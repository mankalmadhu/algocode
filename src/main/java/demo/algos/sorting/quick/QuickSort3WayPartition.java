package demo.algos.sorting.quick;

import java.util.Arrays;

import demo.algos.sorting.SortUtil;

public class QuickSort3WayPartition<T extends Comparable> {

	private T[] elems;

	public QuickSort3WayPartition(T[] elems) {

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

		int pivot = low;
		low++;

		while (true) {

			int compare = elems[pivot].compareTo(elems[low]);

			if (compare > 0) {

				SortUtil.exch(elems, low++, pivot++);
			} else if (compare < 0) {
				SortUtil.exch(elems, low, high--);
			} else {
				pivot++;
			}

			if (low > high) {
				break;
			}

		}

		return high;

	}

}
