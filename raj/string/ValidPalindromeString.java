/**
 * 
 */
package com.raj.string;

import java.util.Stack;

/**
 * @author Raj
 *
 */

/*
 * Valid Palindrome String (Java)
 * 
 * For example, "Red rum, sir, is murder" is a palindrome, while
 * "Programcreek is awesome" is not.
 */

// http://www.programcreek.com/2013/01/leetcode-valid-palindrome-java/
public class ValidPalindromeString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ValidPalindromeString obj = new ValidPalindromeString();

		String str = "Red rum 10, sir, is 01 murder";
		boolean result = false;

		// Time : O(n) Space :O(1)
		result = obj.isValidPalindrome(str.toCharArray(), str.length());
		System.out.println(result);

		str = "Hello, Prithviraj Kumar Dasari";
		result = obj.isValidPalindrome(str.toCharArray(), str.length());
		System.out.println(result);

	}

	public boolean isValidPalindrome(char[] a, int n) {
		int l = 0, r = n - 1;
		while (l < r) {
			while (l < r && !isValidAlphabet(a[l])) {
				l++;
			}

			while (l < r && !isValidAlphabet(a[r])) {
				r--;
			}
			if (Character.toLowerCase(a[l++]) != Character.toLowerCase(a[r--]))
				return false;
		}
		return true;
	}

	public boolean isValidAlphabet(char ch) {
		return Character.isAlphabetic(ch);
	}

	public boolean isValidAlphabet2(char ch) {
		if (ch >= 'A' && ch <= 'Z')
			return true;
		if (ch >= 'a' && ch <= 'z')
			return true;
		if (ch - '0' >= 0 && ch - '0' <= 9)
			return true;
		return false;
	}
}
