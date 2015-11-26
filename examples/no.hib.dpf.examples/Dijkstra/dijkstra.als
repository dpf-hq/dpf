//Signatures for nodes
sig NF2{}
sig NT{}
sig NR{}
sig NP{}
sig NF1{}

//Signatures for edges
sig Ecrit{src:one NP, trg:one NP}
sig EsetTurn{src:one NP, trg:one NP}
sig EPF1{src:one NP, trg:one NF1}
sig EF1R{src:one NF1, trg:one NR}
sig Eactive{src:one NP, trg:one NP}
sig EF2R{src:one NF2, trg:one NR}
sig Echeck{src:one NP, trg:one NP}
sig EPF2{src:one NP, trg:one NF2}
sig EnonActive{src:one NP, trg:one NP}
sig ETP{src:one NT, trg:one NP}
sig ETR{src:one NT, trg:one NR}
sig Estart{src:one NP, trg:one NP}

//preds
pred nand1_EF1R_EF2R[]{
	//NAND constraint between F2R:F2->R and F1R:F1->R
	all n:(NR) | let e1 = (some e : EF2R | e.trg = n), e2=(some e : EF1R | e.trg = n)|not(e1 and e2)
}

pred mult1_EsetTurn[]{
	//mulitplicity on setTurn:P->P[0,1]
	all n:(NP)| lone e:(EsetTurn)|e.src=n
}

pred mult1_Estart[]{
	//mulitplicity on start:P->P[0,1]
	all n:(NP)| lone e:(Estart)|e.src=n
}

pred mult1_EPF1[]{
	//mulitplicity on PF1:P->F1[0,1]
	all n:(NP)| lone e:(EPF1)|e.src=n
}

pred mult1_EPF2[]{
	//mulitplicity on PF2:P->F2[0,1]
	all n:(NP)| lone e:(EPF2)|e.src=n
}

pred mult1_EnonActive[]{
	//mulitplicity on nonActive:P->P[0,1]
	all n:(NP)| lone e:(EnonActive)|e.src=n
}

pred ref_EsetTurn[]{
	//reflexive on setTurn:P->P
	all e:(EsetTurn)| e.src = e.trg
}

pred ref_EnonActive[]{
	//reflexive on nonActive:P->P
	all e:(EnonActive)| e.src = e.trg
}

pred ref_Estart[]{
	//reflexive on start:P->P
	all e:(Estart)| e.src = e.trg
}

pred inj_ETR[]{
	//check injective on TR:T->R
	all n:(NT)| no e1, e2:(ETR)| (e1 != e2 and e1.src = n and e2.src = n and e1.trg = e2.trg)
}

pred ref_Ecrit[]{
	//reflexive on crit:P->P
	all e:(Ecrit)| e.src = e.trg
}

pred nand_EPF1_EPF2[]{
	//NAND constraint between PF2:P->F2 and PF1:P->F1
	all n:(NP) | let e1 = (some e : EPF2 | e.src = n), e2=(some e : EPF1 | e.src = n)|not(e1 and e2)
}

pred xor4_Ecrit_Estart_Echeck_EsetTurn[]{
	//XOR constraint between setTurn:P->P,start:P->P,crit:P->P and check:P->P
	all n:(NP) | let e1=(some e : EsetTurn|e.src = n), e2=(some e : Estart|e.src = n), e3=(some e : Ecrit|e.src = n), e4=(some e : Echeck|e.src = n)|(e1 or e2 or e3 or e4) and not(((e1 and (e2 or e3 or e4)) or (e2 and (e1 or e3 or e4)) or (e3 and (e2 or e1 or e4)) or (e4 and (e2 or e3 or e1))))
}

pred xor_Eactive_EnonActive[]{
	//XOR constraint between active:P->P and nonActive:P->P
	all n:(NP) | let e1 = (some e : Eactive | e.src = n), e2=(some e : EnonActive | e.src = n)|(e1 or e2) and not(e1 and e2)
}

pred mult1_Ecrit[]{
	//mulitplicity on crit:P->P[0,1]
	all n:(NP)| lone e:(Ecrit)|e.src=n
}

