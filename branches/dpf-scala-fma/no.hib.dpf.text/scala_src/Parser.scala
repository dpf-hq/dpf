package no.hib.dpf.text.graph.parser;

import scala.util.parsing.combinator._
import no.hib.dpf.text.graph._
import no.hib.dpf.text.graph.mutable.{Graph=>MGraph}
import no.hib.dpf.text.graph.mutable.{ExtSubGraph=>MExtSubGraph}
import scala.collection.mutable.{Map=>MMap}
import scala.collection.mutable.{Set=>MSet}
import no.hib.dpf.text.coevolution._
import no.hib.dpf.text.output.graphviz.Output
import no.hib.dpf.text.output.parser.{Output=>POutput}

//
//Companion Object:
//
object Parser{

	//Specification vars:
	val specs:MMap[String,S] = MMap("DPF"->Dpf)	
	
	//Graph vars:
	val tGraphs:MMap[String,AbstractGraph]	= MMap("DPF"->GraphDpf)
}

//
//Class:
//
class Parser(mmSpecification:S, mmName:String, nextSeq: Long) extends JavaTokenParsers with Converter with Output with POutput{
    import no.hib.dpf.text.graph.parser.Parser._;
	   
	//Ids:
	object GCtx{
		private var _next = nextSeq-1 	
		def setNext(value:Int):Unit = _next=value-1
		def gen()= {
		  _next+=1;
		  RId(_next);
		}
	}	
	
	//Input and output:
	var inFile="file.tdpf"
	var outDir=""
	
	//Specification vars:
//	private var specs:MMap[String,S] = null	
	
	//Graph vars:
//	private var tGraphs:MMap[String,AbstractGraph]	= null
	private var gMorphisms:MMap[String,Morphism]	= null
	private var gMorphismsCoDomain:MMap[String,(String,String)]	= null
	private var curTGraph:AbstractGraph = null 	//current type graph
	protected var curMGraph:MGraph = null         //current model graph
	private var curSGraph:AbstractGraph = null    //current specification graph
	protected var curTS:S = null					    //current specification type graph
	private var curSignatureConstraints:MMap[(String,List[String]),SignatureConstraint] = null  //ids of constraints of current specification
	private var curDomain:AbstractGraph = null	    //current domain type graph (for creating morphism on one model level)
	private var curCodomain:AbstractGraph = null  //current codomain type graph (for creating morphism on one model level)
	
	protected def initParser()={
  	  
	  //Specification vars:
	  if(!mmName.isEmpty()){
		  specs +=(mmName->mmSpecification);
		  tGraphs+=(mmName->mmSpecification.g);
		  curTGraph = mmSpecification.g  //current type graph
	  }else{
		  curTGraph = specs("DPF").g     //current type graph	    
	  }
	  
	  gMorphisms = MMap();
	  gMorphismsCoDomain = MMap();
	  
	  curMGraph = null              //current model graph
	  curSGraph = null  	         //current specification graph
	  curTS = null			         //current specification type graph
	  curSignatureConstraints = MMap[(String,List[String]),SignatureConstraint]() //ids of constraints of current specification
	  
	  curDomain = null
	  curCodomain = null
	}
	
	
	def mTGraphs(name:String):mutable.Graph = tGraphs(name) match{
		case x:mutable.Graph => x
		case x:AbstractGraph => error("Graph with name '" + name + "' is not mutable!") 
		case _ 				 => error("Graph with name '" + name + "' does not exist!")
	}

	//
	//Own Elements;
	//
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
	                  
	case class ParseResult(element:Option[Element],error:Option[String]); 	                  
	case class RParseResult(element:Option[RElement],error:Option[String]); 	                  
	                  
//
//Terminal
//
	val ID:     Parser[String] = """[a-zA-Z_]\w*""".r
	val ID_A:   Parser[String] = """[a-zA-Z_]\w*|\*""".r
	val DPF_ID: Parser[String] = """[0-9]|([1-9][0-9])+""".r
	val CPARAM: Parser[String] = """[a-zA-Z_]*[0-9]*""".r
	val OCL: Parser[String] = """[^#$]""".r	
	val P_NUM: Parser[String] = """[0-9]|([1-9][0-9])+""".r
	
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
	var isOCL = true

	//
	//Grammar:
	//
	
