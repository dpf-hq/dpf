//Signatures for nodes
sig NScannPatientWristband{}
sig NIdentifynurselogtransfusion{}
sig NSelectDepartment{}
sig NStorePatientCondition{}
sig NSelectBlodTypeing{}
sig NInit{}
sig NCollectSample{}
sig NGetNurseInfo{}
sig NSendSampleOrder{}
sig NPutBloodIntorefrigertor{}
sig NStoreTransfusion{}
sig NScanSample{}
sig NScanPatientWristband{}
sig NStopTransfusionContactAIT{}
sig NVerifyBloodProduct{}
sig NSelectBookpreexamination{}
sig NShowNurseInfo{}
sig Nperformtransfusion{}
sig NGetSampleInfo{}
sig NSendBloodOrder{}
sig NScanBloodProduct{}
sig NOrderBloodProduct{}
sig NScanNurseCard{}
sig NShowPatientInfo{}
sig NRegisterReaction{}
sig NSelectBloodProduct{}
sig NGetPatientInfo0{}
sig NPrintSampleLabel{}
sig NCollectBlood{}
sig NGetDoctorInfo{}
sig NMeasuretemperaturebloodpressureandpulse{}
sig NGetPatientInfo{}
sig NOrderBlood{}
sig NOrderSample{}
sig NSendSample{}

//Signatures for edges
sig ENperformtransfusionNIdentifynurselogtransfusion{src:one Nperformtransfusion, trg:one NIdentifynurselogtransfusion}
sig EPatientisnotfound{src:one NGetPatientInfo, trg:one NScanPatientWristband}
sig ENShowPatientInfoNOrderBlood{src:one NShowPatientInfo, trg:one NOrderBlood}
sig ENurseisnotfound{src:one NGetNurseInfo, trg:one NScanNurseCard}
sig Eouttimelessthen05h{src:one NCollectBlood, trg:one NPutBloodIntorefrigertor}
sig EBloodhavenotbeenordered{src:one NSendSampleOrder, trg:one NOrderBlood}
sig EPatienttemppressure_highpressure_lowpulse{src:one NMeasuretemperaturebloodpressureandpulse, trg:one NStorePatientCondition}
sig ENMeasuretemperaturebloodpressureandpulseNperformtransfusion{src:one NMeasuretemperaturebloodpressureandpulse, trg:one Nperformtransfusion}
sig EBloodhavenotbeenordered4{src:one NSendSample, trg:one NOrderBlood}
sig EDepartment{src:one NSelectDepartment, trg:one NSendBloodOrder}
sig EBarcode{src:one NScanPatientWristband, trg:one NGetPatientInfo}
sig ENSelectBookpreexaminationNSendSampleOrder{src:one NSelectBookpreexamination, trg:one NSendSampleOrder}
sig EDoctor{src:one NGetDoctorInfo, trg:one NSelectDepartment}
sig Eouttimelessthan4h6{src:one NPutBloodIntorefrigertor, trg:one NScanBloodProduct}
sig EBloodOrderquantityexpectTime{src:one NSendBloodOrder, trg:one NOrderBloodProduct}
sig ENSendSampleNCollectBlood{src:one NSendSample, trg:one NCollectBlood}
sig EPatient{src:one NGetPatientInfo0, trg:one NSendSample}
sig EMoreblood{src:one Nperformtransfusion, trg:one NScanBloodProduct}
sig ESampleLabelFile{src:one NSendSampleOrder, trg:one NPrintSampleLabel}
sig EBarcode3{src:one NSelectBloodProduct, trg:one NGetDoctorInfo}
sig EThebloodProductisnotforthepatient{src:one NVerifyBloodProduct, trg:one NStopTransfusionContactAIT}
sig ENSelectBlodTypeingNSendSampleOrder{src:one NSelectBlodTypeing, trg:one NSendSampleOrder}
sig EBlood{src:one NOrderBloodProduct, trg:one NCollectBlood}
sig EPatienthasnotbeenbloodtyped{src:one NOrderSample, trg:one NSelectBlodTypeing}
sig EBarcode1{src:one NScanSample, trg:one NGetSampleInfo}
sig ENperformtransfusionNMeasuretemperaturebloodpressureandpulse{src:one Nperformtransfusion, trg:one NMeasuretemperaturebloodpressureandpulse}
sig ESampleshavenotbeenordered{src:one NSendBloodOrder, trg:one NOrderSample}
sig EBarcode2{src:one NScannPatientWristband, trg:one NGetPatientInfo0}
sig ELabel{src:one NPrintSampleLabel, trg:one NCollectSample}
sig EPatientnameIDgenderblodtypescreening{src:one NGetPatientInfo, trg:one NShowPatientInfo}
sig ESampleshavenotbeensent{src:one NSendBloodOrder, trg:one NScanSample}
sig ETransfusionNurse{src:one NIdentifynurselogtransfusion, trg:one NStoreTransfusion}
sig ENOrderBloodNSelectBloodProduct{src:one NOrderBlood, trg:one NSelectBloodProduct}
sig Eouttimelessthan4h{src:one NCollectBlood, trg:one NScanBloodProduct}
sig Ebloodtypeisunknownorscreeningisnotdoneorinvalidscreenisvalidwithin4days{src:one NShowPatientInfo, trg:one NOrderSample}
sig EBarcode5{src:one NScanNurseCard, trg:one NGetNurseInfo}
sig ENCollectSampleNScanSample{src:one NCollectSample, trg:one NScanSample}
sig EThebloodisforthepatient{src:one NVerifyBloodProduct, trg:one Nperformtransfusion}
sig ESampleisnotforthepatient{src:one NGetPatientInfo0, trg:one NScanSample}
sig ENShowNurseInfoNScanPatientWristband{src:one NShowNurseInfo, trg:one NScanPatientWristband}
sig ENInitNScanNurseCard{src:one NInit, trg:one NScanNurseCard}
sig EReactiontype{src:one Nperformtransfusion, trg:one NRegisterReaction}
sig ENOrderSampleNSelectBookpreexamination{src:one NOrderSample, trg:one NSelectBookpreexamination}
sig ESample{src:one NGetSampleInfo, trg:one NScannPatientWristband}
sig ENursename{src:one NGetNurseInfo, trg:one NShowNurseInfo}
sig EBarcodePatient{src:one NScanBloodProduct, trg:one NVerifyBloodProduct}

