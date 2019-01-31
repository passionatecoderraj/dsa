/**
 *
 */
package com.raj.leetcode;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;

import com.raj.nodes.BinaryTreeNode;
import com.raj.trees.bst.BinarySearchTree;

/**
 * @author Raj
 * 
 *         Given a Binary Search Tree and a target number, return true if there
 *         exist two elements in the BST such that their sum is equal to the
 *         given target.
 * 
 *         Example 1: Input: 5 / \ 3 6 / \ \ 2 4 7
 * 
 *         Target = 9
 * 
 *         Output: True Example 2: Input: 5 / \ 3 6 / \ \ 2 4 7
 * 
 *         Target = 28
 * 
 *         Output: False
 */
public class TwoSum4 {

	// Time : O(n), Space :O(n)
	public boolean findTarget(BinaryTreeNode<Integer> root, int k) {
		if (null == root) {
			return false;
		}

		Deque<BinaryTreeNode<Integer>> stack1 = new LinkedList<>();
		Deque<BinaryTreeNode<Integer>> stack2 = new LinkedList<>();

		BinaryTreeNode<Integer> temp1 = root, temp2 = root;
		BinaryTreeNode<Integer> top1 = null, top2 = null;

		while (true) {
			if (temp1 != null || temp2 != null) {
				if (temp1 != null) {
					stack1.push(temp1);
					temp1 = temp1.left;
				}
				if (temp2 != null) {
					stack2.push(temp2);
					temp2 = temp2.right;
				}
			} else {
				if (stack1.isEmpty() || stack2.isEmpty()) {
					return false;
				}

				top1 = stack1.peek();
				top2 = stack2.peek();

				if (top1 == top2) {
					return false;
				}
				int sum = top1.data + top2.data;

				if (sum == k) {
					return true;
				}
				if (sum > k) {
					stack2.pop();
					temp2 = top2.left;
				} else if (sum < k) {
					stack1.pop();
					temp1 = top1.right;
				}
			}
		}
	}

	public boolean findTarget2(BinaryTreeNode<Integer> root, int k) {
		HashSet<Integer> set = new HashSet<>();
		return dfs(root, set, k);
	}

	public boolean dfs(BinaryTreeNode<Integer> root, HashSet<Integer> set, int k) {
		if (root == null)
			return false;
		if (set.contains(k - root.data))
			return true;
		set.add(root.data);
		return dfs(root.left, set, k) || dfs(root.right, set, k);
	}

	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree();
		tree.root = tree.insert(tree.root, 15);
		tree.root = tree.insert(tree.root, 10);
		tree.root = tree.insert(tree.root, 20);
		tree.root = tree.insert(tree.root, 8);
		tree.root = tree.insert(tree.root, 12);
		tree.root = tree.insert(tree.root, 16);
		tree.root = tree.insert(tree.root, 25);
		tree.inOrder(tree.root);
		System.out.println();
		TwoSum4 obj = new TwoSum4();

		int k = 26;
		boolean res = obj.findTarget(tree.root, k);
		System.out.println(res);

		res = obj.findTarget(tree.root, 16);
		System.out.println(res);
	}

}
