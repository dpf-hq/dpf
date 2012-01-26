package no.dpf.text.graph;
import scala.collection._;
import scala.collection.mutable.{Set=>MSet}

sealed trait Element{
	val id: Id
	val t:  Type
}
case class Node(override val id:Id, override val t:TypeNode) extends Element with TypeNode{
	override def equals(o: Any) = o match { 
		case n:Node => n.id == id 
		case _ => false 
	} 
}
case class Arrow(override val id:Id, sr:Node, tg:Node, override val t:TypeArrow) extends Element with TypeArrow{
	override def equals(o: Any) = o match { 
		case n:Arrow => n.id == id 
		case _ => false 
	} 
}


case class Graph(override val nodes: Map[Id,Node],  //Set
				 override val arrows: Map[Id,Arrow],//Set
				 override val in: Map[Node,Map[TypeArrow,Set[Arrow]]],
				 override val out: Map[Node,Map[TypeArrow,Set[Arrow]]],
				 override val names: Map[Id,String]) extends AbstractGraph(){
	override def arrowsIn(n: Node, t: TypeArrow):Set[Arrow] = if(in contains n)in(n)(t) else Set[Arrow]();  
	override def arrowsOut(n: Node, t: TypeArrow):Set[Arrow] = if(out contains n)out(n)(t) else Set[Arrow](); 
	override val toString = super.toString
}; 
trait Converter{
	implicit def typeNode2node(i:TypeNode):Node = i match { 
		case n: Node => n
		case _ => 	sys.error("Not matched:" + i)
					throw new ClassCastException
	}	
	implicit def typeArrow2arrow(i:TypeArrow):Arrow = i match { 
		case a: Arrow => a
		case _ => 	sys.error("Not matched:" + i)
					throw new ClassCastException
	}	
}
//Nodes and Arrows, In and Out
trait AbstractGraph{
	
	//Nodes and Arrows:
	//For each node all incoming/outgoing arrows of specific type:
	//Key-Arrow is type of all arrows in the set:
	val in: Map[Node,Map[TypeArrow,Set[Arrow]]]
	val out: Map[Node,Map[TypeArrow,Set[Arrow]]]
	
	val nodes:Map[Id,Node]   //Set (Changed to map for direct access)   		  
	val arrows:Map[Id,Arrow] //Set (Changed to map for direct access)
	
	val names:Map[Id,String]
	val mmGraph:AbstractGraph=this
	
	def contains(a: Arrow):Boolean = (arrows contains a.id) && arrows(a.id) == a;
	def contains(n: Node):Boolean =  (nodes contains n.id) && nodes(n.id) == n;
	
	def findArrow(n: String,s:Node,t:Node):Option[Arrow] = arrows.values find {e => n==names(e.id) && s== e.sr && t == e.tg}
	def findArrow(n: String,s:Node):Option[Arrow] = arrows.values find {e => n==names(e.id) && s== e.sr}  //ForAttributeTypes
	def findNode(n: String):Option[Node] = nodes.values find {e => !e.id.isInstanceOf[AValue] && n == names(e.id)}	
	
	def getArrow(id:Id):Option[Arrow] = arrows.get(id)
	def getNode(id:Id):Option[Node] = nodes.get(id)
	
	def iteratorNodes():Iterator[Node] = nodes.values.iterator	
	def iteratorArrows():Iterator[Arrow] = arrows.values.iterator
	
	def arrowsIn(n: Node, t: TypeArrow):Set[Arrow]
	def arrowsIn(n: Node):Set[Arrow] = if(in contains n)Set((in(n) map {_._2}).flatten toSeq: _ *) else Set[Arrow]();  
	def arrowsOut(n: Node, t: TypeArrow):Set[Arrow]
	def arrowsOut(n: Node):Set[Arrow] = if(out contains n)Set((out(n) map {_._2}).flatten toSeq: _ *) else Set[Arrow](); 
	
	override def toString="Graph(\n\t"+ nodesToString +",\n\t"+arrowsToString +"\n)";
	
	protected def nodesToString = (for(n <-nodes.values) yield format(n)).toSet 
	protected def arrowsToString = (for(a <-arrows.values) yield format(a)).toSet 
	
	def format(n:Node):String="Node(" + format(n.id) + "," + mmGraph.format(n.t) + ")";
	protected def format(n:TypeNode):String= n match {
		case n:Node => format(n)
		case o:TypeNode => o.toString 
	}
	
	def format(a:Arrow):String="Arrow(" + format(a.id) + "," + format(a.sr) + "->" + format(a.tg) + ":" + mmGraph.format(a.t) + ")";
	protected def format(a:TypeArrow):String= a match {
		case a:Arrow => format(a)
		case o:TypeArrow => o.toString 
	}
	