pred multi_ETP[]{
	//mulitplicity on TP:T->Pmin:1;max:1
	all n:(NT)| let count = #{e:(ETP)| e.src = n}| count>=1 and count <=1}

pred mult1_EF2R[]{
	//mulitplicity on F2R:F2->R[0,1]
	all n:(NF2)| lone e:(EF2R)|e.src=n
}

pred mult1_Eactive[]{
	//mulitplicity on active:P->P[0,1]
	all n:(NP)| lone e:(Eactive)|e.src=n
}

pred ref_Echeck[]{
	//reflexive on check:P->P
	all e:(Echeck)| e.src = e.trg
}

pred multi1_NT[]{
	//mulitplicity on T min:1;max:1
	let count = #NT | count>=1 and count <=1}

pred mult1_Echeck[]{
	//mulitplicity on check:P->P[0,1]
	all n:(NP)| lone e:(Echeck)|e.src=n
}

pred surj_ETR[]{
	//surjective on TR:T->R
	all n:(NR)| some e:(ETR)| e.trg = n
}

pred multi1_NR[]{
	//mulitplicity on R min:1;max:1
	let count = #NR | count>=1 and count <=1}

pred mult1_EF1R[]{
	//mulitplicity on F1R:F1->R[0,1]
	all n:(NF1)| lone e:(EF1R)|e.src=n
}

pred mult1_ETR[]{
	//mulitplicity on TR:T->R[0,1]
	all n:(NT)| lone e:(ETR)|e.src=n
}

pred ref_Eactive[]{
	//reflexive on active:P->P
	all e:(Eactive)| e.src = e.trg
}

run{not nand1_EF1R_EF2R[] and mult1_EsetTurn[] and mult1_Estart[] and mult1_EPF1[] and mult1_EPF2[] and mult1_EnonActive[] and ref_EsetTurn[] and ref_EnonActive[] and ref_Estart[] and inj_ETR[] and ref_Ecrit[] and nand_EPF1_EPF2[] and xor4_Ecrit_Estart_Echeck_EsetTurn[] and xor_Eactive_EnonActive[] and mult1_Ecrit[] and multi_ETP[] and mult1_EF2R[] and mult1_Eactive[] and ref_Echeck[] and multi1_NT[] and mult1_Echeck[] and surj_ETR[] and multi1_NR[] and mult1_EF1R[] and mult1_ETR[] and ref_Eactive[]} for 5
run{not mult1_EsetTurn[] and nand1_EF1R_EF2R[] and mult1_Estart[] and mult1_EPF1[] and mult1_EPF2[] and mult1_EnonActive[] and ref_EsetTurn[] and ref_EnonActive[] and ref_Estart[] and inj_ETR[] and ref_Ecrit[] and nand_EPF1_EPF2[] and xor4_Ecrit_Estart_Echeck_EsetTurn[] and xor_Eactive_EnonActive[] and mult1_Ecrit[] and multi_ETP[] and mult1_EF2R[] and mult1_Eactive[] and ref_Echeck[] and multi1_NT[] and mult1_Echeck[] and surj_ETR[] and multi1_NR[] and mult1_EF1R[] and mult1_ETR[] and ref_Eactive[]} for 5
run{not mult1_Estart[] and nand1_EF1R_EF2R[] and mult1_EsetTurn[] and mult1_EPF1[] and mult1_EPF2[] and mult1_EnonActive[] and ref_EsetTurn[] and ref_EnonActive[] and ref_Estart[] and inj_ETR[] and ref_Ecrit[] and nand_EPF1_EPF2[] and xor4_Ecrit_Estart_Echeck_EsetTurn[] and xor_Eactive_EnonActive[] and mult1_Ecrit[] and multi_ETP[] and mult1_EF2R[] and mult1_Eactive[] and ref_Echeck[] and multi1_NT[] and mult1_Echeck[] and surj_ETR[] and multi1_NR[] and mult1_EF1R[] and mult1_ETR[] and ref_Eactive[]} for 5
run{not mult1_EPF1[] and nand1_EF1R_EF2R[] and mult1_EsetTurn[] and mult1_Estart[] and mult1_EPF2[] and mult1_EnonActive[] and ref_EsetTurn[] and ref_EnonActive[] and ref_Estart[] and inj_ETR[] and ref_Ecrit[] and nand_EPF1_EPF2[] and xor4_Ecrit_Estart_Echeck_EsetTurn[] and xor_Eactive_EnonActive[] and mult1_Ecrit[] and multi_ETP[] and mult1_EF2R[] and mult1_Eactive[] and ref_Echeck[] and multi1_NT[] and mult1_Echeck[] and surj_ETR[] and multi1_NR[] and mult1_EF1R[] and mult1_ETR[] and ref_Eactive[]} for 5
run{not mult1_EPF2[] and nand1_EF1R_EF2R[] and mult1_EsetTurn[] and mult1_Estart[] and mult1_EPF1[] and mult1_EnonActive[] and ref_EsetTurn[] and ref_EnonActive[] and ref_Estart[] and inj_ETR[] and ref_Ecrit[] and nand_EPF1_EPF2[] and xor4_Ecrit_Estart_Echeck_EsetTurn[] and xor_Eactive_EnonActive[] and mult1_Ecrit[] and multi_ETP[] and mult1_EF2R[] and mult1_Eactive[] and ref_Echeck[] and multi1_NT[] and mult1_Echeck[] and surj_ETR[] and multi1_NR[] and mult1_EF1R[] and mult1_ETR[] and ref_Eactive[]} for 5
run{not mult1_EnonActive[] and nand1_EF1R_EF2R[] and mult1_EsetTurn[] and mult1_Estart[] and mult1_EPF1[] and mult1_EPF2[] and ref_EsetTurn[] and ref_EnonActive[] and ref_Estart[] and inj_ETR[] and ref_Ecrit[] and nand_EPF1_EPF2[] and xor4_Ecrit_Estart_Echeck_EsetTurn[] and xor_Eactive_EnonActive[] and mult1_Ecrit[] and multi_ETP[] and mult1_EF2R[] and mult1_Eactive[] and ref_Echeck[] and multi1_NT[] and mult1_Echeck[] and surj_ETR[] and multi1_NR[] and mult1_EF1R[] and mult1_ETR[] and ref_Eactive[]} for 5
run{not ref_EsetTurn[] and nand1_EF1R_EF2R[] and mult1_EsetTurn[] and mult1_Estart[] and mult1_EPF1[] and mult1_EPF2[] and mult1_EnonActive[] and ref_EnonActive[] and ref_Estart[] and inj_ETR[] and ref_Ecrit[] and nand_EPF1_EPF2[] and xor4_Ecrit_Estart_Echeck_EsetTurn[] and xor_Eactive_EnonActive[] and mult1_Ecrit[] and multi_ETP[] and mult1_EF2R[] and mult1_Eactive[] and ref_Echeck[] and multi1_NT[] and mult1_Echeck[] and surj_ETR[] and multi1_NR[] and mult1_EF1R[] and mult1_ETR[] and ref_Eactive[]} for 5
run{not ref_EnonActive[] and nand1_EF1R_EF2R[] and mult1_EsetTurn[] and mult1_Estart[] and mult1_EPF1[] and mult1_EPF2[] and mult1_EnonActive[] and ref_EsetTurn[] and ref_Estart[] and inj_ETR[] and ref_Ecrit[] and nand_EPF1_EPF2[] and xor4_Ecrit_Estart_Echeck_EsetTurn[] and xor_Eactive_EnonActive[] and mult1_Ecrit[] and multi_ETP[] and mult1_EF2R[] and mult1_Eactive[] and ref_Echeck[] and multi1_NT[] and mult1_Echeck[] and surj_ETR[] and multi1_NR[] and mult1_EF1R[] and mult1_ETR[] and ref_Eactive[]} for 5
run{not ref_Estart[] and nand1_EF1R_EF2R[] and mult1_EsetTurn[] and mult1_Estart[] and mult1_EPF1[] and mult1_EPF2[] and mult1_EnonActive[] and ref_EsetTurn[] and ref_EnonActive[] and inj_ETR[] and ref_Ecrit[] and nand_EPF1_EPF2[] and xor4_Ecrit_Estart_Echeck_EsetTurn[] and xor_Eactive_EnonActive[] and mult1_Ecrit[] and multi_ETP[] and mult1_EF2R[] and mult1_Eactive[] and ref_Echeck[] and multi1_NT[] and mult1_Echeck[] and surj_ETR[] and multi1_NR[] and mult1_EF1R[] and mult1_ETR[] and ref_Eactive[]} for 5
run{not inj_ETR[] and nand1_EF1R_EF2R[] and mult1_EsetTurn[] and mult1_Estart[] and mult1_EPF1[] and mult1_EPF2[] and mult1_EnonActive[] and ref_EsetTurn[] and ref_EnonActive[] and ref_Estart[] and ref_Ecrit[] and nand_EPF1_EPF2[] and xor4_Ecrit_Estart_Echeck_EsetTurn[] and xor_Eactive_EnonActive[] and mult1_Ecrit[] and multi_ETP[] and mult1_EF2R[] and mult1_Eactive[] and ref_Echeck[] and multi1_NT[] and mult1_Echeck[] and surj_ETR[] and multi1_NR[] and mult1_EF1R[] and mult1_ETR[] and ref_Eactive[]} for 5
run{not ref_Ecrit[] and nand1_EF1R_EF2R[] and mult1_EsetTurn[] and mult1_Estart[] and mult1_EPF1[] and mult1_EPF2[] and mult1_EnonActive[] and ref_EsetTurn[] and ref_EnonActive[] and ref_Estart[] and inj_ETR[] and nand_EPF1_EPF2[] and xor4_Ecrit_Estart_Echeck_EsetTurn[] and xor_Eactive_EnonActive[] and mult1_Ecrit[] and multi_ETP[] and mult1_EF2R[] and mult1_Eactive[] and ref_Echeck[] and multi1_NT[] and mult1_Echeck[] and surj_ETR[] and multi1_NR[] and mult1_EF1R[] and mult1_ETR[] and ref_Eactive[]} for 5
run{not nand_EPF1_EPF2[] and nand1_EF1R_EF2R[] and mult1_EsetTurn[] and mult1_Estart[] and mult1_EPF1[] and mult1_EPF2[] and mult1_EnonActive[] and ref_EsetTurn[] and ref_EnonActive[] and ref_Estart[] and inj_ETR[] and ref_Ecrit[] and xor4_Ecrit_Estart_Echeck_EsetTurn[] and xor_Eactive_EnonActive[] and mult1_Ecrit[] and multi_ETP[] and mult1_EF2R[] and mult1_Eactive[] and ref_Echeck[] and multi1_NT[] and mult1_Echeck[] and surj_ETR[] and multi1_NR[] and mult1_EF1R[] and mult1_ETR[] and ref_Eactive[]} for 5
run{not xor4_Ecrit_Estart_Echeck_EsetTurn[] and nand1_EF1R_EF2R[] and mult1_EsetTurn[] and mult1_Estart[] and mult1_EPF1[] and mult1_EPF2[] and mult1_EnonActive[] and ref_EsetTurn[] and ref_EnonActive[] and ref_Estart[] and inj_ETR[] and ref_Ecrit[] and nand_EPF1_EPF2[] and xor_Eactive_EnonActive[] and mult1_Ecrit[] and multi_ETP[] and mult1_EF2R[] and mult1_Eactive[] and ref_Echeck[] and multi1_NT[] and mult1_Echeck[] and surj_ETR[] and multi1_NR[] and mult1_EF1R[] and mult1_ETR[] and ref_Eactive[]} for 5
run{not xor_Eactive_EnonActive[] and nand1_EF1R_EF2R[] and mult1_EsetTurn[] and mult1_Estart[] and mult1_EPF1[] and mult1_EPF2[] and mult1_EnonActive[] and ref_EsetTurn[] and ref_EnonActive[] and ref_Estart[] and inj_ETR[] and ref_Ecrit[] and nand_EPF1_EPF2[] and xor4_Ecrit_Estart_Echeck_EsetTurn[] and mult1_Ecrit[] and multi_ETP[] and mult1_EF2R[] and mult1_Eactive[] and ref_Echeck[] and multi1_NT[] and mult1_Echeck[] and surj_ETR[] and multi1_NR[] and mult1_EF1R[] and mult1_ETR[] and ref_Eactive[]} for 5
run{not mult1_Ecrit[] and nand1_EF1R_EF2R[] and mult1_EsetTurn[] and mult1_Estart[] and mult1_EPF1[] and mult1_EPF2[] and mult1_EnonActive[] and ref_EsetTurn[] and ref_EnonActive[] and ref_Estart[] and inj_ETR[] and ref_Ecrit[] and nand_EPF1_EPF2[] and xor4_Ecrit_Estart_Echeck_EsetTurn[] and xor_Eactive_EnonActive[] and multi_ETP[] and mult1_EF2R[] and mult1_Eactive[] and ref_Echeck[] and multi1_NT[] and mult1_Echeck[] and surj_ETR[] and multi1_NR[] and mult1_EF1R[] and mult1_ETR[] and ref_Eactive[]} for 5
run{not multi_ETP[] and nand1_EF1R_EF2R[] and mult1_EsetTurn[] and mult1_Estart[] and mult1_EPF1[] and mult1_EPF2[] and mult1_EnonActive[] and ref_EsetTurn[] and ref_EnonActive[] and ref_Estart[] and inj_ETR[] and ref_Ecrit[] and nand_EPF1_EPF2[] and xor4_Ecrit_Estart_Echeck_EsetTurn[] and xor_Eactive_EnonActive[] and mult1_Ecrit[] and mult1_EF2R[] and mult1_Eactive[] and ref_Echeck[] and multi1_NT[] and mult1_Echeck[] and surj_ETR[] and multi1_NR[] and mult1_EF1R[] and mult1_ETR[] and ref_Eactive[]} for 5
run{not mult1_EF2R[] and nand1_EF1R_EF2R[] and mult1_EsetTurn[] and mult1_Estart[] and mult1_EPF1[] and mult1_EPF2[] and mult1_EnonActive[] and ref_EsetTurn[] and ref_EnonActive[] and ref_Estart[] and inj_ETR[] and ref_Ecrit[] and nand_EPF1_EPF2[] and xor4_Ecrit_Estart_Echeck_EsetTurn[] and xor_Eactive_EnonActive[] and mult1_Ecrit[] and multi_ETP[] and mult1_Eactive[] and ref_Echeck[] and multi1_NT[] and mult1_Echeck[] and surj_ETR[] and multi1_NR[] and mult1_EF1R[] and mult1_ETR[] and ref_Eactive[]} for 5
run{not mult1_Eactive[] and nand1_EF1R_EF2R[] and mult1_EsetTurn[] and mult1_Estart[] and mult1_EPF1[] and mult1_EPF2[] and mult1_EnonActive[] and ref_EsetTurn[] and ref_EnonActive[] and ref_Estart[] and inj_ETR[] and ref_Ecrit[] and nand_EPF1_EPF2[] and xor4_Ecrit_Estart_Echeck_EsetTurn[] and xor_Eactive_EnonActive[] and mult1_Ecrit[] and multi_ETP[] and mult1_EF2R[] and ref_Echeck[] and multi1_NT[] and mult1_Echeck[] and surj_ETR[] and multi1_NR[] and mult1_EF1R[] and mult1_ETR[] and ref_Eactive[]} for 5
run{not ref_Echeck[] and nand1_EF1R_EF2R[] and mult1_EsetTurn[] and mult1_Estart[] and mult1_EPF1[] and mult1_EPF2[] and mult1_EnonActive[] and ref_EsetTurn[] and ref_EnonActive[] and ref_Estart[] and inj_ETR[] and ref_Ecrit[] and nand_EPF1_EPF2[] and xor4_Ecrit_Estart_Echeck_EsetTurn[] and xor_Eactive_EnonActive[] and mult1_Ecrit[] and multi_ETP[] and mult1_EF2R[] and mult1_Eactive[] and multi1_NT[] and mult1_Echeck[] and surj_ETR[] and multi1_NR[] and mult1_EF1R[] and mult1_ETR[] and ref_Eactive[]} for 5
run{not multi1_NT[] and nand1_EF1R_EF2R[] and mult1_EsetTurn[] and mult1_Estart[] and mult1_EPF1[] and mult1_EPF2[] and mult1_EnonActive[] and ref_EsetTurn[] and ref_EnonActive[] and ref_Estart[] and inj_ETR[] and ref_Ecrit[] and nand_EPF1_EPF2[] and xor4_Ecrit_Estart_Echeck_EsetTurn[] and xor_Eactive_EnonActive[] and mult1_Ecrit[] and multi_ETP[] and mult1_EF2R[] and mult1_Eactive[] and ref_Echeck[] and mult1_Echeck[] and surj_ETR[] and multi1_NR[] and mult1_EF1R[] and mult1_ETR[] and ref_Eactive[]} for 5
run{not mult1_Echeck[] and nand1_EF1R_EF2R[] and mult1_EsetTurn[] and mult1_Estart[] and mult1_EPF1[] and mult1_EPF2[] and mult1_EnonActive[] and ref_EsetTurn[] and ref_EnonActive[] and ref_Estart[] and inj_ETR[] and ref_Ecrit[] and nand_EPF1_EPF2[] and xor4_Ecrit_Estart_Echeck_EsetTurn[] and xor_Eactive_EnonActive[] and mult1_Ecrit[] and multi_ETP[] and mult1_EF2R[] and mult1_Eactive[] and ref_Echeck[] and multi1_NT[] and surj_ETR[] and multi1_NR[] and mult1_EF1R[] and mult1_ETR[] and ref_Eactive[]} for 5
run{not surj_ETR[] and nand1_EF1R_EF2R[] and mult1_EsetTurn[] and mult1_Estart[] and mult1_EPF1[] and mult1_EPF2[] and mult1_EnonActive[] and ref_EsetTurn[] and ref_EnonActive[] and ref_Estart[] and inj_ETR[] and ref_Ecrit[] and nand_EPF1_EPF2[] and xor4_Ecrit_Estart_Echeck_EsetTurn[] and xor_Eactive_EnonActive[] and mult1_Ecrit[] and multi_ETP[] and mult1_EF2R[] and mult1_Eactive[] and ref_Echeck[] and multi1_NT[] and mult1_Echeck[] and multi1_NR[] and mult1_EF1R[] and mult1_ETR[] and ref_Eactive[]} for 5
run{not multi1_NR[] and nand1_EF1R_EF2R[] and mult1_EsetTurn[] and mult1_Estart[] and mult1_EPF1[] and mult1_EPF2[] and mult1_EnonActive[] and ref_EsetTurn[] and ref_EnonActive[] and ref_Estart[] and inj_ETR[] and ref_Ecrit[] and nand_EPF1_EPF2[] and xor4_Ecrit_Estart_Echeck_EsetTurn[] and xor_Eactive_EnonActive[] and mult1_Ecrit[] and multi_ETP[] and mult1_EF2R[] and mult1_Eactive[] and ref_Echeck[] and multi1_NT[] and mult1_Echeck[] and surj_ETR[] and mult1_EF1R[] and mult1_ETR[] and ref_Eactive[]} for 5
run{not mult1_EF1R[] and nand1_EF1R_EF2R[] and mult1_EsetTurn[] and mult1_Estart[] and mult1_EPF1[] and mult1_EPF2[] and mult1_EnonActive[] and ref_EsetTurn[] and ref_EnonActive[] and ref_Estart[] and inj_ETR[] and ref_Ecrit[] and nand_EPF1_EPF2[] and xor4_Ecrit_Estart_Echeck_EsetTurn[] and xor_Eactive_EnonActive[] and mult1_Ecrit[] and multi_ETP[] and mult1_EF2R[] and mult1_Eactive[] and ref_Echeck[] and multi1_NT[] and mult1_Echeck[] and surj_ETR[] and multi1_NR[] and mult1_ETR[] and ref_Eactive[]} for 5
run{not mult1_ETR[] and nand1_EF1R_EF2R[] and mult1_EsetTurn[] and mult1_Estart[] and mult1_EPF1[] and mult1_EPF2[] and mult1_EnonActive[] and ref_EsetTurn[] and ref_EnonActive[] and ref_Estart[] and inj_ETR[] and ref_Ecrit[] and nand_EPF1_EPF2[] and xor4_Ecrit_Estart_Echeck_EsetTurn[] and xor_Eactive_EnonActive[] and mult1_Ecrit[] and multi_ETP[] and mult1_EF2R[] and mult1_Eactive[] and ref_Echeck[] and multi1_NT[] and mult1_Echeck[] and surj_ETR[] and multi1_NR[] and mult1_EF1R[] and ref_Eactive[]} for 5
run{not ref_Eactive[] and nand1_EF1R_EF2R[] and mult1_EsetTurn[] and mult1_Estart[] and mult1_EPF1[] and mult1_EPF2[] and mult1_EnonActive[] and ref_EsetTurn[] and ref_EnonActive[] and ref_Estart[] and inj_ETR[] and ref_Ecrit[] and nand_EPF1_EPF2[] and xor4_Ecrit_Estart_Echeck_EsetTurn[] and xor_Eactive_EnonActive[] and mult1_Ecrit[] and multi_ETP[] and mult1_EF2R[] and mult1_Eactive[] and ref_Echeck[] and multi1_NT[] and mult1_Echeck[] and surj_ETR[] and multi1_NR[] and mult1_EF1R[] and mult1_ETR[]} for 5
