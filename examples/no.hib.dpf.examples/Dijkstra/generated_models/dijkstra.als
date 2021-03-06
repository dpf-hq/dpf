//signatures for nodes
sig NP{}
sig NF2{}
sig NF1{}
sig NT{}
sig NR{}

//signatures for edges
sig AnonActive{src:one NP, trg:one NP}
sig Aactive{src:one NP, trg:one NP}
sig AsetTurn{src:one NP, trg:one NP}
sig Astart{src:one NP, trg:one NP}
sig Acrit{src:one NP, trg:one NP}
sig Acheck{src:one NP, trg:one NP}
sig APF2{src:one NP, trg:one NF2}
sig APF1{src:one NP, trg:one NF1}
sig ATP{src:one NT, trg:one NP}
sig ATR{src:one NT, trg:one NR}
sig AF2R{src:one NF2, trg:one NR}
sig AF1R{src:one NF1, trg:one NR}

sig Graph{nodes:set NP+NF2+NF1+NT+NR, arrows:set AnonActive+Aactive+AsetTurn+Astart+Acrit+Acheck+APF2+APF1+ATP+ATR+AF2R+AF1R}

//In a graph, the source and target node of each contained edge should be also contained by the graph
pred to_be_graph[graph:Graph]{
	all arrow : AnonActive&graph.arrows|(arrow.src in graph.nodes and arrow.trg in graph.nodes)
	all arrow : Aactive&graph.arrows|(arrow.src in graph.nodes and arrow.trg in graph.nodes)
	all arrow : AsetTurn&graph.arrows|(arrow.src in graph.nodes and arrow.trg in graph.nodes)
	all arrow : Astart&graph.arrows|(arrow.src in graph.nodes and arrow.trg in graph.nodes)
	all arrow : Acrit&graph.arrows|(arrow.src in graph.nodes and arrow.trg in graph.nodes)
	all arrow : Acheck&graph.arrows|(arrow.src in graph.nodes and arrow.trg in graph.nodes)
	all arrow : APF2&graph.arrows|(arrow.src in graph.nodes and arrow.trg in graph.nodes)
	all arrow : APF1&graph.arrows|(arrow.src in graph.nodes and arrow.trg in graph.nodes)
	all arrow : ATP&graph.arrows|(arrow.src in graph.nodes and arrow.trg in graph.nodes)
	all arrow : ATR&graph.arrows|(arrow.src in graph.nodes and arrow.trg in graph.nodes)
	all arrow : AF2R&graph.arrows|(arrow.src in graph.nodes and arrow.trg in graph.nodes)
	all arrow : AF1R&graph.arrows|(arrow.src in graph.nodes and arrow.trg in graph.nodes)
}

one abstract sig Rule{}
lone sig setFlag, setTurn1, setTurn2, enter, exit extends Rule{}

sig Trans{rule:one Rule, source,target:one Graph, dnodes, anodes:set NP+NF2+NF1+NT+NR, darrows, aarrows:set AnonActive+Aactive+AsetTurn+Astart+Acrit+Acheck+APF2+APF1+ATP+ATR+AF2R+AF1R}

