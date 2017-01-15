package com.raj.dp;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * 
 * @author Raj
 *
 *         In the "100 game," two players take turns adding, to a running total,
 *         any integer from 1..10. The player who first causes the running total
 *         to reach or exceed 100 wins.
 * 
 *         What if we change the game so that players cannot re-use integers?
 * 
 *         For example, two players might take turns drawing from a common pool
 *         of numbers of 1..15 without replacement until they reach a total >=
 *         100.
 * 
 *         Given an integer maxChoosableInteger and another integer
 *         desiredTotal, determine if the first player to move can force a win,
 *         assuming both players play optimally.
 * 
 *         You can always assume that maxChoosableInteger will not be larger
 *         than 20 and desiredTotal will not be larger than 300.
 */
public class CanIWin {

	private boolean canIWinBruteForce(int total, int[] state) {
		if (total <= 0)
			return false;
		for (int i = 1; i < state.length; i++) {
			if (state[i] == 0) {
				state[i] = 1;
				if (!canIWinBruteForce(total - i, state)) {
					state[i] = 0;
					return true;
				}
				state[i] = 0;
			}
		}
		return false;
	}

	public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
		if (desiredTotal <= 0)
			return true;
		if (maxChoosableInteger * (maxChoosableInteger + 1) / 2 < desiredTotal)
			return false;
		HashMap<String, Boolean> map = new LinkedHashMap<>();
		int[] state = new int[maxChoosableInteger + 1];
		boolean result = canIWin(desiredTotal, state, map);
		System.out.println(map);
		return result;
	}

	private boolean canIWin(int total, int[] state, HashMap<String, Boolean> hashMap) {
		if (total <= 0)
			return false;

		String curr = getKey(state);

		if (hashMap.containsKey(curr))
			return hashMap.get(curr);

		for (int i = 1; i < state.length; i++) {
			if (state[i] == 0) {
				state[i] = 1;
				if (!canIWin(total - i, state, hashMap)) {
					hashMap.put(curr, true);
					state[i] = 0;
					return true;
				}
				state[i] = 0;
			}
		}
		hashMap.put(curr, false);
		return false;
	}

	private String getKey(int state[]) {
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < state.length; i++) {
			if (state[i] == 1)
				sb.append(i);
		}
		if (sb.length() == 0)
			sb.append(0);
		return sb.toString();
	}

	public static void main(String args[]) {
		CanIWin obj = new CanIWin();
		boolean result = false;
		result = obj.canIWin(5, 7);
		System.out.println(result);

		result = obj.canIWin(10, 11);
		System.out.println(result);

	}
}