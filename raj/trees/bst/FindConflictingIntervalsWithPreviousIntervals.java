package com.raj.trees.bst;

import java.util.ArrayList;
import java.util.List;

import com.raj.nodes.IntervalTreeNode;

/**
 * 
 * @author Raj
 *
 *
 *         Given n appointments, find all conflicting appointments.
 * 
 *         Examples:
 * 
 *         Input: appointments[] = { {1, 5} {3, 7}, {2, 6}, {10, 15}, {5, 6},
 *         {4, 100}} Output: Following are conflicting intervals [3,7] Conflicts
 *         with [1,5] [2,6] Conflicts with [1,5] [5,6] Conflicts with [3,7]
 *         [4,100] Conflicts with [1,5]
 */
public class FindConflictingIntervalsWithPreviousIntervals {

	// Time :O(logn)
	public void findConflictingIntervals(List<IntervalTreeNode> list) {
		if (null == list || list.size() == 0 || list.size() == 1) {
			return;
		}
		IntervalTree tree = new IntervalTree();
		IntervalTreeNode root = null;
		root = tree.insert(root, list.get(0));
		for (int i = 1; i < list.size(); i++) {
			IntervalTreeNode node = list.get(i);
			System.out.println("Intersecting Node " + node + " is :: " + findConflictingIntervals(root, node));
			tree.insert(root, node);
		}
	}

	private boolean doOverlap(IntervalTreeNode i1, IntervalTreeNode i2) {
		return i2.start < i1.end;
	}

	// Time :O(logn)
	public IntervalTreeNode findConflictingIntervals(IntervalTreeNode root, IntervalTreeNode node) {
		if (null == root) {
			return root;
		}
		if (doOverlap(root, node)) {
			return root;
		}
		if (null == root.left || node.start > root.left.max) {
			return findConflictingIntervals(root.right, node);
		}
		return findConflictingIntervals(root.left, node);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		FindConflictingIntervalsWithPreviousIntervals obj = new FindConflictingIntervalsWithPreviousIntervals();

		List<IntervalTreeNode> intervals = new ArrayList<IntervalTreeNode>();
		intervals.add(new IntervalTreeNode(1, 5));
		intervals.add(new IntervalTreeNode(3, 7));
		intervals.add(new IntervalTreeNode(2, 6));
		intervals.add(new IntervalTreeNode(10, 15));
		intervals.add(new IntervalTreeNode(5, 6));
		intervals.add(new IntervalTreeNode(4, 100));
		obj.findConflictingIntervals(intervals);

	}
}
