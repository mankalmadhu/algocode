package demo.datastructures.bst;

public class RedBlackBst<T extends Comparable<T>> extends BinarySearchTree<T> {

	protected Node put(T elem, Node x) {

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
	 *            1) Store x.right in 't'.(This would become local root at end
	 *            of operation).
	 * 
	 *            2) Detach t.left and attach to x.right.
	 * 
	 *            3) Make x t.left.(The flip happens).
	 * 
	 *            4) Copy color of t.left to t(t.left is original passed in node
	 * 
	 *            5) 'x' (original passed in node) should be red.
	 * 
	 */
	private Node turnLeft(Node x) {
		Node t = x.right;
		x.right = t.left;
		t.left = x;
		t.isRed = t.left.isRed;
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
