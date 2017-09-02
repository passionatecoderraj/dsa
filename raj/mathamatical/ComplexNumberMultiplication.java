/**
 * 
 */
package com.raj.mathamatical;

/**
 * @author Raj
 *
 *         Given two strings representing two complex numbers.
 * 
 *         You need to return a string representing their multiplication. Note
 *         i2 = -1 according to the definition.
 * 
 *         Example 1: Input: "1+1i", "1+1i"
 * 
 *         Output: "0+2i" Explanation: (1 + i) * (1 + i) = 1 + i2 + 2 * i = 2i,
 *         and you need convert it to the form of 0+2i.
 * 
 * 
 *         Example 2: Input: "1+-1i", "1+-1i" Output: "0+-2i" Explanation: (1 -
 *         i) * (1 - i) = 1 + i2 - 2 * i = -2i, and you need convert it to the
 *         form of 0+-2i.
 */
public class ComplexNumberMultiplication {

	// (a1+b1)*(a2+b2) = (a1a2 + b1b2 + (a1b2+b1a2))
	public String multiply(String a, String b) {
		StringBuilder result = new StringBuilder();
		String A[] = a.split("\\+");
		String B[] = b.split("\\+");
		int a1 = Integer.parseInt(A[0]);
		int a2 = Integer.parseInt(B[0]);
		int b1 = Integer.parseInt(A[1].replace("i", ""));
		int b2 = Integer.parseInt(B[1].replace("i", ""));

		int a1a2 = a1 * a2;
		int b1b2 = (b1 * b2 * -1);
		int a1b2b1a2 = (a1 * b2) + (b1 * a2);
		int res = a1a2 + b1b2;
		result.append(res);
		result.append("+");
		result.append(a1b2b1a2);
		result.append("i");

		return result.toString();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ComplexNumberMultiplication obj = new ComplexNumberMultiplication();
		String res = null;
		String a, b;
		a = "1+1i";
		b = "1+1i";
		res = obj.multiply(a, b);
		System.out.println(res);
		a = "1+-1i";
		b = "1+-1i";
		res = obj.multiply(a, b);
		System.out.println(res);

		a = "1+0i";
		b = "1+0i";
		res = obj.multiply(a, b);
		System.out.println(res);

	}

}
