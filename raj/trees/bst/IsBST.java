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
public class IsBST {

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

		// not binary search tree
		BinaryTree bin_tree = new BinaryTree();
		bin_tree.insert(6);
		bin_tree.insert(2);
		bin_tree.insert(8);
		bin_tree.insert(1);
		bin_tree.insert(9);

		IsBST obj = new IsBST();

		boolean result = false;

		// it's wrong and doesn't cover all the scenarios
		// Time : O(n), Space : O(n)
		result = obj.isBST(tree.root);
		System.out.println(result);
		result = obj.isBST(bin_tree.root);
		System.out.println(result);

		// Time : O(n2), Space : O(n)
		result = obj.isBSTUsingMaxMin(tree.root);
		System.out.println(result);
		result = obj.isBSTUsingMaxMin(bin_tree.root);
		System.out.println(result);

		// Time : O(n), Space : O(n)
		result = obj.isBSTUsingMaxMinOptimized(tree.root, Integer.MIN_VALUE, Integer.MAX_VALUE);
		System.out.println(result);
		result = obj.isBSTUsingMaxMinOptimized(bin_tree.root, Integer.MIN_VALUE, Integer.MAX_VALUE);
		System.out.println(result);

		// If the value of the currently visited node is less than the previous
		// value, then tree is not BST
		// Time : O(n), Space : O(n)
		result = obj.isBSTUsingInorder(tree.root);
		System.out.println(result);

		result = obj.isBSTUsingInorder(bin_tree.root);
		System.out.println(result);

	}

	BinaryTreeNode<Integer> prev = null;

	public boolean isBSTUsingInorder(BinaryTreeNode<Integer> root) {
		if (root == null)
			return true;
		if (!isBSTUsingInorder(root.left))
			return false;
		if (prev == null || (prev != null && prev.data < root.data))
			prev = root;
		else
			return false;
		return isBSTUsingInorder(root.right);
	}

	public boolean isBSTUsingMaxMinOptimized(BinaryTreeNode<Integer> root, int min, int max) {
		if (root == null)
			return true;
		if (root.data > min && root.data < max) {
			return isBSTUsingMaxMinOptimized(root.left, min, root.data)
					&& isBSTUsingMaxMinOptimized(root.right, root.data, max);
		}
		return false;
	}

	public boolean isBSTUsingMaxMin(BinaryTreeNode<Integer> root) {
		if (null == root)
			return true;
		if (root.left != null && root.data < new BinarySearchTree().findMax(root.left).data)
			return false;
		if (root.right != null && root.data > new BinarySearchTree().findMin(root.right).data)
			return false;
		if (!isBSTUsingMaxMin(root.left) || !isBSTUsingMaxMin(root.right))
			return false;
		return true;
	}

	public boolean isBST(BinaryTreeNode<Integer> root) {
		if (root == null)
			return true;
		if (root.left != null && root.data < root.left.data)
			return false;

		if (root.right != null && root.data > root.right.data)
			return false;
		if (!isBST(root.left) || !isBST(root.right))
			return false;
		return true;
	}
}
