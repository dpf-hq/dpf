package no.hib.dpf.text.ui;

//import java.util.regex.Pattern;

import org.eclipse.xtext.ui.editor.syntaxcoloring.DefaultAntlrTokenToAttributeIdMapper;

public class DPFTextAntlrTokenToAttributeIdMapper extends
		DefaultAntlrTokenToAttributeIdMapper {

	private static final String ID_SEP = "'@'";
//	private static final Pattern ID = Pattern.compile("([a-zA-Z]|\\s)([a-zA-Z]|\\s|[0-9])*");
	
	@Override
	protected String calculateId(String tokenName, int tokenType) {
		if(ID_SEP.equals(tokenName)) {
			return  DPFTextSyntaxHighlighting.ID_SEP;
		}
		return super.calculateId(tokenName, tokenType);
	}
	
}
