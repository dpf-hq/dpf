/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package no.hib.dpf.command.impl;

import no.hib.dpf.command.CommandPackage;
import no.hib.dpf.command.CreateNodeCommand;
import no.hib.dpf.metamodel.Graph;
import no.hib.dpf.metamodel.Node;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Create Node Command</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class CreateNodeCommandImpl extends CommandImpl implements CreateNodeCommand {
	private Node node;
	private String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CreateNodeCommandImpl() {
		super();
	}
	
	protected CreateNodeCommandImpl(Graph graph, String name) {
		this.name = name;
		this.graph = graph;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CommandPackage.Literals.CREATE_NODE_COMMAND;
	}

	@Override
	public void execute() {
		super.execute();
		node = graph.createNode(name); //FIXME: use correct name
	}

	@Override
	public void undo() {
		super.undo();
		graph.deleteNode(node);
	}
	

} //CreateNodeCommandImpl
