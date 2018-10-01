package com.raj.nodes;

public class SegmentTreeNode {
	public int start;
	public int end;
	public SegmentTreeNode left;
	public SegmentTreeNode right;
	public int val;

	public SegmentTreeNode(int start, int end) {
		this.start = start;
		this.end = end;
	}

	@Override
	public String toString() {
		return "Node [start=" + start + ", end=" + end + ", val=" + val + "]";
	}

}