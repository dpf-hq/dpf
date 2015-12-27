//signatures for nodes
sig NScanPatientWristband{}
sig NSelectBookpreexamination{}
sig NSendSampleOrder{}
sig NOrderBlood{}
sig NCollectBlood{}
sig NMeasuretemperaturebloodpressureandpulse{}
sig Nperformtransfusion{}
sig NIdentifynurselogtransfusion{}
sig NScanNurseCard{}
sig NShowNurseInfo{}
sig NSelectBlodTypeing{}
sig NShowPatientInfo{}
sig NOrderSample{}
sig NGetNurseInfo{}
sig NGetPatientInfo{}
sig NGetSampleInfo{}
sig NScannPatientWristband{}
sig NScanSample{}
sig NGetPatientInfo0{}
sig NCollectSample{}
sig NSelectBloodProduct{}
sig NGetDoctorInfo{}
sig NSelectDepartment{}
sig NSendBloodOrder{}
sig NSendSample{}
sig NScanBloodProduct{}
sig NVerifyBloodProduct{}
sig NStopTransfusionContactAIT{}
sig NStorePatientCondition{}
sig NRegisterReaction{}
sig NStoreTransfusion{}
sig NPutBloodIntorefrigertor{}
sig NOrderBloodProduct{}
sig NPrintSampleLabel{}
sig NInit{}

//signatures for edges
sig ANOrderSampleNSelectBookpreexamination{src:one NOrderSample, trg:one NSelectBookpreexamination}
sig ANSelectBookpreexaminationNSendSampleOrder{src:one NSelectBookpreexamination, trg:one NSendSampleOrder}
sig ANperformtransfusionNIdentifynurselogtransfusion{src:one Nperformtransfusion, trg:one NIdentifynurselogtransfusion}
sig Aouttimelessthan4h{src:one NCollectBlood, trg:one NScanBloodProduct}
sig ANShowNurseInfoNScanPatientWristband{src:one NShowNurseInfo, trg:one NScanPatientWristband}
sig APatienthasnotbeenbloodtyped{src:one NOrderSample, trg:one NSelectBlodTypeing}
sig ANSelectBlodTypeingNSendSampleOrder{src:one NSelectBlodTypeing, trg:one NSendSampleOrder}
sig ANursename{src:one NGetNurseInfo, trg:one NShowNurseInfo}
sig ANurseisnotfound{src:one NGetNurseInfo, trg:one NScanNurseCard}
sig ABarcode{src:one NScanPatientWristband, trg:one NGetPatientInfo}
sig APatientnameIDgenderblodtypescreening{src:one NGetPatientInfo, trg:one NShowPatientInfo}
sig APatientisnotfound{src:one NGetPatientInfo, trg:one NScanPatientWristband}
sig ASample{src:one NGetSampleInfo, trg:one NScannPatientWristband}
sig ABarcode1{src:one NScanSample, trg:one NGetSampleInfo}
sig ABarcode2{src:one NScannPatientWristband, trg:one NGetPatientInfo0}
sig APatient{src:one NGetPatientInfo0, trg:one NSendSample}
sig ABloodhavenotbeenordered{src:one NSendSampleOrder, trg:one NOrderBlood}
sig ANCollectSampleNScanSample{src:one NCollectSample, trg:one NScanSample}
sig ANOrderBloodNSelectBloodProduct{src:one NOrderBlood, trg:one NSelectBloodProduct}
sig ABarcode3{src:one NSelectBloodProduct, trg:one NGetDoctorInfo}
sig ADoctor{src:one NGetDoctorInfo, trg:one NSelectDepartment}
sig ADepartment{src:one NSelectDepartment, trg:one NSendBloodOrder}
sig ASampleshavenotbeensent{src:one NSendBloodOrder, trg:one NScanSample}
sig ASampleisnotforthepatient{src:one NGetPatientInfo0, trg:one NScanSample}
sig ABloodhavenotbeenordered4{src:one NSendSample, trg:one NOrderBlood}
sig ABarcodePatient{src:one NScanBloodProduct, trg:one NVerifyBloodProduct}
sig AThebloodProductisnotforthepatient{src:one NVerifyBloodProduct, trg:one NStopTransfusionContactAIT}
sig AThebloodisforthepatient{src:one NVerifyBloodProduct, trg:one Nperformtransfusion}
sig APatienttemppressure_highpressure_lowpulse{src:one NMeasuretemperaturebloodpressureandpulse, trg:one NStorePatientCondition}
sig AMoreblood{src:one Nperformtransfusion, trg:one NScanBloodProduct}
sig ABarcode5{src:one NScanNurseCard, trg:one NGetNurseInfo}
sig ANShowPatientInfoNOrderBlood{src:one NShowPatientInfo, trg:one NOrderBlood}
sig AReactiontype{src:one Nperformtransfusion, trg:one NRegisterReaction}
sig ATransfusionNurse{src:one NIdentifynurselogtransfusion, trg:one NStoreTransfusion}
sig Aouttimelessthen05h{src:one NCollectBlood, trg:one NPutBloodIntorefrigertor}
sig Aouttimelessthan4h6{src:one NPutBloodIntorefrigertor, trg:one NScanBloodProduct}
sig ABloodOrderquantityexpectTime{src:one NSendBloodOrder, trg:one NOrderBloodProduct}
sig ABlood{src:one NOrderBloodProduct, trg:one NCollectBlood}
sig ANSendSampleNCollectBlood{src:one NSendSample, trg:one NCollectBlood}
sig Abloodtypeisunknownorscreeningisnotdoneorinvalidscreenisvalidwithin4days{src:one NShowPatientInfo, trg:one NOrderSample}
sig ASampleshavenotbeenordered{src:one NSendBloodOrder, trg:one NOrderSample}
sig ANperformtransfusionNMeasuretemperaturebloodpressureandpulse{src:one Nperformtransfusion, trg:one NMeasuretemperaturebloodpressureandpulse}
sig ANMeasuretemperaturebloodpressureandpulseNperformtransfusion{src:one NMeasuretemperaturebloodpressureandpulse, trg:one Nperformtransfusion}
sig ASampleLabelFile{src:one NSendSampleOrder, trg:one NPrintSampleLabel}
sig ALabel{src:one NPrintSampleLabel, trg:one NCollectSample}
sig ANInitNScanNurseCard{src:one NInit, trg:one NScanNurseCard}

sig Graph{nodes:set NScanPatientWristband+NSelectBookpreexamination+NSendSampleOrder+NOrderBlood+NCollectBlood+NMeasuretemperaturebloodpressureandpulse+Nperformtransfusion+NIdentifynurselogtransfusion+NScanNurseCard+NShowNurseInfo+NSelectBlodTypeing+NShowPatientInfo+NOrderSample+NGetNurseInfo+NGetPatientInfo+NGetSampleInfo+NScannPatientWristband+NScanSample+NGetPatientInfo0+NCollectSample+NSelectBloodProduct+NGetDoctorInfo+NSelectDepartment+NSendBloodOrder+NSendSample+NScanBloodProduct+NVerifyBloodProduct+NStopTransfusionContactAIT+NStorePatientCondition+NRegisterReaction+NStoreTransfusion+NPutBloodIntorefrigertor+NOrderBloodProduct+NPrintSampleLabel+NInit, arrows:set ANOrderSampleNSelectBookpreexamination+ANSelectBookpreexaminationNSendSampleOrder+ANperformtransfusionNIdentifynurselogtransfusion+Aouttimelessthan4h+ANShowNurseInfoNScanPatientWristband+APatienthasnotbeenbloodtyped+ANSelectBlodTypeingNSendSampleOrder+ANursename+ANurseisnotfound+ABarcode+APatientnameIDgenderblodtypescreening+APatientisnotfound+ASample+ABarcode1+ABarcode2+APatient+ABloodhavenotbeenordered+ANCollectSampleNScanSample+ANOrderBloodNSelectBloodProduct+ABarcode3+ADoctor+ADepartment+ASampleshavenotbeensent+ASampleisnotforthepatient+ABloodhavenotbeenordered4+ABarcodePatient+AThebloodProductisnotforthepatient+AThebloodisforthepatient+APatienttemppressure_highpressure_lowpulse+AMoreblood+ABarcode5+ANShowPatientInfoNOrderBlood+AReactiontype+ATransfusionNurse+Aouttimelessthen05h+Aouttimelessthan4h6+ABloodOrderquantityexpectTime+ABlood+ANSendSampleNCollectBlood+Abloodtypeisunknownorscreeningisnotdoneorinvalidscreenisvalidwithin4days+ASampleshavenotbeenordered+ANperformtransfusionNMeasuretemperaturebloodpressureandpulse+ANMeasuretemperaturebloodpressureandpulseNperformtransfusion+ASampleLabelFile+ALabel+ANInitNScanNurseCard}

//In a graph, the source and target node of each contained edge should be also contained by the graph
pred to_be_graph[graph:Graph]{
	all arrow : ANOrderSampleNSelectBookpreexamination&graph.arrows|(arrow.src in graph.nodes and arrow.trg in graph.nodes)
	all arrow : ANSelectBookpreexaminationNSendSampleOrder&graph.arrows|(arrow.src in graph.nodes and arrow.trg in graph.nodes)
	all arrow : ANperformtransfusionNIdentifynurselogtransfusion&graph.arrows|(arrow.src in graph.nodes and arrow.trg in graph.nodes)
	all arrow : Aouttimelessthan4h&graph.arrows|(arrow.src in graph.nodes and arrow.trg in graph.nodes)
	all arrow : ANShowNurseInfoNScanPatientWristband&graph.arrows|(arrow.src in graph.nodes and arrow.trg in graph.nodes)
	all arrow : APatienthasnotbeenbloodtyped&graph.arrows|(arrow.src in graph.nodes and arrow.trg in graph.nodes)
	all arrow : ANSelectBlodTypeingNSendSampleOrder&graph.arrows|(arrow.src in graph.nodes and arrow.trg in graph.nodes)
	all arrow : ANursename&graph.arrows|(arrow.src in graph.nodes and arrow.trg in graph.nodes)
	all arrow : ANurseisnotfound&graph.arrows|(arrow.src in graph.nodes and arrow.trg in graph.nodes)
	all arrow : ABarcode&graph.arrows|(arrow.src in graph.nodes and arrow.trg in graph.nodes)
	all arrow : APatientnameIDgenderblodtypescreening&graph.arrows|(arrow.src in graph.nodes and arrow.trg in graph.nodes)
	all arrow : APatientisnotfound&graph.arrows|(arrow.src in graph.nodes and arrow.trg in graph.nodes)
	all arrow : ASample&graph.arrows|(arrow.src in graph.nodes and arrow.trg in graph.nodes)
	all arrow : ABarcode1&graph.arrows|(arrow.src in graph.nodes and arrow.trg in graph.nodes)
	all arrow : ABarcode2&graph.arrows|(arrow.src in graph.nodes and arrow.trg in graph.nodes)
	all arrow : APatient&graph.arrows|(arrow.src in graph.nodes and arrow.trg in graph.nodes)
	all arrow : ABloodhavenotbeenordered&graph.arrows|(arrow.src in graph.nodes and arrow.trg in graph.nodes)
	all arrow : ANCollectSampleNScanSample&graph.arrows|(arrow.src in graph.nodes and arrow.trg in graph.nodes)
	all arrow : ANOrderBloodNSelectBloodProduct&graph.arrows|(arrow.src in graph.nodes and arrow.trg in graph.nodes)
	all arrow : ABarcode3&graph.arrows|(arrow.src in graph.nodes and arrow.trg in graph.nodes)
	all arrow : ADoctor&graph.arrows|(arrow.src in graph.nodes and arrow.trg in graph.nodes)
	all arrow : ADepartment&graph.arrows|(arrow.src in graph.nodes and arrow.trg in graph.nodes)
	all arrow : ASampleshavenotbeensent&graph.arrows|(arrow.src in graph.nodes and arrow.trg in graph.nodes)
	all arrow : ASampleisnotforthepatient&graph.arrows|(arrow.src in graph.nodes and arrow.trg in graph.nodes)
	all arrow : ABloodhavenotbeenordered4&graph.arrows|(arrow.src in graph.nodes and arrow.trg in graph.nodes)
	all arrow : ABarcodePatient&graph.arrows|(arrow.src in graph.nodes and arrow.trg in graph.nodes)
	all arrow : AThebloodProductisnotforthepatient&graph.arrows|(arrow.src in graph.nodes and arrow.trg in graph.nodes)
	all arrow : AThebloodisforthepatient&graph.arrows|(arrow.src in graph.nodes and arrow.trg in graph.nodes)
	all arrow : APatienttemppressure_highpressure_lowpulse&graph.arrows|(arrow.src in graph.nodes and arrow.trg in graph.nodes)
	all arrow : AMoreblood&graph.arrows|(arrow.src in graph.nodes and arrow.trg in graph.nodes)
	all arrow : ABarcode5&graph.arrows|(arrow.src in graph.nodes and arrow.trg in graph.nodes)
	all arrow : ANShowPatientInfoNOrderBlood&graph.arrows|(arrow.src in graph.nodes and arrow.trg in graph.nodes)
	all arrow : AReactiontype&graph.arrows|(arrow.src in graph.nodes and arrow.trg in graph.nodes)
	all arrow : ATransfusionNurse&graph.arrows|(arrow.src in graph.nodes and arrow.trg in graph.nodes)
	all arrow : Aouttimelessthen05h&graph.arrows|(arrow.src in graph.nodes and arrow.trg in graph.nodes)
	all arrow : Aouttimelessthan4h6&graph.arrows|(arrow.src in graph.nodes and arrow.trg in graph.nodes)
	all arrow : ABloodOrderquantityexpectTime&graph.arrows|(arrow.src in graph.nodes and arrow.trg in graph.nodes)
	all arrow : ABlood&graph.arrows|(arrow.src in graph.nodes and arrow.trg in graph.nodes)
	all arrow : ANSendSampleNCollectBlood&graph.arrows|(arrow.src in graph.nodes and arrow.trg in graph.nodes)
	all arrow : Abloodtypeisunknownorscreeningisnotdoneorinvalidscreenisvalidwithin4days&graph.arrows|(arrow.src in graph.nodes and arrow.trg in graph.nodes)
	all arrow : ASampleshavenotbeenordered&graph.arrows|(arrow.src in graph.nodes and arrow.trg in graph.nodes)
	all arrow : ANperformtransfusionNMeasuretemperaturebloodpressureandpulse&graph.arrows|(arrow.src in graph.nodes and arrow.trg in graph.nodes)
	all arrow : ANMeasuretemperaturebloodpressureandpulseNperformtransfusion&graph.arrows|(arrow.src in graph.nodes and arrow.trg in graph.nodes)
	all arrow : ASampleLabelFile&graph.arrows|(arrow.src in graph.nodes and arrow.trg in graph.nodes)
	all arrow : ALabel&graph.arrows|(arrow.src in graph.nodes and arrow.trg in graph.nodes)
	all arrow : ANInitNScanNurseCard&graph.arrows|(arrow.src in graph.nodes and arrow.trg in graph.nodes)
}

one abstract sig Rule{}
lone sig CollectBloodPutBloodIntorefrigertor, CollectBloodScanBloodProduct, CollectSampleScanSample, GetDoctorInfoSelectDepartment, GetNurseInfoScanNurseCard, GetNurseInfoShowNurseInfo, GetPatientInfoScanPatientWristband, GetPatientInfoScanSample, GetPatientInfoSendSample, GetPatientInfoShowPatientInfo, GetSampleInfoScannPatientWristband, IdentifynurselogtransfusionStoreTransfusion, InitScanNurseCard, MeasuretemperaturebloodpressureandpulseStorePatientCondition, Measuretemperaturebloodpressureandpulseperformtransfusion, OrderBloodProductCollectBlood, OrderBloodSelectBloodProduct, OrderSampleSelectBlodTypeing, OrderSampleSelectBookpreexamination, PrintSampleLabelCollectSample, PutBloodIntorefrigertorScanBloodProduct, ScanBloodProductVerifyBloodProduct, ScanNurseCardGetNurseInfo, ScanPatientWristbandGetPatientInfo, ScanSampleGetSampleInfo, ScannPatientWristbandGetPatientInfo, SelectBlodTypeingSendSampleOrder, SelectBloodProductGetDoctorInfo, SelectBookpreexaminationSendSampleOrder, SelectDepartmentSendBloodOrder, SendBloodOrderOrderBloodProduct, SendBloodOrderOrderSample, SendBloodOrderScanSample, SendSampleCollectBlood, SendSampleOrderBlood, SendSampleOrderOrderBlood, SendSampleOrderPrintSampleLabel, ShowNurseInfoScanPatientWristband, ShowPatientInfoOrderBlood, ShowPatientInfoOrderSample, VerifyBloodProductStopTransfusionContactAIT, VerifyBloodProductperformtransfusion, performtransfusionIdentifynurselogtransfusion, performtransfusionMeasuretemperaturebloodpressureandpulse, performtransfusionRegisterReaction, performtransfusionScanBloodProduct extends Rule{}

sig Trans{rule:one Rule, source,target:one Graph, dnodes, anodes:set NScanPatientWristband+NSelectBookpreexamination+NSendSampleOrder+NOrderBlood+NCollectBlood+NMeasuretemperaturebloodpressureandpulse+Nperformtransfusion+NIdentifynurselogtransfusion+NScanNurseCard+NShowNurseInfo+NSelectBlodTypeing+NShowPatientInfo+NOrderSample+NGetNurseInfo+NGetPatientInfo+NGetSampleInfo+NScannPatientWristband+NScanSample+NGetPatientInfo0+NCollectSample+NSelectBloodProduct+NGetDoctorInfo+NSelectDepartment+NSendBloodOrder+NSendSample+NScanBloodProduct+NVerifyBloodProduct+NStopTransfusionContactAIT+NStorePatientCondition+NRegisterReaction+NStoreTransfusion+NPutBloodIntorefrigertor+NOrderBloodProduct+NPrintSampleLabel+NInit, darrows, aarrows:set ANOrderSampleNSelectBookpreexamination+ANSelectBookpreexaminationNSendSampleOrder+ANperformtransfusionNIdentifynurselogtransfusion+Aouttimelessthan4h+ANShowNurseInfoNScanPatientWristband+APatienthasnotbeenbloodtyped+ANSelectBlodTypeingNSendSampleOrder+ANursename+ANurseisnotfound+ABarcode+APatientnameIDgenderblodtypescreening+APatientisnotfound+ASample+ABarcode1+ABarcode2+APatient+ABloodhavenotbeenordered+ANCollectSampleNScanSample+ANOrderBloodNSelectBloodProduct+ABarcode3+ADoctor+ADepartment+ASampleshavenotbeensent+ASampleisnotforthepatient+ABloodhavenotbeenordered4+ABarcodePatient+AThebloodProductisnotforthepatient+AThebloodisforthepatient+APatienttemppressure_highpressure_lowpulse+AMoreblood+ABarcode5+ANShowPatientInfoNOrderBlood+AReactiontype+ATransfusionNurse+Aouttimelessthen05h+Aouttimelessthan4h6+ABloodOrderquantityexpectTime+ABlood+ANSendSampleNCollectBlood+Abloodtypeisunknownorscreeningisnotdoneorinvalidscreenisvalidwithin4days+ASampleshavenotbeenordered+ANperformtransfusionNMeasuretemperaturebloodpressureandpulse+ANMeasuretemperaturebloodpressureandpulseNperformtransfusion+ASampleLabelFile+ALabel+ANInitNScanNurseCard}

//No dangle edges after a transformation
pred no_dangle_arrow[trans:Trans]{
	all arrow : ANOrderSampleNSelectBookpreexamination|(arrow.src in trans.dnodes or arrow.trg in trans.dnodes) implies arrow in trans.darrows
	all arrow : ANOrderSampleNSelectBookpreexamination|(arrow.src in trans.anodes or arrow.trg in trans.anodes) implies arrow in trans.aarrows
	all arrow : ANSelectBookpreexaminationNSendSampleOrder|(arrow.src in trans.dnodes or arrow.trg in trans.dnodes) implies arrow in trans.darrows
	all arrow : ANSelectBookpreexaminationNSendSampleOrder|(arrow.src in trans.anodes or arrow.trg in trans.anodes) implies arrow in trans.aarrows
	all arrow : ANperformtransfusionNIdentifynurselogtransfusion|(arrow.src in trans.dnodes or arrow.trg in trans.dnodes) implies arrow in trans.darrows
	all arrow : ANperformtransfusionNIdentifynurselogtransfusion|(arrow.src in trans.anodes or arrow.trg in trans.anodes) implies arrow in trans.aarrows
	all arrow : Aouttimelessthan4h|(arrow.src in trans.dnodes or arrow.trg in trans.dnodes) implies arrow in trans.darrows
	all arrow : Aouttimelessthan4h|(arrow.src in trans.anodes or arrow.trg in trans.anodes) implies arrow in trans.aarrows
	all arrow : ANShowNurseInfoNScanPatientWristband|(arrow.src in trans.dnodes or arrow.trg in trans.dnodes) implies arrow in trans.darrows
	all arrow : ANShowNurseInfoNScanPatientWristband|(arrow.src in trans.anodes or arrow.trg in trans.anodes) implies arrow in trans.aarrows
	all arrow : APatienthasnotbeenbloodtyped|(arrow.src in trans.dnodes or arrow.trg in trans.dnodes) implies arrow in trans.darrows
	all arrow : APatienthasnotbeenbloodtyped|(arrow.src in trans.anodes or arrow.trg in trans.anodes) implies arrow in trans.aarrows
	all arrow : ANSelectBlodTypeingNSendSampleOrder|(arrow.src in trans.dnodes or arrow.trg in trans.dnodes) implies arrow in trans.darrows
	all arrow : ANSelectBlodTypeingNSendSampleOrder|(arrow.src in trans.anodes or arrow.trg in trans.anodes) implies arrow in trans.aarrows
	all arrow : ANursename|(arrow.src in trans.dnodes or arrow.trg in trans.dnodes) implies arrow in trans.darrows
	all arrow : ANursename|(arrow.src in trans.anodes or arrow.trg in trans.anodes) implies arrow in trans.aarrows
	all arrow : ANurseisnotfound|(arrow.src in trans.dnodes or arrow.trg in trans.dnodes) implies arrow in trans.darrows
	all arrow : ANurseisnotfound|(arrow.src in trans.anodes or arrow.trg in trans.anodes) implies arrow in trans.aarrows
	all arrow : ABarcode|(arrow.src in trans.dnodes or arrow.trg in trans.dnodes) implies arrow in trans.darrows
	all arrow : ABarcode|(arrow.src in trans.anodes or arrow.trg in trans.anodes) implies arrow in trans.aarrows
	all arrow : APatientnameIDgenderblodtypescreening|(arrow.src in trans.dnodes or arrow.trg in trans.dnodes) implies arrow in trans.darrows
	all arrow : APatientnameIDgenderblodtypescreening|(arrow.src in trans.anodes or arrow.trg in trans.anodes) implies arrow in trans.aarrows
	all arrow : APatientisnotfound|(arrow.src in trans.dnodes or arrow.trg in trans.dnodes) implies arrow in trans.darrows
	all arrow : APatientisnotfound|(arrow.src in trans.anodes or arrow.trg in trans.anodes) implies arrow in trans.aarrows
	all arrow : ASample|(arrow.src in trans.dnodes or arrow.trg in trans.dnodes) implies arrow in trans.darrows
	all arrow : ASample|(arrow.src in trans.anodes or arrow.trg in trans.anodes) implies arrow in trans.aarrows
	all arrow : ABarcode1|(arrow.src in trans.dnodes or arrow.trg in trans.dnodes) implies arrow in trans.darrows
	all arrow : ABarcode1|(arrow.src in trans.anodes or arrow.trg in trans.anodes) implies arrow in trans.aarrows
	all arrow : ABarcode2|(arrow.src in trans.dnodes or arrow.trg in trans.dnodes) implies arrow in trans.darrows
	all arrow : ABarcode2|(arrow.src in trans.anodes or arrow.trg in trans.anodes) implies arrow in trans.aarrows
	all arrow : APatient|(arrow.src in trans.dnodes or arrow.trg in trans.dnodes) implies arrow in trans.darrows
	all arrow : APatient|(arrow.src in trans.anodes or arrow.trg in trans.anodes) implies arrow in trans.aarrows
	all arrow : ABloodhavenotbeenordered|(arrow.src in trans.dnodes or arrow.trg in trans.dnodes) implies arrow in trans.darrows
	all arrow : ABloodhavenotbeenordered|(arrow.src in trans.anodes or arrow.trg in trans.anodes) implies arrow in trans.aarrows
	all arrow : ANCollectSampleNScanSample|(arrow.src in trans.dnodes or arrow.trg in trans.dnodes) implies arrow in trans.darrows
	all arrow : ANCollectSampleNScanSample|(arrow.src in trans.anodes or arrow.trg in trans.anodes) implies arrow in trans.aarrows
	all arrow : ANOrderBloodNSelectBloodProduct|(arrow.src in trans.dnodes or arrow.trg in trans.dnodes) implies arrow in trans.darrows
	all arrow : ANOrderBloodNSelectBloodProduct|(arrow.src in trans.anodes or arrow.trg in trans.anodes) implies arrow in trans.aarrows
	all arrow : ABarcode3|(arrow.src in trans.dnodes or arrow.trg in trans.dnodes) implies arrow in trans.darrows
	all arrow : ABarcode3|(arrow.src in trans.anodes or arrow.trg in trans.anodes) implies arrow in trans.aarrows
	all arrow : ADoctor|(arrow.src in trans.dnodes or arrow.trg in trans.dnodes) implies arrow in trans.darrows
	all arrow : ADoctor|(arrow.src in trans.anodes or arrow.trg in trans.anodes) implies arrow in trans.aarrows
	all arrow : ADepartment|(arrow.src in trans.dnodes or arrow.trg in trans.dnodes) implies arrow in trans.darrows
	all arrow : ADepartment|(arrow.src in trans.anodes or arrow.trg in trans.anodes) implies arrow in trans.aarrows
	all arrow : ASampleshavenotbeensent|(arrow.src in trans.dnodes or arrow.trg in trans.dnodes) implies arrow in trans.darrows
	all arrow : ASampleshavenotbeensent|(arrow.src in trans.anodes or arrow.trg in trans.anodes) implies arrow in trans.aarrows
	all arrow : ASampleisnotforthepatient|(arrow.src in trans.dnodes or arrow.trg in trans.dnodes) implies arrow in trans.darrows
	all arrow : ASampleisnotforthepatient|(arrow.src in trans.anodes or arrow.trg in trans.anodes) implies arrow in trans.aarrows
	all arrow : ABloodhavenotbeenordered4|(arrow.src in trans.dnodes or arrow.trg in trans.dnodes) implies arrow in trans.darrows
	all arrow : ABloodhavenotbeenordered4|(arrow.src in trans.anodes or arrow.trg in trans.anodes) implies arrow in trans.aarrows
	all arrow : ABarcodePatient|(arrow.src in trans.dnodes or arrow.trg in trans.dnodes) implies arrow in trans.darrows
	all arrow : ABarcodePatient|(arrow.src in trans.anodes or arrow.trg in trans.anodes) implies arrow in trans.aarrows
	all arrow : AThebloodProductisnotforthepatient|(arrow.src in trans.dnodes or arrow.trg in trans.dnodes) implies arrow in trans.darrows
	all arrow : AThebloodProductisnotforthepatient|(arrow.src in trans.anodes or arrow.trg in trans.anodes) implies arrow in trans.aarrows
	all arrow : AThebloodisforthepatient|(arrow.src in trans.dnodes or arrow.trg in trans.dnodes) implies arrow in trans.darrows
	all arrow : AThebloodisforthepatient|(arrow.src in trans.anodes or arrow.trg in trans.anodes) implies arrow in trans.aarrows
	all arrow : APatienttemppressure_highpressure_lowpulse|(arrow.src in trans.dnodes or arrow.trg in trans.dnodes) implies arrow in trans.darrows
	all arrow : APatienttemppressure_highpressure_lowpulse|(arrow.src in trans.anodes or arrow.trg in trans.anodes) implies arrow in trans.aarrows
	all arrow : AMoreblood|(arrow.src in trans.dnodes or arrow.trg in trans.dnodes) implies arrow in trans.darrows
	all arrow : AMoreblood|(arrow.src in trans.anodes or arrow.trg in trans.anodes) implies arrow in trans.aarrows
	all arrow : ABarcode5|(arrow.src in trans.dnodes or arrow.trg in trans.dnodes) implies arrow in trans.darrows
	all arrow : ABarcode5|(arrow.src in trans.anodes or arrow.trg in trans.anodes) implies arrow in trans.aarrows
	all arrow : ANShowPatientInfoNOrderBlood|(arrow.src in trans.dnodes or arrow.trg in trans.dnodes) implies arrow in trans.darrows
	all arrow : ANShowPatientInfoNOrderBlood|(arrow.src in trans.anodes or arrow.trg in trans.anodes) implies arrow in trans.aarrows
	all arrow : AReactiontype|(arrow.src in trans.dnodes or arrow.trg in trans.dnodes) implies arrow in trans.darrows
	all arrow : AReactiontype|(arrow.src in trans.anodes or arrow.trg in trans.anodes) implies arrow in trans.aarrows
	all arrow : ATransfusionNurse|(arrow.src in trans.dnodes or arrow.trg in trans.dnodes) implies arrow in trans.darrows
	all arrow : ATransfusionNurse|(arrow.src in trans.anodes or arrow.trg in trans.anodes) implies arrow in trans.aarrows
	all arrow : Aouttimelessthen05h|(arrow.src in trans.dnodes or arrow.trg in trans.dnodes) implies arrow in trans.darrows
	all arrow : Aouttimelessthen05h|(arrow.src in trans.anodes or arrow.trg in trans.anodes) implies arrow in trans.aarrows
	all arrow : Aouttimelessthan4h6|(arrow.src in trans.dnodes or arrow.trg in trans.dnodes) implies arrow in trans.darrows
	all arrow : Aouttimelessthan4h6|(arrow.src in trans.anodes or arrow.trg in trans.anodes) implies arrow in trans.aarrows
	all arrow : ABloodOrderquantityexpectTime|(arrow.src in trans.dnodes or arrow.trg in trans.dnodes) implies arrow in trans.darrows
	all arrow : ABloodOrderquantityexpectTime|(arrow.src in trans.anodes or arrow.trg in trans.anodes) implies arrow in trans.aarrows
	all arrow : ABlood|(arrow.src in trans.dnodes or arrow.trg in trans.dnodes) implies arrow in trans.darrows
	all arrow : ABlood|(arrow.src in trans.anodes or arrow.trg in trans.anodes) implies arrow in trans.aarrows
	all arrow : ANSendSampleNCollectBlood|(arrow.src in trans.dnodes or arrow.trg in trans.dnodes) implies arrow in trans.darrows
	all arrow : ANSendSampleNCollectBlood|(arrow.src in trans.anodes or arrow.trg in trans.anodes) implies arrow in trans.aarrows
	all arrow : Abloodtypeisunknownorscreeningisnotdoneorinvalidscreenisvalidwithin4days|(arrow.src in trans.dnodes or arrow.trg in trans.dnodes) implies arrow in trans.darrows
	all arrow : Abloodtypeisunknownorscreeningisnotdoneorinvalidscreenisvalidwithin4days|(arrow.src in trans.anodes or arrow.trg in trans.anodes) implies arrow in trans.aarrows
	all arrow : ASampleshavenotbeenordered|(arrow.src in trans.dnodes or arrow.trg in trans.dnodes) implies arrow in trans.darrows
	all arrow : ASampleshavenotbeenordered|(arrow.src in trans.anodes or arrow.trg in trans.anodes) implies arrow in trans.aarrows
	all arrow : ANperformtransfusionNMeasuretemperaturebloodpressureandpulse|(arrow.src in trans.dnodes or arrow.trg in trans.dnodes) implies arrow in trans.darrows
	all arrow : ANperformtransfusionNMeasuretemperaturebloodpressureandpulse|(arrow.src in trans.anodes or arrow.trg in trans.anodes) implies arrow in trans.aarrows
	all arrow : ANMeasuretemperaturebloodpressureandpulseNperformtransfusion|(arrow.src in trans.dnodes or arrow.trg in trans.dnodes) implies arrow in trans.darrows
	all arrow : ANMeasuretemperaturebloodpressureandpulseNperformtransfusion|(arrow.src in trans.anodes or arrow.trg in trans.anodes) implies arrow in trans.aarrows
	all arrow : ASampleLabelFile|(arrow.src in trans.dnodes or arrow.trg in trans.dnodes) implies arrow in trans.darrows
	all arrow : ASampleLabelFile|(arrow.src in trans.anodes or arrow.trg in trans.anodes) implies arrow in trans.aarrows
	all arrow : ALabel|(arrow.src in trans.dnodes or arrow.trg in trans.dnodes) implies arrow in trans.darrows
	all arrow : ALabel|(arrow.src in trans.anodes or arrow.trg in trans.anodes) implies arrow in trans.aarrows
	all arrow : ANInitNScanNurseCard|(arrow.src in trans.dnodes or arrow.trg in trans.dnodes) implies arrow in trans.darrows
	all arrow : ANInitNScanNurseCard|(arrow.src in trans.anodes or arrow.trg in trans.anodes) implies arrow in trans.aarrows
}

