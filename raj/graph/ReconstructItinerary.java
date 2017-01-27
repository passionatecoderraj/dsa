package com.raj.graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 
 * @author Raj
 *
 *         Given a list of airline tickets represented by pairs of departure and
 *         arrival airports [from, to], reconstruct the itinerary in order. All
 *         of the tickets belong to a man who departs from JFK. Thus, the
 *         itinerary must begin with JFK.
 * 
 *         Note: If there are multiple valid itineraries, you should return the
 *         itinerary that has the smallest lexical order when read as a single
 *         string.
 * 
 *         For example, the itinerary ["JFK", "LGA"] has a smaller lexical order
 *         than ["JFK", "LGB"]. All airports are represented by three capital
 *         letters (IATA code). You may assume all tickets form at least one
 *         valid itinerary.
 * 
 *         Example 1: tickets = [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"],
 *         ["LHR", "SFO"]]
 * 
 *         Return ["JFK", "MUC", "LHR", "SFO", "SJC"].
 * 
 *         Example 2: tickets =
 *         [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"
 *         ]]
 * 
 *         Return ["JFK","ATL","JFK","SFO","ATL","SFO"]. Another possible
 *         reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"]. But it is
 *         larger in lexical order.
 */
public class ReconstructItinerary {

	/*
	 * In graph theory, an Eulerian trail (or Eulerian path) is a trail in a
	 * graph which visits every edge exactly once. Similarly, an Eulerian
	 * circuit or Eulerian cycle is an Eulerian trail which starts and ends on
	 * the same vertex.
	 */
	public static List<String> findItinerary(String[][] tickets) {
		Map<String, PriorityQueue<String>> map = new HashMap<>();

		// construct graph
		for (String[] ticket : tickets) {
			map.computeIfAbsent(ticket[0], key -> new PriorityQueue<>()).add(ticket[1]);
		}
		LinkedList<String> result = new LinkedList<>();
		dfs("JFK", result, map);
		return result;
	}

	private static void dfs(String cur, LinkedList<String> result, Map<String, PriorityQueue<String>> map) {
		if (map.containsKey(cur))
			while (!map.get(cur).isEmpty()) {
				String neighbour = map.get(cur).poll();
				dfs(neighbour, result, map);
			}
		result.addFirst(cur);
	}

	public static void main(String[] args) {
		String tickets[][] = { { "MUC", "LHR" }, { "JFK", "MUC" }, { "SFO", "SJC" }, { "LHR", "SFO" } };
		List<String> result = null;

		result = findItinerary(tickets);
		System.out.println(result);

		String tickets2[][] = { { "JFK", "SFO" }, { "JFK", "ATL" }, { "SFO", "ATL" }, { "ATL", "JFK" },
				{ "ATL", "SFO" } };
		result = findItinerary(tickets2);
		System.out.println(result);

		String tickets3[][] = { { "JFK", "KUL" }, { "JFK", "NRT" }, { "NRT", "JFK" } };
		result = findItinerary(tickets3);
		System.out.println(result);
		// if we use array list insted of linked list output is wrong
		// correct output : [JFK, NRT, JFK, KUL]
		// wrong output : [JFK,KUL,NRT,JFK]

	}

}
