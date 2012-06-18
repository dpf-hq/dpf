package no.hib.dpf.text.ui;

import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.LinkedList;
import java.util.List;

import no.hib.dpf.text.DPFTextStandaloneSetup;
import no.hib.dpf.text.parser.antlr.DPFTextParser;
import no.hib.dpf.text.tdpf.Specification;
import no.hib.dpf.text.wrapper.JavaScalaBridge;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.text.edits.ReplaceEdit;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parser.IParser;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;

import com.google.inject.Injector;


public class GraphNormalizer{
	
	public static void normalize(final IFile f, final IXtextDocument document, final XtextEditor editor) {
		JavaScalaBridge bridge = new JavaScalaBridge();
		Injector injector = new DPFTextStandaloneSetup().createInjectorAndDoEMFRegistration();
		IParser parser = injector.getInstance(DPFTextParser.class);
		IParseResult result;
		try {
			
			result = parser.parse(new InputStreamReader(f.getContents()));
			
			//TODO Note to comment out:
			for (INode n : result.getSyntaxErrors()) {
				System.out.println("Error:" + n);
			}
			
			EObject eRoot = result.getRootASTElement();
//			System.out.println(eRoot);
			
			try {
				if(eRoot instanceof Specification){
					final Specification specification = (Specification)eRoot;
					final ICompositeNode co = NodeModelUtils.findActualNodeFor(eRoot);	
					final List<String> nGraph = bridge.read(specification);
					
					//Test:
					for(String s:nGraph){
						System.out.print(">>>" + s);
					}
					
					replaceInOpendIFile(co,nGraph,document,editor);
					
					//replaceUnopenedIFile(f, graph, co);
				}
			} catch (Exception e) {
				e.printStackTrace();
				//do nothing
			}
			
		} catch (CoreException e) {
			e.printStackTrace();
		}
	
	}

	private static void replaceInOpendIFile(final ICompositeNode co,	final List<String> nGraph, final IXtextDocument document, final XtextEditor editor) {
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

		System.out.println("TEST FLO");
		
		//Save:
		try {
			editor.doSave(null);			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

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
