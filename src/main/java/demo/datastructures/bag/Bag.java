package demo.datastructures.bag;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Bag<T> implements Iterable<T> {

	private Node first;

	private int size;

	private class Node {
		T entity;
		Node next;
	}

	public void add(T entity) {

		Node n = new Node();
		n.entity = entity;

		n.next = first;
		first = n;

		size++;

	}
	
	public boolean isEmpty(){
		return first==null;
	}

	@Override
	public Iterator<T> iterator() {

		return new ListIterator(first);
	}

	private class ListIterator implements Iterator<T> {
		private Node current;

		public ListIterator(Node first) {
			current = first;
		}

		public boolean hasNext() {
			return current != null;
		}

		public void remove() {
			throw new UnsupportedOperationException();
		}

		public T next() {
			if (!hasNext())
				throw new NoSuchElementException();
			T item = current.entity;
			current = current.next;
			return item;
		}
	}
}
