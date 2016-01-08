/**
 * 
 */
package com.raj.trees.bst;

import com.raj.nodes.BinaryTreeNode;
import com.raj.trees.binary.BinaryTree;

/**
 * @author Raj
 *
 */
public class CorrectBinarySearchTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CorrectBinarySearchTree obj = new CorrectBinarySearchTree();

		BinaryTree tree = new BinaryTree();
		tree.insert(6);
		tree.insert(10);
		tree.insert(2);
		tree.insert(1);
		tree.insert(3);
		tree.insert(7);
		tree.insert(12);
		tree.inOrder(tree.root);
		System.out.println();
		// case 1 : two numbers are not in order (10,2)
		// 10 and 2 are swapped
		// {1,10,3,6,10,7,2,12}
		obj.fixSwappedNodesInBST(tree);
		tree.inOrder(tree.root);
		System.out.println();

		// case 2 : only one number is misplaced that is 2
		// (or adjascent elements are misplaced)
		// {1,3,2,6,7,10, 12}
		BinaryTree tree2 = new BinaryTree();
		tree2.insert(6);
		tree2.insert(3);
		tree2.insert(10);
		tree2.insert(1);
		tree2.insert(2);
		tree2.insert(7);
		tree2.insert(12);
		tree2.inOrder(tree2.root);
		System.out.println();
		obj.fixSwappedNodesInBST(tree2);
		tree2.inOrder(tree2.root);
		System.out.println();

	}

	public void fixSwappedNodesInBST(BinaryTree tree) {
		this.first = this.firstPrev = this.second = this.secondPrev = null;
		findSwappedNodes(tree.root);
		if (first == null && second == null) {
			System.out.println("No nodes to swap");
			return;
		}
		if (second == null) {
			swap(first, firstPrev);
		} else {
			swap(firstPrev, second);
		}
	}

	public void swap(BinaryTreeNode<Integer> t1, BinaryTreeNode<Integer> t2) {
		t1.data = t1.data + t2.data;
		t2.data = t1.data - t2.data;
		t1.data = t1.data - t2.data;
	}

	BinaryTreeNode<Integer> first;
	BinaryTreeNode<Integer> firstPrev;
	BinaryTreeNode<Integer> second;
	BinaryTreeNode<Integer> secondPrev;

	public void findSwappedNodes(BinaryTreeNode<Integer> root) {
		if (null == root)
			return;
		findSwappedNodes(root.left);
		if (first == null) {
			if (firstPrev != null && root.data <= firstPrev.data) {
				first = root;
			} else {
				firstPrev = root;
			}
		}
		if (first != null) {
			if (second == null) {
				if (secondPrev != null && root.data <= secondPrev.data) {
					second = root;
				} else {
					secondPrev = root;
				}
			}
		}
		findSwappedNodes(root.right);
	}
}
