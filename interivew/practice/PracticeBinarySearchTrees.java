package com.interivew.practice;

import java.util.Deque;
import java.util.LinkedList;

import com.raj.nodes.BinaryTreeNode;
import com.raj.nodes.DLLNode;

public class PracticeBinarySearchTrees {
	public BinaryTreeNode<Integer> findMax(BinaryTreeNode<Integer> root) {
		if (null == root || root.right == null)
			return root;
		return findMax(root.right);
	}

	public BinaryTreeNode<Integer> findMaxWithoutRecursion(BinaryTreeNode<Integer> root) {
		if (null == root)
			return null;
		while (root.right != null)
			root = root.right;
		return root;
	}

	public BinaryTreeNode<Integer> findMin(BinaryTreeNode<Integer> root) {
		if (null == root || root.left == null)
			return root;
		return findMin(root.left);
	}

	public BinaryTreeNode<Integer> findMinWithoutRecursion(BinaryTreeNode<Integer> root) {
		if (null == root)
			return null;
		while (root.left != null)
			root = root.left;
		return root;
	}

	public BinaryTreeNode<Integer> insert(BinaryTreeNode<Integer> root, int data) {
		if (null == root) {
			root = new BinaryTreeNode<Integer>(data);
			return root;
		}
		if (root.data > data) {
			root.left = insert(root.left, data);
		} else {
			root.right = insert(root.right, data);
		}
		return root;
	}

	public BinaryTreeNode<Integer> delete(BinaryTreeNode<Integer> root, int data) {
		if (null == root) {
			return null;
		}
		if (root.data > data) {
			root.left = delete(root.left, data);
		} else if (root.data < data) {
			root.right = delete(root.right, data);
		} else {
			if (PracticeBinaryTrees.isFullNode(root)) {
				BinaryTreeNode<Integer> inOrderPredessor = findMax(root.left);
				root.data = inOrderPredessor.data;
				root.left = delete(root.left, inOrderPredessor.data);
			} else {
				root = root.left != null ? root.left : root.right;
			}
		}
		return root;
	}

	public BinaryTreeNode<Integer> search(BinaryTreeNode<Integer> root, int data) {
		if (null == root)
			return root;
		if (root.data > data) {
			return search(root.left, data);
		} else if (root.data < data) {
			return search(root.right, data);
		} else {
			return root;
		}
	}

	public BinaryTreeNode<Integer> searchWithoutRecursion(BinaryTreeNode<Integer> root, int data) {
		if (null == root)
			return root;
		while (root != null) {
			if (root.data > data) {
				root = root.left;
			} else if (root.data < data) {
				root = root.right;
			} else {
				return root;
			}
		}
		return null;
	}

	public BinaryTreeNode<Integer> lca(BinaryTreeNode<Integer> root, int a, int b) {
		if (null == root)
			return root;
		if (root.data > Math.max(a, b)) {
			return lca(root.left, a, b);
		} else if (root.data < Math.min(a, b)) {
			return lca(root.right, a, b);
		}
		return root;
	}

	public BinaryTreeNode<Integer> lcaWithoutRecursion(BinaryTreeNode<Integer> root, int a, int b) {
		if (null == root)
			return root;
		while (root != null) {
			if (root.data > Math.max(a, b))
				root = root.left;
			else if (root.data < Math.min(a, b))
				root = root.right;
			else
				return root;
		}
		return null;
	}

	public boolean isBstUsingMinMax(BinaryTreeNode<Integer> root, int min, int max) {
		if (null == root)
			return true;
		if (root.data > min && root.data < max)
			return isBstUsingMinMax(root.left, min, root.data) && isBstUsingMinMax(root.right, root.data, max);
		return false;
	}

	BinaryTreeNode<Integer> pre = null;

	public boolean isBstUsingInorder(BinaryTreeNode<Integer> root) {
		if (null == root)
			return true;
		if (!isBstUsingInorder(root.left))
			return false;
		if (pre == null || root.data > pre.data)
			pre = root;
		else
			return false;
		return isBstUsingInorder(root.right);
	}

	BinaryTreeNode<Integer> headOfDLL = null;
	BinaryTreeNode<Integer> prevOfDLL = null;