//general constraints for transformations
fact{
	(Trans.source+Trans.target)=Graph
	Rule=Trans.rule
	all graph:Graph|to_be_graph[graph]
	Graph.nodes=NScanPatientWristband+NSelectBookpreexamination+NSendSampleOrder+NOrderBlood+NCollectBlood+NMeasuretemperaturebloodpressureandpulse+Nperformtransfusion+NIdentifynurselogtransfusion+NScanNurseCard+NShowNurseInfo+NSelectBlodTypeing+NShowPatientInfo+NOrderSample+NGetNurseInfo+NGetPatientInfo+NGetSampleInfo+NScannPatientWristband+NScanSample+NGetPatientInfo0+NCollectSample+NSelectBloodProduct+NGetDoctorInfo+NSelectDepartment+NSendBloodOrder+NSendSample+NScanBloodProduct+NVerifyBloodProduct+NStopTransfusionContactAIT+NStorePatientCondition+NRegisterReaction+NStoreTransfusion+NPutBloodIntorefrigertor+NOrderBloodProduct+NPrintSampleLabel+NInit
	Graph.arrows=ANOrderSampleNSelectBookpreexamination+ANSelectBookpreexaminationNSendSampleOrder+ANperformtransfusionNIdentifynurselogtransfusion+Aouttimelessthan4h+ANShowNurseInfoNScanPatientWristband+APatienthasnotbeenbloodtyped+ANSelectBlodTypeingNSendSampleOrder+ANursename+ANurseisnotfound+ABarcode+APatientnameIDgenderblodtypescreening+APatientisnotfound+ASample+ABarcode1+ABarcode2+APatient+ABloodhavenotbeenordered+ANCollectSampleNScanSample+ANOrderBloodNSelectBloodProduct+ABarcode3+ADoctor+ADepartment+ASampleshavenotbeensent+ASampleisnotforthepatient+ABloodhavenotbeenordered4+ABarcodePatient+AThebloodProductisnotforthepatient+AThebloodisforthepatient+APatienttemppressure_highpressure_lowpulse+AMoreblood+ABarcode5+ANShowPatientInfoNOrderBlood+AReactiontype+ATransfusionNurse+Aouttimelessthen05h+Aouttimelessthan4h6+ABloodOrderquantityexpectTime+ABlood+ANSendSampleNCollectBlood+Abloodtypeisunknownorscreeningisnotdoneorinvalidscreenisvalidwithin4days+ASampleshavenotbeenordered+ANperformtransfusionNMeasuretemperaturebloodpressureandpulse+ANMeasuretemperaturebloodpressureandpulseNperformtransfusion+ASampleLabelFile+ALabel+ANInitNScanNurseCard
	all trans:Trans | no_dangle_arrow[trans] and trans_general[trans] and source_valid[trans] and (
	rule_CollectBloodPutBloodIntorefrigertor[trans] or rule_CollectBloodScanBloodProduct[trans] or rule_CollectSampleScanSample[trans] or rule_GetDoctorInfoSelectDepartment[trans] or rule_GetNurseInfoScanNurseCard[trans] or rule_GetNurseInfoShowNurseInfo[trans] or rule_GetPatientInfoScanPatientWristband[trans] or rule_GetPatientInfoScanSample[trans] or rule_GetPatientInfoSendSample[trans] or rule_GetPatientInfoShowPatientInfo[trans] or rule_GetSampleInfoScannPatientWristband[trans] or rule_IdentifynurselogtransfusionStoreTransfusion[trans] or rule_InitScanNurseCard[trans] or rule_MeasuretemperaturebloodpressureandpulseStorePatientCondition[trans] or rule_Measuretemperaturebloodpressureandpulseperformtransfusion[trans] or rule_OrderBloodProductCollectBlood[trans] or rule_OrderBloodSelectBloodProduct[trans] or rule_OrderSampleSelectBlodTypeing[trans] or rule_OrderSampleSelectBookpreexamination[trans] or rule_PrintSampleLabelCollectSample[trans] or rule_PutBloodIntorefrigertorScanBloodProduct[trans] or rule_ScanBloodProductVerifyBloodProduct[trans] or rule_ScanNurseCardGetNurseInfo[trans] or rule_ScanPatientWristbandGetPatientInfo[trans] or rule_ScanSampleGetSampleInfo[trans] or rule_ScannPatientWristbandGetPatientInfo[trans] or rule_SelectBlodTypeingSendSampleOrder[trans] or rule_SelectBloodProductGetDoctorInfo[trans] or rule_SelectBookpreexaminationSendSampleOrder[trans] or rule_SelectDepartmentSendBloodOrder[trans] or rule_SendBloodOrderOrderBloodProduct[trans] or rule_SendBloodOrderOrderSample[trans] or rule_SendBloodOrderScanSample[trans] or rule_SendSampleCollectBlood[trans] or rule_SendSampleOrderBlood[trans] or rule_SendSampleOrderOrderBlood[trans] or rule_SendSampleOrderPrintSampleLabel[trans] or rule_ShowNurseInfoScanPatientWristband[trans] or rule_ShowPatientInfoOrderBlood[trans] or rule_ShowPatientInfoOrderSample[trans] or rule_VerifyBloodProductStopTransfusionContactAIT[trans] or rule_VerifyBloodProductperformtransfusion[trans] or rule_performtransfusionIdentifynurselogtransfusion[trans] or rule_performtransfusionMeasuretemperaturebloodpressureandpulse[trans] or rule_performtransfusionRegisterReaction[trans] or rule_performtransfusionScanBloodProduct[trans])
}

//the predicate that the transformation is an application of the rule CollectBloodPutBloodIntorefrigertor
pred rule_CollectBloodPutBloodIntorefrigertor[trans:Trans]{
	some trans.rule&CollectBloodPutBloodIntorefrigertor


some e0:Aouttimelessthen05h&trans.aarrows|let n0=e0.src,n1=e0.trg|
	(n0 in (trans.source.nodes-trans.dnodes) and n1 in trans.anodes and (no nac:Aouttimelessthan4h&(trans.source.arrows-trans.darrows)|nac.src=n0) and (no nac:Aouttimelessthen05h&(trans.source.arrows-trans.darrows)|nac.src=n0))

	#NPutBloodIntorefrigertor&trans.anodes = 1
	#Aouttimelessthen05h&trans.aarrows = 1
	no trans.dnodes
	no (NScanPatientWristband+NSelectBookpreexamination+NSendSampleOrder+NOrderBlood+NCollectBlood+NMeasuretemperaturebloodpressureandpulse+Nperformtransfusion+NIdentifynurselogtransfusion+NScanNurseCard+NShowNurseInfo+NSelectBlodTypeing+NShowPatientInfo+NOrderSample+NGetNurseInfo+NGetPatientInfo+NGetSampleInfo+NScannPatientWristband+NScanSample+NGetPatientInfo0+NCollectSample+NSelectBloodProduct+NGetDoctorInfo+NSelectDepartment+NSendBloodOrder+NSendSample+NScanBloodProduct+NVerifyBloodProduct+NStopTransfusionContactAIT+NStorePatientCondition+NRegisterReaction+NStoreTransfusion+NOrderBloodProduct+NPrintSampleLabel+NInit)&trans.anodes
	no trans.darrows
	no (ANOrderSampleNSelectBookpreexamination+ANSelectBookpreexaminationNSendSampleOrder+ANperformtransfusionNIdentifynurselogtransfusion+Aouttimelessthan4h+ANShowNurseInfoNScanPatientWristband+APatienthasnotbeenbloodtyped+ANSelectBlodTypeingNSendSampleOrder+ANursename+ANurseisnotfound+ABarcode+APatientnameIDgenderblodtypescreening+APatientisnotfound+ASample+ABarcode1+ABarcode2+APatient+ABloodhavenotbeenordered+ANCollectSampleNScanSample+ANOrderBloodNSelectBloodProduct+ABarcode3+ADoctor+ADepartment+ASampleshavenotbeensent+ASampleisnotforthepatient+ABloodhavenotbeenordered4+ABarcodePatient+AThebloodProductisnotforthepatient+AThebloodisforthepatient+APatienttemppressure_highpressure_lowpulse+AMoreblood+ABarcode5+ANShowPatientInfoNOrderBlood+AReactiontype+ATransfusionNurse+Aouttimelessthan4h6+ABloodOrderquantityexpectTime+ABlood+ANSendSampleNCollectBlood+Abloodtypeisunknownorscreeningisnotdoneorinvalidscreenisvalidwithin4days+ASampleshavenotbeenordered+ANperformtransfusionNMeasuretemperaturebloodpressureandpulse+ANMeasuretemperaturebloodpressureandpulseNperformtransfusion+ASampleLabelFile+ALabel+ANInitNScanNurseCard)&trans.aarrows
}

//the predicate that the transformation is an application of the rule CollectBloodScanBloodProduct
pred rule_CollectBloodScanBloodProduct[trans:Trans]{
	some trans.rule&CollectBloodScanBloodProduct


some e0:Aouttimelessthan4h&trans.aarrows|let n0=e0.src,n1=e0.trg|
	(n0 in (trans.source.nodes-trans.dnodes) and n1 in trans.anodes and (no nac:Aouttimelessthan4h&(trans.source.arrows-trans.darrows)|nac.src=n0) and (no nac:Aouttimelessthen05h&(trans.source.arrows-trans.darrows)|nac.src=n0))

	#NScanBloodProduct&trans.anodes = 1
	#Aouttimelessthan4h&trans.aarrows = 1
	no trans.dnodes
	no (NScanPatientWristband+NSelectBookpreexamination+NSendSampleOrder+NOrderBlood+NCollectBlood+NMeasuretemperaturebloodpressureandpulse+Nperformtransfusion+NIdentifynurselogtransfusion+NScanNurseCard+NShowNurseInfo+NSelectBlodTypeing+NShowPatientInfo+NOrderSample+NGetNurseInfo+NGetPatientInfo+NGetSampleInfo+NScannPatientWristband+NScanSample+NGetPatientInfo0+NCollectSample+NSelectBloodProduct+NGetDoctorInfo+NSelectDepartment+NSendBloodOrder+NSendSample+NVerifyBloodProduct+NStopTransfusionContactAIT+NStorePatientCondition+NRegisterReaction+NStoreTransfusion+NPutBloodIntorefrigertor+NOrderBloodProduct+NPrintSampleLabel+NInit)&trans.anodes
	no trans.darrows
	no (ANOrderSampleNSelectBookpreexamination+ANSelectBookpreexaminationNSendSampleOrder+ANperformtransfusionNIdentifynurselogtransfusion+ANShowNurseInfoNScanPatientWristband+APatienthasnotbeenbloodtyped+ANSelectBlodTypeingNSendSampleOrder+ANursename+ANurseisnotfound+ABarcode+APatientnameIDgenderblodtypescreening+APatientisnotfound+ASample+ABarcode1+ABarcode2+APatient+ABloodhavenotbeenordered+ANCollectSampleNScanSample+ANOrderBloodNSelectBloodProduct+ABarcode3+ADoctor+ADepartment+ASampleshavenotbeensent+ASampleisnotforthepatient+ABloodhavenotbeenordered4+ABarcodePatient+AThebloodProductisnotforthepatient+AThebloodisforthepatient+APatienttemppressure_highpressure_lowpulse+AMoreblood+ABarcode5+ANShowPatientInfoNOrderBlood+AReactiontype+ATransfusionNurse+Aouttimelessthen05h+Aouttimelessthan4h6+ABloodOrderquantityexpectTime+ABlood+ANSendSampleNCollectBlood+Abloodtypeisunknownorscreeningisnotdoneorinvalidscreenisvalidwithin4days+ASampleshavenotbeenordered+ANperformtransfusionNMeasuretemperaturebloodpressureandpulse+ANMeasuretemperaturebloodpressureandpulseNperformtransfusion+ASampleLabelFile+ALabel+ANInitNScanNurseCard)&trans.aarrows
}

//the predicate that the transformation is an application of the rule CollectSampleScanSample
pred rule_CollectSampleScanSample[trans:Trans]{
	some trans.rule&CollectSampleScanSample


some e0:ANCollectSampleNScanSample&trans.aarrows|let n0=e0.src,n1=e0.trg|
	(n0 in (trans.source.nodes-trans.dnodes) and n1 in trans.anodes and (no nac:ANCollectSampleNScanSample&(trans.source.arrows-trans.darrows)|nac.src=n0))
no n:NSendBloodOrder&(trans.source.nodes-trans.dnodes)|(no nac:ASampleshavenotbeensent&(trans.source.arrows-trans.darrows)|nac.src=n) and (no nac:ABloodOrderquantityexpectTime&(trans.source.arrows-trans.darrows)|nac.src=n) and (no nac:ASampleshavenotbeenordered&(trans.source.arrows-trans.darrows)|nac.src=n)
	#NScanSample&trans.anodes = 1
	#ANCollectSampleNScanSample&trans.aarrows = 1
	no trans.dnodes
	no (NScanPatientWristband+NSelectBookpreexamination+NSendSampleOrder+NOrderBlood+NCollectBlood+NMeasuretemperaturebloodpressureandpulse+Nperformtransfusion+NIdentifynurselogtransfusion+NScanNurseCard+NShowNurseInfo+NSelectBlodTypeing+NShowPatientInfo+NOrderSample+NGetNurseInfo+NGetPatientInfo+NGetSampleInfo+NScannPatientWristband+NGetPatientInfo0+NCollectSample+NSelectBloodProduct+NGetDoctorInfo+NSelectDepartment+NSendBloodOrder+NSendSample+NScanBloodProduct+NVerifyBloodProduct+NStopTransfusionContactAIT+NStorePatientCondition+NRegisterReaction+NStoreTransfusion+NPutBloodIntorefrigertor+NOrderBloodProduct+NPrintSampleLabel+NInit)&trans.anodes
	no trans.darrows
	no (ANOrderSampleNSelectBookpreexamination+ANSelectBookpreexaminationNSendSampleOrder+ANperformtransfusionNIdentifynurselogtransfusion+Aouttimelessthan4h+ANShowNurseInfoNScanPatientWristband+APatienthasnotbeenbloodtyped+ANSelectBlodTypeingNSendSampleOrder+ANursename+ANurseisnotfound+ABarcode+APatientnameIDgenderblodtypescreening+APatientisnotfound+ASample+ABarcode1+ABarcode2+APatient+ABloodhavenotbeenordered+ANOrderBloodNSelectBloodProduct+ABarcode3+ADoctor+ADepartment+ASampleshavenotbeensent+ASampleisnotforthepatient+ABloodhavenotbeenordered4+ABarcodePatient+AThebloodProductisnotforthepatient+AThebloodisforthepatient+APatienttemppressure_highpressure_lowpulse+AMoreblood+ABarcode5+ANShowPatientInfoNOrderBlood+AReactiontype+ATransfusionNurse+Aouttimelessthen05h+Aouttimelessthan4h6+ABloodOrderquantityexpectTime+ABlood+ANSendSampleNCollectBlood+Abloodtypeisunknownorscreeningisnotdoneorinvalidscreenisvalidwithin4days+ASampleshavenotbeenordered+ANperformtransfusionNMeasuretemperaturebloodpressureandpulse+ANMeasuretemperaturebloodpressureandpulseNperformtransfusion+ASampleLabelFile+ALabel+ANInitNScanNurseCard)&trans.aarrows
}

//the predicate that the transformation is an application of the rule GetDoctorInfoSelectDepartment
pred rule_GetDoctorInfoSelectDepartment[trans:Trans]{
	some trans.rule&GetDoctorInfoSelectDepartment


some e0:ADoctor&trans.aarrows|let n0=e0.src,n1=e0.trg|
	(n0 in (trans.source.nodes-trans.dnodes) and n1 in trans.anodes and (no nac:ADoctor&(trans.source.arrows-trans.darrows)|nac.src=n0))

	#NSelectDepartment&trans.anodes = 1
	#ADoctor&trans.aarrows = 1
	no trans.dnodes
	no (NScanPatientWristband+NSelectBookpreexamination+NSendSampleOrder+NOrderBlood+NCollectBlood+NMeasuretemperaturebloodpressureandpulse+Nperformtransfusion+NIdentifynurselogtransfusion+NScanNurseCard+NShowNurseInfo+NSelectBlodTypeing+NShowPatientInfo+NOrderSample+NGetNurseInfo+NGetPatientInfo+NGetSampleInfo+NScannPatientWristband+NScanSample+NGetPatientInfo0+NCollectSample+NSelectBloodProduct+NGetDoctorInfo+NSendBloodOrder+NSendSample+NScanBloodProduct+NVerifyBloodProduct+NStopTransfusionContactAIT+NStorePatientCondition+NRegisterReaction+NStoreTransfusion+NPutBloodIntorefrigertor+NOrderBloodProduct+NPrintSampleLabel+NInit)&trans.anodes
	no trans.darrows
	no (ANOrderSampleNSelectBookpreexamination+ANSelectBookpreexaminationNSendSampleOrder+ANperformtransfusionNIdentifynurselogtransfusion+Aouttimelessthan4h+ANShowNurseInfoNScanPatientWristband+APatienthasnotbeenbloodtyped+ANSelectBlodTypeingNSendSampleOrder+ANursename+ANurseisnotfound+ABarcode+APatientnameIDgenderblodtypescreening+APatientisnotfound+ASample+ABarcode1+ABarcode2+APatient+ABloodhavenotbeenordered+ANCollectSampleNScanSample+ANOrderBloodNSelectBloodProduct+ABarcode3+ADepartment+ASampleshavenotbeensent+ASampleisnotforthepatient+ABloodhavenotbeenordered4+ABarcodePatient+AThebloodProductisnotforthepatient+AThebloodisforthepatient+APatienttemppressure_highpressure_lowpulse+AMoreblood+ABarcode5+ANShowPatientInfoNOrderBlood+AReactiontype+ATransfusionNurse+Aouttimelessthen05h+Aouttimelessthan4h6+ABloodOrderquantityexpectTime+ABlood+ANSendSampleNCollectBlood+Abloodtypeisunknownorscreeningisnotdoneorinvalidscreenisvalidwithin4days+ASampleshavenotbeenordered+ANperformtransfusionNMeasuretemperaturebloodpressureandpulse+ANMeasuretemperaturebloodpressureandpulseNperformtransfusion+ASampleLabelFile+ALabel+ANInitNScanNurseCard)&trans.aarrows
}

//the predicate that the transformation is an application of the rule GetNurseInfoScanNurseCard
pred rule_GetNurseInfoScanNurseCard[trans:Trans]{
	some trans.rule&GetNurseInfoScanNurseCard


some e0:ANurseisnotfound&trans.aarrows|let n0=e0.src,n1=e0.trg|
	(n0 in (trans.source.nodes-trans.dnodes) and n1 in trans.anodes and (no nac:ANursename&(trans.source.arrows-trans.darrows)|nac.src=n0) and (no nac:ANurseisnotfound&(trans.source.arrows-trans.darrows)|nac.src=n0))

	#NScanNurseCard&trans.anodes = 1
	#ANurseisnotfound&trans.aarrows = 1
	no trans.dnodes
	no (NScanPatientWristband+NSelectBookpreexamination+NSendSampleOrder+NOrderBlood+NCollectBlood+NMeasuretemperaturebloodpressureandpulse+Nperformtransfusion+NIdentifynurselogtransfusion+NShowNurseInfo+NSelectBlodTypeing+NShowPatientInfo+NOrderSample+NGetNurseInfo+NGetPatientInfo+NGetSampleInfo+NScannPatientWristband+NScanSample+NGetPatientInfo0+NCollectSample+NSelectBloodProduct+NGetDoctorInfo+NSelectDepartment+NSendBloodOrder+NSendSample+NScanBloodProduct+NVerifyBloodProduct+NStopTransfusionContactAIT+NStorePatientCondition+NRegisterReaction+NStoreTransfusion+NPutBloodIntorefrigertor+NOrderBloodProduct+NPrintSampleLabel+NInit)&trans.anodes
	no trans.darrows
	no (ANOrderSampleNSelectBookpreexamination+ANSelectBookpreexaminationNSendSampleOrder+ANperformtransfusionNIdentifynurselogtransfusion+Aouttimelessthan4h+ANShowNurseInfoNScanPatientWristband+APatienthasnotbeenbloodtyped+ANSelectBlodTypeingNSendSampleOrder+ANursename+ABarcode+APatientnameIDgenderblodtypescreening+APatientisnotfound+ASample+ABarcode1+ABarcode2+APatient+ABloodhavenotbeenordered+ANCollectSampleNScanSample+ANOrderBloodNSelectBloodProduct+ABarcode3+ADoctor+ADepartment+ASampleshavenotbeensent+ASampleisnotforthepatient+ABloodhavenotbeenordered4+ABarcodePatient+AThebloodProductisnotforthepatient+AThebloodisforthepatient+APatienttemppressure_highpressure_lowpulse+AMoreblood+ABarcode5+ANShowPatientInfoNOrderBlood+AReactiontype+ATransfusionNurse+Aouttimelessthen05h+Aouttimelessthan4h6+ABloodOrderquantityexpectTime+ABlood+ANSendSampleNCollectBlood+Abloodtypeisunknownorscreeningisnotdoneorinvalidscreenisvalidwithin4days+ASampleshavenotbeenordered+ANperformtransfusionNMeasuretemperaturebloodpressureandpulse+ANMeasuretemperaturebloodpressureandpulseNperformtransfusion+ASampleLabelFile+ALabel+ANInitNScanNurseCard)&trans.aarrows
}

//the predicate that the transformation is an application of the rule GetNurseInfoShowNurseInfo
pred rule_GetNurseInfoShowNurseInfo[trans:Trans]{
	some trans.rule&GetNurseInfoShowNurseInfo


some e0:ANursename&trans.aarrows|let n0=e0.src,n1=e0.trg|
	(n0 in (trans.source.nodes-trans.dnodes) and n1 in trans.anodes and (no nac:ANursename&(trans.source.arrows-trans.darrows)|nac.src=n0) and (no nac:ANurseisnotfound&(trans.source.arrows-trans.darrows)|nac.src=n0))

	#NShowNurseInfo&trans.anodes = 1
	#ANursename&trans.aarrows = 1
	no trans.dnodes
	no (NScanPatientWristband+NSelectBookpreexamination+NSendSampleOrder+NOrderBlood+NCollectBlood+NMeasuretemperaturebloodpressureandpulse+Nperformtransfusion+NIdentifynurselogtransfusion+NScanNurseCard+NSelectBlodTypeing+NShowPatientInfo+NOrderSample+NGetNurseInfo+NGetPatientInfo+NGetSampleInfo+NScannPatientWristband+NScanSample+NGetPatientInfo0+NCollectSample+NSelectBloodProduct+NGetDoctorInfo+NSelectDepartment+NSendBloodOrder+NSendSample+NScanBloodProduct+NVerifyBloodProduct+NStopTransfusionContactAIT+NStorePatientCondition+NRegisterReaction+NStoreTransfusion+NPutBloodIntorefrigertor+NOrderBloodProduct+NPrintSampleLabel+NInit)&trans.anodes
	no trans.darrows
	no (ANOrderSampleNSelectBookpreexamination+ANSelectBookpreexaminationNSendSampleOrder+ANperformtransfusionNIdentifynurselogtransfusion+Aouttimelessthan4h+ANShowNurseInfoNScanPatientWristband+APatienthasnotbeenbloodtyped+ANSelectBlodTypeingNSendSampleOrder+ANurseisnotfound+ABarcode+APatientnameIDgenderblodtypescreening+APatientisnotfound+ASample+ABarcode1+ABarcode2+APatient+ABloodhavenotbeenordered+ANCollectSampleNScanSample+ANOrderBloodNSelectBloodProduct+ABarcode3+ADoctor+ADepartment+ASampleshavenotbeensent+ASampleisnotforthepatient+ABloodhavenotbeenordered4+ABarcodePatient+AThebloodProductisnotforthepatient+AThebloodisforthepatient+APatienttemppressure_highpressure_lowpulse+AMoreblood+ABarcode5+ANShowPatientInfoNOrderBlood+AReactiontype+ATransfusionNurse+Aouttimelessthen05h+Aouttimelessthan4h6+ABloodOrderquantityexpectTime+ABlood+ANSendSampleNCollectBlood+Abloodtypeisunknownorscreeningisnotdoneorinvalidscreenisvalidwithin4days+ASampleshavenotbeenordered+ANperformtransfusionNMeasuretemperaturebloodpressureandpulse+ANMeasuretemperaturebloodpressureandpulseNperformtransfusion+ASampleLabelFile+ALabel+ANInitNScanNurseCard)&trans.aarrows
}

//the predicate that the transformation is an application of the rule GetPatientInfoScanPatientWristband
pred rule_GetPatientInfoScanPatientWristband[trans:Trans]{
	some trans.rule&GetPatientInfoScanPatientWristband


some e0:APatientisnotfound&trans.aarrows|let n0=e0.src,n1=e0.trg|
	(n0 in (trans.source.nodes-trans.dnodes) and n1 in trans.anodes and (no nac:APatientnameIDgenderblodtypescreening&(trans.source.arrows-trans.darrows)|nac.src=n0) and (no nac:APatientisnotfound&(trans.source.arrows-trans.darrows)|nac.src=n0))

	#NScanPatientWristband&trans.anodes = 1
	#APatientisnotfound&trans.aarrows = 1
	no trans.dnodes
	no (NSelectBookpreexamination+NSendSampleOrder+NOrderBlood+NCollectBlood+NMeasuretemperaturebloodpressureandpulse+Nperformtransfusion+NIdentifynurselogtransfusion+NScanNurseCard+NShowNurseInfo+NSelectBlodTypeing+NShowPatientInfo+NOrderSample+NGetNurseInfo+NGetPatientInfo+NGetSampleInfo+NScannPatientWristband+NScanSample+NGetPatientInfo0+NCollectSample+NSelectBloodProduct+NGetDoctorInfo+NSelectDepartment+NSendBloodOrder+NSendSample+NScanBloodProduct+NVerifyBloodProduct+NStopTransfusionContactAIT+NStorePatientCondition+NRegisterReaction+NStoreTransfusion+NPutBloodIntorefrigertor+NOrderBloodProduct+NPrintSampleLabel+NInit)&trans.anodes
	no trans.darrows
	no (ANOrderSampleNSelectBookpreexamination+ANSelectBookpreexaminationNSendSampleOrder+ANperformtransfusionNIdentifynurselogtransfusion+Aouttimelessthan4h+ANShowNurseInfoNScanPatientWristband+APatienthasnotbeenbloodtyped+ANSelectBlodTypeingNSendSampleOrder+ANursename+ANurseisnotfound+ABarcode+APatientnameIDgenderblodtypescreening+ASample+ABarcode1+ABarcode2+APatient+ABloodhavenotbeenordered+ANCollectSampleNScanSample+ANOrderBloodNSelectBloodProduct+ABarcode3+ADoctor+ADepartment+ASampleshavenotbeensent+ASampleisnotforthepatient+ABloodhavenotbeenordered4+ABarcodePatient+AThebloodProductisnotforthepatient+AThebloodisforthepatient+APatienttemppressure_highpressure_lowpulse+AMoreblood+ABarcode5+ANShowPatientInfoNOrderBlood+AReactiontype+ATransfusionNurse+Aouttimelessthen05h+Aouttimelessthan4h6+ABloodOrderquantityexpectTime+ABlood+ANSendSampleNCollectBlood+Abloodtypeisunknownorscreeningisnotdoneorinvalidscreenisvalidwithin4days+ASampleshavenotbeenordered+ANperformtransfusionNMeasuretemperaturebloodpressureandpulse+ANMeasuretemperaturebloodpressureandpulseNperformtransfusion+ASampleLabelFile+ALabel+ANInitNScanNurseCard)&trans.aarrows
}

