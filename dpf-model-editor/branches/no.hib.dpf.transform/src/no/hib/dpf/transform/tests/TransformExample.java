/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package no.hib.dpf.transform.tests;

import no.hib.dpf.core.Arrow;
import no.hib.dpf.core.Node;
import no.hib.dpf.core.Specification;
import no.hib.dpf.transform.Transform;
import no.hib.dpf.transform.TransformFactory;
import no.hib.dpf.transform.util.TransformUtils;
import no.hib.dpf.utils.DPFConstants;
import no.hib.dpf.utils.DPFCoreUtil;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;

/**
 * <!-- begin-user-doc -->
 * A sample utility for the '<em><b>transform</b></em>' package.
 * <!-- end-user-doc -->
 * @generated
 */
public class TransformExample {
	/**
	 * <!-- begin-user-doc -->
	 * Load all the argument file paths or URIs as instances of the model.
	 * <!-- end-user-doc -->
	 * @param args the file paths or URIs.
	 * @generated
	 */
	public static void main(String[] args) {
		Specification Class = DPFCoreUtil.loadSpecification(URI.createFileURI("testModel/ClassMeta.xmi"));
		Specification Table = DPFCoreUtil.loadSpecification(URI.createFileURI("testModel/TableMeta.xmi"));
		Specification joint = TransformUtils.joint(Class, Table);
		Arrow arrow1 = TransformUtils.createMapArrow(joint.getGraph(), "Class", "Table");
//		Arrow arrow2 = TransformUtils.createMapArrow(joint.getGraph(), "DT", "DT");
		EList<Arrow> arrows = new BasicEList<Arrow>();
		EList<Node> nodes = new BasicEList<Node>();
		arrows.add(arrow1);
		nodes.add(arrow1.getSource());
		nodes.add(arrow1.getTarget());
		TransformUtils.createConstraint(joint, arrows, nodes, DPFConstants.DEFAULT_SIGNATURE.getPredicateBySymbol("inj"), null);
		TransformUtils.createConstraint(joint, arrows, nodes, DPFConstants.DEFAULT_SIGNATURE.getPredicateBySymbol("multi"), "min:1;max:1");
//		arrows.clear();
//		arrows.add(arrow2);
//		Constraint bij = TransformUtils.createConstraint(joint, arrows, nodes, new MultiplicityPredicate(), "min:1;max:1");
		DPFCoreUtil.saveSpecification(URI.createFileURI("testModel/JointMeta.xmi"), joint);
		Transform transform = TransformFactory.eINSTANCE.createTransform();
		transform.setSourceMeta(Class);
		transform.setTargetMeta(Table);
		transform.setJointMeta(joint);
		// Create a resource set to hold the resources.
//		//
//		ResourceSet resourceSet = new ResourceSetImpl();
//		
//		// Register the appropriate resource factory to handle all file extensions.
//		//
//		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put
//			(Resource.Factory.Registry.DEFAULT_EXTENSION, 
//			 new XMIResourceFactoryImpl());
//
//		// Register the package to ensure it is available during loading.
//		//
//		resourceSet.getPackageRegistry().put
//			(TransformPackage.eNS_URI, 
//			 TransformPackage.eINSTANCE);
//        
//		// If there are no arguments, emit an appropriate usage message.
//		//
//		if (args.length == 0) {
//			System.out.println("Enter a list of file paths or URIs that have content like this:");
//			try {
//				Resource resource = resourceSet.createResource(URI.createURI("http:///My.transform"));
//				Transform root = TransformFactory.eINSTANCE.createTransform();
//				resource.getContents().add(root);
//				resource.save(System.out, null);
//			}
//			catch (IOException exception) {
//				exception.printStackTrace();
//			}
//		}
//		else {
//			// Iterate over all the arguments.
//			//
//			for (int i = 0; i < args.length; ++i) {
//				// Construct the URI for the instance file.
//				// The argument is treated as a file path only if it denotes an existing file.
//				// Otherwise, it's directly treated as a URL.
//				//
//				File file = new File(args[i]);
//				URI uri = file.isFile() ? URI.createFileURI(file.getAbsolutePath()): URI.createURI(args[i]);
//
//				try {
//					// Demand load resource for this file.
//					//
//					Resource resource = resourceSet.getResource(uri, true);
//					System.out.println("Loaded " + uri);
//
//					// Validate the contents of the loaded resource.
//					//
//					for (EObject eObject : resource.getContents()) {
//						Diagnostic diagnostic = Diagnostician.INSTANCE.validate(eObject);
//						if (diagnostic.getSeverity() != Diagnostic.OK) {
//							printDiagnostic(diagnostic, "");
//						}
//					}
//				}
//				catch (RuntimeException exception) {
//					System.out.println("Problem loading " + uri);
//					exception.printStackTrace();
//				}
//			}
//		}
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * Prints diagnostics with indentation.
	 * <!-- end-user-doc -->
	 * @param diagnostic the diagnostic to print.
	 * @param indent the indentation for printing.
	 * @generated
	 */
	protected static void printDiagnostic(Diagnostic diagnostic, String indent) {
		System.out.print(indent);
		System.out.println(diagnostic.getMessage());
		for (Diagnostic child : diagnostic.getChildren()) {
			printDiagnostic(child, indent + "  ");
		}
	}

} //TransformExample
