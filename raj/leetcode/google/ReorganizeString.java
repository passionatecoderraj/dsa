package com.raj.leetcode.google;

import java.util.PriorityQueue;

/**
 * 
 * @author Raj
 * 
 *Given a string S, check if the letters can be rearranged so that two characters that are adjacent to each other are not the same.

If possible, output any possible result.  If not possible, return the empty string.

Example 1:

Input: S = "aab"
Output: "aba"
Example 2:

Input: S = "aaab"
Output: ""
Note:

S will consist of lowercase letters and have length in range [1, 500].

 * 
 */
public class ReorganizeString {

	// https://leetcode.com/problems/reorganize-string/solution/
	// Time :O(n * log(A)),Space : O(A), A=no.of different chars 
	public String reorganizeString(String S) {
		int t[] = new int[26];
		for (char ch : S.toCharArray()) {
			t[ch - 'a']++;
		}
		class Node {
			char ch;
			int count;

			public Node(char ch, int count) {
				this.ch = ch;
				this.count = count;
			}

			@Override
			public String toString() {
				return "Node [ch=" + ch + ", count=" + count + "]";
			}

		}

		PriorityQueue<Node> pq = new PriorityQueue<>(
				(n1, n2) -> n1.count == n2.count ? n1.ch - n2.ch : n2.count - n1.count);
		for (int i = 0; i < t.length; i++) {
			// if any char is repeated more than half times the given task is impoosible
			if (t[i] > (S.length() + 1) / 2)
				return "";
			if (t[i] > 0)
				pq.offer(new Node((char) ('a' + i), t[i]));
		}

		StringBuilder sb = new StringBuilder();
		while (pq.size() >= 2) {
			
	         /*This code turns out to be superfluous, but explains what is happening
            if (sb.length() == 0 || n1.letter != sb.charAt(sb.length() - 1)) {
                sb.append(n1.letter);
                sb.append(n2.letter);
            } else {
                sb.append(n2.letter);
                sb.append(n1.letter);
            }*/
			Node n1 = pq.poll();
			Node n2 = pq.poll();
			sb.append(n1.ch);
			sb.append(n2.ch);
			n1.count--;
			n2.count--;
			if (n1.count > 0)
				pq.offer(n1);
			if (n2.count > 0)
				pq.offer(n2);

		}
		if (pq.size() > 0)
			sb.append(pq.poll().ch);
		return sb.toString();
	}

	public static void main(String[] args) {
		ReorganizeString obj = new ReorganizeString();
		String result = null;

		String s = "aab";
		result = obj.reorganizeString(s);
		System.out.println(result);

		String s2 = "aaab";
		result = obj.reorganizeString(s2);
		System.out.println(result);

	}

}
