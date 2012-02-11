package no.hib.dpf.codegen.xpand.metamodel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import no.hib.dpf.codegen.xpand.metamodel.typesystem.Cache;
import no.hib.dpf.codegen.xpand.metamodel.typesystem.OperationImpl;
import no.hib.dpf.codegen.xpand.metamodel.typesystem.PropertyImpl;
import no.hib.dpf.codegen.xpand.metamodel.typesystem.types.ArrowType;
import no.hib.dpf.codegen.xpand.metamodel.typesystem.types.ConstraintType;
import no.hib.dpf.codegen.xpand.metamodel.typesystem.types.DummyType;
import no.hib.dpf.codegen.xpand.metamodel.typesystem.types.GraphType;
import no.hib.dpf.codegen.xpand.metamodel.typesystem.types.ListTypeImpl;
import no.hib.dpf.codegen.xpand.metamodel.typesystem.types.NodeType;
import no.hib.dpf.codegen.xpand.metamodel.typesystem.types.PredicateType;
import no.hib.dpf.codegen.xpand.metamodel.typesystem.types.SpecificationType;
import no.hib.dpf.core.Arrow;
import no.hib.dpf.core.Constraint;
import no.hib.dpf.core.CorePackage;
import no.hib.dpf.core.Graph;
import no.hib.dpf.core.Node;
import no.hib.dpf.core.Predicate;
import no.hib.dpf.core.Specification;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.internal.xtend.type.baseimpl.BuiltinMetaModel;
import org.eclipse.xtend.expression.TypeSystem;
import org.eclipse.xtend.expression.TypeSystemImpl;
import org.eclipse.xtend.type.impl.java.JavaBeansMetaModel;
import org.eclipse.xtend.typesystem.MetaModel;
import org.eclipse.xtend.typesystem.Type;
import org.eclipse.xtend.typesystem.emf.EmfListType;
/**
 * 
 * This class represents a Xpand meta model. It's purpose is to map our custom types to
 * types which Xpand can understand. Types contained in the DPF Specification object are
 * mapped to their corresponding Xpand type, ie. an instance of Node (called DomainClass),
 * are mapped to {@link NodeType} with name "DomainClass". This happens through getKnownTypes and
 * dsmCache upon DpfMetamodel instantiation.
 * 
 * When a template is called with the instance model of the DPF meta model as argument, 
 * the Xpand generator will first try to match the Specification object and see if it
 * exists in the meta model. Next it will match the type definitions in the template 
 * against the Specification object provided, through typeForNameCache, ie. getTypeForName
 * will be called with "dpf::Type" as argument.
 * 
 * Each custom Xpand type will also map EOperations and EAttributes from the DPF ecore, so 
 * that we have all the operations defined + custom ones, specified as {@link OperationImpl}
 * and {@link PropertyImpl} 
 *  
 * @author Anders Sandven <anders.sandven@gmail.com>
 */
public class DpfMetamodel implements MetaModel, DpfMMConstants {
	
	static {
		//Since we are using an instance model of the DPF ecore metamodel, we need to put the metamodel in the ecore package registry
		EPackage.Registry.INSTANCE.put(CorePackage.eNS_URI, CorePackage.eINSTANCE);
	}
	
	private static Log log = LogFactory.getLog(DpfMetamodel.class);
	
	/** Contains ecore specific code for use with Xpand types */
	private InternalEcoreHelper ecoreHelper = new InternalEcoreHelper();
	
	/** Represents the domain-specfic modeling language (the meta model) */
	private InternalMetaModel dpfMetaModel = new InternalMetaModel();
	
	/** Represents the model instance of the DPF meta model */
	private InternalModel dpfModel = new InternalModel();
	
	/** Xpand base type system */
	private TypeSystem ts;
	
	/** Java Beans Meta Model which handles java types (found in ecore) */
	private JavaBeansMetaModel jbmm = new JavaBeansMetaModel();
	
	public DpfMetamodel() {
	}
	
	public DpfMetamodel(Specification metaModel) {
		dpfMetaModel.addMetaModel(NS_PREFIX, metaModel);
	}
	
	/**
	 * Sets the Domain Specific Modeling Language (meta model), and initializes the internal metamodel.
	 * 
	 * @param dpfMetaModel
	 *            Specification object which represents the Domain Specific Modeling Language
	 */
	public void addDpfMetaModel(Specification metaModel) {
		dpfMetaModel.addMetaModel(NS_PREFIX, metaModel);
	}
	
