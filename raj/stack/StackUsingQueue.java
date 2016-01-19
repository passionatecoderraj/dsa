/**
 * 
 */
package com.raj.stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Raj
 *
 */
public class StackUsingQueue {

	Deque<Integer> q1 = new LinkedList<Integer>();
	Deque<Integer> q2 = new LinkedList<Integer>();

	Deque<Integer> q3 = new LinkedList<Integer>();
	Deque<Integer> q4 = new LinkedList<Integer>();

	public void push(int data) {
		if (q1.isEmpty())
			q2.addLast(data);
		else
			q1.addLast(data);
	}

	public int pop() {
		if (q1.isEmpty())
			return q2.removeFirst();
		else
			return q1.removeFirst();
	}

	public static void main(String[] args) {
		StackUsingQueue stack = new StackUsingQueue();
		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.push(40);
		stack.push(50);

		System.out.println(stack.popOverload());
		System.out.println(stack.popOverload());

		StackUsingQueue stack2 = new StackUsingQueue();
		stack2.pushOverload(10);
		stack2.pushOverload(20);
		stack2.pushOverload(30);
		stack2.pushOverload(40);
		stack2.pushOverload(50);

		System.out.println(stack2.pop());
		System.out.println(stack2.pop());

	}

	public void pushOverload(int data) {
		if (q1.isEmpty()) {
			q1.addLast(data);
			while (!q2.isEmpty())
				q1.addLast(q2.removeFirst());
		} else {
			q2.addLast(data);
			while (!q1.isEmpty())
				q2.addLast(q1.removeFirst());
		}
	}

	public Object popOverload() {
		if (q1.isEmpty()) {
			int n = q2.size();
			for (int i = 0; i < n - 1; i++) {
				q1.addLast(q2.removeFirst());
			}
			return q2.removeFirst();
		} else {
			int n = q1.size();
			for (int i = 0; i < n - 1; i++) {
				q2.addLast(q1.removeFirst());
			}
			return q1.removeFirst();
		}
	}

}
