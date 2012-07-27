package no.hib.dpf.text.wrapper;

//Scala:
import no.hib.dpf.text.graph.parser.Parser;
import no.hib.dpf.text.graph._
import no.hib.dpf.text.graph.mutable.{Graph=>MGraph}
import no.hib.dpf.text.graph.mutable.{ExtSubGraph=>MExtSubGraph}
import scala.collection.mutable.{Map=>MMap};
import scala.collection.mutable.{Set=>MSet};
import scala.collection.JavaConversions._;
import scala.collection.mutable.ListBuffer;

//Java:
import no.hib.dpf.text.tdpf.{Specification=>JSpecification}
import no.hib.dpf.text.tdpf.{Element=>JElement}
import no.hib.dpf.text.tdpf.{Node=>JNode}
import no.hib.dpf.text.tdpf.{Arrow=>JArrow}
import no.hib.dpf.text.tdpf.{Arrows=>JArrows}
import no.hib.dpf.text.tdpf.{DpfId=>JId}
import no.hib.dpf.text.tdpf.{DataType=>JDataType}
import no.hib.dpf.text.tdpf.{Signature=>JSignature}
import no.hib.dpf.text.util.{Tuple=>JTuple}
import java.util.{Stack=>JStack};
import java.util.{List=>JList};
import java.util.{LinkedList=>JLList};
import java.util.{Map=>JMap};
import java.util.{HashMap=>JHashMap};

class Bridge(mmSpec:S, mmName:String, nextSeq:Long) extends Parser(mmSpec, mmName, nextSeq){
  import no.hib.dpf.text.graph.parser.Parser._;
 
  /**
   * Return Tuple: x=Graph as List of Strings, y=Tuple containing the Element that cases the error plus the error message
   */
  def read(s:JStack[JTuple[String,JSpecification]]):JTuple[JList[String],JList[JTuple[_,String]]]={
	
      if(s.empty()){
	    sys.error("No Specification");
	  }
    
	  //init:
	  initParser();
	  
	  var rSpec:Tuple2[S,JList[JTuple[_,String]]] = null;
	  var top:JTuple[String,JSpecification] = null;
	  	  
	  while(!s.empty()){
	    top = s.pop();
	    try{
	    	rSpec = read(top.x,top.y);
	    }catch{
	      case ex => ex.printStackTrace();
	    }
	  }
	  
	  var sigName:Option[String]=None;
	  val specification:JSpecification = top.y
	  if(null != specification.getConstraintSemantic() && null != specification.getConstraintSemantic().getId()){
	    sigName = Some(specification.getConstraintSemantic().getId())
	  }		  

	  new JTuple(asList(ListBuffer(serializeSpecification(rSpec._1,"",specification.getType.getId(),GCtx.gen().v,"",sigName): _*)),rSpec._2);
  }
    