	public void setDpfModel(Specification model) {
		dpfModel.setDpfModel(NS_PREFIX, model);
	}
	
	public Type getTypeForETypedElement(ETypedElement typedElement) {
		return ecoreHelper.getTypeForETypedElement(typedElement);
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
		log.debug("setTypeSystem called");
	}

	@Override
	public Type getTypeForName(String typeName) {
		return dpfModel.getTypeForName(typeName);
	}

	/**
	 * This method is the starting point when an expand statement is called.
	 * In this metamodel's case , the instance model's {@link Specification} is the first thing that
	 * this method is called on. 
	 * 
	 * @param obj
	 * 		The object that should be mapped to a Xpand Type		
	 * @return a Xpand Type instance
	 */
	@Override
	public Type getType(Object obj) {
		if(obj instanceof Specification) {
			return getTypeForName(SPECIFICATION);
		} else if(obj instanceof Graph) {
			return getTypeForName(GRAPH);
		} else if(obj instanceof Node) {
			//Vi får inn objekt fieldRef med namn userName. Ein kallar så getTypeForName og får igjen NodeType som er feil feil type.
			Type t = getTypeForName(((Node)obj).getName());
			try {
				NodeType ret = (NodeType)t;
				return ret;
			} catch(ClassCastException e) {
				System.out.println("ClassCastException: " + t.getName() + " is not of NodeType. Trying typeNode: " + ((Node)obj).getTypeNode().getName());
				Type tmp = dpfMetaModel.getXpandTypeForDpfType(((Node)obj).getTypeNode());
				return tmp;
			}
		} else if(obj instanceof Arrow) {
			Type t = getTypeForName(((Arrow)obj).getName());
			try {
				ArrowType ret = (ArrowType)t;
				return ret;
			} catch(ClassCastException e) {
				System.out.println("ClassCastException: " + t.getName() + " is not of ArrowType. Trying typeArrow: " + ((Arrow)obj).getTypeArrow().getName());
				Type tmp = dpfMetaModel.getXpandTypeForDpfType(((Arrow)obj).getTypeArrow());
				return tmp;
			}
		} else if(obj instanceof Constraint) {
			return getTypeForName(CONSTRAINT);
		} 
		// Should return null if it's not a relevant type. If not, we create a lot of useless objects in cache, and denies the other xpand metamodels from matching the type.
		return null;
	}
	
	/**
	 * Returns a Cache object with all instances of a dsm type grouped in a list.
	 * This is used in the custom Xpand types such as {@link GraphType}.
	 * 
	 * It only saves types which are instances of Node.
	 * 
	 * It is not really necessary, but makes it a bit easier and more efficient.
	 * 
	 * @return Cache object with a dsm type name as key, and a list of DPF instance types (ie. Node) as value
	 */
	public List<Object> getModelCollections(String typeName) {
		return dpfModel.getMetaModelTypeCollections(typeName);
	}
	
	/**
	 * This method returns all known types that Xpand should know of.
	 * We call getKnownTypes in {@link DpfMetamodel#DpfMetamodel(Specification)} as well as in
	 * {@link DpfMetamodel#addDpfMetaModel(Specification)} to initalize the meta models dsmCache with the proper types.
	 * 
	 * @return set of all known types
	 */
	@Override
	public Set<Type> getKnownTypes() {
		// Vi må på eit tidspunkt laste inn alle xpandtypar vi vil ha, slik at alle operasjonar kan gjennomførast. 
		// Td. får ein ikkje brukt getAttributes utan at Attribute er registrert i cache

		//hentar alle kjende type(instansar?)
		//I emfrmm hentar den alle entitetar i modellen (allPackages()), legg alle til i ei liste, for så
		//å sjekke kva type som er assosiert med kvar entitet; sjekkar mao. Eclassifiers mot getTypeForEclassifier
		
		Set<Type> res = new HashSet<Type>();
		res.add(getTypeForName("dpf::Node"));
		res.add(getTypeForName("dpf::Arrow"));
		for(Type t : dpfMetaModel.getXpandTypes()) {
			res.add(t);
		}
		log.debug("MetaModel#getKnownTypes called");
		return res;
	}
	
