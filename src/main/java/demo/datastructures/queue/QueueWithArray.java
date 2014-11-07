package demo.datastructures.queue;

public class QueueWithArray<T> {

	private T[] elems;
	private final int initialSize = 16;

	private int curFirst;
	private int curLast;

	@SuppressWarnings("unchecked")
	public QueueWithArray() {
		elems = (T[]) new Object[initialSize];
	}

	public boolean isEmpty() {
		return curFirst == curLast;
	}

	public void enqueue(T entity) {

		if (curLast < elems.length) {
			elems[++curLast] = entity;
		} else {
			resize(curLast * 2);
			curLast = curLast - curFirst;
			curFirst = 0;

		}

	}

	public T dequeue() {
		T retElem = elems[curFirst];

		elems[curFirst++] = null;

		if ((curLast - curFirst) < (elems.length / 4)) {

			if ((curLast - curFirst) < initialSize) {
				resize(initialSize);
			} else {
				resize(elems.length / 2);
			}

		}

		return retElem;
	}

	private void resize(int size) {
		@SuppressWarnings("unchecked")
		T[] tempArr = (T[]) new Object[size];

		for (int i = 0; i < elems.length; i++) {

			tempArr[i] = elems[i];
		}

		elems = tempArr;
	}

}
