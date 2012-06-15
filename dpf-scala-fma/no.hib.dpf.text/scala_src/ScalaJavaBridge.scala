package no.hib.dpf.text.graph.parser;
import no.hib.dpf.text.graph._
import no.hib.dpf.text.graph.mutable.{Graph=>MGraph}
import no.hib.dpf.text.graph.mutable.{ExtSubGraph=>MExtSubGraph}
import scala.collection.mutable.{Map=>MMap}
import scala.collection.mutable.{Set=>MSet}
import no.hib.dpf.text.coevolution._
import no.hib.dpf.text.output.graphviz.Output
import no.hib.dpf.text.output.parser.{Output=>POutput}

//Java:
import no.hib.dpf.text.tdpf.{TGraph=>JGraph}
import no.hib.dpf.text.tdpf.{Node=>JNode}
import no.hib.dpf.text.tdpf.{Arrow=>JArrow}
import no.hib.dpf.text.tdpf.{Arrows=>JArrows}
import no.hib.dpf.text.tdpf.{DpfId=>JId}
import no.hib.dpf.text.tdpf.{DataType=>JDataType}


class Bridge(mmGraph:AbstractGraph, mmName:String) extends Parser(mmGraph, mmName){
 
  private var lastJArrows:JArrows = null; 
  
  /**
   * Read Graph as a whole:
   */
  def readTGraph(g:JGraph, name:String)={
      createGraph(g.getTypeGraph().getId());
      for(e <-new IteratorWrapper(g.getElements().iterator())){
    	  if(e.isInstanceOf[JArrow]){
    	    val a=e.asInstanceOf[JArrow];  	    

    	    //First Consume last  "Arrows"
    	    if(null != lastJArrows){
    	      addJArrows(lastJArrows,a);
    	      lastJArrows = null;
    	    }
    	    
    	    //Consume Arrow:
    	    addJArrow(a);
    	    
    	  }
    	  else if(e.isInstanceOf[JArrows]){
    	    val as = e.asInstanceOf[JArrows];

    	    //Consume last last "Arrows"
    	    if(null != lastJArrows){
    	      addJArrows(lastJArrows,as);
    	    }
    	        	
    	    lastJArrows=as;
    	  }
    	  else if(e.isInstanceOf[JNode]){
    	    val n = e.asInstanceOf[JNode];

    	    //Consume Node:
    	    addJNode(n);
    	    
    	  }
      }
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