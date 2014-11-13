package no.hib.dpf.m2m.transformation;

import java.io.File;
import java.io.IOException;

import no.hib.dpf.diagram.DSpecification;
import no.hib.dpf.m2m.transformation.parser.DPFTemplates;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;

public class SmodltoDPFTransformation extends AbstractHandler{

	private String fileLocation,dpfFile;
	
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		
		
		IStructuredSelection selection = (IStructuredSelection) HandlerUtil.getActiveMenuSelection(event);
		Object firstElement = selection.getFirstElement();
		
		if (firstElement instanceof IFile) {
			IFile file = (IFile) firstElement;
			if (file.getName().endsWith("xml")) {
				
				createTheDPFFiles(file);
				DPFTemplates.dpfFileTempleteToGenerate(dpfFile,file);
				/*DSpecification newSpec = DiagramFactory.eINSTANCE.createDefaultDSpecification();
				newSpec = DPFDiagramUtil.loadSpecWithMetaModel(newSpec);
				DPFDiagramUtil.loadSMODLModel(newSpec,dpfFile);*/
				//XmlParser.SmodlXMLParser(getFileLocation(file)+"/"+file.getName().toString());
				//DSpecification newSpec = loadSpecificationWithMetaModel();
				try {
					file.getParent().refreshLocal(1, null);
				} catch (CoreException e) {
					e.printStackTrace();
				}

			}else
			{
				MessageDialog.openInformation(HandlerUtil.getActiveShell(event), "Information",
						"Please select a SMODL xml file");
			}
		}
		
		return null;
	}

	protected void createTheDPFFiles(IFile file){
		String fileName;
		int index = file.getName().indexOf(".");
		if (index != -1 ){
			dpfFile = getFileLocation(file);
			fileName = file.getName().substring(0,index);
			dpfFile = dpfFile+ "/" + fileName + ".dpf";
			File newFILE = new File(dpfFile);
			try {
				newFILE.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	protected URI getURIForFile(String file) {
		return URI.createFileURI(file);
	}
	
	protected DSpecification loadSpecificationWithMetaModel(){
		return null;
	}
	
	protected String getFileLocation(IFile file){
		int index = file.getName().indexOf(".");
		if (index != -1 ){
			fileLocation = file.getProject().getLocation().toPortableString()
					+ "/"
					+ file.getParent().getProjectRelativePath().toString();
					
		}
		return fileLocation;
	}
	
	
}
