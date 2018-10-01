package com.raj.leetcode.google;

import java.util.Arrays;

import com.raj.nodes.BinaryTreeNode;
import com.raj.trees.bst.BinarySearchTree;

/**
 * @author Raj
 * 
 * Given a Binary Search Tree (BST) with root node root, and a target value V, split the tree into two subtrees where one subtree has nodes that are all smaller or equal to the target value, while the other subtree has all nodes that are greater than the target value.  It's not necessarily the case that the tree contains a node with value V.

Additionally, most of the structure of the original tree should remain.  Formally, for any child C with parent P in the original tree, if they are both in the same subtree after the split, then node C should still have the parent P.

You should output the root TreeNode of both subtrees after splitting, in any order.

Example 1:

Input: root = [4,2,6,1,3,5,7], V = 2
Output: [[2,1],[4,3,6,null,null,5,7]]
Explanation:
Note that root, output[0], and output[1] are TreeNode objects, not arrays.

The given tree [4,2,6,1,3,5,7] is represented by the following diagram:

          4
        /   \
      2      6
     / \    / \
    1   3  5   7

while the diagrams for the outputs are:

          4
        /   \
      3      6      and    2
            / \           /
           5   7         1
Note:

The size of the BST will not exceed 50.
The BST is always valid and each node's value is different.

 */
public class SplitBST {

	//https://leetcode.com/problems/split-bst/discuss/114861/Java-Recursion-in-O(logn)
	// Time : O(logn)
	public BinaryTreeNode[] splitBST(BinaryTreeNode<Integer> root, int V) {
		if (null == root) {
			BinaryTreeNode[] res = new BinaryTreeNode[2];
			return new BinaryTreeNode[] { null, null };
		}

		BinaryTreeNode[] res;
		if (root.data > V) {
			res = splitBST(root.left, V);
			root.left = res[1];
			res[1] = root;
		} else {
			res = splitBST(root.right, V);
			root.right = res[0];
			res[0] = root;
		}
		return res;
	}

	public static void main(String[] args) {

		SplitBST obj = new SplitBST();
		BinarySearchTree tree = new BinarySearchTree();
		tree.root = tree.insert(tree.root, 8);
		tree.root = tree.insert(tree.root, 3);
		tree.root = tree.insert(tree.root, 10);
		tree.root = tree.insert(tree.root, 1);
		tree.root = tree.insert(tree.root, 6);
		tree.root = tree.insert(tree.root, 14);
		tree.root = tree.insert(tree.root, 4);
		tree.root = tree.insert(tree.root, 7);
		tree.root = tree.insert(tree.root, 13);

		BinaryTreeNode<Integer>[] result = obj.splitBST(tree.root, 7);

		System.out.println(Arrays.toString(result));
		tree.postOrder(result[0]);
		System.out.println();
		tree.postOrder(result[1]);
	}

}
