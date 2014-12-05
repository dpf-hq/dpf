//signatures for nodes
sig NPerson{}
fact{some NPerson}
abstract sig NGender{}
lone sig Nmale, Nfemale extends NGender{}
abstract sig NCivilStatus{}
lone sig Nmarried, Nsingle, Ndivorced, Nwidowed extends NCivilStatus{}

//signatures for edges
sig Egender{src:one NPerson, trg:one NGender}
sig Ewife{src:one NPerson, trg:one NPerson}
sig Ehusband{src:one NPerson, trg:one NPerson}
sig Ecivstat{src:one NPerson, trg:one NCivilStatus}

fact mult1_wife{
//mulitplicity on wife:Person->Person[0,1]
	all n:(NPerson)| lone e:(Ewife)|e.src=n
}
fact mult1_husband{
//mulitplicity on husband:Person->Person[0,1]
	all n:(NPerson)| lone e:(Ehusband)|e.src=n
}
fact xor_Ehusband_Ewife{
//XOR constraint between wife:Person->Person and husband:Person->Person
	all n:(NPerson) | let e1 = (some e : Ewife | e.src = n), e2=(some e : Ehusband | e.src = n)|(e1 or e2) and not(e1 and e2)
}
fact inv_Ewife_Ehusband{
all x:NPerson, y:NPerson| (some xy:Ehusband| xy.src=x and xy.trg=y) <=>  (some yx:Ewife| yx.src=y and yx.trg=x) 
}
fact multi1_Egender{
//mulitplicity on gender:Person->Gendermin:1;max:1
	all n:(NPerson)| let count = #{e:(Egender)| e.src = n}| count>=1 and count <=1}
fact surj_Egender{
//surjective on gender:Person->Gender
	all n:(NGender)| some e:(Egender)| e.trg = n
}
fact multi1_Ecivstat{
//mulitplicity on civstat:Person->CivilStatusmin:0;max:1
	all n:(NPerson)| let count = #{e:(Ecivstat)| e.src = n}| count>=0 and count <=1}
fact surj_Ecivstat{
//surjective on civstat:Person->CivilStatus
	all n:(NCivilStatus)| some e:(Ecivstat)| e.trg = n
}
fact irr_Ehusband{
//reflexive on husband:Person->Person
	no e:(Ehusband)| e.src = e.trg
}
fact irr_Ewife{
//reflexive on wife:Person->Person
	no e:(Ewife)| e.src = e.trg
}
fact marriedWithoutWifeWithHusband{
all s:Ecivstat|let P1=s.src,married=s.trg|
	married in Nmarried and not (some w:Ewife|let Person0=w.trg|
	w.src=P1) implies (some h:Ehusband|let Person1=h.trg|
	h.src=P1) 
}
fact marriedWithoutHusbandWithWife{
all civstat0:Ecivstat|let P0=civstat0.src,married=civstat0.trg|
	married in Nmarried and not (some h:Ehusband|let P2=h.trg|
	h.src=P0) implies (some w:Ewife|let P1=w.trg|
	w.src=P0) 
}
fact hasWifeIsMarried{
all wife0:Ewife|let P1=wife0.src,Person1=wife0.trg|
	(P1=wife0.src and Person1=wife0.trg) implies (some civstat0:Ecivstat|let married=civstat0.trg|
	(civstat0.src=P1 and married in Nmarried)) 
}
fact hasHusbandIsMarried{
all h:Ehusband|let P0=h.src,P1=h.trg|
	(P0=h.src and P1=h.trg) implies (some civstat0:Ecivstat|let married=civstat0.trg|
	(civstat0.src=P0 and married in Nmarried)) 
}
fact AtLeastOneSingle{
some civstat0:Ecivstat|let P0=civstat0.src,single=civstat0.trg|
	single in Nsingle
}
run {} for 5