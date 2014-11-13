sig NIE{}
sig NBT1{}
sig NMRI{}
sig NE1{}
sig NPA{}
sig NPB{}
sig NE2{}
sig NBT2{}
sig NEND{}
sig NTD{}
abstract sig NState{}
lone sig F, E extends NState{}

sig Af0{src:one NIE, trg:one NBT1}
sig Af1{src:one NIE, trg:one NMRI}
sig Af2{src:one NBT1, trg:one NE1}
sig Af3{src:one NMRI, trg:one NE1}
sig Af4{src:one NE1, trg:one NPA}
sig Af5{src:one NE1, trg:one NPB}
sig Af6{src:one NPA, trg:one NE2}
sig Af7{src:one NPB, trg:one NE2}
sig Af8{src:one NE2, trg:one NEND}
sig Af9{src:one NE2, trg:one NTD}
sig Af10{src:one NTD, trg:one NBT2}
sig Af11{src:one NBT2, trg:one NE2}
sig AresE2{src:one NE2, trg:one Int}{trg=0 or trg=1}
sig Acount{src:one NE2, trg:one Int}{not (trg>5 or trg<0)}
sig AresE1{src:one NE1, trg:one Int}{trg=0 or trg=1}
sig Aatt0{src:one NIE, trg:one NState}
sig Aatt1{src:one NMRI, trg:one NState}
sig Aatt2{src:one NBT1, trg:one NState}
sig Aatt3{src:one NE1, trg:one NState}
sig Aatt4{src:one NPA, trg:one NState}
sig Aatt5{src:one NPB, trg:one NState}
sig Aatt6{src:one NE2, trg:one NState}
sig Aatt7{src:one NBT2, trg:one NState}
sig Aatt8{src:one NTD, trg:one NState}
sig Aatt9{src:one NEND, trg:one NState}

one abstract sig Rule{}
lone sig r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r81, r91, r101, r102, r103 extends Rule{}

sig Graph{nodes:set NIE+NBT1+NMRI+NE1+NPA+NPB+NE2+NBT2+NEND+NTD+NState+Int, 
arrows:set Af0+Af1+Af2+Af3+Af4+Af5+Af6+Af7+Af8+Af9+Af10+Af11+AresE2+Acount+AresE1+Aatt0+Aatt1+Aatt2+Aatt3+Aatt4+Aatt5+Aatt6+Aatt7+Aatt8+Aatt9}

sig Trans{rule:one Rule, source:one Graph, target:one Graph, 
dnodes, anodes:set NIE+NBT1+NMRI+NE1+NPA+NPB+NE2+NBT2+NEND+NTD+NState+Int, 
darrows, aarrows:set Af0+Af1+Af2+Af3+Af4+Af5+Af6+Af7+Af8+Af9+Af10+Af11+AresE2+Acount+AresE1+Aatt0+Aatt1+Aatt2+Aatt3+Aatt4+Aatt5+Aatt6+Aatt7+Aatt8+Aatt9}

pred no_dangle_arrow[trans:Trans]{
all arrow : Af0|(arrow.src in trans.dnodes or arrow.trg in trans.dnodes) implies arrow in trans.darrows
all arrow : Af0|(arrow.src in trans.anodes or arrow.trg in trans.anodes) implies arrow in trans.aarrows
all arrow : Af1|(arrow.src in trans.dnodes or arrow.trg in trans.dnodes) implies arrow in trans.darrows
all arrow : Af1|(arrow.src in trans.anodes or arrow.trg in trans.anodes) implies arrow in trans.aarrows
all arrow : Af2|(arrow.src in trans.dnodes or arrow.trg in trans.dnodes) implies arrow in trans.darrows
all arrow : Af2|(arrow.src in trans.anodes or arrow.trg in trans.anodes) implies arrow in trans.aarrows
all arrow : Af3|(arrow.src in trans.dnodes or arrow.trg in trans.dnodes) implies arrow in trans.darrows
all arrow : Af3|(arrow.src in trans.anodes or arrow.trg in trans.anodes) implies arrow in trans.aarrows
all arrow : Af4|(arrow.src in trans.dnodes or arrow.trg in trans.dnodes) implies arrow in trans.darrows
all arrow : Af4|(arrow.src in trans.anodes or arrow.trg in trans.anodes) implies arrow in trans.aarrows
all arrow : Af5|(arrow.src in trans.dnodes or arrow.trg in trans.dnodes) implies arrow in trans.darrows
all arrow : Af5|(arrow.src in trans.anodes or arrow.trg in trans.anodes) implies arrow in trans.aarrows
all arrow : Af6|(arrow.src in trans.dnodes or arrow.trg in trans.dnodes) implies arrow in trans.darrows
all arrow : Af6|(arrow.src in trans.anodes or arrow.trg in trans.anodes) implies arrow in trans.aarrows
all arrow : Af7|(arrow.src in trans.dnodes or arrow.trg in trans.dnodes) implies arrow in trans.darrows
all arrow : Af7|(arrow.src in trans.anodes or arrow.trg in trans.anodes) implies arrow in trans.aarrows
all arrow : Af8|(arrow.src in trans.dnodes or arrow.trg in trans.dnodes) implies arrow in trans.darrows
all arrow : Af8|(arrow.src in trans.anodes or arrow.trg in trans.anodes) implies arrow in trans.aarrows
all arrow : Af9|(arrow.src in trans.dnodes or arrow.trg in trans.dnodes) implies arrow in trans.darrows
all arrow : Af9|(arrow.src in trans.anodes or arrow.trg in trans.anodes) implies arrow in trans.aarrows
all arrow : Af10|(arrow.src in trans.dnodes or arrow.trg in trans.dnodes) implies arrow in trans.darrows
all arrow : Af10|(arrow.src in trans.anodes or arrow.trg in trans.anodes) implies arrow in trans.aarrows
all arrow : Af11|(arrow.src in trans.dnodes or arrow.trg in trans.dnodes) implies arrow in trans.darrows
all arrow : Af11|(arrow.src in trans.anodes or arrow.trg in trans.anodes) implies arrow in trans.aarrows
all arrow : AresE2|(arrow.src in trans.dnodes or arrow.trg in trans.dnodes) implies arrow in trans.darrows
all arrow : AresE2|(arrow.src in trans.anodes or arrow.trg in trans.anodes) implies arrow in trans.aarrows
all arrow : Acount|(arrow.src in trans.dnodes or arrow.trg in trans.dnodes) implies arrow in trans.darrows
all arrow : Acount|(arrow.src in trans.anodes or arrow.trg in trans.anodes) implies arrow in trans.aarrows
all arrow : AresE1|(arrow.src in trans.dnodes or arrow.trg in trans.dnodes) implies arrow in trans.darrows
all arrow : AresE1|(arrow.src in trans.anodes or arrow.trg in trans.anodes) implies arrow in trans.aarrows
all arrow : Aatt0|(arrow.src in trans.dnodes or arrow.trg in trans.dnodes) implies arrow in trans.darrows
all arrow : Aatt0|(arrow.src in trans.anodes or arrow.trg in trans.anodes) implies arrow in trans.aarrows
all arrow : Aatt1|(arrow.src in trans.dnodes or arrow.trg in trans.dnodes) implies arrow in trans.darrows
all arrow : Aatt1|(arrow.src in trans.anodes or arrow.trg in trans.anodes) implies arrow in trans.aarrows
all arrow : Aatt2|(arrow.src in trans.dnodes or arrow.trg in trans.dnodes) implies arrow in trans.darrows
all arrow : Aatt2|(arrow.src in trans.anodes or arrow.trg in trans.anodes) implies arrow in trans.aarrows
all arrow : Aatt3|(arrow.src in trans.dnodes or arrow.trg in trans.dnodes) implies arrow in trans.darrows
all arrow : Aatt3|(arrow.src in trans.anodes or arrow.trg in trans.anodes) implies arrow in trans.aarrows
all arrow : Aatt4|(arrow.src in trans.dnodes or arrow.trg in trans.dnodes) implies arrow in trans.darrows
all arrow : Aatt4|(arrow.src in trans.anodes or arrow.trg in trans.anodes) implies arrow in trans.aarrows
all arrow : Aatt5|(arrow.src in trans.dnodes or arrow.trg in trans.dnodes) implies arrow in trans.darrows
all arrow : Aatt5|(arrow.src in trans.anodes or arrow.trg in trans.anodes) implies arrow in trans.aarrows
all arrow : Aatt6|(arrow.src in trans.dnodes or arrow.trg in trans.dnodes) implies arrow in trans.darrows
all arrow : Aatt6|(arrow.src in trans.anodes or arrow.trg in trans.anodes) implies arrow in trans.aarrows
all arrow : Aatt7|(arrow.src in trans.dnodes or arrow.trg in trans.dnodes) implies arrow in trans.darrows
all arrow : Aatt7|(arrow.src in trans.anodes or arrow.trg in trans.anodes) implies arrow in trans.aarrows
all arrow : Aatt8|(arrow.src in trans.dnodes or arrow.trg in trans.dnodes) implies arrow in trans.darrows
all arrow : Aatt8|(arrow.src in trans.anodes or arrow.trg in trans.anodes) implies arrow in trans.aarrows
all arrow : Aatt9|(arrow.src in trans.dnodes or arrow.trg in trans.dnodes) implies arrow in trans.darrows
all arrow : Aatt9|(arrow.src in trans.anodes or arrow.trg in trans.anodes) implies arrow in trans.aarrows
}

fact{
(Trans.source+Trans.target)=Graph
Rule=Trans.rule
Graph.nodes=NIE+NBT1+NMRI+NE1+NPA+NPB+NE2+NBT2+NEND+NTD+NState+AresE2.trg+AresE1.trg+Acount.trg
Graph.arrows=Af0+Af1+Af2+Af3+Af4+Af5+Af6+Af7+Af8+Af9+Af10+Af11+AresE2+Acount+AresE1+Aatt0+Aatt1+Aatt2+Aatt3+Aatt4+Aatt5+Aatt6+Aatt7+Aatt8+Aatt9
all trans:Trans | no_dangle_arrow[trans] and trans_general[trans] and source_valid[trans] and (
rule_r1[trans] or rule_r2[trans] or rule_r3[trans] or rule_r4[trans] or rule_r5[trans] or rule_r6[trans] or rule_r7[trans] or rule_r8[trans] or rule_r9[trans] or rule_r10[trans] or rule_r11[trans] or rule_r81[trans] or rule_r91[trans] or rule_r101[trans] or rule_r102[trans] or rule_r103[trans])
}

