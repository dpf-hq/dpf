//Signatures for nodes
sig N2{}
sig N14{}
sig N20{}
sig N10{}
sig N16{}
sig N7{}
sig N15{}
sig N17{}
sig N9{}
sig N12{}
sig N4{}
sig N6{}
sig N0{}
sig N1{}
sig N5{}
sig N8{}
sig N3{}
sig N11{}
sig N19{}
sig N13{}
sig N18{}
sig N21{}

//Signatures for edges
sig E28{src:one N6, trg:one N7}
sig E34{src:one N13, trg:one N14}
sig E36{src:one N13, trg:one N16}
sig E37{src:one N16, trg:one N12}
sig E39{src:one N17, trg:one N9}
sig E30{src:one N2, trg:one N8}
sig E26{src:one N4, trg:one N5}
sig E35{src:one N13, trg:one N15}
sig E27{src:one N5, trg:one N6}
sig E29{src:one N7, trg:one N8}
sig E33{src:one N12, trg:one N13}
sig E42{src:one N16, trg:one N19}
sig E23{src:one N1, trg:one N2}
sig E25{src:one N3, trg:one N4}
sig E40{src:one N9, trg:one N10}
sig E44{src:one N12, trg:one N21}
sig E43{src:one N15, trg:one N20}
sig E38{src:one N8, trg:one N17}
sig E22{src:one N0, trg:one N1}
sig E31{src:one N10, trg:one N12}
sig E24{src:one N2, trg:one N3}
sig E41{src:one N5, trg:one N18}
sig E32{src:one N10, trg:one N11}

//preds
pred surj_E24[]{
	//surjective on :Check Pre-examination->Book pre-examination
	all n:(N3)| some e:(E24)| e.trg = n
}

pred surj_E25[]{
	//surjective on :Book pre-examination->Print Tag
	all n:(N4)| some e:(E25)| e.trg = n
}

pred surj_E22[]{
	//surjective on :Scan Patients Wristband->Get Patient Info
	all n:(N1)| some e:(E22)| e.trg = n
}

pred xorsurj_E30_E29[]{
	all z:N8 | let e1 = (some e : E29 | e.trg = z), 
e2 = (some e : E30 | e.trg = z)|
(e1 or e2) and not (e1 and e2)
}

pred surj_E23[]{
	//surjective on :Get Patient Info->Check Pre-examination
	all n:(N2)| some e:(E23)| e.trg = n
}

pred surj_E28[]{
	//surjective on :Take Sample->Send Sample
	all n:(N7)| some e:(E28)| e.trg = n
}

pred surj_E26[]{
	//surjective on :Print Tag->Register Tag Infomration
	all n:(N5)| some e:(E26)| e.trg = n
}

pred surj_E27[]{
	//surjective on :Register Tag Infomration->Take Sample
	all n:(N6)| some e:(E27)| e.trg = n
}

pred xorsurj_E37_E31[]{
	all z:N12 | let e1 = (some e : E31 | e.trg = z), 
e2 = (some e : E37 | e.trg = z)|
(e1 or e2) and not (e1 and e2)
}

pred mult1_E38[]{
	//mulitplicity on :Order Blood->Provide Blood[0,1]
	all n:(N8)|lone e:(E38)|e.src=n
}

pred mult1_E39[]{
	//mulitplicity on :Provide Blood->Collect Blood[0,1]
	all n:(N17)|lone e:(E39)|e.src=n
}

pred mult1_E36[]{
	//mulitplicity on :perform Transfusion->Identify nurse and log transfusion[0,1]
	all n:(N13)|lone e:(E36)|e.src=n
}

pred mult1_E37[]{
	//mulitplicity on :Identify nurse and log transfusion->Measure Temperature, blood pressure and pulse[0,1]
	all n:(N16)|lone e:(E37)|e.src=n
}

pred surj_E32[]{
	//surjective on :Verify Information->Stop Transfusion Contact AIT
	all n:(N11)| some e:(E32)| e.trg = n
}

pred mult1_E34[]{
	//mulitplicity on :perform Transfusion->Stop Transfusion, log reaction[0,1]
	all n:(N13)|lone e:(E34)|e.src=n
}

