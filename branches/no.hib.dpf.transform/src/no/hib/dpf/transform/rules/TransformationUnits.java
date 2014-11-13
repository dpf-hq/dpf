package no.hib.dpf.transform.rules;

import org.eclipse.emf.henshin.model.impl.IndependentUnitImpl;
import org.eclipse.emf.henshin.model.impl.SequentialUnitImpl;
import org.eclipse.emf.henshin.model.impl.UnitImpl;

public enum TransformationUnits {
//	SEQUENTIAL_UNIT("SequentialUnit"),
//	INDEPENDENT_UNIT("IndependentUnit ");
	SEQUENTIAL_UNIT(new SequentialUnitImpl()),
	INDEPENDENT_UNIT(new IndependentUnitImpl());
	
	private UnitImpl transformationUnit;
	
	TransformationUnits(UnitImpl unitImplementation){
		this.transformationUnit=unitImplementation;
	}
	public UnitImpl getTransformationUnit(){
		return transformationUnit;
	}
}
