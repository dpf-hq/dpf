package no.hib.dpf.text.ui.outline;

import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import no.hib.dpf.text.DPFTextStandaloneSetup;
import no.hib.dpf.text.parser.antlr.DPFTextParser;
import no.hib.dpf.text.tdpf.Signature;
import no.hib.dpf.text.tdpf.Specification;
import no.hib.dpf.text.util.Tuple;
import no.hib.dpf.text.validation.DPFTextJavaValidator;
import no.hib.dpf.text.wrapper.JavaScalaBridge;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.views.contentoutline.ContentOutline;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parser.IParser;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.model.XtextDocument;
import org.eclipse.xtext.ui.editor.outline.impl.EObjectNode;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

import com.google.inject.Injector;

public class OutlineHandlerValidate extends AbstractHandler {
	
	private EObjectNode currentEObjectNode = null;	
	
	/**
	 * Make errors for specifc elements e.g. Nodes, Arrows available
	 */
	private static void setErrorMessages(final Map<Long,String> errors, final IFile owner){
		if(null != errors){
			DPFTextJavaValidator.setValidationErrMsg(errors,owner);
			IEditorPart xtEditor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActivePart().getSite().getPage().getActiveEditor();
			if(xtEditor instanceof XtextEditor){
				revalidate((XtextEditor)xtEditor);
				System.out.println("Revalidate errors.size()=" + errors.size());
			}
		}else{
			DPFTextJavaValidator.setValidationErrMsg(new HashMap<Long,String>(),owner);
		}
	}

	private static void revalidate(XtextEditor editor) {
	    final IXtextDocument document = editor.getDocument();
	    document.readOnly(new IUnitOfWork<Void, XtextResource>() {
	      public java.lang.Void exec(XtextResource resource) throws Exception {
	        ((XtextDocument) document).checkAndUpdateAnnotations();
	        return null;
	      }
	    });
	}

	
	/**
	 * Make errors for elements available set could not further specified:
	 * @param i
	 * @return
	 */
	private static void printUnspecifiedErrorMessages(List<String> errors){
		if(null != errors && 0 < errors.size()){
			final StringBuffer msg = new StringBuffer();
			msg.append("Following global errors where found: \n");
			for(String s:errors){
				msg.append(s);
				msg.append("\n");
			}
			MessageDialog.openInformation(Display.getCurrent().getActiveShell(),"Validation Completed!", msg.toString());
		}else{
			MessageDialog.openInformation(Display.getCurrent().getActiveShell(),"Validation Completed!","Validation Completed!");
		}
	}
	
    private static IFile iFileFromParent(IFile f, String fileName){
	   final String path = f.getParent().getFullPath() + "/" + fileName;
	   return ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(path)); 	   
    }
	
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		//Get current open File:
		try {
			final IFile specification2Parse = (IFile)PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().
					   getActivePart().getSite().getPage().getActiveEditor().getEditorInput().getAdapter(IFile.class);
			
			//Get File to Open:
			final String text = currentEObjectNode.getText().toString();
			final IFile signature2Parse = iFileFromParent(specification2Parse, text.substring(text.indexOf(",")+1,text.length()-1).trim() + "_Signature.tdpf");
			
			//Do Validation:
			if (null != signature2Parse) {
				System.out.println("Validate " + signature2Parse.getFullPath());
				final Injector injector = new DPFTextStandaloneSetup().createInjectorAndDoEMFRegistration();
				final IParser parser = injector.getInstance(DPFTextParser.class);
				try {

					//Get Specification:
					Specification spec = null;
					Signature sig = null;
					{
						final IParseResult result = parser.parse(new InputStreamReader(specification2Parse.getContents()));
						final EObject eRoot = result.getRootASTElement();
						if(eRoot instanceof Specification){
							spec = (Specification) eRoot;
						}else{
							throw new RuntimeException(specification2Parse.getFullPath() + " does not contain a valid signature semantic!");							
						}
					}
									
					//Get Signature:
					{		
						final IParseResult result = parser.parse(new InputStreamReader(signature2Parse.getContents()));
						final EObject eRoot = result.getRootASTElement();
						if(eRoot instanceof Signature){
							sig = (Signature) eRoot;							
						}else{
							throw new RuntimeException(signature2Parse.getFullPath() + " does not contain a valid signature semantic!");							
						}
					}
					
					//Validate:
					if(null != spec && null != sig){
						Tuple<Map<Long,String>,List<String>> errors=JavaScalaBridge.checkConstraints(spec, sig);
						printUnspecifiedErrorMessages(errors.y);
						System.out.println("Validation errors found " + errors.x.size());
						setErrorMessages(errors.x,specification2Parse);
					}
					
				} catch (Exception e) {
					throw new RuntimeException(e);
				}
				throw new RuntimeException(signature2Parse.getFullPath() + " does not contain a valid signature semantic!");	
			}
			
		} catch (Exception e) {
			//ignore
		}
		//do nothing
		return null;
	}

	
	@Override
	public boolean isEnabled() {
		IWorkbench wb = PlatformUI.getWorkbench();
		IWorkbenchWindow win = wb.getActiveWorkbenchWindow();
		IWorkbenchPage page = win.getActivePage();
		IWorkbenchPart part = page.getActivePart();
		if (part instanceof ContentOutline) {
			ISelection selection = ((ContentOutline) part).getSelection();
			if (selection instanceof IStructuredSelection) {
				IStructuredSelection ss = (IStructuredSelection) selection;
				Object sel = ss.getFirstElement();
				if (sel instanceof EObjectNode) {
					currentEObjectNode = (EObjectNode) sel;
					final String check = currentEObjectNode.getText().toString();
					return check.startsWith("Specification:(");
				}
			}
		}
		return false;
	}
}