	/**
	 * Returns a set of all known namespaces. 
	 * In the EmfRegistryMetamodel, you can have multiple metamodels, which uses the XML namespace as namespace.
	 * Right now this method just returns {@link #NS_PREFIX}, as supporting multiple models isn't prioritized.
	 * When implementing this properly, one needs to figure out a proper way to handle the namespaces.
	 * Every model that the DPF editor spits out, uses no.hib.dpf.core as NS.
	 * 
	 * @return set of all known namespaces
	 */
	@Override
	public Set<String> getNamespaces() {
		//Should probably not be hardcoded; in the emf mm the NS is resolved from the ecore package.
		//In our case it will only be whatever is set in the CorePackage interface. This is hardcoded and is not changeable and will thus 
		//always resolve no.hib.dpf.core. It is then easier to just use "dpf".
		log.debug("DpfMetamodel#getNamespaces called");
		Set<String> res = new HashSet<String>();
		res.add(NS_PREFIX);
		return res;
	}
	
	private class InternalMetaModel {
		/**Namespace for use when creating new Xpand Types*/
		private String ns = null;
		
		/** Contains specifications */
		private HashMap<String, Specification> specifications = new HashMap<String, Specification>();
		
		/** Contains a DPF core type to Xpand type mapping. */
		private Cache<Object, Type> metaModelCache = new Cache<Object, Type>() {
			
			@Override
			protected Type createNew(Object obj) {
				log.debug("cache#createNew: " + obj);
				if(obj instanceof Specification) {
					return new SpecificationType(DpfMetamodel.this, ns + "::" + SPECIFICATION , (Specification)obj);
				} else if(obj instanceof Graph) {
					return new GraphType(DpfMetamodel.this, ns + "::" + GRAPH, (Graph)obj);
				} else if(obj instanceof Node) {
					return new NodeType(DpfMetamodel.this, ns + "::" + ((Node)obj).getName(), (Node)obj);
				} else if(obj instanceof Arrow) {
					return new ArrowType(DpfMetamodel.this, ns + "::" + ((Arrow)obj).getName(), (Arrow)obj);
				} else if(obj instanceof Constraint) {
					return new ConstraintType(DpfMetamodel.this, ns + "::" + CONSTRAINT, (Constraint)obj);
				} else if(obj instanceof Predicate) {
					return new PredicateType(DpfMetamodel.this, ns + "::" + PREDICATE , (Predicate)obj);
				} else if(obj instanceof DummyType) {
					
				}
				return null;
			}
		};
		
		public InternalMetaModel() {
			
		}
		
		public void addMetaModel(String namespace, Specification spec) {
			ns = namespace;
			
			//Placeholders for the actual node and arrow type, since it's not possible to traverse the metalevel hierarchy to get them
			DummyType nodet = new DummyType(DpfMetamodel.this, "Node");
			DummyType arrowt = new DummyType(DpfMetamodel.this, "Arrow");
			
			dpfModel.typeForNameCache.put(ns + "::" + "Node", nodet);
			dpfModel.typeForNameCache.put(ns + "::" + "Arrow", arrowt);
			
			metaModelCache.get(spec);
			metaModelCache.get(spec.getGraph());
			for(Node n : spec.getGraph().getNodes()) {
				metaModelCache.get(n);
			}
			for(Arrow a : spec.getGraph().getArrows()) {
				metaModelCache.get(a);
			}
			for(Constraint c : spec.getGraph().getConstraints()) {
				metaModelCache.get(c);
			}
			
			specifications.put(namespace, spec);
		}
		
		public Specification getMetaModelSpec() {
			//Needs to be properly implemented to support multiple namespaces.
			return specifications.get(NS_PREFIX);
		}
		
		public Type getXpandTypeForDpfType(Object key) {
			return metaModelCache.get(key);
		}
		
		public Collection<Type> getXpandTypes() {
			return metaModelCache.getValues();
		}
		
//		public Collection<Object> getDpfTypes() {
//			return metaModelCache.getKeys();
//		}
		
		public boolean dpfTypeExists(Object obj) {
			return metaModelCache.exists(obj);
		}
	}
	private class InternalModel {
		
		private String ns = NS_PREFIX;
		private Specification model = null;
		
