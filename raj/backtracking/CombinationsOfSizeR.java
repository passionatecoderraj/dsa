package com.raj.backtracking;

import com.interview.graph.CommonUtil;

/*
 * @Author Raj
 * 
 * 
 */

public class CombinationsOfSizeR {

	public static void main(String[] args) {
		int a[] = { 1, 2, 3, 4 };
		int n = a.length, r = 2;
		CombinationsOfSizeR obj = new CombinationsOfSizeR();
		// obj.combinationsOfSizeR(a, n, r);
		char t[] = new char[3];
		obj.combinationsOfSizeK("raaj".toCharArray(), 0, 3, t, 0);
	}

	public void combinationsOfSizeR(int[] a, int n, int r) {
		int t[] = new int[r];
		combinationsOfSizeRUtil(a, 0, n, t, 0, r);
	}

	public void combinationsOfSizeRUtil(int[] a, int start, int n, int[] t, int index, int r) {
		if (index == r) {
			CommonUtil.printArray(t);
			return;
		}
		for (int i = start; i < n; i++) {
			t[index] = a[i];
			combinationsOfSizeRUtil(a, i + 1, n, t, index + 1, r);
		}
	}

	public void combinationsOfSizeK(char word[], int curPosition, int k, char[] res, int resIndex) {
		if (resIndex == k) {
			CommonUtil.printArray(res);
			return;
		}
		for (int i = curPosition; i < word.length; i++) {
			res[resIndex] = word[i];
			combinationsOfSizeK(word, i + 1, k, res, resIndex + 1);
		}
	}
	
	
}
