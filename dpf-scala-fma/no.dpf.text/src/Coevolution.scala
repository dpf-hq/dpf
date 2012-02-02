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

  lazy val tR = pbc_right_back.m2

  lazy val k = poc_left_bottom.m1

  lazy val g = poc_left_bottom.m2
  
  lazy val m2 = po_right_bottom.left
  
  lazy val h = po_right_bottom.right
 
  lazy val tm2 = po_right_top.left
  
  lazy val th = po_right_top.right
  
  //
  //Calculations:
  //  
  protected lazy val poc_left_top = Composition(tl,tm).pushoutComplement(10);
  
  protected lazy val pb_left = Cospan(tG,tm).pullback(11);

  protected lazy val pb_left_back = Cospan(tL,tl).pullback(12);
  
  protected lazy val pbc_right_back = Composition(tK,tr).fPullbackComplementMono(13);

  protected lazy val poc_left_bottom = Composition(l,m).pushoutComplement(14);
  
  protected lazy val pb_left_front = Cospan(tG,tg).pullback(15);

  protected lazy val po_right_bottom = Span(r,k).pushout(1);
  
  protected lazy val po_right_top = Span(tr,tk).pushout(2);

 
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

  
  
  lazy val tTG = TypingMorphism(TG);

  lazy val tTC = Composition(tg,tTG).compositeMorphism;

  lazy val tC = pb_left_front.right
  
  lazy val TC = toGraph(TG,TG,TG.mmGraph,tTC);

  lazy val L = toGraph(G,G,TL,tL);

  lazy val K = toGraph(L,L,TK,tK);

  lazy val R = toGraph(K,K,TR,tR);

  lazy val C = toGraph(G,G,TC,tC);
  

  def print(path:String)={

    println("------------------------ Metamodel (tm')---------------------\n\n")
    println(tm2)
    println("------------------------ Model (m')---------------------\n\n")
    println(m2)  
	 printGraph(TL,"TL",path,false)
	 printGraph(TK,"TK",path,false)
	 printGraph(TR,"TR",path,false)
	 printGraph(TG,"TG",path)
	 printGraph(TC,"TC",path)
	 printGraph(L,"L",path,false)
	 printGraph(K,"K",path,false)
	 printGraph(R,"R",path,false)
	 printGraph(C,"C",path)
	 printGraph(G,"G",path)
	 
	 typingMFromPushout(po_right_top,TR.mmGraph)
	 
//	 printGraph(TH,"TH",path)
//	 printGraph(H,"H",path)
     
  }
  
}
