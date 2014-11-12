package no.hib.dpf.editor.parts.attribute;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import no.hib.dpf.core.Arrow;
import no.hib.dpf.core.Constraint;
import no.hib.dpf.core.CorePackage;
import no.hib.dpf.core.DataNode;
import no.hib.dpf.core.Graph;
import no.hib.dpf.core.Node;
import no.hib.dpf.diagram.DDataNode;
import no.hib.dpf.diagram.DNode;
import no.hib.dpf.diagram.DiagramPackage;
import no.hib.dpf.editor.DPFEditor;
import no.hib.dpf.editor.extension_points.FigureConfigureManager;
import no.hib.dpf.editor.extension_points.INodePainting;
import no.hib.dpf.editor.figures.DataNodeFigure;
import no.hib.dpf.editor.figures.EditableLabel;
import no.hib.dpf.editor.figures.MultipleArrowsChopboxAnchor;
import no.hib.dpf.editor.figures.NodeFigure;
import no.hib.dpf.editor.parts.GraphicalEditPartWithListener;
import no.hib.dpf.editor.parts.TextCellEditorLocator;
import no.hib.dpf.editor.parts.TextDirectEditManager;
import no.hib.dpf.editor.parts.constraint.DConstraintEditPart;
import no.hib.dpf.editor.parts.node.DComposedNodePart;
import no.hib.dpf.editor.parts.node.NodeComponentEditPolicy;
import no.hib.dpf.editor.policies.DConnectionCreatePolicy;
import no.hib.dpf.editor.policies.NameDirectEditPolicy;
import no.hib.dpf.editor.preferences.DPFEditorPreferences;
import no.hib.dpf.utils.DPFCoreUtil;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.draw2d.ChopboxAnchor;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.NodeEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.jface.viewers.TextCellEditor;

public class DDataNodeEditPart extends GraphicalEditPartWithListener implements NodeEditPart{

	private Map<NodeEditPart, List<ConnectionAnchor>> anchors = new HashMap<NodeEditPart, List<ConnectionAnchor>>();

	private INodePainting nodePaint;
	public DDataNodeEditPart() {
		super();
	}

	private boolean anchorListContainsConnection(List<ConnectionAnchor> previousAnchorList, ConnectionEditPart connection) {
		return (getConnectionsAnchor(previousAnchorList, connection) != null);
	}

	private ConnectionAnchor createAnchorUseConfigure(){
		if(getNodePaint() != null)
			return nodePaint.createConnectionAnchor(getFigure());
		return null;
	}

