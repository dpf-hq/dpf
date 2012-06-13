package no.hib.dpf.text.output.graphviz;

import no.hib.dpf.text.graph._;
import scala.collection.mutable.{Map=>MMap}
import scala.collection.mutable.{Set=>MSet}

trait Output{ 
 
  private class Helper(g:AbstractGraph,name:String,path:String,printNames:Boolean=true){
    
    def formatNode(l:List[String],n:Node,nl:Boolean):List[String]={
    	var rs=l
    	rs="\""::rs
    	rs=getName(n,true)::rs
    	rs=":"::rs
    	rs=getType(n)::rs
    	rs="\""::rs
    	//With Node label:
    	if(nl){
	    	rs=" [label="::rs
	   	  	rs="\""::rs  
	   	  	rs=format(n,getName(n))::rs
	   	  	rs=":"::rs
	   	  	rs=getType(n)::rs
	   	  	rs="\"]"::rs 
    	}
    	rs
    }	
    def formatArrow(l:List[String],a:Arrow):List[String]={
   	  var rs=l
      rs=formatNode(rs,a.sr,false)
   	  rs="->"::rs  
      rs=formatNode(rs,a.tg,false)
   	  rs=" [label="::rs
   	  rs="\""::rs  
   	  rs=getName(a)::rs
      rs=":"::rs
      rs=getType(a)::rs
   	  rs="\"]"::rs
   	  rs
    }
    def formatArrowForConstraint(l:List[String],a:Arrow):List[String]={
   	  var rs=l
   	  
   	  //Add diamond:
   	  rs="\""::rs
   	  rs=a.id.toString::rs
   	  rs="\""::rs
   	  rs=" [shape=diamond,style=filled,label=\"\",height=.2,width=.2];\n"::rs
   	  
   	  //To diamond
      rs=formatNode(rs,a.sr,false)
   	  rs="->"::rs  
   	  rs="\""::rs
   	  rs=a.id.toString::rs
   	  rs="\""::rs
   	  rs=" [dir=none,weight=2];\n"::rs

   	  //To target node
   	  rs="\""::rs
   	  rs=a.id.toString::rs
   	  rs="\""::rs
   	  rs="->"::rs  
   	  rs=formatNode(rs,a.tg,false)
   	  rs=" [label="::rs
   	  rs="\""::rs  
   	  rs=getName(a)::rs
      rs=":"::rs
      rs=getType(a)::rs
   	  rs="\", weight=1]"::rs
   	  rs
    }
    def formatConstraint(l:List[String],c:Constraint):List[String]={
    	var rs=l

    	//Add Constraint label node
    	rs="\""::rs
    	rs=c.s.id.toString::rs
    	rs="\""::rs

    	//With Node label:
    	rs=" [label="::rs
   	  	rs="\""::rs  
    	rs=c.s.n::rs
    	
    	//Add Parameter
    	rs="("::rs
    	if(0  < c.s.p.size){
    	  rs=c.s.p.head::rs
	      for(p<-c.s.p.tail){
    	   rs=", "::rs
    	   rs=p::rs
	      }
    	}
    	rs=")"::rs
    	rs="\", shape=note, regular=1, style=filled, fillcolor=white]"::rs 
   	  	rs=";\n"::rs 
   	  	
   	   //Add arrows to labelNode
   	   var i = 0	
   	   for(a<-c.as){
   		   //From label node:
   		   rs="\""::rs
   		   rs=c.s.id.toString::rs
    	   rs="\""::rs
	       rs="->"::rs  
	       //To diamond:
	       rs="\""::rs
	       rs=a.id.toString::rs
	       rs="\""::rs
		   rs=" [dir=none,label=\""::rs 
		   rs=i.toString::rs; i+=1 //Label with arrow number in list
		   rs="\"]; \n"::rs   	     
   	   }	
   	   rs
    }	
    
    def getName(e:Element,p:Boolean=printNames):String={
      if(p){
	      e.id match{
	        case SId(_) => e.toString()
	        case _ => g.names.get(e.id) match{
	          			case Some(n) => n
	          			case _		 => e.id.v.toString.replaceAll("\"","")
	        		  }
	      }
      } else ""
    }   
    def format(e:Element,s:String):String={
      //Format String and Char with "" resp. ''  
      e.id match{
        case VString(_) => "\\\"" + s + "\\\""
        case VChar(_) 	=> "\\\'" + s + "\\\'"
        case _			=> s  
      }
    }
    def getType(e:Element):String={
      e.t.id match{
        case SId(_) => e.t.toString()
        case _ => g.mmGraph.names(e.t.id);
      }
    }   
    def writeFile(f:List[String]){
		import java.io._
		val fname = path + name + ".dot"
		val writer = new java.io.PrintWriter(fname)
		val mm = new ByteArrayOutputStream()
		try {
			for(s<-f){
				writer.print(s)
			}
		}catch{
		  case ex => ex.printStackTrace()
		}finally {
			writer.close
		}	
		println("File created: " + fname)
		try {
		    val cmd = "dot -Teps "+ fname +" -o " + path + name + ".eps"
			Runtime.getRuntime().exec(cmd)
		}catch{
		  case ex => ex.printStackTrace()
		}
    }
    
  }
  
  protected def printGraph(g:AbstractGraph,name:String,path:String,printNames:Boolean=true)={
    
    //println("\n\n" + name + " " + g)
 
    val h = new Helper(g,name,path,printNames)
    
    var rs:List[String] = Nil
    rs="digraph "::rs
    rs=name::rs
    rs="\n{\n"::rs
    rs="graph [nodesep=\"0.7\"];\n"::rs
    rs="node [label=\"\\N\", shape=box];\n"::rs

    //Nodes:
    for(n:Node<-g.nodes.values.toSet){
      rs=h.formatNode(rs,n,true)
   	  rs=";\n"::rs  
    }

    //Arrows:
    for(a:Arrow<-g.arrows.values.toSet){
      rs=h.formatArrow(rs,a)
   	  rs=";\n"::rs     	    
    }
    rs="}\n"::rs
    rs=rs.reverse 
    
    h.writeFile(rs)
    
  }


  protected def printSpecification(s:S,name:String,path:String,printNames:Boolean=true)={

    //println("\n\n" + name + " " + g)
    val arrowsWithConstraints = MSet[Id]();
    
    //Get all ids from arrows that have a constraints:
    for(c<-s.cs;a<-c.as){
      arrowsWithConstraints+=a.id
    }
        
    val h = new Helper(s.g,name,path,printNames)
    
    var rs:List[String] = Nil
    rs="digraph "::rs
    rs=name::rs
    rs="\n{\n"::rs
    rs="graph [nodesep=\"0.7\"];\n"::rs
    rs="node [label=\"\\N\", shape=box];\n"::rs
    //Nodes:
    for(n:Node<-s.g.nodes.values.toSet){
      rs=h.formatNode(rs,n,true)
   	  rs=";\n"::rs  
    }
    //Arrows:
    for(a:Arrow<-s.g.arrows.values.toSet){
      if(arrowsWithConstraints contains a.id){
    	rs=h.formatArrowForConstraint(rs,a)        
      }else{
    	rs=h.formatArrow(rs,a)
      }
   	  rs=";\n"::rs     	    
    }
    //Constraints:
    for(c<-s.cs){
      rs=h.formatConstraint(rs,c)
    }
    
    rs="}\n"::rs
    rs=rs.reverse 
    
    h.writeFile(rs)
    
  }
  
  
}