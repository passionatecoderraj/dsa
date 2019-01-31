package com.raj.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;

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
     * First keep going forward until you get stuck. That's a good main path already. Remaining tickets form cycles which are found on the way back and get merged into that main path.
     * 
     * https://leetcode.com/problems/reconstruct-itinerary/discuss/78768/Short-Ruby-Python-Java-C++
     */

    public static List<String> findItinerary(String[][] tickets) {
        Map<String, PriorityQueue<String>> map = new HashMap<>();

        // construct graph
        for (String[] ticket : tickets) {
            map.computeIfAbsent(ticket[0], key -> new PriorityQueue<>()).add(ticket[1]);
        }
        LinkedList<String> result = new LinkedList<>();
        Stack<String> stack = new Stack<>();
        stack.push("JFK");
        while (!stack.isEmpty()) {
            while (map.containsKey(stack.peek()) && !map.get(stack.peek()).isEmpty()) {
                stack.push(map.get(stack.peek()).poll());
            }
            result.addFirst(stack.pop());
        }
        return result;
    }

    
     public static List<String> findItinerary2(String[][] tickets) {
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
