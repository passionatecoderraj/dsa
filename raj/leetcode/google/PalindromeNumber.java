/**
 * 
 */
package com.raj.leetcode.google;

/**
 * @author Raj
 *
 *Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.

Example 1:

Input: 121
Output: true
Example 2:

Input: -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
Example 3:

Input: 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 */
public class PalindromeNumber {

	// https://leetcode.com/problems/palindrome-number/discuss/5127/9-line-accepted-Java-code-without-the-need-of-handling-overflow
	public boolean isPalindrome(int x) {
		if (x < 0 || (x != 0 && x % 10 == 0))
			return false;
		int rev = 0;
		while (x > rev) {
			rev = (rev * 10) + (x % 10);
			x /= 10;
		}
	
		return (rev == x || x == rev / 10);
	}

	public static void main(String[] args) {
		PalindromeNumber obj = new PalindromeNumber();
		boolean result = false;
		int n = 121;
		result = obj.isPalindrome(n);
		System.out.println(result);

	}
}
