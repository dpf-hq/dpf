package no.hib.dpf.text.graph.validation

import no.hib.dpf.text.graph._
import no.hib.dpf.text.graph.ecore._

import scala.collection._
import scala.collection.mutable.{Map=>MMap}
import scala.xml._	  
import no.hib.dpf.text.graph.{Element=>DElement}
import no.hib.dpf.text.graph.{Node=>DNode}
import no.hib.dpf.text.graph.{Arrow=>DArrow}

/**
 * SimpleGraph is usual graph but it is created without doing all the checks which usually are needed. 
 * It is used only in the validation package with input graphs which have been already validated before.
 */
class SimpleGraph private[validation](namesMap:Map[Id,String]) extends no.hib.dpf.text.graph.mutable.Graph(null,null) with Converter{
	import scala.collection._;
	
	//Add all names:
	names++=namesMap
	
	def addArrow(a:DArrow)={		
		//Add nodes and arrows only by arrows without any validation (ATTENTION):
		nodes+= a.sr.id -> a.sr
		nodes+= a.tg.id -> a.tg
		update(a,a.sr,out)	//Add out arrows
		update(a,a.tg,in)   //Add in arrows		
		arrows+= a.id -> a;
	}		
	override def toString="SimpleGraph(\n" + arrows.toString() + "\n)";
}


trait Helper{
  
  /**
   * Create Tuples with pullbacks for each predicate and concrete OCL expression
   */
  def createValidationParts(is:IS):List[(String,AbstractGraph)]={
    val cs:Set[Constraint] = is.mm.cs
    val g:AbstractGraph = is.m.g 
    val pSem:Map[Id,Validator] = is.pSem 
    var ret:List[(String,AbstractGraph)] = Nil
    for(c<-cs){
      
   	  //Pullback Arrows:
      val temp = new SimpleGraph(g.names)
      for(a<-g.iteratorArrows){
	    	if(c.as.exists(x => x.id == a.t.id)){
	    	  temp.addArrow(a)
	    	}
	  }
      //Build OCL:
	  val vali = pSem(c.s.id)
      ret=((fillOcl(c,vali),temp)::ret)
    }
   	//println(ret);
    ret
  } 
  
  /**
   * Fill OCL template with values so that it becomes a valid concrete OCL expression
   */
  def fillOcl(c:Constraint,v:Validator)={
      
	  var oclList:List[String]=Nil
	  for(o<-v.ocl){
		o match {
		  case OclString(e) => oclList=(e::oclList) 
		  case OclChar(e)   => oclList=(e.toString()::oclList)
		  case OclPe(e)		=> v.nodeVars.get(e) match {
		    					 case Some(pos) => oclList=(c.nodeByNo(pos).id.toString()::oclList)	
		    					 case None 		=>
			    					v.arrowVars.get(e) match {
			    					 case Some(pos) => oclList=(c.arrowByNo(pos).id.toString()::oclList)	
			    					 case None 		=> sys.error("Variable " + e + " is not specified!")
			  					   }   
		  					   }
		  case OclPp(e)		=> oclList=(c.paramByNo(e)::oclList)
		}
	  }  
    
	  oclList.reverse.mkString
  }
  
  
    /**
	* Translate the shape into a presentation which is unique for a shape only. Ids are normalized 
	* to "virtual ids" starting from zero. Hence two shapes are equal if they have the same list of arrows.
    * Attention: algortihm must correspond to method in Graph.scala 
    */
   private def createShape(arrows:List[Arrow]):List[Arrow]={
     var counter=0;
	 val virtualIds = MMap[Id,VId]()
	 def getId(s:Id):VId={
	   if(virtualIds.contains(s)){
	     virtualIds(s)
	   }else{
	     counter+=1
		 virtualIds+=s->VId(counter) 
		 getId(s)
	   }
	 }
	 val r = for(a<-arrows)yield{
		 a match {
	     case Arrow(id,DNode(id1,t1),DNode(id2,t2),ty) => Arrow(getId(id),DNode(getId(id1),t1),DNode(getId(id2),t2),ty)
	     case _ => sys.error("Programming Error")
	     }	
	 }
//     println(arrows)
//     println(r)
     r
   }
  
   /**
    * Validate if constraint predicate is correctly put on the graph. Therefore its validator must be defined on the 
    * the same shape the predicate was added to the graph. 
    */
   def validateShapes(is:IS)={
     for(c<-is.mm.cs){
		  
    	  val shapeConstraint = createShape(c.as)
		  val shapeValidator  = is.pSem(c.s.id).shape
		  
		  def printError =  sys.error("Shapes do not fit to" + shapeConstraint + " <> " + shapeValidator)

		  if(shapeConstraint.length==shapeValidator.length){
		    for(i <-0 to shapeConstraint.length-1){
		        val a = shapeConstraint(i)
		    	shapeValidator(i) match {
		    	  case DArrow(_,DNode(_,t1),DNode(_,t2),ty) =>
		    	    if((a.t == ty || ty == TypeArrow.TJoker()) &&
		    	       (a.sr.t==t1 || t1 == TypeNode.TJoker()) &&
		    	       (a.tg.t==t2 || t2 == TypeNode.TJoker())){
		    	      //OK
		    	    }else{
		    	      printError
		    	    }
		    	  case _ => sys.error("Programming Error")
		    	}
		    }
		    
		  }else{ 
		    printError
		  }
		}
   }
}