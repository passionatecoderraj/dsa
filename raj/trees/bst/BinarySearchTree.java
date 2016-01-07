/**
 * 
 */
package com.raj.trees.bst;

import java.util.Deque;
import java.util.LinkedList;

import com.raj.nodes.BinaryTreeNode;

/**
 * @author Raj
 *
 */
public class BinarySearchTree {
	BinaryTreeNode<Integer> root;

	public void inOrder(BinaryTreeNode<Integer> node) {
		if (node != null) {
			inOrder(node.left);
			System.out.print(node.data + " ");
			inOrder(node.right);
		}
	}

	public void preOrder(BinaryTreeNode<Integer> node) {
		if (node != null) {
			System.out.print(node.data + " ");
			preOrder(node.left);
			preOrder(node.right);
		}
	}

	public void postOrder(BinaryTreeNode<Integer> node) {
		if (node != null) {
			postOrder(node.left);
			postOrder(node.right);
			System.out.print(node.data + " ");
		}
	}

	public void levelOrder(BinaryTreeNode<Integer> node) {
		if (null == node) {
			System.out.println("Empty");
			return;
		}

		Deque<BinaryTreeNode<Integer>> queue = new LinkedList<BinaryTreeNode<Integer>>();
		queue.addLast(node);

		while (!queue.isEmpty()) {
			BinaryTreeNode<Integer> cur = queue.removeFirst();
			System.out.print(cur.data + " ");

			if (cur.left != null) {
				queue.addLast(cur.left);
			}
			if (cur.right != null) {
				queue.addLast(cur.right);
			}
		}
		System.out.println();
	}

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
		tree.inOrder(tree.root);
		System.out.println();
		tree.levelOrder(tree.root);
		System.out.println(tree.findMax(tree.root));
		System.out.println(tree.findMaxWithoutRecursion(tree.root));
		System.out.println(tree.findMin(tree.root));
		System.out.println(tree.findMinWithoutRecursion(tree.root));
		tree.root = tree.delete(tree.root, 8);
		tree.preOrder(tree.root);
		System.out.println();
		System.out.println(tree.search(tree.root, 10));
		System.out.println(tree.searchWithoutRecursion(tree.root, 10));

	}

	public BinaryTreeNode<Integer> delete(BinaryTreeNode<Integer> root, int data) {
		if (root == null) {
			return root;
		}
		if (root.data > data) {
			root.left = delete(root.left, data);
		} else if (root.data < data) {
			root.right = delete(root.right, data);
		} else {
			if (isFullNode(root)) {
				BinaryTreeNode<Integer> inOrderPred = findMax(root.left);
				root.data = inOrderPred.data;
				root.left = delete(root.left, inOrderPred.data);
			} else {
				root = (root.left != null) ? root.left : root.right;
			}
		}
		return root;
	}

	public boolean isFullNode(BinaryTreeNode<Integer> root) {
		return root.left != null && root.right != null;
	}

	public BinaryTreeNode<Integer> insert(BinaryTreeNode<Integer> root, int data) {
		if (root == null) {
			root = new BinaryTreeNode<Integer>(data);
			return root;
		}
		if (root.data > data) {
			root.left = insert(root.left, data);
		} else {
			root.right = insert(root.right, data);
		}
		return root;
	}

	public BinaryTreeNode<Integer> findMax(BinaryTreeNode<Integer> root) {
		if (root == null || root.right == null) {
			return root;
		}
		return findMax(root.right);
	}

	public BinaryTreeNode<Integer> findMaxWithoutRecursion(BinaryTreeNode<Integer> root) {
		if (null == root)
			return root;
		while (root.right != null) {
			root = root.right;
		}
		return root;
	}

	public BinaryTreeNode<Integer> findMin(BinaryTreeNode<Integer> root) {
		if (root == null || root.left == null) {
			return root;
		}
		return findMin(root.left);
	}

	public BinaryTreeNode<Integer> findMinWithoutRecursion(BinaryTreeNode<Integer> root) {
		if (null == root)
			return root;
		while (root.left != null) {
			root = root.left;
		}
		return root;
	}

	public BinaryTreeNode<Integer> search(BinaryTreeNode<Integer> root, int data) {
		if (root == null)
			return root;

		if (root.data > data) {
			return search(root.left, data);
		} else if (root.data < data) {
			return search(root.right, data);
		} else {
			return root;
		}
	}

	public BinaryTreeNode<Integer> searchWithoutRecursion(BinaryTreeNode<Integer> root, int data) {
		if (null == root)
			return root;

		while (root != null) {
			if (root.data > data) {
				root = root.left;
			} else if (root.data < data) {
				root = root.right;
			} else {
				return root;
			}
		}
		return root;
	}

	public int size(BinaryTreeNode<Integer> root) {
		if (null == root)
			return 0;
		return 1 + size(root.left) + size(root.right);
	}
}
