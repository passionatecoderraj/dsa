package com.interview.visa;

import java.util.Scanner;

// http://stackoverflow.com/questions/24518682/count-subsequences-divisible-by-k
public class ConsecutiveSubsequences {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int tests = scanner.nextInt();

		for (int l = 0; l < tests; l++) {
			int n = scanner.nextInt();
			int k = scanner.nextInt();
			int[] numbers = new int[n];

			for (int i = 0; i < n; i++) {
				numbers[i] = scanner.nextInt();
			}
			long result = kSub(numbers, k);
			System.out.println(result);
		}

		scanner.close();
	}

	public static long kSub(int nums[], int k) {
		long[] prefixModCount = new long[k];
		for (int i = 0; i < k; i++) {
			prefixModCount[i] = 0;
		}
		prefixModCount[0] = 1;

		int prefixSum = 0;
		for (int i = 0; i < nums.length; i++) {
			prefixSum += nums[i];
			prefixSum %= k;
			prefixModCount[prefixSum] += 1;
		}
		long result = 0;
		for (int mod = 0; mod < k; mod++) {
			result += prefixModCount[mod] * (prefixModCount[mod] - 1) / 2;
		}
		return result;
	}
}