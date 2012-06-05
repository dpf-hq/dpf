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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_NUMBER", "RULE_CHAR", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ANY_OTHER", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "'emf('", "')'", "'ecore('", "'image('", "'simpleEvolution('", "'<-'", "'->'", "','", "'evolution('", "'<->'", "'-><-'", "':='", "'ISpec'", "'<'", "'>'", "'{'", "'}'", "'='", "'Spec'", "'('", "'Morphism'", "'=>'", "'ExtSubTGraph'", "'TGraph'", "'-'", "':'", "'*'", "'['", "']'", "'@'", "'Boolean'", "'Char'", "'Byte'", "'Short'", "'Int'", "'Long'", "'Float'", "'Double'", "'String'"
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
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:867:1: ruleInstanceSpecification returns [EObject current=null] : ( ( (lv_id_0_0= RULE_ID ) ) otherlv_1= ':=' otherlv_2= 'ISpec' otherlv_3= '<' ( (lv_model_4_0= ruleChoosenSpecfication ) ) otherlv_5= ',' ( (lv_metamodel_6_0= ruleChoosenSpecfication ) ) otherlv_7= '>' otherlv_8= '{' ( ( (lv_constraintSemantics_9_0= ruleConstraintSemantic ) ) (otherlv_10= ',' ( (lv_constraintSemantics_11_0= ruleConstraintSemantic ) ) )* ) otherlv_12= '}' ) ;
    public final EObject ruleInstanceSpecification() throws RecognitionException {
        EObject current = null;

        Token lv_id_0_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        EObject lv_model_4_0 = null;

        EObject lv_metamodel_6_0 = null;

        EObject lv_constraintSemantics_9_0 = null;

        EObject lv_constraintSemantics_11_0 = null;


         enterRule(); 
            
        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:870:28: ( ( ( (lv_id_0_0= RULE_ID ) ) otherlv_1= ':=' otherlv_2= 'ISpec' otherlv_3= '<' ( (lv_model_4_0= ruleChoosenSpecfication ) ) otherlv_5= ',' ( (lv_metamodel_6_0= ruleChoosenSpecfication ) ) otherlv_7= '>' otherlv_8= '{' ( ( (lv_constraintSemantics_9_0= ruleConstraintSemantic ) ) (otherlv_10= ',' ( (lv_constraintSemantics_11_0= ruleConstraintSemantic ) ) )* ) otherlv_12= '}' ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:871:1: ( ( (lv_id_0_0= RULE_ID ) ) otherlv_1= ':=' otherlv_2= 'ISpec' otherlv_3= '<' ( (lv_model_4_0= ruleChoosenSpecfication ) ) otherlv_5= ',' ( (lv_metamodel_6_0= ruleChoosenSpecfication ) ) otherlv_7= '>' otherlv_8= '{' ( ( (lv_constraintSemantics_9_0= ruleConstraintSemantic ) ) (otherlv_10= ',' ( (lv_constraintSemantics_11_0= ruleConstraintSemantic ) ) )* ) otherlv_12= '}' )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:871:1: ( ( (lv_id_0_0= RULE_ID ) ) otherlv_1= ':=' otherlv_2= 'ISpec' otherlv_3= '<' ( (lv_model_4_0= ruleChoosenSpecfication ) ) otherlv_5= ',' ( (lv_metamodel_6_0= ruleChoosenSpecfication ) ) otherlv_7= '>' otherlv_8= '{' ( ( (lv_constraintSemantics_9_0= ruleConstraintSemantic ) ) (otherlv_10= ',' ( (lv_constraintSemantics_11_0= ruleConstraintSemantic ) ) )* ) otherlv_12= '}' )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:871:2: ( (lv_id_0_0= RULE_ID ) ) otherlv_1= ':=' otherlv_2= 'ISpec' otherlv_3= '<' ( (lv_model_4_0= ruleChoosenSpecfication ) ) otherlv_5= ',' ( (lv_metamodel_6_0= ruleChoosenSpecfication ) ) otherlv_7= '>' otherlv_8= '{' ( ( (lv_constraintSemantics_9_0= ruleConstraintSemantic ) ) (otherlv_10= ',' ( (lv_constraintSemantics_11_0= ruleConstraintSemantic ) ) )* ) otherlv_12= '}'
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
                
            otherlv_3=(Token)match(input,26,FOLLOW_26_in_ruleInstanceSpecification1980); 

                	newLeafNode(otherlv_3, grammarAccess.getInstanceSpecificationAccess().getLessThanSignKeyword_3());
                
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:901:1: ( (lv_model_4_0= ruleChoosenSpecfication ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:902:1: (lv_model_4_0= ruleChoosenSpecfication )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:902:1: (lv_model_4_0= ruleChoosenSpecfication )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:903:3: lv_model_4_0= ruleChoosenSpecfication
            {
             
            	        newCompositeNode(grammarAccess.getInstanceSpecificationAccess().getModelChoosenSpecficationParserRuleCall_4_0()); 
            	    
            pushFollow(FOLLOW_ruleChoosenSpecfication_in_ruleInstanceSpecification2001);
            lv_model_4_0=ruleChoosenSpecfication();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getInstanceSpecificationRule());
            	        }
                   		set(
                   			current, 
                   			"model",
                    		lv_model_4_0, 
                    		"ChoosenSpecfication");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_5=(Token)match(input,20,FOLLOW_20_in_ruleInstanceSpecification2013); 

                	newLeafNode(otherlv_5, grammarAccess.getInstanceSpecificationAccess().getCommaKeyword_5());
                
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:923:1: ( (lv_metamodel_6_0= ruleChoosenSpecfication ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:924:1: (lv_metamodel_6_0= ruleChoosenSpecfication )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:924:1: (lv_metamodel_6_0= ruleChoosenSpecfication )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:925:3: lv_metamodel_6_0= ruleChoosenSpecfication
            {
             
            	        newCompositeNode(grammarAccess.getInstanceSpecificationAccess().getMetamodelChoosenSpecficationParserRuleCall_6_0()); 
            	    
            pushFollow(FOLLOW_ruleChoosenSpecfication_in_ruleInstanceSpecification2034);
            lv_metamodel_6_0=ruleChoosenSpecfication();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getInstanceSpecificationRule());
            	        }
                   		set(
                   			current, 
                   			"metamodel",
                    		lv_metamodel_6_0, 
                    		"ChoosenSpecfication");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_7=(Token)match(input,27,FOLLOW_27_in_ruleInstanceSpecification2046); 

                	newLeafNode(otherlv_7, grammarAccess.getInstanceSpecificationAccess().getGreaterThanSignKeyword_7());
                
            otherlv_8=(Token)match(input,28,FOLLOW_28_in_ruleInstanceSpecification2058); 

                	newLeafNode(otherlv_8, grammarAccess.getInstanceSpecificationAccess().getLeftCurlyBracketKeyword_8());
                
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:949:1: ( ( (lv_constraintSemantics_9_0= ruleConstraintSemantic ) ) (otherlv_10= ',' ( (lv_constraintSemantics_11_0= ruleConstraintSemantic ) ) )* )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:949:2: ( (lv_constraintSemantics_9_0= ruleConstraintSemantic ) ) (otherlv_10= ',' ( (lv_constraintSemantics_11_0= ruleConstraintSemantic ) ) )*
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:949:2: ( (lv_constraintSemantics_9_0= ruleConstraintSemantic ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:950:1: (lv_constraintSemantics_9_0= ruleConstraintSemantic )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:950:1: (lv_constraintSemantics_9_0= ruleConstraintSemantic )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:951:3: lv_constraintSemantics_9_0= ruleConstraintSemantic
            {
             
            	        newCompositeNode(grammarAccess.getInstanceSpecificationAccess().getConstraintSemanticsConstraintSemanticParserRuleCall_9_0_0()); 
            	    
            pushFollow(FOLLOW_ruleConstraintSemantic_in_ruleInstanceSpecification2080);
            lv_constraintSemantics_9_0=ruleConstraintSemantic();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getInstanceSpecificationRule());
            	        }
                   		add(
                   			current, 
                   			"constraintSemantics",
                    		lv_constraintSemantics_9_0, 
                    		"ConstraintSemantic");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:967:2: (otherlv_10= ',' ( (lv_constraintSemantics_11_0= ruleConstraintSemantic ) ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==20) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:967:4: otherlv_10= ',' ( (lv_constraintSemantics_11_0= ruleConstraintSemantic ) )
            	    {
            	    otherlv_10=(Token)match(input,20,FOLLOW_20_in_ruleInstanceSpecification2093); 

            	        	newLeafNode(otherlv_10, grammarAccess.getInstanceSpecificationAccess().getCommaKeyword_9_1_0());
            	        
            	    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:971:1: ( (lv_constraintSemantics_11_0= ruleConstraintSemantic ) )
            	    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:972:1: (lv_constraintSemantics_11_0= ruleConstraintSemantic )
            	    {
            	    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:972:1: (lv_constraintSemantics_11_0= ruleConstraintSemantic )
            	    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:973:3: lv_constraintSemantics_11_0= ruleConstraintSemantic
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getInstanceSpecificationAccess().getConstraintSemanticsConstraintSemanticParserRuleCall_9_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleConstraintSemantic_in_ruleInstanceSpecification2114);
            	    lv_constraintSemantics_11_0=ruleConstraintSemantic();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getInstanceSpecificationRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"constraintSemantics",
            	            		lv_constraintSemantics_11_0, 
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

            otherlv_12=(Token)match(input,29,FOLLOW_29_in_ruleInstanceSpecification2129); 

                	newLeafNode(otherlv_12, grammarAccess.getInstanceSpecificationAccess().getRightCurlyBracketKeyword_10());
                

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
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1001:1: entryRuleChoosenSpecfication returns [EObject current=null] : iv_ruleChoosenSpecfication= ruleChoosenSpecfication EOF ;
    public final EObject entryRuleChoosenSpecfication() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleChoosenSpecfication = null;


        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1002:2: (iv_ruleChoosenSpecfication= ruleChoosenSpecfication EOF )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1003:2: iv_ruleChoosenSpecfication= ruleChoosenSpecfication EOF
            {
             newCompositeNode(grammarAccess.getChoosenSpecficationRule()); 
            pushFollow(FOLLOW_ruleChoosenSpecfication_in_entryRuleChoosenSpecfication2165);
            iv_ruleChoosenSpecfication=ruleChoosenSpecfication();

            state._fsp--;

             current =iv_ruleChoosenSpecfication; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleChoosenSpecfication2175); 

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
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1010:1: ruleChoosenSpecfication returns [EObject current=null] : ( (lv_id_0_0= RULE_ID ) ) ;
    public final EObject ruleChoosenSpecfication() throws RecognitionException {
        EObject current = null;

        Token lv_id_0_0=null;

         enterRule(); 
            
        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1013:28: ( ( (lv_id_0_0= RULE_ID ) ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1014:1: ( (lv_id_0_0= RULE_ID ) )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1014:1: ( (lv_id_0_0= RULE_ID ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1015:1: (lv_id_0_0= RULE_ID )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1015:1: (lv_id_0_0= RULE_ID )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1016:3: lv_id_0_0= RULE_ID
            {
            lv_id_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleChoosenSpecfication2216); 

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
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1040:1: entryRuleConstraintSemantic returns [EObject current=null] : iv_ruleConstraintSemantic= ruleConstraintSemantic EOF ;
    public final EObject entryRuleConstraintSemantic() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstraintSemantic = null;


        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1041:2: (iv_ruleConstraintSemantic= ruleConstraintSemantic EOF )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1042:2: iv_ruleConstraintSemantic= ruleConstraintSemantic EOF
            {
             newCompositeNode(grammarAccess.getConstraintSemanticRule()); 
            pushFollow(FOLLOW_ruleConstraintSemantic_in_entryRuleConstraintSemantic2256);
            iv_ruleConstraintSemantic=ruleConstraintSemantic();

            state._fsp--;

             current =iv_ruleConstraintSemantic; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleConstraintSemantic2266); 

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
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1049:1: ruleConstraintSemantic returns [EObject current=null] : ( ( (lv_id_0_0= ruleDpfId ) ) otherlv_1= '{' ( ( (lv_arrows_2_0= ruleArrows ) ) (otherlv_3= ',' ( (lv_arrows_4_0= ruleArrows ) ) )* ) otherlv_5= ',' otherlv_6= '}' otherlv_7= '=' ( (lv_ocl_8_0= RULE_STRING ) ) ) ;
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
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1052:28: ( ( ( (lv_id_0_0= ruleDpfId ) ) otherlv_1= '{' ( ( (lv_arrows_2_0= ruleArrows ) ) (otherlv_3= ',' ( (lv_arrows_4_0= ruleArrows ) ) )* ) otherlv_5= ',' otherlv_6= '}' otherlv_7= '=' ( (lv_ocl_8_0= RULE_STRING ) ) ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1053:1: ( ( (lv_id_0_0= ruleDpfId ) ) otherlv_1= '{' ( ( (lv_arrows_2_0= ruleArrows ) ) (otherlv_3= ',' ( (lv_arrows_4_0= ruleArrows ) ) )* ) otherlv_5= ',' otherlv_6= '}' otherlv_7= '=' ( (lv_ocl_8_0= RULE_STRING ) ) )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1053:1: ( ( (lv_id_0_0= ruleDpfId ) ) otherlv_1= '{' ( ( (lv_arrows_2_0= ruleArrows ) ) (otherlv_3= ',' ( (lv_arrows_4_0= ruleArrows ) ) )* ) otherlv_5= ',' otherlv_6= '}' otherlv_7= '=' ( (lv_ocl_8_0= RULE_STRING ) ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1053:2: ( (lv_id_0_0= ruleDpfId ) ) otherlv_1= '{' ( ( (lv_arrows_2_0= ruleArrows ) ) (otherlv_3= ',' ( (lv_arrows_4_0= ruleArrows ) ) )* ) otherlv_5= ',' otherlv_6= '}' otherlv_7= '=' ( (lv_ocl_8_0= RULE_STRING ) )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1053:2: ( (lv_id_0_0= ruleDpfId ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1054:1: (lv_id_0_0= ruleDpfId )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1054:1: (lv_id_0_0= ruleDpfId )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1055:3: lv_id_0_0= ruleDpfId
            {
             
            	        newCompositeNode(grammarAccess.getConstraintSemanticAccess().getIdDpfIdParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleDpfId_in_ruleConstraintSemantic2312);
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

            otherlv_1=(Token)match(input,28,FOLLOW_28_in_ruleConstraintSemantic2324); 

                	newLeafNode(otherlv_1, grammarAccess.getConstraintSemanticAccess().getLeftCurlyBracketKeyword_1());
                
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1075:1: ( ( (lv_arrows_2_0= ruleArrows ) ) (otherlv_3= ',' ( (lv_arrows_4_0= ruleArrows ) ) )* )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1075:2: ( (lv_arrows_2_0= ruleArrows ) ) (otherlv_3= ',' ( (lv_arrows_4_0= ruleArrows ) ) )*
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1075:2: ( (lv_arrows_2_0= ruleArrows ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1076:1: (lv_arrows_2_0= ruleArrows )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1076:1: (lv_arrows_2_0= ruleArrows )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1077:3: lv_arrows_2_0= ruleArrows
            {
             
            	        newCompositeNode(grammarAccess.getConstraintSemanticAccess().getArrowsArrowsParserRuleCall_2_0_0()); 
            	    
            pushFollow(FOLLOW_ruleArrows_in_ruleConstraintSemantic2346);
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

            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1093:2: (otherlv_3= ',' ( (lv_arrows_4_0= ruleArrows ) ) )*
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
            	    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1093:4: otherlv_3= ',' ( (lv_arrows_4_0= ruleArrows ) )
            	    {
            	    otherlv_3=(Token)match(input,20,FOLLOW_20_in_ruleConstraintSemantic2359); 

            	        	newLeafNode(otherlv_3, grammarAccess.getConstraintSemanticAccess().getCommaKeyword_2_1_0());
            	        
            	    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1097:1: ( (lv_arrows_4_0= ruleArrows ) )
            	    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1098:1: (lv_arrows_4_0= ruleArrows )
            	    {
            	    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1098:1: (lv_arrows_4_0= ruleArrows )
            	    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1099:3: lv_arrows_4_0= ruleArrows
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getConstraintSemanticAccess().getArrowsArrowsParserRuleCall_2_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleArrows_in_ruleConstraintSemantic2380);
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

            otherlv_5=(Token)match(input,20,FOLLOW_20_in_ruleConstraintSemantic2395); 

                	newLeafNode(otherlv_5, grammarAccess.getConstraintSemanticAccess().getCommaKeyword_3());
                
            otherlv_6=(Token)match(input,29,FOLLOW_29_in_ruleConstraintSemantic2407); 

                	newLeafNode(otherlv_6, grammarAccess.getConstraintSemanticAccess().getRightCurlyBracketKeyword_4());
                
            otherlv_7=(Token)match(input,30,FOLLOW_30_in_ruleConstraintSemantic2419); 

                	newLeafNode(otherlv_7, grammarAccess.getConstraintSemanticAccess().getEqualsSignKeyword_5());
                
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1127:1: ( (lv_ocl_8_0= RULE_STRING ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1128:1: (lv_ocl_8_0= RULE_STRING )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1128:1: (lv_ocl_8_0= RULE_STRING )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1129:3: lv_ocl_8_0= RULE_STRING
            {
            lv_ocl_8_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleConstraintSemantic2436); 

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
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1153:1: entryRuleSpecification returns [EObject current=null] : iv_ruleSpecification= ruleSpecification EOF ;
    public final EObject entryRuleSpecification() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSpecification = null;


        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1154:2: (iv_ruleSpecification= ruleSpecification EOF )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1155:2: iv_ruleSpecification= ruleSpecification EOF
            {
             newCompositeNode(grammarAccess.getSpecificationRule()); 
            pushFollow(FOLLOW_ruleSpecification_in_entryRuleSpecification2477);
            iv_ruleSpecification=ruleSpecification();

            state._fsp--;

             current =iv_ruleSpecification; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSpecification2487); 

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
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1162:1: ruleSpecification returns [EObject current=null] : ( ( (lv_id_0_0= RULE_ID ) ) otherlv_1= ':=' otherlv_2= 'Spec' otherlv_3= '<' ( (lv_graph_4_0= ruleChoosenGraph ) ) otherlv_5= '>' otherlv_6= '{' ( ( (lv_constraints_7_0= ruleConstraint ) ) (otherlv_8= ',' ( (lv_constraints_9_0= ruleConstraint ) ) )* )? otherlv_10= '}' ) ;
    public final EObject ruleSpecification() throws RecognitionException {
        EObject current = null;

        Token lv_id_0_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        EObject lv_graph_4_0 = null;

        EObject lv_constraints_7_0 = null;

        EObject lv_constraints_9_0 = null;


         enterRule(); 
            
        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1165:28: ( ( ( (lv_id_0_0= RULE_ID ) ) otherlv_1= ':=' otherlv_2= 'Spec' otherlv_3= '<' ( (lv_graph_4_0= ruleChoosenGraph ) ) otherlv_5= '>' otherlv_6= '{' ( ( (lv_constraints_7_0= ruleConstraint ) ) (otherlv_8= ',' ( (lv_constraints_9_0= ruleConstraint ) ) )* )? otherlv_10= '}' ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1166:1: ( ( (lv_id_0_0= RULE_ID ) ) otherlv_1= ':=' otherlv_2= 'Spec' otherlv_3= '<' ( (lv_graph_4_0= ruleChoosenGraph ) ) otherlv_5= '>' otherlv_6= '{' ( ( (lv_constraints_7_0= ruleConstraint ) ) (otherlv_8= ',' ( (lv_constraints_9_0= ruleConstraint ) ) )* )? otherlv_10= '}' )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1166:1: ( ( (lv_id_0_0= RULE_ID ) ) otherlv_1= ':=' otherlv_2= 'Spec' otherlv_3= '<' ( (lv_graph_4_0= ruleChoosenGraph ) ) otherlv_5= '>' otherlv_6= '{' ( ( (lv_constraints_7_0= ruleConstraint ) ) (otherlv_8= ',' ( (lv_constraints_9_0= ruleConstraint ) ) )* )? otherlv_10= '}' )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1166:2: ( (lv_id_0_0= RULE_ID ) ) otherlv_1= ':=' otherlv_2= 'Spec' otherlv_3= '<' ( (lv_graph_4_0= ruleChoosenGraph ) ) otherlv_5= '>' otherlv_6= '{' ( ( (lv_constraints_7_0= ruleConstraint ) ) (otherlv_8= ',' ( (lv_constraints_9_0= ruleConstraint ) ) )* )? otherlv_10= '}'
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1166:2: ( (lv_id_0_0= RULE_ID ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1167:1: (lv_id_0_0= RULE_ID )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1167:1: (lv_id_0_0= RULE_ID )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1168:3: lv_id_0_0= RULE_ID
            {
            lv_id_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSpecification2529); 

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

            otherlv_1=(Token)match(input,24,FOLLOW_24_in_ruleSpecification2546); 

                	newLeafNode(otherlv_1, grammarAccess.getSpecificationAccess().getColonEqualsSignKeyword_1());
                
            otherlv_2=(Token)match(input,31,FOLLOW_31_in_ruleSpecification2558); 

                	newLeafNode(otherlv_2, grammarAccess.getSpecificationAccess().getSpecKeyword_2());
                
            otherlv_3=(Token)match(input,26,FOLLOW_26_in_ruleSpecification2570); 

                	newLeafNode(otherlv_3, grammarAccess.getSpecificationAccess().getLessThanSignKeyword_3());
                
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1196:1: ( (lv_graph_4_0= ruleChoosenGraph ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1197:1: (lv_graph_4_0= ruleChoosenGraph )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1197:1: (lv_graph_4_0= ruleChoosenGraph )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1198:3: lv_graph_4_0= ruleChoosenGraph
            {
             
            	        newCompositeNode(grammarAccess.getSpecificationAccess().getGraphChoosenGraphParserRuleCall_4_0()); 
            	    
            pushFollow(FOLLOW_ruleChoosenGraph_in_ruleSpecification2591);
            lv_graph_4_0=ruleChoosenGraph();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getSpecificationRule());
            	        }
                   		set(
                   			current, 
                   			"graph",
                    		lv_graph_4_0, 
                    		"ChoosenGraph");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_5=(Token)match(input,27,FOLLOW_27_in_ruleSpecification2603); 

                	newLeafNode(otherlv_5, grammarAccess.getSpecificationAccess().getGreaterThanSignKeyword_5());
                
            otherlv_6=(Token)match(input,28,FOLLOW_28_in_ruleSpecification2615); 

                	newLeafNode(otherlv_6, grammarAccess.getSpecificationAccess().getLeftCurlyBracketKeyword_6());
                
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1222:1: ( ( (lv_constraints_7_0= ruleConstraint ) ) (otherlv_8= ',' ( (lv_constraints_9_0= ruleConstraint ) ) )* )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==RULE_ID) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1222:2: ( (lv_constraints_7_0= ruleConstraint ) ) (otherlv_8= ',' ( (lv_constraints_9_0= ruleConstraint ) ) )*
                    {
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1222:2: ( (lv_constraints_7_0= ruleConstraint ) )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1223:1: (lv_constraints_7_0= ruleConstraint )
                    {
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1223:1: (lv_constraints_7_0= ruleConstraint )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1224:3: lv_constraints_7_0= ruleConstraint
                    {
                     
                    	        newCompositeNode(grammarAccess.getSpecificationAccess().getConstraintsConstraintParserRuleCall_7_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleConstraint_in_ruleSpecification2637);
                    lv_constraints_7_0=ruleConstraint();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getSpecificationRule());
                    	        }
                           		add(
                           			current, 
                           			"constraints",
                            		lv_constraints_7_0, 
                            		"Constraint");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1240:2: (otherlv_8= ',' ( (lv_constraints_9_0= ruleConstraint ) ) )*
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( (LA7_0==20) ) {
                            alt7=1;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1240:4: otherlv_8= ',' ( (lv_constraints_9_0= ruleConstraint ) )
                    	    {
                    	    otherlv_8=(Token)match(input,20,FOLLOW_20_in_ruleSpecification2650); 

                    	        	newLeafNode(otherlv_8, grammarAccess.getSpecificationAccess().getCommaKeyword_7_1_0());
                    	        
                    	    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1244:1: ( (lv_constraints_9_0= ruleConstraint ) )
                    	    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1245:1: (lv_constraints_9_0= ruleConstraint )
                    	    {
                    	    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1245:1: (lv_constraints_9_0= ruleConstraint )
                    	    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1246:3: lv_constraints_9_0= ruleConstraint
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getSpecificationAccess().getConstraintsConstraintParserRuleCall_7_1_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleConstraint_in_ruleSpecification2671);
                    	    lv_constraints_9_0=ruleConstraint();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getSpecificationRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"constraints",
                    	            		lv_constraints_9_0, 
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

            otherlv_10=(Token)match(input,29,FOLLOW_29_in_ruleSpecification2687); 

                	newLeafNode(otherlv_10, grammarAccess.getSpecificationAccess().getRightCurlyBracketKeyword_8());
                

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
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1274:1: entryRuleChoosenGraph returns [EObject current=null] : iv_ruleChoosenGraph= ruleChoosenGraph EOF ;
    public final EObject entryRuleChoosenGraph() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleChoosenGraph = null;


        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1275:2: (iv_ruleChoosenGraph= ruleChoosenGraph EOF )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1276:2: iv_ruleChoosenGraph= ruleChoosenGraph EOF
            {
             newCompositeNode(grammarAccess.getChoosenGraphRule()); 
            pushFollow(FOLLOW_ruleChoosenGraph_in_entryRuleChoosenGraph2723);
            iv_ruleChoosenGraph=ruleChoosenGraph();

            state._fsp--;

             current =iv_ruleChoosenGraph; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleChoosenGraph2733); 

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
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1283:1: ruleChoosenGraph returns [EObject current=null] : ( (lv_id_0_0= RULE_ID ) ) ;
    public final EObject ruleChoosenGraph() throws RecognitionException {
        EObject current = null;

        Token lv_id_0_0=null;

         enterRule(); 
            
        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1286:28: ( ( (lv_id_0_0= RULE_ID ) ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1287:1: ( (lv_id_0_0= RULE_ID ) )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1287:1: ( (lv_id_0_0= RULE_ID ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1288:1: (lv_id_0_0= RULE_ID )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1288:1: (lv_id_0_0= RULE_ID )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1289:3: lv_id_0_0= RULE_ID
            {
            lv_id_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleChoosenGraph2774); 

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
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1313:1: entryRuleConstraint returns [EObject current=null] : iv_ruleConstraint= ruleConstraint EOF ;
    public final EObject entryRuleConstraint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstraint = null;


        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1314:2: (iv_ruleConstraint= ruleConstraint EOF )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1315:2: iv_ruleConstraint= ruleConstraint EOF
            {
             newCompositeNode(grammarAccess.getConstraintRule()); 
            pushFollow(FOLLOW_ruleConstraint_in_entryRuleConstraint2814);
            iv_ruleConstraint=ruleConstraint();

            state._fsp--;

             current =iv_ruleConstraint; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleConstraint2824); 

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
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1322:1: ruleConstraint returns [EObject current=null] : ( ( (lv_signature_0_0= ruleConstraintSignature ) ) otherlv_1= '{' ( ( (lv_arrows_2_0= ruleArrows ) ) (otherlv_3= ',' ( (lv_arrows_4_0= ruleArrows ) ) )* ) otherlv_5= '}' ) ;
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
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1325:28: ( ( ( (lv_signature_0_0= ruleConstraintSignature ) ) otherlv_1= '{' ( ( (lv_arrows_2_0= ruleArrows ) ) (otherlv_3= ',' ( (lv_arrows_4_0= ruleArrows ) ) )* ) otherlv_5= '}' ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1326:1: ( ( (lv_signature_0_0= ruleConstraintSignature ) ) otherlv_1= '{' ( ( (lv_arrows_2_0= ruleArrows ) ) (otherlv_3= ',' ( (lv_arrows_4_0= ruleArrows ) ) )* ) otherlv_5= '}' )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1326:1: ( ( (lv_signature_0_0= ruleConstraintSignature ) ) otherlv_1= '{' ( ( (lv_arrows_2_0= ruleArrows ) ) (otherlv_3= ',' ( (lv_arrows_4_0= ruleArrows ) ) )* ) otherlv_5= '}' )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1326:2: ( (lv_signature_0_0= ruleConstraintSignature ) ) otherlv_1= '{' ( ( (lv_arrows_2_0= ruleArrows ) ) (otherlv_3= ',' ( (lv_arrows_4_0= ruleArrows ) ) )* ) otherlv_5= '}'
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1326:2: ( (lv_signature_0_0= ruleConstraintSignature ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1327:1: (lv_signature_0_0= ruleConstraintSignature )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1327:1: (lv_signature_0_0= ruleConstraintSignature )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1328:3: lv_signature_0_0= ruleConstraintSignature
            {
             
            	        newCompositeNode(grammarAccess.getConstraintAccess().getSignatureConstraintSignatureParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleConstraintSignature_in_ruleConstraint2870);
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

            otherlv_1=(Token)match(input,28,FOLLOW_28_in_ruleConstraint2882); 

                	newLeafNode(otherlv_1, grammarAccess.getConstraintAccess().getLeftCurlyBracketKeyword_1());
                
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1348:1: ( ( (lv_arrows_2_0= ruleArrows ) ) (otherlv_3= ',' ( (lv_arrows_4_0= ruleArrows ) ) )* )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1348:2: ( (lv_arrows_2_0= ruleArrows ) ) (otherlv_3= ',' ( (lv_arrows_4_0= ruleArrows ) ) )*
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1348:2: ( (lv_arrows_2_0= ruleArrows ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1349:1: (lv_arrows_2_0= ruleArrows )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1349:1: (lv_arrows_2_0= ruleArrows )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1350:3: lv_arrows_2_0= ruleArrows
            {
             
            	        newCompositeNode(grammarAccess.getConstraintAccess().getArrowsArrowsParserRuleCall_2_0_0()); 
            	    
            pushFollow(FOLLOW_ruleArrows_in_ruleConstraint2904);
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

            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1366:2: (otherlv_3= ',' ( (lv_arrows_4_0= ruleArrows ) ) )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==20) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1366:4: otherlv_3= ',' ( (lv_arrows_4_0= ruleArrows ) )
            	    {
            	    otherlv_3=(Token)match(input,20,FOLLOW_20_in_ruleConstraint2917); 

            	        	newLeafNode(otherlv_3, grammarAccess.getConstraintAccess().getCommaKeyword_2_1_0());
            	        
            	    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1370:1: ( (lv_arrows_4_0= ruleArrows ) )
            	    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1371:1: (lv_arrows_4_0= ruleArrows )
            	    {
            	    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1371:1: (lv_arrows_4_0= ruleArrows )
            	    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1372:3: lv_arrows_4_0= ruleArrows
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getConstraintAccess().getArrowsArrowsParserRuleCall_2_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleArrows_in_ruleConstraint2938);
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

            otherlv_5=(Token)match(input,29,FOLLOW_29_in_ruleConstraint2953); 

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
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1400:1: entryRuleConstraintSignature returns [EObject current=null] : iv_ruleConstraintSignature= ruleConstraintSignature EOF ;
    public final EObject entryRuleConstraintSignature() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstraintSignature = null;


        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1401:2: (iv_ruleConstraintSignature= ruleConstraintSignature EOF )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1402:2: iv_ruleConstraintSignature= ruleConstraintSignature EOF
            {
             newCompositeNode(grammarAccess.getConstraintSignatureRule()); 
            pushFollow(FOLLOW_ruleConstraintSignature_in_entryRuleConstraintSignature2989);
            iv_ruleConstraintSignature=ruleConstraintSignature();

            state._fsp--;

             current =iv_ruleConstraintSignature; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleConstraintSignature2999); 

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
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1409:1: ruleConstraintSignature returns [EObject current=null] : ( ( (lv_id_0_0= ruleDpfId ) ) otherlv_1= '(' ( ( (lv_parameter_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_parameter_4_0= RULE_ID ) ) )* )? otherlv_5= ')' ) ;
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
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1412:28: ( ( ( (lv_id_0_0= ruleDpfId ) ) otherlv_1= '(' ( ( (lv_parameter_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_parameter_4_0= RULE_ID ) ) )* )? otherlv_5= ')' ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1413:1: ( ( (lv_id_0_0= ruleDpfId ) ) otherlv_1= '(' ( ( (lv_parameter_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_parameter_4_0= RULE_ID ) ) )* )? otherlv_5= ')' )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1413:1: ( ( (lv_id_0_0= ruleDpfId ) ) otherlv_1= '(' ( ( (lv_parameter_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_parameter_4_0= RULE_ID ) ) )* )? otherlv_5= ')' )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1413:2: ( (lv_id_0_0= ruleDpfId ) ) otherlv_1= '(' ( ( (lv_parameter_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_parameter_4_0= RULE_ID ) ) )* )? otherlv_5= ')'
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1413:2: ( (lv_id_0_0= ruleDpfId ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1414:1: (lv_id_0_0= ruleDpfId )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1414:1: (lv_id_0_0= ruleDpfId )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1415:3: lv_id_0_0= ruleDpfId
            {
             
            	        newCompositeNode(grammarAccess.getConstraintSignatureAccess().getIdDpfIdParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleDpfId_in_ruleConstraintSignature3045);
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

            otherlv_1=(Token)match(input,32,FOLLOW_32_in_ruleConstraintSignature3057); 

                	newLeafNode(otherlv_1, grammarAccess.getConstraintSignatureAccess().getLeftParenthesisKeyword_1());
                
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1435:1: ( ( (lv_parameter_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_parameter_4_0= RULE_ID ) ) )* )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==RULE_ID) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1435:2: ( (lv_parameter_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_parameter_4_0= RULE_ID ) ) )*
                    {
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1435:2: ( (lv_parameter_2_0= RULE_ID ) )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1436:1: (lv_parameter_2_0= RULE_ID )
                    {
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1436:1: (lv_parameter_2_0= RULE_ID )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1437:3: lv_parameter_2_0= RULE_ID
                    {
                    lv_parameter_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleConstraintSignature3075); 

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

                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1453:2: (otherlv_3= ',' ( (lv_parameter_4_0= RULE_ID ) ) )*
                    loop10:
                    do {
                        int alt10=2;
                        int LA10_0 = input.LA(1);

                        if ( (LA10_0==20) ) {
                            alt10=1;
                        }


                        switch (alt10) {
                    	case 1 :
                    	    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1453:4: otherlv_3= ',' ( (lv_parameter_4_0= RULE_ID ) )
                    	    {
                    	    otherlv_3=(Token)match(input,20,FOLLOW_20_in_ruleConstraintSignature3093); 

                    	        	newLeafNode(otherlv_3, grammarAccess.getConstraintSignatureAccess().getCommaKeyword_2_1_0());
                    	        
                    	    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1457:1: ( (lv_parameter_4_0= RULE_ID ) )
                    	    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1458:1: (lv_parameter_4_0= RULE_ID )
                    	    {
                    	    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1458:1: (lv_parameter_4_0= RULE_ID )
                    	    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1459:3: lv_parameter_4_0= RULE_ID
                    	    {
                    	    lv_parameter_4_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleConstraintSignature3110); 

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

            otherlv_5=(Token)match(input,14,FOLLOW_14_in_ruleConstraintSignature3131); 

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
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1487:1: entryRuleMorphism returns [EObject current=null] : iv_ruleMorphism= ruleMorphism EOF ;
    public final EObject entryRuleMorphism() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMorphism = null;


        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1488:2: (iv_ruleMorphism= ruleMorphism EOF )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1489:2: iv_ruleMorphism= ruleMorphism EOF
            {
             newCompositeNode(grammarAccess.getMorphismRule()); 
            pushFollow(FOLLOW_ruleMorphism_in_entryRuleMorphism3167);
            iv_ruleMorphism=ruleMorphism();

            state._fsp--;

             current =iv_ruleMorphism; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMorphism3177); 

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
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1496:1: ruleMorphism returns [EObject current=null] : (this_ID_0= RULE_ID otherlv_1= ':=' otherlv_2= 'Morphism' otherlv_3= '<' ( (lv_domain_4_0= ruleDomain ) ) otherlv_5= ',' ( (lv_codmain_6_0= ruleCodomain ) ) otherlv_7= '>' otherlv_8= '{' ( ( (lv_mappings_9_0= ruleMapping ) ) (otherlv_10= ',' ( (lv_mappings_11_0= ruleMapping ) ) )* )? otherlv_12= '}' ) ;
    public final EObject ruleMorphism() throws RecognitionException {
        EObject current = null;

        Token this_ID_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        EObject lv_domain_4_0 = null;

        EObject lv_codmain_6_0 = null;

        EObject lv_mappings_9_0 = null;

        EObject lv_mappings_11_0 = null;


         enterRule(); 
            
        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1499:28: ( (this_ID_0= RULE_ID otherlv_1= ':=' otherlv_2= 'Morphism' otherlv_3= '<' ( (lv_domain_4_0= ruleDomain ) ) otherlv_5= ',' ( (lv_codmain_6_0= ruleCodomain ) ) otherlv_7= '>' otherlv_8= '{' ( ( (lv_mappings_9_0= ruleMapping ) ) (otherlv_10= ',' ( (lv_mappings_11_0= ruleMapping ) ) )* )? otherlv_12= '}' ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1500:1: (this_ID_0= RULE_ID otherlv_1= ':=' otherlv_2= 'Morphism' otherlv_3= '<' ( (lv_domain_4_0= ruleDomain ) ) otherlv_5= ',' ( (lv_codmain_6_0= ruleCodomain ) ) otherlv_7= '>' otherlv_8= '{' ( ( (lv_mappings_9_0= ruleMapping ) ) (otherlv_10= ',' ( (lv_mappings_11_0= ruleMapping ) ) )* )? otherlv_12= '}' )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1500:1: (this_ID_0= RULE_ID otherlv_1= ':=' otherlv_2= 'Morphism' otherlv_3= '<' ( (lv_domain_4_0= ruleDomain ) ) otherlv_5= ',' ( (lv_codmain_6_0= ruleCodomain ) ) otherlv_7= '>' otherlv_8= '{' ( ( (lv_mappings_9_0= ruleMapping ) ) (otherlv_10= ',' ( (lv_mappings_11_0= ruleMapping ) ) )* )? otherlv_12= '}' )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1500:2: this_ID_0= RULE_ID otherlv_1= ':=' otherlv_2= 'Morphism' otherlv_3= '<' ( (lv_domain_4_0= ruleDomain ) ) otherlv_5= ',' ( (lv_codmain_6_0= ruleCodomain ) ) otherlv_7= '>' otherlv_8= '{' ( ( (lv_mappings_9_0= ruleMapping ) ) (otherlv_10= ',' ( (lv_mappings_11_0= ruleMapping ) ) )* )? otherlv_12= '}'
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleMorphism3213); 
             
                newLeafNode(this_ID_0, grammarAccess.getMorphismAccess().getIDTerminalRuleCall_0()); 
                
            otherlv_1=(Token)match(input,24,FOLLOW_24_in_ruleMorphism3224); 

                	newLeafNode(otherlv_1, grammarAccess.getMorphismAccess().getColonEqualsSignKeyword_1());
                
            otherlv_2=(Token)match(input,33,FOLLOW_33_in_ruleMorphism3236); 

                	newLeafNode(otherlv_2, grammarAccess.getMorphismAccess().getMorphismKeyword_2());
                
            otherlv_3=(Token)match(input,26,FOLLOW_26_in_ruleMorphism3248); 

                	newLeafNode(otherlv_3, grammarAccess.getMorphismAccess().getLessThanSignKeyword_3());
                
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1516:1: ( (lv_domain_4_0= ruleDomain ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1517:1: (lv_domain_4_0= ruleDomain )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1517:1: (lv_domain_4_0= ruleDomain )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1518:3: lv_domain_4_0= ruleDomain
            {
             
            	        newCompositeNode(grammarAccess.getMorphismAccess().getDomainDomainParserRuleCall_4_0()); 
            	    
            pushFollow(FOLLOW_ruleDomain_in_ruleMorphism3269);
            lv_domain_4_0=ruleDomain();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getMorphismRule());
            	        }
                   		set(
                   			current, 
                   			"domain",
                    		lv_domain_4_0, 
                    		"Domain");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_5=(Token)match(input,20,FOLLOW_20_in_ruleMorphism3281); 

                	newLeafNode(otherlv_5, grammarAccess.getMorphismAccess().getCommaKeyword_5());
                
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1538:1: ( (lv_codmain_6_0= ruleCodomain ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1539:1: (lv_codmain_6_0= ruleCodomain )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1539:1: (lv_codmain_6_0= ruleCodomain )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1540:3: lv_codmain_6_0= ruleCodomain
            {
             
            	        newCompositeNode(grammarAccess.getMorphismAccess().getCodmainCodomainParserRuleCall_6_0()); 
            	    
            pushFollow(FOLLOW_ruleCodomain_in_ruleMorphism3302);
            lv_codmain_6_0=ruleCodomain();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getMorphismRule());
            	        }
                   		set(
                   			current, 
                   			"codmain",
                    		lv_codmain_6_0, 
                    		"Codomain");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_7=(Token)match(input,27,FOLLOW_27_in_ruleMorphism3314); 

                	newLeafNode(otherlv_7, grammarAccess.getMorphismAccess().getGreaterThanSignKeyword_7());
                
            otherlv_8=(Token)match(input,28,FOLLOW_28_in_ruleMorphism3326); 

                	newLeafNode(otherlv_8, grammarAccess.getMorphismAccess().getLeftCurlyBracketKeyword_8());
                
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1564:1: ( ( (lv_mappings_9_0= ruleMapping ) ) (otherlv_10= ',' ( (lv_mappings_11_0= ruleMapping ) ) )* )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==RULE_ID) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1564:2: ( (lv_mappings_9_0= ruleMapping ) ) (otherlv_10= ',' ( (lv_mappings_11_0= ruleMapping ) ) )*
                    {
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1564:2: ( (lv_mappings_9_0= ruleMapping ) )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1565:1: (lv_mappings_9_0= ruleMapping )
                    {
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1565:1: (lv_mappings_9_0= ruleMapping )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1566:3: lv_mappings_9_0= ruleMapping
                    {
                     
                    	        newCompositeNode(grammarAccess.getMorphismAccess().getMappingsMappingParserRuleCall_9_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleMapping_in_ruleMorphism3348);
                    lv_mappings_9_0=ruleMapping();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getMorphismRule());
                    	        }
                           		add(
                           			current, 
                           			"mappings",
                            		lv_mappings_9_0, 
                            		"Mapping");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1582:2: (otherlv_10= ',' ( (lv_mappings_11_0= ruleMapping ) ) )*
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( (LA12_0==20) ) {
                            alt12=1;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1582:4: otherlv_10= ',' ( (lv_mappings_11_0= ruleMapping ) )
                    	    {
                    	    otherlv_10=(Token)match(input,20,FOLLOW_20_in_ruleMorphism3361); 

                    	        	newLeafNode(otherlv_10, grammarAccess.getMorphismAccess().getCommaKeyword_9_1_0());
                    	        
                    	    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1586:1: ( (lv_mappings_11_0= ruleMapping ) )
                    	    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1587:1: (lv_mappings_11_0= ruleMapping )
                    	    {
                    	    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1587:1: (lv_mappings_11_0= ruleMapping )
                    	    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1588:3: lv_mappings_11_0= ruleMapping
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getMorphismAccess().getMappingsMappingParserRuleCall_9_1_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleMapping_in_ruleMorphism3382);
                    	    lv_mappings_11_0=ruleMapping();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getMorphismRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"mappings",
                    	            		lv_mappings_11_0, 
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

            otherlv_12=(Token)match(input,29,FOLLOW_29_in_ruleMorphism3398); 

                	newLeafNode(otherlv_12, grammarAccess.getMorphismAccess().getRightCurlyBracketKeyword_10());
                

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
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1616:1: entryRuleDomain returns [EObject current=null] : iv_ruleDomain= ruleDomain EOF ;
    public final EObject entryRuleDomain() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDomain = null;


        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1617:2: (iv_ruleDomain= ruleDomain EOF )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1618:2: iv_ruleDomain= ruleDomain EOF
            {
             newCompositeNode(grammarAccess.getDomainRule()); 
            pushFollow(FOLLOW_ruleDomain_in_entryRuleDomain3434);
            iv_ruleDomain=ruleDomain();

            state._fsp--;

             current =iv_ruleDomain; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDomain3444); 

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
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1625:1: ruleDomain returns [EObject current=null] : ( (lv_id_0_0= RULE_ID ) ) ;
    public final EObject ruleDomain() throws RecognitionException {
        EObject current = null;

        Token lv_id_0_0=null;

         enterRule(); 
            
        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1628:28: ( ( (lv_id_0_0= RULE_ID ) ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1629:1: ( (lv_id_0_0= RULE_ID ) )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1629:1: ( (lv_id_0_0= RULE_ID ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1630:1: (lv_id_0_0= RULE_ID )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1630:1: (lv_id_0_0= RULE_ID )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1631:3: lv_id_0_0= RULE_ID
            {
            lv_id_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDomain3485); 

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
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1655:1: entryRuleCodomain returns [EObject current=null] : iv_ruleCodomain= ruleCodomain EOF ;
    public final EObject entryRuleCodomain() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCodomain = null;


        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1656:2: (iv_ruleCodomain= ruleCodomain EOF )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1657:2: iv_ruleCodomain= ruleCodomain EOF
            {
             newCompositeNode(grammarAccess.getCodomainRule()); 
            pushFollow(FOLLOW_ruleCodomain_in_entryRuleCodomain3525);
            iv_ruleCodomain=ruleCodomain();

            state._fsp--;

             current =iv_ruleCodomain; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCodomain3535); 

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
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1664:1: ruleCodomain returns [EObject current=null] : ( (lv_id_0_0= RULE_ID ) ) ;
    public final EObject ruleCodomain() throws RecognitionException {
        EObject current = null;

        Token lv_id_0_0=null;

         enterRule(); 
            
        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1667:28: ( ( (lv_id_0_0= RULE_ID ) ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1668:1: ( (lv_id_0_0= RULE_ID ) )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1668:1: ( (lv_id_0_0= RULE_ID ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1669:1: (lv_id_0_0= RULE_ID )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1669:1: (lv_id_0_0= RULE_ID )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1670:3: lv_id_0_0= RULE_ID
            {
            lv_id_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleCodomain3576); 

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
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1694:1: entryRuleMapping returns [EObject current=null] : iv_ruleMapping= ruleMapping EOF ;
    public final EObject entryRuleMapping() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMapping = null;


        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1695:2: (iv_ruleMapping= ruleMapping EOF )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1696:2: iv_ruleMapping= ruleMapping EOF
            {
             newCompositeNode(grammarAccess.getMappingRule()); 
            pushFollow(FOLLOW_ruleMapping_in_entryRuleMapping3616);
            iv_ruleMapping=ruleMapping();

            state._fsp--;

             current =iv_ruleMapping; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMapping3626); 

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
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1703:1: ruleMapping returns [EObject current=null] : (this_MappingNode_0= ruleMappingNode | this_MappingArrow_1= ruleMappingArrow ) ;
    public final EObject ruleMapping() throws RecognitionException {
        EObject current = null;

        EObject this_MappingNode_0 = null;

        EObject this_MappingArrow_1 = null;


         enterRule(); 
            
        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1706:28: ( (this_MappingNode_0= ruleMappingNode | this_MappingArrow_1= ruleMappingArrow ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1707:1: (this_MappingNode_0= ruleMappingNode | this_MappingArrow_1= ruleMappingArrow )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1707:1: (this_MappingNode_0= ruleMappingNode | this_MappingArrow_1= ruleMappingArrow )
            int alt14=2;
            alt14 = dfa14.predict(input);
            switch (alt14) {
                case 1 :
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1708:5: this_MappingNode_0= ruleMappingNode
                    {
                     
                            newCompositeNode(grammarAccess.getMappingAccess().getMappingNodeParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleMappingNode_in_ruleMapping3673);
                    this_MappingNode_0=ruleMappingNode();

                    state._fsp--;

                     
                            current = this_MappingNode_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1718:5: this_MappingArrow_1= ruleMappingArrow
                    {
                     
                            newCompositeNode(grammarAccess.getMappingAccess().getMappingArrowParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleMappingArrow_in_ruleMapping3700);
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
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1734:1: entryRuleMappingNode returns [EObject current=null] : iv_ruleMappingNode= ruleMappingNode EOF ;
    public final EObject entryRuleMappingNode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMappingNode = null;


        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1735:2: (iv_ruleMappingNode= ruleMappingNode EOF )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1736:2: iv_ruleMappingNode= ruleMappingNode EOF
            {
             newCompositeNode(grammarAccess.getMappingNodeRule()); 
            pushFollow(FOLLOW_ruleMappingNode_in_entryRuleMappingNode3735);
            iv_ruleMappingNode=ruleMappingNode();

            state._fsp--;

             current =iv_ruleMappingNode; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMappingNode3745); 

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
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1743:1: ruleMappingNode returns [EObject current=null] : ( ( (lv_domain_0_0= ruleNode ) ) otherlv_1= '=>' ( (lv_codomain_2_0= ruleNode ) ) ) ;
    public final EObject ruleMappingNode() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_domain_0_0 = null;

        EObject lv_codomain_2_0 = null;


         enterRule(); 
            
        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1746:28: ( ( ( (lv_domain_0_0= ruleNode ) ) otherlv_1= '=>' ( (lv_codomain_2_0= ruleNode ) ) ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1747:1: ( ( (lv_domain_0_0= ruleNode ) ) otherlv_1= '=>' ( (lv_codomain_2_0= ruleNode ) ) )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1747:1: ( ( (lv_domain_0_0= ruleNode ) ) otherlv_1= '=>' ( (lv_codomain_2_0= ruleNode ) ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1747:2: ( (lv_domain_0_0= ruleNode ) ) otherlv_1= '=>' ( (lv_codomain_2_0= ruleNode ) )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1747:2: ( (lv_domain_0_0= ruleNode ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1748:1: (lv_domain_0_0= ruleNode )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1748:1: (lv_domain_0_0= ruleNode )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1749:3: lv_domain_0_0= ruleNode
            {
             
            	        newCompositeNode(grammarAccess.getMappingNodeAccess().getDomainNodeParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleNode_in_ruleMappingNode3791);
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

            otherlv_1=(Token)match(input,34,FOLLOW_34_in_ruleMappingNode3803); 

                	newLeafNode(otherlv_1, grammarAccess.getMappingNodeAccess().getEqualsSignGreaterThanSignKeyword_1());
                
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1769:1: ( (lv_codomain_2_0= ruleNode ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1770:1: (lv_codomain_2_0= ruleNode )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1770:1: (lv_codomain_2_0= ruleNode )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1771:3: lv_codomain_2_0= ruleNode
            {
             
            	        newCompositeNode(grammarAccess.getMappingNodeAccess().getCodomainNodeParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleNode_in_ruleMappingNode3824);
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
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1795:1: entryRuleMappingArrow returns [EObject current=null] : iv_ruleMappingArrow= ruleMappingArrow EOF ;
    public final EObject entryRuleMappingArrow() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMappingArrow = null;


        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1796:2: (iv_ruleMappingArrow= ruleMappingArrow EOF )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1797:2: iv_ruleMappingArrow= ruleMappingArrow EOF
            {
             newCompositeNode(grammarAccess.getMappingArrowRule()); 
            pushFollow(FOLLOW_ruleMappingArrow_in_entryRuleMappingArrow3860);
            iv_ruleMappingArrow=ruleMappingArrow();

            state._fsp--;

             current =iv_ruleMappingArrow; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMappingArrow3870); 

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
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1804:1: ruleMappingArrow returns [EObject current=null] : ( ( (lv_domain_0_0= ruleArrow ) ) otherlv_1= '=>' ( (lv_codmain_2_0= ruleArrow ) ) ) ;
    public final EObject ruleMappingArrow() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_domain_0_0 = null;

        EObject lv_codmain_2_0 = null;


         enterRule(); 
            
        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1807:28: ( ( ( (lv_domain_0_0= ruleArrow ) ) otherlv_1= '=>' ( (lv_codmain_2_0= ruleArrow ) ) ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1808:1: ( ( (lv_domain_0_0= ruleArrow ) ) otherlv_1= '=>' ( (lv_codmain_2_0= ruleArrow ) ) )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1808:1: ( ( (lv_domain_0_0= ruleArrow ) ) otherlv_1= '=>' ( (lv_codmain_2_0= ruleArrow ) ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1808:2: ( (lv_domain_0_0= ruleArrow ) ) otherlv_1= '=>' ( (lv_codmain_2_0= ruleArrow ) )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1808:2: ( (lv_domain_0_0= ruleArrow ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1809:1: (lv_domain_0_0= ruleArrow )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1809:1: (lv_domain_0_0= ruleArrow )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1810:3: lv_domain_0_0= ruleArrow
            {
             
            	        newCompositeNode(grammarAccess.getMappingArrowAccess().getDomainArrowParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleArrow_in_ruleMappingArrow3916);
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

            otherlv_1=(Token)match(input,34,FOLLOW_34_in_ruleMappingArrow3928); 

                	newLeafNode(otherlv_1, grammarAccess.getMappingArrowAccess().getEqualsSignGreaterThanSignKeyword_1());
                
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1830:1: ( (lv_codmain_2_0= ruleArrow ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1831:1: (lv_codmain_2_0= ruleArrow )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1831:1: (lv_codmain_2_0= ruleArrow )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1832:3: lv_codmain_2_0= ruleArrow
            {
             
            	        newCompositeNode(grammarAccess.getMappingArrowAccess().getCodmainArrowParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleArrow_in_ruleMappingArrow3949);
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
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1856:1: entryRuleExtSubTGraph returns [EObject current=null] : iv_ruleExtSubTGraph= ruleExtSubTGraph EOF ;
    public final EObject entryRuleExtSubTGraph() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExtSubTGraph = null;


        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1857:2: (iv_ruleExtSubTGraph= ruleExtSubTGraph EOF )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1858:2: iv_ruleExtSubTGraph= ruleExtSubTGraph EOF
            {
             newCompositeNode(grammarAccess.getExtSubTGraphRule()); 
            pushFollow(FOLLOW_ruleExtSubTGraph_in_entryRuleExtSubTGraph3985);
            iv_ruleExtSubTGraph=ruleExtSubTGraph();

            state._fsp--;

             current =iv_ruleExtSubTGraph; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleExtSubTGraph3995); 

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
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1865:1: ruleExtSubTGraph returns [EObject current=null] : ( ( (lv_id_0_0= RULE_ID ) ) otherlv_1= ':=' otherlv_2= 'ExtSubTGraph' otherlv_3= '<' ( (lv_extendsGraph_4_0= ruleTGraphExtSubName ) ) otherlv_5= '>' otherlv_6= '{' ( (lv_elements_7_0= ruleElement ) )* otherlv_8= '}' ) ;
    public final EObject ruleExtSubTGraph() throws RecognitionException {
        EObject current = null;

        Token lv_id_0_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        EObject lv_extendsGraph_4_0 = null;

        EObject lv_elements_7_0 = null;


         enterRule(); 
            
        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1868:28: ( ( ( (lv_id_0_0= RULE_ID ) ) otherlv_1= ':=' otherlv_2= 'ExtSubTGraph' otherlv_3= '<' ( (lv_extendsGraph_4_0= ruleTGraphExtSubName ) ) otherlv_5= '>' otherlv_6= '{' ( (lv_elements_7_0= ruleElement ) )* otherlv_8= '}' ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1869:1: ( ( (lv_id_0_0= RULE_ID ) ) otherlv_1= ':=' otherlv_2= 'ExtSubTGraph' otherlv_3= '<' ( (lv_extendsGraph_4_0= ruleTGraphExtSubName ) ) otherlv_5= '>' otherlv_6= '{' ( (lv_elements_7_0= ruleElement ) )* otherlv_8= '}' )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1869:1: ( ( (lv_id_0_0= RULE_ID ) ) otherlv_1= ':=' otherlv_2= 'ExtSubTGraph' otherlv_3= '<' ( (lv_extendsGraph_4_0= ruleTGraphExtSubName ) ) otherlv_5= '>' otherlv_6= '{' ( (lv_elements_7_0= ruleElement ) )* otherlv_8= '}' )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1869:2: ( (lv_id_0_0= RULE_ID ) ) otherlv_1= ':=' otherlv_2= 'ExtSubTGraph' otherlv_3= '<' ( (lv_extendsGraph_4_0= ruleTGraphExtSubName ) ) otherlv_5= '>' otherlv_6= '{' ( (lv_elements_7_0= ruleElement ) )* otherlv_8= '}'
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1869:2: ( (lv_id_0_0= RULE_ID ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1870:1: (lv_id_0_0= RULE_ID )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1870:1: (lv_id_0_0= RULE_ID )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1871:3: lv_id_0_0= RULE_ID
            {
            lv_id_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleExtSubTGraph4037); 

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

            otherlv_1=(Token)match(input,24,FOLLOW_24_in_ruleExtSubTGraph4054); 

                	newLeafNode(otherlv_1, grammarAccess.getExtSubTGraphAccess().getColonEqualsSignKeyword_1());
                
            otherlv_2=(Token)match(input,35,FOLLOW_35_in_ruleExtSubTGraph4066); 

                	newLeafNode(otherlv_2, grammarAccess.getExtSubTGraphAccess().getExtSubTGraphKeyword_2());
                
            otherlv_3=(Token)match(input,26,FOLLOW_26_in_ruleExtSubTGraph4078); 

                	newLeafNode(otherlv_3, grammarAccess.getExtSubTGraphAccess().getLessThanSignKeyword_3());
                
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1899:1: ( (lv_extendsGraph_4_0= ruleTGraphExtSubName ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1900:1: (lv_extendsGraph_4_0= ruleTGraphExtSubName )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1900:1: (lv_extendsGraph_4_0= ruleTGraphExtSubName )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1901:3: lv_extendsGraph_4_0= ruleTGraphExtSubName
            {
             
            	        newCompositeNode(grammarAccess.getExtSubTGraphAccess().getExtendsGraphTGraphExtSubNameParserRuleCall_4_0()); 
            	    
            pushFollow(FOLLOW_ruleTGraphExtSubName_in_ruleExtSubTGraph4099);
            lv_extendsGraph_4_0=ruleTGraphExtSubName();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getExtSubTGraphRule());
            	        }
                   		set(
                   			current, 
                   			"extendsGraph",
                    		lv_extendsGraph_4_0, 
                    		"TGraphExtSubName");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_5=(Token)match(input,27,FOLLOW_27_in_ruleExtSubTGraph4111); 

                	newLeafNode(otherlv_5, grammarAccess.getExtSubTGraphAccess().getGreaterThanSignKeyword_5());
                
            otherlv_6=(Token)match(input,28,FOLLOW_28_in_ruleExtSubTGraph4123); 

                	newLeafNode(otherlv_6, grammarAccess.getExtSubTGraphAccess().getLeftCurlyBracketKeyword_6());
                
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1925:1: ( (lv_elements_7_0= ruleElement ) )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==RULE_ID) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1926:1: (lv_elements_7_0= ruleElement )
            	    {
            	    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1926:1: (lv_elements_7_0= ruleElement )
            	    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1927:3: lv_elements_7_0= ruleElement
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getExtSubTGraphAccess().getElementsElementParserRuleCall_7_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleElement_in_ruleExtSubTGraph4144);
            	    lv_elements_7_0=ruleElement();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getExtSubTGraphRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"elements",
            	            		lv_elements_7_0, 
            	            		"Element");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);

            otherlv_8=(Token)match(input,29,FOLLOW_29_in_ruleExtSubTGraph4157); 

                	newLeafNode(otherlv_8, grammarAccess.getExtSubTGraphAccess().getRightCurlyBracketKeyword_8());
                

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
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1955:1: entryRuleTGraphExtSubName returns [EObject current=null] : iv_ruleTGraphExtSubName= ruleTGraphExtSubName EOF ;
    public final EObject entryRuleTGraphExtSubName() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTGraphExtSubName = null;


        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1956:2: (iv_ruleTGraphExtSubName= ruleTGraphExtSubName EOF )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1957:2: iv_ruleTGraphExtSubName= ruleTGraphExtSubName EOF
            {
             newCompositeNode(grammarAccess.getTGraphExtSubNameRule()); 
            pushFollow(FOLLOW_ruleTGraphExtSubName_in_entryRuleTGraphExtSubName4193);
            iv_ruleTGraphExtSubName=ruleTGraphExtSubName();

            state._fsp--;

             current =iv_ruleTGraphExtSubName; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTGraphExtSubName4203); 

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
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1964:1: ruleTGraphExtSubName returns [EObject current=null] : ( (lv_id_0_0= RULE_ID ) ) ;
    public final EObject ruleTGraphExtSubName() throws RecognitionException {
        EObject current = null;

        Token lv_id_0_0=null;

         enterRule(); 
            
        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1967:28: ( ( (lv_id_0_0= RULE_ID ) ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1968:1: ( (lv_id_0_0= RULE_ID ) )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1968:1: ( (lv_id_0_0= RULE_ID ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1969:1: (lv_id_0_0= RULE_ID )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1969:1: (lv_id_0_0= RULE_ID )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1970:3: lv_id_0_0= RULE_ID
            {
            lv_id_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTGraphExtSubName4244); 

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
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1994:1: entryRuleTGraph returns [EObject current=null] : iv_ruleTGraph= ruleTGraph EOF ;
    public final EObject entryRuleTGraph() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTGraph = null;


        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1995:2: (iv_ruleTGraph= ruleTGraph EOF )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1996:2: iv_ruleTGraph= ruleTGraph EOF
            {
             newCompositeNode(grammarAccess.getTGraphRule()); 
            pushFollow(FOLLOW_ruleTGraph_in_entryRuleTGraph4284);
            iv_ruleTGraph=ruleTGraph();

            state._fsp--;

             current =iv_ruleTGraph; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTGraph4294); 

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
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2003:1: ruleTGraph returns [EObject current=null] : ( ( (lv_id_0_0= RULE_ID ) ) otherlv_1= ':=' otherlv_2= 'TGraph' otherlv_3= '<' ( (lv_typeGraph_4_0= ruleTGraphName ) ) otherlv_5= '>' otherlv_6= '{' ( (lv_elements_7_0= ruleElement ) )* otherlv_8= '}' ) ;
    public final EObject ruleTGraph() throws RecognitionException {
        EObject current = null;

        Token lv_id_0_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        EObject lv_typeGraph_4_0 = null;

        EObject lv_elements_7_0 = null;


         enterRule(); 
            
        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2006:28: ( ( ( (lv_id_0_0= RULE_ID ) ) otherlv_1= ':=' otherlv_2= 'TGraph' otherlv_3= '<' ( (lv_typeGraph_4_0= ruleTGraphName ) ) otherlv_5= '>' otherlv_6= '{' ( (lv_elements_7_0= ruleElement ) )* otherlv_8= '}' ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2007:1: ( ( (lv_id_0_0= RULE_ID ) ) otherlv_1= ':=' otherlv_2= 'TGraph' otherlv_3= '<' ( (lv_typeGraph_4_0= ruleTGraphName ) ) otherlv_5= '>' otherlv_6= '{' ( (lv_elements_7_0= ruleElement ) )* otherlv_8= '}' )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2007:1: ( ( (lv_id_0_0= RULE_ID ) ) otherlv_1= ':=' otherlv_2= 'TGraph' otherlv_3= '<' ( (lv_typeGraph_4_0= ruleTGraphName ) ) otherlv_5= '>' otherlv_6= '{' ( (lv_elements_7_0= ruleElement ) )* otherlv_8= '}' )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2007:2: ( (lv_id_0_0= RULE_ID ) ) otherlv_1= ':=' otherlv_2= 'TGraph' otherlv_3= '<' ( (lv_typeGraph_4_0= ruleTGraphName ) ) otherlv_5= '>' otherlv_6= '{' ( (lv_elements_7_0= ruleElement ) )* otherlv_8= '}'
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2007:2: ( (lv_id_0_0= RULE_ID ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2008:1: (lv_id_0_0= RULE_ID )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2008:1: (lv_id_0_0= RULE_ID )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2009:3: lv_id_0_0= RULE_ID
            {
            lv_id_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTGraph4336); 

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

            otherlv_1=(Token)match(input,24,FOLLOW_24_in_ruleTGraph4353); 

                	newLeafNode(otherlv_1, grammarAccess.getTGraphAccess().getColonEqualsSignKeyword_1());
                
            otherlv_2=(Token)match(input,36,FOLLOW_36_in_ruleTGraph4365); 

                	newLeafNode(otherlv_2, grammarAccess.getTGraphAccess().getTGraphKeyword_2());
                
            otherlv_3=(Token)match(input,26,FOLLOW_26_in_ruleTGraph4377); 

                	newLeafNode(otherlv_3, grammarAccess.getTGraphAccess().getLessThanSignKeyword_3());
                
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2037:1: ( (lv_typeGraph_4_0= ruleTGraphName ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2038:1: (lv_typeGraph_4_0= ruleTGraphName )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2038:1: (lv_typeGraph_4_0= ruleTGraphName )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2039:3: lv_typeGraph_4_0= ruleTGraphName
            {
             
            	        newCompositeNode(grammarAccess.getTGraphAccess().getTypeGraphTGraphNameParserRuleCall_4_0()); 
            	    
            pushFollow(FOLLOW_ruleTGraphName_in_ruleTGraph4398);
            lv_typeGraph_4_0=ruleTGraphName();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getTGraphRule());
            	        }
                   		set(
                   			current, 
                   			"typeGraph",
                    		lv_typeGraph_4_0, 
                    		"TGraphName");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_5=(Token)match(input,27,FOLLOW_27_in_ruleTGraph4410); 

                	newLeafNode(otherlv_5, grammarAccess.getTGraphAccess().getGreaterThanSignKeyword_5());
                
            otherlv_6=(Token)match(input,28,FOLLOW_28_in_ruleTGraph4422); 

                	newLeafNode(otherlv_6, grammarAccess.getTGraphAccess().getLeftCurlyBracketKeyword_6());
                
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2063:1: ( (lv_elements_7_0= ruleElement ) )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==RULE_ID) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2064:1: (lv_elements_7_0= ruleElement )
            	    {
            	    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2064:1: (lv_elements_7_0= ruleElement )
            	    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2065:3: lv_elements_7_0= ruleElement
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getTGraphAccess().getElementsElementParserRuleCall_7_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleElement_in_ruleTGraph4443);
            	    lv_elements_7_0=ruleElement();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getTGraphRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"elements",
            	            		lv_elements_7_0, 
            	            		"Element");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);

            otherlv_8=(Token)match(input,29,FOLLOW_29_in_ruleTGraph4456); 

                	newLeafNode(otherlv_8, grammarAccess.getTGraphAccess().getRightCurlyBracketKeyword_8());
                

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
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2093:1: entryRuleTGraphName returns [EObject current=null] : iv_ruleTGraphName= ruleTGraphName EOF ;
    public final EObject entryRuleTGraphName() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTGraphName = null;


        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2094:2: (iv_ruleTGraphName= ruleTGraphName EOF )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2095:2: iv_ruleTGraphName= ruleTGraphName EOF
            {
             newCompositeNode(grammarAccess.getTGraphNameRule()); 
            pushFollow(FOLLOW_ruleTGraphName_in_entryRuleTGraphName4492);
            iv_ruleTGraphName=ruleTGraphName();

            state._fsp--;

             current =iv_ruleTGraphName; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTGraphName4502); 

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
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2102:1: ruleTGraphName returns [EObject current=null] : ( (lv_id_0_0= RULE_ID ) ) ;
    public final EObject ruleTGraphName() throws RecognitionException {
        EObject current = null;

        Token lv_id_0_0=null;

         enterRule(); 
            
        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2105:28: ( ( (lv_id_0_0= RULE_ID ) ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2106:1: ( (lv_id_0_0= RULE_ID ) )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2106:1: ( (lv_id_0_0= RULE_ID ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2107:1: (lv_id_0_0= RULE_ID )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2107:1: (lv_id_0_0= RULE_ID )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2108:3: lv_id_0_0= RULE_ID
            {
            lv_id_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTGraphName4543); 

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
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2132:1: entryRuleElement returns [EObject current=null] : iv_ruleElement= ruleElement EOF ;
    public final EObject entryRuleElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleElement = null;


        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2133:2: (iv_ruleElement= ruleElement EOF )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2134:2: iv_ruleElement= ruleElement EOF
            {
             newCompositeNode(grammarAccess.getElementRule()); 
            pushFollow(FOLLOW_ruleElement_in_entryRuleElement4583);
            iv_ruleElement=ruleElement();

            state._fsp--;

             current =iv_ruleElement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleElement4593); 

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
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2141:1: ruleElement returns [EObject current=null] : ( (this_Node_0= ruleNode otherlv_1= ',' ) | (this_Arrows_2= ruleArrows otherlv_3= ',' ) ) ;
    public final EObject ruleElement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject this_Node_0 = null;

        EObject this_Arrows_2 = null;


         enterRule(); 
            
        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2144:28: ( ( (this_Node_0= ruleNode otherlv_1= ',' ) | (this_Arrows_2= ruleArrows otherlv_3= ',' ) ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2145:1: ( (this_Node_0= ruleNode otherlv_1= ',' ) | (this_Arrows_2= ruleArrows otherlv_3= ',' ) )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2145:1: ( (this_Node_0= ruleNode otherlv_1= ',' ) | (this_Arrows_2= ruleArrows otherlv_3= ',' ) )
            int alt17=2;
            alt17 = dfa17.predict(input);
            switch (alt17) {
                case 1 :
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2145:2: (this_Node_0= ruleNode otherlv_1= ',' )
                    {
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2145:2: (this_Node_0= ruleNode otherlv_1= ',' )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2146:5: this_Node_0= ruleNode otherlv_1= ','
                    {
                     
                            newCompositeNode(grammarAccess.getElementAccess().getNodeParserRuleCall_0_0()); 
                        
                    pushFollow(FOLLOW_ruleNode_in_ruleElement4641);
                    this_Node_0=ruleNode();

                    state._fsp--;

                     
                            current = this_Node_0; 
                            afterParserOrEnumRuleCall();
                        
                    otherlv_1=(Token)match(input,20,FOLLOW_20_in_ruleElement4652); 

                        	newLeafNode(otherlv_1, grammarAccess.getElementAccess().getCommaKeyword_0_1());
                        

                    }


                    }
                    break;
                case 2 :
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2159:6: (this_Arrows_2= ruleArrows otherlv_3= ',' )
                    {
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2159:6: (this_Arrows_2= ruleArrows otherlv_3= ',' )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2160:5: this_Arrows_2= ruleArrows otherlv_3= ','
                    {
                     
                            newCompositeNode(grammarAccess.getElementAccess().getArrowsParserRuleCall_1_0()); 
                        
                    pushFollow(FOLLOW_ruleArrows_in_ruleElement4682);
                    this_Arrows_2=ruleArrows();

                    state._fsp--;

                     
                            current = this_Arrows_2; 
                            afterParserOrEnumRuleCall();
                        
                    otherlv_3=(Token)match(input,20,FOLLOW_20_in_ruleElement4693); 

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
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2180:1: entryRuleArrows returns [EObject current=null] : iv_ruleArrows= ruleArrows EOF ;
    public final EObject entryRuleArrows() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArrows = null;


        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2181:2: (iv_ruleArrows= ruleArrows EOF )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2182:2: iv_ruleArrows= ruleArrows EOF
            {
             newCompositeNode(grammarAccess.getArrowsRule()); 
            pushFollow(FOLLOW_ruleArrows_in_entryRuleArrows4730);
            iv_ruleArrows=ruleArrows();

            state._fsp--;

             current =iv_ruleArrows; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleArrows4740); 

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
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2189:1: ruleArrows returns [EObject current=null] : ( ( ( (lv_sr_0_0= ruleNode ) ) otherlv_1= '-' ( (lv_id_2_0= ruleDpfId ) ) otherlv_3= ':' ( (lv_type_4_0= ruleDpfId ) ) otherlv_5= '->' ( (lv_next_6_0= ruleArrows ) ) ) | this_Arrow_7= ruleArrow ) ;
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
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2192:28: ( ( ( ( (lv_sr_0_0= ruleNode ) ) otherlv_1= '-' ( (lv_id_2_0= ruleDpfId ) ) otherlv_3= ':' ( (lv_type_4_0= ruleDpfId ) ) otherlv_5= '->' ( (lv_next_6_0= ruleArrows ) ) ) | this_Arrow_7= ruleArrow ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2193:1: ( ( ( (lv_sr_0_0= ruleNode ) ) otherlv_1= '-' ( (lv_id_2_0= ruleDpfId ) ) otherlv_3= ':' ( (lv_type_4_0= ruleDpfId ) ) otherlv_5= '->' ( (lv_next_6_0= ruleArrows ) ) ) | this_Arrow_7= ruleArrow )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2193:1: ( ( ( (lv_sr_0_0= ruleNode ) ) otherlv_1= '-' ( (lv_id_2_0= ruleDpfId ) ) otherlv_3= ':' ( (lv_type_4_0= ruleDpfId ) ) otherlv_5= '->' ( (lv_next_6_0= ruleArrows ) ) ) | this_Arrow_7= ruleArrow )
            int alt18=2;
            alt18 = dfa18.predict(input);
            switch (alt18) {
                case 1 :
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2193:2: ( ( (lv_sr_0_0= ruleNode ) ) otherlv_1= '-' ( (lv_id_2_0= ruleDpfId ) ) otherlv_3= ':' ( (lv_type_4_0= ruleDpfId ) ) otherlv_5= '->' ( (lv_next_6_0= ruleArrows ) ) )
                    {
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2193:2: ( ( (lv_sr_0_0= ruleNode ) ) otherlv_1= '-' ( (lv_id_2_0= ruleDpfId ) ) otherlv_3= ':' ( (lv_type_4_0= ruleDpfId ) ) otherlv_5= '->' ( (lv_next_6_0= ruleArrows ) ) )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2193:3: ( (lv_sr_0_0= ruleNode ) ) otherlv_1= '-' ( (lv_id_2_0= ruleDpfId ) ) otherlv_3= ':' ( (lv_type_4_0= ruleDpfId ) ) otherlv_5= '->' ( (lv_next_6_0= ruleArrows ) )
                    {
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2193:3: ( (lv_sr_0_0= ruleNode ) )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2194:1: (lv_sr_0_0= ruleNode )
                    {
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2194:1: (lv_sr_0_0= ruleNode )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2195:3: lv_sr_0_0= ruleNode
                    {
                     
                    	        newCompositeNode(grammarAccess.getArrowsAccess().getSrNodeParserRuleCall_0_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleNode_in_ruleArrows4787);
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

                    otherlv_1=(Token)match(input,37,FOLLOW_37_in_ruleArrows4799); 

                        	newLeafNode(otherlv_1, grammarAccess.getArrowsAccess().getHyphenMinusKeyword_0_1());
                        
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2215:1: ( (lv_id_2_0= ruleDpfId ) )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2216:1: (lv_id_2_0= ruleDpfId )
                    {
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2216:1: (lv_id_2_0= ruleDpfId )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2217:3: lv_id_2_0= ruleDpfId
                    {
                     
                    	        newCompositeNode(grammarAccess.getArrowsAccess().getIdDpfIdParserRuleCall_0_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDpfId_in_ruleArrows4820);
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

                    otherlv_3=(Token)match(input,38,FOLLOW_38_in_ruleArrows4832); 

                        	newLeafNode(otherlv_3, grammarAccess.getArrowsAccess().getColonKeyword_0_3());
                        
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2237:1: ( (lv_type_4_0= ruleDpfId ) )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2238:1: (lv_type_4_0= ruleDpfId )
                    {
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2238:1: (lv_type_4_0= ruleDpfId )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2239:3: lv_type_4_0= ruleDpfId
                    {
                     
                    	        newCompositeNode(grammarAccess.getArrowsAccess().getTypeDpfIdParserRuleCall_0_4_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDpfId_in_ruleArrows4853);
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

                    otherlv_5=(Token)match(input,19,FOLLOW_19_in_ruleArrows4865); 

                        	newLeafNode(otherlv_5, grammarAccess.getArrowsAccess().getHyphenMinusGreaterThanSignKeyword_0_5());
                        
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2259:1: ( (lv_next_6_0= ruleArrows ) )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2260:1: (lv_next_6_0= ruleArrows )
                    {
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2260:1: (lv_next_6_0= ruleArrows )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2261:3: lv_next_6_0= ruleArrows
                    {
                     
                    	        newCompositeNode(grammarAccess.getArrowsAccess().getNextArrowsParserRuleCall_0_6_0()); 
                    	    
                    pushFollow(FOLLOW_ruleArrows_in_ruleArrows4886);
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
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2279:5: this_Arrow_7= ruleArrow
                    {
                     
                            newCompositeNode(grammarAccess.getArrowsAccess().getArrowParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleArrow_in_ruleArrows4915);
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
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2295:1: entryRuleArrow returns [EObject current=null] : iv_ruleArrow= ruleArrow EOF ;
    public final EObject entryRuleArrow() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArrow = null;


        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2296:2: (iv_ruleArrow= ruleArrow EOF )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2297:2: iv_ruleArrow= ruleArrow EOF
            {
             newCompositeNode(grammarAccess.getArrowRule()); 
            pushFollow(FOLLOW_ruleArrow_in_entryRuleArrow4950);
            iv_ruleArrow=ruleArrow();

            state._fsp--;

             current =iv_ruleArrow; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleArrow4960); 

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
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2304:1: ruleArrow returns [EObject current=null] : ( ( ( (lv_sr_0_0= ruleNode ) ) otherlv_1= '-' ( (lv_id_2_0= ruleDpfId ) ) otherlv_3= ':' otherlv_4= '*' otherlv_5= '->' ( (lv_tgDataType_6_0= ruleDataType ) ) ) | ( ( (lv_sr_7_0= ruleNode ) ) otherlv_8= '-' ( (lv_id_9_0= ruleDpfId ) ) otherlv_10= ':' ( (lv_type_11_0= ruleDpfId ) ) otherlv_12= '->' ( (lv_tgValue_13_0= ruleAttributeValue ) ) ) | ( ( (lv_sr_14_0= ruleNode ) ) otherlv_15= '-' ( (lv_id_16_0= ruleDpfId ) ) otherlv_17= ':' ( (lv_type_18_0= ruleDpfId ) ) otherlv_19= '->' ( (lv_tgNode_20_0= ruleNode ) ) ) ) ;
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
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2307:28: ( ( ( ( (lv_sr_0_0= ruleNode ) ) otherlv_1= '-' ( (lv_id_2_0= ruleDpfId ) ) otherlv_3= ':' otherlv_4= '*' otherlv_5= '->' ( (lv_tgDataType_6_0= ruleDataType ) ) ) | ( ( (lv_sr_7_0= ruleNode ) ) otherlv_8= '-' ( (lv_id_9_0= ruleDpfId ) ) otherlv_10= ':' ( (lv_type_11_0= ruleDpfId ) ) otherlv_12= '->' ( (lv_tgValue_13_0= ruleAttributeValue ) ) ) | ( ( (lv_sr_14_0= ruleNode ) ) otherlv_15= '-' ( (lv_id_16_0= ruleDpfId ) ) otherlv_17= ':' ( (lv_type_18_0= ruleDpfId ) ) otherlv_19= '->' ( (lv_tgNode_20_0= ruleNode ) ) ) ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2308:1: ( ( ( (lv_sr_0_0= ruleNode ) ) otherlv_1= '-' ( (lv_id_2_0= ruleDpfId ) ) otherlv_3= ':' otherlv_4= '*' otherlv_5= '->' ( (lv_tgDataType_6_0= ruleDataType ) ) ) | ( ( (lv_sr_7_0= ruleNode ) ) otherlv_8= '-' ( (lv_id_9_0= ruleDpfId ) ) otherlv_10= ':' ( (lv_type_11_0= ruleDpfId ) ) otherlv_12= '->' ( (lv_tgValue_13_0= ruleAttributeValue ) ) ) | ( ( (lv_sr_14_0= ruleNode ) ) otherlv_15= '-' ( (lv_id_16_0= ruleDpfId ) ) otherlv_17= ':' ( (lv_type_18_0= ruleDpfId ) ) otherlv_19= '->' ( (lv_tgNode_20_0= ruleNode ) ) ) )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2308:1: ( ( ( (lv_sr_0_0= ruleNode ) ) otherlv_1= '-' ( (lv_id_2_0= ruleDpfId ) ) otherlv_3= ':' otherlv_4= '*' otherlv_5= '->' ( (lv_tgDataType_6_0= ruleDataType ) ) ) | ( ( (lv_sr_7_0= ruleNode ) ) otherlv_8= '-' ( (lv_id_9_0= ruleDpfId ) ) otherlv_10= ':' ( (lv_type_11_0= ruleDpfId ) ) otherlv_12= '->' ( (lv_tgValue_13_0= ruleAttributeValue ) ) ) | ( ( (lv_sr_14_0= ruleNode ) ) otherlv_15= '-' ( (lv_id_16_0= ruleDpfId ) ) otherlv_17= ':' ( (lv_type_18_0= ruleDpfId ) ) otherlv_19= '->' ( (lv_tgNode_20_0= ruleNode ) ) ) )
            int alt19=3;
            alt19 = dfa19.predict(input);
            switch (alt19) {
                case 1 :
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2308:2: ( ( (lv_sr_0_0= ruleNode ) ) otherlv_1= '-' ( (lv_id_2_0= ruleDpfId ) ) otherlv_3= ':' otherlv_4= '*' otherlv_5= '->' ( (lv_tgDataType_6_0= ruleDataType ) ) )
                    {
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2308:2: ( ( (lv_sr_0_0= ruleNode ) ) otherlv_1= '-' ( (lv_id_2_0= ruleDpfId ) ) otherlv_3= ':' otherlv_4= '*' otherlv_5= '->' ( (lv_tgDataType_6_0= ruleDataType ) ) )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2308:3: ( (lv_sr_0_0= ruleNode ) ) otherlv_1= '-' ( (lv_id_2_0= ruleDpfId ) ) otherlv_3= ':' otherlv_4= '*' otherlv_5= '->' ( (lv_tgDataType_6_0= ruleDataType ) )
                    {
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2308:3: ( (lv_sr_0_0= ruleNode ) )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2309:1: (lv_sr_0_0= ruleNode )
                    {
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2309:1: (lv_sr_0_0= ruleNode )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2310:3: lv_sr_0_0= ruleNode
                    {
                     
                    	        newCompositeNode(grammarAccess.getArrowAccess().getSrNodeParserRuleCall_0_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleNode_in_ruleArrow5007);
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

                    otherlv_1=(Token)match(input,37,FOLLOW_37_in_ruleArrow5019); 

                        	newLeafNode(otherlv_1, grammarAccess.getArrowAccess().getHyphenMinusKeyword_0_1());
                        
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2330:1: ( (lv_id_2_0= ruleDpfId ) )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2331:1: (lv_id_2_0= ruleDpfId )
                    {
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2331:1: (lv_id_2_0= ruleDpfId )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2332:3: lv_id_2_0= ruleDpfId
                    {
                     
                    	        newCompositeNode(grammarAccess.getArrowAccess().getIdDpfIdParserRuleCall_0_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDpfId_in_ruleArrow5040);
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

                    otherlv_3=(Token)match(input,38,FOLLOW_38_in_ruleArrow5052); 

                        	newLeafNode(otherlv_3, grammarAccess.getArrowAccess().getColonKeyword_0_3());
                        
                    otherlv_4=(Token)match(input,39,FOLLOW_39_in_ruleArrow5064); 

                        	newLeafNode(otherlv_4, grammarAccess.getArrowAccess().getAsteriskKeyword_0_4());
                        
                    otherlv_5=(Token)match(input,19,FOLLOW_19_in_ruleArrow5076); 

                        	newLeafNode(otherlv_5, grammarAccess.getArrowAccess().getHyphenMinusGreaterThanSignKeyword_0_5());
                        
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2360:1: ( (lv_tgDataType_6_0= ruleDataType ) )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2361:1: (lv_tgDataType_6_0= ruleDataType )
                    {
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2361:1: (lv_tgDataType_6_0= ruleDataType )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2362:3: lv_tgDataType_6_0= ruleDataType
                    {
                     
                    	        newCompositeNode(grammarAccess.getArrowAccess().getTgDataTypeDataTypeEnumRuleCall_0_6_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDataType_in_ruleArrow5097);
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
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2379:6: ( ( (lv_sr_7_0= ruleNode ) ) otherlv_8= '-' ( (lv_id_9_0= ruleDpfId ) ) otherlv_10= ':' ( (lv_type_11_0= ruleDpfId ) ) otherlv_12= '->' ( (lv_tgValue_13_0= ruleAttributeValue ) ) )
                    {
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2379:6: ( ( (lv_sr_7_0= ruleNode ) ) otherlv_8= '-' ( (lv_id_9_0= ruleDpfId ) ) otherlv_10= ':' ( (lv_type_11_0= ruleDpfId ) ) otherlv_12= '->' ( (lv_tgValue_13_0= ruleAttributeValue ) ) )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2379:7: ( (lv_sr_7_0= ruleNode ) ) otherlv_8= '-' ( (lv_id_9_0= ruleDpfId ) ) otherlv_10= ':' ( (lv_type_11_0= ruleDpfId ) ) otherlv_12= '->' ( (lv_tgValue_13_0= ruleAttributeValue ) )
                    {
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2379:7: ( (lv_sr_7_0= ruleNode ) )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2380:1: (lv_sr_7_0= ruleNode )
                    {
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2380:1: (lv_sr_7_0= ruleNode )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2381:3: lv_sr_7_0= ruleNode
                    {
                     
                    	        newCompositeNode(grammarAccess.getArrowAccess().getSrNodeParserRuleCall_1_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleNode_in_ruleArrow5126);
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

                    otherlv_8=(Token)match(input,37,FOLLOW_37_in_ruleArrow5138); 

                        	newLeafNode(otherlv_8, grammarAccess.getArrowAccess().getHyphenMinusKeyword_1_1());
                        
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2401:1: ( (lv_id_9_0= ruleDpfId ) )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2402:1: (lv_id_9_0= ruleDpfId )
                    {
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2402:1: (lv_id_9_0= ruleDpfId )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2403:3: lv_id_9_0= ruleDpfId
                    {
                     
                    	        newCompositeNode(grammarAccess.getArrowAccess().getIdDpfIdParserRuleCall_1_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDpfId_in_ruleArrow5159);
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

                    otherlv_10=(Token)match(input,38,FOLLOW_38_in_ruleArrow5171); 

                        	newLeafNode(otherlv_10, grammarAccess.getArrowAccess().getColonKeyword_1_3());
                        
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2423:1: ( (lv_type_11_0= ruleDpfId ) )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2424:1: (lv_type_11_0= ruleDpfId )
                    {
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2424:1: (lv_type_11_0= ruleDpfId )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2425:3: lv_type_11_0= ruleDpfId
                    {
                     
                    	        newCompositeNode(grammarAccess.getArrowAccess().getTypeDpfIdParserRuleCall_1_4_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDpfId_in_ruleArrow5192);
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

                    otherlv_12=(Token)match(input,19,FOLLOW_19_in_ruleArrow5204); 

                        	newLeafNode(otherlv_12, grammarAccess.getArrowAccess().getHyphenMinusGreaterThanSignKeyword_1_5());
                        
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2445:1: ( (lv_tgValue_13_0= ruleAttributeValue ) )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2446:1: (lv_tgValue_13_0= ruleAttributeValue )
                    {
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2446:1: (lv_tgValue_13_0= ruleAttributeValue )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2447:3: lv_tgValue_13_0= ruleAttributeValue
                    {
                     
                    	        newCompositeNode(grammarAccess.getArrowAccess().getTgValueAttributeValueParserRuleCall_1_6_0()); 
                    	    
                    pushFollow(FOLLOW_ruleAttributeValue_in_ruleArrow5225);
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
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2464:6: ( ( (lv_sr_14_0= ruleNode ) ) otherlv_15= '-' ( (lv_id_16_0= ruleDpfId ) ) otherlv_17= ':' ( (lv_type_18_0= ruleDpfId ) ) otherlv_19= '->' ( (lv_tgNode_20_0= ruleNode ) ) )
                    {
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2464:6: ( ( (lv_sr_14_0= ruleNode ) ) otherlv_15= '-' ( (lv_id_16_0= ruleDpfId ) ) otherlv_17= ':' ( (lv_type_18_0= ruleDpfId ) ) otherlv_19= '->' ( (lv_tgNode_20_0= ruleNode ) ) )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2464:7: ( (lv_sr_14_0= ruleNode ) ) otherlv_15= '-' ( (lv_id_16_0= ruleDpfId ) ) otherlv_17= ':' ( (lv_type_18_0= ruleDpfId ) ) otherlv_19= '->' ( (lv_tgNode_20_0= ruleNode ) )
                    {
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2464:7: ( (lv_sr_14_0= ruleNode ) )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2465:1: (lv_sr_14_0= ruleNode )
                    {
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2465:1: (lv_sr_14_0= ruleNode )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2466:3: lv_sr_14_0= ruleNode
                    {
                     
                    	        newCompositeNode(grammarAccess.getArrowAccess().getSrNodeParserRuleCall_2_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleNode_in_ruleArrow5254);
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

                    otherlv_15=(Token)match(input,37,FOLLOW_37_in_ruleArrow5266); 

                        	newLeafNode(otherlv_15, grammarAccess.getArrowAccess().getHyphenMinusKeyword_2_1());
                        
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2486:1: ( (lv_id_16_0= ruleDpfId ) )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2487:1: (lv_id_16_0= ruleDpfId )
                    {
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2487:1: (lv_id_16_0= ruleDpfId )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2488:3: lv_id_16_0= ruleDpfId
                    {
                     
                    	        newCompositeNode(grammarAccess.getArrowAccess().getIdDpfIdParserRuleCall_2_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDpfId_in_ruleArrow5287);
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

                    otherlv_17=(Token)match(input,38,FOLLOW_38_in_ruleArrow5299); 

                        	newLeafNode(otherlv_17, grammarAccess.getArrowAccess().getColonKeyword_2_3());
                        
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2508:1: ( (lv_type_18_0= ruleDpfId ) )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2509:1: (lv_type_18_0= ruleDpfId )
                    {
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2509:1: (lv_type_18_0= ruleDpfId )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2510:3: lv_type_18_0= ruleDpfId
                    {
                     
                    	        newCompositeNode(grammarAccess.getArrowAccess().getTypeDpfIdParserRuleCall_2_4_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDpfId_in_ruleArrow5320);
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

                    otherlv_19=(Token)match(input,19,FOLLOW_19_in_ruleArrow5332); 

                        	newLeafNode(otherlv_19, grammarAccess.getArrowAccess().getHyphenMinusGreaterThanSignKeyword_2_5());
                        
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2530:1: ( (lv_tgNode_20_0= ruleNode ) )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2531:1: (lv_tgNode_20_0= ruleNode )
                    {
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2531:1: (lv_tgNode_20_0= ruleNode )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2532:3: lv_tgNode_20_0= ruleNode
                    {
                     
                    	        newCompositeNode(grammarAccess.getArrowAccess().getTgNodeNodeParserRuleCall_2_6_0()); 
                    	    
                    pushFollow(FOLLOW_ruleNode_in_ruleArrow5353);
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
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2556:1: entryRuleNode returns [EObject current=null] : iv_ruleNode= ruleNode EOF ;
    public final EObject entryRuleNode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNode = null;


        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2557:2: (iv_ruleNode= ruleNode EOF )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2558:2: iv_ruleNode= ruleNode EOF
            {
             newCompositeNode(grammarAccess.getNodeRule()); 
            pushFollow(FOLLOW_ruleNode_in_entryRuleNode5390);
            iv_ruleNode=ruleNode();

            state._fsp--;

             current =iv_ruleNode; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNode5400); 

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
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2565:1: ruleNode returns [EObject current=null] : ( ( (lv_id_0_0= ruleDpfId ) ) otherlv_1= ':' ( (lv_type_2_0= ruleDpfId ) ) ) ;
    public final EObject ruleNode() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_id_0_0 = null;

        EObject lv_type_2_0 = null;


         enterRule(); 
            
        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2568:28: ( ( ( (lv_id_0_0= ruleDpfId ) ) otherlv_1= ':' ( (lv_type_2_0= ruleDpfId ) ) ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2569:1: ( ( (lv_id_0_0= ruleDpfId ) ) otherlv_1= ':' ( (lv_type_2_0= ruleDpfId ) ) )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2569:1: ( ( (lv_id_0_0= ruleDpfId ) ) otherlv_1= ':' ( (lv_type_2_0= ruleDpfId ) ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2569:2: ( (lv_id_0_0= ruleDpfId ) ) otherlv_1= ':' ( (lv_type_2_0= ruleDpfId ) )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2569:2: ( (lv_id_0_0= ruleDpfId ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2570:1: (lv_id_0_0= ruleDpfId )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2570:1: (lv_id_0_0= ruleDpfId )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2571:3: lv_id_0_0= ruleDpfId
            {
             
            	        newCompositeNode(grammarAccess.getNodeAccess().getIdDpfIdParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleDpfId_in_ruleNode5446);
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

            otherlv_1=(Token)match(input,38,FOLLOW_38_in_ruleNode5458); 

                	newLeafNode(otherlv_1, grammarAccess.getNodeAccess().getColonKeyword_1());
                
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2591:1: ( (lv_type_2_0= ruleDpfId ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2592:1: (lv_type_2_0= ruleDpfId )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2592:1: (lv_type_2_0= ruleDpfId )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2593:3: lv_type_2_0= ruleDpfId
            {
             
            	        newCompositeNode(grammarAccess.getNodeAccess().getTypeDpfIdParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleDpfId_in_ruleNode5479);
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
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2617:1: entryRuleAttributeValue returns [EObject current=null] : iv_ruleAttributeValue= ruleAttributeValue EOF ;
    public final EObject entryRuleAttributeValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttributeValue = null;


        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2618:2: (iv_ruleAttributeValue= ruleAttributeValue EOF )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2619:2: iv_ruleAttributeValue= ruleAttributeValue EOF
            {
             newCompositeNode(grammarAccess.getAttributeValueRule()); 
            pushFollow(FOLLOW_ruleAttributeValue_in_entryRuleAttributeValue5515);
            iv_ruleAttributeValue=ruleAttributeValue();

            state._fsp--;

             current =iv_ruleAttributeValue; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAttributeValue5525); 

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
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2626:1: ruleAttributeValue returns [EObject current=null] : (otherlv_0= '[' ( (lv_value_1_0= ruleVALUE ) ) otherlv_2= ']' ) ;
    public final EObject ruleAttributeValue() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        AntlrDatatypeRuleToken lv_value_1_0 = null;


         enterRule(); 
            
        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2629:28: ( (otherlv_0= '[' ( (lv_value_1_0= ruleVALUE ) ) otherlv_2= ']' ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2630:1: (otherlv_0= '[' ( (lv_value_1_0= ruleVALUE ) ) otherlv_2= ']' )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2630:1: (otherlv_0= '[' ( (lv_value_1_0= ruleVALUE ) ) otherlv_2= ']' )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2630:3: otherlv_0= '[' ( (lv_value_1_0= ruleVALUE ) ) otherlv_2= ']'
            {
            otherlv_0=(Token)match(input,40,FOLLOW_40_in_ruleAttributeValue5562); 

                	newLeafNode(otherlv_0, grammarAccess.getAttributeValueAccess().getLeftSquareBracketKeyword_0());
                
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2634:1: ( (lv_value_1_0= ruleVALUE ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2635:1: (lv_value_1_0= ruleVALUE )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2635:1: (lv_value_1_0= ruleVALUE )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2636:3: lv_value_1_0= ruleVALUE
            {
             
            	        newCompositeNode(grammarAccess.getAttributeValueAccess().getValueVALUEParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleVALUE_in_ruleAttributeValue5583);
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

            otherlv_2=(Token)match(input,41,FOLLOW_41_in_ruleAttributeValue5595); 

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
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2664:1: entryRuleDpfId returns [EObject current=null] : iv_ruleDpfId= ruleDpfId EOF ;
    public final EObject entryRuleDpfId() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDpfId = null;


        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2665:2: (iv_ruleDpfId= ruleDpfId EOF )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2666:2: iv_ruleDpfId= ruleDpfId EOF
            {
             newCompositeNode(grammarAccess.getDpfIdRule()); 
            pushFollow(FOLLOW_ruleDpfId_in_entryRuleDpfId5631);
            iv_ruleDpfId=ruleDpfId();

            state._fsp--;

             current =iv_ruleDpfId; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDpfId5641); 

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
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2673:1: ruleDpfId returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '@' ( (lv_id_2_0= RULE_INT ) ) )? ) ;
    public final EObject ruleDpfId() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token lv_id_2_0=null;

         enterRule(); 
            
        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2676:28: ( ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '@' ( (lv_id_2_0= RULE_INT ) ) )? ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2677:1: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '@' ( (lv_id_2_0= RULE_INT ) ) )? )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2677:1: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '@' ( (lv_id_2_0= RULE_INT ) ) )? )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2677:2: ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '@' ( (lv_id_2_0= RULE_INT ) ) )?
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2677:2: ( (lv_name_0_0= RULE_ID ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2678:1: (lv_name_0_0= RULE_ID )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2678:1: (lv_name_0_0= RULE_ID )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2679:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDpfId5683); 

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

            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2695:2: (otherlv_1= '@' ( (lv_id_2_0= RULE_INT ) ) )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==42) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2695:4: otherlv_1= '@' ( (lv_id_2_0= RULE_INT ) )
                    {
                    otherlv_1=(Token)match(input,42,FOLLOW_42_in_ruleDpfId5701); 

                        	newLeafNode(otherlv_1, grammarAccess.getDpfIdAccess().getCommercialAtKeyword_1_0());
                        
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2699:1: ( (lv_id_2_0= RULE_INT ) )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2700:1: (lv_id_2_0= RULE_INT )
                    {
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2700:1: (lv_id_2_0= RULE_INT )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2701:3: lv_id_2_0= RULE_INT
                    {
                    lv_id_2_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleDpfId5718); 

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
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2725:1: ruleDataType returns [Enumerator current=null] : ( (enumLiteral_0= 'Boolean' ) | (enumLiteral_1= 'Char' ) | (enumLiteral_2= 'Byte' ) | (enumLiteral_3= 'Short' ) | (enumLiteral_4= 'Int' ) | (enumLiteral_5= 'Long' ) | (enumLiteral_6= 'Float' ) | (enumLiteral_7= 'Double' ) | (enumLiteral_8= 'String' ) ) ;
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
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2727:28: ( ( (enumLiteral_0= 'Boolean' ) | (enumLiteral_1= 'Char' ) | (enumLiteral_2= 'Byte' ) | (enumLiteral_3= 'Short' ) | (enumLiteral_4= 'Int' ) | (enumLiteral_5= 'Long' ) | (enumLiteral_6= 'Float' ) | (enumLiteral_7= 'Double' ) | (enumLiteral_8= 'String' ) ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2728:1: ( (enumLiteral_0= 'Boolean' ) | (enumLiteral_1= 'Char' ) | (enumLiteral_2= 'Byte' ) | (enumLiteral_3= 'Short' ) | (enumLiteral_4= 'Int' ) | (enumLiteral_5= 'Long' ) | (enumLiteral_6= 'Float' ) | (enumLiteral_7= 'Double' ) | (enumLiteral_8= 'String' ) )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2728:1: ( (enumLiteral_0= 'Boolean' ) | (enumLiteral_1= 'Char' ) | (enumLiteral_2= 'Byte' ) | (enumLiteral_3= 'Short' ) | (enumLiteral_4= 'Int' ) | (enumLiteral_5= 'Long' ) | (enumLiteral_6= 'Float' ) | (enumLiteral_7= 'Double' ) | (enumLiteral_8= 'String' ) )
            int alt21=9;
            switch ( input.LA(1) ) {
            case 43:
                {
                alt21=1;
                }
                break;
            case 44:
                {
                alt21=2;
                }
                break;
            case 45:
                {
                alt21=3;
                }
                break;
            case 46:
                {
                alt21=4;
                }
                break;
            case 47:
                {
                alt21=5;
                }
                break;
            case 48:
                {
                alt21=6;
                }
                break;
            case 49:
                {
                alt21=7;
                }
                break;
            case 50:
                {
                alt21=8;
                }
                break;
            case 51:
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
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2728:2: (enumLiteral_0= 'Boolean' )
                    {
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2728:2: (enumLiteral_0= 'Boolean' )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2728:4: enumLiteral_0= 'Boolean'
                    {
                    enumLiteral_0=(Token)match(input,43,FOLLOW_43_in_ruleDataType5775); 

                            current = grammarAccess.getDataTypeAccess().getTBOOLEANEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getDataTypeAccess().getTBOOLEANEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2734:6: (enumLiteral_1= 'Char' )
                    {
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2734:6: (enumLiteral_1= 'Char' )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2734:8: enumLiteral_1= 'Char'
                    {
                    enumLiteral_1=(Token)match(input,44,FOLLOW_44_in_ruleDataType5792); 

                            current = grammarAccess.getDataTypeAccess().getTCHAREnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getDataTypeAccess().getTCHAREnumLiteralDeclaration_1()); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2740:6: (enumLiteral_2= 'Byte' )
                    {
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2740:6: (enumLiteral_2= 'Byte' )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2740:8: enumLiteral_2= 'Byte'
                    {
                    enumLiteral_2=(Token)match(input,45,FOLLOW_45_in_ruleDataType5809); 

                            current = grammarAccess.getDataTypeAccess().getTBYTEEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_2, grammarAccess.getDataTypeAccess().getTBYTEEnumLiteralDeclaration_2()); 
                        

                    }


                    }
                    break;
                case 4 :
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2746:6: (enumLiteral_3= 'Short' )
                    {
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2746:6: (enumLiteral_3= 'Short' )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2746:8: enumLiteral_3= 'Short'
                    {
                    enumLiteral_3=(Token)match(input,46,FOLLOW_46_in_ruleDataType5826); 

                            current = grammarAccess.getDataTypeAccess().getTSHORTEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_3, grammarAccess.getDataTypeAccess().getTSHORTEnumLiteralDeclaration_3()); 
                        

                    }


                    }
                    break;
                case 5 :
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2752:6: (enumLiteral_4= 'Int' )
                    {
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2752:6: (enumLiteral_4= 'Int' )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2752:8: enumLiteral_4= 'Int'
                    {
                    enumLiteral_4=(Token)match(input,47,FOLLOW_47_in_ruleDataType5843); 

                            current = grammarAccess.getDataTypeAccess().getTINTEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_4, grammarAccess.getDataTypeAccess().getTINTEnumLiteralDeclaration_4()); 
                        

                    }


                    }
                    break;
                case 6 :
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2758:6: (enumLiteral_5= 'Long' )
                    {
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2758:6: (enumLiteral_5= 'Long' )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2758:8: enumLiteral_5= 'Long'
                    {
                    enumLiteral_5=(Token)match(input,48,FOLLOW_48_in_ruleDataType5860); 

                            current = grammarAccess.getDataTypeAccess().getTLONGEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_5, grammarAccess.getDataTypeAccess().getTLONGEnumLiteralDeclaration_5()); 
                        

                    }


                    }
                    break;
                case 7 :
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2764:6: (enumLiteral_6= 'Float' )
                    {
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2764:6: (enumLiteral_6= 'Float' )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2764:8: enumLiteral_6= 'Float'
                    {
                    enumLiteral_6=(Token)match(input,49,FOLLOW_49_in_ruleDataType5877); 

                            current = grammarAccess.getDataTypeAccess().getTFLOATEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_6, grammarAccess.getDataTypeAccess().getTFLOATEnumLiteralDeclaration_6()); 
                        

                    }


                    }
                    break;
                case 8 :
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2770:6: (enumLiteral_7= 'Double' )
                    {
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2770:6: (enumLiteral_7= 'Double' )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2770:8: enumLiteral_7= 'Double'
                    {
                    enumLiteral_7=(Token)match(input,50,FOLLOW_50_in_ruleDataType5894); 

                            current = grammarAccess.getDataTypeAccess().getTDOUBLEEnumLiteralDeclaration_7().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_7, grammarAccess.getDataTypeAccess().getTDOUBLEEnumLiteralDeclaration_7()); 
                        

                    }


                    }
                    break;
                case 9 :
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2776:6: (enumLiteral_8= 'String' )
                    {
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2776:6: (enumLiteral_8= 'String' )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2776:8: enumLiteral_8= 'String'
                    {
                    enumLiteral_8=(Token)match(input,51,FOLLOW_51_in_ruleDataType5911); 

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
        "\1\25\1\30\3\uffff\2\7\1\44\1\23\1\27\11\uffff";
    static final String DFA4_acceptS =
        "\2\uffff\1\5\1\6\1\7\5\uffff\1\12\1\3\1\1\1\2\1\4\1\10\1\11\1\13"+
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
            "\1\14\5\uffff\1\15\1\uffff\1\12\1\uffff\1\16\1\13",
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
        "\1\7\1\46\1\10\1\7\1\46\1\42\1\10\2\uffff\1\42";
    static final String DFA14_maxS =
        "\1\7\1\52\1\10\1\7\1\46\1\52\1\10\2\uffff\1\45";
    static final String DFA14_acceptS =
        "\7\uffff\1\1\1\2\1\uffff";
    static final String DFA14_specialS =
        "\12\uffff}>";
    static final String[] DFA14_transitionS = {
            "\1\1",
            "\1\3\3\uffff\1\2",
            "\1\4",
            "\1\5",
            "\1\3",
            "\1\7\2\uffff\1\10\4\uffff\1\6",
            "\1\11",
            "",
            "",
            "\1\7\2\uffff\1\10"
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
            return "1707:1: (this_MappingNode_0= ruleMappingNode | this_MappingArrow_1= ruleMappingArrow )";
        }
    }
    static final String DFA17_eotS =
        "\12\uffff";
    static final String DFA17_eofS =
        "\12\uffff";
    static final String DFA17_minS =
        "\1\7\1\46\1\10\1\7\1\46\1\24\1\10\2\uffff\1\24";
    static final String DFA17_maxS =
        "\1\7\1\52\1\10\1\7\1\46\1\52\1\10\2\uffff\1\45";
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
            "\1\10\20\uffff\1\7\4\uffff\1\6",
            "\1\11",
            "",
            "",
            "\1\10\20\uffff\1\7"
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
            return "2145:1: ( (this_Node_0= ruleNode otherlv_1= ',' ) | (this_Arrows_2= ruleArrows otherlv_3= ',' ) )";
        }
    }
    static final String DFA18_eotS =
        "\32\uffff";
    static final String DFA18_eofS =
        "\26\uffff\1\16\2\uffff\1\16";
    static final String DFA18_minS =
        "\1\7\1\46\1\10\1\7\1\46\1\45\1\10\1\7\1\45\1\46\1\10\1\7\1\46\1"+
        "\23\1\uffff\1\10\1\7\1\23\1\46\1\10\1\7\1\46\1\24\1\10\1\uffff\1"+
        "\24";
    static final String DFA18_maxS =
        "\1\7\1\52\1\10\1\7\1\46\1\52\1\10\1\7\1\45\1\52\1\10\1\47\1\46\1"+
        "\52\1\uffff\1\10\1\50\1\23\1\52\1\10\1\7\1\46\1\52\1\10\1\uffff"+
        "\1\45";
    static final String DFA18_acceptS =
        "\16\uffff\1\2\11\uffff\1\1\1\uffff";
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
            "\1\15\37\uffff\1\16",
            "\1\13",
            "\1\20\26\uffff\1\17",
            "",
            "\1\21",
            "\1\22\40\uffff\1\16",
            "\1\20",
            "\1\24\3\uffff\1\23",
            "\1\25",
            "\1\26",
            "\1\24",
            "\1\16\10\uffff\1\16\7\uffff\1\30\4\uffff\1\27",
            "\1\31",
            "",
            "\1\16\10\uffff\1\16\7\uffff\1\30"
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
            return "2193:1: ( ( ( (lv_sr_0_0= ruleNode ) ) otherlv_1= '-' ( (lv_id_2_0= ruleDpfId ) ) otherlv_3= ':' ( (lv_type_4_0= ruleDpfId ) ) otherlv_5= '->' ( (lv_next_6_0= ruleArrows ) ) ) | this_Arrow_7= ruleArrow )";
        }
    }
    static final String DFA19_eotS =
        "\24\uffff";
    static final String DFA19_eofS =
        "\24\uffff";
    static final String DFA19_minS =
        "\1\7\1\46\1\10\1\7\1\46\1\45\1\10\1\7\1\45\1\46\1\10\1\7\1\46\1"+
        "\uffff\1\23\1\10\1\7\1\23\2\uffff";
    static final String DFA19_maxS =
        "\1\7\1\52\1\10\1\7\1\46\1\52\1\10\1\7\1\45\1\52\1\10\1\47\1\46\1"+
        "\uffff\1\52\1\10\1\50\1\23\2\uffff";
    static final String DFA19_acceptS =
        "\15\uffff\1\1\4\uffff\1\2\1\3";
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
            "\1\16\37\uffff\1\15",
            "\1\13",
            "",
            "\1\20\26\uffff\1\17",
            "\1\21",
            "\1\23\40\uffff\1\22",
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
            return "2308:1: ( ( ( (lv_sr_0_0= ruleNode ) ) otherlv_1= '-' ( (lv_id_2_0= ruleDpfId ) ) otherlv_3= ':' otherlv_4= '*' otherlv_5= '->' ( (lv_tgDataType_6_0= ruleDataType ) ) ) | ( ( (lv_sr_7_0= ruleNode ) ) otherlv_8= '-' ( (lv_id_9_0= ruleDpfId ) ) otherlv_10= ':' ( (lv_type_11_0= ruleDpfId ) ) otherlv_12= '->' ( (lv_tgValue_13_0= ruleAttributeValue ) ) ) | ( ( (lv_sr_14_0= ruleNode ) ) otherlv_15= '-' ( (lv_id_16_0= ruleDpfId ) ) otherlv_17= ':' ( (lv_type_18_0= ruleDpfId ) ) otherlv_19= '->' ( (lv_tgNode_20_0= ruleNode ) ) ) )";
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
    public static final BitSet FOLLOW_25_in_ruleInstanceSpecification1968 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_ruleInstanceSpecification1980 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ruleChoosenSpecfication_in_ruleInstanceSpecification2001 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleInstanceSpecification2013 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ruleChoosenSpecfication_in_ruleInstanceSpecification2034 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_ruleInstanceSpecification2046 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_ruleInstanceSpecification2058 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ruleConstraintSemantic_in_ruleInstanceSpecification2080 = new BitSet(new long[]{0x0000000020100000L});
    public static final BitSet FOLLOW_20_in_ruleInstanceSpecification2093 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ruleConstraintSemantic_in_ruleInstanceSpecification2114 = new BitSet(new long[]{0x0000000020100000L});
    public static final BitSet FOLLOW_29_in_ruleInstanceSpecification2129 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleChoosenSpecfication_in_entryRuleChoosenSpecfication2165 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleChoosenSpecfication2175 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleChoosenSpecfication2216 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConstraintSemantic_in_entryRuleConstraintSemantic2256 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConstraintSemantic2266 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDpfId_in_ruleConstraintSemantic2312 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_ruleConstraintSemantic2324 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ruleArrows_in_ruleConstraintSemantic2346 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleConstraintSemantic2359 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ruleArrows_in_ruleConstraintSemantic2380 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleConstraintSemantic2395 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_ruleConstraintSemantic2407 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_ruleConstraintSemantic2419 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleConstraintSemantic2436 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSpecification_in_entryRuleSpecification2477 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSpecification2487 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSpecification2529 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleSpecification2546 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_ruleSpecification2558 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_ruleSpecification2570 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ruleChoosenGraph_in_ruleSpecification2591 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_ruleSpecification2603 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_ruleSpecification2615 = new BitSet(new long[]{0x0000000020000080L});
    public static final BitSet FOLLOW_ruleConstraint_in_ruleSpecification2637 = new BitSet(new long[]{0x0000000020100000L});
    public static final BitSet FOLLOW_20_in_ruleSpecification2650 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ruleConstraint_in_ruleSpecification2671 = new BitSet(new long[]{0x0000000020100000L});
    public static final BitSet FOLLOW_29_in_ruleSpecification2687 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleChoosenGraph_in_entryRuleChoosenGraph2723 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleChoosenGraph2733 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleChoosenGraph2774 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConstraint_in_entryRuleConstraint2814 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConstraint2824 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConstraintSignature_in_ruleConstraint2870 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_ruleConstraint2882 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ruleArrows_in_ruleConstraint2904 = new BitSet(new long[]{0x0000000020100000L});
    public static final BitSet FOLLOW_20_in_ruleConstraint2917 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ruleArrows_in_ruleConstraint2938 = new BitSet(new long[]{0x0000000020100000L});
    public static final BitSet FOLLOW_29_in_ruleConstraint2953 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConstraintSignature_in_entryRuleConstraintSignature2989 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConstraintSignature2999 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDpfId_in_ruleConstraintSignature3045 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_ruleConstraintSignature3057 = new BitSet(new long[]{0x0000000000004080L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleConstraintSignature3075 = new BitSet(new long[]{0x0000000000104000L});
    public static final BitSet FOLLOW_20_in_ruleConstraintSignature3093 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleConstraintSignature3110 = new BitSet(new long[]{0x0000000000104000L});
    public static final BitSet FOLLOW_14_in_ruleConstraintSignature3131 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMorphism_in_entryRuleMorphism3167 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMorphism3177 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleMorphism3213 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleMorphism3224 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_ruleMorphism3236 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_ruleMorphism3248 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ruleDomain_in_ruleMorphism3269 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleMorphism3281 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ruleCodomain_in_ruleMorphism3302 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_ruleMorphism3314 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_ruleMorphism3326 = new BitSet(new long[]{0x0000000020000080L});
    public static final BitSet FOLLOW_ruleMapping_in_ruleMorphism3348 = new BitSet(new long[]{0x0000000020100000L});
    public static final BitSet FOLLOW_20_in_ruleMorphism3361 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ruleMapping_in_ruleMorphism3382 = new BitSet(new long[]{0x0000000020100000L});
    public static final BitSet FOLLOW_29_in_ruleMorphism3398 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDomain_in_entryRuleDomain3434 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDomain3444 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDomain3485 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCodomain_in_entryRuleCodomain3525 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCodomain3535 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleCodomain3576 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMapping_in_entryRuleMapping3616 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMapping3626 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMappingNode_in_ruleMapping3673 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMappingArrow_in_ruleMapping3700 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMappingNode_in_entryRuleMappingNode3735 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMappingNode3745 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNode_in_ruleMappingNode3791 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_ruleMappingNode3803 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ruleNode_in_ruleMappingNode3824 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMappingArrow_in_entryRuleMappingArrow3860 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMappingArrow3870 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArrow_in_ruleMappingArrow3916 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_ruleMappingArrow3928 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ruleArrow_in_ruleMappingArrow3949 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExtSubTGraph_in_entryRuleExtSubTGraph3985 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExtSubTGraph3995 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleExtSubTGraph4037 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleExtSubTGraph4054 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_ruleExtSubTGraph4066 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_ruleExtSubTGraph4078 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ruleTGraphExtSubName_in_ruleExtSubTGraph4099 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_ruleExtSubTGraph4111 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_ruleExtSubTGraph4123 = new BitSet(new long[]{0x0000000020000080L});
    public static final BitSet FOLLOW_ruleElement_in_ruleExtSubTGraph4144 = new BitSet(new long[]{0x0000000020000080L});
    public static final BitSet FOLLOW_29_in_ruleExtSubTGraph4157 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTGraphExtSubName_in_entryRuleTGraphExtSubName4193 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTGraphExtSubName4203 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTGraphExtSubName4244 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTGraph_in_entryRuleTGraph4284 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTGraph4294 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTGraph4336 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleTGraph4353 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_ruleTGraph4365 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_ruleTGraph4377 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ruleTGraphName_in_ruleTGraph4398 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_ruleTGraph4410 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_ruleTGraph4422 = new BitSet(new long[]{0x0000000020000080L});
    public static final BitSet FOLLOW_ruleElement_in_ruleTGraph4443 = new BitSet(new long[]{0x0000000020000080L});
    public static final BitSet FOLLOW_29_in_ruleTGraph4456 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTGraphName_in_entryRuleTGraphName4492 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTGraphName4502 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTGraphName4543 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleElement_in_entryRuleElement4583 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleElement4593 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNode_in_ruleElement4641 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleElement4652 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArrows_in_ruleElement4682 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleElement4693 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArrows_in_entryRuleArrows4730 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleArrows4740 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNode_in_ruleArrows4787 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_37_in_ruleArrows4799 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ruleDpfId_in_ruleArrows4820 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_38_in_ruleArrows4832 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ruleDpfId_in_ruleArrows4853 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleArrows4865 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ruleArrows_in_ruleArrows4886 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArrow_in_ruleArrows4915 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArrow_in_entryRuleArrow4950 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleArrow4960 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNode_in_ruleArrow5007 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_37_in_ruleArrow5019 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ruleDpfId_in_ruleArrow5040 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_38_in_ruleArrow5052 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_ruleArrow5064 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleArrow5076 = new BitSet(new long[]{0x000FF80000000000L});
    public static final BitSet FOLLOW_ruleDataType_in_ruleArrow5097 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNode_in_ruleArrow5126 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_37_in_ruleArrow5138 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ruleDpfId_in_ruleArrow5159 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_38_in_ruleArrow5171 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ruleDpfId_in_ruleArrow5192 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleArrow5204 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_ruleAttributeValue_in_ruleArrow5225 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNode_in_ruleArrow5254 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_37_in_ruleArrow5266 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ruleDpfId_in_ruleArrow5287 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_38_in_ruleArrow5299 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ruleDpfId_in_ruleArrow5320 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleArrow5332 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ruleNode_in_ruleArrow5353 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNode_in_entryRuleNode5390 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNode5400 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDpfId_in_ruleNode5446 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_38_in_ruleNode5458 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ruleDpfId_in_ruleNode5479 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAttributeValue_in_entryRuleAttributeValue5515 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAttributeValue5525 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_ruleAttributeValue5562 = new BitSet(new long[]{0x0000000000000070L});
    public static final BitSet FOLLOW_ruleVALUE_in_ruleAttributeValue5583 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_ruleAttributeValue5595 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDpfId_in_entryRuleDpfId5631 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDpfId5641 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDpfId5683 = new BitSet(new long[]{0x0000040000000002L});
    public static final BitSet FOLLOW_42_in_ruleDpfId5701 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleDpfId5718 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_ruleDataType5775 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_ruleDataType5792 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_ruleDataType5809 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_ruleDataType5826 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_ruleDataType5843 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_ruleDataType5860 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_ruleDataType5877 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_ruleDataType5894 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_ruleDataType5911 = new BitSet(new long[]{0x0000000000000002L});

}