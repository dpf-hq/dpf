//Signatures for nodes
sig N16{} // for Scann Patient Wristband
sig N7{} // for Identify nurse, log transfusion
sig N23{} // for Select Department
sig N29{} // for Store Patient condition
sig N10{} // for Select Blod Typeing
sig N20{} // for Collect Sample
sig N13{} // for Get Nurse Info
sig N2{} // for Send Sample Order
sig N19{} // for PrintTag
sig N32{} // for Put Blood Into refrigertor
sig N31{} // for Store Transfusion
sig N17{} // for Scan Sample
sig N0{} // for Scan Patient Wristband
sig N28{} // for Stop Transfusion, Contact AIT
sig N27{} // for Verify Blood Product
sig N1{} // for Select Book pre-examination
sig N9{} // for Show Nurse Info
sig N6{} // for perform transfusion
sig N15{} // for Get Sample
sig N24{} // for Send Blood Order
sig N26{} // for Scan Blood Product
sig N33{} // for Blood distribution
sig N8{} // for Scan Nurse Card
sig N11{} // for Show Patient Info
sig N30{} // for Register Reaction
sig N21{} // for Select Blood Product
sig N18{} // for Get Patient
sig N4{} // for Collect Blood
sig N22{} // for Get Doctor Info
sig N5{} // for Measure temperature, blood pressure and pulse
sig N14{} // for Get Patient Info
sig N3{} // for Order Blood
sig N12{} // for Order Sample
sig N25{} // for Send Sample

//Signatures for edges
sig E37{src:one N6, trg:one N7} // for :perform transfusion->Identify nurse, log transfusion
sig E46{src:one N14, trg:one N0} // for Patient is not found:Get Patient Info->Scan Patient Wristband
sig E68{src:one N11, trg:one N3} // for :Show Patient Info->Order Blood
sig E43{src:one N13, trg:one N8} // for Nurse is not found:Get Nurse Info->Scan Nurse Card
sig E71{src:one N4, trg:one N32} // for out time less then 0.5h:Collect Blood->Put Blood Into refrigertor
sig E36{src:one N5, trg:one N6} // for :Measure temperature, blood pressure and pulse->perform transfusion
sig E51{src:one N2, trg:one N3} // for Blood have not been ordered:Send Sample Order->Order Blood
sig E65{src:one N5, trg:one N29} // for (Patient{temp, pressure_high, pressure_low, pulse}):Measure temperature, blood pressure and pulse->Store Patient condition
sig E61{src:one N25, trg:one N3} // for Blood have not been ordered:Send Sample->Order Blood
sig E58{src:one N23, trg:one N24} // for (Department):Select Department->Send Blood Order
sig E44{src:one N0, trg:one N14} // for (Barcode):Scan Patient Wristband->Get Patient Info
sig E35{src:one N1, trg:one N2} // for :Select Book pre-examination->Send Sample Order
sig E57{src:one N22, trg:one N23} // for (Doctor):Get Doctor Info->Select Department
sig E72{src:one N32, trg:one N26} // for out time less than 4h:Put Blood Into refrigertor->Scan Blood Product
sig E73{src:one N24, trg:one N33} // for (BloodOrder{quantity, expectTime}):Send Blood Order->Blood distribution
sig E75{src:one N25, trg:one N4} // for :Send Sample->Collect Blood
sig E50{src:one N18, trg:one N25} // for (Patient):Get Patient->Send Sample
sig E66{src:one N6, trg:one N26} // for More blood:perform transfusion->Scan Blood Product
sig E52{src:one N2, trg:one N19} // for :Send Sample Order->PrintTag
sig E56{src:one N21, trg:one N22} // for (Barcode):Select Blood Product->Get Doctor Info
sig E63{src:one N27, trg:one N28} // for The blood Product is not for the patient:Verify Blood Product->Stop Transfusion, Contact AIT
sig E41{src:one N10, trg:one N2} // for :Select Blod Typeing->Send Sample Order
sig E74{src:one N33, trg:one N4} // for (Blood*):Blood distribution->Collect Blood
sig E40{src:one N12, trg:one N10} // for Patient has not been bloodtyped:Order Sample->Select Blod Typeing
sig E48{src:one N17, trg:one N15} // for (Barcode):Scan Sample->Get Sample
sig E49{src:one N16, trg:one N18} // for (Barcode):Scann Patient Wristband->Get Patient
sig E45{src:one N14, trg:one N11} // for (Patient{name, ID, gender, blodtype, screening}):Get Patient Info->Show Patient Info
sig E59{src:one N24, trg:one N17} // for Samples have not been sent:Send Blood Order->Scan Sample
sig E70{src:one N7, trg:one N31} // for (Transfusion, Nurse):Identify nurse, log transfusion->Store Transfusion
sig E55{src:one N3, trg:one N21} // for :Order Blood->Select Blood Product
sig E38{src:one N4, trg:one N26} // for out time less than 4h:Collect Blood->Scan Blood Product
sig E76{src:one N11, trg:one N12} // for bloodtype is unknown or screening is not done or invalid(screen is valid within 4 days):Show Patient Info->Order Sample
sig E67{src:one N8, trg:one N13} // for (Barcode):Scan Nurse Card->Get Nurse Info
sig E54{src:one N20, trg:one N17} // for :Collect Sample->Scan Sample
sig E64{src:one N27, trg:one N5} // for The blood is for the patient:Verify Blood Product->Measure temperature, blood pressure and pulse
sig E60{src:one N18, trg:one N17} // for Sample is not for the patient:Get Patient->Scan Sample
sig E39{src:one N9, trg:one N0} // for :Show Nurse Info->Scan Patient Wristband
sig E69{src:one N6, trg:one N30} // for (Reaction{type}):perform transfusion->Register Reaction
sig E53{src:one N19, trg:one N20} // for :PrintTag->Collect Sample
sig E34{src:one N12, trg:one N1} // for :Order Sample->Select Book pre-examination
sig E47{src:one N15, trg:one N16} // for (Sample):Get Sample->Scann Patient Wristband
sig E42{src:one N13, trg:one N9} // for (Nurse{name}):Get Nurse Info->Show Nurse Info
sig E62{src:one N26, trg:one N27} // for (Barcode,  Patient):Scan Blood Product->Verify Blood Product

