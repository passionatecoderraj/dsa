package com.raj.backtracking;

import com.interview.graph.CommonUtil;

/**
 * 
 * @author Raj
 *
 *         Implement next permutation, which rearranges numbers into the
 *         lexicographically next greater permutation of numbers.
 * 
 *         If such arrangement is not possible, it must rearrange it as the
 *         lowest possible order (ie, sorted in ascending order).
 * 
 *         The replacement must be in-place, do not allocate extra memory.
 * 
 *         Here are some examples. Inputs are in the left-hand column and its
 *         corresponding outputs are in the right-hand column. 1,2,3 → 1,3,2
 * 
 *         3,2,1 → 1,2,3
 * 
 *         1,1,5 → 1,5,1
 * 
 *         https://leetcode.com/articles/next-permutation/
 */
public class NextPermutation {

	/*
	 * My idea is for an array:
	 * 
	 * 
	 * Start from its last element, traverse backward to find the first one with
	 * index i that satisfy num[i-1] < num[i]. So, elements from num[i] to
	 * num[n-1] is reversely sorted.
	 * 
	 * 
	 * To find the next permutation, we have to swap some numbers at different
	 * positions, to minimize the increased amount, we have to make the highest
	 * changed position as high as possible. Notice that index larger than or
	 * equal to i is not possible as num[i,n-1] is reversely sorted. So, we want
	 * to increase the number at index i-1, clearly, swap it with the smallest
	 * number between num[i,n-1] that is larger than num[i-1]. For example,
	 * original number is 121543321, we want to swap the '1' at position 2 with
	 * '2' at position 7.
	 * 
	 * 
	 * The last step is to make the remaining higher position part as small as
	 * possible, we just have to reversely sort the num[i,n-1]
	 *
	 * https://discuss.leetcode.com/topic/2542/share-my-o-n-time-solution
	 */
	public void nextPermutation(int[] a) {

		int i = a.length - 2;
		while (i >= 0 && a[i] >= a[i + 1]) {
			i--;
		}
		if (i >= 0) {
			int j = i + 1;
			while (j < a.length && a[j] > a[i]) {
				j++;
			}
			CommonUtil.swap(a, i, j - 1);
		}
		reverse(a, i + 1, a.length - 1);
	}

	public void nextPermutationWithExplanation(int[] a) {

		int i = a.length - 2;

		// find first decreasing from right
		while (i >= 0 && a[i] >= a[i + 1]) {
			i--;
		}
		if (i >= 0) {
			// find next highest right to firstDecreasing

			// from i+1 to n values are decreasing order
			// need to find least element that is greater than 'i'

			int leastHighestGreaterThani = i + 1;
			int j = i + 1;
			while (j < a.length && a[j] > a[i]) {
				leastHighestGreaterThani = j;
				j++;
			}

			// CommonUtil.swap(a, i, j-1); -> this is also right answer
			CommonUtil.swap(a, i, leastHighestGreaterThani);
		}
		reverse(a, i + 1, a.length - 1);
	}

	private void reverse(int[] a, int l, int r) {
		while (l < r) {
			CommonUtil.swap(a, l++, r--);
		}

	}

	public static void main(String args[]) {
		NextPermutation obj = new NextPermutation();
		int a[] = { 1, 5, 8, 4, 7, 6, 5, 3, 1 };
		obj.nextPermutation(a);
		CommonUtil.printArray(a);

		int a2[] = { 1, 2 };
		obj.nextPermutation(a2);
		CommonUtil.printArray(a2);
	}
}