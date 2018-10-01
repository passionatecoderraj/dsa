/**
 * 
 */
package com.raj.leetcode.google;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author Raj
 *
 Given a non-empty string s and an integer k, rearrange the string such that the same characters are at least distance k from each other.

All input strings are given in lowercase letters. If it is not possible to rearrange the string, return an empty string "".

Example 1:

Input: s = "aabbcc", k = 3
Output: "abcabc" 
Explanation: The same letters are at least distance 3 from each other.
Example 2:

Input: s = "aaabc", k = 3
Output: "" 
Explanation: It is not possible to rearrange the string.
Example 3:

Input: s = "aaadbbcc", k = 2
Output: "abacabcd"
Explanation: The same letters are at least distance 2 from each other.
 */
public class RearrangeStringKDistanceApart {

	//https://leetcode.com/problems/rearrange-string-k-distance-apart/discuss/83192/Java-7-version-of-PriorityQueue-O(nlogn)-with-comments-and-explanations
	// Time : O(n), Space : O(1)
	public String rearrangeString(String s, int k) {
		Map<Character, Integer> map = new HashMap<>();
		for (char ch : s.toCharArray())
			map.put(ch, map.getOrDefault(ch, 0) + 1);
		StringBuilder res = new StringBuilder();
		PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(
				(e1, e2) -> e2.getValue() - e1.getValue());
		Queue<Map.Entry<Character, Integer>> queue = new LinkedList<>();
		pq.addAll(map.entrySet());
		while (!pq.isEmpty()) {
			Map.Entry<Character, Integer> cur = pq.poll();
			res.append(cur.getKey());
			cur.setValue(cur.getValue() - 1);
			queue.offer(cur);
			if (queue.size() >= k) {
				Map.Entry<Character, Integer> front = queue.poll();
				if (front.getValue() > 0) {
					pq.offer(front);
				}
			}
		}
		return res.length() == s.length() ? res.toString() : "";
	}

	public static void main(String[] args) {
		RearrangeStringKDistanceApart obj = new RearrangeStringKDistanceApart();
		String res = "";
		res = obj.rearrangeString("aabbcc", 3);
		System.out.println(res);
		res = obj.rearrangeString("aaabc", 3);
		System.out.println(res);
		res = obj.rearrangeString("aaadbbcc", 2);
		System.out.println(res);

	}

}
