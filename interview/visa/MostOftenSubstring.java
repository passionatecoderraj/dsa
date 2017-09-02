package com.interview.visa;

import java.util.HashMap;
import java.util.Map;

public class MostOftenSubstring {

	/*
	 * Given an input string of size n, return the number of occurrences of the
	 * most common substring between lengths k,l.
	 */
	static int findOccurrencesOfMostCommonSubstring(String input, int n, int k, int l) {
		Map<String, Integer> map = new HashMap<>();
		int maxOccurrences = 1;

		int inputLen = input.length();

		for (int i = 0; i < inputLen - 1; ++i) {

			for (int j = k; j <= l && i + j <= inputLen; ++j) {
				String current = input.substring(i, j);
				Integer currentValue = map.get(current);
				if (currentValue != null)
					maxOccurrences = (++currentValue > maxOccurrences) ? currentValue : maxOccurrences;
			}
		}

		return maxOccurrences;
	}

	static int findOccurrencesOfMostCommonSubstring2(String input, int n, int k, int l) {
		Map<String, Integer> map = new HashMap<>();
		int max = Integer.MIN_VALUE;
		for (int l2 = k; l2 <= l; l2++) {
			for (int i = 0; i < n - l2 + 1; i++) {
				int j = i + l2 - 1;
				String st = input.substring(i, j+1 );
				if (map.containsKey(st)) {
					map.put(st, map.get(st) + 1);
				} else {
					map.put(st, 1);
				}
				if (map.get(st) > max) {
					System.out.println(st);
					max = map.get(st);
				}
			}
		}

		return max;
	}

	public static void main(String args[]) {
		int result = 0;
		result = findOccurrencesOfMostCommonSubstring2("abcde", 5, 2, 4);
		System.out.println(result);
		result = findOccurrencesOfMostCommonSubstring2("ababab", 6, 2, 3);
		System.out.println(result);
	}
}
