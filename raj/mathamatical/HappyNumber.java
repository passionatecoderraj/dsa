/**
 * 
 */
package com.raj.mathamatical;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author Raj
 *
 *         Write an algorithm to determine if a number is "happy".
 * 
 *         A happy number is a number defined by the following process: Starting
 *         with any positive integer, replace the number by the sum of the
 *         squares of its digits, and repeat the process until the number equals
 *         1 (where it will stay), or it loops endlessly in a cycle which does
 *         not include 1. Those numbers for which this process ends in 1 are
 *         happy numbers.
 * 
 *         Example: 19 is a happy number
 * 
 *         12 + 92 = 82 82 + 22 = 68 62 + 82 = 100 12 + 02 + 02 = 1
 * 
 */
public class HappyNumber {

	// Space :O(1)
	public static boolean isHappyNumber(int n) {
		if (0 == n)
			return false;
		int slow, fast;
		slow = fast = n;

		do {
			// next
			slow = sumOfSquaresOfAllDigits(slow);
			// next.next
			fast = sumOfSquaresOfAllDigits(sumOfSquaresOfAllDigits(fast));
			System.out.println("slow=" + slow + ",fast=" + fast);
		} while (slow != fast);

		return slow == 1;
	}

	// Space :O(n)
	public static boolean isHappyNumber2(int n) {
		if (0 == n)
			return false;

		Set<Integer> set = new LinkedHashSet<>();
		while (!set.contains(n)) {
			set.add(n);
			n = sumOfSquaresOfAllDigits(n);
			if (1 == n)
				return true;
		}
		System.out.println(set);

		return false;
	}

	private static int sumOfSquaresOfAllDigits(int n) {
		int sum = 0;
		while (n > 0) {
			sum += (n % 10) * (n % 10);
			n = n / 10;
		}
		return sum;
	}

	public static void main(String[] args) {
		boolean res = false;
		res = isHappyNumber2(19);
		System.out.println(res);
		res = isHappyNumber2(14);
		System.out.println(res);

		res = isHappyNumber(19);
		System.out.println(res);
		res = isHappyNumber(14);
		System.out.println(res);

	}

}
