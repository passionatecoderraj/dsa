/**
 * 
 */
package com.raj.backtracking;

import com.interivew.graph.CommonUtil;

/**
 * @author Raj
 *
 */
public class PermutationsOfString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PermutationsOfString obj = new PermutationsOfString();
		String str = "algo";
		int n = str.length();
		// obj.permuations(str.toCharArray(), 0, n - 1);
		obj.permuationsOfLengthK(str.toCharArray(), 0, 2);
	}

	public void permuations(char[] a, int l, int r) {
		if (l == r) {
			CommonUtil.printArray(a);
		} else {
			for (int i = l; i <= r; i++) {
				CommonUtil.swap(a, i, l);
				permuations(a, l + 1, r);
				CommonUtil.swap(a, i, l);
			}
		}

	}

	public void permuationsOfLengthK(char[] a, int l, int k) {
		if (l == k) {
			for (int i = 0; i < k; i++)
				System.out.print(a[i] + "");
			System.out.print(" ");
			return;
		}

		for (int i = l; i < a.length; i++) {
			CommonUtil.swap(a, i, l);
			permuationsOfLengthK(a, l + 1, k);
			CommonUtil.swap(a, i, l);
		}

	}

}
