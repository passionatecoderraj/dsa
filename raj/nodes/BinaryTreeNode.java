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
