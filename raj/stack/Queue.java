/**
 * 
 */
package com.raj.stack;

/**
 * @author Raj
 *
 */
public class Queue {

	public int front = -1;
	public int rear = -1;
	public Object[] a;
	public int capacity;

	public Queue() {
		this.capacity = 1;
		a = new Object[capacity];
		front = rear = 0;
	}

	public int size() {
		if (front <= rear) {
			return rear - front;
		} else {
			return rear + 1 + capacity - front;
		}
	}

	public Queue(int capacity) {
		this.capacity = capacity;
		a = new Object[capacity];
		front = rear = 0;
	}

	public Object deque() {
		if (front == rear)
			return null;

		Object pop = a[front];
		front = (front + 1) % capacity;
		return pop;
	}

	public boolean isEmpty() {
		return front == rear;
	}

	public boolean isFull() {
		return (rear + 1) % capacity == front;
	}

	public void print() {
		if (isEmpty()) {
			System.out.println("Empty");
			return;
		}
		int i = front;
		do {
			i = (i + 1) % capacity;
			System.out.print(a[i] + " ");
		} while (i != rear);

		System.out.println();
	}

	public static void main(String[] args) {
		Queue q = new Queue();
		q.enque(10);
		q.enque(20);
		q.enque(30);
		q.deque();
		q.print();
		q.deque();
		q.enque(40);
		q.enque(50);
		q.enque(60);
		q.print();
	}

	public void enque(Object data) {
		if (isFull())
			doubleQueue();
		rear = (rear + 1) % capacity;
		a[rear] = data;
	}

	public void doubleQueue() {
		int oldCapacity = capacity;
		Object[] b = new Object[capacity * 2];
		System.arraycopy(a, 0, b, 0, capacity);
		capacity = capacity * 2;

		if (rear < front) {
			for (int i = 0; i < front; i++) {
				b[i + oldCapacity] = b[i];
				b[i] = null;
			}
			rear = rear + oldCapacity;
		}
		a = b;
	}

}
