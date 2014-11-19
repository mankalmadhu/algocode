package demo.algos.sorting.heap;

import java.util.Arrays;

import demo.datastructures.heap.BinaryHeap;

public class HeapSort<T extends Comparable> {

	private T[] elems;

	public HeapSort(T[] elems) {

		this.elems = elems;

	}

	public void sort() {

		BinaryHeap<T> heap = new BinaryHeap<T>(elems);

		for (int i = elems.length - 1; i > 0; i--) {
			elems[i] = heap.getMax();
		}

	}

	public void printResult() {
		System.out.println(Arrays.toString(elems));
	}

}
