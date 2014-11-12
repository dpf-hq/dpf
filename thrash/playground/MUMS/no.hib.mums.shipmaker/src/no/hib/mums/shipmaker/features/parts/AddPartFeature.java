package no.hib.mums.shipmaker.features.parts;

import no.hib.dpf.core.Node;
import no.hib.mums.shipmaker.DiagramTypeProvider;
import no.hib.mums.shipmaker.ShipHelper;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.impl.AbstractAddShapeFeature;
import org.eclipse.graphiti.mm.algorithms.Polyline;
import org.eclipse.graphiti.mm.algorithms.Rectangle;
import org.eclipse.graphiti.mm.algorithms.RoundedRectangle;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.algorithms.styles.Orientation;
import org.eclipse.graphiti.mm.pictograms.BoxRelativeAnchor;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeCreateService;
import org.eclipse.graphiti.util.ColorConstant;
import org.eclipse.graphiti.util.IColorConstant;

public class AddPartFeature extends AbstractAddShapeFeature {

	private ShipHelper ph = DiagramTypeProvider.getHelperInstance();
	
	int width = 120;
	int height = 300;
	int childrenHeight = 20;
	int childrenOffset = 20;

	private IColorConstant classTextForeground;
	private IColorConstant classForeground;
	private IColorConstant classBackground;

	final IPeCreateService peCreateService = Graphiti.getPeCreateService();
	final IGaService gaService = Graphiti.getGaService();

	private Diagram targetDiagram = null;
	private ContainerShape containerShape;
	private RoundedRectangle roundedRectangle;

	private Node node = null;
	
	
	public AddPartFeature(IFeatureProvider fp) {
		super(fp);
		classBackground = new ColorConstant(205, 170, 0);
		classForeground = new ColorConstant(166, 178, 0);
		classTextForeground = new ColorConstant(0, 0, 0);
	}

	@Override
	public boolean canAdd(IAddContext context) {
		if (context.getTargetContainer() instanceof Diagram) {
			if (context.getNewObject() instanceof Node
					&& ph.isPartInstance((Node) context.getNewObject())) {
				return true;
			}
		}
		System.out.println("CAN ADD FAILED");
		return false;
	}

	@Override
	public PictogramElement add(IAddContext context) {
		node = (Node) context.getNewObject();

		targetDiagram = (Diagram) context.getTargetContainer();

		containerShape = peCreateService.createContainerShape(targetDiagram,
				true);

		roundedRectangle = gaService.createRoundedRectangle(containerShape, 5,
				5);

		createRoundRectangleWithLine();

		link(containerShape, node);
		
		addContainerLabel();

		gaService.setLocationAndSize(roundedRectangle, context.getX(),
				context.getY(), width, 120);

		createAnchorForContainerShape();

		layoutPictogramElement(containerShape);

		return containerShape;	
		
	}
	
	private void createRoundRectangleWithLine() {
		roundedRectangle.setForeground(manageColor(classForeground));
		roundedRectangle.setBackground(manageColor(classBackground));
		roundedRectangle.setLineWidth(2);
		// gaService.setLocationAndSize(roundedRectangle, context.getX(),
		// context.getY(), width, height);
		// define a default size for the shape
		// int width = context.getWidth() <= 0 ? 100 : context.getWidth();
		// int height = context.getHeight() <= 0 ? 50 : context.getHeight();

		// SHAPE WITH LINE
		// create shape for line
		final Shape shape = peCreateService.createShape(containerShape, false);

		// create and set graphics algorithm
		final Polyline polyline = gaService.createPolyline(shape, new int[] {
				0, 20, width, 20 });
		polyline.setForeground(manageColor(classForeground));
		polyline.setLineWidth(2);
	}

	private void createAnchorForContainerShape() {

		peCreateService.createChopboxAnchor(containerShape);

		// create an additional box relative anchor at middle-right
		final BoxRelativeAnchor boxAnchor = peCreateService
				.createBoxRelativeAnchor(containerShape);

		boxAnchor.setRelativeWidth(1.0);
		boxAnchor.setRelativeHeight(0.5);

		// anchor references visible rectangle instead of invisible rectangle
		boxAnchor.setReferencedGraphicsAlgorithm(roundedRectangle);

		// assign a graphics algorithm for the box relative anchor
		Rectangle rectangle = gaService.createRectangle(boxAnchor);
		rectangle.setFilled(true);

		// anchor is located on the right border of the visible rectangle
		// and touches the border of the invisible rectangle

		int w = 6;
		gaService.setLocationAndSize(rectangle, -2 * w, -w, 2 * w, 2 * w);
		rectangle.setForeground(manageColor(classForeground));
		rectangle.setBackground(manageColor(classBackground));

	}

	// SHAPE WITH TEXT
	private void addContainerLabel() {
		// create shape for text
		final Shape shape = peCreateService.createShape(containerShape, false);

		// create and set text graphics algorithm
		final Text text = gaService.createDefaultText(getDiagram(), shape,
				node.getName());
		text.setForeground(manageColor(classTextForeground));
		text.setHorizontalAlignment(Orientation.ALIGNMENT_CENTER);
		text.setVerticalAlignment(Orientation.ALIGNMENT_CENTER);
		gaService.setLocationAndSize(text, 0, 0, width, 20);

		// create link and wire it
		link(shape, node);
	}
}


