/**
 *
 */
package com.raj.java.threading;

/**
 * @author Raj
 */

class OddMutex {
    int n = 1;
    Semaphore mutex = new Semaphore(1);

    public int next() {
        mutex.down();
        ++n;
        try {
            Thread.sleep((long) Math.random() * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        n++;
        mutex.up();
        return n;
    }
}

class CallOddMutex implements Runnable {
    OddMutex odd;

    public CallOddMutex(OddMutex odd) {
        this.odd = odd;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(odd.next());
        }
    }
}

public class PrintOdds {

    /**
     * @param args
     */
    public static void main(String[] args) {
        OddMutex odd = new OddMutex();
        Thread t1 = new Thread(new CallOddMutex(odd));
        Thread t2 = new Thread(new CallOddMutex(odd));

        t1.start();
        t2.start();

    }

}
