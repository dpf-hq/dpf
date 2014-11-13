//signatures for nodes
sig NP{}
sig NFlag{}
sig NR{}
sig NIsActive{}
sig NAt{}
sig NT{}

//signatures for edges
sig AisActive{src:one NP, trg:one NIsActive}
sig Aat{src:one NP, trg:one NAt}
sig Aflag{src:one NP, trg:one NFlag}
sig ATP{src:one NT, trg:one NP}
sig ATR{src:one NT, trg:one NR}
sig APR{src:one NP, trg:one NR}

sig Graph{nodes:set NP+NFlag+NR+NIsActive+NAt+NT, arrows:set AisActive+Aat+Aflag+ATP+ATR+APR}

//In a graph, the source and target node of each contained edge should be also contained by the graph
pred to_be_graph[graph:Graph]{
	all arrow : AisActive&graph.arrows|(arrow.src in graph.nodes and arrow.trg in graph.nodes)
	all arrow : Aat&graph.arrows|(arrow.src in graph.nodes and arrow.trg in graph.nodes)
	all arrow : Aflag&graph.arrows|(arrow.src in graph.nodes and arrow.trg in graph.nodes)
	all arrow : ATP&graph.arrows|(arrow.src in graph.nodes and arrow.trg in graph.nodes)
	all arrow : ATR&graph.arrows|(arrow.src in graph.nodes and arrow.trg in graph.nodes)
	all arrow : APR&graph.arrows|(arrow.src in graph.nodes and arrow.trg in graph.nodes)
}

one abstract sig Rule{}
lone sig setFlag, setTurn1, setTurn2, enter, exit extends Rule{}

sig Trans{rule:one Rule, source:one Graph, target:one Graph, dnodes:set NP+NFlag+NR+NIsActive+NAt+NT, darrows:set AisActive+Aat+Aflag+ATP+ATR+APR, anodes:set NP+NFlag+NR+NIsActive+NAt+NT, aarrows:set AisActive+Aat+Aflag+ATP+ATR+APR}

//No dangle edges after a transformation
pred no_dangle_arrow[trans:Trans]{
	all arrow : AisActive|(arrow.src in trans.dnodes or arrow.trg in trans.dnodes) implies arrow in trans.darrows
	all arrow : AisActive|(arrow.src in trans.anodes or arrow.trg in trans.anodes) implies arrow in trans.aarrows
	all arrow : Aat|(arrow.src in trans.dnodes or arrow.trg in trans.dnodes) implies arrow in trans.darrows
	all arrow : Aat|(arrow.src in trans.anodes or arrow.trg in trans.anodes) implies arrow in trans.aarrows
	all arrow : Aflag|(arrow.src in trans.dnodes or arrow.trg in trans.dnodes) implies arrow in trans.darrows
	all arrow : Aflag|(arrow.src in trans.anodes or arrow.trg in trans.anodes) implies arrow in trans.aarrows
	all arrow : ATP|(arrow.src in trans.dnodes or arrow.trg in trans.dnodes) implies arrow in trans.darrows
	all arrow : ATP|(arrow.src in trans.anodes or arrow.trg in trans.anodes) implies arrow in trans.aarrows
	all arrow : ATR|(arrow.src in trans.dnodes or arrow.trg in trans.dnodes) implies arrow in trans.darrows
	all arrow : ATR|(arrow.src in trans.anodes or arrow.trg in trans.anodes) implies arrow in trans.aarrows
	all arrow : APR|(arrow.src in trans.dnodes or arrow.trg in trans.dnodes) implies arrow in trans.darrows
	all arrow : APR|(arrow.src in trans.anodes or arrow.trg in trans.anodes) implies arrow in trans.aarrows
}

//general constraints for transformations
fact{
	(Trans.source+Trans.target)=Graph
	Rule=Trans.rule
	all graph:Graph|to_be_graph[graph]
	Graph.nodes=NP+NFlag+NR+NIsActive+NAt+NT
	Graph.arrows=AisActive+Aat+Aflag+ATP+ATR+APR
	all trans:Trans | no_dangle_arrow[trans] and trans_general[trans] and source_valid[trans] and (
	rule_setFlag[trans] or rule_setTurn1[trans] or rule_setTurn2[trans] or rule_enter[trans] or rule_exit[trans])
}

//the predicate that the transformation is an application of the rule setFlag
pred rule_setFlag[trans:Trans]{
	some trans.rule&setFlag

some isActive0:AisActive&trans.darrows|let P0=isActive0.src,BF=isActive0.trg|(P0 in (trans.source.nodes-trans.dnodes) and BF in trans.dnodes and (some flag0:Aflag&trans.darrows|let F0=flag0.trg|(flag0.src=P0 and F0 in trans.dnodes)
))

some isActive0:AisActive&trans.darrows|let P0=isActive0.src,BF=isActive0.trg|(P0 in (trans.source.nodes-trans.dnodes) and BF in trans.dnodes and (some at0:Aat&trans.darrows|let start=at0.trg|(at0.src=P0 and start in trans.dnodes)
))

some isActive0:AisActive&trans.darrows|let P0=isActive0.src,BF=isActive0.trg|(P0 in (trans.source.nodes-trans.dnodes) and BF in trans.dnodes)
some NP&(trans.source.nodes-trans.dnodes)
some NP&(trans.source.nodes-trans.dnodes)
some NP&(trans.source.nodes-trans.dnodes)
some NR&(trans.source.nodes-trans.dnodes)

some isActive1:AisActive&trans.aarrows|let P0=isActive1.src,BT=isActive1.trg|(P0 in (trans.source.nodes-trans.dnodes) and BT in trans.anodes and (some flag1:Aflag&trans.aarrows|let F1=flag1.trg|(flag1.src=P0 and F1 in trans.anodes)
))

some isActive1:AisActive&trans.aarrows|let P0=isActive1.src,BT=isActive1.trg|(P0 in (trans.source.nodes-trans.dnodes) and BT in trans.anodes and (some PR0:APR&trans.aarrows|let R0=PR0.trg|(PR0.src=P0 and R0 in (trans.source.nodes-trans.dnodes))
))

some isActive1:AisActive&trans.aarrows|let P0=isActive1.src,BT=isActive1.trg|(P0 in (trans.source.nodes-trans.dnodes) and BT in trans.anodes and (some at1:Aat&trans.aarrows|let setTurn=at1.trg|(at1.src=P0 and setTurn in trans.anodes)
))

some isActive1:AisActive&trans.aarrows|let P0=isActive1.src,BT=isActive1.trg|(P0 in (trans.source.nodes-trans.dnodes) and BT in trans.anodes)
some NP&(trans.source.nodes-trans.dnodes)
some NP&(trans.source.nodes-trans.dnodes)
some NP&(trans.source.nodes-trans.dnodes)
some NP&(trans.source.nodes-trans.dnodes)

some P0:NP&(trans.source.nodes-trans.dnodes)|(some isActive0:AisActive&trans.darrows|isActive0.src=P0) and (some flag0:Aflag&trans.darrows|flag0.src=P0) and (some at0:Aat&trans.darrows|at0.src=P0) and (some isActive1:AisActive&trans.aarrows|isActive1.src=P0) and (some flag1:Aflag&trans.aarrows|flag1.src=P0) and (some PR0:APR&trans.aarrows|PR0.src=P0) and (some at1:Aat&trans.aarrows|at1.src=P0)
#NAt&trans.dnodes = 1
#NIsActive&trans.dnodes = 1
#NFlag&trans.dnodes = 1
#NAt&trans.anodes = 1
#NIsActive&trans.anodes = 1
#NFlag&trans.anodes = 1
#AisActive&trans.darrows = 1
#Aflag&trans.darrows = 1
#Aat&trans.darrows = 1
#AisActive&trans.aarrows = 1
#Aflag&trans.aarrows = 1
#Aat&trans.aarrows = 1
#APR&trans.aarrows = 1
no NP&trans.dnodes
no NR&trans.dnodes
no NT&trans.dnodes
no NP&trans.anodes
no NR&trans.anodes
no NT&trans.anodes
no ATP&trans.darrows
no ATR&trans.darrows
no APR&trans.darrows
no ATP&trans.aarrows
no ATR&trans.aarrows
}

