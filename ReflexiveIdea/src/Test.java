import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import morphism.Morphism;
import morphism.MorphismFactory;
import morphism.NodeMapping;
import morphism.ReferenceMapping;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

public class Test {

	//Var:
	final static ResourceSet resourceSet = new ResourceSetImpl();
	static{
		// Register XMI resource factory
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("*",new XMIResourceFactoryImpl());
	}
	final static Map<String,Integer> dynamicNames = new HashMap<String,Integer>(); 

	public static void main(String[] args) throws Exception{
		
		//Model:
		System.out.println("Test: Model");
		
		//Load:
		final Resource rs = loadModel("MyDpf.ecore");

		//Iterate over all objects:
		for(EObject o:iterator(rs)){
			//System.out.println("model:>" +o);
		}

//--------------------------------------------------------------		
		
		//Instance:
		System.out.println("Test: Instance");

		//Register Model-Factory:
		registerEcoreModel(rs);
		
		//Load:
		final Resource rs2 = loadModel("My.dpf");
		
		//Iterate over all objects:
		for(EObject o:iterator(rs2)){
			//System.out.println("instance:>" + o);
		}
		
		//Instance 2 Ecore-Model:
		instance2model(rs2);

//--------------------------------------------------------------		
		
		//Instance2:
		System.out.println("Test: Instance");

		//Register Model-Factory:
		registerEcoreModel(loadModel("Triangle.ecore"));

		//Load:
		final Resource rs3 = loadModel("My.triangle");
		
		//Instance 2 Ecore-Model:
		EPackage rsEcore3 = instance2model(rs3);
		
		System.out.println("YoYo");
	}

	private static void registerEcoreModel(final Resource rs) {
		EPackage p = (EPackage)rs.getContents().get(0);
		//EFactory instanceFactory =  p.getEFactoryInstance();
		resourceSet.getPackageRegistry().put(p.getNsURI(), p);
	}
	
	
	private static Iterable<EObject> iterator(final Resource rs) {
		return new Iterable<EObject>() {
			public TreeIterator<EObject> iterator() {
				return rs.getAllContents();
			};
		};
	}

	private static Resource loadModel(final String fileName) {
		final String f = new File(".").getAbsolutePath() + "/model/" + fileName;
		URI fileURI2 = URI.createFileURI(f);
		final Resource rs = resourceSet.getResource(fileURI2, true);
		return rs;
	}
	
	private static void saveEcore2File(EPackage rsEcore) throws IOException {
		final String f = new File(".").getAbsolutePath() + "/model/" + firstLetter2UpperCase(rsEcore.getName()) + ".ecore";
		final URI fileURI = URI.createFileURI(f);
		final Resource nRs = resourceSet.createResource(fileURI);
		nRs.getContents().add(rsEcore);
		nRs.save(null);
	}
	
	
	@SuppressWarnings("unchecked")
	private static EPackage instance2model(final Resource rs) throws IOException{
		
		//Vars:
		EcoreFactory ecoreFactory = EcoreFactory.eINSTANCE;
		EcorePackage ecorePackage = EcorePackage.eINSTANCE;
		
		//LiftUp-Mapping (between same models)
		final Map<EObject,EClass> mapping = new HashMap<EObject,EClass>(); 
		
		//Mappings for typing Homomorphism:
		final Map<EClass,List<EClass>> mappingNodes = new HashMap<EClass,List<EClass>>();
		final Map<EReference,List<EReference>> mappingReferences = new HashMap<EReference,List<EReference>>();

		EPackage ePackage = null;
		EClass container = null;
		for(EObject o:iterator(rs)){

			//First Element -> EPackage and EClass as Container
			//
			//Attribute "name" is added	
			if(null == ePackage){
				final String name = getName(o).toLowerCase();
				
				//Create package:
				ePackage = ecoreFactory.createEPackage();
				ePackage.setName(name);
				ePackage.setNsURI(name);
				ePackage.setNsPrefix(name);
				
				//Create container:
				container = ecoreFactory.createEClass();
				container.setName(firstLetter2UpperCase(name));
				ePackage.getEClassifiers().add(container);
				mapping.put(o, container);
				
				addMapping(o.eClass(),container,mappingNodes);
				
				//Add nameAttribute:
				container.getEStructuralFeatures().add(createNameAttribute(ecoreFactory, ecorePackage));
				
			//All other XML-Child-Nodes:
			//Node -> EClass 
			//EAttributes and EOperations are ignored because it makes no sense to map them!
			//
			//Attribute "name" is added	
			}else{
				EClass nC = ecoreFactory.createEClass();
				nC.setName(firstLetter2UpperCase(getName(o)));
				ePackage.getEClassifiers().add(nC);
				mapping.put(o, nC);
				
				addMapping(o.eClass(),nC,mappingNodes);
				
				//Add nameAttribute:			
				nC.getEStructuralFeatures().add(createNameAttribute(ecoreFactory,ecorePackage));
			}
		}

		//EReference: -> EReference
		for(EObject o:mapping.keySet()){
			for(EStructuralFeature s:o.eClass().getEStructuralFeatures()){
				if(s instanceof EReference){

					final EReference srcR = (EReference)s;

					//to One:
					if(o.eGet(srcR) instanceof EObject){

						final EReference tarR = createEReference(ecoreFactory, mapping, o, srcR);
						tarR.setEType(mapping.get(o.eGet(srcR))); //Arrow-Target

						//Save Mapping:
						addMapping(srcR, tarR, mappingReferences);
					}

					//to Many:
					else if (o.eGet(srcR) instanceof EList<?>){
						for(EObject ts: (EList<EObject>)o.eGet(srcR)){
						
							final EReference tarR = createEReference(ecoreFactory, mapping, o, srcR);
							tarR.setEType(mapping.get(ts)); //Arrow-Target

							//Save Mapping:
							addMapping(srcR, tarR, mappingReferences);
						}
					}
					
				}
			}
		}
		
		//Save Resource:
		saveEcore2File(ePackage);

		//Save Type-Morphism:
		saveTypeMorphism(container.getName(), mappingNodes,mappingReferences);
		
		return ePackage;
	}
	
