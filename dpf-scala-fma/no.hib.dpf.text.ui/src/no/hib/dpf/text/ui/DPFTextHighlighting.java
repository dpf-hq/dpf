package no.hib.dpf.text.ui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.xtext.ui.editor.syntaxcoloring.DefaultHighlightingConfiguration;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingConfigurationAcceptor;
import org.eclipse.xtext.ui.editor.utils.TextStyle;

public class DPFTextHighlighting extends DefaultHighlightingConfiguration {
	
	public static final String ID_SEP = "ID_SEPERATOR";
	public static final String ARROW = "ARROW";
	
	public void configure(IHighlightingConfigurationAcceptor acceptor) {
		super.configure(acceptor);
		acceptor.acceptDefaultHighlighting(ID_SEP, "ID Seperator", idSeperator());
		acceptor.acceptDefaultHighlighting(ARROW, "Arrow", arrow());
	}

	public static final TextStyle idSeperator() {
		TextStyle textStyle = new TextStyle();
		textStyle.setColor(new RGB(128, 0, 0));
		textStyle.setStyle(SWT.BOLD);
		return textStyle;
	}

	public static final TextStyle arrow() {
		TextStyle textStyle = new TextStyle();
		textStyle.setColor(new RGB(0, 0, 255));
		textStyle.setStyle(SWT.BOLD);
		return textStyle;
	}

}
