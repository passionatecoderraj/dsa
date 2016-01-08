/**
 * 
 */
package com.raj.trees.binary;

import java.util.Arrays;

import com.raj.nodes.BinaryTreeNode;

/**
 * @author Raj
 *
 */
public class ConstructBinarySearchTreeFromBinaryTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ConstructBinarySearchTreeFromBinaryTree obj = new ConstructBinarySearchTreeFromBinaryTree();

		BinaryTree ob = new BinaryTree();
		ob.insert(1);
		ob.insert(2);
		ob.insert(3);
		ob.insert(4);
		ob.insert(5);
		ob.insert(6);

		ob.inOrder(ob.root);
		System.out.println();

		// Time : O(nlogn) (depending on the sorting algorithm

		obj.binaryTreeToBST(ob);

		ob.inOrder(ob.root);
		System.out.println();
		ob.preOrder(ob.root);
		System.out.println();
	}

	public void binaryTreeToBST(BinaryTree tree) {
		int n = tree.size(tree.root);
		int a[] = new int[n];
		this.index = 0;
		copyInorderValuesInArray(tree.root, a);
		// CommonUtil.printArray(a);
		Arrays.sort(a);
		// CommonUtil.printArray(a);
		this.index = 0;
		copyArrayValueToInorderNode(tree.root, a);
	}

	int index = 0;

	public void copyInorderValuesInArray(BinaryTreeNode<Integer> root, int[] a) {
		if (root == null)
			return;
		copyInorderValuesInArray(root.left, a);
		a[index++] = root.data;
		copyInorderValuesInArray(root.right, a);
	}

	public void copyArrayValueToInorderNode(BinaryTreeNode<Integer> root, int[] a) {
		if (root == null)
			return;
		copyArrayValueToInorderNode(root.left, a);
		root.data = a[index++];
		copyArrayValueToInorderNode(root.right, a);
	}
}
