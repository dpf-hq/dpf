package no.hib.dpf.codegen.xpand.metamodel.test;

import static org.junit.Assert.*;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import no.hib.dpf.codegen.xpand.metamodel.DpfMMConstants;
import no.hib.dpf.codegen.xpand.metamodel.DpfMetamodel;
import no.hib.dpf.core.Constraint;
import no.hib.dpf.core.Node;
import no.hib.dpf.core.Specification;
import no.hib.dpf.utils.DPFCoreUtil;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtend.typesystem.Type;
import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.junit.*;

public class MetaModelTest {
	String modelPath = "resources/domainModel/model.xmi";
	String metaModelPath = "resources/domainModel/metamodel.xmi";
	Specification model, metamodel;
	DpfMetamodel mm;
	
	@Before
	public void setUp() {
		model = DPFCoreUtil.loadSpecification(URI.createURI(modelPath));
		metamodel = DPFCoreUtil.loadSpecification(URI.createURI(metaModelPath));
		
		mm = new DpfMetamodel();
		mm.addDpfMetaModel(metamodel);
		mm.setDpfModel(model);
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void metaModelLoaded() {
		Set<Type> res = mm.getKnownTypes();
		//These types should be inside the metamodel.
		assertThat(res, matchTypesName("dpf::Specification"));
		assertThat(res, matchTypesName("dpf::Graph"));
		assertThat(res, matchTypesName("dpf::Node"));
		assertThat(res, matchTypesName("dpf::Arrow"));
		assertThat(res, matchTypesName("dpf::Predicate"));
		assertThat(res, matchTypesName("dpf::Constraint"));
		assertThat(res, matchTypesName("dpf::DomainClass"));
		assertThat(res, matchTypesName("dpf::Type"));
		assertThat(res, matchTypesName("dpf::Attribute"));
		assertThat(res, matchTypesName("dpf::Package"));
		assertThat(res, matchTypesName("dpf::Reference"));
		assertThat(res, matchTypesName("dpf::classBelongsTo"));
		
		assertTrue("Expected 12, got " + res.size(), res.size() == 12);
	}
	
	//Internal types is (and should) not be exported, and this creates a problem when 
	//running tests in a separate classloader.
	@Test
	public void modelLoaded() {
		Type t = mm.getTypeForName("posts");
		assertTrue("Expected proper type with name dpf::posts, got " + t.getName(),
				t instanceof Type && t.getName().equals("dpf::posts"));
		t = null;
		t = mm.getTypeForName("Tag");
		assertTrue("Expected proper type with name dpf::Tag, got " + t.getName(),
				t instanceof Type && t.getName().equals("dpf::Tag"));
	}
	
	@Test
	public void getTypeForNameReturnsProperType() {
		Type t = mm.getTypeForName("dpf::DomainClass");
		assertTrue("Expected proper type with name dpf::DomainClass, got " + t.getName(),
				 t instanceof Type && t.getName().equals("dpf::DomainClass"));
	}
	
	@Test
	public void modelTypeResolvesToProperMetaModelType() {
		//This test should ideally work directly on modelCache, so that we know a model type resolves to a meta model type.
		Type t = mm.getTypeForName("posts");
		assertTrue("Expected that arrow posts has dpf::Reference super type, it did not.", t.getSuperTypes().contains(mm.getTypeForName("dpf::Reference")));
	}
	
	@Test
	public void modelCollectionsReturnsProperly() {
		Node id = metamodel.getGraph().getNodeByName("DomainClass");
		Node expected = model.getGraph().getNodeByName("Post");
		Collection<Object> types = mm.getModelCollections(id.getId());
		assertTrue(types.contains(expected));
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void retrieveConstraints() {
		List<Constraint> clist = model.getConstraints();
		Set<Type> tlist = new HashSet<Type>();
		
		for(Constraint c : clist) {
			tlist.add(mm.getTypeForName(c.getId()));
		}
		assertThat(tlist, matchTypesName(DpfMMConstants.NS_PREFIX + "::e9d1aeaa-ec78-4760-be2b-2187d3d1f96e"));
		assertThat(tlist, matchTypesName(DpfMMConstants.NS_PREFIX + "::5d14cf39-6769-49fb-8cea-7f2364dee8bf"));
		assertThat(tlist, matchTypesName(DpfMMConstants.NS_PREFIX + "::3c44d904-fa09-438c-86d1-b468c86ee940"));
	}
//	@Test
//	public void getTypeForETypedElementReturnsCorrectType() {
//		//This test addresses bug where the ecore specific code in the xpand metamodel will return 
//		//a Node type (the first occurence) even though it is an instance of Node and thus have a type
//		Node fromNode = null, toNode = null;
//		//We retrieve a node which is not first in the list.
//		for(Node nn : metamodel.getGraph().getNodes()) {
//			if(nn.getName().equals("DomainClass")) {
//				fromNode = nn;
//			}
//			if(nn.getName().equals("Package")) {
//				toNode = nn;
//			}
//		}
//		//Xpand types
//		Type expected = mm.getTypeForName("dpf::Package");
//		Type actual = mm.getTypeForETypedElement(fromNode.getArrowto(toNode).eClass().getEStructuralFeature("target"));
//		assertEquals("Expected: " + expected.getName() + " got: " + actual.getName(), 
//				expected, actual);		
//	}
	
	@Test
	public void getArrowCollectionFromNode() {
		
	}
	
	@SuppressWarnings("rawtypes")
	private Matcher matchTypesName(final String expected) {
		
		return new BaseMatcher() {
			@Override
			public boolean matches(Object item) {
				if(item instanceof Set) {
					@SuppressWarnings("unchecked")
					Set<Type> tmp = (Set<Type>)item;
					for(Type t : tmp) {
						if(t.getName().equals(expected)) {
							return true;
						}
					}
				} 
				return false;
			}

			@Override
			public void describeTo(Description description) {
				description.appendText(expected);
			}
		};
	}
}
