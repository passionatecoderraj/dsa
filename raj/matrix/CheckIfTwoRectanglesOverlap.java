/**
 * 
 */
package com.raj.matrix;

/**
 * @author Raj
 *
 */

// http://www.geeksforgeeks.org/find-two-rectangles-overlap/
public class CheckIfTwoRectanglesOverlap {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Cell l1 = new Cell(0, 10), r1 = new Cell(10, 0), l2 = new Cell(5, 5), r2 = new Cell(15, 0);
		CheckIfTwoRectanglesOverlap obj = new CheckIfTwoRectanglesOverlap();
		boolean result = false;
		result = obj.checkIfRectangelsOverlap(l1, r1, l2, r2);
		System.out.println(result);
	}

	// Time : O(1)
	public boolean checkIfRectangelsOverlap(Cell l1, Cell r1, Cell l2, Cell r2) {
		if (l2.i > r1.i || l1.i > r2.i)
			return false;

		if (l2.j < r1.j || l1.j < r2.j)
			return false;
		return true;
	}

}
