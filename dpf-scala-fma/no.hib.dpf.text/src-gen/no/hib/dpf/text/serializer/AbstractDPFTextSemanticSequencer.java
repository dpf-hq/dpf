package no.hib.dpf.text.serializer;

import com.google.inject.Inject;
import com.google.inject.Provider;
import no.hib.dpf.text.services.DPFTextGrammarAccess;
import no.hib.dpf.text.tdpf.Arrow;
import no.hib.dpf.text.tdpf.Arrows;
import no.hib.dpf.text.tdpf.AttributeValue;
import no.hib.dpf.text.tdpf.ChoosenExtSubTGraph;
import no.hib.dpf.text.tdpf.ChoosenGraph;
import no.hib.dpf.text.tdpf.ChoosenSpecfication;
import no.hib.dpf.text.tdpf.ChoosenTGraph;
import no.hib.dpf.text.tdpf.Codomain;
import no.hib.dpf.text.tdpf.Constraint;
import no.hib.dpf.text.tdpf.ConstraintSemantic;
import no.hib.dpf.text.tdpf.ConstraintSignature;
import no.hib.dpf.text.tdpf.Domain;
import no.hib.dpf.text.tdpf.DpfId;
import no.hib.dpf.text.tdpf.EvoCospan;
import no.hib.dpf.text.tdpf.EvoSpan;
import no.hib.dpf.text.tdpf.ExtSubTGraph;
import no.hib.dpf.text.tdpf.InstanceSpecification;
import no.hib.dpf.text.tdpf.MakeEcore;
import no.hib.dpf.text.tdpf.MakeEmf;
import no.hib.dpf.text.tdpf.MakeImage;
import no.hib.dpf.text.tdpf.MappingArrow;
import no.hib.dpf.text.tdpf.MappingNode;
import no.hib.dpf.text.tdpf.Model;
import no.hib.dpf.text.tdpf.Morphism;
import no.hib.dpf.text.tdpf.Node;
import no.hib.dpf.text.tdpf.SimpleEvoCospan;
import no.hib.dpf.text.tdpf.SimpleEvoSpan;
import no.hib.dpf.text.tdpf.Specification;
import no.hib.dpf.text.tdpf.TGraph;
import no.hib.dpf.text.tdpf.TdpfPackage;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.serializer.acceptor.ISemanticSequenceAcceptor;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.diagnostic.ISemanticSequencerDiagnosticProvider;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor;
import org.eclipse.xtext.serializer.sequencer.AbstractSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.GenericSequencer;
import org.eclipse.xtext.serializer.sequencer.ISemanticNodeProvider.INodesForEObjectProvider;
import org.eclipse.xtext.serializer.sequencer.ISemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;

@SuppressWarnings("restriction")
public class AbstractDPFTextSemanticSequencer extends AbstractSemanticSequencer {

	@Inject
	protected DPFTextGrammarAccess grammarAccess;
	
	@Inject
	protected ISemanticSequencerDiagnosticProvider diagnosticProvider;
	
	@Inject
	protected ITransientValueService transientValues;
	
	@Inject
	@GenericSequencer
	protected Provider<ISemanticSequencer> genericSequencerProvider;
	
	protected ISemanticSequencer genericSequencer;
	
	
	@Override
	public void init(ISemanticSequencer sequencer, ISemanticSequenceAcceptor sequenceAcceptor, Acceptor errorAcceptor) {
		super.init(sequencer, sequenceAcceptor, errorAcceptor);
		this.genericSequencer = genericSequencerProvider.get();
		this.genericSequencer.init(sequencer, sequenceAcceptor, errorAcceptor);
	}
	
