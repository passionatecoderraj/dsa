/**
 * 
 */
package com.raj.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Raj
 * 
 *Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note: The solution set must not contain duplicate triplets.

For example, given array S = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]
 */
public class FindThreeSumtoK {

	// Time : O(n2)
	public List<List<Integer>> threeSum(int[] a) {
		List<List<Integer>> result = new ArrayList<>();
		if (a.length < 3) {
			return result;
		}
		Arrays.sort(a);
		for (int i = 0; i < a.length - 2; i++) {
			if (i > 0 && a[i] == a[i - 1])
				continue;
			int l = i + 1;
			int r = a.length - 1;
			while (l < r) {
				int sum = a[i] + a[l] + a[r];
				if (sum > 0) {
					r--;
				} else if (sum < 0) {
					l++;
				} else {
					List<Integer> list = new ArrayList<>();
					list.add(a[i]);
					list.add(a[l]);
					list.add(a[r]);
					result.add(list);
					while (l < r && a[l] == a[l + 1])
						l++;
					while (l < r && a[r] == a[r - 1])
						r--;
					l++;
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		FindThreeSumtoK obj = new FindThreeSumtoK();
		int a[] = { 1, 4, 12, 6, 10, 8 };
		int n = a.length, k = 22;
		// Time : O(n2)
		obj.findTriplet(a, n, k);
		List<List<Integer>> res = null;
		res = obj.threeSum(new int[] { -1, 0, 1, 2, -1, -4 });
		System.out.println(res);

		res = obj.threeSum(new int[] { 0, 0, 0, 0 });
		System.out.println(res);

	}

	public void findTriplet(int[] a, int n, int k) {
		if (n < 3) {
			return;
		}
		Arrays.sort(a);
		int l, r, sum = 0;
		for (int i = 0; i < n - 2; i++) {
			l = i + 1;
			r = n - 1;
			while (l < r) {
				sum = a[i] + a[l] + a[r];
				if (sum == k) {
					System.out.println("1st=" + a[i] + ",2nd=" + a[l] + ",3rd=" + a[r] + " :: Sum=" + sum);
					l++;
					r--;
				} else if (sum > k) {
					r--;
				} else {
					l++;
				}
			}
		}
	}

}