		/** Contains a dpf model (instance) type to Xpand type mapping. */
		private Cache<Object, Type> modelCache = new Cache<Object, Type>() {
			
			@Override
			protected Type createNew(Object obj) {
//				log.debug("cache#createNew: " + obj);
//				if(obj instanceof Specification) {
//					return dpfMetaModel.getXpandTypeForDpfType(obj);
//				} else if(obj instanceof Graph) {
//					return dpfMetaModel.getXpandTypeForDpfType(obj);
//				} else if(obj instanceof Node) {
//					return dpfMetaModel.getXpandTypeForDpfType(((Node)obj).getTypeNode());
//				} else if(obj instanceof Arrow) {
//					return dpfMetaModel.getXpandTypeForDpfType(((Arrow)obj).getTypeArrow());
//				} else if(obj instanceof Constraint) {
//					return dpfMetaModel.getXpandTypeForDpfType(obj);
//				} else if(obj instanceof Predicate) {
//					return dpfMetaModel.getXpandTypeForDpfType(obj);
//				}
//				return null;
				log.debug("cache#createNew: " + obj);
				if(obj instanceof Specification) {
					return new SpecificationType(DpfMetamodel.this, ns + "::" + SPECIFICATION , (Specification)obj);
				} else if(obj instanceof Graph) {
					return new GraphType(DpfMetamodel.this, ns + "::" + ((Graph)obj).getName(), (Graph)obj);
				} else if(obj instanceof Node) {
					return new NodeType(DpfMetamodel.this, ns + "::" + ((Node)obj).getName(), (Node)obj, dpfMetaModel.getXpandTypeForDpfType(((Node)obj).getTypeNode()));
				} else if(obj instanceof Arrow) {
					return new ArrowType(DpfMetamodel.this, ns + "::" + ((Arrow)obj).getName(), (Arrow)obj, dpfMetaModel.getXpandTypeForDpfType(((Arrow)obj).getTypeArrow()));
				} else if(obj instanceof Constraint) {
					return new ConstraintType(DpfMetamodel.this, ns + "::" + CONSTRAINT, (Constraint)obj);
				} else if(obj instanceof Predicate) {
					return new PredicateType(DpfMetamodel.this, ns + "::" + PREDICATE , (Predicate)obj);
				}
				return null;
			}
		};
//	
//		/** Contains a string to Xpand Type mapping */
//		private Cache<String, Type> typeForNameCache2 = new Cache<String, Type>() {
//			
//			@Override
//			protected Type createNew(String str) {
//				//Finn namnet på typen, må strippa vekk namespace
//				int i = str.indexOf("::");
//				String typeDefinition = str;
//				if(i != -1) {
//					typeDefinition = str.substring(i+2);
//				}
//				log.debug("typeForNameCache#createNew: " + typeDefinition);
//					
//				if(model == null) log.debug("typeForNameCache: spec is null");
//					
//				Object key = getDpfMetaModelTypeForTypeName(typeDefinition);
//					
//				//If we already have registered the type
//				if(key != null) {
//					return dpfMetaModel.getXpandTypeForDpfType(key);
//				} else {
//					//We need to register the proper type
//					//Should only return a valid dsm type.
//					key = getGraphElementForName(typeDefinition);
//					//FIXME: Workaround: The ecore specific code needs to get nodenames/nodes from dsm. When building the collections
//					//we need to return a typenode. Hence we create a new method.
//					if(!dpfMetaModel.dpfTypeExists(key) || key == null) {
//						key = getMetaModelTypeForModelName(typeDefinition);
//					}
//					if(key != null) 
//						return dpfMetaModel.getXpandTypeForDpfType(key);
//				}
//	
//				//returnerer antakeligvis null dersom namespace
//				log.debug("getTypeForName#createNew: returned null");	
//				return null;
//			}
//		};
		