//facts
fact mult1_ENperformtransfusionNIdentifynurselogtransfusion{
	//mulitplicity on :perform transfusion->Identify nurse, log transfusion[0,1]
	all n:(Nperformtransfusion)|lone e:(ENperformtransfusionNIdentifynurselogtransfusion)|e.src=n
}

fact xor3surj_Eouttimelessthan4h_EMoreblood_Eouttimelessthan4h6{
	all x:NScanBloodProduct | let e1 = (some e : Eouttimelessthan4h6 | e.trg = x), 
e2 = (some e : EMoreblood | e.trg = x), 
e3 = (some e : Eouttimelessthan4h | e.trg = x)|
not (e1 and e2) and not (e1 and e3) and not (e2 and e3) and (e1 or e2 or e3)
}

fact xorsurj_Ebloodtypeisunknownorscreeningisnotdoneorinvalidscreenisvalidwithin4days_ESampleshavenotbeenordered{
	all z:NOrderSample | let e1 = (some e : ESampleshavenotbeenordered | e.trg = z), 
e2 = (some e : Ebloodtypeisunknownorscreeningisnotdoneorinvalidscreenisvalidwithin4days | e.trg = z)|
(e1 or e2) and not (e1 and e2)
}

fact mult1_ENOrderSampleNSelectBookpreexamination{
	//mulitplicity on :Order Sample->Select Book pre-examination[0,1]
	all n:(NOrderSample)|lone e:(ENOrderSampleNSelectBookpreexamination)|e.src=n
}

fact surj_ESample{
	//surjective on (Sample):Get Sample Info->Scann Patient Wristband
	all n:(NScannPatientWristband)| some e:(ESample)| e.trg = n
}

fact surj_Eouttimelessthen05h{
	//surjective on out time less then 0.5h:Collect Blood->Put Blood Into refrigertor
	all n:(NPutBloodIntorefrigertor)| some e:(Eouttimelessthen05h)| e.trg = n
}

fact surj_EDepartment{
	//surjective on (Department):Select Department->Send Blood Order
	all n:(NSendBloodOrder)| some e:(EDepartment)| e.trg = n
}

fact xorsurj_EPatientisnotfound_ENShowNurseInfoNScanPatientWristband{
	all z:NScanPatientWristband | let e1 = (some e : ENShowNurseInfoNScanPatientWristband | e.trg = z), 
e2 = (some e : EPatientisnotfound | e.trg = z)|
(e1 or e2) and not (e1 and e2)
}

