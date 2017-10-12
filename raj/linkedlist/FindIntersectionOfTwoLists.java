/**
 *
 */
package com.raj.linkedlist;

import com.raj.nodes.ListNode;

/**
 * @author Raj
 */
public class FindIntersectionOfTwoLists {

	// https://discuss.leetcode.com/topic/28067/java-solution-without-knowing-the-difference-in-len
	// Time : O(max(m,n))
	public ListNode<Integer> findIntersection(SingleLinkedList<Integer> list1, SingleLinkedList<Integer> list2) {
		ListNode<Integer> head1 = list1.root, head2 = list2.root;
		ListNode<Integer> temp1 = head1, temp2 = head2;

		while (temp1 != temp2) {
			temp1 = temp1 != null ? temp1.next : head2;
			temp2 = temp2 != null ? temp2.next : head1;
		}
		return temp1;
	}

	// Time : O(n)
	public ListNode<Integer> findIntersection2(SingleLinkedList<Integer> list1, SingleLinkedList<Integer> list2) {
		int n1 = list1.length(), n2 = list2.length();
		int d = Math.abs(n1 - n2);
		ListNode<Integer> temp1, temp2;

		if (n1 > n2) {
			temp1 = list1.root;
			temp2 = list2.root;
		} else {
			temp1 = list2.root;
			temp2 = list1.root;
		}
		for (int i = 0; i < d; i++) {
			temp1 = temp1.next;
		}

		while (temp1 != null && temp2 != null) {
			if (temp1.data == temp2.data) {
				return temp1;
			}
			temp1 = temp1.next;
			temp2 = temp2.next;
		}
		return null;
	}

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
		obj.insert(60);
		obj.insert(70);
		obj.insert(80);
		obj.print();
		SingleLinkedList<Integer> obj2 = new SingleLinkedList<Integer>();
		obj2.insert(4);
		obj2.insert(3);
		obj2.insert(60);
		obj2.insert(70);
		obj2.insert(80);
		obj2.print();

		FindIntersectionOfTwoLists ob = new FindIntersectionOfTwoLists();
		ListNode<Integer> result;
		result = ob.findIntersection(obj, obj2);
		System.out.println(result);
	}

}
