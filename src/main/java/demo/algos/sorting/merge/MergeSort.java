package demo.algos.sorting.merge;

import java.util.Arrays;

import demo.algos.sorting.SortUtil;

public class MergeSort<T extends Comparable<T>> {

	private T[] elems;

	private T[] tmp;

	public MergeSort(T[] elems) {

		this.elems = elems;
		this.tmp =elems.clone();
		

	}

	public void sort() {

		sort(0, elems.length - 1);

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
