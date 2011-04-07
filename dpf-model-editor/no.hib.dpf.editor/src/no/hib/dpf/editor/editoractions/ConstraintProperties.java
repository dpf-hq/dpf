package no.hib.dpf.editor.editoractions;

import no.hib.dpf.editor.model.DConstraint;
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
	private DConstraint.ConstraintType constraintType;
	
	public ConstraintProperties(Predicate predicate, String text, String tooltipText, DConstraint.ConstraintType constraintType) {
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

	public DConstraint.ConstraintType getConstraintType() {
		return constraintType;
	}

}
