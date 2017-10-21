package com.raj.java.threading;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintInterleavingEvenOdd {

    private static Thread createThread(Lock lock, Condition condition, CurrentNumber num, boolean isEven) {
        return new Thread(() -> {
            while (true) {
                lock.lock();
                while (num.num % 2 == 0 != isEven) {
                    try {
                        condition.await();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(num.num++);
                try {
                    Thread.sleep(500);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                condition.signalAll();
                lock.unlock();
            }
        });
    }

    static class CurrentNumber {
        int num;
    }

    public static void main(String... args) {
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        CurrentNumber num = new PrintInterleavingEvenOdd.CurrentNumber();

        Thread even = createThread(lock, condition, num, true);
        Thread odd = createThread(lock, condition, num, false);
        even.start();
        odd.start();
    }

}
