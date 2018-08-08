/**
 * 
 */
package com.raj.dp;

import java.util.Arrays;
import java.util.Comparator;

import com.interview.graph.CommonUtil;

/**
 * @author Raj
 *
 */

class Pair {
	int a;
	int b;

	public Pair(int a, int b) {
		super();
		this.a = a;
		this.b = b;
	}

	@Override
	public String toString() {
		return "pair [a=" + a + ", b=" + b + "]";
	}

}

public class MaxlengthofChainOfPairs {

	public int findLongestChain(int[][] pairs) {
		if (pairs.length <= 0)
			return 0;
		Arrays.sort(pairs, (p1, p2) -> p1[1] - p2[1]);
		int len = 1;
		int last = pairs[0][1];
		for (int i = 1; i < pairs.length; i++) {
			if (pairs[i][0] > last) {
				len++;
				last = pairs[i][1];
			}
		}
		return len;
	}

	public int findLongestChain(Pair[] pairs) {
		Arrays.sort(pairs, (p1, p2) -> p1.a - p2.a);
		int len = 0;
		int pre = Integer.MIN_VALUE;
		for (Pair pair : pairs) {
			if (pair.a > pre) { // not overlap
				len++;
				pre = pair.b;
			} else {
				pre = Math.min(pre, pair.b);
			}
		}
		return len;
	}

	public int findLongestChain2(Pair[] pairs) {
		Arrays.sort(pairs, (p1, p2) -> p1.a - p2.a);
		int len = 0;
		int pre = Integer.MIN_VALUE;
		for (Pair pair : pairs) {
			if (pair.a > pre) { // not overlap
				len++;
				pre = pair.b;
			} else if (pair.b < pre) { // overlap but with smaller second element
				pre = pair.b;
			}
		}
		return len;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Pair a[] = { new Pair(5, 24), new Pair(39, 60), new Pair(15, 28), new Pair(27, 40), new Pair(50, 60) };

		int result = -1;
		MaxlengthofChainOfPairs obj = new MaxlengthofChainOfPairs();
		result = obj.maxLengthOfChainPairs(a);
		System.out.println(result);
		result = obj.findLongestChain(a);
		System.out.println(result);
	}

	public int maxLengthOfChainPairs(Pair[] a) {
		CommonUtil.printArray(a);
		Arrays.sort(a, customSorter);
		CommonUtil.printArray(a);
		int n = a.length;
		int t[] = new int[n];
		for (int i = 0; i < n; i++) {
			t[i] = 1;
		}
		int max = t[0];
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (a[i].a > a[j].b) {
					t[i] = Math.max(t[i], t[j] + 1);
					max = Math.max(max, t[i]);
				}
			}
		}
		CommonUtil.printArray(t);
		return max;
	}

	public Comparator<Pair> customSorter = new Comparator<Pair>() {
		public int compare(Pair p1, Pair p2) {
			return p1.a - p2.a;
		}
	};

}
