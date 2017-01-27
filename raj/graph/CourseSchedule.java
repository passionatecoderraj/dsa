package com.raj.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * 
 * @author Raj
 *
 *         There are a total of n courses you have to take, labeled from 0 to n
 *         - 1. Some courses may have prerequisites, for example to take course
 *         0 you have to first take course 1, which is expressed as a pair:
 *         [0,1].
 * 
 *         Given the total number of courses and a list of prerequisite pairs,
 *         is it possible for you to finish all courses?
 * 
 *         For example, given 2 and [[1,0]], there are a total of 2 courses to
 *         take. To take course 1 you should have finished course 0. So it is
 *         possible.
 * 
 *         For another example, given 2 and [[1,0],[0,1]], there are a total of
 *         2 courses to take. To take course 1 you should have finished course
 *         0, and to take course 0 you should also have finished course 1. So it
 *         is impossible.
 * 
 *         http://www.programcreek.com/2014/05/leetcode-course-schedule-java/
 */
public class CourseSchedule {

	public static boolean canFinishUsingBfs(int numCourses, int[][] prereq) {
		if (numCourses == 0 || prereq.length == 0) {
			return true;
		}

		// store courses that have no prerequisites
		int degree[] = new int[numCourses];
		Map<Integer, Set<Integer>> map = new HashMap<>();
		for (int[] a : prereq) {
			if (!map.containsKey(a[1]) || (map.containsKey(a[1]) && !map.get(a[1]).contains(a[0]))) {
				map.compute(a[1], (key, value) -> {
					if (null == value) {
						value = new HashSet<>(0);
					}
					value.add(a[0]);
					return value;
				});
				degree[a[0]]++;
			}
		}

		// store courses that have no prerequisites
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0; i < degree.length; i++)

		{
			if (degree[i] == 0)
				queue.offer(i);
		}

		// number of courses that have no prerequisites
		Set<Integer> visited = new HashSet<>();
		while (!queue.isEmpty())

		{
			int cur = queue.poll();
			visited.add(cur);
			if (map.containsKey(cur)) {
				for (int neighbour : map.get(cur)) {
					degree[neighbour]--;
					if (degree[neighbour] == 0) {
						queue.add(neighbour);
					}
				}
			}
		}

		return visited.size() == numCourses;

	}

	public static boolean canFinishUsingBfs2(int numCourses, int[][] prereq) {
		if (numCourses == 0 || prereq.length == 0) {
			return true;
		}

		// store courses that have no prerequisites
		int pCounter[] = new int[numCourses];
		for (int i = 0; i < pCounter.length; i++) {
			pCounter[prereq[i][0]]++;
		}

		// store courses that have no prerequisites
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0; i < pCounter.length; i++) {
			if (pCounter[i] == 0)
				queue.offer(i);
		}

		// number of courses that have no prerequisites
		int numNoPre = queue.size();

		while (!queue.isEmpty()) {
			int top = queue.poll();
			for (int i = 0; i < prereq.length; i++) {
				if (prereq[i][1] == top) {
					pCounter[prereq[i][0]]--;
					if (pCounter[prereq[i][0]] == 0) {
						numNoPre++;
						queue.offer(prereq[i][0]);
					}
				}
			}
		}
		return numNoPre == numCourses;
	}

	public static boolean canFinishUsingDfs(int numCourses, int[][] prereq) {

		if (numCourses == 0 || prereq.length == 0) {
			return true;
		}

		// use the map to store what courses depend on a course
		Map<Integer, ArrayList<Integer>> map = new HashMap<>();
		for (int a[] : prereq) {
			map.compute(a[1], (key, value) -> {
				if (value == null) {
					value = new ArrayList<Integer>();
				}
				value.add(a[0]);
				return value;
			});
		}
		// visit[i]=0 not yet processed
		// visit[i]=-1 processing
		// visit[i]=1 Already processed
		// track visited courses
		int visit[] = new int[numCourses];
		for (int i = 0; i < numCourses; i++) {
			if (!dfs(i, visit, map)) {
				return false;
			}
		}
		return true;
	}

	private static boolean dfs(int i, int[] visit, Map<Integer, ArrayList<Integer>> map) {
		if (visit[i] == -1)
			return false;
		if (visit[i] == 1)
			return true;

		visit[i] = -1;
		if (map.containsKey(i)) {
			for (int j : map.get(i)) {
				if (!dfs(j, visit, map)) {
					return false;
				}
			}
		}
		visit[i] = 1;
		return true;
	}

	public static void main(String args[]) {
		int n = 4, prereq[][] = { { 1, 0 }, { 2, 0 }, { 3, 1 }, { 3, 2 } };
		boolean result = false;
		result = canFinishUsingBfs(n, prereq);
		System.out.println(result);
		int prereq2[][] = { { 1, 0 }, { 0, 1 } };
		result = canFinishUsingBfs(2, prereq2);
		System.out.println(result);

		int prereq3[][] = { { 5, 8 }, { 3, 5 }, { 1, 9 }, { 4, 5 }, { 0, 2 }, { 1, 9 }, { 7, 8 }, { 4, 9 } };
		result = canFinishUsingBfs(10, prereq3);
		System.out.println(result);

	}
}
