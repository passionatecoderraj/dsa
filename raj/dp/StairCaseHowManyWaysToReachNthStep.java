package com.raj.dp;

public class StairCaseHowManyWaysToReachNthStep {

	public static void main(String[] args) {
		StairCaseHowManyWaysToReachNthStep obj = new StairCaseHowManyWaysToReachNthStep();
		int result = -1;
		result = obj.waysToReachNthStepWithMaxTwoSteps(4);
		System.out.println(result);
		result = obj.waysToReachNthStepWithMaxThreeSteps(4);
		System.out.println(result);

		int maxSteps = 4;
		result = obj.waysToReachNthStepWithMaxNSteps(4, maxSteps);
		System.out.println(result);
	}

	public int waysToReachNthStepWithMaxNSteps(int n, int maxSteps) {
		if (n < maxSteps)
			return -1;
		int t[] = new int[n];

		for (int i = 0; i < maxSteps; i++) {
			t[i] = (int) Math.pow(2, i);
		}

		for (int i = maxSteps; i < n; i++) {
			t[i] = 0;
			for (int j = 1; j <= maxSteps; j++) {
				t[i] += t[i - j];
			}
		}
		return t[n - 1];
	}

	public int waysToReachNthStepWithMaxThreeSteps(int n) {
		int t[] = new int[n];
		// 1 way to reach step '1' (power of 2)
		t[0] = 1;
		// 2 way to reach step '2' - (1,1) (2)(power of 2)
		t[1] = 2;
		// 3 way to reach step '3' - (1,1,1) (2,1) (1,2) (3)(power of 2)
		t[2] = 4;

		for (int i = 3; i < n; i++) {
			t[i] = t[i - 1] + t[i - 2] + t[i - 3];
		}

		return t[n - 1];
	}

	public int waysToReachNthStepWithMaxTwoSteps(int n) {
		int t[] = new int[n];
		// 1 way to reach step '1'(power of 2)
		t[0] = 1;
		// 2 way to reach step '2' - (1,1) (2)(power of 2)
		t[1] = 2;

		for (int i = 2; i < n; i++) {
			t[i] = t[i - 1] + t[i - 2];
		}

		return t[n - 1];
	}

}
