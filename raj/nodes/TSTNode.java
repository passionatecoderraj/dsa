/**
 * 
 */
package com.raj.nodes;

/**
 * @author Raj
 *
 */
public class TSTNode {
	public char data;
	public boolean is_end_of_string;
	public TSTNode left;
	public TSTNode eq;
	public TSTNode right;

	public TSTNode() {

	}

	public TSTNode(char data) {
		super();
		this.data = data;
	}

	@Override
	public String toString() {
		return "[data=" + data + ", is_end_of_string=" + is_end_of_string + ", left=" + left + ", eq=" + eq
				+ ", right=" + right + "]";
	}

	
}
