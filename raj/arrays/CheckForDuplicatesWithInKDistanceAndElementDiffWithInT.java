/**
 * 
 */
package com.raj.arrays;

import java.util.TreeSet;

/**
 * @author Raj
 * 
 */

/*
 * This problem we are not actually finding duplicates.
 * 
 * Rather finding numbers with max difference of t and with in the distance of k
 * 
 * Contains Duplicate in java
 * 
 * difference between nums[i] and nums[j] is at most t and the difference
 * between i and j is at most k
 *
 */

/*
 * http://blog.welkinlan.com/2015/09/11/contains-duplicate-i-ii-iii-leetcode-
 * java/
 */
public class CheckForDuplicatesWithInKDistanceAndElementDiffWithInT {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CheckForDuplicatesWithInKDistanceAndElementDiffWithInT obj = new CheckForDuplicatesWithInKDistanceAndElementDiffWithInT();
		int a[] = { 3, 6, 0, 4 };
		int k = 2, t = 2, n = a.length;
		boolean result = false;
		// Time : O(n*log(k)) , Space : O(k)
		result = obj.checkForDuplicatesWithInKDistanceAndElementDiffWithInT(a, n, k, t);
		System.out.println(result);

	}

	// Time : O(n*log(k)) , Space : O(k)
	public boolean checkForDuplicatesWithInKDistanceAndElementDiffWithInT(int[] a, int n, int k, int t) {
		TreeSet<Integer> treeSet = new TreeSet<Integer>();
		int val;
		for (int i = 0; i < n; i++) {
			val = a[i];
			Integer floor = treeSet.floor(val);
			Integer ceil = treeSet.ceiling(val);
			if ((floor != null && val - floor <= t) || (ceil != null && ceil - val <= t)) {
				return true;
			}
			treeSet.add(val);
			if (i >= k)
				treeSet.remove(a[i - k]);
		}

		return false;
	}

}
