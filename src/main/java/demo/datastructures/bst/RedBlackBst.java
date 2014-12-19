package demo.datastructures.bst;


public class RedBlackBst<T extends Comparable<T>> extends BinarySearchTree<T> {

	private Node put(T elem, Node x) {

		if (x == null) {
			x = new Node();
			x.entity = elem;
			x.count = 1;
			x.isRed = true;

		} else {

			int compareResult = elem.compareTo(x.entity);

			if (compareResult < 0) {
				x.left = put(elem, x.left);
			} else if (compareResult > 0) {
				x.right = put(elem, x.right);
			}

			if (x.right.isRed && !x.left.isRed) {
				x = turnLeft(x);
			}

			if (x.left.isRed && x.left.left.isRed) {
				x = turnRight(x);
			}

			if (x.left.isRed && x.right.isRed) {
				flipColors(x);
			}

			x.count = 1 + size(x.left) + size(x.right);
		}

		return x;

	}

	/**
	 * @param x
	 * 
	 *            1) Store cur nodes right node in temp.
	 * 
	 *            2) Detach left children from right node and attach it as
	 *            current nodes right node. (this between link in 2 node).
	 * 
	 *            3) Set original nodes right child to have original node as
	 *            left child.
	 * 
	 *            4) Original nodes right child should have same color as
	 *            original node.
	 * 
	 *            5) Original node should be red. (left leaning).
	 * 
	 */
	private Node turnLeft(Node x) {
		Node t = x.right;
		x.right = t.left;
		t.left = x;
		t.isRed = x.isRed;
		x.isRed = true;

		return t;

	}

	private Node turnRight(Node x) {
		Node t = x.left;
		x.left = t.right;
		t.right = x;
		t.isRed = x.isRed;
		x.isRed = true;

		return t;
	}

	private void flipColors(Node x) {
		x.isRed = !x.isRed;
		x.left.isRed = !x.left.isRed;
		x.right.isRed = !x.right.isRed;
	}

}
