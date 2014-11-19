package demo.datastructures.heap;

import demo.algos.sorting.SortUtil;

public class BinaryHeap<T extends Comparable> {

	private T[] elems;

	private int curSize;

	@SuppressWarnings("unchecked")
	public BinaryHeap(int capacity) {
		elems = (T[]) new Object[capacity];
	}
	
	public BinaryHeap(T[] elems) {
		this.elems=elems.clone();
		batchInsert(elems);
	}

	private void batchInsert(T[] bacthInput) {

		for (T elem : bacthInput) {
			insert(elem);
		}

	}

	public void insert(T elem) {
		elems[curSize++] = elem;
		moveUp();
	}

	public T getMax() {
		SortUtil.exch(elems, 0, curSize);

		T elem = elems[curSize];

		elems[curSize--] = null;

		moveDown();

		return elem;
	}

	private void moveUp() {
		int elem = elems.length - 1;
		while ((elem >= 0) && (SortUtil.less(elems[elem / 2], elems[elem]))) {
			SortUtil.exch(elems, elem, elem / 2);
			elem = elem / 2;
		}
	}

	private void moveDown() {
		int elem = 0;

		while (elem <= elems.length - 1) {

			if (SortUtil.less(elems[2 * elem], elems[elem])
					&& SortUtil.less(elems[2 * elem + 1], elems[elem])) {
				break;
			}

			SortUtil.exch(elems, SortUtil.less(elems[2 * elem],
					elems[2 * elem + 1]) ? 2 * elem + 1 : 2 * elem, elem);

		}
	}

}
