package com.raj.trees.binary;

import com.raj.nodes.BinaryTreeNode;

/**
 * @author Raj
 * 
 *         Given a binary tree, find its minimum depth.
 * 
 *         The minimum depth is the number of nodes along the shortest path from
 *         the root node down to the nearest leaf node.
 */
public class MinimumDepthOfBinaryTree {

	// Time : O(n)
	// https://discuss.leetcode.com/topic/8723/my-4-line-java-solution
	public int minDepth(BinaryTreeNode<Integer> root) {
		if (null == root)
			return 0;
		int left = minDepth(root.left);
		int right = minDepth(root.left);
		return (left == 0 || right == 0) ? left + right + 1 : 1 + Math.min(minDepth(root.left), minDepth(root.right));
	}

	public static void main(String args[]) {
		MinimumDepthOfBinaryTree obj = new MinimumDepthOfBinaryTree();
		BinaryTree ob = new BinaryTree();
		ob.insert(1);
		ob.insert(2);
		ob.insert(3);
		ob.insert(4);
		ob.insert(5);
		ob.insert(6);
		ob.insert(7);
		ob.insert(8);

		int res = -1;
		res = obj.minDepth(ob.root);
		System.out.println(res);
	}
}