pred multi1_N0[]{
	//mulitplicity on Scan Patients Wristband min:0;max:1
	let count = #N0 | count>=0 and count <=1}

pred mult1_E35[]{
	//mulitplicity on :perform Transfusion->send <<transformationarket>>[0,1]
	all n:(N13)|lone e:(E35)|e.src=n
}

pred mult1_E32[]{
	//mulitplicity on :Verify Information->Stop Transfusion Contact AIT[0,1]
	all n:(N10)|lone e:(E32)|e.src=n
}

pred mult1_E33[]{
	//mulitplicity on :Measure Temperature, blood pressure and pulse->perform Transfusion[0,1]
	all n:(N12)|lone e:(E33)|e.src=n
}

pred mult1_E30[]{
	//mulitplicity on :Check Pre-examination->Order Blood[0,1]
	all n:(N2)|lone e:(E30)|e.src=n
}

pred mult1_E31[]{
	//mulitplicity on :Verify Information->Measure Temperature, blood pressure and pulse[0,1]
	all n:(N10)|lone e:(E31)|e.src=n
}

pred multi1_N15[]{
	//mulitplicity on send <<transformationarket>> min:1;max:1
	let count = #N15 | count>=1 and count <=1}

pred surj_E35[]{
	//surjective on :perform Transfusion->send <<transformationarket>>
	all n:(N15)| some e:(E35)| e.trg = n
}

pred surj_E36[]{
	//surjective on :perform Transfusion->Identify nurse and log transfusion
	all n:(N16)| some e:(E36)| e.trg = n
}

pred nand_E32_E31[]{
	//NAND constraint between :Verify Information->Stop Transfusion Contact AIT and :Verify Information->Measure Temperature, blood pressure and pulse
	all n:(N10) | let e1 = (some e : E32 | e.src = n), e2=(some e : E31 | e.src = n)|not(e1 and e2)
}

pred surj_E33[]{
	//surjective on :Measure Temperature, blood pressure and pulse->perform Transfusion
	all n:(N13)| some e:(E33)| e.trg = n
}

pred nand_E24_E30[]{
	//NAND constraint between :Check Pre-examination->Book pre-examination and :Check Pre-examination->Order Blood
	all n:(N2) | let e1 = (some e : E24 | e.src = n), e2=(some e : E30 | e.src = n)|not(e1 and e2)
}

pred surj_E34[]{
	//surjective on :perform Transfusion->Stop Transfusion, log reaction
	all n:(N14)| some e:(E34)| e.trg = n
}

pred surj_E39[]{
	//surjective on :Provide Blood->Collect Blood
	all n:(N9)| some e:(E39)| e.trg = n
}

pred surj_E38[]{
	//surjective on :Order Blood->Provide Blood
	all n:(N17)| some e:(E38)| e.trg = n
}

pred mult1_E29[]{
	//mulitplicity on :Send Sample->Order Blood[0,1]
	all n:(N7)|lone e:(E29)|e.src=n
}

pred nand3_E35_E34_E36[]{
	all x:N13 | let e1 = (some e : E34 | e.src = x), 
e2 = (some e : E35 | e.src = x), 
e3 = (some e : E36 | e.src = x)|
not(e1 and e2) and not (e1 and e3) and not (e2 and e3)
}

pred mult1_E27[]{
	//mulitplicity on :Register Tag Infomration->Take Sample[0,1]
	all n:(N5)|lone e:(E27)|e.src=n
}

pred mult1_E28[]{
	//mulitplicity on :Take Sample->Send Sample[0,1]
	all n:(N6)|lone e:(E28)|e.src=n
}

pred mult1_E25[]{
	//mulitplicity on :Book pre-examination->Print Tag[0,1]
	all n:(N3)|lone e:(E25)|e.src=n
}

pred mult1_E26[]{
	//mulitplicity on :Print Tag->Register Tag Infomration[0,1]
	all n:(N4)|lone e:(E26)|e.src=n
}

pred mult1_E23[]{
	//mulitplicity on :Get Patient Info->Check Pre-examination[0,1]
	all n:(N1)|lone e:(E23)|e.src=n
}

pred surj_E40[]{
	//surjective on :Collect Blood->Verify Information
	all n:(N10)| some e:(E40)| e.trg = n
}

pred mult1_E24[]{
	//mulitplicity on :Check Pre-examination->Book pre-examination[0,1]
	all n:(N2)|lone e:(E24)|e.src=n
}

pred mult1_E43[]{
	//mulitplicity on :send <<transformationarket>>->Receive arket [0,1]
	all n:(N15)|lone e:(E43)|e.src=n
}

pred mult1_E22[]{
	//mulitplicity on :Scan Patients Wristband->Get Patient Info[0,1]
	all n:(N0)|lone e:(E22)|e.src=n
}

pred mult1_E44[]{
	//mulitplicity on :Measure Temperature, blood pressure and pulse->Store patient state[0,1]
	all n:(N12)|lone e:(E44)|e.src=n
}

pred mult1_E41[]{
	//mulitplicity on :Register Tag Infomration->Store Information[0,1]
	all n:(N5)|lone e:(E41)|e.src=n
}

pred mult1_E42[]{
	//mulitplicity on :Identify nurse and log transfusion->Store Transfusion[0,1]
	all n:(N16)|lone e:(E42)|e.src=n
}

pred mult1_E40[]{
	//mulitplicity on :Collect Blood->Verify Information[0,1]
	all n:(N9)|lone e:(E40)|e.src=n
}

run{not surj_E24[] and surj_E25[] and surj_E22[] and xorsurj_E30_E29[] and surj_E23[] and surj_E28[] and surj_E26[] and surj_E27[] and xorsurj_E37_E31[] and mult1_E38[] and mult1_E39[] and mult1_E36[] and mult1_E37[] and surj_E32[] and mult1_E34[] and multi1_N0[] and mult1_E35[] and mult1_E32[] and mult1_E33[] and mult1_E30[] and mult1_E31[] and multi1_N15[] and surj_E35[] and surj_E36[] and nand_E32_E31[] and surj_E33[] and nand_E24_E30[] and surj_E34[] and surj_E39[] and surj_E38[] and mult1_E29[] and nand3_E35_E34_E36[] and mult1_E27[] and mult1_E28[] and mult1_E25[] and mult1_E26[] and mult1_E23[] and surj_E40[] and mult1_E24[] and mult1_E43[] and mult1_E22[] and mult1_E44[] and mult1_E41[] and mult1_E42[] and mult1_E40[]} for 5
run{not surj_E25[] and surj_E24[] and surj_E22[] and xorsurj_E30_E29[] and surj_E23[] and surj_E28[] and surj_E26[] and surj_E27[] and xorsurj_E37_E31[] and mult1_E38[] and mult1_E39[] and mult1_E36[] and mult1_E37[] and surj_E32[] and mult1_E34[] and multi1_N0[] and mult1_E35[] and mult1_E32[] and mult1_E33[] and mult1_E30[] and mult1_E31[] and multi1_N15[] and surj_E35[] and surj_E36[] and nand_E32_E31[] and surj_E33[] and nand_E24_E30[] and surj_E34[] and surj_E39[] and surj_E38[] and mult1_E29[] and nand3_E35_E34_E36[] and mult1_E27[] and mult1_E28[] and mult1_E25[] and mult1_E26[] and mult1_E23[] and surj_E40[] and mult1_E24[] and mult1_E43[] and mult1_E22[] and mult1_E44[] and mult1_E41[] and mult1_E42[] and mult1_E40[]} for 5
run{not surj_E22[] and surj_E24[] and surj_E25[] and xorsurj_E30_E29[] and surj_E23[] and surj_E28[] and surj_E26[] and surj_E27[] and xorsurj_E37_E31[] and mult1_E38[] and mult1_E39[] and mult1_E36[] and mult1_E37[] and surj_E32[] and mult1_E34[] and multi1_N0[] and mult1_E35[] and mult1_E32[] and mult1_E33[] and mult1_E30[] and mult1_E31[] and multi1_N15[] and surj_E35[] and surj_E36[] and nand_E32_E31[] and surj_E33[] and nand_E24_E30[] and surj_E34[] and surj_E39[] and surj_E38[] and mult1_E29[] and nand3_E35_E34_E36[] and mult1_E27[] and mult1_E28[] and mult1_E25[] and mult1_E26[] and mult1_E23[] and surj_E40[] and mult1_E24[] and mult1_E43[] and mult1_E22[] and mult1_E44[] and mult1_E41[] and mult1_E42[] and mult1_E40[]} for 5
run{not xorsurj_E30_E29[] and surj_E24[] and surj_E25[] and surj_E22[] and surj_E23[] and surj_E28[] and surj_E26[] and surj_E27[] and xorsurj_E37_E31[] and mult1_E38[] and mult1_E39[] and mult1_E36[] and mult1_E37[] and surj_E32[] and mult1_E34[] and multi1_N0[] and mult1_E35[] and mult1_E32[] and mult1_E33[] and mult1_E30[] and mult1_E31[] and multi1_N15[] and surj_E35[] and surj_E36[] and nand_E32_E31[] and surj_E33[] and nand_E24_E30[] and surj_E34[] and surj_E39[] and surj_E38[] and mult1_E29[] and nand3_E35_E34_E36[] and mult1_E27[] and mult1_E28[] and mult1_E25[] and mult1_E26[] and mult1_E23[] and surj_E40[] and mult1_E24[] and mult1_E43[] and mult1_E22[] and mult1_E44[] and mult1_E41[] and mult1_E42[] and mult1_E40[]} for 5
run{not surj_E23[] and surj_E24[] and surj_E25[] and surj_E22[] and xorsurj_E30_E29[] and surj_E28[] and surj_E26[] and surj_E27[] and xorsurj_E37_E31[] and mult1_E38[] and mult1_E39[] and mult1_E36[] and mult1_E37[] and surj_E32[] and mult1_E34[] and multi1_N0[] and mult1_E35[] and mult1_E32[] and mult1_E33[] and mult1_E30[] and mult1_E31[] and multi1_N15[] and surj_E35[] and surj_E36[] and nand_E32_E31[] and surj_E33[] and nand_E24_E30[] and surj_E34[] and surj_E39[] and surj_E38[] and mult1_E29[] and nand3_E35_E34_E36[] and mult1_E27[] and mult1_E28[] and mult1_E25[] and mult1_E26[] and mult1_E23[] and surj_E40[] and mult1_E24[] and mult1_E43[] and mult1_E22[] and mult1_E44[] and mult1_E41[] and mult1_E42[] and mult1_E40[]} for 5
run{not surj_E28[] and surj_E24[] and surj_E25[] and surj_E22[] and xorsurj_E30_E29[] and surj_E23[] and surj_E26[] and surj_E27[] and xorsurj_E37_E31[] and mult1_E38[] and mult1_E39[] and mult1_E36[] and mult1_E37[] and surj_E32[] and mult1_E34[] and multi1_N0[] and mult1_E35[] and mult1_E32[] and mult1_E33[] and mult1_E30[] and mult1_E31[] and multi1_N15[] and surj_E35[] and surj_E36[] and nand_E32_E31[] and surj_E33[] and nand_E24_E30[] and surj_E34[] and surj_E39[] and surj_E38[] and mult1_E29[] and nand3_E35_E34_E36[] and mult1_E27[] and mult1_E28[] and mult1_E25[] and mult1_E26[] and mult1_E23[] and surj_E40[] and mult1_E24[] and mult1_E43[] and mult1_E22[] and mult1_E44[] and mult1_E41[] and mult1_E42[] and mult1_E40[]} for 5
run{not surj_E26[] and surj_E24[] and surj_E25[] and surj_E22[] and xorsurj_E30_E29[] and surj_E23[] and surj_E28[] and surj_E27[] and xorsurj_E37_E31[] and mult1_E38[] and mult1_E39[] and mult1_E36[] and mult1_E37[] and surj_E32[] and mult1_E34[] and multi1_N0[] and mult1_E35[] and mult1_E32[] and mult1_E33[] and mult1_E30[] and mult1_E31[] and multi1_N15[] and surj_E35[] and surj_E36[] and nand_E32_E31[] and surj_E33[] and nand_E24_E30[] and surj_E34[] and surj_E39[] and surj_E38[] and mult1_E29[] and nand3_E35_E34_E36[] and mult1_E27[] and mult1_E28[] and mult1_E25[] and mult1_E26[] and mult1_E23[] and surj_E40[] and mult1_E24[] and mult1_E43[] and mult1_E22[] and mult1_E44[] and mult1_E41[] and mult1_E42[] and mult1_E40[]} for 5
run{not surj_E27[] and surj_E24[] and surj_E25[] and surj_E22[] and xorsurj_E30_E29[] and surj_E23[] and surj_E28[] and surj_E26[] and xorsurj_E37_E31[] and mult1_E38[] and mult1_E39[] and mult1_E36[] and mult1_E37[] and surj_E32[] and mult1_E34[] and multi1_N0[] and mult1_E35[] and mult1_E32[] and mult1_E33[] and mult1_E30[] and mult1_E31[] and multi1_N15[] and surj_E35[] and surj_E36[] and nand_E32_E31[] and surj_E33[] and nand_E24_E30[] and surj_E34[] and surj_E39[] and surj_E38[] and mult1_E29[] and nand3_E35_E34_E36[] and mult1_E27[] and mult1_E28[] and mult1_E25[] and mult1_E26[] and mult1_E23[] and surj_E40[] and mult1_E24[] and mult1_E43[] and mult1_E22[] and mult1_E44[] and mult1_E41[] and mult1_E42[] and mult1_E40[]} for 5
run{not xorsurj_E37_E31[] and surj_E24[] and surj_E25[] and surj_E22[] and xorsurj_E30_E29[] and surj_E23[] and surj_E28[] and surj_E26[] and surj_E27[] and mult1_E38[] and mult1_E39[] and mult1_E36[] and mult1_E37[] and surj_E32[] and mult1_E34[] and multi1_N0[] and mult1_E35[] and mult1_E32[] and mult1_E33[] and mult1_E30[] and mult1_E31[] and multi1_N15[] and surj_E35[] and surj_E36[] and nand_E32_E31[] and surj_E33[] and nand_E24_E30[] and surj_E34[] and surj_E39[] and surj_E38[] and mult1_E29[] and nand3_E35_E34_E36[] and mult1_E27[] and mult1_E28[] and mult1_E25[] and mult1_E26[] and mult1_E23[] and surj_E40[] and mult1_E24[] and mult1_E43[] and mult1_E22[] and mult1_E44[] and mult1_E41[] and mult1_E42[] and mult1_E40[]} for 5
run{not mult1_E38[] and surj_E24[] and surj_E25[] and surj_E22[] and xorsurj_E30_E29[] and surj_E23[] and surj_E28[] and surj_E26[] and surj_E27[] and xorsurj_E37_E31[] and mult1_E39[] and mult1_E36[] and mult1_E37[] and surj_E32[] and mult1_E34[] and multi1_N0[] and mult1_E35[] and mult1_E32[] and mult1_E33[] and mult1_E30[] and mult1_E31[] and multi1_N15[] and surj_E35[] and surj_E36[] and nand_E32_E31[] and surj_E33[] and nand_E24_E30[] and surj_E34[] and surj_E39[] and surj_E38[] and mult1_E29[] and nand3_E35_E34_E36[] and mult1_E27[] and mult1_E28[] and mult1_E25[] and mult1_E26[] and mult1_E23[] and surj_E40[] and mult1_E24[] and mult1_E43[] and mult1_E22[] and mult1_E44[] and mult1_E41[] and mult1_E42[] and mult1_E40[]} for 5
run{not mult1_E39[] and surj_E24[] and surj_E25[] and surj_E22[] and xorsurj_E30_E29[] and surj_E23[] and surj_E28[] and surj_E26[] and surj_E27[] and xorsurj_E37_E31[] and mult1_E38[] and mult1_E36[] and mult1_E37[] and surj_E32[] and mult1_E34[] and multi1_N0[] and mult1_E35[] and mult1_E32[] and mult1_E33[] and mult1_E30[] and mult1_E31[] and multi1_N15[] and surj_E35[] and surj_E36[] and nand_E32_E31[] and surj_E33[] and nand_E24_E30[] and surj_E34[] and surj_E39[] and surj_E38[] and mult1_E29[] and nand3_E35_E34_E36[] and mult1_E27[] and mult1_E28[] and mult1_E25[] and mult1_E26[] and mult1_E23[] and surj_E40[] and mult1_E24[] and mult1_E43[] and mult1_E22[] and mult1_E44[] and mult1_E41[] and mult1_E42[] and mult1_E40[]} for 5
run{not mult1_E36[] and surj_E24[] and surj_E25[] and surj_E22[] and xorsurj_E30_E29[] and surj_E23[] and surj_E28[] and surj_E26[] and surj_E27[] and xorsurj_E37_E31[] and mult1_E38[] and mult1_E39[] and mult1_E37[] and surj_E32[] and mult1_E34[] and multi1_N0[] and mult1_E35[] and mult1_E32[] and mult1_E33[] and mult1_E30[] and mult1_E31[] and multi1_N15[] and surj_E35[] and surj_E36[] and nand_E32_E31[] and surj_E33[] and nand_E24_E30[] and surj_E34[] and surj_E39[] and surj_E38[] and mult1_E29[] and nand3_E35_E34_E36[] and mult1_E27[] and mult1_E28[] and mult1_E25[] and mult1_E26[] and mult1_E23[] and surj_E40[] and mult1_E24[] and mult1_E43[] and mult1_E22[] and mult1_E44[] and mult1_E41[] and mult1_E42[] and mult1_E40[]} for 5
run{not mult1_E37[] and surj_E24[] and surj_E25[] and surj_E22[] and xorsurj_E30_E29[] and surj_E23[] and surj_E28[] and surj_E26[] and surj_E27[] and xorsurj_E37_E31[] and mult1_E38[] and mult1_E39[] and mult1_E36[] and surj_E32[] and mult1_E34[] and multi1_N0[] and mult1_E35[] and mult1_E32[] and mult1_E33[] and mult1_E30[] and mult1_E31[] and multi1_N15[] and surj_E35[] and surj_E36[] and nand_E32_E31[] and surj_E33[] and nand_E24_E30[] and surj_E34[] and surj_E39[] and surj_E38[] and mult1_E29[] and nand3_E35_E34_E36[] and mult1_E27[] and mult1_E28[] and mult1_E25[] and mult1_E26[] and mult1_E23[] and surj_E40[] and mult1_E24[] and mult1_E43[] and mult1_E22[] and mult1_E44[] and mult1_E41[] and mult1_E42[] and mult1_E40[]} for 5
run{not surj_E32[] and surj_E24[] and surj_E25[] and surj_E22[] and xorsurj_E30_E29[] and surj_E23[] and surj_E28[] and surj_E26[] and surj_E27[] and xorsurj_E37_E31[] and mult1_E38[] and mult1_E39[] and mult1_E36[] and mult1_E37[] and mult1_E34[] and multi1_N0[] and mult1_E35[] and mult1_E32[] and mult1_E33[] and mult1_E30[] and mult1_E31[] and multi1_N15[] and surj_E35[] and surj_E36[] and nand_E32_E31[] and surj_E33[] and nand_E24_E30[] and surj_E34[] and surj_E39[] and surj_E38[] and mult1_E29[] and nand3_E35_E34_E36[] and mult1_E27[] and mult1_E28[] and mult1_E25[] and mult1_E26[] and mult1_E23[] and surj_E40[] and mult1_E24[] and mult1_E43[] and mult1_E22[] and mult1_E44[] and mult1_E41[] and mult1_E42[] and mult1_E40[]} for 5
run{not mult1_E34[] and surj_E24[] and surj_E25[] and surj_E22[] and xorsurj_E30_E29[] and surj_E23[] and surj_E28[] and surj_E26[] and surj_E27[] and xorsurj_E37_E31[] and mult1_E38[] and mult1_E39[] and mult1_E36[] and mult1_E37[] and surj_E32[] and multi1_N0[] and mult1_E35[] and mult1_E32[] and mult1_E33[] and mult1_E30[] and mult1_E31[] and multi1_N15[] and surj_E35[] and surj_E36[] and nand_E32_E31[] and surj_E33[] and nand_E24_E30[] and surj_E34[] and surj_E39[] and surj_E38[] and mult1_E29[] and nand3_E35_E34_E36[] and mult1_E27[] and mult1_E28[] and mult1_E25[] and mult1_E26[] and mult1_E23[] and surj_E40[] and mult1_E24[] and mult1_E43[] and mult1_E22[] and mult1_E44[] and mult1_E41[] and mult1_E42[] and mult1_E40[]} for 5
run{not multi1_N0[] and surj_E24[] and surj_E25[] and surj_E22[] and xorsurj_E30_E29[] and surj_E23[] and surj_E28[] and surj_E26[] and surj_E27[] and xorsurj_E37_E31[] and mult1_E38[] and mult1_E39[] and mult1_E36[] and mult1_E37[] and surj_E32[] and mult1_E34[] and mult1_E35[] and mult1_E32[] and mult1_E33[] and mult1_E30[] and mult1_E31[] and multi1_N15[] and surj_E35[] and surj_E36[] and nand_E32_E31[] and surj_E33[] and nand_E24_E30[] and surj_E34[] and surj_E39[] and surj_E38[] and mult1_E29[] and nand3_E35_E34_E36[] and mult1_E27[] and mult1_E28[] and mult1_E25[] and mult1_E26[] and mult1_E23[] and surj_E40[] and mult1_E24[] and mult1_E43[] and mult1_E22[] and mult1_E44[] and mult1_E41[] and mult1_E42[] and mult1_E40[]} for 5
run{not mult1_E35[] and surj_E24[] and surj_E25[] and surj_E22[] and xorsurj_E30_E29[] and surj_E23[] and surj_E28[] and surj_E26[] and surj_E27[] and xorsurj_E37_E31[] and mult1_E38[] and mult1_E39[] and mult1_E36[] and mult1_E37[] and surj_E32[] and mult1_E34[] and multi1_N0[] and mult1_E32[] and mult1_E33[] and mult1_E30[] and mult1_E31[] and multi1_N15[] and surj_E35[] and surj_E36[] and nand_E32_E31[] and surj_E33[] and nand_E24_E30[] and surj_E34[] and surj_E39[] and surj_E38[] and mult1_E29[] and nand3_E35_E34_E36[] and mult1_E27[] and mult1_E28[] and mult1_E25[] and mult1_E26[] and mult1_E23[] and surj_E40[] and mult1_E24[] and mult1_E43[] and mult1_E22[] and mult1_E44[] and mult1_E41[] and mult1_E42[] and mult1_E40[]} for 5
run{not mult1_E32[] and surj_E24[] and surj_E25[] and surj_E22[] and xorsurj_E30_E29[] and surj_E23[] and surj_E28[] and surj_E26[] and surj_E27[] and xorsurj_E37_E31[] and mult1_E38[] and mult1_E39[] and mult1_E36[] and mult1_E37[] and surj_E32[] and mult1_E34[] and multi1_N0[] and mult1_E35[] and mult1_E33[] and mult1_E30[] and mult1_E31[] and multi1_N15[] and surj_E35[] and surj_E36[] and nand_E32_E31[] and surj_E33[] and nand_E24_E30[] and surj_E34[] and surj_E39[] and surj_E38[] and mult1_E29[] and nand3_E35_E34_E36[] and mult1_E27[] and mult1_E28[] and mult1_E25[] and mult1_E26[] and mult1_E23[] and surj_E40[] and mult1_E24[] and mult1_E43[] and mult1_E22[] and mult1_E44[] and mult1_E41[] and mult1_E42[] and mult1_E40[]} for 5
run{not mult1_E33[] and surj_E24[] and surj_E25[] and surj_E22[] and xorsurj_E30_E29[] and surj_E23[] and surj_E28[] and surj_E26[] and surj_E27[] and xorsurj_E37_E31[] and mult1_E38[] and mult1_E39[] and mult1_E36[] and mult1_E37[] and surj_E32[] and mult1_E34[] and multi1_N0[] and mult1_E35[] and mult1_E32[] and mult1_E30[] and mult1_E31[] and multi1_N15[] and surj_E35[] and surj_E36[] and nand_E32_E31[] and surj_E33[] and nand_E24_E30[] and surj_E34[] and surj_E39[] and surj_E38[] and mult1_E29[] and nand3_E35_E34_E36[] and mult1_E27[] and mult1_E28[] and mult1_E25[] and mult1_E26[] and mult1_E23[] and surj_E40[] and mult1_E24[] and mult1_E43[] and mult1_E22[] and mult1_E44[] and mult1_E41[] and mult1_E42[] and mult1_E40[]} for 5
run{not mult1_E30[] and surj_E24[] and surj_E25[] and surj_E22[] and xorsurj_E30_E29[] and surj_E23[] and surj_E28[] and surj_E26[] and surj_E27[] and xorsurj_E37_E31[] and mult1_E38[] and mult1_E39[] and mult1_E36[] and mult1_E37[] and surj_E32[] and mult1_E34[] and multi1_N0[] and mult1_E35[] and mult1_E32[] and mult1_E33[] and mult1_E31[] and multi1_N15[] and surj_E35[] and surj_E36[] and nand_E32_E31[] and surj_E33[] and nand_E24_E30[] and surj_E34[] and surj_E39[] and surj_E38[] and mult1_E29[] and nand3_E35_E34_E36[] and mult1_E27[] and mult1_E28[] and mult1_E25[] and mult1_E26[] and mult1_E23[] and surj_E40[] and mult1_E24[] and mult1_E43[] and mult1_E22[] and mult1_E44[] and mult1_E41[] and mult1_E42[] and mult1_E40[]} for 5
run{not mult1_E31[] and surj_E24[] and surj_E25[] and surj_E22[] and xorsurj_E30_E29[] and surj_E23[] and surj_E28[] and surj_E26[] and surj_E27[] and xorsurj_E37_E31[] and mult1_E38[] and mult1_E39[] and mult1_E36[] and mult1_E37[] and surj_E32[] and mult1_E34[] and multi1_N0[] and mult1_E35[] and mult1_E32[] and mult1_E33[] and mult1_E30[] and multi1_N15[] and surj_E35[] and surj_E36[] and nand_E32_E31[] and surj_E33[] and nand_E24_E30[] and surj_E34[] and surj_E39[] and surj_E38[] and mult1_E29[] and nand3_E35_E34_E36[] and mult1_E27[] and mult1_E28[] and mult1_E25[] and mult1_E26[] and mult1_E23[] and surj_E40[] and mult1_E24[] and mult1_E43[] and mult1_E22[] and mult1_E44[] and mult1_E41[] and mult1_E42[] and mult1_E40[]} for 5
run{not multi1_N15[] and surj_E24[] and surj_E25[] and surj_E22[] and xorsurj_E30_E29[] and surj_E23[] and surj_E28[] and surj_E26[] and surj_E27[] and xorsurj_E37_E31[] and mult1_E38[] and mult1_E39[] and mult1_E36[] and mult1_E37[] and surj_E32[] and mult1_E34[] and multi1_N0[] and mult1_E35[] and mult1_E32[] and mult1_E33[] and mult1_E30[] and mult1_E31[] and surj_E35[] and surj_E36[] and nand_E32_E31[] and surj_E33[] and nand_E24_E30[] and surj_E34[] and surj_E39[] and surj_E38[] and mult1_E29[] and nand3_E35_E34_E36[] and mult1_E27[] and mult1_E28[] and mult1_E25[] and mult1_E26[] and mult1_E23[] and surj_E40[] and mult1_E24[] and mult1_E43[] and mult1_E22[] and mult1_E44[] and mult1_E41[] and mult1_E42[] and mult1_E40[]} for 5
run{not surj_E35[] and surj_E24[] and surj_E25[] and surj_E22[] and xorsurj_E30_E29[] and surj_E23[] and surj_E28[] and surj_E26[] and surj_E27[] and xorsurj_E37_E31[] and mult1_E38[] and mult1_E39[] and mult1_E36[] and mult1_E37[] and surj_E32[] and mult1_E34[] and multi1_N0[] and mult1_E35[] and mult1_E32[] and mult1_E33[] and mult1_E30[] and mult1_E31[] and multi1_N15[] and surj_E36[] and nand_E32_E31[] and surj_E33[] and nand_E24_E30[] and surj_E34[] and surj_E39[] and surj_E38[] and mult1_E29[] and nand3_E35_E34_E36[] and mult1_E27[] and mult1_E28[] and mult1_E25[] and mult1_E26[] and mult1_E23[] and surj_E40[] and mult1_E24[] and mult1_E43[] and mult1_E22[] and mult1_E44[] and mult1_E41[] and mult1_E42[] and mult1_E40[]} for 5
run{not surj_E36[] and surj_E24[] and surj_E25[] and surj_E22[] and xorsurj_E30_E29[] and surj_E23[] and surj_E28[] and surj_E26[] and surj_E27[] and xorsurj_E37_E31[] and mult1_E38[] and mult1_E39[] and mult1_E36[] and mult1_E37[] and surj_E32[] and mult1_E34[] and multi1_N0[] and mult1_E35[] and mult1_E32[] and mult1_E33[] and mult1_E30[] and mult1_E31[] and multi1_N15[] and surj_E35[] and nand_E32_E31[] and surj_E33[] and nand_E24_E30[] and surj_E34[] and surj_E39[] and surj_E38[] and mult1_E29[] and nand3_E35_E34_E36[] and mult1_E27[] and mult1_E28[] and mult1_E25[] and mult1_E26[] and mult1_E23[] and surj_E40[] and mult1_E24[] and mult1_E43[] and mult1_E22[] and mult1_E44[] and mult1_E41[] and mult1_E42[] and mult1_E40[]} for 5
run{not nand_E32_E31[] and surj_E24[] and surj_E25[] and surj_E22[] and xorsurj_E30_E29[] and surj_E23[] and surj_E28[] and surj_E26[] and surj_E27[] and xorsurj_E37_E31[] and mult1_E38[] and mult1_E39[] and mult1_E36[] and mult1_E37[] and surj_E32[] and mult1_E34[] and multi1_N0[] and mult1_E35[] and mult1_E32[] and mult1_E33[] and mult1_E30[] and mult1_E31[] and multi1_N15[] and surj_E35[] and surj_E36[] and surj_E33[] and nand_E24_E30[] and surj_E34[] and surj_E39[] and surj_E38[] and mult1_E29[] and nand3_E35_E34_E36[] and mult1_E27[] and mult1_E28[] and mult1_E25[] and mult1_E26[] and mult1_E23[] and surj_E40[] and mult1_E24[] and mult1_E43[] and mult1_E22[] and mult1_E44[] and mult1_E41[] and mult1_E42[] and mult1_E40[]} for 5
run{not surj_E33[] and surj_E24[] and surj_E25[] and surj_E22[] and xorsurj_E30_E29[] and surj_E23[] and surj_E28[] and surj_E26[] and surj_E27[] and xorsurj_E37_E31[] and mult1_E38[] and mult1_E39[] and mult1_E36[] and mult1_E37[] and surj_E32[] and mult1_E34[] and multi1_N0[] and mult1_E35[] and mult1_E32[] and mult1_E33[] and mult1_E30[] and mult1_E31[] and multi1_N15[] and surj_E35[] and surj_E36[] and nand_E32_E31[] and nand_E24_E30[] and surj_E34[] and surj_E39[] and surj_E38[] and mult1_E29[] and nand3_E35_E34_E36[] and mult1_E27[] and mult1_E28[] and mult1_E25[] and mult1_E26[] and mult1_E23[] and surj_E40[] and mult1_E24[] and mult1_E43[] and mult1_E22[] and mult1_E44[] and mult1_E41[] and mult1_E42[] and mult1_E40[]} for 5
run{not nand_E24_E30[] and surj_E24[] and surj_E25[] and surj_E22[] and xorsurj_E30_E29[] and surj_E23[] and surj_E28[] and surj_E26[] and surj_E27[] and xorsurj_E37_E31[] and mult1_E38[] and mult1_E39[] and mult1_E36[] and mult1_E37[] and surj_E32[] and mult1_E34[] and multi1_N0[] and mult1_E35[] and mult1_E32[] and mult1_E33[] and mult1_E30[] and mult1_E31[] and multi1_N15[] and surj_E35[] and surj_E36[] and nand_E32_E31[] and surj_E33[] and surj_E34[] and surj_E39[] and surj_E38[] and mult1_E29[] and nand3_E35_E34_E36[] and mult1_E27[] and mult1_E28[] and mult1_E25[] and mult1_E26[] and mult1_E23[] and surj_E40[] and mult1_E24[] and mult1_E43[] and mult1_E22[] and mult1_E44[] and mult1_E41[] and mult1_E42[] and mult1_E40[]} for 5
run{not surj_E34[] and surj_E24[] and surj_E25[] and surj_E22[] and xorsurj_E30_E29[] and surj_E23[] and surj_E28[] and surj_E26[] and surj_E27[] and xorsurj_E37_E31[] and mult1_E38[] and mult1_E39[] and mult1_E36[] and mult1_E37[] and surj_E32[] and mult1_E34[] and multi1_N0[] and mult1_E35[] and mult1_E32[] and mult1_E33[] and mult1_E30[] and mult1_E31[] and multi1_N15[] and surj_E35[] and surj_E36[] and nand_E32_E31[] and surj_E33[] and nand_E24_E30[] and surj_E39[] and surj_E38[] and mult1_E29[] and nand3_E35_E34_E36[] and mult1_E27[] and mult1_E28[] and mult1_E25[] and mult1_E26[] and mult1_E23[] and surj_E40[] and mult1_E24[] and mult1_E43[] and mult1_E22[] and mult1_E44[] and mult1_E41[] and mult1_E42[] and mult1_E40[]} for 5
run{not surj_E39[] and surj_E24[] and surj_E25[] and surj_E22[] and xorsurj_E30_E29[] and surj_E23[] and surj_E28[] and surj_E26[] and surj_E27[] and xorsurj_E37_E31[] and mult1_E38[] and mult1_E39[] and mult1_E36[] and mult1_E37[] and surj_E32[] and mult1_E34[] and multi1_N0[] and mult1_E35[] and mult1_E32[] and mult1_E33[] and mult1_E30[] and mult1_E31[] and multi1_N15[] and surj_E35[] and surj_E36[] and nand_E32_E31[] and surj_E33[] and nand_E24_E30[] and surj_E34[] and surj_E38[] and mult1_E29[] and nand3_E35_E34_E36[] and mult1_E27[] and mult1_E28[] and mult1_E25[] and mult1_E26[] and mult1_E23[] and surj_E40[] and mult1_E24[] and mult1_E43[] and mult1_E22[] and mult1_E44[] and mult1_E41[] and mult1_E42[] and mult1_E40[]} for 5
run{not surj_E38[] and surj_E24[] and surj_E25[] and surj_E22[] and xorsurj_E30_E29[] and surj_E23[] and surj_E28[] and surj_E26[] and surj_E27[] and xorsurj_E37_E31[] and mult1_E38[] and mult1_E39[] and mult1_E36[] and mult1_E37[] and surj_E32[] and mult1_E34[] and multi1_N0[] and mult1_E35[] and mult1_E32[] and mult1_E33[] and mult1_E30[] and mult1_E31[] and multi1_N15[] and surj_E35[] and surj_E36[] and nand_E32_E31[] and surj_E33[] and nand_E24_E30[] and surj_E34[] and surj_E39[] and mult1_E29[] and nand3_E35_E34_E36[] and mult1_E27[] and mult1_E28[] and mult1_E25[] and mult1_E26[] and mult1_E23[] and surj_E40[] and mult1_E24[] and mult1_E43[] and mult1_E22[] and mult1_E44[] and mult1_E41[] and mult1_E42[] and mult1_E40[]} for 5
run{not mult1_E29[] and surj_E24[] and surj_E25[] and surj_E22[] and xorsurj_E30_E29[] and surj_E23[] and surj_E28[] and surj_E26[] and surj_E27[] and xorsurj_E37_E31[] and mult1_E38[] and mult1_E39[] and mult1_E36[] and mult1_E37[] and surj_E32[] and mult1_E34[] and multi1_N0[] and mult1_E35[] and mult1_E32[] and mult1_E33[] and mult1_E30[] and mult1_E31[] and multi1_N15[] and surj_E35[] and surj_E36[] and nand_E32_E31[] and surj_E33[] and nand_E24_E30[] and surj_E34[] and surj_E39[] and surj_E38[] and nand3_E35_E34_E36[] and mult1_E27[] and mult1_E28[] and mult1_E25[] and mult1_E26[] and mult1_E23[] and surj_E40[] and mult1_E24[] and mult1_E43[] and mult1_E22[] and mult1_E44[] and mult1_E41[] and mult1_E42[] and mult1_E40[]} for 5
run{not nand3_E35_E34_E36[] and surj_E24[] and surj_E25[] and surj_E22[] and xorsurj_E30_E29[] and surj_E23[] and surj_E28[] and surj_E26[] and surj_E27[] and xorsurj_E37_E31[] and mult1_E38[] and mult1_E39[] and mult1_E36[] and mult1_E37[] and surj_E32[] and mult1_E34[] and multi1_N0[] and mult1_E35[] and mult1_E32[] and mult1_E33[] and mult1_E30[] and mult1_E31[] and multi1_N15[] and surj_E35[] and surj_E36[] and nand_E32_E31[] and surj_E33[] and nand_E24_E30[] and surj_E34[] and surj_E39[] and surj_E38[] and mult1_E29[] and mult1_E27[] and mult1_E28[] and mult1_E25[] and mult1_E26[] and mult1_E23[] and surj_E40[] and mult1_E24[] and mult1_E43[] and mult1_E22[] and mult1_E44[] and mult1_E41[] and mult1_E42[] and mult1_E40[]} for 5
run{not mult1_E27[] and surj_E24[] and surj_E25[] and surj_E22[] and xorsurj_E30_E29[] and surj_E23[] and surj_E28[] and surj_E26[] and surj_E27[] and xorsurj_E37_E31[] and mult1_E38[] and mult1_E39[] and mult1_E36[] and mult1_E37[] and surj_E32[] and mult1_E34[] and multi1_N0[] and mult1_E35[] and mult1_E32[] and mult1_E33[] and mult1_E30[] and mult1_E31[] and multi1_N15[] and surj_E35[] and surj_E36[] and nand_E32_E31[] and surj_E33[] and nand_E24_E30[] and surj_E34[] and surj_E39[] and surj_E38[] and mult1_E29[] and nand3_E35_E34_E36[] and mult1_E28[] and mult1_E25[] and mult1_E26[] and mult1_E23[] and surj_E40[] and mult1_E24[] and mult1_E43[] and mult1_E22[] and mult1_E44[] and mult1_E41[] and mult1_E42[] and mult1_E40[]} for 5
run{not mult1_E28[] and surj_E24[] and surj_E25[] and surj_E22[] and xorsurj_E30_E29[] and surj_E23[] and surj_E28[] and surj_E26[] and surj_E27[] and xorsurj_E37_E31[] and mult1_E38[] and mult1_E39[] and mult1_E36[] and mult1_E37[] and surj_E32[] and mult1_E34[] and multi1_N0[] and mult1_E35[] and mult1_E32[] and mult1_E33[] and mult1_E30[] and mult1_E31[] and multi1_N15[] and surj_E35[] and surj_E36[] and nand_E32_E31[] and surj_E33[] and nand_E24_E30[] and surj_E34[] and surj_E39[] and surj_E38[] and mult1_E29[] and nand3_E35_E34_E36[] and mult1_E27[] and mult1_E25[] and mult1_E26[] and mult1_E23[] and surj_E40[] and mult1_E24[] and mult1_E43[] and mult1_E22[] and mult1_E44[] and mult1_E41[] and mult1_E42[] and mult1_E40[]} for 5
run{not mult1_E25[] and surj_E24[] and surj_E25[] and surj_E22[] and xorsurj_E30_E29[] and surj_E23[] and surj_E28[] and surj_E26[] and surj_E27[] and xorsurj_E37_E31[] and mult1_E38[] and mult1_E39[] and mult1_E36[] and mult1_E37[] and surj_E32[] and mult1_E34[] and multi1_N0[] and mult1_E35[] and mult1_E32[] and mult1_E33[] and mult1_E30[] and mult1_E31[] and multi1_N15[] and surj_E35[] and surj_E36[] and nand_E32_E31[] and surj_E33[] and nand_E24_E30[] and surj_E34[] and surj_E39[] and surj_E38[] and mult1_E29[] and nand3_E35_E34_E36[] and mult1_E27[] and mult1_E28[] and mult1_E26[] and mult1_E23[] and surj_E40[] and mult1_E24[] and mult1_E43[] and mult1_E22[] and mult1_E44[] and mult1_E41[] and mult1_E42[] and mult1_E40[]} for 5
run{not mult1_E26[] and surj_E24[] and surj_E25[] and surj_E22[] and xorsurj_E30_E29[] and surj_E23[] and surj_E28[] and surj_E26[] and surj_E27[] and xorsurj_E37_E31[] and mult1_E38[] and mult1_E39[] and mult1_E36[] and mult1_E37[] and surj_E32[] and mult1_E34[] and multi1_N0[] and mult1_E35[] and mult1_E32[] and mult1_E33[] and mult1_E30[] and mult1_E31[] and multi1_N15[] and surj_E35[] and surj_E36[] and nand_E32_E31[] and surj_E33[] and nand_E24_E30[] and surj_E34[] and surj_E39[] and surj_E38[] and mult1_E29[] and nand3_E35_E34_E36[] and mult1_E27[] and mult1_E28[] and mult1_E25[] and mult1_E23[] and surj_E40[] and mult1_E24[] and mult1_E43[] and mult1_E22[] and mult1_E44[] and mult1_E41[] and mult1_E42[] and mult1_E40[]} for 5
run{not mult1_E23[] and surj_E24[] and surj_E25[] and surj_E22[] and xorsurj_E30_E29[] and surj_E23[] and surj_E28[] and surj_E26[] and surj_E27[] and xorsurj_E37_E31[] and mult1_E38[] and mult1_E39[] and mult1_E36[] and mult1_E37[] and surj_E32[] and mult1_E34[] and multi1_N0[] and mult1_E35[] and mult1_E32[] and mult1_E33[] and mult1_E30[] and mult1_E31[] and multi1_N15[] and surj_E35[] and surj_E36[] and nand_E32_E31[] and surj_E33[] and nand_E24_E30[] and surj_E34[] and surj_E39[] and surj_E38[] and mult1_E29[] and nand3_E35_E34_E36[] and mult1_E27[] and mult1_E28[] and mult1_E25[] and mult1_E26[] and surj_E40[] and mult1_E24[] and mult1_E43[] and mult1_E22[] and mult1_E44[] and mult1_E41[] and mult1_E42[] and mult1_E40[]} for 5
run{not surj_E40[] and surj_E24[] and surj_E25[] and surj_E22[] and xorsurj_E30_E29[] and surj_E23[] and surj_E28[] and surj_E26[] and surj_E27[] and xorsurj_E37_E31[] and mult1_E38[] and mult1_E39[] and mult1_E36[] and mult1_E37[] and surj_E32[] and mult1_E34[] and multi1_N0[] and mult1_E35[] and mult1_E32[] and mult1_E33[] and mult1_E30[] and mult1_E31[] and multi1_N15[] and surj_E35[] and surj_E36[] and nand_E32_E31[] and surj_E33[] and nand_E24_E30[] and surj_E34[] and surj_E39[] and surj_E38[] and mult1_E29[] and nand3_E35_E34_E36[] and mult1_E27[] and mult1_E28[] and mult1_E25[] and mult1_E26[] and mult1_E23[] and mult1_E24[] and mult1_E43[] and mult1_E22[] and mult1_E44[] and mult1_E41[] and mult1_E42[] and mult1_E40[]} for 5
run{not mult1_E24[] and surj_E24[] and surj_E25[] and surj_E22[] and xorsurj_E30_E29[] and surj_E23[] and surj_E28[] and surj_E26[] and surj_E27[] and xorsurj_E37_E31[] and mult1_E38[] and mult1_E39[] and mult1_E36[] and mult1_E37[] and surj_E32[] and mult1_E34[] and multi1_N0[] and mult1_E35[] and mult1_E32[] and mult1_E33[] and mult1_E30[] and mult1_E31[] and multi1_N15[] and surj_E35[] and surj_E36[] and nand_E32_E31[] and surj_E33[] and nand_E24_E30[] and surj_E34[] and surj_E39[] and surj_E38[] and mult1_E29[] and nand3_E35_E34_E36[] and mult1_E27[] and mult1_E28[] and mult1_E25[] and mult1_E26[] and mult1_E23[] and surj_E40[] and mult1_E43[] and mult1_E22[] and mult1_E44[] and mult1_E41[] and mult1_E42[] and mult1_E40[]} for 5
run{not mult1_E43[] and surj_E24[] and surj_E25[] and surj_E22[] and xorsurj_E30_E29[] and surj_E23[] and surj_E28[] and surj_E26[] and surj_E27[] and xorsurj_E37_E31[] and mult1_E38[] and mult1_E39[] and mult1_E36[] and mult1_E37[] and surj_E32[] and mult1_E34[] and multi1_N0[] and mult1_E35[] and mult1_E32[] and mult1_E33[] and mult1_E30[] and mult1_E31[] and multi1_N15[] and surj_E35[] and surj_E36[] and nand_E32_E31[] and surj_E33[] and nand_E24_E30[] and surj_E34[] and surj_E39[] and surj_E38[] and mult1_E29[] and nand3_E35_E34_E36[] and mult1_E27[] and mult1_E28[] and mult1_E25[] and mult1_E26[] and mult1_E23[] and surj_E40[] and mult1_E24[] and mult1_E22[] and mult1_E44[] and mult1_E41[] and mult1_E42[] and mult1_E40[]} for 5
run{not mult1_E22[] and surj_E24[] and surj_E25[] and surj_E22[] and xorsurj_E30_E29[] and surj_E23[] and surj_E28[] and surj_E26[] and surj_E27[] and xorsurj_E37_E31[] and mult1_E38[] and mult1_E39[] and mult1_E36[] and mult1_E37[] and surj_E32[] and mult1_E34[] and multi1_N0[] and mult1_E35[] and mult1_E32[] and mult1_E33[] and mult1_E30[] and mult1_E31[] and multi1_N15[] and surj_E35[] and surj_E36[] and nand_E32_E31[] and surj_E33[] and nand_E24_E30[] and surj_E34[] and surj_E39[] and surj_E38[] and mult1_E29[] and nand3_E35_E34_E36[] and mult1_E27[] and mult1_E28[] and mult1_E25[] and mult1_E26[] and mult1_E23[] and surj_E40[] and mult1_E24[] and mult1_E43[] and mult1_E44[] and mult1_E41[] and mult1_E42[] and mult1_E40[]} for 5
run{not mult1_E44[] and surj_E24[] and surj_E25[] and surj_E22[] and xorsurj_E30_E29[] and surj_E23[] and surj_E28[] and surj_E26[] and surj_E27[] and xorsurj_E37_E31[] and mult1_E38[] and mult1_E39[] and mult1_E36[] and mult1_E37[] and surj_E32[] and mult1_E34[] and multi1_N0[] and mult1_E35[] and mult1_E32[] and mult1_E33[] and mult1_E30[] and mult1_E31[] and multi1_N15[] and surj_E35[] and surj_E36[] and nand_E32_E31[] and surj_E33[] and nand_E24_E30[] and surj_E34[] and surj_E39[] and surj_E38[] and mult1_E29[] and nand3_E35_E34_E36[] and mult1_E27[] and mult1_E28[] and mult1_E25[] and mult1_E26[] and mult1_E23[] and surj_E40[] and mult1_E24[] and mult1_E43[] and mult1_E22[] and mult1_E41[] and mult1_E42[] and mult1_E40[]} for 5
run{not mult1_E41[] and surj_E24[] and surj_E25[] and surj_E22[] and xorsurj_E30_E29[] and surj_E23[] and surj_E28[] and surj_E26[] and surj_E27[] and xorsurj_E37_E31[] and mult1_E38[] and mult1_E39[] and mult1_E36[] and mult1_E37[] and surj_E32[] and mult1_E34[] and multi1_N0[] and mult1_E35[] and mult1_E32[] and mult1_E33[] and mult1_E30[] and mult1_E31[] and multi1_N15[] and surj_E35[] and surj_E36[] and nand_E32_E31[] and surj_E33[] and nand_E24_E30[] and surj_E34[] and surj_E39[] and surj_E38[] and mult1_E29[] and nand3_E35_E34_E36[] and mult1_E27[] and mult1_E28[] and mult1_E25[] and mult1_E26[] and mult1_E23[] and surj_E40[] and mult1_E24[] and mult1_E43[] and mult1_E22[] and mult1_E44[] and mult1_E42[] and mult1_E40[]} for 5
run{not mult1_E42[] and surj_E24[] and surj_E25[] and surj_E22[] and xorsurj_E30_E29[] and surj_E23[] and surj_E28[] and surj_E26[] and surj_E27[] and xorsurj_E37_E31[] and mult1_E38[] and mult1_E39[] and mult1_E36[] and mult1_E37[] and surj_E32[] and mult1_E34[] and multi1_N0[] and mult1_E35[] and mult1_E32[] and mult1_E33[] and mult1_E30[] and mult1_E31[] and multi1_N15[] and surj_E35[] and surj_E36[] and nand_E32_E31[] and surj_E33[] and nand_E24_E30[] and surj_E34[] and surj_E39[] and surj_E38[] and mult1_E29[] and nand3_E35_E34_E36[] and mult1_E27[] and mult1_E28[] and mult1_E25[] and mult1_E26[] and mult1_E23[] and surj_E40[] and mult1_E24[] and mult1_E43[] and mult1_E22[] and mult1_E44[] and mult1_E41[] and mult1_E40[]} for 5
run{not mult1_E40[] and surj_E24[] and surj_E25[] and surj_E22[] and xorsurj_E30_E29[] and surj_E23[] and surj_E28[] and surj_E26[] and surj_E27[] and xorsurj_E37_E31[] and mult1_E38[] and mult1_E39[] and mult1_E36[] and mult1_E37[] and surj_E32[] and mult1_E34[] and multi1_N0[] and mult1_E35[] and mult1_E32[] and mult1_E33[] and mult1_E30[] and mult1_E31[] and multi1_N15[] and surj_E35[] and surj_E36[] and nand_E32_E31[] and surj_E33[] and nand_E24_E30[] and surj_E34[] and surj_E39[] and surj_E38[] and mult1_E29[] and nand3_E35_E34_E36[] and mult1_E27[] and mult1_E28[] and mult1_E25[] and mult1_E26[] and mult1_E23[] and surj_E40[] and mult1_E24[] and mult1_E43[] and mult1_E22[] and mult1_E44[] and mult1_E41[] and mult1_E42[]} for 5
