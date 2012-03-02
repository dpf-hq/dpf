package no.hib.dpf.core.impl;

import java.util.List;
import java.util.Map;

import no.hib.dpf.core.Arrow;
import no.hib.dpf.core.Graph;
import no.hib.dpf.core.Node;

public interface Checker {
	boolean check(Map<String, String> paras, Graph graph, Map<Node, List<Node>> nodeMap, Map<Arrow, List<Arrow>> arrowMap);
}
