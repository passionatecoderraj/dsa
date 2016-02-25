/**
 * 
 */
package com.raj.arrays;

import java.util.Arrays;

import com.interivew.graph.CommonUtil;

/**
 * @author Raj
 *
 *         You have a stream of numbers coming in (lets say more than a
 *         million). The numbers are between [0-999). Implement a class which
 *         can insert(int i); getMean(); getMedian();
 * 
 *         in constant time O(1).
 *
 */
public class FindMedianAndMeanInStreamOfIntegers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Statistics obj = new Statistics();
		int a[] = { 5, 15, 1, 3, 2, 8, 7, 9, 10, 6, 11, 4 };
		for (int i = 0; i < a.length; i++) {
			obj.insert(a[i]);
		}
		System.out.println(obj.mean());
		System.out.println(obj.median());
		Arrays.sort(a);
		CommonUtil.printArray(a);
	}

	private static class Statistics {

		int n = 0;
		double sum = 0;
		int count[] = new int[1000];

		public void insert(int i) {
			count[i]++;
			n++;
			sum += i;
		}

		public double mean() {
			return sum / n;
		}

		public double median() {
			// counter variable
			int idx = 0;
			double a = -1, b = 0;
			
			// TODO: fix this
			for (int value = 0; value < 1000; value++) {
				idx += count[value];
				if (n % 2 != 0) {
					if (idx >= (n + 1) / 2) {
						return value;
					}
				} else {

					if (a == -1 && idx >= n / 2) {
						a = value;
					}
					if (idx >= (n + 1) / 2) {
						b = value;
						return (a + b) / 2;
					}
				}
			}
			return -1;
		}

	}
}
