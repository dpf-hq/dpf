package no.hib.mums.partmaker.features.parts;

import java.util.List;

import no.hib.dpf.core.Arrow;
import no.hib.dpf.core.Node;
import no.hib.mums.partmaker.DiagramTypeProvider;
import no.hib.mums.partmaker.FeatureProvider;
import no.hib.mums.partmaker.PartHelper;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.algorithms.styles.Orientation;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeCreateService;
import org.eclipse.graphiti.ui.internal.util.ui.PopupMenu;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;

@SuppressWarnings("restriction")
public class AddAttributeCustomFeature extends
		AbstractCustomFeature {
	final IGaService gaService = Graphiti.getGaService();
	final IPeCreateService ps = Graphiti.getPeCreateService(); 
	
	private ILabelProvider lp = new ILabelProvider() {
		
		@Override
		public void removeListener(ILabelProviderListener listener) {
		}
		
		@Override
		public boolean isLabelProperty(Object element, String property) {
			return false;
		}
		
		@Override
		public void dispose() {
		}
		
		@Override
		public void addListener(ILabelProviderListener listener) {
		}
		
		@Override
		public String getText(Object element) {
			return ((Arrow)element).getName();
		}
		
		@Override
		public Image getImage(Object element) {
			return null;
		}
	};
	
	
	public AddAttributeCustomFeature(IFeatureProvider fp) {
		super(fp);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean canExecute(ICustomContext context) {
		// TODO Auto-generated method stub
		return true;
	}
	
	@Override
	public void execute(ICustomContext context) {
		
		PictogramElement[] pe = context.getPictogramElements();
		if(pe != null && pe.length == 1) {
			Object o = getBusinessObjectForPictogramElement(pe[0]);
			if(o instanceof Node && pe[0] instanceof ContainerShape) {
				ContainerShape cs = (ContainerShape)pe[0];
				for(Shape s : cs.getChildren()) {
					if(s.getGraphicsAlgorithm() instanceof Text) {
						System.out.println(getBusinessObjectForPictogramElement(
								s.getGraphicsAlgorithm().getPictogramElement()));
					}
				}
			}
		}
		
//		PictogramElement[] pe = context.getPictogramElements();
//		if(pe != null && pe.length == 1) {
//			Object o = getBusinessObjectForPictogramElement(pe[0]);
//			if(o instanceof Node && pe[0] instanceof ContainerShape) {
//				ContainerShape cs = (ContainerShape)pe[0];
//				
//				Arrow a = addType((Node)o);
//				if (a != null) {
//					link(addAttribute(a, cs), a);
//				}
//			} else System.out.println(o);
//		}
		
	}
	
	@SuppressWarnings("deprecation")
	public Shape addAttribute(Arrow a, ContainerShape containerShape) {
//			ContainerShape labelAndText = ps.createContainerShape(containerShape, true);
			Shape label = ps.createShape(containerShape, true);

			Text attrname = gaService.createDefaultText(getDiagram(), label, a.getName());
			attrname.setHorizontalAlignment(Orientation.ALIGNMENT_LEFT);
			attrname.setVerticalAlignment(Orientation.ALIGNMENT_CENTER);
			gaService.setLocationAndSize(attrname, 5, 
					20 * (containerShape.getChildren().size() - 2), 
					containerShape.getGraphicsAlgorithm().getWidth(), 20);
			
//			Shape input = ps.createShape(containerShape, true);
//			Text attrfield = gaService.createDefaultText(getDiagram(), input, "bleh");
//			attrfield.setHorizontalAlignment(Orientation.ALIGNMENT_RIGHT);
//			attrfield.setVerticalAlignment(Orientation.ALIGNMENT_CENTER);
//			gaService.setLocationAndSize(attrfield, 5 + attrname.getWidth(), 
//					20 * (containerShape.getChildren().size() - 2), 
//					attrname.getWidth(), 20);
//			
			return label;
	}
	
	private Arrow addType(Node n) {
		List<Arrow> la = DiagramTypeProvider.getHelperInstance().getAttributesFromNode(n);

		if(la.size() > 0) {
			if(la.size() == 1) {
				return la.get(0);
			} else {
				PopupMenu pu = new PopupMenu(la, lp);
				boolean show = pu.show(Display.getCurrent().getActiveShell());
				if(show) {
					return (Arrow)pu.getResult();
				}
			}
		}
		
		return null;
	}

}