pred rule_r1[trans:Trans]{
some trans.rule&r1

some e_att00:Aatt0&(trans.source.arrows-trans.darrows) |
let n_IE0 = e_att00.src, n_F = e_att00.trg |
(n_IE0 in NIE&(trans.source.nodes-trans.dnodes) and n_F in F) 
// in NState&(trans.source.nodes-trans.dnodes))
some E
//divide
all e_f10:Af1&trans.aarrows, e_att10:Aatt1&trans.aarrows | e_f10.trg=e_att10.src
all e_f00:Af0&trans.aarrows, e_att20:Aatt2&trans.aarrows | e_f00.trg=e_att20.src
all e_att10:Aatt1&trans.aarrows, e_att20:Aatt2&trans.aarrows|e_att10.trg=e_att20.trg 
all e_f10:Af1&trans.aarrows, e_f00:Af0&trans.aarrows|e_f10.src=e_f00.src
all e_att10:Aatt1&trans.aarrows|e_att10.trg in E
all e_att20:Aatt2&trans.aarrows|e_att20.trg in E

one e_att00:Aatt0&(trans.source.arrows-trans.darrows), e_f10:Af1&trans.aarrows |
let n_IE0 = e_att00.src, n_F = e_att00.trg, n_MRI0 = e_f10.trg |
(n_IE0 = e_f10.src and
n_MRI0 in NMRI&trans.anodes and 
n_IE0 in NIE&(trans.source.nodes-trans.dnodes) and n_F in F) 

//one e_att00:Aatt0&(trans.source.arrows-trans.darrows), e_f10:Af1&trans.aarrows, e_f00:Af0&trans.aarrows, e_att10:Aatt1&trans.aarrows, e_att20:Aatt2&trans.aarrows |
//let n_IE0 = e_att00.src, n_F = e_att00.trg, n_BT10 = e_f00.trg, n_MRI0 = e_f10.trg, n_E = e_att10.trg |
//(n_IE0 = e_f10.src and n_IE0 = e_f00.src and n_MRI0 = e_att10.src and n_BT10 = e_att20.src and n_E = e_att20.trg  and
//n_MRI0 in NMRI&trans.anodes and n_BT10 in NBT1&trans.anodes and
//n_IE0 in NIE&(trans.source.nodes-trans.dnodes) and n_F in F and n_E in E)

#NBT1&trans.anodes = 1
#NMRI&trans.anodes = 1
#Aatt1&trans.aarrows = 1
#Aatt2&trans.aarrows = 1
#Af1&trans.aarrows = 1
#Af0&trans.aarrows = 1
no NIE&trans.dnodes
no NBT1&trans.dnodes
no NMRI&trans.dnodes
no NE1&trans.dnodes
no NPA&trans.dnodes
no NPB&trans.dnodes
no NE2&trans.dnodes
no NBT2&trans.dnodes
no NEND&trans.dnodes
no NTD&trans.dnodes
no Int&trans.dnodes
no NState&trans.dnodes
no NIE&trans.anodes
no NE1&trans.anodes
no NPA&trans.anodes
no NPB&trans.anodes
no NE2&trans.anodes
no NBT2&trans.anodes
no NEND&trans.anodes
no NTD&trans.anodes
no Int&trans.anodes
no NState&trans.anodes
no Af0&trans.darrows
no Af1&trans.darrows
no Af2&trans.darrows
no Af3&trans.darrows
no Af4&trans.darrows
no Af5&trans.darrows
no Af6&trans.darrows
no Af7&trans.darrows
no Af8&trans.darrows
no Af9&trans.darrows
no Af10&trans.darrows
no Af11&trans.darrows
no AresE2&trans.darrows
no Acount&trans.darrows
no AresE1&trans.darrows
no Aatt0&trans.darrows
no Aatt1&trans.darrows
no Aatt2&trans.darrows
no Aatt3&trans.darrows
no Aatt4&trans.darrows
no Aatt5&trans.darrows
no Aatt6&trans.darrows
no Aatt7&trans.darrows
no Aatt8&trans.darrows
no Aatt9&trans.darrows
no Af2&trans.aarrows
no Af3&trans.aarrows
no Af4&trans.aarrows
no Af5&trans.aarrows
no Af6&trans.aarrows
no Af7&trans.aarrows
no Af8&trans.aarrows
no Af9&trans.aarrows
no Af10&trans.aarrows
no Af11&trans.aarrows
no AresE2&trans.aarrows
no Acount&trans.aarrows
no AresE1&trans.aarrows
no Aatt0&trans.aarrows
no Aatt3&trans.aarrows
no Aatt4&trans.aarrows
no Aatt5&trans.aarrows
no Aatt6&trans.aarrows
no Aatt7&trans.aarrows
no Aatt8&trans.aarrows
no Aatt9&trans.aarrows
}

pred rule_r2[trans:Trans]{
some trans.rule&r2

some e_att20:Aatt2&(trans.source.arrows-trans.darrows), e_att10:Aatt1&(trans.source.arrows-trans.darrows) |
let n_MRI0 = e_att10.src, n_BT10 = e_att20.src, n_F = e_att20.trg |
(n_F = e_att10.trg  and
n_BT10 in NBT1&(trans.source.nodes-trans.dnodes) and n_F in F and n_MRI0 in NMRI&(trans.source.nodes-trans.dnodes))
some E

//Divide
all e_f20:Af2&trans.aarrows, e_f30:Af3&trans.aarrows |e_f20.trg=e_f30.trg 
all e_f20:Af2&trans.aarrows, e_att30:Aatt3&trans.aarrows |e_f20.trg=e_att30.src
all e_att30:Aatt3&trans.aarrows, e_f30:Af3&trans.aarrows |e_att30.src=e_f30.trg 
all e_att30:Aatt3&trans.aarrows | e_att30.trg in E
one e_att20:Aatt2&(trans.source.arrows-trans.darrows), e_f20:Af2&trans.aarrows, e_att10:Aatt1&(trans.source.arrows-trans.darrows) |
let n_MRI0 = e_att10.src, n_BT10 = e_att20.src, n_E10 = e_f20.trg, n_F = e_att20.trg |
(n_BT10 = e_f20.src and n_F = e_att10.trg and 
n_E10 in NE1&trans.anodes and
n_BT10 in NBT1&(trans.source.nodes-trans.dnodes) and n_F in F and n_MRI0 in NMRI&(trans.source.nodes-trans.dnodes)) 

//one e_att20:Aatt2&(trans.source.arrows-trans.darrows), e_f20:Af2&trans.aarrows, e_att10:Aatt1&(trans.source.arrows-trans.darrows), e_f30:Af3&trans.aarrows, e_att30:Aatt3&trans.aarrows |
//let n_MRI0 = e_att10.src, n_BT10 = e_att20.src, n_E10 = e_f20.trg, n_E = e_att30.trg, n_F = e_att20.trg |
//(n_BT10 = e_f20.src and n_F = e_att10.trg and n_MRI0 = e_f30.src and n_E10 = e_f30.trg and n_E10 = e_att30.src  and
//n_E10 in NE1&trans.anodes and
//n_BT10 in NBT1&(trans.source.nodes-trans.dnodes) and n_F in F and n_MRI0 in NMRI&(trans.source.nodes-trans.dnodes) and n_E in E) 

#NE1&trans.anodes = 1
#Af3&trans.aarrows = 1
#Af2&trans.aarrows = 1
#Aatt3&trans.aarrows = 1
no NIE&trans.dnodes
no NBT1&trans.dnodes
no NMRI&trans.dnodes
no NE1&trans.dnodes
no NPA&trans.dnodes
no NPB&trans.dnodes
no NE2&trans.dnodes
no NBT2&trans.dnodes
no NEND&trans.dnodes
no NTD&trans.dnodes
no Int&trans.dnodes
no NState&trans.dnodes
no NIE&trans.anodes
no NBT1&trans.anodes
no NMRI&trans.anodes
no NPA&trans.anodes
no NPB&trans.anodes
no NE2&trans.anodes
no NBT2&trans.anodes
no NEND&trans.anodes
no NTD&trans.anodes
no Int&trans.anodes
no NState&trans.anodes
no Af0&trans.darrows
no Af1&trans.darrows
no Af2&trans.darrows
no Af3&trans.darrows
no Af4&trans.darrows
no Af5&trans.darrows
no Af6&trans.darrows
no Af7&trans.darrows
no Af8&trans.darrows
no Af9&trans.darrows
no Af10&trans.darrows
no Af11&trans.darrows
no AresE2&trans.darrows
no Acount&trans.darrows
no AresE1&trans.darrows
no Aatt0&trans.darrows
no Aatt1&trans.darrows
no Aatt2&trans.darrows
no Aatt3&trans.darrows
no Aatt4&trans.darrows
no Aatt5&trans.darrows
no Aatt6&trans.darrows
no Aatt7&trans.darrows
no Aatt8&trans.darrows
no Aatt9&trans.darrows
no Af0&trans.aarrows
no Af1&trans.aarrows
no Af4&trans.aarrows
no Af5&trans.aarrows
no Af6&trans.aarrows
no Af7&trans.aarrows
no Af8&trans.aarrows
no Af9&trans.aarrows
no Af10&trans.aarrows
no Af11&trans.aarrows
no AresE2&trans.aarrows
no Acount&trans.aarrows
no AresE1&trans.aarrows
no Aatt0&trans.aarrows
no Aatt1&trans.aarrows
no Aatt2&trans.aarrows
no Aatt4&trans.aarrows
no Aatt5&trans.aarrows
no Aatt6&trans.aarrows
no Aatt7&trans.aarrows
no Aatt8&trans.aarrows
no Aatt9&trans.aarrows
}

