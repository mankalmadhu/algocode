package demo.algos.sorting;

public class BubbleSort<T extends Comparable<T>> {

	private T[] elems;

	public BubbleSort(T[] elems) {

		this.elems = elems;

	}

	public void sort() {
		for (int i = 0; i < elems.length; i++) {
			for (int j = i; j < elems.length; j++) {
				if (SortUtil.less(elems[j], elems[i])) {
					SortUtil.exch(elems, i, j);
				}
			}
		}
	}
}