		/** Contains a string to Xpand Type mapping */
		private Cache<String, Type> typeForNameCache = new Cache<String, Type>() {
			
			@Override
			protected Type createNew(String str) {
				int i = str.indexOf("::");
				String typeDefinition = str;
				if(i != -1) {
					typeDefinition = str.substring(i+2);
				}
				
				//MetaModel
				if(typeDefinition.equals(IDOBJECT)) {
					return null; //We dont handle this
				} else if(typeDefinition.equals(SPECIFICATION)) {
					return dpfMetaModel.getXpandTypeForDpfType(dpfMetaModel.getMetaModelSpec());
				}else if(typeDefinition.equals(PREDICATE)) {
					try {
						return dpfMetaModel.getXpandTypeForDpfType(dpfMetaModel.getMetaModelSpec().getGraph().getConstraints().get(0).getPredicate());
					} catch(NullPointerException e) {
						return null; //We dont handle the PREDICATE type
					}
				} else if(typeDefinition.equals(GRAPH)) {
					return dpfMetaModel.getXpandTypeForDpfType(dpfMetaModel.getMetaModelSpec().getGraph());
				} else if(typeDefinition.equals(CONSTRAINT)) {
					//Only to ID the ConstraintType in metamodel.
					try {
						return dpfMetaModel.getXpandTypeForDpfType(dpfMetaModel.getMetaModelSpec().getGraph().getConstraints().get(0));
					} catch(NullPointerException e) {
						return null; //We dont handle the CONSTRAINT type
					}
				}
				
				Object key = getSpecificationTypeForName(dpfMetaModel.getMetaModelSpec(), typeDefinition);
				if(key != null && dpfMetaModel.dpfTypeExists(key)) {
					return dpfMetaModel.getXpandTypeForDpfType(key);
				} 
				
				//We try to retrieve from model. Is not instantiated before workflow is executed.
				try {
					key = getSpecificationTypeForName(model, typeDefinition);
					if(key != null && modelCache.exists(key)) {
						return modelCache.get(key);
					}
				} catch (NullPointerException e) {
					return null;
				}
				log.debug("getTypeForName#createNew: tried to resolve " + str + ", returned null");	
				return null;
			}
		};
		
		private Object getSpecificationTypeForName(Specification s, String name) {
			for(Node n : s.getGraph().getNodes()) {
				if(n.getName().equals(name)) {
					return n;
				}
			}
			for(Arrow a : s.getGraph().getArrows()) {
				if(a.getName().equals(name)) {
					return a;
				}
			}
			return null;
		}
		
		/** A collection that holds all instances of a meta model type */
		private Cache<String, List<Object>> metaModelTypeCollections = new Cache<String, List<Object>>() {

			@Override
			protected List<Object> createNew(String typeId) {
				//Dersom vi finn ein korresponderande type i DSM'en, lagar vi ein collection med alle instansar av den typen
				log.debug("Creating type collection: " + typeId);
				List<Object> res = new ArrayList<Object>();
				
				for(Node n : model.getGraph().getNodes()) {
					if(n.getTypeNode().getId().equals(typeId)) {
						res.add(n);
					}
				}
				for(Arrow a : model.getGraph().getArrows()) {
					if(a.getTypeArrow().getId().equals(typeId)) {
						res.add(a);
					}
				}
				return res;
			}
		};
		
//		private Object getMetaModelTypeForModelName(String name) {
//			log.debug("getDsmTypeForInstanceName: trying to find Graph element with name: " + name);
//			//This method should map a instance type to a type specified in the DSM
//			//TODO: Also there should be some validation that the type is actually in the DSM, and not just extract the type node of the instance like now.
//			if(model != null) {
//				if(name.equals(SPECIFICATION)) {
//					log.debug("createNewTypeForName: Specification called. This makes stuff fucky");
//					return model;
//				} else {
//					if(name.equals(GRAPH)) {
//						return model.getGraph();
//					} else {
//						for(Node n : model.getGraph().getNodes()) {
//							if(name.equals(n.getName())) { 
//								return n.getTypeNode(); //We return an object which is in the DSM.
//							}
//						}
//						for(Arrow a : model.getGraph().getArrows()) {
//							if(name.equals(a.getName())) { 
//								return a.getTypeArrow();
//							}
//						}
//					}
//				}
//			}
//			return null;
//		}
		
