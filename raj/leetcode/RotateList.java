/**
 * 
 */
package com.raj.leetcode;

import com.raj.linkedlist.SingleLinkedList;
import com.raj.nodes.ListNode;

/**
 * @author Raj
 *
 *Given a linked list, rotate the list to the right by k places, where k is non-negative.

Example 1:

Input: 1->2->3->4->5->NULL, k = 2
Output: 4->5->1->2->3->NULL
Explanation:
rotate 1 steps to the right: 5->1->2->3->4->NULL
rotate 2 steps to the right: 4->5->1->2->3->NULL
Example 2:

Input: 0->1->2->NULL, k = 4
Output: 2->0->1->NULL
Explanation:
rotate 1 steps to the right: 2->0->1->NULL
rotate 2 steps to the right: 1->2->0->NULL
rotate 3 steps to the right: 0->1->2->NULL
rotate 4 steps to the right: 2->0->1->NULL

 */
public class RotateList {

	public ListNode<Integer> rotateRight(ListNode<Integer> head, int k) {
		if (null == head)
			return head;
		int n = 1;
		ListNode<Integer> cur = head;
		while (cur.next != null) {
			cur = cur.next;
			n++;
		}
		ListNode<Integer> last = cur;
		k %= n;
		if (k == 0)
			return head;

		cur = head;
		for (int i = 1; i < n - k; i++) {
			cur = cur.next;
		}
		ListNode<Integer> newHead = cur.next;
		last.next = head;
		cur.next = null;
		return newHead;
	}

	public static void main(String[] args) {
		SingleLinkedList<Integer> obj = new SingleLinkedList<Integer>();
		obj.insert(11);
		obj.insert(12);
		obj.insert(13);
		obj.insert(14);
		obj.insert(15);
		obj.insert(16);
		obj.insert(17);
		obj.insert(18);
		obj.insert(19);
		obj.insert(20);

		RotateList ob = new RotateList();
		obj.root = ob.rotateRight(obj.root, 10);
		obj.print();
	}

}
