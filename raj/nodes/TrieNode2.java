/**
 * 
 */
package com.raj.nodes;

/**
 * @author Raj
 *
 */
public class TrieNode2 {
	public char data;
	public boolean is_end_of_string;
	public TrieNode2[] child;

	public TrieNode2(char data) {
		super();
		this.data = data;
		this.is_end_of_string = false;
		child = new TrieNode2[256];
	}

	public TrieNode2 getNode(char c) {
		if (child != null) {
			return child[c];
		}
		return null;
	}

}
