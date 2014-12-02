package demo.algos.sorting.heap;

import java.util.Arrays;

import demo.datastructures.heap.BinaryHeap;

public class HeapSort<T extends Comparable<T>> {

	private T[] elems;

	BinaryHeap<T> heap;

	public HeapSort(T[] elems) {

		this.elems = elems;
		heap = new BinaryHeap<T>(elems);

	}

	public void sort() {

		for (int i = elems.length - 1; i >=0; i--) {
			elems[i] = heap.getMax();
		}
	}

	public void printResult() {
		heap.printResult();
		System.out.println(Arrays.toString(elems));
	}

}
