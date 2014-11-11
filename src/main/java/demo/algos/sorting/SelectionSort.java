package demo.algos.sorting;

public class SelectionSort<T extends Comparable> {

	private T[] elems;

	public SelectionSort(T[] elems) {

		this.elems = elems;

	}

	public void sort() {
		for (int i = 0; i < elems.length; i++) {
			int min = i;
			for (int j = i; j < elems.length; j++) {
				if (SortUtil.less(elems[j], elems[min])) {
					SortUtil.exch(elems, min, j);
				}
			}
		}
	}
}
