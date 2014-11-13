package no.hib.dpf.utils.internal.signature;

import java.util.List;
import java.util.Map;

import no.hib.dpf.core.Arrow;
import no.hib.dpf.core.CoreFactory;
import no.hib.dpf.core.Graph;
import no.hib.dpf.core.Node;
import no.hib.dpf.core.impl.PredicateImpl;
import no.hib.dpf.utils.Checker;

public abstract class AbstractBasePredicate extends PredicateImpl{
	public static final String INJECTIVE = "inj",
							   SURJECTIVE = "surj",
							   IRREFLEXIVE = "irref",
							   ARROW_MULTIPLICITY = "multi1",
							   NODE_MULTIPLICITY = "multi2",
							   INVERSE = "inv",
							   JOINT_SURJECITVE = "js",
							   JOINT_INJECTIVE = "ji",
							   XOR = "xor",
							   SPLIT_NOT_AND = "nand1",
							   MERGE_NOT_AND = "nand2",
							   REFLEXIVE = "ref",
							   XOR4 = "xor4";
	public AbstractBasePredicate(String symbol, String parameter, String nodes, String edges){
		super();
		this.symbol = symbol;
		this.parameters = parameter;
		setShape(CoreFactory.eINSTANCE.createGraph(nodes, edges));
		setValidator(CoreFactory.eINSTANCE.createDefaultSemanticValidator());
		checker = new Checker() {
			
			@Override
			public boolean check(Map<String, String> paras, Graph graph,
					Map<Node, List<Node>> nodeMap, Map<Arrow, List<Arrow>> arrowMap) {
				return AbstractBasePredicate.this.check(paras, graph, nodeMap, arrowMap);
			}
		};
	}
	public abstract boolean check(Map<String, String> paras, Graph graph,
			Map<Node, List<Node>> nodeMap, Map<Arrow, List<Arrow>> arrowMap) ;
}
