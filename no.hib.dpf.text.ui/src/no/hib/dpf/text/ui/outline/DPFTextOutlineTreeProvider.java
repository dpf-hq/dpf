package no.hib.dpf.text.ui.outline;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import no.hib.dpf.text.tdpf.Arrow;
import no.hib.dpf.text.tdpf.Arrows;
import no.hib.dpf.text.tdpf.DpfId;
import no.hib.dpf.text.tdpf.Node;
import no.hib.dpf.text.tdpf.SequenceNumber;
import no.hib.dpf.text.tdpf.Specification;
import no.hib.dpf.text.tdpf.TdpfFactory;
import no.hib.dpf.text.ui.FileSaveDetector;
import no.hib.dpf.text.ui.Normalizer;

import org.eclipse.core.resources.IFile;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.PlatformUI;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.resource.ILocationInFileProvider;
import org.eclipse.xtext.ui.editor.CompoundXtextEditorCallback;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.outline.IOutlineNode;
import org.eclipse.xtext.ui.editor.outline.impl.DefaultOutlineTreeProvider;
import org.eclipse.xtext.ui.editor.outline.impl.DocumentRootNode;
import org.eclipse.xtext.ui.editor.outline.impl.EObjectNode;
import org.eclipse.xtext.util.ITextRegion;

import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Module;


public class DPFTextOutlineTreeProvider extends DefaultOutlineTreeProvider implements PropertyChangeListener{

	@Inject
	protected ILocationInFileProvider locationInFileProvider;
	
	protected IXtextDocument document;
	
	@Inject
	protected XtextEditor xtextEditor;
	
	private boolean init = true;
	
	public DPFTextOutlineTreeProvider(){
		FileSaveDetector.INSTANCE.getSupport().addPropertyChangeListener(this);
	}
	
	//
	//Document:
	//
	@Override
	public IOutlineNode createRoot(IXtextDocument d){
		this.document = d;
		return super.createRoot(d);
	}
	
	protected void _createChildren(final DocumentRootNode parentNode, final Specification s) {
		if(init){
			Normalizer.initCache(this.document, s);
			init=false;
		}
		super._createChildren(parentNode,s);
	}
	
	//
	//So not show SequenceNumber in outline view:
	//
	protected void _createNode(IOutlineNode parentNode, SequenceNumber sn) {
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
		return idToString(n.getId()) + ":" + idToString(n.getType());
	}
	protected String idToString(DpfId id) {
		return id.getName() + ((-1 < id.getId())?("@" + id.getId()):"");
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
			final String id = idToString(arrow.getId()) +
							  (null!=arrow.getType()?idToString(arrow.getType()):"Attribute");
			final String sr = idToString(arrow.getSr().getId()) + ":" + idToString(arrow.getSr().getType());
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
		Arrow a = TdpfFactory.eINSTANCE.createArrow();
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

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		try {
			//What is the active File in the editor:
			IFile f = null;
			try {
				f = (IFile)PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().
						   getActivePart().getSite().getPage().getActiveEditor().getEditorInput().getAdapter(IFile.class);
			} catch (Exception e) {
				//ignore
			}
			if(null != f && f.getName().equals(evt.getPropertyName())){
				//Set Dirty Editor = false;
				xtextEditor.setXtextEditorCallback(new CompoundXtextEditorCallback(Guice.createInjector(new Module() {
					public void configure(Binder binder) {}
				})));	
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
