package no.dpf.text.plugin;

import no.dpf.text.graph.parser._;

import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;
import java.io._;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IActionDelegate;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;

class RunParser extends IObjectActionDelegate {

	var FILE_EXT=".tdpf";	
	var shell:Shell=null;

	//Redirect output:
    val bout = new ByteArrayOutputStream();
//    System.setOut(new PrintStream(bout));
	
	/**
	 * @see IObjectActionDelegate#setActivePart(IAction, IWorkbenchPart)
	 */
	override def setActivePart(action:IAction, targetPart:IWorkbenchPart) {
		shell = targetPart.getSite().getShell();
	}

	/**
	 * @see IActionDelegate#run(IAction)
	 */
	override def run(action:IAction) {
		try {
			val selection = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getSelectionService().getSelection(); 
		    if(null != selection && selection.isInstanceOf[StructuredSelection]){		    	
		    	val ss = selection.asInstanceOf[StructuredSelection];
				val file = ss.getFirstElement().asInstanceOf[IFile];
				if(null == file)return;
				if(!file.getName().endsWith(FILE_EXT)){
					MessageDialog.openInformation(shell, "no.dpf.text.plugin.RunParser","DPF-Test files must end with "+ FILE_EXT);
				}else{
					doAction(file);
				}			
		    	
		    }	
		} catch {
			case e => MessageDialog.openError(shell, "no.dpf.text.plugin.RunParser",e.getMessage());
		}			
	}

	private def doAction(file:IFile){
	
	   //Run Workflow:
	   val wsFile=file.getLocation().toPortableString();
	   val project = file.getProject();
	   val targetDir = project.getLocation().toPortableString() + "/" + file.getParent().getProjectRelativePath().toString();
	   
	   //Redirect output:
	   bout.reset()
	   
	   //Start Parser:
	   Main.main(Array(wsFile,targetDir));
	   
	   MessageDialog.openInformation(shell, "no.dpf.text.plugin.RunParser",new String(bout.toByteArray,"UTF-8"));
	   
	   //Refresh Folder:
	   try {
		   file.getParent().refreshLocal(1, null);
	   }catch{
			case e => e.printStackTrace();
	   }

	}
	
	/**
	 * @see IActionDelegate#selectionChanged(IAction, ISelection)
	 */
	override def selectionChanged(action:IAction,selection:ISelection) {
	}

}
