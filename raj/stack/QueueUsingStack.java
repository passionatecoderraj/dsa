/**2.i
 *
 */
package com.raj.stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Raj
 * 
 * 
 * Implement the following operations of a queue using stacks.

push(x) -- Push element x to the back of queue.
pop() -- Removes the element from in front of queue.
peek() -- Get the front element.
empty() -- Return whether the queue is empty.
Notes:
You must use only standard operations of a stack -- which means only push to top, peek/pop from top, size, and is empty operations are valid.
Depending on your language, stack may not be supported natively. You may simulate a stack by using a list or deque (double-ended queue), as long as you use only standard operations of a stack.
You may assume that all operations are valid (for example, no pop or peek operations will be called on an empty queue).


 * (Two Stacks) Push - O(1)O(1) per operation, Pop - Amortized O(1)O(1) per operation.
 */
public class QueueUsingStack {

    Deque<Object> s1 = new LinkedList<>();
    Deque<Object> s2 = new LinkedList<>();

    // Time : O(1)
    public void push(Object data) {
        s1.push(data);
    }

    // Time : Amortized O(1)
    public Object pop() {
        if (isEmpty()) {
            return null;
        }

        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        return s2.pop();
    }

    // Time : O(1)
    public Object peek() {
        if (isEmpty()) {
            return null;
        }
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        return s2.peek();
    }

    // Time : O(1)
    public boolean isEmpty() {
        return !s1.isEmpty() && !s2.isEmpty();
    }

    public static void main(String[] args) {
        QueueUsingStack q = new QueueUsingStack();
        q.push(10);
        q.push(20);
        q.push(30);
        q.push(40);
        System.out.println(q.pop());
        System.out.println(q.peek());
        q.push(50);
        q.push(60);
    }

}
