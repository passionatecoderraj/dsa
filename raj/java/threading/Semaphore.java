package com.raj.java.threading;

public class Semaphore {
    int count;

    public Semaphore(int count) {
        if (count < 0) {
            count = 0;
        }
        this.count = count;
    }

    public synchronized void down() {
        while (count == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        count--;
    }

    public synchronized void up() {
        count++;
        notify();
    }
}
