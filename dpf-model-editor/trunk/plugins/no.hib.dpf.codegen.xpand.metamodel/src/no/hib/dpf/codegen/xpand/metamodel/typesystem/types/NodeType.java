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
import org.eclipse.xtend.typesystem.Type;

public class NodeType extends AbstractTypeImpl {
	
	private DpfMetamodel model;
	private Node node;
	private Type metaType = null;
	
	public NodeType(DpfMetamodel model, String name, Node node) {
		super(model.getTypeSystem(), name);
		this.model = model;
		this.node = node;
	}

	public NodeType(DpfMetamodel model, String name, Node node, Type superType) {
		super(model.getTypeSystem(), name);
		this.model = model;
		this.node = node;
		this.metaType = superType;
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
		
		res.add(new OperationImpl(this, "getOutgoingArrows", new ListTypeImpl(model.getTypeForName("Arrow"), model.getTypeSystem(), "List")) {
			
			@Override
			protected Object evaluateInternal(Object target, Object[] params) {
				final List<Arrow> tmp = new ArrayList<Arrow>();
				tmp.addAll(node.getOutgoings());
				return tmp;
			}
		});
		
		if(node.getConstraints().size() != 0) {
			//The reason for using the first constraint is to give xpand the required features for the constraint type.
			res.add(new OperationImpl(this, "getConstraints", new ListTypeImpl(model.getTypeForName(node.getConstraints().get(0).getId()), model.getTypeSystem(), "List")) {
				
				@Override
				protected Object evaluateInternal(Object target, Object[] params) {
					return node.getConstraints();
				}
			});
		}
		return res.toArray(new Feature[res.size()]);
	}
	
	private void createGettersForAllOutgoingArrowsInNode(Set<FeatureImpl> res) {
		// Meta model specific getters

		Set<Arrow> arrowtypes = new HashSet<Arrow>();
		for(Arrow a : node.getOutgoings()) {
			if(!a.getName().equals("")) //To ensure we dont create methods without a name
				arrowtypes.add(a);
		}
		
		//We prefix arrow getters with A to denote arrow
		for (final Arrow a : arrowtypes) {
			res.add(new OperationImpl(this, TypeHelper.pluralize("getA" + TypeHelper.toFirstUpper(a.getName())),
					new ListTypeImpl(model.getTypeForName(a.getName()), model
							.getTypeSystem(), "List")) {
				@Override
				protected Object evaluateInternal(Object target, Object[] params) {
					final List<Arrow> tmp = new ArrayList<Arrow>();
					List<Object> arrows = model.getModelCollections(a.getId()); //instance level
					if(arrows != null) {
						for (Object o : arrows) {
							//We make sure that the typeNode has the typeArrow. To make sure the our arrow is allowed on the particular node
							if (node.getOutgoings().contains(((Arrow)o).getTypeArrow())) {
								//Instance level: We check that the model arrow has the callee node as source
								if(((Arrow)o).getSource().equals(target)) {
//									System.out.println("Matched!");
									tmp.add(((Arrow) o));
							
								}
							}
						}
					}
					return tmp;
				}
			});
		}
	}
	@Override
	public Set<? extends Type> getSuperTypes() {
		HashSet<Type> res = new HashSet<Type>();
		if(metaType != null) res.add(metaType);
		res.add(model.getTypeSystem().getObjectType());
		return res;
	}
	
	public Node getDpfNode() {
		return node;
	}
}
