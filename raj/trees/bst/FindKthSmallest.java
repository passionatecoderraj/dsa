/**
 * 
 */
package com.raj.trees.bst;

import java.util.Deque;
import java.util.LinkedList;

import com.raj.nodes.BinaryTreeNode;

/**
 * @author Raj
 *
 */
public class FindKthSmallest {

	/**
	 * @param args
	 */
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

		FindKthSmallest obj = new FindKthSmallest();
		tree.inOrder(tree.root);
		System.out.println();
		int k = 3;
		BinaryTreeNode<Integer> result = null;
		result = obj.findKthSmallest(tree.root, k);
		System.out.println(result);
		result = obj.findKthSmallestWithoutRecursion(tree.root, k);
		System.out.println(result);

	}

	int count = 0;

	public BinaryTreeNode<Integer> findKthSmallest(BinaryTreeNode<Integer> root, int k) {
		if (root == null || k <= 0)
			return null;

		BinaryTreeNode<Integer> left = findKthSmallest(root.left, k);
		if (left != null) {
			return left;
		}
		if (++count == k) {
			return root;
		}
		return findKthSmallest(root.right, k);
	}

	public BinaryTreeNode<Integer> findKthSmallestWithoutRecursion(BinaryTreeNode<Integer> root, int k) {
		if (root == null || k <= 0)
			return null;

		int cnt = 0;
		Deque<BinaryTreeNode<Integer>> stack = new LinkedList<BinaryTreeNode<Integer>>();
		BinaryTreeNode<Integer> temp = root;
		while (true) {
			if (temp != null) {
				stack.addFirst(temp);
				temp = temp.left;
			} else {
				if (stack.isEmpty())
					return null;
				BinaryTreeNode<Integer> pop = stack.removeFirst();
				if (++cnt == k)
					return pop;
				temp = pop.right;
			}
		}
	}

}
