sig NX{}

sig Af{src:one NX, trg:one NX}

one abstract sig Rule{}
lone sig fix1, fix2 extends Rule{}

sig Graph{nodes:set NX, arrows:set Af}

pred to_be_graph[graph:Graph]{
	all arrow : Af&graph.arrows|(arrow.src in graph.nodes and arrow.trg in graph.nodes)
}

sig Trans{rule:one Rule, source:one Graph, target:one Graph, dnodes:set NX, darrows:set Af, anodes:set NX, aarrows:set Af}

pred no_dangle_arrow[trans:Trans]{
all arrow : Af|(arrow.src in trans.dnodes or arrow.trg in trans.dnodes) implies arrow in trans.darrows
all arrow : Af|(arrow.src in trans.anodes or arrow.trg in trans.anodes) implies arrow in trans.aarrows
}

fact{
(Trans.source+Trans.target)=Graph
Rule=Trans.rule
all graph:Graph|to_be_graph[graph]
Graph.nodes=NX
Graph.arrows=Af
all trans:Trans | no_dangle_arrow[trans] and trans_general[trans] and source_valid[trans] and (
rule_fix1[trans] or rule_fix2[trans])
}

pred rule_fix1[trans:Trans]{
some trans.rule&fix1

one e_f0:Af&trans.darrows |
let n_X0 = e_f0.src |
(n_X0 = e_f0.trg  and
n_X0 in NX&(trans.source.nodes-trans.dnodes))
some NX&(trans.source.nodes-trans.dnodes)

one e_f1:Af&trans.aarrows |
let n_X0 = e_f1.src, n_X1 = e_f1.trg |
(n_X0 in NX&(trans.source.nodes-trans.dnodes) and n_X1 in NX&(trans.source.nodes-trans.dnodes))

some X0:NX&(trans.source.nodes-trans.dnodes)|(some f0:Af&trans.darrows|f0.src=X0) and (some f1:Af&trans.aarrows|f1.src=X0)
#Af&trans.darrows = 1
#Af&trans.aarrows = 1
no NX&trans.dnodes
no NX&trans.anodes
}

pred rule_fix2[trans:Trans]{
some trans.rule&fix2

one e_f0:Af&trans.darrows |
let n_X0 = e_f0.src |
(n_X0 = e_f0.trg  and
n_X0 in NX&(trans.source.nodes-trans.dnodes))

some NX&(trans.source.nodes-trans.dnodes)

#Af&trans.darrows = 1
no NX&trans.dnodes
no NX&trans.anodes
no Af&trans.aarrows
}

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
//mulitplicity on f:X->X[0,1]
all n:(NX&trans.source.nodes)| lone e:(Af&trans.source.arrows)|e.src=n
}
check{all trans: Trans|//mulitplicity on f:X->X[0,1]
all n:(NX&trans.target.nodes)| lone e:(Af&trans.target.arrows)|e.src=n
}for 3 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//mulitplicity on f:X->X[0,1]
all n:(NX&trans.target.nodes)| lone e:(Af&trans.target.arrows)|e.src=n
}for 4 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//mulitplicity on f:X->X[0,1]
all n:(NX&trans.target.nodes)| lone e:(Af&trans.target.arrows)|e.src=n
}for 5 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//mulitplicity on f:X->X[0,1]
all n:(NX&trans.target.nodes)| lone e:(Af&trans.target.arrows)|e.src=n
}for 6 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//mulitplicity on f:X->X[0,1]
all n:(NX&trans.target.nodes)| lone e:(Af&trans.target.arrows)|e.src=n
}for 7 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//mulitplicity on f:X->X[0,1]
all n:(NX&trans.target.nodes)| lone e:(Af&trans.target.arrows)|e.src=n
}for 8 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//mulitplicity on f:X->X[0,1]
all n:(NX&trans.target.nodes)| lone e:(Af&trans.target.arrows)|e.src=n
}for 9 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//mulitplicity on f:X->X[0,1]
all n:(NX&trans.target.nodes)| lone e:(Af&trans.target.arrows)|e.src=n
}for 10 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//mulitplicity on f:X->X[0,1]
all n:(NX&trans.target.nodes)| lone e:(Af&trans.target.arrows)|e.src=n
}for 11 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//mulitplicity on f:X->X[0,1]
all n:(NX&trans.target.nodes)| lone e:(Af&trans.target.arrows)|e.src=n
}for 12 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//mulitplicity on f:X->X[0,1]
all n:(NX&trans.target.nodes)| lone e:(Af&trans.target.arrows)|e.src=n
}for 13 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//mulitplicity on f:X->X[0,1]
all n:(NX&trans.target.nodes)| lone e:(Af&trans.target.arrows)|e.src=n
}for 14 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//mulitplicity on f:X->X[0,1]
all n:(NX&trans.target.nodes)| lone e:(Af&trans.target.arrows)|e.src=n
}for 15 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//mulitplicity on f:X->X[0,1]
all n:(NX&trans.target.nodes)| lone e:(Af&trans.target.arrows)|e.src=n
}for 16 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//mulitplicity on f:X->X[0,1]
all n:(NX&trans.target.nodes)| lone e:(Af&trans.target.arrows)|e.src=n
}for 17 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//mulitplicity on f:X->X[0,1]
all n:(NX&trans.target.nodes)| lone e:(Af&trans.target.arrows)|e.src=n
}for 18 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
check{all trans: Trans|//mulitplicity on f:X->X[0,1]
all n:(NX&trans.target.nodes)| lone e:(Af&trans.target.arrows)|e.src=n
}for 19 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule
