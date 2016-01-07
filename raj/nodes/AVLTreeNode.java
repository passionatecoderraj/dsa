/**
 * 
 */
package com.raj.nodes;

/**
 * @author Raj
 *
 */
public class AVLTreeNode<T> {
	public T data;
	public int height;
	public AVLTreeNode<T> left;
	public AVLTreeNode<T> right;

	public AVLTreeNode() {

	}

	public AVLTreeNode(T data, int height) {
		super();
		this.data = data;
		this.height = height;
		this.left = null;
		this.right = null;
	}

	public AVLTreeNode(T data) {
		super();
		this.data = data;
		this.left = null;
		this.right = null;
	}

	@Override
	public String toString() {
		return "AVLTreeNode [data=" + data + "]";
	}

}
