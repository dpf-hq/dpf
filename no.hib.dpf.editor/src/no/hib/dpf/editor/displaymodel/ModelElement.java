/*******************************************************************************
 * Copyright (c) 2004, 2005 Elias Volanakis and others.
 * 
 * Portions of the code Copyright (c) 2011 H�yskolen i Bergen
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Elias Volanakis - initial API and implementation
 * 
 * �yvind Bech and Dag Viggo Lok�en - DPF Editor
*******************************************************************************/
package no.hib.dpf.editor.displaymodel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

import no.hib.dpf.core.IDObject;
import no.hib.dpf.editor.extension_points.FigureConfigureManager;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.ui.views.properties.IPropertyDescriptor;
import org.eclipse.ui.views.properties.IPropertySource;

/**
 * Abstract prototype of a model element.
 * <p>
 * This class provides features necessary for all model elements, like:
 * </p>
 * <ul>
 * <li>property-change support (used to notify edit parts of model changes),</li>
 * <li>property-source support (used to display property values in the Property
 * View) and</li>
 * <li>serialization support (the model hierarchy must be serializable, so that
 * the editor can save and restore a binary representation. You might not need
 * this, if you store the model a non-binary form like XML).</li>
 * </ul>
 * 
 * @author Elias Volanakis
 */
public abstract class ModelElement implements IPropertySource, Serializable {
	/** An empty property descriptor. */
	private static final IPropertyDescriptor[] EMPTY_ARRAY = new IPropertyDescriptor[0];

	private static final long serialVersionUID = 1;
	/** Delegate used to implemenent property-change-support. */
	private transient PropertyChangeSupport pcsDelegate = new PropertyChangeSupport(this);

	public IConfigurationElement getConfigure() {
		return configure;
	}

	public void setConfigure(IConfigurationElement figure) {
		this.configure = figure;
	}


	//for the editpart use
	protected transient IConfigurationElement configure = null;
	protected String configurationName = null;

	public static final String PROP_CONFIGURE = "CONFIGURE";

	protected String[] getConfigureLabels(){ return null;}
	/**
	 * Attach a non-null PropertyChangeListener to this object.
	 * 
	 * @param l
	 *            a non-null PropertyChangeListener instance
	 * @throws IllegalArgumentException
	 *             if the parameter is null
	 */
	public synchronized void addPropertyChangeListener(PropertyChangeListener l) {
		if (l == null) {
			throw new IllegalArgumentException();
		}
		pcsDelegate.addPropertyChangeListener(l);
	}

	/**
	 * Report a property change to registered listeners (for example edit
	 * parts).
	 * 
	 * @param property
	 *            the programmatic name of the property that changed
	 * @param oldValue
	 *            the old value of this property
	 * @param newValue
	 *            the new value of this property
	 */
	protected void firePropertyChange(String property, Object oldValue, Object newValue) {
		if (pcsDelegate.hasListeners(property)) {
			pcsDelegate.firePropertyChange(property, oldValue, newValue);
		}
	}

	/**
	 * Returns a value for this property source that can be edited in a property
	 * sheet.
	 * <p>
	 * My personal rule of thumb:
	 * </p>
	 * <ul>
	 * <li>model elements should return themselves and</li>
	 * <li>custom IPropertySource implementations (like DimensionPropertySource
	 * in the GEF-logic example) should return an editable value.</li>
	 * </ul>
	 * <p>
	 * Override only if necessary.
	 * </p>
	 * 
	 * @return this instance
	 */
	public Object getEditableValue() {
		return this;
	}

	/**
	 * Children should override this. The default implementation returns an
	 * empty array.
	 */
	public IPropertyDescriptor[] getPropertyDescriptors() {
		return EMPTY_ARRAY;
	}

	/**
	 * Children should override this. The default implementation returns null.
	 */
	public Object getPropertyValue(Object id) {
		if(id.equals(PROP_CONFIGURE)){
			String name = FigureConfigureManager.getName(configure);
			String[] configurStrings = getConfigureLabels();
			for(int index = 0; index < configurStrings.length; ++index){
				if(configurStrings[index].equals(name))
					return new Integer(index);
			}
		}
		return null;
	}

	/**
	 * Children should override this. The default implementation returns false.
	 */
	public boolean isPropertySet(Object id) {
		return false;
	}

	/**
	 * Deserialization constructor. Initializes transient fields.
	 * 
	 * @see java.io.Serializable
	 */
	private void readObject(ObjectInputStream in) throws IOException,
	ClassNotFoundException {
		in.defaultReadObject();
		if (pcsDelegate == null) { 
			pcsDelegate = new PropertyChangeSupport(this);
		}
	}
	
	/**
	 * Remove a PropertyChangeListener from this component.
	 * 
	 * @param l
	 *            a PropertyChangeListener instance
	 */
	public synchronized void removePropertyChangeListener(
			PropertyChangeListener l) {
		if (l != null) {
			pcsDelegate.removePropertyChangeListener(l);
		}
	}

	/**
	 * Children should override this. The default implementation does nothing.
	 */
	public void resetPropertyValue(Object id) {
		// do nothing
	}

	/**
	 * Children should override this. The default implementation does nothing.
	 */
	public void setPropertyValue(Object id, Object value) {
		if(id.equals(PROP_CONFIGURE)){
			Integer index = (Integer) value;
			IConfigurationElement newConfigure = index.intValue() == 0 ? null : FigureConfigureManager.getConfigurationElement(getConfigureLabels()[index]);
			if(configure != newConfigure){
				IConfigurationElement old = configure;
				configure = newConfigure;
				configurationName = getConfigureLabels()[index];
				firePropertyChange(PROP_CONFIGURE, old, newConfigure);
			}
		}
	}

	public void loadConfigure(){
		configure = FigureConfigureManager.getConfigurationElement(configurationName);
	}
	/**
	 * May or may not create a new DPF Graph element. Only valid for those elements
	 * that implement an IDObject descendant. TODO: refactor.
	 */
	protected void createDpfGraphElement() {}

	public void removeFromDpfGraph() {}
	
	/**
	 * Sets a model element's reference to a dpf model element.
	 */
	public void setIDObject(IDObject idObject) {}

}
