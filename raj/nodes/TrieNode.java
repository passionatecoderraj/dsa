/**
 * 
 */
package com.raj.nodes;

/**
 * @author Raj
 *
 */
public class TrieNode {
	public char data;
	public boolean is_end_of_string;
	public TrieNode[] child;

	public TrieNode(char data) {
		super();
		this.data = data;
		this.is_end_of_string = false;
		child = new TrieNode[26];
	}

	public TrieNode getNode(char c) {
		if (child != null) {
			int index = Character.getNumericValue(c) - 10;
			return child[index];
		}
		return null;
	}

}
