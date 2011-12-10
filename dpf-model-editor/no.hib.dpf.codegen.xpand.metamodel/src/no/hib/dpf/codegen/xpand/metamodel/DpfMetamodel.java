package no.hib.dpf.codegen.xpand.metamodel;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import no.hib.dpf.codegen.xpand.metamodel.typesystem.Cache;
import no.hib.dpf.codegen.xpand.metamodel.typesystem.types.ArrowType;
import no.hib.dpf.codegen.xpand.metamodel.typesystem.types.ConstraintType;
import no.hib.dpf.codegen.xpand.metamodel.typesystem.types.GraphType;
import no.hib.dpf.codegen.xpand.metamodel.typesystem.types.ListTypeImpl;
import no.hib.dpf.codegen.xpand.metamodel.typesystem.types.NodeType;
import no.hib.dpf.codegen.xpand.metamodel.typesystem.types.SpecificationType;
import no.hib.dpf.core.Arrow;
import no.hib.dpf.core.Constraint;
import no.hib.dpf.core.CorePackage;
import no.hib.dpf.core.Graph;
import no.hib.dpf.core.Node;
import no.hib.dpf.core.Predicate;
import no.hib.dpf.core.Specification;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.xtend.expression.TypeSystem;
import org.eclipse.xtend.expression.TypeSystemImpl;
import org.eclipse.xtend.type.impl.java.JavaBeansMetaModel;
import org.eclipse.xtend.typesystem.MetaModel;
import org.eclipse.xtend.typesystem.Type;

public class DpfMetamodel implements MetaModel {
	
	static {
		//Since we are using an instance model of the DPF ecore metamodel, we need to put the metamodel in the ecore package registry
		EPackage.Registry.INSTANCE.put(CorePackage.eNS_URI, CorePackage.eINSTANCE);
		System.out.println("DPFmetamodel2#static constructor");
	}
	
	private static String SPECIFICATION = "Specification";
	private static String NODE = "Node";
	private static String ARROW = "Arrow";
	private static String GRAPH = "Graph";
	private static String CONSTRAINT = "Constraint";
	private static String NS_PREFIX = "dpf2";
	
	private Specification dsmModel = null;
	private Specification instanceModel = null;
	
	private TypeSystem ts;
	private JavaBeansMetaModel jbmm = new JavaBeansMetaModel();
	
	private Cache<String, List<Object>> instanceCollections = new Cache<String, List<Object>>() {

		@Override
		protected List<Object> createNew(String typeName) {
			//Dersom vi finn ein korresponderande type i DSM'en, lagar vi ein collection med alle instansar av den typen
			System.out.println("Creating type collection: " + typeName);
//			Type t = typeForNameCache.get(typeName);
//			if(t != null) {
				List<Object> res = new ArrayList<Object>();
				//FIXME: Only creates collections for nodes.
				for(Node n : instanceModel.getGraph().getNodes()) {
					if(n.getTypeName().equals(typeName)) {
						res.add(n);
					}
				}
				return res;
//			}
//			return null;
		}
	};
	
	//Contains a DPF core type to Xpand type mapping.
	private Cache<Object, Type> dsmCache = new Cache<Object, Type>() {
		
		@Override
		protected Type createNew(Object obj) {
			System.out.println("----------->cache#createNew: " + obj);
			if(obj instanceof Specification) {
				return new SpecificationType(DpfMetamodel.this, NS_PREFIX + "::" + SPECIFICATION , (Specification)obj);
			} else if(obj instanceof Graph) {
				return new GraphType(DpfMetamodel.this, NS_PREFIX + "::" + GRAPH, (Graph)obj);
			} else if(obj instanceof Node) {
				return new NodeType(DpfMetamodel.this, NS_PREFIX + "::" + ((Node)obj).getName(), (Node)obj);
			} else if(obj instanceof Arrow) {
				return new ArrowType(DpfMetamodel.this, NS_PREFIX + "::" + ((Arrow)obj).getName(), (Arrow)obj);
			} else if(obj instanceof Constraint) {
				return new ConstraintType(DpfMetamodel.this, NS_PREFIX + "::" + CONSTRAINT, (Constraint)obj);
			}
			return null;
		}
	};
	
