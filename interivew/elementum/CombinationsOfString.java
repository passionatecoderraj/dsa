/**
 * 
 */
package com.interivew.elementum;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Raj
 *
 */
public class CombinationsOfString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CombinationsOfString obj = new CombinationsOfString();
		String str = "ba";
		int n = str.length();
		obj.combinations(str.toCharArray(), n);
	}

	public void combinations(char[] a, int n) {
		StringBuilder op = new StringBuilder(n);
		List<String> list = new ArrayList<>();
		combinationsUtil3(a, 0, n, op, list);
		Collections.sort(list);
		System.out.println(list);
	}

	public void combinationsUtil3(char[] a, int start, int n, StringBuilder op, List<String> list) {
		if (start == n) {
			return;
		}
		for (int i = start; i < n; i++) {
			op.append(a[i]);
			list.add(op.toString());
			combinationsUtil3(a, i + 1, n, op, list);
			op.deleteCharAt(op.length() - 1);
		}
	}
}
