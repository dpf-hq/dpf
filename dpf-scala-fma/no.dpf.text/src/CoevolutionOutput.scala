package no.dpf.text.coevolution.output;

import no.dpf.text.graph._;
import no.dpf.text.graph.mutable.{Graph=>MGraph}
import no.dpf.text.coevolution._;
import scala.collection.mutable.{Set=>MSet}

trait Output{

  /**
   * do some magic
   */
  protected def toGraph(parent1:AbstractGraph,
		  			    parent2:AbstractGraph,
		  			    typeGraph:AbstractGraph,
		  			    typing:Morphism):AbstractGraph = {
 
    //Retrieve values from id
    def filterValues(s:Id):Id={
    	if(s.isInstanceOf[AValue]){
    	  return s
    	}
    	s match{
    	  case setId@SetId(_) => val f = setId.ids.filter(_.isInstanceOf[AValue]).asInstanceOf[Set[AValue]]
    			  				 f.size match {
    			  				 	case 0 => 
    			  				 	  //Add default: 
    			  				 	  if(setId.containsAId){
    			  				 	    setId.ids.head.asInstanceOf[AId].default
    			  				 	  }else{
    			  				 	    sys.error("Programming error! " + s)
    			  				 	  }	
    			  				 	case 1 => f.head
    			  				 	case _ => VSetId(f)
    	  						 } 
    	  case _ => sys.error("Programming error!") 
    	}
    }
    
    //Add nodes:
    val rs = new MGraph(typeGraph,()=>sys.error("Programming error!"))
    for(nId<-typing.domainNodes()){
      nId match {
        case sid@SetId(_) => 
            val names = MSet[Option[String]]();
            for(e<-sid.v){
            	val id = e._1;
            	
            	//Build Name:
        	    parent1.names.get(id) match{
		  			  	case name1@Some(n) =>names+=name1; 
		  			  	case None 	 => parent2.names.get(id) match{
		  			  	  					case name2@Some(n) => names+=name2; 
		  			  	  					case None => /* its a type id */
		  			  	  					  println("No name for: " + id)
		  			  					}		  
            	}
            }
    		//Type node may be wrapped into setId:
    		val nt = typing.codomainNode(nId) match {
    		  case setId@SetId(_) => if(setId.containsAId){
    			  						setId.ids.head
    		  						 }else{
    		  						    setId
    		  						 }
    		  case nId@_		  => nId 				
    		}
    		
        	typeGraph.nodes.get(nt) match {
        	  case None => 
        	    //Only an attribute type:
        	    if(!sid.containsAId){
        	    	sys.error("Node type with id=" + nId + " does not exist! ")
        	    }
        	  case Some(nt) => 
        	    	if(nt.t == TypeNode.TAttribute()){
        	    	  rs.addVNode(filterValues(nId),nt) 
	    			}else{
            	    	var newName = "";
            	    	for(o<-names.toList.sorted){
            	    	  o match{
            	    	    case None => /*do nothing*/
            	    	    case Some(oldN) => newName+=oldN           
            	    	  }
             	    	}
	    			    newName match{
	    				    case "" => rs.addNode("newName",nt,nId);
	    				    case _ =>  rs.addNode(newName,nt,nId);
	    			    }
	    			}
        	}
        case n@_		  => sys.error(" node " + n)
      }
    }
    //Add Arrows:
    for(aId<-typing.domainArrows()){
      aId match {
        case sid@SetId(_) =>
            val names = MSet[Option[String]]();
            if(3 != sid.v.size){
	            for(e<-sid.v){
	            	  val id = e._1;
	            	  parent1.names.get(id) match{
			  			  	case name1@Some(n) =>names+=name1; 
			  			  	case None 	 => parent2.names.get(id) match{
			  			  	  					case name2@Some(n) => names+=name2; 
			  			  	  					case None => /* its a type id */
			  			  	  					  println("No name for: " + id)
			  			  					}		  
	            	  }
	            }
            }else{
			      for(e<-sid.v){
			    	  e._3 match{
			    	    case "uD" => rs.names.get(e._1) match {
			    	    			   case no@Some(_) => names+=no;	
			    	    			   case None => names+=Some(e._1.toString); 	
			    	    			 }
			    	    case "vD" => rs.names.get(e._1) match {
			    	    			   case no@Some(_) => names+=no;	
			    	    			   case None => names+=Some(e._1.toString); 	
			    	    			 }
			    	    case _	  => /*do nothing*/	
			    	  }
			      }
            }
            
    	    //Build Name:
	    	var newName = "";
	    	for(o<-names.toList.sorted){
	    	  o match{
	    	    case None => /*do nothing*/
	    	    case Some(oldN) => newName+=oldN           
	    	  }
 	    	}
	    	val atId = typing.codomainArrow(aId)
	    	if(atId == TypeArrow.TAttribute().id){
			    newName match{
				    case "" => 
				      sys.error("No Name defined!")
				    case _ =>  
				      val tgNode = typing.domainArrowTg(aId) match{
				        case snId@SetId(_) => if(snId.containsAId){
				        						Node(snId.ids.head,TypeNode.TAttribute())	
				        					  }else{
				        					    rs.nodes(snId)
				        					  }   
				        case nId@_ => Node(nId,TypeNode.TAttribute())
				      }
				      println("1")
				      rs.addAArrow(newName,rs.nodes(typing.domainArrowSr(aId)),tgNode,TypeArrow.TAttribute(),aId);
				      println("2")
			    }
        	}else{
 	        	println("5")
	            typeGraph.arrows.get(typing.codomainArrow(aId)) match {
	        	  case None => 
	        	    sys.error("Arrow type with id=" + aId + " does not exist! ")
	        	  case Some(at) =>  
	        	    println("A")
			        //Attribute Id can be wrapped into a SetId:
	        	    if(at == TypeArrow.TAttribute()){
	        	    println("11" + at)
				      val tgNode = typing.domainArrowTg(aId) match{
				        case snId@SetId(_) => if(snId.containsAId){
				        						Node(snId.ids.head,TypeNode.TAttribute())	
				        					  }else{
				        					    rs.nodes(snId)
				        					  }   
				        case nId@_ => rs.nodes(nId)
				      }
			          rs.addAArrow(newName,rs.nodes(typing.domainArrowSr(aId)),tgNode,TypeArrow.TAttribute(),aId);
			        //Add value: 
 	        		}else if(at.t == TypeArrow.TAttribute()){
 	        		    println("B  " + rs.nodes)
 	        			rs.addArrow(newName,rs.nodes(typing.domainArrowSr(aId)),rs.nodes(filterValues(typing.domainArrowTg(aId))),at,aId);
					//Add arrow:
 	        		}else{
 	        		    println("C")
 	        			rs.addArrow(newName,rs.nodes(typing.domainArrowSr(aId)),rs.nodes(typing.domainArrowTg(aId)),at,aId);
 	        		}
	            }	
 	        	println("6")
        	}
        case a@_		  => sys.error("Programming error: arrow " + a)
      }
    }
    rs
  }
  
  protected def printGraph(g:AbstractGraph,name:String,path:String,printNames:Boolean=true)={
    
    //println("\n\n" + name + " " + g)
    
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
	   	  	rs=getName(n)::rs
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
      rs=formatNode(rs,n,true)
   	  rs=";\n"::rs  
    }
    for(a:Arrow<-g.arrows.values.toSet){
      rs=formatNode(rs,a.sr,false)
   	  rs="->"::rs  
      rs=formatNode(rs,a.tg,false)
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
	    val cmd = "dot -Teps "+ fname +" -o " + path + name + ".eps"
		Runtime.getRuntime().exec(cmd)
	}catch{
	  case ex => ex.printStackTrace()
	}
	
  }
  
  
}