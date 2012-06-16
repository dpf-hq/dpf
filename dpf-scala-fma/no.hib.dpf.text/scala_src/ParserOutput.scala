package no.hib.dpf.text.output.parser;

import no.hib.dpf.text.graph._;
import scala.collection.mutable.{Map=>MMap}
import scala.collection.mutable.{Set=>MSet}

trait Output{ 
 
 private class Helper(g:AbstractGraph,name:String,path:String){
    
    def formatNode(n:Node):String={
        n match{
          //Value ["Hallo"]:
          case Node(id, Node(_,TypeNode.TAttribute())) => formatValue(id) 
           //Attribute:
          case Node(id,TypeNode.TAttribute()) => id.toString()
          //Default:
          case _ => 
            var rs:List[String]=Nil
            rs=getName(n)::rs
            rs=":"::rs
            rs=getType(n)::rs
          	rs.reverse.mkString
        }    	
    }
    
     def getName(e:Element):String={
	      e.id match{
	        case SetId(_,_) => sys.error("Graph have to be normalized first!")
	        case _ => g.names.get(e.id) match{
	          			case Some(n) => n + "@" + e.id.v
	          			case _		 => sys.error("(1) Name is missing!" + e)
	        		  }
	      }
      }

     def getType(e:Element):String={
	      e.id match{
	        case SetId(_,_) => sys.error("Graph have to be normalized first!")
	        case _ => g.mmGraph.names.get(e.t.id) match{
	          			case Some(n) => 
	          			  		e.t.id match {
	          			  		  case RId(v) =>  n + "@" + e.t.id.v
	          			  		  case _ => n
	          			  		}
	          			case _		 => sys.error("(2) Name is missing!" + e)
	        		  }
	      }
      }
    
     def formatValue(id:Id):String={
//      //Format String and Char with "" resp. ''  
//      val rs = id match{
//        case VString(v) => "\"" + v + "\""
//        case VChar(v) 	=> "\'" + v + "\'"
//        case id@_		=> id.v.toString()  
//      }
      "[" + id.v.toString() + "]"
    }
    
    def formatArrow(a:Arrow):String={
   	  var rs:List[String]=Nil
      rs=formatNode(a.sr)::rs
   	  rs="-"::rs  
      rs=getName(a)::rs
      rs=":"::rs
      a match{
          case Arrow(_,_,_,TypeArrow.TAttribute()) => 
              rs="*"::rs
          case _ =>  
		      rs=getType(a)::rs
      }
      rs="->"::rs  
      rs=formatNode(a.tg)::rs
   	  rs.reverse.mkString
    }
    
    def writeFile(f:List[String]){
		import java.io._
		val fname = path + "Output" + name + ".tdpf"
		val writer = new java.io.PrintWriter(fname)
		val mm = new ByteArrayOutputStream()
		try {
			for(s<-f){
				writer.append(s)
			}
		}catch{
		  case ex => ex.printStackTrace()
		}finally {
			writer.close
		}	
    }
    
  }
  
 /**
  * Serialize Graph into the same representation as they are stored in a file. 
  */
  protected def serializeGraph(g:AbstractGraph,name:String,mmName:String,path:String):List[String]={
    
    //println("\n\n" + name + " " + g)
 
    val h = new Helper(g,name,path)    
    var rs:List[String] = Nil
 
    rs=name::rs
    rs=":=TGraph<"::rs
    rs=mmName::rs
    rs=">{\n"::rs

    //Nodes:
    for(n:Node<-g.nodes.values.toSet.toList.reverse){
      if(g.arrowsIn(n).isEmpty && g.arrowsOut(n).isEmpty){/*Node will not be printed by arrow*/
          rs="   "::rs
    	  rs=h.formatNode(n)::rs
    	  rs=",\n"::rs  
      }	  
    }

    //Arrows:
    for(a:Arrow<-g.arrows.values.toSet.toList.reverse){
      rs="   "::rs
      rs=h.formatArrow(a)::rs
   	  rs=",\n"::rs     	    
    }
    
    rs=" }\n"::rs
    rs=rs.reverse 
    
    //Save:
    if(!path.isEmpty() && !name.isEmpty()){
      h.writeFile(rs)      
    }
    
    //Return Result:
    rs;
  }
    
}