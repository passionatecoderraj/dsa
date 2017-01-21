/**
 * 
 */
package com.raj.mathamatical;

import com.raj.nodes.Point;

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
		Point l1 = new Point(0, 10), r1 = new Point(10, 0), l2 = new Point(5, 5), r2 = new Point(15, 0);
		CheckIfTwoRectanglesOverlap obj = new CheckIfTwoRectanglesOverlap();
		boolean result = false;
		result = obj.checkIfRectangelsOverlap(l1, r1, l2, r2);
		System.out.println(result);
	}

	// Time : O(1)
	public boolean checkIfRectangelsOverlap(Point l1, Point r1, Point l2, Point r2) {

		// If one rectangle is on left side of other
		if (l2.x > r1.x || l1.x > r2.x)
			return false;

		// If one rectangle is above other
		if (l2.y < r1.y || l1.y < r2.y)
			return false;
		return true;
	}

}