pred rule_r3[trans:Trans]{
some trans.rule&r3

some e_att30:Aatt3&(trans.source.arrows-trans.darrows), e_resE10:AresE1&(trans.source.arrows-trans.darrows) |
let n_E10 = e_att30.src, n_F = e_att30.trg, n_BT = e_resE10.trg |
(n_E10 = e_resE10.src  and
n_E10 in NE1&(trans.source.nodes-trans.dnodes) and n_F in F and n_BT in Int&(trans.source.nodes-trans.dnodes))
some E

//Divide
all e_f40:Af4&trans.aarrows, e_att40:Aatt4&trans.aarrows | e_f40.trg=e_att40.src
all e_att40:Aatt4&trans.aarrows | e_att40.trg in E
one e_att30:Aatt3&(trans.source.arrows-trans.darrows), e_resE10:AresE1&(trans.source.arrows-trans.darrows), e_f40:Af4&trans.aarrows|
let n_E10 = e_att30.src, n_F = e_att30.trg, n_BT = e_resE10.trg, n_PA0 = e_f40.trg |
(n_E10 = e_resE10.src and n_E10 = e_f40.src and 
n_PA0 in NPA&trans.anodes and
n_E10 in NE1&(trans.source.nodes-trans.dnodes) and n_F in F and n_BT in Int&(trans.source.nodes-trans.dnodes)) 

//one e_att30:Aatt3&(trans.source.arrows-trans.darrows), e_resE10:AresE1&(trans.source.arrows-trans.darrows), e_f40:Af4&trans.aarrows, e_att40:Aatt4&trans.aarrows |
//let n_E10 = e_att30.src, n_F = e_att30.trg, n_PA0 = e_f40.trg, n_E = e_att40.trg, n_BT = e_resE10.trg |
//(n_E10 = e_resE10.src and n_E10 = e_f40.src and n_PA0 = e_att40.src  and
//n_PA0 in NPA&trans.anodes and
//n_E10 in NE1&(trans.source.nodes-trans.dnodes) and n_F in F and n_BT in Int&(trans.source.nodes-trans.dnodes) and n_E in E) 

#NPA&trans.anodes = 1
#Af4&trans.aarrows = 1
#Aatt4&trans.aarrows = 1
no NIE&trans.dnodes
no NBT1&trans.dnodes
no NMRI&trans.dnodes
no NE1&trans.dnodes
no NPA&trans.dnodes
no NPB&trans.dnodes
no NE2&trans.dnodes
no NBT2&trans.dnodes
no NEND&trans.dnodes
no NTD&trans.dnodes
no Int&trans.dnodes
no NState&trans.dnodes
no NIE&trans.anodes
no NBT1&trans.anodes
no NMRI&trans.anodes
no NE1&trans.anodes
no NPB&trans.anodes
no NE2&trans.anodes
no NBT2&trans.anodes
no NEND&trans.anodes
no NTD&trans.anodes
no Int&trans.anodes
no NState&trans.anodes
no Af0&trans.darrows
no Af1&trans.darrows
no Af2&trans.darrows
no Af3&trans.darrows
no Af4&trans.darrows
no Af5&trans.darrows
no Af6&trans.darrows
no Af7&trans.darrows
no Af8&trans.darrows
no Af9&trans.darrows
no Af10&trans.darrows
no Af11&trans.darrows
no AresE2&trans.darrows
no Acount&trans.darrows
no AresE1&trans.darrows
no Aatt0&trans.darrows
no Aatt1&trans.darrows
no Aatt2&trans.darrows
no Aatt3&trans.darrows
no Aatt4&trans.darrows
no Aatt5&trans.darrows
no Aatt6&trans.darrows
no Aatt7&trans.darrows
no Aatt8&trans.darrows
no Aatt9&trans.darrows
no Af0&trans.aarrows
no Af1&trans.aarrows
no Af2&trans.aarrows
no Af3&trans.aarrows
no Af5&trans.aarrows
no Af6&trans.aarrows
no Af7&trans.aarrows
no Af8&trans.aarrows
no Af9&trans.aarrows
no Af10&trans.aarrows
no Af11&trans.aarrows
no AresE2&trans.aarrows
no Acount&trans.aarrows
no AresE1&trans.aarrows
no Aatt0&trans.aarrows
no Aatt1&trans.aarrows
no Aatt2&trans.aarrows
no Aatt3&trans.aarrows
no Aatt5&trans.aarrows
no Aatt6&trans.aarrows
no Aatt7&trans.aarrows
no Aatt8&trans.aarrows
no Aatt9&trans.aarrows
}

pred rule_r4[trans:Trans]{
some trans.rule&r4

some e_resE10:AresE1&(trans.source.arrows-trans.darrows), e_att30:Aatt3&(trans.source.arrows-trans.darrows) |
let n_E10 = e_resE10.src, n_F = e_att30.trg, n_BF = e_resE10.trg |
(n_E10 = e_att30.src  and
n_E10 in NE1&(trans.source.nodes-trans.dnodes) and n_BF in Int&(trans.source.nodes-trans.dnodes) and n_F in F) 
some E

//Divide
all e_f50:Af5&trans.aarrows, e_att50:Aatt5&trans.aarrows | e_f50.trg=e_att50.src
all e_att50:Aatt5&trans.aarrows | e_att50.trg in E
one e_resE10:AresE1&(trans.source.arrows-trans.darrows), e_att30:Aatt3&(trans.source.arrows-trans.darrows), e_f50:Af5&trans.aarrows |
let n_E10 = e_resE10.src, n_PB0 = e_f50.trg, n_F = e_att30.trg, n_BF = e_resE10.trg |
(n_E10 = e_att30.src and n_E10 = e_f50.src and 
n_PB0 in NPB&trans.anodes and
n_E10 in NE1&(trans.source.nodes-trans.dnodes) and n_BF in Int&(trans.source.nodes-trans.dnodes) and n_F in F) 

//one e_resE10:AresE1&(trans.source.arrows-trans.darrows), e_att30:Aatt3&(trans.source.arrows-trans.darrows), e_f50:Af5&trans.aarrows, e_att50:Aatt5&trans.aarrows |
//let n_E10 = e_resE10.src, n_PB0 = e_f50.trg, n_E = e_att50.trg, n_F = e_att30.trg, n_BF = e_resE10.trg |
//(n_E10 = e_att30.src and n_E10 = e_f50.src and n_PB0 = e_att50.src  and
//n_PB0 in NPB&trans.anodes and
//n_E10 in NE1&(trans.source.nodes-trans.dnodes) and n_BF in Int&(trans.source.nodes-trans.dnodes) and n_F in F and n_E in E) 

#NPB&trans.anodes = 1
#Aatt5&trans.aarrows = 1
#Af5&trans.aarrows = 1
no NIE&trans.dnodes
no NBT1&trans.dnodes
no NMRI&trans.dnodes
no NE1&trans.dnodes
no NPA&trans.dnodes
no NPB&trans.dnodes
no NE2&trans.dnodes
no NBT2&trans.dnodes
no NEND&trans.dnodes
no NTD&trans.dnodes
no Int&trans.dnodes
no NState&trans.dnodes
no NIE&trans.anodes
no NBT1&trans.anodes
no NMRI&trans.anodes
no NE1&trans.anodes
no NPA&trans.anodes
no NE2&trans.anodes
no NBT2&trans.anodes
no NEND&trans.anodes
no NTD&trans.anodes
no Int&trans.anodes
no NState&trans.anodes
no Af0&trans.darrows
no Af1&trans.darrows
no Af2&trans.darrows
no Af3&trans.darrows
no Af4&trans.darrows
no Af5&trans.darrows
no Af6&trans.darrows
no Af7&trans.darrows
no Af8&trans.darrows
no Af9&trans.darrows
no Af10&trans.darrows
no Af11&trans.darrows
no AresE2&trans.darrows
no Acount&trans.darrows
no AresE1&trans.darrows
no Aatt0&trans.darrows
no Aatt1&trans.darrows
no Aatt2&trans.darrows
no Aatt3&trans.darrows
no Aatt4&trans.darrows
no Aatt5&trans.darrows
no Aatt6&trans.darrows
no Aatt7&trans.darrows
no Aatt8&trans.darrows
no Aatt9&trans.darrows
no Af0&trans.aarrows
no Af1&trans.aarrows
no Af2&trans.aarrows
no Af3&trans.aarrows
no Af4&trans.aarrows
no Af6&trans.aarrows
no Af7&trans.aarrows
no Af8&trans.aarrows
no Af9&trans.aarrows
no Af10&trans.aarrows
no Af11&trans.aarrows
no AresE2&trans.aarrows
no Acount&trans.aarrows
no AresE1&trans.aarrows
no Aatt0&trans.aarrows
no Aatt1&trans.aarrows
no Aatt2&trans.aarrows
no Aatt3&trans.aarrows
no Aatt4&trans.aarrows
no Aatt6&trans.aarrows
no Aatt7&trans.aarrows
no Aatt8&trans.aarrows
no Aatt9&trans.aarrows
}

pred rule_r5[trans:Trans]{
some trans.rule&r5

some e_att40:Aatt4&(trans.source.arrows-trans.darrows) |
let n_PA0 = e_att40.src, n_F = e_att40.trg |
(n_PA0 in NPA&(trans.source.nodes-trans.dnodes) and n_F in F) 
some E

//Divide
all e_f60:Af6&trans.aarrows, e_att60:Aatt6&trans.aarrows | e_f60.trg=e_att60.src
all e_f60:Af6&trans.aarrows, e_count0:Acount&trans.aarrows | e_f60.trg=e_count0.src 
all e_att60:Aatt6&trans.aarrows, e_count0:Acount&trans.aarrows | e_att60.src=e_count0.src
all e_count0:Acount&trans.aarrows | e_count0.trg=0
all e_att60:Aatt6&trans.aarrows | e_att60.trg in E

one e_att40:Aatt4&(trans.source.arrows-trans.darrows), e_f60:Af6&trans.aarrows |
let n_PA0 = e_att40.src, n_E20 = e_f60.trg, n_F = e_att40.trg |
(n_PA0 = e_f60.src and 
n_E20 in NE2&trans.anodes and
n_PA0 in NPA&(trans.source.nodes-trans.dnodes) and n_F in F) 

//one e_att40:Aatt4&(trans.source.arrows-trans.darrows), e_f60:Af6&trans.aarrows, e_att60:Aatt6&trans.aarrows, e_count0:Acount&trans.aarrows |
//let n_PA0 = e_att40.src, n_E20 = e_f60.trg, n_F = e_att40.trg, n_E = e_att60.trg, n_I0 = e_count0.trg |
//(n_PA0 = e_f60.src and n_E20 = e_att60.src and n_E20 = e_count0.src  and
//n_E20 in NE2&trans.anodes and
//n_PA0 in NPA&(trans.source.nodes-trans.dnodes) and n_F in F and n_E in E and n_I0=0) 

#NE2&trans.anodes = 1
#Af6&trans.aarrows = 1
#Acount&trans.aarrows = 1
#Aatt6&trans.aarrows = 1
no NIE&trans.dnodes
no NBT1&trans.dnodes
no NMRI&trans.dnodes
no NE1&trans.dnodes
no NPA&trans.dnodes
no NPB&trans.dnodes
no NE2&trans.dnodes
no NBT2&trans.dnodes
no NEND&trans.dnodes
no NTD&trans.dnodes
no Int&trans.dnodes
no NState&trans.dnodes
no NIE&trans.anodes
no NBT1&trans.anodes
no NMRI&trans.anodes
no NE1&trans.anodes
no NPA&trans.anodes
no NPB&trans.anodes
no NBT2&trans.anodes
no NEND&trans.anodes
no NTD&trans.anodes
no Int&trans.anodes
no NState&trans.anodes
no Af0&trans.darrows
no Af1&trans.darrows
no Af2&trans.darrows
no Af3&trans.darrows
no Af4&trans.darrows
no Af5&trans.darrows
no Af6&trans.darrows
no Af7&trans.darrows
no Af8&trans.darrows
no Af9&trans.darrows
no Af10&trans.darrows
no Af11&trans.darrows
no AresE2&trans.darrows
no Acount&trans.darrows
no AresE1&trans.darrows
no Aatt0&trans.darrows
no Aatt1&trans.darrows
no Aatt2&trans.darrows
no Aatt3&trans.darrows
no Aatt4&trans.darrows
no Aatt5&trans.darrows
no Aatt6&trans.darrows
no Aatt7&trans.darrows
no Aatt8&trans.darrows
no Aatt9&trans.darrows
no Af0&trans.aarrows
no Af1&trans.aarrows
no Af2&trans.aarrows
no Af3&trans.aarrows
no Af4&trans.aarrows
no Af5&trans.aarrows
no Af7&trans.aarrows
no Af8&trans.aarrows
no Af9&trans.aarrows
no Af10&trans.aarrows
no Af11&trans.aarrows
no AresE2&trans.aarrows
no AresE1&trans.aarrows
no Aatt0&trans.aarrows
no Aatt1&trans.aarrows
no Aatt2&trans.aarrows
no Aatt3&trans.aarrows
no Aatt4&trans.aarrows
no Aatt5&trans.aarrows
no Aatt7&trans.aarrows
no Aatt8&trans.aarrows
no Aatt9&trans.aarrows
}