fact surj_EPatienttemppressure_highpressure_lowpulse{
	//surjective on (Patient{temp, pressure_high, pressure_low, pulse}):Measure temperature, blood pressure and pulse->Store Patient Condition
	all n:(NStorePatientCondition)| some e:(EPatienttemppressure_highpressure_lowpulse)| e.trg = n
}

fact xorsurj_ENMeasuretemperaturebloodpressureandpulseNperformtransfusion_EThebloodisforthepatient{
	all z:Nperformtransfusion | let e1 = (some e : EThebloodisforthepatient | e.trg = z), 
e2 = (some e : ENMeasuretemperaturebloodpressureandpulseNperformtransfusion | e.trg = z)|
(e1 or e2) and not (e1 and e2)
}

fact mult1_EThebloodProductisnotforthepatient{
	//mulitplicity on The blood Product is not for the patient:Verify Blood Product->Stop Transfusion, Contact AIT[0,1]
	all n:(NVerifyBloodProduct)|lone e:(EThebloodProductisnotforthepatient)|e.src=n
}

fact mult1_ENSendSampleNCollectBlood{
	//mulitplicity on :Send Sample->Collect Blood[0,1]
	all n:(NSendSample)|lone e:(ENSendSampleNCollectBlood)|e.src=n
}

fact surj_ENperformtransfusionNIdentifynurselogtransfusion{
	//surjective on :perform transfusion->Identify nurse, log transfusion
	all n:(NIdentifynurselogtransfusion)| some e:(ENperformtransfusionNIdentifynurselogtransfusion)| e.trg = n
}

fact xor_Ebloodtypeisunknownorscreeningisnotdoneorinvalidscreenisvalidwithin4days_ENShowPatientInfoNOrderBlood{
	//XOR constraint between bloodtype is unknown or screening is not done or invalid(screen is valid within 4 days):Show Patient Info->Order Sample and :Show Patient Info->Order Blood
	all n:(NShowPatientInfo) | let e1 = (some e : Ebloodtypeisunknownorscreeningisnotdoneorinvalidscreenisvalidwithin4days | e.src = n), e2=(some e : ENShowPatientInfoNOrderBlood | e.src = n)|(e1 or e2) and not(e1 and e2)
}

fact imply2_Eouttimelessthan4h6_Eouttimelessthen05h{
	all y1:NScanBloodProduct, y2:NPutBloodIntorefrigertor | let e1 = (some e : Eouttimelessthan4h6 | e.trg = y1), 
e2 = (some e : Eouttimelessthen05h | e.trg = y2)|
 e1 implies e2
}

fact surj_EBarcodePatient{
	//surjective on (Barcode,  Patient):Scan Blood Product->Verify Blood Product
	all n:(NVerifyBloodProduct)| some e:(EBarcodePatient)| e.trg = n
}

fact mult1_EPatienttemppressure_highpressure_lowpulse{
	//mulitplicity on (Patient{temp, pressure_high, pressure_low, pulse}):Measure temperature, blood pressure and pulse->Store Patient Condition[0,1]
	all n:(NMeasuretemperaturebloodpressureandpulse)|lone e:(EPatienttemppressure_highpressure_lowpulse)|e.src=n
}

fact mult1_EReactiontype{
	//mulitplicity on (Reaction{type}):perform transfusion->Register Reaction[0,1]
	all n:(Nperformtransfusion)|lone e:(EReactiontype)|e.src=n
}

fact surj_ESampleLabelFile{
	//surjective on (Sample Label File*):Send Sample Order->Print Sample Label
	all n:(NPrintSampleLabel)| some e:(ESampleLabelFile)| e.trg = n
}

fact mult1_ENSelectBlodTypeingNSendSampleOrder{
	//mulitplicity on :Select Blod Typeing->Send Sample Order[0,1]
	all n:(NSelectBlodTypeing)|lone e:(ENSelectBlodTypeingNSendSampleOrder)|e.src=n
}

fact mult1_ENursename{
	//mulitplicity on (Nurse{name}):Get Nurse Info->Show Nurse Info[0,1]
	all n:(NGetNurseInfo)|lone e:(ENursename)|e.src=n
}

fact special_Eouttimelessthan4h_Eouttimelessthan4h6{
	some NScanBloodProduct implies ((some z:NScanBloodProduct|some xz:Eouttimelessthan4h|xz.trg=z) or (some z:NScanBloodProduct|some yz:Eouttimelessthan4h6|yz.trg=z))
}

fact mult1_Eouttimelessthan4h6{
	//mulitplicity on out time less than 4h:Put Blood Into refrigertor->Scan Blood Product[0,1]
	all n:(NPutBloodIntorefrigertor)|lone e:(Eouttimelessthan4h6)|e.src=n
}