//facts
fact iff2_E76_E75{
	all y1:N4, y2:N12 | let e1 = (some e : E75 | e.trg = y1), 
e2 = (some e : E76 | e.trg = y2)|
 e1 iff e2
}

fact surj_E47{
	//surjective on (Sample):Get Sample->Scann Patient Wristband
	all n:(N16)| some e:(E47)| e.trg = n
}

fact surj_E44{
	//surjective on (Barcode):Scan Patient Wristband->Get Patient Info
	all n:(N14)| some e:(E44)| e.trg = n
}

fact surj_E45{
	//surjective on (Patient{name, ID, gender, blodtype, screening}):Get Patient Info->Show Patient Info
	all n:(N11)| some e:(E45)| e.trg = n
}

fact surj_E48{
	//surjective on (Barcode):Scan Sample->Get Sample
	all n:(N15)| some e:(E48)| e.trg = n
}

fact surj_E49{
	//surjective on (Barcode):Scann Patient Wristband->Get Patient
	all n:(N18)| some e:(E49)| e.trg = n
}

fact iff_E40_E41{
	all y:N10 | (some yz:E41| yz.src=y) iff (some xy:E40| xy.trg = y)
}

fact surj_E50{
	//surjective on (Patient):Get Patient->Send Sample
	all n:(N25)| some e:(E50)| e.trg = n
}

fact surj_E53{
	//surjective on :PrintTag->Collect Sample
	all n:(N20)| some e:(E53)| e.trg = n
}

fact surj_E52{
	//surjective on :Send Sample Order->PrintTag
	all n:(N19)| some e:(E52)| e.trg = n
}

fact surj_E35{
	//surjective on :Select Book pre-examination->Send Sample Order
	all n:(N2)| some e:(E35)| e.trg = n
}

fact surj_E36{
	//surjective on :Measure temperature, blood pressure and pulse->perform transfusion
	all n:(N6)| some e:(E36)| e.trg = n
}

fact xor_E76_E68{
	//XOR constraint between bloodtype is unknown or screening is not done or invalid(screen is valid within 4 days):Show Patient Info->Order Sample and :Show Patient Info->Order Blood
	all n:(N11) | let e1 = (some e : E76 | e.src = n), e2=(some e : E68 | e.src = n)|(e1 or e2) and not(e1 and e2)
}

