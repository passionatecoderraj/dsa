/**
 * 
 */
package com.raj.mathamatical;

import java.util.Comparator;
import java.util.PriorityQueue;

import com.interivew.graph.CommonUtil;

/**
 * @author Raj
 * 
 * 
 *         Write a program to find the nth super ugly number.
 * 
 *         Super ugly numbers are positive numbers whose all prime factors are
 *         in the given prime list primes of size k. For example, [1, 2, 4, 7,
 *         8, 13, 14, 16, 19, 26, 28, 32] is the sequence of the first 12 super
 *         ugly numbers given primes = [2, 7, 13, 19] of size 4.
 * 
 *         Note: (1) 1 is a super ugly number for any given primes. (2) The
 *         given numbers in primes are in ascending order. (3) 0 < k ≤ 100, 0 <
 *         n ≤ 106, 0 < primes[i] < 1000. (4) The nth super ugly number is
 *         guaranteed to fit in a 32-bit signed integer.
 */
public class NthSuperUglyNumber {

	public static int nthSuperUglyNumber(int n, int a[]) {
		int t[] = new int[n];
		t[0] = 1;
		class Node {
			int uglyIndex;
			int primeNumber;
			int factorOfPrime;

			public Node(int uglyIndex, int primeNumber, int factorOfPrime) {
				this.uglyIndex = uglyIndex;
				this.primeNumber = primeNumber;
				this.factorOfPrime = factorOfPrime;
			}
		}
		PriorityQueue<Node> pq = new PriorityQueue<>(a.length, new Comparator<Node>() {
			public int compare(Node n1, Node n2) {
				return n1.factorOfPrime - n2.factorOfPrime;
			}
		});

		for (int i : a) {
			pq.offer(new Node(0, i, t[0] * i));
		}

		for (int i = 1; i < n; i++) {
			Node min = pq.peek();
			t[i] = min.factorOfPrime;
			while (pq.peek().factorOfPrime == t[i]) {
				Node temp = pq.poll();
				temp.uglyIndex++;
				temp.factorOfPrime = t[temp.uglyIndex] * temp.primeNumber;
				pq.offer(temp);
			}
		}
		CommonUtil.printArray(t);
		return t[n - 1];
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int res = -1;
		int primes[] = { 2, 3, 5 };
		res = nthSuperUglyNumber(11, primes);
		System.out.println(res);
		res = nthSuperUglyNumber(11, primes);
		System.out.println(res);
	}

}
