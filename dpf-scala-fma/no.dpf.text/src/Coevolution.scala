package no.dpf.text.coevolution;

import no.dpf.text.graph._;
import no.dpf.text.graph.mutable.{Graph=>MGraph}
import no.dpf.text.coevolution.output._;

trait AbstractCoevolutionSpan extends Output{
  
  /**
   * Need to be specified
   */
  val TL:AbstractGraph;
  
  val TK:AbstractGraph;
  
  val TR:AbstractGraph;

  val mmRule:Span;
  
  val tm:Morphism;

  val G:AbstractGraph;
  
  //---------------------------------

  lazy val TG = G.mmGraph;
  
  lazy val tG = TypingMorphism(G);
  
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

  lazy val tTG = TypingMorphism(TG);

  lazy val tTR = TypingMorphism(TR);

  lazy val tTC = Composition(tg,tTG).compositeMorphism;

  //Since tg can be non-injective a section to composition(g,tG),tg is not enough:
  lazy val tC = typingMFromPushout(poc_left_bottom, poc_left_top,tK,tG) 
  
  lazy val TC = toGraph(TG,TG,TG.mmGraph,tTC);

  lazy val L = toGraph(G,G,TL,tL);

  lazy val K = toGraph(L,L,TK,tK);

  lazy val R = toGraph(K,K,TR,tR);

  lazy val C = toGraph(G,G,TC,tC);
  
  lazy val tTH = typingMFromPushout(po_right_top, id_cospan_typTypGraph,tTR,tTC)

  lazy val tH = typingMFromPushout(po_right_bottom, po_right_top,tR,tC)
  
  lazy val TH = toGraph(TC,TR,TC.mmGraph,tTH);

  lazy val H = toGraph(C,R,TH,tH);
  
  //
  //Calculations:
  //  
  //
  //Attention: No graph should be computed twice, or we need a isomorphi check
  //
  protected lazy val poc_left_top = Composition(tl,tm).pushoutComplement(10);
  
  protected lazy val pb_left = Cospan(tG,tm).pullback(11);

  protected lazy val pb_left_back = Cospan(tL,tl).pullback(12);
  
  protected lazy val pbc_right_back = Composition(tK,tr).fPullbackComplementMono(13);

  protected lazy val poc_left_bottom = Composition(l,m).pushoutComplement(14);
  
  protected lazy val po_right_bottom = Span(r,k).pushout(1);
  
  protected lazy val po_right_top = Span(tr,tk).pushout(2);

  protected lazy val id_typTypGraph = IdMorphismGraph(TG.mmGraph);
  
  protected lazy val id_cospan_typTypGraph = Cospan(id_typTypGraph,id_typTypGraph)	
  
}

/**
 * Simplified Coevolution with Span
 */
case class SimpleCoevolutionSpan(TL:AbstractGraph,TK:AbstractGraph,TR:AbstractGraph, G:AbstractGraph) extends AbstractCoevolutionSpan{
  
  override val tm:Morphism = InclusionMorphism(TL,TG);

  override val mmRule = Span(InclusionMorphism(TK,TL),InclusionMorphism(TK,TR));

  def print(path:String)={
	val start = System.currentTimeMillis()  
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
	 printGraph(TH,"TH",path)
	 printGraph(H,"H",path)
     
	 println("Span Coevolution last (msec): " + (System.currentTimeMillis() - start))
  }

}  
//----------------------------------------------------------------------------------------------------------------------------------
  
trait AbstractCoevolutionCospan extends Output{
  
  /**
   * Need to be specified
   */
  val TL:AbstractGraph;
  
  val TI:AbstractGraph;
  
  val TR:AbstractGraph;

  val mmRule:Cospan;
  
  val tm:Morphism;

  val G:AbstractGraph;
  
  //---------------------------------

  lazy val TG = G.mmGraph;
  
  lazy val tG = TypingMorphism(G);
  
  lazy val tl = mmRule.left

  lazy val tr = mmRule.right

  lazy val tg = po_left_top.right 

  lazy val ti = po_left_top.left

