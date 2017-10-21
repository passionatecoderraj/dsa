/**
 *
 */
package com.raj.java.threading;

/**
 * @author Raj
 */

class SimpleThread2 implements Runnable {
	String name;
	Semaphore mutex;

	public SimpleThread2(String name, Semaphore mutex) {
		this.name = name;
		this.mutex = mutex;
	}

	@Override
	public void run() {
		mutex.down();
		for (int i = 0; i < 10; i++) {
			System.out.println(this.name + " says " + i);
		}
		try {
			Thread.sleep((long) Math.random() * 100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(this.name + " is done.");
		mutex.up();
	}
}

public class SemaphoreExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Semaphore mutex = new Semaphore(2);
		Thread t1 = new Thread(new SimpleThread2("t1", mutex));
		Thread t2 = new Thread(new SimpleThread2("t2", mutex));
		Thread t3 = new Thread(new SimpleThread2("t3", mutex));
		Thread t4 = new Thread(new SimpleThread2("t4", mutex));
		t1.start();
		t2.start();
		t3.start();
		t4.start();

	}

}
