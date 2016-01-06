/**
 * 
 */
package com.raj.trees.bst;

import com.raj.nodes.BinaryTreeNode;

/**
 * @author Raj
 *
 */
public class SortedArrayToBalancedBST {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int a[] = { 11, 12, 13, 14, 15, 16 };
		SortedArrayToBalancedBST ob = new SortedArrayToBalancedBST();

		// Time : O(n), Space : O(n)
		BinaryTreeNode<Integer> root = ob.arrayToBST(a, 0, a.length - 1);
		new BinarySearchTree().preOrder(root);
		System.out.println();
		new BinarySearchTree().inOrder(root);
		System.out.println();
	}

	public BinaryTreeNode<Integer> arrayToBST(int[] a, int start, int end) {
		if (start > end)
			return null;
		int mid = start + (end - start) / 2;
		BinaryTreeNode<Integer> node = new BinaryTreeNode<>(a[mid]);
		node.left = arrayToBST(a, start, mid - 1);
		node.right = arrayToBST(a, mid + 1, end);
		return node;
	}

}