		//FIXME: Horrible code. Vi sjekkar jo berre base types... det er useless.
		//Used to find the first object with proper type to associate a type string with the proper Xpand Type in typeForNameCache
		/**
		 * Gets the DPF core instance object that is the key for {@link InternalMetaModel#metaModelCache}.
		 * We need this in getTypeForNameCache to identify that a DPF object, ie. Node is of type node, 
		 * which in it's turn is associated with the correct Xpand type.
		 * 
		 * @param k
		 *            String that contains name of base dpf type
		 * @return Object Returns the Object key (DPF core instance object) from dsmCache
		 */
//		private Object getDpfMetaModelTypeForTypeName(String k) {
//			for(Object o : dpfMetaModel.getDpfTypes()) {
//				if(k.equals(SPECIFICATION)) {
//					if(o instanceof Specification) {
//						return o;
//					}
//				} else if(k.equals(GRAPH)) {
//					if(o instanceof Graph) {
//						return o;
//					}
//				} else if(k.equals(NODE)) {
//					if(o instanceof Node) {
//						return o;
//					}
//				} else if(k.equals(ARROW)) {
//					if(o instanceof Arrow) {
//						return o;
//					}
//				} else if(k.equals(CONSTRAINT)) {
//					if(o instanceof Constraint) {
//						return o;
//					}
//				} else if(k.equals(PREDICATE)) {
//					if(o instanceof Predicate) {
//						return o;
//					}
//				}
//			}
//			return null;
//		}
		
//		private Object getGraphElementForName(String name) {
//			//This method is fugly and is used to retrieve a valid dpf object, which is identifying the proper 
//			//object to do a lookup on in InternalMetaModel#metaModelCache.
//			log.debug("getGraphElementForName: trying to find Graph element with name: " + name);
//			
//			Specification mm = dpfMetaModel.getMetaModelSpec();
//			
//			if(mm != null) {
//				if(name.equals(SPECIFICATION)) {
//					log.debug("createNewTypeForName: Specification called. This makes stuff fucky");
//					return mm;
//				} else {
//					if(name.equals(GRAPH)) {
//						return mm.getGraph();
//					} else {
//						for(Node n : mm.getGraph().getNodes()) {
//							if(name.equals(n.getName())) { 
//								return n;
//							}
//						}
//						for(Arrow a : mm.getGraph().getArrows()) {
//							if(name.equals(a.getName())) { 
//								return a;
//							}
//						}
//					}
//				}
//			}
//			return null;
//		}
		
		public InternalModel() {
			
		}
		
//		public Type getModelType(Object key) {
//			return modelCache.get(key);
//		}
		
		public void setDpfModel(String namespace, Specification model) {
			this.model = model;
			ns = namespace;

			//Collections of model types conforming to metamodel type
			for(Node n : dpfMetaModel.getMetaModelSpec().getGraph().getNodes()) {
				metaModelTypeCollections.get(n.getId());
			}
			
			for(Arrow a : dpfMetaModel.getMetaModelSpec().getGraph().getArrows()) {
				metaModelTypeCollections.get(a.getId());
			}
			
			//Model mappings
			typeForNameCache.put(ns + "::" + SPECIFICATION, dpfMetaModel.getXpandTypeForDpfType(model));
			typeForNameCache.put(ns + "::" + GRAPH, dpfMetaModel.getXpandTypeForDpfType(dpfMetaModel.getMetaModelSpec().getGraph()));
			
			for(Node n : model.getGraph().getNodes()) {
				modelCache.get(n);
			}
			
			for(Arrow a : model.getGraph().getArrows()) {
				modelCache.get(a);
			}
		}
		
		public Type getTypeForName(String name) {
//			System.out.println("TYPE FOR NAME : " + name);
			int i = name.indexOf("::");
			String typeDefinition = name;
			if(i == -1) {
				typeDefinition = ns + "::" + name;
			}
			Type ret = typeForNameCache.get(typeDefinition);
//			if(ret == null) System.out.println("ret NULL");
			return ret;
//			Type ret2 = typeForNameCache2.get(name);
//			if(ret2 == null) System.out.println("ret2 NULL");
//			
//			return ret2;
		}
		
		public List<Object> getMetaModelTypeCollections(String typeId) {
			return metaModelTypeCollections.get(typeId);
		}
	}
	
	private class InternalEcoreHelper {
		private HashSet<EClassifier> stringTypes;

		private HashSet<EClassifier> intTypes;

		private HashSet<EClassifier> realTypes;

		private HashSet<EClassifier> booleanTypes;

		private HashSet<EClassifier> objectTypes;

		private HashSet<EClassifier> listTypes;
		
		public InternalEcoreHelper() {
			initializeKnownETypes();
		}
		
