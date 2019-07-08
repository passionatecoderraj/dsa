package com.raj.leetcode;

import java.util.Arrays;

/**
 * 
 * @author Raj
 *
 *In a N x N grid representing a field of cherries, each cell is one of
 *         three possible integers.
 * 
 * 
 * 
 *         0 means the cell is empty, so you can pass through; 1 means the cell
 *         contains a cherry, that you can pick up and pass through; -1 means
 *         the cell contains a thorn that blocks your way.
 * 
 * 
 *         Your task is to collect maximum number of cherries possible by
 *         following the rules below:
 * 
 * 
 * 
 *         Starting at the position (0, 0) and reaching (N-1, N-1) by moving
 *         right or down through valid path cells (cells with value 0 or 1);
 *         After reaching (N-1, N-1), returning to (0, 0) by moving left or up
 *         through valid path cells; When passing through a path cell containing
 *         a cherry, you pick it up and the cell becomes an empty cell (0); If
 *         there is no valid path between (0, 0) and (N-1, N-1), then no
 *         cherries can be collected.
 * 
 * 
 * 
 * 
 *         Example 1:
 * 
 *         Input: grid = [[0, 1, -1], [1, 0, -1], [1, 1, 1]] Output: 5
 *         Explanation: The player started at (0, 0) and went down, down, right
 *         right to reach (2, 2). 4 cherries were picked up during this single
 *         trip, and the matrix becomes [[0,1,-1],[0,0,-1],[0,0,0]]. Then, the
 *         player went left, up, up, left to return home, picking up one more
 *         cherry. The total number of cherries picked up is 5, and this is the
 *         maximum possible.
 * 
 * 
 *         Note:
 * 
 *         grid is an N by N 2D array, with 1 <= N <= 50. Each grid[i][j] is an
 *         integer in the set {-1, 0, 1}. It is guaranteed that grid[0][0] and
 *         grid[N-1][N-1] are not -1.
 * 
 */
public class CherryPickup {


