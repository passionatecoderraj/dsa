/**
 * 
 */
package com.raj.leetcode;

/**
 * @author Raj
 *
 *         Given a number N, return a string consisting of "0"s and "1"s that
 *         represents its value in base -2 (negative two).
 * 
 *         The returned string must have no leading zeroes, unless the string is
 *         "0".
 * 
 * 
 * 
 *         Example 1:
 * 
 *         Input: 2 Output: "110" Explantion: (-2) ^ 2 + (-2) ^ 1 = 2 Example 2:
 * 
 *         Input: 3 Output: "111" Explantion: (-2) ^ 2 + (-2) ^ 1 + (-2) ^ 0 = 3
 *         Example 3:
 * 
 *         Input: 4 Output: "100" Explantion: (-2) ^ 2 = 4
 * 
 * 
 *         Note:
 * 
 *         0 <= N <= 10^9
 * 
 */
public class ConverttoBaseMinus2 {

	/*
	 * 
	 * dividing negative number by negative number is different -1/-2 = 0(quotient),
	 * reminder = -1
	 * 
	 * https://leetcode.com/problems/convert-to-base-2/discuss/387723/Intuitive-Java
	 * -Solution-With-Clear-Explanation n = 2, p = -n, num = p * q + r q = quotient,
	 * r = reminder if r is negative, then do +n, -n num = p * q + r+n-n but -n=p
	 * num = p *q + r+n+p num = p*(q+1) + (r+n) when d<0, (1) increment reminder by
	 * r, (2) increment quotient by 1
	 * 
	 * 
	 */
	public String baseNeg2(int N) {
		if (N == 0)
			return "0";
		StringBuilder res = new StringBuilder();
		int n = 2, p = -n;
		int r, q;
		while (N != 0) {
			r = N % p;
			q = N / p;
			System.out.println(N + ",q=" +q  + ", r=" + r);

			if (r < 0) {
				r += n;
				q++;
			}
			res.append(r);
			N = q;
		}
		return res.reverse().toString();
	}

	// https://leetcode.com/problems/convert-to-base-2/discuss/265507/JavaC++Python-2-lines-Exactly-Same-as-Base-2
	public String baseNeg2_2(int N) {
		StringBuilder res = new StringBuilder();
		while (N != 0) {
			System.out.println(N + " - " + Integer.toBinaryString(N));
			res.append(N & 1);
			// same as base 2 except divide by -2 instead of 2
			N = -(N >> 1);
		}
		return res.length() > 0 ? res.reverse().toString() : "0";
	}

	public static void main(String[] args) {
		ConverttoBaseMinus2 obj = new ConverttoBaseMinus2();
		String result = "";
		int n = 2;
		result = obj.baseNeg2(n);
		System.out.println(result);

		result = obj.baseNeg2(3);
		System.out.println(result);

		result = obj.baseNeg2(4);
		System.out.println(result);
	}
}
