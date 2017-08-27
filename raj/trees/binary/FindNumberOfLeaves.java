/**
 * 
 */
package com.raj.trees.binary;

import java.util.Deque;
import java.util.LinkedList;

import com.raj.nodes.BinaryTreeNode;

/**
 * @author Raj
 *
 */
public class FindNumberOfLeaves {

	public int numberOfleaves(BinaryTreeNode<Integer> root) {
		if (null == root)
			return 0;
		if (isLeaf(root)) {
			return 1;
		}
		return numberOfleaves(root.left) + numberOfleaves(root.right);
	}

	private boolean isLeaf(BinaryTreeNode<Integer> root) {
		return root.left == null && root.right == null;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FindNumberOfLeaves obj = new FindNumberOfLeaves();

		BinaryTree ob = new BinaryTree();
		ob.insert(1);
		ob.insert(2);
		ob.insert(3);
		ob.insert(4);
		ob.insert(5);
		ob.insert(6);
		ob.insert(7);
		ob.insert(8);

		BinaryTreeNode<Integer> root = ob.root;

		int result = -1;
		result = obj.numberOfleaves(root);
		System.out.println(result);

		result = obj.numberOfleavesWithoutRecursion(root);
		System.out.println(result);

	}

	public int numberOfleavesWithoutRecursion(BinaryTreeNode<Integer> node) {
		int n = 0;
		if (null == node) {
			return n;
		}

		Deque<BinaryTreeNode<Integer>> queue = new LinkedList<BinaryTreeNode<Integer>>();
		queue.addLast(node);

		while (!queue.isEmpty()) {
			BinaryTreeNode<Integer> cur = queue.removeFirst();
			if (isLeaf(cur)) {
				n++;
			}
			if (cur.left != null) {
				queue.addLast(cur.left);
			}
			if (cur.right != null) {
				queue.addLast(cur.right);
			}
		}
		return n;
	}

}