fact mult1_EDepartment{
	//mulitplicity on (Department):Select Department->Send Blood Order[0,1]
	all n:(NSelectDepartment)|lone e:(EDepartment)|e.src=n
}

fact surj_ENOrderSampleNSelectBookpreexamination{
	//surjective on :Order Sample->Select Book pre-examination
	all n:(NSelectBookpreexamination)| some e:(ENOrderSampleNSelectBookpreexamination)| e.trg = n
}

fact surj_ENOrderBloodNSelectBloodProduct{
	//surjective on :Order Blood->Select Blood Product
	all n:(NSelectBloodProduct)| some e:(ENOrderBloodNSelectBloodProduct)| e.trg = n
}

fact mult1_EBloodhavenotbeenordered4{
	//mulitplicity on Blood have not been ordered:Send Sample->Order Blood[0,1]
	all n:(NSendSample)|lone e:(EBloodhavenotbeenordered4)|e.src=n
}

fact imply2_EBloodhavenotbeenordered4_Ebloodtypeisunknownorscreeningisnotdoneorinvalidscreenisvalidwithin4days{
	all y1:NOrderBlood, y2:NOrderSample | let e1 = (some e : EBloodhavenotbeenordered4 | e.trg = y1), 
e2 = (some e : Ebloodtypeisunknownorscreeningisnotdoneorinvalidscreenisvalidwithin4days | e.trg = y2)|
 e1 implies e2
}

fact mult1_EPatienthasnotbeenbloodtyped{
	//mulitplicity on Patient has not been bloodtyped:Order Sample->Select Blod Typeing[0,1]
	all n:(NOrderSample)|lone e:(EPatienthasnotbeenbloodtyped)|e.src=n
}

fact mult1_EThebloodisforthepatient{
	//mulitplicity on The blood is for the patient:Verify Blood Product->perform transfusion[0,1]
	all n:(NVerifyBloodProduct)|lone e:(EThebloodisforthepatient)|e.src=n
}

fact surj_EPatientnameIDgenderblodtypescreening{
	//surjective on (Patient{name, ID, gender, blodtype, screening}):Get Patient Info->Show Patient Info
	all n:(NShowPatientInfo)| some e:(EPatientnameIDgenderblodtypescreening)| e.trg = n
}

fact surj_EBarcode5{
	//surjective on (Barcode):Scan Nurse Card->Get Nurse Info
	all n:(NGetNurseInfo)| some e:(EBarcode5)| e.trg = n
}

fact xor_EPatientisnotfound_EPatientnameIDgenderblodtypescreening{
	//XOR constraint between Patient is not found:Get Patient Info->Scan Patient Wristband and (Patient{name, ID, gender, blodtype, screening}):Get Patient Info->Show Patient Info
	all n:(NGetPatientInfo) | let e1 = (some e : EPatientisnotfound | e.src = n), e2=(some e : EPatientnameIDgenderblodtypescreening | e.src = n)|(e1 or e2) and not(e1 and e2)
}

fact surj_EReactiontype{
	//surjective on (Reaction{type}):perform transfusion->Register Reaction
	all n:(NRegisterReaction)| some e:(EReactiontype)| e.trg = n
}

fact surj_EBarcode1{
	//surjective on (Barcode):Scan Sample->Get Sample Info
	all n:(NGetSampleInfo)| some e:(EBarcode1)| e.trg = n
}

fact mult1_EDoctor{
	//mulitplicity on (Doctor):Get Doctor Info->Select Department[0,1]
	all n:(NGetDoctorInfo)|lone e:(EDoctor)|e.src=n
}

fact surj_EBarcode3{
	//surjective on (Barcode):Select Blood Product->Get Doctor Info
	all n:(NGetDoctorInfo)| some e:(EBarcode3)| e.trg = n
}

fact surj_EBarcode2{
	//surjective on (Barcode):Scann Patient Wristband->Get Patient Info
	all n:(NGetPatientInfo0)| some e:(EBarcode2)| e.trg = n
}

fact mult1_ENOrderBloodNSelectBloodProduct{
	//mulitplicity on :Order Blood->Select Blood Product[0,1]
	all n:(NOrderBlood)|lone e:(ENOrderBloodNSelectBloodProduct)|e.src=n
}

fact mult1_EMoreblood{
	//mulitplicity on More blood:perform transfusion->Scan Blood Product[0,1]
	all n:(Nperformtransfusion)|lone e:(EMoreblood)|e.src=n
}

