/**
 * 
 */
package com.raj.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author Raj
 * 
 * Implement an iterator to flatten a 2d vector.

Example:

Input: 2d vector =
[
  [1,2],
  [3],
  [4,5,6]
]
Output: [1,2,3,4,5,6]
Explanation: By calling next repeatedly until hasNext returns false, 
             the order of elements returned by next should be: [1,2,3,4,5,6].
Follow up:
As an added challenge, try to code it using only iterators in C++ or iterators in Java.


 */

class Vector2D implements Iterator<Integer> {
	private Iterator<List<Integer>> i;
	private Iterator<Integer> j;

	public Vector2D(List<List<Integer>> vec2d) {
		i = vec2d.iterator();
	}

	@Override
	public Integer next() {
		if(hasNext())
			return j.next();
		return null;
	}

	@Override
	public boolean hasNext() {
		while (j == null || (!j.hasNext() && i.hasNext())) {
			j = i.next().iterator();
		}
		return j != null && j.hasNext();
	}

}

class Vector2D_2 implements Iterator<Integer> {
	int i = -1, j = -1;
	List<List<Integer>> a;

	public Vector2D_2(List<List<Integer>> vec2d) {
		this.a = vec2d;
	}

	@Override
	public Integer next() {
		int[] n = getNext();
		if (n == null)
			return null;
		j = n[1];
		return a.get(n[0]).get(n[1]);
	}

	@Override
	public boolean hasNext() {
		return getNext() != null;
	}

	private int[] getNext() {
		while (i + 1 < a.size()) {
			if (j + 1 < a.get(i + 1).size())
				return new int[] { i + 1, j + 1 };
			i++;
			j = -1;
		}
		return null;
	}
}

public class Flatten2DVector {

	public static void main(String... args) {
		List<List<Integer>> list = new ArrayList<>();
		list.add(Arrays.asList(1, 2));
		list.add(Arrays.asList(3));
		list.add(Arrays.asList(4, 5, 6));

		Vector2D obj = new Vector2D(list);
		System.out.println(obj.hasNext());
		System.out.println(obj.next());
	}

}
