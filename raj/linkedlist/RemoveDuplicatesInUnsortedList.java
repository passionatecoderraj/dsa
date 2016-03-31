/**
 * 
 */
package com.raj.linkedlist;

import com.raj.linkedlist.SingleLinkedList;
import com.raj.nodes.ListNode;
import com.raj.sorting.MergeSortForSingleLinkedList;

/**
 * @author Raj
 *
 */
public class RemoveDuplicatesInUnsortedList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SingleLinkedList<Integer> list = new SingleLinkedList<Integer>();
		list.insert(12);
		list.insert(11);
		list.insert(12);
		list.insert(21);
		list.insert(41);
		list.insert(43);
		list.insert(21);

		SingleLinkedList<Integer> list2 = new SingleLinkedList<Integer>();
		list2.insert(12);
		list2.insert(11);
		list2.insert(12);
		list2.insert(21);
		list2.insert(41);
		list2.insert(43);
		list2.insert(21);

		RemoveDuplicatesInUnsortedList obj = new RemoveDuplicatesInUnsortedList();

		// Without Sorting
		// Time :O(n2)
		list.print();
		obj.removeDuplicatesFromUnsortedLinkedList(list.root);
		list.print();

		// With merge sort , we can reduce complexity to O(nlogn)
		// Time :O(nlogn)
		list2.print();
		list2.root = obj.removeDuplicatesFromUnsortedLinkedListUsingSorting(list2.root);
		list2.print();

	}

	public ListNode<Integer> removeDuplicatesFromUnsortedLinkedListUsingSorting(ListNode<Integer> root) {
		root = new MergeSortForSingleLinkedList().mergeSort(root);
		new RemoveDuplicatesInSortedList().removeDuplicatesInSortedLinkedList(root);
		return root;
	}

	public void removeDuplicatesFromUnsortedLinkedList(ListNode<Integer> root) {
		if (null == root || root.next == null)
			return;
		ListNode<Integer> cur1, cur2 = null, prev = null;
		cur1 = root;
		while (cur1 != null) {
			cur2 = cur1.next;
			prev = cur1;
			while (cur2 != null) {
				if (cur1.data == cur2.data) {
					prev.next = cur2.next;
					cur2 = cur2.next;
				} else {
					prev = cur2;
					cur2 = cur2.next;
				}
			}
			cur1 = cur1.next;
		}
	}

}
