package com.raj.leetcode.google;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 
 * @author Raj
 *Given two sentences words1, words2 (each represented as an array of strings), and a list of similar word pairs pairs, determine if two sentences are similar.

For example, "great acting skills" and "fine drama talent" are similar, if the similar word pairs are pairs = [["great", "fine"], ["acting","drama"], ["skills","talent"]].

Note that the similarity relation is not transitive. For example, if "great" and "fine" are similar, and "fine" and "good" are similar, "great" and "good" are not necessarily similar.

However, similarity is symmetric. For example, "great" and "fine" being similar is the same as "fine" and "great" being similar.

Also, a word is always similar with itself. For example, the sentences words1 = ["great"], words2 = ["great"], pairs = [] are similar, even though there are no specified similar word pairs.

Finally, sentences can only be similar if they have the same number of words. So a sentence like words1 = ["great"] can never be similar to words2 = ["doubleplus","good"].

Note:

The length of words1 and words2 will not exceed 1000.
The length of pairs will not exceed 2000.
The length of each pairs[i] will be 2.
The length of each words[i] and pairs[i][j] will be in the range [1, 20].
 */

public class SentenceSimilarity {

	
	public boolean areSentencesSimilar(String[] words1, String[] words2, String[][] pairs) {
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
			if (words1[i].equals(words2[i]))
				continue;
			if (!edges.containsKey(words1[i]) || !edges.get(words1[i]).contains(words2[i])) {
				return false;
			}
		}
		return true;
	}

	public static void main(String... args) {
		SentenceSimilarity obj = new SentenceSimilarity();
		boolean res = false;
		String words1[] = { "great", "acting", "skills" };
		String[] words2 = { "fine", "drama", "talent" };
		String[][] pairs = { { "great", "fine" }, { "acting", "drama" }, { "skills", "talent" } };
		res = obj.areSentencesSimilar(words1, words2, pairs);
		System.out.println(res);

		String words21[] = { "great" };
		String[] words22 = { "great" };
		String[][] pairs2 = {};
		res = obj.areSentencesSimilar(words21, words22, pairs2);
		System.out.println(res);

	}
}
