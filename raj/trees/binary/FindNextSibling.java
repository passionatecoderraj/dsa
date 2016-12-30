/**
 * 
 */
package com.raj.trees.binary;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Raj
 *
 */
public class FindNextSibling {

	public BinaryTreeNodeWithSibling<Integer> createTestTree1() {
		BinaryTreeNodeWithSibling<Integer> n1 = new BinaryTreeNodeWithSibling<Integer>(1);
		BinaryTreeNodeWithSibling<Integer> n2 = new BinaryTreeNodeWithSibling<Integer>(2);
		BinaryTreeNodeWithSibling<Integer> n3 = new BinaryTreeNodeWithSibling<Integer>(3);
		BinaryTreeNodeWithSibling<Integer> n4 = new BinaryTreeNodeWithSibling<Integer>(4);
		BinaryTreeNodeWithSibling<Integer> n5 = new BinaryTreeNodeWithSibling<Integer>(5);
		BinaryTreeNodeWithSibling<Integer> n6 = new BinaryTreeNodeWithSibling<Integer>(6);
		BinaryTreeNodeWithSibling<Integer> n7 = new BinaryTreeNodeWithSibling<Integer>(7);
		BinaryTreeNodeWithSibling<Integer> n8 = new BinaryTreeNodeWithSibling<Integer>(8);
		BinaryTreeNodeWithSibling<Integer> n9 = new BinaryTreeNodeWithSibling<Integer>(9);
		BinaryTreeNodeWithSibling<Integer> n10 = new BinaryTreeNodeWithSibling<Integer>(10);
		BinaryTreeNodeWithSibling<Integer> n11 = new BinaryTreeNodeWithSibling<Integer>(11);
		BinaryTreeNodeWithSibling<Integer> n12 = new BinaryTreeNodeWithSibling<Integer>(12);
		BinaryTreeNodeWithSibling<Integer> n13 = new BinaryTreeNodeWithSibling<Integer>(13);

		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		n5.left = n6;
		n5.right = n7;
		n3.right = n8;
		n8.right = n9;
		n9.left = n10;
		n9.right = n11;
		n10.left = n12;
		n10.right = n13;

		return n1;
	}

	public BinaryTreeNodeWithSibling<Integer> createTestAlmostCompleteBinaryTree() {
		BinaryTreeNodeWithSibling<Integer> n1 = new BinaryTreeNodeWithSibling<Integer>(1);
		BinaryTreeNodeWithSibling<Integer> n2 = new BinaryTreeNodeWithSibling<Integer>(2);
		BinaryTreeNodeWithSibling<Integer> n3 = new BinaryTreeNodeWithSibling<Integer>(3);
		BinaryTreeNodeWithSibling<Integer> n4 = new BinaryTreeNodeWithSibling<Integer>(4);
		BinaryTreeNodeWithSibling<Integer> n5 = new BinaryTreeNodeWithSibling<Integer>(5);
		BinaryTreeNodeWithSibling<Integer> n6 = new BinaryTreeNodeWithSibling<Integer>(6);
		BinaryTreeNodeWithSibling<Integer> n7 = new BinaryTreeNodeWithSibling<Integer>(7);
		BinaryTreeNodeWithSibling<Integer> n8 = new BinaryTreeNodeWithSibling<Integer>(8);

		n1.left = n2;
		n1.right = n3;

		n2.left = n4;
		n2.right = n5;

		n3.left = n6;
		n3.right = n7;
		n4.left = n8;
		return n1;
	}

	public int height(BinaryTreeNodeWithSibling<Integer> node) {
		if (node == null)
			return 0;
		return 1 + Math.max(height(node.left), height(node.right));
	}

	public void levelOrderUsingNextSibling(BinaryTreeNodeWithSibling<Integer> root) {
		int size = height(root);
		for (int i = 1; i <= size; i++) {
			printNodesAtGivenLevel(root, i);
			System.out.print("| ");
		}
		System.out.println();
	}

