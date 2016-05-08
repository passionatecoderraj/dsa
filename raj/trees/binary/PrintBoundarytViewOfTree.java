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
		tree.root = tree.insert(tree.root, 3);
		tree.root = tree.insert(tree.root, 10);
		tree.root = tree.insert(tree.root, 1);
		tree.root = tree.insert(tree.root, 6);
		tree.root = tree.insert(tree.root, 14);
		tree.root = tree.insert(tree.root, 4);
		tree.root = tree.insert(tree.root, 7);
		tree.root = tree.insert(tree.root, 13);

		obj.printBoundaryOfaTree(tree.root);
	}

	// Time : O(n)
	public void printBoundaryOfaTree(BinaryTreeNode<Integer> root) {
		printLeftBoundary(root);
	}

	public void printLeftBoundary(BinaryTreeNode<Integer> root) {
		
	}

}
