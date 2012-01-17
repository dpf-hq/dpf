<?xml version="1.0" encoding="UTF-8"?>
<no.hib.dpf.core:Signature xmlns:no.hib.dpf.core="http://no.hib.dpf.core">
  <predicates symbol="surjective" icon="/media/Data/DPF/runtime-EclipseApplication/dpf/signature/icons/surj_36.png">
    <shape id="dacc4224-482c-463d-a34b-a190cf7812c8" name="Default name">
      <nodes id="82bcfefb-6e73-42aa-9b0f-4c4f01fdc931" name="X">
        <typeNode href="platform:/resource/DefaultGraph.xmi#//@nodes.0"/>
      </nodes>
      <nodes id="29920cc8-692d-43d3-b040-cd63c515a9f4" name="Y">
        <typeNode href="platform:/resource/DefaultGraph.xmi#//@nodes.0"/>
      </nodes>
      <arrows id="47de76a1-9baf-460f-9f12-eaa6f2c31a75" target="//@predicates.0/@shape/@nodes.1" source="//@predicates.0/@shape/@nodes.0" name="">
        <typeArrow href="platform:/resource/DefaultGraph.xmi#//@arrows.0"/>
      </arrows>
    </shape>
    <semanticsValidator type="JAVA" validator="import java.util.*; &#xA;&#xA;import no.hib.dpf.core.Arrow; &#xA;import no.hib.dpf.core.Graph; &#xA;import no.hib.dpf.core.Node; &#xA;import no.hib.dpf.core.impl.Checker; &#xA;public class CheckInstance implements Checker { &#xA;&#x9;public boolean check(Graph shape, Map&lt;Node, List&lt;Node>> nodeMap, Map&lt;Arrow, List&lt;Arrow>> arrowMap) { &#xA;&#x9;&#x9;List&lt;Node> yNodes = nodeMap.get(shape.getNodeByName(&quot;Y&quot;)); &#xA;&#x9;&#x9;List&lt;Arrow> arrows = arrowMap.get(shape.getArrows().get(0)); &#xA;&#x9;&#x9;ArrayList&lt;Node> visitedY = new ArrayList&lt;Node>(); &#xA;&#x9;&#x9;if(arrows != null){&#xA;&#x9;&#x9;&#x9;Iterator&lt;Arrow> i = arrows.iterator(); &#xA;&#x9;&#x9;&#x9;while(i.hasNext()){ &#xA;&#x9;&#x9;&#x9;&#x9;Object arrow = i.next();&#xA;&#x9;&#x9;&#x9;&#x9;if (!visitedY.contains(((Arrow)arrow).getTarget())) &#xA;&#x9;&#x9;&#x9;&#x9;&#x9;visitedY.add(((Arrow)arrow).getTarget()); &#xA;&#x9;&#x9;&#x9;} &#xA;&#x9;&#x9;}&#x9;&#x9;&#xA;&#x9;&#x9;if (yNodes != null &amp;&amp; visitedY.size() != yNodes.size()){ &#xA;&#x9;&#x9;&#x9;System.out.println(&quot;Surjective Violated&quot;); &#xA;&#x9;&#x9;&#x9;return false; &#xA;&#x9;&#x9;} &#xA;&#x9;&#x9;return true; &#xA;&#x9;} &#xA;}"/>
    <visualization source="//@predicates.0/@shape/@arrows.0"/>
  </predicates>
  <predicates symbol="xor" icon="/media/Data/DPF/runtime-EclipseApplication/dpf/signature/icons/xor_36.png">
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
      <arrows id="c2276b42-7ed4-42c1-9474-e38b727d49d0" target="//@predicates.1/@shape/@nodes.2" source="//@predicates.1/@shape/@nodes.0" name="XZ">
        <typeArrow href="platform:/resource/DefaultGraph.xmi#//@arrows.0"/>
      </arrows>
      <arrows id="ee01fe51-4047-4905-a28a-2b52dc358675" target="//@predicates.1/@shape/@nodes.2" source="//@predicates.1/@shape/@nodes.1" name="YZ">
        <typeArrow href="platform:/resource/DefaultGraph.xmi#//@arrows.0"/>
      </arrows>
    </shape>
    <semanticsValidator type="JAVA" validator="import java.util.*; &#xA;&#xA;import no.hib.dpf.core.Arrow; &#xA;import no.hib.dpf.core.Graph; &#xA;import no.hib.dpf.core.Node; &#xA;import no.hib.dpf.core.impl.Checker; &#xA;public class CheckInstance implements Checker { &#xA;&#x9;public boolean check(Graph shape, Map&lt;Node, List&lt;Node>> nodeMap, Map&lt;Arrow, List&lt;Arrow>> arrowMap) { &#xA;&#x9;&#x9;List&lt;Node> sourceWithX = new ArrayList&lt;Node>();&#xA;&#x9;&#x9;List&lt;Node> violated = new ArrayList&lt;Node>();&#xA;&#x9;&#x9;List&lt;Arrow> xz = arrowMap.get(shape.getArrowByName(&quot;XZ&quot;));&#xA;&#x9;&#x9;if(xz != null){&#xA;&#x9;&#x9;&#x9;for(Arrow arrow : xz){&#xA;&#x9;&#x9;&#x9;&#x9;Node zTyped = arrow.getTarget();&#xA;&#x9;&#x9;&#x9;&#x9;if(!sourceWithX.contains(zTyped))&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;sourceWithX.add(zTyped);&#xA;&#x9;&#x9;&#x9;}&#xA;&#x9;&#x9;}&#xA;&#x9;&#x9;List&lt;Arrow> yz = arrowMap.get(shape.getArrowByName(&quot;YZ&quot;));&#xA;&#x9;&#x9;if(yz != null){&#xA;&#x9;&#x9;&#x9;for(Arrow arrow : yz){&#xA;&#x9;&#x9;&#x9;&#x9;Node zTyped = arrow.getTarget();&#xA;&#x9;&#x9;&#x9;&#x9;if(!violated.contains(zTyped) &amp;&amp; sourceWithX.contains(zTyped))&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;violated.add(zTyped);&#xA;&#x9;&#x9;&#x9;}&#xA;&#x9;&#x9;}&#xA;&#x9;&#x9;if(violated.size() == 0)&#xA;&#x9;&#x9;&#x9;return true;&#xA;&#x9;&#x9;for(Node node : violated){&#xA;&#x9;&#x9;&#x9;System.out.println(node.getName() + &quot;violates XOR constraint&quot;);&#xA;&#x9;&#x9;}&#xA;&#x9;&#x9;return false; &#xA;&#x9;} &#xA;}&#xA;"/>
    <visualization type="ArrowToArrow" source="//@predicates.1/@shape/@arrows.0" target="//@predicates.1/@shape/@arrows.1"/>
  </predicates>
</no.hib.dpf.core:Signature>
