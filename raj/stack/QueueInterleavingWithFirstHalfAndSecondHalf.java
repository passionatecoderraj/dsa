package com.raj.stack;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;;

/*
 * rearrange queue with first and second half
 * if q is {1,2,3,4,5,6,7,8}
 * then it should be { 1,5,2,6,3,7,4,8}
 */
public class QueueInterleavingWithFirstHalfAndSecondHalf {

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
		QueueInterleavingWithFirstHalfAndSecondHalf obj = new QueueInterleavingWithFirstHalfAndSecondHalf();

		obj.print(q);
		// Time : O(n), Space : O(n)
		obj.interleavingQueueWithTwoStacks(q);
		obj.print(q);
	}

	public void interleavingQueueWithTwoStacks(Deque<Integer> q) {
		int n = q.size();
		Queue<Integer> tq = new LinkedList<>();
		
		for (int i = 0; i < n / 2; i++) {
			tq.offer(q.removeFirst());
		}
		System.out.println(tq);
		for (int i = n / 2; i < n; i++) {
			if (!tq.isEmpty())
				q.addLast(tq.poll());
			q.addLast(q.removeFirst());
		}
	}

	public void interleavingQueueWithTwoStacks2(Deque<Integer> q) {
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

	private void print(Deque<Integer> q) {
		for (Integer i : q) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
}
