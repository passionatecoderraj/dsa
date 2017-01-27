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
		String str = "raj";
		int n = str.length();
		obj.permuations(str.toCharArray(), 0, n - 1);
		// obj.permuationsOfLengthK(str.toCharArray(), 0, 2);
		System.out.println();
		// obj.permuationsUnique(str.toCharArray(), 0);
	}

	public void permuationsUnique(char a[], int i) {
		if (i == a.length) {
			CommonUtil.printArray(a);
		}
		for (int j = i; j < a.length; j++) {
			if (!containsDuplicate(a, i, j - 1, a[j])) {
				CommonUtil.swap(a, i, j);
				permuationsUnique(a, i + 1);
				CommonUtil.swap(a, i, j);
			}
		}
	}

	private boolean containsDuplicate(char[] a, int start, int end, int k) {
		for (int i = start;	 i <= end; i++) {
			if (a[i] == k)
				return true;
		}
		return false;
	}

	public void permuations(char a[], int i) {
		if (i == a.length) {
			CommonUtil.printArray(a);
		}
		for (int j = i; j < a.length; j++) {
			CommonUtil.swap(a, i, j);
			permuations(a, i + 1);
			CommonUtil.swap(a, i, j);
		}
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
