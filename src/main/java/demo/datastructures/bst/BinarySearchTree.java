package demo.datastructures.bst;

/**
 * @author mankalmadhu
 *
 * @param <T>
 */
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

	/**
	 * 
	 * 1) If compareResult is '0' then 'x' is floor.
	 * 
	 * 2) If compareResult is <0 then search in left subtree.
	 * 
	 * 3) If compareResult is >0. Store current node in temp. See if right
	 * subtree has a minimum recursively. Rescursion will take care to go left
	 * or right accordingly.
	 * 
	 * @param elem
	 * @param x
	 * @return
	 */
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

	public Node min(Node x) {

		if (x == null) {
			x = root;
		}

		while (true) {
			if (x.left == null) {
				return x;
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

	/**
	 * Kth minimum element
	 * 
	 * @param k
	 * @return
	 */
	public T select(int k) {
		return select(k, root);
	}

	private T select(int k, Node x) {

		int leftSubTreeNodes = x.left.count;

		if (leftSubTreeNodes > k) {
			return select(k, x.left);
		} else if (leftSubTreeNodes < k) {
			return select(k - leftSubTreeNodes - 1, x.right);
		} else {
			return x.entity;
		}

	}

	public T deleteMin() {
		return deleteMin(root).entity;
	}

	/**
	 * 1) Find element with no left child.
	 * 
	 * 2) Return the right element of the node (which would become left node of
	 * the parent due to recursive call:x.left = deleteMin(x.left);
	 * 
	 * 3) After final recursion the element itself has no reference in tree.
	 * 
	 * 4) If x.right is null then x.left in higher recursive call becomes null,
	 * effectively deleting the element.
	 * 
	 * @param x
	 * @return
	 */
	private Node deleteMin(Node x) {
		if (x.left == null) {
			return x.right;
		}

		x.left = deleteMin(x.left);
		x.count = 1 + size(x.left) + size(x.right);

		return x;
	}

	public void delete(T entity) {
		delete(root, entity);
	}

	/**
	 * Covers 3 cases :
	 * 
	 * 1) Node has no children : final recursion returns null so in higher
	 * recursion assignment x.left = delete(x.left, entity) (or x.right) would
	 * be set as 'null'. So effectively node is deleted.
	 * 
	 * 2) Node has one children. Similar to above. In this case the non-null
	 * child would be assigned to 'x.left' or 'x.right' in final recursion and
	 * 'x' is effectively deleted.
	 * 
	 * 3) Node has two children :
	 * 
	 * a) Store the node in temp 't'.
	 * 
	 * b) Find the successor of 't' (i.e. a min call to t.right subtree).Point
	 * 'x' to successor.
	 * 
	 * c) Call deleteMin operation on t.right subtree and the returned node
	 * would be x.right.Whatever on right before delete for successor would be back on right again.
	 * 
	 * d) x.left would be t.left(No changes in left subtree).
	 * 
	 * 
	 * @param x
	 * @param entity
	 * @return
	 */
	public Node delete(Node x, T entity) {

		int compareResult = entity.compareTo(x.entity);

		if (compareResult < 0) {
			return x.left = delete(x.left, entity);
		} else if (compareResult > 0) {
			return x.right = delete(x.right, entity);
		} else {

			if (x.left == null) {
				return x.right;
			} else if (x.right == null) {
				return x.left;
			}

			Node t = x;

			x = min(t.right);
			x.right = deleteMin(t.right);
			x.left = t.left;

			x.count = 1 + size(x.left) + size(x.right);

			return x;
		}

	}

	protected class Node {

		T entity;

		Node left;

		Node right;

		int count;
		
		boolean isRed=false;

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
		System.out.println(bt.min(null));
		System.out.println(bt.select(5));

	}
}
