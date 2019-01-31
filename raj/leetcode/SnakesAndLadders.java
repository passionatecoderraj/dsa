package com.raj.leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 
 * @author Raj
 * 
On an N x N board, the numbers from 1 to N*N are written boustrophedonically starting from the bottom left of the board, and alternating direction each row.  For example, for a 6 x 6 board, the numbers are written as follows:


You start on square 1 of the board (which is always in the last row and first column).  Each move, starting from square x, consists of the following:

You choose a destination square S with number x+1, x+2, x+3, x+4, x+5, or x+6, provided this number is <= N*N.
(This choice simulates the result of a standard 6-sided die roll: ie., there are always at most 6 destinations.)
If S has a snake or ladder, you move to the destination of that snake or ladder.  Otherwise, you move to S.
A board square on row r and column c has a "snake or ladder" if board[r][c] != -1.  The destination of that snake or ladder is board[r][c].

Note that you only take a snake or ladder at most once per move: if the destination to a snake or ladder is the start of another snake or ladder, you do not continue moving.  (For example, if the board is `[[4,-1],[-1,3]]`, and on the first move your destination square is `2`, then you finish your first move at `3`, because you do not continue moving to `4`.)

Return the least number of moves required to reach square N*N.  If it is not possible, return -1.

Example 1:

Input: [
[-1,-1,-1,-1,-1,-1],
[-1,-1,-1,-1,-1,-1],
[-1,-1,-1,-1,-1,-1],
[-1,35,-1,-1,13,-1],
[-1,-1,-1,-1,-1,-1],
[-1,15,-1,-1,-1,-1]]
Output: 4
Explanation: 
At the beginning, you start at square 1 [at row 5, column 0].
You decide to move to square 2, and must take the ladder to square 15.
You then decide to move to square 17 (row 3, column 5), and must take the snake to square 13.
You then decide to move to square 14, and must take the ladder to square 35.
You then decide to move to square 36, ending the game.
It can be shown that you need at least 4 moves to reach the N*N-th square, so the answer is 4.
Note:

2 <= board.length = board[0].length <= 20
board[i][j] is between 1 and N*N or is equal to -1.
The board square with number 1 has no snake or ladder.
The board square with number N*N has no snake or ladder.
 */
public class SnakesAndLadders {

	// Time : O(n2), Space:O(n2)
	public int snakesAndLadders(int[][] board) {
		if (0 == board.length)
			return -1;

		class Node {
			int cell;
			int moves;

			public Node(int cell, int moves) {
				this.cell = cell;
				this.moves = moves;
			}

		}

		Queue<Node> q = new LinkedList<>();
		Set<Integer> visited = new HashSet<>();
		int N = board.length;
		q.offer(new Node(1, 0));

		while (!q.isEmpty()) {
			Node cur = q.poll();
			visited.add(cur.cell);
			if (N * N == cur.cell)
				return cur.moves;
			for (int next_move = cur.cell + 1; next_move <= cur.cell + 6 && next_move <= N*N; next_move++) {
				int next_cell = getValueForMove(next_move, board, N);
				if (!visited.contains(next_cell)) {
					q.offer(new Node(next_cell, cur.moves + 1));
				}
			}
		}

		return -1;
	}

	private int getValueForMove(int s2, int[][] board, int N) {
		int r = (s2 - 1) / N, c = (s2 - 1) % N;
		int _r = N - 1 - r;
		int _c = (N - 1 - _r) % 2 == 0 ? c : N - 1 - c;
		return board[_r][_c] != -1 ? board[_r][_c] : s2;
	}

	public static void main(String[] args) {
		SnakesAndLadders obj = new SnakesAndLadders();

		int board[][] = { 
				{ 1, 1, -1 }, 
				{ 1, 1, 1 }, 
				{ -1, 1, 1 } 
				};

		int res = -1;
		res = obj.snakesAndLadders(board);
		System.out.println(res);

		int board2[][] = { 
				{ -1, -1, -1, -1, -1, -1 }, 
				{ -1, -1, -1, -1, -1, -1 }, 
				{ -1, -1, -1, -1, -1, -1 },
				{ -1, 35, -1, -1, 13, -1 }, 
				{ -1, -1, -1, -1, -1, -1 }, 
				{ -1, 15, -1, -1, -1, -1 } 
				};
		res = obj.snakesAndLadders(board2);
		System.out.println(res);
	}

}
