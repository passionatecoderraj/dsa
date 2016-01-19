/**
 * 
 */
package com.raj.stack;

/**
 * @author Raj
 *
 */
public class StackWithGetMinimumInO1 {

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
		StackWithGetMinimumInO1 stack = new StackWithGetMinimumInO1();

		// Time : O(1), Space: O(n)
		stack.push(9);
		stack.push(6);
		stack.push(8);
		stack.push(0);
		stack.push(3);
		stack.push(7);
		stack.print();
		System.out.println(stack.getMinimum());

		StackWithGetMinimumInO1 stack2 = new StackWithGetMinimumInO1();
		// Time : O(1), Space: O(n) , but better than above
		stack2.pushOptimizedSpace(9);
		stack2.pushOptimizedSpace(6);
		stack2.pushOptimizedSpace(8);
		stack2.pushOptimizedSpace(0);
		stack2.pushOptimizedSpace(3);
		stack2.pushOptimizedSpace(7);
		stack2.popOptimizedSpace();
		stack2.popOptimizedSpace();
		stack2.popOptimizedSpace();
		stack2.print();
		System.out.println(stack2.getMinimum());

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
