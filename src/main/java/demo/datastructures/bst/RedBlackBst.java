package demo.datastructures.bst;

public class RedBlackBst<T extends Comparable<T>> extends BinarySearchTree<T> {

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
	private void turnLeft(Node x) {
		Node t = x.right;
		x.right = t.left;
		t.left = x;
		t.isRed = x.isRed;
		x.isRed = true;

	}

	private void turnRight(Node x) {
		Node t = x.left;
		x.left = t.right;
		t.right = x;
		t.isRed = x.isRed;
		x.isRed = true;
	}

	private void flipColors(Node x) {
		x.isRed = !x.isRed;
		x.left.isRed = !x.left.isRed;
		x.right.isRed = !x.right.isRed;
	}

}
