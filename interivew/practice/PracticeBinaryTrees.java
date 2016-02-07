package com.interivew.practice;

import java.util.Deque;
import java.util.LinkedList;

import com.interivew.graph.CommonUtil;
import com.raj.nodes.BinaryTreeNode;

public class PracticeBinaryTrees {

	public void preOrder(BinaryTreeNode<Integer> root) {
		if (root != null) {
			System.out.print(root.data + " ");
			preOrder(root.left);
			preOrder(root.right);
		}
	}

	public void inOrder(BinaryTreeNode<Integer> root) {
		if (root != null) {
			inOrder(root.left);
			System.out.print(root.data + " ");
			inOrder(root.right);
		}
	}

	public void postOrder(BinaryTreeNode<Integer> root) {
		if (root != null) {
			postOrder(root.left);
			postOrder(root.right);
			System.out.print(root.data + " ");
		}
	}

	public void inOrderWithoutRecursion(BinaryTreeNode<Integer> root) {
		Deque<BinaryTreeNode<Integer>> stack = new LinkedList<BinaryTreeNode<Integer>>();
		BinaryTreeNode<Integer> temp = root;

		while (true) {
			if (temp != null) {
				stack.push(temp);
				temp = temp.left;
			} else {
				if (stack.isEmpty())
					break;
				BinaryTreeNode<Integer> pop = stack.pop();
				System.out.print(pop.data + " ");
				temp = pop.right;
			}
		}
	}

	public void preOrderWithoutRecursion(BinaryTreeNode<Integer> root) {
		Deque<BinaryTreeNode<Integer>> stack = new LinkedList<BinaryTreeNode<Integer>>();
		BinaryTreeNode<Integer> temp = root;

		while (true) {
			if (temp != null) {
				System.out.print(temp.data + " ");
				stack.push(temp);
				temp = temp.left;
			} else {
				if (stack.isEmpty())
					break;
				BinaryTreeNode<Integer> pop = stack.pop();
				temp = pop.right;
			}
		}
	}

	public void postOrderWithoutRecursion(BinaryTreeNode<Integer> root) {
		Deque<BinaryTreeNode<Integer>> s1 = new LinkedList<BinaryTreeNode<Integer>>();
		Deque<BinaryTreeNode<Integer>> s2 = new LinkedList<BinaryTreeNode<Integer>>();
		BinaryTreeNode<Integer> temp = null;
		s1.push(root);
		while (!s1.isEmpty()) {
			temp = s1.pop();
			s2.push(temp);
			if (temp.left != null)
				s1.push(temp.left);
			if (temp.right != null)
				s1.push(temp.right);

		}
		while (!s2.isEmpty())
			System.out.print(s1.pop().data + " ");
		System.out.println();
	}

	public void levelOrder(BinaryTreeNode<Integer> root) {
		Deque<BinaryTreeNode<Integer>> q = new LinkedList<BinaryTreeNode<Integer>>();
		BinaryTreeNode<Integer> temp = null;

		q.addLast(root);

		while (!q.isEmpty()) {
			temp = q.removeFirst();
			System.out.print(temp.data + " ");
			if (temp.left != null)
				q.addLast(temp.left);
			if (temp.right != null)
				q.addLast(temp.right);
		}
		System.out.println();
	}

	public BinaryTreeNode<Integer> insert(BinaryTreeNode<Integer> root, int data) {
		Deque<BinaryTreeNode<Integer>> q = new LinkedList<BinaryTreeNode<Integer>>();

		BinaryTreeNode<Integer> nn = new BinaryTreeNode<>(data);
		if (root == null) {
			root = nn;
			return root;
		}

		BinaryTreeNode<Integer> temp = null;
		q.addLast(root);

		while (!q.isEmpty()) {
			temp = q.removeFirst();
			if (temp.left != null)
				q.addLast(temp.left);
			else {
				temp.left = nn;
				return root;
			}
			if (temp.right != null)
				q.addLast(temp.right);
			else {
				temp.right = nn;
				return root;
			}
		}
		System.out.println();
		return root;
	}

	public BinaryTreeNode<Integer> delete(BinaryTreeNode<Integer> root) {
		if (null == root)
			return null;
		delete(root.left);
		delete(root.right);
		root = null;
		return root;
	}

	public int size(BinaryTreeNode<Integer> root) {
		if (null == root)
			return 0;
		return 1 + size(root.left) + size(root.right);
	}

