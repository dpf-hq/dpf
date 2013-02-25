import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Rule{
	public static void main(String[] args) {
		Rule rule = new Rule("setFlag", "1:PI;2:RI;1:PO;2:RO;3:F1O", "1|1->1:non-activeI|PI->PI;2|1->1:startI|PI->PI;3|1->1:activeO|PO->PO;4|1->1:setTurnO|PO->PO;5|1->3:PF1O|PO->F1O;6|3->2:F1RO|F1O->RO");
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
	public static final int SRC = -2, TRG = -1;
	static{
		nadd = new Node(TRG, "VO");
		ndel = new Node(SRC, "VI");
		eadd = new Edge();
		eadd.index = TRG;
		eadd.tn = "NEO";
		edel = new Edge();
		edel.index = SRC;
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

		nu = delNodes.size() + delEdges.size() + kepNodes.size() * 2 + kepEdges.size() * 2 + addNodes.size() + addEdges.size() - 1;
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
		for(Node[] n : kepNodes){
			start = printNodeMap(writer, n[1], start, n[0], false);	
		}
		for(Edge[] n : kepEdges){
			start = printEdgeMap(writer, n[0], start, n[1], true);
		}
		for(Edge[] n : kepEdges){
			start = printEdgeMap(writer, n[1], start, n[0], false);
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
			boolean src = type.endsWith("I");
			Node nu = new Node(index, type);

			if(next == null){
				(src ? delNodes : addNodes).add(nu);
				++i;
			}else{
				String[] nn = next.split(":");
				int ni = 0;
				ni = Integer.parseInt(nn[0]);
				String nt = nn[1];
				Node nuo = new Node(index, nt);
				if(ni != index){
					(src ? delNodes : addNodes).add(nu);
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
	String findNode(int index, boolean in){
		if(index >= 0)
			return getNode(kepNodes, index, in).type;
		return in ? "VI" : "VO";
	}
	private Node getNode(List<Node[]> list, int index, boolean in){
		for(Node[] iter : list)
			if(iter[in ? 0 : 1].index == index)
				return iter[in ? 0 : 1];
		return null;
	}
	List<String[]> getRuleNullEdge(List<String[]> NEdges, boolean in){
		List<Edge[]> cur = (in ? delEdges : addEdges);
		for(int i = 0; i < cur.size(); ++i){
			String[] nulledge = new String[2];
			nulledge[0] = findNode(cur.get(i)[1].src, in);
			nulledge[1] = findNode(cur.get(i)[1].trg, in);
			putIntoList(NEdges, nulledge);
		}
		cur = (in ? addEdges : delEdges);
		for(int i = 0; i < cur.size(); ++i){
			String[] nulledge = new String[2];
			nulledge[0] = findNode(cur.get(i)[1].src, in);
			nulledge[1] = findNode(cur.get(i)[1].trg, in);
			putIntoList(NEdges, nulledge);
		}
		putIntoList(NEdges, new String[]{in ? "VI" : "VO", in ? "VI" : "VO"});
		return NEdges;
	}
	public static  void putIntoList(List<String[]> nEdges, String[] nulledge) {
		for(String[] cur : nEdges){
			if(cur[0].equals(nulledge[0]) && cur[1].endsWith(nulledge[1]))
				return;
		}
		System.out.println("" + nulledge[0] + " " + nulledge[1]);
		nEdges.add(nulledge);
	}
	//transform *O to *I or *I to *O
	String toOppositeName(String name){
		char end = name.charAt(name.length() - 1);
		String result = name.substring(0, name.length() - 1);
		return result + (end == 'I' ? 'O' : 'I');
	}
	Edge getTransformedEdge(Edge edge, boolean src){
		Edge new_edge = new Edge();
		new_edge.index = src ? TRG : SRC;
		new_edge.tn = src ? "NEO" : "NEI";
		boolean isKept = isKept(edge.src, edge.ts, src);
		if(isKept){
			new_edge.src = edge.src;
			new_edge.ts = toOppositeName(edge.ts);
		}else{
			new_edge.src = src ? TRG : SRC;
			new_edge.ts = src ? "VO" : "VI";
		}
		isKept = isKept(edge.trg, edge.tt, src);
		if(isKept){
			new_edge.trg = edge.trg;
			new_edge.tt = toOppositeName(edge.tt);
		}else{
			new_edge.trg = src ? TRG : SRC;
			new_edge.tt = src ? "VO" : "VI";
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
			boolean src = edge.tn.endsWith("I");

			if(next == null){
				(src ? delEdges : addEdges).add(new Edge[]{edge, getTransformedEdge(edge, src)});
				++i;
			}else{
				String[] edge_next = next.split(":");
				Edge ne = new Edge();
				init(ne, edge_next[0]);
				initType(ne, edge_next[1]);
				if(edge.index != ne.index){
					(src ? delEdges : addEdges).add(new Edge[]{edge, getTransformedEdge(edge, src)});
					++i;
				}else{
					kepEdges.add(new Edge[]{edge, ne});
					i = i + 2;
				}
			}

		}
		System.out.println("Delete Edges");
		for (Edge[] string : delEdges) {
			System.out.println(string[0] + "->" + string[1]);
		}
		System.out.println("Add Edges");
		for (Edge[] string : addEdges) {
			System.out.println(string[0] + "->" + string[1]);
		}
		System.out.println("Kept Edges");
		for (Edge[] string : kepEdges) {
			System.out.println(string[0] + "->" + string[1]);
		}
	}
	private boolean findNode(List<Node[]> list, Node node, boolean in){
		for(Node[] iter : list)
			if(iter[(in ? 0 : 1)].index == node.index)
				return true;
		return false;
	}
	private boolean isKept(int src, String type, boolean in) {
		Node cur = new Node(src, type);
		return findNode(kepNodes, cur, in);
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