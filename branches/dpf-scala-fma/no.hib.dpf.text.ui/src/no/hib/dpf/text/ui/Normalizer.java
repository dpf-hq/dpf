package no.hib.dpf.text.ui;

import java.io.InputStreamReader;
import java.util.Date;
import java.util.List;
import java.util.Stack;

import no.hib.dpf.text.DPFTextStandaloneSetup;
import no.hib.dpf.text.parser.antlr.DPFTextParser;
import no.hib.dpf.text.tdpf.Arrow;
import no.hib.dpf.text.tdpf.Arrows;
import no.hib.dpf.text.tdpf.Node;
import no.hib.dpf.text.tdpf.Specification;
import no.hib.dpf.text.util.Tuple;
import no.hib.dpf.text.wrapper.JavaScalaBridge;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.text.IDocument;
import org.eclipse.text.edits.ReplaceEdit;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parser.IParser;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.model.XtextDocument;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

import com.google.inject.Injector;


public class Normalizer{
	
	public static final String SPECIFICATION_FILE_EXTENSION = "_Specification.tdpf";
	public static final String SIGNATURE_FILE_EXTENSION = "_Signature.tdpf";
	
	/**
	 * Normalize a Xtextdocument so that it is a valid type graph (does not care about additional well-formedness rules)
	 * @param d
	 */
	public static void initCache(final IXtextDocument document, final Specification specification) {
		try{
			System.out.println("initCache!");
			JavaScalaBridge.read(readTransitiv(specification));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Normalize a Xtextdocument so that it is a valid type graph (does not care about additional well-formedness rules)
	 * @param d
	 */
	public static void normalize(final IDocument d) {
		if(d instanceof XtextDocument){
			final XtextDocument document = (XtextDocument)d;
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
								final Tuple<List<String>,List<Tuple<?,String>>> rs = JavaScalaBridge.read(readTransitiv(specification));
								final List<String> nGraph = rs.x;
								addNonParsableLines(parseResult, nGraph, d);
								addNotWellTypedElements(rs.y,nGraph,d);
								replaceInOpendIFile(co,nGraph,document);
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

	private static Stack<Tuple<String,Specification>> readTransitiv(final Specification specification) {
		final IFile f = eObject2IFile(specification);
		final Stack<Tuple<String,Specification>> stack = new Stack<Tuple<String,Specification>>();	
		stack.add(new Tuple<String, Specification>(getSpecNameFromFileName(f), specification));
		Specification s = specification;
		while(!stack.isEmpty() && !JavaScalaBridge.isSpecificationInCache(s.getType().getId())){
			stack.push(read(iFileFromParent(f,s)));
			s=stack.peek().y;
		}
		return stack;
	}
	
	private static Tuple<String,Specification> read(final IFile f) {
		final Injector injector = new DPFTextStandaloneSetup().createInjectorAndDoEMFRegistration();
		final IParser parser = injector.getInstance(DPFTextParser.class);
		System.out.println("Read: " + f.getFullPath());
		try {
			final IParseResult result = parser.parse(new InputStreamReader(f.getContents()));
			final EObject eRoot = result.getRootASTElement();
			if(eRoot instanceof Specification){
				return new Tuple<String, Specification>(getSpecNameFromFileName(f),(Specification)eRoot);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		throw new RuntimeException(f.getFullPath() + " is not a Specification!");	
	}

	private static String getSpecNameFromFileName(final IFile f){
		return f.getName().substring(0,f.getName().indexOf(SPECIFICATION_FILE_EXTENSION));
	}

	/**
	 * Errors Level 1: Not Parsable
	 * @param result
	 * @param nGraph
	 * @param d
	 */
	private static void addNonParsableLines(IParseResult result, final List<String> nGraph, final IDocument d) {
		//Comment out errors:
		synchronized (d) {
			if(result.getSyntaxErrors().iterator().hasNext()){
				nGraph.add("\n/*");
				nGraph.add("\n-------------------------------------------------");
				nGraph.add("\nCould not be parsed:" + new Date());
				nGraph.add("\n-------------------------------------------------\n");
				String oldText = "";
				for (INode n : result.getSyntaxErrors()) {
					try {
						for(int i=n.getStartLine()-1;i<=n.getEndLine()-1;i++){
							final String text = d.get(d.getLineOffset(i),d.getLineLength(i));
							if(!text.equals(oldText)){
								nGraph.add(text);
							}
							oldText = text;
						}
						nGraph.add("Error message: " + n.getSyntaxErrorMessage() + "\n");
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				nGraph.add("\n-------------------------------------------------\n");
				nGraph.add("*/\n");
			}
		}
	}

	/**
	 * Errors Level 2: Not Well-typed
	 * @param result
	 * @param nGraph
	 * @param d
	 */
	@SuppressWarnings("unchecked")
	private static void addNotWellTypedElements(List<Tuple<?,String>> errors, final List<String> nGraph, final IDocument d){
		//Comment out errors:
		if(0 < errors.size()){
			nGraph.add("\n/*");
			nGraph.add("\n-------------------------------------------------");
			nGraph.add("\nNot Well-typed Elements:" + new Date());
			nGraph.add("\n-------------------------------------------------\n");
			for (Tuple<?,String> t : errors) {
				ICompositeNode n = null;
				try{				
					if(t.x instanceof Arrow){
						n = NodeModelUtils.findActualNodeFor((Arrow)t.x);
					}else
					if(t.x instanceof Node){
						n = NodeModelUtils.findActualNodeFor((Node)t.x);						
					}else
					if(t.x instanceof Tuple){
						n = NodeModelUtils.findActualNodeFor(((Tuple<Arrows,Arrows>)t.x).x);												
					}else{
						throw new RuntimeException("Programming Error!");
					}
					for(int i=n.getStartLine()-1;i<=n.getEndLine()-1;i++){
						final String text = d.get(d.getLineOffset(i),d.getLineLength(i));
						nGraph.add(text);
					}					
					nGraph.add("Error message: " + t.y + "\n");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			nGraph.add("\n-------------------------------------------------\n");
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

   private static IFile eObject2IFile(EObject o){
	   final Resource eResource = o.eResource();
	   final URI eUri = eResource.getURI();
	   final String platformString = eUri.toPlatformString(true);
	   final IFile file = (IFile)ResourcesPlugin.getWorkspace().getRoot().findMember(platformString);	 
	   return file;
   }

   private static IFile iFileFromParent(IFile f,Specification s){
	   final String path = f.getParent().getFullPath() + "/" + s.getType().getId() + SPECIFICATION_FILE_EXTENSION;
	   return ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(path)); 	   
   }

}
