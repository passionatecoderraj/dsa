/**
 * 
 */
package com.raj.dp;

import java.util.Arrays;
import java.util.Comparator;

import com.interivew.graph.CommonUtil;

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

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Pair a[] = { new Pair(5, 24), new Pair(39, 60), new Pair(15, 28), new Pair(27, 40), new Pair(50, 60) };

		int result = -1;
		MaxlengthofChainOfPairs obj = new MaxlengthofChainOfPairs();
		result = obj.maxLengthOfChainPairs(a);
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
