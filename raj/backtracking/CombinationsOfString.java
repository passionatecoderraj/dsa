/**
 * 
 */
package com.raj.backtracking;

/**
 * @author Raj
 *
 */
public class CombinationsOfString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CombinationsOfString obj = new CombinationsOfString();
		String str = "abcd";
		int n = str.length();
		obj.combinations(str.toCharArray(), n);
	}

	public void combinations(char[] a, int n) {
		StringBuilder op = new StringBuilder(n);
		combinationsUtil(a, 0, n, op);
	}

	public void combinationsUtil(char[] a, int start, int n, StringBuilder op) {
		if (start == n) {
			return;
		}
		for (int i = start; i < n; i++) {
			op.append(a[i]);
			System.out.println(op);
			combinationsUtil(a, i + 1, n, op);
			op.deleteCharAt(op.length() - 1);
		}
	}
}
