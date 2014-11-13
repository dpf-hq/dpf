//surjective on flag:P->Flag
all n:(NFlag&trans.target.nodes)| some e:(Aflag&trans.target.arrows)| e.trg = n
//surjective on at:P->State
all n:(NState&trans.target.nodes)| some e:(Aat&trans.target.arrows)| e.trg = n
//surjective on isActive:P->Active
all n:(NActive&trans.target.nodes)| some e:(AisActive&trans.target.arrows)| e.trg = n