	//OCL expressions:
	def ocl: Parser[List[OclToken]] = repsep(ocl_pars,"") ^^ {case ocl => ocl}
	def ocl_pars:   Parser[OclToken]   = ocl_pp | ocl_pe | ocl_char ^^ {case d => d}
	def ocl_pp:     Parser[OclPp] = "#"~P_NUM~"#" ^^ {case "#"~p~"#" => OclPp(p.toInt)}
	def ocl_pe:     Parser[OclPe] = "#"~ID~"#" ^^ {case "#"~p~"#" => OclPe(p)}
	def ocl_char:   Parser[OclChar] = OCL   ^^ {case c=> OclChar(c.toCharArray()(0))}
	def ocl_start:  Parser[Any] = "$" ^^ {case c=> isOCL = true}
	def ocl_stop:   Parser[Any] = "$"  ^^ {case c=> isOCL = false}

	//"Program":
//	def definitions: Parser[List[Any]] = repsep(definition,"") ^^ {case defs => defs}
	
//	def definition: Parser[Any] = ispec | spec | tgraph | extsubtgraph | emf | ecore | image | simpleEvoSpan | simpleEvoCospan | gmorphism | evoSpan | evoCospan ^^ {case d => d}
	
	def emf: Parser[Any] = "emf("~ID~")" ^^ { case "emf("~i~")" => printEmf(i)}
	
	def ecore: Parser[Any] = "ecore("~ID~")" ^^ { case "ecore("~i~")" => printEcore(i)}
	
	def image: Parser[Any] = "image("~ID~")" ^^ { case "image("~i~")" => createEps(i)}
	
	def simpleEvoSpan: Parser[Any] = "simpleEvolution("~ID~"<-"~ID~"->"~ID~","~ID~")" ^^ { case "simpleEvolution("~tl~"<-"~tk~"->"~tr~","~g~")" => 
	    SimpleCoevolutionSpan(tGraphs(tl),tGraphs(tk),tGraphs(tr),tGraphs(g),GCtx.gen).print(outDir)
	}

	def simpleEvoCospan: Parser[Any] = "simpleEvolution("~ID~"->"~ID~"<-"~ID~","~ID~")" ^^ { case "simpleEvolution("~tl~"->"~ti~"<-"~tr~","~g~")" => 
	    val x = SimpleCoevolutionCospan(tGraphs(tl),tGraphs(ti),tGraphs(tr),tGraphs(g),GCtx.gen)
	    x.print(outDir)
	  	val H = x.H.normalize(GCtx.gen)
	  	val TH = H.mmGraph
	  	serializeSpecification(S(TH,Set()),"TH","DPF",GCtx.gen().v,outDir)
	  	serializeSpecification(S(H,Set()),"H","TH",GCtx.gen().v,outDir)
	}

	def evoSpan: Parser[Any] = "evolution("~ID~"<->"~ID~","~ID~")" ^^ { case "evolution("~l~"<->"~r~","~g~")" => 
	  	val codo1 = gMorphismsCoDomain(l)
	  	val codo2 = gMorphismsCoDomain(r)
	  	CoevolutionSpan(tGraphs(codo1._2),tGraphs(codo1._1),tGraphs(codo2._2),tGraphs(g),gMorphisms(l),gMorphisms(r),GCtx.gen).print(outDir)
	}
	
