package com.raj.leetcode;

/*
 * Add two binary numbers
 * 
 * 
 * http://www.programcreek.com/2014/05/leetcode-add-binary-java/
 */
public class AddTwoBinaryNumbers {

	public static void main(String args[]) {
		AddTwoBinaryNumbers s = new AddTwoBinaryNumbers();
		String b1 = "11", b2 = "111";

		String result = null;
		result = s.addTwoBinaryNumbers(b1, b2);
		System.out.println(result);

	}

	// Time :O(m+n)
	public String addTwoBinaryNumbers(String b1, String b2) {
		if (b1 == null || b1.length() <= 0)
			return b2;
		if (b2 == null || b2.length() <= 0)
			return b1;
		StringBuilder sb = new StringBuilder();

		int carry = 0, l, r, res;
		int i = b1.length() - 1, j = b2.length() - 1;
		while (i >= 0 || j >= 0) {
			l = (i >= 0) ? b1.charAt(i) - '0' : 0;
			r = (j >= 0) ? b2.charAt(j) - '0' : 0;
			res = l + r + carry;
			if (res == 3) {
				sb.append('1');
				carry = 1;
			} else if (res == 2) {
				sb.append('0');
				carry = 1;
			} else {
				sb.append(res);
				carry = 0;
			}
			i--;
			j--;
		}
		if (carry == 1)
			sb.append(carry);
		return sb.reverse().toString();
	}
}