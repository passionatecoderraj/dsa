package com.raj.leetcode.google;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Raj
 *
 *Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

Each row must contain the digits 1-9 without repetition.
Each column must contain the digits 1-9 without repetition.
Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.

A partially filled sudoku which is valid.

The Sudoku board could be partially filled, where empty cells are filled with the character '.'.

Example 1:

Input:
[
  ["5","3",".",".","7",".",".",".","."],
  ["6",".",".","1","9","5",".",".","."],
  [".","9","8",".",".",".",".","6","."],
  ["8",".",".",".","6",".",".",".","3"],
  ["4",".",".","8",".","3",".",".","1"],
  ["7",".",".",".","2",".",".",".","6"],
  [".","6",".",".",".",".","2","8","."],
  [".",".",".","4","1","9",".",".","5"],
  [".",".",".",".","8",".",".","7","9"]
]
Output: true
Example 2:

Input:
[
  ["8","3",".",".","7",".",".",".","."],
  ["6",".",".","1","9","5",".",".","."],
  [".","9","8",".",".",".",".","6","."],
  ["8",".",".",".","6",".",".",".","3"],
  ["4",".",".","8",".","3",".",".","1"],
  ["7",".",".",".","2",".",".",".","6"],
  [".","6",".",".",".",".","2","8","."],
  [".",".",".","4","1","9",".",".","5"],
  [".",".",".",".","8",".",".","7","9"]
]
Output: false
Explanation: Same as Example 1, except with the 5 in the top left corner being 
    modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.
Note:

A Sudoku board (partially filled) could be valid but is not necessarily solvable.
Only the filled cells need to be validated according to the mentioned rules.
The given board contain only digits 1-9 and the character '.'.
The given board size is always 9x9.
 */
public class ValidSudoku {

	
	public boolean isValidSudoku(char[][] board) {
       	boolean[][] rows = new boolean[9][9];
		boolean[][] cols = new boolean[9][9];
		Map<String,Set<Character>> blocks = new HashMap<>();

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == '.')
					continue;
				
				int startX = i-i%3,startY=j-j%3;
				String key = startX+""+startY;
				if(!blocks.containsKey(key)) {
					blocks.put(key, new HashSet<>());
				}
				
				int val = board[i][j] - '1';
				if (rows[i][val] || cols[j][val] || !blocks.get(key).add(board[i][j]))
					return false;				
				
				rows[i][val] = cols[j][val] = true;
			}
		}
		return true;
	}
	
	public boolean isValidSudoku2(char[][] board) {
		boolean[][] rows = new boolean[9][9];
		boolean[][] cols = new boolean[9][9];
		Map<String,boolean[]> blocks = new HashMap<>();

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == '.')
					continue;
				
				int startX = i-i%3,startY=j-j%3;
				String key = startX+""+startY;
				if(!blocks.containsKey(key)) {
					blocks.put(key, new boolean[9]);
				}
				
				int val = board[i][j] - '1';
				if (rows[i][val] || cols[j][val] || blocks.get(key)[val])
					return false;				
				
				rows[i][val] = cols[j][val] = blocks.get(key)[val] = true;
			}
		}
		return true;
	}

	//https://leetcode.com/problems/valid-sudoku/discuss/15643/Simple-clear-java-solution
	public boolean isValidSudoku3(char[][] board) {

		boolean[][] rows = new boolean[9][9];
		boolean[][] cols = new boolean[9][9];
		boolean[][] blocks = new boolean[9][9];

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == '.')
					continue;
				int val = board[i][j] - '1';
				if (rows[i][val] || cols[j][val] || blocks[i - (i % 3) + (j / 3)][val])
					return false;
				rows[i][val] = cols[j][val] = blocks[i - (i % 3) + (j / 3)][val] = true;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		ValidSudoku obj = new ValidSudoku();
		
		char a[][] = {
				  {'8','3','.','.','7','.','.','.','.'},
				  {'6','.','.','1','9','5','.','.','.'},
				  {'.','9','8','.','.','.','.','6','.'},
				  {'8','.','.','.','6','.','.','.','3'},
				  {'4','.','.','8','.','3','.','.','1'},
				  {'7','.','.','.','2','.','.','.','6'},
				  {'.','6','.','.','.','.','2','8','.'},
				  {'.','.','.','4','1','9','.','.','5'},
				  {'.','.','.','.','8','.','.','7','9'}
				};


		char b[][]= {
				  {'5','3','.','.','7','.','.','.','.'},
				  {'6','.','.','1','9','5','.','.','.'},
				  {'.','9','8','.','.','.','.','6','.'},
				  {'8','.','.','.','6','.','.','.','3'},
				  {'4','.','.','8','.','3','.','.','1'},
				  {'7','.','.','.','2','.','.','.','6'},
				  {'.','6','.','.','.','.','2','8','.'},
				  {'.','.','.','4','1','9','.','.','5'},
				  {'.','.','.','.','8','.','.','7','9'}
				};
		boolean result = false;
		result = obj.isValidSudoku(a);
		System.out.println(result);

		result = obj.isValidSudoku(b);
		System.out.println(result);

	}

}
