/**
 *
 */
package com.raj.java.threading;

/**
 * @author Raj
 */

class Odd {
    int n = 1;

    public int next() {
        ++n;
        try {
            Thread.sleep((long) Math.random() * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        n++;
        return n;
    }
}


class CallOdd implements Runnable {
    Odd odd;

    public CallOdd(Odd odd) {
        this.odd = odd;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(odd.next());
        }
    }
}

public class PrintOddsWithoutUsingSemaphore {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Odd odd = new Odd();
        Thread t1 = new Thread(new CallOdd(odd));
        Thread t2 = new Thread(new CallOdd(odd));

        t1.start();
        t2.start();

    }

}