pred rule_r6[trans:Trans]{
some trans.rule&r6

some e_att50:Aatt5&(trans.source.arrows-trans.darrows) |
let n_PB0 = e_att50.src, n_F0 = e_att50.trg |
(n_PB0 in NPB&(trans.source.nodes-trans.dnodes) and n_F0 in F) 
some E&(trans.source.nodes-trans.dnodes)

//Divide
all e_f70:Af7&trans.aarrows, e_count0:Acount&trans.aarrows | e_f70.trg=e_count0.src
all e_att60:Aatt6&trans.aarrows, e_f70:Af7&trans.aarrows | e_att60.src=e_f70.trg 
all e_count0:Acount&trans.aarrows, e_att60:Aatt6&trans.aarrows | e_att60.src=e_count0.src 
all e_count0:Acount&trans.aarrows | e_count0.trg=0
all e_att60:Aatt6&trans.aarrows | e_att60.trg in E
one e_att50:Aatt5&(trans.source.arrows-trans.darrows), e_f70:Af7&trans.aarrows |
let n_PB0 = e_att50.src, n_E20 = e_f70.trg, n_F0 = e_att50.trg |
(n_PB0 = e_f70.src and 
n_E20 in NE2&trans.anodes and
n_PB0 in NPB&(trans.source.nodes-trans.dnodes) and n_F0 in F)

//one e_att50:Aatt5&(trans.source.arrows-trans.darrows), e_f70:Af7&trans.aarrows, e_count0:Acount&trans.aarrows, e_att60:Aatt6&trans.aarrows |
//let n_PB0 = e_att50.src, n_E20 = e_f70.trg, n_I0 = e_count0.trg, n_E0 = e_att60.trg, n_F0 = e_att50.trg |
//(n_PB0 = e_f70.src and n_E20 = e_count0.src and n_E20 = e_att60.src  and
//n_E20 in NE2&trans.anodes and
//n_PB0 in NPB&(trans.source.nodes-trans.dnodes) and n_F0 in F and n_I0=0 and n_E0 in E)

#NE2&trans.anodes = 1
#Acount&trans.aarrows = 1
#Af7&trans.aarrows = 1
#Aatt6&trans.aarrows = 1
no NIE&trans.dnodes
no NBT1&trans.dnodes
no NMRI&trans.dnodes
no NE1&trans.dnodes
no NPA&trans.dnodes
no NPB&trans.dnodes
no NE2&trans.dnodes
no NBT2&trans.dnodes
no NEND&trans.dnodes
no NTD&trans.dnodes
no Int&trans.dnodes
no NState&trans.dnodes
no NIE&trans.anodes
no NBT1&trans.anodes
no NMRI&trans.anodes
no NE1&trans.anodes
no NPA&trans.anodes
no NPB&trans.anodes
no NBT2&trans.anodes
no NEND&trans.anodes
no NTD&trans.anodes
no Int&trans.anodes
no NState&trans.anodes
no Af0&trans.darrows
no Af1&trans.darrows
no Af2&trans.darrows
no Af3&trans.darrows
no Af4&trans.darrows
no Af5&trans.darrows
no Af6&trans.darrows
no Af7&trans.darrows
no Af8&trans.darrows
no Af9&trans.darrows
no Af10&trans.darrows
no Af11&trans.darrows
no AresE2&trans.darrows
no Acount&trans.darrows
no AresE1&trans.darrows
no Aatt0&trans.darrows
no Aatt1&trans.darrows
no Aatt2&trans.darrows
no Aatt3&trans.darrows
no Aatt4&trans.darrows
no Aatt5&trans.darrows
no Aatt6&trans.darrows
no Aatt7&trans.darrows
no Aatt8&trans.darrows
no Aatt9&trans.darrows
no Af0&trans.aarrows
no Af1&trans.aarrows
no Af2&trans.aarrows
no Af3&trans.aarrows
no Af4&trans.aarrows
no Af5&trans.aarrows
no Af6&trans.aarrows
no Af8&trans.aarrows
no Af9&trans.aarrows
no Af10&trans.aarrows
no Af11&trans.aarrows
no AresE2&trans.aarrows
no AresE1&trans.aarrows
no Aatt0&trans.aarrows
no Aatt1&trans.aarrows
no Aatt2&trans.aarrows
no Aatt3&trans.aarrows
no Aatt4&trans.aarrows
no Aatt5&trans.aarrows
no Aatt7&trans.aarrows
no Aatt8&trans.aarrows
no Aatt9&trans.aarrows
}

pred rule_r7[trans:Trans]{
some trans.rule&r7

some e_att60:Aatt6&(trans.source.arrows-trans.darrows), e_resE20:AresE2&(trans.source.arrows-trans.darrows) |
let n_E20 = e_att60.src, n_BT = e_resE20.trg, n_F = e_att60.trg |
(n_E20 = e_resE20.src  and
n_E20 in NE2&(trans.source.nodes-trans.dnodes) and n_F in F and n_BT=1)
some E 

//Divide
all e_f80:Af8&trans.aarrows, e_att90:Aatt9&trans.aarrows | e_f80.trg=e_att90.src 
all e_att90:Aatt9&trans.aarrows | e_att90.trg in E
one e_att60:Aatt6&(trans.source.arrows-trans.darrows), e_f80:Af8&trans.aarrows, e_resE20:AresE2&(trans.source.arrows-trans.darrows) |
let n_E20 = e_att60.src, n_END0 = e_f80.trg, n_BT = e_resE20.trg, n_F = e_att60.trg |
(n_E20 = e_f80.src and n_E20 = e_resE20.src and 
n_END0 in NEND&trans.anodes and
n_E20 in NE2&(trans.source.nodes-trans.dnodes) and n_F in F and n_BT=1) 

//one e_att60:Aatt6&(trans.source.arrows-trans.darrows), e_f80:Af8&trans.aarrows, e_resE20:AresE2&(trans.source.arrows-trans.darrows), e_att90:Aatt9&trans.aarrows |
//let n_E20 = e_att60.src, n_END0 = e_f80.trg, n_E = e_att90.trg, n_BT = e_resE20.trg, n_F = e_att60.trg |
//(n_E20 = e_f80.src and n_E20 = e_resE20.src and n_END0 = e_att90.src  and
//n_END0 in NEND&trans.anodes and
//n_E20 in NE2&(trans.source.nodes-trans.dnodes) and n_F in F and n_BT=1 and n_E in E) 

#NEND&trans.anodes = 1
#Aatt9&trans.aarrows = 1
#Af8&trans.aarrows = 1
no NIE&trans.dnodes
no NBT1&trans.dnodes
no NMRI&trans.dnodes
no NE1&trans.dnodes
no NPA&trans.dnodes
no NPB&trans.dnodes
no NE2&trans.dnodes
no NBT2&trans.dnodes
no NEND&trans.dnodes
no NTD&trans.dnodes
no Int&trans.dnodes
no NState&trans.dnodes
no NIE&trans.anodes
no NBT1&trans.anodes
no NMRI&trans.anodes
no NE1&trans.anodes
no NPA&trans.anodes
no NPB&trans.anodes
no NE2&trans.anodes
no NBT2&trans.anodes
no NTD&trans.anodes
no Int&trans.anodes
no NState&trans.anodes
no Af0&trans.darrows
no Af1&trans.darrows
no Af2&trans.darrows
no Af3&trans.darrows
no Af4&trans.darrows
no Af5&trans.darrows
no Af6&trans.darrows
no Af7&trans.darrows
no Af8&trans.darrows
no Af9&trans.darrows
no Af10&trans.darrows
no Af11&trans.darrows
no AresE2&trans.darrows
no Acount&trans.darrows
no AresE1&trans.darrows
no Aatt0&trans.darrows
no Aatt1&trans.darrows
no Aatt2&trans.darrows
no Aatt3&trans.darrows
no Aatt4&trans.darrows
no Aatt5&trans.darrows
no Aatt6&trans.darrows
no Aatt7&trans.darrows
no Aatt8&trans.darrows
no Aatt9&trans.darrows
no Af0&trans.aarrows
no Af1&trans.aarrows
no Af2&trans.aarrows
no Af3&trans.aarrows
no Af4&trans.aarrows
no Af5&trans.aarrows
no Af6&trans.aarrows
no Af7&trans.aarrows
no Af9&trans.aarrows
no Af10&trans.aarrows
no Af11&trans.aarrows
no AresE2&trans.aarrows
no Acount&trans.aarrows
no AresE1&trans.aarrows
no Aatt0&trans.aarrows
no Aatt1&trans.aarrows
no Aatt2&trans.aarrows
no Aatt3&trans.aarrows
no Aatt4&trans.aarrows
no Aatt5&trans.aarrows
no Aatt6&trans.aarrows
no Aatt7&trans.aarrows
no Aatt8&trans.aarrows
}

