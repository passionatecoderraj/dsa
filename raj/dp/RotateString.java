/**
 * 
 */
package com.raj.dp;

/**
 * @author Raj
We are given two strings, A and B.

A shift on A consists of taking string A and moving the leftmost character to the rightmost position. For example, if A = 'abcde', then it will be 'bcdea' after one shift on A. Return True if and only if A can become B after some number of shifts on A.

Example 1:
Input: A = 'abcde', B = 'cdeab'
Output: true

Example 2:
Input: A = 'abcde', B = 'abced'
Output: false
Note:

A and B will have length at most 100.
 */
public class RotateString {

	public boolean rotateString(String A, String B) {
		return A.length() == B.length() && (A + A).contains(B);
	}

	public static void main(String[] args) {
		RotateString obj = new RotateString();
		boolean res = false;
		res = obj.rotateString("abcde", "cdeab");	
		System.out.println(res);
		res = obj.rotateString("aa", "a");
		System.out.println(res);
	}

}
