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
				setImageDescriptor(getImageDescriptor(ImageSettings.SMALL_CONNECTION));
//			setImageDescriptor(InternalImages.DESC_VERT_ALIGN_BOTTOM);
//			setDisabledImageDescriptor(InternalImages.DESC_VERT_ALIGN_BOTTOM_DIS);
				break;
			case JOINTLY_INJECTIVE:
				setId(CreateJointlyInjectiveConstraintAction.ID);
				setImageDescriptor(getImageDescriptor(ImageSettings.SMALL_CONNECTION));
				break;
			case JOINTLY_SURJECTIVE:
				setId(CreateJointlySurjectiveConstraintAction.ID);
				setImageDescriptor(getImageDescriptor(ImageSettings.SMALL_CONNECTION));
				break;
			case MULTIPLICITY:
				setId(CreateMultiplicityConstraintAction.ID);
				setImageDescriptor(getImageDescriptor(ImageSettings.SMALL_CONNECTION));
				break;
		}
		// TODO Auto-generated constructor stub
	}

}
