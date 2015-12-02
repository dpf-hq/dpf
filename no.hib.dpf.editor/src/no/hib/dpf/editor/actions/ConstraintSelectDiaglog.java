package no.hib.dpf.editor.actions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.ConnectionLayer;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.FreeformLayer;
import org.eclipse.draw2d.FreeformLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.LayerConstants;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.gef.editparts.ScalableFreeformRootEditPart;
import org.eclipse.gef.ui.parts.ScrollingGraphicalViewer;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;

import no.hib.dpf.core.Arrow;
import no.hib.dpf.core.GraphHomomorphism;
import no.hib.dpf.core.Node;
import no.hib.dpf.diagram.DArrow;
import no.hib.dpf.diagram.DConstraint;
import no.hib.dpf.diagram.DNode;
import no.hib.dpf.diagram.DOffset;
import no.hib.dpf.diagram.DiagramFactory;
import no.hib.dpf.editor.figures.DPFShortestPathConnectionRouter;
import no.hib.dpf.editor.figures.Draw2dUtil;
import no.hib.dpf.editor.figures.NodeFigure;
import no.hib.dpf.editor.parts.ArrowLabelEditPart;
import no.hib.dpf.editor.parts.DArrowEditPart;
import no.hib.dpf.editor.parts.DNodeEditPart;
import no.hib.dpf.editor.parts.DPFEditPartFactory;

public class ConstraintSelectDiaglog extends Dialog {
	int index = 0;
	List<GraphHomomorphism> maps = null;
	private Button previous, select, next;
	private List<DNode> dNodes, arityDNodes;
	private List<DArrow> dArrows, arityDArrows;
	private ScrollingGraphicalViewer viewerArity, viewer;
	org.eclipse.draw2d.geometry.Point LEFT_TOP = null;
	private static Color[] COLORS = new Color[] { new Color(null, 255, 0, 0), new Color(null, 0, 255, 0),
			new Color(null, 0, 0, 255), new Color(null, 255, 255, 0), new Color(null, 0, 255, 255),
			new Color(null, 255, 0, 255), new Color(null, 192, 192, 192), new Color(null, 128, 128, 128),
			new Color(null, 128, 0, 0), new Color(null, 128, 128, 0), new Color(null, 0, 128, 0),
			new Color(null, 128, 0, 128), new Color(null, 0, 128, 128), new Color(null, 0, 0, 128) };
	private Map<Object, Color> colorMaps = new HashMap<Object, Color>();
	Point dim = null;
	private SelectionAdapter previousListner;
	private SelectionAdapter nextListenr;
	private SelectionAdapter selectListener;

	public ConstraintSelectDiaglog(Shell parentShell, List<GraphHomomorphism> maps2, EList<DNode> selectionNodes,
			EList<DArrow> selectionArrows) {
		super(parentShell);
		setReturnCode(0);
		maps = maps2;
		dNodes = selectionNodes;
		dArrows = selectionArrows;
		findLeftTop();
		
	}

	private void InitArityDiagram(int index) {
		int color = 0;
		EMap<Node, Node> nodeMap = maps.get(index).getNodeMapping();
		Set<Node> keys = nodeMap.keySet();
		arityDNodes = new ArrayList<DNode>();
		Map<Node, DNode> createMap = new HashMap<Node, DNode>();
		for (Node node : keys) {
			DNode dnode = DiagramFactory.eINSTANCE.createDefaultDNode();
			Node value = nodeMap.get(node);
			DNode dValue = null;
			for (DNode iter : dNodes) {
				if (iter.getNode() == value) {
					dValue = iter;
					break;
				}
			}
			dnode.setLocation(dValue.getLocation());
			dnode.setSize(dValue.getSize());
			dnode.setNode(node);
			arityDNodes.add(dnode);
			createMap.put(node, dnode);
			colorMaps.put(dValue, COLORS[color]);
			colorMaps.put(dnode, COLORS[color++]);
		}

		EMap<Arrow, Arrow> arrowMap = maps.get(index).getArrowMapping();
		Set<Arrow> arrowKeys = arrowMap.keySet();

		arityDArrows = new ArrayList<DArrow>();
		for (Arrow arrow : arrowKeys) {
			DArrow dArrow = DiagramFactory.eINSTANCE.createDefaultDArrow();
			Arrow value = arrowMap.get(arrow);
			DArrow dValue = null;
			for (DArrow iter : dArrows) {
				if (iter.getArrow() == value) {
					dValue = iter;
					break;
				}
			}
			if (!dValue.getBendpoints().isEmpty()) {
				dArrow.getBendpoints().addAll(dValue.getBendpoints());
			}
			dArrow.setArrow(arrow);
			if (dValue.getNameOffset() != null)
				dArrow.setNameOffset(DiagramFactory.eINSTANCE.createDOffset(dValue.getNameOffset()));
			dArrow.setDSource(createMap.get(arrow.getSource()));
			dArrow.setDTarget(createMap.get(arrow.getTarget()));
			arityDArrows.add(dArrow);
			colorMaps.put(dValue, COLORS[color]);
			colorMaps.put(dArrow, COLORS[color++]);
		}
	}

