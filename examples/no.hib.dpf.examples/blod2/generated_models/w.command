//mulitplicity on ScanNurseCard min:0;max:2
let count = #NScanNurseCard&trans.target.nodes | count>=0 and count <=2
//imply2 Blood have not been ordered bloodtype is unknown or screening is not done or invalid(screen is valid within 4 days)
all y1:NOrderBlood&trans.target.nodes, y2:NOrderSample&trans.target.nodes | let e1 = (some e : ABloodhavenotbeenordered&trans.target.arrows | e.trg = y1), 
e2 = (some e : Abloodtypeisunknownorscreeningisnotdoneorinvalidscreenisvalidwithin4days&trans.target.arrows | e.trg = y2)|
 e1 implies e2
//imply2 Blood have not been ordered bloodtype is unknown or screening is not done or invalid(screen is valid within 4 days)
all y1:NOrderBlood&trans.target.nodes, y2:NOrderSample&trans.target.nodes | let e1 = (some e : ABloodhavenotbeenordered4&trans.target.arrows | e.trg = y1), 
e2 = (some e : Abloodtypeisunknownorscreeningisnotdoneorinvalidscreenisvalidwithin4days&trans.target.arrows | e.trg = y2)|
 e1 implies e2
//mulitplicity on ScanPatientWristband min:0;max:2
let count = #NScanPatientWristband&trans.target.nodes | count>=0 and count <=2
//mulitplicity on ScanSample min:0;max:1
let count = #NScanSample&trans.target.nodes | count>=0 and count <=1
//mulitplicity on ScanBloodProduct min:0;max:2
let count = #NScanBloodProduct&trans.target.nodes | count>=0 and count <=2
