/**
 * 
 */
package com.raj.trees.bst;

import com.raj.nodes.BinaryTreeNode;

/**
 * @author Raj
 * 
 *         In a BST, while traversing left code is '0' and while traversing
 *         right code is '1'. Given bst, and key, return huffman code to find
 *         this key.
 * 
 *         However, You were not given bst rather given array which builds bst
 *         in the order they arrive
 * 
 *
 */
public class BuildHuffmanCodeFromArray {

	// Time : O(n), Space : O(1)
	private String buildHuffmanCodeFromArray(int[] a, int key) {
		StringBuilder code = new StringBuilder();
		int min = Integer.MIN_VALUE, max = Integer.MAX_VALUE;
		for (int num : a) {
			if (num >= min && num <= max) {
				if (num > key) {
					code.append(0);
					max = num;
				} else if (num < key) {
					code.append(1);
					min = num;
				} else {
					return code.toString();
				}
			}
		}
		return code.toString();
	}

	public static void main(String[] args) {
		BuildHuffmanCodeFromArray obj = new BuildHuffmanCodeFromArray();
		int a[] = { 8, 3, 10, 1, 6, 14, 4, 7, 13 };
		String res = "";
		res = obj.buildHuffmanCodeFromArray(a, 6);
		System.out.println(res);
		res = obj.buildHuffmanCodeFromArray(a, 7);
		System.out.println(res);
		res = obj.buildHuffmanCodeFromArray(a, 14);
		System.out.println(res);

	}

	public BinaryTreeNode<Integer> lca(BinaryTreeNode<Integer> root, int x, int y) {
		if (null == root) {
			return null;
		}
		if (root.data > Math.max(x, y)) {
			return lca(root.left, x, y);
		} else if (root.data < Math.min(x, y)) {
			return lca(root.right, x, y);
		} else
			return root;
	}

}
