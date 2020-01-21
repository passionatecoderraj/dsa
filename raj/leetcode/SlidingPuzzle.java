/**
 * 
 */
package com.raj.leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @author Raj
 *
 *         On a 2x3 board, there are 5 tiles represented by the integers 1
 *         through 5, and an empty square represented by 0.
 * 
 *         A move consists of choosing 0 and a 4-directionally adjacent number
 *         and swapping it.
 * 
 *         The state of the board is solved if and only if the board is
 *         [[1,2,3],[4,5,0]].
 * 
 *         Given a puzzle board, return the least number of moves required so
 *         that the state of the board is solved. If it is impossible for the
 *         state of the board to be solved, return -1.
 * 
 *         Examples:
 * 
 *         Input: board = [[1,2,3],[4,0,5]] Output: 1 Explanation: Swap the 0
 *         and the 5 in one move. Input: board = [[1,2,3],[5,4,0]] Output: -1
 *         Explanation: No number of moves will make the board solved. Input:
 *         board = [[4,1,2],[5,0,3]] Output: 5 Explanation: 5 is the smallest
 *         number of moves that solves the board. An example path: After move 0:
 *         [[4,1,2],[5,0,3]] After move 1: [[4,1,2],[0,5,3]] After move 2:
 *         [[0,1,2],[4,5,3]] After move 3: [[1,0,2],[4,5,3]] After move 4:
 *         [[1,2,0],[4,5,3]] After move 5: [[1,2,3],[4,5,0]] Input: board =
 *         [[3,2,4],[1,5,0]] Output: 14 Note:
 * 
 *         board will be a 2 x 3 array as described above. board[i][j] will be a
 *         permutation of [0, 1, 2, 3, 4, 5].
 * 
 */
public class SlidingPuzzle {

	// https://leetcode.com/problems/sliding-puzzle/discuss/146652/Java-8ms-BFS-with-algorithm-explained
	public int slidingPuzzle(int[][] board) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				sb.append(board[i][j]);
			}
		}
		/*
		 * if zero is at '0'th position you can swap with 1,3 positions if zero is at
		 * '1'th position you can swap with 1,3 positions .. .. if zero is at '5'th
		 * position you can swap with 2,4 positions
		 */
		int dirs[][] = { { 1, 3 }, { 0, 2, 4 }, { 1, 5 }, { 0, 4 }, { 1, 3, 5 }, { 2, 4 } };
		Set<String> visited = new HashSet<>();
		Queue<String> q = new LinkedList<>();
		q.offer(sb.toString());
		int moves = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				String cur = q.poll();
				visited.add(cur);
				if (cur.equals("123450"))
					return moves;
				int idx = cur.indexOf('0');
				for (int swap_position : dirs[idx]) {
					String s = swap(cur, idx, swap_position);
					if (!visited.contains(s)) {
						q.offer(s);
					}
				}
			}
			moves++;
		}

		return -1;
	}

	public int slidingPuzzle2(int[][] board) {
		int res[][] = { { 1, 2, 3 }, { 4, 5, 0 } };
		return minMoveStep(board, res);
	}

	public int minMoveStep(int[][] init_state, int[][] final_state) {
		int m = init_state.length;
		int n = init_state[0].length;

		int moves[][] = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
		StringBuilder start = new StringBuilder();
		StringBuilder end = new StringBuilder();
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				start.append(init_state[i][j]);
				end.append(final_state[i][j]);
			}
		}
		String res = end.toString();

		Set<String> set = new HashSet<>();
		Queue<String> q = new LinkedList<>();
		q.offer(start.toString());
		set.add(start.toString());
		int steps = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int k = 0; k < size; k++) {
				String cur = q.poll();
				if (cur.equals(res)) {
					return steps;
				}
				int curPos = cur.indexOf('0');
				int i = curPos / n;
				int j = curPos % n;
				for (int move[] : moves) {
					int x = move[0] + i;
					int y = move[1] + j;
					if (x >= 0 && x < m && y >= 0 && y < n) {
						int newPos = x * n + y;
						String s = swap(cur, curPos, newPos);
						if (set.add(s)) {
							q.offer(s);
						}
					}
				}
			}
			steps++;
		}
		return -1;
	}

	public int minMoveStep2(int[][] init_state, int[][] final_state) {
		int m = init_state.length;
		int n = init_state[0].length;

		int moves[][] = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
		String cur = genString(init_state), res = genString(final_state);
		class Node {
			String cur;
			int steps;

			public Node(String cur, int steps) {
				this.cur = cur;
				this.steps = steps;
			}

			public String toString() {
				return "Node [cur=" + cur + ", steps=" + steps + "]";
			}

		}

		Set<String> set = new HashSet<>();
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(cur, 0));
		set.add(cur);
		while (!q.isEmpty()) {
			Node node = q.poll();
			if (node.cur.equals(res)) {
				return node.steps;
			}
			int curPos = node.cur.indexOf('0');
			int i = curPos / n;
			int j = curPos % n;
			for (int move[] : moves) {
				int x = move[0] + i;
				int y = move[1] + j;
				if (x >= 0 && x < m && y >= 0 && y < n) {
					int newPos = x * n + y;
					String s = swap(node.cur, curPos, newPos);
					if (set.add(s)) {
						q.offer(new Node(s, node.steps + 1));
					}
				}
			}
		}
		return -1;
	}

	String genString(int[][] a) {
		StringBuilder s = new StringBuilder();
		for (int[] m : a)
			for (int i : m)
				s.append(i);
		return s.toString();
	}

	private String swap(String cur, int idx, int swap_position) {
		StringBuilder sb = new StringBuilder(cur);
		sb.setCharAt(idx, cur.charAt(swap_position));
		sb.setCharAt(swap_position, cur.charAt(idx));
		return sb.toString();
	}

	public static void main(String[] args) {
		SlidingPuzzle obj = new SlidingPuzzle();
		int res = -1;
		int board[][] = { { 1, 2, 3 }, { 5, 4, 0 } };
		res = obj.slidingPuzzle(board);
		System.out.println(res);

		int board2[][] = { { 3, 2, 4 }, { 1, 5, 0 } };
		res = obj.slidingPuzzle(board2);
		System.out.println(res);
	}

}
