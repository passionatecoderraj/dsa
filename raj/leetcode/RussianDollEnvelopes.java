/**
 * 
 */
package com.raj.leetcode;

import java.util.Arrays;

/**
 * @author Raj
 *
 *You have a number of envelopes with widths and heights given as a pair of integers (w, h). One envelope can fit into another if and only if both the width and height of one envelope is greater than the width and height of the other envelope.

What is the maximum number of envelopes can you Russian doll? (put one inside other)

Note:
Rotation is not allowed.

Example:

Input: [[5,4],[6,4],[6,7],[2,3]]
Output: 3 
Explanation: The maximum number of envelopes you can Russian doll is 3 ([2,3] => [5,4] => [6,7]).

 */
public class RussianDollEnvelopes {

	// https://leetcode.com/problems/russian-doll-envelopes/discuss/82763/Java-NLogN-Solution-with-Explanation
	// Time : O(nlogn), Space : O(n)
	public int maxEnvelopes(int[][] envelopes) {
		/*
		 * [3, 4] cannot contains [3, 3], so we need to put [3, 4] before [3, 3] when sorting otherwise it will be counted as an increasing number if the order is [3, 3], [3, 4]
		 */
		Arrays.sort(envelopes, (e1, e2) -> e1[0] == e2[0] ? e2[1] - e1[1] : e1[0] - e2[0]);

		int max = 0;
		int t[] = new int[envelopes.length];
		for (int v[] : envelopes) {
			int i = 0, j = max;
			int key = v[1];
			while (i < j) {
				int mid = i + (j - i) / 2;
				if (t[mid] < key) {
					i = mid + 1;
				} else {
					j = mid;
				}
			}
			t[i] = key;
			if (i == max) {
				max++;
			}
		}
		return max;
	}

	public static void main(String[] args) {
		RussianDollEnvelopes obj = new RussianDollEnvelopes();
		int result = -1;
		int envelopes[][] = { { 5, 4 }, { 6, 4 }, { 6, 7 }, { 2, 3 } };

		result = obj.maxEnvelopes(envelopes);
		System.out.println(result);

	}
}
