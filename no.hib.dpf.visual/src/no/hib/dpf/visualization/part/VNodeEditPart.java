package no.hib.dpf.visualization.part;

import java.util.ArrayList;
import java.util.List;





//import no.hib.dpf.core.DataNode;
import no.hib.dpf.core.Node;
//import no.hib.dpf.core.NodeAttribute;
//import no.hib.dpf.core.impl.NodeAttributeImpl;
import no.hib.dpf.diagram.DArrow;
import no.hib.dpf.diagram.DElement;
import no.hib.dpf.editor.DPFEditor;
import no.hib.dpf.editor.extension_points.FigureConfigureManager;
//import no.hib.dpf.editor.diagrams.classdiagram.ClassDiagramConstants;
//import no.hib.dpf.editor.extension_points.FigureConfigureManager;
import no.hib.dpf.editor.figures.EditableLabel;
import no.hib.dpf.editor.figures.NodeFigure;
import no.hib.dpf.editor.figures.TextCellEditorLocator;
import no.hib.dpf.editor.policies.NodeComponentEditPolicy;
import no.hib.dpf.editor.preferences.DPFEditorPreferences;
//import no.hib.dpf.editor.parts.TextCellEditorLocator;
//import no.hib.dpf.editor.parts.node.DNodeEditPart;
//import no.hib.dpf.editor.parts.node.NodeComponentEditPolicy;
import no.hib.dpf.editor.policies.DConnectionCreatePolicy;
//import no.hib.dpf.editor.preferences.DPFEditorPreferences;
import no.hib.dpf.editor.utilities.DPFMetaLanguageUtils;
import no.hib.dpf.editor.utilities.DPFTemplateUtils;
import no.hib.dpf.editor.utilities.TemplateNodeAttributeUtils;
import no.hib.dpf.visual.VElement;
import no.hib.dpf.visual.VNode;
import no.hib.dpf.visualization.VCompartment;
import no.hib.dpf.visualization.figures.CompositeVNodeFigure;
import no.hib.dpf.visualization.figures.VNodeFigure;
import no.hib.dpf.visualization.policies.VCompartmentNameDirectEditPolicy;
import no.hib.dpf.visualization.policies.VNodeLayoutPolicy;
import no.hib.dpf.visualization.util.VisualizationModelUtils;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.swt.graphics.Image;

public class VNodeEditPart extends no.hib.dpf.editor.parts.DNodeEditPart {

	VNode visual = null;
	EList<VCompartment> compartments = null;
	EMap<DElement, VElement> maps;
	public static final Dimension DEFAULT_DIMENSION = new Dimension(150, 100);

	public VNodeEditPart(VNode vElement, EList<VCompartment> nodeCompartments, EMap<DElement, VElement> maps) {
		visual = vElement;
		compartments = nodeCompartments;
		this.maps = maps;
	}
	
	public EMap<DElement, VElement> getMaps() {
		return maps;
	}

	@Override
	protected void createEditPolicies() {
		// allow removal of the associated model element
		installEditPolicy(EditPolicy.COMPONENT_ROLE, new NodeComponentEditPolicy());
		// allow the creation of connections and
		// and the reconnection of connections between Shape instances
		installEditPolicy(EditPolicy.GRAPHICAL_NODE_ROLE, new DConnectionCreatePolicy());
		installEditPolicy(EditPolicy.DIRECT_EDIT_ROLE, new VCompartmentNameDirectEditPolicy()); 
		
		// allow adding of childs in compartments
		if (visual.isComposite()) {
			installEditPolicy(EditPolicy.LAYOUT_ROLE, new VNodeLayoutPolicy());
		}
	}

	@Override
	public void refreshVisuals() {
		VNodeFigure figure = (VNodeFigure) getFigure();
		DPFEditor editor = getEditor();
		
		if (editor != null) {
			boolean flag = editor.isMakerExisting(getDiagramModel().getNode());
			if (figure.getErrorImageFlag() != flag) {
				figure.setErrorImageFlag(flag);
			}
		}
		Point p = getDiagramModel().getLocation();
		if(p == null){
			p = new Point(5, 5);
		}
		Dimension d = getDiagramModel().getSize();
		if(d == null){
			d = DEFAULT_DIMENSION;
		}
		
		getFigure().setBounds(new Rectangle(p, d));
		refreshLabel();
	}

