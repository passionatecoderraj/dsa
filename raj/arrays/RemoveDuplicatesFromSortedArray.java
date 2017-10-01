/**
 * 
 */
package com.raj.arrays;

import java.util.Arrays;

import com.interview.graph.CommonUtil;

/**
 * @author Raj
 *
 *         Follow up for "Remove Duplicates": What if duplicates are allowed at
 *         most twice?
 * 
 *         For example, Given sorted array nums = [1,1,1,2,2,3],
 * 
 *         Your function should return length = 5, with the first five elements
 *         of nums being 1, 1, 2, 2 and 3. It doesn't matter what you leave
 *         beyond the new length.
 */
public class RemoveDuplicatesFromSortedArray {

	// What if duplicates are allowed at most twice?
	public int removeDuplicates(int[] a) {
		int l = 0;
		for (int n : a) {
			if (l < 2 || n > a[l - 2]) {
				a[l++] = n;
			}
		}

		return l;
	}

	// What if duplicates are allowed at most twice?
	public int removeDuplicates2(int[] a) {
		int l = 2;
		for (int i = 2; i < a.length; i++) {
			if (a[i] == a[l - 1] && a[i] == a[l - 2]) {

			} else {
				a[l++] = a[i];
			}
		}

		return l;
	}

	// duplicates are not allowed at all
	public int removeDuplicates3(int[] a) {
		int left = 0;
		for (int n : a)
			if (left < 1 || n > a[left - 1])
				a[left++] = n;
		return left;
	}

	public static void main(String[] args) {
		RemoveDuplicatesFromSortedArray obj = new RemoveDuplicatesFromSortedArray();
		int a[] = { 1, 1, 1, 2, 2, 3 };
		int uniqueLength = -1;
		uniqueLength = obj.removeDuplicates(a);
		for (int i = 0; i < uniqueLength; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}

}