	//Contains a string to Xpand Type mapping
	private Cache<String, Type> typeForNameCache = new Cache<String, Type>() {
		
		@Override
		protected Type createNew(String str) {
			//Finn namnet på typen, må strippa vekk namespace
			int i = str.indexOf("::");
			String typeDefinition = str;
			if(i != -1) {
				typeDefinition = str.substring(i+2);
			}
			System.out.println("----------->typeForNameCache#createNew: " + typeDefinition);
				
			if(instanceModel == null) System.out.println("typeForNameCache: spec is null");
				
			Object key = getCacheKeyForTypeName(typeDefinition);
				
			//If we already have registered the type
			if(key != null) {
				return dsmCache.get(key);
			} else {
				//We need to register the proper type
				//Should only return a valid dsm type.
				key = getGraphElementForName(typeDefinition);
				//FIXME: Workaround: The ecore specific code needs to get nodenames/nodes from dsm. When building the collections
				//we need to return a typenode. Hence we create a new method.
				if(!dsmCache.exists(key) || key == null) {
					key = getDsmTypeForInstanceName(typeDefinition);
				}
				if(key != null) 
					return dsmCache.get(key);
			}

			//returnerer antakeligvis null dersom namespace
			System.out.println("getTypeForName#createNew: returned null");	
			return null;
		}

	};
	
	public DpfMetamodel() {}
	
	public DpfMetamodel(Specification dsm) {
		this.dsmModel = dsm;
		getKnownTypes();
	}
	
	public void setDsm(Specification dsm) {
		this.dsmModel = dsm;
		getKnownTypes();
	}
	
	//FIXME: Horrible code.
	//Used to find the first object with proper type to associate a type string with the proper Xpand Type in typeForNameCache
	private Object getCacheKeyForTypeName(String k) {
		for(Object o : dsmCache.getKeys()) {
			if(k.equals(SPECIFICATION)) {
				if(o instanceof Specification) {
					return o;
				}
			} else if(k.equals(GRAPH)) {
				if(o instanceof Graph) {
					return o;
				}
			} else if(k.equals(NODE)) {
				if(o instanceof Node) {
					return o;
				}
			} else if(k.equals(ARROW)) {
				if(o instanceof Arrow) {
					return o;
				}
			} else if(k.equals(CONSTRAINT)) {
				if(o instanceof Constraint) {
					return o;
				}
			} else if(k.equals("Predicate")) {
				if(o instanceof Predicate) {
					return o;
				}
			}
		}
		return null;
	}
	
	private Object getDsmTypeForInstanceName(String name) {
		System.out.println("getDsmTypeForInstanceName: trying to find Graph element with name: " + name);
		//This method should map a instance type to a type specified in the DSM
		//TODO: Also there should be some validation that the type is actually in the DSM, and not just extract the type node of the instance like now.
		if(instanceModel != null) {
			if(name.equals(SPECIFICATION)) {
				System.out.println("createNewTypeForName: Specification called. This makes stuff fucky");
				return instanceModel;
			} else {
				if(name.equals(GRAPH)) {
					return instanceModel.getGraph();
				} else {
					for(Node n : instanceModel.getGraph().getNodes()) {
						if(name.equals(n.getName())) { 
							return n.getTypeNode(); //We return an object which is in the DSM.
						}
					}
					for(Arrow a : instanceModel.getGraph().getArrows()) {
						if(name.equals(a.getName())) { 
							return a.getTypeArrow();
						}
					}
				}
			}
		}
		return null;
	}
	private Object getGraphElementForName(String name) {
		//This method is fugly and is used to retrieve a valid dpf object, which is identifying the proper 
		//object to do a lookup on in dsmCache.
		System.out.println("getGraphElementForName: trying to find Graph element with name: " + name);
		
		if(dsmModel != null) {
			if(name.equals(SPECIFICATION)) {
				System.out.println("createNewTypeForName: Specification called. This makes stuff fucky");
				return dsmModel;
			} else {
				if(name.equals(GRAPH)) {
					return dsmModel.getGraph();
				} else {
					for(Node n : dsmModel.getGraph().getNodes()) {
						if(name.equals(n.getName())) { 
							return n; //We return an object which is in the DSM.
						}
					}
					for(Arrow a : dsmModel.getGraph().getArrows()) {
						if(name.equals(a.getName())) { 
							return a;
						}
					}
				}
			}
		}
		return null;
	}
	
