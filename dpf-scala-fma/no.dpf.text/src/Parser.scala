package no.dpf.text.graph.parser;

import scala.util.parsing.combinator._
import no.dpf.text.graph._
import no.dpf.text.graph.mutable.{Graph=>MGraph}
import scala.collection.mutable.{Map=>MMap}

class Parser(mmGraph:AbstractGraph, mmName:String) extends JavaTokenParsers with Converter{
	   
	//Ids:
	object GCtx{
		private var i = 0; 
		def gen()= {i+=1;
					RId(1000 + i);
		}
		def init() = i = 0; 
	}
	
	//Input and output:
	var inFile="file.tdpf"
	var outDir=""
	
	//Specification vars:
	private var specs:MMap[String,S] = null	
	
	//Graph vars:
	private var tGraphs:MMap[String,AbstractGraph]	= null
	private var curTGraph:AbstractGraph = null 	  //current type graph
	private var curMGraph:MGraph = null           //current model graph
	private var curSGraph:AbstractGraph = null    //current specification graph
	private var curTS:S = null					  //current specification type graph
	private var curSignatureConstraints:MMap[(String,List[String]),SignatureConstraint] = null  //ids of constraints of current specification
	
	protected def initParser()={
	  
	  //Specification vars:
	  specs = MMap[String,S]()	
	
	  //Graph vars:
	  tGraphs = MMap(mmName->mmGraph)	
	  curTGraph = mmGraph	   //current type graph
	  curMGraph = null         //current model graph
	  curSGraph = null  	   //current specification graph
	  curTS = null			   //current specification type graph
	  curSignatureConstraints = MMap[(String,List[String]),SignatureConstraint]() //ids of constraints of current specification
	  
	  //Init Counter:
	  GCtx.init()
	}
	
	
	def mTGraphs(name:String):mutable.Graph = tGraphs(name) match{
		case x:mutable.Graph => x
		case x:AbstractGraph => sys.error("Graph with name '" + name + "' is not mutable!") 
		case _ 				 => sys.error("Graph with name '" + name + "' does not exist!")
	}

	trait RElement
	case class RNode(name:Option[String],
	                 id:Option[Id],
	                 t:TypeNode) extends RElement
	case class RArrow(name:String,
	                  id:Option[Id],
	                  sr:RNode,
	                  tg1:Option[RNode],
	                  tg2:Option[Node],
	                  t:TypeArrow) extends RElement
	                  
//
//Terminal
//
	val ID:     Parser[String] = """[a-zA-Z_]\w*""".r
	val ID_A:   Parser[String] = """[a-zA-Z_]\w*|\*""".r
	val DPF_ID: Parser[String] = """[1-9]?[0-9]*""".r
	val CPARAM: Parser[String] = """[a-zA-Z_]*[0-9]*""".r
	val OCL: Parser[String] = """[^#$]""".r	
	val P_NUM: Parser[String] = """[1-9]?[0-9]*""".r
	
	//Types:
	val TBOOLEAN : Parser[String] = "Boolean".r
	val TCHAR: Parser[String] = "Char".r
	val TBYTE: Parser[String] = "Byte".r
	val TSHORT: Parser[String] = "Short".r
	val TINT: Parser[String] = "Int".r
	val TLONG: Parser[String] = "Long".r
	val TFLOAT: Parser[String] = "Float".r
	val TDOUBLE: Parser[String] = "Double".r
	val TSTRING: Parser[String] = "String".r
	
	//For magic String to URL-Ecoded String
	val URL_ENCODED = "<uRL}$#§{uRL>"
	val TVALUE_char : Parser[String] = """'.'""".r
	
	//Read white in OCL:
	override def skipWhitespace = !isOCL
	var isOCL = false

	//
	//Grammar:
	//
	
