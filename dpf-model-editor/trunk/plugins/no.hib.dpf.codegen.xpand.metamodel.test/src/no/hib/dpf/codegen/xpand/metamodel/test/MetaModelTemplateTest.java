package no.hib.dpf.codegen.xpand.metamodel.test;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MetaModelTemplateTest {
	private DpfXpandRunner runner;
//	private ByteArrayOutputStream sysOut = new ByteArrayOutputStream();
	private ByteArrayOutputStream sysErr = new ByteArrayOutputStream();
	private static HashMap<String, List<String>> res = new HashMap<String, List<String>>();
	
	@Before
	public void setUp() {
		runner = new DpfXpandRunner();
//		System.setOut(new PrintStream(sysOut));
		System.setErr(new PrintStream(sysErr));
		
		runner.run("", 
				"resources/domainModel/metamodel.xmi", 
				"resources/domainModel/nodearrowcollection/model.xmi",
				"resources::domainModel::nodearrowcollection::nac::main");
//		System.out.println(sysErr.toString());
		String[] lines = sysErr.toString().split("\n");
		String s = lines[0];
		
		for(int i = 0; i < lines.length; ++i) {
			s = lines[i];
			if(s.contains("START")) {
				String tcname = s.substring(s.lastIndexOf("(") + 1, s.lastIndexOf(")"));
				ArrayList<String> etmp = new ArrayList<String>();
				
				s = lines[++i];
				while(!s.contains("END")) {
					etmp.add(s);
					s = lines[++i];
				}
				res.put(tcname, etmp);
			}
		}
	}
	
	@Test
	public void listAllModelConstraints() {
		List<String> tmp = res.get("Constraint");
		assertEquals(4, tmp.size());
		assertTrue(tmp.contains("089f1d90-78ea-4196-82e0-f29591898e37"));
		assertTrue(tmp.contains("28fbe8a7-8dc1-43af-89d0-042fa2399d73"));
		assertTrue(tmp.contains("6a418cfb-a6e4-4963-a539-8399f4a0112e"));
		assertTrue(tmp.contains("b1f7804d-4d7e-46e2-8c7c-c1c5e252963f"));
	}
	
	@Test
	public void listingNodeTypeRetrievesAllNodes() {
		List<String> tmp = res.get("Node");
		assertEquals(7, tmp.size());
		assertTrue(tmp.contains("D1"));
		assertTrue(tmp.contains("D2"));
		assertTrue(tmp.contains("D3"));
		assertTrue(tmp.contains("P1"));
		assertTrue(tmp.contains("T1"));
		assertTrue(tmp.contains("T2"));
		assertTrue(tmp.contains("T3"));
	}
	
	@Test
	public void listingDomainClassTypeRetrievesOnlyDomainClassNodes() {
		List<String> tmp = res.get("DomainClass");
		assertEquals(3, res.size());
		assertTrue(tmp.contains("D1"));
		assertTrue(tmp.contains("D2"));
		assertTrue(tmp.contains("D3"));
	}
	
	@Test
	public void retrieveArrowWhenNodeHasSameName() {
		
	}
	
	@After
	public void tearDown() {
		System.setOut(null);
		System.setErr(null);
	}
	
//	@SuppressWarnings("rawtypes")
//	private Matcher matchTypesName(final String expected) {
//		
//		return new BaseMatcher() {
//			@Override
//			public boolean matches(Object item) {
//				if(item instanceof List) {
//					@SuppressWarnings("unchecked")
//					List<String> = (List<String>)item;
//					for(Type t : tmp) {
//						if(t.getName().equals(expected)) {
//							return true;
//						}
//					}
//				} 
//				return false;
//			}
//
//			@Override
//			public void describeTo(Description description) {
//				description.appendText(expected);
//			}
//		};
//	}
}
