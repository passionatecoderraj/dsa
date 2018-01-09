/**
 * 
 */
package com.raj.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.raj.nodes.TrieNode;
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

	int moves[][] = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };

	public List<String> findWords(char[][] a, String[] words) {
		Trie trie = new Trie();
		for (String word : words) {
			trie.insert(word);
		}

		Set<String> result = new HashSet<String>();
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				if (trie.root.children.containsKey(a[i][j])) {
					dfs(i, j, Character.toString(a[i][j]), a, trie.root.children.get(a[i][j]), result);
				}
			}
		}
		return new ArrayList<>(result);
	}

	private void dfs(int x, int y, String word, char[][] a, TrieNode node, Set<String> result) {

		if (node.endOfWord) {
			result.add(word);
		}

		a[x][y] = '#';
		for (int i = 0; i < moves.length; i++) {
			int _x = moves[i][0] + x;
			int _y = moves[i][1] + y;
			if (isSafe(a, _x, _y, node) && node.children.containsKey(a[_x][_y])) {
				dfs(_x, _y, word + a[_x][_y], a, node.children.get(a[_x][_y]), result);
			}

		}
		a[x][y] = node.data;
	}

	private boolean isSafe(char[][] a, int x, int y, TrieNode node) {
		return x >= 0 && x < a.length && y >= 0 && y < a[0].length && a[x][y] != '#'
				&& node.children.containsKey(a[x][y]);
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