  /**
   * Read Graph as a whole:
   */
  private def read(name:String, s:JSpecification):(S,JList[JTuple[_,String]])={
      
      val errors:JList[JTuple[_,String]] = new JLList[JTuple[_,String]];
	  GCtx.setNext(s.getSequenceNumber().getNextNumber());
	  
	  //
	  //Read Graph:
	  //
	  val mmGraphName = s.getType().getId();
	  
      createGraph(mmGraphName);
      
      for(e <-new IteratorWrapper(s.getGraph().getElements().iterator())){
    	  if(e.isInstanceOf[JArrow]){
    	    
    	    val a=e.asInstanceOf[JArrow];  	    
    	    
    	    //Consume Arrow:
    	    val t = addJArrow(a)
    	    if(!t.y.equals("")){
    	    	errors.add(t);
    	    }
    	    
    	  }
    	  else if(e.isInstanceOf[JArrows]){
    	    var as = e.asInstanceOf[JArrows];
    	    
    	    //Add Linked List of Arrows:
    	    while(null != as.getNext()){
    	      val t = addJArrows(as,as.getNext());
	    	  if(!t.y.equals("")){
	    	    errors.add(t);
	    	  }
    	      as = as.getNext();
    	    }
    	    
    	    //Add Last Arrow:
     	    val t = addJArrow(as.asInstanceOf[JArrow]);	  
	    	if(!t.y.equals("")){
	    	  errors.add(t);
	    	}
    	  }
    	  else if(e.isInstanceOf[JNode]){
    	    val n = e.asInstanceOf[JNode];

    	    //Consume Node:
    	    val t = addJNode(n);
 	    	if(!t.y.equals("")){
	    	  errors.add(t);
	    	}
    	    
    	  }
      }
      //Return normalized Graph in List of StringBuffer:
      val rGraph = this.curMGraph.normalize(GCtx.gen);
      
      saveTGraph(name,rGraph);

      //
	  //Read Constraints:
	  //
      initSpec(name)

      //Read constraints;
   	  val cSet = MSet[Constraint]();
      for(c <-new IteratorWrapper(s.getConstraints().iterator())){
          val jSig = c.getSignature(); //Java Signature
    	  //val sig = createSConstraint(jId2RId(jSig.getId()),jSig.getId().getName(),List(jSig.getParameter(): _*))
    	  val sig = createSConstraint(None,jSig.getId().getName(),List(jSig.getParameter(): _*))
    	  var aList:List[Arrow] = Nil;
   	      try{
   	          var errorFound = false;
	    	  for(e<-c.getArrows()){
			    	  if(e.isInstanceOf[JArrow]){
			    	    
			    	    val a=e.asInstanceOf[JArrow];  	    
			    	    
			    	    //Consume Arrow:
			    	    convertJArrow(a) match{
			    	      	case rs@RParseResult(None,Some(m)) => errors.add(new JTuple(e,m)); errorFound = true;
			    	      	case RParseResult(Some(ra:RArrow),None) => findArrow(ra) match{
			    	      	  case (Some(a),None) => aList=a::aList;
			    	      	  case (None,Some(m)) => errors.add(new JTuple(e,m)); errorFound = true;
			    	      	  case _ => error("Constraint Programming Error 1")
			    	      	} 
			    	      	case _ => error("Constraint Programming Error 2")
			    	    }
			    	    
			    	  }
			    	  else if(e.isInstanceOf[JArrows]){
			    	    var as = e.asInstanceOf[JArrows];
			    	    
			    	    //Add Linked List of Arrows:
			    	    while(null != as.getNext()){
			    	      convertJArrows(as,as.getNext()) match{
			    	      	case rs@RParseResult(None,Some(m)) => errors.add(new JTuple(e,m)); errorFound = true;
			    	      	case RParseResult(Some(ra:RArrow),None) => findArrow(ra) match{
			    	      	  case (Some(a),None) => aList=a::aList;
			    	      	  case (None,Some(m)) => errors.add(new JTuple(e,m)); errorFound = true;
			    	      	  case _ => error("Constraint Programming Error 3")
			    	      	} 
			    	      	case _ => error("Constraint Programming Error 4")
			    	      }
			    	      as = as.getNext();
			    	    }
			    	    
			    	    //Add Last Arrow:
			     	    convertJArrow(as.asInstanceOf[JArrow]) match{
			    	      	case rs@RParseResult(None,Some(m)) => errors.add(new JTuple(e,m)); errorFound = true;
			    	      	case RParseResult(Some(ra:RArrow),None) => findArrow(ra) match{
			    	      	  case (Some(a),None) => aList=a::aList;
			    	      	  case (None,Some(m)) => errors.add(new JTuple(e,m)); errorFound = true;
			    	      	  case _ => error("Constraint Programming Error 5")
			    	      	} 
			    	      	case _ => error("Constraint Programming Error 6")
			     	    }
			    	  }else{
			    	      	error("Constraint Programming Error 4")
			    	  } 
	    	  }
	    	  if(!errorFound){
	    	    //Get error messages:
   	            var arrows:List[Arrow] = Nil
   	            cSet+=Constraint(sig,aList.reverse)
	    	  }
	      }catch{
	        case _ => /* do nothing */
	      }
      }
      
      //Save Spec:
      val spec = S(rGraph,cSet.toSet)
      saveSpec(name,spec)

      (spec,errors)
  }

  //
  //Node:
  //
  
  def addJNode(n:JNode):JTuple[JNode,String]={
    convertJNode(n) match{
      case RParseResult(None,Some(m)) => new JTuple(n,m);
      case RParseResult(Some(rn:RNode),None) => createNode(rn) match {
             case ParseResult(None,Some(m)) => new JTuple(n,m);
             case ParseResult(Some(_),None) => new JTuple(n,""); //No error
             case _ => error("addJNode(n:JNode) Programming error 1");
      }
      case _ => error("addJNode(n:JNode) Programming error 2");
    }
  }
  
  def convertJNode(a:JNode):RParseResult={
    val id = a.getId();
    val t = a.getType();
    createRNode(id.getName(),jId2RId(id),t.getName(),jId2RId(t));
  }

  //
  //Arrow:
  //
  
  def addJArrow(a:JArrow):JTuple[JArrow,String]={
   val aa = convertJArrow(a) match{
	      	case rs@RParseResult(None,Some(m)) => return new JTuple(a,m);
	        case RParseResult(Some(ra:RArrow),None) => ra
	        case _ => error("addJArrow(a:JArrow) Programming Error 1")
   } 
   createArrow(aa) match{
	  	case ParseResult(None,Some(m)) => return new JTuple(a,m);
	    case ParseResult(Some(_),None) => new JTuple(a,"");
	    case _ => error("addJArrow(a:JArrow) Programming Error 2")
   } 
 }

