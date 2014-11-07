package demo.algos.quickfind;

public class WeightedQuickUnionWithPathCompression extends WeightedQuickUnion {

	public WeightedQuickUnionWithPathCompression(int N) {
		super(N);

	}

	protected int root(int elem) {
		while (elems[elem] != elem) {
			elems[elem] = elems[elems[elem]];
			elem = elems[elem];
		}
		return elem;
	}

}
