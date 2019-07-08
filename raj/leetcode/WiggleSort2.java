/**
 * 
 */
package com.raj.leetcode;

import java.util.Arrays;
import java.util.Collections;

import com.interview.graph.CommonUtil;
import com.raj.arrays.ReverseArray;

/**
 * @author Raj
 * 
 * Given an unsorted array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....

Example 1:

Input: nums = [1, 5, 1, 1, 6, 4]
Output: One possible answer is [1, 4, 1, 5, 1, 6].
Example 2:

Input: nums = [1, 3, 2, 2, 3, 1]
Output: One possible answer is [2, 3, 1, 3, 1, 2].
Note:
You may assume all input has valid answer.

Follow Up:
Can you do it in O(n) time and/or in-place with O(1) extra space?
 */

public class WiggleSort2 {
	


	/*
	 * https://leetcode.com/problems/wiggle-sort-ii/discuss/77682/Step-by-step-explanation-of-index-mapping-in-Java
	 * 
	 * (1) elements smaller than the 'median' are put into the last even slots

	   (2) elements larger than the 'median' are put into the first odd slots
		
	    (3) the medians are put into the remaining slots.
	    
	    Original idx: 0    1    2    3    4    5  
		Mapped idx:   1    3    5    0    2    4 
		Array:        13   6    5    5    4    2 
		
		How to come up with (2i+1) %(n|1)?
		0 - 1 
		1 - 2
		2 - 3 seems like (2i+1) %n
		
		3 - 0 2i+1% gives 1 instead of 0, so add 1 if n is even. i.e. n+1 -> then (2i+1) % (n+1) -> gives 0
				n+1 when n is even means we can change that to (n|1)  
		4 - 2
		5 - 4
		so, it's (2i+1)%(n|1) 
	 */
	// Time : O(n), Space : O(1)
	public void wiggleSort(int[] a) {
		int n = a.length;
		int first = 0, mid = 0, last = a.length - 1;
		int median = quickSelectFindKthSmallest(a, 0, a.length - 1, (a.length - 1) / 2);
		while (mid <= last) {
			if (a[newIndex(mid, n)] > median) {
				swap(a, newIndex(first++, n), newIndex(mid++, n));
			} else if (a[newIndex(mid, n)] < median) {
				swap(a, newIndex(last--, n), newIndex(mid, n));
			} else {
				mid++;
			}
		}
	}

	/*
	 * n|1 = if n is not odd, make it odd that is greater than n
	 *  larger numbers should be in 1, 3, 5, ... until (floor(n/2)-1)
	 *  smaller number should be 0 2 4 ... n 
	 *  
	 *  j = 2 * (m - 1 - i) if i < m
		j = 2 * (n - 1 - i) + 1 if i >= m
		for descending order, the mapping rule can be combined into one expression:
		j = (2 * i + 1) % (n | 1).
	 */
	private int newIndex(int index, int n) {
		return (1 + 2 * index) % (n | 1);
	}

	
	/*
	 * https://leetcode.com/problems/wiggle-sort-ii/discuss/77682/Step-by-step-explanation-of-index-mapping-in-Java
	 * 
	 * (1) elements smaller than the 'median' are put into the last even slots

	  	(2) elements larger than the 'median' are put into the first odd slots
		
	 	(3) the medians are put into the remaining slots.
	 */
	
	// Time : O(n), Space : O(n)
	public void wiggleSort2(int[] a) {
		int n = a.length, m = (n - 1) >> 1;
		if(n < 2) return;
		int[] copy = Arrays.copyOf(a, n);
		int median = quickSelectFindKthSmallest(a, 0, a.length - 1, m);
		/*
		 * we still need to do color sort - 
		 * 	because after finding kth small though all larger on the left side and smaller on the right side, 
		 * 	there may be values equal to median(since we allow duplicates) far from that value so we need to sort this to consolidate all medians togehter
		 */
		for (int first = 0, mid = 0, last = n - 1; mid <= last;) {
			if (copy[mid] > median) {
				swap(copy, first++, mid++);
			} else if (copy[mid] < median) {
				swap(copy, mid, last--);
			} else {
				mid++;
			}
		}

		for (int i = 0, j = 1; i < n; i++) {
			a[j] = copy[i];
			j = j + 2 < n ? j + 2 : 0;
		}
	}
	
	// Time : O(nlogn), Space : O(n)
	public void wiggleSort3(int[] a) {
		int n = a.length;
		if (n < 2)
			return;
		Arrays.sort(a);
		reverse(a);
		int[] copy = Arrays.copyOf(a, n);
		for (int i = 0, j = 1; i < n; i++) {
			a[j] = copy[i];
			j = j + 2 < n ? j + 2 : 0;
		}
	}

	void reverse(int a[]) {
		int l = 0, r = a.length - 1;
		while (l < r) {
			swap(a, l++, r--);
		}
	}

	void swap(int a[], int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	public static void main(String[] args) {

		WiggleSort2 obj = new WiggleSort2();

		int a[] = { 5, 13, 5, 4, 5, 2, 23 };
		// int a[] = { 1, 5, 1, 1, 6, 4 };
		CommonUtil.printArray(a);
		obj.wiggleSort(a);
		CommonUtil.printArray(a);
	}

	public int quickSelectFindKthSmallest(int a[], int low, int high, int k) {
		if (low <= high) {
			int pivot = partition(a, low, high);
			if (pivot - low == k) {
				return a[pivot];
			} else if (k > pivot - low) {
				// right sub array
				// position of k is changed ,it's k - length of left side -
				// 1(pivot)
				return quickSelectFindKthSmallest(a, pivot + 1, high, k - (pivot - low) - 1);
			} else {
				// lest sub array
				return quickSelectFindKthSmallest(a, low, pivot - 1, k);
			}
		}
		return -1;
	}

	public int partition(int a[], int p, int r) {
		int key = a[r], j = p;
		for (int i = p; i < r; i++) {
			if (a[i] >= key) {
				swap(a, i, j);
				j++;
			}
		}
		swap(a, r, j);
		return j;
	}
}