	def evoCospan: Parser[Any] = "evolution("~ID~"-><-"~ID~","~ID~")" ^^ { case "evolution("~l~"-><-"~r~","~g~")" => 
	  	val codo1 = gMorphismsCoDomain(l)
	  	val codo2 = gMorphismsCoDomain(r)
	  	val x = CoevolutionCospan(tGraphs(codo1._1),tGraphs(codo1._2),tGraphs(codo2._1),tGraphs(g),gMorphisms(l),gMorphisms(r),GCtx.gen);
	  	x.print(outDir)
	  	val H = x.H.normalize(GCtx.gen)
	  	val TH = H.mmGraph
	  	serializeSpecification(S(TH,Set()),"TH","DPF",GCtx.gen().v,outDir)
	  	serializeSpecification(S(H,Set()),"H","TH",GCtx.gen().v,outDir)
	}

//	//Graph morphism:
//	def gmorphism : Parser[Morphism] = ID~":="~"Morphism<"~domain~","~codomain~">"~mappings ^^ {case n~":="~"Morphism<"~d~","~c~">"~m => saveMorphism(n,m,d,c)} //Save map in buffer
//
//	def domain : Parser[String] = ID ^^ {case i => curDomain=tGraphs(i);i}
//	
//	def codomain : Parser[String] = ID ^^ {case i => curCodomain=tGraphs(i);i}	
//	
//	def mappings : Parser[List[(Element,Element)]] = "{"~repsep(mapping,",")~"}"  ^^ {case "{"~l~"}" => l}
//	
//	def mapping : Parser[(Element,Element)] = mapping_node | mapping_arrow ^^ {case i => i}
//	
//	def mapping_node : Parser[(Element,Element)] = node~"=>"~node ^^ {case n1~"=>"~n2 => (findNode(n1,curDomain),findNode(n2,curCodomain))}
//	
//	def mapping_arrow : Parser[(Element,Element)] = arrow~"=>"~arrow ^^ {case a1~"=>"~a2 => (findArrow(a1,curDomain),findArrow(a2,curCodomain))}
//	
//	
//	//Typed subgraphs:
//	def extsubtgraph : Parser[MGraph] = ID~":="~"ExtSubTGraph<"~tnameextsub~">"~graph ^^ {case n~":="~"ExtSubTGraph<"~t~">"~g => saveTGraph(n,g)} //Save map in buffer
//	
//	def tnameextsub : Parser[String] = ID ^^ {case i => createExtSubGraph(i)}
//
//	//Typed graphs:
//	def tgraph : Parser[MGraph] = ID~":="~"TGraph<"~tname~">"~graph ^^ {case n~":="~"TGraph<"~t~">"~g => saveTGraph(n,g)} //Save map in buffer
//	
//	def tname : Parser[String] = ID ^^ {case i => createGraph(i)}
//	
//	def graph : Parser[MGraph] = ("{"~repsep(expr,"")~"}" ^^ {case "{"~elements~"}" => fillCurGraph(elements.flatten)})
//	
//	def expr : Parser[List[RElement]] = ( node~","^^ {case n~"," => List(n)}
//	 								   | arrows~"," ^^ {case a~"," => a})
//							  															
	protected def saveSpec(n:String,s:S):S={
	  //	  
	  //Remove the Specifications that have the old one as type:
	  //
	  specs.get(n) match {
	    case Some(old) =>
	      for(t<-specs){
	        var temp = t._2.g;
	        var remove = false;
	        while(temp != GraphDpf){
	          if(temp == old.g){
	            remove = true;
	          }
	          temp = temp.mmGraph;
	        }
	        if(remove){
	          specs-=t._1;
	          println("Remove Specification: " + t._1)
	        }
	      }
	    case None => /*do nothing*/  
	  }

	  specs+=n->s
	  println("Save Specification: " + n)
	  s
	}		
	
	protected def saveTGraph(n:String,g:MGraph):MGraph={
	  //		
	  //Remove the Graphs that have the old one as type:
	  //
	  tGraphs.get(n) match {
	    case Some(old) =>
	      for(t<-tGraphs){
	        var temp = t._2;
	        var remove = false;
	        while(temp != GraphDpf){
	          if(temp == old){
	            remove = true;
	          }
	          temp = temp.mmGraph;
	        }
	        if(remove){
	        	tGraphs-=t._1;
	        	println("Remove Graph: " + t._1)
	        }
	      }
	    case None => /*do nothing*/  
	  }

	  tGraphs+=n->g;
	  
	  //Generate Standard Specification:
	  specs+=n->S(g,Set())
	  println("Save Graph: " + n)	  
	  g
	}	
	