fact surj_E34{
	//surjective on :Order Sample->Select Book pre-examination
	all n:(N1)| some e:(E34)| e.trg = n
}

fact surj_E39{
	//surjective on :Show Nurse Info->Scan Patient Wristband
	all n:(N0)| some e:(E39)| e.trg = n
}

fact surj_E37{
	//surjective on :perform transfusion->Identify nurse, log transfusion
	all n:(N7)| some e:(E37)| e.trg = n
}

fact surj_E42{
	//surjective on (Nurse{name}):Get Nurse Info->Show Nurse Info
	all n:(N9)| some e:(E42)| e.trg = n
}

fact imply2_E61_E76{
	all y1:N3, y2:N12 | let e1 = (some e : E61 | e.trg = y1), 
e2 = (some e : E76 | e.trg = y2)|
 e1 implies e2
}

fact surj_E40{
	//surjective on Patient has not been bloodtyped:Order Sample->Select Blod Typeing
	all n:(N10)| some e:(E40)| e.trg = n
}

fact xor3_E66_E37_E69{
	all x:N6 | let e1 = (some e : E69 | e.src = x), 
e2 = (some e : E37 | e.src = x), 
e3 = (some e : E66 | e.src = x)|
not (e1 and e2) and not (e1 and e3) and not (e2 and e3) and (e1 or e2 or e3)
}

fact xorsurj_E46_E39{
	all z:N0 | let e1 = (some e : E39 | e.trg = z), 
e2 = (some e : E46 | e.trg = z)|
(e1 or e2) and not (e1 and e2)
}

fact xor3surj_E38_E66_E72{
	all x:N26 | let e1 = (some e : E72 | e.trg = x), 
e2 = (some e : E66 | e.trg = x), 
e3 = (some e : E38 | e.trg = x)|
not (e1 and e2) and not (e1 and e3) and not (e2 and e3) and (e1 or e2 or e3)
}

fact mult1_E76{
	//mulitplicity on bloodtype is unknown or screening is not done or invalid(screen is valid within 4 days):Show Patient Info->Order Sample[0,1]
	all n:(N11)|lone e:(E76)|e.src=n
}

fact mult1_E74{
	//mulitplicity on (Blood*):Blood distribution->Collect Blood[0,1]
	all n:(N33)|lone e:(E74)|e.src=n
}

fact mult1_E75{
	//mulitplicity on :Send Sample->Collect Blood[0,1]
	all n:(N25)|lone e:(E75)|e.src=n
}

fact mult1_E72{
	//mulitplicity on out time less than 4h:Put Blood Into refrigertor->Scan Blood Product[0,1]
	all n:(N32)|lone e:(E72)|e.src=n
}

fact mult1_E73{
	//mulitplicity on (BloodOrder{quantity, expectTime}):Send Blood Order->Blood distribution[0,1]
	all n:(N24)|lone e:(E73)|e.src=n
}

fact mult1_E70{
	//mulitplicity on (Transfusion, Nurse):Identify nurse, log transfusion->Store Transfusion[0,1]
	all n:(N7)|lone e:(E70)|e.src=n
}

fact mult1_E71{
	//mulitplicity on out time less then 0.5h:Collect Blood->Put Blood Into refrigertor[0,1]
	all n:(N4)|lone e:(E71)|e.src=n
}

fact xor3surj_E51_E61_E68{
	all x:N3 | let e1 = (some e : E68 | e.trg = x), 
e2 = (some e : E61 | e.trg = x), 
e3 = (some e : E51 | e.trg = x)|
not (e1 and e2) and not (e1 and e3) and not (e2 and e3) and (e1 or e2 or e3)
}

fact special_E38_E72{
	some N26 implies ((some z:N26|some xz:E38|xz.trg=z) or (some z:N26|some yz:E72|yz.trg=z))
}

