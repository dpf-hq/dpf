package no.hib.dpf.visual.presentation;

import no.hib.dpf.visual.VNode;

import org.eclipse.jface.preference.ColorSelector;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.forms.IDetailsPage;

public class VNodeBlock extends AbstractBlock implements IDetailsPage {


	private ComboViewer compositeCombo;
	private ComboViewer roundedCombo;
	private ColorSelector colorSelector;

	public VNode getVNode(){
		return (VNode) vElement;
	}
	public VNodeBlock(VisualMasterBlock signatureMasterBlock) {
		super(signatureMasterBlock);
	}

	public void refreshOthers() {
			compositeCombo.setSelection(new StructuredSelection(getVNode().isComposite()));
			roundedCombo.setSelection(new StructuredSelection(getVNode().isRounded()));
			colorSelector.setColorValue(getVNode().getColor());
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
		roundedCombo.addSelectionChangedListener(new ISelectionChangedListener() {

			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				boolean type = false;
				if (!event.getSelection().isEmpty())
					type = (Boolean)((IStructuredSelection)event.getSelection()).getFirstElement();
				if(type == getVNode().isRounded())
					return;
				getVNode().setRounded(type);
				master.getMultiEditor().setDirty(true);
			}
		});
		colorSelector.addListener(new IPropertyChangeListener() {
			
			@Override
			public void propertyChange(PropertyChangeEvent event) {
				RGB color = null;
				if (event.getNewValue() != null)
					color = ((RGB)event.getNewValue());
				if(color == getVNode().getColor())
					return;
				getVNode().setColor(colorSelector.getColorValue());
				master.getMultiEditor().setDirty(true);
			}
		});
	}

	@Override
	protected void createControl(Composite infoComposite) {
		Label compositeLabel = new Label(infoComposite, SWT.NONE);
		compositeLabel.setText("Composite:");
		GridData gridData = new GridData(GridData.BEGINNING, GridData.CENTER, false, false);
		compositeLabel.setLayoutData(gridData);
		compositeCombo = new ArrayComboViewer(infoComposite, SWT.NONE);
		compositeCombo.setInput(BOOLEANS);
		GridData comboGridData = new GridData(GridData.FILL, GridData.FILL, true, false);
		comboGridData.horizontalSpan = 2;
		compositeCombo.getControl().setLayoutData(comboGridData);
		
		Label roundedLabel = new Label(infoComposite, SWT.NONE);
		roundedLabel.setText("Rounded corners:");
		GridData roundedGridData = new GridData(GridData.BEGINNING, GridData.CENTER, false, false);
		roundedLabel.setLayoutData(roundedGridData);
		roundedCombo = new ArrayComboViewer(infoComposite, SWT.NONE);
		roundedCombo.setInput(BOOLEANS);
		roundedCombo.getControl().setLayoutData(comboGridData);
		
		Label colorLabel = new Label(infoComposite, SWT.NONE);
		colorLabel.setText("Background color:");
		GridData colorGridData = new GridData(GridData.BEGINNING, GridData.CENTER, false, false);
		colorLabel.setLayoutData(colorGridData);
		colorSelector = new ColorSelector(infoComposite);
	}
}