	private def saveMorphism(n:String,m:List[(Element,Element)],domain:String,codomain:String):Morphism={
	  
	  val domainNodes = MSet[Node]();
	  val codomainNodes = MSet[Node]();
	  val domainArrows = MSet[Arrow]();
	  val codomainArrows = MSet[Arrow]();
	  
	  val nodes = MSet[(Option[Node],Node)]();
	  val arrows = MSet[(Option[Arrow],Arrow)]();
	  
	  for(e<-m){
	    e match{
	      case (n1@Node(_,_),n2@Node(_,_)) =>
	        	
	        	domainNodes+=n1;
	        	codomainNodes+=n2;
	        	
	        	//Add to Set:
	        	val tuple=(Some(n1),n2)
	        	nodes+=tuple
	        	
	      case (a1@Arrow(_,_,_,_),a2@Arrow(_,_,_,_)) => 
	        	domainArrows+=a1;
	        	codomainArrows+=a2;
	        	domainNodes+=a1.sr;
	        	domainNodes+=a1.tg;
	        	codomainNodes+=a2.sr;
	        	codomainNodes+=a2.tg;

	        	//Add to Set:
	        	val tuple=(Some(a1),a2)
	        	arrows+=tuple
	        
	      case _ => error("Programming error! " +  e)  
	    }	    
	  }	  
	  
	  //Check if all arrows and nodes are mapped:
	  val c1 = curDomain.nodes.values.toSet--domainNodes;
	  if(!c1.isEmpty){
	    error("Not all nodes mapped: " + c1.mkString)
	  }
	  val c2 = curDomain.arrows.values.toSet--domainArrows;
	  if(!c2.isEmpty){
	    error("Not all arrows mapped: " + c2.mkString)
	  }

	  //Add unmapped codomain arrows and nodes:
	  for(n<-(curCodomain.nodes.values.toSet--codomainNodes)){
	    val tuple = (None,n)
	    nodes+=tuple
	  }
	  for(a<-(curCodomain.arrows.values.toSet--codomainArrows)){
	    val tuple = (None,a)
	    arrows+=tuple
	  }
	  
	  gMorphisms+=n->ArbitraryMorphism(nodes.toSet,arrows.toSet)
	  val tuple = (domain,codomain)
	  gMorphismsCoDomain+=n->tuple
	  gMorphisms(n)
	}	
	
	protected def initSpec(i:String)={
		//Choose Graph for specification:	
		curSGraph=tGraphs(i);
		//Choose TGraph of specification Graph:
		curTGraph=curSGraph.mmGraph;
		//Empty buffer for constraint ids:
		curSignatureConstraints=curSignatureConstraints.empty; 
		curSGraph	  
	}
									
	protected def createGraph(mmName:String)={
		//Init Graph:
		curTGraph=tGraphs(mmName);
		curMGraph=new MGraph(curTGraph,GCtx.gen);
		mmName	
	}

	private def createExtSubGraph(mmName:String)={
		//Init Graph:
	    val parent=tGraphs(mmName); 
		curTGraph=parent.mmGraph;
		curMGraph=new MExtSubGraph(parent,GCtx.gen);
		mmName	
	}
	
    protected def createRNode(name:String, id:Option[Id], t:String, typeId:Option[Id]):RParseResult={
		typeId match{	
		  case None =>
				if("_" == t){
					RParseResult(Some(RNode(Some(name),id,TypeNode.TJoker())),None);				  
				}else{
			    	val result = curTGraph.findNode(t)
				    val ty =
				    result match {
				    	case None => return RParseResult(None,Some("Node Type does not exit! t="+t));
				    	case Some(x) => x
				    }
					RParseResult(Some(RNode(Some(name),id,ty)),None);
				}
		  case Some(tId) =>
		  		val result = curTGraph.getNode(tId)
			    val ty =
			    result match {
			    	case None => return RParseResult(None,Some("Node Type does not exit! id="+tId));
			    	case Some(x) => x
			    }
		  		RParseResult(Some(RNode(Some(name),id,ty)),None);
		}
	}    
    
    protected def createRArrow(name:String,id:Option[Id],n1:RNode,n2:RNode,t:String,typeId:Option[Id]):RParseResult={
		typeId match{	
		  case None =>
				if("_" == t){
					RParseResult(Some(RArrow(name,id,n1,Some(n2),None,TypeArrow.TJoker())),None);
				}else{
			      val result = curTGraph.findArrow(t,n1.t,n2.t)
				  val ty= result match {
				      case None => return RParseResult(None,Some("Type does not exit! t="+t + " sr=" + n1.t + " tg=" + n2.t));
				      case Some(x) => x
				  }
				  RParseResult(Some(RArrow(name,id,n1,Some(n2),None,ty)),None);
				}  
		  case Some(tId) =>
		      val result = curTGraph.getArrow(tId)
			  val ty= result match {
			      case None => return RParseResult(None,Some("Type does not exit! id=" + tId))
			      case Some(x) => if(x.sr!=n1.t || x.tg!=n2.t){
			    	  				return RParseResult(None,Some("Type with id=" + tId + " is not compatible with source and target!"));	
			      				  }else x 
			  }
			  RParseResult(Some(RArrow(name,id,n1,Some(n2),None,ty)),None);
		}
    }
 
