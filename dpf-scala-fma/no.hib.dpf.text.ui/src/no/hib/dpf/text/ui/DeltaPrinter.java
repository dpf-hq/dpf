package no.hib.dpf.text.ui;

import java.io.InputStreamReader;

import no.hib.dpf.text.DPFTextStandaloneSetup;
import no.hib.dpf.text.parser.antlr.DPFTextParser;
import no.hib.dpf.text.tdpf.TGraph;

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

class DeltaPrinter implements IResourceDeltaVisitor {
	public boolean visit(IResourceDelta delta) {
       IResource res = delta.getResource();
       switch (delta.getKind()) {
          case IResourceDelta.ADDED:
             System.out.print("Resource ");
             System.out.print(res.getFullPath());
             System.out.println(" was added.");
             break;
          case IResourceDelta.REMOVED:
             System.out.print("Resource ");
             System.out.print(res.getFullPath());
             System.out.println(" was removed.");
             break;
          case IResourceDelta.CHANGED:
             System.out.print("Resource ");
             System.out.print(res.getFullPath());
             System.out.println(" has changed.");
             if(res.getFullPath().toString().endsWith(".tdpf")){
            	 System.out.println("War hier");
            	 getModel(getIFileIResource(res));
             }
             break;
       }
       return true; // visit the children
    }

	private void getModel(IFile f) {
		Injector injector = new DPFTextStandaloneSetup()
				.createInjectorAndDoEMFRegistration();
		IParser parser = injector.getInstance(DPFTextParser.class);
		IParseResult result;
		try {
			result = parser.parse(new InputStreamReader(f.getContents()));
			for (INode n : result.getSyntaxErrors()) {
				System.out.println("Error:" + n);
			}
			
			EObject eRoot = result.getRootASTElement();
			System.out.println(eRoot);
			
			if(eRoot.eAllContents().hasNext()){
				final EObject o = eRoot.eAllContents().next();
				if(o instanceof TGraph){
					ICompositeNode co = NodeModelUtils.findActualNodeFor(o);	
					System.out.println("Replace" + co.getOffset() + " " + co.getLength());
				}
			}
			
		} catch (CoreException e) {
			e.printStackTrace();
		}
	
	}

	public static IFile getIFileIResource(IResource r) {
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		return root.getFile(r.getFullPath());
	}

}
