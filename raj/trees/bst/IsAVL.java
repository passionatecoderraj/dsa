/**
 * 
 */
package com.raj.trees.bst;

import com.raj.nodes.AVLTreeNode;

/**
 * @author Raj
 *
 */
public class IsAVL {

	public AVLTreeNode<Integer> createTestAVL() {
		AVLTreeNode<Integer> n1 = new AVLTreeNode<Integer>(1, 3);
		AVLTreeNode<Integer> n2 = new AVLTreeNode<Integer>(2, 2);
		AVLTreeNode<Integer> n3 = new AVLTreeNode<Integer>(3, 1);
		n1.right = n2;
		n2.right = n3;
		return n1;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AVLTree tree = new AVLTree();
		tree.root = tree.insert(tree.root, 10);
		tree.root = tree.insert(tree.root, 20);
		tree.root = tree.insert(tree.root, 30);
		tree.root = tree.insert(tree.root, 40);
		tree.root = tree.insert(tree.root, 35);
		tree.root = tree.insert(tree.root, 9);
		tree.root = tree.insert(tree.root, 8);
		tree.root = tree.insert(tree.root, 5);
		tree.root = tree.insert(tree.root, 6);
		tree.levelOrderTraversal(tree.root);

		IsAVL obj = new IsAVL();

		// not avl tree
		AVLTreeNode<Integer> root2 = obj.createTestAVL();
		tree.levelOrderTraversal(root2);

		boolean result = false;
		int res = -1;
		// Time : O(n), Using AVLTreeNode height value
		result = obj.isAVL(tree, tree.root);
		System.out.println(result);
		result = obj.isAVL(tree, root2);
		System.out.println(result);

		// Time : O(n), Using height function
		res = obj.isAVL(tree.root);
		System.out.println(res);
		res = obj.isAVL(root2);
		System.out.println(res);

	}

	public int isAVL(AVLTreeNode<Integer> root) {
		if (root == null)
			return 0;
		int left, right;
		left = isAVL(root.left);
		if (left == -1)
			return -1;
		right = isAVL(root.right);
		if (right == -1)
			return -1;
		if (Math.abs(left - right) >= 2)
			return -1;
		return 1 + Math.max(left, right);
	}

	public boolean isAVL(AVLTree tree, AVLTreeNode<Integer> root) {
		if (null == root)
			return true;
		if (tree.heightDiff(root.left, root.right) >= 2)
			return false;
		return isAVL(tree, root.left) && isAVL(tree, root.right);
	}

}
