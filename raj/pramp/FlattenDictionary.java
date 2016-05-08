package com.raj.pramp;

import java.util.HashMap;
import java.util.Map;

/*
 * Given a dictionary, write a function to flatten it. Consider the following input/output scenario for better understanding:
 * 
 * https://www.pramp.com/question/AMypWAprdmUlaP2gPVLZ
 */
public class FlattenDictionary {
	public static void main(String[] args) {

		FlattenDictionary obj = new FlattenDictionary();

		Map<String, Object> x = new HashMap<String, Object>();
		x.put("d", "3");
		x.put("e", "1");

		Map<String, Object> t = new HashMap<String, Object>();
		t.put("a", "2");
		t.put("b", "3");
		t.put("c", x);

		Map<String, Object> dictionary = new HashMap<String, Object>();
		dictionary.put("Key1", "1");
		dictionary.put("Key2", t);
		Map<String, String> result = new HashMap<String, String>();

		obj.flattenDictionary(dictionary, result, new String());
		for (String key : result.keySet()) {
			System.out.println(key + " : " + result.get(key));
		}
	}

	public void flattenDictionary(Map<String, Object> map, Map<String, String> result, String k) {
		String temp;
		for (String key : map.keySet()) {
			if (map.get(key) instanceof Map) {
				temp = k + key + ".";
				flattenDictionary((Map<String, Object>) map.get(key), result, temp);
			} else {
				temp = k + key;
				result.put(temp, map.get(key).toString());
			}
		}
	}

	// {'Key2': { 'c' : { 'd' : '3' } } }
	public static void f(Map<String, Object> map, Map<String, String> result, String sb) {
		String k;
		for (String key : map.keySet()) {
			if (map.get(key) instanceof Map) {
				sb = sb + key + ".";
				f((Map<String, Object>) map.get(key), result, sb);
			} else {
				k = sb + key;
				result.put(k, (String) map.get(key));
			}
		}

	}

	public static int f(int[] arr, int min, int max) {

		if (min > max)
			return -1;

		int mid = (min + max) / 2; // 5

		if (arr[mid] == mid)
			return mid;

		if (arr[mid] > mid) {
			return f(arr, min, mid - 1);
		} else {
			return f(arr, mid + 1, max);
		}

		// return -1;
	}

}