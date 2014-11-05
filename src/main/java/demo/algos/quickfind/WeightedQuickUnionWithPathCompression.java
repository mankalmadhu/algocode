package demo.algos.quickfind;

public class WeightedQuickUnionWithPathCompression extends QuickUnion {

	private int[] treesize;

	public WeightedQuickUnionWithPathCompression(int N) {
		super(N);
		treesize = new int[N];

	}
	
	protected int root(int elem) {
		while (elems[elem] != elem) {
			elem = elems[elem];
		}
		return elem;
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