pred rule_r8[trans:Trans]{
some trans.rule&r8

one e_resE20:AresE2&(trans.source.arrows-trans.darrows), e_att60:Aatt6&(trans.source.arrows-trans.darrows), e_count0:Acount&trans.darrows |
let n_E20 = e_resE20.src, n_BF = e_resE20.trg, n_F = e_att60.trg, n_I0 = e_count0.trg |
(n_E20 = e_att60.src and n_E20 = e_count0.src  and
n_E20 in NE2&(trans.source.nodes-trans.dnodes) and n_BF=0 and n_F in F and n_I0 in Int)
some E 

//Divide
all e_count0:Acount&trans.darrows, e_count1:Acount&trans.aarrows | e_count0.src=e_count1.src and e_count1.src=e_count0.src+1 
all e_f90:Af9&trans.aarrows, e_count1:Acount&trans.aarrows | e_f90.src=e_count1.src 
all e_f90:Af9&trans.aarrows, e_count0:Acount&trans.aarrows | e_f90.src=e_count0.src 
all e_f90:Af9&trans.aarrows, e_att80:Aatt8&trans.aarrows | e_f90.trg=e_att80.src 
all e_att80:Aatt1&trans.aarrows | e_att80.trg in E
one e_f90:Af9&trans.aarrows, e_resE20:AresE2&(trans.source.arrows-trans.darrows), e_att60:Aatt6&(trans.source.arrows-trans.darrows) |
let n_E20 = e_f90.src, n_BF = e_resE20.trg, n_F = e_att60.trg, n_TD0 = e_f90.trg |
(n_E20 = e_resE20.src and n_E20 = e_att60.src and 
n_TD0 in NTD&trans.anodes and
n_E20 in NE2&(trans.source.nodes-trans.dnodes) and n_BF=0 and n_F in F)

//one e_f90:Af9&trans.aarrows, e_att80:Aatt8&trans.aarrows, e_resE20:AresE2&(trans.source.arrows-trans.darrows), e_att60:Aatt6&(trans.source.arrows-trans.darrows), e_count1:Acount&trans.aarrows |
//let n_E20 = e_f90.src, n_E = e_att80.trg, n_BF = e_resE20.trg, n_F = e_att60.trg, n_TD0 = e_f90.trg, n_I1 = e_count1.trg |
//(n_TD0 = e_att80.src and n_E20 = e_resE20.src and n_E20 = e_att60.src and n_E20 = e_count1.src  and
//n_TD0 in NTD&trans.anodes and
//n_E20 in NE2&(trans.source.nodes-trans.dnodes) and n_E in E and n_BF=0 and n_F in F and n_I1 in Int)

//some left:Acount&trans.darrows,right:Acount&trans.aarrows|left.src=right.src

#NTD&trans.anodes = 1
#Acount&trans.darrows = 1
#Af9&trans.aarrows = 1
#Aatt8&trans.aarrows = 1
#Acount&trans.aarrows = 1
no NIE&trans.dnodes
no NBT1&trans.dnodes
no NMRI&trans.dnodes
no NE1&trans.dnodes
no NPA&trans.dnodes
no NPB&trans.dnodes
no NE2&trans.dnodes
no NBT2&trans.dnodes
no NEND&trans.dnodes
no NTD&trans.dnodes
no Int&trans.dnodes
no NState&trans.dnodes
no NIE&trans.anodes
no NBT1&trans.anodes
no NMRI&trans.anodes
no NE1&trans.anodes
no NPA&trans.anodes
no NPB&trans.anodes
no NE2&trans.anodes
no NBT2&trans.anodes
no NEND&trans.anodes
no Int&trans.anodes
no NState&trans.anodes
no Af0&trans.darrows
no Af1&trans.darrows
no Af2&trans.darrows
no Af3&trans.darrows
no Af4&trans.darrows
no Af5&trans.darrows
no Af6&trans.darrows
no Af7&trans.darrows
no Af8&trans.darrows
no Af9&trans.darrows
no Af10&trans.darrows
no Af11&trans.darrows
no AresE2&trans.darrows
no AresE1&trans.darrows
no Aatt0&trans.darrows
no Aatt1&trans.darrows
no Aatt2&trans.darrows
no Aatt3&trans.darrows
no Aatt4&trans.darrows
no Aatt5&trans.darrows
no Aatt6&trans.darrows
no Aatt7&trans.darrows
no Aatt8&trans.darrows
no Aatt9&trans.darrows
no Af0&trans.aarrows
no Af1&trans.aarrows
no Af2&trans.aarrows
no Af3&trans.aarrows
no Af4&trans.aarrows
no Af5&trans.aarrows
no Af6&trans.aarrows
no Af7&trans.aarrows
no Af8&trans.aarrows
no Af10&trans.aarrows
no Af11&trans.aarrows
no AresE2&trans.aarrows
no AresE1&trans.aarrows
no Aatt0&trans.aarrows
no Aatt1&trans.aarrows
no Aatt2&trans.aarrows
no Aatt3&trans.aarrows
no Aatt4&trans.aarrows
no Aatt5&trans.aarrows
no Aatt6&trans.aarrows
no Aatt7&trans.aarrows
no Aatt9&trans.aarrows
}

pred rule_r9[trans:Trans]{
some trans.rule&r9

some e_att80:Aatt8&(trans.source.arrows-trans.darrows) |
let n_TD0 = e_att80.src, n_F = e_att80.trg |
(n_TD0 in NTD&(trans.source.nodes-trans.dnodes) and n_F in F) 
some E 

//Divide
all e_f100:Af10&trans.aarrows, e_att70:Aatt7&trans.aarrows | e_f100.trg=e_att70.src 
all e_att70:Aatt7&trans.aarrows | e_att70.trg in E
one e_att80:Aatt8&(trans.source.arrows-trans.darrows), e_f100:Af10&trans.aarrows |
let n_TD0 = e_att80.src, n_F = e_att80.trg, n_BT20 = e_f100.trg |
(n_TD0 = e_f100.src and 
n_BT20 in NBT2&trans.anodes and
n_TD0 in NTD&(trans.source.nodes-trans.dnodes) and n_F in F) 

//one e_att80:Aatt8&(trans.source.arrows-trans.darrows), e_f100:Af10&trans.aarrows, e_att70:Aatt7&trans.aarrows |
//let n_TD0 = e_att80.src, n_E = e_att70.trg, n_F = e_att80.trg, n_BT20 = e_f100.trg |
//(n_TD0 = e_f100.src and n_BT20 = e_att70.src  and
//n_BT20 in NBT2&trans.anodes and
//n_TD0 in NTD&(trans.source.nodes-trans.dnodes) and n_F in F and n_E in E) 

#NBT2&trans.anodes = 1
#Af10&trans.aarrows = 1
#Aatt7&trans.aarrows = 1
no NIE&trans.dnodes
no NBT1&trans.dnodes
no NMRI&trans.dnodes
no NE1&trans.dnodes
no NPA&trans.dnodes
no NPB&trans.dnodes
no NE2&trans.dnodes
no NBT2&trans.dnodes
no NEND&trans.dnodes
no NTD&trans.dnodes
no Int&trans.dnodes
no NState&trans.dnodes
no NIE&trans.anodes
no NBT1&trans.anodes
no NMRI&trans.anodes
no NE1&trans.anodes
no NPA&trans.anodes
no NPB&trans.anodes
no NE2&trans.anodes
no NEND&trans.anodes
no NTD&trans.anodes
no Int&trans.anodes
no NState&trans.anodes
no Af0&trans.darrows
no Af1&trans.darrows
no Af2&trans.darrows
no Af3&trans.darrows
no Af4&trans.darrows
no Af5&trans.darrows
no Af6&trans.darrows
no Af7&trans.darrows
no Af8&trans.darrows
no Af9&trans.darrows
no Af10&trans.darrows
no Af11&trans.darrows
no AresE2&trans.darrows
no Acount&trans.darrows
no AresE1&trans.darrows
no Aatt0&trans.darrows
no Aatt1&trans.darrows
no Aatt2&trans.darrows
no Aatt3&trans.darrows
no Aatt4&trans.darrows
no Aatt5&trans.darrows
no Aatt6&trans.darrows
no Aatt7&trans.darrows
no Aatt8&trans.darrows
no Aatt9&trans.darrows
no Af0&trans.aarrows
no Af1&trans.aarrows
no Af2&trans.aarrows
no Af3&trans.aarrows
no Af4&trans.aarrows
no Af5&trans.aarrows
no Af6&trans.aarrows
no Af7&trans.aarrows
no Af8&trans.aarrows
no Af9&trans.aarrows
no Af11&trans.aarrows
no AresE2&trans.aarrows
no Acount&trans.aarrows
no AresE1&trans.aarrows
no Aatt0&trans.aarrows
no Aatt1&trans.aarrows
no Aatt2&trans.aarrows
no Aatt3&trans.aarrows
no Aatt4&trans.aarrows
no Aatt5&trans.aarrows
no Aatt6&trans.aarrows
no Aatt8&trans.aarrows
no Aatt9&trans.aarrows
}

