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
    
    /**
     *Remove SetId from Attribute Types and Special Ids 
     */
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
    val rs = new MGraph(typeGraph,()=>sys.error("Programming error!"))
    for(nId<-typing.domainNodes()){
      nId match {
        case sid@SetId(_) => 
            val names = MSet[Option[String]]();
            var attributeFound = false;
            if(sid.containsAId){
              attributeFound = true;
            }else{
	            for(e<-sid.v){
	            	val id = e._1;
	            	
	            	//Build Name:
	            	parent1.nodes.get(id) match{
		  			  	case Some(n) =>	names+=parent1.names.get(id); 
		  			  	case None 	 => parent2.nodes.get(id) match{
		  			  	  					case Some(n) => names+=parent2.names.get(id); 
		  			  	  					case None => /* its a type id */
		  			  					}		  
					}
	            }
            }
            //Add node:
            if(!attributeFound){
		        	typeGraph.nodes.get(typing.codomainNode(nId)) match {
	            	  case None => 
	            	    sys.error("Node type with id=" + nId + " does not exist! ")
	            	  case Some(nt) => 
	            	    	if(nt.t == TypeNode.TAttribute()){
	            	    	  rs.addVNode(nId,nt) 
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
            }
        case n@_		  => sys.error(" node " + n)
      }
    }
    //Add Arrows:
    for(aId<-typing.domainArrows()){
      aId match {
        case sid@SetId(_) =>
          	println(sid)
            val names = MSet[Option[String]]();
            if(3 != sid.v.size){
	            for(e<-sid.v){
	            	val id = e._1;
	            	
	            	//Build Name:
	            	parent1.nodes.get(id) match{
		  			  	case Some(n) =>	names+=parent1.names.get(id); 
		  			  	case None 	 => parent2.nodes.get(id) match{
		  			  	  					case Some(n) => names+=parent2.names.get(id); 
		  			  	  					case None => /* its a type id */
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
            
        	typeGraph.arrows.get(typing.codomainArrow(aId)) match {
        	  case None => 
        	    sys.error("Node type with id=" + sid + " does not exist! ")
        	  case Some(a) =>  
        	    
        	    //Build Name:
    	    	var newName = "";
    	    	for(o<-names.toList.sorted){
    	    	  o match{
    	    	    case None => /*do nothing*/
    	    	    case Some(oldN) => newName+=oldN           
    	    	  }
     	    	}
        	    
        	    //Add arrow:
		    	if(a.id == TypeArrow.TAttribute().id){
				    newName match{
					    case "" => sys.error("No Name defined!")
					    case _ => 
					      rs.addAArrow(newName,rs.nodes(typing.domainArrowSr(aId)),rs.nodes(typing.domainArrowTg(aId)),TypeArrow.TAttribute(),aId);
				    }
	        	}else{
  				    	  rs.addArrow(newName,rs.nodes(typing.domainArrowSr(aId)),rs.nodes(typing.domainArrowTg(aId)),a,aId);
	        	}
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