package no.dpf.text.graph;

/**
 * Graph Morphism (Graph not in name because it is already in the package name)
 */
sealed trait Morphism{
  
  /**
   * input: id of codomain
   * output: all ids of domain mapped to this id 
   */
  def domainNode(id:Id):Set[Id]
  /**
   * input: id of domain
   * output: id of codomain mapped to this id 
   */
  def codomainNode(id:Id):Id

  /**
   * input: id of codomain
   * output: all ids of domain mapped to this id 
   */
  def domainArrow(id:Id):Set[Id]

  /**
   * input: id of codomain
   * output: all ids of domain mapped to this id 
   */
  def codomainArrow(id:Id):Id
  
  def arrowSc(id:Id):Id
  def arrowTg(id:Id):Id
  
  def domainNodes():Set[Id]
  def codomainNodes():Set[Id]

  def domainArrows():Set[Id]
  def codomainArrows():Set[Id]
  
//isMono()
//isEpi()
//isIso()
//validate()  
}

case class Span(m1:Morphism,m2:Morphism){
  def getPushOut():Cospan = null
  //validate()  
  //isPullback() calculate on sets use private function taking function-parameter    
}
case class Cospan(m1:Morphism,m2:Morphism){
  def getPullback():Span = null
  //validate()  
  //isPushout()  
}
case class Composition(m1:Morphism,m2:Morphism){
  def getCompositeMorphism():Morphism = null
  def getFPullbackComplement():Composition = null
  //validate()  
}


//case class ArbitraryMorphism extends Morphism 

//case class TypingMorphism extends Morphism 

//case class InclusionMorphism extends Morphism 


//If Category needed than Category extends AbstractGraph. Constructor of Category takes Graph and completes Graph to Category :)
