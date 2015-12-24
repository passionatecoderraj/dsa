package com.raj.dp;

public class CountNDigitsToWholeSum {

	public static void main(String[] args) {
		CountNDigitsToWholeSum obj = new CountNDigitsToWholeSum();
		int result = -1, count = 0, n = 3, sum = 6;
		result = obj.finalCount(n, sum, count);
		System.out.println();
		System.out.println(result);
	}

	public int finalCount(int n, int sum, int count) {
		int res = 0;

		for (int i = 1; sum - i >= 0; i++) {
			System.out.println("---------" + i + "---------");
			int x = countNDigitsToWholeSum(n - 1, sum - i, count);
			res = res + x;

		}
		return res;
	}

	public int countNDigitsToWholeSum(int n, int sum, int count) {
		if (n == 1) {
			System.out.print(sum + ", ");
			System.out.println();
			return count + 1;
		} else {
			for (int i = 0; sum - i >= 0; i++) {
				System.out.print(i + ", ");
				count = countNDigitsToWholeSum(n - 1, sum - i, count);
				// System.out.println("(" + i + "," + j + ")");
			}
		}
		return count;
	}

}
