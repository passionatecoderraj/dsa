/**
 *
 */
package com.raj.mathamatical;

/**
 * @author Raj
 * 
 *         Imagine you have a special keyboard with the following keys:
 * 
 *         Key 1: (A): Print one 'A' on screen.
 * 
 *         Key 2: (Ctrl-A): Select the whole screen.
 * 
 *         Key 3: (Ctrl-C): Copy selection to buffer.
 * 
 *         Key 4: (Ctrl-V): Print buffer on screen appending it after what has
 *         already been printed.
 * 
 *         Now, you can only press the keyboard for N times (with the above four
 *         keys), find out the maximum numbers of 'A' you can print on screen.
 * 
 *         Example 1: Input: N = 3 Output: 3 Explanation: We can at most get 3
 *         A's on screen by pressing following key sequence: A, A, A Example 2:
 *         Input: N = 7 Output: 9 Explanation: We can at most get 9 A's on
 *         screen by pressing following key sequence: A, A, A, Ctrl A, Ctrl C,
 *         Ctrl V, Ctrl V
 */
public class FourKeysKeyboard {

	// http://www.geeksforgeeks.org/how-to-print-maximum-number-of-a-using-given-four-keys/

	// T : O(n2), Space : O(n)
	public int maxA2(int n) {
		if (n <= 6) {
			return n;
		}

		int t[] = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			t[i] = i;
			// why to start with i-3? Because, need to find max of (just by
			// using A's,by using ctrl-A, ctrl-C, ctrl-V) so without using any
			// of these special keys t[i] is i itself. When you use special keys
			// we should ignore two strokes(ctrl-A, Ctrl-C) before making copies
			// Example : so when you are at index 9, you start from 9-3 = 6 by
			// ignoring
			// two strokes for 7 and 8
			for (int j = i - 3; j >= 1; j--) {
				// Why to multiply by (i-j-1?
				/*
				 * after you use i steps to reach maxA(i), you still have n -i
				 * steps. then you cost 2 more steps to do Ctrl-A and Ctrl-C,
				 * After this you have n-i-2 steps left, all the rest could be
				 * used to do Ctrl-V, so you increase n-i-2 copies, at last, you
				 * have the original copy, you need add it to the total num of
				 * copies. therefore, you have n-i-1 copies
				 * https://discuss.leetcode.com/topic/97628/java-4-lines-
				 * recursion-with-step-by-step-explanation-to-derive-dp/4
				 */
				t[i] = Math.max(t[i], (i - j - 1) * t[j]);
			}
		}
		return t[n];
	}

	// T : O(n), Space : O(n)
	public int maxA(int n) {
		if (n <= 6) {
			return n;
		}

		int t[] = new int[n + 1];
		for (int i = 1; i <= 6; i++) {
			t[i] = i;
		}
		for (int i = 7; i <= n; i++) {
			// considering those two elements is sufficient to give maxAs
			t[i] = Math.max(t[i - 4] * 3, t[i - 5] * 4);
		}
		return t[n];
	}

	public static void main(String[] args) {
		FourKeysKeyboard obj = new FourKeysKeyboard();
		int res = -1;
		res = obj.maxA(7);
		System.out.println(res);
		res = obj.maxA(9);
		System.out.println(res);
	}

}
