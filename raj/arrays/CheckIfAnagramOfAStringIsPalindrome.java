/**
 * 
 */
package com.raj.arrays;

/**
 * @author Raj
 *
 */

/*
 * http://algorithmsandme.in/2014/08/strings-find-if-any-anagram-of-string-is-
 * palindrome/#.VAKNXTKSyAg
 * 
 * 
 * Given a string, find out if any anagram of given string is palindrome. For
 * example, “AABBC” has an anagram “ABCBA” which is palindrome.
 */
public class CheckIfAnagramOfAStringIsPalindrome {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CheckIfAnagramOfAStringIsPalindrome obj = new CheckIfAnagramOfAStringIsPalindrome();

		String str = "abcbba";
		boolean result;

		// Time : O(n) Space :O(1)
		result = obj.checkIfAnagramOfAStringIsPalindrome(str.toCharArray(), str.length());
		System.out.println(result);
	}

	/*
	 * each character should occur even number of time except one which is
	 * middle character which may occur odd number of times
	 */

	// Time : O(n), Space :O(1)
	public boolean checkIfAnagramOfAStringIsPalindrome(char[] a, int n) {
		int count[] = new int[256];
		for (int i = 0; i < n; i++) {
			count[a[i]]++;
		}

		int numberOfOdds = 0;
		for (int i = 0; i < count.length; i++) {
			if (count[i] % 2 != 0) {
				numberOfOdds++;
			}
		}
		return numberOfOdds <= 1;
	}

}
