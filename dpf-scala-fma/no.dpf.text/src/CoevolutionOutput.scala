package no.dpf.text.coevolution.output;

import no.dpf.text.graph._;
import no.dpf.text.graph.mutable.{Graph=>MGraph}
import no.dpf.text.coevolution._;
import scala.collection.mutable.{Set=>MSet}

trait Output{
  
  protected def toGraph(parentLeft:AbstractGraph,
		  			    parentRight:AbstractGraph,
		  			    typeGraph:AbstractGraph,
		  			    nodes:Set[Id],
		  			    arrows:Set[Id]):AbstractGraph = {
    //Add nodes:
    val rs = new MGraph(typeGraph,()=>sys.error("Programming error"))
    for(nId<-nodes){
      nId match {
        case sid@SetId(_) => 
          if(sid.ids.size > 1){
            val typeSet = MSet[Id]() 
            val names = MSet[Option[String]]();
            for(e<-sid.v){
            	val pt = e._3 match{
            	  case "L" => names+=parentLeft.names.get(e._1);parentLeft.nodes(e._1).t.id
            	  case "R" => names+=parentRight.names.get(e._1);parentRight.nodes(e._1).t.id
              	  case _ =>  sys.error("1. Not implemented jet: " + sid)
            	} 
            	typeSet+=pt
            	val t = typeSet.size match {
            	  case 0 => sys.error("Programming error")
            	  case 1 => typeSet.head
            	  case _ => val parentSetIdTriple = typeGraph.nodes.head._2.id match {
            	    					 case s@SetId(_) => s.v.head
            	    					 case _ => sys.error("Programming error")
            	  					   }
            	    var setIdSet = MSet[(Id,Int,String)]() 
            	    for(et<-typeSet){
            	      val triple = (et, parentSetIdTriple._2, parentSetIdTriple._3)
            	      setIdSet+= triple
            	    }
            	    SetId(setIdSet)
            	}
            	typeGraph.nodes.get(t) match {
            	  case None => sys.error("Type with id=" + t + " does not exist!")
            	  case Some(nt) => 
            	    	var newName = "";
            	    	for(o<-names){
            	    	  o match{
            	    	    case None => /*do nothing*/
            	    	    case Some(oldN) => newName+=oldN           
            	    	  }
             	    	}    
            	    	if(nt == TypeNode.TAttribute()){
		    			  rs.addVNode(nId,nt)
		    			}else{
		    			  newName match{
		    				    case "" => println("FLO1");rs.addNode(nId.v.toString,nt,nId);println("FLO2");
		    				    case _ =>  println("FLO3");rs.addNode(newName,nt,nId);println("FLO4");
		    			  }
        	    		}
            	}
            }
          }else{
        	  val id = sid.ids.head
        	  var nameOption:Option[String] = null; 
        	  val nodeOption = parentLeft.getNode(id) match {
        	    case oN@Some(_) => nameOption=parentLeft.names.get(id); 
        	    				   oN
        	    case None	 =>    nameOption=parentRight.names.get(id);
        	    				   parentRight.getNode(id)       	    				   
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
        	  val arrowOption = parentLeft.getArrow(id) match {
        	    case oN@Some(_) => nameOption=parentLeft.names.get(id); 
        	    				   oN
        	    case None	 =>    nameOption=parentRight.names.get(id);
        	    				   parentRight.getArrow(id)
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