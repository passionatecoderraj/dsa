/**
 * 
 */
package com.raj.trees.binary;

import com.raj.nodes.BinaryTreeNode;

/**
 * @author Raj
 *
 */
public class HasPathSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		HasPathSum obj = new HasPathSum();

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
		int sum = 20;
		result = obj.hasPathSum(root, sum);
		System.out.println(result);
	}

	public boolean hasPathSum(BinaryTreeNode<Integer> root, int sum) {
		if (root == null) {
			return sum == 0;
		}
		return hasPathSum(root.left, sum - root.data) || hasPathSum(root.right, sum - root.data);
	}
}
