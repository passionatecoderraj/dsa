/**
 * 
 */
package com.raj.leetcode;

import java.util.Arrays;

import com.interview.graph.CommonUtil;

/**
 * @author Raj
 *
 * LeetCode wants to give one of its best employees the option to travel among N cities to collect algorithm problems. But all work and no play makes Jack a dull boy, you could take vacations in some particular cities and weeks. Your job is to schedule the traveling to maximize the number of vacation days you could take, but there are certain rules and restrictions you need to follow.

Rules and restrictions:
You can only travel among N cities, represented by indexes from 0 to N-1. Initially, you are in the city indexed 0 on Monday.
The cities are connected by flights. The flights are represented as a N*N matrix (not necessary symmetrical), called flights representing the airline status from the city i to the city j. If there is no flight from the city i to the city j, flights[i][j] = 0; Otherwise, flights[i][j] = 1. Also, flights[i][i] = 0 for all i.
You totally have K weeks (each week has 7 days) to travel. You can only take flights at most once per day and can only take flights on each week's Monday morning. Since flight time is so short, we don't consider the impact of flight time.
For each city, you can only have restricted vacation days in different weeks, given an N*K matrix called days representing this relationship. For the value of days[i][j], it represents the maximum days you could take vacation in the city i in the week j.
You're given the flights matrix and days matrix, and you need to output the maximum vacation days you could take during K weeks.

Example 1:
Input:flights = [[0,1,1],[1,0,1],[1,1,0]], days = [[1,3,1],[6,0,3],[3,3,3]]
Output: 12
Explanation: 
Ans = 6 + 3 + 3 = 12. 

One of the best strategies is:
1st week : fly from city 0 to city 1 on Monday, and play 6 days and work 1 day. 
(Although you start at city 0, we could also fly to and start at other cities since it is Monday.) 
2nd week : fly from city 1 to city 2 on Monday, and play 3 days and work 4 days.
3rd week : stay at city 2, and play 3 days and work 4 days.
Example 2:
Input:flights = [[0,0,0],[0,0,0],[0,0,0]], days = [[1,1,1],[7,7,7],[7,7,7]]
Output: 3
Explanation: 
Ans = 1 + 1 + 1 = 3. 

Since there is no flights enable you to move to another city, you have to stay at city 0 for the whole 3 weeks. 
For each week, you only have one day to play and six days to work. 
So the maximum number of vacation days is 3.
Example 3:
Input:flights = [[0,1,1],[1,0,1],[1,1,0]], days = [[7,0,0],[0,7,0],[0,0,7]]
Output: 21
Explanation:
Ans = 7 + 7 + 7 = 21

One of the best strategies is:
1st week : stay at city 0, and play 7 days. 
2nd week : fly from city 0 to city 1 on Monday, and play 7 days.
3rd week : fly from city 1 to city 2 on Monday, and play 7 days.
Note:
N and K are positive integers, which are in the range of [1, 100].
In the matrix flights, all the values are integers in the range of [0, 1].
In the matrix days, all the values are integers in the range [0, 7].
You could stay at a city beyond the number of vacation days, but you should work on the extra days, which won't be counted as vacation days.
If you fly from the city A to the city B and take the vacation on that day, the deduction towards vacation days will count towards the vacation days of city B in that week.
We don't consider the impact of flight hours towards the calculation of vacation days.

 */
public class MaximumVacationDays {

	public int maxVacationDays(int[][] flights, int[][] days) {
		int N = flights.length;
		int K = days[0].length;
		int[] t = new int[N];
		Arrays.fill(t, Integer.MIN_VALUE);
		t[0] = 0;

		for (int week = 0; week < K; week++) {
			int[] temp = new int[N];
			Arrays.fill(temp, Integer.MIN_VALUE);
			for (int cur_city = 0; cur_city < N; cur_city++) {
				for (int dest_city = 0; dest_city < N; dest_city++) {
					if (cur_city == dest_city || flights[dest_city][cur_city] == 1) {
						temp[cur_city] = Math.max(temp[cur_city], t[dest_city] + days[cur_city][week]);
					}
				}
			}
			t = temp;
		}

		int max = 0;
		for (int v : t) {
			max = Math.max(max, v);
		}

		return max;
	}

