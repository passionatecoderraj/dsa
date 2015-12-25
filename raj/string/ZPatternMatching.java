package com.raj.string;

import com.interivew.graph.CommonUtil;

public class ZPatternMatching {

	public static void main(String[] args) {
		String txt = "ABABDABACDABABCABAB";
		// String pat = "ABABCABAB";
		String pat = "aabxaayaab";
		ZPatternMatching obj = new ZPatternMatching();

		int m = pat.length();
		int z[] = new int[m];
		obj.makeZ(pat.toCharArray(), m, z);
		CommonUtil.printArray(z);
	}

	public void makeZ(char[] p, int m, int[] z) {
		int k, j;
		z[0] = 0;
		for (int i = 1; i < m; i++) {
			k = i;
			j = 0;
			while (k < m && p[k] == p[j]) {
				k++;
				j++;
			}
			z[i] = j;
		}
	}

}
