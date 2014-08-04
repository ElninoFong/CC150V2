package chapter_2;

import java.util.Stack;
import CtCILibrary.LinkedListNode;

/*
 * 2.7 
 * Implement a function to check if a linked list is a palindrome.
 */
public class Question2_7 {
	// Solution
	// 1. reverse linked list and compare half part
	// 2. use stack
	// 3. recursive
	
	// TC:O(n), SC:O(n)
	// use stack
	public static boolean isPalindrome1(LinkedListNode head) {
		if (head == null) return true;
		LinkedListNode slow = head;
		LinkedListNode fast = head;
		Stack<Integer> st = new Stack<Integer>();
		
		// find the middle
		while (fast != null && fast.next != null) {
			st.push(slow.data);
			slow = slow.next;
			fast = fast.next.next;
		}
		
		// check if the length is odd
		if (fast != null) {
			slow = slow.next;
		}
		
		// compare
		while (!st.isEmpty()) {
			if (slow.data != st.pop()) return false;
			slow = slow.next;
		}
		
		return true;
	}
	
	
	// TC:O(n), SC:O(n)
	// recursive
	public static boolean isPalindrome2(LinkedListNode head) {
		if (head == null) return true; 
		int length = getLength(head);
		Question2_7.Result res = isPalindrome2(head, length);
		return res.isPal;
	}
	
	public static Question2_7.Result isPalindrome2(LinkedListNode node, int length) {
		if (length == 0) return new Question2_7.Result(node, true);		// length is even
		if (length == 1) return new Question2_7.Result(node.next, true);	// length is odd
		Question2_7.Result res = isPalindrome2(node.next, length - 2);
		return new Question2_7.Result(res.node.next, (res.isPal && (node.data == res.node.data)));
	}
	
	public static int getLength(LinkedListNode head) {
		int length = 0;
		while (head != null) {
			length++;
			head = head.next;
		}
		return length;
	}
	
	static class Result {		// be careful of usage of nested class
		LinkedListNode node;
		boolean isPal;
		public Result(LinkedListNode n, boolean b) {
			node = n;
			isPal = b;
		}
	}
	
	
	
	public static void main(String[] args) {
        int length = 9;
        LinkedListNode[] nodes = new LinkedListNode[length];
        for (int i = 0; i < length; i++) {
            nodes[i] = new LinkedListNode(i >= length / 2 ? length - i - 1 : i, null, null);
        }
        
        for (int i = 0; i < length; i++) {
            if (i < length - 1) {
                nodes[i].setNext(nodes[i + 1]);
            }
            if (i > 0) {
                nodes[i].setPrevious(nodes[i - 1]);
            }
        }
//        nodes[length - 2].data = 9; // Uncomment to ruin palindrome
        
        LinkedListNode head = nodes[0];
        System.out.println(head.printForward());
        System.out.println(isPalindrome1(head));
        System.out.println(isPalindrome2(head));
	}
}
