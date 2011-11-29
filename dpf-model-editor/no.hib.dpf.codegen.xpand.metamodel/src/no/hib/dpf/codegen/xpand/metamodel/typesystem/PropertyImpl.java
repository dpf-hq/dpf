package no.hib.dpf.codegen.xpand.metamodel.typesystem;

import org.eclipse.xtend.typesystem.Property;
import org.eclipse.xtend.typesystem.Type;

public abstract class PropertyImpl extends FeatureImpl implements Property {

	    private Type owner;

	    public PropertyImpl(final Type owner, final String name, final Type returnType) {
	        super(name, returnType);
	        this.owner = owner;
	    }

	    public Type getOwner() {
	        return owner;
	    }

	    @Override
	    public boolean equals(final Object obj) {
	        if (obj == null)
	            return false;
	        if (this == obj)
	            return true;
	        if (obj instanceof Property) {
	            final Property op = (Property) obj;
	            return getReturnType().equals(op.getReturnType()) && getName().equals(op.getName());
	        }
	        return false;
	    }

	    private int hashCode = 0;

	    @Override
	    public int hashCode() {
	        if (hashCode == 0) {
	            hashCode = 17;
	            hashCode = 37 * hashCode + getName().hashCode();
	            hashCode = 37 * hashCode + getReturnType().hashCode();
	        }
	        return hashCode;
	    }

	    @Override
	    public String toString() {
	        final StringBuffer buff = new StringBuffer();
	        buff.append(getReturnType().toString());
	        buff.append(" ").append(getOwner().toString());
	        buff.append(".").append(getName());
	        return buff.toString();
	    }

	    public String getDocumentation() {
	        return "";
	    }

	    public void set(final Object target, final Object newValue) {
	        throw new UnsupportedOperationException("setting of property " + getName() + " not upported!");
	    }

}
