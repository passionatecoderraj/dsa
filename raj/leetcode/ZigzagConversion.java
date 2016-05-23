package com.raj.leetcode;

/*
 * ZigZag Conversion (Java)
 * 
 * 
 * http://www.programcreek.com/2014/05/leetcode-zigzag-conversion-java/
 * http://www.tangjikai.com/algorithms/leetcode-6-zigzag-conversion
 */
public class ZigzagConversion {

	public static void main(String args[]) {
		ZigzagConversion s = new ZigzagConversion();
		String str = "prithvirajkumar";

		int rows = 4;
		String result = null;
		System.out.println(str);
		result = s.convertToZigZag(str, rows);
		System.out.println(result);

	}

	public String convertToZigZag(String str, int rows) {
		StringBuilder sb = new StringBuilder();
		int step = 2 * (rows - 1);

		for (int i = 0; i < rows; i++) {
			if (i == 0 || i == rows - 1) {
				int j = i;
				while (j < str.length()) {
					sb.append(str.charAt(j));
					j += step;

				}
			} else {
				int step1 = 2 * (rows - 1 - i);
				int step2 = 2 * i;
				// or int step2 = step1 - step;
				System.out.println(step1);
				System.out.println(step2);

				int j = i;
				boolean flag = true;
				while (j < str.length()) {
					sb.append(str.charAt(j));
					if (flag)
						j += step1;
					else
						j += step2;
					flag = !flag;
				}
			}
		}
		return sb.toString();
	}

}