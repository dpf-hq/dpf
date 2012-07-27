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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_NUMBER", "RULE_CHAR", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ANY_OTHER", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "'emf('", "')'", "'ecore('", "'image('", "'simpleEvolution('", "'<-'", "'->'", "','", "'evolution('", "'<->'", "'-><-'", "'Specification'", "':'", "'('", "'<'", "'>'", "'{'", "'Constraints'", "'}'", "'='", "':='", "'Morphism'", "'=>'", "'ExtSubTGraph'", "'Graph'", "'-'", "'*'", "'['", "']'", "'@'", "'Boolean'", "'Char'", "'Byte'", "'Short'", "'Int'", "'Long'", "'Float'", "'Double'", "'String'"
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
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:77:1: ruleModel returns [EObject current=null] : (this_Specification_0= ruleSpecification | this_Signature_1= ruleSignature | ( ( (lv_commands_2_0= ruleCommand ) ) ( (lv_commands_3_0= ruleCommand ) )* )? ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject this_Specification_0 = null;

        EObject this_Signature_1 = null;

        EObject lv_commands_2_0 = null;

        EObject lv_commands_3_0 = null;


         enterRule(); 
            
        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:80:28: ( (this_Specification_0= ruleSpecification | this_Signature_1= ruleSignature | ( ( (lv_commands_2_0= ruleCommand ) ) ( (lv_commands_3_0= ruleCommand ) )* )? ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:81:1: (this_Specification_0= ruleSpecification | this_Signature_1= ruleSignature | ( ( (lv_commands_2_0= ruleCommand ) ) ( (lv_commands_3_0= ruleCommand ) )* )? )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:81:1: (this_Specification_0= ruleSpecification | this_Signature_1= ruleSignature | ( ( (lv_commands_2_0= ruleCommand ) ) ( (lv_commands_3_0= ruleCommand ) )* )? )
            int alt3=3;
            switch ( input.LA(1) ) {
            case 24:
                {
                alt3=1;
                }
                break;
            case RULE_ID:
                {
                int LA3_2 = input.LA(2);

                if ( (LA3_2==33) ) {
                    alt3=3;
                }
                else if ( (LA3_2==29||LA3_2==42) ) {
                    alt3=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 3, 2, input);

                    throw nvae;
                }
                }
                break;
            case EOF:
            case 13:
            case 15:
            case 16:
            case 17:
            case 21:
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
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:82:5: this_Specification_0= ruleSpecification
                    {
                     
                            newCompositeNode(grammarAccess.getModelAccess().getSpecificationParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleSpecification_in_ruleModel132);
                    this_Specification_0=ruleSpecification();

                    state._fsp--;

                     
                            current = this_Specification_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:92:5: this_Signature_1= ruleSignature
                    {
                     
                            newCompositeNode(grammarAccess.getModelAccess().getSignatureParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleSignature_in_ruleModel159);
                    this_Signature_1=ruleSignature();

                    state._fsp--;

                     
                            current = this_Signature_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:101:6: ( ( (lv_commands_2_0= ruleCommand ) ) ( (lv_commands_3_0= ruleCommand ) )* )?
                    {
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:101:6: ( ( (lv_commands_2_0= ruleCommand ) ) ( (lv_commands_3_0= ruleCommand ) )* )?
                    int alt2=2;
                    int LA2_0 = input.LA(1);

                    if ( (LA2_0==RULE_ID||LA2_0==13||(LA2_0>=15 && LA2_0<=17)||LA2_0==21) ) {
                        alt2=1;
                    }
                    switch (alt2) {
                        case 1 :
                            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:101:7: ( (lv_commands_2_0= ruleCommand ) ) ( (lv_commands_3_0= ruleCommand ) )*
                            {
                            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:101:7: ( (lv_commands_2_0= ruleCommand ) )
                            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:102:1: (lv_commands_2_0= ruleCommand )
                            {
                            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:102:1: (lv_commands_2_0= ruleCommand )
                            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:103:3: lv_commands_2_0= ruleCommand
                            {
                             
                            	        newCompositeNode(grammarAccess.getModelAccess().getCommandsCommandParserRuleCall_2_0_0()); 
                            	    
                            pushFollow(FOLLOW_ruleCommand_in_ruleModel186);
                            lv_commands_2_0=ruleCommand();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getModelRule());
                            	        }
                                   		add(
                                   			current, 
                                   			"commands",
                                    		lv_commands_2_0, 
                                    		"Command");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }

                            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:119:2: ( (lv_commands_3_0= ruleCommand ) )*
                            loop1:
                            do {
                                int alt1=2;
                                int LA1_0 = input.LA(1);

                                if ( (LA1_0==RULE_ID||LA1_0==13||(LA1_0>=15 && LA1_0<=17)||LA1_0==21) ) {
                                    alt1=1;
                                }


                                switch (alt1) {
                            	case 1 :
                            	    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:120:1: (lv_commands_3_0= ruleCommand )
                            	    {
                            	    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:120:1: (lv_commands_3_0= ruleCommand )
                            	    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:121:3: lv_commands_3_0= ruleCommand
                            	    {
                            	     
                            	    	        newCompositeNode(grammarAccess.getModelAccess().getCommandsCommandParserRuleCall_2_1_0()); 
                            	    	    
                            	    pushFollow(FOLLOW_ruleCommand_in_ruleModel207);
                            	    lv_commands_3_0=ruleCommand();

                            	    state._fsp--;


                            	    	        if (current==null) {
                            	    	            current = createModelElementForParent(grammarAccess.getModelRule());
                            	    	        }
                            	           		add(
                            	           			current, 
                            	           			"commands",
                            	            		lv_commands_3_0, 
                            	            		"Command");
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
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:145:1: entryRuleVALUE returns [String current=null] : iv_ruleVALUE= ruleVALUE EOF ;
    public final String entryRuleVALUE() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleVALUE = null;


        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:146:2: (iv_ruleVALUE= ruleVALUE EOF )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:147:2: iv_ruleVALUE= ruleVALUE EOF
            {
             newCompositeNode(grammarAccess.getVALUERule()); 
            pushFollow(FOLLOW_ruleVALUE_in_entryRuleVALUE247);
            iv_ruleVALUE=ruleVALUE();

            state._fsp--;

             current =iv_ruleVALUE.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVALUE258); 

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
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:154:1: ruleVALUE returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_NUMBER_0= RULE_NUMBER | this_CHAR_1= RULE_CHAR | this_STRING_2= RULE_STRING ) ;
    public final AntlrDatatypeRuleToken ruleVALUE() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_NUMBER_0=null;
        Token this_CHAR_1=null;
        Token this_STRING_2=null;

         enterRule(); 
            
        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:157:28: ( (this_NUMBER_0= RULE_NUMBER | this_CHAR_1= RULE_CHAR | this_STRING_2= RULE_STRING ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:158:1: (this_NUMBER_0= RULE_NUMBER | this_CHAR_1= RULE_CHAR | this_STRING_2= RULE_STRING )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:158:1: (this_NUMBER_0= RULE_NUMBER | this_CHAR_1= RULE_CHAR | this_STRING_2= RULE_STRING )
            int alt4=3;
            switch ( input.LA(1) ) {
            case RULE_NUMBER:
                {
                alt4=1;
                }
                break;
            case RULE_CHAR:
                {
                alt4=2;
                }
                break;
            case RULE_STRING:
                {
                alt4=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:158:6: this_NUMBER_0= RULE_NUMBER
                    {
                    this_NUMBER_0=(Token)match(input,RULE_NUMBER,FOLLOW_RULE_NUMBER_in_ruleVALUE298); 

                    		current.merge(this_NUMBER_0);
                        
                     
                        newLeafNode(this_NUMBER_0, grammarAccess.getVALUEAccess().getNUMBERTerminalRuleCall_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:166:10: this_CHAR_1= RULE_CHAR
                    {
                    this_CHAR_1=(Token)match(input,RULE_CHAR,FOLLOW_RULE_CHAR_in_ruleVALUE324); 

                    		current.merge(this_CHAR_1);
                        
                     
                        newLeafNode(this_CHAR_1, grammarAccess.getVALUEAccess().getCHARTerminalRuleCall_1()); 
                        

                    }
                    break;
                case 3 :
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:174:10: this_STRING_2= RULE_STRING
                    {
                    this_STRING_2=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleVALUE350); 

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


    // $ANTLR start "entryRuleCommand"
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:189:1: entryRuleCommand returns [EObject current=null] : iv_ruleCommand= ruleCommand EOF ;
    public final EObject entryRuleCommand() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCommand = null;


        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:190:2: (iv_ruleCommand= ruleCommand EOF )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:191:2: iv_ruleCommand= ruleCommand EOF
            {
             newCompositeNode(grammarAccess.getCommandRule()); 
            pushFollow(FOLLOW_ruleCommand_in_entryRuleCommand395);
            iv_ruleCommand=ruleCommand();

            state._fsp--;

             current =iv_ruleCommand; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCommand405); 

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
    // $ANTLR end "entryRuleCommand"


    // $ANTLR start "ruleCommand"
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:198:1: ruleCommand returns [EObject current=null] : (this_MakeEmf_0= ruleMakeEmf | this_MakeEcore_1= ruleMakeEcore | this_MakeImage_2= ruleMakeImage | this_ExtSubTGraph_3= ruleExtSubTGraph | this_SimpleEvoSpan_4= ruleSimpleEvoSpan | this_SimpleEvoCospan_5= ruleSimpleEvoCospan | this_Morphism_6= ruleMorphism | this_EvoSpan_7= ruleEvoSpan | this_EvoCospan_8= ruleEvoCospan ) ;
    public final EObject ruleCommand() throws RecognitionException {
        EObject current = null;

        EObject this_MakeEmf_0 = null;

        EObject this_MakeEcore_1 = null;

        EObject this_MakeImage_2 = null;

        EObject this_ExtSubTGraph_3 = null;

        EObject this_SimpleEvoSpan_4 = null;

        EObject this_SimpleEvoCospan_5 = null;

        EObject this_Morphism_6 = null;

        EObject this_EvoSpan_7 = null;

        EObject this_EvoCospan_8 = null;


         enterRule(); 
            
        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:201:28: ( (this_MakeEmf_0= ruleMakeEmf | this_MakeEcore_1= ruleMakeEcore | this_MakeImage_2= ruleMakeImage | this_ExtSubTGraph_3= ruleExtSubTGraph | this_SimpleEvoSpan_4= ruleSimpleEvoSpan | this_SimpleEvoCospan_5= ruleSimpleEvoCospan | this_Morphism_6= ruleMorphism | this_EvoSpan_7= ruleEvoSpan | this_EvoCospan_8= ruleEvoCospan ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:202:1: (this_MakeEmf_0= ruleMakeEmf | this_MakeEcore_1= ruleMakeEcore | this_MakeImage_2= ruleMakeImage | this_ExtSubTGraph_3= ruleExtSubTGraph | this_SimpleEvoSpan_4= ruleSimpleEvoSpan | this_SimpleEvoCospan_5= ruleSimpleEvoCospan | this_Morphism_6= ruleMorphism | this_EvoSpan_7= ruleEvoSpan | this_EvoCospan_8= ruleEvoCospan )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:202:1: (this_MakeEmf_0= ruleMakeEmf | this_MakeEcore_1= ruleMakeEcore | this_MakeImage_2= ruleMakeImage | this_ExtSubTGraph_3= ruleExtSubTGraph | this_SimpleEvoSpan_4= ruleSimpleEvoSpan | this_SimpleEvoCospan_5= ruleSimpleEvoCospan | this_Morphism_6= ruleMorphism | this_EvoSpan_7= ruleEvoSpan | this_EvoCospan_8= ruleEvoCospan )
            int alt5=9;
            alt5 = dfa5.predict(input);
            switch (alt5) {
                case 1 :
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:203:5: this_MakeEmf_0= ruleMakeEmf
                    {
                     
                            newCompositeNode(grammarAccess.getCommandAccess().getMakeEmfParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleMakeEmf_in_ruleCommand452);
                    this_MakeEmf_0=ruleMakeEmf();

                    state._fsp--;

                     
                            current = this_MakeEmf_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:213:5: this_MakeEcore_1= ruleMakeEcore
                    {
                     
                            newCompositeNode(grammarAccess.getCommandAccess().getMakeEcoreParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleMakeEcore_in_ruleCommand479);
                    this_MakeEcore_1=ruleMakeEcore();

                    state._fsp--;

                     
                            current = this_MakeEcore_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:223:5: this_MakeImage_2= ruleMakeImage
                    {
                     
                            newCompositeNode(grammarAccess.getCommandAccess().getMakeImageParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleMakeImage_in_ruleCommand506);
                    this_MakeImage_2=ruleMakeImage();

                    state._fsp--;

                     
                            current = this_MakeImage_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:233:5: this_ExtSubTGraph_3= ruleExtSubTGraph
                    {
                     
                            newCompositeNode(grammarAccess.getCommandAccess().getExtSubTGraphParserRuleCall_3()); 
                        
                    pushFollow(FOLLOW_ruleExtSubTGraph_in_ruleCommand533);
                    this_ExtSubTGraph_3=ruleExtSubTGraph();

                    state._fsp--;

                     
                            current = this_ExtSubTGraph_3; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 5 :
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:243:5: this_SimpleEvoSpan_4= ruleSimpleEvoSpan
                    {
                     
                            newCompositeNode(grammarAccess.getCommandAccess().getSimpleEvoSpanParserRuleCall_4()); 
                        
                    pushFollow(FOLLOW_ruleSimpleEvoSpan_in_ruleCommand560);
                    this_SimpleEvoSpan_4=ruleSimpleEvoSpan();

                    state._fsp--;

                     
                            current = this_SimpleEvoSpan_4; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 6 :
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:253:5: this_SimpleEvoCospan_5= ruleSimpleEvoCospan
                    {
                     
                            newCompositeNode(grammarAccess.getCommandAccess().getSimpleEvoCospanParserRuleCall_5()); 
                        
                    pushFollow(FOLLOW_ruleSimpleEvoCospan_in_ruleCommand587);
                    this_SimpleEvoCospan_5=ruleSimpleEvoCospan();

                    state._fsp--;

                     
                            current = this_SimpleEvoCospan_5; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 7 :
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:263:5: this_Morphism_6= ruleMorphism
                    {
                     
                            newCompositeNode(grammarAccess.getCommandAccess().getMorphismParserRuleCall_6()); 
                        
                    pushFollow(FOLLOW_ruleMorphism_in_ruleCommand614);
                    this_Morphism_6=ruleMorphism();

                    state._fsp--;

                     
                            current = this_Morphism_6; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 8 :
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:273:5: this_EvoSpan_7= ruleEvoSpan
                    {
                     
                            newCompositeNode(grammarAccess.getCommandAccess().getEvoSpanParserRuleCall_7()); 
                        
                    pushFollow(FOLLOW_ruleEvoSpan_in_ruleCommand641);
                    this_EvoSpan_7=ruleEvoSpan();

                    state._fsp--;

                     
                            current = this_EvoSpan_7; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 9 :
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:283:5: this_EvoCospan_8= ruleEvoCospan
                    {
                     
                            newCompositeNode(grammarAccess.getCommandAccess().getEvoCospanParserRuleCall_8()); 
                        
                    pushFollow(FOLLOW_ruleEvoCospan_in_ruleCommand668);
                    this_EvoCospan_8=ruleEvoCospan();

                    state._fsp--;

                     
                            current = this_EvoCospan_8; 
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
    // $ANTLR end "ruleCommand"


    // $ANTLR start "entryRuleMakeEmf"
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:299:1: entryRuleMakeEmf returns [EObject current=null] : iv_ruleMakeEmf= ruleMakeEmf EOF ;
    public final EObject entryRuleMakeEmf() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMakeEmf = null;


        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:300:2: (iv_ruleMakeEmf= ruleMakeEmf EOF )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:301:2: iv_ruleMakeEmf= ruleMakeEmf EOF
            {
             newCompositeNode(grammarAccess.getMakeEmfRule()); 
            pushFollow(FOLLOW_ruleMakeEmf_in_entryRuleMakeEmf703);
            iv_ruleMakeEmf=ruleMakeEmf();

            state._fsp--;

             current =iv_ruleMakeEmf; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMakeEmf713); 

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
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:308:1: ruleMakeEmf returns [EObject current=null] : (otherlv_0= 'emf(' ( (lv_id_1_0= RULE_ID ) ) otherlv_2= ')' ) ;
    public final EObject ruleMakeEmf() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_id_1_0=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:311:28: ( (otherlv_0= 'emf(' ( (lv_id_1_0= RULE_ID ) ) otherlv_2= ')' ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:312:1: (otherlv_0= 'emf(' ( (lv_id_1_0= RULE_ID ) ) otherlv_2= ')' )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:312:1: (otherlv_0= 'emf(' ( (lv_id_1_0= RULE_ID ) ) otherlv_2= ')' )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:312:3: otherlv_0= 'emf(' ( (lv_id_1_0= RULE_ID ) ) otherlv_2= ')'
            {
            otherlv_0=(Token)match(input,13,FOLLOW_13_in_ruleMakeEmf750); 

                	newLeafNode(otherlv_0, grammarAccess.getMakeEmfAccess().getEmfKeyword_0());
                
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:316:1: ( (lv_id_1_0= RULE_ID ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:317:1: (lv_id_1_0= RULE_ID )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:317:1: (lv_id_1_0= RULE_ID )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:318:3: lv_id_1_0= RULE_ID
            {
            lv_id_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleMakeEmf767); 

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

            otherlv_2=(Token)match(input,14,FOLLOW_14_in_ruleMakeEmf784); 

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
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:346:1: entryRuleMakeEcore returns [EObject current=null] : iv_ruleMakeEcore= ruleMakeEcore EOF ;
    public final EObject entryRuleMakeEcore() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMakeEcore = null;


        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:347:2: (iv_ruleMakeEcore= ruleMakeEcore EOF )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:348:2: iv_ruleMakeEcore= ruleMakeEcore EOF
            {
             newCompositeNode(grammarAccess.getMakeEcoreRule()); 
            pushFollow(FOLLOW_ruleMakeEcore_in_entryRuleMakeEcore820);
            iv_ruleMakeEcore=ruleMakeEcore();

            state._fsp--;

             current =iv_ruleMakeEcore; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMakeEcore830); 

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
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:355:1: ruleMakeEcore returns [EObject current=null] : (otherlv_0= 'ecore(' ( (lv_id_1_0= RULE_ID ) ) otherlv_2= ')' ) ;
    public final EObject ruleMakeEcore() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_id_1_0=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:358:28: ( (otherlv_0= 'ecore(' ( (lv_id_1_0= RULE_ID ) ) otherlv_2= ')' ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:359:1: (otherlv_0= 'ecore(' ( (lv_id_1_0= RULE_ID ) ) otherlv_2= ')' )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:359:1: (otherlv_0= 'ecore(' ( (lv_id_1_0= RULE_ID ) ) otherlv_2= ')' )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:359:3: otherlv_0= 'ecore(' ( (lv_id_1_0= RULE_ID ) ) otherlv_2= ')'
            {
            otherlv_0=(Token)match(input,15,FOLLOW_15_in_ruleMakeEcore867); 

                	newLeafNode(otherlv_0, grammarAccess.getMakeEcoreAccess().getEcoreKeyword_0());
                
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:363:1: ( (lv_id_1_0= RULE_ID ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:364:1: (lv_id_1_0= RULE_ID )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:364:1: (lv_id_1_0= RULE_ID )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:365:3: lv_id_1_0= RULE_ID
            {
            lv_id_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleMakeEcore884); 

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

            otherlv_2=(Token)match(input,14,FOLLOW_14_in_ruleMakeEcore901); 

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
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:393:1: entryRuleMakeImage returns [EObject current=null] : iv_ruleMakeImage= ruleMakeImage EOF ;
    public final EObject entryRuleMakeImage() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMakeImage = null;


        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:394:2: (iv_ruleMakeImage= ruleMakeImage EOF )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:395:2: iv_ruleMakeImage= ruleMakeImage EOF
            {
             newCompositeNode(grammarAccess.getMakeImageRule()); 
            pushFollow(FOLLOW_ruleMakeImage_in_entryRuleMakeImage937);
            iv_ruleMakeImage=ruleMakeImage();

            state._fsp--;

             current =iv_ruleMakeImage; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMakeImage947); 

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
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:402:1: ruleMakeImage returns [EObject current=null] : (otherlv_0= 'image(' ( (lv_id_1_0= RULE_ID ) ) otherlv_2= ')' ) ;
    public final EObject ruleMakeImage() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_id_1_0=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:405:28: ( (otherlv_0= 'image(' ( (lv_id_1_0= RULE_ID ) ) otherlv_2= ')' ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:406:1: (otherlv_0= 'image(' ( (lv_id_1_0= RULE_ID ) ) otherlv_2= ')' )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:406:1: (otherlv_0= 'image(' ( (lv_id_1_0= RULE_ID ) ) otherlv_2= ')' )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:406:3: otherlv_0= 'image(' ( (lv_id_1_0= RULE_ID ) ) otherlv_2= ')'
            {
            otherlv_0=(Token)match(input,16,FOLLOW_16_in_ruleMakeImage984); 

                	newLeafNode(otherlv_0, grammarAccess.getMakeImageAccess().getImageKeyword_0());
                
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:410:1: ( (lv_id_1_0= RULE_ID ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:411:1: (lv_id_1_0= RULE_ID )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:411:1: (lv_id_1_0= RULE_ID )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:412:3: lv_id_1_0= RULE_ID
            {
            lv_id_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleMakeImage1001); 

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

            otherlv_2=(Token)match(input,14,FOLLOW_14_in_ruleMakeImage1018); 

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
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:440:1: entryRuleSimpleEvoSpan returns [EObject current=null] : iv_ruleSimpleEvoSpan= ruleSimpleEvoSpan EOF ;
    public final EObject entryRuleSimpleEvoSpan() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSimpleEvoSpan = null;


        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:441:2: (iv_ruleSimpleEvoSpan= ruleSimpleEvoSpan EOF )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:442:2: iv_ruleSimpleEvoSpan= ruleSimpleEvoSpan EOF
            {
             newCompositeNode(grammarAccess.getSimpleEvoSpanRule()); 
            pushFollow(FOLLOW_ruleSimpleEvoSpan_in_entryRuleSimpleEvoSpan1054);
            iv_ruleSimpleEvoSpan=ruleSimpleEvoSpan();

            state._fsp--;

             current =iv_ruleSimpleEvoSpan; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSimpleEvoSpan1064); 

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
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:449:1: ruleSimpleEvoSpan returns [EObject current=null] : (otherlv_0= 'simpleEvolution(' ( (lv_lhs_1_0= RULE_ID ) ) otherlv_2= '<-' ( (lv_diff_3_0= RULE_ID ) ) otherlv_4= '->' ( (lv_rhS_5_0= RULE_ID ) ) otherlv_6= ',' ( (lv_typeGraph_7_0= RULE_ID ) ) otherlv_8= ')' ) ;
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
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:452:28: ( (otherlv_0= 'simpleEvolution(' ( (lv_lhs_1_0= RULE_ID ) ) otherlv_2= '<-' ( (lv_diff_3_0= RULE_ID ) ) otherlv_4= '->' ( (lv_rhS_5_0= RULE_ID ) ) otherlv_6= ',' ( (lv_typeGraph_7_0= RULE_ID ) ) otherlv_8= ')' ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:453:1: (otherlv_0= 'simpleEvolution(' ( (lv_lhs_1_0= RULE_ID ) ) otherlv_2= '<-' ( (lv_diff_3_0= RULE_ID ) ) otherlv_4= '->' ( (lv_rhS_5_0= RULE_ID ) ) otherlv_6= ',' ( (lv_typeGraph_7_0= RULE_ID ) ) otherlv_8= ')' )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:453:1: (otherlv_0= 'simpleEvolution(' ( (lv_lhs_1_0= RULE_ID ) ) otherlv_2= '<-' ( (lv_diff_3_0= RULE_ID ) ) otherlv_4= '->' ( (lv_rhS_5_0= RULE_ID ) ) otherlv_6= ',' ( (lv_typeGraph_7_0= RULE_ID ) ) otherlv_8= ')' )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:453:3: otherlv_0= 'simpleEvolution(' ( (lv_lhs_1_0= RULE_ID ) ) otherlv_2= '<-' ( (lv_diff_3_0= RULE_ID ) ) otherlv_4= '->' ( (lv_rhS_5_0= RULE_ID ) ) otherlv_6= ',' ( (lv_typeGraph_7_0= RULE_ID ) ) otherlv_8= ')'
            {
            otherlv_0=(Token)match(input,17,FOLLOW_17_in_ruleSimpleEvoSpan1101); 

                	newLeafNode(otherlv_0, grammarAccess.getSimpleEvoSpanAccess().getSimpleEvolutionKeyword_0());
                
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:457:1: ( (lv_lhs_1_0= RULE_ID ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:458:1: (lv_lhs_1_0= RULE_ID )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:458:1: (lv_lhs_1_0= RULE_ID )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:459:3: lv_lhs_1_0= RULE_ID
            {
            lv_lhs_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSimpleEvoSpan1118); 

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

            otherlv_2=(Token)match(input,18,FOLLOW_18_in_ruleSimpleEvoSpan1135); 

                	newLeafNode(otherlv_2, grammarAccess.getSimpleEvoSpanAccess().getLessThanSignHyphenMinusKeyword_2());
                
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:479:1: ( (lv_diff_3_0= RULE_ID ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:480:1: (lv_diff_3_0= RULE_ID )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:480:1: (lv_diff_3_0= RULE_ID )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:481:3: lv_diff_3_0= RULE_ID
            {
            lv_diff_3_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSimpleEvoSpan1152); 

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

            otherlv_4=(Token)match(input,19,FOLLOW_19_in_ruleSimpleEvoSpan1169); 

                	newLeafNode(otherlv_4, grammarAccess.getSimpleEvoSpanAccess().getHyphenMinusGreaterThanSignKeyword_4());
                
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:501:1: ( (lv_rhS_5_0= RULE_ID ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:502:1: (lv_rhS_5_0= RULE_ID )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:502:1: (lv_rhS_5_0= RULE_ID )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:503:3: lv_rhS_5_0= RULE_ID
            {
            lv_rhS_5_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSimpleEvoSpan1186); 

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

            otherlv_6=(Token)match(input,20,FOLLOW_20_in_ruleSimpleEvoSpan1203); 

                	newLeafNode(otherlv_6, grammarAccess.getSimpleEvoSpanAccess().getCommaKeyword_6());
                
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:523:1: ( (lv_typeGraph_7_0= RULE_ID ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:524:1: (lv_typeGraph_7_0= RULE_ID )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:524:1: (lv_typeGraph_7_0= RULE_ID )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:525:3: lv_typeGraph_7_0= RULE_ID
            {
            lv_typeGraph_7_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSimpleEvoSpan1220); 

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

            otherlv_8=(Token)match(input,14,FOLLOW_14_in_ruleSimpleEvoSpan1237); 

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
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:553:1: entryRuleSimpleEvoCospan returns [EObject current=null] : iv_ruleSimpleEvoCospan= ruleSimpleEvoCospan EOF ;
    public final EObject entryRuleSimpleEvoCospan() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSimpleEvoCospan = null;


        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:554:2: (iv_ruleSimpleEvoCospan= ruleSimpleEvoCospan EOF )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:555:2: iv_ruleSimpleEvoCospan= ruleSimpleEvoCospan EOF
            {
             newCompositeNode(grammarAccess.getSimpleEvoCospanRule()); 
            pushFollow(FOLLOW_ruleSimpleEvoCospan_in_entryRuleSimpleEvoCospan1273);
            iv_ruleSimpleEvoCospan=ruleSimpleEvoCospan();

            state._fsp--;

             current =iv_ruleSimpleEvoCospan; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSimpleEvoCospan1283); 

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
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:562:1: ruleSimpleEvoCospan returns [EObject current=null] : (otherlv_0= 'simpleEvolution(' ( (lv_lhs_1_0= RULE_ID ) ) otherlv_2= '->' ( (lv_joint_3_0= RULE_ID ) ) otherlv_4= '<-' ( (lv_rhs_5_0= RULE_ID ) ) otherlv_6= ',' ( (lv_typeGraph_7_0= RULE_ID ) ) otherlv_8= ')' ) ;
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
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:565:28: ( (otherlv_0= 'simpleEvolution(' ( (lv_lhs_1_0= RULE_ID ) ) otherlv_2= '->' ( (lv_joint_3_0= RULE_ID ) ) otherlv_4= '<-' ( (lv_rhs_5_0= RULE_ID ) ) otherlv_6= ',' ( (lv_typeGraph_7_0= RULE_ID ) ) otherlv_8= ')' ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:566:1: (otherlv_0= 'simpleEvolution(' ( (lv_lhs_1_0= RULE_ID ) ) otherlv_2= '->' ( (lv_joint_3_0= RULE_ID ) ) otherlv_4= '<-' ( (lv_rhs_5_0= RULE_ID ) ) otherlv_6= ',' ( (lv_typeGraph_7_0= RULE_ID ) ) otherlv_8= ')' )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:566:1: (otherlv_0= 'simpleEvolution(' ( (lv_lhs_1_0= RULE_ID ) ) otherlv_2= '->' ( (lv_joint_3_0= RULE_ID ) ) otherlv_4= '<-' ( (lv_rhs_5_0= RULE_ID ) ) otherlv_6= ',' ( (lv_typeGraph_7_0= RULE_ID ) ) otherlv_8= ')' )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:566:3: otherlv_0= 'simpleEvolution(' ( (lv_lhs_1_0= RULE_ID ) ) otherlv_2= '->' ( (lv_joint_3_0= RULE_ID ) ) otherlv_4= '<-' ( (lv_rhs_5_0= RULE_ID ) ) otherlv_6= ',' ( (lv_typeGraph_7_0= RULE_ID ) ) otherlv_8= ')'
            {
            otherlv_0=(Token)match(input,17,FOLLOW_17_in_ruleSimpleEvoCospan1320); 

                	newLeafNode(otherlv_0, grammarAccess.getSimpleEvoCospanAccess().getSimpleEvolutionKeyword_0());
                
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:570:1: ( (lv_lhs_1_0= RULE_ID ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:571:1: (lv_lhs_1_0= RULE_ID )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:571:1: (lv_lhs_1_0= RULE_ID )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:572:3: lv_lhs_1_0= RULE_ID
            {
            lv_lhs_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSimpleEvoCospan1337); 

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

            otherlv_2=(Token)match(input,19,FOLLOW_19_in_ruleSimpleEvoCospan1354); 

                	newLeafNode(otherlv_2, grammarAccess.getSimpleEvoCospanAccess().getHyphenMinusGreaterThanSignKeyword_2());
                
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:592:1: ( (lv_joint_3_0= RULE_ID ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:593:1: (lv_joint_3_0= RULE_ID )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:593:1: (lv_joint_3_0= RULE_ID )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:594:3: lv_joint_3_0= RULE_ID
            {
            lv_joint_3_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSimpleEvoCospan1371); 

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

            otherlv_4=(Token)match(input,18,FOLLOW_18_in_ruleSimpleEvoCospan1388); 

                	newLeafNode(otherlv_4, grammarAccess.getSimpleEvoCospanAccess().getLessThanSignHyphenMinusKeyword_4());
                
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:614:1: ( (lv_rhs_5_0= RULE_ID ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:615:1: (lv_rhs_5_0= RULE_ID )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:615:1: (lv_rhs_5_0= RULE_ID )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:616:3: lv_rhs_5_0= RULE_ID
            {
            lv_rhs_5_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSimpleEvoCospan1405); 

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

            otherlv_6=(Token)match(input,20,FOLLOW_20_in_ruleSimpleEvoCospan1422); 

                	newLeafNode(otherlv_6, grammarAccess.getSimpleEvoCospanAccess().getCommaKeyword_6());
                
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:636:1: ( (lv_typeGraph_7_0= RULE_ID ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:637:1: (lv_typeGraph_7_0= RULE_ID )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:637:1: (lv_typeGraph_7_0= RULE_ID )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:638:3: lv_typeGraph_7_0= RULE_ID
            {
            lv_typeGraph_7_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSimpleEvoCospan1439); 

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

            otherlv_8=(Token)match(input,14,FOLLOW_14_in_ruleSimpleEvoCospan1456); 

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
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:666:1: entryRuleEvoSpan returns [EObject current=null] : iv_ruleEvoSpan= ruleEvoSpan EOF ;
    public final EObject entryRuleEvoSpan() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEvoSpan = null;


        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:667:2: (iv_ruleEvoSpan= ruleEvoSpan EOF )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:668:2: iv_ruleEvoSpan= ruleEvoSpan EOF
            {
             newCompositeNode(grammarAccess.getEvoSpanRule()); 
            pushFollow(FOLLOW_ruleEvoSpan_in_entryRuleEvoSpan1492);
            iv_ruleEvoSpan=ruleEvoSpan();

            state._fsp--;

             current =iv_ruleEvoSpan; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEvoSpan1502); 

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
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:675:1: ruleEvoSpan returns [EObject current=null] : (otherlv_0= 'evolution(' ( (lv_lhs_1_0= RULE_ID ) ) otherlv_2= '<->' ( (lv_rhs_3_0= RULE_ID ) ) otherlv_4= ',' ( (lv_typeGraph_5_0= RULE_ID ) ) otherlv_6= ')' ) ;
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
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:678:28: ( (otherlv_0= 'evolution(' ( (lv_lhs_1_0= RULE_ID ) ) otherlv_2= '<->' ( (lv_rhs_3_0= RULE_ID ) ) otherlv_4= ',' ( (lv_typeGraph_5_0= RULE_ID ) ) otherlv_6= ')' ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:679:1: (otherlv_0= 'evolution(' ( (lv_lhs_1_0= RULE_ID ) ) otherlv_2= '<->' ( (lv_rhs_3_0= RULE_ID ) ) otherlv_4= ',' ( (lv_typeGraph_5_0= RULE_ID ) ) otherlv_6= ')' )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:679:1: (otherlv_0= 'evolution(' ( (lv_lhs_1_0= RULE_ID ) ) otherlv_2= '<->' ( (lv_rhs_3_0= RULE_ID ) ) otherlv_4= ',' ( (lv_typeGraph_5_0= RULE_ID ) ) otherlv_6= ')' )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:679:3: otherlv_0= 'evolution(' ( (lv_lhs_1_0= RULE_ID ) ) otherlv_2= '<->' ( (lv_rhs_3_0= RULE_ID ) ) otherlv_4= ',' ( (lv_typeGraph_5_0= RULE_ID ) ) otherlv_6= ')'
            {
            otherlv_0=(Token)match(input,21,FOLLOW_21_in_ruleEvoSpan1539); 

                	newLeafNode(otherlv_0, grammarAccess.getEvoSpanAccess().getEvolutionKeyword_0());
                
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:683:1: ( (lv_lhs_1_0= RULE_ID ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:684:1: (lv_lhs_1_0= RULE_ID )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:684:1: (lv_lhs_1_0= RULE_ID )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:685:3: lv_lhs_1_0= RULE_ID
            {
            lv_lhs_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEvoSpan1556); 

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

            otherlv_2=(Token)match(input,22,FOLLOW_22_in_ruleEvoSpan1573); 

                	newLeafNode(otherlv_2, grammarAccess.getEvoSpanAccess().getLessThanSignHyphenMinusGreaterThanSignKeyword_2());
                
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:705:1: ( (lv_rhs_3_0= RULE_ID ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:706:1: (lv_rhs_3_0= RULE_ID )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:706:1: (lv_rhs_3_0= RULE_ID )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:707:3: lv_rhs_3_0= RULE_ID
            {
            lv_rhs_3_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEvoSpan1590); 

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

            otherlv_4=(Token)match(input,20,FOLLOW_20_in_ruleEvoSpan1607); 

                	newLeafNode(otherlv_4, grammarAccess.getEvoSpanAccess().getCommaKeyword_4());
                
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:727:1: ( (lv_typeGraph_5_0= RULE_ID ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:728:1: (lv_typeGraph_5_0= RULE_ID )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:728:1: (lv_typeGraph_5_0= RULE_ID )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:729:3: lv_typeGraph_5_0= RULE_ID
            {
            lv_typeGraph_5_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEvoSpan1624); 

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

            otherlv_6=(Token)match(input,14,FOLLOW_14_in_ruleEvoSpan1641); 

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
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:757:1: entryRuleEvoCospan returns [EObject current=null] : iv_ruleEvoCospan= ruleEvoCospan EOF ;
    public final EObject entryRuleEvoCospan() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEvoCospan = null;


        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:758:2: (iv_ruleEvoCospan= ruleEvoCospan EOF )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:759:2: iv_ruleEvoCospan= ruleEvoCospan EOF
            {
             newCompositeNode(grammarAccess.getEvoCospanRule()); 
            pushFollow(FOLLOW_ruleEvoCospan_in_entryRuleEvoCospan1677);
            iv_ruleEvoCospan=ruleEvoCospan();

            state._fsp--;

             current =iv_ruleEvoCospan; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEvoCospan1687); 

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
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:766:1: ruleEvoCospan returns [EObject current=null] : (otherlv_0= 'evolution(' ( (lv_lhs_1_0= RULE_ID ) ) otherlv_2= '-><-' ( (lv_rhs_3_0= RULE_ID ) ) otherlv_4= ',' ( (lv_typeGraph_5_0= RULE_ID ) ) otherlv_6= ')' ) ;
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
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:769:28: ( (otherlv_0= 'evolution(' ( (lv_lhs_1_0= RULE_ID ) ) otherlv_2= '-><-' ( (lv_rhs_3_0= RULE_ID ) ) otherlv_4= ',' ( (lv_typeGraph_5_0= RULE_ID ) ) otherlv_6= ')' ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:770:1: (otherlv_0= 'evolution(' ( (lv_lhs_1_0= RULE_ID ) ) otherlv_2= '-><-' ( (lv_rhs_3_0= RULE_ID ) ) otherlv_4= ',' ( (lv_typeGraph_5_0= RULE_ID ) ) otherlv_6= ')' )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:770:1: (otherlv_0= 'evolution(' ( (lv_lhs_1_0= RULE_ID ) ) otherlv_2= '-><-' ( (lv_rhs_3_0= RULE_ID ) ) otherlv_4= ',' ( (lv_typeGraph_5_0= RULE_ID ) ) otherlv_6= ')' )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:770:3: otherlv_0= 'evolution(' ( (lv_lhs_1_0= RULE_ID ) ) otherlv_2= '-><-' ( (lv_rhs_3_0= RULE_ID ) ) otherlv_4= ',' ( (lv_typeGraph_5_0= RULE_ID ) ) otherlv_6= ')'
            {
            otherlv_0=(Token)match(input,21,FOLLOW_21_in_ruleEvoCospan1724); 

                	newLeafNode(otherlv_0, grammarAccess.getEvoCospanAccess().getEvolutionKeyword_0());
                
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:774:1: ( (lv_lhs_1_0= RULE_ID ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:775:1: (lv_lhs_1_0= RULE_ID )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:775:1: (lv_lhs_1_0= RULE_ID )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:776:3: lv_lhs_1_0= RULE_ID
            {
            lv_lhs_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEvoCospan1741); 

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

            otherlv_2=(Token)match(input,23,FOLLOW_23_in_ruleEvoCospan1758); 

                	newLeafNode(otherlv_2, grammarAccess.getEvoCospanAccess().getHyphenMinusGreaterThanSignLessThanSignHyphenMinusKeyword_2());
                
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:796:1: ( (lv_rhs_3_0= RULE_ID ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:797:1: (lv_rhs_3_0= RULE_ID )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:797:1: (lv_rhs_3_0= RULE_ID )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:798:3: lv_rhs_3_0= RULE_ID
            {
            lv_rhs_3_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEvoCospan1775); 

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

            otherlv_4=(Token)match(input,20,FOLLOW_20_in_ruleEvoCospan1792); 

                	newLeafNode(otherlv_4, grammarAccess.getEvoCospanAccess().getCommaKeyword_4());
                
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:818:1: ( (lv_typeGraph_5_0= RULE_ID ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:819:1: (lv_typeGraph_5_0= RULE_ID )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:819:1: (lv_typeGraph_5_0= RULE_ID )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:820:3: lv_typeGraph_5_0= RULE_ID
            {
            lv_typeGraph_5_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEvoCospan1809); 

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

            otherlv_6=(Token)match(input,14,FOLLOW_14_in_ruleEvoCospan1826); 

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


    // $ANTLR start "entryRuleSpecification"
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:848:1: entryRuleSpecification returns [EObject current=null] : iv_ruleSpecification= ruleSpecification EOF ;
    public final EObject entryRuleSpecification() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSpecification = null;


        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:849:2: (iv_ruleSpecification= ruleSpecification EOF )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:850:2: iv_ruleSpecification= ruleSpecification EOF
            {
             newCompositeNode(grammarAccess.getSpecificationRule()); 
            pushFollow(FOLLOW_ruleSpecification_in_entryRuleSpecification1862);
            iv_ruleSpecification=ruleSpecification();

            state._fsp--;

             current =iv_ruleSpecification; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSpecification1872); 

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
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:857:1: ruleSpecification returns [EObject current=null] : (otherlv_0= 'Specification' otherlv_1= ':' ( ( (lv_type_2_0= ruleChoosenSpecification ) ) | (otherlv_3= '(' ( (lv_type_4_0= ruleChoosenSpecification ) ) otherlv_5= ',' ( (lv_constraintSemantic_6_0= ruleChoosenConstraintSemantic ) ) otherlv_7= ')' ) ) otherlv_8= '<' ( (lv_sequenceNumber_9_0= ruleSequenceNumber ) ) otherlv_10= '>' otherlv_11= '{' ( (lv_graph_12_0= ruleGraph ) ) (otherlv_13= 'Constraints' otherlv_14= '{' ( ( (lv_constraints_15_0= ruleConstraint ) ) (otherlv_16= ',' ( (lv_constraints_17_0= ruleConstraint ) ) )* )? otherlv_18= '}' )? otherlv_19= '}' ) ;
    public final EObject ruleSpecification() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        Token otherlv_14=null;
        Token otherlv_16=null;
        Token otherlv_18=null;
        Token otherlv_19=null;
        EObject lv_type_2_0 = null;

        EObject lv_type_4_0 = null;

        EObject lv_constraintSemantic_6_0 = null;

        EObject lv_sequenceNumber_9_0 = null;

        EObject lv_graph_12_0 = null;

        EObject lv_constraints_15_0 = null;

        EObject lv_constraints_17_0 = null;


         enterRule(); 
            
        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:860:28: ( (otherlv_0= 'Specification' otherlv_1= ':' ( ( (lv_type_2_0= ruleChoosenSpecification ) ) | (otherlv_3= '(' ( (lv_type_4_0= ruleChoosenSpecification ) ) otherlv_5= ',' ( (lv_constraintSemantic_6_0= ruleChoosenConstraintSemantic ) ) otherlv_7= ')' ) ) otherlv_8= '<' ( (lv_sequenceNumber_9_0= ruleSequenceNumber ) ) otherlv_10= '>' otherlv_11= '{' ( (lv_graph_12_0= ruleGraph ) ) (otherlv_13= 'Constraints' otherlv_14= '{' ( ( (lv_constraints_15_0= ruleConstraint ) ) (otherlv_16= ',' ( (lv_constraints_17_0= ruleConstraint ) ) )* )? otherlv_18= '}' )? otherlv_19= '}' ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:861:1: (otherlv_0= 'Specification' otherlv_1= ':' ( ( (lv_type_2_0= ruleChoosenSpecification ) ) | (otherlv_3= '(' ( (lv_type_4_0= ruleChoosenSpecification ) ) otherlv_5= ',' ( (lv_constraintSemantic_6_0= ruleChoosenConstraintSemantic ) ) otherlv_7= ')' ) ) otherlv_8= '<' ( (lv_sequenceNumber_9_0= ruleSequenceNumber ) ) otherlv_10= '>' otherlv_11= '{' ( (lv_graph_12_0= ruleGraph ) ) (otherlv_13= 'Constraints' otherlv_14= '{' ( ( (lv_constraints_15_0= ruleConstraint ) ) (otherlv_16= ',' ( (lv_constraints_17_0= ruleConstraint ) ) )* )? otherlv_18= '}' )? otherlv_19= '}' )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:861:1: (otherlv_0= 'Specification' otherlv_1= ':' ( ( (lv_type_2_0= ruleChoosenSpecification ) ) | (otherlv_3= '(' ( (lv_type_4_0= ruleChoosenSpecification ) ) otherlv_5= ',' ( (lv_constraintSemantic_6_0= ruleChoosenConstraintSemantic ) ) otherlv_7= ')' ) ) otherlv_8= '<' ( (lv_sequenceNumber_9_0= ruleSequenceNumber ) ) otherlv_10= '>' otherlv_11= '{' ( (lv_graph_12_0= ruleGraph ) ) (otherlv_13= 'Constraints' otherlv_14= '{' ( ( (lv_constraints_15_0= ruleConstraint ) ) (otherlv_16= ',' ( (lv_constraints_17_0= ruleConstraint ) ) )* )? otherlv_18= '}' )? otherlv_19= '}' )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:861:3: otherlv_0= 'Specification' otherlv_1= ':' ( ( (lv_type_2_0= ruleChoosenSpecification ) ) | (otherlv_3= '(' ( (lv_type_4_0= ruleChoosenSpecification ) ) otherlv_5= ',' ( (lv_constraintSemantic_6_0= ruleChoosenConstraintSemantic ) ) otherlv_7= ')' ) ) otherlv_8= '<' ( (lv_sequenceNumber_9_0= ruleSequenceNumber ) ) otherlv_10= '>' otherlv_11= '{' ( (lv_graph_12_0= ruleGraph ) ) (otherlv_13= 'Constraints' otherlv_14= '{' ( ( (lv_constraints_15_0= ruleConstraint ) ) (otherlv_16= ',' ( (lv_constraints_17_0= ruleConstraint ) ) )* )? otherlv_18= '}' )? otherlv_19= '}'
            {
            otherlv_0=(Token)match(input,24,FOLLOW_24_in_ruleSpecification1909); 

                	newLeafNode(otherlv_0, grammarAccess.getSpecificationAccess().getSpecificationKeyword_0());
                
            otherlv_1=(Token)match(input,25,FOLLOW_25_in_ruleSpecification1921); 

                	newLeafNode(otherlv_1, grammarAccess.getSpecificationAccess().getColonKeyword_1());
                
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:869:1: ( ( (lv_type_2_0= ruleChoosenSpecification ) ) | (otherlv_3= '(' ( (lv_type_4_0= ruleChoosenSpecification ) ) otherlv_5= ',' ( (lv_constraintSemantic_6_0= ruleChoosenConstraintSemantic ) ) otherlv_7= ')' ) )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==RULE_ID) ) {
                alt6=1;
            }
            else if ( (LA6_0==26) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:869:2: ( (lv_type_2_0= ruleChoosenSpecification ) )
                    {
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:869:2: ( (lv_type_2_0= ruleChoosenSpecification ) )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:870:1: (lv_type_2_0= ruleChoosenSpecification )
                    {
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:870:1: (lv_type_2_0= ruleChoosenSpecification )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:871:3: lv_type_2_0= ruleChoosenSpecification
                    {
                     
                    	        newCompositeNode(grammarAccess.getSpecificationAccess().getTypeChoosenSpecificationParserRuleCall_2_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleChoosenSpecification_in_ruleSpecification1943);
                    lv_type_2_0=ruleChoosenSpecification();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getSpecificationRule());
                    	        }
                           		set(
                           			current, 
                           			"type",
                            		lv_type_2_0, 
                            		"ChoosenSpecification");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:888:6: (otherlv_3= '(' ( (lv_type_4_0= ruleChoosenSpecification ) ) otherlv_5= ',' ( (lv_constraintSemantic_6_0= ruleChoosenConstraintSemantic ) ) otherlv_7= ')' )
                    {
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:888:6: (otherlv_3= '(' ( (lv_type_4_0= ruleChoosenSpecification ) ) otherlv_5= ',' ( (lv_constraintSemantic_6_0= ruleChoosenConstraintSemantic ) ) otherlv_7= ')' )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:888:8: otherlv_3= '(' ( (lv_type_4_0= ruleChoosenSpecification ) ) otherlv_5= ',' ( (lv_constraintSemantic_6_0= ruleChoosenConstraintSemantic ) ) otherlv_7= ')'
                    {
                    otherlv_3=(Token)match(input,26,FOLLOW_26_in_ruleSpecification1962); 

                        	newLeafNode(otherlv_3, grammarAccess.getSpecificationAccess().getLeftParenthesisKeyword_2_1_0());
                        
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:892:1: ( (lv_type_4_0= ruleChoosenSpecification ) )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:893:1: (lv_type_4_0= ruleChoosenSpecification )
                    {
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:893:1: (lv_type_4_0= ruleChoosenSpecification )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:894:3: lv_type_4_0= ruleChoosenSpecification
                    {
                     
                    	        newCompositeNode(grammarAccess.getSpecificationAccess().getTypeChoosenSpecificationParserRuleCall_2_1_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleChoosenSpecification_in_ruleSpecification1983);
                    lv_type_4_0=ruleChoosenSpecification();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getSpecificationRule());
                    	        }
                           		set(
                           			current, 
                           			"type",
                            		lv_type_4_0, 
                            		"ChoosenSpecification");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_5=(Token)match(input,20,FOLLOW_20_in_ruleSpecification1995); 

                        	newLeafNode(otherlv_5, grammarAccess.getSpecificationAccess().getCommaKeyword_2_1_2());
                        
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:914:1: ( (lv_constraintSemantic_6_0= ruleChoosenConstraintSemantic ) )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:915:1: (lv_constraintSemantic_6_0= ruleChoosenConstraintSemantic )
                    {
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:915:1: (lv_constraintSemantic_6_0= ruleChoosenConstraintSemantic )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:916:3: lv_constraintSemantic_6_0= ruleChoosenConstraintSemantic
                    {
                     
                    	        newCompositeNode(grammarAccess.getSpecificationAccess().getConstraintSemanticChoosenConstraintSemanticParserRuleCall_2_1_3_0()); 
                    	    
                    pushFollow(FOLLOW_ruleChoosenConstraintSemantic_in_ruleSpecification2016);
                    lv_constraintSemantic_6_0=ruleChoosenConstraintSemantic();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getSpecificationRule());
                    	        }
                           		set(
                           			current, 
                           			"constraintSemantic",
                            		lv_constraintSemantic_6_0, 
                            		"ChoosenConstraintSemantic");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_7=(Token)match(input,14,FOLLOW_14_in_ruleSpecification2028); 

                        	newLeafNode(otherlv_7, grammarAccess.getSpecificationAccess().getRightParenthesisKeyword_2_1_4());
                        

                    }


                    }
                    break;

            }

            otherlv_8=(Token)match(input,27,FOLLOW_27_in_ruleSpecification2042); 

                	newLeafNode(otherlv_8, grammarAccess.getSpecificationAccess().getLessThanSignKeyword_3());
                
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:940:1: ( (lv_sequenceNumber_9_0= ruleSequenceNumber ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:941:1: (lv_sequenceNumber_9_0= ruleSequenceNumber )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:941:1: (lv_sequenceNumber_9_0= ruleSequenceNumber )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:942:3: lv_sequenceNumber_9_0= ruleSequenceNumber
            {
             
            	        newCompositeNode(grammarAccess.getSpecificationAccess().getSequenceNumberSequenceNumberParserRuleCall_4_0()); 
            	    
            pushFollow(FOLLOW_ruleSequenceNumber_in_ruleSpecification2063);
            lv_sequenceNumber_9_0=ruleSequenceNumber();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getSpecificationRule());
            	        }
                   		set(
                   			current, 
                   			"sequenceNumber",
                    		lv_sequenceNumber_9_0, 
                    		"SequenceNumber");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_10=(Token)match(input,28,FOLLOW_28_in_ruleSpecification2075); 

                	newLeafNode(otherlv_10, grammarAccess.getSpecificationAccess().getGreaterThanSignKeyword_5());
                
            otherlv_11=(Token)match(input,29,FOLLOW_29_in_ruleSpecification2087); 

                	newLeafNode(otherlv_11, grammarAccess.getSpecificationAccess().getLeftCurlyBracketKeyword_6());
                
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:966:1: ( (lv_graph_12_0= ruleGraph ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:967:1: (lv_graph_12_0= ruleGraph )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:967:1: (lv_graph_12_0= ruleGraph )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:968:3: lv_graph_12_0= ruleGraph
            {
             
            	        newCompositeNode(grammarAccess.getSpecificationAccess().getGraphGraphParserRuleCall_7_0()); 
            	    
            pushFollow(FOLLOW_ruleGraph_in_ruleSpecification2108);
            lv_graph_12_0=ruleGraph();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getSpecificationRule());
            	        }
                   		set(
                   			current, 
                   			"graph",
                    		lv_graph_12_0, 
                    		"Graph");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:984:2: (otherlv_13= 'Constraints' otherlv_14= '{' ( ( (lv_constraints_15_0= ruleConstraint ) ) (otherlv_16= ',' ( (lv_constraints_17_0= ruleConstraint ) ) )* )? otherlv_18= '}' )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==30) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:984:4: otherlv_13= 'Constraints' otherlv_14= '{' ( ( (lv_constraints_15_0= ruleConstraint ) ) (otherlv_16= ',' ( (lv_constraints_17_0= ruleConstraint ) ) )* )? otherlv_18= '}'
                    {
                    otherlv_13=(Token)match(input,30,FOLLOW_30_in_ruleSpecification2121); 

                        	newLeafNode(otherlv_13, grammarAccess.getSpecificationAccess().getConstraintsKeyword_8_0());
                        
                    otherlv_14=(Token)match(input,29,FOLLOW_29_in_ruleSpecification2133); 

                        	newLeafNode(otherlv_14, grammarAccess.getSpecificationAccess().getLeftCurlyBracketKeyword_8_1());
                        
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:992:1: ( ( (lv_constraints_15_0= ruleConstraint ) ) (otherlv_16= ',' ( (lv_constraints_17_0= ruleConstraint ) ) )* )?
                    int alt8=2;
                    int LA8_0 = input.LA(1);

                    if ( (LA8_0==RULE_ID) ) {
                        alt8=1;
                    }
                    switch (alt8) {
                        case 1 :
                            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:992:2: ( (lv_constraints_15_0= ruleConstraint ) ) (otherlv_16= ',' ( (lv_constraints_17_0= ruleConstraint ) ) )*
                            {
                            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:992:2: ( (lv_constraints_15_0= ruleConstraint ) )
                            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:993:1: (lv_constraints_15_0= ruleConstraint )
                            {
                            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:993:1: (lv_constraints_15_0= ruleConstraint )
                            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:994:3: lv_constraints_15_0= ruleConstraint
                            {
                             
                            	        newCompositeNode(grammarAccess.getSpecificationAccess().getConstraintsConstraintParserRuleCall_8_2_0_0()); 
                            	    
                            pushFollow(FOLLOW_ruleConstraint_in_ruleSpecification2155);
                            lv_constraints_15_0=ruleConstraint();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getSpecificationRule());
                            	        }
                                   		add(
                                   			current, 
                                   			"constraints",
                                    		lv_constraints_15_0, 
                                    		"Constraint");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }

                            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1010:2: (otherlv_16= ',' ( (lv_constraints_17_0= ruleConstraint ) ) )*
                            loop7:
                            do {
                                int alt7=2;
                                int LA7_0 = input.LA(1);

                                if ( (LA7_0==20) ) {
                                    alt7=1;
                                }


                                switch (alt7) {
                            	case 1 :
                            	    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1010:4: otherlv_16= ',' ( (lv_constraints_17_0= ruleConstraint ) )
                            	    {
                            	    otherlv_16=(Token)match(input,20,FOLLOW_20_in_ruleSpecification2168); 

                            	        	newLeafNode(otherlv_16, grammarAccess.getSpecificationAccess().getCommaKeyword_8_2_1_0());
                            	        
                            	    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1014:1: ( (lv_constraints_17_0= ruleConstraint ) )
                            	    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1015:1: (lv_constraints_17_0= ruleConstraint )
                            	    {
                            	    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1015:1: (lv_constraints_17_0= ruleConstraint )
                            	    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1016:3: lv_constraints_17_0= ruleConstraint
                            	    {
                            	     
                            	    	        newCompositeNode(grammarAccess.getSpecificationAccess().getConstraintsConstraintParserRuleCall_8_2_1_1_0()); 
                            	    	    
                            	    pushFollow(FOLLOW_ruleConstraint_in_ruleSpecification2189);
                            	    lv_constraints_17_0=ruleConstraint();

                            	    state._fsp--;


                            	    	        if (current==null) {
                            	    	            current = createModelElementForParent(grammarAccess.getSpecificationRule());
                            	    	        }
                            	           		add(
                            	           			current, 
                            	           			"constraints",
                            	            		lv_constraints_17_0, 
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

                    otherlv_18=(Token)match(input,31,FOLLOW_31_in_ruleSpecification2205); 

                        	newLeafNode(otherlv_18, grammarAccess.getSpecificationAccess().getRightCurlyBracketKeyword_8_3());
                        

                    }
                    break;

            }

            otherlv_19=(Token)match(input,31,FOLLOW_31_in_ruleSpecification2219); 

                	newLeafNode(otherlv_19, grammarAccess.getSpecificationAccess().getRightCurlyBracketKeyword_9());
                

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


    // $ANTLR start "entryRuleChoosenSpecification"
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1048:1: entryRuleChoosenSpecification returns [EObject current=null] : iv_ruleChoosenSpecification= ruleChoosenSpecification EOF ;
    public final EObject entryRuleChoosenSpecification() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleChoosenSpecification = null;


        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1049:2: (iv_ruleChoosenSpecification= ruleChoosenSpecification EOF )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1050:2: iv_ruleChoosenSpecification= ruleChoosenSpecification EOF
            {
             newCompositeNode(grammarAccess.getChoosenSpecificationRule()); 
            pushFollow(FOLLOW_ruleChoosenSpecification_in_entryRuleChoosenSpecification2255);
            iv_ruleChoosenSpecification=ruleChoosenSpecification();

            state._fsp--;

             current =iv_ruleChoosenSpecification; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleChoosenSpecification2265); 

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
    // $ANTLR end "entryRuleChoosenSpecification"


    // $ANTLR start "ruleChoosenSpecification"
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1057:1: ruleChoosenSpecification returns [EObject current=null] : ( (lv_id_0_0= RULE_ID ) ) ;
    public final EObject ruleChoosenSpecification() throws RecognitionException {
        EObject current = null;

        Token lv_id_0_0=null;

         enterRule(); 
            
        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1060:28: ( ( (lv_id_0_0= RULE_ID ) ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1061:1: ( (lv_id_0_0= RULE_ID ) )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1061:1: ( (lv_id_0_0= RULE_ID ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1062:1: (lv_id_0_0= RULE_ID )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1062:1: (lv_id_0_0= RULE_ID )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1063:3: lv_id_0_0= RULE_ID
            {
            lv_id_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleChoosenSpecification2306); 

            			newLeafNode(lv_id_0_0, grammarAccess.getChoosenSpecificationAccess().getIdIDTerminalRuleCall_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getChoosenSpecificationRule());
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
    // $ANTLR end "ruleChoosenSpecification"


    // $ANTLR start "entryRuleSequenceNumber"
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1087:1: entryRuleSequenceNumber returns [EObject current=null] : iv_ruleSequenceNumber= ruleSequenceNumber EOF ;
    public final EObject entryRuleSequenceNumber() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSequenceNumber = null;


        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1088:2: (iv_ruleSequenceNumber= ruleSequenceNumber EOF )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1089:2: iv_ruleSequenceNumber= ruleSequenceNumber EOF
            {
             newCompositeNode(grammarAccess.getSequenceNumberRule()); 
            pushFollow(FOLLOW_ruleSequenceNumber_in_entryRuleSequenceNumber2346);
            iv_ruleSequenceNumber=ruleSequenceNumber();

            state._fsp--;

             current =iv_ruleSequenceNumber; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSequenceNumber2356); 

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
    // $ANTLR end "entryRuleSequenceNumber"


    // $ANTLR start "ruleSequenceNumber"
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1096:1: ruleSequenceNumber returns [EObject current=null] : ( (lv_nextNumber_0_0= RULE_INT ) ) ;
    public final EObject ruleSequenceNumber() throws RecognitionException {
        EObject current = null;

        Token lv_nextNumber_0_0=null;

         enterRule(); 
            
        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1099:28: ( ( (lv_nextNumber_0_0= RULE_INT ) ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1100:1: ( (lv_nextNumber_0_0= RULE_INT ) )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1100:1: ( (lv_nextNumber_0_0= RULE_INT ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1101:1: (lv_nextNumber_0_0= RULE_INT )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1101:1: (lv_nextNumber_0_0= RULE_INT )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1102:3: lv_nextNumber_0_0= RULE_INT
            {
            lv_nextNumber_0_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleSequenceNumber2397); 

            			newLeafNode(lv_nextNumber_0_0, grammarAccess.getSequenceNumberAccess().getNextNumberINTTerminalRuleCall_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getSequenceNumberRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"nextNumber",
                    		lv_nextNumber_0_0, 
                    		"INT");
            	    

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
    // $ANTLR end "ruleSequenceNumber"


    // $ANTLR start "entryRuleChoosenConstraintSemantic"
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1126:1: entryRuleChoosenConstraintSemantic returns [EObject current=null] : iv_ruleChoosenConstraintSemantic= ruleChoosenConstraintSemantic EOF ;
    public final EObject entryRuleChoosenConstraintSemantic() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleChoosenConstraintSemantic = null;


        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1127:2: (iv_ruleChoosenConstraintSemantic= ruleChoosenConstraintSemantic EOF )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1128:2: iv_ruleChoosenConstraintSemantic= ruleChoosenConstraintSemantic EOF
            {
             newCompositeNode(grammarAccess.getChoosenConstraintSemanticRule()); 
            pushFollow(FOLLOW_ruleChoosenConstraintSemantic_in_entryRuleChoosenConstraintSemantic2437);
            iv_ruleChoosenConstraintSemantic=ruleChoosenConstraintSemantic();

            state._fsp--;

             current =iv_ruleChoosenConstraintSemantic; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleChoosenConstraintSemantic2447); 

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
    // $ANTLR end "entryRuleChoosenConstraintSemantic"


    // $ANTLR start "ruleChoosenConstraintSemantic"
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1135:1: ruleChoosenConstraintSemantic returns [EObject current=null] : ( (lv_id_0_0= RULE_ID ) ) ;
    public final EObject ruleChoosenConstraintSemantic() throws RecognitionException {
        EObject current = null;

        Token lv_id_0_0=null;

         enterRule(); 
            
        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1138:28: ( ( (lv_id_0_0= RULE_ID ) ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1139:1: ( (lv_id_0_0= RULE_ID ) )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1139:1: ( (lv_id_0_0= RULE_ID ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1140:1: (lv_id_0_0= RULE_ID )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1140:1: (lv_id_0_0= RULE_ID )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1141:3: lv_id_0_0= RULE_ID
            {
            lv_id_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleChoosenConstraintSemantic2488); 

            			newLeafNode(lv_id_0_0, grammarAccess.getChoosenConstraintSemanticAccess().getIdIDTerminalRuleCall_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getChoosenConstraintSemanticRule());
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
    // $ANTLR end "ruleChoosenConstraintSemantic"


    // $ANTLR start "entryRuleConstraint"
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1165:1: entryRuleConstraint returns [EObject current=null] : iv_ruleConstraint= ruleConstraint EOF ;
    public final EObject entryRuleConstraint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstraint = null;


        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1166:2: (iv_ruleConstraint= ruleConstraint EOF )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1167:2: iv_ruleConstraint= ruleConstraint EOF
            {
             newCompositeNode(grammarAccess.getConstraintRule()); 
            pushFollow(FOLLOW_ruleConstraint_in_entryRuleConstraint2528);
            iv_ruleConstraint=ruleConstraint();

            state._fsp--;

             current =iv_ruleConstraint; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleConstraint2538); 

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
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1174:1: ruleConstraint returns [EObject current=null] : ( ( (lv_signature_0_0= ruleConstraintSignature ) ) otherlv_1= '{' ( ( (lv_arrows_2_0= ruleArrows ) ) (otherlv_3= ',' ( (lv_arrows_4_0= ruleArrows ) ) )* ) otherlv_5= '}' ) ;
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
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1177:28: ( ( ( (lv_signature_0_0= ruleConstraintSignature ) ) otherlv_1= '{' ( ( (lv_arrows_2_0= ruleArrows ) ) (otherlv_3= ',' ( (lv_arrows_4_0= ruleArrows ) ) )* ) otherlv_5= '}' ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1178:1: ( ( (lv_signature_0_0= ruleConstraintSignature ) ) otherlv_1= '{' ( ( (lv_arrows_2_0= ruleArrows ) ) (otherlv_3= ',' ( (lv_arrows_4_0= ruleArrows ) ) )* ) otherlv_5= '}' )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1178:1: ( ( (lv_signature_0_0= ruleConstraintSignature ) ) otherlv_1= '{' ( ( (lv_arrows_2_0= ruleArrows ) ) (otherlv_3= ',' ( (lv_arrows_4_0= ruleArrows ) ) )* ) otherlv_5= '}' )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1178:2: ( (lv_signature_0_0= ruleConstraintSignature ) ) otherlv_1= '{' ( ( (lv_arrows_2_0= ruleArrows ) ) (otherlv_3= ',' ( (lv_arrows_4_0= ruleArrows ) ) )* ) otherlv_5= '}'
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1178:2: ( (lv_signature_0_0= ruleConstraintSignature ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1179:1: (lv_signature_0_0= ruleConstraintSignature )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1179:1: (lv_signature_0_0= ruleConstraintSignature )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1180:3: lv_signature_0_0= ruleConstraintSignature
            {
             
            	        newCompositeNode(grammarAccess.getConstraintAccess().getSignatureConstraintSignatureParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleConstraintSignature_in_ruleConstraint2584);
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

            otherlv_1=(Token)match(input,29,FOLLOW_29_in_ruleConstraint2596); 

                	newLeafNode(otherlv_1, grammarAccess.getConstraintAccess().getLeftCurlyBracketKeyword_1());
                
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1200:1: ( ( (lv_arrows_2_0= ruleArrows ) ) (otherlv_3= ',' ( (lv_arrows_4_0= ruleArrows ) ) )* )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1200:2: ( (lv_arrows_2_0= ruleArrows ) ) (otherlv_3= ',' ( (lv_arrows_4_0= ruleArrows ) ) )*
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1200:2: ( (lv_arrows_2_0= ruleArrows ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1201:1: (lv_arrows_2_0= ruleArrows )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1201:1: (lv_arrows_2_0= ruleArrows )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1202:3: lv_arrows_2_0= ruleArrows
            {
             
            	        newCompositeNode(grammarAccess.getConstraintAccess().getArrowsArrowsParserRuleCall_2_0_0()); 
            	    
            pushFollow(FOLLOW_ruleArrows_in_ruleConstraint2618);
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

            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1218:2: (otherlv_3= ',' ( (lv_arrows_4_0= ruleArrows ) ) )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==20) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1218:4: otherlv_3= ',' ( (lv_arrows_4_0= ruleArrows ) )
            	    {
            	    otherlv_3=(Token)match(input,20,FOLLOW_20_in_ruleConstraint2631); 

            	        	newLeafNode(otherlv_3, grammarAccess.getConstraintAccess().getCommaKeyword_2_1_0());
            	        
            	    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1222:1: ( (lv_arrows_4_0= ruleArrows ) )
            	    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1223:1: (lv_arrows_4_0= ruleArrows )
            	    {
            	    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1223:1: (lv_arrows_4_0= ruleArrows )
            	    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1224:3: lv_arrows_4_0= ruleArrows
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getConstraintAccess().getArrowsArrowsParserRuleCall_2_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleArrows_in_ruleConstraint2652);
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
            	    break loop10;
                }
            } while (true);


            }

            otherlv_5=(Token)match(input,31,FOLLOW_31_in_ruleConstraint2667); 

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
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1252:1: entryRuleConstraintSignature returns [EObject current=null] : iv_ruleConstraintSignature= ruleConstraintSignature EOF ;
    public final EObject entryRuleConstraintSignature() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstraintSignature = null;


        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1253:2: (iv_ruleConstraintSignature= ruleConstraintSignature EOF )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1254:2: iv_ruleConstraintSignature= ruleConstraintSignature EOF
            {
             newCompositeNode(grammarAccess.getConstraintSignatureRule()); 
            pushFollow(FOLLOW_ruleConstraintSignature_in_entryRuleConstraintSignature2703);
            iv_ruleConstraintSignature=ruleConstraintSignature();

            state._fsp--;

             current =iv_ruleConstraintSignature; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleConstraintSignature2713); 

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
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1261:1: ruleConstraintSignature returns [EObject current=null] : ( ( (lv_id_0_0= ruleDpfId ) ) otherlv_1= '(' ( ( (lv_parameter_2_0= RULE_STRING ) ) (otherlv_3= ',' ( (lv_parameter_4_0= RULE_STRING ) ) )* )? otherlv_5= ')' ) ;
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
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1264:28: ( ( ( (lv_id_0_0= ruleDpfId ) ) otherlv_1= '(' ( ( (lv_parameter_2_0= RULE_STRING ) ) (otherlv_3= ',' ( (lv_parameter_4_0= RULE_STRING ) ) )* )? otherlv_5= ')' ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1265:1: ( ( (lv_id_0_0= ruleDpfId ) ) otherlv_1= '(' ( ( (lv_parameter_2_0= RULE_STRING ) ) (otherlv_3= ',' ( (lv_parameter_4_0= RULE_STRING ) ) )* )? otherlv_5= ')' )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1265:1: ( ( (lv_id_0_0= ruleDpfId ) ) otherlv_1= '(' ( ( (lv_parameter_2_0= RULE_STRING ) ) (otherlv_3= ',' ( (lv_parameter_4_0= RULE_STRING ) ) )* )? otherlv_5= ')' )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1265:2: ( (lv_id_0_0= ruleDpfId ) ) otherlv_1= '(' ( ( (lv_parameter_2_0= RULE_STRING ) ) (otherlv_3= ',' ( (lv_parameter_4_0= RULE_STRING ) ) )* )? otherlv_5= ')'
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1265:2: ( (lv_id_0_0= ruleDpfId ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1266:1: (lv_id_0_0= ruleDpfId )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1266:1: (lv_id_0_0= ruleDpfId )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1267:3: lv_id_0_0= ruleDpfId
            {
             
            	        newCompositeNode(grammarAccess.getConstraintSignatureAccess().getIdDpfIdParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleDpfId_in_ruleConstraintSignature2759);
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

            otherlv_1=(Token)match(input,26,FOLLOW_26_in_ruleConstraintSignature2771); 

                	newLeafNode(otherlv_1, grammarAccess.getConstraintSignatureAccess().getLeftParenthesisKeyword_1());
                
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1287:1: ( ( (lv_parameter_2_0= RULE_STRING ) ) (otherlv_3= ',' ( (lv_parameter_4_0= RULE_STRING ) ) )* )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==RULE_STRING) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1287:2: ( (lv_parameter_2_0= RULE_STRING ) ) (otherlv_3= ',' ( (lv_parameter_4_0= RULE_STRING ) ) )*
                    {
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1287:2: ( (lv_parameter_2_0= RULE_STRING ) )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1288:1: (lv_parameter_2_0= RULE_STRING )
                    {
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1288:1: (lv_parameter_2_0= RULE_STRING )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1289:3: lv_parameter_2_0= RULE_STRING
                    {
                    lv_parameter_2_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleConstraintSignature2789); 

                    			newLeafNode(lv_parameter_2_0, grammarAccess.getConstraintSignatureAccess().getParameterSTRINGTerminalRuleCall_2_0_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getConstraintSignatureRule());
                    	        }
                           		addWithLastConsumed(
                           			current, 
                           			"parameter",
                            		lv_parameter_2_0, 
                            		"STRING");
                    	    

                    }


                    }

                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1305:2: (otherlv_3= ',' ( (lv_parameter_4_0= RULE_STRING ) ) )*
                    loop11:
                    do {
                        int alt11=2;
                        int LA11_0 = input.LA(1);

                        if ( (LA11_0==20) ) {
                            alt11=1;
                        }


                        switch (alt11) {
                    	case 1 :
                    	    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1305:4: otherlv_3= ',' ( (lv_parameter_4_0= RULE_STRING ) )
                    	    {
                    	    otherlv_3=(Token)match(input,20,FOLLOW_20_in_ruleConstraintSignature2807); 

                    	        	newLeafNode(otherlv_3, grammarAccess.getConstraintSignatureAccess().getCommaKeyword_2_1_0());
                    	        
                    	    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1309:1: ( (lv_parameter_4_0= RULE_STRING ) )
                    	    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1310:1: (lv_parameter_4_0= RULE_STRING )
                    	    {
                    	    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1310:1: (lv_parameter_4_0= RULE_STRING )
                    	    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1311:3: lv_parameter_4_0= RULE_STRING
                    	    {
                    	    lv_parameter_4_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleConstraintSignature2824); 

                    	    			newLeafNode(lv_parameter_4_0, grammarAccess.getConstraintSignatureAccess().getParameterSTRINGTerminalRuleCall_2_1_1_0()); 
                    	    		

                    	    	        if (current==null) {
                    	    	            current = createModelElement(grammarAccess.getConstraintSignatureRule());
                    	    	        }
                    	           		addWithLastConsumed(
                    	           			current, 
                    	           			"parameter",
                    	            		lv_parameter_4_0, 
                    	            		"STRING");
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop11;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_5=(Token)match(input,14,FOLLOW_14_in_ruleConstraintSignature2845); 

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


    // $ANTLR start "entryRuleSignature"
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1339:1: entryRuleSignature returns [EObject current=null] : iv_ruleSignature= ruleSignature EOF ;
    public final EObject entryRuleSignature() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSignature = null;


        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1340:2: (iv_ruleSignature= ruleSignature EOF )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1341:2: iv_ruleSignature= ruleSignature EOF
            {
             newCompositeNode(grammarAccess.getSignatureRule()); 
            pushFollow(FOLLOW_ruleSignature_in_entryRuleSignature2881);
            iv_ruleSignature=ruleSignature();

            state._fsp--;

             current =iv_ruleSignature; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSignature2891); 

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
    // $ANTLR end "entryRuleSignature"


    // $ANTLR start "ruleSignature"
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1348:1: ruleSignature returns [EObject current=null] : ( ( (lv_constraintSemantics_0_0= ruleConstraintSemantic ) ) (otherlv_1= ',' ( (lv_constraintSemantics_2_0= ruleConstraintSemantic ) ) )* ) ;
    public final EObject ruleSignature() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_constraintSemantics_0_0 = null;

        EObject lv_constraintSemantics_2_0 = null;


         enterRule(); 
            
        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1351:28: ( ( ( (lv_constraintSemantics_0_0= ruleConstraintSemantic ) ) (otherlv_1= ',' ( (lv_constraintSemantics_2_0= ruleConstraintSemantic ) ) )* ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1352:1: ( ( (lv_constraintSemantics_0_0= ruleConstraintSemantic ) ) (otherlv_1= ',' ( (lv_constraintSemantics_2_0= ruleConstraintSemantic ) ) )* )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1352:1: ( ( (lv_constraintSemantics_0_0= ruleConstraintSemantic ) ) (otherlv_1= ',' ( (lv_constraintSemantics_2_0= ruleConstraintSemantic ) ) )* )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1352:2: ( (lv_constraintSemantics_0_0= ruleConstraintSemantic ) ) (otherlv_1= ',' ( (lv_constraintSemantics_2_0= ruleConstraintSemantic ) ) )*
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1352:2: ( (lv_constraintSemantics_0_0= ruleConstraintSemantic ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1353:1: (lv_constraintSemantics_0_0= ruleConstraintSemantic )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1353:1: (lv_constraintSemantics_0_0= ruleConstraintSemantic )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1354:3: lv_constraintSemantics_0_0= ruleConstraintSemantic
            {
             
            	        newCompositeNode(grammarAccess.getSignatureAccess().getConstraintSemanticsConstraintSemanticParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleConstraintSemantic_in_ruleSignature2937);
            lv_constraintSemantics_0_0=ruleConstraintSemantic();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getSignatureRule());
            	        }
                   		add(
                   			current, 
                   			"constraintSemantics",
                    		lv_constraintSemantics_0_0, 
                    		"ConstraintSemantic");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1370:2: (otherlv_1= ',' ( (lv_constraintSemantics_2_0= ruleConstraintSemantic ) ) )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==20) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1370:4: otherlv_1= ',' ( (lv_constraintSemantics_2_0= ruleConstraintSemantic ) )
            	    {
            	    otherlv_1=(Token)match(input,20,FOLLOW_20_in_ruleSignature2950); 

            	        	newLeafNode(otherlv_1, grammarAccess.getSignatureAccess().getCommaKeyword_1_0());
            	        
            	    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1374:1: ( (lv_constraintSemantics_2_0= ruleConstraintSemantic ) )
            	    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1375:1: (lv_constraintSemantics_2_0= ruleConstraintSemantic )
            	    {
            	    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1375:1: (lv_constraintSemantics_2_0= ruleConstraintSemantic )
            	    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1376:3: lv_constraintSemantics_2_0= ruleConstraintSemantic
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getSignatureAccess().getConstraintSemanticsConstraintSemanticParserRuleCall_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleConstraintSemantic_in_ruleSignature2971);
            	    lv_constraintSemantics_2_0=ruleConstraintSemantic();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getSignatureRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"constraintSemantics",
            	            		lv_constraintSemantics_2_0, 
            	            		"ConstraintSemantic");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);


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
    // $ANTLR end "ruleSignature"


    // $ANTLR start "entryRuleConstraintSemantic"
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1400:1: entryRuleConstraintSemantic returns [EObject current=null] : iv_ruleConstraintSemantic= ruleConstraintSemantic EOF ;
    public final EObject entryRuleConstraintSemantic() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstraintSemantic = null;


        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1401:2: (iv_ruleConstraintSemantic= ruleConstraintSemantic EOF )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1402:2: iv_ruleConstraintSemantic= ruleConstraintSemantic EOF
            {
             newCompositeNode(grammarAccess.getConstraintSemanticRule()); 
            pushFollow(FOLLOW_ruleConstraintSemantic_in_entryRuleConstraintSemantic3009);
            iv_ruleConstraintSemantic=ruleConstraintSemantic();

            state._fsp--;

             current =iv_ruleConstraintSemantic; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleConstraintSemantic3019); 

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
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1409:1: ruleConstraintSemantic returns [EObject current=null] : ( ( (lv_id_0_0= ruleDpfId ) ) otherlv_1= '{' ( ( (lv_arrows_2_0= ruleArrows ) ) (otherlv_3= ',' ( (lv_arrows_4_0= ruleArrows ) ) )* ) otherlv_5= '}' otherlv_6= '=' ( (lv_ocl_7_0= RULE_STRING ) ) ) ;
    public final EObject ruleConstraintSemantic() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token lv_ocl_7_0=null;
        EObject lv_id_0_0 = null;

        EObject lv_arrows_2_0 = null;

        EObject lv_arrows_4_0 = null;


         enterRule(); 
            
        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1412:28: ( ( ( (lv_id_0_0= ruleDpfId ) ) otherlv_1= '{' ( ( (lv_arrows_2_0= ruleArrows ) ) (otherlv_3= ',' ( (lv_arrows_4_0= ruleArrows ) ) )* ) otherlv_5= '}' otherlv_6= '=' ( (lv_ocl_7_0= RULE_STRING ) ) ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1413:1: ( ( (lv_id_0_0= ruleDpfId ) ) otherlv_1= '{' ( ( (lv_arrows_2_0= ruleArrows ) ) (otherlv_3= ',' ( (lv_arrows_4_0= ruleArrows ) ) )* ) otherlv_5= '}' otherlv_6= '=' ( (lv_ocl_7_0= RULE_STRING ) ) )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1413:1: ( ( (lv_id_0_0= ruleDpfId ) ) otherlv_1= '{' ( ( (lv_arrows_2_0= ruleArrows ) ) (otherlv_3= ',' ( (lv_arrows_4_0= ruleArrows ) ) )* ) otherlv_5= '}' otherlv_6= '=' ( (lv_ocl_7_0= RULE_STRING ) ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1413:2: ( (lv_id_0_0= ruleDpfId ) ) otherlv_1= '{' ( ( (lv_arrows_2_0= ruleArrows ) ) (otherlv_3= ',' ( (lv_arrows_4_0= ruleArrows ) ) )* ) otherlv_5= '}' otherlv_6= '=' ( (lv_ocl_7_0= RULE_STRING ) )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1413:2: ( (lv_id_0_0= ruleDpfId ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1414:1: (lv_id_0_0= ruleDpfId )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1414:1: (lv_id_0_0= ruleDpfId )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1415:3: lv_id_0_0= ruleDpfId
            {
             
            	        newCompositeNode(grammarAccess.getConstraintSemanticAccess().getIdDpfIdParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleDpfId_in_ruleConstraintSemantic3065);
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

            otherlv_1=(Token)match(input,29,FOLLOW_29_in_ruleConstraintSemantic3077); 

                	newLeafNode(otherlv_1, grammarAccess.getConstraintSemanticAccess().getLeftCurlyBracketKeyword_1());
                
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1435:1: ( ( (lv_arrows_2_0= ruleArrows ) ) (otherlv_3= ',' ( (lv_arrows_4_0= ruleArrows ) ) )* )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1435:2: ( (lv_arrows_2_0= ruleArrows ) ) (otherlv_3= ',' ( (lv_arrows_4_0= ruleArrows ) ) )*
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1435:2: ( (lv_arrows_2_0= ruleArrows ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1436:1: (lv_arrows_2_0= ruleArrows )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1436:1: (lv_arrows_2_0= ruleArrows )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1437:3: lv_arrows_2_0= ruleArrows
            {
             
            	        newCompositeNode(grammarAccess.getConstraintSemanticAccess().getArrowsArrowsParserRuleCall_2_0_0()); 
            	    
            pushFollow(FOLLOW_ruleArrows_in_ruleConstraintSemantic3099);
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

            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1453:2: (otherlv_3= ',' ( (lv_arrows_4_0= ruleArrows ) ) )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==20) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1453:4: otherlv_3= ',' ( (lv_arrows_4_0= ruleArrows ) )
            	    {
            	    otherlv_3=(Token)match(input,20,FOLLOW_20_in_ruleConstraintSemantic3112); 

            	        	newLeafNode(otherlv_3, grammarAccess.getConstraintSemanticAccess().getCommaKeyword_2_1_0());
            	        
            	    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1457:1: ( (lv_arrows_4_0= ruleArrows ) )
            	    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1458:1: (lv_arrows_4_0= ruleArrows )
            	    {
            	    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1458:1: (lv_arrows_4_0= ruleArrows )
            	    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1459:3: lv_arrows_4_0= ruleArrows
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getConstraintSemanticAccess().getArrowsArrowsParserRuleCall_2_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleArrows_in_ruleConstraintSemantic3133);
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
            	    break loop14;
                }
            } while (true);


            }

            otherlv_5=(Token)match(input,31,FOLLOW_31_in_ruleConstraintSemantic3148); 

                	newLeafNode(otherlv_5, grammarAccess.getConstraintSemanticAccess().getRightCurlyBracketKeyword_3());
                
            otherlv_6=(Token)match(input,32,FOLLOW_32_in_ruleConstraintSemantic3160); 

                	newLeafNode(otherlv_6, grammarAccess.getConstraintSemanticAccess().getEqualsSignKeyword_4());
                
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1483:1: ( (lv_ocl_7_0= RULE_STRING ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1484:1: (lv_ocl_7_0= RULE_STRING )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1484:1: (lv_ocl_7_0= RULE_STRING )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1485:3: lv_ocl_7_0= RULE_STRING
            {
            lv_ocl_7_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleConstraintSemantic3177); 

            			newLeafNode(lv_ocl_7_0, grammarAccess.getConstraintSemanticAccess().getOclSTRINGTerminalRuleCall_5_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getConstraintSemanticRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"ocl",
                    		lv_ocl_7_0, 
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


    // $ANTLR start "entryRuleMorphism"
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1509:1: entryRuleMorphism returns [EObject current=null] : iv_ruleMorphism= ruleMorphism EOF ;
    public final EObject entryRuleMorphism() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMorphism = null;


        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1510:2: (iv_ruleMorphism= ruleMorphism EOF )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1511:2: iv_ruleMorphism= ruleMorphism EOF
            {
             newCompositeNode(grammarAccess.getMorphismRule()); 
            pushFollow(FOLLOW_ruleMorphism_in_entryRuleMorphism3218);
            iv_ruleMorphism=ruleMorphism();

            state._fsp--;

             current =iv_ruleMorphism; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMorphism3228); 

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
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1518:1: ruleMorphism returns [EObject current=null] : (this_ID_0= RULE_ID otherlv_1= ':=' otherlv_2= 'Morphism' otherlv_3= '<' ( (lv_domain_4_0= ruleDomain ) ) otherlv_5= ',' ( (lv_codmain_6_0= ruleCodomain ) ) otherlv_7= '>' otherlv_8= '{' ( ( (lv_mappings_9_0= ruleMapping ) ) (otherlv_10= ',' ( (lv_mappings_11_0= ruleMapping ) ) )* )? otherlv_12= '}' ) ;
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
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1521:28: ( (this_ID_0= RULE_ID otherlv_1= ':=' otherlv_2= 'Morphism' otherlv_3= '<' ( (lv_domain_4_0= ruleDomain ) ) otherlv_5= ',' ( (lv_codmain_6_0= ruleCodomain ) ) otherlv_7= '>' otherlv_8= '{' ( ( (lv_mappings_9_0= ruleMapping ) ) (otherlv_10= ',' ( (lv_mappings_11_0= ruleMapping ) ) )* )? otherlv_12= '}' ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1522:1: (this_ID_0= RULE_ID otherlv_1= ':=' otherlv_2= 'Morphism' otherlv_3= '<' ( (lv_domain_4_0= ruleDomain ) ) otherlv_5= ',' ( (lv_codmain_6_0= ruleCodomain ) ) otherlv_7= '>' otherlv_8= '{' ( ( (lv_mappings_9_0= ruleMapping ) ) (otherlv_10= ',' ( (lv_mappings_11_0= ruleMapping ) ) )* )? otherlv_12= '}' )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1522:1: (this_ID_0= RULE_ID otherlv_1= ':=' otherlv_2= 'Morphism' otherlv_3= '<' ( (lv_domain_4_0= ruleDomain ) ) otherlv_5= ',' ( (lv_codmain_6_0= ruleCodomain ) ) otherlv_7= '>' otherlv_8= '{' ( ( (lv_mappings_9_0= ruleMapping ) ) (otherlv_10= ',' ( (lv_mappings_11_0= ruleMapping ) ) )* )? otherlv_12= '}' )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1522:2: this_ID_0= RULE_ID otherlv_1= ':=' otherlv_2= 'Morphism' otherlv_3= '<' ( (lv_domain_4_0= ruleDomain ) ) otherlv_5= ',' ( (lv_codmain_6_0= ruleCodomain ) ) otherlv_7= '>' otherlv_8= '{' ( ( (lv_mappings_9_0= ruleMapping ) ) (otherlv_10= ',' ( (lv_mappings_11_0= ruleMapping ) ) )* )? otherlv_12= '}'
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleMorphism3264); 
             
                newLeafNode(this_ID_0, grammarAccess.getMorphismAccess().getIDTerminalRuleCall_0()); 
                
            otherlv_1=(Token)match(input,33,FOLLOW_33_in_ruleMorphism3275); 

                	newLeafNode(otherlv_1, grammarAccess.getMorphismAccess().getColonEqualsSignKeyword_1());
                
            otherlv_2=(Token)match(input,34,FOLLOW_34_in_ruleMorphism3287); 

                	newLeafNode(otherlv_2, grammarAccess.getMorphismAccess().getMorphismKeyword_2());
                
            otherlv_3=(Token)match(input,27,FOLLOW_27_in_ruleMorphism3299); 

                	newLeafNode(otherlv_3, grammarAccess.getMorphismAccess().getLessThanSignKeyword_3());
                
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1538:1: ( (lv_domain_4_0= ruleDomain ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1539:1: (lv_domain_4_0= ruleDomain )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1539:1: (lv_domain_4_0= ruleDomain )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1540:3: lv_domain_4_0= ruleDomain
            {
             
            	        newCompositeNode(grammarAccess.getMorphismAccess().getDomainDomainParserRuleCall_4_0()); 
            	    
            pushFollow(FOLLOW_ruleDomain_in_ruleMorphism3320);
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

            otherlv_5=(Token)match(input,20,FOLLOW_20_in_ruleMorphism3332); 

                	newLeafNode(otherlv_5, grammarAccess.getMorphismAccess().getCommaKeyword_5());
                
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1560:1: ( (lv_codmain_6_0= ruleCodomain ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1561:1: (lv_codmain_6_0= ruleCodomain )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1561:1: (lv_codmain_6_0= ruleCodomain )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1562:3: lv_codmain_6_0= ruleCodomain
            {
             
            	        newCompositeNode(grammarAccess.getMorphismAccess().getCodmainCodomainParserRuleCall_6_0()); 
            	    
            pushFollow(FOLLOW_ruleCodomain_in_ruleMorphism3353);
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

            otherlv_7=(Token)match(input,28,FOLLOW_28_in_ruleMorphism3365); 

                	newLeafNode(otherlv_7, grammarAccess.getMorphismAccess().getGreaterThanSignKeyword_7());
                
            otherlv_8=(Token)match(input,29,FOLLOW_29_in_ruleMorphism3377); 

                	newLeafNode(otherlv_8, grammarAccess.getMorphismAccess().getLeftCurlyBracketKeyword_8());
                
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1586:1: ( ( (lv_mappings_9_0= ruleMapping ) ) (otherlv_10= ',' ( (lv_mappings_11_0= ruleMapping ) ) )* )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==RULE_ID) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1586:2: ( (lv_mappings_9_0= ruleMapping ) ) (otherlv_10= ',' ( (lv_mappings_11_0= ruleMapping ) ) )*
                    {
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1586:2: ( (lv_mappings_9_0= ruleMapping ) )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1587:1: (lv_mappings_9_0= ruleMapping )
                    {
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1587:1: (lv_mappings_9_0= ruleMapping )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1588:3: lv_mappings_9_0= ruleMapping
                    {
                     
                    	        newCompositeNode(grammarAccess.getMorphismAccess().getMappingsMappingParserRuleCall_9_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleMapping_in_ruleMorphism3399);
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

                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1604:2: (otherlv_10= ',' ( (lv_mappings_11_0= ruleMapping ) ) )*
                    loop15:
                    do {
                        int alt15=2;
                        int LA15_0 = input.LA(1);

                        if ( (LA15_0==20) ) {
                            alt15=1;
                        }


                        switch (alt15) {
                    	case 1 :
                    	    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1604:4: otherlv_10= ',' ( (lv_mappings_11_0= ruleMapping ) )
                    	    {
                    	    otherlv_10=(Token)match(input,20,FOLLOW_20_in_ruleMorphism3412); 

                    	        	newLeafNode(otherlv_10, grammarAccess.getMorphismAccess().getCommaKeyword_9_1_0());
                    	        
                    	    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1608:1: ( (lv_mappings_11_0= ruleMapping ) )
                    	    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1609:1: (lv_mappings_11_0= ruleMapping )
                    	    {
                    	    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1609:1: (lv_mappings_11_0= ruleMapping )
                    	    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1610:3: lv_mappings_11_0= ruleMapping
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getMorphismAccess().getMappingsMappingParserRuleCall_9_1_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleMapping_in_ruleMorphism3433);
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
                    	    break loop15;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_12=(Token)match(input,31,FOLLOW_31_in_ruleMorphism3449); 

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
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1638:1: entryRuleDomain returns [EObject current=null] : iv_ruleDomain= ruleDomain EOF ;
    public final EObject entryRuleDomain() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDomain = null;


        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1639:2: (iv_ruleDomain= ruleDomain EOF )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1640:2: iv_ruleDomain= ruleDomain EOF
            {
             newCompositeNode(grammarAccess.getDomainRule()); 
            pushFollow(FOLLOW_ruleDomain_in_entryRuleDomain3485);
            iv_ruleDomain=ruleDomain();

            state._fsp--;

             current =iv_ruleDomain; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDomain3495); 

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
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1647:1: ruleDomain returns [EObject current=null] : ( (lv_id_0_0= RULE_ID ) ) ;
    public final EObject ruleDomain() throws RecognitionException {
        EObject current = null;

        Token lv_id_0_0=null;

         enterRule(); 
            
        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1650:28: ( ( (lv_id_0_0= RULE_ID ) ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1651:1: ( (lv_id_0_0= RULE_ID ) )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1651:1: ( (lv_id_0_0= RULE_ID ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1652:1: (lv_id_0_0= RULE_ID )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1652:1: (lv_id_0_0= RULE_ID )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1653:3: lv_id_0_0= RULE_ID
            {
            lv_id_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDomain3536); 

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
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1677:1: entryRuleCodomain returns [EObject current=null] : iv_ruleCodomain= ruleCodomain EOF ;
    public final EObject entryRuleCodomain() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCodomain = null;


        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1678:2: (iv_ruleCodomain= ruleCodomain EOF )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1679:2: iv_ruleCodomain= ruleCodomain EOF
            {
             newCompositeNode(grammarAccess.getCodomainRule()); 
            pushFollow(FOLLOW_ruleCodomain_in_entryRuleCodomain3576);
            iv_ruleCodomain=ruleCodomain();

            state._fsp--;

             current =iv_ruleCodomain; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCodomain3586); 

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
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1686:1: ruleCodomain returns [EObject current=null] : ( (lv_id_0_0= RULE_ID ) ) ;
    public final EObject ruleCodomain() throws RecognitionException {
        EObject current = null;

        Token lv_id_0_0=null;

         enterRule(); 
            
        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1689:28: ( ( (lv_id_0_0= RULE_ID ) ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1690:1: ( (lv_id_0_0= RULE_ID ) )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1690:1: ( (lv_id_0_0= RULE_ID ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1691:1: (lv_id_0_0= RULE_ID )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1691:1: (lv_id_0_0= RULE_ID )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1692:3: lv_id_0_0= RULE_ID
            {
            lv_id_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleCodomain3627); 

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
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1716:1: entryRuleMapping returns [EObject current=null] : iv_ruleMapping= ruleMapping EOF ;
    public final EObject entryRuleMapping() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMapping = null;


        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1717:2: (iv_ruleMapping= ruleMapping EOF )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1718:2: iv_ruleMapping= ruleMapping EOF
            {
             newCompositeNode(grammarAccess.getMappingRule()); 
            pushFollow(FOLLOW_ruleMapping_in_entryRuleMapping3667);
            iv_ruleMapping=ruleMapping();

            state._fsp--;

             current =iv_ruleMapping; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMapping3677); 

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
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1725:1: ruleMapping returns [EObject current=null] : (this_MappingNode_0= ruleMappingNode | this_MappingArrow_1= ruleMappingArrow ) ;
    public final EObject ruleMapping() throws RecognitionException {
        EObject current = null;

        EObject this_MappingNode_0 = null;

        EObject this_MappingArrow_1 = null;


         enterRule(); 
            
        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1728:28: ( (this_MappingNode_0= ruleMappingNode | this_MappingArrow_1= ruleMappingArrow ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1729:1: (this_MappingNode_0= ruleMappingNode | this_MappingArrow_1= ruleMappingArrow )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1729:1: (this_MappingNode_0= ruleMappingNode | this_MappingArrow_1= ruleMappingArrow )
            int alt17=2;
            alt17 = dfa17.predict(input);
            switch (alt17) {
                case 1 :
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1730:5: this_MappingNode_0= ruleMappingNode
                    {
                     
                            newCompositeNode(grammarAccess.getMappingAccess().getMappingNodeParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleMappingNode_in_ruleMapping3724);
                    this_MappingNode_0=ruleMappingNode();

                    state._fsp--;

                     
                            current = this_MappingNode_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1740:5: this_MappingArrow_1= ruleMappingArrow
                    {
                     
                            newCompositeNode(grammarAccess.getMappingAccess().getMappingArrowParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleMappingArrow_in_ruleMapping3751);
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
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1756:1: entryRuleMappingNode returns [EObject current=null] : iv_ruleMappingNode= ruleMappingNode EOF ;
    public final EObject entryRuleMappingNode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMappingNode = null;


        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1757:2: (iv_ruleMappingNode= ruleMappingNode EOF )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1758:2: iv_ruleMappingNode= ruleMappingNode EOF
            {
             newCompositeNode(grammarAccess.getMappingNodeRule()); 
            pushFollow(FOLLOW_ruleMappingNode_in_entryRuleMappingNode3786);
            iv_ruleMappingNode=ruleMappingNode();

            state._fsp--;

             current =iv_ruleMappingNode; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMappingNode3796); 

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
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1765:1: ruleMappingNode returns [EObject current=null] : ( ( (lv_domain_0_0= ruleNode ) ) otherlv_1= '=>' ( (lv_codomain_2_0= ruleNode ) ) ) ;
    public final EObject ruleMappingNode() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_domain_0_0 = null;

        EObject lv_codomain_2_0 = null;


         enterRule(); 
            
        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1768:28: ( ( ( (lv_domain_0_0= ruleNode ) ) otherlv_1= '=>' ( (lv_codomain_2_0= ruleNode ) ) ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1769:1: ( ( (lv_domain_0_0= ruleNode ) ) otherlv_1= '=>' ( (lv_codomain_2_0= ruleNode ) ) )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1769:1: ( ( (lv_domain_0_0= ruleNode ) ) otherlv_1= '=>' ( (lv_codomain_2_0= ruleNode ) ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1769:2: ( (lv_domain_0_0= ruleNode ) ) otherlv_1= '=>' ( (lv_codomain_2_0= ruleNode ) )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1769:2: ( (lv_domain_0_0= ruleNode ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1770:1: (lv_domain_0_0= ruleNode )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1770:1: (lv_domain_0_0= ruleNode )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1771:3: lv_domain_0_0= ruleNode
            {
             
            	        newCompositeNode(grammarAccess.getMappingNodeAccess().getDomainNodeParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleNode_in_ruleMappingNode3842);
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

            otherlv_1=(Token)match(input,35,FOLLOW_35_in_ruleMappingNode3854); 

                	newLeafNode(otherlv_1, grammarAccess.getMappingNodeAccess().getEqualsSignGreaterThanSignKeyword_1());
                
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1791:1: ( (lv_codomain_2_0= ruleNode ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1792:1: (lv_codomain_2_0= ruleNode )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1792:1: (lv_codomain_2_0= ruleNode )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1793:3: lv_codomain_2_0= ruleNode
            {
             
            	        newCompositeNode(grammarAccess.getMappingNodeAccess().getCodomainNodeParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleNode_in_ruleMappingNode3875);
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
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1817:1: entryRuleMappingArrow returns [EObject current=null] : iv_ruleMappingArrow= ruleMappingArrow EOF ;
    public final EObject entryRuleMappingArrow() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMappingArrow = null;


        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1818:2: (iv_ruleMappingArrow= ruleMappingArrow EOF )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1819:2: iv_ruleMappingArrow= ruleMappingArrow EOF
            {
             newCompositeNode(grammarAccess.getMappingArrowRule()); 
            pushFollow(FOLLOW_ruleMappingArrow_in_entryRuleMappingArrow3911);
            iv_ruleMappingArrow=ruleMappingArrow();

            state._fsp--;

             current =iv_ruleMappingArrow; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMappingArrow3921); 

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
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1826:1: ruleMappingArrow returns [EObject current=null] : ( ( (lv_domain_0_0= ruleArrow ) ) otherlv_1= '=>' ( (lv_codmain_2_0= ruleArrow ) ) ) ;
    public final EObject ruleMappingArrow() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_domain_0_0 = null;

        EObject lv_codmain_2_0 = null;


         enterRule(); 
            
        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1829:28: ( ( ( (lv_domain_0_0= ruleArrow ) ) otherlv_1= '=>' ( (lv_codmain_2_0= ruleArrow ) ) ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1830:1: ( ( (lv_domain_0_0= ruleArrow ) ) otherlv_1= '=>' ( (lv_codmain_2_0= ruleArrow ) ) )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1830:1: ( ( (lv_domain_0_0= ruleArrow ) ) otherlv_1= '=>' ( (lv_codmain_2_0= ruleArrow ) ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1830:2: ( (lv_domain_0_0= ruleArrow ) ) otherlv_1= '=>' ( (lv_codmain_2_0= ruleArrow ) )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1830:2: ( (lv_domain_0_0= ruleArrow ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1831:1: (lv_domain_0_0= ruleArrow )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1831:1: (lv_domain_0_0= ruleArrow )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1832:3: lv_domain_0_0= ruleArrow
            {
             
            	        newCompositeNode(grammarAccess.getMappingArrowAccess().getDomainArrowParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleArrow_in_ruleMappingArrow3967);
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

            otherlv_1=(Token)match(input,35,FOLLOW_35_in_ruleMappingArrow3979); 

                	newLeafNode(otherlv_1, grammarAccess.getMappingArrowAccess().getEqualsSignGreaterThanSignKeyword_1());
                
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1852:1: ( (lv_codmain_2_0= ruleArrow ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1853:1: (lv_codmain_2_0= ruleArrow )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1853:1: (lv_codmain_2_0= ruleArrow )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1854:3: lv_codmain_2_0= ruleArrow
            {
             
            	        newCompositeNode(grammarAccess.getMappingArrowAccess().getCodmainArrowParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleArrow_in_ruleMappingArrow4000);
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
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1878:1: entryRuleExtSubTGraph returns [EObject current=null] : iv_ruleExtSubTGraph= ruleExtSubTGraph EOF ;
    public final EObject entryRuleExtSubTGraph() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExtSubTGraph = null;


        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1879:2: (iv_ruleExtSubTGraph= ruleExtSubTGraph EOF )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1880:2: iv_ruleExtSubTGraph= ruleExtSubTGraph EOF
            {
             newCompositeNode(grammarAccess.getExtSubTGraphRule()); 
            pushFollow(FOLLOW_ruleExtSubTGraph_in_entryRuleExtSubTGraph4036);
            iv_ruleExtSubTGraph=ruleExtSubTGraph();

            state._fsp--;

             current =iv_ruleExtSubTGraph; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleExtSubTGraph4046); 

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
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1887:1: ruleExtSubTGraph returns [EObject current=null] : ( ( (lv_id_0_0= RULE_ID ) ) otherlv_1= ':=' otherlv_2= 'ExtSubTGraph' otherlv_3= '<' ( (lv_extendsGraph_4_0= ruleChoosenExtSubTGraph ) ) otherlv_5= '>' otherlv_6= '{' ( ( (lv_elements_7_0= ruleElement ) ) (otherlv_8= ',' ( (lv_elements_9_0= ruleElement ) ) )* )? otherlv_10= '}' ) ;
    public final EObject ruleExtSubTGraph() throws RecognitionException {
        EObject current = null;

        Token lv_id_0_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        EObject lv_extendsGraph_4_0 = null;

        EObject lv_elements_7_0 = null;

        EObject lv_elements_9_0 = null;


         enterRule(); 
            
        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1890:28: ( ( ( (lv_id_0_0= RULE_ID ) ) otherlv_1= ':=' otherlv_2= 'ExtSubTGraph' otherlv_3= '<' ( (lv_extendsGraph_4_0= ruleChoosenExtSubTGraph ) ) otherlv_5= '>' otherlv_6= '{' ( ( (lv_elements_7_0= ruleElement ) ) (otherlv_8= ',' ( (lv_elements_9_0= ruleElement ) ) )* )? otherlv_10= '}' ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1891:1: ( ( (lv_id_0_0= RULE_ID ) ) otherlv_1= ':=' otherlv_2= 'ExtSubTGraph' otherlv_3= '<' ( (lv_extendsGraph_4_0= ruleChoosenExtSubTGraph ) ) otherlv_5= '>' otherlv_6= '{' ( ( (lv_elements_7_0= ruleElement ) ) (otherlv_8= ',' ( (lv_elements_9_0= ruleElement ) ) )* )? otherlv_10= '}' )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1891:1: ( ( (lv_id_0_0= RULE_ID ) ) otherlv_1= ':=' otherlv_2= 'ExtSubTGraph' otherlv_3= '<' ( (lv_extendsGraph_4_0= ruleChoosenExtSubTGraph ) ) otherlv_5= '>' otherlv_6= '{' ( ( (lv_elements_7_0= ruleElement ) ) (otherlv_8= ',' ( (lv_elements_9_0= ruleElement ) ) )* )? otherlv_10= '}' )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1891:2: ( (lv_id_0_0= RULE_ID ) ) otherlv_1= ':=' otherlv_2= 'ExtSubTGraph' otherlv_3= '<' ( (lv_extendsGraph_4_0= ruleChoosenExtSubTGraph ) ) otherlv_5= '>' otherlv_6= '{' ( ( (lv_elements_7_0= ruleElement ) ) (otherlv_8= ',' ( (lv_elements_9_0= ruleElement ) ) )* )? otherlv_10= '}'
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1891:2: ( (lv_id_0_0= RULE_ID ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1892:1: (lv_id_0_0= RULE_ID )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1892:1: (lv_id_0_0= RULE_ID )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1893:3: lv_id_0_0= RULE_ID
            {
            lv_id_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleExtSubTGraph4088); 

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

            otherlv_1=(Token)match(input,33,FOLLOW_33_in_ruleExtSubTGraph4105); 

                	newLeafNode(otherlv_1, grammarAccess.getExtSubTGraphAccess().getColonEqualsSignKeyword_1());
                
            otherlv_2=(Token)match(input,36,FOLLOW_36_in_ruleExtSubTGraph4117); 

                	newLeafNode(otherlv_2, grammarAccess.getExtSubTGraphAccess().getExtSubTGraphKeyword_2());
                
            otherlv_3=(Token)match(input,27,FOLLOW_27_in_ruleExtSubTGraph4129); 

                	newLeafNode(otherlv_3, grammarAccess.getExtSubTGraphAccess().getLessThanSignKeyword_3());
                
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1921:1: ( (lv_extendsGraph_4_0= ruleChoosenExtSubTGraph ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1922:1: (lv_extendsGraph_4_0= ruleChoosenExtSubTGraph )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1922:1: (lv_extendsGraph_4_0= ruleChoosenExtSubTGraph )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1923:3: lv_extendsGraph_4_0= ruleChoosenExtSubTGraph
            {
             
            	        newCompositeNode(grammarAccess.getExtSubTGraphAccess().getExtendsGraphChoosenExtSubTGraphParserRuleCall_4_0()); 
            	    
            pushFollow(FOLLOW_ruleChoosenExtSubTGraph_in_ruleExtSubTGraph4150);
            lv_extendsGraph_4_0=ruleChoosenExtSubTGraph();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getExtSubTGraphRule());
            	        }
                   		set(
                   			current, 
                   			"extendsGraph",
                    		lv_extendsGraph_4_0, 
                    		"ChoosenExtSubTGraph");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_5=(Token)match(input,28,FOLLOW_28_in_ruleExtSubTGraph4162); 

                	newLeafNode(otherlv_5, grammarAccess.getExtSubTGraphAccess().getGreaterThanSignKeyword_5());
                
            otherlv_6=(Token)match(input,29,FOLLOW_29_in_ruleExtSubTGraph4174); 

                	newLeafNode(otherlv_6, grammarAccess.getExtSubTGraphAccess().getLeftCurlyBracketKeyword_6());
                
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1947:1: ( ( (lv_elements_7_0= ruleElement ) ) (otherlv_8= ',' ( (lv_elements_9_0= ruleElement ) ) )* )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==RULE_ID) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1947:2: ( (lv_elements_7_0= ruleElement ) ) (otherlv_8= ',' ( (lv_elements_9_0= ruleElement ) ) )*
                    {
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1947:2: ( (lv_elements_7_0= ruleElement ) )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1948:1: (lv_elements_7_0= ruleElement )
                    {
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1948:1: (lv_elements_7_0= ruleElement )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1949:3: lv_elements_7_0= ruleElement
                    {
                     
                    	        newCompositeNode(grammarAccess.getExtSubTGraphAccess().getElementsElementParserRuleCall_7_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleElement_in_ruleExtSubTGraph4196);
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

                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1965:2: (otherlv_8= ',' ( (lv_elements_9_0= ruleElement ) ) )*
                    loop18:
                    do {
                        int alt18=2;
                        int LA18_0 = input.LA(1);

                        if ( (LA18_0==20) ) {
                            alt18=1;
                        }


                        switch (alt18) {
                    	case 1 :
                    	    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1965:4: otherlv_8= ',' ( (lv_elements_9_0= ruleElement ) )
                    	    {
                    	    otherlv_8=(Token)match(input,20,FOLLOW_20_in_ruleExtSubTGraph4209); 

                    	        	newLeafNode(otherlv_8, grammarAccess.getExtSubTGraphAccess().getCommaKeyword_7_1_0());
                    	        
                    	    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1969:1: ( (lv_elements_9_0= ruleElement ) )
                    	    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1970:1: (lv_elements_9_0= ruleElement )
                    	    {
                    	    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1970:1: (lv_elements_9_0= ruleElement )
                    	    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1971:3: lv_elements_9_0= ruleElement
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getExtSubTGraphAccess().getElementsElementParserRuleCall_7_1_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleElement_in_ruleExtSubTGraph4230);
                    	    lv_elements_9_0=ruleElement();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getExtSubTGraphRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"elements",
                    	            		lv_elements_9_0, 
                    	            		"Element");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop18;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_10=(Token)match(input,31,FOLLOW_31_in_ruleExtSubTGraph4246); 

                	newLeafNode(otherlv_10, grammarAccess.getExtSubTGraphAccess().getRightCurlyBracketKeyword_8());
                

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


    // $ANTLR start "entryRuleChoosenExtSubTGraph"
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1999:1: entryRuleChoosenExtSubTGraph returns [EObject current=null] : iv_ruleChoosenExtSubTGraph= ruleChoosenExtSubTGraph EOF ;
    public final EObject entryRuleChoosenExtSubTGraph() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleChoosenExtSubTGraph = null;


        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2000:2: (iv_ruleChoosenExtSubTGraph= ruleChoosenExtSubTGraph EOF )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2001:2: iv_ruleChoosenExtSubTGraph= ruleChoosenExtSubTGraph EOF
            {
             newCompositeNode(grammarAccess.getChoosenExtSubTGraphRule()); 
            pushFollow(FOLLOW_ruleChoosenExtSubTGraph_in_entryRuleChoosenExtSubTGraph4282);
            iv_ruleChoosenExtSubTGraph=ruleChoosenExtSubTGraph();

            state._fsp--;

             current =iv_ruleChoosenExtSubTGraph; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleChoosenExtSubTGraph4292); 

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
    // $ANTLR end "entryRuleChoosenExtSubTGraph"


    // $ANTLR start "ruleChoosenExtSubTGraph"
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2008:1: ruleChoosenExtSubTGraph returns [EObject current=null] : ( (lv_id_0_0= RULE_ID ) ) ;
    public final EObject ruleChoosenExtSubTGraph() throws RecognitionException {
        EObject current = null;

        Token lv_id_0_0=null;

         enterRule(); 
            
        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2011:28: ( ( (lv_id_0_0= RULE_ID ) ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2012:1: ( (lv_id_0_0= RULE_ID ) )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2012:1: ( (lv_id_0_0= RULE_ID ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2013:1: (lv_id_0_0= RULE_ID )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2013:1: (lv_id_0_0= RULE_ID )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2014:3: lv_id_0_0= RULE_ID
            {
            lv_id_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleChoosenExtSubTGraph4333); 

            			newLeafNode(lv_id_0_0, grammarAccess.getChoosenExtSubTGraphAccess().getIdIDTerminalRuleCall_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getChoosenExtSubTGraphRule());
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
    // $ANTLR end "ruleChoosenExtSubTGraph"


    // $ANTLR start "entryRuleGraph"
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2038:1: entryRuleGraph returns [EObject current=null] : iv_ruleGraph= ruleGraph EOF ;
    public final EObject entryRuleGraph() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGraph = null;


        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2039:2: (iv_ruleGraph= ruleGraph EOF )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2040:2: iv_ruleGraph= ruleGraph EOF
            {
             newCompositeNode(grammarAccess.getGraphRule()); 
            pushFollow(FOLLOW_ruleGraph_in_entryRuleGraph4373);
            iv_ruleGraph=ruleGraph();

            state._fsp--;

             current =iv_ruleGraph; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleGraph4383); 

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
    // $ANTLR end "entryRuleGraph"


    // $ANTLR start "ruleGraph"
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2047:1: ruleGraph returns [EObject current=null] : (otherlv_0= 'Graph' otherlv_1= '{' ( ( (lv_elements_2_0= ruleElement ) ) (otherlv_3= ',' ( (lv_elements_4_0= ruleElement ) ) )* )? otherlv_5= '}' ) ;
    public final EObject ruleGraph() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_elements_2_0 = null;

        EObject lv_elements_4_0 = null;


         enterRule(); 
            
        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2050:28: ( (otherlv_0= 'Graph' otherlv_1= '{' ( ( (lv_elements_2_0= ruleElement ) ) (otherlv_3= ',' ( (lv_elements_4_0= ruleElement ) ) )* )? otherlv_5= '}' ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2051:1: (otherlv_0= 'Graph' otherlv_1= '{' ( ( (lv_elements_2_0= ruleElement ) ) (otherlv_3= ',' ( (lv_elements_4_0= ruleElement ) ) )* )? otherlv_5= '}' )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2051:1: (otherlv_0= 'Graph' otherlv_1= '{' ( ( (lv_elements_2_0= ruleElement ) ) (otherlv_3= ',' ( (lv_elements_4_0= ruleElement ) ) )* )? otherlv_5= '}' )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2051:3: otherlv_0= 'Graph' otherlv_1= '{' ( ( (lv_elements_2_0= ruleElement ) ) (otherlv_3= ',' ( (lv_elements_4_0= ruleElement ) ) )* )? otherlv_5= '}'
            {
            otherlv_0=(Token)match(input,37,FOLLOW_37_in_ruleGraph4420); 

                	newLeafNode(otherlv_0, grammarAccess.getGraphAccess().getGraphKeyword_0());
                
            otherlv_1=(Token)match(input,29,FOLLOW_29_in_ruleGraph4432); 

                	newLeafNode(otherlv_1, grammarAccess.getGraphAccess().getLeftCurlyBracketKeyword_1());
                
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2059:1: ( ( (lv_elements_2_0= ruleElement ) ) (otherlv_3= ',' ( (lv_elements_4_0= ruleElement ) ) )* )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==RULE_ID) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2059:2: ( (lv_elements_2_0= ruleElement ) ) (otherlv_3= ',' ( (lv_elements_4_0= ruleElement ) ) )*
                    {
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2059:2: ( (lv_elements_2_0= ruleElement ) )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2060:1: (lv_elements_2_0= ruleElement )
                    {
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2060:1: (lv_elements_2_0= ruleElement )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2061:3: lv_elements_2_0= ruleElement
                    {
                     
                    	        newCompositeNode(grammarAccess.getGraphAccess().getElementsElementParserRuleCall_2_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleElement_in_ruleGraph4454);
                    lv_elements_2_0=ruleElement();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getGraphRule());
                    	        }
                           		add(
                           			current, 
                           			"elements",
                            		lv_elements_2_0, 
                            		"Element");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2077:2: (otherlv_3= ',' ( (lv_elements_4_0= ruleElement ) ) )*
                    loop20:
                    do {
                        int alt20=2;
                        int LA20_0 = input.LA(1);

                        if ( (LA20_0==20) ) {
                            alt20=1;
                        }


                        switch (alt20) {
                    	case 1 :
                    	    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2077:4: otherlv_3= ',' ( (lv_elements_4_0= ruleElement ) )
                    	    {
                    	    otherlv_3=(Token)match(input,20,FOLLOW_20_in_ruleGraph4467); 

                    	        	newLeafNode(otherlv_3, grammarAccess.getGraphAccess().getCommaKeyword_2_1_0());
                    	        
                    	    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2081:1: ( (lv_elements_4_0= ruleElement ) )
                    	    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2082:1: (lv_elements_4_0= ruleElement )
                    	    {
                    	    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2082:1: (lv_elements_4_0= ruleElement )
                    	    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2083:3: lv_elements_4_0= ruleElement
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getGraphAccess().getElementsElementParserRuleCall_2_1_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleElement_in_ruleGraph4488);
                    	    lv_elements_4_0=ruleElement();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getGraphRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"elements",
                    	            		lv_elements_4_0, 
                    	            		"Element");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop20;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_5=(Token)match(input,31,FOLLOW_31_in_ruleGraph4504); 

                	newLeafNode(otherlv_5, grammarAccess.getGraphAccess().getRightCurlyBracketKeyword_3());
                

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
    // $ANTLR end "ruleGraph"


    // $ANTLR start "entryRuleElement"
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2111:1: entryRuleElement returns [EObject current=null] : iv_ruleElement= ruleElement EOF ;
    public final EObject entryRuleElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleElement = null;


        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2112:2: (iv_ruleElement= ruleElement EOF )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2113:2: iv_ruleElement= ruleElement EOF
            {
             newCompositeNode(grammarAccess.getElementRule()); 
            pushFollow(FOLLOW_ruleElement_in_entryRuleElement4540);
            iv_ruleElement=ruleElement();

            state._fsp--;

             current =iv_ruleElement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleElement4550); 

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
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2120:1: ruleElement returns [EObject current=null] : (this_Node_0= ruleNode | this_Arrows_1= ruleArrows ) ;
    public final EObject ruleElement() throws RecognitionException {
        EObject current = null;

        EObject this_Node_0 = null;

        EObject this_Arrows_1 = null;


         enterRule(); 
            
        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2123:28: ( (this_Node_0= ruleNode | this_Arrows_1= ruleArrows ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2124:1: (this_Node_0= ruleNode | this_Arrows_1= ruleArrows )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2124:1: (this_Node_0= ruleNode | this_Arrows_1= ruleArrows )
            int alt22=2;
            alt22 = dfa22.predict(input);
            switch (alt22) {
                case 1 :
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2125:5: this_Node_0= ruleNode
                    {
                     
                            newCompositeNode(grammarAccess.getElementAccess().getNodeParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleNode_in_ruleElement4597);
                    this_Node_0=ruleNode();

                    state._fsp--;

                     
                            current = this_Node_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2135:5: this_Arrows_1= ruleArrows
                    {
                     
                            newCompositeNode(grammarAccess.getElementAccess().getArrowsParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleArrows_in_ruleElement4624);
                    this_Arrows_1=ruleArrows();

                    state._fsp--;

                     
                            current = this_Arrows_1; 
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
    // $ANTLR end "ruleElement"


    // $ANTLR start "entryRuleArrows"
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2151:1: entryRuleArrows returns [EObject current=null] : iv_ruleArrows= ruleArrows EOF ;
    public final EObject entryRuleArrows() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArrows = null;


        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2152:2: (iv_ruleArrows= ruleArrows EOF )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2153:2: iv_ruleArrows= ruleArrows EOF
            {
             newCompositeNode(grammarAccess.getArrowsRule()); 
            pushFollow(FOLLOW_ruleArrows_in_entryRuleArrows4659);
            iv_ruleArrows=ruleArrows();

            state._fsp--;

             current =iv_ruleArrows; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleArrows4669); 

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
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2160:1: ruleArrows returns [EObject current=null] : ( ( ( (lv_sr_0_0= ruleNode ) ) otherlv_1= '-' ( (lv_id_2_0= ruleDpfId ) ) otherlv_3= ':' ( (lv_type_4_0= ruleDpfId ) ) otherlv_5= '->' ( (lv_next_6_0= ruleArrows ) ) ) | this_Arrow_7= ruleArrow ) ;
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
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2163:28: ( ( ( ( (lv_sr_0_0= ruleNode ) ) otherlv_1= '-' ( (lv_id_2_0= ruleDpfId ) ) otherlv_3= ':' ( (lv_type_4_0= ruleDpfId ) ) otherlv_5= '->' ( (lv_next_6_0= ruleArrows ) ) ) | this_Arrow_7= ruleArrow ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2164:1: ( ( ( (lv_sr_0_0= ruleNode ) ) otherlv_1= '-' ( (lv_id_2_0= ruleDpfId ) ) otherlv_3= ':' ( (lv_type_4_0= ruleDpfId ) ) otherlv_5= '->' ( (lv_next_6_0= ruleArrows ) ) ) | this_Arrow_7= ruleArrow )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2164:1: ( ( ( (lv_sr_0_0= ruleNode ) ) otherlv_1= '-' ( (lv_id_2_0= ruleDpfId ) ) otherlv_3= ':' ( (lv_type_4_0= ruleDpfId ) ) otherlv_5= '->' ( (lv_next_6_0= ruleArrows ) ) ) | this_Arrow_7= ruleArrow )
            int alt23=2;
            alt23 = dfa23.predict(input);
            switch (alt23) {
                case 1 :
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2164:2: ( ( (lv_sr_0_0= ruleNode ) ) otherlv_1= '-' ( (lv_id_2_0= ruleDpfId ) ) otherlv_3= ':' ( (lv_type_4_0= ruleDpfId ) ) otherlv_5= '->' ( (lv_next_6_0= ruleArrows ) ) )
                    {
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2164:2: ( ( (lv_sr_0_0= ruleNode ) ) otherlv_1= '-' ( (lv_id_2_0= ruleDpfId ) ) otherlv_3= ':' ( (lv_type_4_0= ruleDpfId ) ) otherlv_5= '->' ( (lv_next_6_0= ruleArrows ) ) )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2164:3: ( (lv_sr_0_0= ruleNode ) ) otherlv_1= '-' ( (lv_id_2_0= ruleDpfId ) ) otherlv_3= ':' ( (lv_type_4_0= ruleDpfId ) ) otherlv_5= '->' ( (lv_next_6_0= ruleArrows ) )
                    {
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2164:3: ( (lv_sr_0_0= ruleNode ) )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2165:1: (lv_sr_0_0= ruleNode )
                    {
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2165:1: (lv_sr_0_0= ruleNode )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2166:3: lv_sr_0_0= ruleNode
                    {
                     
                    	        newCompositeNode(grammarAccess.getArrowsAccess().getSrNodeParserRuleCall_0_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleNode_in_ruleArrows4716);
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

                    otherlv_1=(Token)match(input,38,FOLLOW_38_in_ruleArrows4728); 

                        	newLeafNode(otherlv_1, grammarAccess.getArrowsAccess().getHyphenMinusKeyword_0_1());
                        
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2186:1: ( (lv_id_2_0= ruleDpfId ) )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2187:1: (lv_id_2_0= ruleDpfId )
                    {
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2187:1: (lv_id_2_0= ruleDpfId )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2188:3: lv_id_2_0= ruleDpfId
                    {
                     
                    	        newCompositeNode(grammarAccess.getArrowsAccess().getIdDpfIdParserRuleCall_0_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDpfId_in_ruleArrows4749);
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

                    otherlv_3=(Token)match(input,25,FOLLOW_25_in_ruleArrows4761); 

                        	newLeafNode(otherlv_3, grammarAccess.getArrowsAccess().getColonKeyword_0_3());
                        
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2208:1: ( (lv_type_4_0= ruleDpfId ) )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2209:1: (lv_type_4_0= ruleDpfId )
                    {
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2209:1: (lv_type_4_0= ruleDpfId )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2210:3: lv_type_4_0= ruleDpfId
                    {
                     
                    	        newCompositeNode(grammarAccess.getArrowsAccess().getTypeDpfIdParserRuleCall_0_4_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDpfId_in_ruleArrows4782);
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

                    otherlv_5=(Token)match(input,19,FOLLOW_19_in_ruleArrows4794); 

                        	newLeafNode(otherlv_5, grammarAccess.getArrowsAccess().getHyphenMinusGreaterThanSignKeyword_0_5());
                        
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2230:1: ( (lv_next_6_0= ruleArrows ) )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2231:1: (lv_next_6_0= ruleArrows )
                    {
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2231:1: (lv_next_6_0= ruleArrows )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2232:3: lv_next_6_0= ruleArrows
                    {
                     
                    	        newCompositeNode(grammarAccess.getArrowsAccess().getNextArrowsParserRuleCall_0_6_0()); 
                    	    
                    pushFollow(FOLLOW_ruleArrows_in_ruleArrows4815);
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
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2250:5: this_Arrow_7= ruleArrow
                    {
                     
                            newCompositeNode(grammarAccess.getArrowsAccess().getArrowParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleArrow_in_ruleArrows4844);
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
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2266:1: entryRuleArrow returns [EObject current=null] : iv_ruleArrow= ruleArrow EOF ;
    public final EObject entryRuleArrow() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArrow = null;


        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2267:2: (iv_ruleArrow= ruleArrow EOF )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2268:2: iv_ruleArrow= ruleArrow EOF
            {
             newCompositeNode(grammarAccess.getArrowRule()); 
            pushFollow(FOLLOW_ruleArrow_in_entryRuleArrow4879);
            iv_ruleArrow=ruleArrow();

            state._fsp--;

             current =iv_ruleArrow; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleArrow4889); 

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
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2275:1: ruleArrow returns [EObject current=null] : ( ( ( (lv_sr_0_0= ruleNode ) ) otherlv_1= '-' ( (lv_id_2_0= ruleDpfId ) ) otherlv_3= ':' otherlv_4= '*' otherlv_5= '->' ( (lv_tgDataType_6_0= ruleDataType ) ) ) | ( ( (lv_sr_7_0= ruleNode ) ) otherlv_8= '-' ( (lv_id_9_0= ruleDpfId ) ) otherlv_10= ':' ( (lv_type_11_0= ruleDpfId ) ) otherlv_12= '->' ( (lv_tgValue_13_0= ruleAttributeValue ) ) ) | ( ( (lv_sr_14_0= ruleNode ) ) otherlv_15= '-' ( (lv_id_16_0= ruleDpfId ) ) otherlv_17= ':' ( (lv_type_18_0= ruleDpfId ) ) otherlv_19= '->' ( (lv_tgNode_20_0= ruleNode ) ) ) ) ;
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
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2278:28: ( ( ( ( (lv_sr_0_0= ruleNode ) ) otherlv_1= '-' ( (lv_id_2_0= ruleDpfId ) ) otherlv_3= ':' otherlv_4= '*' otherlv_5= '->' ( (lv_tgDataType_6_0= ruleDataType ) ) ) | ( ( (lv_sr_7_0= ruleNode ) ) otherlv_8= '-' ( (lv_id_9_0= ruleDpfId ) ) otherlv_10= ':' ( (lv_type_11_0= ruleDpfId ) ) otherlv_12= '->' ( (lv_tgValue_13_0= ruleAttributeValue ) ) ) | ( ( (lv_sr_14_0= ruleNode ) ) otherlv_15= '-' ( (lv_id_16_0= ruleDpfId ) ) otherlv_17= ':' ( (lv_type_18_0= ruleDpfId ) ) otherlv_19= '->' ( (lv_tgNode_20_0= ruleNode ) ) ) ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2279:1: ( ( ( (lv_sr_0_0= ruleNode ) ) otherlv_1= '-' ( (lv_id_2_0= ruleDpfId ) ) otherlv_3= ':' otherlv_4= '*' otherlv_5= '->' ( (lv_tgDataType_6_0= ruleDataType ) ) ) | ( ( (lv_sr_7_0= ruleNode ) ) otherlv_8= '-' ( (lv_id_9_0= ruleDpfId ) ) otherlv_10= ':' ( (lv_type_11_0= ruleDpfId ) ) otherlv_12= '->' ( (lv_tgValue_13_0= ruleAttributeValue ) ) ) | ( ( (lv_sr_14_0= ruleNode ) ) otherlv_15= '-' ( (lv_id_16_0= ruleDpfId ) ) otherlv_17= ':' ( (lv_type_18_0= ruleDpfId ) ) otherlv_19= '->' ( (lv_tgNode_20_0= ruleNode ) ) ) )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2279:1: ( ( ( (lv_sr_0_0= ruleNode ) ) otherlv_1= '-' ( (lv_id_2_0= ruleDpfId ) ) otherlv_3= ':' otherlv_4= '*' otherlv_5= '->' ( (lv_tgDataType_6_0= ruleDataType ) ) ) | ( ( (lv_sr_7_0= ruleNode ) ) otherlv_8= '-' ( (lv_id_9_0= ruleDpfId ) ) otherlv_10= ':' ( (lv_type_11_0= ruleDpfId ) ) otherlv_12= '->' ( (lv_tgValue_13_0= ruleAttributeValue ) ) ) | ( ( (lv_sr_14_0= ruleNode ) ) otherlv_15= '-' ( (lv_id_16_0= ruleDpfId ) ) otherlv_17= ':' ( (lv_type_18_0= ruleDpfId ) ) otherlv_19= '->' ( (lv_tgNode_20_0= ruleNode ) ) ) )
            int alt24=3;
            alt24 = dfa24.predict(input);
            switch (alt24) {
                case 1 :
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2279:2: ( ( (lv_sr_0_0= ruleNode ) ) otherlv_1= '-' ( (lv_id_2_0= ruleDpfId ) ) otherlv_3= ':' otherlv_4= '*' otherlv_5= '->' ( (lv_tgDataType_6_0= ruleDataType ) ) )
                    {
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2279:2: ( ( (lv_sr_0_0= ruleNode ) ) otherlv_1= '-' ( (lv_id_2_0= ruleDpfId ) ) otherlv_3= ':' otherlv_4= '*' otherlv_5= '->' ( (lv_tgDataType_6_0= ruleDataType ) ) )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2279:3: ( (lv_sr_0_0= ruleNode ) ) otherlv_1= '-' ( (lv_id_2_0= ruleDpfId ) ) otherlv_3= ':' otherlv_4= '*' otherlv_5= '->' ( (lv_tgDataType_6_0= ruleDataType ) )
                    {
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2279:3: ( (lv_sr_0_0= ruleNode ) )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2280:1: (lv_sr_0_0= ruleNode )
                    {
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2280:1: (lv_sr_0_0= ruleNode )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2281:3: lv_sr_0_0= ruleNode
                    {
                     
                    	        newCompositeNode(grammarAccess.getArrowAccess().getSrNodeParserRuleCall_0_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleNode_in_ruleArrow4936);
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

                    otherlv_1=(Token)match(input,38,FOLLOW_38_in_ruleArrow4948); 

                        	newLeafNode(otherlv_1, grammarAccess.getArrowAccess().getHyphenMinusKeyword_0_1());
                        
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2301:1: ( (lv_id_2_0= ruleDpfId ) )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2302:1: (lv_id_2_0= ruleDpfId )
                    {
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2302:1: (lv_id_2_0= ruleDpfId )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2303:3: lv_id_2_0= ruleDpfId
                    {
                     
                    	        newCompositeNode(grammarAccess.getArrowAccess().getIdDpfIdParserRuleCall_0_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDpfId_in_ruleArrow4969);
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

                    otherlv_3=(Token)match(input,25,FOLLOW_25_in_ruleArrow4981); 

                        	newLeafNode(otherlv_3, grammarAccess.getArrowAccess().getColonKeyword_0_3());
                        
                    otherlv_4=(Token)match(input,39,FOLLOW_39_in_ruleArrow4993); 

                        	newLeafNode(otherlv_4, grammarAccess.getArrowAccess().getAsteriskKeyword_0_4());
                        
                    otherlv_5=(Token)match(input,19,FOLLOW_19_in_ruleArrow5005); 

                        	newLeafNode(otherlv_5, grammarAccess.getArrowAccess().getHyphenMinusGreaterThanSignKeyword_0_5());
                        
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2331:1: ( (lv_tgDataType_6_0= ruleDataType ) )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2332:1: (lv_tgDataType_6_0= ruleDataType )
                    {
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2332:1: (lv_tgDataType_6_0= ruleDataType )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2333:3: lv_tgDataType_6_0= ruleDataType
                    {
                     
                    	        newCompositeNode(grammarAccess.getArrowAccess().getTgDataTypeDataTypeEnumRuleCall_0_6_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDataType_in_ruleArrow5026);
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
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2350:6: ( ( (lv_sr_7_0= ruleNode ) ) otherlv_8= '-' ( (lv_id_9_0= ruleDpfId ) ) otherlv_10= ':' ( (lv_type_11_0= ruleDpfId ) ) otherlv_12= '->' ( (lv_tgValue_13_0= ruleAttributeValue ) ) )
                    {
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2350:6: ( ( (lv_sr_7_0= ruleNode ) ) otherlv_8= '-' ( (lv_id_9_0= ruleDpfId ) ) otherlv_10= ':' ( (lv_type_11_0= ruleDpfId ) ) otherlv_12= '->' ( (lv_tgValue_13_0= ruleAttributeValue ) ) )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2350:7: ( (lv_sr_7_0= ruleNode ) ) otherlv_8= '-' ( (lv_id_9_0= ruleDpfId ) ) otherlv_10= ':' ( (lv_type_11_0= ruleDpfId ) ) otherlv_12= '->' ( (lv_tgValue_13_0= ruleAttributeValue ) )
                    {
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2350:7: ( (lv_sr_7_0= ruleNode ) )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2351:1: (lv_sr_7_0= ruleNode )
                    {
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2351:1: (lv_sr_7_0= ruleNode )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2352:3: lv_sr_7_0= ruleNode
                    {
                     
                    	        newCompositeNode(grammarAccess.getArrowAccess().getSrNodeParserRuleCall_1_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleNode_in_ruleArrow5055);
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

                    otherlv_8=(Token)match(input,38,FOLLOW_38_in_ruleArrow5067); 

                        	newLeafNode(otherlv_8, grammarAccess.getArrowAccess().getHyphenMinusKeyword_1_1());
                        
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2372:1: ( (lv_id_9_0= ruleDpfId ) )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2373:1: (lv_id_9_0= ruleDpfId )
                    {
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2373:1: (lv_id_9_0= ruleDpfId )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2374:3: lv_id_9_0= ruleDpfId
                    {
                     
                    	        newCompositeNode(grammarAccess.getArrowAccess().getIdDpfIdParserRuleCall_1_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDpfId_in_ruleArrow5088);
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

                    otherlv_10=(Token)match(input,25,FOLLOW_25_in_ruleArrow5100); 

                        	newLeafNode(otherlv_10, grammarAccess.getArrowAccess().getColonKeyword_1_3());
                        
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2394:1: ( (lv_type_11_0= ruleDpfId ) )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2395:1: (lv_type_11_0= ruleDpfId )
                    {
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2395:1: (lv_type_11_0= ruleDpfId )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2396:3: lv_type_11_0= ruleDpfId
                    {
                     
                    	        newCompositeNode(grammarAccess.getArrowAccess().getTypeDpfIdParserRuleCall_1_4_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDpfId_in_ruleArrow5121);
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

                    otherlv_12=(Token)match(input,19,FOLLOW_19_in_ruleArrow5133); 

                        	newLeafNode(otherlv_12, grammarAccess.getArrowAccess().getHyphenMinusGreaterThanSignKeyword_1_5());
                        
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2416:1: ( (lv_tgValue_13_0= ruleAttributeValue ) )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2417:1: (lv_tgValue_13_0= ruleAttributeValue )
                    {
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2417:1: (lv_tgValue_13_0= ruleAttributeValue )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2418:3: lv_tgValue_13_0= ruleAttributeValue
                    {
                     
                    	        newCompositeNode(grammarAccess.getArrowAccess().getTgValueAttributeValueParserRuleCall_1_6_0()); 
                    	    
                    pushFollow(FOLLOW_ruleAttributeValue_in_ruleArrow5154);
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
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2435:6: ( ( (lv_sr_14_0= ruleNode ) ) otherlv_15= '-' ( (lv_id_16_0= ruleDpfId ) ) otherlv_17= ':' ( (lv_type_18_0= ruleDpfId ) ) otherlv_19= '->' ( (lv_tgNode_20_0= ruleNode ) ) )
                    {
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2435:6: ( ( (lv_sr_14_0= ruleNode ) ) otherlv_15= '-' ( (lv_id_16_0= ruleDpfId ) ) otherlv_17= ':' ( (lv_type_18_0= ruleDpfId ) ) otherlv_19= '->' ( (lv_tgNode_20_0= ruleNode ) ) )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2435:7: ( (lv_sr_14_0= ruleNode ) ) otherlv_15= '-' ( (lv_id_16_0= ruleDpfId ) ) otherlv_17= ':' ( (lv_type_18_0= ruleDpfId ) ) otherlv_19= '->' ( (lv_tgNode_20_0= ruleNode ) )
                    {
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2435:7: ( (lv_sr_14_0= ruleNode ) )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2436:1: (lv_sr_14_0= ruleNode )
                    {
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2436:1: (lv_sr_14_0= ruleNode )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2437:3: lv_sr_14_0= ruleNode
                    {
                     
                    	        newCompositeNode(grammarAccess.getArrowAccess().getSrNodeParserRuleCall_2_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleNode_in_ruleArrow5183);
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

                    otherlv_15=(Token)match(input,38,FOLLOW_38_in_ruleArrow5195); 

                        	newLeafNode(otherlv_15, grammarAccess.getArrowAccess().getHyphenMinusKeyword_2_1());
                        
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2457:1: ( (lv_id_16_0= ruleDpfId ) )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2458:1: (lv_id_16_0= ruleDpfId )
                    {
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2458:1: (lv_id_16_0= ruleDpfId )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2459:3: lv_id_16_0= ruleDpfId
                    {
                     
                    	        newCompositeNode(grammarAccess.getArrowAccess().getIdDpfIdParserRuleCall_2_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDpfId_in_ruleArrow5216);
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

                    otherlv_17=(Token)match(input,25,FOLLOW_25_in_ruleArrow5228); 

                        	newLeafNode(otherlv_17, grammarAccess.getArrowAccess().getColonKeyword_2_3());
                        
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2479:1: ( (lv_type_18_0= ruleDpfId ) )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2480:1: (lv_type_18_0= ruleDpfId )
                    {
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2480:1: (lv_type_18_0= ruleDpfId )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2481:3: lv_type_18_0= ruleDpfId
                    {
                     
                    	        newCompositeNode(grammarAccess.getArrowAccess().getTypeDpfIdParserRuleCall_2_4_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDpfId_in_ruleArrow5249);
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

                    otherlv_19=(Token)match(input,19,FOLLOW_19_in_ruleArrow5261); 

                        	newLeafNode(otherlv_19, grammarAccess.getArrowAccess().getHyphenMinusGreaterThanSignKeyword_2_5());
                        
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2501:1: ( (lv_tgNode_20_0= ruleNode ) )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2502:1: (lv_tgNode_20_0= ruleNode )
                    {
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2502:1: (lv_tgNode_20_0= ruleNode )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2503:3: lv_tgNode_20_0= ruleNode
                    {
                     
                    	        newCompositeNode(grammarAccess.getArrowAccess().getTgNodeNodeParserRuleCall_2_6_0()); 
                    	    
                    pushFollow(FOLLOW_ruleNode_in_ruleArrow5282);
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
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2527:1: entryRuleNode returns [EObject current=null] : iv_ruleNode= ruleNode EOF ;
    public final EObject entryRuleNode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNode = null;


        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2528:2: (iv_ruleNode= ruleNode EOF )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2529:2: iv_ruleNode= ruleNode EOF
            {
             newCompositeNode(grammarAccess.getNodeRule()); 
            pushFollow(FOLLOW_ruleNode_in_entryRuleNode5319);
            iv_ruleNode=ruleNode();

            state._fsp--;

             current =iv_ruleNode; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNode5329); 

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
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2536:1: ruleNode returns [EObject current=null] : ( ( (lv_id_0_0= ruleDpfId ) ) otherlv_1= ':' ( (lv_type_2_0= ruleDpfId ) ) ) ;
    public final EObject ruleNode() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_id_0_0 = null;

        EObject lv_type_2_0 = null;


         enterRule(); 
            
        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2539:28: ( ( ( (lv_id_0_0= ruleDpfId ) ) otherlv_1= ':' ( (lv_type_2_0= ruleDpfId ) ) ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2540:1: ( ( (lv_id_0_0= ruleDpfId ) ) otherlv_1= ':' ( (lv_type_2_0= ruleDpfId ) ) )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2540:1: ( ( (lv_id_0_0= ruleDpfId ) ) otherlv_1= ':' ( (lv_type_2_0= ruleDpfId ) ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2540:2: ( (lv_id_0_0= ruleDpfId ) ) otherlv_1= ':' ( (lv_type_2_0= ruleDpfId ) )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2540:2: ( (lv_id_0_0= ruleDpfId ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2541:1: (lv_id_0_0= ruleDpfId )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2541:1: (lv_id_0_0= ruleDpfId )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2542:3: lv_id_0_0= ruleDpfId
            {
             
            	        newCompositeNode(grammarAccess.getNodeAccess().getIdDpfIdParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleDpfId_in_ruleNode5375);
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

            otherlv_1=(Token)match(input,25,FOLLOW_25_in_ruleNode5387); 

                	newLeafNode(otherlv_1, grammarAccess.getNodeAccess().getColonKeyword_1());
                
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2562:1: ( (lv_type_2_0= ruleDpfId ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2563:1: (lv_type_2_0= ruleDpfId )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2563:1: (lv_type_2_0= ruleDpfId )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2564:3: lv_type_2_0= ruleDpfId
            {
             
            	        newCompositeNode(grammarAccess.getNodeAccess().getTypeDpfIdParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleDpfId_in_ruleNode5408);
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
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2588:1: entryRuleAttributeValue returns [EObject current=null] : iv_ruleAttributeValue= ruleAttributeValue EOF ;
    public final EObject entryRuleAttributeValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttributeValue = null;


        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2589:2: (iv_ruleAttributeValue= ruleAttributeValue EOF )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2590:2: iv_ruleAttributeValue= ruleAttributeValue EOF
            {
             newCompositeNode(grammarAccess.getAttributeValueRule()); 
            pushFollow(FOLLOW_ruleAttributeValue_in_entryRuleAttributeValue5444);
            iv_ruleAttributeValue=ruleAttributeValue();

            state._fsp--;

             current =iv_ruleAttributeValue; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAttributeValue5454); 

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
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2597:1: ruleAttributeValue returns [EObject current=null] : (otherlv_0= '[' ( (lv_value_1_0= ruleVALUE ) ) otherlv_2= ']' ) ;
    public final EObject ruleAttributeValue() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        AntlrDatatypeRuleToken lv_value_1_0 = null;


         enterRule(); 
            
        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2600:28: ( (otherlv_0= '[' ( (lv_value_1_0= ruleVALUE ) ) otherlv_2= ']' ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2601:1: (otherlv_0= '[' ( (lv_value_1_0= ruleVALUE ) ) otherlv_2= ']' )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2601:1: (otherlv_0= '[' ( (lv_value_1_0= ruleVALUE ) ) otherlv_2= ']' )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2601:3: otherlv_0= '[' ( (lv_value_1_0= ruleVALUE ) ) otherlv_2= ']'
            {
            otherlv_0=(Token)match(input,40,FOLLOW_40_in_ruleAttributeValue5491); 

                	newLeafNode(otherlv_0, grammarAccess.getAttributeValueAccess().getLeftSquareBracketKeyword_0());
                
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2605:1: ( (lv_value_1_0= ruleVALUE ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2606:1: (lv_value_1_0= ruleVALUE )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2606:1: (lv_value_1_0= ruleVALUE )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2607:3: lv_value_1_0= ruleVALUE
            {
             
            	        newCompositeNode(grammarAccess.getAttributeValueAccess().getValueVALUEParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleVALUE_in_ruleAttributeValue5512);
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

            otherlv_2=(Token)match(input,41,FOLLOW_41_in_ruleAttributeValue5524); 

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
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2635:1: entryRuleDpfId returns [EObject current=null] : iv_ruleDpfId= ruleDpfId EOF ;
    public final EObject entryRuleDpfId() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDpfId = null;


        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2636:2: (iv_ruleDpfId= ruleDpfId EOF )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2637:2: iv_ruleDpfId= ruleDpfId EOF
            {
             newCompositeNode(grammarAccess.getDpfIdRule()); 
            pushFollow(FOLLOW_ruleDpfId_in_entryRuleDpfId5560);
            iv_ruleDpfId=ruleDpfId();

            state._fsp--;

             current =iv_ruleDpfId; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDpfId5570); 

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
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2644:1: ruleDpfId returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '@' ( (lv_id_2_0= RULE_INT ) ) )? ) ;
    public final EObject ruleDpfId() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token lv_id_2_0=null;

         enterRule(); 
            
        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2647:28: ( ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '@' ( (lv_id_2_0= RULE_INT ) ) )? ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2648:1: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '@' ( (lv_id_2_0= RULE_INT ) ) )? )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2648:1: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '@' ( (lv_id_2_0= RULE_INT ) ) )? )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2648:2: ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '@' ( (lv_id_2_0= RULE_INT ) ) )?
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2648:2: ( (lv_name_0_0= RULE_ID ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2649:1: (lv_name_0_0= RULE_ID )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2649:1: (lv_name_0_0= RULE_ID )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2650:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDpfId5612); 

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

            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2666:2: (otherlv_1= '@' ( (lv_id_2_0= RULE_INT ) ) )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==42) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2666:4: otherlv_1= '@' ( (lv_id_2_0= RULE_INT ) )
                    {
                    otherlv_1=(Token)match(input,42,FOLLOW_42_in_ruleDpfId5630); 

                        	newLeafNode(otherlv_1, grammarAccess.getDpfIdAccess().getCommercialAtKeyword_1_0());
                        
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2670:1: ( (lv_id_2_0= RULE_INT ) )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2671:1: (lv_id_2_0= RULE_INT )
                    {
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2671:1: (lv_id_2_0= RULE_INT )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2672:3: lv_id_2_0= RULE_INT
                    {
                    lv_id_2_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleDpfId5647); 

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
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2696:1: ruleDataType returns [Enumerator current=null] : ( (enumLiteral_0= 'Boolean' ) | (enumLiteral_1= 'Char' ) | (enumLiteral_2= 'Byte' ) | (enumLiteral_3= 'Short' ) | (enumLiteral_4= 'Int' ) | (enumLiteral_5= 'Long' ) | (enumLiteral_6= 'Float' ) | (enumLiteral_7= 'Double' ) | (enumLiteral_8= 'String' ) ) ;
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
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2698:28: ( ( (enumLiteral_0= 'Boolean' ) | (enumLiteral_1= 'Char' ) | (enumLiteral_2= 'Byte' ) | (enumLiteral_3= 'Short' ) | (enumLiteral_4= 'Int' ) | (enumLiteral_5= 'Long' ) | (enumLiteral_6= 'Float' ) | (enumLiteral_7= 'Double' ) | (enumLiteral_8= 'String' ) ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2699:1: ( (enumLiteral_0= 'Boolean' ) | (enumLiteral_1= 'Char' ) | (enumLiteral_2= 'Byte' ) | (enumLiteral_3= 'Short' ) | (enumLiteral_4= 'Int' ) | (enumLiteral_5= 'Long' ) | (enumLiteral_6= 'Float' ) | (enumLiteral_7= 'Double' ) | (enumLiteral_8= 'String' ) )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2699:1: ( (enumLiteral_0= 'Boolean' ) | (enumLiteral_1= 'Char' ) | (enumLiteral_2= 'Byte' ) | (enumLiteral_3= 'Short' ) | (enumLiteral_4= 'Int' ) | (enumLiteral_5= 'Long' ) | (enumLiteral_6= 'Float' ) | (enumLiteral_7= 'Double' ) | (enumLiteral_8= 'String' ) )
            int alt26=9;
            switch ( input.LA(1) ) {
            case 43:
                {
                alt26=1;
                }
                break;
            case 44:
                {
                alt26=2;
                }
                break;
            case 45:
                {
                alt26=3;
                }
                break;
            case 46:
                {
                alt26=4;
                }
                break;
            case 47:
                {
                alt26=5;
                }
                break;
            case 48:
                {
                alt26=6;
                }
                break;
            case 49:
                {
                alt26=7;
                }
                break;
            case 50:
                {
                alt26=8;
                }
                break;
            case 51:
                {
                alt26=9;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 26, 0, input);

                throw nvae;
            }

            switch (alt26) {
                case 1 :
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2699:2: (enumLiteral_0= 'Boolean' )
                    {
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2699:2: (enumLiteral_0= 'Boolean' )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2699:4: enumLiteral_0= 'Boolean'
                    {
                    enumLiteral_0=(Token)match(input,43,FOLLOW_43_in_ruleDataType5704); 

                            current = grammarAccess.getDataTypeAccess().getTBOOLEANEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getDataTypeAccess().getTBOOLEANEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2705:6: (enumLiteral_1= 'Char' )
                    {
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2705:6: (enumLiteral_1= 'Char' )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2705:8: enumLiteral_1= 'Char'
                    {
                    enumLiteral_1=(Token)match(input,44,FOLLOW_44_in_ruleDataType5721); 

                            current = grammarAccess.getDataTypeAccess().getTCHAREnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getDataTypeAccess().getTCHAREnumLiteralDeclaration_1()); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2711:6: (enumLiteral_2= 'Byte' )
                    {
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2711:6: (enumLiteral_2= 'Byte' )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2711:8: enumLiteral_2= 'Byte'
                    {
                    enumLiteral_2=(Token)match(input,45,FOLLOW_45_in_ruleDataType5738); 

                            current = grammarAccess.getDataTypeAccess().getTBYTEEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_2, grammarAccess.getDataTypeAccess().getTBYTEEnumLiteralDeclaration_2()); 
                        

                    }


                    }
                    break;
                case 4 :
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2717:6: (enumLiteral_3= 'Short' )
                    {
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2717:6: (enumLiteral_3= 'Short' )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2717:8: enumLiteral_3= 'Short'
                    {
                    enumLiteral_3=(Token)match(input,46,FOLLOW_46_in_ruleDataType5755); 

                            current = grammarAccess.getDataTypeAccess().getTSHORTEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_3, grammarAccess.getDataTypeAccess().getTSHORTEnumLiteralDeclaration_3()); 
                        

                    }


                    }
                    break;
                case 5 :
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2723:6: (enumLiteral_4= 'Int' )
                    {
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2723:6: (enumLiteral_4= 'Int' )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2723:8: enumLiteral_4= 'Int'
                    {
                    enumLiteral_4=(Token)match(input,47,FOLLOW_47_in_ruleDataType5772); 

                            current = grammarAccess.getDataTypeAccess().getTINTEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_4, grammarAccess.getDataTypeAccess().getTINTEnumLiteralDeclaration_4()); 
                        

                    }


                    }
                    break;
                case 6 :
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2729:6: (enumLiteral_5= 'Long' )
                    {
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2729:6: (enumLiteral_5= 'Long' )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2729:8: enumLiteral_5= 'Long'
                    {
                    enumLiteral_5=(Token)match(input,48,FOLLOW_48_in_ruleDataType5789); 

                            current = grammarAccess.getDataTypeAccess().getTLONGEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_5, grammarAccess.getDataTypeAccess().getTLONGEnumLiteralDeclaration_5()); 
                        

                    }


                    }
                    break;
                case 7 :
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2735:6: (enumLiteral_6= 'Float' )
                    {
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2735:6: (enumLiteral_6= 'Float' )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2735:8: enumLiteral_6= 'Float'
                    {
                    enumLiteral_6=(Token)match(input,49,FOLLOW_49_in_ruleDataType5806); 

                            current = grammarAccess.getDataTypeAccess().getTFLOATEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_6, grammarAccess.getDataTypeAccess().getTFLOATEnumLiteralDeclaration_6()); 
                        

                    }


                    }
                    break;
                case 8 :
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2741:6: (enumLiteral_7= 'Double' )
                    {
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2741:6: (enumLiteral_7= 'Double' )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2741:8: enumLiteral_7= 'Double'
                    {
                    enumLiteral_7=(Token)match(input,50,FOLLOW_50_in_ruleDataType5823); 

                            current = grammarAccess.getDataTypeAccess().getTDOUBLEEnumLiteralDeclaration_7().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_7, grammarAccess.getDataTypeAccess().getTDOUBLEEnumLiteralDeclaration_7()); 
                        

                    }


                    }
                    break;
                case 9 :
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2747:6: (enumLiteral_8= 'String' )
                    {
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2747:6: (enumLiteral_8= 'String' )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2747:8: enumLiteral_8= 'String'
                    {
                    enumLiteral_8=(Token)match(input,51,FOLLOW_51_in_ruleDataType5840); 

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


    protected DFA5 dfa5 = new DFA5(this);
    protected DFA17 dfa17 = new DFA17(this);
    protected DFA22 dfa22 = new DFA22(this);
    protected DFA23 dfa23 = new DFA23(this);
    protected DFA24 dfa24 = new DFA24(this);
    static final String DFA5_eotS =
        "\20\uffff";
    static final String DFA5_eofS =
        "\20\uffff";
    static final String DFA5_minS =
        "\1\7\3\uffff\1\41\2\7\1\42\1\22\1\26\6\uffff";
    static final String DFA5_maxS =
        "\1\25\3\uffff\1\41\2\7\1\44\1\23\1\27\6\uffff";
    static final String DFA5_acceptS =
        "\1\uffff\1\1\1\2\1\3\6\uffff\1\7\1\4\1\6\1\5\1\11\1\10";
    static final String DFA5_specialS =
        "\20\uffff}>";
    static final String[] DFA5_transitionS = {
            "\1\4\5\uffff\1\1\1\uffff\1\2\1\3\1\5\3\uffff\1\6",
            "",
            "",
            "",
            "\1\7",
            "\1\10",
            "\1\11",
            "\1\12\1\uffff\1\13",
            "\1\15\1\14",
            "\1\17\1\16",
            "",
            "",
            "",
            "",
            "",
            ""
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
            return "202:1: (this_MakeEmf_0= ruleMakeEmf | this_MakeEcore_1= ruleMakeEcore | this_MakeImage_2= ruleMakeImage | this_ExtSubTGraph_3= ruleExtSubTGraph | this_SimpleEvoSpan_4= ruleSimpleEvoSpan | this_SimpleEvoCospan_5= ruleSimpleEvoCospan | this_Morphism_6= ruleMorphism | this_EvoSpan_7= ruleEvoSpan | this_EvoCospan_8= ruleEvoCospan )";
        }
    }
    static final String DFA17_eotS =
        "\12\uffff";
    static final String DFA17_eofS =
        "\12\uffff";
    static final String DFA17_minS =
        "\1\7\1\31\1\10\1\7\1\31\1\43\1\10\2\uffff\1\43";
    static final String DFA17_maxS =
        "\1\7\1\52\1\10\1\7\1\31\1\52\1\10\2\uffff\1\46";
    static final String DFA17_acceptS =
        "\7\uffff\1\2\1\1\1\uffff";
    static final String DFA17_specialS =
        "\12\uffff}>";
    static final String[] DFA17_transitionS = {
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
            return "1729:1: (this_MappingNode_0= ruleMappingNode | this_MappingArrow_1= ruleMappingArrow )";
        }
    }
    static final String DFA22_eotS =
        "\12\uffff";
    static final String DFA22_eofS =
        "\5\uffff\1\7\3\uffff\1\7";
    static final String DFA22_minS =
        "\1\7\1\31\1\10\1\7\1\31\1\24\1\10\2\uffff\1\24";
    static final String DFA22_maxS =
        "\1\7\1\52\1\10\1\7\1\31\1\52\1\10\2\uffff\1\46";
    static final String DFA22_acceptS =
        "\7\uffff\1\1\1\2\1\uffff";
    static final String DFA22_specialS =
        "\12\uffff}>";
    static final String[] DFA22_transitionS = {
            "\1\1",
            "\1\3\20\uffff\1\2",
            "\1\4",
            "\1\5",
            "\1\3",
            "\1\7\12\uffff\1\7\6\uffff\1\10\3\uffff\1\6",
            "\1\11",
            "",
            "",
            "\1\7\12\uffff\1\7\6\uffff\1\10"
    };

    static final short[] DFA22_eot = DFA.unpackEncodedString(DFA22_eotS);
    static final short[] DFA22_eof = DFA.unpackEncodedString(DFA22_eofS);
    static final char[] DFA22_min = DFA.unpackEncodedStringToUnsignedChars(DFA22_minS);
    static final char[] DFA22_max = DFA.unpackEncodedStringToUnsignedChars(DFA22_maxS);
    static final short[] DFA22_accept = DFA.unpackEncodedString(DFA22_acceptS);
    static final short[] DFA22_special = DFA.unpackEncodedString(DFA22_specialS);
    static final short[][] DFA22_transition;

    static {
        int numStates = DFA22_transitionS.length;
        DFA22_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA22_transition[i] = DFA.unpackEncodedString(DFA22_transitionS[i]);
        }
    }

    class DFA22 extends DFA {

        public DFA22(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 22;
            this.eot = DFA22_eot;
            this.eof = DFA22_eof;
            this.min = DFA22_min;
            this.max = DFA22_max;
            this.accept = DFA22_accept;
            this.special = DFA22_special;
            this.transition = DFA22_transition;
        }
        public String getDescription() {
            return "2124:1: (this_Node_0= ruleNode | this_Arrows_1= ruleArrows )";
        }
    }
    static final String DFA23_eotS =
        "\32\uffff";
    static final String DFA23_eofS =
        "\26\uffff\1\16\2\uffff\1\16";
    static final String DFA23_minS =
        "\1\7\1\31\1\10\1\7\1\31\1\46\1\10\1\7\1\46\1\31\1\10\1\7\1\31\1"+
        "\23\1\uffff\1\10\1\7\1\23\1\31\1\10\1\7\1\31\1\24\1\10\1\uffff\1"+
        "\24";
    static final String DFA23_maxS =
        "\1\7\1\52\1\10\1\7\1\31\1\52\1\10\1\7\1\46\1\52\1\10\1\47\1\31\1"+
        "\52\1\uffff\1\10\1\50\1\23\1\52\1\10\1\7\1\31\1\52\1\10\1\uffff"+
        "\1\46";
    static final String DFA23_acceptS =
        "\16\uffff\1\2\11\uffff\1\1\1\uffff";
    static final String DFA23_specialS =
        "\32\uffff}>";
    static final String[] DFA23_transitionS = {
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
            "\1\15\37\uffff\1\16",
            "\1\13",
            "\1\20\26\uffff\1\17",
            "",
            "\1\21",
            "\1\22\40\uffff\1\16",
            "\1\20",
            "\1\24\20\uffff\1\23",
            "\1\25",
            "\1\26",
            "\1\24",
            "\1\16\12\uffff\1\16\6\uffff\1\30\3\uffff\1\27",
            "\1\31",
            "",
            "\1\16\12\uffff\1\16\6\uffff\1\30"
    };

    static final short[] DFA23_eot = DFA.unpackEncodedString(DFA23_eotS);
    static final short[] DFA23_eof = DFA.unpackEncodedString(DFA23_eofS);
    static final char[] DFA23_min = DFA.unpackEncodedStringToUnsignedChars(DFA23_minS);
    static final char[] DFA23_max = DFA.unpackEncodedStringToUnsignedChars(DFA23_maxS);
    static final short[] DFA23_accept = DFA.unpackEncodedString(DFA23_acceptS);
    static final short[] DFA23_special = DFA.unpackEncodedString(DFA23_specialS);
    static final short[][] DFA23_transition;

    static {
        int numStates = DFA23_transitionS.length;
        DFA23_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA23_transition[i] = DFA.unpackEncodedString(DFA23_transitionS[i]);
        }
    }

    class DFA23 extends DFA {

        public DFA23(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 23;
            this.eot = DFA23_eot;
            this.eof = DFA23_eof;
            this.min = DFA23_min;
            this.max = DFA23_max;
            this.accept = DFA23_accept;
            this.special = DFA23_special;
            this.transition = DFA23_transition;
        }
        public String getDescription() {
            return "2164:1: ( ( ( (lv_sr_0_0= ruleNode ) ) otherlv_1= '-' ( (lv_id_2_0= ruleDpfId ) ) otherlv_3= ':' ( (lv_type_4_0= ruleDpfId ) ) otherlv_5= '->' ( (lv_next_6_0= ruleArrows ) ) ) | this_Arrow_7= ruleArrow )";
        }
    }
    static final String DFA24_eotS =
        "\24\uffff";
    static final String DFA24_eofS =
        "\24\uffff";
    static final String DFA24_minS =
        "\1\7\1\31\1\10\1\7\1\31\1\46\1\10\1\7\1\46\1\31\1\10\1\7\1\31\1"+
        "\23\1\uffff\1\10\1\7\1\23\2\uffff";
    static final String DFA24_maxS =
        "\1\7\1\52\1\10\1\7\1\31\1\52\1\10\1\7\1\46\1\52\1\10\1\47\1\31\1"+
        "\52\1\uffff\1\10\1\50\1\23\2\uffff";
    static final String DFA24_acceptS =
        "\16\uffff\1\1\3\uffff\1\2\1\3";
    static final String DFA24_specialS =
        "\24\uffff}>";
    static final String[] DFA24_transitionS = {
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
            "\1\15\37\uffff\1\16",
            "\1\13",
            "\1\20\26\uffff\1\17",
            "",
            "\1\21",
            "\1\23\40\uffff\1\22",
            "\1\20",
            "",
            ""
    };

    static final short[] DFA24_eot = DFA.unpackEncodedString(DFA24_eotS);
    static final short[] DFA24_eof = DFA.unpackEncodedString(DFA24_eofS);
    static final char[] DFA24_min = DFA.unpackEncodedStringToUnsignedChars(DFA24_minS);
    static final char[] DFA24_max = DFA.unpackEncodedStringToUnsignedChars(DFA24_maxS);
    static final short[] DFA24_accept = DFA.unpackEncodedString(DFA24_acceptS);
    static final short[] DFA24_special = DFA.unpackEncodedString(DFA24_specialS);
    static final short[][] DFA24_transition;

    static {
        int numStates = DFA24_transitionS.length;
        DFA24_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA24_transition[i] = DFA.unpackEncodedString(DFA24_transitionS[i]);
        }
    }

    class DFA24 extends DFA {

        public DFA24(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 24;
            this.eot = DFA24_eot;
            this.eof = DFA24_eof;
            this.min = DFA24_min;
            this.max = DFA24_max;
            this.accept = DFA24_accept;
            this.special = DFA24_special;
            this.transition = DFA24_transition;
        }
        public String getDescription() {
            return "2279:1: ( ( ( (lv_sr_0_0= ruleNode ) ) otherlv_1= '-' ( (lv_id_2_0= ruleDpfId ) ) otherlv_3= ':' otherlv_4= '*' otherlv_5= '->' ( (lv_tgDataType_6_0= ruleDataType ) ) ) | ( ( (lv_sr_7_0= ruleNode ) ) otherlv_8= '-' ( (lv_id_9_0= ruleDpfId ) ) otherlv_10= ':' ( (lv_type_11_0= ruleDpfId ) ) otherlv_12= '->' ( (lv_tgValue_13_0= ruleAttributeValue ) ) ) | ( ( (lv_sr_14_0= ruleNode ) ) otherlv_15= '-' ( (lv_id_16_0= ruleDpfId ) ) otherlv_17= ':' ( (lv_type_18_0= ruleDpfId ) ) otherlv_19= '->' ( (lv_tgNode_20_0= ruleNode ) ) ) )";
        }
    }
 

    public static final BitSet FOLLOW_ruleModel_in_entryRuleModel75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModel85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSpecification_in_ruleModel132 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSignature_in_ruleModel159 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCommand_in_ruleModel186 = new BitSet(new long[]{0x000000000023A082L});
    public static final BitSet FOLLOW_ruleCommand_in_ruleModel207 = new BitSet(new long[]{0x000000000023A082L});
    public static final BitSet FOLLOW_ruleVALUE_in_entryRuleVALUE247 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVALUE258 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NUMBER_in_ruleVALUE298 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_CHAR_in_ruleVALUE324 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleVALUE350 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCommand_in_entryRuleCommand395 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCommand405 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMakeEmf_in_ruleCommand452 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMakeEcore_in_ruleCommand479 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMakeImage_in_ruleCommand506 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExtSubTGraph_in_ruleCommand533 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSimpleEvoSpan_in_ruleCommand560 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSimpleEvoCospan_in_ruleCommand587 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMorphism_in_ruleCommand614 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEvoSpan_in_ruleCommand641 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEvoCospan_in_ruleCommand668 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMakeEmf_in_entryRuleMakeEmf703 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMakeEmf713 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_ruleMakeEmf750 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleMakeEmf767 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleMakeEmf784 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMakeEcore_in_entryRuleMakeEcore820 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMakeEcore830 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleMakeEcore867 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleMakeEcore884 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleMakeEcore901 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMakeImage_in_entryRuleMakeImage937 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMakeImage947 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_ruleMakeImage984 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleMakeImage1001 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleMakeImage1018 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSimpleEvoSpan_in_entryRuleSimpleEvoSpan1054 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSimpleEvoSpan1064 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_ruleSimpleEvoSpan1101 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSimpleEvoSpan1118 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleSimpleEvoSpan1135 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSimpleEvoSpan1152 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleSimpleEvoSpan1169 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSimpleEvoSpan1186 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleSimpleEvoSpan1203 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSimpleEvoSpan1220 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleSimpleEvoSpan1237 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSimpleEvoCospan_in_entryRuleSimpleEvoCospan1273 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSimpleEvoCospan1283 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_ruleSimpleEvoCospan1320 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSimpleEvoCospan1337 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleSimpleEvoCospan1354 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSimpleEvoCospan1371 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleSimpleEvoCospan1388 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSimpleEvoCospan1405 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleSimpleEvoCospan1422 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSimpleEvoCospan1439 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleSimpleEvoCospan1456 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEvoSpan_in_entryRuleEvoSpan1492 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEvoSpan1502 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_ruleEvoSpan1539 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEvoSpan1556 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleEvoSpan1573 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEvoSpan1590 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleEvoSpan1607 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEvoSpan1624 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleEvoSpan1641 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEvoCospan_in_entryRuleEvoCospan1677 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEvoCospan1687 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_ruleEvoCospan1724 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEvoCospan1741 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ruleEvoCospan1758 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEvoCospan1775 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleEvoCospan1792 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEvoCospan1809 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleEvoCospan1826 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSpecification_in_entryRuleSpecification1862 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSpecification1872 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_ruleSpecification1909 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_ruleSpecification1921 = new BitSet(new long[]{0x0000000004000080L});
    public static final BitSet FOLLOW_ruleChoosenSpecification_in_ruleSpecification1943 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_26_in_ruleSpecification1962 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ruleChoosenSpecification_in_ruleSpecification1983 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleSpecification1995 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ruleChoosenConstraintSemantic_in_ruleSpecification2016 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleSpecification2028 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_ruleSpecification2042 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_ruleSequenceNumber_in_ruleSpecification2063 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_ruleSpecification2075 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_ruleSpecification2087 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_ruleGraph_in_ruleSpecification2108 = new BitSet(new long[]{0x00000000C0000000L});
    public static final BitSet FOLLOW_30_in_ruleSpecification2121 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_ruleSpecification2133 = new BitSet(new long[]{0x0000000080000080L});
    public static final BitSet FOLLOW_ruleConstraint_in_ruleSpecification2155 = new BitSet(new long[]{0x0000000080100000L});
    public static final BitSet FOLLOW_20_in_ruleSpecification2168 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ruleConstraint_in_ruleSpecification2189 = new BitSet(new long[]{0x0000000080100000L});
    public static final BitSet FOLLOW_31_in_ruleSpecification2205 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_ruleSpecification2219 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleChoosenSpecification_in_entryRuleChoosenSpecification2255 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleChoosenSpecification2265 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleChoosenSpecification2306 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSequenceNumber_in_entryRuleSequenceNumber2346 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSequenceNumber2356 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleSequenceNumber2397 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleChoosenConstraintSemantic_in_entryRuleChoosenConstraintSemantic2437 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleChoosenConstraintSemantic2447 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleChoosenConstraintSemantic2488 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConstraint_in_entryRuleConstraint2528 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConstraint2538 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConstraintSignature_in_ruleConstraint2584 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_ruleConstraint2596 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ruleArrows_in_ruleConstraint2618 = new BitSet(new long[]{0x0000000080100000L});
    public static final BitSet FOLLOW_20_in_ruleConstraint2631 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ruleArrows_in_ruleConstraint2652 = new BitSet(new long[]{0x0000000080100000L});
    public static final BitSet FOLLOW_31_in_ruleConstraint2667 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConstraintSignature_in_entryRuleConstraintSignature2703 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConstraintSignature2713 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDpfId_in_ruleConstraintSignature2759 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_ruleConstraintSignature2771 = new BitSet(new long[]{0x0000000000004040L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleConstraintSignature2789 = new BitSet(new long[]{0x0000000000104000L});
    public static final BitSet FOLLOW_20_in_ruleConstraintSignature2807 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleConstraintSignature2824 = new BitSet(new long[]{0x0000000000104000L});
    public static final BitSet FOLLOW_14_in_ruleConstraintSignature2845 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSignature_in_entryRuleSignature2881 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSignature2891 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConstraintSemantic_in_ruleSignature2937 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_20_in_ruleSignature2950 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ruleConstraintSemantic_in_ruleSignature2971 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_ruleConstraintSemantic_in_entryRuleConstraintSemantic3009 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConstraintSemantic3019 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDpfId_in_ruleConstraintSemantic3065 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_ruleConstraintSemantic3077 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ruleArrows_in_ruleConstraintSemantic3099 = new BitSet(new long[]{0x0000000080100000L});
    public static final BitSet FOLLOW_20_in_ruleConstraintSemantic3112 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ruleArrows_in_ruleConstraintSemantic3133 = new BitSet(new long[]{0x0000000080100000L});
    public static final BitSet FOLLOW_31_in_ruleConstraintSemantic3148 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_ruleConstraintSemantic3160 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleConstraintSemantic3177 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMorphism_in_entryRuleMorphism3218 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMorphism3228 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleMorphism3264 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_ruleMorphism3275 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_ruleMorphism3287 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_ruleMorphism3299 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ruleDomain_in_ruleMorphism3320 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleMorphism3332 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ruleCodomain_in_ruleMorphism3353 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_ruleMorphism3365 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_ruleMorphism3377 = new BitSet(new long[]{0x0000000080000080L});
    public static final BitSet FOLLOW_ruleMapping_in_ruleMorphism3399 = new BitSet(new long[]{0x0000000080100000L});
    public static final BitSet FOLLOW_20_in_ruleMorphism3412 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ruleMapping_in_ruleMorphism3433 = new BitSet(new long[]{0x0000000080100000L});
    public static final BitSet FOLLOW_31_in_ruleMorphism3449 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDomain_in_entryRuleDomain3485 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDomain3495 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDomain3536 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCodomain_in_entryRuleCodomain3576 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCodomain3586 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleCodomain3627 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMapping_in_entryRuleMapping3667 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMapping3677 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMappingNode_in_ruleMapping3724 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMappingArrow_in_ruleMapping3751 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMappingNode_in_entryRuleMappingNode3786 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMappingNode3796 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNode_in_ruleMappingNode3842 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_ruleMappingNode3854 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ruleNode_in_ruleMappingNode3875 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMappingArrow_in_entryRuleMappingArrow3911 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMappingArrow3921 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArrow_in_ruleMappingArrow3967 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_ruleMappingArrow3979 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ruleArrow_in_ruleMappingArrow4000 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExtSubTGraph_in_entryRuleExtSubTGraph4036 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExtSubTGraph4046 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleExtSubTGraph4088 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_ruleExtSubTGraph4105 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_ruleExtSubTGraph4117 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_ruleExtSubTGraph4129 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ruleChoosenExtSubTGraph_in_ruleExtSubTGraph4150 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_ruleExtSubTGraph4162 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_ruleExtSubTGraph4174 = new BitSet(new long[]{0x0000000080000080L});
    public static final BitSet FOLLOW_ruleElement_in_ruleExtSubTGraph4196 = new BitSet(new long[]{0x0000000080100000L});
    public static final BitSet FOLLOW_20_in_ruleExtSubTGraph4209 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ruleElement_in_ruleExtSubTGraph4230 = new BitSet(new long[]{0x0000000080100000L});
    public static final BitSet FOLLOW_31_in_ruleExtSubTGraph4246 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleChoosenExtSubTGraph_in_entryRuleChoosenExtSubTGraph4282 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleChoosenExtSubTGraph4292 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleChoosenExtSubTGraph4333 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGraph_in_entryRuleGraph4373 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleGraph4383 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_ruleGraph4420 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_ruleGraph4432 = new BitSet(new long[]{0x0000000080000080L});
    public static final BitSet FOLLOW_ruleElement_in_ruleGraph4454 = new BitSet(new long[]{0x0000000080100000L});
    public static final BitSet FOLLOW_20_in_ruleGraph4467 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ruleElement_in_ruleGraph4488 = new BitSet(new long[]{0x0000000080100000L});
    public static final BitSet FOLLOW_31_in_ruleGraph4504 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleElement_in_entryRuleElement4540 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleElement4550 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNode_in_ruleElement4597 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArrows_in_ruleElement4624 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArrows_in_entryRuleArrows4659 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleArrows4669 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNode_in_ruleArrows4716 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_38_in_ruleArrows4728 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ruleDpfId_in_ruleArrows4749 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_ruleArrows4761 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ruleDpfId_in_ruleArrows4782 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleArrows4794 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ruleArrows_in_ruleArrows4815 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArrow_in_ruleArrows4844 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArrow_in_entryRuleArrow4879 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleArrow4889 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNode_in_ruleArrow4936 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_38_in_ruleArrow4948 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ruleDpfId_in_ruleArrow4969 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_ruleArrow4981 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_ruleArrow4993 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleArrow5005 = new BitSet(new long[]{0x000FF80000000000L});
    public static final BitSet FOLLOW_ruleDataType_in_ruleArrow5026 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNode_in_ruleArrow5055 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_38_in_ruleArrow5067 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ruleDpfId_in_ruleArrow5088 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_ruleArrow5100 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ruleDpfId_in_ruleArrow5121 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleArrow5133 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_ruleAttributeValue_in_ruleArrow5154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNode_in_ruleArrow5183 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_38_in_ruleArrow5195 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ruleDpfId_in_ruleArrow5216 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_ruleArrow5228 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ruleDpfId_in_ruleArrow5249 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleArrow5261 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ruleNode_in_ruleArrow5282 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNode_in_entryRuleNode5319 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNode5329 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDpfId_in_ruleNode5375 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_ruleNode5387 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ruleDpfId_in_ruleNode5408 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAttributeValue_in_entryRuleAttributeValue5444 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAttributeValue5454 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_ruleAttributeValue5491 = new BitSet(new long[]{0x0000000000000070L});
    public static final BitSet FOLLOW_ruleVALUE_in_ruleAttributeValue5512 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_ruleAttributeValue5524 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDpfId_in_entryRuleDpfId5560 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDpfId5570 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDpfId5612 = new BitSet(new long[]{0x0000040000000002L});
    public static final BitSet FOLLOW_42_in_ruleDpfId5630 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleDpfId5647 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_ruleDataType5704 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_ruleDataType5721 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_ruleDataType5738 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_ruleDataType5755 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_ruleDataType5772 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_ruleDataType5789 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_ruleDataType5806 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_ruleDataType5823 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_ruleDataType5840 = new BitSet(new long[]{0x0000000000000002L});

}