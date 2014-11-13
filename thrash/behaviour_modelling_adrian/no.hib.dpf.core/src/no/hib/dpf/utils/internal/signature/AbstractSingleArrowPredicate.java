package no.hib.dpf.utils.internal.signature;


public abstract class AbstractSingleArrowPredicate extends AbstractBasePredicate {

	public AbstractSingleArrowPredicate(String symbol, String parameter) {
		super(symbol, parameter, "X,Y", "XY:X:Y");
	}
	public AbstractSingleArrowPredicate(String symbol) {
		super(symbol, null, "X,Y", "XY:X:Y");
	}

}
