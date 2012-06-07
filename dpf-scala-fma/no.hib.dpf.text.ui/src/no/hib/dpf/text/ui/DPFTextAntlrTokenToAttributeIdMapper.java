package no.hib.dpf.text.ui;

import org.eclipse.xtext.ui.editor.syntaxcoloring.DefaultAntlrTokenToAttributeIdMapper;

public class DPFTextAntlrTokenToAttributeIdMapper extends
		DefaultAntlrTokenToAttributeIdMapper {

	private static final String START_ARROW = "'-'";
	private static final String STOP_ARROW = "'->'";
	private static final String STOP_ARROW_REVERSE = "'<-'";
	
	@Override
	protected String calculateId(String tokenName, int tokenType) {
		if(START_ARROW.equals(tokenName)) {
			return  DPFTextSyntaxHighlighting.ARROW;
		}
		if(STOP_ARROW.equals(tokenName)) {
			return  DPFTextSyntaxHighlighting.ARROW;
		}
		if(STOP_ARROW_REVERSE.equals(tokenName)) {
			return  DPFTextSyntaxHighlighting.ARROW;
		}
		return super.calculateId(tokenName, tokenType);
	}
	
}
