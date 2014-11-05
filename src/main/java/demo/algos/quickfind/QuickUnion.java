package demo.algos.quickfind;

public class QuickUnion extends AbstractUnionFind {

	public QuickUnion(int N) {
		super(N);

	}

	@Override
	boolean connected(int elem1, int elem2) {

		return root(elem1) == root(elem2);
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

		elems[elem1root] = elem2root;

	}

}
