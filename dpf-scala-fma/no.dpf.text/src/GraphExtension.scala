package no.dpf.text.graph;
import scala.collection.mutable.{Map=>MMap}
import scala.collection.mutable.{Set=>MSet}


/**
 * Graph Morphism (Graph not in name because it is already in the package name)
 */
sealed trait Morphism{
  
  //
  //Change lazy values were possible
  //use the group numbers where required
  //
  
  
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
  lazy val domainArrowSrTg:ArrowSrTg = createArrowSrTg(domainArrows,domainArrowSr,domainArrowTg) /*If really a new map is required*/

  def codomainArrowSr(id:Id):Id
  def codomainArrowTg(id:Id):Id
  lazy val codomainArrowSrTg:ArrowSrTg = createArrowSrTg(codomainArrows,codomainArrowSr,codomainArrowTg) /*If really a new map is required*/
  
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
 
 private def createArrowSrTg(as:Set[Id], sr:Id=>Id, tg:Id=>Id):ArrowSrTg={
   def create(as:Set[Id],f:Id=>Id):Map[Id,Id]={
     val rs = MMap[Id,Id]();
     for(a<-as){
       rs+=a->f(a)
     }
     rs.toMap
   }
   ArrowSrTg(create(as,sr),create(as,tg))
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
  
  override lazy val toString={
    var rrs:List[String] = Nil
    
    rrs="\n\nNodes-Mapping:\n"::rrs;
    for(n<-domainNodes()){
    	rrs=n + "  =>  " + codomainNode(n) +  "\n"::rrs
    }  
    
    rrs="\n\nAdditional Nodes in Codomain:\n"::rrs;
    for(n<-codomainNodes()){
    	if(domainNodes(n).isEmpty){	
    	rrs=n + "\n"::rrs
    	}
    }  

    rrs="\n\nArrows-Mapping:\n"::rrs;
    for(a1<-domainArrows()){
    	val a2 = codomainArrow(a1)
    	val s_a1 = domainArrowSr(a1) + "---" +  a1 + "--->" + domainArrowTg(a1)
    	val s_a2 = codomainArrowSr(a2) + "---" +  a2 + "--->" + codomainArrowTg(a2)
    	rrs= s_a1 + "  =>  " + s_a2 +  "\n"::rrs
    }  

    rrs="\n\nAdditional Arrows in Codomain:\n"::rrs;
    for(a2<-codomainArrows()){
    	if(domainArrows(a2).isEmpty){
	    	val s_a2 = codomainArrowSr(a2) + "---" +  a2 + "--->" + codomainArrowTg(a2)
	    	rrs= s_a2 +  "\n"::rrs
    	}
    }  
      
    rrs.reverse.mkString
  }
  
}

trait TwoMorphism{
  protected def createArrowSrTg(as:Set[Id],
		  						srL:Id=>Id, tgL:Id=>Id,
		  						srR:Id=>Id,	tgR:Id=>Id):ArrowSrTg={
    var srMap = MMap[Id,Id]()
    var tgMap = MMap[Id,Id]()
    
    for(a<-as){
      a match{
        case x@SetId(s) => if(s.isEmpty){
        						sys.error("Programming error") 
        					}
        					val srSet= MSet[(Id,Int,String)]()
        					val tgSet= MSet[(Id,Int,String)]()
          					for(i <- s){
        					  if(i._3=="L"){
        					    srSet+=((srL(i._1),i._2,i._3))
        					    tgSet+=((tgL(i._1),i._2,i._3))
        					  }
        					  if(i._3=="R"){
        					    srSet+=((srR(i._1),i._2,i._3))
        					    tgSet+=((tgR(i._1),i._2,i._3))
        					  }
        					}
       					    srMap+=x->SetId(srSet.toSet)	
        					tgMap+=x->SetId(tgSet.toSet)	
        case _ => sys.error("Programming error") 
      } 
    }
    ArrowSrTg(srMap.toMap,tgMap.toMap)
  }
}

case class Span(left:Morphism,right:Morphism) extends TwoMorphism{
  def pushout():Cospan = {
    def pushoutSet(domain:Set[Id],codomainDiffLeft:Set[Id],codomainDiffRight:Set[Id],l:Id=>Id,r:Id=>Id)={
      
      //For Result:
      val m = MSet[Id]()
      val left2 = MMap[Id,Id]()
      val right2 = MMap[Id,Id]()

      //Use mutable Maps for Equivalenz classes:
      val left2_tmp  = MMap[(Id,Int,String),MSet[(Id,Int,String)]]()
      val right2_tmp = MMap[(Id,Int,String),MSet[(Id,Int,String)]]()
      for(d<-domain){
        val lV = (l(d),1,"L")  
        val rV = (r(d),1,"R")
        val poe = MSet(lV,rV)
        left2_tmp+=lV->poe
        right2_tmp+=rV->poe
      }
      //Compute equivalenz classes:
      def merge():Boolean={
        var merged = false;
        for(kvL <- left2_tmp; kvR <- right2_tmp){
      	  if(kvL._2 != kvR._2 && !(kvL._2 intersect kvR._2).isEmpty){
	        kvL._2++=kvR._2;
	        right2_tmp+=kvR._1->kvL._2;
	       	merged = true;
	      }
        }
        merged
      }
      while(merge())
      
      //Add to real result:
      for(s<-left2_tmp.values)m+=SetId(s.toSet)
      for(kv<-left2_tmp)left2+=kv._1._1->SetId(kv._2.toSet)
      for(kv<-right2_tmp)right2+=kv._1._1->SetId(kv._2.toSet)

      for(c<-codomainDiffLeft){
        val poe = SetId(Set((c,1,"L")))
    	m+= poe
        left2+=c->poe
      }
      for(c<-codomainDiffRight){
        val poe = SetId(Set((c,1,"R")))
        m+=poe
        right2+=c->poe
      }
      (m.toSet,left2.toMap,right2.toMap)
    }
    //Pushout Nodes:
    val domainNodes = left.domainNodes() // == right.domainNodes()
    val codomainDiffLeftNodes = left.codomainNodes().filter(left.domainNodes(_).isEmpty)
    val codomainDiffRightNodes = right.codomainNodes().filter(right.domainNodes(_).isEmpty)
    val pNodes = pushoutSet(domainNodes,codomainDiffLeftNodes,codomainDiffRightNodes,left.codomainNode,right.codomainNode)
    val rsLeftNodes = SetMorphism(pNodes._2,pNodes._1)		
    val rsRightNodes = SetMorphism(pNodes._3,pNodes._1)  
    

    //Pushout Arrows:
    val domainArrows = left.domainArrows()
    val codomainDiffLeftArrows = left.codomainArrows().filter(left.domainArrows(_).isEmpty)
    val codomainDiffRightArrows = right.codomainArrows().filter(right.domainArrows(_).isEmpty)
    val pArrows = pushoutSet(domainArrows,codomainDiffLeftArrows,codomainDiffRightArrows,left.codomainArrow,right.codomainArrow)
    val rsLeftArrows = SetMorphism(pArrows._2,pArrows._1)		
    val rsRightArrows = SetMorphism(pArrows._3,pArrows._1)	
    
    //Build Result:
    val codomainArrowSrTg = createArrowSrTg(pArrows._1,
    									  left.codomainArrowSr,left.codomainArrowTg,
    									  right.codomainArrowSr,right.codomainArrowTg
    									  )
    val domainArrowSrTgLeft = left.codomainArrowSrTg
    val domainArrowSrTgRight = right.codomainArrowSrTg
    val leftRs = ArbitraryMorphismWithIds(rsLeftNodes,(rsLeftArrows,domainArrowSrTgLeft,codomainArrowSrTg))
    val rightRs = ArbitraryMorphismWithIds(rsRightNodes,(rsRightArrows,domainArrowSrTgRight,codomainArrowSrTg))

    Cospan(leftRs,rightRs);
    
  }
  def validate()=left.domainNodes().equals(right.domainNodes()) && left.domainArrows().equals(right.domainArrows())
}

case class Cospan(left:Morphism,right:Morphism) extends TwoMorphism{
  def pullback():Span = {
    def pullbackSet(codomain2:Set[Id],l2:Id=>Set[Id],r2:Id=>Set[Id])={
      
      val m = MSet[Id]()
      val left1 = MMap[Id,Id]()
      val right1 = MMap[Id,Id]()
      
      for(x<-codomain2){
        val lDomain2 = l2(x)
        val rDomain2 = r2(x)
        //Build cartesian product:
        for(l<-lDomain2;r<-rDomain2){
          val pbe = SetId(Set((l,1,"L"),(r,1,"R"))) 
          left1+=pbe->l
          right1+=pbe->r
          m+= pbe
        }
      }
      (m.toSet,left1.toMap,right1.toMap)
    }
    
    def createSrTgMaps()={
      
    }
    
    //Pullback Nodes:
    val pNodes = pullbackSet(left.codomainNodes(),left.domainNodes,right.domainNodes);
    val rsLeftNodes = SetMorphism(pNodes._2,pNodes._2.values.toSet)		
    val rsRightNodes = SetMorphism(pNodes._3,pNodes._3.values.toSet)
    
    //Pullback Arrows:
    val pArrows = pullbackSet(left.codomainArrows(),left.domainArrows,right.domainArrows)
    val rsLeftArrows = SetMorphism(pArrows._2,pArrows._2.values.toSet)		
    val rsRightArrows = SetMorphism(pArrows._3,pArrows._3.values.toSet)	
    
    //Build Result:
    val domainArrowSrTg = createArrowSrTg(pArrows._1,
    									  left.domainArrowSr,left.domainArrowTg,
    									  right.domainArrowSr,right.domainArrowTg
    									  )
    val codomainArrowSrTgLeft = left.domainArrowSrTg
    val codomainArrowSrTgRight = right.domainArrowSrTg
    val leftRs = ArbitraryMorphismWithIds(rsLeftNodes,(rsLeftArrows,domainArrowSrTg,codomainArrowSrTgLeft))
    val rightRs = ArbitraryMorphismWithIds(rsRightNodes,(rsRightArrows,domainArrowSrTg,codomainArrowSrTgRight))

    Span(leftRs,rightRs);
  }
  def validate()=left.codomainNodes().equals(right.codomainNodes()) && left.codomainArrows().equals(right.codomainArrows())
}
case class Composition(m1:Morphism,m2:Morphism){
  def compositeMorphism():Morphism = null
  def fPullbackComplement():Composition = null
  def pushoutComplement():Composition = {
	
    //Graph transformation book p. 46
    def pushoutComplementSet(G:Set[Id],L:Set[Id],K:Set[Id],l:Id=>Id,m:Id=>Id) ={
      
      //Morphism on the other side:
      val m1B = MMap[Id,Id]();
      val m2B = MMap[Id,Id]();
      
      val m_L = for(x<-L)	yield{val y = SetId(Set((m(x),1,"K")));	   m2B+=y->x ;y} 
      val m_l_K = for(x<-K)	yield{val y = SetId(Set((m(l(x)),1,"G"))); m1B+=x->y ;y}
	  val D = (G--m_L) ++ m_l_K
	  
	  (D,m1B.toMap,m2B.toMap)
	}
    
    //Nodes:
    val pcNodes = pushoutComplementSet(m2.codomainNodes(),m2.domainNodes(),m1.domainNodes(),m1.codomainNode,m2.codomainNode) 
    val ns1 = SetMorphism(pcNodes._2, pcNodes._1)
    val ns2 = SetMorphism(pcNodes._3, m2.codomainNodes())
       
    //Arrows:
    val pcArrows = pushoutComplementSet(m2.codomainArrows(),m2.domainArrows(),m1.domainArrows(),m1.codomainArrow,m2.codomainArrow)
    val as1 = SetMorphism(pcArrows._2, pcArrows._1)
    val as2 = SetMorphism(pcArrows._3, m2.codomainArrows())
    
    //Fix arrows:
    val arrowSr = MMap[Id,Id]();
    val arrowTg = MMap[Id,Id]();
    
    for(a<-pcArrows._1){
      a match{
        case id@SetId(s) => if(1 != s.size){
        		 			   sys.error("Programming error");
        				    }
        				 for(i<-s){
        				   i._3 match{
        				     case "K" => arrowSr+=id->SetId(Set((m1.domainArrowSr(i._1),1,"K")));
        				     			 arrowTg+=id->SetId(Set((m1.domainArrowTg(i._1),1,"K")));
        				     case "G" => arrowSr+=id->SetId(Set((m2.codomainArrowSr(i._1),1,"G")));
        				     			 arrowTg+=id->SetId(Set((m2.codomainArrowTg(i._1),1,"G"))); 
        				     case _ => sys.error("Programming error"); 
        				   }
        				 }	
        case _		  => sys.error("Programming error");  
      }
    }
    val arrowsSrTg_D = ArrowSrTg(arrowSr.toMap,arrowTg.toMap);
    val m1B = ArbitraryMorphismWithIds(ns1,(as1,m1.domainArrowSrTg,arrowsSrTg_D))
    val m2B = ArbitraryMorphismWithIds(ns2,(as2,arrowsSrTg_D,m2.codomainArrowSrTg))

    Composition(m1,m2);
  }
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
  
  def codomainNodes():Set[Id]=inputNodes.codomain ++ inputNodes.map.values.toSet ++ inputArrows._3.sr.values.toSet ++ inputArrows._3.tg.values.toSet
  
  def domainArrows():Set[Id]=inputArrows._1.map.keySet
  
  def codomainArrows():Set[Id]=inputArrows._1.codomain++inputArrows._1.map.values.toSet
  
}

/**
 * Arbitrary morphism With nodes and arrows 
 */
case class ArbitraryMorphism(inputNodes:Set[(Option[Node],Node)],inputArrows:Set[(Option[Arrow],Arrow)]) extends Morphism{
  
  //Mapped Nodes and arrows:
  private val nodes = MMap[Id,Id]()	
  private val codomainNodesSet = MSet[Id]()	
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
        	  					input(domain.sr,codomain.sr);
        	  					input(domain.tg,codomain.tg)
        	  case Some(ex) =>  if(ex != codomain.id){sys.error(domain + " mapped twice: " + codomain + ", " + ex)}
        	}
        	domainArrowsMap+=domain.id->domain
      case _ => /*ignore*/
    }
    codomainArrowsMap+=codomain.id->codomain
    codomainNodesSet+=codomain.sr.id
    codomainNodesSet+=codomain.tg.id
  }

  private def input(domain:Node,codomain:Node){
  	nodes.get(domain.id) match{
	  case None 	=>  nodes+=domain.id->codomain.id
	  case Some(ex) =>  if(ex != codomain.id) sys.error(domain + " mapped twice: " +codomain + ", " + ex)
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
    Set((for{i<-nodes.filter(_ match {case x => x._2 == id})} yield {i._1}) toSeq: _ *)
  }
  /**
   * input: id of domain
   * output: id of codomain mapped to this id 
   */
  def codomainNode(id:Id):Id=nodes(id)

  /**
   * input: id of codomain
   * output: all ids of domain mapped to this id 
   */
  def domainArrows(id:Id):Set[Id]={
    Set((for{i<-arrows.filter(_ match {case x => x._2 == id})} yield {i._1}) toSeq: _ *)
  }
  /**
   * input: id of domain
   * output: id of codomain mapped to this id 
   */
  def codomainArrow(id:Id):Id=arrows(id)
  
  def domainArrowSr(id:Id):Id=domainArrowsMap(id).sr.id
  
  def domainArrowTg(id:Id):Id=domainArrowsMap(id).tg.id
  
  def codomainArrowSr(id:Id):Id=codomainArrowsMap(id).sr.id
  
  def codomainArrowTg(id:Id):Id=codomainArrowsMap(id).tg.id

  def domainNodes():Set[Id]=nodes.keySet.toSet
  
  lazy val codomainNodes:Set[Id]=codomainNodesSet.toSet
  
  lazy val domainArrows:Set[Id]=arrows.keySet.toSet
  
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

object Test {

  	//Ids:
	private var i = 0; 
	def gen()= {i+=1;
		RId(1000 + i);
	}
	
	def node(i:Long):Node = Node(RId(i),GraphDpf.node);
	
	def arrow(i:Long,n1:Long,n2:Long):Arrow = Arrow(RId(i),Node(RId(n1),GraphDpf.node),Node(RId(n2),GraphDpf.node),GraphDpf.arrow)

	def main(args: Array[String]) {
	 
	  //
	  //Test Pushout (Fudamentals of Algebraic Graph Transformation, page. 31 )
	  //
	  {
		  //G_A
		  val a10 = arrow(10,1,2)
		  val a11 = arrow(11,1,3)
	    
		  //G_B
		  val a12 = arrow(12,4,5)
		  val a13 = arrow(13,6,7)
	    
		  //G_C
		  val a14 = arrow(14,8,8)
		  val a15 = arrow(15,8,9)
		  
		  val x = ArbitraryMorphism(Set(),Set(
				  					(Some(a10),a12),
				  					(Some(a11),a12),
				  					(None,a13)
				  					));
		  
		  val y = ArbitraryMorphism(Set(),Set(
				  					(Some(a10),a15),
				  					(Some(a11),a14)
				  					));
		  
		  val span = Span(x,y)

//		  val pushout:Cospan = span.pushout()
		  
//		  println(pushout.left);
//		  println(pushout.right);
		  
	  }	
	  
	  
	  //
	  //Test Pullback (Fudamentals of Algebraic Graph Transformation, page. 35 )
	  //
	  {
	
		  //G_C
		  val a10 = arrow(10,1,2)
		  val a11 = arrow(11,2,3)
	
		  //G_B
		  val a12 = arrow(12,4,5)
		  val a13 = arrow(13,4,6)
		  
		  //G_B
		  val a14 = arrow(14,7,8)
		  val a15 = arrow(15,7,9)
		  val a16 = arrow(16,8,9)
		  
		  
		  val x = ArbitraryMorphism(Set(),Set(
				  					(Some(a12),a14),
				  					(Some(a13),a15)
				  					));
		  
		  val y = ArbitraryMorphism(Set(),Set(
				  					(Some(a10),a14),
				  					(Some(a11),a16)
				  					));
		  
		  val cospan = Cospan(x,y)
		  
//		  val pullback:Span = cospan.pullback()
//		  
//		  println(pullback.left);
//		  println(pullback.right);
		  
	  }

	}
	
}