	private void findLeftTop() {
		DNode leftTop = dNodes.get(0);
		Rectangle bound = new Rectangle(leftTop.getLocation(), leftTop.getSize());
		for (int index = 1; index < dNodes.size(); ++index) {
			leftTop = dNodes.get(index);
			bound.union(new Rectangle(leftTop.getLocation(), leftTop.getSize()));
		}
		for (DArrow iter : dArrows) {
			DOffset offset = iter.getNameOffset();
			org.eclipse.draw2d.geometry.Point source = Draw2dUtil.getCenter(iter.getDSource()),
					target = Draw2dUtil.getCenter(iter.getDTarget()), realsource = source, realtarget = target;
			if(iter.getBendpoints().size() > 2){
				int index = offset.getIndex();
				if (index > 0) {
					realsource = Draw2dUtil.getAbsoluteBendPoint(source, target, iter.getBendpoints().get(index - 1));
				}
				if (index < iter.getBendpoints().size()) {
					realtarget = Draw2dUtil.getAbsoluteBendPoint(source, target, iter.getBendpoints().get(index));
				}
			}
			bound.union(Draw2dUtil.getAbsoluteBendPoint(realsource, realtarget, offset));
		}
		LEFT_TOP = bound.getLocation().getNegated();
		Dimension size = bound.getSize();
		dim = new Point(size.width * 2 + 100, size.height + 150);
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		Composite container = (Composite) super.createDialogArea(parent);
		// container.setBackground(new Color(null, 255, 255, 255));
		Composite canvasContainer = new Composite(container, SWT.BORDER);
		// canvasContainer.setBackground(new Color(null, 255, 0, 0));
		canvasContainer.setLayoutData(new GridData(GridData.FILL_BOTH));
		GridLayout layout = new GridLayout();
		layout.makeColumnsEqualWidth = true;
		layout.numColumns = 2;
		layout.marginHeight = 10;
		layout.marginWidth = 10;
		layout.horizontalSpacing = 10;
		canvasContainer.setLayout(layout);

		viewerArity = new ScrollingGraphicalViewer();
		viewerArity.createControl(canvasContainer);
		viewerArity.getControl().setBackground(ColorConstants.white);
		GridData data = new GridData(SWT.FILL, SWT.FILL, true, true);
		viewerArity.getControl().setLayoutData(data);

		viewerArity.setEditPartFactory(new ArityPartFactory());
		viewerArity.setRootEditPart(new ScalableFreeformRootEditPart());
		

		viewer = new ScrollingGraphicalViewer();
		viewer.createControl(canvasContainer);
		viewer.getControl().setBackground(ColorConstants.white);
		data = new GridData(SWT.FILL, SWT.FILL, true, true);
		viewer.getControl().setLayoutData(data);
		
		viewer.setEditPartFactory(new ConstraintSelectionFactory());
		viewer.setRootEditPart(new ScalableFreeformRootEditPart());
		

		Composite buttonsContainer = new Composite(container, SWT.NONE);
		buttonsContainer.setBackground(new Color(null, 255, 255, 0));
		buttonsContainer.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		layout = new GridLayout();
		layout.makeColumnsEqualWidth = true;
		layout.numColumns = 3;
		layout.marginHeight = 10;
		layout.marginWidth = 10;
		layout.horizontalSpacing = 10;
		buttonsContainer.setLayout(layout);

		previous = new Button(buttonsContainer, SWT.PUSH);
		previous.setText("<<");
		data = new GridData(SWT.CENTER, SWT.CENTER, true, false);
		previous.setLayoutData(data);

		select = new Button(buttonsContainer, SWT.PUSH);
		select.setText("Select");
		data = new GridData(SWT.CENTER, SWT.CENTER, true, false);
		select.setLayoutData(data);

		next = new Button(buttonsContainer, SWT.PUSH);
		next.setText(">>");
		data = new GridData(SWT.CENTER, SWT.CENTER, true, false);
		next.setLayoutData(data);

		refreshVisual();
		listen();

		return container;
	}

