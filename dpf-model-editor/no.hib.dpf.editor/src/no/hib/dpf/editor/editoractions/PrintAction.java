package no.hib.dpf.editor.editoractions;

import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.print.PrintGraphicalViewerOperation;
import org.eclipse.jface.action.Action;
import org.eclipse.swt.SWT;
import org.eclipse.swt.printing.PrintDialog;
import org.eclipse.swt.printing.Printer;
import org.eclipse.swt.printing.PrinterData;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

public class PrintAction extends Action {

	private GraphicalViewer viewer;
	
	public PrintAction(GraphicalViewer viewer) {
		this.viewer = viewer;
	}
	
	@Override
	public void run() {
		int style = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell().getStyle();

		Shell shell = new Shell ((style & SWT.MIRRORED) != 0 ? SWT.RIGHT_TO_LEFT:SWT.NONE);

		PrintDialog dialog = new PrintDialog(shell,SWT.NULL);

		PrinterData data = dialog.open();

		if(data != null)

		{

		PrintGraphicalViewerOperation operation = new PrintGraphicalViewerOperation(new Printer(data), viewer);

		// here you can set the Print Mode

		operation.setPrintMode(2);

		operation.run("Printing Gef");

		}		
	}
}
