/**
 * 
 */
package com.raj.nodes;

/**
 * @author Raj
 *
 */
public class DLLNode<T> {
	public T data;
	public DLLNode<T> prev;
	public DLLNode<T> next;

	public DLLNode() {

	}

	public DLLNode(T data) {
		super();
		this.data = data;
		this.next = null;
		this.prev = null;
	}

	@Override
	public String toString() {
		return "DLLNode [data=" + data + "]";
	}

}
