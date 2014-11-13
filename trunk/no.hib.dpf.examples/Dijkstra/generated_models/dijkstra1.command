//mulitplicity on PF1:P->F1[0,1]
all n:(NP&trans.target.nodes)| lone e:(APF1&trans.target.arrows)|e.src=n
//NAND constraint between F1R:F1->R and F2R:F2->R
all n:(NR&trans.target.nodes) | let e1 = (some e : AF1R&trans.target.arrows | e.trg = n), e2=(some e : AF2R&trans.target.arrows | e.trg = n)|not(e1 and e2)
//NAND constraint between PF2:P->F2 and PF1:P->F1
all n:(NP&trans.target.nodes) | let e1 = (some e : APF2&trans.target.arrows | e.src = n), e2=(some e : APF1&trans.target.arrows | e.src = n)|not(e1 and e2)
