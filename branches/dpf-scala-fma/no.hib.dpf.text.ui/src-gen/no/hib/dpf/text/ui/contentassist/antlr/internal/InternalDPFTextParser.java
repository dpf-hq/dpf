package no.hib.dpf.text.ui.contentassist.antlr.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.DFA;
import no.hib.dpf.text.services.DPFTextGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalDPFTextParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_NUMBER", "RULE_CHAR", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ANY_OTHER", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "'Boolean'", "'Char'", "'Byte'", "'Short'", "'Int'", "'Long'", "'Float'", "'Double'", "'String'", "'emf('", "')'", "'ecore('", "'image('", "'simpleEvolution('", "'<-'", "'->'", "','", "'evolution('", "'<->'", "'-><-'", "'Specification'", "':'", "'<'", "'>'", "'{'", "'}'", "'('", "'Constraints'", "'='", "':='", "'Morphism'", "'=>'", "'ExtSubTGraph'", "'Graph'", "'-'", "'*'", "'['", "']'", "'@'"
    };
    public static final int RULE_ID=7;
    public static final int T__29=29;
    public static final int T__28=28;
    public static final int T__27=27;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int RULE_ANY_OTHER=9;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int EOF=-1;
    public static final int T__19=19;
    public static final int T__16=16;
    public static final int T__51=51;
    public static final int T__15=15;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int RULE_NUMBER=4;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_INT=8;
    public static final int RULE_CHAR=5;
    public static final int T__50=50;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int RULE_SL_COMMENT=11;
    public static final int RULE_ML_COMMENT=10;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int RULE_STRING=6;
    public static final int T__32=32;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int RULE_WS=12;

    // delegates
    // delegators


        public InternalDPFTextParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalDPFTextParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalDPFTextParser.tokenNames; }
    public String getGrammarFileName() { return "../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g"; }


     
     	private DPFTextGrammarAccess grammarAccess;
     	
        public void setGrammarAccess(DPFTextGrammarAccess grammarAccess) {
        	this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected Grammar getGrammar() {
        	return grammarAccess.getGrammar();
        }
        
        @Override
        protected String getValueForTokenName(String tokenName) {
        	return tokenName;
        }




    // $ANTLR start "entryRuleModel"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:60:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:61:1: ( ruleModel EOF )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:62:1: ruleModel EOF
            {
             before(grammarAccess.getModelRule()); 
            pushFollow(FOLLOW_ruleModel_in_entryRuleModel61);
            ruleModel();

            state._fsp--;

             after(grammarAccess.getModelRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleModel68); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:69:1: ruleModel : ( ( rule__Model__Alternatives ) ) ;
    public final void ruleModel() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:73:2: ( ( ( rule__Model__Alternatives ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:74:1: ( ( rule__Model__Alternatives ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:74:1: ( ( rule__Model__Alternatives ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:75:1: ( rule__Model__Alternatives )
            {
             before(grammarAccess.getModelAccess().getAlternatives()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:76:1: ( rule__Model__Alternatives )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:76:2: rule__Model__Alternatives
            {
            pushFollow(FOLLOW_rule__Model__Alternatives_in_ruleModel94);
            rule__Model__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getModelAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleVALUE"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:88:1: entryRuleVALUE : ruleVALUE EOF ;
    public final void entryRuleVALUE() throws RecognitionException {
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:89:1: ( ruleVALUE EOF )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:90:1: ruleVALUE EOF
            {
             before(grammarAccess.getVALUERule()); 
            pushFollow(FOLLOW_ruleVALUE_in_entryRuleVALUE121);
            ruleVALUE();

            state._fsp--;

             after(grammarAccess.getVALUERule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVALUE128); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleVALUE"


    // $ANTLR start "ruleVALUE"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:97:1: ruleVALUE : ( ( rule__VALUE__Alternatives ) ) ;
    public final void ruleVALUE() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:101:2: ( ( ( rule__VALUE__Alternatives ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:102:1: ( ( rule__VALUE__Alternatives ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:102:1: ( ( rule__VALUE__Alternatives ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:103:1: ( rule__VALUE__Alternatives )
            {
             before(grammarAccess.getVALUEAccess().getAlternatives()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:104:1: ( rule__VALUE__Alternatives )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:104:2: rule__VALUE__Alternatives
            {
            pushFollow(FOLLOW_rule__VALUE__Alternatives_in_ruleVALUE154);
            rule__VALUE__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getVALUEAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleVALUE"


    // $ANTLR start "entryRuleCommand"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:116:1: entryRuleCommand : ruleCommand EOF ;
    public final void entryRuleCommand() throws RecognitionException {
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:117:1: ( ruleCommand EOF )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:118:1: ruleCommand EOF
            {
             before(grammarAccess.getCommandRule()); 
            pushFollow(FOLLOW_ruleCommand_in_entryRuleCommand181);
            ruleCommand();

            state._fsp--;

             after(grammarAccess.getCommandRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCommand188); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleCommand"


    // $ANTLR start "ruleCommand"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:125:1: ruleCommand : ( ( rule__Command__Alternatives ) ) ;
    public final void ruleCommand() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:129:2: ( ( ( rule__Command__Alternatives ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:130:1: ( ( rule__Command__Alternatives ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:130:1: ( ( rule__Command__Alternatives ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:131:1: ( rule__Command__Alternatives )
            {
             before(grammarAccess.getCommandAccess().getAlternatives()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:132:1: ( rule__Command__Alternatives )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:132:2: rule__Command__Alternatives
            {
            pushFollow(FOLLOW_rule__Command__Alternatives_in_ruleCommand214);
            rule__Command__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getCommandAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleCommand"


    // $ANTLR start "entryRuleMakeEmf"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:144:1: entryRuleMakeEmf : ruleMakeEmf EOF ;
    public final void entryRuleMakeEmf() throws RecognitionException {
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:145:1: ( ruleMakeEmf EOF )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:146:1: ruleMakeEmf EOF
            {
             before(grammarAccess.getMakeEmfRule()); 
            pushFollow(FOLLOW_ruleMakeEmf_in_entryRuleMakeEmf241);
            ruleMakeEmf();

            state._fsp--;

             after(grammarAccess.getMakeEmfRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMakeEmf248); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleMakeEmf"


    // $ANTLR start "ruleMakeEmf"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:153:1: ruleMakeEmf : ( ( rule__MakeEmf__Group__0 ) ) ;
    public final void ruleMakeEmf() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:157:2: ( ( ( rule__MakeEmf__Group__0 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:158:1: ( ( rule__MakeEmf__Group__0 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:158:1: ( ( rule__MakeEmf__Group__0 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:159:1: ( rule__MakeEmf__Group__0 )
            {
             before(grammarAccess.getMakeEmfAccess().getGroup()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:160:1: ( rule__MakeEmf__Group__0 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:160:2: rule__MakeEmf__Group__0
            {
            pushFollow(FOLLOW_rule__MakeEmf__Group__0_in_ruleMakeEmf274);
            rule__MakeEmf__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getMakeEmfAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleMakeEmf"


    // $ANTLR start "entryRuleMakeEcore"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:172:1: entryRuleMakeEcore : ruleMakeEcore EOF ;
    public final void entryRuleMakeEcore() throws RecognitionException {
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:173:1: ( ruleMakeEcore EOF )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:174:1: ruleMakeEcore EOF
            {
             before(grammarAccess.getMakeEcoreRule()); 
            pushFollow(FOLLOW_ruleMakeEcore_in_entryRuleMakeEcore301);
            ruleMakeEcore();

            state._fsp--;

             after(grammarAccess.getMakeEcoreRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMakeEcore308); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleMakeEcore"


    // $ANTLR start "ruleMakeEcore"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:181:1: ruleMakeEcore : ( ( rule__MakeEcore__Group__0 ) ) ;
    public final void ruleMakeEcore() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:185:2: ( ( ( rule__MakeEcore__Group__0 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:186:1: ( ( rule__MakeEcore__Group__0 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:186:1: ( ( rule__MakeEcore__Group__0 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:187:1: ( rule__MakeEcore__Group__0 )
            {
             before(grammarAccess.getMakeEcoreAccess().getGroup()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:188:1: ( rule__MakeEcore__Group__0 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:188:2: rule__MakeEcore__Group__0
            {
            pushFollow(FOLLOW_rule__MakeEcore__Group__0_in_ruleMakeEcore334);
            rule__MakeEcore__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getMakeEcoreAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleMakeEcore"


    // $ANTLR start "entryRuleMakeImage"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:200:1: entryRuleMakeImage : ruleMakeImage EOF ;
    public final void entryRuleMakeImage() throws RecognitionException {
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:201:1: ( ruleMakeImage EOF )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:202:1: ruleMakeImage EOF
            {
             before(grammarAccess.getMakeImageRule()); 
            pushFollow(FOLLOW_ruleMakeImage_in_entryRuleMakeImage361);
            ruleMakeImage();

            state._fsp--;

             after(grammarAccess.getMakeImageRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMakeImage368); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleMakeImage"


    // $ANTLR start "ruleMakeImage"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:209:1: ruleMakeImage : ( ( rule__MakeImage__Group__0 ) ) ;
    public final void ruleMakeImage() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:213:2: ( ( ( rule__MakeImage__Group__0 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:214:1: ( ( rule__MakeImage__Group__0 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:214:1: ( ( rule__MakeImage__Group__0 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:215:1: ( rule__MakeImage__Group__0 )
            {
             before(grammarAccess.getMakeImageAccess().getGroup()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:216:1: ( rule__MakeImage__Group__0 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:216:2: rule__MakeImage__Group__0
            {
            pushFollow(FOLLOW_rule__MakeImage__Group__0_in_ruleMakeImage394);
            rule__MakeImage__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getMakeImageAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleMakeImage"


    // $ANTLR start "entryRuleSimpleEvoSpan"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:228:1: entryRuleSimpleEvoSpan : ruleSimpleEvoSpan EOF ;
    public final void entryRuleSimpleEvoSpan() throws RecognitionException {
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:229:1: ( ruleSimpleEvoSpan EOF )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:230:1: ruleSimpleEvoSpan EOF
            {
             before(grammarAccess.getSimpleEvoSpanRule()); 
            pushFollow(FOLLOW_ruleSimpleEvoSpan_in_entryRuleSimpleEvoSpan421);
            ruleSimpleEvoSpan();

            state._fsp--;

             after(grammarAccess.getSimpleEvoSpanRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSimpleEvoSpan428); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleSimpleEvoSpan"


    // $ANTLR start "ruleSimpleEvoSpan"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:237:1: ruleSimpleEvoSpan : ( ( rule__SimpleEvoSpan__Group__0 ) ) ;
    public final void ruleSimpleEvoSpan() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:241:2: ( ( ( rule__SimpleEvoSpan__Group__0 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:242:1: ( ( rule__SimpleEvoSpan__Group__0 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:242:1: ( ( rule__SimpleEvoSpan__Group__0 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:243:1: ( rule__SimpleEvoSpan__Group__0 )
            {
             before(grammarAccess.getSimpleEvoSpanAccess().getGroup()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:244:1: ( rule__SimpleEvoSpan__Group__0 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:244:2: rule__SimpleEvoSpan__Group__0
            {
            pushFollow(FOLLOW_rule__SimpleEvoSpan__Group__0_in_ruleSimpleEvoSpan454);
            rule__SimpleEvoSpan__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getSimpleEvoSpanAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleSimpleEvoSpan"


    // $ANTLR start "entryRuleSimpleEvoCospan"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:256:1: entryRuleSimpleEvoCospan : ruleSimpleEvoCospan EOF ;
    public final void entryRuleSimpleEvoCospan() throws RecognitionException {
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:257:1: ( ruleSimpleEvoCospan EOF )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:258:1: ruleSimpleEvoCospan EOF
            {
             before(grammarAccess.getSimpleEvoCospanRule()); 
            pushFollow(FOLLOW_ruleSimpleEvoCospan_in_entryRuleSimpleEvoCospan481);
            ruleSimpleEvoCospan();

            state._fsp--;

             after(grammarAccess.getSimpleEvoCospanRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSimpleEvoCospan488); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleSimpleEvoCospan"


    // $ANTLR start "ruleSimpleEvoCospan"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:265:1: ruleSimpleEvoCospan : ( ( rule__SimpleEvoCospan__Group__0 ) ) ;
    public final void ruleSimpleEvoCospan() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:269:2: ( ( ( rule__SimpleEvoCospan__Group__0 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:270:1: ( ( rule__SimpleEvoCospan__Group__0 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:270:1: ( ( rule__SimpleEvoCospan__Group__0 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:271:1: ( rule__SimpleEvoCospan__Group__0 )
            {
             before(grammarAccess.getSimpleEvoCospanAccess().getGroup()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:272:1: ( rule__SimpleEvoCospan__Group__0 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:272:2: rule__SimpleEvoCospan__Group__0
            {
            pushFollow(FOLLOW_rule__SimpleEvoCospan__Group__0_in_ruleSimpleEvoCospan514);
            rule__SimpleEvoCospan__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getSimpleEvoCospanAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleSimpleEvoCospan"


    // $ANTLR start "entryRuleEvoSpan"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:284:1: entryRuleEvoSpan : ruleEvoSpan EOF ;
    public final void entryRuleEvoSpan() throws RecognitionException {
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:285:1: ( ruleEvoSpan EOF )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:286:1: ruleEvoSpan EOF
            {
             before(grammarAccess.getEvoSpanRule()); 
            pushFollow(FOLLOW_ruleEvoSpan_in_entryRuleEvoSpan541);
            ruleEvoSpan();

            state._fsp--;

             after(grammarAccess.getEvoSpanRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEvoSpan548); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleEvoSpan"


    // $ANTLR start "ruleEvoSpan"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:293:1: ruleEvoSpan : ( ( rule__EvoSpan__Group__0 ) ) ;
    public final void ruleEvoSpan() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:297:2: ( ( ( rule__EvoSpan__Group__0 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:298:1: ( ( rule__EvoSpan__Group__0 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:298:1: ( ( rule__EvoSpan__Group__0 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:299:1: ( rule__EvoSpan__Group__0 )
            {
             before(grammarAccess.getEvoSpanAccess().getGroup()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:300:1: ( rule__EvoSpan__Group__0 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:300:2: rule__EvoSpan__Group__0
            {
            pushFollow(FOLLOW_rule__EvoSpan__Group__0_in_ruleEvoSpan574);
            rule__EvoSpan__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getEvoSpanAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEvoSpan"


    // $ANTLR start "entryRuleEvoCospan"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:312:1: entryRuleEvoCospan : ruleEvoCospan EOF ;
    public final void entryRuleEvoCospan() throws RecognitionException {
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:313:1: ( ruleEvoCospan EOF )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:314:1: ruleEvoCospan EOF
            {
             before(grammarAccess.getEvoCospanRule()); 
            pushFollow(FOLLOW_ruleEvoCospan_in_entryRuleEvoCospan601);
            ruleEvoCospan();

            state._fsp--;

             after(grammarAccess.getEvoCospanRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEvoCospan608); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleEvoCospan"


    // $ANTLR start "ruleEvoCospan"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:321:1: ruleEvoCospan : ( ( rule__EvoCospan__Group__0 ) ) ;
    public final void ruleEvoCospan() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:325:2: ( ( ( rule__EvoCospan__Group__0 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:326:1: ( ( rule__EvoCospan__Group__0 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:326:1: ( ( rule__EvoCospan__Group__0 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:327:1: ( rule__EvoCospan__Group__0 )
            {
             before(grammarAccess.getEvoCospanAccess().getGroup()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:328:1: ( rule__EvoCospan__Group__0 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:328:2: rule__EvoCospan__Group__0
            {
            pushFollow(FOLLOW_rule__EvoCospan__Group__0_in_ruleEvoCospan634);
            rule__EvoCospan__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getEvoCospanAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEvoCospan"


    // $ANTLR start "entryRuleSpecification"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:340:1: entryRuleSpecification : ruleSpecification EOF ;
    public final void entryRuleSpecification() throws RecognitionException {
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:341:1: ( ruleSpecification EOF )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:342:1: ruleSpecification EOF
            {
             before(grammarAccess.getSpecificationRule()); 
            pushFollow(FOLLOW_ruleSpecification_in_entryRuleSpecification661);
            ruleSpecification();

            state._fsp--;

             after(grammarAccess.getSpecificationRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSpecification668); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleSpecification"


    // $ANTLR start "ruleSpecification"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:349:1: ruleSpecification : ( ( rule__Specification__Group__0 ) ) ;
    public final void ruleSpecification() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:353:2: ( ( ( rule__Specification__Group__0 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:354:1: ( ( rule__Specification__Group__0 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:354:1: ( ( rule__Specification__Group__0 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:355:1: ( rule__Specification__Group__0 )
            {
             before(grammarAccess.getSpecificationAccess().getGroup()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:356:1: ( rule__Specification__Group__0 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:356:2: rule__Specification__Group__0
            {
            pushFollow(FOLLOW_rule__Specification__Group__0_in_ruleSpecification694);
            rule__Specification__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getSpecificationAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleSpecification"


    // $ANTLR start "entryRuleChoosenSpecification"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:368:1: entryRuleChoosenSpecification : ruleChoosenSpecification EOF ;
    public final void entryRuleChoosenSpecification() throws RecognitionException {
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:369:1: ( ruleChoosenSpecification EOF )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:370:1: ruleChoosenSpecification EOF
            {
             before(grammarAccess.getChoosenSpecificationRule()); 
            pushFollow(FOLLOW_ruleChoosenSpecification_in_entryRuleChoosenSpecification721);
            ruleChoosenSpecification();

            state._fsp--;

             after(grammarAccess.getChoosenSpecificationRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleChoosenSpecification728); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleChoosenSpecification"


    // $ANTLR start "ruleChoosenSpecification"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:377:1: ruleChoosenSpecification : ( ( rule__ChoosenSpecification__IdAssignment ) ) ;
    public final void ruleChoosenSpecification() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:381:2: ( ( ( rule__ChoosenSpecification__IdAssignment ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:382:1: ( ( rule__ChoosenSpecification__IdAssignment ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:382:1: ( ( rule__ChoosenSpecification__IdAssignment ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:383:1: ( rule__ChoosenSpecification__IdAssignment )
            {
             before(grammarAccess.getChoosenSpecificationAccess().getIdAssignment()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:384:1: ( rule__ChoosenSpecification__IdAssignment )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:384:2: rule__ChoosenSpecification__IdAssignment
            {
            pushFollow(FOLLOW_rule__ChoosenSpecification__IdAssignment_in_ruleChoosenSpecification754);
            rule__ChoosenSpecification__IdAssignment();

            state._fsp--;


            }

             after(grammarAccess.getChoosenSpecificationAccess().getIdAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleChoosenSpecification"


    // $ANTLR start "entryRuleSequenceNumber"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:396:1: entryRuleSequenceNumber : ruleSequenceNumber EOF ;
    public final void entryRuleSequenceNumber() throws RecognitionException {
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:397:1: ( ruleSequenceNumber EOF )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:398:1: ruleSequenceNumber EOF
            {
             before(grammarAccess.getSequenceNumberRule()); 
            pushFollow(FOLLOW_ruleSequenceNumber_in_entryRuleSequenceNumber781);
            ruleSequenceNumber();

            state._fsp--;

             after(grammarAccess.getSequenceNumberRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSequenceNumber788); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleSequenceNumber"


    // $ANTLR start "ruleSequenceNumber"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:405:1: ruleSequenceNumber : ( ( rule__SequenceNumber__NextNumberAssignment ) ) ;
    public final void ruleSequenceNumber() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:409:2: ( ( ( rule__SequenceNumber__NextNumberAssignment ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:410:1: ( ( rule__SequenceNumber__NextNumberAssignment ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:410:1: ( ( rule__SequenceNumber__NextNumberAssignment ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:411:1: ( rule__SequenceNumber__NextNumberAssignment )
            {
             before(grammarAccess.getSequenceNumberAccess().getNextNumberAssignment()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:412:1: ( rule__SequenceNumber__NextNumberAssignment )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:412:2: rule__SequenceNumber__NextNumberAssignment
            {
            pushFollow(FOLLOW_rule__SequenceNumber__NextNumberAssignment_in_ruleSequenceNumber814);
            rule__SequenceNumber__NextNumberAssignment();

            state._fsp--;


            }

             after(grammarAccess.getSequenceNumberAccess().getNextNumberAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleSequenceNumber"


    // $ANTLR start "entryRuleChoosenConstraintSemantic"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:424:1: entryRuleChoosenConstraintSemantic : ruleChoosenConstraintSemantic EOF ;
    public final void entryRuleChoosenConstraintSemantic() throws RecognitionException {
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:425:1: ( ruleChoosenConstraintSemantic EOF )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:426:1: ruleChoosenConstraintSemantic EOF
            {
             before(grammarAccess.getChoosenConstraintSemanticRule()); 
            pushFollow(FOLLOW_ruleChoosenConstraintSemantic_in_entryRuleChoosenConstraintSemantic841);
            ruleChoosenConstraintSemantic();

            state._fsp--;

             after(grammarAccess.getChoosenConstraintSemanticRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleChoosenConstraintSemantic848); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleChoosenConstraintSemantic"


    // $ANTLR start "ruleChoosenConstraintSemantic"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:433:1: ruleChoosenConstraintSemantic : ( ( rule__ChoosenConstraintSemantic__IdAssignment ) ) ;
    public final void ruleChoosenConstraintSemantic() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:437:2: ( ( ( rule__ChoosenConstraintSemantic__IdAssignment ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:438:1: ( ( rule__ChoosenConstraintSemantic__IdAssignment ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:438:1: ( ( rule__ChoosenConstraintSemantic__IdAssignment ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:439:1: ( rule__ChoosenConstraintSemantic__IdAssignment )
            {
             before(grammarAccess.getChoosenConstraintSemanticAccess().getIdAssignment()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:440:1: ( rule__ChoosenConstraintSemantic__IdAssignment )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:440:2: rule__ChoosenConstraintSemantic__IdAssignment
            {
            pushFollow(FOLLOW_rule__ChoosenConstraintSemantic__IdAssignment_in_ruleChoosenConstraintSemantic874);
            rule__ChoosenConstraintSemantic__IdAssignment();

            state._fsp--;


            }

             after(grammarAccess.getChoosenConstraintSemanticAccess().getIdAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleChoosenConstraintSemantic"


    // $ANTLR start "entryRuleConstraint"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:452:1: entryRuleConstraint : ruleConstraint EOF ;
    public final void entryRuleConstraint() throws RecognitionException {
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:453:1: ( ruleConstraint EOF )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:454:1: ruleConstraint EOF
            {
             before(grammarAccess.getConstraintRule()); 
            pushFollow(FOLLOW_ruleConstraint_in_entryRuleConstraint901);
            ruleConstraint();

            state._fsp--;

             after(grammarAccess.getConstraintRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleConstraint908); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleConstraint"


    // $ANTLR start "ruleConstraint"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:461:1: ruleConstraint : ( ( rule__Constraint__Group__0 ) ) ;
    public final void ruleConstraint() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:465:2: ( ( ( rule__Constraint__Group__0 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:466:1: ( ( rule__Constraint__Group__0 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:466:1: ( ( rule__Constraint__Group__0 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:467:1: ( rule__Constraint__Group__0 )
            {
             before(grammarAccess.getConstraintAccess().getGroup()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:468:1: ( rule__Constraint__Group__0 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:468:2: rule__Constraint__Group__0
            {
            pushFollow(FOLLOW_rule__Constraint__Group__0_in_ruleConstraint934);
            rule__Constraint__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getConstraintAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleConstraint"


    // $ANTLR start "entryRuleConstraintSignature"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:480:1: entryRuleConstraintSignature : ruleConstraintSignature EOF ;
    public final void entryRuleConstraintSignature() throws RecognitionException {
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:481:1: ( ruleConstraintSignature EOF )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:482:1: ruleConstraintSignature EOF
            {
             before(grammarAccess.getConstraintSignatureRule()); 
            pushFollow(FOLLOW_ruleConstraintSignature_in_entryRuleConstraintSignature961);
            ruleConstraintSignature();

            state._fsp--;

             after(grammarAccess.getConstraintSignatureRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleConstraintSignature968); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleConstraintSignature"


    // $ANTLR start "ruleConstraintSignature"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:489:1: ruleConstraintSignature : ( ( rule__ConstraintSignature__Group__0 ) ) ;
    public final void ruleConstraintSignature() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:493:2: ( ( ( rule__ConstraintSignature__Group__0 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:494:1: ( ( rule__ConstraintSignature__Group__0 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:494:1: ( ( rule__ConstraintSignature__Group__0 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:495:1: ( rule__ConstraintSignature__Group__0 )
            {
             before(grammarAccess.getConstraintSignatureAccess().getGroup()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:496:1: ( rule__ConstraintSignature__Group__0 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:496:2: rule__ConstraintSignature__Group__0
            {
            pushFollow(FOLLOW_rule__ConstraintSignature__Group__0_in_ruleConstraintSignature994);
            rule__ConstraintSignature__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getConstraintSignatureAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleConstraintSignature"


    // $ANTLR start "entryRuleSignature"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:508:1: entryRuleSignature : ruleSignature EOF ;
    public final void entryRuleSignature() throws RecognitionException {
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:509:1: ( ruleSignature EOF )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:510:1: ruleSignature EOF
            {
             before(grammarAccess.getSignatureRule()); 
            pushFollow(FOLLOW_ruleSignature_in_entryRuleSignature1021);
            ruleSignature();

            state._fsp--;

             after(grammarAccess.getSignatureRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSignature1028); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleSignature"


    // $ANTLR start "ruleSignature"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:517:1: ruleSignature : ( ( rule__Signature__Group__0 ) ) ;
    public final void ruleSignature() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:521:2: ( ( ( rule__Signature__Group__0 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:522:1: ( ( rule__Signature__Group__0 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:522:1: ( ( rule__Signature__Group__0 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:523:1: ( rule__Signature__Group__0 )
            {
             before(grammarAccess.getSignatureAccess().getGroup()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:524:1: ( rule__Signature__Group__0 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:524:2: rule__Signature__Group__0
            {
            pushFollow(FOLLOW_rule__Signature__Group__0_in_ruleSignature1054);
            rule__Signature__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getSignatureAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleSignature"


    // $ANTLR start "entryRuleConstraintSemantic"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:536:1: entryRuleConstraintSemantic : ruleConstraintSemantic EOF ;
    public final void entryRuleConstraintSemantic() throws RecognitionException {
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:537:1: ( ruleConstraintSemantic EOF )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:538:1: ruleConstraintSemantic EOF
            {
             before(grammarAccess.getConstraintSemanticRule()); 
            pushFollow(FOLLOW_ruleConstraintSemantic_in_entryRuleConstraintSemantic1081);
            ruleConstraintSemantic();

            state._fsp--;

             after(grammarAccess.getConstraintSemanticRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleConstraintSemantic1088); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleConstraintSemantic"


    // $ANTLR start "ruleConstraintSemantic"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:545:1: ruleConstraintSemantic : ( ( rule__ConstraintSemantic__Group__0 ) ) ;
    public final void ruleConstraintSemantic() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:549:2: ( ( ( rule__ConstraintSemantic__Group__0 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:550:1: ( ( rule__ConstraintSemantic__Group__0 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:550:1: ( ( rule__ConstraintSemantic__Group__0 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:551:1: ( rule__ConstraintSemantic__Group__0 )
            {
             before(grammarAccess.getConstraintSemanticAccess().getGroup()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:552:1: ( rule__ConstraintSemantic__Group__0 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:552:2: rule__ConstraintSemantic__Group__0
            {
            pushFollow(FOLLOW_rule__ConstraintSemantic__Group__0_in_ruleConstraintSemantic1114);
            rule__ConstraintSemantic__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getConstraintSemanticAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleConstraintSemantic"


    // $ANTLR start "entryRuleMorphism"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:564:1: entryRuleMorphism : ruleMorphism EOF ;
    public final void entryRuleMorphism() throws RecognitionException {
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:565:1: ( ruleMorphism EOF )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:566:1: ruleMorphism EOF
            {
             before(grammarAccess.getMorphismRule()); 
            pushFollow(FOLLOW_ruleMorphism_in_entryRuleMorphism1141);
            ruleMorphism();

            state._fsp--;

             after(grammarAccess.getMorphismRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMorphism1148); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleMorphism"


    // $ANTLR start "ruleMorphism"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:573:1: ruleMorphism : ( ( rule__Morphism__Group__0 ) ) ;
    public final void ruleMorphism() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:577:2: ( ( ( rule__Morphism__Group__0 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:578:1: ( ( rule__Morphism__Group__0 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:578:1: ( ( rule__Morphism__Group__0 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:579:1: ( rule__Morphism__Group__0 )
            {
             before(grammarAccess.getMorphismAccess().getGroup()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:580:1: ( rule__Morphism__Group__0 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:580:2: rule__Morphism__Group__0
            {
            pushFollow(FOLLOW_rule__Morphism__Group__0_in_ruleMorphism1174);
            rule__Morphism__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getMorphismAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleMorphism"


    // $ANTLR start "entryRuleDomain"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:592:1: entryRuleDomain : ruleDomain EOF ;
    public final void entryRuleDomain() throws RecognitionException {
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:593:1: ( ruleDomain EOF )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:594:1: ruleDomain EOF
            {
             before(grammarAccess.getDomainRule()); 
            pushFollow(FOLLOW_ruleDomain_in_entryRuleDomain1201);
            ruleDomain();

            state._fsp--;

             after(grammarAccess.getDomainRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDomain1208); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleDomain"


    // $ANTLR start "ruleDomain"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:601:1: ruleDomain : ( ( rule__Domain__IdAssignment ) ) ;
    public final void ruleDomain() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:605:2: ( ( ( rule__Domain__IdAssignment ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:606:1: ( ( rule__Domain__IdAssignment ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:606:1: ( ( rule__Domain__IdAssignment ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:607:1: ( rule__Domain__IdAssignment )
            {
             before(grammarAccess.getDomainAccess().getIdAssignment()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:608:1: ( rule__Domain__IdAssignment )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:608:2: rule__Domain__IdAssignment
            {
            pushFollow(FOLLOW_rule__Domain__IdAssignment_in_ruleDomain1234);
            rule__Domain__IdAssignment();

            state._fsp--;


            }

             after(grammarAccess.getDomainAccess().getIdAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleDomain"


    // $ANTLR start "entryRuleCodomain"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:620:1: entryRuleCodomain : ruleCodomain EOF ;
    public final void entryRuleCodomain() throws RecognitionException {
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:621:1: ( ruleCodomain EOF )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:622:1: ruleCodomain EOF
            {
             before(grammarAccess.getCodomainRule()); 
            pushFollow(FOLLOW_ruleCodomain_in_entryRuleCodomain1261);
            ruleCodomain();

            state._fsp--;

             after(grammarAccess.getCodomainRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCodomain1268); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleCodomain"


    // $ANTLR start "ruleCodomain"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:629:1: ruleCodomain : ( ( rule__Codomain__IdAssignment ) ) ;
    public final void ruleCodomain() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:633:2: ( ( ( rule__Codomain__IdAssignment ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:634:1: ( ( rule__Codomain__IdAssignment ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:634:1: ( ( rule__Codomain__IdAssignment ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:635:1: ( rule__Codomain__IdAssignment )
            {
             before(grammarAccess.getCodomainAccess().getIdAssignment()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:636:1: ( rule__Codomain__IdAssignment )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:636:2: rule__Codomain__IdAssignment
            {
            pushFollow(FOLLOW_rule__Codomain__IdAssignment_in_ruleCodomain1294);
            rule__Codomain__IdAssignment();

            state._fsp--;


            }

             after(grammarAccess.getCodomainAccess().getIdAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleCodomain"


    // $ANTLR start "entryRuleMapping"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:648:1: entryRuleMapping : ruleMapping EOF ;
    public final void entryRuleMapping() throws RecognitionException {
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:649:1: ( ruleMapping EOF )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:650:1: ruleMapping EOF
            {
             before(grammarAccess.getMappingRule()); 
            pushFollow(FOLLOW_ruleMapping_in_entryRuleMapping1321);
            ruleMapping();

            state._fsp--;

             after(grammarAccess.getMappingRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMapping1328); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleMapping"


    // $ANTLR start "ruleMapping"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:657:1: ruleMapping : ( ( rule__Mapping__Alternatives ) ) ;
    public final void ruleMapping() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:661:2: ( ( ( rule__Mapping__Alternatives ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:662:1: ( ( rule__Mapping__Alternatives ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:662:1: ( ( rule__Mapping__Alternatives ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:663:1: ( rule__Mapping__Alternatives )
            {
             before(grammarAccess.getMappingAccess().getAlternatives()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:664:1: ( rule__Mapping__Alternatives )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:664:2: rule__Mapping__Alternatives
            {
            pushFollow(FOLLOW_rule__Mapping__Alternatives_in_ruleMapping1354);
            rule__Mapping__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getMappingAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleMapping"


    // $ANTLR start "entryRuleMappingNode"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:676:1: entryRuleMappingNode : ruleMappingNode EOF ;
    public final void entryRuleMappingNode() throws RecognitionException {
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:677:1: ( ruleMappingNode EOF )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:678:1: ruleMappingNode EOF
            {
             before(grammarAccess.getMappingNodeRule()); 
            pushFollow(FOLLOW_ruleMappingNode_in_entryRuleMappingNode1381);
            ruleMappingNode();

            state._fsp--;

             after(grammarAccess.getMappingNodeRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMappingNode1388); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleMappingNode"


    // $ANTLR start "ruleMappingNode"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:685:1: ruleMappingNode : ( ( rule__MappingNode__Group__0 ) ) ;
    public final void ruleMappingNode() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:689:2: ( ( ( rule__MappingNode__Group__0 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:690:1: ( ( rule__MappingNode__Group__0 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:690:1: ( ( rule__MappingNode__Group__0 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:691:1: ( rule__MappingNode__Group__0 )
            {
             before(grammarAccess.getMappingNodeAccess().getGroup()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:692:1: ( rule__MappingNode__Group__0 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:692:2: rule__MappingNode__Group__0
            {
            pushFollow(FOLLOW_rule__MappingNode__Group__0_in_ruleMappingNode1414);
            rule__MappingNode__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getMappingNodeAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleMappingNode"


    // $ANTLR start "entryRuleMappingArrow"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:704:1: entryRuleMappingArrow : ruleMappingArrow EOF ;
    public final void entryRuleMappingArrow() throws RecognitionException {
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:705:1: ( ruleMappingArrow EOF )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:706:1: ruleMappingArrow EOF
            {
             before(grammarAccess.getMappingArrowRule()); 
            pushFollow(FOLLOW_ruleMappingArrow_in_entryRuleMappingArrow1441);
            ruleMappingArrow();

            state._fsp--;

             after(grammarAccess.getMappingArrowRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMappingArrow1448); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleMappingArrow"


    // $ANTLR start "ruleMappingArrow"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:713:1: ruleMappingArrow : ( ( rule__MappingArrow__Group__0 ) ) ;
    public final void ruleMappingArrow() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:717:2: ( ( ( rule__MappingArrow__Group__0 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:718:1: ( ( rule__MappingArrow__Group__0 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:718:1: ( ( rule__MappingArrow__Group__0 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:719:1: ( rule__MappingArrow__Group__0 )
            {
             before(grammarAccess.getMappingArrowAccess().getGroup()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:720:1: ( rule__MappingArrow__Group__0 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:720:2: rule__MappingArrow__Group__0
            {
            pushFollow(FOLLOW_rule__MappingArrow__Group__0_in_ruleMappingArrow1474);
            rule__MappingArrow__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getMappingArrowAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleMappingArrow"


    // $ANTLR start "entryRuleExtSubTGraph"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:732:1: entryRuleExtSubTGraph : ruleExtSubTGraph EOF ;
    public final void entryRuleExtSubTGraph() throws RecognitionException {
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:733:1: ( ruleExtSubTGraph EOF )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:734:1: ruleExtSubTGraph EOF
            {
             before(grammarAccess.getExtSubTGraphRule()); 
            pushFollow(FOLLOW_ruleExtSubTGraph_in_entryRuleExtSubTGraph1501);
            ruleExtSubTGraph();

            state._fsp--;

             after(grammarAccess.getExtSubTGraphRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleExtSubTGraph1508); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleExtSubTGraph"


    // $ANTLR start "ruleExtSubTGraph"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:741:1: ruleExtSubTGraph : ( ( rule__ExtSubTGraph__Group__0 ) ) ;
    public final void ruleExtSubTGraph() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:745:2: ( ( ( rule__ExtSubTGraph__Group__0 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:746:1: ( ( rule__ExtSubTGraph__Group__0 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:746:1: ( ( rule__ExtSubTGraph__Group__0 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:747:1: ( rule__ExtSubTGraph__Group__0 )
            {
             before(grammarAccess.getExtSubTGraphAccess().getGroup()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:748:1: ( rule__ExtSubTGraph__Group__0 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:748:2: rule__ExtSubTGraph__Group__0
            {
            pushFollow(FOLLOW_rule__ExtSubTGraph__Group__0_in_ruleExtSubTGraph1534);
            rule__ExtSubTGraph__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getExtSubTGraphAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleExtSubTGraph"


    // $ANTLR start "entryRuleChoosenExtSubTGraph"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:760:1: entryRuleChoosenExtSubTGraph : ruleChoosenExtSubTGraph EOF ;
    public final void entryRuleChoosenExtSubTGraph() throws RecognitionException {
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:761:1: ( ruleChoosenExtSubTGraph EOF )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:762:1: ruleChoosenExtSubTGraph EOF
            {
             before(grammarAccess.getChoosenExtSubTGraphRule()); 
            pushFollow(FOLLOW_ruleChoosenExtSubTGraph_in_entryRuleChoosenExtSubTGraph1561);
            ruleChoosenExtSubTGraph();

            state._fsp--;

             after(grammarAccess.getChoosenExtSubTGraphRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleChoosenExtSubTGraph1568); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleChoosenExtSubTGraph"


    // $ANTLR start "ruleChoosenExtSubTGraph"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:769:1: ruleChoosenExtSubTGraph : ( ( rule__ChoosenExtSubTGraph__IdAssignment ) ) ;
    public final void ruleChoosenExtSubTGraph() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:773:2: ( ( ( rule__ChoosenExtSubTGraph__IdAssignment ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:774:1: ( ( rule__ChoosenExtSubTGraph__IdAssignment ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:774:1: ( ( rule__ChoosenExtSubTGraph__IdAssignment ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:775:1: ( rule__ChoosenExtSubTGraph__IdAssignment )
            {
             before(grammarAccess.getChoosenExtSubTGraphAccess().getIdAssignment()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:776:1: ( rule__ChoosenExtSubTGraph__IdAssignment )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:776:2: rule__ChoosenExtSubTGraph__IdAssignment
            {
            pushFollow(FOLLOW_rule__ChoosenExtSubTGraph__IdAssignment_in_ruleChoosenExtSubTGraph1594);
            rule__ChoosenExtSubTGraph__IdAssignment();

            state._fsp--;


            }

             after(grammarAccess.getChoosenExtSubTGraphAccess().getIdAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleChoosenExtSubTGraph"


    // $ANTLR start "entryRuleGraph"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:788:1: entryRuleGraph : ruleGraph EOF ;
    public final void entryRuleGraph() throws RecognitionException {
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:789:1: ( ruleGraph EOF )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:790:1: ruleGraph EOF
            {
             before(grammarAccess.getGraphRule()); 
            pushFollow(FOLLOW_ruleGraph_in_entryRuleGraph1621);
            ruleGraph();

            state._fsp--;

             after(grammarAccess.getGraphRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleGraph1628); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleGraph"


    // $ANTLR start "ruleGraph"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:797:1: ruleGraph : ( ( rule__Graph__Group__0 ) ) ;
    public final void ruleGraph() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:801:2: ( ( ( rule__Graph__Group__0 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:802:1: ( ( rule__Graph__Group__0 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:802:1: ( ( rule__Graph__Group__0 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:803:1: ( rule__Graph__Group__0 )
            {
             before(grammarAccess.getGraphAccess().getGroup()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:804:1: ( rule__Graph__Group__0 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:804:2: rule__Graph__Group__0
            {
            pushFollow(FOLLOW_rule__Graph__Group__0_in_ruleGraph1654);
            rule__Graph__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getGraphAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleGraph"


    // $ANTLR start "entryRuleElement"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:816:1: entryRuleElement : ruleElement EOF ;
    public final void entryRuleElement() throws RecognitionException {
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:817:1: ( ruleElement EOF )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:818:1: ruleElement EOF
            {
             before(grammarAccess.getElementRule()); 
            pushFollow(FOLLOW_ruleElement_in_entryRuleElement1681);
            ruleElement();

            state._fsp--;

             after(grammarAccess.getElementRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleElement1688); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleElement"


    // $ANTLR start "ruleElement"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:825:1: ruleElement : ( ( rule__Element__Alternatives ) ) ;
    public final void ruleElement() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:829:2: ( ( ( rule__Element__Alternatives ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:830:1: ( ( rule__Element__Alternatives ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:830:1: ( ( rule__Element__Alternatives ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:831:1: ( rule__Element__Alternatives )
            {
             before(grammarAccess.getElementAccess().getAlternatives()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:832:1: ( rule__Element__Alternatives )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:832:2: rule__Element__Alternatives
            {
            pushFollow(FOLLOW_rule__Element__Alternatives_in_ruleElement1714);
            rule__Element__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getElementAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleElement"


    // $ANTLR start "entryRuleArrows"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:844:1: entryRuleArrows : ruleArrows EOF ;
    public final void entryRuleArrows() throws RecognitionException {
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:845:1: ( ruleArrows EOF )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:846:1: ruleArrows EOF
            {
             before(grammarAccess.getArrowsRule()); 
            pushFollow(FOLLOW_ruleArrows_in_entryRuleArrows1741);
            ruleArrows();

            state._fsp--;

             after(grammarAccess.getArrowsRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleArrows1748); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleArrows"


    // $ANTLR start "ruleArrows"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:853:1: ruleArrows : ( ( rule__Arrows__Alternatives ) ) ;
    public final void ruleArrows() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:857:2: ( ( ( rule__Arrows__Alternatives ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:858:1: ( ( rule__Arrows__Alternatives ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:858:1: ( ( rule__Arrows__Alternatives ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:859:1: ( rule__Arrows__Alternatives )
            {
             before(grammarAccess.getArrowsAccess().getAlternatives()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:860:1: ( rule__Arrows__Alternatives )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:860:2: rule__Arrows__Alternatives
            {
            pushFollow(FOLLOW_rule__Arrows__Alternatives_in_ruleArrows1774);
            rule__Arrows__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getArrowsAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleArrows"


    // $ANTLR start "entryRuleArrow"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:872:1: entryRuleArrow : ruleArrow EOF ;
    public final void entryRuleArrow() throws RecognitionException {
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:873:1: ( ruleArrow EOF )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:874:1: ruleArrow EOF
            {
             before(grammarAccess.getArrowRule()); 
            pushFollow(FOLLOW_ruleArrow_in_entryRuleArrow1801);
            ruleArrow();

            state._fsp--;

             after(grammarAccess.getArrowRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleArrow1808); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleArrow"


    // $ANTLR start "ruleArrow"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:881:1: ruleArrow : ( ( rule__Arrow__Alternatives ) ) ;
    public final void ruleArrow() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:885:2: ( ( ( rule__Arrow__Alternatives ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:886:1: ( ( rule__Arrow__Alternatives ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:886:1: ( ( rule__Arrow__Alternatives ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:887:1: ( rule__Arrow__Alternatives )
            {
             before(grammarAccess.getArrowAccess().getAlternatives()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:888:1: ( rule__Arrow__Alternatives )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:888:2: rule__Arrow__Alternatives
            {
            pushFollow(FOLLOW_rule__Arrow__Alternatives_in_ruleArrow1834);
            rule__Arrow__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getArrowAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleArrow"


    // $ANTLR start "entryRuleNode"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:900:1: entryRuleNode : ruleNode EOF ;
    public final void entryRuleNode() throws RecognitionException {
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:901:1: ( ruleNode EOF )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:902:1: ruleNode EOF
            {
             before(grammarAccess.getNodeRule()); 
            pushFollow(FOLLOW_ruleNode_in_entryRuleNode1861);
            ruleNode();

            state._fsp--;

             after(grammarAccess.getNodeRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNode1868); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleNode"


    // $ANTLR start "ruleNode"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:909:1: ruleNode : ( ( rule__Node__Group__0 ) ) ;
    public final void ruleNode() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:913:2: ( ( ( rule__Node__Group__0 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:914:1: ( ( rule__Node__Group__0 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:914:1: ( ( rule__Node__Group__0 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:915:1: ( rule__Node__Group__0 )
            {
             before(grammarAccess.getNodeAccess().getGroup()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:916:1: ( rule__Node__Group__0 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:916:2: rule__Node__Group__0
            {
            pushFollow(FOLLOW_rule__Node__Group__0_in_ruleNode1894);
            rule__Node__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getNodeAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleNode"


    // $ANTLR start "entryRuleAttributeValue"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:928:1: entryRuleAttributeValue : ruleAttributeValue EOF ;
    public final void entryRuleAttributeValue() throws RecognitionException {
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:929:1: ( ruleAttributeValue EOF )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:930:1: ruleAttributeValue EOF
            {
             before(grammarAccess.getAttributeValueRule()); 
            pushFollow(FOLLOW_ruleAttributeValue_in_entryRuleAttributeValue1921);
            ruleAttributeValue();

            state._fsp--;

             after(grammarAccess.getAttributeValueRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAttributeValue1928); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleAttributeValue"


    // $ANTLR start "ruleAttributeValue"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:937:1: ruleAttributeValue : ( ( rule__AttributeValue__Group__0 ) ) ;
    public final void ruleAttributeValue() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:941:2: ( ( ( rule__AttributeValue__Group__0 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:942:1: ( ( rule__AttributeValue__Group__0 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:942:1: ( ( rule__AttributeValue__Group__0 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:943:1: ( rule__AttributeValue__Group__0 )
            {
             before(grammarAccess.getAttributeValueAccess().getGroup()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:944:1: ( rule__AttributeValue__Group__0 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:944:2: rule__AttributeValue__Group__0
            {
            pushFollow(FOLLOW_rule__AttributeValue__Group__0_in_ruleAttributeValue1954);
            rule__AttributeValue__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getAttributeValueAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAttributeValue"


    // $ANTLR start "entryRuleDpfId"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:956:1: entryRuleDpfId : ruleDpfId EOF ;
    public final void entryRuleDpfId() throws RecognitionException {
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:957:1: ( ruleDpfId EOF )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:958:1: ruleDpfId EOF
            {
             before(grammarAccess.getDpfIdRule()); 
            pushFollow(FOLLOW_ruleDpfId_in_entryRuleDpfId1981);
            ruleDpfId();

            state._fsp--;

             after(grammarAccess.getDpfIdRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDpfId1988); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleDpfId"


    // $ANTLR start "ruleDpfId"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:965:1: ruleDpfId : ( ( rule__DpfId__Group__0 ) ) ;
    public final void ruleDpfId() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:969:2: ( ( ( rule__DpfId__Group__0 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:970:1: ( ( rule__DpfId__Group__0 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:970:1: ( ( rule__DpfId__Group__0 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:971:1: ( rule__DpfId__Group__0 )
            {
             before(grammarAccess.getDpfIdAccess().getGroup()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:972:1: ( rule__DpfId__Group__0 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:972:2: rule__DpfId__Group__0
            {
            pushFollow(FOLLOW_rule__DpfId__Group__0_in_ruleDpfId2014);
            rule__DpfId__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getDpfIdAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleDpfId"


    // $ANTLR start "ruleDataType"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:985:1: ruleDataType : ( ( rule__DataType__Alternatives ) ) ;
    public final void ruleDataType() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:989:1: ( ( ( rule__DataType__Alternatives ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:990:1: ( ( rule__DataType__Alternatives ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:990:1: ( ( rule__DataType__Alternatives ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:991:1: ( rule__DataType__Alternatives )
            {
             before(grammarAccess.getDataTypeAccess().getAlternatives()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:992:1: ( rule__DataType__Alternatives )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:992:2: rule__DataType__Alternatives
            {
            pushFollow(FOLLOW_rule__DataType__Alternatives_in_ruleDataType2051);
            rule__DataType__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getDataTypeAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleDataType"


    // $ANTLR start "rule__Model__Alternatives"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1003:1: rule__Model__Alternatives : ( ( ruleSpecification ) | ( ruleSignature ) | ( ( rule__Model__Group_2__0 )? ) );
    public final void rule__Model__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1007:1: ( ( ruleSpecification ) | ( ruleSignature ) | ( ( rule__Model__Group_2__0 )? ) )
            int alt2=3;
            switch ( input.LA(1) ) {
            case 33:
                {
                alt2=1;
                }
                break;
            case RULE_ID:
                {
                int LA2_2 = input.LA(2);

                if ( (LA2_2==37||LA2_2==51) ) {
                    alt2=2;
                }
                else if ( (LA2_2==42) ) {
                    alt2=3;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 2, 2, input);

                    throw nvae;
                }
                }
                break;
            case EOF:
            case 22:
            case 24:
            case 25:
            case 26:
            case 30:
                {
                alt2=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1008:1: ( ruleSpecification )
                    {
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1008:1: ( ruleSpecification )
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1009:1: ruleSpecification
                    {
                     before(grammarAccess.getModelAccess().getSpecificationParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleSpecification_in_rule__Model__Alternatives2086);
                    ruleSpecification();

                    state._fsp--;

                     after(grammarAccess.getModelAccess().getSpecificationParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1014:6: ( ruleSignature )
                    {
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1014:6: ( ruleSignature )
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1015:1: ruleSignature
                    {
                     before(grammarAccess.getModelAccess().getSignatureParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleSignature_in_rule__Model__Alternatives2103);
                    ruleSignature();

                    state._fsp--;

                     after(grammarAccess.getModelAccess().getSignatureParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1020:6: ( ( rule__Model__Group_2__0 )? )
                    {
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1020:6: ( ( rule__Model__Group_2__0 )? )
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1021:1: ( rule__Model__Group_2__0 )?
                    {
                     before(grammarAccess.getModelAccess().getGroup_2()); 
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1022:1: ( rule__Model__Group_2__0 )?
                    int alt1=2;
                    int LA1_0 = input.LA(1);

                    if ( (LA1_0==RULE_ID||LA1_0==22||(LA1_0>=24 && LA1_0<=26)||LA1_0==30) ) {
                        alt1=1;
                    }
                    switch (alt1) {
                        case 1 :
                            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1022:2: rule__Model__Group_2__0
                            {
                            pushFollow(FOLLOW_rule__Model__Group_2__0_in_rule__Model__Alternatives2120);
                            rule__Model__Group_2__0();

                            state._fsp--;


                            }
                            break;

                    }

                     after(grammarAccess.getModelAccess().getGroup_2()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Alternatives"


    // $ANTLR start "rule__VALUE__Alternatives"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1031:1: rule__VALUE__Alternatives : ( ( RULE_NUMBER ) | ( RULE_CHAR ) | ( RULE_STRING ) );
    public final void rule__VALUE__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1035:1: ( ( RULE_NUMBER ) | ( RULE_CHAR ) | ( RULE_STRING ) )
            int alt3=3;
            switch ( input.LA(1) ) {
            case RULE_NUMBER:
                {
                alt3=1;
                }
                break;
            case RULE_CHAR:
                {
                alt3=2;
                }
                break;
            case RULE_STRING:
                {
                alt3=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1036:1: ( RULE_NUMBER )
                    {
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1036:1: ( RULE_NUMBER )
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1037:1: RULE_NUMBER
                    {
                     before(grammarAccess.getVALUEAccess().getNUMBERTerminalRuleCall_0()); 
                    match(input,RULE_NUMBER,FOLLOW_RULE_NUMBER_in_rule__VALUE__Alternatives2154); 
                     after(grammarAccess.getVALUEAccess().getNUMBERTerminalRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1042:6: ( RULE_CHAR )
                    {
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1042:6: ( RULE_CHAR )
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1043:1: RULE_CHAR
                    {
                     before(grammarAccess.getVALUEAccess().getCHARTerminalRuleCall_1()); 
                    match(input,RULE_CHAR,FOLLOW_RULE_CHAR_in_rule__VALUE__Alternatives2171); 
                     after(grammarAccess.getVALUEAccess().getCHARTerminalRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1048:6: ( RULE_STRING )
                    {
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1048:6: ( RULE_STRING )
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1049:1: RULE_STRING
                    {
                     before(grammarAccess.getVALUEAccess().getSTRINGTerminalRuleCall_2()); 
                    match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__VALUE__Alternatives2188); 
                     after(grammarAccess.getVALUEAccess().getSTRINGTerminalRuleCall_2()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VALUE__Alternatives"


    // $ANTLR start "rule__Command__Alternatives"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1059:1: rule__Command__Alternatives : ( ( ruleMakeEmf ) | ( ruleMakeEcore ) | ( ruleMakeImage ) | ( ruleExtSubTGraph ) | ( ruleSimpleEvoSpan ) | ( ruleSimpleEvoCospan ) | ( ruleMorphism ) | ( ruleEvoSpan ) | ( ruleEvoCospan ) );
    public final void rule__Command__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1063:1: ( ( ruleMakeEmf ) | ( ruleMakeEcore ) | ( ruleMakeImage ) | ( ruleExtSubTGraph ) | ( ruleSimpleEvoSpan ) | ( ruleSimpleEvoCospan ) | ( ruleMorphism ) | ( ruleEvoSpan ) | ( ruleEvoCospan ) )
            int alt4=9;
            alt4 = dfa4.predict(input);
            switch (alt4) {
                case 1 :
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1064:1: ( ruleMakeEmf )
                    {
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1064:1: ( ruleMakeEmf )
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1065:1: ruleMakeEmf
                    {
                     before(grammarAccess.getCommandAccess().getMakeEmfParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleMakeEmf_in_rule__Command__Alternatives2220);
                    ruleMakeEmf();

                    state._fsp--;

                     after(grammarAccess.getCommandAccess().getMakeEmfParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1070:6: ( ruleMakeEcore )
                    {
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1070:6: ( ruleMakeEcore )
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1071:1: ruleMakeEcore
                    {
                     before(grammarAccess.getCommandAccess().getMakeEcoreParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleMakeEcore_in_rule__Command__Alternatives2237);
                    ruleMakeEcore();

                    state._fsp--;

                     after(grammarAccess.getCommandAccess().getMakeEcoreParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1076:6: ( ruleMakeImage )
                    {
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1076:6: ( ruleMakeImage )
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1077:1: ruleMakeImage
                    {
                     before(grammarAccess.getCommandAccess().getMakeImageParserRuleCall_2()); 
                    pushFollow(FOLLOW_ruleMakeImage_in_rule__Command__Alternatives2254);
                    ruleMakeImage();

                    state._fsp--;

                     after(grammarAccess.getCommandAccess().getMakeImageParserRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1082:6: ( ruleExtSubTGraph )
                    {
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1082:6: ( ruleExtSubTGraph )
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1083:1: ruleExtSubTGraph
                    {
                     before(grammarAccess.getCommandAccess().getExtSubTGraphParserRuleCall_3()); 
                    pushFollow(FOLLOW_ruleExtSubTGraph_in_rule__Command__Alternatives2271);
                    ruleExtSubTGraph();

                    state._fsp--;

                     after(grammarAccess.getCommandAccess().getExtSubTGraphParserRuleCall_3()); 

                    }


                    }
                    break;
                case 5 :
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1088:6: ( ruleSimpleEvoSpan )
                    {
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1088:6: ( ruleSimpleEvoSpan )
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1089:1: ruleSimpleEvoSpan
                    {
                     before(grammarAccess.getCommandAccess().getSimpleEvoSpanParserRuleCall_4()); 
                    pushFollow(FOLLOW_ruleSimpleEvoSpan_in_rule__Command__Alternatives2288);
                    ruleSimpleEvoSpan();

                    state._fsp--;

                     after(grammarAccess.getCommandAccess().getSimpleEvoSpanParserRuleCall_4()); 

                    }


                    }
                    break;
                case 6 :
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1094:6: ( ruleSimpleEvoCospan )
                    {
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1094:6: ( ruleSimpleEvoCospan )
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1095:1: ruleSimpleEvoCospan
                    {
                     before(grammarAccess.getCommandAccess().getSimpleEvoCospanParserRuleCall_5()); 
                    pushFollow(FOLLOW_ruleSimpleEvoCospan_in_rule__Command__Alternatives2305);
                    ruleSimpleEvoCospan();

                    state._fsp--;

                     after(grammarAccess.getCommandAccess().getSimpleEvoCospanParserRuleCall_5()); 

                    }


                    }
                    break;
                case 7 :
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1100:6: ( ruleMorphism )
                    {
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1100:6: ( ruleMorphism )
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1101:1: ruleMorphism
                    {
                     before(grammarAccess.getCommandAccess().getMorphismParserRuleCall_6()); 
                    pushFollow(FOLLOW_ruleMorphism_in_rule__Command__Alternatives2322);
                    ruleMorphism();

                    state._fsp--;

                     after(grammarAccess.getCommandAccess().getMorphismParserRuleCall_6()); 

                    }


                    }
                    break;
                case 8 :
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1106:6: ( ruleEvoSpan )
                    {
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1106:6: ( ruleEvoSpan )
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1107:1: ruleEvoSpan
                    {
                     before(grammarAccess.getCommandAccess().getEvoSpanParserRuleCall_7()); 
                    pushFollow(FOLLOW_ruleEvoSpan_in_rule__Command__Alternatives2339);
                    ruleEvoSpan();

                    state._fsp--;

                     after(grammarAccess.getCommandAccess().getEvoSpanParserRuleCall_7()); 

                    }


                    }
                    break;
                case 9 :
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1112:6: ( ruleEvoCospan )
                    {
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1112:6: ( ruleEvoCospan )
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1113:1: ruleEvoCospan
                    {
                     before(grammarAccess.getCommandAccess().getEvoCospanParserRuleCall_8()); 
                    pushFollow(FOLLOW_ruleEvoCospan_in_rule__Command__Alternatives2356);
                    ruleEvoCospan();

                    state._fsp--;

                     after(grammarAccess.getCommandAccess().getEvoCospanParserRuleCall_8()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Command__Alternatives"


    // $ANTLR start "rule__Specification__Alternatives_2"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1123:1: rule__Specification__Alternatives_2 : ( ( ( rule__Specification__TypeAssignment_2_0 ) ) | ( ( rule__Specification__Group_2_1__0 ) ) );
    public final void rule__Specification__Alternatives_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1127:1: ( ( ( rule__Specification__TypeAssignment_2_0 ) ) | ( ( rule__Specification__Group_2_1__0 ) ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==RULE_ID) ) {
                alt5=1;
            }
            else if ( (LA5_0==39) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1128:1: ( ( rule__Specification__TypeAssignment_2_0 ) )
                    {
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1128:1: ( ( rule__Specification__TypeAssignment_2_0 ) )
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1129:1: ( rule__Specification__TypeAssignment_2_0 )
                    {
                     before(grammarAccess.getSpecificationAccess().getTypeAssignment_2_0()); 
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1130:1: ( rule__Specification__TypeAssignment_2_0 )
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1130:2: rule__Specification__TypeAssignment_2_0
                    {
                    pushFollow(FOLLOW_rule__Specification__TypeAssignment_2_0_in_rule__Specification__Alternatives_22388);
                    rule__Specification__TypeAssignment_2_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getSpecificationAccess().getTypeAssignment_2_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1134:6: ( ( rule__Specification__Group_2_1__0 ) )
                    {
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1134:6: ( ( rule__Specification__Group_2_1__0 ) )
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1135:1: ( rule__Specification__Group_2_1__0 )
                    {
                     before(grammarAccess.getSpecificationAccess().getGroup_2_1()); 
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1136:1: ( rule__Specification__Group_2_1__0 )
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1136:2: rule__Specification__Group_2_1__0
                    {
                    pushFollow(FOLLOW_rule__Specification__Group_2_1__0_in_rule__Specification__Alternatives_22406);
                    rule__Specification__Group_2_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getSpecificationAccess().getGroup_2_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Specification__Alternatives_2"


    // $ANTLR start "rule__Mapping__Alternatives"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1145:1: rule__Mapping__Alternatives : ( ( ruleMappingNode ) | ( ruleMappingArrow ) );
    public final void rule__Mapping__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1149:1: ( ( ruleMappingNode ) | ( ruleMappingArrow ) )
            int alt6=2;
            alt6 = dfa6.predict(input);
            switch (alt6) {
                case 1 :
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1150:1: ( ruleMappingNode )
                    {
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1150:1: ( ruleMappingNode )
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1151:1: ruleMappingNode
                    {
                     before(grammarAccess.getMappingAccess().getMappingNodeParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleMappingNode_in_rule__Mapping__Alternatives2439);
                    ruleMappingNode();

                    state._fsp--;

                     after(grammarAccess.getMappingAccess().getMappingNodeParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1156:6: ( ruleMappingArrow )
                    {
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1156:6: ( ruleMappingArrow )
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1157:1: ruleMappingArrow
                    {
                     before(grammarAccess.getMappingAccess().getMappingArrowParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleMappingArrow_in_rule__Mapping__Alternatives2456);
                    ruleMappingArrow();

                    state._fsp--;

                     after(grammarAccess.getMappingAccess().getMappingArrowParserRuleCall_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Mapping__Alternatives"


    // $ANTLR start "rule__Element__Alternatives"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1167:1: rule__Element__Alternatives : ( ( ruleNode ) | ( ruleArrows ) );
    public final void rule__Element__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1171:1: ( ( ruleNode ) | ( ruleArrows ) )
            int alt7=2;
            alt7 = dfa7.predict(input);
            switch (alt7) {
                case 1 :
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1172:1: ( ruleNode )
                    {
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1172:1: ( ruleNode )
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1173:1: ruleNode
                    {
                     before(grammarAccess.getElementAccess().getNodeParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleNode_in_rule__Element__Alternatives2488);
                    ruleNode();

                    state._fsp--;

                     after(grammarAccess.getElementAccess().getNodeParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1178:6: ( ruleArrows )
                    {
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1178:6: ( ruleArrows )
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1179:1: ruleArrows
                    {
                     before(grammarAccess.getElementAccess().getArrowsParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleArrows_in_rule__Element__Alternatives2505);
                    ruleArrows();

                    state._fsp--;

                     after(grammarAccess.getElementAccess().getArrowsParserRuleCall_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Element__Alternatives"


    // $ANTLR start "rule__Arrows__Alternatives"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1189:1: rule__Arrows__Alternatives : ( ( ( rule__Arrows__Group_0__0 ) ) | ( ruleArrow ) );
    public final void rule__Arrows__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1193:1: ( ( ( rule__Arrows__Group_0__0 ) ) | ( ruleArrow ) )
            int alt8=2;
            alt8 = dfa8.predict(input);
            switch (alt8) {
                case 1 :
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1194:1: ( ( rule__Arrows__Group_0__0 ) )
                    {
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1194:1: ( ( rule__Arrows__Group_0__0 ) )
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1195:1: ( rule__Arrows__Group_0__0 )
                    {
                     before(grammarAccess.getArrowsAccess().getGroup_0()); 
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1196:1: ( rule__Arrows__Group_0__0 )
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1196:2: rule__Arrows__Group_0__0
                    {
                    pushFollow(FOLLOW_rule__Arrows__Group_0__0_in_rule__Arrows__Alternatives2537);
                    rule__Arrows__Group_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getArrowsAccess().getGroup_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1200:6: ( ruleArrow )
                    {
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1200:6: ( ruleArrow )
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1201:1: ruleArrow
                    {
                     before(grammarAccess.getArrowsAccess().getArrowParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleArrow_in_rule__Arrows__Alternatives2555);
                    ruleArrow();

                    state._fsp--;

                     after(grammarAccess.getArrowsAccess().getArrowParserRuleCall_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Arrows__Alternatives"


    // $ANTLR start "rule__Arrow__Alternatives"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1211:1: rule__Arrow__Alternatives : ( ( ( rule__Arrow__Group_0__0 ) ) | ( ( rule__Arrow__Group_1__0 ) ) | ( ( rule__Arrow__Group_2__0 ) ) );
    public final void rule__Arrow__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1215:1: ( ( ( rule__Arrow__Group_0__0 ) ) | ( ( rule__Arrow__Group_1__0 ) ) | ( ( rule__Arrow__Group_2__0 ) ) )
            int alt9=3;
            alt9 = dfa9.predict(input);
            switch (alt9) {
                case 1 :
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1216:1: ( ( rule__Arrow__Group_0__0 ) )
                    {
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1216:1: ( ( rule__Arrow__Group_0__0 ) )
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1217:1: ( rule__Arrow__Group_0__0 )
                    {
                     before(grammarAccess.getArrowAccess().getGroup_0()); 
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1218:1: ( rule__Arrow__Group_0__0 )
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1218:2: rule__Arrow__Group_0__0
                    {
                    pushFollow(FOLLOW_rule__Arrow__Group_0__0_in_rule__Arrow__Alternatives2587);
                    rule__Arrow__Group_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getArrowAccess().getGroup_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1222:6: ( ( rule__Arrow__Group_1__0 ) )
                    {
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1222:6: ( ( rule__Arrow__Group_1__0 ) )
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1223:1: ( rule__Arrow__Group_1__0 )
                    {
                     before(grammarAccess.getArrowAccess().getGroup_1()); 
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1224:1: ( rule__Arrow__Group_1__0 )
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1224:2: rule__Arrow__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__Arrow__Group_1__0_in_rule__Arrow__Alternatives2605);
                    rule__Arrow__Group_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getArrowAccess().getGroup_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1228:6: ( ( rule__Arrow__Group_2__0 ) )
                    {
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1228:6: ( ( rule__Arrow__Group_2__0 ) )
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1229:1: ( rule__Arrow__Group_2__0 )
                    {
                     before(grammarAccess.getArrowAccess().getGroup_2()); 
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1230:1: ( rule__Arrow__Group_2__0 )
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1230:2: rule__Arrow__Group_2__0
                    {
                    pushFollow(FOLLOW_rule__Arrow__Group_2__0_in_rule__Arrow__Alternatives2623);
                    rule__Arrow__Group_2__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getArrowAccess().getGroup_2()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Arrow__Alternatives"


    // $ANTLR start "rule__DataType__Alternatives"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1239:1: rule__DataType__Alternatives : ( ( ( 'Boolean' ) ) | ( ( 'Char' ) ) | ( ( 'Byte' ) ) | ( ( 'Short' ) ) | ( ( 'Int' ) ) | ( ( 'Long' ) ) | ( ( 'Float' ) ) | ( ( 'Double' ) ) | ( ( 'String' ) ) );
    public final void rule__DataType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1243:1: ( ( ( 'Boolean' ) ) | ( ( 'Char' ) ) | ( ( 'Byte' ) ) | ( ( 'Short' ) ) | ( ( 'Int' ) ) | ( ( 'Long' ) ) | ( ( 'Float' ) ) | ( ( 'Double' ) ) | ( ( 'String' ) ) )
            int alt10=9;
            switch ( input.LA(1) ) {
            case 13:
                {
                alt10=1;
                }
                break;
            case 14:
                {
                alt10=2;
                }
                break;
            case 15:
                {
                alt10=3;
                }
                break;
            case 16:
                {
                alt10=4;
                }
                break;
            case 17:
                {
                alt10=5;
                }
                break;
            case 18:
                {
                alt10=6;
                }
                break;
            case 19:
                {
                alt10=7;
                }
                break;
            case 20:
                {
                alt10=8;
                }
                break;
            case 21:
                {
                alt10=9;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }

            switch (alt10) {
                case 1 :
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1244:1: ( ( 'Boolean' ) )
                    {
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1244:1: ( ( 'Boolean' ) )
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1245:1: ( 'Boolean' )
                    {
                     before(grammarAccess.getDataTypeAccess().getTBOOLEANEnumLiteralDeclaration_0()); 
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1246:1: ( 'Boolean' )
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1246:3: 'Boolean'
                    {
                    match(input,13,FOLLOW_13_in_rule__DataType__Alternatives2657); 

                    }

                     after(grammarAccess.getDataTypeAccess().getTBOOLEANEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1251:6: ( ( 'Char' ) )
                    {
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1251:6: ( ( 'Char' ) )
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1252:1: ( 'Char' )
                    {
                     before(grammarAccess.getDataTypeAccess().getTCHAREnumLiteralDeclaration_1()); 
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1253:1: ( 'Char' )
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1253:3: 'Char'
                    {
                    match(input,14,FOLLOW_14_in_rule__DataType__Alternatives2678); 

                    }

                     after(grammarAccess.getDataTypeAccess().getTCHAREnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1258:6: ( ( 'Byte' ) )
                    {
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1258:6: ( ( 'Byte' ) )
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1259:1: ( 'Byte' )
                    {
                     before(grammarAccess.getDataTypeAccess().getTBYTEEnumLiteralDeclaration_2()); 
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1260:1: ( 'Byte' )
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1260:3: 'Byte'
                    {
                    match(input,15,FOLLOW_15_in_rule__DataType__Alternatives2699); 

                    }

                     after(grammarAccess.getDataTypeAccess().getTBYTEEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1265:6: ( ( 'Short' ) )
                    {
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1265:6: ( ( 'Short' ) )
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1266:1: ( 'Short' )
                    {
                     before(grammarAccess.getDataTypeAccess().getTSHORTEnumLiteralDeclaration_3()); 
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1267:1: ( 'Short' )
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1267:3: 'Short'
                    {
                    match(input,16,FOLLOW_16_in_rule__DataType__Alternatives2720); 

                    }

                     after(grammarAccess.getDataTypeAccess().getTSHORTEnumLiteralDeclaration_3()); 

                    }


                    }
                    break;
                case 5 :
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1272:6: ( ( 'Int' ) )
                    {
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1272:6: ( ( 'Int' ) )
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1273:1: ( 'Int' )
                    {
                     before(grammarAccess.getDataTypeAccess().getTINTEnumLiteralDeclaration_4()); 
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1274:1: ( 'Int' )
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1274:3: 'Int'
                    {
                    match(input,17,FOLLOW_17_in_rule__DataType__Alternatives2741); 

                    }

                     after(grammarAccess.getDataTypeAccess().getTINTEnumLiteralDeclaration_4()); 

                    }


                    }
                    break;
                case 6 :
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1279:6: ( ( 'Long' ) )
                    {
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1279:6: ( ( 'Long' ) )
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1280:1: ( 'Long' )
                    {
                     before(grammarAccess.getDataTypeAccess().getTLONGEnumLiteralDeclaration_5()); 
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1281:1: ( 'Long' )
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1281:3: 'Long'
                    {
                    match(input,18,FOLLOW_18_in_rule__DataType__Alternatives2762); 

                    }

                     after(grammarAccess.getDataTypeAccess().getTLONGEnumLiteralDeclaration_5()); 

                    }


                    }
                    break;
                case 7 :
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1286:6: ( ( 'Float' ) )
                    {
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1286:6: ( ( 'Float' ) )
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1287:1: ( 'Float' )
                    {
                     before(grammarAccess.getDataTypeAccess().getTFLOATEnumLiteralDeclaration_6()); 
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1288:1: ( 'Float' )
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1288:3: 'Float'
                    {
                    match(input,19,FOLLOW_19_in_rule__DataType__Alternatives2783); 

                    }

                     after(grammarAccess.getDataTypeAccess().getTFLOATEnumLiteralDeclaration_6()); 

                    }


                    }
                    break;
                case 8 :
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1293:6: ( ( 'Double' ) )
                    {
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1293:6: ( ( 'Double' ) )
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1294:1: ( 'Double' )
                    {
                     before(grammarAccess.getDataTypeAccess().getTDOUBLEEnumLiteralDeclaration_7()); 
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1295:1: ( 'Double' )
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1295:3: 'Double'
                    {
                    match(input,20,FOLLOW_20_in_rule__DataType__Alternatives2804); 

                    }

                     after(grammarAccess.getDataTypeAccess().getTDOUBLEEnumLiteralDeclaration_7()); 

                    }


                    }
                    break;
                case 9 :
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1300:6: ( ( 'String' ) )
                    {
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1300:6: ( ( 'String' ) )
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1301:1: ( 'String' )
                    {
                     before(grammarAccess.getDataTypeAccess().getTSTRINGEnumLiteralDeclaration_8()); 
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1302:1: ( 'String' )
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1302:3: 'String'
                    {
                    match(input,21,FOLLOW_21_in_rule__DataType__Alternatives2825); 

                    }

                     after(grammarAccess.getDataTypeAccess().getTSTRINGEnumLiteralDeclaration_8()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataType__Alternatives"


    // $ANTLR start "rule__Model__Group_2__0"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1314:1: rule__Model__Group_2__0 : rule__Model__Group_2__0__Impl rule__Model__Group_2__1 ;
    public final void rule__Model__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1318:1: ( rule__Model__Group_2__0__Impl rule__Model__Group_2__1 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1319:2: rule__Model__Group_2__0__Impl rule__Model__Group_2__1
            {
            pushFollow(FOLLOW_rule__Model__Group_2__0__Impl_in_rule__Model__Group_2__02858);
            rule__Model__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Model__Group_2__1_in_rule__Model__Group_2__02861);
            rule__Model__Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_2__0"


    // $ANTLR start "rule__Model__Group_2__0__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1326:1: rule__Model__Group_2__0__Impl : ( ( rule__Model__CommandsAssignment_2_0 ) ) ;
    public final void rule__Model__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1330:1: ( ( ( rule__Model__CommandsAssignment_2_0 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1331:1: ( ( rule__Model__CommandsAssignment_2_0 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1331:1: ( ( rule__Model__CommandsAssignment_2_0 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1332:1: ( rule__Model__CommandsAssignment_2_0 )
            {
             before(grammarAccess.getModelAccess().getCommandsAssignment_2_0()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1333:1: ( rule__Model__CommandsAssignment_2_0 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1333:2: rule__Model__CommandsAssignment_2_0
            {
            pushFollow(FOLLOW_rule__Model__CommandsAssignment_2_0_in_rule__Model__Group_2__0__Impl2888);
            rule__Model__CommandsAssignment_2_0();

            state._fsp--;


            }

             after(grammarAccess.getModelAccess().getCommandsAssignment_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_2__0__Impl"


    // $ANTLR start "rule__Model__Group_2__1"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1343:1: rule__Model__Group_2__1 : rule__Model__Group_2__1__Impl ;
    public final void rule__Model__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1347:1: ( rule__Model__Group_2__1__Impl )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1348:2: rule__Model__Group_2__1__Impl
            {
            pushFollow(FOLLOW_rule__Model__Group_2__1__Impl_in_rule__Model__Group_2__12918);
            rule__Model__Group_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_2__1"


    // $ANTLR start "rule__Model__Group_2__1__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1354:1: rule__Model__Group_2__1__Impl : ( ( rule__Model__CommandsAssignment_2_1 )* ) ;
    public final void rule__Model__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1358:1: ( ( ( rule__Model__CommandsAssignment_2_1 )* ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1359:1: ( ( rule__Model__CommandsAssignment_2_1 )* )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1359:1: ( ( rule__Model__CommandsAssignment_2_1 )* )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1360:1: ( rule__Model__CommandsAssignment_2_1 )*
            {
             before(grammarAccess.getModelAccess().getCommandsAssignment_2_1()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1361:1: ( rule__Model__CommandsAssignment_2_1 )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==RULE_ID||LA11_0==22||(LA11_0>=24 && LA11_0<=26)||LA11_0==30) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1361:2: rule__Model__CommandsAssignment_2_1
            	    {
            	    pushFollow(FOLLOW_rule__Model__CommandsAssignment_2_1_in_rule__Model__Group_2__1__Impl2945);
            	    rule__Model__CommandsAssignment_2_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

             after(grammarAccess.getModelAccess().getCommandsAssignment_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_2__1__Impl"


    // $ANTLR start "rule__MakeEmf__Group__0"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1375:1: rule__MakeEmf__Group__0 : rule__MakeEmf__Group__0__Impl rule__MakeEmf__Group__1 ;
    public final void rule__MakeEmf__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1379:1: ( rule__MakeEmf__Group__0__Impl rule__MakeEmf__Group__1 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1380:2: rule__MakeEmf__Group__0__Impl rule__MakeEmf__Group__1
            {
            pushFollow(FOLLOW_rule__MakeEmf__Group__0__Impl_in_rule__MakeEmf__Group__02980);
            rule__MakeEmf__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__MakeEmf__Group__1_in_rule__MakeEmf__Group__02983);
            rule__MakeEmf__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MakeEmf__Group__0"


    // $ANTLR start "rule__MakeEmf__Group__0__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1387:1: rule__MakeEmf__Group__0__Impl : ( 'emf(' ) ;
    public final void rule__MakeEmf__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1391:1: ( ( 'emf(' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1392:1: ( 'emf(' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1392:1: ( 'emf(' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1393:1: 'emf('
            {
             before(grammarAccess.getMakeEmfAccess().getEmfKeyword_0()); 
            match(input,22,FOLLOW_22_in_rule__MakeEmf__Group__0__Impl3011); 
             after(grammarAccess.getMakeEmfAccess().getEmfKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MakeEmf__Group__0__Impl"


    // $ANTLR start "rule__MakeEmf__Group__1"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1406:1: rule__MakeEmf__Group__1 : rule__MakeEmf__Group__1__Impl rule__MakeEmf__Group__2 ;
    public final void rule__MakeEmf__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1410:1: ( rule__MakeEmf__Group__1__Impl rule__MakeEmf__Group__2 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1411:2: rule__MakeEmf__Group__1__Impl rule__MakeEmf__Group__2
            {
            pushFollow(FOLLOW_rule__MakeEmf__Group__1__Impl_in_rule__MakeEmf__Group__13042);
            rule__MakeEmf__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__MakeEmf__Group__2_in_rule__MakeEmf__Group__13045);
            rule__MakeEmf__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MakeEmf__Group__1"


    // $ANTLR start "rule__MakeEmf__Group__1__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1418:1: rule__MakeEmf__Group__1__Impl : ( ( rule__MakeEmf__IdAssignment_1 ) ) ;
    public final void rule__MakeEmf__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1422:1: ( ( ( rule__MakeEmf__IdAssignment_1 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1423:1: ( ( rule__MakeEmf__IdAssignment_1 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1423:1: ( ( rule__MakeEmf__IdAssignment_1 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1424:1: ( rule__MakeEmf__IdAssignment_1 )
            {
             before(grammarAccess.getMakeEmfAccess().getIdAssignment_1()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1425:1: ( rule__MakeEmf__IdAssignment_1 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1425:2: rule__MakeEmf__IdAssignment_1
            {
            pushFollow(FOLLOW_rule__MakeEmf__IdAssignment_1_in_rule__MakeEmf__Group__1__Impl3072);
            rule__MakeEmf__IdAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getMakeEmfAccess().getIdAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MakeEmf__Group__1__Impl"


    // $ANTLR start "rule__MakeEmf__Group__2"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1435:1: rule__MakeEmf__Group__2 : rule__MakeEmf__Group__2__Impl ;
    public final void rule__MakeEmf__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1439:1: ( rule__MakeEmf__Group__2__Impl )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1440:2: rule__MakeEmf__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__MakeEmf__Group__2__Impl_in_rule__MakeEmf__Group__23102);
            rule__MakeEmf__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MakeEmf__Group__2"


    // $ANTLR start "rule__MakeEmf__Group__2__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1446:1: rule__MakeEmf__Group__2__Impl : ( ')' ) ;
    public final void rule__MakeEmf__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1450:1: ( ( ')' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1451:1: ( ')' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1451:1: ( ')' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1452:1: ')'
            {
             before(grammarAccess.getMakeEmfAccess().getRightParenthesisKeyword_2()); 
            match(input,23,FOLLOW_23_in_rule__MakeEmf__Group__2__Impl3130); 
             after(grammarAccess.getMakeEmfAccess().getRightParenthesisKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MakeEmf__Group__2__Impl"


    // $ANTLR start "rule__MakeEcore__Group__0"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1471:1: rule__MakeEcore__Group__0 : rule__MakeEcore__Group__0__Impl rule__MakeEcore__Group__1 ;
    public final void rule__MakeEcore__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1475:1: ( rule__MakeEcore__Group__0__Impl rule__MakeEcore__Group__1 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1476:2: rule__MakeEcore__Group__0__Impl rule__MakeEcore__Group__1
            {
            pushFollow(FOLLOW_rule__MakeEcore__Group__0__Impl_in_rule__MakeEcore__Group__03167);
            rule__MakeEcore__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__MakeEcore__Group__1_in_rule__MakeEcore__Group__03170);
            rule__MakeEcore__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MakeEcore__Group__0"


    // $ANTLR start "rule__MakeEcore__Group__0__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1483:1: rule__MakeEcore__Group__0__Impl : ( 'ecore(' ) ;
    public final void rule__MakeEcore__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1487:1: ( ( 'ecore(' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1488:1: ( 'ecore(' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1488:1: ( 'ecore(' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1489:1: 'ecore('
            {
             before(grammarAccess.getMakeEcoreAccess().getEcoreKeyword_0()); 
            match(input,24,FOLLOW_24_in_rule__MakeEcore__Group__0__Impl3198); 
             after(grammarAccess.getMakeEcoreAccess().getEcoreKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MakeEcore__Group__0__Impl"


    // $ANTLR start "rule__MakeEcore__Group__1"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1502:1: rule__MakeEcore__Group__1 : rule__MakeEcore__Group__1__Impl rule__MakeEcore__Group__2 ;
    public final void rule__MakeEcore__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1506:1: ( rule__MakeEcore__Group__1__Impl rule__MakeEcore__Group__2 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1507:2: rule__MakeEcore__Group__1__Impl rule__MakeEcore__Group__2
            {
            pushFollow(FOLLOW_rule__MakeEcore__Group__1__Impl_in_rule__MakeEcore__Group__13229);
            rule__MakeEcore__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__MakeEcore__Group__2_in_rule__MakeEcore__Group__13232);
            rule__MakeEcore__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MakeEcore__Group__1"


    // $ANTLR start "rule__MakeEcore__Group__1__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1514:1: rule__MakeEcore__Group__1__Impl : ( ( rule__MakeEcore__IdAssignment_1 ) ) ;
    public final void rule__MakeEcore__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1518:1: ( ( ( rule__MakeEcore__IdAssignment_1 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1519:1: ( ( rule__MakeEcore__IdAssignment_1 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1519:1: ( ( rule__MakeEcore__IdAssignment_1 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1520:1: ( rule__MakeEcore__IdAssignment_1 )
            {
             before(grammarAccess.getMakeEcoreAccess().getIdAssignment_1()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1521:1: ( rule__MakeEcore__IdAssignment_1 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1521:2: rule__MakeEcore__IdAssignment_1
            {
            pushFollow(FOLLOW_rule__MakeEcore__IdAssignment_1_in_rule__MakeEcore__Group__1__Impl3259);
            rule__MakeEcore__IdAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getMakeEcoreAccess().getIdAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MakeEcore__Group__1__Impl"


    // $ANTLR start "rule__MakeEcore__Group__2"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1531:1: rule__MakeEcore__Group__2 : rule__MakeEcore__Group__2__Impl ;
    public final void rule__MakeEcore__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1535:1: ( rule__MakeEcore__Group__2__Impl )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1536:2: rule__MakeEcore__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__MakeEcore__Group__2__Impl_in_rule__MakeEcore__Group__23289);
            rule__MakeEcore__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MakeEcore__Group__2"


    // $ANTLR start "rule__MakeEcore__Group__2__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1542:1: rule__MakeEcore__Group__2__Impl : ( ')' ) ;
    public final void rule__MakeEcore__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1546:1: ( ( ')' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1547:1: ( ')' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1547:1: ( ')' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1548:1: ')'
            {
             before(grammarAccess.getMakeEcoreAccess().getRightParenthesisKeyword_2()); 
            match(input,23,FOLLOW_23_in_rule__MakeEcore__Group__2__Impl3317); 
             after(grammarAccess.getMakeEcoreAccess().getRightParenthesisKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MakeEcore__Group__2__Impl"


    // $ANTLR start "rule__MakeImage__Group__0"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1567:1: rule__MakeImage__Group__0 : rule__MakeImage__Group__0__Impl rule__MakeImage__Group__1 ;
    public final void rule__MakeImage__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1571:1: ( rule__MakeImage__Group__0__Impl rule__MakeImage__Group__1 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1572:2: rule__MakeImage__Group__0__Impl rule__MakeImage__Group__1
            {
            pushFollow(FOLLOW_rule__MakeImage__Group__0__Impl_in_rule__MakeImage__Group__03354);
            rule__MakeImage__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__MakeImage__Group__1_in_rule__MakeImage__Group__03357);
            rule__MakeImage__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MakeImage__Group__0"


    // $ANTLR start "rule__MakeImage__Group__0__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1579:1: rule__MakeImage__Group__0__Impl : ( 'image(' ) ;
    public final void rule__MakeImage__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1583:1: ( ( 'image(' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1584:1: ( 'image(' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1584:1: ( 'image(' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1585:1: 'image('
            {
             before(grammarAccess.getMakeImageAccess().getImageKeyword_0()); 
            match(input,25,FOLLOW_25_in_rule__MakeImage__Group__0__Impl3385); 
             after(grammarAccess.getMakeImageAccess().getImageKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MakeImage__Group__0__Impl"


    // $ANTLR start "rule__MakeImage__Group__1"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1598:1: rule__MakeImage__Group__1 : rule__MakeImage__Group__1__Impl rule__MakeImage__Group__2 ;
    public final void rule__MakeImage__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1602:1: ( rule__MakeImage__Group__1__Impl rule__MakeImage__Group__2 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1603:2: rule__MakeImage__Group__1__Impl rule__MakeImage__Group__2
            {
            pushFollow(FOLLOW_rule__MakeImage__Group__1__Impl_in_rule__MakeImage__Group__13416);
            rule__MakeImage__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__MakeImage__Group__2_in_rule__MakeImage__Group__13419);
            rule__MakeImage__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MakeImage__Group__1"


    // $ANTLR start "rule__MakeImage__Group__1__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1610:1: rule__MakeImage__Group__1__Impl : ( ( rule__MakeImage__IdAssignment_1 ) ) ;
    public final void rule__MakeImage__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1614:1: ( ( ( rule__MakeImage__IdAssignment_1 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1615:1: ( ( rule__MakeImage__IdAssignment_1 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1615:1: ( ( rule__MakeImage__IdAssignment_1 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1616:1: ( rule__MakeImage__IdAssignment_1 )
            {
             before(grammarAccess.getMakeImageAccess().getIdAssignment_1()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1617:1: ( rule__MakeImage__IdAssignment_1 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1617:2: rule__MakeImage__IdAssignment_1
            {
            pushFollow(FOLLOW_rule__MakeImage__IdAssignment_1_in_rule__MakeImage__Group__1__Impl3446);
            rule__MakeImage__IdAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getMakeImageAccess().getIdAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MakeImage__Group__1__Impl"


    // $ANTLR start "rule__MakeImage__Group__2"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1627:1: rule__MakeImage__Group__2 : rule__MakeImage__Group__2__Impl ;
    public final void rule__MakeImage__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1631:1: ( rule__MakeImage__Group__2__Impl )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1632:2: rule__MakeImage__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__MakeImage__Group__2__Impl_in_rule__MakeImage__Group__23476);
            rule__MakeImage__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MakeImage__Group__2"


    // $ANTLR start "rule__MakeImage__Group__2__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1638:1: rule__MakeImage__Group__2__Impl : ( ')' ) ;
    public final void rule__MakeImage__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1642:1: ( ( ')' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1643:1: ( ')' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1643:1: ( ')' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1644:1: ')'
            {
             before(grammarAccess.getMakeImageAccess().getRightParenthesisKeyword_2()); 
            match(input,23,FOLLOW_23_in_rule__MakeImage__Group__2__Impl3504); 
             after(grammarAccess.getMakeImageAccess().getRightParenthesisKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MakeImage__Group__2__Impl"


    // $ANTLR start "rule__SimpleEvoSpan__Group__0"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1663:1: rule__SimpleEvoSpan__Group__0 : rule__SimpleEvoSpan__Group__0__Impl rule__SimpleEvoSpan__Group__1 ;
    public final void rule__SimpleEvoSpan__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1667:1: ( rule__SimpleEvoSpan__Group__0__Impl rule__SimpleEvoSpan__Group__1 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1668:2: rule__SimpleEvoSpan__Group__0__Impl rule__SimpleEvoSpan__Group__1
            {
            pushFollow(FOLLOW_rule__SimpleEvoSpan__Group__0__Impl_in_rule__SimpleEvoSpan__Group__03541);
            rule__SimpleEvoSpan__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SimpleEvoSpan__Group__1_in_rule__SimpleEvoSpan__Group__03544);
            rule__SimpleEvoSpan__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleEvoSpan__Group__0"


    // $ANTLR start "rule__SimpleEvoSpan__Group__0__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1675:1: rule__SimpleEvoSpan__Group__0__Impl : ( 'simpleEvolution(' ) ;
    public final void rule__SimpleEvoSpan__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1679:1: ( ( 'simpleEvolution(' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1680:1: ( 'simpleEvolution(' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1680:1: ( 'simpleEvolution(' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1681:1: 'simpleEvolution('
            {
             before(grammarAccess.getSimpleEvoSpanAccess().getSimpleEvolutionKeyword_0()); 
            match(input,26,FOLLOW_26_in_rule__SimpleEvoSpan__Group__0__Impl3572); 
             after(grammarAccess.getSimpleEvoSpanAccess().getSimpleEvolutionKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleEvoSpan__Group__0__Impl"


    // $ANTLR start "rule__SimpleEvoSpan__Group__1"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1694:1: rule__SimpleEvoSpan__Group__1 : rule__SimpleEvoSpan__Group__1__Impl rule__SimpleEvoSpan__Group__2 ;
    public final void rule__SimpleEvoSpan__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1698:1: ( rule__SimpleEvoSpan__Group__1__Impl rule__SimpleEvoSpan__Group__2 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1699:2: rule__SimpleEvoSpan__Group__1__Impl rule__SimpleEvoSpan__Group__2
            {
            pushFollow(FOLLOW_rule__SimpleEvoSpan__Group__1__Impl_in_rule__SimpleEvoSpan__Group__13603);
            rule__SimpleEvoSpan__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SimpleEvoSpan__Group__2_in_rule__SimpleEvoSpan__Group__13606);
            rule__SimpleEvoSpan__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleEvoSpan__Group__1"


    // $ANTLR start "rule__SimpleEvoSpan__Group__1__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1706:1: rule__SimpleEvoSpan__Group__1__Impl : ( ( rule__SimpleEvoSpan__LhsAssignment_1 ) ) ;
    public final void rule__SimpleEvoSpan__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1710:1: ( ( ( rule__SimpleEvoSpan__LhsAssignment_1 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1711:1: ( ( rule__SimpleEvoSpan__LhsAssignment_1 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1711:1: ( ( rule__SimpleEvoSpan__LhsAssignment_1 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1712:1: ( rule__SimpleEvoSpan__LhsAssignment_1 )
            {
             before(grammarAccess.getSimpleEvoSpanAccess().getLhsAssignment_1()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1713:1: ( rule__SimpleEvoSpan__LhsAssignment_1 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1713:2: rule__SimpleEvoSpan__LhsAssignment_1
            {
            pushFollow(FOLLOW_rule__SimpleEvoSpan__LhsAssignment_1_in_rule__SimpleEvoSpan__Group__1__Impl3633);
            rule__SimpleEvoSpan__LhsAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getSimpleEvoSpanAccess().getLhsAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleEvoSpan__Group__1__Impl"


    // $ANTLR start "rule__SimpleEvoSpan__Group__2"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1723:1: rule__SimpleEvoSpan__Group__2 : rule__SimpleEvoSpan__Group__2__Impl rule__SimpleEvoSpan__Group__3 ;
    public final void rule__SimpleEvoSpan__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1727:1: ( rule__SimpleEvoSpan__Group__2__Impl rule__SimpleEvoSpan__Group__3 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1728:2: rule__SimpleEvoSpan__Group__2__Impl rule__SimpleEvoSpan__Group__3
            {
            pushFollow(FOLLOW_rule__SimpleEvoSpan__Group__2__Impl_in_rule__SimpleEvoSpan__Group__23663);
            rule__SimpleEvoSpan__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SimpleEvoSpan__Group__3_in_rule__SimpleEvoSpan__Group__23666);
            rule__SimpleEvoSpan__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleEvoSpan__Group__2"


    // $ANTLR start "rule__SimpleEvoSpan__Group__2__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1735:1: rule__SimpleEvoSpan__Group__2__Impl : ( '<-' ) ;
    public final void rule__SimpleEvoSpan__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1739:1: ( ( '<-' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1740:1: ( '<-' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1740:1: ( '<-' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1741:1: '<-'
            {
             before(grammarAccess.getSimpleEvoSpanAccess().getLessThanSignHyphenMinusKeyword_2()); 
            match(input,27,FOLLOW_27_in_rule__SimpleEvoSpan__Group__2__Impl3694); 
             after(grammarAccess.getSimpleEvoSpanAccess().getLessThanSignHyphenMinusKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleEvoSpan__Group__2__Impl"


    // $ANTLR start "rule__SimpleEvoSpan__Group__3"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1754:1: rule__SimpleEvoSpan__Group__3 : rule__SimpleEvoSpan__Group__3__Impl rule__SimpleEvoSpan__Group__4 ;
    public final void rule__SimpleEvoSpan__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1758:1: ( rule__SimpleEvoSpan__Group__3__Impl rule__SimpleEvoSpan__Group__4 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1759:2: rule__SimpleEvoSpan__Group__3__Impl rule__SimpleEvoSpan__Group__4
            {
            pushFollow(FOLLOW_rule__SimpleEvoSpan__Group__3__Impl_in_rule__SimpleEvoSpan__Group__33725);
            rule__SimpleEvoSpan__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SimpleEvoSpan__Group__4_in_rule__SimpleEvoSpan__Group__33728);
            rule__SimpleEvoSpan__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleEvoSpan__Group__3"


    // $ANTLR start "rule__SimpleEvoSpan__Group__3__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1766:1: rule__SimpleEvoSpan__Group__3__Impl : ( ( rule__SimpleEvoSpan__DiffAssignment_3 ) ) ;
    public final void rule__SimpleEvoSpan__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1770:1: ( ( ( rule__SimpleEvoSpan__DiffAssignment_3 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1771:1: ( ( rule__SimpleEvoSpan__DiffAssignment_3 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1771:1: ( ( rule__SimpleEvoSpan__DiffAssignment_3 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1772:1: ( rule__SimpleEvoSpan__DiffAssignment_3 )
            {
             before(grammarAccess.getSimpleEvoSpanAccess().getDiffAssignment_3()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1773:1: ( rule__SimpleEvoSpan__DiffAssignment_3 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1773:2: rule__SimpleEvoSpan__DiffAssignment_3
            {
            pushFollow(FOLLOW_rule__SimpleEvoSpan__DiffAssignment_3_in_rule__SimpleEvoSpan__Group__3__Impl3755);
            rule__SimpleEvoSpan__DiffAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getSimpleEvoSpanAccess().getDiffAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleEvoSpan__Group__3__Impl"


    // $ANTLR start "rule__SimpleEvoSpan__Group__4"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1783:1: rule__SimpleEvoSpan__Group__4 : rule__SimpleEvoSpan__Group__4__Impl rule__SimpleEvoSpan__Group__5 ;
    public final void rule__SimpleEvoSpan__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1787:1: ( rule__SimpleEvoSpan__Group__4__Impl rule__SimpleEvoSpan__Group__5 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1788:2: rule__SimpleEvoSpan__Group__4__Impl rule__SimpleEvoSpan__Group__5
            {
            pushFollow(FOLLOW_rule__SimpleEvoSpan__Group__4__Impl_in_rule__SimpleEvoSpan__Group__43785);
            rule__SimpleEvoSpan__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SimpleEvoSpan__Group__5_in_rule__SimpleEvoSpan__Group__43788);
            rule__SimpleEvoSpan__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleEvoSpan__Group__4"


    // $ANTLR start "rule__SimpleEvoSpan__Group__4__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1795:1: rule__SimpleEvoSpan__Group__4__Impl : ( '->' ) ;
    public final void rule__SimpleEvoSpan__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1799:1: ( ( '->' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1800:1: ( '->' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1800:1: ( '->' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1801:1: '->'
            {
             before(grammarAccess.getSimpleEvoSpanAccess().getHyphenMinusGreaterThanSignKeyword_4()); 
            match(input,28,FOLLOW_28_in_rule__SimpleEvoSpan__Group__4__Impl3816); 
             after(grammarAccess.getSimpleEvoSpanAccess().getHyphenMinusGreaterThanSignKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleEvoSpan__Group__4__Impl"


    // $ANTLR start "rule__SimpleEvoSpan__Group__5"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1814:1: rule__SimpleEvoSpan__Group__5 : rule__SimpleEvoSpan__Group__5__Impl rule__SimpleEvoSpan__Group__6 ;
    public final void rule__SimpleEvoSpan__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1818:1: ( rule__SimpleEvoSpan__Group__5__Impl rule__SimpleEvoSpan__Group__6 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1819:2: rule__SimpleEvoSpan__Group__5__Impl rule__SimpleEvoSpan__Group__6
            {
            pushFollow(FOLLOW_rule__SimpleEvoSpan__Group__5__Impl_in_rule__SimpleEvoSpan__Group__53847);
            rule__SimpleEvoSpan__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SimpleEvoSpan__Group__6_in_rule__SimpleEvoSpan__Group__53850);
            rule__SimpleEvoSpan__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleEvoSpan__Group__5"


    // $ANTLR start "rule__SimpleEvoSpan__Group__5__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1826:1: rule__SimpleEvoSpan__Group__5__Impl : ( ( rule__SimpleEvoSpan__RhSAssignment_5 ) ) ;
    public final void rule__SimpleEvoSpan__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1830:1: ( ( ( rule__SimpleEvoSpan__RhSAssignment_5 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1831:1: ( ( rule__SimpleEvoSpan__RhSAssignment_5 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1831:1: ( ( rule__SimpleEvoSpan__RhSAssignment_5 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1832:1: ( rule__SimpleEvoSpan__RhSAssignment_5 )
            {
             before(grammarAccess.getSimpleEvoSpanAccess().getRhSAssignment_5()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1833:1: ( rule__SimpleEvoSpan__RhSAssignment_5 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1833:2: rule__SimpleEvoSpan__RhSAssignment_5
            {
            pushFollow(FOLLOW_rule__SimpleEvoSpan__RhSAssignment_5_in_rule__SimpleEvoSpan__Group__5__Impl3877);
            rule__SimpleEvoSpan__RhSAssignment_5();

            state._fsp--;


            }

             after(grammarAccess.getSimpleEvoSpanAccess().getRhSAssignment_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleEvoSpan__Group__5__Impl"


    // $ANTLR start "rule__SimpleEvoSpan__Group__6"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1843:1: rule__SimpleEvoSpan__Group__6 : rule__SimpleEvoSpan__Group__6__Impl rule__SimpleEvoSpan__Group__7 ;
    public final void rule__SimpleEvoSpan__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1847:1: ( rule__SimpleEvoSpan__Group__6__Impl rule__SimpleEvoSpan__Group__7 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1848:2: rule__SimpleEvoSpan__Group__6__Impl rule__SimpleEvoSpan__Group__7
            {
            pushFollow(FOLLOW_rule__SimpleEvoSpan__Group__6__Impl_in_rule__SimpleEvoSpan__Group__63907);
            rule__SimpleEvoSpan__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SimpleEvoSpan__Group__7_in_rule__SimpleEvoSpan__Group__63910);
            rule__SimpleEvoSpan__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleEvoSpan__Group__6"


    // $ANTLR start "rule__SimpleEvoSpan__Group__6__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1855:1: rule__SimpleEvoSpan__Group__6__Impl : ( ',' ) ;
    public final void rule__SimpleEvoSpan__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1859:1: ( ( ',' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1860:1: ( ',' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1860:1: ( ',' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1861:1: ','
            {
             before(grammarAccess.getSimpleEvoSpanAccess().getCommaKeyword_6()); 
            match(input,29,FOLLOW_29_in_rule__SimpleEvoSpan__Group__6__Impl3938); 
             after(grammarAccess.getSimpleEvoSpanAccess().getCommaKeyword_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleEvoSpan__Group__6__Impl"


    // $ANTLR start "rule__SimpleEvoSpan__Group__7"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1874:1: rule__SimpleEvoSpan__Group__7 : rule__SimpleEvoSpan__Group__7__Impl rule__SimpleEvoSpan__Group__8 ;
    public final void rule__SimpleEvoSpan__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1878:1: ( rule__SimpleEvoSpan__Group__7__Impl rule__SimpleEvoSpan__Group__8 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1879:2: rule__SimpleEvoSpan__Group__7__Impl rule__SimpleEvoSpan__Group__8
            {
            pushFollow(FOLLOW_rule__SimpleEvoSpan__Group__7__Impl_in_rule__SimpleEvoSpan__Group__73969);
            rule__SimpleEvoSpan__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SimpleEvoSpan__Group__8_in_rule__SimpleEvoSpan__Group__73972);
            rule__SimpleEvoSpan__Group__8();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleEvoSpan__Group__7"


    // $ANTLR start "rule__SimpleEvoSpan__Group__7__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1886:1: rule__SimpleEvoSpan__Group__7__Impl : ( ( rule__SimpleEvoSpan__TypeGraphAssignment_7 ) ) ;
    public final void rule__SimpleEvoSpan__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1890:1: ( ( ( rule__SimpleEvoSpan__TypeGraphAssignment_7 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1891:1: ( ( rule__SimpleEvoSpan__TypeGraphAssignment_7 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1891:1: ( ( rule__SimpleEvoSpan__TypeGraphAssignment_7 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1892:1: ( rule__SimpleEvoSpan__TypeGraphAssignment_7 )
            {
             before(grammarAccess.getSimpleEvoSpanAccess().getTypeGraphAssignment_7()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1893:1: ( rule__SimpleEvoSpan__TypeGraphAssignment_7 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1893:2: rule__SimpleEvoSpan__TypeGraphAssignment_7
            {
            pushFollow(FOLLOW_rule__SimpleEvoSpan__TypeGraphAssignment_7_in_rule__SimpleEvoSpan__Group__7__Impl3999);
            rule__SimpleEvoSpan__TypeGraphAssignment_7();

            state._fsp--;


            }

             after(grammarAccess.getSimpleEvoSpanAccess().getTypeGraphAssignment_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleEvoSpan__Group__7__Impl"


    // $ANTLR start "rule__SimpleEvoSpan__Group__8"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1903:1: rule__SimpleEvoSpan__Group__8 : rule__SimpleEvoSpan__Group__8__Impl ;
    public final void rule__SimpleEvoSpan__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1907:1: ( rule__SimpleEvoSpan__Group__8__Impl )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1908:2: rule__SimpleEvoSpan__Group__8__Impl
            {
            pushFollow(FOLLOW_rule__SimpleEvoSpan__Group__8__Impl_in_rule__SimpleEvoSpan__Group__84029);
            rule__SimpleEvoSpan__Group__8__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleEvoSpan__Group__8"


    // $ANTLR start "rule__SimpleEvoSpan__Group__8__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1914:1: rule__SimpleEvoSpan__Group__8__Impl : ( ')' ) ;
    public final void rule__SimpleEvoSpan__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1918:1: ( ( ')' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1919:1: ( ')' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1919:1: ( ')' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1920:1: ')'
            {
             before(grammarAccess.getSimpleEvoSpanAccess().getRightParenthesisKeyword_8()); 
            match(input,23,FOLLOW_23_in_rule__SimpleEvoSpan__Group__8__Impl4057); 
             after(grammarAccess.getSimpleEvoSpanAccess().getRightParenthesisKeyword_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleEvoSpan__Group__8__Impl"


    // $ANTLR start "rule__SimpleEvoCospan__Group__0"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1951:1: rule__SimpleEvoCospan__Group__0 : rule__SimpleEvoCospan__Group__0__Impl rule__SimpleEvoCospan__Group__1 ;
    public final void rule__SimpleEvoCospan__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1955:1: ( rule__SimpleEvoCospan__Group__0__Impl rule__SimpleEvoCospan__Group__1 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1956:2: rule__SimpleEvoCospan__Group__0__Impl rule__SimpleEvoCospan__Group__1
            {
            pushFollow(FOLLOW_rule__SimpleEvoCospan__Group__0__Impl_in_rule__SimpleEvoCospan__Group__04106);
            rule__SimpleEvoCospan__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SimpleEvoCospan__Group__1_in_rule__SimpleEvoCospan__Group__04109);
            rule__SimpleEvoCospan__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleEvoCospan__Group__0"


    // $ANTLR start "rule__SimpleEvoCospan__Group__0__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1963:1: rule__SimpleEvoCospan__Group__0__Impl : ( 'simpleEvolution(' ) ;
    public final void rule__SimpleEvoCospan__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1967:1: ( ( 'simpleEvolution(' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1968:1: ( 'simpleEvolution(' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1968:1: ( 'simpleEvolution(' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1969:1: 'simpleEvolution('
            {
             before(grammarAccess.getSimpleEvoCospanAccess().getSimpleEvolutionKeyword_0()); 
            match(input,26,FOLLOW_26_in_rule__SimpleEvoCospan__Group__0__Impl4137); 
             after(grammarAccess.getSimpleEvoCospanAccess().getSimpleEvolutionKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleEvoCospan__Group__0__Impl"


    // $ANTLR start "rule__SimpleEvoCospan__Group__1"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1982:1: rule__SimpleEvoCospan__Group__1 : rule__SimpleEvoCospan__Group__1__Impl rule__SimpleEvoCospan__Group__2 ;
    public final void rule__SimpleEvoCospan__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1986:1: ( rule__SimpleEvoCospan__Group__1__Impl rule__SimpleEvoCospan__Group__2 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1987:2: rule__SimpleEvoCospan__Group__1__Impl rule__SimpleEvoCospan__Group__2
            {
            pushFollow(FOLLOW_rule__SimpleEvoCospan__Group__1__Impl_in_rule__SimpleEvoCospan__Group__14168);
            rule__SimpleEvoCospan__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SimpleEvoCospan__Group__2_in_rule__SimpleEvoCospan__Group__14171);
            rule__SimpleEvoCospan__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleEvoCospan__Group__1"


    // $ANTLR start "rule__SimpleEvoCospan__Group__1__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1994:1: rule__SimpleEvoCospan__Group__1__Impl : ( ( rule__SimpleEvoCospan__LhsAssignment_1 ) ) ;
    public final void rule__SimpleEvoCospan__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1998:1: ( ( ( rule__SimpleEvoCospan__LhsAssignment_1 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1999:1: ( ( rule__SimpleEvoCospan__LhsAssignment_1 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1999:1: ( ( rule__SimpleEvoCospan__LhsAssignment_1 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2000:1: ( rule__SimpleEvoCospan__LhsAssignment_1 )
            {
             before(grammarAccess.getSimpleEvoCospanAccess().getLhsAssignment_1()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2001:1: ( rule__SimpleEvoCospan__LhsAssignment_1 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2001:2: rule__SimpleEvoCospan__LhsAssignment_1
            {
            pushFollow(FOLLOW_rule__SimpleEvoCospan__LhsAssignment_1_in_rule__SimpleEvoCospan__Group__1__Impl4198);
            rule__SimpleEvoCospan__LhsAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getSimpleEvoCospanAccess().getLhsAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleEvoCospan__Group__1__Impl"


    // $ANTLR start "rule__SimpleEvoCospan__Group__2"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2011:1: rule__SimpleEvoCospan__Group__2 : rule__SimpleEvoCospan__Group__2__Impl rule__SimpleEvoCospan__Group__3 ;
    public final void rule__SimpleEvoCospan__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2015:1: ( rule__SimpleEvoCospan__Group__2__Impl rule__SimpleEvoCospan__Group__3 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2016:2: rule__SimpleEvoCospan__Group__2__Impl rule__SimpleEvoCospan__Group__3
            {
            pushFollow(FOLLOW_rule__SimpleEvoCospan__Group__2__Impl_in_rule__SimpleEvoCospan__Group__24228);
            rule__SimpleEvoCospan__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SimpleEvoCospan__Group__3_in_rule__SimpleEvoCospan__Group__24231);
            rule__SimpleEvoCospan__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleEvoCospan__Group__2"


    // $ANTLR start "rule__SimpleEvoCospan__Group__2__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2023:1: rule__SimpleEvoCospan__Group__2__Impl : ( '->' ) ;
    public final void rule__SimpleEvoCospan__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2027:1: ( ( '->' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2028:1: ( '->' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2028:1: ( '->' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2029:1: '->'
            {
             before(grammarAccess.getSimpleEvoCospanAccess().getHyphenMinusGreaterThanSignKeyword_2()); 
            match(input,28,FOLLOW_28_in_rule__SimpleEvoCospan__Group__2__Impl4259); 
             after(grammarAccess.getSimpleEvoCospanAccess().getHyphenMinusGreaterThanSignKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleEvoCospan__Group__2__Impl"


    // $ANTLR start "rule__SimpleEvoCospan__Group__3"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2042:1: rule__SimpleEvoCospan__Group__3 : rule__SimpleEvoCospan__Group__3__Impl rule__SimpleEvoCospan__Group__4 ;
    public final void rule__SimpleEvoCospan__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2046:1: ( rule__SimpleEvoCospan__Group__3__Impl rule__SimpleEvoCospan__Group__4 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2047:2: rule__SimpleEvoCospan__Group__3__Impl rule__SimpleEvoCospan__Group__4
            {
            pushFollow(FOLLOW_rule__SimpleEvoCospan__Group__3__Impl_in_rule__SimpleEvoCospan__Group__34290);
            rule__SimpleEvoCospan__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SimpleEvoCospan__Group__4_in_rule__SimpleEvoCospan__Group__34293);
            rule__SimpleEvoCospan__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleEvoCospan__Group__3"


    // $ANTLR start "rule__SimpleEvoCospan__Group__3__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2054:1: rule__SimpleEvoCospan__Group__3__Impl : ( ( rule__SimpleEvoCospan__JointAssignment_3 ) ) ;
    public final void rule__SimpleEvoCospan__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2058:1: ( ( ( rule__SimpleEvoCospan__JointAssignment_3 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2059:1: ( ( rule__SimpleEvoCospan__JointAssignment_3 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2059:1: ( ( rule__SimpleEvoCospan__JointAssignment_3 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2060:1: ( rule__SimpleEvoCospan__JointAssignment_3 )
            {
             before(grammarAccess.getSimpleEvoCospanAccess().getJointAssignment_3()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2061:1: ( rule__SimpleEvoCospan__JointAssignment_3 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2061:2: rule__SimpleEvoCospan__JointAssignment_3
            {
            pushFollow(FOLLOW_rule__SimpleEvoCospan__JointAssignment_3_in_rule__SimpleEvoCospan__Group__3__Impl4320);
            rule__SimpleEvoCospan__JointAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getSimpleEvoCospanAccess().getJointAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleEvoCospan__Group__3__Impl"


    // $ANTLR start "rule__SimpleEvoCospan__Group__4"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2071:1: rule__SimpleEvoCospan__Group__4 : rule__SimpleEvoCospan__Group__4__Impl rule__SimpleEvoCospan__Group__5 ;
    public final void rule__SimpleEvoCospan__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2075:1: ( rule__SimpleEvoCospan__Group__4__Impl rule__SimpleEvoCospan__Group__5 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2076:2: rule__SimpleEvoCospan__Group__4__Impl rule__SimpleEvoCospan__Group__5
            {
            pushFollow(FOLLOW_rule__SimpleEvoCospan__Group__4__Impl_in_rule__SimpleEvoCospan__Group__44350);
            rule__SimpleEvoCospan__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SimpleEvoCospan__Group__5_in_rule__SimpleEvoCospan__Group__44353);
            rule__SimpleEvoCospan__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleEvoCospan__Group__4"


    // $ANTLR start "rule__SimpleEvoCospan__Group__4__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2083:1: rule__SimpleEvoCospan__Group__4__Impl : ( '<-' ) ;
    public final void rule__SimpleEvoCospan__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2087:1: ( ( '<-' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2088:1: ( '<-' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2088:1: ( '<-' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2089:1: '<-'
            {
             before(grammarAccess.getSimpleEvoCospanAccess().getLessThanSignHyphenMinusKeyword_4()); 
            match(input,27,FOLLOW_27_in_rule__SimpleEvoCospan__Group__4__Impl4381); 
             after(grammarAccess.getSimpleEvoCospanAccess().getLessThanSignHyphenMinusKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleEvoCospan__Group__4__Impl"


    // $ANTLR start "rule__SimpleEvoCospan__Group__5"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2102:1: rule__SimpleEvoCospan__Group__5 : rule__SimpleEvoCospan__Group__5__Impl rule__SimpleEvoCospan__Group__6 ;
    public final void rule__SimpleEvoCospan__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2106:1: ( rule__SimpleEvoCospan__Group__5__Impl rule__SimpleEvoCospan__Group__6 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2107:2: rule__SimpleEvoCospan__Group__5__Impl rule__SimpleEvoCospan__Group__6
            {
            pushFollow(FOLLOW_rule__SimpleEvoCospan__Group__5__Impl_in_rule__SimpleEvoCospan__Group__54412);
            rule__SimpleEvoCospan__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SimpleEvoCospan__Group__6_in_rule__SimpleEvoCospan__Group__54415);
            rule__SimpleEvoCospan__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleEvoCospan__Group__5"


    // $ANTLR start "rule__SimpleEvoCospan__Group__5__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2114:1: rule__SimpleEvoCospan__Group__5__Impl : ( ( rule__SimpleEvoCospan__RhsAssignment_5 ) ) ;
    public final void rule__SimpleEvoCospan__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2118:1: ( ( ( rule__SimpleEvoCospan__RhsAssignment_5 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2119:1: ( ( rule__SimpleEvoCospan__RhsAssignment_5 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2119:1: ( ( rule__SimpleEvoCospan__RhsAssignment_5 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2120:1: ( rule__SimpleEvoCospan__RhsAssignment_5 )
            {
             before(grammarAccess.getSimpleEvoCospanAccess().getRhsAssignment_5()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2121:1: ( rule__SimpleEvoCospan__RhsAssignment_5 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2121:2: rule__SimpleEvoCospan__RhsAssignment_5
            {
            pushFollow(FOLLOW_rule__SimpleEvoCospan__RhsAssignment_5_in_rule__SimpleEvoCospan__Group__5__Impl4442);
            rule__SimpleEvoCospan__RhsAssignment_5();

            state._fsp--;


            }

             after(grammarAccess.getSimpleEvoCospanAccess().getRhsAssignment_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleEvoCospan__Group__5__Impl"


    // $ANTLR start "rule__SimpleEvoCospan__Group__6"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2131:1: rule__SimpleEvoCospan__Group__6 : rule__SimpleEvoCospan__Group__6__Impl rule__SimpleEvoCospan__Group__7 ;
    public final void rule__SimpleEvoCospan__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2135:1: ( rule__SimpleEvoCospan__Group__6__Impl rule__SimpleEvoCospan__Group__7 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2136:2: rule__SimpleEvoCospan__Group__6__Impl rule__SimpleEvoCospan__Group__7
            {
            pushFollow(FOLLOW_rule__SimpleEvoCospan__Group__6__Impl_in_rule__SimpleEvoCospan__Group__64472);
            rule__SimpleEvoCospan__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SimpleEvoCospan__Group__7_in_rule__SimpleEvoCospan__Group__64475);
            rule__SimpleEvoCospan__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleEvoCospan__Group__6"


    // $ANTLR start "rule__SimpleEvoCospan__Group__6__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2143:1: rule__SimpleEvoCospan__Group__6__Impl : ( ',' ) ;
    public final void rule__SimpleEvoCospan__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2147:1: ( ( ',' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2148:1: ( ',' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2148:1: ( ',' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2149:1: ','
            {
             before(grammarAccess.getSimpleEvoCospanAccess().getCommaKeyword_6()); 
            match(input,29,FOLLOW_29_in_rule__SimpleEvoCospan__Group__6__Impl4503); 
             after(grammarAccess.getSimpleEvoCospanAccess().getCommaKeyword_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleEvoCospan__Group__6__Impl"


    // $ANTLR start "rule__SimpleEvoCospan__Group__7"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2162:1: rule__SimpleEvoCospan__Group__7 : rule__SimpleEvoCospan__Group__7__Impl rule__SimpleEvoCospan__Group__8 ;
    public final void rule__SimpleEvoCospan__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2166:1: ( rule__SimpleEvoCospan__Group__7__Impl rule__SimpleEvoCospan__Group__8 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2167:2: rule__SimpleEvoCospan__Group__7__Impl rule__SimpleEvoCospan__Group__8
            {
            pushFollow(FOLLOW_rule__SimpleEvoCospan__Group__7__Impl_in_rule__SimpleEvoCospan__Group__74534);
            rule__SimpleEvoCospan__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SimpleEvoCospan__Group__8_in_rule__SimpleEvoCospan__Group__74537);
            rule__SimpleEvoCospan__Group__8();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleEvoCospan__Group__7"


    // $ANTLR start "rule__SimpleEvoCospan__Group__7__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2174:1: rule__SimpleEvoCospan__Group__7__Impl : ( ( rule__SimpleEvoCospan__TypeGraphAssignment_7 ) ) ;
    public final void rule__SimpleEvoCospan__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2178:1: ( ( ( rule__SimpleEvoCospan__TypeGraphAssignment_7 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2179:1: ( ( rule__SimpleEvoCospan__TypeGraphAssignment_7 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2179:1: ( ( rule__SimpleEvoCospan__TypeGraphAssignment_7 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2180:1: ( rule__SimpleEvoCospan__TypeGraphAssignment_7 )
            {
             before(grammarAccess.getSimpleEvoCospanAccess().getTypeGraphAssignment_7()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2181:1: ( rule__SimpleEvoCospan__TypeGraphAssignment_7 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2181:2: rule__SimpleEvoCospan__TypeGraphAssignment_7
            {
            pushFollow(FOLLOW_rule__SimpleEvoCospan__TypeGraphAssignment_7_in_rule__SimpleEvoCospan__Group__7__Impl4564);
            rule__SimpleEvoCospan__TypeGraphAssignment_7();

            state._fsp--;


            }

             after(grammarAccess.getSimpleEvoCospanAccess().getTypeGraphAssignment_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleEvoCospan__Group__7__Impl"


    // $ANTLR start "rule__SimpleEvoCospan__Group__8"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2191:1: rule__SimpleEvoCospan__Group__8 : rule__SimpleEvoCospan__Group__8__Impl ;
    public final void rule__SimpleEvoCospan__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2195:1: ( rule__SimpleEvoCospan__Group__8__Impl )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2196:2: rule__SimpleEvoCospan__Group__8__Impl
            {
            pushFollow(FOLLOW_rule__SimpleEvoCospan__Group__8__Impl_in_rule__SimpleEvoCospan__Group__84594);
            rule__SimpleEvoCospan__Group__8__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleEvoCospan__Group__8"


    // $ANTLR start "rule__SimpleEvoCospan__Group__8__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2202:1: rule__SimpleEvoCospan__Group__8__Impl : ( ')' ) ;
    public final void rule__SimpleEvoCospan__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2206:1: ( ( ')' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2207:1: ( ')' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2207:1: ( ')' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2208:1: ')'
            {
             before(grammarAccess.getSimpleEvoCospanAccess().getRightParenthesisKeyword_8()); 
            match(input,23,FOLLOW_23_in_rule__SimpleEvoCospan__Group__8__Impl4622); 
             after(grammarAccess.getSimpleEvoCospanAccess().getRightParenthesisKeyword_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleEvoCospan__Group__8__Impl"


    // $ANTLR start "rule__EvoSpan__Group__0"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2239:1: rule__EvoSpan__Group__0 : rule__EvoSpan__Group__0__Impl rule__EvoSpan__Group__1 ;
    public final void rule__EvoSpan__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2243:1: ( rule__EvoSpan__Group__0__Impl rule__EvoSpan__Group__1 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2244:2: rule__EvoSpan__Group__0__Impl rule__EvoSpan__Group__1
            {
            pushFollow(FOLLOW_rule__EvoSpan__Group__0__Impl_in_rule__EvoSpan__Group__04671);
            rule__EvoSpan__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__EvoSpan__Group__1_in_rule__EvoSpan__Group__04674);
            rule__EvoSpan__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EvoSpan__Group__0"


    // $ANTLR start "rule__EvoSpan__Group__0__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2251:1: rule__EvoSpan__Group__0__Impl : ( 'evolution(' ) ;
    public final void rule__EvoSpan__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2255:1: ( ( 'evolution(' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2256:1: ( 'evolution(' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2256:1: ( 'evolution(' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2257:1: 'evolution('
            {
             before(grammarAccess.getEvoSpanAccess().getEvolutionKeyword_0()); 
            match(input,30,FOLLOW_30_in_rule__EvoSpan__Group__0__Impl4702); 
             after(grammarAccess.getEvoSpanAccess().getEvolutionKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EvoSpan__Group__0__Impl"


    // $ANTLR start "rule__EvoSpan__Group__1"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2270:1: rule__EvoSpan__Group__1 : rule__EvoSpan__Group__1__Impl rule__EvoSpan__Group__2 ;
    public final void rule__EvoSpan__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2274:1: ( rule__EvoSpan__Group__1__Impl rule__EvoSpan__Group__2 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2275:2: rule__EvoSpan__Group__1__Impl rule__EvoSpan__Group__2
            {
            pushFollow(FOLLOW_rule__EvoSpan__Group__1__Impl_in_rule__EvoSpan__Group__14733);
            rule__EvoSpan__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__EvoSpan__Group__2_in_rule__EvoSpan__Group__14736);
            rule__EvoSpan__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EvoSpan__Group__1"


    // $ANTLR start "rule__EvoSpan__Group__1__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2282:1: rule__EvoSpan__Group__1__Impl : ( ( rule__EvoSpan__LhsAssignment_1 ) ) ;
    public final void rule__EvoSpan__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2286:1: ( ( ( rule__EvoSpan__LhsAssignment_1 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2287:1: ( ( rule__EvoSpan__LhsAssignment_1 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2287:1: ( ( rule__EvoSpan__LhsAssignment_1 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2288:1: ( rule__EvoSpan__LhsAssignment_1 )
            {
             before(grammarAccess.getEvoSpanAccess().getLhsAssignment_1()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2289:1: ( rule__EvoSpan__LhsAssignment_1 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2289:2: rule__EvoSpan__LhsAssignment_1
            {
            pushFollow(FOLLOW_rule__EvoSpan__LhsAssignment_1_in_rule__EvoSpan__Group__1__Impl4763);
            rule__EvoSpan__LhsAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getEvoSpanAccess().getLhsAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EvoSpan__Group__1__Impl"


    // $ANTLR start "rule__EvoSpan__Group__2"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2299:1: rule__EvoSpan__Group__2 : rule__EvoSpan__Group__2__Impl rule__EvoSpan__Group__3 ;
    public final void rule__EvoSpan__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2303:1: ( rule__EvoSpan__Group__2__Impl rule__EvoSpan__Group__3 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2304:2: rule__EvoSpan__Group__2__Impl rule__EvoSpan__Group__3
            {
            pushFollow(FOLLOW_rule__EvoSpan__Group__2__Impl_in_rule__EvoSpan__Group__24793);
            rule__EvoSpan__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__EvoSpan__Group__3_in_rule__EvoSpan__Group__24796);
            rule__EvoSpan__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EvoSpan__Group__2"


    // $ANTLR start "rule__EvoSpan__Group__2__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2311:1: rule__EvoSpan__Group__2__Impl : ( '<->' ) ;
    public final void rule__EvoSpan__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2315:1: ( ( '<->' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2316:1: ( '<->' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2316:1: ( '<->' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2317:1: '<->'
            {
             before(grammarAccess.getEvoSpanAccess().getLessThanSignHyphenMinusGreaterThanSignKeyword_2()); 
            match(input,31,FOLLOW_31_in_rule__EvoSpan__Group__2__Impl4824); 
             after(grammarAccess.getEvoSpanAccess().getLessThanSignHyphenMinusGreaterThanSignKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EvoSpan__Group__2__Impl"


    // $ANTLR start "rule__EvoSpan__Group__3"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2330:1: rule__EvoSpan__Group__3 : rule__EvoSpan__Group__3__Impl rule__EvoSpan__Group__4 ;
    public final void rule__EvoSpan__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2334:1: ( rule__EvoSpan__Group__3__Impl rule__EvoSpan__Group__4 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2335:2: rule__EvoSpan__Group__3__Impl rule__EvoSpan__Group__4
            {
            pushFollow(FOLLOW_rule__EvoSpan__Group__3__Impl_in_rule__EvoSpan__Group__34855);
            rule__EvoSpan__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__EvoSpan__Group__4_in_rule__EvoSpan__Group__34858);
            rule__EvoSpan__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EvoSpan__Group__3"


    // $ANTLR start "rule__EvoSpan__Group__3__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2342:1: rule__EvoSpan__Group__3__Impl : ( ( rule__EvoSpan__RhsAssignment_3 ) ) ;
    public final void rule__EvoSpan__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2346:1: ( ( ( rule__EvoSpan__RhsAssignment_3 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2347:1: ( ( rule__EvoSpan__RhsAssignment_3 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2347:1: ( ( rule__EvoSpan__RhsAssignment_3 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2348:1: ( rule__EvoSpan__RhsAssignment_3 )
            {
             before(grammarAccess.getEvoSpanAccess().getRhsAssignment_3()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2349:1: ( rule__EvoSpan__RhsAssignment_3 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2349:2: rule__EvoSpan__RhsAssignment_3
            {
            pushFollow(FOLLOW_rule__EvoSpan__RhsAssignment_3_in_rule__EvoSpan__Group__3__Impl4885);
            rule__EvoSpan__RhsAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getEvoSpanAccess().getRhsAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EvoSpan__Group__3__Impl"


    // $ANTLR start "rule__EvoSpan__Group__4"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2359:1: rule__EvoSpan__Group__4 : rule__EvoSpan__Group__4__Impl rule__EvoSpan__Group__5 ;
    public final void rule__EvoSpan__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2363:1: ( rule__EvoSpan__Group__4__Impl rule__EvoSpan__Group__5 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2364:2: rule__EvoSpan__Group__4__Impl rule__EvoSpan__Group__5
            {
            pushFollow(FOLLOW_rule__EvoSpan__Group__4__Impl_in_rule__EvoSpan__Group__44915);
            rule__EvoSpan__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__EvoSpan__Group__5_in_rule__EvoSpan__Group__44918);
            rule__EvoSpan__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EvoSpan__Group__4"


    // $ANTLR start "rule__EvoSpan__Group__4__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2371:1: rule__EvoSpan__Group__4__Impl : ( ',' ) ;
    public final void rule__EvoSpan__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2375:1: ( ( ',' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2376:1: ( ',' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2376:1: ( ',' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2377:1: ','
            {
             before(grammarAccess.getEvoSpanAccess().getCommaKeyword_4()); 
            match(input,29,FOLLOW_29_in_rule__EvoSpan__Group__4__Impl4946); 
             after(grammarAccess.getEvoSpanAccess().getCommaKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EvoSpan__Group__4__Impl"


    // $ANTLR start "rule__EvoSpan__Group__5"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2390:1: rule__EvoSpan__Group__5 : rule__EvoSpan__Group__5__Impl rule__EvoSpan__Group__6 ;
    public final void rule__EvoSpan__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2394:1: ( rule__EvoSpan__Group__5__Impl rule__EvoSpan__Group__6 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2395:2: rule__EvoSpan__Group__5__Impl rule__EvoSpan__Group__6
            {
            pushFollow(FOLLOW_rule__EvoSpan__Group__5__Impl_in_rule__EvoSpan__Group__54977);
            rule__EvoSpan__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__EvoSpan__Group__6_in_rule__EvoSpan__Group__54980);
            rule__EvoSpan__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EvoSpan__Group__5"


    // $ANTLR start "rule__EvoSpan__Group__5__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2402:1: rule__EvoSpan__Group__5__Impl : ( ( rule__EvoSpan__TypeGraphAssignment_5 ) ) ;
    public final void rule__EvoSpan__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2406:1: ( ( ( rule__EvoSpan__TypeGraphAssignment_5 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2407:1: ( ( rule__EvoSpan__TypeGraphAssignment_5 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2407:1: ( ( rule__EvoSpan__TypeGraphAssignment_5 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2408:1: ( rule__EvoSpan__TypeGraphAssignment_5 )
            {
             before(grammarAccess.getEvoSpanAccess().getTypeGraphAssignment_5()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2409:1: ( rule__EvoSpan__TypeGraphAssignment_5 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2409:2: rule__EvoSpan__TypeGraphAssignment_5
            {
            pushFollow(FOLLOW_rule__EvoSpan__TypeGraphAssignment_5_in_rule__EvoSpan__Group__5__Impl5007);
            rule__EvoSpan__TypeGraphAssignment_5();

            state._fsp--;


            }

             after(grammarAccess.getEvoSpanAccess().getTypeGraphAssignment_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EvoSpan__Group__5__Impl"


    // $ANTLR start "rule__EvoSpan__Group__6"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2419:1: rule__EvoSpan__Group__6 : rule__EvoSpan__Group__6__Impl ;
    public final void rule__EvoSpan__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2423:1: ( rule__EvoSpan__Group__6__Impl )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2424:2: rule__EvoSpan__Group__6__Impl
            {
            pushFollow(FOLLOW_rule__EvoSpan__Group__6__Impl_in_rule__EvoSpan__Group__65037);
            rule__EvoSpan__Group__6__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EvoSpan__Group__6"


    // $ANTLR start "rule__EvoSpan__Group__6__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2430:1: rule__EvoSpan__Group__6__Impl : ( ')' ) ;
    public final void rule__EvoSpan__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2434:1: ( ( ')' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2435:1: ( ')' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2435:1: ( ')' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2436:1: ')'
            {
             before(grammarAccess.getEvoSpanAccess().getRightParenthesisKeyword_6()); 
            match(input,23,FOLLOW_23_in_rule__EvoSpan__Group__6__Impl5065); 
             after(grammarAccess.getEvoSpanAccess().getRightParenthesisKeyword_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EvoSpan__Group__6__Impl"


    // $ANTLR start "rule__EvoCospan__Group__0"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2463:1: rule__EvoCospan__Group__0 : rule__EvoCospan__Group__0__Impl rule__EvoCospan__Group__1 ;
    public final void rule__EvoCospan__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2467:1: ( rule__EvoCospan__Group__0__Impl rule__EvoCospan__Group__1 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2468:2: rule__EvoCospan__Group__0__Impl rule__EvoCospan__Group__1
            {
            pushFollow(FOLLOW_rule__EvoCospan__Group__0__Impl_in_rule__EvoCospan__Group__05110);
            rule__EvoCospan__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__EvoCospan__Group__1_in_rule__EvoCospan__Group__05113);
            rule__EvoCospan__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EvoCospan__Group__0"


    // $ANTLR start "rule__EvoCospan__Group__0__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2475:1: rule__EvoCospan__Group__0__Impl : ( 'evolution(' ) ;
    public final void rule__EvoCospan__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2479:1: ( ( 'evolution(' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2480:1: ( 'evolution(' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2480:1: ( 'evolution(' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2481:1: 'evolution('
            {
             before(grammarAccess.getEvoCospanAccess().getEvolutionKeyword_0()); 
            match(input,30,FOLLOW_30_in_rule__EvoCospan__Group__0__Impl5141); 
             after(grammarAccess.getEvoCospanAccess().getEvolutionKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EvoCospan__Group__0__Impl"


    // $ANTLR start "rule__EvoCospan__Group__1"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2494:1: rule__EvoCospan__Group__1 : rule__EvoCospan__Group__1__Impl rule__EvoCospan__Group__2 ;
    public final void rule__EvoCospan__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2498:1: ( rule__EvoCospan__Group__1__Impl rule__EvoCospan__Group__2 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2499:2: rule__EvoCospan__Group__1__Impl rule__EvoCospan__Group__2
            {
            pushFollow(FOLLOW_rule__EvoCospan__Group__1__Impl_in_rule__EvoCospan__Group__15172);
            rule__EvoCospan__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__EvoCospan__Group__2_in_rule__EvoCospan__Group__15175);
            rule__EvoCospan__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EvoCospan__Group__1"


    // $ANTLR start "rule__EvoCospan__Group__1__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2506:1: rule__EvoCospan__Group__1__Impl : ( ( rule__EvoCospan__LhsAssignment_1 ) ) ;
    public final void rule__EvoCospan__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2510:1: ( ( ( rule__EvoCospan__LhsAssignment_1 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2511:1: ( ( rule__EvoCospan__LhsAssignment_1 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2511:1: ( ( rule__EvoCospan__LhsAssignment_1 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2512:1: ( rule__EvoCospan__LhsAssignment_1 )
            {
             before(grammarAccess.getEvoCospanAccess().getLhsAssignment_1()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2513:1: ( rule__EvoCospan__LhsAssignment_1 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2513:2: rule__EvoCospan__LhsAssignment_1
            {
            pushFollow(FOLLOW_rule__EvoCospan__LhsAssignment_1_in_rule__EvoCospan__Group__1__Impl5202);
            rule__EvoCospan__LhsAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getEvoCospanAccess().getLhsAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EvoCospan__Group__1__Impl"


    // $ANTLR start "rule__EvoCospan__Group__2"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2523:1: rule__EvoCospan__Group__2 : rule__EvoCospan__Group__2__Impl rule__EvoCospan__Group__3 ;
    public final void rule__EvoCospan__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2527:1: ( rule__EvoCospan__Group__2__Impl rule__EvoCospan__Group__3 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2528:2: rule__EvoCospan__Group__2__Impl rule__EvoCospan__Group__3
            {
            pushFollow(FOLLOW_rule__EvoCospan__Group__2__Impl_in_rule__EvoCospan__Group__25232);
            rule__EvoCospan__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__EvoCospan__Group__3_in_rule__EvoCospan__Group__25235);
            rule__EvoCospan__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EvoCospan__Group__2"


    // $ANTLR start "rule__EvoCospan__Group__2__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2535:1: rule__EvoCospan__Group__2__Impl : ( '-><-' ) ;
    public final void rule__EvoCospan__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2539:1: ( ( '-><-' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2540:1: ( '-><-' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2540:1: ( '-><-' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2541:1: '-><-'
            {
             before(grammarAccess.getEvoCospanAccess().getHyphenMinusGreaterThanSignLessThanSignHyphenMinusKeyword_2()); 
            match(input,32,FOLLOW_32_in_rule__EvoCospan__Group__2__Impl5263); 
             after(grammarAccess.getEvoCospanAccess().getHyphenMinusGreaterThanSignLessThanSignHyphenMinusKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EvoCospan__Group__2__Impl"


    // $ANTLR start "rule__EvoCospan__Group__3"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2554:1: rule__EvoCospan__Group__3 : rule__EvoCospan__Group__3__Impl rule__EvoCospan__Group__4 ;
    public final void rule__EvoCospan__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2558:1: ( rule__EvoCospan__Group__3__Impl rule__EvoCospan__Group__4 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2559:2: rule__EvoCospan__Group__3__Impl rule__EvoCospan__Group__4
            {
            pushFollow(FOLLOW_rule__EvoCospan__Group__3__Impl_in_rule__EvoCospan__Group__35294);
            rule__EvoCospan__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__EvoCospan__Group__4_in_rule__EvoCospan__Group__35297);
            rule__EvoCospan__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EvoCospan__Group__3"


    // $ANTLR start "rule__EvoCospan__Group__3__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2566:1: rule__EvoCospan__Group__3__Impl : ( ( rule__EvoCospan__RhsAssignment_3 ) ) ;
    public final void rule__EvoCospan__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2570:1: ( ( ( rule__EvoCospan__RhsAssignment_3 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2571:1: ( ( rule__EvoCospan__RhsAssignment_3 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2571:1: ( ( rule__EvoCospan__RhsAssignment_3 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2572:1: ( rule__EvoCospan__RhsAssignment_3 )
            {
             before(grammarAccess.getEvoCospanAccess().getRhsAssignment_3()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2573:1: ( rule__EvoCospan__RhsAssignment_3 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2573:2: rule__EvoCospan__RhsAssignment_3
            {
            pushFollow(FOLLOW_rule__EvoCospan__RhsAssignment_3_in_rule__EvoCospan__Group__3__Impl5324);
            rule__EvoCospan__RhsAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getEvoCospanAccess().getRhsAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EvoCospan__Group__3__Impl"


    // $ANTLR start "rule__EvoCospan__Group__4"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2583:1: rule__EvoCospan__Group__4 : rule__EvoCospan__Group__4__Impl rule__EvoCospan__Group__5 ;
    public final void rule__EvoCospan__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2587:1: ( rule__EvoCospan__Group__4__Impl rule__EvoCospan__Group__5 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2588:2: rule__EvoCospan__Group__4__Impl rule__EvoCospan__Group__5
            {
            pushFollow(FOLLOW_rule__EvoCospan__Group__4__Impl_in_rule__EvoCospan__Group__45354);
            rule__EvoCospan__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__EvoCospan__Group__5_in_rule__EvoCospan__Group__45357);
            rule__EvoCospan__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EvoCospan__Group__4"


    // $ANTLR start "rule__EvoCospan__Group__4__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2595:1: rule__EvoCospan__Group__4__Impl : ( ',' ) ;
    public final void rule__EvoCospan__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2599:1: ( ( ',' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2600:1: ( ',' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2600:1: ( ',' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2601:1: ','
            {
             before(grammarAccess.getEvoCospanAccess().getCommaKeyword_4()); 
            match(input,29,FOLLOW_29_in_rule__EvoCospan__Group__4__Impl5385); 
             after(grammarAccess.getEvoCospanAccess().getCommaKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EvoCospan__Group__4__Impl"


    // $ANTLR start "rule__EvoCospan__Group__5"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2614:1: rule__EvoCospan__Group__5 : rule__EvoCospan__Group__5__Impl rule__EvoCospan__Group__6 ;
    public final void rule__EvoCospan__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2618:1: ( rule__EvoCospan__Group__5__Impl rule__EvoCospan__Group__6 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2619:2: rule__EvoCospan__Group__5__Impl rule__EvoCospan__Group__6
            {
            pushFollow(FOLLOW_rule__EvoCospan__Group__5__Impl_in_rule__EvoCospan__Group__55416);
            rule__EvoCospan__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__EvoCospan__Group__6_in_rule__EvoCospan__Group__55419);
            rule__EvoCospan__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EvoCospan__Group__5"


    // $ANTLR start "rule__EvoCospan__Group__5__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2626:1: rule__EvoCospan__Group__5__Impl : ( ( rule__EvoCospan__TypeGraphAssignment_5 ) ) ;
    public final void rule__EvoCospan__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2630:1: ( ( ( rule__EvoCospan__TypeGraphAssignment_5 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2631:1: ( ( rule__EvoCospan__TypeGraphAssignment_5 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2631:1: ( ( rule__EvoCospan__TypeGraphAssignment_5 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2632:1: ( rule__EvoCospan__TypeGraphAssignment_5 )
            {
             before(grammarAccess.getEvoCospanAccess().getTypeGraphAssignment_5()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2633:1: ( rule__EvoCospan__TypeGraphAssignment_5 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2633:2: rule__EvoCospan__TypeGraphAssignment_5
            {
            pushFollow(FOLLOW_rule__EvoCospan__TypeGraphAssignment_5_in_rule__EvoCospan__Group__5__Impl5446);
            rule__EvoCospan__TypeGraphAssignment_5();

            state._fsp--;


            }

             after(grammarAccess.getEvoCospanAccess().getTypeGraphAssignment_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EvoCospan__Group__5__Impl"


    // $ANTLR start "rule__EvoCospan__Group__6"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2643:1: rule__EvoCospan__Group__6 : rule__EvoCospan__Group__6__Impl ;
    public final void rule__EvoCospan__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2647:1: ( rule__EvoCospan__Group__6__Impl )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2648:2: rule__EvoCospan__Group__6__Impl
            {
            pushFollow(FOLLOW_rule__EvoCospan__Group__6__Impl_in_rule__EvoCospan__Group__65476);
            rule__EvoCospan__Group__6__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EvoCospan__Group__6"


    // $ANTLR start "rule__EvoCospan__Group__6__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2654:1: rule__EvoCospan__Group__6__Impl : ( ')' ) ;
    public final void rule__EvoCospan__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2658:1: ( ( ')' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2659:1: ( ')' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2659:1: ( ')' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2660:1: ')'
            {
             before(grammarAccess.getEvoCospanAccess().getRightParenthesisKeyword_6()); 
            match(input,23,FOLLOW_23_in_rule__EvoCospan__Group__6__Impl5504); 
             after(grammarAccess.getEvoCospanAccess().getRightParenthesisKeyword_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EvoCospan__Group__6__Impl"


    // $ANTLR start "rule__Specification__Group__0"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2687:1: rule__Specification__Group__0 : rule__Specification__Group__0__Impl rule__Specification__Group__1 ;
    public final void rule__Specification__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2691:1: ( rule__Specification__Group__0__Impl rule__Specification__Group__1 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2692:2: rule__Specification__Group__0__Impl rule__Specification__Group__1
            {
            pushFollow(FOLLOW_rule__Specification__Group__0__Impl_in_rule__Specification__Group__05549);
            rule__Specification__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Specification__Group__1_in_rule__Specification__Group__05552);
            rule__Specification__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Specification__Group__0"


    // $ANTLR start "rule__Specification__Group__0__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2699:1: rule__Specification__Group__0__Impl : ( 'Specification' ) ;
    public final void rule__Specification__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2703:1: ( ( 'Specification' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2704:1: ( 'Specification' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2704:1: ( 'Specification' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2705:1: 'Specification'
            {
             before(grammarAccess.getSpecificationAccess().getSpecificationKeyword_0()); 
            match(input,33,FOLLOW_33_in_rule__Specification__Group__0__Impl5580); 
             after(grammarAccess.getSpecificationAccess().getSpecificationKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Specification__Group__0__Impl"


    // $ANTLR start "rule__Specification__Group__1"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2718:1: rule__Specification__Group__1 : rule__Specification__Group__1__Impl rule__Specification__Group__2 ;
    public final void rule__Specification__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2722:1: ( rule__Specification__Group__1__Impl rule__Specification__Group__2 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2723:2: rule__Specification__Group__1__Impl rule__Specification__Group__2
            {
            pushFollow(FOLLOW_rule__Specification__Group__1__Impl_in_rule__Specification__Group__15611);
            rule__Specification__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Specification__Group__2_in_rule__Specification__Group__15614);
            rule__Specification__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Specification__Group__1"


    // $ANTLR start "rule__Specification__Group__1__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2730:1: rule__Specification__Group__1__Impl : ( ':' ) ;
    public final void rule__Specification__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2734:1: ( ( ':' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2735:1: ( ':' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2735:1: ( ':' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2736:1: ':'
            {
             before(grammarAccess.getSpecificationAccess().getColonKeyword_1()); 
            match(input,34,FOLLOW_34_in_rule__Specification__Group__1__Impl5642); 
             after(grammarAccess.getSpecificationAccess().getColonKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Specification__Group__1__Impl"


    // $ANTLR start "rule__Specification__Group__2"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2749:1: rule__Specification__Group__2 : rule__Specification__Group__2__Impl rule__Specification__Group__3 ;
    public final void rule__Specification__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2753:1: ( rule__Specification__Group__2__Impl rule__Specification__Group__3 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2754:2: rule__Specification__Group__2__Impl rule__Specification__Group__3
            {
            pushFollow(FOLLOW_rule__Specification__Group__2__Impl_in_rule__Specification__Group__25673);
            rule__Specification__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Specification__Group__3_in_rule__Specification__Group__25676);
            rule__Specification__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Specification__Group__2"


    // $ANTLR start "rule__Specification__Group__2__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2761:1: rule__Specification__Group__2__Impl : ( ( rule__Specification__Alternatives_2 ) ) ;
    public final void rule__Specification__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2765:1: ( ( ( rule__Specification__Alternatives_2 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2766:1: ( ( rule__Specification__Alternatives_2 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2766:1: ( ( rule__Specification__Alternatives_2 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2767:1: ( rule__Specification__Alternatives_2 )
            {
             before(grammarAccess.getSpecificationAccess().getAlternatives_2()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2768:1: ( rule__Specification__Alternatives_2 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2768:2: rule__Specification__Alternatives_2
            {
            pushFollow(FOLLOW_rule__Specification__Alternatives_2_in_rule__Specification__Group__2__Impl5703);
            rule__Specification__Alternatives_2();

            state._fsp--;


            }

             after(grammarAccess.getSpecificationAccess().getAlternatives_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Specification__Group__2__Impl"


    // $ANTLR start "rule__Specification__Group__3"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2778:1: rule__Specification__Group__3 : rule__Specification__Group__3__Impl rule__Specification__Group__4 ;
    public final void rule__Specification__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2782:1: ( rule__Specification__Group__3__Impl rule__Specification__Group__4 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2783:2: rule__Specification__Group__3__Impl rule__Specification__Group__4
            {
            pushFollow(FOLLOW_rule__Specification__Group__3__Impl_in_rule__Specification__Group__35733);
            rule__Specification__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Specification__Group__4_in_rule__Specification__Group__35736);
            rule__Specification__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Specification__Group__3"


    // $ANTLR start "rule__Specification__Group__3__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2790:1: rule__Specification__Group__3__Impl : ( '<' ) ;
    public final void rule__Specification__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2794:1: ( ( '<' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2795:1: ( '<' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2795:1: ( '<' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2796:1: '<'
            {
             before(grammarAccess.getSpecificationAccess().getLessThanSignKeyword_3()); 
            match(input,35,FOLLOW_35_in_rule__Specification__Group__3__Impl5764); 
             after(grammarAccess.getSpecificationAccess().getLessThanSignKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Specification__Group__3__Impl"


    // $ANTLR start "rule__Specification__Group__4"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2809:1: rule__Specification__Group__4 : rule__Specification__Group__4__Impl rule__Specification__Group__5 ;
    public final void rule__Specification__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2813:1: ( rule__Specification__Group__4__Impl rule__Specification__Group__5 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2814:2: rule__Specification__Group__4__Impl rule__Specification__Group__5
            {
            pushFollow(FOLLOW_rule__Specification__Group__4__Impl_in_rule__Specification__Group__45795);
            rule__Specification__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Specification__Group__5_in_rule__Specification__Group__45798);
            rule__Specification__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Specification__Group__4"


    // $ANTLR start "rule__Specification__Group__4__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2821:1: rule__Specification__Group__4__Impl : ( ( rule__Specification__SequenceNumberAssignment_4 ) ) ;
    public final void rule__Specification__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2825:1: ( ( ( rule__Specification__SequenceNumberAssignment_4 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2826:1: ( ( rule__Specification__SequenceNumberAssignment_4 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2826:1: ( ( rule__Specification__SequenceNumberAssignment_4 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2827:1: ( rule__Specification__SequenceNumberAssignment_4 )
            {
             before(grammarAccess.getSpecificationAccess().getSequenceNumberAssignment_4()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2828:1: ( rule__Specification__SequenceNumberAssignment_4 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2828:2: rule__Specification__SequenceNumberAssignment_4
            {
            pushFollow(FOLLOW_rule__Specification__SequenceNumberAssignment_4_in_rule__Specification__Group__4__Impl5825);
            rule__Specification__SequenceNumberAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getSpecificationAccess().getSequenceNumberAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Specification__Group__4__Impl"


    // $ANTLR start "rule__Specification__Group__5"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2838:1: rule__Specification__Group__5 : rule__Specification__Group__5__Impl rule__Specification__Group__6 ;
    public final void rule__Specification__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2842:1: ( rule__Specification__Group__5__Impl rule__Specification__Group__6 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2843:2: rule__Specification__Group__5__Impl rule__Specification__Group__6
            {
            pushFollow(FOLLOW_rule__Specification__Group__5__Impl_in_rule__Specification__Group__55855);
            rule__Specification__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Specification__Group__6_in_rule__Specification__Group__55858);
            rule__Specification__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Specification__Group__5"


    // $ANTLR start "rule__Specification__Group__5__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2850:1: rule__Specification__Group__5__Impl : ( '>' ) ;
    public final void rule__Specification__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2854:1: ( ( '>' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2855:1: ( '>' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2855:1: ( '>' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2856:1: '>'
            {
             before(grammarAccess.getSpecificationAccess().getGreaterThanSignKeyword_5()); 
            match(input,36,FOLLOW_36_in_rule__Specification__Group__5__Impl5886); 
             after(grammarAccess.getSpecificationAccess().getGreaterThanSignKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Specification__Group__5__Impl"


    // $ANTLR start "rule__Specification__Group__6"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2869:1: rule__Specification__Group__6 : rule__Specification__Group__6__Impl rule__Specification__Group__7 ;
    public final void rule__Specification__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2873:1: ( rule__Specification__Group__6__Impl rule__Specification__Group__7 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2874:2: rule__Specification__Group__6__Impl rule__Specification__Group__7
            {
            pushFollow(FOLLOW_rule__Specification__Group__6__Impl_in_rule__Specification__Group__65917);
            rule__Specification__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Specification__Group__7_in_rule__Specification__Group__65920);
            rule__Specification__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Specification__Group__6"


    // $ANTLR start "rule__Specification__Group__6__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2881:1: rule__Specification__Group__6__Impl : ( '{' ) ;
    public final void rule__Specification__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2885:1: ( ( '{' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2886:1: ( '{' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2886:1: ( '{' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2887:1: '{'
            {
             before(grammarAccess.getSpecificationAccess().getLeftCurlyBracketKeyword_6()); 
            match(input,37,FOLLOW_37_in_rule__Specification__Group__6__Impl5948); 
             after(grammarAccess.getSpecificationAccess().getLeftCurlyBracketKeyword_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Specification__Group__6__Impl"


    // $ANTLR start "rule__Specification__Group__7"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2900:1: rule__Specification__Group__7 : rule__Specification__Group__7__Impl rule__Specification__Group__8 ;
    public final void rule__Specification__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2904:1: ( rule__Specification__Group__7__Impl rule__Specification__Group__8 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2905:2: rule__Specification__Group__7__Impl rule__Specification__Group__8
            {
            pushFollow(FOLLOW_rule__Specification__Group__7__Impl_in_rule__Specification__Group__75979);
            rule__Specification__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Specification__Group__8_in_rule__Specification__Group__75982);
            rule__Specification__Group__8();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Specification__Group__7"


    // $ANTLR start "rule__Specification__Group__7__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2912:1: rule__Specification__Group__7__Impl : ( ( rule__Specification__GraphAssignment_7 ) ) ;
    public final void rule__Specification__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2916:1: ( ( ( rule__Specification__GraphAssignment_7 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2917:1: ( ( rule__Specification__GraphAssignment_7 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2917:1: ( ( rule__Specification__GraphAssignment_7 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2918:1: ( rule__Specification__GraphAssignment_7 )
            {
             before(grammarAccess.getSpecificationAccess().getGraphAssignment_7()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2919:1: ( rule__Specification__GraphAssignment_7 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2919:2: rule__Specification__GraphAssignment_7
            {
            pushFollow(FOLLOW_rule__Specification__GraphAssignment_7_in_rule__Specification__Group__7__Impl6009);
            rule__Specification__GraphAssignment_7();

            state._fsp--;


            }

             after(grammarAccess.getSpecificationAccess().getGraphAssignment_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Specification__Group__7__Impl"


    // $ANTLR start "rule__Specification__Group__8"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2929:1: rule__Specification__Group__8 : rule__Specification__Group__8__Impl rule__Specification__Group__9 ;
    public final void rule__Specification__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2933:1: ( rule__Specification__Group__8__Impl rule__Specification__Group__9 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2934:2: rule__Specification__Group__8__Impl rule__Specification__Group__9
            {
            pushFollow(FOLLOW_rule__Specification__Group__8__Impl_in_rule__Specification__Group__86039);
            rule__Specification__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Specification__Group__9_in_rule__Specification__Group__86042);
            rule__Specification__Group__9();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Specification__Group__8"


    // $ANTLR start "rule__Specification__Group__8__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2941:1: rule__Specification__Group__8__Impl : ( ( rule__Specification__Group_8__0 )? ) ;
    public final void rule__Specification__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2945:1: ( ( ( rule__Specification__Group_8__0 )? ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2946:1: ( ( rule__Specification__Group_8__0 )? )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2946:1: ( ( rule__Specification__Group_8__0 )? )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2947:1: ( rule__Specification__Group_8__0 )?
            {
             before(grammarAccess.getSpecificationAccess().getGroup_8()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2948:1: ( rule__Specification__Group_8__0 )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==40) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2948:2: rule__Specification__Group_8__0
                    {
                    pushFollow(FOLLOW_rule__Specification__Group_8__0_in_rule__Specification__Group__8__Impl6069);
                    rule__Specification__Group_8__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getSpecificationAccess().getGroup_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Specification__Group__8__Impl"


    // $ANTLR start "rule__Specification__Group__9"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2958:1: rule__Specification__Group__9 : rule__Specification__Group__9__Impl ;
    public final void rule__Specification__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2962:1: ( rule__Specification__Group__9__Impl )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2963:2: rule__Specification__Group__9__Impl
            {
            pushFollow(FOLLOW_rule__Specification__Group__9__Impl_in_rule__Specification__Group__96100);
            rule__Specification__Group__9__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Specification__Group__9"


    // $ANTLR start "rule__Specification__Group__9__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2969:1: rule__Specification__Group__9__Impl : ( '}' ) ;
    public final void rule__Specification__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2973:1: ( ( '}' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2974:1: ( '}' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2974:1: ( '}' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2975:1: '}'
            {
             before(grammarAccess.getSpecificationAccess().getRightCurlyBracketKeyword_9()); 
            match(input,38,FOLLOW_38_in_rule__Specification__Group__9__Impl6128); 
             after(grammarAccess.getSpecificationAccess().getRightCurlyBracketKeyword_9()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Specification__Group__9__Impl"


    // $ANTLR start "rule__Specification__Group_2_1__0"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3008:1: rule__Specification__Group_2_1__0 : rule__Specification__Group_2_1__0__Impl rule__Specification__Group_2_1__1 ;
    public final void rule__Specification__Group_2_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3012:1: ( rule__Specification__Group_2_1__0__Impl rule__Specification__Group_2_1__1 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3013:2: rule__Specification__Group_2_1__0__Impl rule__Specification__Group_2_1__1
            {
            pushFollow(FOLLOW_rule__Specification__Group_2_1__0__Impl_in_rule__Specification__Group_2_1__06179);
            rule__Specification__Group_2_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Specification__Group_2_1__1_in_rule__Specification__Group_2_1__06182);
            rule__Specification__Group_2_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Specification__Group_2_1__0"


    // $ANTLR start "rule__Specification__Group_2_1__0__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3020:1: rule__Specification__Group_2_1__0__Impl : ( '(' ) ;
    public final void rule__Specification__Group_2_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3024:1: ( ( '(' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3025:1: ( '(' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3025:1: ( '(' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3026:1: '('
            {
             before(grammarAccess.getSpecificationAccess().getLeftParenthesisKeyword_2_1_0()); 
            match(input,39,FOLLOW_39_in_rule__Specification__Group_2_1__0__Impl6210); 
             after(grammarAccess.getSpecificationAccess().getLeftParenthesisKeyword_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Specification__Group_2_1__0__Impl"


    // $ANTLR start "rule__Specification__Group_2_1__1"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3039:1: rule__Specification__Group_2_1__1 : rule__Specification__Group_2_1__1__Impl rule__Specification__Group_2_1__2 ;
    public final void rule__Specification__Group_2_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3043:1: ( rule__Specification__Group_2_1__1__Impl rule__Specification__Group_2_1__2 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3044:2: rule__Specification__Group_2_1__1__Impl rule__Specification__Group_2_1__2
            {
            pushFollow(FOLLOW_rule__Specification__Group_2_1__1__Impl_in_rule__Specification__Group_2_1__16241);
            rule__Specification__Group_2_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Specification__Group_2_1__2_in_rule__Specification__Group_2_1__16244);
            rule__Specification__Group_2_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Specification__Group_2_1__1"


    // $ANTLR start "rule__Specification__Group_2_1__1__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3051:1: rule__Specification__Group_2_1__1__Impl : ( ( rule__Specification__TypeAssignment_2_1_1 ) ) ;
    public final void rule__Specification__Group_2_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3055:1: ( ( ( rule__Specification__TypeAssignment_2_1_1 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3056:1: ( ( rule__Specification__TypeAssignment_2_1_1 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3056:1: ( ( rule__Specification__TypeAssignment_2_1_1 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3057:1: ( rule__Specification__TypeAssignment_2_1_1 )
            {
             before(grammarAccess.getSpecificationAccess().getTypeAssignment_2_1_1()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3058:1: ( rule__Specification__TypeAssignment_2_1_1 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3058:2: rule__Specification__TypeAssignment_2_1_1
            {
            pushFollow(FOLLOW_rule__Specification__TypeAssignment_2_1_1_in_rule__Specification__Group_2_1__1__Impl6271);
            rule__Specification__TypeAssignment_2_1_1();

            state._fsp--;


            }

             after(grammarAccess.getSpecificationAccess().getTypeAssignment_2_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Specification__Group_2_1__1__Impl"


    // $ANTLR start "rule__Specification__Group_2_1__2"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3068:1: rule__Specification__Group_2_1__2 : rule__Specification__Group_2_1__2__Impl rule__Specification__Group_2_1__3 ;
    public final void rule__Specification__Group_2_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3072:1: ( rule__Specification__Group_2_1__2__Impl rule__Specification__Group_2_1__3 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3073:2: rule__Specification__Group_2_1__2__Impl rule__Specification__Group_2_1__3
            {
            pushFollow(FOLLOW_rule__Specification__Group_2_1__2__Impl_in_rule__Specification__Group_2_1__26301);
            rule__Specification__Group_2_1__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Specification__Group_2_1__3_in_rule__Specification__Group_2_1__26304);
            rule__Specification__Group_2_1__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Specification__Group_2_1__2"


    // $ANTLR start "rule__Specification__Group_2_1__2__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3080:1: rule__Specification__Group_2_1__2__Impl : ( ',' ) ;
    public final void rule__Specification__Group_2_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3084:1: ( ( ',' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3085:1: ( ',' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3085:1: ( ',' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3086:1: ','
            {
             before(grammarAccess.getSpecificationAccess().getCommaKeyword_2_1_2()); 
            match(input,29,FOLLOW_29_in_rule__Specification__Group_2_1__2__Impl6332); 
             after(grammarAccess.getSpecificationAccess().getCommaKeyword_2_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Specification__Group_2_1__2__Impl"


    // $ANTLR start "rule__Specification__Group_2_1__3"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3099:1: rule__Specification__Group_2_1__3 : rule__Specification__Group_2_1__3__Impl rule__Specification__Group_2_1__4 ;
    public final void rule__Specification__Group_2_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3103:1: ( rule__Specification__Group_2_1__3__Impl rule__Specification__Group_2_1__4 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3104:2: rule__Specification__Group_2_1__3__Impl rule__Specification__Group_2_1__4
            {
            pushFollow(FOLLOW_rule__Specification__Group_2_1__3__Impl_in_rule__Specification__Group_2_1__36363);
            rule__Specification__Group_2_1__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Specification__Group_2_1__4_in_rule__Specification__Group_2_1__36366);
            rule__Specification__Group_2_1__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Specification__Group_2_1__3"


    // $ANTLR start "rule__Specification__Group_2_1__3__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3111:1: rule__Specification__Group_2_1__3__Impl : ( ( rule__Specification__ConstraintSemanticAssignment_2_1_3 ) ) ;
    public final void rule__Specification__Group_2_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3115:1: ( ( ( rule__Specification__ConstraintSemanticAssignment_2_1_3 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3116:1: ( ( rule__Specification__ConstraintSemanticAssignment_2_1_3 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3116:1: ( ( rule__Specification__ConstraintSemanticAssignment_2_1_3 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3117:1: ( rule__Specification__ConstraintSemanticAssignment_2_1_3 )
            {
             before(grammarAccess.getSpecificationAccess().getConstraintSemanticAssignment_2_1_3()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3118:1: ( rule__Specification__ConstraintSemanticAssignment_2_1_3 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3118:2: rule__Specification__ConstraintSemanticAssignment_2_1_3
            {
            pushFollow(FOLLOW_rule__Specification__ConstraintSemanticAssignment_2_1_3_in_rule__Specification__Group_2_1__3__Impl6393);
            rule__Specification__ConstraintSemanticAssignment_2_1_3();

            state._fsp--;


            }

             after(grammarAccess.getSpecificationAccess().getConstraintSemanticAssignment_2_1_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Specification__Group_2_1__3__Impl"


    // $ANTLR start "rule__Specification__Group_2_1__4"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3128:1: rule__Specification__Group_2_1__4 : rule__Specification__Group_2_1__4__Impl ;
    public final void rule__Specification__Group_2_1__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3132:1: ( rule__Specification__Group_2_1__4__Impl )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3133:2: rule__Specification__Group_2_1__4__Impl
            {
            pushFollow(FOLLOW_rule__Specification__Group_2_1__4__Impl_in_rule__Specification__Group_2_1__46423);
            rule__Specification__Group_2_1__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Specification__Group_2_1__4"


    // $ANTLR start "rule__Specification__Group_2_1__4__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3139:1: rule__Specification__Group_2_1__4__Impl : ( ')' ) ;
    public final void rule__Specification__Group_2_1__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3143:1: ( ( ')' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3144:1: ( ')' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3144:1: ( ')' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3145:1: ')'
            {
             before(grammarAccess.getSpecificationAccess().getRightParenthesisKeyword_2_1_4()); 
            match(input,23,FOLLOW_23_in_rule__Specification__Group_2_1__4__Impl6451); 
             after(grammarAccess.getSpecificationAccess().getRightParenthesisKeyword_2_1_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Specification__Group_2_1__4__Impl"


    // $ANTLR start "rule__Specification__Group_8__0"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3168:1: rule__Specification__Group_8__0 : rule__Specification__Group_8__0__Impl rule__Specification__Group_8__1 ;
    public final void rule__Specification__Group_8__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3172:1: ( rule__Specification__Group_8__0__Impl rule__Specification__Group_8__1 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3173:2: rule__Specification__Group_8__0__Impl rule__Specification__Group_8__1
            {
            pushFollow(FOLLOW_rule__Specification__Group_8__0__Impl_in_rule__Specification__Group_8__06492);
            rule__Specification__Group_8__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Specification__Group_8__1_in_rule__Specification__Group_8__06495);
            rule__Specification__Group_8__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Specification__Group_8__0"


    // $ANTLR start "rule__Specification__Group_8__0__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3180:1: rule__Specification__Group_8__0__Impl : ( 'Constraints' ) ;
    public final void rule__Specification__Group_8__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3184:1: ( ( 'Constraints' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3185:1: ( 'Constraints' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3185:1: ( 'Constraints' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3186:1: 'Constraints'
            {
             before(grammarAccess.getSpecificationAccess().getConstraintsKeyword_8_0()); 
            match(input,40,FOLLOW_40_in_rule__Specification__Group_8__0__Impl6523); 
             after(grammarAccess.getSpecificationAccess().getConstraintsKeyword_8_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Specification__Group_8__0__Impl"


    // $ANTLR start "rule__Specification__Group_8__1"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3199:1: rule__Specification__Group_8__1 : rule__Specification__Group_8__1__Impl rule__Specification__Group_8__2 ;
    public final void rule__Specification__Group_8__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3203:1: ( rule__Specification__Group_8__1__Impl rule__Specification__Group_8__2 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3204:2: rule__Specification__Group_8__1__Impl rule__Specification__Group_8__2
            {
            pushFollow(FOLLOW_rule__Specification__Group_8__1__Impl_in_rule__Specification__Group_8__16554);
            rule__Specification__Group_8__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Specification__Group_8__2_in_rule__Specification__Group_8__16557);
            rule__Specification__Group_8__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Specification__Group_8__1"


    // $ANTLR start "rule__Specification__Group_8__1__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3211:1: rule__Specification__Group_8__1__Impl : ( '{' ) ;
    public final void rule__Specification__Group_8__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3215:1: ( ( '{' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3216:1: ( '{' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3216:1: ( '{' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3217:1: '{'
            {
             before(grammarAccess.getSpecificationAccess().getLeftCurlyBracketKeyword_8_1()); 
            match(input,37,FOLLOW_37_in_rule__Specification__Group_8__1__Impl6585); 
             after(grammarAccess.getSpecificationAccess().getLeftCurlyBracketKeyword_8_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Specification__Group_8__1__Impl"


    // $ANTLR start "rule__Specification__Group_8__2"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3230:1: rule__Specification__Group_8__2 : rule__Specification__Group_8__2__Impl rule__Specification__Group_8__3 ;
    public final void rule__Specification__Group_8__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3234:1: ( rule__Specification__Group_8__2__Impl rule__Specification__Group_8__3 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3235:2: rule__Specification__Group_8__2__Impl rule__Specification__Group_8__3
            {
            pushFollow(FOLLOW_rule__Specification__Group_8__2__Impl_in_rule__Specification__Group_8__26616);
            rule__Specification__Group_8__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Specification__Group_8__3_in_rule__Specification__Group_8__26619);
            rule__Specification__Group_8__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Specification__Group_8__2"


    // $ANTLR start "rule__Specification__Group_8__2__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3242:1: rule__Specification__Group_8__2__Impl : ( ( rule__Specification__Group_8_2__0 )? ) ;
    public final void rule__Specification__Group_8__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3246:1: ( ( ( rule__Specification__Group_8_2__0 )? ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3247:1: ( ( rule__Specification__Group_8_2__0 )? )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3247:1: ( ( rule__Specification__Group_8_2__0 )? )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3248:1: ( rule__Specification__Group_8_2__0 )?
            {
             before(grammarAccess.getSpecificationAccess().getGroup_8_2()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3249:1: ( rule__Specification__Group_8_2__0 )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==RULE_ID) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3249:2: rule__Specification__Group_8_2__0
                    {
                    pushFollow(FOLLOW_rule__Specification__Group_8_2__0_in_rule__Specification__Group_8__2__Impl6646);
                    rule__Specification__Group_8_2__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getSpecificationAccess().getGroup_8_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Specification__Group_8__2__Impl"


    // $ANTLR start "rule__Specification__Group_8__3"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3259:1: rule__Specification__Group_8__3 : rule__Specification__Group_8__3__Impl ;
    public final void rule__Specification__Group_8__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3263:1: ( rule__Specification__Group_8__3__Impl )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3264:2: rule__Specification__Group_8__3__Impl
            {
            pushFollow(FOLLOW_rule__Specification__Group_8__3__Impl_in_rule__Specification__Group_8__36677);
            rule__Specification__Group_8__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Specification__Group_8__3"


    // $ANTLR start "rule__Specification__Group_8__3__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3270:1: rule__Specification__Group_8__3__Impl : ( '}' ) ;
    public final void rule__Specification__Group_8__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3274:1: ( ( '}' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3275:1: ( '}' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3275:1: ( '}' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3276:1: '}'
            {
             before(grammarAccess.getSpecificationAccess().getRightCurlyBracketKeyword_8_3()); 
            match(input,38,FOLLOW_38_in_rule__Specification__Group_8__3__Impl6705); 
             after(grammarAccess.getSpecificationAccess().getRightCurlyBracketKeyword_8_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Specification__Group_8__3__Impl"


    // $ANTLR start "rule__Specification__Group_8_2__0"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3297:1: rule__Specification__Group_8_2__0 : rule__Specification__Group_8_2__0__Impl rule__Specification__Group_8_2__1 ;
    public final void rule__Specification__Group_8_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3301:1: ( rule__Specification__Group_8_2__0__Impl rule__Specification__Group_8_2__1 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3302:2: rule__Specification__Group_8_2__0__Impl rule__Specification__Group_8_2__1
            {
            pushFollow(FOLLOW_rule__Specification__Group_8_2__0__Impl_in_rule__Specification__Group_8_2__06744);
            rule__Specification__Group_8_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Specification__Group_8_2__1_in_rule__Specification__Group_8_2__06747);
            rule__Specification__Group_8_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Specification__Group_8_2__0"


    // $ANTLR start "rule__Specification__Group_8_2__0__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3309:1: rule__Specification__Group_8_2__0__Impl : ( ( rule__Specification__ConstraintsAssignment_8_2_0 ) ) ;
    public final void rule__Specification__Group_8_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3313:1: ( ( ( rule__Specification__ConstraintsAssignment_8_2_0 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3314:1: ( ( rule__Specification__ConstraintsAssignment_8_2_0 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3314:1: ( ( rule__Specification__ConstraintsAssignment_8_2_0 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3315:1: ( rule__Specification__ConstraintsAssignment_8_2_0 )
            {
             before(grammarAccess.getSpecificationAccess().getConstraintsAssignment_8_2_0()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3316:1: ( rule__Specification__ConstraintsAssignment_8_2_0 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3316:2: rule__Specification__ConstraintsAssignment_8_2_0
            {
            pushFollow(FOLLOW_rule__Specification__ConstraintsAssignment_8_2_0_in_rule__Specification__Group_8_2__0__Impl6774);
            rule__Specification__ConstraintsAssignment_8_2_0();

            state._fsp--;


            }

             after(grammarAccess.getSpecificationAccess().getConstraintsAssignment_8_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Specification__Group_8_2__0__Impl"


    // $ANTLR start "rule__Specification__Group_8_2__1"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3326:1: rule__Specification__Group_8_2__1 : rule__Specification__Group_8_2__1__Impl ;
    public final void rule__Specification__Group_8_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3330:1: ( rule__Specification__Group_8_2__1__Impl )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3331:2: rule__Specification__Group_8_2__1__Impl
            {
            pushFollow(FOLLOW_rule__Specification__Group_8_2__1__Impl_in_rule__Specification__Group_8_2__16804);
            rule__Specification__Group_8_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Specification__Group_8_2__1"


    // $ANTLR start "rule__Specification__Group_8_2__1__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3337:1: rule__Specification__Group_8_2__1__Impl : ( ( rule__Specification__Group_8_2_1__0 )* ) ;
    public final void rule__Specification__Group_8_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3341:1: ( ( ( rule__Specification__Group_8_2_1__0 )* ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3342:1: ( ( rule__Specification__Group_8_2_1__0 )* )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3342:1: ( ( rule__Specification__Group_8_2_1__0 )* )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3343:1: ( rule__Specification__Group_8_2_1__0 )*
            {
             before(grammarAccess.getSpecificationAccess().getGroup_8_2_1()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3344:1: ( rule__Specification__Group_8_2_1__0 )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==29) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3344:2: rule__Specification__Group_8_2_1__0
            	    {
            	    pushFollow(FOLLOW_rule__Specification__Group_8_2_1__0_in_rule__Specification__Group_8_2__1__Impl6831);
            	    rule__Specification__Group_8_2_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);

             after(grammarAccess.getSpecificationAccess().getGroup_8_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Specification__Group_8_2__1__Impl"


    // $ANTLR start "rule__Specification__Group_8_2_1__0"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3358:1: rule__Specification__Group_8_2_1__0 : rule__Specification__Group_8_2_1__0__Impl rule__Specification__Group_8_2_1__1 ;
    public final void rule__Specification__Group_8_2_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3362:1: ( rule__Specification__Group_8_2_1__0__Impl rule__Specification__Group_8_2_1__1 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3363:2: rule__Specification__Group_8_2_1__0__Impl rule__Specification__Group_8_2_1__1
            {
            pushFollow(FOLLOW_rule__Specification__Group_8_2_1__0__Impl_in_rule__Specification__Group_8_2_1__06866);
            rule__Specification__Group_8_2_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Specification__Group_8_2_1__1_in_rule__Specification__Group_8_2_1__06869);
            rule__Specification__Group_8_2_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Specification__Group_8_2_1__0"


    // $ANTLR start "rule__Specification__Group_8_2_1__0__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3370:1: rule__Specification__Group_8_2_1__0__Impl : ( ',' ) ;
    public final void rule__Specification__Group_8_2_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3374:1: ( ( ',' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3375:1: ( ',' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3375:1: ( ',' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3376:1: ','
            {
             before(grammarAccess.getSpecificationAccess().getCommaKeyword_8_2_1_0()); 
            match(input,29,FOLLOW_29_in_rule__Specification__Group_8_2_1__0__Impl6897); 
             after(grammarAccess.getSpecificationAccess().getCommaKeyword_8_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Specification__Group_8_2_1__0__Impl"


    // $ANTLR start "rule__Specification__Group_8_2_1__1"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3389:1: rule__Specification__Group_8_2_1__1 : rule__Specification__Group_8_2_1__1__Impl ;
    public final void rule__Specification__Group_8_2_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3393:1: ( rule__Specification__Group_8_2_1__1__Impl )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3394:2: rule__Specification__Group_8_2_1__1__Impl
            {
            pushFollow(FOLLOW_rule__Specification__Group_8_2_1__1__Impl_in_rule__Specification__Group_8_2_1__16928);
            rule__Specification__Group_8_2_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Specification__Group_8_2_1__1"


    // $ANTLR start "rule__Specification__Group_8_2_1__1__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3400:1: rule__Specification__Group_8_2_1__1__Impl : ( ( rule__Specification__ConstraintsAssignment_8_2_1_1 ) ) ;
    public final void rule__Specification__Group_8_2_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3404:1: ( ( ( rule__Specification__ConstraintsAssignment_8_2_1_1 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3405:1: ( ( rule__Specification__ConstraintsAssignment_8_2_1_1 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3405:1: ( ( rule__Specification__ConstraintsAssignment_8_2_1_1 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3406:1: ( rule__Specification__ConstraintsAssignment_8_2_1_1 )
            {
             before(grammarAccess.getSpecificationAccess().getConstraintsAssignment_8_2_1_1()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3407:1: ( rule__Specification__ConstraintsAssignment_8_2_1_1 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3407:2: rule__Specification__ConstraintsAssignment_8_2_1_1
            {
            pushFollow(FOLLOW_rule__Specification__ConstraintsAssignment_8_2_1_1_in_rule__Specification__Group_8_2_1__1__Impl6955);
            rule__Specification__ConstraintsAssignment_8_2_1_1();

            state._fsp--;


            }

             after(grammarAccess.getSpecificationAccess().getConstraintsAssignment_8_2_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Specification__Group_8_2_1__1__Impl"


    // $ANTLR start "rule__Constraint__Group__0"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3421:1: rule__Constraint__Group__0 : rule__Constraint__Group__0__Impl rule__Constraint__Group__1 ;
    public final void rule__Constraint__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3425:1: ( rule__Constraint__Group__0__Impl rule__Constraint__Group__1 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3426:2: rule__Constraint__Group__0__Impl rule__Constraint__Group__1
            {
            pushFollow(FOLLOW_rule__Constraint__Group__0__Impl_in_rule__Constraint__Group__06989);
            rule__Constraint__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Constraint__Group__1_in_rule__Constraint__Group__06992);
            rule__Constraint__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constraint__Group__0"


    // $ANTLR start "rule__Constraint__Group__0__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3433:1: rule__Constraint__Group__0__Impl : ( ( rule__Constraint__SignatureAssignment_0 ) ) ;
    public final void rule__Constraint__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3437:1: ( ( ( rule__Constraint__SignatureAssignment_0 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3438:1: ( ( rule__Constraint__SignatureAssignment_0 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3438:1: ( ( rule__Constraint__SignatureAssignment_0 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3439:1: ( rule__Constraint__SignatureAssignment_0 )
            {
             before(grammarAccess.getConstraintAccess().getSignatureAssignment_0()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3440:1: ( rule__Constraint__SignatureAssignment_0 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3440:2: rule__Constraint__SignatureAssignment_0
            {
            pushFollow(FOLLOW_rule__Constraint__SignatureAssignment_0_in_rule__Constraint__Group__0__Impl7019);
            rule__Constraint__SignatureAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getConstraintAccess().getSignatureAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constraint__Group__0__Impl"


    // $ANTLR start "rule__Constraint__Group__1"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3450:1: rule__Constraint__Group__1 : rule__Constraint__Group__1__Impl rule__Constraint__Group__2 ;
    public final void rule__Constraint__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3454:1: ( rule__Constraint__Group__1__Impl rule__Constraint__Group__2 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3455:2: rule__Constraint__Group__1__Impl rule__Constraint__Group__2
            {
            pushFollow(FOLLOW_rule__Constraint__Group__1__Impl_in_rule__Constraint__Group__17049);
            rule__Constraint__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Constraint__Group__2_in_rule__Constraint__Group__17052);
            rule__Constraint__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constraint__Group__1"


    // $ANTLR start "rule__Constraint__Group__1__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3462:1: rule__Constraint__Group__1__Impl : ( '{' ) ;
    public final void rule__Constraint__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3466:1: ( ( '{' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3467:1: ( '{' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3467:1: ( '{' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3468:1: '{'
            {
             before(grammarAccess.getConstraintAccess().getLeftCurlyBracketKeyword_1()); 
            match(input,37,FOLLOW_37_in_rule__Constraint__Group__1__Impl7080); 
             after(grammarAccess.getConstraintAccess().getLeftCurlyBracketKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constraint__Group__1__Impl"


    // $ANTLR start "rule__Constraint__Group__2"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3481:1: rule__Constraint__Group__2 : rule__Constraint__Group__2__Impl rule__Constraint__Group__3 ;
    public final void rule__Constraint__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3485:1: ( rule__Constraint__Group__2__Impl rule__Constraint__Group__3 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3486:2: rule__Constraint__Group__2__Impl rule__Constraint__Group__3
            {
            pushFollow(FOLLOW_rule__Constraint__Group__2__Impl_in_rule__Constraint__Group__27111);
            rule__Constraint__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Constraint__Group__3_in_rule__Constraint__Group__27114);
            rule__Constraint__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constraint__Group__2"


    // $ANTLR start "rule__Constraint__Group__2__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3493:1: rule__Constraint__Group__2__Impl : ( ( rule__Constraint__Group_2__0 ) ) ;
    public final void rule__Constraint__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3497:1: ( ( ( rule__Constraint__Group_2__0 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3498:1: ( ( rule__Constraint__Group_2__0 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3498:1: ( ( rule__Constraint__Group_2__0 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3499:1: ( rule__Constraint__Group_2__0 )
            {
             before(grammarAccess.getConstraintAccess().getGroup_2()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3500:1: ( rule__Constraint__Group_2__0 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3500:2: rule__Constraint__Group_2__0
            {
            pushFollow(FOLLOW_rule__Constraint__Group_2__0_in_rule__Constraint__Group__2__Impl7141);
            rule__Constraint__Group_2__0();

            state._fsp--;


            }

             after(grammarAccess.getConstraintAccess().getGroup_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constraint__Group__2__Impl"


    // $ANTLR start "rule__Constraint__Group__3"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3510:1: rule__Constraint__Group__3 : rule__Constraint__Group__3__Impl ;
    public final void rule__Constraint__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3514:1: ( rule__Constraint__Group__3__Impl )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3515:2: rule__Constraint__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__Constraint__Group__3__Impl_in_rule__Constraint__Group__37171);
            rule__Constraint__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constraint__Group__3"


    // $ANTLR start "rule__Constraint__Group__3__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3521:1: rule__Constraint__Group__3__Impl : ( '}' ) ;
    public final void rule__Constraint__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3525:1: ( ( '}' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3526:1: ( '}' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3526:1: ( '}' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3527:1: '}'
            {
             before(grammarAccess.getConstraintAccess().getRightCurlyBracketKeyword_3()); 
            match(input,38,FOLLOW_38_in_rule__Constraint__Group__3__Impl7199); 
             after(grammarAccess.getConstraintAccess().getRightCurlyBracketKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constraint__Group__3__Impl"


    // $ANTLR start "rule__Constraint__Group_2__0"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3548:1: rule__Constraint__Group_2__0 : rule__Constraint__Group_2__0__Impl rule__Constraint__Group_2__1 ;
    public final void rule__Constraint__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3552:1: ( rule__Constraint__Group_2__0__Impl rule__Constraint__Group_2__1 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3553:2: rule__Constraint__Group_2__0__Impl rule__Constraint__Group_2__1
            {
            pushFollow(FOLLOW_rule__Constraint__Group_2__0__Impl_in_rule__Constraint__Group_2__07238);
            rule__Constraint__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Constraint__Group_2__1_in_rule__Constraint__Group_2__07241);
            rule__Constraint__Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constraint__Group_2__0"


    // $ANTLR start "rule__Constraint__Group_2__0__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3560:1: rule__Constraint__Group_2__0__Impl : ( ( rule__Constraint__ArrowsAssignment_2_0 ) ) ;
    public final void rule__Constraint__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3564:1: ( ( ( rule__Constraint__ArrowsAssignment_2_0 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3565:1: ( ( rule__Constraint__ArrowsAssignment_2_0 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3565:1: ( ( rule__Constraint__ArrowsAssignment_2_0 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3566:1: ( rule__Constraint__ArrowsAssignment_2_0 )
            {
             before(grammarAccess.getConstraintAccess().getArrowsAssignment_2_0()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3567:1: ( rule__Constraint__ArrowsAssignment_2_0 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3567:2: rule__Constraint__ArrowsAssignment_2_0
            {
            pushFollow(FOLLOW_rule__Constraint__ArrowsAssignment_2_0_in_rule__Constraint__Group_2__0__Impl7268);
            rule__Constraint__ArrowsAssignment_2_0();

            state._fsp--;


            }

             after(grammarAccess.getConstraintAccess().getArrowsAssignment_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constraint__Group_2__0__Impl"


    // $ANTLR start "rule__Constraint__Group_2__1"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3577:1: rule__Constraint__Group_2__1 : rule__Constraint__Group_2__1__Impl ;
    public final void rule__Constraint__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3581:1: ( rule__Constraint__Group_2__1__Impl )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3582:2: rule__Constraint__Group_2__1__Impl
            {
            pushFollow(FOLLOW_rule__Constraint__Group_2__1__Impl_in_rule__Constraint__Group_2__17298);
            rule__Constraint__Group_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constraint__Group_2__1"


    // $ANTLR start "rule__Constraint__Group_2__1__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3588:1: rule__Constraint__Group_2__1__Impl : ( ( rule__Constraint__Group_2_1__0 )* ) ;
    public final void rule__Constraint__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3592:1: ( ( ( rule__Constraint__Group_2_1__0 )* ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3593:1: ( ( rule__Constraint__Group_2_1__0 )* )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3593:1: ( ( rule__Constraint__Group_2_1__0 )* )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3594:1: ( rule__Constraint__Group_2_1__0 )*
            {
             before(grammarAccess.getConstraintAccess().getGroup_2_1()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3595:1: ( rule__Constraint__Group_2_1__0 )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==29) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3595:2: rule__Constraint__Group_2_1__0
            	    {
            	    pushFollow(FOLLOW_rule__Constraint__Group_2_1__0_in_rule__Constraint__Group_2__1__Impl7325);
            	    rule__Constraint__Group_2_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);

             after(grammarAccess.getConstraintAccess().getGroup_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constraint__Group_2__1__Impl"


    // $ANTLR start "rule__Constraint__Group_2_1__0"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3609:1: rule__Constraint__Group_2_1__0 : rule__Constraint__Group_2_1__0__Impl rule__Constraint__Group_2_1__1 ;
    public final void rule__Constraint__Group_2_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3613:1: ( rule__Constraint__Group_2_1__0__Impl rule__Constraint__Group_2_1__1 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3614:2: rule__Constraint__Group_2_1__0__Impl rule__Constraint__Group_2_1__1
            {
            pushFollow(FOLLOW_rule__Constraint__Group_2_1__0__Impl_in_rule__Constraint__Group_2_1__07360);
            rule__Constraint__Group_2_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Constraint__Group_2_1__1_in_rule__Constraint__Group_2_1__07363);
            rule__Constraint__Group_2_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constraint__Group_2_1__0"


    // $ANTLR start "rule__Constraint__Group_2_1__0__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3621:1: rule__Constraint__Group_2_1__0__Impl : ( ',' ) ;
    public final void rule__Constraint__Group_2_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3625:1: ( ( ',' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3626:1: ( ',' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3626:1: ( ',' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3627:1: ','
            {
             before(grammarAccess.getConstraintAccess().getCommaKeyword_2_1_0()); 
            match(input,29,FOLLOW_29_in_rule__Constraint__Group_2_1__0__Impl7391); 
             after(grammarAccess.getConstraintAccess().getCommaKeyword_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constraint__Group_2_1__0__Impl"


    // $ANTLR start "rule__Constraint__Group_2_1__1"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3640:1: rule__Constraint__Group_2_1__1 : rule__Constraint__Group_2_1__1__Impl ;
    public final void rule__Constraint__Group_2_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3644:1: ( rule__Constraint__Group_2_1__1__Impl )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3645:2: rule__Constraint__Group_2_1__1__Impl
            {
            pushFollow(FOLLOW_rule__Constraint__Group_2_1__1__Impl_in_rule__Constraint__Group_2_1__17422);
            rule__Constraint__Group_2_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constraint__Group_2_1__1"


    // $ANTLR start "rule__Constraint__Group_2_1__1__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3651:1: rule__Constraint__Group_2_1__1__Impl : ( ( rule__Constraint__ArrowsAssignment_2_1_1 ) ) ;
    public final void rule__Constraint__Group_2_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3655:1: ( ( ( rule__Constraint__ArrowsAssignment_2_1_1 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3656:1: ( ( rule__Constraint__ArrowsAssignment_2_1_1 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3656:1: ( ( rule__Constraint__ArrowsAssignment_2_1_1 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3657:1: ( rule__Constraint__ArrowsAssignment_2_1_1 )
            {
             before(grammarAccess.getConstraintAccess().getArrowsAssignment_2_1_1()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3658:1: ( rule__Constraint__ArrowsAssignment_2_1_1 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3658:2: rule__Constraint__ArrowsAssignment_2_1_1
            {
            pushFollow(FOLLOW_rule__Constraint__ArrowsAssignment_2_1_1_in_rule__Constraint__Group_2_1__1__Impl7449);
            rule__Constraint__ArrowsAssignment_2_1_1();

            state._fsp--;


            }

             after(grammarAccess.getConstraintAccess().getArrowsAssignment_2_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constraint__Group_2_1__1__Impl"


    // $ANTLR start "rule__ConstraintSignature__Group__0"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3672:1: rule__ConstraintSignature__Group__0 : rule__ConstraintSignature__Group__0__Impl rule__ConstraintSignature__Group__1 ;
    public final void rule__ConstraintSignature__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3676:1: ( rule__ConstraintSignature__Group__0__Impl rule__ConstraintSignature__Group__1 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3677:2: rule__ConstraintSignature__Group__0__Impl rule__ConstraintSignature__Group__1
            {
            pushFollow(FOLLOW_rule__ConstraintSignature__Group__0__Impl_in_rule__ConstraintSignature__Group__07483);
            rule__ConstraintSignature__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ConstraintSignature__Group__1_in_rule__ConstraintSignature__Group__07486);
            rule__ConstraintSignature__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConstraintSignature__Group__0"


    // $ANTLR start "rule__ConstraintSignature__Group__0__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3684:1: rule__ConstraintSignature__Group__0__Impl : ( ( rule__ConstraintSignature__IdAssignment_0 ) ) ;
    public final void rule__ConstraintSignature__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3688:1: ( ( ( rule__ConstraintSignature__IdAssignment_0 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3689:1: ( ( rule__ConstraintSignature__IdAssignment_0 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3689:1: ( ( rule__ConstraintSignature__IdAssignment_0 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3690:1: ( rule__ConstraintSignature__IdAssignment_0 )
            {
             before(grammarAccess.getConstraintSignatureAccess().getIdAssignment_0()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3691:1: ( rule__ConstraintSignature__IdAssignment_0 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3691:2: rule__ConstraintSignature__IdAssignment_0
            {
            pushFollow(FOLLOW_rule__ConstraintSignature__IdAssignment_0_in_rule__ConstraintSignature__Group__0__Impl7513);
            rule__ConstraintSignature__IdAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getConstraintSignatureAccess().getIdAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConstraintSignature__Group__0__Impl"


    // $ANTLR start "rule__ConstraintSignature__Group__1"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3701:1: rule__ConstraintSignature__Group__1 : rule__ConstraintSignature__Group__1__Impl rule__ConstraintSignature__Group__2 ;
    public final void rule__ConstraintSignature__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3705:1: ( rule__ConstraintSignature__Group__1__Impl rule__ConstraintSignature__Group__2 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3706:2: rule__ConstraintSignature__Group__1__Impl rule__ConstraintSignature__Group__2
            {
            pushFollow(FOLLOW_rule__ConstraintSignature__Group__1__Impl_in_rule__ConstraintSignature__Group__17543);
            rule__ConstraintSignature__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ConstraintSignature__Group__2_in_rule__ConstraintSignature__Group__17546);
            rule__ConstraintSignature__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConstraintSignature__Group__1"


    // $ANTLR start "rule__ConstraintSignature__Group__1__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3713:1: rule__ConstraintSignature__Group__1__Impl : ( '(' ) ;
    public final void rule__ConstraintSignature__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3717:1: ( ( '(' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3718:1: ( '(' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3718:1: ( '(' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3719:1: '('
            {
             before(grammarAccess.getConstraintSignatureAccess().getLeftParenthesisKeyword_1()); 
            match(input,39,FOLLOW_39_in_rule__ConstraintSignature__Group__1__Impl7574); 
             after(grammarAccess.getConstraintSignatureAccess().getLeftParenthesisKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConstraintSignature__Group__1__Impl"


    // $ANTLR start "rule__ConstraintSignature__Group__2"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3732:1: rule__ConstraintSignature__Group__2 : rule__ConstraintSignature__Group__2__Impl rule__ConstraintSignature__Group__3 ;
    public final void rule__ConstraintSignature__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3736:1: ( rule__ConstraintSignature__Group__2__Impl rule__ConstraintSignature__Group__3 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3737:2: rule__ConstraintSignature__Group__2__Impl rule__ConstraintSignature__Group__3
            {
            pushFollow(FOLLOW_rule__ConstraintSignature__Group__2__Impl_in_rule__ConstraintSignature__Group__27605);
            rule__ConstraintSignature__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ConstraintSignature__Group__3_in_rule__ConstraintSignature__Group__27608);
            rule__ConstraintSignature__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConstraintSignature__Group__2"


    // $ANTLR start "rule__ConstraintSignature__Group__2__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3744:1: rule__ConstraintSignature__Group__2__Impl : ( ( rule__ConstraintSignature__Group_2__0 )? ) ;
    public final void rule__ConstraintSignature__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3748:1: ( ( ( rule__ConstraintSignature__Group_2__0 )? ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3749:1: ( ( rule__ConstraintSignature__Group_2__0 )? )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3749:1: ( ( rule__ConstraintSignature__Group_2__0 )? )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3750:1: ( rule__ConstraintSignature__Group_2__0 )?
            {
             before(grammarAccess.getConstraintSignatureAccess().getGroup_2()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3751:1: ( rule__ConstraintSignature__Group_2__0 )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==RULE_STRING) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3751:2: rule__ConstraintSignature__Group_2__0
                    {
                    pushFollow(FOLLOW_rule__ConstraintSignature__Group_2__0_in_rule__ConstraintSignature__Group__2__Impl7635);
                    rule__ConstraintSignature__Group_2__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getConstraintSignatureAccess().getGroup_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConstraintSignature__Group__2__Impl"


    // $ANTLR start "rule__ConstraintSignature__Group__3"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3761:1: rule__ConstraintSignature__Group__3 : rule__ConstraintSignature__Group__3__Impl ;
    public final void rule__ConstraintSignature__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3765:1: ( rule__ConstraintSignature__Group__3__Impl )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3766:2: rule__ConstraintSignature__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__ConstraintSignature__Group__3__Impl_in_rule__ConstraintSignature__Group__37666);
            rule__ConstraintSignature__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConstraintSignature__Group__3"


    // $ANTLR start "rule__ConstraintSignature__Group__3__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3772:1: rule__ConstraintSignature__Group__3__Impl : ( ')' ) ;
    public final void rule__ConstraintSignature__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3776:1: ( ( ')' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3777:1: ( ')' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3777:1: ( ')' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3778:1: ')'
            {
             before(grammarAccess.getConstraintSignatureAccess().getRightParenthesisKeyword_3()); 
            match(input,23,FOLLOW_23_in_rule__ConstraintSignature__Group__3__Impl7694); 
             after(grammarAccess.getConstraintSignatureAccess().getRightParenthesisKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConstraintSignature__Group__3__Impl"


    // $ANTLR start "rule__ConstraintSignature__Group_2__0"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3799:1: rule__ConstraintSignature__Group_2__0 : rule__ConstraintSignature__Group_2__0__Impl rule__ConstraintSignature__Group_2__1 ;
    public final void rule__ConstraintSignature__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3803:1: ( rule__ConstraintSignature__Group_2__0__Impl rule__ConstraintSignature__Group_2__1 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3804:2: rule__ConstraintSignature__Group_2__0__Impl rule__ConstraintSignature__Group_2__1
            {
            pushFollow(FOLLOW_rule__ConstraintSignature__Group_2__0__Impl_in_rule__ConstraintSignature__Group_2__07733);
            rule__ConstraintSignature__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ConstraintSignature__Group_2__1_in_rule__ConstraintSignature__Group_2__07736);
            rule__ConstraintSignature__Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConstraintSignature__Group_2__0"


    // $ANTLR start "rule__ConstraintSignature__Group_2__0__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3811:1: rule__ConstraintSignature__Group_2__0__Impl : ( ( rule__ConstraintSignature__ParameterAssignment_2_0 ) ) ;
    public final void rule__ConstraintSignature__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3815:1: ( ( ( rule__ConstraintSignature__ParameterAssignment_2_0 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3816:1: ( ( rule__ConstraintSignature__ParameterAssignment_2_0 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3816:1: ( ( rule__ConstraintSignature__ParameterAssignment_2_0 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3817:1: ( rule__ConstraintSignature__ParameterAssignment_2_0 )
            {
             before(grammarAccess.getConstraintSignatureAccess().getParameterAssignment_2_0()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3818:1: ( rule__ConstraintSignature__ParameterAssignment_2_0 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3818:2: rule__ConstraintSignature__ParameterAssignment_2_0
            {
            pushFollow(FOLLOW_rule__ConstraintSignature__ParameterAssignment_2_0_in_rule__ConstraintSignature__Group_2__0__Impl7763);
            rule__ConstraintSignature__ParameterAssignment_2_0();

            state._fsp--;


            }

             after(grammarAccess.getConstraintSignatureAccess().getParameterAssignment_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConstraintSignature__Group_2__0__Impl"


    // $ANTLR start "rule__ConstraintSignature__Group_2__1"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3828:1: rule__ConstraintSignature__Group_2__1 : rule__ConstraintSignature__Group_2__1__Impl ;
    public final void rule__ConstraintSignature__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3832:1: ( rule__ConstraintSignature__Group_2__1__Impl )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3833:2: rule__ConstraintSignature__Group_2__1__Impl
            {
            pushFollow(FOLLOW_rule__ConstraintSignature__Group_2__1__Impl_in_rule__ConstraintSignature__Group_2__17793);
            rule__ConstraintSignature__Group_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConstraintSignature__Group_2__1"


    // $ANTLR start "rule__ConstraintSignature__Group_2__1__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3839:1: rule__ConstraintSignature__Group_2__1__Impl : ( ( rule__ConstraintSignature__Group_2_1__0 )* ) ;
    public final void rule__ConstraintSignature__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3843:1: ( ( ( rule__ConstraintSignature__Group_2_1__0 )* ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3844:1: ( ( rule__ConstraintSignature__Group_2_1__0 )* )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3844:1: ( ( rule__ConstraintSignature__Group_2_1__0 )* )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3845:1: ( rule__ConstraintSignature__Group_2_1__0 )*
            {
             before(grammarAccess.getConstraintSignatureAccess().getGroup_2_1()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3846:1: ( rule__ConstraintSignature__Group_2_1__0 )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==29) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3846:2: rule__ConstraintSignature__Group_2_1__0
            	    {
            	    pushFollow(FOLLOW_rule__ConstraintSignature__Group_2_1__0_in_rule__ConstraintSignature__Group_2__1__Impl7820);
            	    rule__ConstraintSignature__Group_2_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);

             after(grammarAccess.getConstraintSignatureAccess().getGroup_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConstraintSignature__Group_2__1__Impl"


    // $ANTLR start "rule__ConstraintSignature__Group_2_1__0"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3860:1: rule__ConstraintSignature__Group_2_1__0 : rule__ConstraintSignature__Group_2_1__0__Impl rule__ConstraintSignature__Group_2_1__1 ;
    public final void rule__ConstraintSignature__Group_2_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3864:1: ( rule__ConstraintSignature__Group_2_1__0__Impl rule__ConstraintSignature__Group_2_1__1 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3865:2: rule__ConstraintSignature__Group_2_1__0__Impl rule__ConstraintSignature__Group_2_1__1
            {
            pushFollow(FOLLOW_rule__ConstraintSignature__Group_2_1__0__Impl_in_rule__ConstraintSignature__Group_2_1__07855);
            rule__ConstraintSignature__Group_2_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ConstraintSignature__Group_2_1__1_in_rule__ConstraintSignature__Group_2_1__07858);
            rule__ConstraintSignature__Group_2_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConstraintSignature__Group_2_1__0"


    // $ANTLR start "rule__ConstraintSignature__Group_2_1__0__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3872:1: rule__ConstraintSignature__Group_2_1__0__Impl : ( ',' ) ;
    public final void rule__ConstraintSignature__Group_2_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3876:1: ( ( ',' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3877:1: ( ',' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3877:1: ( ',' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3878:1: ','
            {
             before(grammarAccess.getConstraintSignatureAccess().getCommaKeyword_2_1_0()); 
            match(input,29,FOLLOW_29_in_rule__ConstraintSignature__Group_2_1__0__Impl7886); 
             after(grammarAccess.getConstraintSignatureAccess().getCommaKeyword_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConstraintSignature__Group_2_1__0__Impl"


    // $ANTLR start "rule__ConstraintSignature__Group_2_1__1"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3891:1: rule__ConstraintSignature__Group_2_1__1 : rule__ConstraintSignature__Group_2_1__1__Impl ;
    public final void rule__ConstraintSignature__Group_2_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3895:1: ( rule__ConstraintSignature__Group_2_1__1__Impl )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3896:2: rule__ConstraintSignature__Group_2_1__1__Impl
            {
            pushFollow(FOLLOW_rule__ConstraintSignature__Group_2_1__1__Impl_in_rule__ConstraintSignature__Group_2_1__17917);
            rule__ConstraintSignature__Group_2_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConstraintSignature__Group_2_1__1"


    // $ANTLR start "rule__ConstraintSignature__Group_2_1__1__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3902:1: rule__ConstraintSignature__Group_2_1__1__Impl : ( ( rule__ConstraintSignature__ParameterAssignment_2_1_1 ) ) ;
    public final void rule__ConstraintSignature__Group_2_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3906:1: ( ( ( rule__ConstraintSignature__ParameterAssignment_2_1_1 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3907:1: ( ( rule__ConstraintSignature__ParameterAssignment_2_1_1 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3907:1: ( ( rule__ConstraintSignature__ParameterAssignment_2_1_1 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3908:1: ( rule__ConstraintSignature__ParameterAssignment_2_1_1 )
            {
             before(grammarAccess.getConstraintSignatureAccess().getParameterAssignment_2_1_1()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3909:1: ( rule__ConstraintSignature__ParameterAssignment_2_1_1 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3909:2: rule__ConstraintSignature__ParameterAssignment_2_1_1
            {
            pushFollow(FOLLOW_rule__ConstraintSignature__ParameterAssignment_2_1_1_in_rule__ConstraintSignature__Group_2_1__1__Impl7944);
            rule__ConstraintSignature__ParameterAssignment_2_1_1();

            state._fsp--;


            }

             after(grammarAccess.getConstraintSignatureAccess().getParameterAssignment_2_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConstraintSignature__Group_2_1__1__Impl"


    // $ANTLR start "rule__Signature__Group__0"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3923:1: rule__Signature__Group__0 : rule__Signature__Group__0__Impl rule__Signature__Group__1 ;
    public final void rule__Signature__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3927:1: ( rule__Signature__Group__0__Impl rule__Signature__Group__1 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3928:2: rule__Signature__Group__0__Impl rule__Signature__Group__1
            {
            pushFollow(FOLLOW_rule__Signature__Group__0__Impl_in_rule__Signature__Group__07978);
            rule__Signature__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Signature__Group__1_in_rule__Signature__Group__07981);
            rule__Signature__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Signature__Group__0"


    // $ANTLR start "rule__Signature__Group__0__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3935:1: rule__Signature__Group__0__Impl : ( ( rule__Signature__ConstraintSemanticsAssignment_0 ) ) ;
    public final void rule__Signature__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3939:1: ( ( ( rule__Signature__ConstraintSemanticsAssignment_0 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3940:1: ( ( rule__Signature__ConstraintSemanticsAssignment_0 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3940:1: ( ( rule__Signature__ConstraintSemanticsAssignment_0 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3941:1: ( rule__Signature__ConstraintSemanticsAssignment_0 )
            {
             before(grammarAccess.getSignatureAccess().getConstraintSemanticsAssignment_0()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3942:1: ( rule__Signature__ConstraintSemanticsAssignment_0 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3942:2: rule__Signature__ConstraintSemanticsAssignment_0
            {
            pushFollow(FOLLOW_rule__Signature__ConstraintSemanticsAssignment_0_in_rule__Signature__Group__0__Impl8008);
            rule__Signature__ConstraintSemanticsAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getSignatureAccess().getConstraintSemanticsAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Signature__Group__0__Impl"


    // $ANTLR start "rule__Signature__Group__1"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3952:1: rule__Signature__Group__1 : rule__Signature__Group__1__Impl ;
    public final void rule__Signature__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3956:1: ( rule__Signature__Group__1__Impl )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3957:2: rule__Signature__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Signature__Group__1__Impl_in_rule__Signature__Group__18038);
            rule__Signature__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Signature__Group__1"


    // $ANTLR start "rule__Signature__Group__1__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3963:1: rule__Signature__Group__1__Impl : ( ( rule__Signature__Group_1__0 )* ) ;
    public final void rule__Signature__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3967:1: ( ( ( rule__Signature__Group_1__0 )* ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3968:1: ( ( rule__Signature__Group_1__0 )* )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3968:1: ( ( rule__Signature__Group_1__0 )* )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3969:1: ( rule__Signature__Group_1__0 )*
            {
             before(grammarAccess.getSignatureAccess().getGroup_1()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3970:1: ( rule__Signature__Group_1__0 )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==29) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3970:2: rule__Signature__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__Signature__Group_1__0_in_rule__Signature__Group__1__Impl8065);
            	    rule__Signature__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);

             after(grammarAccess.getSignatureAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Signature__Group__1__Impl"


    // $ANTLR start "rule__Signature__Group_1__0"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3984:1: rule__Signature__Group_1__0 : rule__Signature__Group_1__0__Impl rule__Signature__Group_1__1 ;
    public final void rule__Signature__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3988:1: ( rule__Signature__Group_1__0__Impl rule__Signature__Group_1__1 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3989:2: rule__Signature__Group_1__0__Impl rule__Signature__Group_1__1
            {
            pushFollow(FOLLOW_rule__Signature__Group_1__0__Impl_in_rule__Signature__Group_1__08100);
            rule__Signature__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Signature__Group_1__1_in_rule__Signature__Group_1__08103);
            rule__Signature__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Signature__Group_1__0"


    // $ANTLR start "rule__Signature__Group_1__0__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3996:1: rule__Signature__Group_1__0__Impl : ( ',' ) ;
    public final void rule__Signature__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4000:1: ( ( ',' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4001:1: ( ',' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4001:1: ( ',' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4002:1: ','
            {
             before(grammarAccess.getSignatureAccess().getCommaKeyword_1_0()); 
            match(input,29,FOLLOW_29_in_rule__Signature__Group_1__0__Impl8131); 
             after(grammarAccess.getSignatureAccess().getCommaKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Signature__Group_1__0__Impl"


    // $ANTLR start "rule__Signature__Group_1__1"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4015:1: rule__Signature__Group_1__1 : rule__Signature__Group_1__1__Impl ;
    public final void rule__Signature__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4019:1: ( rule__Signature__Group_1__1__Impl )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4020:2: rule__Signature__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__Signature__Group_1__1__Impl_in_rule__Signature__Group_1__18162);
            rule__Signature__Group_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Signature__Group_1__1"


    // $ANTLR start "rule__Signature__Group_1__1__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4026:1: rule__Signature__Group_1__1__Impl : ( ( rule__Signature__ConstraintSemanticsAssignment_1_1 ) ) ;
    public final void rule__Signature__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4030:1: ( ( ( rule__Signature__ConstraintSemanticsAssignment_1_1 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4031:1: ( ( rule__Signature__ConstraintSemanticsAssignment_1_1 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4031:1: ( ( rule__Signature__ConstraintSemanticsAssignment_1_1 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4032:1: ( rule__Signature__ConstraintSemanticsAssignment_1_1 )
            {
             before(grammarAccess.getSignatureAccess().getConstraintSemanticsAssignment_1_1()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4033:1: ( rule__Signature__ConstraintSemanticsAssignment_1_1 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4033:2: rule__Signature__ConstraintSemanticsAssignment_1_1
            {
            pushFollow(FOLLOW_rule__Signature__ConstraintSemanticsAssignment_1_1_in_rule__Signature__Group_1__1__Impl8189);
            rule__Signature__ConstraintSemanticsAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getSignatureAccess().getConstraintSemanticsAssignment_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Signature__Group_1__1__Impl"


    // $ANTLR start "rule__ConstraintSemantic__Group__0"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4047:1: rule__ConstraintSemantic__Group__0 : rule__ConstraintSemantic__Group__0__Impl rule__ConstraintSemantic__Group__1 ;
    public final void rule__ConstraintSemantic__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4051:1: ( rule__ConstraintSemantic__Group__0__Impl rule__ConstraintSemantic__Group__1 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4052:2: rule__ConstraintSemantic__Group__0__Impl rule__ConstraintSemantic__Group__1
            {
            pushFollow(FOLLOW_rule__ConstraintSemantic__Group__0__Impl_in_rule__ConstraintSemantic__Group__08223);
            rule__ConstraintSemantic__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ConstraintSemantic__Group__1_in_rule__ConstraintSemantic__Group__08226);
            rule__ConstraintSemantic__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConstraintSemantic__Group__0"


    // $ANTLR start "rule__ConstraintSemantic__Group__0__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4059:1: rule__ConstraintSemantic__Group__0__Impl : ( ( rule__ConstraintSemantic__IdAssignment_0 ) ) ;
    public final void rule__ConstraintSemantic__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4063:1: ( ( ( rule__ConstraintSemantic__IdAssignment_0 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4064:1: ( ( rule__ConstraintSemantic__IdAssignment_0 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4064:1: ( ( rule__ConstraintSemantic__IdAssignment_0 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4065:1: ( rule__ConstraintSemantic__IdAssignment_0 )
            {
             before(grammarAccess.getConstraintSemanticAccess().getIdAssignment_0()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4066:1: ( rule__ConstraintSemantic__IdAssignment_0 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4066:2: rule__ConstraintSemantic__IdAssignment_0
            {
            pushFollow(FOLLOW_rule__ConstraintSemantic__IdAssignment_0_in_rule__ConstraintSemantic__Group__0__Impl8253);
            rule__ConstraintSemantic__IdAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getConstraintSemanticAccess().getIdAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConstraintSemantic__Group__0__Impl"


    // $ANTLR start "rule__ConstraintSemantic__Group__1"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4076:1: rule__ConstraintSemantic__Group__1 : rule__ConstraintSemantic__Group__1__Impl rule__ConstraintSemantic__Group__2 ;
    public final void rule__ConstraintSemantic__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4080:1: ( rule__ConstraintSemantic__Group__1__Impl rule__ConstraintSemantic__Group__2 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4081:2: rule__ConstraintSemantic__Group__1__Impl rule__ConstraintSemantic__Group__2
            {
            pushFollow(FOLLOW_rule__ConstraintSemantic__Group__1__Impl_in_rule__ConstraintSemantic__Group__18283);
            rule__ConstraintSemantic__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ConstraintSemantic__Group__2_in_rule__ConstraintSemantic__Group__18286);
            rule__ConstraintSemantic__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConstraintSemantic__Group__1"


    // $ANTLR start "rule__ConstraintSemantic__Group__1__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4088:1: rule__ConstraintSemantic__Group__1__Impl : ( '{' ) ;
    public final void rule__ConstraintSemantic__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4092:1: ( ( '{' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4093:1: ( '{' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4093:1: ( '{' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4094:1: '{'
            {
             before(grammarAccess.getConstraintSemanticAccess().getLeftCurlyBracketKeyword_1()); 
            match(input,37,FOLLOW_37_in_rule__ConstraintSemantic__Group__1__Impl8314); 
             after(grammarAccess.getConstraintSemanticAccess().getLeftCurlyBracketKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConstraintSemantic__Group__1__Impl"


    // $ANTLR start "rule__ConstraintSemantic__Group__2"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4107:1: rule__ConstraintSemantic__Group__2 : rule__ConstraintSemantic__Group__2__Impl rule__ConstraintSemantic__Group__3 ;
    public final void rule__ConstraintSemantic__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4111:1: ( rule__ConstraintSemantic__Group__2__Impl rule__ConstraintSemantic__Group__3 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4112:2: rule__ConstraintSemantic__Group__2__Impl rule__ConstraintSemantic__Group__3
            {
            pushFollow(FOLLOW_rule__ConstraintSemantic__Group__2__Impl_in_rule__ConstraintSemantic__Group__28345);
            rule__ConstraintSemantic__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ConstraintSemantic__Group__3_in_rule__ConstraintSemantic__Group__28348);
            rule__ConstraintSemantic__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConstraintSemantic__Group__2"


    // $ANTLR start "rule__ConstraintSemantic__Group__2__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4119:1: rule__ConstraintSemantic__Group__2__Impl : ( ( rule__ConstraintSemantic__Group_2__0 ) ) ;
    public final void rule__ConstraintSemantic__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4123:1: ( ( ( rule__ConstraintSemantic__Group_2__0 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4124:1: ( ( rule__ConstraintSemantic__Group_2__0 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4124:1: ( ( rule__ConstraintSemantic__Group_2__0 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4125:1: ( rule__ConstraintSemantic__Group_2__0 )
            {
             before(grammarAccess.getConstraintSemanticAccess().getGroup_2()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4126:1: ( rule__ConstraintSemantic__Group_2__0 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4126:2: rule__ConstraintSemantic__Group_2__0
            {
            pushFollow(FOLLOW_rule__ConstraintSemantic__Group_2__0_in_rule__ConstraintSemantic__Group__2__Impl8375);
            rule__ConstraintSemantic__Group_2__0();

            state._fsp--;


            }

             after(grammarAccess.getConstraintSemanticAccess().getGroup_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConstraintSemantic__Group__2__Impl"


    // $ANTLR start "rule__ConstraintSemantic__Group__3"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4136:1: rule__ConstraintSemantic__Group__3 : rule__ConstraintSemantic__Group__3__Impl rule__ConstraintSemantic__Group__4 ;
    public final void rule__ConstraintSemantic__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4140:1: ( rule__ConstraintSemantic__Group__3__Impl rule__ConstraintSemantic__Group__4 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4141:2: rule__ConstraintSemantic__Group__3__Impl rule__ConstraintSemantic__Group__4
            {
            pushFollow(FOLLOW_rule__ConstraintSemantic__Group__3__Impl_in_rule__ConstraintSemantic__Group__38405);
            rule__ConstraintSemantic__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ConstraintSemantic__Group__4_in_rule__ConstraintSemantic__Group__38408);
            rule__ConstraintSemantic__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConstraintSemantic__Group__3"


    // $ANTLR start "rule__ConstraintSemantic__Group__3__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4148:1: rule__ConstraintSemantic__Group__3__Impl : ( '}' ) ;
    public final void rule__ConstraintSemantic__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4152:1: ( ( '}' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4153:1: ( '}' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4153:1: ( '}' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4154:1: '}'
            {
             before(grammarAccess.getConstraintSemanticAccess().getRightCurlyBracketKeyword_3()); 
            match(input,38,FOLLOW_38_in_rule__ConstraintSemantic__Group__3__Impl8436); 
             after(grammarAccess.getConstraintSemanticAccess().getRightCurlyBracketKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConstraintSemantic__Group__3__Impl"


    // $ANTLR start "rule__ConstraintSemantic__Group__4"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4167:1: rule__ConstraintSemantic__Group__4 : rule__ConstraintSemantic__Group__4__Impl rule__ConstraintSemantic__Group__5 ;
    public final void rule__ConstraintSemantic__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4171:1: ( rule__ConstraintSemantic__Group__4__Impl rule__ConstraintSemantic__Group__5 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4172:2: rule__ConstraintSemantic__Group__4__Impl rule__ConstraintSemantic__Group__5
            {
            pushFollow(FOLLOW_rule__ConstraintSemantic__Group__4__Impl_in_rule__ConstraintSemantic__Group__48467);
            rule__ConstraintSemantic__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ConstraintSemantic__Group__5_in_rule__ConstraintSemantic__Group__48470);
            rule__ConstraintSemantic__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConstraintSemantic__Group__4"


    // $ANTLR start "rule__ConstraintSemantic__Group__4__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4179:1: rule__ConstraintSemantic__Group__4__Impl : ( '=' ) ;
    public final void rule__ConstraintSemantic__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4183:1: ( ( '=' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4184:1: ( '=' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4184:1: ( '=' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4185:1: '='
            {
             before(grammarAccess.getConstraintSemanticAccess().getEqualsSignKeyword_4()); 
            match(input,41,FOLLOW_41_in_rule__ConstraintSemantic__Group__4__Impl8498); 
             after(grammarAccess.getConstraintSemanticAccess().getEqualsSignKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConstraintSemantic__Group__4__Impl"


    // $ANTLR start "rule__ConstraintSemantic__Group__5"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4198:1: rule__ConstraintSemantic__Group__5 : rule__ConstraintSemantic__Group__5__Impl ;
    public final void rule__ConstraintSemantic__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4202:1: ( rule__ConstraintSemantic__Group__5__Impl )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4203:2: rule__ConstraintSemantic__Group__5__Impl
            {
            pushFollow(FOLLOW_rule__ConstraintSemantic__Group__5__Impl_in_rule__ConstraintSemantic__Group__58529);
            rule__ConstraintSemantic__Group__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConstraintSemantic__Group__5"


    // $ANTLR start "rule__ConstraintSemantic__Group__5__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4209:1: rule__ConstraintSemantic__Group__5__Impl : ( ( rule__ConstraintSemantic__OclAssignment_5 ) ) ;
    public final void rule__ConstraintSemantic__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4213:1: ( ( ( rule__ConstraintSemantic__OclAssignment_5 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4214:1: ( ( rule__ConstraintSemantic__OclAssignment_5 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4214:1: ( ( rule__ConstraintSemantic__OclAssignment_5 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4215:1: ( rule__ConstraintSemantic__OclAssignment_5 )
            {
             before(grammarAccess.getConstraintSemanticAccess().getOclAssignment_5()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4216:1: ( rule__ConstraintSemantic__OclAssignment_5 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4216:2: rule__ConstraintSemantic__OclAssignment_5
            {
            pushFollow(FOLLOW_rule__ConstraintSemantic__OclAssignment_5_in_rule__ConstraintSemantic__Group__5__Impl8556);
            rule__ConstraintSemantic__OclAssignment_5();

            state._fsp--;


            }

             after(grammarAccess.getConstraintSemanticAccess().getOclAssignment_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConstraintSemantic__Group__5__Impl"


    // $ANTLR start "rule__ConstraintSemantic__Group_2__0"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4238:1: rule__ConstraintSemantic__Group_2__0 : rule__ConstraintSemantic__Group_2__0__Impl rule__ConstraintSemantic__Group_2__1 ;
    public final void rule__ConstraintSemantic__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4242:1: ( rule__ConstraintSemantic__Group_2__0__Impl rule__ConstraintSemantic__Group_2__1 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4243:2: rule__ConstraintSemantic__Group_2__0__Impl rule__ConstraintSemantic__Group_2__1
            {
            pushFollow(FOLLOW_rule__ConstraintSemantic__Group_2__0__Impl_in_rule__ConstraintSemantic__Group_2__08598);
            rule__ConstraintSemantic__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ConstraintSemantic__Group_2__1_in_rule__ConstraintSemantic__Group_2__08601);
            rule__ConstraintSemantic__Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConstraintSemantic__Group_2__0"


    // $ANTLR start "rule__ConstraintSemantic__Group_2__0__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4250:1: rule__ConstraintSemantic__Group_2__0__Impl : ( ( rule__ConstraintSemantic__ArrowsAssignment_2_0 ) ) ;
    public final void rule__ConstraintSemantic__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4254:1: ( ( ( rule__ConstraintSemantic__ArrowsAssignment_2_0 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4255:1: ( ( rule__ConstraintSemantic__ArrowsAssignment_2_0 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4255:1: ( ( rule__ConstraintSemantic__ArrowsAssignment_2_0 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4256:1: ( rule__ConstraintSemantic__ArrowsAssignment_2_0 )
            {
             before(grammarAccess.getConstraintSemanticAccess().getArrowsAssignment_2_0()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4257:1: ( rule__ConstraintSemantic__ArrowsAssignment_2_0 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4257:2: rule__ConstraintSemantic__ArrowsAssignment_2_0
            {
            pushFollow(FOLLOW_rule__ConstraintSemantic__ArrowsAssignment_2_0_in_rule__ConstraintSemantic__Group_2__0__Impl8628);
            rule__ConstraintSemantic__ArrowsAssignment_2_0();

            state._fsp--;


            }

             after(grammarAccess.getConstraintSemanticAccess().getArrowsAssignment_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConstraintSemantic__Group_2__0__Impl"


    // $ANTLR start "rule__ConstraintSemantic__Group_2__1"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4267:1: rule__ConstraintSemantic__Group_2__1 : rule__ConstraintSemantic__Group_2__1__Impl ;
    public final void rule__ConstraintSemantic__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4271:1: ( rule__ConstraintSemantic__Group_2__1__Impl )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4272:2: rule__ConstraintSemantic__Group_2__1__Impl
            {
            pushFollow(FOLLOW_rule__ConstraintSemantic__Group_2__1__Impl_in_rule__ConstraintSemantic__Group_2__18658);
            rule__ConstraintSemantic__Group_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConstraintSemantic__Group_2__1"


    // $ANTLR start "rule__ConstraintSemantic__Group_2__1__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4278:1: rule__ConstraintSemantic__Group_2__1__Impl : ( ( rule__ConstraintSemantic__Group_2_1__0 )* ) ;
    public final void rule__ConstraintSemantic__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4282:1: ( ( ( rule__ConstraintSemantic__Group_2_1__0 )* ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4283:1: ( ( rule__ConstraintSemantic__Group_2_1__0 )* )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4283:1: ( ( rule__ConstraintSemantic__Group_2_1__0 )* )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4284:1: ( rule__ConstraintSemantic__Group_2_1__0 )*
            {
             before(grammarAccess.getConstraintSemanticAccess().getGroup_2_1()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4285:1: ( rule__ConstraintSemantic__Group_2_1__0 )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==29) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4285:2: rule__ConstraintSemantic__Group_2_1__0
            	    {
            	    pushFollow(FOLLOW_rule__ConstraintSemantic__Group_2_1__0_in_rule__ConstraintSemantic__Group_2__1__Impl8685);
            	    rule__ConstraintSemantic__Group_2_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);

             after(grammarAccess.getConstraintSemanticAccess().getGroup_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConstraintSemantic__Group_2__1__Impl"


    // $ANTLR start "rule__ConstraintSemantic__Group_2_1__0"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4299:1: rule__ConstraintSemantic__Group_2_1__0 : rule__ConstraintSemantic__Group_2_1__0__Impl rule__ConstraintSemantic__Group_2_1__1 ;
    public final void rule__ConstraintSemantic__Group_2_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4303:1: ( rule__ConstraintSemantic__Group_2_1__0__Impl rule__ConstraintSemantic__Group_2_1__1 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4304:2: rule__ConstraintSemantic__Group_2_1__0__Impl rule__ConstraintSemantic__Group_2_1__1
            {
            pushFollow(FOLLOW_rule__ConstraintSemantic__Group_2_1__0__Impl_in_rule__ConstraintSemantic__Group_2_1__08720);
            rule__ConstraintSemantic__Group_2_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ConstraintSemantic__Group_2_1__1_in_rule__ConstraintSemantic__Group_2_1__08723);
            rule__ConstraintSemantic__Group_2_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConstraintSemantic__Group_2_1__0"


    // $ANTLR start "rule__ConstraintSemantic__Group_2_1__0__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4311:1: rule__ConstraintSemantic__Group_2_1__0__Impl : ( ',' ) ;
    public final void rule__ConstraintSemantic__Group_2_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4315:1: ( ( ',' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4316:1: ( ',' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4316:1: ( ',' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4317:1: ','
            {
             before(grammarAccess.getConstraintSemanticAccess().getCommaKeyword_2_1_0()); 
            match(input,29,FOLLOW_29_in_rule__ConstraintSemantic__Group_2_1__0__Impl8751); 
             after(grammarAccess.getConstraintSemanticAccess().getCommaKeyword_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConstraintSemantic__Group_2_1__0__Impl"


    // $ANTLR start "rule__ConstraintSemantic__Group_2_1__1"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4330:1: rule__ConstraintSemantic__Group_2_1__1 : rule__ConstraintSemantic__Group_2_1__1__Impl ;
    public final void rule__ConstraintSemantic__Group_2_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4334:1: ( rule__ConstraintSemantic__Group_2_1__1__Impl )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4335:2: rule__ConstraintSemantic__Group_2_1__1__Impl
            {
            pushFollow(FOLLOW_rule__ConstraintSemantic__Group_2_1__1__Impl_in_rule__ConstraintSemantic__Group_2_1__18782);
            rule__ConstraintSemantic__Group_2_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConstraintSemantic__Group_2_1__1"


    // $ANTLR start "rule__ConstraintSemantic__Group_2_1__1__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4341:1: rule__ConstraintSemantic__Group_2_1__1__Impl : ( ( rule__ConstraintSemantic__ArrowsAssignment_2_1_1 ) ) ;
    public final void rule__ConstraintSemantic__Group_2_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4345:1: ( ( ( rule__ConstraintSemantic__ArrowsAssignment_2_1_1 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4346:1: ( ( rule__ConstraintSemantic__ArrowsAssignment_2_1_1 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4346:1: ( ( rule__ConstraintSemantic__ArrowsAssignment_2_1_1 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4347:1: ( rule__ConstraintSemantic__ArrowsAssignment_2_1_1 )
            {
             before(grammarAccess.getConstraintSemanticAccess().getArrowsAssignment_2_1_1()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4348:1: ( rule__ConstraintSemantic__ArrowsAssignment_2_1_1 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4348:2: rule__ConstraintSemantic__ArrowsAssignment_2_1_1
            {
            pushFollow(FOLLOW_rule__ConstraintSemantic__ArrowsAssignment_2_1_1_in_rule__ConstraintSemantic__Group_2_1__1__Impl8809);
            rule__ConstraintSemantic__ArrowsAssignment_2_1_1();

            state._fsp--;


            }

             after(grammarAccess.getConstraintSemanticAccess().getArrowsAssignment_2_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConstraintSemantic__Group_2_1__1__Impl"


    // $ANTLR start "rule__Morphism__Group__0"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4362:1: rule__Morphism__Group__0 : rule__Morphism__Group__0__Impl rule__Morphism__Group__1 ;
    public final void rule__Morphism__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4366:1: ( rule__Morphism__Group__0__Impl rule__Morphism__Group__1 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4367:2: rule__Morphism__Group__0__Impl rule__Morphism__Group__1
            {
            pushFollow(FOLLOW_rule__Morphism__Group__0__Impl_in_rule__Morphism__Group__08843);
            rule__Morphism__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Morphism__Group__1_in_rule__Morphism__Group__08846);
            rule__Morphism__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Morphism__Group__0"


    // $ANTLR start "rule__Morphism__Group__0__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4374:1: rule__Morphism__Group__0__Impl : ( RULE_ID ) ;
    public final void rule__Morphism__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4378:1: ( ( RULE_ID ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4379:1: ( RULE_ID )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4379:1: ( RULE_ID )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4380:1: RULE_ID
            {
             before(grammarAccess.getMorphismAccess().getIDTerminalRuleCall_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Morphism__Group__0__Impl8873); 
             after(grammarAccess.getMorphismAccess().getIDTerminalRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Morphism__Group__0__Impl"


    // $ANTLR start "rule__Morphism__Group__1"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4391:1: rule__Morphism__Group__1 : rule__Morphism__Group__1__Impl rule__Morphism__Group__2 ;
    public final void rule__Morphism__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4395:1: ( rule__Morphism__Group__1__Impl rule__Morphism__Group__2 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4396:2: rule__Morphism__Group__1__Impl rule__Morphism__Group__2
            {
            pushFollow(FOLLOW_rule__Morphism__Group__1__Impl_in_rule__Morphism__Group__18902);
            rule__Morphism__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Morphism__Group__2_in_rule__Morphism__Group__18905);
            rule__Morphism__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Morphism__Group__1"


    // $ANTLR start "rule__Morphism__Group__1__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4403:1: rule__Morphism__Group__1__Impl : ( ':=' ) ;
    public final void rule__Morphism__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4407:1: ( ( ':=' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4408:1: ( ':=' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4408:1: ( ':=' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4409:1: ':='
            {
             before(grammarAccess.getMorphismAccess().getColonEqualsSignKeyword_1()); 
            match(input,42,FOLLOW_42_in_rule__Morphism__Group__1__Impl8933); 
             after(grammarAccess.getMorphismAccess().getColonEqualsSignKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Morphism__Group__1__Impl"


    // $ANTLR start "rule__Morphism__Group__2"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4422:1: rule__Morphism__Group__2 : rule__Morphism__Group__2__Impl rule__Morphism__Group__3 ;
    public final void rule__Morphism__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4426:1: ( rule__Morphism__Group__2__Impl rule__Morphism__Group__3 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4427:2: rule__Morphism__Group__2__Impl rule__Morphism__Group__3
            {
            pushFollow(FOLLOW_rule__Morphism__Group__2__Impl_in_rule__Morphism__Group__28964);
            rule__Morphism__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Morphism__Group__3_in_rule__Morphism__Group__28967);
            rule__Morphism__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Morphism__Group__2"


    // $ANTLR start "rule__Morphism__Group__2__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4434:1: rule__Morphism__Group__2__Impl : ( 'Morphism' ) ;
    public final void rule__Morphism__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4438:1: ( ( 'Morphism' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4439:1: ( 'Morphism' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4439:1: ( 'Morphism' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4440:1: 'Morphism'
            {
             before(grammarAccess.getMorphismAccess().getMorphismKeyword_2()); 
            match(input,43,FOLLOW_43_in_rule__Morphism__Group__2__Impl8995); 
             after(grammarAccess.getMorphismAccess().getMorphismKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Morphism__Group__2__Impl"


    // $ANTLR start "rule__Morphism__Group__3"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4453:1: rule__Morphism__Group__3 : rule__Morphism__Group__3__Impl rule__Morphism__Group__4 ;
    public final void rule__Morphism__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4457:1: ( rule__Morphism__Group__3__Impl rule__Morphism__Group__4 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4458:2: rule__Morphism__Group__3__Impl rule__Morphism__Group__4
            {
            pushFollow(FOLLOW_rule__Morphism__Group__3__Impl_in_rule__Morphism__Group__39026);
            rule__Morphism__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Morphism__Group__4_in_rule__Morphism__Group__39029);
            rule__Morphism__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Morphism__Group__3"


    // $ANTLR start "rule__Morphism__Group__3__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4465:1: rule__Morphism__Group__3__Impl : ( '<' ) ;
    public final void rule__Morphism__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4469:1: ( ( '<' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4470:1: ( '<' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4470:1: ( '<' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4471:1: '<'
            {
             before(grammarAccess.getMorphismAccess().getLessThanSignKeyword_3()); 
            match(input,35,FOLLOW_35_in_rule__Morphism__Group__3__Impl9057); 
             after(grammarAccess.getMorphismAccess().getLessThanSignKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Morphism__Group__3__Impl"


    // $ANTLR start "rule__Morphism__Group__4"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4484:1: rule__Morphism__Group__4 : rule__Morphism__Group__4__Impl rule__Morphism__Group__5 ;
    public final void rule__Morphism__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4488:1: ( rule__Morphism__Group__4__Impl rule__Morphism__Group__5 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4489:2: rule__Morphism__Group__4__Impl rule__Morphism__Group__5
            {
            pushFollow(FOLLOW_rule__Morphism__Group__4__Impl_in_rule__Morphism__Group__49088);
            rule__Morphism__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Morphism__Group__5_in_rule__Morphism__Group__49091);
            rule__Morphism__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Morphism__Group__4"


    // $ANTLR start "rule__Morphism__Group__4__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4496:1: rule__Morphism__Group__4__Impl : ( ( rule__Morphism__DomainAssignment_4 ) ) ;
    public final void rule__Morphism__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4500:1: ( ( ( rule__Morphism__DomainAssignment_4 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4501:1: ( ( rule__Morphism__DomainAssignment_4 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4501:1: ( ( rule__Morphism__DomainAssignment_4 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4502:1: ( rule__Morphism__DomainAssignment_4 )
            {
             before(grammarAccess.getMorphismAccess().getDomainAssignment_4()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4503:1: ( rule__Morphism__DomainAssignment_4 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4503:2: rule__Morphism__DomainAssignment_4
            {
            pushFollow(FOLLOW_rule__Morphism__DomainAssignment_4_in_rule__Morphism__Group__4__Impl9118);
            rule__Morphism__DomainAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getMorphismAccess().getDomainAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Morphism__Group__4__Impl"


    // $ANTLR start "rule__Morphism__Group__5"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4513:1: rule__Morphism__Group__5 : rule__Morphism__Group__5__Impl rule__Morphism__Group__6 ;
    public final void rule__Morphism__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4517:1: ( rule__Morphism__Group__5__Impl rule__Morphism__Group__6 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4518:2: rule__Morphism__Group__5__Impl rule__Morphism__Group__6
            {
            pushFollow(FOLLOW_rule__Morphism__Group__5__Impl_in_rule__Morphism__Group__59148);
            rule__Morphism__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Morphism__Group__6_in_rule__Morphism__Group__59151);
            rule__Morphism__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Morphism__Group__5"


    // $ANTLR start "rule__Morphism__Group__5__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4525:1: rule__Morphism__Group__5__Impl : ( ',' ) ;
    public final void rule__Morphism__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4529:1: ( ( ',' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4530:1: ( ',' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4530:1: ( ',' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4531:1: ','
            {
             before(grammarAccess.getMorphismAccess().getCommaKeyword_5()); 
            match(input,29,FOLLOW_29_in_rule__Morphism__Group__5__Impl9179); 
             after(grammarAccess.getMorphismAccess().getCommaKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Morphism__Group__5__Impl"


    // $ANTLR start "rule__Morphism__Group__6"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4544:1: rule__Morphism__Group__6 : rule__Morphism__Group__6__Impl rule__Morphism__Group__7 ;
    public final void rule__Morphism__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4548:1: ( rule__Morphism__Group__6__Impl rule__Morphism__Group__7 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4549:2: rule__Morphism__Group__6__Impl rule__Morphism__Group__7
            {
            pushFollow(FOLLOW_rule__Morphism__Group__6__Impl_in_rule__Morphism__Group__69210);
            rule__Morphism__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Morphism__Group__7_in_rule__Morphism__Group__69213);
            rule__Morphism__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Morphism__Group__6"


    // $ANTLR start "rule__Morphism__Group__6__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4556:1: rule__Morphism__Group__6__Impl : ( ( rule__Morphism__CodmainAssignment_6 ) ) ;
    public final void rule__Morphism__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4560:1: ( ( ( rule__Morphism__CodmainAssignment_6 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4561:1: ( ( rule__Morphism__CodmainAssignment_6 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4561:1: ( ( rule__Morphism__CodmainAssignment_6 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4562:1: ( rule__Morphism__CodmainAssignment_6 )
            {
             before(grammarAccess.getMorphismAccess().getCodmainAssignment_6()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4563:1: ( rule__Morphism__CodmainAssignment_6 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4563:2: rule__Morphism__CodmainAssignment_6
            {
            pushFollow(FOLLOW_rule__Morphism__CodmainAssignment_6_in_rule__Morphism__Group__6__Impl9240);
            rule__Morphism__CodmainAssignment_6();

            state._fsp--;


            }

             after(grammarAccess.getMorphismAccess().getCodmainAssignment_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Morphism__Group__6__Impl"


    // $ANTLR start "rule__Morphism__Group__7"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4573:1: rule__Morphism__Group__7 : rule__Morphism__Group__7__Impl rule__Morphism__Group__8 ;
    public final void rule__Morphism__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4577:1: ( rule__Morphism__Group__7__Impl rule__Morphism__Group__8 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4578:2: rule__Morphism__Group__7__Impl rule__Morphism__Group__8
            {
            pushFollow(FOLLOW_rule__Morphism__Group__7__Impl_in_rule__Morphism__Group__79270);
            rule__Morphism__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Morphism__Group__8_in_rule__Morphism__Group__79273);
            rule__Morphism__Group__8();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Morphism__Group__7"


    // $ANTLR start "rule__Morphism__Group__7__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4585:1: rule__Morphism__Group__7__Impl : ( '>' ) ;
    public final void rule__Morphism__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4589:1: ( ( '>' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4590:1: ( '>' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4590:1: ( '>' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4591:1: '>'
            {
             before(grammarAccess.getMorphismAccess().getGreaterThanSignKeyword_7()); 
            match(input,36,FOLLOW_36_in_rule__Morphism__Group__7__Impl9301); 
             after(grammarAccess.getMorphismAccess().getGreaterThanSignKeyword_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Morphism__Group__7__Impl"


    // $ANTLR start "rule__Morphism__Group__8"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4604:1: rule__Morphism__Group__8 : rule__Morphism__Group__8__Impl rule__Morphism__Group__9 ;
    public final void rule__Morphism__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4608:1: ( rule__Morphism__Group__8__Impl rule__Morphism__Group__9 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4609:2: rule__Morphism__Group__8__Impl rule__Morphism__Group__9
            {
            pushFollow(FOLLOW_rule__Morphism__Group__8__Impl_in_rule__Morphism__Group__89332);
            rule__Morphism__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Morphism__Group__9_in_rule__Morphism__Group__89335);
            rule__Morphism__Group__9();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Morphism__Group__8"


    // $ANTLR start "rule__Morphism__Group__8__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4616:1: rule__Morphism__Group__8__Impl : ( '{' ) ;
    public final void rule__Morphism__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4620:1: ( ( '{' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4621:1: ( '{' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4621:1: ( '{' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4622:1: '{'
            {
             before(grammarAccess.getMorphismAccess().getLeftCurlyBracketKeyword_8()); 
            match(input,37,FOLLOW_37_in_rule__Morphism__Group__8__Impl9363); 
             after(grammarAccess.getMorphismAccess().getLeftCurlyBracketKeyword_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Morphism__Group__8__Impl"


    // $ANTLR start "rule__Morphism__Group__9"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4635:1: rule__Morphism__Group__9 : rule__Morphism__Group__9__Impl rule__Morphism__Group__10 ;
    public final void rule__Morphism__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4639:1: ( rule__Morphism__Group__9__Impl rule__Morphism__Group__10 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4640:2: rule__Morphism__Group__9__Impl rule__Morphism__Group__10
            {
            pushFollow(FOLLOW_rule__Morphism__Group__9__Impl_in_rule__Morphism__Group__99394);
            rule__Morphism__Group__9__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Morphism__Group__10_in_rule__Morphism__Group__99397);
            rule__Morphism__Group__10();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Morphism__Group__9"


    // $ANTLR start "rule__Morphism__Group__9__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4647:1: rule__Morphism__Group__9__Impl : ( ( rule__Morphism__Group_9__0 )? ) ;
    public final void rule__Morphism__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4651:1: ( ( ( rule__Morphism__Group_9__0 )? ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4652:1: ( ( rule__Morphism__Group_9__0 )? )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4652:1: ( ( rule__Morphism__Group_9__0 )? )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4653:1: ( rule__Morphism__Group_9__0 )?
            {
             before(grammarAccess.getMorphismAccess().getGroup_9()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4654:1: ( rule__Morphism__Group_9__0 )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==RULE_ID) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4654:2: rule__Morphism__Group_9__0
                    {
                    pushFollow(FOLLOW_rule__Morphism__Group_9__0_in_rule__Morphism__Group__9__Impl9424);
                    rule__Morphism__Group_9__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getMorphismAccess().getGroup_9()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Morphism__Group__9__Impl"


    // $ANTLR start "rule__Morphism__Group__10"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4664:1: rule__Morphism__Group__10 : rule__Morphism__Group__10__Impl ;
    public final void rule__Morphism__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4668:1: ( rule__Morphism__Group__10__Impl )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4669:2: rule__Morphism__Group__10__Impl
            {
            pushFollow(FOLLOW_rule__Morphism__Group__10__Impl_in_rule__Morphism__Group__109455);
            rule__Morphism__Group__10__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Morphism__Group__10"


    // $ANTLR start "rule__Morphism__Group__10__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4675:1: rule__Morphism__Group__10__Impl : ( '}' ) ;
    public final void rule__Morphism__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4679:1: ( ( '}' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4680:1: ( '}' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4680:1: ( '}' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4681:1: '}'
            {
             before(grammarAccess.getMorphismAccess().getRightCurlyBracketKeyword_10()); 
            match(input,38,FOLLOW_38_in_rule__Morphism__Group__10__Impl9483); 
             after(grammarAccess.getMorphismAccess().getRightCurlyBracketKeyword_10()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Morphism__Group__10__Impl"


    // $ANTLR start "rule__Morphism__Group_9__0"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4716:1: rule__Morphism__Group_9__0 : rule__Morphism__Group_9__0__Impl rule__Morphism__Group_9__1 ;
    public final void rule__Morphism__Group_9__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4720:1: ( rule__Morphism__Group_9__0__Impl rule__Morphism__Group_9__1 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4721:2: rule__Morphism__Group_9__0__Impl rule__Morphism__Group_9__1
            {
            pushFollow(FOLLOW_rule__Morphism__Group_9__0__Impl_in_rule__Morphism__Group_9__09536);
            rule__Morphism__Group_9__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Morphism__Group_9__1_in_rule__Morphism__Group_9__09539);
            rule__Morphism__Group_9__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Morphism__Group_9__0"


    // $ANTLR start "rule__Morphism__Group_9__0__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4728:1: rule__Morphism__Group_9__0__Impl : ( ( rule__Morphism__MappingsAssignment_9_0 ) ) ;
    public final void rule__Morphism__Group_9__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4732:1: ( ( ( rule__Morphism__MappingsAssignment_9_0 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4733:1: ( ( rule__Morphism__MappingsAssignment_9_0 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4733:1: ( ( rule__Morphism__MappingsAssignment_9_0 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4734:1: ( rule__Morphism__MappingsAssignment_9_0 )
            {
             before(grammarAccess.getMorphismAccess().getMappingsAssignment_9_0()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4735:1: ( rule__Morphism__MappingsAssignment_9_0 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4735:2: rule__Morphism__MappingsAssignment_9_0
            {
            pushFollow(FOLLOW_rule__Morphism__MappingsAssignment_9_0_in_rule__Morphism__Group_9__0__Impl9566);
            rule__Morphism__MappingsAssignment_9_0();

            state._fsp--;


            }

             after(grammarAccess.getMorphismAccess().getMappingsAssignment_9_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Morphism__Group_9__0__Impl"


    // $ANTLR start "rule__Morphism__Group_9__1"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4745:1: rule__Morphism__Group_9__1 : rule__Morphism__Group_9__1__Impl ;
    public final void rule__Morphism__Group_9__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4749:1: ( rule__Morphism__Group_9__1__Impl )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4750:2: rule__Morphism__Group_9__1__Impl
            {
            pushFollow(FOLLOW_rule__Morphism__Group_9__1__Impl_in_rule__Morphism__Group_9__19596);
            rule__Morphism__Group_9__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Morphism__Group_9__1"


    // $ANTLR start "rule__Morphism__Group_9__1__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4756:1: rule__Morphism__Group_9__1__Impl : ( ( rule__Morphism__Group_9_1__0 )* ) ;
    public final void rule__Morphism__Group_9__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4760:1: ( ( ( rule__Morphism__Group_9_1__0 )* ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4761:1: ( ( rule__Morphism__Group_9_1__0 )* )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4761:1: ( ( rule__Morphism__Group_9_1__0 )* )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4762:1: ( rule__Morphism__Group_9_1__0 )*
            {
             before(grammarAccess.getMorphismAccess().getGroup_9_1()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4763:1: ( rule__Morphism__Group_9_1__0 )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==29) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4763:2: rule__Morphism__Group_9_1__0
            	    {
            	    pushFollow(FOLLOW_rule__Morphism__Group_9_1__0_in_rule__Morphism__Group_9__1__Impl9623);
            	    rule__Morphism__Group_9_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);

             after(grammarAccess.getMorphismAccess().getGroup_9_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Morphism__Group_9__1__Impl"


    // $ANTLR start "rule__Morphism__Group_9_1__0"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4777:1: rule__Morphism__Group_9_1__0 : rule__Morphism__Group_9_1__0__Impl rule__Morphism__Group_9_1__1 ;
    public final void rule__Morphism__Group_9_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4781:1: ( rule__Morphism__Group_9_1__0__Impl rule__Morphism__Group_9_1__1 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4782:2: rule__Morphism__Group_9_1__0__Impl rule__Morphism__Group_9_1__1
            {
            pushFollow(FOLLOW_rule__Morphism__Group_9_1__0__Impl_in_rule__Morphism__Group_9_1__09658);
            rule__Morphism__Group_9_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Morphism__Group_9_1__1_in_rule__Morphism__Group_9_1__09661);
            rule__Morphism__Group_9_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Morphism__Group_9_1__0"


    // $ANTLR start "rule__Morphism__Group_9_1__0__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4789:1: rule__Morphism__Group_9_1__0__Impl : ( ',' ) ;
    public final void rule__Morphism__Group_9_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4793:1: ( ( ',' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4794:1: ( ',' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4794:1: ( ',' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4795:1: ','
            {
             before(grammarAccess.getMorphismAccess().getCommaKeyword_9_1_0()); 
            match(input,29,FOLLOW_29_in_rule__Morphism__Group_9_1__0__Impl9689); 
             after(grammarAccess.getMorphismAccess().getCommaKeyword_9_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Morphism__Group_9_1__0__Impl"


    // $ANTLR start "rule__Morphism__Group_9_1__1"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4808:1: rule__Morphism__Group_9_1__1 : rule__Morphism__Group_9_1__1__Impl ;
    public final void rule__Morphism__Group_9_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4812:1: ( rule__Morphism__Group_9_1__1__Impl )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4813:2: rule__Morphism__Group_9_1__1__Impl
            {
            pushFollow(FOLLOW_rule__Morphism__Group_9_1__1__Impl_in_rule__Morphism__Group_9_1__19720);
            rule__Morphism__Group_9_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Morphism__Group_9_1__1"


    // $ANTLR start "rule__Morphism__Group_9_1__1__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4819:1: rule__Morphism__Group_9_1__1__Impl : ( ( rule__Morphism__MappingsAssignment_9_1_1 ) ) ;
    public final void rule__Morphism__Group_9_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4823:1: ( ( ( rule__Morphism__MappingsAssignment_9_1_1 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4824:1: ( ( rule__Morphism__MappingsAssignment_9_1_1 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4824:1: ( ( rule__Morphism__MappingsAssignment_9_1_1 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4825:1: ( rule__Morphism__MappingsAssignment_9_1_1 )
            {
             before(grammarAccess.getMorphismAccess().getMappingsAssignment_9_1_1()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4826:1: ( rule__Morphism__MappingsAssignment_9_1_1 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4826:2: rule__Morphism__MappingsAssignment_9_1_1
            {
            pushFollow(FOLLOW_rule__Morphism__MappingsAssignment_9_1_1_in_rule__Morphism__Group_9_1__1__Impl9747);
            rule__Morphism__MappingsAssignment_9_1_1();

            state._fsp--;


            }

             after(grammarAccess.getMorphismAccess().getMappingsAssignment_9_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Morphism__Group_9_1__1__Impl"


    // $ANTLR start "rule__MappingNode__Group__0"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4840:1: rule__MappingNode__Group__0 : rule__MappingNode__Group__0__Impl rule__MappingNode__Group__1 ;
    public final void rule__MappingNode__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4844:1: ( rule__MappingNode__Group__0__Impl rule__MappingNode__Group__1 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4845:2: rule__MappingNode__Group__0__Impl rule__MappingNode__Group__1
            {
            pushFollow(FOLLOW_rule__MappingNode__Group__0__Impl_in_rule__MappingNode__Group__09781);
            rule__MappingNode__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__MappingNode__Group__1_in_rule__MappingNode__Group__09784);
            rule__MappingNode__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MappingNode__Group__0"


    // $ANTLR start "rule__MappingNode__Group__0__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4852:1: rule__MappingNode__Group__0__Impl : ( ( rule__MappingNode__DomainAssignment_0 ) ) ;
    public final void rule__MappingNode__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4856:1: ( ( ( rule__MappingNode__DomainAssignment_0 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4857:1: ( ( rule__MappingNode__DomainAssignment_0 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4857:1: ( ( rule__MappingNode__DomainAssignment_0 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4858:1: ( rule__MappingNode__DomainAssignment_0 )
            {
             before(grammarAccess.getMappingNodeAccess().getDomainAssignment_0()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4859:1: ( rule__MappingNode__DomainAssignment_0 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4859:2: rule__MappingNode__DomainAssignment_0
            {
            pushFollow(FOLLOW_rule__MappingNode__DomainAssignment_0_in_rule__MappingNode__Group__0__Impl9811);
            rule__MappingNode__DomainAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getMappingNodeAccess().getDomainAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MappingNode__Group__0__Impl"


    // $ANTLR start "rule__MappingNode__Group__1"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4869:1: rule__MappingNode__Group__1 : rule__MappingNode__Group__1__Impl rule__MappingNode__Group__2 ;
    public final void rule__MappingNode__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4873:1: ( rule__MappingNode__Group__1__Impl rule__MappingNode__Group__2 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4874:2: rule__MappingNode__Group__1__Impl rule__MappingNode__Group__2
            {
            pushFollow(FOLLOW_rule__MappingNode__Group__1__Impl_in_rule__MappingNode__Group__19841);
            rule__MappingNode__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__MappingNode__Group__2_in_rule__MappingNode__Group__19844);
            rule__MappingNode__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MappingNode__Group__1"


    // $ANTLR start "rule__MappingNode__Group__1__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4881:1: rule__MappingNode__Group__1__Impl : ( '=>' ) ;
    public final void rule__MappingNode__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4885:1: ( ( '=>' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4886:1: ( '=>' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4886:1: ( '=>' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4887:1: '=>'
            {
             before(grammarAccess.getMappingNodeAccess().getEqualsSignGreaterThanSignKeyword_1()); 
            match(input,44,FOLLOW_44_in_rule__MappingNode__Group__1__Impl9872); 
             after(grammarAccess.getMappingNodeAccess().getEqualsSignGreaterThanSignKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MappingNode__Group__1__Impl"


    // $ANTLR start "rule__MappingNode__Group__2"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4900:1: rule__MappingNode__Group__2 : rule__MappingNode__Group__2__Impl ;
    public final void rule__MappingNode__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4904:1: ( rule__MappingNode__Group__2__Impl )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4905:2: rule__MappingNode__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__MappingNode__Group__2__Impl_in_rule__MappingNode__Group__29903);
            rule__MappingNode__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MappingNode__Group__2"


    // $ANTLR start "rule__MappingNode__Group__2__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4911:1: rule__MappingNode__Group__2__Impl : ( ( rule__MappingNode__CodomainAssignment_2 ) ) ;
    public final void rule__MappingNode__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4915:1: ( ( ( rule__MappingNode__CodomainAssignment_2 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4916:1: ( ( rule__MappingNode__CodomainAssignment_2 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4916:1: ( ( rule__MappingNode__CodomainAssignment_2 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4917:1: ( rule__MappingNode__CodomainAssignment_2 )
            {
             before(grammarAccess.getMappingNodeAccess().getCodomainAssignment_2()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4918:1: ( rule__MappingNode__CodomainAssignment_2 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4918:2: rule__MappingNode__CodomainAssignment_2
            {
            pushFollow(FOLLOW_rule__MappingNode__CodomainAssignment_2_in_rule__MappingNode__Group__2__Impl9930);
            rule__MappingNode__CodomainAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getMappingNodeAccess().getCodomainAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MappingNode__Group__2__Impl"


    // $ANTLR start "rule__MappingArrow__Group__0"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4934:1: rule__MappingArrow__Group__0 : rule__MappingArrow__Group__0__Impl rule__MappingArrow__Group__1 ;
    public final void rule__MappingArrow__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4938:1: ( rule__MappingArrow__Group__0__Impl rule__MappingArrow__Group__1 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4939:2: rule__MappingArrow__Group__0__Impl rule__MappingArrow__Group__1
            {
            pushFollow(FOLLOW_rule__MappingArrow__Group__0__Impl_in_rule__MappingArrow__Group__09966);
            rule__MappingArrow__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__MappingArrow__Group__1_in_rule__MappingArrow__Group__09969);
            rule__MappingArrow__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MappingArrow__Group__0"


    // $ANTLR start "rule__MappingArrow__Group__0__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4946:1: rule__MappingArrow__Group__0__Impl : ( ( rule__MappingArrow__DomainAssignment_0 ) ) ;
    public final void rule__MappingArrow__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4950:1: ( ( ( rule__MappingArrow__DomainAssignment_0 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4951:1: ( ( rule__MappingArrow__DomainAssignment_0 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4951:1: ( ( rule__MappingArrow__DomainAssignment_0 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4952:1: ( rule__MappingArrow__DomainAssignment_0 )
            {
             before(grammarAccess.getMappingArrowAccess().getDomainAssignment_0()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4953:1: ( rule__MappingArrow__DomainAssignment_0 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4953:2: rule__MappingArrow__DomainAssignment_0
            {
            pushFollow(FOLLOW_rule__MappingArrow__DomainAssignment_0_in_rule__MappingArrow__Group__0__Impl9996);
            rule__MappingArrow__DomainAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getMappingArrowAccess().getDomainAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MappingArrow__Group__0__Impl"


    // $ANTLR start "rule__MappingArrow__Group__1"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4963:1: rule__MappingArrow__Group__1 : rule__MappingArrow__Group__1__Impl rule__MappingArrow__Group__2 ;
    public final void rule__MappingArrow__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4967:1: ( rule__MappingArrow__Group__1__Impl rule__MappingArrow__Group__2 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4968:2: rule__MappingArrow__Group__1__Impl rule__MappingArrow__Group__2
            {
            pushFollow(FOLLOW_rule__MappingArrow__Group__1__Impl_in_rule__MappingArrow__Group__110026);
            rule__MappingArrow__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__MappingArrow__Group__2_in_rule__MappingArrow__Group__110029);
            rule__MappingArrow__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MappingArrow__Group__1"


    // $ANTLR start "rule__MappingArrow__Group__1__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4975:1: rule__MappingArrow__Group__1__Impl : ( '=>' ) ;
    public final void rule__MappingArrow__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4979:1: ( ( '=>' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4980:1: ( '=>' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4980:1: ( '=>' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4981:1: '=>'
            {
             before(grammarAccess.getMappingArrowAccess().getEqualsSignGreaterThanSignKeyword_1()); 
            match(input,44,FOLLOW_44_in_rule__MappingArrow__Group__1__Impl10057); 
             after(grammarAccess.getMappingArrowAccess().getEqualsSignGreaterThanSignKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MappingArrow__Group__1__Impl"


    // $ANTLR start "rule__MappingArrow__Group__2"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4994:1: rule__MappingArrow__Group__2 : rule__MappingArrow__Group__2__Impl ;
    public final void rule__MappingArrow__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4998:1: ( rule__MappingArrow__Group__2__Impl )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4999:2: rule__MappingArrow__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__MappingArrow__Group__2__Impl_in_rule__MappingArrow__Group__210088);
            rule__MappingArrow__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MappingArrow__Group__2"


    // $ANTLR start "rule__MappingArrow__Group__2__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5005:1: rule__MappingArrow__Group__2__Impl : ( ( rule__MappingArrow__CodmainAssignment_2 ) ) ;
    public final void rule__MappingArrow__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5009:1: ( ( ( rule__MappingArrow__CodmainAssignment_2 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5010:1: ( ( rule__MappingArrow__CodmainAssignment_2 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5010:1: ( ( rule__MappingArrow__CodmainAssignment_2 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5011:1: ( rule__MappingArrow__CodmainAssignment_2 )
            {
             before(grammarAccess.getMappingArrowAccess().getCodmainAssignment_2()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5012:1: ( rule__MappingArrow__CodmainAssignment_2 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5012:2: rule__MappingArrow__CodmainAssignment_2
            {
            pushFollow(FOLLOW_rule__MappingArrow__CodmainAssignment_2_in_rule__MappingArrow__Group__2__Impl10115);
            rule__MappingArrow__CodmainAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getMappingArrowAccess().getCodmainAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MappingArrow__Group__2__Impl"


    // $ANTLR start "rule__ExtSubTGraph__Group__0"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5028:1: rule__ExtSubTGraph__Group__0 : rule__ExtSubTGraph__Group__0__Impl rule__ExtSubTGraph__Group__1 ;
    public final void rule__ExtSubTGraph__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5032:1: ( rule__ExtSubTGraph__Group__0__Impl rule__ExtSubTGraph__Group__1 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5033:2: rule__ExtSubTGraph__Group__0__Impl rule__ExtSubTGraph__Group__1
            {
            pushFollow(FOLLOW_rule__ExtSubTGraph__Group__0__Impl_in_rule__ExtSubTGraph__Group__010151);
            rule__ExtSubTGraph__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ExtSubTGraph__Group__1_in_rule__ExtSubTGraph__Group__010154);
            rule__ExtSubTGraph__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExtSubTGraph__Group__0"


    // $ANTLR start "rule__ExtSubTGraph__Group__0__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5040:1: rule__ExtSubTGraph__Group__0__Impl : ( ( rule__ExtSubTGraph__IdAssignment_0 ) ) ;
    public final void rule__ExtSubTGraph__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5044:1: ( ( ( rule__ExtSubTGraph__IdAssignment_0 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5045:1: ( ( rule__ExtSubTGraph__IdAssignment_0 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5045:1: ( ( rule__ExtSubTGraph__IdAssignment_0 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5046:1: ( rule__ExtSubTGraph__IdAssignment_0 )
            {
             before(grammarAccess.getExtSubTGraphAccess().getIdAssignment_0()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5047:1: ( rule__ExtSubTGraph__IdAssignment_0 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5047:2: rule__ExtSubTGraph__IdAssignment_0
            {
            pushFollow(FOLLOW_rule__ExtSubTGraph__IdAssignment_0_in_rule__ExtSubTGraph__Group__0__Impl10181);
            rule__ExtSubTGraph__IdAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getExtSubTGraphAccess().getIdAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExtSubTGraph__Group__0__Impl"


    // $ANTLR start "rule__ExtSubTGraph__Group__1"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5057:1: rule__ExtSubTGraph__Group__1 : rule__ExtSubTGraph__Group__1__Impl rule__ExtSubTGraph__Group__2 ;
    public final void rule__ExtSubTGraph__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5061:1: ( rule__ExtSubTGraph__Group__1__Impl rule__ExtSubTGraph__Group__2 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5062:2: rule__ExtSubTGraph__Group__1__Impl rule__ExtSubTGraph__Group__2
            {
            pushFollow(FOLLOW_rule__ExtSubTGraph__Group__1__Impl_in_rule__ExtSubTGraph__Group__110211);
            rule__ExtSubTGraph__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ExtSubTGraph__Group__2_in_rule__ExtSubTGraph__Group__110214);
            rule__ExtSubTGraph__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExtSubTGraph__Group__1"


    // $ANTLR start "rule__ExtSubTGraph__Group__1__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5069:1: rule__ExtSubTGraph__Group__1__Impl : ( ':=' ) ;
    public final void rule__ExtSubTGraph__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5073:1: ( ( ':=' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5074:1: ( ':=' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5074:1: ( ':=' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5075:1: ':='
            {
             before(grammarAccess.getExtSubTGraphAccess().getColonEqualsSignKeyword_1()); 
            match(input,42,FOLLOW_42_in_rule__ExtSubTGraph__Group__1__Impl10242); 
             after(grammarAccess.getExtSubTGraphAccess().getColonEqualsSignKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExtSubTGraph__Group__1__Impl"


    // $ANTLR start "rule__ExtSubTGraph__Group__2"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5088:1: rule__ExtSubTGraph__Group__2 : rule__ExtSubTGraph__Group__2__Impl rule__ExtSubTGraph__Group__3 ;
    public final void rule__ExtSubTGraph__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5092:1: ( rule__ExtSubTGraph__Group__2__Impl rule__ExtSubTGraph__Group__3 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5093:2: rule__ExtSubTGraph__Group__2__Impl rule__ExtSubTGraph__Group__3
            {
            pushFollow(FOLLOW_rule__ExtSubTGraph__Group__2__Impl_in_rule__ExtSubTGraph__Group__210273);
            rule__ExtSubTGraph__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ExtSubTGraph__Group__3_in_rule__ExtSubTGraph__Group__210276);
            rule__ExtSubTGraph__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExtSubTGraph__Group__2"


    // $ANTLR start "rule__ExtSubTGraph__Group__2__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5100:1: rule__ExtSubTGraph__Group__2__Impl : ( 'ExtSubTGraph' ) ;
    public final void rule__ExtSubTGraph__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5104:1: ( ( 'ExtSubTGraph' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5105:1: ( 'ExtSubTGraph' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5105:1: ( 'ExtSubTGraph' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5106:1: 'ExtSubTGraph'
            {
             before(grammarAccess.getExtSubTGraphAccess().getExtSubTGraphKeyword_2()); 
            match(input,45,FOLLOW_45_in_rule__ExtSubTGraph__Group__2__Impl10304); 
             after(grammarAccess.getExtSubTGraphAccess().getExtSubTGraphKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExtSubTGraph__Group__2__Impl"


    // $ANTLR start "rule__ExtSubTGraph__Group__3"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5119:1: rule__ExtSubTGraph__Group__3 : rule__ExtSubTGraph__Group__3__Impl rule__ExtSubTGraph__Group__4 ;
    public final void rule__ExtSubTGraph__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5123:1: ( rule__ExtSubTGraph__Group__3__Impl rule__ExtSubTGraph__Group__4 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5124:2: rule__ExtSubTGraph__Group__3__Impl rule__ExtSubTGraph__Group__4
            {
            pushFollow(FOLLOW_rule__ExtSubTGraph__Group__3__Impl_in_rule__ExtSubTGraph__Group__310335);
            rule__ExtSubTGraph__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ExtSubTGraph__Group__4_in_rule__ExtSubTGraph__Group__310338);
            rule__ExtSubTGraph__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExtSubTGraph__Group__3"


    // $ANTLR start "rule__ExtSubTGraph__Group__3__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5131:1: rule__ExtSubTGraph__Group__3__Impl : ( '<' ) ;
    public final void rule__ExtSubTGraph__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5135:1: ( ( '<' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5136:1: ( '<' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5136:1: ( '<' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5137:1: '<'
            {
             before(grammarAccess.getExtSubTGraphAccess().getLessThanSignKeyword_3()); 
            match(input,35,FOLLOW_35_in_rule__ExtSubTGraph__Group__3__Impl10366); 
             after(grammarAccess.getExtSubTGraphAccess().getLessThanSignKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExtSubTGraph__Group__3__Impl"


    // $ANTLR start "rule__ExtSubTGraph__Group__4"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5150:1: rule__ExtSubTGraph__Group__4 : rule__ExtSubTGraph__Group__4__Impl rule__ExtSubTGraph__Group__5 ;
    public final void rule__ExtSubTGraph__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5154:1: ( rule__ExtSubTGraph__Group__4__Impl rule__ExtSubTGraph__Group__5 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5155:2: rule__ExtSubTGraph__Group__4__Impl rule__ExtSubTGraph__Group__5
            {
            pushFollow(FOLLOW_rule__ExtSubTGraph__Group__4__Impl_in_rule__ExtSubTGraph__Group__410397);
            rule__ExtSubTGraph__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ExtSubTGraph__Group__5_in_rule__ExtSubTGraph__Group__410400);
            rule__ExtSubTGraph__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExtSubTGraph__Group__4"


    // $ANTLR start "rule__ExtSubTGraph__Group__4__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5162:1: rule__ExtSubTGraph__Group__4__Impl : ( ( rule__ExtSubTGraph__ExtendsGraphAssignment_4 ) ) ;
    public final void rule__ExtSubTGraph__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5166:1: ( ( ( rule__ExtSubTGraph__ExtendsGraphAssignment_4 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5167:1: ( ( rule__ExtSubTGraph__ExtendsGraphAssignment_4 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5167:1: ( ( rule__ExtSubTGraph__ExtendsGraphAssignment_4 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5168:1: ( rule__ExtSubTGraph__ExtendsGraphAssignment_4 )
            {
             before(grammarAccess.getExtSubTGraphAccess().getExtendsGraphAssignment_4()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5169:1: ( rule__ExtSubTGraph__ExtendsGraphAssignment_4 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5169:2: rule__ExtSubTGraph__ExtendsGraphAssignment_4
            {
            pushFollow(FOLLOW_rule__ExtSubTGraph__ExtendsGraphAssignment_4_in_rule__ExtSubTGraph__Group__4__Impl10427);
            rule__ExtSubTGraph__ExtendsGraphAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getExtSubTGraphAccess().getExtendsGraphAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExtSubTGraph__Group__4__Impl"


    // $ANTLR start "rule__ExtSubTGraph__Group__5"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5179:1: rule__ExtSubTGraph__Group__5 : rule__ExtSubTGraph__Group__5__Impl rule__ExtSubTGraph__Group__6 ;
    public final void rule__ExtSubTGraph__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5183:1: ( rule__ExtSubTGraph__Group__5__Impl rule__ExtSubTGraph__Group__6 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5184:2: rule__ExtSubTGraph__Group__5__Impl rule__ExtSubTGraph__Group__6
            {
            pushFollow(FOLLOW_rule__ExtSubTGraph__Group__5__Impl_in_rule__ExtSubTGraph__Group__510457);
            rule__ExtSubTGraph__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ExtSubTGraph__Group__6_in_rule__ExtSubTGraph__Group__510460);
            rule__ExtSubTGraph__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExtSubTGraph__Group__5"


    // $ANTLR start "rule__ExtSubTGraph__Group__5__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5191:1: rule__ExtSubTGraph__Group__5__Impl : ( '>' ) ;
    public final void rule__ExtSubTGraph__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5195:1: ( ( '>' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5196:1: ( '>' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5196:1: ( '>' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5197:1: '>'
            {
             before(grammarAccess.getExtSubTGraphAccess().getGreaterThanSignKeyword_5()); 
            match(input,36,FOLLOW_36_in_rule__ExtSubTGraph__Group__5__Impl10488); 
             after(grammarAccess.getExtSubTGraphAccess().getGreaterThanSignKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExtSubTGraph__Group__5__Impl"


    // $ANTLR start "rule__ExtSubTGraph__Group__6"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5210:1: rule__ExtSubTGraph__Group__6 : rule__ExtSubTGraph__Group__6__Impl rule__ExtSubTGraph__Group__7 ;
    public final void rule__ExtSubTGraph__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5214:1: ( rule__ExtSubTGraph__Group__6__Impl rule__ExtSubTGraph__Group__7 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5215:2: rule__ExtSubTGraph__Group__6__Impl rule__ExtSubTGraph__Group__7
            {
            pushFollow(FOLLOW_rule__ExtSubTGraph__Group__6__Impl_in_rule__ExtSubTGraph__Group__610519);
            rule__ExtSubTGraph__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ExtSubTGraph__Group__7_in_rule__ExtSubTGraph__Group__610522);
            rule__ExtSubTGraph__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExtSubTGraph__Group__6"


    // $ANTLR start "rule__ExtSubTGraph__Group__6__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5222:1: rule__ExtSubTGraph__Group__6__Impl : ( '{' ) ;
    public final void rule__ExtSubTGraph__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5226:1: ( ( '{' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5227:1: ( '{' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5227:1: ( '{' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5228:1: '{'
            {
             before(grammarAccess.getExtSubTGraphAccess().getLeftCurlyBracketKeyword_6()); 
            match(input,37,FOLLOW_37_in_rule__ExtSubTGraph__Group__6__Impl10550); 
             after(grammarAccess.getExtSubTGraphAccess().getLeftCurlyBracketKeyword_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExtSubTGraph__Group__6__Impl"


    // $ANTLR start "rule__ExtSubTGraph__Group__7"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5241:1: rule__ExtSubTGraph__Group__7 : rule__ExtSubTGraph__Group__7__Impl rule__ExtSubTGraph__Group__8 ;
    public final void rule__ExtSubTGraph__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5245:1: ( rule__ExtSubTGraph__Group__7__Impl rule__ExtSubTGraph__Group__8 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5246:2: rule__ExtSubTGraph__Group__7__Impl rule__ExtSubTGraph__Group__8
            {
            pushFollow(FOLLOW_rule__ExtSubTGraph__Group__7__Impl_in_rule__ExtSubTGraph__Group__710581);
            rule__ExtSubTGraph__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ExtSubTGraph__Group__8_in_rule__ExtSubTGraph__Group__710584);
            rule__ExtSubTGraph__Group__8();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExtSubTGraph__Group__7"


    // $ANTLR start "rule__ExtSubTGraph__Group__7__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5253:1: rule__ExtSubTGraph__Group__7__Impl : ( ( rule__ExtSubTGraph__Group_7__0 )? ) ;
    public final void rule__ExtSubTGraph__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5257:1: ( ( ( rule__ExtSubTGraph__Group_7__0 )? ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5258:1: ( ( rule__ExtSubTGraph__Group_7__0 )? )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5258:1: ( ( rule__ExtSubTGraph__Group_7__0 )? )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5259:1: ( rule__ExtSubTGraph__Group_7__0 )?
            {
             before(grammarAccess.getExtSubTGraphAccess().getGroup_7()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5260:1: ( rule__ExtSubTGraph__Group_7__0 )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==RULE_ID) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5260:2: rule__ExtSubTGraph__Group_7__0
                    {
                    pushFollow(FOLLOW_rule__ExtSubTGraph__Group_7__0_in_rule__ExtSubTGraph__Group__7__Impl10611);
                    rule__ExtSubTGraph__Group_7__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getExtSubTGraphAccess().getGroup_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExtSubTGraph__Group__7__Impl"


    // $ANTLR start "rule__ExtSubTGraph__Group__8"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5270:1: rule__ExtSubTGraph__Group__8 : rule__ExtSubTGraph__Group__8__Impl ;
    public final void rule__ExtSubTGraph__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5274:1: ( rule__ExtSubTGraph__Group__8__Impl )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5275:2: rule__ExtSubTGraph__Group__8__Impl
            {
            pushFollow(FOLLOW_rule__ExtSubTGraph__Group__8__Impl_in_rule__ExtSubTGraph__Group__810642);
            rule__ExtSubTGraph__Group__8__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExtSubTGraph__Group__8"


    // $ANTLR start "rule__ExtSubTGraph__Group__8__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5281:1: rule__ExtSubTGraph__Group__8__Impl : ( '}' ) ;
    public final void rule__ExtSubTGraph__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5285:1: ( ( '}' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5286:1: ( '}' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5286:1: ( '}' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5287:1: '}'
            {
             before(grammarAccess.getExtSubTGraphAccess().getRightCurlyBracketKeyword_8()); 
            match(input,38,FOLLOW_38_in_rule__ExtSubTGraph__Group__8__Impl10670); 
             after(grammarAccess.getExtSubTGraphAccess().getRightCurlyBracketKeyword_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExtSubTGraph__Group__8__Impl"


    // $ANTLR start "rule__ExtSubTGraph__Group_7__0"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5318:1: rule__ExtSubTGraph__Group_7__0 : rule__ExtSubTGraph__Group_7__0__Impl rule__ExtSubTGraph__Group_7__1 ;
    public final void rule__ExtSubTGraph__Group_7__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5322:1: ( rule__ExtSubTGraph__Group_7__0__Impl rule__ExtSubTGraph__Group_7__1 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5323:2: rule__ExtSubTGraph__Group_7__0__Impl rule__ExtSubTGraph__Group_7__1
            {
            pushFollow(FOLLOW_rule__ExtSubTGraph__Group_7__0__Impl_in_rule__ExtSubTGraph__Group_7__010719);
            rule__ExtSubTGraph__Group_7__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ExtSubTGraph__Group_7__1_in_rule__ExtSubTGraph__Group_7__010722);
            rule__ExtSubTGraph__Group_7__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExtSubTGraph__Group_7__0"


    // $ANTLR start "rule__ExtSubTGraph__Group_7__0__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5330:1: rule__ExtSubTGraph__Group_7__0__Impl : ( ( rule__ExtSubTGraph__ElementsAssignment_7_0 ) ) ;
    public final void rule__ExtSubTGraph__Group_7__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5334:1: ( ( ( rule__ExtSubTGraph__ElementsAssignment_7_0 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5335:1: ( ( rule__ExtSubTGraph__ElementsAssignment_7_0 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5335:1: ( ( rule__ExtSubTGraph__ElementsAssignment_7_0 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5336:1: ( rule__ExtSubTGraph__ElementsAssignment_7_0 )
            {
             before(grammarAccess.getExtSubTGraphAccess().getElementsAssignment_7_0()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5337:1: ( rule__ExtSubTGraph__ElementsAssignment_7_0 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5337:2: rule__ExtSubTGraph__ElementsAssignment_7_0
            {
            pushFollow(FOLLOW_rule__ExtSubTGraph__ElementsAssignment_7_0_in_rule__ExtSubTGraph__Group_7__0__Impl10749);
            rule__ExtSubTGraph__ElementsAssignment_7_0();

            state._fsp--;


            }

             after(grammarAccess.getExtSubTGraphAccess().getElementsAssignment_7_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExtSubTGraph__Group_7__0__Impl"


    // $ANTLR start "rule__ExtSubTGraph__Group_7__1"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5347:1: rule__ExtSubTGraph__Group_7__1 : rule__ExtSubTGraph__Group_7__1__Impl ;
    public final void rule__ExtSubTGraph__Group_7__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5351:1: ( rule__ExtSubTGraph__Group_7__1__Impl )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5352:2: rule__ExtSubTGraph__Group_7__1__Impl
            {
            pushFollow(FOLLOW_rule__ExtSubTGraph__Group_7__1__Impl_in_rule__ExtSubTGraph__Group_7__110779);
            rule__ExtSubTGraph__Group_7__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExtSubTGraph__Group_7__1"


    // $ANTLR start "rule__ExtSubTGraph__Group_7__1__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5358:1: rule__ExtSubTGraph__Group_7__1__Impl : ( ( rule__ExtSubTGraph__Group_7_1__0 )* ) ;
    public final void rule__ExtSubTGraph__Group_7__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5362:1: ( ( ( rule__ExtSubTGraph__Group_7_1__0 )* ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5363:1: ( ( rule__ExtSubTGraph__Group_7_1__0 )* )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5363:1: ( ( rule__ExtSubTGraph__Group_7_1__0 )* )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5364:1: ( rule__ExtSubTGraph__Group_7_1__0 )*
            {
             before(grammarAccess.getExtSubTGraphAccess().getGroup_7_1()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5365:1: ( rule__ExtSubTGraph__Group_7_1__0 )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==29) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5365:2: rule__ExtSubTGraph__Group_7_1__0
            	    {
            	    pushFollow(FOLLOW_rule__ExtSubTGraph__Group_7_1__0_in_rule__ExtSubTGraph__Group_7__1__Impl10806);
            	    rule__ExtSubTGraph__Group_7_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop23;
                }
            } while (true);

             after(grammarAccess.getExtSubTGraphAccess().getGroup_7_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExtSubTGraph__Group_7__1__Impl"


    // $ANTLR start "rule__ExtSubTGraph__Group_7_1__0"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5379:1: rule__ExtSubTGraph__Group_7_1__0 : rule__ExtSubTGraph__Group_7_1__0__Impl rule__ExtSubTGraph__Group_7_1__1 ;
    public final void rule__ExtSubTGraph__Group_7_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5383:1: ( rule__ExtSubTGraph__Group_7_1__0__Impl rule__ExtSubTGraph__Group_7_1__1 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5384:2: rule__ExtSubTGraph__Group_7_1__0__Impl rule__ExtSubTGraph__Group_7_1__1
            {
            pushFollow(FOLLOW_rule__ExtSubTGraph__Group_7_1__0__Impl_in_rule__ExtSubTGraph__Group_7_1__010841);
            rule__ExtSubTGraph__Group_7_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ExtSubTGraph__Group_7_1__1_in_rule__ExtSubTGraph__Group_7_1__010844);
            rule__ExtSubTGraph__Group_7_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExtSubTGraph__Group_7_1__0"


    // $ANTLR start "rule__ExtSubTGraph__Group_7_1__0__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5391:1: rule__ExtSubTGraph__Group_7_1__0__Impl : ( ',' ) ;
    public final void rule__ExtSubTGraph__Group_7_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5395:1: ( ( ',' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5396:1: ( ',' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5396:1: ( ',' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5397:1: ','
            {
             before(grammarAccess.getExtSubTGraphAccess().getCommaKeyword_7_1_0()); 
            match(input,29,FOLLOW_29_in_rule__ExtSubTGraph__Group_7_1__0__Impl10872); 
             after(grammarAccess.getExtSubTGraphAccess().getCommaKeyword_7_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExtSubTGraph__Group_7_1__0__Impl"


    // $ANTLR start "rule__ExtSubTGraph__Group_7_1__1"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5410:1: rule__ExtSubTGraph__Group_7_1__1 : rule__ExtSubTGraph__Group_7_1__1__Impl ;
    public final void rule__ExtSubTGraph__Group_7_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5414:1: ( rule__ExtSubTGraph__Group_7_1__1__Impl )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5415:2: rule__ExtSubTGraph__Group_7_1__1__Impl
            {
            pushFollow(FOLLOW_rule__ExtSubTGraph__Group_7_1__1__Impl_in_rule__ExtSubTGraph__Group_7_1__110903);
            rule__ExtSubTGraph__Group_7_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExtSubTGraph__Group_7_1__1"


    // $ANTLR start "rule__ExtSubTGraph__Group_7_1__1__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5421:1: rule__ExtSubTGraph__Group_7_1__1__Impl : ( ( rule__ExtSubTGraph__ElementsAssignment_7_1_1 ) ) ;
    public final void rule__ExtSubTGraph__Group_7_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5425:1: ( ( ( rule__ExtSubTGraph__ElementsAssignment_7_1_1 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5426:1: ( ( rule__ExtSubTGraph__ElementsAssignment_7_1_1 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5426:1: ( ( rule__ExtSubTGraph__ElementsAssignment_7_1_1 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5427:1: ( rule__ExtSubTGraph__ElementsAssignment_7_1_1 )
            {
             before(grammarAccess.getExtSubTGraphAccess().getElementsAssignment_7_1_1()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5428:1: ( rule__ExtSubTGraph__ElementsAssignment_7_1_1 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5428:2: rule__ExtSubTGraph__ElementsAssignment_7_1_1
            {
            pushFollow(FOLLOW_rule__ExtSubTGraph__ElementsAssignment_7_1_1_in_rule__ExtSubTGraph__Group_7_1__1__Impl10930);
            rule__ExtSubTGraph__ElementsAssignment_7_1_1();

            state._fsp--;


            }

             after(grammarAccess.getExtSubTGraphAccess().getElementsAssignment_7_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExtSubTGraph__Group_7_1__1__Impl"


    // $ANTLR start "rule__Graph__Group__0"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5442:1: rule__Graph__Group__0 : rule__Graph__Group__0__Impl rule__Graph__Group__1 ;
    public final void rule__Graph__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5446:1: ( rule__Graph__Group__0__Impl rule__Graph__Group__1 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5447:2: rule__Graph__Group__0__Impl rule__Graph__Group__1
            {
            pushFollow(FOLLOW_rule__Graph__Group__0__Impl_in_rule__Graph__Group__010964);
            rule__Graph__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Graph__Group__1_in_rule__Graph__Group__010967);
            rule__Graph__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Graph__Group__0"


    // $ANTLR start "rule__Graph__Group__0__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5454:1: rule__Graph__Group__0__Impl : ( 'Graph' ) ;
    public final void rule__Graph__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5458:1: ( ( 'Graph' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5459:1: ( 'Graph' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5459:1: ( 'Graph' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5460:1: 'Graph'
            {
             before(grammarAccess.getGraphAccess().getGraphKeyword_0()); 
            match(input,46,FOLLOW_46_in_rule__Graph__Group__0__Impl10995); 
             after(grammarAccess.getGraphAccess().getGraphKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Graph__Group__0__Impl"


    // $ANTLR start "rule__Graph__Group__1"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5473:1: rule__Graph__Group__1 : rule__Graph__Group__1__Impl rule__Graph__Group__2 ;
    public final void rule__Graph__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5477:1: ( rule__Graph__Group__1__Impl rule__Graph__Group__2 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5478:2: rule__Graph__Group__1__Impl rule__Graph__Group__2
            {
            pushFollow(FOLLOW_rule__Graph__Group__1__Impl_in_rule__Graph__Group__111026);
            rule__Graph__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Graph__Group__2_in_rule__Graph__Group__111029);
            rule__Graph__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Graph__Group__1"


    // $ANTLR start "rule__Graph__Group__1__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5485:1: rule__Graph__Group__1__Impl : ( '{' ) ;
    public final void rule__Graph__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5489:1: ( ( '{' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5490:1: ( '{' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5490:1: ( '{' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5491:1: '{'
            {
             before(grammarAccess.getGraphAccess().getLeftCurlyBracketKeyword_1()); 
            match(input,37,FOLLOW_37_in_rule__Graph__Group__1__Impl11057); 
             after(grammarAccess.getGraphAccess().getLeftCurlyBracketKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Graph__Group__1__Impl"


    // $ANTLR start "rule__Graph__Group__2"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5504:1: rule__Graph__Group__2 : rule__Graph__Group__2__Impl rule__Graph__Group__3 ;
    public final void rule__Graph__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5508:1: ( rule__Graph__Group__2__Impl rule__Graph__Group__3 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5509:2: rule__Graph__Group__2__Impl rule__Graph__Group__3
            {
            pushFollow(FOLLOW_rule__Graph__Group__2__Impl_in_rule__Graph__Group__211088);
            rule__Graph__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Graph__Group__3_in_rule__Graph__Group__211091);
            rule__Graph__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Graph__Group__2"


    // $ANTLR start "rule__Graph__Group__2__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5516:1: rule__Graph__Group__2__Impl : ( ( rule__Graph__Group_2__0 )? ) ;
    public final void rule__Graph__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5520:1: ( ( ( rule__Graph__Group_2__0 )? ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5521:1: ( ( rule__Graph__Group_2__0 )? )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5521:1: ( ( rule__Graph__Group_2__0 )? )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5522:1: ( rule__Graph__Group_2__0 )?
            {
             before(grammarAccess.getGraphAccess().getGroup_2()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5523:1: ( rule__Graph__Group_2__0 )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==RULE_ID) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5523:2: rule__Graph__Group_2__0
                    {
                    pushFollow(FOLLOW_rule__Graph__Group_2__0_in_rule__Graph__Group__2__Impl11118);
                    rule__Graph__Group_2__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getGraphAccess().getGroup_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Graph__Group__2__Impl"


    // $ANTLR start "rule__Graph__Group__3"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5533:1: rule__Graph__Group__3 : rule__Graph__Group__3__Impl ;
    public final void rule__Graph__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5537:1: ( rule__Graph__Group__3__Impl )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5538:2: rule__Graph__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__Graph__Group__3__Impl_in_rule__Graph__Group__311149);
            rule__Graph__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Graph__Group__3"


    // $ANTLR start "rule__Graph__Group__3__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5544:1: rule__Graph__Group__3__Impl : ( '}' ) ;
    public final void rule__Graph__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5548:1: ( ( '}' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5549:1: ( '}' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5549:1: ( '}' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5550:1: '}'
            {
             before(grammarAccess.getGraphAccess().getRightCurlyBracketKeyword_3()); 
            match(input,38,FOLLOW_38_in_rule__Graph__Group__3__Impl11177); 
             after(grammarAccess.getGraphAccess().getRightCurlyBracketKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Graph__Group__3__Impl"


    // $ANTLR start "rule__Graph__Group_2__0"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5571:1: rule__Graph__Group_2__0 : rule__Graph__Group_2__0__Impl rule__Graph__Group_2__1 ;
    public final void rule__Graph__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5575:1: ( rule__Graph__Group_2__0__Impl rule__Graph__Group_2__1 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5576:2: rule__Graph__Group_2__0__Impl rule__Graph__Group_2__1
            {
            pushFollow(FOLLOW_rule__Graph__Group_2__0__Impl_in_rule__Graph__Group_2__011216);
            rule__Graph__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Graph__Group_2__1_in_rule__Graph__Group_2__011219);
            rule__Graph__Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Graph__Group_2__0"


    // $ANTLR start "rule__Graph__Group_2__0__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5583:1: rule__Graph__Group_2__0__Impl : ( ( rule__Graph__ElementsAssignment_2_0 ) ) ;
    public final void rule__Graph__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5587:1: ( ( ( rule__Graph__ElementsAssignment_2_0 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5588:1: ( ( rule__Graph__ElementsAssignment_2_0 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5588:1: ( ( rule__Graph__ElementsAssignment_2_0 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5589:1: ( rule__Graph__ElementsAssignment_2_0 )
            {
             before(grammarAccess.getGraphAccess().getElementsAssignment_2_0()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5590:1: ( rule__Graph__ElementsAssignment_2_0 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5590:2: rule__Graph__ElementsAssignment_2_0
            {
            pushFollow(FOLLOW_rule__Graph__ElementsAssignment_2_0_in_rule__Graph__Group_2__0__Impl11246);
            rule__Graph__ElementsAssignment_2_0();

            state._fsp--;


            }

             after(grammarAccess.getGraphAccess().getElementsAssignment_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Graph__Group_2__0__Impl"


    // $ANTLR start "rule__Graph__Group_2__1"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5600:1: rule__Graph__Group_2__1 : rule__Graph__Group_2__1__Impl ;
    public final void rule__Graph__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5604:1: ( rule__Graph__Group_2__1__Impl )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5605:2: rule__Graph__Group_2__1__Impl
            {
            pushFollow(FOLLOW_rule__Graph__Group_2__1__Impl_in_rule__Graph__Group_2__111276);
            rule__Graph__Group_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Graph__Group_2__1"


    // $ANTLR start "rule__Graph__Group_2__1__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5611:1: rule__Graph__Group_2__1__Impl : ( ( rule__Graph__Group_2_1__0 )* ) ;
    public final void rule__Graph__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5615:1: ( ( ( rule__Graph__Group_2_1__0 )* ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5616:1: ( ( rule__Graph__Group_2_1__0 )* )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5616:1: ( ( rule__Graph__Group_2_1__0 )* )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5617:1: ( rule__Graph__Group_2_1__0 )*
            {
             before(grammarAccess.getGraphAccess().getGroup_2_1()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5618:1: ( rule__Graph__Group_2_1__0 )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==29) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5618:2: rule__Graph__Group_2_1__0
            	    {
            	    pushFollow(FOLLOW_rule__Graph__Group_2_1__0_in_rule__Graph__Group_2__1__Impl11303);
            	    rule__Graph__Group_2_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop25;
                }
            } while (true);

             after(grammarAccess.getGraphAccess().getGroup_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Graph__Group_2__1__Impl"


    // $ANTLR start "rule__Graph__Group_2_1__0"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5632:1: rule__Graph__Group_2_1__0 : rule__Graph__Group_2_1__0__Impl rule__Graph__Group_2_1__1 ;
    public final void rule__Graph__Group_2_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5636:1: ( rule__Graph__Group_2_1__0__Impl rule__Graph__Group_2_1__1 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5637:2: rule__Graph__Group_2_1__0__Impl rule__Graph__Group_2_1__1
            {
            pushFollow(FOLLOW_rule__Graph__Group_2_1__0__Impl_in_rule__Graph__Group_2_1__011338);
            rule__Graph__Group_2_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Graph__Group_2_1__1_in_rule__Graph__Group_2_1__011341);
            rule__Graph__Group_2_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Graph__Group_2_1__0"


    // $ANTLR start "rule__Graph__Group_2_1__0__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5644:1: rule__Graph__Group_2_1__0__Impl : ( ',' ) ;
    public final void rule__Graph__Group_2_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5648:1: ( ( ',' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5649:1: ( ',' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5649:1: ( ',' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5650:1: ','
            {
             before(grammarAccess.getGraphAccess().getCommaKeyword_2_1_0()); 
            match(input,29,FOLLOW_29_in_rule__Graph__Group_2_1__0__Impl11369); 
             after(grammarAccess.getGraphAccess().getCommaKeyword_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Graph__Group_2_1__0__Impl"


    // $ANTLR start "rule__Graph__Group_2_1__1"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5663:1: rule__Graph__Group_2_1__1 : rule__Graph__Group_2_1__1__Impl ;
    public final void rule__Graph__Group_2_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5667:1: ( rule__Graph__Group_2_1__1__Impl )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5668:2: rule__Graph__Group_2_1__1__Impl
            {
            pushFollow(FOLLOW_rule__Graph__Group_2_1__1__Impl_in_rule__Graph__Group_2_1__111400);
            rule__Graph__Group_2_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Graph__Group_2_1__1"


    // $ANTLR start "rule__Graph__Group_2_1__1__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5674:1: rule__Graph__Group_2_1__1__Impl : ( ( rule__Graph__ElementsAssignment_2_1_1 ) ) ;
    public final void rule__Graph__Group_2_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5678:1: ( ( ( rule__Graph__ElementsAssignment_2_1_1 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5679:1: ( ( rule__Graph__ElementsAssignment_2_1_1 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5679:1: ( ( rule__Graph__ElementsAssignment_2_1_1 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5680:1: ( rule__Graph__ElementsAssignment_2_1_1 )
            {
             before(grammarAccess.getGraphAccess().getElementsAssignment_2_1_1()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5681:1: ( rule__Graph__ElementsAssignment_2_1_1 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5681:2: rule__Graph__ElementsAssignment_2_1_1
            {
            pushFollow(FOLLOW_rule__Graph__ElementsAssignment_2_1_1_in_rule__Graph__Group_2_1__1__Impl11427);
            rule__Graph__ElementsAssignment_2_1_1();

            state._fsp--;


            }

             after(grammarAccess.getGraphAccess().getElementsAssignment_2_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Graph__Group_2_1__1__Impl"


    // $ANTLR start "rule__Arrows__Group_0__0"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5695:1: rule__Arrows__Group_0__0 : rule__Arrows__Group_0__0__Impl rule__Arrows__Group_0__1 ;
    public final void rule__Arrows__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5699:1: ( rule__Arrows__Group_0__0__Impl rule__Arrows__Group_0__1 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5700:2: rule__Arrows__Group_0__0__Impl rule__Arrows__Group_0__1
            {
            pushFollow(FOLLOW_rule__Arrows__Group_0__0__Impl_in_rule__Arrows__Group_0__011461);
            rule__Arrows__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Arrows__Group_0__1_in_rule__Arrows__Group_0__011464);
            rule__Arrows__Group_0__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Arrows__Group_0__0"


    // $ANTLR start "rule__Arrows__Group_0__0__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5707:1: rule__Arrows__Group_0__0__Impl : ( ( rule__Arrows__SrAssignment_0_0 ) ) ;
    public final void rule__Arrows__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5711:1: ( ( ( rule__Arrows__SrAssignment_0_0 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5712:1: ( ( rule__Arrows__SrAssignment_0_0 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5712:1: ( ( rule__Arrows__SrAssignment_0_0 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5713:1: ( rule__Arrows__SrAssignment_0_0 )
            {
             before(grammarAccess.getArrowsAccess().getSrAssignment_0_0()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5714:1: ( rule__Arrows__SrAssignment_0_0 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5714:2: rule__Arrows__SrAssignment_0_0
            {
            pushFollow(FOLLOW_rule__Arrows__SrAssignment_0_0_in_rule__Arrows__Group_0__0__Impl11491);
            rule__Arrows__SrAssignment_0_0();

            state._fsp--;


            }

             after(grammarAccess.getArrowsAccess().getSrAssignment_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Arrows__Group_0__0__Impl"


    // $ANTLR start "rule__Arrows__Group_0__1"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5724:1: rule__Arrows__Group_0__1 : rule__Arrows__Group_0__1__Impl rule__Arrows__Group_0__2 ;
    public final void rule__Arrows__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5728:1: ( rule__Arrows__Group_0__1__Impl rule__Arrows__Group_0__2 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5729:2: rule__Arrows__Group_0__1__Impl rule__Arrows__Group_0__2
            {
            pushFollow(FOLLOW_rule__Arrows__Group_0__1__Impl_in_rule__Arrows__Group_0__111521);
            rule__Arrows__Group_0__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Arrows__Group_0__2_in_rule__Arrows__Group_0__111524);
            rule__Arrows__Group_0__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Arrows__Group_0__1"


    // $ANTLR start "rule__Arrows__Group_0__1__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5736:1: rule__Arrows__Group_0__1__Impl : ( '-' ) ;
    public final void rule__Arrows__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5740:1: ( ( '-' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5741:1: ( '-' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5741:1: ( '-' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5742:1: '-'
            {
             before(grammarAccess.getArrowsAccess().getHyphenMinusKeyword_0_1()); 
            match(input,47,FOLLOW_47_in_rule__Arrows__Group_0__1__Impl11552); 
             after(grammarAccess.getArrowsAccess().getHyphenMinusKeyword_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Arrows__Group_0__1__Impl"


    // $ANTLR start "rule__Arrows__Group_0__2"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5755:1: rule__Arrows__Group_0__2 : rule__Arrows__Group_0__2__Impl rule__Arrows__Group_0__3 ;
    public final void rule__Arrows__Group_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5759:1: ( rule__Arrows__Group_0__2__Impl rule__Arrows__Group_0__3 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5760:2: rule__Arrows__Group_0__2__Impl rule__Arrows__Group_0__3
            {
            pushFollow(FOLLOW_rule__Arrows__Group_0__2__Impl_in_rule__Arrows__Group_0__211583);
            rule__Arrows__Group_0__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Arrows__Group_0__3_in_rule__Arrows__Group_0__211586);
            rule__Arrows__Group_0__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Arrows__Group_0__2"


    // $ANTLR start "rule__Arrows__Group_0__2__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5767:1: rule__Arrows__Group_0__2__Impl : ( ( rule__Arrows__IdAssignment_0_2 ) ) ;
    public final void rule__Arrows__Group_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5771:1: ( ( ( rule__Arrows__IdAssignment_0_2 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5772:1: ( ( rule__Arrows__IdAssignment_0_2 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5772:1: ( ( rule__Arrows__IdAssignment_0_2 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5773:1: ( rule__Arrows__IdAssignment_0_2 )
            {
             before(grammarAccess.getArrowsAccess().getIdAssignment_0_2()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5774:1: ( rule__Arrows__IdAssignment_0_2 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5774:2: rule__Arrows__IdAssignment_0_2
            {
            pushFollow(FOLLOW_rule__Arrows__IdAssignment_0_2_in_rule__Arrows__Group_0__2__Impl11613);
            rule__Arrows__IdAssignment_0_2();

            state._fsp--;


            }

             after(grammarAccess.getArrowsAccess().getIdAssignment_0_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Arrows__Group_0__2__Impl"


    // $ANTLR start "rule__Arrows__Group_0__3"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5784:1: rule__Arrows__Group_0__3 : rule__Arrows__Group_0__3__Impl rule__Arrows__Group_0__4 ;
    public final void rule__Arrows__Group_0__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5788:1: ( rule__Arrows__Group_0__3__Impl rule__Arrows__Group_0__4 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5789:2: rule__Arrows__Group_0__3__Impl rule__Arrows__Group_0__4
            {
            pushFollow(FOLLOW_rule__Arrows__Group_0__3__Impl_in_rule__Arrows__Group_0__311643);
            rule__Arrows__Group_0__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Arrows__Group_0__4_in_rule__Arrows__Group_0__311646);
            rule__Arrows__Group_0__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Arrows__Group_0__3"


    // $ANTLR start "rule__Arrows__Group_0__3__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5796:1: rule__Arrows__Group_0__3__Impl : ( ':' ) ;
    public final void rule__Arrows__Group_0__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5800:1: ( ( ':' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5801:1: ( ':' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5801:1: ( ':' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5802:1: ':'
            {
             before(grammarAccess.getArrowsAccess().getColonKeyword_0_3()); 
            match(input,34,FOLLOW_34_in_rule__Arrows__Group_0__3__Impl11674); 
             after(grammarAccess.getArrowsAccess().getColonKeyword_0_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Arrows__Group_0__3__Impl"


    // $ANTLR start "rule__Arrows__Group_0__4"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5815:1: rule__Arrows__Group_0__4 : rule__Arrows__Group_0__4__Impl rule__Arrows__Group_0__5 ;
    public final void rule__Arrows__Group_0__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5819:1: ( rule__Arrows__Group_0__4__Impl rule__Arrows__Group_0__5 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5820:2: rule__Arrows__Group_0__4__Impl rule__Arrows__Group_0__5
            {
            pushFollow(FOLLOW_rule__Arrows__Group_0__4__Impl_in_rule__Arrows__Group_0__411705);
            rule__Arrows__Group_0__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Arrows__Group_0__5_in_rule__Arrows__Group_0__411708);
            rule__Arrows__Group_0__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Arrows__Group_0__4"


    // $ANTLR start "rule__Arrows__Group_0__4__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5827:1: rule__Arrows__Group_0__4__Impl : ( ( rule__Arrows__TypeAssignment_0_4 ) ) ;
    public final void rule__Arrows__Group_0__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5831:1: ( ( ( rule__Arrows__TypeAssignment_0_4 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5832:1: ( ( rule__Arrows__TypeAssignment_0_4 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5832:1: ( ( rule__Arrows__TypeAssignment_0_4 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5833:1: ( rule__Arrows__TypeAssignment_0_4 )
            {
             before(grammarAccess.getArrowsAccess().getTypeAssignment_0_4()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5834:1: ( rule__Arrows__TypeAssignment_0_4 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5834:2: rule__Arrows__TypeAssignment_0_4
            {
            pushFollow(FOLLOW_rule__Arrows__TypeAssignment_0_4_in_rule__Arrows__Group_0__4__Impl11735);
            rule__Arrows__TypeAssignment_0_4();

            state._fsp--;


            }

             after(grammarAccess.getArrowsAccess().getTypeAssignment_0_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Arrows__Group_0__4__Impl"


    // $ANTLR start "rule__Arrows__Group_0__5"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5844:1: rule__Arrows__Group_0__5 : rule__Arrows__Group_0__5__Impl rule__Arrows__Group_0__6 ;
    public final void rule__Arrows__Group_0__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5848:1: ( rule__Arrows__Group_0__5__Impl rule__Arrows__Group_0__6 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5849:2: rule__Arrows__Group_0__5__Impl rule__Arrows__Group_0__6
            {
            pushFollow(FOLLOW_rule__Arrows__Group_0__5__Impl_in_rule__Arrows__Group_0__511765);
            rule__Arrows__Group_0__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Arrows__Group_0__6_in_rule__Arrows__Group_0__511768);
            rule__Arrows__Group_0__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Arrows__Group_0__5"


    // $ANTLR start "rule__Arrows__Group_0__5__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5856:1: rule__Arrows__Group_0__5__Impl : ( '->' ) ;
    public final void rule__Arrows__Group_0__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5860:1: ( ( '->' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5861:1: ( '->' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5861:1: ( '->' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5862:1: '->'
            {
             before(grammarAccess.getArrowsAccess().getHyphenMinusGreaterThanSignKeyword_0_5()); 
            match(input,28,FOLLOW_28_in_rule__Arrows__Group_0__5__Impl11796); 
             after(grammarAccess.getArrowsAccess().getHyphenMinusGreaterThanSignKeyword_0_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Arrows__Group_0__5__Impl"


    // $ANTLR start "rule__Arrows__Group_0__6"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5875:1: rule__Arrows__Group_0__6 : rule__Arrows__Group_0__6__Impl ;
    public final void rule__Arrows__Group_0__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5879:1: ( rule__Arrows__Group_0__6__Impl )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5880:2: rule__Arrows__Group_0__6__Impl
            {
            pushFollow(FOLLOW_rule__Arrows__Group_0__6__Impl_in_rule__Arrows__Group_0__611827);
            rule__Arrows__Group_0__6__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Arrows__Group_0__6"


    // $ANTLR start "rule__Arrows__Group_0__6__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5886:1: rule__Arrows__Group_0__6__Impl : ( ( rule__Arrows__NextAssignment_0_6 ) ) ;
    public final void rule__Arrows__Group_0__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5890:1: ( ( ( rule__Arrows__NextAssignment_0_6 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5891:1: ( ( rule__Arrows__NextAssignment_0_6 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5891:1: ( ( rule__Arrows__NextAssignment_0_6 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5892:1: ( rule__Arrows__NextAssignment_0_6 )
            {
             before(grammarAccess.getArrowsAccess().getNextAssignment_0_6()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5893:1: ( rule__Arrows__NextAssignment_0_6 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5893:2: rule__Arrows__NextAssignment_0_6
            {
            pushFollow(FOLLOW_rule__Arrows__NextAssignment_0_6_in_rule__Arrows__Group_0__6__Impl11854);
            rule__Arrows__NextAssignment_0_6();

            state._fsp--;


            }

             after(grammarAccess.getArrowsAccess().getNextAssignment_0_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Arrows__Group_0__6__Impl"


    // $ANTLR start "rule__Arrow__Group_0__0"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5917:1: rule__Arrow__Group_0__0 : rule__Arrow__Group_0__0__Impl rule__Arrow__Group_0__1 ;
    public final void rule__Arrow__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5921:1: ( rule__Arrow__Group_0__0__Impl rule__Arrow__Group_0__1 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5922:2: rule__Arrow__Group_0__0__Impl rule__Arrow__Group_0__1
            {
            pushFollow(FOLLOW_rule__Arrow__Group_0__0__Impl_in_rule__Arrow__Group_0__011898);
            rule__Arrow__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Arrow__Group_0__1_in_rule__Arrow__Group_0__011901);
            rule__Arrow__Group_0__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Arrow__Group_0__0"


    // $ANTLR start "rule__Arrow__Group_0__0__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5929:1: rule__Arrow__Group_0__0__Impl : ( ( rule__Arrow__SrAssignment_0_0 ) ) ;
    public final void rule__Arrow__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5933:1: ( ( ( rule__Arrow__SrAssignment_0_0 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5934:1: ( ( rule__Arrow__SrAssignment_0_0 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5934:1: ( ( rule__Arrow__SrAssignment_0_0 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5935:1: ( rule__Arrow__SrAssignment_0_0 )
            {
             before(grammarAccess.getArrowAccess().getSrAssignment_0_0()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5936:1: ( rule__Arrow__SrAssignment_0_0 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5936:2: rule__Arrow__SrAssignment_0_0
            {
            pushFollow(FOLLOW_rule__Arrow__SrAssignment_0_0_in_rule__Arrow__Group_0__0__Impl11928);
            rule__Arrow__SrAssignment_0_0();

            state._fsp--;


            }

             after(grammarAccess.getArrowAccess().getSrAssignment_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Arrow__Group_0__0__Impl"


    // $ANTLR start "rule__Arrow__Group_0__1"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5946:1: rule__Arrow__Group_0__1 : rule__Arrow__Group_0__1__Impl rule__Arrow__Group_0__2 ;
    public final void rule__Arrow__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5950:1: ( rule__Arrow__Group_0__1__Impl rule__Arrow__Group_0__2 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5951:2: rule__Arrow__Group_0__1__Impl rule__Arrow__Group_0__2
            {
            pushFollow(FOLLOW_rule__Arrow__Group_0__1__Impl_in_rule__Arrow__Group_0__111958);
            rule__Arrow__Group_0__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Arrow__Group_0__2_in_rule__Arrow__Group_0__111961);
            rule__Arrow__Group_0__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Arrow__Group_0__1"


    // $ANTLR start "rule__Arrow__Group_0__1__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5958:1: rule__Arrow__Group_0__1__Impl : ( '-' ) ;
    public final void rule__Arrow__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5962:1: ( ( '-' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5963:1: ( '-' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5963:1: ( '-' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5964:1: '-'
            {
             before(grammarAccess.getArrowAccess().getHyphenMinusKeyword_0_1()); 
            match(input,47,FOLLOW_47_in_rule__Arrow__Group_0__1__Impl11989); 
             after(grammarAccess.getArrowAccess().getHyphenMinusKeyword_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Arrow__Group_0__1__Impl"


    // $ANTLR start "rule__Arrow__Group_0__2"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5977:1: rule__Arrow__Group_0__2 : rule__Arrow__Group_0__2__Impl rule__Arrow__Group_0__3 ;
    public final void rule__Arrow__Group_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5981:1: ( rule__Arrow__Group_0__2__Impl rule__Arrow__Group_0__3 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5982:2: rule__Arrow__Group_0__2__Impl rule__Arrow__Group_0__3
            {
            pushFollow(FOLLOW_rule__Arrow__Group_0__2__Impl_in_rule__Arrow__Group_0__212020);
            rule__Arrow__Group_0__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Arrow__Group_0__3_in_rule__Arrow__Group_0__212023);
            rule__Arrow__Group_0__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Arrow__Group_0__2"


    // $ANTLR start "rule__Arrow__Group_0__2__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5989:1: rule__Arrow__Group_0__2__Impl : ( ( rule__Arrow__IdAssignment_0_2 ) ) ;
    public final void rule__Arrow__Group_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5993:1: ( ( ( rule__Arrow__IdAssignment_0_2 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5994:1: ( ( rule__Arrow__IdAssignment_0_2 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5994:1: ( ( rule__Arrow__IdAssignment_0_2 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5995:1: ( rule__Arrow__IdAssignment_0_2 )
            {
             before(grammarAccess.getArrowAccess().getIdAssignment_0_2()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5996:1: ( rule__Arrow__IdAssignment_0_2 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5996:2: rule__Arrow__IdAssignment_0_2
            {
            pushFollow(FOLLOW_rule__Arrow__IdAssignment_0_2_in_rule__Arrow__Group_0__2__Impl12050);
            rule__Arrow__IdAssignment_0_2();

            state._fsp--;


            }

             after(grammarAccess.getArrowAccess().getIdAssignment_0_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Arrow__Group_0__2__Impl"


    // $ANTLR start "rule__Arrow__Group_0__3"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6006:1: rule__Arrow__Group_0__3 : rule__Arrow__Group_0__3__Impl rule__Arrow__Group_0__4 ;
    public final void rule__Arrow__Group_0__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6010:1: ( rule__Arrow__Group_0__3__Impl rule__Arrow__Group_0__4 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6011:2: rule__Arrow__Group_0__3__Impl rule__Arrow__Group_0__4
            {
            pushFollow(FOLLOW_rule__Arrow__Group_0__3__Impl_in_rule__Arrow__Group_0__312080);
            rule__Arrow__Group_0__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Arrow__Group_0__4_in_rule__Arrow__Group_0__312083);
            rule__Arrow__Group_0__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Arrow__Group_0__3"


    // $ANTLR start "rule__Arrow__Group_0__3__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6018:1: rule__Arrow__Group_0__3__Impl : ( ':' ) ;
    public final void rule__Arrow__Group_0__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6022:1: ( ( ':' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6023:1: ( ':' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6023:1: ( ':' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6024:1: ':'
            {
             before(grammarAccess.getArrowAccess().getColonKeyword_0_3()); 
            match(input,34,FOLLOW_34_in_rule__Arrow__Group_0__3__Impl12111); 
             after(grammarAccess.getArrowAccess().getColonKeyword_0_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Arrow__Group_0__3__Impl"


    // $ANTLR start "rule__Arrow__Group_0__4"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6037:1: rule__Arrow__Group_0__4 : rule__Arrow__Group_0__4__Impl rule__Arrow__Group_0__5 ;
    public final void rule__Arrow__Group_0__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6041:1: ( rule__Arrow__Group_0__4__Impl rule__Arrow__Group_0__5 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6042:2: rule__Arrow__Group_0__4__Impl rule__Arrow__Group_0__5
            {
            pushFollow(FOLLOW_rule__Arrow__Group_0__4__Impl_in_rule__Arrow__Group_0__412142);
            rule__Arrow__Group_0__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Arrow__Group_0__5_in_rule__Arrow__Group_0__412145);
            rule__Arrow__Group_0__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Arrow__Group_0__4"


    // $ANTLR start "rule__Arrow__Group_0__4__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6049:1: rule__Arrow__Group_0__4__Impl : ( '*' ) ;
    public final void rule__Arrow__Group_0__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6053:1: ( ( '*' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6054:1: ( '*' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6054:1: ( '*' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6055:1: '*'
            {
             before(grammarAccess.getArrowAccess().getAsteriskKeyword_0_4()); 
            match(input,48,FOLLOW_48_in_rule__Arrow__Group_0__4__Impl12173); 
             after(grammarAccess.getArrowAccess().getAsteriskKeyword_0_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Arrow__Group_0__4__Impl"


    // $ANTLR start "rule__Arrow__Group_0__5"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6068:1: rule__Arrow__Group_0__5 : rule__Arrow__Group_0__5__Impl rule__Arrow__Group_0__6 ;
    public final void rule__Arrow__Group_0__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6072:1: ( rule__Arrow__Group_0__5__Impl rule__Arrow__Group_0__6 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6073:2: rule__Arrow__Group_0__5__Impl rule__Arrow__Group_0__6
            {
            pushFollow(FOLLOW_rule__Arrow__Group_0__5__Impl_in_rule__Arrow__Group_0__512204);
            rule__Arrow__Group_0__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Arrow__Group_0__6_in_rule__Arrow__Group_0__512207);
            rule__Arrow__Group_0__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Arrow__Group_0__5"


    // $ANTLR start "rule__Arrow__Group_0__5__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6080:1: rule__Arrow__Group_0__5__Impl : ( '->' ) ;
    public final void rule__Arrow__Group_0__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6084:1: ( ( '->' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6085:1: ( '->' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6085:1: ( '->' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6086:1: '->'
            {
             before(grammarAccess.getArrowAccess().getHyphenMinusGreaterThanSignKeyword_0_5()); 
            match(input,28,FOLLOW_28_in_rule__Arrow__Group_0__5__Impl12235); 
             after(grammarAccess.getArrowAccess().getHyphenMinusGreaterThanSignKeyword_0_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Arrow__Group_0__5__Impl"


    // $ANTLR start "rule__Arrow__Group_0__6"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6099:1: rule__Arrow__Group_0__6 : rule__Arrow__Group_0__6__Impl ;
    public final void rule__Arrow__Group_0__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6103:1: ( rule__Arrow__Group_0__6__Impl )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6104:2: rule__Arrow__Group_0__6__Impl
            {
            pushFollow(FOLLOW_rule__Arrow__Group_0__6__Impl_in_rule__Arrow__Group_0__612266);
            rule__Arrow__Group_0__6__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Arrow__Group_0__6"


    // $ANTLR start "rule__Arrow__Group_0__6__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6110:1: rule__Arrow__Group_0__6__Impl : ( ( rule__Arrow__TgDataTypeAssignment_0_6 ) ) ;
    public final void rule__Arrow__Group_0__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6114:1: ( ( ( rule__Arrow__TgDataTypeAssignment_0_6 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6115:1: ( ( rule__Arrow__TgDataTypeAssignment_0_6 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6115:1: ( ( rule__Arrow__TgDataTypeAssignment_0_6 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6116:1: ( rule__Arrow__TgDataTypeAssignment_0_6 )
            {
             before(grammarAccess.getArrowAccess().getTgDataTypeAssignment_0_6()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6117:1: ( rule__Arrow__TgDataTypeAssignment_0_6 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6117:2: rule__Arrow__TgDataTypeAssignment_0_6
            {
            pushFollow(FOLLOW_rule__Arrow__TgDataTypeAssignment_0_6_in_rule__Arrow__Group_0__6__Impl12293);
            rule__Arrow__TgDataTypeAssignment_0_6();

            state._fsp--;


            }

             after(grammarAccess.getArrowAccess().getTgDataTypeAssignment_0_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Arrow__Group_0__6__Impl"


    // $ANTLR start "rule__Arrow__Group_1__0"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6141:1: rule__Arrow__Group_1__0 : rule__Arrow__Group_1__0__Impl rule__Arrow__Group_1__1 ;
    public final void rule__Arrow__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6145:1: ( rule__Arrow__Group_1__0__Impl rule__Arrow__Group_1__1 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6146:2: rule__Arrow__Group_1__0__Impl rule__Arrow__Group_1__1
            {
            pushFollow(FOLLOW_rule__Arrow__Group_1__0__Impl_in_rule__Arrow__Group_1__012337);
            rule__Arrow__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Arrow__Group_1__1_in_rule__Arrow__Group_1__012340);
            rule__Arrow__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Arrow__Group_1__0"


    // $ANTLR start "rule__Arrow__Group_1__0__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6153:1: rule__Arrow__Group_1__0__Impl : ( ( rule__Arrow__SrAssignment_1_0 ) ) ;
    public final void rule__Arrow__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6157:1: ( ( ( rule__Arrow__SrAssignment_1_0 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6158:1: ( ( rule__Arrow__SrAssignment_1_0 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6158:1: ( ( rule__Arrow__SrAssignment_1_0 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6159:1: ( rule__Arrow__SrAssignment_1_0 )
            {
             before(grammarAccess.getArrowAccess().getSrAssignment_1_0()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6160:1: ( rule__Arrow__SrAssignment_1_0 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6160:2: rule__Arrow__SrAssignment_1_0
            {
            pushFollow(FOLLOW_rule__Arrow__SrAssignment_1_0_in_rule__Arrow__Group_1__0__Impl12367);
            rule__Arrow__SrAssignment_1_0();

            state._fsp--;


            }

             after(grammarAccess.getArrowAccess().getSrAssignment_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Arrow__Group_1__0__Impl"


    // $ANTLR start "rule__Arrow__Group_1__1"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6170:1: rule__Arrow__Group_1__1 : rule__Arrow__Group_1__1__Impl rule__Arrow__Group_1__2 ;
    public final void rule__Arrow__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6174:1: ( rule__Arrow__Group_1__1__Impl rule__Arrow__Group_1__2 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6175:2: rule__Arrow__Group_1__1__Impl rule__Arrow__Group_1__2
            {
            pushFollow(FOLLOW_rule__Arrow__Group_1__1__Impl_in_rule__Arrow__Group_1__112397);
            rule__Arrow__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Arrow__Group_1__2_in_rule__Arrow__Group_1__112400);
            rule__Arrow__Group_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Arrow__Group_1__1"


    // $ANTLR start "rule__Arrow__Group_1__1__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6182:1: rule__Arrow__Group_1__1__Impl : ( '-' ) ;
    public final void rule__Arrow__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6186:1: ( ( '-' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6187:1: ( '-' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6187:1: ( '-' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6188:1: '-'
            {
             before(grammarAccess.getArrowAccess().getHyphenMinusKeyword_1_1()); 
            match(input,47,FOLLOW_47_in_rule__Arrow__Group_1__1__Impl12428); 
             after(grammarAccess.getArrowAccess().getHyphenMinusKeyword_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Arrow__Group_1__1__Impl"


    // $ANTLR start "rule__Arrow__Group_1__2"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6201:1: rule__Arrow__Group_1__2 : rule__Arrow__Group_1__2__Impl rule__Arrow__Group_1__3 ;
    public final void rule__Arrow__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6205:1: ( rule__Arrow__Group_1__2__Impl rule__Arrow__Group_1__3 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6206:2: rule__Arrow__Group_1__2__Impl rule__Arrow__Group_1__3
            {
            pushFollow(FOLLOW_rule__Arrow__Group_1__2__Impl_in_rule__Arrow__Group_1__212459);
            rule__Arrow__Group_1__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Arrow__Group_1__3_in_rule__Arrow__Group_1__212462);
            rule__Arrow__Group_1__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Arrow__Group_1__2"


    // $ANTLR start "rule__Arrow__Group_1__2__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6213:1: rule__Arrow__Group_1__2__Impl : ( ( rule__Arrow__IdAssignment_1_2 ) ) ;
    public final void rule__Arrow__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6217:1: ( ( ( rule__Arrow__IdAssignment_1_2 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6218:1: ( ( rule__Arrow__IdAssignment_1_2 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6218:1: ( ( rule__Arrow__IdAssignment_1_2 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6219:1: ( rule__Arrow__IdAssignment_1_2 )
            {
             before(grammarAccess.getArrowAccess().getIdAssignment_1_2()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6220:1: ( rule__Arrow__IdAssignment_1_2 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6220:2: rule__Arrow__IdAssignment_1_2
            {
            pushFollow(FOLLOW_rule__Arrow__IdAssignment_1_2_in_rule__Arrow__Group_1__2__Impl12489);
            rule__Arrow__IdAssignment_1_2();

            state._fsp--;


            }

             after(grammarAccess.getArrowAccess().getIdAssignment_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Arrow__Group_1__2__Impl"


    // $ANTLR start "rule__Arrow__Group_1__3"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6230:1: rule__Arrow__Group_1__3 : rule__Arrow__Group_1__3__Impl rule__Arrow__Group_1__4 ;
    public final void rule__Arrow__Group_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6234:1: ( rule__Arrow__Group_1__3__Impl rule__Arrow__Group_1__4 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6235:2: rule__Arrow__Group_1__3__Impl rule__Arrow__Group_1__4
            {
            pushFollow(FOLLOW_rule__Arrow__Group_1__3__Impl_in_rule__Arrow__Group_1__312519);
            rule__Arrow__Group_1__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Arrow__Group_1__4_in_rule__Arrow__Group_1__312522);
            rule__Arrow__Group_1__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Arrow__Group_1__3"


    // $ANTLR start "rule__Arrow__Group_1__3__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6242:1: rule__Arrow__Group_1__3__Impl : ( ':' ) ;
    public final void rule__Arrow__Group_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6246:1: ( ( ':' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6247:1: ( ':' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6247:1: ( ':' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6248:1: ':'
            {
             before(grammarAccess.getArrowAccess().getColonKeyword_1_3()); 
            match(input,34,FOLLOW_34_in_rule__Arrow__Group_1__3__Impl12550); 
             after(grammarAccess.getArrowAccess().getColonKeyword_1_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Arrow__Group_1__3__Impl"


    // $ANTLR start "rule__Arrow__Group_1__4"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6261:1: rule__Arrow__Group_1__4 : rule__Arrow__Group_1__4__Impl rule__Arrow__Group_1__5 ;
    public final void rule__Arrow__Group_1__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6265:1: ( rule__Arrow__Group_1__4__Impl rule__Arrow__Group_1__5 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6266:2: rule__Arrow__Group_1__4__Impl rule__Arrow__Group_1__5
            {
            pushFollow(FOLLOW_rule__Arrow__Group_1__4__Impl_in_rule__Arrow__Group_1__412581);
            rule__Arrow__Group_1__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Arrow__Group_1__5_in_rule__Arrow__Group_1__412584);
            rule__Arrow__Group_1__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Arrow__Group_1__4"


    // $ANTLR start "rule__Arrow__Group_1__4__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6273:1: rule__Arrow__Group_1__4__Impl : ( ( rule__Arrow__TypeAssignment_1_4 ) ) ;
    public final void rule__Arrow__Group_1__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6277:1: ( ( ( rule__Arrow__TypeAssignment_1_4 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6278:1: ( ( rule__Arrow__TypeAssignment_1_4 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6278:1: ( ( rule__Arrow__TypeAssignment_1_4 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6279:1: ( rule__Arrow__TypeAssignment_1_4 )
            {
             before(grammarAccess.getArrowAccess().getTypeAssignment_1_4()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6280:1: ( rule__Arrow__TypeAssignment_1_4 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6280:2: rule__Arrow__TypeAssignment_1_4
            {
            pushFollow(FOLLOW_rule__Arrow__TypeAssignment_1_4_in_rule__Arrow__Group_1__4__Impl12611);
            rule__Arrow__TypeAssignment_1_4();

            state._fsp--;


            }

             after(grammarAccess.getArrowAccess().getTypeAssignment_1_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Arrow__Group_1__4__Impl"


    // $ANTLR start "rule__Arrow__Group_1__5"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6290:1: rule__Arrow__Group_1__5 : rule__Arrow__Group_1__5__Impl rule__Arrow__Group_1__6 ;
    public final void rule__Arrow__Group_1__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6294:1: ( rule__Arrow__Group_1__5__Impl rule__Arrow__Group_1__6 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6295:2: rule__Arrow__Group_1__5__Impl rule__Arrow__Group_1__6
            {
            pushFollow(FOLLOW_rule__Arrow__Group_1__5__Impl_in_rule__Arrow__Group_1__512641);
            rule__Arrow__Group_1__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Arrow__Group_1__6_in_rule__Arrow__Group_1__512644);
            rule__Arrow__Group_1__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Arrow__Group_1__5"


    // $ANTLR start "rule__Arrow__Group_1__5__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6302:1: rule__Arrow__Group_1__5__Impl : ( '->' ) ;
    public final void rule__Arrow__Group_1__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6306:1: ( ( '->' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6307:1: ( '->' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6307:1: ( '->' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6308:1: '->'
            {
             before(grammarAccess.getArrowAccess().getHyphenMinusGreaterThanSignKeyword_1_5()); 
            match(input,28,FOLLOW_28_in_rule__Arrow__Group_1__5__Impl12672); 
             after(grammarAccess.getArrowAccess().getHyphenMinusGreaterThanSignKeyword_1_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Arrow__Group_1__5__Impl"


    // $ANTLR start "rule__Arrow__Group_1__6"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6321:1: rule__Arrow__Group_1__6 : rule__Arrow__Group_1__6__Impl ;
    public final void rule__Arrow__Group_1__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6325:1: ( rule__Arrow__Group_1__6__Impl )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6326:2: rule__Arrow__Group_1__6__Impl
            {
            pushFollow(FOLLOW_rule__Arrow__Group_1__6__Impl_in_rule__Arrow__Group_1__612703);
            rule__Arrow__Group_1__6__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Arrow__Group_1__6"


    // $ANTLR start "rule__Arrow__Group_1__6__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6332:1: rule__Arrow__Group_1__6__Impl : ( ( rule__Arrow__TgValueAssignment_1_6 ) ) ;
    public final void rule__Arrow__Group_1__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6336:1: ( ( ( rule__Arrow__TgValueAssignment_1_6 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6337:1: ( ( rule__Arrow__TgValueAssignment_1_6 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6337:1: ( ( rule__Arrow__TgValueAssignment_1_6 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6338:1: ( rule__Arrow__TgValueAssignment_1_6 )
            {
             before(grammarAccess.getArrowAccess().getTgValueAssignment_1_6()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6339:1: ( rule__Arrow__TgValueAssignment_1_6 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6339:2: rule__Arrow__TgValueAssignment_1_6
            {
            pushFollow(FOLLOW_rule__Arrow__TgValueAssignment_1_6_in_rule__Arrow__Group_1__6__Impl12730);
            rule__Arrow__TgValueAssignment_1_6();

            state._fsp--;


            }

             after(grammarAccess.getArrowAccess().getTgValueAssignment_1_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Arrow__Group_1__6__Impl"


    // $ANTLR start "rule__Arrow__Group_2__0"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6363:1: rule__Arrow__Group_2__0 : rule__Arrow__Group_2__0__Impl rule__Arrow__Group_2__1 ;
    public final void rule__Arrow__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6367:1: ( rule__Arrow__Group_2__0__Impl rule__Arrow__Group_2__1 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6368:2: rule__Arrow__Group_2__0__Impl rule__Arrow__Group_2__1
            {
            pushFollow(FOLLOW_rule__Arrow__Group_2__0__Impl_in_rule__Arrow__Group_2__012774);
            rule__Arrow__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Arrow__Group_2__1_in_rule__Arrow__Group_2__012777);
            rule__Arrow__Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Arrow__Group_2__0"


    // $ANTLR start "rule__Arrow__Group_2__0__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6375:1: rule__Arrow__Group_2__0__Impl : ( ( rule__Arrow__SrAssignment_2_0 ) ) ;
    public final void rule__Arrow__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6379:1: ( ( ( rule__Arrow__SrAssignment_2_0 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6380:1: ( ( rule__Arrow__SrAssignment_2_0 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6380:1: ( ( rule__Arrow__SrAssignment_2_0 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6381:1: ( rule__Arrow__SrAssignment_2_0 )
            {
             before(grammarAccess.getArrowAccess().getSrAssignment_2_0()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6382:1: ( rule__Arrow__SrAssignment_2_0 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6382:2: rule__Arrow__SrAssignment_2_0
            {
            pushFollow(FOLLOW_rule__Arrow__SrAssignment_2_0_in_rule__Arrow__Group_2__0__Impl12804);
            rule__Arrow__SrAssignment_2_0();

            state._fsp--;


            }

             after(grammarAccess.getArrowAccess().getSrAssignment_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Arrow__Group_2__0__Impl"


    // $ANTLR start "rule__Arrow__Group_2__1"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6392:1: rule__Arrow__Group_2__1 : rule__Arrow__Group_2__1__Impl rule__Arrow__Group_2__2 ;
    public final void rule__Arrow__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6396:1: ( rule__Arrow__Group_2__1__Impl rule__Arrow__Group_2__2 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6397:2: rule__Arrow__Group_2__1__Impl rule__Arrow__Group_2__2
            {
            pushFollow(FOLLOW_rule__Arrow__Group_2__1__Impl_in_rule__Arrow__Group_2__112834);
            rule__Arrow__Group_2__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Arrow__Group_2__2_in_rule__Arrow__Group_2__112837);
            rule__Arrow__Group_2__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Arrow__Group_2__1"


    // $ANTLR start "rule__Arrow__Group_2__1__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6404:1: rule__Arrow__Group_2__1__Impl : ( '-' ) ;
    public final void rule__Arrow__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6408:1: ( ( '-' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6409:1: ( '-' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6409:1: ( '-' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6410:1: '-'
            {
             before(grammarAccess.getArrowAccess().getHyphenMinusKeyword_2_1()); 
            match(input,47,FOLLOW_47_in_rule__Arrow__Group_2__1__Impl12865); 
             after(grammarAccess.getArrowAccess().getHyphenMinusKeyword_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Arrow__Group_2__1__Impl"


    // $ANTLR start "rule__Arrow__Group_2__2"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6423:1: rule__Arrow__Group_2__2 : rule__Arrow__Group_2__2__Impl rule__Arrow__Group_2__3 ;
    public final void rule__Arrow__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6427:1: ( rule__Arrow__Group_2__2__Impl rule__Arrow__Group_2__3 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6428:2: rule__Arrow__Group_2__2__Impl rule__Arrow__Group_2__3
            {
            pushFollow(FOLLOW_rule__Arrow__Group_2__2__Impl_in_rule__Arrow__Group_2__212896);
            rule__Arrow__Group_2__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Arrow__Group_2__3_in_rule__Arrow__Group_2__212899);
            rule__Arrow__Group_2__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Arrow__Group_2__2"


    // $ANTLR start "rule__Arrow__Group_2__2__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6435:1: rule__Arrow__Group_2__2__Impl : ( ( rule__Arrow__IdAssignment_2_2 ) ) ;
    public final void rule__Arrow__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6439:1: ( ( ( rule__Arrow__IdAssignment_2_2 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6440:1: ( ( rule__Arrow__IdAssignment_2_2 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6440:1: ( ( rule__Arrow__IdAssignment_2_2 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6441:1: ( rule__Arrow__IdAssignment_2_2 )
            {
             before(grammarAccess.getArrowAccess().getIdAssignment_2_2()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6442:1: ( rule__Arrow__IdAssignment_2_2 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6442:2: rule__Arrow__IdAssignment_2_2
            {
            pushFollow(FOLLOW_rule__Arrow__IdAssignment_2_2_in_rule__Arrow__Group_2__2__Impl12926);
            rule__Arrow__IdAssignment_2_2();

            state._fsp--;


            }

             after(grammarAccess.getArrowAccess().getIdAssignment_2_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Arrow__Group_2__2__Impl"


    // $ANTLR start "rule__Arrow__Group_2__3"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6452:1: rule__Arrow__Group_2__3 : rule__Arrow__Group_2__3__Impl rule__Arrow__Group_2__4 ;
    public final void rule__Arrow__Group_2__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6456:1: ( rule__Arrow__Group_2__3__Impl rule__Arrow__Group_2__4 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6457:2: rule__Arrow__Group_2__3__Impl rule__Arrow__Group_2__4
            {
            pushFollow(FOLLOW_rule__Arrow__Group_2__3__Impl_in_rule__Arrow__Group_2__312956);
            rule__Arrow__Group_2__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Arrow__Group_2__4_in_rule__Arrow__Group_2__312959);
            rule__Arrow__Group_2__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Arrow__Group_2__3"


    // $ANTLR start "rule__Arrow__Group_2__3__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6464:1: rule__Arrow__Group_2__3__Impl : ( ':' ) ;
    public final void rule__Arrow__Group_2__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6468:1: ( ( ':' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6469:1: ( ':' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6469:1: ( ':' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6470:1: ':'
            {
             before(grammarAccess.getArrowAccess().getColonKeyword_2_3()); 
            match(input,34,FOLLOW_34_in_rule__Arrow__Group_2__3__Impl12987); 
             after(grammarAccess.getArrowAccess().getColonKeyword_2_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Arrow__Group_2__3__Impl"


    // $ANTLR start "rule__Arrow__Group_2__4"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6483:1: rule__Arrow__Group_2__4 : rule__Arrow__Group_2__4__Impl rule__Arrow__Group_2__5 ;
    public final void rule__Arrow__Group_2__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6487:1: ( rule__Arrow__Group_2__4__Impl rule__Arrow__Group_2__5 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6488:2: rule__Arrow__Group_2__4__Impl rule__Arrow__Group_2__5
            {
            pushFollow(FOLLOW_rule__Arrow__Group_2__4__Impl_in_rule__Arrow__Group_2__413018);
            rule__Arrow__Group_2__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Arrow__Group_2__5_in_rule__Arrow__Group_2__413021);
            rule__Arrow__Group_2__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Arrow__Group_2__4"


    // $ANTLR start "rule__Arrow__Group_2__4__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6495:1: rule__Arrow__Group_2__4__Impl : ( ( rule__Arrow__TypeAssignment_2_4 ) ) ;
    public final void rule__Arrow__Group_2__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6499:1: ( ( ( rule__Arrow__TypeAssignment_2_4 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6500:1: ( ( rule__Arrow__TypeAssignment_2_4 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6500:1: ( ( rule__Arrow__TypeAssignment_2_4 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6501:1: ( rule__Arrow__TypeAssignment_2_4 )
            {
             before(grammarAccess.getArrowAccess().getTypeAssignment_2_4()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6502:1: ( rule__Arrow__TypeAssignment_2_4 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6502:2: rule__Arrow__TypeAssignment_2_4
            {
            pushFollow(FOLLOW_rule__Arrow__TypeAssignment_2_4_in_rule__Arrow__Group_2__4__Impl13048);
            rule__Arrow__TypeAssignment_2_4();

            state._fsp--;


            }

             after(grammarAccess.getArrowAccess().getTypeAssignment_2_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Arrow__Group_2__4__Impl"


    // $ANTLR start "rule__Arrow__Group_2__5"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6512:1: rule__Arrow__Group_2__5 : rule__Arrow__Group_2__5__Impl rule__Arrow__Group_2__6 ;
    public final void rule__Arrow__Group_2__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6516:1: ( rule__Arrow__Group_2__5__Impl rule__Arrow__Group_2__6 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6517:2: rule__Arrow__Group_2__5__Impl rule__Arrow__Group_2__6
            {
            pushFollow(FOLLOW_rule__Arrow__Group_2__5__Impl_in_rule__Arrow__Group_2__513078);
            rule__Arrow__Group_2__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Arrow__Group_2__6_in_rule__Arrow__Group_2__513081);
            rule__Arrow__Group_2__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Arrow__Group_2__5"


    // $ANTLR start "rule__Arrow__Group_2__5__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6524:1: rule__Arrow__Group_2__5__Impl : ( '->' ) ;
    public final void rule__Arrow__Group_2__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6528:1: ( ( '->' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6529:1: ( '->' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6529:1: ( '->' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6530:1: '->'
            {
             before(grammarAccess.getArrowAccess().getHyphenMinusGreaterThanSignKeyword_2_5()); 
            match(input,28,FOLLOW_28_in_rule__Arrow__Group_2__5__Impl13109); 
             after(grammarAccess.getArrowAccess().getHyphenMinusGreaterThanSignKeyword_2_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Arrow__Group_2__5__Impl"


    // $ANTLR start "rule__Arrow__Group_2__6"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6543:1: rule__Arrow__Group_2__6 : rule__Arrow__Group_2__6__Impl ;
    public final void rule__Arrow__Group_2__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6547:1: ( rule__Arrow__Group_2__6__Impl )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6548:2: rule__Arrow__Group_2__6__Impl
            {
            pushFollow(FOLLOW_rule__Arrow__Group_2__6__Impl_in_rule__Arrow__Group_2__613140);
            rule__Arrow__Group_2__6__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Arrow__Group_2__6"


    // $ANTLR start "rule__Arrow__Group_2__6__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6554:1: rule__Arrow__Group_2__6__Impl : ( ( rule__Arrow__TgNodeAssignment_2_6 ) ) ;
    public final void rule__Arrow__Group_2__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6558:1: ( ( ( rule__Arrow__TgNodeAssignment_2_6 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6559:1: ( ( rule__Arrow__TgNodeAssignment_2_6 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6559:1: ( ( rule__Arrow__TgNodeAssignment_2_6 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6560:1: ( rule__Arrow__TgNodeAssignment_2_6 )
            {
             before(grammarAccess.getArrowAccess().getTgNodeAssignment_2_6()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6561:1: ( rule__Arrow__TgNodeAssignment_2_6 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6561:2: rule__Arrow__TgNodeAssignment_2_6
            {
            pushFollow(FOLLOW_rule__Arrow__TgNodeAssignment_2_6_in_rule__Arrow__Group_2__6__Impl13167);
            rule__Arrow__TgNodeAssignment_2_6();

            state._fsp--;


            }

             after(grammarAccess.getArrowAccess().getTgNodeAssignment_2_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Arrow__Group_2__6__Impl"


    // $ANTLR start "rule__Node__Group__0"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6585:1: rule__Node__Group__0 : rule__Node__Group__0__Impl rule__Node__Group__1 ;
    public final void rule__Node__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6589:1: ( rule__Node__Group__0__Impl rule__Node__Group__1 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6590:2: rule__Node__Group__0__Impl rule__Node__Group__1
            {
            pushFollow(FOLLOW_rule__Node__Group__0__Impl_in_rule__Node__Group__013211);
            rule__Node__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Node__Group__1_in_rule__Node__Group__013214);
            rule__Node__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__Group__0"


    // $ANTLR start "rule__Node__Group__0__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6597:1: rule__Node__Group__0__Impl : ( ( rule__Node__IdAssignment_0 ) ) ;
    public final void rule__Node__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6601:1: ( ( ( rule__Node__IdAssignment_0 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6602:1: ( ( rule__Node__IdAssignment_0 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6602:1: ( ( rule__Node__IdAssignment_0 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6603:1: ( rule__Node__IdAssignment_0 )
            {
             before(grammarAccess.getNodeAccess().getIdAssignment_0()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6604:1: ( rule__Node__IdAssignment_0 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6604:2: rule__Node__IdAssignment_0
            {
            pushFollow(FOLLOW_rule__Node__IdAssignment_0_in_rule__Node__Group__0__Impl13241);
            rule__Node__IdAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getNodeAccess().getIdAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__Group__0__Impl"


    // $ANTLR start "rule__Node__Group__1"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6614:1: rule__Node__Group__1 : rule__Node__Group__1__Impl rule__Node__Group__2 ;
    public final void rule__Node__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6618:1: ( rule__Node__Group__1__Impl rule__Node__Group__2 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6619:2: rule__Node__Group__1__Impl rule__Node__Group__2
            {
            pushFollow(FOLLOW_rule__Node__Group__1__Impl_in_rule__Node__Group__113271);
            rule__Node__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Node__Group__2_in_rule__Node__Group__113274);
            rule__Node__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__Group__1"


    // $ANTLR start "rule__Node__Group__1__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6626:1: rule__Node__Group__1__Impl : ( ':' ) ;
    public final void rule__Node__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6630:1: ( ( ':' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6631:1: ( ':' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6631:1: ( ':' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6632:1: ':'
            {
             before(grammarAccess.getNodeAccess().getColonKeyword_1()); 
            match(input,34,FOLLOW_34_in_rule__Node__Group__1__Impl13302); 
             after(grammarAccess.getNodeAccess().getColonKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__Group__1__Impl"


    // $ANTLR start "rule__Node__Group__2"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6645:1: rule__Node__Group__2 : rule__Node__Group__2__Impl ;
    public final void rule__Node__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6649:1: ( rule__Node__Group__2__Impl )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6650:2: rule__Node__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__Node__Group__2__Impl_in_rule__Node__Group__213333);
            rule__Node__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__Group__2"


    // $ANTLR start "rule__Node__Group__2__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6656:1: rule__Node__Group__2__Impl : ( ( rule__Node__TypeAssignment_2 ) ) ;
    public final void rule__Node__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6660:1: ( ( ( rule__Node__TypeAssignment_2 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6661:1: ( ( rule__Node__TypeAssignment_2 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6661:1: ( ( rule__Node__TypeAssignment_2 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6662:1: ( rule__Node__TypeAssignment_2 )
            {
             before(grammarAccess.getNodeAccess().getTypeAssignment_2()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6663:1: ( rule__Node__TypeAssignment_2 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6663:2: rule__Node__TypeAssignment_2
            {
            pushFollow(FOLLOW_rule__Node__TypeAssignment_2_in_rule__Node__Group__2__Impl13360);
            rule__Node__TypeAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getNodeAccess().getTypeAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__Group__2__Impl"


    // $ANTLR start "rule__AttributeValue__Group__0"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6679:1: rule__AttributeValue__Group__0 : rule__AttributeValue__Group__0__Impl rule__AttributeValue__Group__1 ;
    public final void rule__AttributeValue__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6683:1: ( rule__AttributeValue__Group__0__Impl rule__AttributeValue__Group__1 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6684:2: rule__AttributeValue__Group__0__Impl rule__AttributeValue__Group__1
            {
            pushFollow(FOLLOW_rule__AttributeValue__Group__0__Impl_in_rule__AttributeValue__Group__013396);
            rule__AttributeValue__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__AttributeValue__Group__1_in_rule__AttributeValue__Group__013399);
            rule__AttributeValue__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttributeValue__Group__0"


    // $ANTLR start "rule__AttributeValue__Group__0__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6691:1: rule__AttributeValue__Group__0__Impl : ( '[' ) ;
    public final void rule__AttributeValue__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6695:1: ( ( '[' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6696:1: ( '[' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6696:1: ( '[' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6697:1: '['
            {
             before(grammarAccess.getAttributeValueAccess().getLeftSquareBracketKeyword_0()); 
            match(input,49,FOLLOW_49_in_rule__AttributeValue__Group__0__Impl13427); 
             after(grammarAccess.getAttributeValueAccess().getLeftSquareBracketKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttributeValue__Group__0__Impl"


    // $ANTLR start "rule__AttributeValue__Group__1"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6710:1: rule__AttributeValue__Group__1 : rule__AttributeValue__Group__1__Impl rule__AttributeValue__Group__2 ;
    public final void rule__AttributeValue__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6714:1: ( rule__AttributeValue__Group__1__Impl rule__AttributeValue__Group__2 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6715:2: rule__AttributeValue__Group__1__Impl rule__AttributeValue__Group__2
            {
            pushFollow(FOLLOW_rule__AttributeValue__Group__1__Impl_in_rule__AttributeValue__Group__113458);
            rule__AttributeValue__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__AttributeValue__Group__2_in_rule__AttributeValue__Group__113461);
            rule__AttributeValue__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttributeValue__Group__1"


    // $ANTLR start "rule__AttributeValue__Group__1__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6722:1: rule__AttributeValue__Group__1__Impl : ( ( rule__AttributeValue__ValueAssignment_1 ) ) ;
    public final void rule__AttributeValue__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6726:1: ( ( ( rule__AttributeValue__ValueAssignment_1 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6727:1: ( ( rule__AttributeValue__ValueAssignment_1 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6727:1: ( ( rule__AttributeValue__ValueAssignment_1 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6728:1: ( rule__AttributeValue__ValueAssignment_1 )
            {
             before(grammarAccess.getAttributeValueAccess().getValueAssignment_1()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6729:1: ( rule__AttributeValue__ValueAssignment_1 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6729:2: rule__AttributeValue__ValueAssignment_1
            {
            pushFollow(FOLLOW_rule__AttributeValue__ValueAssignment_1_in_rule__AttributeValue__Group__1__Impl13488);
            rule__AttributeValue__ValueAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getAttributeValueAccess().getValueAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttributeValue__Group__1__Impl"


    // $ANTLR start "rule__AttributeValue__Group__2"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6739:1: rule__AttributeValue__Group__2 : rule__AttributeValue__Group__2__Impl ;
    public final void rule__AttributeValue__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6743:1: ( rule__AttributeValue__Group__2__Impl )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6744:2: rule__AttributeValue__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__AttributeValue__Group__2__Impl_in_rule__AttributeValue__Group__213518);
            rule__AttributeValue__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttributeValue__Group__2"


    // $ANTLR start "rule__AttributeValue__Group__2__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6750:1: rule__AttributeValue__Group__2__Impl : ( ']' ) ;
    public final void rule__AttributeValue__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6754:1: ( ( ']' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6755:1: ( ']' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6755:1: ( ']' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6756:1: ']'
            {
             before(grammarAccess.getAttributeValueAccess().getRightSquareBracketKeyword_2()); 
            match(input,50,FOLLOW_50_in_rule__AttributeValue__Group__2__Impl13546); 
             after(grammarAccess.getAttributeValueAccess().getRightSquareBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttributeValue__Group__2__Impl"


    // $ANTLR start "rule__DpfId__Group__0"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6775:1: rule__DpfId__Group__0 : rule__DpfId__Group__0__Impl rule__DpfId__Group__1 ;
    public final void rule__DpfId__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6779:1: ( rule__DpfId__Group__0__Impl rule__DpfId__Group__1 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6780:2: rule__DpfId__Group__0__Impl rule__DpfId__Group__1
            {
            pushFollow(FOLLOW_rule__DpfId__Group__0__Impl_in_rule__DpfId__Group__013583);
            rule__DpfId__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DpfId__Group__1_in_rule__DpfId__Group__013586);
            rule__DpfId__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DpfId__Group__0"


    // $ANTLR start "rule__DpfId__Group__0__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6787:1: rule__DpfId__Group__0__Impl : ( ( rule__DpfId__NameAssignment_0 ) ) ;
    public final void rule__DpfId__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6791:1: ( ( ( rule__DpfId__NameAssignment_0 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6792:1: ( ( rule__DpfId__NameAssignment_0 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6792:1: ( ( rule__DpfId__NameAssignment_0 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6793:1: ( rule__DpfId__NameAssignment_0 )
            {
             before(grammarAccess.getDpfIdAccess().getNameAssignment_0()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6794:1: ( rule__DpfId__NameAssignment_0 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6794:2: rule__DpfId__NameAssignment_0
            {
            pushFollow(FOLLOW_rule__DpfId__NameAssignment_0_in_rule__DpfId__Group__0__Impl13613);
            rule__DpfId__NameAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getDpfIdAccess().getNameAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DpfId__Group__0__Impl"


    // $ANTLR start "rule__DpfId__Group__1"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6804:1: rule__DpfId__Group__1 : rule__DpfId__Group__1__Impl ;
    public final void rule__DpfId__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6808:1: ( rule__DpfId__Group__1__Impl )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6809:2: rule__DpfId__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__DpfId__Group__1__Impl_in_rule__DpfId__Group__113643);
            rule__DpfId__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DpfId__Group__1"


    // $ANTLR start "rule__DpfId__Group__1__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6815:1: rule__DpfId__Group__1__Impl : ( ( rule__DpfId__Group_1__0 )? ) ;
    public final void rule__DpfId__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6819:1: ( ( ( rule__DpfId__Group_1__0 )? ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6820:1: ( ( rule__DpfId__Group_1__0 )? )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6820:1: ( ( rule__DpfId__Group_1__0 )? )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6821:1: ( rule__DpfId__Group_1__0 )?
            {
             before(grammarAccess.getDpfIdAccess().getGroup_1()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6822:1: ( rule__DpfId__Group_1__0 )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==51) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6822:2: rule__DpfId__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__DpfId__Group_1__0_in_rule__DpfId__Group__1__Impl13670);
                    rule__DpfId__Group_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getDpfIdAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DpfId__Group__1__Impl"


    // $ANTLR start "rule__DpfId__Group_1__0"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6836:1: rule__DpfId__Group_1__0 : rule__DpfId__Group_1__0__Impl rule__DpfId__Group_1__1 ;
    public final void rule__DpfId__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6840:1: ( rule__DpfId__Group_1__0__Impl rule__DpfId__Group_1__1 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6841:2: rule__DpfId__Group_1__0__Impl rule__DpfId__Group_1__1
            {
            pushFollow(FOLLOW_rule__DpfId__Group_1__0__Impl_in_rule__DpfId__Group_1__013705);
            rule__DpfId__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DpfId__Group_1__1_in_rule__DpfId__Group_1__013708);
            rule__DpfId__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DpfId__Group_1__0"


    // $ANTLR start "rule__DpfId__Group_1__0__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6848:1: rule__DpfId__Group_1__0__Impl : ( '@' ) ;
    public final void rule__DpfId__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6852:1: ( ( '@' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6853:1: ( '@' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6853:1: ( '@' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6854:1: '@'
            {
             before(grammarAccess.getDpfIdAccess().getCommercialAtKeyword_1_0()); 
            match(input,51,FOLLOW_51_in_rule__DpfId__Group_1__0__Impl13736); 
             after(grammarAccess.getDpfIdAccess().getCommercialAtKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DpfId__Group_1__0__Impl"


    // $ANTLR start "rule__DpfId__Group_1__1"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6867:1: rule__DpfId__Group_1__1 : rule__DpfId__Group_1__1__Impl ;
    public final void rule__DpfId__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6871:1: ( rule__DpfId__Group_1__1__Impl )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6872:2: rule__DpfId__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__DpfId__Group_1__1__Impl_in_rule__DpfId__Group_1__113767);
            rule__DpfId__Group_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DpfId__Group_1__1"


    // $ANTLR start "rule__DpfId__Group_1__1__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6878:1: rule__DpfId__Group_1__1__Impl : ( ( rule__DpfId__IdAssignment_1_1 ) ) ;
    public final void rule__DpfId__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6882:1: ( ( ( rule__DpfId__IdAssignment_1_1 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6883:1: ( ( rule__DpfId__IdAssignment_1_1 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6883:1: ( ( rule__DpfId__IdAssignment_1_1 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6884:1: ( rule__DpfId__IdAssignment_1_1 )
            {
             before(grammarAccess.getDpfIdAccess().getIdAssignment_1_1()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6885:1: ( rule__DpfId__IdAssignment_1_1 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6885:2: rule__DpfId__IdAssignment_1_1
            {
            pushFollow(FOLLOW_rule__DpfId__IdAssignment_1_1_in_rule__DpfId__Group_1__1__Impl13794);
            rule__DpfId__IdAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getDpfIdAccess().getIdAssignment_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DpfId__Group_1__1__Impl"


    // $ANTLR start "rule__Model__CommandsAssignment_2_0"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6900:1: rule__Model__CommandsAssignment_2_0 : ( ruleCommand ) ;
    public final void rule__Model__CommandsAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6904:1: ( ( ruleCommand ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6905:1: ( ruleCommand )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6905:1: ( ruleCommand )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6906:1: ruleCommand
            {
             before(grammarAccess.getModelAccess().getCommandsCommandParserRuleCall_2_0_0()); 
            pushFollow(FOLLOW_ruleCommand_in_rule__Model__CommandsAssignment_2_013833);
            ruleCommand();

            state._fsp--;

             after(grammarAccess.getModelAccess().getCommandsCommandParserRuleCall_2_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__CommandsAssignment_2_0"


    // $ANTLR start "rule__Model__CommandsAssignment_2_1"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6915:1: rule__Model__CommandsAssignment_2_1 : ( ruleCommand ) ;
    public final void rule__Model__CommandsAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6919:1: ( ( ruleCommand ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6920:1: ( ruleCommand )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6920:1: ( ruleCommand )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6921:1: ruleCommand
            {
             before(grammarAccess.getModelAccess().getCommandsCommandParserRuleCall_2_1_0()); 
            pushFollow(FOLLOW_ruleCommand_in_rule__Model__CommandsAssignment_2_113864);
            ruleCommand();

            state._fsp--;

             after(grammarAccess.getModelAccess().getCommandsCommandParserRuleCall_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__CommandsAssignment_2_1"


    // $ANTLR start "rule__MakeEmf__IdAssignment_1"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6930:1: rule__MakeEmf__IdAssignment_1 : ( RULE_ID ) ;
    public final void rule__MakeEmf__IdAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6934:1: ( ( RULE_ID ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6935:1: ( RULE_ID )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6935:1: ( RULE_ID )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6936:1: RULE_ID
            {
             before(grammarAccess.getMakeEmfAccess().getIdIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__MakeEmf__IdAssignment_113895); 
             after(grammarAccess.getMakeEmfAccess().getIdIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MakeEmf__IdAssignment_1"


    // $ANTLR start "rule__MakeEcore__IdAssignment_1"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6945:1: rule__MakeEcore__IdAssignment_1 : ( RULE_ID ) ;
    public final void rule__MakeEcore__IdAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6949:1: ( ( RULE_ID ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6950:1: ( RULE_ID )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6950:1: ( RULE_ID )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6951:1: RULE_ID
            {
             before(grammarAccess.getMakeEcoreAccess().getIdIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__MakeEcore__IdAssignment_113926); 
             after(grammarAccess.getMakeEcoreAccess().getIdIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MakeEcore__IdAssignment_1"


    // $ANTLR start "rule__MakeImage__IdAssignment_1"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6960:1: rule__MakeImage__IdAssignment_1 : ( RULE_ID ) ;
    public final void rule__MakeImage__IdAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6964:1: ( ( RULE_ID ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6965:1: ( RULE_ID )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6965:1: ( RULE_ID )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6966:1: RULE_ID
            {
             before(grammarAccess.getMakeImageAccess().getIdIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__MakeImage__IdAssignment_113957); 
             after(grammarAccess.getMakeImageAccess().getIdIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MakeImage__IdAssignment_1"


    // $ANTLR start "rule__SimpleEvoSpan__LhsAssignment_1"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6975:1: rule__SimpleEvoSpan__LhsAssignment_1 : ( RULE_ID ) ;
    public final void rule__SimpleEvoSpan__LhsAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6979:1: ( ( RULE_ID ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6980:1: ( RULE_ID )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6980:1: ( RULE_ID )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6981:1: RULE_ID
            {
             before(grammarAccess.getSimpleEvoSpanAccess().getLhsIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__SimpleEvoSpan__LhsAssignment_113988); 
             after(grammarAccess.getSimpleEvoSpanAccess().getLhsIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleEvoSpan__LhsAssignment_1"


    // $ANTLR start "rule__SimpleEvoSpan__DiffAssignment_3"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6990:1: rule__SimpleEvoSpan__DiffAssignment_3 : ( RULE_ID ) ;
    public final void rule__SimpleEvoSpan__DiffAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6994:1: ( ( RULE_ID ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6995:1: ( RULE_ID )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6995:1: ( RULE_ID )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6996:1: RULE_ID
            {
             before(grammarAccess.getSimpleEvoSpanAccess().getDiffIDTerminalRuleCall_3_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__SimpleEvoSpan__DiffAssignment_314019); 
             after(grammarAccess.getSimpleEvoSpanAccess().getDiffIDTerminalRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleEvoSpan__DiffAssignment_3"


    // $ANTLR start "rule__SimpleEvoSpan__RhSAssignment_5"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7005:1: rule__SimpleEvoSpan__RhSAssignment_5 : ( RULE_ID ) ;
    public final void rule__SimpleEvoSpan__RhSAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7009:1: ( ( RULE_ID ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7010:1: ( RULE_ID )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7010:1: ( RULE_ID )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7011:1: RULE_ID
            {
             before(grammarAccess.getSimpleEvoSpanAccess().getRhSIDTerminalRuleCall_5_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__SimpleEvoSpan__RhSAssignment_514050); 
             after(grammarAccess.getSimpleEvoSpanAccess().getRhSIDTerminalRuleCall_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleEvoSpan__RhSAssignment_5"


    // $ANTLR start "rule__SimpleEvoSpan__TypeGraphAssignment_7"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7020:1: rule__SimpleEvoSpan__TypeGraphAssignment_7 : ( RULE_ID ) ;
    public final void rule__SimpleEvoSpan__TypeGraphAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7024:1: ( ( RULE_ID ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7025:1: ( RULE_ID )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7025:1: ( RULE_ID )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7026:1: RULE_ID
            {
             before(grammarAccess.getSimpleEvoSpanAccess().getTypeGraphIDTerminalRuleCall_7_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__SimpleEvoSpan__TypeGraphAssignment_714081); 
             after(grammarAccess.getSimpleEvoSpanAccess().getTypeGraphIDTerminalRuleCall_7_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleEvoSpan__TypeGraphAssignment_7"


    // $ANTLR start "rule__SimpleEvoCospan__LhsAssignment_1"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7035:1: rule__SimpleEvoCospan__LhsAssignment_1 : ( RULE_ID ) ;
    public final void rule__SimpleEvoCospan__LhsAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7039:1: ( ( RULE_ID ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7040:1: ( RULE_ID )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7040:1: ( RULE_ID )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7041:1: RULE_ID
            {
             before(grammarAccess.getSimpleEvoCospanAccess().getLhsIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__SimpleEvoCospan__LhsAssignment_114112); 
             after(grammarAccess.getSimpleEvoCospanAccess().getLhsIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleEvoCospan__LhsAssignment_1"


    // $ANTLR start "rule__SimpleEvoCospan__JointAssignment_3"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7050:1: rule__SimpleEvoCospan__JointAssignment_3 : ( RULE_ID ) ;
    public final void rule__SimpleEvoCospan__JointAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7054:1: ( ( RULE_ID ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7055:1: ( RULE_ID )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7055:1: ( RULE_ID )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7056:1: RULE_ID
            {
             before(grammarAccess.getSimpleEvoCospanAccess().getJointIDTerminalRuleCall_3_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__SimpleEvoCospan__JointAssignment_314143); 
             after(grammarAccess.getSimpleEvoCospanAccess().getJointIDTerminalRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleEvoCospan__JointAssignment_3"


    // $ANTLR start "rule__SimpleEvoCospan__RhsAssignment_5"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7065:1: rule__SimpleEvoCospan__RhsAssignment_5 : ( RULE_ID ) ;
    public final void rule__SimpleEvoCospan__RhsAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7069:1: ( ( RULE_ID ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7070:1: ( RULE_ID )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7070:1: ( RULE_ID )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7071:1: RULE_ID
            {
             before(grammarAccess.getSimpleEvoCospanAccess().getRhsIDTerminalRuleCall_5_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__SimpleEvoCospan__RhsAssignment_514174); 
             after(grammarAccess.getSimpleEvoCospanAccess().getRhsIDTerminalRuleCall_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleEvoCospan__RhsAssignment_5"


    // $ANTLR start "rule__SimpleEvoCospan__TypeGraphAssignment_7"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7080:1: rule__SimpleEvoCospan__TypeGraphAssignment_7 : ( RULE_ID ) ;
    public final void rule__SimpleEvoCospan__TypeGraphAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7084:1: ( ( RULE_ID ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7085:1: ( RULE_ID )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7085:1: ( RULE_ID )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7086:1: RULE_ID
            {
             before(grammarAccess.getSimpleEvoCospanAccess().getTypeGraphIDTerminalRuleCall_7_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__SimpleEvoCospan__TypeGraphAssignment_714205); 
             after(grammarAccess.getSimpleEvoCospanAccess().getTypeGraphIDTerminalRuleCall_7_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleEvoCospan__TypeGraphAssignment_7"


    // $ANTLR start "rule__EvoSpan__LhsAssignment_1"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7095:1: rule__EvoSpan__LhsAssignment_1 : ( RULE_ID ) ;
    public final void rule__EvoSpan__LhsAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7099:1: ( ( RULE_ID ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7100:1: ( RULE_ID )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7100:1: ( RULE_ID )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7101:1: RULE_ID
            {
             before(grammarAccess.getEvoSpanAccess().getLhsIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__EvoSpan__LhsAssignment_114236); 
             after(grammarAccess.getEvoSpanAccess().getLhsIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EvoSpan__LhsAssignment_1"


    // $ANTLR start "rule__EvoSpan__RhsAssignment_3"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7110:1: rule__EvoSpan__RhsAssignment_3 : ( RULE_ID ) ;
    public final void rule__EvoSpan__RhsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7114:1: ( ( RULE_ID ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7115:1: ( RULE_ID )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7115:1: ( RULE_ID )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7116:1: RULE_ID
            {
             before(grammarAccess.getEvoSpanAccess().getRhsIDTerminalRuleCall_3_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__EvoSpan__RhsAssignment_314267); 
             after(grammarAccess.getEvoSpanAccess().getRhsIDTerminalRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EvoSpan__RhsAssignment_3"


    // $ANTLR start "rule__EvoSpan__TypeGraphAssignment_5"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7125:1: rule__EvoSpan__TypeGraphAssignment_5 : ( RULE_ID ) ;
    public final void rule__EvoSpan__TypeGraphAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7129:1: ( ( RULE_ID ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7130:1: ( RULE_ID )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7130:1: ( RULE_ID )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7131:1: RULE_ID
            {
             before(grammarAccess.getEvoSpanAccess().getTypeGraphIDTerminalRuleCall_5_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__EvoSpan__TypeGraphAssignment_514298); 
             after(grammarAccess.getEvoSpanAccess().getTypeGraphIDTerminalRuleCall_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EvoSpan__TypeGraphAssignment_5"


    // $ANTLR start "rule__EvoCospan__LhsAssignment_1"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7140:1: rule__EvoCospan__LhsAssignment_1 : ( RULE_ID ) ;
    public final void rule__EvoCospan__LhsAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7144:1: ( ( RULE_ID ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7145:1: ( RULE_ID )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7145:1: ( RULE_ID )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7146:1: RULE_ID
            {
             before(grammarAccess.getEvoCospanAccess().getLhsIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__EvoCospan__LhsAssignment_114329); 
             after(grammarAccess.getEvoCospanAccess().getLhsIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EvoCospan__LhsAssignment_1"


    // $ANTLR start "rule__EvoCospan__RhsAssignment_3"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7155:1: rule__EvoCospan__RhsAssignment_3 : ( RULE_ID ) ;
    public final void rule__EvoCospan__RhsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7159:1: ( ( RULE_ID ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7160:1: ( RULE_ID )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7160:1: ( RULE_ID )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7161:1: RULE_ID
            {
             before(grammarAccess.getEvoCospanAccess().getRhsIDTerminalRuleCall_3_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__EvoCospan__RhsAssignment_314360); 
             after(grammarAccess.getEvoCospanAccess().getRhsIDTerminalRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EvoCospan__RhsAssignment_3"


    // $ANTLR start "rule__EvoCospan__TypeGraphAssignment_5"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7170:1: rule__EvoCospan__TypeGraphAssignment_5 : ( RULE_ID ) ;
    public final void rule__EvoCospan__TypeGraphAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7174:1: ( ( RULE_ID ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7175:1: ( RULE_ID )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7175:1: ( RULE_ID )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7176:1: RULE_ID
            {
             before(grammarAccess.getEvoCospanAccess().getTypeGraphIDTerminalRuleCall_5_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__EvoCospan__TypeGraphAssignment_514391); 
             after(grammarAccess.getEvoCospanAccess().getTypeGraphIDTerminalRuleCall_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EvoCospan__TypeGraphAssignment_5"


    // $ANTLR start "rule__Specification__TypeAssignment_2_0"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7185:1: rule__Specification__TypeAssignment_2_0 : ( ruleChoosenSpecification ) ;
    public final void rule__Specification__TypeAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7189:1: ( ( ruleChoosenSpecification ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7190:1: ( ruleChoosenSpecification )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7190:1: ( ruleChoosenSpecification )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7191:1: ruleChoosenSpecification
            {
             before(grammarAccess.getSpecificationAccess().getTypeChoosenSpecificationParserRuleCall_2_0_0()); 
            pushFollow(FOLLOW_ruleChoosenSpecification_in_rule__Specification__TypeAssignment_2_014422);
            ruleChoosenSpecification();

            state._fsp--;

             after(grammarAccess.getSpecificationAccess().getTypeChoosenSpecificationParserRuleCall_2_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Specification__TypeAssignment_2_0"


    // $ANTLR start "rule__Specification__TypeAssignment_2_1_1"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7200:1: rule__Specification__TypeAssignment_2_1_1 : ( ruleChoosenSpecification ) ;
    public final void rule__Specification__TypeAssignment_2_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7204:1: ( ( ruleChoosenSpecification ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7205:1: ( ruleChoosenSpecification )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7205:1: ( ruleChoosenSpecification )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7206:1: ruleChoosenSpecification
            {
             before(grammarAccess.getSpecificationAccess().getTypeChoosenSpecificationParserRuleCall_2_1_1_0()); 
            pushFollow(FOLLOW_ruleChoosenSpecification_in_rule__Specification__TypeAssignment_2_1_114453);
            ruleChoosenSpecification();

            state._fsp--;

             after(grammarAccess.getSpecificationAccess().getTypeChoosenSpecificationParserRuleCall_2_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Specification__TypeAssignment_2_1_1"


    // $ANTLR start "rule__Specification__ConstraintSemanticAssignment_2_1_3"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7215:1: rule__Specification__ConstraintSemanticAssignment_2_1_3 : ( ruleChoosenConstraintSemantic ) ;
    public final void rule__Specification__ConstraintSemanticAssignment_2_1_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7219:1: ( ( ruleChoosenConstraintSemantic ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7220:1: ( ruleChoosenConstraintSemantic )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7220:1: ( ruleChoosenConstraintSemantic )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7221:1: ruleChoosenConstraintSemantic
            {
             before(grammarAccess.getSpecificationAccess().getConstraintSemanticChoosenConstraintSemanticParserRuleCall_2_1_3_0()); 
            pushFollow(FOLLOW_ruleChoosenConstraintSemantic_in_rule__Specification__ConstraintSemanticAssignment_2_1_314484);
            ruleChoosenConstraintSemantic();

            state._fsp--;

             after(grammarAccess.getSpecificationAccess().getConstraintSemanticChoosenConstraintSemanticParserRuleCall_2_1_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Specification__ConstraintSemanticAssignment_2_1_3"


    // $ANTLR start "rule__Specification__SequenceNumberAssignment_4"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7230:1: rule__Specification__SequenceNumberAssignment_4 : ( ruleSequenceNumber ) ;
    public final void rule__Specification__SequenceNumberAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7234:1: ( ( ruleSequenceNumber ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7235:1: ( ruleSequenceNumber )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7235:1: ( ruleSequenceNumber )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7236:1: ruleSequenceNumber
            {
             before(grammarAccess.getSpecificationAccess().getSequenceNumberSequenceNumberParserRuleCall_4_0()); 
            pushFollow(FOLLOW_ruleSequenceNumber_in_rule__Specification__SequenceNumberAssignment_414515);
            ruleSequenceNumber();

            state._fsp--;

             after(grammarAccess.getSpecificationAccess().getSequenceNumberSequenceNumberParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Specification__SequenceNumberAssignment_4"


    // $ANTLR start "rule__Specification__GraphAssignment_7"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7245:1: rule__Specification__GraphAssignment_7 : ( ruleGraph ) ;
    public final void rule__Specification__GraphAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7249:1: ( ( ruleGraph ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7250:1: ( ruleGraph )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7250:1: ( ruleGraph )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7251:1: ruleGraph
            {
             before(grammarAccess.getSpecificationAccess().getGraphGraphParserRuleCall_7_0()); 
            pushFollow(FOLLOW_ruleGraph_in_rule__Specification__GraphAssignment_714546);
            ruleGraph();

            state._fsp--;

             after(grammarAccess.getSpecificationAccess().getGraphGraphParserRuleCall_7_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Specification__GraphAssignment_7"


    // $ANTLR start "rule__Specification__ConstraintsAssignment_8_2_0"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7260:1: rule__Specification__ConstraintsAssignment_8_2_0 : ( ruleConstraint ) ;
    public final void rule__Specification__ConstraintsAssignment_8_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7264:1: ( ( ruleConstraint ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7265:1: ( ruleConstraint )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7265:1: ( ruleConstraint )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7266:1: ruleConstraint
            {
             before(grammarAccess.getSpecificationAccess().getConstraintsConstraintParserRuleCall_8_2_0_0()); 
            pushFollow(FOLLOW_ruleConstraint_in_rule__Specification__ConstraintsAssignment_8_2_014577);
            ruleConstraint();

            state._fsp--;

             after(grammarAccess.getSpecificationAccess().getConstraintsConstraintParserRuleCall_8_2_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Specification__ConstraintsAssignment_8_2_0"


    // $ANTLR start "rule__Specification__ConstraintsAssignment_8_2_1_1"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7275:1: rule__Specification__ConstraintsAssignment_8_2_1_1 : ( ruleConstraint ) ;
    public final void rule__Specification__ConstraintsAssignment_8_2_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7279:1: ( ( ruleConstraint ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7280:1: ( ruleConstraint )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7280:1: ( ruleConstraint )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7281:1: ruleConstraint
            {
             before(grammarAccess.getSpecificationAccess().getConstraintsConstraintParserRuleCall_8_2_1_1_0()); 
            pushFollow(FOLLOW_ruleConstraint_in_rule__Specification__ConstraintsAssignment_8_2_1_114608);
            ruleConstraint();

            state._fsp--;

             after(grammarAccess.getSpecificationAccess().getConstraintsConstraintParserRuleCall_8_2_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Specification__ConstraintsAssignment_8_2_1_1"


    // $ANTLR start "rule__ChoosenSpecification__IdAssignment"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7290:1: rule__ChoosenSpecification__IdAssignment : ( RULE_ID ) ;
    public final void rule__ChoosenSpecification__IdAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7294:1: ( ( RULE_ID ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7295:1: ( RULE_ID )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7295:1: ( RULE_ID )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7296:1: RULE_ID
            {
             before(grammarAccess.getChoosenSpecificationAccess().getIdIDTerminalRuleCall_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ChoosenSpecification__IdAssignment14639); 
             after(grammarAccess.getChoosenSpecificationAccess().getIdIDTerminalRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ChoosenSpecification__IdAssignment"


    // $ANTLR start "rule__SequenceNumber__NextNumberAssignment"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7305:1: rule__SequenceNumber__NextNumberAssignment : ( RULE_INT ) ;
    public final void rule__SequenceNumber__NextNumberAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7309:1: ( ( RULE_INT ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7310:1: ( RULE_INT )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7310:1: ( RULE_INT )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7311:1: RULE_INT
            {
             before(grammarAccess.getSequenceNumberAccess().getNextNumberINTTerminalRuleCall_0()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__SequenceNumber__NextNumberAssignment14670); 
             after(grammarAccess.getSequenceNumberAccess().getNextNumberINTTerminalRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SequenceNumber__NextNumberAssignment"


    // $ANTLR start "rule__ChoosenConstraintSemantic__IdAssignment"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7320:1: rule__ChoosenConstraintSemantic__IdAssignment : ( RULE_ID ) ;
    public final void rule__ChoosenConstraintSemantic__IdAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7324:1: ( ( RULE_ID ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7325:1: ( RULE_ID )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7325:1: ( RULE_ID )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7326:1: RULE_ID
            {
             before(grammarAccess.getChoosenConstraintSemanticAccess().getIdIDTerminalRuleCall_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ChoosenConstraintSemantic__IdAssignment14701); 
             after(grammarAccess.getChoosenConstraintSemanticAccess().getIdIDTerminalRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ChoosenConstraintSemantic__IdAssignment"


    // $ANTLR start "rule__Constraint__SignatureAssignment_0"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7335:1: rule__Constraint__SignatureAssignment_0 : ( ruleConstraintSignature ) ;
    public final void rule__Constraint__SignatureAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7339:1: ( ( ruleConstraintSignature ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7340:1: ( ruleConstraintSignature )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7340:1: ( ruleConstraintSignature )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7341:1: ruleConstraintSignature
            {
             before(grammarAccess.getConstraintAccess().getSignatureConstraintSignatureParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleConstraintSignature_in_rule__Constraint__SignatureAssignment_014732);
            ruleConstraintSignature();

            state._fsp--;

             after(grammarAccess.getConstraintAccess().getSignatureConstraintSignatureParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constraint__SignatureAssignment_0"


    // $ANTLR start "rule__Constraint__ArrowsAssignment_2_0"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7350:1: rule__Constraint__ArrowsAssignment_2_0 : ( ruleArrows ) ;
    public final void rule__Constraint__ArrowsAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7354:1: ( ( ruleArrows ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7355:1: ( ruleArrows )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7355:1: ( ruleArrows )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7356:1: ruleArrows
            {
             before(grammarAccess.getConstraintAccess().getArrowsArrowsParserRuleCall_2_0_0()); 
            pushFollow(FOLLOW_ruleArrows_in_rule__Constraint__ArrowsAssignment_2_014763);
            ruleArrows();

            state._fsp--;

             after(grammarAccess.getConstraintAccess().getArrowsArrowsParserRuleCall_2_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constraint__ArrowsAssignment_2_0"


    // $ANTLR start "rule__Constraint__ArrowsAssignment_2_1_1"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7365:1: rule__Constraint__ArrowsAssignment_2_1_1 : ( ruleArrows ) ;
    public final void rule__Constraint__ArrowsAssignment_2_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7369:1: ( ( ruleArrows ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7370:1: ( ruleArrows )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7370:1: ( ruleArrows )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7371:1: ruleArrows
            {
             before(grammarAccess.getConstraintAccess().getArrowsArrowsParserRuleCall_2_1_1_0()); 
            pushFollow(FOLLOW_ruleArrows_in_rule__Constraint__ArrowsAssignment_2_1_114794);
            ruleArrows();

            state._fsp--;

             after(grammarAccess.getConstraintAccess().getArrowsArrowsParserRuleCall_2_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constraint__ArrowsAssignment_2_1_1"


    // $ANTLR start "rule__ConstraintSignature__IdAssignment_0"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7380:1: rule__ConstraintSignature__IdAssignment_0 : ( ruleDpfId ) ;
    public final void rule__ConstraintSignature__IdAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7384:1: ( ( ruleDpfId ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7385:1: ( ruleDpfId )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7385:1: ( ruleDpfId )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7386:1: ruleDpfId
            {
             before(grammarAccess.getConstraintSignatureAccess().getIdDpfIdParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleDpfId_in_rule__ConstraintSignature__IdAssignment_014825);
            ruleDpfId();

            state._fsp--;

             after(grammarAccess.getConstraintSignatureAccess().getIdDpfIdParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConstraintSignature__IdAssignment_0"


    // $ANTLR start "rule__ConstraintSignature__ParameterAssignment_2_0"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7395:1: rule__ConstraintSignature__ParameterAssignment_2_0 : ( RULE_STRING ) ;
    public final void rule__ConstraintSignature__ParameterAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7399:1: ( ( RULE_STRING ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7400:1: ( RULE_STRING )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7400:1: ( RULE_STRING )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7401:1: RULE_STRING
            {
             before(grammarAccess.getConstraintSignatureAccess().getParameterSTRINGTerminalRuleCall_2_0_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__ConstraintSignature__ParameterAssignment_2_014856); 
             after(grammarAccess.getConstraintSignatureAccess().getParameterSTRINGTerminalRuleCall_2_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConstraintSignature__ParameterAssignment_2_0"


    // $ANTLR start "rule__ConstraintSignature__ParameterAssignment_2_1_1"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7410:1: rule__ConstraintSignature__ParameterAssignment_2_1_1 : ( RULE_STRING ) ;
    public final void rule__ConstraintSignature__ParameterAssignment_2_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7414:1: ( ( RULE_STRING ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7415:1: ( RULE_STRING )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7415:1: ( RULE_STRING )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7416:1: RULE_STRING
            {
             before(grammarAccess.getConstraintSignatureAccess().getParameterSTRINGTerminalRuleCall_2_1_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__ConstraintSignature__ParameterAssignment_2_1_114887); 
             after(grammarAccess.getConstraintSignatureAccess().getParameterSTRINGTerminalRuleCall_2_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConstraintSignature__ParameterAssignment_2_1_1"


    // $ANTLR start "rule__Signature__ConstraintSemanticsAssignment_0"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7425:1: rule__Signature__ConstraintSemanticsAssignment_0 : ( ruleConstraintSemantic ) ;
    public final void rule__Signature__ConstraintSemanticsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7429:1: ( ( ruleConstraintSemantic ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7430:1: ( ruleConstraintSemantic )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7430:1: ( ruleConstraintSemantic )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7431:1: ruleConstraintSemantic
            {
             before(grammarAccess.getSignatureAccess().getConstraintSemanticsConstraintSemanticParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleConstraintSemantic_in_rule__Signature__ConstraintSemanticsAssignment_014918);
            ruleConstraintSemantic();

            state._fsp--;

             after(grammarAccess.getSignatureAccess().getConstraintSemanticsConstraintSemanticParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Signature__ConstraintSemanticsAssignment_0"


    // $ANTLR start "rule__Signature__ConstraintSemanticsAssignment_1_1"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7440:1: rule__Signature__ConstraintSemanticsAssignment_1_1 : ( ruleConstraintSemantic ) ;
    public final void rule__Signature__ConstraintSemanticsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7444:1: ( ( ruleConstraintSemantic ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7445:1: ( ruleConstraintSemantic )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7445:1: ( ruleConstraintSemantic )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7446:1: ruleConstraintSemantic
            {
             before(grammarAccess.getSignatureAccess().getConstraintSemanticsConstraintSemanticParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_ruleConstraintSemantic_in_rule__Signature__ConstraintSemanticsAssignment_1_114949);
            ruleConstraintSemantic();

            state._fsp--;

             after(grammarAccess.getSignatureAccess().getConstraintSemanticsConstraintSemanticParserRuleCall_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Signature__ConstraintSemanticsAssignment_1_1"


    // $ANTLR start "rule__ConstraintSemantic__IdAssignment_0"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7455:1: rule__ConstraintSemantic__IdAssignment_0 : ( ruleDpfId ) ;
    public final void rule__ConstraintSemantic__IdAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7459:1: ( ( ruleDpfId ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7460:1: ( ruleDpfId )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7460:1: ( ruleDpfId )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7461:1: ruleDpfId
            {
             before(grammarAccess.getConstraintSemanticAccess().getIdDpfIdParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleDpfId_in_rule__ConstraintSemantic__IdAssignment_014980);
            ruleDpfId();

            state._fsp--;

             after(grammarAccess.getConstraintSemanticAccess().getIdDpfIdParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConstraintSemantic__IdAssignment_0"


    // $ANTLR start "rule__ConstraintSemantic__ArrowsAssignment_2_0"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7470:1: rule__ConstraintSemantic__ArrowsAssignment_2_0 : ( ruleArrows ) ;
    public final void rule__ConstraintSemantic__ArrowsAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7474:1: ( ( ruleArrows ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7475:1: ( ruleArrows )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7475:1: ( ruleArrows )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7476:1: ruleArrows
            {
             before(grammarAccess.getConstraintSemanticAccess().getArrowsArrowsParserRuleCall_2_0_0()); 
            pushFollow(FOLLOW_ruleArrows_in_rule__ConstraintSemantic__ArrowsAssignment_2_015011);
            ruleArrows();

            state._fsp--;

             after(grammarAccess.getConstraintSemanticAccess().getArrowsArrowsParserRuleCall_2_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConstraintSemantic__ArrowsAssignment_2_0"


    // $ANTLR start "rule__ConstraintSemantic__ArrowsAssignment_2_1_1"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7485:1: rule__ConstraintSemantic__ArrowsAssignment_2_1_1 : ( ruleArrows ) ;
    public final void rule__ConstraintSemantic__ArrowsAssignment_2_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7489:1: ( ( ruleArrows ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7490:1: ( ruleArrows )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7490:1: ( ruleArrows )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7491:1: ruleArrows
            {
             before(grammarAccess.getConstraintSemanticAccess().getArrowsArrowsParserRuleCall_2_1_1_0()); 
            pushFollow(FOLLOW_ruleArrows_in_rule__ConstraintSemantic__ArrowsAssignment_2_1_115042);
            ruleArrows();

            state._fsp--;

             after(grammarAccess.getConstraintSemanticAccess().getArrowsArrowsParserRuleCall_2_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConstraintSemantic__ArrowsAssignment_2_1_1"


    // $ANTLR start "rule__ConstraintSemantic__OclAssignment_5"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7500:1: rule__ConstraintSemantic__OclAssignment_5 : ( RULE_STRING ) ;
    public final void rule__ConstraintSemantic__OclAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7504:1: ( ( RULE_STRING ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7505:1: ( RULE_STRING )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7505:1: ( RULE_STRING )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7506:1: RULE_STRING
            {
             before(grammarAccess.getConstraintSemanticAccess().getOclSTRINGTerminalRuleCall_5_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__ConstraintSemantic__OclAssignment_515073); 
             after(grammarAccess.getConstraintSemanticAccess().getOclSTRINGTerminalRuleCall_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConstraintSemantic__OclAssignment_5"


    // $ANTLR start "rule__Morphism__DomainAssignment_4"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7515:1: rule__Morphism__DomainAssignment_4 : ( ruleDomain ) ;
    public final void rule__Morphism__DomainAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7519:1: ( ( ruleDomain ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7520:1: ( ruleDomain )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7520:1: ( ruleDomain )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7521:1: ruleDomain
            {
             before(grammarAccess.getMorphismAccess().getDomainDomainParserRuleCall_4_0()); 
            pushFollow(FOLLOW_ruleDomain_in_rule__Morphism__DomainAssignment_415104);
            ruleDomain();

            state._fsp--;

             after(grammarAccess.getMorphismAccess().getDomainDomainParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Morphism__DomainAssignment_4"


    // $ANTLR start "rule__Morphism__CodmainAssignment_6"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7530:1: rule__Morphism__CodmainAssignment_6 : ( ruleCodomain ) ;
    public final void rule__Morphism__CodmainAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7534:1: ( ( ruleCodomain ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7535:1: ( ruleCodomain )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7535:1: ( ruleCodomain )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7536:1: ruleCodomain
            {
             before(grammarAccess.getMorphismAccess().getCodmainCodomainParserRuleCall_6_0()); 
            pushFollow(FOLLOW_ruleCodomain_in_rule__Morphism__CodmainAssignment_615135);
            ruleCodomain();

            state._fsp--;

             after(grammarAccess.getMorphismAccess().getCodmainCodomainParserRuleCall_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Morphism__CodmainAssignment_6"


    // $ANTLR start "rule__Morphism__MappingsAssignment_9_0"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7545:1: rule__Morphism__MappingsAssignment_9_0 : ( ruleMapping ) ;
    public final void rule__Morphism__MappingsAssignment_9_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7549:1: ( ( ruleMapping ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7550:1: ( ruleMapping )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7550:1: ( ruleMapping )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7551:1: ruleMapping
            {
             before(grammarAccess.getMorphismAccess().getMappingsMappingParserRuleCall_9_0_0()); 
            pushFollow(FOLLOW_ruleMapping_in_rule__Morphism__MappingsAssignment_9_015166);
            ruleMapping();

            state._fsp--;

             after(grammarAccess.getMorphismAccess().getMappingsMappingParserRuleCall_9_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Morphism__MappingsAssignment_9_0"


    // $ANTLR start "rule__Morphism__MappingsAssignment_9_1_1"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7560:1: rule__Morphism__MappingsAssignment_9_1_1 : ( ruleMapping ) ;
    public final void rule__Morphism__MappingsAssignment_9_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7564:1: ( ( ruleMapping ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7565:1: ( ruleMapping )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7565:1: ( ruleMapping )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7566:1: ruleMapping
            {
             before(grammarAccess.getMorphismAccess().getMappingsMappingParserRuleCall_9_1_1_0()); 
            pushFollow(FOLLOW_ruleMapping_in_rule__Morphism__MappingsAssignment_9_1_115197);
            ruleMapping();

            state._fsp--;

             after(grammarAccess.getMorphismAccess().getMappingsMappingParserRuleCall_9_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Morphism__MappingsAssignment_9_1_1"


    // $ANTLR start "rule__Domain__IdAssignment"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7575:1: rule__Domain__IdAssignment : ( RULE_ID ) ;
    public final void rule__Domain__IdAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7579:1: ( ( RULE_ID ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7580:1: ( RULE_ID )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7580:1: ( RULE_ID )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7581:1: RULE_ID
            {
             before(grammarAccess.getDomainAccess().getIdIDTerminalRuleCall_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Domain__IdAssignment15228); 
             after(grammarAccess.getDomainAccess().getIdIDTerminalRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Domain__IdAssignment"


    // $ANTLR start "rule__Codomain__IdAssignment"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7590:1: rule__Codomain__IdAssignment : ( RULE_ID ) ;
    public final void rule__Codomain__IdAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7594:1: ( ( RULE_ID ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7595:1: ( RULE_ID )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7595:1: ( RULE_ID )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7596:1: RULE_ID
            {
             before(grammarAccess.getCodomainAccess().getIdIDTerminalRuleCall_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Codomain__IdAssignment15259); 
             after(grammarAccess.getCodomainAccess().getIdIDTerminalRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Codomain__IdAssignment"


    // $ANTLR start "rule__MappingNode__DomainAssignment_0"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7605:1: rule__MappingNode__DomainAssignment_0 : ( ruleNode ) ;
    public final void rule__MappingNode__DomainAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7609:1: ( ( ruleNode ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7610:1: ( ruleNode )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7610:1: ( ruleNode )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7611:1: ruleNode
            {
             before(grammarAccess.getMappingNodeAccess().getDomainNodeParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleNode_in_rule__MappingNode__DomainAssignment_015290);
            ruleNode();

            state._fsp--;

             after(grammarAccess.getMappingNodeAccess().getDomainNodeParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MappingNode__DomainAssignment_0"


    // $ANTLR start "rule__MappingNode__CodomainAssignment_2"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7620:1: rule__MappingNode__CodomainAssignment_2 : ( ruleNode ) ;
    public final void rule__MappingNode__CodomainAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7624:1: ( ( ruleNode ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7625:1: ( ruleNode )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7625:1: ( ruleNode )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7626:1: ruleNode
            {
             before(grammarAccess.getMappingNodeAccess().getCodomainNodeParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleNode_in_rule__MappingNode__CodomainAssignment_215321);
            ruleNode();

            state._fsp--;

             after(grammarAccess.getMappingNodeAccess().getCodomainNodeParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MappingNode__CodomainAssignment_2"


    // $ANTLR start "rule__MappingArrow__DomainAssignment_0"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7635:1: rule__MappingArrow__DomainAssignment_0 : ( ruleArrow ) ;
    public final void rule__MappingArrow__DomainAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7639:1: ( ( ruleArrow ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7640:1: ( ruleArrow )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7640:1: ( ruleArrow )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7641:1: ruleArrow
            {
             before(grammarAccess.getMappingArrowAccess().getDomainArrowParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleArrow_in_rule__MappingArrow__DomainAssignment_015352);
            ruleArrow();

            state._fsp--;

             after(grammarAccess.getMappingArrowAccess().getDomainArrowParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MappingArrow__DomainAssignment_0"


    // $ANTLR start "rule__MappingArrow__CodmainAssignment_2"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7650:1: rule__MappingArrow__CodmainAssignment_2 : ( ruleArrow ) ;
    public final void rule__MappingArrow__CodmainAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7654:1: ( ( ruleArrow ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7655:1: ( ruleArrow )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7655:1: ( ruleArrow )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7656:1: ruleArrow
            {
             before(grammarAccess.getMappingArrowAccess().getCodmainArrowParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleArrow_in_rule__MappingArrow__CodmainAssignment_215383);
            ruleArrow();

            state._fsp--;

             after(grammarAccess.getMappingArrowAccess().getCodmainArrowParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MappingArrow__CodmainAssignment_2"


    // $ANTLR start "rule__ExtSubTGraph__IdAssignment_0"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7665:1: rule__ExtSubTGraph__IdAssignment_0 : ( RULE_ID ) ;
    public final void rule__ExtSubTGraph__IdAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7669:1: ( ( RULE_ID ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7670:1: ( RULE_ID )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7670:1: ( RULE_ID )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7671:1: RULE_ID
            {
             before(grammarAccess.getExtSubTGraphAccess().getIdIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ExtSubTGraph__IdAssignment_015414); 
             after(grammarAccess.getExtSubTGraphAccess().getIdIDTerminalRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExtSubTGraph__IdAssignment_0"


    // $ANTLR start "rule__ExtSubTGraph__ExtendsGraphAssignment_4"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7680:1: rule__ExtSubTGraph__ExtendsGraphAssignment_4 : ( ruleChoosenExtSubTGraph ) ;
    public final void rule__ExtSubTGraph__ExtendsGraphAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7684:1: ( ( ruleChoosenExtSubTGraph ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7685:1: ( ruleChoosenExtSubTGraph )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7685:1: ( ruleChoosenExtSubTGraph )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7686:1: ruleChoosenExtSubTGraph
            {
             before(grammarAccess.getExtSubTGraphAccess().getExtendsGraphChoosenExtSubTGraphParserRuleCall_4_0()); 
            pushFollow(FOLLOW_ruleChoosenExtSubTGraph_in_rule__ExtSubTGraph__ExtendsGraphAssignment_415445);
            ruleChoosenExtSubTGraph();

            state._fsp--;

             after(grammarAccess.getExtSubTGraphAccess().getExtendsGraphChoosenExtSubTGraphParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExtSubTGraph__ExtendsGraphAssignment_4"


    // $ANTLR start "rule__ExtSubTGraph__ElementsAssignment_7_0"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7695:1: rule__ExtSubTGraph__ElementsAssignment_7_0 : ( ruleElement ) ;
    public final void rule__ExtSubTGraph__ElementsAssignment_7_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7699:1: ( ( ruleElement ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7700:1: ( ruleElement )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7700:1: ( ruleElement )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7701:1: ruleElement
            {
             before(grammarAccess.getExtSubTGraphAccess().getElementsElementParserRuleCall_7_0_0()); 
            pushFollow(FOLLOW_ruleElement_in_rule__ExtSubTGraph__ElementsAssignment_7_015476);
            ruleElement();

            state._fsp--;

             after(grammarAccess.getExtSubTGraphAccess().getElementsElementParserRuleCall_7_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExtSubTGraph__ElementsAssignment_7_0"


    // $ANTLR start "rule__ExtSubTGraph__ElementsAssignment_7_1_1"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7710:1: rule__ExtSubTGraph__ElementsAssignment_7_1_1 : ( ruleElement ) ;
    public final void rule__ExtSubTGraph__ElementsAssignment_7_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7714:1: ( ( ruleElement ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7715:1: ( ruleElement )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7715:1: ( ruleElement )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7716:1: ruleElement
            {
             before(grammarAccess.getExtSubTGraphAccess().getElementsElementParserRuleCall_7_1_1_0()); 
            pushFollow(FOLLOW_ruleElement_in_rule__ExtSubTGraph__ElementsAssignment_7_1_115507);
            ruleElement();

            state._fsp--;

             after(grammarAccess.getExtSubTGraphAccess().getElementsElementParserRuleCall_7_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExtSubTGraph__ElementsAssignment_7_1_1"


    // $ANTLR start "rule__ChoosenExtSubTGraph__IdAssignment"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7725:1: rule__ChoosenExtSubTGraph__IdAssignment : ( RULE_ID ) ;
    public final void rule__ChoosenExtSubTGraph__IdAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7729:1: ( ( RULE_ID ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7730:1: ( RULE_ID )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7730:1: ( RULE_ID )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7731:1: RULE_ID
            {
             before(grammarAccess.getChoosenExtSubTGraphAccess().getIdIDTerminalRuleCall_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ChoosenExtSubTGraph__IdAssignment15538); 
             after(grammarAccess.getChoosenExtSubTGraphAccess().getIdIDTerminalRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ChoosenExtSubTGraph__IdAssignment"


    // $ANTLR start "rule__Graph__ElementsAssignment_2_0"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7740:1: rule__Graph__ElementsAssignment_2_0 : ( ruleElement ) ;
    public final void rule__Graph__ElementsAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7744:1: ( ( ruleElement ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7745:1: ( ruleElement )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7745:1: ( ruleElement )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7746:1: ruleElement
            {
             before(grammarAccess.getGraphAccess().getElementsElementParserRuleCall_2_0_0()); 
            pushFollow(FOLLOW_ruleElement_in_rule__Graph__ElementsAssignment_2_015569);
            ruleElement();

            state._fsp--;

             after(grammarAccess.getGraphAccess().getElementsElementParserRuleCall_2_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Graph__ElementsAssignment_2_0"


    // $ANTLR start "rule__Graph__ElementsAssignment_2_1_1"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7755:1: rule__Graph__ElementsAssignment_2_1_1 : ( ruleElement ) ;
    public final void rule__Graph__ElementsAssignment_2_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7759:1: ( ( ruleElement ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7760:1: ( ruleElement )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7760:1: ( ruleElement )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7761:1: ruleElement
            {
             before(grammarAccess.getGraphAccess().getElementsElementParserRuleCall_2_1_1_0()); 
            pushFollow(FOLLOW_ruleElement_in_rule__Graph__ElementsAssignment_2_1_115600);
            ruleElement();

            state._fsp--;

             after(grammarAccess.getGraphAccess().getElementsElementParserRuleCall_2_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Graph__ElementsAssignment_2_1_1"


    // $ANTLR start "rule__Arrows__SrAssignment_0_0"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7770:1: rule__Arrows__SrAssignment_0_0 : ( ruleNode ) ;
    public final void rule__Arrows__SrAssignment_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7774:1: ( ( ruleNode ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7775:1: ( ruleNode )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7775:1: ( ruleNode )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7776:1: ruleNode
            {
             before(grammarAccess.getArrowsAccess().getSrNodeParserRuleCall_0_0_0()); 
            pushFollow(FOLLOW_ruleNode_in_rule__Arrows__SrAssignment_0_015631);
            ruleNode();

            state._fsp--;

             after(grammarAccess.getArrowsAccess().getSrNodeParserRuleCall_0_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Arrows__SrAssignment_0_0"


    // $ANTLR start "rule__Arrows__IdAssignment_0_2"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7785:1: rule__Arrows__IdAssignment_0_2 : ( ruleDpfId ) ;
    public final void rule__Arrows__IdAssignment_0_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7789:1: ( ( ruleDpfId ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7790:1: ( ruleDpfId )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7790:1: ( ruleDpfId )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7791:1: ruleDpfId
            {
             before(grammarAccess.getArrowsAccess().getIdDpfIdParserRuleCall_0_2_0()); 
            pushFollow(FOLLOW_ruleDpfId_in_rule__Arrows__IdAssignment_0_215662);
            ruleDpfId();

            state._fsp--;

             after(grammarAccess.getArrowsAccess().getIdDpfIdParserRuleCall_0_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Arrows__IdAssignment_0_2"


    // $ANTLR start "rule__Arrows__TypeAssignment_0_4"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7800:1: rule__Arrows__TypeAssignment_0_4 : ( ruleDpfId ) ;
    public final void rule__Arrows__TypeAssignment_0_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7804:1: ( ( ruleDpfId ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7805:1: ( ruleDpfId )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7805:1: ( ruleDpfId )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7806:1: ruleDpfId
            {
             before(grammarAccess.getArrowsAccess().getTypeDpfIdParserRuleCall_0_4_0()); 
            pushFollow(FOLLOW_ruleDpfId_in_rule__Arrows__TypeAssignment_0_415693);
            ruleDpfId();

            state._fsp--;

             after(grammarAccess.getArrowsAccess().getTypeDpfIdParserRuleCall_0_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Arrows__TypeAssignment_0_4"


    // $ANTLR start "rule__Arrows__NextAssignment_0_6"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7815:1: rule__Arrows__NextAssignment_0_6 : ( ruleArrows ) ;
    public final void rule__Arrows__NextAssignment_0_6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7819:1: ( ( ruleArrows ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7820:1: ( ruleArrows )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7820:1: ( ruleArrows )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7821:1: ruleArrows
            {
             before(grammarAccess.getArrowsAccess().getNextArrowsParserRuleCall_0_6_0()); 
            pushFollow(FOLLOW_ruleArrows_in_rule__Arrows__NextAssignment_0_615724);
            ruleArrows();

            state._fsp--;

             after(grammarAccess.getArrowsAccess().getNextArrowsParserRuleCall_0_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Arrows__NextAssignment_0_6"


    // $ANTLR start "rule__Arrow__SrAssignment_0_0"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7830:1: rule__Arrow__SrAssignment_0_0 : ( ruleNode ) ;
    public final void rule__Arrow__SrAssignment_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7834:1: ( ( ruleNode ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7835:1: ( ruleNode )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7835:1: ( ruleNode )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7836:1: ruleNode
            {
             before(grammarAccess.getArrowAccess().getSrNodeParserRuleCall_0_0_0()); 
            pushFollow(FOLLOW_ruleNode_in_rule__Arrow__SrAssignment_0_015755);
            ruleNode();

            state._fsp--;

             after(grammarAccess.getArrowAccess().getSrNodeParserRuleCall_0_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Arrow__SrAssignment_0_0"


    // $ANTLR start "rule__Arrow__IdAssignment_0_2"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7845:1: rule__Arrow__IdAssignment_0_2 : ( ruleDpfId ) ;
    public final void rule__Arrow__IdAssignment_0_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7849:1: ( ( ruleDpfId ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7850:1: ( ruleDpfId )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7850:1: ( ruleDpfId )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7851:1: ruleDpfId
            {
             before(grammarAccess.getArrowAccess().getIdDpfIdParserRuleCall_0_2_0()); 
            pushFollow(FOLLOW_ruleDpfId_in_rule__Arrow__IdAssignment_0_215786);
            ruleDpfId();

            state._fsp--;

             after(grammarAccess.getArrowAccess().getIdDpfIdParserRuleCall_0_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Arrow__IdAssignment_0_2"


    // $ANTLR start "rule__Arrow__TgDataTypeAssignment_0_6"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7860:1: rule__Arrow__TgDataTypeAssignment_0_6 : ( ruleDataType ) ;
    public final void rule__Arrow__TgDataTypeAssignment_0_6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7864:1: ( ( ruleDataType ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7865:1: ( ruleDataType )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7865:1: ( ruleDataType )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7866:1: ruleDataType
            {
             before(grammarAccess.getArrowAccess().getTgDataTypeDataTypeEnumRuleCall_0_6_0()); 
            pushFollow(FOLLOW_ruleDataType_in_rule__Arrow__TgDataTypeAssignment_0_615817);
            ruleDataType();

            state._fsp--;

             after(grammarAccess.getArrowAccess().getTgDataTypeDataTypeEnumRuleCall_0_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Arrow__TgDataTypeAssignment_0_6"


    // $ANTLR start "rule__Arrow__SrAssignment_1_0"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7875:1: rule__Arrow__SrAssignment_1_0 : ( ruleNode ) ;
    public final void rule__Arrow__SrAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7879:1: ( ( ruleNode ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7880:1: ( ruleNode )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7880:1: ( ruleNode )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7881:1: ruleNode
            {
             before(grammarAccess.getArrowAccess().getSrNodeParserRuleCall_1_0_0()); 
            pushFollow(FOLLOW_ruleNode_in_rule__Arrow__SrAssignment_1_015848);
            ruleNode();

            state._fsp--;

             after(grammarAccess.getArrowAccess().getSrNodeParserRuleCall_1_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Arrow__SrAssignment_1_0"


    // $ANTLR start "rule__Arrow__IdAssignment_1_2"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7890:1: rule__Arrow__IdAssignment_1_2 : ( ruleDpfId ) ;
    public final void rule__Arrow__IdAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7894:1: ( ( ruleDpfId ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7895:1: ( ruleDpfId )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7895:1: ( ruleDpfId )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7896:1: ruleDpfId
            {
             before(grammarAccess.getArrowAccess().getIdDpfIdParserRuleCall_1_2_0()); 
            pushFollow(FOLLOW_ruleDpfId_in_rule__Arrow__IdAssignment_1_215879);
            ruleDpfId();

            state._fsp--;

             after(grammarAccess.getArrowAccess().getIdDpfIdParserRuleCall_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Arrow__IdAssignment_1_2"


    // $ANTLR start "rule__Arrow__TypeAssignment_1_4"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7905:1: rule__Arrow__TypeAssignment_1_4 : ( ruleDpfId ) ;
    public final void rule__Arrow__TypeAssignment_1_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7909:1: ( ( ruleDpfId ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7910:1: ( ruleDpfId )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7910:1: ( ruleDpfId )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7911:1: ruleDpfId
            {
             before(grammarAccess.getArrowAccess().getTypeDpfIdParserRuleCall_1_4_0()); 
            pushFollow(FOLLOW_ruleDpfId_in_rule__Arrow__TypeAssignment_1_415910);
            ruleDpfId();

            state._fsp--;

             after(grammarAccess.getArrowAccess().getTypeDpfIdParserRuleCall_1_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Arrow__TypeAssignment_1_4"


    // $ANTLR start "rule__Arrow__TgValueAssignment_1_6"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7920:1: rule__Arrow__TgValueAssignment_1_6 : ( ruleAttributeValue ) ;
    public final void rule__Arrow__TgValueAssignment_1_6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7924:1: ( ( ruleAttributeValue ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7925:1: ( ruleAttributeValue )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7925:1: ( ruleAttributeValue )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7926:1: ruleAttributeValue
            {
             before(grammarAccess.getArrowAccess().getTgValueAttributeValueParserRuleCall_1_6_0()); 
            pushFollow(FOLLOW_ruleAttributeValue_in_rule__Arrow__TgValueAssignment_1_615941);
            ruleAttributeValue();

            state._fsp--;

             after(grammarAccess.getArrowAccess().getTgValueAttributeValueParserRuleCall_1_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Arrow__TgValueAssignment_1_6"


    // $ANTLR start "rule__Arrow__SrAssignment_2_0"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7935:1: rule__Arrow__SrAssignment_2_0 : ( ruleNode ) ;
    public final void rule__Arrow__SrAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7939:1: ( ( ruleNode ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7940:1: ( ruleNode )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7940:1: ( ruleNode )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7941:1: ruleNode
            {
             before(grammarAccess.getArrowAccess().getSrNodeParserRuleCall_2_0_0()); 
            pushFollow(FOLLOW_ruleNode_in_rule__Arrow__SrAssignment_2_015972);
            ruleNode();

            state._fsp--;

             after(grammarAccess.getArrowAccess().getSrNodeParserRuleCall_2_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Arrow__SrAssignment_2_0"


    // $ANTLR start "rule__Arrow__IdAssignment_2_2"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7950:1: rule__Arrow__IdAssignment_2_2 : ( ruleDpfId ) ;
    public final void rule__Arrow__IdAssignment_2_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7954:1: ( ( ruleDpfId ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7955:1: ( ruleDpfId )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7955:1: ( ruleDpfId )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7956:1: ruleDpfId
            {
             before(grammarAccess.getArrowAccess().getIdDpfIdParserRuleCall_2_2_0()); 
            pushFollow(FOLLOW_ruleDpfId_in_rule__Arrow__IdAssignment_2_216003);
            ruleDpfId();

            state._fsp--;

             after(grammarAccess.getArrowAccess().getIdDpfIdParserRuleCall_2_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Arrow__IdAssignment_2_2"


    // $ANTLR start "rule__Arrow__TypeAssignment_2_4"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7965:1: rule__Arrow__TypeAssignment_2_4 : ( ruleDpfId ) ;
    public final void rule__Arrow__TypeAssignment_2_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7969:1: ( ( ruleDpfId ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7970:1: ( ruleDpfId )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7970:1: ( ruleDpfId )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7971:1: ruleDpfId
            {
             before(grammarAccess.getArrowAccess().getTypeDpfIdParserRuleCall_2_4_0()); 
            pushFollow(FOLLOW_ruleDpfId_in_rule__Arrow__TypeAssignment_2_416034);
            ruleDpfId();

            state._fsp--;

             after(grammarAccess.getArrowAccess().getTypeDpfIdParserRuleCall_2_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Arrow__TypeAssignment_2_4"


    // $ANTLR start "rule__Arrow__TgNodeAssignment_2_6"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7980:1: rule__Arrow__TgNodeAssignment_2_6 : ( ruleNode ) ;
    public final void rule__Arrow__TgNodeAssignment_2_6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7984:1: ( ( ruleNode ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7985:1: ( ruleNode )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7985:1: ( ruleNode )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7986:1: ruleNode
            {
             before(grammarAccess.getArrowAccess().getTgNodeNodeParserRuleCall_2_6_0()); 
            pushFollow(FOLLOW_ruleNode_in_rule__Arrow__TgNodeAssignment_2_616065);
            ruleNode();

            state._fsp--;

             after(grammarAccess.getArrowAccess().getTgNodeNodeParserRuleCall_2_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Arrow__TgNodeAssignment_2_6"


    // $ANTLR start "rule__Node__IdAssignment_0"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7995:1: rule__Node__IdAssignment_0 : ( ruleDpfId ) ;
    public final void rule__Node__IdAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7999:1: ( ( ruleDpfId ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:8000:1: ( ruleDpfId )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:8000:1: ( ruleDpfId )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:8001:1: ruleDpfId
            {
             before(grammarAccess.getNodeAccess().getIdDpfIdParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleDpfId_in_rule__Node__IdAssignment_016096);
            ruleDpfId();

            state._fsp--;

             after(grammarAccess.getNodeAccess().getIdDpfIdParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__IdAssignment_0"


    // $ANTLR start "rule__Node__TypeAssignment_2"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:8010:1: rule__Node__TypeAssignment_2 : ( ruleDpfId ) ;
    public final void rule__Node__TypeAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:8014:1: ( ( ruleDpfId ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:8015:1: ( ruleDpfId )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:8015:1: ( ruleDpfId )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:8016:1: ruleDpfId
            {
             before(grammarAccess.getNodeAccess().getTypeDpfIdParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleDpfId_in_rule__Node__TypeAssignment_216127);
            ruleDpfId();

            state._fsp--;

             after(grammarAccess.getNodeAccess().getTypeDpfIdParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__TypeAssignment_2"


    // $ANTLR start "rule__AttributeValue__ValueAssignment_1"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:8025:1: rule__AttributeValue__ValueAssignment_1 : ( ruleVALUE ) ;
    public final void rule__AttributeValue__ValueAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:8029:1: ( ( ruleVALUE ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:8030:1: ( ruleVALUE )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:8030:1: ( ruleVALUE )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:8031:1: ruleVALUE
            {
             before(grammarAccess.getAttributeValueAccess().getValueVALUEParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleVALUE_in_rule__AttributeValue__ValueAssignment_116158);
            ruleVALUE();

            state._fsp--;

             after(grammarAccess.getAttributeValueAccess().getValueVALUEParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttributeValue__ValueAssignment_1"


    // $ANTLR start "rule__DpfId__NameAssignment_0"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:8040:1: rule__DpfId__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__DpfId__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:8044:1: ( ( RULE_ID ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:8045:1: ( RULE_ID )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:8045:1: ( RULE_ID )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:8046:1: RULE_ID
            {
             before(grammarAccess.getDpfIdAccess().getNameIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__DpfId__NameAssignment_016189); 
             after(grammarAccess.getDpfIdAccess().getNameIDTerminalRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DpfId__NameAssignment_0"


    // $ANTLR start "rule__DpfId__IdAssignment_1_1"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:8055:1: rule__DpfId__IdAssignment_1_1 : ( RULE_INT ) ;
    public final void rule__DpfId__IdAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:8059:1: ( ( RULE_INT ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:8060:1: ( RULE_INT )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:8060:1: ( RULE_INT )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:8061:1: RULE_INT
            {
             before(grammarAccess.getDpfIdAccess().getIdINTTerminalRuleCall_1_1_0()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__DpfId__IdAssignment_1_116220); 
             after(grammarAccess.getDpfIdAccess().getIdINTTerminalRuleCall_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DpfId__IdAssignment_1_1"

    // Delegated rules


    protected DFA4 dfa4 = new DFA4(this);
    protected DFA6 dfa6 = new DFA6(this);
    protected DFA7 dfa7 = new DFA7(this);
    protected DFA8 dfa8 = new DFA8(this);
    protected DFA9 dfa9 = new DFA9(this);
    static final String DFA4_eotS =
        "\20\uffff";
    static final String DFA4_eofS =
        "\20\uffff";
    static final String DFA4_minS =
        "\1\7\3\uffff\1\52\2\7\1\53\1\33\1\37\6\uffff";
    static final String DFA4_maxS =
        "\1\36\3\uffff\1\52\2\7\1\55\1\34\1\40\6\uffff";
    static final String DFA4_acceptS =
        "\1\uffff\1\1\1\2\1\3\6\uffff\1\4\1\7\1\5\1\6\1\11\1\10";
    static final String DFA4_specialS =
        "\20\uffff}>";
    static final String[] DFA4_transitionS = {
            "\1\4\16\uffff\1\1\1\uffff\1\2\1\3\1\5\3\uffff\1\6",
            "",
            "",
            "",
            "\1\7",
            "\1\10",
            "\1\11",
            "\1\13\1\uffff\1\12",
            "\1\14\1\15",
            "\1\17\1\16",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA4_eot = DFA.unpackEncodedString(DFA4_eotS);
    static final short[] DFA4_eof = DFA.unpackEncodedString(DFA4_eofS);
    static final char[] DFA4_min = DFA.unpackEncodedStringToUnsignedChars(DFA4_minS);
    static final char[] DFA4_max = DFA.unpackEncodedStringToUnsignedChars(DFA4_maxS);
    static final short[] DFA4_accept = DFA.unpackEncodedString(DFA4_acceptS);
    static final short[] DFA4_special = DFA.unpackEncodedString(DFA4_specialS);
    static final short[][] DFA4_transition;

    static {
        int numStates = DFA4_transitionS.length;
        DFA4_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA4_transition[i] = DFA.unpackEncodedString(DFA4_transitionS[i]);
        }
    }

    class DFA4 extends DFA {

        public DFA4(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 4;
            this.eot = DFA4_eot;
            this.eof = DFA4_eof;
            this.min = DFA4_min;
            this.max = DFA4_max;
            this.accept = DFA4_accept;
            this.special = DFA4_special;
            this.transition = DFA4_transition;
        }
        public String getDescription() {
            return "1059:1: rule__Command__Alternatives : ( ( ruleMakeEmf ) | ( ruleMakeEcore ) | ( ruleMakeImage ) | ( ruleExtSubTGraph ) | ( ruleSimpleEvoSpan ) | ( ruleSimpleEvoCospan ) | ( ruleMorphism ) | ( ruleEvoSpan ) | ( ruleEvoCospan ) );";
        }
    }
    static final String DFA6_eotS =
        "\12\uffff";
    static final String DFA6_eofS =
        "\12\uffff";
    static final String DFA6_minS =
        "\1\7\1\42\1\10\1\7\1\42\1\54\1\10\2\uffff\1\54";
    static final String DFA6_maxS =
        "\1\7\1\63\1\10\1\7\1\42\1\63\1\10\2\uffff\1\57";
    static final String DFA6_acceptS =
        "\7\uffff\1\2\1\1\1\uffff";
    static final String DFA6_specialS =
        "\12\uffff}>";
    static final String[] DFA6_transitionS = {
            "\1\1",
            "\1\3\20\uffff\1\2",
            "\1\4",
            "\1\5",
            "\1\3",
            "\1\10\2\uffff\1\7\3\uffff\1\6",
            "\1\11",
            "",
            "",
            "\1\10\2\uffff\1\7"
    };

    static final short[] DFA6_eot = DFA.unpackEncodedString(DFA6_eotS);
    static final short[] DFA6_eof = DFA.unpackEncodedString(DFA6_eofS);
    static final char[] DFA6_min = DFA.unpackEncodedStringToUnsignedChars(DFA6_minS);
    static final char[] DFA6_max = DFA.unpackEncodedStringToUnsignedChars(DFA6_maxS);
    static final short[] DFA6_accept = DFA.unpackEncodedString(DFA6_acceptS);
    static final short[] DFA6_special = DFA.unpackEncodedString(DFA6_specialS);
    static final short[][] DFA6_transition;

    static {
        int numStates = DFA6_transitionS.length;
        DFA6_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA6_transition[i] = DFA.unpackEncodedString(DFA6_transitionS[i]);
        }
    }

    class DFA6 extends DFA {

        public DFA6(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 6;
            this.eot = DFA6_eot;
            this.eof = DFA6_eof;
            this.min = DFA6_min;
            this.max = DFA6_max;
            this.accept = DFA6_accept;
            this.special = DFA6_special;
            this.transition = DFA6_transition;
        }
        public String getDescription() {
            return "1145:1: rule__Mapping__Alternatives : ( ( ruleMappingNode ) | ( ruleMappingArrow ) );";
        }
    }
    static final String DFA7_eotS =
        "\12\uffff";
    static final String DFA7_eofS =
        "\5\uffff\1\10\3\uffff\1\10";
    static final String DFA7_minS =
        "\1\7\1\42\1\10\1\7\1\42\1\35\1\10\2\uffff\1\35";
    static final String DFA7_maxS =
        "\1\7\1\63\1\10\1\7\1\42\1\63\1\10\2\uffff\1\57";
    static final String DFA7_acceptS =
        "\7\uffff\1\2\1\1\1\uffff";
    static final String DFA7_specialS =
        "\12\uffff}>";
    static final String[] DFA7_transitionS = {
            "\1\1",
            "\1\3\20\uffff\1\2",
            "\1\4",
            "\1\5",
            "\1\3",
            "\1\10\10\uffff\1\10\10\uffff\1\7\3\uffff\1\6",
            "\1\11",
            "",
            "",
            "\1\10\10\uffff\1\10\10\uffff\1\7"
    };

    static final short[] DFA7_eot = DFA.unpackEncodedString(DFA7_eotS);
    static final short[] DFA7_eof = DFA.unpackEncodedString(DFA7_eofS);
    static final char[] DFA7_min = DFA.unpackEncodedStringToUnsignedChars(DFA7_minS);
    static final char[] DFA7_max = DFA.unpackEncodedStringToUnsignedChars(DFA7_maxS);
    static final short[] DFA7_accept = DFA.unpackEncodedString(DFA7_acceptS);
    static final short[] DFA7_special = DFA.unpackEncodedString(DFA7_specialS);
    static final short[][] DFA7_transition;

    static {
        int numStates = DFA7_transitionS.length;
        DFA7_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA7_transition[i] = DFA.unpackEncodedString(DFA7_transitionS[i]);
        }
    }

    class DFA7 extends DFA {

        public DFA7(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 7;
            this.eot = DFA7_eot;
            this.eof = DFA7_eof;
            this.min = DFA7_min;
            this.max = DFA7_max;
            this.accept = DFA7_accept;
            this.special = DFA7_special;
            this.transition = DFA7_transition;
        }
        public String getDescription() {
            return "1167:1: rule__Element__Alternatives : ( ( ruleNode ) | ( ruleArrows ) );";
        }
    }
    static final String DFA8_eotS =
        "\32\uffff";
    static final String DFA8_eofS =
        "\26\uffff\1\16\2\uffff\1\16";
    static final String DFA8_minS =
        "\1\7\1\42\1\10\1\7\1\42\1\57\1\10\1\7\1\57\1\42\1\10\1\7\1\42\1"+
        "\34\1\uffff\1\10\1\7\1\34\1\42\1\10\1\7\1\42\1\35\1\10\1\uffff\1"+
        "\35";
    static final String DFA8_maxS =
        "\1\7\1\63\1\10\1\7\1\42\1\63\1\10\1\7\1\57\1\63\1\10\1\60\1\42\1"+
        "\63\1\uffff\1\10\1\61\1\34\1\63\1\10\1\7\1\42\1\63\1\10\1\uffff"+
        "\1\57";
    static final String DFA8_acceptS =
        "\16\uffff\1\2\11\uffff\1\1\1\uffff";
    static final String DFA8_specialS =
        "\32\uffff}>";
    static final String[] DFA8_transitionS = {
            "\1\1",
            "\1\3\20\uffff\1\2",
            "\1\4",
            "\1\5",
            "\1\3",
            "\1\7\3\uffff\1\6",
            "\1\10",
            "\1\11",
            "\1\7",
            "\1\13\20\uffff\1\12",
            "\1\14",
            "\1\15\50\uffff\1\16",
            "\1\13",
            "\1\20\26\uffff\1\17",
            "",
            "\1\21",
            "\1\22\51\uffff\1\16",
            "\1\20",
            "\1\24\20\uffff\1\23",
            "\1\25",
            "\1\26",
            "\1\24",
            "\1\16\10\uffff\1\16\10\uffff\1\30\3\uffff\1\27",
            "\1\31",
            "",
            "\1\16\10\uffff\1\16\10\uffff\1\30"
    };

    static final short[] DFA8_eot = DFA.unpackEncodedString(DFA8_eotS);
    static final short[] DFA8_eof = DFA.unpackEncodedString(DFA8_eofS);
    static final char[] DFA8_min = DFA.unpackEncodedStringToUnsignedChars(DFA8_minS);
    static final char[] DFA8_max = DFA.unpackEncodedStringToUnsignedChars(DFA8_maxS);
    static final short[] DFA8_accept = DFA.unpackEncodedString(DFA8_acceptS);
    static final short[] DFA8_special = DFA.unpackEncodedString(DFA8_specialS);
    static final short[][] DFA8_transition;

    static {
        int numStates = DFA8_transitionS.length;
        DFA8_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA8_transition[i] = DFA.unpackEncodedString(DFA8_transitionS[i]);
        }
    }

    class DFA8 extends DFA {

        public DFA8(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 8;
            this.eot = DFA8_eot;
            this.eof = DFA8_eof;
            this.min = DFA8_min;
            this.max = DFA8_max;
            this.accept = DFA8_accept;
            this.special = DFA8_special;
            this.transition = DFA8_transition;
        }
        public String getDescription() {
            return "1189:1: rule__Arrows__Alternatives : ( ( ( rule__Arrows__Group_0__0 ) ) | ( ruleArrow ) );";
        }
    }
    static final String DFA9_eotS =
        "\24\uffff";
    static final String DFA9_eofS =
        "\24\uffff";
    static final String DFA9_minS =
        "\1\7\1\42\1\10\1\7\1\42\1\57\1\10\1\7\1\57\1\42\1\10\1\7\1\42\1"+
        "\uffff\1\34\1\10\1\7\1\34\2\uffff";
    static final String DFA9_maxS =
        "\1\7\1\63\1\10\1\7\1\42\1\63\1\10\1\7\1\57\1\63\1\10\1\60\1\42\1"+
        "\uffff\1\63\1\10\1\61\1\34\2\uffff";
    static final String DFA9_acceptS =
        "\15\uffff\1\1\4\uffff\1\2\1\3";
    static final String DFA9_specialS =
        "\24\uffff}>";
    static final String[] DFA9_transitionS = {
            "\1\1",
            "\1\3\20\uffff\1\2",
            "\1\4",
            "\1\5",
            "\1\3",
            "\1\7\3\uffff\1\6",
            "\1\10",
            "\1\11",
            "\1\7",
            "\1\13\20\uffff\1\12",
            "\1\14",
            "\1\16\50\uffff\1\15",
            "\1\13",
            "",
            "\1\20\26\uffff\1\17",
            "\1\21",
            "\1\23\51\uffff\1\22",
            "\1\20",
            "",
            ""
    };

    static final short[] DFA9_eot = DFA.unpackEncodedString(DFA9_eotS);
    static final short[] DFA9_eof = DFA.unpackEncodedString(DFA9_eofS);
    static final char[] DFA9_min = DFA.unpackEncodedStringToUnsignedChars(DFA9_minS);
    static final char[] DFA9_max = DFA.unpackEncodedStringToUnsignedChars(DFA9_maxS);
    static final short[] DFA9_accept = DFA.unpackEncodedString(DFA9_acceptS);
    static final short[] DFA9_special = DFA.unpackEncodedString(DFA9_specialS);
    static final short[][] DFA9_transition;

    static {
        int numStates = DFA9_transitionS.length;
        DFA9_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA9_transition[i] = DFA.unpackEncodedString(DFA9_transitionS[i]);
        }
    }

    class DFA9 extends DFA {

        public DFA9(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 9;
            this.eot = DFA9_eot;
            this.eof = DFA9_eof;
            this.min = DFA9_min;
            this.max = DFA9_max;
            this.accept = DFA9_accept;
            this.special = DFA9_special;
            this.transition = DFA9_transition;
        }
        public String getDescription() {
            return "1211:1: rule__Arrow__Alternatives : ( ( ( rule__Arrow__Group_0__0 ) ) | ( ( rule__Arrow__Group_1__0 ) ) | ( ( rule__Arrow__Group_2__0 ) ) );";
        }
    }
 

    public static final BitSet FOLLOW_ruleModel_in_entryRuleModel61 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModel68 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__Alternatives_in_ruleModel94 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVALUE_in_entryRuleVALUE121 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVALUE128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VALUE__Alternatives_in_ruleVALUE154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCommand_in_entryRuleCommand181 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCommand188 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Command__Alternatives_in_ruleCommand214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMakeEmf_in_entryRuleMakeEmf241 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMakeEmf248 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MakeEmf__Group__0_in_ruleMakeEmf274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMakeEcore_in_entryRuleMakeEcore301 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMakeEcore308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MakeEcore__Group__0_in_ruleMakeEcore334 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMakeImage_in_entryRuleMakeImage361 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMakeImage368 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MakeImage__Group__0_in_ruleMakeImage394 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSimpleEvoSpan_in_entryRuleSimpleEvoSpan421 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSimpleEvoSpan428 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleEvoSpan__Group__0_in_ruleSimpleEvoSpan454 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSimpleEvoCospan_in_entryRuleSimpleEvoCospan481 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSimpleEvoCospan488 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleEvoCospan__Group__0_in_ruleSimpleEvoCospan514 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEvoSpan_in_entryRuleEvoSpan541 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEvoSpan548 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EvoSpan__Group__0_in_ruleEvoSpan574 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEvoCospan_in_entryRuleEvoCospan601 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEvoCospan608 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EvoCospan__Group__0_in_ruleEvoCospan634 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSpecification_in_entryRuleSpecification661 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSpecification668 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Specification__Group__0_in_ruleSpecification694 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleChoosenSpecification_in_entryRuleChoosenSpecification721 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleChoosenSpecification728 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ChoosenSpecification__IdAssignment_in_ruleChoosenSpecification754 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSequenceNumber_in_entryRuleSequenceNumber781 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSequenceNumber788 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SequenceNumber__NextNumberAssignment_in_ruleSequenceNumber814 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleChoosenConstraintSemantic_in_entryRuleChoosenConstraintSemantic841 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleChoosenConstraintSemantic848 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ChoosenConstraintSemantic__IdAssignment_in_ruleChoosenConstraintSemantic874 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConstraint_in_entryRuleConstraint901 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConstraint908 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Constraint__Group__0_in_ruleConstraint934 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConstraintSignature_in_entryRuleConstraintSignature961 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConstraintSignature968 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConstraintSignature__Group__0_in_ruleConstraintSignature994 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSignature_in_entryRuleSignature1021 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSignature1028 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Signature__Group__0_in_ruleSignature1054 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConstraintSemantic_in_entryRuleConstraintSemantic1081 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConstraintSemantic1088 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConstraintSemantic__Group__0_in_ruleConstraintSemantic1114 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMorphism_in_entryRuleMorphism1141 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMorphism1148 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Morphism__Group__0_in_ruleMorphism1174 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDomain_in_entryRuleDomain1201 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDomain1208 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Domain__IdAssignment_in_ruleDomain1234 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCodomain_in_entryRuleCodomain1261 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCodomain1268 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Codomain__IdAssignment_in_ruleCodomain1294 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMapping_in_entryRuleMapping1321 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMapping1328 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Mapping__Alternatives_in_ruleMapping1354 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMappingNode_in_entryRuleMappingNode1381 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMappingNode1388 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MappingNode__Group__0_in_ruleMappingNode1414 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMappingArrow_in_entryRuleMappingArrow1441 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMappingArrow1448 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MappingArrow__Group__0_in_ruleMappingArrow1474 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExtSubTGraph_in_entryRuleExtSubTGraph1501 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExtSubTGraph1508 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExtSubTGraph__Group__0_in_ruleExtSubTGraph1534 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleChoosenExtSubTGraph_in_entryRuleChoosenExtSubTGraph1561 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleChoosenExtSubTGraph1568 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ChoosenExtSubTGraph__IdAssignment_in_ruleChoosenExtSubTGraph1594 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGraph_in_entryRuleGraph1621 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleGraph1628 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Graph__Group__0_in_ruleGraph1654 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleElement_in_entryRuleElement1681 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleElement1688 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Element__Alternatives_in_ruleElement1714 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArrows_in_entryRuleArrows1741 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleArrows1748 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrows__Alternatives_in_ruleArrows1774 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArrow_in_entryRuleArrow1801 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleArrow1808 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrow__Alternatives_in_ruleArrow1834 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNode_in_entryRuleNode1861 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNode1868 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Node__Group__0_in_ruleNode1894 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAttributeValue_in_entryRuleAttributeValue1921 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAttributeValue1928 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AttributeValue__Group__0_in_ruleAttributeValue1954 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDpfId_in_entryRuleDpfId1981 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDpfId1988 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DpfId__Group__0_in_ruleDpfId2014 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DataType__Alternatives_in_ruleDataType2051 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSpecification_in_rule__Model__Alternatives2086 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSignature_in_rule__Model__Alternatives2103 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__Group_2__0_in_rule__Model__Alternatives2120 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NUMBER_in_rule__VALUE__Alternatives2154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_CHAR_in_rule__VALUE__Alternatives2171 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__VALUE__Alternatives2188 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMakeEmf_in_rule__Command__Alternatives2220 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMakeEcore_in_rule__Command__Alternatives2237 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMakeImage_in_rule__Command__Alternatives2254 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExtSubTGraph_in_rule__Command__Alternatives2271 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSimpleEvoSpan_in_rule__Command__Alternatives2288 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSimpleEvoCospan_in_rule__Command__Alternatives2305 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMorphism_in_rule__Command__Alternatives2322 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEvoSpan_in_rule__Command__Alternatives2339 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEvoCospan_in_rule__Command__Alternatives2356 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Specification__TypeAssignment_2_0_in_rule__Specification__Alternatives_22388 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Specification__Group_2_1__0_in_rule__Specification__Alternatives_22406 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMappingNode_in_rule__Mapping__Alternatives2439 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMappingArrow_in_rule__Mapping__Alternatives2456 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNode_in_rule__Element__Alternatives2488 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArrows_in_rule__Element__Alternatives2505 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrows__Group_0__0_in_rule__Arrows__Alternatives2537 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArrow_in_rule__Arrows__Alternatives2555 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrow__Group_0__0_in_rule__Arrow__Alternatives2587 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrow__Group_1__0_in_rule__Arrow__Alternatives2605 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrow__Group_2__0_in_rule__Arrow__Alternatives2623 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__DataType__Alternatives2657 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__DataType__Alternatives2678 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__DataType__Alternatives2699 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__DataType__Alternatives2720 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__DataType__Alternatives2741 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__DataType__Alternatives2762 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__DataType__Alternatives2783 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__DataType__Alternatives2804 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__DataType__Alternatives2825 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__Group_2__0__Impl_in_rule__Model__Group_2__02858 = new BitSet(new long[]{0x0000000047400080L});
    public static final BitSet FOLLOW_rule__Model__Group_2__1_in_rule__Model__Group_2__02861 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__CommandsAssignment_2_0_in_rule__Model__Group_2__0__Impl2888 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__Group_2__1__Impl_in_rule__Model__Group_2__12918 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__CommandsAssignment_2_1_in_rule__Model__Group_2__1__Impl2945 = new BitSet(new long[]{0x0000000047400082L});
    public static final BitSet FOLLOW_rule__MakeEmf__Group__0__Impl_in_rule__MakeEmf__Group__02980 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__MakeEmf__Group__1_in_rule__MakeEmf__Group__02983 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rule__MakeEmf__Group__0__Impl3011 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MakeEmf__Group__1__Impl_in_rule__MakeEmf__Group__13042 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_rule__MakeEmf__Group__2_in_rule__MakeEmf__Group__13045 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MakeEmf__IdAssignment_1_in_rule__MakeEmf__Group__1__Impl3072 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MakeEmf__Group__2__Impl_in_rule__MakeEmf__Group__23102 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__MakeEmf__Group__2__Impl3130 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MakeEcore__Group__0__Impl_in_rule__MakeEcore__Group__03167 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__MakeEcore__Group__1_in_rule__MakeEcore__Group__03170 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__MakeEcore__Group__0__Impl3198 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MakeEcore__Group__1__Impl_in_rule__MakeEcore__Group__13229 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_rule__MakeEcore__Group__2_in_rule__MakeEcore__Group__13232 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MakeEcore__IdAssignment_1_in_rule__MakeEcore__Group__1__Impl3259 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MakeEcore__Group__2__Impl_in_rule__MakeEcore__Group__23289 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__MakeEcore__Group__2__Impl3317 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MakeImage__Group__0__Impl_in_rule__MakeImage__Group__03354 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__MakeImage__Group__1_in_rule__MakeImage__Group__03357 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_rule__MakeImage__Group__0__Impl3385 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MakeImage__Group__1__Impl_in_rule__MakeImage__Group__13416 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_rule__MakeImage__Group__2_in_rule__MakeImage__Group__13419 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MakeImage__IdAssignment_1_in_rule__MakeImage__Group__1__Impl3446 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MakeImage__Group__2__Impl_in_rule__MakeImage__Group__23476 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__MakeImage__Group__2__Impl3504 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleEvoSpan__Group__0__Impl_in_rule__SimpleEvoSpan__Group__03541 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__SimpleEvoSpan__Group__1_in_rule__SimpleEvoSpan__Group__03544 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__SimpleEvoSpan__Group__0__Impl3572 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleEvoSpan__Group__1__Impl_in_rule__SimpleEvoSpan__Group__13603 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_rule__SimpleEvoSpan__Group__2_in_rule__SimpleEvoSpan__Group__13606 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleEvoSpan__LhsAssignment_1_in_rule__SimpleEvoSpan__Group__1__Impl3633 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleEvoSpan__Group__2__Impl_in_rule__SimpleEvoSpan__Group__23663 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__SimpleEvoSpan__Group__3_in_rule__SimpleEvoSpan__Group__23666 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_rule__SimpleEvoSpan__Group__2__Impl3694 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleEvoSpan__Group__3__Impl_in_rule__SimpleEvoSpan__Group__33725 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_rule__SimpleEvoSpan__Group__4_in_rule__SimpleEvoSpan__Group__33728 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleEvoSpan__DiffAssignment_3_in_rule__SimpleEvoSpan__Group__3__Impl3755 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleEvoSpan__Group__4__Impl_in_rule__SimpleEvoSpan__Group__43785 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__SimpleEvoSpan__Group__5_in_rule__SimpleEvoSpan__Group__43788 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__SimpleEvoSpan__Group__4__Impl3816 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleEvoSpan__Group__5__Impl_in_rule__SimpleEvoSpan__Group__53847 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_rule__SimpleEvoSpan__Group__6_in_rule__SimpleEvoSpan__Group__53850 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleEvoSpan__RhSAssignment_5_in_rule__SimpleEvoSpan__Group__5__Impl3877 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleEvoSpan__Group__6__Impl_in_rule__SimpleEvoSpan__Group__63907 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__SimpleEvoSpan__Group__7_in_rule__SimpleEvoSpan__Group__63910 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__SimpleEvoSpan__Group__6__Impl3938 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleEvoSpan__Group__7__Impl_in_rule__SimpleEvoSpan__Group__73969 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_rule__SimpleEvoSpan__Group__8_in_rule__SimpleEvoSpan__Group__73972 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleEvoSpan__TypeGraphAssignment_7_in_rule__SimpleEvoSpan__Group__7__Impl3999 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleEvoSpan__Group__8__Impl_in_rule__SimpleEvoSpan__Group__84029 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__SimpleEvoSpan__Group__8__Impl4057 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleEvoCospan__Group__0__Impl_in_rule__SimpleEvoCospan__Group__04106 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__SimpleEvoCospan__Group__1_in_rule__SimpleEvoCospan__Group__04109 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__SimpleEvoCospan__Group__0__Impl4137 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleEvoCospan__Group__1__Impl_in_rule__SimpleEvoCospan__Group__14168 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_rule__SimpleEvoCospan__Group__2_in_rule__SimpleEvoCospan__Group__14171 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleEvoCospan__LhsAssignment_1_in_rule__SimpleEvoCospan__Group__1__Impl4198 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleEvoCospan__Group__2__Impl_in_rule__SimpleEvoCospan__Group__24228 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__SimpleEvoCospan__Group__3_in_rule__SimpleEvoCospan__Group__24231 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__SimpleEvoCospan__Group__2__Impl4259 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleEvoCospan__Group__3__Impl_in_rule__SimpleEvoCospan__Group__34290 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_rule__SimpleEvoCospan__Group__4_in_rule__SimpleEvoCospan__Group__34293 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleEvoCospan__JointAssignment_3_in_rule__SimpleEvoCospan__Group__3__Impl4320 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleEvoCospan__Group__4__Impl_in_rule__SimpleEvoCospan__Group__44350 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__SimpleEvoCospan__Group__5_in_rule__SimpleEvoCospan__Group__44353 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_rule__SimpleEvoCospan__Group__4__Impl4381 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleEvoCospan__Group__5__Impl_in_rule__SimpleEvoCospan__Group__54412 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_rule__SimpleEvoCospan__Group__6_in_rule__SimpleEvoCospan__Group__54415 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleEvoCospan__RhsAssignment_5_in_rule__SimpleEvoCospan__Group__5__Impl4442 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleEvoCospan__Group__6__Impl_in_rule__SimpleEvoCospan__Group__64472 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__SimpleEvoCospan__Group__7_in_rule__SimpleEvoCospan__Group__64475 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__SimpleEvoCospan__Group__6__Impl4503 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleEvoCospan__Group__7__Impl_in_rule__SimpleEvoCospan__Group__74534 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_rule__SimpleEvoCospan__Group__8_in_rule__SimpleEvoCospan__Group__74537 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleEvoCospan__TypeGraphAssignment_7_in_rule__SimpleEvoCospan__Group__7__Impl4564 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleEvoCospan__Group__8__Impl_in_rule__SimpleEvoCospan__Group__84594 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__SimpleEvoCospan__Group__8__Impl4622 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EvoSpan__Group__0__Impl_in_rule__EvoSpan__Group__04671 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__EvoSpan__Group__1_in_rule__EvoSpan__Group__04674 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_rule__EvoSpan__Group__0__Impl4702 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EvoSpan__Group__1__Impl_in_rule__EvoSpan__Group__14733 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_rule__EvoSpan__Group__2_in_rule__EvoSpan__Group__14736 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EvoSpan__LhsAssignment_1_in_rule__EvoSpan__Group__1__Impl4763 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EvoSpan__Group__2__Impl_in_rule__EvoSpan__Group__24793 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__EvoSpan__Group__3_in_rule__EvoSpan__Group__24796 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_rule__EvoSpan__Group__2__Impl4824 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EvoSpan__Group__3__Impl_in_rule__EvoSpan__Group__34855 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_rule__EvoSpan__Group__4_in_rule__EvoSpan__Group__34858 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EvoSpan__RhsAssignment_3_in_rule__EvoSpan__Group__3__Impl4885 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EvoSpan__Group__4__Impl_in_rule__EvoSpan__Group__44915 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__EvoSpan__Group__5_in_rule__EvoSpan__Group__44918 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__EvoSpan__Group__4__Impl4946 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EvoSpan__Group__5__Impl_in_rule__EvoSpan__Group__54977 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_rule__EvoSpan__Group__6_in_rule__EvoSpan__Group__54980 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EvoSpan__TypeGraphAssignment_5_in_rule__EvoSpan__Group__5__Impl5007 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EvoSpan__Group__6__Impl_in_rule__EvoSpan__Group__65037 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__EvoSpan__Group__6__Impl5065 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EvoCospan__Group__0__Impl_in_rule__EvoCospan__Group__05110 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__EvoCospan__Group__1_in_rule__EvoCospan__Group__05113 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_rule__EvoCospan__Group__0__Impl5141 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EvoCospan__Group__1__Impl_in_rule__EvoCospan__Group__15172 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_rule__EvoCospan__Group__2_in_rule__EvoCospan__Group__15175 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EvoCospan__LhsAssignment_1_in_rule__EvoCospan__Group__1__Impl5202 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EvoCospan__Group__2__Impl_in_rule__EvoCospan__Group__25232 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__EvoCospan__Group__3_in_rule__EvoCospan__Group__25235 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_rule__EvoCospan__Group__2__Impl5263 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EvoCospan__Group__3__Impl_in_rule__EvoCospan__Group__35294 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_rule__EvoCospan__Group__4_in_rule__EvoCospan__Group__35297 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EvoCospan__RhsAssignment_3_in_rule__EvoCospan__Group__3__Impl5324 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EvoCospan__Group__4__Impl_in_rule__EvoCospan__Group__45354 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__EvoCospan__Group__5_in_rule__EvoCospan__Group__45357 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__EvoCospan__Group__4__Impl5385 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EvoCospan__Group__5__Impl_in_rule__EvoCospan__Group__55416 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_rule__EvoCospan__Group__6_in_rule__EvoCospan__Group__55419 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EvoCospan__TypeGraphAssignment_5_in_rule__EvoCospan__Group__5__Impl5446 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EvoCospan__Group__6__Impl_in_rule__EvoCospan__Group__65476 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__EvoCospan__Group__6__Impl5504 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Specification__Group__0__Impl_in_rule__Specification__Group__05549 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_rule__Specification__Group__1_in_rule__Specification__Group__05552 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_rule__Specification__Group__0__Impl5580 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Specification__Group__1__Impl_in_rule__Specification__Group__15611 = new BitSet(new long[]{0x0000008000000080L});
    public static final BitSet FOLLOW_rule__Specification__Group__2_in_rule__Specification__Group__15614 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_rule__Specification__Group__1__Impl5642 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Specification__Group__2__Impl_in_rule__Specification__Group__25673 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_rule__Specification__Group__3_in_rule__Specification__Group__25676 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Specification__Alternatives_2_in_rule__Specification__Group__2__Impl5703 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Specification__Group__3__Impl_in_rule__Specification__Group__35733 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_rule__Specification__Group__4_in_rule__Specification__Group__35736 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_rule__Specification__Group__3__Impl5764 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Specification__Group__4__Impl_in_rule__Specification__Group__45795 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_rule__Specification__Group__5_in_rule__Specification__Group__45798 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Specification__SequenceNumberAssignment_4_in_rule__Specification__Group__4__Impl5825 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Specification__Group__5__Impl_in_rule__Specification__Group__55855 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_rule__Specification__Group__6_in_rule__Specification__Group__55858 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_rule__Specification__Group__5__Impl5886 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Specification__Group__6__Impl_in_rule__Specification__Group__65917 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_rule__Specification__Group__7_in_rule__Specification__Group__65920 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_rule__Specification__Group__6__Impl5948 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Specification__Group__7__Impl_in_rule__Specification__Group__75979 = new BitSet(new long[]{0x0000014000000000L});
    public static final BitSet FOLLOW_rule__Specification__Group__8_in_rule__Specification__Group__75982 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Specification__GraphAssignment_7_in_rule__Specification__Group__7__Impl6009 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Specification__Group__8__Impl_in_rule__Specification__Group__86039 = new BitSet(new long[]{0x0000014000000000L});
    public static final BitSet FOLLOW_rule__Specification__Group__9_in_rule__Specification__Group__86042 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Specification__Group_8__0_in_rule__Specification__Group__8__Impl6069 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Specification__Group__9__Impl_in_rule__Specification__Group__96100 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_rule__Specification__Group__9__Impl6128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Specification__Group_2_1__0__Impl_in_rule__Specification__Group_2_1__06179 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__Specification__Group_2_1__1_in_rule__Specification__Group_2_1__06182 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_rule__Specification__Group_2_1__0__Impl6210 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Specification__Group_2_1__1__Impl_in_rule__Specification__Group_2_1__16241 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_rule__Specification__Group_2_1__2_in_rule__Specification__Group_2_1__16244 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Specification__TypeAssignment_2_1_1_in_rule__Specification__Group_2_1__1__Impl6271 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Specification__Group_2_1__2__Impl_in_rule__Specification__Group_2_1__26301 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__Specification__Group_2_1__3_in_rule__Specification__Group_2_1__26304 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__Specification__Group_2_1__2__Impl6332 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Specification__Group_2_1__3__Impl_in_rule__Specification__Group_2_1__36363 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_rule__Specification__Group_2_1__4_in_rule__Specification__Group_2_1__36366 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Specification__ConstraintSemanticAssignment_2_1_3_in_rule__Specification__Group_2_1__3__Impl6393 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Specification__Group_2_1__4__Impl_in_rule__Specification__Group_2_1__46423 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__Specification__Group_2_1__4__Impl6451 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Specification__Group_8__0__Impl_in_rule__Specification__Group_8__06492 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_rule__Specification__Group_8__1_in_rule__Specification__Group_8__06495 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_rule__Specification__Group_8__0__Impl6523 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Specification__Group_8__1__Impl_in_rule__Specification__Group_8__16554 = new BitSet(new long[]{0x0000004000000080L});
    public static final BitSet FOLLOW_rule__Specification__Group_8__2_in_rule__Specification__Group_8__16557 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_rule__Specification__Group_8__1__Impl6585 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Specification__Group_8__2__Impl_in_rule__Specification__Group_8__26616 = new BitSet(new long[]{0x0000004000000080L});
    public static final BitSet FOLLOW_rule__Specification__Group_8__3_in_rule__Specification__Group_8__26619 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Specification__Group_8_2__0_in_rule__Specification__Group_8__2__Impl6646 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Specification__Group_8__3__Impl_in_rule__Specification__Group_8__36677 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_rule__Specification__Group_8__3__Impl6705 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Specification__Group_8_2__0__Impl_in_rule__Specification__Group_8_2__06744 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_rule__Specification__Group_8_2__1_in_rule__Specification__Group_8_2__06747 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Specification__ConstraintsAssignment_8_2_0_in_rule__Specification__Group_8_2__0__Impl6774 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Specification__Group_8_2__1__Impl_in_rule__Specification__Group_8_2__16804 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Specification__Group_8_2_1__0_in_rule__Specification__Group_8_2__1__Impl6831 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_rule__Specification__Group_8_2_1__0__Impl_in_rule__Specification__Group_8_2_1__06866 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__Specification__Group_8_2_1__1_in_rule__Specification__Group_8_2_1__06869 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__Specification__Group_8_2_1__0__Impl6897 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Specification__Group_8_2_1__1__Impl_in_rule__Specification__Group_8_2_1__16928 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Specification__ConstraintsAssignment_8_2_1_1_in_rule__Specification__Group_8_2_1__1__Impl6955 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Constraint__Group__0__Impl_in_rule__Constraint__Group__06989 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_rule__Constraint__Group__1_in_rule__Constraint__Group__06992 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Constraint__SignatureAssignment_0_in_rule__Constraint__Group__0__Impl7019 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Constraint__Group__1__Impl_in_rule__Constraint__Group__17049 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__Constraint__Group__2_in_rule__Constraint__Group__17052 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_rule__Constraint__Group__1__Impl7080 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Constraint__Group__2__Impl_in_rule__Constraint__Group__27111 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_rule__Constraint__Group__3_in_rule__Constraint__Group__27114 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Constraint__Group_2__0_in_rule__Constraint__Group__2__Impl7141 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Constraint__Group__3__Impl_in_rule__Constraint__Group__37171 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_rule__Constraint__Group__3__Impl7199 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Constraint__Group_2__0__Impl_in_rule__Constraint__Group_2__07238 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_rule__Constraint__Group_2__1_in_rule__Constraint__Group_2__07241 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Constraint__ArrowsAssignment_2_0_in_rule__Constraint__Group_2__0__Impl7268 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Constraint__Group_2__1__Impl_in_rule__Constraint__Group_2__17298 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Constraint__Group_2_1__0_in_rule__Constraint__Group_2__1__Impl7325 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_rule__Constraint__Group_2_1__0__Impl_in_rule__Constraint__Group_2_1__07360 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__Constraint__Group_2_1__1_in_rule__Constraint__Group_2_1__07363 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__Constraint__Group_2_1__0__Impl7391 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Constraint__Group_2_1__1__Impl_in_rule__Constraint__Group_2_1__17422 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Constraint__ArrowsAssignment_2_1_1_in_rule__Constraint__Group_2_1__1__Impl7449 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConstraintSignature__Group__0__Impl_in_rule__ConstraintSignature__Group__07483 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_rule__ConstraintSignature__Group__1_in_rule__ConstraintSignature__Group__07486 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConstraintSignature__IdAssignment_0_in_rule__ConstraintSignature__Group__0__Impl7513 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConstraintSignature__Group__1__Impl_in_rule__ConstraintSignature__Group__17543 = new BitSet(new long[]{0x0000000000800040L});
    public static final BitSet FOLLOW_rule__ConstraintSignature__Group__2_in_rule__ConstraintSignature__Group__17546 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_rule__ConstraintSignature__Group__1__Impl7574 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConstraintSignature__Group__2__Impl_in_rule__ConstraintSignature__Group__27605 = new BitSet(new long[]{0x0000000000800040L});
    public static final BitSet FOLLOW_rule__ConstraintSignature__Group__3_in_rule__ConstraintSignature__Group__27608 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConstraintSignature__Group_2__0_in_rule__ConstraintSignature__Group__2__Impl7635 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConstraintSignature__Group__3__Impl_in_rule__ConstraintSignature__Group__37666 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__ConstraintSignature__Group__3__Impl7694 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConstraintSignature__Group_2__0__Impl_in_rule__ConstraintSignature__Group_2__07733 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_rule__ConstraintSignature__Group_2__1_in_rule__ConstraintSignature__Group_2__07736 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConstraintSignature__ParameterAssignment_2_0_in_rule__ConstraintSignature__Group_2__0__Impl7763 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConstraintSignature__Group_2__1__Impl_in_rule__ConstraintSignature__Group_2__17793 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConstraintSignature__Group_2_1__0_in_rule__ConstraintSignature__Group_2__1__Impl7820 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_rule__ConstraintSignature__Group_2_1__0__Impl_in_rule__ConstraintSignature__Group_2_1__07855 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__ConstraintSignature__Group_2_1__1_in_rule__ConstraintSignature__Group_2_1__07858 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__ConstraintSignature__Group_2_1__0__Impl7886 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConstraintSignature__Group_2_1__1__Impl_in_rule__ConstraintSignature__Group_2_1__17917 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConstraintSignature__ParameterAssignment_2_1_1_in_rule__ConstraintSignature__Group_2_1__1__Impl7944 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Signature__Group__0__Impl_in_rule__Signature__Group__07978 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_rule__Signature__Group__1_in_rule__Signature__Group__07981 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Signature__ConstraintSemanticsAssignment_0_in_rule__Signature__Group__0__Impl8008 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Signature__Group__1__Impl_in_rule__Signature__Group__18038 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Signature__Group_1__0_in_rule__Signature__Group__1__Impl8065 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_rule__Signature__Group_1__0__Impl_in_rule__Signature__Group_1__08100 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__Signature__Group_1__1_in_rule__Signature__Group_1__08103 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__Signature__Group_1__0__Impl8131 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Signature__Group_1__1__Impl_in_rule__Signature__Group_1__18162 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Signature__ConstraintSemanticsAssignment_1_1_in_rule__Signature__Group_1__1__Impl8189 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConstraintSemantic__Group__0__Impl_in_rule__ConstraintSemantic__Group__08223 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_rule__ConstraintSemantic__Group__1_in_rule__ConstraintSemantic__Group__08226 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConstraintSemantic__IdAssignment_0_in_rule__ConstraintSemantic__Group__0__Impl8253 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConstraintSemantic__Group__1__Impl_in_rule__ConstraintSemantic__Group__18283 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__ConstraintSemantic__Group__2_in_rule__ConstraintSemantic__Group__18286 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_rule__ConstraintSemantic__Group__1__Impl8314 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConstraintSemantic__Group__2__Impl_in_rule__ConstraintSemantic__Group__28345 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_rule__ConstraintSemantic__Group__3_in_rule__ConstraintSemantic__Group__28348 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConstraintSemantic__Group_2__0_in_rule__ConstraintSemantic__Group__2__Impl8375 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConstraintSemantic__Group__3__Impl_in_rule__ConstraintSemantic__Group__38405 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_rule__ConstraintSemantic__Group__4_in_rule__ConstraintSemantic__Group__38408 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_rule__ConstraintSemantic__Group__3__Impl8436 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConstraintSemantic__Group__4__Impl_in_rule__ConstraintSemantic__Group__48467 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__ConstraintSemantic__Group__5_in_rule__ConstraintSemantic__Group__48470 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_rule__ConstraintSemantic__Group__4__Impl8498 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConstraintSemantic__Group__5__Impl_in_rule__ConstraintSemantic__Group__58529 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConstraintSemantic__OclAssignment_5_in_rule__ConstraintSemantic__Group__5__Impl8556 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConstraintSemantic__Group_2__0__Impl_in_rule__ConstraintSemantic__Group_2__08598 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_rule__ConstraintSemantic__Group_2__1_in_rule__ConstraintSemantic__Group_2__08601 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConstraintSemantic__ArrowsAssignment_2_0_in_rule__ConstraintSemantic__Group_2__0__Impl8628 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConstraintSemantic__Group_2__1__Impl_in_rule__ConstraintSemantic__Group_2__18658 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConstraintSemantic__Group_2_1__0_in_rule__ConstraintSemantic__Group_2__1__Impl8685 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_rule__ConstraintSemantic__Group_2_1__0__Impl_in_rule__ConstraintSemantic__Group_2_1__08720 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__ConstraintSemantic__Group_2_1__1_in_rule__ConstraintSemantic__Group_2_1__08723 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__ConstraintSemantic__Group_2_1__0__Impl8751 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConstraintSemantic__Group_2_1__1__Impl_in_rule__ConstraintSemantic__Group_2_1__18782 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConstraintSemantic__ArrowsAssignment_2_1_1_in_rule__ConstraintSemantic__Group_2_1__1__Impl8809 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Morphism__Group__0__Impl_in_rule__Morphism__Group__08843 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_rule__Morphism__Group__1_in_rule__Morphism__Group__08846 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Morphism__Group__0__Impl8873 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Morphism__Group__1__Impl_in_rule__Morphism__Group__18902 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_rule__Morphism__Group__2_in_rule__Morphism__Group__18905 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_rule__Morphism__Group__1__Impl8933 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Morphism__Group__2__Impl_in_rule__Morphism__Group__28964 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_rule__Morphism__Group__3_in_rule__Morphism__Group__28967 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_rule__Morphism__Group__2__Impl8995 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Morphism__Group__3__Impl_in_rule__Morphism__Group__39026 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__Morphism__Group__4_in_rule__Morphism__Group__39029 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_rule__Morphism__Group__3__Impl9057 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Morphism__Group__4__Impl_in_rule__Morphism__Group__49088 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_rule__Morphism__Group__5_in_rule__Morphism__Group__49091 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Morphism__DomainAssignment_4_in_rule__Morphism__Group__4__Impl9118 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Morphism__Group__5__Impl_in_rule__Morphism__Group__59148 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__Morphism__Group__6_in_rule__Morphism__Group__59151 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__Morphism__Group__5__Impl9179 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Morphism__Group__6__Impl_in_rule__Morphism__Group__69210 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_rule__Morphism__Group__7_in_rule__Morphism__Group__69213 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Morphism__CodmainAssignment_6_in_rule__Morphism__Group__6__Impl9240 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Morphism__Group__7__Impl_in_rule__Morphism__Group__79270 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_rule__Morphism__Group__8_in_rule__Morphism__Group__79273 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_rule__Morphism__Group__7__Impl9301 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Morphism__Group__8__Impl_in_rule__Morphism__Group__89332 = new BitSet(new long[]{0x0000004000000080L});
    public static final BitSet FOLLOW_rule__Morphism__Group__9_in_rule__Morphism__Group__89335 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_rule__Morphism__Group__8__Impl9363 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Morphism__Group__9__Impl_in_rule__Morphism__Group__99394 = new BitSet(new long[]{0x0000004000000080L});
    public static final BitSet FOLLOW_rule__Morphism__Group__10_in_rule__Morphism__Group__99397 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Morphism__Group_9__0_in_rule__Morphism__Group__9__Impl9424 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Morphism__Group__10__Impl_in_rule__Morphism__Group__109455 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_rule__Morphism__Group__10__Impl9483 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Morphism__Group_9__0__Impl_in_rule__Morphism__Group_9__09536 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_rule__Morphism__Group_9__1_in_rule__Morphism__Group_9__09539 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Morphism__MappingsAssignment_9_0_in_rule__Morphism__Group_9__0__Impl9566 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Morphism__Group_9__1__Impl_in_rule__Morphism__Group_9__19596 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Morphism__Group_9_1__0_in_rule__Morphism__Group_9__1__Impl9623 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_rule__Morphism__Group_9_1__0__Impl_in_rule__Morphism__Group_9_1__09658 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__Morphism__Group_9_1__1_in_rule__Morphism__Group_9_1__09661 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__Morphism__Group_9_1__0__Impl9689 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Morphism__Group_9_1__1__Impl_in_rule__Morphism__Group_9_1__19720 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Morphism__MappingsAssignment_9_1_1_in_rule__Morphism__Group_9_1__1__Impl9747 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MappingNode__Group__0__Impl_in_rule__MappingNode__Group__09781 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_rule__MappingNode__Group__1_in_rule__MappingNode__Group__09784 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MappingNode__DomainAssignment_0_in_rule__MappingNode__Group__0__Impl9811 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MappingNode__Group__1__Impl_in_rule__MappingNode__Group__19841 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__MappingNode__Group__2_in_rule__MappingNode__Group__19844 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_rule__MappingNode__Group__1__Impl9872 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MappingNode__Group__2__Impl_in_rule__MappingNode__Group__29903 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MappingNode__CodomainAssignment_2_in_rule__MappingNode__Group__2__Impl9930 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MappingArrow__Group__0__Impl_in_rule__MappingArrow__Group__09966 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_rule__MappingArrow__Group__1_in_rule__MappingArrow__Group__09969 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MappingArrow__DomainAssignment_0_in_rule__MappingArrow__Group__0__Impl9996 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MappingArrow__Group__1__Impl_in_rule__MappingArrow__Group__110026 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__MappingArrow__Group__2_in_rule__MappingArrow__Group__110029 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_rule__MappingArrow__Group__1__Impl10057 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MappingArrow__Group__2__Impl_in_rule__MappingArrow__Group__210088 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MappingArrow__CodmainAssignment_2_in_rule__MappingArrow__Group__2__Impl10115 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExtSubTGraph__Group__0__Impl_in_rule__ExtSubTGraph__Group__010151 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_rule__ExtSubTGraph__Group__1_in_rule__ExtSubTGraph__Group__010154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExtSubTGraph__IdAssignment_0_in_rule__ExtSubTGraph__Group__0__Impl10181 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExtSubTGraph__Group__1__Impl_in_rule__ExtSubTGraph__Group__110211 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_rule__ExtSubTGraph__Group__2_in_rule__ExtSubTGraph__Group__110214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_rule__ExtSubTGraph__Group__1__Impl10242 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExtSubTGraph__Group__2__Impl_in_rule__ExtSubTGraph__Group__210273 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_rule__ExtSubTGraph__Group__3_in_rule__ExtSubTGraph__Group__210276 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_rule__ExtSubTGraph__Group__2__Impl10304 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExtSubTGraph__Group__3__Impl_in_rule__ExtSubTGraph__Group__310335 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__ExtSubTGraph__Group__4_in_rule__ExtSubTGraph__Group__310338 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_rule__ExtSubTGraph__Group__3__Impl10366 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExtSubTGraph__Group__4__Impl_in_rule__ExtSubTGraph__Group__410397 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_rule__ExtSubTGraph__Group__5_in_rule__ExtSubTGraph__Group__410400 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExtSubTGraph__ExtendsGraphAssignment_4_in_rule__ExtSubTGraph__Group__4__Impl10427 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExtSubTGraph__Group__5__Impl_in_rule__ExtSubTGraph__Group__510457 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_rule__ExtSubTGraph__Group__6_in_rule__ExtSubTGraph__Group__510460 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_rule__ExtSubTGraph__Group__5__Impl10488 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExtSubTGraph__Group__6__Impl_in_rule__ExtSubTGraph__Group__610519 = new BitSet(new long[]{0x0000004000000080L});
    public static final BitSet FOLLOW_rule__ExtSubTGraph__Group__7_in_rule__ExtSubTGraph__Group__610522 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_rule__ExtSubTGraph__Group__6__Impl10550 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExtSubTGraph__Group__7__Impl_in_rule__ExtSubTGraph__Group__710581 = new BitSet(new long[]{0x0000004000000080L});
    public static final BitSet FOLLOW_rule__ExtSubTGraph__Group__8_in_rule__ExtSubTGraph__Group__710584 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExtSubTGraph__Group_7__0_in_rule__ExtSubTGraph__Group__7__Impl10611 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExtSubTGraph__Group__8__Impl_in_rule__ExtSubTGraph__Group__810642 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_rule__ExtSubTGraph__Group__8__Impl10670 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExtSubTGraph__Group_7__0__Impl_in_rule__ExtSubTGraph__Group_7__010719 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_rule__ExtSubTGraph__Group_7__1_in_rule__ExtSubTGraph__Group_7__010722 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExtSubTGraph__ElementsAssignment_7_0_in_rule__ExtSubTGraph__Group_7__0__Impl10749 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExtSubTGraph__Group_7__1__Impl_in_rule__ExtSubTGraph__Group_7__110779 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExtSubTGraph__Group_7_1__0_in_rule__ExtSubTGraph__Group_7__1__Impl10806 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_rule__ExtSubTGraph__Group_7_1__0__Impl_in_rule__ExtSubTGraph__Group_7_1__010841 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__ExtSubTGraph__Group_7_1__1_in_rule__ExtSubTGraph__Group_7_1__010844 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__ExtSubTGraph__Group_7_1__0__Impl10872 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExtSubTGraph__Group_7_1__1__Impl_in_rule__ExtSubTGraph__Group_7_1__110903 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExtSubTGraph__ElementsAssignment_7_1_1_in_rule__ExtSubTGraph__Group_7_1__1__Impl10930 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Graph__Group__0__Impl_in_rule__Graph__Group__010964 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_rule__Graph__Group__1_in_rule__Graph__Group__010967 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_rule__Graph__Group__0__Impl10995 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Graph__Group__1__Impl_in_rule__Graph__Group__111026 = new BitSet(new long[]{0x0000004000000080L});
    public static final BitSet FOLLOW_rule__Graph__Group__2_in_rule__Graph__Group__111029 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_rule__Graph__Group__1__Impl11057 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Graph__Group__2__Impl_in_rule__Graph__Group__211088 = new BitSet(new long[]{0x0000004000000080L});
    public static final BitSet FOLLOW_rule__Graph__Group__3_in_rule__Graph__Group__211091 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Graph__Group_2__0_in_rule__Graph__Group__2__Impl11118 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Graph__Group__3__Impl_in_rule__Graph__Group__311149 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_rule__Graph__Group__3__Impl11177 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Graph__Group_2__0__Impl_in_rule__Graph__Group_2__011216 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_rule__Graph__Group_2__1_in_rule__Graph__Group_2__011219 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Graph__ElementsAssignment_2_0_in_rule__Graph__Group_2__0__Impl11246 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Graph__Group_2__1__Impl_in_rule__Graph__Group_2__111276 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Graph__Group_2_1__0_in_rule__Graph__Group_2__1__Impl11303 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_rule__Graph__Group_2_1__0__Impl_in_rule__Graph__Group_2_1__011338 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__Graph__Group_2_1__1_in_rule__Graph__Group_2_1__011341 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__Graph__Group_2_1__0__Impl11369 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Graph__Group_2_1__1__Impl_in_rule__Graph__Group_2_1__111400 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Graph__ElementsAssignment_2_1_1_in_rule__Graph__Group_2_1__1__Impl11427 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrows__Group_0__0__Impl_in_rule__Arrows__Group_0__011461 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_rule__Arrows__Group_0__1_in_rule__Arrows__Group_0__011464 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrows__SrAssignment_0_0_in_rule__Arrows__Group_0__0__Impl11491 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrows__Group_0__1__Impl_in_rule__Arrows__Group_0__111521 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__Arrows__Group_0__2_in_rule__Arrows__Group_0__111524 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_rule__Arrows__Group_0__1__Impl11552 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrows__Group_0__2__Impl_in_rule__Arrows__Group_0__211583 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_rule__Arrows__Group_0__3_in_rule__Arrows__Group_0__211586 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrows__IdAssignment_0_2_in_rule__Arrows__Group_0__2__Impl11613 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrows__Group_0__3__Impl_in_rule__Arrows__Group_0__311643 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__Arrows__Group_0__4_in_rule__Arrows__Group_0__311646 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_rule__Arrows__Group_0__3__Impl11674 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrows__Group_0__4__Impl_in_rule__Arrows__Group_0__411705 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_rule__Arrows__Group_0__5_in_rule__Arrows__Group_0__411708 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrows__TypeAssignment_0_4_in_rule__Arrows__Group_0__4__Impl11735 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrows__Group_0__5__Impl_in_rule__Arrows__Group_0__511765 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__Arrows__Group_0__6_in_rule__Arrows__Group_0__511768 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__Arrows__Group_0__5__Impl11796 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrows__Group_0__6__Impl_in_rule__Arrows__Group_0__611827 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrows__NextAssignment_0_6_in_rule__Arrows__Group_0__6__Impl11854 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrow__Group_0__0__Impl_in_rule__Arrow__Group_0__011898 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_rule__Arrow__Group_0__1_in_rule__Arrow__Group_0__011901 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrow__SrAssignment_0_0_in_rule__Arrow__Group_0__0__Impl11928 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrow__Group_0__1__Impl_in_rule__Arrow__Group_0__111958 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__Arrow__Group_0__2_in_rule__Arrow__Group_0__111961 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_rule__Arrow__Group_0__1__Impl11989 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrow__Group_0__2__Impl_in_rule__Arrow__Group_0__212020 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_rule__Arrow__Group_0__3_in_rule__Arrow__Group_0__212023 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrow__IdAssignment_0_2_in_rule__Arrow__Group_0__2__Impl12050 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrow__Group_0__3__Impl_in_rule__Arrow__Group_0__312080 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_rule__Arrow__Group_0__4_in_rule__Arrow__Group_0__312083 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_rule__Arrow__Group_0__3__Impl12111 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrow__Group_0__4__Impl_in_rule__Arrow__Group_0__412142 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_rule__Arrow__Group_0__5_in_rule__Arrow__Group_0__412145 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_rule__Arrow__Group_0__4__Impl12173 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrow__Group_0__5__Impl_in_rule__Arrow__Group_0__512204 = new BitSet(new long[]{0x00000000003FE000L});
    public static final BitSet FOLLOW_rule__Arrow__Group_0__6_in_rule__Arrow__Group_0__512207 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__Arrow__Group_0__5__Impl12235 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrow__Group_0__6__Impl_in_rule__Arrow__Group_0__612266 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrow__TgDataTypeAssignment_0_6_in_rule__Arrow__Group_0__6__Impl12293 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrow__Group_1__0__Impl_in_rule__Arrow__Group_1__012337 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_rule__Arrow__Group_1__1_in_rule__Arrow__Group_1__012340 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrow__SrAssignment_1_0_in_rule__Arrow__Group_1__0__Impl12367 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrow__Group_1__1__Impl_in_rule__Arrow__Group_1__112397 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__Arrow__Group_1__2_in_rule__Arrow__Group_1__112400 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_rule__Arrow__Group_1__1__Impl12428 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrow__Group_1__2__Impl_in_rule__Arrow__Group_1__212459 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_rule__Arrow__Group_1__3_in_rule__Arrow__Group_1__212462 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrow__IdAssignment_1_2_in_rule__Arrow__Group_1__2__Impl12489 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrow__Group_1__3__Impl_in_rule__Arrow__Group_1__312519 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__Arrow__Group_1__4_in_rule__Arrow__Group_1__312522 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_rule__Arrow__Group_1__3__Impl12550 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrow__Group_1__4__Impl_in_rule__Arrow__Group_1__412581 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_rule__Arrow__Group_1__5_in_rule__Arrow__Group_1__412584 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrow__TypeAssignment_1_4_in_rule__Arrow__Group_1__4__Impl12611 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrow__Group_1__5__Impl_in_rule__Arrow__Group_1__512641 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_rule__Arrow__Group_1__6_in_rule__Arrow__Group_1__512644 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__Arrow__Group_1__5__Impl12672 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrow__Group_1__6__Impl_in_rule__Arrow__Group_1__612703 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrow__TgValueAssignment_1_6_in_rule__Arrow__Group_1__6__Impl12730 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrow__Group_2__0__Impl_in_rule__Arrow__Group_2__012774 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_rule__Arrow__Group_2__1_in_rule__Arrow__Group_2__012777 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrow__SrAssignment_2_0_in_rule__Arrow__Group_2__0__Impl12804 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrow__Group_2__1__Impl_in_rule__Arrow__Group_2__112834 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__Arrow__Group_2__2_in_rule__Arrow__Group_2__112837 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_rule__Arrow__Group_2__1__Impl12865 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrow__Group_2__2__Impl_in_rule__Arrow__Group_2__212896 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_rule__Arrow__Group_2__3_in_rule__Arrow__Group_2__212899 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrow__IdAssignment_2_2_in_rule__Arrow__Group_2__2__Impl12926 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrow__Group_2__3__Impl_in_rule__Arrow__Group_2__312956 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__Arrow__Group_2__4_in_rule__Arrow__Group_2__312959 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_rule__Arrow__Group_2__3__Impl12987 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrow__Group_2__4__Impl_in_rule__Arrow__Group_2__413018 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_rule__Arrow__Group_2__5_in_rule__Arrow__Group_2__413021 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrow__TypeAssignment_2_4_in_rule__Arrow__Group_2__4__Impl13048 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrow__Group_2__5__Impl_in_rule__Arrow__Group_2__513078 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__Arrow__Group_2__6_in_rule__Arrow__Group_2__513081 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__Arrow__Group_2__5__Impl13109 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrow__Group_2__6__Impl_in_rule__Arrow__Group_2__613140 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrow__TgNodeAssignment_2_6_in_rule__Arrow__Group_2__6__Impl13167 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Node__Group__0__Impl_in_rule__Node__Group__013211 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_rule__Node__Group__1_in_rule__Node__Group__013214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Node__IdAssignment_0_in_rule__Node__Group__0__Impl13241 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Node__Group__1__Impl_in_rule__Node__Group__113271 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__Node__Group__2_in_rule__Node__Group__113274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_rule__Node__Group__1__Impl13302 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Node__Group__2__Impl_in_rule__Node__Group__213333 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Node__TypeAssignment_2_in_rule__Node__Group__2__Impl13360 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AttributeValue__Group__0__Impl_in_rule__AttributeValue__Group__013396 = new BitSet(new long[]{0x0000000000000070L});
    public static final BitSet FOLLOW_rule__AttributeValue__Group__1_in_rule__AttributeValue__Group__013399 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_rule__AttributeValue__Group__0__Impl13427 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AttributeValue__Group__1__Impl_in_rule__AttributeValue__Group__113458 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_rule__AttributeValue__Group__2_in_rule__AttributeValue__Group__113461 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AttributeValue__ValueAssignment_1_in_rule__AttributeValue__Group__1__Impl13488 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AttributeValue__Group__2__Impl_in_rule__AttributeValue__Group__213518 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_rule__AttributeValue__Group__2__Impl13546 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DpfId__Group__0__Impl_in_rule__DpfId__Group__013583 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_rule__DpfId__Group__1_in_rule__DpfId__Group__013586 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DpfId__NameAssignment_0_in_rule__DpfId__Group__0__Impl13613 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DpfId__Group__1__Impl_in_rule__DpfId__Group__113643 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DpfId__Group_1__0_in_rule__DpfId__Group__1__Impl13670 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DpfId__Group_1__0__Impl_in_rule__DpfId__Group_1__013705 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_rule__DpfId__Group_1__1_in_rule__DpfId__Group_1__013708 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_rule__DpfId__Group_1__0__Impl13736 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DpfId__Group_1__1__Impl_in_rule__DpfId__Group_1__113767 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DpfId__IdAssignment_1_1_in_rule__DpfId__Group_1__1__Impl13794 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCommand_in_rule__Model__CommandsAssignment_2_013833 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCommand_in_rule__Model__CommandsAssignment_2_113864 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__MakeEmf__IdAssignment_113895 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__MakeEcore__IdAssignment_113926 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__MakeImage__IdAssignment_113957 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__SimpleEvoSpan__LhsAssignment_113988 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__SimpleEvoSpan__DiffAssignment_314019 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__SimpleEvoSpan__RhSAssignment_514050 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__SimpleEvoSpan__TypeGraphAssignment_714081 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__SimpleEvoCospan__LhsAssignment_114112 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__SimpleEvoCospan__JointAssignment_314143 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__SimpleEvoCospan__RhsAssignment_514174 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__SimpleEvoCospan__TypeGraphAssignment_714205 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__EvoSpan__LhsAssignment_114236 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__EvoSpan__RhsAssignment_314267 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__EvoSpan__TypeGraphAssignment_514298 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__EvoCospan__LhsAssignment_114329 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__EvoCospan__RhsAssignment_314360 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__EvoCospan__TypeGraphAssignment_514391 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleChoosenSpecification_in_rule__Specification__TypeAssignment_2_014422 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleChoosenSpecification_in_rule__Specification__TypeAssignment_2_1_114453 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleChoosenConstraintSemantic_in_rule__Specification__ConstraintSemanticAssignment_2_1_314484 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSequenceNumber_in_rule__Specification__SequenceNumberAssignment_414515 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGraph_in_rule__Specification__GraphAssignment_714546 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConstraint_in_rule__Specification__ConstraintsAssignment_8_2_014577 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConstraint_in_rule__Specification__ConstraintsAssignment_8_2_1_114608 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ChoosenSpecification__IdAssignment14639 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__SequenceNumber__NextNumberAssignment14670 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ChoosenConstraintSemantic__IdAssignment14701 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConstraintSignature_in_rule__Constraint__SignatureAssignment_014732 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArrows_in_rule__Constraint__ArrowsAssignment_2_014763 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArrows_in_rule__Constraint__ArrowsAssignment_2_1_114794 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDpfId_in_rule__ConstraintSignature__IdAssignment_014825 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__ConstraintSignature__ParameterAssignment_2_014856 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__ConstraintSignature__ParameterAssignment_2_1_114887 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConstraintSemantic_in_rule__Signature__ConstraintSemanticsAssignment_014918 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConstraintSemantic_in_rule__Signature__ConstraintSemanticsAssignment_1_114949 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDpfId_in_rule__ConstraintSemantic__IdAssignment_014980 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArrows_in_rule__ConstraintSemantic__ArrowsAssignment_2_015011 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArrows_in_rule__ConstraintSemantic__ArrowsAssignment_2_1_115042 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__ConstraintSemantic__OclAssignment_515073 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDomain_in_rule__Morphism__DomainAssignment_415104 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCodomain_in_rule__Morphism__CodmainAssignment_615135 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMapping_in_rule__Morphism__MappingsAssignment_9_015166 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMapping_in_rule__Morphism__MappingsAssignment_9_1_115197 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Domain__IdAssignment15228 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Codomain__IdAssignment15259 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNode_in_rule__MappingNode__DomainAssignment_015290 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNode_in_rule__MappingNode__CodomainAssignment_215321 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArrow_in_rule__MappingArrow__DomainAssignment_015352 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArrow_in_rule__MappingArrow__CodmainAssignment_215383 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ExtSubTGraph__IdAssignment_015414 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleChoosenExtSubTGraph_in_rule__ExtSubTGraph__ExtendsGraphAssignment_415445 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleElement_in_rule__ExtSubTGraph__ElementsAssignment_7_015476 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleElement_in_rule__ExtSubTGraph__ElementsAssignment_7_1_115507 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ChoosenExtSubTGraph__IdAssignment15538 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleElement_in_rule__Graph__ElementsAssignment_2_015569 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleElement_in_rule__Graph__ElementsAssignment_2_1_115600 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNode_in_rule__Arrows__SrAssignment_0_015631 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDpfId_in_rule__Arrows__IdAssignment_0_215662 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDpfId_in_rule__Arrows__TypeAssignment_0_415693 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArrows_in_rule__Arrows__NextAssignment_0_615724 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNode_in_rule__Arrow__SrAssignment_0_015755 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDpfId_in_rule__Arrow__IdAssignment_0_215786 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDataType_in_rule__Arrow__TgDataTypeAssignment_0_615817 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNode_in_rule__Arrow__SrAssignment_1_015848 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDpfId_in_rule__Arrow__IdAssignment_1_215879 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDpfId_in_rule__Arrow__TypeAssignment_1_415910 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAttributeValue_in_rule__Arrow__TgValueAssignment_1_615941 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNode_in_rule__Arrow__SrAssignment_2_015972 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDpfId_in_rule__Arrow__IdAssignment_2_216003 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDpfId_in_rule__Arrow__TypeAssignment_2_416034 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNode_in_rule__Arrow__TgNodeAssignment_2_616065 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDpfId_in_rule__Node__IdAssignment_016096 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDpfId_in_rule__Node__TypeAssignment_216127 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVALUE_in_rule__AttributeValue__ValueAssignment_116158 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__DpfId__NameAssignment_016189 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__DpfId__IdAssignment_1_116220 = new BitSet(new long[]{0x0000000000000002L});

}