
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Graph graph = new Graph("buffer", "(3,3)1:C;3:C;5:C;7:C;4:B|1->5:n;5->7:n;7->3:n;3->1:n;4->1:f;4->3:l;3->4:e;1->4:e;5->4:e;7->4:e");
		GraphTransform xform = new GraphTransform();
		xform.addRule(new Rule("Get", "(2,2)0:C;1:O;2:B;3:C|0->1:v;0->3:n;2->0:f", "(2,2)0:C;2:B;3:C|0->2:e;0->3:n;2->3:f", "0<->0;2<->2;3<->3|0->3:n<->0->3:n"));
		xform.addRule(new Rule("Put", "(2,2)0:C;2:B;3:C|3->2:e;0->3:n;2->0:l", "(2,2)0:C;1:O;2:B;3:C|0->3:n;2->3:l;3->1:v;", "0<->0;2<->2;3<->3|0->3:n<->0->3:n"));
//		xform.xform(graph);
		graph.name = "buffer";
		ShapeTransform sform = new ShapeTransform(xform);
		Shape init = new Shape(graph);
		sform.xform(init);
	}

}