//the predicate that the transformation is an application of the rule setTurn1
pred rule_setTurn1[trans:Trans]{
	some trans.rule&setTurn1

some TP0:ATP&trans.darrows|let T0=TP0.src,P0=TP0.trg|(T0 in (trans.source.nodes-trans.dnodes) and P0 in (trans.source.nodes-trans.dnodes) and (some TR0:ATR&(trans.source.arrows-trans.darrows)|let R0=TR0.trg|(TR0.src=T0 and R0 in (trans.source.nodes-trans.dnodes))
) and (some isActive0:AisActive&(trans.source.arrows-trans.darrows)|let BF=isActive0.trg|(isActive0.src=P0 and BF in (trans.source.nodes-trans.dnodes))
))
some at0:Aat&trans.darrows|let P1=at0.src,setTurn=at0.trg|(P1 in (trans.source.nodes-trans.dnodes) and setTurn in trans.dnodes)

some isActive0:AisActive&(trans.source.arrows-trans.darrows)|let P0=isActive0.src,BF=isActive0.trg|(P0 in (trans.source.nodes-trans.dnodes) and BF in (trans.source.nodes-trans.dnodes))
some TP1:ATP&trans.aarrows|let T0=TP1.src,P1=TP1.trg|(T0 in (trans.source.nodes-trans.dnodes) and P1 in (trans.source.nodes-trans.dnodes) and (some at1:Aat&trans.aarrows|let _check=at1.trg|(at1.src=P1 and _check in trans.anodes)
))

some TP1:ATP&trans.aarrows|let T0=TP1.src,P1=TP1.trg|(T0 in (trans.source.nodes-trans.dnodes) and P1 in (trans.source.nodes-trans.dnodes))
some TR0:ATR&(trans.source.arrows-trans.darrows)|let T0=TR0.src,R0=TR0.trg|(T0 in (trans.source.nodes-trans.dnodes) and R0 in (trans.source.nodes-trans.dnodes) and (some TP1:ATP&trans.aarrows|let P1=TP1.trg|(TP1.src=T0 and P1 in (trans.source.nodes-trans.dnodes))
))
some NP&(trans.source.nodes-trans.dnodes)

some P1:NP&(trans.source.nodes-trans.dnodes)|(some at0:Aat&trans.darrows|at0.src=P1) and (some TP1:ATP&trans.aarrows|TP1.trg=P1) and (some at1:Aat&trans.aarrows|at1.src=P1)
some T0:NT&(trans.source.nodes-trans.dnodes)|(some TP0:ATP&trans.darrows|TP0.src=T0) and (some TP1:ATP&trans.aarrows|TP1.src=T0)
#NAt&trans.dnodes = 1
#NAt&trans.anodes = 1
#ATP&trans.darrows = 1
#Aat&trans.darrows = 1
#ATP&trans.aarrows = 1
#Aat&trans.aarrows = 1
no NP&trans.dnodes
no NFlag&trans.dnodes
no NR&trans.dnodes
no NIsActive&trans.dnodes
no NT&trans.dnodes
no NP&trans.anodes
no NFlag&trans.anodes
no NR&trans.anodes
no NIsActive&trans.anodes
no NT&trans.anodes
no AisActive&trans.darrows
no Aflag&trans.darrows
no ATR&trans.darrows
no APR&trans.darrows
no AisActive&trans.aarrows
no Aflag&trans.aarrows
no ATR&trans.aarrows
no APR&trans.aarrows
}

//the predicate that the transformation is an application of the rule setTurn2
pred rule_setTurn2[trans:Trans]{
	some trans.rule&setTurn2

some TP0:ATP&(trans.source.arrows-trans.darrows)|let T0=TP0.src,P0=TP0.trg|(T0 in (trans.source.nodes-trans.dnodes) and P0 in (trans.source.nodes-trans.dnodes) and (some TR0:ATR&(trans.source.arrows-trans.darrows)|let R0=TR0.trg|(TR0.src=T0 and R0 in (trans.source.nodes-trans.dnodes))
) and (some at0:Aat&trans.darrows|let setTurn=at0.trg|(at0.src=P0 and setTurn in trans.dnodes)
))

some TP0:ATP&(trans.source.arrows-trans.darrows)|let T0=TP0.src,P0=TP0.trg|(T0 in (trans.source.nodes-trans.dnodes) and P0 in (trans.source.nodes-trans.dnodes) and (some TR0:ATR&(trans.source.arrows-trans.darrows)|let R0=TR0.trg|(TR0.src=T0 and R0 in (trans.source.nodes-trans.dnodes))
) and (some at1:Aat&trans.aarrows|let _check=at1.trg|(at1.src=P0 and _check in trans.anodes)
))

some P0:NP&(trans.source.nodes-trans.dnodes)|(some at0:Aat&trans.darrows|at0.src=P0) and (some at1:Aat&trans.aarrows|at1.src=P0)
#NAt&trans.dnodes = 1
#NAt&trans.anodes = 1
#Aat&trans.darrows = 1
#Aat&trans.aarrows = 1
no NP&trans.dnodes
no NFlag&trans.dnodes
no NR&trans.dnodes
no NIsActive&trans.dnodes
no NT&trans.dnodes
no NP&trans.anodes
no NFlag&trans.anodes
no NR&trans.anodes
no NIsActive&trans.anodes
no NT&trans.anodes
no AisActive&trans.darrows
no Aflag&trans.darrows
no ATP&trans.darrows
no ATR&trans.darrows
no APR&trans.darrows
no AisActive&trans.aarrows
no Aflag&trans.aarrows
no ATP&trans.aarrows
no ATR&trans.aarrows
no APR&trans.aarrows
}

