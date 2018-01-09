/**
 *
 */
package com.raj.linkedlist;

import com.raj.nodes.ListNode;

/**
 * @author Raj
 * 
 * Given a (singly) linked list with head node root, write a function to split the linked list into k consecutive linked list "parts".

The length of each part should be as equal as possible: no two parts should have a size differing by more than 1. This may lead to some parts being null.

The parts should be in order of occurrence in the input list, and parts occurring earlier should always have a size greater than or equal parts occurring later.

Return a List of ListNode's representing the linked list parts that are formed.

Examples 1->2->3->4, k = 5 // 5 equal parts [ [1], [2], [3], [4], null ]
Example 1:
Input: 
root = [1, 2, 3], k = 5
Output: [[1],[2],[3],[],[]]
Explanation:
The input and each element of the output are ListNodes, not arrays.
For example, the input root has root.val = 1, root.next.val = 2, \root.next.next.val = 3, and root.next.next.next = null.
The first element output[0] has output[0].val = 1, output[0].next = null.
The last element output[4] is null, but it's string representation as a ListNode is [].
Example 2:
Input: 
root = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10], k = 3
Output: [[1, 2, 3, 4], [5, 6, 7], [8, 9, 10]]
Explanation:
The input has been split into consecutive parts with size difference at most 1, and earlier parts are a larger size than the later parts.
Note:

The length of root will be in the range [0, 1000].
Each value of a node in the input will be an integer in the range [0, 999].
k will be an integer in the range [1, 50].

 */
public class SplitLinkedListInParts {

    public ListNode<Integer>[] splitListToParts(ListNode<Integer> root, int k) {
        int nodes = 0;
        ListNode<Integer> temp = root;
        while (temp != null) {
            nodes++;
            temp = temp.next;
        }

        ListNode[] result = new ListNode[k];
        int idx=0;
        ListNode<Integer> cur = root;
        int n = nodes / k, r = nodes % k;
        while(cur!=null) {
            result[idx++] = cur;
            ListNode<Integer> prev = null;
            for (int j = 0; j < n + (r > 0 ? 1 : 0); j++) {
                prev = cur;
                cur = cur.next;
            }
            if (prev != null) {
                prev.next = null;
            }
            r--;
        }

        return result;
    }

    public ListNode<Integer>[] splitListToParts2(ListNode<Integer> root, int k) {
        int nodes = 0;
        ListNode<Integer> temp = root;
        while (temp != null) {
            nodes++;
            temp = temp.next;
        }

        ListNode[] result = new ListNode[k];
        ListNode<Integer> cur = root;
        int b = k;
        for (int i = 0; i < k && nodes > 0; i++) {
            result[i] = cur;
            int n = nodes % b == 0 ? nodes / b : (nodes / b) + 1;
            ListNode<Integer> prev = null;
            for (int j = 0; j < n && cur != null; j++) {
                prev = cur;
                cur = cur.next;
            }
            if (prev != null) {
                prev.next = null;
            }
            nodes -= n;
            b--;
        }

        return result;
    }

    public static void main(String[] args) {
        SingleLinkedList<Integer> obj = new SingleLinkedList<>();
        obj.insert(10);
        obj.insert(20);
        obj.insert(30);
        obj.insert(40);
        obj.insert(50);
        obj.insert(60);
        obj.insert(70);
        // obj.insert(80);

        SplitLinkedListInParts ob = new SplitLinkedListInParts();
        ListNode<Integer>[] result = null;
        result = ob.splitListToParts(obj.root, 3);
        for (ListNode<Integer> r : result) {
            obj.print(r);
        }
    }

    public void print(ListNode<Integer> temp) {
        if (temp == null) {
            System.out.println("(null), ");
            return;
        }
        System.out.print("(");
        while (temp != null) {
            System.out.print(temp.data + ",");
            temp = temp.next;
        }
        System.out.println("), ");
    }

}
