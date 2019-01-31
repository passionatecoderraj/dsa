/**
 * 
 */
package com.raj.leetcode;

import com.raj.linkedlist.SingleLinkedList;
import com.raj.nodes.DLLNode;
import com.raj.nodes.ListNode;

/**
 * @author Raj
 *
 *Given a linked list, swap every two adjacent nodes and return its head.

Example:

Given 1->2->3->4, you should return the list as 2->1->4->3.
Note:

Your algorithm should use only constant extra space.
You may not modify the values in the list's nodes, only nodes itself may be changed.

 */
public class SwapNodesinPairs {

	// Sjngle Linkedlist
	public ListNode<Integer> swapPairs(ListNode<Integer> head) {
		if (null == head || head.next == null)
			return head;
		ListNode<Integer> dummy = new ListNode<Integer>(0);
		dummy.next = head;
		ListNode<Integer> cur = dummy;

		while (cur.next != null && cur.next.next != null) {
			ListNode<Integer> temp = cur.next.next;
			cur.next.next = temp.next;
			temp.next = cur.next;
			cur.next = temp;
			cur = cur.next.next;
		}

		return dummy.next;
	}

	// Double Linkedlist
	public DLLNode<Integer> swapPairs(DLLNode<Integer> head) {
		if (null == head || head.next == null)
			return head;
		DLLNode<Integer> dummy = new DLLNode<Integer>(-1);
		dummy.next = head;
		DLLNode<Integer> cur = dummy;
		while (cur.next != null && cur.next.next != null) {
			DLLNode<Integer> temp = cur.next.next;
			cur.next.next = temp.next;
			if (temp.next != null) {
				temp.next.prev = cur.next;
			}
			temp.next = cur.next;
			temp.prev = cur;
			cur.next.prev = temp;
			cur.next = temp;
			cur = cur.next.next;
		}
		return dummy.next;
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
		obj.insert(21);
		obj.insert(22);
		obj.insert(23);
		obj.insert(24);
		obj.insert(25);
		obj.insert(26);

		obj.print();
		int x = 12, y = 13;

		SwapNodesinPairs ob = new SwapNodesinPairs();
		// ob.swapNodesWithoutSwappingData(obj, x, y);
		// obj.print();
		ListNode<Integer> res = ob.swapPairs(obj.root);
		obj.print(res);
	}

	public void swapNodesWithoutSwappingData(SingleLinkedList<Integer> obj, int x, int y) {
		if (x == y) {
			return;
		}
		ListNode<Integer> tempX = obj.root, tempY = obj.root, prevX = null, prevY = null;
		boolean isXFound, isYFound;
		isXFound = isYFound = false;
		while (tempX != null) {
			if (tempX.data == x) {
				isXFound = true;
				break;
			}
			prevX = tempX;
			tempX = tempX.next;
		}
		if (!isXFound) {
			return;
		}

		tempY = obj.root;
		while (tempY != null) {
			if (tempY.data == y) {
				isYFound = true;
				break;
			}
			prevY = tempY;
			tempY = tempY.next;
		}

		if (!isYFound) {
			return;
		}

		// swapping previous elements next
		// check if X if first element
		if (prevX == null)
			obj.root = tempY;
		else
			prevX.next = tempY;

		// check if Y if first elements
		if (prevY == null)
			obj.root = tempX;
		else
			prevY.next = tempX;

		// swapping next of current elements next
		ListNode<Integer> temp = tempX.next;
		tempX.next = tempY.next;
		tempY.next = temp;
	}

}
