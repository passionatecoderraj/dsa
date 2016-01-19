package com.raj.stack;

public class StackSorting {

	public static void main(String[] args) {
		Stack stack = new Stack();
		stack.push(9);
		stack.push(6);
		stack.push(8);
		stack.push(0);
		stack.push(3);
		stack.push(7);
		stack.print();

		// Time : O(n2), Space : O(n)
		StackSorting obj = new StackSorting();
		stack = obj.sort(stack);
		stack.print();
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

}
