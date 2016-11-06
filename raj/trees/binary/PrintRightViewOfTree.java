/**
 * 
 */
package com.raj.trees.binary;

import java.util.LinkedList;
import java.util.Queue;

import com.raj.nodes.BinaryTreeNode;
import com.raj.trees.bst.BinarySearchTree;

/**
 * @author Raj
 *
 */

/*
 * http://algorithms.tutorialhorizon.com/print-right-view-of-a-given-binary-
 * tree/
 */
public class PrintRightViewOfTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PrintRightViewOfTree obj = new PrintRightViewOfTree();

		BinarySearchTree tree = new BinarySearchTree();
		tree.root = tree.insert(tree.root, 8);
		tree.root = tree.insert(tree.root, 2);
		tree.root = tree.insert(tree.root, 10);
		tree.root = tree.insert(tree.root, 1);
		tree.root = tree.insert(tree.root, 6);
		tree.root = tree.insert(tree.root, 14);
		tree.root = tree.insert(tree.root, 4);
		tree.root = tree.insert(tree.root, 7);
		tree.root = tree.insert(tree.root, 13);
		tree.root = tree.insert(tree.root, 3);

		obj.printRighViewOfTree(tree.root);
	}

	// Time : O(n)
	public void printRighViewOfTree(BinaryTreeNode<Integer> root) {
		if (root == null)
			return;

		Queue<BinaryTreeNode<Integer>> q = new LinkedList<>();

		q.add(root);
		q.add(null);
		BinaryTreeNode<Integer> temp;
		while (!q.isEmpty()) {
			temp = q.poll();

			if (!q.isEmpty() && q.peek() == null) {
				System.out.print(temp.data + " ");
			}

			if (temp == null) {
				if (q.isEmpty())
					break;
				q.add(null);
				continue;
			}
			if (temp.left != null)
				q.add(temp.left);
			if (temp.right != null)
				q.add(temp.right);
		}
		System.out.println();
	}

	int max_level = 0;

	public void printRightViewRecursively(BinaryTreeNode<Integer> root, int level) {
		if (null == root)
			return;
		if (max_level < level) {
			System.out.print(root.data + " ");
			max_level = level;
		}
		printRightViewRecursively(root.left, level + 1);
		printRightViewRecursively(root.right, level + 1);

	}

}
