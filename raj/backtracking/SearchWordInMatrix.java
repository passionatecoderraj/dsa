/**
 * 
 */
package com.raj.backtracking;

/**
 * @author Raj
 *
 */
public class SearchWordInMatrix {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SearchWordInMatrix obj = new SearchWordInMatrix();
		char[][] matrix = { { 't', 'z', 'x', 'c', 'd' }, { 'a', 'h', 'n', 'z', 'x' }, { 'h', 'w', 'o', 'i', 'o' },
				{ 'o', 'r', 'n', 'r', 'n' }, { 'a', 'b', 'r', 'i', 'n' } };

		String word = "horizon";
		boolean result = false;
		result = obj.searchWordInMatrix(matrix, word);
		System.out.println(result);
	}

	public boolean searchWordInMatrix(char[][] matrix, String word) {
		int m = matrix.length;
		int n = matrix[0].length;
		int moves[][] = { { 1, 1 }, { -1, 1 }, { 1, -1 }, { -1, -1 }, { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == word.charAt(0)) {
					if (searchWordInMatrixUtil(matrix, m, n, i, j, word, 1, moves)){
						System.out.print("(i=" + i + ",j=" + j + ") ");
						return true;
					}
					System.out.println();
				}
			}
		}
		return false;
	}

	public boolean searchWordInMatrixUtil(char[][] matrix, int m, int n, int x, int y, String word, int k,
			int[][] moves) {
		if (k == word.length()) {
			return true;
		}
		for (int i = 0; i < moves.length; i++) {
			int _x = x + moves[i][0];
			int _y = y + moves[i][1];
			if (isSafeToMove(matrix, m, n, word, k, _x, _y)) {
				if (searchWordInMatrixUtil(matrix, m, n, _x, _y, word, k + 1, moves)) {
					System.out.print("(i=" + _x + ",j=" + _y + ") ");
					return true;
				}
			}
		}
		return false;
	}

	public boolean isSafeToMove(char[][] matrix, int m, int n, String word, int k, int x, int y) {
		return x >= 0 && x < m && y >= 0 && y < n && word.charAt(k) == matrix[x][y];
	}

}