//the predicate that the transformation is an application of the rule enter
pred rule_enter[trans:Trans]{
	some trans.rule&enter

some flag0:Aflag&trans.darrows|let P0=flag0.src,F1=flag0.trg|(P0 in (trans.source.nodes-trans.dnodes) and F1 in trans.dnodes and (some at0:Aat&trans.darrows|let _check=at0.trg|(at0.src=P0 and _check in trans.dnodes)
))

some TP0:ATP&(trans.source.arrows-trans.darrows)|let T0=TP0.src,P0=TP0.trg|(T0 in (trans.source.nodes-trans.dnodes) and P0 in (trans.source.nodes-trans.dnodes) and (some TR0:ATR&(trans.source.arrows-trans.darrows)|let R0=TR0.trg|(TR0.src=T0 and R0 in (trans.source.nodes-trans.dnodes) and (some PR0:APR&(trans.source.arrows-trans.darrows)|PR0.src=P0 and PR0.trg =R0))
) and (some flag0:Aflag&trans.darrows|let F1=flag0.trg|(flag0.src=P0 and F1 in trans.dnodes)
))
some NP&(trans.source.nodes-trans.dnodes)
some NP&(trans.source.nodes-trans.dnodes)

some flag1:Aflag&trans.aarrows|let P0=flag1.src,F2=flag1.trg|(P0 in (trans.source.nodes-trans.dnodes) and F2 in trans.anodes and (some at1:Aat&trans.aarrows|let crit=at1.trg|(at1.src=P0 and crit in trans.anodes)
))

some TP0:ATP&(trans.source.arrows-trans.darrows)|let T0=TP0.src,P0=TP0.trg|(T0 in (trans.source.nodes-trans.dnodes) and P0 in (trans.source.nodes-trans.dnodes) and (some TR0:ATR&(trans.source.arrows-trans.darrows)|let R0=TR0.trg|(TR0.src=T0 and R0 in (trans.source.nodes-trans.dnodes) and (some PR0:APR&(trans.source.arrows-trans.darrows)|PR0.src=P0 and PR0.trg =R0))
) and (some flag1:Aflag&trans.aarrows|let F2=flag1.trg|(flag1.src=P0 and F2 in trans.anodes)
))
some NP&(trans.source.nodes-trans.dnodes)
some NP&(trans.source.nodes-trans.dnodes)

some P0:NP&(trans.source.nodes-trans.dnodes)|(some flag0:Aflag&trans.darrows|flag0.src=P0) and (some at0:Aat&trans.darrows|at0.src=P0) and (some flag1:Aflag&trans.aarrows|flag1.src=P0) and (some at1:Aat&trans.aarrows|at1.src=P0)
#NAt&trans.dnodes = 1
#NFlag&trans.dnodes = 1
#NAt&trans.anodes = 1
#NFlag&trans.anodes = 1
#Aflag&trans.darrows = 1
#Aat&trans.darrows = 1
#Aflag&trans.aarrows = 1
#Aat&trans.aarrows = 1
no NP&trans.dnodes
no NR&trans.dnodes
no NIsActive&trans.dnodes
no NT&trans.dnodes
no NP&trans.anodes
no NR&trans.anodes
no NIsActive&trans.anodes
no NT&trans.anodes
no AisActive&trans.darrows
no ATP&trans.darrows
no ATR&trans.darrows
no APR&trans.darrows
no AisActive&trans.aarrows
no ATP&trans.aarrows
no ATR&trans.aarrows
no APR&trans.aarrows
}

//the predicate that the transformation is an application of the rule exit
pred rule_exit[trans:Trans]{
	some trans.rule&exit

some flag1:Aflag&trans.darrows|let P0=flag1.src,F2=flag1.trg|(P0 in (trans.source.nodes-trans.dnodes) and F2 in trans.dnodes and (some at0:Aat&trans.darrows|let crit=at0.trg|(at0.src=P0 and crit in trans.dnodes)
))

some flag1:Aflag&trans.darrows|let P0=flag1.src,F2=flag1.trg|(P0 in (trans.source.nodes-trans.dnodes) and F2 in trans.dnodes and (some isActive0:AisActive&trans.darrows|let BT=isActive0.trg|(isActive0.src=P0 and BT in trans.dnodes)
))

some flag1:Aflag&trans.darrows|let P0=flag1.src,F2=flag1.trg|(P0 in (trans.source.nodes-trans.dnodes) and F2 in trans.dnodes and (some PR0:APR&trans.darrows|let R0=PR0.trg|(PR0.src=P0 and R0 in (trans.source.nodes-trans.dnodes))
))

some flag1:Aflag&trans.darrows|let P0=flag1.src,F2=flag1.trg|(P0 in (trans.source.nodes-trans.dnodes) and F2 in trans.dnodes)
some NP&(trans.source.nodes-trans.dnodes)
some NP&(trans.source.nodes-trans.dnodes)
some NP&(trans.source.nodes-trans.dnodes)
some NP&(trans.source.nodes-trans.dnodes)

some flag0:Aflag&trans.aarrows|let P0=flag0.src,F0=flag0.trg|(P0 in (trans.source.nodes-trans.dnodes) and F0 in trans.anodes and (some at1:Aat&trans.aarrows|let start=at1.trg|(at1.src=P0 and start in trans.anodes)
))

some flag0:Aflag&trans.aarrows|let P0=flag0.src,F0=flag0.trg|(P0 in (trans.source.nodes-trans.dnodes) and F0 in trans.anodes and (some isActive1:AisActive&trans.aarrows|let BF=isActive1.trg|(isActive1.src=P0 and BF in trans.anodes)
))

some flag0:Aflag&trans.aarrows|let P0=flag0.src,F0=flag0.trg|(P0 in (trans.source.nodes-trans.dnodes) and F0 in trans.anodes)
some NP&(trans.source.nodes-trans.dnodes)
some NP&(trans.source.nodes-trans.dnodes)
some NP&(trans.source.nodes-trans.dnodes)
some NR&(trans.source.nodes-trans.dnodes)

some P0:NP&(trans.source.nodes-trans.dnodes)|(some flag1:Aflag&trans.darrows|flag1.src=P0) and (some at0:Aat&trans.darrows|at0.src=P0) and (some isActive0:AisActive&trans.darrows|isActive0.src=P0) and (some PR0:APR&trans.darrows|PR0.src=P0) and (some flag0:Aflag&trans.aarrows|flag0.src=P0) and (some at1:Aat&trans.aarrows|at1.src=P0) and (some isActive1:AisActive&trans.aarrows|isActive1.src=P0)
#NAt&trans.dnodes = 1
#NIsActive&trans.dnodes = 1
#NFlag&trans.dnodes = 1
#NAt&trans.anodes = 1
#NIsActive&trans.anodes = 1
#NFlag&trans.anodes = 1
#AisActive&trans.darrows = 1
#Aflag&trans.darrows = 1
#Aat&trans.darrows = 1
#APR&trans.darrows = 1
#AisActive&trans.aarrows = 1
#Aflag&trans.aarrows = 1
#Aat&trans.aarrows = 1
no NP&trans.dnodes
no NR&trans.dnodes
no NT&trans.dnodes
no NP&trans.anodes
no NR&trans.anodes
no NT&trans.anodes
no ATP&trans.darrows
no ATR&trans.darrows
no ATP&trans.aarrows
no ATR&trans.aarrows
no APR&trans.aarrows
}

