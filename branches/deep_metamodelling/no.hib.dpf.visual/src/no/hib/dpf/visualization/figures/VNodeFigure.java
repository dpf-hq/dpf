package no.hib.dpf.visualization.figures;

import java.io.IOException;
import java.util.List;

import no.hib.dpf.editor.DPFPlugin;
import no.hib.dpf.editor.figures.EditableLabel;
import no.hib.dpf.editor.figures.NodeFigure;

import org.eclipse.draw2d.Border;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.LineBorder;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.RGB;

public class VNodeFigure extends NodeFigure{ 
	public org.eclipse.swt.graphics.Image IMAGE;

	public VNodeFigure(EditableLabel name,  RGB color, Boolean rounded, Boolean shadow) {
		this(name, null, color, rounded, shadow);
	}
	
	@SuppressWarnings("rawtypes")
	public VNodeFigure(EditableLabel name, List columns, RGB color, Boolean rounded, Boolean shadow) {
		super(name);
		Border border = null;
		if (rounded){
			border = new RoundedLineBorder(ColorConstants.gray, 1, 5);	
		}else{
			border = new LineBorder(ColorConstants.gray, 1);
		}
		
		setBorder(border);
		if(color != null){
			setBackgroundColor(new Color(null,color));
		}
		
		try {
			IMAGE = new Image(null, DPFPlugin.getDefault().getBundle().getResource("/icons/error.png").openStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

	public VNodeFigure() {
		// super();
	}
}
