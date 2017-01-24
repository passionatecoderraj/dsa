/**
 * 
 */
package com.raj.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.raj.patternmatching.Trie;

/**
 * @author Raj
 *
 *         Given a 2D board and a list of words from the dictionary, find all
 *         words in the board.
 * 
 *         Each word must be constructed from letters of sequentially adjacent
 *         cell, where "adjacent" cells are those horizontally or vertically
 *         neighboring. The same letter cell may not be used more than once in a
 *         word.
 * 
 *         For example, Given words = ["oath","pea","eat","rain"] and board =
 * 
 *         [ ['o','a','a','n'], ['e','t','a','e'], ['i','h','k','r'],
 *         ['i','f','l','v'] ]
 * 
 *         Return ["eat","oath"].
 */
public class SearchWordInMatrix2 {

	public List<String> findWords(char[][] board, String[] words) {
		Trie trie = new Trie();
		for (String word : words) {
			trie.insert(word);
		}

		int moves[][] = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };
		boolean[][] visited = new boolean[board.length][board[0].length];

		Set<String> result = new HashSet<String>();
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				dfs(i, j, "", visited, board, moves, trie, result);
			}
		}
		return new ArrayList<>(result);
	}

	private void dfs(int x, int y, String wordSoFar, boolean[][] visited, char[][] board, int[][] moves, Trie trie,
			Set<String> result) {

		if (!trie.hasPrefix(wordSoFar))
			return;
		if (trie.search(wordSoFar)) {
			result.add(wordSoFar);
			return;
		}
		for (int i = 0; i < moves.length; i++) {
			int _x = x + moves[i][0];
			int _y = y + moves[i][1];
			if (isSafe(board, _x, _y, visited)) {
				visited[_x][_y] = true;
				dfs(_x, _y, wordSoFar + board[_x][_y], visited, board, moves, trie, result);
				visited[_x][_y] = false;
			}
		}
	}

	private boolean isSafe(char[][] matrix, int x, int y, boolean[][] visited) {
		return x >= 0 && x < matrix.length && y >= 0 && y < matrix[0].length && !visited[x][y];
	}

	public static void main(String[] args) {
		SearchWordInMatrix2 obj = new SearchWordInMatrix2();
		char[][] matrix = { { 'o', 'a', 'a', 'n' }, { 'e', 't', 'a', 'e' }, { 'i', 'h', 'k', 'r' },
				{ 'i', 'f', 'l', 'v' } };

		String words[] = { "oath", "pea", "eat", "rain" };

		List<String> result = obj.findWords(matrix, words);

		System.out.println(result);
	}

}