//the predicate that the transformation is an application of the rule GetPatientInfoScanSample
pred rule_GetPatientInfoScanSample[trans:Trans]{
	some trans.rule&GetPatientInfoScanSample


some e0:ASampleisnotforthepatient&trans.aarrows|let n0=e0.src,n1=e0.trg|
	(n0 in (trans.source.nodes-trans.dnodes) and n1 in trans.anodes and (no nac:APatient&(trans.source.arrows-trans.darrows)|nac.src=n0) and (no nac:ASampleisnotforthepatient&(trans.source.arrows-trans.darrows)|nac.src=n0))

	#NScanSample&trans.anodes = 1
	#ASampleisnotforthepatient&trans.aarrows = 1
	no trans.dnodes
	no (NScanPatientWristband+NSelectBookpreexamination+NSendSampleOrder+NOrderBlood+NCollectBlood+NMeasuretemperaturebloodpressureandpulse+Nperformtransfusion+NIdentifynurselogtransfusion+NScanNurseCard+NShowNurseInfo+NSelectBlodTypeing+NShowPatientInfo+NOrderSample+NGetNurseInfo+NGetPatientInfo+NGetSampleInfo+NScannPatientWristband+NGetPatientInfo0+NCollectSample+NSelectBloodProduct+NGetDoctorInfo+NSelectDepartment+NSendBloodOrder+NSendSample+NScanBloodProduct+NVerifyBloodProduct+NStopTransfusionContactAIT+NStorePatientCondition+NRegisterReaction+NStoreTransfusion+NPutBloodIntorefrigertor+NOrderBloodProduct+NPrintSampleLabel+NInit)&trans.anodes
	no trans.darrows
	no (ANOrderSampleNSelectBookpreexamination+ANSelectBookpreexaminationNSendSampleOrder+ANperformtransfusionNIdentifynurselogtransfusion+Aouttimelessthan4h+ANShowNurseInfoNScanPatientWristband+APatienthasnotbeenbloodtyped+ANSelectBlodTypeingNSendSampleOrder+ANursename+ANurseisnotfound+ABarcode+APatientnameIDgenderblodtypescreening+APatientisnotfound+ASample+ABarcode1+ABarcode2+APatient+ABloodhavenotbeenordered+ANCollectSampleNScanSample+ANOrderBloodNSelectBloodProduct+ABarcode3+ADoctor+ADepartment+ASampleshavenotbeensent+ABloodhavenotbeenordered4+ABarcodePatient+AThebloodProductisnotforthepatient+AThebloodisforthepatient+APatienttemppressure_highpressure_lowpulse+AMoreblood+ABarcode5+ANShowPatientInfoNOrderBlood+AReactiontype+ATransfusionNurse+Aouttimelessthen05h+Aouttimelessthan4h6+ABloodOrderquantityexpectTime+ABlood+ANSendSampleNCollectBlood+Abloodtypeisunknownorscreeningisnotdoneorinvalidscreenisvalidwithin4days+ASampleshavenotbeenordered+ANperformtransfusionNMeasuretemperaturebloodpressureandpulse+ANMeasuretemperaturebloodpressureandpulseNperformtransfusion+ASampleLabelFile+ALabel+ANInitNScanNurseCard)&trans.aarrows
}

//the predicate that the transformation is an application of the rule GetPatientInfoSendSample
pred rule_GetPatientInfoSendSample[trans:Trans]{
	some trans.rule&GetPatientInfoSendSample


some e0:APatient&trans.aarrows|let n0=e0.src,n1=e0.trg|
	(n0 in (trans.source.nodes-trans.dnodes) and n1 in trans.anodes and (no nac:APatient&(trans.source.arrows-trans.darrows)|nac.src=n0) and (no nac:ASampleisnotforthepatient&(trans.source.arrows-trans.darrows)|nac.src=n0))

	#NSendSample&trans.anodes = 1
	#APatient&trans.aarrows = 1
	no trans.dnodes
	no (NScanPatientWristband+NSelectBookpreexamination+NSendSampleOrder+NOrderBlood+NCollectBlood+NMeasuretemperaturebloodpressureandpulse+Nperformtransfusion+NIdentifynurselogtransfusion+NScanNurseCard+NShowNurseInfo+NSelectBlodTypeing+NShowPatientInfo+NOrderSample+NGetNurseInfo+NGetPatientInfo+NGetSampleInfo+NScannPatientWristband+NScanSample+NGetPatientInfo0+NCollectSample+NSelectBloodProduct+NGetDoctorInfo+NSelectDepartment+NSendBloodOrder+NScanBloodProduct+NVerifyBloodProduct+NStopTransfusionContactAIT+NStorePatientCondition+NRegisterReaction+NStoreTransfusion+NPutBloodIntorefrigertor+NOrderBloodProduct+NPrintSampleLabel+NInit)&trans.anodes
	no trans.darrows
	no (ANOrderSampleNSelectBookpreexamination+ANSelectBookpreexaminationNSendSampleOrder+ANperformtransfusionNIdentifynurselogtransfusion+Aouttimelessthan4h+ANShowNurseInfoNScanPatientWristband+APatienthasnotbeenbloodtyped+ANSelectBlodTypeingNSendSampleOrder+ANursename+ANurseisnotfound+ABarcode+APatientnameIDgenderblodtypescreening+APatientisnotfound+ASample+ABarcode1+ABarcode2+ABloodhavenotbeenordered+ANCollectSampleNScanSample+ANOrderBloodNSelectBloodProduct+ABarcode3+ADoctor+ADepartment+ASampleshavenotbeensent+ASampleisnotforthepatient+ABloodhavenotbeenordered4+ABarcodePatient+AThebloodProductisnotforthepatient+AThebloodisforthepatient+APatienttemppressure_highpressure_lowpulse+AMoreblood+ABarcode5+ANShowPatientInfoNOrderBlood+AReactiontype+ATransfusionNurse+Aouttimelessthen05h+Aouttimelessthan4h6+ABloodOrderquantityexpectTime+ABlood+ANSendSampleNCollectBlood+Abloodtypeisunknownorscreeningisnotdoneorinvalidscreenisvalidwithin4days+ASampleshavenotbeenordered+ANperformtransfusionNMeasuretemperaturebloodpressureandpulse+ANMeasuretemperaturebloodpressureandpulseNperformtransfusion+ASampleLabelFile+ALabel+ANInitNScanNurseCard)&trans.aarrows
}

//the predicate that the transformation is an application of the rule GetPatientInfoShowPatientInfo
pred rule_GetPatientInfoShowPatientInfo[trans:Trans]{
	some trans.rule&GetPatientInfoShowPatientInfo


some e0:APatientnameIDgenderblodtypescreening&trans.aarrows|let n0=e0.src,n1=e0.trg|
	(n0 in (trans.source.nodes-trans.dnodes) and n1 in trans.anodes and (no nac:APatientnameIDgenderblodtypescreening&(trans.source.arrows-trans.darrows)|nac.src=n0) and (no nac:APatientisnotfound&(trans.source.arrows-trans.darrows)|nac.src=n0))

	#NShowPatientInfo&trans.anodes = 1
	#APatientnameIDgenderblodtypescreening&trans.aarrows = 1
	no trans.dnodes
	no (NScanPatientWristband+NSelectBookpreexamination+NSendSampleOrder+NOrderBlood+NCollectBlood+NMeasuretemperaturebloodpressureandpulse+Nperformtransfusion+NIdentifynurselogtransfusion+NScanNurseCard+NShowNurseInfo+NSelectBlodTypeing+NOrderSample+NGetNurseInfo+NGetPatientInfo+NGetSampleInfo+NScannPatientWristband+NScanSample+NGetPatientInfo0+NCollectSample+NSelectBloodProduct+NGetDoctorInfo+NSelectDepartment+NSendBloodOrder+NSendSample+NScanBloodProduct+NVerifyBloodProduct+NStopTransfusionContactAIT+NStorePatientCondition+NRegisterReaction+NStoreTransfusion+NPutBloodIntorefrigertor+NOrderBloodProduct+NPrintSampleLabel+NInit)&trans.anodes
	no trans.darrows
	no (ANOrderSampleNSelectBookpreexamination+ANSelectBookpreexaminationNSendSampleOrder+ANperformtransfusionNIdentifynurselogtransfusion+Aouttimelessthan4h+ANShowNurseInfoNScanPatientWristband+APatienthasnotbeenbloodtyped+ANSelectBlodTypeingNSendSampleOrder+ANursename+ANurseisnotfound+ABarcode+APatientisnotfound+ASample+ABarcode1+ABarcode2+APatient+ABloodhavenotbeenordered+ANCollectSampleNScanSample+ANOrderBloodNSelectBloodProduct+ABarcode3+ADoctor+ADepartment+ASampleshavenotbeensent+ASampleisnotforthepatient+ABloodhavenotbeenordered4+ABarcodePatient+AThebloodProductisnotforthepatient+AThebloodisforthepatient+APatienttemppressure_highpressure_lowpulse+AMoreblood+ABarcode5+ANShowPatientInfoNOrderBlood+AReactiontype+ATransfusionNurse+Aouttimelessthen05h+Aouttimelessthan4h6+ABloodOrderquantityexpectTime+ABlood+ANSendSampleNCollectBlood+Abloodtypeisunknownorscreeningisnotdoneorinvalidscreenisvalidwithin4days+ASampleshavenotbeenordered+ANperformtransfusionNMeasuretemperaturebloodpressureandpulse+ANMeasuretemperaturebloodpressureandpulseNperformtransfusion+ASampleLabelFile+ALabel+ANInitNScanNurseCard)&trans.aarrows
}

//the predicate that the transformation is an application of the rule GetSampleInfoScannPatientWristband
pred rule_GetSampleInfoScannPatientWristband[trans:Trans]{
	some trans.rule&GetSampleInfoScannPatientWristband


some e0:ASample&trans.aarrows|let n0=e0.src,n1=e0.trg|
	(n0 in (trans.source.nodes-trans.dnodes) and n1 in trans.anodes and (no nac:ASample&(trans.source.arrows-trans.darrows)|nac.src=n0))

	#NScannPatientWristband&trans.anodes = 1
	#ASample&trans.aarrows = 1
	no trans.dnodes
	no (NScanPatientWristband+NSelectBookpreexamination+NSendSampleOrder+NOrderBlood+NCollectBlood+NMeasuretemperaturebloodpressureandpulse+Nperformtransfusion+NIdentifynurselogtransfusion+NScanNurseCard+NShowNurseInfo+NSelectBlodTypeing+NShowPatientInfo+NOrderSample+NGetNurseInfo+NGetPatientInfo+NGetSampleInfo+NScanSample+NGetPatientInfo0+NCollectSample+NSelectBloodProduct+NGetDoctorInfo+NSelectDepartment+NSendBloodOrder+NSendSample+NScanBloodProduct+NVerifyBloodProduct+NStopTransfusionContactAIT+NStorePatientCondition+NRegisterReaction+NStoreTransfusion+NPutBloodIntorefrigertor+NOrderBloodProduct+NPrintSampleLabel+NInit)&trans.anodes
	no trans.darrows
	no (ANOrderSampleNSelectBookpreexamination+ANSelectBookpreexaminationNSendSampleOrder+ANperformtransfusionNIdentifynurselogtransfusion+Aouttimelessthan4h+ANShowNurseInfoNScanPatientWristband+APatienthasnotbeenbloodtyped+ANSelectBlodTypeingNSendSampleOrder+ANursename+ANurseisnotfound+ABarcode+APatientnameIDgenderblodtypescreening+APatientisnotfound+ABarcode1+ABarcode2+APatient+ABloodhavenotbeenordered+ANCollectSampleNScanSample+ANOrderBloodNSelectBloodProduct+ABarcode3+ADoctor+ADepartment+ASampleshavenotbeensent+ASampleisnotforthepatient+ABloodhavenotbeenordered4+ABarcodePatient+AThebloodProductisnotforthepatient+AThebloodisforthepatient+APatienttemppressure_highpressure_lowpulse+AMoreblood+ABarcode5+ANShowPatientInfoNOrderBlood+AReactiontype+ATransfusionNurse+Aouttimelessthen05h+Aouttimelessthan4h6+ABloodOrderquantityexpectTime+ABlood+ANSendSampleNCollectBlood+Abloodtypeisunknownorscreeningisnotdoneorinvalidscreenisvalidwithin4days+ASampleshavenotbeenordered+ANperformtransfusionNMeasuretemperaturebloodpressureandpulse+ANMeasuretemperaturebloodpressureandpulseNperformtransfusion+ASampleLabelFile+ALabel+ANInitNScanNurseCard)&trans.aarrows
}

//the predicate that the transformation is an application of the rule IdentifynurselogtransfusionStoreTransfusion
pred rule_IdentifynurselogtransfusionStoreTransfusion[trans:Trans]{
	some trans.rule&IdentifynurselogtransfusionStoreTransfusion


some e0:ATransfusionNurse&trans.aarrows|let n0=e0.src,n1=e0.trg|
	(n0 in (trans.source.nodes-trans.dnodes) and n1 in trans.anodes and (no nac:ATransfusionNurse&(trans.source.arrows-trans.darrows)|nac.src=n0))

	#NStoreTransfusion&trans.anodes = 1
	#ATransfusionNurse&trans.aarrows = 1
	no trans.dnodes
	no (NScanPatientWristband+NSelectBookpreexamination+NSendSampleOrder+NOrderBlood+NCollectBlood+NMeasuretemperaturebloodpressureandpulse+Nperformtransfusion+NIdentifynurselogtransfusion+NScanNurseCard+NShowNurseInfo+NSelectBlodTypeing+NShowPatientInfo+NOrderSample+NGetNurseInfo+NGetPatientInfo+NGetSampleInfo+NScannPatientWristband+NScanSample+NGetPatientInfo0+NCollectSample+NSelectBloodProduct+NGetDoctorInfo+NSelectDepartment+NSendBloodOrder+NSendSample+NScanBloodProduct+NVerifyBloodProduct+NStopTransfusionContactAIT+NStorePatientCondition+NRegisterReaction+NPutBloodIntorefrigertor+NOrderBloodProduct+NPrintSampleLabel+NInit)&trans.anodes
	no trans.darrows
	no (ANOrderSampleNSelectBookpreexamination+ANSelectBookpreexaminationNSendSampleOrder+ANperformtransfusionNIdentifynurselogtransfusion+Aouttimelessthan4h+ANShowNurseInfoNScanPatientWristband+APatienthasnotbeenbloodtyped+ANSelectBlodTypeingNSendSampleOrder+ANursename+ANurseisnotfound+ABarcode+APatientnameIDgenderblodtypescreening+APatientisnotfound+ASample+ABarcode1+ABarcode2+APatient+ABloodhavenotbeenordered+ANCollectSampleNScanSample+ANOrderBloodNSelectBloodProduct+ABarcode3+ADoctor+ADepartment+ASampleshavenotbeensent+ASampleisnotforthepatient+ABloodhavenotbeenordered4+ABarcodePatient+AThebloodProductisnotforthepatient+AThebloodisforthepatient+APatienttemppressure_highpressure_lowpulse+AMoreblood+ABarcode5+ANShowPatientInfoNOrderBlood+AReactiontype+Aouttimelessthen05h+Aouttimelessthan4h6+ABloodOrderquantityexpectTime+ABlood+ANSendSampleNCollectBlood+Abloodtypeisunknownorscreeningisnotdoneorinvalidscreenisvalidwithin4days+ASampleshavenotbeenordered+ANperformtransfusionNMeasuretemperaturebloodpressureandpulse+ANMeasuretemperaturebloodpressureandpulseNperformtransfusion+ASampleLabelFile+ALabel+ANInitNScanNurseCard)&trans.aarrows
}

//the predicate that the transformation is an application of the rule InitScanNurseCard
pred rule_InitScanNurseCard[trans:Trans]{
	some trans.rule&InitScanNurseCard


some e0:ANInitNScanNurseCard&trans.aarrows|let n0=e0.src,n1=e0.trg|
	(n0 in (trans.source.nodes-trans.dnodes) and n1 in trans.anodes and (no nac:ANInitNScanNurseCard&(trans.source.arrows-trans.darrows)|nac.src=n0))

	#NScanNurseCard&trans.anodes = 1
	#ANInitNScanNurseCard&trans.aarrows = 1
	no trans.dnodes
	no (NScanPatientWristband+NSelectBookpreexamination+NSendSampleOrder+NOrderBlood+NCollectBlood+NMeasuretemperaturebloodpressureandpulse+Nperformtransfusion+NIdentifynurselogtransfusion+NShowNurseInfo+NSelectBlodTypeing+NShowPatientInfo+NOrderSample+NGetNurseInfo+NGetPatientInfo+NGetSampleInfo+NScannPatientWristband+NScanSample+NGetPatientInfo0+NCollectSample+NSelectBloodProduct+NGetDoctorInfo+NSelectDepartment+NSendBloodOrder+NSendSample+NScanBloodProduct+NVerifyBloodProduct+NStopTransfusionContactAIT+NStorePatientCondition+NRegisterReaction+NStoreTransfusion+NPutBloodIntorefrigertor+NOrderBloodProduct+NPrintSampleLabel+NInit)&trans.anodes
	no trans.darrows
	no (ANOrderSampleNSelectBookpreexamination+ANSelectBookpreexaminationNSendSampleOrder+ANperformtransfusionNIdentifynurselogtransfusion+Aouttimelessthan4h+ANShowNurseInfoNScanPatientWristband+APatienthasnotbeenbloodtyped+ANSelectBlodTypeingNSendSampleOrder+ANursename+ANurseisnotfound+ABarcode+APatientnameIDgenderblodtypescreening+APatientisnotfound+ASample+ABarcode1+ABarcode2+APatient+ABloodhavenotbeenordered+ANCollectSampleNScanSample+ANOrderBloodNSelectBloodProduct+ABarcode3+ADoctor+ADepartment+ASampleshavenotbeensent+ASampleisnotforthepatient+ABloodhavenotbeenordered4+ABarcodePatient+AThebloodProductisnotforthepatient+AThebloodisforthepatient+APatienttemppressure_highpressure_lowpulse+AMoreblood+ABarcode5+ANShowPatientInfoNOrderBlood+AReactiontype+ATransfusionNurse+Aouttimelessthen05h+Aouttimelessthan4h6+ABloodOrderquantityexpectTime+ABlood+ANSendSampleNCollectBlood+Abloodtypeisunknownorscreeningisnotdoneorinvalidscreenisvalidwithin4days+ASampleshavenotbeenordered+ANperformtransfusionNMeasuretemperaturebloodpressureandpulse+ANMeasuretemperaturebloodpressureandpulseNperformtransfusion+ASampleLabelFile+ALabel)&trans.aarrows
}

//the predicate that the transformation is an application of the rule MeasuretemperaturebloodpressureandpulseStorePatientCondition
pred rule_MeasuretemperaturebloodpressureandpulseStorePatientCondition[trans:Trans]{
	some trans.rule&MeasuretemperaturebloodpressureandpulseStorePatientCondition


some e0:APatienttemppressure_highpressure_lowpulse&trans.aarrows|let n0=e0.src,n1=e0.trg|
	(n0 in (trans.source.nodes-trans.dnodes) and n1 in trans.anodes and (no nac:APatienttemppressure_highpressure_lowpulse&(trans.source.arrows-trans.darrows)|nac.src=n0) and (no nac:ANMeasuretemperaturebloodpressureandpulseNperformtransfusion&(trans.source.arrows-trans.darrows)|nac.src=n0))

	#NStorePatientCondition&trans.anodes = 1
	#APatienttemppressure_highpressure_lowpulse&trans.aarrows = 1
	no trans.dnodes
	no (NScanPatientWristband+NSelectBookpreexamination+NSendSampleOrder+NOrderBlood+NCollectBlood+NMeasuretemperaturebloodpressureandpulse+Nperformtransfusion+NIdentifynurselogtransfusion+NScanNurseCard+NShowNurseInfo+NSelectBlodTypeing+NShowPatientInfo+NOrderSample+NGetNurseInfo+NGetPatientInfo+NGetSampleInfo+NScannPatientWristband+NScanSample+NGetPatientInfo0+NCollectSample+NSelectBloodProduct+NGetDoctorInfo+NSelectDepartment+NSendBloodOrder+NSendSample+NScanBloodProduct+NVerifyBloodProduct+NStopTransfusionContactAIT+NRegisterReaction+NStoreTransfusion+NPutBloodIntorefrigertor+NOrderBloodProduct+NPrintSampleLabel+NInit)&trans.anodes
	no trans.darrows
	no (ANOrderSampleNSelectBookpreexamination+ANSelectBookpreexaminationNSendSampleOrder+ANperformtransfusionNIdentifynurselogtransfusion+Aouttimelessthan4h+ANShowNurseInfoNScanPatientWristband+APatienthasnotbeenbloodtyped+ANSelectBlodTypeingNSendSampleOrder+ANursename+ANurseisnotfound+ABarcode+APatientnameIDgenderblodtypescreening+APatientisnotfound+ASample+ABarcode1+ABarcode2+APatient+ABloodhavenotbeenordered+ANCollectSampleNScanSample+ANOrderBloodNSelectBloodProduct+ABarcode3+ADoctor+ADepartment+ASampleshavenotbeensent+ASampleisnotforthepatient+ABloodhavenotbeenordered4+ABarcodePatient+AThebloodProductisnotforthepatient+AThebloodisforthepatient+AMoreblood+ABarcode5+ANShowPatientInfoNOrderBlood+AReactiontype+ATransfusionNurse+Aouttimelessthen05h+Aouttimelessthan4h6+ABloodOrderquantityexpectTime+ABlood+ANSendSampleNCollectBlood+Abloodtypeisunknownorscreeningisnotdoneorinvalidscreenisvalidwithin4days+ASampleshavenotbeenordered+ANperformtransfusionNMeasuretemperaturebloodpressureandpulse+ANMeasuretemperaturebloodpressureandpulseNperformtransfusion+ASampleLabelFile+ALabel+ANInitNScanNurseCard)&trans.aarrows
}

//the predicate that the transformation is an application of the rule Measuretemperaturebloodpressureandpulseperformtransfusion
pred rule_Measuretemperaturebloodpressureandpulseperformtransfusion[trans:Trans]{
	some trans.rule&Measuretemperaturebloodpressureandpulseperformtransfusion


some e0:ANMeasuretemperaturebloodpressureandpulseNperformtransfusion&trans.aarrows|let n0=e0.src,n1=e0.trg|
	(n0 in (trans.source.nodes-trans.dnodes) and n1 in trans.anodes and (no nac:APatienttemppressure_highpressure_lowpulse&(trans.source.arrows-trans.darrows)|nac.src=n0) and (no nac:ANMeasuretemperaturebloodpressureandpulseNperformtransfusion&(trans.source.arrows-trans.darrows)|nac.src=n0))

	#Nperformtransfusion&trans.anodes = 1
	#ANMeasuretemperaturebloodpressureandpulseNperformtransfusion&trans.aarrows = 1
	no trans.dnodes
	no (NScanPatientWristband+NSelectBookpreexamination+NSendSampleOrder+NOrderBlood+NCollectBlood+NMeasuretemperaturebloodpressureandpulse+NIdentifynurselogtransfusion+NScanNurseCard+NShowNurseInfo+NSelectBlodTypeing+NShowPatientInfo+NOrderSample+NGetNurseInfo+NGetPatientInfo+NGetSampleInfo+NScannPatientWristband+NScanSample+NGetPatientInfo0+NCollectSample+NSelectBloodProduct+NGetDoctorInfo+NSelectDepartment+NSendBloodOrder+NSendSample+NScanBloodProduct+NVerifyBloodProduct+NStopTransfusionContactAIT+NStorePatientCondition+NRegisterReaction+NStoreTransfusion+NPutBloodIntorefrigertor+NOrderBloodProduct+NPrintSampleLabel+NInit)&trans.anodes
	no trans.darrows
	no (ANOrderSampleNSelectBookpreexamination+ANSelectBookpreexaminationNSendSampleOrder+ANperformtransfusionNIdentifynurselogtransfusion+Aouttimelessthan4h+ANShowNurseInfoNScanPatientWristband+APatienthasnotbeenbloodtyped+ANSelectBlodTypeingNSendSampleOrder+ANursename+ANurseisnotfound+ABarcode+APatientnameIDgenderblodtypescreening+APatientisnotfound+ASample+ABarcode1+ABarcode2+APatient+ABloodhavenotbeenordered+ANCollectSampleNScanSample+ANOrderBloodNSelectBloodProduct+ABarcode3+ADoctor+ADepartment+ASampleshavenotbeensent+ASampleisnotforthepatient+ABloodhavenotbeenordered4+ABarcodePatient+AThebloodProductisnotforthepatient+AThebloodisforthepatient+APatienttemppressure_highpressure_lowpulse+AMoreblood+ABarcode5+ANShowPatientInfoNOrderBlood+AReactiontype+ATransfusionNurse+Aouttimelessthen05h+Aouttimelessthan4h6+ABloodOrderquantityexpectTime+ABlood+ANSendSampleNCollectBlood+Abloodtypeisunknownorscreeningisnotdoneorinvalidscreenisvalidwithin4days+ASampleshavenotbeenordered+ANperformtransfusionNMeasuretemperaturebloodpressureandpulse+ASampleLabelFile+ALabel+ANInitNScanNurseCard)&trans.aarrows
}

//the predicate that the transformation is an application of the rule OrderBloodProductCollectBlood
pred rule_OrderBloodProductCollectBlood[trans:Trans]{
	some trans.rule&OrderBloodProductCollectBlood


some e0:ABlood&trans.aarrows|let n0=e0.src,n1=e0.trg|
	(n0 in (trans.source.nodes-trans.dnodes) and n1 in trans.anodes and (no nac:ABlood&(trans.source.arrows-trans.darrows)|nac.src=n0))
no n:NSendSample&(trans.source.nodes-trans.dnodes)|(no nac:ABloodhavenotbeenordered4&(trans.source.arrows-trans.darrows)|nac.src=n) and (no nac:ANSendSampleNCollectBlood&(trans.source.arrows-trans.darrows)|nac.src=n)
	#NCollectBlood&trans.anodes = 1
	#ABlood&trans.aarrows = 1
	no trans.dnodes
	no (NScanPatientWristband+NSelectBookpreexamination+NSendSampleOrder+NOrderBlood+NMeasuretemperaturebloodpressureandpulse+Nperformtransfusion+NIdentifynurselogtransfusion+NScanNurseCard+NShowNurseInfo+NSelectBlodTypeing+NShowPatientInfo+NOrderSample+NGetNurseInfo+NGetPatientInfo+NGetSampleInfo+NScannPatientWristband+NScanSample+NGetPatientInfo0+NCollectSample+NSelectBloodProduct+NGetDoctorInfo+NSelectDepartment+NSendBloodOrder+NSendSample+NScanBloodProduct+NVerifyBloodProduct+NStopTransfusionContactAIT+NStorePatientCondition+NRegisterReaction+NStoreTransfusion+NPutBloodIntorefrigertor+NOrderBloodProduct+NPrintSampleLabel+NInit)&trans.anodes
	no trans.darrows
	no (ANOrderSampleNSelectBookpreexamination+ANSelectBookpreexaminationNSendSampleOrder+ANperformtransfusionNIdentifynurselogtransfusion+Aouttimelessthan4h+ANShowNurseInfoNScanPatientWristband+APatienthasnotbeenbloodtyped+ANSelectBlodTypeingNSendSampleOrder+ANursename+ANurseisnotfound+ABarcode+APatientnameIDgenderblodtypescreening+APatientisnotfound+ASample+ABarcode1+ABarcode2+APatient+ABloodhavenotbeenordered+ANCollectSampleNScanSample+ANOrderBloodNSelectBloodProduct+ABarcode3+ADoctor+ADepartment+ASampleshavenotbeensent+ASampleisnotforthepatient+ABloodhavenotbeenordered4+ABarcodePatient+AThebloodProductisnotforthepatient+AThebloodisforthepatient+APatienttemppressure_highpressure_lowpulse+AMoreblood+ABarcode5+ANShowPatientInfoNOrderBlood+AReactiontype+ATransfusionNurse+Aouttimelessthen05h+Aouttimelessthan4h6+ABloodOrderquantityexpectTime+ANSendSampleNCollectBlood+Abloodtypeisunknownorscreeningisnotdoneorinvalidscreenisvalidwithin4days+ASampleshavenotbeenordered+ANperformtransfusionNMeasuretemperaturebloodpressureandpulse+ANMeasuretemperaturebloodpressureandpulseNperformtransfusion+ASampleLabelFile+ALabel+ANInitNScanNurseCard)&trans.aarrows
}

//the predicate that the transformation is an application of the rule OrderBloodSelectBloodProduct
pred rule_OrderBloodSelectBloodProduct[trans:Trans]{
	some trans.rule&OrderBloodSelectBloodProduct


some e0:ANOrderBloodNSelectBloodProduct&trans.aarrows|let n0=e0.src,n1=e0.trg|
	(n0 in (trans.source.nodes-trans.dnodes) and n1 in trans.anodes and (no nac:ANOrderBloodNSelectBloodProduct&(trans.source.arrows-trans.darrows)|nac.src=n0))

	#NSelectBloodProduct&trans.anodes = 1
	#ANOrderBloodNSelectBloodProduct&trans.aarrows = 1
	no trans.dnodes
	no (NScanPatientWristband+NSelectBookpreexamination+NSendSampleOrder+NOrderBlood+NCollectBlood+NMeasuretemperaturebloodpressureandpulse+Nperformtransfusion+NIdentifynurselogtransfusion+NScanNurseCard+NShowNurseInfo+NSelectBlodTypeing+NShowPatientInfo+NOrderSample+NGetNurseInfo+NGetPatientInfo+NGetSampleInfo+NScannPatientWristband+NScanSample+NGetPatientInfo0+NCollectSample+NGetDoctorInfo+NSelectDepartment+NSendBloodOrder+NSendSample+NScanBloodProduct+NVerifyBloodProduct+NStopTransfusionContactAIT+NStorePatientCondition+NRegisterReaction+NStoreTransfusion+NPutBloodIntorefrigertor+NOrderBloodProduct+NPrintSampleLabel+NInit)&trans.anodes
	no trans.darrows
	no (ANOrderSampleNSelectBookpreexamination+ANSelectBookpreexaminationNSendSampleOrder+ANperformtransfusionNIdentifynurselogtransfusion+Aouttimelessthan4h+ANShowNurseInfoNScanPatientWristband+APatienthasnotbeenbloodtyped+ANSelectBlodTypeingNSendSampleOrder+ANursename+ANurseisnotfound+ABarcode+APatientnameIDgenderblodtypescreening+APatientisnotfound+ASample+ABarcode1+ABarcode2+APatient+ABloodhavenotbeenordered+ANCollectSampleNScanSample+ABarcode3+ADoctor+ADepartment+ASampleshavenotbeensent+ASampleisnotforthepatient+ABloodhavenotbeenordered4+ABarcodePatient+AThebloodProductisnotforthepatient+AThebloodisforthepatient+APatienttemppressure_highpressure_lowpulse+AMoreblood+ABarcode5+ANShowPatientInfoNOrderBlood+AReactiontype+ATransfusionNurse+Aouttimelessthen05h+Aouttimelessthan4h6+ABloodOrderquantityexpectTime+ABlood+ANSendSampleNCollectBlood+Abloodtypeisunknownorscreeningisnotdoneorinvalidscreenisvalidwithin4days+ASampleshavenotbeenordered+ANperformtransfusionNMeasuretemperaturebloodpressureandpulse+ANMeasuretemperaturebloodpressureandpulseNperformtransfusion+ASampleLabelFile+ALabel+ANInitNScanNurseCard)&trans.aarrows
}

