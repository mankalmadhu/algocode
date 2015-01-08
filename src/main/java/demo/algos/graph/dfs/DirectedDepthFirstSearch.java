package demo.algos.graph.dfs;

import demo.datastructures.graph.DiGraph;
import demo.datastructures.stack.StackWithLinkedList;

public class DirectedDepthFirstSearch {

	boolean marked[];

	int edgeFrom[];

	int connectedComponent[];

	int ccCount;

	DiGraph g;

	public DirectedDepthFirstSearch(DiGraph input) {
		g = input;
		marked = new boolean[g.vertices()];
		edgeFrom = new int[g.vertices()];
		connectedComponent = new int[g.vertices()];

		for (int i = 0; i < g.vertices(); i++) {
			if (!marked[i]) {
				dfs(i);
				ccCount++;
			}
		}
	}

	/**
	 * Uses Iteration.May not be correct..:)
	 * @param v
	 */
	private void dfs(int v) {
		marked[v] = true;

		StackWithLinkedList<Integer> nodestack = new StackWithLinkedList<Integer>();
		nodestack.push(v);

		while (!nodestack.isEmpty()) {
			int curTop = nodestack.pop();
			marked[curTop] = true;
			for (int adjNode : g.adj(curTop)) {
				if (!marked[adjNode]) {

					edgeFrom[adjNode] = v;
					connectedComponent[adjNode] = ccCount;
					nodestack.push(adjNode);
				}
			}
		}
	}

}
