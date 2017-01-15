package com.raj.dp;

import com.interivew.graph.CommonUtil;

public class GamePickingStrategyForFirstPlayerToWin {
	public static void main(String[] args) {
		GamePickingStrategyForFirstPlayerToWin obj = new GamePickingStrategyForFirstPlayerToWin();
		int result = -1;
		 int[] a = { 3, 9, 1, 2 };
		//int[] a = { 20, 30, 2, 2, 2, 10 };
		result = obj.gamePickingStrategyForFirstPlayerToWin(a);
		System.out.println(result);

	}

	public int gamePickingStrategyForFirstPlayerToWin(int[] a) {
		int n = a.length;
		if (n <= 0)
			return -1;
		Cell t[][] = new Cell[n][n];
		for (int i = 0; i < n; i++) {
			t[i][i] = new Cell(a[i], 0);
		}
		for (int l = 2; l <= n; l++) {
			for (int i = 0; i < n - l + 1; i++) {
				int j = i + l - 1;
				int p1 = Math.max(t[i][i].player1 + t[i + 1][j].player2, t[j][j].player1 + t[i][j - 1].player2);
				int p2 = Math.min(t[i][i].player2 + t[i + 1][j].player1, t[j][j].player2 + t[i][j - 1].player1);
				t[i][j] = new Cell(p1, p2);
			}
		}
		CommonUtil.print2DArray(t, n, n);
		return t[0][n - 1].player1;
	}

	public int multiplyDp(int[] a) {
		int n = a.length;
		if (n <= 0)
			return -1;
		int t[][] = new int[n][n];

		for (int i = 1; i < n; i++) {
			t[i][i] = 0;
		}

		for (int l = 2; l < n; l++) {
			for (int i = 1; i < n - l + 1; i++) {
				int j = i + l - 1;
				t[i][j] = Integer.MAX_VALUE;
				for (int k = i; k <= j - 1; k++) {
					int m = t[i][k] + t[k + 1][j] + a[i - 1] * a[k] * a[j];
					if (t[i][j] > m) {
						t[i][j] = m;
					}
				}
			}
		}

		// for (int i = 0; i < n; i++) {
		// for (int j = 0; j < n; j++) {
		// System.out.print(t[i][j] + " ");
		// }
		// System.out.println();
		// }

		return t[1][n - 1];
	}

}

class Cell {
	int player1;
	int player2;

	public Cell(int player1, int player2) {
		super();
		this.player1 = player1;
		this.player2 = player2;
	}

	@Override
	public String toString() {
		return "[p1=" + player1 + ", p2=" + player2 + "]";
	}

}