	@Override
	protected IFigure createFigure() {
		IFigure figure = super.createFigure();
		IFigure nodeFigure;
		EditableLabel label = createLabel();
		
		if (visual.isComposite()) {
			nodeFigure = new CompositeVNodeFigure(label, visual.getColor(), visual.isRounded(), visual.isShadow());
		} else {	
			nodeFigure = new VNodeFigure(label, visual.getColor(), visual.isRounded(), visual.isShadow());
			nodeFigure.setBorder(figure.getBorder());
		}
		
		Dimension d = getDiagramModel().getSize();
		if(d.width() < DEFAULT_DIMENSION.width()){
			d.setWidth(DEFAULT_DIMENSION.width());
		}
		
		if(d.height() < DEFAULT_DIMENSION.height()){
			d.setHeight(DEFAULT_DIMENSION.height());
		}
		
		return nodeFigure;
	}

	private EditableLabel createLabel() {
		Node node = getDPFNode();
		Integer potency = null;
		Integer mutability = null;
//		if(node != null){
//			potency = getDPFNode().getPotency();
//			//mutability = node.getMutability();
//		}
		EditableLabel label = new EditableLabel(getNodeLabelName()); //, potency, mutability);
		ImageDescriptor smallIcon = getImageDescriptor();
		if(smallIcon != null){
			label.setIcon((Image)smallIcon.createResource(null));	
		}
		
		return label;
	}

	private ImageDescriptor getImageDescriptor() {
		IConfigurationElement configure = FigureConfigureManager.getInstance()
				.getConfigurationElement(getDiagramModel().getConfigureString());
		ImageDescriptor smallIcon = configure == null ? null : FigureConfigureManager.getSmallIcon(configure);
		return smallIcon;
	}
	
	//@Override
	protected String getNodeLabelName() {
		String result = "";
		Node node = getDPFNode();
		
	 	String nodeName = node.getName();
		result += nodeName;
		
		Node type = node.getTypeNode();
		if (DPFEditorPreferences.getDefault().getDisplayTypeNames() && type != null && type.getName() != null) {
	 		String typeNodeName = type.getName();
			result += " : " + typeNodeName;
		}
		
		return result;
	}

	@Override
	public IFigure getContentPane() {
		if (visual != null && visual.isComposite())
			return ((CompositeVNodeFigure) getFigure()).getContentPane();
		return super.getContentPane();
	}

	public EList<VCompartment> getCompartments() {
		return compartments;
	}

	@Override
	protected List<VCompartment> getModelChildren() {
		return compartments;
	}

	// Hide connections to contained nodes
	@Override
	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected List<?> getModelSourceConnections() {
		EList sources = new BasicEList();
		Assert.isNotNull(getDiagramModel());
		sources.addAll(getDiagramModel().getDOutgoings());
	 	sources.addAll(getDiagramModel().getConstraintsFrom());
		
	 	ArrayList<String> templateArrows = DPFTemplateUtils.getTemplateArrows(getDiagramModel());
		EList<DArrow> arrows = getDiagramModel().getDOutgoings();
		for (DArrow darrow : arrows) {
			
			boolean remove = false;
			VElement aElement = VisualizationModelUtils.getVElement(darrow.getDType(), maps);
			if(VisualizationModelUtils.isComposedVArrow(aElement)) { // hide contained connections
				remove = true;
			}else if(templateArrows.contains(darrow.getName())){ // hide template connections
				remove = true;
			}
			
			if(remove){
				sources.remove(darrow);
				
			}
		}

		return sources;
	}
	
	@Override
	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected List<?> getModelTargetConnections() {
		EList targets = new BasicEList();
		Assert.isNotNull(getDiagramModel());
		targets.addAll(getDiagramModel().getDIncomings());
	 	targets.addAll(getDiagramModel().getConstraintsFrom());
	 	
	 	ArrayList<String> templateArrows = DPFTemplateUtils.getTemplateArrows(getDiagramModel());
		
		EList<DArrow> arrows = getDiagramModel().getDIncomings();
		for (DArrow darrow : arrows) {
			
			boolean remove = false;
			VElement aElement = VisualizationModelUtils.getVElement(darrow.getDType(), maps);
			if(VisualizationModelUtils.isComposedVArrow(aElement)) { // hide contained connections
				remove = true;
			}else if(templateArrows.contains(darrow.getName())){ // hide template connections
				remove = true;
			}
			
			if(remove){
				targets.remove(darrow);
				
			}
		}

		return targets;
	}

//	@Override
	protected void refreshLabel() {
		VNodeFigure tableFigure = (VNodeFigure) getFigure();
		EditableLabel label = tableFigure.getNameLabel();
		label.setText(getNodeLabelName());
		label.setVisible(true);
		label.revalidate();
	}
	
	@Override
	public void performRequest(Request req) {
		if (req.getType().equals(RequestConstants.REQ_DIRECT_EDIT)) {
			EditableLabel label = ((VNodeFigure) getFigure()).getNameLabel();
			VTextDirectEditManager manager = new VTextDirectEditManager(this, TextCellEditor.class, new TextCellEditorLocator(label));
			manager.show();
			return;
		}
	}
}
