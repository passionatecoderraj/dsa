package com.raj.java.threading;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintInterleaving {
	private static int running = 0;

	private static Thread createThread2(Lock lock, Condition condition, int curThreadId, int nextThreadId,
			ThreadId runningThreadId) {
		Thread thread = new Thread(() -> {
			while (true) {
				lock.lock();
				while (runningThreadId.getId() != curThreadId) {
					try {
						condition.await();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				System.out.println("" + curThreadId);
				runningThreadId.setId(nextThreadId);
				try {
					Thread.sleep((long) 500);
				} catch (Exception e) {
					e.printStackTrace();
				}
				condition.signalAll();
				lock.unlock();
			}
		});
		return thread;
	}

	private static Thread createThread(Lock lock, Condition condition, int curThreadId, int nextThreadId,
			ThreadId runningThreadId) {
		Thread thread = new Thread(() -> {
			while (true) {
				lock.lock();
				// while (runningThreadId.getId() != curThreadId) {
				while (running != curThreadId) {
					try {
						condition.await();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				System.out.println("" + curThreadId);
				runningThreadId.setId(nextThreadId);
				running = (running + 1) % 4;
				try {
					Thread.sleep((long) 500);
				} catch (Exception e) {
					e.printStackTrace();
				}
				condition.signalAll();
				lock.unlock();
			}
		});
		return thread;
	}

	public static void main(String... args) {
		Lock lock = new ReentrantLock();
		Condition condition = lock.newCondition();
		ThreadId runningThread = new PrintInterleaving.ThreadId(0);
		Thread t0 = createThread(lock, condition, 0, 1, runningThread);
		Thread t1 = createThread(lock, condition, 1, 2, runningThread);
		Thread t2 = createThread(lock, condition, 2, 3, runningThread);
		Thread t3 = createThread(lock, condition, 3, 0, runningThread);
		t0.start();
		t1.start();
		t2.start();
		t3.start();
	}

	static class ThreadId {
		int id;

		public ThreadId(int id) {
			this.id = id;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

	}
}
