/**
 * 
 */
package com.raj.leetcode.google;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * @author Raj 
 * 
 * We have a list of bus routes. Each routes[i] is a bus route that the i-th bus repeats forever. For example if routes[0] = [1, 5, 7], this means that the first bus (0-th indexed) travels in the sequence 1->5->7->1->5->7->1->... forever.

We start at bus stop S (initially not on a bus), and we want to go to bus stop T. Travelling by buses only, what is the least number of buses we must take to reach our destination? Return -1 if it is not possible.

Example:
Input: 
routes = [[1, 2, 7], [3, 6, 7]]
S = 1
T = 6
Output: 2
Explanation: 
The best strategy is take the first bus to the bus stop 7, then take the second bus to the bus stop 6.
Note:

1 <= routes.length <= 500.
1 <= routes[i].length <= 500.
0 <= routes[i][j] < 10 ^ 6.

 */
public class BusRoutes {

	public int numBusesToDestination(int[][] routes, int S, int T) {
		if (S == T)
			return 0;
		// bus stop to buses map
		Map<Integer, ArrayList<Integer>> map = new HashMap<>();
		for (int i = 0; i < routes.length; i++) {
			for (int j = 0; j < routes[i].length; j++) {
				if (!map.containsKey(routes[i][j])) {
					map.put(routes[i][j], new ArrayList<>());
				}
				map.get(routes[i][j]).add(i);
			}
		}
		int res = 0;
		Set<Integer> visited = new HashSet<>();
		Queue<Integer> q = new LinkedList<>();
		q.offer(S);
		while (!q.isEmpty()) {
			int size = q.size();
			res++;
			for (int i = 0; i < size; i++) {
				int stop = q.poll();
				ArrayList<Integer> buses = map.get(stop);
				for (int bus : buses) {
					if (visited.contains(bus))
						continue;
					visited.add(bus);
					for (int j = 0; j < routes[bus].length; j++) {
						if (routes[bus][j] == T)
							return res;
						q.offer(routes[bus][j]);
					}
				}

			}
		}
		return -1;
	}

	public static void main(String[] args) {
		BusRoutes obj = new BusRoutes();
		int result = -1;
		int routes[][] = { { 1, 2, 7 }, { 3, 6, 7 } };
		result = obj.numBusesToDestination(routes, 1, 6);
		System.out.println(result);

	}

}
