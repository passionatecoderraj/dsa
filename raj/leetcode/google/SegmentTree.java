package com.raj.leetcode.google;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import com.raj.nodes.SegmentTreeNode;

/**
 * 
 * @author Raj
 * 
 * 
 */

class SegmentTreeForRangeMinUsingTree {

	SegmentTreeNode root = null;

	public void create(int a[]) {
		this.root = createUtil(a, 0, a.length - 1);
	}

	private SegmentTreeNode createUtil(int[] a, int start, int end) {
		if (start > end)
			return null;

		SegmentTreeNode root = new SegmentTreeNode(start, end);
		if (start == end) {
			root.val = a[start];
			return root;
		}
		int mid = start + (end - start) / 2;
		root.left = createUtil(a, start, mid);
		root.right = createUtil(a, mid + 1, end);
		root.val = Math.min(root.left.val, root.right.val);
		return root;
	}

	public void update(int index, int val) {
		updateUtil(root, index, val);
	}

	private int updateUtil(SegmentTreeNode root, int index, int val) {
		// no overlap
		if (root.start > index || index > root.end)
			return Integer.MAX_VALUE;
		if (index == root.start && index == root.end) {
			root.val = val;
			return root.val;
		}
		root.val = Math.min(updateUtil(root.left, index, val), updateUtil(root.right, index, val));
		return root.val;
	}

	public int rangeSumQuery(int qlow, int qhigh) {
		return rangeUtil(this.root, qlow, qhigh);
	}

	private int rangeUtil(SegmentTreeNode root, int qlow, int qhigh) {
		// no overlap
		if (root.start > qhigh || qlow > root.end)
			return Integer.MAX_VALUE;
		// total overlap
		if (qlow <= root.start && qhigh >= root.end)
			return root.val;
		return Math.min(rangeUtil(root.left, qlow, qhigh), rangeUtil(root.right, qlow, qhigh));
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

class SegmentTreeRangeMinimumUsingArray {

	public int[] createSegmentTree(int a[]) {
		int n = new NextPowerOf2().getNextPowerOf2(a.length);
		int size = (n * 2) - 1;
		int[] segmentTree = new int[size];
		createUtil(segmentTree, a, 0, a.length - 1, 0);
		return segmentTree;
	}

	private void createUtil(int[] segmentTree, int a[], int low, int high, int pos) {
		if (low > high)
			return;
		if (low == high) {
			segmentTree[pos] = a[low];
			return;
		}
		int mid = low + (high - low) / 2;
		createUtil(segmentTree, a, low, mid, 2 * pos + 1);
		createUtil(segmentTree, a, mid + 1, high, 2 * pos + 2);
		segmentTree[pos] = Math.min(2 * pos + 1, 2 * pos + 2);
	}

	public void updateSegmentTree(int a[], int segmentTree[], int index, int delta) {
		a[index] += delta;
		updateSegmentTreeUtil(segmentTree, index, delta, 0, a.length - 1, 0);
	}

	private void updateSegmentTreeUtil(int segmentTree[], int index, int delta, int low, int high, int pos) {

		// if index to be updated is less than low or higher than high just return.
		if (index < low || index > high) {
			return;
		}

		// if low and high become equal, then index will be also equal to them and
		// update
		// that value in segment tree at pos
		if (low == high) {
			segmentTree[pos] += delta;
			return;
		}
		// otherwise keep going left and right to find index to be updated
		// and then update current tree position if min of left or right has
		// changed.
		int mid = (low + high) / 2;
		updateSegmentTreeUtil(segmentTree, index, delta, low, mid, 2 * pos + 1);
		updateSegmentTreeUtil(segmentTree, index, delta, mid + 1, high, 2 * pos + 2);
		segmentTree[pos] = Math.min(segmentTree[2 * pos + 1], segmentTree[2 * pos + 2]);
	}

	public int rangeMinimumQuery(int segmentTree[], int qlow, int qhigh, int len) {
		return rangeUtil(segmentTree, 0, len - 1, qlow, qhigh, 0);
	}

	private int rangeUtil(int[] segmentTree, int low, int high, int qlow, int qhigh, int pos) {
		if (qlow <= low && qhigh >= high)
			return segmentTree[pos];
		if (low > qhigh || qlow > high)
			return Integer.MAX_VALUE;
		int mid = low + (high - low) / 2;
		return Math.min(rangeUtil(segmentTree, low, mid, qlow, qhigh, 2 * pos + 1),
				rangeUtil(segmentTree, mid + 1, high, qlow, qhigh, 2 * pos + 2));
	}

	class NextPowerOf2 {
		public int getNextPowerOf2(int n) {
			int count = 0;

			// First n in the below
			// condition is for the
			// case where n is 0
			if (n > 0 && (n & (n - 1)) == 0)
				return n;

			while (n != 0) {
				n >>= 1;
				count += 1;
			}

			return 1 << count;
		}
	}
}

public class SegmentTree {

	public static void main(String[] args) {
		SegmentTreeRangeMinimumUsingArray obj = new SegmentTreeRangeMinimumUsingArray();
		int[] a = { -1, 3, 0, 6 };
		int[] segmentTree = obj.createSegmentTree(a);
		System.out.println(Arrays.toString(segmentTree));
		int result = -1;
		result = obj.rangeMinimumQuery(segmentTree, 0, 2, a.length);
		System.out.println(result);
		obj.updateSegmentTree(a, segmentTree, 2, -4);
		System.out.println(Arrays.toString(segmentTree));

		result = obj.rangeMinimumQuery(segmentTree, 0, 2, a.length);
		System.out.println(result);

		SegmentTreeForRangeMinUsingTree ob = new SegmentTreeForRangeMinUsingTree();
		ob.create(new int[] { -1, 3, 0, -2 });
		result = ob.rangeSumQuery(0, 2);
		System.out.println(result);
		ob.update(2, -4);
		result = ob.rangeSumQuery(0, 2);
		System.out.println(result);
		
	}

}
