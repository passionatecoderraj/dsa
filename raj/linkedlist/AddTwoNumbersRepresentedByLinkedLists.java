/**
 * 
 */
package com.raj.linkedlist;

import com.raj.nodes.ListNode;

/**
 * @author Raj
 *
 */
// Input:
// First List: 5->6->3 // represents number 365
// Second List: 8->4->2 // represents number 248
// Output
// Resultant list: 3->1->6 // reprents number 613

// Input:
// First List: 7->5->9->4->6 // represents number 64957
// Second List: 8->4 // represents number 48
// Output
// Resultant list: 5->0->0->5->6 // represents number 65005

public class AddTwoNumbersRepresentedByLinkedLists {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SingleLinkedList<Integer> l1 = new SingleLinkedList<Integer>();
		// l1.insert(5);
		// l1.insert(6);
		// l1.insert(3);
		l1.insert(7);
		l1.insert(5);
		l1.insert(9);
		l1.insert(4);
		l1.insert(6);

		SingleLinkedList<Integer> l2 = new SingleLinkedList<Integer>();
		l2.insert(8);
		l2.insert(4);

		AddTwoNumbersRepresentedByLinkedLists obj = new AddTwoNumbersRepresentedByLinkedLists();
		ListNode<Integer> result = null;
		result = obj.add(l2.root, l1.root);
		new SingleLinkedList<Integer>().print(result);

		result = obj.addCleanerCode(l2.root, l1.root);
		new SingleLinkedList<Integer>().print(result);
	}

	public ListNode<Integer> addCleanerCode(ListNode<Integer> temp1, ListNode<Integer> temp2) {
		SingleLinkedList<Integer> result = new SingleLinkedList<Integer>();

		int carry = 0, sum = 0, val1 = 0, val2 = 0;
		while (temp1 != null || temp2 != null) {
			val1 = (temp1 != null) ? temp1.data : 0;
			val2 = (temp2 != null) ? temp2.data : 0;
			sum = val1 + val2 + carry;
			carry = sum >= 10 ? 1 : 0;
			sum = sum % 10;
			result.insert(sum);

			if (temp1 != null)
				temp1 = temp1.next;
			if (temp2 != null)
				temp2 = temp2.next;
		}

		if (carry > 0) {
			result.insert(1);
		}

		return result.root;
	}

	public ListNode<Integer> add(ListNode<Integer> temp1, ListNode<Integer> temp2) {
		SingleLinkedList<Integer> result = new SingleLinkedList<Integer>();

		int carry = 0, sum = 0;
		while (temp1 != null && temp2 != null) {
			sum = temp1.data + temp2.data + carry;
			if (sum >= 10) {
				result.insert(sum - 10);
				carry = 1;
			} else {
				result.insert(sum);
				carry = 0;
			}
			temp1 = temp1.next;
			temp2 = temp2.next;
		}

		while (temp1 != null) {
			sum = temp1.data + carry;
			if (sum >= 10) {
				result.insert(sum - 10);
				carry = 1;
			} else {
				result.insert(sum);
				carry = 0;
			}
			temp1 = temp1.next;
		}

		while (temp2 != null) {
			sum = temp2.data + carry;
			if (sum >= 10) {
				result.insert(sum - 10);
				carry = 1;
			} else {
				result.insert(sum);
				carry = 0;
			}
			temp2 = temp2.next;
		}

		if (carry == 1) {
			result.insert(1);
		}

		return result.root;
	}

}
