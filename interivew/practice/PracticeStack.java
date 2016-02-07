package com.interivew.practice;

import java.util.Deque;
import java.util.LinkedList;

import com.raj.stack.Stack;

public class PracticeStack {
	private Stack stack;
	private Stack minStack;

	// stack with getMinimum as O(1)
	public void pushOptimizedSpace(Integer data) {
		stack.push(data);
		Integer topOfMinStack = (Integer) minStack.top();

		if (topOfMinStack == null)
			minStack.push(data);
		else if (data <= topOfMinStack)
			minStack.push(data);
	}

	public Object popOptimizedSpace() {
		Integer topOfStack = (Integer) stack.pop();
		Integer topOfMinStack = (Integer) minStack.top();

		if (topOfStack <= topOfMinStack)
			minStack.pop();
		return topOfStack;
	}

	public void push(Integer data) {
		stack.push(data);
		Integer topOfMinStack = (Integer) minStack.top();
		if (topOfMinStack == null)
			minStack.push(data);
		else if (data < topOfMinStack)
			minStack.push(data);
		else
			minStack.push(topOfMinStack);
	}

	public Object pop() {
		minStack.pop();
		return stack.pop();
	}

	public Object getMinimum() {
		return minStack.top();
	}

	// insert at bottom of stack
	public void insertAtBottomOfStack(Stack stack, Object data) {
		if (stack.isEmpty()) {
			stack.push(data);
			return;
		}
		Object temp = stack.pop();
		insertAtBottomOfStack(stack, data);
		stack.push(temp);
	}

	// reverse stack without using loops and with using recursion
	public void reverseStackWithoutUsingLoops(Stack stack) {
		if (stack.isEmpty())
			return;
		Object data = stack.pop();
		reverseStackWithoutUsingLoops(stack);
		insertAtBottomOfStack(stack, data);
	}

	public Stack sort(Stack stack) {
		Stack sortedStack = new Stack();
		Integer cur, top;

		while (!stack.isEmpty()) {
			cur = (Integer) stack.pop();
			top = (Integer) sortedStack.top();
			while (!sortedStack.isEmpty() && cur > top) {
				stack.push(sortedStack.pop());
				top = (Integer) sortedStack.top();
			}
			sortedStack.push(cur);
		}
		return sortedStack;
	}

	public void calculateSpan(int[] a, int n) {
		if (n <= 0)
			return;

		int t[] = new int[n];
		Deque<Integer> stack = new LinkedList<Integer>();
		for (int i = 0; i < n; i++) {
			while (!stack.isEmpty() && a[i] >= a[stack.peekFirst()]) {
				stack.pop();
			}

			if (stack.isEmpty())
				t[i] = i + 1;
			else
				t[i] = i - stack.peekFirst();

			stack.push(i);
		}
	}

	// look for enque, deque and doubleQueue operations from Queue.java

	// reverse Queue
	// Time : O(n), Space : O(n)
	public void reverseQueue(Deque<Integer> q) {
		Stack stack = new Stack();
		while (!q.isEmpty()) {
			stack.push(q.removeFirst());
		}
		while (!stack.isEmpty()) {
			q.addLast((Integer) stack.pop());
		}
	}

	Deque<Integer> q1 = new LinkedList<Integer>();
	Deque<Integer> q2 = new LinkedList<Integer>();

	Deque<Integer> q3 = new LinkedList<Integer>();
	Deque<Integer> q4 = new LinkedList<Integer>();

	// stack using queues
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

	public int pop2() {
		if (q1.isEmpty())
			return q2.removeFirst();
		else
			return q1.removeFirst();
	}

	public void push(int data) {
		if (q1.isEmpty())
			q2.addLast(data);
		else
			q1.addLast(data);
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

	Stack s1 = new Stack();
	Stack s2 = new Stack();

	Stack s3 = new Stack();
	Stack s4 = new Stack();

	// queue using stacks
	public void enqueOverload(Object data) {
		while (!s3.isEmpty())
			s4.push(s3.pop());
		s4.push(data);
		while (!s4.isEmpty())
			s3.push(s4.pop());
	}

	public Object deQueue() {
		return s3.pop();
	}

	public void enque(Object data) {
		s1.push(data);
	}

	public Object deQueueOverload() {
		while (!s1.isEmpty())
			s2.push(s1.pop());
		Object pop = s2.pop();
		while (!s2.isEmpty())
			s1.push(s2.pop());
		return pop;
	}

	/*
	 * copy queue to stack so that queue also maintains the same order of queue
	 * Use stack - push, pop, Queue - enque,deque operations - should do it in
	 * constant space
	 */
	// Time : O(n), Space : O(1)
	public void queueToStack(Deque<Integer> q, Stack stack) {
		while (!q.isEmpty())
			stack.push(q.removeFirst());
		while (!stack.isEmpty())
			q.addLast((Integer) stack.pop());
		while (!q.isEmpty())
			stack.push(q.removeFirst());
	}

	public void interleavingQueueWithTwoStacks(Deque<Integer> q) {
		int n = q.size();
		Stack s1 = new Stack();
		Stack s2 = new Stack();
		for (int i = 0; i < n; i++) {
			if (i < n / 2)
				s1.push(q.removeFirst());
			else
				s2.push(q.removeFirst());
		}

		while (!s1.isEmpty() || !s2.isEmpty()) {
			q.addLast((Integer) s1.pop());
			q.addLast((Integer) s2.pop());
		}

		for (int i = 0; i < n; i++) {
			if (i % 2 == 0)
				s1.push(q.removeFirst());
			else
				s2.push(q.removeFirst());
		}

		while (!s1.isEmpty() || !s2.isEmpty()) {
			q.addLast((Integer) s1.pop());
			q.addLast((Integer) s2.pop());
		}

	}

	/*
	 * rearrange queue with first and second half if q is {1,2,3,4,5,6,7,8} then
	 * it should be { 1,5,2,6,3,7,4,8}
	 */
	// Time : O(n), Space : O(n)
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

}
