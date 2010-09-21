/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package no.hib.dpf.command.impl;

import no.hib.dpf.command.CommandPackage;
import no.hib.dpf.command.CreateEdgeCommand;
import no.hib.dpf.metamodel.Edge;
import no.hib.dpf.metamodel.Graph;
import no.hib.dpf.metamodel.Node;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Create Edge Command</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class CreateEdgeCommandImpl extends CommandImpl implements CreateEdgeCommand {

	private Node source;
	private Node target;
	private String name;
	private Edge edge;



	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CreateEdgeCommandImpl() {
		super();
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected CreateEdgeCommandImpl(Graph graph, String name, Node source, Node target) {
		super();
		this.graph = graph;
		this.name = name;
		this.source = source;
		this.target = target;
	}
	
	

	@Override
	public void execute() {
		super.execute();
		edge = graph.createEdge(name, source, target);
		
	}



	@Override
	public void undo() {
		// TODO Auto-generated method stub
		super.undo();
		graph.deleteEdge(edge);
	}



	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CommandPackage.Literals.CREATE_EDGE_COMMAND;
	}

} //CreateEdgeCommandImpl
