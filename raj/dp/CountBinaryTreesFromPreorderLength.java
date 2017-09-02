package com.raj.dp;

import com.interview.graph.CommonUtil;

public class CountBinaryTreesFromPreorderLength {

	public static void main(String[] args) {
		CountBinaryTreesFromPreorderLength obj = new CountBinaryTreesFromPreorderLength();
		int result = -1;
		int n = 5;
		result = obj.countBinaryTreesFromPreorderLength(n);
		System.out.println(result);
	}

	// it's catalan number
	// it means when we need for 'n' then calculate all possible sums for 'n-1'
	// and multiply them
	// for example, n=4 then for n=3 possible sums are{(3,0),(2,1),(1,2),(0,3)}
	// result = t[3]*t[0] + t[2]*t[1] + t[1]*t[2] + t[0]*t[3]
	public int countBinaryTreesFromPreorderLength(int n) {
		if (n < 0)
			return -1;
		int t[] = new int[n + 1];
		t[0] = 1;
		t[1] = 1;

		for (int i = 2; i < n + 1; i++) {
			int val = 0;
			for (int j = 0; j < i; j++) {
				val += (t[j] * t[i - j - 1]);
			}
			t[i] = val;
		}
		CommonUtil.printArray(t);
		return t[n];
	}

}
