package no.hib.dpf.editor.editoractions;

import no.hib.dpf.editor.DPFPlugin;
import no.hib.dpf.editor.icons.ImageSettings;
import no.hib.dpf.editor.model.VConstraint;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.actions.LabelRetargetAction;

public class ConstraintRetargetAction extends LabelRetargetAction {
	
	private ImageDescriptor getImageDescriptor(ImageSettings imageSettings) {
		return ImageDescriptor.createFromFile(DPFPlugin.class, imageSettings.getFilePath());
	}

	public ConstraintRetargetAction(VConstraint.ConstraintType constraintType) {
		super(null, null);
		switch (constraintType) {
			case INVERSE: 
				setId(CreateInverseConstraintAction.ID);
				setImageDescriptor(getImageDescriptor(ImageSettings.INVERSE));
//			setImageDescriptor(InternalImages.DESC_VERT_ALIGN_BOTTOM);
//			setDisabledImageDescriptor(InternalImages.DESC_VERT_ALIGN_BOTTOM_DIS);
				break;
			case JOINTLY_INJECTIVE:
				setId(CreateJointlyInjectiveConstraintAction.ID);
				setImageDescriptor(getImageDescriptor(ImageSettings.JOINTLY_INJECTIVE));
				break;
			case JOINTLY_SURJECTIVE:
				setId(CreateJointlySurjectiveConstraintAction.ID);
				setImageDescriptor(getImageDescriptor(ImageSettings.JOINTLY_SURJECTIVE));
				break;
			case MULTIPLICITY:
				setId(CreateMultiplicityConstraintAction.ID);
				setImageDescriptor(getImageDescriptor(ImageSettings.MULTIPLICITY));
				break;
			case IMAGE_INCLUSION:
				setId(CreateImageInclusionConstraintAction.ID);
				setImageDescriptor(getImageDescriptor(ImageSettings.IMAGE_INCLUSION));
				break;
			case COMPOSITION:
				setId(CreateCompositionConstraintAction.ID);
				setImageDescriptor(getImageDescriptor(ImageSettings.COMPOSITION));
				break;
			case INJECTIVE:
				setId(CreateInjectiveConstraintAction.ID);
				setImageDescriptor(getImageDescriptor(ImageSettings.INJECTIVE));
				break;
			case SURJECTIVE:
				setId(CreateSurjectiveConstraintAction.ID);
				setImageDescriptor(getImageDescriptor(ImageSettings.SURJECTIVE));
				break;
			case IRREFLEXIVE:
				setId(CreateIrreflexiveConstraintAction.ID);
				setImageDescriptor(getImageDescriptor(ImageSettings.IRREFLEXIVE));
				break;
			case TRANSITIVE_IRREFLEXIVE:
				setId(CreateTransitiveIrreflexiveConstraintAction.ID);
				setImageDescriptor(getImageDescriptor(ImageSettings.TRANSITIVE_IRREFLEXIVE));
				break;
			case XOR:
				setId(CreateXORConstraintAction.ID);
				setImageDescriptor(getImageDescriptor(ImageSettings.XOR));
				break;
			
			
		}
		// TODO Auto-generated constructor stub
	}

}
