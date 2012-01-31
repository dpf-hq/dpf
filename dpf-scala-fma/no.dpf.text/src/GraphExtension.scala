package no.dpf.text.graph;
import scala.collection.mutable.{Map=>MMap}
import scala.collection.mutable.{Set=>MSet}
import no.dpf.text.graph.mutable.{Graph=>MGraph}

/**
//TODO lots of defs can be improved as lazy values 
*/

/**
 * Graph Morphism (Graph not in name because it is already in the package name)
 */
sealed trait Morphism{
  
  lazy val immutable:Boolean = true	
  
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
  
  private lazy val domainarrowsrtg:ArrowSrTg = createArrowSrTg(domainArrows,domainArrowSr,domainArrowTg)
  def domainArrowSrTg():ArrowSrTg = immutable match {case true => domainarrowsrtg; case _ => createArrowSrTg(domainArrows,domainArrowSr,domainArrowTg)}

  def codomainArrowSr(id:Id):Id
  def codomainArrowTg(id:Id):Id
  
  private lazy val codomainarrowsrtg:ArrowSrTg = createArrowSrTg(codomainArrows,codomainArrowSr,codomainArrowTg)
  def codomainArrowSrTg():ArrowSrTg = immutable match {case true => codomainarrowsrtg; case _ => createArrowSrTg(codomainArrows,codomainArrowSr,codomainArrowTg)}
  
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
  
  private lazy val tostring = mkToString()
  override def toString():String = immutable match {case true => tostring; case _ => mkToString()} 