//the predicate that the transformation is an application of the rule OrderSampleSelectBlodTypeing
pred rule_OrderSampleSelectBlodTypeing[trans:Trans]{
	some trans.rule&OrderSampleSelectBlodTypeing


some e0:APatienthasnotbeenbloodtyped&trans.aarrows|let n0=e0.src,n1=e0.trg|
	(n0 in (trans.source.nodes-trans.dnodes) and n1 in trans.anodes and (no nac:ANOrderSampleNSelectBookpreexamination&(trans.source.arrows-trans.darrows)|nac.src=n0) and (no nac:APatienthasnotbeenbloodtyped&(trans.source.arrows-trans.darrows)|nac.src=n0) and (some e2:ANOrderSampleNSelectBookpreexamination&trans.aarrows|let n2=e2.trg|
	(e2.src=n0 and n2 in trans.anodes)))

	#NSelectBookpreexamination&trans.anodes = 1
	#NSelectBlodTypeing&trans.anodes = 1
	#ANOrderSampleNSelectBookpreexamination&trans.aarrows = 1
	#APatienthasnotbeenbloodtyped&trans.aarrows = 1
	no trans.dnodes
	no (NScanPatientWristband+NSendSampleOrder+NOrderBlood+NCollectBlood+NMeasuretemperaturebloodpressureandpulse+Nperformtransfusion+NIdentifynurselogtransfusion+NScanNurseCard+NShowNurseInfo+NShowPatientInfo+NOrderSample+NGetNurseInfo+NGetPatientInfo+NGetSampleInfo+NScannPatientWristband+NScanSample+NGetPatientInfo0+NCollectSample+NSelectBloodProduct+NGetDoctorInfo+NSelectDepartment+NSendBloodOrder+NSendSample+NScanBloodProduct+NVerifyBloodProduct+NStopTransfusionContactAIT+NStorePatientCondition+NRegisterReaction+NStoreTransfusion+NPutBloodIntorefrigertor+NOrderBloodProduct+NPrintSampleLabel+NInit)&trans.anodes
	no trans.darrows
	no (ANSelectBookpreexaminationNSendSampleOrder+ANperformtransfusionNIdentifynurselogtransfusion+Aouttimelessthan4h+ANShowNurseInfoNScanPatientWristband+ANSelectBlodTypeingNSendSampleOrder+ANursename+ANurseisnotfound+ABarcode+APatientnameIDgenderblodtypescreening+APatientisnotfound+ASample+ABarcode1+ABarcode2+APatient+ABloodhavenotbeenordered+ANCollectSampleNScanSample+ANOrderBloodNSelectBloodProduct+ABarcode3+ADoctor+ADepartment+ASampleshavenotbeensent+ASampleisnotforthepatient+ABloodhavenotbeenordered4+ABarcodePatient+AThebloodProductisnotforthepatient+AThebloodisforthepatient+APatienttemppressure_highpressure_lowpulse+AMoreblood+ABarcode5+ANShowPatientInfoNOrderBlood+AReactiontype+ATransfusionNurse+Aouttimelessthen05h+Aouttimelessthan4h6+ABloodOrderquantityexpectTime+ABlood+ANSendSampleNCollectBlood+Abloodtypeisunknownorscreeningisnotdoneorinvalidscreenisvalidwithin4days+ASampleshavenotbeenordered+ANperformtransfusionNMeasuretemperaturebloodpressureandpulse+ANMeasuretemperaturebloodpressureandpulseNperformtransfusion+ASampleLabelFile+ALabel+ANInitNScanNurseCard)&trans.aarrows
}

//the predicate that the transformation is an application of the rule OrderSampleSelectBookpreexamination
pred rule_OrderSampleSelectBookpreexamination[trans:Trans]{
	some trans.rule&OrderSampleSelectBookpreexamination


some e0:ANOrderSampleNSelectBookpreexamination&trans.aarrows|let n0=e0.src,n1=e0.trg|
	(n0 in (trans.source.nodes-trans.dnodes) and n1 in trans.anodes and (no nac:ANOrderSampleNSelectBookpreexamination&(trans.source.arrows-trans.darrows)|nac.src=n0) and (no nac:APatienthasnotbeenbloodtyped&(trans.source.arrows-trans.darrows)|nac.src=n0))

	#NSelectBookpreexamination&trans.anodes = 1
	#ANOrderSampleNSelectBookpreexamination&trans.aarrows = 1
	no trans.dnodes
	no (NScanPatientWristband+NSendSampleOrder+NOrderBlood+NCollectBlood+NMeasuretemperaturebloodpressureandpulse+Nperformtransfusion+NIdentifynurselogtransfusion+NScanNurseCard+NShowNurseInfo+NSelectBlodTypeing+NShowPatientInfo+NOrderSample+NGetNurseInfo+NGetPatientInfo+NGetSampleInfo+NScannPatientWristband+NScanSample+NGetPatientInfo0+NCollectSample+NSelectBloodProduct+NGetDoctorInfo+NSelectDepartment+NSendBloodOrder+NSendSample+NScanBloodProduct+NVerifyBloodProduct+NStopTransfusionContactAIT+NStorePatientCondition+NRegisterReaction+NStoreTransfusion+NPutBloodIntorefrigertor+NOrderBloodProduct+NPrintSampleLabel+NInit)&trans.anodes
	no trans.darrows
	no (ANSelectBookpreexaminationNSendSampleOrder+ANperformtransfusionNIdentifynurselogtransfusion+Aouttimelessthan4h+ANShowNurseInfoNScanPatientWristband+APatienthasnotbeenbloodtyped+ANSelectBlodTypeingNSendSampleOrder+ANursename+ANurseisnotfound+ABarcode+APatientnameIDgenderblodtypescreening+APatientisnotfound+ASample+ABarcode1+ABarcode2+APatient+ABloodhavenotbeenordered+ANCollectSampleNScanSample+ANOrderBloodNSelectBloodProduct+ABarcode3+ADoctor+ADepartment+ASampleshavenotbeensent+ASampleisnotforthepatient+ABloodhavenotbeenordered4+ABarcodePatient+AThebloodProductisnotforthepatient+AThebloodisforthepatient+APatienttemppressure_highpressure_lowpulse+AMoreblood+ABarcode5+ANShowPatientInfoNOrderBlood+AReactiontype+ATransfusionNurse+Aouttimelessthen05h+Aouttimelessthan4h6+ABloodOrderquantityexpectTime+ABlood+ANSendSampleNCollectBlood+Abloodtypeisunknownorscreeningisnotdoneorinvalidscreenisvalidwithin4days+ASampleshavenotbeenordered+ANperformtransfusionNMeasuretemperaturebloodpressureandpulse+ANMeasuretemperaturebloodpressureandpulseNperformtransfusion+ASampleLabelFile+ALabel+ANInitNScanNurseCard)&trans.aarrows
}

//the predicate that the transformation is an application of the rule PrintSampleLabelCollectSample
pred rule_PrintSampleLabelCollectSample[trans:Trans]{
	some trans.rule&PrintSampleLabelCollectSample


some e0:ALabel&trans.aarrows|let n0=e0.src,n1=e0.trg|
	(n0 in (trans.source.nodes-trans.dnodes) and n1 in trans.anodes and (no nac:ALabel&(trans.source.arrows-trans.darrows)|nac.src=n0))

	#NCollectSample&trans.anodes = 1
	#ALabel&trans.aarrows = 1
	no trans.dnodes
	no (NScanPatientWristband+NSelectBookpreexamination+NSendSampleOrder+NOrderBlood+NCollectBlood+NMeasuretemperaturebloodpressureandpulse+Nperformtransfusion+NIdentifynurselogtransfusion+NScanNurseCard+NShowNurseInfo+NSelectBlodTypeing+NShowPatientInfo+NOrderSample+NGetNurseInfo+NGetPatientInfo+NGetSampleInfo+NScannPatientWristband+NScanSample+NGetPatientInfo0+NSelectBloodProduct+NGetDoctorInfo+NSelectDepartment+NSendBloodOrder+NSendSample+NScanBloodProduct+NVerifyBloodProduct+NStopTransfusionContactAIT+NStorePatientCondition+NRegisterReaction+NStoreTransfusion+NPutBloodIntorefrigertor+NOrderBloodProduct+NPrintSampleLabel+NInit)&trans.anodes
	no trans.darrows
	no (ANOrderSampleNSelectBookpreexamination+ANSelectBookpreexaminationNSendSampleOrder+ANperformtransfusionNIdentifynurselogtransfusion+Aouttimelessthan4h+ANShowNurseInfoNScanPatientWristband+APatienthasnotbeenbloodtyped+ANSelectBlodTypeingNSendSampleOrder+ANursename+ANurseisnotfound+ABarcode+APatientnameIDgenderblodtypescreening+APatientisnotfound+ASample+ABarcode1+ABarcode2+APatient+ABloodhavenotbeenordered+ANCollectSampleNScanSample+ANOrderBloodNSelectBloodProduct+ABarcode3+ADoctor+ADepartment+ASampleshavenotbeensent+ASampleisnotforthepatient+ABloodhavenotbeenordered4+ABarcodePatient+AThebloodProductisnotforthepatient+AThebloodisforthepatient+APatienttemppressure_highpressure_lowpulse+AMoreblood+ABarcode5+ANShowPatientInfoNOrderBlood+AReactiontype+ATransfusionNurse+Aouttimelessthen05h+Aouttimelessthan4h6+ABloodOrderquantityexpectTime+ABlood+ANSendSampleNCollectBlood+Abloodtypeisunknownorscreeningisnotdoneorinvalidscreenisvalidwithin4days+ASampleshavenotbeenordered+ANperformtransfusionNMeasuretemperaturebloodpressureandpulse+ANMeasuretemperaturebloodpressureandpulseNperformtransfusion+ASampleLabelFile+ANInitNScanNurseCard)&trans.aarrows
}

//the predicate that the transformation is an application of the rule PutBloodIntorefrigertorScanBloodProduct
pred rule_PutBloodIntorefrigertorScanBloodProduct[trans:Trans]{
	some trans.rule&PutBloodIntorefrigertorScanBloodProduct


some e0:Aouttimelessthan4h6&trans.aarrows|let n0=e0.src,n1=e0.trg|
	(n0 in (trans.source.nodes-trans.dnodes) and n1 in trans.anodes and (no nac:Aouttimelessthan4h6&(trans.source.arrows-trans.darrows)|nac.src=n0))

	#NScanBloodProduct&trans.anodes = 1
	#Aouttimelessthan4h6&trans.aarrows = 1
	no trans.dnodes
	no (NScanPatientWristband+NSelectBookpreexamination+NSendSampleOrder+NOrderBlood+NCollectBlood+NMeasuretemperaturebloodpressureandpulse+Nperformtransfusion+NIdentifynurselogtransfusion+NScanNurseCard+NShowNurseInfo+NSelectBlodTypeing+NShowPatientInfo+NOrderSample+NGetNurseInfo+NGetPatientInfo+NGetSampleInfo+NScannPatientWristband+NScanSample+NGetPatientInfo0+NCollectSample+NSelectBloodProduct+NGetDoctorInfo+NSelectDepartment+NSendBloodOrder+NSendSample+NVerifyBloodProduct+NStopTransfusionContactAIT+NStorePatientCondition+NRegisterReaction+NStoreTransfusion+NPutBloodIntorefrigertor+NOrderBloodProduct+NPrintSampleLabel+NInit)&trans.anodes
	no trans.darrows
	no (ANOrderSampleNSelectBookpreexamination+ANSelectBookpreexaminationNSendSampleOrder+ANperformtransfusionNIdentifynurselogtransfusion+Aouttimelessthan4h+ANShowNurseInfoNScanPatientWristband+APatienthasnotbeenbloodtyped+ANSelectBlodTypeingNSendSampleOrder+ANursename+ANurseisnotfound+ABarcode+APatientnameIDgenderblodtypescreening+APatientisnotfound+ASample+ABarcode1+ABarcode2+APatient+ABloodhavenotbeenordered+ANCollectSampleNScanSample+ANOrderBloodNSelectBloodProduct+ABarcode3+ADoctor+ADepartment+ASampleshavenotbeensent+ASampleisnotforthepatient+ABloodhavenotbeenordered4+ABarcodePatient+AThebloodProductisnotforthepatient+AThebloodisforthepatient+APatienttemppressure_highpressure_lowpulse+AMoreblood+ABarcode5+ANShowPatientInfoNOrderBlood+AReactiontype+ATransfusionNurse+Aouttimelessthen05h+ABloodOrderquantityexpectTime+ABlood+ANSendSampleNCollectBlood+Abloodtypeisunknownorscreeningisnotdoneorinvalidscreenisvalidwithin4days+ASampleshavenotbeenordered+ANperformtransfusionNMeasuretemperaturebloodpressureandpulse+ANMeasuretemperaturebloodpressureandpulseNperformtransfusion+ASampleLabelFile+ALabel+ANInitNScanNurseCard)&trans.aarrows
}

//the predicate that the transformation is an application of the rule ScanBloodProductVerifyBloodProduct
pred rule_ScanBloodProductVerifyBloodProduct[trans:Trans]{
	some trans.rule&ScanBloodProductVerifyBloodProduct


some e0:ABarcodePatient&trans.aarrows|let n0=e0.src,n1=e0.trg|
	(n0 in (trans.source.nodes-trans.dnodes) and n1 in trans.anodes and (no nac:ABarcodePatient&(trans.source.arrows-trans.darrows)|nac.src=n0))

	#NVerifyBloodProduct&trans.anodes = 1
	#ABarcodePatient&trans.aarrows = 1
	no trans.dnodes
	no (NScanPatientWristband+NSelectBookpreexamination+NSendSampleOrder+NOrderBlood+NCollectBlood+NMeasuretemperaturebloodpressureandpulse+Nperformtransfusion+NIdentifynurselogtransfusion+NScanNurseCard+NShowNurseInfo+NSelectBlodTypeing+NShowPatientInfo+NOrderSample+NGetNurseInfo+NGetPatientInfo+NGetSampleInfo+NScannPatientWristband+NScanSample+NGetPatientInfo0+NCollectSample+NSelectBloodProduct+NGetDoctorInfo+NSelectDepartment+NSendBloodOrder+NSendSample+NScanBloodProduct+NStopTransfusionContactAIT+NStorePatientCondition+NRegisterReaction+NStoreTransfusion+NPutBloodIntorefrigertor+NOrderBloodProduct+NPrintSampleLabel+NInit)&trans.anodes
	no trans.darrows
	no (ANOrderSampleNSelectBookpreexamination+ANSelectBookpreexaminationNSendSampleOrder+ANperformtransfusionNIdentifynurselogtransfusion+Aouttimelessthan4h+ANShowNurseInfoNScanPatientWristband+APatienthasnotbeenbloodtyped+ANSelectBlodTypeingNSendSampleOrder+ANursename+ANurseisnotfound+ABarcode+APatientnameIDgenderblodtypescreening+APatientisnotfound+ASample+ABarcode1+ABarcode2+APatient+ABloodhavenotbeenordered+ANCollectSampleNScanSample+ANOrderBloodNSelectBloodProduct+ABarcode3+ADoctor+ADepartment+ASampleshavenotbeensent+ASampleisnotforthepatient+ABloodhavenotbeenordered4+AThebloodProductisnotforthepatient+AThebloodisforthepatient+APatienttemppressure_highpressure_lowpulse+AMoreblood+ABarcode5+ANShowPatientInfoNOrderBlood+AReactiontype+ATransfusionNurse+Aouttimelessthen05h+Aouttimelessthan4h6+ABloodOrderquantityexpectTime+ABlood+ANSendSampleNCollectBlood+Abloodtypeisunknownorscreeningisnotdoneorinvalidscreenisvalidwithin4days+ASampleshavenotbeenordered+ANperformtransfusionNMeasuretemperaturebloodpressureandpulse+ANMeasuretemperaturebloodpressureandpulseNperformtransfusion+ASampleLabelFile+ALabel+ANInitNScanNurseCard)&trans.aarrows
}

//the predicate that the transformation is an application of the rule ScanNurseCardGetNurseInfo
pred rule_ScanNurseCardGetNurseInfo[trans:Trans]{
	some trans.rule&ScanNurseCardGetNurseInfo


some e0:ABarcode5&trans.aarrows|let n0=e0.src,n1=e0.trg|
	(n0 in (trans.source.nodes-trans.dnodes) and n1 in trans.anodes and (no nac:ABarcode5&(trans.source.arrows-trans.darrows)|nac.src=n0))

	#NGetNurseInfo&trans.anodes = 1
	#ABarcode5&trans.aarrows = 1
	no trans.dnodes
	no (NScanPatientWristband+NSelectBookpreexamination+NSendSampleOrder+NOrderBlood+NCollectBlood+NMeasuretemperaturebloodpressureandpulse+Nperformtransfusion+NIdentifynurselogtransfusion+NScanNurseCard+NShowNurseInfo+NSelectBlodTypeing+NShowPatientInfo+NOrderSample+NGetPatientInfo+NGetSampleInfo+NScannPatientWristband+NScanSample+NGetPatientInfo0+NCollectSample+NSelectBloodProduct+NGetDoctorInfo+NSelectDepartment+NSendBloodOrder+NSendSample+NScanBloodProduct+NVerifyBloodProduct+NStopTransfusionContactAIT+NStorePatientCondition+NRegisterReaction+NStoreTransfusion+NPutBloodIntorefrigertor+NOrderBloodProduct+NPrintSampleLabel+NInit)&trans.anodes
	no trans.darrows
	no (ANOrderSampleNSelectBookpreexamination+ANSelectBookpreexaminationNSendSampleOrder+ANperformtransfusionNIdentifynurselogtransfusion+Aouttimelessthan4h+ANShowNurseInfoNScanPatientWristband+APatienthasnotbeenbloodtyped+ANSelectBlodTypeingNSendSampleOrder+ANursename+ANurseisnotfound+ABarcode+APatientnameIDgenderblodtypescreening+APatientisnotfound+ASample+ABarcode1+ABarcode2+APatient+ABloodhavenotbeenordered+ANCollectSampleNScanSample+ANOrderBloodNSelectBloodProduct+ABarcode3+ADoctor+ADepartment+ASampleshavenotbeensent+ASampleisnotforthepatient+ABloodhavenotbeenordered4+ABarcodePatient+AThebloodProductisnotforthepatient+AThebloodisforthepatient+APatienttemppressure_highpressure_lowpulse+AMoreblood+ANShowPatientInfoNOrderBlood+AReactiontype+ATransfusionNurse+Aouttimelessthen05h+Aouttimelessthan4h6+ABloodOrderquantityexpectTime+ABlood+ANSendSampleNCollectBlood+Abloodtypeisunknownorscreeningisnotdoneorinvalidscreenisvalidwithin4days+ASampleshavenotbeenordered+ANperformtransfusionNMeasuretemperaturebloodpressureandpulse+ANMeasuretemperaturebloodpressureandpulseNperformtransfusion+ASampleLabelFile+ALabel+ANInitNScanNurseCard)&trans.aarrows
}

//the predicate that the transformation is an application of the rule ScanPatientWristbandGetPatientInfo
pred rule_ScanPatientWristbandGetPatientInfo[trans:Trans]{
	some trans.rule&ScanPatientWristbandGetPatientInfo


some e0:ABarcode&trans.aarrows|let n0=e0.src,n1=e0.trg|
	(n0 in (trans.source.nodes-trans.dnodes) and n1 in trans.anodes and (no nac:ABarcode&(trans.source.arrows-trans.darrows)|nac.src=n0))

	#NGetPatientInfo&trans.anodes = 1
	#ABarcode&trans.aarrows = 1
	no trans.dnodes
	no (NScanPatientWristband+NSelectBookpreexamination+NSendSampleOrder+NOrderBlood+NCollectBlood+NMeasuretemperaturebloodpressureandpulse+Nperformtransfusion+NIdentifynurselogtransfusion+NScanNurseCard+NShowNurseInfo+NSelectBlodTypeing+NShowPatientInfo+NOrderSample+NGetNurseInfo+NGetSampleInfo+NScannPatientWristband+NScanSample+NGetPatientInfo0+NCollectSample+NSelectBloodProduct+NGetDoctorInfo+NSelectDepartment+NSendBloodOrder+NSendSample+NScanBloodProduct+NVerifyBloodProduct+NStopTransfusionContactAIT+NStorePatientCondition+NRegisterReaction+NStoreTransfusion+NPutBloodIntorefrigertor+NOrderBloodProduct+NPrintSampleLabel+NInit)&trans.anodes
	no trans.darrows
	no (ANOrderSampleNSelectBookpreexamination+ANSelectBookpreexaminationNSendSampleOrder+ANperformtransfusionNIdentifynurselogtransfusion+Aouttimelessthan4h+ANShowNurseInfoNScanPatientWristband+APatienthasnotbeenbloodtyped+ANSelectBlodTypeingNSendSampleOrder+ANursename+ANurseisnotfound+APatientnameIDgenderblodtypescreening+APatientisnotfound+ASample+ABarcode1+ABarcode2+APatient+ABloodhavenotbeenordered+ANCollectSampleNScanSample+ANOrderBloodNSelectBloodProduct+ABarcode3+ADoctor+ADepartment+ASampleshavenotbeensent+ASampleisnotforthepatient+ABloodhavenotbeenordered4+ABarcodePatient+AThebloodProductisnotforthepatient+AThebloodisforthepatient+APatienttemppressure_highpressure_lowpulse+AMoreblood+ABarcode5+ANShowPatientInfoNOrderBlood+AReactiontype+ATransfusionNurse+Aouttimelessthen05h+Aouttimelessthan4h6+ABloodOrderquantityexpectTime+ABlood+ANSendSampleNCollectBlood+Abloodtypeisunknownorscreeningisnotdoneorinvalidscreenisvalidwithin4days+ASampleshavenotbeenordered+ANperformtransfusionNMeasuretemperaturebloodpressureandpulse+ANMeasuretemperaturebloodpressureandpulseNperformtransfusion+ASampleLabelFile+ALabel+ANInitNScanNurseCard)&trans.aarrows
}

//the predicate that the transformation is an application of the rule ScanSampleGetSampleInfo
pred rule_ScanSampleGetSampleInfo[trans:Trans]{
	some trans.rule&ScanSampleGetSampleInfo


some e0:ABarcode1&trans.aarrows|let n0=e0.src,n1=e0.trg|
	(n0 in (trans.source.nodes-trans.dnodes) and n1 in trans.anodes and (no nac:ABarcode1&(trans.source.arrows-trans.darrows)|nac.src=n0))

	#NGetSampleInfo&trans.anodes = 1
	#ABarcode1&trans.aarrows = 1
	no trans.dnodes
	no (NScanPatientWristband+NSelectBookpreexamination+NSendSampleOrder+NOrderBlood+NCollectBlood+NMeasuretemperaturebloodpressureandpulse+Nperformtransfusion+NIdentifynurselogtransfusion+NScanNurseCard+NShowNurseInfo+NSelectBlodTypeing+NShowPatientInfo+NOrderSample+NGetNurseInfo+NGetPatientInfo+NScannPatientWristband+NScanSample+NGetPatientInfo0+NCollectSample+NSelectBloodProduct+NGetDoctorInfo+NSelectDepartment+NSendBloodOrder+NSendSample+NScanBloodProduct+NVerifyBloodProduct+NStopTransfusionContactAIT+NStorePatientCondition+NRegisterReaction+NStoreTransfusion+NPutBloodIntorefrigertor+NOrderBloodProduct+NPrintSampleLabel+NInit)&trans.anodes
	no trans.darrows
	no (ANOrderSampleNSelectBookpreexamination+ANSelectBookpreexaminationNSendSampleOrder+ANperformtransfusionNIdentifynurselogtransfusion+Aouttimelessthan4h+ANShowNurseInfoNScanPatientWristband+APatienthasnotbeenbloodtyped+ANSelectBlodTypeingNSendSampleOrder+ANursename+ANurseisnotfound+ABarcode+APatientnameIDgenderblodtypescreening+APatientisnotfound+ASample+ABarcode2+APatient+ABloodhavenotbeenordered+ANCollectSampleNScanSample+ANOrderBloodNSelectBloodProduct+ABarcode3+ADoctor+ADepartment+ASampleshavenotbeensent+ASampleisnotforthepatient+ABloodhavenotbeenordered4+ABarcodePatient+AThebloodProductisnotforthepatient+AThebloodisforthepatient+APatienttemppressure_highpressure_lowpulse+AMoreblood+ABarcode5+ANShowPatientInfoNOrderBlood+AReactiontype+ATransfusionNurse+Aouttimelessthen05h+Aouttimelessthan4h6+ABloodOrderquantityexpectTime+ABlood+ANSendSampleNCollectBlood+Abloodtypeisunknownorscreeningisnotdoneorinvalidscreenisvalidwithin4days+ASampleshavenotbeenordered+ANperformtransfusionNMeasuretemperaturebloodpressureandpulse+ANMeasuretemperaturebloodpressureandpulseNperformtransfusion+ASampleLabelFile+ALabel+ANInitNScanNurseCard)&trans.aarrows
}

//the predicate that the transformation is an application of the rule ScannPatientWristbandGetPatientInfo
pred rule_ScannPatientWristbandGetPatientInfo[trans:Trans]{
	some trans.rule&ScannPatientWristbandGetPatientInfo


some e0:ABarcode2&trans.aarrows|let n0=e0.src,n1=e0.trg|
	(n0 in (trans.source.nodes-trans.dnodes) and n1 in trans.anodes and (no nac:ABarcode2&(trans.source.arrows-trans.darrows)|nac.src=n0))

	#NGetPatientInfo0&trans.anodes = 1
	#ABarcode2&trans.aarrows = 1
	no trans.dnodes
	no (NScanPatientWristband+NSelectBookpreexamination+NSendSampleOrder+NOrderBlood+NCollectBlood+NMeasuretemperaturebloodpressureandpulse+Nperformtransfusion+NIdentifynurselogtransfusion+NScanNurseCard+NShowNurseInfo+NSelectBlodTypeing+NShowPatientInfo+NOrderSample+NGetNurseInfo+NGetPatientInfo+NGetSampleInfo+NScannPatientWristband+NScanSample+NCollectSample+NSelectBloodProduct+NGetDoctorInfo+NSelectDepartment+NSendBloodOrder+NSendSample+NScanBloodProduct+NVerifyBloodProduct+NStopTransfusionContactAIT+NStorePatientCondition+NRegisterReaction+NStoreTransfusion+NPutBloodIntorefrigertor+NOrderBloodProduct+NPrintSampleLabel+NInit)&trans.anodes
	no trans.darrows
	no (ANOrderSampleNSelectBookpreexamination+ANSelectBookpreexaminationNSendSampleOrder+ANperformtransfusionNIdentifynurselogtransfusion+Aouttimelessthan4h+ANShowNurseInfoNScanPatientWristband+APatienthasnotbeenbloodtyped+ANSelectBlodTypeingNSendSampleOrder+ANursename+ANurseisnotfound+ABarcode+APatientnameIDgenderblodtypescreening+APatientisnotfound+ASample+ABarcode1+APatient+ABloodhavenotbeenordered+ANCollectSampleNScanSample+ANOrderBloodNSelectBloodProduct+ABarcode3+ADoctor+ADepartment+ASampleshavenotbeensent+ASampleisnotforthepatient+ABloodhavenotbeenordered4+ABarcodePatient+AThebloodProductisnotforthepatient+AThebloodisforthepatient+APatienttemppressure_highpressure_lowpulse+AMoreblood+ABarcode5+ANShowPatientInfoNOrderBlood+AReactiontype+ATransfusionNurse+Aouttimelessthen05h+Aouttimelessthan4h6+ABloodOrderquantityexpectTime+ABlood+ANSendSampleNCollectBlood+Abloodtypeisunknownorscreeningisnotdoneorinvalidscreenisvalidwithin4days+ASampleshavenotbeenordered+ANperformtransfusionNMeasuretemperaturebloodpressureandpulse+ANMeasuretemperaturebloodpressureandpulseNperformtransfusion+ASampleLabelFile+ALabel+ANInitNScanNurseCard)&trans.aarrows
}

