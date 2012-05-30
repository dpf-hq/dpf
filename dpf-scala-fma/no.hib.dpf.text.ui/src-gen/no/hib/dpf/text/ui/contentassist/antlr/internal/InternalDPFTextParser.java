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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_NUMBER", "RULE_CHAR", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ANY_OTHER", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "'Boolean'", "'Char'", "'Byte'", "'Short'", "'Int'", "'Long'", "'Float'", "'Double'", "'String'", "'emf('", "')'", "'ecore('", "'image('", "'simpleEvolution('", "'<-'", "'->'", "','", "'evolution('", "'<->'", "'-><-'", "':='", "'ISpec<'", "'>'", "'{'", "'}'", "'='", "'Spec<'", "'('", "'Morphism<'", "'=>'", "'ExtSubTGraph<'", "'TGraph<'", "'-'", "':'", "'*'", "'['", "']'", "'@'"
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:69:1: ruleModel : ( ( rule__Model__Group__0 )? ) ;
    public final void ruleModel() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:73:2: ( ( ( rule__Model__Group__0 )? ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:74:1: ( ( rule__Model__Group__0 )? )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:74:1: ( ( rule__Model__Group__0 )? )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:75:1: ( rule__Model__Group__0 )?
            {
             before(grammarAccess.getModelAccess().getGroup()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:76:1: ( rule__Model__Group__0 )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==RULE_ID||LA1_0==22||(LA1_0>=24 && LA1_0<=26)||LA1_0==30) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:76:2: rule__Model__Group__0
                    {
                    pushFollow(FOLLOW_rule__Model__Group__0_in_ruleModel94);
                    rule__Model__Group__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getModelAccess().getGroup()); 

            }


            }

        }
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
            pushFollow(FOLLOW_ruleVALUE_in_entryRuleVALUE122);
            ruleVALUE();

            state._fsp--;

             after(grammarAccess.getVALUERule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVALUE129); 

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
            pushFollow(FOLLOW_rule__VALUE__Alternatives_in_ruleVALUE155);
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


    // $ANTLR start "entryRuleDefinition"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:116:1: entryRuleDefinition : ruleDefinition EOF ;
    public final void entryRuleDefinition() throws RecognitionException {
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:117:1: ( ruleDefinition EOF )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:118:1: ruleDefinition EOF
            {
             before(grammarAccess.getDefinitionRule()); 
            pushFollow(FOLLOW_ruleDefinition_in_entryRuleDefinition182);
            ruleDefinition();

            state._fsp--;

             after(grammarAccess.getDefinitionRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDefinition189); 

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
    // $ANTLR end "entryRuleDefinition"


    // $ANTLR start "ruleDefinition"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:125:1: ruleDefinition : ( ( rule__Definition__Alternatives ) ) ;
    public final void ruleDefinition() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:129:2: ( ( ( rule__Definition__Alternatives ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:130:1: ( ( rule__Definition__Alternatives ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:130:1: ( ( rule__Definition__Alternatives ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:131:1: ( rule__Definition__Alternatives )
            {
             before(grammarAccess.getDefinitionAccess().getAlternatives()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:132:1: ( rule__Definition__Alternatives )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:132:2: rule__Definition__Alternatives
            {
            pushFollow(FOLLOW_rule__Definition__Alternatives_in_ruleDefinition215);
            rule__Definition__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getDefinitionAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleDefinition"


    // $ANTLR start "entryRuleMakeEmf"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:144:1: entryRuleMakeEmf : ruleMakeEmf EOF ;
    public final void entryRuleMakeEmf() throws RecognitionException {
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:145:1: ( ruleMakeEmf EOF )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:146:1: ruleMakeEmf EOF
            {
             before(grammarAccess.getMakeEmfRule()); 
            pushFollow(FOLLOW_ruleMakeEmf_in_entryRuleMakeEmf242);
            ruleMakeEmf();

            state._fsp--;

             after(grammarAccess.getMakeEmfRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMakeEmf249); 

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
            pushFollow(FOLLOW_rule__MakeEmf__Group__0_in_ruleMakeEmf275);
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
            pushFollow(FOLLOW_ruleMakeEcore_in_entryRuleMakeEcore302);
            ruleMakeEcore();

            state._fsp--;

             after(grammarAccess.getMakeEcoreRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMakeEcore309); 

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
            pushFollow(FOLLOW_rule__MakeEcore__Group__0_in_ruleMakeEcore335);
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
            pushFollow(FOLLOW_ruleMakeImage_in_entryRuleMakeImage362);
            ruleMakeImage();

            state._fsp--;

             after(grammarAccess.getMakeImageRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMakeImage369); 

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
            pushFollow(FOLLOW_rule__MakeImage__Group__0_in_ruleMakeImage395);
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
            pushFollow(FOLLOW_ruleSimpleEvoSpan_in_entryRuleSimpleEvoSpan422);
            ruleSimpleEvoSpan();

            state._fsp--;

             after(grammarAccess.getSimpleEvoSpanRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSimpleEvoSpan429); 

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
            pushFollow(FOLLOW_rule__SimpleEvoSpan__Group__0_in_ruleSimpleEvoSpan455);
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
            pushFollow(FOLLOW_ruleSimpleEvoCospan_in_entryRuleSimpleEvoCospan482);
            ruleSimpleEvoCospan();

            state._fsp--;

             after(grammarAccess.getSimpleEvoCospanRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSimpleEvoCospan489); 

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
            pushFollow(FOLLOW_rule__SimpleEvoCospan__Group__0_in_ruleSimpleEvoCospan515);
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
            pushFollow(FOLLOW_ruleEvoSpan_in_entryRuleEvoSpan542);
            ruleEvoSpan();

            state._fsp--;

             after(grammarAccess.getEvoSpanRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEvoSpan549); 

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
            pushFollow(FOLLOW_rule__EvoSpan__Group__0_in_ruleEvoSpan575);
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
            pushFollow(FOLLOW_ruleEvoCospan_in_entryRuleEvoCospan602);
            ruleEvoCospan();

            state._fsp--;

             after(grammarAccess.getEvoCospanRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEvoCospan609); 

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
            pushFollow(FOLLOW_rule__EvoCospan__Group__0_in_ruleEvoCospan635);
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
            pushFollow(FOLLOW_ruleInstanceSpecification_in_entryRuleInstanceSpecification662);
            ruleInstanceSpecification();

            state._fsp--;

             after(grammarAccess.getInstanceSpecificationRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleInstanceSpecification669); 

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
            pushFollow(FOLLOW_rule__InstanceSpecification__Group__0_in_ruleInstanceSpecification695);
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
            pushFollow(FOLLOW_ruleChoosenSpecfication_in_entryRuleChoosenSpecfication722);
            ruleChoosenSpecfication();

            state._fsp--;

             after(grammarAccess.getChoosenSpecficationRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleChoosenSpecfication729); 

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
            pushFollow(FOLLOW_rule__ChoosenSpecfication__IdAssignment_in_ruleChoosenSpecfication755);
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
            pushFollow(FOLLOW_ruleConstraintSemantic_in_entryRuleConstraintSemantic782);
            ruleConstraintSemantic();

            state._fsp--;

             after(grammarAccess.getConstraintSemanticRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleConstraintSemantic789); 

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
            pushFollow(FOLLOW_rule__ConstraintSemantic__Group__0_in_ruleConstraintSemantic815);
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
            pushFollow(FOLLOW_ruleSpecification_in_entryRuleSpecification842);
            ruleSpecification();

            state._fsp--;

             after(grammarAccess.getSpecificationRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSpecification849); 

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
            pushFollow(FOLLOW_rule__Specification__Group__0_in_ruleSpecification875);
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


    // $ANTLR start "entryRuleChoosenGraph"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:452:1: entryRuleChoosenGraph : ruleChoosenGraph EOF ;
    public final void entryRuleChoosenGraph() throws RecognitionException {
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:453:1: ( ruleChoosenGraph EOF )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:454:1: ruleChoosenGraph EOF
            {
             before(grammarAccess.getChoosenGraphRule()); 
            pushFollow(FOLLOW_ruleChoosenGraph_in_entryRuleChoosenGraph902);
            ruleChoosenGraph();

            state._fsp--;

             after(grammarAccess.getChoosenGraphRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleChoosenGraph909); 

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
    // $ANTLR end "entryRuleChoosenGraph"


    // $ANTLR start "ruleChoosenGraph"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:461:1: ruleChoosenGraph : ( ( rule__ChoosenGraph__IdAssignment ) ) ;
    public final void ruleChoosenGraph() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:465:2: ( ( ( rule__ChoosenGraph__IdAssignment ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:466:1: ( ( rule__ChoosenGraph__IdAssignment ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:466:1: ( ( rule__ChoosenGraph__IdAssignment ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:467:1: ( rule__ChoosenGraph__IdAssignment )
            {
             before(grammarAccess.getChoosenGraphAccess().getIdAssignment()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:468:1: ( rule__ChoosenGraph__IdAssignment )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:468:2: rule__ChoosenGraph__IdAssignment
            {
            pushFollow(FOLLOW_rule__ChoosenGraph__IdAssignment_in_ruleChoosenGraph935);
            rule__ChoosenGraph__IdAssignment();

            state._fsp--;


            }

             after(grammarAccess.getChoosenGraphAccess().getIdAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleChoosenGraph"


    // $ANTLR start "entryRuleConstraint"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:480:1: entryRuleConstraint : ruleConstraint EOF ;
    public final void entryRuleConstraint() throws RecognitionException {
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:481:1: ( ruleConstraint EOF )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:482:1: ruleConstraint EOF
            {
             before(grammarAccess.getConstraintRule()); 
            pushFollow(FOLLOW_ruleConstraint_in_entryRuleConstraint962);
            ruleConstraint();

            state._fsp--;

             after(grammarAccess.getConstraintRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleConstraint969); 

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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:489:1: ruleConstraint : ( ( rule__Constraint__Group__0 ) ) ;
    public final void ruleConstraint() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:493:2: ( ( ( rule__Constraint__Group__0 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:494:1: ( ( rule__Constraint__Group__0 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:494:1: ( ( rule__Constraint__Group__0 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:495:1: ( rule__Constraint__Group__0 )
            {
             before(grammarAccess.getConstraintAccess().getGroup()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:496:1: ( rule__Constraint__Group__0 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:496:2: rule__Constraint__Group__0
            {
            pushFollow(FOLLOW_rule__Constraint__Group__0_in_ruleConstraint995);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:508:1: entryRuleConstraintSignature : ruleConstraintSignature EOF ;
    public final void entryRuleConstraintSignature() throws RecognitionException {
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:509:1: ( ruleConstraintSignature EOF )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:510:1: ruleConstraintSignature EOF
            {
             before(grammarAccess.getConstraintSignatureRule()); 
            pushFollow(FOLLOW_ruleConstraintSignature_in_entryRuleConstraintSignature1022);
            ruleConstraintSignature();

            state._fsp--;

             after(grammarAccess.getConstraintSignatureRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleConstraintSignature1029); 

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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:517:1: ruleConstraintSignature : ( ( rule__ConstraintSignature__Group__0 ) ) ;
    public final void ruleConstraintSignature() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:521:2: ( ( ( rule__ConstraintSignature__Group__0 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:522:1: ( ( rule__ConstraintSignature__Group__0 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:522:1: ( ( rule__ConstraintSignature__Group__0 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:523:1: ( rule__ConstraintSignature__Group__0 )
            {
             before(grammarAccess.getConstraintSignatureAccess().getGroup()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:524:1: ( rule__ConstraintSignature__Group__0 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:524:2: rule__ConstraintSignature__Group__0
            {
            pushFollow(FOLLOW_rule__ConstraintSignature__Group__0_in_ruleConstraintSignature1055);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:536:1: entryRuleMorphism : ruleMorphism EOF ;
    public final void entryRuleMorphism() throws RecognitionException {
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:537:1: ( ruleMorphism EOF )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:538:1: ruleMorphism EOF
            {
             before(grammarAccess.getMorphismRule()); 
            pushFollow(FOLLOW_ruleMorphism_in_entryRuleMorphism1082);
            ruleMorphism();

            state._fsp--;

             after(grammarAccess.getMorphismRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMorphism1089); 

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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:545:1: ruleMorphism : ( ( rule__Morphism__Group__0 ) ) ;
    public final void ruleMorphism() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:549:2: ( ( ( rule__Morphism__Group__0 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:550:1: ( ( rule__Morphism__Group__0 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:550:1: ( ( rule__Morphism__Group__0 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:551:1: ( rule__Morphism__Group__0 )
            {
             before(grammarAccess.getMorphismAccess().getGroup()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:552:1: ( rule__Morphism__Group__0 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:552:2: rule__Morphism__Group__0
            {
            pushFollow(FOLLOW_rule__Morphism__Group__0_in_ruleMorphism1115);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:564:1: entryRuleDomain : ruleDomain EOF ;
    public final void entryRuleDomain() throws RecognitionException {
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:565:1: ( ruleDomain EOF )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:566:1: ruleDomain EOF
            {
             before(grammarAccess.getDomainRule()); 
            pushFollow(FOLLOW_ruleDomain_in_entryRuleDomain1142);
            ruleDomain();

            state._fsp--;

             after(grammarAccess.getDomainRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDomain1149); 

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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:573:1: ruleDomain : ( ( rule__Domain__IdAssignment ) ) ;
    public final void ruleDomain() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:577:2: ( ( ( rule__Domain__IdAssignment ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:578:1: ( ( rule__Domain__IdAssignment ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:578:1: ( ( rule__Domain__IdAssignment ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:579:1: ( rule__Domain__IdAssignment )
            {
             before(grammarAccess.getDomainAccess().getIdAssignment()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:580:1: ( rule__Domain__IdAssignment )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:580:2: rule__Domain__IdAssignment
            {
            pushFollow(FOLLOW_rule__Domain__IdAssignment_in_ruleDomain1175);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:592:1: entryRuleCodomain : ruleCodomain EOF ;
    public final void entryRuleCodomain() throws RecognitionException {
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:593:1: ( ruleCodomain EOF )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:594:1: ruleCodomain EOF
            {
             before(grammarAccess.getCodomainRule()); 
            pushFollow(FOLLOW_ruleCodomain_in_entryRuleCodomain1202);
            ruleCodomain();

            state._fsp--;

             after(grammarAccess.getCodomainRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCodomain1209); 

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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:601:1: ruleCodomain : ( ( rule__Codomain__IdAssignment ) ) ;
    public final void ruleCodomain() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:605:2: ( ( ( rule__Codomain__IdAssignment ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:606:1: ( ( rule__Codomain__IdAssignment ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:606:1: ( ( rule__Codomain__IdAssignment ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:607:1: ( rule__Codomain__IdAssignment )
            {
             before(grammarAccess.getCodomainAccess().getIdAssignment()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:608:1: ( rule__Codomain__IdAssignment )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:608:2: rule__Codomain__IdAssignment
            {
            pushFollow(FOLLOW_rule__Codomain__IdAssignment_in_ruleCodomain1235);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:620:1: entryRuleMapping : ruleMapping EOF ;
    public final void entryRuleMapping() throws RecognitionException {
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:621:1: ( ruleMapping EOF )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:622:1: ruleMapping EOF
            {
             before(grammarAccess.getMappingRule()); 
            pushFollow(FOLLOW_ruleMapping_in_entryRuleMapping1262);
            ruleMapping();

            state._fsp--;

             after(grammarAccess.getMappingRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMapping1269); 

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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:629:1: ruleMapping : ( ( rule__Mapping__Alternatives ) ) ;
    public final void ruleMapping() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:633:2: ( ( ( rule__Mapping__Alternatives ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:634:1: ( ( rule__Mapping__Alternatives ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:634:1: ( ( rule__Mapping__Alternatives ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:635:1: ( rule__Mapping__Alternatives )
            {
             before(grammarAccess.getMappingAccess().getAlternatives()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:636:1: ( rule__Mapping__Alternatives )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:636:2: rule__Mapping__Alternatives
            {
            pushFollow(FOLLOW_rule__Mapping__Alternatives_in_ruleMapping1295);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:648:1: entryRuleMappingNode : ruleMappingNode EOF ;
    public final void entryRuleMappingNode() throws RecognitionException {
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:649:1: ( ruleMappingNode EOF )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:650:1: ruleMappingNode EOF
            {
             before(grammarAccess.getMappingNodeRule()); 
            pushFollow(FOLLOW_ruleMappingNode_in_entryRuleMappingNode1322);
            ruleMappingNode();

            state._fsp--;

             after(grammarAccess.getMappingNodeRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMappingNode1329); 

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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:657:1: ruleMappingNode : ( ( rule__MappingNode__Group__0 ) ) ;
    public final void ruleMappingNode() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:661:2: ( ( ( rule__MappingNode__Group__0 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:662:1: ( ( rule__MappingNode__Group__0 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:662:1: ( ( rule__MappingNode__Group__0 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:663:1: ( rule__MappingNode__Group__0 )
            {
             before(grammarAccess.getMappingNodeAccess().getGroup()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:664:1: ( rule__MappingNode__Group__0 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:664:2: rule__MappingNode__Group__0
            {
            pushFollow(FOLLOW_rule__MappingNode__Group__0_in_ruleMappingNode1355);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:676:1: entryRuleMappingArrow : ruleMappingArrow EOF ;
    public final void entryRuleMappingArrow() throws RecognitionException {
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:677:1: ( ruleMappingArrow EOF )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:678:1: ruleMappingArrow EOF
            {
             before(grammarAccess.getMappingArrowRule()); 
            pushFollow(FOLLOW_ruleMappingArrow_in_entryRuleMappingArrow1382);
            ruleMappingArrow();

            state._fsp--;

             after(grammarAccess.getMappingArrowRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMappingArrow1389); 

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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:685:1: ruleMappingArrow : ( ( rule__MappingArrow__Group__0 ) ) ;
    public final void ruleMappingArrow() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:689:2: ( ( ( rule__MappingArrow__Group__0 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:690:1: ( ( rule__MappingArrow__Group__0 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:690:1: ( ( rule__MappingArrow__Group__0 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:691:1: ( rule__MappingArrow__Group__0 )
            {
             before(grammarAccess.getMappingArrowAccess().getGroup()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:692:1: ( rule__MappingArrow__Group__0 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:692:2: rule__MappingArrow__Group__0
            {
            pushFollow(FOLLOW_rule__MappingArrow__Group__0_in_ruleMappingArrow1415);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:704:1: entryRuleExtSubTGraph : ruleExtSubTGraph EOF ;
    public final void entryRuleExtSubTGraph() throws RecognitionException {
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:705:1: ( ruleExtSubTGraph EOF )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:706:1: ruleExtSubTGraph EOF
            {
             before(grammarAccess.getExtSubTGraphRule()); 
            pushFollow(FOLLOW_ruleExtSubTGraph_in_entryRuleExtSubTGraph1442);
            ruleExtSubTGraph();

            state._fsp--;

             after(grammarAccess.getExtSubTGraphRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleExtSubTGraph1449); 

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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:713:1: ruleExtSubTGraph : ( ( rule__ExtSubTGraph__Group__0 ) ) ;
    public final void ruleExtSubTGraph() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:717:2: ( ( ( rule__ExtSubTGraph__Group__0 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:718:1: ( ( rule__ExtSubTGraph__Group__0 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:718:1: ( ( rule__ExtSubTGraph__Group__0 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:719:1: ( rule__ExtSubTGraph__Group__0 )
            {
             before(grammarAccess.getExtSubTGraphAccess().getGroup()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:720:1: ( rule__ExtSubTGraph__Group__0 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:720:2: rule__ExtSubTGraph__Group__0
            {
            pushFollow(FOLLOW_rule__ExtSubTGraph__Group__0_in_ruleExtSubTGraph1475);
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


    // $ANTLR start "entryRuleTGraphExtSubName"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:732:1: entryRuleTGraphExtSubName : ruleTGraphExtSubName EOF ;
    public final void entryRuleTGraphExtSubName() throws RecognitionException {
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:733:1: ( ruleTGraphExtSubName EOF )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:734:1: ruleTGraphExtSubName EOF
            {
             before(grammarAccess.getTGraphExtSubNameRule()); 
            pushFollow(FOLLOW_ruleTGraphExtSubName_in_entryRuleTGraphExtSubName1502);
            ruleTGraphExtSubName();

            state._fsp--;

             after(grammarAccess.getTGraphExtSubNameRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTGraphExtSubName1509); 

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
    // $ANTLR end "entryRuleTGraphExtSubName"


    // $ANTLR start "ruleTGraphExtSubName"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:741:1: ruleTGraphExtSubName : ( ( rule__TGraphExtSubName__IdAssignment ) ) ;
    public final void ruleTGraphExtSubName() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:745:2: ( ( ( rule__TGraphExtSubName__IdAssignment ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:746:1: ( ( rule__TGraphExtSubName__IdAssignment ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:746:1: ( ( rule__TGraphExtSubName__IdAssignment ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:747:1: ( rule__TGraphExtSubName__IdAssignment )
            {
             before(grammarAccess.getTGraphExtSubNameAccess().getIdAssignment()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:748:1: ( rule__TGraphExtSubName__IdAssignment )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:748:2: rule__TGraphExtSubName__IdAssignment
            {
            pushFollow(FOLLOW_rule__TGraphExtSubName__IdAssignment_in_ruleTGraphExtSubName1535);
            rule__TGraphExtSubName__IdAssignment();

            state._fsp--;


            }

             after(grammarAccess.getTGraphExtSubNameAccess().getIdAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTGraphExtSubName"


    // $ANTLR start "entryRuleTGraph"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:760:1: entryRuleTGraph : ruleTGraph EOF ;
    public final void entryRuleTGraph() throws RecognitionException {
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:761:1: ( ruleTGraph EOF )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:762:1: ruleTGraph EOF
            {
             before(grammarAccess.getTGraphRule()); 
            pushFollow(FOLLOW_ruleTGraph_in_entryRuleTGraph1562);
            ruleTGraph();

            state._fsp--;

             after(grammarAccess.getTGraphRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTGraph1569); 

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
    // $ANTLR end "entryRuleTGraph"


    // $ANTLR start "ruleTGraph"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:769:1: ruleTGraph : ( ( rule__TGraph__Group__0 ) ) ;
    public final void ruleTGraph() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:773:2: ( ( ( rule__TGraph__Group__0 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:774:1: ( ( rule__TGraph__Group__0 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:774:1: ( ( rule__TGraph__Group__0 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:775:1: ( rule__TGraph__Group__0 )
            {
             before(grammarAccess.getTGraphAccess().getGroup()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:776:1: ( rule__TGraph__Group__0 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:776:2: rule__TGraph__Group__0
            {
            pushFollow(FOLLOW_rule__TGraph__Group__0_in_ruleTGraph1595);
            rule__TGraph__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getTGraphAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTGraph"


    // $ANTLR start "entryRuleTGraphName"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:788:1: entryRuleTGraphName : ruleTGraphName EOF ;
    public final void entryRuleTGraphName() throws RecognitionException {
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:789:1: ( ruleTGraphName EOF )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:790:1: ruleTGraphName EOF
            {
             before(grammarAccess.getTGraphNameRule()); 
            pushFollow(FOLLOW_ruleTGraphName_in_entryRuleTGraphName1622);
            ruleTGraphName();

            state._fsp--;

             after(grammarAccess.getTGraphNameRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTGraphName1629); 

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
    // $ANTLR end "entryRuleTGraphName"


    // $ANTLR start "ruleTGraphName"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:797:1: ruleTGraphName : ( ( rule__TGraphName__IdAssignment ) ) ;
    public final void ruleTGraphName() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:801:2: ( ( ( rule__TGraphName__IdAssignment ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:802:1: ( ( rule__TGraphName__IdAssignment ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:802:1: ( ( rule__TGraphName__IdAssignment ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:803:1: ( rule__TGraphName__IdAssignment )
            {
             before(grammarAccess.getTGraphNameAccess().getIdAssignment()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:804:1: ( rule__TGraphName__IdAssignment )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:804:2: rule__TGraphName__IdAssignment
            {
            pushFollow(FOLLOW_rule__TGraphName__IdAssignment_in_ruleTGraphName1655);
            rule__TGraphName__IdAssignment();

            state._fsp--;


            }

             after(grammarAccess.getTGraphNameAccess().getIdAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTGraphName"


    // $ANTLR start "entryRuleElement"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:816:1: entryRuleElement : ruleElement EOF ;
    public final void entryRuleElement() throws RecognitionException {
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:817:1: ( ruleElement EOF )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:818:1: ruleElement EOF
            {
             before(grammarAccess.getElementRule()); 
            pushFollow(FOLLOW_ruleElement_in_entryRuleElement1682);
            ruleElement();

            state._fsp--;

             after(grammarAccess.getElementRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleElement1689); 

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
            pushFollow(FOLLOW_rule__Element__Alternatives_in_ruleElement1715);
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
            pushFollow(FOLLOW_ruleArrows_in_entryRuleArrows1742);
            ruleArrows();

            state._fsp--;

             after(grammarAccess.getArrowsRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleArrows1749); 

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
            pushFollow(FOLLOW_rule__Arrows__Alternatives_in_ruleArrows1775);
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
            pushFollow(FOLLOW_ruleArrow_in_entryRuleArrow1802);
            ruleArrow();

            state._fsp--;

             after(grammarAccess.getArrowRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleArrow1809); 

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
            pushFollow(FOLLOW_rule__Arrow__Alternatives_in_ruleArrow1835);
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
            pushFollow(FOLLOW_ruleNode_in_entryRuleNode1862);
            ruleNode();

            state._fsp--;

             after(grammarAccess.getNodeRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNode1869); 

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
            pushFollow(FOLLOW_rule__Node__Group__0_in_ruleNode1895);
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
            pushFollow(FOLLOW_ruleAttributeValue_in_entryRuleAttributeValue1922);
            ruleAttributeValue();

            state._fsp--;

             after(grammarAccess.getAttributeValueRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAttributeValue1929); 

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
            pushFollow(FOLLOW_rule__AttributeValue__Group__0_in_ruleAttributeValue1955);
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
            pushFollow(FOLLOW_ruleDpfId_in_entryRuleDpfId1982);
            ruleDpfId();

            state._fsp--;

             after(grammarAccess.getDpfIdRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDpfId1989); 

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
            pushFollow(FOLLOW_rule__DpfId__Group__0_in_ruleDpfId2015);
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
            pushFollow(FOLLOW_rule__DataType__Alternatives_in_ruleDataType2052);
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


    // $ANTLR start "rule__VALUE__Alternatives"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1003:1: rule__VALUE__Alternatives : ( ( RULE_NUMBER ) | ( RULE_CHAR ) | ( RULE_STRING ) );
    public final void rule__VALUE__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1007:1: ( ( RULE_NUMBER ) | ( RULE_CHAR ) | ( RULE_STRING ) )
            int alt2=3;
            switch ( input.LA(1) ) {
            case RULE_NUMBER:
                {
                alt2=1;
                }
                break;
            case RULE_CHAR:
                {
                alt2=2;
                }
                break;
            case RULE_STRING:
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
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1008:1: ( RULE_NUMBER )
                    {
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1008:1: ( RULE_NUMBER )
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1009:1: RULE_NUMBER
                    {
                     before(grammarAccess.getVALUEAccess().getNUMBERTerminalRuleCall_0()); 
                    match(input,RULE_NUMBER,FOLLOW_RULE_NUMBER_in_rule__VALUE__Alternatives2087); 
                     after(grammarAccess.getVALUEAccess().getNUMBERTerminalRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1014:6: ( RULE_CHAR )
                    {
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1014:6: ( RULE_CHAR )
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1015:1: RULE_CHAR
                    {
                     before(grammarAccess.getVALUEAccess().getCHARTerminalRuleCall_1()); 
                    match(input,RULE_CHAR,FOLLOW_RULE_CHAR_in_rule__VALUE__Alternatives2104); 
                     after(grammarAccess.getVALUEAccess().getCHARTerminalRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1020:6: ( RULE_STRING )
                    {
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1020:6: ( RULE_STRING )
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1021:1: RULE_STRING
                    {
                     before(grammarAccess.getVALUEAccess().getSTRINGTerminalRuleCall_2()); 
                    match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__VALUE__Alternatives2121); 
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


    // $ANTLR start "rule__Definition__Alternatives"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1031:1: rule__Definition__Alternatives : ( ( ruleInstanceSpecification ) | ( ruleSpecification ) | ( ruleTGraph ) | ( ruleExtSubTGraph ) | ( ruleMakeEmf ) | ( ruleMakeEcore ) | ( ruleMakeImage ) | ( ruleSimpleEvoSpan ) | ( ruleSimpleEvoCospan ) | ( ruleMorphism ) | ( ruleEvoSpan ) | ( ruleEvoCospan ) );
    public final void rule__Definition__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1035:1: ( ( ruleInstanceSpecification ) | ( ruleSpecification ) | ( ruleTGraph ) | ( ruleExtSubTGraph ) | ( ruleMakeEmf ) | ( ruleMakeEcore ) | ( ruleMakeImage ) | ( ruleSimpleEvoSpan ) | ( ruleSimpleEvoCospan ) | ( ruleMorphism ) | ( ruleEvoSpan ) | ( ruleEvoCospan ) )
            int alt3=12;
            alt3 = dfa3.predict(input);
            switch (alt3) {
                case 1 :
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1036:1: ( ruleInstanceSpecification )
                    {
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1036:1: ( ruleInstanceSpecification )
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1037:1: ruleInstanceSpecification
                    {
                     before(grammarAccess.getDefinitionAccess().getInstanceSpecificationParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleInstanceSpecification_in_rule__Definition__Alternatives2153);
                    ruleInstanceSpecification();

                    state._fsp--;

                     after(grammarAccess.getDefinitionAccess().getInstanceSpecificationParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1042:6: ( ruleSpecification )
                    {
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1042:6: ( ruleSpecification )
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1043:1: ruleSpecification
                    {
                     before(grammarAccess.getDefinitionAccess().getSpecificationParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleSpecification_in_rule__Definition__Alternatives2170);
                    ruleSpecification();

                    state._fsp--;

                     after(grammarAccess.getDefinitionAccess().getSpecificationParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1048:6: ( ruleTGraph )
                    {
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1048:6: ( ruleTGraph )
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1049:1: ruleTGraph
                    {
                     before(grammarAccess.getDefinitionAccess().getTGraphParserRuleCall_2()); 
                    pushFollow(FOLLOW_ruleTGraph_in_rule__Definition__Alternatives2187);
                    ruleTGraph();

                    state._fsp--;

                     after(grammarAccess.getDefinitionAccess().getTGraphParserRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1054:6: ( ruleExtSubTGraph )
                    {
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1054:6: ( ruleExtSubTGraph )
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1055:1: ruleExtSubTGraph
                    {
                     before(grammarAccess.getDefinitionAccess().getExtSubTGraphParserRuleCall_3()); 
                    pushFollow(FOLLOW_ruleExtSubTGraph_in_rule__Definition__Alternatives2204);
                    ruleExtSubTGraph();

                    state._fsp--;

                     after(grammarAccess.getDefinitionAccess().getExtSubTGraphParserRuleCall_3()); 

                    }


                    }
                    break;
                case 5 :
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1060:6: ( ruleMakeEmf )
                    {
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1060:6: ( ruleMakeEmf )
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1061:1: ruleMakeEmf
                    {
                     before(grammarAccess.getDefinitionAccess().getMakeEmfParserRuleCall_4()); 
                    pushFollow(FOLLOW_ruleMakeEmf_in_rule__Definition__Alternatives2221);
                    ruleMakeEmf();

                    state._fsp--;

                     after(grammarAccess.getDefinitionAccess().getMakeEmfParserRuleCall_4()); 

                    }


                    }
                    break;
                case 6 :
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1066:6: ( ruleMakeEcore )
                    {
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1066:6: ( ruleMakeEcore )
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1067:1: ruleMakeEcore
                    {
                     before(grammarAccess.getDefinitionAccess().getMakeEcoreParserRuleCall_5()); 
                    pushFollow(FOLLOW_ruleMakeEcore_in_rule__Definition__Alternatives2238);
                    ruleMakeEcore();

                    state._fsp--;

                     after(grammarAccess.getDefinitionAccess().getMakeEcoreParserRuleCall_5()); 

                    }


                    }
                    break;
                case 7 :
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1072:6: ( ruleMakeImage )
                    {
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1072:6: ( ruleMakeImage )
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1073:1: ruleMakeImage
                    {
                     before(grammarAccess.getDefinitionAccess().getMakeImageParserRuleCall_6()); 
                    pushFollow(FOLLOW_ruleMakeImage_in_rule__Definition__Alternatives2255);
                    ruleMakeImage();

                    state._fsp--;

                     after(grammarAccess.getDefinitionAccess().getMakeImageParserRuleCall_6()); 

                    }


                    }
                    break;
                case 8 :
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1078:6: ( ruleSimpleEvoSpan )
                    {
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1078:6: ( ruleSimpleEvoSpan )
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1079:1: ruleSimpleEvoSpan
                    {
                     before(grammarAccess.getDefinitionAccess().getSimpleEvoSpanParserRuleCall_7()); 
                    pushFollow(FOLLOW_ruleSimpleEvoSpan_in_rule__Definition__Alternatives2272);
                    ruleSimpleEvoSpan();

                    state._fsp--;

                     after(grammarAccess.getDefinitionAccess().getSimpleEvoSpanParserRuleCall_7()); 

                    }


                    }
                    break;
                case 9 :
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1084:6: ( ruleSimpleEvoCospan )
                    {
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1084:6: ( ruleSimpleEvoCospan )
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1085:1: ruleSimpleEvoCospan
                    {
                     before(grammarAccess.getDefinitionAccess().getSimpleEvoCospanParserRuleCall_8()); 
                    pushFollow(FOLLOW_ruleSimpleEvoCospan_in_rule__Definition__Alternatives2289);
                    ruleSimpleEvoCospan();

                    state._fsp--;

                     after(grammarAccess.getDefinitionAccess().getSimpleEvoCospanParserRuleCall_8()); 

                    }


                    }
                    break;
                case 10 :
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1090:6: ( ruleMorphism )
                    {
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1090:6: ( ruleMorphism )
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1091:1: ruleMorphism
                    {
                     before(grammarAccess.getDefinitionAccess().getMorphismParserRuleCall_9()); 
                    pushFollow(FOLLOW_ruleMorphism_in_rule__Definition__Alternatives2306);
                    ruleMorphism();

                    state._fsp--;

                     after(grammarAccess.getDefinitionAccess().getMorphismParserRuleCall_9()); 

                    }


                    }
                    break;
                case 11 :
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1096:6: ( ruleEvoSpan )
                    {
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1096:6: ( ruleEvoSpan )
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1097:1: ruleEvoSpan
                    {
                     before(grammarAccess.getDefinitionAccess().getEvoSpanParserRuleCall_10()); 
                    pushFollow(FOLLOW_ruleEvoSpan_in_rule__Definition__Alternatives2323);
                    ruleEvoSpan();

                    state._fsp--;

                     after(grammarAccess.getDefinitionAccess().getEvoSpanParserRuleCall_10()); 

                    }


                    }
                    break;
                case 12 :
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1102:6: ( ruleEvoCospan )
                    {
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1102:6: ( ruleEvoCospan )
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1103:1: ruleEvoCospan
                    {
                     before(grammarAccess.getDefinitionAccess().getEvoCospanParserRuleCall_11()); 
                    pushFollow(FOLLOW_ruleEvoCospan_in_rule__Definition__Alternatives2340);
                    ruleEvoCospan();

                    state._fsp--;

                     after(grammarAccess.getDefinitionAccess().getEvoCospanParserRuleCall_11()); 

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
    // $ANTLR end "rule__Definition__Alternatives"


    // $ANTLR start "rule__Mapping__Alternatives"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1113:1: rule__Mapping__Alternatives : ( ( ruleMappingNode ) | ( ruleMappingArrow ) );
    public final void rule__Mapping__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1117:1: ( ( ruleMappingNode ) | ( ruleMappingArrow ) )
            int alt4=2;
            alt4 = dfa4.predict(input);
            switch (alt4) {
                case 1 :
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1118:1: ( ruleMappingNode )
                    {
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1118:1: ( ruleMappingNode )
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1119:1: ruleMappingNode
                    {
                     before(grammarAccess.getMappingAccess().getMappingNodeParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleMappingNode_in_rule__Mapping__Alternatives2372);
                    ruleMappingNode();

                    state._fsp--;

                     after(grammarAccess.getMappingAccess().getMappingNodeParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1124:6: ( ruleMappingArrow )
                    {
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1124:6: ( ruleMappingArrow )
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1125:1: ruleMappingArrow
                    {
                     before(grammarAccess.getMappingAccess().getMappingArrowParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleMappingArrow_in_rule__Mapping__Alternatives2389);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1135:1: rule__Element__Alternatives : ( ( ( rule__Element__Group_0__0 ) ) | ( ( rule__Element__Group_1__0 ) ) );
    public final void rule__Element__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1139:1: ( ( ( rule__Element__Group_0__0 ) ) | ( ( rule__Element__Group_1__0 ) ) )
            int alt5=2;
            alt5 = dfa5.predict(input);
            switch (alt5) {
                case 1 :
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1140:1: ( ( rule__Element__Group_0__0 ) )
                    {
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1140:1: ( ( rule__Element__Group_0__0 ) )
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1141:1: ( rule__Element__Group_0__0 )
                    {
                     before(grammarAccess.getElementAccess().getGroup_0()); 
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1142:1: ( rule__Element__Group_0__0 )
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1142:2: rule__Element__Group_0__0
                    {
                    pushFollow(FOLLOW_rule__Element__Group_0__0_in_rule__Element__Alternatives2421);
                    rule__Element__Group_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getElementAccess().getGroup_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1146:6: ( ( rule__Element__Group_1__0 ) )
                    {
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1146:6: ( ( rule__Element__Group_1__0 ) )
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1147:1: ( rule__Element__Group_1__0 )
                    {
                     before(grammarAccess.getElementAccess().getGroup_1()); 
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1148:1: ( rule__Element__Group_1__0 )
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1148:2: rule__Element__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__Element__Group_1__0_in_rule__Element__Alternatives2439);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1157:1: rule__Arrows__Alternatives : ( ( ( rule__Arrows__Group_0__0 ) ) | ( ruleArrow ) );
    public final void rule__Arrows__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1161:1: ( ( ( rule__Arrows__Group_0__0 ) ) | ( ruleArrow ) )
            int alt6=2;
            alt6 = dfa6.predict(input);
            switch (alt6) {
                case 1 :
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1162:1: ( ( rule__Arrows__Group_0__0 ) )
                    {
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1162:1: ( ( rule__Arrows__Group_0__0 ) )
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1163:1: ( rule__Arrows__Group_0__0 )
                    {
                     before(grammarAccess.getArrowsAccess().getGroup_0()); 
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1164:1: ( rule__Arrows__Group_0__0 )
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1164:2: rule__Arrows__Group_0__0
                    {
                    pushFollow(FOLLOW_rule__Arrows__Group_0__0_in_rule__Arrows__Alternatives2472);
                    rule__Arrows__Group_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getArrowsAccess().getGroup_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1168:6: ( ruleArrow )
                    {
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1168:6: ( ruleArrow )
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1169:1: ruleArrow
                    {
                     before(grammarAccess.getArrowsAccess().getArrowParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleArrow_in_rule__Arrows__Alternatives2490);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1179:1: rule__Arrow__Alternatives : ( ( ( rule__Arrow__Group_0__0 ) ) | ( ( rule__Arrow__Group_1__0 ) ) | ( ( rule__Arrow__Group_2__0 ) ) );
    public final void rule__Arrow__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1183:1: ( ( ( rule__Arrow__Group_0__0 ) ) | ( ( rule__Arrow__Group_1__0 ) ) | ( ( rule__Arrow__Group_2__0 ) ) )
            int alt7=3;
            alt7 = dfa7.predict(input);
            switch (alt7) {
                case 1 :
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1184:1: ( ( rule__Arrow__Group_0__0 ) )
                    {
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1184:1: ( ( rule__Arrow__Group_0__0 ) )
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1185:1: ( rule__Arrow__Group_0__0 )
                    {
                     before(grammarAccess.getArrowAccess().getGroup_0()); 
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1186:1: ( rule__Arrow__Group_0__0 )
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1186:2: rule__Arrow__Group_0__0
                    {
                    pushFollow(FOLLOW_rule__Arrow__Group_0__0_in_rule__Arrow__Alternatives2522);
                    rule__Arrow__Group_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getArrowAccess().getGroup_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1190:6: ( ( rule__Arrow__Group_1__0 ) )
                    {
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1190:6: ( ( rule__Arrow__Group_1__0 ) )
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1191:1: ( rule__Arrow__Group_1__0 )
                    {
                     before(grammarAccess.getArrowAccess().getGroup_1()); 
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1192:1: ( rule__Arrow__Group_1__0 )
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1192:2: rule__Arrow__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__Arrow__Group_1__0_in_rule__Arrow__Alternatives2540);
                    rule__Arrow__Group_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getArrowAccess().getGroup_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1196:6: ( ( rule__Arrow__Group_2__0 ) )
                    {
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1196:6: ( ( rule__Arrow__Group_2__0 ) )
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1197:1: ( rule__Arrow__Group_2__0 )
                    {
                     before(grammarAccess.getArrowAccess().getGroup_2()); 
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1198:1: ( rule__Arrow__Group_2__0 )
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1198:2: rule__Arrow__Group_2__0
                    {
                    pushFollow(FOLLOW_rule__Arrow__Group_2__0_in_rule__Arrow__Alternatives2558);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1207:1: rule__DataType__Alternatives : ( ( ( 'Boolean' ) ) | ( ( 'Char' ) ) | ( ( 'Byte' ) ) | ( ( 'Short' ) ) | ( ( 'Int' ) ) | ( ( 'Long' ) ) | ( ( 'Float' ) ) | ( ( 'Double' ) ) | ( ( 'String' ) ) );
    public final void rule__DataType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1211:1: ( ( ( 'Boolean' ) ) | ( ( 'Char' ) ) | ( ( 'Byte' ) ) | ( ( 'Short' ) ) | ( ( 'Int' ) ) | ( ( 'Long' ) ) | ( ( 'Float' ) ) | ( ( 'Double' ) ) | ( ( 'String' ) ) )
            int alt8=9;
            switch ( input.LA(1) ) {
            case 13:
                {
                alt8=1;
                }
                break;
            case 14:
                {
                alt8=2;
                }
                break;
            case 15:
                {
                alt8=3;
                }
                break;
            case 16:
                {
                alt8=4;
                }
                break;
            case 17:
                {
                alt8=5;
                }
                break;
            case 18:
                {
                alt8=6;
                }
                break;
            case 19:
                {
                alt8=7;
                }
                break;
            case 20:
                {
                alt8=8;
                }
                break;
            case 21:
                {
                alt8=9;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }

            switch (alt8) {
                case 1 :
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1212:1: ( ( 'Boolean' ) )
                    {
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1212:1: ( ( 'Boolean' ) )
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1213:1: ( 'Boolean' )
                    {
                     before(grammarAccess.getDataTypeAccess().getTBOOLEANEnumLiteralDeclaration_0()); 
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1214:1: ( 'Boolean' )
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1214:3: 'Boolean'
                    {
                    match(input,13,FOLLOW_13_in_rule__DataType__Alternatives2592); 

                    }

                     after(grammarAccess.getDataTypeAccess().getTBOOLEANEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1219:6: ( ( 'Char' ) )
                    {
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1219:6: ( ( 'Char' ) )
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1220:1: ( 'Char' )
                    {
                     before(grammarAccess.getDataTypeAccess().getTCHAREnumLiteralDeclaration_1()); 
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1221:1: ( 'Char' )
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1221:3: 'Char'
                    {
                    match(input,14,FOLLOW_14_in_rule__DataType__Alternatives2613); 

                    }

                     after(grammarAccess.getDataTypeAccess().getTCHAREnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1226:6: ( ( 'Byte' ) )
                    {
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1226:6: ( ( 'Byte' ) )
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1227:1: ( 'Byte' )
                    {
                     before(grammarAccess.getDataTypeAccess().getTBYTEEnumLiteralDeclaration_2()); 
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1228:1: ( 'Byte' )
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1228:3: 'Byte'
                    {
                    match(input,15,FOLLOW_15_in_rule__DataType__Alternatives2634); 

                    }

                     after(grammarAccess.getDataTypeAccess().getTBYTEEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1233:6: ( ( 'Short' ) )
                    {
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1233:6: ( ( 'Short' ) )
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1234:1: ( 'Short' )
                    {
                     before(grammarAccess.getDataTypeAccess().getTSHORTEnumLiteralDeclaration_3()); 
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1235:1: ( 'Short' )
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1235:3: 'Short'
                    {
                    match(input,16,FOLLOW_16_in_rule__DataType__Alternatives2655); 

                    }

                     after(grammarAccess.getDataTypeAccess().getTSHORTEnumLiteralDeclaration_3()); 

                    }


                    }
                    break;
                case 5 :
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1240:6: ( ( 'Int' ) )
                    {
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1240:6: ( ( 'Int' ) )
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1241:1: ( 'Int' )
                    {
                     before(grammarAccess.getDataTypeAccess().getTINTEnumLiteralDeclaration_4()); 
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1242:1: ( 'Int' )
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1242:3: 'Int'
                    {
                    match(input,17,FOLLOW_17_in_rule__DataType__Alternatives2676); 

                    }

                     after(grammarAccess.getDataTypeAccess().getTINTEnumLiteralDeclaration_4()); 

                    }


                    }
                    break;
                case 6 :
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1247:6: ( ( 'Long' ) )
                    {
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1247:6: ( ( 'Long' ) )
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1248:1: ( 'Long' )
                    {
                     before(grammarAccess.getDataTypeAccess().getTLONGEnumLiteralDeclaration_5()); 
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1249:1: ( 'Long' )
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1249:3: 'Long'
                    {
                    match(input,18,FOLLOW_18_in_rule__DataType__Alternatives2697); 

                    }

                     after(grammarAccess.getDataTypeAccess().getTLONGEnumLiteralDeclaration_5()); 

                    }


                    }
                    break;
                case 7 :
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1254:6: ( ( 'Float' ) )
                    {
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1254:6: ( ( 'Float' ) )
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1255:1: ( 'Float' )
                    {
                     before(grammarAccess.getDataTypeAccess().getTFLOATEnumLiteralDeclaration_6()); 
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1256:1: ( 'Float' )
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1256:3: 'Float'
                    {
                    match(input,19,FOLLOW_19_in_rule__DataType__Alternatives2718); 

                    }

                     after(grammarAccess.getDataTypeAccess().getTFLOATEnumLiteralDeclaration_6()); 

                    }


                    }
                    break;
                case 8 :
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1261:6: ( ( 'Double' ) )
                    {
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1261:6: ( ( 'Double' ) )
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1262:1: ( 'Double' )
                    {
                     before(grammarAccess.getDataTypeAccess().getTDOUBLEEnumLiteralDeclaration_7()); 
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1263:1: ( 'Double' )
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1263:3: 'Double'
                    {
                    match(input,20,FOLLOW_20_in_rule__DataType__Alternatives2739); 

                    }

                     after(grammarAccess.getDataTypeAccess().getTDOUBLEEnumLiteralDeclaration_7()); 

                    }


                    }
                    break;
                case 9 :
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1268:6: ( ( 'String' ) )
                    {
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1268:6: ( ( 'String' ) )
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1269:1: ( 'String' )
                    {
                     before(grammarAccess.getDataTypeAccess().getTSTRINGEnumLiteralDeclaration_8()); 
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1270:1: ( 'String' )
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1270:3: 'String'
                    {
                    match(input,21,FOLLOW_21_in_rule__DataType__Alternatives2760); 

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


    // $ANTLR start "rule__Model__Group__0"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1282:1: rule__Model__Group__0 : rule__Model__Group__0__Impl rule__Model__Group__1 ;
    public final void rule__Model__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1286:1: ( rule__Model__Group__0__Impl rule__Model__Group__1 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1287:2: rule__Model__Group__0__Impl rule__Model__Group__1
            {
            pushFollow(FOLLOW_rule__Model__Group__0__Impl_in_rule__Model__Group__02793);
            rule__Model__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Model__Group__1_in_rule__Model__Group__02796);
            rule__Model__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__0"


    // $ANTLR start "rule__Model__Group__0__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1294:1: rule__Model__Group__0__Impl : ( ( rule__Model__DefinitionsAssignment_0 ) ) ;
    public final void rule__Model__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1298:1: ( ( ( rule__Model__DefinitionsAssignment_0 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1299:1: ( ( rule__Model__DefinitionsAssignment_0 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1299:1: ( ( rule__Model__DefinitionsAssignment_0 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1300:1: ( rule__Model__DefinitionsAssignment_0 )
            {
             before(grammarAccess.getModelAccess().getDefinitionsAssignment_0()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1301:1: ( rule__Model__DefinitionsAssignment_0 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1301:2: rule__Model__DefinitionsAssignment_0
            {
            pushFollow(FOLLOW_rule__Model__DefinitionsAssignment_0_in_rule__Model__Group__0__Impl2823);
            rule__Model__DefinitionsAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getModelAccess().getDefinitionsAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__0__Impl"


    // $ANTLR start "rule__Model__Group__1"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1311:1: rule__Model__Group__1 : rule__Model__Group__1__Impl ;
    public final void rule__Model__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1315:1: ( rule__Model__Group__1__Impl )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1316:2: rule__Model__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Model__Group__1__Impl_in_rule__Model__Group__12853);
            rule__Model__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__1"


    // $ANTLR start "rule__Model__Group__1__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1322:1: rule__Model__Group__1__Impl : ( ( rule__Model__DefinitionsAssignment_1 )* ) ;
    public final void rule__Model__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1326:1: ( ( ( rule__Model__DefinitionsAssignment_1 )* ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1327:1: ( ( rule__Model__DefinitionsAssignment_1 )* )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1327:1: ( ( rule__Model__DefinitionsAssignment_1 )* )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1328:1: ( rule__Model__DefinitionsAssignment_1 )*
            {
             before(grammarAccess.getModelAccess().getDefinitionsAssignment_1()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1329:1: ( rule__Model__DefinitionsAssignment_1 )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==RULE_ID||LA9_0==22||(LA9_0>=24 && LA9_0<=26)||LA9_0==30) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1329:2: rule__Model__DefinitionsAssignment_1
            	    {
            	    pushFollow(FOLLOW_rule__Model__DefinitionsAssignment_1_in_rule__Model__Group__1__Impl2880);
            	    rule__Model__DefinitionsAssignment_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

             after(grammarAccess.getModelAccess().getDefinitionsAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__1__Impl"


    // $ANTLR start "rule__MakeEmf__Group__0"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1343:1: rule__MakeEmf__Group__0 : rule__MakeEmf__Group__0__Impl rule__MakeEmf__Group__1 ;
    public final void rule__MakeEmf__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1347:1: ( rule__MakeEmf__Group__0__Impl rule__MakeEmf__Group__1 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1348:2: rule__MakeEmf__Group__0__Impl rule__MakeEmf__Group__1
            {
            pushFollow(FOLLOW_rule__MakeEmf__Group__0__Impl_in_rule__MakeEmf__Group__02915);
            rule__MakeEmf__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__MakeEmf__Group__1_in_rule__MakeEmf__Group__02918);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1355:1: rule__MakeEmf__Group__0__Impl : ( 'emf(' ) ;
    public final void rule__MakeEmf__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1359:1: ( ( 'emf(' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1360:1: ( 'emf(' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1360:1: ( 'emf(' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1361:1: 'emf('
            {
             before(grammarAccess.getMakeEmfAccess().getEmfKeyword_0()); 
            match(input,22,FOLLOW_22_in_rule__MakeEmf__Group__0__Impl2946); 
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1374:1: rule__MakeEmf__Group__1 : rule__MakeEmf__Group__1__Impl rule__MakeEmf__Group__2 ;
    public final void rule__MakeEmf__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1378:1: ( rule__MakeEmf__Group__1__Impl rule__MakeEmf__Group__2 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1379:2: rule__MakeEmf__Group__1__Impl rule__MakeEmf__Group__2
            {
            pushFollow(FOLLOW_rule__MakeEmf__Group__1__Impl_in_rule__MakeEmf__Group__12977);
            rule__MakeEmf__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__MakeEmf__Group__2_in_rule__MakeEmf__Group__12980);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1386:1: rule__MakeEmf__Group__1__Impl : ( ( rule__MakeEmf__IdAssignment_1 ) ) ;
    public final void rule__MakeEmf__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1390:1: ( ( ( rule__MakeEmf__IdAssignment_1 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1391:1: ( ( rule__MakeEmf__IdAssignment_1 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1391:1: ( ( rule__MakeEmf__IdAssignment_1 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1392:1: ( rule__MakeEmf__IdAssignment_1 )
            {
             before(grammarAccess.getMakeEmfAccess().getIdAssignment_1()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1393:1: ( rule__MakeEmf__IdAssignment_1 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1393:2: rule__MakeEmf__IdAssignment_1
            {
            pushFollow(FOLLOW_rule__MakeEmf__IdAssignment_1_in_rule__MakeEmf__Group__1__Impl3007);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1403:1: rule__MakeEmf__Group__2 : rule__MakeEmf__Group__2__Impl ;
    public final void rule__MakeEmf__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1407:1: ( rule__MakeEmf__Group__2__Impl )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1408:2: rule__MakeEmf__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__MakeEmf__Group__2__Impl_in_rule__MakeEmf__Group__23037);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1414:1: rule__MakeEmf__Group__2__Impl : ( ')' ) ;
    public final void rule__MakeEmf__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1418:1: ( ( ')' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1419:1: ( ')' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1419:1: ( ')' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1420:1: ')'
            {
             before(grammarAccess.getMakeEmfAccess().getRightParenthesisKeyword_2()); 
            match(input,23,FOLLOW_23_in_rule__MakeEmf__Group__2__Impl3065); 
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1439:1: rule__MakeEcore__Group__0 : rule__MakeEcore__Group__0__Impl rule__MakeEcore__Group__1 ;
    public final void rule__MakeEcore__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1443:1: ( rule__MakeEcore__Group__0__Impl rule__MakeEcore__Group__1 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1444:2: rule__MakeEcore__Group__0__Impl rule__MakeEcore__Group__1
            {
            pushFollow(FOLLOW_rule__MakeEcore__Group__0__Impl_in_rule__MakeEcore__Group__03102);
            rule__MakeEcore__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__MakeEcore__Group__1_in_rule__MakeEcore__Group__03105);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1451:1: rule__MakeEcore__Group__0__Impl : ( 'ecore(' ) ;
    public final void rule__MakeEcore__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1455:1: ( ( 'ecore(' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1456:1: ( 'ecore(' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1456:1: ( 'ecore(' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1457:1: 'ecore('
            {
             before(grammarAccess.getMakeEcoreAccess().getEcoreKeyword_0()); 
            match(input,24,FOLLOW_24_in_rule__MakeEcore__Group__0__Impl3133); 
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1470:1: rule__MakeEcore__Group__1 : rule__MakeEcore__Group__1__Impl rule__MakeEcore__Group__2 ;
    public final void rule__MakeEcore__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1474:1: ( rule__MakeEcore__Group__1__Impl rule__MakeEcore__Group__2 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1475:2: rule__MakeEcore__Group__1__Impl rule__MakeEcore__Group__2
            {
            pushFollow(FOLLOW_rule__MakeEcore__Group__1__Impl_in_rule__MakeEcore__Group__13164);
            rule__MakeEcore__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__MakeEcore__Group__2_in_rule__MakeEcore__Group__13167);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1482:1: rule__MakeEcore__Group__1__Impl : ( ( rule__MakeEcore__IdAssignment_1 ) ) ;
    public final void rule__MakeEcore__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1486:1: ( ( ( rule__MakeEcore__IdAssignment_1 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1487:1: ( ( rule__MakeEcore__IdAssignment_1 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1487:1: ( ( rule__MakeEcore__IdAssignment_1 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1488:1: ( rule__MakeEcore__IdAssignment_1 )
            {
             before(grammarAccess.getMakeEcoreAccess().getIdAssignment_1()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1489:1: ( rule__MakeEcore__IdAssignment_1 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1489:2: rule__MakeEcore__IdAssignment_1
            {
            pushFollow(FOLLOW_rule__MakeEcore__IdAssignment_1_in_rule__MakeEcore__Group__1__Impl3194);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1499:1: rule__MakeEcore__Group__2 : rule__MakeEcore__Group__2__Impl ;
    public final void rule__MakeEcore__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1503:1: ( rule__MakeEcore__Group__2__Impl )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1504:2: rule__MakeEcore__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__MakeEcore__Group__2__Impl_in_rule__MakeEcore__Group__23224);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1510:1: rule__MakeEcore__Group__2__Impl : ( ')' ) ;
    public final void rule__MakeEcore__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1514:1: ( ( ')' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1515:1: ( ')' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1515:1: ( ')' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1516:1: ')'
            {
             before(grammarAccess.getMakeEcoreAccess().getRightParenthesisKeyword_2()); 
            match(input,23,FOLLOW_23_in_rule__MakeEcore__Group__2__Impl3252); 
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1535:1: rule__MakeImage__Group__0 : rule__MakeImage__Group__0__Impl rule__MakeImage__Group__1 ;
    public final void rule__MakeImage__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1539:1: ( rule__MakeImage__Group__0__Impl rule__MakeImage__Group__1 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1540:2: rule__MakeImage__Group__0__Impl rule__MakeImage__Group__1
            {
            pushFollow(FOLLOW_rule__MakeImage__Group__0__Impl_in_rule__MakeImage__Group__03289);
            rule__MakeImage__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__MakeImage__Group__1_in_rule__MakeImage__Group__03292);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1547:1: rule__MakeImage__Group__0__Impl : ( 'image(' ) ;
    public final void rule__MakeImage__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1551:1: ( ( 'image(' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1552:1: ( 'image(' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1552:1: ( 'image(' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1553:1: 'image('
            {
             before(grammarAccess.getMakeImageAccess().getImageKeyword_0()); 
            match(input,25,FOLLOW_25_in_rule__MakeImage__Group__0__Impl3320); 
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1566:1: rule__MakeImage__Group__1 : rule__MakeImage__Group__1__Impl rule__MakeImage__Group__2 ;
    public final void rule__MakeImage__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1570:1: ( rule__MakeImage__Group__1__Impl rule__MakeImage__Group__2 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1571:2: rule__MakeImage__Group__1__Impl rule__MakeImage__Group__2
            {
            pushFollow(FOLLOW_rule__MakeImage__Group__1__Impl_in_rule__MakeImage__Group__13351);
            rule__MakeImage__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__MakeImage__Group__2_in_rule__MakeImage__Group__13354);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1578:1: rule__MakeImage__Group__1__Impl : ( ( rule__MakeImage__IdAssignment_1 ) ) ;
    public final void rule__MakeImage__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1582:1: ( ( ( rule__MakeImage__IdAssignment_1 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1583:1: ( ( rule__MakeImage__IdAssignment_1 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1583:1: ( ( rule__MakeImage__IdAssignment_1 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1584:1: ( rule__MakeImage__IdAssignment_1 )
            {
             before(grammarAccess.getMakeImageAccess().getIdAssignment_1()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1585:1: ( rule__MakeImage__IdAssignment_1 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1585:2: rule__MakeImage__IdAssignment_1
            {
            pushFollow(FOLLOW_rule__MakeImage__IdAssignment_1_in_rule__MakeImage__Group__1__Impl3381);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1595:1: rule__MakeImage__Group__2 : rule__MakeImage__Group__2__Impl ;
    public final void rule__MakeImage__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1599:1: ( rule__MakeImage__Group__2__Impl )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1600:2: rule__MakeImage__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__MakeImage__Group__2__Impl_in_rule__MakeImage__Group__23411);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1606:1: rule__MakeImage__Group__2__Impl : ( ')' ) ;
    public final void rule__MakeImage__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1610:1: ( ( ')' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1611:1: ( ')' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1611:1: ( ')' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1612:1: ')'
            {
             before(grammarAccess.getMakeImageAccess().getRightParenthesisKeyword_2()); 
            match(input,23,FOLLOW_23_in_rule__MakeImage__Group__2__Impl3439); 
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1631:1: rule__SimpleEvoSpan__Group__0 : rule__SimpleEvoSpan__Group__0__Impl rule__SimpleEvoSpan__Group__1 ;
    public final void rule__SimpleEvoSpan__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1635:1: ( rule__SimpleEvoSpan__Group__0__Impl rule__SimpleEvoSpan__Group__1 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1636:2: rule__SimpleEvoSpan__Group__0__Impl rule__SimpleEvoSpan__Group__1
            {
            pushFollow(FOLLOW_rule__SimpleEvoSpan__Group__0__Impl_in_rule__SimpleEvoSpan__Group__03476);
            rule__SimpleEvoSpan__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SimpleEvoSpan__Group__1_in_rule__SimpleEvoSpan__Group__03479);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1643:1: rule__SimpleEvoSpan__Group__0__Impl : ( 'simpleEvolution(' ) ;
    public final void rule__SimpleEvoSpan__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1647:1: ( ( 'simpleEvolution(' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1648:1: ( 'simpleEvolution(' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1648:1: ( 'simpleEvolution(' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1649:1: 'simpleEvolution('
            {
             before(grammarAccess.getSimpleEvoSpanAccess().getSimpleEvolutionKeyword_0()); 
            match(input,26,FOLLOW_26_in_rule__SimpleEvoSpan__Group__0__Impl3507); 
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1662:1: rule__SimpleEvoSpan__Group__1 : rule__SimpleEvoSpan__Group__1__Impl rule__SimpleEvoSpan__Group__2 ;
    public final void rule__SimpleEvoSpan__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1666:1: ( rule__SimpleEvoSpan__Group__1__Impl rule__SimpleEvoSpan__Group__2 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1667:2: rule__SimpleEvoSpan__Group__1__Impl rule__SimpleEvoSpan__Group__2
            {
            pushFollow(FOLLOW_rule__SimpleEvoSpan__Group__1__Impl_in_rule__SimpleEvoSpan__Group__13538);
            rule__SimpleEvoSpan__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SimpleEvoSpan__Group__2_in_rule__SimpleEvoSpan__Group__13541);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1674:1: rule__SimpleEvoSpan__Group__1__Impl : ( ( rule__SimpleEvoSpan__LhsAssignment_1 ) ) ;
    public final void rule__SimpleEvoSpan__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1678:1: ( ( ( rule__SimpleEvoSpan__LhsAssignment_1 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1679:1: ( ( rule__SimpleEvoSpan__LhsAssignment_1 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1679:1: ( ( rule__SimpleEvoSpan__LhsAssignment_1 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1680:1: ( rule__SimpleEvoSpan__LhsAssignment_1 )
            {
             before(grammarAccess.getSimpleEvoSpanAccess().getLhsAssignment_1()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1681:1: ( rule__SimpleEvoSpan__LhsAssignment_1 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1681:2: rule__SimpleEvoSpan__LhsAssignment_1
            {
            pushFollow(FOLLOW_rule__SimpleEvoSpan__LhsAssignment_1_in_rule__SimpleEvoSpan__Group__1__Impl3568);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1691:1: rule__SimpleEvoSpan__Group__2 : rule__SimpleEvoSpan__Group__2__Impl rule__SimpleEvoSpan__Group__3 ;
    public final void rule__SimpleEvoSpan__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1695:1: ( rule__SimpleEvoSpan__Group__2__Impl rule__SimpleEvoSpan__Group__3 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1696:2: rule__SimpleEvoSpan__Group__2__Impl rule__SimpleEvoSpan__Group__3
            {
            pushFollow(FOLLOW_rule__SimpleEvoSpan__Group__2__Impl_in_rule__SimpleEvoSpan__Group__23598);
            rule__SimpleEvoSpan__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SimpleEvoSpan__Group__3_in_rule__SimpleEvoSpan__Group__23601);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1703:1: rule__SimpleEvoSpan__Group__2__Impl : ( '<-' ) ;
    public final void rule__SimpleEvoSpan__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1707:1: ( ( '<-' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1708:1: ( '<-' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1708:1: ( '<-' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1709:1: '<-'
            {
             before(grammarAccess.getSimpleEvoSpanAccess().getLessThanSignHyphenMinusKeyword_2()); 
            match(input,27,FOLLOW_27_in_rule__SimpleEvoSpan__Group__2__Impl3629); 
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1722:1: rule__SimpleEvoSpan__Group__3 : rule__SimpleEvoSpan__Group__3__Impl rule__SimpleEvoSpan__Group__4 ;
    public final void rule__SimpleEvoSpan__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1726:1: ( rule__SimpleEvoSpan__Group__3__Impl rule__SimpleEvoSpan__Group__4 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1727:2: rule__SimpleEvoSpan__Group__3__Impl rule__SimpleEvoSpan__Group__4
            {
            pushFollow(FOLLOW_rule__SimpleEvoSpan__Group__3__Impl_in_rule__SimpleEvoSpan__Group__33660);
            rule__SimpleEvoSpan__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SimpleEvoSpan__Group__4_in_rule__SimpleEvoSpan__Group__33663);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1734:1: rule__SimpleEvoSpan__Group__3__Impl : ( ( rule__SimpleEvoSpan__DiffAssignment_3 ) ) ;
    public final void rule__SimpleEvoSpan__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1738:1: ( ( ( rule__SimpleEvoSpan__DiffAssignment_3 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1739:1: ( ( rule__SimpleEvoSpan__DiffAssignment_3 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1739:1: ( ( rule__SimpleEvoSpan__DiffAssignment_3 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1740:1: ( rule__SimpleEvoSpan__DiffAssignment_3 )
            {
             before(grammarAccess.getSimpleEvoSpanAccess().getDiffAssignment_3()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1741:1: ( rule__SimpleEvoSpan__DiffAssignment_3 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1741:2: rule__SimpleEvoSpan__DiffAssignment_3
            {
            pushFollow(FOLLOW_rule__SimpleEvoSpan__DiffAssignment_3_in_rule__SimpleEvoSpan__Group__3__Impl3690);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1751:1: rule__SimpleEvoSpan__Group__4 : rule__SimpleEvoSpan__Group__4__Impl rule__SimpleEvoSpan__Group__5 ;
    public final void rule__SimpleEvoSpan__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1755:1: ( rule__SimpleEvoSpan__Group__4__Impl rule__SimpleEvoSpan__Group__5 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1756:2: rule__SimpleEvoSpan__Group__4__Impl rule__SimpleEvoSpan__Group__5
            {
            pushFollow(FOLLOW_rule__SimpleEvoSpan__Group__4__Impl_in_rule__SimpleEvoSpan__Group__43720);
            rule__SimpleEvoSpan__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SimpleEvoSpan__Group__5_in_rule__SimpleEvoSpan__Group__43723);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1763:1: rule__SimpleEvoSpan__Group__4__Impl : ( '->' ) ;
    public final void rule__SimpleEvoSpan__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1767:1: ( ( '->' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1768:1: ( '->' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1768:1: ( '->' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1769:1: '->'
            {
             before(grammarAccess.getSimpleEvoSpanAccess().getHyphenMinusGreaterThanSignKeyword_4()); 
            match(input,28,FOLLOW_28_in_rule__SimpleEvoSpan__Group__4__Impl3751); 
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1782:1: rule__SimpleEvoSpan__Group__5 : rule__SimpleEvoSpan__Group__5__Impl rule__SimpleEvoSpan__Group__6 ;
    public final void rule__SimpleEvoSpan__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1786:1: ( rule__SimpleEvoSpan__Group__5__Impl rule__SimpleEvoSpan__Group__6 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1787:2: rule__SimpleEvoSpan__Group__5__Impl rule__SimpleEvoSpan__Group__6
            {
            pushFollow(FOLLOW_rule__SimpleEvoSpan__Group__5__Impl_in_rule__SimpleEvoSpan__Group__53782);
            rule__SimpleEvoSpan__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SimpleEvoSpan__Group__6_in_rule__SimpleEvoSpan__Group__53785);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1794:1: rule__SimpleEvoSpan__Group__5__Impl : ( ( rule__SimpleEvoSpan__RhSAssignment_5 ) ) ;
    public final void rule__SimpleEvoSpan__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1798:1: ( ( ( rule__SimpleEvoSpan__RhSAssignment_5 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1799:1: ( ( rule__SimpleEvoSpan__RhSAssignment_5 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1799:1: ( ( rule__SimpleEvoSpan__RhSAssignment_5 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1800:1: ( rule__SimpleEvoSpan__RhSAssignment_5 )
            {
             before(grammarAccess.getSimpleEvoSpanAccess().getRhSAssignment_5()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1801:1: ( rule__SimpleEvoSpan__RhSAssignment_5 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1801:2: rule__SimpleEvoSpan__RhSAssignment_5
            {
            pushFollow(FOLLOW_rule__SimpleEvoSpan__RhSAssignment_5_in_rule__SimpleEvoSpan__Group__5__Impl3812);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1811:1: rule__SimpleEvoSpan__Group__6 : rule__SimpleEvoSpan__Group__6__Impl rule__SimpleEvoSpan__Group__7 ;
    public final void rule__SimpleEvoSpan__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1815:1: ( rule__SimpleEvoSpan__Group__6__Impl rule__SimpleEvoSpan__Group__7 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1816:2: rule__SimpleEvoSpan__Group__6__Impl rule__SimpleEvoSpan__Group__7
            {
            pushFollow(FOLLOW_rule__SimpleEvoSpan__Group__6__Impl_in_rule__SimpleEvoSpan__Group__63842);
            rule__SimpleEvoSpan__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SimpleEvoSpan__Group__7_in_rule__SimpleEvoSpan__Group__63845);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1823:1: rule__SimpleEvoSpan__Group__6__Impl : ( ',' ) ;
    public final void rule__SimpleEvoSpan__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1827:1: ( ( ',' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1828:1: ( ',' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1828:1: ( ',' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1829:1: ','
            {
             before(grammarAccess.getSimpleEvoSpanAccess().getCommaKeyword_6()); 
            match(input,29,FOLLOW_29_in_rule__SimpleEvoSpan__Group__6__Impl3873); 
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1842:1: rule__SimpleEvoSpan__Group__7 : rule__SimpleEvoSpan__Group__7__Impl rule__SimpleEvoSpan__Group__8 ;
    public final void rule__SimpleEvoSpan__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1846:1: ( rule__SimpleEvoSpan__Group__7__Impl rule__SimpleEvoSpan__Group__8 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1847:2: rule__SimpleEvoSpan__Group__7__Impl rule__SimpleEvoSpan__Group__8
            {
            pushFollow(FOLLOW_rule__SimpleEvoSpan__Group__7__Impl_in_rule__SimpleEvoSpan__Group__73904);
            rule__SimpleEvoSpan__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SimpleEvoSpan__Group__8_in_rule__SimpleEvoSpan__Group__73907);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1854:1: rule__SimpleEvoSpan__Group__7__Impl : ( ( rule__SimpleEvoSpan__TypeGraphAssignment_7 ) ) ;
    public final void rule__SimpleEvoSpan__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1858:1: ( ( ( rule__SimpleEvoSpan__TypeGraphAssignment_7 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1859:1: ( ( rule__SimpleEvoSpan__TypeGraphAssignment_7 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1859:1: ( ( rule__SimpleEvoSpan__TypeGraphAssignment_7 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1860:1: ( rule__SimpleEvoSpan__TypeGraphAssignment_7 )
            {
             before(grammarAccess.getSimpleEvoSpanAccess().getTypeGraphAssignment_7()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1861:1: ( rule__SimpleEvoSpan__TypeGraphAssignment_7 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1861:2: rule__SimpleEvoSpan__TypeGraphAssignment_7
            {
            pushFollow(FOLLOW_rule__SimpleEvoSpan__TypeGraphAssignment_7_in_rule__SimpleEvoSpan__Group__7__Impl3934);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1871:1: rule__SimpleEvoSpan__Group__8 : rule__SimpleEvoSpan__Group__8__Impl ;
    public final void rule__SimpleEvoSpan__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1875:1: ( rule__SimpleEvoSpan__Group__8__Impl )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1876:2: rule__SimpleEvoSpan__Group__8__Impl
            {
            pushFollow(FOLLOW_rule__SimpleEvoSpan__Group__8__Impl_in_rule__SimpleEvoSpan__Group__83964);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1882:1: rule__SimpleEvoSpan__Group__8__Impl : ( ')' ) ;
    public final void rule__SimpleEvoSpan__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1886:1: ( ( ')' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1887:1: ( ')' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1887:1: ( ')' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1888:1: ')'
            {
             before(grammarAccess.getSimpleEvoSpanAccess().getRightParenthesisKeyword_8()); 
            match(input,23,FOLLOW_23_in_rule__SimpleEvoSpan__Group__8__Impl3992); 
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1919:1: rule__SimpleEvoCospan__Group__0 : rule__SimpleEvoCospan__Group__0__Impl rule__SimpleEvoCospan__Group__1 ;
    public final void rule__SimpleEvoCospan__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1923:1: ( rule__SimpleEvoCospan__Group__0__Impl rule__SimpleEvoCospan__Group__1 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1924:2: rule__SimpleEvoCospan__Group__0__Impl rule__SimpleEvoCospan__Group__1
            {
            pushFollow(FOLLOW_rule__SimpleEvoCospan__Group__0__Impl_in_rule__SimpleEvoCospan__Group__04041);
            rule__SimpleEvoCospan__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SimpleEvoCospan__Group__1_in_rule__SimpleEvoCospan__Group__04044);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1931:1: rule__SimpleEvoCospan__Group__0__Impl : ( 'simpleEvolution(' ) ;
    public final void rule__SimpleEvoCospan__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1935:1: ( ( 'simpleEvolution(' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1936:1: ( 'simpleEvolution(' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1936:1: ( 'simpleEvolution(' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1937:1: 'simpleEvolution('
            {
             before(grammarAccess.getSimpleEvoCospanAccess().getSimpleEvolutionKeyword_0()); 
            match(input,26,FOLLOW_26_in_rule__SimpleEvoCospan__Group__0__Impl4072); 
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1950:1: rule__SimpleEvoCospan__Group__1 : rule__SimpleEvoCospan__Group__1__Impl rule__SimpleEvoCospan__Group__2 ;
    public final void rule__SimpleEvoCospan__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1954:1: ( rule__SimpleEvoCospan__Group__1__Impl rule__SimpleEvoCospan__Group__2 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1955:2: rule__SimpleEvoCospan__Group__1__Impl rule__SimpleEvoCospan__Group__2
            {
            pushFollow(FOLLOW_rule__SimpleEvoCospan__Group__1__Impl_in_rule__SimpleEvoCospan__Group__14103);
            rule__SimpleEvoCospan__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SimpleEvoCospan__Group__2_in_rule__SimpleEvoCospan__Group__14106);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1962:1: rule__SimpleEvoCospan__Group__1__Impl : ( ( rule__SimpleEvoCospan__LhsAssignment_1 ) ) ;
    public final void rule__SimpleEvoCospan__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1966:1: ( ( ( rule__SimpleEvoCospan__LhsAssignment_1 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1967:1: ( ( rule__SimpleEvoCospan__LhsAssignment_1 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1967:1: ( ( rule__SimpleEvoCospan__LhsAssignment_1 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1968:1: ( rule__SimpleEvoCospan__LhsAssignment_1 )
            {
             before(grammarAccess.getSimpleEvoCospanAccess().getLhsAssignment_1()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1969:1: ( rule__SimpleEvoCospan__LhsAssignment_1 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1969:2: rule__SimpleEvoCospan__LhsAssignment_1
            {
            pushFollow(FOLLOW_rule__SimpleEvoCospan__LhsAssignment_1_in_rule__SimpleEvoCospan__Group__1__Impl4133);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1979:1: rule__SimpleEvoCospan__Group__2 : rule__SimpleEvoCospan__Group__2__Impl rule__SimpleEvoCospan__Group__3 ;
    public final void rule__SimpleEvoCospan__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1983:1: ( rule__SimpleEvoCospan__Group__2__Impl rule__SimpleEvoCospan__Group__3 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1984:2: rule__SimpleEvoCospan__Group__2__Impl rule__SimpleEvoCospan__Group__3
            {
            pushFollow(FOLLOW_rule__SimpleEvoCospan__Group__2__Impl_in_rule__SimpleEvoCospan__Group__24163);
            rule__SimpleEvoCospan__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SimpleEvoCospan__Group__3_in_rule__SimpleEvoCospan__Group__24166);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1991:1: rule__SimpleEvoCospan__Group__2__Impl : ( '->' ) ;
    public final void rule__SimpleEvoCospan__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1995:1: ( ( '->' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1996:1: ( '->' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1996:1: ( '->' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:1997:1: '->'
            {
             before(grammarAccess.getSimpleEvoCospanAccess().getHyphenMinusGreaterThanSignKeyword_2()); 
            match(input,28,FOLLOW_28_in_rule__SimpleEvoCospan__Group__2__Impl4194); 
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2010:1: rule__SimpleEvoCospan__Group__3 : rule__SimpleEvoCospan__Group__3__Impl rule__SimpleEvoCospan__Group__4 ;
    public final void rule__SimpleEvoCospan__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2014:1: ( rule__SimpleEvoCospan__Group__3__Impl rule__SimpleEvoCospan__Group__4 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2015:2: rule__SimpleEvoCospan__Group__3__Impl rule__SimpleEvoCospan__Group__4
            {
            pushFollow(FOLLOW_rule__SimpleEvoCospan__Group__3__Impl_in_rule__SimpleEvoCospan__Group__34225);
            rule__SimpleEvoCospan__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SimpleEvoCospan__Group__4_in_rule__SimpleEvoCospan__Group__34228);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2022:1: rule__SimpleEvoCospan__Group__3__Impl : ( ( rule__SimpleEvoCospan__JointAssignment_3 ) ) ;
    public final void rule__SimpleEvoCospan__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2026:1: ( ( ( rule__SimpleEvoCospan__JointAssignment_3 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2027:1: ( ( rule__SimpleEvoCospan__JointAssignment_3 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2027:1: ( ( rule__SimpleEvoCospan__JointAssignment_3 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2028:1: ( rule__SimpleEvoCospan__JointAssignment_3 )
            {
             before(grammarAccess.getSimpleEvoCospanAccess().getJointAssignment_3()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2029:1: ( rule__SimpleEvoCospan__JointAssignment_3 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2029:2: rule__SimpleEvoCospan__JointAssignment_3
            {
            pushFollow(FOLLOW_rule__SimpleEvoCospan__JointAssignment_3_in_rule__SimpleEvoCospan__Group__3__Impl4255);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2039:1: rule__SimpleEvoCospan__Group__4 : rule__SimpleEvoCospan__Group__4__Impl rule__SimpleEvoCospan__Group__5 ;
    public final void rule__SimpleEvoCospan__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2043:1: ( rule__SimpleEvoCospan__Group__4__Impl rule__SimpleEvoCospan__Group__5 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2044:2: rule__SimpleEvoCospan__Group__4__Impl rule__SimpleEvoCospan__Group__5
            {
            pushFollow(FOLLOW_rule__SimpleEvoCospan__Group__4__Impl_in_rule__SimpleEvoCospan__Group__44285);
            rule__SimpleEvoCospan__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SimpleEvoCospan__Group__5_in_rule__SimpleEvoCospan__Group__44288);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2051:1: rule__SimpleEvoCospan__Group__4__Impl : ( '<-' ) ;
    public final void rule__SimpleEvoCospan__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2055:1: ( ( '<-' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2056:1: ( '<-' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2056:1: ( '<-' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2057:1: '<-'
            {
             before(grammarAccess.getSimpleEvoCospanAccess().getLessThanSignHyphenMinusKeyword_4()); 
            match(input,27,FOLLOW_27_in_rule__SimpleEvoCospan__Group__4__Impl4316); 
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2070:1: rule__SimpleEvoCospan__Group__5 : rule__SimpleEvoCospan__Group__5__Impl rule__SimpleEvoCospan__Group__6 ;
    public final void rule__SimpleEvoCospan__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2074:1: ( rule__SimpleEvoCospan__Group__5__Impl rule__SimpleEvoCospan__Group__6 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2075:2: rule__SimpleEvoCospan__Group__5__Impl rule__SimpleEvoCospan__Group__6
            {
            pushFollow(FOLLOW_rule__SimpleEvoCospan__Group__5__Impl_in_rule__SimpleEvoCospan__Group__54347);
            rule__SimpleEvoCospan__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SimpleEvoCospan__Group__6_in_rule__SimpleEvoCospan__Group__54350);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2082:1: rule__SimpleEvoCospan__Group__5__Impl : ( ( rule__SimpleEvoCospan__RhsAssignment_5 ) ) ;
    public final void rule__SimpleEvoCospan__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2086:1: ( ( ( rule__SimpleEvoCospan__RhsAssignment_5 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2087:1: ( ( rule__SimpleEvoCospan__RhsAssignment_5 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2087:1: ( ( rule__SimpleEvoCospan__RhsAssignment_5 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2088:1: ( rule__SimpleEvoCospan__RhsAssignment_5 )
            {
             before(grammarAccess.getSimpleEvoCospanAccess().getRhsAssignment_5()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2089:1: ( rule__SimpleEvoCospan__RhsAssignment_5 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2089:2: rule__SimpleEvoCospan__RhsAssignment_5
            {
            pushFollow(FOLLOW_rule__SimpleEvoCospan__RhsAssignment_5_in_rule__SimpleEvoCospan__Group__5__Impl4377);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2099:1: rule__SimpleEvoCospan__Group__6 : rule__SimpleEvoCospan__Group__6__Impl rule__SimpleEvoCospan__Group__7 ;
    public final void rule__SimpleEvoCospan__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2103:1: ( rule__SimpleEvoCospan__Group__6__Impl rule__SimpleEvoCospan__Group__7 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2104:2: rule__SimpleEvoCospan__Group__6__Impl rule__SimpleEvoCospan__Group__7
            {
            pushFollow(FOLLOW_rule__SimpleEvoCospan__Group__6__Impl_in_rule__SimpleEvoCospan__Group__64407);
            rule__SimpleEvoCospan__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SimpleEvoCospan__Group__7_in_rule__SimpleEvoCospan__Group__64410);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2111:1: rule__SimpleEvoCospan__Group__6__Impl : ( ',' ) ;
    public final void rule__SimpleEvoCospan__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2115:1: ( ( ',' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2116:1: ( ',' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2116:1: ( ',' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2117:1: ','
            {
             before(grammarAccess.getSimpleEvoCospanAccess().getCommaKeyword_6()); 
            match(input,29,FOLLOW_29_in_rule__SimpleEvoCospan__Group__6__Impl4438); 
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2130:1: rule__SimpleEvoCospan__Group__7 : rule__SimpleEvoCospan__Group__7__Impl rule__SimpleEvoCospan__Group__8 ;
    public final void rule__SimpleEvoCospan__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2134:1: ( rule__SimpleEvoCospan__Group__7__Impl rule__SimpleEvoCospan__Group__8 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2135:2: rule__SimpleEvoCospan__Group__7__Impl rule__SimpleEvoCospan__Group__8
            {
            pushFollow(FOLLOW_rule__SimpleEvoCospan__Group__7__Impl_in_rule__SimpleEvoCospan__Group__74469);
            rule__SimpleEvoCospan__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SimpleEvoCospan__Group__8_in_rule__SimpleEvoCospan__Group__74472);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2142:1: rule__SimpleEvoCospan__Group__7__Impl : ( ( rule__SimpleEvoCospan__TypeGraphAssignment_7 ) ) ;
    public final void rule__SimpleEvoCospan__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2146:1: ( ( ( rule__SimpleEvoCospan__TypeGraphAssignment_7 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2147:1: ( ( rule__SimpleEvoCospan__TypeGraphAssignment_7 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2147:1: ( ( rule__SimpleEvoCospan__TypeGraphAssignment_7 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2148:1: ( rule__SimpleEvoCospan__TypeGraphAssignment_7 )
            {
             before(grammarAccess.getSimpleEvoCospanAccess().getTypeGraphAssignment_7()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2149:1: ( rule__SimpleEvoCospan__TypeGraphAssignment_7 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2149:2: rule__SimpleEvoCospan__TypeGraphAssignment_7
            {
            pushFollow(FOLLOW_rule__SimpleEvoCospan__TypeGraphAssignment_7_in_rule__SimpleEvoCospan__Group__7__Impl4499);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2159:1: rule__SimpleEvoCospan__Group__8 : rule__SimpleEvoCospan__Group__8__Impl ;
    public final void rule__SimpleEvoCospan__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2163:1: ( rule__SimpleEvoCospan__Group__8__Impl )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2164:2: rule__SimpleEvoCospan__Group__8__Impl
            {
            pushFollow(FOLLOW_rule__SimpleEvoCospan__Group__8__Impl_in_rule__SimpleEvoCospan__Group__84529);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2170:1: rule__SimpleEvoCospan__Group__8__Impl : ( ')' ) ;
    public final void rule__SimpleEvoCospan__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2174:1: ( ( ')' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2175:1: ( ')' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2175:1: ( ')' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2176:1: ')'
            {
             before(grammarAccess.getSimpleEvoCospanAccess().getRightParenthesisKeyword_8()); 
            match(input,23,FOLLOW_23_in_rule__SimpleEvoCospan__Group__8__Impl4557); 
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2207:1: rule__EvoSpan__Group__0 : rule__EvoSpan__Group__0__Impl rule__EvoSpan__Group__1 ;
    public final void rule__EvoSpan__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2211:1: ( rule__EvoSpan__Group__0__Impl rule__EvoSpan__Group__1 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2212:2: rule__EvoSpan__Group__0__Impl rule__EvoSpan__Group__1
            {
            pushFollow(FOLLOW_rule__EvoSpan__Group__0__Impl_in_rule__EvoSpan__Group__04606);
            rule__EvoSpan__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__EvoSpan__Group__1_in_rule__EvoSpan__Group__04609);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2219:1: rule__EvoSpan__Group__0__Impl : ( 'evolution(' ) ;
    public final void rule__EvoSpan__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2223:1: ( ( 'evolution(' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2224:1: ( 'evolution(' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2224:1: ( 'evolution(' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2225:1: 'evolution('
            {
             before(grammarAccess.getEvoSpanAccess().getEvolutionKeyword_0()); 
            match(input,30,FOLLOW_30_in_rule__EvoSpan__Group__0__Impl4637); 
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2238:1: rule__EvoSpan__Group__1 : rule__EvoSpan__Group__1__Impl rule__EvoSpan__Group__2 ;
    public final void rule__EvoSpan__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2242:1: ( rule__EvoSpan__Group__1__Impl rule__EvoSpan__Group__2 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2243:2: rule__EvoSpan__Group__1__Impl rule__EvoSpan__Group__2
            {
            pushFollow(FOLLOW_rule__EvoSpan__Group__1__Impl_in_rule__EvoSpan__Group__14668);
            rule__EvoSpan__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__EvoSpan__Group__2_in_rule__EvoSpan__Group__14671);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2250:1: rule__EvoSpan__Group__1__Impl : ( ( rule__EvoSpan__LhsAssignment_1 ) ) ;
    public final void rule__EvoSpan__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2254:1: ( ( ( rule__EvoSpan__LhsAssignment_1 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2255:1: ( ( rule__EvoSpan__LhsAssignment_1 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2255:1: ( ( rule__EvoSpan__LhsAssignment_1 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2256:1: ( rule__EvoSpan__LhsAssignment_1 )
            {
             before(grammarAccess.getEvoSpanAccess().getLhsAssignment_1()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2257:1: ( rule__EvoSpan__LhsAssignment_1 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2257:2: rule__EvoSpan__LhsAssignment_1
            {
            pushFollow(FOLLOW_rule__EvoSpan__LhsAssignment_1_in_rule__EvoSpan__Group__1__Impl4698);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2267:1: rule__EvoSpan__Group__2 : rule__EvoSpan__Group__2__Impl rule__EvoSpan__Group__3 ;
    public final void rule__EvoSpan__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2271:1: ( rule__EvoSpan__Group__2__Impl rule__EvoSpan__Group__3 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2272:2: rule__EvoSpan__Group__2__Impl rule__EvoSpan__Group__3
            {
            pushFollow(FOLLOW_rule__EvoSpan__Group__2__Impl_in_rule__EvoSpan__Group__24728);
            rule__EvoSpan__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__EvoSpan__Group__3_in_rule__EvoSpan__Group__24731);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2279:1: rule__EvoSpan__Group__2__Impl : ( '<->' ) ;
    public final void rule__EvoSpan__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2283:1: ( ( '<->' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2284:1: ( '<->' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2284:1: ( '<->' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2285:1: '<->'
            {
             before(grammarAccess.getEvoSpanAccess().getLessThanSignHyphenMinusGreaterThanSignKeyword_2()); 
            match(input,31,FOLLOW_31_in_rule__EvoSpan__Group__2__Impl4759); 
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2298:1: rule__EvoSpan__Group__3 : rule__EvoSpan__Group__3__Impl rule__EvoSpan__Group__4 ;
    public final void rule__EvoSpan__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2302:1: ( rule__EvoSpan__Group__3__Impl rule__EvoSpan__Group__4 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2303:2: rule__EvoSpan__Group__3__Impl rule__EvoSpan__Group__4
            {
            pushFollow(FOLLOW_rule__EvoSpan__Group__3__Impl_in_rule__EvoSpan__Group__34790);
            rule__EvoSpan__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__EvoSpan__Group__4_in_rule__EvoSpan__Group__34793);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2310:1: rule__EvoSpan__Group__3__Impl : ( ( rule__EvoSpan__RhsAssignment_3 ) ) ;
    public final void rule__EvoSpan__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2314:1: ( ( ( rule__EvoSpan__RhsAssignment_3 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2315:1: ( ( rule__EvoSpan__RhsAssignment_3 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2315:1: ( ( rule__EvoSpan__RhsAssignment_3 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2316:1: ( rule__EvoSpan__RhsAssignment_3 )
            {
             before(grammarAccess.getEvoSpanAccess().getRhsAssignment_3()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2317:1: ( rule__EvoSpan__RhsAssignment_3 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2317:2: rule__EvoSpan__RhsAssignment_3
            {
            pushFollow(FOLLOW_rule__EvoSpan__RhsAssignment_3_in_rule__EvoSpan__Group__3__Impl4820);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2327:1: rule__EvoSpan__Group__4 : rule__EvoSpan__Group__4__Impl rule__EvoSpan__Group__5 ;
    public final void rule__EvoSpan__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2331:1: ( rule__EvoSpan__Group__4__Impl rule__EvoSpan__Group__5 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2332:2: rule__EvoSpan__Group__4__Impl rule__EvoSpan__Group__5
            {
            pushFollow(FOLLOW_rule__EvoSpan__Group__4__Impl_in_rule__EvoSpan__Group__44850);
            rule__EvoSpan__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__EvoSpan__Group__5_in_rule__EvoSpan__Group__44853);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2339:1: rule__EvoSpan__Group__4__Impl : ( ',' ) ;
    public final void rule__EvoSpan__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2343:1: ( ( ',' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2344:1: ( ',' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2344:1: ( ',' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2345:1: ','
            {
             before(grammarAccess.getEvoSpanAccess().getCommaKeyword_4()); 
            match(input,29,FOLLOW_29_in_rule__EvoSpan__Group__4__Impl4881); 
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2358:1: rule__EvoSpan__Group__5 : rule__EvoSpan__Group__5__Impl rule__EvoSpan__Group__6 ;
    public final void rule__EvoSpan__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2362:1: ( rule__EvoSpan__Group__5__Impl rule__EvoSpan__Group__6 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2363:2: rule__EvoSpan__Group__5__Impl rule__EvoSpan__Group__6
            {
            pushFollow(FOLLOW_rule__EvoSpan__Group__5__Impl_in_rule__EvoSpan__Group__54912);
            rule__EvoSpan__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__EvoSpan__Group__6_in_rule__EvoSpan__Group__54915);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2370:1: rule__EvoSpan__Group__5__Impl : ( ( rule__EvoSpan__TypeGraphAssignment_5 ) ) ;
    public final void rule__EvoSpan__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2374:1: ( ( ( rule__EvoSpan__TypeGraphAssignment_5 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2375:1: ( ( rule__EvoSpan__TypeGraphAssignment_5 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2375:1: ( ( rule__EvoSpan__TypeGraphAssignment_5 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2376:1: ( rule__EvoSpan__TypeGraphAssignment_5 )
            {
             before(grammarAccess.getEvoSpanAccess().getTypeGraphAssignment_5()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2377:1: ( rule__EvoSpan__TypeGraphAssignment_5 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2377:2: rule__EvoSpan__TypeGraphAssignment_5
            {
            pushFollow(FOLLOW_rule__EvoSpan__TypeGraphAssignment_5_in_rule__EvoSpan__Group__5__Impl4942);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2387:1: rule__EvoSpan__Group__6 : rule__EvoSpan__Group__6__Impl ;
    public final void rule__EvoSpan__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2391:1: ( rule__EvoSpan__Group__6__Impl )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2392:2: rule__EvoSpan__Group__6__Impl
            {
            pushFollow(FOLLOW_rule__EvoSpan__Group__6__Impl_in_rule__EvoSpan__Group__64972);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2398:1: rule__EvoSpan__Group__6__Impl : ( ')' ) ;
    public final void rule__EvoSpan__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2402:1: ( ( ')' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2403:1: ( ')' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2403:1: ( ')' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2404:1: ')'
            {
             before(grammarAccess.getEvoSpanAccess().getRightParenthesisKeyword_6()); 
            match(input,23,FOLLOW_23_in_rule__EvoSpan__Group__6__Impl5000); 
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2431:1: rule__EvoCospan__Group__0 : rule__EvoCospan__Group__0__Impl rule__EvoCospan__Group__1 ;
    public final void rule__EvoCospan__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2435:1: ( rule__EvoCospan__Group__0__Impl rule__EvoCospan__Group__1 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2436:2: rule__EvoCospan__Group__0__Impl rule__EvoCospan__Group__1
            {
            pushFollow(FOLLOW_rule__EvoCospan__Group__0__Impl_in_rule__EvoCospan__Group__05045);
            rule__EvoCospan__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__EvoCospan__Group__1_in_rule__EvoCospan__Group__05048);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2443:1: rule__EvoCospan__Group__0__Impl : ( 'evolution(' ) ;
    public final void rule__EvoCospan__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2447:1: ( ( 'evolution(' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2448:1: ( 'evolution(' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2448:1: ( 'evolution(' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2449:1: 'evolution('
            {
             before(grammarAccess.getEvoCospanAccess().getEvolutionKeyword_0()); 
            match(input,30,FOLLOW_30_in_rule__EvoCospan__Group__0__Impl5076); 
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2462:1: rule__EvoCospan__Group__1 : rule__EvoCospan__Group__1__Impl rule__EvoCospan__Group__2 ;
    public final void rule__EvoCospan__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2466:1: ( rule__EvoCospan__Group__1__Impl rule__EvoCospan__Group__2 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2467:2: rule__EvoCospan__Group__1__Impl rule__EvoCospan__Group__2
            {
            pushFollow(FOLLOW_rule__EvoCospan__Group__1__Impl_in_rule__EvoCospan__Group__15107);
            rule__EvoCospan__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__EvoCospan__Group__2_in_rule__EvoCospan__Group__15110);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2474:1: rule__EvoCospan__Group__1__Impl : ( ( rule__EvoCospan__LhsAssignment_1 ) ) ;
    public final void rule__EvoCospan__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2478:1: ( ( ( rule__EvoCospan__LhsAssignment_1 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2479:1: ( ( rule__EvoCospan__LhsAssignment_1 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2479:1: ( ( rule__EvoCospan__LhsAssignment_1 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2480:1: ( rule__EvoCospan__LhsAssignment_1 )
            {
             before(grammarAccess.getEvoCospanAccess().getLhsAssignment_1()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2481:1: ( rule__EvoCospan__LhsAssignment_1 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2481:2: rule__EvoCospan__LhsAssignment_1
            {
            pushFollow(FOLLOW_rule__EvoCospan__LhsAssignment_1_in_rule__EvoCospan__Group__1__Impl5137);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2491:1: rule__EvoCospan__Group__2 : rule__EvoCospan__Group__2__Impl rule__EvoCospan__Group__3 ;
    public final void rule__EvoCospan__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2495:1: ( rule__EvoCospan__Group__2__Impl rule__EvoCospan__Group__3 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2496:2: rule__EvoCospan__Group__2__Impl rule__EvoCospan__Group__3
            {
            pushFollow(FOLLOW_rule__EvoCospan__Group__2__Impl_in_rule__EvoCospan__Group__25167);
            rule__EvoCospan__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__EvoCospan__Group__3_in_rule__EvoCospan__Group__25170);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2503:1: rule__EvoCospan__Group__2__Impl : ( '-><-' ) ;
    public final void rule__EvoCospan__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2507:1: ( ( '-><-' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2508:1: ( '-><-' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2508:1: ( '-><-' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2509:1: '-><-'
            {
             before(grammarAccess.getEvoCospanAccess().getHyphenMinusGreaterThanSignLessThanSignHyphenMinusKeyword_2()); 
            match(input,32,FOLLOW_32_in_rule__EvoCospan__Group__2__Impl5198); 
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2522:1: rule__EvoCospan__Group__3 : rule__EvoCospan__Group__3__Impl rule__EvoCospan__Group__4 ;
    public final void rule__EvoCospan__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2526:1: ( rule__EvoCospan__Group__3__Impl rule__EvoCospan__Group__4 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2527:2: rule__EvoCospan__Group__3__Impl rule__EvoCospan__Group__4
            {
            pushFollow(FOLLOW_rule__EvoCospan__Group__3__Impl_in_rule__EvoCospan__Group__35229);
            rule__EvoCospan__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__EvoCospan__Group__4_in_rule__EvoCospan__Group__35232);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2534:1: rule__EvoCospan__Group__3__Impl : ( ( rule__EvoCospan__RhsAssignment_3 ) ) ;
    public final void rule__EvoCospan__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2538:1: ( ( ( rule__EvoCospan__RhsAssignment_3 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2539:1: ( ( rule__EvoCospan__RhsAssignment_3 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2539:1: ( ( rule__EvoCospan__RhsAssignment_3 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2540:1: ( rule__EvoCospan__RhsAssignment_3 )
            {
             before(grammarAccess.getEvoCospanAccess().getRhsAssignment_3()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2541:1: ( rule__EvoCospan__RhsAssignment_3 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2541:2: rule__EvoCospan__RhsAssignment_3
            {
            pushFollow(FOLLOW_rule__EvoCospan__RhsAssignment_3_in_rule__EvoCospan__Group__3__Impl5259);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2551:1: rule__EvoCospan__Group__4 : rule__EvoCospan__Group__4__Impl rule__EvoCospan__Group__5 ;
    public final void rule__EvoCospan__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2555:1: ( rule__EvoCospan__Group__4__Impl rule__EvoCospan__Group__5 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2556:2: rule__EvoCospan__Group__4__Impl rule__EvoCospan__Group__5
            {
            pushFollow(FOLLOW_rule__EvoCospan__Group__4__Impl_in_rule__EvoCospan__Group__45289);
            rule__EvoCospan__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__EvoCospan__Group__5_in_rule__EvoCospan__Group__45292);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2563:1: rule__EvoCospan__Group__4__Impl : ( ',' ) ;
    public final void rule__EvoCospan__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2567:1: ( ( ',' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2568:1: ( ',' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2568:1: ( ',' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2569:1: ','
            {
             before(grammarAccess.getEvoCospanAccess().getCommaKeyword_4()); 
            match(input,29,FOLLOW_29_in_rule__EvoCospan__Group__4__Impl5320); 
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2582:1: rule__EvoCospan__Group__5 : rule__EvoCospan__Group__5__Impl rule__EvoCospan__Group__6 ;
    public final void rule__EvoCospan__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2586:1: ( rule__EvoCospan__Group__5__Impl rule__EvoCospan__Group__6 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2587:2: rule__EvoCospan__Group__5__Impl rule__EvoCospan__Group__6
            {
            pushFollow(FOLLOW_rule__EvoCospan__Group__5__Impl_in_rule__EvoCospan__Group__55351);
            rule__EvoCospan__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__EvoCospan__Group__6_in_rule__EvoCospan__Group__55354);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2594:1: rule__EvoCospan__Group__5__Impl : ( ( rule__EvoCospan__TypeGraphAssignment_5 ) ) ;
    public final void rule__EvoCospan__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2598:1: ( ( ( rule__EvoCospan__TypeGraphAssignment_5 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2599:1: ( ( rule__EvoCospan__TypeGraphAssignment_5 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2599:1: ( ( rule__EvoCospan__TypeGraphAssignment_5 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2600:1: ( rule__EvoCospan__TypeGraphAssignment_5 )
            {
             before(grammarAccess.getEvoCospanAccess().getTypeGraphAssignment_5()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2601:1: ( rule__EvoCospan__TypeGraphAssignment_5 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2601:2: rule__EvoCospan__TypeGraphAssignment_5
            {
            pushFollow(FOLLOW_rule__EvoCospan__TypeGraphAssignment_5_in_rule__EvoCospan__Group__5__Impl5381);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2611:1: rule__EvoCospan__Group__6 : rule__EvoCospan__Group__6__Impl ;
    public final void rule__EvoCospan__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2615:1: ( rule__EvoCospan__Group__6__Impl )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2616:2: rule__EvoCospan__Group__6__Impl
            {
            pushFollow(FOLLOW_rule__EvoCospan__Group__6__Impl_in_rule__EvoCospan__Group__65411);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2622:1: rule__EvoCospan__Group__6__Impl : ( ')' ) ;
    public final void rule__EvoCospan__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2626:1: ( ( ')' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2627:1: ( ')' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2627:1: ( ')' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2628:1: ')'
            {
             before(grammarAccess.getEvoCospanAccess().getRightParenthesisKeyword_6()); 
            match(input,23,FOLLOW_23_in_rule__EvoCospan__Group__6__Impl5439); 
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2655:1: rule__InstanceSpecification__Group__0 : rule__InstanceSpecification__Group__0__Impl rule__InstanceSpecification__Group__1 ;
    public final void rule__InstanceSpecification__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2659:1: ( rule__InstanceSpecification__Group__0__Impl rule__InstanceSpecification__Group__1 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2660:2: rule__InstanceSpecification__Group__0__Impl rule__InstanceSpecification__Group__1
            {
            pushFollow(FOLLOW_rule__InstanceSpecification__Group__0__Impl_in_rule__InstanceSpecification__Group__05484);
            rule__InstanceSpecification__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__InstanceSpecification__Group__1_in_rule__InstanceSpecification__Group__05487);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2667:1: rule__InstanceSpecification__Group__0__Impl : ( ( rule__InstanceSpecification__IdAssignment_0 ) ) ;
    public final void rule__InstanceSpecification__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2671:1: ( ( ( rule__InstanceSpecification__IdAssignment_0 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2672:1: ( ( rule__InstanceSpecification__IdAssignment_0 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2672:1: ( ( rule__InstanceSpecification__IdAssignment_0 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2673:1: ( rule__InstanceSpecification__IdAssignment_0 )
            {
             before(grammarAccess.getInstanceSpecificationAccess().getIdAssignment_0()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2674:1: ( rule__InstanceSpecification__IdAssignment_0 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2674:2: rule__InstanceSpecification__IdAssignment_0
            {
            pushFollow(FOLLOW_rule__InstanceSpecification__IdAssignment_0_in_rule__InstanceSpecification__Group__0__Impl5514);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2684:1: rule__InstanceSpecification__Group__1 : rule__InstanceSpecification__Group__1__Impl rule__InstanceSpecification__Group__2 ;
    public final void rule__InstanceSpecification__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2688:1: ( rule__InstanceSpecification__Group__1__Impl rule__InstanceSpecification__Group__2 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2689:2: rule__InstanceSpecification__Group__1__Impl rule__InstanceSpecification__Group__2
            {
            pushFollow(FOLLOW_rule__InstanceSpecification__Group__1__Impl_in_rule__InstanceSpecification__Group__15544);
            rule__InstanceSpecification__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__InstanceSpecification__Group__2_in_rule__InstanceSpecification__Group__15547);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2696:1: rule__InstanceSpecification__Group__1__Impl : ( ':=' ) ;
    public final void rule__InstanceSpecification__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2700:1: ( ( ':=' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2701:1: ( ':=' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2701:1: ( ':=' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2702:1: ':='
            {
             before(grammarAccess.getInstanceSpecificationAccess().getColonEqualsSignKeyword_1()); 
            match(input,33,FOLLOW_33_in_rule__InstanceSpecification__Group__1__Impl5575); 
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2715:1: rule__InstanceSpecification__Group__2 : rule__InstanceSpecification__Group__2__Impl rule__InstanceSpecification__Group__3 ;
    public final void rule__InstanceSpecification__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2719:1: ( rule__InstanceSpecification__Group__2__Impl rule__InstanceSpecification__Group__3 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2720:2: rule__InstanceSpecification__Group__2__Impl rule__InstanceSpecification__Group__3
            {
            pushFollow(FOLLOW_rule__InstanceSpecification__Group__2__Impl_in_rule__InstanceSpecification__Group__25606);
            rule__InstanceSpecification__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__InstanceSpecification__Group__3_in_rule__InstanceSpecification__Group__25609);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2727:1: rule__InstanceSpecification__Group__2__Impl : ( 'ISpec<' ) ;
    public final void rule__InstanceSpecification__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2731:1: ( ( 'ISpec<' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2732:1: ( 'ISpec<' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2732:1: ( 'ISpec<' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2733:1: 'ISpec<'
            {
             before(grammarAccess.getInstanceSpecificationAccess().getISpecKeyword_2()); 
            match(input,34,FOLLOW_34_in_rule__InstanceSpecification__Group__2__Impl5637); 
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2746:1: rule__InstanceSpecification__Group__3 : rule__InstanceSpecification__Group__3__Impl rule__InstanceSpecification__Group__4 ;
    public final void rule__InstanceSpecification__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2750:1: ( rule__InstanceSpecification__Group__3__Impl rule__InstanceSpecification__Group__4 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2751:2: rule__InstanceSpecification__Group__3__Impl rule__InstanceSpecification__Group__4
            {
            pushFollow(FOLLOW_rule__InstanceSpecification__Group__3__Impl_in_rule__InstanceSpecification__Group__35668);
            rule__InstanceSpecification__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__InstanceSpecification__Group__4_in_rule__InstanceSpecification__Group__35671);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2758:1: rule__InstanceSpecification__Group__3__Impl : ( ( rule__InstanceSpecification__ModelAssignment_3 ) ) ;
    public final void rule__InstanceSpecification__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2762:1: ( ( ( rule__InstanceSpecification__ModelAssignment_3 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2763:1: ( ( rule__InstanceSpecification__ModelAssignment_3 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2763:1: ( ( rule__InstanceSpecification__ModelAssignment_3 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2764:1: ( rule__InstanceSpecification__ModelAssignment_3 )
            {
             before(grammarAccess.getInstanceSpecificationAccess().getModelAssignment_3()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2765:1: ( rule__InstanceSpecification__ModelAssignment_3 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2765:2: rule__InstanceSpecification__ModelAssignment_3
            {
            pushFollow(FOLLOW_rule__InstanceSpecification__ModelAssignment_3_in_rule__InstanceSpecification__Group__3__Impl5698);
            rule__InstanceSpecification__ModelAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getInstanceSpecificationAccess().getModelAssignment_3()); 

            }


            }

        }
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2775:1: rule__InstanceSpecification__Group__4 : rule__InstanceSpecification__Group__4__Impl rule__InstanceSpecification__Group__5 ;
    public final void rule__InstanceSpecification__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2779:1: ( rule__InstanceSpecification__Group__4__Impl rule__InstanceSpecification__Group__5 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2780:2: rule__InstanceSpecification__Group__4__Impl rule__InstanceSpecification__Group__5
            {
            pushFollow(FOLLOW_rule__InstanceSpecification__Group__4__Impl_in_rule__InstanceSpecification__Group__45728);
            rule__InstanceSpecification__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__InstanceSpecification__Group__5_in_rule__InstanceSpecification__Group__45731);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2787:1: rule__InstanceSpecification__Group__4__Impl : ( ',' ) ;
    public final void rule__InstanceSpecification__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2791:1: ( ( ',' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2792:1: ( ',' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2792:1: ( ',' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2793:1: ','
            {
             before(grammarAccess.getInstanceSpecificationAccess().getCommaKeyword_4()); 
            match(input,29,FOLLOW_29_in_rule__InstanceSpecification__Group__4__Impl5759); 
             after(grammarAccess.getInstanceSpecificationAccess().getCommaKeyword_4()); 

            }


            }

        }
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2806:1: rule__InstanceSpecification__Group__5 : rule__InstanceSpecification__Group__5__Impl rule__InstanceSpecification__Group__6 ;
    public final void rule__InstanceSpecification__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2810:1: ( rule__InstanceSpecification__Group__5__Impl rule__InstanceSpecification__Group__6 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2811:2: rule__InstanceSpecification__Group__5__Impl rule__InstanceSpecification__Group__6
            {
            pushFollow(FOLLOW_rule__InstanceSpecification__Group__5__Impl_in_rule__InstanceSpecification__Group__55790);
            rule__InstanceSpecification__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__InstanceSpecification__Group__6_in_rule__InstanceSpecification__Group__55793);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2818:1: rule__InstanceSpecification__Group__5__Impl : ( ( rule__InstanceSpecification__MetamodelAssignment_5 ) ) ;
    public final void rule__InstanceSpecification__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2822:1: ( ( ( rule__InstanceSpecification__MetamodelAssignment_5 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2823:1: ( ( rule__InstanceSpecification__MetamodelAssignment_5 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2823:1: ( ( rule__InstanceSpecification__MetamodelAssignment_5 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2824:1: ( rule__InstanceSpecification__MetamodelAssignment_5 )
            {
             before(grammarAccess.getInstanceSpecificationAccess().getMetamodelAssignment_5()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2825:1: ( rule__InstanceSpecification__MetamodelAssignment_5 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2825:2: rule__InstanceSpecification__MetamodelAssignment_5
            {
            pushFollow(FOLLOW_rule__InstanceSpecification__MetamodelAssignment_5_in_rule__InstanceSpecification__Group__5__Impl5820);
            rule__InstanceSpecification__MetamodelAssignment_5();

            state._fsp--;


            }

             after(grammarAccess.getInstanceSpecificationAccess().getMetamodelAssignment_5()); 

            }


            }

        }
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2835:1: rule__InstanceSpecification__Group__6 : rule__InstanceSpecification__Group__6__Impl rule__InstanceSpecification__Group__7 ;
    public final void rule__InstanceSpecification__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2839:1: ( rule__InstanceSpecification__Group__6__Impl rule__InstanceSpecification__Group__7 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2840:2: rule__InstanceSpecification__Group__6__Impl rule__InstanceSpecification__Group__7
            {
            pushFollow(FOLLOW_rule__InstanceSpecification__Group__6__Impl_in_rule__InstanceSpecification__Group__65850);
            rule__InstanceSpecification__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__InstanceSpecification__Group__7_in_rule__InstanceSpecification__Group__65853);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2847:1: rule__InstanceSpecification__Group__6__Impl : ( '>' ) ;
    public final void rule__InstanceSpecification__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2851:1: ( ( '>' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2852:1: ( '>' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2852:1: ( '>' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2853:1: '>'
            {
             before(grammarAccess.getInstanceSpecificationAccess().getGreaterThanSignKeyword_6()); 
            match(input,35,FOLLOW_35_in_rule__InstanceSpecification__Group__6__Impl5881); 
             after(grammarAccess.getInstanceSpecificationAccess().getGreaterThanSignKeyword_6()); 

            }


            }

        }
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2866:1: rule__InstanceSpecification__Group__7 : rule__InstanceSpecification__Group__7__Impl rule__InstanceSpecification__Group__8 ;
    public final void rule__InstanceSpecification__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2870:1: ( rule__InstanceSpecification__Group__7__Impl rule__InstanceSpecification__Group__8 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2871:2: rule__InstanceSpecification__Group__7__Impl rule__InstanceSpecification__Group__8
            {
            pushFollow(FOLLOW_rule__InstanceSpecification__Group__7__Impl_in_rule__InstanceSpecification__Group__75912);
            rule__InstanceSpecification__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__InstanceSpecification__Group__8_in_rule__InstanceSpecification__Group__75915);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2878:1: rule__InstanceSpecification__Group__7__Impl : ( '{' ) ;
    public final void rule__InstanceSpecification__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2882:1: ( ( '{' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2883:1: ( '{' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2883:1: ( '{' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2884:1: '{'
            {
             before(grammarAccess.getInstanceSpecificationAccess().getLeftCurlyBracketKeyword_7()); 
            match(input,36,FOLLOW_36_in_rule__InstanceSpecification__Group__7__Impl5943); 
             after(grammarAccess.getInstanceSpecificationAccess().getLeftCurlyBracketKeyword_7()); 

            }


            }

        }
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2897:1: rule__InstanceSpecification__Group__8 : rule__InstanceSpecification__Group__8__Impl rule__InstanceSpecification__Group__9 ;
    public final void rule__InstanceSpecification__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2901:1: ( rule__InstanceSpecification__Group__8__Impl rule__InstanceSpecification__Group__9 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2902:2: rule__InstanceSpecification__Group__8__Impl rule__InstanceSpecification__Group__9
            {
            pushFollow(FOLLOW_rule__InstanceSpecification__Group__8__Impl_in_rule__InstanceSpecification__Group__85974);
            rule__InstanceSpecification__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__InstanceSpecification__Group__9_in_rule__InstanceSpecification__Group__85977);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2909:1: rule__InstanceSpecification__Group__8__Impl : ( ( rule__InstanceSpecification__Group_8__0 ) ) ;
    public final void rule__InstanceSpecification__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2913:1: ( ( ( rule__InstanceSpecification__Group_8__0 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2914:1: ( ( rule__InstanceSpecification__Group_8__0 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2914:1: ( ( rule__InstanceSpecification__Group_8__0 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2915:1: ( rule__InstanceSpecification__Group_8__0 )
            {
             before(grammarAccess.getInstanceSpecificationAccess().getGroup_8()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2916:1: ( rule__InstanceSpecification__Group_8__0 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2916:2: rule__InstanceSpecification__Group_8__0
            {
            pushFollow(FOLLOW_rule__InstanceSpecification__Group_8__0_in_rule__InstanceSpecification__Group__8__Impl6004);
            rule__InstanceSpecification__Group_8__0();

            state._fsp--;


            }

             after(grammarAccess.getInstanceSpecificationAccess().getGroup_8()); 

            }


            }

        }
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2926:1: rule__InstanceSpecification__Group__9 : rule__InstanceSpecification__Group__9__Impl ;
    public final void rule__InstanceSpecification__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2930:1: ( rule__InstanceSpecification__Group__9__Impl )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2931:2: rule__InstanceSpecification__Group__9__Impl
            {
            pushFollow(FOLLOW_rule__InstanceSpecification__Group__9__Impl_in_rule__InstanceSpecification__Group__96034);
            rule__InstanceSpecification__Group__9__Impl();

            state._fsp--;


            }

        }
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2937:1: rule__InstanceSpecification__Group__9__Impl : ( '}' ) ;
    public final void rule__InstanceSpecification__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2941:1: ( ( '}' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2942:1: ( '}' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2942:1: ( '}' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2943:1: '}'
            {
             before(grammarAccess.getInstanceSpecificationAccess().getRightCurlyBracketKeyword_9()); 
            match(input,37,FOLLOW_37_in_rule__InstanceSpecification__Group__9__Impl6062); 
             after(grammarAccess.getInstanceSpecificationAccess().getRightCurlyBracketKeyword_9()); 

            }


            }

        }
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


    // $ANTLR start "rule__InstanceSpecification__Group_8__0"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2976:1: rule__InstanceSpecification__Group_8__0 : rule__InstanceSpecification__Group_8__0__Impl rule__InstanceSpecification__Group_8__1 ;
    public final void rule__InstanceSpecification__Group_8__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2980:1: ( rule__InstanceSpecification__Group_8__0__Impl rule__InstanceSpecification__Group_8__1 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2981:2: rule__InstanceSpecification__Group_8__0__Impl rule__InstanceSpecification__Group_8__1
            {
            pushFollow(FOLLOW_rule__InstanceSpecification__Group_8__0__Impl_in_rule__InstanceSpecification__Group_8__06113);
            rule__InstanceSpecification__Group_8__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__InstanceSpecification__Group_8__1_in_rule__InstanceSpecification__Group_8__06116);
            rule__InstanceSpecification__Group_8__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InstanceSpecification__Group_8__0"


    // $ANTLR start "rule__InstanceSpecification__Group_8__0__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2988:1: rule__InstanceSpecification__Group_8__0__Impl : ( ( rule__InstanceSpecification__ConstraintSemanticsAssignment_8_0 ) ) ;
    public final void rule__InstanceSpecification__Group_8__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2992:1: ( ( ( rule__InstanceSpecification__ConstraintSemanticsAssignment_8_0 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2993:1: ( ( rule__InstanceSpecification__ConstraintSemanticsAssignment_8_0 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2993:1: ( ( rule__InstanceSpecification__ConstraintSemanticsAssignment_8_0 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2994:1: ( rule__InstanceSpecification__ConstraintSemanticsAssignment_8_0 )
            {
             before(grammarAccess.getInstanceSpecificationAccess().getConstraintSemanticsAssignment_8_0()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2995:1: ( rule__InstanceSpecification__ConstraintSemanticsAssignment_8_0 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:2995:2: rule__InstanceSpecification__ConstraintSemanticsAssignment_8_0
            {
            pushFollow(FOLLOW_rule__InstanceSpecification__ConstraintSemanticsAssignment_8_0_in_rule__InstanceSpecification__Group_8__0__Impl6143);
            rule__InstanceSpecification__ConstraintSemanticsAssignment_8_0();

            state._fsp--;


            }

             after(grammarAccess.getInstanceSpecificationAccess().getConstraintSemanticsAssignment_8_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InstanceSpecification__Group_8__0__Impl"


    // $ANTLR start "rule__InstanceSpecification__Group_8__1"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3005:1: rule__InstanceSpecification__Group_8__1 : rule__InstanceSpecification__Group_8__1__Impl ;
    public final void rule__InstanceSpecification__Group_8__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3009:1: ( rule__InstanceSpecification__Group_8__1__Impl )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3010:2: rule__InstanceSpecification__Group_8__1__Impl
            {
            pushFollow(FOLLOW_rule__InstanceSpecification__Group_8__1__Impl_in_rule__InstanceSpecification__Group_8__16173);
            rule__InstanceSpecification__Group_8__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InstanceSpecification__Group_8__1"


    // $ANTLR start "rule__InstanceSpecification__Group_8__1__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3016:1: rule__InstanceSpecification__Group_8__1__Impl : ( ( rule__InstanceSpecification__Group_8_1__0 )* ) ;
    public final void rule__InstanceSpecification__Group_8__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3020:1: ( ( ( rule__InstanceSpecification__Group_8_1__0 )* ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3021:1: ( ( rule__InstanceSpecification__Group_8_1__0 )* )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3021:1: ( ( rule__InstanceSpecification__Group_8_1__0 )* )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3022:1: ( rule__InstanceSpecification__Group_8_1__0 )*
            {
             before(grammarAccess.getInstanceSpecificationAccess().getGroup_8_1()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3023:1: ( rule__InstanceSpecification__Group_8_1__0 )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==29) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3023:2: rule__InstanceSpecification__Group_8_1__0
            	    {
            	    pushFollow(FOLLOW_rule__InstanceSpecification__Group_8_1__0_in_rule__InstanceSpecification__Group_8__1__Impl6200);
            	    rule__InstanceSpecification__Group_8_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

             after(grammarAccess.getInstanceSpecificationAccess().getGroup_8_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InstanceSpecification__Group_8__1__Impl"


    // $ANTLR start "rule__InstanceSpecification__Group_8_1__0"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3037:1: rule__InstanceSpecification__Group_8_1__0 : rule__InstanceSpecification__Group_8_1__0__Impl rule__InstanceSpecification__Group_8_1__1 ;
    public final void rule__InstanceSpecification__Group_8_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3041:1: ( rule__InstanceSpecification__Group_8_1__0__Impl rule__InstanceSpecification__Group_8_1__1 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3042:2: rule__InstanceSpecification__Group_8_1__0__Impl rule__InstanceSpecification__Group_8_1__1
            {
            pushFollow(FOLLOW_rule__InstanceSpecification__Group_8_1__0__Impl_in_rule__InstanceSpecification__Group_8_1__06235);
            rule__InstanceSpecification__Group_8_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__InstanceSpecification__Group_8_1__1_in_rule__InstanceSpecification__Group_8_1__06238);
            rule__InstanceSpecification__Group_8_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InstanceSpecification__Group_8_1__0"


    // $ANTLR start "rule__InstanceSpecification__Group_8_1__0__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3049:1: rule__InstanceSpecification__Group_8_1__0__Impl : ( ',' ) ;
    public final void rule__InstanceSpecification__Group_8_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3053:1: ( ( ',' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3054:1: ( ',' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3054:1: ( ',' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3055:1: ','
            {
             before(grammarAccess.getInstanceSpecificationAccess().getCommaKeyword_8_1_0()); 
            match(input,29,FOLLOW_29_in_rule__InstanceSpecification__Group_8_1__0__Impl6266); 
             after(grammarAccess.getInstanceSpecificationAccess().getCommaKeyword_8_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InstanceSpecification__Group_8_1__0__Impl"


    // $ANTLR start "rule__InstanceSpecification__Group_8_1__1"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3068:1: rule__InstanceSpecification__Group_8_1__1 : rule__InstanceSpecification__Group_8_1__1__Impl ;
    public final void rule__InstanceSpecification__Group_8_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3072:1: ( rule__InstanceSpecification__Group_8_1__1__Impl )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3073:2: rule__InstanceSpecification__Group_8_1__1__Impl
            {
            pushFollow(FOLLOW_rule__InstanceSpecification__Group_8_1__1__Impl_in_rule__InstanceSpecification__Group_8_1__16297);
            rule__InstanceSpecification__Group_8_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InstanceSpecification__Group_8_1__1"


    // $ANTLR start "rule__InstanceSpecification__Group_8_1__1__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3079:1: rule__InstanceSpecification__Group_8_1__1__Impl : ( ( rule__InstanceSpecification__ConstraintSemanticsAssignment_8_1_1 ) ) ;
    public final void rule__InstanceSpecification__Group_8_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3083:1: ( ( ( rule__InstanceSpecification__ConstraintSemanticsAssignment_8_1_1 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3084:1: ( ( rule__InstanceSpecification__ConstraintSemanticsAssignment_8_1_1 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3084:1: ( ( rule__InstanceSpecification__ConstraintSemanticsAssignment_8_1_1 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3085:1: ( rule__InstanceSpecification__ConstraintSemanticsAssignment_8_1_1 )
            {
             before(grammarAccess.getInstanceSpecificationAccess().getConstraintSemanticsAssignment_8_1_1()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3086:1: ( rule__InstanceSpecification__ConstraintSemanticsAssignment_8_1_1 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3086:2: rule__InstanceSpecification__ConstraintSemanticsAssignment_8_1_1
            {
            pushFollow(FOLLOW_rule__InstanceSpecification__ConstraintSemanticsAssignment_8_1_1_in_rule__InstanceSpecification__Group_8_1__1__Impl6324);
            rule__InstanceSpecification__ConstraintSemanticsAssignment_8_1_1();

            state._fsp--;


            }

             after(grammarAccess.getInstanceSpecificationAccess().getConstraintSemanticsAssignment_8_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InstanceSpecification__Group_8_1__1__Impl"


    // $ANTLR start "rule__ConstraintSemantic__Group__0"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3100:1: rule__ConstraintSemantic__Group__0 : rule__ConstraintSemantic__Group__0__Impl rule__ConstraintSemantic__Group__1 ;
    public final void rule__ConstraintSemantic__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3104:1: ( rule__ConstraintSemantic__Group__0__Impl rule__ConstraintSemantic__Group__1 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3105:2: rule__ConstraintSemantic__Group__0__Impl rule__ConstraintSemantic__Group__1
            {
            pushFollow(FOLLOW_rule__ConstraintSemantic__Group__0__Impl_in_rule__ConstraintSemantic__Group__06358);
            rule__ConstraintSemantic__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ConstraintSemantic__Group__1_in_rule__ConstraintSemantic__Group__06361);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3112:1: rule__ConstraintSemantic__Group__0__Impl : ( ( rule__ConstraintSemantic__IdAssignment_0 ) ) ;
    public final void rule__ConstraintSemantic__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3116:1: ( ( ( rule__ConstraintSemantic__IdAssignment_0 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3117:1: ( ( rule__ConstraintSemantic__IdAssignment_0 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3117:1: ( ( rule__ConstraintSemantic__IdAssignment_0 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3118:1: ( rule__ConstraintSemantic__IdAssignment_0 )
            {
             before(grammarAccess.getConstraintSemanticAccess().getIdAssignment_0()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3119:1: ( rule__ConstraintSemantic__IdAssignment_0 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3119:2: rule__ConstraintSemantic__IdAssignment_0
            {
            pushFollow(FOLLOW_rule__ConstraintSemantic__IdAssignment_0_in_rule__ConstraintSemantic__Group__0__Impl6388);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3129:1: rule__ConstraintSemantic__Group__1 : rule__ConstraintSemantic__Group__1__Impl rule__ConstraintSemantic__Group__2 ;
    public final void rule__ConstraintSemantic__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3133:1: ( rule__ConstraintSemantic__Group__1__Impl rule__ConstraintSemantic__Group__2 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3134:2: rule__ConstraintSemantic__Group__1__Impl rule__ConstraintSemantic__Group__2
            {
            pushFollow(FOLLOW_rule__ConstraintSemantic__Group__1__Impl_in_rule__ConstraintSemantic__Group__16418);
            rule__ConstraintSemantic__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ConstraintSemantic__Group__2_in_rule__ConstraintSemantic__Group__16421);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3141:1: rule__ConstraintSemantic__Group__1__Impl : ( '{' ) ;
    public final void rule__ConstraintSemantic__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3145:1: ( ( '{' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3146:1: ( '{' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3146:1: ( '{' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3147:1: '{'
            {
             before(grammarAccess.getConstraintSemanticAccess().getLeftCurlyBracketKeyword_1()); 
            match(input,36,FOLLOW_36_in_rule__ConstraintSemantic__Group__1__Impl6449); 
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3160:1: rule__ConstraintSemantic__Group__2 : rule__ConstraintSemantic__Group__2__Impl rule__ConstraintSemantic__Group__3 ;
    public final void rule__ConstraintSemantic__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3164:1: ( rule__ConstraintSemantic__Group__2__Impl rule__ConstraintSemantic__Group__3 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3165:2: rule__ConstraintSemantic__Group__2__Impl rule__ConstraintSemantic__Group__3
            {
            pushFollow(FOLLOW_rule__ConstraintSemantic__Group__2__Impl_in_rule__ConstraintSemantic__Group__26480);
            rule__ConstraintSemantic__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ConstraintSemantic__Group__3_in_rule__ConstraintSemantic__Group__26483);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3172:1: rule__ConstraintSemantic__Group__2__Impl : ( ( rule__ConstraintSemantic__Group_2__0 ) ) ;
    public final void rule__ConstraintSemantic__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3176:1: ( ( ( rule__ConstraintSemantic__Group_2__0 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3177:1: ( ( rule__ConstraintSemantic__Group_2__0 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3177:1: ( ( rule__ConstraintSemantic__Group_2__0 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3178:1: ( rule__ConstraintSemantic__Group_2__0 )
            {
             before(grammarAccess.getConstraintSemanticAccess().getGroup_2()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3179:1: ( rule__ConstraintSemantic__Group_2__0 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3179:2: rule__ConstraintSemantic__Group_2__0
            {
            pushFollow(FOLLOW_rule__ConstraintSemantic__Group_2__0_in_rule__ConstraintSemantic__Group__2__Impl6510);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3189:1: rule__ConstraintSemantic__Group__3 : rule__ConstraintSemantic__Group__3__Impl rule__ConstraintSemantic__Group__4 ;
    public final void rule__ConstraintSemantic__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3193:1: ( rule__ConstraintSemantic__Group__3__Impl rule__ConstraintSemantic__Group__4 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3194:2: rule__ConstraintSemantic__Group__3__Impl rule__ConstraintSemantic__Group__4
            {
            pushFollow(FOLLOW_rule__ConstraintSemantic__Group__3__Impl_in_rule__ConstraintSemantic__Group__36540);
            rule__ConstraintSemantic__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ConstraintSemantic__Group__4_in_rule__ConstraintSemantic__Group__36543);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3201:1: rule__ConstraintSemantic__Group__3__Impl : ( ',' ) ;
    public final void rule__ConstraintSemantic__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3205:1: ( ( ',' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3206:1: ( ',' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3206:1: ( ',' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3207:1: ','
            {
             before(grammarAccess.getConstraintSemanticAccess().getCommaKeyword_3()); 
            match(input,29,FOLLOW_29_in_rule__ConstraintSemantic__Group__3__Impl6571); 
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3220:1: rule__ConstraintSemantic__Group__4 : rule__ConstraintSemantic__Group__4__Impl rule__ConstraintSemantic__Group__5 ;
    public final void rule__ConstraintSemantic__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3224:1: ( rule__ConstraintSemantic__Group__4__Impl rule__ConstraintSemantic__Group__5 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3225:2: rule__ConstraintSemantic__Group__4__Impl rule__ConstraintSemantic__Group__5
            {
            pushFollow(FOLLOW_rule__ConstraintSemantic__Group__4__Impl_in_rule__ConstraintSemantic__Group__46602);
            rule__ConstraintSemantic__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ConstraintSemantic__Group__5_in_rule__ConstraintSemantic__Group__46605);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3232:1: rule__ConstraintSemantic__Group__4__Impl : ( '}' ) ;
    public final void rule__ConstraintSemantic__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3236:1: ( ( '}' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3237:1: ( '}' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3237:1: ( '}' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3238:1: '}'
            {
             before(grammarAccess.getConstraintSemanticAccess().getRightCurlyBracketKeyword_4()); 
            match(input,37,FOLLOW_37_in_rule__ConstraintSemantic__Group__4__Impl6633); 
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3251:1: rule__ConstraintSemantic__Group__5 : rule__ConstraintSemantic__Group__5__Impl rule__ConstraintSemantic__Group__6 ;
    public final void rule__ConstraintSemantic__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3255:1: ( rule__ConstraintSemantic__Group__5__Impl rule__ConstraintSemantic__Group__6 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3256:2: rule__ConstraintSemantic__Group__5__Impl rule__ConstraintSemantic__Group__6
            {
            pushFollow(FOLLOW_rule__ConstraintSemantic__Group__5__Impl_in_rule__ConstraintSemantic__Group__56664);
            rule__ConstraintSemantic__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ConstraintSemantic__Group__6_in_rule__ConstraintSemantic__Group__56667);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3263:1: rule__ConstraintSemantic__Group__5__Impl : ( '=' ) ;
    public final void rule__ConstraintSemantic__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3267:1: ( ( '=' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3268:1: ( '=' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3268:1: ( '=' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3269:1: '='
            {
             before(grammarAccess.getConstraintSemanticAccess().getEqualsSignKeyword_5()); 
            match(input,38,FOLLOW_38_in_rule__ConstraintSemantic__Group__5__Impl6695); 
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3282:1: rule__ConstraintSemantic__Group__6 : rule__ConstraintSemantic__Group__6__Impl ;
    public final void rule__ConstraintSemantic__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3286:1: ( rule__ConstraintSemantic__Group__6__Impl )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3287:2: rule__ConstraintSemantic__Group__6__Impl
            {
            pushFollow(FOLLOW_rule__ConstraintSemantic__Group__6__Impl_in_rule__ConstraintSemantic__Group__66726);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3293:1: rule__ConstraintSemantic__Group__6__Impl : ( ( rule__ConstraintSemantic__OclAssignment_6 ) ) ;
    public final void rule__ConstraintSemantic__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3297:1: ( ( ( rule__ConstraintSemantic__OclAssignment_6 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3298:1: ( ( rule__ConstraintSemantic__OclAssignment_6 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3298:1: ( ( rule__ConstraintSemantic__OclAssignment_6 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3299:1: ( rule__ConstraintSemantic__OclAssignment_6 )
            {
             before(grammarAccess.getConstraintSemanticAccess().getOclAssignment_6()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3300:1: ( rule__ConstraintSemantic__OclAssignment_6 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3300:2: rule__ConstraintSemantic__OclAssignment_6
            {
            pushFollow(FOLLOW_rule__ConstraintSemantic__OclAssignment_6_in_rule__ConstraintSemantic__Group__6__Impl6753);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3324:1: rule__ConstraintSemantic__Group_2__0 : rule__ConstraintSemantic__Group_2__0__Impl rule__ConstraintSemantic__Group_2__1 ;
    public final void rule__ConstraintSemantic__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3328:1: ( rule__ConstraintSemantic__Group_2__0__Impl rule__ConstraintSemantic__Group_2__1 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3329:2: rule__ConstraintSemantic__Group_2__0__Impl rule__ConstraintSemantic__Group_2__1
            {
            pushFollow(FOLLOW_rule__ConstraintSemantic__Group_2__0__Impl_in_rule__ConstraintSemantic__Group_2__06797);
            rule__ConstraintSemantic__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ConstraintSemantic__Group_2__1_in_rule__ConstraintSemantic__Group_2__06800);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3336:1: rule__ConstraintSemantic__Group_2__0__Impl : ( ( rule__ConstraintSemantic__ArrowsAssignment_2_0 ) ) ;
    public final void rule__ConstraintSemantic__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3340:1: ( ( ( rule__ConstraintSemantic__ArrowsAssignment_2_0 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3341:1: ( ( rule__ConstraintSemantic__ArrowsAssignment_2_0 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3341:1: ( ( rule__ConstraintSemantic__ArrowsAssignment_2_0 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3342:1: ( rule__ConstraintSemantic__ArrowsAssignment_2_0 )
            {
             before(grammarAccess.getConstraintSemanticAccess().getArrowsAssignment_2_0()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3343:1: ( rule__ConstraintSemantic__ArrowsAssignment_2_0 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3343:2: rule__ConstraintSemantic__ArrowsAssignment_2_0
            {
            pushFollow(FOLLOW_rule__ConstraintSemantic__ArrowsAssignment_2_0_in_rule__ConstraintSemantic__Group_2__0__Impl6827);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3353:1: rule__ConstraintSemantic__Group_2__1 : rule__ConstraintSemantic__Group_2__1__Impl ;
    public final void rule__ConstraintSemantic__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3357:1: ( rule__ConstraintSemantic__Group_2__1__Impl )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3358:2: rule__ConstraintSemantic__Group_2__1__Impl
            {
            pushFollow(FOLLOW_rule__ConstraintSemantic__Group_2__1__Impl_in_rule__ConstraintSemantic__Group_2__16857);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3364:1: rule__ConstraintSemantic__Group_2__1__Impl : ( ( rule__ConstraintSemantic__Group_2_1__0 )* ) ;
    public final void rule__ConstraintSemantic__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3368:1: ( ( ( rule__ConstraintSemantic__Group_2_1__0 )* ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3369:1: ( ( rule__ConstraintSemantic__Group_2_1__0 )* )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3369:1: ( ( rule__ConstraintSemantic__Group_2_1__0 )* )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3370:1: ( rule__ConstraintSemantic__Group_2_1__0 )*
            {
             before(grammarAccess.getConstraintSemanticAccess().getGroup_2_1()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3371:1: ( rule__ConstraintSemantic__Group_2_1__0 )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==29) ) {
                    int LA11_1 = input.LA(2);

                    if ( (LA11_1==RULE_ID) ) {
                        alt11=1;
                    }


                }


                switch (alt11) {
            	case 1 :
            	    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3371:2: rule__ConstraintSemantic__Group_2_1__0
            	    {
            	    pushFollow(FOLLOW_rule__ConstraintSemantic__Group_2_1__0_in_rule__ConstraintSemantic__Group_2__1__Impl6884);
            	    rule__ConstraintSemantic__Group_2_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop11;
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3385:1: rule__ConstraintSemantic__Group_2_1__0 : rule__ConstraintSemantic__Group_2_1__0__Impl rule__ConstraintSemantic__Group_2_1__1 ;
    public final void rule__ConstraintSemantic__Group_2_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3389:1: ( rule__ConstraintSemantic__Group_2_1__0__Impl rule__ConstraintSemantic__Group_2_1__1 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3390:2: rule__ConstraintSemantic__Group_2_1__0__Impl rule__ConstraintSemantic__Group_2_1__1
            {
            pushFollow(FOLLOW_rule__ConstraintSemantic__Group_2_1__0__Impl_in_rule__ConstraintSemantic__Group_2_1__06919);
            rule__ConstraintSemantic__Group_2_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ConstraintSemantic__Group_2_1__1_in_rule__ConstraintSemantic__Group_2_1__06922);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3397:1: rule__ConstraintSemantic__Group_2_1__0__Impl : ( ',' ) ;
    public final void rule__ConstraintSemantic__Group_2_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3401:1: ( ( ',' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3402:1: ( ',' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3402:1: ( ',' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3403:1: ','
            {
             before(grammarAccess.getConstraintSemanticAccess().getCommaKeyword_2_1_0()); 
            match(input,29,FOLLOW_29_in_rule__ConstraintSemantic__Group_2_1__0__Impl6950); 
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3416:1: rule__ConstraintSemantic__Group_2_1__1 : rule__ConstraintSemantic__Group_2_1__1__Impl ;
    public final void rule__ConstraintSemantic__Group_2_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3420:1: ( rule__ConstraintSemantic__Group_2_1__1__Impl )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3421:2: rule__ConstraintSemantic__Group_2_1__1__Impl
            {
            pushFollow(FOLLOW_rule__ConstraintSemantic__Group_2_1__1__Impl_in_rule__ConstraintSemantic__Group_2_1__16981);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3427:1: rule__ConstraintSemantic__Group_2_1__1__Impl : ( ( rule__ConstraintSemantic__ArrowsAssignment_2_1_1 ) ) ;
    public final void rule__ConstraintSemantic__Group_2_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3431:1: ( ( ( rule__ConstraintSemantic__ArrowsAssignment_2_1_1 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3432:1: ( ( rule__ConstraintSemantic__ArrowsAssignment_2_1_1 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3432:1: ( ( rule__ConstraintSemantic__ArrowsAssignment_2_1_1 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3433:1: ( rule__ConstraintSemantic__ArrowsAssignment_2_1_1 )
            {
             before(grammarAccess.getConstraintSemanticAccess().getArrowsAssignment_2_1_1()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3434:1: ( rule__ConstraintSemantic__ArrowsAssignment_2_1_1 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3434:2: rule__ConstraintSemantic__ArrowsAssignment_2_1_1
            {
            pushFollow(FOLLOW_rule__ConstraintSemantic__ArrowsAssignment_2_1_1_in_rule__ConstraintSemantic__Group_2_1__1__Impl7008);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3448:1: rule__Specification__Group__0 : rule__Specification__Group__0__Impl rule__Specification__Group__1 ;
    public final void rule__Specification__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3452:1: ( rule__Specification__Group__0__Impl rule__Specification__Group__1 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3453:2: rule__Specification__Group__0__Impl rule__Specification__Group__1
            {
            pushFollow(FOLLOW_rule__Specification__Group__0__Impl_in_rule__Specification__Group__07042);
            rule__Specification__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Specification__Group__1_in_rule__Specification__Group__07045);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3460:1: rule__Specification__Group__0__Impl : ( ( rule__Specification__IdAssignment_0 ) ) ;
    public final void rule__Specification__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3464:1: ( ( ( rule__Specification__IdAssignment_0 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3465:1: ( ( rule__Specification__IdAssignment_0 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3465:1: ( ( rule__Specification__IdAssignment_0 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3466:1: ( rule__Specification__IdAssignment_0 )
            {
             before(grammarAccess.getSpecificationAccess().getIdAssignment_0()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3467:1: ( rule__Specification__IdAssignment_0 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3467:2: rule__Specification__IdAssignment_0
            {
            pushFollow(FOLLOW_rule__Specification__IdAssignment_0_in_rule__Specification__Group__0__Impl7072);
            rule__Specification__IdAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getSpecificationAccess().getIdAssignment_0()); 

            }


            }

        }
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3477:1: rule__Specification__Group__1 : rule__Specification__Group__1__Impl rule__Specification__Group__2 ;
    public final void rule__Specification__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3481:1: ( rule__Specification__Group__1__Impl rule__Specification__Group__2 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3482:2: rule__Specification__Group__1__Impl rule__Specification__Group__2
            {
            pushFollow(FOLLOW_rule__Specification__Group__1__Impl_in_rule__Specification__Group__17102);
            rule__Specification__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Specification__Group__2_in_rule__Specification__Group__17105);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3489:1: rule__Specification__Group__1__Impl : ( ':=' ) ;
    public final void rule__Specification__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3493:1: ( ( ':=' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3494:1: ( ':=' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3494:1: ( ':=' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3495:1: ':='
            {
             before(grammarAccess.getSpecificationAccess().getColonEqualsSignKeyword_1()); 
            match(input,33,FOLLOW_33_in_rule__Specification__Group__1__Impl7133); 
             after(grammarAccess.getSpecificationAccess().getColonEqualsSignKeyword_1()); 

            }


            }

        }
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3508:1: rule__Specification__Group__2 : rule__Specification__Group__2__Impl rule__Specification__Group__3 ;
    public final void rule__Specification__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3512:1: ( rule__Specification__Group__2__Impl rule__Specification__Group__3 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3513:2: rule__Specification__Group__2__Impl rule__Specification__Group__3
            {
            pushFollow(FOLLOW_rule__Specification__Group__2__Impl_in_rule__Specification__Group__27164);
            rule__Specification__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Specification__Group__3_in_rule__Specification__Group__27167);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3520:1: rule__Specification__Group__2__Impl : ( 'Spec<' ) ;
    public final void rule__Specification__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3524:1: ( ( 'Spec<' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3525:1: ( 'Spec<' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3525:1: ( 'Spec<' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3526:1: 'Spec<'
            {
             before(grammarAccess.getSpecificationAccess().getSpecKeyword_2()); 
            match(input,39,FOLLOW_39_in_rule__Specification__Group__2__Impl7195); 
             after(grammarAccess.getSpecificationAccess().getSpecKeyword_2()); 

            }


            }

        }
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3539:1: rule__Specification__Group__3 : rule__Specification__Group__3__Impl rule__Specification__Group__4 ;
    public final void rule__Specification__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3543:1: ( rule__Specification__Group__3__Impl rule__Specification__Group__4 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3544:2: rule__Specification__Group__3__Impl rule__Specification__Group__4
            {
            pushFollow(FOLLOW_rule__Specification__Group__3__Impl_in_rule__Specification__Group__37226);
            rule__Specification__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Specification__Group__4_in_rule__Specification__Group__37229);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3551:1: rule__Specification__Group__3__Impl : ( ( rule__Specification__GraphAssignment_3 ) ) ;
    public final void rule__Specification__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3555:1: ( ( ( rule__Specification__GraphAssignment_3 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3556:1: ( ( rule__Specification__GraphAssignment_3 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3556:1: ( ( rule__Specification__GraphAssignment_3 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3557:1: ( rule__Specification__GraphAssignment_3 )
            {
             before(grammarAccess.getSpecificationAccess().getGraphAssignment_3()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3558:1: ( rule__Specification__GraphAssignment_3 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3558:2: rule__Specification__GraphAssignment_3
            {
            pushFollow(FOLLOW_rule__Specification__GraphAssignment_3_in_rule__Specification__Group__3__Impl7256);
            rule__Specification__GraphAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getSpecificationAccess().getGraphAssignment_3()); 

            }


            }

        }
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3568:1: rule__Specification__Group__4 : rule__Specification__Group__4__Impl rule__Specification__Group__5 ;
    public final void rule__Specification__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3572:1: ( rule__Specification__Group__4__Impl rule__Specification__Group__5 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3573:2: rule__Specification__Group__4__Impl rule__Specification__Group__5
            {
            pushFollow(FOLLOW_rule__Specification__Group__4__Impl_in_rule__Specification__Group__47286);
            rule__Specification__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Specification__Group__5_in_rule__Specification__Group__47289);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3580:1: rule__Specification__Group__4__Impl : ( '>' ) ;
    public final void rule__Specification__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3584:1: ( ( '>' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3585:1: ( '>' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3585:1: ( '>' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3586:1: '>'
            {
             before(grammarAccess.getSpecificationAccess().getGreaterThanSignKeyword_4()); 
            match(input,35,FOLLOW_35_in_rule__Specification__Group__4__Impl7317); 
             after(grammarAccess.getSpecificationAccess().getGreaterThanSignKeyword_4()); 

            }


            }

        }
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3599:1: rule__Specification__Group__5 : rule__Specification__Group__5__Impl rule__Specification__Group__6 ;
    public final void rule__Specification__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3603:1: ( rule__Specification__Group__5__Impl rule__Specification__Group__6 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3604:2: rule__Specification__Group__5__Impl rule__Specification__Group__6
            {
            pushFollow(FOLLOW_rule__Specification__Group__5__Impl_in_rule__Specification__Group__57348);
            rule__Specification__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Specification__Group__6_in_rule__Specification__Group__57351);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3611:1: rule__Specification__Group__5__Impl : ( '{' ) ;
    public final void rule__Specification__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3615:1: ( ( '{' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3616:1: ( '{' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3616:1: ( '{' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3617:1: '{'
            {
             before(grammarAccess.getSpecificationAccess().getLeftCurlyBracketKeyword_5()); 
            match(input,36,FOLLOW_36_in_rule__Specification__Group__5__Impl7379); 
             after(grammarAccess.getSpecificationAccess().getLeftCurlyBracketKeyword_5()); 

            }


            }

        }
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3630:1: rule__Specification__Group__6 : rule__Specification__Group__6__Impl rule__Specification__Group__7 ;
    public final void rule__Specification__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3634:1: ( rule__Specification__Group__6__Impl rule__Specification__Group__7 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3635:2: rule__Specification__Group__6__Impl rule__Specification__Group__7
            {
            pushFollow(FOLLOW_rule__Specification__Group__6__Impl_in_rule__Specification__Group__67410);
            rule__Specification__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Specification__Group__7_in_rule__Specification__Group__67413);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3642:1: rule__Specification__Group__6__Impl : ( ( rule__Specification__Group_6__0 )? ) ;
    public final void rule__Specification__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3646:1: ( ( ( rule__Specification__Group_6__0 )? ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3647:1: ( ( rule__Specification__Group_6__0 )? )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3647:1: ( ( rule__Specification__Group_6__0 )? )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3648:1: ( rule__Specification__Group_6__0 )?
            {
             before(grammarAccess.getSpecificationAccess().getGroup_6()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3649:1: ( rule__Specification__Group_6__0 )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==RULE_ID) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3649:2: rule__Specification__Group_6__0
                    {
                    pushFollow(FOLLOW_rule__Specification__Group_6__0_in_rule__Specification__Group__6__Impl7440);
                    rule__Specification__Group_6__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getSpecificationAccess().getGroup_6()); 

            }


            }

        }
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3659:1: rule__Specification__Group__7 : rule__Specification__Group__7__Impl ;
    public final void rule__Specification__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3663:1: ( rule__Specification__Group__7__Impl )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3664:2: rule__Specification__Group__7__Impl
            {
            pushFollow(FOLLOW_rule__Specification__Group__7__Impl_in_rule__Specification__Group__77471);
            rule__Specification__Group__7__Impl();

            state._fsp--;


            }

        }
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3670:1: rule__Specification__Group__7__Impl : ( '}' ) ;
    public final void rule__Specification__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3674:1: ( ( '}' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3675:1: ( '}' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3675:1: ( '}' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3676:1: '}'
            {
             before(grammarAccess.getSpecificationAccess().getRightCurlyBracketKeyword_7()); 
            match(input,37,FOLLOW_37_in_rule__Specification__Group__7__Impl7499); 
             after(grammarAccess.getSpecificationAccess().getRightCurlyBracketKeyword_7()); 

            }


            }

        }
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


    // $ANTLR start "rule__Specification__Group_6__0"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3705:1: rule__Specification__Group_6__0 : rule__Specification__Group_6__0__Impl rule__Specification__Group_6__1 ;
    public final void rule__Specification__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3709:1: ( rule__Specification__Group_6__0__Impl rule__Specification__Group_6__1 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3710:2: rule__Specification__Group_6__0__Impl rule__Specification__Group_6__1
            {
            pushFollow(FOLLOW_rule__Specification__Group_6__0__Impl_in_rule__Specification__Group_6__07546);
            rule__Specification__Group_6__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Specification__Group_6__1_in_rule__Specification__Group_6__07549);
            rule__Specification__Group_6__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Specification__Group_6__0"


    // $ANTLR start "rule__Specification__Group_6__0__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3717:1: rule__Specification__Group_6__0__Impl : ( ( rule__Specification__ConstraintsAssignment_6_0 ) ) ;
    public final void rule__Specification__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3721:1: ( ( ( rule__Specification__ConstraintsAssignment_6_0 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3722:1: ( ( rule__Specification__ConstraintsAssignment_6_0 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3722:1: ( ( rule__Specification__ConstraintsAssignment_6_0 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3723:1: ( rule__Specification__ConstraintsAssignment_6_0 )
            {
             before(grammarAccess.getSpecificationAccess().getConstraintsAssignment_6_0()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3724:1: ( rule__Specification__ConstraintsAssignment_6_0 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3724:2: rule__Specification__ConstraintsAssignment_6_0
            {
            pushFollow(FOLLOW_rule__Specification__ConstraintsAssignment_6_0_in_rule__Specification__Group_6__0__Impl7576);
            rule__Specification__ConstraintsAssignment_6_0();

            state._fsp--;


            }

             after(grammarAccess.getSpecificationAccess().getConstraintsAssignment_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Specification__Group_6__0__Impl"


    // $ANTLR start "rule__Specification__Group_6__1"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3734:1: rule__Specification__Group_6__1 : rule__Specification__Group_6__1__Impl ;
    public final void rule__Specification__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3738:1: ( rule__Specification__Group_6__1__Impl )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3739:2: rule__Specification__Group_6__1__Impl
            {
            pushFollow(FOLLOW_rule__Specification__Group_6__1__Impl_in_rule__Specification__Group_6__17606);
            rule__Specification__Group_6__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Specification__Group_6__1"


    // $ANTLR start "rule__Specification__Group_6__1__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3745:1: rule__Specification__Group_6__1__Impl : ( ( rule__Specification__Group_6_1__0 )* ) ;
    public final void rule__Specification__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3749:1: ( ( ( rule__Specification__Group_6_1__0 )* ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3750:1: ( ( rule__Specification__Group_6_1__0 )* )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3750:1: ( ( rule__Specification__Group_6_1__0 )* )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3751:1: ( rule__Specification__Group_6_1__0 )*
            {
             before(grammarAccess.getSpecificationAccess().getGroup_6_1()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3752:1: ( rule__Specification__Group_6_1__0 )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==29) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3752:2: rule__Specification__Group_6_1__0
            	    {
            	    pushFollow(FOLLOW_rule__Specification__Group_6_1__0_in_rule__Specification__Group_6__1__Impl7633);
            	    rule__Specification__Group_6_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);

             after(grammarAccess.getSpecificationAccess().getGroup_6_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Specification__Group_6__1__Impl"


    // $ANTLR start "rule__Specification__Group_6_1__0"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3766:1: rule__Specification__Group_6_1__0 : rule__Specification__Group_6_1__0__Impl rule__Specification__Group_6_1__1 ;
    public final void rule__Specification__Group_6_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3770:1: ( rule__Specification__Group_6_1__0__Impl rule__Specification__Group_6_1__1 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3771:2: rule__Specification__Group_6_1__0__Impl rule__Specification__Group_6_1__1
            {
            pushFollow(FOLLOW_rule__Specification__Group_6_1__0__Impl_in_rule__Specification__Group_6_1__07668);
            rule__Specification__Group_6_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Specification__Group_6_1__1_in_rule__Specification__Group_6_1__07671);
            rule__Specification__Group_6_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Specification__Group_6_1__0"


    // $ANTLR start "rule__Specification__Group_6_1__0__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3778:1: rule__Specification__Group_6_1__0__Impl : ( ',' ) ;
    public final void rule__Specification__Group_6_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3782:1: ( ( ',' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3783:1: ( ',' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3783:1: ( ',' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3784:1: ','
            {
             before(grammarAccess.getSpecificationAccess().getCommaKeyword_6_1_0()); 
            match(input,29,FOLLOW_29_in_rule__Specification__Group_6_1__0__Impl7699); 
             after(grammarAccess.getSpecificationAccess().getCommaKeyword_6_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Specification__Group_6_1__0__Impl"


    // $ANTLR start "rule__Specification__Group_6_1__1"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3797:1: rule__Specification__Group_6_1__1 : rule__Specification__Group_6_1__1__Impl ;
    public final void rule__Specification__Group_6_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3801:1: ( rule__Specification__Group_6_1__1__Impl )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3802:2: rule__Specification__Group_6_1__1__Impl
            {
            pushFollow(FOLLOW_rule__Specification__Group_6_1__1__Impl_in_rule__Specification__Group_6_1__17730);
            rule__Specification__Group_6_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Specification__Group_6_1__1"


    // $ANTLR start "rule__Specification__Group_6_1__1__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3808:1: rule__Specification__Group_6_1__1__Impl : ( ( rule__Specification__ConstraintsAssignment_6_1_1 ) ) ;
    public final void rule__Specification__Group_6_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3812:1: ( ( ( rule__Specification__ConstraintsAssignment_6_1_1 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3813:1: ( ( rule__Specification__ConstraintsAssignment_6_1_1 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3813:1: ( ( rule__Specification__ConstraintsAssignment_6_1_1 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3814:1: ( rule__Specification__ConstraintsAssignment_6_1_1 )
            {
             before(grammarAccess.getSpecificationAccess().getConstraintsAssignment_6_1_1()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3815:1: ( rule__Specification__ConstraintsAssignment_6_1_1 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3815:2: rule__Specification__ConstraintsAssignment_6_1_1
            {
            pushFollow(FOLLOW_rule__Specification__ConstraintsAssignment_6_1_1_in_rule__Specification__Group_6_1__1__Impl7757);
            rule__Specification__ConstraintsAssignment_6_1_1();

            state._fsp--;


            }

             after(grammarAccess.getSpecificationAccess().getConstraintsAssignment_6_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Specification__Group_6_1__1__Impl"


    // $ANTLR start "rule__Constraint__Group__0"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3829:1: rule__Constraint__Group__0 : rule__Constraint__Group__0__Impl rule__Constraint__Group__1 ;
    public final void rule__Constraint__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3833:1: ( rule__Constraint__Group__0__Impl rule__Constraint__Group__1 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3834:2: rule__Constraint__Group__0__Impl rule__Constraint__Group__1
            {
            pushFollow(FOLLOW_rule__Constraint__Group__0__Impl_in_rule__Constraint__Group__07791);
            rule__Constraint__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Constraint__Group__1_in_rule__Constraint__Group__07794);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3841:1: rule__Constraint__Group__0__Impl : ( ( rule__Constraint__SignatureAssignment_0 ) ) ;
    public final void rule__Constraint__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3845:1: ( ( ( rule__Constraint__SignatureAssignment_0 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3846:1: ( ( rule__Constraint__SignatureAssignment_0 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3846:1: ( ( rule__Constraint__SignatureAssignment_0 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3847:1: ( rule__Constraint__SignatureAssignment_0 )
            {
             before(grammarAccess.getConstraintAccess().getSignatureAssignment_0()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3848:1: ( rule__Constraint__SignatureAssignment_0 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3848:2: rule__Constraint__SignatureAssignment_0
            {
            pushFollow(FOLLOW_rule__Constraint__SignatureAssignment_0_in_rule__Constraint__Group__0__Impl7821);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3858:1: rule__Constraint__Group__1 : rule__Constraint__Group__1__Impl rule__Constraint__Group__2 ;
    public final void rule__Constraint__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3862:1: ( rule__Constraint__Group__1__Impl rule__Constraint__Group__2 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3863:2: rule__Constraint__Group__1__Impl rule__Constraint__Group__2
            {
            pushFollow(FOLLOW_rule__Constraint__Group__1__Impl_in_rule__Constraint__Group__17851);
            rule__Constraint__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Constraint__Group__2_in_rule__Constraint__Group__17854);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3870:1: rule__Constraint__Group__1__Impl : ( '{' ) ;
    public final void rule__Constraint__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3874:1: ( ( '{' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3875:1: ( '{' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3875:1: ( '{' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3876:1: '{'
            {
             before(grammarAccess.getConstraintAccess().getLeftCurlyBracketKeyword_1()); 
            match(input,36,FOLLOW_36_in_rule__Constraint__Group__1__Impl7882); 
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3889:1: rule__Constraint__Group__2 : rule__Constraint__Group__2__Impl rule__Constraint__Group__3 ;
    public final void rule__Constraint__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3893:1: ( rule__Constraint__Group__2__Impl rule__Constraint__Group__3 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3894:2: rule__Constraint__Group__2__Impl rule__Constraint__Group__3
            {
            pushFollow(FOLLOW_rule__Constraint__Group__2__Impl_in_rule__Constraint__Group__27913);
            rule__Constraint__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Constraint__Group__3_in_rule__Constraint__Group__27916);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3901:1: rule__Constraint__Group__2__Impl : ( ( rule__Constraint__Group_2__0 ) ) ;
    public final void rule__Constraint__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3905:1: ( ( ( rule__Constraint__Group_2__0 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3906:1: ( ( rule__Constraint__Group_2__0 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3906:1: ( ( rule__Constraint__Group_2__0 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3907:1: ( rule__Constraint__Group_2__0 )
            {
             before(grammarAccess.getConstraintAccess().getGroup_2()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3908:1: ( rule__Constraint__Group_2__0 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3908:2: rule__Constraint__Group_2__0
            {
            pushFollow(FOLLOW_rule__Constraint__Group_2__0_in_rule__Constraint__Group__2__Impl7943);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3918:1: rule__Constraint__Group__3 : rule__Constraint__Group__3__Impl ;
    public final void rule__Constraint__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3922:1: ( rule__Constraint__Group__3__Impl )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3923:2: rule__Constraint__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__Constraint__Group__3__Impl_in_rule__Constraint__Group__37973);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3929:1: rule__Constraint__Group__3__Impl : ( '}' ) ;
    public final void rule__Constraint__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3933:1: ( ( '}' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3934:1: ( '}' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3934:1: ( '}' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3935:1: '}'
            {
             before(grammarAccess.getConstraintAccess().getRightCurlyBracketKeyword_3()); 
            match(input,37,FOLLOW_37_in_rule__Constraint__Group__3__Impl8001); 
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3956:1: rule__Constraint__Group_2__0 : rule__Constraint__Group_2__0__Impl rule__Constraint__Group_2__1 ;
    public final void rule__Constraint__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3960:1: ( rule__Constraint__Group_2__0__Impl rule__Constraint__Group_2__1 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3961:2: rule__Constraint__Group_2__0__Impl rule__Constraint__Group_2__1
            {
            pushFollow(FOLLOW_rule__Constraint__Group_2__0__Impl_in_rule__Constraint__Group_2__08040);
            rule__Constraint__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Constraint__Group_2__1_in_rule__Constraint__Group_2__08043);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3968:1: rule__Constraint__Group_2__0__Impl : ( ( rule__Constraint__ArrowsAssignment_2_0 ) ) ;
    public final void rule__Constraint__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3972:1: ( ( ( rule__Constraint__ArrowsAssignment_2_0 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3973:1: ( ( rule__Constraint__ArrowsAssignment_2_0 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3973:1: ( ( rule__Constraint__ArrowsAssignment_2_0 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3974:1: ( rule__Constraint__ArrowsAssignment_2_0 )
            {
             before(grammarAccess.getConstraintAccess().getArrowsAssignment_2_0()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3975:1: ( rule__Constraint__ArrowsAssignment_2_0 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3975:2: rule__Constraint__ArrowsAssignment_2_0
            {
            pushFollow(FOLLOW_rule__Constraint__ArrowsAssignment_2_0_in_rule__Constraint__Group_2__0__Impl8070);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3985:1: rule__Constraint__Group_2__1 : rule__Constraint__Group_2__1__Impl ;
    public final void rule__Constraint__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3989:1: ( rule__Constraint__Group_2__1__Impl )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3990:2: rule__Constraint__Group_2__1__Impl
            {
            pushFollow(FOLLOW_rule__Constraint__Group_2__1__Impl_in_rule__Constraint__Group_2__18100);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:3996:1: rule__Constraint__Group_2__1__Impl : ( ( rule__Constraint__Group_2_1__0 )* ) ;
    public final void rule__Constraint__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4000:1: ( ( ( rule__Constraint__Group_2_1__0 )* ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4001:1: ( ( rule__Constraint__Group_2_1__0 )* )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4001:1: ( ( rule__Constraint__Group_2_1__0 )* )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4002:1: ( rule__Constraint__Group_2_1__0 )*
            {
             before(grammarAccess.getConstraintAccess().getGroup_2_1()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4003:1: ( rule__Constraint__Group_2_1__0 )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==29) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4003:2: rule__Constraint__Group_2_1__0
            	    {
            	    pushFollow(FOLLOW_rule__Constraint__Group_2_1__0_in_rule__Constraint__Group_2__1__Impl8127);
            	    rule__Constraint__Group_2_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop14;
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4017:1: rule__Constraint__Group_2_1__0 : rule__Constraint__Group_2_1__0__Impl rule__Constraint__Group_2_1__1 ;
    public final void rule__Constraint__Group_2_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4021:1: ( rule__Constraint__Group_2_1__0__Impl rule__Constraint__Group_2_1__1 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4022:2: rule__Constraint__Group_2_1__0__Impl rule__Constraint__Group_2_1__1
            {
            pushFollow(FOLLOW_rule__Constraint__Group_2_1__0__Impl_in_rule__Constraint__Group_2_1__08162);
            rule__Constraint__Group_2_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Constraint__Group_2_1__1_in_rule__Constraint__Group_2_1__08165);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4029:1: rule__Constraint__Group_2_1__0__Impl : ( ',' ) ;
    public final void rule__Constraint__Group_2_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4033:1: ( ( ',' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4034:1: ( ',' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4034:1: ( ',' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4035:1: ','
            {
             before(grammarAccess.getConstraintAccess().getCommaKeyword_2_1_0()); 
            match(input,29,FOLLOW_29_in_rule__Constraint__Group_2_1__0__Impl8193); 
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4048:1: rule__Constraint__Group_2_1__1 : rule__Constraint__Group_2_1__1__Impl ;
    public final void rule__Constraint__Group_2_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4052:1: ( rule__Constraint__Group_2_1__1__Impl )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4053:2: rule__Constraint__Group_2_1__1__Impl
            {
            pushFollow(FOLLOW_rule__Constraint__Group_2_1__1__Impl_in_rule__Constraint__Group_2_1__18224);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4059:1: rule__Constraint__Group_2_1__1__Impl : ( ( rule__Constraint__ArrowsAssignment_2_1_1 ) ) ;
    public final void rule__Constraint__Group_2_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4063:1: ( ( ( rule__Constraint__ArrowsAssignment_2_1_1 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4064:1: ( ( rule__Constraint__ArrowsAssignment_2_1_1 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4064:1: ( ( rule__Constraint__ArrowsAssignment_2_1_1 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4065:1: ( rule__Constraint__ArrowsAssignment_2_1_1 )
            {
             before(grammarAccess.getConstraintAccess().getArrowsAssignment_2_1_1()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4066:1: ( rule__Constraint__ArrowsAssignment_2_1_1 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4066:2: rule__Constraint__ArrowsAssignment_2_1_1
            {
            pushFollow(FOLLOW_rule__Constraint__ArrowsAssignment_2_1_1_in_rule__Constraint__Group_2_1__1__Impl8251);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4080:1: rule__ConstraintSignature__Group__0 : rule__ConstraintSignature__Group__0__Impl rule__ConstraintSignature__Group__1 ;
    public final void rule__ConstraintSignature__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4084:1: ( rule__ConstraintSignature__Group__0__Impl rule__ConstraintSignature__Group__1 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4085:2: rule__ConstraintSignature__Group__0__Impl rule__ConstraintSignature__Group__1
            {
            pushFollow(FOLLOW_rule__ConstraintSignature__Group__0__Impl_in_rule__ConstraintSignature__Group__08285);
            rule__ConstraintSignature__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ConstraintSignature__Group__1_in_rule__ConstraintSignature__Group__08288);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4092:1: rule__ConstraintSignature__Group__0__Impl : ( ( rule__ConstraintSignature__IdAssignment_0 ) ) ;
    public final void rule__ConstraintSignature__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4096:1: ( ( ( rule__ConstraintSignature__IdAssignment_0 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4097:1: ( ( rule__ConstraintSignature__IdAssignment_0 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4097:1: ( ( rule__ConstraintSignature__IdAssignment_0 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4098:1: ( rule__ConstraintSignature__IdAssignment_0 )
            {
             before(grammarAccess.getConstraintSignatureAccess().getIdAssignment_0()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4099:1: ( rule__ConstraintSignature__IdAssignment_0 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4099:2: rule__ConstraintSignature__IdAssignment_0
            {
            pushFollow(FOLLOW_rule__ConstraintSignature__IdAssignment_0_in_rule__ConstraintSignature__Group__0__Impl8315);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4109:1: rule__ConstraintSignature__Group__1 : rule__ConstraintSignature__Group__1__Impl rule__ConstraintSignature__Group__2 ;
    public final void rule__ConstraintSignature__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4113:1: ( rule__ConstraintSignature__Group__1__Impl rule__ConstraintSignature__Group__2 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4114:2: rule__ConstraintSignature__Group__1__Impl rule__ConstraintSignature__Group__2
            {
            pushFollow(FOLLOW_rule__ConstraintSignature__Group__1__Impl_in_rule__ConstraintSignature__Group__18345);
            rule__ConstraintSignature__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ConstraintSignature__Group__2_in_rule__ConstraintSignature__Group__18348);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4121:1: rule__ConstraintSignature__Group__1__Impl : ( '(' ) ;
    public final void rule__ConstraintSignature__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4125:1: ( ( '(' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4126:1: ( '(' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4126:1: ( '(' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4127:1: '('
            {
             before(grammarAccess.getConstraintSignatureAccess().getLeftParenthesisKeyword_1()); 
            match(input,40,FOLLOW_40_in_rule__ConstraintSignature__Group__1__Impl8376); 
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4140:1: rule__ConstraintSignature__Group__2 : rule__ConstraintSignature__Group__2__Impl rule__ConstraintSignature__Group__3 ;
    public final void rule__ConstraintSignature__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4144:1: ( rule__ConstraintSignature__Group__2__Impl rule__ConstraintSignature__Group__3 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4145:2: rule__ConstraintSignature__Group__2__Impl rule__ConstraintSignature__Group__3
            {
            pushFollow(FOLLOW_rule__ConstraintSignature__Group__2__Impl_in_rule__ConstraintSignature__Group__28407);
            rule__ConstraintSignature__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ConstraintSignature__Group__3_in_rule__ConstraintSignature__Group__28410);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4152:1: rule__ConstraintSignature__Group__2__Impl : ( ( rule__ConstraintSignature__Group_2__0 )? ) ;
    public final void rule__ConstraintSignature__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4156:1: ( ( ( rule__ConstraintSignature__Group_2__0 )? ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4157:1: ( ( rule__ConstraintSignature__Group_2__0 )? )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4157:1: ( ( rule__ConstraintSignature__Group_2__0 )? )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4158:1: ( rule__ConstraintSignature__Group_2__0 )?
            {
             before(grammarAccess.getConstraintSignatureAccess().getGroup_2()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4159:1: ( rule__ConstraintSignature__Group_2__0 )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==RULE_ID) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4159:2: rule__ConstraintSignature__Group_2__0
                    {
                    pushFollow(FOLLOW_rule__ConstraintSignature__Group_2__0_in_rule__ConstraintSignature__Group__2__Impl8437);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4169:1: rule__ConstraintSignature__Group__3 : rule__ConstraintSignature__Group__3__Impl ;
    public final void rule__ConstraintSignature__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4173:1: ( rule__ConstraintSignature__Group__3__Impl )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4174:2: rule__ConstraintSignature__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__ConstraintSignature__Group__3__Impl_in_rule__ConstraintSignature__Group__38468);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4180:1: rule__ConstraintSignature__Group__3__Impl : ( ')' ) ;
    public final void rule__ConstraintSignature__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4184:1: ( ( ')' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4185:1: ( ')' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4185:1: ( ')' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4186:1: ')'
            {
             before(grammarAccess.getConstraintSignatureAccess().getRightParenthesisKeyword_3()); 
            match(input,23,FOLLOW_23_in_rule__ConstraintSignature__Group__3__Impl8496); 
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4207:1: rule__ConstraintSignature__Group_2__0 : rule__ConstraintSignature__Group_2__0__Impl rule__ConstraintSignature__Group_2__1 ;
    public final void rule__ConstraintSignature__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4211:1: ( rule__ConstraintSignature__Group_2__0__Impl rule__ConstraintSignature__Group_2__1 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4212:2: rule__ConstraintSignature__Group_2__0__Impl rule__ConstraintSignature__Group_2__1
            {
            pushFollow(FOLLOW_rule__ConstraintSignature__Group_2__0__Impl_in_rule__ConstraintSignature__Group_2__08535);
            rule__ConstraintSignature__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ConstraintSignature__Group_2__1_in_rule__ConstraintSignature__Group_2__08538);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4219:1: rule__ConstraintSignature__Group_2__0__Impl : ( ( rule__ConstraintSignature__ParameterAssignment_2_0 ) ) ;
    public final void rule__ConstraintSignature__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4223:1: ( ( ( rule__ConstraintSignature__ParameterAssignment_2_0 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4224:1: ( ( rule__ConstraintSignature__ParameterAssignment_2_0 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4224:1: ( ( rule__ConstraintSignature__ParameterAssignment_2_0 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4225:1: ( rule__ConstraintSignature__ParameterAssignment_2_0 )
            {
             before(grammarAccess.getConstraintSignatureAccess().getParameterAssignment_2_0()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4226:1: ( rule__ConstraintSignature__ParameterAssignment_2_0 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4226:2: rule__ConstraintSignature__ParameterAssignment_2_0
            {
            pushFollow(FOLLOW_rule__ConstraintSignature__ParameterAssignment_2_0_in_rule__ConstraintSignature__Group_2__0__Impl8565);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4236:1: rule__ConstraintSignature__Group_2__1 : rule__ConstraintSignature__Group_2__1__Impl ;
    public final void rule__ConstraintSignature__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4240:1: ( rule__ConstraintSignature__Group_2__1__Impl )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4241:2: rule__ConstraintSignature__Group_2__1__Impl
            {
            pushFollow(FOLLOW_rule__ConstraintSignature__Group_2__1__Impl_in_rule__ConstraintSignature__Group_2__18595);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4247:1: rule__ConstraintSignature__Group_2__1__Impl : ( ( rule__ConstraintSignature__Group_2_1__0 )* ) ;
    public final void rule__ConstraintSignature__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4251:1: ( ( ( rule__ConstraintSignature__Group_2_1__0 )* ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4252:1: ( ( rule__ConstraintSignature__Group_2_1__0 )* )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4252:1: ( ( rule__ConstraintSignature__Group_2_1__0 )* )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4253:1: ( rule__ConstraintSignature__Group_2_1__0 )*
            {
             before(grammarAccess.getConstraintSignatureAccess().getGroup_2_1()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4254:1: ( rule__ConstraintSignature__Group_2_1__0 )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==29) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4254:2: rule__ConstraintSignature__Group_2_1__0
            	    {
            	    pushFollow(FOLLOW_rule__ConstraintSignature__Group_2_1__0_in_rule__ConstraintSignature__Group_2__1__Impl8622);
            	    rule__ConstraintSignature__Group_2_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop16;
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4268:1: rule__ConstraintSignature__Group_2_1__0 : rule__ConstraintSignature__Group_2_1__0__Impl rule__ConstraintSignature__Group_2_1__1 ;
    public final void rule__ConstraintSignature__Group_2_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4272:1: ( rule__ConstraintSignature__Group_2_1__0__Impl rule__ConstraintSignature__Group_2_1__1 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4273:2: rule__ConstraintSignature__Group_2_1__0__Impl rule__ConstraintSignature__Group_2_1__1
            {
            pushFollow(FOLLOW_rule__ConstraintSignature__Group_2_1__0__Impl_in_rule__ConstraintSignature__Group_2_1__08657);
            rule__ConstraintSignature__Group_2_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ConstraintSignature__Group_2_1__1_in_rule__ConstraintSignature__Group_2_1__08660);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4280:1: rule__ConstraintSignature__Group_2_1__0__Impl : ( ',' ) ;
    public final void rule__ConstraintSignature__Group_2_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4284:1: ( ( ',' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4285:1: ( ',' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4285:1: ( ',' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4286:1: ','
            {
             before(grammarAccess.getConstraintSignatureAccess().getCommaKeyword_2_1_0()); 
            match(input,29,FOLLOW_29_in_rule__ConstraintSignature__Group_2_1__0__Impl8688); 
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4299:1: rule__ConstraintSignature__Group_2_1__1 : rule__ConstraintSignature__Group_2_1__1__Impl ;
    public final void rule__ConstraintSignature__Group_2_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4303:1: ( rule__ConstraintSignature__Group_2_1__1__Impl )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4304:2: rule__ConstraintSignature__Group_2_1__1__Impl
            {
            pushFollow(FOLLOW_rule__ConstraintSignature__Group_2_1__1__Impl_in_rule__ConstraintSignature__Group_2_1__18719);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4310:1: rule__ConstraintSignature__Group_2_1__1__Impl : ( ( rule__ConstraintSignature__ParameterAssignment_2_1_1 ) ) ;
    public final void rule__ConstraintSignature__Group_2_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4314:1: ( ( ( rule__ConstraintSignature__ParameterAssignment_2_1_1 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4315:1: ( ( rule__ConstraintSignature__ParameterAssignment_2_1_1 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4315:1: ( ( rule__ConstraintSignature__ParameterAssignment_2_1_1 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4316:1: ( rule__ConstraintSignature__ParameterAssignment_2_1_1 )
            {
             before(grammarAccess.getConstraintSignatureAccess().getParameterAssignment_2_1_1()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4317:1: ( rule__ConstraintSignature__ParameterAssignment_2_1_1 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4317:2: rule__ConstraintSignature__ParameterAssignment_2_1_1
            {
            pushFollow(FOLLOW_rule__ConstraintSignature__ParameterAssignment_2_1_1_in_rule__ConstraintSignature__Group_2_1__1__Impl8746);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4331:1: rule__Morphism__Group__0 : rule__Morphism__Group__0__Impl rule__Morphism__Group__1 ;
    public final void rule__Morphism__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4335:1: ( rule__Morphism__Group__0__Impl rule__Morphism__Group__1 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4336:2: rule__Morphism__Group__0__Impl rule__Morphism__Group__1
            {
            pushFollow(FOLLOW_rule__Morphism__Group__0__Impl_in_rule__Morphism__Group__08780);
            rule__Morphism__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Morphism__Group__1_in_rule__Morphism__Group__08783);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4343:1: rule__Morphism__Group__0__Impl : ( RULE_ID ) ;
    public final void rule__Morphism__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4347:1: ( ( RULE_ID ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4348:1: ( RULE_ID )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4348:1: ( RULE_ID )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4349:1: RULE_ID
            {
             before(grammarAccess.getMorphismAccess().getIDTerminalRuleCall_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Morphism__Group__0__Impl8810); 
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4360:1: rule__Morphism__Group__1 : rule__Morphism__Group__1__Impl rule__Morphism__Group__2 ;
    public final void rule__Morphism__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4364:1: ( rule__Morphism__Group__1__Impl rule__Morphism__Group__2 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4365:2: rule__Morphism__Group__1__Impl rule__Morphism__Group__2
            {
            pushFollow(FOLLOW_rule__Morphism__Group__1__Impl_in_rule__Morphism__Group__18839);
            rule__Morphism__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Morphism__Group__2_in_rule__Morphism__Group__18842);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4372:1: rule__Morphism__Group__1__Impl : ( ':=' ) ;
    public final void rule__Morphism__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4376:1: ( ( ':=' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4377:1: ( ':=' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4377:1: ( ':=' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4378:1: ':='
            {
             before(grammarAccess.getMorphismAccess().getColonEqualsSignKeyword_1()); 
            match(input,33,FOLLOW_33_in_rule__Morphism__Group__1__Impl8870); 
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4391:1: rule__Morphism__Group__2 : rule__Morphism__Group__2__Impl rule__Morphism__Group__3 ;
    public final void rule__Morphism__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4395:1: ( rule__Morphism__Group__2__Impl rule__Morphism__Group__3 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4396:2: rule__Morphism__Group__2__Impl rule__Morphism__Group__3
            {
            pushFollow(FOLLOW_rule__Morphism__Group__2__Impl_in_rule__Morphism__Group__28901);
            rule__Morphism__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Morphism__Group__3_in_rule__Morphism__Group__28904);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4403:1: rule__Morphism__Group__2__Impl : ( 'Morphism<' ) ;
    public final void rule__Morphism__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4407:1: ( ( 'Morphism<' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4408:1: ( 'Morphism<' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4408:1: ( 'Morphism<' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4409:1: 'Morphism<'
            {
             before(grammarAccess.getMorphismAccess().getMorphismKeyword_2()); 
            match(input,41,FOLLOW_41_in_rule__Morphism__Group__2__Impl8932); 
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4422:1: rule__Morphism__Group__3 : rule__Morphism__Group__3__Impl rule__Morphism__Group__4 ;
    public final void rule__Morphism__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4426:1: ( rule__Morphism__Group__3__Impl rule__Morphism__Group__4 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4427:2: rule__Morphism__Group__3__Impl rule__Morphism__Group__4
            {
            pushFollow(FOLLOW_rule__Morphism__Group__3__Impl_in_rule__Morphism__Group__38963);
            rule__Morphism__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Morphism__Group__4_in_rule__Morphism__Group__38966);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4434:1: rule__Morphism__Group__3__Impl : ( ( rule__Morphism__DomainAssignment_3 ) ) ;
    public final void rule__Morphism__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4438:1: ( ( ( rule__Morphism__DomainAssignment_3 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4439:1: ( ( rule__Morphism__DomainAssignment_3 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4439:1: ( ( rule__Morphism__DomainAssignment_3 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4440:1: ( rule__Morphism__DomainAssignment_3 )
            {
             before(grammarAccess.getMorphismAccess().getDomainAssignment_3()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4441:1: ( rule__Morphism__DomainAssignment_3 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4441:2: rule__Morphism__DomainAssignment_3
            {
            pushFollow(FOLLOW_rule__Morphism__DomainAssignment_3_in_rule__Morphism__Group__3__Impl8993);
            rule__Morphism__DomainAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getMorphismAccess().getDomainAssignment_3()); 

            }


            }

        }
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4451:1: rule__Morphism__Group__4 : rule__Morphism__Group__4__Impl rule__Morphism__Group__5 ;
    public final void rule__Morphism__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4455:1: ( rule__Morphism__Group__4__Impl rule__Morphism__Group__5 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4456:2: rule__Morphism__Group__4__Impl rule__Morphism__Group__5
            {
            pushFollow(FOLLOW_rule__Morphism__Group__4__Impl_in_rule__Morphism__Group__49023);
            rule__Morphism__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Morphism__Group__5_in_rule__Morphism__Group__49026);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4463:1: rule__Morphism__Group__4__Impl : ( ',' ) ;
    public final void rule__Morphism__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4467:1: ( ( ',' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4468:1: ( ',' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4468:1: ( ',' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4469:1: ','
            {
             before(grammarAccess.getMorphismAccess().getCommaKeyword_4()); 
            match(input,29,FOLLOW_29_in_rule__Morphism__Group__4__Impl9054); 
             after(grammarAccess.getMorphismAccess().getCommaKeyword_4()); 

            }


            }

        }
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4482:1: rule__Morphism__Group__5 : rule__Morphism__Group__5__Impl rule__Morphism__Group__6 ;
    public final void rule__Morphism__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4486:1: ( rule__Morphism__Group__5__Impl rule__Morphism__Group__6 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4487:2: rule__Morphism__Group__5__Impl rule__Morphism__Group__6
            {
            pushFollow(FOLLOW_rule__Morphism__Group__5__Impl_in_rule__Morphism__Group__59085);
            rule__Morphism__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Morphism__Group__6_in_rule__Morphism__Group__59088);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4494:1: rule__Morphism__Group__5__Impl : ( ( rule__Morphism__CodmainAssignment_5 ) ) ;
    public final void rule__Morphism__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4498:1: ( ( ( rule__Morphism__CodmainAssignment_5 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4499:1: ( ( rule__Morphism__CodmainAssignment_5 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4499:1: ( ( rule__Morphism__CodmainAssignment_5 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4500:1: ( rule__Morphism__CodmainAssignment_5 )
            {
             before(grammarAccess.getMorphismAccess().getCodmainAssignment_5()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4501:1: ( rule__Morphism__CodmainAssignment_5 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4501:2: rule__Morphism__CodmainAssignment_5
            {
            pushFollow(FOLLOW_rule__Morphism__CodmainAssignment_5_in_rule__Morphism__Group__5__Impl9115);
            rule__Morphism__CodmainAssignment_5();

            state._fsp--;


            }

             after(grammarAccess.getMorphismAccess().getCodmainAssignment_5()); 

            }


            }

        }
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4511:1: rule__Morphism__Group__6 : rule__Morphism__Group__6__Impl rule__Morphism__Group__7 ;
    public final void rule__Morphism__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4515:1: ( rule__Morphism__Group__6__Impl rule__Morphism__Group__7 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4516:2: rule__Morphism__Group__6__Impl rule__Morphism__Group__7
            {
            pushFollow(FOLLOW_rule__Morphism__Group__6__Impl_in_rule__Morphism__Group__69145);
            rule__Morphism__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Morphism__Group__7_in_rule__Morphism__Group__69148);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4523:1: rule__Morphism__Group__6__Impl : ( '>' ) ;
    public final void rule__Morphism__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4527:1: ( ( '>' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4528:1: ( '>' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4528:1: ( '>' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4529:1: '>'
            {
             before(grammarAccess.getMorphismAccess().getGreaterThanSignKeyword_6()); 
            match(input,35,FOLLOW_35_in_rule__Morphism__Group__6__Impl9176); 
             after(grammarAccess.getMorphismAccess().getGreaterThanSignKeyword_6()); 

            }


            }

        }
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4542:1: rule__Morphism__Group__7 : rule__Morphism__Group__7__Impl rule__Morphism__Group__8 ;
    public final void rule__Morphism__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4546:1: ( rule__Morphism__Group__7__Impl rule__Morphism__Group__8 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4547:2: rule__Morphism__Group__7__Impl rule__Morphism__Group__8
            {
            pushFollow(FOLLOW_rule__Morphism__Group__7__Impl_in_rule__Morphism__Group__79207);
            rule__Morphism__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Morphism__Group__8_in_rule__Morphism__Group__79210);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4554:1: rule__Morphism__Group__7__Impl : ( '{' ) ;
    public final void rule__Morphism__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4558:1: ( ( '{' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4559:1: ( '{' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4559:1: ( '{' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4560:1: '{'
            {
             before(grammarAccess.getMorphismAccess().getLeftCurlyBracketKeyword_7()); 
            match(input,36,FOLLOW_36_in_rule__Morphism__Group__7__Impl9238); 
             after(grammarAccess.getMorphismAccess().getLeftCurlyBracketKeyword_7()); 

            }


            }

        }
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4573:1: rule__Morphism__Group__8 : rule__Morphism__Group__8__Impl rule__Morphism__Group__9 ;
    public final void rule__Morphism__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4577:1: ( rule__Morphism__Group__8__Impl rule__Morphism__Group__9 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4578:2: rule__Morphism__Group__8__Impl rule__Morphism__Group__9
            {
            pushFollow(FOLLOW_rule__Morphism__Group__8__Impl_in_rule__Morphism__Group__89269);
            rule__Morphism__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Morphism__Group__9_in_rule__Morphism__Group__89272);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4585:1: rule__Morphism__Group__8__Impl : ( ( rule__Morphism__Group_8__0 )? ) ;
    public final void rule__Morphism__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4589:1: ( ( ( rule__Morphism__Group_8__0 )? ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4590:1: ( ( rule__Morphism__Group_8__0 )? )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4590:1: ( ( rule__Morphism__Group_8__0 )? )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4591:1: ( rule__Morphism__Group_8__0 )?
            {
             before(grammarAccess.getMorphismAccess().getGroup_8()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4592:1: ( rule__Morphism__Group_8__0 )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==RULE_ID) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4592:2: rule__Morphism__Group_8__0
                    {
                    pushFollow(FOLLOW_rule__Morphism__Group_8__0_in_rule__Morphism__Group__8__Impl9299);
                    rule__Morphism__Group_8__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getMorphismAccess().getGroup_8()); 

            }


            }

        }
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4602:1: rule__Morphism__Group__9 : rule__Morphism__Group__9__Impl ;
    public final void rule__Morphism__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4606:1: ( rule__Morphism__Group__9__Impl )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4607:2: rule__Morphism__Group__9__Impl
            {
            pushFollow(FOLLOW_rule__Morphism__Group__9__Impl_in_rule__Morphism__Group__99330);
            rule__Morphism__Group__9__Impl();

            state._fsp--;


            }

        }
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4613:1: rule__Morphism__Group__9__Impl : ( '}' ) ;
    public final void rule__Morphism__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4617:1: ( ( '}' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4618:1: ( '}' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4618:1: ( '}' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4619:1: '}'
            {
             before(grammarAccess.getMorphismAccess().getRightCurlyBracketKeyword_9()); 
            match(input,37,FOLLOW_37_in_rule__Morphism__Group__9__Impl9358); 
             after(grammarAccess.getMorphismAccess().getRightCurlyBracketKeyword_9()); 

            }


            }

        }
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


    // $ANTLR start "rule__Morphism__Group_8__0"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4652:1: rule__Morphism__Group_8__0 : rule__Morphism__Group_8__0__Impl rule__Morphism__Group_8__1 ;
    public final void rule__Morphism__Group_8__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4656:1: ( rule__Morphism__Group_8__0__Impl rule__Morphism__Group_8__1 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4657:2: rule__Morphism__Group_8__0__Impl rule__Morphism__Group_8__1
            {
            pushFollow(FOLLOW_rule__Morphism__Group_8__0__Impl_in_rule__Morphism__Group_8__09409);
            rule__Morphism__Group_8__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Morphism__Group_8__1_in_rule__Morphism__Group_8__09412);
            rule__Morphism__Group_8__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Morphism__Group_8__0"


    // $ANTLR start "rule__Morphism__Group_8__0__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4664:1: rule__Morphism__Group_8__0__Impl : ( ( rule__Morphism__MappingsAssignment_8_0 ) ) ;
    public final void rule__Morphism__Group_8__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4668:1: ( ( ( rule__Morphism__MappingsAssignment_8_0 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4669:1: ( ( rule__Morphism__MappingsAssignment_8_0 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4669:1: ( ( rule__Morphism__MappingsAssignment_8_0 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4670:1: ( rule__Morphism__MappingsAssignment_8_0 )
            {
             before(grammarAccess.getMorphismAccess().getMappingsAssignment_8_0()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4671:1: ( rule__Morphism__MappingsAssignment_8_0 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4671:2: rule__Morphism__MappingsAssignment_8_0
            {
            pushFollow(FOLLOW_rule__Morphism__MappingsAssignment_8_0_in_rule__Morphism__Group_8__0__Impl9439);
            rule__Morphism__MappingsAssignment_8_0();

            state._fsp--;


            }

             after(grammarAccess.getMorphismAccess().getMappingsAssignment_8_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Morphism__Group_8__0__Impl"


    // $ANTLR start "rule__Morphism__Group_8__1"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4681:1: rule__Morphism__Group_8__1 : rule__Morphism__Group_8__1__Impl ;
    public final void rule__Morphism__Group_8__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4685:1: ( rule__Morphism__Group_8__1__Impl )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4686:2: rule__Morphism__Group_8__1__Impl
            {
            pushFollow(FOLLOW_rule__Morphism__Group_8__1__Impl_in_rule__Morphism__Group_8__19469);
            rule__Morphism__Group_8__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Morphism__Group_8__1"


    // $ANTLR start "rule__Morphism__Group_8__1__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4692:1: rule__Morphism__Group_8__1__Impl : ( ( rule__Morphism__Group_8_1__0 )* ) ;
    public final void rule__Morphism__Group_8__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4696:1: ( ( ( rule__Morphism__Group_8_1__0 )* ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4697:1: ( ( rule__Morphism__Group_8_1__0 )* )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4697:1: ( ( rule__Morphism__Group_8_1__0 )* )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4698:1: ( rule__Morphism__Group_8_1__0 )*
            {
             before(grammarAccess.getMorphismAccess().getGroup_8_1()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4699:1: ( rule__Morphism__Group_8_1__0 )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==29) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4699:2: rule__Morphism__Group_8_1__0
            	    {
            	    pushFollow(FOLLOW_rule__Morphism__Group_8_1__0_in_rule__Morphism__Group_8__1__Impl9496);
            	    rule__Morphism__Group_8_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);

             after(grammarAccess.getMorphismAccess().getGroup_8_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Morphism__Group_8__1__Impl"


    // $ANTLR start "rule__Morphism__Group_8_1__0"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4713:1: rule__Morphism__Group_8_1__0 : rule__Morphism__Group_8_1__0__Impl rule__Morphism__Group_8_1__1 ;
    public final void rule__Morphism__Group_8_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4717:1: ( rule__Morphism__Group_8_1__0__Impl rule__Morphism__Group_8_1__1 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4718:2: rule__Morphism__Group_8_1__0__Impl rule__Morphism__Group_8_1__1
            {
            pushFollow(FOLLOW_rule__Morphism__Group_8_1__0__Impl_in_rule__Morphism__Group_8_1__09531);
            rule__Morphism__Group_8_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Morphism__Group_8_1__1_in_rule__Morphism__Group_8_1__09534);
            rule__Morphism__Group_8_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Morphism__Group_8_1__0"


    // $ANTLR start "rule__Morphism__Group_8_1__0__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4725:1: rule__Morphism__Group_8_1__0__Impl : ( ',' ) ;
    public final void rule__Morphism__Group_8_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4729:1: ( ( ',' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4730:1: ( ',' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4730:1: ( ',' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4731:1: ','
            {
             before(grammarAccess.getMorphismAccess().getCommaKeyword_8_1_0()); 
            match(input,29,FOLLOW_29_in_rule__Morphism__Group_8_1__0__Impl9562); 
             after(grammarAccess.getMorphismAccess().getCommaKeyword_8_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Morphism__Group_8_1__0__Impl"


    // $ANTLR start "rule__Morphism__Group_8_1__1"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4744:1: rule__Morphism__Group_8_1__1 : rule__Morphism__Group_8_1__1__Impl ;
    public final void rule__Morphism__Group_8_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4748:1: ( rule__Morphism__Group_8_1__1__Impl )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4749:2: rule__Morphism__Group_8_1__1__Impl
            {
            pushFollow(FOLLOW_rule__Morphism__Group_8_1__1__Impl_in_rule__Morphism__Group_8_1__19593);
            rule__Morphism__Group_8_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Morphism__Group_8_1__1"


    // $ANTLR start "rule__Morphism__Group_8_1__1__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4755:1: rule__Morphism__Group_8_1__1__Impl : ( ( rule__Morphism__MappingsAssignment_8_1_1 ) ) ;
    public final void rule__Morphism__Group_8_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4759:1: ( ( ( rule__Morphism__MappingsAssignment_8_1_1 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4760:1: ( ( rule__Morphism__MappingsAssignment_8_1_1 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4760:1: ( ( rule__Morphism__MappingsAssignment_8_1_1 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4761:1: ( rule__Morphism__MappingsAssignment_8_1_1 )
            {
             before(grammarAccess.getMorphismAccess().getMappingsAssignment_8_1_1()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4762:1: ( rule__Morphism__MappingsAssignment_8_1_1 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4762:2: rule__Morphism__MappingsAssignment_8_1_1
            {
            pushFollow(FOLLOW_rule__Morphism__MappingsAssignment_8_1_1_in_rule__Morphism__Group_8_1__1__Impl9620);
            rule__Morphism__MappingsAssignment_8_1_1();

            state._fsp--;


            }

             after(grammarAccess.getMorphismAccess().getMappingsAssignment_8_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Morphism__Group_8_1__1__Impl"


    // $ANTLR start "rule__MappingNode__Group__0"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4776:1: rule__MappingNode__Group__0 : rule__MappingNode__Group__0__Impl rule__MappingNode__Group__1 ;
    public final void rule__MappingNode__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4780:1: ( rule__MappingNode__Group__0__Impl rule__MappingNode__Group__1 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4781:2: rule__MappingNode__Group__0__Impl rule__MappingNode__Group__1
            {
            pushFollow(FOLLOW_rule__MappingNode__Group__0__Impl_in_rule__MappingNode__Group__09654);
            rule__MappingNode__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__MappingNode__Group__1_in_rule__MappingNode__Group__09657);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4788:1: rule__MappingNode__Group__0__Impl : ( ( rule__MappingNode__DomainAssignment_0 ) ) ;
    public final void rule__MappingNode__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4792:1: ( ( ( rule__MappingNode__DomainAssignment_0 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4793:1: ( ( rule__MappingNode__DomainAssignment_0 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4793:1: ( ( rule__MappingNode__DomainAssignment_0 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4794:1: ( rule__MappingNode__DomainAssignment_0 )
            {
             before(grammarAccess.getMappingNodeAccess().getDomainAssignment_0()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4795:1: ( rule__MappingNode__DomainAssignment_0 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4795:2: rule__MappingNode__DomainAssignment_0
            {
            pushFollow(FOLLOW_rule__MappingNode__DomainAssignment_0_in_rule__MappingNode__Group__0__Impl9684);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4805:1: rule__MappingNode__Group__1 : rule__MappingNode__Group__1__Impl rule__MappingNode__Group__2 ;
    public final void rule__MappingNode__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4809:1: ( rule__MappingNode__Group__1__Impl rule__MappingNode__Group__2 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4810:2: rule__MappingNode__Group__1__Impl rule__MappingNode__Group__2
            {
            pushFollow(FOLLOW_rule__MappingNode__Group__1__Impl_in_rule__MappingNode__Group__19714);
            rule__MappingNode__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__MappingNode__Group__2_in_rule__MappingNode__Group__19717);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4817:1: rule__MappingNode__Group__1__Impl : ( '=>' ) ;
    public final void rule__MappingNode__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4821:1: ( ( '=>' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4822:1: ( '=>' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4822:1: ( '=>' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4823:1: '=>'
            {
             before(grammarAccess.getMappingNodeAccess().getEqualsSignGreaterThanSignKeyword_1()); 
            match(input,42,FOLLOW_42_in_rule__MappingNode__Group__1__Impl9745); 
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4836:1: rule__MappingNode__Group__2 : rule__MappingNode__Group__2__Impl ;
    public final void rule__MappingNode__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4840:1: ( rule__MappingNode__Group__2__Impl )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4841:2: rule__MappingNode__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__MappingNode__Group__2__Impl_in_rule__MappingNode__Group__29776);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4847:1: rule__MappingNode__Group__2__Impl : ( ( rule__MappingNode__CodomainAssignment_2 ) ) ;
    public final void rule__MappingNode__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4851:1: ( ( ( rule__MappingNode__CodomainAssignment_2 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4852:1: ( ( rule__MappingNode__CodomainAssignment_2 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4852:1: ( ( rule__MappingNode__CodomainAssignment_2 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4853:1: ( rule__MappingNode__CodomainAssignment_2 )
            {
             before(grammarAccess.getMappingNodeAccess().getCodomainAssignment_2()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4854:1: ( rule__MappingNode__CodomainAssignment_2 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4854:2: rule__MappingNode__CodomainAssignment_2
            {
            pushFollow(FOLLOW_rule__MappingNode__CodomainAssignment_2_in_rule__MappingNode__Group__2__Impl9803);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4870:1: rule__MappingArrow__Group__0 : rule__MappingArrow__Group__0__Impl rule__MappingArrow__Group__1 ;
    public final void rule__MappingArrow__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4874:1: ( rule__MappingArrow__Group__0__Impl rule__MappingArrow__Group__1 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4875:2: rule__MappingArrow__Group__0__Impl rule__MappingArrow__Group__1
            {
            pushFollow(FOLLOW_rule__MappingArrow__Group__0__Impl_in_rule__MappingArrow__Group__09839);
            rule__MappingArrow__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__MappingArrow__Group__1_in_rule__MappingArrow__Group__09842);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4882:1: rule__MappingArrow__Group__0__Impl : ( ( rule__MappingArrow__DomainAssignment_0 ) ) ;
    public final void rule__MappingArrow__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4886:1: ( ( ( rule__MappingArrow__DomainAssignment_0 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4887:1: ( ( rule__MappingArrow__DomainAssignment_0 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4887:1: ( ( rule__MappingArrow__DomainAssignment_0 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4888:1: ( rule__MappingArrow__DomainAssignment_0 )
            {
             before(grammarAccess.getMappingArrowAccess().getDomainAssignment_0()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4889:1: ( rule__MappingArrow__DomainAssignment_0 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4889:2: rule__MappingArrow__DomainAssignment_0
            {
            pushFollow(FOLLOW_rule__MappingArrow__DomainAssignment_0_in_rule__MappingArrow__Group__0__Impl9869);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4899:1: rule__MappingArrow__Group__1 : rule__MappingArrow__Group__1__Impl rule__MappingArrow__Group__2 ;
    public final void rule__MappingArrow__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4903:1: ( rule__MappingArrow__Group__1__Impl rule__MappingArrow__Group__2 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4904:2: rule__MappingArrow__Group__1__Impl rule__MappingArrow__Group__2
            {
            pushFollow(FOLLOW_rule__MappingArrow__Group__1__Impl_in_rule__MappingArrow__Group__19899);
            rule__MappingArrow__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__MappingArrow__Group__2_in_rule__MappingArrow__Group__19902);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4911:1: rule__MappingArrow__Group__1__Impl : ( '=>' ) ;
    public final void rule__MappingArrow__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4915:1: ( ( '=>' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4916:1: ( '=>' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4916:1: ( '=>' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4917:1: '=>'
            {
             before(grammarAccess.getMappingArrowAccess().getEqualsSignGreaterThanSignKeyword_1()); 
            match(input,42,FOLLOW_42_in_rule__MappingArrow__Group__1__Impl9930); 
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4930:1: rule__MappingArrow__Group__2 : rule__MappingArrow__Group__2__Impl ;
    public final void rule__MappingArrow__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4934:1: ( rule__MappingArrow__Group__2__Impl )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4935:2: rule__MappingArrow__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__MappingArrow__Group__2__Impl_in_rule__MappingArrow__Group__29961);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4941:1: rule__MappingArrow__Group__2__Impl : ( ( rule__MappingArrow__CodmainAssignment_2 ) ) ;
    public final void rule__MappingArrow__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4945:1: ( ( ( rule__MappingArrow__CodmainAssignment_2 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4946:1: ( ( rule__MappingArrow__CodmainAssignment_2 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4946:1: ( ( rule__MappingArrow__CodmainAssignment_2 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4947:1: ( rule__MappingArrow__CodmainAssignment_2 )
            {
             before(grammarAccess.getMappingArrowAccess().getCodmainAssignment_2()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4948:1: ( rule__MappingArrow__CodmainAssignment_2 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4948:2: rule__MappingArrow__CodmainAssignment_2
            {
            pushFollow(FOLLOW_rule__MappingArrow__CodmainAssignment_2_in_rule__MappingArrow__Group__2__Impl9988);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4964:1: rule__ExtSubTGraph__Group__0 : rule__ExtSubTGraph__Group__0__Impl rule__ExtSubTGraph__Group__1 ;
    public final void rule__ExtSubTGraph__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4968:1: ( rule__ExtSubTGraph__Group__0__Impl rule__ExtSubTGraph__Group__1 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4969:2: rule__ExtSubTGraph__Group__0__Impl rule__ExtSubTGraph__Group__1
            {
            pushFollow(FOLLOW_rule__ExtSubTGraph__Group__0__Impl_in_rule__ExtSubTGraph__Group__010024);
            rule__ExtSubTGraph__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ExtSubTGraph__Group__1_in_rule__ExtSubTGraph__Group__010027);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4976:1: rule__ExtSubTGraph__Group__0__Impl : ( ( rule__ExtSubTGraph__IdAssignment_0 ) ) ;
    public final void rule__ExtSubTGraph__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4980:1: ( ( ( rule__ExtSubTGraph__IdAssignment_0 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4981:1: ( ( rule__ExtSubTGraph__IdAssignment_0 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4981:1: ( ( rule__ExtSubTGraph__IdAssignment_0 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4982:1: ( rule__ExtSubTGraph__IdAssignment_0 )
            {
             before(grammarAccess.getExtSubTGraphAccess().getIdAssignment_0()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4983:1: ( rule__ExtSubTGraph__IdAssignment_0 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4983:2: rule__ExtSubTGraph__IdAssignment_0
            {
            pushFollow(FOLLOW_rule__ExtSubTGraph__IdAssignment_0_in_rule__ExtSubTGraph__Group__0__Impl10054);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4993:1: rule__ExtSubTGraph__Group__1 : rule__ExtSubTGraph__Group__1__Impl rule__ExtSubTGraph__Group__2 ;
    public final void rule__ExtSubTGraph__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4997:1: ( rule__ExtSubTGraph__Group__1__Impl rule__ExtSubTGraph__Group__2 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:4998:2: rule__ExtSubTGraph__Group__1__Impl rule__ExtSubTGraph__Group__2
            {
            pushFollow(FOLLOW_rule__ExtSubTGraph__Group__1__Impl_in_rule__ExtSubTGraph__Group__110084);
            rule__ExtSubTGraph__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ExtSubTGraph__Group__2_in_rule__ExtSubTGraph__Group__110087);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5005:1: rule__ExtSubTGraph__Group__1__Impl : ( ':=' ) ;
    public final void rule__ExtSubTGraph__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5009:1: ( ( ':=' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5010:1: ( ':=' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5010:1: ( ':=' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5011:1: ':='
            {
             before(grammarAccess.getExtSubTGraphAccess().getColonEqualsSignKeyword_1()); 
            match(input,33,FOLLOW_33_in_rule__ExtSubTGraph__Group__1__Impl10115); 
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5024:1: rule__ExtSubTGraph__Group__2 : rule__ExtSubTGraph__Group__2__Impl rule__ExtSubTGraph__Group__3 ;
    public final void rule__ExtSubTGraph__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5028:1: ( rule__ExtSubTGraph__Group__2__Impl rule__ExtSubTGraph__Group__3 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5029:2: rule__ExtSubTGraph__Group__2__Impl rule__ExtSubTGraph__Group__3
            {
            pushFollow(FOLLOW_rule__ExtSubTGraph__Group__2__Impl_in_rule__ExtSubTGraph__Group__210146);
            rule__ExtSubTGraph__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ExtSubTGraph__Group__3_in_rule__ExtSubTGraph__Group__210149);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5036:1: rule__ExtSubTGraph__Group__2__Impl : ( 'ExtSubTGraph<' ) ;
    public final void rule__ExtSubTGraph__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5040:1: ( ( 'ExtSubTGraph<' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5041:1: ( 'ExtSubTGraph<' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5041:1: ( 'ExtSubTGraph<' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5042:1: 'ExtSubTGraph<'
            {
             before(grammarAccess.getExtSubTGraphAccess().getExtSubTGraphKeyword_2()); 
            match(input,43,FOLLOW_43_in_rule__ExtSubTGraph__Group__2__Impl10177); 
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5055:1: rule__ExtSubTGraph__Group__3 : rule__ExtSubTGraph__Group__3__Impl rule__ExtSubTGraph__Group__4 ;
    public final void rule__ExtSubTGraph__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5059:1: ( rule__ExtSubTGraph__Group__3__Impl rule__ExtSubTGraph__Group__4 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5060:2: rule__ExtSubTGraph__Group__3__Impl rule__ExtSubTGraph__Group__4
            {
            pushFollow(FOLLOW_rule__ExtSubTGraph__Group__3__Impl_in_rule__ExtSubTGraph__Group__310208);
            rule__ExtSubTGraph__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ExtSubTGraph__Group__4_in_rule__ExtSubTGraph__Group__310211);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5067:1: rule__ExtSubTGraph__Group__3__Impl : ( ( rule__ExtSubTGraph__ExtendsGraphAssignment_3 ) ) ;
    public final void rule__ExtSubTGraph__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5071:1: ( ( ( rule__ExtSubTGraph__ExtendsGraphAssignment_3 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5072:1: ( ( rule__ExtSubTGraph__ExtendsGraphAssignment_3 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5072:1: ( ( rule__ExtSubTGraph__ExtendsGraphAssignment_3 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5073:1: ( rule__ExtSubTGraph__ExtendsGraphAssignment_3 )
            {
             before(grammarAccess.getExtSubTGraphAccess().getExtendsGraphAssignment_3()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5074:1: ( rule__ExtSubTGraph__ExtendsGraphAssignment_3 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5074:2: rule__ExtSubTGraph__ExtendsGraphAssignment_3
            {
            pushFollow(FOLLOW_rule__ExtSubTGraph__ExtendsGraphAssignment_3_in_rule__ExtSubTGraph__Group__3__Impl10238);
            rule__ExtSubTGraph__ExtendsGraphAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getExtSubTGraphAccess().getExtendsGraphAssignment_3()); 

            }


            }

        }
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5084:1: rule__ExtSubTGraph__Group__4 : rule__ExtSubTGraph__Group__4__Impl rule__ExtSubTGraph__Group__5 ;
    public final void rule__ExtSubTGraph__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5088:1: ( rule__ExtSubTGraph__Group__4__Impl rule__ExtSubTGraph__Group__5 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5089:2: rule__ExtSubTGraph__Group__4__Impl rule__ExtSubTGraph__Group__5
            {
            pushFollow(FOLLOW_rule__ExtSubTGraph__Group__4__Impl_in_rule__ExtSubTGraph__Group__410268);
            rule__ExtSubTGraph__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ExtSubTGraph__Group__5_in_rule__ExtSubTGraph__Group__410271);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5096:1: rule__ExtSubTGraph__Group__4__Impl : ( '>' ) ;
    public final void rule__ExtSubTGraph__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5100:1: ( ( '>' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5101:1: ( '>' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5101:1: ( '>' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5102:1: '>'
            {
             before(grammarAccess.getExtSubTGraphAccess().getGreaterThanSignKeyword_4()); 
            match(input,35,FOLLOW_35_in_rule__ExtSubTGraph__Group__4__Impl10299); 
             after(grammarAccess.getExtSubTGraphAccess().getGreaterThanSignKeyword_4()); 

            }


            }

        }
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5115:1: rule__ExtSubTGraph__Group__5 : rule__ExtSubTGraph__Group__5__Impl rule__ExtSubTGraph__Group__6 ;
    public final void rule__ExtSubTGraph__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5119:1: ( rule__ExtSubTGraph__Group__5__Impl rule__ExtSubTGraph__Group__6 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5120:2: rule__ExtSubTGraph__Group__5__Impl rule__ExtSubTGraph__Group__6
            {
            pushFollow(FOLLOW_rule__ExtSubTGraph__Group__5__Impl_in_rule__ExtSubTGraph__Group__510330);
            rule__ExtSubTGraph__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ExtSubTGraph__Group__6_in_rule__ExtSubTGraph__Group__510333);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5127:1: rule__ExtSubTGraph__Group__5__Impl : ( '{' ) ;
    public final void rule__ExtSubTGraph__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5131:1: ( ( '{' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5132:1: ( '{' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5132:1: ( '{' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5133:1: '{'
            {
             before(grammarAccess.getExtSubTGraphAccess().getLeftCurlyBracketKeyword_5()); 
            match(input,36,FOLLOW_36_in_rule__ExtSubTGraph__Group__5__Impl10361); 
             after(grammarAccess.getExtSubTGraphAccess().getLeftCurlyBracketKeyword_5()); 

            }


            }

        }
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5146:1: rule__ExtSubTGraph__Group__6 : rule__ExtSubTGraph__Group__6__Impl rule__ExtSubTGraph__Group__7 ;
    public final void rule__ExtSubTGraph__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5150:1: ( rule__ExtSubTGraph__Group__6__Impl rule__ExtSubTGraph__Group__7 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5151:2: rule__ExtSubTGraph__Group__6__Impl rule__ExtSubTGraph__Group__7
            {
            pushFollow(FOLLOW_rule__ExtSubTGraph__Group__6__Impl_in_rule__ExtSubTGraph__Group__610392);
            rule__ExtSubTGraph__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ExtSubTGraph__Group__7_in_rule__ExtSubTGraph__Group__610395);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5158:1: rule__ExtSubTGraph__Group__6__Impl : ( ( rule__ExtSubTGraph__ElementsAssignment_6 )* ) ;
    public final void rule__ExtSubTGraph__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5162:1: ( ( ( rule__ExtSubTGraph__ElementsAssignment_6 )* ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5163:1: ( ( rule__ExtSubTGraph__ElementsAssignment_6 )* )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5163:1: ( ( rule__ExtSubTGraph__ElementsAssignment_6 )* )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5164:1: ( rule__ExtSubTGraph__ElementsAssignment_6 )*
            {
             before(grammarAccess.getExtSubTGraphAccess().getElementsAssignment_6()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5165:1: ( rule__ExtSubTGraph__ElementsAssignment_6 )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==RULE_ID) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5165:2: rule__ExtSubTGraph__ElementsAssignment_6
            	    {
            	    pushFollow(FOLLOW_rule__ExtSubTGraph__ElementsAssignment_6_in_rule__ExtSubTGraph__Group__6__Impl10422);
            	    rule__ExtSubTGraph__ElementsAssignment_6();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);

             after(grammarAccess.getExtSubTGraphAccess().getElementsAssignment_6()); 

            }


            }

        }
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5175:1: rule__ExtSubTGraph__Group__7 : rule__ExtSubTGraph__Group__7__Impl ;
    public final void rule__ExtSubTGraph__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5179:1: ( rule__ExtSubTGraph__Group__7__Impl )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5180:2: rule__ExtSubTGraph__Group__7__Impl
            {
            pushFollow(FOLLOW_rule__ExtSubTGraph__Group__7__Impl_in_rule__ExtSubTGraph__Group__710453);
            rule__ExtSubTGraph__Group__7__Impl();

            state._fsp--;


            }

        }
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5186:1: rule__ExtSubTGraph__Group__7__Impl : ( '}' ) ;
    public final void rule__ExtSubTGraph__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5190:1: ( ( '}' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5191:1: ( '}' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5191:1: ( '}' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5192:1: '}'
            {
             before(grammarAccess.getExtSubTGraphAccess().getRightCurlyBracketKeyword_7()); 
            match(input,37,FOLLOW_37_in_rule__ExtSubTGraph__Group__7__Impl10481); 
             after(grammarAccess.getExtSubTGraphAccess().getRightCurlyBracketKeyword_7()); 

            }


            }

        }
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


    // $ANTLR start "rule__TGraph__Group__0"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5221:1: rule__TGraph__Group__0 : rule__TGraph__Group__0__Impl rule__TGraph__Group__1 ;
    public final void rule__TGraph__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5225:1: ( rule__TGraph__Group__0__Impl rule__TGraph__Group__1 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5226:2: rule__TGraph__Group__0__Impl rule__TGraph__Group__1
            {
            pushFollow(FOLLOW_rule__TGraph__Group__0__Impl_in_rule__TGraph__Group__010528);
            rule__TGraph__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TGraph__Group__1_in_rule__TGraph__Group__010531);
            rule__TGraph__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TGraph__Group__0"


    // $ANTLR start "rule__TGraph__Group__0__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5233:1: rule__TGraph__Group__0__Impl : ( ( rule__TGraph__IdAssignment_0 ) ) ;
    public final void rule__TGraph__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5237:1: ( ( ( rule__TGraph__IdAssignment_0 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5238:1: ( ( rule__TGraph__IdAssignment_0 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5238:1: ( ( rule__TGraph__IdAssignment_0 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5239:1: ( rule__TGraph__IdAssignment_0 )
            {
             before(grammarAccess.getTGraphAccess().getIdAssignment_0()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5240:1: ( rule__TGraph__IdAssignment_0 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5240:2: rule__TGraph__IdAssignment_0
            {
            pushFollow(FOLLOW_rule__TGraph__IdAssignment_0_in_rule__TGraph__Group__0__Impl10558);
            rule__TGraph__IdAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getTGraphAccess().getIdAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TGraph__Group__0__Impl"


    // $ANTLR start "rule__TGraph__Group__1"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5250:1: rule__TGraph__Group__1 : rule__TGraph__Group__1__Impl rule__TGraph__Group__2 ;
    public final void rule__TGraph__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5254:1: ( rule__TGraph__Group__1__Impl rule__TGraph__Group__2 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5255:2: rule__TGraph__Group__1__Impl rule__TGraph__Group__2
            {
            pushFollow(FOLLOW_rule__TGraph__Group__1__Impl_in_rule__TGraph__Group__110588);
            rule__TGraph__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TGraph__Group__2_in_rule__TGraph__Group__110591);
            rule__TGraph__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TGraph__Group__1"


    // $ANTLR start "rule__TGraph__Group__1__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5262:1: rule__TGraph__Group__1__Impl : ( ':=' ) ;
    public final void rule__TGraph__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5266:1: ( ( ':=' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5267:1: ( ':=' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5267:1: ( ':=' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5268:1: ':='
            {
             before(grammarAccess.getTGraphAccess().getColonEqualsSignKeyword_1()); 
            match(input,33,FOLLOW_33_in_rule__TGraph__Group__1__Impl10619); 
             after(grammarAccess.getTGraphAccess().getColonEqualsSignKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TGraph__Group__1__Impl"


    // $ANTLR start "rule__TGraph__Group__2"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5281:1: rule__TGraph__Group__2 : rule__TGraph__Group__2__Impl rule__TGraph__Group__3 ;
    public final void rule__TGraph__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5285:1: ( rule__TGraph__Group__2__Impl rule__TGraph__Group__3 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5286:2: rule__TGraph__Group__2__Impl rule__TGraph__Group__3
            {
            pushFollow(FOLLOW_rule__TGraph__Group__2__Impl_in_rule__TGraph__Group__210650);
            rule__TGraph__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TGraph__Group__3_in_rule__TGraph__Group__210653);
            rule__TGraph__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TGraph__Group__2"


    // $ANTLR start "rule__TGraph__Group__2__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5293:1: rule__TGraph__Group__2__Impl : ( 'TGraph<' ) ;
    public final void rule__TGraph__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5297:1: ( ( 'TGraph<' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5298:1: ( 'TGraph<' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5298:1: ( 'TGraph<' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5299:1: 'TGraph<'
            {
             before(grammarAccess.getTGraphAccess().getTGraphKeyword_2()); 
            match(input,44,FOLLOW_44_in_rule__TGraph__Group__2__Impl10681); 
             after(grammarAccess.getTGraphAccess().getTGraphKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TGraph__Group__2__Impl"


    // $ANTLR start "rule__TGraph__Group__3"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5312:1: rule__TGraph__Group__3 : rule__TGraph__Group__3__Impl rule__TGraph__Group__4 ;
    public final void rule__TGraph__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5316:1: ( rule__TGraph__Group__3__Impl rule__TGraph__Group__4 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5317:2: rule__TGraph__Group__3__Impl rule__TGraph__Group__4
            {
            pushFollow(FOLLOW_rule__TGraph__Group__3__Impl_in_rule__TGraph__Group__310712);
            rule__TGraph__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TGraph__Group__4_in_rule__TGraph__Group__310715);
            rule__TGraph__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TGraph__Group__3"


    // $ANTLR start "rule__TGraph__Group__3__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5324:1: rule__TGraph__Group__3__Impl : ( ( rule__TGraph__TypeGraphAssignment_3 ) ) ;
    public final void rule__TGraph__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5328:1: ( ( ( rule__TGraph__TypeGraphAssignment_3 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5329:1: ( ( rule__TGraph__TypeGraphAssignment_3 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5329:1: ( ( rule__TGraph__TypeGraphAssignment_3 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5330:1: ( rule__TGraph__TypeGraphAssignment_3 )
            {
             before(grammarAccess.getTGraphAccess().getTypeGraphAssignment_3()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5331:1: ( rule__TGraph__TypeGraphAssignment_3 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5331:2: rule__TGraph__TypeGraphAssignment_3
            {
            pushFollow(FOLLOW_rule__TGraph__TypeGraphAssignment_3_in_rule__TGraph__Group__3__Impl10742);
            rule__TGraph__TypeGraphAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getTGraphAccess().getTypeGraphAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TGraph__Group__3__Impl"


    // $ANTLR start "rule__TGraph__Group__4"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5341:1: rule__TGraph__Group__4 : rule__TGraph__Group__4__Impl rule__TGraph__Group__5 ;
    public final void rule__TGraph__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5345:1: ( rule__TGraph__Group__4__Impl rule__TGraph__Group__5 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5346:2: rule__TGraph__Group__4__Impl rule__TGraph__Group__5
            {
            pushFollow(FOLLOW_rule__TGraph__Group__4__Impl_in_rule__TGraph__Group__410772);
            rule__TGraph__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TGraph__Group__5_in_rule__TGraph__Group__410775);
            rule__TGraph__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TGraph__Group__4"


    // $ANTLR start "rule__TGraph__Group__4__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5353:1: rule__TGraph__Group__4__Impl : ( '>' ) ;
    public final void rule__TGraph__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5357:1: ( ( '>' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5358:1: ( '>' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5358:1: ( '>' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5359:1: '>'
            {
             before(grammarAccess.getTGraphAccess().getGreaterThanSignKeyword_4()); 
            match(input,35,FOLLOW_35_in_rule__TGraph__Group__4__Impl10803); 
             after(grammarAccess.getTGraphAccess().getGreaterThanSignKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TGraph__Group__4__Impl"


    // $ANTLR start "rule__TGraph__Group__5"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5372:1: rule__TGraph__Group__5 : rule__TGraph__Group__5__Impl rule__TGraph__Group__6 ;
    public final void rule__TGraph__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5376:1: ( rule__TGraph__Group__5__Impl rule__TGraph__Group__6 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5377:2: rule__TGraph__Group__5__Impl rule__TGraph__Group__6
            {
            pushFollow(FOLLOW_rule__TGraph__Group__5__Impl_in_rule__TGraph__Group__510834);
            rule__TGraph__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TGraph__Group__6_in_rule__TGraph__Group__510837);
            rule__TGraph__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TGraph__Group__5"


    // $ANTLR start "rule__TGraph__Group__5__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5384:1: rule__TGraph__Group__5__Impl : ( '{' ) ;
    public final void rule__TGraph__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5388:1: ( ( '{' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5389:1: ( '{' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5389:1: ( '{' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5390:1: '{'
            {
             before(grammarAccess.getTGraphAccess().getLeftCurlyBracketKeyword_5()); 
            match(input,36,FOLLOW_36_in_rule__TGraph__Group__5__Impl10865); 
             after(grammarAccess.getTGraphAccess().getLeftCurlyBracketKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TGraph__Group__5__Impl"


    // $ANTLR start "rule__TGraph__Group__6"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5403:1: rule__TGraph__Group__6 : rule__TGraph__Group__6__Impl rule__TGraph__Group__7 ;
    public final void rule__TGraph__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5407:1: ( rule__TGraph__Group__6__Impl rule__TGraph__Group__7 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5408:2: rule__TGraph__Group__6__Impl rule__TGraph__Group__7
            {
            pushFollow(FOLLOW_rule__TGraph__Group__6__Impl_in_rule__TGraph__Group__610896);
            rule__TGraph__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TGraph__Group__7_in_rule__TGraph__Group__610899);
            rule__TGraph__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TGraph__Group__6"


    // $ANTLR start "rule__TGraph__Group__6__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5415:1: rule__TGraph__Group__6__Impl : ( ( rule__TGraph__ElementsAssignment_6 )* ) ;
    public final void rule__TGraph__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5419:1: ( ( ( rule__TGraph__ElementsAssignment_6 )* ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5420:1: ( ( rule__TGraph__ElementsAssignment_6 )* )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5420:1: ( ( rule__TGraph__ElementsAssignment_6 )* )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5421:1: ( rule__TGraph__ElementsAssignment_6 )*
            {
             before(grammarAccess.getTGraphAccess().getElementsAssignment_6()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5422:1: ( rule__TGraph__ElementsAssignment_6 )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==RULE_ID) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5422:2: rule__TGraph__ElementsAssignment_6
            	    {
            	    pushFollow(FOLLOW_rule__TGraph__ElementsAssignment_6_in_rule__TGraph__Group__6__Impl10926);
            	    rule__TGraph__ElementsAssignment_6();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);

             after(grammarAccess.getTGraphAccess().getElementsAssignment_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TGraph__Group__6__Impl"


    // $ANTLR start "rule__TGraph__Group__7"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5432:1: rule__TGraph__Group__7 : rule__TGraph__Group__7__Impl ;
    public final void rule__TGraph__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5436:1: ( rule__TGraph__Group__7__Impl )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5437:2: rule__TGraph__Group__7__Impl
            {
            pushFollow(FOLLOW_rule__TGraph__Group__7__Impl_in_rule__TGraph__Group__710957);
            rule__TGraph__Group__7__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TGraph__Group__7"


    // $ANTLR start "rule__TGraph__Group__7__Impl"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5443:1: rule__TGraph__Group__7__Impl : ( '}' ) ;
    public final void rule__TGraph__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5447:1: ( ( '}' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5448:1: ( '}' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5448:1: ( '}' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5449:1: '}'
            {
             before(grammarAccess.getTGraphAccess().getRightCurlyBracketKeyword_7()); 
            match(input,37,FOLLOW_37_in_rule__TGraph__Group__7__Impl10985); 
             after(grammarAccess.getTGraphAccess().getRightCurlyBracketKeyword_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TGraph__Group__7__Impl"


    // $ANTLR start "rule__Element__Group_0__0"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5478:1: rule__Element__Group_0__0 : rule__Element__Group_0__0__Impl rule__Element__Group_0__1 ;
    public final void rule__Element__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5482:1: ( rule__Element__Group_0__0__Impl rule__Element__Group_0__1 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5483:2: rule__Element__Group_0__0__Impl rule__Element__Group_0__1
            {
            pushFollow(FOLLOW_rule__Element__Group_0__0__Impl_in_rule__Element__Group_0__011032);
            rule__Element__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Element__Group_0__1_in_rule__Element__Group_0__011035);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5490:1: rule__Element__Group_0__0__Impl : ( ruleNode ) ;
    public final void rule__Element__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5494:1: ( ( ruleNode ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5495:1: ( ruleNode )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5495:1: ( ruleNode )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5496:1: ruleNode
            {
             before(grammarAccess.getElementAccess().getNodeParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleNode_in_rule__Element__Group_0__0__Impl11062);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5507:1: rule__Element__Group_0__1 : rule__Element__Group_0__1__Impl ;
    public final void rule__Element__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5511:1: ( rule__Element__Group_0__1__Impl )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5512:2: rule__Element__Group_0__1__Impl
            {
            pushFollow(FOLLOW_rule__Element__Group_0__1__Impl_in_rule__Element__Group_0__111091);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5518:1: rule__Element__Group_0__1__Impl : ( ',' ) ;
    public final void rule__Element__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5522:1: ( ( ',' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5523:1: ( ',' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5523:1: ( ',' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5524:1: ','
            {
             before(grammarAccess.getElementAccess().getCommaKeyword_0_1()); 
            match(input,29,FOLLOW_29_in_rule__Element__Group_0__1__Impl11119); 
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5541:1: rule__Element__Group_1__0 : rule__Element__Group_1__0__Impl rule__Element__Group_1__1 ;
    public final void rule__Element__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5545:1: ( rule__Element__Group_1__0__Impl rule__Element__Group_1__1 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5546:2: rule__Element__Group_1__0__Impl rule__Element__Group_1__1
            {
            pushFollow(FOLLOW_rule__Element__Group_1__0__Impl_in_rule__Element__Group_1__011154);
            rule__Element__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Element__Group_1__1_in_rule__Element__Group_1__011157);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5553:1: rule__Element__Group_1__0__Impl : ( ruleArrows ) ;
    public final void rule__Element__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5557:1: ( ( ruleArrows ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5558:1: ( ruleArrows )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5558:1: ( ruleArrows )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5559:1: ruleArrows
            {
             before(grammarAccess.getElementAccess().getArrowsParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleArrows_in_rule__Element__Group_1__0__Impl11184);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5570:1: rule__Element__Group_1__1 : rule__Element__Group_1__1__Impl ;
    public final void rule__Element__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5574:1: ( rule__Element__Group_1__1__Impl )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5575:2: rule__Element__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__Element__Group_1__1__Impl_in_rule__Element__Group_1__111213);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5581:1: rule__Element__Group_1__1__Impl : ( ',' ) ;
    public final void rule__Element__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5585:1: ( ( ',' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5586:1: ( ',' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5586:1: ( ',' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5587:1: ','
            {
             before(grammarAccess.getElementAccess().getCommaKeyword_1_1()); 
            match(input,29,FOLLOW_29_in_rule__Element__Group_1__1__Impl11241); 
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5604:1: rule__Arrows__Group_0__0 : rule__Arrows__Group_0__0__Impl rule__Arrows__Group_0__1 ;
    public final void rule__Arrows__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5608:1: ( rule__Arrows__Group_0__0__Impl rule__Arrows__Group_0__1 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5609:2: rule__Arrows__Group_0__0__Impl rule__Arrows__Group_0__1
            {
            pushFollow(FOLLOW_rule__Arrows__Group_0__0__Impl_in_rule__Arrows__Group_0__011276);
            rule__Arrows__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Arrows__Group_0__1_in_rule__Arrows__Group_0__011279);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5616:1: rule__Arrows__Group_0__0__Impl : ( ( rule__Arrows__SrAssignment_0_0 ) ) ;
    public final void rule__Arrows__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5620:1: ( ( ( rule__Arrows__SrAssignment_0_0 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5621:1: ( ( rule__Arrows__SrAssignment_0_0 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5621:1: ( ( rule__Arrows__SrAssignment_0_0 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5622:1: ( rule__Arrows__SrAssignment_0_0 )
            {
             before(grammarAccess.getArrowsAccess().getSrAssignment_0_0()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5623:1: ( rule__Arrows__SrAssignment_0_0 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5623:2: rule__Arrows__SrAssignment_0_0
            {
            pushFollow(FOLLOW_rule__Arrows__SrAssignment_0_0_in_rule__Arrows__Group_0__0__Impl11306);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5633:1: rule__Arrows__Group_0__1 : rule__Arrows__Group_0__1__Impl rule__Arrows__Group_0__2 ;
    public final void rule__Arrows__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5637:1: ( rule__Arrows__Group_0__1__Impl rule__Arrows__Group_0__2 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5638:2: rule__Arrows__Group_0__1__Impl rule__Arrows__Group_0__2
            {
            pushFollow(FOLLOW_rule__Arrows__Group_0__1__Impl_in_rule__Arrows__Group_0__111336);
            rule__Arrows__Group_0__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Arrows__Group_0__2_in_rule__Arrows__Group_0__111339);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5645:1: rule__Arrows__Group_0__1__Impl : ( '-' ) ;
    public final void rule__Arrows__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5649:1: ( ( '-' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5650:1: ( '-' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5650:1: ( '-' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5651:1: '-'
            {
             before(grammarAccess.getArrowsAccess().getHyphenMinusKeyword_0_1()); 
            match(input,45,FOLLOW_45_in_rule__Arrows__Group_0__1__Impl11367); 
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5664:1: rule__Arrows__Group_0__2 : rule__Arrows__Group_0__2__Impl rule__Arrows__Group_0__3 ;
    public final void rule__Arrows__Group_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5668:1: ( rule__Arrows__Group_0__2__Impl rule__Arrows__Group_0__3 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5669:2: rule__Arrows__Group_0__2__Impl rule__Arrows__Group_0__3
            {
            pushFollow(FOLLOW_rule__Arrows__Group_0__2__Impl_in_rule__Arrows__Group_0__211398);
            rule__Arrows__Group_0__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Arrows__Group_0__3_in_rule__Arrows__Group_0__211401);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5676:1: rule__Arrows__Group_0__2__Impl : ( ( rule__Arrows__IdAssignment_0_2 ) ) ;
    public final void rule__Arrows__Group_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5680:1: ( ( ( rule__Arrows__IdAssignment_0_2 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5681:1: ( ( rule__Arrows__IdAssignment_0_2 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5681:1: ( ( rule__Arrows__IdAssignment_0_2 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5682:1: ( rule__Arrows__IdAssignment_0_2 )
            {
             before(grammarAccess.getArrowsAccess().getIdAssignment_0_2()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5683:1: ( rule__Arrows__IdAssignment_0_2 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5683:2: rule__Arrows__IdAssignment_0_2
            {
            pushFollow(FOLLOW_rule__Arrows__IdAssignment_0_2_in_rule__Arrows__Group_0__2__Impl11428);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5693:1: rule__Arrows__Group_0__3 : rule__Arrows__Group_0__3__Impl rule__Arrows__Group_0__4 ;
    public final void rule__Arrows__Group_0__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5697:1: ( rule__Arrows__Group_0__3__Impl rule__Arrows__Group_0__4 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5698:2: rule__Arrows__Group_0__3__Impl rule__Arrows__Group_0__4
            {
            pushFollow(FOLLOW_rule__Arrows__Group_0__3__Impl_in_rule__Arrows__Group_0__311458);
            rule__Arrows__Group_0__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Arrows__Group_0__4_in_rule__Arrows__Group_0__311461);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5705:1: rule__Arrows__Group_0__3__Impl : ( ':' ) ;
    public final void rule__Arrows__Group_0__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5709:1: ( ( ':' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5710:1: ( ':' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5710:1: ( ':' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5711:1: ':'
            {
             before(grammarAccess.getArrowsAccess().getColonKeyword_0_3()); 
            match(input,46,FOLLOW_46_in_rule__Arrows__Group_0__3__Impl11489); 
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5724:1: rule__Arrows__Group_0__4 : rule__Arrows__Group_0__4__Impl rule__Arrows__Group_0__5 ;
    public final void rule__Arrows__Group_0__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5728:1: ( rule__Arrows__Group_0__4__Impl rule__Arrows__Group_0__5 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5729:2: rule__Arrows__Group_0__4__Impl rule__Arrows__Group_0__5
            {
            pushFollow(FOLLOW_rule__Arrows__Group_0__4__Impl_in_rule__Arrows__Group_0__411520);
            rule__Arrows__Group_0__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Arrows__Group_0__5_in_rule__Arrows__Group_0__411523);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5736:1: rule__Arrows__Group_0__4__Impl : ( ( rule__Arrows__TypeAssignment_0_4 ) ) ;
    public final void rule__Arrows__Group_0__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5740:1: ( ( ( rule__Arrows__TypeAssignment_0_4 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5741:1: ( ( rule__Arrows__TypeAssignment_0_4 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5741:1: ( ( rule__Arrows__TypeAssignment_0_4 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5742:1: ( rule__Arrows__TypeAssignment_0_4 )
            {
             before(grammarAccess.getArrowsAccess().getTypeAssignment_0_4()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5743:1: ( rule__Arrows__TypeAssignment_0_4 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5743:2: rule__Arrows__TypeAssignment_0_4
            {
            pushFollow(FOLLOW_rule__Arrows__TypeAssignment_0_4_in_rule__Arrows__Group_0__4__Impl11550);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5753:1: rule__Arrows__Group_0__5 : rule__Arrows__Group_0__5__Impl rule__Arrows__Group_0__6 ;
    public final void rule__Arrows__Group_0__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5757:1: ( rule__Arrows__Group_0__5__Impl rule__Arrows__Group_0__6 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5758:2: rule__Arrows__Group_0__5__Impl rule__Arrows__Group_0__6
            {
            pushFollow(FOLLOW_rule__Arrows__Group_0__5__Impl_in_rule__Arrows__Group_0__511580);
            rule__Arrows__Group_0__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Arrows__Group_0__6_in_rule__Arrows__Group_0__511583);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5765:1: rule__Arrows__Group_0__5__Impl : ( '->' ) ;
    public final void rule__Arrows__Group_0__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5769:1: ( ( '->' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5770:1: ( '->' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5770:1: ( '->' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5771:1: '->'
            {
             before(grammarAccess.getArrowsAccess().getHyphenMinusGreaterThanSignKeyword_0_5()); 
            match(input,28,FOLLOW_28_in_rule__Arrows__Group_0__5__Impl11611); 
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5784:1: rule__Arrows__Group_0__6 : rule__Arrows__Group_0__6__Impl ;
    public final void rule__Arrows__Group_0__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5788:1: ( rule__Arrows__Group_0__6__Impl )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5789:2: rule__Arrows__Group_0__6__Impl
            {
            pushFollow(FOLLOW_rule__Arrows__Group_0__6__Impl_in_rule__Arrows__Group_0__611642);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5795:1: rule__Arrows__Group_0__6__Impl : ( ( rule__Arrows__NextAssignment_0_6 ) ) ;
    public final void rule__Arrows__Group_0__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5799:1: ( ( ( rule__Arrows__NextAssignment_0_6 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5800:1: ( ( rule__Arrows__NextAssignment_0_6 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5800:1: ( ( rule__Arrows__NextAssignment_0_6 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5801:1: ( rule__Arrows__NextAssignment_0_6 )
            {
             before(grammarAccess.getArrowsAccess().getNextAssignment_0_6()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5802:1: ( rule__Arrows__NextAssignment_0_6 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5802:2: rule__Arrows__NextAssignment_0_6
            {
            pushFollow(FOLLOW_rule__Arrows__NextAssignment_0_6_in_rule__Arrows__Group_0__6__Impl11669);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5826:1: rule__Arrow__Group_0__0 : rule__Arrow__Group_0__0__Impl rule__Arrow__Group_0__1 ;
    public final void rule__Arrow__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5830:1: ( rule__Arrow__Group_0__0__Impl rule__Arrow__Group_0__1 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5831:2: rule__Arrow__Group_0__0__Impl rule__Arrow__Group_0__1
            {
            pushFollow(FOLLOW_rule__Arrow__Group_0__0__Impl_in_rule__Arrow__Group_0__011713);
            rule__Arrow__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Arrow__Group_0__1_in_rule__Arrow__Group_0__011716);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5838:1: rule__Arrow__Group_0__0__Impl : ( ( rule__Arrow__SrAssignment_0_0 ) ) ;
    public final void rule__Arrow__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5842:1: ( ( ( rule__Arrow__SrAssignment_0_0 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5843:1: ( ( rule__Arrow__SrAssignment_0_0 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5843:1: ( ( rule__Arrow__SrAssignment_0_0 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5844:1: ( rule__Arrow__SrAssignment_0_0 )
            {
             before(grammarAccess.getArrowAccess().getSrAssignment_0_0()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5845:1: ( rule__Arrow__SrAssignment_0_0 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5845:2: rule__Arrow__SrAssignment_0_0
            {
            pushFollow(FOLLOW_rule__Arrow__SrAssignment_0_0_in_rule__Arrow__Group_0__0__Impl11743);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5855:1: rule__Arrow__Group_0__1 : rule__Arrow__Group_0__1__Impl rule__Arrow__Group_0__2 ;
    public final void rule__Arrow__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5859:1: ( rule__Arrow__Group_0__1__Impl rule__Arrow__Group_0__2 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5860:2: rule__Arrow__Group_0__1__Impl rule__Arrow__Group_0__2
            {
            pushFollow(FOLLOW_rule__Arrow__Group_0__1__Impl_in_rule__Arrow__Group_0__111773);
            rule__Arrow__Group_0__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Arrow__Group_0__2_in_rule__Arrow__Group_0__111776);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5867:1: rule__Arrow__Group_0__1__Impl : ( '-' ) ;
    public final void rule__Arrow__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5871:1: ( ( '-' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5872:1: ( '-' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5872:1: ( '-' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5873:1: '-'
            {
             before(grammarAccess.getArrowAccess().getHyphenMinusKeyword_0_1()); 
            match(input,45,FOLLOW_45_in_rule__Arrow__Group_0__1__Impl11804); 
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5886:1: rule__Arrow__Group_0__2 : rule__Arrow__Group_0__2__Impl rule__Arrow__Group_0__3 ;
    public final void rule__Arrow__Group_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5890:1: ( rule__Arrow__Group_0__2__Impl rule__Arrow__Group_0__3 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5891:2: rule__Arrow__Group_0__2__Impl rule__Arrow__Group_0__3
            {
            pushFollow(FOLLOW_rule__Arrow__Group_0__2__Impl_in_rule__Arrow__Group_0__211835);
            rule__Arrow__Group_0__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Arrow__Group_0__3_in_rule__Arrow__Group_0__211838);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5898:1: rule__Arrow__Group_0__2__Impl : ( ( rule__Arrow__IdAssignment_0_2 ) ) ;
    public final void rule__Arrow__Group_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5902:1: ( ( ( rule__Arrow__IdAssignment_0_2 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5903:1: ( ( rule__Arrow__IdAssignment_0_2 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5903:1: ( ( rule__Arrow__IdAssignment_0_2 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5904:1: ( rule__Arrow__IdAssignment_0_2 )
            {
             before(grammarAccess.getArrowAccess().getIdAssignment_0_2()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5905:1: ( rule__Arrow__IdAssignment_0_2 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5905:2: rule__Arrow__IdAssignment_0_2
            {
            pushFollow(FOLLOW_rule__Arrow__IdAssignment_0_2_in_rule__Arrow__Group_0__2__Impl11865);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5915:1: rule__Arrow__Group_0__3 : rule__Arrow__Group_0__3__Impl rule__Arrow__Group_0__4 ;
    public final void rule__Arrow__Group_0__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5919:1: ( rule__Arrow__Group_0__3__Impl rule__Arrow__Group_0__4 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5920:2: rule__Arrow__Group_0__3__Impl rule__Arrow__Group_0__4
            {
            pushFollow(FOLLOW_rule__Arrow__Group_0__3__Impl_in_rule__Arrow__Group_0__311895);
            rule__Arrow__Group_0__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Arrow__Group_0__4_in_rule__Arrow__Group_0__311898);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5927:1: rule__Arrow__Group_0__3__Impl : ( ':' ) ;
    public final void rule__Arrow__Group_0__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5931:1: ( ( ':' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5932:1: ( ':' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5932:1: ( ':' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5933:1: ':'
            {
             before(grammarAccess.getArrowAccess().getColonKeyword_0_3()); 
            match(input,46,FOLLOW_46_in_rule__Arrow__Group_0__3__Impl11926); 
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5946:1: rule__Arrow__Group_0__4 : rule__Arrow__Group_0__4__Impl rule__Arrow__Group_0__5 ;
    public final void rule__Arrow__Group_0__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5950:1: ( rule__Arrow__Group_0__4__Impl rule__Arrow__Group_0__5 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5951:2: rule__Arrow__Group_0__4__Impl rule__Arrow__Group_0__5
            {
            pushFollow(FOLLOW_rule__Arrow__Group_0__4__Impl_in_rule__Arrow__Group_0__411957);
            rule__Arrow__Group_0__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Arrow__Group_0__5_in_rule__Arrow__Group_0__411960);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5958:1: rule__Arrow__Group_0__4__Impl : ( '*' ) ;
    public final void rule__Arrow__Group_0__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5962:1: ( ( '*' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5963:1: ( '*' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5963:1: ( '*' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5964:1: '*'
            {
             before(grammarAccess.getArrowAccess().getAsteriskKeyword_0_4()); 
            match(input,47,FOLLOW_47_in_rule__Arrow__Group_0__4__Impl11988); 
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5977:1: rule__Arrow__Group_0__5 : rule__Arrow__Group_0__5__Impl rule__Arrow__Group_0__6 ;
    public final void rule__Arrow__Group_0__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5981:1: ( rule__Arrow__Group_0__5__Impl rule__Arrow__Group_0__6 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5982:2: rule__Arrow__Group_0__5__Impl rule__Arrow__Group_0__6
            {
            pushFollow(FOLLOW_rule__Arrow__Group_0__5__Impl_in_rule__Arrow__Group_0__512019);
            rule__Arrow__Group_0__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Arrow__Group_0__6_in_rule__Arrow__Group_0__512022);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5989:1: rule__Arrow__Group_0__5__Impl : ( '->' ) ;
    public final void rule__Arrow__Group_0__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5993:1: ( ( '->' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5994:1: ( '->' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5994:1: ( '->' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:5995:1: '->'
            {
             before(grammarAccess.getArrowAccess().getHyphenMinusGreaterThanSignKeyword_0_5()); 
            match(input,28,FOLLOW_28_in_rule__Arrow__Group_0__5__Impl12050); 
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6008:1: rule__Arrow__Group_0__6 : rule__Arrow__Group_0__6__Impl ;
    public final void rule__Arrow__Group_0__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6012:1: ( rule__Arrow__Group_0__6__Impl )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6013:2: rule__Arrow__Group_0__6__Impl
            {
            pushFollow(FOLLOW_rule__Arrow__Group_0__6__Impl_in_rule__Arrow__Group_0__612081);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6019:1: rule__Arrow__Group_0__6__Impl : ( ( rule__Arrow__TgDataTypeAssignment_0_6 ) ) ;
    public final void rule__Arrow__Group_0__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6023:1: ( ( ( rule__Arrow__TgDataTypeAssignment_0_6 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6024:1: ( ( rule__Arrow__TgDataTypeAssignment_0_6 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6024:1: ( ( rule__Arrow__TgDataTypeAssignment_0_6 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6025:1: ( rule__Arrow__TgDataTypeAssignment_0_6 )
            {
             before(grammarAccess.getArrowAccess().getTgDataTypeAssignment_0_6()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6026:1: ( rule__Arrow__TgDataTypeAssignment_0_6 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6026:2: rule__Arrow__TgDataTypeAssignment_0_6
            {
            pushFollow(FOLLOW_rule__Arrow__TgDataTypeAssignment_0_6_in_rule__Arrow__Group_0__6__Impl12108);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6050:1: rule__Arrow__Group_1__0 : rule__Arrow__Group_1__0__Impl rule__Arrow__Group_1__1 ;
    public final void rule__Arrow__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6054:1: ( rule__Arrow__Group_1__0__Impl rule__Arrow__Group_1__1 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6055:2: rule__Arrow__Group_1__0__Impl rule__Arrow__Group_1__1
            {
            pushFollow(FOLLOW_rule__Arrow__Group_1__0__Impl_in_rule__Arrow__Group_1__012152);
            rule__Arrow__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Arrow__Group_1__1_in_rule__Arrow__Group_1__012155);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6062:1: rule__Arrow__Group_1__0__Impl : ( ( rule__Arrow__SrAssignment_1_0 ) ) ;
    public final void rule__Arrow__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6066:1: ( ( ( rule__Arrow__SrAssignment_1_0 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6067:1: ( ( rule__Arrow__SrAssignment_1_0 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6067:1: ( ( rule__Arrow__SrAssignment_1_0 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6068:1: ( rule__Arrow__SrAssignment_1_0 )
            {
             before(grammarAccess.getArrowAccess().getSrAssignment_1_0()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6069:1: ( rule__Arrow__SrAssignment_1_0 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6069:2: rule__Arrow__SrAssignment_1_0
            {
            pushFollow(FOLLOW_rule__Arrow__SrAssignment_1_0_in_rule__Arrow__Group_1__0__Impl12182);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6079:1: rule__Arrow__Group_1__1 : rule__Arrow__Group_1__1__Impl rule__Arrow__Group_1__2 ;
    public final void rule__Arrow__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6083:1: ( rule__Arrow__Group_1__1__Impl rule__Arrow__Group_1__2 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6084:2: rule__Arrow__Group_1__1__Impl rule__Arrow__Group_1__2
            {
            pushFollow(FOLLOW_rule__Arrow__Group_1__1__Impl_in_rule__Arrow__Group_1__112212);
            rule__Arrow__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Arrow__Group_1__2_in_rule__Arrow__Group_1__112215);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6091:1: rule__Arrow__Group_1__1__Impl : ( '-' ) ;
    public final void rule__Arrow__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6095:1: ( ( '-' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6096:1: ( '-' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6096:1: ( '-' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6097:1: '-'
            {
             before(grammarAccess.getArrowAccess().getHyphenMinusKeyword_1_1()); 
            match(input,45,FOLLOW_45_in_rule__Arrow__Group_1__1__Impl12243); 
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6110:1: rule__Arrow__Group_1__2 : rule__Arrow__Group_1__2__Impl rule__Arrow__Group_1__3 ;
    public final void rule__Arrow__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6114:1: ( rule__Arrow__Group_1__2__Impl rule__Arrow__Group_1__3 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6115:2: rule__Arrow__Group_1__2__Impl rule__Arrow__Group_1__3
            {
            pushFollow(FOLLOW_rule__Arrow__Group_1__2__Impl_in_rule__Arrow__Group_1__212274);
            rule__Arrow__Group_1__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Arrow__Group_1__3_in_rule__Arrow__Group_1__212277);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6122:1: rule__Arrow__Group_1__2__Impl : ( ( rule__Arrow__IdAssignment_1_2 ) ) ;
    public final void rule__Arrow__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6126:1: ( ( ( rule__Arrow__IdAssignment_1_2 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6127:1: ( ( rule__Arrow__IdAssignment_1_2 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6127:1: ( ( rule__Arrow__IdAssignment_1_2 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6128:1: ( rule__Arrow__IdAssignment_1_2 )
            {
             before(grammarAccess.getArrowAccess().getIdAssignment_1_2()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6129:1: ( rule__Arrow__IdAssignment_1_2 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6129:2: rule__Arrow__IdAssignment_1_2
            {
            pushFollow(FOLLOW_rule__Arrow__IdAssignment_1_2_in_rule__Arrow__Group_1__2__Impl12304);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6139:1: rule__Arrow__Group_1__3 : rule__Arrow__Group_1__3__Impl rule__Arrow__Group_1__4 ;
    public final void rule__Arrow__Group_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6143:1: ( rule__Arrow__Group_1__3__Impl rule__Arrow__Group_1__4 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6144:2: rule__Arrow__Group_1__3__Impl rule__Arrow__Group_1__4
            {
            pushFollow(FOLLOW_rule__Arrow__Group_1__3__Impl_in_rule__Arrow__Group_1__312334);
            rule__Arrow__Group_1__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Arrow__Group_1__4_in_rule__Arrow__Group_1__312337);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6151:1: rule__Arrow__Group_1__3__Impl : ( ':' ) ;
    public final void rule__Arrow__Group_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6155:1: ( ( ':' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6156:1: ( ':' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6156:1: ( ':' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6157:1: ':'
            {
             before(grammarAccess.getArrowAccess().getColonKeyword_1_3()); 
            match(input,46,FOLLOW_46_in_rule__Arrow__Group_1__3__Impl12365); 
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6170:1: rule__Arrow__Group_1__4 : rule__Arrow__Group_1__4__Impl rule__Arrow__Group_1__5 ;
    public final void rule__Arrow__Group_1__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6174:1: ( rule__Arrow__Group_1__4__Impl rule__Arrow__Group_1__5 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6175:2: rule__Arrow__Group_1__4__Impl rule__Arrow__Group_1__5
            {
            pushFollow(FOLLOW_rule__Arrow__Group_1__4__Impl_in_rule__Arrow__Group_1__412396);
            rule__Arrow__Group_1__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Arrow__Group_1__5_in_rule__Arrow__Group_1__412399);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6182:1: rule__Arrow__Group_1__4__Impl : ( ( rule__Arrow__TypeAssignment_1_4 ) ) ;
    public final void rule__Arrow__Group_1__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6186:1: ( ( ( rule__Arrow__TypeAssignment_1_4 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6187:1: ( ( rule__Arrow__TypeAssignment_1_4 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6187:1: ( ( rule__Arrow__TypeAssignment_1_4 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6188:1: ( rule__Arrow__TypeAssignment_1_4 )
            {
             before(grammarAccess.getArrowAccess().getTypeAssignment_1_4()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6189:1: ( rule__Arrow__TypeAssignment_1_4 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6189:2: rule__Arrow__TypeAssignment_1_4
            {
            pushFollow(FOLLOW_rule__Arrow__TypeAssignment_1_4_in_rule__Arrow__Group_1__4__Impl12426);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6199:1: rule__Arrow__Group_1__5 : rule__Arrow__Group_1__5__Impl rule__Arrow__Group_1__6 ;
    public final void rule__Arrow__Group_1__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6203:1: ( rule__Arrow__Group_1__5__Impl rule__Arrow__Group_1__6 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6204:2: rule__Arrow__Group_1__5__Impl rule__Arrow__Group_1__6
            {
            pushFollow(FOLLOW_rule__Arrow__Group_1__5__Impl_in_rule__Arrow__Group_1__512456);
            rule__Arrow__Group_1__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Arrow__Group_1__6_in_rule__Arrow__Group_1__512459);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6211:1: rule__Arrow__Group_1__5__Impl : ( '->' ) ;
    public final void rule__Arrow__Group_1__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6215:1: ( ( '->' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6216:1: ( '->' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6216:1: ( '->' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6217:1: '->'
            {
             before(grammarAccess.getArrowAccess().getHyphenMinusGreaterThanSignKeyword_1_5()); 
            match(input,28,FOLLOW_28_in_rule__Arrow__Group_1__5__Impl12487); 
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6230:1: rule__Arrow__Group_1__6 : rule__Arrow__Group_1__6__Impl ;
    public final void rule__Arrow__Group_1__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6234:1: ( rule__Arrow__Group_1__6__Impl )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6235:2: rule__Arrow__Group_1__6__Impl
            {
            pushFollow(FOLLOW_rule__Arrow__Group_1__6__Impl_in_rule__Arrow__Group_1__612518);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6241:1: rule__Arrow__Group_1__6__Impl : ( ( rule__Arrow__TgValueAssignment_1_6 ) ) ;
    public final void rule__Arrow__Group_1__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6245:1: ( ( ( rule__Arrow__TgValueAssignment_1_6 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6246:1: ( ( rule__Arrow__TgValueAssignment_1_6 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6246:1: ( ( rule__Arrow__TgValueAssignment_1_6 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6247:1: ( rule__Arrow__TgValueAssignment_1_6 )
            {
             before(grammarAccess.getArrowAccess().getTgValueAssignment_1_6()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6248:1: ( rule__Arrow__TgValueAssignment_1_6 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6248:2: rule__Arrow__TgValueAssignment_1_6
            {
            pushFollow(FOLLOW_rule__Arrow__TgValueAssignment_1_6_in_rule__Arrow__Group_1__6__Impl12545);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6272:1: rule__Arrow__Group_2__0 : rule__Arrow__Group_2__0__Impl rule__Arrow__Group_2__1 ;
    public final void rule__Arrow__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6276:1: ( rule__Arrow__Group_2__0__Impl rule__Arrow__Group_2__1 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6277:2: rule__Arrow__Group_2__0__Impl rule__Arrow__Group_2__1
            {
            pushFollow(FOLLOW_rule__Arrow__Group_2__0__Impl_in_rule__Arrow__Group_2__012589);
            rule__Arrow__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Arrow__Group_2__1_in_rule__Arrow__Group_2__012592);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6284:1: rule__Arrow__Group_2__0__Impl : ( ( rule__Arrow__SrAssignment_2_0 ) ) ;
    public final void rule__Arrow__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6288:1: ( ( ( rule__Arrow__SrAssignment_2_0 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6289:1: ( ( rule__Arrow__SrAssignment_2_0 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6289:1: ( ( rule__Arrow__SrAssignment_2_0 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6290:1: ( rule__Arrow__SrAssignment_2_0 )
            {
             before(grammarAccess.getArrowAccess().getSrAssignment_2_0()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6291:1: ( rule__Arrow__SrAssignment_2_0 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6291:2: rule__Arrow__SrAssignment_2_0
            {
            pushFollow(FOLLOW_rule__Arrow__SrAssignment_2_0_in_rule__Arrow__Group_2__0__Impl12619);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6301:1: rule__Arrow__Group_2__1 : rule__Arrow__Group_2__1__Impl rule__Arrow__Group_2__2 ;
    public final void rule__Arrow__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6305:1: ( rule__Arrow__Group_2__1__Impl rule__Arrow__Group_2__2 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6306:2: rule__Arrow__Group_2__1__Impl rule__Arrow__Group_2__2
            {
            pushFollow(FOLLOW_rule__Arrow__Group_2__1__Impl_in_rule__Arrow__Group_2__112649);
            rule__Arrow__Group_2__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Arrow__Group_2__2_in_rule__Arrow__Group_2__112652);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6313:1: rule__Arrow__Group_2__1__Impl : ( '-' ) ;
    public final void rule__Arrow__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6317:1: ( ( '-' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6318:1: ( '-' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6318:1: ( '-' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6319:1: '-'
            {
             before(grammarAccess.getArrowAccess().getHyphenMinusKeyword_2_1()); 
            match(input,45,FOLLOW_45_in_rule__Arrow__Group_2__1__Impl12680); 
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6332:1: rule__Arrow__Group_2__2 : rule__Arrow__Group_2__2__Impl rule__Arrow__Group_2__3 ;
    public final void rule__Arrow__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6336:1: ( rule__Arrow__Group_2__2__Impl rule__Arrow__Group_2__3 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6337:2: rule__Arrow__Group_2__2__Impl rule__Arrow__Group_2__3
            {
            pushFollow(FOLLOW_rule__Arrow__Group_2__2__Impl_in_rule__Arrow__Group_2__212711);
            rule__Arrow__Group_2__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Arrow__Group_2__3_in_rule__Arrow__Group_2__212714);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6344:1: rule__Arrow__Group_2__2__Impl : ( ( rule__Arrow__IdAssignment_2_2 ) ) ;
    public final void rule__Arrow__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6348:1: ( ( ( rule__Arrow__IdAssignment_2_2 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6349:1: ( ( rule__Arrow__IdAssignment_2_2 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6349:1: ( ( rule__Arrow__IdAssignment_2_2 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6350:1: ( rule__Arrow__IdAssignment_2_2 )
            {
             before(grammarAccess.getArrowAccess().getIdAssignment_2_2()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6351:1: ( rule__Arrow__IdAssignment_2_2 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6351:2: rule__Arrow__IdAssignment_2_2
            {
            pushFollow(FOLLOW_rule__Arrow__IdAssignment_2_2_in_rule__Arrow__Group_2__2__Impl12741);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6361:1: rule__Arrow__Group_2__3 : rule__Arrow__Group_2__3__Impl rule__Arrow__Group_2__4 ;
    public final void rule__Arrow__Group_2__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6365:1: ( rule__Arrow__Group_2__3__Impl rule__Arrow__Group_2__4 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6366:2: rule__Arrow__Group_2__3__Impl rule__Arrow__Group_2__4
            {
            pushFollow(FOLLOW_rule__Arrow__Group_2__3__Impl_in_rule__Arrow__Group_2__312771);
            rule__Arrow__Group_2__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Arrow__Group_2__4_in_rule__Arrow__Group_2__312774);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6373:1: rule__Arrow__Group_2__3__Impl : ( ':' ) ;
    public final void rule__Arrow__Group_2__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6377:1: ( ( ':' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6378:1: ( ':' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6378:1: ( ':' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6379:1: ':'
            {
             before(grammarAccess.getArrowAccess().getColonKeyword_2_3()); 
            match(input,46,FOLLOW_46_in_rule__Arrow__Group_2__3__Impl12802); 
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6392:1: rule__Arrow__Group_2__4 : rule__Arrow__Group_2__4__Impl rule__Arrow__Group_2__5 ;
    public final void rule__Arrow__Group_2__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6396:1: ( rule__Arrow__Group_2__4__Impl rule__Arrow__Group_2__5 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6397:2: rule__Arrow__Group_2__4__Impl rule__Arrow__Group_2__5
            {
            pushFollow(FOLLOW_rule__Arrow__Group_2__4__Impl_in_rule__Arrow__Group_2__412833);
            rule__Arrow__Group_2__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Arrow__Group_2__5_in_rule__Arrow__Group_2__412836);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6404:1: rule__Arrow__Group_2__4__Impl : ( ( rule__Arrow__TypeAssignment_2_4 ) ) ;
    public final void rule__Arrow__Group_2__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6408:1: ( ( ( rule__Arrow__TypeAssignment_2_4 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6409:1: ( ( rule__Arrow__TypeAssignment_2_4 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6409:1: ( ( rule__Arrow__TypeAssignment_2_4 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6410:1: ( rule__Arrow__TypeAssignment_2_4 )
            {
             before(grammarAccess.getArrowAccess().getTypeAssignment_2_4()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6411:1: ( rule__Arrow__TypeAssignment_2_4 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6411:2: rule__Arrow__TypeAssignment_2_4
            {
            pushFollow(FOLLOW_rule__Arrow__TypeAssignment_2_4_in_rule__Arrow__Group_2__4__Impl12863);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6421:1: rule__Arrow__Group_2__5 : rule__Arrow__Group_2__5__Impl rule__Arrow__Group_2__6 ;
    public final void rule__Arrow__Group_2__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6425:1: ( rule__Arrow__Group_2__5__Impl rule__Arrow__Group_2__6 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6426:2: rule__Arrow__Group_2__5__Impl rule__Arrow__Group_2__6
            {
            pushFollow(FOLLOW_rule__Arrow__Group_2__5__Impl_in_rule__Arrow__Group_2__512893);
            rule__Arrow__Group_2__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Arrow__Group_2__6_in_rule__Arrow__Group_2__512896);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6433:1: rule__Arrow__Group_2__5__Impl : ( '->' ) ;
    public final void rule__Arrow__Group_2__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6437:1: ( ( '->' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6438:1: ( '->' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6438:1: ( '->' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6439:1: '->'
            {
             before(grammarAccess.getArrowAccess().getHyphenMinusGreaterThanSignKeyword_2_5()); 
            match(input,28,FOLLOW_28_in_rule__Arrow__Group_2__5__Impl12924); 
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6452:1: rule__Arrow__Group_2__6 : rule__Arrow__Group_2__6__Impl ;
    public final void rule__Arrow__Group_2__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6456:1: ( rule__Arrow__Group_2__6__Impl )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6457:2: rule__Arrow__Group_2__6__Impl
            {
            pushFollow(FOLLOW_rule__Arrow__Group_2__6__Impl_in_rule__Arrow__Group_2__612955);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6463:1: rule__Arrow__Group_2__6__Impl : ( ( rule__Arrow__TgNodeAssignment_2_6 ) ) ;
    public final void rule__Arrow__Group_2__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6467:1: ( ( ( rule__Arrow__TgNodeAssignment_2_6 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6468:1: ( ( rule__Arrow__TgNodeAssignment_2_6 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6468:1: ( ( rule__Arrow__TgNodeAssignment_2_6 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6469:1: ( rule__Arrow__TgNodeAssignment_2_6 )
            {
             before(grammarAccess.getArrowAccess().getTgNodeAssignment_2_6()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6470:1: ( rule__Arrow__TgNodeAssignment_2_6 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6470:2: rule__Arrow__TgNodeAssignment_2_6
            {
            pushFollow(FOLLOW_rule__Arrow__TgNodeAssignment_2_6_in_rule__Arrow__Group_2__6__Impl12982);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6494:1: rule__Node__Group__0 : rule__Node__Group__0__Impl rule__Node__Group__1 ;
    public final void rule__Node__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6498:1: ( rule__Node__Group__0__Impl rule__Node__Group__1 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6499:2: rule__Node__Group__0__Impl rule__Node__Group__1
            {
            pushFollow(FOLLOW_rule__Node__Group__0__Impl_in_rule__Node__Group__013026);
            rule__Node__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Node__Group__1_in_rule__Node__Group__013029);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6506:1: rule__Node__Group__0__Impl : ( ( rule__Node__IdAssignment_0 ) ) ;
    public final void rule__Node__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6510:1: ( ( ( rule__Node__IdAssignment_0 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6511:1: ( ( rule__Node__IdAssignment_0 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6511:1: ( ( rule__Node__IdAssignment_0 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6512:1: ( rule__Node__IdAssignment_0 )
            {
             before(grammarAccess.getNodeAccess().getIdAssignment_0()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6513:1: ( rule__Node__IdAssignment_0 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6513:2: rule__Node__IdAssignment_0
            {
            pushFollow(FOLLOW_rule__Node__IdAssignment_0_in_rule__Node__Group__0__Impl13056);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6523:1: rule__Node__Group__1 : rule__Node__Group__1__Impl rule__Node__Group__2 ;
    public final void rule__Node__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6527:1: ( rule__Node__Group__1__Impl rule__Node__Group__2 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6528:2: rule__Node__Group__1__Impl rule__Node__Group__2
            {
            pushFollow(FOLLOW_rule__Node__Group__1__Impl_in_rule__Node__Group__113086);
            rule__Node__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Node__Group__2_in_rule__Node__Group__113089);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6535:1: rule__Node__Group__1__Impl : ( ':' ) ;
    public final void rule__Node__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6539:1: ( ( ':' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6540:1: ( ':' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6540:1: ( ':' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6541:1: ':'
            {
             before(grammarAccess.getNodeAccess().getColonKeyword_1()); 
            match(input,46,FOLLOW_46_in_rule__Node__Group__1__Impl13117); 
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6554:1: rule__Node__Group__2 : rule__Node__Group__2__Impl ;
    public final void rule__Node__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6558:1: ( rule__Node__Group__2__Impl )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6559:2: rule__Node__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__Node__Group__2__Impl_in_rule__Node__Group__213148);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6565:1: rule__Node__Group__2__Impl : ( ( rule__Node__TypeAssignment_2 ) ) ;
    public final void rule__Node__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6569:1: ( ( ( rule__Node__TypeAssignment_2 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6570:1: ( ( rule__Node__TypeAssignment_2 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6570:1: ( ( rule__Node__TypeAssignment_2 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6571:1: ( rule__Node__TypeAssignment_2 )
            {
             before(grammarAccess.getNodeAccess().getTypeAssignment_2()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6572:1: ( rule__Node__TypeAssignment_2 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6572:2: rule__Node__TypeAssignment_2
            {
            pushFollow(FOLLOW_rule__Node__TypeAssignment_2_in_rule__Node__Group__2__Impl13175);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6588:1: rule__AttributeValue__Group__0 : rule__AttributeValue__Group__0__Impl rule__AttributeValue__Group__1 ;
    public final void rule__AttributeValue__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6592:1: ( rule__AttributeValue__Group__0__Impl rule__AttributeValue__Group__1 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6593:2: rule__AttributeValue__Group__0__Impl rule__AttributeValue__Group__1
            {
            pushFollow(FOLLOW_rule__AttributeValue__Group__0__Impl_in_rule__AttributeValue__Group__013211);
            rule__AttributeValue__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__AttributeValue__Group__1_in_rule__AttributeValue__Group__013214);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6600:1: rule__AttributeValue__Group__0__Impl : ( '[' ) ;
    public final void rule__AttributeValue__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6604:1: ( ( '[' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6605:1: ( '[' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6605:1: ( '[' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6606:1: '['
            {
             before(grammarAccess.getAttributeValueAccess().getLeftSquareBracketKeyword_0()); 
            match(input,48,FOLLOW_48_in_rule__AttributeValue__Group__0__Impl13242); 
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6619:1: rule__AttributeValue__Group__1 : rule__AttributeValue__Group__1__Impl rule__AttributeValue__Group__2 ;
    public final void rule__AttributeValue__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6623:1: ( rule__AttributeValue__Group__1__Impl rule__AttributeValue__Group__2 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6624:2: rule__AttributeValue__Group__1__Impl rule__AttributeValue__Group__2
            {
            pushFollow(FOLLOW_rule__AttributeValue__Group__1__Impl_in_rule__AttributeValue__Group__113273);
            rule__AttributeValue__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__AttributeValue__Group__2_in_rule__AttributeValue__Group__113276);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6631:1: rule__AttributeValue__Group__1__Impl : ( ( rule__AttributeValue__ValueAssignment_1 ) ) ;
    public final void rule__AttributeValue__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6635:1: ( ( ( rule__AttributeValue__ValueAssignment_1 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6636:1: ( ( rule__AttributeValue__ValueAssignment_1 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6636:1: ( ( rule__AttributeValue__ValueAssignment_1 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6637:1: ( rule__AttributeValue__ValueAssignment_1 )
            {
             before(grammarAccess.getAttributeValueAccess().getValueAssignment_1()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6638:1: ( rule__AttributeValue__ValueAssignment_1 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6638:2: rule__AttributeValue__ValueAssignment_1
            {
            pushFollow(FOLLOW_rule__AttributeValue__ValueAssignment_1_in_rule__AttributeValue__Group__1__Impl13303);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6648:1: rule__AttributeValue__Group__2 : rule__AttributeValue__Group__2__Impl ;
    public final void rule__AttributeValue__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6652:1: ( rule__AttributeValue__Group__2__Impl )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6653:2: rule__AttributeValue__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__AttributeValue__Group__2__Impl_in_rule__AttributeValue__Group__213333);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6659:1: rule__AttributeValue__Group__2__Impl : ( ']' ) ;
    public final void rule__AttributeValue__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6663:1: ( ( ']' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6664:1: ( ']' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6664:1: ( ']' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6665:1: ']'
            {
             before(grammarAccess.getAttributeValueAccess().getRightSquareBracketKeyword_2()); 
            match(input,49,FOLLOW_49_in_rule__AttributeValue__Group__2__Impl13361); 
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6684:1: rule__DpfId__Group__0 : rule__DpfId__Group__0__Impl rule__DpfId__Group__1 ;
    public final void rule__DpfId__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6688:1: ( rule__DpfId__Group__0__Impl rule__DpfId__Group__1 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6689:2: rule__DpfId__Group__0__Impl rule__DpfId__Group__1
            {
            pushFollow(FOLLOW_rule__DpfId__Group__0__Impl_in_rule__DpfId__Group__013398);
            rule__DpfId__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DpfId__Group__1_in_rule__DpfId__Group__013401);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6696:1: rule__DpfId__Group__0__Impl : ( ( rule__DpfId__NameAssignment_0 ) ) ;
    public final void rule__DpfId__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6700:1: ( ( ( rule__DpfId__NameAssignment_0 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6701:1: ( ( rule__DpfId__NameAssignment_0 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6701:1: ( ( rule__DpfId__NameAssignment_0 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6702:1: ( rule__DpfId__NameAssignment_0 )
            {
             before(grammarAccess.getDpfIdAccess().getNameAssignment_0()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6703:1: ( rule__DpfId__NameAssignment_0 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6703:2: rule__DpfId__NameAssignment_0
            {
            pushFollow(FOLLOW_rule__DpfId__NameAssignment_0_in_rule__DpfId__Group__0__Impl13428);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6713:1: rule__DpfId__Group__1 : rule__DpfId__Group__1__Impl ;
    public final void rule__DpfId__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6717:1: ( rule__DpfId__Group__1__Impl )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6718:2: rule__DpfId__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__DpfId__Group__1__Impl_in_rule__DpfId__Group__113458);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6724:1: rule__DpfId__Group__1__Impl : ( ( rule__DpfId__Group_1__0 )? ) ;
    public final void rule__DpfId__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6728:1: ( ( ( rule__DpfId__Group_1__0 )? ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6729:1: ( ( rule__DpfId__Group_1__0 )? )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6729:1: ( ( rule__DpfId__Group_1__0 )? )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6730:1: ( rule__DpfId__Group_1__0 )?
            {
             before(grammarAccess.getDpfIdAccess().getGroup_1()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6731:1: ( rule__DpfId__Group_1__0 )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==50) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6731:2: rule__DpfId__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__DpfId__Group_1__0_in_rule__DpfId__Group__1__Impl13485);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6745:1: rule__DpfId__Group_1__0 : rule__DpfId__Group_1__0__Impl rule__DpfId__Group_1__1 ;
    public final void rule__DpfId__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6749:1: ( rule__DpfId__Group_1__0__Impl rule__DpfId__Group_1__1 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6750:2: rule__DpfId__Group_1__0__Impl rule__DpfId__Group_1__1
            {
            pushFollow(FOLLOW_rule__DpfId__Group_1__0__Impl_in_rule__DpfId__Group_1__013520);
            rule__DpfId__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DpfId__Group_1__1_in_rule__DpfId__Group_1__013523);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6757:1: rule__DpfId__Group_1__0__Impl : ( '@' ) ;
    public final void rule__DpfId__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6761:1: ( ( '@' ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6762:1: ( '@' )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6762:1: ( '@' )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6763:1: '@'
            {
             before(grammarAccess.getDpfIdAccess().getCommercialAtKeyword_1_0()); 
            match(input,50,FOLLOW_50_in_rule__DpfId__Group_1__0__Impl13551); 
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6776:1: rule__DpfId__Group_1__1 : rule__DpfId__Group_1__1__Impl ;
    public final void rule__DpfId__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6780:1: ( rule__DpfId__Group_1__1__Impl )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6781:2: rule__DpfId__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__DpfId__Group_1__1__Impl_in_rule__DpfId__Group_1__113582);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6787:1: rule__DpfId__Group_1__1__Impl : ( ( rule__DpfId__IdAssignment_1_1 ) ) ;
    public final void rule__DpfId__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6791:1: ( ( ( rule__DpfId__IdAssignment_1_1 ) ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6792:1: ( ( rule__DpfId__IdAssignment_1_1 ) )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6792:1: ( ( rule__DpfId__IdAssignment_1_1 ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6793:1: ( rule__DpfId__IdAssignment_1_1 )
            {
             before(grammarAccess.getDpfIdAccess().getIdAssignment_1_1()); 
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6794:1: ( rule__DpfId__IdAssignment_1_1 )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6794:2: rule__DpfId__IdAssignment_1_1
            {
            pushFollow(FOLLOW_rule__DpfId__IdAssignment_1_1_in_rule__DpfId__Group_1__1__Impl13609);
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


    // $ANTLR start "rule__Model__DefinitionsAssignment_0"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6809:1: rule__Model__DefinitionsAssignment_0 : ( ruleDefinition ) ;
    public final void rule__Model__DefinitionsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6813:1: ( ( ruleDefinition ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6814:1: ( ruleDefinition )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6814:1: ( ruleDefinition )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6815:1: ruleDefinition
            {
             before(grammarAccess.getModelAccess().getDefinitionsDefinitionParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleDefinition_in_rule__Model__DefinitionsAssignment_013648);
            ruleDefinition();

            state._fsp--;

             after(grammarAccess.getModelAccess().getDefinitionsDefinitionParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__DefinitionsAssignment_0"


    // $ANTLR start "rule__Model__DefinitionsAssignment_1"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6824:1: rule__Model__DefinitionsAssignment_1 : ( ruleDefinition ) ;
    public final void rule__Model__DefinitionsAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6828:1: ( ( ruleDefinition ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6829:1: ( ruleDefinition )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6829:1: ( ruleDefinition )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6830:1: ruleDefinition
            {
             before(grammarAccess.getModelAccess().getDefinitionsDefinitionParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleDefinition_in_rule__Model__DefinitionsAssignment_113679);
            ruleDefinition();

            state._fsp--;

             after(grammarAccess.getModelAccess().getDefinitionsDefinitionParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__DefinitionsAssignment_1"


    // $ANTLR start "rule__MakeEmf__IdAssignment_1"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6839:1: rule__MakeEmf__IdAssignment_1 : ( RULE_ID ) ;
    public final void rule__MakeEmf__IdAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6843:1: ( ( RULE_ID ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6844:1: ( RULE_ID )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6844:1: ( RULE_ID )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6845:1: RULE_ID
            {
             before(grammarAccess.getMakeEmfAccess().getIdIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__MakeEmf__IdAssignment_113710); 
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6854:1: rule__MakeEcore__IdAssignment_1 : ( RULE_ID ) ;
    public final void rule__MakeEcore__IdAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6858:1: ( ( RULE_ID ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6859:1: ( RULE_ID )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6859:1: ( RULE_ID )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6860:1: RULE_ID
            {
             before(grammarAccess.getMakeEcoreAccess().getIdIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__MakeEcore__IdAssignment_113741); 
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6869:1: rule__MakeImage__IdAssignment_1 : ( RULE_ID ) ;
    public final void rule__MakeImage__IdAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6873:1: ( ( RULE_ID ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6874:1: ( RULE_ID )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6874:1: ( RULE_ID )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6875:1: RULE_ID
            {
             before(grammarAccess.getMakeImageAccess().getIdIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__MakeImage__IdAssignment_113772); 
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6884:1: rule__SimpleEvoSpan__LhsAssignment_1 : ( RULE_ID ) ;
    public final void rule__SimpleEvoSpan__LhsAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6888:1: ( ( RULE_ID ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6889:1: ( RULE_ID )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6889:1: ( RULE_ID )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6890:1: RULE_ID
            {
             before(grammarAccess.getSimpleEvoSpanAccess().getLhsIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__SimpleEvoSpan__LhsAssignment_113803); 
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6899:1: rule__SimpleEvoSpan__DiffAssignment_3 : ( RULE_ID ) ;
    public final void rule__SimpleEvoSpan__DiffAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6903:1: ( ( RULE_ID ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6904:1: ( RULE_ID )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6904:1: ( RULE_ID )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6905:1: RULE_ID
            {
             before(grammarAccess.getSimpleEvoSpanAccess().getDiffIDTerminalRuleCall_3_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__SimpleEvoSpan__DiffAssignment_313834); 
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6914:1: rule__SimpleEvoSpan__RhSAssignment_5 : ( RULE_ID ) ;
    public final void rule__SimpleEvoSpan__RhSAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6918:1: ( ( RULE_ID ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6919:1: ( RULE_ID )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6919:1: ( RULE_ID )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6920:1: RULE_ID
            {
             before(grammarAccess.getSimpleEvoSpanAccess().getRhSIDTerminalRuleCall_5_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__SimpleEvoSpan__RhSAssignment_513865); 
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6929:1: rule__SimpleEvoSpan__TypeGraphAssignment_7 : ( RULE_ID ) ;
    public final void rule__SimpleEvoSpan__TypeGraphAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6933:1: ( ( RULE_ID ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6934:1: ( RULE_ID )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6934:1: ( RULE_ID )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6935:1: RULE_ID
            {
             before(grammarAccess.getSimpleEvoSpanAccess().getTypeGraphIDTerminalRuleCall_7_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__SimpleEvoSpan__TypeGraphAssignment_713896); 
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6944:1: rule__SimpleEvoCospan__LhsAssignment_1 : ( RULE_ID ) ;
    public final void rule__SimpleEvoCospan__LhsAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6948:1: ( ( RULE_ID ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6949:1: ( RULE_ID )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6949:1: ( RULE_ID )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6950:1: RULE_ID
            {
             before(grammarAccess.getSimpleEvoCospanAccess().getLhsIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__SimpleEvoCospan__LhsAssignment_113927); 
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6959:1: rule__SimpleEvoCospan__JointAssignment_3 : ( RULE_ID ) ;
    public final void rule__SimpleEvoCospan__JointAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6963:1: ( ( RULE_ID ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6964:1: ( RULE_ID )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6964:1: ( RULE_ID )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6965:1: RULE_ID
            {
             before(grammarAccess.getSimpleEvoCospanAccess().getJointIDTerminalRuleCall_3_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__SimpleEvoCospan__JointAssignment_313958); 
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6974:1: rule__SimpleEvoCospan__RhsAssignment_5 : ( RULE_ID ) ;
    public final void rule__SimpleEvoCospan__RhsAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6978:1: ( ( RULE_ID ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6979:1: ( RULE_ID )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6979:1: ( RULE_ID )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6980:1: RULE_ID
            {
             before(grammarAccess.getSimpleEvoCospanAccess().getRhsIDTerminalRuleCall_5_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__SimpleEvoCospan__RhsAssignment_513989); 
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6989:1: rule__SimpleEvoCospan__TypeGraphAssignment_7 : ( RULE_ID ) ;
    public final void rule__SimpleEvoCospan__TypeGraphAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6993:1: ( ( RULE_ID ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6994:1: ( RULE_ID )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6994:1: ( RULE_ID )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:6995:1: RULE_ID
            {
             before(grammarAccess.getSimpleEvoCospanAccess().getTypeGraphIDTerminalRuleCall_7_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__SimpleEvoCospan__TypeGraphAssignment_714020); 
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7004:1: rule__EvoSpan__LhsAssignment_1 : ( RULE_ID ) ;
    public final void rule__EvoSpan__LhsAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7008:1: ( ( RULE_ID ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7009:1: ( RULE_ID )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7009:1: ( RULE_ID )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7010:1: RULE_ID
            {
             before(grammarAccess.getEvoSpanAccess().getLhsIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__EvoSpan__LhsAssignment_114051); 
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7019:1: rule__EvoSpan__RhsAssignment_3 : ( RULE_ID ) ;
    public final void rule__EvoSpan__RhsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7023:1: ( ( RULE_ID ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7024:1: ( RULE_ID )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7024:1: ( RULE_ID )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7025:1: RULE_ID
            {
             before(grammarAccess.getEvoSpanAccess().getRhsIDTerminalRuleCall_3_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__EvoSpan__RhsAssignment_314082); 
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7034:1: rule__EvoSpan__TypeGraphAssignment_5 : ( RULE_ID ) ;
    public final void rule__EvoSpan__TypeGraphAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7038:1: ( ( RULE_ID ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7039:1: ( RULE_ID )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7039:1: ( RULE_ID )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7040:1: RULE_ID
            {
             before(grammarAccess.getEvoSpanAccess().getTypeGraphIDTerminalRuleCall_5_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__EvoSpan__TypeGraphAssignment_514113); 
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7049:1: rule__EvoCospan__LhsAssignment_1 : ( RULE_ID ) ;
    public final void rule__EvoCospan__LhsAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7053:1: ( ( RULE_ID ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7054:1: ( RULE_ID )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7054:1: ( RULE_ID )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7055:1: RULE_ID
            {
             before(grammarAccess.getEvoCospanAccess().getLhsIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__EvoCospan__LhsAssignment_114144); 
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7064:1: rule__EvoCospan__RhsAssignment_3 : ( RULE_ID ) ;
    public final void rule__EvoCospan__RhsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7068:1: ( ( RULE_ID ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7069:1: ( RULE_ID )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7069:1: ( RULE_ID )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7070:1: RULE_ID
            {
             before(grammarAccess.getEvoCospanAccess().getRhsIDTerminalRuleCall_3_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__EvoCospan__RhsAssignment_314175); 
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7079:1: rule__EvoCospan__TypeGraphAssignment_5 : ( RULE_ID ) ;
    public final void rule__EvoCospan__TypeGraphAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7083:1: ( ( RULE_ID ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7084:1: ( RULE_ID )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7084:1: ( RULE_ID )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7085:1: RULE_ID
            {
             before(grammarAccess.getEvoCospanAccess().getTypeGraphIDTerminalRuleCall_5_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__EvoCospan__TypeGraphAssignment_514206); 
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7094:1: rule__InstanceSpecification__IdAssignment_0 : ( RULE_ID ) ;
    public final void rule__InstanceSpecification__IdAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7098:1: ( ( RULE_ID ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7099:1: ( RULE_ID )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7099:1: ( RULE_ID )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7100:1: RULE_ID
            {
             before(grammarAccess.getInstanceSpecificationAccess().getIdIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__InstanceSpecification__IdAssignment_014237); 
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


    // $ANTLR start "rule__InstanceSpecification__ModelAssignment_3"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7109:1: rule__InstanceSpecification__ModelAssignment_3 : ( ruleChoosenSpecfication ) ;
    public final void rule__InstanceSpecification__ModelAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7113:1: ( ( ruleChoosenSpecfication ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7114:1: ( ruleChoosenSpecfication )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7114:1: ( ruleChoosenSpecfication )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7115:1: ruleChoosenSpecfication
            {
             before(grammarAccess.getInstanceSpecificationAccess().getModelChoosenSpecficationParserRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleChoosenSpecfication_in_rule__InstanceSpecification__ModelAssignment_314268);
            ruleChoosenSpecfication();

            state._fsp--;

             after(grammarAccess.getInstanceSpecificationAccess().getModelChoosenSpecficationParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InstanceSpecification__ModelAssignment_3"


    // $ANTLR start "rule__InstanceSpecification__MetamodelAssignment_5"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7124:1: rule__InstanceSpecification__MetamodelAssignment_5 : ( ruleChoosenSpecfication ) ;
    public final void rule__InstanceSpecification__MetamodelAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7128:1: ( ( ruleChoosenSpecfication ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7129:1: ( ruleChoosenSpecfication )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7129:1: ( ruleChoosenSpecfication )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7130:1: ruleChoosenSpecfication
            {
             before(grammarAccess.getInstanceSpecificationAccess().getMetamodelChoosenSpecficationParserRuleCall_5_0()); 
            pushFollow(FOLLOW_ruleChoosenSpecfication_in_rule__InstanceSpecification__MetamodelAssignment_514299);
            ruleChoosenSpecfication();

            state._fsp--;

             after(grammarAccess.getInstanceSpecificationAccess().getMetamodelChoosenSpecficationParserRuleCall_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InstanceSpecification__MetamodelAssignment_5"


    // $ANTLR start "rule__InstanceSpecification__ConstraintSemanticsAssignment_8_0"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7139:1: rule__InstanceSpecification__ConstraintSemanticsAssignment_8_0 : ( ruleConstraintSemantic ) ;
    public final void rule__InstanceSpecification__ConstraintSemanticsAssignment_8_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7143:1: ( ( ruleConstraintSemantic ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7144:1: ( ruleConstraintSemantic )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7144:1: ( ruleConstraintSemantic )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7145:1: ruleConstraintSemantic
            {
             before(grammarAccess.getInstanceSpecificationAccess().getConstraintSemanticsConstraintSemanticParserRuleCall_8_0_0()); 
            pushFollow(FOLLOW_ruleConstraintSemantic_in_rule__InstanceSpecification__ConstraintSemanticsAssignment_8_014330);
            ruleConstraintSemantic();

            state._fsp--;

             after(grammarAccess.getInstanceSpecificationAccess().getConstraintSemanticsConstraintSemanticParserRuleCall_8_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InstanceSpecification__ConstraintSemanticsAssignment_8_0"


    // $ANTLR start "rule__InstanceSpecification__ConstraintSemanticsAssignment_8_1_1"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7154:1: rule__InstanceSpecification__ConstraintSemanticsAssignment_8_1_1 : ( ruleConstraintSemantic ) ;
    public final void rule__InstanceSpecification__ConstraintSemanticsAssignment_8_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7158:1: ( ( ruleConstraintSemantic ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7159:1: ( ruleConstraintSemantic )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7159:1: ( ruleConstraintSemantic )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7160:1: ruleConstraintSemantic
            {
             before(grammarAccess.getInstanceSpecificationAccess().getConstraintSemanticsConstraintSemanticParserRuleCall_8_1_1_0()); 
            pushFollow(FOLLOW_ruleConstraintSemantic_in_rule__InstanceSpecification__ConstraintSemanticsAssignment_8_1_114361);
            ruleConstraintSemantic();

            state._fsp--;

             after(grammarAccess.getInstanceSpecificationAccess().getConstraintSemanticsConstraintSemanticParserRuleCall_8_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InstanceSpecification__ConstraintSemanticsAssignment_8_1_1"


    // $ANTLR start "rule__ChoosenSpecfication__IdAssignment"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7169:1: rule__ChoosenSpecfication__IdAssignment : ( RULE_ID ) ;
    public final void rule__ChoosenSpecfication__IdAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7173:1: ( ( RULE_ID ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7174:1: ( RULE_ID )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7174:1: ( RULE_ID )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7175:1: RULE_ID
            {
             before(grammarAccess.getChoosenSpecficationAccess().getIdIDTerminalRuleCall_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ChoosenSpecfication__IdAssignment14392); 
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7184:1: rule__ConstraintSemantic__IdAssignment_0 : ( ruleDpfId ) ;
    public final void rule__ConstraintSemantic__IdAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7188:1: ( ( ruleDpfId ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7189:1: ( ruleDpfId )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7189:1: ( ruleDpfId )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7190:1: ruleDpfId
            {
             before(grammarAccess.getConstraintSemanticAccess().getIdDpfIdParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleDpfId_in_rule__ConstraintSemantic__IdAssignment_014423);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7199:1: rule__ConstraintSemantic__ArrowsAssignment_2_0 : ( ruleArrows ) ;
    public final void rule__ConstraintSemantic__ArrowsAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7203:1: ( ( ruleArrows ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7204:1: ( ruleArrows )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7204:1: ( ruleArrows )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7205:1: ruleArrows
            {
             before(grammarAccess.getConstraintSemanticAccess().getArrowsArrowsParserRuleCall_2_0_0()); 
            pushFollow(FOLLOW_ruleArrows_in_rule__ConstraintSemantic__ArrowsAssignment_2_014454);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7214:1: rule__ConstraintSemantic__ArrowsAssignment_2_1_1 : ( ruleArrows ) ;
    public final void rule__ConstraintSemantic__ArrowsAssignment_2_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7218:1: ( ( ruleArrows ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7219:1: ( ruleArrows )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7219:1: ( ruleArrows )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7220:1: ruleArrows
            {
             before(grammarAccess.getConstraintSemanticAccess().getArrowsArrowsParserRuleCall_2_1_1_0()); 
            pushFollow(FOLLOW_ruleArrows_in_rule__ConstraintSemantic__ArrowsAssignment_2_1_114485);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7229:1: rule__ConstraintSemantic__OclAssignment_6 : ( RULE_STRING ) ;
    public final void rule__ConstraintSemantic__OclAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7233:1: ( ( RULE_STRING ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7234:1: ( RULE_STRING )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7234:1: ( RULE_STRING )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7235:1: RULE_STRING
            {
             before(grammarAccess.getConstraintSemanticAccess().getOclSTRINGTerminalRuleCall_6_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__ConstraintSemantic__OclAssignment_614516); 
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


    // $ANTLR start "rule__Specification__IdAssignment_0"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7244:1: rule__Specification__IdAssignment_0 : ( RULE_ID ) ;
    public final void rule__Specification__IdAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7248:1: ( ( RULE_ID ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7249:1: ( RULE_ID )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7249:1: ( RULE_ID )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7250:1: RULE_ID
            {
             before(grammarAccess.getSpecificationAccess().getIdIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Specification__IdAssignment_014547); 
             after(grammarAccess.getSpecificationAccess().getIdIDTerminalRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Specification__IdAssignment_0"


    // $ANTLR start "rule__Specification__GraphAssignment_3"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7259:1: rule__Specification__GraphAssignment_3 : ( ruleChoosenGraph ) ;
    public final void rule__Specification__GraphAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7263:1: ( ( ruleChoosenGraph ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7264:1: ( ruleChoosenGraph )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7264:1: ( ruleChoosenGraph )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7265:1: ruleChoosenGraph
            {
             before(grammarAccess.getSpecificationAccess().getGraphChoosenGraphParserRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleChoosenGraph_in_rule__Specification__GraphAssignment_314578);
            ruleChoosenGraph();

            state._fsp--;

             after(grammarAccess.getSpecificationAccess().getGraphChoosenGraphParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Specification__GraphAssignment_3"


    // $ANTLR start "rule__Specification__ConstraintsAssignment_6_0"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7274:1: rule__Specification__ConstraintsAssignment_6_0 : ( ruleConstraint ) ;
    public final void rule__Specification__ConstraintsAssignment_6_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7278:1: ( ( ruleConstraint ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7279:1: ( ruleConstraint )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7279:1: ( ruleConstraint )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7280:1: ruleConstraint
            {
             before(grammarAccess.getSpecificationAccess().getConstraintsConstraintParserRuleCall_6_0_0()); 
            pushFollow(FOLLOW_ruleConstraint_in_rule__Specification__ConstraintsAssignment_6_014609);
            ruleConstraint();

            state._fsp--;

             after(grammarAccess.getSpecificationAccess().getConstraintsConstraintParserRuleCall_6_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Specification__ConstraintsAssignment_6_0"


    // $ANTLR start "rule__Specification__ConstraintsAssignment_6_1_1"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7289:1: rule__Specification__ConstraintsAssignment_6_1_1 : ( ruleConstraint ) ;
    public final void rule__Specification__ConstraintsAssignment_6_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7293:1: ( ( ruleConstraint ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7294:1: ( ruleConstraint )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7294:1: ( ruleConstraint )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7295:1: ruleConstraint
            {
             before(grammarAccess.getSpecificationAccess().getConstraintsConstraintParserRuleCall_6_1_1_0()); 
            pushFollow(FOLLOW_ruleConstraint_in_rule__Specification__ConstraintsAssignment_6_1_114640);
            ruleConstraint();

            state._fsp--;

             after(grammarAccess.getSpecificationAccess().getConstraintsConstraintParserRuleCall_6_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Specification__ConstraintsAssignment_6_1_1"


    // $ANTLR start "rule__ChoosenGraph__IdAssignment"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7304:1: rule__ChoosenGraph__IdAssignment : ( RULE_ID ) ;
    public final void rule__ChoosenGraph__IdAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7308:1: ( ( RULE_ID ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7309:1: ( RULE_ID )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7309:1: ( RULE_ID )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7310:1: RULE_ID
            {
             before(grammarAccess.getChoosenGraphAccess().getIdIDTerminalRuleCall_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ChoosenGraph__IdAssignment14671); 
             after(grammarAccess.getChoosenGraphAccess().getIdIDTerminalRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ChoosenGraph__IdAssignment"


    // $ANTLR start "rule__Constraint__SignatureAssignment_0"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7319:1: rule__Constraint__SignatureAssignment_0 : ( ruleConstraintSignature ) ;
    public final void rule__Constraint__SignatureAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7323:1: ( ( ruleConstraintSignature ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7324:1: ( ruleConstraintSignature )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7324:1: ( ruleConstraintSignature )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7325:1: ruleConstraintSignature
            {
             before(grammarAccess.getConstraintAccess().getSignatureConstraintSignatureParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleConstraintSignature_in_rule__Constraint__SignatureAssignment_014702);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7334:1: rule__Constraint__ArrowsAssignment_2_0 : ( ruleArrows ) ;
    public final void rule__Constraint__ArrowsAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7338:1: ( ( ruleArrows ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7339:1: ( ruleArrows )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7339:1: ( ruleArrows )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7340:1: ruleArrows
            {
             before(grammarAccess.getConstraintAccess().getArrowsArrowsParserRuleCall_2_0_0()); 
            pushFollow(FOLLOW_ruleArrows_in_rule__Constraint__ArrowsAssignment_2_014733);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7349:1: rule__Constraint__ArrowsAssignment_2_1_1 : ( ruleArrows ) ;
    public final void rule__Constraint__ArrowsAssignment_2_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7353:1: ( ( ruleArrows ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7354:1: ( ruleArrows )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7354:1: ( ruleArrows )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7355:1: ruleArrows
            {
             before(grammarAccess.getConstraintAccess().getArrowsArrowsParserRuleCall_2_1_1_0()); 
            pushFollow(FOLLOW_ruleArrows_in_rule__Constraint__ArrowsAssignment_2_1_114764);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7364:1: rule__ConstraintSignature__IdAssignment_0 : ( ruleDpfId ) ;
    public final void rule__ConstraintSignature__IdAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7368:1: ( ( ruleDpfId ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7369:1: ( ruleDpfId )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7369:1: ( ruleDpfId )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7370:1: ruleDpfId
            {
             before(grammarAccess.getConstraintSignatureAccess().getIdDpfIdParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleDpfId_in_rule__ConstraintSignature__IdAssignment_014795);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7379:1: rule__ConstraintSignature__ParameterAssignment_2_0 : ( RULE_ID ) ;
    public final void rule__ConstraintSignature__ParameterAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7383:1: ( ( RULE_ID ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7384:1: ( RULE_ID )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7384:1: ( RULE_ID )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7385:1: RULE_ID
            {
             before(grammarAccess.getConstraintSignatureAccess().getParameterIDTerminalRuleCall_2_0_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ConstraintSignature__ParameterAssignment_2_014826); 
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7394:1: rule__ConstraintSignature__ParameterAssignment_2_1_1 : ( RULE_ID ) ;
    public final void rule__ConstraintSignature__ParameterAssignment_2_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7398:1: ( ( RULE_ID ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7399:1: ( RULE_ID )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7399:1: ( RULE_ID )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7400:1: RULE_ID
            {
             before(grammarAccess.getConstraintSignatureAccess().getParameterIDTerminalRuleCall_2_1_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ConstraintSignature__ParameterAssignment_2_1_114857); 
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


    // $ANTLR start "rule__Morphism__DomainAssignment_3"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7409:1: rule__Morphism__DomainAssignment_3 : ( ruleDomain ) ;
    public final void rule__Morphism__DomainAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7413:1: ( ( ruleDomain ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7414:1: ( ruleDomain )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7414:1: ( ruleDomain )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7415:1: ruleDomain
            {
             before(grammarAccess.getMorphismAccess().getDomainDomainParserRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleDomain_in_rule__Morphism__DomainAssignment_314888);
            ruleDomain();

            state._fsp--;

             after(grammarAccess.getMorphismAccess().getDomainDomainParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Morphism__DomainAssignment_3"


    // $ANTLR start "rule__Morphism__CodmainAssignment_5"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7424:1: rule__Morphism__CodmainAssignment_5 : ( ruleCodomain ) ;
    public final void rule__Morphism__CodmainAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7428:1: ( ( ruleCodomain ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7429:1: ( ruleCodomain )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7429:1: ( ruleCodomain )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7430:1: ruleCodomain
            {
             before(grammarAccess.getMorphismAccess().getCodmainCodomainParserRuleCall_5_0()); 
            pushFollow(FOLLOW_ruleCodomain_in_rule__Morphism__CodmainAssignment_514919);
            ruleCodomain();

            state._fsp--;

             after(grammarAccess.getMorphismAccess().getCodmainCodomainParserRuleCall_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Morphism__CodmainAssignment_5"


    // $ANTLR start "rule__Morphism__MappingsAssignment_8_0"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7439:1: rule__Morphism__MappingsAssignment_8_0 : ( ruleMapping ) ;
    public final void rule__Morphism__MappingsAssignment_8_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7443:1: ( ( ruleMapping ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7444:1: ( ruleMapping )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7444:1: ( ruleMapping )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7445:1: ruleMapping
            {
             before(grammarAccess.getMorphismAccess().getMappingsMappingParserRuleCall_8_0_0()); 
            pushFollow(FOLLOW_ruleMapping_in_rule__Morphism__MappingsAssignment_8_014950);
            ruleMapping();

            state._fsp--;

             after(grammarAccess.getMorphismAccess().getMappingsMappingParserRuleCall_8_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Morphism__MappingsAssignment_8_0"


    // $ANTLR start "rule__Morphism__MappingsAssignment_8_1_1"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7454:1: rule__Morphism__MappingsAssignment_8_1_1 : ( ruleMapping ) ;
    public final void rule__Morphism__MappingsAssignment_8_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7458:1: ( ( ruleMapping ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7459:1: ( ruleMapping )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7459:1: ( ruleMapping )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7460:1: ruleMapping
            {
             before(grammarAccess.getMorphismAccess().getMappingsMappingParserRuleCall_8_1_1_0()); 
            pushFollow(FOLLOW_ruleMapping_in_rule__Morphism__MappingsAssignment_8_1_114981);
            ruleMapping();

            state._fsp--;

             after(grammarAccess.getMorphismAccess().getMappingsMappingParserRuleCall_8_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Morphism__MappingsAssignment_8_1_1"


    // $ANTLR start "rule__Domain__IdAssignment"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7469:1: rule__Domain__IdAssignment : ( RULE_ID ) ;
    public final void rule__Domain__IdAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7473:1: ( ( RULE_ID ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7474:1: ( RULE_ID )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7474:1: ( RULE_ID )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7475:1: RULE_ID
            {
             before(grammarAccess.getDomainAccess().getIdIDTerminalRuleCall_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Domain__IdAssignment15012); 
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7484:1: rule__Codomain__IdAssignment : ( RULE_ID ) ;
    public final void rule__Codomain__IdAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7488:1: ( ( RULE_ID ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7489:1: ( RULE_ID )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7489:1: ( RULE_ID )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7490:1: RULE_ID
            {
             before(grammarAccess.getCodomainAccess().getIdIDTerminalRuleCall_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Codomain__IdAssignment15043); 
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7499:1: rule__MappingNode__DomainAssignment_0 : ( ruleNode ) ;
    public final void rule__MappingNode__DomainAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7503:1: ( ( ruleNode ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7504:1: ( ruleNode )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7504:1: ( ruleNode )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7505:1: ruleNode
            {
             before(grammarAccess.getMappingNodeAccess().getDomainNodeParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleNode_in_rule__MappingNode__DomainAssignment_015074);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7514:1: rule__MappingNode__CodomainAssignment_2 : ( ruleNode ) ;
    public final void rule__MappingNode__CodomainAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7518:1: ( ( ruleNode ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7519:1: ( ruleNode )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7519:1: ( ruleNode )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7520:1: ruleNode
            {
             before(grammarAccess.getMappingNodeAccess().getCodomainNodeParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleNode_in_rule__MappingNode__CodomainAssignment_215105);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7529:1: rule__MappingArrow__DomainAssignment_0 : ( ruleArrow ) ;
    public final void rule__MappingArrow__DomainAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7533:1: ( ( ruleArrow ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7534:1: ( ruleArrow )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7534:1: ( ruleArrow )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7535:1: ruleArrow
            {
             before(grammarAccess.getMappingArrowAccess().getDomainArrowParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleArrow_in_rule__MappingArrow__DomainAssignment_015136);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7544:1: rule__MappingArrow__CodmainAssignment_2 : ( ruleArrow ) ;
    public final void rule__MappingArrow__CodmainAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7548:1: ( ( ruleArrow ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7549:1: ( ruleArrow )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7549:1: ( ruleArrow )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7550:1: ruleArrow
            {
             before(grammarAccess.getMappingArrowAccess().getCodmainArrowParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleArrow_in_rule__MappingArrow__CodmainAssignment_215167);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7559:1: rule__ExtSubTGraph__IdAssignment_0 : ( RULE_ID ) ;
    public final void rule__ExtSubTGraph__IdAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7563:1: ( ( RULE_ID ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7564:1: ( RULE_ID )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7564:1: ( RULE_ID )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7565:1: RULE_ID
            {
             before(grammarAccess.getExtSubTGraphAccess().getIdIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ExtSubTGraph__IdAssignment_015198); 
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


    // $ANTLR start "rule__ExtSubTGraph__ExtendsGraphAssignment_3"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7574:1: rule__ExtSubTGraph__ExtendsGraphAssignment_3 : ( ruleTGraphExtSubName ) ;
    public final void rule__ExtSubTGraph__ExtendsGraphAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7578:1: ( ( ruleTGraphExtSubName ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7579:1: ( ruleTGraphExtSubName )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7579:1: ( ruleTGraphExtSubName )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7580:1: ruleTGraphExtSubName
            {
             before(grammarAccess.getExtSubTGraphAccess().getExtendsGraphTGraphExtSubNameParserRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleTGraphExtSubName_in_rule__ExtSubTGraph__ExtendsGraphAssignment_315229);
            ruleTGraphExtSubName();

            state._fsp--;

             after(grammarAccess.getExtSubTGraphAccess().getExtendsGraphTGraphExtSubNameParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExtSubTGraph__ExtendsGraphAssignment_3"


    // $ANTLR start "rule__ExtSubTGraph__ElementsAssignment_6"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7589:1: rule__ExtSubTGraph__ElementsAssignment_6 : ( ruleElement ) ;
    public final void rule__ExtSubTGraph__ElementsAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7593:1: ( ( ruleElement ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7594:1: ( ruleElement )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7594:1: ( ruleElement )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7595:1: ruleElement
            {
             before(grammarAccess.getExtSubTGraphAccess().getElementsElementParserRuleCall_6_0()); 
            pushFollow(FOLLOW_ruleElement_in_rule__ExtSubTGraph__ElementsAssignment_615260);
            ruleElement();

            state._fsp--;

             after(grammarAccess.getExtSubTGraphAccess().getElementsElementParserRuleCall_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExtSubTGraph__ElementsAssignment_6"


    // $ANTLR start "rule__TGraphExtSubName__IdAssignment"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7604:1: rule__TGraphExtSubName__IdAssignment : ( RULE_ID ) ;
    public final void rule__TGraphExtSubName__IdAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7608:1: ( ( RULE_ID ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7609:1: ( RULE_ID )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7609:1: ( RULE_ID )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7610:1: RULE_ID
            {
             before(grammarAccess.getTGraphExtSubNameAccess().getIdIDTerminalRuleCall_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__TGraphExtSubName__IdAssignment15291); 
             after(grammarAccess.getTGraphExtSubNameAccess().getIdIDTerminalRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TGraphExtSubName__IdAssignment"


    // $ANTLR start "rule__TGraph__IdAssignment_0"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7619:1: rule__TGraph__IdAssignment_0 : ( RULE_ID ) ;
    public final void rule__TGraph__IdAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7623:1: ( ( RULE_ID ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7624:1: ( RULE_ID )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7624:1: ( RULE_ID )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7625:1: RULE_ID
            {
             before(grammarAccess.getTGraphAccess().getIdIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__TGraph__IdAssignment_015322); 
             after(grammarAccess.getTGraphAccess().getIdIDTerminalRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TGraph__IdAssignment_0"


    // $ANTLR start "rule__TGraph__TypeGraphAssignment_3"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7634:1: rule__TGraph__TypeGraphAssignment_3 : ( ruleTGraphName ) ;
    public final void rule__TGraph__TypeGraphAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7638:1: ( ( ruleTGraphName ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7639:1: ( ruleTGraphName )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7639:1: ( ruleTGraphName )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7640:1: ruleTGraphName
            {
             before(grammarAccess.getTGraphAccess().getTypeGraphTGraphNameParserRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleTGraphName_in_rule__TGraph__TypeGraphAssignment_315353);
            ruleTGraphName();

            state._fsp--;

             after(grammarAccess.getTGraphAccess().getTypeGraphTGraphNameParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TGraph__TypeGraphAssignment_3"


    // $ANTLR start "rule__TGraph__ElementsAssignment_6"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7649:1: rule__TGraph__ElementsAssignment_6 : ( ruleElement ) ;
    public final void rule__TGraph__ElementsAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7653:1: ( ( ruleElement ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7654:1: ( ruleElement )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7654:1: ( ruleElement )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7655:1: ruleElement
            {
             before(grammarAccess.getTGraphAccess().getElementsElementParserRuleCall_6_0()); 
            pushFollow(FOLLOW_ruleElement_in_rule__TGraph__ElementsAssignment_615384);
            ruleElement();

            state._fsp--;

             after(grammarAccess.getTGraphAccess().getElementsElementParserRuleCall_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TGraph__ElementsAssignment_6"


    // $ANTLR start "rule__TGraphName__IdAssignment"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7664:1: rule__TGraphName__IdAssignment : ( RULE_ID ) ;
    public final void rule__TGraphName__IdAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7668:1: ( ( RULE_ID ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7669:1: ( RULE_ID )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7669:1: ( RULE_ID )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7670:1: RULE_ID
            {
             before(grammarAccess.getTGraphNameAccess().getIdIDTerminalRuleCall_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__TGraphName__IdAssignment15415); 
             after(grammarAccess.getTGraphNameAccess().getIdIDTerminalRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TGraphName__IdAssignment"


    // $ANTLR start "rule__Arrows__SrAssignment_0_0"
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7679:1: rule__Arrows__SrAssignment_0_0 : ( ruleNode ) ;
    public final void rule__Arrows__SrAssignment_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7683:1: ( ( ruleNode ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7684:1: ( ruleNode )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7684:1: ( ruleNode )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7685:1: ruleNode
            {
             before(grammarAccess.getArrowsAccess().getSrNodeParserRuleCall_0_0_0()); 
            pushFollow(FOLLOW_ruleNode_in_rule__Arrows__SrAssignment_0_015446);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7694:1: rule__Arrows__IdAssignment_0_2 : ( ruleDpfId ) ;
    public final void rule__Arrows__IdAssignment_0_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7698:1: ( ( ruleDpfId ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7699:1: ( ruleDpfId )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7699:1: ( ruleDpfId )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7700:1: ruleDpfId
            {
             before(grammarAccess.getArrowsAccess().getIdDpfIdParserRuleCall_0_2_0()); 
            pushFollow(FOLLOW_ruleDpfId_in_rule__Arrows__IdAssignment_0_215477);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7709:1: rule__Arrows__TypeAssignment_0_4 : ( ruleDpfId ) ;
    public final void rule__Arrows__TypeAssignment_0_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7713:1: ( ( ruleDpfId ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7714:1: ( ruleDpfId )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7714:1: ( ruleDpfId )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7715:1: ruleDpfId
            {
             before(grammarAccess.getArrowsAccess().getTypeDpfIdParserRuleCall_0_4_0()); 
            pushFollow(FOLLOW_ruleDpfId_in_rule__Arrows__TypeAssignment_0_415508);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7724:1: rule__Arrows__NextAssignment_0_6 : ( ruleArrows ) ;
    public final void rule__Arrows__NextAssignment_0_6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7728:1: ( ( ruleArrows ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7729:1: ( ruleArrows )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7729:1: ( ruleArrows )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7730:1: ruleArrows
            {
             before(grammarAccess.getArrowsAccess().getNextArrowsParserRuleCall_0_6_0()); 
            pushFollow(FOLLOW_ruleArrows_in_rule__Arrows__NextAssignment_0_615539);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7739:1: rule__Arrow__SrAssignment_0_0 : ( ruleNode ) ;
    public final void rule__Arrow__SrAssignment_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7743:1: ( ( ruleNode ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7744:1: ( ruleNode )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7744:1: ( ruleNode )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7745:1: ruleNode
            {
             before(grammarAccess.getArrowAccess().getSrNodeParserRuleCall_0_0_0()); 
            pushFollow(FOLLOW_ruleNode_in_rule__Arrow__SrAssignment_0_015570);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7754:1: rule__Arrow__IdAssignment_0_2 : ( ruleDpfId ) ;
    public final void rule__Arrow__IdAssignment_0_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7758:1: ( ( ruleDpfId ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7759:1: ( ruleDpfId )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7759:1: ( ruleDpfId )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7760:1: ruleDpfId
            {
             before(grammarAccess.getArrowAccess().getIdDpfIdParserRuleCall_0_2_0()); 
            pushFollow(FOLLOW_ruleDpfId_in_rule__Arrow__IdAssignment_0_215601);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7769:1: rule__Arrow__TgDataTypeAssignment_0_6 : ( ruleDataType ) ;
    public final void rule__Arrow__TgDataTypeAssignment_0_6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7773:1: ( ( ruleDataType ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7774:1: ( ruleDataType )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7774:1: ( ruleDataType )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7775:1: ruleDataType
            {
             before(grammarAccess.getArrowAccess().getTgDataTypeDataTypeEnumRuleCall_0_6_0()); 
            pushFollow(FOLLOW_ruleDataType_in_rule__Arrow__TgDataTypeAssignment_0_615632);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7784:1: rule__Arrow__SrAssignment_1_0 : ( ruleNode ) ;
    public final void rule__Arrow__SrAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7788:1: ( ( ruleNode ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7789:1: ( ruleNode )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7789:1: ( ruleNode )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7790:1: ruleNode
            {
             before(grammarAccess.getArrowAccess().getSrNodeParserRuleCall_1_0_0()); 
            pushFollow(FOLLOW_ruleNode_in_rule__Arrow__SrAssignment_1_015663);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7799:1: rule__Arrow__IdAssignment_1_2 : ( ruleDpfId ) ;
    public final void rule__Arrow__IdAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7803:1: ( ( ruleDpfId ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7804:1: ( ruleDpfId )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7804:1: ( ruleDpfId )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7805:1: ruleDpfId
            {
             before(grammarAccess.getArrowAccess().getIdDpfIdParserRuleCall_1_2_0()); 
            pushFollow(FOLLOW_ruleDpfId_in_rule__Arrow__IdAssignment_1_215694);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7814:1: rule__Arrow__TypeAssignment_1_4 : ( ruleDpfId ) ;
    public final void rule__Arrow__TypeAssignment_1_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7818:1: ( ( ruleDpfId ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7819:1: ( ruleDpfId )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7819:1: ( ruleDpfId )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7820:1: ruleDpfId
            {
             before(grammarAccess.getArrowAccess().getTypeDpfIdParserRuleCall_1_4_0()); 
            pushFollow(FOLLOW_ruleDpfId_in_rule__Arrow__TypeAssignment_1_415725);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7829:1: rule__Arrow__TgValueAssignment_1_6 : ( ruleAttributeValue ) ;
    public final void rule__Arrow__TgValueAssignment_1_6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7833:1: ( ( ruleAttributeValue ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7834:1: ( ruleAttributeValue )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7834:1: ( ruleAttributeValue )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7835:1: ruleAttributeValue
            {
             before(grammarAccess.getArrowAccess().getTgValueAttributeValueParserRuleCall_1_6_0()); 
            pushFollow(FOLLOW_ruleAttributeValue_in_rule__Arrow__TgValueAssignment_1_615756);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7844:1: rule__Arrow__SrAssignment_2_0 : ( ruleNode ) ;
    public final void rule__Arrow__SrAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7848:1: ( ( ruleNode ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7849:1: ( ruleNode )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7849:1: ( ruleNode )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7850:1: ruleNode
            {
             before(grammarAccess.getArrowAccess().getSrNodeParserRuleCall_2_0_0()); 
            pushFollow(FOLLOW_ruleNode_in_rule__Arrow__SrAssignment_2_015787);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7859:1: rule__Arrow__IdAssignment_2_2 : ( ruleDpfId ) ;
    public final void rule__Arrow__IdAssignment_2_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7863:1: ( ( ruleDpfId ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7864:1: ( ruleDpfId )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7864:1: ( ruleDpfId )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7865:1: ruleDpfId
            {
             before(grammarAccess.getArrowAccess().getIdDpfIdParserRuleCall_2_2_0()); 
            pushFollow(FOLLOW_ruleDpfId_in_rule__Arrow__IdAssignment_2_215818);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7874:1: rule__Arrow__TypeAssignment_2_4 : ( ruleDpfId ) ;
    public final void rule__Arrow__TypeAssignment_2_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7878:1: ( ( ruleDpfId ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7879:1: ( ruleDpfId )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7879:1: ( ruleDpfId )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7880:1: ruleDpfId
            {
             before(grammarAccess.getArrowAccess().getTypeDpfIdParserRuleCall_2_4_0()); 
            pushFollow(FOLLOW_ruleDpfId_in_rule__Arrow__TypeAssignment_2_415849);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7889:1: rule__Arrow__TgNodeAssignment_2_6 : ( ruleNode ) ;
    public final void rule__Arrow__TgNodeAssignment_2_6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7893:1: ( ( ruleNode ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7894:1: ( ruleNode )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7894:1: ( ruleNode )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7895:1: ruleNode
            {
             before(grammarAccess.getArrowAccess().getTgNodeNodeParserRuleCall_2_6_0()); 
            pushFollow(FOLLOW_ruleNode_in_rule__Arrow__TgNodeAssignment_2_615880);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7904:1: rule__Node__IdAssignment_0 : ( ruleDpfId ) ;
    public final void rule__Node__IdAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7908:1: ( ( ruleDpfId ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7909:1: ( ruleDpfId )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7909:1: ( ruleDpfId )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7910:1: ruleDpfId
            {
             before(grammarAccess.getNodeAccess().getIdDpfIdParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleDpfId_in_rule__Node__IdAssignment_015911);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7919:1: rule__Node__TypeAssignment_2 : ( ruleDpfId ) ;
    public final void rule__Node__TypeAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7923:1: ( ( ruleDpfId ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7924:1: ( ruleDpfId )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7924:1: ( ruleDpfId )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7925:1: ruleDpfId
            {
             before(grammarAccess.getNodeAccess().getTypeDpfIdParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleDpfId_in_rule__Node__TypeAssignment_215942);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7934:1: rule__AttributeValue__ValueAssignment_1 : ( ruleVALUE ) ;
    public final void rule__AttributeValue__ValueAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7938:1: ( ( ruleVALUE ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7939:1: ( ruleVALUE )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7939:1: ( ruleVALUE )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7940:1: ruleVALUE
            {
             before(grammarAccess.getAttributeValueAccess().getValueVALUEParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleVALUE_in_rule__AttributeValue__ValueAssignment_115973);
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7949:1: rule__DpfId__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__DpfId__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7953:1: ( ( RULE_ID ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7954:1: ( RULE_ID )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7954:1: ( RULE_ID )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7955:1: RULE_ID
            {
             before(grammarAccess.getDpfIdAccess().getNameIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__DpfId__NameAssignment_016004); 
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
    // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7964:1: rule__DpfId__IdAssignment_1_1 : ( RULE_INT ) ;
    public final void rule__DpfId__IdAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7968:1: ( ( RULE_INT ) )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7969:1: ( RULE_INT )
            {
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7969:1: ( RULE_INT )
            // ../no.hib.dpf.text.ui/src-gen/no/hib/dpf/text/ui/contentassist/antlr/internal/InternalDPFText.g:7970:1: RULE_INT
            {
             before(grammarAccess.getDpfIdAccess().getIdINTTerminalRuleCall_1_1_0()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__DpfId__IdAssignment_1_116035); 
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


    protected DFA3 dfa3 = new DFA3(this);
    protected DFA4 dfa4 = new DFA4(this);
    protected DFA5 dfa5 = new DFA5(this);
    protected DFA6 dfa6 = new DFA6(this);
    protected DFA7 dfa7 = new DFA7(this);
    static final String DFA3_eotS =
        "\23\uffff";
    static final String DFA3_eofS =
        "\23\uffff";
    static final String DFA3_minS =
        "\1\7\1\41\3\uffff\2\7\1\42\1\33\1\37\11\uffff";
    static final String DFA3_maxS =
        "\1\36\1\41\3\uffff\2\7\1\54\1\34\1\40\11\uffff";
    static final String DFA3_acceptS =
        "\2\uffff\1\5\1\6\1\7\5\uffff\1\1\1\4\1\12\1\2\1\3\1\10\1\11\1\14"+
        "\1\13";
    static final String DFA3_specialS =
        "\23\uffff}>";
    static final String[] DFA3_transitionS = {
            "\1\1\16\uffff\1\2\1\uffff\1\3\1\4\1\5\3\uffff\1\6",
            "\1\7",
            "",
            "",
            "",
            "\1\10",
            "\1\11",
            "\1\12\4\uffff\1\15\1\uffff\1\14\1\uffff\1\13\1\16",
            "\1\17\1\20",
            "\1\22\1\21",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA3_eot = DFA.unpackEncodedString(DFA3_eotS);
    static final short[] DFA3_eof = DFA.unpackEncodedString(DFA3_eofS);
    static final char[] DFA3_min = DFA.unpackEncodedStringToUnsignedChars(DFA3_minS);
    static final char[] DFA3_max = DFA.unpackEncodedStringToUnsignedChars(DFA3_maxS);
    static final short[] DFA3_accept = DFA.unpackEncodedString(DFA3_acceptS);
    static final short[] DFA3_special = DFA.unpackEncodedString(DFA3_specialS);
    static final short[][] DFA3_transition;

    static {
        int numStates = DFA3_transitionS.length;
        DFA3_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA3_transition[i] = DFA.unpackEncodedString(DFA3_transitionS[i]);
        }
    }

    class DFA3 extends DFA {

        public DFA3(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 3;
            this.eot = DFA3_eot;
            this.eof = DFA3_eof;
            this.min = DFA3_min;
            this.max = DFA3_max;
            this.accept = DFA3_accept;
            this.special = DFA3_special;
            this.transition = DFA3_transition;
        }
        public String getDescription() {
            return "1031:1: rule__Definition__Alternatives : ( ( ruleInstanceSpecification ) | ( ruleSpecification ) | ( ruleTGraph ) | ( ruleExtSubTGraph ) | ( ruleMakeEmf ) | ( ruleMakeEcore ) | ( ruleMakeImage ) | ( ruleSimpleEvoSpan ) | ( ruleSimpleEvoCospan ) | ( ruleMorphism ) | ( ruleEvoSpan ) | ( ruleEvoCospan ) );";
        }
    }
    static final String DFA4_eotS =
        "\12\uffff";
    static final String DFA4_eofS =
        "\12\uffff";
    static final String DFA4_minS =
        "\1\7\1\56\1\10\1\7\1\56\1\52\1\10\2\uffff\1\52";
    static final String DFA4_maxS =
        "\1\7\1\62\1\10\1\7\1\56\1\62\1\10\2\uffff\1\55";
    static final String DFA4_acceptS =
        "\7\uffff\1\2\1\1\1\uffff";
    static final String DFA4_specialS =
        "\12\uffff}>";
    static final String[] DFA4_transitionS = {
            "\1\1",
            "\1\3\3\uffff\1\2",
            "\1\4",
            "\1\5",
            "\1\3",
            "\1\10\2\uffff\1\7\4\uffff\1\6",
            "\1\11",
            "",
            "",
            "\1\10\2\uffff\1\7"
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
            return "1113:1: rule__Mapping__Alternatives : ( ( ruleMappingNode ) | ( ruleMappingArrow ) );";
        }
    }
    static final String DFA5_eotS =
        "\12\uffff";
    static final String DFA5_eofS =
        "\12\uffff";
    static final String DFA5_minS =
        "\1\7\1\56\1\10\1\7\1\56\1\35\1\10\2\uffff\1\35";
    static final String DFA5_maxS =
        "\1\7\1\62\1\10\1\7\1\56\1\62\1\10\2\uffff\1\55";
    static final String DFA5_acceptS =
        "\7\uffff\1\2\1\1\1\uffff";
    static final String DFA5_specialS =
        "\12\uffff}>";
    static final String[] DFA5_transitionS = {
            "\1\1",
            "\1\3\3\uffff\1\2",
            "\1\4",
            "\1\5",
            "\1\3",
            "\1\10\17\uffff\1\7\4\uffff\1\6",
            "\1\11",
            "",
            "",
            "\1\10\17\uffff\1\7"
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
            return "1135:1: rule__Element__Alternatives : ( ( ( rule__Element__Group_0__0 ) ) | ( ( rule__Element__Group_1__0 ) ) );";
        }
    }
    static final String DFA6_eotS =
        "\32\uffff";
    static final String DFA6_eofS =
        "\26\uffff\1\16\2\uffff\1\16";
    static final String DFA6_minS =
        "\1\7\1\56\1\10\1\7\1\56\1\55\1\10\1\7\1\55\1\56\1\10\1\7\1\56\1"+
        "\34\1\uffff\1\10\1\7\1\34\1\56\1\10\1\7\1\56\1\35\1\10\1\uffff\1"+
        "\35";
    static final String DFA6_maxS =
        "\1\7\1\62\1\10\1\7\1\56\1\62\1\10\1\7\1\55\1\62\1\10\1\57\1\56\1"+
        "\62\1\uffff\1\10\1\60\1\34\1\62\1\10\1\7\1\56\1\62\1\10\1\uffff"+
        "\1\55";
    static final String DFA6_acceptS =
        "\16\uffff\1\2\11\uffff\1\1\1\uffff";
    static final String DFA6_specialS =
        "\32\uffff}>";
    static final String[] DFA6_transitionS = {
            "\1\1",
            "\1\3\3\uffff\1\2",
            "\1\4",
            "\1\5",
            "\1\3",
            "\1\7\4\uffff\1\6",
            "\1\10",
            "\1\11",
            "\1\7",
            "\1\13\3\uffff\1\12",
            "\1\14",
            "\1\15\47\uffff\1\16",
            "\1\13",
            "\1\20\25\uffff\1\17",
            "",
            "\1\21",
            "\1\22\50\uffff\1\16",
            "\1\20",
            "\1\24\3\uffff\1\23",
            "\1\25",
            "\1\26",
            "\1\24",
            "\1\16\7\uffff\1\16\7\uffff\1\30\4\uffff\1\27",
            "\1\31",
            "",
            "\1\16\7\uffff\1\16\7\uffff\1\30"
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
            return "1157:1: rule__Arrows__Alternatives : ( ( ( rule__Arrows__Group_0__0 ) ) | ( ruleArrow ) );";
        }
    }
    static final String DFA7_eotS =
        "\24\uffff";
    static final String DFA7_eofS =
        "\24\uffff";
    static final String DFA7_minS =
        "\1\7\1\56\1\10\1\7\1\56\1\55\1\10\1\7\1\55\1\56\1\10\1\7\1\56\1"+
        "\uffff\1\34\1\10\1\7\1\34\2\uffff";
    static final String DFA7_maxS =
        "\1\7\1\62\1\10\1\7\1\56\1\62\1\10\1\7\1\55\1\62\1\10\1\57\1\56\1"+
        "\uffff\1\62\1\10\1\60\1\34\2\uffff";
    static final String DFA7_acceptS =
        "\15\uffff\1\1\4\uffff\1\3\1\2";
    static final String DFA7_specialS =
        "\24\uffff}>";
    static final String[] DFA7_transitionS = {
            "\1\1",
            "\1\3\3\uffff\1\2",
            "\1\4",
            "\1\5",
            "\1\3",
            "\1\7\4\uffff\1\6",
            "\1\10",
            "\1\11",
            "\1\7",
            "\1\13\3\uffff\1\12",
            "\1\14",
            "\1\16\47\uffff\1\15",
            "\1\13",
            "",
            "\1\20\25\uffff\1\17",
            "\1\21",
            "\1\22\50\uffff\1\23",
            "\1\20",
            "",
            ""
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
            return "1179:1: rule__Arrow__Alternatives : ( ( ( rule__Arrow__Group_0__0 ) ) | ( ( rule__Arrow__Group_1__0 ) ) | ( ( rule__Arrow__Group_2__0 ) ) );";
        }
    }
 

    public static final BitSet FOLLOW_ruleModel_in_entryRuleModel61 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModel68 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__Group__0_in_ruleModel94 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVALUE_in_entryRuleVALUE122 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVALUE129 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VALUE__Alternatives_in_ruleVALUE155 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDefinition_in_entryRuleDefinition182 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDefinition189 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Alternatives_in_ruleDefinition215 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMakeEmf_in_entryRuleMakeEmf242 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMakeEmf249 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MakeEmf__Group__0_in_ruleMakeEmf275 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMakeEcore_in_entryRuleMakeEcore302 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMakeEcore309 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MakeEcore__Group__0_in_ruleMakeEcore335 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMakeImage_in_entryRuleMakeImage362 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMakeImage369 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MakeImage__Group__0_in_ruleMakeImage395 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSimpleEvoSpan_in_entryRuleSimpleEvoSpan422 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSimpleEvoSpan429 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleEvoSpan__Group__0_in_ruleSimpleEvoSpan455 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSimpleEvoCospan_in_entryRuleSimpleEvoCospan482 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSimpleEvoCospan489 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleEvoCospan__Group__0_in_ruleSimpleEvoCospan515 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEvoSpan_in_entryRuleEvoSpan542 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEvoSpan549 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EvoSpan__Group__0_in_ruleEvoSpan575 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEvoCospan_in_entryRuleEvoCospan602 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEvoCospan609 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EvoCospan__Group__0_in_ruleEvoCospan635 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInstanceSpecification_in_entryRuleInstanceSpecification662 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInstanceSpecification669 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__InstanceSpecification__Group__0_in_ruleInstanceSpecification695 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleChoosenSpecfication_in_entryRuleChoosenSpecfication722 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleChoosenSpecfication729 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ChoosenSpecfication__IdAssignment_in_ruleChoosenSpecfication755 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConstraintSemantic_in_entryRuleConstraintSemantic782 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConstraintSemantic789 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConstraintSemantic__Group__0_in_ruleConstraintSemantic815 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSpecification_in_entryRuleSpecification842 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSpecification849 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Specification__Group__0_in_ruleSpecification875 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleChoosenGraph_in_entryRuleChoosenGraph902 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleChoosenGraph909 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ChoosenGraph__IdAssignment_in_ruleChoosenGraph935 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConstraint_in_entryRuleConstraint962 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConstraint969 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Constraint__Group__0_in_ruleConstraint995 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConstraintSignature_in_entryRuleConstraintSignature1022 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConstraintSignature1029 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConstraintSignature__Group__0_in_ruleConstraintSignature1055 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMorphism_in_entryRuleMorphism1082 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMorphism1089 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Morphism__Group__0_in_ruleMorphism1115 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDomain_in_entryRuleDomain1142 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDomain1149 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Domain__IdAssignment_in_ruleDomain1175 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCodomain_in_entryRuleCodomain1202 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCodomain1209 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Codomain__IdAssignment_in_ruleCodomain1235 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMapping_in_entryRuleMapping1262 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMapping1269 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Mapping__Alternatives_in_ruleMapping1295 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMappingNode_in_entryRuleMappingNode1322 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMappingNode1329 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MappingNode__Group__0_in_ruleMappingNode1355 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMappingArrow_in_entryRuleMappingArrow1382 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMappingArrow1389 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MappingArrow__Group__0_in_ruleMappingArrow1415 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExtSubTGraph_in_entryRuleExtSubTGraph1442 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExtSubTGraph1449 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExtSubTGraph__Group__0_in_ruleExtSubTGraph1475 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTGraphExtSubName_in_entryRuleTGraphExtSubName1502 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTGraphExtSubName1509 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TGraphExtSubName__IdAssignment_in_ruleTGraphExtSubName1535 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTGraph_in_entryRuleTGraph1562 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTGraph1569 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TGraph__Group__0_in_ruleTGraph1595 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTGraphName_in_entryRuleTGraphName1622 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTGraphName1629 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TGraphName__IdAssignment_in_ruleTGraphName1655 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleElement_in_entryRuleElement1682 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleElement1689 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Element__Alternatives_in_ruleElement1715 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArrows_in_entryRuleArrows1742 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleArrows1749 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrows__Alternatives_in_ruleArrows1775 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArrow_in_entryRuleArrow1802 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleArrow1809 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrow__Alternatives_in_ruleArrow1835 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNode_in_entryRuleNode1862 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNode1869 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Node__Group__0_in_ruleNode1895 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAttributeValue_in_entryRuleAttributeValue1922 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAttributeValue1929 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AttributeValue__Group__0_in_ruleAttributeValue1955 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDpfId_in_entryRuleDpfId1982 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDpfId1989 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DpfId__Group__0_in_ruleDpfId2015 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DataType__Alternatives_in_ruleDataType2052 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NUMBER_in_rule__VALUE__Alternatives2087 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_CHAR_in_rule__VALUE__Alternatives2104 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__VALUE__Alternatives2121 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInstanceSpecification_in_rule__Definition__Alternatives2153 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSpecification_in_rule__Definition__Alternatives2170 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTGraph_in_rule__Definition__Alternatives2187 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExtSubTGraph_in_rule__Definition__Alternatives2204 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMakeEmf_in_rule__Definition__Alternatives2221 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMakeEcore_in_rule__Definition__Alternatives2238 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMakeImage_in_rule__Definition__Alternatives2255 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSimpleEvoSpan_in_rule__Definition__Alternatives2272 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSimpleEvoCospan_in_rule__Definition__Alternatives2289 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMorphism_in_rule__Definition__Alternatives2306 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEvoSpan_in_rule__Definition__Alternatives2323 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEvoCospan_in_rule__Definition__Alternatives2340 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMappingNode_in_rule__Mapping__Alternatives2372 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMappingArrow_in_rule__Mapping__Alternatives2389 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Element__Group_0__0_in_rule__Element__Alternatives2421 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Element__Group_1__0_in_rule__Element__Alternatives2439 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrows__Group_0__0_in_rule__Arrows__Alternatives2472 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArrow_in_rule__Arrows__Alternatives2490 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrow__Group_0__0_in_rule__Arrow__Alternatives2522 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrow__Group_1__0_in_rule__Arrow__Alternatives2540 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrow__Group_2__0_in_rule__Arrow__Alternatives2558 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__DataType__Alternatives2592 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__DataType__Alternatives2613 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__DataType__Alternatives2634 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__DataType__Alternatives2655 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__DataType__Alternatives2676 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__DataType__Alternatives2697 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__DataType__Alternatives2718 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__DataType__Alternatives2739 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__DataType__Alternatives2760 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__Group__0__Impl_in_rule__Model__Group__02793 = new BitSet(new long[]{0x0000000047400080L});
    public static final BitSet FOLLOW_rule__Model__Group__1_in_rule__Model__Group__02796 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__DefinitionsAssignment_0_in_rule__Model__Group__0__Impl2823 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__Group__1__Impl_in_rule__Model__Group__12853 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__DefinitionsAssignment_1_in_rule__Model__Group__1__Impl2880 = new BitSet(new long[]{0x0000000047400082L});
    public static final BitSet FOLLOW_rule__MakeEmf__Group__0__Impl_in_rule__MakeEmf__Group__02915 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__MakeEmf__Group__1_in_rule__MakeEmf__Group__02918 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rule__MakeEmf__Group__0__Impl2946 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MakeEmf__Group__1__Impl_in_rule__MakeEmf__Group__12977 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_rule__MakeEmf__Group__2_in_rule__MakeEmf__Group__12980 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MakeEmf__IdAssignment_1_in_rule__MakeEmf__Group__1__Impl3007 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MakeEmf__Group__2__Impl_in_rule__MakeEmf__Group__23037 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__MakeEmf__Group__2__Impl3065 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MakeEcore__Group__0__Impl_in_rule__MakeEcore__Group__03102 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__MakeEcore__Group__1_in_rule__MakeEcore__Group__03105 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__MakeEcore__Group__0__Impl3133 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MakeEcore__Group__1__Impl_in_rule__MakeEcore__Group__13164 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_rule__MakeEcore__Group__2_in_rule__MakeEcore__Group__13167 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MakeEcore__IdAssignment_1_in_rule__MakeEcore__Group__1__Impl3194 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MakeEcore__Group__2__Impl_in_rule__MakeEcore__Group__23224 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__MakeEcore__Group__2__Impl3252 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MakeImage__Group__0__Impl_in_rule__MakeImage__Group__03289 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__MakeImage__Group__1_in_rule__MakeImage__Group__03292 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_rule__MakeImage__Group__0__Impl3320 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MakeImage__Group__1__Impl_in_rule__MakeImage__Group__13351 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_rule__MakeImage__Group__2_in_rule__MakeImage__Group__13354 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MakeImage__IdAssignment_1_in_rule__MakeImage__Group__1__Impl3381 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MakeImage__Group__2__Impl_in_rule__MakeImage__Group__23411 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__MakeImage__Group__2__Impl3439 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleEvoSpan__Group__0__Impl_in_rule__SimpleEvoSpan__Group__03476 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__SimpleEvoSpan__Group__1_in_rule__SimpleEvoSpan__Group__03479 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__SimpleEvoSpan__Group__0__Impl3507 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleEvoSpan__Group__1__Impl_in_rule__SimpleEvoSpan__Group__13538 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_rule__SimpleEvoSpan__Group__2_in_rule__SimpleEvoSpan__Group__13541 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleEvoSpan__LhsAssignment_1_in_rule__SimpleEvoSpan__Group__1__Impl3568 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleEvoSpan__Group__2__Impl_in_rule__SimpleEvoSpan__Group__23598 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__SimpleEvoSpan__Group__3_in_rule__SimpleEvoSpan__Group__23601 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_rule__SimpleEvoSpan__Group__2__Impl3629 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleEvoSpan__Group__3__Impl_in_rule__SimpleEvoSpan__Group__33660 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_rule__SimpleEvoSpan__Group__4_in_rule__SimpleEvoSpan__Group__33663 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleEvoSpan__DiffAssignment_3_in_rule__SimpleEvoSpan__Group__3__Impl3690 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleEvoSpan__Group__4__Impl_in_rule__SimpleEvoSpan__Group__43720 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__SimpleEvoSpan__Group__5_in_rule__SimpleEvoSpan__Group__43723 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__SimpleEvoSpan__Group__4__Impl3751 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleEvoSpan__Group__5__Impl_in_rule__SimpleEvoSpan__Group__53782 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_rule__SimpleEvoSpan__Group__6_in_rule__SimpleEvoSpan__Group__53785 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleEvoSpan__RhSAssignment_5_in_rule__SimpleEvoSpan__Group__5__Impl3812 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleEvoSpan__Group__6__Impl_in_rule__SimpleEvoSpan__Group__63842 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__SimpleEvoSpan__Group__7_in_rule__SimpleEvoSpan__Group__63845 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__SimpleEvoSpan__Group__6__Impl3873 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleEvoSpan__Group__7__Impl_in_rule__SimpleEvoSpan__Group__73904 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_rule__SimpleEvoSpan__Group__8_in_rule__SimpleEvoSpan__Group__73907 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleEvoSpan__TypeGraphAssignment_7_in_rule__SimpleEvoSpan__Group__7__Impl3934 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleEvoSpan__Group__8__Impl_in_rule__SimpleEvoSpan__Group__83964 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__SimpleEvoSpan__Group__8__Impl3992 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleEvoCospan__Group__0__Impl_in_rule__SimpleEvoCospan__Group__04041 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__SimpleEvoCospan__Group__1_in_rule__SimpleEvoCospan__Group__04044 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__SimpleEvoCospan__Group__0__Impl4072 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleEvoCospan__Group__1__Impl_in_rule__SimpleEvoCospan__Group__14103 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_rule__SimpleEvoCospan__Group__2_in_rule__SimpleEvoCospan__Group__14106 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleEvoCospan__LhsAssignment_1_in_rule__SimpleEvoCospan__Group__1__Impl4133 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleEvoCospan__Group__2__Impl_in_rule__SimpleEvoCospan__Group__24163 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__SimpleEvoCospan__Group__3_in_rule__SimpleEvoCospan__Group__24166 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__SimpleEvoCospan__Group__2__Impl4194 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleEvoCospan__Group__3__Impl_in_rule__SimpleEvoCospan__Group__34225 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_rule__SimpleEvoCospan__Group__4_in_rule__SimpleEvoCospan__Group__34228 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleEvoCospan__JointAssignment_3_in_rule__SimpleEvoCospan__Group__3__Impl4255 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleEvoCospan__Group__4__Impl_in_rule__SimpleEvoCospan__Group__44285 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__SimpleEvoCospan__Group__5_in_rule__SimpleEvoCospan__Group__44288 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_rule__SimpleEvoCospan__Group__4__Impl4316 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleEvoCospan__Group__5__Impl_in_rule__SimpleEvoCospan__Group__54347 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_rule__SimpleEvoCospan__Group__6_in_rule__SimpleEvoCospan__Group__54350 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleEvoCospan__RhsAssignment_5_in_rule__SimpleEvoCospan__Group__5__Impl4377 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleEvoCospan__Group__6__Impl_in_rule__SimpleEvoCospan__Group__64407 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__SimpleEvoCospan__Group__7_in_rule__SimpleEvoCospan__Group__64410 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__SimpleEvoCospan__Group__6__Impl4438 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleEvoCospan__Group__7__Impl_in_rule__SimpleEvoCospan__Group__74469 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_rule__SimpleEvoCospan__Group__8_in_rule__SimpleEvoCospan__Group__74472 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleEvoCospan__TypeGraphAssignment_7_in_rule__SimpleEvoCospan__Group__7__Impl4499 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleEvoCospan__Group__8__Impl_in_rule__SimpleEvoCospan__Group__84529 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__SimpleEvoCospan__Group__8__Impl4557 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EvoSpan__Group__0__Impl_in_rule__EvoSpan__Group__04606 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__EvoSpan__Group__1_in_rule__EvoSpan__Group__04609 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_rule__EvoSpan__Group__0__Impl4637 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EvoSpan__Group__1__Impl_in_rule__EvoSpan__Group__14668 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_rule__EvoSpan__Group__2_in_rule__EvoSpan__Group__14671 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EvoSpan__LhsAssignment_1_in_rule__EvoSpan__Group__1__Impl4698 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EvoSpan__Group__2__Impl_in_rule__EvoSpan__Group__24728 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__EvoSpan__Group__3_in_rule__EvoSpan__Group__24731 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_rule__EvoSpan__Group__2__Impl4759 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EvoSpan__Group__3__Impl_in_rule__EvoSpan__Group__34790 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_rule__EvoSpan__Group__4_in_rule__EvoSpan__Group__34793 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EvoSpan__RhsAssignment_3_in_rule__EvoSpan__Group__3__Impl4820 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EvoSpan__Group__4__Impl_in_rule__EvoSpan__Group__44850 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__EvoSpan__Group__5_in_rule__EvoSpan__Group__44853 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__EvoSpan__Group__4__Impl4881 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EvoSpan__Group__5__Impl_in_rule__EvoSpan__Group__54912 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_rule__EvoSpan__Group__6_in_rule__EvoSpan__Group__54915 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EvoSpan__TypeGraphAssignment_5_in_rule__EvoSpan__Group__5__Impl4942 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EvoSpan__Group__6__Impl_in_rule__EvoSpan__Group__64972 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__EvoSpan__Group__6__Impl5000 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EvoCospan__Group__0__Impl_in_rule__EvoCospan__Group__05045 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__EvoCospan__Group__1_in_rule__EvoCospan__Group__05048 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_rule__EvoCospan__Group__0__Impl5076 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EvoCospan__Group__1__Impl_in_rule__EvoCospan__Group__15107 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_rule__EvoCospan__Group__2_in_rule__EvoCospan__Group__15110 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EvoCospan__LhsAssignment_1_in_rule__EvoCospan__Group__1__Impl5137 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EvoCospan__Group__2__Impl_in_rule__EvoCospan__Group__25167 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__EvoCospan__Group__3_in_rule__EvoCospan__Group__25170 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_rule__EvoCospan__Group__2__Impl5198 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EvoCospan__Group__3__Impl_in_rule__EvoCospan__Group__35229 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_rule__EvoCospan__Group__4_in_rule__EvoCospan__Group__35232 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EvoCospan__RhsAssignment_3_in_rule__EvoCospan__Group__3__Impl5259 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EvoCospan__Group__4__Impl_in_rule__EvoCospan__Group__45289 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__EvoCospan__Group__5_in_rule__EvoCospan__Group__45292 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__EvoCospan__Group__4__Impl5320 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EvoCospan__Group__5__Impl_in_rule__EvoCospan__Group__55351 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_rule__EvoCospan__Group__6_in_rule__EvoCospan__Group__55354 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EvoCospan__TypeGraphAssignment_5_in_rule__EvoCospan__Group__5__Impl5381 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EvoCospan__Group__6__Impl_in_rule__EvoCospan__Group__65411 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__EvoCospan__Group__6__Impl5439 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__InstanceSpecification__Group__0__Impl_in_rule__InstanceSpecification__Group__05484 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_rule__InstanceSpecification__Group__1_in_rule__InstanceSpecification__Group__05487 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__InstanceSpecification__IdAssignment_0_in_rule__InstanceSpecification__Group__0__Impl5514 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__InstanceSpecification__Group__1__Impl_in_rule__InstanceSpecification__Group__15544 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_rule__InstanceSpecification__Group__2_in_rule__InstanceSpecification__Group__15547 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_rule__InstanceSpecification__Group__1__Impl5575 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__InstanceSpecification__Group__2__Impl_in_rule__InstanceSpecification__Group__25606 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__InstanceSpecification__Group__3_in_rule__InstanceSpecification__Group__25609 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_rule__InstanceSpecification__Group__2__Impl5637 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__InstanceSpecification__Group__3__Impl_in_rule__InstanceSpecification__Group__35668 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_rule__InstanceSpecification__Group__4_in_rule__InstanceSpecification__Group__35671 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__InstanceSpecification__ModelAssignment_3_in_rule__InstanceSpecification__Group__3__Impl5698 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__InstanceSpecification__Group__4__Impl_in_rule__InstanceSpecification__Group__45728 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__InstanceSpecification__Group__5_in_rule__InstanceSpecification__Group__45731 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__InstanceSpecification__Group__4__Impl5759 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__InstanceSpecification__Group__5__Impl_in_rule__InstanceSpecification__Group__55790 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_rule__InstanceSpecification__Group__6_in_rule__InstanceSpecification__Group__55793 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__InstanceSpecification__MetamodelAssignment_5_in_rule__InstanceSpecification__Group__5__Impl5820 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__InstanceSpecification__Group__6__Impl_in_rule__InstanceSpecification__Group__65850 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_rule__InstanceSpecification__Group__7_in_rule__InstanceSpecification__Group__65853 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_rule__InstanceSpecification__Group__6__Impl5881 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__InstanceSpecification__Group__7__Impl_in_rule__InstanceSpecification__Group__75912 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__InstanceSpecification__Group__8_in_rule__InstanceSpecification__Group__75915 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_rule__InstanceSpecification__Group__7__Impl5943 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__InstanceSpecification__Group__8__Impl_in_rule__InstanceSpecification__Group__85974 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_rule__InstanceSpecification__Group__9_in_rule__InstanceSpecification__Group__85977 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__InstanceSpecification__Group_8__0_in_rule__InstanceSpecification__Group__8__Impl6004 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__InstanceSpecification__Group__9__Impl_in_rule__InstanceSpecification__Group__96034 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_rule__InstanceSpecification__Group__9__Impl6062 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__InstanceSpecification__Group_8__0__Impl_in_rule__InstanceSpecification__Group_8__06113 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_rule__InstanceSpecification__Group_8__1_in_rule__InstanceSpecification__Group_8__06116 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__InstanceSpecification__ConstraintSemanticsAssignment_8_0_in_rule__InstanceSpecification__Group_8__0__Impl6143 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__InstanceSpecification__Group_8__1__Impl_in_rule__InstanceSpecification__Group_8__16173 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__InstanceSpecification__Group_8_1__0_in_rule__InstanceSpecification__Group_8__1__Impl6200 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_rule__InstanceSpecification__Group_8_1__0__Impl_in_rule__InstanceSpecification__Group_8_1__06235 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__InstanceSpecification__Group_8_1__1_in_rule__InstanceSpecification__Group_8_1__06238 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__InstanceSpecification__Group_8_1__0__Impl6266 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__InstanceSpecification__Group_8_1__1__Impl_in_rule__InstanceSpecification__Group_8_1__16297 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__InstanceSpecification__ConstraintSemanticsAssignment_8_1_1_in_rule__InstanceSpecification__Group_8_1__1__Impl6324 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConstraintSemantic__Group__0__Impl_in_rule__ConstraintSemantic__Group__06358 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_rule__ConstraintSemantic__Group__1_in_rule__ConstraintSemantic__Group__06361 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConstraintSemantic__IdAssignment_0_in_rule__ConstraintSemantic__Group__0__Impl6388 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConstraintSemantic__Group__1__Impl_in_rule__ConstraintSemantic__Group__16418 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__ConstraintSemantic__Group__2_in_rule__ConstraintSemantic__Group__16421 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_rule__ConstraintSemantic__Group__1__Impl6449 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConstraintSemantic__Group__2__Impl_in_rule__ConstraintSemantic__Group__26480 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_rule__ConstraintSemantic__Group__3_in_rule__ConstraintSemantic__Group__26483 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConstraintSemantic__Group_2__0_in_rule__ConstraintSemantic__Group__2__Impl6510 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConstraintSemantic__Group__3__Impl_in_rule__ConstraintSemantic__Group__36540 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_rule__ConstraintSemantic__Group__4_in_rule__ConstraintSemantic__Group__36543 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__ConstraintSemantic__Group__3__Impl6571 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConstraintSemantic__Group__4__Impl_in_rule__ConstraintSemantic__Group__46602 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_rule__ConstraintSemantic__Group__5_in_rule__ConstraintSemantic__Group__46605 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_rule__ConstraintSemantic__Group__4__Impl6633 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConstraintSemantic__Group__5__Impl_in_rule__ConstraintSemantic__Group__56664 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__ConstraintSemantic__Group__6_in_rule__ConstraintSemantic__Group__56667 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_rule__ConstraintSemantic__Group__5__Impl6695 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConstraintSemantic__Group__6__Impl_in_rule__ConstraintSemantic__Group__66726 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConstraintSemantic__OclAssignment_6_in_rule__ConstraintSemantic__Group__6__Impl6753 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConstraintSemantic__Group_2__0__Impl_in_rule__ConstraintSemantic__Group_2__06797 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_rule__ConstraintSemantic__Group_2__1_in_rule__ConstraintSemantic__Group_2__06800 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConstraintSemantic__ArrowsAssignment_2_0_in_rule__ConstraintSemantic__Group_2__0__Impl6827 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConstraintSemantic__Group_2__1__Impl_in_rule__ConstraintSemantic__Group_2__16857 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConstraintSemantic__Group_2_1__0_in_rule__ConstraintSemantic__Group_2__1__Impl6884 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_rule__ConstraintSemantic__Group_2_1__0__Impl_in_rule__ConstraintSemantic__Group_2_1__06919 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__ConstraintSemantic__Group_2_1__1_in_rule__ConstraintSemantic__Group_2_1__06922 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__ConstraintSemantic__Group_2_1__0__Impl6950 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConstraintSemantic__Group_2_1__1__Impl_in_rule__ConstraintSemantic__Group_2_1__16981 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConstraintSemantic__ArrowsAssignment_2_1_1_in_rule__ConstraintSemantic__Group_2_1__1__Impl7008 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Specification__Group__0__Impl_in_rule__Specification__Group__07042 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_rule__Specification__Group__1_in_rule__Specification__Group__07045 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Specification__IdAssignment_0_in_rule__Specification__Group__0__Impl7072 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Specification__Group__1__Impl_in_rule__Specification__Group__17102 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_rule__Specification__Group__2_in_rule__Specification__Group__17105 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_rule__Specification__Group__1__Impl7133 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Specification__Group__2__Impl_in_rule__Specification__Group__27164 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__Specification__Group__3_in_rule__Specification__Group__27167 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_rule__Specification__Group__2__Impl7195 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Specification__Group__3__Impl_in_rule__Specification__Group__37226 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_rule__Specification__Group__4_in_rule__Specification__Group__37229 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Specification__GraphAssignment_3_in_rule__Specification__Group__3__Impl7256 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Specification__Group__4__Impl_in_rule__Specification__Group__47286 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_rule__Specification__Group__5_in_rule__Specification__Group__47289 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_rule__Specification__Group__4__Impl7317 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Specification__Group__5__Impl_in_rule__Specification__Group__57348 = new BitSet(new long[]{0x0000002000000080L});
    public static final BitSet FOLLOW_rule__Specification__Group__6_in_rule__Specification__Group__57351 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_rule__Specification__Group__5__Impl7379 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Specification__Group__6__Impl_in_rule__Specification__Group__67410 = new BitSet(new long[]{0x0000002000000080L});
    public static final BitSet FOLLOW_rule__Specification__Group__7_in_rule__Specification__Group__67413 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Specification__Group_6__0_in_rule__Specification__Group__6__Impl7440 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Specification__Group__7__Impl_in_rule__Specification__Group__77471 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_rule__Specification__Group__7__Impl7499 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Specification__Group_6__0__Impl_in_rule__Specification__Group_6__07546 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_rule__Specification__Group_6__1_in_rule__Specification__Group_6__07549 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Specification__ConstraintsAssignment_6_0_in_rule__Specification__Group_6__0__Impl7576 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Specification__Group_6__1__Impl_in_rule__Specification__Group_6__17606 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Specification__Group_6_1__0_in_rule__Specification__Group_6__1__Impl7633 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_rule__Specification__Group_6_1__0__Impl_in_rule__Specification__Group_6_1__07668 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__Specification__Group_6_1__1_in_rule__Specification__Group_6_1__07671 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__Specification__Group_6_1__0__Impl7699 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Specification__Group_6_1__1__Impl_in_rule__Specification__Group_6_1__17730 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Specification__ConstraintsAssignment_6_1_1_in_rule__Specification__Group_6_1__1__Impl7757 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Constraint__Group__0__Impl_in_rule__Constraint__Group__07791 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_rule__Constraint__Group__1_in_rule__Constraint__Group__07794 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Constraint__SignatureAssignment_0_in_rule__Constraint__Group__0__Impl7821 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Constraint__Group__1__Impl_in_rule__Constraint__Group__17851 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__Constraint__Group__2_in_rule__Constraint__Group__17854 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_rule__Constraint__Group__1__Impl7882 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Constraint__Group__2__Impl_in_rule__Constraint__Group__27913 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_rule__Constraint__Group__3_in_rule__Constraint__Group__27916 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Constraint__Group_2__0_in_rule__Constraint__Group__2__Impl7943 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Constraint__Group__3__Impl_in_rule__Constraint__Group__37973 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_rule__Constraint__Group__3__Impl8001 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Constraint__Group_2__0__Impl_in_rule__Constraint__Group_2__08040 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_rule__Constraint__Group_2__1_in_rule__Constraint__Group_2__08043 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Constraint__ArrowsAssignment_2_0_in_rule__Constraint__Group_2__0__Impl8070 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Constraint__Group_2__1__Impl_in_rule__Constraint__Group_2__18100 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Constraint__Group_2_1__0_in_rule__Constraint__Group_2__1__Impl8127 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_rule__Constraint__Group_2_1__0__Impl_in_rule__Constraint__Group_2_1__08162 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__Constraint__Group_2_1__1_in_rule__Constraint__Group_2_1__08165 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__Constraint__Group_2_1__0__Impl8193 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Constraint__Group_2_1__1__Impl_in_rule__Constraint__Group_2_1__18224 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Constraint__ArrowsAssignment_2_1_1_in_rule__Constraint__Group_2_1__1__Impl8251 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConstraintSignature__Group__0__Impl_in_rule__ConstraintSignature__Group__08285 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_rule__ConstraintSignature__Group__1_in_rule__ConstraintSignature__Group__08288 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConstraintSignature__IdAssignment_0_in_rule__ConstraintSignature__Group__0__Impl8315 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConstraintSignature__Group__1__Impl_in_rule__ConstraintSignature__Group__18345 = new BitSet(new long[]{0x0000000000800080L});
    public static final BitSet FOLLOW_rule__ConstraintSignature__Group__2_in_rule__ConstraintSignature__Group__18348 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_rule__ConstraintSignature__Group__1__Impl8376 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConstraintSignature__Group__2__Impl_in_rule__ConstraintSignature__Group__28407 = new BitSet(new long[]{0x0000000000800080L});
    public static final BitSet FOLLOW_rule__ConstraintSignature__Group__3_in_rule__ConstraintSignature__Group__28410 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConstraintSignature__Group_2__0_in_rule__ConstraintSignature__Group__2__Impl8437 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConstraintSignature__Group__3__Impl_in_rule__ConstraintSignature__Group__38468 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__ConstraintSignature__Group__3__Impl8496 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConstraintSignature__Group_2__0__Impl_in_rule__ConstraintSignature__Group_2__08535 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_rule__ConstraintSignature__Group_2__1_in_rule__ConstraintSignature__Group_2__08538 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConstraintSignature__ParameterAssignment_2_0_in_rule__ConstraintSignature__Group_2__0__Impl8565 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConstraintSignature__Group_2__1__Impl_in_rule__ConstraintSignature__Group_2__18595 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConstraintSignature__Group_2_1__0_in_rule__ConstraintSignature__Group_2__1__Impl8622 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_rule__ConstraintSignature__Group_2_1__0__Impl_in_rule__ConstraintSignature__Group_2_1__08657 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__ConstraintSignature__Group_2_1__1_in_rule__ConstraintSignature__Group_2_1__08660 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__ConstraintSignature__Group_2_1__0__Impl8688 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConstraintSignature__Group_2_1__1__Impl_in_rule__ConstraintSignature__Group_2_1__18719 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConstraintSignature__ParameterAssignment_2_1_1_in_rule__ConstraintSignature__Group_2_1__1__Impl8746 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Morphism__Group__0__Impl_in_rule__Morphism__Group__08780 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_rule__Morphism__Group__1_in_rule__Morphism__Group__08783 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Morphism__Group__0__Impl8810 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Morphism__Group__1__Impl_in_rule__Morphism__Group__18839 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_rule__Morphism__Group__2_in_rule__Morphism__Group__18842 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_rule__Morphism__Group__1__Impl8870 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Morphism__Group__2__Impl_in_rule__Morphism__Group__28901 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__Morphism__Group__3_in_rule__Morphism__Group__28904 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_rule__Morphism__Group__2__Impl8932 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Morphism__Group__3__Impl_in_rule__Morphism__Group__38963 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_rule__Morphism__Group__4_in_rule__Morphism__Group__38966 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Morphism__DomainAssignment_3_in_rule__Morphism__Group__3__Impl8993 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Morphism__Group__4__Impl_in_rule__Morphism__Group__49023 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__Morphism__Group__5_in_rule__Morphism__Group__49026 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__Morphism__Group__4__Impl9054 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Morphism__Group__5__Impl_in_rule__Morphism__Group__59085 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_rule__Morphism__Group__6_in_rule__Morphism__Group__59088 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Morphism__CodmainAssignment_5_in_rule__Morphism__Group__5__Impl9115 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Morphism__Group__6__Impl_in_rule__Morphism__Group__69145 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_rule__Morphism__Group__7_in_rule__Morphism__Group__69148 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_rule__Morphism__Group__6__Impl9176 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Morphism__Group__7__Impl_in_rule__Morphism__Group__79207 = new BitSet(new long[]{0x0000002000000080L});
    public static final BitSet FOLLOW_rule__Morphism__Group__8_in_rule__Morphism__Group__79210 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_rule__Morphism__Group__7__Impl9238 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Morphism__Group__8__Impl_in_rule__Morphism__Group__89269 = new BitSet(new long[]{0x0000002000000080L});
    public static final BitSet FOLLOW_rule__Morphism__Group__9_in_rule__Morphism__Group__89272 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Morphism__Group_8__0_in_rule__Morphism__Group__8__Impl9299 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Morphism__Group__9__Impl_in_rule__Morphism__Group__99330 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_rule__Morphism__Group__9__Impl9358 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Morphism__Group_8__0__Impl_in_rule__Morphism__Group_8__09409 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_rule__Morphism__Group_8__1_in_rule__Morphism__Group_8__09412 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Morphism__MappingsAssignment_8_0_in_rule__Morphism__Group_8__0__Impl9439 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Morphism__Group_8__1__Impl_in_rule__Morphism__Group_8__19469 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Morphism__Group_8_1__0_in_rule__Morphism__Group_8__1__Impl9496 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_rule__Morphism__Group_8_1__0__Impl_in_rule__Morphism__Group_8_1__09531 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__Morphism__Group_8_1__1_in_rule__Morphism__Group_8_1__09534 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__Morphism__Group_8_1__0__Impl9562 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Morphism__Group_8_1__1__Impl_in_rule__Morphism__Group_8_1__19593 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Morphism__MappingsAssignment_8_1_1_in_rule__Morphism__Group_8_1__1__Impl9620 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MappingNode__Group__0__Impl_in_rule__MappingNode__Group__09654 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_rule__MappingNode__Group__1_in_rule__MappingNode__Group__09657 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MappingNode__DomainAssignment_0_in_rule__MappingNode__Group__0__Impl9684 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MappingNode__Group__1__Impl_in_rule__MappingNode__Group__19714 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__MappingNode__Group__2_in_rule__MappingNode__Group__19717 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_rule__MappingNode__Group__1__Impl9745 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MappingNode__Group__2__Impl_in_rule__MappingNode__Group__29776 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MappingNode__CodomainAssignment_2_in_rule__MappingNode__Group__2__Impl9803 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MappingArrow__Group__0__Impl_in_rule__MappingArrow__Group__09839 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_rule__MappingArrow__Group__1_in_rule__MappingArrow__Group__09842 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MappingArrow__DomainAssignment_0_in_rule__MappingArrow__Group__0__Impl9869 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MappingArrow__Group__1__Impl_in_rule__MappingArrow__Group__19899 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__MappingArrow__Group__2_in_rule__MappingArrow__Group__19902 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_rule__MappingArrow__Group__1__Impl9930 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MappingArrow__Group__2__Impl_in_rule__MappingArrow__Group__29961 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MappingArrow__CodmainAssignment_2_in_rule__MappingArrow__Group__2__Impl9988 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExtSubTGraph__Group__0__Impl_in_rule__ExtSubTGraph__Group__010024 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_rule__ExtSubTGraph__Group__1_in_rule__ExtSubTGraph__Group__010027 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExtSubTGraph__IdAssignment_0_in_rule__ExtSubTGraph__Group__0__Impl10054 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExtSubTGraph__Group__1__Impl_in_rule__ExtSubTGraph__Group__110084 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_rule__ExtSubTGraph__Group__2_in_rule__ExtSubTGraph__Group__110087 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_rule__ExtSubTGraph__Group__1__Impl10115 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExtSubTGraph__Group__2__Impl_in_rule__ExtSubTGraph__Group__210146 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__ExtSubTGraph__Group__3_in_rule__ExtSubTGraph__Group__210149 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_rule__ExtSubTGraph__Group__2__Impl10177 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExtSubTGraph__Group__3__Impl_in_rule__ExtSubTGraph__Group__310208 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_rule__ExtSubTGraph__Group__4_in_rule__ExtSubTGraph__Group__310211 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExtSubTGraph__ExtendsGraphAssignment_3_in_rule__ExtSubTGraph__Group__3__Impl10238 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExtSubTGraph__Group__4__Impl_in_rule__ExtSubTGraph__Group__410268 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_rule__ExtSubTGraph__Group__5_in_rule__ExtSubTGraph__Group__410271 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_rule__ExtSubTGraph__Group__4__Impl10299 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExtSubTGraph__Group__5__Impl_in_rule__ExtSubTGraph__Group__510330 = new BitSet(new long[]{0x0000002000000080L});
    public static final BitSet FOLLOW_rule__ExtSubTGraph__Group__6_in_rule__ExtSubTGraph__Group__510333 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_rule__ExtSubTGraph__Group__5__Impl10361 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExtSubTGraph__Group__6__Impl_in_rule__ExtSubTGraph__Group__610392 = new BitSet(new long[]{0x0000002000000080L});
    public static final BitSet FOLLOW_rule__ExtSubTGraph__Group__7_in_rule__ExtSubTGraph__Group__610395 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExtSubTGraph__ElementsAssignment_6_in_rule__ExtSubTGraph__Group__6__Impl10422 = new BitSet(new long[]{0x0000000000000082L});
    public static final BitSet FOLLOW_rule__ExtSubTGraph__Group__7__Impl_in_rule__ExtSubTGraph__Group__710453 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_rule__ExtSubTGraph__Group__7__Impl10481 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TGraph__Group__0__Impl_in_rule__TGraph__Group__010528 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_rule__TGraph__Group__1_in_rule__TGraph__Group__010531 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TGraph__IdAssignment_0_in_rule__TGraph__Group__0__Impl10558 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TGraph__Group__1__Impl_in_rule__TGraph__Group__110588 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_rule__TGraph__Group__2_in_rule__TGraph__Group__110591 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_rule__TGraph__Group__1__Impl10619 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TGraph__Group__2__Impl_in_rule__TGraph__Group__210650 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__TGraph__Group__3_in_rule__TGraph__Group__210653 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_rule__TGraph__Group__2__Impl10681 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TGraph__Group__3__Impl_in_rule__TGraph__Group__310712 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_rule__TGraph__Group__4_in_rule__TGraph__Group__310715 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TGraph__TypeGraphAssignment_3_in_rule__TGraph__Group__3__Impl10742 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TGraph__Group__4__Impl_in_rule__TGraph__Group__410772 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_rule__TGraph__Group__5_in_rule__TGraph__Group__410775 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_rule__TGraph__Group__4__Impl10803 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TGraph__Group__5__Impl_in_rule__TGraph__Group__510834 = new BitSet(new long[]{0x0000002000000080L});
    public static final BitSet FOLLOW_rule__TGraph__Group__6_in_rule__TGraph__Group__510837 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_rule__TGraph__Group__5__Impl10865 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TGraph__Group__6__Impl_in_rule__TGraph__Group__610896 = new BitSet(new long[]{0x0000002000000080L});
    public static final BitSet FOLLOW_rule__TGraph__Group__7_in_rule__TGraph__Group__610899 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TGraph__ElementsAssignment_6_in_rule__TGraph__Group__6__Impl10926 = new BitSet(new long[]{0x0000000000000082L});
    public static final BitSet FOLLOW_rule__TGraph__Group__7__Impl_in_rule__TGraph__Group__710957 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_rule__TGraph__Group__7__Impl10985 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Element__Group_0__0__Impl_in_rule__Element__Group_0__011032 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_rule__Element__Group_0__1_in_rule__Element__Group_0__011035 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNode_in_rule__Element__Group_0__0__Impl11062 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Element__Group_0__1__Impl_in_rule__Element__Group_0__111091 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__Element__Group_0__1__Impl11119 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Element__Group_1__0__Impl_in_rule__Element__Group_1__011154 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_rule__Element__Group_1__1_in_rule__Element__Group_1__011157 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArrows_in_rule__Element__Group_1__0__Impl11184 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Element__Group_1__1__Impl_in_rule__Element__Group_1__111213 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__Element__Group_1__1__Impl11241 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrows__Group_0__0__Impl_in_rule__Arrows__Group_0__011276 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_rule__Arrows__Group_0__1_in_rule__Arrows__Group_0__011279 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrows__SrAssignment_0_0_in_rule__Arrows__Group_0__0__Impl11306 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrows__Group_0__1__Impl_in_rule__Arrows__Group_0__111336 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__Arrows__Group_0__2_in_rule__Arrows__Group_0__111339 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_rule__Arrows__Group_0__1__Impl11367 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrows__Group_0__2__Impl_in_rule__Arrows__Group_0__211398 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_rule__Arrows__Group_0__3_in_rule__Arrows__Group_0__211401 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrows__IdAssignment_0_2_in_rule__Arrows__Group_0__2__Impl11428 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrows__Group_0__3__Impl_in_rule__Arrows__Group_0__311458 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__Arrows__Group_0__4_in_rule__Arrows__Group_0__311461 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_rule__Arrows__Group_0__3__Impl11489 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrows__Group_0__4__Impl_in_rule__Arrows__Group_0__411520 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_rule__Arrows__Group_0__5_in_rule__Arrows__Group_0__411523 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrows__TypeAssignment_0_4_in_rule__Arrows__Group_0__4__Impl11550 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrows__Group_0__5__Impl_in_rule__Arrows__Group_0__511580 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__Arrows__Group_0__6_in_rule__Arrows__Group_0__511583 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__Arrows__Group_0__5__Impl11611 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrows__Group_0__6__Impl_in_rule__Arrows__Group_0__611642 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrows__NextAssignment_0_6_in_rule__Arrows__Group_0__6__Impl11669 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrow__Group_0__0__Impl_in_rule__Arrow__Group_0__011713 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_rule__Arrow__Group_0__1_in_rule__Arrow__Group_0__011716 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrow__SrAssignment_0_0_in_rule__Arrow__Group_0__0__Impl11743 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrow__Group_0__1__Impl_in_rule__Arrow__Group_0__111773 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__Arrow__Group_0__2_in_rule__Arrow__Group_0__111776 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_rule__Arrow__Group_0__1__Impl11804 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrow__Group_0__2__Impl_in_rule__Arrow__Group_0__211835 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_rule__Arrow__Group_0__3_in_rule__Arrow__Group_0__211838 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrow__IdAssignment_0_2_in_rule__Arrow__Group_0__2__Impl11865 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrow__Group_0__3__Impl_in_rule__Arrow__Group_0__311895 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_rule__Arrow__Group_0__4_in_rule__Arrow__Group_0__311898 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_rule__Arrow__Group_0__3__Impl11926 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrow__Group_0__4__Impl_in_rule__Arrow__Group_0__411957 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_rule__Arrow__Group_0__5_in_rule__Arrow__Group_0__411960 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_rule__Arrow__Group_0__4__Impl11988 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrow__Group_0__5__Impl_in_rule__Arrow__Group_0__512019 = new BitSet(new long[]{0x00000000003FE000L});
    public static final BitSet FOLLOW_rule__Arrow__Group_0__6_in_rule__Arrow__Group_0__512022 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__Arrow__Group_0__5__Impl12050 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrow__Group_0__6__Impl_in_rule__Arrow__Group_0__612081 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrow__TgDataTypeAssignment_0_6_in_rule__Arrow__Group_0__6__Impl12108 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrow__Group_1__0__Impl_in_rule__Arrow__Group_1__012152 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_rule__Arrow__Group_1__1_in_rule__Arrow__Group_1__012155 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrow__SrAssignment_1_0_in_rule__Arrow__Group_1__0__Impl12182 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrow__Group_1__1__Impl_in_rule__Arrow__Group_1__112212 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__Arrow__Group_1__2_in_rule__Arrow__Group_1__112215 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_rule__Arrow__Group_1__1__Impl12243 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrow__Group_1__2__Impl_in_rule__Arrow__Group_1__212274 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_rule__Arrow__Group_1__3_in_rule__Arrow__Group_1__212277 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrow__IdAssignment_1_2_in_rule__Arrow__Group_1__2__Impl12304 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrow__Group_1__3__Impl_in_rule__Arrow__Group_1__312334 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__Arrow__Group_1__4_in_rule__Arrow__Group_1__312337 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_rule__Arrow__Group_1__3__Impl12365 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrow__Group_1__4__Impl_in_rule__Arrow__Group_1__412396 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_rule__Arrow__Group_1__5_in_rule__Arrow__Group_1__412399 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrow__TypeAssignment_1_4_in_rule__Arrow__Group_1__4__Impl12426 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrow__Group_1__5__Impl_in_rule__Arrow__Group_1__512456 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_rule__Arrow__Group_1__6_in_rule__Arrow__Group_1__512459 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__Arrow__Group_1__5__Impl12487 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrow__Group_1__6__Impl_in_rule__Arrow__Group_1__612518 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrow__TgValueAssignment_1_6_in_rule__Arrow__Group_1__6__Impl12545 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrow__Group_2__0__Impl_in_rule__Arrow__Group_2__012589 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_rule__Arrow__Group_2__1_in_rule__Arrow__Group_2__012592 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrow__SrAssignment_2_0_in_rule__Arrow__Group_2__0__Impl12619 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrow__Group_2__1__Impl_in_rule__Arrow__Group_2__112649 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__Arrow__Group_2__2_in_rule__Arrow__Group_2__112652 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_rule__Arrow__Group_2__1__Impl12680 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrow__Group_2__2__Impl_in_rule__Arrow__Group_2__212711 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_rule__Arrow__Group_2__3_in_rule__Arrow__Group_2__212714 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrow__IdAssignment_2_2_in_rule__Arrow__Group_2__2__Impl12741 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrow__Group_2__3__Impl_in_rule__Arrow__Group_2__312771 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__Arrow__Group_2__4_in_rule__Arrow__Group_2__312774 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_rule__Arrow__Group_2__3__Impl12802 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrow__Group_2__4__Impl_in_rule__Arrow__Group_2__412833 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_rule__Arrow__Group_2__5_in_rule__Arrow__Group_2__412836 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrow__TypeAssignment_2_4_in_rule__Arrow__Group_2__4__Impl12863 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrow__Group_2__5__Impl_in_rule__Arrow__Group_2__512893 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__Arrow__Group_2__6_in_rule__Arrow__Group_2__512896 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__Arrow__Group_2__5__Impl12924 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrow__Group_2__6__Impl_in_rule__Arrow__Group_2__612955 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrow__TgNodeAssignment_2_6_in_rule__Arrow__Group_2__6__Impl12982 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Node__Group__0__Impl_in_rule__Node__Group__013026 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_rule__Node__Group__1_in_rule__Node__Group__013029 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Node__IdAssignment_0_in_rule__Node__Group__0__Impl13056 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Node__Group__1__Impl_in_rule__Node__Group__113086 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__Node__Group__2_in_rule__Node__Group__113089 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_rule__Node__Group__1__Impl13117 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Node__Group__2__Impl_in_rule__Node__Group__213148 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Node__TypeAssignment_2_in_rule__Node__Group__2__Impl13175 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AttributeValue__Group__0__Impl_in_rule__AttributeValue__Group__013211 = new BitSet(new long[]{0x0000000000000070L});
    public static final BitSet FOLLOW_rule__AttributeValue__Group__1_in_rule__AttributeValue__Group__013214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_rule__AttributeValue__Group__0__Impl13242 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AttributeValue__Group__1__Impl_in_rule__AttributeValue__Group__113273 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_rule__AttributeValue__Group__2_in_rule__AttributeValue__Group__113276 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AttributeValue__ValueAssignment_1_in_rule__AttributeValue__Group__1__Impl13303 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AttributeValue__Group__2__Impl_in_rule__AttributeValue__Group__213333 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_rule__AttributeValue__Group__2__Impl13361 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DpfId__Group__0__Impl_in_rule__DpfId__Group__013398 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_rule__DpfId__Group__1_in_rule__DpfId__Group__013401 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DpfId__NameAssignment_0_in_rule__DpfId__Group__0__Impl13428 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DpfId__Group__1__Impl_in_rule__DpfId__Group__113458 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DpfId__Group_1__0_in_rule__DpfId__Group__1__Impl13485 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DpfId__Group_1__0__Impl_in_rule__DpfId__Group_1__013520 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_rule__DpfId__Group_1__1_in_rule__DpfId__Group_1__013523 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_rule__DpfId__Group_1__0__Impl13551 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DpfId__Group_1__1__Impl_in_rule__DpfId__Group_1__113582 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DpfId__IdAssignment_1_1_in_rule__DpfId__Group_1__1__Impl13609 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDefinition_in_rule__Model__DefinitionsAssignment_013648 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDefinition_in_rule__Model__DefinitionsAssignment_113679 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__MakeEmf__IdAssignment_113710 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__MakeEcore__IdAssignment_113741 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__MakeImage__IdAssignment_113772 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__SimpleEvoSpan__LhsAssignment_113803 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__SimpleEvoSpan__DiffAssignment_313834 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__SimpleEvoSpan__RhSAssignment_513865 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__SimpleEvoSpan__TypeGraphAssignment_713896 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__SimpleEvoCospan__LhsAssignment_113927 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__SimpleEvoCospan__JointAssignment_313958 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__SimpleEvoCospan__RhsAssignment_513989 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__SimpleEvoCospan__TypeGraphAssignment_714020 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__EvoSpan__LhsAssignment_114051 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__EvoSpan__RhsAssignment_314082 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__EvoSpan__TypeGraphAssignment_514113 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__EvoCospan__LhsAssignment_114144 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__EvoCospan__RhsAssignment_314175 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__EvoCospan__TypeGraphAssignment_514206 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__InstanceSpecification__IdAssignment_014237 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleChoosenSpecfication_in_rule__InstanceSpecification__ModelAssignment_314268 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleChoosenSpecfication_in_rule__InstanceSpecification__MetamodelAssignment_514299 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConstraintSemantic_in_rule__InstanceSpecification__ConstraintSemanticsAssignment_8_014330 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConstraintSemantic_in_rule__InstanceSpecification__ConstraintSemanticsAssignment_8_1_114361 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ChoosenSpecfication__IdAssignment14392 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDpfId_in_rule__ConstraintSemantic__IdAssignment_014423 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArrows_in_rule__ConstraintSemantic__ArrowsAssignment_2_014454 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArrows_in_rule__ConstraintSemantic__ArrowsAssignment_2_1_114485 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__ConstraintSemantic__OclAssignment_614516 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Specification__IdAssignment_014547 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleChoosenGraph_in_rule__Specification__GraphAssignment_314578 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConstraint_in_rule__Specification__ConstraintsAssignment_6_014609 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConstraint_in_rule__Specification__ConstraintsAssignment_6_1_114640 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ChoosenGraph__IdAssignment14671 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConstraintSignature_in_rule__Constraint__SignatureAssignment_014702 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArrows_in_rule__Constraint__ArrowsAssignment_2_014733 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArrows_in_rule__Constraint__ArrowsAssignment_2_1_114764 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDpfId_in_rule__ConstraintSignature__IdAssignment_014795 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ConstraintSignature__ParameterAssignment_2_014826 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ConstraintSignature__ParameterAssignment_2_1_114857 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDomain_in_rule__Morphism__DomainAssignment_314888 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCodomain_in_rule__Morphism__CodmainAssignment_514919 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMapping_in_rule__Morphism__MappingsAssignment_8_014950 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMapping_in_rule__Morphism__MappingsAssignment_8_1_114981 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Domain__IdAssignment15012 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Codomain__IdAssignment15043 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNode_in_rule__MappingNode__DomainAssignment_015074 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNode_in_rule__MappingNode__CodomainAssignment_215105 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArrow_in_rule__MappingArrow__DomainAssignment_015136 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArrow_in_rule__MappingArrow__CodmainAssignment_215167 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ExtSubTGraph__IdAssignment_015198 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTGraphExtSubName_in_rule__ExtSubTGraph__ExtendsGraphAssignment_315229 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleElement_in_rule__ExtSubTGraph__ElementsAssignment_615260 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__TGraphExtSubName__IdAssignment15291 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__TGraph__IdAssignment_015322 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTGraphName_in_rule__TGraph__TypeGraphAssignment_315353 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleElement_in_rule__TGraph__ElementsAssignment_615384 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__TGraphName__IdAssignment15415 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNode_in_rule__Arrows__SrAssignment_0_015446 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDpfId_in_rule__Arrows__IdAssignment_0_215477 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDpfId_in_rule__Arrows__TypeAssignment_0_415508 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArrows_in_rule__Arrows__NextAssignment_0_615539 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNode_in_rule__Arrow__SrAssignment_0_015570 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDpfId_in_rule__Arrow__IdAssignment_0_215601 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDataType_in_rule__Arrow__TgDataTypeAssignment_0_615632 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNode_in_rule__Arrow__SrAssignment_1_015663 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDpfId_in_rule__Arrow__IdAssignment_1_215694 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDpfId_in_rule__Arrow__TypeAssignment_1_415725 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAttributeValue_in_rule__Arrow__TgValueAssignment_1_615756 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNode_in_rule__Arrow__SrAssignment_2_015787 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDpfId_in_rule__Arrow__IdAssignment_2_215818 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDpfId_in_rule__Arrow__TypeAssignment_2_415849 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNode_in_rule__Arrow__TgNodeAssignment_2_615880 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDpfId_in_rule__Node__IdAssignment_015911 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDpfId_in_rule__Node__TypeAssignment_215942 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVALUE_in_rule__AttributeValue__ValueAssignment_115973 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__DpfId__NameAssignment_016004 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__DpfId__IdAssignment_1_116035 = new BitSet(new long[]{0x0000000000000002L});

}