/**
 * 
 */
package com.raj.stack;

/**
 * @author Raj
 *
 */
public class StackWithGetMinimumInO1 {

	static class StackNode {
		int data;
		int min;
		StackNode next;

		public StackNode(int data, int min) {
			super();
			this.data = data;
			this.min = min;
		}

		@Override
		public String toString() {
			return "StackNode [data=" + data + ", min=" + min + "]";
		}
	}

	static class StackWithMin {
		StackNode top;

		public void push(int data) {
			int min = getMinimum();
			StackNode node = new StackNode(data, Math.min(min, data));
			if (isEmpty()) {
				top = node;
			}
			node.next = top;
			top = node;
		}

		public StackNode pop() {
			if (isEmpty()) {
				return null;
			}
			StackNode node = top;
			top = top.next;
			return node;
		}

		public boolean isEmpty() {
			return top == null;
		}

		public int getMinimum() {
			if (isEmpty()) {
				return Integer.MAX_VALUE;
			}
			return top.min;
		}
	}

	private Stack stack;
	private Stack minStack;

	public StackWithGetMinimumInO1() {
		stack = new Stack();
		minStack = new Stack();
	}

	public Object top() {
		return stack.pop();
	}

	public boolean isEmpty() {
		return stack.isEmpty();
	}

	public boolean isFull() {
		return stack.isFull();
	}

	public void print() {
		System.out.println("Actual Stack");
		stack.print();
		System.out.println("Min Stack");
		minStack.print();
	}

	public static void main(String[] args) {
		/*
		 * StackWithGetMinimumInO1 stack = new StackWithGetMinimumInO1();
		 * 
		 * // Time : O(1), Space: O(n) stack.push(9); stack.push(6);
		 * stack.push(8); stack.push(0); stack.push(3); stack.push(7);
		 * stack.print(); System.out.println(stack.getMinimum());
		 * 
		 * StackWithGetMinimumInO1 stack2 = new StackWithGetMinimumInO1(); //
		 * Time : O(1), Space: O(n) , but better than above
		 * stack2.pushOptimizedSpace(9); stack2.pushOptimizedSpace(6);
		 * stack2.pushOptimizedSpace(8); stack2.pushOptimizedSpace(0);
		 * stack2.pushOptimizedSpace(3); stack2.pushOptimizedSpace(7);
		 * stack2.popOptimizedSpace(); stack2.popOptimizedSpace();
		 * stack2.popOptimizedSpace(); stack2.print();
		 * System.out.println(stack2.getMinimum());
		 */

		StackWithMin stack3 = new StackWithMin();
		// Time : O(1), Space: O(n) , but better than above
		stack3.push(9);
		stack3.push(6);
		stack3.push(8);
		stack3.push(0);
		stack3.push(3);
		stack3.push(7);
		System.out.println(stack3.getMinimum());

	}

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

}
