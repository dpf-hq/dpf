<?xml version="1.0" encoding="UTF-8"?>
<no.hib.dpf.core:Signature xmlns:no.hib.dpf.core="http://no.hib.dpf.core">
  <predicates parameters="" symbol="surjective" icon="icons/surj_36.png">
    <shape id="dacc4224-482c-463d-a34b-a190cf7812c8" name="Default name">
      <nodes id="82bcfefb-6e73-42aa-9b0f-4c4f01fdc931" name="X">
        <typeNode href="platform:/resource/DefaultGraph.xmi#//@nodes.0"/>
      </nodes>
      <nodes id="29920cc8-692d-43d3-b040-cd63c515a9f4" name="Y">
        <typeNode href="platform:/resource/DefaultGraph.xmi#//@nodes.0"/>
      </nodes>
      <arrows id="47de76a1-9baf-460f-9f12-eaa6f2c31a75" target="//@predicates.0/@shape/@nodes.1" source="//@predicates.0/@shape/@nodes.0" name="XY">
        <typeArrow href="platform:/resource/DefaultGraph.xmi#//@arrows.0"/>
      </arrows>
    </shape>
    <semanticsValidator type="JAVA" validator="import java.util.*; &#xA;&#xA;import no.hib.dpf.core.Arrow; &#xA;import no.hib.dpf.core.Graph; &#xA;import no.hib.dpf.core.Node; &#xA;import no.hib.dpf.core.impl.Checker; &#xA;public class CheckInstance implements Checker { &#xA;&#x9;public boolean check(Map&lt;String, String> maps, Graph shape, Map&lt;Node, List&lt;Node>> nodeMap, Map&lt;Arrow, List&lt;Arrow>> arrowMap) { &#xA;&#x9;&#x9;&#xA;&#x9;&#x9;List&lt;Node> yNodes = nodeMap.get(shape.getNodeByName(&quot;Y&quot;)); &#xA;&#x9;&#x9;List&lt;Arrow> arrows = arrowMap.get(shape.getArrows().get(0)); &#xA;&#x9;&#x9;List&lt;Node> visitedY = new ArrayList&lt;Node>(); &#xA;&#x9;&#x9;if(arrows != null){&#xA;&#x9;&#x9;&#x9;for(Arrow arrow : arrows){&#xA;&#x9;&#x9;&#x9;&#x9;if (!visitedY.contains(arrow.getTarget())) &#xA;&#x9;&#x9;&#x9;&#x9;&#x9;visitedY.add(arrow.getTarget()); &#xA;&#x9;&#x9;&#x9;&#x9;&#xA;&#x9;&#x9;&#x9;}&#xA;&#x9;&#x9;}&#x9;&#x9;&#xA;&#x9;&#x9;if (yNodes != null &amp;&amp; visitedY.size() != yNodes.size()){&#xA;&#x9;&#x9;&#x9;for(Node node : yNodes){&#xA;&#x9;&#x9;&#x9;&#x9;if(!visitedY.contains(node))&#xA;&#x9;&#x9;&#x9;&#x9;System.out.println(&quot;Node &quot; + node.getName() + &quot; Violated Surjective Constraint&quot;);&#xA;&#x9;&#x9;&#x9;}&#xA;&#x9;&#x9;&#x9;return false; &#xA;&#x9;&#x9;} &#xA;&#x9;&#x9;return true; &#xA;&#x9;} &#xA;}"/>
    <visualization source="//@predicates.0/@shape/@arrows.0"/>
  </predicates>
  <predicates symbol="xor" icon="icons/xor_36.png">
    <shape id="c488643f-04c5-44e8-890f-3a477135e069" name="Default name">
      <nodes id="99aa5228-3469-4f33-987e-cf896091e15e" name="X">
        <typeNode href="platform:/resource/DefaultGraph.xmi#//@nodes.0"/>
      </nodes>
      <nodes id="66c57265-d4e1-4ed5-8619-ecf4d5f5cbb8" name="Y">
        <typeNode href="platform:/resource/DefaultGraph.xmi#//@nodes.0"/>
      </nodes>
      <nodes id="58d77213-d5d4-4e21-83c8-774f66f736f0" name="Z">
        <typeNode href="platform:/resource/DefaultGraph.xmi#//@nodes.0"/>
      </nodes>
      <arrows id="003e2146-28ab-45dc-b0c2-0bb8835850b4" target="//@predicates.1/@shape/@nodes.0" source="//@predicates.1/@shape/@nodes.2" name="ZX">
        <typeArrow href="platform:/resource/DefaultGraph.xmi#//@arrows.0"/>
      </arrows>
      <arrows id="277d6696-3dc9-44f2-a957-c8eb30eace35" target="//@predicates.1/@shape/@nodes.1" source="//@predicates.1/@shape/@nodes.2" name="ZY">
        <typeArrow href="platform:/resource/DefaultGraph.xmi#//@arrows.0"/>
      </arrows>
    </shape>
    <semanticsValidator type="JAVA" validator="import java.util.*; &#xA;import java.util.Map.Entry;&#xA;&#xA;import no.hib.dpf.core.Arrow; &#xA;import no.hib.dpf.core.Graph; &#xA;import no.hib.dpf.core.Node; &#xA;import no.hib.dpf.core.impl.Checker; &#xA;public class CheckInstance implements Checker { &#xA;&#x9;public boolean check(Map&lt;String, String> maps, Graph shape, Map&lt;Node, List&lt;Node>> nodeMap, Map&lt;Arrow, List&lt;Arrow>> arrowMap) { &#xA;&#x9;&#x9;Map&lt;Node, List&lt;Arrow>> targetWithX = new HashMap&lt;Node, List&lt;Arrow>>();&#xA;&#x9;&#x9;Map&lt;Node, List&lt;Arrow>> violated = new HashMap&lt;Node, List&lt;Arrow>>();&#xA;&#x9;&#x9;List&lt;Node> visitedZ = new ArrayList&lt;Node>();&#xA;&#x9;&#x9;List&lt;Arrow> zx = arrowMap.get(shape.getArrowByName(&quot;ZX&quot;));&#xA;&#x9;&#x9;if(zx != null){ for(Arrow arrow : zx){&#xA;&#x9;&#x9;&#x9;&#x9;Node source = arrow.getSource();&#xA;&#x9;&#x9;&#x9;&#x9;if(!visitedZ.contains(source)) visitedZ.add(source);&#xA;&#x9;&#x9;&#x9;&#x9;List&lt;Arrow> value = targetWithX.containsKey(source) ? targetWithX.get(source) : new ArrayList&lt;Arrow>();&#xA;&#x9;&#x9;&#x9;&#x9;value.add(arrow); targetWithX.put(source, value);&#xA;&#x9;&#x9;&#x9;}&#xA;&#x9;&#x9;}&#xA;&#x9;&#x9;List&lt;Arrow> zy = arrowMap.get(shape.getArrowByName(&quot;ZY&quot;));&#xA;&#x9;&#x9;if(zy != null){&#xA;&#x9;&#x9;&#x9;for(Arrow arrow : zy){&#xA;&#x9;&#x9;&#x9;&#x9;Node source = arrow.getSource();&#xA;&#x9;&#x9;&#x9;&#x9;if(!visitedZ.contains(source)) visitedZ.add(source);&#xA;&#x9;&#x9;&#x9;&#x9;if(targetWithX.containsKey(source)){&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;List&lt;Arrow> value = violated.containsKey(source) ? violated.get(source) : new ArrayList&lt;Arrow>();&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;if(value.isEmpty()) value.addAll(targetWithX.get(source));&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;value.add(arrow); violated.put(source, value);&#xA;&#x9;&#x9;&#x9;&#x9;}&#xA;&#x9;&#x9;&#x9;}&#xA;&#x9;&#x9;}&#xA;&#x9;&#x9;List&lt;Node> zNodes = nodeMap.get(shape.getNodeByName(&quot;Z&quot;));&#xA;&#x9;&#x9;if(zNodes != null){&#xA;&#x9;&#x9;&#x9;for(Node node : zNodes)&#xA;&#x9;&#x9;&#x9;&#x9;if(!visitedZ.contains(node)) violated.put(node, null);&#xA;&#x9;&#x9;}&#xA;&#x9;&#x9;if(violated.size() == 0) return true;&#xA;&#x9;&#x9;for(Entry&lt;Node, List&lt;Arrow>> entry : violated.entrySet()){&#xA;&#x9;&#x9;&#x9;System.out.println(entry.getKey().getName() + &quot; violates XOR constraint&quot;);&#xA;&#x9;&#x9;&#x9;if(entry.getValue() == null){&#xA;&#x9;&#x9;&#x9;&#x9;System.out.println(&quot;It has no outgoing arrows which has type homophomism to ZX or ZY&quot;);&#xA;&#x9;&#x9;&#x9;}else{&#xA;&#x9;&#x9;&#x9;&#x9;System.out.println(&quot;It has multiply typed outgoing arrows:&quot;);&#xA;&#x9;&#x9;&#x9;&#x9;for(Arrow arrow : entry.getValue())&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;System.out.println(arrow.getSource().getName() + &quot;-->&quot; + arrow.getTarget().getName());&#xA;&#x9;&#x9;&#x9;}&#xA;&#x9;&#x9;}&#xA;&#x9;&#x9;return false; &#xA;&#x9;} &#xA;}&#xA;"/>
    <visualization type="ArrowToArrow" source="//@predicates.1/@shape/@arrows.0" target="//@predicates.1/@shape/@arrows.0"/>
  </predicates>
  <predicates symbol="injective" icon="icons/inj_36.png">
    <shape id="064fa707-f68e-4561-891a-1c45d6d3baa2" name="Default name">
      <nodes id="e0dcee4a-c92b-4167-b45b-9bf20b2a484e" name="X">
        <typeNode href="platform:/resource/DefaultGraph.xmi#//@nodes.0"/>
      </nodes>
      <nodes id="7cd0947e-b0ed-42ac-9d4f-d35d91f19e55" name="Y">
        <typeNode href="platform:/resource/DefaultGraph.xmi#//@nodes.0"/>
      </nodes>
      <arrows id="f8158664-dc28-4b85-859a-c6fce0c2155e" target="//@predicates.2/@shape/@nodes.1" source="//@predicates.2/@shape/@nodes.0" name="XY">
        <typeArrow href="platform:/resource/DefaultGraph.xmi#//@arrows.0"/>
      </arrows>
    </shape>
    <semanticsValidator type="JAVA" validator="import java.util.*; &#xA;import java.util.Map.Entry;&#xA;&#xA;import no.hib.dpf.core.Arrow; &#xA;import no.hib.dpf.core.Graph; &#xA;import no.hib.dpf.core.Node; &#xA;import no.hib.dpf.core.impl.Checker; &#xA;public class CheckInstance implements Checker { &#xA;&#x9;public boolean check(Map&lt;String, String> maps, Graph shape, Map&lt;Node, List&lt;Node>> nodeMap, Map&lt;Arrow, List&lt;Arrow>> arrowMap) { &#xA;&#xA;&#x9;&#x9;List&lt;Arrow> arrows = arrowMap.get(shape.getArrowByName(&quot;XY&quot;)); &#xA;&#x9;&#x9;Map&lt;Node, List&lt;Arrow>> violated = new HashMap&lt;Node, List&lt;Arrow>>();&#xA;&#x9;&#x9;if(arrows != null){&#xA;&#x9;&#x9;&#x9;for(Arrow arrow : arrows){&#xA;&#x9;&#x9;&#x9;&#x9;Node target = arrow.getTarget();&#xA;&#x9;&#x9;&#x9;&#x9;List&lt;Arrow> value = violated.containsKey(target) ? violated.get(target) : new ArrayList&lt;Arrow>();&#xA;&#x9;&#x9;&#x9;&#x9;value.add(arrow);&#xA;&#x9;&#x9;&#x9;&#x9;violated.put(target, value);&#xA;&#x9;&#x9;&#x9;}&#xA;&#x9;&#x9;}&#xA;&#x9;&#x9;boolean result = true;&#xA;&#x9;&#x9;for(Entry&lt;Node, List&lt;Arrow>> entry : violated.entrySet())&#xA;&#x9;&#x9;&#x9;if(entry.getValue().size() > 1){&#xA;&#x9;&#x9;&#x9;&#x9;result = false;&#xA;&#x9;&#x9;&#x9;&#x9;System.out.println(entry.getKey().getName() + &quot; violates INJECTIVE constraint&quot;);&#xA;&#x9;&#x9;&#x9;&#x9;System.out.println(&quot;It has multiply incoming arrows:&quot;);&#xA;&#x9;&#x9;&#x9;&#x9;for(Arrow arrow : entry.getValue())&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;System.out.println(arrow.getSource().getName() + &quot;-->&quot; + arrow.getTarget().getName());&#xA;&#x9;&#x9;&#x9;}&#xA;&#x9;&#x9;return result; &#xA;&#x9;} &#xA;}"/>
    <visualization source="//@predicates.2/@shape/@arrows.0"/>
  </predicates>
  <predicates symbol="nand" icon="icons/nand_36.png">
    <shape id="1072633c-c8da-4aaf-ae62-fc7a317c1b69" name="Default name">
      <nodes id="2c7e5932-1c05-4cb3-a875-90825c7289bc" name="X">
        <typeNode href="platform:/resource/DefaultGraph.xmi#//@nodes.0"/>
      </nodes>
      <nodes id="aa062792-e8f6-4d2e-877e-9cfac577e64b" name="Y">
        <typeNode href="platform:/resource/DefaultGraph.xmi#//@nodes.0"/>
      </nodes>
      <nodes id="a89b103f-e77a-44b2-bbc6-6d8e2cc30da9" name="Z">
        <typeNode href="platform:/resource/DefaultGraph.xmi#//@nodes.0"/>
      </nodes>
      <arrows id="ab9c42a5-bdc9-441f-a6b4-338d5787754b" target="//@predicates.3/@shape/@nodes.0" source="//@predicates.3/@shape/@nodes.2" name="ZX">
        <typeArrow href="platform:/resource/DefaultGraph.xmi#//@arrows.0"/>
      </arrows>
      <arrows id="01954b28-8748-400e-813f-e20d4f6f3e8f" target="//@predicates.3/@shape/@nodes.1" source="//@predicates.3/@shape/@nodes.2" name="ZY">
        <typeArrow href="platform:/resource/DefaultGraph.xmi#//@arrows.0"/>
      </arrows>
    </shape>
    <semanticsValidator type="JAVA" validator="import java.util.*; &#xA;import java.util.Map.Entry;&#xA;import no.hib.dpf.core.Arrow; &#xA;import no.hib.dpf.core.Graph; &#xA;import no.hib.dpf.core.Node; &#xA;import no.hib.dpf.core.impl.Checker; &#xA;public class CheckInstance implements Checker { &#xA;&#x9;public boolean check(Map&lt;String, String> maps, Graph shape, Map&lt;Node, List&lt;Node>> nodeMap, Map&lt;Arrow, List&lt;Arrow>> arrowMap) { &#xA;&#x9;&#x9;Map&lt;Node, List&lt;Arrow>> targetWithX = new HashMap&lt;Node, List&lt;Arrow>>();&#xA;&#x9;&#x9;Map&lt;Node, List&lt;Arrow>> violated = new HashMap&lt;Node, List&lt;Arrow>>();&#xA;&#x9;&#x9;List&lt;Arrow> zx = arrowMap.get(shape.getArrowByName(&quot;ZX&quot;));&#xA;&#x9;&#x9;if(zx != null){&#xA;&#x9;&#x9;&#x9;for(Arrow arrow : zx){&#xA;&#x9;&#x9;&#x9;&#x9;Node source = arrow.getSource();&#xA;&#x9;&#x9;&#x9;&#x9;List&lt;Arrow> value = targetWithX.containsKey(source) ? targetWithX.get(source) : new ArrayList&lt;Arrow>();&#xA;&#x9;&#x9;&#x9;&#x9;value.add(arrow);&#xA;&#x9;&#x9;&#x9;&#x9;targetWithX.put(source, value);&#xA;&#x9;&#x9;&#x9;}&#xA;&#x9;&#x9;}&#xA;&#x9;&#x9;List&lt;Arrow> zy = arrowMap.get(shape.getArrowByName(&quot;ZY&quot;));&#xA;&#x9;&#x9;if(zy != null){&#xA;&#x9;&#x9;&#x9;for(Arrow arrow : zy){&#xA;&#x9;&#x9;&#x9;&#x9;Node source = arrow.getSource();&#xA;&#x9;&#x9;&#x9;&#x9;if(targetWithX.containsKey(source)){&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;List&lt;Arrow> value = violated.containsKey(source) ? violated.get(source) : new ArrayList&lt;Arrow>();&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;if(value.isEmpty())&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;value.addAll(targetWithX.get(source));&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;value.add(arrow);&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;violated.put(source, value);&#xA;&#x9;&#x9;&#x9;&#x9;}&#xA;&#x9;&#x9;&#x9;}&#xA;&#x9;&#x9;}&#xA;&#x9;&#x9;if(violated.size() == 0)&#xA;&#x9;&#x9;&#x9;return true;&#xA;&#x9;&#x9;for(Entry&lt;Node, List&lt;Arrow>> entry : violated.entrySet()){&#xA;&#x9;&#x9;&#x9;System.out.println(entry.getKey().getName() + &quot; violates NAND constraint&quot;);&#xA;&#x9;&#x9;&#x9;System.out.println(&quot;It has multiply typed outgoing arrows:&quot;);&#xA;&#x9;&#x9;&#x9;for(Arrow arrow : entry.getValue())&#xA;&#x9;&#x9;&#x9;&#x9;System.out.println(arrow.getSource().getName() + &quot;-->&quot; + arrow.getTarget().getName());&#xA;&#x9;&#x9;}&#xA;&#x9;&#x9;return false; &#xA;&#x9;} &#xA;}&#xA;"/>
    <visualization type="ArrowToArrow" source="//@predicates.3/@shape/@arrows.0" target="//@predicates.3/@shape/@arrows.1"/>
  </predicates>
  <predicates symbol="irreflexive" icon="icons/irr_36.png">
    <shape id="a6be1b9d-6912-4c3a-a418-0954b62f658d" name="Default name">
      <nodes id="5cb2ff66-62a8-4893-9c8c-7c709735fb0c" name="X">
        <typeNode href="platform:/resource/DefaultGraph.xmi#//@nodes.0"/>
      </nodes>
      <arrows id="737ff24f-e49c-4499-a528-36d44a8dbf9d" target="//@predicates.4/@shape/@nodes.0" source="//@predicates.4/@shape/@nodes.0" name="XX">
        <typeArrow href="platform:/resource/DefaultGraph.xmi#//@arrows.0"/>
      </arrows>
    </shape>
    <semanticsValidator type="JAVA" validator="import java.util.*;&#xA;&#xA;import no.hib.dpf.core.Arrow;&#xA;import no.hib.dpf.core.Graph;&#xA;import no.hib.dpf.core.Node;&#xA;import no.hib.dpf.core.impl.Checker;&#xA;&#xA;public class CheckInstance implements Checker {&#xA;&#x9;public boolean check(Map&lt;String, String> maps, Graph shape, Map&lt;Node, List&lt;Node>> nodeMap,&#xA;&#x9;&#x9;&#x9;Map&lt;Arrow, List&lt;Arrow>> arrowMap) {&#xA;&#x9;&#x9;List&lt;Arrow> violated = new ArrayList&lt;Arrow>();&#xA;&#x9;&#x9;List&lt;Arrow> xx = arrowMap.get(shape.getArrowByName(&quot;XX&quot;));&#xA;&#x9;&#x9;if (xx != null) &#xA;&#x9;&#x9;&#x9;for (Arrow arrow : xx)&#xA;&#x9;&#x9;&#x9;&#x9;if (arrow.getTarget() == arrow.getSource())&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;violated.add(arrow);&#xA;&#x9;&#x9;if (violated.size() == 0)&#xA;&#x9;&#x9;&#x9;return true;&#xA;&#x9;&#x9;for (Arrow entry : violated)&#xA;&#x9;&#x9;&#x9;System.out.println(entry.getName()&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;+ &quot; violates Irreflexive constraint. &quot;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;+ entry.getSource().getName() + &quot; goes back to itself.&quot;);&#xA;&#x9;&#x9;return false;&#xA;&#x9;}&#xA;}&#xA;"/>
    <visualization source="//@predicates.4/@shape/@arrows.0"/>
  </predicates>
  <predicates symbol="inverse" icon="icons/inv_36.png">
    <shape id="d1e33bcd-d217-4b40-a812-6dd0f079d826" name="Default name">
      <nodes id="f17a6089-2e24-4eda-83d0-e6ac54031a8a" name="X">
        <typeNode href="platform:/resource/DefaultGraph.xmi#//@nodes.0"/>
      </nodes>
      <nodes id="6b016675-aa33-4a7e-b26b-c224eabb4791" name="Y">
        <typeNode href="platform:/resource/DefaultGraph.xmi#//@nodes.0"/>
      </nodes>
      <arrows id="661b332d-79f9-4e64-b3b3-b551cd5e2deb" target="//@predicates.5/@shape/@nodes.1" source="//@predicates.5/@shape/@nodes.0" name="XY">
        <typeArrow href="platform:/resource/DefaultGraph.xmi#//@arrows.0"/>
      </arrows>
      <arrows id="5e911488-63e8-458a-87e2-f853037316e0" target="//@predicates.5/@shape/@nodes.0" source="//@predicates.5/@shape/@nodes.1" name="YX">
        <typeArrow href="platform:/resource/DefaultGraph.xmi#//@arrows.0"/>
      </arrows>
    </shape>
    <semanticsValidator type="JAVA" validator="import java.util.ArrayList;&#xA;import java.util.HashMap;&#xA;import java.util.List;&#xA;import java.util.Map;&#xA;import no.hib.dpf.core.Arrow;&#xA;import no.hib.dpf.core.Graph;&#xA;import no.hib.dpf.core.Node;&#xA;import no.hib.dpf.core.impl.Checker;&#xA;&#xA;public class CheckInstance implements Checker {&#xA;&#x9;@Override&#xA;&#x9;public boolean check(Map&lt;String, String> maps, Graph graph, Map&lt;Node, List&lt;Node>> nodeMap,&#xA;&#x9;&#x9;&#x9;Map&lt;Arrow, List&lt;Arrow>> arrowMap) {&#xA;&#x9;&#x9;List&lt;Arrow> xy = arrowMap.get(graph.getArrowByName(&quot;XY&quot;));&#xA;&#x9;&#x9;Map&lt;Node, List&lt;Node>> visited = new HashMap&lt;Node, List&lt;Node>>();&#xA;&#x9;&#x9;if (xy != null) {&#xA;&#x9;&#x9;&#x9;for (Arrow arrow : xy) {&#xA;&#x9;&#x9;&#x9;&#x9;Node source = arrow.getSource();&#xA;&#x9;&#x9;&#x9;&#x9;List&lt;Node> value = visited.containsKey(source) ? visited&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;.get(source) : new ArrayList&lt;Node>();&#xA;&#x9;&#x9;&#x9;&#x9;if (!value.contains(arrow.getTarget()))&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;value.add(arrow.getTarget());&#xA;&#x9;&#x9;&#x9;&#x9;visited.put(source, value);&#xA;&#x9;&#x9;&#x9;}&#xA;&#x9;&#x9;}&#xA;&#x9;&#x9;List&lt;Arrow> yx = arrowMap.get(graph.getArrowByName(&quot;YX&quot;));&#xA;&#x9;&#x9;List&lt;Arrow> withXYArrow = new ArrayList&lt;Arrow>();&#xA;&#x9;&#x9;List&lt;Arrow> withoutXYArrow = new ArrayList&lt;Arrow>();&#xA;&#x9;&#x9;if (xy != null) {&#xA;&#x9;&#x9;&#x9;for (Arrow arrow : yx) {&#xA;&#x9;&#x9;&#x9;&#x9;Node target = arrow.getTarget();&#xA;&#x9;&#x9;&#x9;&#x9;Node source = arrow.getSource();&#xA;&#x9;&#x9;&#x9;&#x9;List&lt;Node> value = visited.get(target);// ? visited.get(source)&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;// : new&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;// ArrayList&lt;Node>();&#xA;&#x9;&#x9;&#x9;&#x9;if (value == null)&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;withoutXYArrow.add(arrow);&#xA;&#x9;&#x9;&#x9;&#x9;else if (!value.contains(source))&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;withXYArrow.add(arrow);&#xA;&#x9;&#x9;&#x9;}&#xA;&#x9;&#x9;}&#xA;&#x9;&#x9;if (withoutXYArrow.size() == 0 &amp;&amp; withXYArrow.size() == 0)&#xA;&#x9;&#x9;&#x9;return true;&#xA;&#x9;&#x9;for (Arrow arrow : withXYArrow)&#xA;&#x9;&#x9;&#x9;System.out&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;.println(arrow.getSource().getName()&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;+ &quot;-->&quot;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;+ arrow.getTarget().getName()&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;+ &quot;violate inverse constraint. It has no other direction relationship.&quot;);&#xA;&#x9;&#x9;for (Arrow arrow : withoutXYArrow)&#xA;&#x9;&#x9;&#x9;System.out&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;.println(arrow.getTarget().getName()&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;+ &quot;-->&quot;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;+ arrow.getSource().getName()&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;+ &quot;violate inverse constraint. It has no other direction relationship.&quot;);&#xA;&#x9;&#x9;return false;&#xA;&#x9;}&#xA;}"/>
    <visualization type="ArrowToArrow" source="//@predicates.5/@shape/@arrows.0" target="//@predicates.5/@shape/@arrows.1"/>
  </predicates>
  <predicates parameters="min:0;max:1" symbol="multi" icon="icons/mult_36.png">
    <shape id="c96aa25e-c517-4639-8fd9-d39ae965b0a9" name="Default name">
      <nodes id="6a5dd456-cd42-4239-a02d-a50e07c11fea" name="X">
        <typeNode href="platform:/resource/DefaultGraph.xmi#//@nodes.0"/>
      </nodes>
      <nodes id="cd61cd13-b5c4-4ac7-b543-135f67aac088" name="Y">
        <typeNode href="platform:/resource/DefaultGraph.xmi#//@nodes.0"/>
      </nodes>
      <arrows id="8ff36864-1cb9-40ab-91b9-71714bd77844" target="//@predicates.6/@shape/@nodes.1" source="//@predicates.6/@shape/@nodes.0" name="XY">
        <typeArrow href="platform:/resource/DefaultGraph.xmi#//@arrows.0"/>
      </arrows>
    </shape>
    <semanticsValidator type="JAVA" validator="import java.util.HashMap;&#xA;import java.util.List;&#xA;import java.util.Map;&#xA;import java.util.Map.Entry;&#xA;&#xA;import no.hib.dpf.core.Arrow;&#xA;import no.hib.dpf.core.Graph;&#xA;import no.hib.dpf.core.Node;&#xA;import no.hib.dpf.core.impl.Checker;&#xA;public class CheckInstance implements Checker{&#xA;&#x9;@Override&#xA;&#x9;public boolean check(Map&lt;String, String> maps, Graph graph, Map&lt;Node, List&lt;Node>> nodeMap,&#xA;&#x9;&#x9;&#x9;Map&lt;Arrow, List&lt;Arrow>> arrowMap) {&#xA;&#x9;&#x9;int min = Integer.parseInt(maps.get(&quot;min&quot;));&#xA;&#x9;&#x9;int max = Integer.parseInt(maps.get(&quot;max&quot;));&#xA;&#x9;&#x9;List&lt;Arrow> arrows = arrowMap.get(graph.getArrowByName(&quot;XY&quot;));&#xA;&#x9;&#x9;Map&lt;Node, Integer> record = new HashMap&lt;Node, Integer>();&#xA;&#x9;&#x9;if(arrows != null) {&#xA;&#x9;&#x9;&#x9;for (Arrow arrow : arrows) {&#xA;&#x9;&#x9;&#x9;&#x9;Node source = arrow.getSource();&#xA;&#x9;&#x9;&#x9;&#x9;Integer times = record.get(source);&#xA;&#x9;&#x9;&#x9;&#x9;record.put(source, times == null ? 1 : times + 1); &#xA;&#x9;&#x9;&#x9;}&#xA;&#x9;&#x9;}&#xA;&#x9;&#x9;List&lt;Node> nodes = nodeMap.get(graph.getNodeByName(&quot;X&quot;));&#xA;&#x9;&#x9;if(nodes != null){&#xA;&#x9;&#x9;&#x9;for(Node node : nodes)&#xA;&#x9;&#x9;&#x9;&#x9;if(!record.containsKey(node))&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;record.put(node, 0);&#xA;&#x9;&#x9;}&#xA;&#x9;&#x9;boolean result = true;&#xA;&#x9;&#x9;for(Entry&lt;Node, Integer>  entry : record.entrySet()){&#xA;&#x9;&#x9;&#x9;Integer value = entry.getValue();&#xA;&#x9;&#x9;&#x9;System.out.println(value);&#xA;&#x9;&#x9;&#x9;System.out.println(max);&#xA;&#x9;&#x9;&#x9;if(value &lt; min || value > max){&#xA;&#x9;&#x9;&#x9;&#x9;System.out.println(entry.getKey().getName() + &quot; has violates Multi[&quot; + min + &quot;,&quot; + max + &quot;] constraints. It has &quot; + value + &quot; outgoings.&quot;);&#xA;&#x9;&#x9;&#x9;&#x9;result = false;&#xA;&#x9;&#x9;&#x9;}&#xA;&#x9;&#x9;}&#xA;&#x9;&#x9;return result;&#xA;&#x9;}&#xA;}"/>
    <visualization source="//@predicates.6/@shape/@arrows.0"/>
  </predicates>
</no.hib.dpf.core:Signature>
