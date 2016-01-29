/**
 * 
 */
package com.raj.nodes;

/**
 * @author Raj
 *
 */
public class BinaryTreeNode<T> {
	public T data;
	public BinaryTreeNode<T> left;
	public BinaryTreeNode<T> right;

	public BinaryTreeNode() {

	}

	
	public BinaryTreeNode(T data, BinaryTreeNode<T> left, BinaryTreeNode<T> right) {
		super();
		this.data = data;
		this.left = left;
		this.right = right;
	}


	public BinaryTreeNode(T data) {
		super();
		this.data = data;
		this.left = null;
		this.right = null;
	}

	@Override
	public String toString() {
		return "BinaryTreeNode [data=" + data + "]";
	}

}