		public Type getTypeForETypedElement(ETypedElement typedElement) {
			//We need to map the pre-defined EStructuralFeatures (the ones specified in the DPF ecore metamodel.
			//This is an attempt on making things as generic as possible. Allthough it will probably break if names change in the metamodel
			log.debug("getTypeForETypedElement:");
			if(typedElement.getEType() == null) {
				return ts.getVoidType();
			}
			
			Type t = null;
			EClassifier classifier = typedElement.getEType();
			
			// TODO: These should return metametamodel types (dpf ecore), right now returns dsm types.
			if(classifier.getName().equals(GRAPH)) {
				t = getTypeForName(NS_PREFIX + "::" + GRAPH);
			}  else if(classifier instanceof EDataType) {
				//This resolves an "external" datatype used in the DPF ecore. This means other classes than the EClasses provided by ecore.
				
				//Java "primitive" datatypes which are resolved from the dpf ecore, will be retrieved using
				//javabeans metamodel, but should be handled by the Xpand typesystem.
				if (ts != null) {
					if (stringTypes.contains(classifier)) {
						return ts.getStringType();
					}
					else if (booleanTypes.contains(classifier)) {
						return ts.getBooleanType();
					}
					else if (intTypes.contains(classifier)) {
						return ts.getIntegerType();
					}
					else if (realTypes.contains(classifier)) {
						return ts.getRealType();
					}
					else if (objectTypes.contains(classifier)) {
						return ts.getObjectType();
					}
					else if (listTypes.contains(classifier)) {
						return new EmfListType(ts.getObjectType(), ts, BuiltinMetaModel.LIST);
					}
				}
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
					log.debug("EGenericType: " + typedElement.getEGenericType());
						//Linje 359-373 EmfRegistryMM... sjekk på om baseType har verdi eller om det er gyldig listetype
					t = getTypeForEClassifier(typedElement.getEGenericType()); //Void type?
				} else {
					t = getTypeSystem().getTypeForName(typedElement.getEType().getName());
					//TODO: See getFullyQualifiedName()
				}
			}
			if(t == null) log.debug("getTypeForETypedElement failed: " + typedElement.getEType());
			
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

			return dpfMetaModel.getXpandTypeForDpfType(element);
		}
		
		public Type getTypeForEClassifier(final EClassifier element) {
			if (element == null) {
				return getTypeSystem().getVoidType();
			}
			log.debug("getTypeForEClassifier#name: " + element.getName());
			return getTypeForName(NS_PREFIX + "::" + element.getName());
		}
		
		/**
		 * Contains a lists over the different Ecore types we want the Xpand typesystem to handle.
		 * If this isnt checked, the Java Beans MetaModel is called, and we will only get plain Java functionality.
		 */
		private void initializeKnownETypes() {
			stringTypes = new HashSet<EClassifier>();
			stringTypes.add(EcorePackage.eINSTANCE.getEString());
			stringTypes.add(EcorePackage.eINSTANCE.getEChar());
			stringTypes.add(EcorePackage.eINSTANCE.getECharacterObject());

			booleanTypes = new HashSet<EClassifier>();
			booleanTypes.add(EcorePackage.eINSTANCE.getEBoolean());
			booleanTypes.add(EcorePackage.eINSTANCE.getEBooleanObject());

			intTypes = new HashSet<EClassifier>();
			intTypes.add(EcorePackage.eINSTANCE.getEInt());
			intTypes.add(EcorePackage.eINSTANCE.getEIntegerObject());
			intTypes.add(EcorePackage.eINSTANCE.getELong());
			intTypes.add(EcorePackage.eINSTANCE.getELongObject());
			intTypes.add(EcorePackage.eINSTANCE.getEShort());
			intTypes.add(EcorePackage.eINSTANCE.getEShortObject());
			intTypes.add(EcorePackage.eINSTANCE.getEByte());
			intTypes.add(EcorePackage.eINSTANCE.getEByteObject());
			intTypes.add(EcorePackage.eINSTANCE.getEBigInteger());

			realTypes = new HashSet<EClassifier>();
			realTypes.add(EcorePackage.eINSTANCE.getEFloat());
			realTypes.add(EcorePackage.eINSTANCE.getEFloatObject());
			realTypes.add(EcorePackage.eINSTANCE.getEDouble());
			realTypes.add(EcorePackage.eINSTANCE.getEDoubleObject());
			realTypes.add(EcorePackage.eINSTANCE.getEBigDecimal());

			objectTypes = new HashSet<EClassifier>();
			objectTypes.add(EcorePackage.eINSTANCE.getEJavaObject());

			listTypes = new HashSet<EClassifier>();
			listTypes.add(EcorePackage.eINSTANCE.getEEList());
		}
	}
}
