/**
 * 
 */
package com.raj.mathamatical;

import com.interivew.graph.CommonUtil;

/**
 * @author Raj
 *
 *         Given a sorted array of integers nums and integer values a, b and c.
 *         Apply a function of the form f(x) = ax2 +bx + c to each element x in
 *         the array. The returned array must be in sorted order. Expected time
 *         complexity: O(n)
 * 
 *         Example: nums = [-4, -2, 2, 4], a = 1, b = 3, c = 5,
 * 
 *         Result: [3, 9, 15, 33]
 * 
 *         nums = [-4, -2, 2, 4], a = -1, b = 3, c = 5
 * 
 *         Result: [-23, -5, 1, 7]
 * 
 *         https://discuss.leetcode.com/topic/50497/my-easy-to-understand-java-
 *         ac-solution-using-two-pointers
 */
public class SortTransformedArray {

	/*
	 * For a parabola,
	 * 
	 * if a >= 0, the min value is at its vertex. So our our sorting should goes
	 * from two end points towards the vertex, high to low.
	 * 
	 * if a < 0, the max value is at its vertex. So our sort goes the opposite
	 * way.
	 * 
	 * 1.a>0, two ends in original array are bigger than center if you learned
	 * middle school math before. 2.a<0, center is bigger than two ends.
	 */
	// Time :O(n)
	public static int[] sortTransformedArray(int[] arr, int a, int b, int c) {
		int left = 0, right = arr.length - 1;
		int res[] = new int[arr.length];
		int i = a >= 0 ? arr.length - 1 : 0;
		while (left <= right) {
			int leftNum = getNum(arr[left], a, b, c);
			int rightNum = getNum(arr[right], a, b, c);
			if (a >= 0) {
				if (leftNum >= rightNum) {
					res[i--] = leftNum;
					left++;
				} else {
					res[i--] = rightNum;
					right--;
				}
			} else {
				if (leftNum <= rightNum) {
					res[i++] = leftNum;
					left++;
				} else {
					res[i++] = rightNum;
					right--;
				}
			}
		}
		return res;
	}

	private static int getNum(int x, int a, int b, int c) {
		return (a * x * x) + (b * x) + c;
	}

	public static void main(String[] args) {
		int arr[] = { -4, -2, 2, 4 };
		int r[] = sortTransformedArray(arr, 1, 3, 5);
		CommonUtil.printArray(r);

		int r2[] = sortTransformedArray(arr, -1, 3, 5);
		CommonUtil.printArray(r2);
	}

}