	protected def format(id:Id)={ 
		id match{
		case i:RId => names(i) + "@" + i
		case o:Id  => o.toString
		}
	}
	
}

case class SignatureConstraint(id:Id,n:String,p:List[String]) 
case class Validator(id:Id, shape: List[Arrow],ocl:List[OclToken]){
	//Parameter contained in constraint name
	//def validate(g:Graph):VResult={
	//  null
	//}   
}
//case class VResult(n:SignatureConstraint,msg:String)     //Validator result Typ?
case class Constraint(s:SignatureConstraint,as:List[Arrow]){
  def paramByNo(i:Int)= s.p(i)
  def nodeByNo(i:Int) = if(0 == i % 2) as(i/2).sr else as(i/2).tg
  def arrowByNo(i:Int)= as(i)
  /**
   * Give all positions of a specific node
   */
  def positions(n:Node)={
    val pos = MSet[Int]()
    var i = 0
    for(a<-as){
      if(a.sr == n){
        pos+=i
      }
      i+=1
      if(a.tg == n){
        pos+=i
      }
      i+=1
    }
    pos
  }
  /**
   * Give all positions of a specific arrow
   */
  def positions(e:Arrow)={
    val pos = MSet[Int]()
    var i = 0
    for(a<-as){
      if(a==e){
        pos+=i
      }
      i+=1
    }
    pos
  }
}
case class S(g:AbstractGraph,cs:Set[Constraint]){  //Specification
	
	private def inv(_g:AbstractGraph,_cs:Set[Constraint]):Boolean={
		_cs foreach{ _p => for(_a <- _p.as){
			if(!(_g contains _a)) return false		   
		  }
		}
		return true;
	}	
	if(!inv (g,cs)){
		sys.error("not valid specification") 
	}
	
	override def toString="S(\n"+ g + "\n\t"+ constraintsToString +"\n)";	
	
	protected def constraintsToString = (for(c <-cs) yield format(c))
	protected def arrowsToString(as:List[Arrow]) = (for(a <-as) yield g.format(a))
	def format(c:Constraint):String=c.s.n + "(" +c.s.p + ")"+ "{Arrows(" + arrowsToString(c.as) + ")}";
	
}

case class IS(m:S,mm:S,pSem:Map[Id,Validator]){
	private def inv(_m:S,_mm:S, _pSem:Map[Id,Validator]):Boolean={
		 _m.g.mmGraph.nodes == mm.g.nodes &&
		 _m.g.mmGraph.arrows == mm.g.arrows 
		 //&& validateConstraint(_m.g,_mm.cs,_pSem)
	}
	//def validateConstraint(g:AbstractGraph, cs:List[Constraint], pSem:Map[SignatureConstraint,Validator]):Boolean={
	//  true
	//}
	if(!inv(m,mm,pSem)){
		sys.error("not valid instance specification!");
	}
}

trait OclToken
case class OclString(s:String) extends OclToken{
  override val toString=s;
}
case class OclChar(c:Char) extends OclToken{
  override val toString="" + c;
}
case class OclPp(v:Int) extends OclToken{
  override val toString="#p" + v + "#";
}
case class OclPa(v:Int) extends OclToken{
  override val toString="#a" + v + "#";
}
case class OclPn(v:Int) extends OclToken{
  override val toString="#n" + v + "#";
}


case object GraphDpf extends AbstractGraph(){
		val node = Node(RId(0), TypeNode.TSelf())
		val arrow = Arrow(RId(1),node,node,TypeArrow.TSelf())
		override val nodes = Map[Id,Node](node.id->node)
		override val arrows = Map[Id,Arrow](arrow.id->arrow)
		override val names = Map[Id,String](RId(0)->"n",RId(1)->"id")
		override val in = Map[Node,Map[TypeArrow,Set[Arrow]]](node->Map(arrow->Set(arrow)))
		override val out = in
		override def arrowsIn(n: Node, t: TypeArrow):Set[Arrow]=Set(arrow)
		override def arrowsIn(n: Node):Set[Arrow]=Set(arrow)
		override def arrowsOut(n: Node, t: TypeArrow):Set[Arrow]=Set(arrow) 
		override def arrowsOut(n: Node):Set[Arrow]=Set(arrow) 
		override val toString = super.toString
}

