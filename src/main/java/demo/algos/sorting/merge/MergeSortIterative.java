package demo.algos.sorting.merge;


public class MergeSortIterative<T extends Comparable> extends MergeSort {

	public MergeSortIterative(T[] elems) {

		super(elems);

	}

	protected void sort(int low, int high) {

		if (high <= low) {
			return;
		}

		int mid = low + ((high - low) / 2);
		sort(low, mid);
		sort(mid + 1, high);
		merge(low, mid, high);

	}

}
