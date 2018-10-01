package com.raj.leetcode.google;

/**
 * 
 * @author Raj
 * 
 * Given a 2D matrix matrix, find the sum of the elements inside the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2).

Range Sum Query 2D
The above rectangle (with the red border) is defined by (row1, col1) = (2, 1) and (row2, col2) = (4, 3), which contains sum = 8.

Example:
Given matrix = [
  [3, 0, 1, 4, 2],
  [5, 6, 3, 2, 1],
  [1, 2, 0, 1, 5],
  [4, 1, 0, 1, 7],
  [1, 0, 3, 0, 5]
]

sumRegion(2, 1, 4, 3) -> 8
update(3, 2, 2)
sumRegion(2, 1, 4, 3) -> 10
 */

// https://leetcode.com/problems/range-sum-query-2d-mutable/discuss/75870/Java-2D-Binary-Indexed-Tree-Solution-clean-and-short-17ms
class RangeSumQuery2DMutableGeneral{
	int binaryIndexTree[][];
	int[][] nums;

	public RangeSumQuery2DMutableGeneral(int[][] matrix) {
		binaryIndexTree = new int[matrix.length + 1][matrix[0].length + 1];
		nums = new int[matrix.length][matrix[0].length];

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				update(i, j, matrix[i][j]);
			}
		}
	}

	public void update(int row, int col, int val) {
		int delta = val - nums[row][col];
		nums[row][col] = val;

		for (int i = row + 1; i < binaryIndexTree.length; i = getNext(i)) {
			for (int j = col + 1; j < binaryIndexTree[0].length; j = getNext(j)) {
				binaryIndexTree[i][j] += delta;
			}
		}
	}

	public int sumRegion(int row1, int col1, int row2, int col2) {
		return getSum(row2 + 1, col2 + 1) + getSum(row1, col1) - getSum(row1, col2 + 1) - getSum(row2 + 1, col1);
	}

	private int getSum(int row, int col) {
		int sum = 0;
		for (int i = row; i > 0; i = getParent(i)) {
			for (int j = col; j > 0; j = getParent(j)) {
				sum += binaryIndexTree[i][j];
			}
		}
		return sum;
	}

	/**
	 * To get parent 1) 2's complement to get minus of index 2) AND this with index
	 * 3) Subtract that from index
	 */
	private int getParent(int index) {
		return index - (index & -index);
	}

	/**
	 * To get next 1) 2's complement of get minus of index 2) AND this with index 3)
	 * Add it to index
	 */
	private int getNext(int index) {
		return index + (index & -index);
	}
}
public class RangeSumQuery2DMutable {
	

	public static void main(String[] args) {

		int a[][] = { { 3, 0, 1, 4, 2 }, { 5, 6, 3, 2, 1 }, { 1, 2, 0, 1, 5 }, { 4, 1, 0, 1, 7 }, { 1, 0, 3, 0, 5 } };
		RangeSumQuery2DMutableGeneral obj = new RangeSumQuery2DMutableGeneral(a);
		// for (int[] r : obj.binaryIndexTree)
		// System.out.println(Arrays.toString(r));
		int res = Integer.MIN_VALUE;
		res = obj.sumRegion(2, 1, 4, 3);
		System.out.println(res);
		res = obj.sumRegion(1, 1, 2, 2);
		System.out.println(res);
		res = obj.sumRegion(1, 2, 2, 4);
		System.out.println(res);

	}

}


