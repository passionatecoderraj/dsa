package com.interivew.practice;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

import com.interivew.graph.CommonUtil;
import com.raj.nodes.AVLTreeNode;
import com.raj.nodes.BinaryTreeNode;
import com.raj.nodes.DLLNode;
import com.raj.sorting.MergeSort;
import com.raj.trees.binary.BinaryTree;
import com.raj.trees.bst.AVLTree;

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
		if (null == root)
			return root;
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
		BinaryTreeNode<Integer> predessor, successor;
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

	public void findPairWithSumK(BinaryTreeNode<Integer> root, int k) {
		if (null == root) {
			return;
		}

		Deque<BinaryTreeNode<Integer>> stack1 = new LinkedList<BinaryTreeNode<Integer>>();
		Deque<BinaryTreeNode<Integer>> stack2 = new LinkedList<BinaryTreeNode<Integer>>();
		BinaryTreeNode<Integer> temp1, temp2, pop1 = null, pop2 = null;
		temp1 = temp2 = root;
		while (true) {
			if (temp1 != null || temp2 != null) {
				if (temp1 != null) {
					stack1.push(temp1);
					temp1 = temp1.left;
				}
				if (temp2 != null) {
					stack2.push(temp2);
					temp2 = temp2.left;
				}

			} else {
				if (stack1.isEmpty() || stack2.isEmpty())
					break;
				pop1 = stack1.pop();
				pop2 = stack2.pop();

				int sum = pop1.data + pop2.data;
				if (sum > k) {
					temp1 = pop1.right;
					stack2.push(pop2);
				} else if (sum < k) {
					temp2 = pop2.right;
					stack1.push(pop1);
				} else {
					System.out.println(pop1.data + "+" + pop2.data + "=" + k);
					temp1 = pop1.right;
					temp2 = pop2.right;
				}
			}

		}
	}

	// Two nodes of a BST are swapped, correct the BST
	// two cases :
	// case 1 : two numbers are not in order (10,2)
	// 10 and 2 are swapped
	// {1,10,3,6,10,7,2,12}
	// case 2 : two swapped can be not adjacent
	// case 2 : only one number is misplaced that is 2
	// (or adjacent elements are misplaced)
	// {1,3,2,6,7,10, 12}
	// Time : O(n)

	public void fixSwappedNodesInBSTOptimized(BinaryTree tree) {
		n1 = null;
		n2 = null;
		prev = null;
		findSwappedNodesOptimized(tree.root);
		CommonUtil.swap(n1, n2);
	}

	BinaryTreeNode<Integer> n1;
	BinaryTreeNode<Integer> n2;
	BinaryTreeNode<Integer> prev;

	public void findSwappedNodesOptimized(BinaryTreeNode<Integer> root) {
		if (null == root)
			return;
		findSwappedNodesOptimized(root.left);
		if (prev != null) {
			if (root.data < prev.data) {
				if (n1 == null) {
					n1 = prev;
				}
				n2 = root;
			}
		}
		prev = root;

		findSwappedNodesOptimized(root.right);
	}

	public void constructBstFromBinaryTree(BinaryTreeNode<Integer> root) {
		int a[] = new int[BinaryTree.size(root)];
		inOrderToCopyInArrayFromTree(root, a);
		Arrays.sort(a);
		inOrderToCopyInTreeFromArray(root, a);
	}

	int idx = 0;

	public void inOrderToCopyInArrayFromTree(BinaryTreeNode<Integer> root, int a[]) {
		if (null == root)
			return;
		inOrderToCopyInArrayFromTree(root.left, a);
		a[idx++] = root.data;
		inOrderToCopyInArrayFromTree(root.right, a);
	}

	int indx = 0;

	public void inOrderToCopyInTreeFromArray(BinaryTreeNode<Integer> root, int a[]) {
		if (null == root)
			return;
		inOrderToCopyInTreeFromArray(root.left, a);
		root.data = a[indx++];
		inOrderToCopyInTreeFromArray(root.right, a);
	}

	// count number of bsts with no.of keys
	// it's catalan number
	// it means when we need for 'n' then calculate all possible sums for 'n-1'
	// and multiply them
	// for example, n=4 then for n=3 possible sums are{(3,0),(2,1),(1,2),(0,3)}
	// result = t[0]*t[3] + t[1]*t[2] + t[2]*t[1] + t[3]*t[0]
	public int countNoOfBstsWithKeys(int n) {
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

	// AVL related

	public AVLTreeNode<Integer> rotateRight(AVLTreeNode<Integer> root) {
		AVLTreeNode<Integer> temp = root.left;
		root.left = temp.right;
		temp.right = root;
		temp.height = 1 + Math.max(height(temp.right), height(temp.left));
		root.height = 1 + Math.max(height(root.right), height(root.left));
		return temp;
	}

	public AVLTreeNode<Integer> rotateLeft(AVLTreeNode<Integer> root) {
		AVLTreeNode<Integer> temp = root.right;
		root.right = temp.left;
		temp.left = root;

		temp.height = 1 + Math.max(height(temp.right), height(temp.left));
		root.height = 1 + Math.max(height(root.right), height(root.left));
		return temp;
	}

	public int height(AVLTreeNode<Integer> root) {
		return root == null ? 0 : root.height;
	}

	public AVLTreeNode<Integer> insert(AVLTreeNode<Integer> root, int data) {
		if (null == root) {
			root = new AVLTreeNode<Integer>(data, 1);
		}
		if (root.data > data) {
			root.left = insert(root.left, data);
			if (Math.abs(height(root.left) - height(root.right)) == 2) {
				// LL imbalance
				if (root.left.data > data) {
					root = rotateRight(root);
				} else {
					root.left = rotateLeft(root.left);
					root = rotateRight(root);
				}
			}
		} else {
			root.right = insert(root.right, data);
			// RL imbalance
			if (root.right.data > data) {
				root = rotateLeft(root);

			} else {
				root.right = rotateRight(root.right);
				root = rotateLeft(root);
			}
		}
		root.height = 1 + Math.max(height(root.right), height(root.left));
		return root;
	}

	public AVLTreeNode<Integer> delete(AVLTreeNode<Integer> root, int data) {
		if (root == null)
			return root;
		if (root.data > data) {
			root.left = insert(root.left, data);
			if (Math.abs(height(root.left) - height(root.right)) == 2) {
				// LL imbalance
				if (root.left.data > data) {
					root = rotateRight(root);
				} else {
					root.left = rotateLeft(root.left);
					root = rotateRight(root);
				}
			}
		} else if (root.data < data) {
			root.right = insert(root.right, data);
			// RL imbalance
			if (root.right.data < data) {
				root = rotateLeft(root);

			} else {
				root.right = rotateRight(root.right);
				root = rotateLeft(root);
			}
		} else {
			if (AVLTree.isFullNode(root)) {
				AVLTreeNode<Integer> predec = AVLTree.findMax(root.left);
				root.data = predec.data;
				root.left = delete(root.left, predec.data);
			}
		}
		if (root != null)
			root.height = 1 + Math.max(height(root.right), height(root.left));
		return root;
	}

	// method 1
	public boolean isAvl(AVLTreeNode<Integer> root) {
		if (null == root)
			return true;
		return Math.abs(height(root.left) - height(root.right)) < 2 && isAvl(root.left) && isAvl(root.right);
	}

	// method 2
	// using height function
	// returns -1 if it's not avl; if its avl anything(0 to n) but -1
	public int isAvlUsingHeight(AVLTreeNode<Integer> root) {
		if (null == root)
			return 0;
		int left, right;
		left = isAvlUsingHeight(root.left);
		if (left == -1)
			return -1;
		right = isAvlUsingHeight(root.right);
		if (right == -1)
			return -1;
		if (Math.abs(left - right) >= 2)
			return -1;

		return 1 + Math.max(left, right);
	}

	// method 1
	// Time : O(m+n), Space : O(m+n)
	public AVLTreeNode<Integer> mergeTwoBSTsUsingInorder(AVLTreeNode<Integer> r1, AVLTreeNode<Integer> r2) {
		int m = AVLTree.size(r1);
		int n = AVLTree.size(r2);
		int a[] = new int[m + n];
		inOrder(r1, a);
		inOrder(r2, a);
		new MergeSort().merge(a, 0, m - 1, m + n-1);
		return arrayToAvl(a, 0, m + n - 1);
	}

	public AVLTreeNode<Integer> arrayToAvl(int[] a, int l, int r) {
		if (l > r)
			return null;
		int mid = l + (r - l) / 2;
		AVLTreeNode<Integer> node = new AVLTreeNode<>(a[mid]);
		node.left = arrayToAvl(a, l, mid - 1);
		node.right = arrayToAvl(a, mid + 1, r);
		return node;
	}

	int index = 0;

	public void inOrder(AVLTreeNode<Integer> root, int[] a) {
		if (root != null) {
			inOrder(root.left, a);
			a[index++] = root.data;
			inOrder(root.right, a);
		}
	}

	// method 2
	// mergeTwoBalancedBsts using dll
	// Time : O(m+n), Space : O(1)
	public AVLTreeNode<Integer> mergeTwoBSTsUsingDLLs(AVLTreeNode<Integer> r1, AVLTreeNode<Integer> r2) {
		AVLTreeNode<Integer> head1, head2;
		avl2Dll(r1);
		head1 = headOfAvl;
		avl2Dll(r1);
		head2 = headOfAvl;
		AVLTreeNode<Integer> head = merge(head1, head2);
		return dll2Avl(head);
	}

	public AVLTreeNode<Integer> dll2Avl(AVLTreeNode<Integer> root) {
		if (null == root || root.right == null)
			return root;
		AVLTreeNode<Integer> slow, fast;
		slow = fast = root;
		while (fast.right != null && fast.right.right != null) {
			fast = fast.right.right;
			slow = slow.right;
		}
		AVLTreeNode<Integer> mid = slow;
		mid.right = null;
		mid.left = dll2Avl(root);
		mid.right.left = null;
		mid.right = dll2Avl(mid.right);
		return mid;
	}

	AVLTreeNode<Integer> headOfAvl = null, prevOfAvl = null;

	public void avl2Dll(AVLTreeNode<Integer> root) {
		if (null == root)
			return;
		avl2Dll(root.left);
		if (headOfAvl == null) {
			headOfAvl = root;
		} else {
			root.left = prevOfAvl;
			prevOfAvl.right = root;
		}
		prevOfAvl = root;
		avl2Dll(root.right);
	}

	public AVLTreeNode<Integer> merge(AVLTreeNode<Integer> head1, AVLTreeNode<Integer> head2) {
		if (head1 == null)
			return head2;
		if (head2 == null)
			return head1;
		if (head1.data <= head2.data) {
			head1.right = merge(head1.right, head2);
			head1.right.left = head1;
			head1.left = null;
			return head1;
		} else {
			head2.right = merge(head1, head2.right);
			head2.right.left = head2;
			head2.left = null;
			return head2;
		}
	}
}
