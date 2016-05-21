package com.interivew.practice;

import java.util.Scanner;

public class StringSimilarity {
	public static int calculate(String s) {
		char[] arr = s.toCharArray();
		int length = arr.length;
		int count = length;
		for (int i = 1; i < length; i++) {
			int len = length - i;
			int j = 0;
			for (; j < len; j++)
				if (arr[j] != arr[j + i]) {
					break;
				}
			count += j;
		}
		return count;
	}

	/*
	 * public static int calculate(String s){ int count=s.length(); for(int
	 * i=1;i<s.length();i++){ count+=similarCount(s,s.substring(i)); } return
	 * count; } private static int similarCount(String s, String sub){ for(int
	 * i=0;i<sub.length();i++) if(s.charAt(i)!=sub.charAt(i)) return i; return
	 * sub.length(); }
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		for (int i = 0; i < n; i++) {
			String s = scanner.next();
			System.out.println(calculate(s));
		}
	}
}