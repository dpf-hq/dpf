package no.dpf.text.validation.ocl.dresden;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.codehaus.janino.DebuggingInformation;
import org.codehaus.janino.JavaSourceClassLoader;
import org.codehaus.janino.SimpleCompiler;
import org.codehaus.janino.util.resource.MapResourceFinder;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import tudresden.ocl20.pivot.interpreter.IInterpretationResult;
import tudresden.ocl20.pivot.language.ocl.resource.ocl.Ocl22Parser;
import tudresden.ocl20.pivot.language.ocl.resource.ocl.OclReferenceResolveHelperProvider;
import tudresden.ocl20.pivot.language.ocl.staticsemantics.postporcessor.OclReferenceResolveHelper;
import tudresden.ocl20.pivot.model.IModel;
import tudresden.ocl20.pivot.model.metamodel.IMetamodel;
import tudresden.ocl20.pivot.modelinstance.IModelInstance;
import tudresden.ocl20.pivot.modelinstancetype.java.internal.modelinstance.JavaModelInstance;
import tudresden.ocl20.pivot.pivotmodel.Constraint;
import tudresden.ocl20.pivot.standalone.facade.StandaloneFacade;
import tudresden.ocl20.pivot.standalone.metamodel.JavaMetamodel;
import tudresden.ocl20.pivot.standalone.model.StandaloneJavaModelProvider;

public class OCLValidation {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		
		if(args.length < 1){
			System.out.println("Not enough parameter");
			System.exit(0);
		}
		System.out.println("Start Validation: " + new Date());
		final long start = System.currentTimeMillis();
		final Map<String,byte[]> map = new HashMap<String,byte[]>();
		final List<String> classNamesSlashes = new ArrayList<String>();
		final Map<String,String> oclMap = new HashMap<String,String>();
		
		MapResourceFinder mrf = null;
		ClassLoader classLoader = null;
	    try {
	    	 
	    	SAXParserFactory factory = SAXParserFactory.newInstance();
	    	SAXParser saxParser = factory.newSAXParser();
	     
	    	DefaultHandler handler = new DefaultHandler() {
	    	ByteArrayOutputStream buffer = null;
    		PrintWriter writer = null;
    		String className = null;
    		String classNameSlash = null;
    		String oclString = null;
    		boolean write = false;

	    	public void startElement(String uri, String localName,String qName, Attributes attributes) throws SAXException {
	    		//System.out.println("Start Element :" + qName);
	    		if(qName.equals("class")){
	    			buffer = new ByteArrayOutputStream();
	    			writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(buffer)));
	    			className=attributes.getValue("className");
	    			classNameSlash=className.replaceAll("\\.", "/");
	    			classNamesSlashes.add(classNameSlash);
	    			write = true;
	    		}
	    		if(qName.equals("constraint")){
	    			oclString=attributes.getValue("oclString");
	    		}	
	    	}
	     
	    	public void characters(char ch[], int start, int length) throws SAXException {
	    		if(write)writer.print(new String(ch, start, length));
	    	}

	    	public void endElement(String uri, String localName, String qName) throws SAXException {
	    		if(write){
		    		if(null!=writer)writer.close();
	    			//System.out.println("End Class: " + className + " " + classNameSlash);
	    			map.put(classNameSlash, buffer.toByteArray());
	    			oclMap.put(classNameSlash, oclString);
	    			oclString = "";
	    			className = "";
	    			classNameSlash= "";
	    		}
    			write = false;
    			
	    	}
         };
           
         
           ByteArrayInputStream b = new ByteArrayInputStream(args[0].getBytes());	
           saxParser.parse(b, handler);
   		   
           //Init class loader:
           mrf = new MapResourceFinder(map);
           
           //Compile:		
           SimpleCompiler scompiler = null;
		   for(String cn:classNamesSlashes){
			   scompiler = new SimpleCompiler();
			   if(null != classLoader){
				   scompiler.setParentClassLoader(classLoader);
			   }
		       scompiler.cook(new ByteArrayInputStream(map.get(cn)));
		       classLoader=scompiler.getClassLoader();
//		       System.out.println("Compiled: "+ cn);
		   }

        } catch (Exception e) {
            e.printStackTrace();
        }
          
	   String encoding = null;
	   ClassLoader cl = new JavaSourceClassLoader(classLoader, mrf, encoding, DebuggingInformation.ALL);
	   
/*
	   //Test instanciate all:
	   for(String k:map.keySet()){
		   String cn = k.replaceAll("/","\\.");
		   System.out.println(cn);
		   System.out.println(cl.loadClass(cn).newInstance());
	   }
*/     
		StandaloneFacade.INSTANCE.initialize(new URL("file:"+ new File("log4j.properties").getAbsolutePath()));
		OclReferenceResolveHelperProvider.setOclReferenceResolveHelper(new OclReferenceResolveHelper());
		IMetamodel javaMetamodel = new JavaMetamodel();
		StandaloneFacade.INSTANCE.getStandaloneMetamodelRegistry().addMetamodel(javaMetamodel);
		IModel model = null;
		final long init = System.currentTimeMillis();
		long start_constraints = 0;
        for(String s:classNamesSlashes){
        	String cn = s.replaceAll("/","\\.");
        	if(cn.startsWith("no.dpf.text.validation.temp.ModelProviderClass")){
        		model = ((StandaloneJavaModelProvider)javaMetamodel.getModelProvider()).getModel(cl.loadClass(cn));
//        		System.out.println("Model: " + model);
        	}
        	if(cn.startsWith("no.dpf.text.validation.temp.ModelInstanceProviderClass")){
        		if(0==start_constraints)start_constraints=System.currentTimeMillis();
        		ModelInstanceProvider data = (ModelInstanceProvider)cl.loadClass(cn).newInstance();
        		IModelInstance modelInstance = new JavaModelInstance(model);
        		for(Object o:data.getModelObjects()){
        			modelInstance.addModelInstanceElement(o);
        		}	
//        		System.out.println("Modelinstance: " + modelInstance);
        		List<Constraint> constraintList = Ocl22Parser.INSTANCE.parseOclString(oclMap.get(s), model);
				for (IInterpretationResult result : StandaloneFacade.INSTANCE.interpretEverything(modelInstance, constraintList)) {
					System.out.println("  " + result.getModelObject() + " ("
							+ result.getConstraint().getKind() + ": "
							+ result.getConstraint().getSpecification().getBody()
							+ "): " + result.getResult());
				}
      		
        	}
        }
                 
 		System.out.println("Stop Validation: " + new Date());
 		System.out.println("Last: " + (System.currentTimeMillis()-start));
 		System.out.println("Last (without initialization): " + (System.currentTimeMillis()-init));
 		System.out.println("Last (only constraint checking): " + (System.currentTimeMillis()-start_constraints));
		
	}

}
