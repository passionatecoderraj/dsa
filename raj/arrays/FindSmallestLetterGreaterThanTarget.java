/**
 * 
 */
package com.raj.arrays;

/**
 * @author Raj
 *
 *Given a list of sorted characters letters containing only lowercase letters, and given a target letter target, find the smallest element in the list that is larger than the given target.

Letters also wrap around. For example, if the target is target = 'z' and letters = ['a', 'b'], the answer is 'a'.

Examples:
Input:
letters = ["c", "f", "j"]
target = "a"
Output: "c"

Input:
letters = ["c", "f", "j"]
target = "c"
Output: "f"

Input:
letters = ["c", "f", "j"]
target = "d"
Output: "f"

Input:
letters = ["c", "f", "j"]
target = "g"
Output: "j"

Input:
letters = ["c", "f", "j"]
target = "j"
Output: "c"

Input:
letters = ["c", "f", "j"]
target = "k"
Output: "c"
Note:
letters has a length in range [2, 10000].
letters consists of lowercase letters, and contains at least 2 unique letters.
target is a lowercase letter.
 */
public class FindSmallestLetterGreaterThanTarget {

	// Time : O(logn), Space : O(1)
	public char nextGreatestLetter(char[] a, char target) {

		int l = 0, r = a.length - 1;
		while (l <= r) {
			int m = (l + r) >> 1;
			if (a[m] > target && (m == 0 || target >= a[m - 1])) {
				return a[m];
			}
			if (a[m] > target) {
				r = m;
			} else {
				l = m + 1;
			}
		}
		return a[0];
	}

	// Time : O(n), Space : O(1)
	public char nextGreatestLetter2(char[] a, char target) {
		for (char ch : a) {
			if (ch > target)
				return ch;
		}
		return a[0];
	}

	public static void main(String[] args) {
		FindSmallestLetterGreaterThanTarget obj = new FindSmallestLetterGreaterThanTarget();
		char res = ' ';

		res = obj.nextGreatestLetter(new char[] { 'c', 'f', 'j' }, 'a');
		System.out.println(res);

		res = obj.nextGreatestLetter(new char[] { 'c', 'f', 'j' }, 'c');
		System.out.println(res);

		res = obj.nextGreatestLetter(new char[] { 'c', 'f', 'j' }, 'd');
		System.out.println(res);

		res = obj.nextGreatestLetter(new char[] { 'c', 'f', 'j' }, 'g');
		System.out.println(res);

		res = obj.nextGreatestLetter(new char[] { 'c', 'f', 'j' }, 'j');
		System.out.println(res);

		res = obj.nextGreatestLetter(new char[] { 'c', 'f', 'j' }, 'k');
		System.out.println(res);

	}

}
