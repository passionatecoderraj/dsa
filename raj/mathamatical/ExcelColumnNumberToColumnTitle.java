/**
 * 
 */
package com.raj.mathamatical;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Raj
 *
 *         Convert a given integer into a Excel style letter string for columns
 *         like 0 to A, 1 to B, ..., 26 to AA
 */
public class ExcelColumnNumberToColumnTitle {

	public String excelSheetColumnNumber(int n) {
		if (n == 0)
			return "";
		StringBuilder sb = new StringBuilder();
		while (n % 26 > 0) {
			sb.append(map.get(n % 26));
			n = n / 26;
		}
		return sb.reverse().toString();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ExcelColumnNumberToColumnTitle obj = new ExcelColumnNumberToColumnTitle();
		String result = obj.excelSheetColumnNumber(230);
		System.out.println(result);
	}

	static Map<Integer, Character> map = new HashMap<>();

	static {
		map.put(1, 'A');
		map.put(2, 'B');
		map.put(3, 'C');
		map.put(4, 'D');
		map.put(5, 'E');
		map.put(6, 'F');
		map.put(7, 'G');
		map.put(8, 'H');
		map.put(9, 'I');
		map.put(10, 'J');
		map.put(11, 'K');
		map.put(12, 'L');
		map.put(13, 'M');
		map.put(14, 'N');
		map.put(15, 'O');
		map.put(16, 'P');
		map.put(17, 'Q');
		map.put(18, 'R');
		map.put(19, 'S');
		map.put(20, 'T');
		map.put(21, 'U');
		map.put(22, 'V');
		map.put(23, 'W');
		map.put(24, 'X');
		map.put(25, 'Y');
		map.put(26, 'Z');

	}
}
