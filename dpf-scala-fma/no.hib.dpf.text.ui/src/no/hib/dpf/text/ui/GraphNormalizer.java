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
import org.eclipse.emf.mwe.core.monitor.NullProgressMonitor;
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
								JavaScalaBridge bridge = new JavaScalaBridge();
								outData.addAll(bridge.read(graph));
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
			
		} catch (CoreException e) {
			e.printStackTrace();
		}
	
	}

	private static IFile getIFileIResource(IResource r) {
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		return root.getFile(r.getFullPath());
	}
	

}
