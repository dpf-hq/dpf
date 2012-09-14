package no.hib.mums.partmaker.propertytab;

import no.hib.dpf.core.Node;

import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.ui.platform.GFPropertySection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;

public class PartPropertySection extends GFPropertySection implements ITabbedPropertyConstants {

    private Text nameText, objId;
//    private Text[] attributes;
    
    @Override
    public void createControls(Composite parent, TabbedPropertySheetPage tabbedPropertySheetPage) {
        super.createControls(parent, tabbedPropertySheetPage);
 
        TabbedPropertySheetWidgetFactory factory = getWidgetFactory();
        Composite composite = factory.createFlatFormComposite(parent);
        FormData data;
        
        nameText = factory.createText(composite, "");
        data = new FormData();
        data.left = new FormAttachment(0, STANDARD_LABEL_WIDTH);
        data.right = new FormAttachment(100, 0);
        data.top = new FormAttachment(0, VSPACE);
        nameText.setLayoutData(data);
 
        CLabel valueLabel = factory.createCLabel(composite, "Name:");
        data = new FormData();
        data.left = new FormAttachment(0, 0);
        data.right = new FormAttachment(nameText, -HSPACE);
        data.top = new FormAttachment(nameText, 0, SWT.CENTER);
        valueLabel.setLayoutData(data);
        
        objId = factory.createText(composite, "");
        data = new FormData();
        data.left = new FormAttachment(0, STANDARD_LABEL_WIDTH);
        data.right = new FormAttachment(100, 0);
        data.top = new FormAttachment(0, 20 + VSPACE);
        objId.setLayoutData(data);
        
        CLabel objLbl = factory.createCLabel(composite, "Object ID:");
        data = new FormData();
        data.left = new FormAttachment(0, 0);
        data.right = new FormAttachment(objId, -HSPACE);
        data.top = new FormAttachment(objId, 20 + VSPACE, SWT.CENTER);
        objLbl.setLayoutData(data);
        
//        System.out.println("CreateCOntrols");
//        PictogramElement pe = getSelectedPictogramElement();
//        if (pe != null) {
//            Object bo = Graphiti.getLinkService()
//                 .getBusinessObjectForLinkedPictogramElement(pe);
//            // the filter assured, that it is a EClass
//            if (bo == null)
//                return;
//            Node n = (Node) bo;
//            
//            for(Arrow a : n.getOutgoings()) {
//            	
//            }
//        }
    }
 
    @Override
    public void refresh() {
        PictogramElement pe = getSelectedPictogramElement();
        if (pe != null) {
            Object bo = Graphiti.getLinkService()
                 .getBusinessObjectForLinkedPictogramElement(pe);
            // the filter assured, that it is a EClass
            if (bo == null)
                return;
            Node n = (Node) bo;
            nameText.setText(n.getName() == null ? "" : n.getName());
            objId.setText(n.getId() == null ? "" : n.getId());
        }
    }
}
 
