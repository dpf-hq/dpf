package no.hib.mums.shipmaker;

import java.util.HashMap;

import static no.hib.mums.shared.MumsConstants.*;
import no.hib.dpf.core.Arrow;
import no.hib.dpf.core.Node;
import no.hib.mums.shared.FeatureContainer;
import no.hib.mums.shipmaker.features.parts.AddPartConnectionFeature;
import no.hib.mums.shipmaker.features.parts.CreatePartConnectionFeature;
import no.hib.mums.shipmaker.features.parts.PartFeatureContainer;

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
import org.eclipse.graphiti.mm.pictograms.ConnectionDecorator;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.ui.features.DefaultFeatureProvider;

public class FeatureProvider extends DefaultFeatureProvider {

	private static ShipHelper sh = DiagramTypeProvider.getHelperInstance();
	
	HashMap<String, FeatureContainer> featureContainers;
	
	public FeatureProvider(IDiagramTypeProvider dtp) {
		super(dtp);
		featureContainers = new HashMap<String, FeatureContainer>();
//		featureContainers.put(HULL, new HullFeatureContainer());
//		featureContainers.put(PROPULSOR, new PropulsorFeatureContainer());
//		featureContainers.put(ACTUATOR, new ActuatorFeatureContainer());
//		featureContainers.put(CONTROLLER, new ControllerFeatureContainer());
//		featureContainers.put(THRUSTER_CONTROL, new ThrusterControlFeatureContainer());
	}

	public void init() {
		DiagramTypeProvider dtp = (DiagramTypeProvider)getDiagramTypeProvider();
		
		for(String s : sh.getPartMap().keySet()) {
			//Only the nodes are present in partmap
			featureContainers.put(s, new PartFeatureContainer(s));
		}
		
		try {
			dtp.getDiagramEditor().refreshPalette();
		} catch(NullPointerException e) {
			//Case where the editor hasn't been loaded yet. We ignore it and wait for the next call.
		}
	}
	
	@Override
	public IAddFeature getAddFeature(IAddContext context) {
		if(context.getNewObject() instanceof Node) {
			Node n = (Node)context.getNewObject();
			FeatureContainer fc = getFeatureContainerForNode(n);
			return fc.getAddFeature(this);
		}
		if(context.getNewObject() instanceof Arrow) {
			//isattribute isrelation
			return new AddPartConnectionFeature(this);
		}
		return super.getAddFeature(context);
	}
	
	private FeatureContainer getFeatureContainerForNode(Node n) {
		if(n != null) {
//			System.out.println("Reqesting featureContainer: " + n.getName());
			return featureContainers.get(n.getName());
		}
		
		return null;
	}
	
	@Override
	public ICreateFeature[] getCreateFeatures() {
//		System.out.println("Ship#getCreateFeature");
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
		return new ICreateConnectionFeature[] {
				new CreatePartConnectionFeature(this, "Relation", "Create new Relation arrow")};
	}
	
	@Override
	public IUpdateFeature getUpdateFeature(IUpdateContext context) {
//		PictogramElement pictogramElement = context.getPictogramElement();
//		if (pictogramElement instanceof ContainerShape) {
//			Object bo = getBusinessObjectForPictogramElement(pictogramElement);
//			if (bo instanceof Node) {
//				return getFeatureContainerForNode((Node)bo).getUpdateFeature(this);
//
//			}
//		}
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
//		PictogramElement pictogramElement = context.getPictogramElement();
//		Object bo = getBusinessObjectForPictogramElement(pictogramElement);
//		if (bo instanceof Node) {
//			return getFeatureContainerForNode((Node)bo).getLayoutFeature(this);
//		}
		return super.getLayoutFeature(context);
	}
	
	@Override
	public IDeleteFeature getDeleteFeature(IDeleteContext context) {
//		PictogramElement pictogramElement = context.getPictogramElement();
//		Object bo = getBusinessObjectForPictogramElement(pictogramElement);
//		if (bo instanceof Node) {
//			return getFeatureContainerForNode((Node)bo).getDeleteFeature(this);
//		} 
		return super.getDeleteFeature(context);
	}
	
	@Override
	public ICustomFeature[] getCustomFeatures(ICustomContext context) {
//		PictogramElement[] pe = context.getPictogramElements();
//		if(pe.length == 1 && pe[0] instanceof ContainerShape) {
//			Object o = getBusinessObjectForPictogramElement(pe[0]);
//			if(o instanceof Node) {
//				return getFeatureContainerForNode((Node)o).getCustomFeatures(this);
//			}
//		}

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
		if(pe instanceof ConnectionDecorator) {
			ConnectionDecorator cd = (ConnectionDecorator)pe;
			pe = cd.getConnection();
		}
		Object o = getBusinessObjectForPictogramElement(pe);
		
		System.out.println(o);
		if(o instanceof Arrow && sh.descendantOf((Arrow)o, RELATION)) {
			return getFeatureContainerForNode(((Arrow)o).getSource()).getDirectEditingFeature(this);
		}

		return super.getDirectEditingFeature(context);
	}
	
}
