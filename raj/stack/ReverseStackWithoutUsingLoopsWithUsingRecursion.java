package com.raj.stack;

/**
 * @author Raj 
 * 
 * Reverse a Stack without using recursion and extra space .Even the functional Stack is not allowed.

Examples:

Input : 1->2->3->4
Output : 4->3->2->1

Input :  6->5->4
Output : 4->5->6
 */
public class ReverseStackWithoutUsingLoopsWithUsingRecursion {

    static class StackNode {
        int data;
        StackNode next;

        public StackNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class Stack {
        StackNode top;

        // Push and pop operations
        public void push(int data) {
            if (this.top == null) {
                top = new StackNode(data);
                return;
            }
            StackNode s = new StackNode(data);
            s.next = this.top;
            this.top = s;
        }

        public StackNode pop() {
            StackNode s = this.top;
            this.top = this.top.next;
            return s;
        }

        // prints contents of stack
        public void display() {
            StackNode s = this.top;
            while (s != null) {
                System.out.print(" " + s.data);
                s = s.next;
            }
            System.out.println();
        }

        // Reverses the stack using simple
        // linked list reversal logic.
        public void reverse() {
            StackNode prev, cur, succ;
            cur = prev = this.top;
            cur = cur.next;
            prev.next = null;
            while (cur != null) {

                succ = cur.next;
                cur.next = prev;
                prev = cur;
                cur = succ;
            }
            this.top = prev;
        }
    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);
        stack.display();

        // Time : O(n2), Space : O(n)
        ReverseStackWithoutUsingLoopsWithUsingRecursion obj = new ReverseStackWithoutUsingLoopsWithUsingRecursion();
        obj.reverseStackWithoutUsingLoops(stack);
        stack.display();
        stack.reverse();
        stack.display();
    }

    public void reverseStackWithoutUsingLoops(Stack stack) {
        if (stack.top == null) {
            return;
        }
        StackNode data = stack.pop();
        reverseStackWithoutUsingLoops(stack);
        insertAtBottomOfStack(stack, data.data);
    }

    public void insertAtBottomOfStack(Stack stack, int data) {
        if (stack.top == null) {
            stack.push(data);
            return;
        }
        StackNode temp = stack.pop();
        insertAtBottomOfStack(stack, data);
        stack.push(temp.data);
    }

}
