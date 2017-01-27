/**
 * 
 */
package com.raj.trees.binary;

import java.util.ArrayList;
import java.util.List;

import com.raj.nodes.BinaryTreeNode;

/**
 * @author Raj
 *
 *         Given a binary tree, collect a tree's nodes as if you were doing
 *         this: Collect and remove all leaves, repeat until the tree is empty.
 * 
 *         Example: Given binary tree 1 / \ 2 3 / \ 4 5 Returns [4, 5, 3], [2],
 *         [1].
 * 
 *         Explanation: 1. Removing the leaves [4, 5, 3] would result in this
 *         tree:
 * 
 *         1 / 2 2. Now removing the leaf [2] would result in this tree:
 * 
 *         1 3. Now removing the leaf [1] would result in the empty tree:
 * 
 *         [] Returns [4, 5, 3], [2], [1].
 */
public class FindLeaveOfBinaryTree {

	public static List<List<Integer>> findLeaves(BinaryTreeNode<Integer> root) {
		List<List<Integer>> result = new ArrayList<>();
		if (null == root)
			return result;
		heightHelper(root, result);
		return result;
	}

	private static int heightHelper(BinaryTreeNode<Integer> root, List<List<Integer>> result) {
		if (null == root)
			return -1;
		int lheight = heightHelper(root.left, result);
		int rheight = heightHelper(root.right, result);
		int height = 1 + Math.max(lheight, rheight);

		// the first time this code is reached is when height==0,
		// since the tree is bottom-up processed.
		if (height >= result.size()) {
			result.add(new ArrayList<>());
		}

		result.get(height).add(root.data);
		return height;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		BinaryTree ob = new BinaryTree();
		ob.insert(1);
		ob.insert(2);
		ob.insert(3);
		ob.insert(4);
		ob.insert(5);

		BinaryTreeNode<Integer> root = ob.root;

		List<List<Integer>> result = null;
		result = findLeaves(root);
		System.out.println(result);

	}

}
