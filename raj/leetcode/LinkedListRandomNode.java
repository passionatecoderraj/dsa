/**
 * 
 */
package com.raj.leetcode;

import java.util.Random;

import com.raj.linkedlist.SingleLinkedList;
import com.raj.nodes.ListNode;

/**
 * @author Raj
 *
 * Given a singly linked list, return a random node's value from the linked list. Each node must have the same probability of being chosen.

Follow up:
What if the linked list is extremely large and its length is unknown to you? Could you solve this efficiently without using extra space?

Example:

// Init a singly linked list [1,2,3].
ListNode head = new ListNode(1);
head.next = new ListNode(2);
head.next.next = new ListNode(3);
Solution solution = new Solution(head);

// getRandom() should return either 1, 2, or 3 randomly. Each element should have equal probability of returning.
solution.getRandom(); 
 */

class ListWithRandomNode {

	ListNode head;
	Random random;

	/**
	 * @param head
	 *            The linked list's head. Note that the head is guaranteed to be not
	 *            null, so it contains at least one node.
	 */
	public ListWithRandomNode(ListNode head) {
		this.head = head;
		random = new Random();
	}

// https://www.programcreek.com/2014/08/leetcode-linked-list-random-node-java/
	/** Returns a random node's value. */
	public int getRandom() {
		if (head == null)
			return 0;

		int res = 0;
		ListNode cur = head;
		int size = 1;
		while (cur != null) {
			/*
			 * for list with only one element it always return first element
			 * 
			 * For second element, 
			 */
			if (random.nextInt(size++) == 0) {
				res = (int)cur.data;
			}
			cur = cur.next;
		}
		return res;
	}
}

public class LinkedListRandomNode {

	public static void main(String[] args) {
		SingleLinkedList<Integer> obj = new SingleLinkedList<Integer>();
		obj.insert(11);
		
		ListWithRandomNode ob = new ListWithRandomNode(obj.root);
		System.out.println(ob.getRandom());
		obj.insert(12);
		System.out.println(ob.getRandom());
		obj.insert(13);
		System.out.println(ob.getRandom());
		obj.insert(14);
		System.out.println(ob.getRandom());
		obj.insert(15);
		System.out.println(ob.getRandom());
		
		
	}

}
