package com.raj.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.TreeSet;

/**
 * 
 * You have an infinite number of stacks arranged in a row and numbered (left to right) from 0, each of the stacks has the same maximum capacity.

Implement the DinnerPlates class:

DinnerPlates(int capacity) Initializes the object with the maximum capacity of the stacks.
void push(int val) pushes the given positive integer val into the leftmost stack with size less than capacity.
int pop() returns the value at the top of the rightmost non-empty stack and removes it from that stack, and returns -1 if all stacks are empty.
int popAtStack(int index) returns the value at the top of the stack with the given index and removes it from that stack, and returns -1 if the stack with that given index is empty.
Example:

Input: 
["DinnerPlates","push","push","push","push","push","popAtStack","push","push","popAtStack","popAtStack","pop","pop","pop","pop","pop"]
[[2],[1],[2],[3],[4],[5],[0],[20],[21],[0],[2],[],[],[],[],[]]
Output: 
[null,null,null,null,null,null,2,null,null,20,21,5,4,3,1,-1]

Explanation: 
DinnerPlates D = DinnerPlates(2);  // Initialize with capacity = 2
D.push(1);
D.push(2);
D.push(3);
D.push(4);
D.push(5);         // The stacks are now:  2  4
                                           1  3  5
                                           ﹈ ﹈ ﹈
D.popAtStack(0);   // Returns 2.  The stacks are now:     4
                                                       1  3  5
                                                       ﹈ ﹈ ﹈
D.push(20);        // The stacks are now: 20  4
                                           1  3  5
                                           ﹈ ﹈ ﹈
D.push(21);        // The stacks are now: 20  4 21
                                           1  3  5
                                           ﹈ ﹈ ﹈
D.popAtStack(0);   // Returns 20.  The stacks are now:     4 21
                                                        1  3  5
                                                        ﹈ ﹈ ﹈
D.popAtStack(2);   // Returns 21.  The stacks are now:     4
                                                        1  3  5
                                                        ﹈ ﹈ ﹈ 
D.pop()            // Returns 5.  The stacks are now:      4
                                                        1  3 
                                                        ﹈ ﹈  
D.pop()            // Returns 4.  The stacks are now:   1  3 
                                                        ﹈ ﹈   
D.pop()            // Returns 3.  The stacks are now:   1 
                                                        ﹈   
D.pop()            // Returns 1.  There are no stacks.
D.pop()            // Returns -1.  There are still no stacks.
 

Constraints:

1 <= capacity <= 20000
1 <= val <= 20000
0 <= index <= 100000
At most 200000 calls will be made to push, pop, and popAtStack.
 *
 */
class DinnerPlates {
	Map<Integer, Stack<Integer>> map;
	int N;
	int pushPos;
	int popPos;
	TreeSet<Integer> gaps;
	int count = 0;

	public DinnerPlates(int capacity) {
		this.map = new HashMap<>();
		this.N = capacity;
		this.pushPos = 0;
		this.popPos = 0;
		this.count = 0;
	}

	public void push(int val) {
		while (map.containsKey(pushPos) && map.get(pushPos).size() == N) {
			pushPos++;
		}
		if (!map.containsKey(pushPos)) {
			map.put(pushPos, new Stack<>());
		}
		count++;
		map.get(pushPos).add(val);
		popPos = Math.max(popPos, pushPos);
	}

	public int pop() {
		if (0 == count)
			return -1;
		while (popPos >= 0 && map.get(popPos).isEmpty()) {
			popPos--;
		}
		count--;
		pushPos = Math.min(popPos, pushPos);
		return map.get(popPos).pop();
	}

	public int popAtStack(int index) {
		if (!map.containsKey(index) || map.get(index).isEmpty())
			return -1;
		count--;
		pushPos = Math.min(popPos, index);
		return map.get(index).pop();
	}

	public void print() {
		for (Stack<Integer> s : map.values()) {
			System.out.println(s);
		}
	}

}

public class DinnerPlateStacks {

	public static void main(String args[]) {
		DinnerPlates ob = new DinnerPlates(2);
		ob.push(1);
		ob.push(2);
		ob.push(3);
		ob.push(4);
		ob.push(5);
		System.out.println(ob.popAtStack(0));
		ob.push(20);
		ob.push(21);

		System.out.println(ob.popAtStack(0));
		System.out.println(ob.popAtStack(2));
		ob.print();
		System.out.println(ob.pop());
		System.out.println(ob.pop());
		System.out.println(ob.pop());
		System.out.println(ob.pop());
		System.out.println(ob.pop());
		ob.push(4);
		ob.print();

	}

}