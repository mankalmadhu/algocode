package demo.algos.graph.bfs;

import demo.datastructures.graph.Graph;
import demo.datastructures.queue.QueueWithLinkedList;

public class BreadthFirstSearch {

	private boolean marked[];

	private int edgeFrom[];

	private int[] distTo;

	Graph g;

	public BreadthFirstSearch(Graph input) {
		g = input;
		marked = new boolean[g.vertices()];
		edgeFrom = new int[g.vertices()];
		distTo = new int[g.vertices()];
		bfs(0);

	}

	private void bfs(int v) {

		QueueWithLinkedList<Integer> q = new QueueWithLinkedList<Integer>();

		marked[v] = true;
		distTo[v] = 0;
		q.enueue(v);

		while (!q.isEmpty()) {
			int qelem = q.dequeue();

			for (int adj : g.adj(qelem)) {
				if (!marked[adj]) {
					edgeFrom[adj] = v;
					marked[adj] = true;
					distTo[adj] = distTo[adj] + 1;
					q.enueue(adj);
				}
			}

		}
	}

}
