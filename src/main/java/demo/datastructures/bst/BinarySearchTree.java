package demo.datastructures.bst;

public class BinarySearchTree<T extends Comparable<T>> {

	Node root;

	public void put(T elem) {
		root = put(elem, root);
	}

	private Node put(T elem, Node x) {

		if (x == null) {
			x = new Node();
			x.entity = elem;
			x.count = 1;

		} else {

			int compareResult = elem.compareTo(x.entity);

			if (compareResult < 0) {
				x.left = put(elem, x.left);
			} else if (compareResult > 0) {
				x.right = put(elem, x.right);
			}

			x.count = 1 + size(x.left) + size(x.right);
		}

		return x;

	}

	public T get(T elem) {

		T retVal = null;

		Node x = root;

		while (x != null) {

			int compareResult = elem.compareTo(x.entity);

			if (compareResult < 0) {
				x = x.left;
			} else if (compareResult > 0) {
				x = x.right;
			} else {
				retVal = x.entity;
				break;
			}
		}

		return retVal;

	}

	public void printTree() {

		if (root != null) {
			System.out.println("Root Is :" + root.entity);
		}
		printTree(root);
	}

	private void printTree(Node x) {

		if (x == null) {
			return;
		}

		printTree(x.left);
		System.out.println(x);
		printTree(x.right);

	}

	public int size() {

		return size(root);
	}

	private int size(Node x) {
		int size = 0;
		if (x != null) {
			size = x.count;
		}

		return size;

	}

	public int height() {
		return height(root);
	}

	private int height(Node x) {

		if (x == null) {
			return -1;
		}

		return 1 + Math.max(height(x.left), height(x.right));

	}

	public T floor(T elem) {
		Node retVal = floor(elem, root);

		if (retVal != null) {
			return retVal.entity;
		}

		return null;

	}

	public Node floor(T elem, Node x) {
		Node retVal = null;

		while (x != null) {
			int compareVal = elem.compareTo(x.entity);

			if (compareVal == 0) {
				retVal = x;
				break;
			} else if (compareVal < 0) {
				retVal = floor(elem, x.left);
			} else {
				Node rightSideNode = floor(elem, x.right);
				if (rightSideNode != null) {
					retVal = rightSideNode;
				} else {
					retVal = x;
				}

			}
		}

		return retVal;
	}

	public T max() {

		Node x = root;
		while (true) {
			if (x.right == null) {
				return x.entity;
			}
			x = x.right;
		}
	}
	
	
	
	public T min() {

		Node x = root;
		while (true) {
			if (x.left == null) {
				return x.entity;
			}
			x = x.left;
		}
	}


	public int rank(T elem) {
		return rank(elem, root);
	}

	private int rank(T elem, Node x) {

		int compareVal = elem.compareTo(x.entity);

		if (compareVal == 0) {
			return size(x.left);
		} else if (compareVal < 0) {
			return rank(elem, x.left);
		} else {
			return 1 + size(x.left) + rank(elem, x.right);
		}

	}

	private class Node {

		T entity;

		Node left;

		Node right;

		int count;

		@Override
		public String toString() {

			return this.entity + ":" + count;
		}

	}

	public static void main(String[] args) {

		int[] input = new int[] { 4, 6, 2, 5, 1, 3 };

		BinarySearchTree<Integer> bt = new BinarySearchTree<Integer>();

		for (int i : input) {
			bt.put(i);
		}

		System.out.println(bt.height());
		System.out.println(bt.max());
		System.out.println(bt.min());

	}
}
