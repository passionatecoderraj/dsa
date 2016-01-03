/**
 * 
 */
package com.raj.nodes;

/**
 * @author Raj
 *
 */
public class CLLNode<T> {
	public T data;
	public CLLNode<T> next;

	public CLLNode() {

	}

	public CLLNode(T data) {
		super();
		this.data = data;
		this.next = null;
	}

	@Override
	public String toString() {
		return "CLLNode [data=" + data + "]";
	}

}
