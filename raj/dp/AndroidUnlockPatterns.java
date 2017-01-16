package com.raj.dp;

import java.util.HashMap;
import java.util.Map;

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

	public static int dfs(boolean[] visited, int cur, Map<Integer, Integer> map, int curLen, int totalLen) {
		if (curLen == totalLen)
			return 1;
		visited[cur] = true;
		int res = 0;
		for (int i = 1; i <= 9; i++) {
			int key = cur * 10 + i;
			if (!visited[i] && (!map.containsKey(key) || visited[map.get(key)])) {
				res += dfs(visited, i, map, curLen + 1, totalLen);
			}
		}
		visited[cur] = false;
		return res;
	}

	public static int numberOfPatterns(int m, int n) {
		Map<Integer, Integer> map = new HashMap<>();
		map.put(13, 2);
		map.put(31, 2);
		map.put(17, 4);
		map.put(71, 4);
		map.put(39, 6);
		map.put(93, 6);
		map.put(79, 8);
		map.put(97, 8);
		map.put(19, 5);
		map.put(28, 5);
		map.put(37, 5);
		map.put(46, 5);
		map.put(64, 5);
		map.put(73, 5);
		map.put(82, 5);
		map.put(91, 5);

		int res = 0;
		boolean visited[] = new boolean[10];
		for (int i = m; i <= n; i++) {
			// DFS search each length from m to n
			res += dfs(visited, 1, map, 1, i) * 4;// 1, 3, 7, 9 are symmetric
			res += dfs(visited, 2, map, 1, i) * 4;// 2, 4, 6, 8 are symmetric
			res += dfs(visited, 5, map, 1, i); // 5
		}
		return res;
	}

	// cur: the current position
	static int dfs2(boolean vis[], int[][] skip, int cur, int curLen, int totalLen) {
		if (curLen == totalLen)
			return 1;
		vis[cur] = true;
		int rst = 0;
		for (int i = 1; i <= 9; ++i) {
			// If vis[i] is not visited and (two numbers are adjacent or skip
			// number is already visited)
			if (!vis[i] && (skip[cur][i] == 0 || (vis[skip[cur][i]]))) {
				rst += dfs2(vis, skip, i, curLen + 1, totalLen);
			}
		}
		vis[cur] = false;
		return rst;
	}

	public static int numberOfPatterns2(int m, int n) {
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
			rst += dfs2(vis, skip, 1, 1, i) * 4; // 1, 3, 7, 9 are symmetric
			rst += dfs2(vis, skip, 2, 1, i) * 4; // 2, 4, 6, 8 are symmetric
			rst += dfs2(vis, skip, 5, 1, i); // 5
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