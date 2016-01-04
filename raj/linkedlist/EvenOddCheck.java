/**
 * 
 */
package com.raj.linkedlist;

import com.raj.nodes.ListNode;

/**
 * @author Raj
 *
 */
public class EvenOddCheck {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SingleLinkedList<Integer> obj = new SingleLinkedList<Integer>();
		obj.insert(10);
		obj.insert(20);
		obj.insert(30);
		obj.insert(40);
		obj.insert(50);
		EvenOddCheck ob = new EvenOddCheck();
		boolean result = false;
		result = ob.isEven(obj.root);
		System.out.println(result);
		result = ob.isEvenMethod2(obj.root);
		System.out.println(result);
	}

	public boolean isEven(ListNode<Integer> root) {
		ListNode<Integer> fast = root;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
		}
		if (fast != null) {
			return false;
		}
		return true;
	}

	public boolean isEvenMethod2(ListNode<Integer> root) {
		ListNode<Integer> fast = root;
		while (fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
		}
		if (fast.next == null) {
			return false;
		}
		return true;
	}

}
