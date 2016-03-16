package com.raj.stack;

import java.util.Deque;
import java.util.LinkedList;

/*
 * copy queue to stack so that stack also maintains the same order of queue
 * Use stack - push, pop, Queue - enque,deque operations
 *  - should do it in constant space
 */
public class QueueToStackCopyWithConstantSpace {

	public static void main(String[] args) {

		Deque<Integer> q = new LinkedList<Integer>();
		q.addLast(10);
		q.addLast(20);
		q.addLast(30);
		q.addLast(40);
		q.addLast(50);
		q.addLast(60);
		QueueToStackCopyWithConstantSpace obj = new QueueToStackCopyWithConstantSpace();

		Stack stack = new Stack();
		obj.print(q);

		// Time : O(n), Space : O(1)
		obj.queueToStack(q, stack);
		stack.print();
	}

	// Time : O(n), Space : O(1)
	public void queueToStack(Deque<Integer> q, Stack stack) {
		while (!q.isEmpty())
			stack.push(q.removeFirst());
		while (!stack.isEmpty())
			q.addLast((Integer) stack.pop());
		while (!q.isEmpty())
			stack.push(q.removeFirst());
	}

	private void print(Deque<Integer> q) {
		for (Integer i : q) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

}
