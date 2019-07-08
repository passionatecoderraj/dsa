/**
 * 
 */
package com.raj.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

/**
 * @author Raj
 * 
 *         Given a non-empty array of integers, return the k most frequent
 *         elements.
 * 
 *         For example, Given [1,1,1,2,2,3] and k = 2, return [1,2].
 * 
 *         Note: You may assume k is always valid, 1 ≤ k ≤ number of unique
 *         elements. Your algorithm's time complexity must be better than O(n
 *         log n), where n is the array's size
 */

public class TopKFrequentElements {

	// Time : O(n), Space : O(n)
	public List<Integer> topKFrequent2(int[] a, int k) {
		List<Integer> res = new ArrayList<>();
		Map<Integer, Integer> map = new HashMap<>();
		for (int n : a) {
			map.compute(n, (kev, val) -> {
				if (val == null)
					val = 0;
				return val + 1;
			});
		}

		ArrayList<Integer>[] t = new ArrayList[a.length + 1];

		for (Map.Entry<Integer, Integer> e : map.entrySet()) {
			if (t[e.getValue()] == null) {
				t[e.getValue()] = new ArrayList<>();
			}
			t[e.getValue()].add(e.getKey());
		}
		int count = 0;
		for (int i = a.length; i >= 0; i--) {
			if (t[i] != null) {
				for (int j = 0; j < t[i].size() && count < k; j++) {
					res.add(t[i].get(j));
					count++;
				}
			}
		}

		return res;
	}

	// Time : O(klogn), Space :O(n)
	public List<Integer> topKFrequent(int[] a, int k) {
		List<Integer> res = new ArrayList<>();
		Map<Integer, Integer> map = new HashMap<>();
		for (int n : a) {
			map.compute(n, (kev, val) -> {
				if (val == null)
					val = 0;
				return val + 1;
			});
		}

		PriorityQueue<Entry<Integer, Integer>> pq = new PriorityQueue<>((e1, e2) -> e1.getValue() - e2.getValue());

		for (Entry<Integer, Integer> e : map.entrySet()) {
			pq.offer(e);
			if (pq.size() > k)
				pq.poll();
		}
		while (!pq.isEmpty()) {
			res.add(pq.poll().getKey());
		}

		return res;
	}

	public static void main(String[] args) {
		TopKFrequentElements obj = new TopKFrequentElements();

		int a[] = { 1, 1, 1, 2, 2, 3 };

		List<Integer> res = null;
		res = obj.topKFrequent(a, 3);
		System.out.println(res);

	}

}
