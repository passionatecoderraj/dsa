/**
 * 
 */
package com.raj.java;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Raj
 *
 */
public class ProducerConsumerProblem {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int size = 5;
		Deque<Integer> q = new ArrayDeque<Integer>();
		Thread p = new Thread(new Producer(q, size), "Producer");
		p.start();
		Thread c = new Thread(new Consumer(q, size), "Consumer");
		c.start();
	}
}
