/**
 * 
 */
package com.raj.mathamatical;

/**
 * @author Raj
 *
 */
public class XPowerN {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		XPowerN obj = new XPowerN();
		int result = -1, x = 2, n = 10;

		// Time :O(n)
		result = obj.powBruteForce(x, n);
		System.out.println(result);

		// Time :O(n)
		result = obj.powMethod2(x, n);
		System.out.println(result);

		// Time :O(logn)
		result = obj.powOptimized(x, n);
		System.out.println(result);

		// Time :O(logn)
		// for negative values also
		double res = 0;
		res = obj.pow(2, -3);
		System.out.println(res);
	}

	public double pow(double x, int n) {
		if (0 == n)
			return 1;
		double temp = pow(x, n / 2);
		if (n % 2 == 0) {
			return temp * temp;
		} else {
			if (n > 0)
				return x * temp * temp;
			else
				return (temp * temp) / x;
		}
	}

	public int powOptimized(int x, int n) {
		if (n == 0)
			return 1;
		int temp = powOptimized(x, n / 2);
		if (n % 2 == 0)
			return temp * temp;
		else
			return x * temp * temp;
	}

	public int powMethod2(int x, int n) {
		if (n == 0)
			return 1;
		if (n % 2 == 0)
			return powMethod2(x, n / 2) * powMethod2(x, n / 2);
		else
			return x * powMethod2(x, n / 2) * powMethod2(x, n / 2);
	}

	private int powBruteForce(int x, int n) {
		int res = 1;
		for (int i = 0; i < n; i++) {
			res = res * x;
		}
		return res;
	}

}
