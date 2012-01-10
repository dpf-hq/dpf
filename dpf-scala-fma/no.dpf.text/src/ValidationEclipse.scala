package no.dpf.text.graph.validation.eclipse

import no.dpf.text.graph._
import no.dpf.text.graph.ecore._
import no.dpf.text.graph.validation._
import no.dpf.text.graph.{Constraint=>DConstraint}
import no.dpf.text.graph.validation.SimpleGraph
//Ecore:
import org.eclipse.emf.ecore._;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
//OCL:
import java.text.ParseException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.OCL;
import org.eclipse.ocl.OCLInput;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.EcoreEnvironmentFactory;
import org.eclipse.ocl.helper.OCLHelper;
import no.dpf.text.graph.validation._;
import org.eclipse.emf.common.util.URI;
//Util:
import scala.collection.mutable.{Map=>MMap}
import scala.collection.mutable.{Set=>MSet}
//EMFtoCSP:
import fr.inria.atlanmod.emftocsp._
import fr.inria.atlanmod.emftocsp.impl._
import fr.inria.atlanmod.emftocsp.emf.impl._
import fr.inria.atlanmod.emftocsp.eclipsecs.EclipseSolver;
import fr.inria.atlanmod.emftocsp.emftoecl.EmfToEclCodeGenerator;
import fr.inria.atlanmod.emftocsp.emftoecl.EmfToEclCodeGenerator;
//Eclipse
import org.eclipse.core.resources._
//Java:
import java.io.File


object Validation extends Helper{
	
    //Vars:
    private val ocl:OCL[_,EClassifier,_,_,_,_,_,_,_,Constraint,EClass,EObject]=OCL.newInstance(EcoreEnvironmentFactory.INSTANCE);
    private val oclHelper=ocl.createOCLHelper();
    private val resourceSet:ResourceSet = new ResourceSetImpl();
    
    //Init:
    private val init1 = Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("xmi",new XMIResourceFactoryImpl());
	private val init2 = Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("ecore",new EcoreResourceFactoryImpl());
    
	

 	def validate(is:IS){
 	    import java.io._
		validateShapes(is)	  

		//Create and load model:
		val name = "Temp" + System.currentTimeMillis();		
		createMetaModel(name,is.mm.g)	
		
		//In create,load and validate instance:
		for(e<-createValidationParts(is)){
//			val i:ByteArrayOutputStream = new ByteArrayOutputStream()
//			val writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(i)));
			val nameI = "Temp" + System.currentTimeMillis()+".xmi";
			val file = getWorkingFolder() match{
		      case Some(f) => new File(f.getLocation().toFile(),nameI)      		
		      case None => new File(nameI); 
		    }
		    println("File:" + file.getPath())
			val writer = new PrintWriter(new BufferedWriter(new FileWriter(file)));
			try{
				writer.println("""<?xml version="1.0" encoding="UTF-8"?>""");
				writer.write(EcoreGenerator.graph2EcoreI_simple(e._2,name).toString);			
			}finally{	
				writer.close()
			}
			val modelResource = loadInstance(file.getAbsolutePath());
			try{
				validate1(modelResource,e._1); 
			}catch{
			  case ex => validate2(modelResource,e._1); 
			}			
 	  }

	}

	private def createMetaModel(name:String,g:AbstractGraph):File={
		import java.io._
		val file = getWorkingFolder() match{
	      case Some(f) => new File(f.getLocation().toFile(),name + ".ecore")      		
	      case None => new File(name + ".ecore"); 
	    }
	    println("File:" + file.getPath())
		val writer = new PrintWriter(new BufferedWriter(new FileWriter(file)));
		try{
			writer.println("""<?xml version="1.0" encoding="UTF-8"?>""");
			writer.write(EcoreGenerator.graph2EcoreM_simple(g,name).toString);
		}finally{	
			writer.close()
		}
		file
	}
 	
    /**
    * OCL must start with "inv" etc.
    */       
   private def validate1(modelResource: EObject,oclString: String)={
	  
	  val eOclString = "package Graph\n\n" + oclString + "\n\nendpackage"; 		
	  val document = new OCLInput(eOclString);
	  val ecoreEnv = new EcoreEnvironmentFactory(modelResource.eResource().getResourceSet().getPackageRegistry());
	  val oclParser = OCL.newInstance(ecoreEnv);
	  val constraint = oclParser.parse(document).get(0);
	     
	  import scala.collection.JavaConversions._
	  val context = constraint.getSpecification().getContextVariable().getType();
	  for(e<-modelResource.eAllContents()){
    	 try{
    		 if(context==e.eClass()){
    			 println("OCL=" +  constraint + " e=" + e + " Result="+ ocl.check(e, constraint))
    		 }
    	 }catch{
    	   case e => e.printStackTrace()
    	 }
	  }
   }   
  
