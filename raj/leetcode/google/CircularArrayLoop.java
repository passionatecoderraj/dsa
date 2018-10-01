package com.raj.leetcode.google;

/**
 * 
 * @author Raj
 *
 * You are given an array of positive and negative integers. If a number n at an index is positive, then move forward n steps. Conversely, if it's negative (-n), move backward n steps. Assume the first element of the array is forward next to the last element, and the last element is backward next to the first element. Determine if there is a loop in this array. A loop starts and ends at a particular index with more than 1 element along the loop. The loop must be "forward" or "backward'.

Example 1: Given the array [2, -1, 1, 2, 2], there is a loop, from index 0 -> 2 -> 3 -> 0.

Example 2: Given the array [-1, 2], there is no loop.

Note: The given array is guaranteed to contain no element "0".

Can you do it in O(n) time complexity and O(1) space complexity?


 */
public class CircularArrayLoop {

	public boolean circularArrayLoop(int[] nums) {
		int n = nums.length;
		for (int i = 0; i < n; i++) {
			if (nums[i] == 0) {
				continue;
			}
			// slow/fast pointer
			int j = i, k = next(i, nums);
			while (nums[k] * nums[i] > 0 && nums[next(k, nums)] * nums[i] > 0) {
				if (j == k) {
					// check for loop with only one element
					if (j == next(j, nums)) {
						break;
					}
					return true;
				}
				j = next(j, nums);
				k = next(next(k, nums), nums);
			}
			// loop not found, set all element along the way to 0
			j = i;
			int val = nums[i];
			while (nums[j] * val > 0) {
				nums[j] = 0;
				j = next(j, nums);
			}
		}
		return false;
	}


	// Time :O(n), Space: O(1)
	public boolean circularArrayLoop2(int[] a) {
		for (int i = 0; i < a.length; i++) {
			int count = 0, slow = i, fast = i;
			boolean forward = a[slow] > 0;
			do {
				if ((forward && a[fast] < 0) || (!forward && a[fast] > 0))
					return false;
				fast = next(fast, a);

				if ((forward && a[fast] < 0) || (!forward && a[fast] > 0))
					return false;

				// save this in temp variable because we can't set directly a[slow] since it
				// affects the next slow and fast values
				int tempSlow = slow;
				slow = next(slow, a);
				fast = next(fast, a);

				a[tempSlow] = 0;
				count++;
			} while (slow != fast);

			if (count > 1)
				return true;
		}
		return false;
	}

	public int next(int i, int[] nums) {
		int n = nums.length;
		return (i + nums[i] + n) % n;
	}

	public static void main(String[] args) {
		CircularArrayLoop obj = new CircularArrayLoop();
		boolean result = false;

		result = obj.circularArrayLoop(new int[] { 2, -1, 1, 2, 2 });
		System.out.println(result);

		result = obj.circularArrayLoop(new int[] { -1, -2, -3, -4, -5 });
		System.out.println(result);

	}

}
