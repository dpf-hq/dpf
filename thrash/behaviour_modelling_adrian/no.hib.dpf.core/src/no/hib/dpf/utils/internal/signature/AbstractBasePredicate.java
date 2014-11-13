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
	public AbstractBasePredicate(String symbol, String parameter, String nodes, String edges){
		super();
		this.symbol = symbol;
		this.parameters = parameter;
		setShape(CoreFactory.eINSTANCE.createGraph(nodes, edges));
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
