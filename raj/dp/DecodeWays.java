/**
 * 
 */
package com.raj.dp;

import com.interivew.graph.CommonUtil;

/**
 * @author Raj
 *
 */
public class DecodeWays {

	// Time :O(n), Space : O(1)
	public static int decodeWaysDpConstantSpace(String str) {
		if (null == str || str.length() == 0)
			return 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) != '0') {
				break;
			}
			if (i == str.length() - 1)
				return 0;
		}
		int a = 1, b = 1, c = 1;
		for (int i = 2; i <= str.length(); i++) {
			c = 0;
			if (str.charAt(i - 1) > '0') {
				c = b;
			}

			if (str.charAt(i - 2) < '2' || (str.charAt(i - 2) == '2' && str.charAt(i - 1) < '7')) {
				c += a;
			}
			a = b;
			b = c;
		}
		return c;
	}

	// Time : O(n), Space :O(n)
	public static int decodeWaysDp(String str) {
		int t[] = new int[str.length() + 1];
		t[0] = t[1] = 1;
		for (int i = 2; i <= str.length(); i++) {

			if (str.charAt(i - 1) > '0') {
				t[i] = t[i - 1];
			}

			if (str.charAt(i - 2) < '2' || (str.charAt(i - 2) == '2' && str.charAt(i - 1) < '7')) {
				t[i] += t[i - 2];
			}
		}
		CommonUtil.printArray(t);
		return t[str.length()];
	}

	// Time : O(2^n)
	public static int decodeWaysBruteForce(String str, int n) {
		if (0 == n || 1 == n)
			return 1;
		int count = 0;
		if (str.charAt(n - 1) > '0') {
			count = decodeWaysBruteForce(str, n - 1);
		}
		if (str.charAt(n - 2) < '2' || (str.charAt(n - 2) == '2' && str.charAt(n - 1) < '7')) {
			count += decodeWaysBruteForce(str, n - 2);
		}
		return count;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int result = decodeWaysBruteForce("1234", 4);
		System.out.println(result);

		result = decodeWaysDp("1234");
		System.out.println(result);

		result = decodeWaysDpConstantSpace("1234");
		System.out.println(result);

		result = decodeWaysDpConstantSpace("0");
		System.out.println(result);

	}

}
