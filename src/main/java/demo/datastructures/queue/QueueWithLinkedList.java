package demo.datastructures.queue;

public class QueueWithLinkedList<T> {

	private Node first;

	private Node last;

	private int size;

	public boolean isEmpty() {
		return first == null;
	}

	public void enueue(T entity) {
		Node newNode = new Node();
		newNode.entity = entity;

		if (isEmpty()) {
			first = newNode;
		} else {
			last.next = newNode;
		}
		last = newNode;
		size++;

	}

	public T dequeue() {

		if (!isEmpty()) {

			Node retNode = first;
			first = first.next;
			size--;
			return retNode.entity;
		}

		if (size == 0) {
			last = null;
		}

		return null;

	}

	private class Node {
		T entity;
		Node next;
	}

}
