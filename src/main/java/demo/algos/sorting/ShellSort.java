package demo.algos.sorting;

public class ShellSort<T extends Comparable> {

	private T[] elems;

	public ShellSort(T[] elems) {

		this.elems = elems;

	}

	public void sort() {

		Integer h = 0;
		while (h < (elems.length / 3)) {
			h = 3 * h + 1;
		}

		while (h >= 1) {
			for (int i = 0; i < elems.length; i++) {

				for (int j = i; j > 0; j--) {
					if (SortUtil.less(elems[j], elems[j - h])) {
						SortUtil.exch(elems, j, j - h);
					}
				}
			}
			h = h / 3;
		}
	}

}
