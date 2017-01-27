package com.raj.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author Raj
 *
 *         This is a follow up of Shortest Word Distance. The only difference is
 *         now you are given the list of words and your method will be called
 *         repeatedly many times with different parameters. How would you
 *         optimize it?
 * 
 *         Design a class which receives a list of words in the constructor, and
 *         implements a method that takes two words word1 and word2 and return
 *         the shortest distance between these two words in the list.
 * 
 *         For example, Assume that words = ["practice", "makes", "perfect",
 *         "coding", "makes"].
 * 
 *         Given word1 = “coding”, word2 = “practice”, return 3. Given word1 =
 *         "makes", word2 = "coding", return 1.
 */
public class ShortestWordDistance2 {

	Map<String, List<Integer>> map;

	// Time : O(n)
	public ShortestWordDistance2(String[] words) {
		map = new HashMap<>();
		// by default indices are sorted here because they are ordered
		for (int i = 0; i < words.length; i++) {
			int idx = i;
			map.compute(words[i], (key, value) -> {
				if (null == value) {
					value = new ArrayList<>();
				}
				value.add(idx);
				return value;
			});
		}
	}

	// Time : O(m+n)
	public int shortest(String word1, String word2) {

		if (!map.containsKey(word1) || !map.containsKey(word2))
			return Integer.MAX_VALUE;

		int min = Integer.MAX_VALUE;
		List<Integer> list1 = map.get(word1);
		List<Integer> list2 = map.get(word2);
		System.out.println(list1);
		System.out.println(list2);
		int i = 0, j = 0;
		// merge procedure
		while (i < list1.size() && j < list2.size()) {

			min = Math.min(Math.abs(list1.get(i) - list2.get(j)), min);
			if (list1.get(i) < list2.get(j)) {
				i++;
			} else {
				j++;
			}
		}

		return min;
	}

	public static void main(String args[]) {
		String words[] = { "practice", "makes", "perfect", "coding", "makes" };
		ShortestWordDistance2 obj = new ShortestWordDistance2(words);

		int res = -1;
		res = obj.shortest("practice", "coding");
		System.out.println(res);

		res = obj.shortest("makes", "coding");
		System.out.println(res);
	}
}