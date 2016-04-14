/**
 * 
 */
package com.raj.patternmatching;

import com.raj.nodes.End;
import com.raj.nodes.SuffixNode;

/**
 * @author Raj
 *
 */
public class SuffixTree {

	public static void main(String args[]) {
		String str = "abc";
		SuffixTree st = new SuffixTree();
		st.build(str.toCharArray());
	}

	private static char UNIQUE_CHAR = '$';
	private SuffixNode root;
	private Active active;
	private End end;
	private int remainingSuffixesToBeBuilt;
	private char[] input;

	public void build(char[] a) {
		input = new char[a.length + 1];
		for (int i = 0; i < a.length; i++) {
			input[i] = a[i];
		}
		input[a.length] = UNIQUE_CHAR;

		// initialization
		root = new SuffixNode(1, new End(0));
		root.index = -1;

		remainingSuffixesToBeBuilt = 0;
		active = new Active(root);
		this.end = new End(-1);
		// loop through all indices
		for (int i = 0; i < input.length; i++) {
			startPhase(i);
		}
		System.out.println(root);
	}

	/**
	 * @param input
	 * @param i
	 */
	private void startPhase(int i) {
		end.end++;
		remainingSuffixesToBeBuilt++;
		while (remainingSuffixesToBeBuilt > 0) {
			// if active length is 0 then look for current character from root.
			if (active.activeLength == 0) {

				SuffixNode node = selectNode(i);
				if (node != null) {
					active.activeEdge = node.start;
					remainingSuffixesToBeBuilt++;
				} else {
					root.child[input[i]] = new SuffixNode(i, end);
					remainingSuffixesToBeBuilt--;
				}
			}
			// if active length is not 0 means we are traversing somewhere in
			// middle. So check if next character is same as current character.
			else {

			}
		}
	}

	private SuffixNode selectNode(int index) {
		return active.activeNode.child[index];
	}
}

class Active {
	int activeLength;
	int activeEdge;
	SuffixNode activeNode;

	public Active(SuffixNode activeNode) {
		this.activeNode = activeNode;
		this.activeEdge = -1;
		this.activeLength = 0;
	}

}