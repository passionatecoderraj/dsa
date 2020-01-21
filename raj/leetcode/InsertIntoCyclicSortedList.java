/**
 * 
 */
package com.raj.leetcode;

import com.raj.linkedlist.CircularLinkedList;
import com.raj.nodes.ListNode;

/**
 * @author Raj
 *
 *Given a node from a cyclic linked list which is sorted in ascending order, write a function to insert a value into the list such that it remains a cyclic sorted list. The given node can be a reference to any single node in the list, and may not be necessarily the smallest value in the cyclic list.

If there are multiple suitable places for insertion, you may choose any place to insert the new value. After the insertion, the cyclic list should remain sorted.

If the list is empty (i.e., given node is null), you should create a new single cyclic list and return the reference to that single node. Otherwise, you should return the original given node.

The following example may help you understand the problem better:

 



In the figure above, there is a cyclic sorted list of three elements. You are given a reference to the node with value 3, and we need to insert 2 into the list.

 



The new node should insert between node 1 and node 3. After the insertion, the list should look like this, and we should still return node 3.
 */
public class InsertIntoCyclicSortedList {

	// Time : O(n), Space : O(1)
	public ListNode<Integer> insert(ListNode<Integer> head, int insertVal) {
		// if there are zero nodes
		if (null == head) {
			head = new ListNode<Integer>(insertVal);
			head.next = head;
			return head;
		}
		ListNode<Integer> cur = head;
		while (cur.next != head) {
			// if numbers are in increasing order, check whether value exists between cur
			// and next
			if (cur.next.data >= cur.data) {
				if (insertVal >= cur.data && insertVal <= cur.next.data) {
					break;
				}
			} else {
				// if cur and next are not last value and value of the list
				if (insertVal >= cur.data || insertVal <= cur.next.data) {
					break;
				}
			}
			cur = cur.next;
		}
		ListNode<Integer> n = new ListNode<Integer>(insertVal);
		n.next = cur.next;
		cur.next = n;
		return head;
	}

	public static void main(String[] args) {

		InsertIntoCyclicSortedList obj = new InsertIntoCyclicSortedList();

		CircularLinkedList<Integer> list = new CircularLinkedList<Integer>();
		list.insert(10);
		list.insert(20);
		list.insert(30);
		list.insert(40);
		list.insert(50);
		ListNode<Integer> res = null;
		obj.print(list.root);
		ListNode<Integer> random = obj.getRandomNode(obj.length(list.root), list.root);
		System.out.println(random);
		res = obj.insert(random, 25);
		obj.print(res);
	}

	private void print(ListNode<Integer> head) {
		ListNode<Integer> node = head;

		while (node.next != head) {
			System.out.print(node.data + " -> ");
			node = node.next;
		}
		System.out.println(node.data);

	}

	ListNode<Integer> getRandomNode(int n, ListNode<Integer> head) {
		int len = 0;
		while (len++ < n) {
			head = head.next;
		}
		return head;
	}

	int length(ListNode<Integer> head) {
		if (null == head)
			return 0;
		int len = 1;
		ListNode<Integer> node = head;
		while (node.next != head) {
			node = node.next;
			len++;
		}
		return len;
	}

}
