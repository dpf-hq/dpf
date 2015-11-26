//Signatures for nodes
sig NTD{}
sig NPA{}
sig NBT1{}
sig NE2{}
sig NEND{}
sig NPB{}
sig NBool{}
sig NBT2{}
sig NMRI{}
sig NE1{}
sig NInt{}
sig NIE{}
sig NState{}

//Signatures for edges
sig Eatt0{src:one NIE, trg:one NState}
sig Ecount{src:one NE2, trg:one NInt}
sig Eatt4{src:one NPA, trg:one NState}
sig Ef10{src:one NTD, trg:one NBT2}
sig Ef3{src:one NMRI, trg:one NE1}
sig Eatt6{src:one NE2, trg:one NState}
sig Eatt8{src:one NTD, trg:one NState}
sig Ef5{src:one NE1, trg:one NPB}
sig Eatt9{src:one NEND, trg:one NState}
sig Ef0{src:one NIE, trg:one NBT1}
sig Eatt5{src:one NPB, trg:one NState}
sig Ef1{src:one NIE, trg:one NMRI}
sig EresE1{src:one NE1, trg:one NBool}
sig Ef4{src:one NE1, trg:one NPA}
sig Eatt1{src:one NMRI, trg:one NState}
sig Ef9{src:one NE2, trg:one NTD}
sig Ef6{src:one NPA, trg:one NE2}
sig Eatt7{src:one NBT2, trg:one NState}
sig Eatt3{src:one NE1, trg:one NState}
sig EresE2{src:one NE2, trg:one NBool}
sig Eatt2{src:one NBT1, trg:one NState}
sig Ef11{src:one NBT2, trg:one NE2}
sig Ef2{src:one NBT1, trg:one NE1}
sig Ef8{src:one NE2, trg:one NEND}
sig Ef7{src:one NPB, trg:one NE2}

//facts
fact mult1_Ef10{
	//mulitplicity on f10:TD->BT2[0,1]
	all n:(NTD)| lone e:(Ef10)|e.src=n
}

fact mult1_Ef11{
	//mulitplicity on f11:BT2->E2[0,1]
	all n:(NBT2)| lone e:(Ef11)|e.src=n
}

fact XOR_SPLIT_Ef8_Ef9{
	}

fact AND_MERGE_Ef3_Ef2{
	}

fact OR_MERGE_Ef11_Ef6{
	}

fact XOR_SPLIT_Ef4_Ef5{
	}

fact mult1_Ef9{
	//mulitplicity on f9:E2->TD[0,1]
	all n:(NE2)| lone e:(Ef9)|e.src=n
}

fact mult1_Ef7{
	//mulitplicity on f7:PB->E2[0,1]
	all n:(NPB)| lone e:(Ef7)|e.src=n
}

fact mult1_Ef8{
	//mulitplicity on f8:E2->END[0,1]
	all n:(NE2)| lone e:(Ef8)|e.src=n
}

fact mult1_Ef5{
	//mulitplicity on f5:E1->PB[0,1]
	all n:(NE1)| lone e:(Ef5)|e.src=n
}

fact multi_Ecount{
	//mulitplicity on count:E2->Intmin:1;max:1
	all n:(NE2)| let count = #{e:(Ecount)| e.src = n}| count>=1 and count <=1}

fact multi_Eatt6{
	//mulitplicity on att6:E2->Statemin:1;max:1
	all n:(NE2)| let count = #{e:(Eatt6)| e.src = n}| count>=1 and count <=1}

fact mult1_Ef6{
	//mulitplicity on f6:PA->E2[0,1]
	all n:(NPA)| lone e:(Ef6)|e.src=n
}

fact multi_EresE2{
	//mulitplicity on resE2:E2->Boolmin:1;max:1
	all n:(NE2)| let count = #{e:(EresE2)| e.src = n}| count>=1 and count <=1}

fact multi_Eatt7{
	//mulitplicity on att7:BT2->Statemin:1;max:1
	all n:(NBT2)| let count = #{e:(Eatt7)| e.src = n}| count>=1 and count <=1}

fact mult1_Ef3{
	//mulitplicity on f3:MRI->E1[0,1]
	all n:(NMRI)| lone e:(Ef3)|e.src=n
}

fact multi_EresE1{
	//mulitplicity on resE1:E1->Boolmin:1;max:1
	all n:(NE1)| let count = #{e:(EresE1)| e.src = n}| count>=1 and count <=1}

fact multi_Eatt8{
	//mulitplicity on att8:TD->Statemin:1;max:1
	all n:(NTD)| let count = #{e:(Eatt8)| e.src = n}| count>=1 and count <=1}

fact mult1_Ef4{
	//mulitplicity on f4:E1->PA[0,1]
	all n:(NE1)| lone e:(Ef4)|e.src=n
}

fact XOR_MERGE_Ef6_Ef7{
	}

fact multi_Eatt9{
	//mulitplicity on att9:END->Statemin:1;max:1
	all n:(NEND)| let count = #{e:(Eatt9)| e.src = n}| count>=1 and count <=1}

fact mult1_Ef1{
	//mulitplicity on f1:IE->MRI[0,1]
	all n:(NIE)| lone e:(Ef1)|e.src=n
}

fact multi_Eatt2{
	//mulitplicity on att2:BT1->Statemin:1;max:1
	all n:(NBT1)| let count = #{e:(Eatt2)| e.src = n}| count>=1 and count <=1}

fact mult1_Ef2{
	//mulitplicity on f2:BT1->E1[0,1]
	all n:(NBT1)| lone e:(Ef2)|e.src=n
}

fact multi_Eatt3{
	//mulitplicity on att3:E1->Statemin:1;max:1
	all n:(NE1)| let count = #{e:(Eatt3)| e.src = n}| count>=1 and count <=1}

fact multi_Eatt4{
	//mulitplicity on att4:PA->Statemin:1;max:1
	all n:(NPA)| let count = #{e:(Eatt4)| e.src = n}| count>=1 and count <=1}

fact mult1_Ef0{
	//mulitplicity on f0:IE->BT1[0,1]
	all n:(NIE)| lone e:(Ef0)|e.src=n
}

fact multi_Eatt5{
	//mulitplicity on att5:PB->Statemin:1;max:1
	all n:(NPB)| let count = #{e:(Eatt5)| e.src = n}| count>=1 and count <=1}

fact multi_Eatt0{
	//mulitplicity on att0:IE->Statemin:0;max:1
	all n:(NIE)| let count = #{e:(Eatt0)| e.src = n}| count>=0 and count <=1}

fact multi_Eatt1{
	//mulitplicity on att1:MRI->Statemin:1;max:1
	all n:(NMRI)| let count = #{e:(Eatt1)| e.src = n}| count>=1 and count <=1}

fact AND_SPLIT_Ef0_Ef1{
	}

run{} for 3
run{} for 4
run{} for 5
