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
public class FindNumberOfFullNodes {

	public int numberOfFullNodes(BinaryTreeNode<Integer> root) {
		if (null == root)
			return 0;
		int n = 0;
		if (isFullNode(root)) {
			n = 1;
		}
		return n + numberOfFullNodes(root.left) + numberOfFullNodes(root.right);
	}

	private boolean isFullNode(BinaryTreeNode<Integer> root) {
		return root.left != null && root.right != null;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FindNumberOfFullNodes obj = new FindNumberOfFullNodes();

		BinaryTree ob = new BinaryTree();
		ob.insert(1);
		ob.insert(2);
		ob.insert(3);
		ob.insert(4);
		ob.insert(5);
		ob.insert(6);
		ob.insert(7);
		ob.insert(8);
		ob.insert(9);

		BinaryTreeNode<Integer> root = ob.root;

		int result = -1;
		result = obj.numberOfFullNodes(root);
		System.out.println(result);

		result = obj.numberOfleavesWithoutRecursion(root);
		System.out.println(result);

	}

	public int numberOfleavesWithoutRecursion(BinaryTreeNode<Integer> node) {
		int n = 0;
		if (null == node) {
			return n;
		}

		Deque<BinaryTreeNode<Integer>> queue = new LinkedList<BinaryTreeNode<Integer>>();
		queue.addLast(node);

		while (!queue.isEmpty()) {
			BinaryTreeNode<Integer> cur = queue.removeFirst();
			if (isFullNode(cur)) {
				n++;
			}
			if (cur.left != null) {
				queue.addLast(cur.left);
			}
			if (cur.right != null) {
				queue.addLast(cur.right);
			}
		}
		return n;
	}

}