  def convertJArrow(a:JArrow):RParseResult={

    //
    //Find out which kind of arrow:
    //
    val id = a.getId();
    val t = a.getType();
    if(null != a.getTgNode()){
	     val sr = convertJNode(a.getSr()) match{
	      	case rs@RParseResult(None,Some(m)) => return rs;
	        case RParseResult(Some(rn:RNode),None) => rn
	        case _ => error("addJArrow(a:JArrow) Programming Error 1")
	     }
	     val tg = convertJNode(a.getTgNode()) match{
	      	case rs@RParseResult(None,Some(m)) => return rs;
	        case RParseResult(Some(rn:RNode),None) => rn
	        case _ => error("addJArrow(a:JArrow) Programming Error 2")
	     }	     
	     createRArrow(id.getName(),jId2RId(id),sr,tg,t.getName(),jId2RId(t))
    }else if(null != a.getTgValue()){
	     val sr = convertJNode(a.getSr()) match{
	      	case rs@RParseResult(None,Some(m)) => return rs;
	        case RParseResult(Some(rn:RNode),None) => rn
	        case _ => error("addJArrow(a:JArrow) Programming Error 3")
	     }
	    createRAttributeValue(id.getName(),jId2RId(id),sr,a.getTgValue().getValue(),t.getName(),jId2RId(t))
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
      	case _ => sys.error("addJArrow(a:JArrow) Programming Error: Datatype Error!");
      }
     val sr = convertJNode(a.getSr()) match{
      	case rs@RParseResult(None,Some(m)) => return rs;
        case RParseResult(Some(rn:RNode),None) => rn
        case _ => error("addJArrow(a:JArrow) Programming Error 4")
     }
     createRAttributeType(id.getName(),jId2RId(id),sr,at,"*")
   }  
  }
  
  
  def checkJArrowForConstraint(ja:JArrow):JTuple[JArrow,String]={
    convertJArrow(ja) match{
      	case RParseResult(None,Some(m)) => new JTuple(ja,m);
        case RParseResult(Some(ra:RArrow),None) => 
           findArrow(ra,curMGraph) match{
	      	  case (Some(a),None)  => new JTuple(ja,"");
	      	  case (None,Some(m2)) => new JTuple(ja,m2); 
	      	  case _ => error("checkJArrowForConstraint(a:JArrow) Programming Error 1")
           }	  
        case _ => error("checkJArrowForConstraint(a:JArrow) Programming Error 2")
    }
  }

  
  //
  //Arrows:
  //
  
  def addJArrows(a:JArrows, next:JArrows):JTuple[JTuple[JArrows,JArrows],String]={
    val aa = convertJArrows(a,next)match{
      	case rs@RParseResult(None,Some(m)) => return new JTuple(new JTuple(a,next),m);
        case rs@RParseResult(Some(ra:RArrow),None) => ra
        case _ => error("addJArrows(a:JArrows, next:JArrows) Programming Error 1")
	}
    createArrow(aa) match{
      	case ParseResult(None,Some(m)) => return new JTuple(new JTuple(a,next),m);
        case ParseResult(Some(_),None) => new JTuple(new JTuple(a,next),"");
        case _ => error("addJArrows(a:JArrows, next:JArrows) Programming Error 2")
     };  
  }

  def convertJArrows(a:JArrows,next:JArrows):RParseResult={
    val id = a.getId();
    val t = a.getType();
    
    val sr = convertJNode(a.getSr()) match{
      	case rs@RParseResult(None,Some(m)) => return rs;
        case RParseResult(Some(rn:RNode),None) => rn
        case _ => error("convertJArrows(a:JArrows,next:JArrows) Programming Error 1")
    }
    val tg = convertJNode(next.getSr()) match{
      	case rs@RParseResult(None,Some(m)) => return rs;
        case RParseResult(Some(rn:RNode),None) => rn
        case _ => error("convertJArrows(a:JArrows,next:JArrows) Programming Error 2")
	}	     
    createRArrow(id.getName(),jId2RId(id),sr,tg,t.getName(),jId2RId(t)) 
  }
 
  def checkJArrowsForConstraint(ja:JArrows,next:JArrows):JTuple[JTuple[JArrows,JArrows],String]={
    convertJArrows(ja,next) match{
      	case RParseResult(None,Some(m)) => new JTuple(new JTuple(ja,next),m);
        case RParseResult(Some(ra:RArrow),None) => 
           findArrow(ra,curMGraph) match{
	      	  case (Some(a),None)  => new JTuple(new JTuple(ja,next),"");
	      	  case (None,Some(m2)) => new JTuple(new JTuple(ja,next),m2); 
	      	  case _ => error("checkJArrowForConstraint(a:JArrow) Programming Error 1")
           }	  
        case _ => error("checkJArrowsForConstraint(a:JArrows,next:JArrows) Programming Error 2")
    }
  }

  //
  //Constraints:
  //
  
  def checkConstraints(s:JSpecification, cs:JSignature):JTuple[JMap[java.lang.Long,String],JList[String]]={
      import no.hib.dpf.text.graph.validation.eclipse._
 	  val rs1 = new JHashMap[java.lang.Long,String]();
      val rs2 = new JLList[String]();
      try{
    	  //Init:
          initParser();
    	  
	  	  //Set curTS:
		  curTS=specs(s.getType().getId())

 		  val tempName = "2DummyName";
		  read(tempName,s) 
		  val readCons = readConstraintSemantics(cs);
		  val pSem:Map[Id,Validator] = readCons._1;
		  val is = IS(specs(tempName),curTS,pSem)
		  
		  //Add Read Errors:
		  for(t<-readCons._2){
		    rs2.add(t.y); //Forget for now which constraint defintion caused the error! //TODO
		  } 
		  
		  //Validate: //Maybe validation should not be a singelton
		  Validation.synchronized{
		      
			  //Empty errors:
			  Validation.errors.init();
			  
			  //Validate:
			  Validation.validate(is);
			  
			  //Collect errors:
			  for(e<-Validation.errors.getErrors){
			    rs1.put(e._1.v.asInstanceOf[Long],e._2);
			  }

			  //Collect errors:
			  for(e<-Validation.errors.getGlobalErrors){
			    rs2.add(e);
			  }
		  }
		  
		  
      }catch{
        case ex => rs2.add("checkConstraints() " + ex.getMessage());
      }
	  new JTuple(rs1,rs2);
  }
  
  def readConstraintSemantics(cs:JSignature):(Map[Id,Validator],JList[JTuple[JId,String]])={
      
      //Vals:
      val rs = MMap[Id,Validator]();
      val errors = new JLList[JTuple[JId,String]];
      
      for(sem<-cs.getConstraintSemantics()){
        try{
	        val id = jId2RId(sem.getId());
	        val n = sem.getId().getName();
	        var aList:List[RArrow]=Nil;
	        var errorFound = false;
		  	for(e<-sem.getArrows()){
		    	  if(e.isInstanceOf[JArrow]){
		    	    
		    	    val a=e.asInstanceOf[JArrow];  	    
		    	    
		    	    //Consume Arrow:
		    	    convertJArrow(a) match{
		    	      	case rs@RParseResult(None,Some(m)) => errors.add(new JTuple(e.getId(),m)); errorFound = true;
		    	      	case RParseResult(Some(ra:RArrow),None) => aList=ra::aList;
		    	      	case _ => error("readConstraintSemantics(cs:JSignature) Error 1")
		    	    }
		    	    
		    	  }
		    	  else if(e.isInstanceOf[JArrows]){
		    	    var as = e.asInstanceOf[JArrows];
		    	    
		    	    //Add Linked List of Arrows:
		    	    while(null != as.getNext()){
		    	      convertJArrows(as,as.getNext()) match{
		    	      	case rs@RParseResult(None,Some(m)) => errors.add(new JTuple(e.getId(),m)); errorFound = true;
		    	      	case RParseResult(Some(ra:RArrow),None) => aList=ra::aList;
		    	      	case _ => error("readConstraintSemantics(cs:JSignature) Error 2")
		    	      }
		    	      as = as.getNext();
		    	    }
		    	    
		    	    //Add Last Arrow:
		     	    convertJArrow(as.asInstanceOf[JArrow]) match{
		    	      	case rs@RParseResult(None,Some(m)) => errors.add(new JTuple(e.getId(),m)); errorFound = true;
		    	      	case RParseResult(Some(ra:RArrow),None) => aList=ra::aList;
		    	      	case _ => error("readConstraintSemantics(cs:JSignature) Error 3")
		     	    }
		    	  }else{
		    	      	error("readConstraintSemantics(cs:JSignature) Error 4")
		    	  } 
		    }
		  	val o = parseAll(ocl,sem.getOcl()).get;
	        createValidator(id,n,aList.reverse,o) match {
	           case (Some(validator), None) => rs+=(validator.id->validator)
	           case (None, Some(msg)) => errors.add(new JTuple(sem.getId(),msg));
	           case (None, None) => error("readConstraintSemantics(cs:JSignature) Error 5")
	        }
	        
        }catch{
          case ex => //ex.printStackTrace();
          			 errors.add(new JTuple(sem.getId(),ex.getMessage()));
        }
      }
      (rs.toMap,errors);
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
  
  private def jId2RId(d:JId):Option[Id]={
     if(d.getId() > -1){
       Some(RId(d.getId()));
     }else{
       None
     } 
   } 
   
}