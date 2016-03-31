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
public class RemoveDuplicatesInUnsortedCircularList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		RemoveDuplicatesInUnsortedCircularList obj = new RemoveDuplicatesInUnsortedCircularList();

		CircularLinkedList<Integer> clist = new CircularLinkedList<Integer>();
		clist.insert(12);
		clist.insert(11);
		clist.insert(12);
		clist.insert(21);
		clist.insert(41);
		clist.insert(43);
		clist.insert(21);

		CircularLinkedList<Integer> clist2 = new CircularLinkedList<Integer>();
		clist2.insert(12);
		clist2.insert(11);
		clist2.insert(12);
		clist2.insert(21);
		clist2.insert(41);
		clist2.insert(43);
		clist2.insert(21);

		clist.print();
		// Without Sorting
		// Time :O(n2)
		obj.removeDuplicatesFromUnsortedCircularList(clist.root);
		clist.print();

		clist2.print();
		// With merge sort , we can reduce complexity to O(nlogn)
		// Time :O(nlogn)
		clist2.root = obj.removeDuplicatesFromUnsortedCircularListUsingSorting(clist2.root);
		clist2.print();

	}

	public ListNode<Integer> removeDuplicatesFromUnsortedCircularListUsingSorting(ListNode<Integer> root) {
		ListNode<Integer> last = new CircularLinkedList<Integer>().getLastNodeInCLL(root);
		last.next = null;
		root = new MergeSortForSingleLinkedList().mergeSort(root);
		last = new SingleLinkedList<Integer>().getLastNode(root);
		last.next = root;
		new RemoveDuplicatesInSortedList().removeDuplicatesInSortedCircularList(root);
		return root;
	}

	public void removeDuplicatesFromUnsortedCircularList(ListNode<Integer> root) {
		if (null == root || root.next == root)
			return;
		ListNode<Integer> cur1, cur2 = null, prev = null;
		cur1 = root;
		while (cur1 != null) {
			cur2 = cur1.next;
			prev = cur1;
			if (cur2 == root)
				break;
			while (cur2 != root) {
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
