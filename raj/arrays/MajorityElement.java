/**
 * 
 */
package com.raj.arrays;

import java.util.Arrays;

import com.interivew.graph.CommonUtil;

/**
 * @author Raj
 *
 */
public class MajorityElement {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MajorityElement obj = new MajorityElement();
		int result = -1;
		int a[] = { 3, 3, 4, 2, 4, 4, 2, 4, 4 };

		// Time :O(n2), Space : O(1)
		result = obj.findMajorityElementInBruteForceON2(a, a.length);
		System.out.println(result);
		// Time :O(nlogn), Space : O(1)
		result = obj.findMajorityElementUsingSortinONlogN(a, a.length);
		System.out.println(result);
		// Using Moore's Voting Time :O(n), Space : O(1)
		result = obj.findMajorityElementUsingMooresVotingON(a, a.length);
		System.out.println(result);

	}

	public int findMajorityElementUsingMooresVotingON(int[] a, int n) {
		int majority = Integer.MIN_VALUE;
		int count = 0, candidate = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			if (0 == count) {
				count = 1;
				candidate = a[i];
			} else {
				if (candidate == a[i]) {
					count++;
				} else {
					count--;
				}
			}
		}

		// step 2 of Moore's algorithms : finding count of candidate
		count = 0;
		for (int i = 0; i < n; i++) {
			if (a[i] == candidate)
				count++;
		}
		if (count > n / 2)
			majority = candidate;

		return majority;
	}

	public int findMajorityElementUsingSortinONlogN(int[] a, int n) {
		int majority = Integer.MIN_VALUE;
		Arrays.sort(a);

		int count = 1, maxCount = Integer.MIN_VALUE;

		for (int i = 1; i < n; i++) {
			if (a[i] == a[i - 1]) {
				count++;
				if (i == n - 1) {
					if (count > maxCount) {
						maxCount = count;
						if (maxCount > n / 2) {
							majority = a[i];
							break;

						}
					}
				}
			} else {
				if (count > maxCount) {
					maxCount = count;

					if (maxCount > n / 2) {
						majority = a[i];
						break;
					}
				}
				count = 1;
			}
		}
		return majority;
	}

	public int findMajorityElementInBruteForceON2(int[] a, int n) {
		int majority = Integer.MIN_VALUE, count;
		for (int i = 0; i < n; i++) {
			count = 0;
			for (int j = 0; j < n; j++) {
				if (a[i] == a[j]) {
					count++;
				}
			}
			if (count > n / 2) {
				majority = a[i];
				break;
			}
		}
		return majority;
	}

}
