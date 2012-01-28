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
  private lazy val poc_left_top = Composition(tl,tm).pushoutComplement();
  
  private lazy val pb_left = Cospan(tG,tm).pullback();

  private lazy val pb_left_back = Cospan(tL,tl).pullback();

  private lazy val pbc_right_back = Composition(tK,tr).fPullbackComplementMono();

  private lazy val poc_left_bottom = Composition(l,m).pushoutComplement();
  
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

  lazy val TC = toGraph(TG,TG,TG.mmGraph,tk.codomainNodes(),tk.codomainArrows());
  lazy val TH = toGraph(TC,TR,TG.mmGraph,tm2.codomainNodes(),tm2.codomainArrows());
  lazy val C = toGraph(G,G,TC,k.codomainNodes(),k.codomainArrows())
  lazy val L = toGraph(G,G,TL,m.domainNodes(),m.domainArrows())
  lazy val K = toGraph(L,C,TK,l.domainNodes(),l.domainArrows())    
  lazy val R = toGraph(K,K,TR,r.codomainNodes(),r.codomainArrows())    
  lazy val H = toGraph(C,R,TH,tm2.codomainNodes(),tm2.codomainArrows())
  
  def print(path:String)={

    println("------------------------ Metamodel (tm')---------------------\n\n")
    println(tm2)
    println("------------------------ Model (m')---------------------\n\n")
    println(m2)  
    
     printGraph(TL,"TL",path)
     printGraph(TK,"TK",path)
     printGraph(TR,"TR",path)
     printGraph(TC,"TC",path)
     printGraph(TG,"TG",path)
     printGraph(TH,"TH",path)
     
     printGraph(L,"L",path)
     printGraph(K,"K",path)
     printGraph(R,"R",path)
     printGraph(C,"C",path)
     printGraph(G,"G",path)
     printGraph(H,"H",path)
     
     
  }
  
}
