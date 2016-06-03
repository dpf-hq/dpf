//Signatures for nodes
sig NScannPatientWristband{}
sig NShowPatientInfo{}
sig NGetPatientInfo{}
sig NPrintSampleLabel{}
sig NCollectBlood{}
sig NCollectSample{}
sig NSendSampleOrder{}
sig NScanSample{}
sig NOrderBlood{}
sig NOrderSample{}
sig NSelectBookpreexamination{}
sig NSendSample{}
sig NGetSampleInfo{}
sig NSendBloodOrder{}

//Signatures for edges
sig EBarcode0{src:one NScanSample, trg:one NGetSampleInfo}
sig ENShowPatientInfoNOrderBlood{src:one NShowPatientInfo, trg:one NOrderBlood}
sig EBarcode{src:one NScannPatientWristband, trg:one NGetPatientInfo}
sig ELabel{src:one NPrintSampleLabel, trg:one NCollectSample}
sig ESampleshavenotbeensent{src:one NSendBloodOrder, trg:one NScanSample}
sig EBloodhavenotbeenordered{src:one NSendSample, trg:one NOrderBlood}
sig Ebloodtypeisunknownorscreeningisnotdoneorinvalidscreenisvalidwithin4days{src:one NShowPatientInfo, trg:one NOrderSample}
sig ENSelectBookpreexaminationNSendSampleOrder{src:one NSelectBookpreexamination, trg:one NSendSampleOrder}
sig ENCollectSampleNScanSample{src:one NCollectSample, trg:one NScanSample}
sig ESampleisnotforthepatient{src:one NGetPatientInfo, trg:one NScanSample}
sig ENSendSampleNCollectBlood{src:one NSendSample, trg:one NCollectBlood}
sig EPatient{src:one NGetPatientInfo, trg:one NSendSample}
sig ESampleLabelFile{src:one NSendSampleOrder, trg:one NPrintSampleLabel}
sig ENOrderSampleNSelectBookpreexamination{src:one NOrderSample, trg:one NSelectBookpreexamination}
sig ESample{src:one NGetSampleInfo, trg:one NScannPatientWristband}

//facts
fact surj_ENSelectBookpreexaminationNSendSampleOrder{
	//surjective on :Select Book pre-examination->Send Sample Order
	all n:(NSendSampleOrder)| some e:(ENSelectBookpreexaminationNSendSampleOrder)| e.trg = n
}

fact imply2_EBloodhavenotbeenordered_Ebloodtypeisunknownorscreeningisnotdoneorinvalidscreenisvalidwithin4days{
	all y1:NOrderBlood, y2:NOrderSample | let e1 = (some e : EBloodhavenotbeenordered | e.trg = y1), 
e2 = (some e : Ebloodtypeisunknownorscreeningisnotdoneorinvalidscreenisvalidwithin4days | e.trg = y2)|
 e1 implies e2
}

