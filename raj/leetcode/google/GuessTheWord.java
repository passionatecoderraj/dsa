package com.raj.leetcode.google;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * 
 * @author Raj
 * This problem is an interactive problem new to the LeetCode platform.

We are given a word list of unique words, each word is 6 letters long, and one word in this list is chosen as secret.

You may call master.guess(word) to guess a word.  The guessed word should have type string and must be from the original list with 6 lowercase letters.

This function returns an integer type, representing the number of exact matches (value and position) of your guess to the secret word.  Also, if your guess is not in the given wordlist, it will return -1 instead.

For each test case, you have 10 guesses to guess the word. At the end of any number of calls, if you have made 10 or less calls to master.guess and at least one of these guesses was the secret, you pass the testcase.

Besides the example test case below, there will be 5 additional test cases, each with 100 words in the word list.  The letters of each word in those testcases were chosen independently at random from 'a' to 'z', such that every word in the given word lists is unique.

Example 1:
Input: secret = "acckzz", wordlist = ["acckzz","ccbazz","eiowzz","abcczz"]

Explanation:

master.guess("aaaaaa") returns -1, because "aaaaaa" is not in wordlist.
master.guess("acckzz") returns 6, because "acckzz" is secret and has all 6 matches.
master.guess("ccbazz") returns 3, because "ccbazz" has 3 matches.
master.guess("eiowzz") returns 2, because "eiowzz" has 2 matches.
master.guess("abcczz") returns 4, because "abcczz" has 4 matches.

We made 5 calls to master.guess and one of them was the secret, so we pass the test case.
Note:  Any solutions that attempt to circumvent the judge will result in disqualification.


 * 
 */
public class GuessTheWord {

	// https://leetcode.com/problems/guess-the-word/discuss/133862/Random-Guess-and-Minimax-Guess-with-Comparison
	/*
	 *  Strategy : Avoid words that has zero matches in each round
	 *  1. make map of words with zero matches
	 *  2. Guess will be a word (a) that has atleast one match with other words, or
	 *  (b) word that least of zero matches
	 *  3) if guess is not correct, build words for next iteration with exact 'x' matches
	 */
	public void findSecretWord(String[] wordlist, Master master) {
		for (int i = 0, x = 0; i < 10 && x < 6; i++) {
			Map<String, Integer> map = new HashMap<>();
			for (String w1 : wordlist) {
				for (String w2 : wordlist) {
					if (match(w1, w2) == 0) {
						map.put(w1, map.getOrDefault(w1, 0) + 1);
					}
				}
			}
			String guess = "";
			int minCount = 1000;
			for (String word : wordlist) {
				if (!map.containsKey(word)) {
					guess = word;
					break;
				} else if (map.get(word) < minCount) {
					minCount = map.get(word);
					guess = word;
				}

			}

			x = master.guess(guess);
			List<String> newWordList = new ArrayList<>();
			for (String word : wordlist) {
				if (match(word, guess) == x) {
					newWordList.add(word);
				}
			}
			wordlist = newWordList.toArray(new String[newWordList.size()]);
		}
	}

	// https://leetcode.com/problems/guess-the-word/discuss/133862/Random-Guess-and-Minimax-Guess-with-Comparison
	/*
	 *  Strategy : Guess the word randomly
	 *  1. randomly choose a 'guess' word
	 *  2. call 'guess' method with word to get no. of matches(x)
	 *  3. if guess is not correct and matched word is still in list of words, it should also have 'x' matches
	 *  4. so, filter out words that has 'x' matches for next iteration
	 */
	public void findSecretWord2(String[] wordlist, Master master) {
		for (int i = 0, x = 0; i < 10 && x < 6; i++) {
			String guess = wordlist[new Random().nextInt(wordlist.length)];
			x = master.guess(guess);
			List<String> newWordList = new ArrayList<>();
			for (String word : wordlist) {
				if (match(word, guess) == x) {
					newWordList.add(word);
				}
			}
			wordlist = newWordList.toArray(new String[newWordList.size()]);
		}
	}

	private int match(String s, String t) {
		int matches = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == t.charAt(i)) {
				matches++;
			}
		}
		return matches;
	}

	public static void main(String... args) {
		GuessTheWord obj = new GuessTheWord();
		String words[] = { "acckzz", "ccbazz", "eiowzz", "abcczz" };
		Master master = new Master("eiowzz");
		obj.findSecretWord(words, master);

	}

}

class Master {

	String secret;

	public Master(String secret) {
		this.secret = secret;
	}

	public int guess(String word) {
		int x = match(secret, word);
		if (x == 6) {
			System.out.println("Matched : " + word);
		}
		return x;
	}

	private int match(String s, String t) {
		int matches = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == t.charAt(i)) {
				matches++;
			}
		}
		return matches;
	}

}