//No dangle edges after a transformation
pred no_dangle_arrow[trans:Trans]{
	all arrow : AnonActive|(arrow.src in trans.dnodes or arrow.trg in trans.dnodes) implies arrow in trans.darrows
	all arrow : AnonActive|(arrow.src in trans.anodes or arrow.trg in trans.anodes) implies arrow in trans.aarrows
	all arrow : Aactive|(arrow.src in trans.dnodes or arrow.trg in trans.dnodes) implies arrow in trans.darrows
	all arrow : Aactive|(arrow.src in trans.anodes or arrow.trg in trans.anodes) implies arrow in trans.aarrows
	all arrow : AsetTurn|(arrow.src in trans.dnodes or arrow.trg in trans.dnodes) implies arrow in trans.darrows
	all arrow : AsetTurn|(arrow.src in trans.anodes or arrow.trg in trans.anodes) implies arrow in trans.aarrows
	all arrow : Astart|(arrow.src in trans.dnodes or arrow.trg in trans.dnodes) implies arrow in trans.darrows
	all arrow : Astart|(arrow.src in trans.anodes or arrow.trg in trans.anodes) implies arrow in trans.aarrows
	all arrow : Acrit|(arrow.src in trans.dnodes or arrow.trg in trans.dnodes) implies arrow in trans.darrows
	all arrow : Acrit|(arrow.src in trans.anodes or arrow.trg in trans.anodes) implies arrow in trans.aarrows
	all arrow : Acheck|(arrow.src in trans.dnodes or arrow.trg in trans.dnodes) implies arrow in trans.darrows
	all arrow : Acheck|(arrow.src in trans.anodes or arrow.trg in trans.anodes) implies arrow in trans.aarrows
	all arrow : APF2|(arrow.src in trans.dnodes or arrow.trg in trans.dnodes) implies arrow in trans.darrows
	all arrow : APF2|(arrow.src in trans.anodes or arrow.trg in trans.anodes) implies arrow in trans.aarrows
	all arrow : APF1|(arrow.src in trans.dnodes or arrow.trg in trans.dnodes) implies arrow in trans.darrows
	all arrow : APF1|(arrow.src in trans.anodes or arrow.trg in trans.anodes) implies arrow in trans.aarrows
	all arrow : ATP|(arrow.src in trans.dnodes or arrow.trg in trans.dnodes) implies arrow in trans.darrows
	all arrow : ATP|(arrow.src in trans.anodes or arrow.trg in trans.anodes) implies arrow in trans.aarrows
	all arrow : ATR|(arrow.src in trans.dnodes or arrow.trg in trans.dnodes) implies arrow in trans.darrows
	all arrow : ATR|(arrow.src in trans.anodes or arrow.trg in trans.anodes) implies arrow in trans.aarrows
	all arrow : AF2R|(arrow.src in trans.dnodes or arrow.trg in trans.dnodes) implies arrow in trans.darrows
	all arrow : AF2R|(arrow.src in trans.anodes or arrow.trg in trans.anodes) implies arrow in trans.aarrows
	all arrow : AF1R|(arrow.src in trans.dnodes or arrow.trg in trans.dnodes) implies arrow in trans.darrows
	all arrow : AF1R|(arrow.src in trans.anodes or arrow.trg in trans.anodes) implies arrow in trans.aarrows
}

//general constraints for transformations
fact{
	(Trans.source+Trans.target)=Graph
	Rule=Trans.rule
	all graph:Graph|to_be_graph[graph]
	Graph.nodes=NP+NF2+NF1+NT+NR
	Graph.arrows=AnonActive+Aactive+AsetTurn+Astart+Acrit+Acheck+APF2+APF1+ATP+ATR+AF2R+AF1R
	all trans:Trans | no_dangle_arrow[trans] and trans_general[trans] and source_valid[trans] and (
	rule_setFlag[trans] or rule_setTurn1[trans] or rule_setTurn2[trans] or rule_enter[trans] or rule_exit[trans])
}

//the predicate that the transformation is an application of the rule setFlag
pred rule_setFlag[trans:Trans]{
	some trans.rule&setFlag

some nonActive0:AnonActive&trans.darrows|let P0=nonActive0.src|
	(P0 in (trans.source.nodes-trans.dnodes) and P0=nonActive0.trg and (some start0:Astart&trans.darrows|start0.src=P0 and start0.trg =P0))some nonActive0:AnonActive&trans.darrows|let P0=nonActive0.src|
	(P0 in (trans.source.nodes-trans.dnodes) and P0=nonActive0.trg and (some start0:Astart&trans.darrows|start0.src=P0 and start0.trg =P0))
some PF10:APF1&trans.aarrows|let P0=PF10.src,F10=PF10.trg|
	(P0 in (trans.source.nodes-trans.dnodes) and F10 in trans.anodes and (some active0:Aactive&trans.aarrows|active0.src=P0 and active0.trg =P0) and (some setTurn0:AsetTurn&trans.aarrows|setTurn0.src=P0 and setTurn0.trg =P0) and (some F1R0:AF1R&trans.aarrows|let R0=F1R0.trg|
	(F1R0.src=F10 and R0 in (trans.source.nodes-trans.dnodes))))
	some P0:NP&(trans.source.nodes-trans.dnodes)|(some nonActive0:AnonActive&trans.darrows|nonActive0.src=P0) and (some start0:Astart&trans.darrows|start0.src=P0) and (some active0:Aactive&trans.aarrows|active0.src=P0) and (some setTurn0:AsetTurn&trans.aarrows|setTurn0.src=P0) and (some PF10:APF1&trans.aarrows|PF10.src=P0)

	#NF1&trans.anodes = 1
	#Astart&trans.darrows = 1
	#AnonActive&trans.darrows = 1
	#AF1R&trans.aarrows = 1
	#APF1&trans.aarrows = 1
	#AsetTurn&trans.aarrows = 1
	#Aactive&trans.aarrows = 1
	no trans.dnodes
	no (NP+NF2+NT+NR)&trans.anodes
	no (Aactive+AsetTurn+Acrit+Acheck+APF2+APF1+ATP+ATR+AF2R+AF1R)&trans.darrows
	no (AnonActive+Astart+Acrit+Acheck+APF2+ATP+ATR+AF2R)&trans.aarrows
}