	//OCL expressions:
	def ocl: Parser[List[OclToken]] = repsep(ocl_pars,"") ^^ {case ocl => ocl}
	def ocl_pars:   Parser[OclToken]   = ocl_pp | ocl_pn | ocl_pa | ocl_char ^^ {case d => d}
	def ocl_pp:     Parser[OclPp] = "#p"~P_NUM~"#" ^^ {case "#p"~p~"#" => OclPp(p.toInt)}
	def ocl_pn:     Parser[OclPn] = "#n"~P_NUM~"#" ^^ {case "#n"~p~"#" => OclPn(p.toInt)}
	def ocl_pa:     Parser[OclPa] = "#a"~P_NUM~"#" ^^ {case "#a"~p~"#" => OclPa(p.toInt)}
	def ocl_char:   Parser[OclChar] = OCL   ^^ {case c=> OclChar(c.toCharArray()(0))}
	def ocl_start:  Parser[Any] = "$" ^^ {case c=> isOCL = true}
	def ocl_stop:   Parser[Any] = "$"  ^^ {case c=> isOCL = false}

	//"Program":
	def definitions: Parser[List[Any]] = repsep(definition,"") ^^ {case defs => defs}
	
	def definition: Parser[Any] = ispec | spec | tgraph | emf | ecore ^^ {case d => d}
	
	def emf: Parser[Any] = "emf("~ID~")" ^^ { case "emf("~i~")" => printEmf(i)}
	
	def ecore: Parser[Any] = "ecore("~ID~")" ^^ { case "ecore("~i~")" => printEcore(i)}

	//Specification instance:
	def ispec : Parser[IS] = ID~":="~"ISpec<"~chosenSpec~","~chosenSpec~">"~"{"~repsep(constraintSem,",")~"}" ^^ {case n~":="~"ISpec<"~mS~","~mmS~">"~"{"~sem~"}" => IS(mS,mmS,sem.map{e=>(e.id,e)}.toMap)}

	def chosenSpec : Parser[S] = ID ^^ {case i => curTS=specs(i);curTS}
	
	def constraintSem: Parser[Validator] = ID~dpfId~"{"~repsep(arrows,",")~","~"}"~"="~ocl_start~ocl~ocl_stop ^^ {case n~dpfid~"{"~as~","~"}"~"="~start~v~stop => createValidator(dpfid,n,as,v)}
		
	//Specification:
	def spec : Parser[S] = ID~":="~"Spec<"~chosenGraph~">"~"{"~repsep(constraint,",")~"}" ^^ {case n~":="~"Spec<"~g~">"~"{"~cs~"}" => saveSpec(n,S(g,cs.toSet))}
	
	def chosenGraph : Parser[AbstractGraph] = ID ^^ {case i => initSpec(i)}
	
	def constraint: Parser[Constraint] = constraintName~"{"~repsep(arrows,",")~","~"}" ^^ {case n~"{"~as~","~"}" => createConstraint(n,as.flatten)} //Arrows holen 
		
	def constraintName: Parser[SignatureConstraint] = ID~dpfId~"("~repsep(CPARAM,",")~")" ^^ {case n~dpfid~"("~ps~")" => createSConstraint(dpfid,n,ps)}

	
	//Typed graphs:
	def tgraph : Parser[MGraph] = ID~":="~"TGraph<"~tname~">"~graph ^^ {case n~":="~"TGraph<"~t~">"~g => saveTGraph(n,g)} //Save map in buffer
	
	def tname : Parser[String] = ID ^^ {case i => createGraph(i)}
	
	def graph : Parser[MGraph] = ("{"~repsep(expr,"")~"}" ^^ {case "{"~elements~"}" => fillCurGraph(elements.flatten)})
	
	def expr : Parser[List[RElement]] = ( node~","^^ {case n~"," => List(n)}
	 								   | arrows~"," ^^ {case a~"," => a})
							  
	def arrows: Parser[List[RArrow]]   = (node~"-"~ID~dpfId~":"~ID~dpfId~"->"~arrows   ^^ {case n1~"-"~i~dpfId1~":"~t~dpfId2~"->"~l  =>  createRArrow(i,dpfId1,n1,l.head.sr,t,dpfId2)::l}	
							      		 |node~"-"~ID~dpfId~":"~ID~dpfId~"->"~arrow    ^^ {case n1~"-"~i~dpfId1~":"~t~dpfId2~"->"~a  =>  List(createRArrow(i,dpfId1,n1,a.sr,t,dpfId2),a)}
							             |arrow							   			   ^^ {case a  		               =>  List(a)}	
								        )
	
