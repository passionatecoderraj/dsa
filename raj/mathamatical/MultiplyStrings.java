/**
 * 
 */
package com.raj.mathamatical;

/**
 * @author Raj
 *
 *         Given two non-negative integers num1 and num2 represented as strings,
 *         return the product of num1 and num2.
 * 
 *         Note:
 * 
 *         The length of both num1 and num2 is < 110. Both num1 and num2
 *         contains only digits 0-9. Both num1 and num2 does not contain any
 *         leading zero. You must not use any built-in BigInteger library or
 *         convert the inputs to integer directly
 */
public class MultiplyStrings {

	// Time :O(mn), Space :O(m+n)
	public static String multiply(String n1, String n2) {
		int t[] = new int[n1.length() + n2.length()];

		for (int i = n1.length() - 1; i >= 0; i--) {
			int carry = 0;
			for (int j = n2.length() - 1; j >= 0; j--) {
				int mul = (n1.charAt(i) - '0') * (n2.charAt(j) - '0');
				mul = mul + carry + t[i + j + 1];
				carry = mul / 10;
				t[i + j + 1] = mul % 10;
			}
			if (carry > 0) {
				t[i] = (char) carry;
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i : t)
			sb.append(i);
		while (sb.length() > 0 && sb.charAt(0) == '0') {
			sb.deleteCharAt(0);
		}

		return sb.toString();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String result = null;
		result = multiply("98", "74");
		System.out.println(result);
	}

}