	/*
	 * Go from (0, 0) -> (n-1, n-1) -> (0, 0) can be opt to two men go from (0, 0)
	 * -> (n-1, n-1) together, but when they go into the same cell, the cur state
	 * can only be added 1 (use once) Using DP to solve the problem: 1.
	 * dp[x1][y1][x2] to represent the largest ans we can get when first guy (marked
	 * as A) at(x1, y2) and second guy(marked as B) at (x2, x1 + y1 - x2) because we
	 * can only go right and down, so we have x1 + y1 = x2 + y2 2. Induction: every
	 * time we calculate the maximum of : dp[x1 - 1][y1][x2] : A down, B right
	 * dp[x1][y1 - 1][x2] : A right, B right dp[x1 - 1][y1][x2 - 1]: A down, B down
	 * dp[x1][y1 - 1][x2 - 1]: A right, B down if the Max of these values is
	 * negative, then we don't have a path to this point else we have:
	 * dp[x1][y1][x2] = Max + grid[x1 - 1][y1 - 1] + grid[x2 - 1][y2 - 1](if x1 !=
	 * x2 && y1 != y2) else we only add once. 3. Base case; we use dp[][][]from 1 -
	 * n, so we have: dp[1][1][1] = 1 and all other values are MIN_VALUE 4. Ans:
	 * dp[n][n][n] 5. Direction: from top left -> bottom right 6. Time: O(n^3)
	 * Space: O(n^3)
	 */
	// https://leetcode.com/problems/cherry-pickup/discuss/165218/Java-O(N3)-DP-solution-w-specific-explanation
	// Time : O(n3), Space : O(n3)
	public int cherryPickup(int[][] a) {
		int n = a.length;
		int[][][] t = new int[n + 1][n + 1][n + 1];
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= n; j++) {
				Arrays.fill(t[i][j], Integer.MIN_VALUE);
			}
		}
		t[1][1][1] = a[0][0];
		for (int x1 = 1; x1 <= n; x1++) {
			for (int y1 = 1; y1 <= n; y1++) {
				for (int x2 = 1; x2 <= n; x2++) {
					int y2 = x1 + y1 - x2;

					// if (t[x1][y1][x2] > 0 || y2 < 1 || y2 > n || a[x1 - 1][y1 - 1] == -1 || a[x2
					// - 1][y2 - 1] == -1) {
					if (y2 < 1 || y2 > n || a[x1 - 1][y1 - 1] == -1 || a[x2 - 1][y2 - 1] == -1) {
						continue;
						// have already detected || out of boundary || cannot access
					}

					/*
					 * 1. (x1-1,y1) - (x2, y2-1) -> up, left 2. (x1-1,y1) - (x2-1, y2) -> up, up 3.
					 * (x1,y1-1) - (x2, y2-1) -> left, left 4. (x1,y1-1) - (x2-1, y2) -> left, up
					 * 
					 */
					int cur = Math.max(Math.max(t[x1 - 1][y1][x2], t[x1 - 1][y1][x2 - 1]),
							Math.max(t[x1][y1 - 1][x2], t[x1][y1 - 1][x2 - 1]));
					if (cur < 0) {
						continue;
					}
					t[x1][y1][x2] = cur + a[x1 - 1][y1 - 1];
					// if (x1 != x2 && y1!=y2) {
					if (x1 != x2) {
						t[x1][y1][x2] += a[x2 - 1][y2 - 1];
					}
				}
			}
		}
		return t[n][n][n] < 0 ? 0 : t[n][n][n];
	}
	
	/*
	 * Let dp[r1][c1][c2] be the most number of cherries obtained by two people starting at (r1, c1) and (r2, c2) and 
	 * walking towards (N-1, N-1) picking up cherries, where r2 = r1+c1-c2.
	 * 
	 * If grid[r1][c1] and grid[r2][c2] are not thorns, then the value of dp[r1][c1][c2] is (grid[r1][c1] + grid[r2][c2]), 
	 * plus the maximum of dp[r1+1][c1][c2], dp[r1][c1+1][c2], dp[r1+1][c1][c2+1], dp[r1][c1+1][c2+1] as appropriate. 
	 * We should also be careful to not double count in case (r1, c1) == (r2, c2).
	 * 
	 * 
	 */
	// https://leetcode.com/problems/cherry-pickup/solution/
	// Time : O(n3), Space : O(n3)
	public int cherryPickup2(int[][] a) {
		int n = a.length;
		int t[][][] = new int[n][n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				Arrays.fill(t[i][j], Integer.MIN_VALUE);
			}
		}
		int res = dp(t,a,0,0,0,n);
		return res < 0 ? 0 : res;
	}

	private int dp(int[][][] t, int a[][], int x1, int y1, int x2,int n) {
		int y2 = x1 + y1 - x2;
		if(x1 == n || x2 == n || y1 == n || y2 == n || a[x1][y1] == -1 || a[x2][y2] == -1) {
			return Integer.MIN_VALUE;
		}
		// when reaching end point, then return no. of cherries
		if(x1 == n-1 && y1 == n-1)
			return a[x1][y1];
		
		if(t[x1][y1][x2] == Integer.MIN_VALUE) {
			int res = a[x1][y1];
			if(x1 != x2) {
				res += a[x2][y2];
			}
			/*
			 *  Person 1 down and person 2 down: dp[r1+1][c1][c2];
				Person 1 right and person 2 down: dp[r1][c1+1][c2];
				Person 1 down and person 2 right: dp[r1+1][c1][c2+1];
				Person 1 right and person 2 right: dp[r1][c1+1][c2+1];
			 */
			res += Math.max(Math.max(dp(t, a, x1, y1+1, x2+1, n), dp(t, a, x1+1, y1, x2+1, n)),
                    Math.max(dp(t, a, x1, y1+1, x2, n), dp(t, a, x1+1, y1, x2, n)));
			if(res > 0)
				t[x1][y1][x2]=res;
		}
		return t[x1][y1][x2];
	}


	public static void main(String[] args) {
		CherryPickup obj = new CherryPickup();

		int a[][] = { { 0, 1, -1 }, { 1, 0, -1 }, { 1, 1, 1 } };
		int result = -1;
		result = obj.cherryPickup(a);
		System.out.println(result);
	}

}
