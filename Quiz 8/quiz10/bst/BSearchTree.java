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
		
		// if the root is null, then value is the new root
		if(this.root == null) {
			this.root = new BSTNode<E>(value,null,null); 
		}
		else {
			add(this.root,value);
		}
	}
	
	private void add(BSTNode<E> currentRoot, E value) {
		//if(currentRoot == null) {}
		if(value.compareTo(currentRoot.getData()) < 0) {
			if(currentRoot.getLeft() == null) {
				currentRoot.setLeft(new BSTNode<E>(value,null,null));
			}
			else {
				add(currentRoot.getLeft(),value);
			}
		}
		else {
			if(currentRoot.getRight() == null) {
				currentRoot.setRight(new BSTNode<E>(value,null,null));
			}
			else {
				add(currentRoot.getRight(),value);
			}
		}
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

		return find(this.root,value);
	}
	
	private boolean find(BSTNode<E> currentRoot, E value) {
		
		if(currentRoot.getData().equals(value)) {
			return true;
		}
		else if(value.compareTo(currentRoot.getData()) < 0){
			if(currentRoot.getLeft() == null) {return false;}
			return find(currentRoot.getLeft(),value);
		}
		else {
			if(currentRoot.getRight()== null) {return false;}
			return find(currentRoot.getRight(),value);
		}
		
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
		if(this.root.getData() == value) {
			if(root.getLeft() == null && root.getRight()== null) {
				this.root = null;
				return this.root;
			}
			else if(root.getLeft() != null && root.getRight() != null){
				BSTNode<E> newRoot = remove(value,this.root,null);
				newRoot.setLeft(this.root.getLeft());
				newRoot.setRight(this.root.getRight());
				this.root = newRoot;
				return this.root;
			}
			else if(root.getLeft() == null) {
				this.root = this.root.getRight();
				return this.root;
			}
			else {
				this.root = this.root.getLeft();
				return this.root;
			}
		}
		else if(this.root.getData().compareTo(value) < 0) {
			
		}
	}
	
	private BSTNode<E> traverse(BSTNode<E> node){
		
	}
	// returns node that points to the node we want to remove
	private BSTNode<E> remove(E value, BSTNode<E> currentNode, BSTNode<E> previousNode){
		if(currentNode == null) {
			return previousNode;
			}
		if(currentNode.getLeft() == null) {
			if(currentNode.getRight() != null) {
				previousNode.setLeft(currentNode.getRight());
				return currentNode;
			}
			else {
				previousNode.setLeft(null);
				return currentNode;
			}
		}
		else {
			return remove(value,currentNode.getLeft(),currentNode);
		}
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
