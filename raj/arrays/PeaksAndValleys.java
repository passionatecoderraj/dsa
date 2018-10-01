/**
 * 
 */
package com.raj.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Raj
 *
 */
public class PeaksAndValleys {

	// Time :O(logn), Space : O(1)
	public List<Integer> findPeaksAndValleys(int a[]) {
		List<Integer> res = new ArrayList<>();
		peaksAndValleysUtil(a, 0, a.length - 1, res);
		return res;
	}

	void peaksAndValleysUtil(int a[], int l, int r, List<Integer> res) {
		if (r - l < 2)
			return;
		int m = (l + r) >> 1;

		// System.out.println("l=" + l + ",r=" + r + ",m=" + m);

		if (Math.abs(a[m] - a[l]) != m - l) {
			peaksAndValleysUtil(a, l, m, res);
		}

		if (Math.abs(a[r] - a[m]) != r - m) {
			peaksAndValleysUtil(a, m, r, res);
		}
		if (a[m - 1] == a[m + 1])
			res.add(a[m]);
	}

	// Time :O(n), Space : O(1)
	public List<Integer> findPeaksAndValleys_bruteforce2(int a[]) {
		List<Integer> res = new ArrayList<>();
		for (int i = 1; i < a.length - 1; i++) {
			if (a[i - 1] == a[i + 1]) {
				res.add(a[i]);
			}
		}
		return res;
	}

	// Time :O(n), Space : O(1)
	public List<Integer> findPeaksAndValleys_bruteforce(int a[]) {
		List<Integer> res = new ArrayList<>();
		for (int i = 2; i < a.length; i++) {
			if (a[i] < a[i - 1] && a[i - 1] > a[i - 2]) {
				res.add(a[i - 1]);
			} else if (a[i] > a[i - 1] && a[i - 1] < a[i - 2]) {
				res.add(a[i - 1]);
			}
		}
		return res;
	}

	public static void main(String[] args) {
		PeaksAndValleys obj = new PeaksAndValleys();
		int a[] = { 3, 4, 5, 6, 5, 4, 5, 4, 3, 4, 5 };
		List<Integer> result = null;

		result = obj.findPeaksAndValleys_bruteforce(a);
		System.out.println(result);

		// Time :O(logn), Space : O(1)
		result = obj.findPeaksAndValleys_bruteforce2(a);
		System.out.println(result);

		// Time :O(logn), Space : O(1)
		result = obj.findPeaksAndValleys(a);
		System.out.println(result);

	}

}
