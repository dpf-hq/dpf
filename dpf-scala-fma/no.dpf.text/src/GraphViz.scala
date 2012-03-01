package no.dpf.text.output.graphviz;

import no.dpf.text.graph._;
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
    	//With Node lable:
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
    for(n:Node<-g.nodes.values.toSet){
      rs=h.formatNode(rs,n,true)
   	  rs=";\n"::rs  
    }
    for(a:Arrow<-g.arrows.values.toSet){
      rs=h.formatNode(rs,a.sr,false)
   	  rs="->"::rs  
      rs=h.formatNode(rs,a.tg,false)
   	  rs=" [label="::rs
   	  rs="\""::rs  
   	  rs=h.getName(a)::rs
      rs=":"::rs
      rs=h.getType(a)::rs
   	  rs="\"]"::rs 
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
    for(n:Node<-s.g.nodes.values.toSet){
      rs=h.formatNode(rs,n,true)
   	  rs=";\n"::rs  
    }
    for(a:Arrow<-s.g.arrows.values.toSet){
      rs=h.formatNode(rs,a.sr,false)
   	  rs="->"::rs  
      rs=h.formatNode(rs,a.tg,false)
   	  rs=" [label="::rs
   	  rs="\""::rs  
   	  rs=h.getName(a)::rs
      rs=":"::rs
      rs=h.getType(a)::rs
   	  rs="\"]"::rs 
   	  rs=";\n"::rs     	    
    }
    rs="}\n"::rs
    rs=rs.reverse 
    
    h.writeFile(rs)
    
  }
  
  
}