  private def mkToString():String={
    
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


//Ids:
object GroupIdGen{
	private var i = 100; 
	def gen():Int = {i+=1;i;}
}


trait TwoMorphism{
  protected def createArrowSrTg(as:Set[Id],ns:Set[Id],
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

    //Import if nodes have been merged to equivalenz classes
    def checkNodes(m:MMap[Id,Id]){
      for(kv<-m){
        //Is sr or target tg node a valid one:
        if(!(ns contains kv._2)){
          //No:
          var fixed = false
          //Try do find the correct one:
          for(n<-ns){
            n match {
              case y@SetId(_) => 
		            kv._2 match {
		              case x@SetId(_) =>
		              //Fix:
		              if(x.v subsetOf y.v){
		            	  m+=kv._1->y
		            	  fixed = true
		              }
		              case _ => 
		            }
              case _ => 
            }
          }
          if(!fixed){
        	  sys.error("Node does not exist: " + kv._2)            
          }
        }
      }
    }
    
    checkNodes(srMap)
    checkNodes(tgMap)
    
    ArrowSrTg(srMap.toMap,tgMap.toMap)
  }
}

case class Span(left:Morphism,right:Morphism) extends TwoMorphism{
  def pushout(gid:Int=GroupIdGen.gen()):Cospan = {
    def pushoutSet(domain:Set[Id],codomainDiffLeft:Set[Id],codomainDiffRight:Set[Id],l:Id=>Id,r:Id=>Id)={
      
      //For Result:
      val m = MSet[Id]()
      val left2 = MMap[Id,Id]()
      val right2 = MMap[Id,Id]()

      //Use mutable Maps for Equivalenz classes:
      val left2_tmp  = MMap[(Id,Int,String),MSet[(Id,Int,String)]]()
      val right2_tmp = MMap[(Id,Int,String),MSet[(Id,Int,String)]]()
      for(d<-domain){
        val lV = (l(d),gid,"PO")  
        val rV = (r(d),gid,"PO")
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
      while(merge()){/*do nothing*/}
      
      //Add to real result:
      for(s<-left2_tmp.values)m+=SetId(s.toSet)
      for(kv<-left2_tmp)left2+=kv._1._1->SetId(kv._2.toSet)
      for(kv<-right2_tmp)right2+=kv._1._1->SetId(kv._2.toSet)

      for(c<-codomainDiffLeft){
        val poe = SetId(Set((c,gid,"PO")))
    	m+= poe
        left2+=c->poe
      }
      for(c<-codomainDiffRight){
        val poe = SetId(Set((c,gid,"PO")))
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
    val codomainArrowSrTg = createArrowSrTg(pArrows._1, pNodes._1,
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
  def pullback(gid:Int=GroupIdGen.gen()):Span = {
    def pullbackSet(codomain2:Set[Id],l2:Id=>Set[Id],r2:Id=>Set[Id])={
      
      val m = MSet[Id]()
      val left1 = MMap[Id,Id]()
      val right1 = MMap[Id,Id]()
      
      for(x<-codomain2){
        val lDomain2 = l2(x)
        val rDomain2 = r2(x)
        //Build cartesian product:
        for(l<-lDomain2;r<-rDomain2){
          val pbe = SetId(Set((l,gid,"PB"),(r,gid,"PB"))) 
          left1+=pbe->l
          right1+=pbe->r
          m+= pbe
        }
      }
      (m.toSet,left1.toMap,right1.toMap)
    }
    
    //Pullback Nodes:
    val pNodes = pullbackSet(left.codomainNodes(),left.domainNodes,right.domainNodes);
    val rsLeftNodes = SetMorphism(pNodes._2,left.domainNodes)		
    val rsRightNodes = SetMorphism(pNodes._3,right.domainNodes)
    
    //Pullback Arrows:
    val pArrows = pullbackSet(left.codomainArrows(),left.domainArrows,right.domainArrows)
    val rsLeftArrows = SetMorphism(pArrows._2,left.domainArrows)
    val rsRightArrows = SetMorphism(pArrows._3,right.domainArrows)	
    
    //Build Result:
    val domainArrowSrTg = createArrowSrTg(pArrows._1, pNodes._1,
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
  
  /**
   * Final-Pullback-Complement for Monic matches
   */
  def fPullbackComplementMono(gid:Int=GroupIdGen.gen()):Composition = {
	//From: Sesqui-pushout rewriting (Corradini et. al) 

    //Construction 6
    val V_A = m2.codomainNodes();
    val V_L = m2.domainNodes();
    val V_K = m1.domainNodes();
    val m_V = m2.codomainNode(_);
    val i_V = MMap[Id,Id]();
    val V_D = MSet[SetId]();
   
    //Compute V_D and i_V:
    for(v<-V_A){
      V_D+=SetId(Set((v,gid,"A")))
    }
    for(v<-V_L){
      V_D-=SetId(Set((m_V(v),gid,"A")))
    }
    for(v<-V_K){
      val n = SetId(Set((v,gid,"K"))) 
      V_D+=n;
      i_V+=v->n;
    }
    
    //Compute y_v:
    val a_V = m1.codomainNode(_);
    val y_V = MMap[Id,Id]();
    for(v<-V_D){
      val u = v.v.head
      u._3 match{ 
        case "K" => y_V+=v->m_V(a_V(u._1)) 
        case "A" => y_V+=v->u._1
        case _ => sys.error("Programming error")
      }
    }
    
    //Compute E_D and i_E
    val E_A = m2.codomainArrows();
    val m_E_image = m2.domainArrows(_:Id);
    val src_A = m2.codomainArrowSr(_);
    val tgt_A = m2.codomainArrowTg(_);
    val E_K = m1.domainArrows();
    val i_E = MMap[Id,Id]();
    val E_D = MSet[SetId]();
    for(e <- E_A){
      if(m_E_image(e).isEmpty){
        for(u <- V_D;
            v <- V_D){
          if(src_A(e) == y_V(u) && tgt_A(e) == y_V(v)){
        	  E_D+=SetId(Set((e,gid,"A"),(u,gid,"uD"),(v,gid,"vD")))
          }
        }
      }
    }
    for(e<-E_K){
      val a = SetId(Set((e,gid,"K"))); 
   	  E_D+=a;
   	  i_E+=e->a;
    }
    
   //Compute y_E and src_D(e) and tgt_D(e):
   val m_E = m2.codomainArrow(_);
   val a_E = m1.codomainArrow(_);
   var src_K = m1.domainArrowSr(_);
   var tgt_K = m1.domainArrowTg(_);
   val y_E = MMap[Id,Id]();
   val src_D = MMap[Id,Id]();
   val tgt_D = MMap[Id,Id]();
   for(e<-E_D){
     val e_set = e.v
     if(3 == e_set.size){
       
       val e_A = e_set.find(x => "A" == x._3).get
       y_E+=e->e_A._1
       
       val e_uD = e_set.find(x => "uD" == x._3).get
       src_D+=e->e_uD._1 

       val e_vD = e_set.find(x => "vD" == x._3).get
       tgt_D+=e->e_vD._1
       
     }else{
       val e2 = e_set.head
       if("K" != e2._3){
         sys.error("Programming error")
       }
       y_E+=e->SetId(Set((m_E(a_E(e2._1)),gid,e2._3)))

       src_D+=e->src_K(e2._1)
       
       tgt_D+=e->tgt_K(e2._1) 
     }		 
   }
    
   val ns1 = SetMorphism(i_V.toMap,V_D.toSet)
   val ns2 = SetMorphism(y_V.toMap,V_A)

   val as1 = SetMorphism(i_E.toMap,E_D.toSet)
   val as2 = SetMorphism(y_E.toMap,E_A)
   
   val arrowsSrTg_D = ArrowSrTg(src_D.toMap,tgt_D.toMap);
   val m1B = ArbitraryMorphismWithIds(ns1,(as1,m1.domainArrowSrTg,arrowsSrTg_D))
   val m2B = ArbitraryMorphismWithIds(ns2,(as2,arrowsSrTg_D,m2.codomainArrowSrTg))
   
   Composition(m1B,m2B);
  }
  
  
  
  def pushoutComplement(gid:Int=GroupIdGen.gen()):Composition = {
	
    //Graph transformation book p. 46
    def pushoutComplementSet(G:Set[Id],L:Set[Id],K:Set[Id],l:Id=>Id,m:Id=>Id) ={
      
      //Morphism on the other side:
      val m1B = MMap[Id,Id]();
      val m2B = MMap[Id,Id]();
      
      val xG = for(x<-G)	yield{
        val y = SetId(Set((x,gid,"G"))); 	   
        m2B+=y->x ;y
      }
      val m_L = for(x<-L)	yield{
        val y = SetId(Set((m(x),gid,"G")));
        m2B-=y 	 
        ;y
      } 
      val m_l_K = for(x<-K)	yield{
        val g = m(l(x))
        val y = SetId(Set((g,gid,"G")));
        m1B+=x->y; 
        m2B+=y->g ;y
      }
	  
      val D:Set[Id] = (xG--m_L) ++ m_l_K
	  
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
        				     case "G" => arrowSr+=id->SetId(Set((m2.codomainArrowSr(i._1),gid,"G")));
        				     			 arrowTg+=id->SetId(Set((m2.codomainArrowTg(i._1),gid,"G"))); 
        				     case _ => sys.error("Programming error"); 
        				   }
        				 }	
        case _		  => sys.error("Programming error");  
      }
    }
    val arrowsSrTg_D = ArrowSrTg(arrowSr.toMap,arrowTg.toMap);
    val m1B = ArbitraryMorphismWithIds(ns1,(as1,m1.domainArrowSrTg,arrowsSrTg_D))
    val m2B = ArbitraryMorphismWithIds(ns2,(as2,arrowsSrTg_D,m2.codomainArrowSrTg))

    Composition(m1B,m2B);
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

  lazy val domainNodes:Set[Id]=inputNodes.map.keySet
  
  lazy val codomainNodes:Set[Id]=inputNodes.codomain ++ inputNodes.map.values.toSet ++ inputArrows._3.sr.values.toSet ++ inputArrows._3.tg.values.toSet
  
  lazy val domainArrows:Set[Id]=inputArrows._1.map.keySet
  
  lazy val codomainArrows:Set[Id]=inputArrows._1.codomain++inputArrows._1.map.values.toSet
 
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
        	  case Some(ex) =>  if(ex != codomain.id){sys.error("Arrow " + domain.id + " mapped twice: " + codomain.id + ", " + ex)}
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
	  case Some(ex) =>  if(ex != codomain.id) sys.error("Node " + domain.id + " mapped twice: " + codomain.id + ", " + ex)
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

  lazy val domainNodes:Set[Id]=nodes.keySet.toSet
  
  lazy val codomainNodes:Set[Id]=codomainNodesSet.toSet
  
  lazy val domainArrows:Set[Id]=arrows.keySet.toSet
  
  lazy val codomainArrows:Set[Id]=Set((for{(_,a)<-inputArrows} yield {a.id}) toSeq: _ *)

} 

/**
 * Typing Morphism  
 */
case class TypingMorphism(input:AbstractGraph) extends Morphism{
  
  override lazy val immutable:Boolean = !input.getClass().getPackage().getName().endsWith("mutable") 	
  
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

  private lazy val domainnodes:Set[Id] = mkDomainNodes()    
  def domainNodes():Set[Id]= immutable match {case true => domainnodes; case _ => mkDomainNodes()}
  private def mkDomainNodes():Set[Id]={
    Set((for{n<-input.nodes.values} yield {n.id}) toSeq: _ *)
  }
  
  private lazy val codomainnodes:Set[Id] = mkCodomainNodes()    
  def codomainNodes():Set[Id]= immutable match {case true => codomainnodes; case _ => mkCodomainNodes()}
  private def mkCodomainNodes():Set[Id]={
    Set((for{n<-input.mmGraph.nodes.values} yield {n.id}) toSeq: _ *)
  }

  private lazy val domainarrows:Set[Id]= mkDomainArrows() 
  def domainArrows():Set[Id]= immutable match {case true => domainarrows; case _ => mkDomainArrows()}
  private def mkDomainArrows():Set[Id]={
    Set((for{a<-input.arrows.values} yield {a.id}) toSeq: _ *)
  }
  
  private lazy val codomainarrows:Set[Id]=mkCodomainArrows()
  def codomainArrows():Set[Id]= immutable match {case true => codomainarrows; case _ => mkCodomainArrows()}
  private def mkCodomainArrows():Set[Id]={
    Set((for{n<-input.mmGraph.arrows.values} yield {n.id}) toSeq: _ *)
  }
  
} 

/**
 * Inclusion Morphism  
 */
case class InclusionMorphism(inputSub:AbstractGraph, input:AbstractGraph) extends Morphism{

  override lazy val immutable:Boolean = !inputSub.getClass().getPackage().getName().endsWith("mutable") && 
		  								!input.getClass().getPackage().getName().endsWith("mutable")	
  
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
    input.arrows(id).sr.id
  }
  
  def codomainArrowTg(id:Id):Id={
    input.arrows(id).tg.id
  }

  private lazy val domainnodes:Set[Id] = mkDomainNodes()    
  def domainNodes():Set[Id]= immutable match {case true => domainnodes; case _ => mkDomainNodes()}
  private def mkDomainNodes():Set[Id]={
    Set((for{n<-inputSub.nodes.values} yield {n.id}) toSeq: _ *)
  }
  
  private lazy val codomainnodes:Set[Id] = mkCodomainNodes()    
  def codomainNodes():Set[Id]= immutable match {case true => codomainnodes; case _ => mkCodomainNodes()}
  private def mkCodomainNodes():Set[Id]={
    Set((for{n<-input.nodes.values} yield {n.id}) toSeq: _ *)
  }

  private lazy val domainarrows:Set[Id]= mkDomainArrows() 
  def domainArrows():Set[Id]= immutable match {case true => domainarrows; case _ => mkDomainArrows()}
  private def mkDomainArrows():Set[Id]={
    Set((for{a<-inputSub.arrows.values} yield {a.id}) toSeq: _ *)
  }
  
  private lazy val codomainarrows:Set[Id]=mkCodomainArrows()
  def codomainArrows():Set[Id]= immutable match {case true => codomainarrows; case _ => mkCodomainArrows()}
  private def mkCodomainArrows():Set[Id]={
    Set((for{n<-input.arrows.values} yield {n.id}) toSeq: _ *)
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
	
	  var start = System.currentTimeMillis
	  
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

		  val pushout:Cospan = span.pushout()
		  
//		  println(pushout.left);
//		  println(pushout.right);
		  
	  }	
	  

	  //
	  //Test Pushout Complement (Fudamentals of Algebraic Graph Transformation, page. 13 )
	  //
	  {
		  //G_L
		  val a100 = arrow(100,1,2)
		  val a101 = arrow(101,1,3)
		  val a102 = arrow(102,2,3)
	    
		  //G_K
		  val n21 = node(21)
		  val n22 = node(22)
	    
		  //G_R
		  val a300 = arrow(300,31,34)
		  val a301 = arrow(301,34,32)
		  val a302 = arrow(302,31,35)
		  val a303 = arrow(303,35,32)
		  
		  //G_G
		  val a400 = arrow(400,41,42)
		  val a401 = arrow(401,41,43)
		  val a402 = arrow(402,42,43)
		  val a403 = arrow(403,41,46)
		  val a404 = arrow(404,46,47)
		  val a405 = arrow(405,42,47)
		  
		  
		  val l = ArbitraryMorphism(Set((Some(n21),node(1)),
				  						(Some(n22),node(2))
				  					),Set((None,a100),
				  					      (None,a101),
				  					      (None,a102)
				  					));

		  val r = ArbitraryMorphism(Set((Some(n21),node(31)),
				  						(Some(n22),node(32))
				  					),Set((None,a300),
				  					      (None,a301),
				  					      (None,a302),
				  					      (None,a303)
				  					));

		  
		  
		  val m = ArbitraryMorphism(Set(),Set(
				  					(Some(a100),a400),
				  					(Some(a101),a401),
				  					(Some(a102),a402),
				  					(None,a403),
				  					(None,a404),
				  					(None,a405)
				  					));
		  
		  val comp = Composition(l,m)

		  val pushoutComplement:Composition = comp.pushoutComplement()
		  
//		  println(pushoutComplement.m1);
//		  println(pushoutComplement.m2);
		  
		  val span = Span(pushoutComplement.m1,r)
		  
		  val pushout:Cospan = span.pushout()
		  
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
		  
		  val pullback:Span = cospan.pullback()
		  
//		  println(pullback.left);
//		  println(pullback.right);
		  
	  }

	  //
	  //Test Final Pullback Complement for Monic Matches: Sesqui-pushout rewriting (Andrea Corradini et. al.) Fig 3. Left-Part
	  
	  //
	  {
	  
	  //L:
	  val n1 = node(1)   

	  //K:
	  val n2 = node(2)   
	  val n3 = node(3)   

	  //A:
	  val a11 = arrow(11,4,5);
	  val a12 = arrow(12,4,6);
	  val a13 = arrow(13,4,6);
	  
	  val alpha = ArbitraryMorphism(Set(
			  						(Some(n2),n1),
			  						(Some(n3),n1)
			  						),Set());
		  
	  val m = ArbitraryMorphism(Set(
			  						(Some(n1),node(4))
			  					),Set(
			  					(None,a11),
			  					(None,a12),
			  					(None,a13)));
	  
	  val comp = Composition(alpha,m)

	  val pullbackComplement:Composition = comp.fPullbackComplementMono();
	  
	  println(pullbackComplement.m1);
	  println(pullbackComplement.m2);
	  
	  } 	  
	  println("Time spent:" + (System.currentTimeMillis - start))
	  
	}
	
}
