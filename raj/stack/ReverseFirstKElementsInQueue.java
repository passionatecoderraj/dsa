package com.raj.stack;

import java.util.Deque;
import java.util.LinkedList;

public class ReverseFirstKElementsInQueue {

	public static void main(String[] args) {
		Deque<Integer> q = new LinkedList<Integer>();
		q.addLast(10);
		q.addLast(20);
		q.addLast(30);
		q.addLast(40);
		q.addLast(50);
		q.addLast(60);
		q.addLast(70);
		q.addLast(80);
		q.addLast(90);
		ReverseFirstKElementsInQueue obj = new ReverseFirstKElementsInQueue();

		int k = 4;
		obj.print(q);
		// Time : O(n), Space : O(k)
		obj.reverseFirstKElements(q, k);
		obj.print(q);
	}

	public void reverseFirstKElements(Deque<Integer> q, int k) {
		int n = q.size();
		if (k > n) {
			return;
		}
		Stack stack = new Stack();
		for (int i = 0; i < k; i++)
			stack.push(q.removeFirst());

		while (!stack.isEmpty())
			q.addLast((Integer) stack.pop());
		for (int i = 0; i < (n - k); i++) {
			q.addLast(q.removeFirst());
		}
	}

	private void print(Deque<Integer> q) {
		for (Integer i : q) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

}
