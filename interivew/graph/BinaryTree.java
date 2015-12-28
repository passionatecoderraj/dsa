/**
 * 
 */
package com.interivew.graph;

/**
 * @author Raj
 *
 */
public class BinaryTree {

	public static boolean isLeaf(BinaryTreeNode<Integer> root) {
		return root.left == null && root.right == null;
	}

	public static int height(BinaryTreeNode<Integer> root) {
		if (null == root)
			return 0;
		else {
			int l = height(root.left);
			int r = height(root.right);
			return 1 + (l > r ? l : r);
		}
	}

}
