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
public class NumberOfNodes {

	// Time :O(n), Space :O(n)
	public int size(BinaryTreeNode<Integer> root) {
		if (null == root)
			return 0;
		return 1 + size(root.left) + size(root.right);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		NumberOfNodes obj = new NumberOfNodes();

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

		int result = -1;
		result = obj.size(root);
		System.out.println(result);

		result = obj.sizeWithoutRecursion(root);
		System.out.println(result);

	}

	public int sizeWithoutRecursion(BinaryTreeNode<Integer> node) {
		int n = 0;
		if (null == node) {
			return n;
		}

		Deque<BinaryTreeNode<Integer>> queue = new LinkedList<BinaryTreeNode<Integer>>();
		queue.addLast(node);

		while (!queue.isEmpty()) {
			BinaryTreeNode<Integer> cur = queue.removeFirst();
			n++;
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
