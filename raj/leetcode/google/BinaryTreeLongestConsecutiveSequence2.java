/**
 * 
 */
package com.raj.leetcode.google;

import com.raj.nodes.BinaryTreeNode;
import com.raj.trees.binary.BinaryTree;

/**
 * @author Raj
 *
 *         Given a binary tree, find the length of the longest consecutive
 *         sequence path.
 * 
 *         The path refers to any sequence of nodes from some starting node to
 *         any node in the tree along the parent-child connections. The longest
 *         consecutive path need to be from parent to child (cannot be the
 *         reverse).
 * 
 *         For example, 1 \ 3 / \ 2 4 \ 5 Longest consecutive sequence path is
 *         3-4-5, so return 3.
 * 
 *         2 \ 3 / 2 / 1 Longest consecutive sequence path is 2-3,not3-2-1, so
 *         return 2.
 */
public class BinaryTreeLongestConsecutiveSequence2 {

	// Time : O(n), Space : O(n)
	public static int longestConsecutive(BinaryTreeNode<Integer> root) {
		if (null == root)
			return 0;
		int res[] = new int[1];
		helper(root, res);
		return res[0];
	}

	private static int[] helper(BinaryTreeNode<Integer> root, int[] res) {
		if (null == root) {
			return new int[] { 0, 0 };
		}
		int[] left = helper(root.left, res);
		int[] right = helper(root.left, res);
		int incr = 1, decr = 1;
		if (root.left != null) {
			if (root.left.data == root.data + 1) {
				incr = left[1] + 1;
			}
			if (root.left.data == root.data - 1) {
				decr = left[0] + 1;
			}
		}

		if (root.right != null) {
			if (root.right.data == root.data + 1) {
				incr = Math.max(right[1] + 1, incr);
			}
			if (root.right.data == root.data - 1) {
				decr = Math.max(right[0] + 1, decr);
			}
		}
		res[0] = Math.max(res[0], incr + decr - 1);
		return new int[] { decr, incr };
	}

	public static void main(String[] args) {

		BinaryTree ob = new BinaryTree();
		ob.insert(2);
		ob.insert(1);
		ob.insert(3);
		BinaryTree.levelOrder(ob.root);
		int result = -1;
		result = longestConsecutive(ob.root);
		System.out.println(result);

	}

}
