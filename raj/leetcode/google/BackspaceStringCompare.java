package com.raj.leetcode.google;

/**
 * 
 * @author Raj
 *
 *Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace character.

Example 1:

Input: S = "ab#c", T = "ad#c"
Output: true
Explanation: Both S and T become "ac".
Example 2:

Input: S = "ab##", T = "c#d#"
Output: true
Explanation: Both S and T become "".
Example 3:

Input: S = "a##c", T = "#a#c"
Output: true
Explanation: Both S and T become "c".
Example 4:

Input: S = "a#c", T = "b"
Output: false
Explanation: S becomes "c" while T becomes "b".
Note:

1 <= S.length <= 200
1 <= T.length <= 200
S and T only contain lowercase letters and '#' characters.
Follow up:

Can you solve it in O(N) time and O(1) space?
 */
public class BackspaceStringCompare {

	// Time :O(n), Space: O(1)
	public boolean backspaceCompare(String S, String T) {
		int i = S.length() - 1, j = T.length() - 1;
		int skipS = 0, skipT = 0;
		
		/*
		 * although we don't do any processing after one of the strings empty,
		 * we should allow to process this atleast once
		 * for example, s="", t = a#b#
		 */
		while (i >= 0 || j >= 0) { // While there may be chars in build(S) or build (T)
			while (i >= 0) { // Find position of next possible char in build(S)
				if (S.charAt(i) == '#') {
					skipS++;
					i--;
				} else if (skipS > 0) {
					skipS--;
					i--;
				} else
					break;
			}
			while (j >= 0) { // Find position of next possible char in build(T)
				if (T.charAt(j) == '#') {
					skipT++;
					j--;
				} else if (skipT > 0) {
					skipT--;
					j--;
				} else
					break;
			}
			// as soon as one string is ended check whether both ended
			if (i < 0 || j < 0)
				return i == j;
			// If two actual characters are different
			if (S.charAt(i--) != T.charAt(j--))
				return false;

		}
		return true;
	}

	public static void main(String[] args) {
		BackspaceStringCompare obj = new BackspaceStringCompare();
		boolean result = false;
		String S = "", T = "";

		S = "ab#c";
		T = "ad#c";
		result = obj.backspaceCompare(S, T);
		System.out.println(result);

		S = "ab##";
		T = "c#d#";
		result = obj.backspaceCompare(S, T);
		System.out.println(result);

		S = "a##c";
		T = "#a#c";
		result = obj.backspaceCompare(S, T);
		System.out.println(result);

		S = "a#c";
		T = "b";
		result = obj.backspaceCompare(S, T);
		System.out.println(result);

		S = "bxj##tw";
		T = "bxo#j##tw";
		result = obj.backspaceCompare(S, T);
		System.out.println(result);

		S = "bx##tw";
		T = "bx###tw";
		result = obj.backspaceCompare(S, T);
		System.out.println(result);
	}

}
