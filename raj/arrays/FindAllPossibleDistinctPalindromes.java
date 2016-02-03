package com.raj.arrays;

import java.util.HashSet;
import java.util.Set;

public class FindAllPossibleDistinctPalindromes {

	public static void main(String[] args) {

		String str = "ananab";
		FindAllPossibleDistinctPalindromes obj = new FindAllPossibleDistinctPalindromes();
		int n = str.length(), result = -1;
		result = obj.findAllPossibleDistinctPalindromes(str, n);
		System.out.println(result);
	}

	public int findAllPossibleDistinctPalindromes(String str, int n) {
		Set<String> set = new HashSet<String>();
		boolean t[][] = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			t[i][i] = true;
			set.add(str.substring(i, i + 1));
		}

		for (int l = 2; l <= n; l++) {
			for (int i = 0; i < n - l + 1; i++) {
				int j = i + l - 1;
				if (str.charAt(i) == str.charAt(j)) {
					if (l == 2) {
						t[i][j] = true;
						set.add(str.substring(i, j + 1));
					} else {
						t[i][j] = t[i + 1][j - 1];
						if (t[i][j])
							set.add(str.substring(i, j + 1));
					}
				}
			}
		}
		for (String s : set)
			System.out.print(s + " ");
		System.out.println();
		return set.size();
	}

}
