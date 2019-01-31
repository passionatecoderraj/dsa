/**
 * 
 */
package com.raj.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author Raj
 *
 *         You have a number of envelopes with widths and heights given as a
 *         pair of integers (w, h). One envelope can fit into another if and
 *         only if both the width and height of one envelope is greater than the
 *         width and height of the other envelope.
 * 
 *         What is the maximum number of envelopes can you Russian doll? (put
 *         one inside other)
 * 
 *         Note: Rotation is not allowed.
 * 
 *         Example:
 * 
 *         Input: [[5,4],[6,4],[6,7],[2,3]] Output: 3 Explanation: The maximum
 *         number of envelopes you can Russian doll is 3 ([2,3] => [5,4] =>
 *         [6,7]).
 * 
 */
public class FindKPairswithSmallestSums {

	/*
	 * Some observations: For every numbers in nums1, its best partner(yields min sum) always strats from nums2[0] since arrays are all sorted; 
	 * And for a specific number in nums1, its next candidate should be [this specific number] + nums2[current_associated_index + 1], unless out of boundary;)
	 */
	// https://leetcode.com/problems/find-k-pairs-with-smallest-sums/discuss/84551/simple-Java-O(KlogK)-solution-with-explanation
	// Time : O(klogk), Space : O(k)
	public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
		List<int[]> res = new ArrayList<>();
		if (nums1.length == 0 || nums2.length == 0 || k == 0)
			return res;
		class Node {
			int first;
			int second;
			int secIndex;

			public Node(int first, int second, int secIndex) {
				this.first = first;
				this.second = second;
				this.secIndex = secIndex;
			}

			@Override
			public String toString() {
				return "Node [first=" + first + ", second=" + second + ", secIndex=" + secIndex + "]";
			}

		}
		PriorityQueue<Node> pq = new PriorityQueue<>(k, (n1, n2) -> n1.first + n1.second - (n2.first + n2.second));
		 // Even if there are 100 elements if we need 4 pairs, we just need to traverse through 4 elements of first/second array
		for (int i = 0; i < nums1.length && i < k; i++) {
			pq.offer(new Node(nums1[i], nums2[0], 0));
		}
		while (!pq.isEmpty() && k-- > 0) {
			Node cur = pq.poll();
			res.add(new int[] { cur.first, cur.second });
			if (++cur.secIndex < nums2.length) {
				pq.offer(new Node(cur.first, nums2[cur.secIndex], cur.secIndex));
			}
		}
		return res;
	}

	public static void main(String[] args) {
		FindKPairswithSmallestSums obj = new FindKPairswithSmallestSums();
		List<int[]> result = null;
		int[] nums1 = { 1, 7, 11 }, nums2 = { 2, 4, 6 };

		result = obj.kSmallestPairs(nums1, nums2, 3);
		for (int[] r : result)
			System.out.print(Arrays.toString(r) + ", ");
		System.out.println();

		int[] nums21 = { 1, 1, 2 }, nums22 = { 1, 2, 3 };

		result = obj.kSmallestPairs(nums21, nums22, 2);
		for (int[] r : result)
			System.out.print(Arrays.toString(r) + ", ");
		System.out.println();

		int[] nums31 = { 1, 2 }, nums32 = { 3 };

		result = obj.kSmallestPairs(nums31, nums32, 3);
		for (int[] r : result)
			System.out.print(Arrays.toString(r) + ", ");
		System.out.println();

	}
}
