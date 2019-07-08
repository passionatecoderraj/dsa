/**
 * 
 */
package com.raj.leetcode;

import com.raj.linkedlist.SingleLinkedList;
import com.raj.nodes.ListNode;

/**
 * @author Raj
 * 
 * Sort a linked list using insertion sort.


A graphical example of insertion sort. The partial sorted list (black) initially contains only the first element in the list.
With each iteration one element (red) is removed from the input data and inserted in-place into the sorted list
 

Algorithm of Insertion Sort:

Insertion sort iterates, consuming one input element each repetition, and growing a sorted output list.
At each iteration, insertion sort removes one element from the input data, finds the location it belongs within the sorted list, and inserts it there.
It repeats until no input elements remain.

Example 1:

Input: 4->2->1->3
Output: 1->2->3->4
Example 2:

Input: -1->5->3->4->0
Output: -1->0->3->4->5

 *
 */
public class InsertionSortList {
	
	// https://leetcode.com/problems/insertion-sort-list/discuss/46573/Clean-Java-solution-using-a-fake-head
	// Time : O(n2), Space : O(1)
	public ListNode<Integer> insertionSortList(ListNode<Integer> head) {
		ListNode<Integer> dummyHead = new ListNode<Integer>(-1);
		ListNode<Integer> cur = head;
		//dummy.next = head;
		while (cur != null) {
			ListNode<Integer> next = cur.next;

			ListNode<Integer> prev = dummyHead;
			while (prev.next != null && cur.data > prev.next.data) {
				prev = prev.next;
			}
			cur.next = prev.next;
			prev.next = cur;
			cur = next;
		}
		return dummyHead.next;
	}

	public static void main(String[] args) {
		SingleLinkedList<Integer> list = new SingleLinkedList<Integer>();
		list.insert(7);
		list.insert(4);
		list.insert(6);
		list.insert(3);
		list.insert(9);
		list.insert(0);
		list.insert(2);
		// obj.print();

		InsertionSortList ob = new InsertionSortList();
		ListNode<Integer> newHead = ob.insertionSortList(list.root);
		list.print(newHead);

	}

}
