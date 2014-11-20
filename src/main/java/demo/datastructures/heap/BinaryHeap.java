package demo.datastructures.heap;

import demo.algos.sorting.SortUtil;

public class BinaryHeap<T extends Comparable> {

	private T[] elems;

	private int curEnd = 0;

	@SuppressWarnings("unchecked")
	public BinaryHeap(int capacity) {

		elems = (T[]) new Comparable[capacity];
	}

	public BinaryHeap(T[] input) {
		elems = (T[]) new Comparable[input.length];
		batchInsert(input);
	}

	private void batchInsert(T[] input) {

		for (int i = 0; i < input.length; i++) {
			insert(input[i]);
		}

	}

	public void insert(T elem) {
		elems[curEnd] = elem;
		moveUp();
		curEnd++;
	}

	public T getMax() {

		SortUtil.exch(elems, 0, curEnd-1);

		T elem = elems[curEnd-1];

		elems[curEnd-1] = null;
		
		curEnd--;

		moveDown();

		return elem;
	}

	private void moveUp() {
		int elem = curEnd;
		while ((elem > 0) && (SortUtil.less(elems[elem / 2], elems[elem]))) {
			SortUtil.exch(elems, elem, elem / 2);
			elem = elem / 2;
		}
	}

	private void moveDown() {

		int elem = 0;

		while ((curEnd > 0) && (2 * elem <= curEnd)) {

			int child = elem != 0 ? 2 * elem : 1;

			if (child < curEnd && (child + 1 < curEnd)
					&& (SortUtil.less(elems[child], elems[child + 1]))) {
				child++;
			}

			if (SortUtil.less(elems[child], elems[elem])) {
				break;
			}
			SortUtil.exch(elems, child, elem);
			elem = child;

		}
	}
}
