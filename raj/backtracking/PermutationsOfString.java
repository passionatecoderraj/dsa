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
		String str = "abcd";
		int n = str.length();
		obj.permuations(str.toCharArray(), 0, n - 1);
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

}
