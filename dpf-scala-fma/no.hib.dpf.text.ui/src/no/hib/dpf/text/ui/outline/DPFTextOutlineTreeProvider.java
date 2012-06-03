/*
* generated by Xtext
*/
package no.hib.dpf.text.ui.outline;

import no.hib.dpf.text.tdpf.Definition;
import no.hib.dpf.text.tdpf.Model;
import no.hib.dpf.text.tdpf.Node;
import no.hib.dpf.text.tdpf.TdpfPackage;

import org.eclipse.swt.graphics.Image;
import org.eclipse.xtext.ui.IImageHelper;
import org.eclipse.xtext.ui.editor.outline.IOutlineNode;
import org.eclipse.xtext.ui.editor.outline.impl.DefaultOutlineTreeProvider;
import org.eclipse.xtext.ui.editor.outline.impl.DocumentRootNode;
import org.eclipse.xtext.ui.editor.outline.impl.EObjectNode;

import com.google.inject.Inject;

/**
 * customization of the default outline structure
 * TODO Call scala wrapper from here:
 */
public class DPFTextOutlineTreeProvider extends DefaultOutlineTreeProvider {
	
	@Inject
    private IImageHelper imageHelper;
	
	protected void _createChildren(DocumentRootNode parentNode, Model model) {
        for(Definition d: model.getDefinitions()) {
            createNode(parentNode, d);
        }         
    }
		
//    protected void _createNode(IOutlineNode parentNode, Arrow arrow) {
//    	
//    }	

	protected void _createNode(IOutlineNode parentNode, Node node) {
		EObjectNode n = createEObjectNode(parentNode, node.eClass());
		n.setImage(_image(node));
		n.setText("");
//		createEStructuralFeatureNode(parentNode, owner, feature, image, text, isLeaf)
		createEStructuralFeatureNode(
				parentNode,
				node,
				node.eClass().getEStructuralFeature(TdpfPackage.NODE__ID),
				null, //Image for ID?
				"id=" + node.getId().getName(),
				true);
		createEStructuralFeatureNode(
				parentNode,
				node,
				node.eClass().getEStructuralFeature(TdpfPackage.NODE__TYPE),
				null,//Image for type
				"type=" + node.getType().getName(),
				true);
	}	

	protected Image _image(Node node) {
        return this.imageHelper.getImage("node.png");
    }
	
}
