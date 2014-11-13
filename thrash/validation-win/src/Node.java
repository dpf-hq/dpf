

class Node implements Comparable<Node>{
		public Node(int index2, String type2) {
			index = index2;
			type = type2;
		}
		int index;
		String type;
		@Override
		public int compareTo(Node arg0) {
			return index - arg0.index;
		}
		public String toString(){
			return "" + index + ":" + type;
		}
	}
