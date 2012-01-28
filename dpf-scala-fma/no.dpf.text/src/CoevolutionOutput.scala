package no.dpf.text.coevolution.output;

import no.dpf.text.graph._;
import no.dpf.text.graph.mutable.{Graph=>MGraph}
import no.dpf.text.coevolution._;


trait Output{
  
  protected def toGraph(parent1:AbstractGraph,
		  			    parent2:AbstractGraph,
		  			    typeGraph:AbstractGraph,
		  			    nodes:Set[Id],
		  			    arrows:Set[Id]):AbstractGraph = {
    //Add nodes:
    val rs = new MGraph(typeGraph,()=>sys.error("Programming error"))
    for(n<-nodes){
      n match {
        case sid@SetId(_) => 
          //Build SetId with concat name (names vorher in set tun und dann sort list):
          if(sid.ids.size > 1){
            //TODO
            sys.error("1. Not implemented jet: " + sid.ids)
          }else{
        	  val id = sid.ids.head
        	  var nameOption:Option[String] = null; 
        	  val nodeOption = parent1.getNode(id) match {
        	    case oN@Some(_) => nameOption=parent1.names.get(id); 
        	    				   oN
        	    case None	 =>    nameOption=parent2.names.get(id);
        	    				   parent2.getNode(id)
        	  }
        	  nodeOption match {
        	    case Some(n) => if(n.t == TypeNode.TAttribute()){
        	    				  rs.addVNode(n.id,n.t)
        	    				}else{
        	    				  nameOption match{
        	    				    case Some(name) => rs.addNode(name,n.t,n.id)
        	    				    case None => rs.addNode(n.id.v.toString,n.t,n.id)
        	    				  }
        	    				  
        	    				}
        	    case None	 => sys.error("Programming error")
        	  }
          }
        case n@_		  => sys.error("Programming error")
      }
    }
    for(a<-arrows){
      a match {
        case sid@SetId(_) => 
          //Build SetId with concat name (names vorher in set tun und dann sort list):
          if(sid.ids.size > 1){
            //TODO
            sys.error("2. Not implemented jet: " + sid.ids)
          }else{
        	  val id = sid.ids.head
        	  var nameOption:Option[String] = null; 
        	  val arrowOption = parent1.getArrow(id) match {
        	    case oN@Some(_) => nameOption=parent1.names.get(id); 
        	    				   oN
        	    case None	 =>    nameOption=parent2.names.get(id);
        	    				   parent2.getArrow(id)
        	  }
        	  arrowOption match {
        	    case Some(a) =>	if(a.t == TypeArrow.TAttribute()){
        	    				  rs.addAArrow(nameOption.get,a.sr,a.tg,TypeArrow.TAttribute(),a.id)
        	    				}else{
        	    				  rs.addArrow(nameOption.get,a.sr,a.tg,a.t,a.id)
        	    				}
        	    case None	 => sys.error("Programming error")
        	  }
          }
        case n@_		  => sys.error("Programming error")
      }
    }
    rs
  }
  
  protected def printGraph(g:AbstractGraph,name:String,path:String,printNames:Boolean=true)={
    
    def formatNode(l:List[String],n:Node):List[String]={
    	var rs=l
    	rs="\""::rs
    	rs=getName(n)::rs
    	rs=":"::rs
    	rs=getType(n)::rs
    	rs="\""::rs
    	rs
    }		  
    
    def getName(e:Element):String={
      if(printNames){
	      e.id match{
	        case SId(_) => e.toString()
	        case _ => g.names(e.id).replaceAll("\"","")
	      }
      } else ""    
    }

    def getType(e:Element):String={
      e.t.id match{
        case SId(_) => e.t.toString()
        case _ => g.mmGraph.names(e.t.id);
      }
    }
    
    var rs:List[String] = Nil
    rs="digraph "::rs
    rs=name::rs
    rs="\n{\n"::rs
    rs="graph [nodesep=\"0.7\"];\n"::rs
    rs="node [label=\"\\N\", shape=box];\n"::rs
    for(n:Node<-g.nodes.values.toSet){
      rs=formatNode(rs,n)
   	  rs=";\n"::rs  
    }
    for(a:Arrow<-g.arrows.values.toSet){
      rs=formatNode(rs,a.sr)
   	  rs="->"::rs  
      rs=formatNode(rs,a.tg)
   	  rs=" [label="::rs
   	  rs="\""::rs  
   	  rs=getName(a)::rs
      rs=":"::rs
      rs=getType(a)::rs
   	  rs="\"]"::rs 
   	  rs=";\n"::rs     	    
    }
    rs="}\n"::rs
    rs=rs.reverse
    
	import java.io._
	val fname = path + name + ".dot"
	val writer = new java.io.PrintWriter(fname)
	val mm = new ByteArrayOutputStream()
	try {
		for(s<-rs){
			writer.print(s)
		}
	}catch{
	  case ex => ex.printStackTrace()
	}finally {
		writer.close
	}	
	println("File created: " + fname)
	try {
	    val cmd = "dot -Tpng "+ fname +" -o " + path + name + ".png"
		Runtime.getRuntime().exec(cmd)
	}catch{
	  case ex => ex.printStackTrace()
	}
	
  }
  
  
}