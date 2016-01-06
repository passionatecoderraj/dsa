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
public class FindDeepestNode {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FindDeepestNode obj = new FindDeepestNode();

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

		BinaryTreeNode<Integer> result = null;
		result = obj.findDeepestNode(root);
		System.out.println(result);

	}

	public BinaryTreeNode<Integer> findDeepestNode(BinaryTreeNode<Integer> node) {
		if (null == node) {
			return null;
		}

		BinaryTreeNode<Integer> deepNode = null;
		Deque<BinaryTreeNode<Integer>> queue = new LinkedList<BinaryTreeNode<Integer>>();
		queue.addLast(node);

		while (!queue.isEmpty()) {
			BinaryTreeNode<Integer> cur = queue.removeFirst();
			deepNode = cur;
			if (cur.left != null) {
				queue.addLast(cur.left);
			}
			if (cur.right != null) {
				queue.addLast(cur.right);
			}
		}
		return deepNode;
	}

}
