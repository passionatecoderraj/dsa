package com.raj.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * @author Raj
 *
 *         here are a total of n courses you have to take, labeled from 0 to n -
 *         1.
 * 
 *         Some courses may have prerequisites, for example to take course 0 you
 *         have to first take course 1, which is expressed as a pair: [0,1]
 * 
 *         Given the total number of courses and a list of prerequisite pairs,
 *         return the ordering of courses you should take to finish all courses.
 * 
 *         There may be multiple correct orders, you just need to return one of
 *         them. If it is impossible to finish all courses, return an empty
 *         array.
 * 
 *         For example:
 * 
 *         2, [[1,0]] There are a total of 2 courses to take. To take course 1
 *         you should have finished course 0. So the correct course order is
 *         [0,1]
 * 
 *         4, [[1,0],[2,0],[3,1],[3,2]] There are a total of 4 courses to take.
 *         To take course 3 you should have finished both courses 1 and 2. Both
 *         courses 1 and 2 should be taken after you finished course 0. So one
 *         correct course order is [0,1,2,3]. Another correct ordering
 *         is[0,2,1,3].
 * 
 *         Note: The input prerequisites is a graph represented by a list of
 *         edges, not adjacency matrices. Read more about how a graph is
 *         represented.
 * 
 *         http://www.programcreek.com/2014/06/leetcode-course-schedule-ii-java/
 */
public class CourseSchedule2 {

	public static int[] canFinishUsingBfs(int numCourses, int[][] prereq) {
		if (numCourses == 0) {
			return new int[0];
		}
		int res[] = new int[numCourses];

		if (prereq.length == 0) {
			for (int i = 0; i < res.length; i++) {
				res[i] = i;
			}
			return res;
		}

		// store courses with number of prerequisites
		int pCounter[] = new int[numCourses];
		for (int i = 0; i < pCounter.length; i++) {
			pCounter[prereq[i][0]]++;
		}

		// store courses that have no prerequisites in queue
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0; i < pCounter.length; i++) {
			if (pCounter[i] == 0) {
				queue.offer(i);
			}
		}

		// number of courses that have no prerequisites
		int numNoPre = queue.size();
		int idx = 0;
		while (!queue.isEmpty()) {
			int top = queue.poll();
			res[idx++] = top;
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
		return (numNoPre == numCourses) ? res : new int[0];
	}

	public static void main(String args[]) {
		int n = 4, prereq[][] = { { 1, 0 }, { 2, 0 }, { 3, 1 }, { 3, 2 } };
		int[] result = null;
		result = canFinishUsingBfs(n, prereq);
		System.out.println(Arrays.toString(result));
		int prereq2[][] = { { 1, 0 }, { 0, 1 } };
		result = canFinishUsingBfs(2, prereq2);
		System.out.println(Arrays.toString(result));
	}
}
