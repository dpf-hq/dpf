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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_NUMBER", "RULE_CHAR", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ANY_OTHER", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "'emf('", "')'", "'ecore('", "'image('", "'simpleEvolution('", "'<-'", "'->'", "','", "'evolution('", "'<->'", "'-><-'", "':='", "'ISpec'", "'<'", "'>'", "'{'", "'}'", "'='", "'Specification'", "':'", "'Constraints'", "'('", "'Morphism'", "'=>'", "'ExtSubTGraph'", "'Graph'", "'-'", "'*'", "'['", "']'", "'@'", "'Boolean'", "'Char'", "'Byte'", "'Short'", "'Int'", "'Long'", "'Float'", "'Double'", "'String'"
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
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:77:1: ruleModel returns [EObject current=null] : (this_Specification_0= ruleSpecification | ( ( (lv_commands_1_0= ruleCommand ) ) ( (lv_commands_2_0= ruleCommand ) )* )? ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject this_Specification_0 = null;

        EObject lv_commands_1_0 = null;

        EObject lv_commands_2_0 = null;


         enterRule(); 
            
        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:80:28: ( (this_Specification_0= ruleSpecification | ( ( (lv_commands_1_0= ruleCommand ) ) ( (lv_commands_2_0= ruleCommand ) )* )? ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:81:1: (this_Specification_0= ruleSpecification | ( ( (lv_commands_1_0= ruleCommand ) ) ( (lv_commands_2_0= ruleCommand ) )* )? )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:81:1: (this_Specification_0= ruleSpecification | ( ( (lv_commands_1_0= ruleCommand ) ) ( (lv_commands_2_0= ruleCommand ) )* )? )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==31) ) {
                alt3=1;
            }
            else if ( (LA3_0==EOF||LA3_0==RULE_ID||LA3_0==13||(LA3_0>=15 && LA3_0<=17)||LA3_0==21) ) {
                alt3=2;
            }
            else {
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
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:91:6: ( ( (lv_commands_1_0= ruleCommand ) ) ( (lv_commands_2_0= ruleCommand ) )* )?
                    {
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:91:6: ( ( (lv_commands_1_0= ruleCommand ) ) ( (lv_commands_2_0= ruleCommand ) )* )?
                    int alt2=2;
                    int LA2_0 = input.LA(1);

                    if ( (LA2_0==RULE_ID||LA2_0==13||(LA2_0>=15 && LA2_0<=17)||LA2_0==21) ) {
                        alt2=1;
                    }
                    switch (alt2) {
                        case 1 :
                            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:91:7: ( (lv_commands_1_0= ruleCommand ) ) ( (lv_commands_2_0= ruleCommand ) )*
                            {
                            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:91:7: ( (lv_commands_1_0= ruleCommand ) )
                            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:92:1: (lv_commands_1_0= ruleCommand )
                            {
                            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:92:1: (lv_commands_1_0= ruleCommand )
                            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:93:3: lv_commands_1_0= ruleCommand
                            {
                             
                            	        newCompositeNode(grammarAccess.getModelAccess().getCommandsCommandParserRuleCall_1_0_0()); 
                            	    
                            pushFollow(FOLLOW_ruleCommand_in_ruleModel159);
                            lv_commands_1_0=ruleCommand();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getModelRule());
                            	        }
                                   		add(
                                   			current, 
                                   			"commands",
                                    		lv_commands_1_0, 
                                    		"Command");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }

                            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:109:2: ( (lv_commands_2_0= ruleCommand ) )*
                            loop1:
                            do {
                                int alt1=2;
                                int LA1_0 = input.LA(1);

                                if ( (LA1_0==RULE_ID||LA1_0==13||(LA1_0>=15 && LA1_0<=17)||LA1_0==21) ) {
                                    alt1=1;
                                }


                                switch (alt1) {
                            	case 1 :
                            	    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:110:1: (lv_commands_2_0= ruleCommand )
                            	    {
                            	    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:110:1: (lv_commands_2_0= ruleCommand )
                            	    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:111:3: lv_commands_2_0= ruleCommand
                            	    {
                            	     
                            	    	        newCompositeNode(grammarAccess.getModelAccess().getCommandsCommandParserRuleCall_1_1_0()); 
                            	    	    
                            	    pushFollow(FOLLOW_ruleCommand_in_ruleModel180);
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
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:135:1: entryRuleVALUE returns [String current=null] : iv_ruleVALUE= ruleVALUE EOF ;
    public final String entryRuleVALUE() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleVALUE = null;


        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:136:2: (iv_ruleVALUE= ruleVALUE EOF )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:137:2: iv_ruleVALUE= ruleVALUE EOF
            {
             newCompositeNode(grammarAccess.getVALUERule()); 
            pushFollow(FOLLOW_ruleVALUE_in_entryRuleVALUE220);
            iv_ruleVALUE=ruleVALUE();

            state._fsp--;

             current =iv_ruleVALUE.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVALUE231); 

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
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:144:1: ruleVALUE returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_NUMBER_0= RULE_NUMBER | this_CHAR_1= RULE_CHAR | this_STRING_2= RULE_STRING ) ;
    public final AntlrDatatypeRuleToken ruleVALUE() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_NUMBER_0=null;
        Token this_CHAR_1=null;
        Token this_STRING_2=null;

         enterRule(); 
            
        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:147:28: ( (this_NUMBER_0= RULE_NUMBER | this_CHAR_1= RULE_CHAR | this_STRING_2= RULE_STRING ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:148:1: (this_NUMBER_0= RULE_NUMBER | this_CHAR_1= RULE_CHAR | this_STRING_2= RULE_STRING )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:148:1: (this_NUMBER_0= RULE_NUMBER | this_CHAR_1= RULE_CHAR | this_STRING_2= RULE_STRING )
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
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:148:6: this_NUMBER_0= RULE_NUMBER
                    {
                    this_NUMBER_0=(Token)match(input,RULE_NUMBER,FOLLOW_RULE_NUMBER_in_ruleVALUE271); 

                    		current.merge(this_NUMBER_0);
                        
                     
                        newLeafNode(this_NUMBER_0, grammarAccess.getVALUEAccess().getNUMBERTerminalRuleCall_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:156:10: this_CHAR_1= RULE_CHAR
                    {
                    this_CHAR_1=(Token)match(input,RULE_CHAR,FOLLOW_RULE_CHAR_in_ruleVALUE297); 

                    		current.merge(this_CHAR_1);
                        
                     
                        newLeafNode(this_CHAR_1, grammarAccess.getVALUEAccess().getCHARTerminalRuleCall_1()); 
                        

                    }
                    break;
                case 3 :
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:164:10: this_STRING_2= RULE_STRING
                    {
                    this_STRING_2=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleVALUE323); 

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
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:179:1: entryRuleCommand returns [EObject current=null] : iv_ruleCommand= ruleCommand EOF ;
    public final EObject entryRuleCommand() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCommand = null;


        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:180:2: (iv_ruleCommand= ruleCommand EOF )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:181:2: iv_ruleCommand= ruleCommand EOF
            {
             newCompositeNode(grammarAccess.getCommandRule()); 
            pushFollow(FOLLOW_ruleCommand_in_entryRuleCommand368);
            iv_ruleCommand=ruleCommand();

            state._fsp--;

             current =iv_ruleCommand; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCommand378); 

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
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:188:1: ruleCommand returns [EObject current=null] : (this_InstanceSpecification_0= ruleInstanceSpecification | this_ExtSubTGraph_1= ruleExtSubTGraph | this_MakeEmf_2= ruleMakeEmf | this_MakeEcore_3= ruleMakeEcore | this_MakeImage_4= ruleMakeImage | this_SimpleEvoSpan_5= ruleSimpleEvoSpan | this_SimpleEvoCospan_6= ruleSimpleEvoCospan | this_Morphism_7= ruleMorphism | this_EvoSpan_8= ruleEvoSpan | this_EvoCospan_9= ruleEvoCospan ) ;
    public final EObject ruleCommand() throws RecognitionException {
        EObject current = null;

        EObject this_InstanceSpecification_0 = null;

        EObject this_ExtSubTGraph_1 = null;

        EObject this_MakeEmf_2 = null;

        EObject this_MakeEcore_3 = null;

        EObject this_MakeImage_4 = null;

        EObject this_SimpleEvoSpan_5 = null;

        EObject this_SimpleEvoCospan_6 = null;

        EObject this_Morphism_7 = null;

        EObject this_EvoSpan_8 = null;

        EObject this_EvoCospan_9 = null;


         enterRule(); 
            
        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:191:28: ( (this_InstanceSpecification_0= ruleInstanceSpecification | this_ExtSubTGraph_1= ruleExtSubTGraph | this_MakeEmf_2= ruleMakeEmf | this_MakeEcore_3= ruleMakeEcore | this_MakeImage_4= ruleMakeImage | this_SimpleEvoSpan_5= ruleSimpleEvoSpan | this_SimpleEvoCospan_6= ruleSimpleEvoCospan | this_Morphism_7= ruleMorphism | this_EvoSpan_8= ruleEvoSpan | this_EvoCospan_9= ruleEvoCospan ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:192:1: (this_InstanceSpecification_0= ruleInstanceSpecification | this_ExtSubTGraph_1= ruleExtSubTGraph | this_MakeEmf_2= ruleMakeEmf | this_MakeEcore_3= ruleMakeEcore | this_MakeImage_4= ruleMakeImage | this_SimpleEvoSpan_5= ruleSimpleEvoSpan | this_SimpleEvoCospan_6= ruleSimpleEvoCospan | this_Morphism_7= ruleMorphism | this_EvoSpan_8= ruleEvoSpan | this_EvoCospan_9= ruleEvoCospan )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:192:1: (this_InstanceSpecification_0= ruleInstanceSpecification | this_ExtSubTGraph_1= ruleExtSubTGraph | this_MakeEmf_2= ruleMakeEmf | this_MakeEcore_3= ruleMakeEcore | this_MakeImage_4= ruleMakeImage | this_SimpleEvoSpan_5= ruleSimpleEvoSpan | this_SimpleEvoCospan_6= ruleSimpleEvoCospan | this_Morphism_7= ruleMorphism | this_EvoSpan_8= ruleEvoSpan | this_EvoCospan_9= ruleEvoCospan )
            int alt5=10;
            alt5 = dfa5.predict(input);
            switch (alt5) {
                case 1 :
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:193:5: this_InstanceSpecification_0= ruleInstanceSpecification
                    {
                     
                            newCompositeNode(grammarAccess.getCommandAccess().getInstanceSpecificationParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleInstanceSpecification_in_ruleCommand425);
                    this_InstanceSpecification_0=ruleInstanceSpecification();

                    state._fsp--;

                     
                            current = this_InstanceSpecification_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:203:5: this_ExtSubTGraph_1= ruleExtSubTGraph
                    {
                     
                            newCompositeNode(grammarAccess.getCommandAccess().getExtSubTGraphParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleExtSubTGraph_in_ruleCommand452);
                    this_ExtSubTGraph_1=ruleExtSubTGraph();

                    state._fsp--;

                     
                            current = this_ExtSubTGraph_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:213:5: this_MakeEmf_2= ruleMakeEmf
                    {
                     
                            newCompositeNode(grammarAccess.getCommandAccess().getMakeEmfParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleMakeEmf_in_ruleCommand479);
                    this_MakeEmf_2=ruleMakeEmf();

                    state._fsp--;

                     
                            current = this_MakeEmf_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:223:5: this_MakeEcore_3= ruleMakeEcore
                    {
                     
                            newCompositeNode(grammarAccess.getCommandAccess().getMakeEcoreParserRuleCall_3()); 
                        
                    pushFollow(FOLLOW_ruleMakeEcore_in_ruleCommand506);
                    this_MakeEcore_3=ruleMakeEcore();

                    state._fsp--;

                     
                            current = this_MakeEcore_3; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 5 :
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:233:5: this_MakeImage_4= ruleMakeImage
                    {
                     
                            newCompositeNode(grammarAccess.getCommandAccess().getMakeImageParserRuleCall_4()); 
                        
                    pushFollow(FOLLOW_ruleMakeImage_in_ruleCommand533);
                    this_MakeImage_4=ruleMakeImage();

                    state._fsp--;

                     
                            current = this_MakeImage_4; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 6 :
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:243:5: this_SimpleEvoSpan_5= ruleSimpleEvoSpan
                    {
                     
                            newCompositeNode(grammarAccess.getCommandAccess().getSimpleEvoSpanParserRuleCall_5()); 
                        
                    pushFollow(FOLLOW_ruleSimpleEvoSpan_in_ruleCommand560);
                    this_SimpleEvoSpan_5=ruleSimpleEvoSpan();

                    state._fsp--;

                     
                            current = this_SimpleEvoSpan_5; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 7 :
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:253:5: this_SimpleEvoCospan_6= ruleSimpleEvoCospan
                    {
                     
                            newCompositeNode(grammarAccess.getCommandAccess().getSimpleEvoCospanParserRuleCall_6()); 
                        
                    pushFollow(FOLLOW_ruleSimpleEvoCospan_in_ruleCommand587);
                    this_SimpleEvoCospan_6=ruleSimpleEvoCospan();

                    state._fsp--;

                     
                            current = this_SimpleEvoCospan_6; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 8 :
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:263:5: this_Morphism_7= ruleMorphism
                    {
                     
                            newCompositeNode(grammarAccess.getCommandAccess().getMorphismParserRuleCall_7()); 
                        
                    pushFollow(FOLLOW_ruleMorphism_in_ruleCommand614);
                    this_Morphism_7=ruleMorphism();

                    state._fsp--;

                     
                            current = this_Morphism_7; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 9 :
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:273:5: this_EvoSpan_8= ruleEvoSpan
                    {
                     
                            newCompositeNode(grammarAccess.getCommandAccess().getEvoSpanParserRuleCall_8()); 
                        
                    pushFollow(FOLLOW_ruleEvoSpan_in_ruleCommand641);
                    this_EvoSpan_8=ruleEvoSpan();

                    state._fsp--;

                     
                            current = this_EvoSpan_8; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 10 :
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:283:5: this_EvoCospan_9= ruleEvoCospan
                    {
                     
                            newCompositeNode(grammarAccess.getCommandAccess().getEvoCospanParserRuleCall_9()); 
                        
                    pushFollow(FOLLOW_ruleEvoCospan_in_ruleCommand668);
                    this_EvoCospan_9=ruleEvoCospan();

                    state._fsp--;

                     
                            current = this_EvoCospan_9; 
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


    // $ANTLR start "entryRuleInstanceSpecification"
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:848:1: entryRuleInstanceSpecification returns [EObject current=null] : iv_ruleInstanceSpecification= ruleInstanceSpecification EOF ;
    public final EObject entryRuleInstanceSpecification() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInstanceSpecification = null;


        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:849:2: (iv_ruleInstanceSpecification= ruleInstanceSpecification EOF )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:850:2: iv_ruleInstanceSpecification= ruleInstanceSpecification EOF
            {
             newCompositeNode(grammarAccess.getInstanceSpecificationRule()); 
            pushFollow(FOLLOW_ruleInstanceSpecification_in_entryRuleInstanceSpecification1862);
            iv_ruleInstanceSpecification=ruleInstanceSpecification();

            state._fsp--;

             current =iv_ruleInstanceSpecification; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleInstanceSpecification1872); 

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
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:857:1: ruleInstanceSpecification returns [EObject current=null] : ( ( (lv_id_0_0= RULE_ID ) ) otherlv_1= ':=' otherlv_2= 'ISpec' otherlv_3= '<' ( (lv_model_4_0= ruleChoosenSpecfication ) ) otherlv_5= ',' ( (lv_metamodel_6_0= ruleChoosenSpecfication ) ) otherlv_7= '>' otherlv_8= '{' ( ( (lv_constraintSemantics_9_0= ruleConstraintSemantic ) ) (otherlv_10= ',' ( (lv_constraintSemantics_11_0= ruleConstraintSemantic ) ) )* ) otherlv_12= '}' ) ;
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
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:860:28: ( ( ( (lv_id_0_0= RULE_ID ) ) otherlv_1= ':=' otherlv_2= 'ISpec' otherlv_3= '<' ( (lv_model_4_0= ruleChoosenSpecfication ) ) otherlv_5= ',' ( (lv_metamodel_6_0= ruleChoosenSpecfication ) ) otherlv_7= '>' otherlv_8= '{' ( ( (lv_constraintSemantics_9_0= ruleConstraintSemantic ) ) (otherlv_10= ',' ( (lv_constraintSemantics_11_0= ruleConstraintSemantic ) ) )* ) otherlv_12= '}' ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:861:1: ( ( (lv_id_0_0= RULE_ID ) ) otherlv_1= ':=' otherlv_2= 'ISpec' otherlv_3= '<' ( (lv_model_4_0= ruleChoosenSpecfication ) ) otherlv_5= ',' ( (lv_metamodel_6_0= ruleChoosenSpecfication ) ) otherlv_7= '>' otherlv_8= '{' ( ( (lv_constraintSemantics_9_0= ruleConstraintSemantic ) ) (otherlv_10= ',' ( (lv_constraintSemantics_11_0= ruleConstraintSemantic ) ) )* ) otherlv_12= '}' )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:861:1: ( ( (lv_id_0_0= RULE_ID ) ) otherlv_1= ':=' otherlv_2= 'ISpec' otherlv_3= '<' ( (lv_model_4_0= ruleChoosenSpecfication ) ) otherlv_5= ',' ( (lv_metamodel_6_0= ruleChoosenSpecfication ) ) otherlv_7= '>' otherlv_8= '{' ( ( (lv_constraintSemantics_9_0= ruleConstraintSemantic ) ) (otherlv_10= ',' ( (lv_constraintSemantics_11_0= ruleConstraintSemantic ) ) )* ) otherlv_12= '}' )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:861:2: ( (lv_id_0_0= RULE_ID ) ) otherlv_1= ':=' otherlv_2= 'ISpec' otherlv_3= '<' ( (lv_model_4_0= ruleChoosenSpecfication ) ) otherlv_5= ',' ( (lv_metamodel_6_0= ruleChoosenSpecfication ) ) otherlv_7= '>' otherlv_8= '{' ( ( (lv_constraintSemantics_9_0= ruleConstraintSemantic ) ) (otherlv_10= ',' ( (lv_constraintSemantics_11_0= ruleConstraintSemantic ) ) )* ) otherlv_12= '}'
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:861:2: ( (lv_id_0_0= RULE_ID ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:862:1: (lv_id_0_0= RULE_ID )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:862:1: (lv_id_0_0= RULE_ID )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:863:3: lv_id_0_0= RULE_ID
            {
            lv_id_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleInstanceSpecification1914); 

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

            otherlv_1=(Token)match(input,24,FOLLOW_24_in_ruleInstanceSpecification1931); 

                	newLeafNode(otherlv_1, grammarAccess.getInstanceSpecificationAccess().getColonEqualsSignKeyword_1());
                
            otherlv_2=(Token)match(input,25,FOLLOW_25_in_ruleInstanceSpecification1943); 

                	newLeafNode(otherlv_2, grammarAccess.getInstanceSpecificationAccess().getISpecKeyword_2());
                
            otherlv_3=(Token)match(input,26,FOLLOW_26_in_ruleInstanceSpecification1955); 

                	newLeafNode(otherlv_3, grammarAccess.getInstanceSpecificationAccess().getLessThanSignKeyword_3());
                
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:891:1: ( (lv_model_4_0= ruleChoosenSpecfication ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:892:1: (lv_model_4_0= ruleChoosenSpecfication )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:892:1: (lv_model_4_0= ruleChoosenSpecfication )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:893:3: lv_model_4_0= ruleChoosenSpecfication
            {
             
            	        newCompositeNode(grammarAccess.getInstanceSpecificationAccess().getModelChoosenSpecficationParserRuleCall_4_0()); 
            	    
            pushFollow(FOLLOW_ruleChoosenSpecfication_in_ruleInstanceSpecification1976);
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

            otherlv_5=(Token)match(input,20,FOLLOW_20_in_ruleInstanceSpecification1988); 

                	newLeafNode(otherlv_5, grammarAccess.getInstanceSpecificationAccess().getCommaKeyword_5());
                
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:913:1: ( (lv_metamodel_6_0= ruleChoosenSpecfication ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:914:1: (lv_metamodel_6_0= ruleChoosenSpecfication )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:914:1: (lv_metamodel_6_0= ruleChoosenSpecfication )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:915:3: lv_metamodel_6_0= ruleChoosenSpecfication
            {
             
            	        newCompositeNode(grammarAccess.getInstanceSpecificationAccess().getMetamodelChoosenSpecficationParserRuleCall_6_0()); 
            	    
            pushFollow(FOLLOW_ruleChoosenSpecfication_in_ruleInstanceSpecification2009);
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

            otherlv_7=(Token)match(input,27,FOLLOW_27_in_ruleInstanceSpecification2021); 

                	newLeafNode(otherlv_7, grammarAccess.getInstanceSpecificationAccess().getGreaterThanSignKeyword_7());
                
            otherlv_8=(Token)match(input,28,FOLLOW_28_in_ruleInstanceSpecification2033); 

                	newLeafNode(otherlv_8, grammarAccess.getInstanceSpecificationAccess().getLeftCurlyBracketKeyword_8());
                
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:939:1: ( ( (lv_constraintSemantics_9_0= ruleConstraintSemantic ) ) (otherlv_10= ',' ( (lv_constraintSemantics_11_0= ruleConstraintSemantic ) ) )* )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:939:2: ( (lv_constraintSemantics_9_0= ruleConstraintSemantic ) ) (otherlv_10= ',' ( (lv_constraintSemantics_11_0= ruleConstraintSemantic ) ) )*
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:939:2: ( (lv_constraintSemantics_9_0= ruleConstraintSemantic ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:940:1: (lv_constraintSemantics_9_0= ruleConstraintSemantic )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:940:1: (lv_constraintSemantics_9_0= ruleConstraintSemantic )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:941:3: lv_constraintSemantics_9_0= ruleConstraintSemantic
            {
             
            	        newCompositeNode(grammarAccess.getInstanceSpecificationAccess().getConstraintSemanticsConstraintSemanticParserRuleCall_9_0_0()); 
            	    
            pushFollow(FOLLOW_ruleConstraintSemantic_in_ruleInstanceSpecification2055);
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

            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:957:2: (otherlv_10= ',' ( (lv_constraintSemantics_11_0= ruleConstraintSemantic ) ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==20) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:957:4: otherlv_10= ',' ( (lv_constraintSemantics_11_0= ruleConstraintSemantic ) )
            	    {
            	    otherlv_10=(Token)match(input,20,FOLLOW_20_in_ruleInstanceSpecification2068); 

            	        	newLeafNode(otherlv_10, grammarAccess.getInstanceSpecificationAccess().getCommaKeyword_9_1_0());
            	        
            	    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:961:1: ( (lv_constraintSemantics_11_0= ruleConstraintSemantic ) )
            	    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:962:1: (lv_constraintSemantics_11_0= ruleConstraintSemantic )
            	    {
            	    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:962:1: (lv_constraintSemantics_11_0= ruleConstraintSemantic )
            	    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:963:3: lv_constraintSemantics_11_0= ruleConstraintSemantic
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getInstanceSpecificationAccess().getConstraintSemanticsConstraintSemanticParserRuleCall_9_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleConstraintSemantic_in_ruleInstanceSpecification2089);
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
            	    break loop6;
                }
            } while (true);


            }

            otherlv_12=(Token)match(input,29,FOLLOW_29_in_ruleInstanceSpecification2104); 

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
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:991:1: entryRuleChoosenSpecfication returns [EObject current=null] : iv_ruleChoosenSpecfication= ruleChoosenSpecfication EOF ;
    public final EObject entryRuleChoosenSpecfication() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleChoosenSpecfication = null;


        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:992:2: (iv_ruleChoosenSpecfication= ruleChoosenSpecfication EOF )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:993:2: iv_ruleChoosenSpecfication= ruleChoosenSpecfication EOF
            {
             newCompositeNode(grammarAccess.getChoosenSpecficationRule()); 
            pushFollow(FOLLOW_ruleChoosenSpecfication_in_entryRuleChoosenSpecfication2140);
            iv_ruleChoosenSpecfication=ruleChoosenSpecfication();

            state._fsp--;

             current =iv_ruleChoosenSpecfication; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleChoosenSpecfication2150); 

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
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1000:1: ruleChoosenSpecfication returns [EObject current=null] : ( (lv_id_0_0= RULE_ID ) ) ;
    public final EObject ruleChoosenSpecfication() throws RecognitionException {
        EObject current = null;

        Token lv_id_0_0=null;

         enterRule(); 
            
        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1003:28: ( ( (lv_id_0_0= RULE_ID ) ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1004:1: ( (lv_id_0_0= RULE_ID ) )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1004:1: ( (lv_id_0_0= RULE_ID ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1005:1: (lv_id_0_0= RULE_ID )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1005:1: (lv_id_0_0= RULE_ID )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1006:3: lv_id_0_0= RULE_ID
            {
            lv_id_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleChoosenSpecfication2191); 

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
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1030:1: entryRuleConstraintSemantic returns [EObject current=null] : iv_ruleConstraintSemantic= ruleConstraintSemantic EOF ;
    public final EObject entryRuleConstraintSemantic() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstraintSemantic = null;


        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1031:2: (iv_ruleConstraintSemantic= ruleConstraintSemantic EOF )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1032:2: iv_ruleConstraintSemantic= ruleConstraintSemantic EOF
            {
             newCompositeNode(grammarAccess.getConstraintSemanticRule()); 
            pushFollow(FOLLOW_ruleConstraintSemantic_in_entryRuleConstraintSemantic2231);
            iv_ruleConstraintSemantic=ruleConstraintSemantic();

            state._fsp--;

             current =iv_ruleConstraintSemantic; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleConstraintSemantic2241); 

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
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1039:1: ruleConstraintSemantic returns [EObject current=null] : ( ( (lv_id_0_0= ruleDpfId ) ) otherlv_1= '{' ( ( (lv_arrows_2_0= ruleArrows ) ) (otherlv_3= ',' ( (lv_arrows_4_0= ruleArrows ) ) )* ) otherlv_5= ',' otherlv_6= '}' otherlv_7= '=' ( (lv_ocl_8_0= RULE_STRING ) ) ) ;
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
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1042:28: ( ( ( (lv_id_0_0= ruleDpfId ) ) otherlv_1= '{' ( ( (lv_arrows_2_0= ruleArrows ) ) (otherlv_3= ',' ( (lv_arrows_4_0= ruleArrows ) ) )* ) otherlv_5= ',' otherlv_6= '}' otherlv_7= '=' ( (lv_ocl_8_0= RULE_STRING ) ) ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1043:1: ( ( (lv_id_0_0= ruleDpfId ) ) otherlv_1= '{' ( ( (lv_arrows_2_0= ruleArrows ) ) (otherlv_3= ',' ( (lv_arrows_4_0= ruleArrows ) ) )* ) otherlv_5= ',' otherlv_6= '}' otherlv_7= '=' ( (lv_ocl_8_0= RULE_STRING ) ) )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1043:1: ( ( (lv_id_0_0= ruleDpfId ) ) otherlv_1= '{' ( ( (lv_arrows_2_0= ruleArrows ) ) (otherlv_3= ',' ( (lv_arrows_4_0= ruleArrows ) ) )* ) otherlv_5= ',' otherlv_6= '}' otherlv_7= '=' ( (lv_ocl_8_0= RULE_STRING ) ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1043:2: ( (lv_id_0_0= ruleDpfId ) ) otherlv_1= '{' ( ( (lv_arrows_2_0= ruleArrows ) ) (otherlv_3= ',' ( (lv_arrows_4_0= ruleArrows ) ) )* ) otherlv_5= ',' otherlv_6= '}' otherlv_7= '=' ( (lv_ocl_8_0= RULE_STRING ) )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1043:2: ( (lv_id_0_0= ruleDpfId ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1044:1: (lv_id_0_0= ruleDpfId )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1044:1: (lv_id_0_0= ruleDpfId )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1045:3: lv_id_0_0= ruleDpfId
            {
             
            	        newCompositeNode(grammarAccess.getConstraintSemanticAccess().getIdDpfIdParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleDpfId_in_ruleConstraintSemantic2287);
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

            otherlv_1=(Token)match(input,28,FOLLOW_28_in_ruleConstraintSemantic2299); 

                	newLeafNode(otherlv_1, grammarAccess.getConstraintSemanticAccess().getLeftCurlyBracketKeyword_1());
                
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1065:1: ( ( (lv_arrows_2_0= ruleArrows ) ) (otherlv_3= ',' ( (lv_arrows_4_0= ruleArrows ) ) )* )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1065:2: ( (lv_arrows_2_0= ruleArrows ) ) (otherlv_3= ',' ( (lv_arrows_4_0= ruleArrows ) ) )*
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1065:2: ( (lv_arrows_2_0= ruleArrows ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1066:1: (lv_arrows_2_0= ruleArrows )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1066:1: (lv_arrows_2_0= ruleArrows )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1067:3: lv_arrows_2_0= ruleArrows
            {
             
            	        newCompositeNode(grammarAccess.getConstraintSemanticAccess().getArrowsArrowsParserRuleCall_2_0_0()); 
            	    
            pushFollow(FOLLOW_ruleArrows_in_ruleConstraintSemantic2321);
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

            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1083:2: (otherlv_3= ',' ( (lv_arrows_4_0= ruleArrows ) ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==20) ) {
                    int LA7_1 = input.LA(2);

                    if ( (LA7_1==RULE_ID) ) {
                        alt7=1;
                    }


                }


                switch (alt7) {
            	case 1 :
            	    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1083:4: otherlv_3= ',' ( (lv_arrows_4_0= ruleArrows ) )
            	    {
            	    otherlv_3=(Token)match(input,20,FOLLOW_20_in_ruleConstraintSemantic2334); 

            	        	newLeafNode(otherlv_3, grammarAccess.getConstraintSemanticAccess().getCommaKeyword_2_1_0());
            	        
            	    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1087:1: ( (lv_arrows_4_0= ruleArrows ) )
            	    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1088:1: (lv_arrows_4_0= ruleArrows )
            	    {
            	    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1088:1: (lv_arrows_4_0= ruleArrows )
            	    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1089:3: lv_arrows_4_0= ruleArrows
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getConstraintSemanticAccess().getArrowsArrowsParserRuleCall_2_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleArrows_in_ruleConstraintSemantic2355);
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
            	    break loop7;
                }
            } while (true);


            }

            otherlv_5=(Token)match(input,20,FOLLOW_20_in_ruleConstraintSemantic2370); 

                	newLeafNode(otherlv_5, grammarAccess.getConstraintSemanticAccess().getCommaKeyword_3());
                
            otherlv_6=(Token)match(input,29,FOLLOW_29_in_ruleConstraintSemantic2382); 

                	newLeafNode(otherlv_6, grammarAccess.getConstraintSemanticAccess().getRightCurlyBracketKeyword_4());
                
            otherlv_7=(Token)match(input,30,FOLLOW_30_in_ruleConstraintSemantic2394); 

                	newLeafNode(otherlv_7, grammarAccess.getConstraintSemanticAccess().getEqualsSignKeyword_5());
                
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1117:1: ( (lv_ocl_8_0= RULE_STRING ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1118:1: (lv_ocl_8_0= RULE_STRING )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1118:1: (lv_ocl_8_0= RULE_STRING )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1119:3: lv_ocl_8_0= RULE_STRING
            {
            lv_ocl_8_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleConstraintSemantic2411); 

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
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1143:1: entryRuleSpecification returns [EObject current=null] : iv_ruleSpecification= ruleSpecification EOF ;
    public final EObject entryRuleSpecification() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSpecification = null;


        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1144:2: (iv_ruleSpecification= ruleSpecification EOF )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1145:2: iv_ruleSpecification= ruleSpecification EOF
            {
             newCompositeNode(grammarAccess.getSpecificationRule()); 
            pushFollow(FOLLOW_ruleSpecification_in_entryRuleSpecification2452);
            iv_ruleSpecification=ruleSpecification();

            state._fsp--;

             current =iv_ruleSpecification; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSpecification2462); 

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
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1152:1: ruleSpecification returns [EObject current=null] : (otherlv_0= 'Specification' otherlv_1= ':' ( (lv_type_2_0= ruleChoosenSpecification ) ) otherlv_3= '<' ( (lv_sequenceNumber_4_0= RULE_INT ) ) otherlv_5= '>' otherlv_6= '{' ( (lv_graph_7_0= ruleGraph ) ) otherlv_8= 'Constraints' otherlv_9= '<' ( (lv_constaintSemantic_10_0= ruleChoosenConstraintSemantic ) ) otherlv_11= '>' otherlv_12= '{' ( ( (lv_constraints_13_0= ruleConstraint ) ) (otherlv_14= ',' ( (lv_constraints_15_0= ruleConstraint ) ) )* )? otherlv_16= '}' otherlv_17= '}' ) ;
    public final EObject ruleSpecification() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token lv_sequenceNumber_4_0=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token otherlv_14=null;
        Token otherlv_16=null;
        Token otherlv_17=null;
        EObject lv_type_2_0 = null;

        EObject lv_graph_7_0 = null;

        EObject lv_constaintSemantic_10_0 = null;

        EObject lv_constraints_13_0 = null;

        EObject lv_constraints_15_0 = null;


         enterRule(); 
            
        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1155:28: ( (otherlv_0= 'Specification' otherlv_1= ':' ( (lv_type_2_0= ruleChoosenSpecification ) ) otherlv_3= '<' ( (lv_sequenceNumber_4_0= RULE_INT ) ) otherlv_5= '>' otherlv_6= '{' ( (lv_graph_7_0= ruleGraph ) ) otherlv_8= 'Constraints' otherlv_9= '<' ( (lv_constaintSemantic_10_0= ruleChoosenConstraintSemantic ) ) otherlv_11= '>' otherlv_12= '{' ( ( (lv_constraints_13_0= ruleConstraint ) ) (otherlv_14= ',' ( (lv_constraints_15_0= ruleConstraint ) ) )* )? otherlv_16= '}' otherlv_17= '}' ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1156:1: (otherlv_0= 'Specification' otherlv_1= ':' ( (lv_type_2_0= ruleChoosenSpecification ) ) otherlv_3= '<' ( (lv_sequenceNumber_4_0= RULE_INT ) ) otherlv_5= '>' otherlv_6= '{' ( (lv_graph_7_0= ruleGraph ) ) otherlv_8= 'Constraints' otherlv_9= '<' ( (lv_constaintSemantic_10_0= ruleChoosenConstraintSemantic ) ) otherlv_11= '>' otherlv_12= '{' ( ( (lv_constraints_13_0= ruleConstraint ) ) (otherlv_14= ',' ( (lv_constraints_15_0= ruleConstraint ) ) )* )? otherlv_16= '}' otherlv_17= '}' )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1156:1: (otherlv_0= 'Specification' otherlv_1= ':' ( (lv_type_2_0= ruleChoosenSpecification ) ) otherlv_3= '<' ( (lv_sequenceNumber_4_0= RULE_INT ) ) otherlv_5= '>' otherlv_6= '{' ( (lv_graph_7_0= ruleGraph ) ) otherlv_8= 'Constraints' otherlv_9= '<' ( (lv_constaintSemantic_10_0= ruleChoosenConstraintSemantic ) ) otherlv_11= '>' otherlv_12= '{' ( ( (lv_constraints_13_0= ruleConstraint ) ) (otherlv_14= ',' ( (lv_constraints_15_0= ruleConstraint ) ) )* )? otherlv_16= '}' otherlv_17= '}' )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1156:3: otherlv_0= 'Specification' otherlv_1= ':' ( (lv_type_2_0= ruleChoosenSpecification ) ) otherlv_3= '<' ( (lv_sequenceNumber_4_0= RULE_INT ) ) otherlv_5= '>' otherlv_6= '{' ( (lv_graph_7_0= ruleGraph ) ) otherlv_8= 'Constraints' otherlv_9= '<' ( (lv_constaintSemantic_10_0= ruleChoosenConstraintSemantic ) ) otherlv_11= '>' otherlv_12= '{' ( ( (lv_constraints_13_0= ruleConstraint ) ) (otherlv_14= ',' ( (lv_constraints_15_0= ruleConstraint ) ) )* )? otherlv_16= '}' otherlv_17= '}'
            {
            otherlv_0=(Token)match(input,31,FOLLOW_31_in_ruleSpecification2499); 

                	newLeafNode(otherlv_0, grammarAccess.getSpecificationAccess().getSpecificationKeyword_0());
                
            otherlv_1=(Token)match(input,32,FOLLOW_32_in_ruleSpecification2511); 

                	newLeafNode(otherlv_1, grammarAccess.getSpecificationAccess().getColonKeyword_1());
                
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1164:1: ( (lv_type_2_0= ruleChoosenSpecification ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1165:1: (lv_type_2_0= ruleChoosenSpecification )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1165:1: (lv_type_2_0= ruleChoosenSpecification )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1166:3: lv_type_2_0= ruleChoosenSpecification
            {
             
            	        newCompositeNode(grammarAccess.getSpecificationAccess().getTypeChoosenSpecificationParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleChoosenSpecification_in_ruleSpecification2532);
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

            otherlv_3=(Token)match(input,26,FOLLOW_26_in_ruleSpecification2544); 

                	newLeafNode(otherlv_3, grammarAccess.getSpecificationAccess().getLessThanSignKeyword_3());
                
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1186:1: ( (lv_sequenceNumber_4_0= RULE_INT ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1187:1: (lv_sequenceNumber_4_0= RULE_INT )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1187:1: (lv_sequenceNumber_4_0= RULE_INT )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1188:3: lv_sequenceNumber_4_0= RULE_INT
            {
            lv_sequenceNumber_4_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleSpecification2561); 

            			newLeafNode(lv_sequenceNumber_4_0, grammarAccess.getSpecificationAccess().getSequenceNumberINTTerminalRuleCall_4_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getSpecificationRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"sequenceNumber",
                    		lv_sequenceNumber_4_0, 
                    		"INT");
            	    

            }


            }

            otherlv_5=(Token)match(input,27,FOLLOW_27_in_ruleSpecification2578); 

                	newLeafNode(otherlv_5, grammarAccess.getSpecificationAccess().getGreaterThanSignKeyword_5());
                
            otherlv_6=(Token)match(input,28,FOLLOW_28_in_ruleSpecification2590); 

                	newLeafNode(otherlv_6, grammarAccess.getSpecificationAccess().getLeftCurlyBracketKeyword_6());
                
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1212:1: ( (lv_graph_7_0= ruleGraph ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1213:1: (lv_graph_7_0= ruleGraph )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1213:1: (lv_graph_7_0= ruleGraph )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1214:3: lv_graph_7_0= ruleGraph
            {
             
            	        newCompositeNode(grammarAccess.getSpecificationAccess().getGraphGraphParserRuleCall_7_0()); 
            	    
            pushFollow(FOLLOW_ruleGraph_in_ruleSpecification2611);
            lv_graph_7_0=ruleGraph();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getSpecificationRule());
            	        }
                   		set(
                   			current, 
                   			"graph",
                    		lv_graph_7_0, 
                    		"Graph");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_8=(Token)match(input,33,FOLLOW_33_in_ruleSpecification2623); 

                	newLeafNode(otherlv_8, grammarAccess.getSpecificationAccess().getConstraintsKeyword_8());
                
            otherlv_9=(Token)match(input,26,FOLLOW_26_in_ruleSpecification2635); 

                	newLeafNode(otherlv_9, grammarAccess.getSpecificationAccess().getLessThanSignKeyword_9());
                
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1238:1: ( (lv_constaintSemantic_10_0= ruleChoosenConstraintSemantic ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1239:1: (lv_constaintSemantic_10_0= ruleChoosenConstraintSemantic )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1239:1: (lv_constaintSemantic_10_0= ruleChoosenConstraintSemantic )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1240:3: lv_constaintSemantic_10_0= ruleChoosenConstraintSemantic
            {
             
            	        newCompositeNode(grammarAccess.getSpecificationAccess().getConstaintSemanticChoosenConstraintSemanticParserRuleCall_10_0()); 
            	    
            pushFollow(FOLLOW_ruleChoosenConstraintSemantic_in_ruleSpecification2656);
            lv_constaintSemantic_10_0=ruleChoosenConstraintSemantic();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getSpecificationRule());
            	        }
                   		set(
                   			current, 
                   			"constaintSemantic",
                    		lv_constaintSemantic_10_0, 
                    		"ChoosenConstraintSemantic");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_11=(Token)match(input,27,FOLLOW_27_in_ruleSpecification2668); 

                	newLeafNode(otherlv_11, grammarAccess.getSpecificationAccess().getGreaterThanSignKeyword_11());
                
            otherlv_12=(Token)match(input,28,FOLLOW_28_in_ruleSpecification2680); 

                	newLeafNode(otherlv_12, grammarAccess.getSpecificationAccess().getLeftCurlyBracketKeyword_12());
                
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1264:1: ( ( (lv_constraints_13_0= ruleConstraint ) ) (otherlv_14= ',' ( (lv_constraints_15_0= ruleConstraint ) ) )* )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==RULE_ID) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1264:2: ( (lv_constraints_13_0= ruleConstraint ) ) (otherlv_14= ',' ( (lv_constraints_15_0= ruleConstraint ) ) )*
                    {
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1264:2: ( (lv_constraints_13_0= ruleConstraint ) )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1265:1: (lv_constraints_13_0= ruleConstraint )
                    {
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1265:1: (lv_constraints_13_0= ruleConstraint )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1266:3: lv_constraints_13_0= ruleConstraint
                    {
                     
                    	        newCompositeNode(grammarAccess.getSpecificationAccess().getConstraintsConstraintParserRuleCall_13_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleConstraint_in_ruleSpecification2702);
                    lv_constraints_13_0=ruleConstraint();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getSpecificationRule());
                    	        }
                           		add(
                           			current, 
                           			"constraints",
                            		lv_constraints_13_0, 
                            		"Constraint");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1282:2: (otherlv_14= ',' ( (lv_constraints_15_0= ruleConstraint ) ) )*
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( (LA8_0==20) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1282:4: otherlv_14= ',' ( (lv_constraints_15_0= ruleConstraint ) )
                    	    {
                    	    otherlv_14=(Token)match(input,20,FOLLOW_20_in_ruleSpecification2715); 

                    	        	newLeafNode(otherlv_14, grammarAccess.getSpecificationAccess().getCommaKeyword_13_1_0());
                    	        
                    	    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1286:1: ( (lv_constraints_15_0= ruleConstraint ) )
                    	    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1287:1: (lv_constraints_15_0= ruleConstraint )
                    	    {
                    	    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1287:1: (lv_constraints_15_0= ruleConstraint )
                    	    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1288:3: lv_constraints_15_0= ruleConstraint
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getSpecificationAccess().getConstraintsConstraintParserRuleCall_13_1_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleConstraint_in_ruleSpecification2736);
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


                    	    }
                    	    break;

                    	default :
                    	    break loop8;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_16=(Token)match(input,29,FOLLOW_29_in_ruleSpecification2752); 

                	newLeafNode(otherlv_16, grammarAccess.getSpecificationAccess().getRightCurlyBracketKeyword_14());
                
            otherlv_17=(Token)match(input,29,FOLLOW_29_in_ruleSpecification2764); 

                	newLeafNode(otherlv_17, grammarAccess.getSpecificationAccess().getRightCurlyBracketKeyword_15());
                

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
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1320:1: entryRuleChoosenSpecification returns [EObject current=null] : iv_ruleChoosenSpecification= ruleChoosenSpecification EOF ;
    public final EObject entryRuleChoosenSpecification() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleChoosenSpecification = null;


        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1321:2: (iv_ruleChoosenSpecification= ruleChoosenSpecification EOF )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1322:2: iv_ruleChoosenSpecification= ruleChoosenSpecification EOF
            {
             newCompositeNode(grammarAccess.getChoosenSpecificationRule()); 
            pushFollow(FOLLOW_ruleChoosenSpecification_in_entryRuleChoosenSpecification2800);
            iv_ruleChoosenSpecification=ruleChoosenSpecification();

            state._fsp--;

             current =iv_ruleChoosenSpecification; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleChoosenSpecification2810); 

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
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1329:1: ruleChoosenSpecification returns [EObject current=null] : ( (lv_id_0_0= RULE_ID ) ) ;
    public final EObject ruleChoosenSpecification() throws RecognitionException {
        EObject current = null;

        Token lv_id_0_0=null;

         enterRule(); 
            
        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1332:28: ( ( (lv_id_0_0= RULE_ID ) ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1333:1: ( (lv_id_0_0= RULE_ID ) )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1333:1: ( (lv_id_0_0= RULE_ID ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1334:1: (lv_id_0_0= RULE_ID )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1334:1: (lv_id_0_0= RULE_ID )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1335:3: lv_id_0_0= RULE_ID
            {
            lv_id_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleChoosenSpecification2851); 

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


    // $ANTLR start "entryRuleChoosenConstraintSemantic"
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1359:1: entryRuleChoosenConstraintSemantic returns [EObject current=null] : iv_ruleChoosenConstraintSemantic= ruleChoosenConstraintSemantic EOF ;
    public final EObject entryRuleChoosenConstraintSemantic() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleChoosenConstraintSemantic = null;


        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1360:2: (iv_ruleChoosenConstraintSemantic= ruleChoosenConstraintSemantic EOF )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1361:2: iv_ruleChoosenConstraintSemantic= ruleChoosenConstraintSemantic EOF
            {
             newCompositeNode(grammarAccess.getChoosenConstraintSemanticRule()); 
            pushFollow(FOLLOW_ruleChoosenConstraintSemantic_in_entryRuleChoosenConstraintSemantic2891);
            iv_ruleChoosenConstraintSemantic=ruleChoosenConstraintSemantic();

            state._fsp--;

             current =iv_ruleChoosenConstraintSemantic; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleChoosenConstraintSemantic2901); 

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
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1368:1: ruleChoosenConstraintSemantic returns [EObject current=null] : ( (lv_id_0_0= RULE_ID ) ) ;
    public final EObject ruleChoosenConstraintSemantic() throws RecognitionException {
        EObject current = null;

        Token lv_id_0_0=null;

         enterRule(); 
            
        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1371:28: ( ( (lv_id_0_0= RULE_ID ) ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1372:1: ( (lv_id_0_0= RULE_ID ) )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1372:1: ( (lv_id_0_0= RULE_ID ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1373:1: (lv_id_0_0= RULE_ID )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1373:1: (lv_id_0_0= RULE_ID )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1374:3: lv_id_0_0= RULE_ID
            {
            lv_id_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleChoosenConstraintSemantic2942); 

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
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1398:1: entryRuleConstraint returns [EObject current=null] : iv_ruleConstraint= ruleConstraint EOF ;
    public final EObject entryRuleConstraint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstraint = null;


        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1399:2: (iv_ruleConstraint= ruleConstraint EOF )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1400:2: iv_ruleConstraint= ruleConstraint EOF
            {
             newCompositeNode(grammarAccess.getConstraintRule()); 
            pushFollow(FOLLOW_ruleConstraint_in_entryRuleConstraint2982);
            iv_ruleConstraint=ruleConstraint();

            state._fsp--;

             current =iv_ruleConstraint; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleConstraint2992); 

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
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1407:1: ruleConstraint returns [EObject current=null] : ( ( (lv_signature_0_0= ruleConstraintSignature ) ) otherlv_1= '{' ( ( (lv_arrows_2_0= ruleArrows ) ) (otherlv_3= ',' ( (lv_arrows_4_0= ruleArrows ) ) )* ) otherlv_5= '}' ) ;
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
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1410:28: ( ( ( (lv_signature_0_0= ruleConstraintSignature ) ) otherlv_1= '{' ( ( (lv_arrows_2_0= ruleArrows ) ) (otherlv_3= ',' ( (lv_arrows_4_0= ruleArrows ) ) )* ) otherlv_5= '}' ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1411:1: ( ( (lv_signature_0_0= ruleConstraintSignature ) ) otherlv_1= '{' ( ( (lv_arrows_2_0= ruleArrows ) ) (otherlv_3= ',' ( (lv_arrows_4_0= ruleArrows ) ) )* ) otherlv_5= '}' )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1411:1: ( ( (lv_signature_0_0= ruleConstraintSignature ) ) otherlv_1= '{' ( ( (lv_arrows_2_0= ruleArrows ) ) (otherlv_3= ',' ( (lv_arrows_4_0= ruleArrows ) ) )* ) otherlv_5= '}' )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1411:2: ( (lv_signature_0_0= ruleConstraintSignature ) ) otherlv_1= '{' ( ( (lv_arrows_2_0= ruleArrows ) ) (otherlv_3= ',' ( (lv_arrows_4_0= ruleArrows ) ) )* ) otherlv_5= '}'
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1411:2: ( (lv_signature_0_0= ruleConstraintSignature ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1412:1: (lv_signature_0_0= ruleConstraintSignature )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1412:1: (lv_signature_0_0= ruleConstraintSignature )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1413:3: lv_signature_0_0= ruleConstraintSignature
            {
             
            	        newCompositeNode(grammarAccess.getConstraintAccess().getSignatureConstraintSignatureParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleConstraintSignature_in_ruleConstraint3038);
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

            otherlv_1=(Token)match(input,28,FOLLOW_28_in_ruleConstraint3050); 

                	newLeafNode(otherlv_1, grammarAccess.getConstraintAccess().getLeftCurlyBracketKeyword_1());
                
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1433:1: ( ( (lv_arrows_2_0= ruleArrows ) ) (otherlv_3= ',' ( (lv_arrows_4_0= ruleArrows ) ) )* )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1433:2: ( (lv_arrows_2_0= ruleArrows ) ) (otherlv_3= ',' ( (lv_arrows_4_0= ruleArrows ) ) )*
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1433:2: ( (lv_arrows_2_0= ruleArrows ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1434:1: (lv_arrows_2_0= ruleArrows )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1434:1: (lv_arrows_2_0= ruleArrows )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1435:3: lv_arrows_2_0= ruleArrows
            {
             
            	        newCompositeNode(grammarAccess.getConstraintAccess().getArrowsArrowsParserRuleCall_2_0_0()); 
            	    
            pushFollow(FOLLOW_ruleArrows_in_ruleConstraint3072);
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

            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1451:2: (otherlv_3= ',' ( (lv_arrows_4_0= ruleArrows ) ) )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==20) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1451:4: otherlv_3= ',' ( (lv_arrows_4_0= ruleArrows ) )
            	    {
            	    otherlv_3=(Token)match(input,20,FOLLOW_20_in_ruleConstraint3085); 

            	        	newLeafNode(otherlv_3, grammarAccess.getConstraintAccess().getCommaKeyword_2_1_0());
            	        
            	    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1455:1: ( (lv_arrows_4_0= ruleArrows ) )
            	    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1456:1: (lv_arrows_4_0= ruleArrows )
            	    {
            	    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1456:1: (lv_arrows_4_0= ruleArrows )
            	    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1457:3: lv_arrows_4_0= ruleArrows
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getConstraintAccess().getArrowsArrowsParserRuleCall_2_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleArrows_in_ruleConstraint3106);
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

            otherlv_5=(Token)match(input,29,FOLLOW_29_in_ruleConstraint3121); 

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
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1485:1: entryRuleConstraintSignature returns [EObject current=null] : iv_ruleConstraintSignature= ruleConstraintSignature EOF ;
    public final EObject entryRuleConstraintSignature() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstraintSignature = null;


        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1486:2: (iv_ruleConstraintSignature= ruleConstraintSignature EOF )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1487:2: iv_ruleConstraintSignature= ruleConstraintSignature EOF
            {
             newCompositeNode(grammarAccess.getConstraintSignatureRule()); 
            pushFollow(FOLLOW_ruleConstraintSignature_in_entryRuleConstraintSignature3157);
            iv_ruleConstraintSignature=ruleConstraintSignature();

            state._fsp--;

             current =iv_ruleConstraintSignature; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleConstraintSignature3167); 

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
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1494:1: ruleConstraintSignature returns [EObject current=null] : ( ( (lv_id_0_0= ruleDpfId ) ) otherlv_1= '(' ( ( (lv_parameter_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_parameter_4_0= RULE_ID ) ) )* )? otherlv_5= ')' ) ;
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
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1497:28: ( ( ( (lv_id_0_0= ruleDpfId ) ) otherlv_1= '(' ( ( (lv_parameter_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_parameter_4_0= RULE_ID ) ) )* )? otherlv_5= ')' ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1498:1: ( ( (lv_id_0_0= ruleDpfId ) ) otherlv_1= '(' ( ( (lv_parameter_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_parameter_4_0= RULE_ID ) ) )* )? otherlv_5= ')' )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1498:1: ( ( (lv_id_0_0= ruleDpfId ) ) otherlv_1= '(' ( ( (lv_parameter_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_parameter_4_0= RULE_ID ) ) )* )? otherlv_5= ')' )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1498:2: ( (lv_id_0_0= ruleDpfId ) ) otherlv_1= '(' ( ( (lv_parameter_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_parameter_4_0= RULE_ID ) ) )* )? otherlv_5= ')'
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1498:2: ( (lv_id_0_0= ruleDpfId ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1499:1: (lv_id_0_0= ruleDpfId )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1499:1: (lv_id_0_0= ruleDpfId )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1500:3: lv_id_0_0= ruleDpfId
            {
             
            	        newCompositeNode(grammarAccess.getConstraintSignatureAccess().getIdDpfIdParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleDpfId_in_ruleConstraintSignature3213);
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

            otherlv_1=(Token)match(input,34,FOLLOW_34_in_ruleConstraintSignature3225); 

                	newLeafNode(otherlv_1, grammarAccess.getConstraintSignatureAccess().getLeftParenthesisKeyword_1());
                
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1520:1: ( ( (lv_parameter_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_parameter_4_0= RULE_ID ) ) )* )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==RULE_ID) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1520:2: ( (lv_parameter_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_parameter_4_0= RULE_ID ) ) )*
                    {
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1520:2: ( (lv_parameter_2_0= RULE_ID ) )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1521:1: (lv_parameter_2_0= RULE_ID )
                    {
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1521:1: (lv_parameter_2_0= RULE_ID )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1522:3: lv_parameter_2_0= RULE_ID
                    {
                    lv_parameter_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleConstraintSignature3243); 

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

                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1538:2: (otherlv_3= ',' ( (lv_parameter_4_0= RULE_ID ) ) )*
                    loop11:
                    do {
                        int alt11=2;
                        int LA11_0 = input.LA(1);

                        if ( (LA11_0==20) ) {
                            alt11=1;
                        }


                        switch (alt11) {
                    	case 1 :
                    	    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1538:4: otherlv_3= ',' ( (lv_parameter_4_0= RULE_ID ) )
                    	    {
                    	    otherlv_3=(Token)match(input,20,FOLLOW_20_in_ruleConstraintSignature3261); 

                    	        	newLeafNode(otherlv_3, grammarAccess.getConstraintSignatureAccess().getCommaKeyword_2_1_0());
                    	        
                    	    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1542:1: ( (lv_parameter_4_0= RULE_ID ) )
                    	    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1543:1: (lv_parameter_4_0= RULE_ID )
                    	    {
                    	    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1543:1: (lv_parameter_4_0= RULE_ID )
                    	    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1544:3: lv_parameter_4_0= RULE_ID
                    	    {
                    	    lv_parameter_4_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleConstraintSignature3278); 

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
                    	    break loop11;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_5=(Token)match(input,14,FOLLOW_14_in_ruleConstraintSignature3299); 

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
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1572:1: entryRuleMorphism returns [EObject current=null] : iv_ruleMorphism= ruleMorphism EOF ;
    public final EObject entryRuleMorphism() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMorphism = null;


        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1573:2: (iv_ruleMorphism= ruleMorphism EOF )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1574:2: iv_ruleMorphism= ruleMorphism EOF
            {
             newCompositeNode(grammarAccess.getMorphismRule()); 
            pushFollow(FOLLOW_ruleMorphism_in_entryRuleMorphism3335);
            iv_ruleMorphism=ruleMorphism();

            state._fsp--;

             current =iv_ruleMorphism; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMorphism3345); 

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
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1581:1: ruleMorphism returns [EObject current=null] : (this_ID_0= RULE_ID otherlv_1= ':=' otherlv_2= 'Morphism' otherlv_3= '<' ( (lv_domain_4_0= ruleDomain ) ) otherlv_5= ',' ( (lv_codmain_6_0= ruleCodomain ) ) otherlv_7= '>' otherlv_8= '{' ( ( (lv_mappings_9_0= ruleMapping ) ) (otherlv_10= ',' ( (lv_mappings_11_0= ruleMapping ) ) )* )? otherlv_12= '}' ) ;
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
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1584:28: ( (this_ID_0= RULE_ID otherlv_1= ':=' otherlv_2= 'Morphism' otherlv_3= '<' ( (lv_domain_4_0= ruleDomain ) ) otherlv_5= ',' ( (lv_codmain_6_0= ruleCodomain ) ) otherlv_7= '>' otherlv_8= '{' ( ( (lv_mappings_9_0= ruleMapping ) ) (otherlv_10= ',' ( (lv_mappings_11_0= ruleMapping ) ) )* )? otherlv_12= '}' ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1585:1: (this_ID_0= RULE_ID otherlv_1= ':=' otherlv_2= 'Morphism' otherlv_3= '<' ( (lv_domain_4_0= ruleDomain ) ) otherlv_5= ',' ( (lv_codmain_6_0= ruleCodomain ) ) otherlv_7= '>' otherlv_8= '{' ( ( (lv_mappings_9_0= ruleMapping ) ) (otherlv_10= ',' ( (lv_mappings_11_0= ruleMapping ) ) )* )? otherlv_12= '}' )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1585:1: (this_ID_0= RULE_ID otherlv_1= ':=' otherlv_2= 'Morphism' otherlv_3= '<' ( (lv_domain_4_0= ruleDomain ) ) otherlv_5= ',' ( (lv_codmain_6_0= ruleCodomain ) ) otherlv_7= '>' otherlv_8= '{' ( ( (lv_mappings_9_0= ruleMapping ) ) (otherlv_10= ',' ( (lv_mappings_11_0= ruleMapping ) ) )* )? otherlv_12= '}' )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1585:2: this_ID_0= RULE_ID otherlv_1= ':=' otherlv_2= 'Morphism' otherlv_3= '<' ( (lv_domain_4_0= ruleDomain ) ) otherlv_5= ',' ( (lv_codmain_6_0= ruleCodomain ) ) otherlv_7= '>' otherlv_8= '{' ( ( (lv_mappings_9_0= ruleMapping ) ) (otherlv_10= ',' ( (lv_mappings_11_0= ruleMapping ) ) )* )? otherlv_12= '}'
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleMorphism3381); 
             
                newLeafNode(this_ID_0, grammarAccess.getMorphismAccess().getIDTerminalRuleCall_0()); 
                
            otherlv_1=(Token)match(input,24,FOLLOW_24_in_ruleMorphism3392); 

                	newLeafNode(otherlv_1, grammarAccess.getMorphismAccess().getColonEqualsSignKeyword_1());
                
            otherlv_2=(Token)match(input,35,FOLLOW_35_in_ruleMorphism3404); 

                	newLeafNode(otherlv_2, grammarAccess.getMorphismAccess().getMorphismKeyword_2());
                
            otherlv_3=(Token)match(input,26,FOLLOW_26_in_ruleMorphism3416); 

                	newLeafNode(otherlv_3, grammarAccess.getMorphismAccess().getLessThanSignKeyword_3());
                
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1601:1: ( (lv_domain_4_0= ruleDomain ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1602:1: (lv_domain_4_0= ruleDomain )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1602:1: (lv_domain_4_0= ruleDomain )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1603:3: lv_domain_4_0= ruleDomain
            {
             
            	        newCompositeNode(grammarAccess.getMorphismAccess().getDomainDomainParserRuleCall_4_0()); 
            	    
            pushFollow(FOLLOW_ruleDomain_in_ruleMorphism3437);
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

            otherlv_5=(Token)match(input,20,FOLLOW_20_in_ruleMorphism3449); 

                	newLeafNode(otherlv_5, grammarAccess.getMorphismAccess().getCommaKeyword_5());
                
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1623:1: ( (lv_codmain_6_0= ruleCodomain ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1624:1: (lv_codmain_6_0= ruleCodomain )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1624:1: (lv_codmain_6_0= ruleCodomain )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1625:3: lv_codmain_6_0= ruleCodomain
            {
             
            	        newCompositeNode(grammarAccess.getMorphismAccess().getCodmainCodomainParserRuleCall_6_0()); 
            	    
            pushFollow(FOLLOW_ruleCodomain_in_ruleMorphism3470);
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

            otherlv_7=(Token)match(input,27,FOLLOW_27_in_ruleMorphism3482); 

                	newLeafNode(otherlv_7, grammarAccess.getMorphismAccess().getGreaterThanSignKeyword_7());
                
            otherlv_8=(Token)match(input,28,FOLLOW_28_in_ruleMorphism3494); 

                	newLeafNode(otherlv_8, grammarAccess.getMorphismAccess().getLeftCurlyBracketKeyword_8());
                
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1649:1: ( ( (lv_mappings_9_0= ruleMapping ) ) (otherlv_10= ',' ( (lv_mappings_11_0= ruleMapping ) ) )* )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==RULE_ID) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1649:2: ( (lv_mappings_9_0= ruleMapping ) ) (otherlv_10= ',' ( (lv_mappings_11_0= ruleMapping ) ) )*
                    {
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1649:2: ( (lv_mappings_9_0= ruleMapping ) )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1650:1: (lv_mappings_9_0= ruleMapping )
                    {
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1650:1: (lv_mappings_9_0= ruleMapping )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1651:3: lv_mappings_9_0= ruleMapping
                    {
                     
                    	        newCompositeNode(grammarAccess.getMorphismAccess().getMappingsMappingParserRuleCall_9_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleMapping_in_ruleMorphism3516);
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

                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1667:2: (otherlv_10= ',' ( (lv_mappings_11_0= ruleMapping ) ) )*
                    loop13:
                    do {
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( (LA13_0==20) ) {
                            alt13=1;
                        }


                        switch (alt13) {
                    	case 1 :
                    	    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1667:4: otherlv_10= ',' ( (lv_mappings_11_0= ruleMapping ) )
                    	    {
                    	    otherlv_10=(Token)match(input,20,FOLLOW_20_in_ruleMorphism3529); 

                    	        	newLeafNode(otherlv_10, grammarAccess.getMorphismAccess().getCommaKeyword_9_1_0());
                    	        
                    	    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1671:1: ( (lv_mappings_11_0= ruleMapping ) )
                    	    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1672:1: (lv_mappings_11_0= ruleMapping )
                    	    {
                    	    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1672:1: (lv_mappings_11_0= ruleMapping )
                    	    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1673:3: lv_mappings_11_0= ruleMapping
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getMorphismAccess().getMappingsMappingParserRuleCall_9_1_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleMapping_in_ruleMorphism3550);
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
                    	    break loop13;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_12=(Token)match(input,29,FOLLOW_29_in_ruleMorphism3566); 

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
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1701:1: entryRuleDomain returns [EObject current=null] : iv_ruleDomain= ruleDomain EOF ;
    public final EObject entryRuleDomain() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDomain = null;


        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1702:2: (iv_ruleDomain= ruleDomain EOF )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1703:2: iv_ruleDomain= ruleDomain EOF
            {
             newCompositeNode(grammarAccess.getDomainRule()); 
            pushFollow(FOLLOW_ruleDomain_in_entryRuleDomain3602);
            iv_ruleDomain=ruleDomain();

            state._fsp--;

             current =iv_ruleDomain; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDomain3612); 

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
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1710:1: ruleDomain returns [EObject current=null] : ( (lv_id_0_0= RULE_ID ) ) ;
    public final EObject ruleDomain() throws RecognitionException {
        EObject current = null;

        Token lv_id_0_0=null;

         enterRule(); 
            
        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1713:28: ( ( (lv_id_0_0= RULE_ID ) ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1714:1: ( (lv_id_0_0= RULE_ID ) )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1714:1: ( (lv_id_0_0= RULE_ID ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1715:1: (lv_id_0_0= RULE_ID )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1715:1: (lv_id_0_0= RULE_ID )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1716:3: lv_id_0_0= RULE_ID
            {
            lv_id_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDomain3653); 

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
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1740:1: entryRuleCodomain returns [EObject current=null] : iv_ruleCodomain= ruleCodomain EOF ;
    public final EObject entryRuleCodomain() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCodomain = null;


        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1741:2: (iv_ruleCodomain= ruleCodomain EOF )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1742:2: iv_ruleCodomain= ruleCodomain EOF
            {
             newCompositeNode(grammarAccess.getCodomainRule()); 
            pushFollow(FOLLOW_ruleCodomain_in_entryRuleCodomain3693);
            iv_ruleCodomain=ruleCodomain();

            state._fsp--;

             current =iv_ruleCodomain; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCodomain3703); 

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
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1749:1: ruleCodomain returns [EObject current=null] : ( (lv_id_0_0= RULE_ID ) ) ;
    public final EObject ruleCodomain() throws RecognitionException {
        EObject current = null;

        Token lv_id_0_0=null;

         enterRule(); 
            
        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1752:28: ( ( (lv_id_0_0= RULE_ID ) ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1753:1: ( (lv_id_0_0= RULE_ID ) )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1753:1: ( (lv_id_0_0= RULE_ID ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1754:1: (lv_id_0_0= RULE_ID )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1754:1: (lv_id_0_0= RULE_ID )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1755:3: lv_id_0_0= RULE_ID
            {
            lv_id_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleCodomain3744); 

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
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1779:1: entryRuleMapping returns [EObject current=null] : iv_ruleMapping= ruleMapping EOF ;
    public final EObject entryRuleMapping() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMapping = null;


        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1780:2: (iv_ruleMapping= ruleMapping EOF )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1781:2: iv_ruleMapping= ruleMapping EOF
            {
             newCompositeNode(grammarAccess.getMappingRule()); 
            pushFollow(FOLLOW_ruleMapping_in_entryRuleMapping3784);
            iv_ruleMapping=ruleMapping();

            state._fsp--;

             current =iv_ruleMapping; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMapping3794); 

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
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1788:1: ruleMapping returns [EObject current=null] : (this_MappingNode_0= ruleMappingNode | this_MappingArrow_1= ruleMappingArrow ) ;
    public final EObject ruleMapping() throws RecognitionException {
        EObject current = null;

        EObject this_MappingNode_0 = null;

        EObject this_MappingArrow_1 = null;


         enterRule(); 
            
        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1791:28: ( (this_MappingNode_0= ruleMappingNode | this_MappingArrow_1= ruleMappingArrow ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1792:1: (this_MappingNode_0= ruleMappingNode | this_MappingArrow_1= ruleMappingArrow )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1792:1: (this_MappingNode_0= ruleMappingNode | this_MappingArrow_1= ruleMappingArrow )
            int alt15=2;
            alt15 = dfa15.predict(input);
            switch (alt15) {
                case 1 :
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1793:5: this_MappingNode_0= ruleMappingNode
                    {
                     
                            newCompositeNode(grammarAccess.getMappingAccess().getMappingNodeParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleMappingNode_in_ruleMapping3841);
                    this_MappingNode_0=ruleMappingNode();

                    state._fsp--;

                     
                            current = this_MappingNode_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1803:5: this_MappingArrow_1= ruleMappingArrow
                    {
                     
                            newCompositeNode(grammarAccess.getMappingAccess().getMappingArrowParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleMappingArrow_in_ruleMapping3868);
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
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1819:1: entryRuleMappingNode returns [EObject current=null] : iv_ruleMappingNode= ruleMappingNode EOF ;
    public final EObject entryRuleMappingNode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMappingNode = null;


        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1820:2: (iv_ruleMappingNode= ruleMappingNode EOF )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1821:2: iv_ruleMappingNode= ruleMappingNode EOF
            {
             newCompositeNode(grammarAccess.getMappingNodeRule()); 
            pushFollow(FOLLOW_ruleMappingNode_in_entryRuleMappingNode3903);
            iv_ruleMappingNode=ruleMappingNode();

            state._fsp--;

             current =iv_ruleMappingNode; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMappingNode3913); 

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
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1828:1: ruleMappingNode returns [EObject current=null] : ( ( (lv_domain_0_0= ruleNode ) ) otherlv_1= '=>' ( (lv_codomain_2_0= ruleNode ) ) ) ;
    public final EObject ruleMappingNode() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_domain_0_0 = null;

        EObject lv_codomain_2_0 = null;


         enterRule(); 
            
        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1831:28: ( ( ( (lv_domain_0_0= ruleNode ) ) otherlv_1= '=>' ( (lv_codomain_2_0= ruleNode ) ) ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1832:1: ( ( (lv_domain_0_0= ruleNode ) ) otherlv_1= '=>' ( (lv_codomain_2_0= ruleNode ) ) )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1832:1: ( ( (lv_domain_0_0= ruleNode ) ) otherlv_1= '=>' ( (lv_codomain_2_0= ruleNode ) ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1832:2: ( (lv_domain_0_0= ruleNode ) ) otherlv_1= '=>' ( (lv_codomain_2_0= ruleNode ) )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1832:2: ( (lv_domain_0_0= ruleNode ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1833:1: (lv_domain_0_0= ruleNode )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1833:1: (lv_domain_0_0= ruleNode )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1834:3: lv_domain_0_0= ruleNode
            {
             
            	        newCompositeNode(grammarAccess.getMappingNodeAccess().getDomainNodeParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleNode_in_ruleMappingNode3959);
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

            otherlv_1=(Token)match(input,36,FOLLOW_36_in_ruleMappingNode3971); 

                	newLeafNode(otherlv_1, grammarAccess.getMappingNodeAccess().getEqualsSignGreaterThanSignKeyword_1());
                
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1854:1: ( (lv_codomain_2_0= ruleNode ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1855:1: (lv_codomain_2_0= ruleNode )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1855:1: (lv_codomain_2_0= ruleNode )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1856:3: lv_codomain_2_0= ruleNode
            {
             
            	        newCompositeNode(grammarAccess.getMappingNodeAccess().getCodomainNodeParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleNode_in_ruleMappingNode3992);
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
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1880:1: entryRuleMappingArrow returns [EObject current=null] : iv_ruleMappingArrow= ruleMappingArrow EOF ;
    public final EObject entryRuleMappingArrow() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMappingArrow = null;


        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1881:2: (iv_ruleMappingArrow= ruleMappingArrow EOF )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1882:2: iv_ruleMappingArrow= ruleMappingArrow EOF
            {
             newCompositeNode(grammarAccess.getMappingArrowRule()); 
            pushFollow(FOLLOW_ruleMappingArrow_in_entryRuleMappingArrow4028);
            iv_ruleMappingArrow=ruleMappingArrow();

            state._fsp--;

             current =iv_ruleMappingArrow; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMappingArrow4038); 

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
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1889:1: ruleMappingArrow returns [EObject current=null] : ( ( (lv_domain_0_0= ruleArrow ) ) otherlv_1= '=>' ( (lv_codmain_2_0= ruleArrow ) ) ) ;
    public final EObject ruleMappingArrow() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_domain_0_0 = null;

        EObject lv_codmain_2_0 = null;


         enterRule(); 
            
        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1892:28: ( ( ( (lv_domain_0_0= ruleArrow ) ) otherlv_1= '=>' ( (lv_codmain_2_0= ruleArrow ) ) ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1893:1: ( ( (lv_domain_0_0= ruleArrow ) ) otherlv_1= '=>' ( (lv_codmain_2_0= ruleArrow ) ) )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1893:1: ( ( (lv_domain_0_0= ruleArrow ) ) otherlv_1= '=>' ( (lv_codmain_2_0= ruleArrow ) ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1893:2: ( (lv_domain_0_0= ruleArrow ) ) otherlv_1= '=>' ( (lv_codmain_2_0= ruleArrow ) )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1893:2: ( (lv_domain_0_0= ruleArrow ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1894:1: (lv_domain_0_0= ruleArrow )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1894:1: (lv_domain_0_0= ruleArrow )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1895:3: lv_domain_0_0= ruleArrow
            {
             
            	        newCompositeNode(grammarAccess.getMappingArrowAccess().getDomainArrowParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleArrow_in_ruleMappingArrow4084);
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

            otherlv_1=(Token)match(input,36,FOLLOW_36_in_ruleMappingArrow4096); 

                	newLeafNode(otherlv_1, grammarAccess.getMappingArrowAccess().getEqualsSignGreaterThanSignKeyword_1());
                
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1915:1: ( (lv_codmain_2_0= ruleArrow ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1916:1: (lv_codmain_2_0= ruleArrow )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1916:1: (lv_codmain_2_0= ruleArrow )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1917:3: lv_codmain_2_0= ruleArrow
            {
             
            	        newCompositeNode(grammarAccess.getMappingArrowAccess().getCodmainArrowParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleArrow_in_ruleMappingArrow4117);
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
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1941:1: entryRuleExtSubTGraph returns [EObject current=null] : iv_ruleExtSubTGraph= ruleExtSubTGraph EOF ;
    public final EObject entryRuleExtSubTGraph() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExtSubTGraph = null;


        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1942:2: (iv_ruleExtSubTGraph= ruleExtSubTGraph EOF )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1943:2: iv_ruleExtSubTGraph= ruleExtSubTGraph EOF
            {
             newCompositeNode(grammarAccess.getExtSubTGraphRule()); 
            pushFollow(FOLLOW_ruleExtSubTGraph_in_entryRuleExtSubTGraph4153);
            iv_ruleExtSubTGraph=ruleExtSubTGraph();

            state._fsp--;

             current =iv_ruleExtSubTGraph; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleExtSubTGraph4163); 

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
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1950:1: ruleExtSubTGraph returns [EObject current=null] : ( ( (lv_id_0_0= RULE_ID ) ) otherlv_1= ':=' otherlv_2= 'ExtSubTGraph' otherlv_3= '<' ( (lv_extendsGraph_4_0= ruleChoosenExtSubTGraph ) ) otherlv_5= '>' otherlv_6= '{' ( (lv_elements_7_0= ruleElement ) )* otherlv_8= '}' ) ;
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
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1953:28: ( ( ( (lv_id_0_0= RULE_ID ) ) otherlv_1= ':=' otherlv_2= 'ExtSubTGraph' otherlv_3= '<' ( (lv_extendsGraph_4_0= ruleChoosenExtSubTGraph ) ) otherlv_5= '>' otherlv_6= '{' ( (lv_elements_7_0= ruleElement ) )* otherlv_8= '}' ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1954:1: ( ( (lv_id_0_0= RULE_ID ) ) otherlv_1= ':=' otherlv_2= 'ExtSubTGraph' otherlv_3= '<' ( (lv_extendsGraph_4_0= ruleChoosenExtSubTGraph ) ) otherlv_5= '>' otherlv_6= '{' ( (lv_elements_7_0= ruleElement ) )* otherlv_8= '}' )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1954:1: ( ( (lv_id_0_0= RULE_ID ) ) otherlv_1= ':=' otherlv_2= 'ExtSubTGraph' otherlv_3= '<' ( (lv_extendsGraph_4_0= ruleChoosenExtSubTGraph ) ) otherlv_5= '>' otherlv_6= '{' ( (lv_elements_7_0= ruleElement ) )* otherlv_8= '}' )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1954:2: ( (lv_id_0_0= RULE_ID ) ) otherlv_1= ':=' otherlv_2= 'ExtSubTGraph' otherlv_3= '<' ( (lv_extendsGraph_4_0= ruleChoosenExtSubTGraph ) ) otherlv_5= '>' otherlv_6= '{' ( (lv_elements_7_0= ruleElement ) )* otherlv_8= '}'
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1954:2: ( (lv_id_0_0= RULE_ID ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1955:1: (lv_id_0_0= RULE_ID )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1955:1: (lv_id_0_0= RULE_ID )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1956:3: lv_id_0_0= RULE_ID
            {
            lv_id_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleExtSubTGraph4205); 

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

            otherlv_1=(Token)match(input,24,FOLLOW_24_in_ruleExtSubTGraph4222); 

                	newLeafNode(otherlv_1, grammarAccess.getExtSubTGraphAccess().getColonEqualsSignKeyword_1());
                
            otherlv_2=(Token)match(input,37,FOLLOW_37_in_ruleExtSubTGraph4234); 

                	newLeafNode(otherlv_2, grammarAccess.getExtSubTGraphAccess().getExtSubTGraphKeyword_2());
                
            otherlv_3=(Token)match(input,26,FOLLOW_26_in_ruleExtSubTGraph4246); 

                	newLeafNode(otherlv_3, grammarAccess.getExtSubTGraphAccess().getLessThanSignKeyword_3());
                
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1984:1: ( (lv_extendsGraph_4_0= ruleChoosenExtSubTGraph ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1985:1: (lv_extendsGraph_4_0= ruleChoosenExtSubTGraph )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1985:1: (lv_extendsGraph_4_0= ruleChoosenExtSubTGraph )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:1986:3: lv_extendsGraph_4_0= ruleChoosenExtSubTGraph
            {
             
            	        newCompositeNode(grammarAccess.getExtSubTGraphAccess().getExtendsGraphChoosenExtSubTGraphParserRuleCall_4_0()); 
            	    
            pushFollow(FOLLOW_ruleChoosenExtSubTGraph_in_ruleExtSubTGraph4267);
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

            otherlv_5=(Token)match(input,27,FOLLOW_27_in_ruleExtSubTGraph4279); 

                	newLeafNode(otherlv_5, grammarAccess.getExtSubTGraphAccess().getGreaterThanSignKeyword_5());
                
            otherlv_6=(Token)match(input,28,FOLLOW_28_in_ruleExtSubTGraph4291); 

                	newLeafNode(otherlv_6, grammarAccess.getExtSubTGraphAccess().getLeftCurlyBracketKeyword_6());
                
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2010:1: ( (lv_elements_7_0= ruleElement ) )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==RULE_ID) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2011:1: (lv_elements_7_0= ruleElement )
            	    {
            	    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2011:1: (lv_elements_7_0= ruleElement )
            	    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2012:3: lv_elements_7_0= ruleElement
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getExtSubTGraphAccess().getElementsElementParserRuleCall_7_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleElement_in_ruleExtSubTGraph4312);
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
            	    break loop16;
                }
            } while (true);

            otherlv_8=(Token)match(input,29,FOLLOW_29_in_ruleExtSubTGraph4325); 

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


    // $ANTLR start "entryRuleChoosenExtSubTGraph"
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2040:1: entryRuleChoosenExtSubTGraph returns [EObject current=null] : iv_ruleChoosenExtSubTGraph= ruleChoosenExtSubTGraph EOF ;
    public final EObject entryRuleChoosenExtSubTGraph() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleChoosenExtSubTGraph = null;


        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2041:2: (iv_ruleChoosenExtSubTGraph= ruleChoosenExtSubTGraph EOF )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2042:2: iv_ruleChoosenExtSubTGraph= ruleChoosenExtSubTGraph EOF
            {
             newCompositeNode(grammarAccess.getChoosenExtSubTGraphRule()); 
            pushFollow(FOLLOW_ruleChoosenExtSubTGraph_in_entryRuleChoosenExtSubTGraph4361);
            iv_ruleChoosenExtSubTGraph=ruleChoosenExtSubTGraph();

            state._fsp--;

             current =iv_ruleChoosenExtSubTGraph; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleChoosenExtSubTGraph4371); 

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
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2049:1: ruleChoosenExtSubTGraph returns [EObject current=null] : ( (lv_id_0_0= RULE_ID ) ) ;
    public final EObject ruleChoosenExtSubTGraph() throws RecognitionException {
        EObject current = null;

        Token lv_id_0_0=null;

         enterRule(); 
            
        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2052:28: ( ( (lv_id_0_0= RULE_ID ) ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2053:1: ( (lv_id_0_0= RULE_ID ) )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2053:1: ( (lv_id_0_0= RULE_ID ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2054:1: (lv_id_0_0= RULE_ID )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2054:1: (lv_id_0_0= RULE_ID )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2055:3: lv_id_0_0= RULE_ID
            {
            lv_id_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleChoosenExtSubTGraph4412); 

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
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2079:1: entryRuleGraph returns [EObject current=null] : iv_ruleGraph= ruleGraph EOF ;
    public final EObject entryRuleGraph() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGraph = null;


        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2080:2: (iv_ruleGraph= ruleGraph EOF )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2081:2: iv_ruleGraph= ruleGraph EOF
            {
             newCompositeNode(grammarAccess.getGraphRule()); 
            pushFollow(FOLLOW_ruleGraph_in_entryRuleGraph4452);
            iv_ruleGraph=ruleGraph();

            state._fsp--;

             current =iv_ruleGraph; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleGraph4462); 

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
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2088:1: ruleGraph returns [EObject current=null] : (otherlv_0= 'Graph' otherlv_1= '{' ( (lv_elements_2_0= ruleElement ) )* otherlv_3= '}' ) ;
    public final EObject ruleGraph() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_elements_2_0 = null;


         enterRule(); 
            
        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2091:28: ( (otherlv_0= 'Graph' otherlv_1= '{' ( (lv_elements_2_0= ruleElement ) )* otherlv_3= '}' ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2092:1: (otherlv_0= 'Graph' otherlv_1= '{' ( (lv_elements_2_0= ruleElement ) )* otherlv_3= '}' )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2092:1: (otherlv_0= 'Graph' otherlv_1= '{' ( (lv_elements_2_0= ruleElement ) )* otherlv_3= '}' )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2092:3: otherlv_0= 'Graph' otherlv_1= '{' ( (lv_elements_2_0= ruleElement ) )* otherlv_3= '}'
            {
            otherlv_0=(Token)match(input,38,FOLLOW_38_in_ruleGraph4499); 

                	newLeafNode(otherlv_0, grammarAccess.getGraphAccess().getGraphKeyword_0());
                
            otherlv_1=(Token)match(input,28,FOLLOW_28_in_ruleGraph4511); 

                	newLeafNode(otherlv_1, grammarAccess.getGraphAccess().getLeftCurlyBracketKeyword_1());
                
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2100:1: ( (lv_elements_2_0= ruleElement ) )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==RULE_ID) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2101:1: (lv_elements_2_0= ruleElement )
            	    {
            	    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2101:1: (lv_elements_2_0= ruleElement )
            	    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2102:3: lv_elements_2_0= ruleElement
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getGraphAccess().getElementsElementParserRuleCall_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleElement_in_ruleGraph4532);
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
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);

            otherlv_3=(Token)match(input,29,FOLLOW_29_in_ruleGraph4545); 

                	newLeafNode(otherlv_3, grammarAccess.getGraphAccess().getRightCurlyBracketKeyword_3());
                

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
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2130:1: entryRuleElement returns [EObject current=null] : iv_ruleElement= ruleElement EOF ;
    public final EObject entryRuleElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleElement = null;


        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2131:2: (iv_ruleElement= ruleElement EOF )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2132:2: iv_ruleElement= ruleElement EOF
            {
             newCompositeNode(grammarAccess.getElementRule()); 
            pushFollow(FOLLOW_ruleElement_in_entryRuleElement4581);
            iv_ruleElement=ruleElement();

            state._fsp--;

             current =iv_ruleElement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleElement4591); 

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
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2139:1: ruleElement returns [EObject current=null] : ( (this_Node_0= ruleNode otherlv_1= ',' ) | (this_Arrows_2= ruleArrows otherlv_3= ',' ) ) ;
    public final EObject ruleElement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject this_Node_0 = null;

        EObject this_Arrows_2 = null;


         enterRule(); 
            
        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2142:28: ( ( (this_Node_0= ruleNode otherlv_1= ',' ) | (this_Arrows_2= ruleArrows otherlv_3= ',' ) ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2143:1: ( (this_Node_0= ruleNode otherlv_1= ',' ) | (this_Arrows_2= ruleArrows otherlv_3= ',' ) )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2143:1: ( (this_Node_0= ruleNode otherlv_1= ',' ) | (this_Arrows_2= ruleArrows otherlv_3= ',' ) )
            int alt18=2;
            alt18 = dfa18.predict(input);
            switch (alt18) {
                case 1 :
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2143:2: (this_Node_0= ruleNode otherlv_1= ',' )
                    {
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2143:2: (this_Node_0= ruleNode otherlv_1= ',' )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2144:5: this_Node_0= ruleNode otherlv_1= ','
                    {
                     
                            newCompositeNode(grammarAccess.getElementAccess().getNodeParserRuleCall_0_0()); 
                        
                    pushFollow(FOLLOW_ruleNode_in_ruleElement4639);
                    this_Node_0=ruleNode();

                    state._fsp--;

                     
                            current = this_Node_0; 
                            afterParserOrEnumRuleCall();
                        
                    otherlv_1=(Token)match(input,20,FOLLOW_20_in_ruleElement4650); 

                        	newLeafNode(otherlv_1, grammarAccess.getElementAccess().getCommaKeyword_0_1());
                        

                    }


                    }
                    break;
                case 2 :
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2157:6: (this_Arrows_2= ruleArrows otherlv_3= ',' )
                    {
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2157:6: (this_Arrows_2= ruleArrows otherlv_3= ',' )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2158:5: this_Arrows_2= ruleArrows otherlv_3= ','
                    {
                     
                            newCompositeNode(grammarAccess.getElementAccess().getArrowsParserRuleCall_1_0()); 
                        
                    pushFollow(FOLLOW_ruleArrows_in_ruleElement4680);
                    this_Arrows_2=ruleArrows();

                    state._fsp--;

                     
                            current = this_Arrows_2; 
                            afterParserOrEnumRuleCall();
                        
                    otherlv_3=(Token)match(input,20,FOLLOW_20_in_ruleElement4691); 

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
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2178:1: entryRuleArrows returns [EObject current=null] : iv_ruleArrows= ruleArrows EOF ;
    public final EObject entryRuleArrows() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArrows = null;


        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2179:2: (iv_ruleArrows= ruleArrows EOF )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2180:2: iv_ruleArrows= ruleArrows EOF
            {
             newCompositeNode(grammarAccess.getArrowsRule()); 
            pushFollow(FOLLOW_ruleArrows_in_entryRuleArrows4728);
            iv_ruleArrows=ruleArrows();

            state._fsp--;

             current =iv_ruleArrows; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleArrows4738); 

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
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2187:1: ruleArrows returns [EObject current=null] : ( ( ( (lv_sr_0_0= ruleNode ) ) otherlv_1= '-' ( (lv_id_2_0= ruleDpfId ) ) otherlv_3= ':' ( (lv_type_4_0= ruleDpfId ) ) otherlv_5= '->' ( (lv_next_6_0= ruleArrows ) ) ) | this_Arrow_7= ruleArrow ) ;
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
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2190:28: ( ( ( ( (lv_sr_0_0= ruleNode ) ) otherlv_1= '-' ( (lv_id_2_0= ruleDpfId ) ) otherlv_3= ':' ( (lv_type_4_0= ruleDpfId ) ) otherlv_5= '->' ( (lv_next_6_0= ruleArrows ) ) ) | this_Arrow_7= ruleArrow ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2191:1: ( ( ( (lv_sr_0_0= ruleNode ) ) otherlv_1= '-' ( (lv_id_2_0= ruleDpfId ) ) otherlv_3= ':' ( (lv_type_4_0= ruleDpfId ) ) otherlv_5= '->' ( (lv_next_6_0= ruleArrows ) ) ) | this_Arrow_7= ruleArrow )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2191:1: ( ( ( (lv_sr_0_0= ruleNode ) ) otherlv_1= '-' ( (lv_id_2_0= ruleDpfId ) ) otherlv_3= ':' ( (lv_type_4_0= ruleDpfId ) ) otherlv_5= '->' ( (lv_next_6_0= ruleArrows ) ) ) | this_Arrow_7= ruleArrow )
            int alt19=2;
            alt19 = dfa19.predict(input);
            switch (alt19) {
                case 1 :
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2191:2: ( ( (lv_sr_0_0= ruleNode ) ) otherlv_1= '-' ( (lv_id_2_0= ruleDpfId ) ) otherlv_3= ':' ( (lv_type_4_0= ruleDpfId ) ) otherlv_5= '->' ( (lv_next_6_0= ruleArrows ) ) )
                    {
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2191:2: ( ( (lv_sr_0_0= ruleNode ) ) otherlv_1= '-' ( (lv_id_2_0= ruleDpfId ) ) otherlv_3= ':' ( (lv_type_4_0= ruleDpfId ) ) otherlv_5= '->' ( (lv_next_6_0= ruleArrows ) ) )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2191:3: ( (lv_sr_0_0= ruleNode ) ) otherlv_1= '-' ( (lv_id_2_0= ruleDpfId ) ) otherlv_3= ':' ( (lv_type_4_0= ruleDpfId ) ) otherlv_5= '->' ( (lv_next_6_0= ruleArrows ) )
                    {
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2191:3: ( (lv_sr_0_0= ruleNode ) )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2192:1: (lv_sr_0_0= ruleNode )
                    {
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2192:1: (lv_sr_0_0= ruleNode )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2193:3: lv_sr_0_0= ruleNode
                    {
                     
                    	        newCompositeNode(grammarAccess.getArrowsAccess().getSrNodeParserRuleCall_0_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleNode_in_ruleArrows4785);
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

                    otherlv_1=(Token)match(input,39,FOLLOW_39_in_ruleArrows4797); 

                        	newLeafNode(otherlv_1, grammarAccess.getArrowsAccess().getHyphenMinusKeyword_0_1());
                        
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2213:1: ( (lv_id_2_0= ruleDpfId ) )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2214:1: (lv_id_2_0= ruleDpfId )
                    {
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2214:1: (lv_id_2_0= ruleDpfId )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2215:3: lv_id_2_0= ruleDpfId
                    {
                     
                    	        newCompositeNode(grammarAccess.getArrowsAccess().getIdDpfIdParserRuleCall_0_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDpfId_in_ruleArrows4818);
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

                    otherlv_3=(Token)match(input,32,FOLLOW_32_in_ruleArrows4830); 

                        	newLeafNode(otherlv_3, grammarAccess.getArrowsAccess().getColonKeyword_0_3());
                        
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2235:1: ( (lv_type_4_0= ruleDpfId ) )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2236:1: (lv_type_4_0= ruleDpfId )
                    {
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2236:1: (lv_type_4_0= ruleDpfId )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2237:3: lv_type_4_0= ruleDpfId
                    {
                     
                    	        newCompositeNode(grammarAccess.getArrowsAccess().getTypeDpfIdParserRuleCall_0_4_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDpfId_in_ruleArrows4851);
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

                    otherlv_5=(Token)match(input,19,FOLLOW_19_in_ruleArrows4863); 

                        	newLeafNode(otherlv_5, grammarAccess.getArrowsAccess().getHyphenMinusGreaterThanSignKeyword_0_5());
                        
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2257:1: ( (lv_next_6_0= ruleArrows ) )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2258:1: (lv_next_6_0= ruleArrows )
                    {
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2258:1: (lv_next_6_0= ruleArrows )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2259:3: lv_next_6_0= ruleArrows
                    {
                     
                    	        newCompositeNode(grammarAccess.getArrowsAccess().getNextArrowsParserRuleCall_0_6_0()); 
                    	    
                    pushFollow(FOLLOW_ruleArrows_in_ruleArrows4884);
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
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2277:5: this_Arrow_7= ruleArrow
                    {
                     
                            newCompositeNode(grammarAccess.getArrowsAccess().getArrowParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleArrow_in_ruleArrows4913);
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
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2293:1: entryRuleArrow returns [EObject current=null] : iv_ruleArrow= ruleArrow EOF ;
    public final EObject entryRuleArrow() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArrow = null;


        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2294:2: (iv_ruleArrow= ruleArrow EOF )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2295:2: iv_ruleArrow= ruleArrow EOF
            {
             newCompositeNode(grammarAccess.getArrowRule()); 
            pushFollow(FOLLOW_ruleArrow_in_entryRuleArrow4948);
            iv_ruleArrow=ruleArrow();

            state._fsp--;

             current =iv_ruleArrow; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleArrow4958); 

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
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2302:1: ruleArrow returns [EObject current=null] : ( ( ( (lv_sr_0_0= ruleNode ) ) otherlv_1= '-' ( (lv_id_2_0= ruleDpfId ) ) otherlv_3= ':' otherlv_4= '*' otherlv_5= '->' ( (lv_tgDataType_6_0= ruleDataType ) ) ) | ( ( (lv_sr_7_0= ruleNode ) ) otherlv_8= '-' ( (lv_id_9_0= ruleDpfId ) ) otherlv_10= ':' ( (lv_type_11_0= ruleDpfId ) ) otherlv_12= '->' ( (lv_tgValue_13_0= ruleAttributeValue ) ) ) | ( ( (lv_sr_14_0= ruleNode ) ) otherlv_15= '-' ( (lv_id_16_0= ruleDpfId ) ) otherlv_17= ':' ( (lv_type_18_0= ruleDpfId ) ) otherlv_19= '->' ( (lv_tgNode_20_0= ruleNode ) ) ) ) ;
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
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2305:28: ( ( ( ( (lv_sr_0_0= ruleNode ) ) otherlv_1= '-' ( (lv_id_2_0= ruleDpfId ) ) otherlv_3= ':' otherlv_4= '*' otherlv_5= '->' ( (lv_tgDataType_6_0= ruleDataType ) ) ) | ( ( (lv_sr_7_0= ruleNode ) ) otherlv_8= '-' ( (lv_id_9_0= ruleDpfId ) ) otherlv_10= ':' ( (lv_type_11_0= ruleDpfId ) ) otherlv_12= '->' ( (lv_tgValue_13_0= ruleAttributeValue ) ) ) | ( ( (lv_sr_14_0= ruleNode ) ) otherlv_15= '-' ( (lv_id_16_0= ruleDpfId ) ) otherlv_17= ':' ( (lv_type_18_0= ruleDpfId ) ) otherlv_19= '->' ( (lv_tgNode_20_0= ruleNode ) ) ) ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2306:1: ( ( ( (lv_sr_0_0= ruleNode ) ) otherlv_1= '-' ( (lv_id_2_0= ruleDpfId ) ) otherlv_3= ':' otherlv_4= '*' otherlv_5= '->' ( (lv_tgDataType_6_0= ruleDataType ) ) ) | ( ( (lv_sr_7_0= ruleNode ) ) otherlv_8= '-' ( (lv_id_9_0= ruleDpfId ) ) otherlv_10= ':' ( (lv_type_11_0= ruleDpfId ) ) otherlv_12= '->' ( (lv_tgValue_13_0= ruleAttributeValue ) ) ) | ( ( (lv_sr_14_0= ruleNode ) ) otherlv_15= '-' ( (lv_id_16_0= ruleDpfId ) ) otherlv_17= ':' ( (lv_type_18_0= ruleDpfId ) ) otherlv_19= '->' ( (lv_tgNode_20_0= ruleNode ) ) ) )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2306:1: ( ( ( (lv_sr_0_0= ruleNode ) ) otherlv_1= '-' ( (lv_id_2_0= ruleDpfId ) ) otherlv_3= ':' otherlv_4= '*' otherlv_5= '->' ( (lv_tgDataType_6_0= ruleDataType ) ) ) | ( ( (lv_sr_7_0= ruleNode ) ) otherlv_8= '-' ( (lv_id_9_0= ruleDpfId ) ) otherlv_10= ':' ( (lv_type_11_0= ruleDpfId ) ) otherlv_12= '->' ( (lv_tgValue_13_0= ruleAttributeValue ) ) ) | ( ( (lv_sr_14_0= ruleNode ) ) otherlv_15= '-' ( (lv_id_16_0= ruleDpfId ) ) otherlv_17= ':' ( (lv_type_18_0= ruleDpfId ) ) otherlv_19= '->' ( (lv_tgNode_20_0= ruleNode ) ) ) )
            int alt20=3;
            alt20 = dfa20.predict(input);
            switch (alt20) {
                case 1 :
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2306:2: ( ( (lv_sr_0_0= ruleNode ) ) otherlv_1= '-' ( (lv_id_2_0= ruleDpfId ) ) otherlv_3= ':' otherlv_4= '*' otherlv_5= '->' ( (lv_tgDataType_6_0= ruleDataType ) ) )
                    {
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2306:2: ( ( (lv_sr_0_0= ruleNode ) ) otherlv_1= '-' ( (lv_id_2_0= ruleDpfId ) ) otherlv_3= ':' otherlv_4= '*' otherlv_5= '->' ( (lv_tgDataType_6_0= ruleDataType ) ) )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2306:3: ( (lv_sr_0_0= ruleNode ) ) otherlv_1= '-' ( (lv_id_2_0= ruleDpfId ) ) otherlv_3= ':' otherlv_4= '*' otherlv_5= '->' ( (lv_tgDataType_6_0= ruleDataType ) )
                    {
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2306:3: ( (lv_sr_0_0= ruleNode ) )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2307:1: (lv_sr_0_0= ruleNode )
                    {
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2307:1: (lv_sr_0_0= ruleNode )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2308:3: lv_sr_0_0= ruleNode
                    {
                     
                    	        newCompositeNode(grammarAccess.getArrowAccess().getSrNodeParserRuleCall_0_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleNode_in_ruleArrow5005);
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

                    otherlv_1=(Token)match(input,39,FOLLOW_39_in_ruleArrow5017); 

                        	newLeafNode(otherlv_1, grammarAccess.getArrowAccess().getHyphenMinusKeyword_0_1());
                        
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2328:1: ( (lv_id_2_0= ruleDpfId ) )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2329:1: (lv_id_2_0= ruleDpfId )
                    {
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2329:1: (lv_id_2_0= ruleDpfId )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2330:3: lv_id_2_0= ruleDpfId
                    {
                     
                    	        newCompositeNode(grammarAccess.getArrowAccess().getIdDpfIdParserRuleCall_0_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDpfId_in_ruleArrow5038);
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

                    otherlv_3=(Token)match(input,32,FOLLOW_32_in_ruleArrow5050); 

                        	newLeafNode(otherlv_3, grammarAccess.getArrowAccess().getColonKeyword_0_3());
                        
                    otherlv_4=(Token)match(input,40,FOLLOW_40_in_ruleArrow5062); 

                        	newLeafNode(otherlv_4, grammarAccess.getArrowAccess().getAsteriskKeyword_0_4());
                        
                    otherlv_5=(Token)match(input,19,FOLLOW_19_in_ruleArrow5074); 

                        	newLeafNode(otherlv_5, grammarAccess.getArrowAccess().getHyphenMinusGreaterThanSignKeyword_0_5());
                        
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2358:1: ( (lv_tgDataType_6_0= ruleDataType ) )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2359:1: (lv_tgDataType_6_0= ruleDataType )
                    {
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2359:1: (lv_tgDataType_6_0= ruleDataType )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2360:3: lv_tgDataType_6_0= ruleDataType
                    {
                     
                    	        newCompositeNode(grammarAccess.getArrowAccess().getTgDataTypeDataTypeEnumRuleCall_0_6_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDataType_in_ruleArrow5095);
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
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2377:6: ( ( (lv_sr_7_0= ruleNode ) ) otherlv_8= '-' ( (lv_id_9_0= ruleDpfId ) ) otherlv_10= ':' ( (lv_type_11_0= ruleDpfId ) ) otherlv_12= '->' ( (lv_tgValue_13_0= ruleAttributeValue ) ) )
                    {
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2377:6: ( ( (lv_sr_7_0= ruleNode ) ) otherlv_8= '-' ( (lv_id_9_0= ruleDpfId ) ) otherlv_10= ':' ( (lv_type_11_0= ruleDpfId ) ) otherlv_12= '->' ( (lv_tgValue_13_0= ruleAttributeValue ) ) )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2377:7: ( (lv_sr_7_0= ruleNode ) ) otherlv_8= '-' ( (lv_id_9_0= ruleDpfId ) ) otherlv_10= ':' ( (lv_type_11_0= ruleDpfId ) ) otherlv_12= '->' ( (lv_tgValue_13_0= ruleAttributeValue ) )
                    {
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2377:7: ( (lv_sr_7_0= ruleNode ) )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2378:1: (lv_sr_7_0= ruleNode )
                    {
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2378:1: (lv_sr_7_0= ruleNode )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2379:3: lv_sr_7_0= ruleNode
                    {
                     
                    	        newCompositeNode(grammarAccess.getArrowAccess().getSrNodeParserRuleCall_1_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleNode_in_ruleArrow5124);
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

                    otherlv_8=(Token)match(input,39,FOLLOW_39_in_ruleArrow5136); 

                        	newLeafNode(otherlv_8, grammarAccess.getArrowAccess().getHyphenMinusKeyword_1_1());
                        
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2399:1: ( (lv_id_9_0= ruleDpfId ) )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2400:1: (lv_id_9_0= ruleDpfId )
                    {
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2400:1: (lv_id_9_0= ruleDpfId )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2401:3: lv_id_9_0= ruleDpfId
                    {
                     
                    	        newCompositeNode(grammarAccess.getArrowAccess().getIdDpfIdParserRuleCall_1_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDpfId_in_ruleArrow5157);
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

                    otherlv_10=(Token)match(input,32,FOLLOW_32_in_ruleArrow5169); 

                        	newLeafNode(otherlv_10, grammarAccess.getArrowAccess().getColonKeyword_1_3());
                        
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2421:1: ( (lv_type_11_0= ruleDpfId ) )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2422:1: (lv_type_11_0= ruleDpfId )
                    {
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2422:1: (lv_type_11_0= ruleDpfId )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2423:3: lv_type_11_0= ruleDpfId
                    {
                     
                    	        newCompositeNode(grammarAccess.getArrowAccess().getTypeDpfIdParserRuleCall_1_4_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDpfId_in_ruleArrow5190);
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

                    otherlv_12=(Token)match(input,19,FOLLOW_19_in_ruleArrow5202); 

                        	newLeafNode(otherlv_12, grammarAccess.getArrowAccess().getHyphenMinusGreaterThanSignKeyword_1_5());
                        
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2443:1: ( (lv_tgValue_13_0= ruleAttributeValue ) )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2444:1: (lv_tgValue_13_0= ruleAttributeValue )
                    {
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2444:1: (lv_tgValue_13_0= ruleAttributeValue )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2445:3: lv_tgValue_13_0= ruleAttributeValue
                    {
                     
                    	        newCompositeNode(grammarAccess.getArrowAccess().getTgValueAttributeValueParserRuleCall_1_6_0()); 
                    	    
                    pushFollow(FOLLOW_ruleAttributeValue_in_ruleArrow5223);
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
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2462:6: ( ( (lv_sr_14_0= ruleNode ) ) otherlv_15= '-' ( (lv_id_16_0= ruleDpfId ) ) otherlv_17= ':' ( (lv_type_18_0= ruleDpfId ) ) otherlv_19= '->' ( (lv_tgNode_20_0= ruleNode ) ) )
                    {
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2462:6: ( ( (lv_sr_14_0= ruleNode ) ) otherlv_15= '-' ( (lv_id_16_0= ruleDpfId ) ) otherlv_17= ':' ( (lv_type_18_0= ruleDpfId ) ) otherlv_19= '->' ( (lv_tgNode_20_0= ruleNode ) ) )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2462:7: ( (lv_sr_14_0= ruleNode ) ) otherlv_15= '-' ( (lv_id_16_0= ruleDpfId ) ) otherlv_17= ':' ( (lv_type_18_0= ruleDpfId ) ) otherlv_19= '->' ( (lv_tgNode_20_0= ruleNode ) )
                    {
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2462:7: ( (lv_sr_14_0= ruleNode ) )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2463:1: (lv_sr_14_0= ruleNode )
                    {
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2463:1: (lv_sr_14_0= ruleNode )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2464:3: lv_sr_14_0= ruleNode
                    {
                     
                    	        newCompositeNode(grammarAccess.getArrowAccess().getSrNodeParserRuleCall_2_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleNode_in_ruleArrow5252);
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

                    otherlv_15=(Token)match(input,39,FOLLOW_39_in_ruleArrow5264); 

                        	newLeafNode(otherlv_15, grammarAccess.getArrowAccess().getHyphenMinusKeyword_2_1());
                        
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2484:1: ( (lv_id_16_0= ruleDpfId ) )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2485:1: (lv_id_16_0= ruleDpfId )
                    {
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2485:1: (lv_id_16_0= ruleDpfId )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2486:3: lv_id_16_0= ruleDpfId
                    {
                     
                    	        newCompositeNode(grammarAccess.getArrowAccess().getIdDpfIdParserRuleCall_2_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDpfId_in_ruleArrow5285);
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

                    otherlv_17=(Token)match(input,32,FOLLOW_32_in_ruleArrow5297); 

                        	newLeafNode(otherlv_17, grammarAccess.getArrowAccess().getColonKeyword_2_3());
                        
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2506:1: ( (lv_type_18_0= ruleDpfId ) )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2507:1: (lv_type_18_0= ruleDpfId )
                    {
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2507:1: (lv_type_18_0= ruleDpfId )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2508:3: lv_type_18_0= ruleDpfId
                    {
                     
                    	        newCompositeNode(grammarAccess.getArrowAccess().getTypeDpfIdParserRuleCall_2_4_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDpfId_in_ruleArrow5318);
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

                    otherlv_19=(Token)match(input,19,FOLLOW_19_in_ruleArrow5330); 

                        	newLeafNode(otherlv_19, grammarAccess.getArrowAccess().getHyphenMinusGreaterThanSignKeyword_2_5());
                        
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2528:1: ( (lv_tgNode_20_0= ruleNode ) )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2529:1: (lv_tgNode_20_0= ruleNode )
                    {
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2529:1: (lv_tgNode_20_0= ruleNode )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2530:3: lv_tgNode_20_0= ruleNode
                    {
                     
                    	        newCompositeNode(grammarAccess.getArrowAccess().getTgNodeNodeParserRuleCall_2_6_0()); 
                    	    
                    pushFollow(FOLLOW_ruleNode_in_ruleArrow5351);
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
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2554:1: entryRuleNode returns [EObject current=null] : iv_ruleNode= ruleNode EOF ;
    public final EObject entryRuleNode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNode = null;


        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2555:2: (iv_ruleNode= ruleNode EOF )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2556:2: iv_ruleNode= ruleNode EOF
            {
             newCompositeNode(grammarAccess.getNodeRule()); 
            pushFollow(FOLLOW_ruleNode_in_entryRuleNode5388);
            iv_ruleNode=ruleNode();

            state._fsp--;

             current =iv_ruleNode; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNode5398); 

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
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2563:1: ruleNode returns [EObject current=null] : ( ( (lv_id_0_0= ruleDpfId ) ) otherlv_1= ':' ( (lv_type_2_0= ruleDpfId ) ) ) ;
    public final EObject ruleNode() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_id_0_0 = null;

        EObject lv_type_2_0 = null;


         enterRule(); 
            
        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2566:28: ( ( ( (lv_id_0_0= ruleDpfId ) ) otherlv_1= ':' ( (lv_type_2_0= ruleDpfId ) ) ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2567:1: ( ( (lv_id_0_0= ruleDpfId ) ) otherlv_1= ':' ( (lv_type_2_0= ruleDpfId ) ) )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2567:1: ( ( (lv_id_0_0= ruleDpfId ) ) otherlv_1= ':' ( (lv_type_2_0= ruleDpfId ) ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2567:2: ( (lv_id_0_0= ruleDpfId ) ) otherlv_1= ':' ( (lv_type_2_0= ruleDpfId ) )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2567:2: ( (lv_id_0_0= ruleDpfId ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2568:1: (lv_id_0_0= ruleDpfId )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2568:1: (lv_id_0_0= ruleDpfId )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2569:3: lv_id_0_0= ruleDpfId
            {
             
            	        newCompositeNode(grammarAccess.getNodeAccess().getIdDpfIdParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleDpfId_in_ruleNode5444);
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

            otherlv_1=(Token)match(input,32,FOLLOW_32_in_ruleNode5456); 

                	newLeafNode(otherlv_1, grammarAccess.getNodeAccess().getColonKeyword_1());
                
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2589:1: ( (lv_type_2_0= ruleDpfId ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2590:1: (lv_type_2_0= ruleDpfId )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2590:1: (lv_type_2_0= ruleDpfId )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2591:3: lv_type_2_0= ruleDpfId
            {
             
            	        newCompositeNode(grammarAccess.getNodeAccess().getTypeDpfIdParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleDpfId_in_ruleNode5477);
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
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2615:1: entryRuleAttributeValue returns [EObject current=null] : iv_ruleAttributeValue= ruleAttributeValue EOF ;
    public final EObject entryRuleAttributeValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttributeValue = null;


        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2616:2: (iv_ruleAttributeValue= ruleAttributeValue EOF )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2617:2: iv_ruleAttributeValue= ruleAttributeValue EOF
            {
             newCompositeNode(grammarAccess.getAttributeValueRule()); 
            pushFollow(FOLLOW_ruleAttributeValue_in_entryRuleAttributeValue5513);
            iv_ruleAttributeValue=ruleAttributeValue();

            state._fsp--;

             current =iv_ruleAttributeValue; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAttributeValue5523); 

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
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2624:1: ruleAttributeValue returns [EObject current=null] : (otherlv_0= '[' ( (lv_value_1_0= ruleVALUE ) ) otherlv_2= ']' ) ;
    public final EObject ruleAttributeValue() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        AntlrDatatypeRuleToken lv_value_1_0 = null;


         enterRule(); 
            
        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2627:28: ( (otherlv_0= '[' ( (lv_value_1_0= ruleVALUE ) ) otherlv_2= ']' ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2628:1: (otherlv_0= '[' ( (lv_value_1_0= ruleVALUE ) ) otherlv_2= ']' )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2628:1: (otherlv_0= '[' ( (lv_value_1_0= ruleVALUE ) ) otherlv_2= ']' )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2628:3: otherlv_0= '[' ( (lv_value_1_0= ruleVALUE ) ) otherlv_2= ']'
            {
            otherlv_0=(Token)match(input,41,FOLLOW_41_in_ruleAttributeValue5560); 

                	newLeafNode(otherlv_0, grammarAccess.getAttributeValueAccess().getLeftSquareBracketKeyword_0());
                
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2632:1: ( (lv_value_1_0= ruleVALUE ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2633:1: (lv_value_1_0= ruleVALUE )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2633:1: (lv_value_1_0= ruleVALUE )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2634:3: lv_value_1_0= ruleVALUE
            {
             
            	        newCompositeNode(grammarAccess.getAttributeValueAccess().getValueVALUEParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleVALUE_in_ruleAttributeValue5581);
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

            otherlv_2=(Token)match(input,42,FOLLOW_42_in_ruleAttributeValue5593); 

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
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2662:1: entryRuleDpfId returns [EObject current=null] : iv_ruleDpfId= ruleDpfId EOF ;
    public final EObject entryRuleDpfId() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDpfId = null;


        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2663:2: (iv_ruleDpfId= ruleDpfId EOF )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2664:2: iv_ruleDpfId= ruleDpfId EOF
            {
             newCompositeNode(grammarAccess.getDpfIdRule()); 
            pushFollow(FOLLOW_ruleDpfId_in_entryRuleDpfId5629);
            iv_ruleDpfId=ruleDpfId();

            state._fsp--;

             current =iv_ruleDpfId; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDpfId5639); 

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
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2671:1: ruleDpfId returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '@' ( (lv_id_2_0= RULE_INT ) ) )? ) ;
    public final EObject ruleDpfId() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token lv_id_2_0=null;

         enterRule(); 
            
        try {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2674:28: ( ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '@' ( (lv_id_2_0= RULE_INT ) ) )? ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2675:1: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '@' ( (lv_id_2_0= RULE_INT ) ) )? )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2675:1: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '@' ( (lv_id_2_0= RULE_INT ) ) )? )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2675:2: ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '@' ( (lv_id_2_0= RULE_INT ) ) )?
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2675:2: ( (lv_name_0_0= RULE_ID ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2676:1: (lv_name_0_0= RULE_ID )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2676:1: (lv_name_0_0= RULE_ID )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2677:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDpfId5681); 

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

            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2693:2: (otherlv_1= '@' ( (lv_id_2_0= RULE_INT ) ) )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==43) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2693:4: otherlv_1= '@' ( (lv_id_2_0= RULE_INT ) )
                    {
                    otherlv_1=(Token)match(input,43,FOLLOW_43_in_ruleDpfId5699); 

                        	newLeafNode(otherlv_1, grammarAccess.getDpfIdAccess().getCommercialAtKeyword_1_0());
                        
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2697:1: ( (lv_id_2_0= RULE_INT ) )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2698:1: (lv_id_2_0= RULE_INT )
                    {
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2698:1: (lv_id_2_0= RULE_INT )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2699:3: lv_id_2_0= RULE_INT
                    {
                    lv_id_2_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleDpfId5716); 

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
    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2723:1: ruleDataType returns [Enumerator current=null] : ( (enumLiteral_0= 'Boolean' ) | (enumLiteral_1= 'Char' ) | (enumLiteral_2= 'Byte' ) | (enumLiteral_3= 'Short' ) | (enumLiteral_4= 'Int' ) | (enumLiteral_5= 'Long' ) | (enumLiteral_6= 'Float' ) | (enumLiteral_7= 'Double' ) | (enumLiteral_8= 'String' ) ) ;
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
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2725:28: ( ( (enumLiteral_0= 'Boolean' ) | (enumLiteral_1= 'Char' ) | (enumLiteral_2= 'Byte' ) | (enumLiteral_3= 'Short' ) | (enumLiteral_4= 'Int' ) | (enumLiteral_5= 'Long' ) | (enumLiteral_6= 'Float' ) | (enumLiteral_7= 'Double' ) | (enumLiteral_8= 'String' ) ) )
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2726:1: ( (enumLiteral_0= 'Boolean' ) | (enumLiteral_1= 'Char' ) | (enumLiteral_2= 'Byte' ) | (enumLiteral_3= 'Short' ) | (enumLiteral_4= 'Int' ) | (enumLiteral_5= 'Long' ) | (enumLiteral_6= 'Float' ) | (enumLiteral_7= 'Double' ) | (enumLiteral_8= 'String' ) )
            {
            // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2726:1: ( (enumLiteral_0= 'Boolean' ) | (enumLiteral_1= 'Char' ) | (enumLiteral_2= 'Byte' ) | (enumLiteral_3= 'Short' ) | (enumLiteral_4= 'Int' ) | (enumLiteral_5= 'Long' ) | (enumLiteral_6= 'Float' ) | (enumLiteral_7= 'Double' ) | (enumLiteral_8= 'String' ) )
            int alt22=9;
            switch ( input.LA(1) ) {
            case 44:
                {
                alt22=1;
                }
                break;
            case 45:
                {
                alt22=2;
                }
                break;
            case 46:
                {
                alt22=3;
                }
                break;
            case 47:
                {
                alt22=4;
                }
                break;
            case 48:
                {
                alt22=5;
                }
                break;
            case 49:
                {
                alt22=6;
                }
                break;
            case 50:
                {
                alt22=7;
                }
                break;
            case 51:
                {
                alt22=8;
                }
                break;
            case 52:
                {
                alt22=9;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }

            switch (alt22) {
                case 1 :
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2726:2: (enumLiteral_0= 'Boolean' )
                    {
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2726:2: (enumLiteral_0= 'Boolean' )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2726:4: enumLiteral_0= 'Boolean'
                    {
                    enumLiteral_0=(Token)match(input,44,FOLLOW_44_in_ruleDataType5773); 

                            current = grammarAccess.getDataTypeAccess().getTBOOLEANEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getDataTypeAccess().getTBOOLEANEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2732:6: (enumLiteral_1= 'Char' )
                    {
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2732:6: (enumLiteral_1= 'Char' )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2732:8: enumLiteral_1= 'Char'
                    {
                    enumLiteral_1=(Token)match(input,45,FOLLOW_45_in_ruleDataType5790); 

                            current = grammarAccess.getDataTypeAccess().getTCHAREnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getDataTypeAccess().getTCHAREnumLiteralDeclaration_1()); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2738:6: (enumLiteral_2= 'Byte' )
                    {
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2738:6: (enumLiteral_2= 'Byte' )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2738:8: enumLiteral_2= 'Byte'
                    {
                    enumLiteral_2=(Token)match(input,46,FOLLOW_46_in_ruleDataType5807); 

                            current = grammarAccess.getDataTypeAccess().getTBYTEEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_2, grammarAccess.getDataTypeAccess().getTBYTEEnumLiteralDeclaration_2()); 
                        

                    }


                    }
                    break;
                case 4 :
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2744:6: (enumLiteral_3= 'Short' )
                    {
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2744:6: (enumLiteral_3= 'Short' )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2744:8: enumLiteral_3= 'Short'
                    {
                    enumLiteral_3=(Token)match(input,47,FOLLOW_47_in_ruleDataType5824); 

                            current = grammarAccess.getDataTypeAccess().getTSHORTEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_3, grammarAccess.getDataTypeAccess().getTSHORTEnumLiteralDeclaration_3()); 
                        

                    }


                    }
                    break;
                case 5 :
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2750:6: (enumLiteral_4= 'Int' )
                    {
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2750:6: (enumLiteral_4= 'Int' )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2750:8: enumLiteral_4= 'Int'
                    {
                    enumLiteral_4=(Token)match(input,48,FOLLOW_48_in_ruleDataType5841); 

                            current = grammarAccess.getDataTypeAccess().getTINTEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_4, grammarAccess.getDataTypeAccess().getTINTEnumLiteralDeclaration_4()); 
                        

                    }


                    }
                    break;
                case 6 :
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2756:6: (enumLiteral_5= 'Long' )
                    {
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2756:6: (enumLiteral_5= 'Long' )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2756:8: enumLiteral_5= 'Long'
                    {
                    enumLiteral_5=(Token)match(input,49,FOLLOW_49_in_ruleDataType5858); 

                            current = grammarAccess.getDataTypeAccess().getTLONGEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_5, grammarAccess.getDataTypeAccess().getTLONGEnumLiteralDeclaration_5()); 
                        

                    }


                    }
                    break;
                case 7 :
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2762:6: (enumLiteral_6= 'Float' )
                    {
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2762:6: (enumLiteral_6= 'Float' )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2762:8: enumLiteral_6= 'Float'
                    {
                    enumLiteral_6=(Token)match(input,50,FOLLOW_50_in_ruleDataType5875); 

                            current = grammarAccess.getDataTypeAccess().getTFLOATEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_6, grammarAccess.getDataTypeAccess().getTFLOATEnumLiteralDeclaration_6()); 
                        

                    }


                    }
                    break;
                case 8 :
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2768:6: (enumLiteral_7= 'Double' )
                    {
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2768:6: (enumLiteral_7= 'Double' )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2768:8: enumLiteral_7= 'Double'
                    {
                    enumLiteral_7=(Token)match(input,51,FOLLOW_51_in_ruleDataType5892); 

                            current = grammarAccess.getDataTypeAccess().getTDOUBLEEnumLiteralDeclaration_7().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_7, grammarAccess.getDataTypeAccess().getTDOUBLEEnumLiteralDeclaration_7()); 
                        

                    }


                    }
                    break;
                case 9 :
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2774:6: (enumLiteral_8= 'String' )
                    {
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2774:6: (enumLiteral_8= 'String' )
                    // ../no.hib.dpf.text/src-gen/no/hib/dpf/text/parser/antlr/internal/InternalDPFText.g:2774:8: enumLiteral_8= 'String'
                    {
                    enumLiteral_8=(Token)match(input,52,FOLLOW_52_in_ruleDataType5909); 

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
    protected DFA15 dfa15 = new DFA15(this);
    protected DFA18 dfa18 = new DFA18(this);
    protected DFA19 dfa19 = new DFA19(this);
    protected DFA20 dfa20 = new DFA20(this);
    static final String DFA5_eotS =
        "\21\uffff";
    static final String DFA5_eofS =
        "\21\uffff";
    static final String DFA5_minS =
        "\1\7\1\30\3\uffff\2\7\1\31\1\22\1\26\7\uffff";
    static final String DFA5_maxS =
        "\1\25\1\30\3\uffff\2\7\1\45\1\23\1\27\7\uffff";
    static final String DFA5_acceptS =
        "\2\uffff\1\3\1\4\1\5\5\uffff\1\10\1\2\1\1\1\7\1\6\1\12\1\11";
    static final String DFA5_specialS =
        "\21\uffff}>";
    static final String[] DFA5_transitionS = {
            "\1\1\5\uffff\1\2\1\uffff\1\3\1\4\1\5\3\uffff\1\6",
            "\1\7",
            "",
            "",
            "",
            "\1\10",
            "\1\11",
            "\1\14\11\uffff\1\12\1\uffff\1\13",
            "\1\16\1\15",
            "\1\20\1\17",
            "",
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
            return "192:1: (this_InstanceSpecification_0= ruleInstanceSpecification | this_ExtSubTGraph_1= ruleExtSubTGraph | this_MakeEmf_2= ruleMakeEmf | this_MakeEcore_3= ruleMakeEcore | this_MakeImage_4= ruleMakeImage | this_SimpleEvoSpan_5= ruleSimpleEvoSpan | this_SimpleEvoCospan_6= ruleSimpleEvoCospan | this_Morphism_7= ruleMorphism | this_EvoSpan_8= ruleEvoSpan | this_EvoCospan_9= ruleEvoCospan )";
        }
    }
    static final String DFA15_eotS =
        "\12\uffff";
    static final String DFA15_eofS =
        "\12\uffff";
    static final String DFA15_minS =
        "\1\7\1\40\1\10\1\7\1\40\1\44\1\10\2\uffff\1\44";
    static final String DFA15_maxS =
        "\1\7\1\53\1\10\1\7\1\40\1\53\1\10\2\uffff\1\47";
    static final String DFA15_acceptS =
        "\7\uffff\1\2\1\1\1\uffff";
    static final String DFA15_specialS =
        "\12\uffff}>";
    static final String[] DFA15_transitionS = {
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

    static final short[] DFA15_eot = DFA.unpackEncodedString(DFA15_eotS);
    static final short[] DFA15_eof = DFA.unpackEncodedString(DFA15_eofS);
    static final char[] DFA15_min = DFA.unpackEncodedStringToUnsignedChars(DFA15_minS);
    static final char[] DFA15_max = DFA.unpackEncodedStringToUnsignedChars(DFA15_maxS);
    static final short[] DFA15_accept = DFA.unpackEncodedString(DFA15_acceptS);
    static final short[] DFA15_special = DFA.unpackEncodedString(DFA15_specialS);
    static final short[][] DFA15_transition;

    static {
        int numStates = DFA15_transitionS.length;
        DFA15_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA15_transition[i] = DFA.unpackEncodedString(DFA15_transitionS[i]);
        }
    }

    class DFA15 extends DFA {

        public DFA15(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 15;
            this.eot = DFA15_eot;
            this.eof = DFA15_eof;
            this.min = DFA15_min;
            this.max = DFA15_max;
            this.accept = DFA15_accept;
            this.special = DFA15_special;
            this.transition = DFA15_transition;
        }
        public String getDescription() {
            return "1792:1: (this_MappingNode_0= ruleMappingNode | this_MappingArrow_1= ruleMappingArrow )";
        }
    }
    static final String DFA18_eotS =
        "\12\uffff";
    static final String DFA18_eofS =
        "\12\uffff";
    static final String DFA18_minS =
        "\1\7\1\40\1\10\1\7\1\40\1\24\1\10\2\uffff\1\24";
    static final String DFA18_maxS =
        "\1\7\1\53\1\10\1\7\1\40\1\53\1\10\2\uffff\1\47";
    static final String DFA18_acceptS =
        "\7\uffff\1\2\1\1\1\uffff";
    static final String DFA18_specialS =
        "\12\uffff}>";
    static final String[] DFA18_transitionS = {
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
            return "2143:1: ( (this_Node_0= ruleNode otherlv_1= ',' ) | (this_Arrows_2= ruleArrows otherlv_3= ',' ) )";
        }
    }
    static final String DFA19_eotS =
        "\32\uffff";
    static final String DFA19_eofS =
        "\26\uffff\1\16\2\uffff\1\16";
    static final String DFA19_minS =
        "\1\7\1\40\1\10\1\7\1\40\1\47\1\10\1\7\1\47\1\40\1\10\1\7\1\40\1"+
        "\23\1\uffff\1\10\1\7\1\23\1\40\1\10\1\7\1\40\1\24\1\10\1\uffff\1"+
        "\24";
    static final String DFA19_maxS =
        "\1\7\1\53\1\10\1\7\1\40\1\53\1\10\1\7\1\47\1\53\1\10\1\50\1\40\1"+
        "\53\1\uffff\1\10\1\51\1\23\1\53\1\10\1\7\1\40\1\53\1\10\1\uffff"+
        "\1\47";
    static final String DFA19_acceptS =
        "\16\uffff\1\2\11\uffff\1\1\1\uffff";
    static final String DFA19_specialS =
        "\32\uffff}>";
    static final String[] DFA19_transitionS = {
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
            "\1\15\40\uffff\1\16",
            "\1\13",
            "\1\20\27\uffff\1\17",
            "",
            "\1\21",
            "\1\22\41\uffff\1\16",
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
            return "2191:1: ( ( ( (lv_sr_0_0= ruleNode ) ) otherlv_1= '-' ( (lv_id_2_0= ruleDpfId ) ) otherlv_3= ':' ( (lv_type_4_0= ruleDpfId ) ) otherlv_5= '->' ( (lv_next_6_0= ruleArrows ) ) ) | this_Arrow_7= ruleArrow )";
        }
    }
    static final String DFA20_eotS =
        "\24\uffff";
    static final String DFA20_eofS =
        "\24\uffff";
    static final String DFA20_minS =
        "\1\7\1\40\1\10\1\7\1\40\1\47\1\10\1\7\1\47\1\40\1\10\1\7\1\40\1"+
        "\23\1\uffff\1\10\1\7\1\23\2\uffff";
    static final String DFA20_maxS =
        "\1\7\1\53\1\10\1\7\1\40\1\53\1\10\1\7\1\47\1\53\1\10\1\50\1\40\1"+
        "\53\1\uffff\1\10\1\51\1\23\2\uffff";
    static final String DFA20_acceptS =
        "\16\uffff\1\1\3\uffff\1\3\1\2";
    static final String DFA20_specialS =
        "\24\uffff}>";
    static final String[] DFA20_transitionS = {
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
            "\1\15\40\uffff\1\16",
            "\1\13",
            "\1\20\27\uffff\1\17",
            "",
            "\1\21",
            "\1\22\41\uffff\1\23",
            "\1\20",
            "",
            ""
    };

    static final short[] DFA20_eot = DFA.unpackEncodedString(DFA20_eotS);
    static final short[] DFA20_eof = DFA.unpackEncodedString(DFA20_eofS);
    static final char[] DFA20_min = DFA.unpackEncodedStringToUnsignedChars(DFA20_minS);
    static final char[] DFA20_max = DFA.unpackEncodedStringToUnsignedChars(DFA20_maxS);
    static final short[] DFA20_accept = DFA.unpackEncodedString(DFA20_acceptS);
    static final short[] DFA20_special = DFA.unpackEncodedString(DFA20_specialS);
    static final short[][] DFA20_transition;

    static {
        int numStates = DFA20_transitionS.length;
        DFA20_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA20_transition[i] = DFA.unpackEncodedString(DFA20_transitionS[i]);
        }
    }

    class DFA20 extends DFA {

        public DFA20(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 20;
            this.eot = DFA20_eot;
            this.eof = DFA20_eof;
            this.min = DFA20_min;
            this.max = DFA20_max;
            this.accept = DFA20_accept;
            this.special = DFA20_special;
            this.transition = DFA20_transition;
        }
        public String getDescription() {
            return "2306:1: ( ( ( (lv_sr_0_0= ruleNode ) ) otherlv_1= '-' ( (lv_id_2_0= ruleDpfId ) ) otherlv_3= ':' otherlv_4= '*' otherlv_5= '->' ( (lv_tgDataType_6_0= ruleDataType ) ) ) | ( ( (lv_sr_7_0= ruleNode ) ) otherlv_8= '-' ( (lv_id_9_0= ruleDpfId ) ) otherlv_10= ':' ( (lv_type_11_0= ruleDpfId ) ) otherlv_12= '->' ( (lv_tgValue_13_0= ruleAttributeValue ) ) ) | ( ( (lv_sr_14_0= ruleNode ) ) otherlv_15= '-' ( (lv_id_16_0= ruleDpfId ) ) otherlv_17= ':' ( (lv_type_18_0= ruleDpfId ) ) otherlv_19= '->' ( (lv_tgNode_20_0= ruleNode ) ) ) )";
        }
    }
 

    public static final BitSet FOLLOW_ruleModel_in_entryRuleModel75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModel85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSpecification_in_ruleModel132 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCommand_in_ruleModel159 = new BitSet(new long[]{0x000000000023A082L});
    public static final BitSet FOLLOW_ruleCommand_in_ruleModel180 = new BitSet(new long[]{0x000000000023A082L});
    public static final BitSet FOLLOW_ruleVALUE_in_entryRuleVALUE220 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVALUE231 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NUMBER_in_ruleVALUE271 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_CHAR_in_ruleVALUE297 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleVALUE323 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCommand_in_entryRuleCommand368 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCommand378 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInstanceSpecification_in_ruleCommand425 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExtSubTGraph_in_ruleCommand452 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMakeEmf_in_ruleCommand479 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMakeEcore_in_ruleCommand506 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMakeImage_in_ruleCommand533 = new BitSet(new long[]{0x0000000000000002L});
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
    public static final BitSet FOLLOW_ruleInstanceSpecification_in_entryRuleInstanceSpecification1862 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInstanceSpecification1872 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleInstanceSpecification1914 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleInstanceSpecification1931 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_ruleInstanceSpecification1943 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_ruleInstanceSpecification1955 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ruleChoosenSpecfication_in_ruleInstanceSpecification1976 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleInstanceSpecification1988 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ruleChoosenSpecfication_in_ruleInstanceSpecification2009 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_ruleInstanceSpecification2021 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_ruleInstanceSpecification2033 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ruleConstraintSemantic_in_ruleInstanceSpecification2055 = new BitSet(new long[]{0x0000000020100000L});
    public static final BitSet FOLLOW_20_in_ruleInstanceSpecification2068 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ruleConstraintSemantic_in_ruleInstanceSpecification2089 = new BitSet(new long[]{0x0000000020100000L});
    public static final BitSet FOLLOW_29_in_ruleInstanceSpecification2104 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleChoosenSpecfication_in_entryRuleChoosenSpecfication2140 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleChoosenSpecfication2150 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleChoosenSpecfication2191 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConstraintSemantic_in_entryRuleConstraintSemantic2231 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConstraintSemantic2241 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDpfId_in_ruleConstraintSemantic2287 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_ruleConstraintSemantic2299 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ruleArrows_in_ruleConstraintSemantic2321 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleConstraintSemantic2334 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ruleArrows_in_ruleConstraintSemantic2355 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleConstraintSemantic2370 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_ruleConstraintSemantic2382 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_ruleConstraintSemantic2394 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleConstraintSemantic2411 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSpecification_in_entryRuleSpecification2452 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSpecification2462 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_ruleSpecification2499 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_ruleSpecification2511 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ruleChoosenSpecification_in_ruleSpecification2532 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_ruleSpecification2544 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleSpecification2561 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_ruleSpecification2578 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_ruleSpecification2590 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_ruleGraph_in_ruleSpecification2611 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_ruleSpecification2623 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_ruleSpecification2635 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ruleChoosenConstraintSemantic_in_ruleSpecification2656 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_ruleSpecification2668 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_ruleSpecification2680 = new BitSet(new long[]{0x0000000020000080L});
    public static final BitSet FOLLOW_ruleConstraint_in_ruleSpecification2702 = new BitSet(new long[]{0x0000000020100000L});
    public static final BitSet FOLLOW_20_in_ruleSpecification2715 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ruleConstraint_in_ruleSpecification2736 = new BitSet(new long[]{0x0000000020100000L});
    public static final BitSet FOLLOW_29_in_ruleSpecification2752 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_ruleSpecification2764 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleChoosenSpecification_in_entryRuleChoosenSpecification2800 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleChoosenSpecification2810 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleChoosenSpecification2851 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleChoosenConstraintSemantic_in_entryRuleChoosenConstraintSemantic2891 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleChoosenConstraintSemantic2901 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleChoosenConstraintSemantic2942 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConstraint_in_entryRuleConstraint2982 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConstraint2992 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConstraintSignature_in_ruleConstraint3038 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_ruleConstraint3050 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ruleArrows_in_ruleConstraint3072 = new BitSet(new long[]{0x0000000020100000L});
    public static final BitSet FOLLOW_20_in_ruleConstraint3085 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ruleArrows_in_ruleConstraint3106 = new BitSet(new long[]{0x0000000020100000L});
    public static final BitSet FOLLOW_29_in_ruleConstraint3121 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConstraintSignature_in_entryRuleConstraintSignature3157 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConstraintSignature3167 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDpfId_in_ruleConstraintSignature3213 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_ruleConstraintSignature3225 = new BitSet(new long[]{0x0000000000004080L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleConstraintSignature3243 = new BitSet(new long[]{0x0000000000104000L});
    public static final BitSet FOLLOW_20_in_ruleConstraintSignature3261 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleConstraintSignature3278 = new BitSet(new long[]{0x0000000000104000L});
    public static final BitSet FOLLOW_14_in_ruleConstraintSignature3299 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMorphism_in_entryRuleMorphism3335 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMorphism3345 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleMorphism3381 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleMorphism3392 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_ruleMorphism3404 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_ruleMorphism3416 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ruleDomain_in_ruleMorphism3437 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleMorphism3449 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ruleCodomain_in_ruleMorphism3470 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_ruleMorphism3482 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_ruleMorphism3494 = new BitSet(new long[]{0x0000000020000080L});
    public static final BitSet FOLLOW_ruleMapping_in_ruleMorphism3516 = new BitSet(new long[]{0x0000000020100000L});
    public static final BitSet FOLLOW_20_in_ruleMorphism3529 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ruleMapping_in_ruleMorphism3550 = new BitSet(new long[]{0x0000000020100000L});
    public static final BitSet FOLLOW_29_in_ruleMorphism3566 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDomain_in_entryRuleDomain3602 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDomain3612 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDomain3653 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCodomain_in_entryRuleCodomain3693 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCodomain3703 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleCodomain3744 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMapping_in_entryRuleMapping3784 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMapping3794 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMappingNode_in_ruleMapping3841 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMappingArrow_in_ruleMapping3868 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMappingNode_in_entryRuleMappingNode3903 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMappingNode3913 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNode_in_ruleMappingNode3959 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_ruleMappingNode3971 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ruleNode_in_ruleMappingNode3992 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMappingArrow_in_entryRuleMappingArrow4028 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMappingArrow4038 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArrow_in_ruleMappingArrow4084 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_ruleMappingArrow4096 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ruleArrow_in_ruleMappingArrow4117 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExtSubTGraph_in_entryRuleExtSubTGraph4153 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExtSubTGraph4163 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleExtSubTGraph4205 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleExtSubTGraph4222 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_37_in_ruleExtSubTGraph4234 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_ruleExtSubTGraph4246 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ruleChoosenExtSubTGraph_in_ruleExtSubTGraph4267 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_ruleExtSubTGraph4279 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_ruleExtSubTGraph4291 = new BitSet(new long[]{0x0000000020000080L});
    public static final BitSet FOLLOW_ruleElement_in_ruleExtSubTGraph4312 = new BitSet(new long[]{0x0000000020000080L});
    public static final BitSet FOLLOW_29_in_ruleExtSubTGraph4325 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleChoosenExtSubTGraph_in_entryRuleChoosenExtSubTGraph4361 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleChoosenExtSubTGraph4371 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleChoosenExtSubTGraph4412 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGraph_in_entryRuleGraph4452 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleGraph4462 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_ruleGraph4499 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_ruleGraph4511 = new BitSet(new long[]{0x0000000020000080L});
    public static final BitSet FOLLOW_ruleElement_in_ruleGraph4532 = new BitSet(new long[]{0x0000000020000080L});
    public static final BitSet FOLLOW_29_in_ruleGraph4545 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleElement_in_entryRuleElement4581 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleElement4591 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNode_in_ruleElement4639 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleElement4650 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArrows_in_ruleElement4680 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleElement4691 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArrows_in_entryRuleArrows4728 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleArrows4738 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNode_in_ruleArrows4785 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_ruleArrows4797 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ruleDpfId_in_ruleArrows4818 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_ruleArrows4830 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ruleDpfId_in_ruleArrows4851 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleArrows4863 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ruleArrows_in_ruleArrows4884 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArrow_in_ruleArrows4913 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArrow_in_entryRuleArrow4948 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleArrow4958 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNode_in_ruleArrow5005 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_ruleArrow5017 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ruleDpfId_in_ruleArrow5038 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_ruleArrow5050 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_ruleArrow5062 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleArrow5074 = new BitSet(new long[]{0x001FF00000000000L});
    public static final BitSet FOLLOW_ruleDataType_in_ruleArrow5095 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNode_in_ruleArrow5124 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_ruleArrow5136 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ruleDpfId_in_ruleArrow5157 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_ruleArrow5169 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ruleDpfId_in_ruleArrow5190 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleArrow5202 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_ruleAttributeValue_in_ruleArrow5223 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNode_in_ruleArrow5252 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_ruleArrow5264 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ruleDpfId_in_ruleArrow5285 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_ruleArrow5297 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ruleDpfId_in_ruleArrow5318 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleArrow5330 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ruleNode_in_ruleArrow5351 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNode_in_entryRuleNode5388 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNode5398 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDpfId_in_ruleNode5444 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_ruleNode5456 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ruleDpfId_in_ruleNode5477 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAttributeValue_in_entryRuleAttributeValue5513 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAttributeValue5523 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_ruleAttributeValue5560 = new BitSet(new long[]{0x0000000000000070L});
    public static final BitSet FOLLOW_ruleVALUE_in_ruleAttributeValue5581 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_ruleAttributeValue5593 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDpfId_in_entryRuleDpfId5629 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDpfId5639 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDpfId5681 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_43_in_ruleDpfId5699 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleDpfId5716 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_ruleDataType5773 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_ruleDataType5790 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_ruleDataType5807 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_ruleDataType5824 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_ruleDataType5841 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_ruleDataType5858 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_ruleDataType5875 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_ruleDataType5892 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_ruleDataType5909 = new BitSet(new long[]{0x0000000000000002L});

}