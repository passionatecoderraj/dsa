/**
 * 
 */
package com.raj.dp;

/**
 * @author Raj We are given two strings, A and B.
 * 
 *         A shift on A consists of taking string A and moving the leftmost
 *         character to the rightmost position. For example, if A = 'abcde',
 *         then it will be 'bcdea' after one shift on A. Return True if and only
 *         if A can become B after some number of shifts on A.
 * 
 *         Example 1: Input: A = 'abcde', B = 'cdeab' Output: true
 * 
 *         Example 2: Input: A = 'abcde', B = 'abced' Output: false Note:
 * 
 *         A and B will have length at most 100.
 */
public class ShortestCompletingWord {

	private static final int[] primes = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71,
			73, 79, 83, 89, 97, 101, 103 };
	// https://leetcode.com/problems/shortest-completing-word/discuss/158110/Java-6ms-beats-100-PRIME-NUMBERS
	/*
	 * Idea: assign each letter a prime number and compute the product for the license plate. 
	 * Then, compute the product for each word in wordlist. We know if the char product for a word is divisible 
	 * by the license plate char product, it contains all the characters.
	 */
	public String shortestCompletingWord(String licensePlate, String[] words) {
		long licence = getCharProduct(licensePlate.toLowerCase());
		int resLen = Integer.MAX_VALUE;
		String res = "";
		for (String word : words) {
			if (getCharProduct(word.toLowerCase()) % licence == 0 && word.length() < resLen) {
				res = word;
				resLen = word.length();
			}
		}
		return res;
	}

	private long getCharProduct(String s) {
		long product = 1L;
		for (char ch : s.toCharArray())
			if (Character.isAlphabetic(ch))
				product *= primes[ch - 'a'];
		return product;
	}

	public String shortestCompletingWord2(String licensePlate, String[] words) {
		int licence[] = count(licensePlate.toLowerCase());
		int resLen = Integer.MAX_VALUE;
		String res = "";
		for (String word : words) {
			if (matches(licence, count(word.toLowerCase())) && word.length() < resLen) {
				res = word;
				resLen = word.length();
			}
		}
		return res;
	}

	boolean matches(int[] a, int[] b) {
		for (int i = 0; i < a.length; i++)
			if (a[i] > b[i])
				return false;
		return true;
	}

	int[] count(String word) {
		int[] t = new int[26];
		for (char ch : word.toCharArray())
			if (Character.isAlphabetic(ch))
				t[ch - 'a']++;

		return t;
	}

	public static void main(String[] args) {
		ShortestCompletingWord obj = new ShortestCompletingWord();
		String res = null;
		String licensePlate = "1s3 PSt", words[] = { "step", "steps", "stripe", "stepple" };

		res = obj.shortestCompletingWord(licensePlate, words);
		System.out.println(res);

		String licensePlate2 = "1s3 456", words2[] = { "looks", "pest", "stew", "show" };

		res = obj.shortestCompletingWord(licensePlate2, words2);
		System.out.println(res);

	}

}
