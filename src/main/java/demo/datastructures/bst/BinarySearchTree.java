package demo.datastructures.bst;

import demo.algos.sorting.SortUtil;

public class BinarySearchTree<T extends Comparable> {

	Node root;

	public void put(T elem) {
		put(elem, root);
	}

	private void put(T elem, Node parent) {

		if (parent == null) {
			parent = new Node();
			parent.entity = elem;
		} else {
			if (SortUtil.less(elem, parent.entity)) {
				parent = parent.left;
			} else {
				parent = parent.right;
			}
			put(elem, parent);
		}

	}

	public T get(T elem) {

		T retVal = null;

		Node parent = root;

		if (parent != null) {
			while (parent != null) {
				if (elem.compareTo(parent) < 0) {
					parent = parent.left;
				} else if (elem.compareTo(parent) > 0) {
					parent = parent.right;
				} else {
					retVal = parent.entity;
				}
			}
		}

		return retVal;

	}

	private class Node {

		T entity;

		Node left;

		Node right;

		int count;

	}
}
