package no.dpf.text.graph.validation

import no.dpf.text.graph._
import no.dpf.text.graph.ecore._

import scala.collection._
import scala.collection.mutable.{Map=>MMap}
import scala.xml._	  
import no.dpf.text.graph.{Element=>DElement}
import no.dpf.text.graph.{Node=>DNode}
import no.dpf.text.graph.{Arrow=>DArrow}


class SimpleGraph private[validation](namesMap:Map[Id,String]) extends no.dpf.text.graph.mutable.Graph(null,null) with Converter{
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
    * Attention algortihms must correspond to method in Graph.scala 
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

package dresden{
object Validation extends Helper{
	def validate(is:IS){
		
		validateShapes(is)	  
		
		import java.io._

		val mm = new ByteArrayOutputStream()
		val writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(mm)));
  	    try {
	      writer.print(createValModel(is))
	    }finally {
	      writer.close
	    }	    
	    
	    //val path = "/home/hyperion/scala/workspace_scala/tudresden.ocl20.pivot.standalone.example/bin/"
	    val prog = "oclchecker.jar"  
      	val processBuilder = new ProcessBuilder("java","-jar",prog,new String(mm.toByteArray))
	    processBuilder.redirectErrorStream(true)
        val proc = processBuilder.start()
        val i = new scala.io.BufferedSource(proc.getInputStream())
		for(s<-i)print(s)  

	    //println("Hallo")
	}
  
  def createValModel(is:IS): xml.Elem={
    <validationmodel>
		{
		  graph2ClassModel(is.mm.g)
		}{ 
		var i = 0;  
		for(e<-createValidationParts(is)) yield
		<constraint oclString={e._1}>  
			{i=i+1}
			{graph2ObjectModel(e._2,i.toString)}
		</constraint>
		}
	</validationmodel>	  
  }
	
  def graph2ClassModel(g:AbstractGraph): xml.Elem={   
    val nodesWithoutValues = g.nodes.values.filter(_  match {case DNode(_, DNode(_,TypeNode.TAttribute())) => false;case _ => true})
    <classmodel>
    	{
        //Model Value Class:	
        <class className="no.dpf.text.validation.temp.Value">
    	package no.dpf.text.validation.temp;
        public class Value{{
    		final public Object value;
    		public Value(Object v){{value=v;}}
    		public int hashCode(){{
    		  if(null == value)return 0; else return value.hashCode(); 
    		}}
    		public boolean equals(Object o){{
    		  try{{	
    		  Value v = (Value)o;	
    		  if(null != value &amp;&amp; null != v.value)return value.equals(v.value); else return false;
    		  }}catch(Exception e){{return false;}}
    		}}
     	}}
        </class>
    	}
    	{
        for(n<-nodesWithoutValues) yield
    	<class className={"no.dpf.text.validation.temp."+n.id}>
    	package no.dpf.text.validation.temp;
        import java.util.LinkedList;
    	import java.util.List;
 		public class {n.id.toString}{{
        	{
         	//Incoming arrows:
        	//for(a<-g.arrowsIn(n)) yield	
 			//<in>public List in{a.id}s = new LinkedList();</in>.text
         	}
        	{
			//Outgoing arrows:
        	for(a<-g.arrowsOut(n).filter(_ match {
        	  case DArrow(_,_,_,DArrow(_,_,_,TypeArrow.TAttribute())) => false; //without value arrows
        	  case _ => true})) yield	
			<out>public List out{a.id}s = new LinkedList();</out>.text
         	}
		}}
    	</class>
    	}{
        //Model Provider class:	
        <class className="no.dpf.text.validation.temp.ModelProviderClass">	
    	package no.dpf.text.validation.temp;
        public class ModelProviderClass {{
    		   public Value value;
        {	
        for(n<-nodesWithoutValues) yield  
        	<c>public {n.id.toString} {n.id.toString.toLowerCase};</c>.text
        }
        }}
        </class>
    	}
    </classmodel>
  }
  
  def graph2ObjectModel(g:AbstractGraph, namePostfix:String): xml.Elem={
    def toJavaValue(id:Id)= id match {
      case v:VByte => "((byte)"+v.v+")"
      case v:VChar => "'" + v.v.toString.replaceAllLiterally("'","\\'") + "'"
      case v:VFloat => v.v.toString + "f" 
      case v:VString => "\""+ v.v.substring(1,v.v.length-2).replaceAllLiterally("\"","\\\"") + "\""
      case v:AValue => v.v
      case _ => sys.error("Programming error!")
    }
    val nodes = g.nodes.values.filter(_  
        match { case DNode(_, TypeNode.TAttribute()) => false 		   //no attributes
        		case DNode(_, DNode(_,TypeNode.TAttribute())) => false //no values
         		case _ => true}
    )
    val arrows= g.arrows.values.filter(_ 
        match { case DArrow(_,_,_,TypeArrow.TAttribute()) => false; 			  //no attributes
        		case DArrow(_,_,_,DArrow(_,_,_,TypeArrow.TAttribute())) => false; //no values
        		case _ => true}
    )
    val values= g.arrows.values.filter(_ 
        match { case DArrow(_,_,_,DArrow(_,_,_,TypeArrow.TAttribute())) => true; //no values
        		case _ => false}
    )
    <objectmodel>
    	<class className={"no.dpf.text.validation.temp.ModelInstanceProviderClass"+namePostfix}>
    	package no.dpf.text.validation.temp;
        import java.util.LinkedList;
    	import java.util.List;
    	import no.dpf.text.validation.ocl.dresden.ModelInstanceProvider;
    	public class ModelInstanceProviderClass{namePostfix} implements ModelInstanceProvider{{
    	public List getModelObjects() {{
		List result = new LinkedList();
    		{
    		//Add classes:
	        for(n<-nodes) yield
	    		<s>
	        	{n.t.id.toString} {n.id.toString.toLowerCase} = new {n.t.id.toString}();
	        	result.add({n.id.toString.toLowerCase});
	        	</s>.text
    		}{
    		//Link classes:
    		for(a<-arrows) yield
	    		<s>
    			{a.sr.id.toString.toLowerCase}.out{a.t.id}s.add({a.tg.id.toString.toLowerCase});
    			{
    			//{a.tg.id.toString.toLowerCase}.in{a.t.id}s.add({a.sr.id.toString.toLowerCase});
    			}
    			</s>.text
    		}{
    		//Add values:
    		for(a<-values) yield
	    		<s>
    			{a.sr.id.toString.toLowerCase}.out{a.t.id}s.add(new Value({toJavaValue(a.tg.id)}));
    			</s>.text
    		}
			return result;
    		}}
    	}}
    	</class>
    </objectmodel>    
  }
}
}