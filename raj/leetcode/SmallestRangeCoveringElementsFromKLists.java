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
 *You have k lists of sorted integers in ascending order. Find the smallest range that includes at least one number from each of the k lists.

We define the range [a,b] is smaller than range [c,d] if b-a < d-c or a < c if b-a == d-c.

 

Example 1:

Input: [[4,10,15,24,26], [0,9,12,20], [5,18,22,30]]
Output: [20,24]
Explanation: 
List 1: [4, 10, 15, 24,26], 24 is in range [20,24].
List 2: [0, 9, 12, 20], 20 is in range [20,24].
List 3: [5, 18, 22, 30], 22 is in range [20,24].
 

Note:

The given list may contain duplicates, so ascending order means >= here.
1 <= k <= 3500
-105 <= value of elements <= 105.

 */
public class SmallestRangeCoveringElementsFromKLists {

	// Time : O(nlogk), Space : O(k)
	/*
	 * 1. if there are only one in element in each list, range become min and max
	 * 2. as we add more elements re-calculate max and min to discover min range
	 */
	public int[] smallestRange(List<List<Integer>> nums) {
		class Node {
			int idx;
			int row;
			int val;

			Node(int idx, int row, int val) {
				this.idx = idx;
				this.row = row;
				this.val = val;
			}

		}
		PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> n1.val - n2.val);
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < nums.size(); i++) {
			if (null != nums.get(i)) {
				pq.offer(new Node(0, i, nums.get(i).get(0)));
				max = Math.max(max, nums.get(i).get(0));
			}
		}
		int range = Integer.MAX_VALUE, start = -1, end = -1;
		// until pq size as much as "K"
		while (pq.size() == nums.size()) {
			Node n = pq.poll();
			if (max - n.val < range) {
				start = n.val;
				end = max;
				range = max - n.val;
			}
			if (++n.idx < nums.get(n.row).size()) {
				n.val = nums.get(n.row).get(n.idx);
				if (n.val > max)
					max = n.val;
				pq.offer(n);
			}
		}
		return new int[] { start, end };
	}

	public static void main(String[] args) {

		List<Integer> list1 = new ArrayList<>();
		list1.add(4);
		list1.add(10);
		list1.add(15);
		list1.add(24);
		list1.add(26);
		List<Integer> list2 = new ArrayList<>();
		list2.add(0);
		list2.add(9);
		list2.add(12);
		list2.add(20);
		List<Integer> list3 = new ArrayList<>();
		list3.add(5);
		list3.add(18);
		list3.add(22);
		list3.add(30);

		SmallestRangeCoveringElementsFromKLists obj = new SmallestRangeCoveringElementsFromKLists();
		int[] result = null;
		List<List<Integer>> list = new ArrayList<>();
		list.add(list1);
		list.add(list2);
		list.add(list3);

		result = obj.smallestRange(list);
		System.out.println(Arrays.toString(result));

	}
}
