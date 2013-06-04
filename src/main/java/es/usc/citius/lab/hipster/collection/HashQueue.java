package es.usc.citius.lab.hipster.collection;

import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class HashQueue<S> extends AbstractQueue<S> {

	private Set<S> elements = new LinkedHashSet<S>();
	private S first = null;

	public boolean offer(S e) {
		elements.add(e);
		if (first == null) {
			first = e;
		}
		return true;
	}

	public S poll() {
		// Remove the first element
		elements.remove(first);
		S out = first;
		// Reasign first
		first = (elements.isEmpty()) ? null : elements.iterator().next();
		return out;
	}

	public S peek() {
		return first;
	}

	@Override
	public Iterator<S> iterator() {
		return elements.iterator();
	}

	@Override
	public int size() {
		return elements.size();
	}

	@Override
	public boolean contains(Object o) {
		return this.elements.contains(o);
	}

}