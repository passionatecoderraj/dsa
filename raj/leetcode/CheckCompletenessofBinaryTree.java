package com.raj.leetcode;

import java.util.LinkedList;
import java.util.Queue;

import com.raj.nodes.BinaryTreeNode;
import com.raj.trees.binary.BinaryTree;

/**
 * @author Raj
 *
 *
 *         Given a complete binary tree, count the number of nodes.
 */
public class CheckCompletenessofBinaryTree {

	public boolean isCompleteTree(BinaryTreeNode<Integer> root) {
		Queue<BinaryTreeNode<Integer>> q = new LinkedList<>();
		q.offer(root);
		boolean end = false;
		while (!q.isEmpty()) {
			BinaryTreeNode<Integer> temp = q.poll();
			if (null == temp)
				end = true;
			else {
				if (end)
					return false;
				q.offer(temp.left);
				q.offer(temp.right);
			}

		}
		return true;
	}

	public boolean isCompleteTree2(BinaryTreeNode<Integer> root) {
		Queue<BinaryTreeNode<Integer>> q = new LinkedList<>();
		q.offer(root);
		while (q.peek() != null) {
			BinaryTreeNode<Integer> temp = q.poll();
			q.offer(temp.left);
			q.offer(temp.right);
		}
		while (!q.isEmpty() && q.peek() == null) {
			q.poll();
		}

		return q.isEmpty();
	}

	public static void main(String[] args) {
		CheckCompletenessofBinaryTree obj = new CheckCompletenessofBinaryTree();

		BinaryTree ob = new BinaryTree();
		ob.insert(1);
		ob.insert(2);
		ob.insert(3);
		ob.insert(4);
		ob.insert(5);
		ob.insert(6);

		boolean result = false;
		result = obj.isCompleteTree(ob.root);
		System.out.println(result);

	}

}
