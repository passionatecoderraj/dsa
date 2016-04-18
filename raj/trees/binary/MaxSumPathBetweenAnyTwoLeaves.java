/**
 * 
 */
package com.raj.trees.binary;

import com.raj.nodes.BinaryTreeNode;

/**
 * @author Raj
 *
 */
public class MaxSumPathBetweenAnyTwoLeaves {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MaxSumPathBetweenAnyTwoLeaves obj = new MaxSumPathBetweenAnyTwoLeaves();

		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(-5);
		root.left = new BinaryTreeNode<Integer>(1);
		root.right = new BinaryTreeNode<Integer>(4);
		root.left.left = new BinaryTreeNode<Integer>(-6);
		root.left.right = new BinaryTreeNode<Integer>(5);
		root.left.right.left = new BinaryTreeNode<Integer>(-2);
		root.left.right.right = new BinaryTreeNode<Integer>(3);
		root.left.left.left = new BinaryTreeNode<Integer>(9);
		root.left.left.right = new BinaryTreeNode<Integer>(10);
		root.right.left = new BinaryTreeNode<Integer>(11);
		root.right.right = new BinaryTreeNode<Integer>(-2);
		root.right.right.right = new BinaryTreeNode<Integer>(-8);
		root.right.right.left = new BinaryTreeNode<Integer>(7);
		root.right.right.right.left = new BinaryTreeNode<Integer>(1);
		root.right.right.right.right = new BinaryTreeNode<Integer>(7);
		root.right.right.right.right.left = new BinaryTreeNode<Integer>(12);

		obj.maxSumPathBetweenAnyTwoLeaves(root);
		System.out.println(obj.maxSoFar);
	}

	int maxSoFar = Integer.MIN_VALUE;

	public int maxSumPathBetweenAnyTwoLeaves(BinaryTreeNode<Integer> root) {
		if (null == root)
			return 0;
		int left = maxSumPathBetweenAnyTwoLeaves(root.left);
		int right = maxSumPathBetweenAnyTwoLeaves(root.right);
		int cur = Math.max(left + right + root.data, Math.max(left, right));
		this.maxSoFar = Math.max(cur, maxSoFar);

		return root.data + Math.max(left, right);
	}
}
