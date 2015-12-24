package com.raj.dp;

import com.interivew.graph.CommonUtil;

public class CountBinarySearchTreesGivenNumberOfKeys {

	public static void main(String[] args) {
		CountBinarySearchTreesGivenNumberOfKeys obj = new CountBinarySearchTreesGivenNumberOfKeys();
		int result = -1;
		int n = 7;
		result = obj.countBinarySearchTreesGivenNumberOfKeys(n);
		System.out.println(result);
	}

	public int countBinarySearchTreesGivenNumberOfKeys(int n) {
		if (n < 0)
			return -1;
		int t[] = new int[n + 1];
		t[0] = 1;
		t[1] = 1;

		for (int i = 2; i < n + 1; i++) {
			for (int j = 0; j < i; j++) {
				t[i] += (t[j] * t[i - j - 1]);
			}
		}
		CommonUtil.printArray(t);
		return t[n];
	}

}
