package com.raj.trees.binary;

import com.raj.nodes.BinaryTreeNode;

/**
 * 
 * @author Raj
 *
 *         Given an integer array with no duplicates. A maximum tree building on
 *         this array is defined as follow:
 * 
 *         The root is the maximum number in the array. The left subtree is the
 *         maximum tree constructed from left part subarray divided by the
 *         maximum number. The right subtree is the maximum tree constructed
 *         from right part subarray divided by the maximum number. Construct the
 *         maximum tree by the given array and output the root node of this
 *         tree.
 * 
 *         Example 1: Input: [3,2,1,6,0,5] Output: return the tree root node
 *         representing the following tree:
 * 
 *         6 / \ 3 5 \ / 2 0 \ 1
 */
public class MaximumBinaryTree {

	public BinaryTreeNode<Integer> constructMaximumBinaryTree(int[] a) {
		return constructMaximumBinaryTreeUtil(a, 0, a.length - 1);
	}

	public BinaryTreeNode<Integer> constructMaximumBinaryTreeUtil(int a[], int l, int r) {
		if (l > r) {
			return null;
		}
		int maxIndex = max(a, l, r);
		BinaryTreeNode<Integer> root = new BinaryTreeNode<>(a[maxIndex]);
		root.left = constructMaximumBinaryTreeUtil(a, l, maxIndex - 1);
		root.right = constructMaximumBinaryTreeUtil(a, maxIndex + 1, r);
		return root;
	}

	public int max(int a[], int l, int r) {
		int max = a[l], index = l;
		for (int i = l + 1; i <= r; i++) {
			if (a[i] > max) {
				max = a[i];
				index = i;
			}
		}
		return index;
	}

	public static void main(String args[]) {
		MaximumBinaryTree obj = new MaximumBinaryTree();
		int a[] = { 3, 2, 1, 6, 0, 5 };
		BinaryTreeNode<Integer> root = obj.constructMaximumBinaryTree(a);
		BinaryTree.levelOrder(root);
	}
}