package demo.algos.sorting.merge;

import java.util.Arrays;

import demo.algos.sorting.SortUtil;

public class MergeSortIterative<T extends Comparable<?>> {

	private T[] elems;

	private T[] tmp;

	public MergeSortIterative(T[] elems) {

		this.elems = elems;
		this.tmp = elems.clone();

	}

	protected void sort(int low, int high) {

		
		int mid = 0;

		merge(0, mid, 1);
		
		mid=1;
		merge(0,mid,2);
		
		mid=2;
		merge(0,mid,3);

	}

	public void sort() {

		sort(0, elems.length - 1);

	}

	public void printResult() {
		System.out.println(Arrays.toString(elems));
	}

	protected void merge(int low, int mid, int high) {

		for (int k = low; k <= high; k++) {
			tmp[k] = elems[k];
		}

		int i = low;
		int j = mid + 1;

		for (int k = low; k <= high; k++) {

			if (i > mid) {
				elems[k] = tmp[j++];
			}

			else if (j > high) {
				elems[k] = tmp[i++];
			}

			else if (SortUtil.less(tmp[j], tmp[i])) {
				elems[k] = tmp[j++];

			} else {
				elems[k] = tmp[i++];
			}

		}

	}

}
