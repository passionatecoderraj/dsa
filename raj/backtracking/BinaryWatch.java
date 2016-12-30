/**
 * 
 */
package com.raj.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Raj
 *
 *
 *         A binary watch has 4 LEDs on the top which represent the hours
 *         (0-11), and the 6 LEDs on the bottom represent the minutes (0-59).
 *
 *         Given a non-negative integer n which represents the number of LEDs
 *         that are currently on, return all possible times the watch could
 *         represent.
 *
 *
 *         Input: n = 1 Return: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02",
 *         "0:04", "0:08", "0:16", "0:32"]
 * 
 */

public class BinaryWatch {

	public List<String> readBinaryWatch(int num) {
		List<String> result = new ArrayList<String>();

		for (int i = 0; i < 12; i++) {
			for (int j = 0; j < 60; j++) {
				int total = count1sInBinary(i) + count1sInBinary(j);
				if (total == num) {
					String s = "";
					s += i + ":";

					if (j < 10) {
						s += "0" + j;
					} else {
						s += j;
					}

					result.add(s);
				}
			}
		}

		return result;
	}

	public int count1sInBinary(int n) {
		int count = 0;
		while (n > 0) {
			count += (n & 1);
			n = n >> 1;
		}
		return count;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BinaryWatch obj = new BinaryWatch();
		int n = 1;
		List<String> result = null;

		result = obj.readBinaryWatch(n);
		System.out.println(result);
	}

}