	public void createSequence(EObject context, EObject semanticObject) {
		if(semanticObject.eClass().getEPackage() == TdpfPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case TdpfPackage.ARROW:
				if(context == grammarAccess.getArrowRule() ||
				   context == grammarAccess.getArrowsRule() ||
				   context == grammarAccess.getElementRule()) {
					sequence_Arrow(context, (Arrow) semanticObject); 
					return; 
				}
				else break;
			case TdpfPackage.ARROWS:
				if(context == grammarAccess.getArrowsRule() ||
				   context == grammarAccess.getElementRule()) {
					sequence_Arrows(context, (Arrows) semanticObject); 
					return; 
				}
				else break;
			case TdpfPackage.ATTRIBUTE_VALUE:
				if(context == grammarAccess.getAttributeValueRule()) {
					sequence_AttributeValue(context, (AttributeValue) semanticObject); 
					return; 
				}
				else break;
			case TdpfPackage.CHOOSEN_EXT_SUB_TGRAPH:
				if(context == grammarAccess.getChoosenExtSubTGraphRule()) {
					sequence_ChoosenExtSubTGraph(context, (ChoosenExtSubTGraph) semanticObject); 
					return; 
				}
				else break;
			case TdpfPackage.CHOOSEN_GRAPH:
				if(context == grammarAccess.getChoosenGraphRule()) {
					sequence_ChoosenGraph(context, (ChoosenGraph) semanticObject); 
					return; 
				}
				else break;
			case TdpfPackage.CHOOSEN_SPECFICATION:
				if(context == grammarAccess.getChoosenSpecficationRule()) {
					sequence_ChoosenSpecfication(context, (ChoosenSpecfication) semanticObject); 
					return; 
				}
				else break;
			case TdpfPackage.CHOOSEN_TGRAPH:
				if(context == grammarAccess.getChoosenTGraphRule()) {
					sequence_ChoosenTGraph(context, (ChoosenTGraph) semanticObject); 
					return; 
				}
				else break;
			case TdpfPackage.CODOMAIN:
				if(context == grammarAccess.getCodomainRule()) {
					sequence_Codomain(context, (Codomain) semanticObject); 
					return; 
				}
				else break;
			case TdpfPackage.CONSTRAINT:
				if(context == grammarAccess.getConstraintRule()) {
					sequence_Constraint(context, (Constraint) semanticObject); 
					return; 
				}
				else break;
			case TdpfPackage.CONSTRAINT_SEMANTIC:
				if(context == grammarAccess.getConstraintSemanticRule()) {
					sequence_ConstraintSemantic(context, (ConstraintSemantic) semanticObject); 
					return; 
				}
				else break;
			case TdpfPackage.CONSTRAINT_SIGNATURE:
				if(context == grammarAccess.getConstraintSignatureRule()) {
					sequence_ConstraintSignature(context, (ConstraintSignature) semanticObject); 
					return; 
				}
				else break;
			case TdpfPackage.DOMAIN:
				if(context == grammarAccess.getDomainRule()) {
					sequence_Domain(context, (Domain) semanticObject); 
					return; 
				}
				else break;
			case TdpfPackage.DPF_ID:
				if(context == grammarAccess.getDpfIdRule()) {
					sequence_DpfId(context, (DpfId) semanticObject); 
					return; 
				}
				else break;
			case TdpfPackage.EVO_COSPAN:
				if(context == grammarAccess.getDefinitionRule() ||
				   context == grammarAccess.getEvoCospanRule()) {
					sequence_EvoCospan(context, (EvoCospan) semanticObject); 
					return; 
				}
				else break;
			case TdpfPackage.EVO_SPAN:
				if(context == grammarAccess.getDefinitionRule() ||
				   context == grammarAccess.getEvoSpanRule()) {
					sequence_EvoSpan(context, (EvoSpan) semanticObject); 
					return; 
				}
				else break;
			case TdpfPackage.EXT_SUB_TGRAPH:
				if(context == grammarAccess.getDefinitionRule() ||
				   context == grammarAccess.getExtSubTGraphRule()) {
					sequence_ExtSubTGraph(context, (ExtSubTGraph) semanticObject); 
					return; 
				}
				else break;
			case TdpfPackage.INSTANCE_SPECIFICATION:
				if(context == grammarAccess.getDefinitionRule() ||
				   context == grammarAccess.getInstanceSpecificationRule()) {
					sequence_InstanceSpecification(context, (InstanceSpecification) semanticObject); 
					return; 
				}
				else break;
			case TdpfPackage.MAKE_ECORE:
				if(context == grammarAccess.getDefinitionRule() ||
				   context == grammarAccess.getMakeEcoreRule()) {
					sequence_MakeEcore(context, (MakeEcore) semanticObject); 
					return; 
				}
				else break;
			case TdpfPackage.MAKE_EMF:
				if(context == grammarAccess.getDefinitionRule() ||
				   context == grammarAccess.getMakeEmfRule()) {
					sequence_MakeEmf(context, (MakeEmf) semanticObject); 
					return; 
				}
				else break;
			case TdpfPackage.MAKE_IMAGE:
				if(context == grammarAccess.getDefinitionRule() ||
				   context == grammarAccess.getMakeImageRule()) {
					sequence_MakeImage(context, (MakeImage) semanticObject); 
					return; 
				}
				else break;
			case TdpfPackage.MAPPING_ARROW:
				if(context == grammarAccess.getMappingRule() ||
				   context == grammarAccess.getMappingArrowRule()) {
					sequence_MappingArrow(context, (MappingArrow) semanticObject); 
					return; 
				}
				else break;
			case TdpfPackage.MAPPING_NODE:
				if(context == grammarAccess.getMappingRule() ||
				   context == grammarAccess.getMappingNodeRule()) {
					sequence_MappingNode(context, (MappingNode) semanticObject); 
					return; 
				}
				else break;
			case TdpfPackage.MODEL:
				if(context == grammarAccess.getModelRule()) {
					sequence_Model(context, (Model) semanticObject); 
					return; 
				}
				else break;
			case TdpfPackage.MORPHISM:
				if(context == grammarAccess.getDefinitionRule() ||
				   context == grammarAccess.getMorphismRule()) {
					sequence_Morphism(context, (Morphism) semanticObject); 
					return; 
				}
				else break;
			case TdpfPackage.NODE:
				if(context == grammarAccess.getElementRule() ||
				   context == grammarAccess.getNodeRule()) {
					sequence_Node(context, (Node) semanticObject); 
					return; 
				}
				else break;
			case TdpfPackage.SIMPLE_EVO_COSPAN:
				if(context == grammarAccess.getDefinitionRule() ||
				   context == grammarAccess.getSimpleEvoCospanRule()) {
					sequence_SimpleEvoCospan(context, (SimpleEvoCospan) semanticObject); 
					return; 
				}
				else break;
			case TdpfPackage.SIMPLE_EVO_SPAN:
				if(context == grammarAccess.getDefinitionRule() ||
				   context == grammarAccess.getSimpleEvoSpanRule()) {
					sequence_SimpleEvoSpan(context, (SimpleEvoSpan) semanticObject); 
					return; 
				}
				else break;
			case TdpfPackage.SPECIFICATION:
				if(context == grammarAccess.getDefinitionRule() ||
				   context == grammarAccess.getSpecificationRule()) {
					sequence_Specification(context, (Specification) semanticObject); 
					return; 
				}
				else break;
			case TdpfPackage.TGRAPH:
				if(context == grammarAccess.getDefinitionRule() ||
				   context == grammarAccess.getTGraphRule()) {
					sequence_TGraph(context, (TGraph) semanticObject); 
					return; 
				}
				else break;
			}
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     ((sr=Node id=DpfId tgDataType=DataType) | (sr=Node id=DpfId type=DpfId tgValue=AttributeValue) | (sr=Node id=DpfId type=DpfId tgNode=Node))
	 *
	 * Features:
	 *    id[0, 3]
	 *    type[0, 2]
	 *         EXCLUDE_IF_SET sr
	 *         EXCLUDE_IF_SET id
	 *         EXCLUDE_IF_SET tgDataType
	 *    sr[0, 3]
	 *    tgDataType[0, 1]
	 *         EXCLUDE_IF_UNSET sr
	 *         MANDATORY_IF_SET sr
	 *         EXCLUDE_IF_UNSET id
	 *         MANDATORY_IF_SET id
	 *         EXCLUDE_IF_SET sr
	 *         EXCLUDE_IF_SET id
	 *         EXCLUDE_IF_SET type
	 *         EXCLUDE_IF_SET tgValue
	 *         EXCLUDE_IF_SET sr
	 *         EXCLUDE_IF_SET id
	 *         EXCLUDE_IF_SET type
	 *         EXCLUDE_IF_SET tgNode
	 *    tgValue[0, 1]
	 *         EXCLUDE_IF_UNSET sr
	 *         MANDATORY_IF_SET sr
	 *         EXCLUDE_IF_UNSET id
	 *         MANDATORY_IF_SET id
	 *         EXCLUDE_IF_UNSET type
	 *         MANDATORY_IF_SET type
	 *         EXCLUDE_IF_SET sr
	 *         EXCLUDE_IF_SET id
	 *         EXCLUDE_IF_SET tgDataType
	 *         EXCLUDE_IF_SET sr
	 *         EXCLUDE_IF_SET id
	 *         EXCLUDE_IF_SET type
	 *         EXCLUDE_IF_SET tgNode
	 *    tgNode[0, 1]
	 *         EXCLUDE_IF_UNSET sr
	 *         MANDATORY_IF_SET sr
	 *         EXCLUDE_IF_UNSET id
	 *         MANDATORY_IF_SET id
	 *         EXCLUDE_IF_UNSET type
	 *         MANDATORY_IF_SET type
	 *         EXCLUDE_IF_SET sr
	 *         EXCLUDE_IF_SET id
	 *         EXCLUDE_IF_SET tgDataType
	 *         EXCLUDE_IF_SET sr
	 *         EXCLUDE_IF_SET id
	 *         EXCLUDE_IF_SET type
	 *         EXCLUDE_IF_SET tgValue
	 */
	protected void sequence_Arrow(EObject context, Arrow semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (sr=Node id=DpfId type=DpfId next=Arrows)
	 *
	 * Features:
	 *    id[1, 1]
	 *    type[1, 1]
	 *    sr[1, 1]
	 *    next[1, 1]
	 */
	protected void sequence_Arrows(EObject context, Arrows semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, TdpfPackage.Literals.ELEMENT__ID) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, TdpfPackage.Literals.ELEMENT__ID));
			if(transientValues.isValueTransient(semanticObject, TdpfPackage.Literals.ELEMENT__TYPE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, TdpfPackage.Literals.ELEMENT__TYPE));
			if(transientValues.isValueTransient(semanticObject, TdpfPackage.Literals.ARROWS__SR) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, TdpfPackage.Literals.ARROWS__SR));
			if(transientValues.isValueTransient(semanticObject, TdpfPackage.Literals.ARROWS__NEXT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, TdpfPackage.Literals.ARROWS__NEXT));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getArrowsAccess().getSrNodeParserRuleCall_0_0_0(), semanticObject.getSr());
		feeder.accept(grammarAccess.getArrowsAccess().getIdDpfIdParserRuleCall_0_2_0(), semanticObject.getId());
		feeder.accept(grammarAccess.getArrowsAccess().getTypeDpfIdParserRuleCall_0_4_0(), semanticObject.getType());
		feeder.accept(grammarAccess.getArrowsAccess().getNextArrowsParserRuleCall_0_6_0(), semanticObject.getNext());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     value=VALUE
	 *
	 * Features:
	 *    value[1, 1]
	 */
	protected void sequence_AttributeValue(EObject context, AttributeValue semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, TdpfPackage.Literals.ATTRIBUTE_VALUE__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, TdpfPackage.Literals.ATTRIBUTE_VALUE__VALUE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getAttributeValueAccess().getValueVALUEParserRuleCall_1_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     id=ID
	 *
	 * Features:
	 *    id[1, 1]
	 */
	protected void sequence_ChoosenExtSubTGraph(EObject context, ChoosenExtSubTGraph semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, TdpfPackage.Literals.CHOOSEN_EXT_SUB_TGRAPH__ID) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, TdpfPackage.Literals.CHOOSEN_EXT_SUB_TGRAPH__ID));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getChoosenExtSubTGraphAccess().getIdIDTerminalRuleCall_0(), semanticObject.getId());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     id=ID
	 *
	 * Features:
	 *    id[1, 1]
	 */
	protected void sequence_ChoosenGraph(EObject context, ChoosenGraph semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, TdpfPackage.Literals.CHOOSEN_GRAPH__ID) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, TdpfPackage.Literals.CHOOSEN_GRAPH__ID));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getChoosenGraphAccess().getIdIDTerminalRuleCall_0(), semanticObject.getId());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     id=ID
	 *
	 * Features:
	 *    id[1, 1]
	 */
	protected void sequence_ChoosenSpecfication(EObject context, ChoosenSpecfication semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, TdpfPackage.Literals.CHOOSEN_SPECFICATION__ID) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, TdpfPackage.Literals.CHOOSEN_SPECFICATION__ID));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getChoosenSpecficationAccess().getIdIDTerminalRuleCall_0(), semanticObject.getId());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     id=ID
	 *
	 * Features:
	 *    id[1, 1]
	 */
	protected void sequence_ChoosenTGraph(EObject context, ChoosenTGraph semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, TdpfPackage.Literals.CHOOSEN_TGRAPH__ID) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, TdpfPackage.Literals.CHOOSEN_TGRAPH__ID));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getChoosenTGraphAccess().getIdIDTerminalRuleCall_0(), semanticObject.getId());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     id=ID
	 *
	 * Features:
	 *    id[1, 1]
	 */
	protected void sequence_Codomain(EObject context, Codomain semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, TdpfPackage.Literals.CODOMAIN__ID) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, TdpfPackage.Literals.CODOMAIN__ID));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getCodomainAccess().getIdIDTerminalRuleCall_0(), semanticObject.getId());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (id=DpfId arrows+=Arrows arrows+=Arrows* ocl=STRING)
	 *
	 * Features:
	 *    id[1, 1]
	 *    arrows[1, *]
	 *    ocl[1, 1]
	 */
	protected void sequence_ConstraintSemantic(EObject context, ConstraintSemantic semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (id=DpfId (parameter+=ID parameter+=ID*)?)
	 *
	 * Features:
	 *    id[1, 1]
	 *    parameter[0, *]
	 */
	protected void sequence_ConstraintSignature(EObject context, ConstraintSignature semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (signature=ConstraintSignature arrows+=Arrows arrows+=Arrows*)
	 *
	 * Features:
	 *    signature[1, 1]
	 *    arrows[1, *]
	 */
	protected void sequence_Constraint(EObject context, Constraint semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     id=ID
	 *
	 * Features:
	 *    id[1, 1]
	 */
	protected void sequence_Domain(EObject context, Domain semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, TdpfPackage.Literals.DOMAIN__ID) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, TdpfPackage.Literals.DOMAIN__ID));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getDomainAccess().getIdIDTerminalRuleCall_0(), semanticObject.getId());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID id=INT?)
	 *
	 * Features:
	 *    name[1, 1]
	 *    id[0, 1]
	 */
	protected void sequence_DpfId(EObject context, DpfId semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (lhs=ID rhs=ID typeGraph=ID)
	 *
	 * Features:
	 *    lhs[1, 1]
	 *    rhs[1, 1]
	 *    typeGraph[1, 1]
	 */
	protected void sequence_EvoCospan(EObject context, EvoCospan semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, TdpfPackage.Literals.EVO_COSPAN__LHS) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, TdpfPackage.Literals.EVO_COSPAN__LHS));
			if(transientValues.isValueTransient(semanticObject, TdpfPackage.Literals.EVO_COSPAN__RHS) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, TdpfPackage.Literals.EVO_COSPAN__RHS));
			if(transientValues.isValueTransient(semanticObject, TdpfPackage.Literals.EVO_COSPAN__TYPE_GRAPH) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, TdpfPackage.Literals.EVO_COSPAN__TYPE_GRAPH));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getEvoCospanAccess().getLhsIDTerminalRuleCall_1_0(), semanticObject.getLhs());
		feeder.accept(grammarAccess.getEvoCospanAccess().getRhsIDTerminalRuleCall_3_0(), semanticObject.getRhs());
		feeder.accept(grammarAccess.getEvoCospanAccess().getTypeGraphIDTerminalRuleCall_5_0(), semanticObject.getTypeGraph());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (lhs=ID rhs=ID typeGraph=ID)
	 *
	 * Features:
	 *    lhs[1, 1]
	 *    rhs[1, 1]
	 *    typeGraph[1, 1]
	 */
	protected void sequence_EvoSpan(EObject context, EvoSpan semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, TdpfPackage.Literals.EVO_SPAN__LHS) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, TdpfPackage.Literals.EVO_SPAN__LHS));
			if(transientValues.isValueTransient(semanticObject, TdpfPackage.Literals.EVO_SPAN__RHS) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, TdpfPackage.Literals.EVO_SPAN__RHS));
			if(transientValues.isValueTransient(semanticObject, TdpfPackage.Literals.EVO_SPAN__TYPE_GRAPH) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, TdpfPackage.Literals.EVO_SPAN__TYPE_GRAPH));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getEvoSpanAccess().getLhsIDTerminalRuleCall_1_0(), semanticObject.getLhs());
		feeder.accept(grammarAccess.getEvoSpanAccess().getRhsIDTerminalRuleCall_3_0(), semanticObject.getRhs());
		feeder.accept(grammarAccess.getEvoSpanAccess().getTypeGraphIDTerminalRuleCall_5_0(), semanticObject.getTypeGraph());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (id=ID extendsGraph=ChoosenExtSubTGraph elements+=Element*)
	 *
	 * Features:
	 *    id[1, 1]
	 *    extendsGraph[1, 1]
	 *    elements[0, *]
	 */
	protected void sequence_ExtSubTGraph(EObject context, ExtSubTGraph semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (id=ID model=ChoosenSpecfication metamodel=ChoosenSpecfication constraintSemantics+=ConstraintSemantic constraintSemantics+=ConstraintSemantic*)
	 *
	 * Features:
	 *    id[1, 1]
	 *    model[1, 1]
	 *    metamodel[1, 1]
	 *    constraintSemantics[1, *]
	 */
	protected void sequence_InstanceSpecification(EObject context, InstanceSpecification semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     id=ID
	 *
	 * Features:
	 *    id[1, 1]
	 */
	protected void sequence_MakeEcore(EObject context, MakeEcore semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, TdpfPackage.Literals.MAKE_ECORE__ID) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, TdpfPackage.Literals.MAKE_ECORE__ID));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getMakeEcoreAccess().getIdIDTerminalRuleCall_1_0(), semanticObject.getId());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     id=ID
	 *
	 * Features:
	 *    id[1, 1]
	 */
	protected void sequence_MakeEmf(EObject context, MakeEmf semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, TdpfPackage.Literals.MAKE_EMF__ID) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, TdpfPackage.Literals.MAKE_EMF__ID));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getMakeEmfAccess().getIdIDTerminalRuleCall_1_0(), semanticObject.getId());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     id=ID
	 *
	 * Features:
	 *    id[1, 1]
	 */
	protected void sequence_MakeImage(EObject context, MakeImage semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, TdpfPackage.Literals.MAKE_IMAGE__ID) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, TdpfPackage.Literals.MAKE_IMAGE__ID));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getMakeImageAccess().getIdIDTerminalRuleCall_1_0(), semanticObject.getId());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (domain=Arrow codmain=Arrow)
	 *
	 * Features:
	 *    domain[1, 1]
	 *    codmain[1, 1]
	 */
	protected void sequence_MappingArrow(EObject context, MappingArrow semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, TdpfPackage.Literals.MAPPING_ARROW__DOMAIN) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, TdpfPackage.Literals.MAPPING_ARROW__DOMAIN));
			if(transientValues.isValueTransient(semanticObject, TdpfPackage.Literals.MAPPING_ARROW__CODMAIN) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, TdpfPackage.Literals.MAPPING_ARROW__CODMAIN));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getMappingArrowAccess().getDomainArrowParserRuleCall_0_0(), semanticObject.getDomain());
		feeder.accept(grammarAccess.getMappingArrowAccess().getCodmainArrowParserRuleCall_2_0(), semanticObject.getCodmain());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (domain=Node codomain=Node)
	 *
	 * Features:
	 *    domain[1, 1]
	 *    codomain[1, 1]
	 */
	protected void sequence_MappingNode(EObject context, MappingNode semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, TdpfPackage.Literals.MAPPING_NODE__DOMAIN) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, TdpfPackage.Literals.MAPPING_NODE__DOMAIN));
			if(transientValues.isValueTransient(semanticObject, TdpfPackage.Literals.MAPPING_NODE__CODOMAIN) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, TdpfPackage.Literals.MAPPING_NODE__CODOMAIN));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getMappingNodeAccess().getDomainNodeParserRuleCall_0_0(), semanticObject.getDomain());
		feeder.accept(grammarAccess.getMappingNodeAccess().getCodomainNodeParserRuleCall_2_0(), semanticObject.getCodomain());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (definitions+=Definition definitions+=Definition*)?
	 *
	 * Features:
	 *    definitions[0, *]
	 */
	protected void sequence_Model(EObject context, Model semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (domain=Domain codmain=Codomain (mappings+=Mapping mappings+=Mapping*)?)
	 *
	 * Features:
	 *    domain[1, 1]
	 *    codmain[1, 1]
	 *    mappings[0, *]
	 */
	protected void sequence_Morphism(EObject context, Morphism semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (id=DpfId type=DpfId)
	 *
	 * Features:
	 *    id[1, 1]
	 *    type[1, 1]
	 */
	protected void sequence_Node(EObject context, Node semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, TdpfPackage.Literals.ELEMENT__ID) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, TdpfPackage.Literals.ELEMENT__ID));
			if(transientValues.isValueTransient(semanticObject, TdpfPackage.Literals.ELEMENT__TYPE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, TdpfPackage.Literals.ELEMENT__TYPE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getNodeAccess().getIdDpfIdParserRuleCall_0_0(), semanticObject.getId());
		feeder.accept(grammarAccess.getNodeAccess().getTypeDpfIdParserRuleCall_2_0(), semanticObject.getType());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (lhs=ID joint=ID rhs=ID typeGraph=ID)
	 *
	 * Features:
	 *    lhs[1, 1]
	 *    joint[1, 1]
	 *    rhs[1, 1]
	 *    typeGraph[1, 1]
	 */
	protected void sequence_SimpleEvoCospan(EObject context, SimpleEvoCospan semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, TdpfPackage.Literals.SIMPLE_EVO_COSPAN__LHS) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, TdpfPackage.Literals.SIMPLE_EVO_COSPAN__LHS));
			if(transientValues.isValueTransient(semanticObject, TdpfPackage.Literals.SIMPLE_EVO_COSPAN__JOINT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, TdpfPackage.Literals.SIMPLE_EVO_COSPAN__JOINT));
			if(transientValues.isValueTransient(semanticObject, TdpfPackage.Literals.SIMPLE_EVO_COSPAN__RHS) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, TdpfPackage.Literals.SIMPLE_EVO_COSPAN__RHS));
			if(transientValues.isValueTransient(semanticObject, TdpfPackage.Literals.SIMPLE_EVO_COSPAN__TYPE_GRAPH) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, TdpfPackage.Literals.SIMPLE_EVO_COSPAN__TYPE_GRAPH));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getSimpleEvoCospanAccess().getLhsIDTerminalRuleCall_1_0(), semanticObject.getLhs());
		feeder.accept(grammarAccess.getSimpleEvoCospanAccess().getJointIDTerminalRuleCall_3_0(), semanticObject.getJoint());
		feeder.accept(grammarAccess.getSimpleEvoCospanAccess().getRhsIDTerminalRuleCall_5_0(), semanticObject.getRhs());
		feeder.accept(grammarAccess.getSimpleEvoCospanAccess().getTypeGraphIDTerminalRuleCall_7_0(), semanticObject.getTypeGraph());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (lhs=ID diff=ID rhS=ID typeGraph=ID)
	 *
	 * Features:
	 *    lhs[1, 1]
	 *    diff[1, 1]
	 *    rhS[1, 1]
	 *    typeGraph[1, 1]
	 */
	protected void sequence_SimpleEvoSpan(EObject context, SimpleEvoSpan semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, TdpfPackage.Literals.SIMPLE_EVO_SPAN__LHS) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, TdpfPackage.Literals.SIMPLE_EVO_SPAN__LHS));
			if(transientValues.isValueTransient(semanticObject, TdpfPackage.Literals.SIMPLE_EVO_SPAN__DIFF) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, TdpfPackage.Literals.SIMPLE_EVO_SPAN__DIFF));
			if(transientValues.isValueTransient(semanticObject, TdpfPackage.Literals.SIMPLE_EVO_SPAN__RH_S) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, TdpfPackage.Literals.SIMPLE_EVO_SPAN__RH_S));
			if(transientValues.isValueTransient(semanticObject, TdpfPackage.Literals.SIMPLE_EVO_SPAN__TYPE_GRAPH) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, TdpfPackage.Literals.SIMPLE_EVO_SPAN__TYPE_GRAPH));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getSimpleEvoSpanAccess().getLhsIDTerminalRuleCall_1_0(), semanticObject.getLhs());
		feeder.accept(grammarAccess.getSimpleEvoSpanAccess().getDiffIDTerminalRuleCall_3_0(), semanticObject.getDiff());
		feeder.accept(grammarAccess.getSimpleEvoSpanAccess().getRhSIDTerminalRuleCall_5_0(), semanticObject.getRhS());
		feeder.accept(grammarAccess.getSimpleEvoSpanAccess().getTypeGraphIDTerminalRuleCall_7_0(), semanticObject.getTypeGraph());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (id=ID graph=ChoosenGraph (constraints+=Constraint constraints+=Constraint*)?)
	 *
	 * Features:
	 *    id[1, 1]
	 *    graph[1, 1]
	 *    constraints[0, *]
	 */
	protected void sequence_Specification(EObject context, Specification semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (id=ID typeGraph=ChoosenTGraph elements+=Element*)
	 *
	 * Features:
	 *    id[1, 1]
	 *    typeGraph[1, 1]
	 *    elements[0, *]
	 */
	protected void sequence_TGraph(EObject context, TGraph semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
}
