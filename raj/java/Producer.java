package com.raj.java;

import java.util.Deque;

public class Producer implements Runnable {

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