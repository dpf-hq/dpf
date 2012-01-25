package no.dpf.text.coevolution;

import no.dpf.text.graph._;

trait AbstractCoevolution{
  
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
case class Coevolution(override val mmRule:Span, override val tm:Morphism, override val tG:Morphism) extends AbstractCoevolution

/**
 * Simplified Coevolution
 */
case class SimpleCoevolution(TL:AbstractGraph,TK:AbstractGraph,TR:AbstractGraph,G:AbstractGraph) extends AbstractCoevolution{
  
  private val TG = G.mmGraph;
  
  override val mmRule:Span = Span(InclusionMorphism(TK,TL),InclusionMorphism(TK,TR));
  
  override val tm:Morphism = InclusionMorphism(TL,TG);
  
  override val tG:Morphism = TypingMorphism(G);

  def print()={
	println("\n\nTL" + TL)
    println("\n\nTK" + TK)
    println("\n\nTR" + TR)
    println("\n\nTG" + TG)
    println("\n\nG" + G)

    println("\n\ntl" + tl)
    println("\n\ntm" + tm)
    println("\n\ntk" + tk)
    println("\n\ntg" + tg)

////    println("\n\nm" + m)
////    println("\n\ntL" + tL)
////    println("\n\nl" + l)
////    println("\n\ntK" + tK)
////    println("\n\nr" + r)
////    println("\n\ntC" + tC)
////    println("\n\nk" + k)
////    println("\n\ng" + g)
////    println("\n\nm2" + m2)
////    println("\n\nh" + h)
    println("\n\ntm2" + tm2)
    println("\n\nth" + th)
////    
////
//    println("------------------------ Metamodel (tm')---------------------\n\n")
//    println(tm2)
//    println("------------------------ Model (m')---------------------\n\n")
//    println(m2)
  }
  
}
