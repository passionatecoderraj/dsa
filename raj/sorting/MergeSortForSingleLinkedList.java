/**
 * 
 */
package com.raj.sorting;

import com.raj.linkedlist.SingleLinkedList;
import com.raj.nodes.ListNode;

/**
 * @author Raj
 *
 */
public class MergeSortForSingleLinkedList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SingleLinkedList<Integer> list = new SingleLinkedList<Integer>();
		list.insert(80);
		list.insert(10);
		list.insert(20);
		list.insert(40);
		list.insert(50);
		list.insert(60);
		list.insert(70);
		list.print();
		MergeSortForSingleLinkedList obj = new MergeSortForSingleLinkedList();

		list.root = obj.mergeSort(list.root);
		list.print();
	}

	public ListNode<Integer> mergeSort(ListNode<Integer> root) {
		if (null == root || root.next == null)
			return root;
		ListNode<Integer> head1 = root, head2;
		ListNode<Integer> slow, fast;
		slow = fast = root;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		head2 = slow.next;
		slow.next = null;
		head1 = mergeSort(head1);
		head2 = mergeSort(head2);
		return merge(head1, head2);
	}

	public ListNode<Integer> merge(ListNode<Integer> head1, ListNode<Integer> head2) {
		if (head1 == null)
			return head2;
		if (head2 == null)
			return head1;

		if (head1.data <= head2.data) {
			head1.next = merge(head1.next, head2);
			return head1;
		} else {
			head2.next = merge(head1, head2.next);
			return head2;
		}
	}

}
