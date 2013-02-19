import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Rule{
	public static void main(String[] args) {
		Rule rule = new Rule("setFlag", "1:PI;2:RI;1:PO;2:RO;3:F1O", "1|1->1:non-activeI|PI->PI;2|1->1:startI|PI->PI;3|1->1:activeO|PO->PO;4|1->1:setTurnO|PO->PO;5|1->3:PF1O|PO->F1O;6|3->2:F1RO|F1->R");
		try {
			rule.printRule(new PrintWriter(new File("rule")));
		} catch (FileNotFoundException e) {
			System.out.println(e);
			e.printStackTrace();
		}
	}

	List<Node> delNodes = new ArrayList<Node>();
	List<Node> addNodes = new ArrayList<Node>();
	List<Node[]> kepNodes = new ArrayList<Node[]>();
	List<Edge[]> delEdges = new ArrayList<Edge[]>();
	List<Edge[]> addEdges = new ArrayList<Edge[]>();
	List<Edge[]> kepEdges = new ArrayList<Edge[]>();
	public static final Node nadd, ndel;
	public static final Edge eadd, edel;
	public static final int DEL = -2, ADD = -1;
	static{
		nadd = new Node(ADD, "VO");
		ndel = new Node(DEL, "VI");
		eadd = new Edge();
		eadd.index = ADD;
		eadd.tn = "NEO";
		edel = new Edge();
		edel.index = DEL;
		edel.tn = "NEI";
	}
	void printRuleMatch(PrintWriter writer, int index){
		writer.println();
		writer.print(" (exists (");
		for(Node n : delNodes){
			writer.print(" (ni_"+ index + n.index + " V-INN)");
		}
		for(Edge[] n : delEdges){
			writer.print(" (ei_" + index + n[0].index + " E-INN)");
		}
		for(Node[] n : kepNodes){
			writer.print(" (ni_" + index + n[0].index + " V-INN)");
		}

		for(Edge[] n : kepEdges){
			writer.print(" (ei_" + index + n[0].index + " E-INN)");
		}

		if(!addNodes.isEmpty())
			writer.print(" (ni_" + index + ndel.index + " V-INN)");
		if(!addEdges.isEmpty())
			writer.print(" (ei_" + index + edel.index + " E-INN)");
		writer.println(") ");
		int nu = delNodes.size() + delEdges.size() + kepNodes.size() + kepEdges.size() - 1 + (addNodes.isEmpty() ? 0 : 1) + addEdges.size();
		for(int i = 0; i < nu; i++){
			writer.print(" (and");
		}
		if(nu < 0)
			writer.print(" ");
		boolean start = nu > 0;
		for(Node n : delNodes){
			start = printNode(writer, n, start, true, "_" + index);			
		}
		for(Edge[] n : delEdges){
			start = printEdge(writer, n[0], start, true, "_" + index);
		}
		for(Node[] n : kepNodes){
			start = printNode(writer, n[0], start, true, "_" + index);
		}
		for(Edge[] n : kepEdges){
			start = printEdge(writer, n[0], start, true, "_" + index);
		}
		if(!addNodes.isEmpty())
			printNode(writer, ndel, start, true, "_" + index);
		for(Edge[] n : addEdges){
			start = printEdge(writer, n[1], start, true, "_" + index);
		}
		writer.print(")");
	}
	private boolean printEdge(PrintWriter writer, Edge e, boolean start,
			boolean input, String string) {
		if(input)
			writer.print(" (" + e.tn + " ni" + string + e.src + " ni" + string + e.trg + " ei" + string + e.index + ")");
		else
			writer.print(" (" + e.tn + " no" + string + e.src + " no" + string + e.trg + " eo" + string + e.index + ")");
		if(!start)
			writer.print(")");
		else
			start = false;
		return start;
	}
	private boolean printNode(PrintWriter writer, Node n, boolean start,
			boolean b, String string) {
		writer.print(" (" + n.type + (b ? " ni" : " no") + string + n.index + ")");
		if(!start)
			writer.print(")");
		else
			start = false;
		return start;
	}
	void printRule(PrintWriter writer){
		writer.println(";Rule " + name);
		writer.print("(assert (! (forall (");
		for(Node n : delNodes){
			writer.print(" (ni" + n.index + " V-INN)");
		}
		for(Edge[] n : delEdges){
			writer.print(" (ei" + n[0].index + " E-INN)");
		}
		for(Node[] n : kepNodes){
			writer.print(" (ni" + n[0].index + " V-INN)");
		}

		for(Edge[] n : kepEdges){
			writer.print(" (ei" + n[0].index + " E-INN)");
		}

		if(!addNodes.isEmpty())
			writer.print(" (ni" + ndel.index + " V-INN)");
		if(!addEdges.isEmpty())
			writer.print(" (ei" + edel.index + " E-INN)");

		writer.println(") ");
		writer.print("(=>");
		//print left matching
		int nu = delNodes.size() + delEdges.size() + kepNodes.size() + kepEdges.size() - 1 + (addNodes.isEmpty() ? 0 : 1) + addEdges.size();
		for(int i = 0; i < nu; i++){
			writer.print(" (and");
		}
		if(nu < 0)
			writer.print(" ");
		boolean start = nu > 0;
		for(Node n : delNodes){
			start = printNode(writer, n, start, true);			
		}
		for(Edge[] n : delEdges){
			start = printEdge(writer, n[0], start, true);
		}
		for(Node[] n : kepNodes){
			start = printNode(writer, n[0], start, true);
		}
		for(Edge[] n : kepEdges){
			start = printEdge(writer, n[0], start, true);
		}
		if(!addNodes.isEmpty())
			printNode(writer, ndel, start, true);
		for(Edge[] n : addEdges){
			start = printEdge(writer, n[1], start, true);
		}
		writer.println(" ");
		writer.print("(exists (");

		for(Node n : addNodes){
			writer.print(" (no" + n.index + " V-OUT)");
		}
		for(Edge n[] : addEdges){
			writer.print(" (eo" + n[0].index + " E-OUT)");
		}
		for(Node[] n : kepNodes){
			writer.print(" (no" + n[1].index + " V-OUT)");
		}
		for(Edge[] n : kepEdges){
			writer.print(" (eo" + n[1].index + " E-OUT)");
		}
		if(!delNodes.isEmpty())
			writer.print(" (no" + nadd.index + " V-OUT)");
		if(!delEdges.isEmpty())
			writer.print(" (eo" + eadd.index + " E-OUT)");

		writer.println(") ");

		writer.print("(and");
		//print right corresponding
		nu = addNodes.size() + addEdges.size() + kepNodes.size() + kepEdges.size() - 1 + (delNodes.isEmpty() ? 0 : 1) + delEdges.size();
		for(int i = 0; i < nu; i++){
			writer.print(" (and");
		}
		if(nu < 0)
			writer.print(" ");
		start = nu > 0;
		for(Node n : addNodes){
			start = printNode(writer, n, start, false);
		}
		for(Edge[] n : addEdges){
			start = printEdge(writer, n[0], start, false);
		}
		for(Node[] n : kepNodes){
			start = printNode(writer, n[1], start, false);
		}
		for(Edge[] n : kepEdges){
			start = printEdge(writer, n[1], start, false);
		}
		if(!delNodes.isEmpty())
			start = printNode(writer, nadd, start, false);
		for(Edge[] n : delEdges){
			start = printEdge(writer, n[1], start, false);
		}
		writer.println(" ");
		writer.print("(and");

		nu = delNodes.size() + delEdges.size() + kepNodes.size() + kepEdges.size() + addNodes.size() + addEdges.size() - 1;
		for(int i = 0; i < nu; i++){
			writer.print(" (and");
		}
		if(nu < 0)
			writer.print(" ");
		start = nu > 0;
		for(Node n : delNodes){
			start = printNodeMap(writer, n, start, nadd, true);			
		}
		for(Edge[] n : delEdges){
			start = printEdgeMap(writer, n[0], start, n[1], true);
		}
		for(Node[] n : kepNodes){
			start = printNodeMap(writer, n[0], start, n[1], true);	
		}
		for(Edge[] n : kepEdges){
			start = printEdgeMap(writer, n[0], start, n[1], true);
		}

		for(Node n : addNodes){
			start = printNodeMap(writer, n, start, ndel, false);			
		}
		for(Edge[] n : addEdges){
			start = printEdgeMap(writer, n[0], start, n[1], false);
		}
		writer.println("");

		nu = delNodes.size() + delEdges.size() + addNodes.size() + addEdges.size() - 1;
		for(int i = 0; i < nu; i++){
			writer.print(" (and");
		}
		if(nu < 0)
			writer.print(" ");
		start = nu > 0;
		for(Node n : delNodes){
			start = printNodeChange(writer, n, start, true);			
		}
		for(Edge[] n : delEdges){
			start = printEdgeChange(writer, n[0], start, true);
		}
		for(Node n : addNodes){
			start = printNodeChange(writer, n, start, false);			
		}
		for(Edge[] n : addEdges){
			start = printEdgeChange(writer, n[0], start, false);
		}
		writer.println("))))) :named rule-" + name + "))");
	}
	String name;
	private boolean printNodeChange(PrintWriter writer, Node n, boolean start,
			boolean input) {
		if(input)
			writer.print(" (delVID ni" + n.index + " id" + name + ")");
		else
			writer.print(" (addVID no" + n.index + " id" + name + ")");
		if(!start)
			writer.print(")");
		else
			start = false;
		return start;
	}
	private boolean printEdgeChange(PrintWriter writer, Edge n, boolean start,
			boolean input) {
		if(input)
			writer.print(" (delEID ni" + n.src + " ni" + n.trg + " ei" + n.index + " id" + name + ")");
		else
			writer.print(" (addEID no" + n.src + " no" + n.trg + " eo" + n.index + " id" + name + ")");
		if(!start)
			writer.print(")");
		else
			start = false;
		return start;
	}
	private boolean printEdgeMap(PrintWriter writer, Edge e, boolean start,
			Edge edge2, boolean b) {
		if(b)
			writer.print(" (= (out-tuple no" + edge2.src + " no" + edge2.trg + " eo" + edge2.index + ") (delE ni" + e.src + " ni" + e.trg + " ei" + e.index + "))");
		else
			writer.print(" (= (inn-tuple ni" + edge2.src + " ni" + edge2.trg + " ei" + edge2.index + ") (addE no" + e.src + " no" + e.trg + " eo" + e.index + "))");

		if(!start)
			writer.print(")");
		else
			start = false;
		return start;
	}
	private boolean printNodeMap(PrintWriter writer, Node n, boolean start,
			Node nadd2, boolean del) {
		writer.print(" (= n" + (del ? "o" : "i") + nadd2.index + " (" + (del ? "delV" : "addV") + (del ? " ni" : " no") + n.index + "))");
		if(!start)
			writer.print(")");
		else
			start = false;
		return start;
	}
	private boolean printEdge(PrintWriter writer, Edge e, boolean start, boolean input) {
		return  printEdge(writer, e, start, input, "");
	}
	private boolean printNode(PrintWriter writer, Node n, boolean start, boolean input) {
		return printNode(writer, n, start, input, "");
	}
	void parseNode(String n){
		String[] nodes = n.split(";");
		Arrays.sort(nodes);
		for (int i = 0; i < nodes.length; ) {
			String cur = nodes[i];
			String next = i + 1 < nodes.length ? nodes[i + 1] : null;
			String[] node = cur.split(":");
			int index = 0;
			index = Integer.parseInt(node[0]);
			String type = node[1];
			Node nu = new Node(index, type);

			if(next == null){
				if(type.endsWith("I"))
					delNodes.add(nu);
				else
					addNodes.add(nu);
				++i;
			}else{
				String[] nn = next.split(":");
				int ni = 0;
				ni = Integer.parseInt(nn[0]);
				String nt = nn[1];
				Node nuo = new Node(index, nt);
				if(ni != index){
					if(type.endsWith("I"))
						delNodes.add(nu);
					else
						addNodes.add(nu);
					++i;
				}else{
					kepNodes.add(new Node[]{nu, nuo});
					i = i + 2;
				}
			}

		}
		System.out.println("Delete Nodes");
		for (Node string : delNodes) {
			System.out.println(string);
		}
		System.out.println("Add Nodes");
		for (Node string : addNodes) {
			System.out.println(string);
		}
		System.out.println("Kept Nodes");
		for (Node[] string : kepNodes) {
			System.out.println(string[0] + "->" + string[1]);
		}
	}
	List<int[]> getRuleNullEdge(boolean in){
		List<int[]> NEdges = new ArrayList<int[]>();
		for(Edge[] cur : (in ? addEdges : delEdges)){
			int[] nulledge = new int[2];
			nulledge[0] = cur[2].src;
			nulledge[1] = cur[2].trg;
			putIntoList(NEdges, nulledge);
		}
		return NEdges;
	}
	public static  void putIntoList(List<int[]> nEdges, int[] nulledge) {
		for(int[] cur : nEdges){
			if(cur[0] == nulledge[0] && cur[1] == nulledge[1])
				return;
		}
		nEdges.add(nulledge);
	}
	Edge getTransformedEdge(Edge edge){
		Edge new_edge = new Edge();
		if(edge.tn.endsWith("I")){
			new_edge.index = ADD;
			new_edge.tn = "NEO";
		}else{
			new_edge.index = DEL;
			new_edge.tn = "NEI";
		}
		new_edge.src = getTransformedNode(edge.src, edge.ts);
		switch(new_edge.src){
		case DEL:
			new_edge.ts = "VI";
			break;
		case ADD: 
			new_edge.ts = "VO";
			break;
		default:
			new_edge.ts = edge.ts;
		}
		new_edge.trg = getTransformedNode(edge.trg, edge.tt);
		switch(new_edge.src){
		case DEL:
			new_edge.tt = "VI";
			break;
		case ADD: 
			new_edge.tt = "VO";
			break;
		default:
			new_edge.tt = edge.tt;
		}
		return new_edge;
	}
	void parseEdge(String e){
		String[] edges = e.split(";");
		Arrays.sort(edges);
		for (int i = 0; i < edges.length;) {
			String cur = edges[i];
			String next = i + 1 < edges.length ? edges[i + 1] : null;
			String[] edge_type = cur.split(":");
			Edge edge = new Edge();
			init(edge, edge_type[0]);
			initType(edge, edge_type[1]);

			if(next == null){
				if(edge.tn.endsWith("I"))
					delEdges.add(new Edge[]{edge, getTransformedEdge(edge)});
				else
					addEdges.add(new Edge[]{edge, getTransformedEdge(edge)});
				++i;
			}else{
				String[] edge_next = next.split(":");
				Edge ne = new Edge();
				init(ne, edge_next[0]);
				initType(ne, edge_next[1]);
				if(edge.index != ne.index){
					if(edge.tn.endsWith("I"))
						delEdges.add(new Edge[]{edge, getTransformedEdge(edge)});
					else
						addEdges.add(new Edge[]{edge, getTransformedEdge(edge)});
					++i;
				}else{
					kepEdges.add(new Edge[]{edge, ne});
					i = i + 2;
				}
			}

		}
		System.out.println("Delete Edges");
		for (Edge[] string : delEdges) {
			System.out.println(string[0]);
		}
		System.out.println("Add Edges");
		for (Edge[] string : addEdges) {
			System.out.println(string[0]);
		}
		System.out.println("Kept Edges");
		for (Edge[] string : kepEdges) {
			System.out.println(string[0] + "->" + string[1]);
		}
	}
	private boolean findNode(List<Node[]> list, Node node){
		for(Node[] iter : list)
			if(iter[0].index == node.index)
				return true;
		return false;
	}
	private int getTransformedNode(int src, String type) {
		Node cur = new Node(src, type);
		//		System.out.println(type);
		Boolean result = !findNode(kepNodes, cur);
		if(result && type.endsWith("O"))
			return DEL;
		if(result && type.endsWith("I"))
			return ADD;
		//		System.out.println(src);
		return src;
	}
	private void initType(Edge edge, String string) {
		int f = string.indexOf("|");
		if(f == -1)
			throw new RuntimeException("type in edge is not right. See " + string);
		int s = string.indexOf("->", f);
		if(s == -1)
			throw new RuntimeException("type in edge is not right. See " + string);
		edge.tn = string.substring(0, f);
		edge.ts = string.substring(f + 1, s);
		edge.tt = string.substring(s + 2);
	}
	private void init(Edge edge, String string) {
		int f = string.indexOf("|");
		if(f == -1)
			throw new RuntimeException("type in edge is not right. See " + string);
		int s = string.indexOf("->", f);
		if(s == -1)
			throw new RuntimeException("type in edge is not right. See " + string);
		edge.index = Integer.parseInt(string.substring(0, f));
		edge.src = Integer.parseInt(string.substring(f + 1, s));
		edge.trg = Integer.parseInt(string.substring(s + 2));
	}
	Rule(String name, String n, String e){
		this.name = name;
		parseNode(n);
		parseEdge(e);
	}
}