	public int findMaxWithoutRecursion(BinaryTreeNode<Integer> root) {
		Deque<BinaryTreeNode<Integer>> q = new LinkedList<BinaryTreeNode<Integer>>();
		int max = Integer.MIN_VALUE;
		if (root == null)
			return max;
		BinaryTreeNode<Integer> temp = null;
		q.addLast(root);

		while (!q.isEmpty()) {
			temp = q.removeFirst();
			max = Math.max(temp.data, max);
			if (temp.left != null)
				q.addLast(temp.left);
			if (temp.right != null)
				q.addLast(temp.right);
		}
		return max;
	}

	public int findMax(BinaryTreeNode<Integer> root, int max) {
		if (root == null)
			return max;
		int lmax, rmax;
		lmax = findMax(root.left, max);
		rmax = findMax(root.right, max);

		max = Math.max(root.data, Math.max(lmax, rmax));
		return max;
	}

	public boolean search(BinaryTreeNode<Integer> root, int data) {
		if (root == null)
			return false;
		if (root.data == data)
			return true;
		return search(root.left, data) && search(root.right, data);
	}

	public boolean searchWithoutRecursion(BinaryTreeNode<Integer> root, int data) {
		Deque<BinaryTreeNode<Integer>> q = new LinkedList<BinaryTreeNode<Integer>>();
		if (root == null)
			return false;
		BinaryTreeNode<Integer> temp = null;
		q.addLast(root);

		while (!q.isEmpty()) {
			temp = q.removeFirst();
			if (temp.data == data)
				return true;
			if (temp.left != null)
				q.addLast(temp.left);
			if (temp.right != null)
				q.addLast(temp.right);
		}
		return false;
	}

	public int height(BinaryTreeNode<Integer> root) {
		if (null == root)
			return 0;
		return 1 + Math.max(height(root.left), height(root.right));
	}

	public int heightWithoutRecursion(BinaryTreeNode<Integer> root) {
		Deque<BinaryTreeNode<Integer>> q = new LinkedList<BinaryTreeNode<Integer>>();
		int level = 0;
		if (root == null)
			return level;
		BinaryTreeNode<Integer> temp = null;
		q.addLast(root);
		q.addLast(null);

		while (!q.isEmpty()) {
			temp = q.removeFirst();
			if (temp == null) {
				level++;
				if (q.isEmpty())
					break;
				q.addLast(null);
				continue;
			}
			if (temp.left != null)
				q.addLast(temp.left);
			if (temp.right != null)
				q.addLast(temp.right);
		}
		return level;
	}

	public BinaryTreeNode<Integer> deepestNode(BinaryTreeNode<Integer> root) {
		Deque<BinaryTreeNode<Integer>> q = new LinkedList<BinaryTreeNode<Integer>>();
		BinaryTreeNode<Integer> temp = null;

		q.addLast(root);

		while (!q.isEmpty()) {
			temp = q.removeFirst();
			System.out.print(temp.data + " ");
			if (temp.left != null)
				q.addLast(temp.left);
			if (temp.right != null)
				q.addLast(temp.right);
		}
		return temp;
	}

	public static boolean isLeaf(BinaryTreeNode<Integer> root) {
		return root.left == null && root.right == null;
	}

	public static boolean isFullNode(BinaryTreeNode<Integer> root) {
		return root.left != null && root.right != null;
	}

	public static boolean isHalfNode(BinaryTreeNode<Integer> root) {
		return (root.left != null && root.right == null) || (root.left == null && root.right != null);
	}

	public int numberofLeaves(BinaryTreeNode<Integer> root) {
		if (null == root)
			return 0;
		if (isLeaf(root))
			return 1;
		return numberofLeaves(root.left) + numberofLeaves(root.right);
	}

	public int numberOfLeavesWithoutRecursion(BinaryTreeNode<Integer> root) {
		int count = 0;
		if (root == null)
			return count;

		Deque<BinaryTreeNode<Integer>> q = new LinkedList<BinaryTreeNode<Integer>>();
		BinaryTreeNode<Integer> temp = null;

		q.addLast(root);

		while (!q.isEmpty()) {
			temp = q.removeFirst();
			if (isLeaf(temp))
				count++;

			if (temp.left != null)
				q.addLast(temp.left);
			if (temp.right != null)
				q.addLast(temp.right);
		}
		return count;
	}

	public int numberofHalfNodes(BinaryTreeNode<Integer> root) {
		if (null == root)
			return 0;
		int t = 0;
		if (isHalfNode(root))
			t = 1;
		return t + numberofHalfNodes(root.left) + numberofHalfNodes(root.right);
	}

