package no.hib.dpf.text.wrapper;

import no.dpf.text.graph.parser.Parser;
import no.dpf.text.graph.GraphDpf$;

public class ScalaWrapper {
	public static void main(String[] args) {
		Parser test = new Parser(GraphDpf$.MODULE$, "DPF");
		System.out.println("Hallo" + test);
	}
}
