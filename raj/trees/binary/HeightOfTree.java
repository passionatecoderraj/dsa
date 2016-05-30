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
public class HeightOfTree {

	public BinaryTreeNode<Integer> createTestTree1() {
		BinaryTreeNode<Integer> n1 = new BinaryTreeNode<Integer>(1);
		BinaryTreeNode<Integer> n2 = new BinaryTreeNode<Integer>(2);
		BinaryTreeNode<Integer> n3 = new BinaryTreeNode<Integer>(3);
		BinaryTreeNode<Integer> n4 = new BinaryTreeNode<Integer>(4);
		BinaryTreeNode<Integer> n5 = new BinaryTreeNode<Integer>(5);
		BinaryTreeNode<Integer> n6 = new BinaryTreeNode<Integer>(6);
		BinaryTreeNode<Integer> n7 = new BinaryTreeNode<Integer>(7);
		BinaryTreeNode<Integer> n8 = new BinaryTreeNode<Integer>(8);
		BinaryTreeNode<Integer> n9 = new BinaryTreeNode<Integer>(9);
		BinaryTreeNode<Integer> n10 = new BinaryTreeNode<Integer>(10);
		BinaryTreeNode<Integer> n11 = new BinaryTreeNode<Integer>(11);
		BinaryTreeNode<Integer> n12 = new BinaryTreeNode<Integer>(12);
		BinaryTreeNode<Integer> n13 = new BinaryTreeNode<Integer>(13);

		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		n3.right = n7;
		n7.right = n6;
		

		n4.right = n5;
		n5.left = n4;

		n5.right = n6;
		n6.left = n5;

		n6.right = n4;
		n4.left = n6;
		return n1;
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

	public int height(BinaryTreeNode<Integer> root) {
		if (null == root) {
			return 0;
		}
		if (isLeaf(root)) {
			return 1;
		}
		return 1 + Math.max(height(root.left), height(root.right));
	}

	private boolean isLeaf(BinaryTreeNode<Integer> root) {
		BinaryTreeNode<Integer> left = root.left;
		if (null == left)
			return false;
		return left.right == root;
	}

}
