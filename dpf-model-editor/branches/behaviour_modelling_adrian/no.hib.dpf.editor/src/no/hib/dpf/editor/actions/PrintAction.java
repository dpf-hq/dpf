/*******************************************************************************
 * Copyright (c) 2011 Høyskolen i Bergen
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Øyvind Bech and Dag Viggo Lokøen - DPF Editor
*******************************************************************************/
package no.hib.dpf.editor.actions;

import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.internal.GEFMessages;
import org.eclipse.gef.print.PrintGraphicalViewerOperation;
import org.eclipse.jface.action.Action;
import org.eclipse.swt.SWT;
import org.eclipse.swt.printing.PrintDialog;
import org.eclipse.swt.printing.Printer;
import org.eclipse.swt.printing.PrinterData;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.ActionFactory;

@SuppressWarnings("restriction")
public class PrintAction extends Action {

	private GraphicalViewer viewer;

	public PrintAction(GraphicalViewer viewer) {
		super(GEFMessages.PrintAction_Label, AS_PUSH_BUTTON);
		this.viewer = viewer;
		setToolTipText(GEFMessages.PrintAction_Tooltip);
		setId(ActionFactory.PRINT.getId());
		setActionDefinitionId(ActionFactory.PRINT.getId());
	}

	@Override
	public void run() {
		int style = PlatformUI.getWorkbench().getActiveWorkbenchWindow()
				.getShell().getStyle();

		Shell shell = new Shell((style & SWT.MIRRORED) != 0 ? SWT.RIGHT_TO_LEFT
				: SWT.NONE);
		PrintDialog dialog = new PrintDialog(shell, SWT.NULL);
		PrinterData data = dialog.open();

		if (data != null) {
			PrintGraphicalViewerOperation operation = new PrintGraphicalViewerOperation(
					new Printer(data), viewer);

			// here you can set the Print Mode
			operation.setPrintMode(2);
			operation.run("Printing Gef");
		}
	}
}
