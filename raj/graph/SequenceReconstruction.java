package com.raj.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * 
 * @author Raj
 *
 *         Check whether the original sequence org can be uniquely reconstructed
 *         from the sequences in seqs. The org sequence is a permutation of the
 *         integers from 1 to n, with 1 ≤ n ≤ 104. Reconstruction means building
 *         a shortest common supersequence of the sequences in seqs (i.e., a
 *         shortest sequence so that all sequences in seqs are subsequences of
 *         it). Determine whether there is only one sequence that can be
 *         reconstructed from seqs and it is the org sequence.
 * 
 *         Example 1:
 * 
 *         Input: org: [1,2,3], seqs: [[1,2],[1,3]]
 * 
 *         Output: false
 * 
 *         Explanation: [1,2,3] is not the only one sequence that can be
 *         reconstructed, because [1,3,2] is also a valid sequence that can be
 *         reconstructed.
 * 
 *         Example 2:
 * 
 *         Input: org: [1,2,3], seqs: [[1,2]]
 * 
 *         Output: false
 * 
 *         Explanation: The reconstructed sequence can only be [1,2]. Example 3:
 * 
 *         Input: org: [1,2,3], seqs: [[1,2],[1,3],[2,3]]
 * 
 *         Output: true
 * 
 *         Explanation: The sequences [1,2], [1,3], and [2,3] can uniquely
 *         reconstruct the original sequence [1,2,3]. Example 4:
 * 
 *         Input: org: [4,1,5,2,6,3], seqs: [[5,2,6,3],[4,1,5,2]]
 * 
 *         Output: true
 *         
 *         https://discuss.leetcode.com/topic/65948/java-solution-using-bfs-topological-sort/2
 */
public class SequenceReconstruction {

	public static boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
		Map<Integer, Integer> degree = new HashMap<>();
		for (int i : org) {
			degree.put(i, 0);
		}

		Map<Integer, Set<Integer>> map = new HashMap<>();
		for (List<Integer> seq : seqs) {
			if (seq.size() == 1) {
				map.put(seq.get(0), new HashSet<>());
				continue;
			}
			// if seq size > 1
			for (int i = 0; i < seq.size() - 1; i++) {
				int cur = seq.get(i), next = seq.get(i + 1);
				if (!map.containsKey(cur) || !map.get(cur).contains(next)) {
					map.compute(cur, (key, value) -> {
						if (null == value) {
							value = new HashSet<>();
						}
						value.add(next);
						return value;
					});
					degree.put(next, degree.get(next) + 1);
				}
			}
		}

		Queue<Integer> queue = new LinkedList<>();
		for (int key : degree.keySet()) {
			if (0 == degree.get(key)) {
				queue.offer(key);
			}
		}

		int index = 0;
		while (!queue.isEmpty()) {
			if (queue.size() > 1) {
				return false;
			}
			int cur = queue.poll();
			System.out.print(cur + " ");
			if (index == org.length || org[index++] != cur)
				return false;
			if (map.containsKey(cur)) {
				for (int neighbour : map.get(cur)) {
					degree.compute(neighbour, (key, value) -> {
						return value - 1;
					});
					if (0 == degree.get(neighbour)) {
						queue.offer(neighbour);
					}
				}

			}
		}
		return index == org.length;
	}

	public static void main(String[] args) {
		boolean result = false;
		int[] org = { 1, 2, 3 };
		List<List<Integer>> seqs = new ArrayList<>();
		Integer[] s11 = { 1, 2 };
		Integer[] s12 = { 1, 3 };
		Integer[] s13 = { 2, 3 };
		seqs.add(Arrays.asList(s11));
		seqs.add(Arrays.asList(s12));
		seqs.add(Arrays.asList(s13));
		result = sequenceReconstruction(org, seqs);
		System.out.println(result);

		seqs.clear();
		seqs.add(Arrays.asList(s11));
		seqs.add(Arrays.asList(s12));
		result = sequenceReconstruction(org, seqs);
		System.out.println(result);

		int[] org2 = { 4, 1, 5, 2, 6, 3 };
		Integer[] s21 = { 4, 1, 5, 2 };
		Integer[] s22 = { 5, 2, 6, 3 };
		seqs.clear();
		seqs.add(Arrays.asList(s21));
		seqs.add(Arrays.asList(s22));
		result = sequenceReconstruction(org2, seqs);
		System.out.println(result);

	}

}
