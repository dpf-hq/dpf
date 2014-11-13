package no.hib.dpf.visualization.util;

import java.lang.reflect.Type;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;

public class EMFUtils {

	//If class A is contained by B, return B
	public static EClass getContainerClass(EReference e){
		if(e != null)
			return e.getEReferenceType();
		return null;
	}
	public static EReference getContainerEReference(EClass c){
		for(EReference e : c.getEAllReferences())
			if(e.isContainer())
				return e;
		return null;
	}

	public static EAttribute getEAttribute(EClass c, String name){
		for(EAttribute e : c.getEAllAttributes())
			if(e.getName().equals(name))
				return e;
		return null;
	}
	public static EReference getEEReference(EClass c, String name){
		for(EReference e : c.getEReferences())
			if(e.getName().equals(name))
				return e;
		return null;
	}
	@SuppressWarnings("unchecked")
	public static boolean isParentClass(Class<? extends Object> p, Class<? extends Object> c){
		if(c == p)
			return true;
		Type t = c.getGenericSuperclass();
		if(t instanceof Class){
			return isParentClass(p, (Class<? extends Object>) t);
		}
		return false;
	}
	public static boolean isValueForFeature(EStructuralFeature f, Object obj){
		if(f instanceof EReference){
			if(obj instanceof EObject){
				EClass p = ((EReference) f).getEReferenceType();
				EClass b = ((EObject)obj).eClass();
				return p == b || b.getEAllSuperTypes().contains(p);
			}
		}else if(f instanceof EAttribute){
			return isParentClass(((EAttribute) f).getEAttributeType().getInstanceClass(),  obj.getClass());
		}
		return false;
	}
	public static EObject findContainer(EObject object)
	{
		for (EReference i : object.eClass().getEAllReferences())
			if (i.isContainer())
				return (EObject) object.eGet(i);
		return null;
	}
	public static void setContainer(EObject object, EObject parent)
	{
		for (EReference i : object.eClass().getEAllReferences())
			if (i.isContainer() && isValueForFeature(i, parent))
				 object.eSet(i, parent);
	}
}
