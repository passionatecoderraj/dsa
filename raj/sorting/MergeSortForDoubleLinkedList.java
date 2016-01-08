/**
 * 
 */
package com.raj.sorting;

import com.raj.linkedlist.DoubleLinkedList;
import com.raj.nodes.DLLNode;

/**
 * @author Raj
 *
 */
public class MergeSortForDoubleLinkedList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();
		list.insert(80);
		list.insert(10);
		list.insert(20);
		list.insert(40);
		list.insert(50);
		list.insert(60);
		list.insert(70);
		list.print();
		MergeSortForDoubleLinkedList obj = new MergeSortForDoubleLinkedList();

		list.root = obj.mergeSort(list.root);
		list.print();
	}

	public DLLNode<Integer> mergeSort(DLLNode<Integer> root) {
		if (null == root || root.next == null)
			return root;
		DLLNode<Integer> head1 = root, head2;
		DLLNode<Integer> slow, fast;
		slow = fast = root;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		head2 = slow.next;
		head2.prev = null;
		slow.next = null;
		head1 = mergeSort(head1);
		head2 = mergeSort(head2);
		return merge(head1, head2);
	}

	public DLLNode<Integer> merge(DLLNode<Integer> head1, DLLNode<Integer> head2) {
		if (head1 == null)
			return head2;
		if (head2 == null)
			return head1;
		if (head1.data <= head2.data) {
			head1.next = merge(head1.next, head2);
			head1.next.prev = head1;
			head1.prev = null;
			return head1;
		} else {
			head2.next = merge(head1, head2.next);
			head2.next.prev = head2;
			head2.prev = null;
			return head2;
		}
	}

}
