/**
 * 
 */
package com.raj.trees.bst;

import java.util.ArrayList;

import com.raj.nodes.BinaryTreeNode;

/**
 * @author Raj
 *
 */
public class FindUniqueBinarySearchTrees {

	public ArrayList<BinaryTreeNode<Integer>> findUniqueBinarySearchTreeNodes(int n) {
		if (n == 0)
			return new ArrayList<>();
		ArrayList<BinaryTreeNode<Integer>>[][] t = new ArrayList[n][n];

		for (int i = 0; i < n; i++) {
			ArrayList<BinaryTreeNode<Integer>> list = new ArrayList<>();
			list.add(new BinaryTreeNode<Integer>(i + 1));
			t[i][i] = list;
		}

		for (int l = 2; l <= n; l++) {
			for (int i = 0; i < n - l + 1; i++) {
				int j = i + l - 1;
				t[i][j] = new ArrayList<>();
				for (int k = i; k <= j; k++) {
					ArrayList<BinaryTreeNode<Integer>> left, right;
					if (i == k) {
						left = new ArrayList<>();
						left.add(null);
					} else {
						left = t[i][k - 1];
					}
					if (j == k) {
						right = new ArrayList<>();
						right.add(null);
					} else {
						right = t[k + 1][j];
					}
					for (BinaryTreeNode<Integer> lval : left) {
						for (BinaryTreeNode<Integer> rval : right) {
							BinaryTreeNode<Integer> val = new BinaryTreeNode<Integer>(k + 1);
							val.left = lval;
							val.right = rval;
							t[i][j].add(val);
						}
					}
				}
			}
		}
		return t[0][n - 1];
	}

	public ArrayList<String> findUniqueBinarySearchTrees(int n) {
		ArrayList<String>[][] t = new ArrayList[n][n];
		for (int i = 0; i < n; i++) {
			ArrayList<String> list = new ArrayList<>();
			list.add(Integer.toString(i));
			t[i][i] = list;
		}

		for (int l = 2; l <= n; l++) {
			for (int i = 0; i < n - l + 1; i++) {
				int j = i + l - 1;
				t[i][j] = new ArrayList<>();
				for (int k = i; k <= j; k++) {
					ArrayList<String> left, right;
					if (i == k) {
						left = new ArrayList<>();
						left.add("");
					} else {
						left = t[i][k - 1];
					}
					if (j == k) {
						right = new ArrayList<>();
						right.add("");
					} else {
						right = t[k + 1][j];
					}
					for (String lval : left) {
						for (String rval : right) {
							String val = Integer.toString(k) + lval + rval;
							t[i][j].add(val);
						}
					}
				}
			}
		}
		return t[0][n - 1];
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FindUniqueBinarySearchTrees obj = new FindUniqueBinarySearchTrees();
		int n = 4;
		ArrayList result = null;
		result = obj.findUniqueBinarySearchTrees(n);
		System.out.println(result);

		ArrayList<BinaryTreeNode<Integer>> res = obj.findUniqueBinarySearchTreeNodes(n);
		for (BinaryTreeNode<Integer> node : res) {
			preOrder(node);
			System.out.print(" ");
		}

		System.out.println();

	}

	private static void preOrder(BinaryTreeNode<Integer> node) {
		if (null == node)
			return;
		System.out.print(node.data);
		preOrder(node.left);
		preOrder(node.right);
	}
}
