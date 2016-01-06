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
public class FindMax {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FindMax obj = new FindMax();

		BinaryTree ob = new BinaryTree();
		ob.insert(1);
		ob.insert(2);
		ob.insert(3);
		ob.insert(4);
		ob.insert(5);

		BinaryTreeNode<Integer> root = ob.root;

		int result = -1;
		int max = Integer.MIN_VALUE;
		result = obj.findMax(root, max);
		System.out.println(result);

		max = Integer.MIN_VALUE;
		result = obj.findMaxWithoutRecursion(root, max);
		System.out.println(result);

	}

	public int findMax(BinaryTreeNode<Integer> root, int max) {
		if (root == null) {
			return max;
		}
		int lmax = findMax(root.left, max);
		int rmax = findMax(root.right, max);
		max = Math.max(Math.max(lmax, rmax), root.data);
		return max;
	}

	public int findMaxWithoutRecursion(BinaryTreeNode<Integer> node, int max) {
		if (null == node) {
			return max;
		}

		Deque<BinaryTreeNode<Integer>> queue = new LinkedList<BinaryTreeNode<Integer>>();
		queue.addLast(node);

		while (!queue.isEmpty()) {
			BinaryTreeNode<Integer> cur = queue.removeFirst();
			if (cur.data > max)
				max = cur.data;
			if (cur.left != null) {
				queue.addLast(cur.left);
			}
			if (cur.right != null) {
				queue.addLast(cur.right);
			}
		}
		return max;
	}

}
