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
}
