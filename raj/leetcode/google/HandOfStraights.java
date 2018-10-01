/**
 * 
 */
package com.raj.leetcode.google;

import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * @author Raj
 *
 *
 *         Alice has a hand of cards, given as an array of integers.
 * 
 *         Now she wants to rearrange the cards into groups so that each group
 *         is size W, and consists of W consecutive cards.
 * 
 *         Return true if and only if she can.
 * 
 * 
 * 
 *         Example 1:
 * 
 *         Input: hand = [1,2,3,6,2,3,4,7,8], W = 3 Output: true Explanation:
 *         Alice's hand can be rearranged as [1,2,3],[2,3,4],[6,7,8]. Example 2:
 * 
 *         Input: hand = [1,2,3,4,5], W = 4 Output: false Explanation: Alice's
 *         hand can't be rearranged into groups of 4.
 * 
 * 
 *         Note:
 * 
 *         1 <= hand.length <= 10000 0 <= hand[i] <= 10^9 1 <= W <= hand.length
 */

public class HandOfStraights {

	/*
	 * same idea as priroity queue but using treemap is efficient time complexity
	 */
	// Time : O(nlogn + nW) 
	public boolean isNStraightHand2(int[] a, int W) {
		TreeMap<Integer, Integer> map = new TreeMap<>();
		for (int n : a) {
			map.compute(n, (k, v) -> {
				if (null == v)
					v = 0;
				return v + 1;
			});
		}
		for (int n : map.keySet()) {
			System.out.println(map);
			if (map.get(n) > 0)
				for (int i = 0; i < W; i++) {
					if (!map.containsKey(n + i) || map.get(n + i) <= 0)
						return false;
					map.put(n + i, map.get(n + i) - 1);
				}
		}

		return true;
	}

	// https://leetcode.com/problems/hand-of-straights/discuss/136200/Simple-Java-solution-using-priority-queue
	// O(n+ (n*logn*w))
	public boolean isNStraightHand(int[] hand, int W) {
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		for (int i : hand) {
			minHeap.add(i);
		}
		while (!minHeap.isEmpty()) {
			int start = minHeap.poll();
			for (int j = 1; j < W; j++) {
				if (!minHeap.remove(start + j)) {
					return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		HandOfStraights obj = new HandOfStraights();

		boolean result = false;
		result = obj.isNStraightHand(new int[] { 1, 2, 3, 6, 2, 3, 4, 7, 8 }, 3);
		System.out.println(result);

		result = obj.isNStraightHand(new int[] { 1, 2, 3, 4, 5 }, 4);
		System.out.println(result);

	}

}
