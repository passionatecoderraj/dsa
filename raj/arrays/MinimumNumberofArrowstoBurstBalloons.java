/**
 * 
 */
package com.raj.arrays;

import java.util.Arrays;

/**
 * @author Raj
 *There are a number of spherical balloons spread in two-dimensional space. For each balloon, provided input is the start and end coordinates of the horizontal diameter. Since it's horizontal, y-coordinates don't matter and hence the x-coordinates of start and end of the diameter suffice. Start is always smaller than end. There will be at most 104 balloons.

An arrow can be shot up exactly vertically from different points along the x-axis. A balloon with xstart and xend bursts by an arrow shot at x if xstart ≤ x ≤ xend. There is no limit to the number of arrows that can be shot. An arrow once shot keeps travelling up infinitely. The problem is to find the minimum number of arrows that must be shot to burst all balloons.

Example:

Input:
[[10,16], [2,8], [1,6], [7,12]]

Output:
2

Explanation:
One way is to shoot one arrow for example at x = 6 (bursting the balloons [2,8] and [1,6]) and another arrow at x = 11 (bursting the other tw
 */

public class MinimumNumberofArrowstoBurstBalloons {

	// Time : O(nlogn)
		public int findMinArrowShots(int[][] a) {
			if (a.length < 0) {
				return 0;
			}

			/*
			 * sort by end position because we need to shoot down before it ends. If
			 * sort by end , then we can try to find as many balloons as possible
			 * before it ends
			 * 
			 */
			Arrays.sort(a, (a1, a2) -> a1[1] - a2[1]);

			int arrowPos = a[0][1];
			int arrowCount = 1;
			for (int i = 1; i < a.length; i++) {
				/*
				 * if balloon end position is higher than next balloon start
				 * position we dont need to use additional arrow
				 */
				if (a[i][0]  > arrowPos ) {
	                arrowCount++;
	                arrowPos = a[i][1];
				}
			}
			return arrowCount;
		}
		
		// Time : O(nlogn)
	public int findMinArrowShots2(int[][] a) {
		if (a.length < 0) {
			return 0;
		}

		/*
		 * sort by end position because we need to shoot down before it ends. If
		 * sort by end , then we can try to find as many balloons as possible
		 * before it ends
		 * 
		 */
		Arrays.sort(a, (a1, a2) -> a1[1] - a2[1]);

		int arrowPos = a[0][1];
		int arrowCount = 1;
		for (int i = 1; i < a.length; i++) {
			/*
			 * if balloon end position is higher than next balloon start
			 * position we dont need to use addiontal arrow
			 */
			if (arrowPos >= a[i][0]) {
				continue;
			}
			arrowCount++;
			arrowPos = a[i][1];
		}
		return arrowCount;
	}

	public static void main(String[] args) {
		MinimumNumberofArrowstoBurstBalloons obj = new MinimumNumberofArrowstoBurstBalloons();

		int result = -1;
		int[][] points = { { 10, 16 }, { 2, 8 }, { 1, 6 }, { 7, 12 } };
		result = obj.findMinArrowShots(points);
		System.out.println(result);
	}

}
