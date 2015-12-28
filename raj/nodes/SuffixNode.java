/**
 * 
 */
package com.raj.nodes;

/**
 * @author Raj
 *
 */
public class SuffixNode {
	private static final int TOTAL = 256;

	public int start;
	public End end;
	public int index;
	public SuffixNode suffixLink;
	public SuffixNode child[] = new SuffixNode[TOTAL];

	public SuffixNode(int start, End end) {
		super();
		this.start = start;
		this.end = end;
	}

	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		int i = 0;
		for (SuffixNode node : child) {
			if (node != null) {
				buffer.append((char) i + " ");
			}
			i++;
		}
		return "SuffixNode [start=" + start + "]" + " " + buffer.toString();
	}
}
