package com.raj.leetcode;


/**
 * @author Raj
 *
 */
// Valid Sudoku (Java)
/*
 * Determine if a Sudoku is valid. The Sudoku board could be partially filled,
 * where empty cells are filled with the character '0'.
 */
public class IsValidSudoku {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		IsValidSudoku obj = new IsValidSudoku();
		int[][] a = new int[][] {
			{ 5, 3, 0, 0, 7, 0, 0, 0, 0 },
			{ 6, 0, 0, 1, 9, 5, 0, 0, 0 },
			{ 0, 9, 8, 0, 0, 0, 0, 6, 0 }, 
			{ 8, 0, 0, 0, 6, 0, 0, 0, 3 }, 
			{ 4, 0, 0, 8, 0, 3, 0, 0, 1 },
			{ 7, 0, 0, 0, 2, 0, 0, 0, 6 }, 
			{ 0, 6, 0, 0, 0, 0, 2, 8, 0 },
			{ 0, 0, 0, 4, 1, 9, 0, 0, 5 },
			{ 0, 0, 0, 0, 8, 0, 0, 7, 9 } };

		boolean result = false;
		result = obj.isValidSudoku(a);
		System.out.println(result);

	}

	public boolean isValidSudoku(int[][] sudoku) {

		boolean a[];
		// valid rows
		for (int i = 0; i < sudoku.length; i++) {
			a = new boolean[sudoku.length];
			for (int j = 0; j < sudoku[i].length; j++) {
				int index = sudoku[i][j];
				if (index == 0) {
					continue;
				} else {
					if (a[index - 1]) {
						System.out.println("INVALID ROW : i="+i+",j="+j);
						return false;
					}
					a[index - 1] = true;
				}
			}
		}
		
		// valid rows
		for (int j = 0; j < sudoku[0].length; j++) {
			a = new boolean[sudoku[0].length];
			for (int i = 0; i < sudoku.length; i++) {
				int index = sudoku[i][j];
				if (index == 0) {
					continue;
				} else {
					if (a[index - 1]) {
						System.out.println("INVALID COLUMN : i="+i+",j="+j);
						return false;
					}
					a[index - 1] = true;
				}
			}
		}

		// valid block
		for (int i = 0; i <= sudoku.length-3; i+=3) {
			for (int j = 0; j <= sudoku[i].length-3; j+=3) {
				if(!isValidBlock(sudoku,i,j))
					return false;
			}
		}
		
		
		return true;
	}

	public boolean isValidBlock(int[][] sudoku, int x, int y) {
		boolean a[] = new boolean [9];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				int index = sudoku[x+i][y+j];
				if (index == 0) {
					continue;
				} else {
					if (a[index - 1]) {
						System.out.println("INVALID BLOCK: i="+i+",j="+j);
						return false;
					}
					a[index - 1] = true;
				}
			}
		}
		return true;
	}

	
}
