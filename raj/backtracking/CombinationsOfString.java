/**
 * 
 */
package com.raj.backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

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
		// combinationsUtil(a, 0, n, op);
		Set<String> set = new TreeSet<>();
		List<String> list = new ArrayList<>();
		combinationsUtil3(a, 0, n, op, list);
		Collections.sort(list);
		System.out.println(list);
		// String str = "ba";
		// char[] b = str.toCharArray();
		//
		// Arrays.sort(b);
		// combinationsUtil2(b, 0, b.length, op, set);
		// set.remove(str);
		// System.out.println(set);
	}

	public void combinationsUtil(char[] a, int start, int n, StringBuilder op) {
		if (start == n) {
			return;
		}
		for (int i = start; i < n; i++) {
			op.append(a[i]);
			System.out.println(op);
			combinationsUtil(a, i + 1, n, op);
			op.deleteCharAt(op.length() - 1);
		}
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

	public void combinationsUtil2(char[] a, int start, int n, StringBuilder op, Set<String> set) {
		if (start == n) {
			return;
		}
		for (int i = start; i < n; i++) {
			op.append(a[i]);
			set.add(op.toString());
			combinationsUtil2(a, i + 1, n, op, set);
			op.deleteCharAt(op.length() - 1);
		}
	}
}
