package no.hib.dpf.visual.presentation;


import no.hib.dpf.visual.VArrow;

import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.forms.IDetailsPage;

public class VArrowBlock extends AbstractBlock implements IDetailsPage {


	private ComboViewer composedCombo;

	public VArrow getVArrow(){
		return (VArrow) this.vElement;
	}
	
	public VArrowBlock(VisualMasterBlock signatureMasterBlock) {
		super(signatureMasterBlock);
	}

	@Override
	public void refreshOthers() {
		composedCombo.setSelection(new StructuredSelection(getVArrow().isComposed()));
	}
	
	@Override
	protected void addListeners(){
		super.addListeners();
		composedCombo.addSelectionChangedListener(new ISelectionChangedListener() {

			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				boolean type = false;
				if (!event.getSelection().isEmpty())
					type = (Boolean)((IStructuredSelection)event.getSelection()).getFirstElement();
				if(type == getVArrow().isComposed())
					return;
				getVArrow().setComposed(type);
				master.getMultiEditor().setDirty(true);
			}
		});
	}

	@Override
	protected void createControl(Composite infoComposite) {
		Label visulationLabel = new Label(infoComposite, SWT.NONE);
		visulationLabel.setText("Composed:");
		GridData gridData = new GridData(GridData.BEGINNING, GridData.FILL, false, false);
		gridData.verticalSpan = 3;
		gridData.minimumWidth = 20;
		visulationLabel.setLayoutData(gridData);
		composedCombo = new ArrayComboViewer(infoComposite, SWT.NONE);
		composedCombo.setInput(BOOLEANS);
		composedCombo.getControl().setLayoutData(new GridData(GridData.FILL, GridData.FILL, true, false));
	}
}
