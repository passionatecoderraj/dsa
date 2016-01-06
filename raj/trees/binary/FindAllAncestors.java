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
public class FindAllAncestors {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FindAllAncestors obj = new FindAllAncestors();

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

		boolean result = false;
		int k = 7;
		result = obj.printAllAncestors(root, k);
		System.out.println(result);
	}

	public boolean printAllAncestors(BinaryTreeNode<Integer> root, int k) {
		if (null == root) {
			return false;
		}
		if (root.data == k) {
			System.out.println(root.data);
			return true;
		}
		if (printAllAncestors(root.left, k) || printAllAncestors(root.right, k)) {
			System.out.println(root.data);
			return true;
		}
		return false;
	}

	public boolean search(BinaryTreeNode<Integer> root, int k) {
		if (null == root) {
			return false;
		}
		if (root.data == k) {
			return true;
		}
		return search(root.left, k) || search(root.right, k);
	}

	public boolean searchWithoutRecursion(BinaryTreeNode<Integer> node, int k) {
		if (null == node) {
			return false;
		}

		Deque<BinaryTreeNode<Integer>> queue = new LinkedList<BinaryTreeNode<Integer>>();
		queue.addLast(node);

		while (!queue.isEmpty()) {
			BinaryTreeNode<Integer> cur = queue.removeFirst();
			if (cur.data == k)
				return true;

			if (cur.left != null) {
				queue.addLast(cur.left);
			}
			if (cur.right != null) {
				queue.addLast(cur.right);
			}
		}
		return false;
	}

}
