package com.raj.dp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author Raj
 * 
 * In a 2D grid from (0, 0) to (N-1, N-1), every cell contains a 1, except those cells in the given list mines which are 0. What is the largest axis-aligned plus sign of 1s contained in the grid? Return the order of the plus sign. If there is none, return 0.

An "axis-aligned plus sign of 1s of order k" has some center grid[x][y] = 1 along with 4 arms of length k-1 going up, down, left, and right, and made of 1s. This is demonstrated in the diagrams below. Note that there could be 0s or 1s beyond the arms of the plus sign, only the relevant area of the plus sign is checked for 1s.

Examples of Axis-Aligned Plus Signs of Order k:

Order 1:
000
010
000

Order 2:
00000
00100
01110
00100
00000

Order 3:
0000000
0001000
0001000
0111110
0001000
0001000
0000000
Example 1:

Input: N = 5, mines = [[4, 2]]
Output: 2
Explanation:
11111
11111
11111
11111
11011
In the above grid, the largest plus sign can only be order 2.  One of them is marked in bold.
Example 2:

Input: N = 2, mines = []
Output: 1
Explanation:
There is no plus sign of order 2, but there is of order 1.
Example 3:

Input: N = 1, mines = [[0, 0]]
Output: 0
Explanation:
There is no plus sign, so return 0.
Note:

N will be an integer in the range [1, 500].
mines will have length at most 5000.
mines[i] will be length 2 and consist of integers in the range [0, N-1].
(Additionally, programs submitted in C, C++, or C# will be judged with a slightly smaller time limit.)
 *
 */
public class LargestPlusSign {

	// https://leetcode.com/articles/largest-plus-sign/
	// Time :O(n2), Space : O(n2)
	public int orderOfLargestPlusSign2(int N, int[][] mines) {
		Set<Integer> set = new HashSet<>();
		for (int[] mine : mines) {
			set.add(mine[0] * N + mine[1]);
		}
		int res = 0;
		int t[][] = new int[N][N];
		for (int i = 0; i < N; i++) {
			int count = 0;
			for (int j = 0; j < N; j++) {
				count = set.contains(i * N + j) ? 0 : count + 1;
				t[i][j] = count;
			}
			count = 0;
			for (int j = N - 1; j >= 0; j--) {
				count = set.contains(i * N + j) ? 0 : count + 1;
				t[i][j] = Math.min(count, t[i][j]);
			}
		}

		for (int j = 0; j < N; j++) {
			int count = 0;
			for (int i = 0; i < N; i++) {
				count = set.contains(i * N + j) ? 0 : count + 1;
				t[i][j] = Math.min(count, t[i][j]);
			}

			count = 0;
			for (int i = N - 1; i >= 0; i--) {
				count = set.contains(i * N + j) ? 0 : count + 1;
				t[i][j] = Math.min(count, t[i][j]);
				res = Math.max(res, t[i][j]);
			}
		}

		for (int[] a : t)
			System.out.println(Arrays.toString(a));
		return res;

	}

	// https://discuss.leetcode.com/topic/117134/java-c-python-o-n-2-solution-using-only-one-grid-matrix
	// Time :O(n2), Space : O(n2)
	public int orderOfLargestPlusSign(int N, int[][] mines) {
		int res = 0;
		int t[][] = new int[N][N];

		for (int i = 0; i < N; i++) {
			Arrays.fill(t[i], N);
		}
		for (int mine[] : mines) {
			t[mine[0]][mine[1]] = 0;
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0, k = N - 1, l = 0, r = 0, u = 0, d = 0; j < N; j++, k--) {
				t[i][j] = Math.min(t[i][j], l = t[i][j] == 0 ? 0 : l + 1);
				t[i][k] = Math.min(t[i][k], r = t[i][k] == 0 ? 0 : r + 1);
				t[j][i] = Math.min(t[j][i], d = t[j][i] == 0 ? 0 : d + 1);
				t[k][i] = Math.min(t[k][i], u = t[k][i] == 0 ? 0 : u + 1);
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				res = Math.max(res, t[i][j]);
			}
		}
		return res;

	}

	public static void main(String[] args) {
		LargestPlusSign obj = new LargestPlusSign();
		int result = -1;
		result = obj.orderOfLargestPlusSign(5, new int[][] { { 4, 2 } });
		System.out.println(result);

		result = obj.orderOfLargestPlusSign(5, new int[][] { { 2, 2 } });
		System.out.println(result);
	}

}
