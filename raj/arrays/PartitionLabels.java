package com.raj.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * A string S of lowercase letters is given. We want to partition this string into as many parts as possible so that each letter appears in at most one part, and return a list of integers representing the size of these parts.

Example 1:
Input: S = "ababcbacadefegdehijhklij"
Output: [9,7,8]
Explanation:
The partition is "ababcbaca", "defegde", "hijhklij".
This is a partition so that each letter appears in at most one part.
A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less parts.
Note:

S will have length in range [1, 500].
S will consist of lowercase letters ('a' to 'z') only.
 *
 */
public class PartitionLabels {
	public List<Integer> partitionLabels(String s) {
		if (s == null || s.length() == 0) {
			return null;
		}
		List<Integer> list = new ArrayList<>();
		int[] map = new int[26]; // record the last index of the each char

		for (int i = 0; i < s.length(); i++) {
			map[s.charAt(i) - 'a'] = i;
		}
		System.out.println(Arrays.toString(map));
		// record the end index of the current sub string
		int last = 0;
		int start = 0;
		for (int i = 0; i < s.length(); i++) {
			last = Math.max(last, map[s.charAt(i) - 'a']);
			if (last == i) {
				list.add(last - start + 1);
				start = last + 1;
			}
		}
		return list;
	}

	public static void main(String... args) {
		PartitionLabels obj = new PartitionLabels();
		List<Integer> res = null;
		String s = "ababcbacadefegdehijhklij";
		res = obj.partitionLabels(s);
		System.out.println(res);
	}
}