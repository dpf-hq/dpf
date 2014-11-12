package no.dpf.text.graph.ecore

import no.dpf.text.graph._
import scala.collection._
import scala.collection.mutable.{Map=>MMap}
import scala.xml._	  
import no.dpf.text.graph.{Element=>DElement}
import no.dpf.text.graph.{Node=>DNode}
import no.dpf.text.graph.{Arrow=>DArrow}

object EcoreGenerator extends ModelHelper with InstanceHelper with Converter{

  def graph2EcoreM(g:AbstractGraph, ecoreName:String): xml.Elem={
    val nodesWithoutValues = g.nodes.values.filterNot(_  match {case DNode(_, DNode(_,TypeNode.TAttribute())) => true;case _ => false})
    val arrowsWithoutValues = g.arrows.values.filterNot(_ match {case DArrow(_,_,_,DArrow(_,_,_,TypeArrow.TAttribute())) => true;case _ => false})
	<ecore:EPackage xmi:version="2.0"
    	xmlns:xmi="http://www.omg.org/XMI" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    	xmlns:ecore="http://www.eclipse.org/emf/2002/Ecore" name="Graph"
    	nsURI="graph" nsPrefix="graph">
  
    	<!-- Containment Relationships: -->  
    	<eClassifiers xsi:type="ecore:EClass" name="Graph">
		  	<eStructuralFeatures xsi:type="ecore:EAttribute" name="id" eType="ecore:EDataType http://www.eclipse.org/emf/2002/Ecore#//EString"/>
   		{
		for{e <- nodesWithoutValues ++ arrowsWithoutValues} yield 
			<eStructuralFeatures xsi:type="ecore:EReference" name={(e.id+"s").toLowerCase}  upperBound="-1"  eType={"#//"+e.id} containment="true"/>
		}
   		<!-- Simple Dataypes: --> 
   		{simpleDataTypeReferences.child}
   			
    	</eClassifiers>

    	<!-- Nodes: -->      
   		{
   		for{n <- nodesWithoutValues} yield 
	    <eClassifiers xsi:type="ecore:EClass" name={n.id.toString}>
		  	<eStructuralFeatures xsi:type="ecore:EAttribute" name="id" eType="ecore:EDataType http://www.eclipse.org/emf/2002/Ecore#//EString" iD="true"/>
   			<eStructuralFeatures xsi:type="ecore:EAttribute" name="name" eType="ecore:EDataType http://www.eclipse.org/emf/2002/Ecore#//EString"/>
		{
	   		for{a <- g.arrowsOut(n).filterNot(_ match {case DArrow(_,_,_,DArrow(_,_,_,TypeArrow.TAttribute())) => true;case _ => false})} yield 
	   		<eStructuralFeatures xsi:type="ecore:EReference" name={a.id.toString.toLowerCase}  upperBound="-1" eType={"#//"+a.id}/>
   		}
   		</eClassifiers>
   		}

   		<!-- Simple Datatypes: -->
  		{simpleDataTypes.child}

   		<!-- Arrows: -->      
   		{
   		for{a <- arrowsWithoutValues} yield 
   		<eClassifiers xsi:type="ecore:EClass" name={a.id.toString}>
		  	<eStructuralFeatures xsi:type="ecore:EAttribute" name="id" eType="ecore:EDataType http://www.eclipse.org/emf/2002/Ecore#//EString" iD="true"/>
   			<eStructuralFeatures xsi:type="ecore:EAttribute" name="name" eType="ecore:EDataType http://www.eclipse.org/emf/2002/Ecore#//EString"/>
   			<eStructuralFeatures xsi:type="ecore:EReference" name="sr" lowerBound="1" eType={"#//" + a.sr.id}/>
   			<eStructuralFeatures xsi:type="ecore:EReference" name="tg" lowerBound="1" eType={"#//" + a.tg.id}/>
  		</eClassifiers>
   		}
   		
   	</ecore:EPackage>
  }

     

  
  def graph2EcoreI(g:AbstractGraph, ecoreName:String): xml.Elem={
  implicit val ns = split(g.iteratorNodes)
  val as = split(g.iteratorArrows)  	   
  var xn=
    <graph:Graph xmi:version="2.0" xmlns:xmi="http://www.omg.org/XMI" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:graph="graph" xsi:schemaLocation={"graph " + ecoreName+ ".ecore"}>
    <!--Nodes (no primitives): -->
    {
	  for(n<-ns._1.values.flatten.filterNot(_ match {case DNode(_,DNode(_,TypeNode.TAttribute())) => true;case _ => false}))
	    yield {var xn= <DUMMY/>.copy(label = (n.t.id+"s").toLowerCase)
		  	   xn%= Attribute(None, "id", Text(rIdvalue(n)), Null)	
		  	   xn%= Attribute(None, "name", Text(g.names(n.id)), Null)	
		  	   for(a<-g.arrowsOut(n).filterNot(_ match {case DArrow(_,_,_,TypeArrow.TAttribute()) => true;case _ => false})){	
		  		   xn%= Attribute(None, a.t.id.toString.toLowerCase, Text(rIdvalue(a)), Null);
		  	   }
	    	   xn
	    }
    }
	
    <!--Arrows: -->		  
    {
	  for(a<-as._1.values.flatten)
	    yield {var xn= <DUMMY/>.copy(label = (a.t.id+"s").toLowerCase)
		  	   xn%= Attribute(None, "id", Text(rIdvalue(a)), Null)	
   		  	   xn%= Attribute(None, "name", Text(g.names(a.id)), Null)	
	  		   xn%= Attribute(None, "sr", Text(rIdvalue(a.sr)), Null);
	    	   xn%= Attribute(None, "tg", arrowtrRef(a), Null);
	    	   xn
	    }
    }
    
    <!--Nodes (primitives): -->		    
    {
    for(n<-ns._1.values.flatten.filter(_ match {case DNode(_,DNode(_,TypeNode.TAttribute())) => true;case _ => false}))
        yield {<DUMMY/>.copy(label = lfirstChar(n.t.id+"s")) % Attribute(None, "value", Text(value(n)), Null)}
    }
   </graph:Graph>
   xn%=Attribute(None, "id", Text(ecoreName+"_Instance:" + new java.util.Date), Null)
   xn
   }