//the predicate that the transformation is an application of the rule setTurn1
pred rule_setTurn1[trans:Trans]{
	some trans.rule&setTurn1

some TR0:ATR&(trans.source.arrows-trans.darrows)|let T0=TR0.src,R0=TR0.trg|
	(T0 in (trans.source.nodes-trans.dnodes) and R0 in (trans.source.nodes-trans.dnodes) and (some TP0:ATP&trans.darrows|let P0=TP0.trg|
	(TP0.src=T0 and P0 in (trans.source.nodes-trans.dnodes) and (some nonActive0:AnonActive&(trans.source.arrows-trans.darrows)|nonActive0.src=P0 and nonActive0.trg =P0))))some TR0:ATR&(trans.source.arrows-trans.darrows)|let T0=TR0.src,R0=TR0.trg|
	(T0 in (trans.source.nodes-trans.dnodes) and R0 in (trans.source.nodes-trans.dnodes) and (some TP0:ATP&trans.darrows|let P0=TP0.trg|
	(TP0.src=T0 and P0 in (trans.source.nodes-trans.dnodes) and (some nonActive0:AnonActive&(trans.source.arrows-trans.darrows)|nonActive0.src=P0 and nonActive0.trg =P0))))
some TR0:ATR&(trans.source.arrows-trans.darrows)|let T0=TR0.src,R0=TR0.trg|
	(T0 in (trans.source.nodes-trans.dnodes) and R0 in (trans.source.nodes-trans.dnodes) and (some TP1:ATP&trans.aarrows|let P1=TP1.trg|
	(TP1.src=T0 and P1 in (trans.source.nodes-trans.dnodes) and (some check0:Acheck&trans.aarrows|check0.src=P1 and check0.trg =P1))))some TR0:ATR&(trans.source.arrows-trans.darrows)|let T0=TR0.src,R0=TR0.trg|
	(T0 in (trans.source.nodes-trans.dnodes) and R0 in (trans.source.nodes-trans.dnodes) and (some TP1:ATP&trans.aarrows|let P1=TP1.trg|
	(TP1.src=T0 and P1 in (trans.source.nodes-trans.dnodes) and (some check0:Acheck&trans.aarrows|check0.src=P1 and check0.trg =P1))))
	some P1:NP&(trans.source.nodes-trans.dnodes)|(some setTurn0:AsetTurn&trans.darrows|setTurn0.src=P1) and (some TP1:ATP&trans.aarrows|TP1.trg=P1) and (some check0:Acheck&trans.aarrows|check0.src=P1)
	some T0:NT&(trans.source.nodes-trans.dnodes)|(some TP0:ATP&trans.darrows|TP0.src=T0) and (some TP1:ATP&trans.aarrows|TP1.src=T0)

	#ATP&trans.darrows = 1
	#AsetTurn&trans.darrows = 1
	#ATP&trans.aarrows = 1
	#Acheck&trans.aarrows = 1
	no trans.dnodes
	no trans.anodes
	no (AnonActive+Aactive+Astart+Acrit+Acheck+APF2+APF1+ATR+AF2R+AF1R)&trans.darrows
	no (AnonActive+Aactive+AsetTurn+Astart+Acrit+APF2+APF1+ATR+AF2R+AF1R)&trans.aarrows
}