	@Override
	public TypeSystem getTypeSystem() {
		if(ts == null)
			setTypeSystem(new TypeSystemImpl());
		return ts;
	}

	@Override
	public void setTypeSystem(final TypeSystem typeSystem) {
		this.ts = typeSystem;
		this.jbmm.setTypeSystem(typeSystem);
		System.out.println("DPFMM2#setTypeSystem called");
	}

	@Override
	public Type getTypeForName(String typeName) {
		System.out.println("------> getTypeForname: " + typeName);
		return typeForNameCache.get(typeName);
	}

	public Type getTypeForETypedElement(ETypedElement typedElement) {
		//We need to map the pre-defined EStructuralFeatures (the ones specified in the DPF ecore metamodel.
		//This is an attempt on making things as generic as possible. Allthough it will probably break if names change in the metamodel
		System.out.println("getTypeForETypedElement:");
		if(typedElement.getEType() == null) {
			return ts.getVoidType();
		}
		
		Type t = null;
		EClassifier classifier = typedElement.getEType();
		if(classifier.getName().equals(GRAPH)) {
			//TODO: Types are stored with ns prefix
			t = getTypeForName(NS_PREFIX + "::" + GRAPH);
		} else if(classifier instanceof EDataType) {
			//This resolves an "external" datatype used in the DPF ecore. This means other classes than the EClasses provided by ecore.
			EDataType dt = (EDataType)classifier;
			if(dt.getInstanceClassName() != null) {
				//if the EDataType has a class name (which is with a full identifier) we use the JavaBeansMetaModel to resolve it's features (attributes and operations)
				t = jbmm.getTypeForName(dt.getInstanceClassName().replace(".", "::"));
				if(t == null) {
					t = ts.getTypeForName(dt.getInstanceClassName().replace(".", "::"));
				}
			} else return ts.getObjectType();
		} else {
			if(typedElement.getEGenericType() != null) {
				System.out.println("------------> EGenericType: " + typedElement.getEGenericType());
					//Linje 359-373 EmfRegistryMM... sjekk på om baseType har verdi eller om det er gyldig listetype
				t = getTypeForEClassifier(typedElement.getEGenericType()); //Void type?
			} else {
				t = getTypeSystem().getTypeForName(typedElement.getEType().getName());
				//TODO: See getFullyQualifiedName()
			}
		}
		if(t == null) System.out.println("------------> getTypeForETypedElement failed: " + typedElement.getEType());
		
		if(typedElement.isMany())
			return new ListTypeImpl(t, ts, "List");
		else return t;
	}
	
	public Type getTypeForEClassifier(final EGenericType element) {
		EClassifier baseType = null;
		if (element.getEClassifier() != null) {
			baseType = element.getEClassifier();
		} else {
			baseType = element.getERawType();
		}
		
		//sjekkar at vi ikkje har ei liste
		if (baseType == null || !(baseType instanceof EList<?>)) {
			return getTypeForEClassifier(baseType);
		}
		if (element.getETypeArguments().size() != 1)
			throw new RuntimeException("Unexpected number of type arguments " + element.getETypeArguments().toString());

		return dsmCache.get(element);
	}
	
