/**
 *
 */
package com.raj.mathamatical;

/**
 * @author Raj
 * 
 *         Convert a given integer into a Excel style letter string
 * 
 *         for columns like 0 to A, 1 to B, ..., 26 to AA
 */
public class ExcelColumnNumberToColumnTitle {

	public String excelSheetColumnNumber(int n) {
		if (n == 0) {
			return "";
		}
		StringBuilder sb = new StringBuilder();
		while (n > 0) {
			n--;
			sb.append((char) ('A' + n % 26));
			n /= 26;
		}
		return sb.reverse().toString();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ExcelColumnNumberToColumnTitle obj = new ExcelColumnNumberToColumnTitle();
		String result = obj.excelSheetColumnNumber(2300);
		System.out.println(result);
	}

}
