//Signatures for nodes
sig NPerson{}
abstract sig NGender{}
abstract sig NCivilStatus{}
lone sig Nmale, Nfemale extends NGender{}
lone sig Nmarried, Nsingle, Ndivorced, Nwidowed extends NCivilStatus{}

//Signatures for edges
sig Ehusband{src:one NPerson, trg:one NPerson}
sig Ewife{src:one NPerson, trg:one NPerson}
sig EpGender{src:one NPerson, trg:one NGender}
sig EpCivstat{src:one NPerson, trg:one NCivilStatus}

//preds
pred inv_Ewife_Ehusband[]{
	all x:NPerson, y:NPerson| (some xy:Ehusband| xy.src=x and xy.trg=y) <=>  (some yx:Ewife| yx.src=y and yx.trg=x) 
}

pred multi_EpCivstat[]{
	//mulitplicity on pCivstat:Person->CivilStatusmin:1;max:1
	all n:(NPerson)| let count = #{e:(EpCivstat)| e.src = n}| count>=1 and count <=1}

pred multi_Ewife[]{
	//mulitplicity on wife:Person->Personmin:0;max:1
	all n:(NPerson)| let count = #{e:(Ewife)| e.src = n}| count>=0 and count <=1}

pred multi_Ehusband[]{
	//mulitplicity on husband:Person->Personmin:0;max:1
	all n:(NPerson)| let count = #{e:(Ehusband)| e.src = n}| count>=0 and count <=1}

pred surj_EpGender[]{
	//surjective on pGender:Person->Gender
	all n:(NGender)| some e:(EpGender)| e.trg = n
}

pred nand_Ewife_Ehusband[]{
	//NAND constraint between wife:Person->Person and husband:Person->Person
	all n:(NPerson) | let e1 = (some e : Ewife | e.src = n), e2=(some e : Ehusband | e.src = n)|not(e1 and e2)
}

pred multi_EpGender[]{
	//mulitplicity on pGender:Person->Gendermin:1;max:1
	all n:(NPerson)| let count = #{e:(EpGender)| e.src = n}| count>=1 and count <=1}

pred irr_Ehusband[]{
	//reflexive on husband:Person->Person
	no e:(Ehusband)| e.src = e.trg
}

pred surj_EpCivstat[]{
	//surjective on pCivstat:Person->CivilStatus
	all n:(NCivilStatus)| some e:(EpCivstat)| e.trg = n
}

pred irr_Ewife[]{
	//reflexive on wife:Person->Person
	no e:(Ewife)| e.src = e.trg
}

run{not inv_Ewife_Ehusband[] and multi_EpCivstat[] and multi_Ewife[] and multi_Ehusband[] and surj_EpGender[] and nand_Ewife_Ehusband[] and multi_EpGender[] and irr_Ehusband[] and surj_EpCivstat[] and irr_Ewife[]} for 5
run{not multi_EpCivstat[] and inv_Ewife_Ehusband[] and multi_Ewife[] and multi_Ehusband[] and surj_EpGender[] and nand_Ewife_Ehusband[] and multi_EpGender[] and irr_Ehusband[] and surj_EpCivstat[] and irr_Ewife[]} for 5
run{not multi_Ewife[] and inv_Ewife_Ehusband[] and multi_EpCivstat[] and multi_Ehusband[] and surj_EpGender[] and nand_Ewife_Ehusband[] and multi_EpGender[] and irr_Ehusband[] and surj_EpCivstat[] and irr_Ewife[]} for 5
run{not multi_Ehusband[] and inv_Ewife_Ehusband[] and multi_EpCivstat[] and multi_Ewife[] and surj_EpGender[] and nand_Ewife_Ehusband[] and multi_EpGender[] and irr_Ehusband[] and surj_EpCivstat[] and irr_Ewife[]} for 5
run{not surj_EpGender[] and inv_Ewife_Ehusband[] and multi_EpCivstat[] and multi_Ewife[] and multi_Ehusband[] and nand_Ewife_Ehusband[] and multi_EpGender[] and irr_Ehusband[] and surj_EpCivstat[] and irr_Ewife[]} for 5
run{not nand_Ewife_Ehusband[] and inv_Ewife_Ehusband[] and multi_EpCivstat[] and multi_Ewife[] and multi_Ehusband[] and surj_EpGender[] and multi_EpGender[] and irr_Ehusband[] and surj_EpCivstat[] and irr_Ewife[]} for 5
run{not multi_EpGender[] and inv_Ewife_Ehusband[] and multi_EpCivstat[] and multi_Ewife[] and multi_Ehusband[] and surj_EpGender[] and nand_Ewife_Ehusband[] and irr_Ehusband[] and surj_EpCivstat[] and irr_Ewife[]} for 5
run{not irr_Ehusband[] and inv_Ewife_Ehusband[] and multi_EpCivstat[] and multi_Ewife[] and multi_Ehusband[] and surj_EpGender[] and nand_Ewife_Ehusband[] and multi_EpGender[] and surj_EpCivstat[] and irr_Ewife[]} for 5
run{not surj_EpCivstat[] and inv_Ewife_Ehusband[] and multi_EpCivstat[] and multi_Ewife[] and multi_Ehusband[] and surj_EpGender[] and nand_Ewife_Ehusband[] and multi_EpGender[] and irr_Ehusband[] and irr_Ewife[]} for 5
run{not irr_Ewife[] and inv_Ewife_Ehusband[] and multi_EpCivstat[] and multi_Ewife[] and multi_Ehusband[] and surj_EpGender[] and nand_Ewife_Ehusband[] and multi_EpGender[] and irr_Ehusband[] and surj_EpCivstat[]} for 5