  //-------------------------------------------------------------------------------------------------------------------------------
  
  /*
   * Simpler Ecore Presentations:
   */

  //-------------------------------------------------------------------------------------------------------------------------------
  
  def graph2EcoreM_simple(g:AbstractGraph, ecoreName:String): xml.Elem={
    val nodesWithoutValues = g.nodes.values.filterNot(_  match {case DNode(_, DNode(_,TypeNode.TAttribute())) => true;case _ => false})
    val arrowsWithoutValues = g.arrows.values.filterNot(_ match {case DArrow(_,_,_,DArrow(_,_,_,TypeArrow.TAttribute())) => true;case _ => false})
	<ecore:EPackage xmi:version="2.0"
    	xmlns:xmi="http://www.omg.org/XMI" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    	xmlns:ecore="http://www.eclipse.org/emf/2002/Ecore" name="Graph"
    	nsURI="graph" nsPrefix="graph">
  
    	<!-- Containment Relationships: -->  
    	<eClassifiers xsi:type="ecore:EClass" name="Graph">
		  	<eStructuralFeatures xsi:type="ecore:EAttribute" name="id" eType="ecore:EDataType http://www.eclipse.org/emf/2002/Ecore#//EString"/>
   		{
		for{e <- nodesWithoutValues} yield 
			<eStructuralFeatures xsi:type="ecore:EReference" name={(e.id+"s").toLowerCase}  upperBound="-1"  eType={"#//"+e.id} containment="true"/>
		}
   		<!-- Simple Dataypes: --> 
   		{simpleDataTypeReferences.child}
   			
    	</eClassifiers>

    	<!-- Nodes: -->      
   		{
   		for{n <- nodesWithoutValues} yield 
	    <eClassifiers xsi:type="ecore:EClass" name={n.id.toString}>
		  	<eStructuralFeatures xsi:type="ecore:EAttribute" name="id" eType="ecore:EDataType http://www.eclipse.org/emf/2002/Ecore#//EString" iD="true"/>
   			<eStructuralFeatures xsi:type="ecore:EAttribute" name="name" eType="ecore:EDataType http://www.eclipse.org/emf/2002/Ecore#//EString"/>
		{
	   		for{a <- g.arrowsOut(n).filterNot(_ match {case DArrow(_,_,_,DArrow(_,_,_,TypeArrow.TAttribute())) => true;case _ => false})} yield 
	   		<eStructuralFeatures xsi:type="ecore:EReference" name={a.id.toString}  upperBound="-1" eType={"#//"+a.tg.id}/>
   		}
   		</eClassifiers>
   		}

   		<!-- Simple Datatypes: -->
  		{simpleDataTypes.child}
   	</ecore:EPackage>
  }

