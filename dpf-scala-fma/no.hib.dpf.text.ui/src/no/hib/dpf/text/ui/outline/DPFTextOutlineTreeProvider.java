/*
 * generated by Xtext
 */
package no.hib.dpf.text.ui.outline;

import no.hib.dpf.text.tdpf.Arrow;
import no.hib.dpf.text.tdpf.Definition;
import no.hib.dpf.text.tdpf.Model;
import no.hib.dpf.text.tdpf.TGraphName;

import org.eclipse.swt.graphics.Image;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.ILocationInFileProvider;
import org.eclipse.xtext.ui.IImageHelper;
import org.eclipse.xtext.ui.editor.outline.IOutlineNode;
import org.eclipse.xtext.ui.editor.outline.impl.DefaultOutlineTreeProvider;
import org.eclipse.xtext.ui.editor.outline.impl.DocumentRootNode;
import org.eclipse.xtext.ui.editor.outline.impl.EObjectNode;
import org.eclipse.xtext.util.TextRegion;

import com.google.inject.Inject;

/**
 * customization of the default outline structure TODO Call scala wrapper from
 * here:
 */
public class DPFTextOutlineTreeProvider extends DefaultOutlineTreeProvider {

	@Inject
	private IImageHelper imageHelper;

	@Inject
	protected ILocationInFileProvider locationInFileProvider;
	
	protected void _createChildren(DocumentRootNode parentNode, Model model) {
		for (Definition d : model.getDefinitions()) {
			createNode(parentNode, d);
		}
	}

	//
	// Graph:
	//
	protected void _createNode(IOutlineNode parentNode, TGraphName node) {
	}

	//
	// Arrow:
	//
	protected void _createNode(IOutlineNode parentNode, Arrow arrow) {
//		EObjectNode n = createEObjectNode(parentNode, arrow.eClass());
		Object text = textDispatcher.invoke(arrow);
		Image image = imageDispatcher.invoke(arrow);
		EObjectNode eObjectNode = new EObjectNode(arrow, parentNode, image, text, true);
//		ICompositeNode parserNode = NodeModelUtils.getNode(arrow);
//		if (parserNode != null)
//			eObjectNode.setTextRegion(new TextRegion(parserNode.getOffset(), parserNode.getLength()));
		eObjectNode.setShortTextRegion(locationInFileProvider.getSignificantTextRegion(arrow));
	}

	// //
	// //Node:
	// //
	// protected void _createNode(IOutlineNode parentNode, Node node) {
	// EObjectNode n = createEObjectNode(parentNode, node.eClass());
	// n.setImage(_image(node));
	// n.setText("");
	// createEStructuralFeatureNode(
	// parentNode,
	// node,
	// node.eClass().getEStructuralFeature(TdpfPackage.NODE__ID),
	// null, //Image for ID?
	// "id=" + node.getId().getId() + "@" + node.getId().getName(),
	// true);
	// createEStructuralFeatureNode(
	// parentNode,
	// node,
	// node.eClass().getEStructuralFeature(TdpfPackage.NODE__TYPE),
	// null,//Image for type
	// "type=" + node.getType().getId() + "@" + node.getType().getName(),
	// true);
	// }
	//
	// protected void _createNode(IOutlineNode parentNode, AttributeValue value)
	// {
	// EObjectNode n = createEObjectNode(parentNode, value.eClass());
	// n.setImage(_image(value));
	// n.setText("");
	// createEStructuralFeatureNode(
	// parentNode,
	// value,
	// value.eClass().getEStructuralFeature(TdpfPackage.ARROW__TG_VALUE),
	// null, //Image for ID?
	// "value=" + value.getValue(),
	// true);
	// }
	//
	// //
	// //Arrow:
	// //
	// protected void _createNode(IOutlineNode parentNode, Arrow arrow) {
	// EObjectNode n = createEObjectNode(parentNode, arrow.eClass());
	// n.setImage(_image(arrow));
	// n.setText("id=" + arrow.getId().getId() + "@" + arrow.getId().getName());
	// //Type:
	// createEStructuralFeatureNode(
	// parentNode,
	// arrow,
	// arrow.eClass().getEStructuralFeature(TdpfPackage.ARROW__TYPE),
	// null,//Image for type
	// "type=" + arrow.getType().getId() + "@" + arrow.getType().getName(),
	// true);
	//
	// //Source:
	// createEStructuralFeatureNode(
	// parentNode,
	// arrow,
	// arrow.eClass().getEStructuralFeature(TdpfPackage.ARROW__SR),
	// null, //Image for ID?
	// "source=" + arrow.getSr().getId().getId() + "@" +
	// arrow.getSr().getId().getName(),
	// false);
	//
	// //Target:
	// if(null != arrow.getTgNode()){
	// createEStructuralFeatureNode(
	// parentNode,
	// arrow,
	// arrow.eClass().getEStructuralFeature(TdpfPackage.ARROW__TG_NODE),
	// null,
	// "target=" + arrow.getTgNode().getId().getId() + "@" +
	// arrow.getTgNode().getId().getName(),
	// false);
	// }
	// else if(null != arrow.getTgValue()){
	// createEStructuralFeatureNode(
	// parentNode,
	// arrow,
	// arrow.eClass().getEStructuralFeature(TdpfPackage.ARROW__TG_VALUE),
	// null,
	// "target=" + arrow.getTgValue().getValue(),
	// false);
	// }
	// else if(null != arrow.getTgDataType()){
	// createEStructuralFeatureNode(
	// parentNode,
	// arrow,
	// arrow.eClass().getEStructuralFeature(TdpfPackage.ARROW__TG_DATA_TYPE),
	// null,
	// "target=" + arrow.getTgDataType().getName(),
	// false);
	// }
	//
	// }
	//
	// protected Image _image(TGraph graph) {
	// return this.imageHelper.getImage("graph.png");
	// }
	//
	// protected Image _image(Node node) {
	// return this.imageHelper.getImage("node.png");
	// }
	//
//	 protected Image _image(Arrow arrow) {
//	 return this.imageHelper.getImage("arrow.png");
//	 }

}