    protected def createRAttributeType(name:String,id:Option[Id],n1:RNode,at:Node with TypeP,t:String):RParseResult={
		if("*" != t) return RParseResult(None,Some("Attribute arrow has to have type *"));
		RParseResult(Some(RArrow(name,id,n1,None,Some(at),TypeArrow.TAttribute())),None);
	}
	
	protected def createRAttributeValue(name:String,id:Option[Id],n1:RNode,rav:String,t:String,typeId:Option[Id]):RParseResult={
		val result = typeId match{
		    case None =>  curTGraph.findArrow(t,n1.t)
  		  	case Some(tId) => curTGraph.getArrow(tId)
		}
		val ty = result match {
	    	case None => return RParseResult(None,Some("Attribute does not exit! t="+t + " sr=" + n1.t));
	    	case Some(x) => x
	    }
	    val value = ty.tg match {
	    	case tc:TypeP => tc.toValue(rav)
	    	case _ => return RParseResult(None,Some("Programming error in createAttributeValue"));
	    }
	    val v = RNode(None,Some(value),ty.tg) 	 					//Only return inside Arrow (is not a problem here)
	    RParseResult(Some(RArrow(name,id,n1,Some(v),None,ty)),None);//Attribute Value has always a upper-bound of 1 that means one attribute => max one value
	}
    

   protected def createNode(rn: RNode):ParseResult={
		rn match {
		  case RNode(Some(name),Some(nId),ty) =>
		  	curMGraph.getNode(nId) match{
		  	  	case Some(n) => if(name!=curMGraph.names(n.id)){
		  	  						ParseResult(None,Some("Node with id=" +  n.id + " must have a unique name."));
		  	  					}else{
		  	  					    ParseResult(Some(n),None);
		  	  					} 
		  	  	case None => curMGraph.addNode(name,ty,nId) match {
			  			   		case None => ParseResult(None,Some("Node could be created:" + name + ":" + ty));
			  			   		case Some(x) => ParseResult(Some(x),None);
			  			   	 }
		  	}
		  case RNode(Some(name),None,ty) =>
		    curMGraph.findNode(name) match {
				case Some(x) =>  ParseResult(Some(x),None); 
				case None    =>  curMGraph.addNode(name, ty) match{
				  			   		case None => ParseResult(None,Some("Node could be created:" + name + ":" + ty));
				  			   		case Some(x) => ParseResult(Some(x),None);
				  			   	 }
			}
		   case RNode(None,Some(value),ty) =>	
		     	curMGraph.addVNode(value,ty) match {
					case Some(x) =>  ParseResult(Some(x),None); 
					case None    =>  error("Programming error")
				}
			case _ => error("Programming error")	
		}
    }
	
