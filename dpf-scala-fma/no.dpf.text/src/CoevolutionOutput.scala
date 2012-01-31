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
		  			    arrows:Set[Id],
		  			    sr:Id=>Id,
		  			    tg:Id=>Id):AbstractGraph = {
    
    //Remove SetId from Attribute Types
    def convertId(id:Id):Id={
 		id match{ 
			case s@SetId(_) => 
		  		if(1 == s.v.size){
		  		  s.ids.head match{
		  		    case AId(_) => s.ids.head  //Attribute Node
		  		    case SId(_) => s.ids.head  
 				    case _ => id            	  				  		   
		  		  }
		  		}else id          	  				 
			case _ => id
		}          	  
    }
    
    //Add nodes:
    val rs = new MGraph(typeGraph,()=>sys.error("Programming error 1"))
    for(nId<-nodes){
      nId match {
        case sid@SetId(_) => 
            val typeSet = MSet[Id]() 
            val names = MSet[Option[String]]();
            var attributeFound = false;
            for(e<-sid.v){
            	val id = convertId(e._1);
            	id match{
            	  case AId(_) =>  attributeFound = true/*do nothing */
            	  case _=> 	  val pt = parentLeft.nodes.get(id) match{
            	  			  	case Some(n) =>	names+=parentLeft.names.get(id); Some(n.t.id); 
            	  			  	case None 	 => parentRight.nodes.get(id) match{
            	  			  	  					case Some(n) => names+=parentRight.names.get(id); Some(n.t.id);
            	  			  	  					case None => 	None /* its a type id */	
            	  			  					}
            	  			  }	
            	  			  pt match {
            	  			    case Some(nt) => typeSet+=nt
            	  			    case None	  => /*do nothing*/
            	  			  }	
             	}
            }
            if(!attributeFound && typeSet.isEmpty){
                println(parentLeft.nodes + "\n\n\n" + parentRight.nodes) //104 from type graph?
            	sys.error("Programming error 1b" + sid)
            }
            if(!typeSet.isEmpty){
	        	val t = typeSet.size match {
	        	  case 0 => sys.error("Programming error 3" + sid)
//	        	  case 1 => convertId(typeSet.head)
	        	  case _ => 
	        	    val group = typeGraph.nodes.values.find(n => n.id match{
	        	      				case SetId(_) => true
	        	      				case _ => false
        	    				}
       	    			)
	        	    group match {
	    					 case Some(Node(SetId(v),_)) => 
	    					   		val parentSetIdTriple = v.head
					        	    var setIdSet = MSet[(Id,Int,String)]() 
					        	    for(et<-typeSet){
					        	      val triple = (et, parentSetIdTriple._2, parentSetIdTriple._3)
					        	      setIdSet+= triple
					        	    }
	    					   		SetId(setIdSet)
	    					 case _ => if(1 == typeSet.size){
	    						 			convertId(typeSet.head)
	    					 		   }else{
	    					 		     sys.error("Programming error 4" + typeSet)
	    					 		   }
	    	  		}  
	        	}
	        	val tConverted = t match{
	        	  case s@SetId(_) => if(1 == s.v.size && s.containsAId){
	        		  					s.ids.head
	        	  					 }else{
	        	  					   t
	        	  					 }
	        	  case _ =>			 t
	        	} 
            	typeGraph.nodes.get(tConverted) match {
            	  case None => sys.error("Node type with id=" + tConverted + " does not exist! " + typeGraph.nodes)
            	  case Some(nt) => 
            	    	if(nt.t == TypeNode.TAttribute()){
            	    	  rs.addVNode(nId,nt) //may add concat value
    	    			}else{
	            	    	var newName = "";
	            	    	for(o<-names){
	            	    	  o match{
	            	    	    case None => /*do nothing*/
	            	    	    case Some(oldN) => newName+=oldN           
	            	    	  }
	             	    	}    
		    			    newName match{
		    				    case "" => sys.error("No Name defined!")
		    				    case _ =>  rs.addNode(newName,nt,nId);
		    			    }
    	    			}
            	}
            }
//          }else{
//        	  val id = sid.ids.head
//        	  var nameOption:Option[String] = null; 
//        	  val nodeOption = parentLeft.getNode(id) match {
//        	    case oN@Some(_) => nameOption=parentLeft.names.get(id); 
//        	    				   oN
//        	    case None	 =>    nameOption=parentRight.names.get(id);
//        	    				   parentRight.getNode(id)       	    				   
//        	  }
//        	  nodeOption match {
//        	    case Some(n) => if(n.t == TypeNode.TAttribute()){
//        	    				  rs.addVNode(n.id,n.t)
//        	    				}else{
//        	    				  nameOption match{
//        	    				    case Some(name) => rs.addNode(name,n.t,n.id)
//        	    				    case None => rs.addNode(n.id.v.toString,n.t,n.id)
//        	    				  }
//        	    				  
//        	    				}
//        	    case None	 => sys.error("Programming error")
//        	  }
//          }
        case n@_		  => sys.error("Programming error 5" + n)
      }
    }
    println("Florian100")

//    for(a<-arrows){
//      a match {
//        case sid@SetId(_) => 
//          //Build SetId with concat name (names vorher in set tun und dann sort list):
//          if(sid.ids.size > 1){
//            //TODO
//            sys.error("2. Not implemented jet: " + sid.ids)
//          }else{
//        	  val id = sid.ids.head
//        	  var nameOption:Option[String] = null; 
//        	  val arrowOption = parentLeft.getArrow(id) match {
//        	    case oN@Some(_) => nameOption=parentLeft.names.get(id); 
//        	    				   oN
//        	    case None	 =>    nameOption=parentRight.names.get(id);
//        	    				   parentRight.getArrow(id)
//        	  }
//        	  arrowOption match {
//        	    case Some(a) =>	if(a.t == TypeArrow.TAttribute()){
//        	    				  rs.addAArrow(nameOption.get,a.sr,a.tg,TypeArrow.TAttribute(),a.id)
//        	    				}else{
//        	    				  rs.addArrow(nameOption.get,a.sr,a.tg,a.t,a.id)
//        	    				}
//        	    case None	 => sys.error("Programming error 6" + id)
//        	  }
//          }
//        case n@_		  => sys.error("Programming error 7")
//      }
//    } 
    //Add Arrows:
    for(aId<-arrows){
      aId match {
        case sid@SetId(_) => 
            val typeSet = MSet[Id]() 
            val names = MSet[Option[String]]();
            for(e<-sid.v){
            	val id = convertId(e._1);
            	id match{
            	  case a@SId(2) => sys.error("TEST " + a)
            	  case _=> 	  val pt = parentLeft.arrows.get(id) match{
            	  			  	case Some(a) =>	names+=parentLeft.names.get(id); Some(a.t.id); 
            	  			  	case None 	 => parentRight.arrows.get(id) match{
            	  			  	  					case Some(a) => names+=parentRight.names.get(id); Some(a.t.id);
            	  			  	  					case None => None /* its a type id */
            	  			  					}
            	  			  }	
            	  			  pt match{
            	  			    case Some(at) => typeSet+=at
            	  			    case None 	  => /*do nothing */
            	  			  }
             	}
            }
//            if(!typeSet.isEmpty){ //If typeSet Empty it contains only attribute types
        	val t = typeSet.size match {
        	case 0 => sys.error("Programming error 6" + typeSet)
//        	  case 1 => typeSet.head //convertId(typeSet.head)
        	  case _ => 
	        	    val group = typeGraph.arrows.values.find(n => n.id match{
	        	      				case SetId(_) => true
	        	      				case _ => false
        	    				}
       	    			)
	        	    group match {
	    					 case Some(Arrow(SetId(v),_,_,_)) => 
	    					   		val parentSetIdTriple = v.head
					        	    var setIdSet = MSet[(Id,Int,String)]() 
					        	    for(et<-typeSet){
					        	      val triple = (et, parentSetIdTriple._2, parentSetIdTriple._3)
					        	      setIdSet+= triple
					        	    }
	    					   		SetId(setIdSet)
	    					 case _ => if(1 == typeSet.size){
	    						 			convertId(typeSet.head)
	    					 		   }else{
	    					 		     sys.error("Programming error 7" + typeSet)
	    					 		   }
	        	    }
        	}
        	println(typeSet)
        	
        	//Build Name:
	    	var newName = "";
	    	for(o<-names){
	    	  o match{
	    	    case None => /*do nothing*/
	    	    case Some(oldN) => newName+=oldN           
	    	  }
 	    	}    

	    	if(t  == TypeArrow.TAttribute().id){
			    newName match{
				    case "" => sys.error("No Name defined!")
				    case _ =>  ;println("F1");rs.addAArrow(newName,rs.nodes(sr(aId)),Node(convertId(tg(aId)),TypeNode.TAttribute()),TypeArrow.TAttribute(),aId);println("F2");
			    }
        	}else{
	        	typeGraph.arrows.get(t) match {
	        	  case None => sys.error("Arrow type with id=" + t + " does not exist! " + typeGraph.arrows)
	        	  case Some(at) => 
				    newName match{
					    case "" => sys.error("No Name defined!")
					    case _ =>  println("F3");rs.addArrow(newName,rs.nodes(sr(aId)),rs.nodes(tg(aId)),at,aId);println("F4");
				    }
	           	}
        	}
	    	
//     	}	    	
        
        case n@_		  => sys.error("Programming error 8" + n)
        
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