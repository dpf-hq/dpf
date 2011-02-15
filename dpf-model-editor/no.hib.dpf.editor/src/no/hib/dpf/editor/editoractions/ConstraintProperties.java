package no.hib.dpf.editor.editoractions;

import no.hib.dpf.editor.viewmodel.VConstraint;
import no.hib.dpf.metamodel.Predicate;

/**
 * Class for managing the properties needed to construct a constraint action.
 * @author oyvind
 *
 */
public class ConstraintProperties {
	
	private Predicate predicate;
	private String text;
	private String tooltipText;
	private VConstraint.ConstraintType constraintType;
	
	public ConstraintProperties(Predicate predicate, String text, String tooltipText, VConstraint.ConstraintType constraintType) {
		this.predicate = predicate;
		this.text = text;
		this.tooltipText = tooltipText;
		this.constraintType = constraintType;
	}

	public Predicate getPredicate() {
		return predicate;
	}

	public String getText() {
		return text;
	}

	public String getTooltipText() {
		return tooltipText;
	}

	public VConstraint.ConstraintType getConstraintType() {
		return constraintType;
	}

}
