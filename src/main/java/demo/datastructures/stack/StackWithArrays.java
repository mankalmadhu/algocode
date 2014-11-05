package demo.datastructures.stack;

public class StackWithArrays<T> {

	private final int initialSize = 16;
	private T[] elems;

	private int curStackTop = 0;

	@SuppressWarnings("unchecked")
	public StackWithArrays() {
		elems = (T[]) new Object[initialSize];
	}

	public boolean isEmpty() {
		return elems.length == 0;
	}

	public T pop() {
		T ret = elems[curStackTop];
		elems[curStackTop--] = null;

		if ((curStackTop > initialSize) && (curStackTop <= (elems.length / 4))) {
			sizeDown();
		}

		return ret;
	}

	public void push(T entity) {

		if (curStackTop < elems.length) {
			elems[curStackTop++] = entity;

		} else {
			sizeUp();
		}

		elems[curStackTop++] = entity;
	}

	private void sizeUp() {
		resize(curStackTop * 2);

	}

	private void sizeDown() {
		resize(curStackTop / 2);

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
