/**
 * 
 */
package com.interivew.regex;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.interivew.graph.CommonUtil;

/**
 * @author Raj
 *
 */
public class CareerCup {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		reverseSetence("Prithviraj Kumar Dasari. $Hello");
	}

	public static String reverseSetence(String str) {
		StringBuilder sb = new StringBuilder(str);
		Pattern p = Pattern.compile("[a-zA-Z0-9]+");
		Matcher m = p.matcher(str);
		while (m.find()) {
			reverse(sb, m.start(), m.end() - 1);
		}
		return sb.toString();
	}

	public static void reverse(StringBuilder sb, int l, int r) {
		while (l < r) {
			swap(sb, l++, r--);
		}
	}

	public static void swap(StringBuilder sb, int i, int j) {
		char temp = sb.charAt(i);
		sb.setCharAt(i, sb.charAt(j));
		sb.setCharAt(j, temp);
	}

	/*
	 * Given a series of number form a binary tree find the minimum weight
	 * binary tree. The weight of the node is depth * value of the element +
	 * weight of the left tree + weight of the right tree.
	 * 
	 * Weight of the root node is the weight of the tree . Find the minimum
	 * weight binary tree out of all possible binary trees that are possible.
	 */
	
	
}
