package no.hib.dpf.codegen.xpand.metamodel.typesystem;

import org.eclipse.xtend.typesystem.Callable;
import org.eclipse.xtend.typesystem.Type;

public abstract class FeatureImpl implements Callable {

    private String name;

    private Type returnType;

    public FeatureImpl(final String name, final Type returnType) {
        this.name = name;
        this.returnType = returnType;
    }

    public String getName() {
        return name;
    }

    public Type getReturnType() {
        return returnType;
    }

    @Override
    public String toString() {
        return returnType.toString() + " " + name;
    }

    @Override
    public abstract boolean equals(Object obj);

    @Override
    public abstract int hashCode();
}
