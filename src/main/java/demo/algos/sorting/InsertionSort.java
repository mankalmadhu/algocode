package demo.algos.sorting;

public class InsertionSort<T extends Comparable> {

	private T[] elems;

	public InsertionSort(T[] elems) {

		this.elems = elems;

	}

	public void sort() {
		for (int i = 0; i < elems.length; i++) {

			for (int j = i; j > 0; j--) {
				if (SortUtil.less(elems[j], elems[j - 1])) {
					SortUtil.exch(elems, j, j - 1);
				}
			}
		}
	}
}