pred rule_r10[trans:Trans]{
some trans.rule&r10

one e_att70:Aatt7&(trans.source.arrows-trans.darrows), e_att60:Aatt6&trans.darrows |
let n_BT20 = e_att70.src, n_E20 = e_att60.src, n_F = e_att70.trg |
(n_F = e_att60.trg  and
n_BT20 in NBT2&(trans.source.nodes-trans.dnodes) and n_F in F and n_E20 in NE2&(trans.source.nodes-trans.dnodes))
some E 

//Divide
all e_f110:Af11&trans.aarrows, e_att61:Aatt6&trans.aarrows | e_f110.trg=e_att61.src 
all e_f110:Af11&trans.aarrows, e_att60:Aatt6&trans.darrows | e_f110.trg=e_att60.src 
all e_att60:Aatt6&trans.darrows, e_att61:Aatt6&trans.aarrows | e_att60.src=e_att61.src 
all e_att61:Aatt6&trans.aarrows | e_att61.trg in E
one e_att70:Aatt7&(trans.source.arrows-trans.darrows), e_f110:Af11&trans.aarrows |
let n_BT20 = e_att70.src, n_F = e_att70.trg, n_E20 = e_f110.trg |
(n_BT20 = e_f110.src and 
n_BT20 in NBT2&(trans.source.nodes-trans.dnodes) and n_F in F and n_E20 in NE2&(trans.source.nodes-trans.dnodes)) 
//one e_att70:Aatt7&(trans.source.arrows-trans.darrows), e_f110:Af11&trans.aarrows, e_att61:Aatt6&trans.aarrows |
//let n_BT20 = e_att70.src, n_F = e_att70.trg, n_E20 = e_f110.trg, n_E = e_att61.trg |
//(n_BT20 = e_f110.src and n_E20 = e_att61.src  and
//n_BT20 in NBT2&(trans.source.nodes-trans.dnodes) and n_F in F and n_E20 in NE2&(trans.source.nodes-trans.dnodes) and n_E in E) 

//some left:Aatt6&trans.darrows,right:Aatt6&trans.aarrows|left.src=right.src

#Aatt6&trans.darrows = 1
#Af11&trans.aarrows = 1
#Aatt6&trans.aarrows = 1
no NIE&trans.dnodes
no NBT1&trans.dnodes
no NMRI&trans.dnodes
no NE1&trans.dnodes
no NPA&trans.dnodes
no NPB&trans.dnodes
no NE2&trans.dnodes
no NBT2&trans.dnodes
no NEND&trans.dnodes
no NTD&trans.dnodes
no Int&trans.dnodes
no NState&trans.dnodes
no NIE&trans.anodes
no NBT1&trans.anodes
no NMRI&trans.anodes
no NE1&trans.anodes
no NPA&trans.anodes
no NPB&trans.anodes
no NE2&trans.anodes
no NBT2&trans.anodes
no NEND&trans.anodes
no NTD&trans.anodes
no Int&trans.anodes
no NState&trans.anodes
no Af0&trans.darrows
no Af1&trans.darrows
no Af2&trans.darrows
no Af3&trans.darrows
no Af4&trans.darrows
no Af5&trans.darrows
no Af6&trans.darrows
no Af7&trans.darrows
no Af8&trans.darrows
no Af9&trans.darrows
no Af10&trans.darrows
no Af11&trans.darrows
no AresE2&trans.darrows
no Acount&trans.darrows
no AresE1&trans.darrows
no Aatt0&trans.darrows
no Aatt1&trans.darrows
no Aatt2&trans.darrows
no Aatt3&trans.darrows
no Aatt4&trans.darrows
no Aatt5&trans.darrows
no Aatt7&trans.darrows
no Aatt8&trans.darrows
no Aatt9&trans.darrows
no Af0&trans.aarrows
no Af1&trans.aarrows
no Af2&trans.aarrows
no Af3&trans.aarrows
no Af4&trans.aarrows
no Af5&trans.aarrows
no Af6&trans.aarrows
no Af7&trans.aarrows
no Af8&trans.aarrows
no Af9&trans.aarrows
no Af10&trans.aarrows
no AresE2&trans.aarrows
no Acount&trans.aarrows
no AresE1&trans.aarrows
no Aatt0&trans.aarrows
no Aatt1&trans.aarrows
no Aatt2&trans.aarrows
no Aatt3&trans.aarrows
no Aatt4&trans.aarrows
no Aatt5&trans.aarrows
no Aatt7&trans.aarrows
no Aatt8&trans.aarrows
no Aatt9&trans.aarrows
}

pred rule_r11[trans:Trans]{
some trans.rule&r11

one e_att70:Aatt7&(trans.source.arrows-trans.darrows), e_f110:Af11&(trans.source.arrows-trans.darrows), e_att60:Aatt6&(trans.source.arrows-trans.darrows), e_count1:Acount&trans.darrows |
let n_BT20 = e_att70.src, n_F = e_att70.trg, n_E20 = e_f110.trg, n_Int0 = e_count1.trg |
(n_BT20 = e_f110.src and n_E20 = e_att60.src and n_F = e_att60.trg and n_E20 = e_count1.src  and
n_BT20 in NBT2&(trans.source.nodes-trans.dnodes) and n_F in F and n_E20 in NE2&(trans.source.nodes-trans.dnodes) and n_Int0 in Int)

//Divide
all e_count1:Acount&trans.darrows, e_count0:Acount&trans.aarrows | e_count1.src=e_count0.src and e_count1.src=e_count0.src+1 
one e_att70:Aatt7&(trans.source.arrows-trans.darrows), e_f110:Af11&(trans.source.arrows-trans.darrows), e_att60:Aatt6&(trans.source.arrows-trans.darrows), e_count0:Acount&trans.aarrows |
let n_BT20 = e_att70.src, n_F = e_att70.trg, n_E20 = e_f110.trg, n_Int1 = e_count0.trg |
(n_BT20 = e_f110.src and n_E20 = e_att60.src and n_F = e_att60.trg and n_E20 = e_count0.src  and
n_BT20 in NBT2&(trans.source.nodes-trans.dnodes) and n_F in F and n_E20 in NE2&(trans.source.nodes-trans.dnodes) and n_Int1 in Int)
//one e_att70:Aatt7&(trans.source.arrows-trans.darrows), e_f110:Af11&(trans.source.arrows-trans.darrows), e_att60:Aatt6&(trans.source.arrows-trans.darrows), e_count0:Acount&trans.aarrows |
//let n_BT20 = e_att70.src, n_F = e_att70.trg, n_E20 = e_f110.trg, n_Int1 = e_count0.trg |
//(n_BT20 = e_f110.src and n_E20 = e_att60.src and n_F = e_att60.trg and n_E20 = e_count0.src  and
//n_BT20 in NBT2&(trans.source.nodes-trans.dnodes) and n_F in F and n_E20 in NE2&(trans.source.nodes-trans.dnodes) and n_Int1 in Int)

all left:Acount&trans.darrows,right:Acount&trans.aarrows|left.src=right.src

#Acount&trans.darrows = 1
#Acount&trans.aarrows = 1
no NIE&trans.dnodes
no NBT1&trans.dnodes
no NMRI&trans.dnodes
no NE1&trans.dnodes
no NPA&trans.dnodes
no NPB&trans.dnodes
no NE2&trans.dnodes
no NBT2&trans.dnodes
no NEND&trans.dnodes
no NTD&trans.dnodes
no Int&trans.dnodes
no NState&trans.dnodes
no NIE&trans.anodes
no NBT1&trans.anodes
no NMRI&trans.anodes
no NE1&trans.anodes
no NPA&trans.anodes
no NPB&trans.anodes
no NE2&trans.anodes
no NBT2&trans.anodes
no NEND&trans.anodes
no NTD&trans.anodes
no Int&trans.anodes
no NState&trans.anodes
no Af0&trans.darrows
no Af1&trans.darrows
no Af2&trans.darrows
no Af3&trans.darrows
no Af4&trans.darrows
no Af5&trans.darrows
no Af6&trans.darrows
no Af7&trans.darrows
no Af8&trans.darrows
no Af9&trans.darrows
no Af10&trans.darrows
no Af11&trans.darrows
no AresE2&trans.darrows
no AresE1&trans.darrows
no Aatt0&trans.darrows
no Aatt1&trans.darrows
no Aatt2&trans.darrows
no Aatt3&trans.darrows
no Aatt4&trans.darrows
no Aatt5&trans.darrows
no Aatt6&trans.darrows
no Aatt7&trans.darrows
no Aatt8&trans.darrows
no Aatt9&trans.darrows
no Af0&trans.aarrows
no Af1&trans.aarrows
no Af2&trans.aarrows
no Af3&trans.aarrows
no Af4&trans.aarrows
no Af5&trans.aarrows
no Af6&trans.aarrows
no Af7&trans.aarrows
no Af8&trans.aarrows
no Af9&trans.aarrows
no Af10&trans.aarrows
no Af11&trans.aarrows
no AresE2&trans.aarrows
no AresE1&trans.aarrows
no Aatt0&trans.aarrows
no Aatt1&trans.aarrows
no Aatt2&trans.aarrows
no Aatt3&trans.aarrows
no Aatt4&trans.aarrows
no Aatt5&trans.aarrows
no Aatt6&trans.aarrows
no Aatt7&trans.aarrows
no Aatt8&trans.aarrows
no Aatt9&trans.aarrows
}

pred rule_r81[trans:Trans]{
some trans.rule&r81

one e_count0:Acount&trans.darrows, e_resE20:AresE2&(trans.source.arrows-trans.darrows), e_att60:Aatt6&(trans.source.arrows-trans.darrows), e_f90:Af9&(trans.source.arrows-trans.darrows), e_att80:Aatt8&trans.darrows |
let n_E20 = e_count0.src, n_F = e_att60.trg, n_BF = e_resE20.trg, n_Int0 = e_count0.trg, n_TD0 = e_f90.trg |
(n_E20 = e_resE20.src and n_E20 = e_att60.src and n_E20 = e_f90.src and n_TD0 = e_att80.src  and e_att80.trg = n_F and
n_E20 in NE2&(trans.source.nodes-trans.dnodes) and n_Int0 in Int and n_BF=0 and n_F in F and n_TD0 in NTD&(trans.source.nodes-trans.dnodes)) 
some E 

one e_count1:Acount&trans.aarrows, e_resE20:AresE2&(trans.source.arrows-trans.darrows), e_att60:Aatt6&(trans.source.arrows-trans.darrows), e_f90:Af9&(trans.source.arrows-trans.darrows), e_att81:Aatt8&trans.aarrows |
let n_E20 = e_count1.src, n_Int1 = e_count1.trg, n_F = e_att60.trg, n_BF = e_resE20.trg, n_TD0 = e_f90.trg, n_E = e_att81.trg |
(n_E20 = e_resE20.src and n_E20 = e_att60.src and n_E20 = e_f90.src and n_TD0 = e_att81.src  and
n_E20 in NE2&(trans.source.nodes-trans.dnodes) and n_Int1 in Int and n_BF=0 and n_F in F and n_TD0 in NTD&(trans.source.nodes-trans.dnodes) and n_E in E) 
some F 

all left:Acount&trans.darrows,right:Acount&trans.aarrows|left.src=right.src and right.trg=left.trg+1
all left:Aatt8&trans.darrows,right:Aatt8&trans.aarrows|left.src=right.src

#Acount&trans.darrows = 1
#Aatt8&trans.darrows = 1
#Acount&trans.aarrows = 1
#Aatt8&trans.aarrows = 1
no NIE&trans.dnodes
no NBT1&trans.dnodes
no NMRI&trans.dnodes
no NE1&trans.dnodes
no NPA&trans.dnodes
no NPB&trans.dnodes
no NE2&trans.dnodes
no NBT2&trans.dnodes
no NEND&trans.dnodes
no NTD&trans.dnodes
no Int&trans.dnodes
no NState&trans.dnodes
no NIE&trans.anodes
no NBT1&trans.anodes
no NMRI&trans.anodes
no NE1&trans.anodes
no NPA&trans.anodes
no NPB&trans.anodes
no NE2&trans.anodes
no NBT2&trans.anodes
no NEND&trans.anodes
no NTD&trans.anodes
no Int&trans.anodes
no NState&trans.anodes
no Af0&trans.darrows
no Af1&trans.darrows
no Af2&trans.darrows
no Af3&trans.darrows
no Af4&trans.darrows
no Af5&trans.darrows
no Af6&trans.darrows
no Af7&trans.darrows
no Af8&trans.darrows
no Af9&trans.darrows
no Af10&trans.darrows
no Af11&trans.darrows
no AresE2&trans.darrows
no AresE1&trans.darrows
no Aatt0&trans.darrows
no Aatt1&trans.darrows
no Aatt2&trans.darrows
no Aatt3&trans.darrows
no Aatt4&trans.darrows
no Aatt5&trans.darrows
no Aatt6&trans.darrows
no Aatt7&trans.darrows
no Aatt9&trans.darrows
no Af0&trans.aarrows
no Af1&trans.aarrows
no Af2&trans.aarrows
no Af3&trans.aarrows
no Af4&trans.aarrows
no Af5&trans.aarrows
no Af6&trans.aarrows
no Af7&trans.aarrows
no Af8&trans.aarrows
no Af9&trans.aarrows
no Af10&trans.aarrows
no Af11&trans.aarrows
no AresE2&trans.aarrows
no AresE1&trans.aarrows
no Aatt0&trans.aarrows
no Aatt1&trans.aarrows
no Aatt2&trans.aarrows
no Aatt3&trans.aarrows
no Aatt4&trans.aarrows
no Aatt5&trans.aarrows
no Aatt6&trans.aarrows
no Aatt7&trans.aarrows
no Aatt9&trans.aarrows
}

