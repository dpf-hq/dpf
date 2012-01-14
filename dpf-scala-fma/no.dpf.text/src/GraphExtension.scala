package no.dpf.text.graph;
import scala.collection.mutable.{Map=>MMap}
import scala.collection.mutable.{Set=>MSet}


/**
 * Graph Morphism (Graph not in name because it is already in the package name)
 */
sealed trait Morphism{
  
  /**
   * input: id of codomain
   * output: all ids of domain mapped to this id 
   */
  def domainNodes(id:Id):Set[Id]
  /**
   * input: id of domain
   * output: id of codomain mapped to this id 
   */
  def codomainNode(id:Id):Id

  /**
   * input: id of codomain
   * output: all ids of domain mapped to this id 
   */
  def domainArrows(id:Id):Set[Id]

  /**
   * input: id of codomain
   * output: all ids of domain mapped to this id 
   */
  def codomainArrow(id:Id):Id
  
  def domainArrowSr(id:Id):Id
  def domainArrowTg(id:Id):Id
  def codomainArrowSr(id:Id):Id
  def codomainArrowTg(id:Id):Id
  
  def domainNodes():Set[Id]
  def codomainNodes():Set[Id]

  def domainArrows():Set[Id]
  def codomainArrows():Set[Id]
   
  private def test(error:(Int)=>Boolean):Boolean={
	def testSet(codomain:Set[Id],domain:(Id)=>Set[Id], error:(Int)=>Boolean):Boolean={
	  for(e<-codomain){
	    if(error(domain(e).size)){
	      return false
	    }
	  }
	  true;
	}
	return testSet(codomainNodes,domainNodes,error) && testSet(codomainArrows,domainArrows,error) 
  } 	
 
  def isMono():Boolean=test(_ > 1)
  def isEpi():Boolean=test(_ < 1)
  def isIso():Boolean=test(_ != 1)
  
  def validate():Boolean={
    //Check if all nodes and arrows in the domain are mapped:
	def validateSet(domain:Set[Id],codomain:(Id)=>Id):Boolean={
	  for(e<-domain){
	    if(null == codomain(e)){
	      return false
	    }
	  }
	  true;
	}
    //Check if the graph homomorphism property is statisfied:
	def validateGraphHomo():Boolean={
	  for(a<-domainArrows()){
	    if(!(
	       codomainNode(domainArrowSr(a)) == codomainArrowSr(codomainArrow(a)) &&
	       codomainNode(domainArrowTg(a)) == codomainArrowTg(codomainArrow(a))
	    )){
	      return false
	    }
	  }
	  true;
	}
	return validateSet(domainNodes,codomainNode) && validateSet(domainArrows,codomainArrow) && validateGraphHomo() 
  }  
}

