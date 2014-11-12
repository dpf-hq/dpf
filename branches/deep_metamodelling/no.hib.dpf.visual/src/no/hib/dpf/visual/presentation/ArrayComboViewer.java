package no.hib.dpf.visual.presentation;

import java.util.List;

import no.hib.dpf.visualization.util.EMFUtils;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;

public class ArrayComboViewer extends ComboViewer{

	private final IContentProvider contentProvider = new IStructuredContentProvider() {
		
		@Override
		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) { }
		
		@Override
		public void dispose() { }
		
		@SuppressWarnings({ "rawtypes", "unchecked" })
		@Override
		public Object[] getElements(Object inputElement) {
			if(inputElement instanceof Object[])
				return (Object[])inputElement;
			if(inputElement instanceof List){
				List l = (List)inputElement;
				return (l).toArray(new Object[l.size()]);
			}
			return new Object[]{inputElement};
		}
	};
	
	private final ILabelProvider labelProvider = new LabelProvider(){
		@Override
		public String getText(Object element) {
			if(element instanceof EObject){
				EAttribute e = EMFUtils.getEAttribute(((EObject) element).eClass(), "name");
				if(e != null && EMFUtils.isParentClass(e.getEAttributeType().getInstanceClass(), String.class)){
					return (String) e.eGet(e);
				}
			}
			return element.toString();
		}
	};
	
	public ArrayComboViewer(Composite parent, int style) {
		super(parent, style);
		GridData gridData = new GridData(GridData.BEGINNING, GridData.FILL, false, false);
		gridData.horizontalSpan = 2;
		getControl().setLayoutData(gridData);
		setContentProvider(contentProvider);
		setLabelProvider(labelProvider);
	}
}