//the predicate that the transformation is an application of the rule SelectBlodTypeingSendSampleOrder
pred rule_SelectBlodTypeingSendSampleOrder[trans:Trans]{
	some trans.rule&SelectBlodTypeingSendSampleOrder


some e0:ANSelectBlodTypeingNSendSampleOrder&trans.aarrows|let n0=e0.src,n1=e0.trg|
	(n0 in (trans.source.nodes-trans.dnodes) and n1 in trans.anodes and (no nac:ANSelectBlodTypeingNSendSampleOrder&(trans.source.arrows-trans.darrows)|nac.src=n0) and (some e2:ANSelectBookpreexaminationNSendSampleOrder&trans.aarrows|let n2=e2.src|
	(n2 in (trans.source.nodes-trans.dnodes) and e2.trg=n1 and (no nac:ANSelectBookpreexaminationNSendSampleOrder&(trans.source.arrows-trans.darrows)|nac.src=n2))))

	#NSendSampleOrder&trans.anodes = 1
	#ANSelectBookpreexaminationNSendSampleOrder&trans.aarrows = 1
	#ANSelectBlodTypeingNSendSampleOrder&trans.aarrows = 1
	no trans.dnodes
	no (NScanPatientWristband+NSelectBookpreexamination+NOrderBlood+NCollectBlood+NMeasuretemperaturebloodpressureandpulse+Nperformtransfusion+NIdentifynurselogtransfusion+NScanNurseCard+NShowNurseInfo+NSelectBlodTypeing+NShowPatientInfo+NOrderSample+NGetNurseInfo+NGetPatientInfo+NGetSampleInfo+NScannPatientWristband+NScanSample+NGetPatientInfo0+NCollectSample+NSelectBloodProduct+NGetDoctorInfo+NSelectDepartment+NSendBloodOrder+NSendSample+NScanBloodProduct+NVerifyBloodProduct+NStopTransfusionContactAIT+NStorePatientCondition+NRegisterReaction+NStoreTransfusion+NPutBloodIntorefrigertor+NOrderBloodProduct+NPrintSampleLabel+NInit)&trans.anodes
	no trans.darrows
	no (ANOrderSampleNSelectBookpreexamination+ANperformtransfusionNIdentifynurselogtransfusion+Aouttimelessthan4h+ANShowNurseInfoNScanPatientWristband+APatienthasnotbeenbloodtyped+ANursename+ANurseisnotfound+ABarcode+APatientnameIDgenderblodtypescreening+APatientisnotfound+ASample+ABarcode1+ABarcode2+APatient+ABloodhavenotbeenordered+ANCollectSampleNScanSample+ANOrderBloodNSelectBloodProduct+ABarcode3+ADoctor+ADepartment+ASampleshavenotbeensent+ASampleisnotforthepatient+ABloodhavenotbeenordered4+ABarcodePatient+AThebloodProductisnotforthepatient+AThebloodisforthepatient+APatienttemppressure_highpressure_lowpulse+AMoreblood+ABarcode5+ANShowPatientInfoNOrderBlood+AReactiontype+ATransfusionNurse+Aouttimelessthen05h+Aouttimelessthan4h6+ABloodOrderquantityexpectTime+ABlood+ANSendSampleNCollectBlood+Abloodtypeisunknownorscreeningisnotdoneorinvalidscreenisvalidwithin4days+ASampleshavenotbeenordered+ANperformtransfusionNMeasuretemperaturebloodpressureandpulse+ANMeasuretemperaturebloodpressureandpulseNperformtransfusion+ASampleLabelFile+ALabel+ANInitNScanNurseCard)&trans.aarrows
}

//the predicate that the transformation is an application of the rule SelectBloodProductGetDoctorInfo
pred rule_SelectBloodProductGetDoctorInfo[trans:Trans]{
	some trans.rule&SelectBloodProductGetDoctorInfo


some e0:ABarcode3&trans.aarrows|let n0=e0.src,n1=e0.trg|
	(n0 in (trans.source.nodes-trans.dnodes) and n1 in trans.anodes and (no nac:ABarcode3&(trans.source.arrows-trans.darrows)|nac.src=n0))

	#NGetDoctorInfo&trans.anodes = 1
	#ABarcode3&trans.aarrows = 1
	no trans.dnodes
	no (NScanPatientWristband+NSelectBookpreexamination+NSendSampleOrder+NOrderBlood+NCollectBlood+NMeasuretemperaturebloodpressureandpulse+Nperformtransfusion+NIdentifynurselogtransfusion+NScanNurseCard+NShowNurseInfo+NSelectBlodTypeing+NShowPatientInfo+NOrderSample+NGetNurseInfo+NGetPatientInfo+NGetSampleInfo+NScannPatientWristband+NScanSample+NGetPatientInfo0+NCollectSample+NSelectBloodProduct+NSelectDepartment+NSendBloodOrder+NSendSample+NScanBloodProduct+NVerifyBloodProduct+NStopTransfusionContactAIT+NStorePatientCondition+NRegisterReaction+NStoreTransfusion+NPutBloodIntorefrigertor+NOrderBloodProduct+NPrintSampleLabel+NInit)&trans.anodes
	no trans.darrows
	no (ANOrderSampleNSelectBookpreexamination+ANSelectBookpreexaminationNSendSampleOrder+ANperformtransfusionNIdentifynurselogtransfusion+Aouttimelessthan4h+ANShowNurseInfoNScanPatientWristband+APatienthasnotbeenbloodtyped+ANSelectBlodTypeingNSendSampleOrder+ANursename+ANurseisnotfound+ABarcode+APatientnameIDgenderblodtypescreening+APatientisnotfound+ASample+ABarcode1+ABarcode2+APatient+ABloodhavenotbeenordered+ANCollectSampleNScanSample+ANOrderBloodNSelectBloodProduct+ADoctor+ADepartment+ASampleshavenotbeensent+ASampleisnotforthepatient+ABloodhavenotbeenordered4+ABarcodePatient+AThebloodProductisnotforthepatient+AThebloodisforthepatient+APatienttemppressure_highpressure_lowpulse+AMoreblood+ABarcode5+ANShowPatientInfoNOrderBlood+AReactiontype+ATransfusionNurse+Aouttimelessthen05h+Aouttimelessthan4h6+ABloodOrderquantityexpectTime+ABlood+ANSendSampleNCollectBlood+Abloodtypeisunknownorscreeningisnotdoneorinvalidscreenisvalidwithin4days+ASampleshavenotbeenordered+ANperformtransfusionNMeasuretemperaturebloodpressureandpulse+ANMeasuretemperaturebloodpressureandpulseNperformtransfusion+ASampleLabelFile+ALabel+ANInitNScanNurseCard)&trans.aarrows
}

//the predicate that the transformation is an application of the rule SelectBookpreexaminationSendSampleOrder
pred rule_SelectBookpreexaminationSendSampleOrder[trans:Trans]{
	some trans.rule&SelectBookpreexaminationSendSampleOrder


some e0:ANSelectBookpreexaminationNSendSampleOrder&trans.aarrows|let n0=e0.src,n1=e0.trg|
	(n0 in (trans.source.nodes-trans.dnodes) and n1 in trans.anodes and (no nac:ANSelectBookpreexaminationNSendSampleOrder&(trans.source.arrows-trans.darrows)|nac.src=n0))
no n:NSelectBlodTypeing&(trans.source.nodes-trans.dnodes)|(no nac:ANSelectBlodTypeingNSendSampleOrder&(trans.source.arrows-trans.darrows)|nac.src=n)
	#NSendSampleOrder&trans.anodes = 1
	#ANSelectBookpreexaminationNSendSampleOrder&trans.aarrows = 1
	no trans.dnodes
	no (NScanPatientWristband+NSelectBookpreexamination+NOrderBlood+NCollectBlood+NMeasuretemperaturebloodpressureandpulse+Nperformtransfusion+NIdentifynurselogtransfusion+NScanNurseCard+NShowNurseInfo+NSelectBlodTypeing+NShowPatientInfo+NOrderSample+NGetNurseInfo+NGetPatientInfo+NGetSampleInfo+NScannPatientWristband+NScanSample+NGetPatientInfo0+NCollectSample+NSelectBloodProduct+NGetDoctorInfo+NSelectDepartment+NSendBloodOrder+NSendSample+NScanBloodProduct+NVerifyBloodProduct+NStopTransfusionContactAIT+NStorePatientCondition+NRegisterReaction+NStoreTransfusion+NPutBloodIntorefrigertor+NOrderBloodProduct+NPrintSampleLabel+NInit)&trans.anodes
	no trans.darrows
	no (ANOrderSampleNSelectBookpreexamination+ANperformtransfusionNIdentifynurselogtransfusion+Aouttimelessthan4h+ANShowNurseInfoNScanPatientWristband+APatienthasnotbeenbloodtyped+ANSelectBlodTypeingNSendSampleOrder+ANursename+ANurseisnotfound+ABarcode+APatientnameIDgenderblodtypescreening+APatientisnotfound+ASample+ABarcode1+ABarcode2+APatient+ABloodhavenotbeenordered+ANCollectSampleNScanSample+ANOrderBloodNSelectBloodProduct+ABarcode3+ADoctor+ADepartment+ASampleshavenotbeensent+ASampleisnotforthepatient+ABloodhavenotbeenordered4+ABarcodePatient+AThebloodProductisnotforthepatient+AThebloodisforthepatient+APatienttemppressure_highpressure_lowpulse+AMoreblood+ABarcode5+ANShowPatientInfoNOrderBlood+AReactiontype+ATransfusionNurse+Aouttimelessthen05h+Aouttimelessthan4h6+ABloodOrderquantityexpectTime+ABlood+ANSendSampleNCollectBlood+Abloodtypeisunknownorscreeningisnotdoneorinvalidscreenisvalidwithin4days+ASampleshavenotbeenordered+ANperformtransfusionNMeasuretemperaturebloodpressureandpulse+ANMeasuretemperaturebloodpressureandpulseNperformtransfusion+ASampleLabelFile+ALabel+ANInitNScanNurseCard)&trans.aarrows
}

//the predicate that the transformation is an application of the rule SelectDepartmentSendBloodOrder
pred rule_SelectDepartmentSendBloodOrder[trans:Trans]{
	some trans.rule&SelectDepartmentSendBloodOrder


some e0:ADepartment&trans.aarrows|let n0=e0.src,n1=e0.trg|
	(n0 in (trans.source.nodes-trans.dnodes) and n1 in trans.anodes and (no nac:ADepartment&(trans.source.arrows-trans.darrows)|nac.src=n0))

	#NSendBloodOrder&trans.anodes = 1
	#ADepartment&trans.aarrows = 1
	no trans.dnodes
	no (NScanPatientWristband+NSelectBookpreexamination+NSendSampleOrder+NOrderBlood+NCollectBlood+NMeasuretemperaturebloodpressureandpulse+Nperformtransfusion+NIdentifynurselogtransfusion+NScanNurseCard+NShowNurseInfo+NSelectBlodTypeing+NShowPatientInfo+NOrderSample+NGetNurseInfo+NGetPatientInfo+NGetSampleInfo+NScannPatientWristband+NScanSample+NGetPatientInfo0+NCollectSample+NSelectBloodProduct+NGetDoctorInfo+NSelectDepartment+NSendSample+NScanBloodProduct+NVerifyBloodProduct+NStopTransfusionContactAIT+NStorePatientCondition+NRegisterReaction+NStoreTransfusion+NPutBloodIntorefrigertor+NOrderBloodProduct+NPrintSampleLabel+NInit)&trans.anodes
	no trans.darrows
	no (ANOrderSampleNSelectBookpreexamination+ANSelectBookpreexaminationNSendSampleOrder+ANperformtransfusionNIdentifynurselogtransfusion+Aouttimelessthan4h+ANShowNurseInfoNScanPatientWristband+APatienthasnotbeenbloodtyped+ANSelectBlodTypeingNSendSampleOrder+ANursename+ANurseisnotfound+ABarcode+APatientnameIDgenderblodtypescreening+APatientisnotfound+ASample+ABarcode1+ABarcode2+APatient+ABloodhavenotbeenordered+ANCollectSampleNScanSample+ANOrderBloodNSelectBloodProduct+ABarcode3+ADoctor+ASampleshavenotbeensent+ASampleisnotforthepatient+ABloodhavenotbeenordered4+ABarcodePatient+AThebloodProductisnotforthepatient+AThebloodisforthepatient+APatienttemppressure_highpressure_lowpulse+AMoreblood+ABarcode5+ANShowPatientInfoNOrderBlood+AReactiontype+ATransfusionNurse+Aouttimelessthen05h+Aouttimelessthan4h6+ABloodOrderquantityexpectTime+ABlood+ANSendSampleNCollectBlood+Abloodtypeisunknownorscreeningisnotdoneorinvalidscreenisvalidwithin4days+ASampleshavenotbeenordered+ANperformtransfusionNMeasuretemperaturebloodpressureandpulse+ANMeasuretemperaturebloodpressureandpulseNperformtransfusion+ASampleLabelFile+ALabel+ANInitNScanNurseCard)&trans.aarrows
}

//the predicate that the transformation is an application of the rule SendBloodOrderOrderBloodProduct
pred rule_SendBloodOrderOrderBloodProduct[trans:Trans]{
	some trans.rule&SendBloodOrderOrderBloodProduct


some e0:ABloodOrderquantityexpectTime&trans.aarrows|let n0=e0.src,n1=e0.trg|
	(n0 in (trans.source.nodes-trans.dnodes) and n1 in trans.anodes and (no nac:ASampleshavenotbeensent&(trans.source.arrows-trans.darrows)|nac.src=n0) and (no nac:ABloodOrderquantityexpectTime&(trans.source.arrows-trans.darrows)|nac.src=n0) and (no nac:ASampleshavenotbeenordered&(trans.source.arrows-trans.darrows)|nac.src=n0))

	#NOrderBloodProduct&trans.anodes = 1
	#ABloodOrderquantityexpectTime&trans.aarrows = 1
	no trans.dnodes
	no (NScanPatientWristband+NSelectBookpreexamination+NSendSampleOrder+NOrderBlood+NCollectBlood+NMeasuretemperaturebloodpressureandpulse+Nperformtransfusion+NIdentifynurselogtransfusion+NScanNurseCard+NShowNurseInfo+NSelectBlodTypeing+NShowPatientInfo+NOrderSample+NGetNurseInfo+NGetPatientInfo+NGetSampleInfo+NScannPatientWristband+NScanSample+NGetPatientInfo0+NCollectSample+NSelectBloodProduct+NGetDoctorInfo+NSelectDepartment+NSendBloodOrder+NSendSample+NScanBloodProduct+NVerifyBloodProduct+NStopTransfusionContactAIT+NStorePatientCondition+NRegisterReaction+NStoreTransfusion+NPutBloodIntorefrigertor+NPrintSampleLabel+NInit)&trans.anodes
	no trans.darrows
	no (ANOrderSampleNSelectBookpreexamination+ANSelectBookpreexaminationNSendSampleOrder+ANperformtransfusionNIdentifynurselogtransfusion+Aouttimelessthan4h+ANShowNurseInfoNScanPatientWristband+APatienthasnotbeenbloodtyped+ANSelectBlodTypeingNSendSampleOrder+ANursename+ANurseisnotfound+ABarcode+APatientnameIDgenderblodtypescreening+APatientisnotfound+ASample+ABarcode1+ABarcode2+APatient+ABloodhavenotbeenordered+ANCollectSampleNScanSample+ANOrderBloodNSelectBloodProduct+ABarcode3+ADoctor+ADepartment+ASampleshavenotbeensent+ASampleisnotforthepatient+ABloodhavenotbeenordered4+ABarcodePatient+AThebloodProductisnotforthepatient+AThebloodisforthepatient+APatienttemppressure_highpressure_lowpulse+AMoreblood+ABarcode5+ANShowPatientInfoNOrderBlood+AReactiontype+ATransfusionNurse+Aouttimelessthen05h+Aouttimelessthan4h6+ABlood+ANSendSampleNCollectBlood+Abloodtypeisunknownorscreeningisnotdoneorinvalidscreenisvalidwithin4days+ASampleshavenotbeenordered+ANperformtransfusionNMeasuretemperaturebloodpressureandpulse+ANMeasuretemperaturebloodpressureandpulseNperformtransfusion+ASampleLabelFile+ALabel+ANInitNScanNurseCard)&trans.aarrows
}

//the predicate that the transformation is an application of the rule SendBloodOrderOrderSample
pred rule_SendBloodOrderOrderSample[trans:Trans]{
	some trans.rule&SendBloodOrderOrderSample


some e0:ASampleshavenotbeenordered&trans.aarrows|let n0=e0.src,n1=e0.trg|
	(n0 in (trans.source.nodes-trans.dnodes) and n1 in trans.anodes and (no nac:ASampleshavenotbeensent&(trans.source.arrows-trans.darrows)|nac.src=n0) and (no nac:ABloodOrderquantityexpectTime&(trans.source.arrows-trans.darrows)|nac.src=n0) and (no nac:ASampleshavenotbeenordered&(trans.source.arrows-trans.darrows)|nac.src=n0))

	#NOrderSample&trans.anodes = 1
	#ASampleshavenotbeenordered&trans.aarrows = 1
	no trans.dnodes
	no (NScanPatientWristband+NSelectBookpreexamination+NSendSampleOrder+NOrderBlood+NCollectBlood+NMeasuretemperaturebloodpressureandpulse+Nperformtransfusion+NIdentifynurselogtransfusion+NScanNurseCard+NShowNurseInfo+NSelectBlodTypeing+NShowPatientInfo+NGetNurseInfo+NGetPatientInfo+NGetSampleInfo+NScannPatientWristband+NScanSample+NGetPatientInfo0+NCollectSample+NSelectBloodProduct+NGetDoctorInfo+NSelectDepartment+NSendBloodOrder+NSendSample+NScanBloodProduct+NVerifyBloodProduct+NStopTransfusionContactAIT+NStorePatientCondition+NRegisterReaction+NStoreTransfusion+NPutBloodIntorefrigertor+NOrderBloodProduct+NPrintSampleLabel+NInit)&trans.anodes
	no trans.darrows
	no (ANOrderSampleNSelectBookpreexamination+ANSelectBookpreexaminationNSendSampleOrder+ANperformtransfusionNIdentifynurselogtransfusion+Aouttimelessthan4h+ANShowNurseInfoNScanPatientWristband+APatienthasnotbeenbloodtyped+ANSelectBlodTypeingNSendSampleOrder+ANursename+ANurseisnotfound+ABarcode+APatientnameIDgenderblodtypescreening+APatientisnotfound+ASample+ABarcode1+ABarcode2+APatient+ABloodhavenotbeenordered+ANCollectSampleNScanSample+ANOrderBloodNSelectBloodProduct+ABarcode3+ADoctor+ADepartment+ASampleshavenotbeensent+ASampleisnotforthepatient+ABloodhavenotbeenordered4+ABarcodePatient+AThebloodProductisnotforthepatient+AThebloodisforthepatient+APatienttemppressure_highpressure_lowpulse+AMoreblood+ABarcode5+ANShowPatientInfoNOrderBlood+AReactiontype+ATransfusionNurse+Aouttimelessthen05h+Aouttimelessthan4h6+ABloodOrderquantityexpectTime+ABlood+ANSendSampleNCollectBlood+Abloodtypeisunknownorscreeningisnotdoneorinvalidscreenisvalidwithin4days+ANperformtransfusionNMeasuretemperaturebloodpressureandpulse+ANMeasuretemperaturebloodpressureandpulseNperformtransfusion+ASampleLabelFile+ALabel+ANInitNScanNurseCard)&trans.aarrows
}

//the predicate that the transformation is an application of the rule SendBloodOrderScanSample
pred rule_SendBloodOrderScanSample[trans:Trans]{
	some trans.rule&SendBloodOrderScanSample


some e0:ASampleshavenotbeensent&trans.aarrows|let n0=e0.src,n1=e0.trg|
	(n0 in (trans.source.nodes-trans.dnodes) and n1 in trans.anodes and (no nac:ASampleshavenotbeensent&(trans.source.arrows-trans.darrows)|nac.src=n0) and (no nac:ABloodOrderquantityexpectTime&(trans.source.arrows-trans.darrows)|nac.src=n0) and (no nac:ASampleshavenotbeenordered&(trans.source.arrows-trans.darrows)|nac.src=n0) and (some e2:ANCollectSampleNScanSample&trans.aarrows|let n2=e2.src|
	(n2 in (trans.source.nodes-trans.dnodes) and e2.trg=n1 and (no nac:ANCollectSampleNScanSample&(trans.source.arrows-trans.darrows)|nac.src=n2))))

	#NScanSample&trans.anodes = 1
	#ASampleshavenotbeensent&trans.aarrows = 1
	#ANCollectSampleNScanSample&trans.aarrows = 1
	no trans.dnodes
	no (NScanPatientWristband+NSelectBookpreexamination+NSendSampleOrder+NOrderBlood+NCollectBlood+NMeasuretemperaturebloodpressureandpulse+Nperformtransfusion+NIdentifynurselogtransfusion+NScanNurseCard+NShowNurseInfo+NSelectBlodTypeing+NShowPatientInfo+NOrderSample+NGetNurseInfo+NGetPatientInfo+NGetSampleInfo+NScannPatientWristband+NGetPatientInfo0+NCollectSample+NSelectBloodProduct+NGetDoctorInfo+NSelectDepartment+NSendBloodOrder+NSendSample+NScanBloodProduct+NVerifyBloodProduct+NStopTransfusionContactAIT+NStorePatientCondition+NRegisterReaction+NStoreTransfusion+NPutBloodIntorefrigertor+NOrderBloodProduct+NPrintSampleLabel+NInit)&trans.anodes
	no trans.darrows
	no (ANOrderSampleNSelectBookpreexamination+ANSelectBookpreexaminationNSendSampleOrder+ANperformtransfusionNIdentifynurselogtransfusion+Aouttimelessthan4h+ANShowNurseInfoNScanPatientWristband+APatienthasnotbeenbloodtyped+ANSelectBlodTypeingNSendSampleOrder+ANursename+ANurseisnotfound+ABarcode+APatientnameIDgenderblodtypescreening+APatientisnotfound+ASample+ABarcode1+ABarcode2+APatient+ABloodhavenotbeenordered+ANOrderBloodNSelectBloodProduct+ABarcode3+ADoctor+ADepartment+ASampleisnotforthepatient+ABloodhavenotbeenordered4+ABarcodePatient+AThebloodProductisnotforthepatient+AThebloodisforthepatient+APatienttemppressure_highpressure_lowpulse+AMoreblood+ABarcode5+ANShowPatientInfoNOrderBlood+AReactiontype+ATransfusionNurse+Aouttimelessthen05h+Aouttimelessthan4h6+ABloodOrderquantityexpectTime+ABlood+ANSendSampleNCollectBlood+Abloodtypeisunknownorscreeningisnotdoneorinvalidscreenisvalidwithin4days+ASampleshavenotbeenordered+ANperformtransfusionNMeasuretemperaturebloodpressureandpulse+ANMeasuretemperaturebloodpressureandpulseNperformtransfusion+ASampleLabelFile+ALabel+ANInitNScanNurseCard)&trans.aarrows
}

//the predicate that the transformation is an application of the rule SendSampleCollectBlood
pred rule_SendSampleCollectBlood[trans:Trans]{
	some trans.rule&SendSampleCollectBlood


some e0:ANSendSampleNCollectBlood&trans.aarrows|let n0=e0.src,n1=e0.trg|
	(n0 in (trans.source.nodes-trans.dnodes) and n1 in trans.anodes and (no nac:ABloodhavenotbeenordered4&(trans.source.arrows-trans.darrows)|nac.src=n0) and (no nac:ANSendSampleNCollectBlood&(trans.source.arrows-trans.darrows)|nac.src=n0) and (some e2:ABlood&trans.aarrows|let n2=e2.src|
	(n2 in (trans.source.nodes-trans.dnodes) and e2.trg=n1 and (no nac:ABlood&(trans.source.arrows-trans.darrows)|nac.src=n2))))

	#NCollectBlood&trans.anodes = 1
	#ABlood&trans.aarrows = 1
	#ANSendSampleNCollectBlood&trans.aarrows = 1
	no trans.dnodes
	no (NScanPatientWristband+NSelectBookpreexamination+NSendSampleOrder+NOrderBlood+NMeasuretemperaturebloodpressureandpulse+Nperformtransfusion+NIdentifynurselogtransfusion+NScanNurseCard+NShowNurseInfo+NSelectBlodTypeing+NShowPatientInfo+NOrderSample+NGetNurseInfo+NGetPatientInfo+NGetSampleInfo+NScannPatientWristband+NScanSample+NGetPatientInfo0+NCollectSample+NSelectBloodProduct+NGetDoctorInfo+NSelectDepartment+NSendBloodOrder+NSendSample+NScanBloodProduct+NVerifyBloodProduct+NStopTransfusionContactAIT+NStorePatientCondition+NRegisterReaction+NStoreTransfusion+NPutBloodIntorefrigertor+NOrderBloodProduct+NPrintSampleLabel+NInit)&trans.anodes
	no trans.darrows
	no (ANOrderSampleNSelectBookpreexamination+ANSelectBookpreexaminationNSendSampleOrder+ANperformtransfusionNIdentifynurselogtransfusion+Aouttimelessthan4h+ANShowNurseInfoNScanPatientWristband+APatienthasnotbeenbloodtyped+ANSelectBlodTypeingNSendSampleOrder+ANursename+ANurseisnotfound+ABarcode+APatientnameIDgenderblodtypescreening+APatientisnotfound+ASample+ABarcode1+ABarcode2+APatient+ABloodhavenotbeenordered+ANCollectSampleNScanSample+ANOrderBloodNSelectBloodProduct+ABarcode3+ADoctor+ADepartment+ASampleshavenotbeensent+ASampleisnotforthepatient+ABloodhavenotbeenordered4+ABarcodePatient+AThebloodProductisnotforthepatient+AThebloodisforthepatient+APatienttemppressure_highpressure_lowpulse+AMoreblood+ABarcode5+ANShowPatientInfoNOrderBlood+AReactiontype+ATransfusionNurse+Aouttimelessthen05h+Aouttimelessthan4h6+ABloodOrderquantityexpectTime+Abloodtypeisunknownorscreeningisnotdoneorinvalidscreenisvalidwithin4days+ASampleshavenotbeenordered+ANperformtransfusionNMeasuretemperaturebloodpressureandpulse+ANMeasuretemperaturebloodpressureandpulseNperformtransfusion+ASampleLabelFile+ALabel+ANInitNScanNurseCard)&trans.aarrows
}

//the predicate that the transformation is an application of the rule SendSampleOrderBlood
pred rule_SendSampleOrderBlood[trans:Trans]{
	some trans.rule&SendSampleOrderBlood


some e0:ABloodhavenotbeenordered4&trans.aarrows|let n0=e0.src,n1=e0.trg|
	(n0 in (trans.source.nodes-trans.dnodes) and n1 in trans.anodes and (no nac:ABloodhavenotbeenordered4&(trans.source.arrows-trans.darrows)|nac.src=n0) and (no nac:ANSendSampleNCollectBlood&(trans.source.arrows-trans.darrows)|nac.src=n0))

	#NOrderBlood&trans.anodes = 1
	#ABloodhavenotbeenordered4&trans.aarrows = 1
	no trans.dnodes
	no (NScanPatientWristband+NSelectBookpreexamination+NSendSampleOrder+NCollectBlood+NMeasuretemperaturebloodpressureandpulse+Nperformtransfusion+NIdentifynurselogtransfusion+NScanNurseCard+NShowNurseInfo+NSelectBlodTypeing+NShowPatientInfo+NOrderSample+NGetNurseInfo+NGetPatientInfo+NGetSampleInfo+NScannPatientWristband+NScanSample+NGetPatientInfo0+NCollectSample+NSelectBloodProduct+NGetDoctorInfo+NSelectDepartment+NSendBloodOrder+NSendSample+NScanBloodProduct+NVerifyBloodProduct+NStopTransfusionContactAIT+NStorePatientCondition+NRegisterReaction+NStoreTransfusion+NPutBloodIntorefrigertor+NOrderBloodProduct+NPrintSampleLabel+NInit)&trans.anodes
	no trans.darrows
	no (ANOrderSampleNSelectBookpreexamination+ANSelectBookpreexaminationNSendSampleOrder+ANperformtransfusionNIdentifynurselogtransfusion+Aouttimelessthan4h+ANShowNurseInfoNScanPatientWristband+APatienthasnotbeenbloodtyped+ANSelectBlodTypeingNSendSampleOrder+ANursename+ANurseisnotfound+ABarcode+APatientnameIDgenderblodtypescreening+APatientisnotfound+ASample+ABarcode1+ABarcode2+APatient+ABloodhavenotbeenordered+ANCollectSampleNScanSample+ANOrderBloodNSelectBloodProduct+ABarcode3+ADoctor+ADepartment+ASampleshavenotbeensent+ASampleisnotforthepatient+ABarcodePatient+AThebloodProductisnotforthepatient+AThebloodisforthepatient+APatienttemppressure_highpressure_lowpulse+AMoreblood+ABarcode5+ANShowPatientInfoNOrderBlood+AReactiontype+ATransfusionNurse+Aouttimelessthen05h+Aouttimelessthan4h6+ABloodOrderquantityexpectTime+ABlood+ANSendSampleNCollectBlood+Abloodtypeisunknownorscreeningisnotdoneorinvalidscreenisvalidwithin4days+ASampleshavenotbeenordered+ANperformtransfusionNMeasuretemperaturebloodpressureandpulse+ANMeasuretemperaturebloodpressureandpulseNperformtransfusion+ASampleLabelFile+ALabel+ANInitNScanNurseCard)&trans.aarrows
}

//the predicate that the transformation is an application of the rule SendSampleOrderOrderBlood
pred rule_SendSampleOrderOrderBlood[trans:Trans]{
	some trans.rule&SendSampleOrderOrderBlood


some e0:ABloodhavenotbeenordered&trans.aarrows|let n0=e0.src,n1=e0.trg|
	(n0 in (trans.source.nodes-trans.dnodes) and n1 in trans.anodes and (no nac:ABloodhavenotbeenordered&(trans.source.arrows-trans.darrows)|nac.src=n0) and (no nac:ASampleLabelFile&(trans.source.arrows-trans.darrows)|nac.src=n0))

	#NOrderBlood&trans.anodes = 1
	#ABloodhavenotbeenordered&trans.aarrows = 1
	no trans.dnodes
	no (NScanPatientWristband+NSelectBookpreexamination+NSendSampleOrder+NCollectBlood+NMeasuretemperaturebloodpressureandpulse+Nperformtransfusion+NIdentifynurselogtransfusion+NScanNurseCard+NShowNurseInfo+NSelectBlodTypeing+NShowPatientInfo+NOrderSample+NGetNurseInfo+NGetPatientInfo+NGetSampleInfo+NScannPatientWristband+NScanSample+NGetPatientInfo0+NCollectSample+NSelectBloodProduct+NGetDoctorInfo+NSelectDepartment+NSendBloodOrder+NSendSample+NScanBloodProduct+NVerifyBloodProduct+NStopTransfusionContactAIT+NStorePatientCondition+NRegisterReaction+NStoreTransfusion+NPutBloodIntorefrigertor+NOrderBloodProduct+NPrintSampleLabel+NInit)&trans.anodes
	no trans.darrows
	no (ANOrderSampleNSelectBookpreexamination+ANSelectBookpreexaminationNSendSampleOrder+ANperformtransfusionNIdentifynurselogtransfusion+Aouttimelessthan4h+ANShowNurseInfoNScanPatientWristband+APatienthasnotbeenbloodtyped+ANSelectBlodTypeingNSendSampleOrder+ANursename+ANurseisnotfound+ABarcode+APatientnameIDgenderblodtypescreening+APatientisnotfound+ASample+ABarcode1+ABarcode2+APatient+ANCollectSampleNScanSample+ANOrderBloodNSelectBloodProduct+ABarcode3+ADoctor+ADepartment+ASampleshavenotbeensent+ASampleisnotforthepatient+ABloodhavenotbeenordered4+ABarcodePatient+AThebloodProductisnotforthepatient+AThebloodisforthepatient+APatienttemppressure_highpressure_lowpulse+AMoreblood+ABarcode5+ANShowPatientInfoNOrderBlood+AReactiontype+ATransfusionNurse+Aouttimelessthen05h+Aouttimelessthan4h6+ABloodOrderquantityexpectTime+ABlood+ANSendSampleNCollectBlood+Abloodtypeisunknownorscreeningisnotdoneorinvalidscreenisvalidwithin4days+ASampleshavenotbeenordered+ANperformtransfusionNMeasuretemperaturebloodpressureandpulse+ANMeasuretemperaturebloodpressureandpulseNperformtransfusion+ASampleLabelFile+ALabel+ANInitNScanNurseCard)&trans.aarrows
}

