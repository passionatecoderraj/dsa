package com.raj.dp;

public class SimpleRecurrence {

	public static void main(String[] args) {
		SimpleRecurrence obj = new SimpleRecurrence();
		int result = -1, n = 5;

		result = obj.funInBookBruteForce(n);
		System.out.println(result);

		result = obj.funBruteForce(n);
		System.out.println(result);
		result = obj.funBottomUp(n);
		System.out.println(result);
		obj.init(n);
		result = obj.funTopDown(n);
		System.out.println(result);

	}

	public int funBottomUp(int n) {
		int c[] = new int[n + 1];
		c[0] = 2;
		c[1] = 2;
		c[2] = 2 * c[1] * c[0];
		for (int i = 3; i <= n; i++) {
			c[i] = c[i - 1] + (2 * c[i - 1] * c[i - 2]);
		}
		return c[n];
	}

	int f[];

	public void init(int n) {
		f = new int[n + 1];
		f[0] = 2;
		f[1] = 2;
		f[2] = 2 * f[1] * f[0];
	}

	public int funTopDown(int n) {
		if (n < 0)
			return -1;
		if (n == 0)
			return f[0];
		else if (n == 1)
			return f[1];
		else if (n == 2)
			return f[2];
		else {
			f[n] = funTopDown(n - 1) + (2 * funTopDown(n - 1) * funTopDown(n - 2));
			return f[n];
		}
	}

	public int funBruteForce(int n) {
		if (n < 0)
			return -1;
		else if (n == 0 || n == 1)
			return 2;
		else if (n == 2)
			return 2 * funBruteForce(n - 1) * funBruteForce(n - 2);
		else {
			return funBruteForce(n - 1) + (2 * funBruteForce(n - 1) * funBruteForce(n - 2));
		}
	}

	public int funInBookBruteForce(int n) {
		int sum = 0;
		if (n < 0)
			return -1;
		else if (n == 0 || n == 1)
			return 2;
		for (int i = 1; i < n; i++)
			sum += 2 * funInBookBruteForce(i) * funInBookBruteForce(i - 1);
		return sum;
	}

}
