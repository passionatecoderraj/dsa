/**
 * 
 */
package com.raj.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author Raj
 * 
 *         Given a non-empty list of words, return the k most frequent elements.
 * 
 *         Your answer should be sorted by frequency from highest to lowest. If
 *         two words have the same frequency, then the word with the lower
 *         alphabetical order comes first.
 * 
 * 
 * Example 1:
Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
Output: ["i", "love"]
Explanation: "i" and "love" are the two most frequent words.
    Note that "i" comes before "love" due to a lower alphabetical order.
Example 2:
Input: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
Output: ["the", "is", "sunny", "day"]
Explanation: "the", "is", "sunny" and "day" are the four most frequent words,
    with the number of occurrence being 4, 3, 2 and 1 respectively.
Note:
You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
Input words contain only lowercase letters.
Follow up:
Try to solve it in O(n log k) time and O(n) extra space.
 */

public class TopKFrequentWords {

	// https://discuss.leetcode.com/topic/107751/my-simple-java-solution-using-hashmap-priorityqueue-o-nlogk-time-o-n-space
	// Time : O(nlogk), Space : O(n)
	public List<String> topKFrequent(String[] words, int k) {
		Map<String, Integer> map = new HashMap<>();
		for (String word : words) {
			map.compute(word, (key, val) -> {
				if (null == val)
					val = 0;
				return val + 1;
			});
		}
		PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(k, (e1, e2) -> {
			if (e1.getValue() == e2.getValue()) {
				return e2.getKey().compareTo(e1.getKey());
			}
			return e1.getValue() - e2.getValue();
		});
		List<String> res = new ArrayList<>();
		for (Map.Entry<String, Integer> e : map.entrySet()) {
			pq.offer(e);
			if (pq.size() > k)
				pq.poll();
		}

		while (!pq.isEmpty()) {
			res.add(0, pq.poll().getKey());
		}
		return res;
	}

	public static void main(String[] args) {
		TopKFrequentWords obj = new TopKFrequentWords();

		String a[] = { "i", "love", "leetcode", "i", "love", "coding" };

		List<String> res = null;
		res = obj.topKFrequent(a, 2);
		System.out.println(res);

		String b[] = { "the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is" };
		res = obj.topKFrequent(b, 4);
		System.out.println(res);
	}

}
