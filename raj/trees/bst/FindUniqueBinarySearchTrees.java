/**
 * 
 */
package com.raj.trees.bst;

import java.util.ArrayList;

/**
 * @author Raj
 *
 */
public class FindUniqueBinarySearchTrees {

	

	public ArrayList findUniqueBinarySearchTrees(int n) {
		ArrayList t[][] = new ArrayList[n][n];

		for (int i = 0; i < n; i++) {
			ArrayList list = new ArrayList();
			list.add(Integer.toString(i));
			t[i][i] = list;
		}

		for (int l = 2; l <= n; l++) {
			for (int i = 0; i < n - l + 1; i++) {
				int j = i + l - 1;
				ArrayList cur = new ArrayList();
				for (int k = i; k <= j; k++) {
					// k is a root

					// left subtree
					ArrayList lst = getValue(t, i, k - 1);

					// right sub tree
					ArrayList rst = getValue(t, k + 1, j);

					for (Object left : lst) {
						for (Object right : rst) {
							String str = Integer.toString(k) + right.toString() + left.toString();
							cur.add(str);
						}
					}
				}
				t[i][j] = cur;
			}
		}

		System.out.println(t[0][n - 1].size());
		return t[0][n - 1];
	}

	private ArrayList getValue(ArrayList[][] t, int i, int j) {
		if (i > j) {
			ArrayList list = new ArrayList();
			list.add("");
			return list;
		}
		return t[i][j];
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
	}
}
