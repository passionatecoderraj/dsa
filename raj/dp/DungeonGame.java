package com.raj.dp;

import com.interview.graph.CommonUtil;

/**
 * 
 * @author Raj
 *
 *         The demons had captured the princess (P) and imprisoned her in the
 *         bottom-right corner of a dungeon. The dungeon consists of M x N rooms
 *         laid out in a 2D grid. Our valiant knight (K) was initially
 *         positioned in the top-left room and must fight his way through the
 *         dungeon to rescue the princess.
 * 
 *         The knight has an initial health point represented by a positive
 *         integer. If at any point his health point drops to 0 or below, he
 *         dies immediately.
 * 
 *         Some of the rooms are guarded by demons, so the knight loses health
 *         (negative integers) upon entering these rooms; other rooms are either
 *         empty (0's) or contain magic orbs that increase the knight's health
 *         (positive integers).
 * 
 *         In order to reach the princess as quickly as possible, the knight
 *         decides to move only rightward or downward in each step.
 * 
 *         Write a function to determine the knight's minimum initial health so
 *         that he is able to rescue the princess.
 * 
 *         For example, given the dungeon below, the initial health of the
 *         knight must be at least 7 if he follows the optimal path RIGHT->
 *         RIGHT -> DOWN -> DOWN.
 * 
 *         -2 (K) -3 3 -5 -10 1 10 30 -5 (P)
 * 
 *         Notes:
 * 
 *         The knight's health has no upper bound. Any room can contain threats
 *         or power-ups, even the first room the knight enters and the
 *         bottom-right room where the princess is imprisoned.
 */
public class DungeonGame {

	public static int dungeonGame(int a[][]) {
		int m = a.length, n = a[0].length;
		int t[][] = new int[m][n];

		t[m - 1][n - 1] = Math.max(1 - a[m - 1][n - 1], 1);

		for (int i = m - 2; i >= 0; i--) {
			t[i][n - 1] = Math.max(t[i + 1][n - 1] - a[i][n - 1], 1);
		}

		for (int j = n - 2; j >= 0; j--) {
			t[m - 1][j] = Math.max(t[m - 1][j + 1] - a[m - 1][j], 1);
		}

		for (int i = m - 2; i >= 0; i--) {
			for (int j = n - 2; j >= 0; j--) {
				int down = Math.max(t[i + 1][j] - a[i][j], 1);
				int right = Math.max(t[i][j + 1] - a[i][j], 1);
				t[i][j] = Math.min(right, down);
			}
		}
		CommonUtil.print2DArray(t, m, n);
		return t[0][0];
	}

	public static void main(String[] args) {
		int result = -1;
		int a[][] = { { -2, -3, 3 }, { -5, -10, 1 }, { 10, 30, -5 } };
		result = dungeonGame(a);
		System.out.println(result);

		int b[][] = { { 1, -3, 3 }, { 0, -2, 0 }, { -3, -3, -3 } };
		result = dungeonGame(b);
		System.out.println(result);
	}
}