	def arrow: Parser[RArrow] = ( node~"-"~ID~dpfId~":"~ID_A~"->"~attributeType  ^^ {case n1~"-"~i~dpfId~":"~t~"->"~at => createRAttributeType(i,dpfId,n1,at,t)}
	                            | node~"-"~ID~dpfId~":"~ID~"->"~attributeValue   ^^ {case n1~"-"~i~dpfId~":"~t~"->"~av => createRAttributeValue(i,dpfId,n1,av,t)}
	                            | node~"-"~ID~dpfId~":"~ID~dpfId~"->"~node	   	 ^^ {case n1~"-"~i~dpfId1~":"~t~dpfId2~"->"~n2 => createRArrow(i,dpfId1,n1,n2,t,dpfId2)}
	                            )       											 
																		
	def node: Parser[RNode] = ID~dpfId~":"~ID~dpfId ^^ {case i~dpfId1~":"~t~dpfId2 => createRNode(i,dpfId1,t,dpfId2)}
	
	def attributeType: Parser[Node with TypeP] = (	
													TBOOLEAN ^^^ {TypeP.TInt}
												|	TCHAR    ^^^ {TypeP.TChar}
												|	TBYTE    ^^^ {TypeP.TByte}
												|	TSHORT   ^^^ {TypeP.TShort}
												|	TINT     ^^^ {TypeP.TInt}
												|	TLONG    ^^^ {TypeP.TLong}
												|	TFLOAT   ^^^ {TypeP.TFloat}
												|	TDOUBLE  ^^^ {TypeP.TDouble}
												|	TSTRING  ^^^ {TypeP.TString}
												)
												 
	def attributeValue: Parser[String] = "["~tValue~"]" ^^ {case "["~v~"]" => decodeString(v)}
	
	def tValue: Parser[String]  = floatingPointNumber | TVALUE_char | stringLiteral 

	def dpfId: Parser[Option[Id]] = ("@"~DPF_ID ^^ {case "@"~id  =>  Some(RId(id.toLong))}
							 		|"" ^^ {case _  =>  None}
									) 
 
																		
	private def saveSpec(n:String,s:S):S={
	  specs+=n->s
	  s
	}		
	
	private def saveTGraph(n:String,g:MGraph):MGraph={
	  tGraphs+=n->g;
	  
	  //Generate Standard Specification:
	  specs+=n->S(g,Set())
	  
	  g
	}	
	
	private def initSpec(i:String)={
		//Choose Graph for specification:	
		curSGraph=tGraphs(i);
		//Choose TGraph of specification Graph:
		curTGraph=curSGraph.mmGraph;
		//Empty buffer for constraint ids:
		curSignatureConstraints=curSignatureConstraints.empty; 
		curSGraph	  
	}
									
	private def createGraph(mmName:String)={
		//Init Graph:
		curTGraph=tGraphs(mmName);
		curMGraph=new MGraph(curTGraph,GCtx.gen);
		mmName	
	}
	
    private def createRNode(name:String, id:Option[Id], t:String, typeId:Option[Id]):RNode={
		typeId match{	
		  case None =>
				if("_" == t){
					RNode(Some(name),id,TypeNode.TJoker())				  
				}else{
			    	val result = curTGraph.findNode(t)
				    val ty =
				    result match {
				    	case None => sys.error("Node Type does not exit! t="+t)
				    	case Some(x) => x
				    }
					RNode(Some(name),id,ty)
				}
		  case Some(tId) =>
		  		val result = curTGraph.getNode(tId)
			    val ty =
			    result match {
			    	case None => sys.error("Node Type does not exit! id="+tId)
			    	case Some(x) => x
			    }
		  		RNode(Some(name),id,ty)
		}
	}    
    