	public boolean printNodesAtGivenLevel(BinaryTreeNodeWithSibling<Integer> root, int level) {
		if (root == null) {
			return false;
		}
		if (level == 1) {
			System.out.print(root.data + " ");
			BinaryTreeNodeWithSibling<Integer> temp = root.nextSibling;
			while (temp != null) {
				System.out.print(temp.data + " ");
				temp = temp.nextSibling;
			}
			return true;
		} else if (level > 1) {
			if (printNodesAtGivenLevel(root.left, level - 1) || printNodesAtGivenLevel(root.right, level - 1)) {
				return true;
			}
		}

		return false;
	}

	public void levelOrderTraversal(BinaryTreeNodeWithSibling<Integer> node) {
		if (null == node) {
			System.out.println("Empty");
			return;
		}

		Deque<BinaryTreeNodeWithSibling<Integer>> queue = new LinkedList<BinaryTreeNodeWithSibling<Integer>>();
		queue.addLast(node);

		while (!queue.isEmpty()) {
			BinaryTreeNodeWithSibling<Integer> cur = queue.removeFirst();
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
		FindNextSibling obj = new FindNextSibling();

		BinaryTree ob = new BinaryTree();
		ob.insert(1);
		ob.insert(2);
		ob.insert(3);
		ob.insert(4);
		ob.insert(5);
		ob.insert(6);
		ob.insert(7);
		ob.insert(8);

		BinaryTreeNodeWithSibling<Integer> root = obj.createTestTree1();
		BinaryTreeNodeWithSibling<Integer> completebinarytree_root = obj.createTestAlmostCompleteBinaryTree();

		obj.levelOrderTraversal(root);

		// Time : O(n), space : O(n)
		obj.updateNextSibling(root);
		obj.levelOrderUsingNextSibling(root);

		// Time : O(n)
		// This works only for almost complete binary trees
		obj.updateNextSiblingRecur(completebinarytree_root);
		obj.levelOrderUsingNextSibling(completebinarytree_root);

	}

	public void updateNextSiblingRecur(BinaryTreeNodeWithSibling<Integer> node) {
		if (node == null) {
			return;
		}
		if (node.left != null) {
			node.left.nextSibling = node.right;
		}
		if (node.nextSibling != null) {
			if (node.right != null) {
				node.right.nextSibling = node.nextSibling.left;
			}
		}

		updateNextSiblingRecur(node.left);
		updateNextSiblingRecur(node.right);
	}

	/*
	 * connect nodes at same level
	 */
	public void updateNextSibling(BinaryTreeNodeWithSibling<Integer> node) {
		if (null == node) {
			return;
		}

		Deque<BinaryTreeNodeWithSibling<Integer>> queue = new LinkedList<BinaryTreeNodeWithSibling<Integer>>();
		queue.addLast(node);
		queue.addLast(null);

		while (!queue.isEmpty()) {
			BinaryTreeNodeWithSibling<Integer> cur = queue.removeFirst();

			if (cur == null) {
				if (queue.isEmpty())
					break;
				queue.addLast(null);
			} else {
				cur.nextSibling = queue.peekFirst();
				if (cur.left != null) {
					queue.addLast(cur.left);
				}

				if (cur.right != null) {
					queue.addLast(cur.right);
				}
			}
		}
	}
}

class BinaryTreeNodeWithSibling<T> {
	public T data;
	public BinaryTreeNodeWithSibling<T> left;
	public BinaryTreeNodeWithSibling<T> right;
	public BinaryTreeNodeWithSibling<T> nextSibling;

	public BinaryTreeNodeWithSibling() {

	}

	public BinaryTreeNodeWithSibling(T data) {
		super();
		this.data = data;
		this.left = null;
		this.right = null;
		this.nextSibling = null;
	}

	@Override
	public String toString() {
		return "BinaryTreeNode [data=" + data + "]";
	}

}