package mutable{
	import scala.collection._;
  
	 /**
	  * Graph
	  */
	class Graph(override val mmGraph: AbstractGraph, val idGen:()=>RId) extends AbstractGraph() with Converter{
		
		override val nodes = mutable.HashMap[Id,Node]()
		override val arrows = mutable.HashMap[Id,Arrow]()
		override val in = mutable.HashMap[Node,mutable.Map[TypeArrow,mutable.Set[Arrow]]]()
		override val out = mutable.HashMap[Node,mutable.Map[TypeArrow,mutable.Set[Arrow]]]()
		override val names = mutable.HashMap[Id,String]()
		
		def addNode(name: String,t:TypeNode,id:Id=idGen()):Option[Node] = {
			def inv(_n:Node):Boolean = { 
						  (null != _n.id &&          //Id exist
						  (mmGraph contains _n.t));  //Node has a valid type 
			}
			//New:
			val n = Node(id,t)
			if(inv(n)){
				names+= n.id -> name
				nodes+= n.id -> n;
				Some(n);
			}else None;
		}
		def addVNode(id:Id, t:TypeNode):Option[Node] = {
			def inv(_n:Node):Boolean={
				//Check if node type and id:
			    _n.id != null
		    }
			val n = Node(id,t)
			if(inv(n)){
				nodes+= n.id->n;
				Some(n);
			}else{
				None;
			}
		}			
		def addArrow(name: String, sr:Node,tg:Node,t:TypeArrow,id:Id=idGen()):Option[Arrow]= {
			//Invariant:	
			def inv(_a:Arrow):Boolean={
				_a.id != null &&			   //Arrow needs id
				_a.sr.t == _a.t.sr && 		   //Check source node type compatible 
				_a.tg.t == _a.t.tg && 		   //Check target node type compatible
				(mmGraph contains _a.t) && 	   //Check if arrow exist in metamodel
				(this contains _a.sr) &&       //Check if src node exist in graph 
				(this contains _a.tg)          //Check if tg  node exist in graph
			}
			//New:
			val a=Arrow(id,sr,tg,t)
			addArrow(a,name,inv)
		}
		def addAArrow(name: String, sr:Node,tg:Node,t:TypeArrow.TAttribute,id:Id=idGen()):Option[Arrow] = {
			//Invariant:	
			def inv(_a:Arrow):Boolean={
			   //Check Type of tg node:  
			   def check={
			    _a.tg match{ case Node(_ ,t:TypeNode.TAttribute) => true  
							 case _				   	     	     => false	
				          }
			   }			   
			   null != _a.id && //Check if id exist
				     check && (this contains _a.sr) //Check if sr node exist in graph 								 						    	
			}
			//New:
			val a=Arrow(id,sr,tg,t)
			val o = addArrow(a,name,inv)
			o match {
			  case Some(_) => /*Save Attributes types like "String" also if they occure*/
			    			  val n = a.tg
			    			  val isAttr = n match{
			    			    case Node(_,TypeNode.TAttribute()) => true
			    			    case Node(sid@SetId(_),_) => sid.containsAId
			    			    case _ => false
			    			  }
			    			  if(isAttr){	
				    			  nodes+= n.id -> n; 
				  				  names+= n.id -> n.id.v.toString
			    			  }
			  case _ => /* do nothing */
			}
			o;
		}
		protected def addArrow(a:Arrow,name:String,inv:Arrow=>Boolean):Option[Arrow]={
			if(inv(a)){
				//Add Arrow:
				names+= a.id -> name
				arrows+=a.id -> a
				update(a,a.sr,out)	//Add out arrows
				update(a,a.tg,in)   //Add in arrows		
				Some(a)
			}else{
				None
			}			
		}
		//Update IN/OUT:
		protected def update(_a:Arrow,_n:Node,_h:mutable.Map[Node,mutable.Map[TypeArrow,mutable.Set[Arrow]]]):Unit={
			 if(_h contains _n){
				 val m = _h(_n)
				 if(m contains _a.t){
					 m(_a.t)+=_a	
				 }else{
					 val s = mutable.Set[Arrow]()
					 m += _a.t -> s //put set into hashmap by key arrow-type  
				 }						 
			 }else{
				 val m = mutable.HashMap[TypeArrow,mutable.Set[Arrow]]()
				 val s = mutable.Set[Arrow]()
				  s += _a        //put arrow in set s
				  m += _a.t -> s //put set into hashmap by key arrow-type  
				 _h += _n -> m   //put hashmap in hashmap by key node 
			 }
		}
		override def arrowsIn(n: Node, t: TypeArrow):Set[Arrow] = if(in contains n)Set(in(n)(t) toSeq : _ *) else Set[Arrow]();  
		override def arrowsOut(n: Node, t: TypeArrow):Set[Arrow] = if(out contains n)Set(out(n)(t) toSeq : _ *) else Set[Arrow]();  
		
		def immutable():no.dpf.text.graph.Graph={
			//Make inmutable copy
			def toInMut(_m: mutable.HashMap[Node,mutable.Map[TypeArrow,mutable.Set[Arrow]]]): 
				scala.collection.immutable.Map[Node,scala.collection.immutable.Map[TypeArrow,scala.collection.immutable.Set[Arrow]]]={
				_m.toMap map{v1 => (v1._1, (v1._2.toMap map (v2 => (v2._1, scala.collection.immutable.Set(v2._2 toSeq : _ *)))))}
			}
			val i = toInMut(in)
			val o = toInMut(out)
			val n:Map[Id,String] = Map(names toSeq: _*)
			no.dpf.text.graph.Graph(Map(nodes toSeq : _*),Map(arrows toSeq : _*),i,o,n)	
		}
		
		def rename(id:Id, newName: String){
		  names.put(id,newName)
		} 
	  }
	
	 /**
	  * Extended Subgraph (subgraph of a parent with additional nodes and arrows)
	  */
   	 class ExtSubGraph(val parent:AbstractGraph,val idGenNew:()=>RId) extends Graph(parent.mmGraph, ()=>RId(-1)){
		
   		 override def addNode(name: String,t:TypeNode,id:Id=idGen()):Option[Node] = {
			//Find Node:
			val nO = id match{
			  case RId(-1) => //find node via name:
			    			  parent.findNode(name)	
			  case id@_    => //find node via id
			    			  parent.nodes.get(id)	
			}
			//New:
			nO match {
			  case Some(n) => if(n.t==t){
					  			  names+= n.id -> name
						  		  nodes+= n.id -> n;
						  		  nO;
			  				  }else{
			  				    id match {
				    			    case RId(-1) => super.addNode(name,t,idGenNew())
				    			    case _		 => None /*Id has to be unique*/
			  				    }
			  				  }
			  case None    => //Fix id:
			    			  val idNew	= id match {
			    			    case RId(-1) => idGenNew()
			    			    case _		 => id
			    			  }
			  				  super.addNode(name,t,idNew)
			}
		}
		override def addArrow(name: String, sr:Node,tg:Node,t:TypeArrow,id:Id=idGen()):Option[Arrow]= {
			//Find Arrow:
			val aO = id match{
			  case RId(-1) => //find arrow via name:
			    			  parent.findArrow(name,sr,tg)	
			  case id@_    => //find arrow via id
			    			  parent.arrows.get(id)	
			}
			aO match {
			  case Some(a) => if(a.t==t){
				  				//For Subgraph sr and tg nodes have to be added to the structure:
				  				super.addArrow(name,a.sr,a.tg,a.t,a.id);
			  				  }else{
			  				    id match {
				    			    case RId(-1) => super.addArrow(name,sr,tg,t,idGenNew())
				    			    case _		 => None /*Id has to be unique*/
			  				    }
			  				  }
			  case None    => //Fix id:
			    			  val idNew	= id match {
			    			    case RId(-1) => idGenNew()
			    			    case _		 => id
			    			  }
			    			  super.addArrow(name,sr,tg,t,idNew);			  				    
			  		  
			}
		}
		override def addAArrow(name: String, sr:Node,tg:Node,t:TypeArrow.TAttribute,id:Id=idGen()):Option[Arrow] = {
			//Find Arrow:
			val aO = id match{
			  case RId(-1) => //find arrow via name:
			    			  parent.findArrow(name,sr,tg)	
			  case id@_    => //find arrow via id
			    			  parent.arrows.get(id)	
			}
			aO match {
			  case Some(a) => if(a.t==t){
				  				//For Subgraph sr and tg nodes have to be added to the structure:
				  				super.addAArrow(name,a.sr,a.tg,t,a.id);
			  				  }else{
			  				    id match {
				    			    case RId(-1) => super.addAArrow(name,sr,tg,t,idGenNew())
				    			    case _		 => None /*Id has to be unique*/
			  				    }
			  				  }
			  case None    => //Fix id:
			    			  val idNew	= id match {
			    			    case RId(-1) => idGenNew()
			    			    case _		 => id
			    			  }
			  				  super.addAArrow(name,sr,tg,t,idNew)
			}
		}
   		 
	 }

		
}

