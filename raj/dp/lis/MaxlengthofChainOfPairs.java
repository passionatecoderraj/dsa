/**
 * 
 */
package com.raj.dp.lis;

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

	private int maxLengthOfChainPairs(Pair[] a) {
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
		for (int i : t)
			System.out.print(i + " ");
		System.out.println();
		return max;
	}

}
