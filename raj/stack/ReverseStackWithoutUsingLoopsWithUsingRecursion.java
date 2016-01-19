package com.raj.stack;

public class ReverseStackWithoutUsingLoopsWithUsingRecursion {

	public static void main(String[] args) {
		Stack stack = new Stack();
		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.push(40);
		stack.push(50);
		stack.print();

		// Time : O(n2), Space : O(n)
		ReverseStackWithoutUsingLoopsWithUsingRecursion obj = new ReverseStackWithoutUsingLoopsWithUsingRecursion();
		obj.reverseStackWithoutUsingLoops(stack);
		stack.print();
	}

	public void reverseStackWithoutUsingLoops(Stack stack) {
		if (stack.isEmpty())
			return;
		Object data = stack.pop();
		reverseStackWithoutUsingLoops(stack);
		insertAtBottomOfStack(stack, data);
	}

	public void insertAtBottomOfStack(Stack stack, Object data) {
		if (stack.isEmpty()) {
			stack.push(data);
			return;
		}
		Object temp = stack.pop();
		insertAtBottomOfStack(stack, data);
		stack.push(temp);
	}

}