    private def createRArrow(name:String,id:Option[Id],n1:RNode,n2:RNode,t:String,typeId:Option[Id]):RArrow={
		typeId match{	
		  case None =>
				if("_" == t){
					RArrow(name,id,n1,Some(n2),None,TypeArrow.TJoker())
				}else{
			      val result = curTGraph.findArrow(t,n1.t,n2.t)
				  val ty= result match {
				      case None => sys.error("Type does not exit! t="+t + " sr=" + n1.t + " tg=" + n2.t)
				      case Some(x) => x
				  }
				  RArrow(name,id,n1,Some(n2),None,ty)
				}  
		  case Some(tId) =>
		      val result = curTGraph.getArrow(tId)
			  val ty= result match {
			      case None => sys.error("Type does not exit! id=" + tId)
			      case Some(x) => if(x.sr!=n1.t || x.tg!=n2.t){
			    	  				sys.error("Type with id=" + tId + " is not compatible with source and target!")	
			      				  }else x 
			  }
			  RArrow(name,id,n1,Some(n2),None,ty)
		}
    }
    
	private def createRAttributeType(name:String,id:Option[Id],n1:RNode,at:Node with TypeP,t:String):RArrow={
		if("*" != t) sys.error("Attribute arrow has to have type *")
		RArrow(name,id,n1,None,Some(at),TypeArrow.TAttribute())
	}
	
	private def createRAttributeValue(name:String,id:Option[Id],n1:RNode,rav:String,t:String):RArrow={
	    val result = curTGraph.findArrow(t,n1.t)
	    val ty = result match {
	    	case None => sys.error("Attribute does not exit! t="+t + " sr=" + n1.t)
	    	case Some(x) => x
	    }
	    val value = ty.tg match {
	    	case tc:TypeP => tc.toValue(rav)
	    	case _ => sys.error("Programming sys.error in createAttributeValue")
	    }
	    val v = RNode(None,Some(value),ty.tg) 	 //Only return inside Arrow (is not a problem here)
	    RArrow(name,id,n1,Some(v),None,ty)       //Attribute Value has always a upper-bound of 1 that means one attribute => max one value
	}
    

   private def createNode(rn: RNode):Node={
		rn match {
		  case RNode(Some(name),Some(nId),ty) =>
		  	curMGraph.getNode(nId) match{
		  	  	case Some(n) => if(name!=curMGraph.names(n.id)){
		  	  						sys.error("Node with id=" +  n.id + " must have a unique name.")
		  	  					}else n
		  	  	case None => curMGraph.addNode(name,ty,nId) match {
			  			   		case None => sys.error("Node could be created:" + name + ":" + ty)
			  			   		case Some(x) => x
			  			   	 }
		  	}
		  case RNode(Some(name),None,ty) =>
		    curMGraph.findNode(name) match {
				case Some(x) =>  x 
				case None    =>  curMGraph.addNode(name, ty) match{
				  			   		case None => sys.error("Node could be created:" + name + ":" + ty)
				  			   		case Some(x) => x
				  			   	 }
			}
		   case RNode(None,Some(value),ty) =>	
		     	curMGraph.addVNode(value,ty) match {
					case Some(x) =>  x 
					case None    =>  sys.error("Programming sys.error")
				}
			case _ => sys.error("Programming sys.error")	
		}
    }
	