	private static EAttribute createNameAttribute(EcoreFactory ecoreFactory, EcorePackage ecorePackage) {
		EAttribute nameAttr = ecoreFactory.createEAttribute();
		nameAttr.setName("name");
		nameAttr.setEType(ecorePackage.getEString());
		return nameAttr;
	}

	private static EReference createEReference(
			final EcoreFactory ecoreFactory,
			final Map<EObject,EClass> mapping, 
			final EObject o, 
			final EReference srcR) {
		final EReference tarR = ecoreFactory.createEReference();
		tarR.setName(getReferenceName(srcR));
		tarR.setContainment(srcR.isContainment());
		tarR.setLowerBound(srcR.getLowerBound());
		tarR.setUpperBound(srcR.getUpperBound());
		mapping.get(o).getEStructuralFeatures().add(tarR); //Arrow-Src
		return tarR;
	}

	private static String getName(EObject o) {
		String name = null;
		for(EAttribute a:o.eClass().getEAllAttributes()){
			if(a.getName().equals("name")){
				Object value = o.eGet(a);
				if(null != value){
					name = value.toString();
				}
				break;
			}
		}
		if(null == name){
			name = generateDynamicName(o.eClass());
		}
		return name;
	} 

	private static String generateDynamicName(ENamedElement c){
		int no = 1;
		if(dynamicNames.containsKey(c.getName())){
			no=dynamicNames.get(c.getName())+1;
		}	
		dynamicNames.put(c.getName(), no);
		return c.getName() + "_" + no;
	}


	private static String getReferenceName(final EReference srcR) {
		if(1 <= srcR.getUpperBound()){
			return srcR.getName();
		}else{
			return generateDynamicName(srcR);						
		}
	}
	
	public static String firstLetter2UpperCase(final String name){
		return name.toUpperCase().substring(0,1) + name.substring(1);
	}
	
	
	private static <T> void addMapping(T src, T tar, Map<T,List<T>> container) {
		if(container.containsKey(src)){
			container.get(src).add(tar);
		}else{
			final List<T> l = new LinkedList<T>();
			l.add(tar);
			container.put(src,l);
		}
	}

	private static void saveTypeMorphism(final String name, final Map<EClass,List<EClass>> nodes, final Map<EReference,List<EReference>> edges) throws IOException {

		MorphismFactory factory = MorphismFactory.eINSTANCE;
		Morphism container = factory.createMorphism();

		//Add all nodes:
		for(Map.Entry<EClass, List<EClass>> e:nodes.entrySet()){
			NodeMapping nm = factory.createNodeMapping();
			nm.setSrc(e.getKey());
			nm.getTar().addAll(e.getValue());
			container.getNodeMappings().add(nm);
		}
		
		//Add all edges:
		for(Map.Entry<EReference, List<EReference>> e:edges.entrySet()){
			ReferenceMapping rm = factory.createReferenceMapping();
			rm.setSrc(e.getKey());
			rm.getTar().addAll(e.getValue());
			container.getReferenceMappings().add(rm);
		}
		
		//Save:
		final String f = new File(".").getAbsolutePath() + "/model/morphism/" + firstLetter2UpperCase(name) + ".morphism";
		final URI fileURI = URI.createFileURI(f);
		final Resource nRs = resourceSet.createResource(fileURI);
		nRs.getContents().add(container);
		nRs.save(null);

	}
	
}
