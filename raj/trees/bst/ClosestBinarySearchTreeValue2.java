package com.raj.trees.bst;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import com.raj.nodes.BinaryTreeNode;

/**
 * 
 * @author Raj
 * 
 * Given a non-empty binary search tree and a target value, find k values in the BST that are closest to the target.

Note:

Given target value is a floating point.
You may assume k is always valid, that is: k ≤ total nodes.
You are guaranteed to have only one unique set of k values in the BST that are closest to the target.
Example:

Input: root = [4,2,5,1,3], target = 3.714286, and k = 2

    4
   / \
  2   5
 / \
1   3

Output: [4,3]
Follow up:
Assume that the BST is balanced, could you solve it in less than O(n) runtime (where n = total nodes)?


 */
public class ClosestBinarySearchTreeValue2 {

	// https://leetcode.com/problems/closest-binary-search-tree-value-ii/discuss/186606/Deque-Solution-Java.-Definitely-easy-to-understand
	// Time : O(n), Space :O(n)
	public List<Integer> closestKValues(BinaryTreeNode<Integer> root, double target, int k) {
		Deque<Integer> dq = new LinkedList<>();

		List<Integer> res = new ArrayList<>();
		inorder(root, dq);
		while (dq.size() > k) {
			if (Math.abs(dq.peekFirst() - target) > Math.abs(dq.peekLast() - target)) {
				dq.pollFirst();
			} else {
				dq.pollLast();
			}
		}
		res.addAll(dq);
		return res;
	}

	private void inorder(BinaryTreeNode<Integer> root, Deque<Integer> dq) {
		if (null != root) {
			inorder(root.left, dq);
			dq.addLast(root.data);
			inorder(root.right, dq);
		}
	}

	public static void main(String[] args) {
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

		ClosestBinarySearchTreeValue2 obj = new ClosestBinarySearchTreeValue2();
		double target = 4.428571;

		List<Integer> result = null;
		result = obj.closestKValues(tree.root, target, 3);
		System.out.println(result);
	}

}