    private def createArrow(ra: RArrow):Arrow={
		ra match {
		 //Usual arrow:
	     case RArrow(name,None,rn1,Some(rn2),None,ty) =>	
		  	
		    val n1 = createNode(rn1)
		    val n2 = createNode(rn2)

				curMGraph.findArrow(name,n1,n2) match {
					case Some(x) =>  x
					case None 	 =>
				    	curMGraph.addArrow(name,n1,n2,ty) match{
		    		    	case None => sys.error("Arrow could not be created:" + name + " " + n1 + "->" + n2 + ":" + ty)
		    		    	case Some(x) => x 
				    	}
				}
	     
	     case RArrow(name,Some(id),rn1,Some(rn2),None,ty) =>	
		  	
		    val n1 = createNode(rn1)
		    val n2 = createNode(rn2)

				curMGraph.getArrow(id) match {
					case Some(x) =>  if(x.sr != n1 || x.tg != n2 || x.t != ty || curMGraph.names(id) != name){
										sys.error("Arrow with id" + id + " must have a unique definition!")
									 };x
					case None 	 =>
				    	curMGraph.addArrow(name,n1,n2,ty,id) match{
		    		    	case None => sys.error("Arrow could not be created:" + name + " " + n1 + "->" + n2 + ":" + ty)
		    		    	case Some(x) => x 
				    	}
				}
		  //Attribute Type:		  
		  case RArrow(name,None,rn1,None,Some(at),TypeArrow.TAttribute()) =>
		  	
		  	val n1 = createNode(rn1)
			curMGraph.findArrow(name,n1,at) match {
					case Some(x) =>  x 
					case None 	 =>
						curMGraph.addAArrow(name,n1,at,TypeArrow.TAttribute()) match{
					    	case None => sys.error("Attribute-Arrow could not be created:" + name + " " + n1 + "->" + at + ":" + TypeArrow.TAttribute())
					    	case Some(x) => x
					    }	
			}
		  	
		  case RArrow(name,Some(id),rn1,None,Some(at),TypeArrow.TAttribute()) =>
		  	
		  	val n1 = createNode(rn1)
		  	
			curMGraph.getArrow(id) match {
					case Some(x) =>  if(x.sr != n1 || x.tg != at || x.t != TypeArrow.TAttribute() || curMGraph.names(id) != name){
										sys.error("Arrow with id" + id + " must have a unique definition!")
									 };x 
					case None 	 =>
						curMGraph.addAArrow(name,n1,at,TypeArrow.TAttribute(),id) match{
					    	case None => sys.error("Attribute-Arrow could not be created:" + name + " " + n1 + "->" + at + ":" + TypeArrow.TAttribute())
					    	case Some(x) => x
					    }	
			}
		  	
		  case _ => sys.error("Programming sys.error")  
		}
    }  

   /**
    * Attention algortihms must correspond to method in no.dpf.text.graph.validation.Helper.createShape
    */
   private def createShape(rarrows:List[RArrow]):List[Arrow]={
     var counter=0;
	 val virtualIds = MMap[String,VId]()
	 def getId(s:String):VId={
	   if(virtualIds.contains(s)){
	     virtualIds(s)
	   }else{
	     counter+=1
		 virtualIds+=s->VId(counter) 
		 getId(s)
	   }
	 }
	 val r = for(ra<-rarrows)yield{
		 ra match {
	     case RArrow(name,_,RNode(Some(n1),_,t1),Some(RNode(Some(n2),_,t2)),_,ty) => Arrow(getId(name),Node(getId(n1),t1),Node(getId(n2),t2),ty)
	     case RArrow(name,_,RNode(Some(n1),_,t1),_,Some(n2),ty) => Arrow(getId(name),Node(getId(n1),t1),n2,ty)
		     case _ => sys.error("Programming Error")
	     }	
	 }
//     println(rarrows)
//     println(r)
     r
   }
    
   private def createSConstraint(dpfid:Option[Id],n:String,ps:List[String]):SignatureConstraint ={
     val rs:SignatureConstraint= dpfid match{
       case Some(id) => SignatureConstraint(id,n,ps)
       case None 	 => curSignatureConstraints.get((n,ps)) match{
         					case Some(s) => s 
         					case None => SignatureConstraint(GCtx.gen(),n,ps) 
       					}
     }
     curSignatureConstraints+=(rs.n,rs.p)->rs
     rs 
   } 

   private def createValidator(id:Option[Id],n:String,as:List[List[RArrow]],v:List[OclToken]):Validator={
		id match{	
		  case Some(id) => Validator(id,createShape(as.flatten),compressOCL(v)) 
		  case None 	=> {
		    curTS.cs.find(c=>c.s.n==n) match{
		      case None => sys.error("Constraint does not exist:" + n);
		      case Some(c) => Validator(c.s.id,createShape(as.flatten),compressOCL(v))
		    }
		  }
		}   
   }
   
   private def findNode(rn: RNode):Node={
		rn match {
		  case RNode(_,Some(nId),ty) =>
		  	curSGraph.getNode(nId) match{
		  	  	case Some(n) => n
		  	  	case None    => sys.error("Node not found:" + rn)
		  	}
		  case RNode(Some(name),None,ty) =>
		    curSGraph.findNode(name) match {
				case Some(x) =>  x 
				case None    =>  sys.error("Node not found:" + rn)
			}
		   case _ => sys.error("Node not found:" + rn)	
		}
    }
    
