/**
 * 
 */
package com.raj.linkedlist;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Raj
 *
 */
public class CopyListWithRandomPointer {

	// Time : O(n), Space :O(1)
	public Node copyListWithRandomPointer(Node head) {
		Node temp = head, next;
		while (temp != null) {
			next = temp.next;
			Node copy = new Node(temp.label);
			temp.next = copy;
			copy.next = next;
			temp = next;
		}

		temp = head;
		while (temp != null) {
			if (temp.random != null) {
				temp.next.random = temp.random.next;
			}
			temp = temp.next.next;
		}

		temp = head;
		Node newHead = null, prev = null;
		while (temp != null) {
			next = temp.next.next;
			if (null == newHead) {
				newHead = temp.next;
			} else {
				prev.next = temp.next;
			}
			prev = temp.next;

			temp.next = next;
			temp = next;
		}

		return newHead;
	}

	// Time : O(n), Space :O(n)
	public Node copyListWithRandomPointer2(Node head) {
		Map<Node, Node> map = new HashMap<>();
		Node temp = head;
		while (temp != null) {
			map.put(temp, new Node(temp.label));
			temp = temp.next;
		}
		temp = head;

		while (temp != null) {
			map.get(temp).next = map.get(temp.next);
			map.get(temp).random = map.get(temp.random);
			temp = temp.next;
		}
		return map.get(head);
	}

	public void print(Node n) {
		Node temp = n;
		while (temp != null) {
			System.out.print(temp.label + "(" + temp.random.label + "), ");
			temp = temp.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);
		Node n6 = new Node(6);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n1.random = n3;
		n2.random = n5;
		n3.random = n4;
		n4.random = n6;
		n5.random = n1;
		n6.random = n2;

		// mid of 6 numbers is 4th one
		// mid of 5 numbers is 3rd one

		CopyListWithRandomPointer ob = new CopyListWithRandomPointer();
		Node result = null;
		ob.print(n1);
		result = ob.copyListWithRandomPointer2(n1);
		ob.print(result);
		result = ob.copyListWithRandomPointer(n1);
		ob.print(result);
	}

}

class Node {
	Node next, random;
	int label;

	public Node(int label) {
		this.label = label;
	}

}