	private void listen() {
		previousListner = new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				index--;
				refreshVisual();
			}
		};
		previous.addSelectionListener(previousListner);
		
		nextListenr = new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				index++;
				refreshVisual();
			}
		};
		next.addSelectionListener(nextListenr);
		
		selectListener = new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				setReturnCode(index);
				close();
			}
		};
		select.addSelectionListener(selectListener);
	}
	
	public boolean close() {
		previous.removeSelectionListener(previousListner);
		next.removeSelectionListener(nextListenr);
		select.removeSelectionListener(selectListener);
		return super.close();
	}

	class ConstraintSelectionFactory extends DPFEditPartFactory {
		protected EditPart getPartForElement(Object modelElement) {
			if (modelElement instanceof List<?>) {
				return new AbstractGraphicalEditPart() {

					@Override
					protected IFigure createFigure() {
						Figure f = new FreeformLayer();
						f.setBorder(new MarginBorder(3));
						f.setLayoutManager(new FreeformLayout());
						// Create the static router for the connection layer
						ConnectionLayer connLayer = (ConnectionLayer) getLayer(LayerConstants.CONNECTION_LAYER);
						connLayer.setConnectionRouter(new DPFShortestPathConnectionRouter(f));

						return f;
					}

					@Override
					protected void createEditPolicies() {
					}

					@SuppressWarnings("unchecked")
					@Override
					protected List<DNode> getModelChildren() {
						return (List<DNode>) getModel();
					}

				};
			}
			if (modelElement instanceof DNode) {
				return new DNodeEditPart() {
					protected void createEditPolicies() {
					}

					@Override
					@SuppressWarnings({ "unchecked", "rawtypes" })
					protected List<?> getModelSourceConnections() {
						EList sources = new BasicEList();
						for (DArrow arrow : getDNode().getDOutgoings())
							if (dArrows.contains(arrow))
								sources.add(arrow);
						return sources;
					}

					@SuppressWarnings({ "unchecked", "rawtypes" })
					@Override
					protected List<?> getModelTargetConnections() {
						EList targets = new BasicEList();
						for (DArrow arrow : getDNode().getDIncomings())
							if (dArrows.contains(arrow))
								targets.add(arrow);
						return targets;
					}

					public void refreshVisuals() {
						NodeFigure figure = (NodeFigure) getFigure();
						DNode dNode = getDiagramModel();
						figure.setBounds(new Rectangle(dNode.getLocation().getTranslated(LEFT_TOP), dNode.getSize()));
						figure.setBackgroundColor(colorMaps.get(dNode));
						figure.repaint();
						figure.invalidate();
						refreshLabel();
					}
				};

			}
			if (modelElement instanceof DArrow) {
				return new DArrowEditPart() {
					@Override
					protected List<?> getModelSourceConnections() {
						return Collections.EMPTY_LIST;
					}

					@Override
					protected List<DConstraint> getModelTargetConnections() {
						return Collections.emptyList();
					}

					protected List<EObject> getModelChildren() {
						List<EObject> result = new ArrayList<EObject>();
						result.add(getDArrow().getNameOffset());
						return result;
					}

					public void refreshVisuals() {
						DArrow darrow = getDArrow();
						getFigure().setForegroundColor(colorMaps.get(darrow));
						refreshBendpoints();
					}
				};
			}
			if (modelElement instanceof DOffset) {
				DOffset offset = (DOffset) modelElement;
				if (offset.eContainer() instanceof DArrow)
					return new ArrowLabelEditPart();
			}
			return super.getPartForElement(modelElement);
		}
	}

	class ArityPartFactory extends ConstraintSelectionFactory {
		protected EditPart getPartForElement(Object modelElement) {
			if (modelElement instanceof DNode) {
				return new DNodeEditPart() {

					protected void createEditPolicies() {
					}

					@Override
					@SuppressWarnings({ "unchecked", "rawtypes" })
					protected List<?> getModelSourceConnections() {
						EList sources = new BasicEList();
						for (DArrow arrow : getDNode().getDOutgoings())
							sources.add(arrow);
						return sources;
					}

					@SuppressWarnings({ "unchecked", "rawtypes" })
					@Override
					protected List<?> getModelTargetConnections() {
						EList targets = new BasicEList();
						for (DArrow arrow : getDNode().getDIncomings())
							targets.add(arrow);
						return targets;
					}

					public void refreshVisuals() {
						NodeFigure figure = (NodeFigure) getFigure();
						DNode dNode = getDiagramModel();
						figure.setBounds(new Rectangle(dNode.getLocation().getTranslated(LEFT_TOP), dNode.getSize()));
						figure.setBackgroundColor(colorMaps.get(dNode));
						figure.repaint();
						figure.invalidate();
						refreshLabel();
					}
				};

			}
			return super.getPartForElement(modelElement);
		}
	}

	private void refreshVisual() {
		previous.setEnabled(maps != null && index > 0);
		next.setEnabled(maps != null && index < maps.size() - 1);
		InitArityDiagram(index);
		viewerArity.setContents(arityDNodes);
		viewer.setContents(dNodes);
		
	}

	protected Control createButtonBar(Composite parent) {
		return null;
	}

	// overriding this methods allows you to set the
	// title of the custom dialog
	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setText("Selection dialog");
	}

	protected void handleShellCloseEvent() {
		setReturnCode(-1);
		close();
	}

	@Override
	protected Point getInitialSize() {
		return dim;
	}

}
