/**
 * 
 */
package com.raj.trees.binary;

import java.util.Deque;
import java.util.LinkedList;

import com.raj.nodes.BinaryTreeNode;

/**
 * @author Raj
 *
 */
public class LevelOrderSpiral {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LevelOrderSpiral obj = new LevelOrderSpiral();

		BinaryTree ob = new BinaryTree();
		ob.insert(1);
		ob.insert(2);
		ob.insert(3);
		ob.insert(4);
		ob.insert(5);
		ob.insert(6);
		ob.insert(7);
		ob.insert(8);

		BinaryTreeNode<Integer> root = ob.root;

		ob.levelOrder(ob.root);
		// Time :O(n2)
		obj.levelOrderTraversalSpiral(root);

		// Time : O(n)
		obj.levelOrderSpiralWithoutRecursionMethod1(root);

		obj.levelOrderSpiralWithoutRecursionMethod2(root);
	}

	public void levelOrderTraversalSpiral(BinaryTreeNode<Integer> root) {
		int size = new Height().height(root);
		boolean ltr = false;
		for (int i = 1; i <= size; i++) {
			printNodesAtGivenLevel(root, i, ltr);
			// System.out.print("| ");
			ltr = !ltr;
		}
		System.out.println();
	}

	public void printNodesAtGivenLevel(BinaryTreeNode<Integer> root, int level, boolean ltr) {
		if (root == null) {
			return;
		}
		if (level == 1) {
			System.out.print(root.data + " ");
		} else if (level > 1) {
			if (ltr) {
				printNodesAtGivenLevel(root.left, level - 1, ltr);
				printNodesAtGivenLevel(root.right, level - 1, ltr);
			} else {
				printNodesAtGivenLevel(root.right, level - 1, ltr);
				printNodesAtGivenLevel(root.left, level - 1, ltr);
			}
		}

	}

	public void levelOrderSpiralWithoutRecursionMethod1(BinaryTreeNode<Integer> node) {
		if (null == node) {
			return;
		}

		Deque<BinaryTreeNode<Integer>> stack1 = new LinkedList<BinaryTreeNode<Integer>>();
		Deque<BinaryTreeNode<Integer>> stack2 = new LinkedList<BinaryTreeNode<Integer>>();
		stack1.addFirst(node);

		while (!stack1.isEmpty() || !stack2.isEmpty()) {
			while (!stack1.isEmpty()) {
				BinaryTreeNode<Integer> cur = stack1.pop();
				System.out.print(cur.data + " ");
				if (cur.right != null)
					stack2.addFirst(cur.right);
				if (cur.left != null)
					stack2.addFirst(cur.left);
			}
			while (!stack2.isEmpty()) {
				BinaryTreeNode<Integer> cur = stack2.pop();
				System.out.print(cur.data + " ");
				if (cur.left != null)
					stack1.addFirst(cur.left);
				if (cur.right != null)
					stack1.addFirst(cur.right);
			}
		}
		System.out.println();
	}

	public void levelOrderSpiralWithoutRecursionMethod2(BinaryTreeNode<Integer> node) {
		if (null == node) {
			return;
		}

		Deque<BinaryTreeNode<Integer>> stack1 = new LinkedList<BinaryTreeNode<Integer>>();
		Deque<BinaryTreeNode<Integer>> stack2 = new LinkedList<BinaryTreeNode<Integer>>();
		stack1.addFirst(node);

		boolean ltr = false;
		while (!stack1.isEmpty()) {
			BinaryTreeNode<Integer> cur = stack1.pop();
			System.out.print(cur.data + " ");

			if (ltr) {
				if (cur.left != null)
					stack2.addFirst(cur.left);
				if (cur.right != null)
					stack2.addFirst(cur.right);
			} else {
				if (cur.right != null)
					stack2.addFirst(cur.right);
				if (cur.left != null)
					stack2.addFirst(cur.left);

			}
			if (stack1.isEmpty()) {
				Deque<BinaryTreeNode<Integer>> temp = stack1;
				stack1 = stack2;
				stack2 = temp;
				ltr = !ltr;
			}
		}
		System.out.println();
	}
}
