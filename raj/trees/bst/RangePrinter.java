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
public class RangePrinter {

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
		tree.inOrder(tree.root);
		System.out.println();
		RangePrinter obj = new RangePrinter();

		int k1 = 1, k2 = 7;
		obj.printRange(tree.root, k1, k2);
		System.out.println();
		obj.printRangeWithoutRecursion(tree.root, k1, k2);

	}

	// k1 < k2
	public void printRange(BinaryTreeNode<Integer> root, int k1, int k2) {
		if (null == root)
			return;
		if (root.data >= k1) {
			printRange(root.left, k1, k2);
		}
		if (root.data >= k1 && root.data <= k2) {
			System.out.print(root.data + " ");
		}
		if (root.data <= k2) {
			printRange(root.right, k1, k2);
		}
	}

	public void printRangeWithoutRecursion(BinaryTreeNode<Integer> root, int k1, int k2) {
		if (null == root) {
			return;
		}

		Deque<BinaryTreeNode<Integer>> queue = new LinkedList<BinaryTreeNode<Integer>>();
		queue.addLast(root);

		while (!queue.isEmpty()) {
			BinaryTreeNode<Integer> cur = queue.removeFirst();
			if (cur.data >= k1 && cur.data <= k2) {
				System.out.print(cur.data + " ");
			}
			if (cur.left != null)
				queue.addLast(cur.left);
			if (cur.right != null)
				queue.addLast(cur.right);

		}
		System.out.println();
	}

}