pred rule_r91[trans:Trans]{
some trans.rule&r91

one e_att80:Aatt8&(trans.source.arrows-trans.darrows), e_f100:Af10&(trans.source.arrows-trans.darrows), e_att71:Aatt7&trans.darrows |
let n_TD0 = e_att80.src, n_F = e_att71.trg, n_BT20 = e_f100.trg |
(n_TD0 = e_f100.src and n_BT20 = e_att71.src  and e_att80.trg = n_F and
n_TD0 in NTD&(trans.source.nodes-trans.dnodes) and n_F in F and n_BT20 in NBT2&(trans.source.nodes-trans.dnodes)) 
some E 

one e_att80:Aatt8&(trans.source.arrows-trans.darrows), e_f100:Af10&(trans.source.arrows-trans.darrows), e_att70:Aatt7&trans.aarrows |
let n_TD0 = e_att80.src, n_E = e_att70.trg, n_F = e_att80.trg, n_BT20 = e_f100.trg |
(n_TD0 = e_f100.src and n_BT20 = e_att70.src  and
n_TD0 in NTD&(trans.source.nodes-trans.dnodes) and n_F in F and n_BT20 in NBT2&(trans.source.nodes-trans.dnodes) and n_E in E) 

all left:Aatt7&trans.darrows, right:Aatt7&trans.aarrows | left.src=right.src
all right:Aatt7&trans.aarrows | right.trg in E

#Aatt7&trans.darrows = 1
#Aatt7&trans.aarrows = 1
no NIE&trans.dnodes
no NBT1&trans.dnodes
no NMRI&trans.dnodes
no NE1&trans.dnodes
no NPA&trans.dnodes
no NPB&trans.dnodes
no NE2&trans.dnodes
no NBT2&trans.dnodes
no NEND&trans.dnodes
no NTD&trans.dnodes
no Int&trans.dnodes
no NState&trans.dnodes
no NIE&trans.anodes
no NBT1&trans.anodes
no NMRI&trans.anodes
no NE1&trans.anodes
no NPA&trans.anodes
no NPB&trans.anodes
no NE2&trans.anodes
no NBT2&trans.anodes
no NEND&trans.anodes
no NTD&trans.anodes
no Int&trans.anodes
no NState&trans.anodes
no Af0&trans.darrows
no Af1&trans.darrows
no Af2&trans.darrows
no Af3&trans.darrows
no Af4&trans.darrows
no Af5&trans.darrows
no Af6&trans.darrows
no Af7&trans.darrows
no Af8&trans.darrows
no Af9&trans.darrows
no Af10&trans.darrows
no Af11&trans.darrows
no AresE2&trans.darrows
no Acount&trans.darrows
no AresE1&trans.darrows
no Aatt0&trans.darrows
no Aatt1&trans.darrows
no Aatt2&trans.darrows
no Aatt3&trans.darrows
no Aatt4&trans.darrows
no Aatt5&trans.darrows
no Aatt6&trans.darrows
no Aatt8&trans.darrows
no Aatt9&trans.darrows
no Af0&trans.aarrows
no Af1&trans.aarrows
no Af2&trans.aarrows
no Af3&trans.aarrows
no Af4&trans.aarrows
no Af5&trans.aarrows
no Af6&trans.aarrows
no Af7&trans.aarrows
no Af8&trans.aarrows
no Af9&trans.aarrows
no Af10&trans.aarrows
no Af11&trans.aarrows
no AresE2&trans.aarrows
no Acount&trans.aarrows
no AresE1&trans.aarrows
no Aatt0&trans.aarrows
no Aatt1&trans.aarrows
no Aatt2&trans.aarrows
no Aatt3&trans.aarrows
no Aatt4&trans.aarrows
no Aatt5&trans.aarrows
no Aatt6&trans.aarrows
no Aatt8&trans.aarrows
no Aatt9&trans.aarrows
}

pred rule_r101[trans:Trans]{
some trans.rule&r101

one e_att70:Aatt7&(trans.source.arrows-trans.darrows), e_f110:Af11&(trans.source.arrows-trans.darrows), e_att61:Aatt6&trans.darrows |
let n_BT20 = e_att70.src, n_E20 = e_f110.trg, n_F = e_att70.trg |
(n_BT20 = e_f110.src and n_E20 = e_att61.src and n_F = e_att61.trg  and
n_BT20 in NBT2&(trans.source.nodes-trans.dnodes) and n_F in F and n_E20 in NE2&(trans.source.nodes-trans.dnodes))
some E 

one e_att70:Aatt7&(trans.source.arrows-trans.darrows), e_f110:Af11&(trans.source.arrows-trans.darrows), e_att61:Aatt6&trans.aarrows |
let n_BT20 = e_att70.src, n_E20 = e_f110.trg, n_F = e_att70.trg, n_E = e_att61.trg |
(n_BT20 = e_f110.src and n_E20 = e_att61.src  and
n_BT20 in NBT2&(trans.source.nodes-trans.dnodes) and n_F in F and n_E20 in NE2&(trans.source.nodes-trans.dnodes) and n_E in E) 

all left:Aatt6&trans.darrows,right:Aatt6&trans.aarrows|left.src=right.src
all right:Aatt6&trans.aarrows | right.trg in E

#Aatt6&trans.darrows = 1
#Aatt6&trans.aarrows = 1
no NIE&trans.dnodes
no NBT1&trans.dnodes
no NMRI&trans.dnodes
no NE1&trans.dnodes
no NPA&trans.dnodes
no NPB&trans.dnodes
no NE2&trans.dnodes
no NBT2&trans.dnodes
no NEND&trans.dnodes
no NTD&trans.dnodes
no Int&trans.dnodes
no NState&trans.dnodes
no NIE&trans.anodes
no NBT1&trans.anodes
no NMRI&trans.anodes
no NE1&trans.anodes
no NPA&trans.anodes
no NPB&trans.anodes
no NE2&trans.anodes
no NBT2&trans.anodes
no NEND&trans.anodes
no NTD&trans.anodes
no Int&trans.anodes
no NState&trans.anodes
no Af0&trans.darrows
no Af1&trans.darrows
no Af2&trans.darrows
no Af3&trans.darrows
no Af4&trans.darrows
no Af5&trans.darrows
no Af6&trans.darrows
no Af7&trans.darrows
no Af8&trans.darrows
no Af9&trans.darrows
no Af10&trans.darrows
no Af11&trans.darrows
no AresE2&trans.darrows
no Acount&trans.darrows
no AresE1&trans.darrows
no Aatt0&trans.darrows
no Aatt1&trans.darrows
no Aatt2&trans.darrows
no Aatt3&trans.darrows
no Aatt4&trans.darrows
no Aatt5&trans.darrows
no Aatt7&trans.darrows
no Aatt8&trans.darrows
no Aatt9&trans.darrows
no Af0&trans.aarrows
no Af1&trans.aarrows
no Af2&trans.aarrows
no Af3&trans.aarrows
no Af4&trans.aarrows
no Af5&trans.aarrows
no Af6&trans.aarrows
no Af7&trans.aarrows
no Af8&trans.aarrows
no Af9&trans.aarrows
no Af10&trans.aarrows
no Af11&trans.aarrows
no AresE2&trans.aarrows
no Acount&trans.aarrows
no AresE1&trans.aarrows
no Aatt0&trans.aarrows
no Aatt1&trans.aarrows
no Aatt2&trans.aarrows
no Aatt3&trans.aarrows
no Aatt4&trans.aarrows
no Aatt5&trans.aarrows
no Aatt7&trans.aarrows
no Aatt8&trans.aarrows
no Aatt9&trans.aarrows
}