	public void bstToDLL(BinaryTreeNode<Integer> root) {
		if (null == root)
			return;
		bstToDLL(root.left);
		if (headOfDLL == null) {
			headOfDLL = root;
		} else {
			prevOfDLL.right = root;
		}
		root.left = prevOfDLL;
		prevOfDLL = root;
		bstToDLL(root.right);
	}

	BinaryTreeNode<Integer> headOfCDLL = null;
	BinaryTreeNode<Integer> prevOfCDLL = null;

	public void bstToCDLL(BinaryTreeNode<Integer> root) {
		if (null == root)
			return;
		bstToDLL(root.left);

		BinaryTreeNode<Integer> right = root.right;
		if (headOfCDLL == null) {
			headOfCDLL = root;
		} else {
			prevOfCDLL.right = root;
		}
		root.left = prevOfCDLL;
		root.right = headOfCDLL;

		prevOfCDLL = root;
		bstToDLL(right);
	}

	public DLLNode<Integer> middle(DLLNode<Integer> node) {
		if (null == node)
			return null;
		DLLNode<Integer> slow, fast;
		slow = fast = node;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		return slow;
	}

	// Tree construction is top down here
	// Time : O(nlogn), Space : O(1)
	public DLLNode<Integer> dllToBST(DLLNode<Integer> head) {
		if (head == null || head.next == null)
			return head;
		DLLNode<Integer> mid = middle(head);

		mid.prev.next = null;
		mid.prev = dllToBST(head);

		if (mid.next != null)
			mid.next.prev = null;
		mid.next = dllToBST(mid.next);
		return mid;
	}

	// this has to be set as head of dll before making function call
	DLLNode<Integer> head = null;

	// Tree construction is bottom up here
	// Time : O(n), Space : O(1)
	public DLLNode<Integer> dllToBSTBottomUp(int n) {
		if (n <= 0)
			return null;
		DLLNode<Integer> node, left, right;
		left = dllToBSTBottomUp(n / 2);
		node = head;
		head = head.next;
		right = dllToBSTBottomUp(n - n / 2 - 1);
		node.prev = left;
		node.next = right;
		return node;
	}

	// Time : O(n), Space : O(n)
	public BinaryTreeNode<Integer> arrayToBst(int a[], int l, int r) {
		if (l > r)
			return null;
		int mid = l + (r - l) / 2;
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(a[mid]);
		root.left = arrayToBst(a, l, mid - 1);
		root.right = arrayToBst(a, mid + 1, r);
		return root;
	}

	int count = 0;

	public BinaryTreeNode<Integer> findKthSmallest(BinaryTreeNode<Integer> root, int k) {
		if (root == null || k <= 0) {
			return null;
		}
		BinaryTreeNode<Integer> left = null;
		left = findKthSmallest(root.left, k);
		if (left != null)
			return left;
		if (++count == k)
			return root;
		return findKthSmallest(root.right, k);
	}

