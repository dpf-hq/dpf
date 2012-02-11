package no.hib.dpf.codegen.xpand.metamodel.test;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MetaModelTemplateTest {
	private DpfXpandRunner runner;
	private ByteArrayOutputStream sysOut = new ByteArrayOutputStream();
	private ByteArrayOutputStream sysErr = new ByteArrayOutputStream();
	@Before
	public void setUp() {
		runner = new DpfXpandRunner();
//		System.setOut(new PrintStream(sysOut));
		System.setErr(new PrintStream(sysErr));
	}
	
	@Test
	public void retrieveArrowWhenNodeHasSameName() {
		runner.run("", 
				"resources/smodlModel/nameTest/metamodel/testMetamodel.dpf.xmi", 
				"resources/smodlModel/nameTest/model/testModel.dpf.xmi",
				"resources::smodlModel::nameTest::templ::main");
		System.out.println(sysErr.toString());
		assertEquals("Expected no output, got " + sysErr.toString(), "", sysErr.toString());
	}
	
	@After
	public void tearDown() {
		System.setOut(null);
		System.setErr(null);
	}
}

