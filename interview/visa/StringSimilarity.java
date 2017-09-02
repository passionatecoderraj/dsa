package com.interview.visa;

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

	static int[] StringSimilarity(String[] inputs) {
		int[] res = new int[inputs.length];
		for (int i = 0; i < inputs.length; i++) {
			String input = inputs[i];
			res[i] = calculate(input);
		}
		return res;
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
	/*
	 * static int[] StringSimilarity(String[] inputs) { int[] res = new
	 * int[inputs.length]; if(inputs == null || inputs.length==0) return res;
	 * int count=0; for(int i=0;i<inputs.length;i++){ String input = inputs[i];
	 * if(input.length()==0){ res[i]=0; continue; }
	 * 
	 * String suffixes[] = suffixes(input); print(suffixes); count =0;
	 * for(String suffix:suffixes){ int c = common(input,suffix);; count+=c; }
	 * res[i] = count; } return res; }
	 * 
	 * 
	 * public static void print(String s[]){ for(String a:s) System.out.print(a+
	 * " "); System.out.println(); }
	 * 
	 * public static int common(String a,String b){ int count =0; int i=0,j=0;
	 * 
	 * while(i < a.length() && j < b.length()){
	 * if(a.charAt(i++)==b.charAt(j++)){ count++; } else{ return count; } }
	 * return count; }
	 * 
	 * public static String[] suffixes(String str){ String s[] = new
	 * String[str.length()]; for(int i=0;i<str.length();i++){ s[i] =
	 * str.substring(i,str.length()); } return s; }
	 */
}