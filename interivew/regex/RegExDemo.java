/**
 * 
 */
package com.interivew.regex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Raj
 *
 */
public class RegExDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// demoExample5();
		isValidDomain("prithivrajwww.gmail.com");
		isValidDomain("www.gmail.raj.com");
	}

	public static boolean isValidEmail(String str) {
		String pat = "[a-zA-Z0-9][a-zA-Z0-9_.]*@[a-zA-Z0-9]+([.][a-zA-Z]+)+";
		Pattern p = Pattern.compile(pat);
		Matcher m = p.matcher(str);
		return m.matches();
	}

	public static void isValidDomain(String str) {
		String pat = "[www.|ww2.|web.][a-zA-Z0-9]+([.][a-zA-Z]+)+";
		// String pat
		// ="[https|http]?:((?:[-a-zA-Z0-9]+\.)*[\-a-zA-Z0-9]+\.[a-zA-Z0-9]+(?:[a-zA-Z0-9]+)?)";
		Pattern p = Pattern.compile(pat);
		Matcher m = p.matcher(str);
		StringBuilder sb = new StringBuilder();

		while (m.find()) {
			System.out.println("start=" + m.start() + ", end=" + m.end() + ", group=" + m.group());
			sb.append(m.group());
		}
		System.out.println(sb.toString());

	}

	public static void reverseSentence() {

	}

	// count of pattern matches with 'ab'
	public static void demoExample() {
		String pat = "ab";
		String targetString = "ababbaba";

		Pattern p = Pattern.compile(pat);
		Matcher m = p.matcher(targetString);

		int count = 0;
		while (m.find()) {
			count++;
			System.out.println("start=" + m.start() + ", end=" + m.end() + ", group=" + m.group());
		}
		System.out.println("Total number of occurences : " + count);
	}

	// except alphanumeric symbols
	public static void demoExample2() {
		String pat = "[^a-zA-Z0-9]";
		String targetString = "a7b k@9";

		Pattern p = Pattern.compile(pat);
		Matcher m = p.matcher(targetString);

		while (m.find()) {
			System.out.println("start=" + m.start() + ", end=" + m.end() + ", group=" + m.group());
		}
	}

	// predefined character classes demo
	// except alphanumeric symbols
	public static void demoExample3() {
		String pat = "\\W";
		String targetString = "a7b k@9";

		Pattern p = Pattern.compile(pat);
		Matcher m = p.matcher(targetString);

		while (m.find()) {
			System.out.println("start=" + m.start() + ", end=" + m.end() + ", group=" + m.group());
		}
	}

	// Quantifiers demo
	// one or zero a
	public static void demoExample4() {
		String pat = "a?";
		String targetString = "abaabaaab";

		Pattern p = Pattern.compile(pat);
		Matcher m = p.matcher(targetString);

		while (m.find()) {
			System.out.println("start=" + m.start() + ", end=" + m.end() + ", group=" + m.group());
		}
	}

	// split demo
	public static void demoExample5() {
		String pat = "[.]";
		// or String pat = "\\.";
		String targetString = "www.bookcab.in";

		Pattern p = Pattern.compile(pat);
		String s[] = p.split(targetString);
		for (String s1 : s) {
			System.out.println(s1);
		}
	}

	// StringTokenizer demo
	public static void demoExample6() {
		String targetString = "1985-07-26";
		StringTokenizer st = new StringTokenizer(targetString, "-");
		while (st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}
	}

	// Check for validity of mobile number
	public static void demoExample7() {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			System.out.println("Enter Mobile Number : ");
			String mobile = br.readLine();
			String pat = "(0|91)?[7-9][0-9]{9}";
			Pattern p = Pattern.compile(pat);
			Matcher m = p.matcher(mobile);
			if (m.find() && m.group().equals(mobile)) {
				System.out.println("Valid");
			} else {
				System.out.println("Not vaild");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	// Check for validity of email
	public static void demoExample8() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			System.out.println("Enter Email : ");
			String mobile = br.readLine();
			String pat = "[a-z][a-zA-Z0-9_.]*@[a-zA-Z0-9][[.][a-zA-Z]+]+";
			Pattern p = Pattern.compile(pat);
			Matcher m = p.matcher(mobile);
			if (m.find() && m.group().equals(mobile)) {
				System.out.println("Valid");
			} else {
				System.out.println("Not vaild");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
