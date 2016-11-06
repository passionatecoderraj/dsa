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
public class PrintBoundarytViewOfTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PrintBoundarytViewOfTree obj = new PrintBoundarytViewOfTree();

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

		obj.printBoundaryOfaTree(tree.root);
	}

	// Time : O(n)
	public void printBoundaryOfaTree(BinaryTreeNode<Integer> root) {
		if (null == root)
			return;
		System.out.print(root.data + " ");
		printLeftBoundary(root.left);
		printLeaves(root);
		printRightBoundary(root.right);
	}

	public void printLeftBoundary(BinaryTreeNode<Integer> root) {
		if (null == root)
			return;
		Queue<BinaryTreeNode<Integer>> q = new LinkedList<>();
		q.offer(root);
		q.offer(null);
		boolean flag = true;
		while (!q.isEmpty()) {
			BinaryTreeNode<Integer> temp = q.poll();
			if (null == temp) {
				if (q.isEmpty()) {
					break;
				}
				q.offer(null);
				flag = true;
				continue;
			}
			if (flag && !BinaryTree.isLeaf(temp)) {
				System.out.print(temp.data + " ");
			}
			flag = false;

			if (temp.left != null)
				q.add(temp.left);
			if (temp.right != null)
				q.add(temp.right);
		}
	}

	private void printLeaves(BinaryTreeNode<Integer> root) {
		if (null == root)
			return;
		if (BinaryTree.isLeaf(root)) {
			System.out.print(root.data + " ");
			return;
		}
		printLeaves(root.left);
		printLeaves(root.right);
	}

	private void printRightBoundary(BinaryTreeNode<Integer> root) {
		if (null == root)
			return;
		Queue<BinaryTreeNode<Integer>> q = new LinkedList<>();
		q.offer(root);
		q.offer(null);
		while (!q.isEmpty()) {
			BinaryTreeNode<Integer> temp = q.poll();
			if (!q.isEmpty() && q.peek() == null && !BinaryTree.isLeaf(temp)) {
				System.out.print(temp.data + " ");
			}

			if (null == temp) {
				if (!q.isEmpty()) {
					q.offer(null);
				}
				continue;
			}
			if (temp.left != null)
				q.add(temp.left);
			if (temp.right != null)
				q.add(temp.right);
		}
	}

}