	public int maxVacationDays2(int[][] flights, int[][] days) {
		if (days.length == 0 || flights.length == 0)
			return 0;
		int N = flights.length;
		int K = days[0].length;
		int t[][] = new int[K + 1][N];
		for (int week = 1; week <= K; week++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (i == j || flights[i][j] == 1) {
						t[week][j] = Math.max(days[j][week - 1] + t[week - 1][j], t[week][j]);
					}
				}
			}
		}
		CommonUtil.print2DArray(t, K + 1, N);
		int max = 0;
		for (int i = 0; i < N; i++) {
			max = Math.max(t[K][i], max);
		}
		return max;
	}

	int max = 0, N, K;

	public int maxVacationDays_Bruteforce(int[][] flights, int[][] days) {
		if (days.length == 0 || flights.length == 0)
			return 0;
		N = flights.length;
		K = days[0].length;
		util(0, 0, 0, flights, days);
		return max;
	}

	private void util(int cur_city, int week, int total_vacation_days, int[][] flights, int[][] days) {
		if (week == K) {
			max = Math.max(max, total_vacation_days);
			return;
		}
		for (int dest_city = 0; dest_city < flights.length; dest_city++) {
			if (cur_city == dest_city || flights[cur_city][dest_city] == 1) {
				util(dest_city, week + 1, total_vacation_days + days[dest_city][week], flights, days);
			}
		}
	}

	// https://leetcode.com/problems/maximum-vacation-days/solution/
	// Time : O(n*n*k), Space : O(n),n=no. of days, k=no. of weeks
	public int maxVacationDays3(int[][] flights, int[][] days) {
		if (days.length == 0 || flights.length == 0)
			return 0;
		int m = flights.length, n = days[0].length;
		int t[] = new int[m];
		for (int week = n - 1; week >= 0; week--) {
			int temp[] = new int[m];
			for (int cur_city = 0; cur_city < m; cur_city++) {
				int max = days[cur_city][week] + t[cur_city];
				for (int dest_city = 0; dest_city < m; dest_city++) {
					if (flights[cur_city][dest_city] == 1) {
						max = Math.max(max, days[dest_city][week] + t[dest_city]);
					}
				}
				temp[cur_city] = max;
			}
			t = temp;
		}
		return t[0];
	}

	// Time : O(n*n*k), Space : O(n*k),n=no. of days, k=no. of weeks
	public int maxVacationDays4(int[][] flights, int[][] days) {
		if (days.length == 0 || flights.length == 0)
			return 0;
		int m = flights.length, n = days[0].length;
		int t[][] = new int[m][n + 1];
		for (int week = n - 1; week >= 0; week--) {
			for (int cur_city = 0; cur_city < m; cur_city++) {
				int max = days[cur_city][week] + t[cur_city][week + 1];
				for (int dest_city = 0; dest_city < m; dest_city++) {
					if (flights[cur_city][dest_city] == 1) {
						max = Math.max(max, days[dest_city][week] + t[dest_city][week + 1]);
					}
				}
				t[cur_city][week] = max;
			}
			CommonUtil.print2DArray(t, m, n + 1);
		}
		return t[0][0];
	}

	public static void main(String[] args) {
		MaximumVacationDays obj = new MaximumVacationDays();
		int[][] flights = { { 0, 1, 1 }, { 1, 0, 1 }, { 1, 1, 0 } }, days = { { 1, 3, 1 }, { 6, 0, 3 }, { 3, 3, 3 } };

		int res = -1;
		res = obj.maxVacationDays(flights, days);
		System.out.println(res);

	}

}
