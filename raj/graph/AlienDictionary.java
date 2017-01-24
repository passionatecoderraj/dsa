package com.raj.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * 
 * @author Raj
 *
 *         There is a new alien language which uses the latin alphabet. However,
 *         the order among letters are unknown to you. You receive a list of
 *         words from the dictionary, where words are sorted lexicographically
 *         by the rules of this new language. Derive the order of letters in
 *         this language.
 * 
 *         For example, Given the following words in dictionary,
 * 
 *         [ "wrt", "wrf", "er", "ett", "rftt" ] The correct order is: "wertf".
 * 
 *         Note: You may assume all letters are in lowercase. If the order is
 *         invalid, return an empty string. There may be multiple valid order of
 *         letters, return any one of them is fine.
 */
public class AlienDictionary {

	/*
	 * look here awesome explanation
	 * https://discuss.leetcode.com/topic/28308/java-ac-solution-using-bfs/9
	 * 
	 *
	 */
	public static String alienOrder(String[] words) {

		// build a degree map for each character in all the words:
		Map<Character, Integer> degree = new HashMap<>();
		for (String word : words) {
			for (char ch : word.toCharArray()) {
				degree.put(ch, 0);
			}
		}
		// build the hashmap by comparing the adjacent words, the first
		// character that is different between two adjacent words reflect the
		// lexicographical order.
		Map<Character, Set<Character>> map = new HashMap<>();
		for (int i = 0; i < words.length - 1; i++) {
			String cur = words[i];
			String next = words[i + 1];
			for (int j = 0; j < Math.min(cur.length(), next.length()); j++) {
				char c1 = cur.charAt(j), c2 = next.charAt(j);

				// if c1 and c2 are not equal, it means c1 come before c2
				// wrt, wrf -> t comes before f
				// ertt, erf -> t comes before f but it's already there in
				// map,it means degree of f because t would have been set
				// already we shouldn't increase again
				if (c1 != c2 && (!map.containsKey(c1) || !map.get(c1).contains(c2))) {
					map.compute(c1, (key, value) -> {
						if (null == value) {
							value = new HashSet<>();
						}
						value.add(c2);
						return value;
					});
					// increment degree of c2 because now c1 must come before c2
					degree.put(c2, degree.get(c2) + 1);
				}
			}
		}

		Queue<Character> queue = new LinkedList<>();
		for (char ch : degree.keySet()) {
			if (degree.get(ch) == 0) {
				queue.offer(ch);
			}
		}
		StringBuilder result = new StringBuilder();

		while (!queue.isEmpty()) {
			char cur = queue.poll();
			result.append(cur);
			if (map.containsKey(cur)) {
				for (char c2 : map.get(cur)) {
					degree.put(c2, degree.get(c2) - 1);
					if (degree.get(c2) == 0) {
						queue.offer(c2);
					}
				}
			}
		}
		return result.toString();
	}

	public static void main(String[] args) {
		String words[] = { "wrt", "wrf", "er", "ett", "rftt" };
		String result = null;

		result = alienOrder(words);
		System.out.println(result);

	}

}
