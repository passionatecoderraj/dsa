/**
 * 
 */
package com.raj.arrays;

/**
 * @author Raj
 *
 *
 */
/*
 * Compare Version Numbers using Java
 */

/*
 * "Compare two version numbers version1 and version2. If version1 > version2
 * return 1, if version1 < version2 return -1, otherwise return 0.
 * 
 * You may assume that the version strings are non-empty and contain only digits
 * and the . character. The . character does not represent a decimal point and
 * is used to separate number sequences."
 * 
 * 
 * imp case is 1.0 and 1 are equal
 */
public class CompareVersionNumbers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CompareVersionNumbers obj = new CompareVersionNumbers();
		int result = Integer.MAX_VALUE;
		String str1, str2;
		str1 = "10.3.2";
		str2 = "10.3.4";
		result = obj.compareVersionNumbers(str1, str2);
		System.out.println(result);
		result = obj.compareVersionNumbers2(str1, str2);
		System.out.println(result);
		str1 = "10.3.2.0.1";
		str2 = "10.3.2";
		result = obj.compareVersionNumbers(str1, str2);
		System.out.println(result);
		result = obj.compareVersionNumbers2(str1, str2);
		System.out.println(result);

	}

	public int compareVersionNumbers(String str1, String str2) {
		String a[] = str1.split("\\.");
		String b[] = str2.split("\\.");
		int i = 0, v1, v2;
		while (i < a.length || i < b.length) {
			if (i < a.length && i < b.length) {
				v1 = Integer.parseInt(a[i]);
				v2 = Integer.parseInt(b[i]);
				if (v1 > v2) {
					return 1;
				} else if (v1 < v2) {
					return -1;
				}
			} else if (i < a.length) {
				return Integer.parseInt(a[i]) == 0 ? 0 : 1;
			} else {
				return Integer.parseInt(b[i]) == 0 ? 0 : -1;
			}
			i++;
		}
		return 0;
	}

	public int compareVersionNumbers2(String str1, String str2) {
		String a[] = str1.split("\\.");
		String b[] = str2.split("\\.");
		int i = 0, j = 0, v1, v2;
		while (i < a.length || j < b.length) {
			v1 = i < a.length ? Integer.parseInt(a[i++]) : 0;
			v2 = j < b.length ? Integer.parseInt(b[j++]) : 0;
			if (v1 > v2) {
				return 1;
			} else if (v1 < v2) {
				return -1;
			}
		}
		return 0;
	}
}
