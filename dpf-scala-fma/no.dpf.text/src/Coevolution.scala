package no.dpf.text.coevolution;

import no.dpf.text.graph._;
import no.dpf.text.graph.mutable.{Graph=>MGraph}
import no.dpf.text.coevolution.output._;

trait AbstractCoevolutionSpan{
  
  /**
   * Need to be specified
   */
  
  val mmRule:Span;
  
  val tm:Morphism;
  
  val tG:Morphism;
  
  //---------------------------------
  
  lazy val tl = mmRule.left

  lazy val tr = mmRule.right
  
  lazy val tk = poc_left_top.m1
  
  lazy val tg = poc_left_top.m2 
  
  lazy val m = pb_left.left
  
  lazy val tL = pb_left.right
  
  lazy val l = pb_left_back.left
  
  lazy val tK = pb_left_back.right

  lazy val r = pbc_right_back.m1

  lazy val tC = pbc_right_back.m2

  lazy val k = poc_left_bottom.m1

  lazy val g = poc_left_bottom.m2
  
  lazy val m2 = po_right_bottom.left
  
  lazy val h = po_right_bottom.right
 
  lazy val tm2 = po_right_top.left
  
  lazy val th = po_right_top.right
  
  //
  //Calculations:
  //  
  private lazy val poc_left_top = Composition(tl,tm).pushoutComplement(10);
  
  private lazy val pb_left = Cospan(tG,tm).pullback(11);

  private lazy val pb_left_back = Cospan(tL,tl).pullback(12);

  private lazy val pbc_right_back = Composition(tK,tr).fPullbackComplementMono(13);

  private lazy val poc_left_bottom = Composition(l,m).pushoutComplement(14);
  
  private lazy val po_right_bottom = Span(r,k).pushout(1);
  
  private lazy val po_right_top = Span(tr,tk).pushout(2);
  
}

/**
 * Common Coevolution
 */
case class CoevolutionSpan(override val mmRule:Span, override val tm:Morphism, override val tG:Morphism) extends AbstractCoevolutionSpan 

/**
 * Simplified Coevolution
 */
case class SimpleCoevolutionSpan(TL:AbstractGraph,TK:AbstractGraph,TR:AbstractGraph,G:AbstractGraph) extends AbstractCoevolutionSpan with Output{
  
  private val TG = G.mmGraph;
  
  override val mmRule:Span = Span(InclusionMorphism(TK,TL),InclusionMorphism(TK,TR));
  
  override val tm:Morphism = InclusionMorphism(TL,TG);
  
  override val tG:Morphism = TypingMorphism(G);

  //
  //With domain., codomain. Much nicer method calls /*improve*/ //TODO
  //
  lazy val TC = toGraph(TG,TG,TG.mmGraph,tk.codomainNodes(),tk.codomainArrows(),tk.codomainArrowSr,tk.codomainArrowTg);
  lazy val TH = toGraph(TR,TC,TG.mmGraph,tm2.codomainNodes(),tm2.codomainArrows(),tm2.codomainArrowSr,tm2.codomainArrowTg);
  lazy val C = toGraph(G,G,TC,k.codomainNodes(),k.codomainArrows(),k.codomainArrowSr,k.codomainArrowTg)
  lazy val L = toGraph(G,G,TL,m.domainNodes(),m.domainArrows(),m.domainArrowSr,m.domainArrowTg)
  lazy val K = toGraph(L,C,TK,l.domainNodes(),l.domainArrows(),l.domainArrowSr,l.domainArrowTg)    
  lazy val R = toGraph(K,K,TR,r.codomainNodes(),r.codomainArrows(),r.codomainArrowSr,r.codomainArrowTg)    
  lazy val H = toGraph(R,C,TH,tm2.codomainNodes(),tm2.codomainArrows(),tm2.codomainArrowSr,tm2.codomainArrowTg)
  
  def print(path:String)={

    println("------------------------ Metamodel (tm')---------------------\n\n")
    println(tm2)
    println("------------------------ Model (m')---------------------\n\n")
    println(m2)  
	 printGraph(TL,"TL",path,false)
	 printGraph(TK,"TK",path,false)
	 printGraph(TR,"TR",path,false)
	 printGraph(TC,"TC",path)
	 printGraph(TG,"TG",path)
	 printGraph(TH,"TH",path)
	 printGraph(L,"L",path,false)
	 printGraph(K,"K",path,false)
	 
	 
	 printGraph(R,"R",path,false)
	 printGraph(C,"C",path)
	 printGraph(G,"G",path)
	 printGraph(H,"H",path)
     
  }
  
}