   /**
    * OCL must start without "inv" BUT with XXX.allInstances()
    */
   private def validate2(modelResource: EObject,oclString: String)={
       
       //Init:
       oclHelper.setContext(modelResource.eClass());
       val constraint = oclHelper.createInvariant(oclString); 
       
       // Check the constraint:
       println("OCL=" + oclString + " Result="+ ocl.check(modelResource, constraint))
     
   }
   
 	private def loadModel(fname:String)={
 		import java.io.File;
		val modelUri = URI.createFileURI(new File(fname).getAbsolutePath());
		resourceSet.getResource(modelUri, true);
		val resourceModel:Resource = resourceSet.getResource(modelUri, true);
		resourceModel
		//resourceModel.getContents().get(0).asInstanceOf[EPackage];
	}
  
	private def loadInstance(fname:String):EObject={
		import java.io.File;
		/*
		 * Note the usage of ".getAbsolutePath()" below! This is necessary for
		 * EMF to resolve relative paths in instance models. In our case, the
		 * typing i.e. the meta-model petri.ecore is given relative to this
		 * instance models location.
		 */
		val instanceUri = URI.createFileURI(new File(fname).getAbsolutePath());
		val resourceInstance:Resource = resourceSet.getResource(instanceUri, true);
		resourceInstance.getContents().get(0).asInstanceOf[EObject];
	}
 	
 	
	/**
	 * - Check OCL strings if they do not prevent to create an instance
	 * - Save calculated Strings into a database file to prevent recalculation the next time
	 */	
   def checkOclDefintion(is:IS)={
     
	   var ocls:List[String]=Nil
	   
	   //Initial map: 
	   val epsMap = is.mm.cs.map { c => (c, MSet(c)) } toMap
	   
	   //Create sets of overlapping constraints:
	   for(c1<-is.mm.cs){
		   for(c2<-is.mm.cs){
			   //Not equal and Not empty intersection:
			   if(c1 != c2 && !(c1.as.toSet & c2.as.toSet).isEmpty){
			     epsMap(c1).add(c2)
			   }
		   }		   
	   }
	   //Collapse to sets:
	   val epsSet = epsMap.values.toSet
	   
	   //Sorted List of ocl-constraints with overlapping constraints sets
	   val intermrs = epsSet map {x=>(x map {c => (fillOcl_parameter(c,is.pSem(c.s.id).ocl),c)}).toList.sortBy(_._1)}

	   //Calculate Elements which are equal:
	   //List[String] = Sorted List of OCL constraints with only parameter values set
	   //String = N=Node,A=Arrow
	   //Int1   = Position of OCL constraint in List
	   //Int2	= Position of node/arrow in constraint arrow list
	   //All Tuple3 in one set are equal
	   //SimpleGraph   = Metamodel
	   //List[String] = List of OCL constraints ready to use
	   val rs = MMap[(List[String],Set[MSet[Tuple3[String,Int,Int]]]),(SimpleGraph,List[String])]();
	   
	   for(e<-intermrs){

	     var ocls:List[String]=Nil 
	     var fullOcls:List[String]=Nil
	     val equalities = MSet[MSet[Tuple3[String,Int,Int]]]()
	     val eqNodes = MMap[Node,MSet[Tuple3[String,Int,Int]]]()
	     val eqArrows = MMap[Arrow,MSet[Tuple3[String,Int,Int]]]()
	     var graph = new SimpleGraph(is.mm.g.names)
	     
	     for((ocl,c)<-e){
	       for(a<-c.as){
	         //
	         //Build metamodel graph:
	         //
	         graph.addArrow(a)
	         
	         //
	         //Build equalities:
	         //
	         var ii = 0
	    	 for((_,ci)<-e){
	    	   if(c!=ci){
		    	   //Check arrows:  
		    	   val posA=ci.positions(a)
		    	   if(0<posA.size){
		    	     //save:
   	                 var eq:MSet[Tuple3[String,Int,Int]]=null;
		    	     if(!eqArrows.contains(a)){
		    	       eqArrows.put(a,MSet[Tuple3[String,Int,Int]]())
		    	     }
		    	     eq=eqArrows(a)
		    	     for(i<-posA)eq.add("A",ii,i)
		    	   }	    	     
		    	   //Check nodes: 
		    	   val posN1=ci.positions(a.sr)
		    	   if(0<posN1.size){
		    	     //save:
		    	     var eq:MSet[Tuple3[String,Int,Int]]=null;
		    	     if(!eqNodes.contains(a.sr)){
		    	       eqNodes.put(a.sr,MSet[Tuple3[String,Int,Int]]())
		    	     }
		    	     eq=eqNodes(a.sr)
		    	     for(i<-posN1)eq.add("N",ii,i)
		    	   }
		    	   val posN2=ci.positions(a.tg)
		    	   if(0<posN2.size){
		    	     //save:
		    	     var eq:MSet[Tuple3[String,Int,Int]]=null;
		    	     if(!eqNodes.contains(a.tg)){
		    	       eqNodes.put(a.tg,MSet[Tuple3[String,Int,Int]]())
		    	     }
		    	     eq=eqNodes(a.tg)
		    	     for(i<-posN2)eq.add("N",ii,i)
		    	   }
	    	   }
	    	   ii+=1
	    	 }  
	       }
	       //Outer constraint loop:
	       ocls=(ocl::ocls)
	       fullOcls=(fillOcl(c,is.pSem(c.s.id).ocl)::fullOcls)
	       equalities++=eqNodes.values
	       equalities++=eqArrows.values
	     }	     
	     rs.put((ocls.reverse,Set(equalities toSeq : _ *)),(graph,fullOcls.reverse)); 
	   }
	   
	   //Read already calculated values from file:
	   
	   //Database-Structure:
	   //List[String] = Sorted List of OCL constraints with parameter
	   //String = N=Node,A=Arrow
	   //Int1   = Position of OCL constraint in List
	   //Int2	= Position of node/arrow in constraint arrow list
	   //All Tuple3 in one set are equal
	   //Boolean = Constraint/Constraint combination valid/invalid
	   var db:MMap[(List[String],Set[MSet[Tuple3[String,Int,Int]]]),Boolean]=null;
	   try{
		 import java.io._
	     val read = new ObjectInputStream(new FileInputStream("db.ser"))
	     db = read.readObject().asInstanceOf[MMap[(List[String],Set[MSet[Tuple3[String,Int,Int]]]),Boolean]]
	     read.close()
	   }catch{
	   	case ex => 	db=MMap[(List[String],Set[MSet[Tuple3[String,Int,Int]]]),Boolean]();
	   	  			println(ex.getMessage())
	   }
	   
	   //Check only non-calculated values:
	   for(e<-rs.keys){
		  val b = db.get(e) match {
		    case Some(b) => b
		    case None => {
		    	//Calculate and store value:
		    	val r = callEmfToCsp(e,rs(e))
		    	val b2 = r match {
		    	  case Some(b2) => db+=e->b2
		    	  case None => /*do nothing*/
		    	}
		    	b2
		    }
		  }
		  b match{
		    case Some(true) => println("Conflict:" + rs(e))
		    case Some(false) => println("No conflict:" + rs(e))
		  }

//TEST:
callEmfToCsp(e,rs(e))		  
		  
	   }

	   //Save updated database:
	   try{
	     import java.io._
	     val save = new ObjectOutputStream(new FileOutputStream("db.ser"))
	     save.writeObject(db)
	     save.close();
	   }catch{
	   	 case ex => println(ex.getMessage())
	   }   
//	   println(rs)
   }
	
  
  def callEmfToCsp(k:(List[String],Set[MSet[Tuple3[String,Int,Int]]]),ms:(SimpleGraph,List[String])):Option[Boolean]={   
	try{   
	    import org.eclipse.core.resources._
	    import org.eclipse.ui._;
	    import org.eclipse.core.runtime.Path;
	    import java.io.File;
	    
	    val eclipsePath = "";  //is already overwritten 
	    val graphvizPath = ""; //is already overwritten
	    
	    println("-----------------------------")
	    println("callEmfToCsp")
	
		val name = "TTemp" + System.currentTimeMillis();
	
	    //Create Metamodel:
		val fileNameModel = createMetaModel(name,ms._1).getAbsoluteFile().getAbsolutePath()	
		val mmodel = loadModel(fileNameModel)
		
		//Create OCL-constraint File:
	    val fileNameOcl = name+".ocl"
		writeOclFile(fileNameOcl,ms._2)
		val workspace= ResourcesPlugin.getWorkspace();    
	    val location = Path.fromOSString(new File(fileNameOcl).getAbsolutePath()); 
		val oclFile = workspace.getRoot().getFileForLocation(location);
		
	    val solver = new EclipseSolver(eclipsePath, graphvizPath);
	    val modelSolverFactory = new EmfModelToCspSolverFactory();
	 
	    //Init Solver:
	    val modelSolver = modelSolverFactory.getModelToCspSolver();
	    modelSolver.setModelFileName(name + ".ecore");
	    modelSolver.setModel(mmodel);
	    modelSolver.setSolver(solver);
	    modelSolver.setCspCodeGenerator(new EmfToEclCodeGenerator(modelSolver));
	    modelSolver.setConstraintsDocument(oclFile);
	
	    //
	    //Set the same search defaults as in EMFToCSP plugin
	    //
	    val modelElementsDomain = new java.util.HashMap[String, String]();
	    val modelReader = modelSolver.getModelReader().asInstanceOf[IModelReader[Resource, EPackage, EClass, EAssociation, EAttribute, EOperation]];
	    val iter = modelReader.getClasses().iterator
	    while (iter.hasNext) {
	        val c = iter.next
	        modelElementsDomain.put(c.getEPackage().getName() + "." + c.getName(), "0..5"); 
	        
	        //Attributes:
	        val iter2 = modelReader.getClassAttributes(c).iterator
	        while (iter2.hasNext){
	          val at = iter2.next
	          if (at.getEAttributeType().getInstanceClass().getSimpleName() == "boolean"){ 
	            modelElementsDomain.put(at.getEContainingClass().getName() + "." + at.getName(), "0..1");
	          }else{
	            modelElementsDomain.put(at.getEContainingClass().getName() + "." + at.getName(), "[1,10,20]");
	          }  
	        }
	        
	        //Associations:
	        val iter3 = modelReader.getAssociationsNames().iterator   
	        while(iter3.hasNext){
	        	modelElementsDomain.put(iter3.next, "0..10"); 
	        }
	    }  
	    modelSolver.setModelElementsDomain(modelElementsDomain);    
	
	    //What should be checked:
	    val modelProperties = new java.util.ArrayList[IModelProperty]();
	    modelProperties.add(new StrongSatisfiabilityModelProperty());
	    modelSolver.setModelProperties(modelProperties);
	    
	    //Compute:
	    getWorkingFolder() match{
	    	case Some(f) => println("Test:>" + f)
	    	  				modelSolver.setResultLocation(f);
	    					//Solve Problem:
	    				    Some(modelSolver.solveModel()) 
	    	case None => None			     
	    }
	}catch{
		case e => e.printStackTrace();None
	}
  }
  