	public BinaryTreeNode<Integer> findKthSmallestWithoutRecursion(BinaryTreeNode<Integer> root, int k) {
		if (root == null || k <= 0)
			return null;
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
				if (++count == k)
					return pop;
				temp = pop.right;
			}
		}
		return null;
	}

	int floor = Integer.MIN_VALUE;
	int ceil = Integer.MAX_VALUE;

	public void floorAndCeilOfBst(BinaryTreeNode<Integer> root, int data) {
		if (root == null)
			return;
		if (root.data > data) {
			ceil = root.data;
			floorAndCeilOfBst(root.left, data);
		} else if (root.data < data) {
			floor = root.data;
			floorAndCeilOfBst(root.right, data);
		} else {
			floor = root.data;
			ceil = root.data;
		}
	}

	// k1 < k2
	public void printRange(BinaryTreeNode<Integer> root, int k1, int k2) {
		if (null == root)
			return;
		if (root.data >= k1) {
			printRange(root.left, k1, k2);
		}
		if (root.data >= k1 && root.data <= k2) {
			System.out.print(root.data + " ");
		}
		if (root.data <= k2) {
			printRange(root.right, k1, k2);
		}
	}

	// k1 < k2
	public void printRangeWithoutRecursion(BinaryTreeNode<Integer> root, int k1, int k2) {
		if (null == root) {
			return;
		}

		Deque<BinaryTreeNode<Integer>> queue = new LinkedList<BinaryTreeNode<Integer>>();
		queue.addLast(root);

		while (!queue.isEmpty()) {
			BinaryTreeNode<Integer> cur = queue.removeFirst();
			if (cur.data >= k1 && cur.data <= k2) {
				System.out.print(cur.data + " ");
			}
			if (cur.left != null)
				queue.addLast(cur.left);
			if (cur.right != null)
				queue.addLast(cur.right);

		}
		System.out.println();
	}

	int rangeCount = 0;

	// k1 < k2
	public void rangeCount(BinaryTreeNode<Integer> root, int k1, int k2) {
		if (null == root)
			return;

		if (root.data >= k1)
			rangeCount(root.left, k1, k2);

		if (root.data >= k1 && root.data <= k2)
			rangeCount++;

		if (root.data <= k2)
			rangeCount(root.right, k1, k2);
	}

	// k1<k2
	public BinaryTreeNode<Integer> pruneBstOutsideRange(BinaryTreeNode<Integer> root, int k1, int k2) {
		root.left = pruneBstOutsideRange(root.left, k1, k2);
		root.right = pruneBstOutsideRange(root.right, k1, k2);
		if (root.data >= k1 && root.data <= k2)
			return root;

		if (root.data < k1)
			return root.right;

		if (root.data > k2)
			return root.left;
		return null;
	}

	// using pre-order
	public BinaryTreeNode<Integer> removeAllLeaves(BinaryTreeNode<Integer> root) {
		if (null == root || PracticeBinaryTrees.isLeaf(root))
			return null;
		root.left = removeAllLeaves(root.left);
		root.right = removeAllLeaves(root.right);
		return root;
	}

	// using post-order
	public BinaryTreeNode<Integer> removeAllHalfNodes(BinaryTreeNode<Integer> root) {
		if (null == root)
			return null;

		root.left = removeAllLeaves(root.left);
		root.right = removeAllLeaves(root.right);

		if (PracticeBinaryTrees.isHalfNode(root)) {
			return root.left != null ? root.left : root.right;
		}
		return root;
	}

	public void inOrderReverse(BinaryTreeNode<Integer> node) {
		if (node != null) {
			inOrderReverse(node.right);
			System.out.print(node.data + " ");
			inOrderReverse(node.left);
		}
	}

	public void inorderReverseWithoutRecursion(BinaryTreeNode<Integer> root) {
		if (null == root) {
			return;
		}

		Deque<BinaryTreeNode<Integer>> stack = new LinkedList<BinaryTreeNode<Integer>>();
		BinaryTreeNode<Integer> pop, temp = root;
		while (true) {
			if (temp != null) {
				stack.push(temp);
				temp = temp.right;
			} else {
				if (stack.isEmpty())
					break;
				pop = stack.pop();
				System.out.print(pop.data + " ");
				temp = pop.left;
			}
		}
		System.out.println();
	}

	BinaryTreeNode<Integer> predessor, successor;

	public void findInorderPredSucc(BinaryTreeNode<Integer> root, int data) {
		if (null == root)
			return;
		if (root.data > data) {
			successor = root;
			findInorderPredSucc(root.left, data);
		} else if (root.data < data) {
			predessor = root;
			findInorderPredSucc(root, data);
		} else {

			// pred
			if (root.left != null) {
				predessor = findMax(root.left);
			}

			// succ
			if (root.right != null) {
				successor = findMin(root.right);
			}

		}
	}

	public void findInorderPredSuccWithoutRecurison(BinaryTreeNode<Integer> root, int data) {
		if (root == null)
			return;
		while (root != null) {
			if (root.data > data) {
				successor = root;
				root = root.left;
			} else if (root.data < data) {
				predessor = root;
				root = root.right;
			} else {
				// pred
				if (root.left != null) {
					predessor = findMax(root.left);
				}

				// succ
				if (root.right != null) {
					successor = findMin(root.right);
				}
				return;
			}
		}
	}
}
