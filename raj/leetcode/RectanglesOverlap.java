/**
 * 
 */
package com.raj.leetcode;

/**
 * @author Raj
 *
 *A rectangle is represented as a list [x1, y1, x2, y2], where (x1, y1) are the coordinates of its bottom-left corner, and (x2, y2) are the coordinates of its top-right corner.

Two rectangles overlap if the area of their intersection is positive.  To be clear, two rectangles that only touch at the corner or edges do not overlap.

Given two (axis-aligned) rectangles, return whether they overlap.

Example 1:

Input: rec1 = [0,0,2,2], rec2 = [1,1,3,3]
Output: true
Example 2:

Input: rec1 = [0,0,1,1], rec2 = [1,0,2,1]
Output: false
Notes:

Both rectangles rec1 and rec2 are lists of 4 integers.
All coordinates in rectangles will be between -10^9 and 10^9.

 */

public class RectanglesOverlap {

	// https://leetcode.com/problems/rectangle-overlap/discuss/133175/C++-Solution-with-easy-explanation
	// Time : O(1), Space : O(1);
	public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
		int x1 = rec1[0], y1 = rec1[1], x3 = rec1[2], y3 = rec1[3];
		int x2 = rec2[0], y2 = rec2[1], x4 = rec2[2], y4 = rec2[3];
		return x1 < x4 && x2 < x3 && y1 < y4 && y2 < y3;
	}

	public static void main(String[] args) {
		RectanglesOverlap obj = new RectanglesOverlap();
		boolean result = false;
		result = obj.isRectangleOverlap(new int[] { 0, 0, 2, 2 }, new int[] { 1, 1, 3, 3 });
		System.out.println(result);
		result = obj.isRectangleOverlap(new int[] { 0, 0, 1, 1 }, new int[] { 1, 0, 2, 1 });
		System.out.println(result);
	}

}
