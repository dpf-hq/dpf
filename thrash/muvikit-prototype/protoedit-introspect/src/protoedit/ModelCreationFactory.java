package protoedit;

import org.eclipse.gef.requests.CreationFactory;

import protomodel.Clazz;
import protomodel.ProtomodelFactory;

public class ModelCreationFactory implements CreationFactory {

	private Class<?> clazz;
	public ModelCreationFactory(Class<?> clazz) {
		this.clazz = clazz;
	}
	
	@Override
	public Object getNewObject() {
		if(clazz == Clazz.class) {
			return ProtomodelFactory.eINSTANCE.createClazz();
		}
		return null;
	}

	@Override
	public Object getObjectType() {
		// TODO Auto-generated method stub
		return null;
	}

}
