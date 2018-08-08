/**
 * 
 */
package com.raj.dp;

import java.util.Arrays;

/**
 * @author Raj
 *
 *A message containing letters from A-Z is being encoded to numbers using the following mapping way:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Beyond that, now the encoded string can also contain the character '*', which can be treated as one of the numbers from 1 to 9.

Given the encoded message containing digits and the character '*', return the total number of ways to decode it.

Also, since the answer may be very large, you should return the output mod 109 + 7.

Example 1:
Input: "*"
Output: 9
Explanation: The encoded message can be decoded to the string: "A", "B", "C", "D", "E", "F", "G", "H", "I".
Example 2:
Input: "1*"
Output: 9 + 9 = 18
Note:
The length of the input string will fit in range [1, 105].
The input string will only contain the character '*' and digits '0' - '9'.
 * 
 */
public class DecodeWays2 {

	// https://leetcode.com/articles/decode-ways-ii/
	// Time : O(n), Space : O(1)
	public int numDecodings(String s) {
		if (s.isEmpty())
			return 0;

		long a, b, c;
		a = 1;
		b = (s.charAt(0) == '*') ? 9 : (s.charAt(0) != '0') ? 1 : 0;

		int M = 1000000007;
		for (int i = 1; i < s.length(); i++) {
			char cur = s.charAt(i);
			if (cur == '*') {
				c = (9 * b) % M;

				char prev = s.charAt(i - 1);
				if (prev == '1') {
					c = (c + a * 9) % M;
				} else if (prev == '2') {
					c = (c + a * 6) % M;
				} else if (prev == '*') {
					c = (c + a * 15) % M;
				}

			} else {
				c = (cur >= '1' && cur <= '9') ? b : 0;
				char prev = s.charAt(i - 1);
				if (prev == '1' || prev == '2') {
					int num = (prev - '0') * 10 + (cur - '0');
					if (num >= 10 && num <= 26)
						c = (c + a) % M;
				} else if (prev == '*') {
					c = (c + ((cur <= '6' ? 2 : 1) * a)) % M;
				}
			}
			a = b;
			b = c;
		}
		return (int) b;
	}

	// Time : O(n), Space : O(n)
	public int numDecodings2(String s) {
		if (s.isEmpty())
			return 0;

		long t[] = new long[s.length() + 1];
		t[0] = 1;
		t[1] = (s.charAt(0) == '*') ? 9 : (s.charAt(0) != '0') ? 1 : 0;
		int M = 1000000007;
		for (int i = 2; i <= s.length(); i++) {
			char cur = s.charAt(i - 1);
			if (cur == '*') {
				t[i] = (9 * t[i - 1]) % M;
				char prev = s.charAt(i - 2);
				if (prev == '1') {
					t[i] = (t[i] + t[i - 2] * 9) % M;
				} else if (prev == '2') {
					t[i] = (t[i] + t[i - 2] * 6) % M;
				} else if (prev == '*') {
					t[i] = (t[i] + t[i - 2] * 15) % M;
				}

			} else {
				t[i] = (cur >= '1' && cur <= '9') ? t[i - 1] : 0;
				char prev = s.charAt(i - 2);
				if (prev == '1' || prev == '2') {
					int num = (prev - '0') * 10 + (cur - '0');
					if (num >= 10 && num <= 26)
						t[i] = (t[i] + t[i - 2]) % M;
				} else if (prev == '*') {
					t[i] = (t[i] + ((cur <= '6' ? 2 : 1) * t[i - 2])) % M;
				}
			}
		}
		System.out.println(Arrays.toString(t));
		return (int) t[s.length()];
	}

	public static void main(String[] args) {
		int result = -1;
		DecodeWays2 obj = new DecodeWays2();

		String input = "12**610";
		result = obj.numDecodings(input);
		System.out.println(result);
	}

}
