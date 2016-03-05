/**
 * 
 */
package com.raj.trees.binary;

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
		Lca obj = new Lca();

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

		int x = 8, y = 9;
		BinaryTreeNode<Integer> result = null;
		result = obj.lca(root, x, y);
		System.out.println(result);

	}

	public BinaryTreeNode<Integer> lca(BinaryTreeNode<Integer> root, int x, int y) {
		if (null == root) {
			return null;
		}
		if (root.data == x || root.data == y) {
			return root;
		}
		BinaryTreeNode<Integer> left = lca(root.left, x, y);
		BinaryTreeNode<Integer> right = lca(root.right, x, y);
		if (left != null && right != null) {
			return root;
		}
		return left != null ? left : right;
	}
}
