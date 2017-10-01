/**
 *
 */
package com.raj.java.threading;

/**
 * @author Raj
 */

class SimpleThread implements Runnable {
    String name;

    SimpleThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(this.name + " says " + i);
        }
        try {
            Thread.sleep((long) Math.random() * 100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this.name + " is done.");
    }
}

public class MultiThreading1 {

    public static void main(String[] args) {
        Thread t1 = new Thread(new SimpleThread("t1"));
        Thread t2 = new Thread(new SimpleThread("t2"));
        Thread t3 = new Thread(new SimpleThread("t3"));
        Thread t4 = new Thread(new SimpleThread("t4"));
        t1.start();
        t2.start();
        t3.start();
        t4.start();

    }

}