	public ConnectionAnchor createConnectionAnchor(ConnectionEditPart connection, boolean b, DDataNodeEditPart owner){
		ConnectionAnchor anchor = owner.createAnchorUseConfigure();
		if(anchor != null)
			return anchor;
		return getConnectionAnchor(connection, b);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.editparts.AbstractEditPart#createEditPolicies()
	 */
	@Override
	protected void createEditPolicies() {
		// allow removal of the associated model element
		installEditPolicy(EditPolicy.COMPONENT_ROLE, new NodeComponentEditPolicy());
		// allow the creation of connections and
		// and the reconnection of connections between Shape instances
		installEditPolicy(EditPolicy.GRAPHICAL_NODE_ROLE, new DConnectionCreatePolicy());
		installEditPolicy(EditPolicy.DIRECT_EDIT_ROLE, new NameDirectEditPolicy());
	}

	@Override
	protected IFigure createFigure() {
		if(getNodePaint() != null){
			NodeFigure figure = nodePaint.createNodeFigure();;
			return figure;
		}
		
		return new DataNodeFigure(new EditableLabel(getNodeLabelName()));
	}

	private DDataNodeEditPart getAnchorOwner(ConnectionEditPart connection, boolean source){
		if(connection == null || source || connection.getTarget() == null)
			return this;
		return (DDataNodeEditPart) connection.getTarget();
	}

	private ConnectionAnchor getConnectionAnchor(ConnectionEditPart connection, boolean isSourceAnchor) {
		NodeEditPart oppositeEnd = getOppositeEnd(connection, isSourceAnchor);
		List<ConnectionAnchor> previousAnchorList;
		ConnectionAnchor previousAnchor;

		// Get any previous anchors:
		if (anchors.containsKey(oppositeEnd)) {
			if (oppositeEnd == null) {
				return anchors.get(null).get(0);
			}
			previousAnchorList = anchors.get(oppositeEnd);
			previousAnchor = previousAnchorList.get(previousAnchorList.size() - 1);
		} else {
			previousAnchorList = new ArrayList<ConnectionAnchor>();
			anchors.put(oppositeEnd, previousAnchorList);
			previousAnchor = null;
		}

		// Get an anchor for the connection:
		if ((connection == null) || (connection.getSource() == null) || (connection.getSource().equals(connection.getTarget()))) {
			previousAnchorList.add(new ChopboxAnchor(getFigure()));
			return previousAnchorList.get(previousAnchorList.size() - 1);

		} else {
			// Check if this connection already has got an anchor:
			if (!anchorListContainsConnection(previousAnchorList, connection)) {
				previousAnchorList.add(new MultipleArrowsChopboxAnchor(getFigure(), connection, previousAnchor));
				return previousAnchorList.get(previousAnchorList.size() - 1);
			} else {
				// Return that anchor:
				return getConnectionsAnchor(previousAnchorList, connection);
			}
		}
	}

	private ConnectionAnchor getConnectionsAnchor(List<ConnectionAnchor> previousAnchorList, ConnectionEditPart connection) {
		for (ConnectionAnchor connectionAnchor : previousAnchorList) {
			if (connectionAnchor instanceof MultipleArrowsChopboxAnchor) {
				MultipleArrowsChopboxAnchor multipleArrowsChopboxAnchor = (MultipleArrowsChopboxAnchor)connectionAnchor;
				if (multipleArrowsChopboxAnchor.getConnectionEditPart().equals(connection)) {
					return multipleArrowsChopboxAnchor;
				}
			}
		}
		return null;		
	}
	
	@Override
	protected DDataNode getDiagramModel(){ return (DDataNode) getModel(); }

	public DDataNode getDDataNode(){
		return (DDataNode) getModel();
	}

	public DataNode getDPFDataNode(){
		DDataNode ddatanode = getDDataNode();
		if(ddatanode != null)
			return ddatanode.getDatanode();
		return null;
	}

	@Override
	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected List<?> getModelSourceConnections() {
		EList sources = new BasicEList();
		sources.addAll(getDDataNode().getConstraintsFrom());
		return sources;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	protected List<?> getModelTargetConnections() {
		EList targets = new BasicEList();
		targets.addAll(getDDataNode().getDIncomingDArrowDAttributes());
		targets.addAll(getDDataNode().getDIncomingDNodeDAttributes());
		targets.addAll(getDDataNode().getConstraintsTo());
		return targets;

	}

	protected String getNodeLabelName() {
		String result = "";
		DataNode datanode = getDPFDataNode();
		if(datanode != null && datanode.getValue() != null){
			result += datanode.getValue();
		}
		
		return result;
	}

	private INodePainting getNodePaint() {
		if(nodePaint == null)
			try {
				String name = null;
				if(getDDataNode() instanceof DDataNode)
					name = getDDataNode().getDType().getConfigureString();
				if(name == null || name.isEmpty())
					return null;
				IConfigurationElement configure = FigureConfigureManager.getInstance().getConfigurationElement(name);
				if(configure != null){
					nodePaint = (INodePainting) configure.createExecutableExtension(FigureConfigureManager.PAINT_ATT);
				}
			} catch (CoreException e) {
				e.printStackTrace();
			}
		return nodePaint;
	}

	private NodeEditPart getOppositeEnd(ConnectionEditPart connection, boolean isSourceAnchor) {
		if (connection == null) 
			return null;
		if (isSourceAnchor) 
			return (NodeEditPart) connection.getTarget();
		return (NodeEditPart) connection.getSource();
	}

	@Override
	public ConnectionAnchor getSourceConnectionAnchor(ConnectionEditPart connection) {
		return createConnectionAnchor(connection, true, getAnchorOwner(connection, true));
	}

	@Override
	public ConnectionAnchor getSourceConnectionAnchor(Request request) {
		return createConnectionAnchor(null, true, getAnchorOwner(null, true));
	}
	@Override
	public ConnectionAnchor getTargetConnectionAnchor(ConnectionEditPart connection) {
		return createConnectionAnchor(connection, false, getAnchorOwner(connection, false));
	}

	@Override
	public ConnectionAnchor getTargetConnectionAnchor(Request request) {
		return createConnectionAnchor(null, false, getAnchorOwner(null, false));
	}

	/*
	 * After the diagram elements is created or updated, then refresh the visualization
	 * @see no.hib.dpf.editor.parts.GraphicalEditPartWithListener#handleDiagramModelChanged(org.eclipse.emf.common.notify.Notification)
	 */
	@Override
	protected void handleDiagramModelChanged(Notification msg) {
		super.handleDiagramModelChanged(msg);
		if(msg.getNotifier() != null && msg.getNotifier() == getDiagramModel()){ 
			switch(msg.getFeatureID(DNode.class)){
			case DiagramPackage.DDATA_NODE__CONSTRAINTS_FROM:
				refreshSourceConnections();
				break;
			case DiagramPackage.DDATA_NODE__DINCOMING_DNODE_DATTRIBUTES:
				refresh();
			case DiagramPackage.DDATA_NODE__DINCOMING_DARROW_DATTRIBUTES:
				refresh();
			case DiagramPackage.DDATA_NODE__CONSTRAINTS_TO:
				refreshTargetConnections();
				break;
			case DiagramPackage.DDATA_NODE__LOCATION:
			case DiagramPackage.DDATA_NODE__SIZE:
				refresh();
				for(Object connect : getTargetConnections()){
					if(connect instanceof DConstraintEditPart && ((DConstraintEditPart)connect).getSource() instanceof DComposedNodePart){
						DComposedNodePart editPart = (DComposedNodePart) ((DConstraintEditPart)connect).getSource();
						editPart.resize(getDDataNode().getLocation());
						
					}
				}
			}

		}
	}

	/*
	 * Verification of the model after arrows added or deleted.
	 * @see no.hib.dpf.editor.parts.GraphicalEditPartWithListener#handleModelChanged(org.eclipse.emf.common.notify.Notification)
	 */
	@Override
	protected void handleModelChanged(Notification msg) {
		if(msg.getNotifier() != null && msg.getNotifier() == getDPFDataNode()){ 
			switch(msg.getFeatureID(DataNode.class)){
			case CorePackage.DATA_NODE__VALUE:
				refreshVisuals();
				break;
			case CorePackage.DATA_NODE__INCOMING_NODE_ATTRIBUTES:
				//verifyOnArrowChange((Node)msg.getNotifier(), msg.getOldValue(), msg.getNewValue());
				break;
			case CorePackage.DATA_NODE__INCOMING_ARROW_ATRIBUTES:
				//verifyOnArrowChange((Node)msg.getNotifier(), msg.getOldValue(), msg.getNewValue());
				break;
			}
		}
	}

	@Override
	protected void listen(){
		super.listen();
		addUIAdapter(getDPFDataNode(), modelListener);
	}
	
	@Override
	protected void unlisten(){
		removeUIAdapter(getDPFDataNode(), modelListener);
		super.unlisten();
	}

	@Override
	public void performRequest(Request req) {
		if (req.getType().equals(RequestConstants.REQ_DIRECT_EDIT)) {
			TextDirectEditManager manager = new TextDirectEditManager(this, TextCellEditor.class, new TextCellEditorLocator(((NodeFigure)getFigure()).getNameLabel()));
			manager.show();
			return;
		}
		super.performRequest(req);
	}
	protected void refreshLabel() {
		NodeFigure tableFigure = (NodeFigure) getFigure();
		EditableLabel label = tableFigure.getNameLabel();
		label.setText(getNodeLabelName());
		label.setVisible(true);
		label.revalidate();
	}
	@Override
	protected void refreshVisuals() {
		NodeFigure figure = (NodeFigure)getFigure();
		DPFEditor editor = getEditor();
		if(editor != null){
		//	boolean flag = editor.isMakerExisting(getDDataNode().getDatanode());
		//	if(figure.getErrorImageFlag() != flag)
		//		figure.setErrorImageFlag(flag);
		}
		
		Point loc = getDDataNode().getLocation();
		if(loc == null){
			loc = new Point(5, 5);
		}
		
		Dimension size = getDDataNode().getSize();
		if(size == null){
			size = new Dimension(50, 20);
		}
		
		getFigure().setBounds(new Rectangle(loc, size));
		refreshLabel();
		//			((GraphicalEditPart) getParent()).setLayoutConstraint(this, getFigure(), bounds);
		// notify parent container of changed position & location
		// if this line is removed, the XYLayoutManager used by the parent
		// container (the Figure of the DPFDiagramEditPart), will not know the bounds of
		// this figure and will not draw it correctly.
	}

	private void verifyOnArrowChange(Node node, Object oldArrow, Object newArrow){
		Arrow checkedArrow = null;
		DPFEditor editor = getEditor();
		if(editor == null)
			return;
		if (newArrow == null && oldArrow instanceof Arrow){
			checkedArrow = (Arrow) oldArrow;
			if(checkedArrow.getSource() == null && checkedArrow.getTarget() == null)
				editor.deleteMaker(checkedArrow);
		}
		else if (newArrow instanceof Arrow)
			checkedArrow = (Arrow) newArrow;

		EList<Constraint> constraints = new BasicEList<Constraint>();
		constraints.addAll(checkedArrow.getTypeArrow().getConstraints());

		Graph graph = node.getGraph();
		if(editor == null || graph == null) return;

		for (Constraint constraint : constraints) {
			EList<Node> nodes = new BasicEList<Node>();
			EList<Arrow> arrows = new BasicEList<Arrow>();

			DPFCoreUtil.findRelatedElements(node, constraint, graph, nodes, arrows);

			boolean valid = constraint.validate(nodes, arrows);
			if(!valid){
				for(Node iter : nodes)
					editor.addMarker(iter, constraint);
				for(Arrow iter : arrows)
					editor.addMarker(iter, constraint);
			}else{
				for(Node iter : nodes)
					editor.deleteMaker(iter, constraint);
				for(Arrow iter : arrows)
					editor.deleteMaker(iter, constraint);
			}

		}
	}
}