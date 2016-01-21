/**
 * 
 */
package com.raj.arrays;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Raj
 *
 */

/*
 * Write a function to count number of smaller elements on right of each element
 * in an array. Given an unsorted array arr[] of distinct integers, construct
 * another array countSmaller[] such that countSmaller[i] contains count of
 * smaller elements on right side of each element arr[i] in array.
 */

public class AVLTreeWithSize {
	public AVLTreeNodeWithSize<Integer> root;

	public void inOrder(AVLTreeNodeWithSize<Integer> node) {
		if (node != null) {
			inOrder(node.left);
			System.out.print(node.data + " ");
			inOrder(node.right);
		}
	}

	public void preOrder(AVLTreeNodeWithSize<Integer> node) {
		if (node != null) {
			System.out.print(node.data + " ");
			preOrder(node.left);
			preOrder(node.right);
		}
	}

	public void levelOrderTraversal(AVLTreeNodeWithSize<Integer> root) {
		int size = root.height;
		for (int i = 1; i <= size; i++) {
			printNodesAtGivenLevel(root, i);
			System.out.print("| ");
		}
		System.out.println();
	}

	public void printNodesAtGivenLevel(AVLTreeNodeWithSize<Integer> root, int level) {
		if (root == null) {
			return;
		}
		if (level == 1) {
			System.out.print(root.data + "(" + root.size + ")");
		} else if (level > 1) {
			printNodesAtGivenLevel(root.left, level - 1);
			printNodesAtGivenLevel(root.right, level - 1);
		}

	}

