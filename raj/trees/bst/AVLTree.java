/**
 * 
 */
package com.raj.trees.bst;

import java.util.Deque;
import java.util.LinkedList;

import com.raj.nodes.AVLTreeNode;

/**
 * @author Raj
 *
 */
public class AVLTree {
	public AVLTreeNode<Integer> root;

	public void inOrder(AVLTreeNode<Integer> node) {
		if (node != null) {
			inOrder(node.left);
			System.out.print(node.data + " ");
			inOrder(node.right);
		}
	}

	public void preOrder(AVLTreeNode<Integer> node) {
		if (node != null) {
			System.out.print(node.data + " ");
			preOrder(node.left);
			preOrder(node.right);
		}
	}

	public void levelOrderTraversal(AVLTreeNode<Integer> root) {
		int size = root.height;
		for (int i = 1; i <= size; i++) {
			printNodesAtGivenLevel(root, i);
			System.out.print("| ");
		}
		System.out.println();
	}

	public void printNodesAtGivenLevel(AVLTreeNode<Integer> root, int level) {
		if (root == null) {
			return;
		}
		if (level == 1) {
			System.out.print(root.data + " ");
		} else if (level > 1) {
			printNodesAtGivenLevel(root.left, level - 1);
			printNodesAtGivenLevel(root.right, level - 1);
		}

	}

	public void levelOrder(AVLTreeNode<Integer> node) {
		if (null == node) {
			System.out.println("Empty");
			return;
		}

		Deque<AVLTreeNode<Integer>> queue = new LinkedList<AVLTreeNode<Integer>>();
		queue.addLast(node);

		while (!queue.isEmpty()) {
			AVLTreeNode<Integer> cur = queue.removeFirst();
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
		tree.inOrder(tree.root);
		System.out.println();
		tree.preOrder(tree.root);
		System.out.println();
		tree.levelOrderTraversal(tree.root);
		tree.delete(tree.root, 10);
		tree.levelOrderTraversal(tree.root);
	}

	public AVLTreeNode<Integer> insert(AVLTreeNode<Integer> root, int data) {
		if (root == null) {
			root = new AVLTreeNode<Integer>(data, 1);
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
		return root;
	}

	public int heightDiff(AVLTreeNode<Integer> left, AVLTreeNode<Integer> right) {
		return Math.abs(height(left) - height(right));
	}

	public AVLTreeNode<Integer> delete(AVLTreeNode<Integer> root, int data) {
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
				AVLTreeNode<Integer> inOrderPred = findMax(root.left);
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

	public AVLTreeNode<Integer> findMax(AVLTreeNode<Integer> root) {
		if (null == root)
			return root;
		while (root.right != null) {
			root = root.right;
		}
		return root;
	}

	public AVLTreeNode<Integer> findMin(AVLTreeNode<Integer> root) {
		if (null == root)
			return root;
		while (root.left != null) {
			root = root.left;
		}
		return root;
	}

	public AVLTreeNode<Integer> rotateRight(AVLTreeNode<Integer> node) {
		AVLTreeNode<Integer> temp = node.left;
		node.left = temp.right;
		temp.right = node;

		node.height = 1 + Math.max(height(node.left), height(node.right));
		temp.height = 1 + Math.max(height(temp.left), height(temp.right));
		return temp;
	}

	public AVLTreeNode<Integer> rotateLeft(AVLTreeNode<Integer> node) {
		AVLTreeNode<Integer> temp = node.right;
		node.right = temp.left;
		temp.left = node;

		node.height = 1 + Math.max(height(node.left), height(node.right));
		temp.height = 1 + Math.max(height(temp.left), height(temp.right));
		return temp;
	}

	public int height(AVLTreeNode<Integer> root) {
		if (null == root)
			return 0;
		return root.height;
	}

	public boolean isFullNode(AVLTreeNode<Integer> root) {
		return root.left != null && root.right != null;
	}

	public int size(AVLTreeNode<Integer> root2) {
		if (null == root2)
			return 0;
		return 1 + size(root2.left) + size(root2.right);
	}

}
