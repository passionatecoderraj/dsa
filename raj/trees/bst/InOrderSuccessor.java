/**
 * 
 */
package com.raj.trees.bst;

import com.raj.nodes.BinaryTreeNode;

/**
 * @author Raj
 *
 */
public class InOrderSuccessor {

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

		// case 1 : if right is not null, then find min in right sub tree
		// case 2 : if right subtree is null then it's ancestor on the right
		// side( i.e. this node fall on the right side of it's ancestor)
		InOrderSuccessor obj = new InOrderSuccessor();
		tree.inOrder(tree.root);
		System.out.println();
		int key = 13;

		BinaryTreeNode<Integer> result = null;
		result = obj.inorderSuccessor(tree, tree.root, key);
		System.out.println(result);

		result = obj.inorderPredecessor(tree, tree.root, key);
		System.out.println(result);

		obj.findPredSucc(tree, tree.root, key);
		System.out.println(obj.predessor);
		System.out.println(obj.sucessor);

	}

	BinaryTreeNode<Integer> predessor = null, sucessor = null;

	public void findPredSucc(BinarySearchTree tree, BinaryTreeNode<Integer> root, int data) {
		if (null == root)
			return;
		if (root.data > data) {
			sucessor = root;
			findPredSucc(tree, root.left, data);
		} else if (root.data < data) {
			predessor = root;
			findPredSucc(tree, root.right, data);
		} else {
			// if root left is not null, then predessor is max on the left sub
			// tree
			if (root.left != null) {
				predessor = tree.findMax(root.left);
			}

			// if root right is not null, then successor is min on the right sub
			// tree
			if (root.right != null) {
				sucessor = tree.findMin(root.right);
			}
		}

	}

	public BinaryTreeNode<Integer> inorderSuccessor(BinarySearchTree tree, BinaryTreeNode<Integer> root, int data) {
		if (null == root)
			return null;
		if (root.data > data) {
			return inorderSuccessor(tree, root.left, data);
		} else if (root.data < data) {
			return inorderSuccessor(tree, root.right, data);
		} else {
			if (root.right != null) {
				return tree.findMin(root.right);
			} else {
				BinaryTreeNode<Integer> node = tree.root;
				BinaryTreeNode<Integer> succ = null;
				while (node != null) {
					if (node.data > data) {
						succ = node;
						node = node.left;
					} else if (node.data < data) {
						node = node.right;
					} else {
						return succ;
					}
				}
			}
		}
		return null;
	}

	public BinaryTreeNode<Integer> inorderPredecessor(BinarySearchTree tree, BinaryTreeNode<Integer> root, int data) {
		if (null == root)
			return null;
		if (root.data > data) {
			return inorderPredecessor(tree, root.left, data);
		} else if (root.data < data) {
			return inorderPredecessor(tree, root.right, data);
		} else {
			if (root.left != null) {
				return tree.findMax(root.left);
			} else {
				BinaryTreeNode<Integer> node = tree.root;
				BinaryTreeNode<Integer> pred = null;
				while (node != null) {
					if (node.data > data) {
						node = node.left;
					} else if (node.data < data) {
						pred = node;
						node = node.right;
					} else {
						return pred;
					}
				}
			}
		}
		return null;
	}
}
