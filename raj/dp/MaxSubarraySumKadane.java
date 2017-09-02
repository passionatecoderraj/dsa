package com.raj.dp;

import com.interview.graph.CommonUtil;

public class MaxSubarraySumKadane {

	public static void main(String[] args) {
		// int a[] ={-2, 11, -4, 13, -5, -2};
		int a[] = { -2, -3, 4, -1, -2, 1, 5, -3 };
		// int a[] ={1,2,3,4};
		MaxSubarraySumKadane obj = new MaxSubarraySumKadane();
		int result = -1;
		result = obj.maxContiguousSumBruteForceOn3(a);
		System.out.println(result);
		result = obj.maxContiguousSumBruteForceOn2(a);
		System.out.println(result);

		result = obj.maxContiguousSumDpOn(a);
		System.out.println(result);

		KadaneResult res = obj.maxContiguousSumWithKadaneResult(a);
		System.out.println(res);
	}

	public KadaneResult maxContiguousSumWithKadaneResult(int[] a) {
		int maxStart = -1;
		int maxEnd = -1;
		int max = 0;

		int curStart = 0;
		int maxSoFar = 0;

		for (int i = 0; i < a.length; i++) {
			maxSoFar += a[i];
			if (maxSoFar > max) {
				max = maxSoFar;
				maxStart = curStart;
				maxEnd = i;
			}
			
			if (maxSoFar < 0) {
				curStart = i + 1;
				maxSoFar = 0;
			}
		}
		return new KadaneResult(max, maxStart, maxEnd);
	}

	public int maxContiguousSumDpOn(int[] a) {
		int n = a.length;
		if (n <= 0)
			return -1;
		int sum[] = new int[a.length];
		sum[0] = a[0];
		int max = sum[0];
		for (int i = 1; i < n; i++) {
			sum[i] = Math.max(sum[i - 1] + a[i], a[i]);
			max = Math.max(sum[i], max);
		}
		CommonUtil.printArray(sum);
		return max;
	}

	public int max(int a, int b) {
		return a > b ? a : b;
	}

	public int maxContiguousSumBruteForceOn2(int[] a) {
		int n = a.length;
		int maxSum = 0;
		for (int i = 0; i < n; i++) {
			int currentSum = 0;
			for (int j = i; j < n; j++) {
				currentSum += a[j];
				if (currentSum > maxSum) {
					maxSum = currentSum;
				}
			}
		}
		return maxSum;
	}

	public int maxContiguousSumBruteForceOn3(int[] a) {
		int n = a.length;
		int maxSum = 0;
		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				int currentSum = 0;
				for (int k = i; k <= j; k++) {
					currentSum += a[k];
				}
				if (currentSum > maxSum) {
					maxSum = currentSum;
				}
			}
		}
		return maxSum;
	}

}

class KadaneResult {
	int max;
	int maxStart;
	int maxEnd;

	public KadaneResult(int max, int maxStart, int maxEnd) {
		super();
		this.max = max;
		this.maxStart = maxStart;
		this.maxEnd = maxEnd;
	}

	@Override
	public String toString() {
		return "KadaneResult [max=" + max + ", maxStart=" + maxStart + ", maxEnd=" + maxEnd + "]";
	}

}
