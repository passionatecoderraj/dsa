/**
 * 
 */
package com.raj.stack;

/**
 * @author Raj
 *
 */
public class QueueUsingStack {

	Stack s1 = new Stack();
	Stack s2 = new Stack();

	Stack s3 = new Stack();
	Stack s4 = new Stack();

	public void enque(Object data) {
		s1.push(data);
	}

	public Object deQueue() {
		return s3.pop();
	}

	public static void main(String[] args) {
		QueueUsingStack q = new QueueUsingStack();
		q.enque(10);
		q.enque(20);
		q.enque(30);
		q.enque(40);
		q.enque(50);
		q.enque(60);

		System.out.println(q.deQueueOverload());
		System.out.println(q.deQueueOverload());

		QueueUsingStack q2 = new QueueUsingStack();
		q2.enqueOverload(10);
		q2.enqueOverload(20);
		q2.enqueOverload(30);
		q2.enqueOverload(40);
		q2.enqueOverload(50);
		q2.enqueOverload(60);

		System.out.println(q2.deQueue());
		System.out.println(q2.deQueue());

	}

	public void enqueOverload(Object data) {
		while (!s3.isEmpty())
			s4.push(s3.pop());
		s4.push(data);
		while (!s4.isEmpty())
			s3.push(s4.pop());
	}

	public Object deQueueOverload() {
		while (!s1.isEmpty())
			s2.push(s1.pop());
		Object pop = s2.pop();
		while (!s2.isEmpty())
			s1.push(s2.pop());
		return pop;
	}

}
