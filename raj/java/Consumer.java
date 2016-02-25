package com.raj.java;

import java.util.Deque;

public class Consumer implements Runnable {

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
