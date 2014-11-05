package demo.algos.quickfind;

public class WeightedQuickUnion extends QuickUnion {

	private int[] treesize;

	public WeightedQuickUnion(int N) {
		super(N);
		treesize = new int[N];

	}

	@Override
	void union(int elem1, int elem2) {

		int elem1root = root(elem1);
		int elem2root = root(elem2);
		
		if (elem1root == elem2root) {
			return;
		}

		if (treesize[elem1] > treesize[elem2]) {
			treesize[elem1] += treesize[elem2];
			elems[elem2root] = elem1root;
		} else {
			treesize[elem2] += treesize[elem1];
			elems[elem1root] = elem2root;
		}

	}

}
