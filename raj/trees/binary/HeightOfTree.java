/**
 * 
 */
package com.raj.trees.binary;

import com.raj.nodes.BinaryTreeNode;

/**
 * @author Raj
 *
 */
public class HeightOfTree {

	// Time :O(n), Space :O(n)
	public int height(BinaryTreeNode<Integer> root) {
		if (null == root) {
			return 0;
		}
		return 1 + Math.max(height(root.left), height(root.right));
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		HeightOfTree obj = new HeightOfTree();

		BinaryTreeNode<Integer> root = obj.createTestTree1();

		int result = -1;
		result = obj.height(root);
		System.out.println(result);

	}

	public BinaryTreeNode<Integer> createTestTree1() {
		BinaryTreeNode<Integer> n1 = new BinaryTreeNode<Integer>(1);
		BinaryTreeNode<Integer> n2 = new BinaryTreeNode<Integer>(2);
		BinaryTreeNode<Integer> n3 = new BinaryTreeNode<Integer>(3);
		BinaryTreeNode<Integer> n4 = new BinaryTreeNode<Integer>(4);
		BinaryTreeNode<Integer> n5 = new BinaryTreeNode<Integer>(5);
		BinaryTreeNode<Integer> n6 = new BinaryTreeNode<Integer>(6);
		BinaryTreeNode<Integer> n7 = new BinaryTreeNode<Integer>(7);

		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		n3.right = n7;
		n7.right = n6;

		return n1;
	}
}