//the predicate that the transformation is an application of the rule setTurn2
pred rule_setTurn2[trans:Trans]{
	some trans.rule&setTurn2

some TP0:ATP&(trans.source.arrows-trans.darrows)|let T0=TP0.src,P0=TP0.trg|
	(T0 in (trans.source.nodes-trans.dnodes) and P0 in (trans.source.nodes-trans.dnodes) and (some TR0:ATR&(trans.source.arrows-trans.darrows)|let R0=TR0.trg|
	(TR0.src=T0 and R0 in (trans.source.nodes-trans.dnodes))) and (some setTurn0:AsetTurn&trans.darrows|setTurn0.src=P0 and setTurn0.trg =P0))
some TP0:ATP&(trans.source.arrows-trans.darrows)|let T0=TP0.src,P0=TP0.trg|
	(T0 in (trans.source.nodes-trans.dnodes) and P0 in (trans.source.nodes-trans.dnodes) and (some TR0:ATR&(trans.source.arrows-trans.darrows)|let R0=TR0.trg|
	(TR0.src=T0 and R0 in (trans.source.nodes-trans.dnodes))) and (some check0:Acheck&trans.aarrows|check0.src=P0 and check0.trg =P0))
	some P0:NP&(trans.source.nodes-trans.dnodes)|(some setTurn0:AsetTurn&trans.darrows|setTurn0.src=P0) and (some check0:Acheck&trans.aarrows|check0.src=P0)

	#AsetTurn&trans.darrows = 1
	#Acheck&trans.aarrows = 1
	no trans.dnodes
	no trans.anodes
	no (AnonActive+Aactive+Astart+Acrit+Acheck+APF2+APF1+ATP+ATR+AF2R+AF1R)&trans.darrows
	no (AnonActive+Aactive+AsetTurn+Astart+Acrit+APF2+APF1+ATP+ATR+AF2R+AF1R)&trans.aarrows
}

//the predicate that the transformation is an application of the rule enter
pred rule_enter[trans:Trans]{
	some trans.rule&enter

some check0:Acheck&trans.darrows|let P0=check0.src|
	(P0 in (trans.source.nodes-trans.dnodes) and P0=check0.trg and (some TP0:ATP&(trans.source.arrows-trans.darrows)|let T0=TP0.src|
	(T0 in (trans.source.nodes-trans.dnodes) and TP0.trg=P0 and (some TR0:ATR&(trans.source.arrows-trans.darrows)|let R0=TR0.trg|
	(TR0.src=T0 and R0 in (trans.source.nodes-trans.dnodes) and (some F1R0:AF1R&trans.darrows|let F10=F1R0.src|
	(F10 in trans.dnodes and F1R0.trg=R0 and (some PF10:APF1&trans.darrows|PF10.src=P0 and PF10.trg =F10))))))))
some crit0:Acrit&trans.aarrows|let P0=crit0.src|
	(P0 in (trans.source.nodes-trans.dnodes) and P0=crit0.trg and (some TP0:ATP&(trans.source.arrows-trans.darrows)|let T0=TP0.src|
	(T0 in (trans.source.nodes-trans.dnodes) and TP0.trg=P0 and (some TR0:ATR&(trans.source.arrows-trans.darrows)|let R0=TR0.trg|
	(TR0.src=T0 and R0 in (trans.source.nodes-trans.dnodes) and (some F2R0:AF2R&trans.aarrows|let F20=F2R0.src|
	(F20 in trans.anodes and F2R0.trg=R0 and (some PF20:APF2&trans.aarrows|PF20.src=P0 and PF20.trg =F20))))))))
	some P0:NP&(trans.source.nodes-trans.dnodes)|(some check0:Acheck&trans.darrows|check0.src=P0) and (some PF10:APF1&trans.darrows|PF10.src=P0) and (some crit0:Acrit&trans.aarrows|crit0.src=P0) and (some PF20:APF2&trans.aarrows|PF20.src=P0)
	some R0:NR&(trans.source.nodes-trans.dnodes)|(some F1R0:AF1R&trans.darrows|F1R0.trg=R0) and (some F2R0:AF2R&trans.aarrows|F2R0.trg=R0)

	#NF1&trans.dnodes = 1
	#NF2&trans.anodes = 1
	#AF1R&trans.darrows = 1
	#APF1&trans.darrows = 1
	#Acheck&trans.darrows = 1
	#AF2R&trans.aarrows = 1
	#Acrit&trans.aarrows = 1
	#APF2&trans.aarrows = 1
	no (NP+NF2+NT+NR)&trans.dnodes
	no (NP+NF1+NT+NR)&trans.anodes
	no (AnonActive+Aactive+AsetTurn+Astart+Acrit+APF2+ATP+ATR+AF2R)&trans.darrows
	no (AnonActive+Aactive+AsetTurn+Astart+Acheck+APF1+ATP+ATR+AF1R)&trans.aarrows
}

