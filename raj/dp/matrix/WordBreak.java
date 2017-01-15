/**
 * 
 */
package com.raj.dp.matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class WordBreak {

	public static boolean wordBreak(String str, Set<String> dict) {
		int t[] = new int[str.length()];
		Arrays.fill(t, -1);
		for (int i = 0; i < str.length(); i++) {
			if (0 == i || t[i - 1] != -1) {
				for (int j = i; j < str.length(); j++) {
					String sb = str.substring(i, j + 1);
					if (dict.contains(sb)) {
						t[j] = i;
					}
				}
			}
		}
		//System.out.println(Arrays.toString(t));
		return t[str.length() - 1] != -1;
	}

	public static ArrayList<String> wordBreak2(String str, Set<String> dict) {
		ArrayList<String> t[] = new ArrayList[str.length()];
		for (int i = 0; i < str.length(); i++) {
			if (0 == i || t[i - 1] != null) {
				for (int j = i; j < str.length(); j++) {
					String sb = str.substring(i, j + 1);
					if (dict.contains(sb)) {
						if (t[j] == null) {
							ArrayList<String> list = new ArrayList<>();
							list.add(sb);
							t[j] = list;
						} else {
							t[j].add(sb);
						}
					}
				}
			}
		}
		System.out.println(Arrays.toString(t));

		ArrayList<String> result = new ArrayList<String>();
		if (t[str.length() - 1] == null) {
			return result;
		}

		dfs(t, result, t.length - 1, "");
		System.out.println(result);
		return result;
	}

	public static void dfs(ArrayList<String> t[], ArrayList<String> result, int index, String cur) {
		if (index < 0 || null == t[index]) {
			result.add(cur);
			return;
		}

		for (String str : t[index]) {
			dfs(t, result, index - str.length(), str + " " + cur);
		}
	}

	public static void main(String[] args) {
		boolean result = false;
		Set<String> dict = new HashSet<>();

		dict.add("cat");
		dict.add("cats");
		dict.add("sand");
		dict.add("and");
		dict.add("dog");

		result = wordBreak("catsanddog", dict);
		System.out.println(result);
		wordBreak2("catsanddoga", dict);
	}

}
