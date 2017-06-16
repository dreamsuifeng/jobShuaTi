package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/*
 * this problem is also solved by TreeMap which is based on red-black tree,
 * it's a balanced BST and really O(lgN) on sequence stream.
 */
public class DataStreamasDisjointIntervals352 {
	public class Interval {
		int start;
		int end;

		Interval() {
			start = 0;
			end = 0;
		}

		Interval(int s, int e) {
			start = s;
			end = e;
		}
	}

	class Node {
		int val;
		Node left;
		Node right;

		public Node(int i) {
			val = i;
		}
	}

	Node root;

	private Node addNode(int num, Node head) {
		if (head == null) {
			head = new Node(num);

		}
		if (num > head.val) {
			head.right = addNode(num, head.right);
		}
		if (num < head.val) {
			head.left = addNode(num, head.left);
		}
		return head;
	}

	private LinkedList<Interval> getList(Node h) {
		LinkedList<Interval> tmp = new LinkedList<>();
		if (h == null)
			return tmp;
		if (h.left == null && h.right == null) {
			Interval it = new Interval(h.val, h.val);
			tmp.add(it);
			return tmp;
		}
		LinkedList<Interval> leftList = getList(h.left);
		LinkedList<Interval> rightList = getList(h.right);
		Interval leftlast = leftList.peekLast();
		Interval rightfirst = rightList.peekFirst();
		if (leftlast != null && leftlast.end + 1 == h.val) {
			leftlast.end += 1;
			leftList.pollLast();
			leftList.add(leftlast);
		} else if (leftlast == null || leftlast.end + 1 < h.val) {
			leftList.add(new Interval(h.val, h.val));
			leftlast=leftList.peekLast();
		}
		if (rightfirst!=null && rightfirst.start-1==leftlast.end){
			leftlast.end=rightfirst.end;
			leftList.pollLast();
			leftList.add(leftlast);
			rightList.pollFirst();
		}
		leftList.addAll(rightList);
		return leftList;
		
	}

	public DataStreamasDisjointIntervals352() {
		this.root = null;
	}

	public void addNum(int val) {
		this.root = addNode(val, this.root);
	}

	public List<Interval> getIntervals() {
		return this.getList(this.root);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
