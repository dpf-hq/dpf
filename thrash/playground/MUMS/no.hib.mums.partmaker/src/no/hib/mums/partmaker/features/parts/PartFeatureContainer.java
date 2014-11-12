package no.hib.mums.partmaker.features.parts;

import no.hib.mums.shared.FeatureContainer;

import org.eclipse.graphiti.features.IAddFeature;
import org.eclipse.graphiti.features.ICreateFeature;
import org.eclipse.graphiti.features.IDeleteFeature;
import org.eclipse.graphiti.features.IDirectEditingFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.ILayoutFeature;
import org.eclipse.graphiti.features.IMoveShapeFeature;
import org.eclipse.graphiti.features.IRemoveFeature;
import org.eclipse.graphiti.features.IResizeShapeFeature;
import org.eclipse.graphiti.features.IUpdateFeature;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.custom.ICustomFeature;
import org.eclipse.graphiti.features.impl.DefaultMoveShapeFeature;
import org.eclipse.graphiti.features.impl.DefaultRemoveFeature;
import org.eclipse.graphiti.features.impl.DefaultResizeShapeFeature;

//Superklasse for parts. Skal innehalda visualisering frå AddFeature, samt part-spesifikke features.
//+ relevant namninfo...

/*
Ideen er at kvar Part subklassar container, så tek vi å "tømmer" containeren i featureprovider

Alle parts har lik visualisering no, men kan overridast. (AddFeature)

Ein kan ha fleire custom features pr part, men berre ein CRUD
*/
public class PartFeatureContainer implements FeatureContainer {	
	public PartFeatureContainer() {
	
	}
	
	//Oppretting av grafisk object, samt linking mot businessobjekt
	public IAddFeature getAddFeature(IFeatureProvider fp) {
		return new AddPartFeature(fp);
	}
	
	//Custom features er ting som contextmenyar, ekstra knappar osv.
	public ICustomFeature[] getCustomFeatures(ICustomContext cc) {
		return new ICustomFeature[]{};
	}

	//Create features lagar knapp i toolbar for oppretting av eit grafisk element (addFeature)
	@Override
	public ICreateFeature getCreateFeature(IFeatureProvider fp) {
		return new CreatePartFeature(fp, "Default part", "Default description") {
			
			@Override
			public Object[] create(ICreateContext context) {
				String tmp = "Default";
				
				addGraphicalRepresentation(context, tmp);
				
				return new Object[] {tmp};
			}
		};
	}

	@Override
	public IUpdateFeature getUpdateFeature(IFeatureProvider fp) {
		// TODO Auto-generated method stub
		return new UpdatePartFeature(fp);
	}

	@Override
	public ILayoutFeature getLayoutFeature(IFeatureProvider fp) {
		// TODO Auto-generated method stub
		return new LayoutPartFeature(fp);
	}

	@Override
	public IRemoveFeature getRemoveFeature(IFeatureProvider fp) {
		return new DefaultRemoveFeature(fp);
	}

	@Override
	public IMoveShapeFeature getMoveFeature(IFeatureProvider fp) {
		return new DefaultMoveShapeFeature(fp);
	}

	@Override
	public IResizeShapeFeature getResizeFeature(IFeatureProvider fp) {
		return new DefaultResizeShapeFeature(fp);
	}

	@Override
	public IDeleteFeature getDeleteFeature(IFeatureProvider fp) {
		return new DeletePartFeature(fp);
	}

	@Override
	public ICustomFeature[] getCustomFeatures(IFeatureProvider fp) {
		return new ICustomFeature[] {
			new AddAttributeCustomFeature(fp)
		};
	}

	@Override
	public IDirectEditingFeature getDirectEditingFeature(IFeatureProvider fp) {
		System.out.println("directedit feature creation");
		return new DirectEditingPartAttributeFeature(fp);
	}
}
