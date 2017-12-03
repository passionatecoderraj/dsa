package com.raj.ds;

import java.util.Arrays;

import com.interview.graph.CommonUtil;

public class PriorityQueue {

    void push(int num) {
        decreaseKey(heapSize++, num);
        print();
    }

    int poll() {
        if (heapSize < 1) {
            return -1;
        }
        int min = a[0];
        heapSize--;
        if (heapSize > 0) {
            a[0] = a[heapSize];
            min_heapify(0);
        }
        print();
        return min;
    }

    int a[];
    int heapSize = 0;

    public PriorityQueue() {
        a = new int[100];
        Arrays.fill(a, Integer.MAX_VALUE);
    }

    void min_heapify(int i) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int smallest = i;
        if (left < heapSize && a[left] < a[smallest]) {
            smallest = left;
        }
        if (right < heapSize && a[right] < a[smallest]) {
            smallest = left;
        }
        if (i != smallest) {
            CommonUtil.swap(a, i, smallest);
            min_heapify(smallest);
        }
    }

    void decreaseKey(int idx, int value) {
        if (a[idx] < value) {
            return;
        }
        int parent = idx / 2;
        while (idx != parent && parent >= 0 && a[parent] > value) {
            a[idx] = a[parent];
            idx = parent;
            parent = idx / 2;
        }
        a[idx] = value;
    }

    void print() {
        for (int i = 0; i < heapSize; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public static void main(String args[]) {
        PriorityQueue heap = new PriorityQueue();
        heap.push(30);
        heap.push(10);
        heap.push(40);
        heap.push(20);
        heap.push(10);
        heap.push(30);
        int res = -1;
        res = heap.poll();
        System.out.println(res);
    }
}
