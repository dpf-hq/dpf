package no.hib.dpf.text.wrapper;

//Scala:
import no.hib.dpf.text.graph.parser.Parser;
import no.hib.dpf.text.graph._
import no.hib.dpf.text.graph.mutable.{Graph=>MGraph}
import no.hib.dpf.text.graph.mutable.{ExtSubGraph=>MExtSubGraph}
import scala.collection.mutable.{Map=>MMap};
import scala.collection.mutable.{Set=>MSet};
//import no.hib.dpf.text.coevolution._
//import no.hib.dpf.text.output.graphviz.Output
//import no.hib.dpf.text.output.parser.{Output=>POutput}
import scala.collection.JavaConversions._;
import scala.collection.mutable.ListBuffer;

//Java:
import no.hib.dpf.text.tdpf.{Specification=>JSpecification}
import no.hib.dpf.text.tdpf.{Node=>JNode}
import no.hib.dpf.text.tdpf.{Arrow=>JArrow}
import no.hib.dpf.text.tdpf.{Arrows=>JArrows}
import no.hib.dpf.text.tdpf.{DpfId=>JId}
import no.hib.dpf.text.tdpf.{DataType=>JDataType}


class Bridge(mmSpec:S, mmName:String) extends Parser(mmSpec, mmName){
 
  /**
   * Read Graph as a whole:
   */
  def read(g:JSpecification)={
      //init:
	  initParser();
	  
	  val mmGraphName = g.getType().getId();
	  
      createGraph(mmGraphName);
      
      for(e <-new IteratorWrapper(g.getGraph().getElements().iterator())){
    	  if(e.isInstanceOf[JArrow]){
    	    
    	    val a=e.asInstanceOf[JArrow];  	    
    	    
    	    //Consume Arrow:
    	    addJArrow(a);
    	    
    	  }
    	  else if(e.isInstanceOf[JArrows]){
    	    var as = e.asInstanceOf[JArrows];
    	    
    	    //Add Linked List of Arrows:
    	    while(null != as.getNext()){
    	      addJArrows(as,as.getNext());
    	      as = as.getNext();
    	    }
    	    
    	    //Add Last Arrow:
     	    addJArrow(as.asInstanceOf[JArrow]);
    	  
    	  }
    	  else if(e.isInstanceOf[JNode]){
    	    val n = e.asInstanceOf[JNode];

    	    //Consume Node:
    	    addJNode(n);
    	    
    	  }
      }
      //Return normalized Graph in List of StringBuffer:
      asList(ListBuffer(serializeGraph(this.curMGraph.normalize(GCtx.gen),"",mmGraphName,""): _*));
  }

  //
  //Nodes:
  //
  
  def addJNode(n:JNode){
    createNode(convertJNode(n));
  }
  
  def convertJNode(a:JNode):RNode={
    val id = a.getId();
    val t = a.getType();
    createRNode(id.getName(),jId2RId(id),t.getName(),jId2RId(t));
  }

  //
  //Arrows:
  //
  
  def addJArrow(a:JArrow)={
    //
    //Find out which kind of arrow:
    //
    val id = a.getId();
    val t = a.getType();
    if(null != a.getTgNode()){
		createArrow(createRArrow(id.getName(),jId2RId(id),convertJNode(a.getSr()),convertJNode(a.getTgNode()),t.getName(),jId2RId(t)));  
    }else if(null != a.getTgValue()){
    	createArrow(createRAttributeValue(id.getName(),jId2RId(id),convertJNode(a.getSr()),a.getTgValue().getValue(),t.getName(),jId2RId(t)))
    }else{
      //Is is an AttributeType:
      val at = a.getTgDataType() match {
      	case  JDataType.TBOOLEAN => TypeP.TBoolean 
      	case  JDataType.TCHAR 	 => TypeP.TChar 
      	case  JDataType.TBYTE	 => TypeP.TByte 
      	case  JDataType.TSHORT	 => TypeP.TShort 
      	case  JDataType.TINT 	 => TypeP.TInt 
      	case  JDataType.TLONG 	 => TypeP.TLong 
      	case  JDataType.TFLOAT 	 => TypeP.TFloat 
      	case  JDataType.TDOUBLE  => TypeP.TDouble
      	case  JDataType.TSTRING  => TypeP.TString
      	case _ => sys.error("Datatype Error!");
      }
      	createArrow(createRAttributeType(id.getName(),jId2RId(id),convertJNode(a.getSr()),at,"*"))
    }
  }
  
  def addJArrows(a:JArrows, next:JArrows)={
    val id = a.getId();
    val t = a.getType();
	createArrow(createRArrow(id.getName(),jId2RId(id),convertJNode(a.getSr()),convertJNode(next.getSr()),t.getName(),jId2RId(t)));  
  }
  
  //
  //Helper:
  //
  
  private class IteratorWrapper[A](iter:java.util.Iterator[A]){
	    def foreach(f: A => Unit): Unit = {
	        while(iter.hasNext){
	          f(iter.next)
	        }
	    }
	}
  
  private  def jId2RId(d:JId):Option[Id]={
     if(d.getId() > -1){
       Some(RId(d.getId()));
     }else{
       None
     } 
   } 
   
}