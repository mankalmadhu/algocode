package demo.algos.graph.dfs;

import demo.datastructures.graph.Graph;

public class DepthFirstSearch {

	boolean marked[];

	int edgeFrom[];

	int connectedComponent[];

	int ccCount;

	Graph g;

	public DepthFirstSearch(Graph input) {
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

	private void dfs(int v) {
		marked[v] = true;

		for (int adjNode : g.adj(v)) {
			if (!marked[adjNode]) {
				dfs(adjNode);
				edgeFrom[adjNode] = v;
				connectedComponent[adjNode] = ccCount;
			}
		}
	}

}
