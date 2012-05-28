package no.hib.dpf.text.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import no.hib.dpf.text.services.DPFTextGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalDPFTextParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_NUMBER", "RULE_CHAR", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ANY_OTHER", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "'emf('", "')'", "'ecore('", "'image('", "'simpleEvolution('", "'<-'", "'->'", "','", "'evolution('", "'<->'", "'-><-'", "':='", "'ISpec<'", "'>'", "'{'", "'}'", "'='", "'Spec<'", "'('", "'Morphism<'", "'=>'", "'ExtSubTGraph<'", "'TGraph<'", "'-'", "':'", "'*'", "'['", "']'", "'@'", "'Boolean'", "'Char'", "'Byte'", "'Short'", "'Int'", "'Long'", "'Float'", "'Double'", "'String'"
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
    public String getGrammarFileName() { return "../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g"; }



     	private DPFTextGrammarAccess grammarAccess;
     	
        public InternalDPFTextParser(TokenStream input, DPFTextGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Model";	
       	}
       	
       	@Override
       	protected DPFTextGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleModel"
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:68:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:69:2: (iv_ruleModel= ruleModel EOF )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:70:2: iv_ruleModel= ruleModel EOF
            {
             newCompositeNode(grammarAccess.getModelRule()); 
            pushFollow(FOLLOW_ruleModel_in_entryRuleModel75);
            iv_ruleModel=ruleModel();

            state._fsp--;

             current =iv_ruleModel; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleModel85); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:77:1: ruleModel returns [EObject current=null] : ( ( (lv_definitions_0_0= ruleDefinition ) ) ( (lv_definitions_1_0= ruleDefinition ) )* )? ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_definitions_0_0 = null;

        EObject lv_definitions_1_0 = null;


         enterRule(); 
            
        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:80:28: ( ( ( (lv_definitions_0_0= ruleDefinition ) ) ( (lv_definitions_1_0= ruleDefinition ) )* )? )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:81:1: ( ( (lv_definitions_0_0= ruleDefinition ) ) ( (lv_definitions_1_0= ruleDefinition ) )* )?
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:81:1: ( ( (lv_definitions_0_0= ruleDefinition ) ) ( (lv_definitions_1_0= ruleDefinition ) )* )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==RULE_ID||LA2_0==13||(LA2_0>=15 && LA2_0<=17)||LA2_0==21) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:81:2: ( (lv_definitions_0_0= ruleDefinition ) ) ( (lv_definitions_1_0= ruleDefinition ) )*
                    {
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:81:2: ( (lv_definitions_0_0= ruleDefinition ) )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:82:1: (lv_definitions_0_0= ruleDefinition )
                    {
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:82:1: (lv_definitions_0_0= ruleDefinition )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:83:3: lv_definitions_0_0= ruleDefinition
                    {
                     
                    	        newCompositeNode(grammarAccess.getModelAccess().getDefinitionsDefinitionParserRuleCall_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDefinition_in_ruleModel131);
                    lv_definitions_0_0=ruleDefinition();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getModelRule());
                    	        }
                           		add(
                           			current, 
                           			"definitions",
                            		lv_definitions_0_0, 
                            		"Definition");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:99:2: ( (lv_definitions_1_0= ruleDefinition ) )*
                    loop1:
                    do {
                        int alt1=2;
                        int LA1_0 = input.LA(1);

                        if ( (LA1_0==RULE_ID||LA1_0==13||(LA1_0>=15 && LA1_0<=17)||LA1_0==21) ) {
                            alt1=1;
                        }


                        switch (alt1) {
                    	case 1 :
                    	    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:100:1: (lv_definitions_1_0= ruleDefinition )
                    	    {
                    	    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:100:1: (lv_definitions_1_0= ruleDefinition )
                    	    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:101:3: lv_definitions_1_0= ruleDefinition
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getModelAccess().getDefinitionsDefinitionParserRuleCall_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleDefinition_in_ruleModel152);
                    	    lv_definitions_1_0=ruleDefinition();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getModelRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"definitions",
                    	            		lv_definitions_1_0, 
                    	            		"Definition");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop1;
                        }
                    } while (true);


                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleVALUE"
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:125:1: entryRuleVALUE returns [String current=null] : iv_ruleVALUE= ruleVALUE EOF ;
    public final String entryRuleVALUE() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleVALUE = null;


        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:126:2: (iv_ruleVALUE= ruleVALUE EOF )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:127:2: iv_ruleVALUE= ruleVALUE EOF
            {
             newCompositeNode(grammarAccess.getVALUERule()); 
            pushFollow(FOLLOW_ruleVALUE_in_entryRuleVALUE191);
            iv_ruleVALUE=ruleVALUE();

            state._fsp--;

             current =iv_ruleVALUE.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVALUE202); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleVALUE"


    // $ANTLR start "ruleVALUE"
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:134:1: ruleVALUE returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_NUMBER_0= RULE_NUMBER | this_CHAR_1= RULE_CHAR | this_STRING_2= RULE_STRING ) ;
    public final AntlrDatatypeRuleToken ruleVALUE() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_NUMBER_0=null;
        Token this_CHAR_1=null;
        Token this_STRING_2=null;

         enterRule(); 
            
        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:137:28: ( (this_NUMBER_0= RULE_NUMBER | this_CHAR_1= RULE_CHAR | this_STRING_2= RULE_STRING ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:138:1: (this_NUMBER_0= RULE_NUMBER | this_CHAR_1= RULE_CHAR | this_STRING_2= RULE_STRING )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:138:1: (this_NUMBER_0= RULE_NUMBER | this_CHAR_1= RULE_CHAR | this_STRING_2= RULE_STRING )
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
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:138:6: this_NUMBER_0= RULE_NUMBER
                    {
                    this_NUMBER_0=(Token)match(input,RULE_NUMBER,FOLLOW_RULE_NUMBER_in_ruleVALUE242); 

                    		current.merge(this_NUMBER_0);
                        
                     
                        newLeafNode(this_NUMBER_0, grammarAccess.getVALUEAccess().getNUMBERTerminalRuleCall_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:146:10: this_CHAR_1= RULE_CHAR
                    {
                    this_CHAR_1=(Token)match(input,RULE_CHAR,FOLLOW_RULE_CHAR_in_ruleVALUE268); 

                    		current.merge(this_CHAR_1);
                        
                     
                        newLeafNode(this_CHAR_1, grammarAccess.getVALUEAccess().getCHARTerminalRuleCall_1()); 
                        

                    }
                    break;
                case 3 :
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:154:10: this_STRING_2= RULE_STRING
                    {
                    this_STRING_2=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleVALUE294); 

                    		current.merge(this_STRING_2);
                        
                     
                        newLeafNode(this_STRING_2, grammarAccess.getVALUEAccess().getSTRINGTerminalRuleCall_2()); 
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVALUE"


    // $ANTLR start "entryRuleDefinition"
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:169:1: entryRuleDefinition returns [EObject current=null] : iv_ruleDefinition= ruleDefinition EOF ;
    public final EObject entryRuleDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDefinition = null;


        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:170:2: (iv_ruleDefinition= ruleDefinition EOF )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:171:2: iv_ruleDefinition= ruleDefinition EOF
            {
             newCompositeNode(grammarAccess.getDefinitionRule()); 
            pushFollow(FOLLOW_ruleDefinition_in_entryRuleDefinition339);
            iv_ruleDefinition=ruleDefinition();

            state._fsp--;

             current =iv_ruleDefinition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDefinition349); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDefinition"


    // $ANTLR start "ruleDefinition"
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:178:1: ruleDefinition returns [EObject current=null] : (this_InstanceSpecification_0= ruleInstanceSpecification | this_Specification_1= ruleSpecification | this_TGraph_2= ruleTGraph | this_ExtSubTGraph_3= ruleExtSubTGraph | this_MakeEmf_4= ruleMakeEmf | this_MakeEcore_5= ruleMakeEcore | this_MakeImage_6= ruleMakeImage | this_SimpleEvoSpan_7= ruleSimpleEvoSpan | this_SimpleEvoCospan_8= ruleSimpleEvoCospan | this_Morphism_9= ruleMorphism | this_EvoSpan_10= ruleEvoSpan | this_EvoCospan_11= ruleEvoCospan ) ;
    public final EObject ruleDefinition() throws RecognitionException {
        EObject current = null;

        EObject this_InstanceSpecification_0 = null;

        EObject this_Specification_1 = null;

        EObject this_TGraph_2 = null;

        EObject this_ExtSubTGraph_3 = null;

        EObject this_MakeEmf_4 = null;

        EObject this_MakeEcore_5 = null;

        EObject this_MakeImage_6 = null;

        EObject this_SimpleEvoSpan_7 = null;

        EObject this_SimpleEvoCospan_8 = null;

        EObject this_Morphism_9 = null;

        EObject this_EvoSpan_10 = null;

        EObject this_EvoCospan_11 = null;


         enterRule(); 
            
        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:181:28: ( (this_InstanceSpecification_0= ruleInstanceSpecification | this_Specification_1= ruleSpecification | this_TGraph_2= ruleTGraph | this_ExtSubTGraph_3= ruleExtSubTGraph | this_MakeEmf_4= ruleMakeEmf | this_MakeEcore_5= ruleMakeEcore | this_MakeImage_6= ruleMakeImage | this_SimpleEvoSpan_7= ruleSimpleEvoSpan | this_SimpleEvoCospan_8= ruleSimpleEvoCospan | this_Morphism_9= ruleMorphism | this_EvoSpan_10= ruleEvoSpan | this_EvoCospan_11= ruleEvoCospan ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:182:1: (this_InstanceSpecification_0= ruleInstanceSpecification | this_Specification_1= ruleSpecification | this_TGraph_2= ruleTGraph | this_ExtSubTGraph_3= ruleExtSubTGraph | this_MakeEmf_4= ruleMakeEmf | this_MakeEcore_5= ruleMakeEcore | this_MakeImage_6= ruleMakeImage | this_SimpleEvoSpan_7= ruleSimpleEvoSpan | this_SimpleEvoCospan_8= ruleSimpleEvoCospan | this_Morphism_9= ruleMorphism | this_EvoSpan_10= ruleEvoSpan | this_EvoCospan_11= ruleEvoCospan )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:182:1: (this_InstanceSpecification_0= ruleInstanceSpecification | this_Specification_1= ruleSpecification | this_TGraph_2= ruleTGraph | this_ExtSubTGraph_3= ruleExtSubTGraph | this_MakeEmf_4= ruleMakeEmf | this_MakeEcore_5= ruleMakeEcore | this_MakeImage_6= ruleMakeImage | this_SimpleEvoSpan_7= ruleSimpleEvoSpan | this_SimpleEvoCospan_8= ruleSimpleEvoCospan | this_Morphism_9= ruleMorphism | this_EvoSpan_10= ruleEvoSpan | this_EvoCospan_11= ruleEvoCospan )
            int alt4=12;
            alt4 = dfa4.predict(input);
            switch (alt4) {
                case 1 :
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:183:5: this_InstanceSpecification_0= ruleInstanceSpecification
                    {
                     
                            newCompositeNode(grammarAccess.getDefinitionAccess().getInstanceSpecificationParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleInstanceSpecification_in_ruleDefinition396);
                    this_InstanceSpecification_0=ruleInstanceSpecification();

                    state._fsp--;

                     
                            current = this_InstanceSpecification_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:193:5: this_Specification_1= ruleSpecification
                    {
                     
                            newCompositeNode(grammarAccess.getDefinitionAccess().getSpecificationParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleSpecification_in_ruleDefinition423);
                    this_Specification_1=ruleSpecification();

                    state._fsp--;

                     
                            current = this_Specification_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:203:5: this_TGraph_2= ruleTGraph
                    {
                     
                            newCompositeNode(grammarAccess.getDefinitionAccess().getTGraphParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleTGraph_in_ruleDefinition450);
                    this_TGraph_2=ruleTGraph();

                    state._fsp--;

                     
                            current = this_TGraph_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:213:5: this_ExtSubTGraph_3= ruleExtSubTGraph
                    {
                     
                            newCompositeNode(grammarAccess.getDefinitionAccess().getExtSubTGraphParserRuleCall_3()); 
                        
                    pushFollow(FOLLOW_ruleExtSubTGraph_in_ruleDefinition477);
                    this_ExtSubTGraph_3=ruleExtSubTGraph();

                    state._fsp--;

                     
                            current = this_ExtSubTGraph_3; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 5 :
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:223:5: this_MakeEmf_4= ruleMakeEmf
                    {
                     
                            newCompositeNode(grammarAccess.getDefinitionAccess().getMakeEmfParserRuleCall_4()); 
                        
                    pushFollow(FOLLOW_ruleMakeEmf_in_ruleDefinition504);
                    this_MakeEmf_4=ruleMakeEmf();

                    state._fsp--;

                     
                            current = this_MakeEmf_4; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 6 :
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:233:5: this_MakeEcore_5= ruleMakeEcore
                    {
                     
                            newCompositeNode(grammarAccess.getDefinitionAccess().getMakeEcoreParserRuleCall_5()); 
                        
                    pushFollow(FOLLOW_ruleMakeEcore_in_ruleDefinition531);
                    this_MakeEcore_5=ruleMakeEcore();

                    state._fsp--;

                     
                            current = this_MakeEcore_5; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 7 :
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:243:5: this_MakeImage_6= ruleMakeImage
                    {
                     
                            newCompositeNode(grammarAccess.getDefinitionAccess().getMakeImageParserRuleCall_6()); 
                        
                    pushFollow(FOLLOW_ruleMakeImage_in_ruleDefinition558);
                    this_MakeImage_6=ruleMakeImage();

                    state._fsp--;

                     
                            current = this_MakeImage_6; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 8 :
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:253:5: this_SimpleEvoSpan_7= ruleSimpleEvoSpan
                    {
                     
                            newCompositeNode(grammarAccess.getDefinitionAccess().getSimpleEvoSpanParserRuleCall_7()); 
                        
                    pushFollow(FOLLOW_ruleSimpleEvoSpan_in_ruleDefinition585);
                    this_SimpleEvoSpan_7=ruleSimpleEvoSpan();

                    state._fsp--;

                     
                            current = this_SimpleEvoSpan_7; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 9 :
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:263:5: this_SimpleEvoCospan_8= ruleSimpleEvoCospan
                    {
                     
                            newCompositeNode(grammarAccess.getDefinitionAccess().getSimpleEvoCospanParserRuleCall_8()); 
                        
                    pushFollow(FOLLOW_ruleSimpleEvoCospan_in_ruleDefinition612);
                    this_SimpleEvoCospan_8=ruleSimpleEvoCospan();

                    state._fsp--;

                     
                            current = this_SimpleEvoCospan_8; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 10 :
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:273:5: this_Morphism_9= ruleMorphism
                    {
                     
                            newCompositeNode(grammarAccess.getDefinitionAccess().getMorphismParserRuleCall_9()); 
                        
                    pushFollow(FOLLOW_ruleMorphism_in_ruleDefinition639);
                    this_Morphism_9=ruleMorphism();

                    state._fsp--;

                     
                            current = this_Morphism_9; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 11 :
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:283:5: this_EvoSpan_10= ruleEvoSpan
                    {
                     
                            newCompositeNode(grammarAccess.getDefinitionAccess().getEvoSpanParserRuleCall_10()); 
                        
                    pushFollow(FOLLOW_ruleEvoSpan_in_ruleDefinition666);
                    this_EvoSpan_10=ruleEvoSpan();

                    state._fsp--;

                     
                            current = this_EvoSpan_10; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 12 :
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:293:5: this_EvoCospan_11= ruleEvoCospan
                    {
                     
                            newCompositeNode(grammarAccess.getDefinitionAccess().getEvoCospanParserRuleCall_11()); 
                        
                    pushFollow(FOLLOW_ruleEvoCospan_in_ruleDefinition693);
                    this_EvoCospan_11=ruleEvoCospan();

                    state._fsp--;

                     
                            current = this_EvoCospan_11; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDefinition"


    // $ANTLR start "entryRuleMakeEmf"
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:309:1: entryRuleMakeEmf returns [EObject current=null] : iv_ruleMakeEmf= ruleMakeEmf EOF ;
    public final EObject entryRuleMakeEmf() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMakeEmf = null;


        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:310:2: (iv_ruleMakeEmf= ruleMakeEmf EOF )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:311:2: iv_ruleMakeEmf= ruleMakeEmf EOF
            {
             newCompositeNode(grammarAccess.getMakeEmfRule()); 
            pushFollow(FOLLOW_ruleMakeEmf_in_entryRuleMakeEmf728);
            iv_ruleMakeEmf=ruleMakeEmf();

            state._fsp--;

             current =iv_ruleMakeEmf; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMakeEmf738); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMakeEmf"


    // $ANTLR start "ruleMakeEmf"
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:318:1: ruleMakeEmf returns [EObject current=null] : (otherlv_0= 'emf(' ( (lv_id_1_0= RULE_ID ) ) otherlv_2= ')' ) ;
    public final EObject ruleMakeEmf() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_id_1_0=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:321:28: ( (otherlv_0= 'emf(' ( (lv_id_1_0= RULE_ID ) ) otherlv_2= ')' ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:322:1: (otherlv_0= 'emf(' ( (lv_id_1_0= RULE_ID ) ) otherlv_2= ')' )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:322:1: (otherlv_0= 'emf(' ( (lv_id_1_0= RULE_ID ) ) otherlv_2= ')' )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:322:3: otherlv_0= 'emf(' ( (lv_id_1_0= RULE_ID ) ) otherlv_2= ')'
            {
            otherlv_0=(Token)match(input,13,FOLLOW_13_in_ruleMakeEmf775); 

                	newLeafNode(otherlv_0, grammarAccess.getMakeEmfAccess().getEmfKeyword_0());
                
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:326:1: ( (lv_id_1_0= RULE_ID ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:327:1: (lv_id_1_0= RULE_ID )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:327:1: (lv_id_1_0= RULE_ID )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:328:3: lv_id_1_0= RULE_ID
            {
            lv_id_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleMakeEmf792); 

            			newLeafNode(lv_id_1_0, grammarAccess.getMakeEmfAccess().getIdIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getMakeEmfRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"id",
                    		lv_id_1_0, 
                    		"ID");
            	    

            }


            }

            otherlv_2=(Token)match(input,14,FOLLOW_14_in_ruleMakeEmf809); 

                	newLeafNode(otherlv_2, grammarAccess.getMakeEmfAccess().getRightParenthesisKeyword_2());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMakeEmf"


    // $ANTLR start "entryRuleMakeEcore"
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:356:1: entryRuleMakeEcore returns [EObject current=null] : iv_ruleMakeEcore= ruleMakeEcore EOF ;
    public final EObject entryRuleMakeEcore() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMakeEcore = null;


        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:357:2: (iv_ruleMakeEcore= ruleMakeEcore EOF )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:358:2: iv_ruleMakeEcore= ruleMakeEcore EOF
            {
             newCompositeNode(grammarAccess.getMakeEcoreRule()); 
            pushFollow(FOLLOW_ruleMakeEcore_in_entryRuleMakeEcore845);
            iv_ruleMakeEcore=ruleMakeEcore();

            state._fsp--;

             current =iv_ruleMakeEcore; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMakeEcore855); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMakeEcore"


    // $ANTLR start "ruleMakeEcore"
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:365:1: ruleMakeEcore returns [EObject current=null] : (otherlv_0= 'ecore(' ( (lv_id_1_0= RULE_ID ) ) otherlv_2= ')' ) ;
    public final EObject ruleMakeEcore() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_id_1_0=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:368:28: ( (otherlv_0= 'ecore(' ( (lv_id_1_0= RULE_ID ) ) otherlv_2= ')' ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:369:1: (otherlv_0= 'ecore(' ( (lv_id_1_0= RULE_ID ) ) otherlv_2= ')' )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:369:1: (otherlv_0= 'ecore(' ( (lv_id_1_0= RULE_ID ) ) otherlv_2= ')' )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:369:3: otherlv_0= 'ecore(' ( (lv_id_1_0= RULE_ID ) ) otherlv_2= ')'
            {
            otherlv_0=(Token)match(input,15,FOLLOW_15_in_ruleMakeEcore892); 

                	newLeafNode(otherlv_0, grammarAccess.getMakeEcoreAccess().getEcoreKeyword_0());
                
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:373:1: ( (lv_id_1_0= RULE_ID ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:374:1: (lv_id_1_0= RULE_ID )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:374:1: (lv_id_1_0= RULE_ID )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:375:3: lv_id_1_0= RULE_ID
            {
            lv_id_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleMakeEcore909); 

            			newLeafNode(lv_id_1_0, grammarAccess.getMakeEcoreAccess().getIdIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getMakeEcoreRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"id",
                    		lv_id_1_0, 
                    		"ID");
            	    

            }


            }

            otherlv_2=(Token)match(input,14,FOLLOW_14_in_ruleMakeEcore926); 

                	newLeafNode(otherlv_2, grammarAccess.getMakeEcoreAccess().getRightParenthesisKeyword_2());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMakeEcore"


    // $ANTLR start "entryRuleMakeImage"
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:403:1: entryRuleMakeImage returns [EObject current=null] : iv_ruleMakeImage= ruleMakeImage EOF ;
    public final EObject entryRuleMakeImage() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMakeImage = null;


        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:404:2: (iv_ruleMakeImage= ruleMakeImage EOF )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:405:2: iv_ruleMakeImage= ruleMakeImage EOF
            {
             newCompositeNode(grammarAccess.getMakeImageRule()); 
            pushFollow(FOLLOW_ruleMakeImage_in_entryRuleMakeImage962);
            iv_ruleMakeImage=ruleMakeImage();

            state._fsp--;

             current =iv_ruleMakeImage; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMakeImage972); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMakeImage"


    // $ANTLR start "ruleMakeImage"
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:412:1: ruleMakeImage returns [EObject current=null] : (otherlv_0= 'image(' ( (lv_id_1_0= RULE_ID ) ) otherlv_2= ')' ) ;
    public final EObject ruleMakeImage() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_id_1_0=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:415:28: ( (otherlv_0= 'image(' ( (lv_id_1_0= RULE_ID ) ) otherlv_2= ')' ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:416:1: (otherlv_0= 'image(' ( (lv_id_1_0= RULE_ID ) ) otherlv_2= ')' )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:416:1: (otherlv_0= 'image(' ( (lv_id_1_0= RULE_ID ) ) otherlv_2= ')' )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:416:3: otherlv_0= 'image(' ( (lv_id_1_0= RULE_ID ) ) otherlv_2= ')'
            {
            otherlv_0=(Token)match(input,16,FOLLOW_16_in_ruleMakeImage1009); 

                	newLeafNode(otherlv_0, grammarAccess.getMakeImageAccess().getImageKeyword_0());
                
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:420:1: ( (lv_id_1_0= RULE_ID ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:421:1: (lv_id_1_0= RULE_ID )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:421:1: (lv_id_1_0= RULE_ID )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:422:3: lv_id_1_0= RULE_ID
            {
            lv_id_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleMakeImage1026); 

            			newLeafNode(lv_id_1_0, grammarAccess.getMakeImageAccess().getIdIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getMakeImageRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"id",
                    		lv_id_1_0, 
                    		"ID");
            	    

            }


            }

            otherlv_2=(Token)match(input,14,FOLLOW_14_in_ruleMakeImage1043); 

                	newLeafNode(otherlv_2, grammarAccess.getMakeImageAccess().getRightParenthesisKeyword_2());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMakeImage"


    // $ANTLR start "entryRuleSimpleEvoSpan"
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:450:1: entryRuleSimpleEvoSpan returns [EObject current=null] : iv_ruleSimpleEvoSpan= ruleSimpleEvoSpan EOF ;
    public final EObject entryRuleSimpleEvoSpan() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSimpleEvoSpan = null;


        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:451:2: (iv_ruleSimpleEvoSpan= ruleSimpleEvoSpan EOF )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:452:2: iv_ruleSimpleEvoSpan= ruleSimpleEvoSpan EOF
            {
             newCompositeNode(grammarAccess.getSimpleEvoSpanRule()); 
            pushFollow(FOLLOW_ruleSimpleEvoSpan_in_entryRuleSimpleEvoSpan1079);
            iv_ruleSimpleEvoSpan=ruleSimpleEvoSpan();

            state._fsp--;

             current =iv_ruleSimpleEvoSpan; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSimpleEvoSpan1089); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSimpleEvoSpan"


    // $ANTLR start "ruleSimpleEvoSpan"
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:459:1: ruleSimpleEvoSpan returns [EObject current=null] : (otherlv_0= 'simpleEvolution(' ( (lv_lhs_1_0= RULE_ID ) ) otherlv_2= '<-' ( (lv_diff_3_0= RULE_ID ) ) otherlv_4= '->' ( (lv_rhS_5_0= RULE_ID ) ) otherlv_6= ',' ( (lv_typeGraph_7_0= RULE_ID ) ) otherlv_8= ')' ) ;
    public final EObject ruleSimpleEvoSpan() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_lhs_1_0=null;
        Token otherlv_2=null;
        Token lv_diff_3_0=null;
        Token otherlv_4=null;
        Token lv_rhS_5_0=null;
        Token otherlv_6=null;
        Token lv_typeGraph_7_0=null;
        Token otherlv_8=null;

         enterRule(); 
            
        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:462:28: ( (otherlv_0= 'simpleEvolution(' ( (lv_lhs_1_0= RULE_ID ) ) otherlv_2= '<-' ( (lv_diff_3_0= RULE_ID ) ) otherlv_4= '->' ( (lv_rhS_5_0= RULE_ID ) ) otherlv_6= ',' ( (lv_typeGraph_7_0= RULE_ID ) ) otherlv_8= ')' ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:463:1: (otherlv_0= 'simpleEvolution(' ( (lv_lhs_1_0= RULE_ID ) ) otherlv_2= '<-' ( (lv_diff_3_0= RULE_ID ) ) otherlv_4= '->' ( (lv_rhS_5_0= RULE_ID ) ) otherlv_6= ',' ( (lv_typeGraph_7_0= RULE_ID ) ) otherlv_8= ')' )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:463:1: (otherlv_0= 'simpleEvolution(' ( (lv_lhs_1_0= RULE_ID ) ) otherlv_2= '<-' ( (lv_diff_3_0= RULE_ID ) ) otherlv_4= '->' ( (lv_rhS_5_0= RULE_ID ) ) otherlv_6= ',' ( (lv_typeGraph_7_0= RULE_ID ) ) otherlv_8= ')' )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:463:3: otherlv_0= 'simpleEvolution(' ( (lv_lhs_1_0= RULE_ID ) ) otherlv_2= '<-' ( (lv_diff_3_0= RULE_ID ) ) otherlv_4= '->' ( (lv_rhS_5_0= RULE_ID ) ) otherlv_6= ',' ( (lv_typeGraph_7_0= RULE_ID ) ) otherlv_8= ')'
            {
            otherlv_0=(Token)match(input,17,FOLLOW_17_in_ruleSimpleEvoSpan1126); 

                	newLeafNode(otherlv_0, grammarAccess.getSimpleEvoSpanAccess().getSimpleEvolutionKeyword_0());
                
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:467:1: ( (lv_lhs_1_0= RULE_ID ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:468:1: (lv_lhs_1_0= RULE_ID )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:468:1: (lv_lhs_1_0= RULE_ID )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:469:3: lv_lhs_1_0= RULE_ID
            {
            lv_lhs_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSimpleEvoSpan1143); 

            			newLeafNode(lv_lhs_1_0, grammarAccess.getSimpleEvoSpanAccess().getLhsIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getSimpleEvoSpanRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"lhs",
                    		lv_lhs_1_0, 
                    		"ID");
            	    

            }


            }

            otherlv_2=(Token)match(input,18,FOLLOW_18_in_ruleSimpleEvoSpan1160); 

                	newLeafNode(otherlv_2, grammarAccess.getSimpleEvoSpanAccess().getLessThanSignHyphenMinusKeyword_2());
                
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:489:1: ( (lv_diff_3_0= RULE_ID ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:490:1: (lv_diff_3_0= RULE_ID )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:490:1: (lv_diff_3_0= RULE_ID )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:491:3: lv_diff_3_0= RULE_ID
            {
            lv_diff_3_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSimpleEvoSpan1177); 

            			newLeafNode(lv_diff_3_0, grammarAccess.getSimpleEvoSpanAccess().getDiffIDTerminalRuleCall_3_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getSimpleEvoSpanRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"diff",
                    		lv_diff_3_0, 
                    		"ID");
            	    

            }


            }

            otherlv_4=(Token)match(input,19,FOLLOW_19_in_ruleSimpleEvoSpan1194); 

                	newLeafNode(otherlv_4, grammarAccess.getSimpleEvoSpanAccess().getHyphenMinusGreaterThanSignKeyword_4());
                
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:511:1: ( (lv_rhS_5_0= RULE_ID ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:512:1: (lv_rhS_5_0= RULE_ID )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:512:1: (lv_rhS_5_0= RULE_ID )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:513:3: lv_rhS_5_0= RULE_ID
            {
            lv_rhS_5_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSimpleEvoSpan1211); 

            			newLeafNode(lv_rhS_5_0, grammarAccess.getSimpleEvoSpanAccess().getRhSIDTerminalRuleCall_5_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getSimpleEvoSpanRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"rhS",
                    		lv_rhS_5_0, 
                    		"ID");
            	    

            }


            }

            otherlv_6=(Token)match(input,20,FOLLOW_20_in_ruleSimpleEvoSpan1228); 

                	newLeafNode(otherlv_6, grammarAccess.getSimpleEvoSpanAccess().getCommaKeyword_6());
                
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:533:1: ( (lv_typeGraph_7_0= RULE_ID ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:534:1: (lv_typeGraph_7_0= RULE_ID )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:534:1: (lv_typeGraph_7_0= RULE_ID )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:535:3: lv_typeGraph_7_0= RULE_ID
            {
            lv_typeGraph_7_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSimpleEvoSpan1245); 

            			newLeafNode(lv_typeGraph_7_0, grammarAccess.getSimpleEvoSpanAccess().getTypeGraphIDTerminalRuleCall_7_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getSimpleEvoSpanRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"typeGraph",
                    		lv_typeGraph_7_0, 
                    		"ID");
            	    

            }


            }

            otherlv_8=(Token)match(input,14,FOLLOW_14_in_ruleSimpleEvoSpan1262); 

                	newLeafNode(otherlv_8, grammarAccess.getSimpleEvoSpanAccess().getRightParenthesisKeyword_8());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSimpleEvoSpan"


    // $ANTLR start "entryRuleSimpleEvoCospan"
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:563:1: entryRuleSimpleEvoCospan returns [EObject current=null] : iv_ruleSimpleEvoCospan= ruleSimpleEvoCospan EOF ;
    public final EObject entryRuleSimpleEvoCospan() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSimpleEvoCospan = null;


        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:564:2: (iv_ruleSimpleEvoCospan= ruleSimpleEvoCospan EOF )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:565:2: iv_ruleSimpleEvoCospan= ruleSimpleEvoCospan EOF
            {
             newCompositeNode(grammarAccess.getSimpleEvoCospanRule()); 
            pushFollow(FOLLOW_ruleSimpleEvoCospan_in_entryRuleSimpleEvoCospan1298);
            iv_ruleSimpleEvoCospan=ruleSimpleEvoCospan();

            state._fsp--;

             current =iv_ruleSimpleEvoCospan; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSimpleEvoCospan1308); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSimpleEvoCospan"


    // $ANTLR start "ruleSimpleEvoCospan"
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:572:1: ruleSimpleEvoCospan returns [EObject current=null] : (otherlv_0= 'simpleEvolution(' ( (lv_lhs_1_0= RULE_ID ) ) otherlv_2= '->' ( (lv_joint_3_0= RULE_ID ) ) otherlv_4= '<-' ( (lv_rhs_5_0= RULE_ID ) ) otherlv_6= ',' ( (lv_typeGraph_7_0= RULE_ID ) ) otherlv_8= ')' ) ;
    public final EObject ruleSimpleEvoCospan() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_lhs_1_0=null;
        Token otherlv_2=null;
        Token lv_joint_3_0=null;
        Token otherlv_4=null;
        Token lv_rhs_5_0=null;
        Token otherlv_6=null;
        Token lv_typeGraph_7_0=null;
        Token otherlv_8=null;

         enterRule(); 
            
        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:575:28: ( (otherlv_0= 'simpleEvolution(' ( (lv_lhs_1_0= RULE_ID ) ) otherlv_2= '->' ( (lv_joint_3_0= RULE_ID ) ) otherlv_4= '<-' ( (lv_rhs_5_0= RULE_ID ) ) otherlv_6= ',' ( (lv_typeGraph_7_0= RULE_ID ) ) otherlv_8= ')' ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:576:1: (otherlv_0= 'simpleEvolution(' ( (lv_lhs_1_0= RULE_ID ) ) otherlv_2= '->' ( (lv_joint_3_0= RULE_ID ) ) otherlv_4= '<-' ( (lv_rhs_5_0= RULE_ID ) ) otherlv_6= ',' ( (lv_typeGraph_7_0= RULE_ID ) ) otherlv_8= ')' )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:576:1: (otherlv_0= 'simpleEvolution(' ( (lv_lhs_1_0= RULE_ID ) ) otherlv_2= '->' ( (lv_joint_3_0= RULE_ID ) ) otherlv_4= '<-' ( (lv_rhs_5_0= RULE_ID ) ) otherlv_6= ',' ( (lv_typeGraph_7_0= RULE_ID ) ) otherlv_8= ')' )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:576:3: otherlv_0= 'simpleEvolution(' ( (lv_lhs_1_0= RULE_ID ) ) otherlv_2= '->' ( (lv_joint_3_0= RULE_ID ) ) otherlv_4= '<-' ( (lv_rhs_5_0= RULE_ID ) ) otherlv_6= ',' ( (lv_typeGraph_7_0= RULE_ID ) ) otherlv_8= ')'
            {
            otherlv_0=(Token)match(input,17,FOLLOW_17_in_ruleSimpleEvoCospan1345); 

                	newLeafNode(otherlv_0, grammarAccess.getSimpleEvoCospanAccess().getSimpleEvolutionKeyword_0());
                
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:580:1: ( (lv_lhs_1_0= RULE_ID ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:581:1: (lv_lhs_1_0= RULE_ID )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:581:1: (lv_lhs_1_0= RULE_ID )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:582:3: lv_lhs_1_0= RULE_ID
            {
            lv_lhs_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSimpleEvoCospan1362); 

            			newLeafNode(lv_lhs_1_0, grammarAccess.getSimpleEvoCospanAccess().getLhsIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getSimpleEvoCospanRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"lhs",
                    		lv_lhs_1_0, 
                    		"ID");
            	    

            }


            }

            otherlv_2=(Token)match(input,19,FOLLOW_19_in_ruleSimpleEvoCospan1379); 

                	newLeafNode(otherlv_2, grammarAccess.getSimpleEvoCospanAccess().getHyphenMinusGreaterThanSignKeyword_2());
                
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:602:1: ( (lv_joint_3_0= RULE_ID ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:603:1: (lv_joint_3_0= RULE_ID )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:603:1: (lv_joint_3_0= RULE_ID )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:604:3: lv_joint_3_0= RULE_ID
            {
            lv_joint_3_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSimpleEvoCospan1396); 

            			newLeafNode(lv_joint_3_0, grammarAccess.getSimpleEvoCospanAccess().getJointIDTerminalRuleCall_3_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getSimpleEvoCospanRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"joint",
                    		lv_joint_3_0, 
                    		"ID");
            	    

            }


            }

            otherlv_4=(Token)match(input,18,FOLLOW_18_in_ruleSimpleEvoCospan1413); 

                	newLeafNode(otherlv_4, grammarAccess.getSimpleEvoCospanAccess().getLessThanSignHyphenMinusKeyword_4());
                
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:624:1: ( (lv_rhs_5_0= RULE_ID ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:625:1: (lv_rhs_5_0= RULE_ID )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:625:1: (lv_rhs_5_0= RULE_ID )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:626:3: lv_rhs_5_0= RULE_ID
            {
            lv_rhs_5_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSimpleEvoCospan1430); 

            			newLeafNode(lv_rhs_5_0, grammarAccess.getSimpleEvoCospanAccess().getRhsIDTerminalRuleCall_5_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getSimpleEvoCospanRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"rhs",
                    		lv_rhs_5_0, 
                    		"ID");
            	    

            }


            }

            otherlv_6=(Token)match(input,20,FOLLOW_20_in_ruleSimpleEvoCospan1447); 

                	newLeafNode(otherlv_6, grammarAccess.getSimpleEvoCospanAccess().getCommaKeyword_6());
                
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:646:1: ( (lv_typeGraph_7_0= RULE_ID ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:647:1: (lv_typeGraph_7_0= RULE_ID )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:647:1: (lv_typeGraph_7_0= RULE_ID )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:648:3: lv_typeGraph_7_0= RULE_ID
            {
            lv_typeGraph_7_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSimpleEvoCospan1464); 

            			newLeafNode(lv_typeGraph_7_0, grammarAccess.getSimpleEvoCospanAccess().getTypeGraphIDTerminalRuleCall_7_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getSimpleEvoCospanRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"typeGraph",
                    		lv_typeGraph_7_0, 
                    		"ID");
            	    

            }


            }

            otherlv_8=(Token)match(input,14,FOLLOW_14_in_ruleSimpleEvoCospan1481); 

                	newLeafNode(otherlv_8, grammarAccess.getSimpleEvoCospanAccess().getRightParenthesisKeyword_8());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSimpleEvoCospan"


    // $ANTLR start "entryRuleEvoSpan"
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:676:1: entryRuleEvoSpan returns [EObject current=null] : iv_ruleEvoSpan= ruleEvoSpan EOF ;
    public final EObject entryRuleEvoSpan() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEvoSpan = null;


        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:677:2: (iv_ruleEvoSpan= ruleEvoSpan EOF )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:678:2: iv_ruleEvoSpan= ruleEvoSpan EOF
            {
             newCompositeNode(grammarAccess.getEvoSpanRule()); 
            pushFollow(FOLLOW_ruleEvoSpan_in_entryRuleEvoSpan1517);
            iv_ruleEvoSpan=ruleEvoSpan();

            state._fsp--;

             current =iv_ruleEvoSpan; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEvoSpan1527); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEvoSpan"


    // $ANTLR start "ruleEvoSpan"
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:685:1: ruleEvoSpan returns [EObject current=null] : (otherlv_0= 'evolution(' ( (lv_lhs_1_0= RULE_ID ) ) otherlv_2= '<->' ( (lv_rhs_3_0= RULE_ID ) ) otherlv_4= ',' ( (lv_typeGraph_5_0= RULE_ID ) ) otherlv_6= ')' ) ;
    public final EObject ruleEvoSpan() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_lhs_1_0=null;
        Token otherlv_2=null;
        Token lv_rhs_3_0=null;
        Token otherlv_4=null;
        Token lv_typeGraph_5_0=null;
        Token otherlv_6=null;

         enterRule(); 
            
        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:688:28: ( (otherlv_0= 'evolution(' ( (lv_lhs_1_0= RULE_ID ) ) otherlv_2= '<->' ( (lv_rhs_3_0= RULE_ID ) ) otherlv_4= ',' ( (lv_typeGraph_5_0= RULE_ID ) ) otherlv_6= ')' ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:689:1: (otherlv_0= 'evolution(' ( (lv_lhs_1_0= RULE_ID ) ) otherlv_2= '<->' ( (lv_rhs_3_0= RULE_ID ) ) otherlv_4= ',' ( (lv_typeGraph_5_0= RULE_ID ) ) otherlv_6= ')' )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:689:1: (otherlv_0= 'evolution(' ( (lv_lhs_1_0= RULE_ID ) ) otherlv_2= '<->' ( (lv_rhs_3_0= RULE_ID ) ) otherlv_4= ',' ( (lv_typeGraph_5_0= RULE_ID ) ) otherlv_6= ')' )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:689:3: otherlv_0= 'evolution(' ( (lv_lhs_1_0= RULE_ID ) ) otherlv_2= '<->' ( (lv_rhs_3_0= RULE_ID ) ) otherlv_4= ',' ( (lv_typeGraph_5_0= RULE_ID ) ) otherlv_6= ')'
            {
            otherlv_0=(Token)match(input,21,FOLLOW_21_in_ruleEvoSpan1564); 

                	newLeafNode(otherlv_0, grammarAccess.getEvoSpanAccess().getEvolutionKeyword_0());
                
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:693:1: ( (lv_lhs_1_0= RULE_ID ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:694:1: (lv_lhs_1_0= RULE_ID )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:694:1: (lv_lhs_1_0= RULE_ID )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:695:3: lv_lhs_1_0= RULE_ID
            {
            lv_lhs_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEvoSpan1581); 

            			newLeafNode(lv_lhs_1_0, grammarAccess.getEvoSpanAccess().getLhsIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getEvoSpanRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"lhs",
                    		lv_lhs_1_0, 
                    		"ID");
            	    

            }


            }

            otherlv_2=(Token)match(input,22,FOLLOW_22_in_ruleEvoSpan1598); 

                	newLeafNode(otherlv_2, grammarAccess.getEvoSpanAccess().getLessThanSignHyphenMinusGreaterThanSignKeyword_2());
                
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:715:1: ( (lv_rhs_3_0= RULE_ID ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:716:1: (lv_rhs_3_0= RULE_ID )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:716:1: (lv_rhs_3_0= RULE_ID )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:717:3: lv_rhs_3_0= RULE_ID
            {
            lv_rhs_3_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEvoSpan1615); 

            			newLeafNode(lv_rhs_3_0, grammarAccess.getEvoSpanAccess().getRhsIDTerminalRuleCall_3_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getEvoSpanRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"rhs",
                    		lv_rhs_3_0, 
                    		"ID");
            	    

            }


            }

            otherlv_4=(Token)match(input,20,FOLLOW_20_in_ruleEvoSpan1632); 

                	newLeafNode(otherlv_4, grammarAccess.getEvoSpanAccess().getCommaKeyword_4());
                
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:737:1: ( (lv_typeGraph_5_0= RULE_ID ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:738:1: (lv_typeGraph_5_0= RULE_ID )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:738:1: (lv_typeGraph_5_0= RULE_ID )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:739:3: lv_typeGraph_5_0= RULE_ID
            {
            lv_typeGraph_5_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEvoSpan1649); 

            			newLeafNode(lv_typeGraph_5_0, grammarAccess.getEvoSpanAccess().getTypeGraphIDTerminalRuleCall_5_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getEvoSpanRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"typeGraph",
                    		lv_typeGraph_5_0, 
                    		"ID");
            	    

            }


            }

            otherlv_6=(Token)match(input,14,FOLLOW_14_in_ruleEvoSpan1666); 

                	newLeafNode(otherlv_6, grammarAccess.getEvoSpanAccess().getRightParenthesisKeyword_6());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEvoSpan"


    // $ANTLR start "entryRuleEvoCospan"
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:767:1: entryRuleEvoCospan returns [EObject current=null] : iv_ruleEvoCospan= ruleEvoCospan EOF ;
    public final EObject entryRuleEvoCospan() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEvoCospan = null;


        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:768:2: (iv_ruleEvoCospan= ruleEvoCospan EOF )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:769:2: iv_ruleEvoCospan= ruleEvoCospan EOF
            {
             newCompositeNode(grammarAccess.getEvoCospanRule()); 
            pushFollow(FOLLOW_ruleEvoCospan_in_entryRuleEvoCospan1702);
            iv_ruleEvoCospan=ruleEvoCospan();

            state._fsp--;

             current =iv_ruleEvoCospan; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEvoCospan1712); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEvoCospan"


    // $ANTLR start "ruleEvoCospan"
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:776:1: ruleEvoCospan returns [EObject current=null] : (otherlv_0= 'evolution(' ( (lv_lhs_1_0= RULE_ID ) ) otherlv_2= '-><-' ( (lv_rhs_3_0= RULE_ID ) ) otherlv_4= ',' ( (lv_typeGraph_5_0= RULE_ID ) ) otherlv_6= ')' ) ;
    public final EObject ruleEvoCospan() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_lhs_1_0=null;
        Token otherlv_2=null;
        Token lv_rhs_3_0=null;
        Token otherlv_4=null;
        Token lv_typeGraph_5_0=null;
        Token otherlv_6=null;

         enterRule(); 
            
        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:779:28: ( (otherlv_0= 'evolution(' ( (lv_lhs_1_0= RULE_ID ) ) otherlv_2= '-><-' ( (lv_rhs_3_0= RULE_ID ) ) otherlv_4= ',' ( (lv_typeGraph_5_0= RULE_ID ) ) otherlv_6= ')' ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:780:1: (otherlv_0= 'evolution(' ( (lv_lhs_1_0= RULE_ID ) ) otherlv_2= '-><-' ( (lv_rhs_3_0= RULE_ID ) ) otherlv_4= ',' ( (lv_typeGraph_5_0= RULE_ID ) ) otherlv_6= ')' )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:780:1: (otherlv_0= 'evolution(' ( (lv_lhs_1_0= RULE_ID ) ) otherlv_2= '-><-' ( (lv_rhs_3_0= RULE_ID ) ) otherlv_4= ',' ( (lv_typeGraph_5_0= RULE_ID ) ) otherlv_6= ')' )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:780:3: otherlv_0= 'evolution(' ( (lv_lhs_1_0= RULE_ID ) ) otherlv_2= '-><-' ( (lv_rhs_3_0= RULE_ID ) ) otherlv_4= ',' ( (lv_typeGraph_5_0= RULE_ID ) ) otherlv_6= ')'
            {
            otherlv_0=(Token)match(input,21,FOLLOW_21_in_ruleEvoCospan1749); 

                	newLeafNode(otherlv_0, grammarAccess.getEvoCospanAccess().getEvolutionKeyword_0());
                
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:784:1: ( (lv_lhs_1_0= RULE_ID ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:785:1: (lv_lhs_1_0= RULE_ID )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:785:1: (lv_lhs_1_0= RULE_ID )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:786:3: lv_lhs_1_0= RULE_ID
            {
            lv_lhs_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEvoCospan1766); 

            			newLeafNode(lv_lhs_1_0, grammarAccess.getEvoCospanAccess().getLhsIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getEvoCospanRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"lhs",
                    		lv_lhs_1_0, 
                    		"ID");
            	    

            }


            }

            otherlv_2=(Token)match(input,23,FOLLOW_23_in_ruleEvoCospan1783); 

                	newLeafNode(otherlv_2, grammarAccess.getEvoCospanAccess().getHyphenMinusGreaterThanSignLessThanSignHyphenMinusKeyword_2());
                
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:806:1: ( (lv_rhs_3_0= RULE_ID ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:807:1: (lv_rhs_3_0= RULE_ID )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:807:1: (lv_rhs_3_0= RULE_ID )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:808:3: lv_rhs_3_0= RULE_ID
            {
            lv_rhs_3_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEvoCospan1800); 

            			newLeafNode(lv_rhs_3_0, grammarAccess.getEvoCospanAccess().getRhsIDTerminalRuleCall_3_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getEvoCospanRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"rhs",
                    		lv_rhs_3_0, 
                    		"ID");
            	    

            }


            }

            otherlv_4=(Token)match(input,20,FOLLOW_20_in_ruleEvoCospan1817); 

                	newLeafNode(otherlv_4, grammarAccess.getEvoCospanAccess().getCommaKeyword_4());
                
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:828:1: ( (lv_typeGraph_5_0= RULE_ID ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:829:1: (lv_typeGraph_5_0= RULE_ID )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:829:1: (lv_typeGraph_5_0= RULE_ID )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:830:3: lv_typeGraph_5_0= RULE_ID
            {
            lv_typeGraph_5_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEvoCospan1834); 

            			newLeafNode(lv_typeGraph_5_0, grammarAccess.getEvoCospanAccess().getTypeGraphIDTerminalRuleCall_5_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getEvoCospanRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"typeGraph",
                    		lv_typeGraph_5_0, 
                    		"ID");
            	    

            }


            }

            otherlv_6=(Token)match(input,14,FOLLOW_14_in_ruleEvoCospan1851); 

                	newLeafNode(otherlv_6, grammarAccess.getEvoCospanAccess().getRightParenthesisKeyword_6());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEvoCospan"


    // $ANTLR start "entryRuleInstanceSpecification"
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:858:1: entryRuleInstanceSpecification returns [EObject current=null] : iv_ruleInstanceSpecification= ruleInstanceSpecification EOF ;
    public final EObject entryRuleInstanceSpecification() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInstanceSpecification = null;


        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:859:2: (iv_ruleInstanceSpecification= ruleInstanceSpecification EOF )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:860:2: iv_ruleInstanceSpecification= ruleInstanceSpecification EOF
            {
             newCompositeNode(grammarAccess.getInstanceSpecificationRule()); 
            pushFollow(FOLLOW_ruleInstanceSpecification_in_entryRuleInstanceSpecification1887);
            iv_ruleInstanceSpecification=ruleInstanceSpecification();

            state._fsp--;

             current =iv_ruleInstanceSpecification; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleInstanceSpecification1897); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleInstanceSpecification"


    // $ANTLR start "ruleInstanceSpecification"
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:867:1: ruleInstanceSpecification returns [EObject current=null] : ( ( (lv_id_0_0= RULE_ID ) ) otherlv_1= ':=' otherlv_2= 'ISpec<' ( (lv_model_3_0= ruleChoosenSpecfication ) ) otherlv_4= ',' ( (lv_metamodel_5_0= ruleChoosenSpecfication ) ) otherlv_6= '>' otherlv_7= '{' ( ( (lv_constraintSemantics_8_0= ruleConstraintSemantic ) ) (otherlv_9= ',' ( (lv_constraintSemantics_10_0= ruleConstraintSemantic ) ) )* ) otherlv_11= '}' ) ;
    public final EObject ruleInstanceSpecification() throws RecognitionException {
        EObject current = null;

        Token lv_id_0_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        EObject lv_model_3_0 = null;

        EObject lv_metamodel_5_0 = null;

        EObject lv_constraintSemantics_8_0 = null;

        EObject lv_constraintSemantics_10_0 = null;


         enterRule(); 
            
        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:870:28: ( ( ( (lv_id_0_0= RULE_ID ) ) otherlv_1= ':=' otherlv_2= 'ISpec<' ( (lv_model_3_0= ruleChoosenSpecfication ) ) otherlv_4= ',' ( (lv_metamodel_5_0= ruleChoosenSpecfication ) ) otherlv_6= '>' otherlv_7= '{' ( ( (lv_constraintSemantics_8_0= ruleConstraintSemantic ) ) (otherlv_9= ',' ( (lv_constraintSemantics_10_0= ruleConstraintSemantic ) ) )* ) otherlv_11= '}' ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:871:1: ( ( (lv_id_0_0= RULE_ID ) ) otherlv_1= ':=' otherlv_2= 'ISpec<' ( (lv_model_3_0= ruleChoosenSpecfication ) ) otherlv_4= ',' ( (lv_metamodel_5_0= ruleChoosenSpecfication ) ) otherlv_6= '>' otherlv_7= '{' ( ( (lv_constraintSemantics_8_0= ruleConstraintSemantic ) ) (otherlv_9= ',' ( (lv_constraintSemantics_10_0= ruleConstraintSemantic ) ) )* ) otherlv_11= '}' )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:871:1: ( ( (lv_id_0_0= RULE_ID ) ) otherlv_1= ':=' otherlv_2= 'ISpec<' ( (lv_model_3_0= ruleChoosenSpecfication ) ) otherlv_4= ',' ( (lv_metamodel_5_0= ruleChoosenSpecfication ) ) otherlv_6= '>' otherlv_7= '{' ( ( (lv_constraintSemantics_8_0= ruleConstraintSemantic ) ) (otherlv_9= ',' ( (lv_constraintSemantics_10_0= ruleConstraintSemantic ) ) )* ) otherlv_11= '}' )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:871:2: ( (lv_id_0_0= RULE_ID ) ) otherlv_1= ':=' otherlv_2= 'ISpec<' ( (lv_model_3_0= ruleChoosenSpecfication ) ) otherlv_4= ',' ( (lv_metamodel_5_0= ruleChoosenSpecfication ) ) otherlv_6= '>' otherlv_7= '{' ( ( (lv_constraintSemantics_8_0= ruleConstraintSemantic ) ) (otherlv_9= ',' ( (lv_constraintSemantics_10_0= ruleConstraintSemantic ) ) )* ) otherlv_11= '}'
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:871:2: ( (lv_id_0_0= RULE_ID ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:872:1: (lv_id_0_0= RULE_ID )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:872:1: (lv_id_0_0= RULE_ID )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:873:3: lv_id_0_0= RULE_ID
            {
            lv_id_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleInstanceSpecification1939); 

            			newLeafNode(lv_id_0_0, grammarAccess.getInstanceSpecificationAccess().getIdIDTerminalRuleCall_0_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getInstanceSpecificationRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"id",
                    		lv_id_0_0, 
                    		"ID");
            	    

            }


            }

            otherlv_1=(Token)match(input,24,FOLLOW_24_in_ruleInstanceSpecification1956); 

                	newLeafNode(otherlv_1, grammarAccess.getInstanceSpecificationAccess().getColonEqualsSignKeyword_1());
                
            otherlv_2=(Token)match(input,25,FOLLOW_25_in_ruleInstanceSpecification1968); 

                	newLeafNode(otherlv_2, grammarAccess.getInstanceSpecificationAccess().getISpecKeyword_2());
                
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:897:1: ( (lv_model_3_0= ruleChoosenSpecfication ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:898:1: (lv_model_3_0= ruleChoosenSpecfication )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:898:1: (lv_model_3_0= ruleChoosenSpecfication )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:899:3: lv_model_3_0= ruleChoosenSpecfication
            {
             
            	        newCompositeNode(grammarAccess.getInstanceSpecificationAccess().getModelChoosenSpecficationParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_ruleChoosenSpecfication_in_ruleInstanceSpecification1989);
            lv_model_3_0=ruleChoosenSpecfication();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getInstanceSpecificationRule());
            	        }
                   		set(
                   			current, 
                   			"model",
                    		lv_model_3_0, 
                    		"ChoosenSpecfication");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_4=(Token)match(input,20,FOLLOW_20_in_ruleInstanceSpecification2001); 

                	newLeafNode(otherlv_4, grammarAccess.getInstanceSpecificationAccess().getCommaKeyword_4());
                
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:919:1: ( (lv_metamodel_5_0= ruleChoosenSpecfication ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:920:1: (lv_metamodel_5_0= ruleChoosenSpecfication )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:920:1: (lv_metamodel_5_0= ruleChoosenSpecfication )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:921:3: lv_metamodel_5_0= ruleChoosenSpecfication
            {
             
            	        newCompositeNode(grammarAccess.getInstanceSpecificationAccess().getMetamodelChoosenSpecficationParserRuleCall_5_0()); 
            	    
            pushFollow(FOLLOW_ruleChoosenSpecfication_in_ruleInstanceSpecification2022);
            lv_metamodel_5_0=ruleChoosenSpecfication();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getInstanceSpecificationRule());
            	        }
                   		set(
                   			current, 
                   			"metamodel",
                    		lv_metamodel_5_0, 
                    		"ChoosenSpecfication");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_6=(Token)match(input,26,FOLLOW_26_in_ruleInstanceSpecification2034); 

                	newLeafNode(otherlv_6, grammarAccess.getInstanceSpecificationAccess().getGreaterThanSignKeyword_6());
                
            otherlv_7=(Token)match(input,27,FOLLOW_27_in_ruleInstanceSpecification2046); 

                	newLeafNode(otherlv_7, grammarAccess.getInstanceSpecificationAccess().getLeftCurlyBracketKeyword_7());
                
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:945:1: ( ( (lv_constraintSemantics_8_0= ruleConstraintSemantic ) ) (otherlv_9= ',' ( (lv_constraintSemantics_10_0= ruleConstraintSemantic ) ) )* )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:945:2: ( (lv_constraintSemantics_8_0= ruleConstraintSemantic ) ) (otherlv_9= ',' ( (lv_constraintSemantics_10_0= ruleConstraintSemantic ) ) )*
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:945:2: ( (lv_constraintSemantics_8_0= ruleConstraintSemantic ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:946:1: (lv_constraintSemantics_8_0= ruleConstraintSemantic )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:946:1: (lv_constraintSemantics_8_0= ruleConstraintSemantic )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:947:3: lv_constraintSemantics_8_0= ruleConstraintSemantic
            {
             
            	        newCompositeNode(grammarAccess.getInstanceSpecificationAccess().getConstraintSemanticsConstraintSemanticParserRuleCall_8_0_0()); 
            	    
            pushFollow(FOLLOW_ruleConstraintSemantic_in_ruleInstanceSpecification2068);
            lv_constraintSemantics_8_0=ruleConstraintSemantic();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getInstanceSpecificationRule());
            	        }
                   		add(
                   			current, 
                   			"constraintSemantics",
                    		lv_constraintSemantics_8_0, 
                    		"ConstraintSemantic");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:963:2: (otherlv_9= ',' ( (lv_constraintSemantics_10_0= ruleConstraintSemantic ) ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==20) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:963:4: otherlv_9= ',' ( (lv_constraintSemantics_10_0= ruleConstraintSemantic ) )
            	    {
            	    otherlv_9=(Token)match(input,20,FOLLOW_20_in_ruleInstanceSpecification2081); 

            	        	newLeafNode(otherlv_9, grammarAccess.getInstanceSpecificationAccess().getCommaKeyword_8_1_0());
            	        
            	    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:967:1: ( (lv_constraintSemantics_10_0= ruleConstraintSemantic ) )
            	    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:968:1: (lv_constraintSemantics_10_0= ruleConstraintSemantic )
            	    {
            	    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:968:1: (lv_constraintSemantics_10_0= ruleConstraintSemantic )
            	    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:969:3: lv_constraintSemantics_10_0= ruleConstraintSemantic
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getInstanceSpecificationAccess().getConstraintSemanticsConstraintSemanticParserRuleCall_8_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleConstraintSemantic_in_ruleInstanceSpecification2102);
            	    lv_constraintSemantics_10_0=ruleConstraintSemantic();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getInstanceSpecificationRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"constraintSemantics",
            	            		lv_constraintSemantics_10_0, 
            	            		"ConstraintSemantic");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);


            }

            otherlv_11=(Token)match(input,28,FOLLOW_28_in_ruleInstanceSpecification2117); 

                	newLeafNode(otherlv_11, grammarAccess.getInstanceSpecificationAccess().getRightCurlyBracketKeyword_9());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleInstanceSpecification"


    // $ANTLR start "entryRuleChoosenSpecfication"
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:997:1: entryRuleChoosenSpecfication returns [EObject current=null] : iv_ruleChoosenSpecfication= ruleChoosenSpecfication EOF ;
    public final EObject entryRuleChoosenSpecfication() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleChoosenSpecfication = null;


        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:998:2: (iv_ruleChoosenSpecfication= ruleChoosenSpecfication EOF )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:999:2: iv_ruleChoosenSpecfication= ruleChoosenSpecfication EOF
            {
             newCompositeNode(grammarAccess.getChoosenSpecficationRule()); 
            pushFollow(FOLLOW_ruleChoosenSpecfication_in_entryRuleChoosenSpecfication2153);
            iv_ruleChoosenSpecfication=ruleChoosenSpecfication();

            state._fsp--;

             current =iv_ruleChoosenSpecfication; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleChoosenSpecfication2163); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleChoosenSpecfication"


    // $ANTLR start "ruleChoosenSpecfication"
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1006:1: ruleChoosenSpecfication returns [EObject current=null] : ( (lv_id_0_0= RULE_ID ) ) ;
    public final EObject ruleChoosenSpecfication() throws RecognitionException {
        EObject current = null;

        Token lv_id_0_0=null;

         enterRule(); 
            
        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1009:28: ( ( (lv_id_0_0= RULE_ID ) ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1010:1: ( (lv_id_0_0= RULE_ID ) )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1010:1: ( (lv_id_0_0= RULE_ID ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1011:1: (lv_id_0_0= RULE_ID )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1011:1: (lv_id_0_0= RULE_ID )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1012:3: lv_id_0_0= RULE_ID
            {
            lv_id_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleChoosenSpecfication2204); 

            			newLeafNode(lv_id_0_0, grammarAccess.getChoosenSpecficationAccess().getIdIDTerminalRuleCall_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getChoosenSpecficationRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"id",
                    		lv_id_0_0, 
                    		"ID");
            	    

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleChoosenSpecfication"


    // $ANTLR start "entryRuleConstraintSemantic"
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1036:1: entryRuleConstraintSemantic returns [EObject current=null] : iv_ruleConstraintSemantic= ruleConstraintSemantic EOF ;
    public final EObject entryRuleConstraintSemantic() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstraintSemantic = null;


        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1037:2: (iv_ruleConstraintSemantic= ruleConstraintSemantic EOF )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1038:2: iv_ruleConstraintSemantic= ruleConstraintSemantic EOF
            {
             newCompositeNode(grammarAccess.getConstraintSemanticRule()); 
            pushFollow(FOLLOW_ruleConstraintSemantic_in_entryRuleConstraintSemantic2244);
            iv_ruleConstraintSemantic=ruleConstraintSemantic();

            state._fsp--;

             current =iv_ruleConstraintSemantic; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleConstraintSemantic2254); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleConstraintSemantic"


    // $ANTLR start "ruleConstraintSemantic"
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1045:1: ruleConstraintSemantic returns [EObject current=null] : ( ( (lv_id_0_0= ruleDpfId ) ) otherlv_1= '{' ( ( (lv_arrows_2_0= ruleArrows ) ) (otherlv_3= ',' ( (lv_arrows_4_0= ruleArrows ) ) )* ) otherlv_5= ',' otherlv_6= '}' otherlv_7= '=' ( (lv_ocl_8_0= RULE_STRING ) ) ) ;
    public final EObject ruleConstraintSemantic() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token lv_ocl_8_0=null;
        EObject lv_id_0_0 = null;

        EObject lv_arrows_2_0 = null;

        EObject lv_arrows_4_0 = null;


         enterRule(); 
            
        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1048:28: ( ( ( (lv_id_0_0= ruleDpfId ) ) otherlv_1= '{' ( ( (lv_arrows_2_0= ruleArrows ) ) (otherlv_3= ',' ( (lv_arrows_4_0= ruleArrows ) ) )* ) otherlv_5= ',' otherlv_6= '}' otherlv_7= '=' ( (lv_ocl_8_0= RULE_STRING ) ) ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1049:1: ( ( (lv_id_0_0= ruleDpfId ) ) otherlv_1= '{' ( ( (lv_arrows_2_0= ruleArrows ) ) (otherlv_3= ',' ( (lv_arrows_4_0= ruleArrows ) ) )* ) otherlv_5= ',' otherlv_6= '}' otherlv_7= '=' ( (lv_ocl_8_0= RULE_STRING ) ) )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1049:1: ( ( (lv_id_0_0= ruleDpfId ) ) otherlv_1= '{' ( ( (lv_arrows_2_0= ruleArrows ) ) (otherlv_3= ',' ( (lv_arrows_4_0= ruleArrows ) ) )* ) otherlv_5= ',' otherlv_6= '}' otherlv_7= '=' ( (lv_ocl_8_0= RULE_STRING ) ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1049:2: ( (lv_id_0_0= ruleDpfId ) ) otherlv_1= '{' ( ( (lv_arrows_2_0= ruleArrows ) ) (otherlv_3= ',' ( (lv_arrows_4_0= ruleArrows ) ) )* ) otherlv_5= ',' otherlv_6= '}' otherlv_7= '=' ( (lv_ocl_8_0= RULE_STRING ) )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1049:2: ( (lv_id_0_0= ruleDpfId ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1050:1: (lv_id_0_0= ruleDpfId )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1050:1: (lv_id_0_0= ruleDpfId )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1051:3: lv_id_0_0= ruleDpfId
            {
             
            	        newCompositeNode(grammarAccess.getConstraintSemanticAccess().getIdDpfIdParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleDpfId_in_ruleConstraintSemantic2300);
            lv_id_0_0=ruleDpfId();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getConstraintSemanticRule());
            	        }
                   		set(
                   			current, 
                   			"id",
                    		lv_id_0_0, 
                    		"DpfId");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_1=(Token)match(input,27,FOLLOW_27_in_ruleConstraintSemantic2312); 

                	newLeafNode(otherlv_1, grammarAccess.getConstraintSemanticAccess().getLeftCurlyBracketKeyword_1());
                
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1071:1: ( ( (lv_arrows_2_0= ruleArrows ) ) (otherlv_3= ',' ( (lv_arrows_4_0= ruleArrows ) ) )* )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1071:2: ( (lv_arrows_2_0= ruleArrows ) ) (otherlv_3= ',' ( (lv_arrows_4_0= ruleArrows ) ) )*
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1071:2: ( (lv_arrows_2_0= ruleArrows ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1072:1: (lv_arrows_2_0= ruleArrows )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1072:1: (lv_arrows_2_0= ruleArrows )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1073:3: lv_arrows_2_0= ruleArrows
            {
             
            	        newCompositeNode(grammarAccess.getConstraintSemanticAccess().getArrowsArrowsParserRuleCall_2_0_0()); 
            	    
            pushFollow(FOLLOW_ruleArrows_in_ruleConstraintSemantic2334);
            lv_arrows_2_0=ruleArrows();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getConstraintSemanticRule());
            	        }
                   		add(
                   			current, 
                   			"arrows",
                    		lv_arrows_2_0, 
                    		"Arrows");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1089:2: (otherlv_3= ',' ( (lv_arrows_4_0= ruleArrows ) ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==20) ) {
                    int LA6_1 = input.LA(2);

                    if ( (LA6_1==RULE_ID) ) {
                        alt6=1;
                    }


                }


                switch (alt6) {
            	case 1 :
            	    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1089:4: otherlv_3= ',' ( (lv_arrows_4_0= ruleArrows ) )
            	    {
            	    otherlv_3=(Token)match(input,20,FOLLOW_20_in_ruleConstraintSemantic2347); 

            	        	newLeafNode(otherlv_3, grammarAccess.getConstraintSemanticAccess().getCommaKeyword_2_1_0());
            	        
            	    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1093:1: ( (lv_arrows_4_0= ruleArrows ) )
            	    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1094:1: (lv_arrows_4_0= ruleArrows )
            	    {
            	    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1094:1: (lv_arrows_4_0= ruleArrows )
            	    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1095:3: lv_arrows_4_0= ruleArrows
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getConstraintSemanticAccess().getArrowsArrowsParserRuleCall_2_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleArrows_in_ruleConstraintSemantic2368);
            	    lv_arrows_4_0=ruleArrows();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getConstraintSemanticRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"arrows",
            	            		lv_arrows_4_0, 
            	            		"Arrows");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);


            }

            otherlv_5=(Token)match(input,20,FOLLOW_20_in_ruleConstraintSemantic2383); 

                	newLeafNode(otherlv_5, grammarAccess.getConstraintSemanticAccess().getCommaKeyword_3());
                
            otherlv_6=(Token)match(input,28,FOLLOW_28_in_ruleConstraintSemantic2395); 

                	newLeafNode(otherlv_6, grammarAccess.getConstraintSemanticAccess().getRightCurlyBracketKeyword_4());
                
            otherlv_7=(Token)match(input,29,FOLLOW_29_in_ruleConstraintSemantic2407); 

                	newLeafNode(otherlv_7, grammarAccess.getConstraintSemanticAccess().getEqualsSignKeyword_5());
                
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1123:1: ( (lv_ocl_8_0= RULE_STRING ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1124:1: (lv_ocl_8_0= RULE_STRING )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1124:1: (lv_ocl_8_0= RULE_STRING )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1125:3: lv_ocl_8_0= RULE_STRING
            {
            lv_ocl_8_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleConstraintSemantic2424); 

            			newLeafNode(lv_ocl_8_0, grammarAccess.getConstraintSemanticAccess().getOclSTRINGTerminalRuleCall_6_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getConstraintSemanticRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"ocl",
                    		lv_ocl_8_0, 
                    		"STRING");
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleConstraintSemantic"


    // $ANTLR start "entryRuleSpecification"
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1149:1: entryRuleSpecification returns [EObject current=null] : iv_ruleSpecification= ruleSpecification EOF ;
    public final EObject entryRuleSpecification() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSpecification = null;


        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1150:2: (iv_ruleSpecification= ruleSpecification EOF )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1151:2: iv_ruleSpecification= ruleSpecification EOF
            {
             newCompositeNode(grammarAccess.getSpecificationRule()); 
            pushFollow(FOLLOW_ruleSpecification_in_entryRuleSpecification2465);
            iv_ruleSpecification=ruleSpecification();

            state._fsp--;

             current =iv_ruleSpecification; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSpecification2475); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSpecification"


    // $ANTLR start "ruleSpecification"
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1158:1: ruleSpecification returns [EObject current=null] : ( ( (lv_id_0_0= RULE_ID ) ) otherlv_1= ':=' otherlv_2= 'Spec<' ( (lv_graph_3_0= ruleChoosenGraph ) ) otherlv_4= '>' otherlv_5= '{' ( ( (lv_constraints_6_0= ruleConstraint ) ) (otherlv_7= ',' ( (lv_constraints_8_0= ruleConstraint ) ) )* )? otherlv_9= '}' ) ;
    public final EObject ruleSpecification() throws RecognitionException {
        EObject current = null;

        Token lv_id_0_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        EObject lv_graph_3_0 = null;

        EObject lv_constraints_6_0 = null;

        EObject lv_constraints_8_0 = null;


         enterRule(); 
            
        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1161:28: ( ( ( (lv_id_0_0= RULE_ID ) ) otherlv_1= ':=' otherlv_2= 'Spec<' ( (lv_graph_3_0= ruleChoosenGraph ) ) otherlv_4= '>' otherlv_5= '{' ( ( (lv_constraints_6_0= ruleConstraint ) ) (otherlv_7= ',' ( (lv_constraints_8_0= ruleConstraint ) ) )* )? otherlv_9= '}' ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1162:1: ( ( (lv_id_0_0= RULE_ID ) ) otherlv_1= ':=' otherlv_2= 'Spec<' ( (lv_graph_3_0= ruleChoosenGraph ) ) otherlv_4= '>' otherlv_5= '{' ( ( (lv_constraints_6_0= ruleConstraint ) ) (otherlv_7= ',' ( (lv_constraints_8_0= ruleConstraint ) ) )* )? otherlv_9= '}' )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1162:1: ( ( (lv_id_0_0= RULE_ID ) ) otherlv_1= ':=' otherlv_2= 'Spec<' ( (lv_graph_3_0= ruleChoosenGraph ) ) otherlv_4= '>' otherlv_5= '{' ( ( (lv_constraints_6_0= ruleConstraint ) ) (otherlv_7= ',' ( (lv_constraints_8_0= ruleConstraint ) ) )* )? otherlv_9= '}' )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1162:2: ( (lv_id_0_0= RULE_ID ) ) otherlv_1= ':=' otherlv_2= 'Spec<' ( (lv_graph_3_0= ruleChoosenGraph ) ) otherlv_4= '>' otherlv_5= '{' ( ( (lv_constraints_6_0= ruleConstraint ) ) (otherlv_7= ',' ( (lv_constraints_8_0= ruleConstraint ) ) )* )? otherlv_9= '}'
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1162:2: ( (lv_id_0_0= RULE_ID ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1163:1: (lv_id_0_0= RULE_ID )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1163:1: (lv_id_0_0= RULE_ID )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1164:3: lv_id_0_0= RULE_ID
            {
            lv_id_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSpecification2517); 

            			newLeafNode(lv_id_0_0, grammarAccess.getSpecificationAccess().getIdIDTerminalRuleCall_0_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getSpecificationRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"id",
                    		lv_id_0_0, 
                    		"ID");
            	    

            }


            }

            otherlv_1=(Token)match(input,24,FOLLOW_24_in_ruleSpecification2534); 

                	newLeafNode(otherlv_1, grammarAccess.getSpecificationAccess().getColonEqualsSignKeyword_1());
                
            otherlv_2=(Token)match(input,30,FOLLOW_30_in_ruleSpecification2546); 

                	newLeafNode(otherlv_2, grammarAccess.getSpecificationAccess().getSpecKeyword_2());
                
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1188:1: ( (lv_graph_3_0= ruleChoosenGraph ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1189:1: (lv_graph_3_0= ruleChoosenGraph )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1189:1: (lv_graph_3_0= ruleChoosenGraph )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1190:3: lv_graph_3_0= ruleChoosenGraph
            {
             
            	        newCompositeNode(grammarAccess.getSpecificationAccess().getGraphChoosenGraphParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_ruleChoosenGraph_in_ruleSpecification2567);
            lv_graph_3_0=ruleChoosenGraph();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getSpecificationRule());
            	        }
                   		set(
                   			current, 
                   			"graph",
                    		lv_graph_3_0, 
                    		"ChoosenGraph");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_4=(Token)match(input,26,FOLLOW_26_in_ruleSpecification2579); 

                	newLeafNode(otherlv_4, grammarAccess.getSpecificationAccess().getGreaterThanSignKeyword_4());
                
            otherlv_5=(Token)match(input,27,FOLLOW_27_in_ruleSpecification2591); 

                	newLeafNode(otherlv_5, grammarAccess.getSpecificationAccess().getLeftCurlyBracketKeyword_5());
                
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1214:1: ( ( (lv_constraints_6_0= ruleConstraint ) ) (otherlv_7= ',' ( (lv_constraints_8_0= ruleConstraint ) ) )* )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==RULE_ID) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1214:2: ( (lv_constraints_6_0= ruleConstraint ) ) (otherlv_7= ',' ( (lv_constraints_8_0= ruleConstraint ) ) )*
                    {
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1214:2: ( (lv_constraints_6_0= ruleConstraint ) )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1215:1: (lv_constraints_6_0= ruleConstraint )
                    {
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1215:1: (lv_constraints_6_0= ruleConstraint )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1216:3: lv_constraints_6_0= ruleConstraint
                    {
                     
                    	        newCompositeNode(grammarAccess.getSpecificationAccess().getConstraintsConstraintParserRuleCall_6_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleConstraint_in_ruleSpecification2613);
                    lv_constraints_6_0=ruleConstraint();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getSpecificationRule());
                    	        }
                           		add(
                           			current, 
                           			"constraints",
                            		lv_constraints_6_0, 
                            		"Constraint");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1232:2: (otherlv_7= ',' ( (lv_constraints_8_0= ruleConstraint ) ) )*
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( (LA7_0==20) ) {
                            alt7=1;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1232:4: otherlv_7= ',' ( (lv_constraints_8_0= ruleConstraint ) )
                    	    {
                    	    otherlv_7=(Token)match(input,20,FOLLOW_20_in_ruleSpecification2626); 

                    	        	newLeafNode(otherlv_7, grammarAccess.getSpecificationAccess().getCommaKeyword_6_1_0());
                    	        
                    	    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1236:1: ( (lv_constraints_8_0= ruleConstraint ) )
                    	    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1237:1: (lv_constraints_8_0= ruleConstraint )
                    	    {
                    	    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1237:1: (lv_constraints_8_0= ruleConstraint )
                    	    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1238:3: lv_constraints_8_0= ruleConstraint
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getSpecificationAccess().getConstraintsConstraintParserRuleCall_6_1_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleConstraint_in_ruleSpecification2647);
                    	    lv_constraints_8_0=ruleConstraint();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getSpecificationRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"constraints",
                    	            		lv_constraints_8_0, 
                    	            		"Constraint");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop7;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_9=(Token)match(input,28,FOLLOW_28_in_ruleSpecification2663); 

                	newLeafNode(otherlv_9, grammarAccess.getSpecificationAccess().getRightCurlyBracketKeyword_7());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSpecification"


    // $ANTLR start "entryRuleChoosenGraph"
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1266:1: entryRuleChoosenGraph returns [EObject current=null] : iv_ruleChoosenGraph= ruleChoosenGraph EOF ;
    public final EObject entryRuleChoosenGraph() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleChoosenGraph = null;


        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1267:2: (iv_ruleChoosenGraph= ruleChoosenGraph EOF )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1268:2: iv_ruleChoosenGraph= ruleChoosenGraph EOF
            {
             newCompositeNode(grammarAccess.getChoosenGraphRule()); 
            pushFollow(FOLLOW_ruleChoosenGraph_in_entryRuleChoosenGraph2699);
            iv_ruleChoosenGraph=ruleChoosenGraph();

            state._fsp--;

             current =iv_ruleChoosenGraph; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleChoosenGraph2709); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleChoosenGraph"


    // $ANTLR start "ruleChoosenGraph"
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1275:1: ruleChoosenGraph returns [EObject current=null] : ( (lv_id_0_0= RULE_ID ) ) ;
    public final EObject ruleChoosenGraph() throws RecognitionException {
        EObject current = null;

        Token lv_id_0_0=null;

         enterRule(); 
            
        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1278:28: ( ( (lv_id_0_0= RULE_ID ) ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1279:1: ( (lv_id_0_0= RULE_ID ) )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1279:1: ( (lv_id_0_0= RULE_ID ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1280:1: (lv_id_0_0= RULE_ID )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1280:1: (lv_id_0_0= RULE_ID )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1281:3: lv_id_0_0= RULE_ID
            {
            lv_id_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleChoosenGraph2750); 

            			newLeafNode(lv_id_0_0, grammarAccess.getChoosenGraphAccess().getIdIDTerminalRuleCall_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getChoosenGraphRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"id",
                    		lv_id_0_0, 
                    		"ID");
            	    

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleChoosenGraph"


    // $ANTLR start "entryRuleConstraint"
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1305:1: entryRuleConstraint returns [EObject current=null] : iv_ruleConstraint= ruleConstraint EOF ;
    public final EObject entryRuleConstraint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstraint = null;


        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1306:2: (iv_ruleConstraint= ruleConstraint EOF )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1307:2: iv_ruleConstraint= ruleConstraint EOF
            {
             newCompositeNode(grammarAccess.getConstraintRule()); 
            pushFollow(FOLLOW_ruleConstraint_in_entryRuleConstraint2790);
            iv_ruleConstraint=ruleConstraint();

            state._fsp--;

             current =iv_ruleConstraint; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleConstraint2800); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleConstraint"


    // $ANTLR start "ruleConstraint"
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1314:1: ruleConstraint returns [EObject current=null] : ( ( (lv_signature_0_0= ruleConstraintSignature ) ) otherlv_1= '{' ( ( (lv_arrows_2_0= ruleArrows ) ) (otherlv_3= ',' ( (lv_arrows_4_0= ruleArrows ) ) )* ) otherlv_5= '}' ) ;
    public final EObject ruleConstraint() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_signature_0_0 = null;

        EObject lv_arrows_2_0 = null;

        EObject lv_arrows_4_0 = null;


         enterRule(); 
            
        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1317:28: ( ( ( (lv_signature_0_0= ruleConstraintSignature ) ) otherlv_1= '{' ( ( (lv_arrows_2_0= ruleArrows ) ) (otherlv_3= ',' ( (lv_arrows_4_0= ruleArrows ) ) )* ) otherlv_5= '}' ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1318:1: ( ( (lv_signature_0_0= ruleConstraintSignature ) ) otherlv_1= '{' ( ( (lv_arrows_2_0= ruleArrows ) ) (otherlv_3= ',' ( (lv_arrows_4_0= ruleArrows ) ) )* ) otherlv_5= '}' )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1318:1: ( ( (lv_signature_0_0= ruleConstraintSignature ) ) otherlv_1= '{' ( ( (lv_arrows_2_0= ruleArrows ) ) (otherlv_3= ',' ( (lv_arrows_4_0= ruleArrows ) ) )* ) otherlv_5= '}' )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1318:2: ( (lv_signature_0_0= ruleConstraintSignature ) ) otherlv_1= '{' ( ( (lv_arrows_2_0= ruleArrows ) ) (otherlv_3= ',' ( (lv_arrows_4_0= ruleArrows ) ) )* ) otherlv_5= '}'
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1318:2: ( (lv_signature_0_0= ruleConstraintSignature ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1319:1: (lv_signature_0_0= ruleConstraintSignature )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1319:1: (lv_signature_0_0= ruleConstraintSignature )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1320:3: lv_signature_0_0= ruleConstraintSignature
            {
             
            	        newCompositeNode(grammarAccess.getConstraintAccess().getSignatureConstraintSignatureParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleConstraintSignature_in_ruleConstraint2846);
            lv_signature_0_0=ruleConstraintSignature();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getConstraintRule());
            	        }
                   		set(
                   			current, 
                   			"signature",
                    		lv_signature_0_0, 
                    		"ConstraintSignature");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_1=(Token)match(input,27,FOLLOW_27_in_ruleConstraint2858); 

                	newLeafNode(otherlv_1, grammarAccess.getConstraintAccess().getLeftCurlyBracketKeyword_1());
                
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1340:1: ( ( (lv_arrows_2_0= ruleArrows ) ) (otherlv_3= ',' ( (lv_arrows_4_0= ruleArrows ) ) )* )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1340:2: ( (lv_arrows_2_0= ruleArrows ) ) (otherlv_3= ',' ( (lv_arrows_4_0= ruleArrows ) ) )*
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1340:2: ( (lv_arrows_2_0= ruleArrows ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1341:1: (lv_arrows_2_0= ruleArrows )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1341:1: (lv_arrows_2_0= ruleArrows )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1342:3: lv_arrows_2_0= ruleArrows
            {
             
            	        newCompositeNode(grammarAccess.getConstraintAccess().getArrowsArrowsParserRuleCall_2_0_0()); 
            	    
            pushFollow(FOLLOW_ruleArrows_in_ruleConstraint2880);
            lv_arrows_2_0=ruleArrows();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getConstraintRule());
            	        }
                   		add(
                   			current, 
                   			"arrows",
                    		lv_arrows_2_0, 
                    		"Arrows");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1358:2: (otherlv_3= ',' ( (lv_arrows_4_0= ruleArrows ) ) )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==20) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1358:4: otherlv_3= ',' ( (lv_arrows_4_0= ruleArrows ) )
            	    {
            	    otherlv_3=(Token)match(input,20,FOLLOW_20_in_ruleConstraint2893); 

            	        	newLeafNode(otherlv_3, grammarAccess.getConstraintAccess().getCommaKeyword_2_1_0());
            	        
            	    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1362:1: ( (lv_arrows_4_0= ruleArrows ) )
            	    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1363:1: (lv_arrows_4_0= ruleArrows )
            	    {
            	    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1363:1: (lv_arrows_4_0= ruleArrows )
            	    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1364:3: lv_arrows_4_0= ruleArrows
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getConstraintAccess().getArrowsArrowsParserRuleCall_2_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleArrows_in_ruleConstraint2914);
            	    lv_arrows_4_0=ruleArrows();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getConstraintRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"arrows",
            	            		lv_arrows_4_0, 
            	            		"Arrows");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);


            }

            otherlv_5=(Token)match(input,28,FOLLOW_28_in_ruleConstraint2929); 

                	newLeafNode(otherlv_5, grammarAccess.getConstraintAccess().getRightCurlyBracketKeyword_3());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleConstraint"


    // $ANTLR start "entryRuleConstraintSignature"
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1392:1: entryRuleConstraintSignature returns [EObject current=null] : iv_ruleConstraintSignature= ruleConstraintSignature EOF ;
    public final EObject entryRuleConstraintSignature() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstraintSignature = null;


        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1393:2: (iv_ruleConstraintSignature= ruleConstraintSignature EOF )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1394:2: iv_ruleConstraintSignature= ruleConstraintSignature EOF
            {
             newCompositeNode(grammarAccess.getConstraintSignatureRule()); 
            pushFollow(FOLLOW_ruleConstraintSignature_in_entryRuleConstraintSignature2965);
            iv_ruleConstraintSignature=ruleConstraintSignature();

            state._fsp--;

             current =iv_ruleConstraintSignature; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleConstraintSignature2975); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleConstraintSignature"


    // $ANTLR start "ruleConstraintSignature"
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1401:1: ruleConstraintSignature returns [EObject current=null] : ( ( (lv_id_0_0= ruleDpfId ) ) otherlv_1= '(' ( ( (lv_parameter_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_parameter_4_0= RULE_ID ) ) )* )? otherlv_5= ')' ) ;
    public final EObject ruleConstraintSignature() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_parameter_2_0=null;
        Token otherlv_3=null;
        Token lv_parameter_4_0=null;
        Token otherlv_5=null;
        EObject lv_id_0_0 = null;


         enterRule(); 
            
        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1404:28: ( ( ( (lv_id_0_0= ruleDpfId ) ) otherlv_1= '(' ( ( (lv_parameter_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_parameter_4_0= RULE_ID ) ) )* )? otherlv_5= ')' ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1405:1: ( ( (lv_id_0_0= ruleDpfId ) ) otherlv_1= '(' ( ( (lv_parameter_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_parameter_4_0= RULE_ID ) ) )* )? otherlv_5= ')' )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1405:1: ( ( (lv_id_0_0= ruleDpfId ) ) otherlv_1= '(' ( ( (lv_parameter_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_parameter_4_0= RULE_ID ) ) )* )? otherlv_5= ')' )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1405:2: ( (lv_id_0_0= ruleDpfId ) ) otherlv_1= '(' ( ( (lv_parameter_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_parameter_4_0= RULE_ID ) ) )* )? otherlv_5= ')'
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1405:2: ( (lv_id_0_0= ruleDpfId ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1406:1: (lv_id_0_0= ruleDpfId )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1406:1: (lv_id_0_0= ruleDpfId )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1407:3: lv_id_0_0= ruleDpfId
            {
             
            	        newCompositeNode(grammarAccess.getConstraintSignatureAccess().getIdDpfIdParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleDpfId_in_ruleConstraintSignature3021);
            lv_id_0_0=ruleDpfId();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getConstraintSignatureRule());
            	        }
                   		set(
                   			current, 
                   			"id",
                    		lv_id_0_0, 
                    		"DpfId");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_1=(Token)match(input,31,FOLLOW_31_in_ruleConstraintSignature3033); 

                	newLeafNode(otherlv_1, grammarAccess.getConstraintSignatureAccess().getLeftParenthesisKeyword_1());
                
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1427:1: ( ( (lv_parameter_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_parameter_4_0= RULE_ID ) ) )* )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==RULE_ID) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1427:2: ( (lv_parameter_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_parameter_4_0= RULE_ID ) ) )*
                    {
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1427:2: ( (lv_parameter_2_0= RULE_ID ) )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1428:1: (lv_parameter_2_0= RULE_ID )
                    {
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1428:1: (lv_parameter_2_0= RULE_ID )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1429:3: lv_parameter_2_0= RULE_ID
                    {
                    lv_parameter_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleConstraintSignature3051); 

                    			newLeafNode(lv_parameter_2_0, grammarAccess.getConstraintSignatureAccess().getParameterIDTerminalRuleCall_2_0_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getConstraintSignatureRule());
                    	        }
                           		addWithLastConsumed(
                           			current, 
                           			"parameter",
                            		lv_parameter_2_0, 
                            		"ID");
                    	    

                    }


                    }

                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1445:2: (otherlv_3= ',' ( (lv_parameter_4_0= RULE_ID ) ) )*
                    loop10:
                    do {
                        int alt10=2;
                        int LA10_0 = input.LA(1);

                        if ( (LA10_0==20) ) {
                            alt10=1;
                        }


                        switch (alt10) {
                    	case 1 :
                    	    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1445:4: otherlv_3= ',' ( (lv_parameter_4_0= RULE_ID ) )
                    	    {
                    	    otherlv_3=(Token)match(input,20,FOLLOW_20_in_ruleConstraintSignature3069); 

                    	        	newLeafNode(otherlv_3, grammarAccess.getConstraintSignatureAccess().getCommaKeyword_2_1_0());
                    	        
                    	    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1449:1: ( (lv_parameter_4_0= RULE_ID ) )
                    	    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1450:1: (lv_parameter_4_0= RULE_ID )
                    	    {
                    	    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1450:1: (lv_parameter_4_0= RULE_ID )
                    	    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1451:3: lv_parameter_4_0= RULE_ID
                    	    {
                    	    lv_parameter_4_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleConstraintSignature3086); 

                    	    			newLeafNode(lv_parameter_4_0, grammarAccess.getConstraintSignatureAccess().getParameterIDTerminalRuleCall_2_1_1_0()); 
                    	    		

                    	    	        if (current==null) {
                    	    	            current = createModelElement(grammarAccess.getConstraintSignatureRule());
                    	    	        }
                    	           		addWithLastConsumed(
                    	           			current, 
                    	           			"parameter",
                    	            		lv_parameter_4_0, 
                    	            		"ID");
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop10;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_5=(Token)match(input,14,FOLLOW_14_in_ruleConstraintSignature3107); 

                	newLeafNode(otherlv_5, grammarAccess.getConstraintSignatureAccess().getRightParenthesisKeyword_3());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleConstraintSignature"


    // $ANTLR start "entryRuleMorphism"
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1479:1: entryRuleMorphism returns [EObject current=null] : iv_ruleMorphism= ruleMorphism EOF ;
    public final EObject entryRuleMorphism() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMorphism = null;


        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1480:2: (iv_ruleMorphism= ruleMorphism EOF )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1481:2: iv_ruleMorphism= ruleMorphism EOF
            {
             newCompositeNode(grammarAccess.getMorphismRule()); 
            pushFollow(FOLLOW_ruleMorphism_in_entryRuleMorphism3143);
            iv_ruleMorphism=ruleMorphism();

            state._fsp--;

             current =iv_ruleMorphism; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMorphism3153); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMorphism"


    // $ANTLR start "ruleMorphism"
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1488:1: ruleMorphism returns [EObject current=null] : (this_ID_0= RULE_ID otherlv_1= ':=' otherlv_2= 'Morphism<' ( (lv_domain_3_0= ruleDomain ) ) otherlv_4= ',' ( (lv_codmain_5_0= ruleCodomain ) ) otherlv_6= '>' otherlv_7= '{' ( ( (lv_mappings_8_0= ruleMapping ) ) (otherlv_9= ',' ( (lv_mappings_10_0= ruleMapping ) ) )* )? otherlv_11= '}' ) ;
    public final EObject ruleMorphism() throws RecognitionException {
        EObject current = null;

        Token this_ID_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        EObject lv_domain_3_0 = null;

        EObject lv_codmain_5_0 = null;

        EObject lv_mappings_8_0 = null;

        EObject lv_mappings_10_0 = null;


         enterRule(); 
            
        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1491:28: ( (this_ID_0= RULE_ID otherlv_1= ':=' otherlv_2= 'Morphism<' ( (lv_domain_3_0= ruleDomain ) ) otherlv_4= ',' ( (lv_codmain_5_0= ruleCodomain ) ) otherlv_6= '>' otherlv_7= '{' ( ( (lv_mappings_8_0= ruleMapping ) ) (otherlv_9= ',' ( (lv_mappings_10_0= ruleMapping ) ) )* )? otherlv_11= '}' ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1492:1: (this_ID_0= RULE_ID otherlv_1= ':=' otherlv_2= 'Morphism<' ( (lv_domain_3_0= ruleDomain ) ) otherlv_4= ',' ( (lv_codmain_5_0= ruleCodomain ) ) otherlv_6= '>' otherlv_7= '{' ( ( (lv_mappings_8_0= ruleMapping ) ) (otherlv_9= ',' ( (lv_mappings_10_0= ruleMapping ) ) )* )? otherlv_11= '}' )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1492:1: (this_ID_0= RULE_ID otherlv_1= ':=' otherlv_2= 'Morphism<' ( (lv_domain_3_0= ruleDomain ) ) otherlv_4= ',' ( (lv_codmain_5_0= ruleCodomain ) ) otherlv_6= '>' otherlv_7= '{' ( ( (lv_mappings_8_0= ruleMapping ) ) (otherlv_9= ',' ( (lv_mappings_10_0= ruleMapping ) ) )* )? otherlv_11= '}' )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1492:2: this_ID_0= RULE_ID otherlv_1= ':=' otherlv_2= 'Morphism<' ( (lv_domain_3_0= ruleDomain ) ) otherlv_4= ',' ( (lv_codmain_5_0= ruleCodomain ) ) otherlv_6= '>' otherlv_7= '{' ( ( (lv_mappings_8_0= ruleMapping ) ) (otherlv_9= ',' ( (lv_mappings_10_0= ruleMapping ) ) )* )? otherlv_11= '}'
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleMorphism3189); 
             
                newLeafNode(this_ID_0, grammarAccess.getMorphismAccess().getIDTerminalRuleCall_0()); 
                
            otherlv_1=(Token)match(input,24,FOLLOW_24_in_ruleMorphism3200); 

                	newLeafNode(otherlv_1, grammarAccess.getMorphismAccess().getColonEqualsSignKeyword_1());
                
            otherlv_2=(Token)match(input,32,FOLLOW_32_in_ruleMorphism3212); 

                	newLeafNode(otherlv_2, grammarAccess.getMorphismAccess().getMorphismKeyword_2());
                
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1504:1: ( (lv_domain_3_0= ruleDomain ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1505:1: (lv_domain_3_0= ruleDomain )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1505:1: (lv_domain_3_0= ruleDomain )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1506:3: lv_domain_3_0= ruleDomain
            {
             
            	        newCompositeNode(grammarAccess.getMorphismAccess().getDomainDomainParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_ruleDomain_in_ruleMorphism3233);
            lv_domain_3_0=ruleDomain();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getMorphismRule());
            	        }
                   		set(
                   			current, 
                   			"domain",
                    		lv_domain_3_0, 
                    		"Domain");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_4=(Token)match(input,20,FOLLOW_20_in_ruleMorphism3245); 

                	newLeafNode(otherlv_4, grammarAccess.getMorphismAccess().getCommaKeyword_4());
                
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1526:1: ( (lv_codmain_5_0= ruleCodomain ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1527:1: (lv_codmain_5_0= ruleCodomain )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1527:1: (lv_codmain_5_0= ruleCodomain )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1528:3: lv_codmain_5_0= ruleCodomain
            {
             
            	        newCompositeNode(grammarAccess.getMorphismAccess().getCodmainCodomainParserRuleCall_5_0()); 
            	    
            pushFollow(FOLLOW_ruleCodomain_in_ruleMorphism3266);
            lv_codmain_5_0=ruleCodomain();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getMorphismRule());
            	        }
                   		set(
                   			current, 
                   			"codmain",
                    		lv_codmain_5_0, 
                    		"Codomain");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_6=(Token)match(input,26,FOLLOW_26_in_ruleMorphism3278); 

                	newLeafNode(otherlv_6, grammarAccess.getMorphismAccess().getGreaterThanSignKeyword_6());
                
            otherlv_7=(Token)match(input,27,FOLLOW_27_in_ruleMorphism3290); 

                	newLeafNode(otherlv_7, grammarAccess.getMorphismAccess().getLeftCurlyBracketKeyword_7());
                
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1552:1: ( ( (lv_mappings_8_0= ruleMapping ) ) (otherlv_9= ',' ( (lv_mappings_10_0= ruleMapping ) ) )* )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==RULE_ID) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1552:2: ( (lv_mappings_8_0= ruleMapping ) ) (otherlv_9= ',' ( (lv_mappings_10_0= ruleMapping ) ) )*
                    {
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1552:2: ( (lv_mappings_8_0= ruleMapping ) )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1553:1: (lv_mappings_8_0= ruleMapping )
                    {
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1553:1: (lv_mappings_8_0= ruleMapping )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1554:3: lv_mappings_8_0= ruleMapping
                    {
                     
                    	        newCompositeNode(grammarAccess.getMorphismAccess().getMappingsMappingParserRuleCall_8_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleMapping_in_ruleMorphism3312);
                    lv_mappings_8_0=ruleMapping();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getMorphismRule());
                    	        }
                           		add(
                           			current, 
                           			"mappings",
                            		lv_mappings_8_0, 
                            		"Mapping");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1570:2: (otherlv_9= ',' ( (lv_mappings_10_0= ruleMapping ) ) )*
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( (LA12_0==20) ) {
                            alt12=1;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1570:4: otherlv_9= ',' ( (lv_mappings_10_0= ruleMapping ) )
                    	    {
                    	    otherlv_9=(Token)match(input,20,FOLLOW_20_in_ruleMorphism3325); 

                    	        	newLeafNode(otherlv_9, grammarAccess.getMorphismAccess().getCommaKeyword_8_1_0());
                    	        
                    	    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1574:1: ( (lv_mappings_10_0= ruleMapping ) )
                    	    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1575:1: (lv_mappings_10_0= ruleMapping )
                    	    {
                    	    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1575:1: (lv_mappings_10_0= ruleMapping )
                    	    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1576:3: lv_mappings_10_0= ruleMapping
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getMorphismAccess().getMappingsMappingParserRuleCall_8_1_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleMapping_in_ruleMorphism3346);
                    	    lv_mappings_10_0=ruleMapping();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getMorphismRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"mappings",
                    	            		lv_mappings_10_0, 
                    	            		"Mapping");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop12;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_11=(Token)match(input,28,FOLLOW_28_in_ruleMorphism3362); 

                	newLeafNode(otherlv_11, grammarAccess.getMorphismAccess().getRightCurlyBracketKeyword_9());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMorphism"


    // $ANTLR start "entryRuleDomain"
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1604:1: entryRuleDomain returns [EObject current=null] : iv_ruleDomain= ruleDomain EOF ;
    public final EObject entryRuleDomain() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDomain = null;


        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1605:2: (iv_ruleDomain= ruleDomain EOF )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1606:2: iv_ruleDomain= ruleDomain EOF
            {
             newCompositeNode(grammarAccess.getDomainRule()); 
            pushFollow(FOLLOW_ruleDomain_in_entryRuleDomain3398);
            iv_ruleDomain=ruleDomain();

            state._fsp--;

             current =iv_ruleDomain; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDomain3408); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDomain"


    // $ANTLR start "ruleDomain"
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1613:1: ruleDomain returns [EObject current=null] : ( (lv_id_0_0= RULE_ID ) ) ;
    public final EObject ruleDomain() throws RecognitionException {
        EObject current = null;

        Token lv_id_0_0=null;

         enterRule(); 
            
        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1616:28: ( ( (lv_id_0_0= RULE_ID ) ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1617:1: ( (lv_id_0_0= RULE_ID ) )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1617:1: ( (lv_id_0_0= RULE_ID ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1618:1: (lv_id_0_0= RULE_ID )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1618:1: (lv_id_0_0= RULE_ID )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1619:3: lv_id_0_0= RULE_ID
            {
            lv_id_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDomain3449); 

            			newLeafNode(lv_id_0_0, grammarAccess.getDomainAccess().getIdIDTerminalRuleCall_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getDomainRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"id",
                    		lv_id_0_0, 
                    		"ID");
            	    

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDomain"


    // $ANTLR start "entryRuleCodomain"
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1643:1: entryRuleCodomain returns [EObject current=null] : iv_ruleCodomain= ruleCodomain EOF ;
    public final EObject entryRuleCodomain() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCodomain = null;


        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1644:2: (iv_ruleCodomain= ruleCodomain EOF )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1645:2: iv_ruleCodomain= ruleCodomain EOF
            {
             newCompositeNode(grammarAccess.getCodomainRule()); 
            pushFollow(FOLLOW_ruleCodomain_in_entryRuleCodomain3489);
            iv_ruleCodomain=ruleCodomain();

            state._fsp--;

             current =iv_ruleCodomain; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCodomain3499); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCodomain"


    // $ANTLR start "ruleCodomain"
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1652:1: ruleCodomain returns [EObject current=null] : ( (lv_id_0_0= RULE_ID ) ) ;
    public final EObject ruleCodomain() throws RecognitionException {
        EObject current = null;

        Token lv_id_0_0=null;

         enterRule(); 
            
        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1655:28: ( ( (lv_id_0_0= RULE_ID ) ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1656:1: ( (lv_id_0_0= RULE_ID ) )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1656:1: ( (lv_id_0_0= RULE_ID ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1657:1: (lv_id_0_0= RULE_ID )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1657:1: (lv_id_0_0= RULE_ID )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1658:3: lv_id_0_0= RULE_ID
            {
            lv_id_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleCodomain3540); 

            			newLeafNode(lv_id_0_0, grammarAccess.getCodomainAccess().getIdIDTerminalRuleCall_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getCodomainRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"id",
                    		lv_id_0_0, 
                    		"ID");
            	    

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCodomain"


    // $ANTLR start "entryRuleMapping"
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1682:1: entryRuleMapping returns [EObject current=null] : iv_ruleMapping= ruleMapping EOF ;
    public final EObject entryRuleMapping() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMapping = null;


        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1683:2: (iv_ruleMapping= ruleMapping EOF )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1684:2: iv_ruleMapping= ruleMapping EOF
            {
             newCompositeNode(grammarAccess.getMappingRule()); 
            pushFollow(FOLLOW_ruleMapping_in_entryRuleMapping3580);
            iv_ruleMapping=ruleMapping();

            state._fsp--;

             current =iv_ruleMapping; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMapping3590); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMapping"


    // $ANTLR start "ruleMapping"
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1691:1: ruleMapping returns [EObject current=null] : (this_MappingNode_0= ruleMappingNode | this_MappingArrow_1= ruleMappingArrow ) ;
    public final EObject ruleMapping() throws RecognitionException {
        EObject current = null;

        EObject this_MappingNode_0 = null;

        EObject this_MappingArrow_1 = null;


         enterRule(); 
            
        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1694:28: ( (this_MappingNode_0= ruleMappingNode | this_MappingArrow_1= ruleMappingArrow ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1695:1: (this_MappingNode_0= ruleMappingNode | this_MappingArrow_1= ruleMappingArrow )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1695:1: (this_MappingNode_0= ruleMappingNode | this_MappingArrow_1= ruleMappingArrow )
            int alt14=2;
            alt14 = dfa14.predict(input);
            switch (alt14) {
                case 1 :
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1696:5: this_MappingNode_0= ruleMappingNode
                    {
                     
                            newCompositeNode(grammarAccess.getMappingAccess().getMappingNodeParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleMappingNode_in_ruleMapping3637);
                    this_MappingNode_0=ruleMappingNode();

                    state._fsp--;

                     
                            current = this_MappingNode_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1706:5: this_MappingArrow_1= ruleMappingArrow
                    {
                     
                            newCompositeNode(grammarAccess.getMappingAccess().getMappingArrowParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleMappingArrow_in_ruleMapping3664);
                    this_MappingArrow_1=ruleMappingArrow();

                    state._fsp--;

                     
                            current = this_MappingArrow_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMapping"


    // $ANTLR start "entryRuleMappingNode"
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1722:1: entryRuleMappingNode returns [EObject current=null] : iv_ruleMappingNode= ruleMappingNode EOF ;
    public final EObject entryRuleMappingNode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMappingNode = null;


        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1723:2: (iv_ruleMappingNode= ruleMappingNode EOF )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1724:2: iv_ruleMappingNode= ruleMappingNode EOF
            {
             newCompositeNode(grammarAccess.getMappingNodeRule()); 
            pushFollow(FOLLOW_ruleMappingNode_in_entryRuleMappingNode3699);
            iv_ruleMappingNode=ruleMappingNode();

            state._fsp--;

             current =iv_ruleMappingNode; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMappingNode3709); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMappingNode"


    // $ANTLR start "ruleMappingNode"
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1731:1: ruleMappingNode returns [EObject current=null] : ( ( (lv_domain_0_0= ruleNode ) ) otherlv_1= '=>' ( (lv_codomain_2_0= ruleNode ) ) ) ;
    public final EObject ruleMappingNode() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_domain_0_0 = null;

        EObject lv_codomain_2_0 = null;


         enterRule(); 
            
        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1734:28: ( ( ( (lv_domain_0_0= ruleNode ) ) otherlv_1= '=>' ( (lv_codomain_2_0= ruleNode ) ) ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1735:1: ( ( (lv_domain_0_0= ruleNode ) ) otherlv_1= '=>' ( (lv_codomain_2_0= ruleNode ) ) )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1735:1: ( ( (lv_domain_0_0= ruleNode ) ) otherlv_1= '=>' ( (lv_codomain_2_0= ruleNode ) ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1735:2: ( (lv_domain_0_0= ruleNode ) ) otherlv_1= '=>' ( (lv_codomain_2_0= ruleNode ) )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1735:2: ( (lv_domain_0_0= ruleNode ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1736:1: (lv_domain_0_0= ruleNode )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1736:1: (lv_domain_0_0= ruleNode )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1737:3: lv_domain_0_0= ruleNode
            {
             
            	        newCompositeNode(grammarAccess.getMappingNodeAccess().getDomainNodeParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleNode_in_ruleMappingNode3755);
            lv_domain_0_0=ruleNode();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getMappingNodeRule());
            	        }
                   		set(
                   			current, 
                   			"domain",
                    		lv_domain_0_0, 
                    		"Node");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_1=(Token)match(input,33,FOLLOW_33_in_ruleMappingNode3767); 

                	newLeafNode(otherlv_1, grammarAccess.getMappingNodeAccess().getEqualsSignGreaterThanSignKeyword_1());
                
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1757:1: ( (lv_codomain_2_0= ruleNode ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1758:1: (lv_codomain_2_0= ruleNode )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1758:1: (lv_codomain_2_0= ruleNode )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1759:3: lv_codomain_2_0= ruleNode
            {
             
            	        newCompositeNode(grammarAccess.getMappingNodeAccess().getCodomainNodeParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleNode_in_ruleMappingNode3788);
            lv_codomain_2_0=ruleNode();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getMappingNodeRule());
            	        }
                   		set(
                   			current, 
                   			"codomain",
                    		lv_codomain_2_0, 
                    		"Node");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMappingNode"


    // $ANTLR start "entryRuleMappingArrow"
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1783:1: entryRuleMappingArrow returns [EObject current=null] : iv_ruleMappingArrow= ruleMappingArrow EOF ;
    public final EObject entryRuleMappingArrow() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMappingArrow = null;


        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1784:2: (iv_ruleMappingArrow= ruleMappingArrow EOF )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1785:2: iv_ruleMappingArrow= ruleMappingArrow EOF
            {
             newCompositeNode(grammarAccess.getMappingArrowRule()); 
            pushFollow(FOLLOW_ruleMappingArrow_in_entryRuleMappingArrow3824);
            iv_ruleMappingArrow=ruleMappingArrow();

            state._fsp--;

             current =iv_ruleMappingArrow; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMappingArrow3834); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMappingArrow"


    // $ANTLR start "ruleMappingArrow"
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1792:1: ruleMappingArrow returns [EObject current=null] : ( ( (lv_domain_0_0= ruleArrow ) ) otherlv_1= '=>' ( (lv_codmain_2_0= ruleArrow ) ) ) ;
    public final EObject ruleMappingArrow() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_domain_0_0 = null;

        EObject lv_codmain_2_0 = null;


         enterRule(); 
            
        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1795:28: ( ( ( (lv_domain_0_0= ruleArrow ) ) otherlv_1= '=>' ( (lv_codmain_2_0= ruleArrow ) ) ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1796:1: ( ( (lv_domain_0_0= ruleArrow ) ) otherlv_1= '=>' ( (lv_codmain_2_0= ruleArrow ) ) )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1796:1: ( ( (lv_domain_0_0= ruleArrow ) ) otherlv_1= '=>' ( (lv_codmain_2_0= ruleArrow ) ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1796:2: ( (lv_domain_0_0= ruleArrow ) ) otherlv_1= '=>' ( (lv_codmain_2_0= ruleArrow ) )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1796:2: ( (lv_domain_0_0= ruleArrow ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1797:1: (lv_domain_0_0= ruleArrow )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1797:1: (lv_domain_0_0= ruleArrow )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1798:3: lv_domain_0_0= ruleArrow
            {
             
            	        newCompositeNode(grammarAccess.getMappingArrowAccess().getDomainArrowParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleArrow_in_ruleMappingArrow3880);
            lv_domain_0_0=ruleArrow();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getMappingArrowRule());
            	        }
                   		set(
                   			current, 
                   			"domain",
                    		lv_domain_0_0, 
                    		"Arrow");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_1=(Token)match(input,33,FOLLOW_33_in_ruleMappingArrow3892); 

                	newLeafNode(otherlv_1, grammarAccess.getMappingArrowAccess().getEqualsSignGreaterThanSignKeyword_1());
                
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1818:1: ( (lv_codmain_2_0= ruleArrow ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1819:1: (lv_codmain_2_0= ruleArrow )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1819:1: (lv_codmain_2_0= ruleArrow )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1820:3: lv_codmain_2_0= ruleArrow
            {
             
            	        newCompositeNode(grammarAccess.getMappingArrowAccess().getCodmainArrowParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleArrow_in_ruleMappingArrow3913);
            lv_codmain_2_0=ruleArrow();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getMappingArrowRule());
            	        }
                   		set(
                   			current, 
                   			"codmain",
                    		lv_codmain_2_0, 
                    		"Arrow");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMappingArrow"


    // $ANTLR start "entryRuleExtSubTGraph"
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1844:1: entryRuleExtSubTGraph returns [EObject current=null] : iv_ruleExtSubTGraph= ruleExtSubTGraph EOF ;
    public final EObject entryRuleExtSubTGraph() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExtSubTGraph = null;


        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1845:2: (iv_ruleExtSubTGraph= ruleExtSubTGraph EOF )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1846:2: iv_ruleExtSubTGraph= ruleExtSubTGraph EOF
            {
             newCompositeNode(grammarAccess.getExtSubTGraphRule()); 
            pushFollow(FOLLOW_ruleExtSubTGraph_in_entryRuleExtSubTGraph3949);
            iv_ruleExtSubTGraph=ruleExtSubTGraph();

            state._fsp--;

             current =iv_ruleExtSubTGraph; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleExtSubTGraph3959); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExtSubTGraph"


    // $ANTLR start "ruleExtSubTGraph"
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1853:1: ruleExtSubTGraph returns [EObject current=null] : ( ( (lv_id_0_0= RULE_ID ) ) otherlv_1= ':=' otherlv_2= 'ExtSubTGraph<' ( (lv_extendsGraph_3_0= ruleTGraphExtSubName ) ) otherlv_4= '>' otherlv_5= '{' ( (lv_elements_6_0= ruleElement ) )* otherlv_7= '}' ) ;
    public final EObject ruleExtSubTGraph() throws RecognitionException {
        EObject current = null;

        Token lv_id_0_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        EObject lv_extendsGraph_3_0 = null;

        EObject lv_elements_6_0 = null;


         enterRule(); 
            
        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1856:28: ( ( ( (lv_id_0_0= RULE_ID ) ) otherlv_1= ':=' otherlv_2= 'ExtSubTGraph<' ( (lv_extendsGraph_3_0= ruleTGraphExtSubName ) ) otherlv_4= '>' otherlv_5= '{' ( (lv_elements_6_0= ruleElement ) )* otherlv_7= '}' ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1857:1: ( ( (lv_id_0_0= RULE_ID ) ) otherlv_1= ':=' otherlv_2= 'ExtSubTGraph<' ( (lv_extendsGraph_3_0= ruleTGraphExtSubName ) ) otherlv_4= '>' otherlv_5= '{' ( (lv_elements_6_0= ruleElement ) )* otherlv_7= '}' )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1857:1: ( ( (lv_id_0_0= RULE_ID ) ) otherlv_1= ':=' otherlv_2= 'ExtSubTGraph<' ( (lv_extendsGraph_3_0= ruleTGraphExtSubName ) ) otherlv_4= '>' otherlv_5= '{' ( (lv_elements_6_0= ruleElement ) )* otherlv_7= '}' )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1857:2: ( (lv_id_0_0= RULE_ID ) ) otherlv_1= ':=' otherlv_2= 'ExtSubTGraph<' ( (lv_extendsGraph_3_0= ruleTGraphExtSubName ) ) otherlv_4= '>' otherlv_5= '{' ( (lv_elements_6_0= ruleElement ) )* otherlv_7= '}'
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1857:2: ( (lv_id_0_0= RULE_ID ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1858:1: (lv_id_0_0= RULE_ID )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1858:1: (lv_id_0_0= RULE_ID )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1859:3: lv_id_0_0= RULE_ID
            {
            lv_id_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleExtSubTGraph4001); 

            			newLeafNode(lv_id_0_0, grammarAccess.getExtSubTGraphAccess().getIdIDTerminalRuleCall_0_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getExtSubTGraphRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"id",
                    		lv_id_0_0, 
                    		"ID");
            	    

            }


            }

            otherlv_1=(Token)match(input,24,FOLLOW_24_in_ruleExtSubTGraph4018); 

                	newLeafNode(otherlv_1, grammarAccess.getExtSubTGraphAccess().getColonEqualsSignKeyword_1());
                
            otherlv_2=(Token)match(input,34,FOLLOW_34_in_ruleExtSubTGraph4030); 

                	newLeafNode(otherlv_2, grammarAccess.getExtSubTGraphAccess().getExtSubTGraphKeyword_2());
                
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1883:1: ( (lv_extendsGraph_3_0= ruleTGraphExtSubName ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1884:1: (lv_extendsGraph_3_0= ruleTGraphExtSubName )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1884:1: (lv_extendsGraph_3_0= ruleTGraphExtSubName )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1885:3: lv_extendsGraph_3_0= ruleTGraphExtSubName
            {
             
            	        newCompositeNode(grammarAccess.getExtSubTGraphAccess().getExtendsGraphTGraphExtSubNameParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_ruleTGraphExtSubName_in_ruleExtSubTGraph4051);
            lv_extendsGraph_3_0=ruleTGraphExtSubName();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getExtSubTGraphRule());
            	        }
                   		set(
                   			current, 
                   			"extendsGraph",
                    		lv_extendsGraph_3_0, 
                    		"TGraphExtSubName");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_4=(Token)match(input,26,FOLLOW_26_in_ruleExtSubTGraph4063); 

                	newLeafNode(otherlv_4, grammarAccess.getExtSubTGraphAccess().getGreaterThanSignKeyword_4());
                
            otherlv_5=(Token)match(input,27,FOLLOW_27_in_ruleExtSubTGraph4075); 

                	newLeafNode(otherlv_5, grammarAccess.getExtSubTGraphAccess().getLeftCurlyBracketKeyword_5());
                
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1909:1: ( (lv_elements_6_0= ruleElement ) )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==RULE_ID) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1910:1: (lv_elements_6_0= ruleElement )
            	    {
            	    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1910:1: (lv_elements_6_0= ruleElement )
            	    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1911:3: lv_elements_6_0= ruleElement
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getExtSubTGraphAccess().getElementsElementParserRuleCall_6_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleElement_in_ruleExtSubTGraph4096);
            	    lv_elements_6_0=ruleElement();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getExtSubTGraphRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"elements",
            	            		lv_elements_6_0, 
            	            		"Element");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);

            otherlv_7=(Token)match(input,28,FOLLOW_28_in_ruleExtSubTGraph4109); 

                	newLeafNode(otherlv_7, grammarAccess.getExtSubTGraphAccess().getRightCurlyBracketKeyword_7());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExtSubTGraph"


    // $ANTLR start "entryRuleTGraphExtSubName"
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1939:1: entryRuleTGraphExtSubName returns [EObject current=null] : iv_ruleTGraphExtSubName= ruleTGraphExtSubName EOF ;
    public final EObject entryRuleTGraphExtSubName() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTGraphExtSubName = null;


        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1940:2: (iv_ruleTGraphExtSubName= ruleTGraphExtSubName EOF )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1941:2: iv_ruleTGraphExtSubName= ruleTGraphExtSubName EOF
            {
             newCompositeNode(grammarAccess.getTGraphExtSubNameRule()); 
            pushFollow(FOLLOW_ruleTGraphExtSubName_in_entryRuleTGraphExtSubName4145);
            iv_ruleTGraphExtSubName=ruleTGraphExtSubName();

            state._fsp--;

             current =iv_ruleTGraphExtSubName; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTGraphExtSubName4155); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTGraphExtSubName"


    // $ANTLR start "ruleTGraphExtSubName"
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1948:1: ruleTGraphExtSubName returns [EObject current=null] : ( (lv_id_0_0= RULE_ID ) ) ;
    public final EObject ruleTGraphExtSubName() throws RecognitionException {
        EObject current = null;

        Token lv_id_0_0=null;

         enterRule(); 
            
        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1951:28: ( ( (lv_id_0_0= RULE_ID ) ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1952:1: ( (lv_id_0_0= RULE_ID ) )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1952:1: ( (lv_id_0_0= RULE_ID ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1953:1: (lv_id_0_0= RULE_ID )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1953:1: (lv_id_0_0= RULE_ID )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1954:3: lv_id_0_0= RULE_ID
            {
            lv_id_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTGraphExtSubName4196); 

            			newLeafNode(lv_id_0_0, grammarAccess.getTGraphExtSubNameAccess().getIdIDTerminalRuleCall_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getTGraphExtSubNameRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"id",
                    		lv_id_0_0, 
                    		"ID");
            	    

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTGraphExtSubName"


    // $ANTLR start "entryRuleTGraph"
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1978:1: entryRuleTGraph returns [EObject current=null] : iv_ruleTGraph= ruleTGraph EOF ;
    public final EObject entryRuleTGraph() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTGraph = null;


        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1979:2: (iv_ruleTGraph= ruleTGraph EOF )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1980:2: iv_ruleTGraph= ruleTGraph EOF
            {
             newCompositeNode(grammarAccess.getTGraphRule()); 
            pushFollow(FOLLOW_ruleTGraph_in_entryRuleTGraph4236);
            iv_ruleTGraph=ruleTGraph();

            state._fsp--;

             current =iv_ruleTGraph; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTGraph4246); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTGraph"


    // $ANTLR start "ruleTGraph"
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1987:1: ruleTGraph returns [EObject current=null] : ( ( (lv_id_0_0= RULE_ID ) ) otherlv_1= ':=' otherlv_2= 'TGraph<' ( (lv_typeGraph_3_0= ruleTGraphName ) ) otherlv_4= '>' otherlv_5= '{' ( (lv_elements_6_0= ruleElement ) )* otherlv_7= '}' ) ;
    public final EObject ruleTGraph() throws RecognitionException {
        EObject current = null;

        Token lv_id_0_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        EObject lv_typeGraph_3_0 = null;

        EObject lv_elements_6_0 = null;


         enterRule(); 
            
        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1990:28: ( ( ( (lv_id_0_0= RULE_ID ) ) otherlv_1= ':=' otherlv_2= 'TGraph<' ( (lv_typeGraph_3_0= ruleTGraphName ) ) otherlv_4= '>' otherlv_5= '{' ( (lv_elements_6_0= ruleElement ) )* otherlv_7= '}' ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1991:1: ( ( (lv_id_0_0= RULE_ID ) ) otherlv_1= ':=' otherlv_2= 'TGraph<' ( (lv_typeGraph_3_0= ruleTGraphName ) ) otherlv_4= '>' otherlv_5= '{' ( (lv_elements_6_0= ruleElement ) )* otherlv_7= '}' )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1991:1: ( ( (lv_id_0_0= RULE_ID ) ) otherlv_1= ':=' otherlv_2= 'TGraph<' ( (lv_typeGraph_3_0= ruleTGraphName ) ) otherlv_4= '>' otherlv_5= '{' ( (lv_elements_6_0= ruleElement ) )* otherlv_7= '}' )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1991:2: ( (lv_id_0_0= RULE_ID ) ) otherlv_1= ':=' otherlv_2= 'TGraph<' ( (lv_typeGraph_3_0= ruleTGraphName ) ) otherlv_4= '>' otherlv_5= '{' ( (lv_elements_6_0= ruleElement ) )* otherlv_7= '}'
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1991:2: ( (lv_id_0_0= RULE_ID ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1992:1: (lv_id_0_0= RULE_ID )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1992:1: (lv_id_0_0= RULE_ID )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1993:3: lv_id_0_0= RULE_ID
            {
            lv_id_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTGraph4288); 

            			newLeafNode(lv_id_0_0, grammarAccess.getTGraphAccess().getIdIDTerminalRuleCall_0_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getTGraphRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"id",
                    		lv_id_0_0, 
                    		"ID");
            	    

            }


            }

            otherlv_1=(Token)match(input,24,FOLLOW_24_in_ruleTGraph4305); 

                	newLeafNode(otherlv_1, grammarAccess.getTGraphAccess().getColonEqualsSignKeyword_1());
                
            otherlv_2=(Token)match(input,35,FOLLOW_35_in_ruleTGraph4317); 

                	newLeafNode(otherlv_2, grammarAccess.getTGraphAccess().getTGraphKeyword_2());
                
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2017:1: ( (lv_typeGraph_3_0= ruleTGraphName ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2018:1: (lv_typeGraph_3_0= ruleTGraphName )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2018:1: (lv_typeGraph_3_0= ruleTGraphName )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2019:3: lv_typeGraph_3_0= ruleTGraphName
            {
             
            	        newCompositeNode(grammarAccess.getTGraphAccess().getTypeGraphTGraphNameParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_ruleTGraphName_in_ruleTGraph4338);
            lv_typeGraph_3_0=ruleTGraphName();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getTGraphRule());
            	        }
                   		set(
                   			current, 
                   			"typeGraph",
                    		lv_typeGraph_3_0, 
                    		"TGraphName");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_4=(Token)match(input,26,FOLLOW_26_in_ruleTGraph4350); 

                	newLeafNode(otherlv_4, grammarAccess.getTGraphAccess().getGreaterThanSignKeyword_4());
                
            otherlv_5=(Token)match(input,27,FOLLOW_27_in_ruleTGraph4362); 

                	newLeafNode(otherlv_5, grammarAccess.getTGraphAccess().getLeftCurlyBracketKeyword_5());
                
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2043:1: ( (lv_elements_6_0= ruleElement ) )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==RULE_ID) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2044:1: (lv_elements_6_0= ruleElement )
            	    {
            	    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2044:1: (lv_elements_6_0= ruleElement )
            	    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2045:3: lv_elements_6_0= ruleElement
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getTGraphAccess().getElementsElementParserRuleCall_6_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleElement_in_ruleTGraph4383);
            	    lv_elements_6_0=ruleElement();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getTGraphRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"elements",
            	            		lv_elements_6_0, 
            	            		"Element");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);

            otherlv_7=(Token)match(input,28,FOLLOW_28_in_ruleTGraph4396); 

                	newLeafNode(otherlv_7, grammarAccess.getTGraphAccess().getRightCurlyBracketKeyword_7());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTGraph"


    // $ANTLR start "entryRuleTGraphName"
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2073:1: entryRuleTGraphName returns [EObject current=null] : iv_ruleTGraphName= ruleTGraphName EOF ;
    public final EObject entryRuleTGraphName() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTGraphName = null;


        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2074:2: (iv_ruleTGraphName= ruleTGraphName EOF )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2075:2: iv_ruleTGraphName= ruleTGraphName EOF
            {
             newCompositeNode(grammarAccess.getTGraphNameRule()); 
            pushFollow(FOLLOW_ruleTGraphName_in_entryRuleTGraphName4432);
            iv_ruleTGraphName=ruleTGraphName();

            state._fsp--;

             current =iv_ruleTGraphName; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTGraphName4442); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTGraphName"


    // $ANTLR start "ruleTGraphName"
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2082:1: ruleTGraphName returns [EObject current=null] : ( (lv_id_0_0= RULE_ID ) ) ;
    public final EObject ruleTGraphName() throws RecognitionException {
        EObject current = null;

        Token lv_id_0_0=null;

         enterRule(); 
            
        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2085:28: ( ( (lv_id_0_0= RULE_ID ) ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2086:1: ( (lv_id_0_0= RULE_ID ) )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2086:1: ( (lv_id_0_0= RULE_ID ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2087:1: (lv_id_0_0= RULE_ID )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2087:1: (lv_id_0_0= RULE_ID )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2088:3: lv_id_0_0= RULE_ID
            {
            lv_id_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTGraphName4483); 

            			newLeafNode(lv_id_0_0, grammarAccess.getTGraphNameAccess().getIdIDTerminalRuleCall_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getTGraphNameRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"id",
                    		lv_id_0_0, 
                    		"ID");
            	    

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTGraphName"


    // $ANTLR start "entryRuleElement"
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2112:1: entryRuleElement returns [EObject current=null] : iv_ruleElement= ruleElement EOF ;
    public final EObject entryRuleElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleElement = null;


        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2113:2: (iv_ruleElement= ruleElement EOF )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2114:2: iv_ruleElement= ruleElement EOF
            {
             newCompositeNode(grammarAccess.getElementRule()); 
            pushFollow(FOLLOW_ruleElement_in_entryRuleElement4523);
            iv_ruleElement=ruleElement();

            state._fsp--;

             current =iv_ruleElement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleElement4533); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleElement"


    // $ANTLR start "ruleElement"
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2121:1: ruleElement returns [EObject current=null] : ( (this_Node_0= ruleNode otherlv_1= ',' ) | (this_Arrows_2= ruleArrows otherlv_3= ',' ) ) ;
    public final EObject ruleElement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject this_Node_0 = null;

        EObject this_Arrows_2 = null;


         enterRule(); 
            
        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2124:28: ( ( (this_Node_0= ruleNode otherlv_1= ',' ) | (this_Arrows_2= ruleArrows otherlv_3= ',' ) ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2125:1: ( (this_Node_0= ruleNode otherlv_1= ',' ) | (this_Arrows_2= ruleArrows otherlv_3= ',' ) )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2125:1: ( (this_Node_0= ruleNode otherlv_1= ',' ) | (this_Arrows_2= ruleArrows otherlv_3= ',' ) )
            int alt17=2;
            alt17 = dfa17.predict(input);
            switch (alt17) {
                case 1 :
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2125:2: (this_Node_0= ruleNode otherlv_1= ',' )
                    {
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2125:2: (this_Node_0= ruleNode otherlv_1= ',' )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2126:5: this_Node_0= ruleNode otherlv_1= ','
                    {
                     
                            newCompositeNode(grammarAccess.getElementAccess().getNodeParserRuleCall_0_0()); 
                        
                    pushFollow(FOLLOW_ruleNode_in_ruleElement4581);
                    this_Node_0=ruleNode();

                    state._fsp--;

                     
                            current = this_Node_0; 
                            afterParserOrEnumRuleCall();
                        
                    otherlv_1=(Token)match(input,20,FOLLOW_20_in_ruleElement4592); 

                        	newLeafNode(otherlv_1, grammarAccess.getElementAccess().getCommaKeyword_0_1());
                        

                    }


                    }
                    break;
                case 2 :
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2139:6: (this_Arrows_2= ruleArrows otherlv_3= ',' )
                    {
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2139:6: (this_Arrows_2= ruleArrows otherlv_3= ',' )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2140:5: this_Arrows_2= ruleArrows otherlv_3= ','
                    {
                     
                            newCompositeNode(grammarAccess.getElementAccess().getArrowsParserRuleCall_1_0()); 
                        
                    pushFollow(FOLLOW_ruleArrows_in_ruleElement4622);
                    this_Arrows_2=ruleArrows();

                    state._fsp--;

                     
                            current = this_Arrows_2; 
                            afterParserOrEnumRuleCall();
                        
                    otherlv_3=(Token)match(input,20,FOLLOW_20_in_ruleElement4633); 

                        	newLeafNode(otherlv_3, grammarAccess.getElementAccess().getCommaKeyword_1_1());
                        

                    }


                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleElement"


    // $ANTLR start "entryRuleArrows"
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2160:1: entryRuleArrows returns [EObject current=null] : iv_ruleArrows= ruleArrows EOF ;
    public final EObject entryRuleArrows() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArrows = null;


        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2161:2: (iv_ruleArrows= ruleArrows EOF )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2162:2: iv_ruleArrows= ruleArrows EOF
            {
             newCompositeNode(grammarAccess.getArrowsRule()); 
            pushFollow(FOLLOW_ruleArrows_in_entryRuleArrows4670);
            iv_ruleArrows=ruleArrows();

            state._fsp--;

             current =iv_ruleArrows; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleArrows4680); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleArrows"


    // $ANTLR start "ruleArrows"
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2169:1: ruleArrows returns [EObject current=null] : ( ( ( (lv_sr_0_0= ruleNode ) ) otherlv_1= '-' ( (lv_id_2_0= ruleDpfId ) ) otherlv_3= ':' ( (lv_type_4_0= ruleDpfId ) ) otherlv_5= '->' ( (lv_next_6_0= ruleArrows ) ) ) | this_Arrow_7= ruleArrow ) ;
    public final EObject ruleArrows() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_sr_0_0 = null;

        EObject lv_id_2_0 = null;

        EObject lv_type_4_0 = null;

        EObject lv_next_6_0 = null;

        EObject this_Arrow_7 = null;


         enterRule(); 
            
        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2172:28: ( ( ( ( (lv_sr_0_0= ruleNode ) ) otherlv_1= '-' ( (lv_id_2_0= ruleDpfId ) ) otherlv_3= ':' ( (lv_type_4_0= ruleDpfId ) ) otherlv_5= '->' ( (lv_next_6_0= ruleArrows ) ) ) | this_Arrow_7= ruleArrow ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2173:1: ( ( ( (lv_sr_0_0= ruleNode ) ) otherlv_1= '-' ( (lv_id_2_0= ruleDpfId ) ) otherlv_3= ':' ( (lv_type_4_0= ruleDpfId ) ) otherlv_5= '->' ( (lv_next_6_0= ruleArrows ) ) ) | this_Arrow_7= ruleArrow )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2173:1: ( ( ( (lv_sr_0_0= ruleNode ) ) otherlv_1= '-' ( (lv_id_2_0= ruleDpfId ) ) otherlv_3= ':' ( (lv_type_4_0= ruleDpfId ) ) otherlv_5= '->' ( (lv_next_6_0= ruleArrows ) ) ) | this_Arrow_7= ruleArrow )
            int alt18=2;
            alt18 = dfa18.predict(input);
            switch (alt18) {
                case 1 :
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2173:2: ( ( (lv_sr_0_0= ruleNode ) ) otherlv_1= '-' ( (lv_id_2_0= ruleDpfId ) ) otherlv_3= ':' ( (lv_type_4_0= ruleDpfId ) ) otherlv_5= '->' ( (lv_next_6_0= ruleArrows ) ) )
                    {
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2173:2: ( ( (lv_sr_0_0= ruleNode ) ) otherlv_1= '-' ( (lv_id_2_0= ruleDpfId ) ) otherlv_3= ':' ( (lv_type_4_0= ruleDpfId ) ) otherlv_5= '->' ( (lv_next_6_0= ruleArrows ) ) )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2173:3: ( (lv_sr_0_0= ruleNode ) ) otherlv_1= '-' ( (lv_id_2_0= ruleDpfId ) ) otherlv_3= ':' ( (lv_type_4_0= ruleDpfId ) ) otherlv_5= '->' ( (lv_next_6_0= ruleArrows ) )
                    {
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2173:3: ( (lv_sr_0_0= ruleNode ) )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2174:1: (lv_sr_0_0= ruleNode )
                    {
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2174:1: (lv_sr_0_0= ruleNode )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2175:3: lv_sr_0_0= ruleNode
                    {
                     
                    	        newCompositeNode(grammarAccess.getArrowsAccess().getSrNodeParserRuleCall_0_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleNode_in_ruleArrows4727);
                    lv_sr_0_0=ruleNode();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getArrowsRule());
                    	        }
                           		set(
                           			current, 
                           			"sr",
                            		lv_sr_0_0, 
                            		"Node");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_1=(Token)match(input,36,FOLLOW_36_in_ruleArrows4739); 

                        	newLeafNode(otherlv_1, grammarAccess.getArrowsAccess().getHyphenMinusKeyword_0_1());
                        
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2195:1: ( (lv_id_2_0= ruleDpfId ) )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2196:1: (lv_id_2_0= ruleDpfId )
                    {
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2196:1: (lv_id_2_0= ruleDpfId )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2197:3: lv_id_2_0= ruleDpfId
                    {
                     
                    	        newCompositeNode(grammarAccess.getArrowsAccess().getIdDpfIdParserRuleCall_0_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDpfId_in_ruleArrows4760);
                    lv_id_2_0=ruleDpfId();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getArrowsRule());
                    	        }
                           		set(
                           			current, 
                           			"id",
                            		lv_id_2_0, 
                            		"DpfId");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_3=(Token)match(input,37,FOLLOW_37_in_ruleArrows4772); 

                        	newLeafNode(otherlv_3, grammarAccess.getArrowsAccess().getColonKeyword_0_3());
                        
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2217:1: ( (lv_type_4_0= ruleDpfId ) )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2218:1: (lv_type_4_0= ruleDpfId )
                    {
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2218:1: (lv_type_4_0= ruleDpfId )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2219:3: lv_type_4_0= ruleDpfId
                    {
                     
                    	        newCompositeNode(grammarAccess.getArrowsAccess().getTypeDpfIdParserRuleCall_0_4_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDpfId_in_ruleArrows4793);
                    lv_type_4_0=ruleDpfId();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getArrowsRule());
                    	        }
                           		set(
                           			current, 
                           			"type",
                            		lv_type_4_0, 
                            		"DpfId");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_5=(Token)match(input,19,FOLLOW_19_in_ruleArrows4805); 

                        	newLeafNode(otherlv_5, grammarAccess.getArrowsAccess().getHyphenMinusGreaterThanSignKeyword_0_5());
                        
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2239:1: ( (lv_next_6_0= ruleArrows ) )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2240:1: (lv_next_6_0= ruleArrows )
                    {
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2240:1: (lv_next_6_0= ruleArrows )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2241:3: lv_next_6_0= ruleArrows
                    {
                     
                    	        newCompositeNode(grammarAccess.getArrowsAccess().getNextArrowsParserRuleCall_0_6_0()); 
                    	    
                    pushFollow(FOLLOW_ruleArrows_in_ruleArrows4826);
                    lv_next_6_0=ruleArrows();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getArrowsRule());
                    	        }
                           		set(
                           			current, 
                           			"next",
                            		lv_next_6_0, 
                            		"Arrows");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2259:5: this_Arrow_7= ruleArrow
                    {
                     
                            newCompositeNode(grammarAccess.getArrowsAccess().getArrowParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleArrow_in_ruleArrows4855);
                    this_Arrow_7=ruleArrow();

                    state._fsp--;

                     
                            current = this_Arrow_7; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleArrows"


    // $ANTLR start "entryRuleArrow"
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2275:1: entryRuleArrow returns [EObject current=null] : iv_ruleArrow= ruleArrow EOF ;
    public final EObject entryRuleArrow() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArrow = null;


        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2276:2: (iv_ruleArrow= ruleArrow EOF )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2277:2: iv_ruleArrow= ruleArrow EOF
            {
             newCompositeNode(grammarAccess.getArrowRule()); 
            pushFollow(FOLLOW_ruleArrow_in_entryRuleArrow4890);
            iv_ruleArrow=ruleArrow();

            state._fsp--;

             current =iv_ruleArrow; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleArrow4900); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleArrow"


    // $ANTLR start "ruleArrow"
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2284:1: ruleArrow returns [EObject current=null] : ( ( ( (lv_sr_0_0= ruleNode ) ) otherlv_1= '-' ( (lv_id_2_0= ruleDpfId ) ) otherlv_3= ':' otherlv_4= '*' otherlv_5= '->' ( (lv_tgDataType_6_0= ruleDataType ) ) ) | ( ( (lv_sr_7_0= ruleNode ) ) otherlv_8= '-' ( (lv_id_9_0= ruleDpfId ) ) otherlv_10= ':' ( (lv_type_11_0= ruleDpfId ) ) otherlv_12= '->' ( (lv_tgValue_13_0= ruleAttributeValue ) ) ) | ( ( (lv_sr_14_0= ruleNode ) ) otherlv_15= '-' ( (lv_id_16_0= ruleDpfId ) ) otherlv_17= ':' ( (lv_type_18_0= ruleDpfId ) ) otherlv_19= '->' ( (lv_tgNode_20_0= ruleNode ) ) ) ) ;
    public final EObject ruleArrow() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Token otherlv_15=null;
        Token otherlv_17=null;
        Token otherlv_19=null;
        EObject lv_sr_0_0 = null;

        EObject lv_id_2_0 = null;

        Enumerator lv_tgDataType_6_0 = null;

        EObject lv_sr_7_0 = null;

        EObject lv_id_9_0 = null;

        EObject lv_type_11_0 = null;

        EObject lv_tgValue_13_0 = null;

        EObject lv_sr_14_0 = null;

        EObject lv_id_16_0 = null;

        EObject lv_type_18_0 = null;

        EObject lv_tgNode_20_0 = null;


         enterRule(); 
            
        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2287:28: ( ( ( ( (lv_sr_0_0= ruleNode ) ) otherlv_1= '-' ( (lv_id_2_0= ruleDpfId ) ) otherlv_3= ':' otherlv_4= '*' otherlv_5= '->' ( (lv_tgDataType_6_0= ruleDataType ) ) ) | ( ( (lv_sr_7_0= ruleNode ) ) otherlv_8= '-' ( (lv_id_9_0= ruleDpfId ) ) otherlv_10= ':' ( (lv_type_11_0= ruleDpfId ) ) otherlv_12= '->' ( (lv_tgValue_13_0= ruleAttributeValue ) ) ) | ( ( (lv_sr_14_0= ruleNode ) ) otherlv_15= '-' ( (lv_id_16_0= ruleDpfId ) ) otherlv_17= ':' ( (lv_type_18_0= ruleDpfId ) ) otherlv_19= '->' ( (lv_tgNode_20_0= ruleNode ) ) ) ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2288:1: ( ( ( (lv_sr_0_0= ruleNode ) ) otherlv_1= '-' ( (lv_id_2_0= ruleDpfId ) ) otherlv_3= ':' otherlv_4= '*' otherlv_5= '->' ( (lv_tgDataType_6_0= ruleDataType ) ) ) | ( ( (lv_sr_7_0= ruleNode ) ) otherlv_8= '-' ( (lv_id_9_0= ruleDpfId ) ) otherlv_10= ':' ( (lv_type_11_0= ruleDpfId ) ) otherlv_12= '->' ( (lv_tgValue_13_0= ruleAttributeValue ) ) ) | ( ( (lv_sr_14_0= ruleNode ) ) otherlv_15= '-' ( (lv_id_16_0= ruleDpfId ) ) otherlv_17= ':' ( (lv_type_18_0= ruleDpfId ) ) otherlv_19= '->' ( (lv_tgNode_20_0= ruleNode ) ) ) )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2288:1: ( ( ( (lv_sr_0_0= ruleNode ) ) otherlv_1= '-' ( (lv_id_2_0= ruleDpfId ) ) otherlv_3= ':' otherlv_4= '*' otherlv_5= '->' ( (lv_tgDataType_6_0= ruleDataType ) ) ) | ( ( (lv_sr_7_0= ruleNode ) ) otherlv_8= '-' ( (lv_id_9_0= ruleDpfId ) ) otherlv_10= ':' ( (lv_type_11_0= ruleDpfId ) ) otherlv_12= '->' ( (lv_tgValue_13_0= ruleAttributeValue ) ) ) | ( ( (lv_sr_14_0= ruleNode ) ) otherlv_15= '-' ( (lv_id_16_0= ruleDpfId ) ) otherlv_17= ':' ( (lv_type_18_0= ruleDpfId ) ) otherlv_19= '->' ( (lv_tgNode_20_0= ruleNode ) ) ) )
            int alt19=3;
            alt19 = dfa19.predict(input);
            switch (alt19) {
                case 1 :
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2288:2: ( ( (lv_sr_0_0= ruleNode ) ) otherlv_1= '-' ( (lv_id_2_0= ruleDpfId ) ) otherlv_3= ':' otherlv_4= '*' otherlv_5= '->' ( (lv_tgDataType_6_0= ruleDataType ) ) )
                    {
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2288:2: ( ( (lv_sr_0_0= ruleNode ) ) otherlv_1= '-' ( (lv_id_2_0= ruleDpfId ) ) otherlv_3= ':' otherlv_4= '*' otherlv_5= '->' ( (lv_tgDataType_6_0= ruleDataType ) ) )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2288:3: ( (lv_sr_0_0= ruleNode ) ) otherlv_1= '-' ( (lv_id_2_0= ruleDpfId ) ) otherlv_3= ':' otherlv_4= '*' otherlv_5= '->' ( (lv_tgDataType_6_0= ruleDataType ) )
                    {
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2288:3: ( (lv_sr_0_0= ruleNode ) )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2289:1: (lv_sr_0_0= ruleNode )
                    {
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2289:1: (lv_sr_0_0= ruleNode )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2290:3: lv_sr_0_0= ruleNode
                    {
                     
                    	        newCompositeNode(grammarAccess.getArrowAccess().getSrNodeParserRuleCall_0_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleNode_in_ruleArrow4947);
                    lv_sr_0_0=ruleNode();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getArrowRule());
                    	        }
                           		set(
                           			current, 
                           			"sr",
                            		lv_sr_0_0, 
                            		"Node");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_1=(Token)match(input,36,FOLLOW_36_in_ruleArrow4959); 

                        	newLeafNode(otherlv_1, grammarAccess.getArrowAccess().getHyphenMinusKeyword_0_1());
                        
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2310:1: ( (lv_id_2_0= ruleDpfId ) )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2311:1: (lv_id_2_0= ruleDpfId )
                    {
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2311:1: (lv_id_2_0= ruleDpfId )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2312:3: lv_id_2_0= ruleDpfId
                    {
                     
                    	        newCompositeNode(grammarAccess.getArrowAccess().getIdDpfIdParserRuleCall_0_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDpfId_in_ruleArrow4980);
                    lv_id_2_0=ruleDpfId();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getArrowRule());
                    	        }
                           		set(
                           			current, 
                           			"id",
                            		lv_id_2_0, 
                            		"DpfId");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_3=(Token)match(input,37,FOLLOW_37_in_ruleArrow4992); 

                        	newLeafNode(otherlv_3, grammarAccess.getArrowAccess().getColonKeyword_0_3());
                        
                    otherlv_4=(Token)match(input,38,FOLLOW_38_in_ruleArrow5004); 

                        	newLeafNode(otherlv_4, grammarAccess.getArrowAccess().getAsteriskKeyword_0_4());
                        
                    otherlv_5=(Token)match(input,19,FOLLOW_19_in_ruleArrow5016); 

                        	newLeafNode(otherlv_5, grammarAccess.getArrowAccess().getHyphenMinusGreaterThanSignKeyword_0_5());
                        
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2340:1: ( (lv_tgDataType_6_0= ruleDataType ) )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2341:1: (lv_tgDataType_6_0= ruleDataType )
                    {
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2341:1: (lv_tgDataType_6_0= ruleDataType )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2342:3: lv_tgDataType_6_0= ruleDataType
                    {
                     
                    	        newCompositeNode(grammarAccess.getArrowAccess().getTgDataTypeDataTypeEnumRuleCall_0_6_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDataType_in_ruleArrow5037);
                    lv_tgDataType_6_0=ruleDataType();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getArrowRule());
                    	        }
                           		set(
                           			current, 
                           			"tgDataType",
                            		lv_tgDataType_6_0, 
                            		"DataType");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2359:6: ( ( (lv_sr_7_0= ruleNode ) ) otherlv_8= '-' ( (lv_id_9_0= ruleDpfId ) ) otherlv_10= ':' ( (lv_type_11_0= ruleDpfId ) ) otherlv_12= '->' ( (lv_tgValue_13_0= ruleAttributeValue ) ) )
                    {
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2359:6: ( ( (lv_sr_7_0= ruleNode ) ) otherlv_8= '-' ( (lv_id_9_0= ruleDpfId ) ) otherlv_10= ':' ( (lv_type_11_0= ruleDpfId ) ) otherlv_12= '->' ( (lv_tgValue_13_0= ruleAttributeValue ) ) )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2359:7: ( (lv_sr_7_0= ruleNode ) ) otherlv_8= '-' ( (lv_id_9_0= ruleDpfId ) ) otherlv_10= ':' ( (lv_type_11_0= ruleDpfId ) ) otherlv_12= '->' ( (lv_tgValue_13_0= ruleAttributeValue ) )
                    {
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2359:7: ( (lv_sr_7_0= ruleNode ) )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2360:1: (lv_sr_7_0= ruleNode )
                    {
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2360:1: (lv_sr_7_0= ruleNode )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2361:3: lv_sr_7_0= ruleNode
                    {
                     
                    	        newCompositeNode(grammarAccess.getArrowAccess().getSrNodeParserRuleCall_1_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleNode_in_ruleArrow5066);
                    lv_sr_7_0=ruleNode();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getArrowRule());
                    	        }
                           		set(
                           			current, 
                           			"sr",
                            		lv_sr_7_0, 
                            		"Node");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_8=(Token)match(input,36,FOLLOW_36_in_ruleArrow5078); 

                        	newLeafNode(otherlv_8, grammarAccess.getArrowAccess().getHyphenMinusKeyword_1_1());
                        
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2381:1: ( (lv_id_9_0= ruleDpfId ) )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2382:1: (lv_id_9_0= ruleDpfId )
                    {
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2382:1: (lv_id_9_0= ruleDpfId )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2383:3: lv_id_9_0= ruleDpfId
                    {
                     
                    	        newCompositeNode(grammarAccess.getArrowAccess().getIdDpfIdParserRuleCall_1_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDpfId_in_ruleArrow5099);
                    lv_id_9_0=ruleDpfId();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getArrowRule());
                    	        }
                           		set(
                           			current, 
                           			"id",
                            		lv_id_9_0, 
                            		"DpfId");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_10=(Token)match(input,37,FOLLOW_37_in_ruleArrow5111); 

                        	newLeafNode(otherlv_10, grammarAccess.getArrowAccess().getColonKeyword_1_3());
                        
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2403:1: ( (lv_type_11_0= ruleDpfId ) )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2404:1: (lv_type_11_0= ruleDpfId )
                    {
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2404:1: (lv_type_11_0= ruleDpfId )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2405:3: lv_type_11_0= ruleDpfId
                    {
                     
                    	        newCompositeNode(grammarAccess.getArrowAccess().getTypeDpfIdParserRuleCall_1_4_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDpfId_in_ruleArrow5132);
                    lv_type_11_0=ruleDpfId();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getArrowRule());
                    	        }
                           		set(
                           			current, 
                           			"type",
                            		lv_type_11_0, 
                            		"DpfId");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_12=(Token)match(input,19,FOLLOW_19_in_ruleArrow5144); 

                        	newLeafNode(otherlv_12, grammarAccess.getArrowAccess().getHyphenMinusGreaterThanSignKeyword_1_5());
                        
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2425:1: ( (lv_tgValue_13_0= ruleAttributeValue ) )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2426:1: (lv_tgValue_13_0= ruleAttributeValue )
                    {
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2426:1: (lv_tgValue_13_0= ruleAttributeValue )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2427:3: lv_tgValue_13_0= ruleAttributeValue
                    {
                     
                    	        newCompositeNode(grammarAccess.getArrowAccess().getTgValueAttributeValueParserRuleCall_1_6_0()); 
                    	    
                    pushFollow(FOLLOW_ruleAttributeValue_in_ruleArrow5165);
                    lv_tgValue_13_0=ruleAttributeValue();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getArrowRule());
                    	        }
                           		set(
                           			current, 
                           			"tgValue",
                            		lv_tgValue_13_0, 
                            		"AttributeValue");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2444:6: ( ( (lv_sr_14_0= ruleNode ) ) otherlv_15= '-' ( (lv_id_16_0= ruleDpfId ) ) otherlv_17= ':' ( (lv_type_18_0= ruleDpfId ) ) otherlv_19= '->' ( (lv_tgNode_20_0= ruleNode ) ) )
                    {
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2444:6: ( ( (lv_sr_14_0= ruleNode ) ) otherlv_15= '-' ( (lv_id_16_0= ruleDpfId ) ) otherlv_17= ':' ( (lv_type_18_0= ruleDpfId ) ) otherlv_19= '->' ( (lv_tgNode_20_0= ruleNode ) ) )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2444:7: ( (lv_sr_14_0= ruleNode ) ) otherlv_15= '-' ( (lv_id_16_0= ruleDpfId ) ) otherlv_17= ':' ( (lv_type_18_0= ruleDpfId ) ) otherlv_19= '->' ( (lv_tgNode_20_0= ruleNode ) )
                    {
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2444:7: ( (lv_sr_14_0= ruleNode ) )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2445:1: (lv_sr_14_0= ruleNode )
                    {
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2445:1: (lv_sr_14_0= ruleNode )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2446:3: lv_sr_14_0= ruleNode
                    {
                     
                    	        newCompositeNode(grammarAccess.getArrowAccess().getSrNodeParserRuleCall_2_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleNode_in_ruleArrow5194);
                    lv_sr_14_0=ruleNode();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getArrowRule());
                    	        }
                           		set(
                           			current, 
                           			"sr",
                            		lv_sr_14_0, 
                            		"Node");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_15=(Token)match(input,36,FOLLOW_36_in_ruleArrow5206); 

                        	newLeafNode(otherlv_15, grammarAccess.getArrowAccess().getHyphenMinusKeyword_2_1());
                        
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2466:1: ( (lv_id_16_0= ruleDpfId ) )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2467:1: (lv_id_16_0= ruleDpfId )
                    {
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2467:1: (lv_id_16_0= ruleDpfId )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2468:3: lv_id_16_0= ruleDpfId
                    {
                     
                    	        newCompositeNode(grammarAccess.getArrowAccess().getIdDpfIdParserRuleCall_2_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDpfId_in_ruleArrow5227);
                    lv_id_16_0=ruleDpfId();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getArrowRule());
                    	        }
                           		set(
                           			current, 
                           			"id",
                            		lv_id_16_0, 
                            		"DpfId");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_17=(Token)match(input,37,FOLLOW_37_in_ruleArrow5239); 

                        	newLeafNode(otherlv_17, grammarAccess.getArrowAccess().getColonKeyword_2_3());
                        
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2488:1: ( (lv_type_18_0= ruleDpfId ) )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2489:1: (lv_type_18_0= ruleDpfId )
                    {
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2489:1: (lv_type_18_0= ruleDpfId )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2490:3: lv_type_18_0= ruleDpfId
                    {
                     
                    	        newCompositeNode(grammarAccess.getArrowAccess().getTypeDpfIdParserRuleCall_2_4_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDpfId_in_ruleArrow5260);
                    lv_type_18_0=ruleDpfId();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getArrowRule());
                    	        }
                           		set(
                           			current, 
                           			"type",
                            		lv_type_18_0, 
                            		"DpfId");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_19=(Token)match(input,19,FOLLOW_19_in_ruleArrow5272); 

                        	newLeafNode(otherlv_19, grammarAccess.getArrowAccess().getHyphenMinusGreaterThanSignKeyword_2_5());
                        
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2510:1: ( (lv_tgNode_20_0= ruleNode ) )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2511:1: (lv_tgNode_20_0= ruleNode )
                    {
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2511:1: (lv_tgNode_20_0= ruleNode )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2512:3: lv_tgNode_20_0= ruleNode
                    {
                     
                    	        newCompositeNode(grammarAccess.getArrowAccess().getTgNodeNodeParserRuleCall_2_6_0()); 
                    	    
                    pushFollow(FOLLOW_ruleNode_in_ruleArrow5293);
                    lv_tgNode_20_0=ruleNode();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getArrowRule());
                    	        }
                           		set(
                           			current, 
                           			"tgNode",
                            		lv_tgNode_20_0, 
                            		"Node");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }


                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleArrow"


    // $ANTLR start "entryRuleNode"
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2536:1: entryRuleNode returns [EObject current=null] : iv_ruleNode= ruleNode EOF ;
    public final EObject entryRuleNode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNode = null;


        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2537:2: (iv_ruleNode= ruleNode EOF )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2538:2: iv_ruleNode= ruleNode EOF
            {
             newCompositeNode(grammarAccess.getNodeRule()); 
            pushFollow(FOLLOW_ruleNode_in_entryRuleNode5330);
            iv_ruleNode=ruleNode();

            state._fsp--;

             current =iv_ruleNode; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNode5340); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNode"


    // $ANTLR start "ruleNode"
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2545:1: ruleNode returns [EObject current=null] : ( ( (lv_id_0_0= ruleDpfId ) ) otherlv_1= ':' ( (lv_type_2_0= ruleDpfId ) ) ) ;
    public final EObject ruleNode() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_id_0_0 = null;

        EObject lv_type_2_0 = null;


         enterRule(); 
            
        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2548:28: ( ( ( (lv_id_0_0= ruleDpfId ) ) otherlv_1= ':' ( (lv_type_2_0= ruleDpfId ) ) ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2549:1: ( ( (lv_id_0_0= ruleDpfId ) ) otherlv_1= ':' ( (lv_type_2_0= ruleDpfId ) ) )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2549:1: ( ( (lv_id_0_0= ruleDpfId ) ) otherlv_1= ':' ( (lv_type_2_0= ruleDpfId ) ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2549:2: ( (lv_id_0_0= ruleDpfId ) ) otherlv_1= ':' ( (lv_type_2_0= ruleDpfId ) )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2549:2: ( (lv_id_0_0= ruleDpfId ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2550:1: (lv_id_0_0= ruleDpfId )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2550:1: (lv_id_0_0= ruleDpfId )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2551:3: lv_id_0_0= ruleDpfId
            {
             
            	        newCompositeNode(grammarAccess.getNodeAccess().getIdDpfIdParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleDpfId_in_ruleNode5386);
            lv_id_0_0=ruleDpfId();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getNodeRule());
            	        }
                   		set(
                   			current, 
                   			"id",
                    		lv_id_0_0, 
                    		"DpfId");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_1=(Token)match(input,37,FOLLOW_37_in_ruleNode5398); 

                	newLeafNode(otherlv_1, grammarAccess.getNodeAccess().getColonKeyword_1());
                
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2571:1: ( (lv_type_2_0= ruleDpfId ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2572:1: (lv_type_2_0= ruleDpfId )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2572:1: (lv_type_2_0= ruleDpfId )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2573:3: lv_type_2_0= ruleDpfId
            {
             
            	        newCompositeNode(grammarAccess.getNodeAccess().getTypeDpfIdParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleDpfId_in_ruleNode5419);
            lv_type_2_0=ruleDpfId();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getNodeRule());
            	        }
                   		set(
                   			current, 
                   			"type",
                    		lv_type_2_0, 
                    		"DpfId");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNode"


    // $ANTLR start "entryRuleAttributeValue"
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2597:1: entryRuleAttributeValue returns [EObject current=null] : iv_ruleAttributeValue= ruleAttributeValue EOF ;
    public final EObject entryRuleAttributeValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttributeValue = null;


        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2598:2: (iv_ruleAttributeValue= ruleAttributeValue EOF )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2599:2: iv_ruleAttributeValue= ruleAttributeValue EOF
            {
             newCompositeNode(grammarAccess.getAttributeValueRule()); 
            pushFollow(FOLLOW_ruleAttributeValue_in_entryRuleAttributeValue5455);
            iv_ruleAttributeValue=ruleAttributeValue();

            state._fsp--;

             current =iv_ruleAttributeValue; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAttributeValue5465); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAttributeValue"


    // $ANTLR start "ruleAttributeValue"
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2606:1: ruleAttributeValue returns [EObject current=null] : (otherlv_0= '[' ( (lv_value_1_0= ruleVALUE ) ) otherlv_2= ']' ) ;
    public final EObject ruleAttributeValue() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        AntlrDatatypeRuleToken lv_value_1_0 = null;


         enterRule(); 
            
        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2609:28: ( (otherlv_0= '[' ( (lv_value_1_0= ruleVALUE ) ) otherlv_2= ']' ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2610:1: (otherlv_0= '[' ( (lv_value_1_0= ruleVALUE ) ) otherlv_2= ']' )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2610:1: (otherlv_0= '[' ( (lv_value_1_0= ruleVALUE ) ) otherlv_2= ']' )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2610:3: otherlv_0= '[' ( (lv_value_1_0= ruleVALUE ) ) otherlv_2= ']'
            {
            otherlv_0=(Token)match(input,39,FOLLOW_39_in_ruleAttributeValue5502); 

                	newLeafNode(otherlv_0, grammarAccess.getAttributeValueAccess().getLeftSquareBracketKeyword_0());
                
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2614:1: ( (lv_value_1_0= ruleVALUE ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2615:1: (lv_value_1_0= ruleVALUE )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2615:1: (lv_value_1_0= ruleVALUE )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2616:3: lv_value_1_0= ruleVALUE
            {
             
            	        newCompositeNode(grammarAccess.getAttributeValueAccess().getValueVALUEParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleVALUE_in_ruleAttributeValue5523);
            lv_value_1_0=ruleVALUE();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getAttributeValueRule());
            	        }
                   		set(
                   			current, 
                   			"value",
                    		lv_value_1_0, 
                    		"VALUE");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_2=(Token)match(input,40,FOLLOW_40_in_ruleAttributeValue5535); 

                	newLeafNode(otherlv_2, grammarAccess.getAttributeValueAccess().getRightSquareBracketKeyword_2());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAttributeValue"


    // $ANTLR start "entryRuleDpfId"
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2644:1: entryRuleDpfId returns [EObject current=null] : iv_ruleDpfId= ruleDpfId EOF ;
    public final EObject entryRuleDpfId() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDpfId = null;


        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2645:2: (iv_ruleDpfId= ruleDpfId EOF )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2646:2: iv_ruleDpfId= ruleDpfId EOF
            {
             newCompositeNode(grammarAccess.getDpfIdRule()); 
            pushFollow(FOLLOW_ruleDpfId_in_entryRuleDpfId5571);
            iv_ruleDpfId=ruleDpfId();

            state._fsp--;

             current =iv_ruleDpfId; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDpfId5581); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDpfId"


    // $ANTLR start "ruleDpfId"
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2653:1: ruleDpfId returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '@' ( (lv_id_2_0= RULE_INT ) ) )? ) ;
    public final EObject ruleDpfId() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token lv_id_2_0=null;

         enterRule(); 
            
        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2656:28: ( ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '@' ( (lv_id_2_0= RULE_INT ) ) )? ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2657:1: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '@' ( (lv_id_2_0= RULE_INT ) ) )? )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2657:1: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '@' ( (lv_id_2_0= RULE_INT ) ) )? )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2657:2: ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '@' ( (lv_id_2_0= RULE_INT ) ) )?
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2657:2: ( (lv_name_0_0= RULE_ID ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2658:1: (lv_name_0_0= RULE_ID )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2658:1: (lv_name_0_0= RULE_ID )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2659:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDpfId5623); 

            			newLeafNode(lv_name_0_0, grammarAccess.getDpfIdAccess().getNameIDTerminalRuleCall_0_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getDpfIdRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_0_0, 
                    		"ID");
            	    

            }


            }

            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2675:2: (otherlv_1= '@' ( (lv_id_2_0= RULE_INT ) ) )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==41) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2675:4: otherlv_1= '@' ( (lv_id_2_0= RULE_INT ) )
                    {
                    otherlv_1=(Token)match(input,41,FOLLOW_41_in_ruleDpfId5641); 

                        	newLeafNode(otherlv_1, grammarAccess.getDpfIdAccess().getCommercialAtKeyword_1_0());
                        
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2679:1: ( (lv_id_2_0= RULE_INT ) )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2680:1: (lv_id_2_0= RULE_INT )
                    {
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2680:1: (lv_id_2_0= RULE_INT )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2681:3: lv_id_2_0= RULE_INT
                    {
                    lv_id_2_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleDpfId5658); 

                    			newLeafNode(lv_id_2_0, grammarAccess.getDpfIdAccess().getIdINTTerminalRuleCall_1_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getDpfIdRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"id",
                            		lv_id_2_0, 
                            		"INT");
                    	    

                    }


                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDpfId"


    // $ANTLR start "ruleDataType"
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2705:1: ruleDataType returns [Enumerator current=null] : ( (enumLiteral_0= 'Boolean' ) | (enumLiteral_1= 'Char' ) | (enumLiteral_2= 'Byte' ) | (enumLiteral_3= 'Short' ) | (enumLiteral_4= 'Int' ) | (enumLiteral_5= 'Long' ) | (enumLiteral_6= 'Float' ) | (enumLiteral_7= 'Double' ) | (enumLiteral_8= 'String' ) ) ;
    public final Enumerator ruleDataType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;
        Token enumLiteral_5=null;
        Token enumLiteral_6=null;
        Token enumLiteral_7=null;
        Token enumLiteral_8=null;

         enterRule(); 
        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2707:28: ( ( (enumLiteral_0= 'Boolean' ) | (enumLiteral_1= 'Char' ) | (enumLiteral_2= 'Byte' ) | (enumLiteral_3= 'Short' ) | (enumLiteral_4= 'Int' ) | (enumLiteral_5= 'Long' ) | (enumLiteral_6= 'Float' ) | (enumLiteral_7= 'Double' ) | (enumLiteral_8= 'String' ) ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2708:1: ( (enumLiteral_0= 'Boolean' ) | (enumLiteral_1= 'Char' ) | (enumLiteral_2= 'Byte' ) | (enumLiteral_3= 'Short' ) | (enumLiteral_4= 'Int' ) | (enumLiteral_5= 'Long' ) | (enumLiteral_6= 'Float' ) | (enumLiteral_7= 'Double' ) | (enumLiteral_8= 'String' ) )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2708:1: ( (enumLiteral_0= 'Boolean' ) | (enumLiteral_1= 'Char' ) | (enumLiteral_2= 'Byte' ) | (enumLiteral_3= 'Short' ) | (enumLiteral_4= 'Int' ) | (enumLiteral_5= 'Long' ) | (enumLiteral_6= 'Float' ) | (enumLiteral_7= 'Double' ) | (enumLiteral_8= 'String' ) )
            int alt21=9;
            switch ( input.LA(1) ) {
            case 42:
                {
                alt21=1;
                }
                break;
            case 43:
                {
                alt21=2;
                }
                break;
            case 44:
                {
                alt21=3;
                }
                break;
            case 45:
                {
                alt21=4;
                }
                break;
            case 46:
                {
                alt21=5;
                }
                break;
            case 47:
                {
                alt21=6;
                }
                break;
            case 48:
                {
                alt21=7;
                }
                break;
            case 49:
                {
                alt21=8;
                }
                break;
            case 50:
                {
                alt21=9;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;
            }

            switch (alt21) {
                case 1 :
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2708:2: (enumLiteral_0= 'Boolean' )
                    {
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2708:2: (enumLiteral_0= 'Boolean' )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2708:4: enumLiteral_0= 'Boolean'
                    {
                    enumLiteral_0=(Token)match(input,42,FOLLOW_42_in_ruleDataType5715); 

                            current = grammarAccess.getDataTypeAccess().getTBOOLEANEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getDataTypeAccess().getTBOOLEANEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2714:6: (enumLiteral_1= 'Char' )
                    {
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2714:6: (enumLiteral_1= 'Char' )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2714:8: enumLiteral_1= 'Char'
                    {
                    enumLiteral_1=(Token)match(input,43,FOLLOW_43_in_ruleDataType5732); 

                            current = grammarAccess.getDataTypeAccess().getTCHAREnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getDataTypeAccess().getTCHAREnumLiteralDeclaration_1()); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2720:6: (enumLiteral_2= 'Byte' )
                    {
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2720:6: (enumLiteral_2= 'Byte' )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2720:8: enumLiteral_2= 'Byte'
                    {
                    enumLiteral_2=(Token)match(input,44,FOLLOW_44_in_ruleDataType5749); 

                            current = grammarAccess.getDataTypeAccess().getTBYTEEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_2, grammarAccess.getDataTypeAccess().getTBYTEEnumLiteralDeclaration_2()); 
                        

                    }


                    }
                    break;
                case 4 :
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2726:6: (enumLiteral_3= 'Short' )
                    {
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2726:6: (enumLiteral_3= 'Short' )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2726:8: enumLiteral_3= 'Short'
                    {
                    enumLiteral_3=(Token)match(input,45,FOLLOW_45_in_ruleDataType5766); 

                            current = grammarAccess.getDataTypeAccess().getTSHORTEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_3, grammarAccess.getDataTypeAccess().getTSHORTEnumLiteralDeclaration_3()); 
                        

                    }


                    }
                    break;
                case 5 :
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2732:6: (enumLiteral_4= 'Int' )
                    {
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2732:6: (enumLiteral_4= 'Int' )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2732:8: enumLiteral_4= 'Int'
                    {
                    enumLiteral_4=(Token)match(input,46,FOLLOW_46_in_ruleDataType5783); 

                            current = grammarAccess.getDataTypeAccess().getTINTEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_4, grammarAccess.getDataTypeAccess().getTINTEnumLiteralDeclaration_4()); 
                        

                    }


                    }
                    break;
                case 6 :
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2738:6: (enumLiteral_5= 'Long' )
                    {
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2738:6: (enumLiteral_5= 'Long' )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2738:8: enumLiteral_5= 'Long'
                    {
                    enumLiteral_5=(Token)match(input,47,FOLLOW_47_in_ruleDataType5800); 

                            current = grammarAccess.getDataTypeAccess().getTLONGEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_5, grammarAccess.getDataTypeAccess().getTLONGEnumLiteralDeclaration_5()); 
                        

                    }


                    }
                    break;
                case 7 :
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2744:6: (enumLiteral_6= 'Float' )
                    {
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2744:6: (enumLiteral_6= 'Float' )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2744:8: enumLiteral_6= 'Float'
                    {
                    enumLiteral_6=(Token)match(input,48,FOLLOW_48_in_ruleDataType5817); 

                            current = grammarAccess.getDataTypeAccess().getTFLOATEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_6, grammarAccess.getDataTypeAccess().getTFLOATEnumLiteralDeclaration_6()); 
                        

                    }


                    }
                    break;
                case 8 :
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2750:6: (enumLiteral_7= 'Double' )
                    {
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2750:6: (enumLiteral_7= 'Double' )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2750:8: enumLiteral_7= 'Double'
                    {
                    enumLiteral_7=(Token)match(input,49,FOLLOW_49_in_ruleDataType5834); 

                            current = grammarAccess.getDataTypeAccess().getTDOUBLEEnumLiteralDeclaration_7().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_7, grammarAccess.getDataTypeAccess().getTDOUBLEEnumLiteralDeclaration_7()); 
                        

                    }


                    }
                    break;
                case 9 :
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2756:6: (enumLiteral_8= 'String' )
                    {
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2756:6: (enumLiteral_8= 'String' )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2756:8: enumLiteral_8= 'String'
                    {
                    enumLiteral_8=(Token)match(input,50,FOLLOW_50_in_ruleDataType5851); 

                            current = grammarAccess.getDataTypeAccess().getTSTRINGEnumLiteralDeclaration_8().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_8, grammarAccess.getDataTypeAccess().getTSTRINGEnumLiteralDeclaration_8()); 
                        

                    }


                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDataType"

    // Delegated rules


    protected DFA4 dfa4 = new DFA4(this);
    protected DFA14 dfa14 = new DFA14(this);
    protected DFA17 dfa17 = new DFA17(this);
    protected DFA18 dfa18 = new DFA18(this);
    protected DFA19 dfa19 = new DFA19(this);
    static final String DFA4_eotS =
        "\23\uffff";
    static final String DFA4_eofS =
        "\23\uffff";
    static final String DFA4_minS =
        "\1\7\1\30\3\uffff\2\7\1\31\1\22\1\26\11\uffff";
    static final String DFA4_maxS =
        "\1\25\1\30\3\uffff\2\7\1\43\1\23\1\27\11\uffff";
    static final String DFA4_acceptS =
        "\2\uffff\1\5\1\6\1\7\5\uffff\1\4\1\12\1\2\1\1\1\3\1\10\1\11\1\13"+
        "\1\14";
    static final String DFA4_specialS =
        "\23\uffff}>";
    static final String[] DFA4_transitionS = {
            "\1\1\5\uffff\1\2\1\uffff\1\3\1\4\1\5\3\uffff\1\6",
            "\1\7",
            "",
            "",
            "",
            "\1\10",
            "\1\11",
            "\1\15\4\uffff\1\14\1\uffff\1\13\1\uffff\1\12\1\16",
            "\1\17\1\20",
            "\1\21\1\22",
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
            return "182:1: (this_InstanceSpecification_0= ruleInstanceSpecification | this_Specification_1= ruleSpecification | this_TGraph_2= ruleTGraph | this_ExtSubTGraph_3= ruleExtSubTGraph | this_MakeEmf_4= ruleMakeEmf | this_MakeEcore_5= ruleMakeEcore | this_MakeImage_6= ruleMakeImage | this_SimpleEvoSpan_7= ruleSimpleEvoSpan | this_SimpleEvoCospan_8= ruleSimpleEvoCospan | this_Morphism_9= ruleMorphism | this_EvoSpan_10= ruleEvoSpan | this_EvoCospan_11= ruleEvoCospan )";
        }
    }
    static final String DFA14_eotS =
        "\12\uffff";
    static final String DFA14_eofS =
        "\12\uffff";
    static final String DFA14_minS =
        "\1\7\1\45\1\10\1\7\1\45\1\41\1\10\2\uffff\1\41";
    static final String DFA14_maxS =
        "\1\7\1\51\1\10\1\7\1\45\1\51\1\10\2\uffff\1\44";
    static final String DFA14_acceptS =
        "\7\uffff\1\2\1\1\1\uffff";
    static final String DFA14_specialS =
        "\12\uffff}>";
    static final String[] DFA14_transitionS = {
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

    static final short[] DFA14_eot = DFA.unpackEncodedString(DFA14_eotS);
    static final short[] DFA14_eof = DFA.unpackEncodedString(DFA14_eofS);
    static final char[] DFA14_min = DFA.unpackEncodedStringToUnsignedChars(DFA14_minS);
    static final char[] DFA14_max = DFA.unpackEncodedStringToUnsignedChars(DFA14_maxS);
    static final short[] DFA14_accept = DFA.unpackEncodedString(DFA14_acceptS);
    static final short[] DFA14_special = DFA.unpackEncodedString(DFA14_specialS);
    static final short[][] DFA14_transition;

    static {
        int numStates = DFA14_transitionS.length;
        DFA14_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA14_transition[i] = DFA.unpackEncodedString(DFA14_transitionS[i]);
        }
    }

    class DFA14 extends DFA {

        public DFA14(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 14;
            this.eot = DFA14_eot;
            this.eof = DFA14_eof;
            this.min = DFA14_min;
            this.max = DFA14_max;
            this.accept = DFA14_accept;
            this.special = DFA14_special;
            this.transition = DFA14_transition;
        }
        public String getDescription() {
            return "1695:1: (this_MappingNode_0= ruleMappingNode | this_MappingArrow_1= ruleMappingArrow )";
        }
    }
    static final String DFA17_eotS =
        "\12\uffff";
    static final String DFA17_eofS =
        "\12\uffff";
    static final String DFA17_minS =
        "\1\7\1\45\1\10\1\7\1\45\1\24\1\10\2\uffff\1\24";
    static final String DFA17_maxS =
        "\1\7\1\51\1\10\1\7\1\45\1\51\1\10\2\uffff\1\44";
    static final String DFA17_acceptS =
        "\7\uffff\1\2\1\1\1\uffff";
    static final String DFA17_specialS =
        "\12\uffff}>";
    static final String[] DFA17_transitionS = {
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

    static final short[] DFA17_eot = DFA.unpackEncodedString(DFA17_eotS);
    static final short[] DFA17_eof = DFA.unpackEncodedString(DFA17_eofS);
    static final char[] DFA17_min = DFA.unpackEncodedStringToUnsignedChars(DFA17_minS);
    static final char[] DFA17_max = DFA.unpackEncodedStringToUnsignedChars(DFA17_maxS);
    static final short[] DFA17_accept = DFA.unpackEncodedString(DFA17_acceptS);
    static final short[] DFA17_special = DFA.unpackEncodedString(DFA17_specialS);
    static final short[][] DFA17_transition;

    static {
        int numStates = DFA17_transitionS.length;
        DFA17_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA17_transition[i] = DFA.unpackEncodedString(DFA17_transitionS[i]);
        }
    }

    class DFA17 extends DFA {

        public DFA17(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 17;
            this.eot = DFA17_eot;
            this.eof = DFA17_eof;
            this.min = DFA17_min;
            this.max = DFA17_max;
            this.accept = DFA17_accept;
            this.special = DFA17_special;
            this.transition = DFA17_transition;
        }
        public String getDescription() {
            return "2125:1: ( (this_Node_0= ruleNode otherlv_1= ',' ) | (this_Arrows_2= ruleArrows otherlv_3= ',' ) )";
        }
    }
    static final String DFA18_eotS =
        "\32\uffff";
    static final String DFA18_eofS =
        "\26\uffff\1\15\2\uffff\1\15";
    static final String DFA18_minS =
        "\1\7\1\45\1\10\1\7\1\45\1\44\1\10\1\7\1\44\1\45\1\10\1\7\1\45\1"+
        "\uffff\1\23\1\10\1\7\1\23\1\45\1\10\1\7\1\45\1\24\1\10\1\uffff\1"+
        "\24";
    static final String DFA18_maxS =
        "\1\7\1\51\1\10\1\7\1\45\1\51\1\10\1\7\1\44\1\51\1\10\1\46\1\45\1"+
        "\uffff\1\51\1\10\1\47\1\23\1\51\1\10\1\7\1\45\1\51\1\10\1\uffff"+
        "\1\44";
    static final String DFA18_acceptS =
        "\15\uffff\1\2\12\uffff\1\1\1\uffff";
    static final String DFA18_specialS =
        "\32\uffff}>";
    static final String[] DFA18_transitionS = {
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
            "\1\16\36\uffff\1\15",
            "\1\13",
            "",
            "\1\20\25\uffff\1\17",
            "\1\21",
            "\1\22\37\uffff\1\15",
            "\1\20",
            "\1\24\3\uffff\1\23",
            "\1\25",
            "\1\26",
            "\1\24",
            "\1\15\7\uffff\1\15\7\uffff\1\30\4\uffff\1\27",
            "\1\31",
            "",
            "\1\15\7\uffff\1\15\7\uffff\1\30"
    };

    static final short[] DFA18_eot = DFA.unpackEncodedString(DFA18_eotS);
    static final short[] DFA18_eof = DFA.unpackEncodedString(DFA18_eofS);
    static final char[] DFA18_min = DFA.unpackEncodedStringToUnsignedChars(DFA18_minS);
    static final char[] DFA18_max = DFA.unpackEncodedStringToUnsignedChars(DFA18_maxS);
    static final short[] DFA18_accept = DFA.unpackEncodedString(DFA18_acceptS);
    static final short[] DFA18_special = DFA.unpackEncodedString(DFA18_specialS);
    static final short[][] DFA18_transition;

    static {
        int numStates = DFA18_transitionS.length;
        DFA18_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA18_transition[i] = DFA.unpackEncodedString(DFA18_transitionS[i]);
        }
    }

    class DFA18 extends DFA {

        public DFA18(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 18;
            this.eot = DFA18_eot;
            this.eof = DFA18_eof;
            this.min = DFA18_min;
            this.max = DFA18_max;
            this.accept = DFA18_accept;
            this.special = DFA18_special;
            this.transition = DFA18_transition;
        }
        public String getDescription() {
            return "2173:1: ( ( ( (lv_sr_0_0= ruleNode ) ) otherlv_1= '-' ( (lv_id_2_0= ruleDpfId ) ) otherlv_3= ':' ( (lv_type_4_0= ruleDpfId ) ) otherlv_5= '->' ( (lv_next_6_0= ruleArrows ) ) ) | this_Arrow_7= ruleArrow )";
        }
    }
    static final String DFA19_eotS =
        "\24\uffff";
    static final String DFA19_eofS =
        "\24\uffff";
    static final String DFA19_minS =
        "\1\7\1\45\1\10\1\7\1\45\1\44\1\10\1\7\1\44\1\45\1\10\1\7\1\45\1"+
        "\23\1\uffff\1\10\1\7\1\23\2\uffff";
    static final String DFA19_maxS =
        "\1\7\1\51\1\10\1\7\1\45\1\51\1\10\1\7\1\44\1\51\1\10\1\46\1\45\1"+
        "\51\1\uffff\1\10\1\47\1\23\2\uffff";
    static final String DFA19_acceptS =
        "\16\uffff\1\1\3\uffff\1\3\1\2";
    static final String DFA19_specialS =
        "\24\uffff}>";
    static final String[] DFA19_transitionS = {
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
            "\1\15\36\uffff\1\16",
            "\1\13",
            "\1\20\25\uffff\1\17",
            "",
            "\1\21",
            "\1\22\37\uffff\1\23",
            "\1\20",
            "",
            ""
    };

    static final short[] DFA19_eot = DFA.unpackEncodedString(DFA19_eotS);
    static final short[] DFA19_eof = DFA.unpackEncodedString(DFA19_eofS);
    static final char[] DFA19_min = DFA.unpackEncodedStringToUnsignedChars(DFA19_minS);
    static final char[] DFA19_max = DFA.unpackEncodedStringToUnsignedChars(DFA19_maxS);
    static final short[] DFA19_accept = DFA.unpackEncodedString(DFA19_acceptS);
    static final short[] DFA19_special = DFA.unpackEncodedString(DFA19_specialS);
    static final short[][] DFA19_transition;

    static {
        int numStates = DFA19_transitionS.length;
        DFA19_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA19_transition[i] = DFA.unpackEncodedString(DFA19_transitionS[i]);
        }
    }

    class DFA19 extends DFA {

        public DFA19(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 19;
            this.eot = DFA19_eot;
            this.eof = DFA19_eof;
            this.min = DFA19_min;
            this.max = DFA19_max;
            this.accept = DFA19_accept;
            this.special = DFA19_special;
            this.transition = DFA19_transition;
        }
        public String getDescription() {
            return "2288:1: ( ( ( (lv_sr_0_0= ruleNode ) ) otherlv_1= '-' ( (lv_id_2_0= ruleDpfId ) ) otherlv_3= ':' otherlv_4= '*' otherlv_5= '->' ( (lv_tgDataType_6_0= ruleDataType ) ) ) | ( ( (lv_sr_7_0= ruleNode ) ) otherlv_8= '-' ( (lv_id_9_0= ruleDpfId ) ) otherlv_10= ':' ( (lv_type_11_0= ruleDpfId ) ) otherlv_12= '->' ( (lv_tgValue_13_0= ruleAttributeValue ) ) ) | ( ( (lv_sr_14_0= ruleNode ) ) otherlv_15= '-' ( (lv_id_16_0= ruleDpfId ) ) otherlv_17= ':' ( (lv_type_18_0= ruleDpfId ) ) otherlv_19= '->' ( (lv_tgNode_20_0= ruleNode ) ) ) )";
        }
    }
 

    public static final BitSet FOLLOW_ruleModel_in_entryRuleModel75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModel85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDefinition_in_ruleModel131 = new BitSet(new long[]{0x000000000023A082L});
    public static final BitSet FOLLOW_ruleDefinition_in_ruleModel152 = new BitSet(new long[]{0x000000000023A082L});
    public static final BitSet FOLLOW_ruleVALUE_in_entryRuleVALUE191 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVALUE202 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NUMBER_in_ruleVALUE242 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_CHAR_in_ruleVALUE268 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleVALUE294 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDefinition_in_entryRuleDefinition339 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDefinition349 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInstanceSpecification_in_ruleDefinition396 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSpecification_in_ruleDefinition423 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTGraph_in_ruleDefinition450 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExtSubTGraph_in_ruleDefinition477 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMakeEmf_in_ruleDefinition504 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMakeEcore_in_ruleDefinition531 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMakeImage_in_ruleDefinition558 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSimpleEvoSpan_in_ruleDefinition585 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSimpleEvoCospan_in_ruleDefinition612 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMorphism_in_ruleDefinition639 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEvoSpan_in_ruleDefinition666 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEvoCospan_in_ruleDefinition693 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMakeEmf_in_entryRuleMakeEmf728 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMakeEmf738 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_ruleMakeEmf775 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleMakeEmf792 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleMakeEmf809 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMakeEcore_in_entryRuleMakeEcore845 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMakeEcore855 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleMakeEcore892 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleMakeEcore909 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleMakeEcore926 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMakeImage_in_entryRuleMakeImage962 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMakeImage972 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_ruleMakeImage1009 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleMakeImage1026 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleMakeImage1043 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSimpleEvoSpan_in_entryRuleSimpleEvoSpan1079 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSimpleEvoSpan1089 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_ruleSimpleEvoSpan1126 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSimpleEvoSpan1143 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleSimpleEvoSpan1160 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSimpleEvoSpan1177 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleSimpleEvoSpan1194 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSimpleEvoSpan1211 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleSimpleEvoSpan1228 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSimpleEvoSpan1245 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleSimpleEvoSpan1262 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSimpleEvoCospan_in_entryRuleSimpleEvoCospan1298 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSimpleEvoCospan1308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_ruleSimpleEvoCospan1345 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSimpleEvoCospan1362 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleSimpleEvoCospan1379 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSimpleEvoCospan1396 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleSimpleEvoCospan1413 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSimpleEvoCospan1430 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleSimpleEvoCospan1447 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSimpleEvoCospan1464 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleSimpleEvoCospan1481 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEvoSpan_in_entryRuleEvoSpan1517 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEvoSpan1527 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_ruleEvoSpan1564 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEvoSpan1581 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleEvoSpan1598 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEvoSpan1615 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleEvoSpan1632 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEvoSpan1649 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleEvoSpan1666 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEvoCospan_in_entryRuleEvoCospan1702 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEvoCospan1712 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_ruleEvoCospan1749 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEvoCospan1766 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ruleEvoCospan1783 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEvoCospan1800 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleEvoCospan1817 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEvoCospan1834 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleEvoCospan1851 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInstanceSpecification_in_entryRuleInstanceSpecification1887 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInstanceSpecification1897 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleInstanceSpecification1939 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleInstanceSpecification1956 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_ruleInstanceSpecification1968 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ruleChoosenSpecfication_in_ruleInstanceSpecification1989 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleInstanceSpecification2001 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ruleChoosenSpecfication_in_ruleInstanceSpecification2022 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_ruleInstanceSpecification2034 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_ruleInstanceSpecification2046 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ruleConstraintSemantic_in_ruleInstanceSpecification2068 = new BitSet(new long[]{0x0000000010100000L});
    public static final BitSet FOLLOW_20_in_ruleInstanceSpecification2081 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ruleConstraintSemantic_in_ruleInstanceSpecification2102 = new BitSet(new long[]{0x0000000010100000L});
    public static final BitSet FOLLOW_28_in_ruleInstanceSpecification2117 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleChoosenSpecfication_in_entryRuleChoosenSpecfication2153 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleChoosenSpecfication2163 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleChoosenSpecfication2204 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConstraintSemantic_in_entryRuleConstraintSemantic2244 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConstraintSemantic2254 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDpfId_in_ruleConstraintSemantic2300 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_ruleConstraintSemantic2312 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ruleArrows_in_ruleConstraintSemantic2334 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleConstraintSemantic2347 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ruleArrows_in_ruleConstraintSemantic2368 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleConstraintSemantic2383 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_ruleConstraintSemantic2395 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_ruleConstraintSemantic2407 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleConstraintSemantic2424 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSpecification_in_entryRuleSpecification2465 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSpecification2475 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSpecification2517 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleSpecification2534 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_ruleSpecification2546 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ruleChoosenGraph_in_ruleSpecification2567 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_ruleSpecification2579 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_ruleSpecification2591 = new BitSet(new long[]{0x0000000010000080L});
    public static final BitSet FOLLOW_ruleConstraint_in_ruleSpecification2613 = new BitSet(new long[]{0x0000000010100000L});
    public static final BitSet FOLLOW_20_in_ruleSpecification2626 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ruleConstraint_in_ruleSpecification2647 = new BitSet(new long[]{0x0000000010100000L});
    public static final BitSet FOLLOW_28_in_ruleSpecification2663 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleChoosenGraph_in_entryRuleChoosenGraph2699 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleChoosenGraph2709 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleChoosenGraph2750 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConstraint_in_entryRuleConstraint2790 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConstraint2800 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConstraintSignature_in_ruleConstraint2846 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_ruleConstraint2858 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ruleArrows_in_ruleConstraint2880 = new BitSet(new long[]{0x0000000010100000L});
    public static final BitSet FOLLOW_20_in_ruleConstraint2893 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ruleArrows_in_ruleConstraint2914 = new BitSet(new long[]{0x0000000010100000L});
    public static final BitSet FOLLOW_28_in_ruleConstraint2929 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConstraintSignature_in_entryRuleConstraintSignature2965 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConstraintSignature2975 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDpfId_in_ruleConstraintSignature3021 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_ruleConstraintSignature3033 = new BitSet(new long[]{0x0000000000004080L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleConstraintSignature3051 = new BitSet(new long[]{0x0000000000104000L});
    public static final BitSet FOLLOW_20_in_ruleConstraintSignature3069 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleConstraintSignature3086 = new BitSet(new long[]{0x0000000000104000L});
    public static final BitSet FOLLOW_14_in_ruleConstraintSignature3107 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMorphism_in_entryRuleMorphism3143 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMorphism3153 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleMorphism3189 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleMorphism3200 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_ruleMorphism3212 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ruleDomain_in_ruleMorphism3233 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleMorphism3245 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ruleCodomain_in_ruleMorphism3266 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_ruleMorphism3278 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_ruleMorphism3290 = new BitSet(new long[]{0x0000000010000080L});
    public static final BitSet FOLLOW_ruleMapping_in_ruleMorphism3312 = new BitSet(new long[]{0x0000000010100000L});
    public static final BitSet FOLLOW_20_in_ruleMorphism3325 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ruleMapping_in_ruleMorphism3346 = new BitSet(new long[]{0x0000000010100000L});
    public static final BitSet FOLLOW_28_in_ruleMorphism3362 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDomain_in_entryRuleDomain3398 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDomain3408 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDomain3449 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCodomain_in_entryRuleCodomain3489 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCodomain3499 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleCodomain3540 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMapping_in_entryRuleMapping3580 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMapping3590 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMappingNode_in_ruleMapping3637 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMappingArrow_in_ruleMapping3664 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMappingNode_in_entryRuleMappingNode3699 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMappingNode3709 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNode_in_ruleMappingNode3755 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_ruleMappingNode3767 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ruleNode_in_ruleMappingNode3788 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMappingArrow_in_entryRuleMappingArrow3824 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMappingArrow3834 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArrow_in_ruleMappingArrow3880 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_ruleMappingArrow3892 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ruleArrow_in_ruleMappingArrow3913 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExtSubTGraph_in_entryRuleExtSubTGraph3949 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExtSubTGraph3959 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleExtSubTGraph4001 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleExtSubTGraph4018 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_ruleExtSubTGraph4030 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ruleTGraphExtSubName_in_ruleExtSubTGraph4051 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_ruleExtSubTGraph4063 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_ruleExtSubTGraph4075 = new BitSet(new long[]{0x0000000010000080L});
    public static final BitSet FOLLOW_ruleElement_in_ruleExtSubTGraph4096 = new BitSet(new long[]{0x0000000010000080L});
    public static final BitSet FOLLOW_28_in_ruleExtSubTGraph4109 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTGraphExtSubName_in_entryRuleTGraphExtSubName4145 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTGraphExtSubName4155 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTGraphExtSubName4196 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTGraph_in_entryRuleTGraph4236 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTGraph4246 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTGraph4288 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleTGraph4305 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_ruleTGraph4317 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ruleTGraphName_in_ruleTGraph4338 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_ruleTGraph4350 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_ruleTGraph4362 = new BitSet(new long[]{0x0000000010000080L});
    public static final BitSet FOLLOW_ruleElement_in_ruleTGraph4383 = new BitSet(new long[]{0x0000000010000080L});
    public static final BitSet FOLLOW_28_in_ruleTGraph4396 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTGraphName_in_entryRuleTGraphName4432 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTGraphName4442 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTGraphName4483 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleElement_in_entryRuleElement4523 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleElement4533 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNode_in_ruleElement4581 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleElement4592 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArrows_in_ruleElement4622 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleElement4633 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArrows_in_entryRuleArrows4670 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleArrows4680 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNode_in_ruleArrows4727 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_ruleArrows4739 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ruleDpfId_in_ruleArrows4760 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_37_in_ruleArrows4772 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ruleDpfId_in_ruleArrows4793 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleArrows4805 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ruleArrows_in_ruleArrows4826 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArrow_in_ruleArrows4855 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArrow_in_entryRuleArrow4890 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleArrow4900 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNode_in_ruleArrow4947 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_ruleArrow4959 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ruleDpfId_in_ruleArrow4980 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_37_in_ruleArrow4992 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_38_in_ruleArrow5004 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleArrow5016 = new BitSet(new long[]{0x0007FC0000000000L});
    public static final BitSet FOLLOW_ruleDataType_in_ruleArrow5037 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNode_in_ruleArrow5066 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_ruleArrow5078 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ruleDpfId_in_ruleArrow5099 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_37_in_ruleArrow5111 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ruleDpfId_in_ruleArrow5132 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleArrow5144 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_ruleAttributeValue_in_ruleArrow5165 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNode_in_ruleArrow5194 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_ruleArrow5206 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ruleDpfId_in_ruleArrow5227 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_37_in_ruleArrow5239 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ruleDpfId_in_ruleArrow5260 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleArrow5272 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ruleNode_in_ruleArrow5293 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNode_in_entryRuleNode5330 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNode5340 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDpfId_in_ruleNode5386 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_37_in_ruleNode5398 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ruleDpfId_in_ruleNode5419 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAttributeValue_in_entryRuleAttributeValue5455 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAttributeValue5465 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_ruleAttributeValue5502 = new BitSet(new long[]{0x0000000000000070L});
    public static final BitSet FOLLOW_ruleVALUE_in_ruleAttributeValue5523 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_ruleAttributeValue5535 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDpfId_in_entryRuleDpfId5571 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDpfId5581 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDpfId5623 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_41_in_ruleDpfId5641 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleDpfId5658 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_ruleDataType5715 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_ruleDataType5732 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_ruleDataType5749 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_ruleDataType5766 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_ruleDataType5783 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_ruleDataType5800 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_ruleDataType5817 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_ruleDataType5834 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_ruleDataType5851 = new BitSet(new long[]{0x0000000000000002L});

}