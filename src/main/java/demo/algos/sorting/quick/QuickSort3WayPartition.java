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

		Tuple<Integer, Integer> ret = new Tuple<>(low, high);

		partition(ret);

		sort(low, ret.low - 1);
		sort(ret.high + 1, high);

	}

	public void printResult() {
		System.out.println(Arrays.toString(elems));
	}

	/**
	 * @param tuple
	 *            Invariant : During partition the pivot variable always should
	 *            be at the index if 'pivot'.
	 */
	protected void partition(Tuple<Integer, Integer> tuple) {

		int pivot = tuple.low;
		tuple.low++;

		while (tuple.low <= tuple.high) {

			int compare = elems[pivot].compareTo(elems[tuple.low]);

			if (compare > 0) {
				SortUtil.exch(elems, tuple.low++, pivot++);
			} else if (compare < 0) {
				SortUtil.exch(elems, tuple.low, tuple.high--);
			} else {
				pivot++;
			}

		}

	}

	private class Tuple<T, U> {

		T low;
		U high;

		public Tuple(T low, U high) {
			super();
			this.low = low;
			this.high = high;
		}

	}

}
