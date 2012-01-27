package no.hib.dpf.codegen.xpand.metamodel.typesystem.types;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import no.hib.dpf.codegen.xpand.metamodel.DpfMetamodel;
import no.hib.dpf.codegen.xpand.metamodel.typesystem.FeatureImpl;
import no.hib.dpf.codegen.xpand.metamodel.typesystem.OperationImpl;
import no.hib.dpf.codegen.xpand.metamodel.typesystem.TypeHelper;
import no.hib.dpf.core.Graph;
import no.hib.dpf.core.Node;

import org.eclipse.xtend.typesystem.AbstractTypeImpl;
import org.eclipse.xtend.typesystem.Feature;

public class GraphType extends AbstractTypeImpl {

	private DpfMetamodel model;
	private Graph graph;
	
	public GraphType(DpfMetamodel model, String name, Graph graph) {
		super(model.getTypeSystem(), name);
		this.model = model;
		this.graph = graph;
	}

	@Override
	public boolean isInstance(Object o) {
		return o instanceof Graph;
	}

	@Override
	public Object newInstance() {
		return null;
	}

	@Override
	public Feature[] getContributedFeatures() {
		final Set<FeatureImpl> res = new HashSet<FeatureImpl>();
		
		res.addAll(TypeHelper.getEClassFeatures(model, graph.eClass(), this));
		
		createGettersForMetaModelNodeTypes(res);
		createGetterForAllArrowsInGraph(res);
		
		return res.toArray(new Feature[res.size()]);
	}
	
	private void createGetterForAllArrowsInGraph(Set<FeatureImpl> res) {
		// create a getter for each meta model type which returns all instances
		// as a list
		res.add(new OperationImpl(this, "getAllArrows",
				new ListTypeImpl(model.getTypeForName("dpf::Arrow"), model
						.getTypeSystem(), "List")) {
			@Override
			protected Object evaluateInternal(Object target, Object[] params) {
				return graph.getArrows();
			}
		});
	}

	private void createGettersForMetaModelNodeTypes(Set<FeatureImpl> res) {
		//Meta model specific getters
		
		List<String> nodetypes = new ArrayList<String>();
		for(Node n : graph.getNodes()) {
			boolean hasNode = false;
			for(String name : nodetypes) {
				if(name.equals(n.getName())) {
					hasNode = true;
				}
			}
			if(!hasNode)
				nodetypes.add(n.getName());
			else hasNode = false;
		}
		
		//create a getter for each meta model type which returns all instances as a list
		for(final String name : nodetypes) {
			res.add(new OperationImpl(this, TypeHelper.pluralize("get" + name), 
					new ListTypeImpl(model.getTypeForName(name), model.getTypeSystem(), "List")) {
				@Override
				protected Object evaluateInternal(Object target, Object[] params) {
					List<Node> tmp = new ArrayList<Node>();
					for(Object o : model.getModelCollections(name)) {
						if(o instanceof Node) {
							tmp.add(((Node)o));
						}
 					}
					return tmp;
				}
			});
		}
	}
}
