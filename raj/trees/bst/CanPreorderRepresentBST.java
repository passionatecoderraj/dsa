/**
 * 
 */
package com.raj.trees.bst;

import com.raj.nodes.BinaryTreeNode;

/**
 * @author Raj
 *
 */
public class CanPreorderRepresentBST {

	int preOrderIndex = 0;

	public boolean canPreorderRepresentBST(int[] a) {
		preOrderIndex = 0;
		buildBSTFromPreOrder(a, Integer.MIN_VALUE, Integer.MAX_VALUE);
		return preOrderIndex == a.length;
	}

	private BinaryTreeNode<Integer> buildBSTFromPreOrder(int[] a, int min, int max) {
		if (preOrderIndex == a.length)
			return null;
		int data = a[preOrderIndex];
		if (data > min && data < max) {
			preOrderIndex++;
			BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(data);
			root.left = buildBSTFromPreOrder(a, min, data);
			root.right = buildBSTFromPreOrder(a, data, max);
		}
		return null;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CanPreorderRepresentBST obj = new CanPreorderRepresentBST();

		boolean result = false;
		result = obj.canPreorderRepresentBST(new int[] { 2, 4, 3 });
		System.out.println(result);

		result = obj.canPreorderRepresentBST(new int[] { 40, 30, 35, 20, 80, 100 });
		System.out.println(result);

	}

}
