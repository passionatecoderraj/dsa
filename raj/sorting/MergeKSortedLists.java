/**
 * 
 */
package com.raj.sorting;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

import com.interivew.graph.BinaryMinHeap;
import com.raj.linkedlist.SingleLinkedList;
import com.raj.nodes.ListNode;

/**
 * @author Raj
 *
 */
public class MergeKSortedLists {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		SingleLinkedList<Integer> list1 = new SingleLinkedList<Integer>();
		list1.insert(1);
		list1.insert(5);
		list1.insert(8);
		list1.insert(9);
		list1.print();
		SingleLinkedList<Integer> list2 = new SingleLinkedList<Integer>();
		list2.insert(2);
		list2.insert(3);
		list2.insert(7);
		list2.insert(10);
		list2.print();
		SingleLinkedList<Integer> list3 = new SingleLinkedList<Integer>();
		list3.insert(4);
		list3.insert(6);
		list3.insert(11);
		list3.insert(15);
		list3.print();
		SingleLinkedList<Integer> list4 = new SingleLinkedList<Integer>();
		list4.insert(9);
		list4.insert(14);
		list4.insert(16);
		list4.insert(19);
		list4.print();
		SingleLinkedList<Integer> list5 = new SingleLinkedList<Integer>();
		list5.insert(2);
		list5.insert(4);
		list5.insert(6);
		list5.insert(9);
		list5.print();

		MergeKSortedLists obj = new MergeKSortedLists();
		ListNode<Integer> result = null;
		List<ListNode<Integer>> list = new ArrayList<ListNode<Integer>>(0);
		list.add(list1.root);
		list.add(list2.root);
		list.add(list3.root);
		list.add(list4.root);
		list.add(list5.root);

		// result = obj.merge(list);
		// new SingleLinkedList<Integer>().print(result);

		result = obj.mergeKSortedLists(list);
		new SingleLinkedList<Integer>().print(result);

	}

	public ListNode<Integer> merge(List<ListNode<Integer>> list) {
		ListNode<Integer> head = null, cur = null, temp;

		if (null == list || list.size() == 0) {
			return head;
		}
		int k = list.size();
		BinaryMinHeap<ListNode<Integer>> heap = new BinaryMinHeap<ListNode<Integer>>();

		for (int i = 0; i < k; i++) {
			temp = list.get(i);
			if (temp != null)
				heap.add(temp.data, temp);
		}

		while (heap.size() > 0) {
			temp = heap.extractMin();
			if (null == head) {
				head = temp;
				cur = head;
			} else {
				cur.next = temp;
				cur = cur.next;
			}
			if (temp.next != null)
				heap.add(temp.next.data, temp.next);

		}
		return head;
	}

	public ListNode<Integer> mergeKSortedLists(List<ListNode<Integer>> list) {
		class Node {
			int id;
			ListNode<Integer> node;

			public Node(int id, ListNode<Integer> node) {
				super();
				this.id = id;
				this.node = node;
			}
		}
		PriorityQueue<Node> pq = new PriorityQueue<>(list.size(), new Comparator<Node>() {
			@Override
			public int compare(Node n1, Node n2) {
				return n1.id - n2.id;
			}
		});

		for (ListNode<Integer> node : list) {
			if (node != null)
				pq.offer(new Node(node.data, node));
		}

		ListNode<Integer> head = null, cur = null;
		while (!pq.isEmpty()) {
			Node temp = pq.poll();
			if (head == null) {
				head = temp.node;
				cur = head;
			} else {
				cur.next = temp.node;
				cur = cur.next;
			}
			if (temp.node.next != null) {
				pq.offer(new Node(temp.node.next.data, temp.node.next));
			}
		}
		return head;
	}

}
