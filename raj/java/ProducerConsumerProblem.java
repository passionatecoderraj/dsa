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

class Producer implements Runnable {

	private Deque<Integer> q;
	private int size;

	public Producer(Deque<Integer> q, int size) {
		super();
		this.q = q;
		this.size = size;
	}

	@Override
	public void run() {
		for (int i = 1; i < 10; i++) {
			try {
				produce(i);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void produce(int i) throws InterruptedException {
		while (q.size() == size) {
			synchronized (q) {
				System.out.println("Q is full " + Thread.currentThread().getName());
				q.wait();
			}
		}
		synchronized (q) {
			System.out.println("Produced: " + i);
			q.addLast(i);
			q.notifyAll();
		}
	}
}

class Consumer implements Runnable {

	private Deque<Integer> q;
	private int size;

	public Consumer(Deque<Integer> q, int size) {
		this.q = q;
		this.size = size;
	}

	@Override
	public void run() {

		while (true) {
			try {
				consume();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void consume() throws InterruptedException {
		while (q.isEmpty()) {
			synchronized (q) {
				System.out.println("Q is empty " + Thread.currentThread().getName());
				q.wait();
			}
		}
		synchronized (q) {
			System.out.println("Consume : " + q.removeFirst());
			q.notifyAll();
		}
	}

}