fact multi1_N31{
	//mulitplicity on Store Transfusion min:1;max:1
	let count = #N31 | count>=1 and count <=1}

fact imply_E54_E59{
	all x:N17 | let e1 = (some e : E59 | e.trg = x), 
e2 = (some e : E54 | e.trg = x)|
 not e1 or e2
}

fact mult1_E69{
	//mulitplicity on (Reaction{type}):perform transfusion->Register Reaction[0,1]
	all n:(N6)|lone e:(E69)|e.src=n
}

fact mult1_E67{
	//mulitplicity on (Barcode):Scan Nurse Card->Get Nurse Info[0,1]
	all n:(N8)|lone e:(E67)|e.src=n
}

fact mult1_E68{
	//mulitplicity on :Show Patient Info->Order Blood[0,1]
	all n:(N11)|lone e:(E68)|e.src=n
}

fact mult1_E65{
	//mulitplicity on (Patient{temp, pressure_high, pressure_low, pulse}):Measure temperature, blood pressure and pulse->Store Patient condition[0,1]
	all n:(N5)|lone e:(E65)|e.src=n
}

fact mult1_E66{
	//mulitplicity on More blood:perform transfusion->Scan Blood Product[0,1]
	all n:(N6)|lone e:(E66)|e.src=n
}

fact mult1_E63{
	//mulitplicity on The blood Product is not for the patient:Verify Blood Product->Stop Transfusion, Contact AIT[0,1]
	all n:(N27)|lone e:(E63)|e.src=n
}

fact mult1_E64{
	//mulitplicity on The blood is for the patient:Verify Blood Product->Measure temperature, blood pressure and pulse[0,1]
	all n:(N27)|lone e:(E64)|e.src=n
}

fact mult1_E61{
	//mulitplicity on Blood have not been ordered:Send Sample->Order Blood[0,1]
	all n:(N25)|lone e:(E61)|e.src=n
}

fact mult1_E62{
	//mulitplicity on (Barcode,  Patient):Scan Blood Product->Verify Blood Product[0,1]
	all n:(N26)|lone e:(E62)|e.src=n
}

fact mult1_E60{
	//mulitplicity on Sample is not for the patient:Get Patient->Scan Sample[0,1]
	all n:(N18)|lone e:(E60)|e.src=n
}

fact multi1_N24{
	//mulitplicity on Send Blood Order min:2;max:2
	let count = #N24 | count>=2 and count <=2}

fact iff_E71_E72{
	all y:N32 | (some yz:E72| yz.src=y) iff (some xy:E71| xy.trg = y)
}

fact multi1_N26{
	//mulitplicity on Scan Blood Product min:0;max:1
	let count = #N26 | count>=0 and count <=1}

fact xor_E59_E73{
	//XOR constraint between Samples have not been sent:Send Blood Order->Scan Sample and (BloodOrder{quantity, expectTime}):Send Blood Order->Blood distribution
	all n:(N24) | let e1 = (some e : E59 | e.src = n), e2=(some e : E73 | e.src = n)|(e1 or e2) and not(e1 and e2)
}

fact mult1_E58{
	//mulitplicity on (Department):Select Department->Send Blood Order[0,1]
	all n:(N23)|lone e:(E58)|e.src=n
}

fact xorsurj_E60_E54{
	all z:N17 | let e1 = (some e : E54 | e.trg = z), 
e2 = (some e : E60 | e.trg = z)|
(e1 or e2) and not (e1 and e2)
}

fact xor_E75_E61{
	//XOR constraint between :Send Sample->Collect Blood and Blood have not been ordered:Send Sample->Order Blood
	all n:(N25) | let e1 = (some e : E75 | e.src = n), e2=(some e : E61 | e.src = n)|(e1 or e2) and not(e1 and e2)
}

fact mult1_E59{
	//mulitplicity on Samples have not been sent:Send Blood Order->Scan Sample[0,1]
	all n:(N24)|lone e:(E59)|e.src=n
}

fact mult1_E56{
	//mulitplicity on (Barcode):Select Blood Product->Get Doctor Info[0,1]
	all n:(N21)|lone e:(E56)|e.src=n
}

fact mult1_E57{
	//mulitplicity on (Doctor):Get Doctor Info->Select Department[0,1]
	all n:(N22)|lone e:(E57)|e.src=n
}

fact mult1_E54{
	//mulitplicity on :Collect Sample->Scan Sample[0,1]
	all n:(N20)|lone e:(E54)|e.src=n
}

fact mult1_E55{
	//mulitplicity on :Order Blood->Select Blood Product[0,1]
	all n:(N3)|lone e:(E55)|e.src=n
}

fact mult1_E52{
	//mulitplicity on :Send Sample Order->PrintTag[0,1]
	all n:(N2)|lone e:(E52)|e.src=n
}

fact nand1_E59_E60{
	//NAND constraint between Sample is not for the patient:Get Patient->Scan Sample and Samples have not been sent:Send Blood Order->Scan Sample
	all n:(N17) | let e1 = (some e : E60 | e.trg = n), e2=(some e : E59 | e.trg = n)|not(e1 and e2)
}

fact mult1_E53{
	//mulitplicity on :PrintTag->Collect Sample[0,1]
	all n:(N19)|lone e:(E53)|e.src=n
}

fact mult1_E50{
	//mulitplicity on (Patient):Get Patient->Send Sample[0,1]
	all n:(N18)|lone e:(E50)|e.src=n
}

fact mult1_E51{
	//mulitplicity on Blood have not been ordered:Send Sample Order->Order Blood[0,1]
	all n:(N2)|lone e:(E51)|e.src=n
}

fact xor_E63_E64{
	//XOR constraint between The blood Product is not for the patient:Verify Blood Product->Stop Transfusion, Contact AIT and The blood is for the patient:Verify Blood Product->Measure temperature, blood pressure and pulse
	all n:(N27) | let e1 = (some e : E63 | e.src = n), e2=(some e : E64 | e.src = n)|(e1 or e2) and not(e1 and e2)
}

fact mult1_E49{
	//mulitplicity on (Barcode):Scann Patient Wristband->Get Patient[0,1]
	all n:(N16)|lone e:(E49)|e.src=n
}

fact mult1_E47{
	//mulitplicity on (Sample):Get Sample->Scann Patient Wristband[0,1]
	all n:(N15)|lone e:(E47)|e.src=n
}

fact mult1_E48{
	//mulitplicity on (Barcode):Scan Sample->Get Sample[0,1]
	all n:(N17)|lone e:(E48)|e.src=n
}

fact mult1_E45{
	//mulitplicity on (Patient{name, ID, gender, blodtype, screening}):Get Patient Info->Show Patient Info[0,1]
	all n:(N14)|lone e:(E45)|e.src=n
}

fact mult1_E46{
	//mulitplicity on Patient is not found:Get Patient Info->Scan Patient Wristband[0,1]
	all n:(N14)|lone e:(E46)|e.src=n
}

fact mult1_E43{
	//mulitplicity on Nurse is not found:Get Nurse Info->Scan Nurse Card[0,1]
	all n:(N13)|lone e:(E43)|e.src=n
}

fact mult1_E44{
	//mulitplicity on (Barcode):Scan Patient Wristband->Get Patient Info[0,1]
	all n:(N0)|lone e:(E44)|e.src=n
}

fact mult1_E41{
	//mulitplicity on :Select Blod Typeing->Send Sample Order[0,1]
	all n:(N10)|lone e:(E41)|e.src=n
}

fact mult1_E42{
	//mulitplicity on (Nurse{name}):Get Nurse Info->Show Nurse Info[0,1]
	all n:(N13)|lone e:(E42)|e.src=n
}

fact mult1_E40{
	//mulitplicity on Patient has not been bloodtyped:Order Sample->Select Blod Typeing[0,1]
	all n:(N12)|lone e:(E40)|e.src=n
}

fact xor_E43_E42{
	//XOR constraint between Nurse is not found:Get Nurse Info->Scan Nurse Card and (Nurse{name}):Get Nurse Info->Show Nurse Info
	all n:(N13) | let e1 = (some e : E43 | e.src = n), e2=(some e : E42 | e.src = n)|(e1 or e2) and not(e1 and e2)
}

fact surj_E69{
	//surjective on (Reaction{type}):perform transfusion->Register Reaction
	all n:(N30)| some e:(E69)| e.trg = n
}

fact surj_E67{
	//surjective on (Barcode):Scan Nurse Card->Get Nurse Info
	all n:(N13)| some e:(E67)| e.trg = n
}

fact multi1_N8{
	//mulitplicity on Scan Nurse Card min:1;max:1
	let count = #N8 | count>=1 and count <=1}

fact surj_E71{
	//surjective on out time less then 0.5h:Collect Blood->Put Blood Into refrigertor
	all n:(N32)| some e:(E71)| e.trg = n
}

fact mult1_E38{
	//mulitplicity on out time less than 4h:Collect Blood->Scan Blood Product[0,1]
	all n:(N4)|lone e:(E38)|e.src=n
}

fact mult1_E39{
	//mulitplicity on :Show Nurse Info->Scan Patient Wristband[0,1]
	all n:(N9)|lone e:(E39)|e.src=n
}

fact surj_E70{
	//surjective on (Transfusion, Nurse):Identify nurse, log transfusion->Store Transfusion
	all n:(N31)| some e:(E70)| e.trg = n
}

fact mult1_E36{
	//mulitplicity on :Measure temperature, blood pressure and pulse->perform transfusion[0,1]
	all n:(N5)|lone e:(E36)|e.src=n
}

fact mult1_E37{
	//mulitplicity on :perform transfusion->Identify nurse, log transfusion[0,1]
	all n:(N6)|lone e:(E37)|e.src=n
}

fact surj_E76{
	//surjective on bloodtype is unknown or screening is not done or invalid(screen is valid within 4 days):Show Patient Info->Order Sample
	all n:(N12)| some e:(E76)| e.trg = n
}

fact mult1_E34{
	//mulitplicity on :Order Sample->Select Book pre-examination[0,1]
	all n:(N12)|lone e:(E34)|e.src=n
}

fact surj_E73{
	//surjective on (BloodOrder{quantity, expectTime}):Send Blood Order->Blood distribution
	all n:(N33)| some e:(E73)| e.trg = n
}

fact mult1_E35{
	//mulitplicity on :Select Book pre-examination->Send Sample Order[0,1]
	all n:(N1)|lone e:(E35)|e.src=n
}

fact surj_E74{
	//surjective on (Blood*):Blood distribution->Collect Blood
	all n:(N4)| some e:(E74)| e.trg = n
}

fact xor_E50_E60{
	//XOR constraint between (Patient):Get Patient->Send Sample and Sample is not for the patient:Get Patient->Scan Sample
	all n:(N18) | let e1 = (some e : E50 | e.src = n), e2=(some e : E60 | e.src = n)|(e1 or e2) and not(e1 and e2)
}

fact surj_E57{
	//surjective on (Doctor):Get Doctor Info->Select Department
	all n:(N23)| some e:(E57)| e.trg = n
}

fact surj_E58{
	//surjective on (Department):Select Department->Send Blood Order
	all n:(N24)| some e:(E58)| e.trg = n
}

fact surj_E55{
	//surjective on :Order Blood->Select Blood Product
	all n:(N21)| some e:(E55)| e.trg = n
}

fact surj_E56{
	//surjective on (Barcode):Select Blood Product->Get Doctor Info
	all n:(N22)| some e:(E56)| e.trg = n
}

fact xor_E46_E45{
	//XOR constraint between Patient is not found:Get Patient Info->Scan Patient Wristband and (Patient{name, ID, gender, blodtype, screening}):Get Patient Info->Show Patient Info
	all n:(N14) | let e1 = (some e : E46 | e.src = n), e2=(some e : E45 | e.src = n)|(e1 or e2) and not(e1 and e2)
}

fact surj_E64{
	//surjective on The blood is for the patient:Verify Blood Product->Measure temperature, blood pressure and pulse
	all n:(N5)| some e:(E64)| e.trg = n
}

fact surj_E65{
	//surjective on (Patient{temp, pressure_high, pressure_low, pulse}):Measure temperature, blood pressure and pulse->Store Patient condition
	all n:(N29)| some e:(E65)| e.trg = n
}

fact surj_E62{
	//surjective on (Barcode,  Patient):Scan Blood Product->Verify Blood Product
	all n:(N27)| some e:(E62)| e.trg = n
}

fact imply2_E51_E76{
	all y1:N3, y2:N12 | let e1 = (some e : E51 | e.trg = y1), 
e2 = (some e : E76 | e.trg = y2)|
 e1 implies e2
}

fact surj_E63{
	//surjective on The blood Product is not for the patient:Verify Blood Product->Stop Transfusion, Contact AIT
	all n:(N28)| some e:(E63)| e.trg = n
}

fact xor_E71_E38{
	//XOR constraint between out time less then 0.5h:Collect Blood->Put Blood Into refrigertor and out time less than 4h:Collect Blood->Scan Blood Product
	all n:(N4) | let e1 = (some e : E71 | e.src = n), e2=(some e : E38 | e.src = n)|(e1 or e2) and not(e1 and e2)
}

run{} for 3
