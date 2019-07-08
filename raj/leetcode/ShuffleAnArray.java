/**
 * 
 */
package com.raj.leetcode;

import java.util.Arrays;
import java.util.Random;

/**
 * @author Raj
 * 
 * Shuffle a set of numbers without duplicates.

Example:

// Init an array with set 1, 2, and 3.
int[] nums = {1,2,3};
Solution solution = new Solution(nums);

// Shuffle the array [1,2,3] and return its result. Any permutation of [1,2,3] must equally likely to be returned.
solution.shuffle();

// Resets the array back to its original configuration [1,2,3].
solution.reset();

// Returns the random shuffling of array [1,2,3].
solution.shuffle();

 *
 */

class Shuffle {
	private int[] nums;
	private Random random;

	public Shuffle(int[] nums) {
		this.nums = nums;
		random = new Random();
	}

	/** Resets the array to its original configuration and return it. */
	public int[] reset() {
		return nums;
	}

	/** Returns a random shuffling of the array. */
	public int[] shuffle() {
		if (nums == null)
			return null;
		int[] a = nums.clone();
		for (int j = a.length - 1; j > 0; j--) {
			int i = random.nextInt(j + 1);
			swap(a, i, j);
		}
		return a;
	}

	private void swap(int[] a, int i, int j) {
		int t = a[i];
		a[i] = a[j];
		a[j] = t;
	}
}

public class ShuffleAnArray {

	public static void main(String[] args) {
		int a[] = { 1, 2, 3 };
		Shuffle obj = new Shuffle(a);
		System.out.println(Arrays.toString(obj.shuffle()));
		System.out.println(Arrays.toString(obj.reset()));
		System.out.println(Arrays.toString(obj.shuffle()));
	}
}