//the predicate that the transformation is an application of the rule exit
pred rule_exit[trans:Trans]{
	some trans.rule&exit

some PF20:APF2&trans.darrows|let P0=PF20.src,F20=PF20.trg|
	(P0 in (trans.source.nodes-trans.dnodes) and F20 in trans.dnodes and (some active0:Aactive&trans.darrows|active0.src=P0 and active0.trg =P0) and (some crit0:Acrit&trans.darrows|crit0.src=P0 and crit0.trg =P0) and (some F2R0:AF2R&trans.darrows|let R0=F2R0.trg|
	(F2R0.src=F20 and R0 in (trans.source.nodes-trans.dnodes))))
some nonActive0:AnonActive&trans.aarrows|let P0=nonActive0.src|
	(P0 in (trans.source.nodes-trans.dnodes) and P0=nonActive0.trg and (some start0:Astart&trans.aarrows|start0.src=P0 and start0.trg =P0))some nonActive0:AnonActive&trans.aarrows|let P0=nonActive0.src|
	(P0 in (trans.source.nodes-trans.dnodes) and P0=nonActive0.trg and (some start0:Astart&trans.aarrows|start0.src=P0 and start0.trg =P0))
	some P0:NP&(trans.source.nodes-trans.dnodes)|(some active0:Aactive&trans.darrows|active0.src=P0) and (some crit0:Acrit&trans.darrows|crit0.src=P0) and (some PF20:APF2&trans.darrows|PF20.src=P0) and (some nonActive0:AnonActive&trans.aarrows|nonActive0.src=P0) and (some start0:Astart&trans.aarrows|start0.src=P0)

	#NF2&trans.dnodes = 1
	#AF2R&trans.darrows = 1
	#Acrit&trans.darrows = 1
	#Aactive&trans.darrows = 1
	#APF2&trans.darrows = 1
	#Astart&trans.aarrows = 1
	#AnonActive&trans.aarrows = 1
	no (NP+NF1+NT+NR)&trans.dnodes
	no trans.anodes
	no (AnonActive+AsetTurn+Astart+Acheck+APF1+ATP+ATR+AF1R)&trans.darrows
	no (Aactive+AsetTurn+Acrit+Acheck+APF2+APF1+ATP+ATR+AF2R+AF1R)&trans.aarrows
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
//mulitplicity on nonActive:P->P[0,1]
all n:(NP&trans.source.nodes)| lone e:(AnonActive&trans.source.arrows)|e.src=n
//mulitplicity on active:P->P[0,1]
all n:(NP&trans.source.nodes)| lone e:(Aactive&trans.source.arrows)|e.src=n
//mulitplicity on setTurn:P->P[0,1]
all n:(NP&trans.source.nodes)| lone e:(AsetTurn&trans.source.arrows)|e.src=n
//mulitplicity on start:P->P[0,1]
all n:(NP&trans.source.nodes)| lone e:(Astart&trans.source.arrows)|e.src=n
//mulitplicity on crit:P->P[0,1]
all n:(NP&trans.source.nodes)| lone e:(Acrit&trans.source.arrows)|e.src=n
//mulitplicity on check:P->P[0,1]
all n:(NP&trans.source.nodes)| lone e:(Acheck&trans.source.arrows)|e.src=n
//mulitplicity on PF2:P->F2[0,1]
all n:(NP&trans.source.nodes)| lone e:(APF2&trans.source.arrows)|e.src=n
//mulitplicity on PF1:P->F1[0,1]
all n:(NP&trans.source.nodes)| lone e:(APF1&trans.source.arrows)|e.src=n
//mulitplicity on TR:T->R[0,1]
all n:(NT&trans.source.nodes)| lone e:(ATR&trans.source.arrows)|e.src=n
//XOR constraint between active:P->P and nonActive:P->P
all n:(NP&trans.source.nodes) | let e1 = (some e : Aactive&trans.source.arrows | e.src = n), e2=(some e : AnonActive&trans.source.arrows | e.src = n)|(e1 or e2) and not(e1 and e2)
//XOR constraint between setTurn:P->P,start:P->P,crit:P->P and check:P->P
all n:(NP&trans.source.nodes) | let e1=(some e : AsetTurn&trans.source.arrows|e.src = n), e2=(some e : Astart&trans.source.arrows|e.src = n), e3=(some e : Acrit&trans.source.arrows|e.src = n), e4=(some e : Acheck&trans.source.arrows|e.src = n)|(e1 or e2 or e3 or e4) and not(((e1 and (e2 or e3 or e4)) or (e2 and (e1 or e3 or e4)) or (e3 and (e2 or e1 or e4)) or (e4 and (e2 or e3 or e1))))
//NAND constraint between F1R:F1->R and F2R:F2->R
all n:(NR&trans.source.nodes) | let e1 = (some e : AF1R&trans.source.arrows | e.trg = n), e2=(some e : AF2R&trans.source.arrows | e.trg = n)|not(e1 and e2)
//NAND constraint between PF2:P->F2 and PF1:P->F1
all n:(NP&trans.source.nodes) | let e1 = (some e : APF2&trans.source.arrows | e.src = n), e2=(some e : APF1&trans.source.arrows | e.src = n)|not(e1 and e2)
//reflexive on nonActive:P->P
all e:(AnonActive&trans.source.arrows)| e.src = e.trg
//reflexive on active:P->P
all e:(Aactive&trans.source.arrows)| e.src = e.trg
//reflexive on setTurn:P->P
all e:(AsetTurn&trans.source.arrows)| e.src = e.trg
//reflexive on start:P->P
all e:(Astart&trans.source.arrows)| e.src = e.trg
//reflexive on crit:P->P
all e:(Acrit&trans.source.arrows)| e.src = e.trg
//reflexive on check:P->P
all e:(Acheck&trans.source.arrows)| e.src = e.trg
//mulitplicity on TP:T->Pmin:1;max:1
all n:(NT&trans.source.nodes)| let count = #{e:(ATP&trans.source.arrows)| e.src = n}| count>=1 and count <=1
//check injective on TR:T->R
all n:(NT&trans.source.nodes)| no e1, e2:(ATR&trans.source.arrows)| (e1 != e2 and e1.src = n and e2.src = n and e1.trg = e2.trg)
//surjective on TR:T->R
all n:(NR&trans.source.nodes)| some e:(ATR&trans.source.arrows)| e.trg = n
//mulitplicity on T min:1;max:1
let count = #NT&trans.source.nodes | count>=1 and count <=1
//mulitplicity on R min:1;max:1
let count = #NR&trans.source.nodes | count>=1 and count <=1
//mulitplicity on F2R:F2->Rmin:1;max:1
all n:(NF2&trans.source.nodes)| let count = #{e:(AF2R&trans.source.arrows)| e.src = n}| count>=1 and count <=1
//surjective on PF2:P->F2
all n:(NF2&trans.source.nodes)| some e:(APF2&trans.source.arrows)| e.trg = n
//surjective on PF1:P->F1
all n:(NF1&trans.source.nodes)| some e:(APF1&trans.source.arrows)| e.trg = n
//mulitplicity on F1R:F1->Rmin:1;max:1
all n:(NF1&trans.source.nodes)| let count = #{e:(AF1R&trans.source.arrows)| e.src = n}| count>=1 and count <=1
}
