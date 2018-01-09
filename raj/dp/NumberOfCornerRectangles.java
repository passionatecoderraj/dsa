package com.raj.dp;

/**
 * 
 * @author Raj
 *Given a grid where each entry is only 0 or 1, find the number of corner rectangles.

A corner rectangle is 4 distinct 1s on the grid that form an axis-aligned rectangle. Note that only the corners need to have the value 1. Also, all four 1s used must be distinct.

Example 1:
Input: grid = 
[[1, 0, 0, 1, 0],
 [0, 0, 1, 0, 1],
 [0, 0, 0, 1, 0],
 [1, 0, 1, 0, 1]]
Output: 1
Explanation: There is only one corner rectangle, with corners grid[1][2], grid[1][4], grid[3][2], grid[3][4].
Example 2:
Input: grid = 
[[1, 1, 1],
 [1, 1, 1],
 [1, 1, 1]]
Output: 9
Explanation: There are four 2x2 rectangles, four 2x3 and 3x2 rectangles, and one 3x3 rectangle.
Example 3:
Input: grid = 
[[1, 1, 1, 1]]
Output: 0
Explanation: Rectangles must have four distinct corners.
Note:
The number of rows and columns of grid will each be in the range [1, 200].
Each grid[i][j] will be either 0 or 1.
The number of 1s in the grid will be at most 6000.
 */
public class NumberOfCornerRectangles {

	// Time : O(m*m*n), Space : O(1)
	public int countCornerRectangles(int[][] a) {
		int ans = 0;
		for (int i = 0; i < a.length - 1; i++) {
			for (int j = i + 1; j < a.length; j++) {
				int counter = 0;
				for (int k = 0; k < a[0].length; k++) {
					if (a[i][k] == 1 && a[j][k] == 1)
						counter++;
				}
				if (counter > 0)
					ans += counter * (counter - 1) / 2;
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		NumberOfCornerRectangles obj = new NumberOfCornerRectangles();
		int result = -1;
		int a[][] = { { 1, 1, 1 }, { 1, 1, 1 }, { 1, 1, 1 } };
		result = obj.countCornerRectangles(a);
		System.out.println(result);

		int b[][] = { { 1, 0, 0, 1, 0 }, { 0, 0, 1, 0, 1 }, { 0, 0, 0, 1, 0 }, { 1, 0, 1, 0, 1 } };

		result = obj.countCornerRectangles(b);
		System.out.println(result);
	}

}
