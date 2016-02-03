/**
 * 
 */
package com.raj.dp.matrix;

/**
 * @author Raj
 *
 */
public class MinNumberOfOpertionsToConvertToPalindrome {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str = "ananab";
		// this program may be wrong
		int result = -1;
		MinNumberOfOpertionsToConvertToPalindrome obj = new MinNumberOfOpertionsToConvertToPalindrome();
		result = obj.numberOfOperations(str);
		System.out.println(result);
	}

	public int numberOfOperations(String str) {
		int n = str.length();
		int l = 0, r = n - 1;
		int total = 0, v;
		while (l < r) {
			if (str.charAt(l) != str.charAt(r)) {
				v = Math.abs(Character.getNumericValue(str.charAt(r)) - Character.getNumericValue(str.charAt(l)));
				total += v;
			}
			l++;
			r--;
		}
		return total;
	}

}
