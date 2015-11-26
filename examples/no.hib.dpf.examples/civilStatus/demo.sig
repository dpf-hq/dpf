<?xml version="1.0" encoding="ASCII"?>
<xmi:XMI xmi:version="2.0" xmlns:xmi="http://www.omg.org/XMI" xmlns:core="http://no.hib.dpf.core" xmlns:diagram="http://no.hib.dpf.diagram">
  <diagram:DSignature signature="/1">
    <dPredicates predicate="/1/@predicates.0">
      <dGraph graph="/1/@predicates.0/@shape">
        <dNodes node="/1/@predicates.0/@shape/@nodes.0" dOutgoings="/0/@dPredicates.0/@dGraph/@dArrows.0 /0/@dPredicates.0/@dGraph/@dArrows.1" location="79 61" size="100 30"/>
        <dNodes node="/1/@predicates.0/@shape/@nodes.1" dOutgoings="/0/@dPredicates.0/@dGraph/@dArrows.2" dIncomings="/0/@dPredicates.0/@dGraph/@dArrows.0" location="283 58" size="100 30"/>
        <dNodes node="/1/@predicates.0/@shape/@nodes.2" dIncomings="/0/@dPredicates.0/@dGraph/@dArrows.1 /0/@dPredicates.0/@dGraph/@dArrows.2" location="84 165" size="100 30"/>
        <dArrows arrow="/1/@predicates.0/@shape/@arrows.0" dSource="/0/@dPredicates.0/@dGraph/@dNodes.0" dTarget="/0/@dPredicates.0/@dGraph/@dNodes.1">
          <nameOffset offset="10 -3" len="16"/>
        </dArrows>
        <dArrows arrow="/1/@predicates.0/@shape/@arrows.1" dSource="/0/@dPredicates.0/@dGraph/@dNodes.0" dTarget="/0/@dPredicates.0/@dGraph/@dNodes.2">
          <nameOffset offset="10 -3" len="16"/>
        </dArrows>
        <dArrows arrow="/1/@predicates.0/@shape/@arrows.2" dSource="/0/@dPredicates.0/@dGraph/@dNodes.1" dTarget="/0/@dPredicates.0/@dGraph/@dNodes.2">
          <nameOffset offset="-103 16" len="-226"/>
        </dArrows>
      </dGraph>
      <visualization type="Composed"/>
    </dPredicates>
  </diagram:DSignature>
  <core:Signature>
    <predicates symbol="comp">
      <shape id="ac77ca2b-851d-4d54-a3f1-49101ebbd160">
        <nodes id="ff2aa5f6-3a9b-4ba4-8788-8afad15d0fc0" name="X" outgoings="/1/@predicates.0/@shape/@arrows.0 /1/@predicates.0/@shape/@arrows.1"/>
        <nodes id="0e2b9246-09a0-4893-93b7-a806235f7a0d" name="Y" outgoings="/1/@predicates.0/@shape/@arrows.2" incomings="/1/@predicates.0/@shape/@arrows.0"/>
        <nodes id="abcc53f9-eb5e-454d-8f38-c9db8c5a9e42" name="Z" incomings="/1/@predicates.0/@shape/@arrows.1 /1/@predicates.0/@shape/@arrows.2"/>
        <arrows id="642cd71a-4617-4bfb-8cee-f8bebc1067b7" name="XY" source="/1/@predicates.0/@shape/@nodes.0" target="/1/@predicates.0/@shape/@nodes.1"/>
        <arrows id="9cdf3651-fbee-4aed-85d8-42c8ebf93e62" name="XZ" source="/1/@predicates.0/@shape/@nodes.0" target="/1/@predicates.0/@shape/@nodes.2"/>
        <arrows id="367d6d80-4f64-43e2-9c82-750257358c48" name="YZ" source="/1/@predicates.0/@shape/@nodes.1" target="/1/@predicates.0/@shape/@nodes.2"/>
      </shape>
      <validator type="JAVA" validator="import java.util.ArrayList;&#xA;import java.util.HashMap;&#xA;import java.util.List;&#xA;import java.util.Map;&#xA;&#xA;import no.hib.dpf.core.Arrow;&#xA;import no.hib.dpf.core.Graph;&#xA;import no.hib.dpf.core.Node;&#xA;import no.hib.dpf.utils.Checker;&#xA;public class CheckInstance implements Checker{&#xA;&#x9;@Override&#xA;&#x9;public boolean check(Map&lt;String, String> paras, Graph graph, Map&lt;Node, List&lt;Node>> nodeMap,&#xA;&#x9;&#x9;&#x9;Map&lt;Arrow, List&lt;Arrow>> arrowMap) {&#xA;&#x9;&#x9;List&lt;Arrow> xys = arrowMap.get(graph.getArrowByName(&quot;XY&quot;));&#xA;&#x9;&#x9;List&lt;Arrow> yzs = arrowMap.get(graph.getArrowByName(&quot;YZ&quot;));&#xA;&#x9;&#x9;List&lt;Arrow> xzs = arrowMap.get(graph.getArrowByName(&quot;XZ&quot;));&#xA;&#x9;&#x9;Map&lt;Node, List&lt;Node>> xtoz = new HashMap&lt;Node, List&lt;Node>>();&#xA;&#x9;&#x9;if(xys != null)&#xA;&#x9;&#x9;for(Arrow xy : xys){&#xA;&#x9;&#x9;&#x9;if(yzs != null)&#xA;&#x9;&#x9;&#x9;for(Arrow yz : yzs){&#xA;&#x9;&#x9;&#x9;&#x9;if(xy.getTarget() == yz.getSource())&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;addToMapList(xy.getSource(), yz.getTarget(), xtoz);&#xA;&#x9;&#x9;&#x9;}&#xA;&#x9;&#x9;}&#xA;&#x9;&#x9;if(xzs != null)&#xA;&#x9;&#x9;for(Arrow xz : xzs){&#xA;&#x9;&#x9;&#x9;List&lt;Node> nodes = xtoz.get(xz.getSource());&#xA;&#x9;&#x9;&#x9;if(nodes != null &amp;&amp; nodes.contains(xz.getTarget())){&#xA;&#x9;&#x9;&#x9;&#x9;nodes.remove(xz.getTarget());&#xA;&#x9;&#x9;&#x9;&#x9;if(nodes.isEmpty())&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;xtoz.remove(xz.getSource());&#xA;&#x9;&#x9;&#x9;}&#xA;&#x9;&#x9;}&#x9;&#x9;&#xA;&#x9;&#x9;return xtoz.isEmpty();&#xA;&#x9;}&#xA;&#x9;public &lt;T, U> void addToMapList(T key, U value, Map&lt;T, List&lt;U>> map){&#xA;&#x9;&#x9;List&lt;U> tos = map.get(key);&#xA;&#x9;&#x9;if(tos == null){&#xA;&#x9;&#x9;&#x9;tos = new ArrayList&lt;U>();&#xA;&#x9;&#x9;&#x9;tos.add(value);&#xA;&#x9;&#x9;&#x9;map.put(key, tos);&#xA;&#x9;&#x9;&#x9;return;&#xA;&#x9;&#x9;}&#xA;&#x9;&#x9;if(!tos.contains(value))&#xA;&#x9;&#x9;&#x9;tos.add(value);&#xA;&#x9;}&#xA;}"/>
    </predicates>
  </core:Signature>
</xmi:XMI>