trait Type extends Element
sealed trait TypeArrow extends Type{
	case class TSelf() extends TypeArrow{
	    override val id = SId(1)
	    override val t = this
		override def toString="Self";
	}
	case class TAttribute() extends TypeArrow{
	    override val id = SId(2)
	    override val t = this
		override def toString="TAttrArrow";
	}
	case class TJoker() extends TypeArrow{
	    override val id = SId(3)
	    override val t = this
		override def toString="_";
	}
}
object TypeArrow extends TypeArrow{
    override val id = SId(1)
    override val t = this
}

sealed trait TypeNode extends Type{
	//Typed by itself:
	case class TSelf() extends TypeNode{
	    override val id = SId(0)
	    override val t = this
		override def toString="Self";
	}
	case class TAttribute() extends TypeNode{
	    override val id = SId(10)
	    override val t = this
		override def toString="TAttrNode";
	}
	case class TJoker() extends TypeNode{
	    override val id = SId(20)
	    override val t = this
		override def toString="_";
	}
}
object TypeNode extends TypeNode{
    override val id = SId(0)
    override val t = this
}

//Attributes on metalevel:
sealed trait TypeP extends TypeNode{
	def toValue(s:String) = if(null == s) sys.error("Attribute value is null!") else convert(s)
	protected def convert(s:String):AValue
}
object TypeP{
	val TBoolean = new Node(AId("TBoolean"),TypeNode.TAttribute()) with TypeP{
		override def convert(s:String)=VBoolean(s.toBoolean);
	}
	val TChar = new Node(AId("TChar"),TypeNode.TAttribute()) with TypeP{
		override def convert(s:String)=VChar(s.toCharArray()(0));
	}
	val TByte = new Node(AId("TByte"),TypeNode.TAttribute()) with TypeP{
		override def convert(s:String)=VByte(s.toByte);
	}
	val TShort = new Node(AId("TShort"),TypeNode.TAttribute()) with TypeP{
		override def convert(s:String)=VShort(s.toShort);
	}
	val TInt = new Node(AId("TInt"),TypeNode.TAttribute()) with TypeP{
		override def convert(s:String)=VInt(s.toInt);
	}
	val TLong = new Node(AId("TLong"),TypeNode.TAttribute()) with TypeP{
		override def convert(s:String)=VLong(s.toLong);
	}
	val TFloat = new Node(AId("TFloat"),TypeNode.TAttribute()) with TypeP{
		override def convert(s:String)=VFloat(s.toFloat);
	}
	val TDouble = new Node(AId("TDouble"),TypeNode.TAttribute()) with TypeP{
		override def convert(s:String)=VDouble(s.toDouble);
	}
	val TString = new Node(AId("TString"),TypeNode.TAttribute()) with TypeP{
		override def convert(s:String)=VString(s);
	}
}	

