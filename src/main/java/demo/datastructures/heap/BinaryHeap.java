package demo.datastructures.heap;

import java.util.Arrays;

import demo.algos.sorting.SortUtil;

public class BinaryHeap<T extends Comparable> {

	private T[] elems;

	private int curEnd;

	public BinaryHeap(T[] input) {
		elems = (T[]) new Comparable[input.length + 1];
		batchInsert(input);
	}

	private void batchInsert(T[] input) {

		for (int i = 0; i < input.length; i++) {
			insert(input[i]);
		}

	}

	public void insert(T elem) {
		elems[++curEnd] = elem;
		moveUp();

	}

	public void printResult() {
		System.out.println(Arrays.toString(elems));
	}

	public T getMax() {

		SortUtil.exch(elems, 1, curEnd);

		T elem = elems[curEnd];

		elems[curEnd--] = null;

		moveDown(1);

		return elem;
	}

	private void moveUp() {
		int elem = curEnd;
		while ((elem > 1) && (SortUtil.less(elems, elem / 2, elem))) {
			SortUtil.exch(elems, elem, elem / 2);
			elem = elem / 2;
		}
	}

	private void moveDown(int elem) {

		while (2 * elem <= curEnd) {
			int child = 2 * elem;

			if (((child + 1) <= curEnd)
					&& (SortUtil.less(elems, child, child + 1))) {
				child++;
			}

			if (SortUtil.less(elems, child, elem)) {
				break;
			}

			SortUtil.exch(elems, child, elem);
			elem = child;
		}

	}

}
