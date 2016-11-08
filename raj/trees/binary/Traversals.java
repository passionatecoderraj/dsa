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
public class Traversals {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Traversals obj = new Traversals();

		BinaryTree ob = new BinaryTree();
		ob.insert(1);
		ob.insert(2);
		ob.insert(3);
		ob.insert(4);
		ob.insert(5);

		BinaryTreeNode<Integer> root = ob.root;
		obj.inOrder(root);
		System.out.println();
		obj.inOrderWithoutRecursion(root);
		obj.preOrder(root);
		System.out.println();
		obj.preOrderWithoutRecursion(root);
		obj.postOrder(root);
		System.out.println();
		obj.postOrderWithoutRecursion(root);
		obj.levelOrder(root);

	}

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

	public static void levelOrderWithMarkers(BinaryTreeNode<Integer> node) {

		Deque<BinaryTreeNode<Integer>> queue = new LinkedList<BinaryTreeNode<Integer>>();

		queue.addLast(node);
		queue.addLast(null);

		while (!queue.isEmpty()) {
			BinaryTreeNode<Integer> cur = queue.removeFirst();

			if (cur == null) {
				if (!queue.isEmpty()) {
					System.out.print(" | ");
					queue.addLast(null);
				}
				continue;
			}
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

	public void levelOrder(BinaryTreeNode<Integer> node) {
		if (null == node) {
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

	public void inOrderWithoutRecursion(BinaryTreeNode<Integer> node) {
		if (null == node) {
			return;
		}

		Deque<BinaryTreeNode<Integer>> stack = new LinkedList<BinaryTreeNode<Integer>>();
		BinaryTreeNode<Integer> temp = node;
		while (true) {
			if (temp != null) {
				stack.addFirst(temp);
				temp = temp.left;
			} else {
				if (stack.isEmpty()) {
					break;
				}
				temp = stack.removeFirst();
				System.out.print(temp.data + " ");
				temp = temp.right;
			}
		}
		System.out.println();
	}

	public void preOrderWithoutRecursion(BinaryTreeNode<Integer> node) {
		if (null == node) {
			return;
		}

		Deque<BinaryTreeNode<Integer>> stack = new LinkedList<BinaryTreeNode<Integer>>();
		BinaryTreeNode<Integer> temp = node;
		while (true) {
			if (temp != null) {
				System.out.print(temp.data + " ");
				stack.addFirst(temp);
				temp = temp.left;
			} else {
				if (stack.isEmpty()) {
					break;
				}
				temp = stack.removeFirst();
				temp = temp.right;
			}
		}
		System.out.println();
	}

	public void postOrderWithoutRecursion(BinaryTreeNode<Integer> node) {
		if (null == node) {
			return;
		}

		Deque<BinaryTreeNode<Integer>> stack1 = new LinkedList<BinaryTreeNode<Integer>>();
		Deque<BinaryTreeNode<Integer>> stack2 = new LinkedList<BinaryTreeNode<Integer>>();
		BinaryTreeNode<Integer> temp = node;
		stack1.addFirst(temp);
		while (!stack1.isEmpty()) {
			BinaryTreeNode<Integer> cur = stack1.removeFirst();
			stack2.addFirst(cur);
			if (cur.left != null) {
				stack1.addFirst(cur.left);
			}
			if (cur.right != null) {
				stack1.push(cur.right);
			}
		}

		while (!stack2.isEmpty())
			System.out.print(stack2.removeFirst().data + " ");

		System.out.println();
	}

}
