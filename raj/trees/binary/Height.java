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
public class Height {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Height obj = new Height();

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
		result = obj.height(root);
		System.out.println(result);

		result = obj.heightWithoutRecursion(root);
		System.out.println(result);

	}

	public int height(BinaryTreeNode<Integer> root) {
		if (null == root)
			return 0;
		return 1 + Math.max(height(root.left), height(root.right));
	}

	public int heightWithoutRecursion(BinaryTreeNode<Integer> node) {
		int level = 0;
		if (null == node) {
			return level;
		}

		Deque<BinaryTreeNode<Integer>> queue = new LinkedList<BinaryTreeNode<Integer>>();
		queue.addLast(node);
		queue.addLast(null);

		while (!queue.isEmpty()) {
			BinaryTreeNode<Integer> cur = queue.removeFirst();
			if (cur == null) {
				level++;
				if (queue.isEmpty())
					break;
				queue.addLast(null);
			} else {
				if (cur.left != null) {
					queue.addLast(cur.left);
				}
				if (cur.right != null) {
					queue.addLast(cur.right);
				}
			}

		}
		return level;
	}

}
