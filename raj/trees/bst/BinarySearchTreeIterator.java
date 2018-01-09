/**
 * 
 */
package com.raj.trees.bst;

import java.util.Stack;

import com.raj.nodes.BinaryTreeNode;

/**
 * @author Raj
 *
 */
/*
 * Binary Search Tree Iterator in Java
 *
 * Implement an iterator over a binary search tree (BST). Your iterator will be
 * initialized with the root node of a BST.
 * 
 * Calling next() will return the next smallest number in the BST.
 * 
 * Note: next() and hasNext() should run in average O(1) time and uses O(h)
 * memory, where h is the height of the tree.
 */

/*
 * http://www.programcreek.com/2014/04/leetcode-binary-search-tree-iterator-
 * java/
 */
public class BinarySearchTreeIterator {

	Stack<BinaryTreeNode<Integer>> stack = new Stack<>();

	public BinarySearchTreeIterator(BinaryTreeNode<Integer> root) {
		pushAll(root);
	}

	public boolean hasNext() {
		return !stack.isEmpty();
	}

	public BinaryTreeNode<Integer> next() {
		BinaryTreeNode<Integer> node = stack.pop();
		pushAll(node.right);
		return node;
	}

	private void pushAll(BinaryTreeNode<Integer> root) {
		while (root != null) {
			stack.push(root);
			root = root.left;
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

		BinarySearchTreeIterator obj = new BinarySearchTreeIterator(tree.root);
		while (obj.hasNext()) {
			System.out.print(obj.next().data + " ");
		}
		System.out.println();
	}

}
