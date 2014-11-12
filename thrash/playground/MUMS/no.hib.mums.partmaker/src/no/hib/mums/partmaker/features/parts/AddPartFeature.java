package no.hib.mums.partmaker.features.parts;

import no.hib.dpf.core.Arrow;
import no.hib.dpf.core.Node;
import no.hib.mums.partmaker.DiagramTypeProvider;
import no.hib.mums.partmaker.PartHelper;

import static no.hib.mums.shared.MumsConstants.*;

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

	private PartHelper ph = DiagramTypeProvider.getHelperInstance();
	
	protected int width = 120;
	protected int height = 150;
	protected int childrenHeight = 20;
	protected int childrenOffset = 20;

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
		classBackground = new ColorConstant(255, 170, 0);
		classForeground = new ColorConstant(166, 111, 0);
		classTextForeground = new ColorConstant(0, 0, 0);
	}

	public boolean canAdd(final IAddContext context) {
		// check if user wants to add to a diagram
		if (context.getTargetContainer() instanceof Diagram) {
			if (context.getNewObject() instanceof Node
					&& ph.descendantOf((Node) context.getNewObject(), PART)) {
				return true;
			}
		}
		return false;
	}

	public PictogramElement add(final IAddContext context) {
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
				context.getY(), width, height);

		createAnchorForContainerShape();

		addChildrenToContainer();

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

	public void setColors(ColorConstant textForeground,
			ColorConstant classForeground, ColorConstant classBackground) {
		this.classTextForeground = textForeground;
		this.classForeground = classForeground;
		this.classBackground = classBackground;
	}

	private void addChildrenToContainer() {
		for (Arrow a : node.getTypeNode().getOutgoings()) {
			if (a.getTypeName().equals(ATTRIBUTE)) {
				//Snu det om slik at ein itererer over alle attributtars barnebarn
				addAttribute(a);
			}
		}
	}

	public void addAttribute(Arrow a) {
//		ContainerShape cs = peCreateService.createContainerShape(containerShape, true);
//		Rectangle r = gaService.createInvisibleRectangle(containerShape);
//		gaService.setLocationAndSize(r, 
//				5, 
//				childrenOffset, 
//				width, 
//				childrenHeight);
		{
			final Shape shape = peCreateService.createShape(containerShape,
					true);
			shape.setActive(false);
//			final Shape shape = peCreateService.createShape(containerShape,
//					true);
			final Text text = gaService.createDefaultText(getDiagram(), shape,
					a.getName());
			text.setHorizontalAlignment(Orientation.ALIGNMENT_LEFT);
			text.setVerticalAlignment(Orientation.ALIGNMENT_CENTER);
			
			gaService
					.setLocationAndSize(text, 5, childrenOffset, width / 2, childrenHeight);

			link(shape, a);
		}
		{
			final Shape input = peCreateService.createShape(containerShape,
					true);
//			final Shape input = peCreateService.createShape(containerShape,
//					true);
			final Text attrfield = gaService.createDefaultText(getDiagram(),
					input, "");
			attrfield.setHorizontalAlignment(Orientation.ALIGNMENT_LEFT);
			attrfield.setVerticalAlignment(Orientation.ALIGNMENT_CENTER);

			gaService.setLocationAndSize(attrfield, (width / 2) + 2,
					childrenOffset, width/2, childrenHeight);

			Arrow aa = ph.createAttributeArrow(node, a);
			
//			System.out.println("Created attribute instance for " + node.eResource() + ": " + aa.eResource());
			
			link(input, aa);
		}

		childrenOffset += 20;
	}

	@Override
	protected void updatePictogramElement(PictogramElement pe) {
		// TODO Auto-generated method stub
		super.updatePictogramElement(pe);
	}
}