sealed trait Id{
  val v:Any
}

//RegularId:
case class RId(v:Long) extends Id{
  override lazy val toString="ID"+v;
}

//AttributeTypeId:
case class AId(v:String) extends Id{
  override lazy val toString=v;
}

//Special Id: (Dummy) (for some predefined nodes and arrows)
case class SId(v:Long) extends Id{
  override lazy val toString="SID"+v;
}

//----------------------------------------------------------------------
//SetId (required for pushouts and pullbacks)
case class SetId(v:Set[(Id,Int,String)]) extends Id{ // SetId(v:Set[(Id,Int,String)])   (Id, Set-Identifier,L(eft) || R(right))
  
  lazy val ids:Set[Id] = toNonSetIds(this)
  
  private def toNonSetIds(s:SetId):Set[Id] = {
    val rs = MSet[Id]()
    for(e<-s.v){
      e._1 match {
	  	case s2@SetId(_) => rs++=toNonSetIds(s2)
 	  	case nonSetId@_	 => rs.add(e._1)
	  }
    }
    if(rs.isEmpty)sys.error("Programming error in SetId:" + this)
    rs.toSet;
  }
  
  lazy val containsAId = {
  	if(1 == v.size){
  	  ids.head.isInstanceOf[AId]
  	}else false
  }
  
  override lazy val toString="SetID"+v.toString;	
}
//----------------------------------------------------------------------

//Virtual ID: (temporal in use for some comparisons):
case class VId(v:Long) extends Id{
  override lazy val toString="VID"+v;
}

//Attribute ValueId:
sealed trait AValue extends Id
case class VBoolean(override val v:Boolean) extends AValue 
case class VChar(override val v:Char) extends AValue 
case class VByte(override val v:Byte) extends AValue 
case class VShort(override val v:Short) extends AValue 
case class VInt(override val v:Int) extends AValue 
case class VLong(override val v:Long) extends AValue 
case class VFloat(override val v:Float) extends AValue 
case class VDouble(override val v:Double) extends AValue 
case class VString(override val v:String) extends AValue 