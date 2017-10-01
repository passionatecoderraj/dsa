/**
 * 
 */
package com.raj.mathamatical;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author Raj
 *
 *         Given two dates, find total number of days between them. The count of
 *         days must be calculated in O(1) time and O(1) auxiliary space.
 * 
 *         Examples:
 * 
 *         Input: dt1 = {10, 2, 2014} dt2 = {10, 3, 2015} Output: 393 dt1
 *         represents "10-Feb-2014" and dt2 represents "10-Mar-2015" The
 *         difference is 365 + 28
 * 
 *         Input: dt1 = {10, 2, 2000} dt2 = {10, 3, 2000} Output: 29 Note that
 *         2000 is a leap year
 * 
 *         Input: dt1 = {10, 2, 2000} dt2 = {10, 2, 2000} Output: 0 Both dates
 *         are same
 * 
 *         Input: dt1 = {1, 2, 2000}; dt2 = {1, 2, 2004}; Output: 1461 Number of
 *         days is 365*4 + 1
 * 
 * 
 * 
 */
public class NumberOfDaysBetweenTwoDates {

	// http://www.geeksforgeeks.org/find-number-of-days-between-two-given-dates/
	// Time : O(1), Space :O(1)
	public int getDifference(Date dt1, Date dt2) {
		return getDays(dt1) - getDays(dt2);
	}

	private int getDays(Date dt) {
		int monthDays[] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

		// initialize count using years and day
		int days = dt.getYear() * 365;

		// count using day
		days += dt.getDate();

		// Add days for months in given date
		for (int i = 0; i < dt.getMonth(); i++) {
			days += monthDays[i];
		}

		// Since every leap year is of 366 days,
		// Add a day for every leap year
		days += countLeapYears(dt);

		return days;
	}

	private int countLeapYears(Date dt) {
		int years = dt.getYear();

		// Check if the current year needs to be considered
		// for the count of leap years or not
		if (dt.getMonth() <= 2) {
			years--;
		}

		// An year is a leap year if it is a multiple of 4,
		// multiple of 400 and not a multiple of 100.
		return (years / 4) - (years / 100) + (years / 400);
	}

	public static void main(String[] args) {
		// new Date(year, month, day), month: 0 index
		Date dt1 = new Date(2004, 0, 1); // 2004 Jan 1st
		Date dt2 = new Date(2004, 1, 1);// 2004 Feb 1st
		int result = -1;
		NumberOfDaysBetweenTwoDates obj = new NumberOfDaysBetweenTwoDates();
		result = obj.getDifference(dt2, dt1);
		System.out.println(result);
	}

}
