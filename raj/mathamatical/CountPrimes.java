/**
 * 
 */
package com.raj.mathamatical;

import java.util.Arrays;

/**
 * @author Raj
 *
 */
public class CountPrimes {

	// Time :O(n*loglogn), Space : O(n)
	public int countPrimes(int n) {
		boolean[] isPrime = new boolean[n];
		Arrays.fill(isPrime, true);

		// Loop's ending condition is i * i < n instead of i < sqrt(n)
		// to avoid repeatedly calling an expensive function sqrt().
		for (int i = 2; i * i < n; i++) {
			if (!isPrime[i])
				continue;
			for (int k = i * i; k < n; k += i) {
				isPrime[k] = false;
			}
			// another way of doing
			// for (int k = i ; k* i < n; k++) {
			// isPrime[k*i] = false;
			// }
		}
		int count = 0;
		for (int i = 2; i < n; i++) {
			if (isPrime[i])
				count++;
		}
		System.out.println(Arrays.toString(isPrime));
		return count;
	}

	// Time :O(n*√n), Space : O(1)
	public int countPrimes2(int n) {
		int count = 0;
		for (int i = 2; i <= n; i++) {
			if (isPrime(i)) {
				System.out.println(i);
				count++;
			}
		}
		return count;
	}

	/*
	 * Let's write down all of 12's factors:
	 * 
	 * 2 × 6 = 12 3 × 4 = 12 4 × 3 = 12 6 × 2 = 12 As you can see, calculations
	 * of 4 × 3 and 6 × 2 are not necessary. Therefore, we only need to consider
	 * factors up to √n because, if n is divisible
	 */

	// Time :O(√n)
	public boolean isPrime(int n) {

		for (int i = 2; i <= (int) Math.sqrt(n); i++) {
			if (n % i == 0)
				return false;
		}
		return true;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CountPrimes obj = new CountPrimes();
		int result = -1;
		int n = 12;

		result = obj.countPrimes(n);
		System.out.println(result);
	}

}
