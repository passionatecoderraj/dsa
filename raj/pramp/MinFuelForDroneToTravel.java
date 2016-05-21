package com.raj.pramp;

/*
 * https://www.pramp.com/question/BrLMj8M2dVUoY95A9x3X
 */
public class MinFuelForDroneToTravel {

	public static void main(String[] args) {
		int z[] = { 10, 0, 6, 15, 8 };
		int result = -1;
		MinFuelForDroneToTravel obj = new MinFuelForDroneToTravel();

		// 2n to 4n operations : O(n)
		result = obj.calculateMinFuel(z);
		System.out.println(result);

		// n operations : O(n)
		result = obj.calculateMinFuelOptimized(z);
		System.out.println(result);
	}

	public int calculateMinFuelOptimized(int[] z) {
		int minFuel = 0;
		if (z.length < 2)
			return minFuel;
		int start = z[0];
		int max = start;
		for (int i = 1; i < z.length; i++) {
			max = Math.max(z[i], max);
		}
		minFuel = max - start;
		return minFuel;
	}

	public int calculateMinFuel(int z[]) {
		int a = 0, d = 0;
		int minFuel = 0;
		for (int i = 1; i < z.length; i++) {

			if (z[i] > z[i - 1]) {
				a += z[i] - z[i - 1];
			} else {
				d += z[i - 1] - z[i];
			}
			System.out.println(a+"-"+d);
			
			if (a > d)
				minFuel = Math.max(minFuel, (a - d));
		}

		return minFuel;
	}

}