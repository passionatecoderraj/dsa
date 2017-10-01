package com.raj.design;

import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.MIN_VALUE;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 
 * @author Raj
 *
 *Implement a data structure supporting the following operations:

Inc(Key) - Inserts a new key with value 1. Or increments an existing key by 1. Key is guaranteed to be a non-empty string.
Dec(Key) - If Key's value is 1, remove it from the data structure. Otherwise decrements an existing key by 1. If the key does not exist, this function does nothing. Key is guaranteed to be a non-empty string.
GetMaxKey() - Returns one of the keys with maximal value. If no element exists, return an empty string "".
GetMinKey() - Returns one of the keys with minimal value. If no element exists, return an empty string "".
Challenge: Perform all these in O(1) time complexity.
 */
public class AllOne {

    class Node {
        int count;
        Set<String> keys;

        Node next;
        Node prev;

        public Node(int count) {
            this.count = count;
            this.keys = new HashSet<>();
        }

    }

    Node head, tail;
    Map<String, Node> map;

    /** Initialize your data structure here. */
    public AllOne() {
        head = new Node(MIN_VALUE);
        tail = new Node(MAX_VALUE);
        head.next = tail;
        tail.prev = head;
        map = new HashMap<>();
    }

    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
        if (!map.containsKey(key)) {
            addNextToHead(key);
        }
        incrementCount(key);
    }

    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
        if (!map.containsKey(key)) {
            return;
        }
        decreamentCount(key);
    }

    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
        if (tail.prev != head) {
            return tail.prev.keys.iterator().next();
        }
        return "";
    }

    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
        if (head.next != tail) {
            return head.next.keys.iterator().next();
        }
        return "";
    }

    private void addNextToHead(String key) {
        if (head.next.count == 0) {
            head.next.keys.add(key);
        } else {
            Node nn = new Node(0);
            nn.keys.add(key);
            nn.next = head.next;
            nn.prev = head;
            nn.next.prev = nn;
            head.next = nn;
        }
        map.put(key, head.next);
    }

    private void incrementCount(String key) {
        Node node = map.get(key);
        node.keys.remove(key);
        if (node.next.count - node.count == 1) {
            node.next.keys.add(key);
        } else {
            // node.next == tail or node.next.count - node.count >1
            Node nn = new Node(node.count + 1);
            nn.keys.add(key);
            nn.next = node.next;
            nn.prev = node;
            nn.next.prev = nn;
            node.next = nn;
        }
        map.put(key, node.next);
        if (node.keys.isEmpty()) {
            remove(node);
        }
    }

    private void decreamentCount(String key) {
        Node node = map.get(key);
        node.keys.remove(key);

        if (node.count == 1) {
            map.remove(key);
        } else {
            if (node.count - node.prev.count == 1) {
                node.prev.keys.add(key);
            } else {
                // node.prev == head or node.count - node.prev.count >1
                Node nn = new Node(node.count - 1);
                nn.keys.add(key);
                nn.prev = node.prev;
                nn.next = node;
                nn.prev.next = nn;
                node.prev = nn;
            }
            map.put(key, node.prev);
        }

        if (node.keys.isEmpty()) {
            remove(node);
        }

    }

    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public static void main(String... args) {
        AllOne obj = new AllOne();
        String result = "";

        obj.inc("hello");
        obj.inc("goodbye");
        obj.inc("hello");
        obj.inc("hello");
        result = obj.getMaxKey();
        System.out.println(result);
        obj.inc("leet");
        obj.inc("code");
        obj.inc("leet");
        obj.dec("hello");
        obj.print();
        obj.inc("leet");
        obj.inc("code");
        obj.inc("code");

        obj.print();

        result = obj.getMaxKey();
        System.out.println(result);
    }

    public void print() {
        Node cur = head.next;
        while (cur != tail) {
            System.out.println(cur.count + "(" + cur.keys + ")");
            cur = cur.next;
        }
    }
}