pred rule_r102[trans:Trans]{
some trans.rule&r102

one e_att70:Aatt7&(trans.source.arrows-trans.darrows), e_f110:Af11&(trans.source.arrows-trans.darrows), e_att61:Aatt6&trans.darrows, e_resE21:AresE2&trans.darrows |
let n_BT20 = e_att70.src, n_F = e_att70.trg, n_B1 = e_resE21.trg, n_E20 = e_f110.trg |
(n_BT20 = e_f110.src and n_E20 = e_att61.src and n_F = e_att61.trg and n_E20 = e_resE21.src  and
n_BT20 in NBT2&(trans.source.nodes-trans.dnodes) and n_F in F and n_E20 in NE2&(trans.source.nodes-trans.dnodes) and n_B1 in Int)
some E 

one e_att70:Aatt7&(trans.source.arrows-trans.darrows), e_f110:Af11&(trans.source.arrows-trans.darrows), e_att60:Aatt6&trans.aarrows, e_resE20:AresE2&trans.aarrows |
let n_BT20 = e_att70.src, n_E = e_att60.trg, n_F = e_att70.trg, n_B2 = e_resE20.trg, n_E20 = e_f110.trg |
(n_BT20 = e_f110.src and n_E20 = e_att60.src and n_E20 = e_resE20.src  and
n_BT20 in NBT2&(trans.source.nodes-trans.dnodes) and n_F in F and n_E20 in NE2&(trans.source.nodes-trans.dnodes) and n_E in E and n_B2 in Int)

all left:Aatt6&trans.darrows,right:Aatt6&trans.aarrows|left.src=right.src
all e_resE20:AresE2&trans.aarrows, e_resE21:AresE2&trans.darrows | e_resE20.src=e_resE21.src and e_resE20.src=1-e_resE21.src
all e_att61:Aatt6&trans.darrows, e_resE21:AresE2&trans.darrows | e_att61.src=e_resE21.src

#AresE2&trans.darrows = 1
#Aatt6&trans.darrows = 1
#AresE2&trans.aarrows = 1
#Aatt6&trans.aarrows = 1
no NIE&trans.dnodes
no NBT1&trans.dnodes
no NMRI&trans.dnodes
no NE1&trans.dnodes
no NPA&trans.dnodes
no NPB&trans.dnodes
no NE2&trans.dnodes
no NBT2&trans.dnodes
no NEND&trans.dnodes
no NTD&trans.dnodes
no Int&trans.dnodes
no NState&trans.dnodes
no NIE&trans.anodes
no NBT1&trans.anodes
no NMRI&trans.anodes
no NE1&trans.anodes
no NPA&trans.anodes
no NPB&trans.anodes
no NE2&trans.anodes
no NBT2&trans.anodes
no NEND&trans.anodes
no NTD&trans.anodes
no Int&trans.anodes
no NState&trans.anodes
no Af0&trans.darrows
no Af1&trans.darrows
no Af2&trans.darrows
no Af3&trans.darrows
no Af4&trans.darrows
no Af5&trans.darrows
no Af6&trans.darrows
no Af7&trans.darrows
no Af8&trans.darrows
no Af9&trans.darrows
no Af10&trans.darrows
no Af11&trans.darrows
no Acount&trans.darrows
no AresE1&trans.darrows
no Aatt0&trans.darrows
no Aatt1&trans.darrows
no Aatt2&trans.darrows
no Aatt3&trans.darrows
no Aatt4&trans.darrows
no Aatt5&trans.darrows
no Aatt7&trans.darrows
no Aatt8&trans.darrows
no Aatt9&trans.darrows
no Af0&trans.aarrows
no Af1&trans.aarrows
no Af2&trans.aarrows
no Af3&trans.aarrows
no Af4&trans.aarrows
no Af5&trans.aarrows
no Af6&trans.aarrows
no Af7&trans.aarrows
no Af8&trans.aarrows
no Af9&trans.aarrows
no Af10&trans.aarrows
no Af11&trans.aarrows
no Acount&trans.aarrows
no AresE1&trans.aarrows
no Aatt0&trans.aarrows
no Aatt1&trans.aarrows
no Aatt2&trans.aarrows
no Aatt3&trans.aarrows
no Aatt4&trans.aarrows
no Aatt5&trans.aarrows
no Aatt7&trans.aarrows
no Aatt8&trans.aarrows
no Aatt9&trans.aarrows
}

pred rule_r103[trans:Trans]{
some trans.rule&r103

one e_att60:Aatt6&trans.darrows, e_resE20:AresE2&trans.darrows, e_att70:Aatt7&(trans.source.arrows-trans.darrows) |
let n_E20 = e_att60.src, n_BT20 = e_att70.src, n_B0 = e_resE20.trg, n_F = e_att60.trg |
(n_E20 = e_resE20.src and n_F = e_att70.trg  and
n_E20 in NE2&(trans.source.nodes-trans.dnodes) and n_F in F and n_B0 in Int and n_BT20 in NBT2&(trans.source.nodes-trans.dnodes))
some E 

one e_f110:Af11&trans.aarrows, e_att61:Aatt6&trans.aarrows, e_resE21:AresE2&trans.aarrows, e_att70:Aatt7&(trans.source.arrows-trans.darrows) |
let n_BT20 = e_f110.src, n_E20 = e_f110.trg, n_E = e_att61.trg, n_B1 = e_resE21.trg, n_F = e_att70.trg |
(n_E20 = e_att61.src and n_E20 = e_resE21.src and n_BT20 = e_att70.src  and
n_E20 in NE2&(trans.source.nodes-trans.dnodes) and n_BT20 in NBT2&(trans.source.nodes-trans.dnodes) and n_E in E and n_B1 in Int and n_F in F) 

some left:Aatt6&trans.darrows,right:Aatt6&trans.aarrows|left.src=right.src

#AresE2&trans.darrows = 1
#Aatt6&trans.darrows = 1
#Af11&trans.aarrows = 1
#AresE2&trans.aarrows = 1
#Aatt6&trans.aarrows = 1
no NIE&trans.dnodes
no NBT1&trans.dnodes
no NMRI&trans.dnodes
no NE1&trans.dnodes
no NPA&trans.dnodes
no NPB&trans.dnodes
no NE2&trans.dnodes
no NBT2&trans.dnodes
no NEND&trans.dnodes
no NTD&trans.dnodes
no Int&trans.dnodes
no NState&trans.dnodes
no NIE&trans.anodes
no NBT1&trans.anodes
no NMRI&trans.anodes
no NE1&trans.anodes
no NPA&trans.anodes
no NPB&trans.anodes
no NE2&trans.anodes
no NBT2&trans.anodes
no NEND&trans.anodes
no NTD&trans.anodes
no Int&trans.anodes
no NState&trans.anodes
no Af0&trans.darrows
no Af1&trans.darrows
no Af2&trans.darrows
no Af3&trans.darrows
no Af4&trans.darrows
no Af5&trans.darrows
no Af6&trans.darrows
no Af7&trans.darrows
no Af8&trans.darrows
no Af9&trans.darrows
no Af10&trans.darrows
no Af11&trans.darrows
no Acount&trans.darrows
no AresE1&trans.darrows
no Aatt0&trans.darrows
no Aatt1&trans.darrows
no Aatt2&trans.darrows
no Aatt3&trans.darrows
no Aatt4&trans.darrows
no Aatt5&trans.darrows
no Aatt7&trans.darrows
no Aatt8&trans.darrows
no Aatt9&trans.darrows
no Af0&trans.aarrows
no Af1&trans.aarrows
no Af2&trans.aarrows
no Af3&trans.aarrows
no Af4&trans.aarrows
no Af5&trans.aarrows
no Af6&trans.aarrows
no Af7&trans.aarrows
no Af8&trans.aarrows
no Af9&trans.aarrows
no Af10&trans.aarrows
no Acount&trans.aarrows
no AresE1&trans.aarrows
no Aatt0&trans.aarrows
no Aatt1&trans.aarrows
no Aatt2&trans.aarrows
no Aatt3&trans.aarrows
no Aatt4&trans.aarrows
no Aatt5&trans.aarrows
no Aatt7&trans.aarrows
no Aatt8&trans.aarrows
no Aatt9&trans.aarrows
}

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
//mulitplicity on f0:IE->BT1[0,1]
all n:(NIE&trans.source.nodes)| lone e:(Af0&trans.source.arrows)|e.src=n
//mulitplicity on f1:IE->MRI[0,1]
all n:(NIE&trans.source.nodes)| lone e:(Af1&trans.source.arrows)|e.src=n
//mulitplicity on f2:BT1->E1[0,1]
all n:(NBT1&trans.source.nodes)| lone e:(Af2&trans.source.arrows)|e.src=n
//mulitplicity on f3:MRI->E1[0,1]
all n:(NMRI&trans.source.nodes)| lone e:(Af3&trans.source.arrows)|e.src=n
//mulitplicity on f4:E1->PA[0,1]
all n:(NE1&trans.source.nodes)| lone e:(Af4&trans.source.arrows)|e.src=n
//mulitplicity on f5:E1->PB[0,1]
all n:(NE1&trans.source.nodes)| lone e:(Af5&trans.source.arrows)|e.src=n
//mulitplicity on f6:PA->E2[0,1]
all n:(NPA&trans.source.nodes)| lone e:(Af6&trans.source.arrows)|e.src=n
//mulitplicity on f7:PB->E2[0,1]
all n:(NPB&trans.source.nodes)| lone e:(Af7&trans.source.arrows)|e.src=n
//mulitplicity on f8:E2->END[0,1]
all n:(NE2&trans.source.nodes)| lone e:(Af8&trans.source.arrows)|e.src=n
//mulitplicity on f9:E2->TD[0,1]
all n:(NE2&trans.source.nodes)| lone e:(Af9&trans.source.arrows)|e.src=n
//mulitplicity on f10:TD->BT2[0,1]
all n:(NTD&trans.source.nodes)| lone e:(Af10&trans.source.arrows)|e.src=n
//mulitplicity on f11:BT2->E2[0,1]
all n:(NBT2&trans.source.nodes)| lone e:(Af11&trans.source.arrows)|e.src=n
//mulitplicity on resE2:E2->Bool[0,1]
all n:(NE2&trans.source.nodes)| lone e:(AresE2&trans.source.arrows)|e.src=n
//mulitplicity on count:E2->Int[0,1]
all n:(NE2&trans.source.nodes)| lone e:(Acount&trans.source.arrows)|e.src=n
//mulitplicity on resE1:E1->Bool[0,1]
all n:(NE1&trans.source.nodes)| lone e:(AresE1&trans.source.arrows)|e.src=n
//mulitplicity on att0:IE->State[0,1]
all n:(NIE&trans.source.nodes)| lone e:(Aatt0&trans.source.arrows)|e.src=n
//mulitplicity on att1:MRI->State[0,1]
all n:(NMRI&trans.source.nodes)| lone e:(Aatt1&trans.source.arrows)|e.src=n
//mulitplicity on att2:BT1->State[0,1]
all n:(NBT1&trans.source.nodes)| lone e:(Aatt2&trans.source.arrows)|e.src=n
//mulitplicity on att3:E1->State[0,1]
all n:(NE1&trans.source.nodes)| lone e:(Aatt3&trans.source.arrows)|e.src=n
//mulitplicity on att4:PA->State[0,1]
all n:(NPA&trans.source.nodes)| lone e:(Aatt4&trans.source.arrows)|e.src=n
//mulitplicity on att5:PB->State[0,1]
all n:(NPB&trans.source.nodes)| lone e:(Aatt5&trans.source.arrows)|e.src=n
//mulitplicity on att6:E2->State[0,1]
all n:(NE2&trans.source.nodes)| lone e:(Aatt6&trans.source.arrows)|e.src=n
//mulitplicity on att7:BT2->State[0,1]
all n:(NBT2&trans.source.nodes)| lone e:(Aatt7&trans.source.arrows)|e.src=n
//mulitplicity on att8:TD->State[0,1]
all n:(NTD&trans.source.nodes)| lone e:(Aatt8&trans.source.arrows)|e.src=n
//mulitplicity on att9:END->State[0,1]
all n:(NEND&trans.source.nodes)| lone e:(Aatt9&trans.source.arrows)|e.src=n
}
run{}
