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
public class ExcelColumnTitleToColumnNumber {

	public int excelSheetColumnNumber(String string) {
		int res = 0, pow = 1;
		for (char ch : new StringBuilder(string).reverse().toString().toCharArray()) {
			res += (pow * (ch - 'A' + 1));
			pow *= 26;
		}
		return res;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ExcelColumnTitleToColumnNumber obj = new ExcelColumnTitleToColumnNumber();
		int result = obj.excelSheetColumnNumber("AB");
		System.out.println(result);
	}

}