case class Span(left:Morphism,right:Morphism){
  def pushout():Cospan = {
    def pushoutSet(domain:Set[Id],codomainDiffLeft:Set[Id],codomainDiffRight:Set[Id],l:Id=>Id,r:Id=>Id){
      val m = MSet[Id]()
      val left2 = MMap[Id,Id]()
      val right2 = MMap[Id,Id]()
      for(d<-domain){
        val lV = l(d)
        val rV = r(d)
        val poe=TId((Some(lV),Some(rV)))
        left2+=lV->poe
        right2+=rV->poe
        m+=poe
      }
      for(c<-codomainDiffLeft){
        val poe = TId((Some(c),None))
    	m+= poe
        left2+=c->poe
      }
      for(c<-codomainDiffRight){
        val poe = TId((None,Some(c)))
        m+=poe
        right2+=c->poe
      }
      (m.toSet,left2.toMap,right2.toMap)
    }
    //Pushout Nodes:
    {
    val domain = left.domainNodes() // == right.domainNodes()
    val codomainDiffLeft = left.codomainNodes().filter(left.domainNodes(_).isEmpty)
    val codomainDiffRight = right.codomainNodes().filter(right.domainNodes(_).isEmpty)
    val p = pushoutSet(domain,codomainDiffLeft,codomainDiffRight,left.codomainNode,right.codomainNode)
    //TODO
    }
    //Pushout Arrows:
    {
    val domain = left.domainArrows() // == right.domainNodes()
    val codomainDiffLeft = left.codomainArrows().filter(left.domainArrows(_).isEmpty)
    val codomainDiffRight = right.codomainArrows().filter(right.domainArrows(_).isEmpty)
    val p = pushoutSet(domain,codomainDiffLeft,codomainDiffRight,left.codomainArrow,right.codomainArrow)
    //TODO
    }
    null
  }
  def validate()=left.domainNodes().equals(right.domainNodes()) && left.domainArrows().equals(right.domainArrows())
}
case class Cospan(left:Morphism,right:Morphism){
  def pullback():Span = {
    def pullbackSet(codomain2:Set[Id],l2:Id=>Set[Id],r2:Id=>Set[Id]){
      
      val m = MSet[Id]()
      val left1 = MMap[Id,Id]()
      val right1 = MMap[Id,Id]()
      
      for(x<-codomain2){
        val lDomain2 = l2(x)
        val rDomain2 = r2(x)
        //Build cartesian product:
        for(l<-lDomain2;r<-rDomain2){
          val pbe =(TId((Some(l),Some(r))))
          left1+=pbe->l
          right1+=pbe->r
          m+= pbe
        }
      }
      (m.toSet,left1.toMap,right1.toMap)
    }
    //Pullback Nodes:
    {
    val p = pullbackSet(left.codomainNodes(),left.domainNodes,right.domainNodes)
    }
    //Pullback Arrows:
    {
    val p = pullbackSet(left.codomainArrows(),left.domainArrows,right.domainArrows)
    }
    null;
  }
  def validate()=left.codomainNodes().equals(right.codomainNodes()) && left.codomainArrows().equals(right.codomainArrows())
}
case class Composition(m1:Morphism,m2:Morphism){
  def compositeMorphism():Morphism = null
  def fPullbackComplement():Composition = null
  def pushoutComplement():Composition = null
  def validate()=m1.codomainNodes().equals(m2.domainNodes()) && m1.codomainArrows().equals(m2.domainArrows())
}



sealed trait CommutingSquare{
  //isPullback()
  //isPushout()
}

case class CommutingSquareBF(span:Span,cospan:Cospan)
case class CommutingSquareLR(left:Composition,cospan:Composition)


//
//If Category needed: Category extends AbstractGraph. Constructor of Category takes Graph and completes Graph to Category :)
//

/*-------------------------- c o n c r e t e --- g r a p h - m o r p h i s m --- e a s y --- to --- c r e a t e: ------------------------*/  

/**
 * Arbitrary morphism with ids
 */
case class SetMorphism(map:Map[Id,Id], codomain:Set[Id])
case class ArrowSrTg(sr:Map[Id,Id],tg:Map[Id,Id])
case class ArbitraryMorphismWithIds(inputNodes:SetMorphism,inputArrows:(SetMorphism,ArrowSrTg,ArrowSrTg)) extends Morphism{
  
  /**
   * input: id of codomain
   * output: all ids of domain mapped to this id 
   */
  def domainNodes(id:Id):Set[Id]=Set((for{e<-inputNodes.map.filter(x=>id == x._2)} yield {e._1}) toSeq: _ *)
  /**
   * input: id of domain
   * output: id of codomain mapped to this id 
   */
  def codomainNode(id:Id):Id=inputNodes.map(id)
  /**
   * input: id of codomain
   * output: all ids of domain mapped to this id 
   */
  def domainArrows(id:Id):Set[Id]=Set((for{e<-inputArrows._1.map.filter(x=>id == x._2)} yield {e._1}) toSeq: _ *)
  
  /**
   * input: id of codomain
   * output: all ids of domain mapped to this id 
   */
  def codomainArrow(id:Id):Id=inputArrows._1.map(id)
  
  def domainArrowSr(id:Id):Id=inputArrows._2.sr(id)
  
  def domainArrowTg(id:Id):Id=inputArrows._2.tg(id)
  
  def codomainArrowSr(id:Id):Id=inputArrows._3.sr(id)
  
  def codomainArrowTg(id:Id):Id=inputArrows._3.tg(id)

  def domainNodes():Set[Id]=inputNodes.map.keySet
  
  def codomainNodes():Set[Id]=inputNodes.codomain ++ Set(inputNodes.map.values toSeq: _ *) ++ Set(inputArrows._3.sr.values toSeq: _ *) ++ Set(inputArrows._3.tg.values toSeq: _ *)
  
  def domainArrows():Set[Id]=inputArrows._1.map.keySet
  
  def codomainArrows():Set[Id]=inputArrows._1.codomain++Set(inputArrows._1.map.values toSeq: _ *)
  
}