fact mult1_ETransfusionNurse{
	//mulitplicity on (Transfusion, Nurse):Identify nurse, log transfusion->Store Transfusion[0,1]
	all n:(NIdentifynurselogtransfusion)|lone e:(ETransfusionNurse)|e.src=n
}

fact surj_EBloodOrderquantityexpectTime{
	//surjective on (BloodOrder{quantity, expectTime}):Send Blood Order->Order Blood Product
	all n:(NOrderBloodProduct)| some e:(EBloodOrderquantityexpectTime)| e.trg = n
}

fact xorsurj_ENInitNScanNurseCard_ENurseisnotfound{
	all z:NScanNurseCard | let e1 = (some e : ENurseisnotfound | e.trg = z), 
e2 = (some e : ENInitNScanNurseCard | e.trg = z)|
(e1 or e2) and not (e1 and e2)
}

fact mult1_ENShowPatientInfoNOrderBlood{
	//mulitplicity on :Show Patient Info->Order Blood[0,1]
	all n:(NShowPatientInfo)|lone e:(ENShowPatientInfoNOrderBlood)|e.src=n
}

fact mult1_ENShowNurseInfoNScanPatientWristband{
	//mulitplicity on :Show Nurse Info->Scan Patient Wristband[0,1]
	all n:(NShowNurseInfo)|lone e:(ENShowNurseInfoNScanPatientWristband)|e.src=n
}

fact surj_ETransfusionNurse{
	//surjective on (Transfusion, Nurse):Identify nurse, log transfusion->Store Transfusion
	all n:(NStoreTransfusion)| some e:(ETransfusionNurse)| e.trg = n
}

fact surj_ENursename{
	//surjective on (Nurse{name}):Get Nurse Info->Show Nurse Info
	all n:(NShowNurseInfo)| some e:(ENursename)| e.trg = n
}

fact xor_EThebloodProductisnotforthepatient_EThebloodisforthepatient{
	//XOR constraint between The blood Product is not for the patient:Verify Blood Product->Stop Transfusion, Contact AIT and The blood is for the patient:Verify Blood Product->perform transfusion
	all n:(NVerifyBloodProduct) | let e1 = (some e : EThebloodProductisnotforthepatient | e.src = n), e2=(some e : EThebloodisforthepatient | e.src = n)|(e1 or e2) and not(e1 and e2)
}

fact mult1_ELabel{
	//mulitplicity on (Label*):Print Sample Label->Collect Sample[0,1]
	all n:(NPrintSampleLabel)|lone e:(ELabel)|e.src=n
}

fact mult1_ENurseisnotfound{
	//mulitplicity on Nurse is not found:Get Nurse Info->Scan Nurse Card[0,1]
	all n:(NGetNurseInfo)|lone e:(ENurseisnotfound)|e.src=n
}

fact mult1_Ebloodtypeisunknownorscreeningisnotdoneorinvalidscreenisvalidwithin4days{
	//mulitplicity on bloodtype is unknown or screening is not done or invalid(screen is valid within 4 days):Show Patient Info->Order Sample[0,1]
	all n:(NShowPatientInfo)|lone e:(Ebloodtypeisunknownorscreeningisnotdoneorinvalidscreenisvalidwithin4days)|e.src=n
}

fact mult1_EPatient{
	//mulitplicity on (Patient):Get Patient Info->Send Sample[0,1]
	all n:(NGetPatientInfo0)|lone e:(EPatient)|e.src=n
}

