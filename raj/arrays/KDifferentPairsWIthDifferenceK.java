/**
 *
 */
package com.raj.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @author Raj
 *
 *         //@formatter:off
 * 
 *         Given an array of integers and an integer k, you need to find the
 *         number of unique k-diff pairs in the array. Here a k-diff pair is
 *         defined as an integer pair (i, j), where i and j are both numbers in
 *         the array and their absolute difference is k.
 *
 *         Example 1: Input: [3, 1, 4, 1, 5], k = 2 Output: 2
 *
 *         Explanation: There are two 2-diff pairs in the array, (1, 3) and (3,
 *         5). Although we have two 1s in the input, we should only return the
 *         number of unique pairs.
 *
 *
 *         Example 2: Input:[1, 2, 3, 4, 5], k = 1 Output: 4
 *
 *         Explanation: There are four 1-diff pairs in the array, (1, 2), (2,
 *         3), (3, 4) and (4, 5).
 *
 *         Example 3: Input: [1, 3, 1, 5, 4], k = 0 Output: 1
 *
 *         Explanation: There is one 0-diff pair in the array, (1, 1).
 *
 *
 *         //@formatter:on
 */
public class KDifferentPairsWIthDifferenceK {

	// Time : O(n), Space : O(n)
	public int findPairs(int[] a, int k) {
		int count = 0;
		Map<Integer, Integer> map = new HashMap<>();
		for (int i : a) {
			map.compute(i, (key, val) -> {
				if (null == val) {
					val = 0;
				}
				return 1 + val;
			});
		}

		for (Entry<Integer, Integer> e : map.entrySet()) {
			if (k == 0) {
				if (e.getValue() >= 2) {
					count++;
				}
			} else {
				if (map.containsKey(e.getKey() + k)) {
					count++;
				}
			}
		}
		return count;
	}

	// Time : O(nlogn), Space : O(1)
	public int findPairsWithSorting(int[] a, int k) {
		int count = 0;
		if (null == a || a.length < 2) {
			return count;
		}
		Arrays.sort(a);
		for (int i = 0; i < a.length; i++) {
			if (i > 0 && a[i] == a[i - 1]) {
				continue;
			}
			if (binarySearch(a, i + 1, a[i] + k)) {
				count++;
			}
		}
		return count;
	}

	private boolean binarySearch(int[] a, int l, int key) {
		int r = a.length - 1;
		while (l <= r) {
			int mid = l + (r - l) / 2;
			if (a[mid] == key) {
				return true;
			}
			if (a[mid] < key) {
				l = mid + 1;
			} else {
				r = mid - 1;
			}
		}
		return false;
	}

	// Time : O(nlogn), Space : O(1)
	public int findPairsWithSorting2(int[] a, int k) {
		int count = 0;
		Arrays.sort(a);
		int l = 0, r = 1;
		while (l < a.length && r < a.length) {
			if (l == r) {
				r++;
				continue;
			}
			int d = a[r] - a[l];
			if (d > k) {
				l++;
			} else if (d < k) {
				r++;
			} else {
				int val = a[l];
				count++;
				l++;
				while (l < a.length && a[l] == val) {
					l++;
				}
				r = Math.max(l + 1, r + 1);
			}
		}
		return count;
	}

	// Time : O(nlogn), Space : O(1)
	public int findPairsWithSorting3(int[] a, int k) {
		int count = 0;
		if (null == a || a.length < 2) {
			return count;
		}
		Arrays.sort(a);
		int l = 0, r = 1;
		while (r < a.length) {
			int d = a[r] - a[l];
			if (d < k) {
				r++;
			} else if (d > k) {
				if (l + 1 == r) {
					l++;
					r++;
				} else {
					l++;
				}
			} else {
				System.out.println(a[l] + "," + a[r]);
				int i = a[l], j = a[r];
				l++;
				r++;
				while (r < a.length && a[r] == j) {
					r++;
				}
				while (l < r - 1 && a[l] == i) {
					l++;
				}
				count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		KDifferentPairsWIthDifferenceK obj = new KDifferentPairsWIthDifferenceK();
		int a[] = { 3, 1, 4, 1, 5 };
		int result = -1;
		result = obj.findPairsWithSorting3(a, 2);
		System.out.println(result);
		int b[] = { 1, 2, 3, 4, 5 };
		result = obj.findPairsWithSorting3(b, 1);
		System.out.println(result);
		int c[] = { 1, 3, 1, 5, 4 };
		result = obj.findPairsWithSorting3(c, 0);
		System.out.println(result);
	}

}