	public void levelOrder(AVLTreeNodeWithSize<Integer> node) {
		if (null == node) {
			System.out.println("Empty");
			return;
		}

		Deque<AVLTreeNodeWithSize<Integer>> queue = new LinkedList<AVLTreeNodeWithSize<Integer>>();
		queue.addLast(node);

		while (!queue.isEmpty()) {
			AVLTreeNodeWithSize<Integer> cur = queue.removeFirst();
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
		AVLTreeWithSize tree = new AVLTreeWithSize();
		tree.root = tree.insert(tree.root, 10);
		tree.root = tree.insert(tree.root, 20);
		tree.root = tree.insert(tree.root, 30);
		tree.root = tree.insert(tree.root, 40);
		tree.root = tree.insert(tree.root, 35);
		tree.root = tree.insert(tree.root, 9);
		tree.root = tree.insert(tree.root, 8);
		tree.root = tree.insert(tree.root, 5);
		tree.root = tree.insert(tree.root, 6);
		tree.inOrder(tree.root);
		System.out.println();
		tree.preOrder(tree.root);
		System.out.println();
		tree.levelOrderTraversal(tree.root);
		// tree.delete(tree.root, 10);
		// tree.levelOrderTraversal(tree.root);
	}

	public int count;

	public AVLTreeNodeWithSize<Integer> insert(AVLTreeNodeWithSize<Integer> root, int data) {
		if (root == null) {
			root = new AVLTreeNodeWithSize<Integer>(data, 1, 1);
			return root;
		}
		if (root.data > data) {
			root.left = insert(root.left, data);
			if (heightDiff(root.left, root.right) == 2) {
				// LL imbalance
				if (root.left.data > data) {
					root = rotateRight(root);
				}
				// LR imbalance
				else {
					root.left = rotateLeft(root.left);
					root = rotateRight(root);
				}
			}

		} else {
			count = 1 + size(root.left);
			root.right = insert(root.right, data);

			if (heightDiff(root.left, root.right) == 2) {
				// RL imbalance
				if (root.right.data > data) {
					root.right = rotateRight(root.right);
					root = rotateLeft(root);
				}
				// RR imbalance
				else {

					root = rotateLeft(root);
				}
			}
		}
		root.height = 1 + Math.max(height(root.left), height(root.right));
		root.size = 1 + size(root.left) + size(root.right);
		return root;
	}

	public int heightDiff(AVLTreeNodeWithSize<Integer> left, AVLTreeNodeWithSize<Integer> right) {
		return Math.abs(height(left) - height(right));
	}

	public AVLTreeNodeWithSize<Integer> delete(AVLTreeNodeWithSize<Integer> root, int data) {
		if (root == null) {
			return root;
		}
		if (root.data > data) {
			root.left = delete(root.left, data);
			if (heightDiff(root.left, root.right) == 2) {
				// LL imbalance
				if (root.left.data > data) {
					root = rotateRight(root);
				}
				// LR imbalance
				else {
					root.left = rotateLeft(root.left);
					root = rotateRight(root);
				}
			}
		} else if (root.data < data) {
			root.right = delete(root.right, data);
			if (heightDiff(root.left, root.right) == 2) {
				// RL imbalance
				if (root.right.data > data) {
					root.right = rotateRight(root.right);
					root = rotateLeft(root);
				}
				// RR imbalance
				else {
					root = rotateLeft(root);
				}
			}

		} else {
			if (isFullNode(root)) {
				AVLTreeNodeWithSize<Integer> inOrderPred = findMax(root.left);
				root.data = inOrderPred.data;
				root.left = delete(root.left, inOrderPred.data);
			} else {
				root = (root.left != null) ? root.left : root.right;
			}
		}
		if (root != null)
			root.height = 1 + Math.max(height(root.left), height(root.right));
		return root;
	}

	public AVLTreeNodeWithSize<Integer> findMax(AVLTreeNodeWithSize<Integer> root) {
		if (null == root)
			return root;
		while (root.right != null) {
			root = root.right;
		}
		return root;
	}

	public AVLTreeNodeWithSize<Integer> findMin(AVLTreeNodeWithSize<Integer> root) {
		if (null == root)
			return root;
		while (root.left != null) {
			root = root.left;
		}
		return root;
	}

	public AVLTreeNodeWithSize<Integer> rotateRight(AVLTreeNodeWithSize<Integer> node) {
		AVLTreeNodeWithSize<Integer> temp = node.left;
		node.left = temp.right;
		temp.right = node;

		node.height = 1 + Math.max(height(node.left), height(node.right));
		temp.height = 1 + Math.max(height(temp.left), height(temp.right));

		node.size = 1 + size(node.left) + size(node.right);
		temp.size = 1 + size(node.left) + size(node.right);
		return temp;
	}

	public AVLTreeNodeWithSize<Integer> rotateLeft(AVLTreeNodeWithSize<Integer> node) {
		AVLTreeNodeWithSize<Integer> temp = node.right;
		node.right = temp.left;
		temp.left = node;

		node.height = 1 + Math.max(height(node.left), height(node.right));
		temp.height = 1 + Math.max(height(temp.left), height(temp.right));

		node.size = 1 + size(node.left) + size(node.right);
		temp.size = 1 + size(node.left) + size(node.right);

		return temp;
	}

	public int height(AVLTreeNodeWithSize<Integer> root) {
		if (null == root)
			return 0;
		return root.height;
	}

	public int size(AVLTreeNodeWithSize<Integer> root) {
		if (null == root)
			return 0;
		return root.size;
	}

	public boolean isFullNode(AVLTreeNodeWithSize<Integer> root) {
		return root.left != null && root.right != null;
	}

}

class AVLTreeNodeWithSize<T> {
	public T data;
	public int height;
	public int size;
	public AVLTreeNodeWithSize<T> left;
	public AVLTreeNodeWithSize<T> right;

	public AVLTreeNodeWithSize() {

	}

	public AVLTreeNodeWithSize(T data, int height, int size) {
		super();
		this.data = data;
		this.height = height;
		this.size = size;
		this.left = null;
		this.right = null;
	}

	public AVLTreeNodeWithSize(T data) {
		super();
		this.data = data;
		this.left = null;
		this.right = null;
	}

	@Override
	public String toString() {
		return "AVLTreeNodeWithSize [data=" + data + "]";
	}

}
