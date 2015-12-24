package com.interivew.graph;

import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * Generic class that implements a min-heap.
 *   @author Dave Reed
 *   @version 11/2/12
 */
public class MinHeap<E extends Comparable<? super E>>  {
    private ArrayList<E> values;

    /**
     * Constructs an empty heap.
     */
    public MinHeap() {
        this.values = new ArrayList<E>();
    }
    
    /**
     * Identifies the minimum value stored in the heap
     *   @return the minimum value
     */
    public E minValue() {
        if (this.values.size() == 0) {
            throw new NoSuchElementException();
        }
        return this.values.get(0);
    }
    
    /**
     * Adds a new value to the heap.
     *   @param newValue the value to be added
     */
    public void add(E newValue) {
        values.add(newValue);
        int pos = this.values.size()-1;
        
        while (pos > 0) {
            if (newValue.compareTo(this.values.get((pos-1)/2)) < 0) {
                values.set(pos, this.values.get((pos-1)/2));
                pos = (pos-1)/2;
            }
            else {
                break;
            }
        }
        this.values.set(pos, newValue);
    }
    
    /**
     * Removes the minimum value from the heap.
     */
    public void remove() {
       E newValue = this.values.remove(this.values.size()-1);
       int pos = 0;
       
       if (this.values.size() > 0) {
           while (2*pos+1 < this.values.size()) {
               int minChild = 2*pos+1;
               if (2*pos+2 < this.values.size() &&
                     this.values.get(2*pos+2).compareTo(this.values.get(2*pos+1)) < 0) {
                   minChild = 2*pos+2;
               }
           
               if (newValue.compareTo(this.values.get(minChild)) > 0) {
                   this.values.set(pos, this.values.get(minChild));
                   pos = minChild;
               }
               else {
                   break;
               }
           }
           this.values.set(pos, newValue);
       }      
    }
    
    /**
     * Converts the heap into its String representation.
     *   @return the String representation
     */
    public String toString() {
        return values.toString();
    }
    
    public static void main(String[] args) {
        int[] items = {5, 3, 7, 6, 1, 4, 2, 8};

        MinHeap<Integer> itemHeap = new MinHeap<Integer>();
        for (int i = 0; i < items.length; i++) {
            itemHeap.add(items[i]);
        }

        for (int i = 0; i < items.length; i++) {
            items[i] = itemHeap.minValue();
            itemHeap.remove();
        }

        for (int i : items) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}