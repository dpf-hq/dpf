package no.hib.dpf.editor.signature;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;

public class EnumeratorCombo extends ComboViewer{

	private final IContentProvider contentProvider = new IStructuredContentProvider() {
		
		@Override
		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) { }
		
		@Override
		public void dispose() { }
		
		@Override
		public Object[] getElements(Object inputElement) {
			Assert.isTrue(inputElement instanceof Enumerator[]);
			return (Enumerator[])inputElement;
		}
	};
	
	private final ILabelProvider labelProvider = new LabelProvider(){
		public String getText(Object element) {
			Assert.isTrue(element instanceof Enumerator);
			return ((Enumerator)element).getLiteral();
		}
	};
	
	public EnumeratorCombo(Composite parent, int style) {
		super(parent, style);
		GridData gridData = new GridData(GridData.BEGINNING, GridData.FILL, false, false);
		gridData.horizontalSpan = 2;
		getControl().setLayoutData(gridData);
		setContentProvider(contentProvider);
		setLabelProvider(labelProvider);
	}
}