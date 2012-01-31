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
            	  case _=> 	  val pt = parent1.nodes.get(id) match{
            	  			  	case Some(n) =>	names+=parent1.names.get(id); Some(n.t.id); 
            	  			  	case None 	 => parent2.nodes.get(id) match{
            	  			  	  					case Some(n) => names+=parent2.names.get(id); Some(n.t.id);
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
              if(1 == sid.v.size){
            	  sid.v.head._3 match{
            	    case "A" => //Value from Pullback complement
            	      			sid.v.head._1 match{
            	      			  	case s@SetId(_) => if(!s.containsAId){
            	      			  							typeSet+=sid.v.head._1
            	      			  					   } 
            	      				case _ => typeSet+=sid.v.head._1
            	      			}
            	    case _ =>   println(parent1.nodes)
            	      			println(parent2.nodes)
            	      			sys.error("Programming error 1b " + sid) 
            	  }
              }	else{	
            	  sys.error("Programming error 1c " + sid)
              }
            }
            if(!typeSet.isEmpty){
	        	val t = typeSet.size match {
	        	  case 0 => sys.error("Programming error 3" + sid)
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
		    				    case "" => rs.addNode("newName",nt,nId);
		    				    case _ =>  rs.addNode(newName,nt,nId);
		    			    }
    	    			}
            	}
            }
        case n@_		  => sys.error("Programming error 5" + n)
      }
    }
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
            	  case _=> 	  val pt = parent1.arrows.get(id) match{
            	  			  	case Some(a) =>	names+=parent1.names.get(id); Some(a.t.id); 
            	  			  	case None 	 => parent2.arrows.get(id) match{
            	  			  	  					case Some(a) => names+=parent2.names.get(id); Some(a.t.id);
            	  			  	  					case None => None /* its a type id */
            	  			  					}
            	  			  }	
            	  			  pt match{
            	  			    case Some(at) => typeSet+=at
            	  			    case None 	  => /*do nothing */
            	  			  }
             	}
            }
            if(0 == typeSet.size && 3 == sid.v.size){
                  //Value from Pullback complement
                  var found_A = false;
                  var found_uD = false;
                  var found_vD = false;
                  for(e<-sid.v){
	            	  e._3 match{
	            	    case "A" => found_A=true;
	            	    			typeSet+=sid.v.head._1  
	            	    case "uD" => found_uD=true;
	            	    			 val convertedId = convertId(e._1) 	
	            	    			 rs.names.get(convertedId) match {
	            	    			   case no@Some(_) => names+=no;	
	            	    			   case None => names+=Some(convertedId.toString()); 	
	            	    			 }
	            	    case "vD" => found_vD=true;
	            	    			 val convertedId = convertId(e._1) 	
	            	    			 rs.names.get(convertedId) match {
	            	    			   case no@Some(_) => names+=no;	
	            	    			   case None => names+=Some(convertedId.toString()); 	
	            	    			 }
	            	    case _ => sys.error("Programming error 1e " + sid) 
	            	  }
                  }
                  if(!(found_A && found_uD && found_vD)){
                	  sys.error("Programming error 1f " + sid)
                  }
            }	
            val t = typeSet.size match {
        		case 0 => sys.error("Programming error 7" + typeSet)
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
        	//Build Name:
	    	var newName = "";
	    	for(o<-names){
	    	  o match{
	    	    case None => /*do nothing*/
	    	    case Some(oldN) => newName+=oldN           
	    	  }
 	    	}   
//	    	println(t)
	    	if(t == TypeArrow.TAttribute().id){
			    newName match{
				    case "" => sys.error("No Name defined!")
				    case _ => 
				      println("1");  
				      rs.addAArrow(newName,rs.nodes(sr(aId)),Node(convertId(tg(aId)),TypeNode.TAttribute()),TypeArrow.TAttribute(),aId);
				      println("2");
			    }
        	}else{
	        	typeGraph.arrows.get(t) match {
	        	  case None => sys.error("Arrow type with id=" + t + " does not exist! " + typeGraph.arrows)
	        	  case Some(at) => 
				    newName match{
					    case "" => sys.error("No Name defined!")
					    case _ =>  
	  				      if(at.t == TypeArrow.TAttribute()){
	  				    	  println("31" + at);
	  				    	  rs.addAArrow(newName,rs.nodes(sr(aId)),Node(convertId(tg(aId)),TypeNode.TAttribute()),TypeArrow.TAttribute(),aId);
	  				    	  println("32" + at);
	  				      }else{
	  				    	  println("33" + at);
	  				    	  rs.addArrow(newName,rs.nodes(sr(aId)),rs.nodes(tg(aId)),at,aId);
	  				    	  println("34" + at);
	  				      }
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
    
    //println("\n\n" + name + " " + g)
    
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