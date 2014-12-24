package demo.datastructures.graph;

import demo.datastructures.bag.Bag;

public class Graph {

	private int numOfVertices;

	private int numOfEdges;

	private Bag<Integer>[] nodeLinks;

	@SuppressWarnings("unchecked")
	public Graph(int numOfVertices) {
		this.numOfVertices = numOfVertices;
		nodeLinks = (Bag<Integer>[]) new Bag[numOfVertices];

		for (int v = 0; v < numOfVertices; v++) {
			nodeLinks[v] = new Bag<Integer>();
		}
	}

	public int vertices() {
		return numOfVertices;
	}

	public int edges() {
		return numOfEdges;
	}

	public void addEdge(int src, int dest) {

		checkSanity(src);
		checkSanity(dest);
		nodeLinks[src].add(dest);
		nodeLinks[dest].add(src);
		numOfEdges++;
	}

	public Iterable<Integer> adj(int v) {
		checkSanity(v);
		return nodeLinks[v];
	}

	private void checkSanity(int v) {

		if (v < 0 || v >= numOfVertices)
			throw new IndexOutOfBoundsException();
	}

}