  def graph2EcoreI_simple(g:AbstractGraph, ecoreName:String): xml.Elem={
  implicit val ns = split(g.iteratorNodes)
  val as = split(g.iteratorArrows)  	   
  var xn=
    <graph:Graph xmi:version="2.0" xmlns:xmi="http://www.omg.org/XMI" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:graph="graph" xsi:schemaLocation={"graph " + ecoreName+ ".ecore"}>
    <!--Nodes (no primitives): -->
    {
	  for(n<-ns._1.values.flatten.filterNot(_ match {case DNode(_,DNode(_,TypeNode.TAttribute())) => true;case _ => false}))
	    yield {var xn= <DUMMY/>.copy(label = (n.t.id+"s").toLowerCase)
		  	   
	    	   xn%= Attribute(None, "id", Text(rIdvalue(n)), Null)	
		  	   xn%= Attribute(None, "name", Text(g.names(n.id)), Null)	
		  	   
		  	   //All non attribute grouped by their type
		  	   for(e<-g.arrowsOut(n).filterNot(_ match {case DArrow(_,_,_,TypeArrow.TAttribute()) => true;case _ => false}).groupBy(_.t)){
		  		   val links = for(a<-e._2)yield {arrowtrRef(a) + " "}
		  		   xn%= Attribute(None,e._1.id.toString, Text(links.reduceLeft(_+_)), Null);
		  	   }
	    
	    
	    	   xn
	  }
    }
    <!--Nodes (primitives): -->		    
    {
    for(n<-ns._1.values.flatten.filter(_ match {case DNode(_,DNode(_,TypeNode.TAttribute())) => true;case _ => false}))
        yield {<DUMMY/>.copy(label = lfirstChar(n.t.id+"s")) % Attribute(None, "value", Text(value(n)), Null)}
    }
   </graph:Graph>
   xn%=Attribute(None, "id", Text(ecoreName+"_Instance:" + new java.util.Date), Null)
   xn
   }
  
}