    private def findArrow(ra: RArrow):Arrow={
		ra match {
		 //Usual arrow:
	     case RArrow(name,None,rn1,Some(rn2),None,ty) =>	 	
		    val n1 = findNode(rn1)
		    val n2 = findNode(rn2)
			curSGraph.findArrow(name,n1,n2) match {
				case Some(x) =>  x
				case None 	 =>  sys.error("Arrow could not be found:" + name + " " + n1 + "->" + n2 + ":" + ty)
			}
	     case RArrow(name,Some(id),rn1,Some(rn2),None,ty) =>	
		    val n1 = findNode(rn1)
		    val n2 = findNode(rn2)
			curSGraph.getArrow(id) match {
				case Some(x) =>  if(x.sr != n1 || x.tg != n2 || x.t != ty || curMGraph.names(id) != name){
									sys.error("Arrow with id" + id + " must have a unique definition!")
								 };x
				case None 	 =>  sys.error("Arrow could not be found:" + name + " " + n1 + "->" + n2 + ":" + ty)
			}
		  //Attribute Type:		  
		  case RArrow(name,None,rn1,None,Some(at),TypeArrow.TAttribute()) =>
		  	val n1 = findNode(rn1)
			curSGraph.findArrow(name,n1,at) match {
					case Some(x) =>  x 
					case None 	 =>  sys.error("Attribute-Arrow could not be found:" + name + " " + n1 + "->" + at + ":" + TypeArrow.TAttribute())
			}	  	
		  case RArrow(name,Some(id),rn1,None,Some(at),TypeArrow.TAttribute()) =>		  	
		  	val n1 = findNode(rn1)
			curSGraph.getArrow(id) match {
					case Some(x) =>  if(x.sr != n1 || x.tg != at || x.t != TypeArrow.TAttribute() || curMGraph.names(id) != name){
										sys.error("Arrow with id" + id + " must have a unique definition!")
									 };x 
					case None 	 => sys.error("Attribute-Arrow could not be found:" + name + " " + n1 + "->" + at + ":" + TypeArrow.TAttribute())
			}		  	
		  case _ => sys.error("Programming sys.error")  
		}
    }  
    
    
    private def createConstraint(name:SignatureConstraint,as:List[RArrow]):Constraint={
      Constraint(name,for(a<-as) yield findArrow(a))	
	}	

    
    private def compressOCL(l:List[OclToken]):List[OclToken]={
       var lString:List[Char]  =Nil
       var lOcl:List[OclToken] =Nil
       for(t<-l) t match {
         case s@OclString(_) =>  lOcl=(s::lOcl)
         case OclChar(c) => lString=(c::lString)
         case p@_ => {
        	 	val tString = lString.reverse.mkString;
        	 	if(!tString.isEmpty){lOcl=(OclString(tString)::lOcl)}
        	 	lString=Nil
        	 	lOcl=(p::lOcl)
        	 }
       }
 	   val tString = lString.reverse.mkString;
       if(!tString.isEmpty){lOcl=(OclString(tString)::lOcl)}
       lOcl.reverse
    }
    
	private def fillCurGraph(rElems:List[RElement]):MGraph={
	  rElems foreach(x => x match {
	    	case rn@RNode(_,_,_) 		=> createNode(rn) 
	    	case ra@RArrow(_,_,_,_,_,_) => createArrow(ra)
	      	case _ => sys.error("Programming sys.error")
	  	  }
	  )
	  curMGraph
	}
	
	def writeFile(fname:String, contents:Any)={
		import java.io._
		val writer = new java.io.PrintWriter(fname)
		val mm = new ByteArrayOutputStream()
		try {
			writer.println("""<?xml version="1.0" encoding="UTF-8"?>""");
			writer.print(contents)
		}finally {
			writer.close
		}	
		println("File created: " + fname)
	}
	
	def printEcore(n:String)={
		import java.io._
		import no.dpf.text.graph.ecore.EcoreGenerator
		writeFile(outDir + n + ".ecore",EcoreGenerator.graph2EcoreM(tGraphs(n),n))
		writeFile(outDir + n + "_simple.ecore",EcoreGenerator.graph2EcoreM_simple(tGraphs(n),n))
	}

