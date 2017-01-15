package com.raj.dp;

/**
 * 
 * @author Raj
 *
 *         Number of ways to make mobile lock pattern
 * 
 *         A mobile pattern is a grid of 3X3 cell, where drawing a specific
 *         pattern (connecting specific sequence of cells in order) will unlock
 *         the mobile. In this problem, the task is to calculate number of ways
 *         of making the lock pattern with number of connections in given range.
 *         In general terms, we are given a range as min and max, we need to
 *         tell how many patterns can be made which use at least min connection
 *         cell and at most max connection cell.
 */
public class AndroidUnlockPatterns {

	// cur: the current position
	static int dfs(boolean vis[], int[][] skip, int cur, int curLen, int totalLen) {
		if (curLen == totalLen)
			return 1;
		vis[cur] = true;
		int rst = 0;
		for (int i = 1; i <= 9; ++i) {
			// If vis[i] is not visited and (two numbers are adjacent or skip
			// number is already visited)
			if (!vis[i] && (skip[cur][i] == 0 || (vis[skip[cur][i]]))) {
				rst += dfs(vis, skip, i, curLen + 1, totalLen);
			}
		}
		vis[cur] = false;
		return rst;
	}

	public static int numberOfPatterns(int m, int n) {
		// Skip array represents number to skip between two pairs
		int skip[][] = new int[10][10];
		skip[1][3] = skip[3][1] = 2;
		skip[1][7] = skip[7][1] = 4;
		skip[3][9] = skip[9][3] = 6;
		skip[7][9] = skip[9][7] = 8;
		skip[1][9] = skip[9][1] = skip[2][8] = skip[8][2] = skip[3][7] = skip[7][3] = skip[4][6] = skip[6][4] = 5;
		boolean vis[] = new boolean[10];
		int rst = 0;
		// DFS search each length from m to n
		for (int i = m; i <= n; ++i) {
			rst += dfs(vis, skip, 1, 1, i) * 4; // 1, 3, 7, 9 are symmetric
			rst += dfs(vis, skip, 2, 1, i) * 4; // 2, 4, 6, 8 are symmetric
			rst += dfs(vis, skip, 5, 1, i); // 5
		}
		return rst;
	}

	public static void main(String args[]) {
		int res = numberOfPatterns(3, 3);
		System.out.println(res);
	}

	// cur: the current position
	// remain: the steps remaining
	static int DFS(boolean vis[], int[][] skip, int cur, int remain, StringBuilder sb) {
		if (remain < 0)
			return 0;
		if (remain == 0) {
			System.out.println(sb);
			return 1;
		}
		vis[cur] = true;
		int rst = 0;
		for (int i = 1; i <= 9; ++i) {
			// If vis[i] is not visited and (two numbers are adjacent or skip
			// number is already visited)
			if (!vis[i] && (skip[cur][i] == 0 || (vis[skip[cur][i]]))) {
				rst += DFS(vis, skip, i, remain - 1, sb.append(i));
				sb.deleteCharAt(sb.length() - 1);
			}
		}
		vis[cur] = false;
		return rst;
	}

	public static int numberOfPatternsWithPath(int m, int n) {
		// Skip array represents number to skip between two pairs
		int skip[][] = new int[10][10];
		skip[1][3] = skip[3][1] = 2;
		skip[1][7] = skip[7][1] = 4;
		skip[3][9] = skip[9][3] = 6;
		skip[7][9] = skip[9][7] = 8;
		skip[1][9] = skip[9][1] = skip[2][8] = skip[8][2] = skip[3][7] = skip[7][3] = skip[4][6] = skip[6][4] = 5;
		boolean vis[] = new boolean[10];
		int rst = 0;
		StringBuilder sb = new StringBuilder();
		// DFS search each length from m to n
		for (int i = m; i <= n; ++i) {
			sb = new StringBuilder(); // symmetric
			rst += DFS(vis, skip, 7, i - 1, sb.append(7)) * 4; // 1, 3, 7, 9 are
			sb = new StringBuilder(); // symmetric
			rst += DFS(vis, skip, 2, i - 1, sb.append(2)) * 4; // 2, 4, 6, 8 are
			sb = new StringBuilder(); // symmetric
			rst += DFS(vis, skip, 5, i - 1, sb.append(5)); // 5
		}
		return rst;
	}
}