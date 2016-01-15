package com.raj.arrays;

import com.interivew.graph.CommonUtil;

/*
 * @Author Raj
 * 
 * Given an array of integers, replace every element with the next greatest element 
 * (greatest element on the right side) in the array. Since there is no element next to the last element, replace it with -1
 * 
 * . For example, if the array is {16, 17, 4, 3, 5, 2}, then it should be modified to {17, 5, 5, 5, 2, -1}.
 */

public class ReplaceWithMaxOnRight {

	public static void main(String[] args) {
		int a[] = { 16, 17, 4, 3, 5, 2 };
		int n = a.length;
		ReplaceWithMaxOnRight obj = new ReplaceWithMaxOnRight();

		// Time : O(n), Space: O(1) ; traverse from reverse
		obj.replaceWithMaxOnRight(a, n);
		CommonUtil.printArray(a);

	}

	public void replaceWithMaxOnRight(int[] a, int n) {
		if (n <= 0)
			return;
		int maxFromRight = a[n - 1];
		a[n - 1] = -1;
		int temp;
		for (int i = n - 2; i >= 0; i--) {
			temp = maxFromRight;
			maxFromRight = Math.max(a[i], maxFromRight);
			a[i] = temp;
		}
	}

	public void leadersInArrayBruteForce(int[] a, int n) {
		boolean isNotLeader;
		for (int i = 0; i < n; i++) {
			isNotLeader = false;
			for (int j = n - 1; j > i && !isNotLeader; j--) {
				if (a[i] > a[j]) {

				} else {
					isNotLeader = true;
				}
			}
			if (!isNotLeader) {
				System.out.print(a[i] + " ");
			}
		}
		System.out.println();
	}

}
