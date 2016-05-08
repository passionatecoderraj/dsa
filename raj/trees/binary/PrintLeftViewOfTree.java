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
public class PrintLeftViewOfTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PrintLeftViewOfTree obj = new PrintLeftViewOfTree();

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

		obj.printLeftViewOfTree(tree.root);
		obj.printLeftViewRecursively(tree.root, 1);
	}

	int max_level = 0;

	public void printLeftViewRecursively(BinaryTreeNode<Integer> root, int level) {
		if (null == root)
			return;
		if (max_level < level) {
			System.out.print(root.data + " ");
			max_level = level;
		}
		printLeftViewRecursively(root.left, level + 1);
		printLeftViewRecursively(root.right, level + 1);

	}

	// Time : O(n)
	public void printLeftViewOfTree(BinaryTreeNode<Integer> root) {
		if (root == null)
			return;
		Queue<BinaryTreeNode<Integer>> q = new LinkedList<>();

		q.add(root);
		q.add(null);
		BinaryTreeNode<Integer> tmp2 = null, temp;
		while (!q.isEmpty()) {
			temp = q.poll();
			if (temp == null) {
				if (q.isEmpty())
					break;
				tmp2 = null;
				q.add(null);
				continue;
			}
			if (null == tmp2) {
				tmp2 = temp;
				System.out.print(tmp2.data + " ");
			}
			if (temp.left != null)
				q.add(temp.left);
			if (temp.right != null)
				q.add(temp.right);
		}
		System.out.println();
	}

}
