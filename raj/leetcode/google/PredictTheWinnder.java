package com.raj.leetcode.google;
/**
 * 
 * @author Raj
 *
 *Given an array of scores that are non-negative integers. Player 1 picks one of the numbers from either end of the array followed by the player 2 and then player 1 and so on. Each time a player picks a number, that number will not be available for the next player. This continues until all the scores have been chosen. The player with the maximum score wins.

Given an array of scores, predict whether player 1 is the winner. You can assume each player plays to maximize his score.

Example 1:
Input: [1, 5, 2]
Output: False
Explanation: Initially, player 1 can choose between 1 and 2. 
If he chooses 2 (or 1), then player 2 can choose from 1 (or 2) and 5. If player 2 chooses 5, then player 1 will be left with 1 (or 2). 
So, final score of player 1 is 1 + 2 = 3, and player 2 is 5. 
Hence, player 1 will never be the winner and you need to return False.
Example 2:
Input: [1, 5, 233, 7]
Output: True
Explanation: Player 1 first chooses 1. Then player 2 have to choose between 5 and 7. No matter which number player 2 choose, player 1 can choose 233.
Finally, player 1 has more score (234) than player 2 (12), so you need to return True representing player1 can win.
Note:
1 <= length of the array <= 20.
Any scores in the given array are non-negative integers and will not exceed 10,000,000.
If the scores of both players are equal, then player 1 is still the winner.
 */
public class PredictTheWinnder {

	// Time : O(n2), Space : O(n)
	public boolean PredictTheWinner(int[] a) {
		int n = a.length;
		if (n <= 0)
			return true;
		Cell t[] = new Cell[n];

		for (int i = n - 1; i >= 0; i--) {
			t[i] = new Cell(a[i],0);
			for (int j = i+1; j < n; j++) {
				int p1, p2;
				if (a[i] + t[j].player2 > a[j] + t[j - 1].player2) {
					p1 = a[i] + t[j].player2;
					p2 = t[j].player1;
				} else {
					p1 = a[j] + t[j-1].player2;
					p2 = t[j-1].player1;
				}
				t[j] = new Cell(p1, p2);
			}
		}

		return t[n - 1].player1 >= t[n - 1].player2;
	}

	// Time : O(n2), Space : O(n2)
	public boolean PredictTheWinner2(int[] a) {
		int n = a.length;
		if (n <= 0)
			return true;
		Cell t[][] = new Cell[n][n];
		for (int i = 0; i < n; i++) {
			t[i][i] = new Cell(a[i], 0);
		}
		for (int l = 2; l <= n; l++) {
			for (int i = 0; i < n - l + 1; i++) {
				int j = i + l - 1;
				int p1, p2;
				if ((a[i] + t[i + 1][j].player2) > (a[j] + t[i][j - 1].player2)) {
					p1 = a[i] + t[i + 1][j].player2;
					p2 = t[i + 1][j].player1;
				} else {
					p1 = a[j] + t[i][j - 1].player2;
					p2 = t[i][j - 1].player1;
				}
				t[i][j] = new Cell(p1, p2);
			}
		}
		return t[0][n - 1].player1 >= t[0][n - 1].player2;
	}

	public static void main(String[] args) {
		PredictTheWinnder obj = new PredictTheWinnder();
		boolean result = false;
		int[] a = { 20, 30, 2, 2, 2, 10 };
		result = obj.PredictTheWinner(a);
		System.out.println(result);
		result = obj.PredictTheWinner(new int[] { 1, 5, 233, 7 });
		System.out.println(result);

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
