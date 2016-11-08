/**
 * 
 */
package com.raj.trees.binary;

import com.raj.nodes.BinaryTreeNode;

/**
 * @author Raj
 *
 */
public class CountCompleteTreeNodes {

	public int countCompleteTreeNodes(BinaryTreeNode<Integer> root) {
		if (null == root)
			return 0;
		int lHeight = getLeftHeight(root) + 1;
		int rHeight = getRightHeight(root) + 1;

		if (lHeight == rHeight) {
			// 2^h - 1
			return (2 << (lHeight - 1)) - 1;
		} else {
			return 1 + countCompleteTreeNodes(root.left) + countCompleteTreeNodes(root.right);
		}
	}

	private int getLeftHeight(BinaryTreeNode<Integer> root) {
		if (null == root)
			return 0;

		int height = 0;
		while (root.left != null) {
			height++;
			root = root.left;
		}
		return height;
	}

	private int getRightHeight(BinaryTreeNode<Integer> root) {
		if (null == root)
			return 0;

		int height = 0;
		while (root.right != null) {
			height++;
			root = root.right;
		}
		return height;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CountCompleteTreeNodes obj = new CountCompleteTreeNodes();

		BinaryTree ob = new BinaryTree();
		ob.insert(1);
		ob.insert(2);
		ob.insert(3);
		ob.insert(4);
		ob.insert(5);
		ob.insert(6);
		// Time : O(h2)
		int result = -1;
		result = obj.countCompleteTreeNodes(ob.root);
		System.out.println(result);

	}

}
