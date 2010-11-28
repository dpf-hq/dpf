package no.hib.dpf.editor.figures;



public interface RoutableFigure {

	/**
	 * Returns the priority under which an instance should be routed.
	 * Some elements are dependant upon other types of elements, and
	 * this gives the elements an opportunity to signal their preference
	 * for routing.
	 */
	int getRoutingPriority();
	
	
}
