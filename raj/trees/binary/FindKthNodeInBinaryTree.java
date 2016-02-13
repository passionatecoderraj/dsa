/**
 * 
 */
package com.raj.trees.binary;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

import com.raj.nodes.BinaryTreeNode;

/**
 * @author Raj
 *
 */
public class FindKthNodeInBinaryTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FindKthNodeInBinaryTree obj = new FindKthNodeInBinaryTree();

		BinaryTree ob = new BinaryTree();
		ob.insert(1);
		ob.insert(2);
		ob.insert(3);
		ob.insert(4);
		ob.insert(5);
		ob.insert(6);
		ob.insert(7);
		ob.insert(8);

		ob.inOrder(ob.root);
		int result = -1;
		int k = 3;
		result = obj.findKthSmallest(ob.root, k);
		System.out.println();
		System.out.println(result);

	}

	public int findKthSmallest(BinaryTreeNode<Integer> root, int k) {
		if (null == root)
			return -1;
		int n = BinaryTree.size(root);
		int a[] = new int[n];
		inorder(root, a);
		Arrays.sort(a);
		return a[k - 1];
	}

	int i = 0;

	public void inorder(BinaryTreeNode<Integer> root, int[] a) {
		if (root != null) {
			inorder(root.left, a);
			a[i++] = root.data;
			inorder(root.right, a);
		}
	}

}
