package no.hib.dpf.text.ui;

import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import no.hib.dpf.text.tdpf.Specification;
import no.hib.dpf.text.wrapper.JavaScalaBridge;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.IDocument;
import org.eclipse.text.edits.ReplaceEdit;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.model.XtextDocument;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;


public class GraphNormalizer{
	
	/**
	 * Normalize a Xtextdocument so that it is a valid type graph (does not care about additional well-formedness rules)
	 * @param d
	 */
	public static void normalize(final IDocument d) {
		if(d instanceof XtextDocument){
			final XtextDocument document = (XtextDocument)d;
			final JavaScalaBridge bridge = new JavaScalaBridge();
			try {
				document.modify(new IUnitOfWork<EList<EObject>, XtextResource>() {
					public EList<EObject> exec(XtextResource state) throws Exception {
						IParseResult parseResult = state.getParseResult();					
						EObject eRoot = parseResult.getRootASTElement();
	//					System.out.println(eRoot);
						try {
							if(eRoot instanceof Specification){
								final Specification specification = (Specification)eRoot;
								final ICompositeNode co = NodeModelUtils.findActualNodeFor(eRoot);	
								final List<String> nGraph = bridge.read(specification);
								addNonParsableLines(parseResult, nGraph);
								replaceInOpendIFile(co,nGraph,document);
								//replaceUnopenedIFile(f, graph, co);
							}
						} catch (Exception e) {
							e.printStackTrace();
							//do nothing
						}
						return null;
					}
			    });
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Normalize a Xtextdocument so that it is a valid type graph (does not care about additional well-formedness rules)
	 * @param d
	 */
	public static void normalize(final IXtextDocument document, Specification specification) {
		try{
			final JavaScalaBridge bridge = new JavaScalaBridge();
			final ICompositeNode co = NodeModelUtils.findActualNodeFor(specification);	
			final List<String> nGraph = bridge.read(specification);
			replaceInOpendIFile(co,nGraph,document);
			//replaceUnopenedIFile(f, graph, co);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
//	
//	public static void normalize(final IFile f, final IXtextDocument document) {
//		JavaScalaBridge bridge = new JavaScalaBridge();
//		Injector injector = new DPFTextStandaloneSetup().createInjectorAndDoEMFRegistration();
//		IParser parser = injector.getInstance(DPFTextParser.class);
//		IParseResult result;
//		try {
//			
//			result = parser.parse(new InputStreamReader(f.getContents()));
//			EObject eRoot = result.getRootASTElement();
////			System.out.println(eRoot);
//			
//			try {
//				if(eRoot instanceof Specification){
//					final Specification specification = (Specification)eRoot;
//					final ICompositeNode co = NodeModelUtils.findActualNodeFor(eRoot);	
//					final List<String> nGraph = bridge.read(specification);
//					addNonParsableLines(result, nGraph);
//					replaceInOpendIFile(co,nGraph,document);
//					//replaceUnopenedIFile(f, graph, co);
//				}
//			} catch (Exception e) {
//				e.printStackTrace();
//				//do nothing
//			}
//			
//		} catch (CoreException e) {
//			e.printStackTrace();
//		}
//	
//	}
//

	private static void addNonParsableLines(IParseResult result,
			final List<String> nGraph) {
		//Comment out errors:
		if(result.getSyntaxErrors().iterator().hasNext()){
			nGraph.add("\n/*");
			nGraph.add("\n-------------------------------------------");
			nGraph.add("\nCould not be parsed:" + new Date());
			nGraph.add("\n-------------------------------------------");
			for (INode n : result.getSyntaxErrors()) {
				nGraph.add(n.getText());
			}
			nGraph.add("*/\n");
		}
	}

   /**
    * Replace in the current file which is displayed in the editor:	
    * @param co
    * @param nGraph
    * @param document
    */
   private static void replaceInOpendIFile(final ICompositeNode co,	final List<String> nGraph, final IXtextDocument document) {
		final StringBuilder nGraphAsString = new StringBuilder();
		for(String s:nGraph){
			nGraphAsString.append(s);
		}
		//Replace:
		final ReplaceEdit r = new ReplaceEdit(co.getOffset(),co.getLength(),nGraphAsString.toString());
		
		try {
			r.apply(document,ReplaceEdit.NONE);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

   /**
    * Replace in a file which is stored on disk but not displayed in the editor:	
    * @param co
    * @param nGraph
    * @param document
    */
	@SuppressWarnings("unused")
	private static void replaceInUnopenedIFile(IFile f, final List<String> graph, final ICompositeNode co) {
		//Replace content:
		try{
			final InputStreamReader reader = new InputStreamReader(f.getContents());
			final List<String> outData = new LinkedList<String>();
		    final int rangeStart=co.getOffset();
		    final int rangeEnd=rangeStart + co.getLength();
		    int r = 0;
		    int c = 0;
		    boolean insert = true;
		    
		    //Read:
			while((r = reader.read()) > -1){
				if(rangeStart > c || rangeEnd < c){
					outData.add(String.valueOf((char)r));
				}else if(insert){
					insert = false;
					outData.addAll(graph);
				}
				c++;
			}
			//Close:
			reader.close();
			
			//Write:
			//create an empty InputStream
			final PipedInputStream in = new PipedInputStream();

			//create an OutputStream with the InputStream from above as input
			final BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new PipedOutputStream(in)));

			for(String data:outData){
				out.write(data);
			}

			//Close:
			out.close();
			
			//overwrite file contents
			f.setContents(in, true, true, null); 						
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}


}
