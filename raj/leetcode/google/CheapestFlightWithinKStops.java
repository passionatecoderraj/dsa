package com.raj.leetcode.google;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 
 * @author Raj
 * 
 * There are n cities connected by m flights. Each fight starts from city u and arrives at v with a price w.

Now given all the cities and fights, together with starting city src and the destination dst, your task is to find the cheapest price from src to dst with up to k stops. If there is no such route, output -1.

Example 1:
Input: 
n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
src = 0, dst = 2, k = 1
Output: 200
Explanation: 
The graph looks like this:


The cheapest price from city 0 to city 2 with at most 1 stop costs 200, as marked red in the picture.
Example 2:
Input: 
n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
src = 0, dst = 2, k = 0
Output: 500
Explanation: 
The graph looks like this:


The cheapest price from city 0 to city 2 with at most 0 stop costs 500, as marked blue in the picture.
Note:

The number of nodes n will be in range [1, 100], with nodes labeled from 0 to n - 1.
The size of flights will be in range [0, n * (n - 1) / 2].
The format of each flight will be (src, dst, price).
The price of each flight will be in the range [1, 10000].
k is in the range of [0, n - 1].
There will not be any duplicated flights or self cycles.
 * 
 */
public class CheapestFlightWithinKStops {

	// https://leetcode.com/problems/cheapest-flights-within-k-stops/discuss/115541/Easy-and-Concise-Solution-Using-Priority-Queue-JavaPython
	public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
		Map<Integer, Map<Integer, Integer>> edges = new HashMap<>();
		for (int[] flight : flights) {
			edges.compute(flight[0], (k, v) -> {
				if (null == v) {
					v = new HashMap<>();
				}
				v.put(flight[1], flight[2]);
				return v;
			});
		}
		class Node {
			int vertex;
			int price;
			int noOfStops;

			public Node(int vertex, int price, int noOfStops) {
				this.vertex = vertex;
				this.price = price;
				this.noOfStops = noOfStops;
			}

		}
		PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> n1.price - n2.price);
		pq.offer(new Node(src, 0, K));
		while (!pq.isEmpty()) {
			Node cur = pq.poll();
			if (cur.vertex == dst)
				return cur.price;
			if (cur.noOfStops >= 0) {
				Map<Integer, Integer> adj = edges.get(cur.vertex);
				for (int to : adj.keySet()) {
					pq.offer(new Node(to, cur.price + adj.get(to), cur.noOfStops - 1));
				}
			}
		}
		return -1;
	}

	public static void main(String... args) {
		CheapestFlightWithinKStops obj = new CheapestFlightWithinKStops();
		int[][] flights = { { 0, 1, 100 }, { 1, 2, 100 }, { 0, 2, 500 } };
		int n = 3, src = 0, dst = 2, k = 1;
		int res = -1;

		res = obj.findCheapestPrice(n, flights, src, dst, k);
		System.out.println(res);

		k = 0;
		res = obj.findCheapestPrice(n, flights, src, dst, k);
		System.out.println(res);

	}
}