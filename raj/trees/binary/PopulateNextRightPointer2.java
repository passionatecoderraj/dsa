/**
 *
 */
package com.raj.trees.binary;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Raj
 * 
 *         Follow up for problem "Populating Next Right Pointers in Each Node".
 * 
 *         What if the given tree could be any binary tree? Would your previous
 *         solution still work?
 * 
 *         Note:
 * 
 *         You may only use constant extra space. For example, Given the
 *         following binary tree, 1 / \ 2 3 / \ \ 4 5 7 After calling your
 *         function, the tree should look like: 1 -> NULL / \ 2 -> 3 -> NULL / \
 *         \ 4-> 5 -> 7 -> NULL
 */
public class PopulateNextRightPointer2 {

	// Time :O(n), Space :O(1)
	public void updateNextSiblingInConstantSpace(BinaryTreeNodeWithSibling<Integer> root) {
		BinaryTreeNodeWithSibling<Integer> next_level_start = root; // head of
																	// the next
																	// level
		BinaryTreeNodeWithSibling<Integer> cur; // current node of
												// current level
		BinaryTreeNodeWithSibling<Integer> prev = null;// the leading node on
														// the next level
		while (next_level_start != null) {
			cur = next_level_start;
			next_level_start = null;
			prev = null;
			while (cur != null) {
				// left child
				if (cur.left != null) {// iterate on the current level
					if (prev != null) {
						prev.next = cur.left;
					} else {
						next_level_start = cur.left;
					}
					prev = cur.left;
				}

				// right child
				if (cur.right != null) {
					if (prev != null) {
						prev.next = cur.right;
					} else {
						next_level_start = cur.right;
					}
					prev = cur.right;
				}

				// move to next node
				cur = cur.next;
			}
		}
	}

	/*
	 * connect nodes at same level
	 */
	// Time :O(n), Space :O(n)
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
				if (queue.isEmpty()) {
					break;
				}
				queue.addLast(null);
			} else {
				cur.next = queue.peekFirst();
				if (cur.left != null) {
					queue.addLast(cur.left);
				}

				if (cur.right != null) {
					queue.addLast(cur.right);
				}
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PopulateNextRightPointer2 obj = new PopulateNextRightPointer2();
		BinaryTreeNodeWithSibling<Integer> root = obj.createTestTree1();

		obj.levelOrderTraversal(root);

		// Time : O(n), space : O(n)
		// obj.updateNextSibling(root);
		// obj.levelOrderUsingNextSibling(root);

		// Time : O(n), space : O(n)
		obj.updateNextSiblingInConstantSpace(root);
		obj.levelOrderUsingNextSibling(root);
	}

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

	public int height(BinaryTreeNodeWithSibling<Integer> node) {
		if (node == null) {
			return 0;
		}
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
			BinaryTreeNodeWithSibling<Integer> temp = root.next;
			while (temp != null) {
				System.out.print(temp.data + " ");
				temp = temp.next;
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

}
