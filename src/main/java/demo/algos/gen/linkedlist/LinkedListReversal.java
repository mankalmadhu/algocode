package demo.algos.gen.linkedlist;

public class LinkedListReversal<T> {

	Node head;

	public LinkedListReversal() {

	}

	private void push(T[] elems) {

		for (int i = elems.length - 1; i >= 0; i--) {
			Node temp = new Node();
			temp.entity = elems[i];
			temp.next = head;
			head = temp;
		}

		System.out.println(this);

	}

	private void reverseIt() {

		Node prev = null;// Holds prev Node.
		Node next = null;// Temp variable to hold on to next of current.
		Node current = this.head;

		while (current != null) {
			// Need to nullify/change the 'next' of current. So back up the next
			// of current.
			next = current.next;
			// Change the currents next to prev.(Reverse link direction.)
			current.next = prev;
			// current is pointing to prev instead of next.So reversal done for
			// current . Move prev to next element.
			prev = current;
			// Move current to back up variable next.
			current = next;
		}

		// prev would be pointing to last node in list. Make it as head.
		this.head = prev;

		System.out.println(this);

	}

	private void reverseRec(Node curHead) {

		if (curHead == null) {
			return;
		}

		if (curHead.next == null) {
			this.head = curHead;
			return;
		}

		reverseRec(curHead.next);

		// Logic to make 1->3 to 3->1. Since it is a recursive call the other
		// elements are similarly taken care of.
		curHead.next.next = curHead;
		curHead.next = null;

		System.out.println(this);

	}

	@Override
	public String toString() {

		Node current = head;

		StringBuilder builder = new StringBuilder();

		while (current != null) {
			builder.append(current.entity);
			builder.append("->");
			current = current.next;
		}

		builder.deleteCharAt(builder.lastIndexOf("-"));
		builder.deleteCharAt(builder.lastIndexOf(">"));

		return builder.toString();
	}

	private class Node {

		T entity;
		Node next;

	}

	public static void main(String[] args) {
		LinkedListReversal<Integer> ll = new LinkedListReversal<Integer>();

		ll.push(new Integer[] { 1, 3, 5, 7 });

		ll.reverseIt();

		ll.reverseRec(ll.head);

	}

}
