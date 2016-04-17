/**
 * 
 */
package com.raj.trees.binary;

import java.util.LinkedList;
import java.util.Queue;

import com.raj.nodes.BinaryTreeNode;

/**
 * @author Raj
 *
 */

/*
 * http://algorithms.tutorialhorizon.com/in-a-binary-tree-check-if-two-nodes-are
 * -cousins/
 */
/*
 * Check the level of both nodes, if heights are different then return false.
 * 
 * Check if both the nodes has the same parent, if yes then return false. e
 * 
 * else return true.
 */
public class CheckIfTwoNodesAreCousins {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CheckIfTwoNodesAreCousins obj = new CheckIfTwoNodesAreCousins();

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
		result = obj.checkIfTwoNodesAreSiblings(root, 4, 7);
		System.out.println(result);

		result = obj.checkIfTwoNodesAreSiblings(root, 6, 7);
		System.out.println(result);

		result = obj.checkIfTwoNodesAreSiblings(root, 6, 8);
		System.out.println(result);

	}

	public BinaryTreeNode<Integer> findTreeNode(BinaryTreeNode<Integer> root, int data) {
		if (null == root)
			return root;
		if (root.data == data)
			return root;
		BinaryTreeNode<Integer> left = findTreeNode(root.left, data);
		if (null != left)
			return left;
		return findTreeNode(root.right, data);
	}

	// Time : O(n)
	public boolean checkIfTwoNodesAreSiblings(BinaryTreeNode<Integer> root, int a, int b) {
		if (level(root, a) != level(root, b)) {
			return false;
		}
		CheckIfTwoNodesAreSiblings obj = new CheckIfTwoNodesAreSiblings();
		if (obj.checkIfTwoNodesAreSiblings(root, a, b)) {
			return false;
		}
		return true;
	}

	public int level(BinaryTreeNode<Integer> root, int data) {
		if (root == null)
			return Integer.MIN_VALUE;
		Queue<BinaryTreeNode<Integer>> q = new LinkedList<>();
		q.add(root);
		q.add(null);
		int level = 1;
		BinaryTreeNode<Integer> temp;
		while (!q.isEmpty()) {
			temp = q.poll();
			if (temp == null) {
				if (q.isEmpty())
					break;
				q.add(null);
				level++;
				continue;
			}
			if (temp.data == data)
				return level;

			if (temp.left != null)
				q.add(temp.left);
			if (temp.right != null)
				q.add(temp.right);
		}

		return Integer.MIN_VALUE;
	}

}
