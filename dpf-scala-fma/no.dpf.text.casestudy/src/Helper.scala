import scala.xml._
import scala.xml.transform._
import com.sun.org.apache.xalan.internal.xsltc.compiler.ForEach

object RemoveImageFromSVG {
    def main(args: Array[String]) {

      convert("0/original_minimal_metamodel_0.svg")
      convert("1/original_minimal_metamodel_1.svg")
      convert("2/original_minimal_metamodel_2.svg")
      convert("3/original_minimal_metamodel_3.svg")
      convert("4/original_minimal_metamodel_4.svg")
      convert("5/original_minimal_metamodel_5.svg")
      
      def convert(fname:String)={ 
	      val path = "/home/fma/scala/workspace_modelling/no.dpf.text.casestudy/models/";
	      val xml = XML.loadFile(path + fname)
	
		  val removeIt = new RewriteRule {
		    override def transform(n: Node): NodeSeq = n match {
		      case <image/> =>  NodeSeq.Empty
		      case n => n
		    }
	      }
	      
	      new RuleTransformer(removeIt).transform(xml)
	      XML.save(path + fname,xml)
	      //println(xml) 
      }
      
      println("Ready.")
    }


}

