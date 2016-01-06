/**
 * 
 */
package com.raj.trees.bst;

import com.raj.nodes.BinaryTreeNode;

/**
 * @author Raj
 *
 */
public class Lca {

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

		Lca obj = new Lca();

		int x = 1, y = 7;
		BinaryTreeNode<Integer> result = null;
		result = obj.lca(tree.root, x, y);
		System.out.println(result);
		result = obj.lcaWithoutRecursion(tree.root, x, y);
		System.out.println(result);

	}

	public BinaryTreeNode<Integer> lca(BinaryTreeNode<Integer> root, int x, int y) {
		if (null == root) {
			return null;
		}
		if (root.data > Math.max(x, y)) {
			return lca(root.left, x, y);
		} else if (root.data < Math.min(x, y)) {
			return lca(root.right, x, y);
		} else
			return root;
	}

	public BinaryTreeNode<Integer> lcaWithoutRecursion(BinaryTreeNode<Integer> root, int x, int y) {
		if (null == root) {
			return null;
		}

		while (root != null) {
			if (root.data > Math.max(x, y)) {
				root = root.left;
			} else if (root.data < Math.min(x, y)) {
				root = root.right;
			} else
				return root;
		}
		return null;
	}

}
