package no.hib.dpf.codegen.xpand.metamodel.test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.Set;

import no.hib.dpf.codegen.xpand.metamodel.DpfMetamodel;
import no.hib.dpf.codegen.xpand.metamodel.typesystem.types.*;
import no.hib.dpf.core.CoreFactory;
import no.hib.dpf.core.Specification;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtend.typesystem.Type;
import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.core.Is;
import org.junit.*;

public class MetaModelTest {
	String modelPath = "resources/model.dpf.xmi";
	String metaModelPath = "resources/test.dpf.xmi";
	Specification model, metamodel;
	DpfMetamodel mm;
	
	@Before
	public void setUp() {
		try {
			model = CoreFactory.eINSTANCE.loadSpecification(URI.createURI(modelPath));
			metamodel = CoreFactory.eINSTANCE.loadSpecification(URI.createURI(metaModelPath));
		} catch (IOException e) {
			e.printStackTrace();
		}
		mm = new DpfMetamodel();
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void metaModelLoaded() {
		mm.addDpfMetaModel(metamodel);
		Set<Type> res = mm.getKnownTypes();
		//These types should be inside the metamodel.
		assertThat(res, matchTypeName("dpf::DomainClass"));
		assertThat(res, matchTypeName("dpf::Type"));
		assertThat(res, matchTypeName("dpf::Attribute"));
		assertThat(res, matchTypeName("dpf::Package"));
		assertThat(res, matchTypeName("dpf::Controller"));
		assertThat(res, matchTypeName("dpf::Reference"));
		assertThat(res, matchTypeName("dpf::hasAction"));
		assertThat(res, matchTypeName("dpf::operatesOn"));
		assertThat(res, matchTypeName("dpf::classBelongsTo"));
		assertThat(res, matchTypeName("dpf::controllerBelongsTo"));
		assertThat(res, matchTypeName("dpf::Action"));
		assertThat(res, matchTypeName("dpf::hasAction"));
		//Last two are Node and Arrow
		assertTrue("Expected 14, got " + res.size(), res.size() == 14);
	}
	
	//Internal types should not be exported, and this creates a problem when 
	//running tests in a separate classloader.
	@Test
	public void modelLoaded() {
		//BROKEN TEST -> somehow it returns null::Specification
		Type tt = mm.getType(model);
		Type t = mm.getTypeForName("posts");
		assertTrue("Expected proper type with name dpf::Reference, got " + t.getName(),
				t instanceof Type && t.getName().equals("dpf::Reference"));
		t = null;
		t = mm.getTypeForName("Tag");
		assertTrue("Expected proper type with name dpf::DomainClass, got " + t.getName(),
				t instanceof Type && t.getName().equals("dpf::Reference"));
	}
	
	@Test
	public void getTypeForNameReturnsProperType() {
		Type t = mm.getTypeForName("dpf::DomainClass");
		assertTrue("Expected proper type with name dpf::DomainClass, got " + t.getName(),
				 t instanceof Type && t.getName().equals("dpf::DomainClass"));
	}
	
	@SuppressWarnings("rawtypes")
	private Matcher matchTypeName(final String expected) {
		
		return new BaseMatcher() {
			@Override
			public boolean matches(Object item) {
				if(item instanceof Set) {
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