    protected def createArrow(ra: RArrow):ParseResult={
		ra match {
		 //Usual arrow:
	     case RArrow(name,None,rn1,Some(rn2),None,ty) =>	
		  	
		    val n1 = createNode(rn1) match{
		      			case ParseResult(Some(n),None) => n.asInstanceOf[Node];
		      			case r@ParseResult(None,_) => return r;
		      			case _ => error("Programming error");
		    		 }
		    val n2 = createNode(rn2) match{
		      			case ParseResult(Some(n),None) => n.asInstanceOf[Node];
		      			case r@ParseResult(None,_) => return r;
		      			case _ => error("Programming error");
		    		 }

				curMGraph.findArrow(name,n1,n2) match {
					case Some(x) =>  ParseResult(Some(x),None);
					case None 	 =>
				    	curMGraph.addArrow(name,n1,n2,ty) match{
		    		    	case None => ParseResult(None,Some("Arrow could not be created:" + name + " " + n1 + "->" + n2 + ":" + ty))
		    		    	case Some(x) => ParseResult(Some(x),None); 
				    	}
				}
	     
	     case RArrow(name,Some(id),rn1,Some(rn2),None,ty) =>	
		  	
		    val n1 = createNode(rn1) match{
		      			case ParseResult(Some(n),None) => n.asInstanceOf[Node];
		      			case r@ParseResult(None,_) => return r;
		      			case _ => error("Programming error");
		    		 }
		    val n2 = createNode(rn2) match{
		      			case ParseResult(Some(n),None) => n.asInstanceOf[Node];
		      			case r@ParseResult(None,_) => return r;
		      			case _ => error("Programming error");
		    		 }

				curMGraph.getArrow(id) match {
					case Some(x) =>  if(x.sr != n1 || x.tg != n2 || x.t != ty || curMGraph.names(id) != name){
										ParseResult(None,Some("Arrow with id" + id + " must have a unique definition!"))
									 }else{
									   ParseResult(Some(x),None);
		    						 }
					case None 	 =>
				    	curMGraph.addArrow(name,n1,n2,ty,id) match{
		    		    	case None => ParseResult(None,Some("Arrow could not be created:" + name + " " + n1 + "->" + n2 + ":" + ty))
		    		    	case Some(x) => ParseResult(Some(x),None); 
				    	}
				}
		  //Attribute Type:		  
		  case RArrow(name,None,rn1,None,Some(at),TypeArrow.TAttribute()) =>
		  	
		  	val n1 = createNode(rn1) match{
		      			case ParseResult(Some(n),None) => n.asInstanceOf[Node];
		      			case r@ParseResult(None,_) => return r;
		      			case _ => error("Programming error");
		    		 }
		  	
			curMGraph.findArrow(name,n1,at) match {
					case Some(x) =>  ParseResult(Some(x),None); 
					case None 	 =>
						curMGraph.addAArrow(name,n1,at,TypeArrow.TAttribute()) match{
					    	case None => ParseResult(None,Some("Attribute-Arrow could not be created:" + name + " " + n1 + "->" + at + ":" + TypeArrow.TAttribute()))
					    	case Some(x) => ParseResult(Some(x),None);
					    }	
			}
		  	
		  case RArrow(name,Some(id),rn1,None,Some(at),TypeArrow.TAttribute()) =>
		  	
		  	val n1 = createNode(rn1) match{
		      			case ParseResult(Some(n),None) => n.asInstanceOf[Node];
		      			case r@ParseResult(None,_) => return r;
		      			case _ => error("Programming error");
		    		 }
		  	
			curMGraph.getArrow(id) match {
					case Some(x) =>  if(x.sr != n1 || x.tg != at || x.t != TypeArrow.TAttribute() || curMGraph.names(id) != name){
										ParseResult(None,Some("Arrow with id" + id + " must have a unique definition!"));
									 }else{
										ParseResult(Some(x),None);
									 }	
					case None 	 =>
						curMGraph.addAArrow(name,n1,at,TypeArrow.TAttribute(),id) match{
					    	case None => ParseResult(None,Some("Attribute-Arrow could not be created:" + name + " " + n1 + "->" + at + ":" + TypeArrow.TAttribute()));
					    	case Some(x) => ParseResult(Some(x),None);
					    }	
			}

		  case _ => error("Programming error")  
		}
    }  

