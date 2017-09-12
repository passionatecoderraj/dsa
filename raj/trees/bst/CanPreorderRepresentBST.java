/**
 * 
 */
package com.raj.trees.bst;

import java.util.Stack;

import com.raj.nodes.BinaryTreeNode;

/**
 * @author Raj
 *
 *         https://discuss.leetcode.com/topic/21217/java-o-n-and-o-1-extra-space
 */
public class CanPreorderRepresentBST {

	int preOrderIndex = 0;

	// Time : O(n), Space : O(n)
	public boolean canPreorderRepresentBST(int[] a) {
		preOrderIndex = 0;
		buildBSTFromPreOrder(a, Integer.MIN_VALUE, Integer.MAX_VALUE);
		return preOrderIndex == a.length;
	}

	private BinaryTreeNode<Integer> buildBSTFromPreOrder(int[] a, int min, int max) {
		if (preOrderIndex == a.length)
			return null;
		int data = a[preOrderIndex];
		if (data > min && data < max) {
			preOrderIndex++;
			BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(data);
			root.left = buildBSTFromPreOrder(a, min, data);
			root.right = buildBSTFromPreOrder(a, data, max);
		}
		return null;
	}

	// Time :O(n) , Space : O(n)
	// similar to next greater element
	public boolean canPreorderRepresentBSTUsingStack(int[] a) {
		Stack<Integer> stack = new Stack<>();
		int root = Integer.MIN_VALUE;
		for (int i : a) {
			if (i < root)
				return false;
			while (!stack.isEmpty() && i > stack.peek()) {
				root = stack.pop();
			}
			stack.push(i);
		}
		return true;
	}

	// Time : O(n) , Space :O(1)
	public boolean canPreorderRepresentBSTInConstantSpace(int[] a) {
		int root = Integer.MIN_VALUE, i = -1;
		for (int num : a) {
			if (num < root)
				return false;
			while (i >= 0 && num > a[i]) {
				root = a[i--];
			}
			a[++i] = num;
		}
		return true;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CanPreorderRepresentBST obj = new CanPreorderRepresentBST();

		boolean result = false;
		result = obj.canPreorderRepresentBST(new int[] { 2, 4, 3 });
		System.out.println(result);

		result = obj.canPreorderRepresentBST(new int[] { 40, 30, 35, 20, 80, 100 });
		System.out.println(result);

		// Time :O(n), Space :O(n)
		result = obj.canPreorderRepresentBSTUsingStack(new int[] { 40, 30, 35, 20, 80, 100 });
		System.out.println(result);

		// Time :O(n), Space :O(1)
		result = obj.canPreorderRepresentBSTInConstantSpace(new int[] { 40, 30, 35, 20, 80, 100 });
		System.out.println(result);

	}

}
