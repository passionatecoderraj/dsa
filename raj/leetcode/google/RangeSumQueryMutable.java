package com.raj.leetcode.google;

import java.util.LinkedList;
import java.util.Queue;

import com.raj.nodes.SegmentTreeNode;

/**
 * 
 * @author Raj
 * 
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

The update(i, val) function modifies nums by updating the element at index i to val.

Example:

Given nums = [1, 3, 5]

sumRange(0, 2) -> 9
update(1, 2)
sumRange(0, 2) -> 8
Note:

The array is only modifiable by the update function.
You may assume the number of calls to update and sumRange function is distributed evenly.

 */

class SegmentTreeForRangeSumUsingTree {

	SegmentTreeNode root = null;

	public void create(int a[]) {
		this.root = createUtil(a, 0, a.length - 1);
	}

	private SegmentTreeNode createUtil(int[] a, int start, int end) {
		if (start > end)
			return null;

		SegmentTreeNode root = new SegmentTreeNode(start, end);
		// make leaf nodes with value
		if (start == end) {
			root.val = a[start];
			return root;
		}

		int mid = start + (end - start) / 2;
		root.left = createUtil(a, start, mid);
		root.right = createUtil(a, mid + 1, end);
		root.val = root.left.val + root.right.val;
		return root;
	}

	public void update(int index, int val) {
		updateUtil(root, index, val);
	}

	private int updateUtil(SegmentTreeNode root, int index, int val) {
		// no overlap
		if (root.start > index || index > root.end)
			return root.val;
		// complete overlap
		if (index == root.start && index == root.end) {
			root.val = val;
			return root.val;
		}
		root.val = (updateUtil(root.left, index, val) + updateUtil(root.right, index, val));
		return root.val;
	}

	public int rangeSumQuery(int qlow, int qhigh) {
		return rangeUtil(this.root, qlow, qhigh);
	}

	private int rangeUtil(SegmentTreeNode root, int qlow, int qhigh) {
		// no overlap
		if (root.start > qhigh || qlow > root.end)
			return 0;

		// complete overlap
		if (qlow <= root.start && qhigh >= root.end)
			return root.val;
		return rangeUtil(root.left, qlow, qhigh) + rangeUtil(root.right, qlow, qhigh);
	}

	void print() {
		Queue<SegmentTreeNode> q = new LinkedList<>();
		q.offer(this.root);
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				SegmentTreeNode temp = q.poll();
				System.out.println(temp);
				if (temp.left != null)
					q.offer(temp.left);
				if (temp.right != null)
					q.offer(temp.right);
			}
			System.out.println("-----");
		}
	}

}

public class RangeSumQueryMutable {
	SegmentTreeForRangeSumUsingTree st;

	public RangeSumQueryMutable(int[] nums) {
		st = new SegmentTreeForRangeSumUsingTree();
		st.create(nums);
	}

	public void update(int i, int val) {
		st.update(i, val);
	}

	public int sumRange(int i, int j) {
		return st.rangeSumQuery(i, j);
	}

	public static void main(String[] args) {
		SegmentTreeForRangeSumUsingTree obj = new SegmentTreeForRangeSumUsingTree();
		int[] a = { -1, 3, 0, 6 };

		int result = -1;
		obj.create(a);
		result = obj.rangeSumQuery(0, 2);
		// System.out.println(result);
		obj.update(2, -4);
		obj.print();
		result = obj.rangeSumQuery(0, 2);
		System.out.println(result);

		int a2[] = { 0, 3, 4, 2, 1, 6, -1 };

		RangeSumQueryMutable ob = new RangeSumQueryMutable(a2);
		result = ob.sumRange(0, 2);
		System.out.println(result);
		ob.update(2, -1);
		result = ob.sumRange(0, 2);
		System.out.println(result);

	}

}
