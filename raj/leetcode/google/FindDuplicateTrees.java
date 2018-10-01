package com.raj.leetcode.google;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.raj.nodes.BinaryTreeNode;
import com.raj.trees.binary.BinaryTree;

/**
 * @author Raj
 * 
 * Given a binary tree, return all duplicate subtrees. For each kind of duplicate subtrees, you only need to return the root node of any one of them.

Two trees are duplicate if they have the same structure with same node values.

Example 1:

        1
       / \
      2   3
     /   / \
    4   2   4
       /
      4
The following are two duplicate subtrees:

      2
     /
    4
and

    4
Therefore, you need to return above trees' root in the form of a list.
 */
public class FindDuplicateTrees {

	public List<BinaryTreeNode<Integer>> findDuplicateSubtrees(BinaryTreeNode<Integer> root) {
		List<BinaryTreeNode<Integer>> result = new ArrayList<>();
		Map<String, Integer> map = new HashMap<>();

		util(root, map, result);
		return result;
	}

	private String util(BinaryTreeNode<Integer> root, Map<String, Integer> map, List<BinaryTreeNode<Integer>> result) {
		if (null == root)
			return "#";
		String pre = root.data + "," + util(root.left, map, result) + "," + util(root.right, map, result);
		if (map.containsKey(pre) && map.get(pre) == 1) {
			result.add(root);
		}
		map.compute(pre, (k, v) -> {
			if (null == v)
				v = 0;
			return v + 1;
		});

		return pre;
	}

	public static void main(String[] args) {

		FindDuplicateTrees obj = new FindDuplicateTrees();
		List<BinaryTreeNode<Integer>> result = null;
		BinaryTreeNode<Integer> node = makeTree();
		result = obj.findDuplicateSubtrees(node);
		for (BinaryTreeNode<Integer> n : result) {
			BinaryTree.postOrder(n);System.out.println();
			BinaryTree.inOrder(n);
			System.out.println();
		}

	}

	private static BinaryTreeNode<Integer> makeTree() {
		BinaryTreeNode<Integer> r1 = new BinaryTreeNode<Integer>(1);
		BinaryTreeNode<Integer> r2 = new BinaryTreeNode<Integer>(2);
		BinaryTreeNode<Integer> r3 = new BinaryTreeNode<Integer>(3);
		BinaryTreeNode<Integer> r4 = new BinaryTreeNode<Integer>(4);
		BinaryTreeNode<Integer> r4_2 = new BinaryTreeNode<Integer>(4);
		BinaryTreeNode<Integer> r4_3 = new BinaryTreeNode<Integer>(4);
		BinaryTreeNode<Integer> r2_2 = new BinaryTreeNode<Integer>(2);

		r1.left = r2;
		r1.right = r3;
		r2.left = r4;

		r3.left = r2_2;
		r3.right = r4_2;
		r2_2.left = r4_3;
		return r1;
	}

}
