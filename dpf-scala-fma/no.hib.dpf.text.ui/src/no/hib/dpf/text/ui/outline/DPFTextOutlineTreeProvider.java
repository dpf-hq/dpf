/*
 * generated by Xtext
 */
package no.hib.dpf.text.ui.outline;

import no.hib.dpf.text.tdpf.Arrow;
import no.hib.dpf.text.tdpf.Arrows;
import no.hib.dpf.text.tdpf.Definition;
import no.hib.dpf.text.tdpf.DpfId;
import no.hib.dpf.text.tdpf.Element;
import no.hib.dpf.text.tdpf.Model;
import no.hib.dpf.text.tdpf.Node;
import no.hib.dpf.text.tdpf.TGraph;
import no.hib.dpf.text.tdpf.TGraphName;
import no.hib.dpf.text.tdpf.impl.TdpfFactoryImpl;

import org.eclipse.jface.viewers.StyledString;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.text.edits.ReplaceEdit;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.nodemodel.BidiTreeIterator;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.impl.LeafNode;
import org.eclipse.xtext.nodemodel.impl.NodeModelBuilder;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.ILocationInFileProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.outline.IOutlineNode;
import org.eclipse.xtext.ui.editor.outline.impl.DefaultOutlineTreeProvider;
import org.eclipse.xtext.ui.editor.outline.impl.DocumentRootNode;
import org.eclipse.xtext.ui.editor.outline.impl.EObjectNode;
import org.eclipse.xtext.util.ITextRegion;

import com.google.inject.Inject;

/**
 * customization of the default outline structure TODO Call scala wrapper from
 * here:
 */
public class DPFTextOutlineTreeProvider extends DefaultOutlineTreeProvider {


	@Inject
	protected ILocationInFileProvider locationInFileProvider;
//	protected ILocationInFileProvider locationInFileProvider =	new DefaultLocationInFileProvider();
	
	@Inject
	protected XtextResource xresource;
			
	@Inject
	protected XtextEditor editor;
	
	protected NodeModelBuilder nodeModelBuilder = new NodeModelBuilder();
	protected IXtextDocument document;
	
	boolean autocompleteIds = false;
	boolean isInited = false;
	
	protected void _createChildren(final DocumentRootNode parentNode, final Model model) {
		Display display = Display.getDefault();
		
		//Init:
		if(!isInited){
		   init(model); 	
		}
		
		for (Definition d : model.getDefinitions()) {
			createNode(parentNode, d);
		}
	
		//Defs schon da?:
		if(autocompleteIds)
		display.syncExec(new Runnable() {
	    public void run(){
	    	autocompleteIds=false;
			for (Definition d : model.getDefinitions()){
				int offSet = 0;
				if(d instanceof TGraph){
					final TGraph t = (TGraph) d;
					for (Element e : t.getElements()) {
						if(e instanceof Arrow){
							Arrow arrow = (Arrow)e;
							final ITextRegion location = locationInFileProvider.getSignificantTextRegion(arrow.getId());
							if(arrow.getId().getId() < 1){
								
								//Change document:
								offSet += location.getOffset()+arrow.getId().getName().length();
								ReplaceEdit r = new ReplaceEdit(offSet,0,"@" + 100);//UPDATE 1	
								try {
									r.apply(document,ReplaceEdit.NONE);
								} catch (Exception ex) {
									ex.printStackTrace();
								}
								return;
							}
						}
					}		
				}
			}
	    }
	  });
	  autocompleteIds=true;
	}

//	//
//	//Document:
//	//
	@Override
	public IOutlineNode createRoot(IXtextDocument d){
		this.document = d;
		return super.createRoot(document);
	}
	
