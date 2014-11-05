package demo.datastructures.stack;

public class StackWithLinkedList<T> {

	Node first;

	public boolean isEmpty() {
		return first == null;
	}

	public T pop() {
		Node ret = first;
		first = first.next;

		return ret.entity;
	}

	public void push(T entity) {
		Node newNode = new Node();
		newNode.entity = entity;

		newNode.next = first;
		first = newNode;
	}

	private class Node {
		T entity;
		Node next;
	}
}
