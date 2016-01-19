package com.raj.stack;

import java.util.Deque;
import java.util.LinkedList;

public class ReverseQueue {

	public static void main(String[] args) {
		Deque<Integer> q = new LinkedList<Integer>();
		q.addLast(10);
		q.addLast(20);
		q.addLast(30);
		q.addLast(40);
		q.addLast(50);
		q.addLast(60);
		ReverseQueue obj = new ReverseQueue();

		obj.print(q);
		// Time : O(n), Space : O(n)
		obj.reverseQueue(q);
		obj.print(q);
	}

	private void print(Deque<Integer> q) {
		for (Integer i : q) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

	public void reverseQueue(Deque<Integer> q) {
		Stack stack = new Stack();
		while (!q.isEmpty()) {
			stack.push(q.removeFirst());
		}
		while (!stack.isEmpty()) {
			q.addLast((Integer) stack.pop());
		}
	}

}
