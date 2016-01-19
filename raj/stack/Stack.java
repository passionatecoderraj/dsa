/**
 * 
 */
package com.raj.stack;

/**
 * @author Raj
 *
 */
public class Stack {

	public int top = -1;
	public Object[] a;
	public int capacity;

	public Stack() {
		this.capacity = 1;
		a = new Object[capacity];
		top = -1;
	}

	public Stack(int capacity) {
		this.capacity = capacity;
		a = new Object[capacity];
		top = -1;
	}

	public int size() {
		return top + 1;
	}

	public Object pop() {
		if (top == -1)
			return null;

		Object pop = a[top];
		top--;
		return pop;
	}

	public Object top() {
		if (top == -1)
			return null;
		return a[top];
	}

	public boolean isEmpty() {
		return top == -1;
	}

	public boolean isFull() {
		return top == capacity - 1;
	}

	public void print() {
		if (top == -1) {
			System.out.println("Empty");
			return;
		}
		for (int i = top; i >= 0; i--) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Stack stack = new Stack();
		stack.push(10);
		stack.push(20);
		stack.print();
		stack.top();
		stack.print();
		stack.pop();
		stack.pop();
		stack.pop();
		stack.print();
	}

	public void doubleStack() {
		Object t[] = new Object[capacity * 2];
		System.arraycopy(a, 0, t, 0, capacity);
		this.capacity = this.capacity * 2;
		a = t;
	}

	public void push(Object data) {
		if (isFull())
			doubleStack();
		a[++top] = data;
	}

}