/**
 * Arbitrary morphism With nodes and arrows 
 */
case class ArbitraryMorphism(inputNodes:Set[(Option[Node],Node)],inputArrows:Set[(Option[Arrow],Arrow)]) extends Morphism{
  
  //Mapped Nodes and arrows:
  private val nodes = MMap[Id,Id]()	
  private val arrows = MMap[Id,Id]()	
  private val domainArrowsMap = MMap[Id,Arrow]()	
  private val codomainArrowsMap = MMap[Id,Arrow]()	
  
  for((domainO,codomain)<-inputNodes){
    domainO match{
      case Some(domain) =>	input(domain,codomain)
      case _ 			=> /*ignore*/
    }
  }
  for((domainO,codomain)<-inputArrows){
    domainO match{
      case Some(domain) =>
        	arrows.get(domain.id) match{
        	  case None 	=>  arrows+=domain.id->codomain.id
        	  case Some(ex) =>  if(ex != codomain){sys.error("Arrow " + domain + " mapped twice: " + codomain + ", " + ex)}
        	  					input(domain.sr,codomain.sr);
        	  					input(domain.tg,codomain.tg)
        	}
        	domainArrowsMap+=domain.id->domain
      case _ => /*ignore*/
    }
    codomainArrowsMap+=codomain.id->codomain
  }

  private def input(domain:Node,codomain:Node){
  	nodes.get(domain.id) match{
	  case None 	=>  nodes+=domain.id->codomain.id
	  case Some(ex) =>  if(ex != codomain) sys.error("Node " + domain + " mapped twice: " +codomain + ", " + ex)
	}
  }
  
  def haveMappedElementsSameType()={
	  for(e<-inputNodes++inputArrows){
		  e match {
		    case (Some(domain),codomain) => if(domain.t != codomain.t) println(domain + " and " +codomain + " does not habe same type!");false;
		    case _ => /*do nothing*/
		  }
	  }
	  true  
  }
  
  /**
   * input: id of codomain
   * output: all ids of domain mapped to this id 
   */
  def domainNodes(id:Id):Set[Id]={
    Set((for{(Some(n),_)<-inputNodes.filter(_ match {case (None,_) => false;case (Some(_),n) => n.id == id})} yield {n.id}) toSeq: _ *)
  }
  /**
   * input: id of domain
   * output: id of codomain mapped to this id 
   */
  def codomainNode(id:Id):Id=(inputNodes find {t => (t match {case (Some(n),_) => n.id==id; case _ => false})}).get._2.id

  /**
   * input: id of codomain
   * output: all ids of domain mapped to this id 
   */
  def domainArrows(id:Id):Set[Id]={
    Set((for{(Some(a),_)<-inputArrows.filter(_ match {case (None,_) => false;case (Some(_),a) => a.id == id})} yield {a.id}) toSeq: _ *)
  }
  /**
   * input: id of codomain
   * output: all ids of domain mapped to this id 
   */
  def codomainArrow(id:Id):Id=(inputArrows find {t => (t match {case (Some(a),_) => a.id==id; case _ => false})}).get._2.id
  
  def domainArrowSr(id:Id):Id=domainArrowsMap(id).sr.id
  
  def domainArrowTg(id:Id):Id=domainArrowsMap(id).tg.id
  
  def codomainArrowSr(id:Id):Id=codomainArrowsMap(id).sr.id
  
  def codomainArrowTg(id:Id):Id=codomainArrowsMap(id).tg.id

  def domainNodes():Set[Id]={
    Set((for{(Some(n),_)<-inputNodes.filter(_ match {case (None,_) => false;case _ => true})} yield {n.id}) toSeq: _ *)    
  }
  
  def codomainNodes():Set[Id]=Set((for{(_,n)<-inputNodes} yield {n.id}) toSeq: _ *)
  
  def domainArrows():Set[Id]={
    Set((for{(Some(a),_)<-inputArrows.filter(_ match {case (None,_) => false;case _ => true})} yield {a.id}) toSeq: _ *)
  }
  
  def codomainArrows():Set[Id]=Set((for{(_,a)<-inputArrows} yield {a.id}) toSeq: _ *)

} 

