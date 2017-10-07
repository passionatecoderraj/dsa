/**
 * 
 */
package com.raj.dp;

/**
 * @author Raj
 * Given an array which consists of non-negative integers and an integer m, you can split the array into m non-empty continuous subarrays. Write an algorithm to minimize the largest sum among these m subarrays.

Note:
If n is the length of array, assume the following constraints are satisfied:

1 ≤ n ≤ 1000
1 ≤ m ≤ min(50, n)
Examples:

Input:
nums = [7,2,5,10,8]
m = 2

Output:
18

Explanation:
There are four ways to split nums into two subarrays.
The best way is to split it into [7,2,5] and [10,8],
where the largest sum among the two subarrays is only 18.
 */
public class SplitArrayLargestSum {

	/*
	 * [7, 2, 5, 10, 8] m = 2
	 * 
	 * left = 10, right = 32, mid = 21 => [7, 2, 5], [10, 8]
	 * 
	 * left = 10, right = 21, mid = 15 => [7, 2], [10, 5],[8]
	 * 
	 * left = 16, right = 21, mid = 18 => [7, 2], [10, 8]
	 * 
	 * left = 16, right = 18, mid = 17 => [7, 2], [10, 5],[8]
	 * 
	 * left = 18, right = 18 => return 18
	 */
	
	public int splitArray(int[] a, int m) {
		int sum = 0, max = Integer.MIN_VALUE;
		for (int i : a) {
			sum += i;
			max = Math.max(i, max);
		}
		long l = max, r = sum;
		if (m <= 1)
			return sum;
		else if (m >= a.length) {
			return max;
		}
		// binary search
		while (l < r) {
		//	while (l <= r) {
						long mid = (l + r) / 2;
			System.out.println("l=" + l + ",r=" + r+",mid="+mid);
			if (valid(a, mid, m)) {
				r = mid ;
			//	r = mid-1 ;
			} else {
				l = mid + 1;
			}
		}
		return (int) l;
	}

	private boolean valid(int[] a, long target, int m) {
		// count is defaulted to '1' because atleast 1 partition is possible with array
		long sum = 0, count = 1;
		for (int num : a) {
			sum += num;
			if (sum > target) {
				sum = num;
				count++;
				if (count > m) {
					return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		SplitArrayLargestSum obj = new SplitArrayLargestSum();
		int a[] = { 7, 2, 5, 10, 8 };
		int result = -1;
		result = obj.splitArray(a, 2);
		System.out.println(result);

	}

}
