package demo.algos.sorting.quick;

import java.util.Arrays;

import demo.algos.sorting.SortUtil;

public class QuickSort<T extends Comparable<T>> {

	private T[] elems;

	public QuickSort(T[] elems) {

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

	protected int partition(int low, int high) {

		int start = low + 1;
		int end = high;
		int pivot = low;

		while (true) {

			while (SortUtil.less(elems[start], elems[pivot])) {
				start++;
				if (start == high) {
					break;
				}
			}

			while (SortUtil.less(elems[pivot], elems[end])) {
				end--;
				if (end == low) {
					break;
				}
			}

			if (start > end) {
				break;
			}

			SortUtil.exch(elems, start, end);
		}

		SortUtil.exch(elems, pivot, end);
		return end;

	}
	
	

}
