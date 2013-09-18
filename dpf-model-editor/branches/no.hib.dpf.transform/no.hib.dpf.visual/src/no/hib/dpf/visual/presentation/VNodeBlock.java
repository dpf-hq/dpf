package no.hib.dpf.visual.presentation;


import no.hib.dpf.visual.VNode;

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

public class VNodeBlock extends AbstractBlock implements IDetailsPage {


	private ComboViewer compositeCombo;

	public VNode getVNode(){
		return (VNode) vElement;
	}
	public VNodeBlock(VisualMasterBlock signatureMasterBlock) {
		super(signatureMasterBlock);
	}

	public void refreshOthers() {
			compositeCombo.setSelection(new StructuredSelection(getVNode().isComposite()));
	}
	
	protected void addListners(){
		super.addListners();
		compositeCombo.addSelectionChangedListener(new ISelectionChangedListener() {

			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				boolean type = false;
				if (!event.getSelection().isEmpty())
					type = (Boolean)((IStructuredSelection)event.getSelection()).getFirstElement();
				if(type == getVNode().isComposite())
					return;
				getVNode().setComposite(type);
				master.getMultiEditor().setDirty(true);
			}
		});
	}

	@Override
	protected void createControl(Composite infoComposite) {
		Label visulationLabel = new Label(infoComposite, SWT.NONE);
		visulationLabel.setText("Composite:");
		GridData gridData = new GridData(GridData.BEGINNING, GridData.FILL, false, false);
		gridData.verticalSpan = 3;
		gridData.minimumWidth = 20;
		visulationLabel.setLayoutData(gridData);
		compositeCombo = new ArrayComboViewer(infoComposite, SWT.NONE);
		compositeCombo.setInput(BOOLEANS);
		compositeCombo.getControl().setLayoutData(new GridData(GridData.FILL, GridData.FILL, true, false));
	}
}
