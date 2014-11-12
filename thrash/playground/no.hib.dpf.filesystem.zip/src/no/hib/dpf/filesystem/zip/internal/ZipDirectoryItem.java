/*******************************************************************************
 * Copyright (c) 2006 Alex Blewitt and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Alex Blewitt - initial API and implementation
 *******************************************************************************/
package no.hib.dpf.filesystem.zip.internal;

import java.util.Collection;
import java.util.Collections;
import java.util.SortedMap;
import java.util.TreeMap;

public class ZipDirectoryItem extends ZipItem {
	SortedMap<String, ZipItem> children = Collections.synchronizedSortedMap(new TreeMap<String, ZipItem>());
	
	protected ZipDirectoryItem(String name, ZipDirectoryItem parent) {
		super(name, parent);
	}

	public void addChild(ZipItem item) {
		children.put(item.getName(), item);
	}

	public void removeChild(ZipItem item) {
		children.remove(item.getName());
	}

	public Collection<ZipItem> getChildren() {
		return children.values();
	}

	public ZipItem getItem(String name) {
		return (ZipItem) children.get(name);
	}

	public String toString() {
		return super.toString() + children.toString();
	}
}
