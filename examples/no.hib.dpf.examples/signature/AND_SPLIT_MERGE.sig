<?xml version="1.0" encoding="ASCII"?>
<xmi:XMI xmi:version="2.0" xmlns:xmi="http://www.omg.org/XMI" xmlns:core="http://no.hib.dpf.core" xmlns:diagram="http://no.hib.dpf.diagram">
  <diagram:DSignature signature="/1">
    <dPredicates predicate="/1/@predicates.0">
      <dGraph graph="/1/@predicates.0/@shape">
        <dNodes node="/1/@predicates.0/@shape/@nodes.0" dOutgoings="/0/@dPredicates.0/@dGraph/@dArrows.0 /0/@dPredicates.0/@dGraph/@dArrows.1" location="59 102" size="100 30"/>
        <dNodes node="/1/@predicates.0/@shape/@nodes.1" dIncomings="/0/@dPredicates.0/@dGraph/@dArrows.0" location="312 103" size="100 30"/>
        <dNodes node="/1/@predicates.0/@shape/@nodes.2" dIncomings="/0/@dPredicates.0/@dGraph/@dArrows.1" location="315 283" size="100 30"/>
        <dArrows arrow="/1/@predicates.0/@shape/@arrows.0" dSource="/0/@dPredicates.0/@dGraph/@dNodes.0" dTarget="/0/@dPredicates.0/@dGraph/@dNodes.1">
          <nameOffset offset="111 -38" len="253"/>
        </dArrows>
        <dArrows arrow="/1/@predicates.0/@shape/@arrows.1" dSource="/0/@dPredicates.0/@dGraph/@dNodes.0" dTarget="/0/@dPredicates.0/@dGraph/@dNodes.2">
          <nameOffset offset="150 -22" len="313"/>
        </dArrows>
      </dGraph>
      <visualization type="ArrowToArrow" source="/1/@predicates.0/@shape/@arrows.0" target="/1/@predicates.0/@shape/@arrows.1"/>
    </dPredicates>
    <dPredicates predicate="/1/@predicates.1">
      <dGraph graph="/1/@predicates.1/@shape">
        <dNodes node="/1/@predicates.1/@shape/@nodes.0" dOutgoings="/0/@dPredicates.1/@dGraph/@dArrows.0" location="32 49" size="100 30"/>
        <dNodes node="/1/@predicates.1/@shape/@nodes.1" dOutgoings="/0/@dPredicates.1/@dGraph/@dArrows.1" location="32 133" size="100 30"/>
        <dNodes node="/1/@predicates.1/@shape/@nodes.2" dIncomings="/0/@dPredicates.1/@dGraph/@dArrows.0 /0/@dPredicates.1/@dGraph/@dArrows.1" location="212 51" size="100 30"/>
        <dArrows arrow="/1/@predicates.1/@shape/@arrows.0" dSource="/0/@dPredicates.1/@dGraph/@dNodes.0" dTarget="/0/@dPredicates.1/@dGraph/@dNodes.2">
          <nameOffset offset="10 -3" len="16"/>
        </dArrows>
        <dArrows arrow="/1/@predicates.1/@shape/@arrows.1" dSource="/0/@dPredicates.1/@dGraph/@dNodes.1" dTarget="/0/@dPredicates.1/@dGraph/@dNodes.2">
          <nameOffset offset="118 4" len="197"/>
        </dArrows>
      </dGraph>
      <visualization type="ArrowToArrow" source="/1/@predicates.1/@shape/@arrows.0" target="/1/@predicates.1/@shape/@arrows.1"/>
    </dPredicates>
  </diagram:DSignature>
  <core:Signature>
    <predicates symbol="AND_SPLIT" parameters="">
      <shape id="b5d9fdd8-72ce-4803-859a-8cb66665ed00">
        <nodes id="0ce7581b-b5ea-462e-8a99-4de33b39d3bb" name="X" outgoings="/1/@predicates.0/@shape/@arrows.0 /1/@predicates.0/@shape/@arrows.1"/>
        <nodes id="e28f90ea-fc68-4eae-a0e1-d9df2753a4ac" name="Y" incomings="/1/@predicates.0/@shape/@arrows.0"/>
        <nodes id="67446e9f-9c72-4791-80c2-9514fba3e724" name="Z" incomings="/1/@predicates.0/@shape/@arrows.1"/>
        <arrows id="9d6acce1-9732-42bb-932f-75b919118d71" name="XY" source="/1/@predicates.0/@shape/@nodes.0" target="/1/@predicates.0/@shape/@nodes.1"/>
        <arrows id="7a67ab3a-c19a-421f-87c8-eb46aef011ff" name="XZ" source="/1/@predicates.0/@shape/@nodes.0" target="/1/@predicates.0/@shape/@nodes.2"/>
      </shape>
      <validator type="JAVA" validator="import java.util.*; &#xA;&#xA;import no.hib.dpf.core.Arrow; &#xA;import no.hib.dpf.core.Graph; &#xA;import no.hib.dpf.core.Node; &#xA;import no.hib.dpf.utils.Checker; &#xA;public class CheckInstance implements Checker { &#xA;&#x9;public boolean check(Map&lt;String, String> maps, Graph shape, Map&lt;Node, List&lt;Node>> nodeMap, Map&lt;Arrow, List&lt;Arrow>> arrowMap) { &#xA;&#xA;&#x9;&#x9;List&lt;Node> x = new ArrayList&lt;Node>();&#xA;&#x9;&#x9;List&lt;Node> maped = nodeMap.get(shape.getNodeByName(&quot;X&quot;));&#xA;&#x9;&#x9;if(maped != null)&#xA;&#x9;&#x9;&#x9;x.addAll(maped);&#xA;&#x9;&#x9;List&lt;Arrow> xy = arrowMap.get(shape.getArrowByName(&quot;XY&quot;)), xz = arrowMap.get(shape.getArrowByName(&quot;XZ&quot;));&#xA;&#x9;&#x9;List&lt;Node> x1 = new ArrayList&lt;Node>();&#xA;&#x9;&#x9;if(xy != null){&#xA;&#x9;&#x9;&#x9;for(Arrow arrow : xy){&#xA;&#x9;&#x9;&#x9;&#x9;Node from = arrow.getSource();&#xA;&#x9;&#x9;&#x9;&#x9;if(x.contains(from)){&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;x.remove(from);&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;x1.add(from);&#xA;&#x9;&#x9;&#x9;&#x9;}&#xA;&#x9;&#x9;&#x9;}&#xA;&#x9;&#x9;}&#xA;&#x9;&#x9;List&lt;Node> x2 = new ArrayList&lt;Node>();&#xA;&#x9;&#x9;if(xz != null){&#xA;&#x9;&#x9;&#x9;for(Arrow arrow : xz){&#xA;&#x9;&#x9;&#x9;&#x9;Node from = arrow.getSource();&#xA;&#x9;&#x9;&#x9;&#x9;if(x1.contains(from))&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;x1.remove(from);&#xA;&#x9;&#x9;&#x9;&#x9;else if(x.contains(from)){&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;x.remove(from);&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;x2.add(from);&#xA;&#x9;&#x9;&#x9;&#x9;}&#xA;&#x9;&#x9;&#x9;}&#xA;&#x9;&#x9;}&#xA;&#x9;&#x9;for(Node node : x)&#xA;&#x9;&#x9;&#x9;System.out.println(node.getName() + &quot; violates AND_SPLIT constraint.\n It misses Y and Z&quot;);&#xA;&#x9;&#x9;&#x9;&#x9;for(Node node : x1)&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;System.out.println(node.getName() + &quot; violates AND_SPLIT constraint.\n It misses Z&quot;);&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;for(Node node : x2)&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;System.out.println(node.getName() + &quot; violates AND_SPLIT constraint.\n It misses Y&quot;);&#xA;&#x9;&#x9;System.out.println(x.size() == 0 &amp;&amp; x1.size() == 0 &amp;&amp; x2.size() == 0);&#xA;&#x9;&#x9;return x.size() == 0 &amp;&amp; x1.size()== 0 &amp;&amp; x2.size() == 0; &#xA;&#x9;} &#xA;}"/>
    </predicates>
    <predicates symbol="AND_MERGE">
      <shape id="2e328111-2e64-4041-aa39-7907d0745475">
        <nodes id="d958be45-d643-43c8-83d5-21088b6704eb" name="X" outgoings="/1/@predicates.1/@shape/@arrows.0"/>
        <nodes id="6e6f3a36-6196-4b47-bc0c-dd09651bbb2a" name="Z" outgoings="/1/@predicates.1/@shape/@arrows.1"/>
        <nodes id="8a46fba3-84b2-4c5a-81cf-050cf0230799" name="Y" incomings="/1/@predicates.1/@shape/@arrows.0 /1/@predicates.1/@shape/@arrows.1"/>
        <arrows id="f7979db6-5dc9-4651-90b6-898f286dd128" name="XY" source="/1/@predicates.1/@shape/@nodes.0" target="/1/@predicates.1/@shape/@nodes.2"/>
        <arrows id="570cc8ec-1c1b-4eeb-b423-f0334923fc8a" name="ZY" source="/1/@predicates.1/@shape/@nodes.1" target="/1/@predicates.1/@shape/@nodes.2"/>
      </shape>
      <validator type="JAVA" validator="import java.util.*; &#xA;&#xA;import no.hib.dpf.core.Arrow; &#xA;import no.hib.dpf.core.Graph; &#xA;import no.hib.dpf.core.Node; &#xA;import no.hib.dpf.utils.Checker; &#xA;public class CheckInstance implements Checker { &#xA;&#x9;public boolean check(Map&lt;String, String> maps, Graph shape, Map&lt;Node, List&lt;Node>> nodeMap, Map&lt;Arrow, List&lt;Arrow>> arrowMap) { &#xA;&#xA;&#x9;&#x9;List&lt;Node> y = new ArrayList&lt;Node>();&#xA;&#x9;&#x9;List&lt;Node> maped = nodeMap.get(shape.getNodeByName(&quot;Y&quot;));&#xA;&#x9;&#x9;if(maped != null)&#xA;&#x9;&#x9;&#x9;y.addAll(maped);&#xA;&#x9;&#x9;List&lt;Arrow> xy = arrowMap.get(shape.getArrowByName(&quot;XY&quot;)), zy = arrowMap.get(shape.getArrowByName(&quot;ZY&quot;));&#xA;&#x9;&#x9;List&lt;Node> y1 = new ArrayList&lt;Node>();&#xA;&#x9;&#x9;if(xy != null){&#xA;&#x9;&#x9;&#x9;for(Arrow arrow : xy){&#xA;&#x9;&#x9;&#x9;&#x9;Node from = arrow.getTarget();&#xA;&#x9;&#x9;&#x9;&#x9;if(y.contains(from)){&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;y.remove(from);&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;y1.add(from);&#xA;&#x9;&#x9;&#x9;&#x9;}&#xA;&#x9;&#x9;&#x9;}&#xA;&#x9;&#x9;}&#xA;&#x9;&#x9;List&lt;Node> y2 = new ArrayList&lt;Node>();&#xA;&#x9;&#x9;if(zy != null){&#xA;&#x9;&#x9;&#x9;for(Arrow arrow : zy){&#xA;&#x9;&#x9;&#x9;&#x9;Node from = arrow.getTarget();&#xA;&#x9;&#x9;&#x9;&#x9;if(y1.contains(from))&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;y1.remove(from);&#xA;&#x9;&#x9;&#x9;&#x9;else if(y.contains(from)){&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;y.remove(from);&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;y2.add(from);&#xA;&#x9;&#x9;&#x9;&#x9;}&#xA;&#x9;&#x9;&#x9;}&#xA;&#x9;&#x9;}&#xA;&#x9;&#x9;for(Node node : y)&#xA;&#x9;&#x9;&#x9;System.out.println(node.getName() + &quot; violates AND_MERGE constraint.\n It misses X and Z&quot;);&#xA;&#x9;&#x9;&#x9;&#x9;for(Node node : y1)&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;System.out.println(node.getName() + &quot; violates AND_MERGE constraint.\n It misses Z&quot;);&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;for(Node node : y2)&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;System.out.println(node.getName() + &quot; violates AND_MERGE constraint.\n It misses X&quot;);&#xA;&#x9;&#x9;&#xA;&#x9;&#x9;return y.size() == 0 &amp;&amp;  y1.size() == 0 &amp;&amp;  y2.size() == 0; &#xA;&#x9;} &#xA;}"/>
    </predicates>
  </core:Signature>
</xmi:XMI>