	def printEmf(n:String)={
		import java.io._
		import no.dpf.text.graph.ecore.EcoreGenerator
		def ecoreName():String = {
		  for(k <- tGraphs.keys){
		    if(tGraphs(k)==tGraphs(n).mmGraph){
		      return k
		    }  
		  }
		  return "Error"
		} 		
		writeFile(outDir + n + ".xmi",EcoreGenerator.graph2EcoreI(tGraphs(n),ecoreName))
		writeFile(outDir + n + "_simple.xmi",EcoreGenerator.graph2EcoreI_simple(tGraphs(n),ecoreName + "_simple"))
	}
	
	//Handle Escaped Strings and comments:
	def readFile(f:String):String={		
		
		val comment = """//""".r
		val ccomentBegin = """/*"""
		val ccomentEnd = """*/"""	
		
		val escString = "\"".r
		val magic = "*}D}p{F{*"

   		val lines  = scala.io.Source.fromFile(f)
		var file:List[String] = Nil 
   		var inComment=false;  
   		var inEscString=false;  
 		
   		//Exclude c-comments
		def excludeCComments(l:String):String={
		  var temp = l
		  val r = new StringBuilder()
		  if(!inComment){			  
			  val bC = temp.indexOf(ccomentBegin)
			  if(bC > -1){
			    r++=temp.substring(0,bC) //til comment
			    temp = temp.substring(bC) 
			    inComment=true
			  }else{
			    r++=temp
			  }
		  }	  
		  if(inComment){
			 val eC =temp.indexOf(ccomentEnd) 
			 if(eC > -1){
				 temp=temp.substring(eC+ccomentEnd.length) //from comment
				 inComment=false
				 r++=excludeCComments(temp)
			 }			 
		  }
		  r.mkString
		} 
  
		//Handle Escaped Strings:
		def handleEscapedStrings(l:String):String={
  		  import java.net.URLEncoder
		  val temp = escString.split(l.replaceAllLiterally("\\\"",magic))
		  val r= new StringBuilder()
		  for(i<-0 to temp.length-1){
			  if(0 == i % 2){
			    r++=temp(i)
			  }else{
			    r++="\"" 
			    r++=URL_ENCODED  
			    r++= URLEncoder.encode(temp(i).replaceAllLiterally(magic,"\""),"UTF-8")
			    r++="\""
			  }
		  }
 		  r.mkString
		}

		
		var addLine = ""
   		for(l<-lines.getLines()){
		  
		  //Eclude Comments:
		  val temp1 = comment.split(l)
		  if(temp1.length > 0){
		    addLine=temp1(0) 
		  }		  
		  //Eclude C-Comments:
		  addLine=excludeCComments(addLine)
		  
		  //Read Escaped Strings:
		  addLine=handleEscapedStrings(addLine)
		  
		  file=(addLine::file)
		}
		file.reverse.mkString
	}

	
	private def decodeString(s:String):String={
	  import java.net.URLDecoder
	  val prefix = "\""+ URL_ENCODED
	  if(s.startsWith(prefix)){
	    return URLDecoder.decode("\""+ s.stripPrefix(prefix),"UTF-8")
	  }else{
	    return s
	  }
	}		
	
}


object Main extends Parser(GraphDpf, "DPF") 
{
	import no.dpf.text.graph.validation.eclipse._
//	import no.dpf.text.graph.validation.dresden._
	def main(args:Array[String]) = {
 
	initParser()  
	  
	//readFile("file1.txt")
	if(0<args.length)inFile = args(0)
	if(1<args.length)outDir = args(1)
	val parseR = parseAll(definitions,readFile(inFile)).get
	//		println(parseR)
	
	//Only in Eclipse OCL:
//  EMFtoCSP has a bug right now, bugreport submitted	
//	println("Check conflicting constraints in specification:")
//	parseR foreach (_ match {case is@IS(_,_,_) => Validation.checkOclDefintion(is);case _ =>;});
	//
	
	println("Validate OCL")
	val ds = System.currentTimeMillis();
	parseR foreach (_ match {case is@IS(_,_,_) => Validation.validate(is);case _ =>;});
	println("OCL-check:" + (System.currentTimeMillis()-ds))

}

}
