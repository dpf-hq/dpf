The Error in the project is only temporary. Eclipse misses a reference to a Java-file which does not exist
in the source code because it is implemented in Scala. Hence, ignore this error. Its more "a bug" 
of the Eclipse IDE which did not realize that you can also implement plugins in Scala now:  

-------------------------------------------------------------------------------------------------------
In Parser.scala can you switch between Eclipse-OCL and Dresden-OCL by changing the import statement: 

object Main extends Parser(GraphDpf, "DPF") 
{
	import no.dpf.text.graph.validation.eclipse._
//	import no.dpf.text.graph.validation.dresden._

-------------------------------------------------------------------------------------------------------

If you use EclipseOCL:

1.) Run "no.dpf.text" as Eclipse-Application
2.) Right-Mouse-Click on file "file.tdpf" : "Run DPF-Parser"

If you use DresdenOCL:
- Option 1: Run the program as in EclipseOCL
- Option 2: Run Main in Parser.scala or run Test.scala (Test.scala exist only because of another bug in EclipseIDE) 

EMFtoCSP: - Cross-check of conflicting constraints
          - integration is nearly finished, however found a bug in the tool and submited a bug report
          
EclipseOCL: Uses EMF model as input
DresdenOCL: Uses Java-Classes as import. "On-the-fly-compilation" and loading is implemented using apaches janino compiler :)          
-------------------------------------------------------------------------------------------------------


 