  private def writeOclFile(name:String,ocls:List[String])={
    import java.io._
	val file = getWorkingFolder() match{
      case Some(f) => new File(f.getLocation().toFile(),name)      		
      case None => new File(name); 
    }
    println("File:" + file.getPath())
    val writer = new PrintWriter(new BufferedWriter(new FileWriter(file)));
	try{
		writer.println("package Graph\n\n");
		for(s<-ocls)writer.println(s + "\n");
		writer.println("\n\nendpackage");
	}finally{	
		writer.close()
	}	   
  }
  
  private def getWorkingFolder():Option[IFolder]={

    import org.eclipse.ui.PlatformUI;
    import org.eclipse.jface.viewers.StructuredSelection;
    import org.eclipse.core.runtime.Path;
    
    var rs:Option[IFolder] = None
    val selection = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getSelectionService().getSelection();
    if(null != selection){
    	val ss = selection.asInstanceOf[StructuredSelection];
		val file = ss.getFirstElement().asInstanceOf[IFile];
		val parent = file.getParent()
		val folder = parent.getFolder(new Path("debug"));
		if (!folder.exists()) {
			folder.create(false, true, null);
		}		
		rs = Some(folder)
    }
    println(rs)
    rs 
  }
  
  
  private def fillOcl_parameter(c:DConstraint,ocl:List[OclToken])={
      
	  var oclList:List[String]=Nil
	  for(o<-ocl){
		o match {
		  case OclPp(v)		=> oclList=(c.paramByNo(v)::oclList)
		  case s@_	=> oclList=(s.toString::oclList)
		}
	  }  
    
	  oclList.reverse.mkString
  }
	
}


