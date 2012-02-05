package no.hib.dpf.codegen.xpand.metamodel.typesystem;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public abstract class Cache<K, V> {

	protected abstract V createNew(K arg0);

	protected Map<K, V> internal = new HashMap<K, V>();

	public V get(final K key) {
		if (internal.containsKey(key))
			return internal.get(key);
		final V r = createNew(key);
		internal.put(key, r);
		return r;
	}

	public boolean exists(final K key) {
		return internal.containsKey(key);
	}
	
	public Collection<V> getValues() {
		return internal.values();
	}

	public void put(K key, V value) {
		internal.put(key, value);
	}
	
	public Collection<K> getKeys() {
		return internal.keySet();
	}
	/**
	 * Clears the cache.
	 * 
	 * @since 4.2
	 */
	public void clear() {
		internal.clear();
	}

	/**
	 * @return
	 * @see java.util.Map#isEmpty()
	 */
	public boolean isEmpty() {
		return internal.isEmpty();
	}
	
	

}