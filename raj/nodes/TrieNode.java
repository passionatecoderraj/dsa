/**
 * 
 */
package com.raj.nodes;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Raj
 *
 */
public class TrieNode {
	public char data;
	public boolean endOfWord;
	public Map<Character, TrieNode> children = new HashMap<>();

	public TrieNode(char data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "TrieNode [data=" + data + ", endOfWord=" + endOfWord + ", children=" + children + "]";
	}

}
