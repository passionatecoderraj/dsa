package com.raj.leetcode.google;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 
 * @author Raj 
 * To some string S, we will perform some replacement operations that replace groups of letters with new ones (not necessarily the same size).

Each replacement operation has 3 parameters: a starting index i, a source word x and a target word y.  The rule is that if x starts at position i in the original string S, then we will replace that occurrence of x with y.  If not, we do nothing.

For example, if we have S = "abcd" and we have some replacement operation i = 2, x = "cd", y = "ffff", then because "cd" starts at position 2 in the original string S, we will replace it with "ffff".

Using another example on S = "abcd", if we have both the replacement operation i = 0, x = "ab", y = "eee", as well as another replacement operation i = 2, x = "ec", y = "ffff", this second operation does nothing because in the original string S[2] = 'c', which doesn't match x[0] = 'e'.

All these operations occur simultaneously.  It's guaranteed that there won't be any overlap in replacement: for example, S = "abc", indexes = [0, 1], sources = ["ab","bc"] is not a valid test case.

Example 1:

Input: S = "abcd", indexes = [0,2], sources = ["a","cd"], targets = ["eee","ffff"]
Output: "eeebffff"
Explanation: "a" starts at index 0 in S, so it's replaced by "eee".
"cd" starts at index 2 in S, so it's replaced by "ffff".
Example 2:

Input: S = "abcd", indexes = [0,2], sources = ["ab","ec"], targets = ["eee","ffff"]
Output: "eeecd"
Explanation: "ab" starts at index 0 in S, so it's replaced by "eee". 
"ec" doesn't starts at index 2 in the original S, so we do nothing.
Notes:

0 <= indexes.length = sources.length = targets.length <= 100
0 < indexes[i] < S.length <= 1000
All characters in given inputs are lowercase letters.
 */

public class FindAndReplaceInString {

	//https://leetcode.com/problems/find-and-replace-in-string/discuss/130587/C++JavaPython-Replace-S-from-right-to-left
	// Time : O(n), Space: O(n)
	public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
		List<int[]> sortedIndices = new ArrayList<>();
		for (int i = 0; i < indexes.length; i++) {
			sortedIndices.add(new int[] { indexes[i], i });
		}

		// sort result in decreasing order of index values
		Collections.sort(sortedIndices, (i1, i2) -> i2[0] - i1[0]);

		for (int[] ind : sortedIndices) {
			int i = ind[0], j = ind[1];
			String src = sources[j], target = targets[j];
			if (S.substring(i, i + src.length()).equals(src)) {
				S = S.substring(0, i) + target + S.substring(i + src.length());
			}
		}

		return S;
	}

	public static void main(String... args) {
		FindAndReplaceInString obj = new FindAndReplaceInString();
		String res = "";

		String S3 = "jjievdtjfb";
		int[] indexes3 = { 4, 6, 1 };
		String[] sources3 = { "md", "tjgb", "jf" };
		String targets3[] = { "foe", "oov", "e" };
		res = obj.findReplaceString(S3, indexes3, sources3, targets3);
		System.out.println(res);

		String S = "abcd";
		int[] indexes = { 0, 2 };
		String[] sources = { "a", "cd" };
		String targets[] = { "eee", "ffff" };
		res = obj.findReplaceString(S, indexes, sources, targets);
		System.out.println(res);

		String S2 = "abcd";
		int[] indexes2 = { 0, 2 };
		String[] sources2 = { "ab", "ec" };
		String targets2[] = { "eee", "ffff" };
		res = obj.findReplaceString(S2, indexes2, sources2, targets2);
		System.out.println(res);

	}
}