	public int numberOfHalfNodesWithoutRecursion(BinaryTreeNode<Integer> root) {
		int count = 0;
		if (root == null)
			return count;

		Deque<BinaryTreeNode<Integer>> q = new LinkedList<BinaryTreeNode<Integer>>();
		BinaryTreeNode<Integer> temp = null;

		q.addLast(root);

		while (!q.isEmpty()) {
			temp = q.removeFirst();
			if (isHalfNode(temp))
				count++;

			if (temp.left != null)
				q.addLast(temp.left);
			if (temp.right != null)
				q.addLast(temp.right);
		}
		return count;
	}

	public int numberofFullNodes(BinaryTreeNode<Integer> root) {
		if (null == root)
			return 0;
		int t = 0;
		if (isFullNode(root))
			t = 1;
		return t + numberofHalfNodes(root.left) + numberofHalfNodes(root.right);
	}

	public int numberOfFullNodesWithoutRecursion(BinaryTreeNode<Integer> root) {
		int count = 0;
		if (root == null)
			return count;

		Deque<BinaryTreeNode<Integer>> q = new LinkedList<BinaryTreeNode<Integer>>();
		BinaryTreeNode<Integer> temp = null;

		q.addLast(root);

		while (!q.isEmpty()) {
			temp = q.removeFirst();
			if (isFullNode(temp))
				count++;

			if (temp.left != null)
				q.addLast(temp.left);
			if (temp.right != null)
				q.addLast(temp.right);
		}
		return count;
	}

	public boolean isStructurallyIdentical(BinaryTreeNode<Integer> root1, BinaryTreeNode<Integer> root2) {
		if (root1 == null && root2 == null)
			return true;

		if (root1 == null && root2 != null)
			return false;
		if (root1 != null && root2 == null)
			return false;
		return isStructurallyIdentical(root1.left, root2.left) && isStructurallyIdentical(root1.right, root2.right);
	}

	int diameter = Integer.MIN_VALUE;
	BinaryTreeNode<Integer> diameterRoot = null;

	public int diameter(BinaryTreeNode<Integer> root) {
		if (root == null)
			return 0;
		int lh, rh, curDiameter;
		lh = diameter(root.left);
		rh = diameter(root.right);
		curDiameter = 1 + lh + rh;
		if (curDiameter > diameter) {
			diameter = curDiameter;
			diameterRoot = root;
		}
		return 1 + Math.max(lh, rh);
	}

	public int levelThatHasMaxSum(BinaryTreeNode<Integer> root) {
		int level = 0;
		if (root == null)
			return level;

		int levelWithMaxSum = 0;
		int maxSum = -1;
		int curLevelSum = 0;

		Deque<BinaryTreeNode<Integer>> q = new LinkedList<BinaryTreeNode<Integer>>();
		BinaryTreeNode<Integer> temp = null;

		q.addLast(root);
		q.addLast(null);
		while (!q.isEmpty()) {
			temp = q.removeFirst();
			if (temp == null) {
				level++;
				if (curLevelSum > maxSum) {
					maxSum = curLevelSum;
					levelWithMaxSum = level;
				}
				if (q.isEmpty())
					break;
				q.addLast(null);
				curLevelSum = 0;
				continue;
			}
			curLevelSum += temp.data;
			if (temp.left != null)
				q.addLast(temp.left);
			if (temp.right != null)
				q.addLast(temp.right);
		}

		return levelWithMaxSum;
	}

	public void print(int a[], int start, int end) {
		for (int i = start; i <= end; i++) {
			System.out.print(a[i] + " ");
		}
	}

	public void printRootToLeavePaths(BinaryTreeNode<Integer> root, int level, int a[]) {
		if (root == null)
			return;
		a[level] = root.data;
		if (isLeaf(root)) {
			print(a, 0, level);
			return;
		}
		printRootToLeavePaths(root.left, level + 1, a);
		printRootToLeavePaths(root.right, level + 1, a);
	}

	public boolean hasPathSum(BinaryTreeNode<Integer> root, int sum) {
		if (root == null) {
			return sum == 0;
		}
		return hasPathSum(root.left, sum - root.data) || hasPathSum(root.right, sum - root.data);
	}

	public int numberOfNodes(BinaryTreeNode<Integer> root) {
		if (root == null)
			return 0;
		return 1 + numberOfNodes(root.left) + numberOfNodes(root.right);
	}

	public BinaryTreeNode<Integer> mirror(BinaryTreeNode<Integer> root) {
		if (root == null)
			return root;
		mirror(root.left);
		mirror(root.right);
		root = CommonUtil.swapLeftRight(root);
		return root;
	}

