package no.hib.dpf.codegen.xpand.metamodel.typesystem.types;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import no.hib.dpf.codegen.xpand.metamodel.DpfMetamodel;
import no.hib.dpf.codegen.xpand.metamodel.typesystem.FeatureImpl;
import no.hib.dpf.codegen.xpand.metamodel.typesystem.OperationImpl;
import no.hib.dpf.codegen.xpand.metamodel.typesystem.TypeHelper;
import no.hib.dpf.core.Arrow;
import no.hib.dpf.core.Node;

import org.eclipse.xtend.typesystem.AbstractTypeImpl;
import org.eclipse.xtend.typesystem.Feature;

public class NodeType extends AbstractTypeImpl {
	
	private DpfMetamodel model;
	private Node node;
	
	public NodeType(DpfMetamodel model, String name, Node node) {
		super(model.getTypeSystem(), name);
		this.model = model;
		this.node = node;
	}

	@Override
	public boolean isInstance(Object o) {
		return o instanceof Node;
	}

	@Override
	public Object newInstance() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Feature[] getContributedFeatures() {
		final Set<FeatureImpl> res = new HashSet<FeatureImpl>();
		
		res.addAll(TypeHelper.getEClassFeatures(model, node.eClass(), this));
		
		createGettersForAllOutgoingArrowsInNode(res);
		
		res.add(new OperationImpl(NodeType.this, "toString", getTypeSystem().getStringType()) {

			@Override
			protected Object evaluateInternal(Object target, Object[] params) {
				if(target instanceof Node) {
					return "NodeType#toString: " + ((Node)target).getName();
				}
				return null;
			}	
		});
		
		return res.toArray(new Feature[res.size()]);
	}
	
	private void createGettersForAllOutgoingArrowsInNode(Set<FeatureImpl> res) {
		// Meta model specific getters

		List<String> arrowtypes = new ArrayList<String>();
		for (Arrow a : node.getGraph().getArrows()) {
			boolean hasArrow = false;
			for (String name : arrowtypes) {
				if (name.equals(a.getName()) && node.getOutgoingArrows().contains(a)) {
					hasArrow = true;
				}
			}
			if (!hasArrow)
				arrowtypes.add(a.getName());
			else
				hasArrow = false;
		}

		//We prefix arrow getters with A to denote arrow
		for (final String name : arrowtypes) {
			res.add(new OperationImpl(this, TypeHelper.pluralize("getA" + TypeHelper.toFirstUpper(name)),
					new ListTypeImpl(model.getTypeForName(name), model
							.getTypeSystem(), "List")) {
				@Override
				protected Object evaluateInternal(Object target, Object[] params) {
					List<Arrow> tmp = new ArrayList<Arrow>();
					for (Object o : model.getModelCollections(name)) {
						if (o instanceof Arrow) {
							tmp.add(((Arrow) o));
						}
					}
					return tmp;
				}
			});
		}
	}
}
