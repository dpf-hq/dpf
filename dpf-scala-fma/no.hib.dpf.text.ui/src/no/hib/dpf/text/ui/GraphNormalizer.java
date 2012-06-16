package no.hib.dpf.text.ui;

import java.io.InputStreamReader;

import no.hib.dpf.text.DPFTextStandaloneSetup;
import no.hib.dpf.text.parser.antlr.DPFTextParser;
import no.hib.dpf.text.tdpf.TGraph;
import no.hib.dpf.text.wrapper.JavaScalaBridge;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parser.IParser;

import com.google.inject.Injector;


class GraphNormalizer implements IResourceDeltaVisitor {
	public boolean visit(IResourceDelta delta) {
       IResource res = delta.getResource();
       switch (delta.getKind()) {
//          case IResourceDelta.ADDED:
//             break;
//          case IResourceDelta.REMOVED:
//              break;
          case IResourceDelta.CHANGED:
             if(res.getFullPath().toString().endsWith(".tdpf")){
            	 normalize(getIFileIResource(res));
             }
             break;
       }
       return true; // visit the children
    }

	private static void normalize(IFile f) {
		Injector injector = new DPFTextStandaloneSetup().createInjectorAndDoEMFRegistration();
		IParser parser = injector.getInstance(DPFTextParser.class);
		IParseResult result;
		try {
			
			result = parser.parse(new InputStreamReader(f.getContents()));
			for (INode n : result.getSyntaxErrors()) {
				System.out.println("Error:" + n);
			}
			
			EObject eRoot = result.getRootASTElement();
//			System.out.println(eRoot);
			if(eRoot.eAllContents().hasNext()){
				final EObject o = eRoot.eAllContents().next();
				if(o instanceof TGraph){
					final TGraph graph = (TGraph)o;
					final ICompositeNode co = NodeModelUtils.findActualNodeFor(o);	
					//System.out.println("Replace" + co.getOffset() + " " + co.getLength());
					
					//Replace content:
					try{
					InputStreamReader reader = new InputStreamReader(f.getContents());
					    int r = 0;
					    int c = 0;
					    final int rangeStart=co.getOffset();
					    final int rangeEnd=rangeStart + co.getLength();
					    boolean insert = true;
						while((r = reader.read()) > -1){
							if(rangeStart > c || rangeEnd < c){
								System.out.print((char)r);
							}else if(insert){
								insert = false;
								JavaScalaBridge bridge = new JavaScalaBridge();
								for(String line:bridge.read(graph)){
									System.out.print(line);
								}
							}
							c++;
						}
					}catch(Exception ex){
						ex.printStackTrace();
					}
				}
			}
			
		} catch (CoreException e) {
			e.printStackTrace();
		}
	
	}

	private static IFile getIFileIResource(IResource r) {
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		return root.getFile(r.getFullPath());
	}
	

}
