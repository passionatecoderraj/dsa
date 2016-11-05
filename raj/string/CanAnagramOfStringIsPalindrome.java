/**
 * 
 */
package com.raj.string;

import java.util.HashMap;
import java.util.Map;

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
public class CanAnagramOfStringIsPalindrome {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CanAnagramOfStringIsPalindrome obj = new CanAnagramOfStringIsPalindrome();

		String str = "abcbba";
		boolean result;

		// Time : O(n) Space :O(1)
		result = obj.checkIfAnagramOfAStringIsPalindrome(str.toCharArray(), str.length());
		System.out.println(result);

		// Time : O(n) Space :O(1)
		result = obj.canAnagramOfStringIsPalindrome(str);
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

	/**
	 * 
	 * @param str
	 * @return
	 */
	// Time : O(n) Space :O(1)
	public boolean canAnagramOfStringIsPalindrome(String str) {

		Map<Character, Integer> countMap = new HashMap<>();

		for (Character ch : str.toCharArray()) {
			countMap.compute(ch, (key, value) -> {
				if (null == value)
					return 1;
				return value + 1;
			});
		}

		int oddCount = 0;

		for (Character key : countMap.keySet()) {
			if (countMap.get(key) % 2 != 0) {
				oddCount++;
				if (oddCount > 1)
					return false;
			}
		}

		return true;
	}
}
