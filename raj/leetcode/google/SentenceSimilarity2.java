package com.raj.leetcode.google;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 
 * @author Raj 
 * 
 * Finally, sentences can only be similar if they have the same number of words. So a sentence like words1 = ["great"] can never be similar to words2 = ["doubleplus","good"].

Note:

The length of words1 and words2 will not exceed 1000.
The length of pairs will not exceed 2000.
The length of each pairs[i] will be 2.
The length of each words[i] and pairs[i][j] will be in the range [1, 20].
 */

public class SentenceSimilarity2 {

	public boolean areSentencesSimilarTwo(String[] words1, String[] words2, String[][] pairs) {
		if (words1.length != words2.length)
			return false;
		Map<String, Set<String>> edges = new HashMap<>();
		for (String[] pair : pairs) {
			edges.compute(pair[0], (k, v) -> {
				if (null == v) {
					v = new HashSet<>();
				}
				v.add(pair[1]);
				return v;
			});
			edges.compute(pair[1], (k, v) -> {
				if (null == v) {
					v = new HashSet<>();
				}
				v.add(pair[0]);
				return v;
			});
		}
		for (int i = 0; i < words1.length; i++) {
			Set<String> visited = new HashSet<>();
			if (!dfs(words1[i], words2[i], visited, edges)) {
				return false;
			}
		}
		return true;
	}

	private boolean dfs(String word1, String word2, Set<String> visited, Map<String, Set<String>> edges) {
		if (word1.equals(word2))
			return true;
		visited.add(word1);
		if (edges.containsKey(word1)) {
			for (String adj : edges.get(word1)) {
				if (!visited.contains(adj)) {
					if (dfs(adj, word2, visited, edges)) {
						return true;
					}
				}
			}
		}
		return false;
	}

	public static void main(String... args) {
		SentenceSimilarity2 obj = new SentenceSimilarity2();
		boolean res = false;
		String words1[] = { "great", "acting", "skills" };
		String[] words2 = { "fine", "drama", "talent" };
		String[][] pairs = { { "great", "good" }, { "fine", "good" }, { "acting", "drama" }, { "skills", "talent" } };
		res = obj.areSentencesSimilarTwo(words1, words2, pairs);
		System.out.println(res);

		String words21[] = { "great" };
		String[] words22 = { "great" };
		String[][] pairs2 = {};
		res = obj.areSentencesSimilarTwo(words21, words22, pairs2);
		System.out.println(res);

	}
}