//the predicate that the transformation is an application of the rule SendSampleOrderPrintSampleLabel
pred rule_SendSampleOrderPrintSampleLabel[trans:Trans]{
	some trans.rule&SendSampleOrderPrintSampleLabel


some e0:ASampleLabelFile&trans.aarrows|let n0=e0.src,n1=e0.trg|
	(n0 in (trans.source.nodes-trans.dnodes) and n1 in trans.anodes and (no nac:ABloodhavenotbeenordered&(trans.source.arrows-trans.darrows)|nac.src=n0) and (no nac:ASampleLabelFile&(trans.source.arrows-trans.darrows)|nac.src=n0))

	#NPrintSampleLabel&trans.anodes = 1
	#ASampleLabelFile&trans.aarrows = 1
	no trans.dnodes
	no (NScanPatientWristband+NSelectBookpreexamination+NSendSampleOrder+NOrderBlood+NCollectBlood+NMeasuretemperaturebloodpressureandpulse+Nperformtransfusion+NIdentifynurselogtransfusion+NScanNurseCard+NShowNurseInfo+NSelectBlodTypeing+NShowPatientInfo+NOrderSample+NGetNurseInfo+NGetPatientInfo+NGetSampleInfo+NScannPatientWristband+NScanSample+NGetPatientInfo0+NCollectSample+NSelectBloodProduct+NGetDoctorInfo+NSelectDepartment+NSendBloodOrder+NSendSample+NScanBloodProduct+NVerifyBloodProduct+NStopTransfusionContactAIT+NStorePatientCondition+NRegisterReaction+NStoreTransfusion+NPutBloodIntorefrigertor+NOrderBloodProduct+NInit)&trans.anodes
	no trans.darrows
	no (ANOrderSampleNSelectBookpreexamination+ANSelectBookpreexaminationNSendSampleOrder+ANperformtransfusionNIdentifynurselogtransfusion+Aouttimelessthan4h+ANShowNurseInfoNScanPatientWristband+APatienthasnotbeenbloodtyped+ANSelectBlodTypeingNSendSampleOrder+ANursename+ANurseisnotfound+ABarcode+APatientnameIDgenderblodtypescreening+APatientisnotfound+ASample+ABarcode1+ABarcode2+APatient+ABloodhavenotbeenordered+ANCollectSampleNScanSample+ANOrderBloodNSelectBloodProduct+ABarcode3+ADoctor+ADepartment+ASampleshavenotbeensent+ASampleisnotforthepatient+ABloodhavenotbeenordered4+ABarcodePatient+AThebloodProductisnotforthepatient+AThebloodisforthepatient+APatienttemppressure_highpressure_lowpulse+AMoreblood+ABarcode5+ANShowPatientInfoNOrderBlood+AReactiontype+ATransfusionNurse+Aouttimelessthen05h+Aouttimelessthan4h6+ABloodOrderquantityexpectTime+ABlood+ANSendSampleNCollectBlood+Abloodtypeisunknownorscreeningisnotdoneorinvalidscreenisvalidwithin4days+ASampleshavenotbeenordered+ANperformtransfusionNMeasuretemperaturebloodpressureandpulse+ANMeasuretemperaturebloodpressureandpulseNperformtransfusion+ALabel+ANInitNScanNurseCard)&trans.aarrows
}

//the predicate that the transformation is an application of the rule ShowNurseInfoScanPatientWristband
pred rule_ShowNurseInfoScanPatientWristband[trans:Trans]{
	some trans.rule&ShowNurseInfoScanPatientWristband


some e0:ANShowNurseInfoNScanPatientWristband&trans.aarrows|let n0=e0.src,n1=e0.trg|
	(n0 in (trans.source.nodes-trans.dnodes) and n1 in trans.anodes and (no nac:ANShowNurseInfoNScanPatientWristband&(trans.source.arrows-trans.darrows)|nac.src=n0))

	#NScanPatientWristband&trans.anodes = 1
	#ANShowNurseInfoNScanPatientWristband&trans.aarrows = 1
	no trans.dnodes
	no (NSelectBookpreexamination+NSendSampleOrder+NOrderBlood+NCollectBlood+NMeasuretemperaturebloodpressureandpulse+Nperformtransfusion+NIdentifynurselogtransfusion+NScanNurseCard+NShowNurseInfo+NSelectBlodTypeing+NShowPatientInfo+NOrderSample+NGetNurseInfo+NGetPatientInfo+NGetSampleInfo+NScannPatientWristband+NScanSample+NGetPatientInfo0+NCollectSample+NSelectBloodProduct+NGetDoctorInfo+NSelectDepartment+NSendBloodOrder+NSendSample+NScanBloodProduct+NVerifyBloodProduct+NStopTransfusionContactAIT+NStorePatientCondition+NRegisterReaction+NStoreTransfusion+NPutBloodIntorefrigertor+NOrderBloodProduct+NPrintSampleLabel+NInit)&trans.anodes
	no trans.darrows
	no (ANOrderSampleNSelectBookpreexamination+ANSelectBookpreexaminationNSendSampleOrder+ANperformtransfusionNIdentifynurselogtransfusion+Aouttimelessthan4h+APatienthasnotbeenbloodtyped+ANSelectBlodTypeingNSendSampleOrder+ANursename+ANurseisnotfound+ABarcode+APatientnameIDgenderblodtypescreening+APatientisnotfound+ASample+ABarcode1+ABarcode2+APatient+ABloodhavenotbeenordered+ANCollectSampleNScanSample+ANOrderBloodNSelectBloodProduct+ABarcode3+ADoctor+ADepartment+ASampleshavenotbeensent+ASampleisnotforthepatient+ABloodhavenotbeenordered4+ABarcodePatient+AThebloodProductisnotforthepatient+AThebloodisforthepatient+APatienttemppressure_highpressure_lowpulse+AMoreblood+ABarcode5+ANShowPatientInfoNOrderBlood+AReactiontype+ATransfusionNurse+Aouttimelessthen05h+Aouttimelessthan4h6+ABloodOrderquantityexpectTime+ABlood+ANSendSampleNCollectBlood+Abloodtypeisunknownorscreeningisnotdoneorinvalidscreenisvalidwithin4days+ASampleshavenotbeenordered+ANperformtransfusionNMeasuretemperaturebloodpressureandpulse+ANMeasuretemperaturebloodpressureandpulseNperformtransfusion+ASampleLabelFile+ALabel+ANInitNScanNurseCard)&trans.aarrows
}

//the predicate that the transformation is an application of the rule ShowPatientInfoOrderBlood
pred rule_ShowPatientInfoOrderBlood[trans:Trans]{
	some trans.rule&ShowPatientInfoOrderBlood


some e0:ANShowPatientInfoNOrderBlood&trans.aarrows|let n0=e0.src,n1=e0.trg|
	(n0 in (trans.source.nodes-trans.dnodes) and n1 in trans.anodes and (no nac:ANShowPatientInfoNOrderBlood&(trans.source.arrows-trans.darrows)|nac.src=n0) and (no nac:Abloodtypeisunknownorscreeningisnotdoneorinvalidscreenisvalidwithin4days&(trans.source.arrows-trans.darrows)|nac.src=n0))

	#NOrderBlood&trans.anodes = 1
	#ANShowPatientInfoNOrderBlood&trans.aarrows = 1
	no trans.dnodes
	no (NScanPatientWristband+NSelectBookpreexamination+NSendSampleOrder+NCollectBlood+NMeasuretemperaturebloodpressureandpulse+Nperformtransfusion+NIdentifynurselogtransfusion+NScanNurseCard+NShowNurseInfo+NSelectBlodTypeing+NShowPatientInfo+NOrderSample+NGetNurseInfo+NGetPatientInfo+NGetSampleInfo+NScannPatientWristband+NScanSample+NGetPatientInfo0+NCollectSample+NSelectBloodProduct+NGetDoctorInfo+NSelectDepartment+NSendBloodOrder+NSendSample+NScanBloodProduct+NVerifyBloodProduct+NStopTransfusionContactAIT+NStorePatientCondition+NRegisterReaction+NStoreTransfusion+NPutBloodIntorefrigertor+NOrderBloodProduct+NPrintSampleLabel+NInit)&trans.anodes
	no trans.darrows
	no (ANOrderSampleNSelectBookpreexamination+ANSelectBookpreexaminationNSendSampleOrder+ANperformtransfusionNIdentifynurselogtransfusion+Aouttimelessthan4h+ANShowNurseInfoNScanPatientWristband+APatienthasnotbeenbloodtyped+ANSelectBlodTypeingNSendSampleOrder+ANursename+ANurseisnotfound+ABarcode+APatientnameIDgenderblodtypescreening+APatientisnotfound+ASample+ABarcode1+ABarcode2+APatient+ABloodhavenotbeenordered+ANCollectSampleNScanSample+ANOrderBloodNSelectBloodProduct+ABarcode3+ADoctor+ADepartment+ASampleshavenotbeensent+ASampleisnotforthepatient+ABloodhavenotbeenordered4+ABarcodePatient+AThebloodProductisnotforthepatient+AThebloodisforthepatient+APatienttemppressure_highpressure_lowpulse+AMoreblood+ABarcode5+AReactiontype+ATransfusionNurse+Aouttimelessthen05h+Aouttimelessthan4h6+ABloodOrderquantityexpectTime+ABlood+ANSendSampleNCollectBlood+Abloodtypeisunknownorscreeningisnotdoneorinvalidscreenisvalidwithin4days+ASampleshavenotbeenordered+ANperformtransfusionNMeasuretemperaturebloodpressureandpulse+ANMeasuretemperaturebloodpressureandpulseNperformtransfusion+ASampleLabelFile+ALabel+ANInitNScanNurseCard)&trans.aarrows
}

//the predicate that the transformation is an application of the rule ShowPatientInfoOrderSample
pred rule_ShowPatientInfoOrderSample[trans:Trans]{
	some trans.rule&ShowPatientInfoOrderSample


some e0:Abloodtypeisunknownorscreeningisnotdoneorinvalidscreenisvalidwithin4days&trans.aarrows|let n0=e0.src,n1=e0.trg|
	(n0 in (trans.source.nodes-trans.dnodes) and n1 in trans.anodes and (no nac:ANShowPatientInfoNOrderBlood&(trans.source.arrows-trans.darrows)|nac.src=n0) and (no nac:Abloodtypeisunknownorscreeningisnotdoneorinvalidscreenisvalidwithin4days&(trans.source.arrows-trans.darrows)|nac.src=n0))

	#NOrderSample&trans.anodes = 1
	#Abloodtypeisunknownorscreeningisnotdoneorinvalidscreenisvalidwithin4days&trans.aarrows = 1
	no trans.dnodes
	no (NScanPatientWristband+NSelectBookpreexamination+NSendSampleOrder+NOrderBlood+NCollectBlood+NMeasuretemperaturebloodpressureandpulse+Nperformtransfusion+NIdentifynurselogtransfusion+NScanNurseCard+NShowNurseInfo+NSelectBlodTypeing+NShowPatientInfo+NGetNurseInfo+NGetPatientInfo+NGetSampleInfo+NScannPatientWristband+NScanSample+NGetPatientInfo0+NCollectSample+NSelectBloodProduct+NGetDoctorInfo+NSelectDepartment+NSendBloodOrder+NSendSample+NScanBloodProduct+NVerifyBloodProduct+NStopTransfusionContactAIT+NStorePatientCondition+NRegisterReaction+NStoreTransfusion+NPutBloodIntorefrigertor+NOrderBloodProduct+NPrintSampleLabel+NInit)&trans.anodes
	no trans.darrows
	no (ANOrderSampleNSelectBookpreexamination+ANSelectBookpreexaminationNSendSampleOrder+ANperformtransfusionNIdentifynurselogtransfusion+Aouttimelessthan4h+ANShowNurseInfoNScanPatientWristband+APatienthasnotbeenbloodtyped+ANSelectBlodTypeingNSendSampleOrder+ANursename+ANurseisnotfound+ABarcode+APatientnameIDgenderblodtypescreening+APatientisnotfound+ASample+ABarcode1+ABarcode2+APatient+ABloodhavenotbeenordered+ANCollectSampleNScanSample+ANOrderBloodNSelectBloodProduct+ABarcode3+ADoctor+ADepartment+ASampleshavenotbeensent+ASampleisnotforthepatient+ABloodhavenotbeenordered4+ABarcodePatient+AThebloodProductisnotforthepatient+AThebloodisforthepatient+APatienttemppressure_highpressure_lowpulse+AMoreblood+ABarcode5+ANShowPatientInfoNOrderBlood+AReactiontype+ATransfusionNurse+Aouttimelessthen05h+Aouttimelessthan4h6+ABloodOrderquantityexpectTime+ABlood+ANSendSampleNCollectBlood+ASampleshavenotbeenordered+ANperformtransfusionNMeasuretemperaturebloodpressureandpulse+ANMeasuretemperaturebloodpressureandpulseNperformtransfusion+ASampleLabelFile+ALabel+ANInitNScanNurseCard)&trans.aarrows
}

//the predicate that the transformation is an application of the rule VerifyBloodProductStopTransfusionContactAIT
pred rule_VerifyBloodProductStopTransfusionContactAIT[trans:Trans]{
	some trans.rule&VerifyBloodProductStopTransfusionContactAIT


some e0:AThebloodProductisnotforthepatient&trans.aarrows|let n0=e0.src,n1=e0.trg|
	(n0 in (trans.source.nodes-trans.dnodes) and n1 in trans.anodes and (no nac:AThebloodProductisnotforthepatient&(trans.source.arrows-trans.darrows)|nac.src=n0) and (no nac:AThebloodisforthepatient&(trans.source.arrows-trans.darrows)|nac.src=n0))

	#NStopTransfusionContactAIT&trans.anodes = 1
	#AThebloodProductisnotforthepatient&trans.aarrows = 1
	no trans.dnodes
	no (NScanPatientWristband+NSelectBookpreexamination+NSendSampleOrder+NOrderBlood+NCollectBlood+NMeasuretemperaturebloodpressureandpulse+Nperformtransfusion+NIdentifynurselogtransfusion+NScanNurseCard+NShowNurseInfo+NSelectBlodTypeing+NShowPatientInfo+NOrderSample+NGetNurseInfo+NGetPatientInfo+NGetSampleInfo+NScannPatientWristband+NScanSample+NGetPatientInfo0+NCollectSample+NSelectBloodProduct+NGetDoctorInfo+NSelectDepartment+NSendBloodOrder+NSendSample+NScanBloodProduct+NVerifyBloodProduct+NStorePatientCondition+NRegisterReaction+NStoreTransfusion+NPutBloodIntorefrigertor+NOrderBloodProduct+NPrintSampleLabel+NInit)&trans.anodes
	no trans.darrows
	no (ANOrderSampleNSelectBookpreexamination+ANSelectBookpreexaminationNSendSampleOrder+ANperformtransfusionNIdentifynurselogtransfusion+Aouttimelessthan4h+ANShowNurseInfoNScanPatientWristband+APatienthasnotbeenbloodtyped+ANSelectBlodTypeingNSendSampleOrder+ANursename+ANurseisnotfound+ABarcode+APatientnameIDgenderblodtypescreening+APatientisnotfound+ASample+ABarcode1+ABarcode2+APatient+ABloodhavenotbeenordered+ANCollectSampleNScanSample+ANOrderBloodNSelectBloodProduct+ABarcode3+ADoctor+ADepartment+ASampleshavenotbeensent+ASampleisnotforthepatient+ABloodhavenotbeenordered4+ABarcodePatient+AThebloodisforthepatient+APatienttemppressure_highpressure_lowpulse+AMoreblood+ABarcode5+ANShowPatientInfoNOrderBlood+AReactiontype+ATransfusionNurse+Aouttimelessthen05h+Aouttimelessthan4h6+ABloodOrderquantityexpectTime+ABlood+ANSendSampleNCollectBlood+Abloodtypeisunknownorscreeningisnotdoneorinvalidscreenisvalidwithin4days+ASampleshavenotbeenordered+ANperformtransfusionNMeasuretemperaturebloodpressureandpulse+ANMeasuretemperaturebloodpressureandpulseNperformtransfusion+ASampleLabelFile+ALabel+ANInitNScanNurseCard)&trans.aarrows
}

//the predicate that the transformation is an application of the rule VerifyBloodProductperformtransfusion
pred rule_VerifyBloodProductperformtransfusion[trans:Trans]{
	some trans.rule&VerifyBloodProductperformtransfusion


some e0:AThebloodisforthepatient&trans.aarrows|let n0=e0.src,n1=e0.trg|
	(n0 in (trans.source.nodes-trans.dnodes) and n1 in trans.anodes and (no nac:AThebloodProductisnotforthepatient&(trans.source.arrows-trans.darrows)|nac.src=n0) and (no nac:AThebloodisforthepatient&(trans.source.arrows-trans.darrows)|nac.src=n0))

	#Nperformtransfusion&trans.anodes = 1
	#AThebloodisforthepatient&trans.aarrows = 1
	no trans.dnodes
	no (NScanPatientWristband+NSelectBookpreexamination+NSendSampleOrder+NOrderBlood+NCollectBlood+NMeasuretemperaturebloodpressureandpulse+NIdentifynurselogtransfusion+NScanNurseCard+NShowNurseInfo+NSelectBlodTypeing+NShowPatientInfo+NOrderSample+NGetNurseInfo+NGetPatientInfo+NGetSampleInfo+NScannPatientWristband+NScanSample+NGetPatientInfo0+NCollectSample+NSelectBloodProduct+NGetDoctorInfo+NSelectDepartment+NSendBloodOrder+NSendSample+NScanBloodProduct+NVerifyBloodProduct+NStopTransfusionContactAIT+NStorePatientCondition+NRegisterReaction+NStoreTransfusion+NPutBloodIntorefrigertor+NOrderBloodProduct+NPrintSampleLabel+NInit)&trans.anodes
	no trans.darrows
	no (ANOrderSampleNSelectBookpreexamination+ANSelectBookpreexaminationNSendSampleOrder+ANperformtransfusionNIdentifynurselogtransfusion+Aouttimelessthan4h+ANShowNurseInfoNScanPatientWristband+APatienthasnotbeenbloodtyped+ANSelectBlodTypeingNSendSampleOrder+ANursename+ANurseisnotfound+ABarcode+APatientnameIDgenderblodtypescreening+APatientisnotfound+ASample+ABarcode1+ABarcode2+APatient+ABloodhavenotbeenordered+ANCollectSampleNScanSample+ANOrderBloodNSelectBloodProduct+ABarcode3+ADoctor+ADepartment+ASampleshavenotbeensent+ASampleisnotforthepatient+ABloodhavenotbeenordered4+ABarcodePatient+AThebloodProductisnotforthepatient+APatienttemppressure_highpressure_lowpulse+AMoreblood+ABarcode5+ANShowPatientInfoNOrderBlood+AReactiontype+ATransfusionNurse+Aouttimelessthen05h+Aouttimelessthan4h6+ABloodOrderquantityexpectTime+ABlood+ANSendSampleNCollectBlood+Abloodtypeisunknownorscreeningisnotdoneorinvalidscreenisvalidwithin4days+ASampleshavenotbeenordered+ANperformtransfusionNMeasuretemperaturebloodpressureandpulse+ANMeasuretemperaturebloodpressureandpulseNperformtransfusion+ASampleLabelFile+ALabel+ANInitNScanNurseCard)&trans.aarrows
}

//the predicate that the transformation is an application of the rule performtransfusionIdentifynurselogtransfusion
pred rule_performtransfusionIdentifynurselogtransfusion[trans:Trans]{
	some trans.rule&performtransfusionIdentifynurselogtransfusion


some e0:ANperformtransfusionNIdentifynurselogtransfusion&trans.aarrows|let n0=e0.src,n1=e0.trg|
	(n0 in (trans.source.nodes-trans.dnodes) and n1 in trans.anodes and (no nac:ANperformtransfusionNIdentifynurselogtransfusion&(trans.source.arrows-trans.darrows)|nac.src=n0) and (no nac:AMoreblood&(trans.source.arrows-trans.darrows)|nac.src=n0) and (no nac:AReactiontype&(trans.source.arrows-trans.darrows)|nac.src=n0) and (no nac:ANperformtransfusionNMeasuretemperaturebloodpressureandpulse&(trans.source.arrows-trans.darrows)|nac.src=n0))

	#NIdentifynurselogtransfusion&trans.anodes = 1
	#ANperformtransfusionNIdentifynurselogtransfusion&trans.aarrows = 1
	no trans.dnodes
	no (NScanPatientWristband+NSelectBookpreexamination+NSendSampleOrder+NOrderBlood+NCollectBlood+NMeasuretemperaturebloodpressureandpulse+Nperformtransfusion+NScanNurseCard+NShowNurseInfo+NSelectBlodTypeing+NShowPatientInfo+NOrderSample+NGetNurseInfo+NGetPatientInfo+NGetSampleInfo+NScannPatientWristband+NScanSample+NGetPatientInfo0+NCollectSample+NSelectBloodProduct+NGetDoctorInfo+NSelectDepartment+NSendBloodOrder+NSendSample+NScanBloodProduct+NVerifyBloodProduct+NStopTransfusionContactAIT+NStorePatientCondition+NRegisterReaction+NStoreTransfusion+NPutBloodIntorefrigertor+NOrderBloodProduct+NPrintSampleLabel+NInit)&trans.anodes
	no trans.darrows
	no (ANOrderSampleNSelectBookpreexamination+ANSelectBookpreexaminationNSendSampleOrder+Aouttimelessthan4h+ANShowNurseInfoNScanPatientWristband+APatienthasnotbeenbloodtyped+ANSelectBlodTypeingNSendSampleOrder+ANursename+ANurseisnotfound+ABarcode+APatientnameIDgenderblodtypescreening+APatientisnotfound+ASample+ABarcode1+ABarcode2+APatient+ABloodhavenotbeenordered+ANCollectSampleNScanSample+ANOrderBloodNSelectBloodProduct+ABarcode3+ADoctor+ADepartment+ASampleshavenotbeensent+ASampleisnotforthepatient+ABloodhavenotbeenordered4+ABarcodePatient+AThebloodProductisnotforthepatient+AThebloodisforthepatient+APatienttemppressure_highpressure_lowpulse+AMoreblood+ABarcode5+ANShowPatientInfoNOrderBlood+AReactiontype+ATransfusionNurse+Aouttimelessthen05h+Aouttimelessthan4h6+ABloodOrderquantityexpectTime+ABlood+ANSendSampleNCollectBlood+Abloodtypeisunknownorscreeningisnotdoneorinvalidscreenisvalidwithin4days+ASampleshavenotbeenordered+ANperformtransfusionNMeasuretemperaturebloodpressureandpulse+ANMeasuretemperaturebloodpressureandpulseNperformtransfusion+ASampleLabelFile+ALabel+ANInitNScanNurseCard)&trans.aarrows
}

//the predicate that the transformation is an application of the rule performtransfusionMeasuretemperaturebloodpressureandpulse
pred rule_performtransfusionMeasuretemperaturebloodpressureandpulse[trans:Trans]{
	some trans.rule&performtransfusionMeasuretemperaturebloodpressureandpulse


some e0:ANperformtransfusionNMeasuretemperaturebloodpressureandpulse&trans.aarrows|let n0=e0.src,n1=e0.trg|
	(n0 in (trans.source.nodes-trans.dnodes) and n1 in trans.anodes and (no nac:ANperformtransfusionNIdentifynurselogtransfusion&(trans.source.arrows-trans.darrows)|nac.src=n0) and (no nac:AMoreblood&(trans.source.arrows-trans.darrows)|nac.src=n0) and (no nac:AReactiontype&(trans.source.arrows-trans.darrows)|nac.src=n0) and (no nac:ANperformtransfusionNMeasuretemperaturebloodpressureandpulse&(trans.source.arrows-trans.darrows)|nac.src=n0))

	#NMeasuretemperaturebloodpressureandpulse&trans.anodes = 1
	#ANperformtransfusionNMeasuretemperaturebloodpressureandpulse&trans.aarrows = 1
	no trans.dnodes
	no (NScanPatientWristband+NSelectBookpreexamination+NSendSampleOrder+NOrderBlood+NCollectBlood+Nperformtransfusion+NIdentifynurselogtransfusion+NScanNurseCard+NShowNurseInfo+NSelectBlodTypeing+NShowPatientInfo+NOrderSample+NGetNurseInfo+NGetPatientInfo+NGetSampleInfo+NScannPatientWristband+NScanSample+NGetPatientInfo0+NCollectSample+NSelectBloodProduct+NGetDoctorInfo+NSelectDepartment+NSendBloodOrder+NSendSample+NScanBloodProduct+NVerifyBloodProduct+NStopTransfusionContactAIT+NStorePatientCondition+NRegisterReaction+NStoreTransfusion+NPutBloodIntorefrigertor+NOrderBloodProduct+NPrintSampleLabel+NInit)&trans.anodes
	no trans.darrows
	no (ANOrderSampleNSelectBookpreexamination+ANSelectBookpreexaminationNSendSampleOrder+ANperformtransfusionNIdentifynurselogtransfusion+Aouttimelessthan4h+ANShowNurseInfoNScanPatientWristband+APatienthasnotbeenbloodtyped+ANSelectBlodTypeingNSendSampleOrder+ANursename+ANurseisnotfound+ABarcode+APatientnameIDgenderblodtypescreening+APatientisnotfound+ASample+ABarcode1+ABarcode2+APatient+ABloodhavenotbeenordered+ANCollectSampleNScanSample+ANOrderBloodNSelectBloodProduct+ABarcode3+ADoctor+ADepartment+ASampleshavenotbeensent+ASampleisnotforthepatient+ABloodhavenotbeenordered4+ABarcodePatient+AThebloodProductisnotforthepatient+AThebloodisforthepatient+APatienttemppressure_highpressure_lowpulse+AMoreblood+ABarcode5+ANShowPatientInfoNOrderBlood+AReactiontype+ATransfusionNurse+Aouttimelessthen05h+Aouttimelessthan4h6+ABloodOrderquantityexpectTime+ABlood+ANSendSampleNCollectBlood+Abloodtypeisunknownorscreeningisnotdoneorinvalidscreenisvalidwithin4days+ASampleshavenotbeenordered+ANMeasuretemperaturebloodpressureandpulseNperformtransfusion+ASampleLabelFile+ALabel+ANInitNScanNurseCard)&trans.aarrows
}

//the predicate that the transformation is an application of the rule performtransfusionRegisterReaction
pred rule_performtransfusionRegisterReaction[trans:Trans]{
	some trans.rule&performtransfusionRegisterReaction


some e0:AReactiontype&trans.aarrows|let n0=e0.src,n1=e0.trg|
	(n0 in (trans.source.nodes-trans.dnodes) and n1 in trans.anodes and (no nac:ANperformtransfusionNIdentifynurselogtransfusion&(trans.source.arrows-trans.darrows)|nac.src=n0) and (no nac:AMoreblood&(trans.source.arrows-trans.darrows)|nac.src=n0) and (no nac:AReactiontype&(trans.source.arrows-trans.darrows)|nac.src=n0) and (no nac:ANperformtransfusionNMeasuretemperaturebloodpressureandpulse&(trans.source.arrows-trans.darrows)|nac.src=n0))

	#NRegisterReaction&trans.anodes = 1
	#AReactiontype&trans.aarrows = 1
	no trans.dnodes
	no (NScanPatientWristband+NSelectBookpreexamination+NSendSampleOrder+NOrderBlood+NCollectBlood+NMeasuretemperaturebloodpressureandpulse+Nperformtransfusion+NIdentifynurselogtransfusion+NScanNurseCard+NShowNurseInfo+NSelectBlodTypeing+NShowPatientInfo+NOrderSample+NGetNurseInfo+NGetPatientInfo+NGetSampleInfo+NScannPatientWristband+NScanSample+NGetPatientInfo0+NCollectSample+NSelectBloodProduct+NGetDoctorInfo+NSelectDepartment+NSendBloodOrder+NSendSample+NScanBloodProduct+NVerifyBloodProduct+NStopTransfusionContactAIT+NStorePatientCondition+NStoreTransfusion+NPutBloodIntorefrigertor+NOrderBloodProduct+NPrintSampleLabel+NInit)&trans.anodes
	no trans.darrows
	no (ANOrderSampleNSelectBookpreexamination+ANSelectBookpreexaminationNSendSampleOrder+ANperformtransfusionNIdentifynurselogtransfusion+Aouttimelessthan4h+ANShowNurseInfoNScanPatientWristband+APatienthasnotbeenbloodtyped+ANSelectBlodTypeingNSendSampleOrder+ANursename+ANurseisnotfound+ABarcode+APatientnameIDgenderblodtypescreening+APatientisnotfound+ASample+ABarcode1+ABarcode2+APatient+ABloodhavenotbeenordered+ANCollectSampleNScanSample+ANOrderBloodNSelectBloodProduct+ABarcode3+ADoctor+ADepartment+ASampleshavenotbeensent+ASampleisnotforthepatient+ABloodhavenotbeenordered4+ABarcodePatient+AThebloodProductisnotforthepatient+AThebloodisforthepatient+APatienttemppressure_highpressure_lowpulse+AMoreblood+ABarcode5+ANShowPatientInfoNOrderBlood+ATransfusionNurse+Aouttimelessthen05h+Aouttimelessthan4h6+ABloodOrderquantityexpectTime+ABlood+ANSendSampleNCollectBlood+Abloodtypeisunknownorscreeningisnotdoneorinvalidscreenisvalidwithin4days+ASampleshavenotbeenordered+ANperformtransfusionNMeasuretemperaturebloodpressureandpulse+ANMeasuretemperaturebloodpressureandpulseNperformtransfusion+ASampleLabelFile+ALabel+ANInitNScanNurseCard)&trans.aarrows
}

