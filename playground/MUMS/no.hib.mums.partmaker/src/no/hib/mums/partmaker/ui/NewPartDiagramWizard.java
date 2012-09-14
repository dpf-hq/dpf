package no.hib.mums.partmaker.ui;

import no.hib.mums.shared.MumsConstants;
import no.hib.mums.shared.NewDiagramWizard;

public class NewPartDiagramWizard extends NewDiagramWizard {
	private final static String WIZARD_TITLE = "New PartMaker Diagram";
	private final static String DIAGRAM_TITLE = "PartMaker Diagram";
	
	public NewPartDiagramWizard() {
		super(WIZARD_TITLE, DIAGRAM_TITLE, MumsConstants.PARTMAKER_DIAGRAM_TYPE);
	}

}