private[ecore] trait ModelHelper{
  
  val simpleDataTypeReferences:xml.Elem=
    <simpleDataTypeReferences>
   		<eStructuralFeatures xsi:type="ecore:EReference" name="tBooleans" upperBound="-1"  eType="#//Boolean" containment="true"/>
   		<eStructuralFeatures xsi:type="ecore:EReference" name="tChars"    upperBound="-1"  eType="#//Char"    containment="true"/>
   		<eStructuralFeatures xsi:type="ecore:EReference" name="tBytes"    upperBound="-1"  eType="#//Byte"    containment="true"/>
   		<eStructuralFeatures xsi:type="ecore:EReference" name="tShorts"   upperBound="-1"  eType="#//Short"   containment="true"/>
   		<eStructuralFeatures xsi:type="ecore:EReference" name="tInts"     upperBound="-1"  eType="#//Int"     containment="true"/>
   		<eStructuralFeatures xsi:type="ecore:EReference" name="tLongs"    upperBound="-1"  eType="#//Long"    containment="true"/>
   		<eStructuralFeatures xsi:type="ecore:EReference" name="tFloats"   upperBound="-1"  eType="#//Float"   containment="true"/>
   		<eStructuralFeatures xsi:type="ecore:EReference" name="tDoubles"  upperBound="-1"  eType="#//Double"  containment="true"/>
   		<eStructuralFeatures xsi:type="ecore:EReference" name="tStrings"  upperBound="-1"  eType="#//String"  containment="true"/>
    </simpleDataTypeReferences>

  val simpleDataTypes:xml.Elem=
    <simpleDataTypes>
   		<eClassifiers xsi:type="ecore:EClass" name="Boolean">
   			<eStructuralFeatures xsi:type="ecore:EAttribute" name="value" lowerBound="1" eType="ecore:EDataType http://www.eclipse.org/emf/2002/Ecore#//EBoolean"/>
   		</eClassifiers>
   		<eClassifiers xsi:type="ecore:EClass" name="Char">
   			<eStructuralFeatures xsi:type="ecore:EAttribute" name="value" lowerBound="1" eType="ecore:EDataType http://www.eclipse.org/emf/2002/Ecore#//EChar"/>
   		</eClassifiers>
   		<eClassifiers xsi:type="ecore:EClass" name="Byte">
   			<eStructuralFeatures xsi:type="ecore:EAttribute" name="value" lowerBound="1" eType="ecore:EDataType http://www.eclipse.org/emf/2002/Ecore#//EByte"/>
   		</eClassifiers>
   		<eClassifiers xsi:type="ecore:EClass" name="Short">
   			<eStructuralFeatures xsi:type="ecore:EAttribute" name="value" lowerBound="1" eType="ecore:EDataType http://www.eclipse.org/emf/2002/Ecore#//EShort"/>
   		</eClassifiers>
   		<eClassifiers xsi:type="ecore:EClass" name="Int">
   			<eStructuralFeatures xsi:type="ecore:EAttribute" name="value" lowerBound="1" eType="ecore:EDataType http://www.eclipse.org/emf/2002/Ecore#//EInt"/>
   		</eClassifiers>
   		<eClassifiers xsi:type="ecore:EClass" name="Long">
   			<eStructuralFeatures xsi:type="ecore:EAttribute" name="value" lowerBound="1" eType="ecore:EDataType http://www.eclipse.org/emf/2002/Ecore#//ELong"/>
   		</eClassifiers>
   		<eClassifiers xsi:type="ecore:EClass" name="Float">
   			<eStructuralFeatures xsi:type="ecore:EAttribute" name="value" lowerBound="1" eType="ecore:EDataType http://www.eclipse.org/emf/2002/Ecore#//EFloat"/>
   		</eClassifiers>
   		<eClassifiers xsi:type="ecore:EClass" name="Double">
   			<eStructuralFeatures xsi:type="ecore:EAttribute" name="value" lowerBound="1" eType="ecore:EDataType http://www.eclipse.org/emf/2002/Ecore#//EDouble"/>
   		</eClassifiers>
   		<eClassifiers xsi:type="ecore:EClass" name="String">
   			<eStructuralFeatures xsi:type="ecore:EAttribute" name="value" lowerBound="1" eType="ecore:EDataType http://www.eclipse.org/emf/2002/Ecore#//EString"/>
   		</eClassifiers>
    </simpleDataTypes>
}

private[ecore] trait InstanceHelper{
	  def split[T<:Element](i:Iterator[T])={
	      val elems = MMap[Type,List[T]]() 
		  //Split Elements according to their types:
	      for(e<-i){
		    if(elems contains e.t){
		      //Filterout values:
		      e.t match {
		        case TypeNode.TAttribute()  => 
		        case TypeArrow.TAttribute() => 
		        case _ => elems+=e.t->(e::elems(e.t))
		      }
		    }else{
		      //Filterout values:
		      e.t match {
		        case TypeNode.TAttribute()  => 
		        case TypeArrow.TAttribute() => 
		        case _ => elems+=e.t->(e::Nil)
		      }
		    }
		  }
	      //Save positions to ids
	      val pos = MMap[Id,Int]()
	      for(l<-elems.values){
	        var c = 0
	        for(e<-l){
	          pos+=e.id->c
	          c+=1
	        }
	      } 
	      (elems,pos)
	  }
	  def lfirstChar(s:String)=s.head.toString.toLowerCase + s.tail	
	  def value(n:DNode)=n match {
	    case DNode(v:AValue,_) => v.v.toString
	    case _ => sys.error("Programming error!")  
	  }	
	  def rIdvalue(e:DElement)=e match {
	    case DNode(RId(x),_) => x.toString
	    case DArrow(RId(x),_,_,_) => x.toString
	    case _ => sys.error("Programming error! RId not found:" + e)  
	  }	
	  def arrowtrRef(a:DArrow)(implicit ns:(MMap[Type,List[DNode]],MMap[Id,Int]))=a match {
	    case DArrow(_,_,_,DArrow(_,_,_,TypeArrow.TAttribute())) => Text("//@"+ lfirstChar(a.tg.t.id.toString) + "s." + ns._2(a.tg.id))
	    case DArrow(_,_,tg,_) => Text(rIdvalue(tg))    
	    case _ => sys.error("Programming error! RId not found:" + a)  
	  }	
}
