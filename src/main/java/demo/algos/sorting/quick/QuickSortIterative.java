package demo.algos.sorting.quick;

import java.util.Arrays;

import demo.algos.sorting.SortUtil;

public class QuickSortIterative<T extends Comparable<T>> {

	private T[] elems;

	public QuickSortIterative(T[] elems) {

		this.elems = elems;

	}

	/**
	 * 1) In outer loop keep looping the sort count until length.
	 * 
	 * 2) In inner loop the first unsorted elem is 'start' and 'end' is the next
	 * unsorted element.
	 * 
	 */
	public void sort() {
		boolean[] sorted = new boolean[elems.length];

		int sortedCount = 0;

		while (sortedCount < elems.length) {
			for (int start = 0; start < elems.length; start++) {
				if (!sorted[start]) {
					int end = start;
					while ((end < elems.length - 1) && (!sorted[end + 1])) {
						end++;
					}
					sorted[start = partition(start, end)] = true;
					sortedCount++;

				}
			}
		}

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
