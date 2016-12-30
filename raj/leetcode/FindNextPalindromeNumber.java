/**
 * 
 */
package com.raj.leetcode;

import com.interivew.graph.CommonUtil;

/**
 * @author Raj
 *
 */
public class FindNextPalindromeNumber {

	public int[] nextPalindromeNumber(int[] a) {
		if (null == a || a.length == 0)
			return a;
		boolean all9s = true;
		int n = a.length;
		for (int i : a) {
			if (i != 9) {
				all9s = false;
				break;
			}
		}

		// if all9s then return 1 followed by n-1 0s then 1
		// ex : 999 -> 1001
		if (all9s) {
			int res[] = new int[n + 1];
			res[0] = res[n] = 1;
			for (int i = 1; i < n; i++) {
				res[i] = 0;
			}
			return res;
		}

		boolean isPalindrome = true, smallerLeft = false;

		int l = n / 2 - 1;
		int r = (n % 2 == 0) ? n / 2 : n / 2 + 1;

		int li = l, ri = r;
		while (li >= 0 && ri < n) {
			if (a[li] != a[ri]) {
				isPalindrome = false;
			}

			if (a[li] < a[ri]) {
				smallerLeft = true;
				break;
			}
			li--;
			ri++;
		}

		// if it's palindrome or smaller left then increment mid by 1 if there's
		// a carry increment left
		if (smallerLeft || isPalindrome) {
			li = r - 1;
			int carry = 1;
			while (li >= 0 && carry > 0) {
				int sum = carry + a[li];
				a[li] = sum % 10;
				carry = sum / 10;
				li--;
			}
		}
		li = l;
		ri = r;
		while (li >= 0) {
			a[ri++] = a[li--];
		}

		return a;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FindNextPalindromeNumber obj = new FindNextPalindromeNumber();
		int a[] = { 8, 8, 9, 9, 9 };
		int res[] = null;

		res = obj.nextPalindromeNumber(a);
		CommonUtil.printArray(res);
	}

}
