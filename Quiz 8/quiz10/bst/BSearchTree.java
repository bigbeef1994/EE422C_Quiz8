/**
 * EE422C Quiz  submission by
 * Daniel Li, bl22782
 * Andy Hoang, ath857
 * 
 */

package quiz10.bst;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <p>
 * In this quiz, you are asked to implement Binary Search Tree using iteration
 * and recursion.
 * </p>
 * <p>
 * Replacing TODO with your implementation. Don't change any other things,
 * including package, class, or method declaration. Your submission should not
 * have any generic warnings.
 * </p>
 * <p>
 * Only submit your BSearchTree.java file.
 * </p>
 */
public class BSearchTree<E extends Comparable<E>> {

	private BSTNode<E> root;

	public BSearchTree() {
		this.root = null;
	}

	public BSearchTree(E[] arr) {
		for (E v : arr)
			add(v);
	}

	/**
	 * BST insert method
	 *
	 * @param root
	 *            BST root node
	 * @param value
	 *            the inserted value, allow duplicate values.
	 */
	public void add(E value) {
		// TODO Implement this method using recursion
	}

	/**
	 * Find method in BST
	 *
	 * @param root
	 *            BST root
	 * @param value
	 *            searched value
	 * @return true if the value is found in the BST
	 */
	public boolean find(E value) {
		// TODO implement this method using recursion
		return false;
	}

	/**
	 * BST remove method
	 *
	 * @param root
	 *            BST root node
	 * @param value
	 * @return tree root
	 */
	public BSTNode<E> remove(E value) {
		// TODO implement this method using iteration
		return root;
	}

	public BSTNode<E> getRoot() {
		return root;
	}

	// DO NOT CHANGE THIS METHOD
	public String toString() {
		if (root == null)
			return "";
		String str = "";
		Queue<BSTNode<E>> q = new LinkedList<BSTNode<E>>();
		q.add(root);
		while (!q.isEmpty()) {
			BSTNode<E> n = q.poll();
			str += n.toString() + " ";
			if (n.left != null)
				q.add(n.left);
			if (n.right != null)
				q.add(n.right);
		}
		return str;
	}
}
