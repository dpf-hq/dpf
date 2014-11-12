package tudresden.ocl20.pivot.standalone.example;

import java.io.File;
import java.net.URL;
import java.util.List;

import tudresden.ocl20.pivot.examples.simple.Person;
import tudresden.ocl20.pivot.examples.simple.Professor;
import tudresden.ocl20.pivot.examples.simple.Student;
import tudresden.ocl20.pivot.interpreter.IInterpretationResult;
import tudresden.ocl20.pivot.model.IModel;
import tudresden.ocl20.pivot.modelinstance.IModelInstance;
import tudresden.ocl20.pivot.modelinstancetype.java.internal.modelinstance.JavaModelInstance;
import tudresden.ocl20.pivot.pivotmodel.Constraint;
import tudresden.ocl20.pivot.standalone.facade.StandaloneFacade;
import tudresden.ocl20.pivot.tools.codegen.ocl2java.IOcl2JavaSettings;
import tudresden.ocl20.pivot.tools.codegen.ocl2java.Ocl2JavaFactory;

public class StandaloneDresdenOCLExample {

	final static File simpleModel = new File(
			"resources/model/tudresden/ocl20/pivot/examples/simple/ModelProviderClass.class");
	final static File simpleInstance = new File(
			"resources/modelinstance/tudresden/ocl20/pivot/examples/simple/instance/ModelInstanceProviderClass.class");
	final static File simpleOclConstraints = new File(
			"resources/constraints/simple_allConstraints.ocl");

	public static void main(String[] args) throws Exception {

		StandaloneFacade.INSTANCE.initialize(new URL("file:"
				+ new File("log4j.properties").getAbsolutePath()));

		simple();
	}
	private static void simple() {

		/*
		 * Simple
		 */
		System.out.println();
		System.out.println("Simple Example");
		System.out.println("--------------");
		System.out.println();

		try {
			IModel model = StandaloneFacade.INSTANCE.loadJavaModel(simpleModel);

			// create an empty model instance and put objects into it
			IModelInstance modelInstance = new JavaModelInstance(model);

			Person student = new Student();
			student.setName("Student-work-a-lot");
			student.setAge(23);

			Person prof = new Professor();
			prof.setName("Prof. Invalid");
			prof.setAge(-42);

			modelInstance.addModelInstanceElement(student);
			modelInstance.addModelInstanceElement(prof);

			List<Constraint> constraintList = StandaloneFacade.INSTANCE
					.parseOclConstraints(model, simpleOclConstraints);

			for (IInterpretationResult result : StandaloneFacade.INSTANCE
					.interpretEverything(modelInstance, constraintList)) {
				System.out.println("  " + result.getModelObject() + " ("
						+ result.getConstraint().getKind() + ": "
						+ result.getConstraint().getSpecification().getBody()
						+ "): " + result.getResult());
			}

			IOcl2JavaSettings settings = Ocl2JavaFactory.getInstance()
					.createJavaCodeGeneratorSettings();
			settings.setSourceDirectory("src-gen/simple/");

			System.out.println();
			System.out.println("Generate Java Fragements:");
			System.out.println("-------------------------");

			for (String fragment : StandaloneFacade.INSTANCE.generateJavaCode(
					constraintList, settings)) {
				System.out.println(fragment);
				System.out.println();

			}
			// end for.

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