fact multi1_NScanNurseCard{
	//mulitplicity on Scan Nurse Card min:2;max:2
	let count = #NScanNurseCard | count>=2 and count <=2}

fact mult1_Eouttimelessthan4h{
	//mulitplicity on out time less than 4h:Collect Blood->Scan Blood Product[0,1]
	all n:(NCollectBlood)|lone e:(Eouttimelessthan4h)|e.src=n
}

fact mult1_EBloodOrderquantityexpectTime{
	//mulitplicity on (BloodOrder{quantity, expectTime}):Send Blood Order->Order Blood Product[0,1]
	all n:(NSendBloodOrder)|lone e:(EBloodOrderquantityexpectTime)|e.src=n
}

fact nand1_ESampleshavenotbeensent_ESampleisnotforthepatient{
	//NAND constraint between Sample is not for the patient:Get Patient Info->Scan Sample and Samples have not been sent:Send Blood Order->Scan Sample
	all n:(NScanSample) | let e1 = (some e : ESampleisnotforthepatient | e.trg = n), e2=(some e : ESampleshavenotbeensent | e.trg = n)|not(e1 and e2)
}

fact surj_EBlood{
	//surjective on (Blood*):Order Blood Product->Collect Blood
	all n:(NCollectBlood)| some e:(EBlood)| e.trg = n
}

fact mult1_EBarcodePatient{
	//mulitplicity on (Barcode,  Patient):Scan Blood Product->Verify Blood Product[0,1]
	all n:(NScanBloodProduct)|lone e:(EBarcodePatient)|e.src=n
}

fact surj_ENSelectBookpreexaminationNSendSampleOrder{
	//surjective on :Select Book pre-examination->Send Sample Order
	all n:(NSendSampleOrder)| some e:(ENSelectBookpreexaminationNSendSampleOrder)| e.trg = n
}

fact mult1_EPatientisnotfound{
	//mulitplicity on Patient is not found:Get Patient Info->Scan Patient Wristband[0,1]
	all n:(NGetPatientInfo)|lone e:(EPatientisnotfound)|e.src=n
}

fact multi1_NInit{
	//mulitplicity on Init min:1;max:1
	let count = #NInit | count>=1 and count <=1}

fact mult1_ESampleisnotforthepatient{
	//mulitplicity on Sample is not for the patient:Get Patient Info->Scan Sample[0,1]
	all n:(NGetPatientInfo0)|lone e:(ESampleisnotforthepatient)|e.src=n
}

fact xor3_ESampleshavenotbeenordered_EBloodOrderquantityexpectTime_ESampleshavenotbeensent{
	all x:NSendBloodOrder | let e1 = (some e : ESampleshavenotbeensent | e.src = x), 
e2 = (some e : EBloodOrderquantityexpectTime | e.src = x), 
e3 = (some e : ESampleshavenotbeenordered | e.src = x)|
not (e1 and e2) and not (e1 and e3) and not (e2 and e3) and (e1 or e2 or e3)
}

fact mult1_ESampleLabelFile{
	//mulitplicity on (Sample Label File*):Send Sample Order->Print Sample Label[0,1]
	all n:(NSendSampleOrder)|lone e:(ESampleLabelFile)|e.src=n
}

fact xor_ENSendSampleNCollectBlood_EBloodhavenotbeenordered4{
	//XOR constraint between :Send Sample->Collect Blood and Blood have not been ordered:Send Sample->Order Blood
	all n:(NSendSample) | let e1 = (some e : ENSendSampleNCollectBlood | e.src = n), e2=(some e : EBloodhavenotbeenordered4 | e.src = n)|(e1 or e2) and not(e1 and e2)
}

fact multi1_NSendSample{
	//mulitplicity on Send Sample min:2;max:2
	let count = #NSendSample | count>=2 and count <=2}

fact xorsurj_ESampleisnotforthepatient_ENCollectSampleNScanSample{
	all z:NScanSample | let e1 = (some e : ENCollectSampleNScanSample | e.trg = z), 
e2 = (some e : ESampleisnotforthepatient | e.trg = z)|
(e1 or e2) and not (e1 and e2)
}

fact xor3surj_EBloodhavenotbeenordered_EBloodhavenotbeenordered4_ENShowPatientInfoNOrderBlood{
	all x:NOrderBlood | let e1 = (some e : ENShowPatientInfoNOrderBlood | e.trg = x), 
e2 = (some e : EBloodhavenotbeenordered4 | e.trg = x), 
e3 = (some e : EBloodhavenotbeenordered | e.trg = x)|
not (e1 and e2) and not (e1 and e3) and not (e2 and e3) and (e1 or e2 or e3)
}

fact mult1_ENInitNScanNurseCard{
	//mulitplicity on :Init->Scan Nurse Card[0,1]
	all n:(NInit)|lone e:(ENInitNScanNurseCard)|e.src=n
}

fact mult1_EBarcode{
	//mulitplicity on (Barcode):Scan Patient Wristband->Get Patient Info[0,1]
	all n:(NScanPatientWristband)|lone e:(EBarcode)|e.src=n
}

fact xor4_ENperformtransfusionNIdentifynurselogtransfusion_EMoreblood_ENperformtransfusionNMeasuretemperaturebloodpressureandpulse_EReactiontype{
	//XOR constraint between More blood:perform transfusion->Scan Blood Product,:perform transfusion->Measure temperature, blood pressure and pulse,(Reaction{type}):perform transfusion->Register Reaction and :perform transfusion->Identify nurse, log transfusion
	all n:(Nperformtransfusion) | let e1=(some e : EMoreblood|e.src = n), e2=(some e : ENperformtransfusionNMeasuretemperaturebloodpressureandpulse|e.src = n), e3=(some e : EReactiontype|e.src = n), e4=(some e : ENperformtransfusionNIdentifynurselogtransfusion|e.src = n)|(e1 or e2 or e3 or e4) and not(((e1 and (e2 or e3 or e4)) or (e2 and (e1 or e3 or e4)) or (e3 and (e2 or e1 or e4)) or (e4 and (e2 or e3 or e1))))
}

fact imply2_ENSelectBlodTypeingNSendSampleOrder_EPatienthasnotbeenbloodtyped{
	all y1:NSendSampleOrder, y2:NSelectBlodTypeing | let e1 = (some e : ENSelectBlodTypeingNSendSampleOrder | e.trg = y1), 
e2 = (some e : EPatienthasnotbeenbloodtyped | e.trg = y2)|
 e1 implies e2
}

fact mult1_ESample{
	//mulitplicity on (Sample):Get Sample Info->Scann Patient Wristband[0,1]
	all n:(NGetSampleInfo)|lone e:(ESample)|e.src=n
}

fact mult1_ESampleshavenotbeenordered{
	//mulitplicity on Samples have not been ordered:Send Blood Order->Order Sample[0,1]
	all n:(NSendBloodOrder)|lone e:(ESampleshavenotbeenordered)|e.src=n
}

fact surj_EBarcode{
	//surjective on (Barcode):Scan Patient Wristband->Get Patient Info
	all n:(NGetPatientInfo)| some e:(EBarcode)| e.trg = n
}

fact mult1_ENSelectBookpreexaminationNSendSampleOrder{
	//mulitplicity on :Select Book pre-examination->Send Sample Order[0,1]
	all n:(NSelectBookpreexamination)|lone e:(ENSelectBookpreexaminationNSendSampleOrder)|e.src=n
}

fact surj_EThebloodisforthepatient{
	//surjective on The blood is for the patient:Verify Blood Product->perform transfusion
	all n:(NMeasuretemperaturebloodpressureandpulse)| some e:(EThebloodisforthepatient)| e.trg = n
}

fact multi1_NScanSample{
	//mulitplicity on Scan Sample min:0;max:1
	let count = #NScanSample | count>=0 and count <=1}

fact mult1_ENMeasuretemperaturebloodpressureandpulseNperformtransfusion{
	//mulitplicity on :Measure temperature, blood pressure and pulse->perform transfusion[0,1]
	all n:(NMeasuretemperaturebloodpressureandpulse)|lone e:(ENMeasuretemperaturebloodpressureandpulseNperformtransfusion)|e.src=n
}

fact imply2_EBloodhavenotbeenordered_Ebloodtypeisunknownorscreeningisnotdoneorinvalidscreenisvalidwithin4days{
	all y1:NOrderBlood, y2:NOrderSample | let e1 = (some e : EBloodhavenotbeenordered | e.trg = y1), 
e2 = (some e : Ebloodtypeisunknownorscreeningisnotdoneorinvalidscreenisvalidwithin4days | e.trg = y2)|
 e1 implies e2
}

fact xor_ENurseisnotfound_ENursename{
	//XOR constraint between Nurse is not found:Get Nurse Info->Scan Nurse Card and (Nurse{name}):Get Nurse Info->Show Nurse Info
	all n:(NGetNurseInfo) | let e1 = (some e : ENurseisnotfound | e.src = n), e2=(some e : ENursename | e.src = n)|(e1 or e2) and not(e1 and e2)
}

fact xor_Eouttimelessthen05h_Eouttimelessthan4h{
	//XOR constraint between out time less then 0.5h:Collect Blood->Put Blood Into refrigertor and out time less than 4h:Collect Blood->Scan Blood Product
	all n:(NCollectBlood) | let e1 = (some e : Eouttimelessthen05h | e.src = n), e2=(some e : Eouttimelessthan4h | e.src = n)|(e1 or e2) and not(e1 and e2)
}

fact surj_EDoctor{
	//surjective on (Doctor):Get Doctor Info->Select Department
	all n:(NSelectDepartment)| some e:(EDoctor)| e.trg = n
}

fact mult1_ENCollectSampleNScanSample{
	//mulitplicity on :Collect Sample->Scan Sample[0,1]
	all n:(NCollectSample)|lone e:(ENCollectSampleNScanSample)|e.src=n
}

fact surj_ENMeasuretemperaturebloodpressureandpulseNperformtransfusion{
	//surjective on :Measure temperature, blood pressure and pulse->perform transfusion
	all n:(Nperformtransfusion)| some e:(ENMeasuretemperaturebloodpressureandpulseNperformtransfusion)| e.trg = n
}

fact surj_EPatienthasnotbeenbloodtyped{
	//surjective on Patient has not been bloodtyped:Order Sample->Select Blod Typeing
	all n:(NSelectBlodTypeing)| some e:(EPatienthasnotbeenbloodtyped)| e.trg = n
}

fact mult1_EBarcode2{
	//mulitplicity on (Barcode):Scann Patient Wristband->Get Patient Info[0,1]
	all n:(NScannPatientWristband)|lone e:(EBarcode2)|e.src=n
}

fact mult1_EBarcode1{
	//mulitplicity on (Barcode):Scan Sample->Get Sample Info[0,1]
	all n:(NScanSample)|lone e:(EBarcode1)|e.src=n
}

fact mult1_EBarcode3{
	//mulitplicity on (Barcode):Select Blood Product->Get Doctor Info[0,1]
	all n:(NSelectBloodProduct)|lone e:(EBarcode3)|e.src=n
}

fact multi1_NScanPatientWristband{
	//mulitplicity on Scan Patient Wristband min:0;max:2
	let count = #NScanPatientWristband | count>=0 and count <=2}

fact mult1_ESampleshavenotbeensent{
	//mulitplicity on Samples have not been sent:Send Blood Order->Scan Sample[0,1]
	all n:(NSendBloodOrder)|lone e:(ESampleshavenotbeensent)|e.src=n
}

fact mult1_EBarcode5{
	//mulitplicity on (Barcode):Scan Nurse Card->Get Nurse Info[0,1]
	all n:(NScanNurseCard)|lone e:(EBarcode5)|e.src=n
}

fact mult1_ENperformtransfusionNMeasuretemperaturebloodpressureandpulse{
	//mulitplicity on :perform transfusion->Measure temperature, blood pressure and pulse[0,1]
	all n:(Nperformtransfusion)|lone e:(ENperformtransfusionNMeasuretemperaturebloodpressureandpulse)|e.src=n
}

fact xor_EPatient_ESampleisnotforthepatient{
	//XOR constraint between (Patient):Get Patient Info->Send Sample and Sample is not for the patient:Get Patient Info->Scan Sample
	all n:(NGetPatientInfo0) | let e1 = (some e : EPatient | e.src = n), e2=(some e : ESampleisnotforthepatient | e.src = n)|(e1 or e2) and not(e1 and e2)
}

fact mult1_EPatientnameIDgenderblodtypescreening{
	//mulitplicity on (Patient{name, ID, gender, blodtype, screening}):Get Patient Info->Show Patient Info[0,1]
	all n:(NGetPatientInfo)|lone e:(EPatientnameIDgenderblodtypescreening)|e.src=n
}

fact surj_EPatient{
	//surjective on (Patient):Get Patient Info->Send Sample
	all n:(NSendSample)| some e:(EPatient)| e.trg = n
}

fact mult1_EBloodhavenotbeenordered{
	//mulitplicity on Blood have not been ordered:Send Sample Order->Order Blood[0,1]
	all n:(NSendSampleOrder)|lone e:(EBloodhavenotbeenordered)|e.src=n
}

fact mult1_Eouttimelessthen05h{
	//mulitplicity on out time less then 0.5h:Collect Blood->Put Blood Into refrigertor[0,1]
	all n:(NCollectBlood)|lone e:(Eouttimelessthen05h)|e.src=n
}

fact mult1_EBlood{
	//mulitplicity on (Blood*):Order Blood Product->Collect Blood[0,1]
	all n:(NOrderBloodProduct)|lone e:(EBlood)|e.src=n
}

fact surj_EThebloodProductisnotforthepatient{
	//surjective on The blood Product is not for the patient:Verify Blood Product->Stop Transfusion, Contact AIT
	all n:(NStopTransfusionContactAIT)| some e:(EThebloodProductisnotforthepatient)| e.trg = n
}

fact surj_ELabel{
	//surjective on (Label*):Print Sample Label->Collect Sample
	all n:(NCollectSample)| some e:(ELabel)| e.trg = n
}

fact imply_ENCollectSampleNScanSample_ESampleshavenotbeensent{
	all x:NScanSample | let e1 = (some e : ESampleshavenotbeensent | e.trg = x), 
e2 = (some e : ENCollectSampleNScanSample | e.trg = x)| not e1 or e2
}

run{} for 3
