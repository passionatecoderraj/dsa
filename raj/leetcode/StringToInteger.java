package com.raj.leetcode;

/*
 *
 * String to Integer
 * 
 *http://www.programcreek.com/2012/12/leetcode-string-to-integer-atoi/ 
 */
public class StringToInteger {

	public static void main(String args[]) {
		StringToInteger s = new StringToInteger();
		String str = "   -2333   ";

		int result = -1;
		result = s.stringToInteger(str);
		System.out.println(result);

	}

	/*
	 * 
	 * 1. null or empty string
	 * 
	 * 2. white spaces
	 * 
	 * 3. +/- sign
	 * 
	 * 4. calculate real value
	 * 
	 * 5. handle min & max
	 */
	// Time :O(n), Space : O(1)
	public int stringToInteger(String str) {
		if (null == str || str.length() <= 0)
			return 0;

		str = str.trim();

		if (str.length() <= 0)
			return 0;

		double res = 0;
		boolean isNegative = false;

		int i = 0;
		if (str.charAt(i) == '-') {
			isNegative = true;
			i++;
		} else if (str.charAt(i) == '+') {
			isNegative = false;
			i++;
		}

		for (; i < str.length(); i++) {
			int a = str.charAt(i) - '0';
			res = (res * 10) + a;
		}
		if (isNegative) {
			res = -res;
		}
		if (res < Integer.MIN_VALUE)
			return Integer.MIN_VALUE;
		else if (res > Integer.MAX_VALUE)
			return Integer.MAX_VALUE;

		return (int) res;
	}

}