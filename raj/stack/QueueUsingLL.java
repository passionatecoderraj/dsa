package com.raj.stack;

class Node {
	int data;
	Node next;

	public Node(int data) {
		this.data = data;
		this.next = null;
	}
}

public class QueueUsingLL {
	Node front = null;
	Node rear = null;

	public void enQueue(int data) {
		Node nn = new Node(data);
		if (null == rear) {
			front = rear = nn;
		} else {
			rear.next = nn;
			rear = rear.next;
		}
	}

	public int deQueue() {
		if (null == front)
			return -1;
		int data = front.data;
		front = front.next;
		return data;
	}

	public int top() {
		if (null == front)
			return -1;
		return front.data;
	}

	public void display() {
		Node temp = front;
		if (null == temp) {
			System.out.println("Empty");
			return;
		}
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}

	public static void main(String args[]) {
		QueueUsingLL obj = new QueueUsingLL();
		obj.display();
		obj.enQueue(10);
		obj.enQueue(20);
		obj.enQueue(30);
		obj.enQueue(40);
		obj.enQueue(50);
		obj.display();
		int res;
		res = obj.top();
		System.out.println(res);
		res = obj.deQueue();
		System.out.println(res);
		obj.display();

	}

}
