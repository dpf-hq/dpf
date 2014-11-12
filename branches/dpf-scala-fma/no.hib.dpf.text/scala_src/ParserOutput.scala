package no.hib.dpf.text.output.parser;

import no.hib.dpf.text.graph._;
import scala.collection.mutable.{Map=>MMap}
import scala.collection.mutable.{Set=>MSet}

trait Output{ 
 
 private class Helper(s:S,name:String,path:String){
    
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
	        case _ => s.g.names.get(e.id) match{
	          			case Some(n) => n + "@" + e.id.v
	          			case _		 => sys.error("(1) Name is missing!" + e)
	        		  }
	      }
      }

     def getType(e:Element):String={
	      e.id match{
	        case SetId(_,_) => sys.error("Graph have to be normalized first!")
	        case _ => s.g.mmGraph.names.get(e.t.id) match{
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
      "[\"" + id.v.toString() + "\"]"
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
  protected def serializeSpecification(
      s:S,
      name:String,
      mmName:String,
      sequenceNo:Long,
      path:String, 
      sigName:Option[String]=None):List[String]={
    
    //println("\n\n" + name + " " + g)
 
    val h = new Helper(s,name,path)    
    var rs:List[String] = Nil
 
    //Specification Header:
    rs="Specification:"::rs
    sigName match {
      case None		 		     => rs=mmName::rs
      case Some(signatureName)  =>
        	rs="("::rs
        	rs=mmName::rs
        	rs=" ,"::rs
        	rs=signatureName::rs
        	rs=")"::rs
    }
    rs="<"::rs
    rs=sequenceNo.toString()::rs
    rs="> {\n"::rs
    
    //Graph:
    rs=" Graph {\n"::rs

    //Nodes:
    var first = true;
    for(n:Node<-s.g.nodes.values.toSet){
      if(s.g.arrowsIn(n).isEmpty && s.g.arrowsOut(n).isEmpty){/*Node will not be printed by arrow*/
    	  if(!first){rs=",\n"::rs}else{first=false}  
          rs="   "::rs
    	  rs=h.formatNode(n)::rs
      }	  
    }

    //Arrows:
    for(a:Arrow<-s.g.arrows.values.toSet){
   	  if(!first){rs=",\n"::rs}else{first=false}  
      rs="   "::rs
      rs=h.formatArrow(a)::rs
    }
    
    rs="\n }\n"::rs
    rs=" Constraints"::rs
    rs=" {\n"::rs
    
    //Constraints:
    first = true;
    for(c:Constraint<-s.cs){
      
   	  if(!first){rs=",\n"::rs}else{first=false}  
      rs="   "::rs
      
      //Signature:
      rs=c.s.n::rs      
      rs="("::rs
      var first2 = true
      for(p:String<-c.s.ps){
    	if(!first2){rs=", "::rs}else{first=false}  
        rs="\""::rs
        rs=p::rs
        rs="\""::rs
      }
      rs=")"::rs      

      //Arrows:
      first2 = true
      rs="{"::rs
      for(a:Arrow<-c.as){
    	if(!first2){rs=", "::rs}else{first=false}
    	rs=h.formatArrow(a)::rs
      }
      rs="}"::rs
    }
    
    rs="\n }\n"::rs
    rs="}\n"::rs
    rs=rs.reverse 
    
    //Save:
    if(!path.isEmpty() && !name.isEmpty()){
      h.writeFile(rs)      
    }
    
    //Return Result:
    rs;
  }
    
}