//the predicate that the transformation is an application of the rule performtransfusionScanBloodProduct
pred rule_performtransfusionScanBloodProduct[trans:Trans]{
	some trans.rule&performtransfusionScanBloodProduct


some e0:AMoreblood&trans.aarrows|let n0=e0.src,n1=e0.trg|
	(n0 in (trans.source.nodes-trans.dnodes) and n1 in trans.anodes and (no nac:ANperformtransfusionNIdentifynurselogtransfusion&(trans.source.arrows-trans.darrows)|nac.src=n0) and (no nac:AMoreblood&(trans.source.arrows-trans.darrows)|nac.src=n0) and (no nac:AReactiontype&(trans.source.arrows-trans.darrows)|nac.src=n0) and (no nac:ANperformtransfusionNMeasuretemperaturebloodpressureandpulse&(trans.source.arrows-trans.darrows)|nac.src=n0))

	#NScanBloodProduct&trans.anodes = 1
	#AMoreblood&trans.aarrows = 1
	no trans.dnodes
	no (NScanPatientWristband+NSelectBookpreexamination+NSendSampleOrder+NOrderBlood+NCollectBlood+NMeasuretemperaturebloodpressureandpulse+Nperformtransfusion+NIdentifynurselogtransfusion+NScanNurseCard+NShowNurseInfo+NSelectBlodTypeing+NShowPatientInfo+NOrderSample+NGetNurseInfo+NGetPatientInfo+NGetSampleInfo+NScannPatientWristband+NScanSample+NGetPatientInfo0+NCollectSample+NSelectBloodProduct+NGetDoctorInfo+NSelectDepartment+NSendBloodOrder+NSendSample+NVerifyBloodProduct+NStopTransfusionContactAIT+NStorePatientCondition+NRegisterReaction+NStoreTransfusion+NPutBloodIntorefrigertor+NOrderBloodProduct+NPrintSampleLabel+NInit)&trans.anodes
	no trans.darrows
	no (ANOrderSampleNSelectBookpreexamination+ANSelectBookpreexaminationNSendSampleOrder+ANperformtransfusionNIdentifynurselogtransfusion+Aouttimelessthan4h+ANShowNurseInfoNScanPatientWristband+APatienthasnotbeenbloodtyped+ANSelectBlodTypeingNSendSampleOrder+ANursename+ANurseisnotfound+ABarcode+APatientnameIDgenderblodtypescreening+APatientisnotfound+ASample+ABarcode1+ABarcode2+APatient+ABloodhavenotbeenordered+ANCollectSampleNScanSample+ANOrderBloodNSelectBloodProduct+ABarcode3+ADoctor+ADepartment+ASampleshavenotbeensent+ASampleisnotforthepatient+ABloodhavenotbeenordered4+ABarcodePatient+AThebloodProductisnotforthepatient+AThebloodisforthepatient+APatienttemppressure_highpressure_lowpulse+ABarcode5+ANShowPatientInfoNOrderBlood+AReactiontype+ATransfusionNurse+Aouttimelessthen05h+Aouttimelessthan4h6+ABloodOrderquantityexpectTime+ABlood+ANSendSampleNCollectBlood+Abloodtypeisunknownorscreeningisnotdoneorinvalidscreenisvalidwithin4days+ASampleshavenotbeenordered+ANperformtransfusionNMeasuretemperaturebloodpressureandpulse+ANMeasuretemperaturebloodpressureandpulseNperformtransfusion+ASampleLabelFile+ALabel+ANInitNScanNurseCard)&trans.aarrows
}

