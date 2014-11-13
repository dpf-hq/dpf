package no.hib.dpf.utils.internal.signature;


public abstract class AbstractSingleNodePredicate extends AbstractBasePredicate {

	public AbstractSingleNodePredicate(String symbol, String parameter) {
		super(symbol, parameter, "X", "");
	}
	public AbstractSingleNodePredicate(String symbol) {
		super(symbol, null, "X", "");
	}

}
