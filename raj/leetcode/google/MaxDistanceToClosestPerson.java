package com.raj.leetcode.google;

/**
 * 
 * @author Raj
 * 
 *         In a row of seats, 1 represents a person sitting in that seat, and 0
 *         represents that the seat is empty.
 * 
 *         There is at least one empty seat, and at least one person sitting.
 * 
 *         Alex wants to sit in the seat such that the distance between him and
 *         the closest person to him is maximized.
 * 
 *         Return that maximum distance to closest person.
 * 
 *         Example 1:
 * 
 *         Input: [1,0,0,0,1,0,1] Output: 2 Explanation: If Alex sits in the
 *         second open seat (seats[2]), then the closest person has distance 2.
 *         If Alex sits in any other open seat, the closest person has distance
 *         1. Thus, the maximum distance to the closest person is 2. Example 2:
 * 
 *         Input: [1,0,0,0] Output: 3 Explanation: If Alex sits in the last
 *         seat, the closest person is 3 seats away. This is the maximum
 *         distance possible, so the answer is 3. Note:
 * 
 *         1 <= seats.length <= 20000 seats contains only 0s or 1s, at least one
 *         0, and at least one 1.
 */
public class MaxDistanceToClosestPerson {

	// Time :O(n), Space: O(1)
	// https://leetcode.com/problems/maximize-distance-to-closest-person/discuss/155564/Clean-One-Pass-Two-Pointers-Java-Solution
	public int maxDistToClosest(int[] a) {
		/*
		 * init max to zero, which covers the other corner case when only person is in last seat {0,0,0,1}
		 */
		int max = 0, left = -1;
		for (int i = 0; i < a.length; i++) {
			if (a[i] == 0)
				continue;
			if (left == -1)
				max = i;
			else
				max = Math.max(max, (i - left) / 2);
			left = i;
		}

		if (a[a.length - 1] == 0) {
			max = Math.max(max, a.length - left - 1);
		}
		return max;
	}

	public static void main(String[] args) {
		MaxDistanceToClosestPerson obj = new MaxDistanceToClosestPerson();
		int[] a = { 1, 0, 0, 0, 1, 0, 1 };
		int result = -1;
		result = obj.maxDistToClosest(a);
		System.out.println(result);

	}

}
