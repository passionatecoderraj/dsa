package com.raj.dp;

import com.interivew.graph.CommonUtil;

/**
 * House Robber http://www.programcreek.com/2014/03/leetcode-house-robber-java/
 * 
 * @author Raj
 *
 */
public class HouseRobberWithHousesInLine {

	// Time :O(n) Space :O(1)
	public int maxSumForNonAdjascentPositiveNumbers(int[] a) {
		int n = a.length;
		if (n <= 0)
			return -1;
		int incl = a[0];
		int excl = 0, temp;
		for (int i = 1; i < n; i++) {
			temp = incl;
			incl = Math.max(excl + a[i], incl);
			excl = temp;
			// System.out.println("incl=" + incl + ",excl=" + excl);
		}
		return incl;
	}

	// Time :O(n) Space :O(n)
	public int houseRobberWithMaxAmount(int[] a) {
		if (null == a || a.length == 0)
			return 0;
		int n = a.length;

		if (1 == n)
			return a[0];
		if (2 == n)
			return Math.max(a[0], a[1]);

		int t[] = new int[n + 1];
		t[0] = 0;
		t[1] = a[0];

		for (int i = 2; i <= n; i++) {
			t[i] = Math.max(t[i - 1], t[i - 2] + a[i - 1]);
		}
		CommonUtil.printArray(t);
		return t[n];
	}

	public static void main(String[] args) {
		// int a[] = { 2, 1, 2, 3, 1 };
		// int a[] = { 5, 5, 10, 40, 50, 35 };
		int a[] = { 2, 10, 13, 4, 2, 15, 10 };

		HouseRobberWithHousesInLine obj = new HouseRobberWithHousesInLine();
		int result = -1;
		// Time : O(n), Space : O(1)
		result = obj.maxSumForNonAdjascentPositiveNumbers(a);
		System.out.println(result);

		result = obj.houseRobberWithMaxAmount(a);
		System.out.println(result);

	}

}
