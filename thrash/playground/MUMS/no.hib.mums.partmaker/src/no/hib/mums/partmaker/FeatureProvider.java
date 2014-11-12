package no.hib.mums.partmaker;

import java.util.HashMap;

import no.hib.dpf.core.Arrow;
import no.hib.dpf.core.Node;
import no.hib.mums.partmaker.features.parts.actuator.ActuatorFeatureContainer;
import no.hib.mums.partmaker.features.parts.controller.ControllerFeatureContainer;
import no.hib.mums.partmaker.features.parts.hull.HullFeatureContainer;
import no.hib.mums.partmaker.features.parts.propulsor.PropulsorFeatureContainer;
import no.hib.mums.partmaker.features.parts.thrustercontrol.ThrusterControlFeatureContainer;
import no.hib.mums.shared.FeatureContainer;

import static no.hib.mums.shared.MumsConstants.*;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.IAddFeature;
import org.eclipse.graphiti.features.ICreateConnectionFeature;
import org.eclipse.graphiti.features.ICreateFeature;
import org.eclipse.graphiti.features.IDeleteFeature;
import org.eclipse.graphiti.features.IDirectEditingFeature;
import org.eclipse.graphiti.features.IFeature;
import org.eclipse.graphiti.features.ILayoutFeature;
import org.eclipse.graphiti.features.IMoveShapeFeature;
import org.eclipse.graphiti.features.IResizeShapeFeature;
import org.eclipse.graphiti.features.IUpdateFeature;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.context.IDeleteContext;
import org.eclipse.graphiti.features.context.IDirectEditingContext;
import org.eclipse.graphiti.features.context.ILayoutContext;
import org.eclipse.graphiti.features.context.IMoveShapeContext;
import org.eclipse.graphiti.features.context.IPictogramElementContext;
import org.eclipse.graphiti.features.context.IResizeShapeContext;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.features.custom.ICustomFeature;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.ui.features.DefaultFeatureProvider;

public class FeatureProvider extends DefaultFeatureProvider {
	
	private static PartHelper ph = DiagramTypeProvider.getHelperInstance();
	
	private HashMap<String, FeatureContainer> featureContainers;
	
	public FeatureProvider(IDiagramTypeProvider dtp) {
		super(dtp);
		featureContainers = new HashMap<String, FeatureContainer>();
		featureContainers.put(HULL, new HullFeatureContainer());
		featureContainers.put(PROPULSOR, new PropulsorFeatureContainer());
		featureContainers.put(ACTUATOR, new ActuatorFeatureContainer());
		featureContainers.put(CONTROLLER, new ControllerFeatureContainer());
		featureContainers.put(THRUSTER_CONTROL, new ThrusterControlFeatureContainer());
	}

	@Override
	public IAddFeature getAddFeature(IAddContext context) {
		if(context.getNewObject() instanceof Node) {
			Node n = (Node)context.getNewObject();
			FeatureContainer fc = getFeatureContainerForNode(n);
			return fc.getAddFeature(this);
		}
		return super.getAddFeature(context);
	}
	
	private FeatureContainer getFeatureContainerForNode(Node n) {
		if(n != null) {
			if(ph.isHull(n)) {
				return featureContainers.get(HULL);
			} else if(ph.isProp(n)) {
				return featureContainers.get(PROPULSOR);
			} else if(ph.isController(n)) {
				return featureContainers.get(CONTROLLER);
			} else if(ph.isActuator(n)) {
				return featureContainers.get(ACTUATOR);
			} else if(ph.isThrusterControl(n)) {
				return featureContainers.get(THRUSTER_CONTROL);
			} 
		}
		
		return null;
	}
	
	@Override
	public ICreateFeature[] getCreateFeatures() {
		ICreateFeature[] res = new ICreateFeature[featureContainers.size()];
		
		int i = 0;
		for(FeatureContainer fc : featureContainers.values()) {
			res[i] = fc.getCreateFeature(this);
			i++;
		}
		
		return res;
//		return super.getCreateFeatures();
	}