	public void init(final Model model){
		//
		//Add missing Ids:
		//
		final ICompositeNode c = NodeModelUtils.findActualNodeFor(model);
		final StringBuffer buffer = new StringBuffer();
		BidiTreeIterator<INode> ti = c.getAsTreeIterable().iterator();
		StringBuffer cache = new StringBuffer();
		boolean incompleteDpfId=false;
		DpfId id = null;
		while(ti.hasNext()){
			final INode n = ti.next();
			if(n instanceof LeafNode){		
				if(n.getSemanticElement() instanceof DpfId){
					id = (DpfId)n.getSemanticElement(); 
					if(id.getId() < 1){
						incompleteDpfId=true;
						cache.append(n.getText());
					}else{
						buffer.append(n.getText());
					}
				}else{
					if(incompleteDpfId){
						buffer.append(cache.toString().replaceFirst(id.getName(),id.getName() + "@100"));
						cache = new StringBuffer();
					    incompleteDpfId=false;
					}
					buffer.append(n.getText());
				}
			}
		}
		//
		//Add automatic all IDs at once: 
		//
		final ReplaceEdit r = new ReplaceEdit(0,document.getLength(),buffer.toString());	
		try {
			r.apply(document,ReplaceEdit.NONE);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		System.out.println("Test:" + buffer.toString());
		this.isInited=true;
	}
	
	
	//
	// Graph:
	//
	protected void _createNode(IOutlineNode parentNode, TGraphName name) {
	}

	//
	// Arrow:
	//
	/**
	 * Create Arrow for outline view:
	 * @param parentNode
	 * @param arrow
	 */
	protected void _createNode(IOutlineNode parentNode, Arrow arrow) {
		Image image = imageDispatcher.invoke(arrow);
		EObjectNode eObjectNode = new EObjectNode(arrow, parentNode, image, makeLabel(arrow), true);
		ITextRegion location = locationInFileProvider.getSignificantTextRegion(arrow.getId());
		eObjectNode.setShortTextRegion(location);
	}
	
	/**
	 * Make Label for an Arrow
	 * @param arrow
	 * @return
	 */
	protected StyledString makeLabel(Arrow arrow) {
		try {			
			final String id = arrow.getId().getName() + "@" + arrow.getId().getId() + ":" +
							  (null!=arrow.getType()?arrow.getType().getName() + "@" + arrow.getType().getId():"Attribute");
			final String sr = arrow.getSr().getId().getName() + "@" + arrow.getSr().getId().getId() + ":" 
						     + arrow.getSr().getType().getName() + "@" + arrow.getSr().getType().getId();
			String tg = "";		
			//Target:
			if(null != arrow.getTgNode()){
				Node n = arrow.getTgNode();
				tg = makeLabel(n);
			}
			else if(null != arrow.getTgValue()){
				tg = arrow.getTgValue().getValue();
			}
			else if(null != arrow.getTgDataType()){
				tg = arrow.getTgDataType().getName() + ":Datatype";
			}		
			final StyledString ret = new StyledString(sr + " --- " + id + " ---> " + tg);
			ret.setStyle(sr.length() + 1,id.length()+10, StyledString.COUNTER_STYLER);
		return ret;
		} catch (Exception e) {
			System.out.println("Source: " + arrow.getSr());
			System.out.println("Type  : " + arrow.getType());
			return new StyledString("Problem with arrow: " + arrow.getId().getName());
		}
	}

	/**
	 * Split Arrow-List into to sequence of Arrows
	 * @param parentNode
	 * @param arrows
	 */
	protected void _createNode(IOutlineNode parentNode, Arrows arrows) {
		
		//Create head arrow:
		Arrow a = new TdpfFactoryImpl().createArrow();
		a.setId(arrows.getId());
		a.setType(arrows.getType());
		a.setSr(EcoreUtil2.clone(arrows.getSr()));
		Arrows next = arrows.getNext();
		a.setTgNode(EcoreUtil2.clone(next.getSr()));
		_createNode(parentNode, a);
		
		//Call either creation method for arrow or arrows:
		if(next instanceof Arrow){
			_createNode(parentNode, (Arrow) next);
		}else{
			_createNode(parentNode, (Arrows) next);
		}
			
	}
	
	//
	// Node:
	//
	/**
	 * Create Arrow for outline view:
	 * @param parentNode
	 * @param arrow
	 */
	protected void _createNode(IOutlineNode parentNode, Node node) {
		Image image = imageDispatcher.invoke(node);
		EObjectNode eObjectNode = new EObjectNode(node, parentNode, image, new StyledString(makeLabel(node)), true);
		eObjectNode.setShortTextRegion(locationInFileProvider.getSignificantTextRegion(node.getId()));
	}
	
	/**
	 * Make Label for a Node
	 * @param n
	 * @return
	 */
	private String makeLabel(Node n) {
		String tg;
		tg = n.getId().getId() + "@" + n.getId().getName() + ":"
		   + n.getType().getName() + "@" + n.getType().getId();
		return tg;
	}
	
	
}
