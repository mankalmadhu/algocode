package demo.algos.sorting.heap;

import java.util.Arrays;

import demo.datastructures.heap.BinaryHeapForSort;

public class HeapSortCrazy<T extends Comparable> {

	private T[] elems;

	public HeapSortCrazy(T[] elems) {

		this.elems = elems;

	}

	public void sort() {

		BinaryHeapForSort<T> heap = new BinaryHeapForSort<T>(elems);

		for (int i = elems.length - 1; i > 0; i--) {
			elems[i] = heap.getMax();
		}

	}

	public void printResult() {
		System.out.println(Arrays.toString(elems));
	}

}
