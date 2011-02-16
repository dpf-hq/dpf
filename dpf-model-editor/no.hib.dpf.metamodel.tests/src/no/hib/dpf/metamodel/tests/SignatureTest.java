/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package no.hib.dpf.metamodel.tests;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import no.hib.dpf.metamodel.MetamodelFactory;
import no.hib.dpf.metamodel.Predicate;
import no.hib.dpf.metamodel.Signature;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Signature</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link no.hib.dpf.metamodel.Signature#save(org.eclipse.emf.common.util.URI) <em>Save</em>}</li>
 *   <li>{@link no.hib.dpf.metamodel.Signature#getPredicateBySymbol(java.lang.String) <em>Get Predicate By Symbol</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class SignatureTest extends TestCase {

	/**
	 * The fixture for this Signature test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Signature fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(SignatureTest.class);
	}

	/**
	 * Constructs a new Signature test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SignatureTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Signature test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(Signature fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Signature test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Signature getFixture() {
		return fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(MetamodelFactory.eINSTANCE.createSignature());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 * @generated
	 */
	@Override
	protected void tearDown() throws Exception {
		setFixture(null);
	}

	/**
	 * Tests the '{@link no.hib.dpf.metamodel.Signature#save(org.eclipse.emf.common.util.URI) <em>Save</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hib.dpf.metamodel.Signature#save(org.eclipse.emf.common.util.URI)
	 * @generated
	 */
	public void testSave__URI() {
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link no.hib.dpf.metamodel.Signature#getPredicateBySymbol(java.lang.String) <em>Get Predicate By Symbol</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hib.dpf.metamodel.Signature#getPredicateBySymbol(java.lang.String)
	 * @generated NOT
	 */
	public void testGetPredicateBySymbol__String() {
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT
		Predicate p1 = MetamodelFactory.eINSTANCE.createPredicate("p1", "n_1,n_2,n_3", "e_1:n_1:n_2,e_2:n_1:n_3");
		getFixture().getPredicates().add(p1);
		Predicate p2 = MetamodelFactory.eINSTANCE.createPredicate("p2", "n_1,n_2", "e_1:n_1:n_2");
		getFixture().getPredicates().add(p2);
		
		assertEquals(p2, getFixture().getPredicateBySymbol("p2"));
		assertEquals(p1, getFixture().getPredicateBySymbol("p1"));
		assertEquals(null, getFixture().getPredicateBySymbol("p3"));
	}

} //SignatureTest