   /**
    * Attention algortihms must correspond to method in no.hib.dpf.text.graph.validation.Helper.createShape
    */
   private def createShape(rarrows:List[RArrow]):(Option[(List[Arrow],Map[String,Int],Map[String,Int])],Option[String])={
     var counter=0;
	 
     val virtualIds = MMap[String,VId]()
	 val varNodes   = MMap[Id,String]()
	 val varArrows  = MMap[Id,String]()
	 
	 //Create Virtual Ids and save these virtual Id mapping into a container:
	 def getId(s:String, save:MMap[Id,String]):VId={
	   if(virtualIds.contains(s)){
	     virtualIds(s)
	   }else{
	     counter+=1
	     val newId = VId(counter)
		 virtualIds+=s -> newId
		 save+=newId -> s
		 getId(s,save)
	   }
	 }
     
     //Create all arrows:
	 val r = for(ra<-rarrows)yield{
		 ra match {
	     case RArrow(name,_,RNode(Some(n1),_,t1),Some(RNode(Some(n2),_,t2)),_,ty) => Arrow(getId(name,varArrows),Node(getId(n1,varNodes),t1),Node(getId(n2,varNodes),t2),ty)
	     case RArrow(name,_,RNode(Some(n1),_,t1),_,Some(n2),ty) => Arrow(getId(name,varArrows),Node(getId(n1,varNodes),t1),n2,ty)
		     case _ => error("Programming Error")
	     }	
	 }
     
	 //Invariant:
	 val inter = varNodes.values.toSet.intersect(varArrows.values.toSet)
	 if(!inter.isEmpty){
	   return (None,Some("Arrows and nodes cannot use the same variables:" + inter))
	 }
	 
	 //Go through all arrows and save which variable has which position:
     var counterNode = 0;
     var counterArrow = 0;
	 val var2PosNodes   = MMap[String,Int]()
	 val var2PosArrows  = MMap[String,Int]()
	 for(a<-r){
       var2PosArrows+=varArrows(a.id)->counterArrow
       counterArrow+=1
       var2PosNodes+=varNodes(a.sr.id)->counterNode
       counterNode+=1
       var2PosNodes+=varNodes(a.tg.id)->counterNode
       counterNode+=1
     }
	 
//     println(rarrows)
//     println(r)
	 
     (Some(r,var2PosNodes.toMap,var2PosArrows.toMap),None)
   }
    
   protected def createSConstraint(dpfid:Option[Id],n:String,ps:List[String]):SignatureConstraint ={
     val rs:SignatureConstraint= dpfid match{
       case Some(id) => SignatureConstraint(id,n,ps)
       case None 	 => curSignatureConstraints.get((n,ps)) match{
         					case Some(s) => s 
         					case None => SignatureConstraint(GCtx.gen(),n,ps) 
       					}
     }
     curSignatureConstraints+=(rs.n,rs.ps)->rs
     rs 
   } 

   protected def createValidator(id:Option[Id],n:String,as:List[RArrow],v:List[OclToken]):(Option[Validator],Option[String])={
		
		//Create Shape:	
		createShape(as) match {
		  case (Some(rs), None) => /* No Error */
			
		    //Get Result:
		    val shape = rs._1 
			val nodeVars = rs._2
			val arrowVars = rs._3
			
			id match{	
			  case Some(id) => (Some(Validator(id,shape,nodeVars,arrowVars,compressOCL(v))),None) 
			  case None 	=> {
			    curTS.cs.find(c=>c.s.n==n) match{
			      case None => (None,Some("Constraint does not exist:" + n));
			      case Some(c) => (Some(Validator(c.s.id,shape,nodeVars,arrowVars,compressOCL(v))),None) 
			    }
			  }
			}
		    
		  case (None,Some(e)) => (None,Some(e))	/*Forward error*/
		  case (None,None) => error("Programming error in createValidator()")
		}
   }
   
   protected def findNode(rn: RNode, searchGraph:AbstractGraph=curSGraph):Tuple2[Option[Node],Option[String]]={
		rn match {
		  case RNode(_,Some(nId),ty) =>
		  	searchGraph.getNode(nId) match{
		  	  	case Some(n) => (Some(n),None)
		  	  	case None    => (None,Some("Node not found:" + rn))
		  	}
		  case RNode(Some(name),None,ty) =>
		    searchGraph.findNode(name) match {
				case Some(x) =>  (Some(x),None) 
				case None    =>  (None,Some("Node not found:" + rn))
			}
		   case _ => error("Programming error findNode")	
		}
    }
    
