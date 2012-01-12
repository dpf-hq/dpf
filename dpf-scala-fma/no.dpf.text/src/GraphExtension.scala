package no.dpf.text.graph;
import scala.collection.mutable.{Map=>MMap}


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
  def getPushOut():Cospan = null
  //validate()  
  //getPullback() calculate on sets use private function taking function-parameter    
}
case class Cospan(left:Morphism,right:Morphism){
  def getPullback():Span = null
  //validate()  
  //getPushout()  
}
case class Composition(m1:Morphism,m2:Morphism){
  def getCompositeMorphism():Morphism = null
  def getFPullbackComplement():Composition = null
  //validate()  
}


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


sealed trait CommutingSquare{
  //isPullback()
  //isPushout()
}

case class CommutingSquareBF(span:Span,cospan:Cospan)
case class CommutingSquareLR(left:Composition,cospan:Composition)


//If Category needed than Category extends AbstractGraph. Constructor of Category takes Graph and completes Graph to Category :)