  lazy val tm2 = poc_right_top.m1
  
  lazy val th = poc_right_top.m2
  
  lazy val m = pb_left.left
  
  lazy val tL = pb_left.right

  lazy val l = pbc_left_back.m1
  
  lazy val tI = pbc_left_back.m2

  lazy val r = pb_right_back.left
  
  lazy val tR = pb_right_back.right
    
  lazy val i = po_left_bottom.left
    
  lazy val g = po_left_bottom.right

  lazy val m2 =  poc_right_bottom.m1
  
  lazy val h =  poc_right_bottom.m2

  lazy val tTL = TypingMorphism(TR);
  
  lazy val tTG = TypingMorphism(TG);
  
  lazy val tTR = TypingMorphism(TR);

  lazy val tTI = TypingMorphism(TI);
  
  lazy val tTU = typingMFromPushout(po_left_top,id_cospan_typTypGraph,tTI,tTG); 

  lazy val TU = toGraph(TI,TG,TG.mmGraph,tTU);

  lazy val tTH = typingMFromPushout(poc_right_top,id_composition_typTypGraph,tTR,tTU);
  
  lazy val L = toGraph(G,G,TL,tL);

  lazy val I = toGraph(L,L,TI,tI);

  lazy val R = toGraph(I,I,TR,tR);
  
  lazy val TH = toGraph(TU,TR,TG.mmGraph,tTH);

  lazy val tH = typingMFromPushout(poc_right_bottom, poc_right_top,tR,tU)

  lazy val H = toGraph(U,R,TH,tH);

  lazy val tU = typingMFromPushout(po_left_bottom,po_left_top,tI,tG); 
  
  lazy val U = toGraph(I,G,TU,tU);
  
  //
  //Calculations:
  //  
  //
  //Attention: No graph should be computed twice, or we need a isomorphi check
  //
  protected lazy val po_left_top = Span(tl,tm).pushout(10);

  protected lazy val poc_right_top = Composition(tr,ti).pushoutComplement(2);
  
  protected lazy val pb_left = Cospan(tG,tm).pullback(12);

  protected lazy val pbc_left_back = Composition(tL,tl).fPullbackComplementMono(13);
  
  protected lazy val pb_right_back = Cospan(tI,tr).pullback(14);
    
  protected lazy val po_left_bottom = Span(l,m).pushout(15)
  
  protected lazy val poc_right_bottom = Composition(r,i).pushoutComplement(1);
  
  protected lazy val id_typTypGraph = IdMorphismGraph(TG.mmGraph);
  
  protected lazy val id_cospan_typTypGraph = Cospan(id_typTypGraph,id_typTypGraph)	

  protected lazy val id_composition_typTypGraph = Composition(id_typTypGraph,id_typTypGraph)	
  
}

/**
 * Simplified Coevolution with Span
 */
case class SimpleCoevolutionCospan(TL:AbstractGraph,TI:AbstractGraph,TR:AbstractGraph, G:AbstractGraph) extends AbstractCoevolutionCospan{
  
  override val tm:Morphism = InclusionMorphism(TL,TG);

  override val mmRule = Cospan(InclusionMorphism(TL,TI),InclusionMorphism(TR,TI));

  def print(path:String)={
	val start = System.currentTimeMillis()  
    println("------------------------ Metamodel (tm')---------------------\n\n")
    println(tm2)
    println("------------------------ Model (m')---------------------\n\n")
    println(m2)  

     printGraph(TL,"TL",path,false)
	 printGraph(TI,"TI",path,false)
	 printGraph(TR,"TR",path,false)
	 printGraph(TG,"TG",path)
	 printGraph(TU,"TU",path)
	 printGraph(G,"G",path)
	 printGraph(L,"L",path,false)
	 printGraph(I,"I",path,false)
	 printGraph(R,"R",path,false)
	 printGraph(U,"U",path)
	 printGraph(TH,"TH",path)
	 printGraph(H,"H",path)
     
	 println("Cospan Coevolution last (msec): " + (System.currentTimeMillis() - start))
  }
  
}