//The general constraints of a transformation
pred trans_general[trans:Trans]{
	some trans.dnodes or some trans.darrows or some trans.anodes or some trans.aarrows
	trans.dnodes in trans.source.nodes
	trans.darrows in trans.source.arrows
	trans.anodes in trans.target.nodes
	trans.aarrows in trans.target.arrows
	no (trans.dnodes & trans.anodes)
	no (trans.darrows & trans.aarrows)
	trans.source.nodes-trans.dnodes=trans.target.nodes-trans.anodes
	trans.source.arrows-trans.darrows=trans.target.arrows-trans.aarrows
}
pred source_valid[trans:Trans]{
//mulitplicity on TR:T->R[0,1]
all n:(NT&trans.source.nodes)| lone e:(ATR&trans.source.arrows)|e.src=n
//mulitplicity on PR:P->R[0,1]
all n:(NP&trans.source.nodes)| lone e:(APR&trans.source.arrows)|e.src=n
//mulitplicity on T min:1;max:1
let count = #NT&trans.source.nodes | count>=1 and count <=1
//mulitplicity on R min:1;max:1
let count = #NR&trans.source.nodes | count>=1 and count <=1
//check injective on TR:T->R
all n:(NT&trans.source.nodes)| no e1, e2:(ATR&trans.source.arrows)| (e1 != e2 and e1.src = n and e2.src = n and e1.trg = e2.trg)
//surjective on TR:T->R
all n:(NR&trans.source.nodes)| some e:(ATR&trans.source.arrows)| e.trg = n
//mulitplicity on TP:T->Pmin:1;max:1
all n:(NT&trans.source.nodes)| let count = #{e:(ATP&trans.source.arrows)| e.src = n}| count>=1 and count <=1
//mulitplicity on flag:P->Flagmin:1;max:1
all n:(NP&trans.source.nodes)| let count = #{e:(Aflag&trans.source.arrows)| e.src = n}| count>=1 and count <=1
//mulitplicity on at:P->Atmin:1;max:1
all n:(NP&trans.source.nodes)| let count = #{e:(Aat&trans.source.arrows)| e.src = n}| count>=1 and count <=1
//mulitplicity on isActive:P->IsActivemin:1;max:1
all n:(NP&trans.source.nodes)| let count = #{e:(AisActive&trans.source.arrows)| e.src = n}| count>=1 and count <=1
}
check{all trans: Trans|//mulitplicity on TR:T->R[0,1]
all n:(NT&trans.target.nodes)| lone e:(ATR&trans.target.arrows)|e.src=n
}for 3 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//mulitplicity on PR:P->R[0,1]
all n:(NP&trans.target.nodes)| lone e:(APR&trans.target.arrows)|e.src=n
}for 3 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//mulitplicity on T min:1;max:1
let count = #NT&trans.target.nodes | count>=1 and count <=1
}for 3 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//mulitplicity on R min:1;max:1
let count = #NR&trans.target.nodes | count>=1 and count <=1
}for 3 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//check injective on TR:T->R
all n:(NT&trans.target.nodes)| no e1, e2:(ATR&trans.target.arrows)| (e1 != e2 and e1.src = n and e2.src = n and e1.trg = e2.trg)
}for 3 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//surjective on TR:T->R
all n:(NR&trans.target.nodes)| some e:(ATR&trans.target.arrows)| e.trg = n
}for 3 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//mulitplicity on TP:T->Pmin:1;max:1
all n:(NT&trans.target.nodes)| let count = #{e:(ATP&trans.target.arrows)| e.src = n}| count>=1 and count <=1
}for 3 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//mulitplicity on flag:P->Flagmin:1;max:1
all n:(NP&trans.target.nodes)| let count = #{e:(Aflag&trans.target.arrows)| e.src = n}| count>=1 and count <=1
}for 3 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//mulitplicity on at:P->Atmin:1;max:1
all n:(NP&trans.target.nodes)| let count = #{e:(Aat&trans.target.arrows)| e.src = n}| count>=1 and count <=1
}for 3 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//mulitplicity on isActive:P->IsActivemin:1;max:1
all n:(NP&trans.target.nodes)| let count = #{e:(AisActive&trans.target.arrows)| e.src = n}| count>=1 and count <=1
}for 3 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//mulitplicity on TR:T->R[0,1]
all n:(NT&trans.target.nodes)| lone e:(ATR&trans.target.arrows)|e.src=n
}for 4 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//mulitplicity on PR:P->R[0,1]
all n:(NP&trans.target.nodes)| lone e:(APR&trans.target.arrows)|e.src=n
}for 4 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//mulitplicity on T min:1;max:1
let count = #NT&trans.target.nodes | count>=1 and count <=1
}for 4 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//mulitplicity on R min:1;max:1
let count = #NR&trans.target.nodes | count>=1 and count <=1
}for 4 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//check injective on TR:T->R
all n:(NT&trans.target.nodes)| no e1, e2:(ATR&trans.target.arrows)| (e1 != e2 and e1.src = n and e2.src = n and e1.trg = e2.trg)
}for 4 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//surjective on TR:T->R
all n:(NR&trans.target.nodes)| some e:(ATR&trans.target.arrows)| e.trg = n
}for 4 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//mulitplicity on TP:T->Pmin:1;max:1
all n:(NT&trans.target.nodes)| let count = #{e:(ATP&trans.target.arrows)| e.src = n}| count>=1 and count <=1
}for 4 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//mulitplicity on flag:P->Flagmin:1;max:1
all n:(NP&trans.target.nodes)| let count = #{e:(Aflag&trans.target.arrows)| e.src = n}| count>=1 and count <=1
}for 4 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//mulitplicity on at:P->Atmin:1;max:1
all n:(NP&trans.target.nodes)| let count = #{e:(Aat&trans.target.arrows)| e.src = n}| count>=1 and count <=1
}for 4 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//mulitplicity on isActive:P->IsActivemin:1;max:1
all n:(NP&trans.target.nodes)| let count = #{e:(AisActive&trans.target.arrows)| e.src = n}| count>=1 and count <=1
}for 4 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//mulitplicity on TR:T->R[0,1]
all n:(NT&trans.target.nodes)| lone e:(ATR&trans.target.arrows)|e.src=n
}for 5 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//mulitplicity on PR:P->R[0,1]
all n:(NP&trans.target.nodes)| lone e:(APR&trans.target.arrows)|e.src=n
}for 5 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//mulitplicity on T min:1;max:1
let count = #NT&trans.target.nodes | count>=1 and count <=1
}for 5 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//mulitplicity on R min:1;max:1
let count = #NR&trans.target.nodes | count>=1 and count <=1
}for 5 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//check injective on TR:T->R
all n:(NT&trans.target.nodes)| no e1, e2:(ATR&trans.target.arrows)| (e1 != e2 and e1.src = n and e2.src = n and e1.trg = e2.trg)
}for 5 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//surjective on TR:T->R
all n:(NR&trans.target.nodes)| some e:(ATR&trans.target.arrows)| e.trg = n
}for 5 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//mulitplicity on TP:T->Pmin:1;max:1
all n:(NT&trans.target.nodes)| let count = #{e:(ATP&trans.target.arrows)| e.src = n}| count>=1 and count <=1
}for 5 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//mulitplicity on flag:P->Flagmin:1;max:1
all n:(NP&trans.target.nodes)| let count = #{e:(Aflag&trans.target.arrows)| e.src = n}| count>=1 and count <=1
}for 5 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//mulitplicity on at:P->Atmin:1;max:1
all n:(NP&trans.target.nodes)| let count = #{e:(Aat&trans.target.arrows)| e.src = n}| count>=1 and count <=1
}for 5 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//mulitplicity on isActive:P->IsActivemin:1;max:1
all n:(NP&trans.target.nodes)| let count = #{e:(AisActive&trans.target.arrows)| e.src = n}| count>=1 and count <=1
}for 5 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//mulitplicity on TR:T->R[0,1]
all n:(NT&trans.target.nodes)| lone e:(ATR&trans.target.arrows)|e.src=n
}for 6 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//mulitplicity on PR:P->R[0,1]
all n:(NP&trans.target.nodes)| lone e:(APR&trans.target.arrows)|e.src=n
}for 6 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//mulitplicity on T min:1;max:1
let count = #NT&trans.target.nodes | count>=1 and count <=1
}for 6 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//mulitplicity on R min:1;max:1
let count = #NR&trans.target.nodes | count>=1 and count <=1
}for 6 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//check injective on TR:T->R
all n:(NT&trans.target.nodes)| no e1, e2:(ATR&trans.target.arrows)| (e1 != e2 and e1.src = n and e2.src = n and e1.trg = e2.trg)
}for 6 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//surjective on TR:T->R
all n:(NR&trans.target.nodes)| some e:(ATR&trans.target.arrows)| e.trg = n
}for 6 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//mulitplicity on TP:T->Pmin:1;max:1
all n:(NT&trans.target.nodes)| let count = #{e:(ATP&trans.target.arrows)| e.src = n}| count>=1 and count <=1
}for 6 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//mulitplicity on flag:P->Flagmin:1;max:1
all n:(NP&trans.target.nodes)| let count = #{e:(Aflag&trans.target.arrows)| e.src = n}| count>=1 and count <=1
}for 6 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//mulitplicity on at:P->Atmin:1;max:1
all n:(NP&trans.target.nodes)| let count = #{e:(Aat&trans.target.arrows)| e.src = n}| count>=1 and count <=1
}for 6 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//mulitplicity on isActive:P->IsActivemin:1;max:1
all n:(NP&trans.target.nodes)| let count = #{e:(AisActive&trans.target.arrows)| e.src = n}| count>=1 and count <=1
}for 6 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//mulitplicity on TR:T->R[0,1]
all n:(NT&trans.target.nodes)| lone e:(ATR&trans.target.arrows)|e.src=n
}for 7 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//mulitplicity on PR:P->R[0,1]
all n:(NP&trans.target.nodes)| lone e:(APR&trans.target.arrows)|e.src=n
}for 7 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//mulitplicity on T min:1;max:1
let count = #NT&trans.target.nodes | count>=1 and count <=1
}for 7 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//mulitplicity on R min:1;max:1
let count = #NR&trans.target.nodes | count>=1 and count <=1
}for 7 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//check injective on TR:T->R
all n:(NT&trans.target.nodes)| no e1, e2:(ATR&trans.target.arrows)| (e1 != e2 and e1.src = n and e2.src = n and e1.trg = e2.trg)
}for 7 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//surjective on TR:T->R
all n:(NR&trans.target.nodes)| some e:(ATR&trans.target.arrows)| e.trg = n
}for 7 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//mulitplicity on TP:T->Pmin:1;max:1
all n:(NT&trans.target.nodes)| let count = #{e:(ATP&trans.target.arrows)| e.src = n}| count>=1 and count <=1
}for 7 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//mulitplicity on flag:P->Flagmin:1;max:1
all n:(NP&trans.target.nodes)| let count = #{e:(Aflag&trans.target.arrows)| e.src = n}| count>=1 and count <=1
}for 7 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//mulitplicity on at:P->Atmin:1;max:1
all n:(NP&trans.target.nodes)| let count = #{e:(Aat&trans.target.arrows)| e.src = n}| count>=1 and count <=1
}for 7 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//mulitplicity on isActive:P->IsActivemin:1;max:1
all n:(NP&trans.target.nodes)| let count = #{e:(AisActive&trans.target.arrows)| e.src = n}| count>=1 and count <=1
}for 7 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//mulitplicity on TR:T->R[0,1]
all n:(NT&trans.target.nodes)| lone e:(ATR&trans.target.arrows)|e.src=n
}for 8 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//mulitplicity on PR:P->R[0,1]
all n:(NP&trans.target.nodes)| lone e:(APR&trans.target.arrows)|e.src=n
}for 8 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//mulitplicity on T min:1;max:1
let count = #NT&trans.target.nodes | count>=1 and count <=1
}for 8 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//mulitplicity on R min:1;max:1
let count = #NR&trans.target.nodes | count>=1 and count <=1
}for 8 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//check injective on TR:T->R
all n:(NT&trans.target.nodes)| no e1, e2:(ATR&trans.target.arrows)| (e1 != e2 and e1.src = n and e2.src = n and e1.trg = e2.trg)
}for 8 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//surjective on TR:T->R
all n:(NR&trans.target.nodes)| some e:(ATR&trans.target.arrows)| e.trg = n
}for 8 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//mulitplicity on TP:T->Pmin:1;max:1
all n:(NT&trans.target.nodes)| let count = #{e:(ATP&trans.target.arrows)| e.src = n}| count>=1 and count <=1
}for 8 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//mulitplicity on flag:P->Flagmin:1;max:1
all n:(NP&trans.target.nodes)| let count = #{e:(Aflag&trans.target.arrows)| e.src = n}| count>=1 and count <=1
}for 8 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//mulitplicity on at:P->Atmin:1;max:1
all n:(NP&trans.target.nodes)| let count = #{e:(Aat&trans.target.arrows)| e.src = n}| count>=1 and count <=1
}for 8 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//mulitplicity on isActive:P->IsActivemin:1;max:1
all n:(NP&trans.target.nodes)| let count = #{e:(AisActive&trans.target.arrows)| e.src = n}| count>=1 and count <=1
}for 8 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//mulitplicity on TR:T->R[0,1]
all n:(NT&trans.target.nodes)| lone e:(ATR&trans.target.arrows)|e.src=n
}for 9 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//mulitplicity on PR:P->R[0,1]
all n:(NP&trans.target.nodes)| lone e:(APR&trans.target.arrows)|e.src=n
}for 9 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//mulitplicity on T min:1;max:1
let count = #NT&trans.target.nodes | count>=1 and count <=1
}for 9 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//mulitplicity on R min:1;max:1
let count = #NR&trans.target.nodes | count>=1 and count <=1
}for 9 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//check injective on TR:T->R
all n:(NT&trans.target.nodes)| no e1, e2:(ATR&trans.target.arrows)| (e1 != e2 and e1.src = n and e2.src = n and e1.trg = e2.trg)
}for 9 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//surjective on TR:T->R
all n:(NR&trans.target.nodes)| some e:(ATR&trans.target.arrows)| e.trg = n
}for 9 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//mulitplicity on TP:T->Pmin:1;max:1
all n:(NT&trans.target.nodes)| let count = #{e:(ATP&trans.target.arrows)| e.src = n}| count>=1 and count <=1
}for 9 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//mulitplicity on flag:P->Flagmin:1;max:1
all n:(NP&trans.target.nodes)| let count = #{e:(Aflag&trans.target.arrows)| e.src = n}| count>=1 and count <=1
}for 9 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//mulitplicity on at:P->Atmin:1;max:1
all n:(NP&trans.target.nodes)| let count = #{e:(Aat&trans.target.arrows)| e.src = n}| count>=1 and count <=1
}for 9 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//mulitplicity on isActive:P->IsActivemin:1;max:1
all n:(NP&trans.target.nodes)| let count = #{e:(AisActive&trans.target.arrows)| e.src = n}| count>=1 and count <=1
}for 9 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//mulitplicity on TR:T->R[0,1]
all n:(NT&trans.target.nodes)| lone e:(ATR&trans.target.arrows)|e.src=n
}for 10 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//mulitplicity on PR:P->R[0,1]
all n:(NP&trans.target.nodes)| lone e:(APR&trans.target.arrows)|e.src=n
}for 10 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//mulitplicity on T min:1;max:1
let count = #NT&trans.target.nodes | count>=1 and count <=1
}for 10 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//mulitplicity on R min:1;max:1
let count = #NR&trans.target.nodes | count>=1 and count <=1
}for 10 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//check injective on TR:T->R
all n:(NT&trans.target.nodes)| no e1, e2:(ATR&trans.target.arrows)| (e1 != e2 and e1.src = n and e2.src = n and e1.trg = e2.trg)
}for 10 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//surjective on TR:T->R
all n:(NR&trans.target.nodes)| some e:(ATR&trans.target.arrows)| e.trg = n
}for 10 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//mulitplicity on TP:T->Pmin:1;max:1
all n:(NT&trans.target.nodes)| let count = #{e:(ATP&trans.target.arrows)| e.src = n}| count>=1 and count <=1
}for 10 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//mulitplicity on flag:P->Flagmin:1;max:1
all n:(NP&trans.target.nodes)| let count = #{e:(Aflag&trans.target.arrows)| e.src = n}| count>=1 and count <=1
}for 10 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//mulitplicity on at:P->Atmin:1;max:1
all n:(NP&trans.target.nodes)| let count = #{e:(Aat&trans.target.arrows)| e.src = n}| count>=1 and count <=1
}for 10 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//mulitplicity on isActive:P->IsActivemin:1;max:1
all n:(NP&trans.target.nodes)| let count = #{e:(AisActive&trans.target.arrows)| e.src = n}| count>=1 and count <=1
}for 10 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//mulitplicity on TR:T->R[0,1]
all n:(NT&trans.target.nodes)| lone e:(ATR&trans.target.arrows)|e.src=n
}for 11 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//mulitplicity on PR:P->R[0,1]
all n:(NP&trans.target.nodes)| lone e:(APR&trans.target.arrows)|e.src=n
}for 11 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//mulitplicity on T min:1;max:1
let count = #NT&trans.target.nodes | count>=1 and count <=1
}for 11 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//mulitplicity on R min:1;max:1
let count = #NR&trans.target.nodes | count>=1 and count <=1
}for 11 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//check injective on TR:T->R
all n:(NT&trans.target.nodes)| no e1, e2:(ATR&trans.target.arrows)| (e1 != e2 and e1.src = n and e2.src = n and e1.trg = e2.trg)
}for 11 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//surjective on TR:T->R
all n:(NR&trans.target.nodes)| some e:(ATR&trans.target.arrows)| e.trg = n
}for 11 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//mulitplicity on TP:T->Pmin:1;max:1
all n:(NT&trans.target.nodes)| let count = #{e:(ATP&trans.target.arrows)| e.src = n}| count>=1 and count <=1
}for 11 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//mulitplicity on flag:P->Flagmin:1;max:1
all n:(NP&trans.target.nodes)| let count = #{e:(Aflag&trans.target.arrows)| e.src = n}| count>=1 and count <=1
}for 11 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//mulitplicity on at:P->Atmin:1;max:1
all n:(NP&trans.target.nodes)| let count = #{e:(Aat&trans.target.arrows)| e.src = n}| count>=1 and count <=1
}for 11 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//mulitplicity on isActive:P->IsActivemin:1;max:1
all n:(NP&trans.target.nodes)| let count = #{e:(AisActive&trans.target.arrows)| e.src = n}| count>=1 and count <=1
}for 11 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//mulitplicity on TR:T->R[0,1]
all n:(NT&trans.target.nodes)| lone e:(ATR&trans.target.arrows)|e.src=n
}for 12 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//mulitplicity on PR:P->R[0,1]
all n:(NP&trans.target.nodes)| lone e:(APR&trans.target.arrows)|e.src=n
}for 12 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//mulitplicity on T min:1;max:1
let count = #NT&trans.target.nodes | count>=1 and count <=1
}for 12 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//mulitplicity on R min:1;max:1
let count = #NR&trans.target.nodes | count>=1 and count <=1
}for 12 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//check injective on TR:T->R
all n:(NT&trans.target.nodes)| no e1, e2:(ATR&trans.target.arrows)| (e1 != e2 and e1.src = n and e2.src = n and e1.trg = e2.trg)
}for 12 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//surjective on TR:T->R
all n:(NR&trans.target.nodes)| some e:(ATR&trans.target.arrows)| e.trg = n
}for 12 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//mulitplicity on TP:T->Pmin:1;max:1
all n:(NT&trans.target.nodes)| let count = #{e:(ATP&trans.target.arrows)| e.src = n}| count>=1 and count <=1
}for 12 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//mulitplicity on flag:P->Flagmin:1;max:1
all n:(NP&trans.target.nodes)| let count = #{e:(Aflag&trans.target.arrows)| e.src = n}| count>=1 and count <=1
}for 12 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//mulitplicity on at:P->Atmin:1;max:1
all n:(NP&trans.target.nodes)| let count = #{e:(Aat&trans.target.arrows)| e.src = n}| count>=1 and count <=1
}for 12 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//mulitplicity on isActive:P->IsActivemin:1;max:1
all n:(NP&trans.target.nodes)| let count = #{e:(AisActive&trans.target.arrows)| e.src = n}| count>=1 and count <=1
}for 12 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//mulitplicity on TR:T->R[0,1]
all n:(NT&trans.target.nodes)| lone e:(ATR&trans.target.arrows)|e.src=n
}for 13 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//mulitplicity on PR:P->R[0,1]
all n:(NP&trans.target.nodes)| lone e:(APR&trans.target.arrows)|e.src=n
}for 13 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//mulitplicity on T min:1;max:1
let count = #NT&trans.target.nodes | count>=1 and count <=1
}for 13 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//mulitplicity on R min:1;max:1
let count = #NR&trans.target.nodes | count>=1 and count <=1
}for 13 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//check injective on TR:T->R
all n:(NT&trans.target.nodes)| no e1, e2:(ATR&trans.target.arrows)| (e1 != e2 and e1.src = n and e2.src = n and e1.trg = e2.trg)
}for 13 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//surjective on TR:T->R
all n:(NR&trans.target.nodes)| some e:(ATR&trans.target.arrows)| e.trg = n
}for 13 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//mulitplicity on TP:T->Pmin:1;max:1
all n:(NT&trans.target.nodes)| let count = #{e:(ATP&trans.target.arrows)| e.src = n}| count>=1 and count <=1
}for 13 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//mulitplicity on flag:P->Flagmin:1;max:1
all n:(NP&trans.target.nodes)| let count = #{e:(Aflag&trans.target.arrows)| e.src = n}| count>=1 and count <=1
}for 13 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//mulitplicity on at:P->Atmin:1;max:1
all n:(NP&trans.target.nodes)| let count = #{e:(Aat&trans.target.arrows)| e.src = n}| count>=1 and count <=1
}for 13 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//mulitplicity on isActive:P->IsActivemin:1;max:1
all n:(NP&trans.target.nodes)| let count = #{e:(AisActive&trans.target.arrows)| e.src = n}| count>=1 and count <=1
}for 13 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//mulitplicity on TR:T->R[0,1]
all n:(NT&trans.target.nodes)| lone e:(ATR&trans.target.arrows)|e.src=n
}for 14 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//mulitplicity on PR:P->R[0,1]
all n:(NP&trans.target.nodes)| lone e:(APR&trans.target.arrows)|e.src=n
}for 14 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//mulitplicity on T min:1;max:1
let count = #NT&trans.target.nodes | count>=1 and count <=1
}for 14 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//mulitplicity on R min:1;max:1
let count = #NR&trans.target.nodes | count>=1 and count <=1
}for 14 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//check injective on TR:T->R
all n:(NT&trans.target.nodes)| no e1, e2:(ATR&trans.target.arrows)| (e1 != e2 and e1.src = n and e2.src = n and e1.trg = e2.trg)
}for 14 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//surjective on TR:T->R
all n:(NR&trans.target.nodes)| some e:(ATR&trans.target.arrows)| e.trg = n
}for 14 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//mulitplicity on TP:T->Pmin:1;max:1
all n:(NT&trans.target.nodes)| let count = #{e:(ATP&trans.target.arrows)| e.src = n}| count>=1 and count <=1
}for 14 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//mulitplicity on flag:P->Flagmin:1;max:1
all n:(NP&trans.target.nodes)| let count = #{e:(Aflag&trans.target.arrows)| e.src = n}| count>=1 and count <=1
}for 14 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//mulitplicity on at:P->Atmin:1;max:1
all n:(NP&trans.target.nodes)| let count = #{e:(Aat&trans.target.arrows)| e.src = n}| count>=1 and count <=1
}for 14 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//mulitplicity on isActive:P->IsActivemin:1;max:1
all n:(NP&trans.target.nodes)| let count = #{e:(AisActive&trans.target.arrows)| e.src = n}| count>=1 and count <=1
}for 14 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//mulitplicity on TR:T->R[0,1]
all n:(NT&trans.target.nodes)| lone e:(ATR&trans.target.arrows)|e.src=n
}for 15 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//mulitplicity on PR:P->R[0,1]
all n:(NP&trans.target.nodes)| lone e:(APR&trans.target.arrows)|e.src=n
}for 15 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//mulitplicity on T min:1;max:1
let count = #NT&trans.target.nodes | count>=1 and count <=1
}for 15 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//mulitplicity on R min:1;max:1
let count = #NR&trans.target.nodes | count>=1 and count <=1
}for 15 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//check injective on TR:T->R
all n:(NT&trans.target.nodes)| no e1, e2:(ATR&trans.target.arrows)| (e1 != e2 and e1.src = n and e2.src = n and e1.trg = e2.trg)
}for 15 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//surjective on TR:T->R
all n:(NR&trans.target.nodes)| some e:(ATR&trans.target.arrows)| e.trg = n
}for 15 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//mulitplicity on TP:T->Pmin:1;max:1
all n:(NT&trans.target.nodes)| let count = #{e:(ATP&trans.target.arrows)| e.src = n}| count>=1 and count <=1
}for 15 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//mulitplicity on flag:P->Flagmin:1;max:1
all n:(NP&trans.target.nodes)| let count = #{e:(Aflag&trans.target.arrows)| e.src = n}| count>=1 and count <=1
}for 15 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//mulitplicity on at:P->Atmin:1;max:1
all n:(NP&trans.target.nodes)| let count = #{e:(Aat&trans.target.arrows)| e.src = n}| count>=1 and count <=1
}for 15 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//mulitplicity on isActive:P->IsActivemin:1;max:1
all n:(NP&trans.target.nodes)| let count = #{e:(AisActive&trans.target.arrows)| e.src = n}| count>=1 and count <=1
}for 15 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//mulitplicity on TR:T->R[0,1]
all n:(NT&trans.target.nodes)| lone e:(ATR&trans.target.arrows)|e.src=n
}for 16 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//mulitplicity on PR:P->R[0,1]
all n:(NP&trans.target.nodes)| lone e:(APR&trans.target.arrows)|e.src=n
}for 16 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//mulitplicity on T min:1;max:1
let count = #NT&trans.target.nodes | count>=1 and count <=1
}for 16 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//mulitplicity on R min:1;max:1
let count = #NR&trans.target.nodes | count>=1 and count <=1
}for 16 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//check injective on TR:T->R
all n:(NT&trans.target.nodes)| no e1, e2:(ATR&trans.target.arrows)| (e1 != e2 and e1.src = n and e2.src = n and e1.trg = e2.trg)
}for 16 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//surjective on TR:T->R
all n:(NR&trans.target.nodes)| some e:(ATR&trans.target.arrows)| e.trg = n
}for 16 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//mulitplicity on TP:T->Pmin:1;max:1
all n:(NT&trans.target.nodes)| let count = #{e:(ATP&trans.target.arrows)| e.src = n}| count>=1 and count <=1
}for 16 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//mulitplicity on flag:P->Flagmin:1;max:1
all n:(NP&trans.target.nodes)| let count = #{e:(Aflag&trans.target.arrows)| e.src = n}| count>=1 and count <=1
}for 16 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//mulitplicity on at:P->Atmin:1;max:1
all n:(NP&trans.target.nodes)| let count = #{e:(Aat&trans.target.arrows)| e.src = n}| count>=1 and count <=1
}for 16 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//mulitplicity on isActive:P->IsActivemin:1;max:1
all n:(NP&trans.target.nodes)| let count = #{e:(AisActive&trans.target.arrows)| e.src = n}| count>=1 and count <=1
}for 16 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//mulitplicity on TR:T->R[0,1]
all n:(NT&trans.target.nodes)| lone e:(ATR&trans.target.arrows)|e.src=n
}for 17 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//mulitplicity on PR:P->R[0,1]
all n:(NP&trans.target.nodes)| lone e:(APR&trans.target.arrows)|e.src=n
}for 17 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//mulitplicity on T min:1;max:1
let count = #NT&trans.target.nodes | count>=1 and count <=1
}for 17 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//mulitplicity on R min:1;max:1
let count = #NR&trans.target.nodes | count>=1 and count <=1
}for 17 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//check injective on TR:T->R
all n:(NT&trans.target.nodes)| no e1, e2:(ATR&trans.target.arrows)| (e1 != e2 and e1.src = n and e2.src = n and e1.trg = e2.trg)
}for 17 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//surjective on TR:T->R
all n:(NR&trans.target.nodes)| some e:(ATR&trans.target.arrows)| e.trg = n
}for 17 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//mulitplicity on TP:T->Pmin:1;max:1
all n:(NT&trans.target.nodes)| let count = #{e:(ATP&trans.target.arrows)| e.src = n}| count>=1 and count <=1
}for 17 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//mulitplicity on flag:P->Flagmin:1;max:1
all n:(NP&trans.target.nodes)| let count = #{e:(Aflag&trans.target.arrows)| e.src = n}| count>=1 and count <=1
}for 17 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//mulitplicity on at:P->Atmin:1;max:1
all n:(NP&trans.target.nodes)| let count = #{e:(Aat&trans.target.arrows)| e.src = n}| count>=1 and count <=1
}for 17 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//mulitplicity on isActive:P->IsActivemin:1;max:1
all n:(NP&trans.target.nodes)| let count = #{e:(AisActive&trans.target.arrows)| e.src = n}| count>=1 and count <=1
}for 17 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//mulitplicity on TR:T->R[0,1]
all n:(NT&trans.target.nodes)| lone e:(ATR&trans.target.arrows)|e.src=n
}for 18 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//mulitplicity on PR:P->R[0,1]
all n:(NP&trans.target.nodes)| lone e:(APR&trans.target.arrows)|e.src=n
}for 18 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//mulitplicity on T min:1;max:1
let count = #NT&trans.target.nodes | count>=1 and count <=1
}for 18 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//mulitplicity on R min:1;max:1
let count = #NR&trans.target.nodes | count>=1 and count <=1
}for 18 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//check injective on TR:T->R
all n:(NT&trans.target.nodes)| no e1, e2:(ATR&trans.target.arrows)| (e1 != e2 and e1.src = n and e2.src = n and e1.trg = e2.trg)
}for 18 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//surjective on TR:T->R
all n:(NR&trans.target.nodes)| some e:(ATR&trans.target.arrows)| e.trg = n
}for 18 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//mulitplicity on TP:T->Pmin:1;max:1
all n:(NT&trans.target.nodes)| let count = #{e:(ATP&trans.target.arrows)| e.src = n}| count>=1 and count <=1
}for 18 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//mulitplicity on flag:P->Flagmin:1;max:1
all n:(NP&trans.target.nodes)| let count = #{e:(Aflag&trans.target.arrows)| e.src = n}| count>=1 and count <=1
}for 18 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//mulitplicity on at:P->Atmin:1;max:1
all n:(NP&trans.target.nodes)| let count = #{e:(Aat&trans.target.arrows)| e.src = n}| count>=1 and count <=1
}for 18 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//mulitplicity on isActive:P->IsActivemin:1;max:1
all n:(NP&trans.target.nodes)| let count = #{e:(AisActive&trans.target.arrows)| e.src = n}| count>=1 and count <=1
}for 18 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//mulitplicity on TR:T->R[0,1]
all n:(NT&trans.target.nodes)| lone e:(ATR&trans.target.arrows)|e.src=n
}for 19 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//mulitplicity on PR:P->R[0,1]
all n:(NP&trans.target.nodes)| lone e:(APR&trans.target.arrows)|e.src=n
}for 19 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//mulitplicity on T min:1;max:1
let count = #NT&trans.target.nodes | count>=1 and count <=1
}for 19 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//mulitplicity on R min:1;max:1
let count = #NR&trans.target.nodes | count>=1 and count <=1
}for 19 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//check injective on TR:T->R
all n:(NT&trans.target.nodes)| no e1, e2:(ATR&trans.target.arrows)| (e1 != e2 and e1.src = n and e2.src = n and e1.trg = e2.trg)
}for 19 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//surjective on TR:T->R
all n:(NR&trans.target.nodes)| some e:(ATR&trans.target.arrows)| e.trg = n
}for 19 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//mulitplicity on TP:T->Pmin:1;max:1
all n:(NT&trans.target.nodes)| let count = #{e:(ATP&trans.target.arrows)| e.src = n}| count>=1 and count <=1
}for 19 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//mulitplicity on flag:P->Flagmin:1;max:1
all n:(NP&trans.target.nodes)| let count = #{e:(Aflag&trans.target.arrows)| e.src = n}| count>=1 and count <=1
}for 19 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//mulitplicity on at:P->Atmin:1;max:1
all n:(NP&trans.target.nodes)| let count = #{e:(Aat&trans.target.arrows)| e.src = n}| count>=1 and count <=1
}for 19 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//mulitplicity on isActive:P->IsActivemin:1;max:1
all n:(NP&trans.target.nodes)| let count = #{e:(AisActive&trans.target.arrows)| e.src = n}| count>=1 and count <=1
}for 19 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
