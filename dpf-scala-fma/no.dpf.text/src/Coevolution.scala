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
 
  private lazy val poc_left_top = Composition(tl,tm).pushoutComplement();
  
  private lazy val pb_left = Cospan(tG,tm).pullback();

  private lazy val pb_left_back = Cospan(tL,tl).pullback();

  private lazy val pbc_right_back = Composition(tK,tr).fPullbackComplementMono();

  private lazy val poc_left_bottom = Composition(l,m).pushoutComplement();
  
  private lazy val po_right_bottom = Span(r,k).pushout();
  
}

case class Coevolution(override val mmRule:Span, override val tm:Morphism, override val tG:Morphism) extends AbstractCoevolution