	public Type getTypeForEClassifier(final EClassifier element) {
		if (element == null) {
			return getTypeSystem().getVoidType();
		}
		System.out.println("getTypeForEClassifier#name: " + element.getName());
		return getTypeForName(NS_PREFIX + "::" + element.getName());
	}
	
	@Override
	public Type getType(Object obj) {
		//This method is supposed to return a proper type for the object parameter.
		//Otherwise it returns null and lets the other metamodels do the work.
		System.out.println("getType: " + obj.toString());
		
		//Requires the input to start with a Specification object.
		if(obj instanceof Specification && instanceModel != dsmModel) {
			instanceModel = (Specification)obj;
			
			for(Node dsmNode : dsmModel.getGraph().getNodes()) {
				instanceCollections.get(dsmNode.getName());
			}
		} 
		//dekkar alle(?) ønska typar. Test.
		//Sidan vi kallar getKnownTypes i spesialkonstruktør, har vi registrert alt vi treng FØR getType vert kalla
		//mao. vi kan anta at dsm aldri går igjen getType.
//		if(obj instanceof Specification
//				|| obj instanceof IDObject
//				|| obj instanceof Predicate
//				|| obj instanceof Constraint) {
//			return dsmCache.get(obj);
//		}
		
		if(obj instanceof Specification) {
			return getTypeForName(SPECIFICATION);
		} else if(obj instanceof Graph) {
			return getTypeForName(GRAPH);
		} else if(obj instanceof Node) {
			return getTypeForName(((Node)obj).getName());
		} else if(obj instanceof Arrow) {
			return getTypeForName(((Arrow)obj).getName());
		} else if(obj instanceof Constraint) {
			return getTypeForName(CONSTRAINT);
		}
		
		// Should return null if it's not a relevant type. If not, we create a lot of useless objects in cache, and denies the other xpand metamodels from matching the type.
		return null;
	}
	
	public Cache<String, List<Object>> getInstanceModelCollections() {
		return instanceCollections;
	}
	
	@Override
	public Set<Type> getKnownTypes() {
		// Vi må på eit tidspunkt laste inn alle xpandtypar vi vil ha, slik at alle operasjonar kan gjennomførast. 
		// Td. får ein ikkje brukt getAttributes utan at Attribute er registrert i cache

		//hentar alle kjende type(instansar?)
		//I emfrmm hentar den alle entitetar i modellen (allPackages()), legg alle til i ei liste, for så
		//å sjekke kva type som er assosiert med kvar entitet; sjekkar mao. Eclassifiers mot getTypeForEclassifier
		
		Set<Type> res = new HashSet<Type>();
		if(dsmCache.isEmpty()) {
			res.add(dsmCache.get(dsmModel));
			res.add(dsmCache.get(dsmModel.getGraph()));
			for(Node n : dsmModel.getGraph().getNodes()) {
				res.add(dsmCache.get(n));
			}
			for(Arrow a : dsmModel.getGraph().getArrows()) {
				res.add(dsmCache.get(a));
			}
			for(Constraint c : dsmModel.getGraph().getConstraints()) {
				res.add(dsmCache.get(c));
			}
		} else {
			for(Type t : dsmCache.getValues()) {
				res.add(t);
			}
		}
		System.out.println("MetaModel#getKnownTypes called");
		return res;
	}

	@Override
	public Set<String> getNamespaces() {
		//Should probably not be hardcoded; in the emf mm the NS is resolved from the ecore package.
		//In our case it will only be whatever is set in the CorePackage interface. This is hardcoded and is not changeable and will thus 
		//always resolve no.hib.dpf.core. It is then easier to just use "dpf".
		System.out.println("DPFMetaModel2#getNamespaces called");
		Set<String> res = new HashSet<String>();
		res.add(NS_PREFIX);
		return res;
	}

}
