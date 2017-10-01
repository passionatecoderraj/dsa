/**
 *
 */
package com.raj.stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Raj
 */
public class StackUsingQueue {

    Queue<Object> q = new LinkedList<>();

    // Time : O(n)
    public void push(Object data) {
        q.offer(data);
        int size = q.size();
        while (size > 1) {
            q.offer(q.poll());
        }
    }

    // Time : O(1)
    public Object pop() {
        if (isEmpty()) {
            return null;
        }
        return q.poll();
    }

    // Time : O(1)
    public Object peek() {
        if (isEmpty()) {
            return null;
        }
        return q.peek();
    }

    // Time : O(1)
    public boolean isEmpty() {
        return !q.isEmpty();
    }

    public static void main(String[] args) {
        StackUsingQueue q = new StackUsingQueue();
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
