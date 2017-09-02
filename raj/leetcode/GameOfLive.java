package com.raj.leetcode;

import com.interview.graph.CommonUtil;

public class GameOfLive {

	public void gameOfLife(int[][] board) {
		if (board == null || board.length == 0 || board[0].length == 0)
			return;

		int m = board.length;
		int n = board[0].length;

		int[] x = { -1, -1, 0, 1, 1, 1, 0, -1 };
		int[] y = { 0, 1, 1, 1, 0, -1, -1, -1 };

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				int count = 0;
				for (int k = 0; k < 8; k++) {
					int nx = i + x[k];
					int ny = j + y[k];
					if (nx >= 0 && nx < m && ny >= 0 && ny < n && (board[nx][ny] & 1) == 1) {
						count++;
					}
				}

				// <2 die
				if (count < 2) {
					board[i][j] &= 1;
				}

				// same state
				if (count == 2 || count == 3) {
					board[i][j] |= board[i][j] << 1;
				}

				// go live
				if (count == 3) {
					board[i][j] |= 2;
				}

				// >3 die
				if (count > 3) {
					board[i][j] &= 1;
				}
			}
		}

		CommonUtil.print2DArray(board, board.length, board[0].length);
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				board[i][j] = board[i][j] >> 1;

			}
		}
		CommonUtil.print2DArray(board, board.length, board[0].length);
	}

	public static void main(String args[]) {
		int a[][] = { { 1, 0, 1, 0, 1 }, 
				{ 0, 1, 0, 0, 1 }, 
				{ 0, 1, 0, 0, 1 },
				{ 0, 1, 0, 1, 1 } };
		GameOfLive obj = new GameOfLive();
		obj.gameOfLife(a);
	}
}
