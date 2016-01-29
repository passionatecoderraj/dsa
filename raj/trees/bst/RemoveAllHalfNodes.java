/**
 * 
 */
package com.raj.trees.bst;

import com.raj.nodes.BinaryTreeNode;

/**
 * @author Raj
 *
 */
public class RemoveAllHalfNodes {

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
		tree.postOrder(tree.root);
		System.out.println();
		RemoveAllHalfNodes obj = new RemoveAllHalfNodes();

		// Time :O(n)
		// using post-order traversal
		tree.root = obj.removeAllHalfNodes(tree.root);
		tree.postOrder(tree.root);
		System.out.println();
		tree.inOrder(tree.root);

	}

	public BinaryTreeNode<Integer> removeAllHalfNodes(BinaryTreeNode<Integer> root) {
		if (root == null)
			return null;
		root.left = removeAllHalfNodes(root.left);
		root.right = removeAllHalfNodes(root.right);
		if (isHalfNode(root)) {
			return root.left != null ? root.left : root.right;
		}
		return root;
	}

	public boolean isHalfNode(BinaryTreeNode<Integer> root) {
		return (root.left != null && root.right == null) || (root.left == null && root.right != null);
	}

}
