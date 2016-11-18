package com.raj.leetcode;

public class Ramanujan {

	public static void main(String[] args) {

		// read in one command-line argument
		int n = 1729;
		Ramanujan obj = new Ramanujan();
		boolean result = false;
		result = obj.checkRamanujanBruteForce(n);
		System.out.println(result);
		result = obj.checkRamanujan(n);
		System.out.println(result);
		result = obj.efficientRamanujan(n);
		System.out.println(result);

	}

	public boolean efficientRamanujan(int n) {
		int count = 0;

		int x = 1;
		int y = (int) Math.cbrt(n);

		while (x < y) {

			int sum = (int) Math.pow(x, 3) + (int) Math.pow(y, 3);
			if (sum < n) {
				x = x + 1;
			} else if (sum > n) {
				y = y - 1;
			} else {
				count++;
				System.out.print(x + "^3 + " + y + "^3 = ");
				x = x + 1;
				y = y - 1;
			}

			if (count >= 2) {
				return true;
			}
		}

		return false;
	}

	// checking whether a number is Ramanujan number
	public boolean checkRamanujan(int a) {
		int count = 0;
		int cbrt = (int) Math.cbrt(a);

		// numbers only below and equal to cubeth root of number
		for (int i = 1; i <= cbrt; i++) {
			int difference = a - (i * i * i);
			int a1 = (int) Math.cbrt(difference); // checking whether the
													// difference is perfect
													// cube

			if (a1 == Math.cbrt(difference)) {
				count = count + 1;
				System.out.print(i + "^3 + " + a1 + "^3 = ");
			}
			// checking if two such pairs exists i.e.
			// (a*a*a)+(b*b*b)=(c*c*c)+(d*d*d)=number
			if (count == 2) {
				return true;
			}
		}
		return false;
	}

	// checking whether a number is ramanujan number
	public boolean checkRamanujanBruteForce(int n) {
		// for each a, b, c, d, check whether a^3 + b^3 = c^3 + d^3
		for (int a = 1; a <= n; a++) {
			int a3 = a * a * a;
			if (a3 > n)
				break;

			// start at a to avoid print out duplicate
			for (int b = a; b <= n; b++) {
				int b3 = b * b * b;
				if (a3 + b3 > n)
					break;

				// start at a + 1 to avoid printing out duplicates
				for (int c = a + 1; c <= n; c++) {
					int c3 = c * c * c;
					if (c3 > a3 + b3)
						break;

					// start at c to avoid printing out duplicates
					for (int d = c; d <= n; d++) {
						int d3 = d * d * d;
						if (c3 + d3 > a3 + b3)
							break;

						if (c3 + d3 == a3 + b3) {
							System.out.print((a3 + b3) + " = ");
							System.out.print(a + "^3 + " + b + "^3 = ");
							System.out.print(c + "^3 + " + d + "^3");
							System.out.println();
							return true;
						}
					}
				}
			}
		}
		return false;
	}
}