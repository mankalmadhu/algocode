package demo.algos.sorting.quick;

import java.util.Arrays;

import demo.algos.sorting.SortUtil;

public class QuickSortAlternative<T extends Comparable> {

	private T[] elems;

	public QuickSortAlternative(T[] elems) {

		this.elems = elems;

	}

	public void sort() {

		sort(0, elems.length - 1);

	}

	protected void sort(int low, int high) {

		if (high <= low) {
			return;
		}

		int j = partition(low, high);
		sort(low, j - 1);
		sort(j + 1, high);

	}

	public void printResult() {
		System.out.println(Arrays.toString(elems));
	}

	protected int partition(int start, int end) {

		int pivot = start;

		for (int i = start++; i <= end; i++) {

			if (SortUtil.less(elems[i], elems[pivot])) {
				SortUtil.exch(elems, start++, i);
			}
		}
		SortUtil.exch(elems, pivot, start - 1);
		return start - 1;

	}

}