    protected def findArrow(ra: RArrow, searchGraph:AbstractGraph=curSGraph):Tuple2[Option[Arrow],Option[String]]={
		ra match {
		 //Usual arrow:
	     case RArrow(name,None,rn1,Some(rn2),None,ty) => 	
		    val n1 = findNode(rn1,searchGraph) match{
		  	  	case (Some(n),None) => n
		  	  	case (None,Some(s)) => return (None,Some(s))	
		  	  	case _ 		  => error("Programming error in findArrow")
		    }
		    val n2 = findNode(rn2,searchGraph) match{
		  	  	case (Some(n),None) => n
		  	  	case (None,Some(s)) => return (None,Some(s))	
		  	  	case _ 		        => error("Programming error in findArrow")
		    }
			searchGraph.findArrow(name,n1,n2) match {
				case Some(x) => (Some(x),None)
				case None 	 =>  (None,Some("Arrow could not be found:" + name + " " + n1 + "->" + n2 + ":" + ty))
			}
	     case RArrow(name,Some(id),rn1,Some(rn2),None,ty) =>  	
		    val n1 = findNode(rn1,searchGraph) match{
		  	  	case (Some(n),None) => n
		  	  	case (None,Some(s)) => return (None,Some(s))	
		  	  	case _ 		  => error("Programming error in findArrow")
		    }
		    val n2 = findNode(rn2,searchGraph) match{
		  	  	case (Some(n),None) => n
		  	  	case (None,Some(s)) => return (None,Some(s))	
		  	  	case _ 		         => error("Programming error in findArrow")
		    }
			searchGraph.getArrow(id) match {
				case Some(x) => if(x.sr != n1 || x.tg != n2 || x.t != ty || searchGraph.names(id) != name){
									(None,Some("Arrow with id" + id + " must have a unique definition!"));
								 }else{
								    (Some(x),None) 
								 }
				case None 	 =>  (None,Some("Arrow could not be found:" + name + " " + n1 + "->" + n2 + ":" + ty))
			}
		  //Attribute Type:		  
		  case RArrow(name,None,rn1,None,Some(at),TypeArrow.TAttribute()) =>  
		  	val n1 = findNode(rn1,searchGraph) match{
		  	  	case (Some(n),None) => n
		  	  	case (None,Some(s)) => return (None,Some(s))	
		  	  	case _ 		  		 => error("Programming error in findArrow")
		    }
			searchGraph.findArrow(name,n1,at) match {
					case Some(x) => (Some(x),None) 
					case None 	 =>  (None,Some("Attribute-Arrow could not be found:" + name + " " + n1 + "->" + at + ":" + TypeArrow.TAttribute()))
			}	  	
		  case RArrow(name,Some(id),rn1,None,Some(at),TypeArrow.TAttribute()) =>  		  	
		  	val n1 = findNode(rn1,searchGraph) match{
		  	  	case (Some(n),None) => n
		  	  	case (None,Some(s)) => return (None,Some(s))	
		  	  	case _ 		  		 => error("Programming error in findArrow")
		    }
			searchGraph.getArrow(id) match {
					case Some(x) =>  if(x.sr != n1 || x.tg != at || x.t != TypeArrow.TAttribute() || searchGraph.names(id) != name){
										(None,Some("Arrow with id" + id + " must have a unique definition!"))
									 }else{
										(Some(x),None)
									 }
					case None 	 => (None,Some("Attribute-Arrow could not be found:" + name + " " + n1 + "->" + at + ":" + TypeArrow.TAttribute()))
			}		  	
		  case _ => error("Programming error")  
		}
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
	      	case _ => error("Programming error")
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
		import no.hib.dpf.text.graph.ecore.EcoreGenerator
		writeFile(outDir + n + ".ecore",EcoreGenerator.graph2EcoreM(tGraphs(n),n))
		writeFile(outDir + n + "_simple.ecore",EcoreGenerator.graph2EcoreM_simple(tGraphs(n),n))
	}

	def printEmf(n:String)={
		import java.io._
		import no.hib.dpf.text.graph.ecore.EcoreGenerator
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
		
	def createEps(n:String)={
	   printSpecification(specs(n),n,outDir)
	}
		
}

object Main extends Parser(Dpf, "DPF",10) 
{
	import no.hib.dpf.text.graph.validation.eclipse._
	def main(args:Array[String]) = {
 
	initParser()  
	  
	//readFile("file1.txt")
	if(0<args.length)inFile = args(0)
	if(1<args.length)outDir = args(1)
	println("Parse File: " + inFile)
//	val parseR = parseAll(definitions,readFile(inFile)).get
	//		println(parseR)
	
	//Only in Eclipse OCL:
//  EMFtoCSP has a bug right now, bugreport submitted	
//	println("Check conflicting constraints in specification:")
//	parseR foreach (_ match {case is@IS(_,_,_) => Validation.checkOclDefintion(is);case _ =>;});
	
	println("Validate OCL")
	val ds = System.currentTimeMillis();
//	parseR foreach (_ match {case is@IS(_,_,_) => Validation.validate(is);case _ =>;});
	println("OCL-check:" + (System.currentTimeMillis()-ds))

}

}

