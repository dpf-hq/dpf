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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_NUMBER", "RULE_CHAR", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ANY_OTHER", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "'Boolean'", "'Char'", "'Byte'", "'Short'", "'Int'", "'Long'", "'Float'", "'Double'", "'String'", "'emf('", "')'", "'ecore('", "'image('", "'simpleEvolution('", "'<-'", "'->'", "','", "'evolution('", "'<->'", "'-><-'", "':='", "'ISpec'", "'<'", "'>'", "'{'", "'}'", "'='", "'Specification'", "':'", "'Constraints'", "'('", "'Morphism'", "'=>'", "'ExtSubTGraph'", "'Graph'", "'-'", "'*'", "'['", "']'", "'@'"
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
    public static final int T__52=52;
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


    // $ANTLR start "entryRuleInstanceSpecification"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:340:1: entryRuleInstanceSpecification : ruleInstanceSpecification EOF ;
    public final void entryRuleInstanceSpecification() throws RecognitionException {
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:341:1: ( ruleInstanceSpecification EOF )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:342:1: ruleInstanceSpecification EOF
            {
             before(grammarAccess.getInstanceSpecificationRule()); 
            pushFollow(FOLLOW_ruleInstanceSpecification_in_entryRuleInstanceSpecification661);
            ruleInstanceSpecification();

            state._fsp--;

             after(grammarAccess.getInstanceSpecificationRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleInstanceSpecification668); 

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
    // $ANTLR end "entryRuleInstanceSpecification"


    // $ANTLR start "ruleInstanceSpecification"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:349:1: ruleInstanceSpecification : ( ( rule__InstanceSpecification__Group__0 ) ) ;
    public final void ruleInstanceSpecification() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:353:2: ( ( ( rule__InstanceSpecification__Group__0 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:354:1: ( ( rule__InstanceSpecification__Group__0 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:354:1: ( ( rule__InstanceSpecification__Group__0 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:355:1: ( rule__InstanceSpecification__Group__0 )
            {
             before(grammarAccess.getInstanceSpecificationAccess().getGroup()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:356:1: ( rule__InstanceSpecification__Group__0 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:356:2: rule__InstanceSpecification__Group__0
            {
            pushFollow(FOLLOW_rule__InstanceSpecification__Group__0_in_ruleInstanceSpecification694);
            rule__InstanceSpecification__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getInstanceSpecificationAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleInstanceSpecification"


    // $ANTLR start "entryRuleChoosenSpecfication"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:368:1: entryRuleChoosenSpecfication : ruleChoosenSpecfication EOF ;
    public final void entryRuleChoosenSpecfication() throws RecognitionException {
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:369:1: ( ruleChoosenSpecfication EOF )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:370:1: ruleChoosenSpecfication EOF
            {
             before(grammarAccess.getChoosenSpecficationRule()); 
            pushFollow(FOLLOW_ruleChoosenSpecfication_in_entryRuleChoosenSpecfication721);
            ruleChoosenSpecfication();

            state._fsp--;

             after(grammarAccess.getChoosenSpecficationRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleChoosenSpecfication728); 

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
    // $ANTLR end "entryRuleChoosenSpecfication"


    // $ANTLR start "ruleChoosenSpecfication"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:377:1: ruleChoosenSpecfication : ( ( rule__ChoosenSpecfication__IdAssignment ) ) ;
    public final void ruleChoosenSpecfication() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:381:2: ( ( ( rule__ChoosenSpecfication__IdAssignment ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:382:1: ( ( rule__ChoosenSpecfication__IdAssignment ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:382:1: ( ( rule__ChoosenSpecfication__IdAssignment ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:383:1: ( rule__ChoosenSpecfication__IdAssignment )
            {
             before(grammarAccess.getChoosenSpecficationAccess().getIdAssignment()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:384:1: ( rule__ChoosenSpecfication__IdAssignment )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:384:2: rule__ChoosenSpecfication__IdAssignment
            {
            pushFollow(FOLLOW_rule__ChoosenSpecfication__IdAssignment_in_ruleChoosenSpecfication754);
            rule__ChoosenSpecfication__IdAssignment();

            state._fsp--;


            }

             after(grammarAccess.getChoosenSpecficationAccess().getIdAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleChoosenSpecfication"


    // $ANTLR start "entryRuleConstraintSemantic"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:396:1: entryRuleConstraintSemantic : ruleConstraintSemantic EOF ;
    public final void entryRuleConstraintSemantic() throws RecognitionException {
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:397:1: ( ruleConstraintSemantic EOF )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:398:1: ruleConstraintSemantic EOF
            {
             before(grammarAccess.getConstraintSemanticRule()); 
            pushFollow(FOLLOW_ruleConstraintSemantic_in_entryRuleConstraintSemantic781);
            ruleConstraintSemantic();

            state._fsp--;

             after(grammarAccess.getConstraintSemanticRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleConstraintSemantic788); 

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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:405:1: ruleConstraintSemantic : ( ( rule__ConstraintSemantic__Group__0 ) ) ;
    public final void ruleConstraintSemantic() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:409:2: ( ( ( rule__ConstraintSemantic__Group__0 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:410:1: ( ( rule__ConstraintSemantic__Group__0 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:410:1: ( ( rule__ConstraintSemantic__Group__0 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:411:1: ( rule__ConstraintSemantic__Group__0 )
            {
             before(grammarAccess.getConstraintSemanticAccess().getGroup()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:412:1: ( rule__ConstraintSemantic__Group__0 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:412:2: rule__ConstraintSemantic__Group__0
            {
            pushFollow(FOLLOW_rule__ConstraintSemantic__Group__0_in_ruleConstraintSemantic814);
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


    // $ANTLR start "entryRuleSpecification"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:424:1: entryRuleSpecification : ruleSpecification EOF ;
    public final void entryRuleSpecification() throws RecognitionException {
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:425:1: ( ruleSpecification EOF )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:426:1: ruleSpecification EOF
            {
             before(grammarAccess.getSpecificationRule()); 
            pushFollow(FOLLOW_ruleSpecification_in_entryRuleSpecification841);
            ruleSpecification();

            state._fsp--;

             after(grammarAccess.getSpecificationRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSpecification848); 

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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:433:1: ruleSpecification : ( ( rule__Specification__Group__0 ) ) ;
    public final void ruleSpecification() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:437:2: ( ( ( rule__Specification__Group__0 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:438:1: ( ( rule__Specification__Group__0 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:438:1: ( ( rule__Specification__Group__0 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:439:1: ( rule__Specification__Group__0 )
            {
             before(grammarAccess.getSpecificationAccess().getGroup()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:440:1: ( rule__Specification__Group__0 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:440:2: rule__Specification__Group__0
            {
            pushFollow(FOLLOW_rule__Specification__Group__0_in_ruleSpecification874);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:452:1: entryRuleChoosenSpecification : ruleChoosenSpecification EOF ;
    public final void entryRuleChoosenSpecification() throws RecognitionException {
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:453:1: ( ruleChoosenSpecification EOF )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:454:1: ruleChoosenSpecification EOF
            {
             before(grammarAccess.getChoosenSpecificationRule()); 
            pushFollow(FOLLOW_ruleChoosenSpecification_in_entryRuleChoosenSpecification901);
            ruleChoosenSpecification();

            state._fsp--;

             after(grammarAccess.getChoosenSpecificationRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleChoosenSpecification908); 

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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:461:1: ruleChoosenSpecification : ( ( rule__ChoosenSpecification__IdAssignment ) ) ;
    public final void ruleChoosenSpecification() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:465:2: ( ( ( rule__ChoosenSpecification__IdAssignment ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:466:1: ( ( rule__ChoosenSpecification__IdAssignment ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:466:1: ( ( rule__ChoosenSpecification__IdAssignment ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:467:1: ( rule__ChoosenSpecification__IdAssignment )
            {
             before(grammarAccess.getChoosenSpecificationAccess().getIdAssignment()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:468:1: ( rule__ChoosenSpecification__IdAssignment )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:468:2: rule__ChoosenSpecification__IdAssignment
            {
            pushFollow(FOLLOW_rule__ChoosenSpecification__IdAssignment_in_ruleChoosenSpecification934);
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


    // $ANTLR start "entryRuleChoosenConstraintSemantic"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:480:1: entryRuleChoosenConstraintSemantic : ruleChoosenConstraintSemantic EOF ;
    public final void entryRuleChoosenConstraintSemantic() throws RecognitionException {
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:481:1: ( ruleChoosenConstraintSemantic EOF )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:482:1: ruleChoosenConstraintSemantic EOF
            {
             before(grammarAccess.getChoosenConstraintSemanticRule()); 
            pushFollow(FOLLOW_ruleChoosenConstraintSemantic_in_entryRuleChoosenConstraintSemantic961);
            ruleChoosenConstraintSemantic();

            state._fsp--;

             after(grammarAccess.getChoosenConstraintSemanticRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleChoosenConstraintSemantic968); 

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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:489:1: ruleChoosenConstraintSemantic : ( ( rule__ChoosenConstraintSemantic__IdAssignment ) ) ;
    public final void ruleChoosenConstraintSemantic() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:493:2: ( ( ( rule__ChoosenConstraintSemantic__IdAssignment ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:494:1: ( ( rule__ChoosenConstraintSemantic__IdAssignment ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:494:1: ( ( rule__ChoosenConstraintSemantic__IdAssignment ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:495:1: ( rule__ChoosenConstraintSemantic__IdAssignment )
            {
             before(grammarAccess.getChoosenConstraintSemanticAccess().getIdAssignment()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:496:1: ( rule__ChoosenConstraintSemantic__IdAssignment )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:496:2: rule__ChoosenConstraintSemantic__IdAssignment
            {
            pushFollow(FOLLOW_rule__ChoosenConstraintSemantic__IdAssignment_in_ruleChoosenConstraintSemantic994);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:508:1: entryRuleConstraint : ruleConstraint EOF ;
    public final void entryRuleConstraint() throws RecognitionException {
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:509:1: ( ruleConstraint EOF )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:510:1: ruleConstraint EOF
            {
             before(grammarAccess.getConstraintRule()); 
            pushFollow(FOLLOW_ruleConstraint_in_entryRuleConstraint1021);
            ruleConstraint();

            state._fsp--;

             after(grammarAccess.getConstraintRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleConstraint1028); 

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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:517:1: ruleConstraint : ( ( rule__Constraint__Group__0 ) ) ;
    public final void ruleConstraint() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:521:2: ( ( ( rule__Constraint__Group__0 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:522:1: ( ( rule__Constraint__Group__0 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:522:1: ( ( rule__Constraint__Group__0 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:523:1: ( rule__Constraint__Group__0 )
            {
             before(grammarAccess.getConstraintAccess().getGroup()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:524:1: ( rule__Constraint__Group__0 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:524:2: rule__Constraint__Group__0
            {
            pushFollow(FOLLOW_rule__Constraint__Group__0_in_ruleConstraint1054);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:536:1: entryRuleConstraintSignature : ruleConstraintSignature EOF ;
    public final void entryRuleConstraintSignature() throws RecognitionException {
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:537:1: ( ruleConstraintSignature EOF )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:538:1: ruleConstraintSignature EOF
            {
             before(grammarAccess.getConstraintSignatureRule()); 
            pushFollow(FOLLOW_ruleConstraintSignature_in_entryRuleConstraintSignature1081);
            ruleConstraintSignature();

            state._fsp--;

             after(grammarAccess.getConstraintSignatureRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleConstraintSignature1088); 

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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:545:1: ruleConstraintSignature : ( ( rule__ConstraintSignature__Group__0 ) ) ;
    public final void ruleConstraintSignature() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:549:2: ( ( ( rule__ConstraintSignature__Group__0 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:550:1: ( ( rule__ConstraintSignature__Group__0 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:550:1: ( ( rule__ConstraintSignature__Group__0 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:551:1: ( rule__ConstraintSignature__Group__0 )
            {
             before(grammarAccess.getConstraintSignatureAccess().getGroup()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:552:1: ( rule__ConstraintSignature__Group__0 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:552:2: rule__ConstraintSignature__Group__0
            {
            pushFollow(FOLLOW_rule__ConstraintSignature__Group__0_in_ruleConstraintSignature1114);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1003:1: rule__Model__Alternatives : ( ( ruleSpecification ) | ( ( rule__Model__Group_1__0 )? ) );
    public final void rule__Model__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1007:1: ( ( ruleSpecification ) | ( ( rule__Model__Group_1__0 )? ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==40) ) {
                alt2=1;
            }
            else if ( (LA2_0==EOF||LA2_0==RULE_ID||LA2_0==22||(LA2_0>=24 && LA2_0<=26)||LA2_0==30) ) {
                alt2=2;
            }
            else {
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
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1014:6: ( ( rule__Model__Group_1__0 )? )
                    {
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1014:6: ( ( rule__Model__Group_1__0 )? )
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1015:1: ( rule__Model__Group_1__0 )?
                    {
                     before(grammarAccess.getModelAccess().getGroup_1()); 
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1016:1: ( rule__Model__Group_1__0 )?
                    int alt1=2;
                    int LA1_0 = input.LA(1);

                    if ( (LA1_0==RULE_ID||LA1_0==22||(LA1_0>=24 && LA1_0<=26)||LA1_0==30) ) {
                        alt1=1;
                    }
                    switch (alt1) {
                        case 1 :
                            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1016:2: rule__Model__Group_1__0
                            {
                            pushFollow(FOLLOW_rule__Model__Group_1__0_in_rule__Model__Alternatives2103);
                            rule__Model__Group_1__0();

                            state._fsp--;


                            }
                            break;

                    }

                     after(grammarAccess.getModelAccess().getGroup_1()); 

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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1025:1: rule__VALUE__Alternatives : ( ( RULE_NUMBER ) | ( RULE_CHAR ) | ( RULE_STRING ) );
    public final void rule__VALUE__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1029:1: ( ( RULE_NUMBER ) | ( RULE_CHAR ) | ( RULE_STRING ) )
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
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1030:1: ( RULE_NUMBER )
                    {
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1030:1: ( RULE_NUMBER )
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1031:1: RULE_NUMBER
                    {
                     before(grammarAccess.getVALUEAccess().getNUMBERTerminalRuleCall_0()); 
                    match(input,RULE_NUMBER,FOLLOW_RULE_NUMBER_in_rule__VALUE__Alternatives2137); 
                     after(grammarAccess.getVALUEAccess().getNUMBERTerminalRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1036:6: ( RULE_CHAR )
                    {
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1036:6: ( RULE_CHAR )
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1037:1: RULE_CHAR
                    {
                     before(grammarAccess.getVALUEAccess().getCHARTerminalRuleCall_1()); 
                    match(input,RULE_CHAR,FOLLOW_RULE_CHAR_in_rule__VALUE__Alternatives2154); 
                     after(grammarAccess.getVALUEAccess().getCHARTerminalRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1042:6: ( RULE_STRING )
                    {
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1042:6: ( RULE_STRING )
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1043:1: RULE_STRING
                    {
                     before(grammarAccess.getVALUEAccess().getSTRINGTerminalRuleCall_2()); 
                    match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__VALUE__Alternatives2171); 
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1053:1: rule__Command__Alternatives : ( ( ruleInstanceSpecification ) | ( ruleExtSubTGraph ) | ( ruleMakeEmf ) | ( ruleMakeEcore ) | ( ruleMakeImage ) | ( ruleSimpleEvoSpan ) | ( ruleSimpleEvoCospan ) | ( ruleMorphism ) | ( ruleEvoSpan ) | ( ruleEvoCospan ) );
    public final void rule__Command__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1057:1: ( ( ruleInstanceSpecification ) | ( ruleExtSubTGraph ) | ( ruleMakeEmf ) | ( ruleMakeEcore ) | ( ruleMakeImage ) | ( ruleSimpleEvoSpan ) | ( ruleSimpleEvoCospan ) | ( ruleMorphism ) | ( ruleEvoSpan ) | ( ruleEvoCospan ) )
            int alt4=10;
            alt4 = dfa4.predict(input);
            switch (alt4) {
                case 1 :
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1058:1: ( ruleInstanceSpecification )
                    {
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1058:1: ( ruleInstanceSpecification )
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1059:1: ruleInstanceSpecification
                    {
                     before(grammarAccess.getCommandAccess().getInstanceSpecificationParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleInstanceSpecification_in_rule__Command__Alternatives2203);
                    ruleInstanceSpecification();

                    state._fsp--;

                     after(grammarAccess.getCommandAccess().getInstanceSpecificationParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1064:6: ( ruleExtSubTGraph )
                    {
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1064:6: ( ruleExtSubTGraph )
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1065:1: ruleExtSubTGraph
                    {
                     before(grammarAccess.getCommandAccess().getExtSubTGraphParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleExtSubTGraph_in_rule__Command__Alternatives2220);
                    ruleExtSubTGraph();

                    state._fsp--;

                     after(grammarAccess.getCommandAccess().getExtSubTGraphParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1070:6: ( ruleMakeEmf )
                    {
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1070:6: ( ruleMakeEmf )
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1071:1: ruleMakeEmf
                    {
                     before(grammarAccess.getCommandAccess().getMakeEmfParserRuleCall_2()); 
                    pushFollow(FOLLOW_ruleMakeEmf_in_rule__Command__Alternatives2237);
                    ruleMakeEmf();

                    state._fsp--;

                     after(grammarAccess.getCommandAccess().getMakeEmfParserRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1076:6: ( ruleMakeEcore )
                    {
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1076:6: ( ruleMakeEcore )
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1077:1: ruleMakeEcore
                    {
                     before(grammarAccess.getCommandAccess().getMakeEcoreParserRuleCall_3()); 
                    pushFollow(FOLLOW_ruleMakeEcore_in_rule__Command__Alternatives2254);
                    ruleMakeEcore();

                    state._fsp--;

                     after(grammarAccess.getCommandAccess().getMakeEcoreParserRuleCall_3()); 

                    }


                    }
                    break;
                case 5 :
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1082:6: ( ruleMakeImage )
                    {
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1082:6: ( ruleMakeImage )
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1083:1: ruleMakeImage
                    {
                     before(grammarAccess.getCommandAccess().getMakeImageParserRuleCall_4()); 
                    pushFollow(FOLLOW_ruleMakeImage_in_rule__Command__Alternatives2271);
                    ruleMakeImage();

                    state._fsp--;

                     after(grammarAccess.getCommandAccess().getMakeImageParserRuleCall_4()); 

                    }


                    }
                    break;
                case 6 :
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1088:6: ( ruleSimpleEvoSpan )
                    {
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1088:6: ( ruleSimpleEvoSpan )
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1089:1: ruleSimpleEvoSpan
                    {
                     before(grammarAccess.getCommandAccess().getSimpleEvoSpanParserRuleCall_5()); 
                    pushFollow(FOLLOW_ruleSimpleEvoSpan_in_rule__Command__Alternatives2288);
                    ruleSimpleEvoSpan();

                    state._fsp--;

                     after(grammarAccess.getCommandAccess().getSimpleEvoSpanParserRuleCall_5()); 

                    }


                    }
                    break;
                case 7 :
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1094:6: ( ruleSimpleEvoCospan )
                    {
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1094:6: ( ruleSimpleEvoCospan )
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1095:1: ruleSimpleEvoCospan
                    {
                     before(grammarAccess.getCommandAccess().getSimpleEvoCospanParserRuleCall_6()); 
                    pushFollow(FOLLOW_ruleSimpleEvoCospan_in_rule__Command__Alternatives2305);
                    ruleSimpleEvoCospan();

                    state._fsp--;

                     after(grammarAccess.getCommandAccess().getSimpleEvoCospanParserRuleCall_6()); 

                    }


                    }
                    break;
                case 8 :
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1100:6: ( ruleMorphism )
                    {
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1100:6: ( ruleMorphism )
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1101:1: ruleMorphism
                    {
                     before(grammarAccess.getCommandAccess().getMorphismParserRuleCall_7()); 
                    pushFollow(FOLLOW_ruleMorphism_in_rule__Command__Alternatives2322);
                    ruleMorphism();

                    state._fsp--;

                     after(grammarAccess.getCommandAccess().getMorphismParserRuleCall_7()); 

                    }


                    }
                    break;
                case 9 :
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1106:6: ( ruleEvoSpan )
                    {
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1106:6: ( ruleEvoSpan )
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1107:1: ruleEvoSpan
                    {
                     before(grammarAccess.getCommandAccess().getEvoSpanParserRuleCall_8()); 
                    pushFollow(FOLLOW_ruleEvoSpan_in_rule__Command__Alternatives2339);
                    ruleEvoSpan();

                    state._fsp--;

                     after(grammarAccess.getCommandAccess().getEvoSpanParserRuleCall_8()); 

                    }


                    }
                    break;
                case 10 :
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1112:6: ( ruleEvoCospan )
                    {
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1112:6: ( ruleEvoCospan )
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1113:1: ruleEvoCospan
                    {
                     before(grammarAccess.getCommandAccess().getEvoCospanParserRuleCall_9()); 
                    pushFollow(FOLLOW_ruleEvoCospan_in_rule__Command__Alternatives2356);
                    ruleEvoCospan();

                    state._fsp--;

                     after(grammarAccess.getCommandAccess().getEvoCospanParserRuleCall_9()); 

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


    // $ANTLR start "rule__Mapping__Alternatives"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1123:1: rule__Mapping__Alternatives : ( ( ruleMappingNode ) | ( ruleMappingArrow ) );
    public final void rule__Mapping__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1127:1: ( ( ruleMappingNode ) | ( ruleMappingArrow ) )
            int alt5=2;
            alt5 = dfa5.predict(input);
            switch (alt5) {
                case 1 :
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1128:1: ( ruleMappingNode )
                    {
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1128:1: ( ruleMappingNode )
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1129:1: ruleMappingNode
                    {
                     before(grammarAccess.getMappingAccess().getMappingNodeParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleMappingNode_in_rule__Mapping__Alternatives2388);
                    ruleMappingNode();

                    state._fsp--;

                     after(grammarAccess.getMappingAccess().getMappingNodeParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1134:6: ( ruleMappingArrow )
                    {
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1134:6: ( ruleMappingArrow )
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1135:1: ruleMappingArrow
                    {
                     before(grammarAccess.getMappingAccess().getMappingArrowParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleMappingArrow_in_rule__Mapping__Alternatives2405);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1145:1: rule__Element__Alternatives : ( ( ( rule__Element__Group_0__0 ) ) | ( ( rule__Element__Group_1__0 ) ) );
    public final void rule__Element__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1149:1: ( ( ( rule__Element__Group_0__0 ) ) | ( ( rule__Element__Group_1__0 ) ) )
            int alt6=2;
            alt6 = dfa6.predict(input);
            switch (alt6) {
                case 1 :
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1150:1: ( ( rule__Element__Group_0__0 ) )
                    {
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1150:1: ( ( rule__Element__Group_0__0 ) )
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1151:1: ( rule__Element__Group_0__0 )
                    {
                     before(grammarAccess.getElementAccess().getGroup_0()); 
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1152:1: ( rule__Element__Group_0__0 )
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1152:2: rule__Element__Group_0__0
                    {
                    pushFollow(FOLLOW_rule__Element__Group_0__0_in_rule__Element__Alternatives2437);
                    rule__Element__Group_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getElementAccess().getGroup_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1156:6: ( ( rule__Element__Group_1__0 ) )
                    {
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1156:6: ( ( rule__Element__Group_1__0 ) )
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1157:1: ( rule__Element__Group_1__0 )
                    {
                     before(grammarAccess.getElementAccess().getGroup_1()); 
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1158:1: ( rule__Element__Group_1__0 )
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1158:2: rule__Element__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__Element__Group_1__0_in_rule__Element__Alternatives2455);
                    rule__Element__Group_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getElementAccess().getGroup_1()); 

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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1167:1: rule__Arrows__Alternatives : ( ( ( rule__Arrows__Group_0__0 ) ) | ( ruleArrow ) );
    public final void rule__Arrows__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1171:1: ( ( ( rule__Arrows__Group_0__0 ) ) | ( ruleArrow ) )
            int alt7=2;
            alt7 = dfa7.predict(input);
            switch (alt7) {
                case 1 :
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1172:1: ( ( rule__Arrows__Group_0__0 ) )
                    {
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1172:1: ( ( rule__Arrows__Group_0__0 ) )
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1173:1: ( rule__Arrows__Group_0__0 )
                    {
                     before(grammarAccess.getArrowsAccess().getGroup_0()); 
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1174:1: ( rule__Arrows__Group_0__0 )
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1174:2: rule__Arrows__Group_0__0
                    {
                    pushFollow(FOLLOW_rule__Arrows__Group_0__0_in_rule__Arrows__Alternatives2488);
                    rule__Arrows__Group_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getArrowsAccess().getGroup_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1178:6: ( ruleArrow )
                    {
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1178:6: ( ruleArrow )
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1179:1: ruleArrow
                    {
                     before(grammarAccess.getArrowsAccess().getArrowParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleArrow_in_rule__Arrows__Alternatives2506);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1189:1: rule__Arrow__Alternatives : ( ( ( rule__Arrow__Group_0__0 ) ) | ( ( rule__Arrow__Group_1__0 ) ) | ( ( rule__Arrow__Group_2__0 ) ) );
    public final void rule__Arrow__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1193:1: ( ( ( rule__Arrow__Group_0__0 ) ) | ( ( rule__Arrow__Group_1__0 ) ) | ( ( rule__Arrow__Group_2__0 ) ) )
            int alt8=3;
            alt8 = dfa8.predict(input);
            switch (alt8) {
                case 1 :
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1194:1: ( ( rule__Arrow__Group_0__0 ) )
                    {
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1194:1: ( ( rule__Arrow__Group_0__0 ) )
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1195:1: ( rule__Arrow__Group_0__0 )
                    {
                     before(grammarAccess.getArrowAccess().getGroup_0()); 
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1196:1: ( rule__Arrow__Group_0__0 )
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1196:2: rule__Arrow__Group_0__0
                    {
                    pushFollow(FOLLOW_rule__Arrow__Group_0__0_in_rule__Arrow__Alternatives2538);
                    rule__Arrow__Group_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getArrowAccess().getGroup_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1200:6: ( ( rule__Arrow__Group_1__0 ) )
                    {
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1200:6: ( ( rule__Arrow__Group_1__0 ) )
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1201:1: ( rule__Arrow__Group_1__0 )
                    {
                     before(grammarAccess.getArrowAccess().getGroup_1()); 
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1202:1: ( rule__Arrow__Group_1__0 )
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1202:2: rule__Arrow__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__Arrow__Group_1__0_in_rule__Arrow__Alternatives2556);
                    rule__Arrow__Group_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getArrowAccess().getGroup_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1206:6: ( ( rule__Arrow__Group_2__0 ) )
                    {
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1206:6: ( ( rule__Arrow__Group_2__0 ) )
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1207:1: ( rule__Arrow__Group_2__0 )
                    {
                     before(grammarAccess.getArrowAccess().getGroup_2()); 
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1208:1: ( rule__Arrow__Group_2__0 )
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1208:2: rule__Arrow__Group_2__0
                    {
                    pushFollow(FOLLOW_rule__Arrow__Group_2__0_in_rule__Arrow__Alternatives2574);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1217:1: rule__DataType__Alternatives : ( ( ( 'Boolean' ) ) | ( ( 'Char' ) ) | ( ( 'Byte' ) ) | ( ( 'Short' ) ) | ( ( 'Int' ) ) | ( ( 'Long' ) ) | ( ( 'Float' ) ) | ( ( 'Double' ) ) | ( ( 'String' ) ) );
    public final void rule__DataType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1221:1: ( ( ( 'Boolean' ) ) | ( ( 'Char' ) ) | ( ( 'Byte' ) ) | ( ( 'Short' ) ) | ( ( 'Int' ) ) | ( ( 'Long' ) ) | ( ( 'Float' ) ) | ( ( 'Double' ) ) | ( ( 'String' ) ) )
            int alt9=9;
            switch ( input.LA(1) ) {
            case 13:
                {
                alt9=1;
                }
                break;
            case 14:
                {
                alt9=2;
                }
                break;
            case 15:
                {
                alt9=3;
                }
                break;
            case 16:
                {
                alt9=4;
                }
                break;
            case 17:
                {
                alt9=5;
                }
                break;
            case 18:
                {
                alt9=6;
                }
                break;
            case 19:
                {
                alt9=7;
                }
                break;
            case 20:
                {
                alt9=8;
                }
                break;
            case 21:
                {
                alt9=9;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }

            switch (alt9) {
                case 1 :
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1222:1: ( ( 'Boolean' ) )
                    {
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1222:1: ( ( 'Boolean' ) )
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1223:1: ( 'Boolean' )
                    {
                     before(grammarAccess.getDataTypeAccess().getTBOOLEANEnumLiteralDeclaration_0()); 
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1224:1: ( 'Boolean' )
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1224:3: 'Boolean'
                    {
                    match(input,13,FOLLOW_13_in_rule__DataType__Alternatives2608); 

                    }

                     after(grammarAccess.getDataTypeAccess().getTBOOLEANEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1229:6: ( ( 'Char' ) )
                    {
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1229:6: ( ( 'Char' ) )
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1230:1: ( 'Char' )
                    {
                     before(grammarAccess.getDataTypeAccess().getTCHAREnumLiteralDeclaration_1()); 
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1231:1: ( 'Char' )
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1231:3: 'Char'
                    {
                    match(input,14,FOLLOW_14_in_rule__DataType__Alternatives2629); 

                    }

                     after(grammarAccess.getDataTypeAccess().getTCHAREnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1236:6: ( ( 'Byte' ) )
                    {
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1236:6: ( ( 'Byte' ) )
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1237:1: ( 'Byte' )
                    {
                     before(grammarAccess.getDataTypeAccess().getTBYTEEnumLiteralDeclaration_2()); 
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1238:1: ( 'Byte' )
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1238:3: 'Byte'
                    {
                    match(input,15,FOLLOW_15_in_rule__DataType__Alternatives2650); 

                    }

                     after(grammarAccess.getDataTypeAccess().getTBYTEEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1243:6: ( ( 'Short' ) )
                    {
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1243:6: ( ( 'Short' ) )
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1244:1: ( 'Short' )
                    {
                     before(grammarAccess.getDataTypeAccess().getTSHORTEnumLiteralDeclaration_3()); 
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1245:1: ( 'Short' )
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1245:3: 'Short'
                    {
                    match(input,16,FOLLOW_16_in_rule__DataType__Alternatives2671); 

                    }

                     after(grammarAccess.getDataTypeAccess().getTSHORTEnumLiteralDeclaration_3()); 

                    }


                    }
                    break;
                case 5 :
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1250:6: ( ( 'Int' ) )
                    {
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1250:6: ( ( 'Int' ) )
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1251:1: ( 'Int' )
                    {
                     before(grammarAccess.getDataTypeAccess().getTINTEnumLiteralDeclaration_4()); 
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1252:1: ( 'Int' )
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1252:3: 'Int'
                    {
                    match(input,17,FOLLOW_17_in_rule__DataType__Alternatives2692); 

                    }

                     after(grammarAccess.getDataTypeAccess().getTINTEnumLiteralDeclaration_4()); 

                    }


                    }
                    break;
                case 6 :
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1257:6: ( ( 'Long' ) )
                    {
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1257:6: ( ( 'Long' ) )
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1258:1: ( 'Long' )
                    {
                     before(grammarAccess.getDataTypeAccess().getTLONGEnumLiteralDeclaration_5()); 
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1259:1: ( 'Long' )
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1259:3: 'Long'
                    {
                    match(input,18,FOLLOW_18_in_rule__DataType__Alternatives2713); 

                    }

                     after(grammarAccess.getDataTypeAccess().getTLONGEnumLiteralDeclaration_5()); 

                    }


                    }
                    break;
                case 7 :
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1264:6: ( ( 'Float' ) )
                    {
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1264:6: ( ( 'Float' ) )
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1265:1: ( 'Float' )
                    {
                     before(grammarAccess.getDataTypeAccess().getTFLOATEnumLiteralDeclaration_6()); 
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1266:1: ( 'Float' )
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1266:3: 'Float'
                    {
                    match(input,19,FOLLOW_19_in_rule__DataType__Alternatives2734); 

                    }

                     after(grammarAccess.getDataTypeAccess().getTFLOATEnumLiteralDeclaration_6()); 

                    }


                    }
                    break;
                case 8 :
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1271:6: ( ( 'Double' ) )
                    {
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1271:6: ( ( 'Double' ) )
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1272:1: ( 'Double' )
                    {
                     before(grammarAccess.getDataTypeAccess().getTDOUBLEEnumLiteralDeclaration_7()); 
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1273:1: ( 'Double' )
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1273:3: 'Double'
                    {
                    match(input,20,FOLLOW_20_in_rule__DataType__Alternatives2755); 

                    }

                     after(grammarAccess.getDataTypeAccess().getTDOUBLEEnumLiteralDeclaration_7()); 

                    }


                    }
                    break;
                case 9 :
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1278:6: ( ( 'String' ) )
                    {
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1278:6: ( ( 'String' ) )
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1279:1: ( 'String' )
                    {
                     before(grammarAccess.getDataTypeAccess().getTSTRINGEnumLiteralDeclaration_8()); 
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1280:1: ( 'String' )
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1280:3: 'String'
                    {
                    match(input,21,FOLLOW_21_in_rule__DataType__Alternatives2776); 

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


    // $ANTLR start "rule__Model__Group_1__0"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1292:1: rule__Model__Group_1__0 : rule__Model__Group_1__0__Impl rule__Model__Group_1__1 ;
    public final void rule__Model__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1296:1: ( rule__Model__Group_1__0__Impl rule__Model__Group_1__1 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1297:2: rule__Model__Group_1__0__Impl rule__Model__Group_1__1
            {
            pushFollow(FOLLOW_rule__Model__Group_1__0__Impl_in_rule__Model__Group_1__02809);
            rule__Model__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Model__Group_1__1_in_rule__Model__Group_1__02812);
            rule__Model__Group_1__1();

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
    // $ANTLR end "rule__Model__Group_1__0"


    // $ANTLR start "rule__Model__Group_1__0__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1304:1: rule__Model__Group_1__0__Impl : ( ( rule__Model__CommandsAssignment_1_0 ) ) ;
    public final void rule__Model__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1308:1: ( ( ( rule__Model__CommandsAssignment_1_0 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1309:1: ( ( rule__Model__CommandsAssignment_1_0 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1309:1: ( ( rule__Model__CommandsAssignment_1_0 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1310:1: ( rule__Model__CommandsAssignment_1_0 )
            {
             before(grammarAccess.getModelAccess().getCommandsAssignment_1_0()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1311:1: ( rule__Model__CommandsAssignment_1_0 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1311:2: rule__Model__CommandsAssignment_1_0
            {
            pushFollow(FOLLOW_rule__Model__CommandsAssignment_1_0_in_rule__Model__Group_1__0__Impl2839);
            rule__Model__CommandsAssignment_1_0();

            state._fsp--;


            }

             after(grammarAccess.getModelAccess().getCommandsAssignment_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_1__0__Impl"


    // $ANTLR start "rule__Model__Group_1__1"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1321:1: rule__Model__Group_1__1 : rule__Model__Group_1__1__Impl ;
    public final void rule__Model__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1325:1: ( rule__Model__Group_1__1__Impl )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1326:2: rule__Model__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__Model__Group_1__1__Impl_in_rule__Model__Group_1__12869);
            rule__Model__Group_1__1__Impl();

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
    // $ANTLR end "rule__Model__Group_1__1"


    // $ANTLR start "rule__Model__Group_1__1__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1332:1: rule__Model__Group_1__1__Impl : ( ( rule__Model__CommandsAssignment_1_1 )* ) ;
    public final void rule__Model__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1336:1: ( ( ( rule__Model__CommandsAssignment_1_1 )* ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1337:1: ( ( rule__Model__CommandsAssignment_1_1 )* )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1337:1: ( ( rule__Model__CommandsAssignment_1_1 )* )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1338:1: ( rule__Model__CommandsAssignment_1_1 )*
            {
             before(grammarAccess.getModelAccess().getCommandsAssignment_1_1()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1339:1: ( rule__Model__CommandsAssignment_1_1 )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==RULE_ID||LA10_0==22||(LA10_0>=24 && LA10_0<=26)||LA10_0==30) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1339:2: rule__Model__CommandsAssignment_1_1
            	    {
            	    pushFollow(FOLLOW_rule__Model__CommandsAssignment_1_1_in_rule__Model__Group_1__1__Impl2896);
            	    rule__Model__CommandsAssignment_1_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

             after(grammarAccess.getModelAccess().getCommandsAssignment_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_1__1__Impl"


    // $ANTLR start "rule__MakeEmf__Group__0"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1353:1: rule__MakeEmf__Group__0 : rule__MakeEmf__Group__0__Impl rule__MakeEmf__Group__1 ;
    public final void rule__MakeEmf__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1357:1: ( rule__MakeEmf__Group__0__Impl rule__MakeEmf__Group__1 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1358:2: rule__MakeEmf__Group__0__Impl rule__MakeEmf__Group__1
            {
            pushFollow(FOLLOW_rule__MakeEmf__Group__0__Impl_in_rule__MakeEmf__Group__02931);
            rule__MakeEmf__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__MakeEmf__Group__1_in_rule__MakeEmf__Group__02934);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1365:1: rule__MakeEmf__Group__0__Impl : ( 'emf(' ) ;
    public final void rule__MakeEmf__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1369:1: ( ( 'emf(' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1370:1: ( 'emf(' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1370:1: ( 'emf(' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1371:1: 'emf('
            {
             before(grammarAccess.getMakeEmfAccess().getEmfKeyword_0()); 
            match(input,22,FOLLOW_22_in_rule__MakeEmf__Group__0__Impl2962); 
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1384:1: rule__MakeEmf__Group__1 : rule__MakeEmf__Group__1__Impl rule__MakeEmf__Group__2 ;
    public final void rule__MakeEmf__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1388:1: ( rule__MakeEmf__Group__1__Impl rule__MakeEmf__Group__2 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1389:2: rule__MakeEmf__Group__1__Impl rule__MakeEmf__Group__2
            {
            pushFollow(FOLLOW_rule__MakeEmf__Group__1__Impl_in_rule__MakeEmf__Group__12993);
            rule__MakeEmf__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__MakeEmf__Group__2_in_rule__MakeEmf__Group__12996);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1396:1: rule__MakeEmf__Group__1__Impl : ( ( rule__MakeEmf__IdAssignment_1 ) ) ;
    public final void rule__MakeEmf__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1400:1: ( ( ( rule__MakeEmf__IdAssignment_1 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1401:1: ( ( rule__MakeEmf__IdAssignment_1 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1401:1: ( ( rule__MakeEmf__IdAssignment_1 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1402:1: ( rule__MakeEmf__IdAssignment_1 )
            {
             before(grammarAccess.getMakeEmfAccess().getIdAssignment_1()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1403:1: ( rule__MakeEmf__IdAssignment_1 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1403:2: rule__MakeEmf__IdAssignment_1
            {
            pushFollow(FOLLOW_rule__MakeEmf__IdAssignment_1_in_rule__MakeEmf__Group__1__Impl3023);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1413:1: rule__MakeEmf__Group__2 : rule__MakeEmf__Group__2__Impl ;
    public final void rule__MakeEmf__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1417:1: ( rule__MakeEmf__Group__2__Impl )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1418:2: rule__MakeEmf__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__MakeEmf__Group__2__Impl_in_rule__MakeEmf__Group__23053);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1424:1: rule__MakeEmf__Group__2__Impl : ( ')' ) ;
    public final void rule__MakeEmf__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1428:1: ( ( ')' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1429:1: ( ')' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1429:1: ( ')' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1430:1: ')'
            {
             before(grammarAccess.getMakeEmfAccess().getRightParenthesisKeyword_2()); 
            match(input,23,FOLLOW_23_in_rule__MakeEmf__Group__2__Impl3081); 
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1449:1: rule__MakeEcore__Group__0 : rule__MakeEcore__Group__0__Impl rule__MakeEcore__Group__1 ;
    public final void rule__MakeEcore__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1453:1: ( rule__MakeEcore__Group__0__Impl rule__MakeEcore__Group__1 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1454:2: rule__MakeEcore__Group__0__Impl rule__MakeEcore__Group__1
            {
            pushFollow(FOLLOW_rule__MakeEcore__Group__0__Impl_in_rule__MakeEcore__Group__03118);
            rule__MakeEcore__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__MakeEcore__Group__1_in_rule__MakeEcore__Group__03121);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1461:1: rule__MakeEcore__Group__0__Impl : ( 'ecore(' ) ;
    public final void rule__MakeEcore__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1465:1: ( ( 'ecore(' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1466:1: ( 'ecore(' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1466:1: ( 'ecore(' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1467:1: 'ecore('
            {
             before(grammarAccess.getMakeEcoreAccess().getEcoreKeyword_0()); 
            match(input,24,FOLLOW_24_in_rule__MakeEcore__Group__0__Impl3149); 
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1480:1: rule__MakeEcore__Group__1 : rule__MakeEcore__Group__1__Impl rule__MakeEcore__Group__2 ;
    public final void rule__MakeEcore__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1484:1: ( rule__MakeEcore__Group__1__Impl rule__MakeEcore__Group__2 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1485:2: rule__MakeEcore__Group__1__Impl rule__MakeEcore__Group__2
            {
            pushFollow(FOLLOW_rule__MakeEcore__Group__1__Impl_in_rule__MakeEcore__Group__13180);
            rule__MakeEcore__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__MakeEcore__Group__2_in_rule__MakeEcore__Group__13183);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1492:1: rule__MakeEcore__Group__1__Impl : ( ( rule__MakeEcore__IdAssignment_1 ) ) ;
    public final void rule__MakeEcore__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1496:1: ( ( ( rule__MakeEcore__IdAssignment_1 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1497:1: ( ( rule__MakeEcore__IdAssignment_1 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1497:1: ( ( rule__MakeEcore__IdAssignment_1 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1498:1: ( rule__MakeEcore__IdAssignment_1 )
            {
             before(grammarAccess.getMakeEcoreAccess().getIdAssignment_1()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1499:1: ( rule__MakeEcore__IdAssignment_1 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1499:2: rule__MakeEcore__IdAssignment_1
            {
            pushFollow(FOLLOW_rule__MakeEcore__IdAssignment_1_in_rule__MakeEcore__Group__1__Impl3210);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1509:1: rule__MakeEcore__Group__2 : rule__MakeEcore__Group__2__Impl ;
    public final void rule__MakeEcore__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1513:1: ( rule__MakeEcore__Group__2__Impl )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1514:2: rule__MakeEcore__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__MakeEcore__Group__2__Impl_in_rule__MakeEcore__Group__23240);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1520:1: rule__MakeEcore__Group__2__Impl : ( ')' ) ;
    public final void rule__MakeEcore__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1524:1: ( ( ')' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1525:1: ( ')' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1525:1: ( ')' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1526:1: ')'
            {
             before(grammarAccess.getMakeEcoreAccess().getRightParenthesisKeyword_2()); 
            match(input,23,FOLLOW_23_in_rule__MakeEcore__Group__2__Impl3268); 
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1545:1: rule__MakeImage__Group__0 : rule__MakeImage__Group__0__Impl rule__MakeImage__Group__1 ;
    public final void rule__MakeImage__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1549:1: ( rule__MakeImage__Group__0__Impl rule__MakeImage__Group__1 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1550:2: rule__MakeImage__Group__0__Impl rule__MakeImage__Group__1
            {
            pushFollow(FOLLOW_rule__MakeImage__Group__0__Impl_in_rule__MakeImage__Group__03305);
            rule__MakeImage__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__MakeImage__Group__1_in_rule__MakeImage__Group__03308);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1557:1: rule__MakeImage__Group__0__Impl : ( 'image(' ) ;
    public final void rule__MakeImage__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1561:1: ( ( 'image(' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1562:1: ( 'image(' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1562:1: ( 'image(' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1563:1: 'image('
            {
             before(grammarAccess.getMakeImageAccess().getImageKeyword_0()); 
            match(input,25,FOLLOW_25_in_rule__MakeImage__Group__0__Impl3336); 
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1576:1: rule__MakeImage__Group__1 : rule__MakeImage__Group__1__Impl rule__MakeImage__Group__2 ;
    public final void rule__MakeImage__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1580:1: ( rule__MakeImage__Group__1__Impl rule__MakeImage__Group__2 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1581:2: rule__MakeImage__Group__1__Impl rule__MakeImage__Group__2
            {
            pushFollow(FOLLOW_rule__MakeImage__Group__1__Impl_in_rule__MakeImage__Group__13367);
            rule__MakeImage__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__MakeImage__Group__2_in_rule__MakeImage__Group__13370);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1588:1: rule__MakeImage__Group__1__Impl : ( ( rule__MakeImage__IdAssignment_1 ) ) ;
    public final void rule__MakeImage__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1592:1: ( ( ( rule__MakeImage__IdAssignment_1 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1593:1: ( ( rule__MakeImage__IdAssignment_1 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1593:1: ( ( rule__MakeImage__IdAssignment_1 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1594:1: ( rule__MakeImage__IdAssignment_1 )
            {
             before(grammarAccess.getMakeImageAccess().getIdAssignment_1()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1595:1: ( rule__MakeImage__IdAssignment_1 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1595:2: rule__MakeImage__IdAssignment_1
            {
            pushFollow(FOLLOW_rule__MakeImage__IdAssignment_1_in_rule__MakeImage__Group__1__Impl3397);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1605:1: rule__MakeImage__Group__2 : rule__MakeImage__Group__2__Impl ;
    public final void rule__MakeImage__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1609:1: ( rule__MakeImage__Group__2__Impl )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1610:2: rule__MakeImage__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__MakeImage__Group__2__Impl_in_rule__MakeImage__Group__23427);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1616:1: rule__MakeImage__Group__2__Impl : ( ')' ) ;
    public final void rule__MakeImage__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1620:1: ( ( ')' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1621:1: ( ')' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1621:1: ( ')' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1622:1: ')'
            {
             before(grammarAccess.getMakeImageAccess().getRightParenthesisKeyword_2()); 
            match(input,23,FOLLOW_23_in_rule__MakeImage__Group__2__Impl3455); 
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1641:1: rule__SimpleEvoSpan__Group__0 : rule__SimpleEvoSpan__Group__0__Impl rule__SimpleEvoSpan__Group__1 ;
    public final void rule__SimpleEvoSpan__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1645:1: ( rule__SimpleEvoSpan__Group__0__Impl rule__SimpleEvoSpan__Group__1 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1646:2: rule__SimpleEvoSpan__Group__0__Impl rule__SimpleEvoSpan__Group__1
            {
            pushFollow(FOLLOW_rule__SimpleEvoSpan__Group__0__Impl_in_rule__SimpleEvoSpan__Group__03492);
            rule__SimpleEvoSpan__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SimpleEvoSpan__Group__1_in_rule__SimpleEvoSpan__Group__03495);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1653:1: rule__SimpleEvoSpan__Group__0__Impl : ( 'simpleEvolution(' ) ;
    public final void rule__SimpleEvoSpan__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1657:1: ( ( 'simpleEvolution(' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1658:1: ( 'simpleEvolution(' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1658:1: ( 'simpleEvolution(' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1659:1: 'simpleEvolution('
            {
             before(grammarAccess.getSimpleEvoSpanAccess().getSimpleEvolutionKeyword_0()); 
            match(input,26,FOLLOW_26_in_rule__SimpleEvoSpan__Group__0__Impl3523); 
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1672:1: rule__SimpleEvoSpan__Group__1 : rule__SimpleEvoSpan__Group__1__Impl rule__SimpleEvoSpan__Group__2 ;
    public final void rule__SimpleEvoSpan__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1676:1: ( rule__SimpleEvoSpan__Group__1__Impl rule__SimpleEvoSpan__Group__2 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1677:2: rule__SimpleEvoSpan__Group__1__Impl rule__SimpleEvoSpan__Group__2
            {
            pushFollow(FOLLOW_rule__SimpleEvoSpan__Group__1__Impl_in_rule__SimpleEvoSpan__Group__13554);
            rule__SimpleEvoSpan__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SimpleEvoSpan__Group__2_in_rule__SimpleEvoSpan__Group__13557);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1684:1: rule__SimpleEvoSpan__Group__1__Impl : ( ( rule__SimpleEvoSpan__LhsAssignment_1 ) ) ;
    public final void rule__SimpleEvoSpan__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1688:1: ( ( ( rule__SimpleEvoSpan__LhsAssignment_1 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1689:1: ( ( rule__SimpleEvoSpan__LhsAssignment_1 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1689:1: ( ( rule__SimpleEvoSpan__LhsAssignment_1 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1690:1: ( rule__SimpleEvoSpan__LhsAssignment_1 )
            {
             before(grammarAccess.getSimpleEvoSpanAccess().getLhsAssignment_1()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1691:1: ( rule__SimpleEvoSpan__LhsAssignment_1 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1691:2: rule__SimpleEvoSpan__LhsAssignment_1
            {
            pushFollow(FOLLOW_rule__SimpleEvoSpan__LhsAssignment_1_in_rule__SimpleEvoSpan__Group__1__Impl3584);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1701:1: rule__SimpleEvoSpan__Group__2 : rule__SimpleEvoSpan__Group__2__Impl rule__SimpleEvoSpan__Group__3 ;
    public final void rule__SimpleEvoSpan__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1705:1: ( rule__SimpleEvoSpan__Group__2__Impl rule__SimpleEvoSpan__Group__3 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1706:2: rule__SimpleEvoSpan__Group__2__Impl rule__SimpleEvoSpan__Group__3
            {
            pushFollow(FOLLOW_rule__SimpleEvoSpan__Group__2__Impl_in_rule__SimpleEvoSpan__Group__23614);
            rule__SimpleEvoSpan__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SimpleEvoSpan__Group__3_in_rule__SimpleEvoSpan__Group__23617);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1713:1: rule__SimpleEvoSpan__Group__2__Impl : ( '<-' ) ;
    public final void rule__SimpleEvoSpan__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1717:1: ( ( '<-' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1718:1: ( '<-' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1718:1: ( '<-' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1719:1: '<-'
            {
             before(grammarAccess.getSimpleEvoSpanAccess().getLessThanSignHyphenMinusKeyword_2()); 
            match(input,27,FOLLOW_27_in_rule__SimpleEvoSpan__Group__2__Impl3645); 
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1732:1: rule__SimpleEvoSpan__Group__3 : rule__SimpleEvoSpan__Group__3__Impl rule__SimpleEvoSpan__Group__4 ;
    public final void rule__SimpleEvoSpan__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1736:1: ( rule__SimpleEvoSpan__Group__3__Impl rule__SimpleEvoSpan__Group__4 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1737:2: rule__SimpleEvoSpan__Group__3__Impl rule__SimpleEvoSpan__Group__4
            {
            pushFollow(FOLLOW_rule__SimpleEvoSpan__Group__3__Impl_in_rule__SimpleEvoSpan__Group__33676);
            rule__SimpleEvoSpan__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SimpleEvoSpan__Group__4_in_rule__SimpleEvoSpan__Group__33679);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1744:1: rule__SimpleEvoSpan__Group__3__Impl : ( ( rule__SimpleEvoSpan__DiffAssignment_3 ) ) ;
    public final void rule__SimpleEvoSpan__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1748:1: ( ( ( rule__SimpleEvoSpan__DiffAssignment_3 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1749:1: ( ( rule__SimpleEvoSpan__DiffAssignment_3 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1749:1: ( ( rule__SimpleEvoSpan__DiffAssignment_3 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1750:1: ( rule__SimpleEvoSpan__DiffAssignment_3 )
            {
             before(grammarAccess.getSimpleEvoSpanAccess().getDiffAssignment_3()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1751:1: ( rule__SimpleEvoSpan__DiffAssignment_3 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1751:2: rule__SimpleEvoSpan__DiffAssignment_3
            {
            pushFollow(FOLLOW_rule__SimpleEvoSpan__DiffAssignment_3_in_rule__SimpleEvoSpan__Group__3__Impl3706);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1761:1: rule__SimpleEvoSpan__Group__4 : rule__SimpleEvoSpan__Group__4__Impl rule__SimpleEvoSpan__Group__5 ;
    public final void rule__SimpleEvoSpan__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1765:1: ( rule__SimpleEvoSpan__Group__4__Impl rule__SimpleEvoSpan__Group__5 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1766:2: rule__SimpleEvoSpan__Group__4__Impl rule__SimpleEvoSpan__Group__5
            {
            pushFollow(FOLLOW_rule__SimpleEvoSpan__Group__4__Impl_in_rule__SimpleEvoSpan__Group__43736);
            rule__SimpleEvoSpan__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SimpleEvoSpan__Group__5_in_rule__SimpleEvoSpan__Group__43739);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1773:1: rule__SimpleEvoSpan__Group__4__Impl : ( '->' ) ;
    public final void rule__SimpleEvoSpan__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1777:1: ( ( '->' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1778:1: ( '->' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1778:1: ( '->' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1779:1: '->'
            {
             before(grammarAccess.getSimpleEvoSpanAccess().getHyphenMinusGreaterThanSignKeyword_4()); 
            match(input,28,FOLLOW_28_in_rule__SimpleEvoSpan__Group__4__Impl3767); 
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1792:1: rule__SimpleEvoSpan__Group__5 : rule__SimpleEvoSpan__Group__5__Impl rule__SimpleEvoSpan__Group__6 ;
    public final void rule__SimpleEvoSpan__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1796:1: ( rule__SimpleEvoSpan__Group__5__Impl rule__SimpleEvoSpan__Group__6 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1797:2: rule__SimpleEvoSpan__Group__5__Impl rule__SimpleEvoSpan__Group__6
            {
            pushFollow(FOLLOW_rule__SimpleEvoSpan__Group__5__Impl_in_rule__SimpleEvoSpan__Group__53798);
            rule__SimpleEvoSpan__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SimpleEvoSpan__Group__6_in_rule__SimpleEvoSpan__Group__53801);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1804:1: rule__SimpleEvoSpan__Group__5__Impl : ( ( rule__SimpleEvoSpan__RhSAssignment_5 ) ) ;
    public final void rule__SimpleEvoSpan__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1808:1: ( ( ( rule__SimpleEvoSpan__RhSAssignment_5 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1809:1: ( ( rule__SimpleEvoSpan__RhSAssignment_5 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1809:1: ( ( rule__SimpleEvoSpan__RhSAssignment_5 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1810:1: ( rule__SimpleEvoSpan__RhSAssignment_5 )
            {
             before(grammarAccess.getSimpleEvoSpanAccess().getRhSAssignment_5()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1811:1: ( rule__SimpleEvoSpan__RhSAssignment_5 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1811:2: rule__SimpleEvoSpan__RhSAssignment_5
            {
            pushFollow(FOLLOW_rule__SimpleEvoSpan__RhSAssignment_5_in_rule__SimpleEvoSpan__Group__5__Impl3828);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1821:1: rule__SimpleEvoSpan__Group__6 : rule__SimpleEvoSpan__Group__6__Impl rule__SimpleEvoSpan__Group__7 ;
    public final void rule__SimpleEvoSpan__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1825:1: ( rule__SimpleEvoSpan__Group__6__Impl rule__SimpleEvoSpan__Group__7 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1826:2: rule__SimpleEvoSpan__Group__6__Impl rule__SimpleEvoSpan__Group__7
            {
            pushFollow(FOLLOW_rule__SimpleEvoSpan__Group__6__Impl_in_rule__SimpleEvoSpan__Group__63858);
            rule__SimpleEvoSpan__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SimpleEvoSpan__Group__7_in_rule__SimpleEvoSpan__Group__63861);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1833:1: rule__SimpleEvoSpan__Group__6__Impl : ( ',' ) ;
    public final void rule__SimpleEvoSpan__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1837:1: ( ( ',' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1838:1: ( ',' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1838:1: ( ',' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1839:1: ','
            {
             before(grammarAccess.getSimpleEvoSpanAccess().getCommaKeyword_6()); 
            match(input,29,FOLLOW_29_in_rule__SimpleEvoSpan__Group__6__Impl3889); 
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1852:1: rule__SimpleEvoSpan__Group__7 : rule__SimpleEvoSpan__Group__7__Impl rule__SimpleEvoSpan__Group__8 ;
    public final void rule__SimpleEvoSpan__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1856:1: ( rule__SimpleEvoSpan__Group__7__Impl rule__SimpleEvoSpan__Group__8 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1857:2: rule__SimpleEvoSpan__Group__7__Impl rule__SimpleEvoSpan__Group__8
            {
            pushFollow(FOLLOW_rule__SimpleEvoSpan__Group__7__Impl_in_rule__SimpleEvoSpan__Group__73920);
            rule__SimpleEvoSpan__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SimpleEvoSpan__Group__8_in_rule__SimpleEvoSpan__Group__73923);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1864:1: rule__SimpleEvoSpan__Group__7__Impl : ( ( rule__SimpleEvoSpan__TypeGraphAssignment_7 ) ) ;
    public final void rule__SimpleEvoSpan__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1868:1: ( ( ( rule__SimpleEvoSpan__TypeGraphAssignment_7 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1869:1: ( ( rule__SimpleEvoSpan__TypeGraphAssignment_7 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1869:1: ( ( rule__SimpleEvoSpan__TypeGraphAssignment_7 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1870:1: ( rule__SimpleEvoSpan__TypeGraphAssignment_7 )
            {
             before(grammarAccess.getSimpleEvoSpanAccess().getTypeGraphAssignment_7()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1871:1: ( rule__SimpleEvoSpan__TypeGraphAssignment_7 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1871:2: rule__SimpleEvoSpan__TypeGraphAssignment_7
            {
            pushFollow(FOLLOW_rule__SimpleEvoSpan__TypeGraphAssignment_7_in_rule__SimpleEvoSpan__Group__7__Impl3950);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1881:1: rule__SimpleEvoSpan__Group__8 : rule__SimpleEvoSpan__Group__8__Impl ;
    public final void rule__SimpleEvoSpan__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1885:1: ( rule__SimpleEvoSpan__Group__8__Impl )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1886:2: rule__SimpleEvoSpan__Group__8__Impl
            {
            pushFollow(FOLLOW_rule__SimpleEvoSpan__Group__8__Impl_in_rule__SimpleEvoSpan__Group__83980);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1892:1: rule__SimpleEvoSpan__Group__8__Impl : ( ')' ) ;
    public final void rule__SimpleEvoSpan__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1896:1: ( ( ')' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1897:1: ( ')' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1897:1: ( ')' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1898:1: ')'
            {
             before(grammarAccess.getSimpleEvoSpanAccess().getRightParenthesisKeyword_8()); 
            match(input,23,FOLLOW_23_in_rule__SimpleEvoSpan__Group__8__Impl4008); 
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1929:1: rule__SimpleEvoCospan__Group__0 : rule__SimpleEvoCospan__Group__0__Impl rule__SimpleEvoCospan__Group__1 ;
    public final void rule__SimpleEvoCospan__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1933:1: ( rule__SimpleEvoCospan__Group__0__Impl rule__SimpleEvoCospan__Group__1 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1934:2: rule__SimpleEvoCospan__Group__0__Impl rule__SimpleEvoCospan__Group__1
            {
            pushFollow(FOLLOW_rule__SimpleEvoCospan__Group__0__Impl_in_rule__SimpleEvoCospan__Group__04057);
            rule__SimpleEvoCospan__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SimpleEvoCospan__Group__1_in_rule__SimpleEvoCospan__Group__04060);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1941:1: rule__SimpleEvoCospan__Group__0__Impl : ( 'simpleEvolution(' ) ;
    public final void rule__SimpleEvoCospan__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1945:1: ( ( 'simpleEvolution(' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1946:1: ( 'simpleEvolution(' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1946:1: ( 'simpleEvolution(' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1947:1: 'simpleEvolution('
            {
             before(grammarAccess.getSimpleEvoCospanAccess().getSimpleEvolutionKeyword_0()); 
            match(input,26,FOLLOW_26_in_rule__SimpleEvoCospan__Group__0__Impl4088); 
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1960:1: rule__SimpleEvoCospan__Group__1 : rule__SimpleEvoCospan__Group__1__Impl rule__SimpleEvoCospan__Group__2 ;
    public final void rule__SimpleEvoCospan__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1964:1: ( rule__SimpleEvoCospan__Group__1__Impl rule__SimpleEvoCospan__Group__2 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1965:2: rule__SimpleEvoCospan__Group__1__Impl rule__SimpleEvoCospan__Group__2
            {
            pushFollow(FOLLOW_rule__SimpleEvoCospan__Group__1__Impl_in_rule__SimpleEvoCospan__Group__14119);
            rule__SimpleEvoCospan__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SimpleEvoCospan__Group__2_in_rule__SimpleEvoCospan__Group__14122);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1972:1: rule__SimpleEvoCospan__Group__1__Impl : ( ( rule__SimpleEvoCospan__LhsAssignment_1 ) ) ;
    public final void rule__SimpleEvoCospan__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1976:1: ( ( ( rule__SimpleEvoCospan__LhsAssignment_1 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1977:1: ( ( rule__SimpleEvoCospan__LhsAssignment_1 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1977:1: ( ( rule__SimpleEvoCospan__LhsAssignment_1 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1978:1: ( rule__SimpleEvoCospan__LhsAssignment_1 )
            {
             before(grammarAccess.getSimpleEvoCospanAccess().getLhsAssignment_1()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1979:1: ( rule__SimpleEvoCospan__LhsAssignment_1 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1979:2: rule__SimpleEvoCospan__LhsAssignment_1
            {
            pushFollow(FOLLOW_rule__SimpleEvoCospan__LhsAssignment_1_in_rule__SimpleEvoCospan__Group__1__Impl4149);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1989:1: rule__SimpleEvoCospan__Group__2 : rule__SimpleEvoCospan__Group__2__Impl rule__SimpleEvoCospan__Group__3 ;
    public final void rule__SimpleEvoCospan__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1993:1: ( rule__SimpleEvoCospan__Group__2__Impl rule__SimpleEvoCospan__Group__3 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1994:2: rule__SimpleEvoCospan__Group__2__Impl rule__SimpleEvoCospan__Group__3
            {
            pushFollow(FOLLOW_rule__SimpleEvoCospan__Group__2__Impl_in_rule__SimpleEvoCospan__Group__24179);
            rule__SimpleEvoCospan__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SimpleEvoCospan__Group__3_in_rule__SimpleEvoCospan__Group__24182);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2001:1: rule__SimpleEvoCospan__Group__2__Impl : ( '->' ) ;
    public final void rule__SimpleEvoCospan__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2005:1: ( ( '->' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2006:1: ( '->' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2006:1: ( '->' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2007:1: '->'
            {
             before(grammarAccess.getSimpleEvoCospanAccess().getHyphenMinusGreaterThanSignKeyword_2()); 
            match(input,28,FOLLOW_28_in_rule__SimpleEvoCospan__Group__2__Impl4210); 
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2020:1: rule__SimpleEvoCospan__Group__3 : rule__SimpleEvoCospan__Group__3__Impl rule__SimpleEvoCospan__Group__4 ;
    public final void rule__SimpleEvoCospan__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2024:1: ( rule__SimpleEvoCospan__Group__3__Impl rule__SimpleEvoCospan__Group__4 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2025:2: rule__SimpleEvoCospan__Group__3__Impl rule__SimpleEvoCospan__Group__4
            {
            pushFollow(FOLLOW_rule__SimpleEvoCospan__Group__3__Impl_in_rule__SimpleEvoCospan__Group__34241);
            rule__SimpleEvoCospan__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SimpleEvoCospan__Group__4_in_rule__SimpleEvoCospan__Group__34244);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2032:1: rule__SimpleEvoCospan__Group__3__Impl : ( ( rule__SimpleEvoCospan__JointAssignment_3 ) ) ;
    public final void rule__SimpleEvoCospan__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2036:1: ( ( ( rule__SimpleEvoCospan__JointAssignment_3 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2037:1: ( ( rule__SimpleEvoCospan__JointAssignment_3 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2037:1: ( ( rule__SimpleEvoCospan__JointAssignment_3 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2038:1: ( rule__SimpleEvoCospan__JointAssignment_3 )
            {
             before(grammarAccess.getSimpleEvoCospanAccess().getJointAssignment_3()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2039:1: ( rule__SimpleEvoCospan__JointAssignment_3 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2039:2: rule__SimpleEvoCospan__JointAssignment_3
            {
            pushFollow(FOLLOW_rule__SimpleEvoCospan__JointAssignment_3_in_rule__SimpleEvoCospan__Group__3__Impl4271);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2049:1: rule__SimpleEvoCospan__Group__4 : rule__SimpleEvoCospan__Group__4__Impl rule__SimpleEvoCospan__Group__5 ;
    public final void rule__SimpleEvoCospan__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2053:1: ( rule__SimpleEvoCospan__Group__4__Impl rule__SimpleEvoCospan__Group__5 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2054:2: rule__SimpleEvoCospan__Group__4__Impl rule__SimpleEvoCospan__Group__5
            {
            pushFollow(FOLLOW_rule__SimpleEvoCospan__Group__4__Impl_in_rule__SimpleEvoCospan__Group__44301);
            rule__SimpleEvoCospan__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SimpleEvoCospan__Group__5_in_rule__SimpleEvoCospan__Group__44304);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2061:1: rule__SimpleEvoCospan__Group__4__Impl : ( '<-' ) ;
    public final void rule__SimpleEvoCospan__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2065:1: ( ( '<-' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2066:1: ( '<-' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2066:1: ( '<-' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2067:1: '<-'
            {
             before(grammarAccess.getSimpleEvoCospanAccess().getLessThanSignHyphenMinusKeyword_4()); 
            match(input,27,FOLLOW_27_in_rule__SimpleEvoCospan__Group__4__Impl4332); 
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2080:1: rule__SimpleEvoCospan__Group__5 : rule__SimpleEvoCospan__Group__5__Impl rule__SimpleEvoCospan__Group__6 ;
    public final void rule__SimpleEvoCospan__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2084:1: ( rule__SimpleEvoCospan__Group__5__Impl rule__SimpleEvoCospan__Group__6 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2085:2: rule__SimpleEvoCospan__Group__5__Impl rule__SimpleEvoCospan__Group__6
            {
            pushFollow(FOLLOW_rule__SimpleEvoCospan__Group__5__Impl_in_rule__SimpleEvoCospan__Group__54363);
            rule__SimpleEvoCospan__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SimpleEvoCospan__Group__6_in_rule__SimpleEvoCospan__Group__54366);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2092:1: rule__SimpleEvoCospan__Group__5__Impl : ( ( rule__SimpleEvoCospan__RhsAssignment_5 ) ) ;
    public final void rule__SimpleEvoCospan__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2096:1: ( ( ( rule__SimpleEvoCospan__RhsAssignment_5 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2097:1: ( ( rule__SimpleEvoCospan__RhsAssignment_5 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2097:1: ( ( rule__SimpleEvoCospan__RhsAssignment_5 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2098:1: ( rule__SimpleEvoCospan__RhsAssignment_5 )
            {
             before(grammarAccess.getSimpleEvoCospanAccess().getRhsAssignment_5()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2099:1: ( rule__SimpleEvoCospan__RhsAssignment_5 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2099:2: rule__SimpleEvoCospan__RhsAssignment_5
            {
            pushFollow(FOLLOW_rule__SimpleEvoCospan__RhsAssignment_5_in_rule__SimpleEvoCospan__Group__5__Impl4393);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2109:1: rule__SimpleEvoCospan__Group__6 : rule__SimpleEvoCospan__Group__6__Impl rule__SimpleEvoCospan__Group__7 ;
    public final void rule__SimpleEvoCospan__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2113:1: ( rule__SimpleEvoCospan__Group__6__Impl rule__SimpleEvoCospan__Group__7 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2114:2: rule__SimpleEvoCospan__Group__6__Impl rule__SimpleEvoCospan__Group__7
            {
            pushFollow(FOLLOW_rule__SimpleEvoCospan__Group__6__Impl_in_rule__SimpleEvoCospan__Group__64423);
            rule__SimpleEvoCospan__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SimpleEvoCospan__Group__7_in_rule__SimpleEvoCospan__Group__64426);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2121:1: rule__SimpleEvoCospan__Group__6__Impl : ( ',' ) ;
    public final void rule__SimpleEvoCospan__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2125:1: ( ( ',' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2126:1: ( ',' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2126:1: ( ',' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2127:1: ','
            {
             before(grammarAccess.getSimpleEvoCospanAccess().getCommaKeyword_6()); 
            match(input,29,FOLLOW_29_in_rule__SimpleEvoCospan__Group__6__Impl4454); 
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2140:1: rule__SimpleEvoCospan__Group__7 : rule__SimpleEvoCospan__Group__7__Impl rule__SimpleEvoCospan__Group__8 ;
    public final void rule__SimpleEvoCospan__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2144:1: ( rule__SimpleEvoCospan__Group__7__Impl rule__SimpleEvoCospan__Group__8 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2145:2: rule__SimpleEvoCospan__Group__7__Impl rule__SimpleEvoCospan__Group__8
            {
            pushFollow(FOLLOW_rule__SimpleEvoCospan__Group__7__Impl_in_rule__SimpleEvoCospan__Group__74485);
            rule__SimpleEvoCospan__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SimpleEvoCospan__Group__8_in_rule__SimpleEvoCospan__Group__74488);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2152:1: rule__SimpleEvoCospan__Group__7__Impl : ( ( rule__SimpleEvoCospan__TypeGraphAssignment_7 ) ) ;
    public final void rule__SimpleEvoCospan__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2156:1: ( ( ( rule__SimpleEvoCospan__TypeGraphAssignment_7 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2157:1: ( ( rule__SimpleEvoCospan__TypeGraphAssignment_7 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2157:1: ( ( rule__SimpleEvoCospan__TypeGraphAssignment_7 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2158:1: ( rule__SimpleEvoCospan__TypeGraphAssignment_7 )
            {
             before(grammarAccess.getSimpleEvoCospanAccess().getTypeGraphAssignment_7()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2159:1: ( rule__SimpleEvoCospan__TypeGraphAssignment_7 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2159:2: rule__SimpleEvoCospan__TypeGraphAssignment_7
            {
            pushFollow(FOLLOW_rule__SimpleEvoCospan__TypeGraphAssignment_7_in_rule__SimpleEvoCospan__Group__7__Impl4515);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2169:1: rule__SimpleEvoCospan__Group__8 : rule__SimpleEvoCospan__Group__8__Impl ;
    public final void rule__SimpleEvoCospan__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2173:1: ( rule__SimpleEvoCospan__Group__8__Impl )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2174:2: rule__SimpleEvoCospan__Group__8__Impl
            {
            pushFollow(FOLLOW_rule__SimpleEvoCospan__Group__8__Impl_in_rule__SimpleEvoCospan__Group__84545);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2180:1: rule__SimpleEvoCospan__Group__8__Impl : ( ')' ) ;
    public final void rule__SimpleEvoCospan__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2184:1: ( ( ')' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2185:1: ( ')' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2185:1: ( ')' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2186:1: ')'
            {
             before(grammarAccess.getSimpleEvoCospanAccess().getRightParenthesisKeyword_8()); 
            match(input,23,FOLLOW_23_in_rule__SimpleEvoCospan__Group__8__Impl4573); 
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2217:1: rule__EvoSpan__Group__0 : rule__EvoSpan__Group__0__Impl rule__EvoSpan__Group__1 ;
    public final void rule__EvoSpan__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2221:1: ( rule__EvoSpan__Group__0__Impl rule__EvoSpan__Group__1 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2222:2: rule__EvoSpan__Group__0__Impl rule__EvoSpan__Group__1
            {
            pushFollow(FOLLOW_rule__EvoSpan__Group__0__Impl_in_rule__EvoSpan__Group__04622);
            rule__EvoSpan__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__EvoSpan__Group__1_in_rule__EvoSpan__Group__04625);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2229:1: rule__EvoSpan__Group__0__Impl : ( 'evolution(' ) ;
    public final void rule__EvoSpan__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2233:1: ( ( 'evolution(' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2234:1: ( 'evolution(' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2234:1: ( 'evolution(' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2235:1: 'evolution('
            {
             before(grammarAccess.getEvoSpanAccess().getEvolutionKeyword_0()); 
            match(input,30,FOLLOW_30_in_rule__EvoSpan__Group__0__Impl4653); 
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2248:1: rule__EvoSpan__Group__1 : rule__EvoSpan__Group__1__Impl rule__EvoSpan__Group__2 ;
    public final void rule__EvoSpan__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2252:1: ( rule__EvoSpan__Group__1__Impl rule__EvoSpan__Group__2 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2253:2: rule__EvoSpan__Group__1__Impl rule__EvoSpan__Group__2
            {
            pushFollow(FOLLOW_rule__EvoSpan__Group__1__Impl_in_rule__EvoSpan__Group__14684);
            rule__EvoSpan__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__EvoSpan__Group__2_in_rule__EvoSpan__Group__14687);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2260:1: rule__EvoSpan__Group__1__Impl : ( ( rule__EvoSpan__LhsAssignment_1 ) ) ;
    public final void rule__EvoSpan__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2264:1: ( ( ( rule__EvoSpan__LhsAssignment_1 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2265:1: ( ( rule__EvoSpan__LhsAssignment_1 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2265:1: ( ( rule__EvoSpan__LhsAssignment_1 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2266:1: ( rule__EvoSpan__LhsAssignment_1 )
            {
             before(grammarAccess.getEvoSpanAccess().getLhsAssignment_1()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2267:1: ( rule__EvoSpan__LhsAssignment_1 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2267:2: rule__EvoSpan__LhsAssignment_1
            {
            pushFollow(FOLLOW_rule__EvoSpan__LhsAssignment_1_in_rule__EvoSpan__Group__1__Impl4714);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2277:1: rule__EvoSpan__Group__2 : rule__EvoSpan__Group__2__Impl rule__EvoSpan__Group__3 ;
    public final void rule__EvoSpan__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2281:1: ( rule__EvoSpan__Group__2__Impl rule__EvoSpan__Group__3 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2282:2: rule__EvoSpan__Group__2__Impl rule__EvoSpan__Group__3
            {
            pushFollow(FOLLOW_rule__EvoSpan__Group__2__Impl_in_rule__EvoSpan__Group__24744);
            rule__EvoSpan__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__EvoSpan__Group__3_in_rule__EvoSpan__Group__24747);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2289:1: rule__EvoSpan__Group__2__Impl : ( '<->' ) ;
    public final void rule__EvoSpan__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2293:1: ( ( '<->' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2294:1: ( '<->' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2294:1: ( '<->' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2295:1: '<->'
            {
             before(grammarAccess.getEvoSpanAccess().getLessThanSignHyphenMinusGreaterThanSignKeyword_2()); 
            match(input,31,FOLLOW_31_in_rule__EvoSpan__Group__2__Impl4775); 
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2308:1: rule__EvoSpan__Group__3 : rule__EvoSpan__Group__3__Impl rule__EvoSpan__Group__4 ;
    public final void rule__EvoSpan__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2312:1: ( rule__EvoSpan__Group__3__Impl rule__EvoSpan__Group__4 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2313:2: rule__EvoSpan__Group__3__Impl rule__EvoSpan__Group__4
            {
            pushFollow(FOLLOW_rule__EvoSpan__Group__3__Impl_in_rule__EvoSpan__Group__34806);
            rule__EvoSpan__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__EvoSpan__Group__4_in_rule__EvoSpan__Group__34809);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2320:1: rule__EvoSpan__Group__3__Impl : ( ( rule__EvoSpan__RhsAssignment_3 ) ) ;
    public final void rule__EvoSpan__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2324:1: ( ( ( rule__EvoSpan__RhsAssignment_3 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2325:1: ( ( rule__EvoSpan__RhsAssignment_3 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2325:1: ( ( rule__EvoSpan__RhsAssignment_3 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2326:1: ( rule__EvoSpan__RhsAssignment_3 )
            {
             before(grammarAccess.getEvoSpanAccess().getRhsAssignment_3()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2327:1: ( rule__EvoSpan__RhsAssignment_3 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2327:2: rule__EvoSpan__RhsAssignment_3
            {
            pushFollow(FOLLOW_rule__EvoSpan__RhsAssignment_3_in_rule__EvoSpan__Group__3__Impl4836);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2337:1: rule__EvoSpan__Group__4 : rule__EvoSpan__Group__4__Impl rule__EvoSpan__Group__5 ;
    public final void rule__EvoSpan__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2341:1: ( rule__EvoSpan__Group__4__Impl rule__EvoSpan__Group__5 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2342:2: rule__EvoSpan__Group__4__Impl rule__EvoSpan__Group__5
            {
            pushFollow(FOLLOW_rule__EvoSpan__Group__4__Impl_in_rule__EvoSpan__Group__44866);
            rule__EvoSpan__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__EvoSpan__Group__5_in_rule__EvoSpan__Group__44869);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2349:1: rule__EvoSpan__Group__4__Impl : ( ',' ) ;
    public final void rule__EvoSpan__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2353:1: ( ( ',' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2354:1: ( ',' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2354:1: ( ',' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2355:1: ','
            {
             before(grammarAccess.getEvoSpanAccess().getCommaKeyword_4()); 
            match(input,29,FOLLOW_29_in_rule__EvoSpan__Group__4__Impl4897); 
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2368:1: rule__EvoSpan__Group__5 : rule__EvoSpan__Group__5__Impl rule__EvoSpan__Group__6 ;
    public final void rule__EvoSpan__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2372:1: ( rule__EvoSpan__Group__5__Impl rule__EvoSpan__Group__6 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2373:2: rule__EvoSpan__Group__5__Impl rule__EvoSpan__Group__6
            {
            pushFollow(FOLLOW_rule__EvoSpan__Group__5__Impl_in_rule__EvoSpan__Group__54928);
            rule__EvoSpan__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__EvoSpan__Group__6_in_rule__EvoSpan__Group__54931);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2380:1: rule__EvoSpan__Group__5__Impl : ( ( rule__EvoSpan__TypeGraphAssignment_5 ) ) ;
    public final void rule__EvoSpan__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2384:1: ( ( ( rule__EvoSpan__TypeGraphAssignment_5 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2385:1: ( ( rule__EvoSpan__TypeGraphAssignment_5 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2385:1: ( ( rule__EvoSpan__TypeGraphAssignment_5 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2386:1: ( rule__EvoSpan__TypeGraphAssignment_5 )
            {
             before(grammarAccess.getEvoSpanAccess().getTypeGraphAssignment_5()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2387:1: ( rule__EvoSpan__TypeGraphAssignment_5 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2387:2: rule__EvoSpan__TypeGraphAssignment_5
            {
            pushFollow(FOLLOW_rule__EvoSpan__TypeGraphAssignment_5_in_rule__EvoSpan__Group__5__Impl4958);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2397:1: rule__EvoSpan__Group__6 : rule__EvoSpan__Group__6__Impl ;
    public final void rule__EvoSpan__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2401:1: ( rule__EvoSpan__Group__6__Impl )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2402:2: rule__EvoSpan__Group__6__Impl
            {
            pushFollow(FOLLOW_rule__EvoSpan__Group__6__Impl_in_rule__EvoSpan__Group__64988);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2408:1: rule__EvoSpan__Group__6__Impl : ( ')' ) ;
    public final void rule__EvoSpan__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2412:1: ( ( ')' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2413:1: ( ')' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2413:1: ( ')' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2414:1: ')'
            {
             before(grammarAccess.getEvoSpanAccess().getRightParenthesisKeyword_6()); 
            match(input,23,FOLLOW_23_in_rule__EvoSpan__Group__6__Impl5016); 
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2441:1: rule__EvoCospan__Group__0 : rule__EvoCospan__Group__0__Impl rule__EvoCospan__Group__1 ;
    public final void rule__EvoCospan__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2445:1: ( rule__EvoCospan__Group__0__Impl rule__EvoCospan__Group__1 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2446:2: rule__EvoCospan__Group__0__Impl rule__EvoCospan__Group__1
            {
            pushFollow(FOLLOW_rule__EvoCospan__Group__0__Impl_in_rule__EvoCospan__Group__05061);
            rule__EvoCospan__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__EvoCospan__Group__1_in_rule__EvoCospan__Group__05064);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2453:1: rule__EvoCospan__Group__0__Impl : ( 'evolution(' ) ;
    public final void rule__EvoCospan__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2457:1: ( ( 'evolution(' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2458:1: ( 'evolution(' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2458:1: ( 'evolution(' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2459:1: 'evolution('
            {
             before(grammarAccess.getEvoCospanAccess().getEvolutionKeyword_0()); 
            match(input,30,FOLLOW_30_in_rule__EvoCospan__Group__0__Impl5092); 
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2472:1: rule__EvoCospan__Group__1 : rule__EvoCospan__Group__1__Impl rule__EvoCospan__Group__2 ;
    public final void rule__EvoCospan__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2476:1: ( rule__EvoCospan__Group__1__Impl rule__EvoCospan__Group__2 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2477:2: rule__EvoCospan__Group__1__Impl rule__EvoCospan__Group__2
            {
            pushFollow(FOLLOW_rule__EvoCospan__Group__1__Impl_in_rule__EvoCospan__Group__15123);
            rule__EvoCospan__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__EvoCospan__Group__2_in_rule__EvoCospan__Group__15126);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2484:1: rule__EvoCospan__Group__1__Impl : ( ( rule__EvoCospan__LhsAssignment_1 ) ) ;
    public final void rule__EvoCospan__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2488:1: ( ( ( rule__EvoCospan__LhsAssignment_1 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2489:1: ( ( rule__EvoCospan__LhsAssignment_1 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2489:1: ( ( rule__EvoCospan__LhsAssignment_1 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2490:1: ( rule__EvoCospan__LhsAssignment_1 )
            {
             before(grammarAccess.getEvoCospanAccess().getLhsAssignment_1()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2491:1: ( rule__EvoCospan__LhsAssignment_1 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2491:2: rule__EvoCospan__LhsAssignment_1
            {
            pushFollow(FOLLOW_rule__EvoCospan__LhsAssignment_1_in_rule__EvoCospan__Group__1__Impl5153);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2501:1: rule__EvoCospan__Group__2 : rule__EvoCospan__Group__2__Impl rule__EvoCospan__Group__3 ;
    public final void rule__EvoCospan__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2505:1: ( rule__EvoCospan__Group__2__Impl rule__EvoCospan__Group__3 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2506:2: rule__EvoCospan__Group__2__Impl rule__EvoCospan__Group__3
            {
            pushFollow(FOLLOW_rule__EvoCospan__Group__2__Impl_in_rule__EvoCospan__Group__25183);
            rule__EvoCospan__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__EvoCospan__Group__3_in_rule__EvoCospan__Group__25186);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2513:1: rule__EvoCospan__Group__2__Impl : ( '-><-' ) ;
    public final void rule__EvoCospan__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2517:1: ( ( '-><-' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2518:1: ( '-><-' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2518:1: ( '-><-' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2519:1: '-><-'
            {
             before(grammarAccess.getEvoCospanAccess().getHyphenMinusGreaterThanSignLessThanSignHyphenMinusKeyword_2()); 
            match(input,32,FOLLOW_32_in_rule__EvoCospan__Group__2__Impl5214); 
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2532:1: rule__EvoCospan__Group__3 : rule__EvoCospan__Group__3__Impl rule__EvoCospan__Group__4 ;
    public final void rule__EvoCospan__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2536:1: ( rule__EvoCospan__Group__3__Impl rule__EvoCospan__Group__4 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2537:2: rule__EvoCospan__Group__3__Impl rule__EvoCospan__Group__4
            {
            pushFollow(FOLLOW_rule__EvoCospan__Group__3__Impl_in_rule__EvoCospan__Group__35245);
            rule__EvoCospan__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__EvoCospan__Group__4_in_rule__EvoCospan__Group__35248);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2544:1: rule__EvoCospan__Group__3__Impl : ( ( rule__EvoCospan__RhsAssignment_3 ) ) ;
    public final void rule__EvoCospan__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2548:1: ( ( ( rule__EvoCospan__RhsAssignment_3 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2549:1: ( ( rule__EvoCospan__RhsAssignment_3 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2549:1: ( ( rule__EvoCospan__RhsAssignment_3 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2550:1: ( rule__EvoCospan__RhsAssignment_3 )
            {
             before(grammarAccess.getEvoCospanAccess().getRhsAssignment_3()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2551:1: ( rule__EvoCospan__RhsAssignment_3 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2551:2: rule__EvoCospan__RhsAssignment_3
            {
            pushFollow(FOLLOW_rule__EvoCospan__RhsAssignment_3_in_rule__EvoCospan__Group__3__Impl5275);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2561:1: rule__EvoCospan__Group__4 : rule__EvoCospan__Group__4__Impl rule__EvoCospan__Group__5 ;
    public final void rule__EvoCospan__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2565:1: ( rule__EvoCospan__Group__4__Impl rule__EvoCospan__Group__5 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2566:2: rule__EvoCospan__Group__4__Impl rule__EvoCospan__Group__5
            {
            pushFollow(FOLLOW_rule__EvoCospan__Group__4__Impl_in_rule__EvoCospan__Group__45305);
            rule__EvoCospan__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__EvoCospan__Group__5_in_rule__EvoCospan__Group__45308);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2573:1: rule__EvoCospan__Group__4__Impl : ( ',' ) ;
    public final void rule__EvoCospan__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2577:1: ( ( ',' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2578:1: ( ',' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2578:1: ( ',' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2579:1: ','
            {
             before(grammarAccess.getEvoCospanAccess().getCommaKeyword_4()); 
            match(input,29,FOLLOW_29_in_rule__EvoCospan__Group__4__Impl5336); 
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2592:1: rule__EvoCospan__Group__5 : rule__EvoCospan__Group__5__Impl rule__EvoCospan__Group__6 ;
    public final void rule__EvoCospan__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2596:1: ( rule__EvoCospan__Group__5__Impl rule__EvoCospan__Group__6 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2597:2: rule__EvoCospan__Group__5__Impl rule__EvoCospan__Group__6
            {
            pushFollow(FOLLOW_rule__EvoCospan__Group__5__Impl_in_rule__EvoCospan__Group__55367);
            rule__EvoCospan__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__EvoCospan__Group__6_in_rule__EvoCospan__Group__55370);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2604:1: rule__EvoCospan__Group__5__Impl : ( ( rule__EvoCospan__TypeGraphAssignment_5 ) ) ;
    public final void rule__EvoCospan__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2608:1: ( ( ( rule__EvoCospan__TypeGraphAssignment_5 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2609:1: ( ( rule__EvoCospan__TypeGraphAssignment_5 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2609:1: ( ( rule__EvoCospan__TypeGraphAssignment_5 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2610:1: ( rule__EvoCospan__TypeGraphAssignment_5 )
            {
             before(grammarAccess.getEvoCospanAccess().getTypeGraphAssignment_5()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2611:1: ( rule__EvoCospan__TypeGraphAssignment_5 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2611:2: rule__EvoCospan__TypeGraphAssignment_5
            {
            pushFollow(FOLLOW_rule__EvoCospan__TypeGraphAssignment_5_in_rule__EvoCospan__Group__5__Impl5397);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2621:1: rule__EvoCospan__Group__6 : rule__EvoCospan__Group__6__Impl ;
    public final void rule__EvoCospan__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2625:1: ( rule__EvoCospan__Group__6__Impl )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2626:2: rule__EvoCospan__Group__6__Impl
            {
            pushFollow(FOLLOW_rule__EvoCospan__Group__6__Impl_in_rule__EvoCospan__Group__65427);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2632:1: rule__EvoCospan__Group__6__Impl : ( ')' ) ;
    public final void rule__EvoCospan__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2636:1: ( ( ')' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2637:1: ( ')' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2637:1: ( ')' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2638:1: ')'
            {
             before(grammarAccess.getEvoCospanAccess().getRightParenthesisKeyword_6()); 
            match(input,23,FOLLOW_23_in_rule__EvoCospan__Group__6__Impl5455); 
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


    // $ANTLR start "rule__InstanceSpecification__Group__0"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2665:1: rule__InstanceSpecification__Group__0 : rule__InstanceSpecification__Group__0__Impl rule__InstanceSpecification__Group__1 ;
    public final void rule__InstanceSpecification__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2669:1: ( rule__InstanceSpecification__Group__0__Impl rule__InstanceSpecification__Group__1 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2670:2: rule__InstanceSpecification__Group__0__Impl rule__InstanceSpecification__Group__1
            {
            pushFollow(FOLLOW_rule__InstanceSpecification__Group__0__Impl_in_rule__InstanceSpecification__Group__05500);
            rule__InstanceSpecification__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__InstanceSpecification__Group__1_in_rule__InstanceSpecification__Group__05503);
            rule__InstanceSpecification__Group__1();

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
    // $ANTLR end "rule__InstanceSpecification__Group__0"


    // $ANTLR start "rule__InstanceSpecification__Group__0__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2677:1: rule__InstanceSpecification__Group__0__Impl : ( ( rule__InstanceSpecification__IdAssignment_0 ) ) ;
    public final void rule__InstanceSpecification__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2681:1: ( ( ( rule__InstanceSpecification__IdAssignment_0 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2682:1: ( ( rule__InstanceSpecification__IdAssignment_0 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2682:1: ( ( rule__InstanceSpecification__IdAssignment_0 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2683:1: ( rule__InstanceSpecification__IdAssignment_0 )
            {
             before(grammarAccess.getInstanceSpecificationAccess().getIdAssignment_0()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2684:1: ( rule__InstanceSpecification__IdAssignment_0 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2684:2: rule__InstanceSpecification__IdAssignment_0
            {
            pushFollow(FOLLOW_rule__InstanceSpecification__IdAssignment_0_in_rule__InstanceSpecification__Group__0__Impl5530);
            rule__InstanceSpecification__IdAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getInstanceSpecificationAccess().getIdAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InstanceSpecification__Group__0__Impl"


    // $ANTLR start "rule__InstanceSpecification__Group__1"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2694:1: rule__InstanceSpecification__Group__1 : rule__InstanceSpecification__Group__1__Impl rule__InstanceSpecification__Group__2 ;
    public final void rule__InstanceSpecification__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2698:1: ( rule__InstanceSpecification__Group__1__Impl rule__InstanceSpecification__Group__2 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2699:2: rule__InstanceSpecification__Group__1__Impl rule__InstanceSpecification__Group__2
            {
            pushFollow(FOLLOW_rule__InstanceSpecification__Group__1__Impl_in_rule__InstanceSpecification__Group__15560);
            rule__InstanceSpecification__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__InstanceSpecification__Group__2_in_rule__InstanceSpecification__Group__15563);
            rule__InstanceSpecification__Group__2();

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
    // $ANTLR end "rule__InstanceSpecification__Group__1"


    // $ANTLR start "rule__InstanceSpecification__Group__1__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2706:1: rule__InstanceSpecification__Group__1__Impl : ( ':=' ) ;
    public final void rule__InstanceSpecification__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2710:1: ( ( ':=' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2711:1: ( ':=' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2711:1: ( ':=' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2712:1: ':='
            {
             before(grammarAccess.getInstanceSpecificationAccess().getColonEqualsSignKeyword_1()); 
            match(input,33,FOLLOW_33_in_rule__InstanceSpecification__Group__1__Impl5591); 
             after(grammarAccess.getInstanceSpecificationAccess().getColonEqualsSignKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InstanceSpecification__Group__1__Impl"


    // $ANTLR start "rule__InstanceSpecification__Group__2"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2725:1: rule__InstanceSpecification__Group__2 : rule__InstanceSpecification__Group__2__Impl rule__InstanceSpecification__Group__3 ;
    public final void rule__InstanceSpecification__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2729:1: ( rule__InstanceSpecification__Group__2__Impl rule__InstanceSpecification__Group__3 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2730:2: rule__InstanceSpecification__Group__2__Impl rule__InstanceSpecification__Group__3
            {
            pushFollow(FOLLOW_rule__InstanceSpecification__Group__2__Impl_in_rule__InstanceSpecification__Group__25622);
            rule__InstanceSpecification__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__InstanceSpecification__Group__3_in_rule__InstanceSpecification__Group__25625);
            rule__InstanceSpecification__Group__3();

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
    // $ANTLR end "rule__InstanceSpecification__Group__2"


    // $ANTLR start "rule__InstanceSpecification__Group__2__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2737:1: rule__InstanceSpecification__Group__2__Impl : ( 'ISpec' ) ;
    public final void rule__InstanceSpecification__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2741:1: ( ( 'ISpec' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2742:1: ( 'ISpec' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2742:1: ( 'ISpec' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2743:1: 'ISpec'
            {
             before(grammarAccess.getInstanceSpecificationAccess().getISpecKeyword_2()); 
            match(input,34,FOLLOW_34_in_rule__InstanceSpecification__Group__2__Impl5653); 
             after(grammarAccess.getInstanceSpecificationAccess().getISpecKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InstanceSpecification__Group__2__Impl"


    // $ANTLR start "rule__InstanceSpecification__Group__3"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2756:1: rule__InstanceSpecification__Group__3 : rule__InstanceSpecification__Group__3__Impl rule__InstanceSpecification__Group__4 ;
    public final void rule__InstanceSpecification__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2760:1: ( rule__InstanceSpecification__Group__3__Impl rule__InstanceSpecification__Group__4 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2761:2: rule__InstanceSpecification__Group__3__Impl rule__InstanceSpecification__Group__4
            {
            pushFollow(FOLLOW_rule__InstanceSpecification__Group__3__Impl_in_rule__InstanceSpecification__Group__35684);
            rule__InstanceSpecification__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__InstanceSpecification__Group__4_in_rule__InstanceSpecification__Group__35687);
            rule__InstanceSpecification__Group__4();

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
    // $ANTLR end "rule__InstanceSpecification__Group__3"


    // $ANTLR start "rule__InstanceSpecification__Group__3__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2768:1: rule__InstanceSpecification__Group__3__Impl : ( '<' ) ;
    public final void rule__InstanceSpecification__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2772:1: ( ( '<' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2773:1: ( '<' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2773:1: ( '<' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2774:1: '<'
            {
             before(grammarAccess.getInstanceSpecificationAccess().getLessThanSignKeyword_3()); 
            match(input,35,FOLLOW_35_in_rule__InstanceSpecification__Group__3__Impl5715); 
             after(grammarAccess.getInstanceSpecificationAccess().getLessThanSignKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InstanceSpecification__Group__3__Impl"


    // $ANTLR start "rule__InstanceSpecification__Group__4"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2787:1: rule__InstanceSpecification__Group__4 : rule__InstanceSpecification__Group__4__Impl rule__InstanceSpecification__Group__5 ;
    public final void rule__InstanceSpecification__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2791:1: ( rule__InstanceSpecification__Group__4__Impl rule__InstanceSpecification__Group__5 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2792:2: rule__InstanceSpecification__Group__4__Impl rule__InstanceSpecification__Group__5
            {
            pushFollow(FOLLOW_rule__InstanceSpecification__Group__4__Impl_in_rule__InstanceSpecification__Group__45746);
            rule__InstanceSpecification__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__InstanceSpecification__Group__5_in_rule__InstanceSpecification__Group__45749);
            rule__InstanceSpecification__Group__5();

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
    // $ANTLR end "rule__InstanceSpecification__Group__4"


    // $ANTLR start "rule__InstanceSpecification__Group__4__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2799:1: rule__InstanceSpecification__Group__4__Impl : ( ( rule__InstanceSpecification__ModelAssignment_4 ) ) ;
    public final void rule__InstanceSpecification__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2803:1: ( ( ( rule__InstanceSpecification__ModelAssignment_4 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2804:1: ( ( rule__InstanceSpecification__ModelAssignment_4 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2804:1: ( ( rule__InstanceSpecification__ModelAssignment_4 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2805:1: ( rule__InstanceSpecification__ModelAssignment_4 )
            {
             before(grammarAccess.getInstanceSpecificationAccess().getModelAssignment_4()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2806:1: ( rule__InstanceSpecification__ModelAssignment_4 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2806:2: rule__InstanceSpecification__ModelAssignment_4
            {
            pushFollow(FOLLOW_rule__InstanceSpecification__ModelAssignment_4_in_rule__InstanceSpecification__Group__4__Impl5776);
            rule__InstanceSpecification__ModelAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getInstanceSpecificationAccess().getModelAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InstanceSpecification__Group__4__Impl"


    // $ANTLR start "rule__InstanceSpecification__Group__5"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2816:1: rule__InstanceSpecification__Group__5 : rule__InstanceSpecification__Group__5__Impl rule__InstanceSpecification__Group__6 ;
    public final void rule__InstanceSpecification__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2820:1: ( rule__InstanceSpecification__Group__5__Impl rule__InstanceSpecification__Group__6 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2821:2: rule__InstanceSpecification__Group__5__Impl rule__InstanceSpecification__Group__6
            {
            pushFollow(FOLLOW_rule__InstanceSpecification__Group__5__Impl_in_rule__InstanceSpecification__Group__55806);
            rule__InstanceSpecification__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__InstanceSpecification__Group__6_in_rule__InstanceSpecification__Group__55809);
            rule__InstanceSpecification__Group__6();

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
    // $ANTLR end "rule__InstanceSpecification__Group__5"


    // $ANTLR start "rule__InstanceSpecification__Group__5__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2828:1: rule__InstanceSpecification__Group__5__Impl : ( ',' ) ;
    public final void rule__InstanceSpecification__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2832:1: ( ( ',' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2833:1: ( ',' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2833:1: ( ',' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2834:1: ','
            {
             before(grammarAccess.getInstanceSpecificationAccess().getCommaKeyword_5()); 
            match(input,29,FOLLOW_29_in_rule__InstanceSpecification__Group__5__Impl5837); 
             after(grammarAccess.getInstanceSpecificationAccess().getCommaKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InstanceSpecification__Group__5__Impl"


    // $ANTLR start "rule__InstanceSpecification__Group__6"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2847:1: rule__InstanceSpecification__Group__6 : rule__InstanceSpecification__Group__6__Impl rule__InstanceSpecification__Group__7 ;
    public final void rule__InstanceSpecification__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2851:1: ( rule__InstanceSpecification__Group__6__Impl rule__InstanceSpecification__Group__7 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2852:2: rule__InstanceSpecification__Group__6__Impl rule__InstanceSpecification__Group__7
            {
            pushFollow(FOLLOW_rule__InstanceSpecification__Group__6__Impl_in_rule__InstanceSpecification__Group__65868);
            rule__InstanceSpecification__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__InstanceSpecification__Group__7_in_rule__InstanceSpecification__Group__65871);
            rule__InstanceSpecification__Group__7();

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
    // $ANTLR end "rule__InstanceSpecification__Group__6"


    // $ANTLR start "rule__InstanceSpecification__Group__6__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2859:1: rule__InstanceSpecification__Group__6__Impl : ( ( rule__InstanceSpecification__MetamodelAssignment_6 ) ) ;
    public final void rule__InstanceSpecification__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2863:1: ( ( ( rule__InstanceSpecification__MetamodelAssignment_6 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2864:1: ( ( rule__InstanceSpecification__MetamodelAssignment_6 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2864:1: ( ( rule__InstanceSpecification__MetamodelAssignment_6 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2865:1: ( rule__InstanceSpecification__MetamodelAssignment_6 )
            {
             before(grammarAccess.getInstanceSpecificationAccess().getMetamodelAssignment_6()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2866:1: ( rule__InstanceSpecification__MetamodelAssignment_6 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2866:2: rule__InstanceSpecification__MetamodelAssignment_6
            {
            pushFollow(FOLLOW_rule__InstanceSpecification__MetamodelAssignment_6_in_rule__InstanceSpecification__Group__6__Impl5898);
            rule__InstanceSpecification__MetamodelAssignment_6();

            state._fsp--;


            }

             after(grammarAccess.getInstanceSpecificationAccess().getMetamodelAssignment_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InstanceSpecification__Group__6__Impl"


    // $ANTLR start "rule__InstanceSpecification__Group__7"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2876:1: rule__InstanceSpecification__Group__7 : rule__InstanceSpecification__Group__7__Impl rule__InstanceSpecification__Group__8 ;
    public final void rule__InstanceSpecification__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2880:1: ( rule__InstanceSpecification__Group__7__Impl rule__InstanceSpecification__Group__8 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2881:2: rule__InstanceSpecification__Group__7__Impl rule__InstanceSpecification__Group__8
            {
            pushFollow(FOLLOW_rule__InstanceSpecification__Group__7__Impl_in_rule__InstanceSpecification__Group__75928);
            rule__InstanceSpecification__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__InstanceSpecification__Group__8_in_rule__InstanceSpecification__Group__75931);
            rule__InstanceSpecification__Group__8();

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
    // $ANTLR end "rule__InstanceSpecification__Group__7"


    // $ANTLR start "rule__InstanceSpecification__Group__7__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2888:1: rule__InstanceSpecification__Group__7__Impl : ( '>' ) ;
    public final void rule__InstanceSpecification__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2892:1: ( ( '>' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2893:1: ( '>' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2893:1: ( '>' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2894:1: '>'
            {
             before(grammarAccess.getInstanceSpecificationAccess().getGreaterThanSignKeyword_7()); 
            match(input,36,FOLLOW_36_in_rule__InstanceSpecification__Group__7__Impl5959); 
             after(grammarAccess.getInstanceSpecificationAccess().getGreaterThanSignKeyword_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InstanceSpecification__Group__7__Impl"


    // $ANTLR start "rule__InstanceSpecification__Group__8"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2907:1: rule__InstanceSpecification__Group__8 : rule__InstanceSpecification__Group__8__Impl rule__InstanceSpecification__Group__9 ;
    public final void rule__InstanceSpecification__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2911:1: ( rule__InstanceSpecification__Group__8__Impl rule__InstanceSpecification__Group__9 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2912:2: rule__InstanceSpecification__Group__8__Impl rule__InstanceSpecification__Group__9
            {
            pushFollow(FOLLOW_rule__InstanceSpecification__Group__8__Impl_in_rule__InstanceSpecification__Group__85990);
            rule__InstanceSpecification__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__InstanceSpecification__Group__9_in_rule__InstanceSpecification__Group__85993);
            rule__InstanceSpecification__Group__9();

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
    // $ANTLR end "rule__InstanceSpecification__Group__8"


    // $ANTLR start "rule__InstanceSpecification__Group__8__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2919:1: rule__InstanceSpecification__Group__8__Impl : ( '{' ) ;
    public final void rule__InstanceSpecification__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2923:1: ( ( '{' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2924:1: ( '{' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2924:1: ( '{' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2925:1: '{'
            {
             before(grammarAccess.getInstanceSpecificationAccess().getLeftCurlyBracketKeyword_8()); 
            match(input,37,FOLLOW_37_in_rule__InstanceSpecification__Group__8__Impl6021); 
             after(grammarAccess.getInstanceSpecificationAccess().getLeftCurlyBracketKeyword_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InstanceSpecification__Group__8__Impl"


    // $ANTLR start "rule__InstanceSpecification__Group__9"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2938:1: rule__InstanceSpecification__Group__9 : rule__InstanceSpecification__Group__9__Impl rule__InstanceSpecification__Group__10 ;
    public final void rule__InstanceSpecification__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2942:1: ( rule__InstanceSpecification__Group__9__Impl rule__InstanceSpecification__Group__10 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2943:2: rule__InstanceSpecification__Group__9__Impl rule__InstanceSpecification__Group__10
            {
            pushFollow(FOLLOW_rule__InstanceSpecification__Group__9__Impl_in_rule__InstanceSpecification__Group__96052);
            rule__InstanceSpecification__Group__9__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__InstanceSpecification__Group__10_in_rule__InstanceSpecification__Group__96055);
            rule__InstanceSpecification__Group__10();

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
    // $ANTLR end "rule__InstanceSpecification__Group__9"


    // $ANTLR start "rule__InstanceSpecification__Group__9__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2950:1: rule__InstanceSpecification__Group__9__Impl : ( ( rule__InstanceSpecification__Group_9__0 ) ) ;
    public final void rule__InstanceSpecification__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2954:1: ( ( ( rule__InstanceSpecification__Group_9__0 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2955:1: ( ( rule__InstanceSpecification__Group_9__0 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2955:1: ( ( rule__InstanceSpecification__Group_9__0 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2956:1: ( rule__InstanceSpecification__Group_9__0 )
            {
             before(grammarAccess.getInstanceSpecificationAccess().getGroup_9()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2957:1: ( rule__InstanceSpecification__Group_9__0 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2957:2: rule__InstanceSpecification__Group_9__0
            {
            pushFollow(FOLLOW_rule__InstanceSpecification__Group_9__0_in_rule__InstanceSpecification__Group__9__Impl6082);
            rule__InstanceSpecification__Group_9__0();

            state._fsp--;


            }

             after(grammarAccess.getInstanceSpecificationAccess().getGroup_9()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InstanceSpecification__Group__9__Impl"


    // $ANTLR start "rule__InstanceSpecification__Group__10"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2967:1: rule__InstanceSpecification__Group__10 : rule__InstanceSpecification__Group__10__Impl ;
    public final void rule__InstanceSpecification__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2971:1: ( rule__InstanceSpecification__Group__10__Impl )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2972:2: rule__InstanceSpecification__Group__10__Impl
            {
            pushFollow(FOLLOW_rule__InstanceSpecification__Group__10__Impl_in_rule__InstanceSpecification__Group__106112);
            rule__InstanceSpecification__Group__10__Impl();

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
    // $ANTLR end "rule__InstanceSpecification__Group__10"


    // $ANTLR start "rule__InstanceSpecification__Group__10__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2978:1: rule__InstanceSpecification__Group__10__Impl : ( '}' ) ;
    public final void rule__InstanceSpecification__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2982:1: ( ( '}' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2983:1: ( '}' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2983:1: ( '}' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2984:1: '}'
            {
             before(grammarAccess.getInstanceSpecificationAccess().getRightCurlyBracketKeyword_10()); 
            match(input,38,FOLLOW_38_in_rule__InstanceSpecification__Group__10__Impl6140); 
             after(grammarAccess.getInstanceSpecificationAccess().getRightCurlyBracketKeyword_10()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InstanceSpecification__Group__10__Impl"


    // $ANTLR start "rule__InstanceSpecification__Group_9__0"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3019:1: rule__InstanceSpecification__Group_9__0 : rule__InstanceSpecification__Group_9__0__Impl rule__InstanceSpecification__Group_9__1 ;
    public final void rule__InstanceSpecification__Group_9__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3023:1: ( rule__InstanceSpecification__Group_9__0__Impl rule__InstanceSpecification__Group_9__1 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3024:2: rule__InstanceSpecification__Group_9__0__Impl rule__InstanceSpecification__Group_9__1
            {
            pushFollow(FOLLOW_rule__InstanceSpecification__Group_9__0__Impl_in_rule__InstanceSpecification__Group_9__06193);
            rule__InstanceSpecification__Group_9__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__InstanceSpecification__Group_9__1_in_rule__InstanceSpecification__Group_9__06196);
            rule__InstanceSpecification__Group_9__1();

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
    // $ANTLR end "rule__InstanceSpecification__Group_9__0"


    // $ANTLR start "rule__InstanceSpecification__Group_9__0__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3031:1: rule__InstanceSpecification__Group_9__0__Impl : ( ( rule__InstanceSpecification__ConstraintSemanticsAssignment_9_0 ) ) ;
    public final void rule__InstanceSpecification__Group_9__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3035:1: ( ( ( rule__InstanceSpecification__ConstraintSemanticsAssignment_9_0 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3036:1: ( ( rule__InstanceSpecification__ConstraintSemanticsAssignment_9_0 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3036:1: ( ( rule__InstanceSpecification__ConstraintSemanticsAssignment_9_0 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3037:1: ( rule__InstanceSpecification__ConstraintSemanticsAssignment_9_0 )
            {
             before(grammarAccess.getInstanceSpecificationAccess().getConstraintSemanticsAssignment_9_0()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3038:1: ( rule__InstanceSpecification__ConstraintSemanticsAssignment_9_0 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3038:2: rule__InstanceSpecification__ConstraintSemanticsAssignment_9_0
            {
            pushFollow(FOLLOW_rule__InstanceSpecification__ConstraintSemanticsAssignment_9_0_in_rule__InstanceSpecification__Group_9__0__Impl6223);
            rule__InstanceSpecification__ConstraintSemanticsAssignment_9_0();

            state._fsp--;


            }

             after(grammarAccess.getInstanceSpecificationAccess().getConstraintSemanticsAssignment_9_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InstanceSpecification__Group_9__0__Impl"


    // $ANTLR start "rule__InstanceSpecification__Group_9__1"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3048:1: rule__InstanceSpecification__Group_9__1 : rule__InstanceSpecification__Group_9__1__Impl ;
    public final void rule__InstanceSpecification__Group_9__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3052:1: ( rule__InstanceSpecification__Group_9__1__Impl )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3053:2: rule__InstanceSpecification__Group_9__1__Impl
            {
            pushFollow(FOLLOW_rule__InstanceSpecification__Group_9__1__Impl_in_rule__InstanceSpecification__Group_9__16253);
            rule__InstanceSpecification__Group_9__1__Impl();

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
    // $ANTLR end "rule__InstanceSpecification__Group_9__1"


    // $ANTLR start "rule__InstanceSpecification__Group_9__1__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3059:1: rule__InstanceSpecification__Group_9__1__Impl : ( ( rule__InstanceSpecification__Group_9_1__0 )* ) ;
    public final void rule__InstanceSpecification__Group_9__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3063:1: ( ( ( rule__InstanceSpecification__Group_9_1__0 )* ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3064:1: ( ( rule__InstanceSpecification__Group_9_1__0 )* )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3064:1: ( ( rule__InstanceSpecification__Group_9_1__0 )* )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3065:1: ( rule__InstanceSpecification__Group_9_1__0 )*
            {
             before(grammarAccess.getInstanceSpecificationAccess().getGroup_9_1()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3066:1: ( rule__InstanceSpecification__Group_9_1__0 )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==29) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3066:2: rule__InstanceSpecification__Group_9_1__0
            	    {
            	    pushFollow(FOLLOW_rule__InstanceSpecification__Group_9_1__0_in_rule__InstanceSpecification__Group_9__1__Impl6280);
            	    rule__InstanceSpecification__Group_9_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

             after(grammarAccess.getInstanceSpecificationAccess().getGroup_9_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InstanceSpecification__Group_9__1__Impl"


    // $ANTLR start "rule__InstanceSpecification__Group_9_1__0"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3080:1: rule__InstanceSpecification__Group_9_1__0 : rule__InstanceSpecification__Group_9_1__0__Impl rule__InstanceSpecification__Group_9_1__1 ;
    public final void rule__InstanceSpecification__Group_9_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3084:1: ( rule__InstanceSpecification__Group_9_1__0__Impl rule__InstanceSpecification__Group_9_1__1 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3085:2: rule__InstanceSpecification__Group_9_1__0__Impl rule__InstanceSpecification__Group_9_1__1
            {
            pushFollow(FOLLOW_rule__InstanceSpecification__Group_9_1__0__Impl_in_rule__InstanceSpecification__Group_9_1__06315);
            rule__InstanceSpecification__Group_9_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__InstanceSpecification__Group_9_1__1_in_rule__InstanceSpecification__Group_9_1__06318);
            rule__InstanceSpecification__Group_9_1__1();

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
    // $ANTLR end "rule__InstanceSpecification__Group_9_1__0"


    // $ANTLR start "rule__InstanceSpecification__Group_9_1__0__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3092:1: rule__InstanceSpecification__Group_9_1__0__Impl : ( ',' ) ;
    public final void rule__InstanceSpecification__Group_9_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3096:1: ( ( ',' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3097:1: ( ',' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3097:1: ( ',' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3098:1: ','
            {
             before(grammarAccess.getInstanceSpecificationAccess().getCommaKeyword_9_1_0()); 
            match(input,29,FOLLOW_29_in_rule__InstanceSpecification__Group_9_1__0__Impl6346); 
             after(grammarAccess.getInstanceSpecificationAccess().getCommaKeyword_9_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InstanceSpecification__Group_9_1__0__Impl"


    // $ANTLR start "rule__InstanceSpecification__Group_9_1__1"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3111:1: rule__InstanceSpecification__Group_9_1__1 : rule__InstanceSpecification__Group_9_1__1__Impl ;
    public final void rule__InstanceSpecification__Group_9_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3115:1: ( rule__InstanceSpecification__Group_9_1__1__Impl )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3116:2: rule__InstanceSpecification__Group_9_1__1__Impl
            {
            pushFollow(FOLLOW_rule__InstanceSpecification__Group_9_1__1__Impl_in_rule__InstanceSpecification__Group_9_1__16377);
            rule__InstanceSpecification__Group_9_1__1__Impl();

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
    // $ANTLR end "rule__InstanceSpecification__Group_9_1__1"


    // $ANTLR start "rule__InstanceSpecification__Group_9_1__1__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3122:1: rule__InstanceSpecification__Group_9_1__1__Impl : ( ( rule__InstanceSpecification__ConstraintSemanticsAssignment_9_1_1 ) ) ;
    public final void rule__InstanceSpecification__Group_9_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3126:1: ( ( ( rule__InstanceSpecification__ConstraintSemanticsAssignment_9_1_1 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3127:1: ( ( rule__InstanceSpecification__ConstraintSemanticsAssignment_9_1_1 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3127:1: ( ( rule__InstanceSpecification__ConstraintSemanticsAssignment_9_1_1 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3128:1: ( rule__InstanceSpecification__ConstraintSemanticsAssignment_9_1_1 )
            {
             before(grammarAccess.getInstanceSpecificationAccess().getConstraintSemanticsAssignment_9_1_1()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3129:1: ( rule__InstanceSpecification__ConstraintSemanticsAssignment_9_1_1 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3129:2: rule__InstanceSpecification__ConstraintSemanticsAssignment_9_1_1
            {
            pushFollow(FOLLOW_rule__InstanceSpecification__ConstraintSemanticsAssignment_9_1_1_in_rule__InstanceSpecification__Group_9_1__1__Impl6404);
            rule__InstanceSpecification__ConstraintSemanticsAssignment_9_1_1();

            state._fsp--;


            }

             after(grammarAccess.getInstanceSpecificationAccess().getConstraintSemanticsAssignment_9_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InstanceSpecification__Group_9_1__1__Impl"


    // $ANTLR start "rule__ConstraintSemantic__Group__0"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3143:1: rule__ConstraintSemantic__Group__0 : rule__ConstraintSemantic__Group__0__Impl rule__ConstraintSemantic__Group__1 ;
    public final void rule__ConstraintSemantic__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3147:1: ( rule__ConstraintSemantic__Group__0__Impl rule__ConstraintSemantic__Group__1 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3148:2: rule__ConstraintSemantic__Group__0__Impl rule__ConstraintSemantic__Group__1
            {
            pushFollow(FOLLOW_rule__ConstraintSemantic__Group__0__Impl_in_rule__ConstraintSemantic__Group__06438);
            rule__ConstraintSemantic__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ConstraintSemantic__Group__1_in_rule__ConstraintSemantic__Group__06441);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3155:1: rule__ConstraintSemantic__Group__0__Impl : ( ( rule__ConstraintSemantic__IdAssignment_0 ) ) ;
    public final void rule__ConstraintSemantic__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3159:1: ( ( ( rule__ConstraintSemantic__IdAssignment_0 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3160:1: ( ( rule__ConstraintSemantic__IdAssignment_0 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3160:1: ( ( rule__ConstraintSemantic__IdAssignment_0 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3161:1: ( rule__ConstraintSemantic__IdAssignment_0 )
            {
             before(grammarAccess.getConstraintSemanticAccess().getIdAssignment_0()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3162:1: ( rule__ConstraintSemantic__IdAssignment_0 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3162:2: rule__ConstraintSemantic__IdAssignment_0
            {
            pushFollow(FOLLOW_rule__ConstraintSemantic__IdAssignment_0_in_rule__ConstraintSemantic__Group__0__Impl6468);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3172:1: rule__ConstraintSemantic__Group__1 : rule__ConstraintSemantic__Group__1__Impl rule__ConstraintSemantic__Group__2 ;
    public final void rule__ConstraintSemantic__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3176:1: ( rule__ConstraintSemantic__Group__1__Impl rule__ConstraintSemantic__Group__2 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3177:2: rule__ConstraintSemantic__Group__1__Impl rule__ConstraintSemantic__Group__2
            {
            pushFollow(FOLLOW_rule__ConstraintSemantic__Group__1__Impl_in_rule__ConstraintSemantic__Group__16498);
            rule__ConstraintSemantic__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ConstraintSemantic__Group__2_in_rule__ConstraintSemantic__Group__16501);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3184:1: rule__ConstraintSemantic__Group__1__Impl : ( '{' ) ;
    public final void rule__ConstraintSemantic__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3188:1: ( ( '{' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3189:1: ( '{' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3189:1: ( '{' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3190:1: '{'
            {
             before(grammarAccess.getConstraintSemanticAccess().getLeftCurlyBracketKeyword_1()); 
            match(input,37,FOLLOW_37_in_rule__ConstraintSemantic__Group__1__Impl6529); 
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3203:1: rule__ConstraintSemantic__Group__2 : rule__ConstraintSemantic__Group__2__Impl rule__ConstraintSemantic__Group__3 ;
    public final void rule__ConstraintSemantic__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3207:1: ( rule__ConstraintSemantic__Group__2__Impl rule__ConstraintSemantic__Group__3 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3208:2: rule__ConstraintSemantic__Group__2__Impl rule__ConstraintSemantic__Group__3
            {
            pushFollow(FOLLOW_rule__ConstraintSemantic__Group__2__Impl_in_rule__ConstraintSemantic__Group__26560);
            rule__ConstraintSemantic__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ConstraintSemantic__Group__3_in_rule__ConstraintSemantic__Group__26563);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3215:1: rule__ConstraintSemantic__Group__2__Impl : ( ( rule__ConstraintSemantic__Group_2__0 ) ) ;
    public final void rule__ConstraintSemantic__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3219:1: ( ( ( rule__ConstraintSemantic__Group_2__0 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3220:1: ( ( rule__ConstraintSemantic__Group_2__0 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3220:1: ( ( rule__ConstraintSemantic__Group_2__0 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3221:1: ( rule__ConstraintSemantic__Group_2__0 )
            {
             before(grammarAccess.getConstraintSemanticAccess().getGroup_2()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3222:1: ( rule__ConstraintSemantic__Group_2__0 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3222:2: rule__ConstraintSemantic__Group_2__0
            {
            pushFollow(FOLLOW_rule__ConstraintSemantic__Group_2__0_in_rule__ConstraintSemantic__Group__2__Impl6590);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3232:1: rule__ConstraintSemantic__Group__3 : rule__ConstraintSemantic__Group__3__Impl rule__ConstraintSemantic__Group__4 ;
    public final void rule__ConstraintSemantic__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3236:1: ( rule__ConstraintSemantic__Group__3__Impl rule__ConstraintSemantic__Group__4 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3237:2: rule__ConstraintSemantic__Group__3__Impl rule__ConstraintSemantic__Group__4
            {
            pushFollow(FOLLOW_rule__ConstraintSemantic__Group__3__Impl_in_rule__ConstraintSemantic__Group__36620);
            rule__ConstraintSemantic__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ConstraintSemantic__Group__4_in_rule__ConstraintSemantic__Group__36623);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3244:1: rule__ConstraintSemantic__Group__3__Impl : ( ',' ) ;
    public final void rule__ConstraintSemantic__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3248:1: ( ( ',' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3249:1: ( ',' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3249:1: ( ',' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3250:1: ','
            {
             before(grammarAccess.getConstraintSemanticAccess().getCommaKeyword_3()); 
            match(input,29,FOLLOW_29_in_rule__ConstraintSemantic__Group__3__Impl6651); 
             after(grammarAccess.getConstraintSemanticAccess().getCommaKeyword_3()); 

            }


            }

        }
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3263:1: rule__ConstraintSemantic__Group__4 : rule__ConstraintSemantic__Group__4__Impl rule__ConstraintSemantic__Group__5 ;
    public final void rule__ConstraintSemantic__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3267:1: ( rule__ConstraintSemantic__Group__4__Impl rule__ConstraintSemantic__Group__5 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3268:2: rule__ConstraintSemantic__Group__4__Impl rule__ConstraintSemantic__Group__5
            {
            pushFollow(FOLLOW_rule__ConstraintSemantic__Group__4__Impl_in_rule__ConstraintSemantic__Group__46682);
            rule__ConstraintSemantic__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ConstraintSemantic__Group__5_in_rule__ConstraintSemantic__Group__46685);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3275:1: rule__ConstraintSemantic__Group__4__Impl : ( '}' ) ;
    public final void rule__ConstraintSemantic__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3279:1: ( ( '}' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3280:1: ( '}' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3280:1: ( '}' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3281:1: '}'
            {
             before(grammarAccess.getConstraintSemanticAccess().getRightCurlyBracketKeyword_4()); 
            match(input,38,FOLLOW_38_in_rule__ConstraintSemantic__Group__4__Impl6713); 
             after(grammarAccess.getConstraintSemanticAccess().getRightCurlyBracketKeyword_4()); 

            }


            }

        }
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3294:1: rule__ConstraintSemantic__Group__5 : rule__ConstraintSemantic__Group__5__Impl rule__ConstraintSemantic__Group__6 ;
    public final void rule__ConstraintSemantic__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3298:1: ( rule__ConstraintSemantic__Group__5__Impl rule__ConstraintSemantic__Group__6 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3299:2: rule__ConstraintSemantic__Group__5__Impl rule__ConstraintSemantic__Group__6
            {
            pushFollow(FOLLOW_rule__ConstraintSemantic__Group__5__Impl_in_rule__ConstraintSemantic__Group__56744);
            rule__ConstraintSemantic__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ConstraintSemantic__Group__6_in_rule__ConstraintSemantic__Group__56747);
            rule__ConstraintSemantic__Group__6();

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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3306:1: rule__ConstraintSemantic__Group__5__Impl : ( '=' ) ;
    public final void rule__ConstraintSemantic__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3310:1: ( ( '=' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3311:1: ( '=' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3311:1: ( '=' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3312:1: '='
            {
             before(grammarAccess.getConstraintSemanticAccess().getEqualsSignKeyword_5()); 
            match(input,39,FOLLOW_39_in_rule__ConstraintSemantic__Group__5__Impl6775); 
             after(grammarAccess.getConstraintSemanticAccess().getEqualsSignKeyword_5()); 

            }


            }

        }
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


    // $ANTLR start "rule__ConstraintSemantic__Group__6"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3325:1: rule__ConstraintSemantic__Group__6 : rule__ConstraintSemantic__Group__6__Impl ;
    public final void rule__ConstraintSemantic__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3329:1: ( rule__ConstraintSemantic__Group__6__Impl )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3330:2: rule__ConstraintSemantic__Group__6__Impl
            {
            pushFollow(FOLLOW_rule__ConstraintSemantic__Group__6__Impl_in_rule__ConstraintSemantic__Group__66806);
            rule__ConstraintSemantic__Group__6__Impl();

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
    // $ANTLR end "rule__ConstraintSemantic__Group__6"


    // $ANTLR start "rule__ConstraintSemantic__Group__6__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3336:1: rule__ConstraintSemantic__Group__6__Impl : ( ( rule__ConstraintSemantic__OclAssignment_6 ) ) ;
    public final void rule__ConstraintSemantic__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3340:1: ( ( ( rule__ConstraintSemantic__OclAssignment_6 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3341:1: ( ( rule__ConstraintSemantic__OclAssignment_6 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3341:1: ( ( rule__ConstraintSemantic__OclAssignment_6 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3342:1: ( rule__ConstraintSemantic__OclAssignment_6 )
            {
             before(grammarAccess.getConstraintSemanticAccess().getOclAssignment_6()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3343:1: ( rule__ConstraintSemantic__OclAssignment_6 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3343:2: rule__ConstraintSemantic__OclAssignment_6
            {
            pushFollow(FOLLOW_rule__ConstraintSemantic__OclAssignment_6_in_rule__ConstraintSemantic__Group__6__Impl6833);
            rule__ConstraintSemantic__OclAssignment_6();

            state._fsp--;


            }

             after(grammarAccess.getConstraintSemanticAccess().getOclAssignment_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConstraintSemantic__Group__6__Impl"


    // $ANTLR start "rule__ConstraintSemantic__Group_2__0"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3367:1: rule__ConstraintSemantic__Group_2__0 : rule__ConstraintSemantic__Group_2__0__Impl rule__ConstraintSemantic__Group_2__1 ;
    public final void rule__ConstraintSemantic__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3371:1: ( rule__ConstraintSemantic__Group_2__0__Impl rule__ConstraintSemantic__Group_2__1 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3372:2: rule__ConstraintSemantic__Group_2__0__Impl rule__ConstraintSemantic__Group_2__1
            {
            pushFollow(FOLLOW_rule__ConstraintSemantic__Group_2__0__Impl_in_rule__ConstraintSemantic__Group_2__06877);
            rule__ConstraintSemantic__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ConstraintSemantic__Group_2__1_in_rule__ConstraintSemantic__Group_2__06880);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3379:1: rule__ConstraintSemantic__Group_2__0__Impl : ( ( rule__ConstraintSemantic__ArrowsAssignment_2_0 ) ) ;
    public final void rule__ConstraintSemantic__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3383:1: ( ( ( rule__ConstraintSemantic__ArrowsAssignment_2_0 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3384:1: ( ( rule__ConstraintSemantic__ArrowsAssignment_2_0 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3384:1: ( ( rule__ConstraintSemantic__ArrowsAssignment_2_0 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3385:1: ( rule__ConstraintSemantic__ArrowsAssignment_2_0 )
            {
             before(grammarAccess.getConstraintSemanticAccess().getArrowsAssignment_2_0()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3386:1: ( rule__ConstraintSemantic__ArrowsAssignment_2_0 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3386:2: rule__ConstraintSemantic__ArrowsAssignment_2_0
            {
            pushFollow(FOLLOW_rule__ConstraintSemantic__ArrowsAssignment_2_0_in_rule__ConstraintSemantic__Group_2__0__Impl6907);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3396:1: rule__ConstraintSemantic__Group_2__1 : rule__ConstraintSemantic__Group_2__1__Impl ;
    public final void rule__ConstraintSemantic__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3400:1: ( rule__ConstraintSemantic__Group_2__1__Impl )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3401:2: rule__ConstraintSemantic__Group_2__1__Impl
            {
            pushFollow(FOLLOW_rule__ConstraintSemantic__Group_2__1__Impl_in_rule__ConstraintSemantic__Group_2__16937);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3407:1: rule__ConstraintSemantic__Group_2__1__Impl : ( ( rule__ConstraintSemantic__Group_2_1__0 )* ) ;
    public final void rule__ConstraintSemantic__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3411:1: ( ( ( rule__ConstraintSemantic__Group_2_1__0 )* ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3412:1: ( ( rule__ConstraintSemantic__Group_2_1__0 )* )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3412:1: ( ( rule__ConstraintSemantic__Group_2_1__0 )* )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3413:1: ( rule__ConstraintSemantic__Group_2_1__0 )*
            {
             before(grammarAccess.getConstraintSemanticAccess().getGroup_2_1()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3414:1: ( rule__ConstraintSemantic__Group_2_1__0 )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==29) ) {
                    int LA12_1 = input.LA(2);

                    if ( (LA12_1==RULE_ID) ) {
                        alt12=1;
                    }


                }


                switch (alt12) {
            	case 1 :
            	    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3414:2: rule__ConstraintSemantic__Group_2_1__0
            	    {
            	    pushFollow(FOLLOW_rule__ConstraintSemantic__Group_2_1__0_in_rule__ConstraintSemantic__Group_2__1__Impl6964);
            	    rule__ConstraintSemantic__Group_2_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop12;
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3428:1: rule__ConstraintSemantic__Group_2_1__0 : rule__ConstraintSemantic__Group_2_1__0__Impl rule__ConstraintSemantic__Group_2_1__1 ;
    public final void rule__ConstraintSemantic__Group_2_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3432:1: ( rule__ConstraintSemantic__Group_2_1__0__Impl rule__ConstraintSemantic__Group_2_1__1 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3433:2: rule__ConstraintSemantic__Group_2_1__0__Impl rule__ConstraintSemantic__Group_2_1__1
            {
            pushFollow(FOLLOW_rule__ConstraintSemantic__Group_2_1__0__Impl_in_rule__ConstraintSemantic__Group_2_1__06999);
            rule__ConstraintSemantic__Group_2_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ConstraintSemantic__Group_2_1__1_in_rule__ConstraintSemantic__Group_2_1__07002);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3440:1: rule__ConstraintSemantic__Group_2_1__0__Impl : ( ',' ) ;
    public final void rule__ConstraintSemantic__Group_2_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3444:1: ( ( ',' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3445:1: ( ',' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3445:1: ( ',' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3446:1: ','
            {
             before(grammarAccess.getConstraintSemanticAccess().getCommaKeyword_2_1_0()); 
            match(input,29,FOLLOW_29_in_rule__ConstraintSemantic__Group_2_1__0__Impl7030); 
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3459:1: rule__ConstraintSemantic__Group_2_1__1 : rule__ConstraintSemantic__Group_2_1__1__Impl ;
    public final void rule__ConstraintSemantic__Group_2_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3463:1: ( rule__ConstraintSemantic__Group_2_1__1__Impl )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3464:2: rule__ConstraintSemantic__Group_2_1__1__Impl
            {
            pushFollow(FOLLOW_rule__ConstraintSemantic__Group_2_1__1__Impl_in_rule__ConstraintSemantic__Group_2_1__17061);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3470:1: rule__ConstraintSemantic__Group_2_1__1__Impl : ( ( rule__ConstraintSemantic__ArrowsAssignment_2_1_1 ) ) ;
    public final void rule__ConstraintSemantic__Group_2_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3474:1: ( ( ( rule__ConstraintSemantic__ArrowsAssignment_2_1_1 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3475:1: ( ( rule__ConstraintSemantic__ArrowsAssignment_2_1_1 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3475:1: ( ( rule__ConstraintSemantic__ArrowsAssignment_2_1_1 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3476:1: ( rule__ConstraintSemantic__ArrowsAssignment_2_1_1 )
            {
             before(grammarAccess.getConstraintSemanticAccess().getArrowsAssignment_2_1_1()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3477:1: ( rule__ConstraintSemantic__ArrowsAssignment_2_1_1 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3477:2: rule__ConstraintSemantic__ArrowsAssignment_2_1_1
            {
            pushFollow(FOLLOW_rule__ConstraintSemantic__ArrowsAssignment_2_1_1_in_rule__ConstraintSemantic__Group_2_1__1__Impl7088);
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


    // $ANTLR start "rule__Specification__Group__0"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3491:1: rule__Specification__Group__0 : rule__Specification__Group__0__Impl rule__Specification__Group__1 ;
    public final void rule__Specification__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3495:1: ( rule__Specification__Group__0__Impl rule__Specification__Group__1 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3496:2: rule__Specification__Group__0__Impl rule__Specification__Group__1
            {
            pushFollow(FOLLOW_rule__Specification__Group__0__Impl_in_rule__Specification__Group__07122);
            rule__Specification__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Specification__Group__1_in_rule__Specification__Group__07125);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3503:1: rule__Specification__Group__0__Impl : ( 'Specification' ) ;
    public final void rule__Specification__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3507:1: ( ( 'Specification' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3508:1: ( 'Specification' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3508:1: ( 'Specification' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3509:1: 'Specification'
            {
             before(grammarAccess.getSpecificationAccess().getSpecificationKeyword_0()); 
            match(input,40,FOLLOW_40_in_rule__Specification__Group__0__Impl7153); 
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3522:1: rule__Specification__Group__1 : rule__Specification__Group__1__Impl rule__Specification__Group__2 ;
    public final void rule__Specification__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3526:1: ( rule__Specification__Group__1__Impl rule__Specification__Group__2 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3527:2: rule__Specification__Group__1__Impl rule__Specification__Group__2
            {
            pushFollow(FOLLOW_rule__Specification__Group__1__Impl_in_rule__Specification__Group__17184);
            rule__Specification__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Specification__Group__2_in_rule__Specification__Group__17187);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3534:1: rule__Specification__Group__1__Impl : ( ':' ) ;
    public final void rule__Specification__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3538:1: ( ( ':' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3539:1: ( ':' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3539:1: ( ':' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3540:1: ':'
            {
             before(grammarAccess.getSpecificationAccess().getColonKeyword_1()); 
            match(input,41,FOLLOW_41_in_rule__Specification__Group__1__Impl7215); 
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3553:1: rule__Specification__Group__2 : rule__Specification__Group__2__Impl rule__Specification__Group__3 ;
    public final void rule__Specification__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3557:1: ( rule__Specification__Group__2__Impl rule__Specification__Group__3 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3558:2: rule__Specification__Group__2__Impl rule__Specification__Group__3
            {
            pushFollow(FOLLOW_rule__Specification__Group__2__Impl_in_rule__Specification__Group__27246);
            rule__Specification__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Specification__Group__3_in_rule__Specification__Group__27249);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3565:1: rule__Specification__Group__2__Impl : ( ( rule__Specification__TypeAssignment_2 ) ) ;
    public final void rule__Specification__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3569:1: ( ( ( rule__Specification__TypeAssignment_2 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3570:1: ( ( rule__Specification__TypeAssignment_2 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3570:1: ( ( rule__Specification__TypeAssignment_2 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3571:1: ( rule__Specification__TypeAssignment_2 )
            {
             before(grammarAccess.getSpecificationAccess().getTypeAssignment_2()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3572:1: ( rule__Specification__TypeAssignment_2 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3572:2: rule__Specification__TypeAssignment_2
            {
            pushFollow(FOLLOW_rule__Specification__TypeAssignment_2_in_rule__Specification__Group__2__Impl7276);
            rule__Specification__TypeAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getSpecificationAccess().getTypeAssignment_2()); 

            }


            }

        }
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3582:1: rule__Specification__Group__3 : rule__Specification__Group__3__Impl rule__Specification__Group__4 ;
    public final void rule__Specification__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3586:1: ( rule__Specification__Group__3__Impl rule__Specification__Group__4 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3587:2: rule__Specification__Group__3__Impl rule__Specification__Group__4
            {
            pushFollow(FOLLOW_rule__Specification__Group__3__Impl_in_rule__Specification__Group__37306);
            rule__Specification__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Specification__Group__4_in_rule__Specification__Group__37309);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3594:1: rule__Specification__Group__3__Impl : ( '<' ) ;
    public final void rule__Specification__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3598:1: ( ( '<' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3599:1: ( '<' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3599:1: ( '<' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3600:1: '<'
            {
             before(grammarAccess.getSpecificationAccess().getLessThanSignKeyword_3()); 
            match(input,35,FOLLOW_35_in_rule__Specification__Group__3__Impl7337); 
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3613:1: rule__Specification__Group__4 : rule__Specification__Group__4__Impl rule__Specification__Group__5 ;
    public final void rule__Specification__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3617:1: ( rule__Specification__Group__4__Impl rule__Specification__Group__5 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3618:2: rule__Specification__Group__4__Impl rule__Specification__Group__5
            {
            pushFollow(FOLLOW_rule__Specification__Group__4__Impl_in_rule__Specification__Group__47368);
            rule__Specification__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Specification__Group__5_in_rule__Specification__Group__47371);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3625:1: rule__Specification__Group__4__Impl : ( ( rule__Specification__SequenceNumberAssignment_4 ) ) ;
    public final void rule__Specification__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3629:1: ( ( ( rule__Specification__SequenceNumberAssignment_4 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3630:1: ( ( rule__Specification__SequenceNumberAssignment_4 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3630:1: ( ( rule__Specification__SequenceNumberAssignment_4 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3631:1: ( rule__Specification__SequenceNumberAssignment_4 )
            {
             before(grammarAccess.getSpecificationAccess().getSequenceNumberAssignment_4()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3632:1: ( rule__Specification__SequenceNumberAssignment_4 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3632:2: rule__Specification__SequenceNumberAssignment_4
            {
            pushFollow(FOLLOW_rule__Specification__SequenceNumberAssignment_4_in_rule__Specification__Group__4__Impl7398);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3642:1: rule__Specification__Group__5 : rule__Specification__Group__5__Impl rule__Specification__Group__6 ;
    public final void rule__Specification__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3646:1: ( rule__Specification__Group__5__Impl rule__Specification__Group__6 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3647:2: rule__Specification__Group__5__Impl rule__Specification__Group__6
            {
            pushFollow(FOLLOW_rule__Specification__Group__5__Impl_in_rule__Specification__Group__57428);
            rule__Specification__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Specification__Group__6_in_rule__Specification__Group__57431);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3654:1: rule__Specification__Group__5__Impl : ( '>' ) ;
    public final void rule__Specification__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3658:1: ( ( '>' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3659:1: ( '>' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3659:1: ( '>' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3660:1: '>'
            {
             before(grammarAccess.getSpecificationAccess().getGreaterThanSignKeyword_5()); 
            match(input,36,FOLLOW_36_in_rule__Specification__Group__5__Impl7459); 
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3673:1: rule__Specification__Group__6 : rule__Specification__Group__6__Impl rule__Specification__Group__7 ;
    public final void rule__Specification__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3677:1: ( rule__Specification__Group__6__Impl rule__Specification__Group__7 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3678:2: rule__Specification__Group__6__Impl rule__Specification__Group__7
            {
            pushFollow(FOLLOW_rule__Specification__Group__6__Impl_in_rule__Specification__Group__67490);
            rule__Specification__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Specification__Group__7_in_rule__Specification__Group__67493);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3685:1: rule__Specification__Group__6__Impl : ( '{' ) ;
    public final void rule__Specification__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3689:1: ( ( '{' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3690:1: ( '{' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3690:1: ( '{' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3691:1: '{'
            {
             before(grammarAccess.getSpecificationAccess().getLeftCurlyBracketKeyword_6()); 
            match(input,37,FOLLOW_37_in_rule__Specification__Group__6__Impl7521); 
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3704:1: rule__Specification__Group__7 : rule__Specification__Group__7__Impl rule__Specification__Group__8 ;
    public final void rule__Specification__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3708:1: ( rule__Specification__Group__7__Impl rule__Specification__Group__8 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3709:2: rule__Specification__Group__7__Impl rule__Specification__Group__8
            {
            pushFollow(FOLLOW_rule__Specification__Group__7__Impl_in_rule__Specification__Group__77552);
            rule__Specification__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Specification__Group__8_in_rule__Specification__Group__77555);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3716:1: rule__Specification__Group__7__Impl : ( ( rule__Specification__GraphAssignment_7 ) ) ;
    public final void rule__Specification__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3720:1: ( ( ( rule__Specification__GraphAssignment_7 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3721:1: ( ( rule__Specification__GraphAssignment_7 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3721:1: ( ( rule__Specification__GraphAssignment_7 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3722:1: ( rule__Specification__GraphAssignment_7 )
            {
             before(grammarAccess.getSpecificationAccess().getGraphAssignment_7()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3723:1: ( rule__Specification__GraphAssignment_7 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3723:2: rule__Specification__GraphAssignment_7
            {
            pushFollow(FOLLOW_rule__Specification__GraphAssignment_7_in_rule__Specification__Group__7__Impl7582);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3733:1: rule__Specification__Group__8 : rule__Specification__Group__8__Impl rule__Specification__Group__9 ;
    public final void rule__Specification__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3737:1: ( rule__Specification__Group__8__Impl rule__Specification__Group__9 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3738:2: rule__Specification__Group__8__Impl rule__Specification__Group__9
            {
            pushFollow(FOLLOW_rule__Specification__Group__8__Impl_in_rule__Specification__Group__87612);
            rule__Specification__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Specification__Group__9_in_rule__Specification__Group__87615);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3745:1: rule__Specification__Group__8__Impl : ( 'Constraints' ) ;
    public final void rule__Specification__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3749:1: ( ( 'Constraints' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3750:1: ( 'Constraints' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3750:1: ( 'Constraints' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3751:1: 'Constraints'
            {
             before(grammarAccess.getSpecificationAccess().getConstraintsKeyword_8()); 
            match(input,42,FOLLOW_42_in_rule__Specification__Group__8__Impl7643); 
             after(grammarAccess.getSpecificationAccess().getConstraintsKeyword_8()); 

            }


            }

        }
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3764:1: rule__Specification__Group__9 : rule__Specification__Group__9__Impl rule__Specification__Group__10 ;
    public final void rule__Specification__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3768:1: ( rule__Specification__Group__9__Impl rule__Specification__Group__10 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3769:2: rule__Specification__Group__9__Impl rule__Specification__Group__10
            {
            pushFollow(FOLLOW_rule__Specification__Group__9__Impl_in_rule__Specification__Group__97674);
            rule__Specification__Group__9__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Specification__Group__10_in_rule__Specification__Group__97677);
            rule__Specification__Group__10();

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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3776:1: rule__Specification__Group__9__Impl : ( '<' ) ;
    public final void rule__Specification__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3780:1: ( ( '<' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3781:1: ( '<' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3781:1: ( '<' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3782:1: '<'
            {
             before(grammarAccess.getSpecificationAccess().getLessThanSignKeyword_9()); 
            match(input,35,FOLLOW_35_in_rule__Specification__Group__9__Impl7705); 
             after(grammarAccess.getSpecificationAccess().getLessThanSignKeyword_9()); 

            }


            }

        }
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


    // $ANTLR start "rule__Specification__Group__10"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3795:1: rule__Specification__Group__10 : rule__Specification__Group__10__Impl rule__Specification__Group__11 ;
    public final void rule__Specification__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3799:1: ( rule__Specification__Group__10__Impl rule__Specification__Group__11 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3800:2: rule__Specification__Group__10__Impl rule__Specification__Group__11
            {
            pushFollow(FOLLOW_rule__Specification__Group__10__Impl_in_rule__Specification__Group__107736);
            rule__Specification__Group__10__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Specification__Group__11_in_rule__Specification__Group__107739);
            rule__Specification__Group__11();

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
    // $ANTLR end "rule__Specification__Group__10"


    // $ANTLR start "rule__Specification__Group__10__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3807:1: rule__Specification__Group__10__Impl : ( ( rule__Specification__ConstaintSemanticAssignment_10 ) ) ;
    public final void rule__Specification__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3811:1: ( ( ( rule__Specification__ConstaintSemanticAssignment_10 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3812:1: ( ( rule__Specification__ConstaintSemanticAssignment_10 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3812:1: ( ( rule__Specification__ConstaintSemanticAssignment_10 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3813:1: ( rule__Specification__ConstaintSemanticAssignment_10 )
            {
             before(grammarAccess.getSpecificationAccess().getConstaintSemanticAssignment_10()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3814:1: ( rule__Specification__ConstaintSemanticAssignment_10 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3814:2: rule__Specification__ConstaintSemanticAssignment_10
            {
            pushFollow(FOLLOW_rule__Specification__ConstaintSemanticAssignment_10_in_rule__Specification__Group__10__Impl7766);
            rule__Specification__ConstaintSemanticAssignment_10();

            state._fsp--;


            }

             after(grammarAccess.getSpecificationAccess().getConstaintSemanticAssignment_10()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Specification__Group__10__Impl"


    // $ANTLR start "rule__Specification__Group__11"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3824:1: rule__Specification__Group__11 : rule__Specification__Group__11__Impl rule__Specification__Group__12 ;
    public final void rule__Specification__Group__11() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3828:1: ( rule__Specification__Group__11__Impl rule__Specification__Group__12 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3829:2: rule__Specification__Group__11__Impl rule__Specification__Group__12
            {
            pushFollow(FOLLOW_rule__Specification__Group__11__Impl_in_rule__Specification__Group__117796);
            rule__Specification__Group__11__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Specification__Group__12_in_rule__Specification__Group__117799);
            rule__Specification__Group__12();

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
    // $ANTLR end "rule__Specification__Group__11"


    // $ANTLR start "rule__Specification__Group__11__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3836:1: rule__Specification__Group__11__Impl : ( '>' ) ;
    public final void rule__Specification__Group__11__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3840:1: ( ( '>' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3841:1: ( '>' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3841:1: ( '>' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3842:1: '>'
            {
             before(grammarAccess.getSpecificationAccess().getGreaterThanSignKeyword_11()); 
            match(input,36,FOLLOW_36_in_rule__Specification__Group__11__Impl7827); 
             after(grammarAccess.getSpecificationAccess().getGreaterThanSignKeyword_11()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Specification__Group__11__Impl"


    // $ANTLR start "rule__Specification__Group__12"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3855:1: rule__Specification__Group__12 : rule__Specification__Group__12__Impl rule__Specification__Group__13 ;
    public final void rule__Specification__Group__12() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3859:1: ( rule__Specification__Group__12__Impl rule__Specification__Group__13 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3860:2: rule__Specification__Group__12__Impl rule__Specification__Group__13
            {
            pushFollow(FOLLOW_rule__Specification__Group__12__Impl_in_rule__Specification__Group__127858);
            rule__Specification__Group__12__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Specification__Group__13_in_rule__Specification__Group__127861);
            rule__Specification__Group__13();

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
    // $ANTLR end "rule__Specification__Group__12"


    // $ANTLR start "rule__Specification__Group__12__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3867:1: rule__Specification__Group__12__Impl : ( '{' ) ;
    public final void rule__Specification__Group__12__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3871:1: ( ( '{' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3872:1: ( '{' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3872:1: ( '{' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3873:1: '{'
            {
             before(grammarAccess.getSpecificationAccess().getLeftCurlyBracketKeyword_12()); 
            match(input,37,FOLLOW_37_in_rule__Specification__Group__12__Impl7889); 
             after(grammarAccess.getSpecificationAccess().getLeftCurlyBracketKeyword_12()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Specification__Group__12__Impl"


    // $ANTLR start "rule__Specification__Group__13"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3886:1: rule__Specification__Group__13 : rule__Specification__Group__13__Impl rule__Specification__Group__14 ;
    public final void rule__Specification__Group__13() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3890:1: ( rule__Specification__Group__13__Impl rule__Specification__Group__14 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3891:2: rule__Specification__Group__13__Impl rule__Specification__Group__14
            {
            pushFollow(FOLLOW_rule__Specification__Group__13__Impl_in_rule__Specification__Group__137920);
            rule__Specification__Group__13__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Specification__Group__14_in_rule__Specification__Group__137923);
            rule__Specification__Group__14();

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
    // $ANTLR end "rule__Specification__Group__13"


    // $ANTLR start "rule__Specification__Group__13__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3898:1: rule__Specification__Group__13__Impl : ( ( rule__Specification__Group_13__0 )? ) ;
    public final void rule__Specification__Group__13__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3902:1: ( ( ( rule__Specification__Group_13__0 )? ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3903:1: ( ( rule__Specification__Group_13__0 )? )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3903:1: ( ( rule__Specification__Group_13__0 )? )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3904:1: ( rule__Specification__Group_13__0 )?
            {
             before(grammarAccess.getSpecificationAccess().getGroup_13()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3905:1: ( rule__Specification__Group_13__0 )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==RULE_ID) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3905:2: rule__Specification__Group_13__0
                    {
                    pushFollow(FOLLOW_rule__Specification__Group_13__0_in_rule__Specification__Group__13__Impl7950);
                    rule__Specification__Group_13__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getSpecificationAccess().getGroup_13()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Specification__Group__13__Impl"


    // $ANTLR start "rule__Specification__Group__14"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3915:1: rule__Specification__Group__14 : rule__Specification__Group__14__Impl rule__Specification__Group__15 ;
    public final void rule__Specification__Group__14() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3919:1: ( rule__Specification__Group__14__Impl rule__Specification__Group__15 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3920:2: rule__Specification__Group__14__Impl rule__Specification__Group__15
            {
            pushFollow(FOLLOW_rule__Specification__Group__14__Impl_in_rule__Specification__Group__147981);
            rule__Specification__Group__14__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Specification__Group__15_in_rule__Specification__Group__147984);
            rule__Specification__Group__15();

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
    // $ANTLR end "rule__Specification__Group__14"


    // $ANTLR start "rule__Specification__Group__14__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3927:1: rule__Specification__Group__14__Impl : ( '}' ) ;
    public final void rule__Specification__Group__14__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3931:1: ( ( '}' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3932:1: ( '}' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3932:1: ( '}' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3933:1: '}'
            {
             before(grammarAccess.getSpecificationAccess().getRightCurlyBracketKeyword_14()); 
            match(input,38,FOLLOW_38_in_rule__Specification__Group__14__Impl8012); 
             after(grammarAccess.getSpecificationAccess().getRightCurlyBracketKeyword_14()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Specification__Group__14__Impl"


    // $ANTLR start "rule__Specification__Group__15"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3946:1: rule__Specification__Group__15 : rule__Specification__Group__15__Impl ;
    public final void rule__Specification__Group__15() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3950:1: ( rule__Specification__Group__15__Impl )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3951:2: rule__Specification__Group__15__Impl
            {
            pushFollow(FOLLOW_rule__Specification__Group__15__Impl_in_rule__Specification__Group__158043);
            rule__Specification__Group__15__Impl();

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
    // $ANTLR end "rule__Specification__Group__15"


    // $ANTLR start "rule__Specification__Group__15__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3957:1: rule__Specification__Group__15__Impl : ( '}' ) ;
    public final void rule__Specification__Group__15__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3961:1: ( ( '}' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3962:1: ( '}' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3962:1: ( '}' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3963:1: '}'
            {
             before(grammarAccess.getSpecificationAccess().getRightCurlyBracketKeyword_15()); 
            match(input,38,FOLLOW_38_in_rule__Specification__Group__15__Impl8071); 
             after(grammarAccess.getSpecificationAccess().getRightCurlyBracketKeyword_15()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Specification__Group__15__Impl"


    // $ANTLR start "rule__Specification__Group_13__0"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4008:1: rule__Specification__Group_13__0 : rule__Specification__Group_13__0__Impl rule__Specification__Group_13__1 ;
    public final void rule__Specification__Group_13__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4012:1: ( rule__Specification__Group_13__0__Impl rule__Specification__Group_13__1 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4013:2: rule__Specification__Group_13__0__Impl rule__Specification__Group_13__1
            {
            pushFollow(FOLLOW_rule__Specification__Group_13__0__Impl_in_rule__Specification__Group_13__08134);
            rule__Specification__Group_13__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Specification__Group_13__1_in_rule__Specification__Group_13__08137);
            rule__Specification__Group_13__1();

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
    // $ANTLR end "rule__Specification__Group_13__0"


    // $ANTLR start "rule__Specification__Group_13__0__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4020:1: rule__Specification__Group_13__0__Impl : ( ( rule__Specification__ConstraintsAssignment_13_0 ) ) ;
    public final void rule__Specification__Group_13__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4024:1: ( ( ( rule__Specification__ConstraintsAssignment_13_0 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4025:1: ( ( rule__Specification__ConstraintsAssignment_13_0 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4025:1: ( ( rule__Specification__ConstraintsAssignment_13_0 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4026:1: ( rule__Specification__ConstraintsAssignment_13_0 )
            {
             before(grammarAccess.getSpecificationAccess().getConstraintsAssignment_13_0()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4027:1: ( rule__Specification__ConstraintsAssignment_13_0 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4027:2: rule__Specification__ConstraintsAssignment_13_0
            {
            pushFollow(FOLLOW_rule__Specification__ConstraintsAssignment_13_0_in_rule__Specification__Group_13__0__Impl8164);
            rule__Specification__ConstraintsAssignment_13_0();

            state._fsp--;


            }

             after(grammarAccess.getSpecificationAccess().getConstraintsAssignment_13_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Specification__Group_13__0__Impl"


    // $ANTLR start "rule__Specification__Group_13__1"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4037:1: rule__Specification__Group_13__1 : rule__Specification__Group_13__1__Impl ;
    public final void rule__Specification__Group_13__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4041:1: ( rule__Specification__Group_13__1__Impl )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4042:2: rule__Specification__Group_13__1__Impl
            {
            pushFollow(FOLLOW_rule__Specification__Group_13__1__Impl_in_rule__Specification__Group_13__18194);
            rule__Specification__Group_13__1__Impl();

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
    // $ANTLR end "rule__Specification__Group_13__1"


    // $ANTLR start "rule__Specification__Group_13__1__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4048:1: rule__Specification__Group_13__1__Impl : ( ( rule__Specification__Group_13_1__0 )* ) ;
    public final void rule__Specification__Group_13__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4052:1: ( ( ( rule__Specification__Group_13_1__0 )* ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4053:1: ( ( rule__Specification__Group_13_1__0 )* )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4053:1: ( ( rule__Specification__Group_13_1__0 )* )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4054:1: ( rule__Specification__Group_13_1__0 )*
            {
             before(grammarAccess.getSpecificationAccess().getGroup_13_1()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4055:1: ( rule__Specification__Group_13_1__0 )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==29) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4055:2: rule__Specification__Group_13_1__0
            	    {
            	    pushFollow(FOLLOW_rule__Specification__Group_13_1__0_in_rule__Specification__Group_13__1__Impl8221);
            	    rule__Specification__Group_13_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);

             after(grammarAccess.getSpecificationAccess().getGroup_13_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Specification__Group_13__1__Impl"


    // $ANTLR start "rule__Specification__Group_13_1__0"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4069:1: rule__Specification__Group_13_1__0 : rule__Specification__Group_13_1__0__Impl rule__Specification__Group_13_1__1 ;
    public final void rule__Specification__Group_13_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4073:1: ( rule__Specification__Group_13_1__0__Impl rule__Specification__Group_13_1__1 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4074:2: rule__Specification__Group_13_1__0__Impl rule__Specification__Group_13_1__1
            {
            pushFollow(FOLLOW_rule__Specification__Group_13_1__0__Impl_in_rule__Specification__Group_13_1__08256);
            rule__Specification__Group_13_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Specification__Group_13_1__1_in_rule__Specification__Group_13_1__08259);
            rule__Specification__Group_13_1__1();

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
    // $ANTLR end "rule__Specification__Group_13_1__0"


    // $ANTLR start "rule__Specification__Group_13_1__0__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4081:1: rule__Specification__Group_13_1__0__Impl : ( ',' ) ;
    public final void rule__Specification__Group_13_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4085:1: ( ( ',' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4086:1: ( ',' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4086:1: ( ',' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4087:1: ','
            {
             before(grammarAccess.getSpecificationAccess().getCommaKeyword_13_1_0()); 
            match(input,29,FOLLOW_29_in_rule__Specification__Group_13_1__0__Impl8287); 
             after(grammarAccess.getSpecificationAccess().getCommaKeyword_13_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Specification__Group_13_1__0__Impl"


    // $ANTLR start "rule__Specification__Group_13_1__1"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4100:1: rule__Specification__Group_13_1__1 : rule__Specification__Group_13_1__1__Impl ;
    public final void rule__Specification__Group_13_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4104:1: ( rule__Specification__Group_13_1__1__Impl )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4105:2: rule__Specification__Group_13_1__1__Impl
            {
            pushFollow(FOLLOW_rule__Specification__Group_13_1__1__Impl_in_rule__Specification__Group_13_1__18318);
            rule__Specification__Group_13_1__1__Impl();

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
    // $ANTLR end "rule__Specification__Group_13_1__1"


    // $ANTLR start "rule__Specification__Group_13_1__1__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4111:1: rule__Specification__Group_13_1__1__Impl : ( ( rule__Specification__ConstraintsAssignment_13_1_1 ) ) ;
    public final void rule__Specification__Group_13_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4115:1: ( ( ( rule__Specification__ConstraintsAssignment_13_1_1 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4116:1: ( ( rule__Specification__ConstraintsAssignment_13_1_1 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4116:1: ( ( rule__Specification__ConstraintsAssignment_13_1_1 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4117:1: ( rule__Specification__ConstraintsAssignment_13_1_1 )
            {
             before(grammarAccess.getSpecificationAccess().getConstraintsAssignment_13_1_1()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4118:1: ( rule__Specification__ConstraintsAssignment_13_1_1 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4118:2: rule__Specification__ConstraintsAssignment_13_1_1
            {
            pushFollow(FOLLOW_rule__Specification__ConstraintsAssignment_13_1_1_in_rule__Specification__Group_13_1__1__Impl8345);
            rule__Specification__ConstraintsAssignment_13_1_1();

            state._fsp--;


            }

             after(grammarAccess.getSpecificationAccess().getConstraintsAssignment_13_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Specification__Group_13_1__1__Impl"


    // $ANTLR start "rule__Constraint__Group__0"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4132:1: rule__Constraint__Group__0 : rule__Constraint__Group__0__Impl rule__Constraint__Group__1 ;
    public final void rule__Constraint__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4136:1: ( rule__Constraint__Group__0__Impl rule__Constraint__Group__1 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4137:2: rule__Constraint__Group__0__Impl rule__Constraint__Group__1
            {
            pushFollow(FOLLOW_rule__Constraint__Group__0__Impl_in_rule__Constraint__Group__08379);
            rule__Constraint__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Constraint__Group__1_in_rule__Constraint__Group__08382);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4144:1: rule__Constraint__Group__0__Impl : ( ( rule__Constraint__SignatureAssignment_0 ) ) ;
    public final void rule__Constraint__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4148:1: ( ( ( rule__Constraint__SignatureAssignment_0 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4149:1: ( ( rule__Constraint__SignatureAssignment_0 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4149:1: ( ( rule__Constraint__SignatureAssignment_0 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4150:1: ( rule__Constraint__SignatureAssignment_0 )
            {
             before(grammarAccess.getConstraintAccess().getSignatureAssignment_0()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4151:1: ( rule__Constraint__SignatureAssignment_0 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4151:2: rule__Constraint__SignatureAssignment_0
            {
            pushFollow(FOLLOW_rule__Constraint__SignatureAssignment_0_in_rule__Constraint__Group__0__Impl8409);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4161:1: rule__Constraint__Group__1 : rule__Constraint__Group__1__Impl rule__Constraint__Group__2 ;
    public final void rule__Constraint__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4165:1: ( rule__Constraint__Group__1__Impl rule__Constraint__Group__2 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4166:2: rule__Constraint__Group__1__Impl rule__Constraint__Group__2
            {
            pushFollow(FOLLOW_rule__Constraint__Group__1__Impl_in_rule__Constraint__Group__18439);
            rule__Constraint__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Constraint__Group__2_in_rule__Constraint__Group__18442);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4173:1: rule__Constraint__Group__1__Impl : ( '{' ) ;
    public final void rule__Constraint__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4177:1: ( ( '{' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4178:1: ( '{' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4178:1: ( '{' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4179:1: '{'
            {
             before(grammarAccess.getConstraintAccess().getLeftCurlyBracketKeyword_1()); 
            match(input,37,FOLLOW_37_in_rule__Constraint__Group__1__Impl8470); 
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4192:1: rule__Constraint__Group__2 : rule__Constraint__Group__2__Impl rule__Constraint__Group__3 ;
    public final void rule__Constraint__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4196:1: ( rule__Constraint__Group__2__Impl rule__Constraint__Group__3 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4197:2: rule__Constraint__Group__2__Impl rule__Constraint__Group__3
            {
            pushFollow(FOLLOW_rule__Constraint__Group__2__Impl_in_rule__Constraint__Group__28501);
            rule__Constraint__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Constraint__Group__3_in_rule__Constraint__Group__28504);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4204:1: rule__Constraint__Group__2__Impl : ( ( rule__Constraint__Group_2__0 ) ) ;
    public final void rule__Constraint__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4208:1: ( ( ( rule__Constraint__Group_2__0 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4209:1: ( ( rule__Constraint__Group_2__0 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4209:1: ( ( rule__Constraint__Group_2__0 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4210:1: ( rule__Constraint__Group_2__0 )
            {
             before(grammarAccess.getConstraintAccess().getGroup_2()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4211:1: ( rule__Constraint__Group_2__0 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4211:2: rule__Constraint__Group_2__0
            {
            pushFollow(FOLLOW_rule__Constraint__Group_2__0_in_rule__Constraint__Group__2__Impl8531);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4221:1: rule__Constraint__Group__3 : rule__Constraint__Group__3__Impl ;
    public final void rule__Constraint__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4225:1: ( rule__Constraint__Group__3__Impl )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4226:2: rule__Constraint__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__Constraint__Group__3__Impl_in_rule__Constraint__Group__38561);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4232:1: rule__Constraint__Group__3__Impl : ( '}' ) ;
    public final void rule__Constraint__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4236:1: ( ( '}' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4237:1: ( '}' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4237:1: ( '}' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4238:1: '}'
            {
             before(grammarAccess.getConstraintAccess().getRightCurlyBracketKeyword_3()); 
            match(input,38,FOLLOW_38_in_rule__Constraint__Group__3__Impl8589); 
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4259:1: rule__Constraint__Group_2__0 : rule__Constraint__Group_2__0__Impl rule__Constraint__Group_2__1 ;
    public final void rule__Constraint__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4263:1: ( rule__Constraint__Group_2__0__Impl rule__Constraint__Group_2__1 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4264:2: rule__Constraint__Group_2__0__Impl rule__Constraint__Group_2__1
            {
            pushFollow(FOLLOW_rule__Constraint__Group_2__0__Impl_in_rule__Constraint__Group_2__08628);
            rule__Constraint__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Constraint__Group_2__1_in_rule__Constraint__Group_2__08631);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4271:1: rule__Constraint__Group_2__0__Impl : ( ( rule__Constraint__ArrowsAssignment_2_0 ) ) ;
    public final void rule__Constraint__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4275:1: ( ( ( rule__Constraint__ArrowsAssignment_2_0 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4276:1: ( ( rule__Constraint__ArrowsAssignment_2_0 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4276:1: ( ( rule__Constraint__ArrowsAssignment_2_0 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4277:1: ( rule__Constraint__ArrowsAssignment_2_0 )
            {
             before(grammarAccess.getConstraintAccess().getArrowsAssignment_2_0()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4278:1: ( rule__Constraint__ArrowsAssignment_2_0 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4278:2: rule__Constraint__ArrowsAssignment_2_0
            {
            pushFollow(FOLLOW_rule__Constraint__ArrowsAssignment_2_0_in_rule__Constraint__Group_2__0__Impl8658);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4288:1: rule__Constraint__Group_2__1 : rule__Constraint__Group_2__1__Impl ;
    public final void rule__Constraint__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4292:1: ( rule__Constraint__Group_2__1__Impl )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4293:2: rule__Constraint__Group_2__1__Impl
            {
            pushFollow(FOLLOW_rule__Constraint__Group_2__1__Impl_in_rule__Constraint__Group_2__18688);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4299:1: rule__Constraint__Group_2__1__Impl : ( ( rule__Constraint__Group_2_1__0 )* ) ;
    public final void rule__Constraint__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4303:1: ( ( ( rule__Constraint__Group_2_1__0 )* ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4304:1: ( ( rule__Constraint__Group_2_1__0 )* )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4304:1: ( ( rule__Constraint__Group_2_1__0 )* )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4305:1: ( rule__Constraint__Group_2_1__0 )*
            {
             before(grammarAccess.getConstraintAccess().getGroup_2_1()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4306:1: ( rule__Constraint__Group_2_1__0 )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==29) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4306:2: rule__Constraint__Group_2_1__0
            	    {
            	    pushFollow(FOLLOW_rule__Constraint__Group_2_1__0_in_rule__Constraint__Group_2__1__Impl8715);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4320:1: rule__Constraint__Group_2_1__0 : rule__Constraint__Group_2_1__0__Impl rule__Constraint__Group_2_1__1 ;
    public final void rule__Constraint__Group_2_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4324:1: ( rule__Constraint__Group_2_1__0__Impl rule__Constraint__Group_2_1__1 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4325:2: rule__Constraint__Group_2_1__0__Impl rule__Constraint__Group_2_1__1
            {
            pushFollow(FOLLOW_rule__Constraint__Group_2_1__0__Impl_in_rule__Constraint__Group_2_1__08750);
            rule__Constraint__Group_2_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Constraint__Group_2_1__1_in_rule__Constraint__Group_2_1__08753);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4332:1: rule__Constraint__Group_2_1__0__Impl : ( ',' ) ;
    public final void rule__Constraint__Group_2_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4336:1: ( ( ',' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4337:1: ( ',' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4337:1: ( ',' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4338:1: ','
            {
             before(grammarAccess.getConstraintAccess().getCommaKeyword_2_1_0()); 
            match(input,29,FOLLOW_29_in_rule__Constraint__Group_2_1__0__Impl8781); 
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4351:1: rule__Constraint__Group_2_1__1 : rule__Constraint__Group_2_1__1__Impl ;
    public final void rule__Constraint__Group_2_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4355:1: ( rule__Constraint__Group_2_1__1__Impl )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4356:2: rule__Constraint__Group_2_1__1__Impl
            {
            pushFollow(FOLLOW_rule__Constraint__Group_2_1__1__Impl_in_rule__Constraint__Group_2_1__18812);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4362:1: rule__Constraint__Group_2_1__1__Impl : ( ( rule__Constraint__ArrowsAssignment_2_1_1 ) ) ;
    public final void rule__Constraint__Group_2_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4366:1: ( ( ( rule__Constraint__ArrowsAssignment_2_1_1 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4367:1: ( ( rule__Constraint__ArrowsAssignment_2_1_1 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4367:1: ( ( rule__Constraint__ArrowsAssignment_2_1_1 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4368:1: ( rule__Constraint__ArrowsAssignment_2_1_1 )
            {
             before(grammarAccess.getConstraintAccess().getArrowsAssignment_2_1_1()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4369:1: ( rule__Constraint__ArrowsAssignment_2_1_1 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4369:2: rule__Constraint__ArrowsAssignment_2_1_1
            {
            pushFollow(FOLLOW_rule__Constraint__ArrowsAssignment_2_1_1_in_rule__Constraint__Group_2_1__1__Impl8839);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4383:1: rule__ConstraintSignature__Group__0 : rule__ConstraintSignature__Group__0__Impl rule__ConstraintSignature__Group__1 ;
    public final void rule__ConstraintSignature__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4387:1: ( rule__ConstraintSignature__Group__0__Impl rule__ConstraintSignature__Group__1 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4388:2: rule__ConstraintSignature__Group__0__Impl rule__ConstraintSignature__Group__1
            {
            pushFollow(FOLLOW_rule__ConstraintSignature__Group__0__Impl_in_rule__ConstraintSignature__Group__08873);
            rule__ConstraintSignature__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ConstraintSignature__Group__1_in_rule__ConstraintSignature__Group__08876);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4395:1: rule__ConstraintSignature__Group__0__Impl : ( ( rule__ConstraintSignature__IdAssignment_0 ) ) ;
    public final void rule__ConstraintSignature__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4399:1: ( ( ( rule__ConstraintSignature__IdAssignment_0 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4400:1: ( ( rule__ConstraintSignature__IdAssignment_0 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4400:1: ( ( rule__ConstraintSignature__IdAssignment_0 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4401:1: ( rule__ConstraintSignature__IdAssignment_0 )
            {
             before(grammarAccess.getConstraintSignatureAccess().getIdAssignment_0()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4402:1: ( rule__ConstraintSignature__IdAssignment_0 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4402:2: rule__ConstraintSignature__IdAssignment_0
            {
            pushFollow(FOLLOW_rule__ConstraintSignature__IdAssignment_0_in_rule__ConstraintSignature__Group__0__Impl8903);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4412:1: rule__ConstraintSignature__Group__1 : rule__ConstraintSignature__Group__1__Impl rule__ConstraintSignature__Group__2 ;
    public final void rule__ConstraintSignature__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4416:1: ( rule__ConstraintSignature__Group__1__Impl rule__ConstraintSignature__Group__2 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4417:2: rule__ConstraintSignature__Group__1__Impl rule__ConstraintSignature__Group__2
            {
            pushFollow(FOLLOW_rule__ConstraintSignature__Group__1__Impl_in_rule__ConstraintSignature__Group__18933);
            rule__ConstraintSignature__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ConstraintSignature__Group__2_in_rule__ConstraintSignature__Group__18936);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4424:1: rule__ConstraintSignature__Group__1__Impl : ( '(' ) ;
    public final void rule__ConstraintSignature__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4428:1: ( ( '(' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4429:1: ( '(' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4429:1: ( '(' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4430:1: '('
            {
             before(grammarAccess.getConstraintSignatureAccess().getLeftParenthesisKeyword_1()); 
            match(input,43,FOLLOW_43_in_rule__ConstraintSignature__Group__1__Impl8964); 
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4443:1: rule__ConstraintSignature__Group__2 : rule__ConstraintSignature__Group__2__Impl rule__ConstraintSignature__Group__3 ;
    public final void rule__ConstraintSignature__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4447:1: ( rule__ConstraintSignature__Group__2__Impl rule__ConstraintSignature__Group__3 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4448:2: rule__ConstraintSignature__Group__2__Impl rule__ConstraintSignature__Group__3
            {
            pushFollow(FOLLOW_rule__ConstraintSignature__Group__2__Impl_in_rule__ConstraintSignature__Group__28995);
            rule__ConstraintSignature__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ConstraintSignature__Group__3_in_rule__ConstraintSignature__Group__28998);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4455:1: rule__ConstraintSignature__Group__2__Impl : ( ( rule__ConstraintSignature__Group_2__0 )? ) ;
    public final void rule__ConstraintSignature__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4459:1: ( ( ( rule__ConstraintSignature__Group_2__0 )? ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4460:1: ( ( rule__ConstraintSignature__Group_2__0 )? )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4460:1: ( ( rule__ConstraintSignature__Group_2__0 )? )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4461:1: ( rule__ConstraintSignature__Group_2__0 )?
            {
             before(grammarAccess.getConstraintSignatureAccess().getGroup_2()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4462:1: ( rule__ConstraintSignature__Group_2__0 )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==RULE_ID) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4462:2: rule__ConstraintSignature__Group_2__0
                    {
                    pushFollow(FOLLOW_rule__ConstraintSignature__Group_2__0_in_rule__ConstraintSignature__Group__2__Impl9025);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4472:1: rule__ConstraintSignature__Group__3 : rule__ConstraintSignature__Group__3__Impl ;
    public final void rule__ConstraintSignature__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4476:1: ( rule__ConstraintSignature__Group__3__Impl )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4477:2: rule__ConstraintSignature__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__ConstraintSignature__Group__3__Impl_in_rule__ConstraintSignature__Group__39056);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4483:1: rule__ConstraintSignature__Group__3__Impl : ( ')' ) ;
    public final void rule__ConstraintSignature__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4487:1: ( ( ')' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4488:1: ( ')' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4488:1: ( ')' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4489:1: ')'
            {
             before(grammarAccess.getConstraintSignatureAccess().getRightParenthesisKeyword_3()); 
            match(input,23,FOLLOW_23_in_rule__ConstraintSignature__Group__3__Impl9084); 
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4510:1: rule__ConstraintSignature__Group_2__0 : rule__ConstraintSignature__Group_2__0__Impl rule__ConstraintSignature__Group_2__1 ;
    public final void rule__ConstraintSignature__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4514:1: ( rule__ConstraintSignature__Group_2__0__Impl rule__ConstraintSignature__Group_2__1 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4515:2: rule__ConstraintSignature__Group_2__0__Impl rule__ConstraintSignature__Group_2__1
            {
            pushFollow(FOLLOW_rule__ConstraintSignature__Group_2__0__Impl_in_rule__ConstraintSignature__Group_2__09123);
            rule__ConstraintSignature__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ConstraintSignature__Group_2__1_in_rule__ConstraintSignature__Group_2__09126);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4522:1: rule__ConstraintSignature__Group_2__0__Impl : ( ( rule__ConstraintSignature__ParameterAssignment_2_0 ) ) ;
    public final void rule__ConstraintSignature__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4526:1: ( ( ( rule__ConstraintSignature__ParameterAssignment_2_0 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4527:1: ( ( rule__ConstraintSignature__ParameterAssignment_2_0 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4527:1: ( ( rule__ConstraintSignature__ParameterAssignment_2_0 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4528:1: ( rule__ConstraintSignature__ParameterAssignment_2_0 )
            {
             before(grammarAccess.getConstraintSignatureAccess().getParameterAssignment_2_0()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4529:1: ( rule__ConstraintSignature__ParameterAssignment_2_0 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4529:2: rule__ConstraintSignature__ParameterAssignment_2_0
            {
            pushFollow(FOLLOW_rule__ConstraintSignature__ParameterAssignment_2_0_in_rule__ConstraintSignature__Group_2__0__Impl9153);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4539:1: rule__ConstraintSignature__Group_2__1 : rule__ConstraintSignature__Group_2__1__Impl ;
    public final void rule__ConstraintSignature__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4543:1: ( rule__ConstraintSignature__Group_2__1__Impl )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4544:2: rule__ConstraintSignature__Group_2__1__Impl
            {
            pushFollow(FOLLOW_rule__ConstraintSignature__Group_2__1__Impl_in_rule__ConstraintSignature__Group_2__19183);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4550:1: rule__ConstraintSignature__Group_2__1__Impl : ( ( rule__ConstraintSignature__Group_2_1__0 )* ) ;
    public final void rule__ConstraintSignature__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4554:1: ( ( ( rule__ConstraintSignature__Group_2_1__0 )* ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4555:1: ( ( rule__ConstraintSignature__Group_2_1__0 )* )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4555:1: ( ( rule__ConstraintSignature__Group_2_1__0 )* )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4556:1: ( rule__ConstraintSignature__Group_2_1__0 )*
            {
             before(grammarAccess.getConstraintSignatureAccess().getGroup_2_1()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4557:1: ( rule__ConstraintSignature__Group_2_1__0 )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==29) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4557:2: rule__ConstraintSignature__Group_2_1__0
            	    {
            	    pushFollow(FOLLOW_rule__ConstraintSignature__Group_2_1__0_in_rule__ConstraintSignature__Group_2__1__Impl9210);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4571:1: rule__ConstraintSignature__Group_2_1__0 : rule__ConstraintSignature__Group_2_1__0__Impl rule__ConstraintSignature__Group_2_1__1 ;
    public final void rule__ConstraintSignature__Group_2_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4575:1: ( rule__ConstraintSignature__Group_2_1__0__Impl rule__ConstraintSignature__Group_2_1__1 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4576:2: rule__ConstraintSignature__Group_2_1__0__Impl rule__ConstraintSignature__Group_2_1__1
            {
            pushFollow(FOLLOW_rule__ConstraintSignature__Group_2_1__0__Impl_in_rule__ConstraintSignature__Group_2_1__09245);
            rule__ConstraintSignature__Group_2_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ConstraintSignature__Group_2_1__1_in_rule__ConstraintSignature__Group_2_1__09248);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4583:1: rule__ConstraintSignature__Group_2_1__0__Impl : ( ',' ) ;
    public final void rule__ConstraintSignature__Group_2_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4587:1: ( ( ',' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4588:1: ( ',' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4588:1: ( ',' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4589:1: ','
            {
             before(grammarAccess.getConstraintSignatureAccess().getCommaKeyword_2_1_0()); 
            match(input,29,FOLLOW_29_in_rule__ConstraintSignature__Group_2_1__0__Impl9276); 
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4602:1: rule__ConstraintSignature__Group_2_1__1 : rule__ConstraintSignature__Group_2_1__1__Impl ;
    public final void rule__ConstraintSignature__Group_2_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4606:1: ( rule__ConstraintSignature__Group_2_1__1__Impl )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4607:2: rule__ConstraintSignature__Group_2_1__1__Impl
            {
            pushFollow(FOLLOW_rule__ConstraintSignature__Group_2_1__1__Impl_in_rule__ConstraintSignature__Group_2_1__19307);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4613:1: rule__ConstraintSignature__Group_2_1__1__Impl : ( ( rule__ConstraintSignature__ParameterAssignment_2_1_1 ) ) ;
    public final void rule__ConstraintSignature__Group_2_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4617:1: ( ( ( rule__ConstraintSignature__ParameterAssignment_2_1_1 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4618:1: ( ( rule__ConstraintSignature__ParameterAssignment_2_1_1 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4618:1: ( ( rule__ConstraintSignature__ParameterAssignment_2_1_1 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4619:1: ( rule__ConstraintSignature__ParameterAssignment_2_1_1 )
            {
             before(grammarAccess.getConstraintSignatureAccess().getParameterAssignment_2_1_1()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4620:1: ( rule__ConstraintSignature__ParameterAssignment_2_1_1 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4620:2: rule__ConstraintSignature__ParameterAssignment_2_1_1
            {
            pushFollow(FOLLOW_rule__ConstraintSignature__ParameterAssignment_2_1_1_in_rule__ConstraintSignature__Group_2_1__1__Impl9334);
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


    // $ANTLR start "rule__Morphism__Group__0"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4634:1: rule__Morphism__Group__0 : rule__Morphism__Group__0__Impl rule__Morphism__Group__1 ;
    public final void rule__Morphism__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4638:1: ( rule__Morphism__Group__0__Impl rule__Morphism__Group__1 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4639:2: rule__Morphism__Group__0__Impl rule__Morphism__Group__1
            {
            pushFollow(FOLLOW_rule__Morphism__Group__0__Impl_in_rule__Morphism__Group__09368);
            rule__Morphism__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Morphism__Group__1_in_rule__Morphism__Group__09371);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4646:1: rule__Morphism__Group__0__Impl : ( RULE_ID ) ;
    public final void rule__Morphism__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4650:1: ( ( RULE_ID ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4651:1: ( RULE_ID )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4651:1: ( RULE_ID )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4652:1: RULE_ID
            {
             before(grammarAccess.getMorphismAccess().getIDTerminalRuleCall_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Morphism__Group__0__Impl9398); 
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4663:1: rule__Morphism__Group__1 : rule__Morphism__Group__1__Impl rule__Morphism__Group__2 ;
    public final void rule__Morphism__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4667:1: ( rule__Morphism__Group__1__Impl rule__Morphism__Group__2 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4668:2: rule__Morphism__Group__1__Impl rule__Morphism__Group__2
            {
            pushFollow(FOLLOW_rule__Morphism__Group__1__Impl_in_rule__Morphism__Group__19427);
            rule__Morphism__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Morphism__Group__2_in_rule__Morphism__Group__19430);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4675:1: rule__Morphism__Group__1__Impl : ( ':=' ) ;
    public final void rule__Morphism__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4679:1: ( ( ':=' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4680:1: ( ':=' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4680:1: ( ':=' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4681:1: ':='
            {
             before(grammarAccess.getMorphismAccess().getColonEqualsSignKeyword_1()); 
            match(input,33,FOLLOW_33_in_rule__Morphism__Group__1__Impl9458); 
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4694:1: rule__Morphism__Group__2 : rule__Morphism__Group__2__Impl rule__Morphism__Group__3 ;
    public final void rule__Morphism__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4698:1: ( rule__Morphism__Group__2__Impl rule__Morphism__Group__3 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4699:2: rule__Morphism__Group__2__Impl rule__Morphism__Group__3
            {
            pushFollow(FOLLOW_rule__Morphism__Group__2__Impl_in_rule__Morphism__Group__29489);
            rule__Morphism__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Morphism__Group__3_in_rule__Morphism__Group__29492);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4706:1: rule__Morphism__Group__2__Impl : ( 'Morphism' ) ;
    public final void rule__Morphism__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4710:1: ( ( 'Morphism' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4711:1: ( 'Morphism' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4711:1: ( 'Morphism' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4712:1: 'Morphism'
            {
             before(grammarAccess.getMorphismAccess().getMorphismKeyword_2()); 
            match(input,44,FOLLOW_44_in_rule__Morphism__Group__2__Impl9520); 
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4725:1: rule__Morphism__Group__3 : rule__Morphism__Group__3__Impl rule__Morphism__Group__4 ;
    public final void rule__Morphism__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4729:1: ( rule__Morphism__Group__3__Impl rule__Morphism__Group__4 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4730:2: rule__Morphism__Group__3__Impl rule__Morphism__Group__4
            {
            pushFollow(FOLLOW_rule__Morphism__Group__3__Impl_in_rule__Morphism__Group__39551);
            rule__Morphism__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Morphism__Group__4_in_rule__Morphism__Group__39554);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4737:1: rule__Morphism__Group__3__Impl : ( '<' ) ;
    public final void rule__Morphism__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4741:1: ( ( '<' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4742:1: ( '<' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4742:1: ( '<' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4743:1: '<'
            {
             before(grammarAccess.getMorphismAccess().getLessThanSignKeyword_3()); 
            match(input,35,FOLLOW_35_in_rule__Morphism__Group__3__Impl9582); 
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4756:1: rule__Morphism__Group__4 : rule__Morphism__Group__4__Impl rule__Morphism__Group__5 ;
    public final void rule__Morphism__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4760:1: ( rule__Morphism__Group__4__Impl rule__Morphism__Group__5 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4761:2: rule__Morphism__Group__4__Impl rule__Morphism__Group__5
            {
            pushFollow(FOLLOW_rule__Morphism__Group__4__Impl_in_rule__Morphism__Group__49613);
            rule__Morphism__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Morphism__Group__5_in_rule__Morphism__Group__49616);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4768:1: rule__Morphism__Group__4__Impl : ( ( rule__Morphism__DomainAssignment_4 ) ) ;
    public final void rule__Morphism__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4772:1: ( ( ( rule__Morphism__DomainAssignment_4 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4773:1: ( ( rule__Morphism__DomainAssignment_4 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4773:1: ( ( rule__Morphism__DomainAssignment_4 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4774:1: ( rule__Morphism__DomainAssignment_4 )
            {
             before(grammarAccess.getMorphismAccess().getDomainAssignment_4()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4775:1: ( rule__Morphism__DomainAssignment_4 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4775:2: rule__Morphism__DomainAssignment_4
            {
            pushFollow(FOLLOW_rule__Morphism__DomainAssignment_4_in_rule__Morphism__Group__4__Impl9643);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4785:1: rule__Morphism__Group__5 : rule__Morphism__Group__5__Impl rule__Morphism__Group__6 ;
    public final void rule__Morphism__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4789:1: ( rule__Morphism__Group__5__Impl rule__Morphism__Group__6 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4790:2: rule__Morphism__Group__5__Impl rule__Morphism__Group__6
            {
            pushFollow(FOLLOW_rule__Morphism__Group__5__Impl_in_rule__Morphism__Group__59673);
            rule__Morphism__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Morphism__Group__6_in_rule__Morphism__Group__59676);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4797:1: rule__Morphism__Group__5__Impl : ( ',' ) ;
    public final void rule__Morphism__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4801:1: ( ( ',' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4802:1: ( ',' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4802:1: ( ',' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4803:1: ','
            {
             before(grammarAccess.getMorphismAccess().getCommaKeyword_5()); 
            match(input,29,FOLLOW_29_in_rule__Morphism__Group__5__Impl9704); 
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4816:1: rule__Morphism__Group__6 : rule__Morphism__Group__6__Impl rule__Morphism__Group__7 ;
    public final void rule__Morphism__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4820:1: ( rule__Morphism__Group__6__Impl rule__Morphism__Group__7 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4821:2: rule__Morphism__Group__6__Impl rule__Morphism__Group__7
            {
            pushFollow(FOLLOW_rule__Morphism__Group__6__Impl_in_rule__Morphism__Group__69735);
            rule__Morphism__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Morphism__Group__7_in_rule__Morphism__Group__69738);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4828:1: rule__Morphism__Group__6__Impl : ( ( rule__Morphism__CodmainAssignment_6 ) ) ;
    public final void rule__Morphism__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4832:1: ( ( ( rule__Morphism__CodmainAssignment_6 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4833:1: ( ( rule__Morphism__CodmainAssignment_6 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4833:1: ( ( rule__Morphism__CodmainAssignment_6 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4834:1: ( rule__Morphism__CodmainAssignment_6 )
            {
             before(grammarAccess.getMorphismAccess().getCodmainAssignment_6()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4835:1: ( rule__Morphism__CodmainAssignment_6 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4835:2: rule__Morphism__CodmainAssignment_6
            {
            pushFollow(FOLLOW_rule__Morphism__CodmainAssignment_6_in_rule__Morphism__Group__6__Impl9765);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4845:1: rule__Morphism__Group__7 : rule__Morphism__Group__7__Impl rule__Morphism__Group__8 ;
    public final void rule__Morphism__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4849:1: ( rule__Morphism__Group__7__Impl rule__Morphism__Group__8 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4850:2: rule__Morphism__Group__7__Impl rule__Morphism__Group__8
            {
            pushFollow(FOLLOW_rule__Morphism__Group__7__Impl_in_rule__Morphism__Group__79795);
            rule__Morphism__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Morphism__Group__8_in_rule__Morphism__Group__79798);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4857:1: rule__Morphism__Group__7__Impl : ( '>' ) ;
    public final void rule__Morphism__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4861:1: ( ( '>' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4862:1: ( '>' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4862:1: ( '>' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4863:1: '>'
            {
             before(grammarAccess.getMorphismAccess().getGreaterThanSignKeyword_7()); 
            match(input,36,FOLLOW_36_in_rule__Morphism__Group__7__Impl9826); 
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4876:1: rule__Morphism__Group__8 : rule__Morphism__Group__8__Impl rule__Morphism__Group__9 ;
    public final void rule__Morphism__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4880:1: ( rule__Morphism__Group__8__Impl rule__Morphism__Group__9 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4881:2: rule__Morphism__Group__8__Impl rule__Morphism__Group__9
            {
            pushFollow(FOLLOW_rule__Morphism__Group__8__Impl_in_rule__Morphism__Group__89857);
            rule__Morphism__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Morphism__Group__9_in_rule__Morphism__Group__89860);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4888:1: rule__Morphism__Group__8__Impl : ( '{' ) ;
    public final void rule__Morphism__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4892:1: ( ( '{' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4893:1: ( '{' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4893:1: ( '{' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4894:1: '{'
            {
             before(grammarAccess.getMorphismAccess().getLeftCurlyBracketKeyword_8()); 
            match(input,37,FOLLOW_37_in_rule__Morphism__Group__8__Impl9888); 
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4907:1: rule__Morphism__Group__9 : rule__Morphism__Group__9__Impl rule__Morphism__Group__10 ;
    public final void rule__Morphism__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4911:1: ( rule__Morphism__Group__9__Impl rule__Morphism__Group__10 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4912:2: rule__Morphism__Group__9__Impl rule__Morphism__Group__10
            {
            pushFollow(FOLLOW_rule__Morphism__Group__9__Impl_in_rule__Morphism__Group__99919);
            rule__Morphism__Group__9__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Morphism__Group__10_in_rule__Morphism__Group__99922);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4919:1: rule__Morphism__Group__9__Impl : ( ( rule__Morphism__Group_9__0 )? ) ;
    public final void rule__Morphism__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4923:1: ( ( ( rule__Morphism__Group_9__0 )? ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4924:1: ( ( rule__Morphism__Group_9__0 )? )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4924:1: ( ( rule__Morphism__Group_9__0 )? )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4925:1: ( rule__Morphism__Group_9__0 )?
            {
             before(grammarAccess.getMorphismAccess().getGroup_9()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4926:1: ( rule__Morphism__Group_9__0 )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==RULE_ID) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4926:2: rule__Morphism__Group_9__0
                    {
                    pushFollow(FOLLOW_rule__Morphism__Group_9__0_in_rule__Morphism__Group__9__Impl9949);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4936:1: rule__Morphism__Group__10 : rule__Morphism__Group__10__Impl ;
    public final void rule__Morphism__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4940:1: ( rule__Morphism__Group__10__Impl )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4941:2: rule__Morphism__Group__10__Impl
            {
            pushFollow(FOLLOW_rule__Morphism__Group__10__Impl_in_rule__Morphism__Group__109980);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4947:1: rule__Morphism__Group__10__Impl : ( '}' ) ;
    public final void rule__Morphism__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4951:1: ( ( '}' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4952:1: ( '}' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4952:1: ( '}' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4953:1: '}'
            {
             before(grammarAccess.getMorphismAccess().getRightCurlyBracketKeyword_10()); 
            match(input,38,FOLLOW_38_in_rule__Morphism__Group__10__Impl10008); 
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4988:1: rule__Morphism__Group_9__0 : rule__Morphism__Group_9__0__Impl rule__Morphism__Group_9__1 ;
    public final void rule__Morphism__Group_9__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4992:1: ( rule__Morphism__Group_9__0__Impl rule__Morphism__Group_9__1 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4993:2: rule__Morphism__Group_9__0__Impl rule__Morphism__Group_9__1
            {
            pushFollow(FOLLOW_rule__Morphism__Group_9__0__Impl_in_rule__Morphism__Group_9__010061);
            rule__Morphism__Group_9__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Morphism__Group_9__1_in_rule__Morphism__Group_9__010064);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5000:1: rule__Morphism__Group_9__0__Impl : ( ( rule__Morphism__MappingsAssignment_9_0 ) ) ;
    public final void rule__Morphism__Group_9__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5004:1: ( ( ( rule__Morphism__MappingsAssignment_9_0 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5005:1: ( ( rule__Morphism__MappingsAssignment_9_0 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5005:1: ( ( rule__Morphism__MappingsAssignment_9_0 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5006:1: ( rule__Morphism__MappingsAssignment_9_0 )
            {
             before(grammarAccess.getMorphismAccess().getMappingsAssignment_9_0()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5007:1: ( rule__Morphism__MappingsAssignment_9_0 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5007:2: rule__Morphism__MappingsAssignment_9_0
            {
            pushFollow(FOLLOW_rule__Morphism__MappingsAssignment_9_0_in_rule__Morphism__Group_9__0__Impl10091);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5017:1: rule__Morphism__Group_9__1 : rule__Morphism__Group_9__1__Impl ;
    public final void rule__Morphism__Group_9__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5021:1: ( rule__Morphism__Group_9__1__Impl )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5022:2: rule__Morphism__Group_9__1__Impl
            {
            pushFollow(FOLLOW_rule__Morphism__Group_9__1__Impl_in_rule__Morphism__Group_9__110121);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5028:1: rule__Morphism__Group_9__1__Impl : ( ( rule__Morphism__Group_9_1__0 )* ) ;
    public final void rule__Morphism__Group_9__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5032:1: ( ( ( rule__Morphism__Group_9_1__0 )* ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5033:1: ( ( rule__Morphism__Group_9_1__0 )* )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5033:1: ( ( rule__Morphism__Group_9_1__0 )* )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5034:1: ( rule__Morphism__Group_9_1__0 )*
            {
             before(grammarAccess.getMorphismAccess().getGroup_9_1()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5035:1: ( rule__Morphism__Group_9_1__0 )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==29) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5035:2: rule__Morphism__Group_9_1__0
            	    {
            	    pushFollow(FOLLOW_rule__Morphism__Group_9_1__0_in_rule__Morphism__Group_9__1__Impl10148);
            	    rule__Morphism__Group_9_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop19;
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5049:1: rule__Morphism__Group_9_1__0 : rule__Morphism__Group_9_1__0__Impl rule__Morphism__Group_9_1__1 ;
    public final void rule__Morphism__Group_9_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5053:1: ( rule__Morphism__Group_9_1__0__Impl rule__Morphism__Group_9_1__1 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5054:2: rule__Morphism__Group_9_1__0__Impl rule__Morphism__Group_9_1__1
            {
            pushFollow(FOLLOW_rule__Morphism__Group_9_1__0__Impl_in_rule__Morphism__Group_9_1__010183);
            rule__Morphism__Group_9_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Morphism__Group_9_1__1_in_rule__Morphism__Group_9_1__010186);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5061:1: rule__Morphism__Group_9_1__0__Impl : ( ',' ) ;
    public final void rule__Morphism__Group_9_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5065:1: ( ( ',' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5066:1: ( ',' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5066:1: ( ',' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5067:1: ','
            {
             before(grammarAccess.getMorphismAccess().getCommaKeyword_9_1_0()); 
            match(input,29,FOLLOW_29_in_rule__Morphism__Group_9_1__0__Impl10214); 
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5080:1: rule__Morphism__Group_9_1__1 : rule__Morphism__Group_9_1__1__Impl ;
    public final void rule__Morphism__Group_9_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5084:1: ( rule__Morphism__Group_9_1__1__Impl )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5085:2: rule__Morphism__Group_9_1__1__Impl
            {
            pushFollow(FOLLOW_rule__Morphism__Group_9_1__1__Impl_in_rule__Morphism__Group_9_1__110245);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5091:1: rule__Morphism__Group_9_1__1__Impl : ( ( rule__Morphism__MappingsAssignment_9_1_1 ) ) ;
    public final void rule__Morphism__Group_9_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5095:1: ( ( ( rule__Morphism__MappingsAssignment_9_1_1 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5096:1: ( ( rule__Morphism__MappingsAssignment_9_1_1 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5096:1: ( ( rule__Morphism__MappingsAssignment_9_1_1 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5097:1: ( rule__Morphism__MappingsAssignment_9_1_1 )
            {
             before(grammarAccess.getMorphismAccess().getMappingsAssignment_9_1_1()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5098:1: ( rule__Morphism__MappingsAssignment_9_1_1 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5098:2: rule__Morphism__MappingsAssignment_9_1_1
            {
            pushFollow(FOLLOW_rule__Morphism__MappingsAssignment_9_1_1_in_rule__Morphism__Group_9_1__1__Impl10272);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5112:1: rule__MappingNode__Group__0 : rule__MappingNode__Group__0__Impl rule__MappingNode__Group__1 ;
    public final void rule__MappingNode__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5116:1: ( rule__MappingNode__Group__0__Impl rule__MappingNode__Group__1 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5117:2: rule__MappingNode__Group__0__Impl rule__MappingNode__Group__1
            {
            pushFollow(FOLLOW_rule__MappingNode__Group__0__Impl_in_rule__MappingNode__Group__010306);
            rule__MappingNode__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__MappingNode__Group__1_in_rule__MappingNode__Group__010309);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5124:1: rule__MappingNode__Group__0__Impl : ( ( rule__MappingNode__DomainAssignment_0 ) ) ;
    public final void rule__MappingNode__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5128:1: ( ( ( rule__MappingNode__DomainAssignment_0 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5129:1: ( ( rule__MappingNode__DomainAssignment_0 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5129:1: ( ( rule__MappingNode__DomainAssignment_0 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5130:1: ( rule__MappingNode__DomainAssignment_0 )
            {
             before(grammarAccess.getMappingNodeAccess().getDomainAssignment_0()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5131:1: ( rule__MappingNode__DomainAssignment_0 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5131:2: rule__MappingNode__DomainAssignment_0
            {
            pushFollow(FOLLOW_rule__MappingNode__DomainAssignment_0_in_rule__MappingNode__Group__0__Impl10336);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5141:1: rule__MappingNode__Group__1 : rule__MappingNode__Group__1__Impl rule__MappingNode__Group__2 ;
    public final void rule__MappingNode__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5145:1: ( rule__MappingNode__Group__1__Impl rule__MappingNode__Group__2 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5146:2: rule__MappingNode__Group__1__Impl rule__MappingNode__Group__2
            {
            pushFollow(FOLLOW_rule__MappingNode__Group__1__Impl_in_rule__MappingNode__Group__110366);
            rule__MappingNode__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__MappingNode__Group__2_in_rule__MappingNode__Group__110369);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5153:1: rule__MappingNode__Group__1__Impl : ( '=>' ) ;
    public final void rule__MappingNode__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5157:1: ( ( '=>' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5158:1: ( '=>' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5158:1: ( '=>' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5159:1: '=>'
            {
             before(grammarAccess.getMappingNodeAccess().getEqualsSignGreaterThanSignKeyword_1()); 
            match(input,45,FOLLOW_45_in_rule__MappingNode__Group__1__Impl10397); 
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5172:1: rule__MappingNode__Group__2 : rule__MappingNode__Group__2__Impl ;
    public final void rule__MappingNode__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5176:1: ( rule__MappingNode__Group__2__Impl )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5177:2: rule__MappingNode__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__MappingNode__Group__2__Impl_in_rule__MappingNode__Group__210428);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5183:1: rule__MappingNode__Group__2__Impl : ( ( rule__MappingNode__CodomainAssignment_2 ) ) ;
    public final void rule__MappingNode__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5187:1: ( ( ( rule__MappingNode__CodomainAssignment_2 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5188:1: ( ( rule__MappingNode__CodomainAssignment_2 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5188:1: ( ( rule__MappingNode__CodomainAssignment_2 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5189:1: ( rule__MappingNode__CodomainAssignment_2 )
            {
             before(grammarAccess.getMappingNodeAccess().getCodomainAssignment_2()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5190:1: ( rule__MappingNode__CodomainAssignment_2 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5190:2: rule__MappingNode__CodomainAssignment_2
            {
            pushFollow(FOLLOW_rule__MappingNode__CodomainAssignment_2_in_rule__MappingNode__Group__2__Impl10455);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5206:1: rule__MappingArrow__Group__0 : rule__MappingArrow__Group__0__Impl rule__MappingArrow__Group__1 ;
    public final void rule__MappingArrow__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5210:1: ( rule__MappingArrow__Group__0__Impl rule__MappingArrow__Group__1 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5211:2: rule__MappingArrow__Group__0__Impl rule__MappingArrow__Group__1
            {
            pushFollow(FOLLOW_rule__MappingArrow__Group__0__Impl_in_rule__MappingArrow__Group__010491);
            rule__MappingArrow__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__MappingArrow__Group__1_in_rule__MappingArrow__Group__010494);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5218:1: rule__MappingArrow__Group__0__Impl : ( ( rule__MappingArrow__DomainAssignment_0 ) ) ;
    public final void rule__MappingArrow__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5222:1: ( ( ( rule__MappingArrow__DomainAssignment_0 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5223:1: ( ( rule__MappingArrow__DomainAssignment_0 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5223:1: ( ( rule__MappingArrow__DomainAssignment_0 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5224:1: ( rule__MappingArrow__DomainAssignment_0 )
            {
             before(grammarAccess.getMappingArrowAccess().getDomainAssignment_0()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5225:1: ( rule__MappingArrow__DomainAssignment_0 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5225:2: rule__MappingArrow__DomainAssignment_0
            {
            pushFollow(FOLLOW_rule__MappingArrow__DomainAssignment_0_in_rule__MappingArrow__Group__0__Impl10521);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5235:1: rule__MappingArrow__Group__1 : rule__MappingArrow__Group__1__Impl rule__MappingArrow__Group__2 ;
    public final void rule__MappingArrow__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5239:1: ( rule__MappingArrow__Group__1__Impl rule__MappingArrow__Group__2 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5240:2: rule__MappingArrow__Group__1__Impl rule__MappingArrow__Group__2
            {
            pushFollow(FOLLOW_rule__MappingArrow__Group__1__Impl_in_rule__MappingArrow__Group__110551);
            rule__MappingArrow__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__MappingArrow__Group__2_in_rule__MappingArrow__Group__110554);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5247:1: rule__MappingArrow__Group__1__Impl : ( '=>' ) ;
    public final void rule__MappingArrow__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5251:1: ( ( '=>' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5252:1: ( '=>' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5252:1: ( '=>' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5253:1: '=>'
            {
             before(grammarAccess.getMappingArrowAccess().getEqualsSignGreaterThanSignKeyword_1()); 
            match(input,45,FOLLOW_45_in_rule__MappingArrow__Group__1__Impl10582); 
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5266:1: rule__MappingArrow__Group__2 : rule__MappingArrow__Group__2__Impl ;
    public final void rule__MappingArrow__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5270:1: ( rule__MappingArrow__Group__2__Impl )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5271:2: rule__MappingArrow__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__MappingArrow__Group__2__Impl_in_rule__MappingArrow__Group__210613);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5277:1: rule__MappingArrow__Group__2__Impl : ( ( rule__MappingArrow__CodmainAssignment_2 ) ) ;
    public final void rule__MappingArrow__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5281:1: ( ( ( rule__MappingArrow__CodmainAssignment_2 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5282:1: ( ( rule__MappingArrow__CodmainAssignment_2 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5282:1: ( ( rule__MappingArrow__CodmainAssignment_2 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5283:1: ( rule__MappingArrow__CodmainAssignment_2 )
            {
             before(grammarAccess.getMappingArrowAccess().getCodmainAssignment_2()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5284:1: ( rule__MappingArrow__CodmainAssignment_2 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5284:2: rule__MappingArrow__CodmainAssignment_2
            {
            pushFollow(FOLLOW_rule__MappingArrow__CodmainAssignment_2_in_rule__MappingArrow__Group__2__Impl10640);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5300:1: rule__ExtSubTGraph__Group__0 : rule__ExtSubTGraph__Group__0__Impl rule__ExtSubTGraph__Group__1 ;
    public final void rule__ExtSubTGraph__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5304:1: ( rule__ExtSubTGraph__Group__0__Impl rule__ExtSubTGraph__Group__1 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5305:2: rule__ExtSubTGraph__Group__0__Impl rule__ExtSubTGraph__Group__1
            {
            pushFollow(FOLLOW_rule__ExtSubTGraph__Group__0__Impl_in_rule__ExtSubTGraph__Group__010676);
            rule__ExtSubTGraph__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ExtSubTGraph__Group__1_in_rule__ExtSubTGraph__Group__010679);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5312:1: rule__ExtSubTGraph__Group__0__Impl : ( ( rule__ExtSubTGraph__IdAssignment_0 ) ) ;
    public final void rule__ExtSubTGraph__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5316:1: ( ( ( rule__ExtSubTGraph__IdAssignment_0 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5317:1: ( ( rule__ExtSubTGraph__IdAssignment_0 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5317:1: ( ( rule__ExtSubTGraph__IdAssignment_0 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5318:1: ( rule__ExtSubTGraph__IdAssignment_0 )
            {
             before(grammarAccess.getExtSubTGraphAccess().getIdAssignment_0()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5319:1: ( rule__ExtSubTGraph__IdAssignment_0 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5319:2: rule__ExtSubTGraph__IdAssignment_0
            {
            pushFollow(FOLLOW_rule__ExtSubTGraph__IdAssignment_0_in_rule__ExtSubTGraph__Group__0__Impl10706);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5329:1: rule__ExtSubTGraph__Group__1 : rule__ExtSubTGraph__Group__1__Impl rule__ExtSubTGraph__Group__2 ;
    public final void rule__ExtSubTGraph__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5333:1: ( rule__ExtSubTGraph__Group__1__Impl rule__ExtSubTGraph__Group__2 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5334:2: rule__ExtSubTGraph__Group__1__Impl rule__ExtSubTGraph__Group__2
            {
            pushFollow(FOLLOW_rule__ExtSubTGraph__Group__1__Impl_in_rule__ExtSubTGraph__Group__110736);
            rule__ExtSubTGraph__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ExtSubTGraph__Group__2_in_rule__ExtSubTGraph__Group__110739);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5341:1: rule__ExtSubTGraph__Group__1__Impl : ( ':=' ) ;
    public final void rule__ExtSubTGraph__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5345:1: ( ( ':=' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5346:1: ( ':=' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5346:1: ( ':=' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5347:1: ':='
            {
             before(grammarAccess.getExtSubTGraphAccess().getColonEqualsSignKeyword_1()); 
            match(input,33,FOLLOW_33_in_rule__ExtSubTGraph__Group__1__Impl10767); 
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5360:1: rule__ExtSubTGraph__Group__2 : rule__ExtSubTGraph__Group__2__Impl rule__ExtSubTGraph__Group__3 ;
    public final void rule__ExtSubTGraph__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5364:1: ( rule__ExtSubTGraph__Group__2__Impl rule__ExtSubTGraph__Group__3 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5365:2: rule__ExtSubTGraph__Group__2__Impl rule__ExtSubTGraph__Group__3
            {
            pushFollow(FOLLOW_rule__ExtSubTGraph__Group__2__Impl_in_rule__ExtSubTGraph__Group__210798);
            rule__ExtSubTGraph__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ExtSubTGraph__Group__3_in_rule__ExtSubTGraph__Group__210801);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5372:1: rule__ExtSubTGraph__Group__2__Impl : ( 'ExtSubTGraph' ) ;
    public final void rule__ExtSubTGraph__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5376:1: ( ( 'ExtSubTGraph' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5377:1: ( 'ExtSubTGraph' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5377:1: ( 'ExtSubTGraph' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5378:1: 'ExtSubTGraph'
            {
             before(grammarAccess.getExtSubTGraphAccess().getExtSubTGraphKeyword_2()); 
            match(input,46,FOLLOW_46_in_rule__ExtSubTGraph__Group__2__Impl10829); 
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5391:1: rule__ExtSubTGraph__Group__3 : rule__ExtSubTGraph__Group__3__Impl rule__ExtSubTGraph__Group__4 ;
    public final void rule__ExtSubTGraph__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5395:1: ( rule__ExtSubTGraph__Group__3__Impl rule__ExtSubTGraph__Group__4 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5396:2: rule__ExtSubTGraph__Group__3__Impl rule__ExtSubTGraph__Group__4
            {
            pushFollow(FOLLOW_rule__ExtSubTGraph__Group__3__Impl_in_rule__ExtSubTGraph__Group__310860);
            rule__ExtSubTGraph__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ExtSubTGraph__Group__4_in_rule__ExtSubTGraph__Group__310863);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5403:1: rule__ExtSubTGraph__Group__3__Impl : ( '<' ) ;
    public final void rule__ExtSubTGraph__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5407:1: ( ( '<' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5408:1: ( '<' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5408:1: ( '<' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5409:1: '<'
            {
             before(grammarAccess.getExtSubTGraphAccess().getLessThanSignKeyword_3()); 
            match(input,35,FOLLOW_35_in_rule__ExtSubTGraph__Group__3__Impl10891); 
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5422:1: rule__ExtSubTGraph__Group__4 : rule__ExtSubTGraph__Group__4__Impl rule__ExtSubTGraph__Group__5 ;
    public final void rule__ExtSubTGraph__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5426:1: ( rule__ExtSubTGraph__Group__4__Impl rule__ExtSubTGraph__Group__5 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5427:2: rule__ExtSubTGraph__Group__4__Impl rule__ExtSubTGraph__Group__5
            {
            pushFollow(FOLLOW_rule__ExtSubTGraph__Group__4__Impl_in_rule__ExtSubTGraph__Group__410922);
            rule__ExtSubTGraph__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ExtSubTGraph__Group__5_in_rule__ExtSubTGraph__Group__410925);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5434:1: rule__ExtSubTGraph__Group__4__Impl : ( ( rule__ExtSubTGraph__ExtendsGraphAssignment_4 ) ) ;
    public final void rule__ExtSubTGraph__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5438:1: ( ( ( rule__ExtSubTGraph__ExtendsGraphAssignment_4 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5439:1: ( ( rule__ExtSubTGraph__ExtendsGraphAssignment_4 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5439:1: ( ( rule__ExtSubTGraph__ExtendsGraphAssignment_4 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5440:1: ( rule__ExtSubTGraph__ExtendsGraphAssignment_4 )
            {
             before(grammarAccess.getExtSubTGraphAccess().getExtendsGraphAssignment_4()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5441:1: ( rule__ExtSubTGraph__ExtendsGraphAssignment_4 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5441:2: rule__ExtSubTGraph__ExtendsGraphAssignment_4
            {
            pushFollow(FOLLOW_rule__ExtSubTGraph__ExtendsGraphAssignment_4_in_rule__ExtSubTGraph__Group__4__Impl10952);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5451:1: rule__ExtSubTGraph__Group__5 : rule__ExtSubTGraph__Group__5__Impl rule__ExtSubTGraph__Group__6 ;
    public final void rule__ExtSubTGraph__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5455:1: ( rule__ExtSubTGraph__Group__5__Impl rule__ExtSubTGraph__Group__6 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5456:2: rule__ExtSubTGraph__Group__5__Impl rule__ExtSubTGraph__Group__6
            {
            pushFollow(FOLLOW_rule__ExtSubTGraph__Group__5__Impl_in_rule__ExtSubTGraph__Group__510982);
            rule__ExtSubTGraph__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ExtSubTGraph__Group__6_in_rule__ExtSubTGraph__Group__510985);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5463:1: rule__ExtSubTGraph__Group__5__Impl : ( '>' ) ;
    public final void rule__ExtSubTGraph__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5467:1: ( ( '>' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5468:1: ( '>' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5468:1: ( '>' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5469:1: '>'
            {
             before(grammarAccess.getExtSubTGraphAccess().getGreaterThanSignKeyword_5()); 
            match(input,36,FOLLOW_36_in_rule__ExtSubTGraph__Group__5__Impl11013); 
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5482:1: rule__ExtSubTGraph__Group__6 : rule__ExtSubTGraph__Group__6__Impl rule__ExtSubTGraph__Group__7 ;
    public final void rule__ExtSubTGraph__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5486:1: ( rule__ExtSubTGraph__Group__6__Impl rule__ExtSubTGraph__Group__7 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5487:2: rule__ExtSubTGraph__Group__6__Impl rule__ExtSubTGraph__Group__7
            {
            pushFollow(FOLLOW_rule__ExtSubTGraph__Group__6__Impl_in_rule__ExtSubTGraph__Group__611044);
            rule__ExtSubTGraph__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ExtSubTGraph__Group__7_in_rule__ExtSubTGraph__Group__611047);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5494:1: rule__ExtSubTGraph__Group__6__Impl : ( '{' ) ;
    public final void rule__ExtSubTGraph__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5498:1: ( ( '{' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5499:1: ( '{' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5499:1: ( '{' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5500:1: '{'
            {
             before(grammarAccess.getExtSubTGraphAccess().getLeftCurlyBracketKeyword_6()); 
            match(input,37,FOLLOW_37_in_rule__ExtSubTGraph__Group__6__Impl11075); 
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5513:1: rule__ExtSubTGraph__Group__7 : rule__ExtSubTGraph__Group__7__Impl rule__ExtSubTGraph__Group__8 ;
    public final void rule__ExtSubTGraph__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5517:1: ( rule__ExtSubTGraph__Group__7__Impl rule__ExtSubTGraph__Group__8 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5518:2: rule__ExtSubTGraph__Group__7__Impl rule__ExtSubTGraph__Group__8
            {
            pushFollow(FOLLOW_rule__ExtSubTGraph__Group__7__Impl_in_rule__ExtSubTGraph__Group__711106);
            rule__ExtSubTGraph__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ExtSubTGraph__Group__8_in_rule__ExtSubTGraph__Group__711109);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5525:1: rule__ExtSubTGraph__Group__7__Impl : ( ( rule__ExtSubTGraph__ElementsAssignment_7 )* ) ;
    public final void rule__ExtSubTGraph__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5529:1: ( ( ( rule__ExtSubTGraph__ElementsAssignment_7 )* ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5530:1: ( ( rule__ExtSubTGraph__ElementsAssignment_7 )* )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5530:1: ( ( rule__ExtSubTGraph__ElementsAssignment_7 )* )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5531:1: ( rule__ExtSubTGraph__ElementsAssignment_7 )*
            {
             before(grammarAccess.getExtSubTGraphAccess().getElementsAssignment_7()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5532:1: ( rule__ExtSubTGraph__ElementsAssignment_7 )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==RULE_ID) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5532:2: rule__ExtSubTGraph__ElementsAssignment_7
            	    {
            	    pushFollow(FOLLOW_rule__ExtSubTGraph__ElementsAssignment_7_in_rule__ExtSubTGraph__Group__7__Impl11136);
            	    rule__ExtSubTGraph__ElementsAssignment_7();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);

             after(grammarAccess.getExtSubTGraphAccess().getElementsAssignment_7()); 

            }


            }

        }
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5542:1: rule__ExtSubTGraph__Group__8 : rule__ExtSubTGraph__Group__8__Impl ;
    public final void rule__ExtSubTGraph__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5546:1: ( rule__ExtSubTGraph__Group__8__Impl )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5547:2: rule__ExtSubTGraph__Group__8__Impl
            {
            pushFollow(FOLLOW_rule__ExtSubTGraph__Group__8__Impl_in_rule__ExtSubTGraph__Group__811167);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5553:1: rule__ExtSubTGraph__Group__8__Impl : ( '}' ) ;
    public final void rule__ExtSubTGraph__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5557:1: ( ( '}' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5558:1: ( '}' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5558:1: ( '}' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5559:1: '}'
            {
             before(grammarAccess.getExtSubTGraphAccess().getRightCurlyBracketKeyword_8()); 
            match(input,38,FOLLOW_38_in_rule__ExtSubTGraph__Group__8__Impl11195); 
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


    // $ANTLR start "rule__Graph__Group__0"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5590:1: rule__Graph__Group__0 : rule__Graph__Group__0__Impl rule__Graph__Group__1 ;
    public final void rule__Graph__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5594:1: ( rule__Graph__Group__0__Impl rule__Graph__Group__1 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5595:2: rule__Graph__Group__0__Impl rule__Graph__Group__1
            {
            pushFollow(FOLLOW_rule__Graph__Group__0__Impl_in_rule__Graph__Group__011244);
            rule__Graph__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Graph__Group__1_in_rule__Graph__Group__011247);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5602:1: rule__Graph__Group__0__Impl : ( 'Graph' ) ;
    public final void rule__Graph__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5606:1: ( ( 'Graph' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5607:1: ( 'Graph' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5607:1: ( 'Graph' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5608:1: 'Graph'
            {
             before(grammarAccess.getGraphAccess().getGraphKeyword_0()); 
            match(input,47,FOLLOW_47_in_rule__Graph__Group__0__Impl11275); 
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5621:1: rule__Graph__Group__1 : rule__Graph__Group__1__Impl rule__Graph__Group__2 ;
    public final void rule__Graph__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5625:1: ( rule__Graph__Group__1__Impl rule__Graph__Group__2 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5626:2: rule__Graph__Group__1__Impl rule__Graph__Group__2
            {
            pushFollow(FOLLOW_rule__Graph__Group__1__Impl_in_rule__Graph__Group__111306);
            rule__Graph__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Graph__Group__2_in_rule__Graph__Group__111309);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5633:1: rule__Graph__Group__1__Impl : ( '{' ) ;
    public final void rule__Graph__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5637:1: ( ( '{' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5638:1: ( '{' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5638:1: ( '{' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5639:1: '{'
            {
             before(grammarAccess.getGraphAccess().getLeftCurlyBracketKeyword_1()); 
            match(input,37,FOLLOW_37_in_rule__Graph__Group__1__Impl11337); 
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5652:1: rule__Graph__Group__2 : rule__Graph__Group__2__Impl rule__Graph__Group__3 ;
    public final void rule__Graph__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5656:1: ( rule__Graph__Group__2__Impl rule__Graph__Group__3 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5657:2: rule__Graph__Group__2__Impl rule__Graph__Group__3
            {
            pushFollow(FOLLOW_rule__Graph__Group__2__Impl_in_rule__Graph__Group__211368);
            rule__Graph__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Graph__Group__3_in_rule__Graph__Group__211371);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5664:1: rule__Graph__Group__2__Impl : ( ( rule__Graph__ElementsAssignment_2 )* ) ;
    public final void rule__Graph__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5668:1: ( ( ( rule__Graph__ElementsAssignment_2 )* ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5669:1: ( ( rule__Graph__ElementsAssignment_2 )* )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5669:1: ( ( rule__Graph__ElementsAssignment_2 )* )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5670:1: ( rule__Graph__ElementsAssignment_2 )*
            {
             before(grammarAccess.getGraphAccess().getElementsAssignment_2()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5671:1: ( rule__Graph__ElementsAssignment_2 )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==RULE_ID) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5671:2: rule__Graph__ElementsAssignment_2
            	    {
            	    pushFollow(FOLLOW_rule__Graph__ElementsAssignment_2_in_rule__Graph__Group__2__Impl11398);
            	    rule__Graph__ElementsAssignment_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);

             after(grammarAccess.getGraphAccess().getElementsAssignment_2()); 

            }


            }

        }
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5681:1: rule__Graph__Group__3 : rule__Graph__Group__3__Impl ;
    public final void rule__Graph__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5685:1: ( rule__Graph__Group__3__Impl )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5686:2: rule__Graph__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__Graph__Group__3__Impl_in_rule__Graph__Group__311429);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5692:1: rule__Graph__Group__3__Impl : ( '}' ) ;
    public final void rule__Graph__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5696:1: ( ( '}' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5697:1: ( '}' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5697:1: ( '}' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5698:1: '}'
            {
             before(grammarAccess.getGraphAccess().getRightCurlyBracketKeyword_3()); 
            match(input,38,FOLLOW_38_in_rule__Graph__Group__3__Impl11457); 
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


    // $ANTLR start "rule__Element__Group_0__0"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5719:1: rule__Element__Group_0__0 : rule__Element__Group_0__0__Impl rule__Element__Group_0__1 ;
    public final void rule__Element__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5723:1: ( rule__Element__Group_0__0__Impl rule__Element__Group_0__1 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5724:2: rule__Element__Group_0__0__Impl rule__Element__Group_0__1
            {
            pushFollow(FOLLOW_rule__Element__Group_0__0__Impl_in_rule__Element__Group_0__011496);
            rule__Element__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Element__Group_0__1_in_rule__Element__Group_0__011499);
            rule__Element__Group_0__1();

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
    // $ANTLR end "rule__Element__Group_0__0"


    // $ANTLR start "rule__Element__Group_0__0__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5731:1: rule__Element__Group_0__0__Impl : ( ruleNode ) ;
    public final void rule__Element__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5735:1: ( ( ruleNode ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5736:1: ( ruleNode )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5736:1: ( ruleNode )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5737:1: ruleNode
            {
             before(grammarAccess.getElementAccess().getNodeParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleNode_in_rule__Element__Group_0__0__Impl11526);
            ruleNode();

            state._fsp--;

             after(grammarAccess.getElementAccess().getNodeParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Element__Group_0__0__Impl"


    // $ANTLR start "rule__Element__Group_0__1"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5748:1: rule__Element__Group_0__1 : rule__Element__Group_0__1__Impl ;
    public final void rule__Element__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5752:1: ( rule__Element__Group_0__1__Impl )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5753:2: rule__Element__Group_0__1__Impl
            {
            pushFollow(FOLLOW_rule__Element__Group_0__1__Impl_in_rule__Element__Group_0__111555);
            rule__Element__Group_0__1__Impl();

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
    // $ANTLR end "rule__Element__Group_0__1"


    // $ANTLR start "rule__Element__Group_0__1__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5759:1: rule__Element__Group_0__1__Impl : ( ',' ) ;
    public final void rule__Element__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5763:1: ( ( ',' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5764:1: ( ',' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5764:1: ( ',' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5765:1: ','
            {
             before(grammarAccess.getElementAccess().getCommaKeyword_0_1()); 
            match(input,29,FOLLOW_29_in_rule__Element__Group_0__1__Impl11583); 
             after(grammarAccess.getElementAccess().getCommaKeyword_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Element__Group_0__1__Impl"


    // $ANTLR start "rule__Element__Group_1__0"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5782:1: rule__Element__Group_1__0 : rule__Element__Group_1__0__Impl rule__Element__Group_1__1 ;
    public final void rule__Element__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5786:1: ( rule__Element__Group_1__0__Impl rule__Element__Group_1__1 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5787:2: rule__Element__Group_1__0__Impl rule__Element__Group_1__1
            {
            pushFollow(FOLLOW_rule__Element__Group_1__0__Impl_in_rule__Element__Group_1__011618);
            rule__Element__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Element__Group_1__1_in_rule__Element__Group_1__011621);
            rule__Element__Group_1__1();

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
    // $ANTLR end "rule__Element__Group_1__0"


    // $ANTLR start "rule__Element__Group_1__0__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5794:1: rule__Element__Group_1__0__Impl : ( ruleArrows ) ;
    public final void rule__Element__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5798:1: ( ( ruleArrows ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5799:1: ( ruleArrows )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5799:1: ( ruleArrows )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5800:1: ruleArrows
            {
             before(grammarAccess.getElementAccess().getArrowsParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleArrows_in_rule__Element__Group_1__0__Impl11648);
            ruleArrows();

            state._fsp--;

             after(grammarAccess.getElementAccess().getArrowsParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Element__Group_1__0__Impl"


    // $ANTLR start "rule__Element__Group_1__1"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5811:1: rule__Element__Group_1__1 : rule__Element__Group_1__1__Impl ;
    public final void rule__Element__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5815:1: ( rule__Element__Group_1__1__Impl )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5816:2: rule__Element__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__Element__Group_1__1__Impl_in_rule__Element__Group_1__111677);
            rule__Element__Group_1__1__Impl();

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
    // $ANTLR end "rule__Element__Group_1__1"


    // $ANTLR start "rule__Element__Group_1__1__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5822:1: rule__Element__Group_1__1__Impl : ( ',' ) ;
    public final void rule__Element__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5826:1: ( ( ',' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5827:1: ( ',' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5827:1: ( ',' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5828:1: ','
            {
             before(grammarAccess.getElementAccess().getCommaKeyword_1_1()); 
            match(input,29,FOLLOW_29_in_rule__Element__Group_1__1__Impl11705); 
             after(grammarAccess.getElementAccess().getCommaKeyword_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Element__Group_1__1__Impl"


    // $ANTLR start "rule__Arrows__Group_0__0"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5845:1: rule__Arrows__Group_0__0 : rule__Arrows__Group_0__0__Impl rule__Arrows__Group_0__1 ;
    public final void rule__Arrows__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5849:1: ( rule__Arrows__Group_0__0__Impl rule__Arrows__Group_0__1 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5850:2: rule__Arrows__Group_0__0__Impl rule__Arrows__Group_0__1
            {
            pushFollow(FOLLOW_rule__Arrows__Group_0__0__Impl_in_rule__Arrows__Group_0__011740);
            rule__Arrows__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Arrows__Group_0__1_in_rule__Arrows__Group_0__011743);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5857:1: rule__Arrows__Group_0__0__Impl : ( ( rule__Arrows__SrAssignment_0_0 ) ) ;
    public final void rule__Arrows__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5861:1: ( ( ( rule__Arrows__SrAssignment_0_0 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5862:1: ( ( rule__Arrows__SrAssignment_0_0 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5862:1: ( ( rule__Arrows__SrAssignment_0_0 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5863:1: ( rule__Arrows__SrAssignment_0_0 )
            {
             before(grammarAccess.getArrowsAccess().getSrAssignment_0_0()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5864:1: ( rule__Arrows__SrAssignment_0_0 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5864:2: rule__Arrows__SrAssignment_0_0
            {
            pushFollow(FOLLOW_rule__Arrows__SrAssignment_0_0_in_rule__Arrows__Group_0__0__Impl11770);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5874:1: rule__Arrows__Group_0__1 : rule__Arrows__Group_0__1__Impl rule__Arrows__Group_0__2 ;
    public final void rule__Arrows__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5878:1: ( rule__Arrows__Group_0__1__Impl rule__Arrows__Group_0__2 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5879:2: rule__Arrows__Group_0__1__Impl rule__Arrows__Group_0__2
            {
            pushFollow(FOLLOW_rule__Arrows__Group_0__1__Impl_in_rule__Arrows__Group_0__111800);
            rule__Arrows__Group_0__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Arrows__Group_0__2_in_rule__Arrows__Group_0__111803);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5886:1: rule__Arrows__Group_0__1__Impl : ( '-' ) ;
    public final void rule__Arrows__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5890:1: ( ( '-' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5891:1: ( '-' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5891:1: ( '-' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5892:1: '-'
            {
             before(grammarAccess.getArrowsAccess().getHyphenMinusKeyword_0_1()); 
            match(input,48,FOLLOW_48_in_rule__Arrows__Group_0__1__Impl11831); 
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5905:1: rule__Arrows__Group_0__2 : rule__Arrows__Group_0__2__Impl rule__Arrows__Group_0__3 ;
    public final void rule__Arrows__Group_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5909:1: ( rule__Arrows__Group_0__2__Impl rule__Arrows__Group_0__3 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5910:2: rule__Arrows__Group_0__2__Impl rule__Arrows__Group_0__3
            {
            pushFollow(FOLLOW_rule__Arrows__Group_0__2__Impl_in_rule__Arrows__Group_0__211862);
            rule__Arrows__Group_0__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Arrows__Group_0__3_in_rule__Arrows__Group_0__211865);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5917:1: rule__Arrows__Group_0__2__Impl : ( ( rule__Arrows__IdAssignment_0_2 ) ) ;
    public final void rule__Arrows__Group_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5921:1: ( ( ( rule__Arrows__IdAssignment_0_2 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5922:1: ( ( rule__Arrows__IdAssignment_0_2 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5922:1: ( ( rule__Arrows__IdAssignment_0_2 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5923:1: ( rule__Arrows__IdAssignment_0_2 )
            {
             before(grammarAccess.getArrowsAccess().getIdAssignment_0_2()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5924:1: ( rule__Arrows__IdAssignment_0_2 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5924:2: rule__Arrows__IdAssignment_0_2
            {
            pushFollow(FOLLOW_rule__Arrows__IdAssignment_0_2_in_rule__Arrows__Group_0__2__Impl11892);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5934:1: rule__Arrows__Group_0__3 : rule__Arrows__Group_0__3__Impl rule__Arrows__Group_0__4 ;
    public final void rule__Arrows__Group_0__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5938:1: ( rule__Arrows__Group_0__3__Impl rule__Arrows__Group_0__4 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5939:2: rule__Arrows__Group_0__3__Impl rule__Arrows__Group_0__4
            {
            pushFollow(FOLLOW_rule__Arrows__Group_0__3__Impl_in_rule__Arrows__Group_0__311922);
            rule__Arrows__Group_0__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Arrows__Group_0__4_in_rule__Arrows__Group_0__311925);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5946:1: rule__Arrows__Group_0__3__Impl : ( ':' ) ;
    public final void rule__Arrows__Group_0__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5950:1: ( ( ':' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5951:1: ( ':' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5951:1: ( ':' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5952:1: ':'
            {
             before(grammarAccess.getArrowsAccess().getColonKeyword_0_3()); 
            match(input,41,FOLLOW_41_in_rule__Arrows__Group_0__3__Impl11953); 
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5965:1: rule__Arrows__Group_0__4 : rule__Arrows__Group_0__4__Impl rule__Arrows__Group_0__5 ;
    public final void rule__Arrows__Group_0__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5969:1: ( rule__Arrows__Group_0__4__Impl rule__Arrows__Group_0__5 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5970:2: rule__Arrows__Group_0__4__Impl rule__Arrows__Group_0__5
            {
            pushFollow(FOLLOW_rule__Arrows__Group_0__4__Impl_in_rule__Arrows__Group_0__411984);
            rule__Arrows__Group_0__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Arrows__Group_0__5_in_rule__Arrows__Group_0__411987);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5977:1: rule__Arrows__Group_0__4__Impl : ( ( rule__Arrows__TypeAssignment_0_4 ) ) ;
    public final void rule__Arrows__Group_0__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5981:1: ( ( ( rule__Arrows__TypeAssignment_0_4 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5982:1: ( ( rule__Arrows__TypeAssignment_0_4 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5982:1: ( ( rule__Arrows__TypeAssignment_0_4 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5983:1: ( rule__Arrows__TypeAssignment_0_4 )
            {
             before(grammarAccess.getArrowsAccess().getTypeAssignment_0_4()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5984:1: ( rule__Arrows__TypeAssignment_0_4 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5984:2: rule__Arrows__TypeAssignment_0_4
            {
            pushFollow(FOLLOW_rule__Arrows__TypeAssignment_0_4_in_rule__Arrows__Group_0__4__Impl12014);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5994:1: rule__Arrows__Group_0__5 : rule__Arrows__Group_0__5__Impl rule__Arrows__Group_0__6 ;
    public final void rule__Arrows__Group_0__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5998:1: ( rule__Arrows__Group_0__5__Impl rule__Arrows__Group_0__6 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5999:2: rule__Arrows__Group_0__5__Impl rule__Arrows__Group_0__6
            {
            pushFollow(FOLLOW_rule__Arrows__Group_0__5__Impl_in_rule__Arrows__Group_0__512044);
            rule__Arrows__Group_0__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Arrows__Group_0__6_in_rule__Arrows__Group_0__512047);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6006:1: rule__Arrows__Group_0__5__Impl : ( '->' ) ;
    public final void rule__Arrows__Group_0__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6010:1: ( ( '->' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6011:1: ( '->' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6011:1: ( '->' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6012:1: '->'
            {
             before(grammarAccess.getArrowsAccess().getHyphenMinusGreaterThanSignKeyword_0_5()); 
            match(input,28,FOLLOW_28_in_rule__Arrows__Group_0__5__Impl12075); 
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6025:1: rule__Arrows__Group_0__6 : rule__Arrows__Group_0__6__Impl ;
    public final void rule__Arrows__Group_0__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6029:1: ( rule__Arrows__Group_0__6__Impl )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6030:2: rule__Arrows__Group_0__6__Impl
            {
            pushFollow(FOLLOW_rule__Arrows__Group_0__6__Impl_in_rule__Arrows__Group_0__612106);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6036:1: rule__Arrows__Group_0__6__Impl : ( ( rule__Arrows__NextAssignment_0_6 ) ) ;
    public final void rule__Arrows__Group_0__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6040:1: ( ( ( rule__Arrows__NextAssignment_0_6 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6041:1: ( ( rule__Arrows__NextAssignment_0_6 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6041:1: ( ( rule__Arrows__NextAssignment_0_6 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6042:1: ( rule__Arrows__NextAssignment_0_6 )
            {
             before(grammarAccess.getArrowsAccess().getNextAssignment_0_6()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6043:1: ( rule__Arrows__NextAssignment_0_6 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6043:2: rule__Arrows__NextAssignment_0_6
            {
            pushFollow(FOLLOW_rule__Arrows__NextAssignment_0_6_in_rule__Arrows__Group_0__6__Impl12133);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6067:1: rule__Arrow__Group_0__0 : rule__Arrow__Group_0__0__Impl rule__Arrow__Group_0__1 ;
    public final void rule__Arrow__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6071:1: ( rule__Arrow__Group_0__0__Impl rule__Arrow__Group_0__1 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6072:2: rule__Arrow__Group_0__0__Impl rule__Arrow__Group_0__1
            {
            pushFollow(FOLLOW_rule__Arrow__Group_0__0__Impl_in_rule__Arrow__Group_0__012177);
            rule__Arrow__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Arrow__Group_0__1_in_rule__Arrow__Group_0__012180);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6079:1: rule__Arrow__Group_0__0__Impl : ( ( rule__Arrow__SrAssignment_0_0 ) ) ;
    public final void rule__Arrow__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6083:1: ( ( ( rule__Arrow__SrAssignment_0_0 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6084:1: ( ( rule__Arrow__SrAssignment_0_0 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6084:1: ( ( rule__Arrow__SrAssignment_0_0 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6085:1: ( rule__Arrow__SrAssignment_0_0 )
            {
             before(grammarAccess.getArrowAccess().getSrAssignment_0_0()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6086:1: ( rule__Arrow__SrAssignment_0_0 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6086:2: rule__Arrow__SrAssignment_0_0
            {
            pushFollow(FOLLOW_rule__Arrow__SrAssignment_0_0_in_rule__Arrow__Group_0__0__Impl12207);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6096:1: rule__Arrow__Group_0__1 : rule__Arrow__Group_0__1__Impl rule__Arrow__Group_0__2 ;
    public final void rule__Arrow__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6100:1: ( rule__Arrow__Group_0__1__Impl rule__Arrow__Group_0__2 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6101:2: rule__Arrow__Group_0__1__Impl rule__Arrow__Group_0__2
            {
            pushFollow(FOLLOW_rule__Arrow__Group_0__1__Impl_in_rule__Arrow__Group_0__112237);
            rule__Arrow__Group_0__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Arrow__Group_0__2_in_rule__Arrow__Group_0__112240);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6108:1: rule__Arrow__Group_0__1__Impl : ( '-' ) ;
    public final void rule__Arrow__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6112:1: ( ( '-' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6113:1: ( '-' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6113:1: ( '-' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6114:1: '-'
            {
             before(grammarAccess.getArrowAccess().getHyphenMinusKeyword_0_1()); 
            match(input,48,FOLLOW_48_in_rule__Arrow__Group_0__1__Impl12268); 
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6127:1: rule__Arrow__Group_0__2 : rule__Arrow__Group_0__2__Impl rule__Arrow__Group_0__3 ;
    public final void rule__Arrow__Group_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6131:1: ( rule__Arrow__Group_0__2__Impl rule__Arrow__Group_0__3 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6132:2: rule__Arrow__Group_0__2__Impl rule__Arrow__Group_0__3
            {
            pushFollow(FOLLOW_rule__Arrow__Group_0__2__Impl_in_rule__Arrow__Group_0__212299);
            rule__Arrow__Group_0__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Arrow__Group_0__3_in_rule__Arrow__Group_0__212302);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6139:1: rule__Arrow__Group_0__2__Impl : ( ( rule__Arrow__IdAssignment_0_2 ) ) ;
    public final void rule__Arrow__Group_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6143:1: ( ( ( rule__Arrow__IdAssignment_0_2 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6144:1: ( ( rule__Arrow__IdAssignment_0_2 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6144:1: ( ( rule__Arrow__IdAssignment_0_2 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6145:1: ( rule__Arrow__IdAssignment_0_2 )
            {
             before(grammarAccess.getArrowAccess().getIdAssignment_0_2()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6146:1: ( rule__Arrow__IdAssignment_0_2 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6146:2: rule__Arrow__IdAssignment_0_2
            {
            pushFollow(FOLLOW_rule__Arrow__IdAssignment_0_2_in_rule__Arrow__Group_0__2__Impl12329);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6156:1: rule__Arrow__Group_0__3 : rule__Arrow__Group_0__3__Impl rule__Arrow__Group_0__4 ;
    public final void rule__Arrow__Group_0__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6160:1: ( rule__Arrow__Group_0__3__Impl rule__Arrow__Group_0__4 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6161:2: rule__Arrow__Group_0__3__Impl rule__Arrow__Group_0__4
            {
            pushFollow(FOLLOW_rule__Arrow__Group_0__3__Impl_in_rule__Arrow__Group_0__312359);
            rule__Arrow__Group_0__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Arrow__Group_0__4_in_rule__Arrow__Group_0__312362);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6168:1: rule__Arrow__Group_0__3__Impl : ( ':' ) ;
    public final void rule__Arrow__Group_0__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6172:1: ( ( ':' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6173:1: ( ':' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6173:1: ( ':' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6174:1: ':'
            {
             before(grammarAccess.getArrowAccess().getColonKeyword_0_3()); 
            match(input,41,FOLLOW_41_in_rule__Arrow__Group_0__3__Impl12390); 
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6187:1: rule__Arrow__Group_0__4 : rule__Arrow__Group_0__4__Impl rule__Arrow__Group_0__5 ;
    public final void rule__Arrow__Group_0__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6191:1: ( rule__Arrow__Group_0__4__Impl rule__Arrow__Group_0__5 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6192:2: rule__Arrow__Group_0__4__Impl rule__Arrow__Group_0__5
            {
            pushFollow(FOLLOW_rule__Arrow__Group_0__4__Impl_in_rule__Arrow__Group_0__412421);
            rule__Arrow__Group_0__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Arrow__Group_0__5_in_rule__Arrow__Group_0__412424);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6199:1: rule__Arrow__Group_0__4__Impl : ( '*' ) ;
    public final void rule__Arrow__Group_0__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6203:1: ( ( '*' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6204:1: ( '*' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6204:1: ( '*' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6205:1: '*'
            {
             before(grammarAccess.getArrowAccess().getAsteriskKeyword_0_4()); 
            match(input,49,FOLLOW_49_in_rule__Arrow__Group_0__4__Impl12452); 
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6218:1: rule__Arrow__Group_0__5 : rule__Arrow__Group_0__5__Impl rule__Arrow__Group_0__6 ;
    public final void rule__Arrow__Group_0__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6222:1: ( rule__Arrow__Group_0__5__Impl rule__Arrow__Group_0__6 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6223:2: rule__Arrow__Group_0__5__Impl rule__Arrow__Group_0__6
            {
            pushFollow(FOLLOW_rule__Arrow__Group_0__5__Impl_in_rule__Arrow__Group_0__512483);
            rule__Arrow__Group_0__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Arrow__Group_0__6_in_rule__Arrow__Group_0__512486);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6230:1: rule__Arrow__Group_0__5__Impl : ( '->' ) ;
    public final void rule__Arrow__Group_0__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6234:1: ( ( '->' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6235:1: ( '->' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6235:1: ( '->' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6236:1: '->'
            {
             before(grammarAccess.getArrowAccess().getHyphenMinusGreaterThanSignKeyword_0_5()); 
            match(input,28,FOLLOW_28_in_rule__Arrow__Group_0__5__Impl12514); 
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6249:1: rule__Arrow__Group_0__6 : rule__Arrow__Group_0__6__Impl ;
    public final void rule__Arrow__Group_0__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6253:1: ( rule__Arrow__Group_0__6__Impl )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6254:2: rule__Arrow__Group_0__6__Impl
            {
            pushFollow(FOLLOW_rule__Arrow__Group_0__6__Impl_in_rule__Arrow__Group_0__612545);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6260:1: rule__Arrow__Group_0__6__Impl : ( ( rule__Arrow__TgDataTypeAssignment_0_6 ) ) ;
    public final void rule__Arrow__Group_0__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6264:1: ( ( ( rule__Arrow__TgDataTypeAssignment_0_6 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6265:1: ( ( rule__Arrow__TgDataTypeAssignment_0_6 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6265:1: ( ( rule__Arrow__TgDataTypeAssignment_0_6 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6266:1: ( rule__Arrow__TgDataTypeAssignment_0_6 )
            {
             before(grammarAccess.getArrowAccess().getTgDataTypeAssignment_0_6()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6267:1: ( rule__Arrow__TgDataTypeAssignment_0_6 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6267:2: rule__Arrow__TgDataTypeAssignment_0_6
            {
            pushFollow(FOLLOW_rule__Arrow__TgDataTypeAssignment_0_6_in_rule__Arrow__Group_0__6__Impl12572);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6291:1: rule__Arrow__Group_1__0 : rule__Arrow__Group_1__0__Impl rule__Arrow__Group_1__1 ;
    public final void rule__Arrow__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6295:1: ( rule__Arrow__Group_1__0__Impl rule__Arrow__Group_1__1 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6296:2: rule__Arrow__Group_1__0__Impl rule__Arrow__Group_1__1
            {
            pushFollow(FOLLOW_rule__Arrow__Group_1__0__Impl_in_rule__Arrow__Group_1__012616);
            rule__Arrow__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Arrow__Group_1__1_in_rule__Arrow__Group_1__012619);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6303:1: rule__Arrow__Group_1__0__Impl : ( ( rule__Arrow__SrAssignment_1_0 ) ) ;
    public final void rule__Arrow__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6307:1: ( ( ( rule__Arrow__SrAssignment_1_0 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6308:1: ( ( rule__Arrow__SrAssignment_1_0 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6308:1: ( ( rule__Arrow__SrAssignment_1_0 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6309:1: ( rule__Arrow__SrAssignment_1_0 )
            {
             before(grammarAccess.getArrowAccess().getSrAssignment_1_0()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6310:1: ( rule__Arrow__SrAssignment_1_0 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6310:2: rule__Arrow__SrAssignment_1_0
            {
            pushFollow(FOLLOW_rule__Arrow__SrAssignment_1_0_in_rule__Arrow__Group_1__0__Impl12646);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6320:1: rule__Arrow__Group_1__1 : rule__Arrow__Group_1__1__Impl rule__Arrow__Group_1__2 ;
    public final void rule__Arrow__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6324:1: ( rule__Arrow__Group_1__1__Impl rule__Arrow__Group_1__2 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6325:2: rule__Arrow__Group_1__1__Impl rule__Arrow__Group_1__2
            {
            pushFollow(FOLLOW_rule__Arrow__Group_1__1__Impl_in_rule__Arrow__Group_1__112676);
            rule__Arrow__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Arrow__Group_1__2_in_rule__Arrow__Group_1__112679);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6332:1: rule__Arrow__Group_1__1__Impl : ( '-' ) ;
    public final void rule__Arrow__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6336:1: ( ( '-' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6337:1: ( '-' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6337:1: ( '-' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6338:1: '-'
            {
             before(grammarAccess.getArrowAccess().getHyphenMinusKeyword_1_1()); 
            match(input,48,FOLLOW_48_in_rule__Arrow__Group_1__1__Impl12707); 
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6351:1: rule__Arrow__Group_1__2 : rule__Arrow__Group_1__2__Impl rule__Arrow__Group_1__3 ;
    public final void rule__Arrow__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6355:1: ( rule__Arrow__Group_1__2__Impl rule__Arrow__Group_1__3 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6356:2: rule__Arrow__Group_1__2__Impl rule__Arrow__Group_1__3
            {
            pushFollow(FOLLOW_rule__Arrow__Group_1__2__Impl_in_rule__Arrow__Group_1__212738);
            rule__Arrow__Group_1__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Arrow__Group_1__3_in_rule__Arrow__Group_1__212741);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6363:1: rule__Arrow__Group_1__2__Impl : ( ( rule__Arrow__IdAssignment_1_2 ) ) ;
    public final void rule__Arrow__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6367:1: ( ( ( rule__Arrow__IdAssignment_1_2 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6368:1: ( ( rule__Arrow__IdAssignment_1_2 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6368:1: ( ( rule__Arrow__IdAssignment_1_2 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6369:1: ( rule__Arrow__IdAssignment_1_2 )
            {
             before(grammarAccess.getArrowAccess().getIdAssignment_1_2()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6370:1: ( rule__Arrow__IdAssignment_1_2 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6370:2: rule__Arrow__IdAssignment_1_2
            {
            pushFollow(FOLLOW_rule__Arrow__IdAssignment_1_2_in_rule__Arrow__Group_1__2__Impl12768);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6380:1: rule__Arrow__Group_1__3 : rule__Arrow__Group_1__3__Impl rule__Arrow__Group_1__4 ;
    public final void rule__Arrow__Group_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6384:1: ( rule__Arrow__Group_1__3__Impl rule__Arrow__Group_1__4 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6385:2: rule__Arrow__Group_1__3__Impl rule__Arrow__Group_1__4
            {
            pushFollow(FOLLOW_rule__Arrow__Group_1__3__Impl_in_rule__Arrow__Group_1__312798);
            rule__Arrow__Group_1__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Arrow__Group_1__4_in_rule__Arrow__Group_1__312801);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6392:1: rule__Arrow__Group_1__3__Impl : ( ':' ) ;
    public final void rule__Arrow__Group_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6396:1: ( ( ':' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6397:1: ( ':' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6397:1: ( ':' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6398:1: ':'
            {
             before(grammarAccess.getArrowAccess().getColonKeyword_1_3()); 
            match(input,41,FOLLOW_41_in_rule__Arrow__Group_1__3__Impl12829); 
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6411:1: rule__Arrow__Group_1__4 : rule__Arrow__Group_1__4__Impl rule__Arrow__Group_1__5 ;
    public final void rule__Arrow__Group_1__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6415:1: ( rule__Arrow__Group_1__4__Impl rule__Arrow__Group_1__5 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6416:2: rule__Arrow__Group_1__4__Impl rule__Arrow__Group_1__5
            {
            pushFollow(FOLLOW_rule__Arrow__Group_1__4__Impl_in_rule__Arrow__Group_1__412860);
            rule__Arrow__Group_1__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Arrow__Group_1__5_in_rule__Arrow__Group_1__412863);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6423:1: rule__Arrow__Group_1__4__Impl : ( ( rule__Arrow__TypeAssignment_1_4 ) ) ;
    public final void rule__Arrow__Group_1__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6427:1: ( ( ( rule__Arrow__TypeAssignment_1_4 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6428:1: ( ( rule__Arrow__TypeAssignment_1_4 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6428:1: ( ( rule__Arrow__TypeAssignment_1_4 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6429:1: ( rule__Arrow__TypeAssignment_1_4 )
            {
             before(grammarAccess.getArrowAccess().getTypeAssignment_1_4()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6430:1: ( rule__Arrow__TypeAssignment_1_4 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6430:2: rule__Arrow__TypeAssignment_1_4
            {
            pushFollow(FOLLOW_rule__Arrow__TypeAssignment_1_4_in_rule__Arrow__Group_1__4__Impl12890);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6440:1: rule__Arrow__Group_1__5 : rule__Arrow__Group_1__5__Impl rule__Arrow__Group_1__6 ;
    public final void rule__Arrow__Group_1__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6444:1: ( rule__Arrow__Group_1__5__Impl rule__Arrow__Group_1__6 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6445:2: rule__Arrow__Group_1__5__Impl rule__Arrow__Group_1__6
            {
            pushFollow(FOLLOW_rule__Arrow__Group_1__5__Impl_in_rule__Arrow__Group_1__512920);
            rule__Arrow__Group_1__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Arrow__Group_1__6_in_rule__Arrow__Group_1__512923);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6452:1: rule__Arrow__Group_1__5__Impl : ( '->' ) ;
    public final void rule__Arrow__Group_1__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6456:1: ( ( '->' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6457:1: ( '->' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6457:1: ( '->' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6458:1: '->'
            {
             before(grammarAccess.getArrowAccess().getHyphenMinusGreaterThanSignKeyword_1_5()); 
            match(input,28,FOLLOW_28_in_rule__Arrow__Group_1__5__Impl12951); 
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6471:1: rule__Arrow__Group_1__6 : rule__Arrow__Group_1__6__Impl ;
    public final void rule__Arrow__Group_1__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6475:1: ( rule__Arrow__Group_1__6__Impl )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6476:2: rule__Arrow__Group_1__6__Impl
            {
            pushFollow(FOLLOW_rule__Arrow__Group_1__6__Impl_in_rule__Arrow__Group_1__612982);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6482:1: rule__Arrow__Group_1__6__Impl : ( ( rule__Arrow__TgValueAssignment_1_6 ) ) ;
    public final void rule__Arrow__Group_1__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6486:1: ( ( ( rule__Arrow__TgValueAssignment_1_6 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6487:1: ( ( rule__Arrow__TgValueAssignment_1_6 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6487:1: ( ( rule__Arrow__TgValueAssignment_1_6 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6488:1: ( rule__Arrow__TgValueAssignment_1_6 )
            {
             before(grammarAccess.getArrowAccess().getTgValueAssignment_1_6()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6489:1: ( rule__Arrow__TgValueAssignment_1_6 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6489:2: rule__Arrow__TgValueAssignment_1_6
            {
            pushFollow(FOLLOW_rule__Arrow__TgValueAssignment_1_6_in_rule__Arrow__Group_1__6__Impl13009);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6513:1: rule__Arrow__Group_2__0 : rule__Arrow__Group_2__0__Impl rule__Arrow__Group_2__1 ;
    public final void rule__Arrow__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6517:1: ( rule__Arrow__Group_2__0__Impl rule__Arrow__Group_2__1 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6518:2: rule__Arrow__Group_2__0__Impl rule__Arrow__Group_2__1
            {
            pushFollow(FOLLOW_rule__Arrow__Group_2__0__Impl_in_rule__Arrow__Group_2__013053);
            rule__Arrow__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Arrow__Group_2__1_in_rule__Arrow__Group_2__013056);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6525:1: rule__Arrow__Group_2__0__Impl : ( ( rule__Arrow__SrAssignment_2_0 ) ) ;
    public final void rule__Arrow__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6529:1: ( ( ( rule__Arrow__SrAssignment_2_0 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6530:1: ( ( rule__Arrow__SrAssignment_2_0 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6530:1: ( ( rule__Arrow__SrAssignment_2_0 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6531:1: ( rule__Arrow__SrAssignment_2_0 )
            {
             before(grammarAccess.getArrowAccess().getSrAssignment_2_0()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6532:1: ( rule__Arrow__SrAssignment_2_0 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6532:2: rule__Arrow__SrAssignment_2_0
            {
            pushFollow(FOLLOW_rule__Arrow__SrAssignment_2_0_in_rule__Arrow__Group_2__0__Impl13083);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6542:1: rule__Arrow__Group_2__1 : rule__Arrow__Group_2__1__Impl rule__Arrow__Group_2__2 ;
    public final void rule__Arrow__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6546:1: ( rule__Arrow__Group_2__1__Impl rule__Arrow__Group_2__2 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6547:2: rule__Arrow__Group_2__1__Impl rule__Arrow__Group_2__2
            {
            pushFollow(FOLLOW_rule__Arrow__Group_2__1__Impl_in_rule__Arrow__Group_2__113113);
            rule__Arrow__Group_2__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Arrow__Group_2__2_in_rule__Arrow__Group_2__113116);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6554:1: rule__Arrow__Group_2__1__Impl : ( '-' ) ;
    public final void rule__Arrow__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6558:1: ( ( '-' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6559:1: ( '-' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6559:1: ( '-' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6560:1: '-'
            {
             before(grammarAccess.getArrowAccess().getHyphenMinusKeyword_2_1()); 
            match(input,48,FOLLOW_48_in_rule__Arrow__Group_2__1__Impl13144); 
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6573:1: rule__Arrow__Group_2__2 : rule__Arrow__Group_2__2__Impl rule__Arrow__Group_2__3 ;
    public final void rule__Arrow__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6577:1: ( rule__Arrow__Group_2__2__Impl rule__Arrow__Group_2__3 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6578:2: rule__Arrow__Group_2__2__Impl rule__Arrow__Group_2__3
            {
            pushFollow(FOLLOW_rule__Arrow__Group_2__2__Impl_in_rule__Arrow__Group_2__213175);
            rule__Arrow__Group_2__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Arrow__Group_2__3_in_rule__Arrow__Group_2__213178);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6585:1: rule__Arrow__Group_2__2__Impl : ( ( rule__Arrow__IdAssignment_2_2 ) ) ;
    public final void rule__Arrow__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6589:1: ( ( ( rule__Arrow__IdAssignment_2_2 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6590:1: ( ( rule__Arrow__IdAssignment_2_2 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6590:1: ( ( rule__Arrow__IdAssignment_2_2 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6591:1: ( rule__Arrow__IdAssignment_2_2 )
            {
             before(grammarAccess.getArrowAccess().getIdAssignment_2_2()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6592:1: ( rule__Arrow__IdAssignment_2_2 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6592:2: rule__Arrow__IdAssignment_2_2
            {
            pushFollow(FOLLOW_rule__Arrow__IdAssignment_2_2_in_rule__Arrow__Group_2__2__Impl13205);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6602:1: rule__Arrow__Group_2__3 : rule__Arrow__Group_2__3__Impl rule__Arrow__Group_2__4 ;
    public final void rule__Arrow__Group_2__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6606:1: ( rule__Arrow__Group_2__3__Impl rule__Arrow__Group_2__4 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6607:2: rule__Arrow__Group_2__3__Impl rule__Arrow__Group_2__4
            {
            pushFollow(FOLLOW_rule__Arrow__Group_2__3__Impl_in_rule__Arrow__Group_2__313235);
            rule__Arrow__Group_2__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Arrow__Group_2__4_in_rule__Arrow__Group_2__313238);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6614:1: rule__Arrow__Group_2__3__Impl : ( ':' ) ;
    public final void rule__Arrow__Group_2__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6618:1: ( ( ':' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6619:1: ( ':' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6619:1: ( ':' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6620:1: ':'
            {
             before(grammarAccess.getArrowAccess().getColonKeyword_2_3()); 
            match(input,41,FOLLOW_41_in_rule__Arrow__Group_2__3__Impl13266); 
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6633:1: rule__Arrow__Group_2__4 : rule__Arrow__Group_2__4__Impl rule__Arrow__Group_2__5 ;
    public final void rule__Arrow__Group_2__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6637:1: ( rule__Arrow__Group_2__4__Impl rule__Arrow__Group_2__5 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6638:2: rule__Arrow__Group_2__4__Impl rule__Arrow__Group_2__5
            {
            pushFollow(FOLLOW_rule__Arrow__Group_2__4__Impl_in_rule__Arrow__Group_2__413297);
            rule__Arrow__Group_2__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Arrow__Group_2__5_in_rule__Arrow__Group_2__413300);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6645:1: rule__Arrow__Group_2__4__Impl : ( ( rule__Arrow__TypeAssignment_2_4 ) ) ;
    public final void rule__Arrow__Group_2__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6649:1: ( ( ( rule__Arrow__TypeAssignment_2_4 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6650:1: ( ( rule__Arrow__TypeAssignment_2_4 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6650:1: ( ( rule__Arrow__TypeAssignment_2_4 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6651:1: ( rule__Arrow__TypeAssignment_2_4 )
            {
             before(grammarAccess.getArrowAccess().getTypeAssignment_2_4()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6652:1: ( rule__Arrow__TypeAssignment_2_4 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6652:2: rule__Arrow__TypeAssignment_2_4
            {
            pushFollow(FOLLOW_rule__Arrow__TypeAssignment_2_4_in_rule__Arrow__Group_2__4__Impl13327);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6662:1: rule__Arrow__Group_2__5 : rule__Arrow__Group_2__5__Impl rule__Arrow__Group_2__6 ;
    public final void rule__Arrow__Group_2__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6666:1: ( rule__Arrow__Group_2__5__Impl rule__Arrow__Group_2__6 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6667:2: rule__Arrow__Group_2__5__Impl rule__Arrow__Group_2__6
            {
            pushFollow(FOLLOW_rule__Arrow__Group_2__5__Impl_in_rule__Arrow__Group_2__513357);
            rule__Arrow__Group_2__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Arrow__Group_2__6_in_rule__Arrow__Group_2__513360);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6674:1: rule__Arrow__Group_2__5__Impl : ( '->' ) ;
    public final void rule__Arrow__Group_2__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6678:1: ( ( '->' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6679:1: ( '->' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6679:1: ( '->' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6680:1: '->'
            {
             before(grammarAccess.getArrowAccess().getHyphenMinusGreaterThanSignKeyword_2_5()); 
            match(input,28,FOLLOW_28_in_rule__Arrow__Group_2__5__Impl13388); 
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6693:1: rule__Arrow__Group_2__6 : rule__Arrow__Group_2__6__Impl ;
    public final void rule__Arrow__Group_2__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6697:1: ( rule__Arrow__Group_2__6__Impl )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6698:2: rule__Arrow__Group_2__6__Impl
            {
            pushFollow(FOLLOW_rule__Arrow__Group_2__6__Impl_in_rule__Arrow__Group_2__613419);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6704:1: rule__Arrow__Group_2__6__Impl : ( ( rule__Arrow__TgNodeAssignment_2_6 ) ) ;
    public final void rule__Arrow__Group_2__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6708:1: ( ( ( rule__Arrow__TgNodeAssignment_2_6 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6709:1: ( ( rule__Arrow__TgNodeAssignment_2_6 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6709:1: ( ( rule__Arrow__TgNodeAssignment_2_6 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6710:1: ( rule__Arrow__TgNodeAssignment_2_6 )
            {
             before(grammarAccess.getArrowAccess().getTgNodeAssignment_2_6()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6711:1: ( rule__Arrow__TgNodeAssignment_2_6 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6711:2: rule__Arrow__TgNodeAssignment_2_6
            {
            pushFollow(FOLLOW_rule__Arrow__TgNodeAssignment_2_6_in_rule__Arrow__Group_2__6__Impl13446);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6735:1: rule__Node__Group__0 : rule__Node__Group__0__Impl rule__Node__Group__1 ;
    public final void rule__Node__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6739:1: ( rule__Node__Group__0__Impl rule__Node__Group__1 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6740:2: rule__Node__Group__0__Impl rule__Node__Group__1
            {
            pushFollow(FOLLOW_rule__Node__Group__0__Impl_in_rule__Node__Group__013490);
            rule__Node__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Node__Group__1_in_rule__Node__Group__013493);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6747:1: rule__Node__Group__0__Impl : ( ( rule__Node__IdAssignment_0 ) ) ;
    public final void rule__Node__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6751:1: ( ( ( rule__Node__IdAssignment_0 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6752:1: ( ( rule__Node__IdAssignment_0 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6752:1: ( ( rule__Node__IdAssignment_0 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6753:1: ( rule__Node__IdAssignment_0 )
            {
             before(grammarAccess.getNodeAccess().getIdAssignment_0()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6754:1: ( rule__Node__IdAssignment_0 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6754:2: rule__Node__IdAssignment_0
            {
            pushFollow(FOLLOW_rule__Node__IdAssignment_0_in_rule__Node__Group__0__Impl13520);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6764:1: rule__Node__Group__1 : rule__Node__Group__1__Impl rule__Node__Group__2 ;
    public final void rule__Node__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6768:1: ( rule__Node__Group__1__Impl rule__Node__Group__2 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6769:2: rule__Node__Group__1__Impl rule__Node__Group__2
            {
            pushFollow(FOLLOW_rule__Node__Group__1__Impl_in_rule__Node__Group__113550);
            rule__Node__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Node__Group__2_in_rule__Node__Group__113553);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6776:1: rule__Node__Group__1__Impl : ( ':' ) ;
    public final void rule__Node__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6780:1: ( ( ':' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6781:1: ( ':' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6781:1: ( ':' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6782:1: ':'
            {
             before(grammarAccess.getNodeAccess().getColonKeyword_1()); 
            match(input,41,FOLLOW_41_in_rule__Node__Group__1__Impl13581); 
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6795:1: rule__Node__Group__2 : rule__Node__Group__2__Impl ;
    public final void rule__Node__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6799:1: ( rule__Node__Group__2__Impl )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6800:2: rule__Node__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__Node__Group__2__Impl_in_rule__Node__Group__213612);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6806:1: rule__Node__Group__2__Impl : ( ( rule__Node__TypeAssignment_2 ) ) ;
    public final void rule__Node__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6810:1: ( ( ( rule__Node__TypeAssignment_2 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6811:1: ( ( rule__Node__TypeAssignment_2 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6811:1: ( ( rule__Node__TypeAssignment_2 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6812:1: ( rule__Node__TypeAssignment_2 )
            {
             before(grammarAccess.getNodeAccess().getTypeAssignment_2()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6813:1: ( rule__Node__TypeAssignment_2 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6813:2: rule__Node__TypeAssignment_2
            {
            pushFollow(FOLLOW_rule__Node__TypeAssignment_2_in_rule__Node__Group__2__Impl13639);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6829:1: rule__AttributeValue__Group__0 : rule__AttributeValue__Group__0__Impl rule__AttributeValue__Group__1 ;
    public final void rule__AttributeValue__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6833:1: ( rule__AttributeValue__Group__0__Impl rule__AttributeValue__Group__1 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6834:2: rule__AttributeValue__Group__0__Impl rule__AttributeValue__Group__1
            {
            pushFollow(FOLLOW_rule__AttributeValue__Group__0__Impl_in_rule__AttributeValue__Group__013675);
            rule__AttributeValue__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__AttributeValue__Group__1_in_rule__AttributeValue__Group__013678);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6841:1: rule__AttributeValue__Group__0__Impl : ( '[' ) ;
    public final void rule__AttributeValue__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6845:1: ( ( '[' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6846:1: ( '[' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6846:1: ( '[' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6847:1: '['
            {
             before(grammarAccess.getAttributeValueAccess().getLeftSquareBracketKeyword_0()); 
            match(input,50,FOLLOW_50_in_rule__AttributeValue__Group__0__Impl13706); 
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6860:1: rule__AttributeValue__Group__1 : rule__AttributeValue__Group__1__Impl rule__AttributeValue__Group__2 ;
    public final void rule__AttributeValue__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6864:1: ( rule__AttributeValue__Group__1__Impl rule__AttributeValue__Group__2 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6865:2: rule__AttributeValue__Group__1__Impl rule__AttributeValue__Group__2
            {
            pushFollow(FOLLOW_rule__AttributeValue__Group__1__Impl_in_rule__AttributeValue__Group__113737);
            rule__AttributeValue__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__AttributeValue__Group__2_in_rule__AttributeValue__Group__113740);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6872:1: rule__AttributeValue__Group__1__Impl : ( ( rule__AttributeValue__ValueAssignment_1 ) ) ;
    public final void rule__AttributeValue__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6876:1: ( ( ( rule__AttributeValue__ValueAssignment_1 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6877:1: ( ( rule__AttributeValue__ValueAssignment_1 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6877:1: ( ( rule__AttributeValue__ValueAssignment_1 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6878:1: ( rule__AttributeValue__ValueAssignment_1 )
            {
             before(grammarAccess.getAttributeValueAccess().getValueAssignment_1()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6879:1: ( rule__AttributeValue__ValueAssignment_1 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6879:2: rule__AttributeValue__ValueAssignment_1
            {
            pushFollow(FOLLOW_rule__AttributeValue__ValueAssignment_1_in_rule__AttributeValue__Group__1__Impl13767);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6889:1: rule__AttributeValue__Group__2 : rule__AttributeValue__Group__2__Impl ;
    public final void rule__AttributeValue__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6893:1: ( rule__AttributeValue__Group__2__Impl )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6894:2: rule__AttributeValue__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__AttributeValue__Group__2__Impl_in_rule__AttributeValue__Group__213797);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6900:1: rule__AttributeValue__Group__2__Impl : ( ']' ) ;
    public final void rule__AttributeValue__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6904:1: ( ( ']' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6905:1: ( ']' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6905:1: ( ']' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6906:1: ']'
            {
             before(grammarAccess.getAttributeValueAccess().getRightSquareBracketKeyword_2()); 
            match(input,51,FOLLOW_51_in_rule__AttributeValue__Group__2__Impl13825); 
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6925:1: rule__DpfId__Group__0 : rule__DpfId__Group__0__Impl rule__DpfId__Group__1 ;
    public final void rule__DpfId__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6929:1: ( rule__DpfId__Group__0__Impl rule__DpfId__Group__1 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6930:2: rule__DpfId__Group__0__Impl rule__DpfId__Group__1
            {
            pushFollow(FOLLOW_rule__DpfId__Group__0__Impl_in_rule__DpfId__Group__013862);
            rule__DpfId__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DpfId__Group__1_in_rule__DpfId__Group__013865);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6937:1: rule__DpfId__Group__0__Impl : ( ( rule__DpfId__NameAssignment_0 ) ) ;
    public final void rule__DpfId__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6941:1: ( ( ( rule__DpfId__NameAssignment_0 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6942:1: ( ( rule__DpfId__NameAssignment_0 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6942:1: ( ( rule__DpfId__NameAssignment_0 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6943:1: ( rule__DpfId__NameAssignment_0 )
            {
             before(grammarAccess.getDpfIdAccess().getNameAssignment_0()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6944:1: ( rule__DpfId__NameAssignment_0 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6944:2: rule__DpfId__NameAssignment_0
            {
            pushFollow(FOLLOW_rule__DpfId__NameAssignment_0_in_rule__DpfId__Group__0__Impl13892);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6954:1: rule__DpfId__Group__1 : rule__DpfId__Group__1__Impl ;
    public final void rule__DpfId__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6958:1: ( rule__DpfId__Group__1__Impl )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6959:2: rule__DpfId__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__DpfId__Group__1__Impl_in_rule__DpfId__Group__113922);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6965:1: rule__DpfId__Group__1__Impl : ( ( rule__DpfId__Group_1__0 )? ) ;
    public final void rule__DpfId__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6969:1: ( ( ( rule__DpfId__Group_1__0 )? ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6970:1: ( ( rule__DpfId__Group_1__0 )? )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6970:1: ( ( rule__DpfId__Group_1__0 )? )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6971:1: ( rule__DpfId__Group_1__0 )?
            {
             before(grammarAccess.getDpfIdAccess().getGroup_1()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6972:1: ( rule__DpfId__Group_1__0 )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==52) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6972:2: rule__DpfId__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__DpfId__Group_1__0_in_rule__DpfId__Group__1__Impl13949);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6986:1: rule__DpfId__Group_1__0 : rule__DpfId__Group_1__0__Impl rule__DpfId__Group_1__1 ;
    public final void rule__DpfId__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6990:1: ( rule__DpfId__Group_1__0__Impl rule__DpfId__Group_1__1 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6991:2: rule__DpfId__Group_1__0__Impl rule__DpfId__Group_1__1
            {
            pushFollow(FOLLOW_rule__DpfId__Group_1__0__Impl_in_rule__DpfId__Group_1__013984);
            rule__DpfId__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DpfId__Group_1__1_in_rule__DpfId__Group_1__013987);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6998:1: rule__DpfId__Group_1__0__Impl : ( '@' ) ;
    public final void rule__DpfId__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7002:1: ( ( '@' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7003:1: ( '@' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7003:1: ( '@' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7004:1: '@'
            {
             before(grammarAccess.getDpfIdAccess().getCommercialAtKeyword_1_0()); 
            match(input,52,FOLLOW_52_in_rule__DpfId__Group_1__0__Impl14015); 
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7017:1: rule__DpfId__Group_1__1 : rule__DpfId__Group_1__1__Impl ;
    public final void rule__DpfId__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7021:1: ( rule__DpfId__Group_1__1__Impl )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7022:2: rule__DpfId__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__DpfId__Group_1__1__Impl_in_rule__DpfId__Group_1__114046);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7028:1: rule__DpfId__Group_1__1__Impl : ( ( rule__DpfId__IdAssignment_1_1 ) ) ;
    public final void rule__DpfId__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7032:1: ( ( ( rule__DpfId__IdAssignment_1_1 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7033:1: ( ( rule__DpfId__IdAssignment_1_1 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7033:1: ( ( rule__DpfId__IdAssignment_1_1 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7034:1: ( rule__DpfId__IdAssignment_1_1 )
            {
             before(grammarAccess.getDpfIdAccess().getIdAssignment_1_1()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7035:1: ( rule__DpfId__IdAssignment_1_1 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7035:2: rule__DpfId__IdAssignment_1_1
            {
            pushFollow(FOLLOW_rule__DpfId__IdAssignment_1_1_in_rule__DpfId__Group_1__1__Impl14073);
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


    // $ANTLR start "rule__Model__CommandsAssignment_1_0"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7050:1: rule__Model__CommandsAssignment_1_0 : ( ruleCommand ) ;
    public final void rule__Model__CommandsAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7054:1: ( ( ruleCommand ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7055:1: ( ruleCommand )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7055:1: ( ruleCommand )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7056:1: ruleCommand
            {
             before(grammarAccess.getModelAccess().getCommandsCommandParserRuleCall_1_0_0()); 
            pushFollow(FOLLOW_ruleCommand_in_rule__Model__CommandsAssignment_1_014112);
            ruleCommand();

            state._fsp--;

             after(grammarAccess.getModelAccess().getCommandsCommandParserRuleCall_1_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__CommandsAssignment_1_0"


    // $ANTLR start "rule__Model__CommandsAssignment_1_1"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7065:1: rule__Model__CommandsAssignment_1_1 : ( ruleCommand ) ;
    public final void rule__Model__CommandsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7069:1: ( ( ruleCommand ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7070:1: ( ruleCommand )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7070:1: ( ruleCommand )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7071:1: ruleCommand
            {
             before(grammarAccess.getModelAccess().getCommandsCommandParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_ruleCommand_in_rule__Model__CommandsAssignment_1_114143);
            ruleCommand();

            state._fsp--;

             after(grammarAccess.getModelAccess().getCommandsCommandParserRuleCall_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__CommandsAssignment_1_1"


    // $ANTLR start "rule__MakeEmf__IdAssignment_1"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7080:1: rule__MakeEmf__IdAssignment_1 : ( RULE_ID ) ;
    public final void rule__MakeEmf__IdAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7084:1: ( ( RULE_ID ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7085:1: ( RULE_ID )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7085:1: ( RULE_ID )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7086:1: RULE_ID
            {
             before(grammarAccess.getMakeEmfAccess().getIdIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__MakeEmf__IdAssignment_114174); 
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7095:1: rule__MakeEcore__IdAssignment_1 : ( RULE_ID ) ;
    public final void rule__MakeEcore__IdAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7099:1: ( ( RULE_ID ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7100:1: ( RULE_ID )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7100:1: ( RULE_ID )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7101:1: RULE_ID
            {
             before(grammarAccess.getMakeEcoreAccess().getIdIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__MakeEcore__IdAssignment_114205); 
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7110:1: rule__MakeImage__IdAssignment_1 : ( RULE_ID ) ;
    public final void rule__MakeImage__IdAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7114:1: ( ( RULE_ID ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7115:1: ( RULE_ID )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7115:1: ( RULE_ID )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7116:1: RULE_ID
            {
             before(grammarAccess.getMakeImageAccess().getIdIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__MakeImage__IdAssignment_114236); 
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7125:1: rule__SimpleEvoSpan__LhsAssignment_1 : ( RULE_ID ) ;
    public final void rule__SimpleEvoSpan__LhsAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7129:1: ( ( RULE_ID ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7130:1: ( RULE_ID )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7130:1: ( RULE_ID )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7131:1: RULE_ID
            {
             before(grammarAccess.getSimpleEvoSpanAccess().getLhsIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__SimpleEvoSpan__LhsAssignment_114267); 
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7140:1: rule__SimpleEvoSpan__DiffAssignment_3 : ( RULE_ID ) ;
    public final void rule__SimpleEvoSpan__DiffAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7144:1: ( ( RULE_ID ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7145:1: ( RULE_ID )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7145:1: ( RULE_ID )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7146:1: RULE_ID
            {
             before(grammarAccess.getSimpleEvoSpanAccess().getDiffIDTerminalRuleCall_3_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__SimpleEvoSpan__DiffAssignment_314298); 
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7155:1: rule__SimpleEvoSpan__RhSAssignment_5 : ( RULE_ID ) ;
    public final void rule__SimpleEvoSpan__RhSAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7159:1: ( ( RULE_ID ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7160:1: ( RULE_ID )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7160:1: ( RULE_ID )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7161:1: RULE_ID
            {
             before(grammarAccess.getSimpleEvoSpanAccess().getRhSIDTerminalRuleCall_5_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__SimpleEvoSpan__RhSAssignment_514329); 
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7170:1: rule__SimpleEvoSpan__TypeGraphAssignment_7 : ( RULE_ID ) ;
    public final void rule__SimpleEvoSpan__TypeGraphAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7174:1: ( ( RULE_ID ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7175:1: ( RULE_ID )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7175:1: ( RULE_ID )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7176:1: RULE_ID
            {
             before(grammarAccess.getSimpleEvoSpanAccess().getTypeGraphIDTerminalRuleCall_7_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__SimpleEvoSpan__TypeGraphAssignment_714360); 
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7185:1: rule__SimpleEvoCospan__LhsAssignment_1 : ( RULE_ID ) ;
    public final void rule__SimpleEvoCospan__LhsAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7189:1: ( ( RULE_ID ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7190:1: ( RULE_ID )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7190:1: ( RULE_ID )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7191:1: RULE_ID
            {
             before(grammarAccess.getSimpleEvoCospanAccess().getLhsIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__SimpleEvoCospan__LhsAssignment_114391); 
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7200:1: rule__SimpleEvoCospan__JointAssignment_3 : ( RULE_ID ) ;
    public final void rule__SimpleEvoCospan__JointAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7204:1: ( ( RULE_ID ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7205:1: ( RULE_ID )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7205:1: ( RULE_ID )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7206:1: RULE_ID
            {
             before(grammarAccess.getSimpleEvoCospanAccess().getJointIDTerminalRuleCall_3_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__SimpleEvoCospan__JointAssignment_314422); 
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7215:1: rule__SimpleEvoCospan__RhsAssignment_5 : ( RULE_ID ) ;
    public final void rule__SimpleEvoCospan__RhsAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7219:1: ( ( RULE_ID ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7220:1: ( RULE_ID )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7220:1: ( RULE_ID )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7221:1: RULE_ID
            {
             before(grammarAccess.getSimpleEvoCospanAccess().getRhsIDTerminalRuleCall_5_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__SimpleEvoCospan__RhsAssignment_514453); 
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7230:1: rule__SimpleEvoCospan__TypeGraphAssignment_7 : ( RULE_ID ) ;
    public final void rule__SimpleEvoCospan__TypeGraphAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7234:1: ( ( RULE_ID ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7235:1: ( RULE_ID )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7235:1: ( RULE_ID )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7236:1: RULE_ID
            {
             before(grammarAccess.getSimpleEvoCospanAccess().getTypeGraphIDTerminalRuleCall_7_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__SimpleEvoCospan__TypeGraphAssignment_714484); 
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7245:1: rule__EvoSpan__LhsAssignment_1 : ( RULE_ID ) ;
    public final void rule__EvoSpan__LhsAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7249:1: ( ( RULE_ID ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7250:1: ( RULE_ID )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7250:1: ( RULE_ID )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7251:1: RULE_ID
            {
             before(grammarAccess.getEvoSpanAccess().getLhsIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__EvoSpan__LhsAssignment_114515); 
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7260:1: rule__EvoSpan__RhsAssignment_3 : ( RULE_ID ) ;
    public final void rule__EvoSpan__RhsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7264:1: ( ( RULE_ID ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7265:1: ( RULE_ID )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7265:1: ( RULE_ID )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7266:1: RULE_ID
            {
             before(grammarAccess.getEvoSpanAccess().getRhsIDTerminalRuleCall_3_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__EvoSpan__RhsAssignment_314546); 
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7275:1: rule__EvoSpan__TypeGraphAssignment_5 : ( RULE_ID ) ;
    public final void rule__EvoSpan__TypeGraphAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7279:1: ( ( RULE_ID ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7280:1: ( RULE_ID )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7280:1: ( RULE_ID )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7281:1: RULE_ID
            {
             before(grammarAccess.getEvoSpanAccess().getTypeGraphIDTerminalRuleCall_5_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__EvoSpan__TypeGraphAssignment_514577); 
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7290:1: rule__EvoCospan__LhsAssignment_1 : ( RULE_ID ) ;
    public final void rule__EvoCospan__LhsAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7294:1: ( ( RULE_ID ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7295:1: ( RULE_ID )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7295:1: ( RULE_ID )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7296:1: RULE_ID
            {
             before(grammarAccess.getEvoCospanAccess().getLhsIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__EvoCospan__LhsAssignment_114608); 
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7305:1: rule__EvoCospan__RhsAssignment_3 : ( RULE_ID ) ;
    public final void rule__EvoCospan__RhsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7309:1: ( ( RULE_ID ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7310:1: ( RULE_ID )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7310:1: ( RULE_ID )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7311:1: RULE_ID
            {
             before(grammarAccess.getEvoCospanAccess().getRhsIDTerminalRuleCall_3_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__EvoCospan__RhsAssignment_314639); 
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7320:1: rule__EvoCospan__TypeGraphAssignment_5 : ( RULE_ID ) ;
    public final void rule__EvoCospan__TypeGraphAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7324:1: ( ( RULE_ID ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7325:1: ( RULE_ID )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7325:1: ( RULE_ID )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7326:1: RULE_ID
            {
             before(grammarAccess.getEvoCospanAccess().getTypeGraphIDTerminalRuleCall_5_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__EvoCospan__TypeGraphAssignment_514670); 
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


    // $ANTLR start "rule__InstanceSpecification__IdAssignment_0"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7335:1: rule__InstanceSpecification__IdAssignment_0 : ( RULE_ID ) ;
    public final void rule__InstanceSpecification__IdAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7339:1: ( ( RULE_ID ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7340:1: ( RULE_ID )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7340:1: ( RULE_ID )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7341:1: RULE_ID
            {
             before(grammarAccess.getInstanceSpecificationAccess().getIdIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__InstanceSpecification__IdAssignment_014701); 
             after(grammarAccess.getInstanceSpecificationAccess().getIdIDTerminalRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InstanceSpecification__IdAssignment_0"


    // $ANTLR start "rule__InstanceSpecification__ModelAssignment_4"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7350:1: rule__InstanceSpecification__ModelAssignment_4 : ( ruleChoosenSpecfication ) ;
    public final void rule__InstanceSpecification__ModelAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7354:1: ( ( ruleChoosenSpecfication ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7355:1: ( ruleChoosenSpecfication )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7355:1: ( ruleChoosenSpecfication )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7356:1: ruleChoosenSpecfication
            {
             before(grammarAccess.getInstanceSpecificationAccess().getModelChoosenSpecficationParserRuleCall_4_0()); 
            pushFollow(FOLLOW_ruleChoosenSpecfication_in_rule__InstanceSpecification__ModelAssignment_414732);
            ruleChoosenSpecfication();

            state._fsp--;

             after(grammarAccess.getInstanceSpecificationAccess().getModelChoosenSpecficationParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InstanceSpecification__ModelAssignment_4"


    // $ANTLR start "rule__InstanceSpecification__MetamodelAssignment_6"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7365:1: rule__InstanceSpecification__MetamodelAssignment_6 : ( ruleChoosenSpecfication ) ;
    public final void rule__InstanceSpecification__MetamodelAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7369:1: ( ( ruleChoosenSpecfication ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7370:1: ( ruleChoosenSpecfication )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7370:1: ( ruleChoosenSpecfication )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7371:1: ruleChoosenSpecfication
            {
             before(grammarAccess.getInstanceSpecificationAccess().getMetamodelChoosenSpecficationParserRuleCall_6_0()); 
            pushFollow(FOLLOW_ruleChoosenSpecfication_in_rule__InstanceSpecification__MetamodelAssignment_614763);
            ruleChoosenSpecfication();

            state._fsp--;

             after(grammarAccess.getInstanceSpecificationAccess().getMetamodelChoosenSpecficationParserRuleCall_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InstanceSpecification__MetamodelAssignment_6"


    // $ANTLR start "rule__InstanceSpecification__ConstraintSemanticsAssignment_9_0"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7380:1: rule__InstanceSpecification__ConstraintSemanticsAssignment_9_0 : ( ruleConstraintSemantic ) ;
    public final void rule__InstanceSpecification__ConstraintSemanticsAssignment_9_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7384:1: ( ( ruleConstraintSemantic ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7385:1: ( ruleConstraintSemantic )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7385:1: ( ruleConstraintSemantic )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7386:1: ruleConstraintSemantic
            {
             before(grammarAccess.getInstanceSpecificationAccess().getConstraintSemanticsConstraintSemanticParserRuleCall_9_0_0()); 
            pushFollow(FOLLOW_ruleConstraintSemantic_in_rule__InstanceSpecification__ConstraintSemanticsAssignment_9_014794);
            ruleConstraintSemantic();

            state._fsp--;

             after(grammarAccess.getInstanceSpecificationAccess().getConstraintSemanticsConstraintSemanticParserRuleCall_9_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InstanceSpecification__ConstraintSemanticsAssignment_9_0"


    // $ANTLR start "rule__InstanceSpecification__ConstraintSemanticsAssignment_9_1_1"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7395:1: rule__InstanceSpecification__ConstraintSemanticsAssignment_9_1_1 : ( ruleConstraintSemantic ) ;
    public final void rule__InstanceSpecification__ConstraintSemanticsAssignment_9_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7399:1: ( ( ruleConstraintSemantic ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7400:1: ( ruleConstraintSemantic )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7400:1: ( ruleConstraintSemantic )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7401:1: ruleConstraintSemantic
            {
             before(grammarAccess.getInstanceSpecificationAccess().getConstraintSemanticsConstraintSemanticParserRuleCall_9_1_1_0()); 
            pushFollow(FOLLOW_ruleConstraintSemantic_in_rule__InstanceSpecification__ConstraintSemanticsAssignment_9_1_114825);
            ruleConstraintSemantic();

            state._fsp--;

             after(grammarAccess.getInstanceSpecificationAccess().getConstraintSemanticsConstraintSemanticParserRuleCall_9_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InstanceSpecification__ConstraintSemanticsAssignment_9_1_1"


    // $ANTLR start "rule__ChoosenSpecfication__IdAssignment"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7410:1: rule__ChoosenSpecfication__IdAssignment : ( RULE_ID ) ;
    public final void rule__ChoosenSpecfication__IdAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7414:1: ( ( RULE_ID ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7415:1: ( RULE_ID )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7415:1: ( RULE_ID )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7416:1: RULE_ID
            {
             before(grammarAccess.getChoosenSpecficationAccess().getIdIDTerminalRuleCall_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ChoosenSpecfication__IdAssignment14856); 
             after(grammarAccess.getChoosenSpecficationAccess().getIdIDTerminalRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ChoosenSpecfication__IdAssignment"


    // $ANTLR start "rule__ConstraintSemantic__IdAssignment_0"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7425:1: rule__ConstraintSemantic__IdAssignment_0 : ( ruleDpfId ) ;
    public final void rule__ConstraintSemantic__IdAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7429:1: ( ( ruleDpfId ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7430:1: ( ruleDpfId )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7430:1: ( ruleDpfId )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7431:1: ruleDpfId
            {
             before(grammarAccess.getConstraintSemanticAccess().getIdDpfIdParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleDpfId_in_rule__ConstraintSemantic__IdAssignment_014887);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7440:1: rule__ConstraintSemantic__ArrowsAssignment_2_0 : ( ruleArrows ) ;
    public final void rule__ConstraintSemantic__ArrowsAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7444:1: ( ( ruleArrows ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7445:1: ( ruleArrows )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7445:1: ( ruleArrows )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7446:1: ruleArrows
            {
             before(grammarAccess.getConstraintSemanticAccess().getArrowsArrowsParserRuleCall_2_0_0()); 
            pushFollow(FOLLOW_ruleArrows_in_rule__ConstraintSemantic__ArrowsAssignment_2_014918);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7455:1: rule__ConstraintSemantic__ArrowsAssignment_2_1_1 : ( ruleArrows ) ;
    public final void rule__ConstraintSemantic__ArrowsAssignment_2_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7459:1: ( ( ruleArrows ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7460:1: ( ruleArrows )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7460:1: ( ruleArrows )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7461:1: ruleArrows
            {
             before(grammarAccess.getConstraintSemanticAccess().getArrowsArrowsParserRuleCall_2_1_1_0()); 
            pushFollow(FOLLOW_ruleArrows_in_rule__ConstraintSemantic__ArrowsAssignment_2_1_114949);
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


    // $ANTLR start "rule__ConstraintSemantic__OclAssignment_6"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7470:1: rule__ConstraintSemantic__OclAssignment_6 : ( RULE_STRING ) ;
    public final void rule__ConstraintSemantic__OclAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7474:1: ( ( RULE_STRING ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7475:1: ( RULE_STRING )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7475:1: ( RULE_STRING )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7476:1: RULE_STRING
            {
             before(grammarAccess.getConstraintSemanticAccess().getOclSTRINGTerminalRuleCall_6_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__ConstraintSemantic__OclAssignment_614980); 
             after(grammarAccess.getConstraintSemanticAccess().getOclSTRINGTerminalRuleCall_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConstraintSemantic__OclAssignment_6"


    // $ANTLR start "rule__Specification__TypeAssignment_2"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7485:1: rule__Specification__TypeAssignment_2 : ( ruleChoosenSpecification ) ;
    public final void rule__Specification__TypeAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7489:1: ( ( ruleChoosenSpecification ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7490:1: ( ruleChoosenSpecification )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7490:1: ( ruleChoosenSpecification )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7491:1: ruleChoosenSpecification
            {
             before(grammarAccess.getSpecificationAccess().getTypeChoosenSpecificationParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleChoosenSpecification_in_rule__Specification__TypeAssignment_215011);
            ruleChoosenSpecification();

            state._fsp--;

             after(grammarAccess.getSpecificationAccess().getTypeChoosenSpecificationParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Specification__TypeAssignment_2"


    // $ANTLR start "rule__Specification__SequenceNumberAssignment_4"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7500:1: rule__Specification__SequenceNumberAssignment_4 : ( RULE_INT ) ;
    public final void rule__Specification__SequenceNumberAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7504:1: ( ( RULE_INT ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7505:1: ( RULE_INT )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7505:1: ( RULE_INT )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7506:1: RULE_INT
            {
             before(grammarAccess.getSpecificationAccess().getSequenceNumberINTTerminalRuleCall_4_0()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__Specification__SequenceNumberAssignment_415042); 
             after(grammarAccess.getSpecificationAccess().getSequenceNumberINTTerminalRuleCall_4_0()); 

            }


            }

        }
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7515:1: rule__Specification__GraphAssignment_7 : ( ruleGraph ) ;
    public final void rule__Specification__GraphAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7519:1: ( ( ruleGraph ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7520:1: ( ruleGraph )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7520:1: ( ruleGraph )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7521:1: ruleGraph
            {
             before(grammarAccess.getSpecificationAccess().getGraphGraphParserRuleCall_7_0()); 
            pushFollow(FOLLOW_ruleGraph_in_rule__Specification__GraphAssignment_715073);
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


    // $ANTLR start "rule__Specification__ConstaintSemanticAssignment_10"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7530:1: rule__Specification__ConstaintSemanticAssignment_10 : ( ruleChoosenConstraintSemantic ) ;
    public final void rule__Specification__ConstaintSemanticAssignment_10() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7534:1: ( ( ruleChoosenConstraintSemantic ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7535:1: ( ruleChoosenConstraintSemantic )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7535:1: ( ruleChoosenConstraintSemantic )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7536:1: ruleChoosenConstraintSemantic
            {
             before(grammarAccess.getSpecificationAccess().getConstaintSemanticChoosenConstraintSemanticParserRuleCall_10_0()); 
            pushFollow(FOLLOW_ruleChoosenConstraintSemantic_in_rule__Specification__ConstaintSemanticAssignment_1015104);
            ruleChoosenConstraintSemantic();

            state._fsp--;

             after(grammarAccess.getSpecificationAccess().getConstaintSemanticChoosenConstraintSemanticParserRuleCall_10_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Specification__ConstaintSemanticAssignment_10"


    // $ANTLR start "rule__Specification__ConstraintsAssignment_13_0"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7545:1: rule__Specification__ConstraintsAssignment_13_0 : ( ruleConstraint ) ;
    public final void rule__Specification__ConstraintsAssignment_13_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7549:1: ( ( ruleConstraint ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7550:1: ( ruleConstraint )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7550:1: ( ruleConstraint )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7551:1: ruleConstraint
            {
             before(grammarAccess.getSpecificationAccess().getConstraintsConstraintParserRuleCall_13_0_0()); 
            pushFollow(FOLLOW_ruleConstraint_in_rule__Specification__ConstraintsAssignment_13_015135);
            ruleConstraint();

            state._fsp--;

             after(grammarAccess.getSpecificationAccess().getConstraintsConstraintParserRuleCall_13_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Specification__ConstraintsAssignment_13_0"


    // $ANTLR start "rule__Specification__ConstraintsAssignment_13_1_1"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7560:1: rule__Specification__ConstraintsAssignment_13_1_1 : ( ruleConstraint ) ;
    public final void rule__Specification__ConstraintsAssignment_13_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7564:1: ( ( ruleConstraint ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7565:1: ( ruleConstraint )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7565:1: ( ruleConstraint )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7566:1: ruleConstraint
            {
             before(grammarAccess.getSpecificationAccess().getConstraintsConstraintParserRuleCall_13_1_1_0()); 
            pushFollow(FOLLOW_ruleConstraint_in_rule__Specification__ConstraintsAssignment_13_1_115166);
            ruleConstraint();

            state._fsp--;

             after(grammarAccess.getSpecificationAccess().getConstraintsConstraintParserRuleCall_13_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Specification__ConstraintsAssignment_13_1_1"


    // $ANTLR start "rule__ChoosenSpecification__IdAssignment"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7575:1: rule__ChoosenSpecification__IdAssignment : ( RULE_ID ) ;
    public final void rule__ChoosenSpecification__IdAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7579:1: ( ( RULE_ID ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7580:1: ( RULE_ID )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7580:1: ( RULE_ID )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7581:1: RULE_ID
            {
             before(grammarAccess.getChoosenSpecificationAccess().getIdIDTerminalRuleCall_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ChoosenSpecification__IdAssignment15197); 
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


    // $ANTLR start "rule__ChoosenConstraintSemantic__IdAssignment"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7590:1: rule__ChoosenConstraintSemantic__IdAssignment : ( RULE_ID ) ;
    public final void rule__ChoosenConstraintSemantic__IdAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7594:1: ( ( RULE_ID ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7595:1: ( RULE_ID )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7595:1: ( RULE_ID )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7596:1: RULE_ID
            {
             before(grammarAccess.getChoosenConstraintSemanticAccess().getIdIDTerminalRuleCall_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ChoosenConstraintSemantic__IdAssignment15228); 
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7605:1: rule__Constraint__SignatureAssignment_0 : ( ruleConstraintSignature ) ;
    public final void rule__Constraint__SignatureAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7609:1: ( ( ruleConstraintSignature ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7610:1: ( ruleConstraintSignature )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7610:1: ( ruleConstraintSignature )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7611:1: ruleConstraintSignature
            {
             before(grammarAccess.getConstraintAccess().getSignatureConstraintSignatureParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleConstraintSignature_in_rule__Constraint__SignatureAssignment_015259);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7620:1: rule__Constraint__ArrowsAssignment_2_0 : ( ruleArrows ) ;
    public final void rule__Constraint__ArrowsAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7624:1: ( ( ruleArrows ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7625:1: ( ruleArrows )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7625:1: ( ruleArrows )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7626:1: ruleArrows
            {
             before(grammarAccess.getConstraintAccess().getArrowsArrowsParserRuleCall_2_0_0()); 
            pushFollow(FOLLOW_ruleArrows_in_rule__Constraint__ArrowsAssignment_2_015290);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7635:1: rule__Constraint__ArrowsAssignment_2_1_1 : ( ruleArrows ) ;
    public final void rule__Constraint__ArrowsAssignment_2_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7639:1: ( ( ruleArrows ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7640:1: ( ruleArrows )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7640:1: ( ruleArrows )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7641:1: ruleArrows
            {
             before(grammarAccess.getConstraintAccess().getArrowsArrowsParserRuleCall_2_1_1_0()); 
            pushFollow(FOLLOW_ruleArrows_in_rule__Constraint__ArrowsAssignment_2_1_115321);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7650:1: rule__ConstraintSignature__IdAssignment_0 : ( ruleDpfId ) ;
    public final void rule__ConstraintSignature__IdAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7654:1: ( ( ruleDpfId ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7655:1: ( ruleDpfId )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7655:1: ( ruleDpfId )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7656:1: ruleDpfId
            {
             before(grammarAccess.getConstraintSignatureAccess().getIdDpfIdParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleDpfId_in_rule__ConstraintSignature__IdAssignment_015352);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7665:1: rule__ConstraintSignature__ParameterAssignment_2_0 : ( RULE_ID ) ;
    public final void rule__ConstraintSignature__ParameterAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7669:1: ( ( RULE_ID ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7670:1: ( RULE_ID )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7670:1: ( RULE_ID )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7671:1: RULE_ID
            {
             before(grammarAccess.getConstraintSignatureAccess().getParameterIDTerminalRuleCall_2_0_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ConstraintSignature__ParameterAssignment_2_015383); 
             after(grammarAccess.getConstraintSignatureAccess().getParameterIDTerminalRuleCall_2_0_0()); 

            }


            }

        }
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7680:1: rule__ConstraintSignature__ParameterAssignment_2_1_1 : ( RULE_ID ) ;
    public final void rule__ConstraintSignature__ParameterAssignment_2_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7684:1: ( ( RULE_ID ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7685:1: ( RULE_ID )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7685:1: ( RULE_ID )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7686:1: RULE_ID
            {
             before(grammarAccess.getConstraintSignatureAccess().getParameterIDTerminalRuleCall_2_1_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ConstraintSignature__ParameterAssignment_2_1_115414); 
             after(grammarAccess.getConstraintSignatureAccess().getParameterIDTerminalRuleCall_2_1_1_0()); 

            }


            }

        }
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


    // $ANTLR start "rule__Morphism__DomainAssignment_4"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7695:1: rule__Morphism__DomainAssignment_4 : ( ruleDomain ) ;
    public final void rule__Morphism__DomainAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7699:1: ( ( ruleDomain ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7700:1: ( ruleDomain )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7700:1: ( ruleDomain )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7701:1: ruleDomain
            {
             before(grammarAccess.getMorphismAccess().getDomainDomainParserRuleCall_4_0()); 
            pushFollow(FOLLOW_ruleDomain_in_rule__Morphism__DomainAssignment_415445);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7710:1: rule__Morphism__CodmainAssignment_6 : ( ruleCodomain ) ;
    public final void rule__Morphism__CodmainAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7714:1: ( ( ruleCodomain ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7715:1: ( ruleCodomain )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7715:1: ( ruleCodomain )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7716:1: ruleCodomain
            {
             before(grammarAccess.getMorphismAccess().getCodmainCodomainParserRuleCall_6_0()); 
            pushFollow(FOLLOW_ruleCodomain_in_rule__Morphism__CodmainAssignment_615476);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7725:1: rule__Morphism__MappingsAssignment_9_0 : ( ruleMapping ) ;
    public final void rule__Morphism__MappingsAssignment_9_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7729:1: ( ( ruleMapping ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7730:1: ( ruleMapping )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7730:1: ( ruleMapping )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7731:1: ruleMapping
            {
             before(grammarAccess.getMorphismAccess().getMappingsMappingParserRuleCall_9_0_0()); 
            pushFollow(FOLLOW_ruleMapping_in_rule__Morphism__MappingsAssignment_9_015507);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7740:1: rule__Morphism__MappingsAssignment_9_1_1 : ( ruleMapping ) ;
    public final void rule__Morphism__MappingsAssignment_9_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7744:1: ( ( ruleMapping ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7745:1: ( ruleMapping )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7745:1: ( ruleMapping )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7746:1: ruleMapping
            {
             before(grammarAccess.getMorphismAccess().getMappingsMappingParserRuleCall_9_1_1_0()); 
            pushFollow(FOLLOW_ruleMapping_in_rule__Morphism__MappingsAssignment_9_1_115538);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7755:1: rule__Domain__IdAssignment : ( RULE_ID ) ;
    public final void rule__Domain__IdAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7759:1: ( ( RULE_ID ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7760:1: ( RULE_ID )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7760:1: ( RULE_ID )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7761:1: RULE_ID
            {
             before(grammarAccess.getDomainAccess().getIdIDTerminalRuleCall_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Domain__IdAssignment15569); 
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7770:1: rule__Codomain__IdAssignment : ( RULE_ID ) ;
    public final void rule__Codomain__IdAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7774:1: ( ( RULE_ID ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7775:1: ( RULE_ID )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7775:1: ( RULE_ID )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7776:1: RULE_ID
            {
             before(grammarAccess.getCodomainAccess().getIdIDTerminalRuleCall_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Codomain__IdAssignment15600); 
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7785:1: rule__MappingNode__DomainAssignment_0 : ( ruleNode ) ;
    public final void rule__MappingNode__DomainAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7789:1: ( ( ruleNode ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7790:1: ( ruleNode )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7790:1: ( ruleNode )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7791:1: ruleNode
            {
             before(grammarAccess.getMappingNodeAccess().getDomainNodeParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleNode_in_rule__MappingNode__DomainAssignment_015631);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7800:1: rule__MappingNode__CodomainAssignment_2 : ( ruleNode ) ;
    public final void rule__MappingNode__CodomainAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7804:1: ( ( ruleNode ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7805:1: ( ruleNode )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7805:1: ( ruleNode )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7806:1: ruleNode
            {
             before(grammarAccess.getMappingNodeAccess().getCodomainNodeParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleNode_in_rule__MappingNode__CodomainAssignment_215662);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7815:1: rule__MappingArrow__DomainAssignment_0 : ( ruleArrow ) ;
    public final void rule__MappingArrow__DomainAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7819:1: ( ( ruleArrow ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7820:1: ( ruleArrow )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7820:1: ( ruleArrow )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7821:1: ruleArrow
            {
             before(grammarAccess.getMappingArrowAccess().getDomainArrowParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleArrow_in_rule__MappingArrow__DomainAssignment_015693);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7830:1: rule__MappingArrow__CodmainAssignment_2 : ( ruleArrow ) ;
    public final void rule__MappingArrow__CodmainAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7834:1: ( ( ruleArrow ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7835:1: ( ruleArrow )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7835:1: ( ruleArrow )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7836:1: ruleArrow
            {
             before(grammarAccess.getMappingArrowAccess().getCodmainArrowParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleArrow_in_rule__MappingArrow__CodmainAssignment_215724);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7845:1: rule__ExtSubTGraph__IdAssignment_0 : ( RULE_ID ) ;
    public final void rule__ExtSubTGraph__IdAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7849:1: ( ( RULE_ID ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7850:1: ( RULE_ID )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7850:1: ( RULE_ID )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7851:1: RULE_ID
            {
             before(grammarAccess.getExtSubTGraphAccess().getIdIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ExtSubTGraph__IdAssignment_015755); 
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7860:1: rule__ExtSubTGraph__ExtendsGraphAssignment_4 : ( ruleChoosenExtSubTGraph ) ;
    public final void rule__ExtSubTGraph__ExtendsGraphAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7864:1: ( ( ruleChoosenExtSubTGraph ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7865:1: ( ruleChoosenExtSubTGraph )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7865:1: ( ruleChoosenExtSubTGraph )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7866:1: ruleChoosenExtSubTGraph
            {
             before(grammarAccess.getExtSubTGraphAccess().getExtendsGraphChoosenExtSubTGraphParserRuleCall_4_0()); 
            pushFollow(FOLLOW_ruleChoosenExtSubTGraph_in_rule__ExtSubTGraph__ExtendsGraphAssignment_415786);
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


    // $ANTLR start "rule__ExtSubTGraph__ElementsAssignment_7"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7875:1: rule__ExtSubTGraph__ElementsAssignment_7 : ( ruleElement ) ;
    public final void rule__ExtSubTGraph__ElementsAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7879:1: ( ( ruleElement ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7880:1: ( ruleElement )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7880:1: ( ruleElement )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7881:1: ruleElement
            {
             before(grammarAccess.getExtSubTGraphAccess().getElementsElementParserRuleCall_7_0()); 
            pushFollow(FOLLOW_ruleElement_in_rule__ExtSubTGraph__ElementsAssignment_715817);
            ruleElement();

            state._fsp--;

             after(grammarAccess.getExtSubTGraphAccess().getElementsElementParserRuleCall_7_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExtSubTGraph__ElementsAssignment_7"


    // $ANTLR start "rule__ChoosenExtSubTGraph__IdAssignment"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7890:1: rule__ChoosenExtSubTGraph__IdAssignment : ( RULE_ID ) ;
    public final void rule__ChoosenExtSubTGraph__IdAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7894:1: ( ( RULE_ID ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7895:1: ( RULE_ID )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7895:1: ( RULE_ID )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7896:1: RULE_ID
            {
             before(grammarAccess.getChoosenExtSubTGraphAccess().getIdIDTerminalRuleCall_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ChoosenExtSubTGraph__IdAssignment15848); 
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


    // $ANTLR start "rule__Graph__ElementsAssignment_2"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7905:1: rule__Graph__ElementsAssignment_2 : ( ruleElement ) ;
    public final void rule__Graph__ElementsAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7909:1: ( ( ruleElement ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7910:1: ( ruleElement )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7910:1: ( ruleElement )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7911:1: ruleElement
            {
             before(grammarAccess.getGraphAccess().getElementsElementParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleElement_in_rule__Graph__ElementsAssignment_215879);
            ruleElement();

            state._fsp--;

             after(grammarAccess.getGraphAccess().getElementsElementParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Graph__ElementsAssignment_2"


    // $ANTLR start "rule__Arrows__SrAssignment_0_0"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7920:1: rule__Arrows__SrAssignment_0_0 : ( ruleNode ) ;
    public final void rule__Arrows__SrAssignment_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7924:1: ( ( ruleNode ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7925:1: ( ruleNode )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7925:1: ( ruleNode )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7926:1: ruleNode
            {
             before(grammarAccess.getArrowsAccess().getSrNodeParserRuleCall_0_0_0()); 
            pushFollow(FOLLOW_ruleNode_in_rule__Arrows__SrAssignment_0_015910);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7935:1: rule__Arrows__IdAssignment_0_2 : ( ruleDpfId ) ;
    public final void rule__Arrows__IdAssignment_0_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7939:1: ( ( ruleDpfId ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7940:1: ( ruleDpfId )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7940:1: ( ruleDpfId )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7941:1: ruleDpfId
            {
             before(grammarAccess.getArrowsAccess().getIdDpfIdParserRuleCall_0_2_0()); 
            pushFollow(FOLLOW_ruleDpfId_in_rule__Arrows__IdAssignment_0_215941);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7950:1: rule__Arrows__TypeAssignment_0_4 : ( ruleDpfId ) ;
    public final void rule__Arrows__TypeAssignment_0_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7954:1: ( ( ruleDpfId ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7955:1: ( ruleDpfId )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7955:1: ( ruleDpfId )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7956:1: ruleDpfId
            {
             before(grammarAccess.getArrowsAccess().getTypeDpfIdParserRuleCall_0_4_0()); 
            pushFollow(FOLLOW_ruleDpfId_in_rule__Arrows__TypeAssignment_0_415972);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7965:1: rule__Arrows__NextAssignment_0_6 : ( ruleArrows ) ;
    public final void rule__Arrows__NextAssignment_0_6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7969:1: ( ( ruleArrows ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7970:1: ( ruleArrows )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7970:1: ( ruleArrows )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7971:1: ruleArrows
            {
             before(grammarAccess.getArrowsAccess().getNextArrowsParserRuleCall_0_6_0()); 
            pushFollow(FOLLOW_ruleArrows_in_rule__Arrows__NextAssignment_0_616003);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7980:1: rule__Arrow__SrAssignment_0_0 : ( ruleNode ) ;
    public final void rule__Arrow__SrAssignment_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7984:1: ( ( ruleNode ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7985:1: ( ruleNode )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7985:1: ( ruleNode )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7986:1: ruleNode
            {
             before(grammarAccess.getArrowAccess().getSrNodeParserRuleCall_0_0_0()); 
            pushFollow(FOLLOW_ruleNode_in_rule__Arrow__SrAssignment_0_016034);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7995:1: rule__Arrow__IdAssignment_0_2 : ( ruleDpfId ) ;
    public final void rule__Arrow__IdAssignment_0_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7999:1: ( ( ruleDpfId ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:8000:1: ( ruleDpfId )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:8000:1: ( ruleDpfId )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:8001:1: ruleDpfId
            {
             before(grammarAccess.getArrowAccess().getIdDpfIdParserRuleCall_0_2_0()); 
            pushFollow(FOLLOW_ruleDpfId_in_rule__Arrow__IdAssignment_0_216065);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:8010:1: rule__Arrow__TgDataTypeAssignment_0_6 : ( ruleDataType ) ;
    public final void rule__Arrow__TgDataTypeAssignment_0_6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:8014:1: ( ( ruleDataType ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:8015:1: ( ruleDataType )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:8015:1: ( ruleDataType )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:8016:1: ruleDataType
            {
             before(grammarAccess.getArrowAccess().getTgDataTypeDataTypeEnumRuleCall_0_6_0()); 
            pushFollow(FOLLOW_ruleDataType_in_rule__Arrow__TgDataTypeAssignment_0_616096);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:8025:1: rule__Arrow__SrAssignment_1_0 : ( ruleNode ) ;
    public final void rule__Arrow__SrAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:8029:1: ( ( ruleNode ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:8030:1: ( ruleNode )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:8030:1: ( ruleNode )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:8031:1: ruleNode
            {
             before(grammarAccess.getArrowAccess().getSrNodeParserRuleCall_1_0_0()); 
            pushFollow(FOLLOW_ruleNode_in_rule__Arrow__SrAssignment_1_016127);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:8040:1: rule__Arrow__IdAssignment_1_2 : ( ruleDpfId ) ;
    public final void rule__Arrow__IdAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:8044:1: ( ( ruleDpfId ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:8045:1: ( ruleDpfId )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:8045:1: ( ruleDpfId )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:8046:1: ruleDpfId
            {
             before(grammarAccess.getArrowAccess().getIdDpfIdParserRuleCall_1_2_0()); 
            pushFollow(FOLLOW_ruleDpfId_in_rule__Arrow__IdAssignment_1_216158);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:8055:1: rule__Arrow__TypeAssignment_1_4 : ( ruleDpfId ) ;
    public final void rule__Arrow__TypeAssignment_1_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:8059:1: ( ( ruleDpfId ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:8060:1: ( ruleDpfId )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:8060:1: ( ruleDpfId )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:8061:1: ruleDpfId
            {
             before(grammarAccess.getArrowAccess().getTypeDpfIdParserRuleCall_1_4_0()); 
            pushFollow(FOLLOW_ruleDpfId_in_rule__Arrow__TypeAssignment_1_416189);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:8070:1: rule__Arrow__TgValueAssignment_1_6 : ( ruleAttributeValue ) ;
    public final void rule__Arrow__TgValueAssignment_1_6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:8074:1: ( ( ruleAttributeValue ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:8075:1: ( ruleAttributeValue )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:8075:1: ( ruleAttributeValue )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:8076:1: ruleAttributeValue
            {
             before(grammarAccess.getArrowAccess().getTgValueAttributeValueParserRuleCall_1_6_0()); 
            pushFollow(FOLLOW_ruleAttributeValue_in_rule__Arrow__TgValueAssignment_1_616220);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:8085:1: rule__Arrow__SrAssignment_2_0 : ( ruleNode ) ;
    public final void rule__Arrow__SrAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:8089:1: ( ( ruleNode ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:8090:1: ( ruleNode )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:8090:1: ( ruleNode )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:8091:1: ruleNode
            {
             before(grammarAccess.getArrowAccess().getSrNodeParserRuleCall_2_0_0()); 
            pushFollow(FOLLOW_ruleNode_in_rule__Arrow__SrAssignment_2_016251);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:8100:1: rule__Arrow__IdAssignment_2_2 : ( ruleDpfId ) ;
    public final void rule__Arrow__IdAssignment_2_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:8104:1: ( ( ruleDpfId ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:8105:1: ( ruleDpfId )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:8105:1: ( ruleDpfId )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:8106:1: ruleDpfId
            {
             before(grammarAccess.getArrowAccess().getIdDpfIdParserRuleCall_2_2_0()); 
            pushFollow(FOLLOW_ruleDpfId_in_rule__Arrow__IdAssignment_2_216282);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:8115:1: rule__Arrow__TypeAssignment_2_4 : ( ruleDpfId ) ;
    public final void rule__Arrow__TypeAssignment_2_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:8119:1: ( ( ruleDpfId ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:8120:1: ( ruleDpfId )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:8120:1: ( ruleDpfId )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:8121:1: ruleDpfId
            {
             before(grammarAccess.getArrowAccess().getTypeDpfIdParserRuleCall_2_4_0()); 
            pushFollow(FOLLOW_ruleDpfId_in_rule__Arrow__TypeAssignment_2_416313);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:8130:1: rule__Arrow__TgNodeAssignment_2_6 : ( ruleNode ) ;
    public final void rule__Arrow__TgNodeAssignment_2_6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:8134:1: ( ( ruleNode ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:8135:1: ( ruleNode )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:8135:1: ( ruleNode )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:8136:1: ruleNode
            {
             before(grammarAccess.getArrowAccess().getTgNodeNodeParserRuleCall_2_6_0()); 
            pushFollow(FOLLOW_ruleNode_in_rule__Arrow__TgNodeAssignment_2_616344);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:8145:1: rule__Node__IdAssignment_0 : ( ruleDpfId ) ;
    public final void rule__Node__IdAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:8149:1: ( ( ruleDpfId ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:8150:1: ( ruleDpfId )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:8150:1: ( ruleDpfId )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:8151:1: ruleDpfId
            {
             before(grammarAccess.getNodeAccess().getIdDpfIdParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleDpfId_in_rule__Node__IdAssignment_016375);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:8160:1: rule__Node__TypeAssignment_2 : ( ruleDpfId ) ;
    public final void rule__Node__TypeAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:8164:1: ( ( ruleDpfId ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:8165:1: ( ruleDpfId )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:8165:1: ( ruleDpfId )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:8166:1: ruleDpfId
            {
             before(grammarAccess.getNodeAccess().getTypeDpfIdParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleDpfId_in_rule__Node__TypeAssignment_216406);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:8175:1: rule__AttributeValue__ValueAssignment_1 : ( ruleVALUE ) ;
    public final void rule__AttributeValue__ValueAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:8179:1: ( ( ruleVALUE ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:8180:1: ( ruleVALUE )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:8180:1: ( ruleVALUE )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:8181:1: ruleVALUE
            {
             before(grammarAccess.getAttributeValueAccess().getValueVALUEParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleVALUE_in_rule__AttributeValue__ValueAssignment_116437);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:8190:1: rule__DpfId__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__DpfId__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:8194:1: ( ( RULE_ID ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:8195:1: ( RULE_ID )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:8195:1: ( RULE_ID )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:8196:1: RULE_ID
            {
             before(grammarAccess.getDpfIdAccess().getNameIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__DpfId__NameAssignment_016468); 
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:8205:1: rule__DpfId__IdAssignment_1_1 : ( RULE_INT ) ;
    public final void rule__DpfId__IdAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:8209:1: ( ( RULE_INT ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:8210:1: ( RULE_INT )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:8210:1: ( RULE_INT )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:8211:1: RULE_INT
            {
             before(grammarAccess.getDpfIdAccess().getIdINTTerminalRuleCall_1_1_0()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__DpfId__IdAssignment_1_116499); 
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
    protected DFA5 dfa5 = new DFA5(this);
    protected DFA6 dfa6 = new DFA6(this);
    protected DFA7 dfa7 = new DFA7(this);
    protected DFA8 dfa8 = new DFA8(this);
    static final String DFA4_eotS =
        "\21\uffff";
    static final String DFA4_eofS =
        "\21\uffff";
    static final String DFA4_minS =
        "\1\7\1\41\3\uffff\2\7\1\42\1\33\1\37\7\uffff";
    static final String DFA4_maxS =
        "\1\36\1\41\3\uffff\2\7\1\56\1\34\1\40\7\uffff";
    static final String DFA4_acceptS =
        "\2\uffff\1\3\1\4\1\5\5\uffff\1\2\1\1\1\10\1\6\1\7\1\12\1\11";
    static final String DFA4_specialS =
        "\21\uffff}>";
    static final String[] DFA4_transitionS = {
            "\1\1\16\uffff\1\2\1\uffff\1\3\1\4\1\5\3\uffff\1\6",
            "\1\7",
            "",
            "",
            "",
            "\1\10",
            "\1\11",
            "\1\13\11\uffff\1\14\1\uffff\1\12",
            "\1\15\1\16",
            "\1\20\1\17",
            "",
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
            return "1053:1: rule__Command__Alternatives : ( ( ruleInstanceSpecification ) | ( ruleExtSubTGraph ) | ( ruleMakeEmf ) | ( ruleMakeEcore ) | ( ruleMakeImage ) | ( ruleSimpleEvoSpan ) | ( ruleSimpleEvoCospan ) | ( ruleMorphism ) | ( ruleEvoSpan ) | ( ruleEvoCospan ) );";
        }
    }
    static final String DFA5_eotS =
        "\12\uffff";
    static final String DFA5_eofS =
        "\12\uffff";
    static final String DFA5_minS =
        "\1\7\1\51\1\10\1\7\1\51\1\55\1\10\2\uffff\1\55";
    static final String DFA5_maxS =
        "\1\7\1\64\1\10\1\7\1\51\1\64\1\10\2\uffff\1\60";
    static final String DFA5_acceptS =
        "\7\uffff\1\2\1\1\1\uffff";
    static final String DFA5_specialS =
        "\12\uffff}>";
    static final String[] DFA5_transitionS = {
            "\1\1",
            "\1\3\12\uffff\1\2",
            "\1\4",
            "\1\5",
            "\1\3",
            "\1\10\2\uffff\1\7\3\uffff\1\6",
            "\1\11",
            "",
            "",
            "\1\10\2\uffff\1\7"
    };

    static final short[] DFA5_eot = DFA.unpackEncodedString(DFA5_eotS);
    static final short[] DFA5_eof = DFA.unpackEncodedString(DFA5_eofS);
    static final char[] DFA5_min = DFA.unpackEncodedStringToUnsignedChars(DFA5_minS);
    static final char[] DFA5_max = DFA.unpackEncodedStringToUnsignedChars(DFA5_maxS);
    static final short[] DFA5_accept = DFA.unpackEncodedString(DFA5_acceptS);
    static final short[] DFA5_special = DFA.unpackEncodedString(DFA5_specialS);
    static final short[][] DFA5_transition;

    static {
        int numStates = DFA5_transitionS.length;
        DFA5_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA5_transition[i] = DFA.unpackEncodedString(DFA5_transitionS[i]);
        }
    }

    class DFA5 extends DFA {

        public DFA5(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 5;
            this.eot = DFA5_eot;
            this.eof = DFA5_eof;
            this.min = DFA5_min;
            this.max = DFA5_max;
            this.accept = DFA5_accept;
            this.special = DFA5_special;
            this.transition = DFA5_transition;
        }
        public String getDescription() {
            return "1123:1: rule__Mapping__Alternatives : ( ( ruleMappingNode ) | ( ruleMappingArrow ) );";
        }
    }
    static final String DFA6_eotS =
        "\12\uffff";
    static final String DFA6_eofS =
        "\12\uffff";
    static final String DFA6_minS =
        "\1\7\1\51\1\10\1\7\1\51\1\35\1\10\2\uffff\1\35";
    static final String DFA6_maxS =
        "\1\7\1\64\1\10\1\7\1\51\1\64\1\10\2\uffff\1\60";
    static final String DFA6_acceptS =
        "\7\uffff\1\2\1\1\1\uffff";
    static final String DFA6_specialS =
        "\12\uffff}>";
    static final String[] DFA6_transitionS = {
            "\1\1",
            "\1\3\12\uffff\1\2",
            "\1\4",
            "\1\5",
            "\1\3",
            "\1\10\22\uffff\1\7\3\uffff\1\6",
            "\1\11",
            "",
            "",
            "\1\10\22\uffff\1\7"
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
            return "1145:1: rule__Element__Alternatives : ( ( ( rule__Element__Group_0__0 ) ) | ( ( rule__Element__Group_1__0 ) ) );";
        }
    }
    static final String DFA7_eotS =
        "\32\uffff";
    static final String DFA7_eofS =
        "\26\uffff\1\16\2\uffff\1\16";
    static final String DFA7_minS =
        "\1\7\1\51\1\10\1\7\1\51\1\60\1\10\1\7\1\60\1\51\1\10\1\7\1\51\1"+
        "\34\1\uffff\1\10\1\7\1\34\1\51\1\10\1\7\1\51\1\35\1\10\1\uffff\1"+
        "\35";
    static final String DFA7_maxS =
        "\1\7\1\64\1\10\1\7\1\51\1\64\1\10\1\7\1\60\1\64\1\10\1\61\1\51\1"+
        "\64\1\uffff\1\10\1\62\1\34\1\64\1\10\1\7\1\51\1\64\1\10\1\uffff"+
        "\1\60";
    static final String DFA7_acceptS =
        "\16\uffff\1\2\11\uffff\1\1\1\uffff";
    static final String DFA7_specialS =
        "\32\uffff}>";
    static final String[] DFA7_transitionS = {
            "\1\1",
            "\1\3\12\uffff\1\2",
            "\1\4",
            "\1\5",
            "\1\3",
            "\1\7\3\uffff\1\6",
            "\1\10",
            "\1\11",
            "\1\7",
            "\1\13\12\uffff\1\12",
            "\1\14",
            "\1\15\51\uffff\1\16",
            "\1\13",
            "\1\20\27\uffff\1\17",
            "",
            "\1\21",
            "\1\22\52\uffff\1\16",
            "\1\20",
            "\1\24\12\uffff\1\23",
            "\1\25",
            "\1\26",
            "\1\24",
            "\1\16\10\uffff\1\16\11\uffff\1\30\3\uffff\1\27",
            "\1\31",
            "",
            "\1\16\10\uffff\1\16\11\uffff\1\30"
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
            return "1167:1: rule__Arrows__Alternatives : ( ( ( rule__Arrows__Group_0__0 ) ) | ( ruleArrow ) );";
        }
    }
    static final String DFA8_eotS =
        "\24\uffff";
    static final String DFA8_eofS =
        "\24\uffff";
    static final String DFA8_minS =
        "\1\7\1\51\1\10\1\7\1\51\1\60\1\10\1\7\1\60\1\51\1\10\1\7\1\51\1"+
        "\uffff\1\34\1\10\1\7\1\34\2\uffff";
    static final String DFA8_maxS =
        "\1\7\1\64\1\10\1\7\1\51\1\64\1\10\1\7\1\60\1\64\1\10\1\61\1\51\1"+
        "\uffff\1\64\1\10\1\62\1\34\2\uffff";
    static final String DFA8_acceptS =
        "\15\uffff\1\1\4\uffff\1\2\1\3";
    static final String DFA8_specialS =
        "\24\uffff}>";
    static final String[] DFA8_transitionS = {
            "\1\1",
            "\1\3\12\uffff\1\2",
            "\1\4",
            "\1\5",
            "\1\3",
            "\1\7\3\uffff\1\6",
            "\1\10",
            "\1\11",
            "\1\7",
            "\1\13\12\uffff\1\12",
            "\1\14",
            "\1\16\51\uffff\1\15",
            "\1\13",
            "",
            "\1\20\27\uffff\1\17",
            "\1\21",
            "\1\23\52\uffff\1\22",
            "\1\20",
            "",
            ""
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
            return "1189:1: rule__Arrow__Alternatives : ( ( ( rule__Arrow__Group_0__0 ) ) | ( ( rule__Arrow__Group_1__0 ) ) | ( ( rule__Arrow__Group_2__0 ) ) );";
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
    public static final BitSet FOLLOW_ruleInstanceSpecification_in_entryRuleInstanceSpecification661 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInstanceSpecification668 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__InstanceSpecification__Group__0_in_ruleInstanceSpecification694 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleChoosenSpecfication_in_entryRuleChoosenSpecfication721 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleChoosenSpecfication728 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ChoosenSpecfication__IdAssignment_in_ruleChoosenSpecfication754 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConstraintSemantic_in_entryRuleConstraintSemantic781 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConstraintSemantic788 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConstraintSemantic__Group__0_in_ruleConstraintSemantic814 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSpecification_in_entryRuleSpecification841 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSpecification848 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Specification__Group__0_in_ruleSpecification874 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleChoosenSpecification_in_entryRuleChoosenSpecification901 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleChoosenSpecification908 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ChoosenSpecification__IdAssignment_in_ruleChoosenSpecification934 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleChoosenConstraintSemantic_in_entryRuleChoosenConstraintSemantic961 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleChoosenConstraintSemantic968 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ChoosenConstraintSemantic__IdAssignment_in_ruleChoosenConstraintSemantic994 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConstraint_in_entryRuleConstraint1021 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConstraint1028 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Constraint__Group__0_in_ruleConstraint1054 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConstraintSignature_in_entryRuleConstraintSignature1081 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConstraintSignature1088 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConstraintSignature__Group__0_in_ruleConstraintSignature1114 = new BitSet(new long[]{0x0000000000000002L});
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
    public static final BitSet FOLLOW_rule__Model__Group_1__0_in_rule__Model__Alternatives2103 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NUMBER_in_rule__VALUE__Alternatives2137 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_CHAR_in_rule__VALUE__Alternatives2154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__VALUE__Alternatives2171 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInstanceSpecification_in_rule__Command__Alternatives2203 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExtSubTGraph_in_rule__Command__Alternatives2220 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMakeEmf_in_rule__Command__Alternatives2237 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMakeEcore_in_rule__Command__Alternatives2254 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMakeImage_in_rule__Command__Alternatives2271 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSimpleEvoSpan_in_rule__Command__Alternatives2288 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSimpleEvoCospan_in_rule__Command__Alternatives2305 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMorphism_in_rule__Command__Alternatives2322 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEvoSpan_in_rule__Command__Alternatives2339 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEvoCospan_in_rule__Command__Alternatives2356 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMappingNode_in_rule__Mapping__Alternatives2388 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMappingArrow_in_rule__Mapping__Alternatives2405 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Element__Group_0__0_in_rule__Element__Alternatives2437 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Element__Group_1__0_in_rule__Element__Alternatives2455 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrows__Group_0__0_in_rule__Arrows__Alternatives2488 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArrow_in_rule__Arrows__Alternatives2506 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrow__Group_0__0_in_rule__Arrow__Alternatives2538 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrow__Group_1__0_in_rule__Arrow__Alternatives2556 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrow__Group_2__0_in_rule__Arrow__Alternatives2574 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__DataType__Alternatives2608 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__DataType__Alternatives2629 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__DataType__Alternatives2650 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__DataType__Alternatives2671 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__DataType__Alternatives2692 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__DataType__Alternatives2713 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__DataType__Alternatives2734 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__DataType__Alternatives2755 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__DataType__Alternatives2776 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__Group_1__0__Impl_in_rule__Model__Group_1__02809 = new BitSet(new long[]{0x0000000047400080L});
    public static final BitSet FOLLOW_rule__Model__Group_1__1_in_rule__Model__Group_1__02812 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__CommandsAssignment_1_0_in_rule__Model__Group_1__0__Impl2839 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__Group_1__1__Impl_in_rule__Model__Group_1__12869 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__CommandsAssignment_1_1_in_rule__Model__Group_1__1__Impl2896 = new BitSet(new long[]{0x0000000047400082L});
    public static final BitSet FOLLOW_rule__MakeEmf__Group__0__Impl_in_rule__MakeEmf__Group__02931 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__MakeEmf__Group__1_in_rule__MakeEmf__Group__02934 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rule__MakeEmf__Group__0__Impl2962 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MakeEmf__Group__1__Impl_in_rule__MakeEmf__Group__12993 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_rule__MakeEmf__Group__2_in_rule__MakeEmf__Group__12996 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MakeEmf__IdAssignment_1_in_rule__MakeEmf__Group__1__Impl3023 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MakeEmf__Group__2__Impl_in_rule__MakeEmf__Group__23053 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__MakeEmf__Group__2__Impl3081 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MakeEcore__Group__0__Impl_in_rule__MakeEcore__Group__03118 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__MakeEcore__Group__1_in_rule__MakeEcore__Group__03121 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__MakeEcore__Group__0__Impl3149 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MakeEcore__Group__1__Impl_in_rule__MakeEcore__Group__13180 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_rule__MakeEcore__Group__2_in_rule__MakeEcore__Group__13183 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MakeEcore__IdAssignment_1_in_rule__MakeEcore__Group__1__Impl3210 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MakeEcore__Group__2__Impl_in_rule__MakeEcore__Group__23240 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__MakeEcore__Group__2__Impl3268 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MakeImage__Group__0__Impl_in_rule__MakeImage__Group__03305 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__MakeImage__Group__1_in_rule__MakeImage__Group__03308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_rule__MakeImage__Group__0__Impl3336 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MakeImage__Group__1__Impl_in_rule__MakeImage__Group__13367 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_rule__MakeImage__Group__2_in_rule__MakeImage__Group__13370 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MakeImage__IdAssignment_1_in_rule__MakeImage__Group__1__Impl3397 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MakeImage__Group__2__Impl_in_rule__MakeImage__Group__23427 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__MakeImage__Group__2__Impl3455 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleEvoSpan__Group__0__Impl_in_rule__SimpleEvoSpan__Group__03492 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__SimpleEvoSpan__Group__1_in_rule__SimpleEvoSpan__Group__03495 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__SimpleEvoSpan__Group__0__Impl3523 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleEvoSpan__Group__1__Impl_in_rule__SimpleEvoSpan__Group__13554 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_rule__SimpleEvoSpan__Group__2_in_rule__SimpleEvoSpan__Group__13557 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleEvoSpan__LhsAssignment_1_in_rule__SimpleEvoSpan__Group__1__Impl3584 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleEvoSpan__Group__2__Impl_in_rule__SimpleEvoSpan__Group__23614 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__SimpleEvoSpan__Group__3_in_rule__SimpleEvoSpan__Group__23617 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_rule__SimpleEvoSpan__Group__2__Impl3645 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleEvoSpan__Group__3__Impl_in_rule__SimpleEvoSpan__Group__33676 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_rule__SimpleEvoSpan__Group__4_in_rule__SimpleEvoSpan__Group__33679 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleEvoSpan__DiffAssignment_3_in_rule__SimpleEvoSpan__Group__3__Impl3706 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleEvoSpan__Group__4__Impl_in_rule__SimpleEvoSpan__Group__43736 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__SimpleEvoSpan__Group__5_in_rule__SimpleEvoSpan__Group__43739 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__SimpleEvoSpan__Group__4__Impl3767 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleEvoSpan__Group__5__Impl_in_rule__SimpleEvoSpan__Group__53798 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_rule__SimpleEvoSpan__Group__6_in_rule__SimpleEvoSpan__Group__53801 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleEvoSpan__RhSAssignment_5_in_rule__SimpleEvoSpan__Group__5__Impl3828 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleEvoSpan__Group__6__Impl_in_rule__SimpleEvoSpan__Group__63858 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__SimpleEvoSpan__Group__7_in_rule__SimpleEvoSpan__Group__63861 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__SimpleEvoSpan__Group__6__Impl3889 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleEvoSpan__Group__7__Impl_in_rule__SimpleEvoSpan__Group__73920 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_rule__SimpleEvoSpan__Group__8_in_rule__SimpleEvoSpan__Group__73923 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleEvoSpan__TypeGraphAssignment_7_in_rule__SimpleEvoSpan__Group__7__Impl3950 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleEvoSpan__Group__8__Impl_in_rule__SimpleEvoSpan__Group__83980 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__SimpleEvoSpan__Group__8__Impl4008 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleEvoCospan__Group__0__Impl_in_rule__SimpleEvoCospan__Group__04057 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__SimpleEvoCospan__Group__1_in_rule__SimpleEvoCospan__Group__04060 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__SimpleEvoCospan__Group__0__Impl4088 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleEvoCospan__Group__1__Impl_in_rule__SimpleEvoCospan__Group__14119 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_rule__SimpleEvoCospan__Group__2_in_rule__SimpleEvoCospan__Group__14122 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleEvoCospan__LhsAssignment_1_in_rule__SimpleEvoCospan__Group__1__Impl4149 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleEvoCospan__Group__2__Impl_in_rule__SimpleEvoCospan__Group__24179 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__SimpleEvoCospan__Group__3_in_rule__SimpleEvoCospan__Group__24182 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__SimpleEvoCospan__Group__2__Impl4210 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleEvoCospan__Group__3__Impl_in_rule__SimpleEvoCospan__Group__34241 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_rule__SimpleEvoCospan__Group__4_in_rule__SimpleEvoCospan__Group__34244 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleEvoCospan__JointAssignment_3_in_rule__SimpleEvoCospan__Group__3__Impl4271 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleEvoCospan__Group__4__Impl_in_rule__SimpleEvoCospan__Group__44301 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__SimpleEvoCospan__Group__5_in_rule__SimpleEvoCospan__Group__44304 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_rule__SimpleEvoCospan__Group__4__Impl4332 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleEvoCospan__Group__5__Impl_in_rule__SimpleEvoCospan__Group__54363 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_rule__SimpleEvoCospan__Group__6_in_rule__SimpleEvoCospan__Group__54366 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleEvoCospan__RhsAssignment_5_in_rule__SimpleEvoCospan__Group__5__Impl4393 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleEvoCospan__Group__6__Impl_in_rule__SimpleEvoCospan__Group__64423 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__SimpleEvoCospan__Group__7_in_rule__SimpleEvoCospan__Group__64426 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__SimpleEvoCospan__Group__6__Impl4454 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleEvoCospan__Group__7__Impl_in_rule__SimpleEvoCospan__Group__74485 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_rule__SimpleEvoCospan__Group__8_in_rule__SimpleEvoCospan__Group__74488 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleEvoCospan__TypeGraphAssignment_7_in_rule__SimpleEvoCospan__Group__7__Impl4515 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleEvoCospan__Group__8__Impl_in_rule__SimpleEvoCospan__Group__84545 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__SimpleEvoCospan__Group__8__Impl4573 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EvoSpan__Group__0__Impl_in_rule__EvoSpan__Group__04622 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__EvoSpan__Group__1_in_rule__EvoSpan__Group__04625 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_rule__EvoSpan__Group__0__Impl4653 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EvoSpan__Group__1__Impl_in_rule__EvoSpan__Group__14684 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_rule__EvoSpan__Group__2_in_rule__EvoSpan__Group__14687 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EvoSpan__LhsAssignment_1_in_rule__EvoSpan__Group__1__Impl4714 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EvoSpan__Group__2__Impl_in_rule__EvoSpan__Group__24744 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__EvoSpan__Group__3_in_rule__EvoSpan__Group__24747 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_rule__EvoSpan__Group__2__Impl4775 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EvoSpan__Group__3__Impl_in_rule__EvoSpan__Group__34806 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_rule__EvoSpan__Group__4_in_rule__EvoSpan__Group__34809 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EvoSpan__RhsAssignment_3_in_rule__EvoSpan__Group__3__Impl4836 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EvoSpan__Group__4__Impl_in_rule__EvoSpan__Group__44866 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__EvoSpan__Group__5_in_rule__EvoSpan__Group__44869 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__EvoSpan__Group__4__Impl4897 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EvoSpan__Group__5__Impl_in_rule__EvoSpan__Group__54928 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_rule__EvoSpan__Group__6_in_rule__EvoSpan__Group__54931 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EvoSpan__TypeGraphAssignment_5_in_rule__EvoSpan__Group__5__Impl4958 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EvoSpan__Group__6__Impl_in_rule__EvoSpan__Group__64988 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__EvoSpan__Group__6__Impl5016 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EvoCospan__Group__0__Impl_in_rule__EvoCospan__Group__05061 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__EvoCospan__Group__1_in_rule__EvoCospan__Group__05064 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_rule__EvoCospan__Group__0__Impl5092 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EvoCospan__Group__1__Impl_in_rule__EvoCospan__Group__15123 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_rule__EvoCospan__Group__2_in_rule__EvoCospan__Group__15126 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EvoCospan__LhsAssignment_1_in_rule__EvoCospan__Group__1__Impl5153 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EvoCospan__Group__2__Impl_in_rule__EvoCospan__Group__25183 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__EvoCospan__Group__3_in_rule__EvoCospan__Group__25186 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_rule__EvoCospan__Group__2__Impl5214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EvoCospan__Group__3__Impl_in_rule__EvoCospan__Group__35245 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_rule__EvoCospan__Group__4_in_rule__EvoCospan__Group__35248 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EvoCospan__RhsAssignment_3_in_rule__EvoCospan__Group__3__Impl5275 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EvoCospan__Group__4__Impl_in_rule__EvoCospan__Group__45305 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__EvoCospan__Group__5_in_rule__EvoCospan__Group__45308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__EvoCospan__Group__4__Impl5336 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EvoCospan__Group__5__Impl_in_rule__EvoCospan__Group__55367 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_rule__EvoCospan__Group__6_in_rule__EvoCospan__Group__55370 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EvoCospan__TypeGraphAssignment_5_in_rule__EvoCospan__Group__5__Impl5397 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EvoCospan__Group__6__Impl_in_rule__EvoCospan__Group__65427 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__EvoCospan__Group__6__Impl5455 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__InstanceSpecification__Group__0__Impl_in_rule__InstanceSpecification__Group__05500 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_rule__InstanceSpecification__Group__1_in_rule__InstanceSpecification__Group__05503 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__InstanceSpecification__IdAssignment_0_in_rule__InstanceSpecification__Group__0__Impl5530 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__InstanceSpecification__Group__1__Impl_in_rule__InstanceSpecification__Group__15560 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_rule__InstanceSpecification__Group__2_in_rule__InstanceSpecification__Group__15563 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_rule__InstanceSpecification__Group__1__Impl5591 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__InstanceSpecification__Group__2__Impl_in_rule__InstanceSpecification__Group__25622 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_rule__InstanceSpecification__Group__3_in_rule__InstanceSpecification__Group__25625 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_rule__InstanceSpecification__Group__2__Impl5653 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__InstanceSpecification__Group__3__Impl_in_rule__InstanceSpecification__Group__35684 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__InstanceSpecification__Group__4_in_rule__InstanceSpecification__Group__35687 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_rule__InstanceSpecification__Group__3__Impl5715 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__InstanceSpecification__Group__4__Impl_in_rule__InstanceSpecification__Group__45746 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_rule__InstanceSpecification__Group__5_in_rule__InstanceSpecification__Group__45749 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__InstanceSpecification__ModelAssignment_4_in_rule__InstanceSpecification__Group__4__Impl5776 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__InstanceSpecification__Group__5__Impl_in_rule__InstanceSpecification__Group__55806 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__InstanceSpecification__Group__6_in_rule__InstanceSpecification__Group__55809 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__InstanceSpecification__Group__5__Impl5837 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__InstanceSpecification__Group__6__Impl_in_rule__InstanceSpecification__Group__65868 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_rule__InstanceSpecification__Group__7_in_rule__InstanceSpecification__Group__65871 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__InstanceSpecification__MetamodelAssignment_6_in_rule__InstanceSpecification__Group__6__Impl5898 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__InstanceSpecification__Group__7__Impl_in_rule__InstanceSpecification__Group__75928 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_rule__InstanceSpecification__Group__8_in_rule__InstanceSpecification__Group__75931 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_rule__InstanceSpecification__Group__7__Impl5959 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__InstanceSpecification__Group__8__Impl_in_rule__InstanceSpecification__Group__85990 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__InstanceSpecification__Group__9_in_rule__InstanceSpecification__Group__85993 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_rule__InstanceSpecification__Group__8__Impl6021 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__InstanceSpecification__Group__9__Impl_in_rule__InstanceSpecification__Group__96052 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_rule__InstanceSpecification__Group__10_in_rule__InstanceSpecification__Group__96055 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__InstanceSpecification__Group_9__0_in_rule__InstanceSpecification__Group__9__Impl6082 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__InstanceSpecification__Group__10__Impl_in_rule__InstanceSpecification__Group__106112 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_rule__InstanceSpecification__Group__10__Impl6140 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__InstanceSpecification__Group_9__0__Impl_in_rule__InstanceSpecification__Group_9__06193 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_rule__InstanceSpecification__Group_9__1_in_rule__InstanceSpecification__Group_9__06196 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__InstanceSpecification__ConstraintSemanticsAssignment_9_0_in_rule__InstanceSpecification__Group_9__0__Impl6223 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__InstanceSpecification__Group_9__1__Impl_in_rule__InstanceSpecification__Group_9__16253 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__InstanceSpecification__Group_9_1__0_in_rule__InstanceSpecification__Group_9__1__Impl6280 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_rule__InstanceSpecification__Group_9_1__0__Impl_in_rule__InstanceSpecification__Group_9_1__06315 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__InstanceSpecification__Group_9_1__1_in_rule__InstanceSpecification__Group_9_1__06318 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__InstanceSpecification__Group_9_1__0__Impl6346 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__InstanceSpecification__Group_9_1__1__Impl_in_rule__InstanceSpecification__Group_9_1__16377 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__InstanceSpecification__ConstraintSemanticsAssignment_9_1_1_in_rule__InstanceSpecification__Group_9_1__1__Impl6404 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConstraintSemantic__Group__0__Impl_in_rule__ConstraintSemantic__Group__06438 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_rule__ConstraintSemantic__Group__1_in_rule__ConstraintSemantic__Group__06441 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConstraintSemantic__IdAssignment_0_in_rule__ConstraintSemantic__Group__0__Impl6468 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConstraintSemantic__Group__1__Impl_in_rule__ConstraintSemantic__Group__16498 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__ConstraintSemantic__Group__2_in_rule__ConstraintSemantic__Group__16501 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_rule__ConstraintSemantic__Group__1__Impl6529 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConstraintSemantic__Group__2__Impl_in_rule__ConstraintSemantic__Group__26560 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_rule__ConstraintSemantic__Group__3_in_rule__ConstraintSemantic__Group__26563 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConstraintSemantic__Group_2__0_in_rule__ConstraintSemantic__Group__2__Impl6590 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConstraintSemantic__Group__3__Impl_in_rule__ConstraintSemantic__Group__36620 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_rule__ConstraintSemantic__Group__4_in_rule__ConstraintSemantic__Group__36623 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__ConstraintSemantic__Group__3__Impl6651 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConstraintSemantic__Group__4__Impl_in_rule__ConstraintSemantic__Group__46682 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_rule__ConstraintSemantic__Group__5_in_rule__ConstraintSemantic__Group__46685 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_rule__ConstraintSemantic__Group__4__Impl6713 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConstraintSemantic__Group__5__Impl_in_rule__ConstraintSemantic__Group__56744 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__ConstraintSemantic__Group__6_in_rule__ConstraintSemantic__Group__56747 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_rule__ConstraintSemantic__Group__5__Impl6775 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConstraintSemantic__Group__6__Impl_in_rule__ConstraintSemantic__Group__66806 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConstraintSemantic__OclAssignment_6_in_rule__ConstraintSemantic__Group__6__Impl6833 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConstraintSemantic__Group_2__0__Impl_in_rule__ConstraintSemantic__Group_2__06877 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_rule__ConstraintSemantic__Group_2__1_in_rule__ConstraintSemantic__Group_2__06880 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConstraintSemantic__ArrowsAssignment_2_0_in_rule__ConstraintSemantic__Group_2__0__Impl6907 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConstraintSemantic__Group_2__1__Impl_in_rule__ConstraintSemantic__Group_2__16937 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConstraintSemantic__Group_2_1__0_in_rule__ConstraintSemantic__Group_2__1__Impl6964 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_rule__ConstraintSemantic__Group_2_1__0__Impl_in_rule__ConstraintSemantic__Group_2_1__06999 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__ConstraintSemantic__Group_2_1__1_in_rule__ConstraintSemantic__Group_2_1__07002 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__ConstraintSemantic__Group_2_1__0__Impl7030 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConstraintSemantic__Group_2_1__1__Impl_in_rule__ConstraintSemantic__Group_2_1__17061 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConstraintSemantic__ArrowsAssignment_2_1_1_in_rule__ConstraintSemantic__Group_2_1__1__Impl7088 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Specification__Group__0__Impl_in_rule__Specification__Group__07122 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_rule__Specification__Group__1_in_rule__Specification__Group__07125 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_rule__Specification__Group__0__Impl7153 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Specification__Group__1__Impl_in_rule__Specification__Group__17184 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__Specification__Group__2_in_rule__Specification__Group__17187 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_rule__Specification__Group__1__Impl7215 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Specification__Group__2__Impl_in_rule__Specification__Group__27246 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_rule__Specification__Group__3_in_rule__Specification__Group__27249 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Specification__TypeAssignment_2_in_rule__Specification__Group__2__Impl7276 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Specification__Group__3__Impl_in_rule__Specification__Group__37306 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_rule__Specification__Group__4_in_rule__Specification__Group__37309 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_rule__Specification__Group__3__Impl7337 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Specification__Group__4__Impl_in_rule__Specification__Group__47368 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_rule__Specification__Group__5_in_rule__Specification__Group__47371 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Specification__SequenceNumberAssignment_4_in_rule__Specification__Group__4__Impl7398 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Specification__Group__5__Impl_in_rule__Specification__Group__57428 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_rule__Specification__Group__6_in_rule__Specification__Group__57431 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_rule__Specification__Group__5__Impl7459 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Specification__Group__6__Impl_in_rule__Specification__Group__67490 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_rule__Specification__Group__7_in_rule__Specification__Group__67493 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_rule__Specification__Group__6__Impl7521 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Specification__Group__7__Impl_in_rule__Specification__Group__77552 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_rule__Specification__Group__8_in_rule__Specification__Group__77555 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Specification__GraphAssignment_7_in_rule__Specification__Group__7__Impl7582 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Specification__Group__8__Impl_in_rule__Specification__Group__87612 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_rule__Specification__Group__9_in_rule__Specification__Group__87615 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_rule__Specification__Group__8__Impl7643 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Specification__Group__9__Impl_in_rule__Specification__Group__97674 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__Specification__Group__10_in_rule__Specification__Group__97677 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_rule__Specification__Group__9__Impl7705 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Specification__Group__10__Impl_in_rule__Specification__Group__107736 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_rule__Specification__Group__11_in_rule__Specification__Group__107739 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Specification__ConstaintSemanticAssignment_10_in_rule__Specification__Group__10__Impl7766 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Specification__Group__11__Impl_in_rule__Specification__Group__117796 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_rule__Specification__Group__12_in_rule__Specification__Group__117799 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_rule__Specification__Group__11__Impl7827 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Specification__Group__12__Impl_in_rule__Specification__Group__127858 = new BitSet(new long[]{0x0000004000000080L});
    public static final BitSet FOLLOW_rule__Specification__Group__13_in_rule__Specification__Group__127861 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_rule__Specification__Group__12__Impl7889 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Specification__Group__13__Impl_in_rule__Specification__Group__137920 = new BitSet(new long[]{0x0000004000000080L});
    public static final BitSet FOLLOW_rule__Specification__Group__14_in_rule__Specification__Group__137923 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Specification__Group_13__0_in_rule__Specification__Group__13__Impl7950 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Specification__Group__14__Impl_in_rule__Specification__Group__147981 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_rule__Specification__Group__15_in_rule__Specification__Group__147984 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_rule__Specification__Group__14__Impl8012 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Specification__Group__15__Impl_in_rule__Specification__Group__158043 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_rule__Specification__Group__15__Impl8071 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Specification__Group_13__0__Impl_in_rule__Specification__Group_13__08134 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_rule__Specification__Group_13__1_in_rule__Specification__Group_13__08137 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Specification__ConstraintsAssignment_13_0_in_rule__Specification__Group_13__0__Impl8164 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Specification__Group_13__1__Impl_in_rule__Specification__Group_13__18194 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Specification__Group_13_1__0_in_rule__Specification__Group_13__1__Impl8221 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_rule__Specification__Group_13_1__0__Impl_in_rule__Specification__Group_13_1__08256 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__Specification__Group_13_1__1_in_rule__Specification__Group_13_1__08259 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__Specification__Group_13_1__0__Impl8287 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Specification__Group_13_1__1__Impl_in_rule__Specification__Group_13_1__18318 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Specification__ConstraintsAssignment_13_1_1_in_rule__Specification__Group_13_1__1__Impl8345 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Constraint__Group__0__Impl_in_rule__Constraint__Group__08379 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_rule__Constraint__Group__1_in_rule__Constraint__Group__08382 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Constraint__SignatureAssignment_0_in_rule__Constraint__Group__0__Impl8409 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Constraint__Group__1__Impl_in_rule__Constraint__Group__18439 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__Constraint__Group__2_in_rule__Constraint__Group__18442 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_rule__Constraint__Group__1__Impl8470 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Constraint__Group__2__Impl_in_rule__Constraint__Group__28501 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_rule__Constraint__Group__3_in_rule__Constraint__Group__28504 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Constraint__Group_2__0_in_rule__Constraint__Group__2__Impl8531 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Constraint__Group__3__Impl_in_rule__Constraint__Group__38561 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_rule__Constraint__Group__3__Impl8589 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Constraint__Group_2__0__Impl_in_rule__Constraint__Group_2__08628 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_rule__Constraint__Group_2__1_in_rule__Constraint__Group_2__08631 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Constraint__ArrowsAssignment_2_0_in_rule__Constraint__Group_2__0__Impl8658 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Constraint__Group_2__1__Impl_in_rule__Constraint__Group_2__18688 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Constraint__Group_2_1__0_in_rule__Constraint__Group_2__1__Impl8715 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_rule__Constraint__Group_2_1__0__Impl_in_rule__Constraint__Group_2_1__08750 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__Constraint__Group_2_1__1_in_rule__Constraint__Group_2_1__08753 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__Constraint__Group_2_1__0__Impl8781 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Constraint__Group_2_1__1__Impl_in_rule__Constraint__Group_2_1__18812 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Constraint__ArrowsAssignment_2_1_1_in_rule__Constraint__Group_2_1__1__Impl8839 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConstraintSignature__Group__0__Impl_in_rule__ConstraintSignature__Group__08873 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_rule__ConstraintSignature__Group__1_in_rule__ConstraintSignature__Group__08876 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConstraintSignature__IdAssignment_0_in_rule__ConstraintSignature__Group__0__Impl8903 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConstraintSignature__Group__1__Impl_in_rule__ConstraintSignature__Group__18933 = new BitSet(new long[]{0x0000000000800080L});
    public static final BitSet FOLLOW_rule__ConstraintSignature__Group__2_in_rule__ConstraintSignature__Group__18936 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_rule__ConstraintSignature__Group__1__Impl8964 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConstraintSignature__Group__2__Impl_in_rule__ConstraintSignature__Group__28995 = new BitSet(new long[]{0x0000000000800080L});
    public static final BitSet FOLLOW_rule__ConstraintSignature__Group__3_in_rule__ConstraintSignature__Group__28998 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConstraintSignature__Group_2__0_in_rule__ConstraintSignature__Group__2__Impl9025 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConstraintSignature__Group__3__Impl_in_rule__ConstraintSignature__Group__39056 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__ConstraintSignature__Group__3__Impl9084 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConstraintSignature__Group_2__0__Impl_in_rule__ConstraintSignature__Group_2__09123 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_rule__ConstraintSignature__Group_2__1_in_rule__ConstraintSignature__Group_2__09126 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConstraintSignature__ParameterAssignment_2_0_in_rule__ConstraintSignature__Group_2__0__Impl9153 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConstraintSignature__Group_2__1__Impl_in_rule__ConstraintSignature__Group_2__19183 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConstraintSignature__Group_2_1__0_in_rule__ConstraintSignature__Group_2__1__Impl9210 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_rule__ConstraintSignature__Group_2_1__0__Impl_in_rule__ConstraintSignature__Group_2_1__09245 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__ConstraintSignature__Group_2_1__1_in_rule__ConstraintSignature__Group_2_1__09248 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__ConstraintSignature__Group_2_1__0__Impl9276 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConstraintSignature__Group_2_1__1__Impl_in_rule__ConstraintSignature__Group_2_1__19307 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConstraintSignature__ParameterAssignment_2_1_1_in_rule__ConstraintSignature__Group_2_1__1__Impl9334 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Morphism__Group__0__Impl_in_rule__Morphism__Group__09368 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_rule__Morphism__Group__1_in_rule__Morphism__Group__09371 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Morphism__Group__0__Impl9398 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Morphism__Group__1__Impl_in_rule__Morphism__Group__19427 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_rule__Morphism__Group__2_in_rule__Morphism__Group__19430 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_rule__Morphism__Group__1__Impl9458 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Morphism__Group__2__Impl_in_rule__Morphism__Group__29489 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_rule__Morphism__Group__3_in_rule__Morphism__Group__29492 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_rule__Morphism__Group__2__Impl9520 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Morphism__Group__3__Impl_in_rule__Morphism__Group__39551 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__Morphism__Group__4_in_rule__Morphism__Group__39554 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_rule__Morphism__Group__3__Impl9582 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Morphism__Group__4__Impl_in_rule__Morphism__Group__49613 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_rule__Morphism__Group__5_in_rule__Morphism__Group__49616 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Morphism__DomainAssignment_4_in_rule__Morphism__Group__4__Impl9643 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Morphism__Group__5__Impl_in_rule__Morphism__Group__59673 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__Morphism__Group__6_in_rule__Morphism__Group__59676 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__Morphism__Group__5__Impl9704 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Morphism__Group__6__Impl_in_rule__Morphism__Group__69735 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_rule__Morphism__Group__7_in_rule__Morphism__Group__69738 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Morphism__CodmainAssignment_6_in_rule__Morphism__Group__6__Impl9765 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Morphism__Group__7__Impl_in_rule__Morphism__Group__79795 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_rule__Morphism__Group__8_in_rule__Morphism__Group__79798 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_rule__Morphism__Group__7__Impl9826 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Morphism__Group__8__Impl_in_rule__Morphism__Group__89857 = new BitSet(new long[]{0x0000004000000080L});
    public static final BitSet FOLLOW_rule__Morphism__Group__9_in_rule__Morphism__Group__89860 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_rule__Morphism__Group__8__Impl9888 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Morphism__Group__9__Impl_in_rule__Morphism__Group__99919 = new BitSet(new long[]{0x0000004000000080L});
    public static final BitSet FOLLOW_rule__Morphism__Group__10_in_rule__Morphism__Group__99922 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Morphism__Group_9__0_in_rule__Morphism__Group__9__Impl9949 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Morphism__Group__10__Impl_in_rule__Morphism__Group__109980 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_rule__Morphism__Group__10__Impl10008 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Morphism__Group_9__0__Impl_in_rule__Morphism__Group_9__010061 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_rule__Morphism__Group_9__1_in_rule__Morphism__Group_9__010064 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Morphism__MappingsAssignment_9_0_in_rule__Morphism__Group_9__0__Impl10091 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Morphism__Group_9__1__Impl_in_rule__Morphism__Group_9__110121 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Morphism__Group_9_1__0_in_rule__Morphism__Group_9__1__Impl10148 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_rule__Morphism__Group_9_1__0__Impl_in_rule__Morphism__Group_9_1__010183 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__Morphism__Group_9_1__1_in_rule__Morphism__Group_9_1__010186 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__Morphism__Group_9_1__0__Impl10214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Morphism__Group_9_1__1__Impl_in_rule__Morphism__Group_9_1__110245 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Morphism__MappingsAssignment_9_1_1_in_rule__Morphism__Group_9_1__1__Impl10272 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MappingNode__Group__0__Impl_in_rule__MappingNode__Group__010306 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_rule__MappingNode__Group__1_in_rule__MappingNode__Group__010309 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MappingNode__DomainAssignment_0_in_rule__MappingNode__Group__0__Impl10336 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MappingNode__Group__1__Impl_in_rule__MappingNode__Group__110366 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__MappingNode__Group__2_in_rule__MappingNode__Group__110369 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_rule__MappingNode__Group__1__Impl10397 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MappingNode__Group__2__Impl_in_rule__MappingNode__Group__210428 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MappingNode__CodomainAssignment_2_in_rule__MappingNode__Group__2__Impl10455 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MappingArrow__Group__0__Impl_in_rule__MappingArrow__Group__010491 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_rule__MappingArrow__Group__1_in_rule__MappingArrow__Group__010494 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MappingArrow__DomainAssignment_0_in_rule__MappingArrow__Group__0__Impl10521 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MappingArrow__Group__1__Impl_in_rule__MappingArrow__Group__110551 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__MappingArrow__Group__2_in_rule__MappingArrow__Group__110554 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_rule__MappingArrow__Group__1__Impl10582 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MappingArrow__Group__2__Impl_in_rule__MappingArrow__Group__210613 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MappingArrow__CodmainAssignment_2_in_rule__MappingArrow__Group__2__Impl10640 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExtSubTGraph__Group__0__Impl_in_rule__ExtSubTGraph__Group__010676 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_rule__ExtSubTGraph__Group__1_in_rule__ExtSubTGraph__Group__010679 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExtSubTGraph__IdAssignment_0_in_rule__ExtSubTGraph__Group__0__Impl10706 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExtSubTGraph__Group__1__Impl_in_rule__ExtSubTGraph__Group__110736 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_rule__ExtSubTGraph__Group__2_in_rule__ExtSubTGraph__Group__110739 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_rule__ExtSubTGraph__Group__1__Impl10767 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExtSubTGraph__Group__2__Impl_in_rule__ExtSubTGraph__Group__210798 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_rule__ExtSubTGraph__Group__3_in_rule__ExtSubTGraph__Group__210801 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_rule__ExtSubTGraph__Group__2__Impl10829 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExtSubTGraph__Group__3__Impl_in_rule__ExtSubTGraph__Group__310860 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__ExtSubTGraph__Group__4_in_rule__ExtSubTGraph__Group__310863 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_rule__ExtSubTGraph__Group__3__Impl10891 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExtSubTGraph__Group__4__Impl_in_rule__ExtSubTGraph__Group__410922 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_rule__ExtSubTGraph__Group__5_in_rule__ExtSubTGraph__Group__410925 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExtSubTGraph__ExtendsGraphAssignment_4_in_rule__ExtSubTGraph__Group__4__Impl10952 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExtSubTGraph__Group__5__Impl_in_rule__ExtSubTGraph__Group__510982 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_rule__ExtSubTGraph__Group__6_in_rule__ExtSubTGraph__Group__510985 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_rule__ExtSubTGraph__Group__5__Impl11013 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExtSubTGraph__Group__6__Impl_in_rule__ExtSubTGraph__Group__611044 = new BitSet(new long[]{0x0000004000000080L});
    public static final BitSet FOLLOW_rule__ExtSubTGraph__Group__7_in_rule__ExtSubTGraph__Group__611047 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_rule__ExtSubTGraph__Group__6__Impl11075 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExtSubTGraph__Group__7__Impl_in_rule__ExtSubTGraph__Group__711106 = new BitSet(new long[]{0x0000004000000080L});
    public static final BitSet FOLLOW_rule__ExtSubTGraph__Group__8_in_rule__ExtSubTGraph__Group__711109 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExtSubTGraph__ElementsAssignment_7_in_rule__ExtSubTGraph__Group__7__Impl11136 = new BitSet(new long[]{0x0000000000000082L});
    public static final BitSet FOLLOW_rule__ExtSubTGraph__Group__8__Impl_in_rule__ExtSubTGraph__Group__811167 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_rule__ExtSubTGraph__Group__8__Impl11195 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Graph__Group__0__Impl_in_rule__Graph__Group__011244 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_rule__Graph__Group__1_in_rule__Graph__Group__011247 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_rule__Graph__Group__0__Impl11275 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Graph__Group__1__Impl_in_rule__Graph__Group__111306 = new BitSet(new long[]{0x0000004000000080L});
    public static final BitSet FOLLOW_rule__Graph__Group__2_in_rule__Graph__Group__111309 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_rule__Graph__Group__1__Impl11337 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Graph__Group__2__Impl_in_rule__Graph__Group__211368 = new BitSet(new long[]{0x0000004000000080L});
    public static final BitSet FOLLOW_rule__Graph__Group__3_in_rule__Graph__Group__211371 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Graph__ElementsAssignment_2_in_rule__Graph__Group__2__Impl11398 = new BitSet(new long[]{0x0000000000000082L});
    public static final BitSet FOLLOW_rule__Graph__Group__3__Impl_in_rule__Graph__Group__311429 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_rule__Graph__Group__3__Impl11457 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Element__Group_0__0__Impl_in_rule__Element__Group_0__011496 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_rule__Element__Group_0__1_in_rule__Element__Group_0__011499 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNode_in_rule__Element__Group_0__0__Impl11526 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Element__Group_0__1__Impl_in_rule__Element__Group_0__111555 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__Element__Group_0__1__Impl11583 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Element__Group_1__0__Impl_in_rule__Element__Group_1__011618 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_rule__Element__Group_1__1_in_rule__Element__Group_1__011621 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArrows_in_rule__Element__Group_1__0__Impl11648 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Element__Group_1__1__Impl_in_rule__Element__Group_1__111677 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__Element__Group_1__1__Impl11705 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrows__Group_0__0__Impl_in_rule__Arrows__Group_0__011740 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_rule__Arrows__Group_0__1_in_rule__Arrows__Group_0__011743 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrows__SrAssignment_0_0_in_rule__Arrows__Group_0__0__Impl11770 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrows__Group_0__1__Impl_in_rule__Arrows__Group_0__111800 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__Arrows__Group_0__2_in_rule__Arrows__Group_0__111803 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_rule__Arrows__Group_0__1__Impl11831 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrows__Group_0__2__Impl_in_rule__Arrows__Group_0__211862 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_rule__Arrows__Group_0__3_in_rule__Arrows__Group_0__211865 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrows__IdAssignment_0_2_in_rule__Arrows__Group_0__2__Impl11892 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrows__Group_0__3__Impl_in_rule__Arrows__Group_0__311922 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__Arrows__Group_0__4_in_rule__Arrows__Group_0__311925 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_rule__Arrows__Group_0__3__Impl11953 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrows__Group_0__4__Impl_in_rule__Arrows__Group_0__411984 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_rule__Arrows__Group_0__5_in_rule__Arrows__Group_0__411987 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrows__TypeAssignment_0_4_in_rule__Arrows__Group_0__4__Impl12014 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrows__Group_0__5__Impl_in_rule__Arrows__Group_0__512044 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__Arrows__Group_0__6_in_rule__Arrows__Group_0__512047 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__Arrows__Group_0__5__Impl12075 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrows__Group_0__6__Impl_in_rule__Arrows__Group_0__612106 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrows__NextAssignment_0_6_in_rule__Arrows__Group_0__6__Impl12133 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrow__Group_0__0__Impl_in_rule__Arrow__Group_0__012177 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_rule__Arrow__Group_0__1_in_rule__Arrow__Group_0__012180 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrow__SrAssignment_0_0_in_rule__Arrow__Group_0__0__Impl12207 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrow__Group_0__1__Impl_in_rule__Arrow__Group_0__112237 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__Arrow__Group_0__2_in_rule__Arrow__Group_0__112240 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_rule__Arrow__Group_0__1__Impl12268 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrow__Group_0__2__Impl_in_rule__Arrow__Group_0__212299 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_rule__Arrow__Group_0__3_in_rule__Arrow__Group_0__212302 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrow__IdAssignment_0_2_in_rule__Arrow__Group_0__2__Impl12329 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrow__Group_0__3__Impl_in_rule__Arrow__Group_0__312359 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_rule__Arrow__Group_0__4_in_rule__Arrow__Group_0__312362 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_rule__Arrow__Group_0__3__Impl12390 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrow__Group_0__4__Impl_in_rule__Arrow__Group_0__412421 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_rule__Arrow__Group_0__5_in_rule__Arrow__Group_0__412424 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_rule__Arrow__Group_0__4__Impl12452 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrow__Group_0__5__Impl_in_rule__Arrow__Group_0__512483 = new BitSet(new long[]{0x00000000003FE000L});
    public static final BitSet FOLLOW_rule__Arrow__Group_0__6_in_rule__Arrow__Group_0__512486 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__Arrow__Group_0__5__Impl12514 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrow__Group_0__6__Impl_in_rule__Arrow__Group_0__612545 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrow__TgDataTypeAssignment_0_6_in_rule__Arrow__Group_0__6__Impl12572 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrow__Group_1__0__Impl_in_rule__Arrow__Group_1__012616 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_rule__Arrow__Group_1__1_in_rule__Arrow__Group_1__012619 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrow__SrAssignment_1_0_in_rule__Arrow__Group_1__0__Impl12646 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrow__Group_1__1__Impl_in_rule__Arrow__Group_1__112676 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__Arrow__Group_1__2_in_rule__Arrow__Group_1__112679 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_rule__Arrow__Group_1__1__Impl12707 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrow__Group_1__2__Impl_in_rule__Arrow__Group_1__212738 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_rule__Arrow__Group_1__3_in_rule__Arrow__Group_1__212741 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrow__IdAssignment_1_2_in_rule__Arrow__Group_1__2__Impl12768 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrow__Group_1__3__Impl_in_rule__Arrow__Group_1__312798 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__Arrow__Group_1__4_in_rule__Arrow__Group_1__312801 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_rule__Arrow__Group_1__3__Impl12829 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrow__Group_1__4__Impl_in_rule__Arrow__Group_1__412860 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_rule__Arrow__Group_1__5_in_rule__Arrow__Group_1__412863 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrow__TypeAssignment_1_4_in_rule__Arrow__Group_1__4__Impl12890 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrow__Group_1__5__Impl_in_rule__Arrow__Group_1__512920 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_rule__Arrow__Group_1__6_in_rule__Arrow__Group_1__512923 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__Arrow__Group_1__5__Impl12951 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrow__Group_1__6__Impl_in_rule__Arrow__Group_1__612982 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrow__TgValueAssignment_1_6_in_rule__Arrow__Group_1__6__Impl13009 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrow__Group_2__0__Impl_in_rule__Arrow__Group_2__013053 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_rule__Arrow__Group_2__1_in_rule__Arrow__Group_2__013056 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrow__SrAssignment_2_0_in_rule__Arrow__Group_2__0__Impl13083 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrow__Group_2__1__Impl_in_rule__Arrow__Group_2__113113 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__Arrow__Group_2__2_in_rule__Arrow__Group_2__113116 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_rule__Arrow__Group_2__1__Impl13144 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrow__Group_2__2__Impl_in_rule__Arrow__Group_2__213175 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_rule__Arrow__Group_2__3_in_rule__Arrow__Group_2__213178 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrow__IdAssignment_2_2_in_rule__Arrow__Group_2__2__Impl13205 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrow__Group_2__3__Impl_in_rule__Arrow__Group_2__313235 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__Arrow__Group_2__4_in_rule__Arrow__Group_2__313238 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_rule__Arrow__Group_2__3__Impl13266 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrow__Group_2__4__Impl_in_rule__Arrow__Group_2__413297 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_rule__Arrow__Group_2__5_in_rule__Arrow__Group_2__413300 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrow__TypeAssignment_2_4_in_rule__Arrow__Group_2__4__Impl13327 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrow__Group_2__5__Impl_in_rule__Arrow__Group_2__513357 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__Arrow__Group_2__6_in_rule__Arrow__Group_2__513360 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__Arrow__Group_2__5__Impl13388 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrow__Group_2__6__Impl_in_rule__Arrow__Group_2__613419 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrow__TgNodeAssignment_2_6_in_rule__Arrow__Group_2__6__Impl13446 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Node__Group__0__Impl_in_rule__Node__Group__013490 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_rule__Node__Group__1_in_rule__Node__Group__013493 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Node__IdAssignment_0_in_rule__Node__Group__0__Impl13520 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Node__Group__1__Impl_in_rule__Node__Group__113550 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__Node__Group__2_in_rule__Node__Group__113553 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_rule__Node__Group__1__Impl13581 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Node__Group__2__Impl_in_rule__Node__Group__213612 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Node__TypeAssignment_2_in_rule__Node__Group__2__Impl13639 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AttributeValue__Group__0__Impl_in_rule__AttributeValue__Group__013675 = new BitSet(new long[]{0x0000000000000070L});
    public static final BitSet FOLLOW_rule__AttributeValue__Group__1_in_rule__AttributeValue__Group__013678 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_rule__AttributeValue__Group__0__Impl13706 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AttributeValue__Group__1__Impl_in_rule__AttributeValue__Group__113737 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_rule__AttributeValue__Group__2_in_rule__AttributeValue__Group__113740 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AttributeValue__ValueAssignment_1_in_rule__AttributeValue__Group__1__Impl13767 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AttributeValue__Group__2__Impl_in_rule__AttributeValue__Group__213797 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_rule__AttributeValue__Group__2__Impl13825 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DpfId__Group__0__Impl_in_rule__DpfId__Group__013862 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_rule__DpfId__Group__1_in_rule__DpfId__Group__013865 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DpfId__NameAssignment_0_in_rule__DpfId__Group__0__Impl13892 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DpfId__Group__1__Impl_in_rule__DpfId__Group__113922 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DpfId__Group_1__0_in_rule__DpfId__Group__1__Impl13949 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DpfId__Group_1__0__Impl_in_rule__DpfId__Group_1__013984 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_rule__DpfId__Group_1__1_in_rule__DpfId__Group_1__013987 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_rule__DpfId__Group_1__0__Impl14015 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DpfId__Group_1__1__Impl_in_rule__DpfId__Group_1__114046 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DpfId__IdAssignment_1_1_in_rule__DpfId__Group_1__1__Impl14073 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCommand_in_rule__Model__CommandsAssignment_1_014112 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCommand_in_rule__Model__CommandsAssignment_1_114143 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__MakeEmf__IdAssignment_114174 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__MakeEcore__IdAssignment_114205 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__MakeImage__IdAssignment_114236 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__SimpleEvoSpan__LhsAssignment_114267 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__SimpleEvoSpan__DiffAssignment_314298 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__SimpleEvoSpan__RhSAssignment_514329 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__SimpleEvoSpan__TypeGraphAssignment_714360 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__SimpleEvoCospan__LhsAssignment_114391 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__SimpleEvoCospan__JointAssignment_314422 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__SimpleEvoCospan__RhsAssignment_514453 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__SimpleEvoCospan__TypeGraphAssignment_714484 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__EvoSpan__LhsAssignment_114515 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__EvoSpan__RhsAssignment_314546 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__EvoSpan__TypeGraphAssignment_514577 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__EvoCospan__LhsAssignment_114608 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__EvoCospan__RhsAssignment_314639 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__EvoCospan__TypeGraphAssignment_514670 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__InstanceSpecification__IdAssignment_014701 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleChoosenSpecfication_in_rule__InstanceSpecification__ModelAssignment_414732 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleChoosenSpecfication_in_rule__InstanceSpecification__MetamodelAssignment_614763 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConstraintSemantic_in_rule__InstanceSpecification__ConstraintSemanticsAssignment_9_014794 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConstraintSemantic_in_rule__InstanceSpecification__ConstraintSemanticsAssignment_9_1_114825 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ChoosenSpecfication__IdAssignment14856 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDpfId_in_rule__ConstraintSemantic__IdAssignment_014887 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArrows_in_rule__ConstraintSemantic__ArrowsAssignment_2_014918 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArrows_in_rule__ConstraintSemantic__ArrowsAssignment_2_1_114949 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__ConstraintSemantic__OclAssignment_614980 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleChoosenSpecification_in_rule__Specification__TypeAssignment_215011 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__Specification__SequenceNumberAssignment_415042 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGraph_in_rule__Specification__GraphAssignment_715073 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleChoosenConstraintSemantic_in_rule__Specification__ConstaintSemanticAssignment_1015104 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConstraint_in_rule__Specification__ConstraintsAssignment_13_015135 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConstraint_in_rule__Specification__ConstraintsAssignment_13_1_115166 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ChoosenSpecification__IdAssignment15197 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ChoosenConstraintSemantic__IdAssignment15228 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConstraintSignature_in_rule__Constraint__SignatureAssignment_015259 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArrows_in_rule__Constraint__ArrowsAssignment_2_015290 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArrows_in_rule__Constraint__ArrowsAssignment_2_1_115321 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDpfId_in_rule__ConstraintSignature__IdAssignment_015352 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ConstraintSignature__ParameterAssignment_2_015383 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ConstraintSignature__ParameterAssignment_2_1_115414 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDomain_in_rule__Morphism__DomainAssignment_415445 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCodomain_in_rule__Morphism__CodmainAssignment_615476 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMapping_in_rule__Morphism__MappingsAssignment_9_015507 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMapping_in_rule__Morphism__MappingsAssignment_9_1_115538 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Domain__IdAssignment15569 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Codomain__IdAssignment15600 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNode_in_rule__MappingNode__DomainAssignment_015631 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNode_in_rule__MappingNode__CodomainAssignment_215662 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArrow_in_rule__MappingArrow__DomainAssignment_015693 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArrow_in_rule__MappingArrow__CodmainAssignment_215724 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ExtSubTGraph__IdAssignment_015755 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleChoosenExtSubTGraph_in_rule__ExtSubTGraph__ExtendsGraphAssignment_415786 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleElement_in_rule__ExtSubTGraph__ElementsAssignment_715817 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ChoosenExtSubTGraph__IdAssignment15848 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleElement_in_rule__Graph__ElementsAssignment_215879 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNode_in_rule__Arrows__SrAssignment_0_015910 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDpfId_in_rule__Arrows__IdAssignment_0_215941 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDpfId_in_rule__Arrows__TypeAssignment_0_415972 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArrows_in_rule__Arrows__NextAssignment_0_616003 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNode_in_rule__Arrow__SrAssignment_0_016034 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDpfId_in_rule__Arrow__IdAssignment_0_216065 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDataType_in_rule__Arrow__TgDataTypeAssignment_0_616096 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNode_in_rule__Arrow__SrAssignment_1_016127 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDpfId_in_rule__Arrow__IdAssignment_1_216158 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDpfId_in_rule__Arrow__TypeAssignment_1_416189 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAttributeValue_in_rule__Arrow__TgValueAssignment_1_616220 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNode_in_rule__Arrow__SrAssignment_2_016251 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDpfId_in_rule__Arrow__IdAssignment_2_216282 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDpfId_in_rule__Arrow__TypeAssignment_2_416313 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNode_in_rule__Arrow__TgNodeAssignment_2_616344 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDpfId_in_rule__Node__IdAssignment_016375 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDpfId_in_rule__Node__TypeAssignment_216406 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVALUE_in_rule__AttributeValue__ValueAssignment_116437 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__DpfId__NameAssignment_016468 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__DpfId__IdAssignment_1_116499 = new BitSet(new long[]{0x0000000000000002L});

}