	public BinaryTreeNode<Integer> mirrorWithoutRecursion(BinaryTreeNode<Integer> root) {
		if (root == null)
			return root;

		Deque<BinaryTreeNode<Integer>> q = new LinkedList<BinaryTreeNode<Integer>>();
		BinaryTreeNode<Integer> temp = null;

		q.addLast(root);
		while (!q.isEmpty()) {
			temp = q.removeFirst();
			if (temp.left != null)
				q.addLast(temp.left);
			if (temp.right != null)
				q.addLast(temp.right);
			temp = CommonUtil.swapLeftRight(temp);
		}
		return root;
	}

	public boolean areMirrors(BinaryTreeNode<Integer> r1, BinaryTreeNode<Integer> r2) {
		if (r1 == null && r2 == null)
			return true;
		if (r1 == null && r2 != null)
			return false;
		if (r1 != null && r2 == null)
			return false;
		return areMirrors(r1.left, r2.right) && areMirrors(r1.right, r2.left);
	}

	int preOrderIndex = 0;

	public BinaryTreeNode<Integer> buildBinaryTreeFromInorderAnPreorder(int[] preOrder, int[] inOrder, int inOrderStart,
			int inOrderEnd) {
		if (inOrderStart > inOrderEnd)
			return null;
		int data = preOrder[preOrderIndex++];
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(data);

		if (inOrderStart == inOrderEnd)
			return root;

		int inOrderIndex = findInOrderIndex(inOrder, inOrderStart, inOrderEnd, data);
		root.left = buildBinaryTreeFromInorderAnPreorder(preOrder, inOrder, inOrderStart, inOrderIndex - 1);
		root.right = buildBinaryTreeFromInorderAnPreorder(preOrder, inOrder, inOrderIndex + 1, inOrderEnd);
		return root;
	}

	public int findInOrderIndex(int[] inOrder, int inOrderStart, int inOrderEnd, int data) {
		for (int i = inOrderStart; i <= inOrderEnd; i++) {
			if (inOrder[i] == data) {
				return i;
			}
		}
		return -1;
	}

	public boolean findAllAncestors(BinaryTreeNode<Integer> root, int data) {
		if (null == root)
			return false;
		if (root.data == data) {
			System.out.print(root.data + " ");
			return true;
		}
		if (findAllAncestors(root.left, data) || findAllAncestors(root.right, data)) {
			System.out.print(root.data + " ");
			return true;
		}
		return false;
	}

	public BinaryTreeNode<Integer> lca(BinaryTreeNode<Integer> root, int a, int b) {
		if (null == root)
			return null;
		if (root.data == a || root.data == b)
			return root;
		BinaryTreeNode<Integer> left, right;
		left = lca(root.left, a, b);
		right = lca(root.right, a, b);
		if (left != null && right != null)
			return root;
		return left != null ? left : right;
	}

	// Time :O(n2)
	public void levelOrderSpiral(BinaryTreeNode<Integer> root) {
		int height = height(root);
		boolean ltr = false;
		for (int i = 1; i <= height; i++) {
			printNodesAtGivenLevel(root, i, ltr);
		}
	}

	public void printNodesAtGivenLevel(BinaryTreeNode<Integer> root, int level, boolean ltr) {
		if (level == 1) {
			System.out.print(root.data + " ");
		} else {
			if (ltr) {
				printNodesAtGivenLevel(root.left, level - 1, ltr);
				printNodesAtGivenLevel(root.right, level - 1, ltr);
			} else {
				printNodesAtGivenLevel(root.right, level - 1, ltr);
				printNodesAtGivenLevel(root.left, level - 1, ltr);
			}
		}
	}

	public void levelOrderSpiralWithoutRecursion(BinaryTreeNode<Integer> root) {
		if (null == root)
			return;
		Deque<BinaryTreeNode<Integer>> s1 = new LinkedList<BinaryTreeNode<Integer>>();
		Deque<BinaryTreeNode<Integer>> s2 = new LinkedList<BinaryTreeNode<Integer>>();
		BinaryTreeNode<Integer> temp = null;
		s1.push(root);
		while (!s1.isEmpty() || !s2.isEmpty()) {
			while (!s1.isEmpty()) {
				temp = s1.pop();
				System.out.print(temp.data + " ");
				if (temp.right != null)
					s2.push(temp.right);
				if (temp.left != null)
					s2.push(temp.left);
			}
			while (!s2.isEmpty()) {
				temp = s2.pop();
				System.out.print(temp.data + " ");
				if (temp.left != null)
					s1.push(temp.left);
				if (temp.right != null)
					s1.push(temp.right);
			}
		}
	}

