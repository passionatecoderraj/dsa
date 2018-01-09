package com.raj.mathamatical;

/**
 * @author Raj
 * 
 * Given a non-negative integer N, find the largest number that is less than or equal to N with monotone increasing digits.

(Recall that an integer has monotone increasing digits if and only if each pair of adjacent digits x and y satisfy x <= y.)

Example 1:
Input: N = 10
Output: 9
Example 2:
Input: N = 1234
Output: 1234
Example 3:
Input: N = 332
Output: 299
Note: N is an integer in the range [0, 10^9]
 */
public class MonotoneIncreasingDigits {

	public int monotoneIncreasingDigits(int N) {
		char[] S = String.valueOf(N).toCharArray();
		int i = 1;
		while (i < S.length && S[i] >= S[i - 1] ) {
			i++;
		}
		while (0 < i && i < S.length && S[i - 1] > S[i]) {
			S[i-- - 1]--;
		}
		for (int j = i + 1; j < S.length; ++j) {
			S[j] = '9';
		}

		return Integer.parseInt(String.valueOf(S));
	}

	public static void main(String[] args) {
		MonotoneIncreasingDigits obj = new MonotoneIncreasingDigits();
		int res = -1;

		res = obj.monotoneIncreasingDigits(4554);
		System.out.println(res);

		res = obj.monotoneIncreasingDigits(200);
		System.out.println(res);

		res = obj.monotoneIncreasingDigits(1234);
		System.out.println(res);

		res = obj.monotoneIncreasingDigits(332);
		System.out.println(res);

	}

}
