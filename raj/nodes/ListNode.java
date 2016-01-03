/**
 * 
 */
package com.raj.nodes;

/**
 * @author Raj
 *
 */
public class ListNode<T> {
	public T data;
	public ListNode<T> next;

	public ListNode() {

	}

	public ListNode(T data) {
		super();
		this.data = data;
		this.next = null;
	}

	@Override
	public String toString() {
		return "ListNode [data=" + data + "]";
	}

}