	@Override
	public ICreateConnectionFeature[] getCreateConnectionFeatures() {
		return super.getCreateConnectionFeatures();
	}
	
	@Override
	public IUpdateFeature getUpdateFeature(IUpdateContext context) {
		PictogramElement pictogramElement = context.getPictogramElement();
		if (pictogramElement instanceof ContainerShape) {
			Object bo = getBusinessObjectForPictogramElement(pictogramElement);
//			if(bo instanceof Node && ((Node)bo).getName().equals("Node")) {
////				System.out.println(bo);
////				System.out.println(pictogramElement);
//				System.out.print("Invalid pe link: ");
//				for(Shape s : ((ContainerShape)pictogramElement).getChildren()) {
//					if(s instanceof Shape && ((Shape)s).getGraphicsAlgorithm() instanceof Text) {
//						GraphicsAlgorithm ga = ((Shape)s).getGraphicsAlgorithm();
//						Text t = (Text)ga;
//						System.out.print(t.getValue() + "\n");
//					}
//				}
//			}
//			else 
			if (bo instanceof Node) {
//				System.out.println("#Valid pe: " + bo);
//				EcoreUtil.resolveAll(getDiagramTypeProvider().getDiagramEditor().getEditingDomain().getResourceSet());
				return getFeatureContainerForNode((Node)bo).getUpdateFeature(this);
			}
		}
		return super.getUpdateFeature(context);
	}

	@Override
	public IMoveShapeFeature getMoveShapeFeature(IMoveShapeContext context) {
//		Shape shape = context.getShape();
//		Object bo = getBusinessObjectForPictogramElement(shape);
//		if (bo instanceof EClass) {
//			return new MoveEClassFeature(this);
//		}
		return super.getMoveShapeFeature(context);
	}
	
	@Override
	public IResizeShapeFeature getResizeShapeFeature(IResizeShapeContext context) {
//		Shape shape = context.getShape();
//		Object bo = getBusinessObjectForPictogramElement(shape);
//		//Parent shape vert returnert, mao. Node og ikkje Arrows.
//		if (bo instanceof Arrow) {
//			return new ResizeArrowFeature(this);
//		}
		return super.getResizeShapeFeature(context);
	}
	
	@Override
	public ILayoutFeature getLayoutFeature(ILayoutContext context) {
		PictogramElement pictogramElement = context.getPictogramElement();
		Object bo = getBusinessObjectForPictogramElement(pictogramElement);
		if (bo instanceof Node) {
			return getFeatureContainerForNode((Node)bo).getLayoutFeature(this);
		}
		return super.getLayoutFeature(context);
	}
	
	@Override
	public IDeleteFeature getDeleteFeature(IDeleteContext context) {
		PictogramElement pictogramElement = context.getPictogramElement();
		Object bo = getBusinessObjectForPictogramElement(pictogramElement);
		if (bo instanceof Node) {
			return getFeatureContainerForNode((Node)bo).getDeleteFeature(this);
		} 
		return super.getDeleteFeature(context);
	}
	
	@Override
	public ICustomFeature[] getCustomFeatures(ICustomContext context) {
		PictogramElement[] pe = context.getPictogramElements();
		if(pe.length == 1 && pe[0] instanceof ContainerShape) {
			Object bo = getBusinessObjectForPictogramElement(pe[0]);
			if(bo instanceof Node) {
				return getFeatureContainerForNode((Node)bo).getCustomFeatures(this);
			}
		}

		return new ICustomFeature[]{};
	}
	
	@Override
	public IFeature[] getDragAndDropFeatures(IPictogramElementContext context) {
		return getCreateConnectionFeatures();
	}
	
	@Override
	public IDirectEditingFeature getDirectEditingFeature(
			IDirectEditingContext context) {
		
		PictogramElement pe = context.getPictogramElement();
		Object o = getBusinessObjectForPictogramElement(pe);
		
		if(o instanceof Arrow && ph.isAttributeInstance((Arrow)o)) {
			return getFeatureContainerForNode(((Arrow)o).getSource()).getDirectEditingFeature(this);
		}

		return super.getDirectEditingFeature(context);
	}
}