	public void levelOrderSpiralWithoutRecursion2(BinaryTreeNode<Integer> root) {
		if (null == root)
			return;
		Deque<BinaryTreeNode<Integer>> s1 = new LinkedList<BinaryTreeNode<Integer>>();
		Deque<BinaryTreeNode<Integer>> s2 = new LinkedList<BinaryTreeNode<Integer>>();
		boolean ltr = false;
		BinaryTreeNode<Integer> temp = null;
		s1.push(root);
		while (!s1.isEmpty()) {
			temp = s1.pop();
			System.out.print(temp.data + " ");
			if (ltr) {
				if (temp.left != null)
					s2.push(temp.left);
				if (temp.right != null)
					s2.push(temp.right);
			} else {
				if (temp.right != null)
					s2.push(temp.right);
				if (temp.left != null)
					s2.push(temp.left);
			}
			if (s1.isEmpty()) {
				Deque<BinaryTreeNode<Integer>> tmp = s1;
				s1 = s2;
				s2 = tmp;
				ltr = !ltr;
			}
		}
	}

	public void levelOrderInReverse(BinaryTreeNode<Integer> root) {
		int height = height(root);
		for (int i = height; i >= 1; i--) {
			printNodesAtGivenLevel(root, i);
		}
	}

	public void printNodesAtGivenLevel(BinaryTreeNode<Integer> root, int level) {
		if (level == 1) {
			System.out.print(root.data + " ");
		} else {
			printNodesAtGivenLevel(root.left, level - 1);
			printNodesAtGivenLevel(root.right, level - 1);
		}
	}

	public void levelOrderInReverseWithoutRecursion(BinaryTreeNode<Integer> root) {
		Deque<BinaryTreeNode<Integer>> q = new LinkedList<BinaryTreeNode<Integer>>();
		Deque<BinaryTreeNode<Integer>> stack = new LinkedList<BinaryTreeNode<Integer>>();
		BinaryTreeNode<Integer> temp = null;

		q.addLast(root);

		while (!q.isEmpty()) {
			temp = q.removeFirst();
			stack.push(temp);
			if (temp.left != null)
				q.addLast(temp.left);
			if (temp.right != null)
				q.addLast(temp.right);
		}
		while (!stack.isEmpty())
			System.out.print(stack.pop().data + " ");
		System.out.println();
	}

	public void updateNextSiblingWithoutRecursion(BinaryTreeNodeWithSibling<Integer> root) {
		Deque<BinaryTreeNodeWithSibling<Integer>> q = new LinkedList<BinaryTreeNodeWithSibling<Integer>>();
		BinaryTreeNodeWithSibling<Integer> temp = null;

		q.addLast(root);
		q.addLast(null);

		while (!q.isEmpty()) {
			temp = q.removeFirst();
			if (temp == null) {
				if (q.isEmpty())
					break;
				q.addLast(null);
			}
			temp.nextSibling = q.peekFirst();
			if (temp.left != null)
				q.addLast(temp.left);
			if (temp.right != null)
				q.addLast(temp.right);
		}
	}

	public void updateNextSibling(BinaryTreeNodeWithSibling<Integer> root) {
		if (root == null)
			return;

		if (root.left != null)
			root.left.nextSibling = root.right;

		if (root.right != null) {
			if (root.nextSibling != null)
				root.right.nextSibling = root.nextSibling.left;
			else
				root.right.nextSibling = null;
		}

		updateNextSibling(root.left);
		updateNextSibling(root.right);

	}

	// count number of binary trees given preorder length with no.of keys
	// it's catalan number
	// it means when we need for 'n' then calculate all possible sums for 'n-1'
	// and multiply them
	// for example, n=4 then for n=3 possible sums are{(3,0),(2,1),(1,2),(0,3)}
	// result = t[0]*t[3] + t[1]*t[2] + t[2]*t[1] + t[3]*t[0]
	public int countBinaryTreesFromPreorderLength(int n) {
		if (n <= 0)
			return -1;
		int t[] = new int[n + 1];
		t[0] = 1;
		t[1] = 1;

		for (int i = 2; i <= n; i++) {
			for (int j = 0; j < i; j++) {
				t[i] += (t[j] * t[i - 1 - j]);
			}
		}
		return t[n];
	}
}

class BinaryTreeNodeWithSibling<T> {
	public T data;
	public BinaryTreeNodeWithSibling<T> left;
	public BinaryTreeNodeWithSibling<T> right;
	public BinaryTreeNodeWithSibling<T> nextSibling;

	public BinaryTreeNodeWithSibling() {

	}

	public BinaryTreeNodeWithSibling(T data) {
		super();
		this.data = data;
		this.left = null;
		this.right = null;
		this.nextSibling = null;
	}

	@Override
	public String toString() {
		return "BinaryTreeNode [data=" + data + "]";
	}

}
