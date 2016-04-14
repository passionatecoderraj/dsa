	/**
 * 
 */
package com.raj.trees.binary;

import com.raj.nodes.BinaryTreeNode;

/**
 * @author Raj
 *
 */
public class IsBalancedTree {

	public BinaryTreeNode<Integer> createTestTree() {
		BinaryTreeNode<Integer> n1 = new BinaryTreeNode<Integer>(1);
		BinaryTreeNode<Integer> n2 = new BinaryTreeNode<Integer>(2);
		BinaryTreeNode<Integer> n3 = new BinaryTreeNode<Integer>(3);
		n1.right = n2;
		n2.right = n3;
		return n1;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.insert(10);
		tree.insert(20);
		tree.insert(30);
		tree.insert(40);
		tree.insert(35);
		tree.insert(9);
		tree.insert(8);
		tree.insert(5);
		tree.insert(6);
		tree.levelOrder(tree.root);

		IsBalancedTree obj = new IsBalancedTree();
		int result = obj.isBalancedTree(tree.root);
		System.out.println(result);

		BinaryTreeNode<Integer> tree2 = obj.createTestTree();
		new BinaryTree().levelOrder(tree2);
		result = obj.isBalancedTree(tree2);
		System.out.println(result);

	}

	public int isBalancedTree(BinaryTreeNode<Integer> root) {
		if (root == null)
			return 0;
		int left = isBalancedTree(root.left);
		if (left == -1)
			return left;
		int right = isBalancedTree(root.right);
		if (right == -1)
			return right;

		if (Math.abs(left - right) >= 2)
			return -1;
		return 1 + Math.max(left, right);
	}

}
