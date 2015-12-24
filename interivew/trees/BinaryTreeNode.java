package com.interivew.trees;

public class BinaryTreeNode<T> {
	public T data;
	public BinaryTreeNode<T> left;
	public BinaryTreeNode<T> right;

	public BinaryTreeNode() {
		this.left = null;
		this.right = null;
	}

	public BinaryTreeNode(T data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}

	public BinaryTreeNode(T data, BinaryTreeNode<T> left, BinaryTreeNode<T> right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}

}
