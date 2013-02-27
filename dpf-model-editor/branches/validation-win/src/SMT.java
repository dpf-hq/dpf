import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class SMT {

	public static final String INN = "INN";
	public static final String OUT = "OUT";
	public static final String VINN = "V-INN";
	public static final String VOUT = "V-OUT";
	public static final String EINN = "E-INN";
	public static final String EOUT = "E-OUT";
	private List<Rule> rules = new ArrayList<Rule>();
	public void translate(){
		PrintWriter writer = null;
		try {
			writer = new PrintWriter(new File(name + ".smt2"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		writer.println("(set-option :produce-models true)");
		writer.println(";(set-option :produce-proofs true)");
		writer.println("(set-option :model-compact false)");
		writer.println("(set-option :produce-unsat-cores true)");
		writer.println("(set-option :pull-nested-quantifiers true)");
		writer.println("(set-option :mbqi true)");
		writer.println("");
		writer.println("(declare-sort " + VINN + ")    ; un" + VINN + "erpreted ");
		writer.println("(declare-sort " + EINN + ")    ; un" + VINN + "erpreted ");
		writer.println("(declare-sort " + VOUT + ")    ; un" + VOUT + "erpreted ");
		writer.println("(declare-sort " + EOUT + ")    ; un" + VOUT + "erpreted ");
		writer.println("");
		writer.println("; Source and target model type declaration");
		translateVertexType(writer, sVertex, VINN, "");
		translateEdgeType(writer, sEdges, VINN, EINN, "");
		translateVertexType(writer, tVertex, VOUT, "");
		translateEdgeType(writer, tEdges, VOUT, EOUT, "");
		writer.println(";Assistant functions");
		writer.print("(define-fun NNullVI ((a " + VINN + ")) Bool ");
		visitAnArray(writer, sVertex, "(", " a)", "(or", " ", ")", 0, sVertex.length - 2);
		writer.println(")");
		writer.print("(define-fun NNullEI ((a " + VINN + ") (b " + VINN + ") (c " + EINN + ")) Bool ");
		visitAnArray(writer, sEdges, "(", " a b c)", "(or", " ", ")", 0, sVertex.length - 2);
		writer.println(")");
		writer.println("(define-fun ValidVI ((a " + VINN + ")) Bool (or (NNullVI a) (VI a)))"); 
		writer.println("(define-fun ValidEI ((a " + VINN + ") (b " + VINN + ") (c " + EINN + ")) Bool (or (NNullEI a b c) (NEI a b c)))");
		writer.print("(define-fun NNullVO ((a " + VOUT + ")) Bool ");
		visitAnArray(writer, tVertex, "(", " a)", "(or", " ", ")", 0, tVertex.length - 2);
		writer.println(")");
		writer.print("(define-fun NNullEO ((a " + VOUT + ") (b " + VOUT + ") (c " + EOUT + ")) Bool ");
		visitAnArray(writer, tEdges, "(", " a b c)", "(or", " ", ")", 0, tVertex.length - 2);
		writer.println(")");
		writer.println("(define-fun ValidVO ((a " + VOUT + ")) Bool (or (NNullVO a) (VO a)))"); 
		writer.println("(define-fun ValidEO ((a " + VOUT + ") (b " + VOUT + ") (c " + EOUT + ")) Bool (or (NNullEO a b c) (NEO a b c)))");
		writer.println("");
		writer.println(";Source and target model type constraint");
		writer.println(";Each element in the instance could be typed by only one element in the metamodel");
		writer.println(nodeIncompatiable(sVertex, true));
		writer.println(edgeIncompatiable(sEdges, true));
		writer.println(nodeIncompatiable(tVertex, false));
		writer.println(edgeIncompatiable(tEdges, false));
		writer.println("");
		List<String[]> SourceNullEdges = new ArrayList<String[]>();
		for(Rule rule : rules){
			rule.getRuleNullEdge(SourceNullEdges, true);
		}
		List<String[]> targetNullEdges = new ArrayList<String[]>();
		for(Rule rule : rules){
			rule.getRuleNullEdge(targetNullEdges, false);
		}
		writer.println(";Any NullEdge only comes and goes to those nodes");
		writer.println(getNullEdges(SourceNullEdges, true));
		writer.println(getNullEdges(targetNullEdges, false));
		writer.println("(assert (! (forall ((a V-OUT) (b V-OUT) (c E-OUT) (d V-OUT) (e V-OUT) (f E-OUT)) " +
				"(=> (and (NEO a b c) (NEO d e f)) (= c f))) :named only-one-NEO-exists))");
		writer.println("(assert (! (forall ((a V-INN) (b V-INN) (c E-INN) (d V-INN) (e V-INN) (f E-INN)) " +
				"(=> (and (NEI a b c) (NEI d e f)) (= c f))) :named only-one-NEI-exists))");
		writer.println("");
		writer.println(";Any edge comes in or goes out an invalid node is invalid");
		writer.println("(assert (! (forall ((a V-INN) (b V-INN) (c E-INN)) (=> (not (ValidVI a)) (and (not (ValidEI a b c)) (not (ValidEI b a c))))) :named source-untyped-node-edge-undefined))");
		writer.println("(assert (! (forall ((a V-OUT) (b V-OUT) (c E-OUT)) (=> (not (ValidVO a)) (and (not (ValidEO a b c)) (not (ValidEO b a c))))) :named target-untyped-node-edge-undefined))");
		writer.println("");
		writer.println(";Any edge comes in or goes out an null node is null");
		writer.println("(assert (! (forall ((s V-INN) (t V-INN) (e E-INN)) (=> (VI s) (and (=> (ValidEI s t e) (NEI s t e)) (=> (ValidEI t s e) (NEI t s e))))) :named VI-null-incoming-null-outing))");
		writer.println("(assert (! (forall ((s V-OUT) (t V-OUT) (e E-OUT)) (=> (VO s) (and (=> (ValidEO s t e) (NEO s t e)) (=> (ValidEO t s e) (NEO t s e))))) :named VO-null-incoming-null-outing))");
		writer.println("");
		writer.println(";Source and target information of an edge in metamodel should well kept in the instance level");
		writer.println(sourceAndTarget(sEdges, true));
		writer.println(sourceAndTarget(tEdges, false));
		writer.println("");
		writer.println(";If edge (s, t, e) is an valid edge, then other combination (s', t', e) are invalid");
		writer.println(edgeExclusive(sEdges, true));
		writer.println(edgeExclusive(tEdges, false));
		writer.println("");
		writer.println(";Only one Null Node exists in instance level");
		writer.println("(assert (! (forall ((s " + VINN + ") (t " + VINN + ")) (or (= s t) (not (and (VI s) (VI t))))) :named Source-only-one-null-node-allowed))");
		writer.println("(assert (! (forall ((s " + VOUT + ") (t " + VOUT + ")) (or (= s t) (not (and (VO s) (VO t))))) :named Target-only-one-null-node-allowed))");
		writer.println("(assert (! (forall ((s " + VINN + ") (t " + VINN + ") (e " + EINN + ") (e1 " + EINN + ")) (or (= e e1) (not (and (NEI s t e) (NEI s t e1))))) :named Source-only-one-null-edge-allowed))");
		writer.println("(assert (! (forall ((s " + VOUT + ") (t " + VOUT + ") (e " + EOUT + ") (e1 " + EOUT + ")) (or (= e e1) (not (and (NEO s t e) (NEO s t e1))))) :named Target-only-one-null-edge-allowed))");
		writer.println("");
		writer.println(";encoding of Add and Del function");
		writer.println("(declare-datatypes () ((InnTuple (inn-tuple (s " + VINN + ") (t " + VINN + ") (e " + EINN + ")))))");
		writer.println("(declare-datatypes () ((OutTuple (out-tuple (s " + VOUT + ") (t " + VOUT + ") (e " + EOUT + ")))))");
		writer.println("(declare-fun addV (" + VOUT + ") " + VINN + ")");
		writer.println("(declare-fun delV (" + VINN + ") " + VOUT + ")");
		writer.println("(declare-fun addE (" + VOUT + " " + VOUT + " " + EOUT + ") InnTuple)");
		writer.println("(declare-fun delE (" + VINN + " " + VINN + " " + EINN + ") OutTuple)");

		writer.println("");
		writer.println(";graph morphism");
//		writer.println("(assert (! (forall ((a V-INN) (b V-OUT) (t V-INN) (e E-INN)) (=> (and (= (delV a) b) (ValidVI a)) " +
//				"(and (=> (ValidEI a t e) (exists ((t1 V-OUT) (e1 E-OUT)) (= (delE a t e) (out-tuple b t1 e1)))) " +
//				"(=> (ValidEI t a e) (exists ((t1 V-OUT) (e1 E-OUT)) (= (delE t a e) (out-tuple t1 b e1))))))) :named node-del-edge-del))"); 
//		writer.println("(assert (! (forall ((a V-OUT) (b V-INN) (t V-OUT) (e E-OUT)) (=> (and (= (addV a) b) (ValidVO a)) " +
//				"(and (=> (ValidEO a t e) (exists ((t1 V-INN) (e1 E-INN)) (= (addE a t e) (inn-tuple b t1 e1)))) " +
//				"(=> (ValidEO t a e) (exists ((t1 V-INN) (e1 E-INN)) (= (addE t a e) (inn-tuple t1 b e1))))))) :named node-add-edge-add))");
		writer.println("(assert (! (forall ((a " + VINN + ") (b " + VINN + ") (c " + EINN + ") (d " + VOUT + ") (e " + VOUT + ") (f " + EOUT + ")) " +
				"(=> (and (ValidEO d e f) (= (addE d e f) (inn-tuple a b c))) (and (= (addV d) a) (= (addV e) b)))) :named add-graph-morphism))");
		writer.println("(assert (! (forall ((a " + VINN + ") (b " + VINN + ") (c " + EINN + ") (d " + VOUT + ") (e " + VOUT + ") (f " + EOUT + ")) " +
				"(=> (and (ValidEI a b c) (= (delE a b c) (out-tuple d e f))) (and (= (delV a) d) (= (delV b) e)))) :named del-graph-morphism))");
		

		writer.println("");
		writer.println(";Invalid elements and Null elements are changed into Null elements");
		writer.println("(assert (! (forall ((a " + VINN + ") (b " + VOUT + ")) (=> (and (or (not (ValidVI a)) (VI a)) (= (delV a) b)) (VO b))) :named Null-Inn-Or-Invalid-Node-Null-Out-Deled))");
		writer.println("(assert (! (forall ((a " + VOUT + ") (b " + VINN + ")) (=> (and (or (not (ValidVO a)) (VO a)) (= (addV a) b)) (VI b))) :named Null-Out-Or-Invalid-Node-Null-Inn-Added))");
		writer.println("(assert (! (forall ((a " + VINN + ") (b " + VINN + ") (c " + EINN + ") (d " + VOUT + ") (e " + VOUT + ") (f " + EOUT + ")) " +
				"(=> (and (not (ValidEI a b c)) (= (delE a b c) (out-tuple d e f))) (and (= d e) (and (VO d) (NEO d e f))))) :named Invalid-Edge-Null-Out-Edge-Deled))");
		writer.println("(assert (! (forall ((a " + VOUT + ") (b " + VOUT + ") (c " + EOUT + ") (d " + VINN + ") (e " + VINN + ") (f " + EINN + ")) " +
				"(=> (and (not (ValidEO a b c)) (= (addE a b c) (inn-tuple d e f))) (and (= d e) (and (VI d) (NEI d e f))))) :named Invalid-Edge-Null-Inn-Edge-Added))");
		writer.println("(assert (! (forall ((a " + VOUT + ") (b " + VOUT + ") (c " + EOUT + ") (d " + VINN + ") (e " + VINN + ") (f " + EINN + ")) " +
				"(=> (and (NEO a b c) (= (addE a b c) (inn-tuple d e f))) (NEI d e f))) :named Null-Out-Edge-Null-Inn-Edge-Added))");
		writer.println("(assert (! (forall ((a " + VINN + ") (b " + VINN + ") (c " + EINN + ") (d " + VOUT + ") (e " + VOUT + ") (f " + EOUT + ")) " +
				"(=> (and (NEI a b c) (= (delE a b c) (out-tuple d e f))) (NEO d e f))) :named Null-Inn-Edge-Null-Out-Edge-Deled))");

		writer.println("");
		writer.println(";Commond part for each transformation are well kept");
//		writer.println("(assert (! (forall ((a " + VOUT + ") (b " + VOUT + ") (c " + EOUT + ") (d " + VINN + ") (e " + VINN + ") (f " + EINN + ")) " +
//				"(=> (and (ValidEI d e f) (and (ValidEO a b c) (= (addE a b c) (inn-tuple d e f)))) (and (= (addV a) d) (= (addV b) e)))) :named Add-Source-Target-Kept))");
//		writer.println("(assert (! (forall ((a " + VINN + ") (b " + VINN + ") (c " + EINN + ") (d " + VOUT + ") (e " + VOUT + ") (f " + EOUT + ")) " +
//				"(=> (and (ValidEI a b c) (and (ValidEO d e f) (= (delE a b c) (out-tuple d e f)))) (and (= (delV a) d) (= (delV b) e)))) :named Del-Source-Target-Kept))");
		writer.println("(assert (! (forall ((a " + VINN + ") (b " + VOUT + ")) (=> (and (and (NNullVI a) (NNullVO b)) (= (delV a) b)) (= (addV b) a))) :named common-node-del-bi))");
		writer.println("(assert (! (forall ((a " + VINN + ") (b " + VOUT + ")) (=> (and (and (NNullVI a) (NNullVO b)) (= (addV b) a)) (= (delV a) b))) :named common-node-add-bi))");
		writer.println("(assert (! (forall ((a " + VINN + ") (b " + VINN + ") (c " + EINN + ") (d " + VOUT + ") (e " + VOUT + ") (f " + EOUT + ")) " +
				"(=> (and (and (NNullEI a b c) (NNullEO d e f)) (= (delE a b c) (out-tuple d e f))) (= (addE d e f) (inn-tuple a b c)))) :named common-edge-del-bi))");
		writer.println("(assert (! (forall ((a " + VINN + ") (b " + VINN + ") (c " + EINN + ") (d " + VOUT + ") (e " + VOUT + ") (f " + EOUT + ")) " +
				"(=> (and (and (NNullEO d e f) (NNullEI a b c)) (= (addE d e f) (inn-tuple a b c))) (= (delE a b c) (out-tuple d e f)))) :named common-edge-add-bi))");
		writer.println("");
		writer.println(";the type of commond elements are well kept");
		writer.println("(assert (! (forall ((a " + VINN + ") (b " + VOUT + ")) (=> (and (and (NNullVI a) (NNullVO b)) (= (delV a) b))");
		for (int i = 0; i < sVertex.length - 2; i++) {
			writer.print(" (and");
		}
		for (int i = 0; i < sVertex.length - 1; i++) {
			writer.print(" (and (=> (" + sVertex[i] + " a) (" + tVertex[i] + " b)) (=> (" + tVertex[i] + " b) (" + sVertex[i] + " a)))");
			if(i != 0)
				writer.println(")");
		}
		writer.println(")) :named type-del-kept))");
		writer.println("(assert (! (forall ((a " + VINN + ") (b " + VOUT + ")) (=> (and (and (NNullVI a) (NNullVO b)) (= (addV b) a))");
		for (int i = 0; i < sVertex.length - 2; i++) {
			writer.print(" (and");
		}
		for (int i = 0; i < sVertex.length - 1; i++) {
			writer.print(" (and (=> (" + sVertex[i] + " a) (" + tVertex[i] + " b)) (=> (" + tVertex[i] + " b) (" + sVertex[i] + " a)))");
			if(i != 0)
				writer.println(")");
		}
		writer.println(")) :named type-add-kept))");

		writer.println("(assert (! (forall ((a " + VINN + ") (b " + VINN + ") (c " + EINN + ") (d " + VOUT + ") (e " + VOUT + ") (f " + EOUT + ")) (=> (and (and (NNullEI a b c) (NNullEO d e f)) (= (delE a b c) (out-tuple d e f)))");
		for (int i = 0; i < sEdges.length - 2; i++) {
			writer.print(" (and");
		}
		for (int i = 0; i < sEdges.length - 1; i++) {
			writer.print(" (and (=> (" + sEdges[i][0] + " a b c) (" + tEdges[i][0] + " d e f)) (=> (" + tEdges[i][0] + " d e f) (" + sEdges[i][0] + " a b c)))");
			if(i != 0)
				writer.println(")");
		}
		writer.println(")) :named edge-type-del-kept))");
		writer.println("(assert (! (forall ((a " + VINN + ") (b " + VINN + ") (c " + EINN + ") (d " + VOUT + ") (e " + VOUT + ") (f " + EOUT + ")) (=> (and (and (NNullEO d e f) (NNullEI a b c)) (= (addE d e f) (inn-tuple a b c)))");
		for (int i = 0; i < sEdges.length - 2; i++) {
			writer.print(" (and");
		}
		for (int i = 0; i < sEdges.length - 1; i++) {
			writer.print(" (and (=> (" + sEdges[i][0] + " a b c) (" + tEdges[i][0] + " d e f)) (=> (" + tEdges[i][0] + " d e f) (" + sEdges[i][0] + " a b c)))");
			if(i != 0)
				writer.println(")");
		}
		writer.println(")) :named edge-type-add-kept))");

		writer.println("");
		writer.println(";common elements are mapped injectively");
		writer.println("(assert (! (forall ((a " + VINN + ") (b " + VOUT + ") (c " + VOUT + ")) " +
				"(=> (and (and (NNullVO b) (NNullVO c)) (and (= (addV b) a) (NNullVI a))) (or (= c b) (not (= (addV c) a))))) :named node-add-injective))");
		writer.println("(assert (! (forall ((a " + VINN + ") (b " + VOUT + ") (c " + VINN + ")) " +
				"(=> (and (and (NNullVI a) (NNullVI c)) (and (= (delV a) b) (NNullVO b))) (or (= c a) (not (= (delV c) b))))) :named node-del-injective))");
		writer.println("(assert (! (forall ((a " + VINN + ") (b " + VINN + ") (c " + EINN + ") (d " + VOUT + ") (e " + VOUT + ") (f " + EOUT + ") (h " + VOUT + ") (i " + VOUT + ") (j " + EOUT + ")) " +
				"(=> (and (and (NNullEO d e f) (NNullEO h i j)) (and (= (addE d e f) (inn-tuple a b c)) (NNullEI a b c))) (or (or (= d h) (or (= e i) (= f j))) (not (= (addE h i j) (inn-tuple a b c)))))) :named edge-add-injective))");
		writer.println("(assert (! (forall ((a " + VINN + ") (b " + VINN + ") (c " + EINN + ") (d " + VOUT + ") (e " + VOUT + ") (f " + EOUT + ") (h " + VINN + ") (i " + VINN + ") (j " + EINN + ")) " +
				"(=> (and (and (NNullEI a b c) (NNullEI h i j)) (and (= (delE a b c) (out-tuple d e f)) (NNullEO d e f))) (or (or (= a h) (or (= b i) (= c j))) (not (= (delE h i j) (out-tuple d e f)))))) :named edge-del-injective))");
		writer.println("");
		writer.println(";Each valid elements in the target model should hava a preimage for del");
		writer.println(";Each valid elements in the source model should hava a preimage for add");
		writer.println("(assert (! (forall ((a " + VOUT + ")) (=> (NNullVO a) (exists ((b " + VINN + ")) (and (NNullVI b) (= a (delV b)))))) :named del-surjective-for-NotNull-node-in-target))");
		writer.println("(assert (! (forall ((a " + VINN + ")) (=> (NNullVI a) (exists ((b " + VOUT + ")) (and (NNullVO b) (= a (addV b)))))) :named add-surjective-for-NotNull-node-in-source))");
		writer.println("(assert (! (forall ((a " + VINN + ") (b " + VINN + ") (c " + EINN + ")) " +
				"(=> (NNullEI a b c) (exists ((d " + VOUT + ") (e " + VOUT + ") (f " + EOUT + ")) (and (NNullEO d e f) (= (addE d e f) (inn-tuple a b c)))))) :named add-surjective-for-NotNull-edge-in-source))");
		writer.println("(assert (! (forall ((a " + VOUT + ") (b " + VOUT + ") (c " + EOUT + ")) " +
				"(=> (NNullEO a b c) (exists ((d " + VINN + ") (e " + VINN + ") (f " + EINN + ")) (and (NNullEI d e f) (= (delE d e f) (out-tuple a b c)))))) :named del-surjective-for-NotNull-edge-in-target))");

//		writer.println("");
//		writer.println(";Each valid elements in the source model should hava an image for del");
//		writer.println(";Each valid elements in the target model should hava an image for add");
//		writer.println("(assert (! (forall ((a " + VINN + ")) (=> (ValidVI a) (exists ((b " + VOUT + ")) (and (ValidVO b) (= b (delV a)))))) :named each-valid-node-in-source-is-deled))");
//		writer.println("(assert (! (forall ((a " + VOUT + ")) (=> (ValidVO a) (exists ((b " + VINN + ")) (and (ValidVI b) (= b (addV a)))))) :named each-valid-node-in-target-is-added))");
//		writer.println("(assert (! (forall ((a " + VINN + ") (b " + VINN + ") (c " + EINN + ")) " +
//				"(=> (ValidEI a b c) (exists ((d " + VOUT + ") (e " + VOUT + ") (f " + EOUT + ")) (and (ValidEO d e f) (= (delE a b c) (out-tuple d e f)))))) :named each-valid-edge-in-source-is-deled))");
//		writer.println("(assert (! (forall ((a " + VOUT + ") (b " + VOUT + ") (c " + EOUT + ")) " +
//				"(=> (ValidEO a b c) (exists ((d " + VINN + ") (e " + VINN + ") (f " + EINN + ")) (and (ValidEI d e f) (= (addE a b c) (inn-tuple d e f)))))) :named each-valid-edge-in-target-is-added))");
		
		writer.println("");
		writer.println(";Each invalid elements in the target model should hava no preimage for del");
		writer.println(";Each invalid elements in the source model should hava no preimage for add");
		writer.println("(assert (! (forall ((t V-OUT)) (=> (not (ValidVO t)) (not (exists ((s V-INN)) (= (delV s) t))))) :named no-invalid-node-in-source-has-pre-image-in-del))");
		writer.println("(assert (! (forall ((s V-INN)) (=> (not (ValidVI s)) (not (exists ((t V-OUT)) (= (addV t) s))))) :named no-invalid-node-in-target-has-pre-image-in-add))");
		writer.println("(assert (! (forall ((s V-OUT) (t V-OUT) (e E-OUT)) (=> (not (ValidEO s t e)) (not (exists ((a V-INN) (b V-INN) (c E-INN)) (= (delE a b c) (out-tuple s t e)))))) :named no-invalid-edge-in-source-has-pre-image-in-del))");
		writer.println("(assert (! (forall ((a V-INN) (b V-INN) (c E-INN)) (=> (not (ValidEI a b c)) (not (exists ((s V-OUT) (t V-OUT) (e E-OUT)) (= (addE s t e) (inn-tuple a b c)))))) :named no-invalid-edge-in-target-has-pre-image-in-add))");
		
		writer.println("");
		writer.print("(declare-datatypes () ((RuleID");
		for (Rule iter : rules) {
			writer.print(" id" + iter.name);
		}
		writer.println(")))");
		writer.println("(declare-fun delVID (" + VINN + " RuleID) Bool)");
		writer.println("(declare-fun addVID (" + VOUT + " RuleID) Bool)");
		writer.println("(declare-fun delEID (" + VINN + " " + VINN + " " + EINN + " RuleID) Bool)");
		writer.println("(declare-fun addEID (" + VOUT + " " + VOUT + " " + EOUT + " RuleID) Bool)");
//		writer.println("(assert (! (forall ((a V-INN) (id RuleID)) (=> (delVID a id) (NNullVI a))) :named only-valid-node-deled))");
//		writer.println("(assert (! (forall ((a V-OUT) (id RuleID)) (=> (addVID a id) (NNullVO a))) :named only-valid-node-added))");
//		writer.println("(assert (! (forall ((c E-INN) (id RuleID)) (=> (delEID c id) (exists ((a V-INN) (b V-INN)) (NNullEI a b c)))) :named only-valid-edge-deled))");
//		writer.println("(assert (! (forall ((c E-OUT) (id RuleID)) (=> (addEID c id) (exists ((a V-OUT) (b V-OUT)) (NNullEO a b c)))) :named only-valid-edge-added))");

		
		writer.println("(assert (! (forall ((a V-INN) (id RuleID)) (=> " +
				"(or (not (ValidVI a)) (or (VI a) (and (NNullVI a) (exists ((b V-OUT)) (and (NNullVO b) (= (delV a) b)))))) " +
				"(not (delVID a id)))) " +
				":named del-node-id-false))");
		writer.println("(assert (! (forall ((a V-OUT) (id RuleID)) (=> " +
				"(or (not (ValidVO a)) (or (VO a) (and (NNullVO a) (exists ((b V-INN)) (and (NNullVI b) (= (addV a) b)))))) " +
				"(not (addVID a id)))) " +
				":named add-node-id-false))");
		writer.println("(assert (! (forall ((a V-INN) (b V-INN) (c E-INN) (id RuleID)) (=> " +
				"(or (not (ValidEI a b c)) (or (NEI a b c) (and (NNullEI a b c) (exists ((d V-OUT) (e V-OUT) (f E-OUT)) (and (NNullEO d e f) (= (delE a b c) (out-tuple d e f))))))) " +
				"(not (delEID a b c id)))) " +
				":named del-edge-id-false))");
		writer.println("(assert (! (forall ((a V-OUT) (b V-OUT) (c E-OUT) (id RuleID)) (=> " +
				"(or (not (ValidEO a b c)) (or (NEO a b c) (and (NNullEO a b c) (exists ((d V-INN) (e V-INN) (f E-INN)) (and (NNullEI d e f) (= (addE a b c) (inn-tuple d e f))))))) " +
				"(not (addEID a b c id)))) " +
				":named add-edge-id-false))");
		
		writer.println("(assert (! (forall ((a V-INN)) (=> " +
				"(and (NNullVI a) (exists ((b V-OUT)) (and (VO b) (= (delV a) b)))) " +
				"(exists ((id RuleID)) (delVID a id)))) " +
				":named del-node-id-true))");
		writer.println("(assert (! (forall ((a V-OUT)) (=> " +
				"(and (NNullVO a) (exists ((b V-INN)) (and (VI b) (= (addV a) b)))) " +
				"(exists ((id RuleID)) (addVID a id)))) " +
				":named add-node-id-true))");
		writer.println("(assert (! (forall ((a V-INN) (b V-INN) (c E-INN)) (=> " +
				"(and (NNullEI a b c) (exists ((d V-OUT) (e V-OUT) (f E-OUT)) (and (NEO d e f) (= (delE a b c) (out-tuple d e f))))) " +
				"(exists ((id RuleID)) (delEID a b c id)))) " +
				":named del-edge-id-true))");
		writer.println("(assert (! (forall ((a V-OUT) (b V-OUT) (c E-OUT)) (=> " +
				"(and (NNullEO a b c) (exists ((d V-INN) (e V-INN) (f E-INN)) (and (NEI d e f) (= (addE a b c) (inn-tuple d e f))))) " +
				"(exists ((id RuleID)) (addEID a b c id)))) " +
				":named add-edge-id-true))");
		
		writer.println("(assert (! (forall ((a V-INN) (id RuleID)) (=> " +
				"(not (delVID a id)) " +
				"(or (not (ValidVI a)) (or (VI a) (and (NNullVI a) (exists ((b V-OUT)) (and (NNullVO b) (= (delV a) b)))))))) " +
				":named del-node-id-false-domain))");
		writer.println("(assert (! (forall ((a V-OUT) (id RuleID)) (=> " +
				"(not (addVID a id)) " +
				"(or (not (ValidVO a)) (or (VO a) (and (NNullVO a) (exists ((b V-INN)) (and (NNullVI b) (= (addV a) b)))))))) " +
				":named add-node-id-false-domain))");
		writer.println("(assert (! (forall ((a V-INN) (b V-INN) (c E-INN) (id RuleID)) (=> " +
				"(not (delEID a b c id)) " +
				"(or (not (ValidEI a b c)) (or (NEI a b c) (and (NNullEI a b c) (exists ((d V-OUT) (e V-OUT) (f E-OUT)) (and (NNullEO d e f) (= (delE a b c) (out-tuple d e f))))))))) " +
				":named del-edge-id-false-domain))");
		writer.println("(assert (! (forall ((a V-OUT) (b V-OUT) (c E-OUT) (id RuleID)) (=> " +
				"(not (addEID a b c id)) " +
				"(or (not (ValidEO a b c)) (or (NEO a b c) (and (NNullEO a b c) (exists ((d V-INN) (e V-INN) (f E-INN)) (and (NNullEI d e f) (= (addE a b c) (inn-tuple d e f))))))))) " +
				":named add-edge-id-false-domain))");
		
		writer.println("(assert (! (forall ((a V-INN)) (=> " +
				"(exists ((id RuleID)) (delVID a id)) " +
				"(and (NNullVI a) (exists ((b V-OUT)) (and (VO b) (= (delV a) b)))))) " +
				":named del-node-id-true-domain))");
		writer.println("(assert (! (forall ((a V-OUT)) (=> " +
				"(exists ((id RuleID)) (addVID a id)) " +
				"(and (NNullVO a) (exists ((b V-INN)) (and (VI b) (= (addV a) b)))))) " +
				":named add-node-id-true-domain))");
		writer.println("(assert (! (forall ((a V-INN) (b V-INN) (c E-INN)) (=> " +
				"(exists ((id RuleID)) (delEID a b c id)) " +
				"(and (NNullEI a b c) (exists ((d V-OUT) (e V-OUT) (f E-OUT)) (and (NEO d e f) (= (delE a b c) (out-tuple d e f))))))) " +
				":named del-edge-id-true-domain))");
		writer.println("(assert (! (forall ((a V-OUT) (b V-OUT) (c E-OUT)) (=> " +
				"(exists ((id RuleID)) (addEID a b c id)) " +
				"(and (NNullEO a b c) (exists ((d V-INN) (e V-INN) (f E-INN)) (and (NEI d e f) (= (addE a b c) (inn-tuple d e f))))))) " +
				":named add-edge-id-true-domain))");
		
//		writer.println("(assert (! (forall ((a V-INN) (b V-OUT) (id RuleID)) (=> (and (addVID b id) (= a (addV b))) (VI a))) :named id-node-added))");
//		writer.println("(assert (! (forall ((a V-INN) (b V-OUT) (id RuleID)) (=> (and (delVID a id) (= b (delV a))) (VO b))) :named id-node-deled))");
//		writer.println("(assert (! (forall ((a V-INN) (b V-OUT) (id RuleID)) (=> (and (addVID b id) (= a (addV b))) (VI a))) :named id-node-added))");
//		writer.println("(assert (! (forall ((a V-INN) (b V-INN) (c E-INN) (d V-OUT) (e V-OUT) (f E-OUT) (id RuleID)) " +
//				"(=> (and (delEID c id) (= (out-tuple d e f) (delE a b c))) (NEO d e f))) :named id-edge-deled))"); 
//		writer.println("(assert (! (forall ((a V-INN) (b V-INN) (c E-INN) (d V-OUT) (e V-OUT) (f E-OUT) (id RuleID)) " +
//				"(=> (and (addEID f id) (= (inn-tuple a b c) (addE d e f))) (NEI a b c))) :named id-edge-added))");
								
		writer.println("(assert (! (forall ((a " + VINN + ") (b " + VINN + ") (c " + EINN + ") (id RuleID)) (=> (delVID a id) " +
				"(and (=> (NNullEI a b c) (delEID a b c id)) (=> (NNullEI b a c) (delEID b a c id))))) :named id-node-del-edge-del))");
		writer.println("(assert (! (forall ((a " + VOUT + ") (b " + VOUT + ") (c " + EOUT + ") (id RuleID)) (=> (addVID a id) " +
				"(and (=> (NNullEO a b c) (addEID a b c id)) (=> (NNullEO b a c) (addEID b a c id))))) :named id-node-add-edge-add))");
		
		writer.println(idNodeIncompatiable(rules, true));
		writer.println(idNodeIncompatiable(rules, false));
		writer.println(idEdgeIncompatiable(rules, true));
		writer.println(idEdgeIncompatiable(rules, false));
//		writer.println("(assert (! (forall ((s V-INN)) (=> (and (NNullVI s) (not (exists ((id RuleID)) (delVID s id)))) (exists ((t V-OUT)) (and (= t (delV s)) (NNullVO t))))) :named unmatched-node-del-kept))");
//		writer.println("(assert (! (forall ((s V-OUT)) (=> (and (NNullVO s) (not (exists ((id RuleID)) (addVID s id)))) (exists ((t V-INN)) (and (= t (addV s)) (NNullVI t))))) :named unmatched-node-add-kept))");
//		writer.println("(assert (! (forall ((a V-INN) (b V-INN) (c E-INN)) (=> (and (NNullEI a b c) (not (exists ((id RuleID)) (delEID c id)))) (exists ((d V-OUT) (e V-OUT) (f E-OUT)) (and (= (out-tuple d e f) (delE a b c)) (NNullEO d e f))))) :named unmatched-edge-del-kept))");
//		writer.println("(assert (! (forall ((a V-OUT) (b V-OUT) (c E-OUT)) (=> (and (NNullEO a b c) (not (exists ((id RuleID)) (addEID c id)))) (exists ((d V-INN) (e V-INN) (f E-INN)) (and (= (inn-tuple d e f) (addE a b c)) (NNullEI d e f))))) :named unmatched-edge-add-kept))");

		for(Rule rule : rules){
			rule.printRule(writer);
		}
		writer.println();
		
		writer.println("(assert (! (or (or (or (exists ((a1 V-INN) (b1 V-OUT)) (=> (and (NNullVI a1) (= b1 (delV a1))) (VO b1))) ");
		writer.println("(exists ((a2 V-OUT) (b2 V-INN)) (=> (and (NNullVO a2) (= b2 (addV a2))) (VI b2)))) ");
		writer.println("(exists ((a3 V-INN) (b3 V-INN) (c3 E-INN) (d3 V-OUT) (e3 V-OUT) (f3 E-OUT)) (=> (and (NNullEI a3 b3 c3) (= (out-tuple d3 e3 f3) (delE a3 b3 c3))) (NEO d3 e3 f3)))) ");
		writer.println("(exists ((a4 V-INN) (b4 V-INN) (c4 E-INN) (d4 V-OUT) (e4 V-OUT) (f4 E-OUT)) (=> (and (NNullEO d4 e4 f4) (= (inn-tuple a4 b4 c4) (addE d4 e4 f4))) (NEI a4 b4 c4)))) :named at-least-one-edge-node-is-added-or-deled))");
		writer.println();
		//At least the source model should match one rule
		writer.print("(assert (! ");
		for (int i = 0; i < rules.size() - 1; i++) {
			writer.print(" (or");
		}
		for (int i = 0; i < rules.size(); i++) {
			rules.get(i).printRuleMatch(writer, i);
			if(i > 0)
				writer.print(")");
		}
		
		writer.println(" :named source-model-should-match-at-least-one-rule))");
//		writer.print(";");
		writer.println(reflexiveEdge("non-active", true));
//		writer.print(";");
		writer.println(reflexiveEdge("active", true));
//		writer.print(";");
		writer.println(reflexiveEdge("start", true));
//		writer.print(";");
		writer.println(reflexiveEdge("crit", true));
//		writer.print(";");
		writer.println(reflexiveEdge("check", true));
//		writer.print(";");
		writer.println(reflexiveEdge("setTurn", true));
//		writer.print(";");
		writer.println(uniqueNode("T", true));
//		writer.print(";");
		writer.println(uniqueNode("R", true));
//		writer.print(";");
		writer.println(existNode("T", true));
//		writer.print(";");
		writer.println(existNode("R", true));
//		writer.print(";");
		writer.println(existNode("P", true));
//		writer.print(";");
		writer.println(existEdge("TP", true));
//		writer.print(";");
		writer.println(existOneOfEdges("non-active;active", true));
//		writer.print(";");
		writer.println(existOneOfEdges("start;crit;check;setTurn", true));
//		writer.print(";");
		writer.println(noncompatibleEdge("non-active;active", true));
//		writer.print(";");
		writer.println(noncompatibleEdge("start;crit;check;setTurn", true));
//		writer.print(";");
		writer.println(injective("PF2", true));
//		writer.print(";");
		writer.println(injective("PF1", true));
//		writer.print(";");
		writer.println(injective("TR", true));
//		writer.print(";");
		writer.println(injective("TP", true));
		
//		writer.print(";");
		writer.println(nullOrOne("non-active", true));
//		writer.print(";");
		writer.println(nullOrOne("active", true));
//		writer.print(";");
		writer.println(nullOrOne("start", true));
//		writer.print(";");
		writer.println(nullOrOne("crit", true));
//		writer.print(";");
		writer.println(nullOrOne("check", true));
//		writer.print(";");
		writer.println(nullOrOne("setTurn", true));
//		writer.print(";");
		writer.println(nullOrOne("PF2", true));
//		writer.print(";");
		writer.println(nullOrOne("PF1", true));
//		writer.print(";");
		writer.println(nullOrOne("F1R", true));
//		writer.print(";");
		writer.println(nullOrOne("F2R", true));
//		writer.print(";");
		writer.println(nullOrOne("TP", true));
//		writer.print(";");
		writer.println(surjective("PF2", "F2", true));
//		writer.print(";");
		writer.println(surjective("PF1", "F1", true));
//		writer.print(";");
		writer.println(surjective("TR", "R", true));

		writer.print(";");
		writer.println(existNode("P", false));
		writer.print(";");
		writer.println(existNode("R", false));
		writer.print(";");
		writer.println(existNode("T", false));
		writer.print(";");
		writer.println(uniqueNode("T", false));
		writer.print(";");
		writer.println(uniqueNode("R", false));
		writer.print(";");
		writer.println(existOneOfEdges("non-active;active", false));
		writer.print(";");
		writer.println(existOneOfEdges("start;crit;check;setTurn", false));
		writer.print(";");
		writer.println(noncompatibleEdge("non-active;active", false));
		writer.print(";");
		writer.println(noncompatibleEdge("start;crit;check;setTurn", false));
		writer.print(";");
		writer.println(reflexiveEdge("non-active", false));
		writer.print(";");
		writer.println(reflexiveEdge("active", false));
		writer.print(";");
		writer.println(reflexiveEdge("start", false));
		writer.print(";");
		writer.println(reflexiveEdge("crit", false));
		writer.print(";");
		writer.println(reflexiveEdge("check", false));
		writer.print(";");
		writer.println(reflexiveEdge("setTurn", false));
//		writer.print(";");
		writer.println(injective("PF2", false));
		writer.print(";");
		writer.println(injective("PF1", false));
		writer.println("(check-sat)");
		writer.println("(get-unsat-core)");
		writer.println("(exit)");
		writer.close();
	}
	private String getNullEdges(List<String[]> edges, boolean in) {
		StringBuffer result = new StringBuffer();
		result.append("(assert (! (forall ((a V-" + (in ? INN : OUT) + ") (b V-" + (in ? INN : OUT) + ") (c E-" + (in ? INN : OUT) + ")) (=> (NE" + (in ? "I" : "O") + " a b c) ");
		int size = edges.size();
		for (int i = 0; i < size - 1; i++) {
			result.append(" (or");
		}
		for (int i = 0; i < size; i++) {
			String src = edges.get(i)[0], trg = edges.get(i)[1];
			if(in){
				if(trg.equals("VO"))
					trg = "VI";
				if(src.equals("VO"))
					src = "VI";
			}else{
				if(trg.equals("VI"))
					trg = "VO";
				if(src.equals("VI"))
					src = "VO";
			}
				
			result.append(" (and " + "(" + src  +  " a) (" + trg +  " b))");
			if(i != 0)
				result.append(")");
		}
		result.append(")) :named " + (in ? "Source" : "Target") + "-NullEdge-Source-Target))");
		return result.toString();
	}
	private String existEdge(String a, boolean in) {
		String node = a + (in ? "I" : "O");
		String type = in ? VINN : VOUT;
		return "(assert (! " + (in ? "" : "(not ") + "(exists ((s " + type + ") (t " + type + ") (e " + (in ? EINN : EOUT) + ")) (" + node + " s t e))" + (in ? "" : ")") + " :named exist-edge-" + node + "))";

	}
	public String nullOrOne(String e, boolean in){
		String node = in ? VINN : VOUT;
		String edge = in ? EINN : EOUT;
		return "(assert (! " + (in ? "" : "(not ") + "(forall ((s " + node + ") (t1 " + node + ") (t2 " + node + ") (e1 " + edge + ") (e2 " + edge + ")) (=> (and (" 
		+ e + (in ? "I" : "O") + " s t1 e1) (" + e + (in ? "I" : "O")+ " s t2 e2)) (and (= t1 t2) (= e1 e2))))" + (in ? "" : ")") + " :named multi-0-1-" + e + (in ? "I" : "O") + "))";
	}
	public String injective(String e, boolean in){
		String node = in ? VINN : VOUT;
		String edge = in ? EINN : EOUT;
		return "(assert (! " + (in ? "" : "(not ") + "(forall ((s1 " + node + ") (s2 " + node + ") (t " + node + ") (e1 " + edge + ") (e2 " + edge + ")) (=> (and (" 
		+ e + (in ? "I" : "O") + " s1 t e1) (" + e + (in ? "I" : "O")+ " s2 t e2)) (and (= s1 s2) (= e1 e2))))" + (in ? "" : ")") + " :named injective-" + e + (in ? "I" : "O") + "))";
	}
	public String surjective(String e, String t, boolean in){
		String node = in ? VINN : VOUT;
		String edge = in ? EINN : EOUT;
		return "(assert (! " + (in ? "" : "(not ") + "(forall ((t " + node + ")) (=> (" + t + (in ? "I" : "O") + " t) (exists ((s " + node + ") (e " + edge + ")) (" 
		+ e + (in ? "I" : "O") + " s t e))))" + (in ? "" : ")") + " :named surjective-" + e + (in ? "I" : "O") + "))";
	}

	public String reflexiveEdge(String edge, boolean in){
		String[] e = findEdge(edge, in);
		return "(assert (! " + (in ? "" : "(not ") + "(forall ((s " + (in ? VINN : VOUT) + ") (t "  + (in ? VINN : VOUT) + ") (e "  + (in ? EINN : EOUT) + ")) (=> (" 
		+ e[0] + " s t e) (= s t)))" + (in ? "" : ")") + " :named " + e[0] + "-reflexive))";
	}
	private void visitAnArray(PrintWriter writer, String[] array, String prefix, String suffix, String Prefix, String Infix, String Suffix, int start, int end){
		iterVisitAnArray(writer, array, start, prefix, suffix, Prefix, Infix, Suffix, end);
	}
	private void visitUnit(PrintWriter writer, String[] array, int i, String prefix, String suffix){
		writer.write(prefix);
		writer.write(array[i]);
		writer.write(suffix);
	}
	public String noncompatibleEdge(String edges, boolean in){
		String[] array = edges.split(";");
		String[][] es = new String[array.length][];
		for (int i = 0; i < es.length; i++) {
			es[i] = findEdge(array[i], in);
		}
		String result = "(assert (! " + (in ? "" : "(not");
		result += noncompatibleEdge(es, in ? INN : OUT) + (in ? "" : ")");
		result += " :named ";
		for (int i = 0; i < es.length; i++) {
			result += (es[i][0] + "-");
		}
		return result + "incompatiable))";
	}
	private String[] findEdge(String string, boolean in) {
		String[][] es = in ? this.sEdges : this.tEdges;
		for (int i = 0; i < es.length; i++) {
			if(es[i][0].equals(string + (in ? "I" : "O")))
				return es[i];
		}
		throw new RuntimeException("Cannot find edge" + string);
	}
	public String existOneOfEdges(String edges, boolean in){
		String[] array = edges.split(";");
		String[][] es = new String[array.length][];
		for (int i = 0; i < es.length; i++) {
			es[i] = findEdge(array[i], in);
		}
		String result = "(assert (! " + (in ? "" : "(not") + existOneOfEdges(es, in ? VINN : VOUT, in ? EINN : EOUT) + (in ? "" : ")");
		result += " :named exist-one-of-";
		for (int i = 0; i < es.length; i++) {
			result += es[i][0] + "-";
		}
		result += "edges))";
		return result;
	}
	private String existOneOfEdges(String[][] edges, String node, String edge){
		String result = "";
		for (int i = 0; i < edges.length - 1; i++) {
			result += " (or";
		}
		for (int i = 0; i < edges.length; i++) {
			result += " (exists ((s" + i + " " + node + ") (t" + i + " " + node + ") (e" + i + " " + edge + ")) (" 
					+ edges[i][0] + " s" + i + " t" + i + " e" + i + "))";
			if(i != 0)
				result += ")";
		}
		return result;
	}
	private String noncompatibleEdge(String[][] edges, String in){
		StringBuffer result = new StringBuffer();
		int size = edges.length;
		for (int i = 0; i < edges.length - 1; i++) {
			result.append(" (and");
		}
		for (int i = 0; i < edges.length; i++) {
			result.append(" (not (forall ((a" + i + " V-" + in + ") (b" + i + " V-" + in + ") (c" + i + " E-" + in + ")) (exists ((d" + i 
					+ " V-" + in + ") (e" + i + " V-" + in + ") (f" + i + " E-" + in + ")) (and (and (and (= a" + i + " d" + i + ") (= b" + i + " e" + i + ")) (" + edges[i][0] + " a" + i + " b" + i + " c" + i + "))");
			for(int j = 0; j < size - 2; j++){
				result.append(" (or");
			}
			for(int j = 0; j < size; j++){
				if(i != j){
					result.append(" (" + edges[j][0] + " d" + i + " e" + i + " f" + i + ")");
					if((i == 0 && j > 1) || (i > 0 && j > 0))
						result.append(")");
				}
			}
			result.append("))))");
			if(i != 0)
				result.append(")");
		}
		return result.toString();
	}
	private void iterVisitAnArray(PrintWriter writer, String[] array, int i, String prefix, String suffix, String Prefix, String Infix, String Suffix, int end) {
		if(i == end){
			visitUnit(writer, array, i, prefix, suffix);
			return;
		}
		writer.write(Prefix);
		writer.write(Infix);
		visitUnit(writer, array, i, prefix, suffix);
		writer.write(Infix);
		iterVisitAnArray(writer, array, i + 1, prefix, suffix, Prefix, Infix, Suffix, end);
		writer.write(Suffix);
	}

	private void visitAnArray(PrintWriter writer, String[][] array, String prefix, String suffix, String Prefix, String Infix, String Suffix, int start, int end){
		iterVisitAnArray(writer, array, start, prefix, suffix, Prefix, Infix, Suffix, end);
	}
	private void visitUnit(PrintWriter writer, String[][] array, int i, String prefix, String suffix){
		writer.write(prefix);
		writer.write(array[i][0]);
		writer.write(suffix);
	}
	private void iterVisitAnArray(PrintWriter writer, String[][] array, int i, String prefix, String suffix, String Prefix, String Infix, String Suffix, int end) {
		if(i == end){
			visitUnit(writer, array, i, prefix, suffix);
			return;
		}
		writer.write(Prefix);
		writer.write(Infix);
		visitUnit(writer, array, i, prefix, suffix);
		writer.write(Infix);
		iterVisitAnArray(writer, array, i + 1, prefix, suffix, Prefix, Infix, Suffix, end);
		writer.write(Suffix);
	}
	private void translateVertexType(PrintWriter writer, String[] nodes, String type, String suffix){
		for (int i = 0; i < nodes.length; i++) 
			writer.println("(declare-fun " + nodes[i] + suffix + " (" + type + ") Bool)");
	}
	private void translateEdgeType(PrintWriter writer, String[][] edges, String nodeType, String edgeType, String suffix){
		for (int i = 0; i < edges.length; i++) 
			writer.println("(declare-fun " + edges[i][0] + suffix + " (" + makeSpaceBetweenStrings(nodeType, nodeType, edgeType) + ") Bool)");
	}

	private  String nodeIncompatiable(String[] sVertex, boolean in){
		StringBuffer result = new StringBuffer();
		result.append("(assert (! (forall ((a " + (in ? VINN : VOUT) + "))");
		
		int size = sVertex.length;
		for (int i = 0; i < size - 1; i++) {
			result.append(" (and");
		}
		for (int i = 0; i < size; i++) {
			result.append(" (not (and " + "(" + sVertex[i] +  " a)");
			for(int j = 0; j < size - 2; j++){
				result.append(" (or");
			}
			for(int j = 0; j < size; j++){
				if(i != j){
					result.append(" (" + sVertex[j] +  " a)");
					if((i == 0 && j > 1) || (i > 0 && j > 0))
						result.append(")");
				}
			}
			result.append("))");
			if(i != 0)
				result.append(")");
		}
		result.append(") :named " + (in ? "Source" : "Target") + "-node-incompatiable))");
		return result.toString();
	
	}

	private  String idNodeIncompatiable(List<Rule> rules, boolean in){
		if(rules.size() == 1)
			return "";

		String fname = (in ? "del" : "add") + "VID";
		StringBuffer result = new StringBuffer();
		result.append("(assert (! (forall ((a V-" + (in ? INN : OUT) + "))");
		
		int size = rules.size();
		for (int i = 0; i < size - 1; i++) {
			result.append(" (and");
		}
		for (int i = 0; i < size; i++) {
			result.append(" (not (and " + "(" + fname + " a id" + rules.get(i).name +  ")");
			for(int j = 0; j < size - 2; j++){
				result.append(" (or");
			}
			for(int j = 0; j < size; j++){
				if(i != j){
					result.append(" (" + fname + " a id" + rules.get(j).name +  ")");
					if((i == 0 && j > 1) || (i > 0 && j > 0))
						result.append(")");
				}
			}
			result.append("))");
			if(i != 0)
				result.append(")");
		}
		result.append(") :named " + (in ? "Del" : "Add") + "-node-only-once))");
		return result.toString();
	}
	private  String idEdgeIncompatiable(List<Rule> rules, boolean in){
		if(rules.size() == 1)
			return "";
		
		String fname = (in ? "del" : "add")  + "EID";
		StringBuffer result = new StringBuffer();
		result.append("(assert (! (forall ((a V-" + (in ? INN : OUT) + ") (b V-" + (in ? INN : OUT) + ") (c E-" + (in ? INN : OUT) + "))");
		
		int size = rules.size();
		for (int i = 0; i < size - 1; i++) {
			result.append(" (and");
		}
		for (int i = 0; i < size; i++) {
			result.append(" (not (and " + "(" + fname + " a b c id" + rules.get(i).name +  ")");
			for(int j = 0; j < size - 2; j++){
				result.append(" (or");
			}
			for(int j = 0; j < size; j++){
				if(i != j){
					result.append(" (" + fname + " a b c id" + rules.get(j).name +  ")");
					if((i == 0 && j > 1) || (i > 0 && j > 0))
						result.append(")");
				}
			}
			result.append("))");
			if(i != 0)
				result.append(")");
		}
		result.append(") :named " + (in ? "Del" : "Add") + "-edge-only-once))");
		return result.toString();
	}

	private  String edgeIncompatiable(String[][] edge, boolean in){
		StringBuffer result = new StringBuffer();
		result.append("(assert (! (forall ((s " + (in ? VINN : VOUT) + ") (t " + (in ? VINN : VOUT) + ") (e " + (in ? EINN : EOUT) + "))");
		int size = edge.length;
		for (int i = 0; i < size - 1; i++) {
			result.append(" (and");
		}
		for (int i = 0; i < size; i++) {
			result.append(" (not (and " + "(" + edge[i][0] +  " s t e)");
			for(int j = 0; j < size - 2; j++){
				result.append(" (or");
			}
			for(int j = 0; j < size; j++){
				if(i != j){
					result.append(" (" + edge[j][0] +  " s t e" + ")");
					if((i == 0 && j > 1) || (i > 0 && j > 0))
						result.append(")");
				}
			}
			result.append("))");
			if(i != 0)
				result.append(")");
		}
		result.append(") :named " + (in ? "Source" : "Target") + "-edge-incompatiable))");
		return result.toString();
	}

	public static void main(String[] args) {
		//		SMT smt = new SMT("Source", "A;B;C", "AB:A:B;BC:B:C", "A;B;C", "AB:A:B;BC:B:C");
		//		smt.translate(new PrintWriter(System.out));
		SMT other = new SMT("Mutex", 
				"P;F1;F2;T;R",
				"non-active|P->P;active|P->P;start|P->P;crit|P->P;check|P->P;setTurn|P->P;PF2|P->F2;PF1|P->F1;TP|T->P;F2R|F2->R;F1R|F1->R;TR|T->R");
		other.addRule("setFlag", 
				"1:PI;2:RI;1:PO;2:RO;3:F1O", 
				"1|1->1:non-activeI|PI->PI;2|1->1:startI|PI->PI;3|1->1:activeO|PO->PO;4|1->1:setTurnO|PO->PO;5|1->3:PF1O|PO->F1O;6|3->2:F1RO|F1O->RO");
		other.addRule("setTurn1", 
				"1:PI;1:PO;2:PI;2:PO;3:TI;3:TO;4:RI;4:RO", 
				"1|1->1:non-activeI|PI->PI;1|1->1:non-activeO|PO->PO;2|3->4:TRI|TI->RI;2|3->4:TRO|TO->RO;3|3->1:TPI|TI->PI;4|2->2:setTurnI|PI->PI;5|2->2:checkO|PO->TO;6|3->2:TPO|TO->PO");
		other.addRule("setTurn2", 
				"1:PI;2:TI;3:RI;1:PO;2:TO;3:RO;", 
				"1|2->1:TPI|TI->PI;2|2->3:TRI|TI->RI;1|2->1:TPO|TO->PO;2|2->3:TRO|TO->RO;3|1->1:setTurnI|PI->PI;4|1->1:checkO|PO->PO");
		other.addRule("enter", 
				"1:PI;2:TI;3:RI;4:F1I;1:PO;2:TO;3:RO;5:F2O",
				"1|2->1:TPI|TI->PI;2|2->3:TRI|TI->RI;1|2->1:TPO|TO->PO;2|2->3:TRO|TO->RO;3|1->1:checkI|PI->PI;4|1->4:PF1I|PI->F1I;5|4->3:F1RI|F1I->RI;6|1->1:critO|PO->PO;7|1->5:PF2O|PO->F2O;8|5->3:F2RO|F2O->RO");
		other.addRule("exit", 
				"1:PI;2:RI;1:PO;2:RO;3:F2I", 
				"1|1->1:activeI|PI->PI;2|1->1:critI|PI->PI;3|1->3:PF2I|PI->F2I;4|3->2:F2RI|F2I->RI;5|1->1:non-activeO|PO->PO;6|1->1:startO|PO->PO");
		other.refresh();
		other.translate();
	}
	public void refresh() {
		
	}
	String[] sVertex = null;
	String[][] sEdges = null;
	String[] tVertex = null;
	String[][] tEdges = null;
	String name = null;
	public SMT(String string, String snodes, String sedges, String tnodes, String tedges){
		name = string;
		String[] ns = snodes.split(";");
		this.sVertex = Arrays.copyOf(ns, ns.length + 1);
		this.sVertex[ns.length] = "V";		
		String[] es = sedges.split(";");
		this.sEdges = new String[es.length + 1][];
		for (int i = 0; i < es.length; i++) {
			String edge = es[i];
			int f = edge.indexOf("|");
			if(f == -1)
				throw new RuntimeException("type in edge is not right. See " + edge);
			int s = edge.indexOf("->", f);
			if(s == -1)
				throw new RuntimeException("type in edge is not right. See " + edge);
			this.sEdges[i] = new String[3];
			this.sEdges[i][0] = edge.substring(0, f);
			this.sEdges[i][1] = edge.substring(f + 1, s);
			this.sEdges[i][2] = edge.substring(s + 2);
		}
		this.sEdges[es.length] = new String[]{"NEI"};
		for (int i = 0; i < sVertex.length; i++) {
			sVertex[i] += "I";
		}
		for (int i = 0; i < sEdges.length - 1; i++) {
			sEdges[i][0] += "I";
			sEdges[i][1] += "I";
			sEdges[i][2] += "I";
		}

		ns = tnodes.split(";");
		this.tVertex = Arrays.copyOf(ns, ns.length + 1);
		this.tVertex[ns.length] = "V";		
		es = tedges.split(";");
		this.tEdges = new String[es.length + 1][];
		for (int i = 0; i < es.length; i++) {
			String edge = es[i];
			int f = edge.indexOf("|");
			if(f == -1)
				throw new RuntimeException("type in edge is not right. See " + edge);
			int s = edge.indexOf("->", f);
			if(s == -1)
				throw new RuntimeException("type in edge is not right. See " + edge);
			this.tEdges[i] = new String[3];
			this.tEdges[i][0] = edge.substring(0, f);
			this.tEdges[i][1] = edge.substring(f + 1, s);
			this.tEdges[i][2] = edge.substring(s + 2);
		}
		this.tEdges[es.length] = new String[]{"NEO"};
		for (int i = 0; i < tVertex.length; i++) {
			tVertex[i] += "O";
		}
		for (int i = 0; i < tEdges.length - 1; i++) {
			tEdges[i][0] += "O";
			tEdges[i][1] += "O";
			tEdges[i][2] += "O";
		}
	}

	public SMT(String string, String snodes, String sedges){
		this(string, snodes, sedges, snodes, sedges);
	}

	private String makeSpaceBetweenStrings(String... vari){
		String result = "";
		for (int i = 0; i < vari.length; i++) {
			result += vari[i];
			if(i != vari.length - 1)
				result += " ";
		}
		return result;
	}
	private String sourceAndTarget(String[][] sEdges, boolean in){
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < sEdges.length - 1; i++) {
			buffer.append("(assert (! (forall ((s " + (in ? VINN : VOUT) + ") (t " + (in ? VINN : VOUT) + ") (e " + (in ? EINN : EOUT) + ")) (=> (");
			buffer.append(sEdges[i][0] + " s t e) (and (" + sEdges[i][1] + " s) (" + sEdges[i][2] + " t)))) :named " + sEdges[i][0] + "-source-target))");
			buffer.append(System.getProperty("line.separator"));
		}
//		if(in)
//			buffer.append("(assert (! (forall ((s V-INN) (t V-INN) (e E-INN)) (=> (NEI s t e) (and (ValidVI s) (ValidVI t)))) :named NEI-source-target))");
//		else
//			buffer.append("(assert (! (forall ((s V-OUT) (t V-OUT) (e E-OUT)) (=> (NEO s t e) (and (ValidVO s) (ValidVO t)))) :named NEO-source-target))");
		
		buffer.append(System.getProperty("line.separator"));
		return buffer.toString();
	}
	private String edgeExclusive(String[][] sEdges, boolean in){
		StringBuffer buffer = new StringBuffer();
//		for (int i = 0; i < sEdges.length - 1; i++) {
			buffer.append("(assert (! (forall ((s " + (in ? VINN : VOUT) + ") (t " + (in ? VINN : VOUT) + ") (e " + (in ? EINN : EOUT) + ")) (=> (");
			buffer.append("NNullE" + (in ? "I" : "O") + " s t e) (forall ((s1 " + (in ? VINN : VOUT) + ") (t1 " + (in ? VINN : VOUT) + ")) " +
					"(=> (not (and (= s s1) (= t t1))) (not (ValidE" + (in ? "I" : "O") + " s1 t1 e)))))) :named " + (in ? "source" : "target") + "-edge-exclusive))");
//			buffer.append(System.getProperty("line.separator"));
//		}
		return buffer.toString();
	}

	public void addRule(String name, String n, String e){
		rules.add(new Rule(name, n, e));
	}


	public String uniqueNode(String a, boolean in){
		String node = a + (in ? "I" : "O");
		String type = in ? VINN : VOUT;
		return "(assert (! " + (in ? "" : "(not ") + "(forall ((a " + type + ") (b " + type + ")) (or (not (and (" + node + " a) (" + node + " b))) (= a b)))" + (in ? "" : ")") + " :named unique-" + node + "))";
	}
	public String existNode(String a, boolean in){
		String node = a + (in ? "I" : "O");
		String type = in ? VINN : VOUT;
		return "(assert (! " + (in ? "" : "(not ") + "(exists ((a " + type + ")) (" + node + " a))" + (in ? "" : ")") + " :named exist-" + node + "))";
	}
	public String notuniqueNode(String a, boolean in){
		String node = a + (in ? "I" : "O");
		String type = in ? VINN : VOUT;
		return "(assert (! " + (in ? "" : "(not ") + "(not (forall ((a " + type + ") (b " + type + ")) (or (not (and (" + node + " a) (" + node + " b))) (= a b)))" + (in ? "" : ")") + " :named not-unique-" + node + "))";
	}
	public String notexistNode(String a, boolean in){
		String node = a + (in ? "I" : "O");
		String type = in ? VINN : VOUT;
		return "(assert (! " + (in ? "" : "(not ") + "(not (exists ((a " + type + ")) (" + node + " a)))" + (in ? "" : ")") + " :named not-exist-" + node + "))";
	}

}