//The general constraints of a transformation
pred trans_general[trans:Trans]{
	some trans.dnodes or some trans.darrows or some trans.anodes or some trans.aarrows
	trans.dnodes in trans.source.nodes
	trans.darrows in trans.source.arrows
	trans.anodes in trans.target.nodes
	trans.aarrows in trans.target.arrows
	no (trans.dnodes & trans.anodes)
	no (trans.darrows & trans.aarrows)
	trans.source.nodes-trans.dnodes=trans.target.nodes-trans.anodes
	trans.source.arrows-trans.darrows=trans.target.arrows-trans.aarrows
}
pred source_valid[trans:Trans]{
//mulitplicity on :Order Sample->Select Book pre-examination[0,1]
all n:(NOrderSample&trans.source.nodes)| lone e:(ANOrderSampleNSelectBookpreexamination&trans.source.arrows)|e.src=n
//mulitplicity on :Select Book pre-examination->Send Sample Order[0,1]
all n:(NSelectBookpreexamination&trans.source.nodes)| lone e:(ANSelectBookpreexaminationNSendSampleOrder&trans.source.arrows)|e.src=n
//mulitplicity on :perform transfusion->Identify nurse, log transfusion[0,1]
all n:(Nperformtransfusion&trans.source.nodes)| lone e:(ANperformtransfusionNIdentifynurselogtransfusion&trans.source.arrows)|e.src=n
//mulitplicity on out time less than 4h:Collect Blood->Scan Blood Product[0,1]
all n:(NCollectBlood&trans.source.nodes)| lone e:(Aouttimelessthan4h&trans.source.arrows)|e.src=n
//mulitplicity on :Show Nurse Info->Scan Patient Wristband[0,1]
all n:(NShowNurseInfo&trans.source.nodes)| lone e:(ANShowNurseInfoNScanPatientWristband&trans.source.arrows)|e.src=n
//mulitplicity on Patient has not been bloodtyped:Order Sample->Select Blod Typeing[0,1]
all n:(NOrderSample&trans.source.nodes)| lone e:(APatienthasnotbeenbloodtyped&trans.source.arrows)|e.src=n
//mulitplicity on :Select Blod Typeing->Send Sample Order[0,1]
all n:(NSelectBlodTypeing&trans.source.nodes)| lone e:(ANSelectBlodTypeingNSendSampleOrder&trans.source.arrows)|e.src=n
//mulitplicity on (Nurse{name}):Get Nurse Info->Show Nurse Info[0,1]
all n:(NGetNurseInfo&trans.source.nodes)| lone e:(ANursename&trans.source.arrows)|e.src=n
//mulitplicity on Nurse is not found:Get Nurse Info->Scan Nurse Card[0,1]
all n:(NGetNurseInfo&trans.source.nodes)| lone e:(ANurseisnotfound&trans.source.arrows)|e.src=n
//mulitplicity on (Barcode):Scan Patient Wristband->Get Patient Info[0,1]
all n:(NScanPatientWristband&trans.source.nodes)| lone e:(ABarcode&trans.source.arrows)|e.src=n
//mulitplicity on (Patient{name, ID, gender, blodtype, screening}):Get Patient Info->Show Patient Info[0,1]
all n:(NGetPatientInfo&trans.source.nodes)| lone e:(APatientnameIDgenderblodtypescreening&trans.source.arrows)|e.src=n
//mulitplicity on Patient is not found:Get Patient Info->Scan Patient Wristband[0,1]
all n:(NGetPatientInfo&trans.source.nodes)| lone e:(APatientisnotfound&trans.source.arrows)|e.src=n
//mulitplicity on (Sample):Get Sample Info->Scann Patient Wristband[0,1]
all n:(NGetSampleInfo&trans.source.nodes)| lone e:(ASample&trans.source.arrows)|e.src=n
//mulitplicity on (Barcode):Scan Sample->Get Sample Info[0,1]
all n:(NScanSample&trans.source.nodes)| lone e:(ABarcode1&trans.source.arrows)|e.src=n
//mulitplicity on (Barcode):Scann Patient Wristband->Get Patient Info[0,1]
all n:(NScannPatientWristband&trans.source.nodes)| lone e:(ABarcode2&trans.source.arrows)|e.src=n
//mulitplicity on (Patient):Get Patient Info->Send Sample[0,1]
all n:(NGetPatientInfo0&trans.source.nodes)| lone e:(APatient&trans.source.arrows)|e.src=n
//mulitplicity on Blood have not been ordered:Send Sample Order->Order Blood[0,1]
all n:(NSendSampleOrder&trans.source.nodes)| lone e:(ABloodhavenotbeenordered&trans.source.arrows)|e.src=n
//mulitplicity on :Collect Sample->Scan Sample[0,1]
all n:(NCollectSample&trans.source.nodes)| lone e:(ANCollectSampleNScanSample&trans.source.arrows)|e.src=n
//mulitplicity on :Order Blood->Select Blood Product[0,1]
all n:(NOrderBlood&trans.source.nodes)| lone e:(ANOrderBloodNSelectBloodProduct&trans.source.arrows)|e.src=n
//mulitplicity on (Barcode):Select Blood Product->Get Doctor Info[0,1]
all n:(NSelectBloodProduct&trans.source.nodes)| lone e:(ABarcode3&trans.source.arrows)|e.src=n
//mulitplicity on (Doctor):Get Doctor Info->Select Department[0,1]
all n:(NGetDoctorInfo&trans.source.nodes)| lone e:(ADoctor&trans.source.arrows)|e.src=n
//mulitplicity on (Department):Select Department->Send Blood Order[0,1]
all n:(NSelectDepartment&trans.source.nodes)| lone e:(ADepartment&trans.source.arrows)|e.src=n
//mulitplicity on Samples have not been sent:Send Blood Order->Scan Sample[0,1]
all n:(NSendBloodOrder&trans.source.nodes)| lone e:(ASampleshavenotbeensent&trans.source.arrows)|e.src=n
//mulitplicity on Sample is not for the patient:Get Patient Info->Scan Sample[0,1]
all n:(NGetPatientInfo0&trans.source.nodes)| lone e:(ASampleisnotforthepatient&trans.source.arrows)|e.src=n
//mulitplicity on Blood have not been ordered:Send Sample->Order Blood[0,1]
all n:(NSendSample&trans.source.nodes)| lone e:(ABloodhavenotbeenordered4&trans.source.arrows)|e.src=n
//mulitplicity on (Barcode,  Patient):Scan Blood Product->Verify Blood Product[0,1]
all n:(NScanBloodProduct&trans.source.nodes)| lone e:(ABarcodePatient&trans.source.arrows)|e.src=n
//mulitplicity on The blood Product is not for the patient:Verify Blood Product->Stop Transfusion, Contact AIT[0,1]
all n:(NVerifyBloodProduct&trans.source.nodes)| lone e:(AThebloodProductisnotforthepatient&trans.source.arrows)|e.src=n
//mulitplicity on The blood is for the patient:Verify Blood Product->perform transfusion[0,1]
all n:(NVerifyBloodProduct&trans.source.nodes)| lone e:(AThebloodisforthepatient&trans.source.arrows)|e.src=n
//mulitplicity on (Patient{temp, pressure_high, pressure_low, pulse}):Measure temperature, blood pressure and pulse->Store Patient Condition[0,1]
all n:(NMeasuretemperaturebloodpressureandpulse&trans.source.nodes)| lone e:(APatienttemppressure_highpressure_lowpulse&trans.source.arrows)|e.src=n
//mulitplicity on More blood:perform transfusion->Scan Blood Product[0,1]
all n:(Nperformtransfusion&trans.source.nodes)| lone e:(AMoreblood&trans.source.arrows)|e.src=n
//mulitplicity on (Barcode):Scan Nurse Card->Get Nurse Info[0,1]
all n:(NScanNurseCard&trans.source.nodes)| lone e:(ABarcode5&trans.source.arrows)|e.src=n
//mulitplicity on :Show Patient Info->Order Blood[0,1]
all n:(NShowPatientInfo&trans.source.nodes)| lone e:(ANShowPatientInfoNOrderBlood&trans.source.arrows)|e.src=n
//mulitplicity on (Reaction{type}):perform transfusion->Register Reaction[0,1]
all n:(Nperformtransfusion&trans.source.nodes)| lone e:(AReactiontype&trans.source.arrows)|e.src=n
//mulitplicity on (Transfusion, Nurse):Identify nurse, log transfusion->Store Transfusion[0,1]
all n:(NIdentifynurselogtransfusion&trans.source.nodes)| lone e:(ATransfusionNurse&trans.source.arrows)|e.src=n
//mulitplicity on out time less then 0.5h:Collect Blood->Put Blood Into refrigertor[0,1]
all n:(NCollectBlood&trans.source.nodes)| lone e:(Aouttimelessthen05h&trans.source.arrows)|e.src=n
//mulitplicity on out time less than 4h:Put Blood Into refrigertor->Scan Blood Product[0,1]
all n:(NPutBloodIntorefrigertor&trans.source.nodes)| lone e:(Aouttimelessthan4h6&trans.source.arrows)|e.src=n
//mulitplicity on (BloodOrder{quantity, expectTime}):Send Blood Order->Order Blood Product[0,1]
all n:(NSendBloodOrder&trans.source.nodes)| lone e:(ABloodOrderquantityexpectTime&trans.source.arrows)|e.src=n
//mulitplicity on (Blood*):Order Blood Product->Collect Blood[0,1]
all n:(NOrderBloodProduct&trans.source.nodes)| lone e:(ABlood&trans.source.arrows)|e.src=n
//mulitplicity on :Send Sample->Collect Blood[0,1]
all n:(NSendSample&trans.source.nodes)| lone e:(ANSendSampleNCollectBlood&trans.source.arrows)|e.src=n
//mulitplicity on bloodtype is unknown or screening is not done or invalid(screen is valid within 4 days):Show Patient Info->Order Sample[0,1]
all n:(NShowPatientInfo&trans.source.nodes)| lone e:(Abloodtypeisunknownorscreeningisnotdoneorinvalidscreenisvalidwithin4days&trans.source.arrows)|e.src=n
//mulitplicity on Samples have not been ordered:Send Blood Order->Order Sample[0,1]
all n:(NSendBloodOrder&trans.source.nodes)| lone e:(ASampleshavenotbeenordered&trans.source.arrows)|e.src=n
//mulitplicity on :perform transfusion->Measure temperature, blood pressure and pulse[0,1]
all n:(Nperformtransfusion&trans.source.nodes)| lone e:(ANperformtransfusionNMeasuretemperaturebloodpressureandpulse&trans.source.arrows)|e.src=n
//mulitplicity on :Measure temperature, blood pressure and pulse->perform transfusion[0,1]
all n:(NMeasuretemperaturebloodpressureandpulse&trans.source.nodes)| lone e:(ANMeasuretemperaturebloodpressureandpulseNperformtransfusion&trans.source.arrows)|e.src=n
//mulitplicity on (Sample Label File*):Send Sample Order->Print Sample Label[0,1]
all n:(NSendSampleOrder&trans.source.nodes)| lone e:(ASampleLabelFile&trans.source.arrows)|e.src=n
//mulitplicity on (Label*):Print Sample Label->Collect Sample[0,1]
all n:(NPrintSampleLabel&trans.source.nodes)| lone e:(ALabel&trans.source.arrows)|e.src=n
//mulitplicity on :Init->Scan Nurse Card[0,1]
all n:(NInit&trans.source.nodes)| lone e:(ANInitNScanNurseCard&trans.source.arrows)|e.src=n
//surjective on :Select Book pre-examination->Send Sample Order
all n:(NSendSampleOrder&trans.source.nodes)| some e:(ANSelectBookpreexaminationNSendSampleOrder&trans.source.arrows)| e.trg = n
//surjective on :perform transfusion->Identify nurse, log transfusion
all n:(NIdentifynurselogtransfusion&trans.source.nodes)| some e:(ANperformtransfusionNIdentifynurselogtransfusion&trans.source.arrows)| e.trg = n
//surjective on :Order Sample->Select Book pre-examination
all n:(NSelectBookpreexamination&trans.source.nodes)| some e:(ANOrderSampleNSelectBookpreexamination&trans.source.arrows)| e.trg = n
//surjective on Patient has not been bloodtyped:Order Sample->Select Blod Typeing
all n:(NSelectBlodTypeing&trans.source.nodes)| some e:(APatienthasnotbeenbloodtyped&trans.source.arrows)| e.trg = n
//XOR constraint between (Patient):Get Patient Info->Send Sample and Sample is not for the patient:Get Patient Info->Scan Sample
all n:(NGetPatientInfo0&trans.source.nodes) | let e1 = (some e : APatient&trans.source.arrows | e.src = n), e2=(some e : ASampleisnotforthepatient&trans.source.arrows | e.src = n)|not(e1 and e2)
//XOR constraint between Nurse is not found:Get Nurse Info->Scan Nurse Card and (Nurse{name}):Get Nurse Info->Show Nurse Info
all n:(NGetNurseInfo&trans.source.nodes) | let e1 = (some e : ANurseisnotfound&trans.source.arrows | e.src = n), e2=(some e : ANursename&trans.source.arrows | e.src = n)|not(e1 and e2)
//XOR constraint between Patient is not found:Get Patient Info->Scan Patient Wristband and (Patient{name, ID, gender, blodtype, screening}):Get Patient Info->Show Patient Info
all n:(NGetPatientInfo&trans.source.nodes) | let e1 = (some e : APatientisnotfound&trans.source.arrows | e.src = n), e2=(some e : APatientnameIDgenderblodtypescreening&trans.source.arrows | e.src = n)|not(e1 and e2)
//XOR constraint between The blood Product is not for the patient:Verify Blood Product->Stop Transfusion, Contact AIT and The blood is for the patient:Verify Blood Product->perform transfusion
all n:(NVerifyBloodProduct&trans.source.nodes) | let e1 = (some e : AThebloodProductisnotforthepatient&trans.source.arrows | e.src = n), e2=(some e : AThebloodisforthepatient&trans.source.arrows | e.src = n)|not(e1 and e2)
//surjective on (Patient):Get Patient Info->Send Sample
all n:(NSendSample&trans.source.nodes)| some e:(APatient&trans.source.arrows)| e.trg = n
//surjective on (Barcode):Scann Patient Wristband->Get Patient Info
all n:(NGetPatientInfo0&trans.source.nodes)| some e:(ABarcode2&trans.source.arrows)| e.trg = n
//surjective on (Sample):Get Sample Info->Scann Patient Wristband
all n:(NScannPatientWristband&trans.source.nodes)| some e:(ASample&trans.source.arrows)| e.trg = n
//surjective on (Barcode):Scan Sample->Get Sample Info
all n:(NGetSampleInfo&trans.source.nodes)| some e:(ABarcode1&trans.source.arrows)| e.trg = n
//surjective on (Barcode):Scan Patient Wristband->Get Patient Info
all n:(NGetPatientInfo&trans.source.nodes)| some e:(ABarcode&trans.source.arrows)| e.trg = n
//xorsurj Patient is not found 
all z:NScanPatientWristband&trans.source.nodes | let e1 = (some e : ANShowNurseInfoNScanPatientWristband&trans.source.arrows | e.trg = z), 
e2 = (some e : APatientisnotfound&trans.source.arrows | e.trg = z)|
(e1 or e2) and not (e1 and e2)
//surjective on (Department):Select Department->Send Blood Order
all n:(NSendBloodOrder&trans.source.nodes)| some e:(ADepartment&trans.source.arrows)| e.trg = n
//surjective on (Doctor):Get Doctor Info->Select Department
all n:(NSelectDepartment&trans.source.nodes)| some e:(ADoctor&trans.source.arrows)| e.trg = n
//surjective on (Barcode):Select Blood Product->Get Doctor Info
all n:(NGetDoctorInfo&trans.source.nodes)| some e:(ABarcode3&trans.source.arrows)| e.trg = n
//xor3surj Blood have not been ordered Blood have not been ordered 
all x:NOrderBlood&trans.source.nodes | let e1 = (some e : ANShowPatientInfoNOrderBlood&trans.source.arrows | e.trg = x), 
e2 = (some e : ABloodhavenotbeenordered4&trans.source.arrows | e.trg = x), 
e3 = (some e : ABloodhavenotbeenordered&trans.source.arrows | e.trg = x)|
not (e1 and e2) and not (e1 and e3) and not (e2 and e3) and (e1 or e2 or e3)
//xorsurj Sample is not for the patient 
all z:NScanSample&trans.source.nodes | let e1 = (some e : ANCollectSampleNScanSample&trans.source.arrows | e.trg = z), 
e2 = (some e : ASampleisnotforthepatient&trans.source.arrows | e.trg = z)|
(e1 or e2) and not (e1 and e2)
//imply Samples have not been sent 
all x:NScanSample&trans.source.nodes | let e1 = (some e : ASampleshavenotbeensent&trans.source.arrows | e.trg = x), 
e2 = (some e : ANCollectSampleNScanSample&trans.source.arrows | e.trg = x)| not e1 or e2
//surjective on (Reaction{type}):perform transfusion->Register Reaction
all n:(NRegisterReaction&trans.source.nodes)| some e:(AReactiontype&trans.source.arrows)| e.trg = n
//surjective on (Barcode):Scan Nurse Card->Get Nurse Info
all n:(NGetNurseInfo&trans.source.nodes)| some e:(ABarcode5&trans.source.arrows)| e.trg = n
//surjective on (Nurse{name}):Get Nurse Info->Show Nurse Info
all n:(NShowNurseInfo&trans.source.nodes)| some e:(ANursename&trans.source.arrows)| e.trg = n
//surjective on (Patient{name, ID, gender, blodtype, screening}):Get Patient Info->Show Patient Info
all n:(NShowPatientInfo&trans.source.nodes)| some e:(APatientnameIDgenderblodtypescreening&trans.source.arrows)| e.trg = n
//surjective on (Patient{temp, pressure_high, pressure_low, pulse}):Measure temperature, blood pressure and pulse->Store Patient Condition
all n:(NStorePatientCondition&trans.source.nodes)| some e:(APatienttemppressure_highpressure_lowpulse&trans.source.arrows)| e.trg = n
//surjective on (Transfusion, Nurse):Identify nurse, log transfusion->Store Transfusion
all n:(NStoreTransfusion&trans.source.nodes)| some e:(ATransfusionNurse&trans.source.arrows)| e.trg = n
//surjective on The blood Product is not for the patient:Verify Blood Product->Stop Transfusion, Contact AIT
all n:(NStopTransfusionContactAIT&trans.source.nodes)| some e:(AThebloodProductisnotforthepatient&trans.source.arrows)| e.trg = n
//surjective on (Barcode,  Patient):Scan Blood Product->Verify Blood Product
all n:(NVerifyBloodProduct&trans.source.nodes)| some e:(ABarcodePatient&trans.source.arrows)| e.trg = n
//xor3surj More blood out time less than 4h out time less than 4h
all x:NScanBloodProduct&trans.source.nodes | let e1 = (some e : Aouttimelessthan4h6&trans.source.arrows | e.trg = x), 
e2 = (some e : AMoreblood&trans.source.arrows | e.trg = x), 
e3 = (some e : Aouttimelessthan4h&trans.source.arrows | e.trg = x)|
not (e1 and e2) and not (e1 and e3) and not (e2 and e3) and (e1 or e2 or e3)
//NAND constraint between Sample is not for the patient:Get Patient Info->Scan Sample and Samples have not been sent:Send Blood Order->Scan Sample
all n:(NScanSample&trans.source.nodes) | let e1 = (some e : ASampleisnotforthepatient&trans.source.arrows | e.trg = n), e2=(some e : ASampleshavenotbeensent&trans.source.arrows | e.trg = n)|not(e1 and e2)
//surjective on (BloodOrder{quantity, expectTime}):Send Blood Order->Order Blood Product
all n:(NOrderBloodProduct&trans.source.nodes)| some e:(ABloodOrderquantityexpectTime&trans.source.arrows)| e.trg = n
//surjective on out time less then 0.5h:Collect Blood->Put Blood Into refrigertor
all n:(NPutBloodIntorefrigertor&trans.source.nodes)| some e:(Aouttimelessthen05h&trans.source.arrows)| e.trg = n
//mulitplicity on ScanNurseCard min:0;max:2
let count = #NScanNurseCard&trans.source.nodes | count>=0 and count <=2
//XOR constraint between out time less then 0.5h:Collect Blood->Put Blood Into refrigertor and out time less than 4h:Collect Blood->Scan Blood Product
all n:(NCollectBlood&trans.source.nodes) | let e1 = (some e : Aouttimelessthen05h&trans.source.arrows | e.src = n), e2=(some e : Aouttimelessthan4h&trans.source.arrows | e.src = n)|not(e1 and e2)
//special out time less than 4h out time less than 4h
some NScanBloodProduct&trans.source.nodes implies ((some z:NScanBloodProduct&trans.source.nodes|some xz:Aouttimelessthan4h&trans.source.arrows|xz.trg=z) or (some z:NScanBloodProduct&trans.source.nodes|some yz:Aouttimelessthan4h6&trans.source.arrows|yz.trg=z))
//XOR constraint between bloodtype is unknown or screening is not done or invalid(screen is valid within 4 days):Show Patient Info->Order Sample and :Show Patient Info->Order Blood
all n:(NShowPatientInfo&trans.source.nodes) | let e1 = (some e : Abloodtypeisunknownorscreeningisnotdoneorinvalidscreenisvalidwithin4days&trans.source.arrows | e.src = n), e2=(some e : ANShowPatientInfoNOrderBlood&trans.source.arrows | e.src = n)|not(e1 and e2)
//imply2 Blood have not been ordered bloodtype is unknown or screening is not done or invalid(screen is valid within 4 days)
all y1:NOrderBlood&trans.source.nodes, y2:NOrderSample&trans.source.nodes | let e1 = (some e : ABloodhavenotbeenordered&trans.source.arrows | e.trg = y1), 
e2 = (some e : Abloodtypeisunknownorscreeningisnotdoneorinvalidscreenisvalidwithin4days&trans.source.arrows | e.trg = y2)|
 e1 implies e2
//imply2 Blood have not been ordered bloodtype is unknown or screening is not done or invalid(screen is valid within 4 days)
all y1:NOrderBlood&trans.source.nodes, y2:NOrderSample&trans.source.nodes | let e1 = (some e : ABloodhavenotbeenordered4&trans.source.arrows | e.trg = y1), 
e2 = (some e : Abloodtypeisunknownorscreeningisnotdoneorinvalidscreenisvalidwithin4days&trans.source.arrows | e.trg = y2)|
 e1 implies e2
//surjective on (Blood*):Order Blood Product->Collect Blood
all n:(NCollectBlood&trans.source.nodes)| some e:(ABlood&trans.source.arrows)| e.trg = n
//XOR constraint between :Send Sample->Collect Blood and Blood have not been ordered:Send Sample->Order Blood
all n:(NSendSample&trans.source.nodes) | let e1 = (some e : ANSendSampleNCollectBlood&trans.source.arrows | e.src = n), e2=(some e : ABloodhavenotbeenordered4&trans.source.arrows | e.src = n)|not(e1 and e2)
//surjective on :Order Blood->Select Blood Product
all n:(NSelectBloodProduct&trans.source.nodes)| some e:(ANOrderBloodNSelectBloodProduct&trans.source.arrows)| e.trg = n
//xorsurj bloodtype is unknown or screening is not done or invalid(screen is valid within 4 days) Samples have not been ordered
all z:NOrderSample&trans.source.nodes | let e1 = (some e : ASampleshavenotbeenordered&trans.source.arrows | e.trg = z), 
e2 = (some e : Abloodtypeisunknownorscreeningisnotdoneorinvalidscreenisvalidwithin4days&trans.source.arrows | e.trg = z)|
(e1 or e2) and not (e1 and e2)
//xor3 Samples have not been sent Samples have not been ordered (BloodOrder{quantity, expectTime})
all x:NSendBloodOrder&trans.source.nodes | let e1 = (some e : ASampleshavenotbeensent&trans.source.arrows | e.src = x), 
e2 = (some e : ABloodOrderquantityexpectTime&trans.source.arrows | e.src = x), 
e3 = (some e : ASampleshavenotbeenordered&trans.source.arrows | e.src = x)|
not (e1 and e2) and not (e1 and e3) and not (e2 and e3)
//xorsurj  The blood is for the patient
all z:Nperformtransfusion&trans.source.nodes | let e1 = (some e : AThebloodisforthepatient&trans.source.arrows | e.trg = z), 
e2 = (some e : ANMeasuretemperaturebloodpressureandpulseNperformtransfusion&trans.source.arrows | e.trg = z)|
(e1 or e2) and not (e1 and e2)
//imply2  Patient has not been bloodtyped
all y1:NSendSampleOrder&trans.source.nodes, y2:NSelectBlodTypeing&trans.source.nodes | let e1 = (some e : ANSelectBlodTypeingNSendSampleOrder&trans.source.arrows | e.trg = y1), 
e2 = (some e : APatienthasnotbeenbloodtyped&trans.source.arrows | e.trg = y2)|
 e1 implies e2
//imply2 out time less then 0.5h out time less than 4h
all y1:NScanBloodProduct&trans.source.nodes, y2:NPutBloodIntorefrigertor&trans.source.nodes | let e1 = (some e : Aouttimelessthan4h6&trans.source.arrows | e.trg = y1), 
e2 = (some e : Aouttimelessthen05h&trans.source.arrows | e.trg = y2)|
 e1 implies e2
//xorsurj  Nurse is not found
all z:NScanNurseCard&trans.source.nodes | let e1 = (some e : ANurseisnotfound&trans.source.arrows | e.trg = z), 
e2 = (some e : ANInitNScanNurseCard&trans.source.arrows | e.trg = z)|
(e1 or e2) and not (e1 and e2)
//mulitplicity on Init min:1;max:1
let count = #NInit&trans.source.nodes | count>=1 and count <=1
//mulitplicity on ScanPatientWristband min:0;max:2
let count = #NScanPatientWristband&trans.source.nodes | count>=0 and count <=2
//surjective on (Sample Label File*):Send Sample Order->Print Sample Label
all n:(NPrintSampleLabel&trans.source.nodes)| some e:(ASampleLabelFile&trans.source.arrows)| e.trg = n
//surjective on (Label*):Print Sample Label->Collect Sample
all n:(NCollectSample&trans.source.nodes)| some e:(ALabel&trans.source.arrows)| e.trg = n
//mulitplicity on ScanSample min:0;max:1
let count = #NScanSample&trans.source.nodes | count>=0 and count <=1
//XOR constraint between (Patient{temp, pressure_high, pressure_low, pulse}):Measure temperature, blood pressure and pulse->Store Patient Condition and :Measure temperature, blood pressure and pulse->perform transfusion
all n:(NMeasuretemperaturebloodpressureandpulse&trans.source.nodes) | let e1 = (some e : APatienttemppressure_highpressure_lowpulse&trans.source.arrows | e.src = n), e2=(some e : ANMeasuretemperaturebloodpressureandpulseNperformtransfusion&trans.source.arrows | e.src = n)|not(e1 and e2)
//mulitplicity on ScanBloodProduct min:0;max:2
let count = #NScanBloodProduct&trans.source.nodes | count>=0 and count <=2
//xor4  (Reaction{type})  More blood
all x:Nperformtransfusion&trans.source.nodes | let e1 = (some e : ANperformtransfusionNIdentifynurselogtransfusion&trans.source.arrows | e.src = x), 
e2 = (some e : AReactiontype&trans.source.arrows | e.src = x), 
e3 = (some e : ANperformtransfusionNMeasuretemperaturebloodpressureandpulse&trans.source.arrows | e.src = x),
e4 = (some e : AMoreblood&trans.source.arrows | e.src = x)|
not (e1 and e2) and not (e1 and e3) and not (e2 and e3) and not (e1 and e4)   and not (e2 and e4) and not (e3 and e4)
//surjective on :perform transfusion->Measure temperature, blood pressure and pulse
all n:(NMeasuretemperaturebloodpressureandpulse&trans.source.nodes)| some e:(ANperformtransfusionNMeasuretemperaturebloodpressureandpulse&trans.source.arrows)| e.trg = n
}
fact{ all trans: Trans|//mulitplicity on :Order Sample->Select Book pre-examination[0,1]
all n:(NOrderSample&trans.target.nodes)| lone e:(ANOrderSampleNSelectBookpreexamination&trans.target.arrows)|e.src=n
}
fact{ all trans: Trans|//mulitplicity on :Select Book pre-examination->Send Sample Order[0,1]
all n:(NSelectBookpreexamination&trans.target.nodes)| lone e:(ANSelectBookpreexaminationNSendSampleOrder&trans.target.arrows)|e.src=n
}
fact{ all trans: Trans|//mulitplicity on :perform transfusion->Identify nurse, log transfusion[0,1]
all n:(Nperformtransfusion&trans.target.nodes)| lone e:(ANperformtransfusionNIdentifynurselogtransfusion&trans.target.arrows)|e.src=n
}
fact{ all trans: Trans|//mulitplicity on out time less than 4h:Collect Blood->Scan Blood Product[0,1]
all n:(NCollectBlood&trans.target.nodes)| lone e:(Aouttimelessthan4h&trans.target.arrows)|e.src=n
}
fact{ all trans: Trans|//mulitplicity on :Show Nurse Info->Scan Patient Wristband[0,1]
all n:(NShowNurseInfo&trans.target.nodes)| lone e:(ANShowNurseInfoNScanPatientWristband&trans.target.arrows)|e.src=n
}
fact{ all trans: Trans|//mulitplicity on Patient has not been bloodtyped:Order Sample->Select Blod Typeing[0,1]
all n:(NOrderSample&trans.target.nodes)| lone e:(APatienthasnotbeenbloodtyped&trans.target.arrows)|e.src=n
}
fact{ all trans: Trans|//mulitplicity on :Select Blod Typeing->Send Sample Order[0,1]
all n:(NSelectBlodTypeing&trans.target.nodes)| lone e:(ANSelectBlodTypeingNSendSampleOrder&trans.target.arrows)|e.src=n
}
fact{ all trans: Trans|//mulitplicity on (Nurse{name}):Get Nurse Info->Show Nurse Info[0,1]
all n:(NGetNurseInfo&trans.target.nodes)| lone e:(ANursename&trans.target.arrows)|e.src=n
}
fact{ all trans: Trans|//mulitplicity on Nurse is not found:Get Nurse Info->Scan Nurse Card[0,1]
all n:(NGetNurseInfo&trans.target.nodes)| lone e:(ANurseisnotfound&trans.target.arrows)|e.src=n
}
fact{ all trans: Trans|//mulitplicity on (Barcode):Scan Patient Wristband->Get Patient Info[0,1]
all n:(NScanPatientWristband&trans.target.nodes)| lone e:(ABarcode&trans.target.arrows)|e.src=n
}
fact{ all trans: Trans|//mulitplicity on (Patient{name, ID, gender, blodtype, screening}):Get Patient Info->Show Patient Info[0,1]
all n:(NGetPatientInfo&trans.target.nodes)| lone e:(APatientnameIDgenderblodtypescreening&trans.target.arrows)|e.src=n
}
fact{ all trans: Trans|//mulitplicity on Patient is not found:Get Patient Info->Scan Patient Wristband[0,1]
all n:(NGetPatientInfo&trans.target.nodes)| lone e:(APatientisnotfound&trans.target.arrows)|e.src=n
}
fact{ all trans: Trans|//mulitplicity on (Sample):Get Sample Info->Scann Patient Wristband[0,1]
all n:(NGetSampleInfo&trans.target.nodes)| lone e:(ASample&trans.target.arrows)|e.src=n
}
fact{ all trans: Trans|//mulitplicity on (Barcode):Scan Sample->Get Sample Info[0,1]
all n:(NScanSample&trans.target.nodes)| lone e:(ABarcode1&trans.target.arrows)|e.src=n
}
fact{ all trans: Trans|//mulitplicity on (Barcode):Scann Patient Wristband->Get Patient Info[0,1]
all n:(NScannPatientWristband&trans.target.nodes)| lone e:(ABarcode2&trans.target.arrows)|e.src=n
}
fact{ all trans: Trans|//mulitplicity on (Patient):Get Patient Info->Send Sample[0,1]
all n:(NGetPatientInfo0&trans.target.nodes)| lone e:(APatient&trans.target.arrows)|e.src=n
}
fact{ all trans: Trans|//mulitplicity on Blood have not been ordered:Send Sample Order->Order Blood[0,1]
all n:(NSendSampleOrder&trans.target.nodes)| lone e:(ABloodhavenotbeenordered&trans.target.arrows)|e.src=n
}
fact{ all trans: Trans|//mulitplicity on :Collect Sample->Scan Sample[0,1]
all n:(NCollectSample&trans.target.nodes)| lone e:(ANCollectSampleNScanSample&trans.target.arrows)|e.src=n
}
fact{ all trans: Trans|//mulitplicity on :Order Blood->Select Blood Product[0,1]
all n:(NOrderBlood&trans.target.nodes)| lone e:(ANOrderBloodNSelectBloodProduct&trans.target.arrows)|e.src=n
}
fact{ all trans: Trans|//mulitplicity on (Barcode):Select Blood Product->Get Doctor Info[0,1]
all n:(NSelectBloodProduct&trans.target.nodes)| lone e:(ABarcode3&trans.target.arrows)|e.src=n
}
fact{ all trans: Trans|//mulitplicity on (Doctor):Get Doctor Info->Select Department[0,1]
all n:(NGetDoctorInfo&trans.target.nodes)| lone e:(ADoctor&trans.target.arrows)|e.src=n
}
fact{ all trans: Trans|//mulitplicity on (Department):Select Department->Send Blood Order[0,1]
all n:(NSelectDepartment&trans.target.nodes)| lone e:(ADepartment&trans.target.arrows)|e.src=n
}
fact{ all trans: Trans|//mulitplicity on Samples have not been sent:Send Blood Order->Scan Sample[0,1]
all n:(NSendBloodOrder&trans.target.nodes)| lone e:(ASampleshavenotbeensent&trans.target.arrows)|e.src=n
}
fact{ all trans: Trans|//mulitplicity on Sample is not for the patient:Get Patient Info->Scan Sample[0,1]
all n:(NGetPatientInfo0&trans.target.nodes)| lone e:(ASampleisnotforthepatient&trans.target.arrows)|e.src=n
}
fact{ all trans: Trans|//mulitplicity on Blood have not been ordered:Send Sample->Order Blood[0,1]
all n:(NSendSample&trans.target.nodes)| lone e:(ABloodhavenotbeenordered4&trans.target.arrows)|e.src=n
}
fact{ all trans: Trans|//mulitplicity on (Barcode,  Patient):Scan Blood Product->Verify Blood Product[0,1]
all n:(NScanBloodProduct&trans.target.nodes)| lone e:(ABarcodePatient&trans.target.arrows)|e.src=n
}
fact{ all trans: Trans|//mulitplicity on The blood Product is not for the patient:Verify Blood Product->Stop Transfusion, Contact AIT[0,1]
all n:(NVerifyBloodProduct&trans.target.nodes)| lone e:(AThebloodProductisnotforthepatient&trans.target.arrows)|e.src=n
}
fact{ all trans: Trans|//mulitplicity on The blood is for the patient:Verify Blood Product->perform transfusion[0,1]
all n:(NVerifyBloodProduct&trans.target.nodes)| lone e:(AThebloodisforthepatient&trans.target.arrows)|e.src=n
}
fact{ all trans: Trans|//mulitplicity on (Patient{temp, pressure_high, pressure_low, pulse}):Measure temperature, blood pressure and pulse->Store Patient Condition[0,1]
all n:(NMeasuretemperaturebloodpressureandpulse&trans.target.nodes)| lone e:(APatienttemppressure_highpressure_lowpulse&trans.target.arrows)|e.src=n
}
fact{ all trans: Trans|//mulitplicity on More blood:perform transfusion->Scan Blood Product[0,1]
all n:(Nperformtransfusion&trans.target.nodes)| lone e:(AMoreblood&trans.target.arrows)|e.src=n
}
fact{ all trans: Trans|//mulitplicity on (Barcode):Scan Nurse Card->Get Nurse Info[0,1]
all n:(NScanNurseCard&trans.target.nodes)| lone e:(ABarcode5&trans.target.arrows)|e.src=n
}
fact{ all trans: Trans|//mulitplicity on :Show Patient Info->Order Blood[0,1]
all n:(NShowPatientInfo&trans.target.nodes)| lone e:(ANShowPatientInfoNOrderBlood&trans.target.arrows)|e.src=n
}
fact{ all trans: Trans|//mulitplicity on (Reaction{type}):perform transfusion->Register Reaction[0,1]
all n:(Nperformtransfusion&trans.target.nodes)| lone e:(AReactiontype&trans.target.arrows)|e.src=n
}
fact{ all trans: Trans|//mulitplicity on (Transfusion, Nurse):Identify nurse, log transfusion->Store Transfusion[0,1]
all n:(NIdentifynurselogtransfusion&trans.target.nodes)| lone e:(ATransfusionNurse&trans.target.arrows)|e.src=n
}
fact{ all trans: Trans|//mulitplicity on out time less then 0.5h:Collect Blood->Put Blood Into refrigertor[0,1]
all n:(NCollectBlood&trans.target.nodes)| lone e:(Aouttimelessthen05h&trans.target.arrows)|e.src=n
}
fact{ all trans: Trans|//mulitplicity on out time less than 4h:Put Blood Into refrigertor->Scan Blood Product[0,1]
all n:(NPutBloodIntorefrigertor&trans.target.nodes)| lone e:(Aouttimelessthan4h6&trans.target.arrows)|e.src=n
}
fact{ all trans: Trans|//mulitplicity on (BloodOrder{quantity, expectTime}):Send Blood Order->Order Blood Product[0,1]
all n:(NSendBloodOrder&trans.target.nodes)| lone e:(ABloodOrderquantityexpectTime&trans.target.arrows)|e.src=n
}
fact{ all trans: Trans|//mulitplicity on (Blood*):Order Blood Product->Collect Blood[0,1]
all n:(NOrderBloodProduct&trans.target.nodes)| lone e:(ABlood&trans.target.arrows)|e.src=n
}
fact{ all trans: Trans|//mulitplicity on :Send Sample->Collect Blood[0,1]
all n:(NSendSample&trans.target.nodes)| lone e:(ANSendSampleNCollectBlood&trans.target.arrows)|e.src=n
}
fact{ all trans: Trans|//mulitplicity on bloodtype is unknown or screening is not done or invalid(screen is valid within 4 days):Show Patient Info->Order Sample[0,1]
all n:(NShowPatientInfo&trans.target.nodes)| lone e:(Abloodtypeisunknownorscreeningisnotdoneorinvalidscreenisvalidwithin4days&trans.target.arrows)|e.src=n
}
fact{ all trans: Trans|//mulitplicity on Samples have not been ordered:Send Blood Order->Order Sample[0,1]
all n:(NSendBloodOrder&trans.target.nodes)| lone e:(ASampleshavenotbeenordered&trans.target.arrows)|e.src=n
}
fact{ all trans: Trans|//mulitplicity on :perform transfusion->Measure temperature, blood pressure and pulse[0,1]
all n:(Nperformtransfusion&trans.target.nodes)| lone e:(ANperformtransfusionNMeasuretemperaturebloodpressureandpulse&trans.target.arrows)|e.src=n
}
fact{ all trans: Trans|//mulitplicity on :Measure temperature, blood pressure and pulse->perform transfusion[0,1]
all n:(NMeasuretemperaturebloodpressureandpulse&trans.target.nodes)| lone e:(ANMeasuretemperaturebloodpressureandpulseNperformtransfusion&trans.target.arrows)|e.src=n
}
fact{ all trans: Trans|//mulitplicity on (Sample Label File*):Send Sample Order->Print Sample Label[0,1]
all n:(NSendSampleOrder&trans.target.nodes)| lone e:(ASampleLabelFile&trans.target.arrows)|e.src=n
}
fact{ all trans: Trans|//mulitplicity on (Label*):Print Sample Label->Collect Sample[0,1]
all n:(NPrintSampleLabel&trans.target.nodes)| lone e:(ALabel&trans.target.arrows)|e.src=n
}
fact{ all trans: Trans|//mulitplicity on :Init->Scan Nurse Card[0,1]
all n:(NInit&trans.target.nodes)| lone e:(ANInitNScanNurseCard&trans.target.arrows)|e.src=n
}
fact{ all trans: Trans|//surjective on :Select Book pre-examination->Send Sample Order
all n:(NSendSampleOrder&trans.target.nodes)| some e:(ANSelectBookpreexaminationNSendSampleOrder&trans.target.arrows)| e.trg = n
}
fact{ all trans: Trans|//surjective on :perform transfusion->Identify nurse, log transfusion
all n:(NIdentifynurselogtransfusion&trans.target.nodes)| some e:(ANperformtransfusionNIdentifynurselogtransfusion&trans.target.arrows)| e.trg = n
}
fact{ all trans: Trans|//surjective on :Order Sample->Select Book pre-examination
all n:(NSelectBookpreexamination&trans.target.nodes)| some e:(ANOrderSampleNSelectBookpreexamination&trans.target.arrows)| e.trg = n
}
fact{ all trans: Trans|//surjective on Patient has not been bloodtyped:Order Sample->Select Blod Typeing
all n:(NSelectBlodTypeing&trans.target.nodes)| some e:(APatienthasnotbeenbloodtyped&trans.target.arrows)| e.trg = n
}
fact{ all trans: Trans|//XOR constraint between (Patient):Get Patient Info->Send Sample and Sample is not for the patient:Get Patient Info->Scan Sample
all n:(NGetPatientInfo0&trans.target.nodes) | let e1 = (some e : APatient&trans.target.arrows | e.src = n), e2=(some e : ASampleisnotforthepatient&trans.target.arrows | e.src = n)|not(e1 and e2)
}
fact{ all trans: Trans|//XOR constraint between Nurse is not found:Get Nurse Info->Scan Nurse Card and (Nurse{name}):Get Nurse Info->Show Nurse Info
all n:(NGetNurseInfo&trans.target.nodes) | let e1 = (some e : ANurseisnotfound&trans.target.arrows | e.src = n), e2=(some e : ANursename&trans.target.arrows | e.src = n)|not(e1 and e2)
}
fact{ all trans: Trans|//XOR constraint between Patient is not found:Get Patient Info->Scan Patient Wristband and (Patient{name, ID, gender, blodtype, screening}):Get Patient Info->Show Patient Info
all n:(NGetPatientInfo&trans.target.nodes) | let e1 = (some e : APatientisnotfound&trans.target.arrows | e.src = n), e2=(some e : APatientnameIDgenderblodtypescreening&trans.target.arrows | e.src = n)|not(e1 and e2)
}
fact{ all trans: Trans|//XOR constraint between The blood Product is not for the patient:Verify Blood Product->Stop Transfusion, Contact AIT and The blood is for the patient:Verify Blood Product->perform transfusion
all n:(NVerifyBloodProduct&trans.target.nodes) | let e1 = (some e : AThebloodProductisnotforthepatient&trans.target.arrows | e.src = n), e2=(some e : AThebloodisforthepatient&trans.target.arrows | e.src = n)|not(e1 and e2)
}
fact{ all trans: Trans|//surjective on (Patient):Get Patient Info->Send Sample
all n:(NSendSample&trans.target.nodes)| some e:(APatient&trans.target.arrows)| e.trg = n
}
fact{ all trans: Trans|//surjective on (Barcode):Scann Patient Wristband->Get Patient Info
all n:(NGetPatientInfo0&trans.target.nodes)| some e:(ABarcode2&trans.target.arrows)| e.trg = n
}
fact{ all trans: Trans|//surjective on (Sample):Get Sample Info->Scann Patient Wristband
all n:(NScannPatientWristband&trans.target.nodes)| some e:(ASample&trans.target.arrows)| e.trg = n
}
fact{ all trans: Trans|//surjective on (Barcode):Scan Sample->Get Sample Info
all n:(NGetSampleInfo&trans.target.nodes)| some e:(ABarcode1&trans.target.arrows)| e.trg = n
}
fact{ all trans: Trans|//surjective on (Barcode):Scan Patient Wristband->Get Patient Info
all n:(NGetPatientInfo&trans.target.nodes)| some e:(ABarcode&trans.target.arrows)| e.trg = n
}
fact{ all trans: Trans|//xorsurj Patient is not found 
all z:NScanPatientWristband&trans.target.nodes | let e1 = (some e : ANShowNurseInfoNScanPatientWristband&trans.target.arrows | e.trg = z), 
e2 = (some e : APatientisnotfound&trans.target.arrows | e.trg = z)|
(e1 or e2) and not (e1 and e2)
}
fact{ all trans: Trans|//surjective on (Department):Select Department->Send Blood Order
all n:(NSendBloodOrder&trans.target.nodes)| some e:(ADepartment&trans.target.arrows)| e.trg = n
}
fact{ all trans: Trans|//surjective on (Doctor):Get Doctor Info->Select Department
all n:(NSelectDepartment&trans.target.nodes)| some e:(ADoctor&trans.target.arrows)| e.trg = n
}
fact{ all trans: Trans|//surjective on (Barcode):Select Blood Product->Get Doctor Info
all n:(NGetDoctorInfo&trans.target.nodes)| some e:(ABarcode3&trans.target.arrows)| e.trg = n
}
fact{ all trans: Trans|//xor3surj Blood have not been ordered Blood have not been ordered 
all x:NOrderBlood&trans.target.nodes | let e1 = (some e : ANShowPatientInfoNOrderBlood&trans.target.arrows | e.trg = x), 
e2 = (some e : ABloodhavenotbeenordered4&trans.target.arrows | e.trg = x), 
e3 = (some e : ABloodhavenotbeenordered&trans.target.arrows | e.trg = x)|
not (e1 and e2) and not (e1 and e3) and not (e2 and e3) and (e1 or e2 or e3)
}
fact{ all trans: Trans|//xorsurj Sample is not for the patient 
all z:NScanSample&trans.target.nodes | let e1 = (some e : ANCollectSampleNScanSample&trans.target.arrows | e.trg = z), 
e2 = (some e : ASampleisnotforthepatient&trans.target.arrows | e.trg = z)|
(e1 or e2) and not (e1 and e2)
}
fact{ all trans: Trans|//imply Samples have not been sent 
all x:NScanSample&trans.target.nodes | let e1 = (some e : ASampleshavenotbeensent&trans.target.arrows | e.trg = x), 
e2 = (some e : ANCollectSampleNScanSample&trans.target.arrows | e.trg = x)| not e1 or e2
}
fact{ all trans: Trans|//surjective on (Reaction{type}):perform transfusion->Register Reaction
all n:(NRegisterReaction&trans.target.nodes)| some e:(AReactiontype&trans.target.arrows)| e.trg = n
}
fact{ all trans: Trans|//surjective on (Barcode):Scan Nurse Card->Get Nurse Info
all n:(NGetNurseInfo&trans.target.nodes)| some e:(ABarcode5&trans.target.arrows)| e.trg = n
}
fact{ all trans: Trans|//surjective on (Nurse{name}):Get Nurse Info->Show Nurse Info
all n:(NShowNurseInfo&trans.target.nodes)| some e:(ANursename&trans.target.arrows)| e.trg = n
}
fact{ all trans: Trans|//surjective on (Patient{name, ID, gender, blodtype, screening}):Get Patient Info->Show Patient Info
all n:(NShowPatientInfo&trans.target.nodes)| some e:(APatientnameIDgenderblodtypescreening&trans.target.arrows)| e.trg = n
}
fact{ all trans: Trans|//surjective on (Patient{temp, pressure_high, pressure_low, pulse}):Measure temperature, blood pressure and pulse->Store Patient Condition
all n:(NStorePatientCondition&trans.target.nodes)| some e:(APatienttemppressure_highpressure_lowpulse&trans.target.arrows)| e.trg = n
}
fact{ all trans: Trans|//surjective on (Transfusion, Nurse):Identify nurse, log transfusion->Store Transfusion
all n:(NStoreTransfusion&trans.target.nodes)| some e:(ATransfusionNurse&trans.target.arrows)| e.trg = n
}
fact{ all trans: Trans|//surjective on The blood Product is not for the patient:Verify Blood Product->Stop Transfusion, Contact AIT
all n:(NStopTransfusionContactAIT&trans.target.nodes)| some e:(AThebloodProductisnotforthepatient&trans.target.arrows)| e.trg = n
}
fact{ all trans: Trans|//surjective on (Barcode,  Patient):Scan Blood Product->Verify Blood Product
all n:(NVerifyBloodProduct&trans.target.nodes)| some e:(ABarcodePatient&trans.target.arrows)| e.trg = n
}
fact{ all trans: Trans|//xor3surj More blood out time less than 4h out time less than 4h
all x:NScanBloodProduct&trans.target.nodes | let e1 = (some e : Aouttimelessthan4h6&trans.target.arrows | e.trg = x), 
e2 = (some e : AMoreblood&trans.target.arrows | e.trg = x), 
e3 = (some e : Aouttimelessthan4h&trans.target.arrows | e.trg = x)|
not (e1 and e2) and not (e1 and e3) and not (e2 and e3) and (e1 or e2 or e3)
}
fact{ all trans: Trans|//NAND constraint between Sample is not for the patient:Get Patient Info->Scan Sample and Samples have not been sent:Send Blood Order->Scan Sample
all n:(NScanSample&trans.target.nodes) | let e1 = (some e : ASampleisnotforthepatient&trans.target.arrows | e.trg = n), e2=(some e : ASampleshavenotbeensent&trans.target.arrows | e.trg = n)|not(e1 and e2)
}
fact{ all trans: Trans|//surjective on (BloodOrder{quantity, expectTime}):Send Blood Order->Order Blood Product
all n:(NOrderBloodProduct&trans.target.nodes)| some e:(ABloodOrderquantityexpectTime&trans.target.arrows)| e.trg = n
}
fact{ all trans: Trans|//surjective on out time less then 0.5h:Collect Blood->Put Blood Into refrigertor
all n:(NPutBloodIntorefrigertor&trans.target.nodes)| some e:(Aouttimelessthen05h&trans.target.arrows)| e.trg = n
}
fact{ all trans: Trans|//XOR constraint between out time less then 0.5h:Collect Blood->Put Blood Into refrigertor and out time less than 4h:Collect Blood->Scan Blood Product
all n:(NCollectBlood&trans.target.nodes) | let e1 = (some e : Aouttimelessthen05h&trans.target.arrows | e.src = n), e2=(some e : Aouttimelessthan4h&trans.target.arrows | e.src = n)|not(e1 and e2)
}
fact{ all trans: Trans|//special out time less than 4h out time less than 4h
some NScanBloodProduct&trans.target.nodes implies ((some z:NScanBloodProduct&trans.target.nodes|some xz:Aouttimelessthan4h&trans.target.arrows|xz.trg=z) or (some z:NScanBloodProduct&trans.target.nodes|some yz:Aouttimelessthan4h6&trans.target.arrows|yz.trg=z))
}
fact{ all trans: Trans|//XOR constraint between bloodtype is unknown or screening is not done or invalid(screen is valid within 4 days):Show Patient Info->Order Sample and :Show Patient Info->Order Blood
all n:(NShowPatientInfo&trans.target.nodes) | let e1 = (some e : Abloodtypeisunknownorscreeningisnotdoneorinvalidscreenisvalidwithin4days&trans.target.arrows | e.src = n), e2=(some e : ANShowPatientInfoNOrderBlood&trans.target.arrows | e.src = n)|not(e1 and e2)
}
fact{ all trans: Trans|//surjective on (Blood*):Order Blood Product->Collect Blood
all n:(NCollectBlood&trans.target.nodes)| some e:(ABlood&trans.target.arrows)| e.trg = n
}
fact{ all trans: Trans|//XOR constraint between :Send Sample->Collect Blood and Blood have not been ordered:Send Sample->Order Blood
all n:(NSendSample&trans.target.nodes) | let e1 = (some e : ANSendSampleNCollectBlood&trans.target.arrows | e.src = n), e2=(some e : ABloodhavenotbeenordered4&trans.target.arrows | e.src = n)|not(e1 and e2)
}
fact{ all trans: Trans|//surjective on :Order Blood->Select Blood Product
all n:(NSelectBloodProduct&trans.target.nodes)| some e:(ANOrderBloodNSelectBloodProduct&trans.target.arrows)| e.trg = n
}
fact{ all trans: Trans|//xorsurj bloodtype is unknown or screening is not done or invalid(screen is valid within 4 days) Samples have not been ordered
all z:NOrderSample&trans.target.nodes | let e1 = (some e : ASampleshavenotbeenordered&trans.target.arrows | e.trg = z), 
e2 = (some e : Abloodtypeisunknownorscreeningisnotdoneorinvalidscreenisvalidwithin4days&trans.target.arrows | e.trg = z)|
(e1 or e2) and not (e1 and e2)
}
fact{ all trans: Trans|//xor3 Samples have not been sent Samples have not been ordered (BloodOrder{quantity, expectTime})
all x:NSendBloodOrder&trans.target.nodes | let e1 = (some e : ASampleshavenotbeensent&trans.target.arrows | e.src = x), 
e2 = (some e : ABloodOrderquantityexpectTime&trans.target.arrows | e.src = x), 
e3 = (some e : ASampleshavenotbeenordered&trans.target.arrows | e.src = x)|
not (e1 and e2) and not (e1 and e3) and not (e2 and e3)
}
fact{ all trans: Trans|//xorsurj  The blood is for the patient
all z:Nperformtransfusion&trans.target.nodes | let e1 = (some e : AThebloodisforthepatient&trans.target.arrows | e.trg = z), 
e2 = (some e : ANMeasuretemperaturebloodpressureandpulseNperformtransfusion&trans.target.arrows | e.trg = z)|
(e1 or e2) and not (e1 and e2)
}
fact{ all trans: Trans|//imply2  Patient has not been bloodtyped
all y1:NSendSampleOrder&trans.target.nodes, y2:NSelectBlodTypeing&trans.target.nodes | let e1 = (some e : ANSelectBlodTypeingNSendSampleOrder&trans.target.arrows | e.trg = y1), 
e2 = (some e : APatienthasnotbeenbloodtyped&trans.target.arrows | e.trg = y2)|
 e1 implies e2
}
fact{ all trans: Trans|//imply2 out time less then 0.5h out time less than 4h
all y1:NScanBloodProduct&trans.target.nodes, y2:NPutBloodIntorefrigertor&trans.target.nodes | let e1 = (some e : Aouttimelessthan4h6&trans.target.arrows | e.trg = y1), 
e2 = (some e : Aouttimelessthen05h&trans.target.arrows | e.trg = y2)|
 e1 implies e2
}
fact{ all trans: Trans|//xorsurj  Nurse is not found
all z:NScanNurseCard&trans.target.nodes | let e1 = (some e : ANurseisnotfound&trans.target.arrows | e.trg = z), 
e2 = (some e : ANInitNScanNurseCard&trans.target.arrows | e.trg = z)|
(e1 or e2) and not (e1 and e2)
}
fact{ all trans: Trans|//mulitplicity on Init min:1;max:1
let count = #NInit&trans.target.nodes | count>=1 and count <=1
}
fact{ all trans: Trans|//surjective on (Sample Label File*):Send Sample Order->Print Sample Label
all n:(NPrintSampleLabel&trans.target.nodes)| some e:(ASampleLabelFile&trans.target.arrows)| e.trg = n
}
fact{ all trans: Trans|//surjective on (Label*):Print Sample Label->Collect Sample
all n:(NCollectSample&trans.target.nodes)| some e:(ALabel&trans.target.arrows)| e.trg = n
}
fact{ all trans: Trans|//XOR constraint between (Patient{temp, pressure_high, pressure_low, pulse}):Measure temperature, blood pressure and pulse->Store Patient Condition and :Measure temperature, blood pressure and pulse->perform transfusion
all n:(NMeasuretemperaturebloodpressureandpulse&trans.target.nodes) | let e1 = (some e : APatienttemppressure_highpressure_lowpulse&trans.target.arrows | e.src = n), e2=(some e : ANMeasuretemperaturebloodpressureandpulseNperformtransfusion&trans.target.arrows | e.src = n)|not(e1 and e2)
}
fact{ all trans: Trans|//xor4  (Reaction{type})  More blood
all x:Nperformtransfusion&trans.target.nodes | let e1 = (some e : ANperformtransfusionNIdentifynurselogtransfusion&trans.target.arrows | e.src = x), 
e2 = (some e : AReactiontype&trans.target.arrows | e.src = x), 
e3 = (some e : ANperformtransfusionNMeasuretemperaturebloodpressureandpulse&trans.target.arrows | e.src = x),
e4 = (some e : AMoreblood&trans.target.arrows | e.src = x)|
not (e1 and e2) and not (e1 and e3) and not (e2 and e3) and not (e1 and e4)   and not (e2 and e4) and not (e3 and e4)
}
fact{ all trans: Trans|//surjective on :perform transfusion->Measure temperature, blood pressure and pulse
all n:(NMeasuretemperaturebloodpressureandpulse&trans.target.nodes)| some e:(ANperformtransfusionNMeasuretemperaturebloodpressureandpulse&trans.target.arrows)| e.trg = n
}