fact multi_ENCollectSampleNScanSample{
	//mulitplicity on :Collect Sample->Scan Samplemin:0;max:1
	all n:(NCollectSample)| let count = #{e:(ENCollectSampleNScanSample)| e.src = n}| count>=0 and count <=1}

fact multi_ENShowPatientInfoNOrderBlood{
	//mulitplicity on :Show Patient Info->Order Bloodmin:0;max:1
	all n:(NShowPatientInfo)| let count = #{e:(ENShowPatientInfoNOrderBlood)| e.src = n}| count>=0 and count <=1}

fact multi_EBarcode0{
	//mulitplicity on (Barcode):Scan Sample->Get Sample Infomin:0;max:1
	all n:(NScanSample)| let count = #{e:(EBarcode0)| e.src = n}| count>=0 and count <=1}

fact mult1_ESampleisnotforthepatient{
	//mulitplicity on Sample is not for the patient:Get Patient Info->Scan Sample[0,1]
	all n:(NGetPatientInfo)|lone e:(ESampleisnotforthepatient)|e.src=n
}

fact js_ENCollectSampleNScanSample_ESampleshavenotbeensent{
	//joint-surjective constraint between Samples have not been sent:Send Blood Order->Scan Sample and :Collect Sample->Scan Sample
	all n:(NScanSample) | let e1 = (some e : ESampleshavenotbeensent | e.trg = n), e2=(some e : ENCollectSampleNScanSample | e.trg = n)| e1 or e2
}

fact surj_ESample{
	//surjective on (Sample):Get Sample Info->Scann Patient Wristband
	all n:(NScannPatientWristband)| some e:(ESample)| e.trg = n
}

fact surj_EBarcode0{
	//surjective on (Barcode):Scan Sample->Get Sample Info
	all n:(NGetSampleInfo)| some e:(EBarcode0)| e.trg = n
}

fact multi1_NSendSample{
	//mulitplicity on Send Sample min:2;max:2
	let count = #NSendSample | count>=2 and count <=2}

fact multi_ESample{
	//mulitplicity on (Sample):Get Sample Info->Scann Patient Wristbandmin:0;max:1
	all n:(NGetSampleInfo)| let count = #{e:(ESample)| e.src = n}| count>=0 and count <=1}

fact multi1_NShowPatientInfo{
	//mulitplicity on Show Patient Info min:0;max:1
	let count = #NShowPatientInfo | count>=0 and count <=1}

fact xor_Ebloodtypeisunknownorscreeningisnotdoneorinvalidscreenisvalidwithin4days_ENShowPatientInfoNOrderBlood{
	//XOR constraint between bloodtype is unknown or screening is not done or invalid(screen is valid within 4 days):Show Patient Info->Order Sample and :Show Patient Info->Order Blood
	all n:(NShowPatientInfo) | let e1 = (some e : Ebloodtypeisunknownorscreeningisnotdoneorinvalidscreenisvalidwithin4days | e.src = n), e2=(some e : ENShowPatientInfoNOrderBlood | e.src = n)|(e1 or e2) and not(e1 and e2)
}

fact xorsurj_ESampleisnotforthepatient_ENCollectSampleNScanSample{
	all z:NScanSample | let e1 = (some e : ENCollectSampleNScanSample | e.trg = z), 
e2 = (some e : ESampleisnotforthepatient | e.trg = z)|
(e1 or e2) and not (e1 and e2)
}

fact multi_ESampleLabelFile{
	//mulitplicity on (Sample Label File*):Send Sample Order->Print Sample Labelmin:0;max:1
	all n:(NSendSampleOrder)| let count = #{e:(ESampleLabelFile)| e.src = n}| count>=0 and count <=1}

fact xor_ENSendSampleNCollectBlood_EBloodhavenotbeenordered{
	//XOR constraint between :Send Sample->Collect Blood and Blood have not been ordered:Send Sample->Order Blood
	all n:(NSendSample) | let e1 = (some e : ENSendSampleNCollectBlood | e.src = n), e2=(some e : EBloodhavenotbeenordered | e.src = n)|(e1 or e2) and not(e1 and e2)
}

fact surj_ESampleLabelFile{
	//surjective on (Sample Label File*):Send Sample Order->Print Sample Label
	all n:(NPrintSampleLabel)| some e:(ESampleLabelFile)| e.trg = n
}

fact multi_EPatient{
	//mulitplicity on (Patient):Get Patient Info->Send Samplemin:0;max:1
	all n:(NGetPatientInfo)| let count = #{e:(EPatient)| e.src = n}| count>=0 and count <=1}

fact xor_EPatient_ESampleisnotforthepatient{
	//XOR constraint between (Patient):Get Patient Info->Send Sample and Sample is not for the patient:Get Patient Info->Scan Sample
	all n:(NGetPatientInfo) | let e1 = (some e : EPatient | e.src = n), e2=(some e : ESampleisnotforthepatient | e.src = n)|(e1 or e2) and not(e1 and e2)
}

fact multi_ESampleshavenotbeensent{
	//mulitplicity on Samples have not been sent:Send Blood Order->Scan Samplemin:0;max:1
	all n:(NSendBloodOrder)| let count = #{e:(ESampleshavenotbeensent)| e.src = n}| count>=0 and count <=1}

fact multi_Ebloodtypeisunknownorscreeningisnotdoneorinvalidscreenisvalidwithin4days{
	//mulitplicity on bloodtype is unknown or screening is not done or invalid(screen is valid within 4 days):Show Patient Info->Order Samplemin:0;max:1
	all n:(NShowPatientInfo)| let count = #{e:(Ebloodtypeisunknownorscreeningisnotdoneorinvalidscreenisvalidwithin4days)| e.src = n}| count>=0 and count <=1}

fact surj_EPatient{
	//surjective on (Patient):Get Patient Info->Send Sample
	all n:(NSendSample)| some e:(EPatient)| e.trg = n
}

fact multi_EBarcode{
	//mulitplicity on (Barcode):Scann Patient Wristband->Get Patient Infomin:0;max:1
	all n:(NScannPatientWristband)| let count = #{e:(EBarcode)| e.src = n}| count>=0 and count <=1}

fact iff2_Ebloodtypeisunknownorscreeningisnotdoneorinvalidscreenisvalidwithin4days_ENSendSampleNCollectBlood{
	all y1:NCollectBlood, y2:NOrderSample | let e1 = (some e : ENSendSampleNCollectBlood | e.trg = y1), 
e2 = (some e : Ebloodtypeisunknownorscreeningisnotdoneorinvalidscreenisvalidwithin4days | e.trg = y2)|
 e1 iff e2
}

fact surj_ENOrderSampleNSelectBookpreexamination{
	//surjective on :Order Sample->Select Book pre-examination
	all n:(NSelectBookpreexamination)| some e:(ENOrderSampleNSelectBookpreexamination)| e.trg = n
}

fact multi_ENSendSampleNCollectBlood{
	//mulitplicity on :Send Sample->Collect Bloodmin:0;max:1
	all n:(NSendSample)| let count = #{e:(ENSendSampleNCollectBlood)| e.src = n}| count>=0 and count <=1}

fact multi_ELabel{
	//mulitplicity on (Label*):Print Sample Label->Collect Samplemin:0;max:1
	all n:(NPrintSampleLabel)| let count = #{e:(ELabel)| e.src = n}| count>=0 and count <=1}

fact surj_ELabel{
	//surjective on (Label*):Print Sample Label->Collect Sample
	all n:(NCollectSample)| some e:(ELabel)| e.trg = n
}

fact surj_EBarcode{
	//surjective on (Barcode):Scann Patient Wristband->Get Patient Info
	all n:(NGetPatientInfo)| some e:(EBarcode)| e.trg = n
}

fact multi_ENSelectBookpreexaminationNSendSampleOrder{
	//mulitplicity on :Select Book pre-examination->Send Sample Ordermin:0;max:1
	all n:(NSelectBookpreexamination)| let count = #{e:(ENSelectBookpreexaminationNSendSampleOrder)| e.src = n}| count>=0 and count <=1}

fact imply_ENCollectSampleNScanSample_ESampleshavenotbeensent{
	all x:NScanSample | let e1 = (some e : ESampleshavenotbeensent | e.trg = x), 
e2 = (some e : ENCollectSampleNScanSample | e.trg = x)| not e1 or e2
}

fact nand1_ESampleshavenotbeensent_ESampleisnotforthepatient{
	//NAND constraint between Sample is not for the patient:Get Patient Info->Scan Sample and Samples have not been sent:Send Blood Order->Scan Sample
	all n:(NScanSample) | let e1 = (some e : ESampleisnotforthepatient | e.trg = n), e2=(some e : ESampleshavenotbeensent | e.trg = n)|not(e1 and e2)
}

fact multi_EBloodhavenotbeenordered{
	//mulitplicity on Blood have not been ordered:Send Sample->Order Bloodmin:0;max:1
	all n:(NSendSample)| let count = #{e:(EBloodhavenotbeenordered)| e.src = n}| count>=0 and count <=1}

fact multi_ENOrderSampleNSelectBookpreexamination{
	//mulitplicity on :Order Sample->Select Book pre-examinationmin:0;max:1
	all n:(NOrderSample)| let count = #{e:(ENOrderSampleNSelectBookpreexamination)| e.src = n}| count>=0 and count <=1}

run{} for 3