/**
 * Typing Morphism  
 */
case class TypingMorphism(input:AbstractGraph) extends Morphism{
  
  /**
   * input: id of codomain
   * output: all ids of domain mapped to this id 
   */
  def domainNodes(id:Id):Set[Id]={
    Set((for{n<-input.nodes.values.filter(_.t.id == id)} yield {n.id}) toSeq: _ *)
  }
  /**
   * input: id of domain
   * output: id of codomain mapped to this id 
   */
  def codomainNode(id:Id):Id={
    input.nodes(id).t.id
  }

  /**
   * input: id of codomain
   * output: all ids of domain mapped to this id 
   */
  def domainArrows(id:Id):Set[Id]={
    Set((for{a<-input.arrows.values.filter(_.t.id == id)} yield {a.id}) toSeq: _ *)
  }

  /**
   * input: id of codomain
   * output: all ids of domain mapped to this id 
   */
  def codomainArrow(id:Id):Id={
    input.arrows(id).t.id
  }
  
  def domainArrowSr(id:Id):Id={
    input.arrows(id).sr.id
  }
  
  def domainArrowTg(id:Id):Id={
    input.arrows(id).tg.id
  }
  
  def codomainArrowSr(id:Id):Id={
    input.mmGraph.arrows(id).sr.id
  }
  
  def codomainArrowTg(id:Id):Id={
    input.mmGraph.arrows(id).tg.id
  }

  def domainNodes():Set[Id]={
    Set((for{n<-input.nodes.values} yield {n.id}) toSeq: _ *)
  }
  
  def codomainNodes():Set[Id]={
    Set((for{n<-input.mmGraph.nodes.values} yield {n.id}) toSeq: _ *)
  }

  def domainArrows():Set[Id]={
    Set((for{a<-input.arrows.values} yield {a.id}) toSeq: _ *)
  }
  
  def codomainArrows():Set[Id]={
    Set((for{n<-input.mmGraph.arrows.values} yield {n.id}) toSeq: _ *)
  }
  
} 

/**
 * Inclusion Morphism  
 */
case class InclusionMorphism(inputSub:AbstractGraph, input:AbstractGraph) extends Morphism{
  
  /**
   * input: id of codomain
   * output: all ids of domain mapped to this id 
   */
  def domainNodes(id:Id):Set[Id]={
    inputSub.getNode(id) match{
      case None => Set()
      case _ => Set(id)
    }
  }
  /**
   * input: id of domain
   * output: id of codomain mapped to this id 
   */
  def codomainNode(id:Id):Id=id
 
  /**
   * input: id of codomain
   * output: all ids of domain mapped to this id 
   */
  def domainArrows(id:Id):Set[Id]={
     inputSub.getArrow(id) match{
      case None => Set()
      case _ => Set(id)
    }
  }

  /**
   * input: id of codomain
   * output: all ids of domain mapped to this id 
   */
  def codomainArrow(id:Id):Id=id
  
  def domainArrowSr(id:Id):Id={
    inputSub.arrows(id).sr.id
  }
  
  def domainArrowTg(id:Id):Id={
    inputSub.arrows(id).tg.id
  }
  
  def codomainArrowSr(id:Id):Id={
    input.mmGraph.arrows(id).sr.id
  }
  
  def codomainArrowTg(id:Id):Id={
    input.mmGraph.arrows(id).tg.id
  }

  def domainNodes():Set[Id]={
    Set((for{n<-inputSub.nodes.values} yield {n.id}) toSeq: _ *)
  }
  
  def codomainNodes():Set[Id]={
    Set((for{n<-input.mmGraph.nodes.values} yield {n.id}) toSeq: _ *)
  }

  def domainArrows():Set[Id]={
    Set((for{a<-inputSub.arrows.values} yield {a.id}) toSeq: _ *)
  }
  
  def codomainArrows():Set[Id]={
    Set((for{n<-input.mmGraph.arrows.values} yield {n.id}) toSeq: _ *)
  }
  
  override def validate():Boolean={
	return Set(inputSub.nodes).subsetOf(Set(input.nodes)) && Set(inputSub.arrows).subsetOf(Set(input.arrows)) 
  }  
  
}