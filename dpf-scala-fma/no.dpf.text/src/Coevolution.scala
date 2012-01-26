package no.dpf.text.coevolution;

import no.dpf.text.graph._;
import no.dpf.text.graph.mutable.{Graph=>MGraph}

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
  
  protected def toGraph(parent1:AbstractGraph,
		  			    parent2:AbstractGraph,
		  			    typeGraph:AbstractGraph,
		  			    nodes:Set[Id],
		  			    arrows:Set[Id]):AbstractGraph = {
    //Add nodes:
    val rs = new MGraph(typeGraph,()=>sys.error("Programming error"))
    for(n<-nodes){
      n match {
        case sid@SetId(_) => 
          //Build SetId with concat name (names vorher in set tun und dann sort list):
          if(sid.ids.size > 1){
            //TODO
            sys.error("1. Not implemented jet: " + sid.ids)
          }else{
        	  val id = sid.ids.head
        	  var nameOption:Option[String] = null; 
        	  val nodeOption = parent1.getNode(id) match {
        	    case oN@Some(_) => nameOption=parent1.names.get(id); 
        	    				   oN
        	    case None	 =>    nameOption=parent2.names.get(id);
        	    				   parent2.getNode(id)
        	  }
        	  nodeOption match {
        	    case Some(n) => if(n.t == TypeNode.TAttribute()){
        	    				  rs.addVNode(n.id,n.t)
        	    				}else{
        	    				  nameOption match{
        	    				    case Some(name) => rs.addNode(name,n.t,n.id)
        	    				    case None => rs.addNode(n.id.v.toString,n.t,n.id)
        	    				  }
        	    				  
        	    				}
        	    case None	 => sys.error("Programming error")
        	  }
          }
        case n@_		  => sys.error("Programming error")
      }
    }
    for(a<-arrows){
      a match {
        case sid@SetId(_) => 
          //Build SetId with concat name (names vorher in set tun und dann sort list):
          if(sid.ids.size > 1){
            //TODO
            sys.error("2. Not implemented jet: " + sid.ids)
          }else{
        	  val id = sid.ids.head
        	  var nameOption:Option[String] = null; 
        	  val arrowOption = parent1.getArrow(id) match {
        	    case oN@Some(_) => nameOption=parent1.names.get(id); 
        	    				   oN
        	    case None	 =>    nameOption=parent2.names.get(id);
        	    				   parent2.getArrow(id)
        	  }
        	  arrowOption match {
        	    case Some(a) =>	if(a.t == TypeArrow.TAttribute()){
        	    				  rs.addAArrow(nameOption.get,a.sr,a.tg,TypeArrow.TAttribute(),a.id)
        	    				}else{
        	    				  rs.addArrow(nameOption.get,a.sr,a.tg,a.t,a.id)
        	    				}
        	    case None	 => sys.error("Programming error")
        	  }
          }
        case n@_		  => sys.error("Programming error")
      }
    }
    rs
  }
  
  protected def printGraph(g:AbstractGraph,name:String,path:String)={
    
    def formatNode(l:List[String],n:Node):List[String]={
    	var rs=l
    	rs="\""::rs
    	rs=getName(n)::rs
    	rs=":"::rs
    	rs=getType(n)::rs
    	rs="\""::rs
    	rs
    }		  
    
    def getName(e:Element):String={
      e.id match{
        case SId(_) => e.toString()
        case _ => g.names(e.id).replaceAll("\"","")
      }
    }

    def getType(e:Element):String={
      e.t.id match{
        case SId(_) => e.t.toString()
        case _ => g.mmGraph.names(e.t.id);
      }
    }
    
    var rs:List[String] = Nil
    rs="digraph "::rs
    rs=name::rs
    rs="\n{\n"::rs
    rs="graph [nodesep=\"0.7\"];\n"::rs
    rs="node [label=\"\\N\", shape=box];\n"::rs
    for(n:Node<-g.nodes.values.toSet){
      rs=formatNode(rs,n)
   	  rs=";\n"::rs  
    }
    for(a:Arrow<-g.arrows.values.toSet){
      rs=formatNode(rs,a.sr)
   	  rs="->"::rs  
      rs=formatNode(rs,a.tg)
   	  rs=" [label="::rs
   	  rs="\""::rs  
   	  rs=getName(a)::rs
      rs=":"::rs
      rs=getType(a)::rs
   	  rs="\"]"::rs 
   	  rs=";\n"::rs     	    
    }
    rs="}\n"::rs
    rs=rs.reverse
    
	import java.io._
	val fname = path + name + ".dot"
	val writer = new java.io.PrintWriter(fname)
	val mm = new ByteArrayOutputStream()
	try {
		for(s<-rs){
			writer.print(s)
		}
	}catch{
	  case ex => ex.printStackTrace()
	}finally {
		writer.close
	}	
	println("File created: " + fname)
	try {
	    val cmd = "dot -Tpng "+ fname +" -o " + path + name + ".png"
		Runtime.getRuntime().exec(cmd)
	}catch{
	  case ex => ex.printStackTrace()
	}
	
  }
  
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
