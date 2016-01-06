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
public class Search {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Search obj = new Search();

		BinaryTree ob = new BinaryTree();
		ob.insert(1);
		ob.insert(2);
		ob.insert(3);
		ob.insert(4);
		ob.insert(5);

		BinaryTreeNode<Integer> root = ob.root;

		boolean result = false;
		int k = 33;
		result = obj.search(root, k);
		System.out.println(result);

		result = obj.searchWithoutRecursion(root, k);
		System.out.println(result);

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
