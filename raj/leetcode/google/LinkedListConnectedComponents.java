/**
 * 
 */
package com.raj.leetcode.google;

import java.util.HashSet;
import java.util.Set;

import com.raj.graph.DisjointSet;
import com.raj.linkedlist.SingleLinkedList;
import com.raj.nodes.ListNode;

/**
 * @author Raj 
 * 
 * 
 * We are given head, the head node of a linked list containing unique integer values.

We are also given the list G, a subset of the values in the linked list.

Return the number of connected components in G, where two values are connected if they appear consecutively in the linked list.

Example 1:

Input: 
head: 0->1->2->3
G = [0, 1, 3]
Output: 2
Explanation: 
0 and 1 are connected, so [0, 1] and [3] are the two connected components.
Example 2:

Input: 
head: 0->1->2->3->4
G = [0, 3, 1, 4]
Output: 2
Explanation: 
0 and 1 are connected, 3 and 4 are connected, so [0, 1] and [3, 4] are the two connected components.
 */
public class LinkedListConnectedComponents {

	//https://leetcode.com/problems/linked-list-components/discuss/123842/C++JavaPython-Easy-and-Concise-Solution-with-Explanation
	public int numComponents(ListNode<Integer> head, int[] G) {
		Set<Integer> set = new HashSet<>();
		for (int n : G) {
			set.add(n);
		}
		int res = 0;
		ListNode<Integer> temp = head;
		while (temp != null) {
			if(set.contains(temp.data) && (temp.next == null || !set.contains(temp.next.data))){
				res++;
			}
			temp = temp.next;
		}
		return res;
	}
	
	/*
	 * No. of edges for k nodes is k-1. If given no. of edges are n, there is one
	 * edge extra, so there are n+1 nodes
	 * 
	 */
	public int numComponents2(ListNode<Integer> head, int[] G) {
		DisjointSet ds = new DisjointSet();
		for (int n : G) {
			ds.makeSet(n);
		}
		int res = G.length;
		ListNode<Integer> temp = head;
		while (temp != null && temp.next != null) {
			if (ds.contains(temp.data) && ds.contains(temp.next.data)) {
				ds.union(temp.data, temp.next.data);
				res--;
			}
			temp = temp.next;
		}
		return res;
	}

	public static void main(String[] args) {
		LinkedListConnectedComponents obj = new LinkedListConnectedComponents();
		SingleLinkedList<Integer> list = new SingleLinkedList<Integer>();
		list.insert(0);
		list.insert(1);
		list.insert(2);
		list.insert(3);
		int G[] = { 0, 1, 3 };
		int result = -1;
		result = obj.numComponents(list.root, G);
		System.out.println(result);

		list.insert(4);
		int G2[] = { 0, 3, 1, 4 };
		result = obj.numComponents(list.root, G2);
		System.out.println(result);
	}

}
