package no.hib.dpf.text.ui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.xtext.ui.editor.syntaxcoloring.DefaultHighlightingConfiguration;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingConfigurationAcceptor;
import org.eclipse.xtext.ui.editor.utils.TextStyle;

public class DPFTextSyntaxHighlighting extends DefaultHighlightingConfiguration {
	
	public static final String ARROW = "Arrow";

	public void configure(IHighlightingConfigurationAcceptor acceptor) {
		super.configure(acceptor);
		acceptor.acceptDefaultHighlighting(ARROW, "ARROW_START", arrowTextStyle());
	}

	public TextStyle arrowTextStyle() {
		TextStyle textStyle = new TextStyle();
		textStyle.setColor(new RGB(255, 0, 0));
		textStyle.setStyle(SWT.BOLD);
		return textStyle;
	}
}
