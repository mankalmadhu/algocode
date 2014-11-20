package demo.datastructures.heap;

import demo.algos.sorting.SortUtil;

public class BinaryHeapForSort<T extends Comparable> {

	private T[] elems;

	private int curSize;

	@SuppressWarnings("unchecked")
	public BinaryHeapForSort(int capacity) {

		elems = (T[]) new Object[capacity];
	}

	public BinaryHeapForSort(T[] elems) {
		this.elems = elems;
		curSize = elems.length;
		batchInsert();
	}

	private void batchInsert() {

		for (int i = curSize / 2; i >= 0; i--) {
			moveDown(i, curSize);
		}

	}

	public void insert(T elem) {
		elems[curSize++] = elem;
		moveUp();
	}

	public T getMax() {

		SortUtil.exch(elems, 0, curSize - 1);

		T elem = elems[curSize - 1];

		// elems[curSize] = null;

		curSize--;

		moveDown(0, curSize - 1);

		return elem;
	}

	private void moveUp() {
		int elem = elems.length - 1;
		while ((elem >= 0) && (SortUtil.less(elems[elem / 2], elems[elem]))) {
			SortUtil.exch(elems, elem, elem / 2);
			elem = elem / 2;
		}
	}

	private void moveDown(int elem, int length) {

		while ((length > 0) && (2 * elem <= length)) {

			int child = elem != 0 ? 2 * elem : 1;

			if (child < length && (child + 1 < length)
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
