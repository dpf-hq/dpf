<?xml version="1.0" encoding="ASCII"?>
<xmi:XMI xmi:version="2.0" xmlns:xmi="http://www.omg.org/XMI" xmlns:core="http://no.hib.dpf.core" xmlns:diagram="http://no.hib.dpf.diagram">
  <diagram:DSignature signature="/1">
    <dPredicates predicate="/1/@predicates.0">
      <dGraph graph="/1/@predicates.0/@shape">
        <dNodes node="/1/@predicates.0/@shape/@nodes.0" dOutgoings="/0/@dPredicates.0/@dGraph/@dArrows.0" dIncomings="/0/@dPredicates.0/@dGraph/@dArrows.1" location="50 50" size="100 30"/>
        <dNodes node="/1/@predicates.0/@shape/@nodes.1" dOutgoings="/0/@dPredicates.0/@dGraph/@dArrows.1" dIncomings="/0/@dPredicates.0/@dGraph/@dArrows.0" location="200 50" size="100 30"/>
        <dArrows arrow="/1/@predicates.0/@shape/@arrows.0" dSource="/0/@dPredicates.0/@dGraph/@dNodes.0" dTarget="/0/@dPredicates.0/@dGraph/@dNodes.1">
          <nameOffset offset="56 -43" len="150"/>
        </dArrows>
        <dArrows arrow="/1/@predicates.0/@shape/@arrows.1" dSource="/0/@dPredicates.0/@dGraph/@dNodes.1" dTarget="/0/@dPredicates.0/@dGraph/@dNodes.0">
          <nameOffset offset="-80 42" len="-150"/>
        </dArrows>
      </dGraph>
      <visualization type="ArrowToArrow" source="/1/@predicates.0/@shape/@arrows.0" target="/1/@predicates.0/@shape/@arrows.1"/>
    </dPredicates>
    <dPredicates predicate="/1/@predicates.1" icon="enum_32.png">
      <dGraph graph="/1/@predicates.1/@shape">
        <dNodes node="/1/@predicates.1/@shape/@nodes.0" location="50 50" size="100 30"/>
      </dGraph>
      <visualization type="OnNode"/>
    </dPredicates>
  </diagram:DSignature>
  <core:Signature>
    <predicates symbol="inv">
      <shape id="feecbf0a-3b37-4be0-8a75-8a7f99da00b1">
        <nodes id="233f7e58-efe0-4354-8ef5-11e38a1c171f" name="X" outgoings="/1/@predicates.0/@shape/@arrows.0" incomings="/1/@predicates.0/@shape/@arrows.1"/>
        <nodes id="94e28bab-5d65-43f3-a664-73b44e453135" name="Y" outgoings="/1/@predicates.0/@shape/@arrows.1" incomings="/1/@predicates.0/@shape/@arrows.0"/>
        <arrows id="b1a8fd70-fccc-4415-b73f-36e639334aed" name="XY" source="/1/@predicates.0/@shape/@nodes.0" target="/1/@predicates.0/@shape/@nodes.1"/>
        <arrows id="84a5cc5f-46b8-4e6b-a546-9cabf9f439e4" name="YX" source="/1/@predicates.0/@shape/@nodes.1" target="/1/@predicates.0/@shape/@nodes.0"/>
      </shape>
      <validator type="ALLOY" validator="all x:$X$, y:$Y$| (some xy:$XY$| xy.src=x and xy.trg=y) &lt;=>  (some yx:$YX$| yx.src=y and yx.trg=x) "/>
    </predicates>
    <predicates symbol="enum" parameters="literal:{}">
      <shape id="5af402e1-88bf-45d3-9943-0a5306f7b069">
        <nodes id="6e1a9e42-fcc2-47d6-beeb-02bb305ba9ef" name="X"/>
      </shape>
      <validator type="ALLOY" validator=""/>
    </predicates>
  </core:Signature>
</xmi:XMI>
