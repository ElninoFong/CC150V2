package chapter_2;

import CtCILibrary.AssortedMethods;
import CtCILibrary.LinkedListNode;

/*
 * 2.2 
 * Implement an algorithm to find the kth to last element of a singly linked list.
 */
public class Question2_2 {
	// TC:O(n), SC:O(1)
	// assume 1th to last means the last element
	public static LinkedListNode kthToLast1(LinkedListNode head, int k) {
		if (head == null || k <= 0) return null;
		LinkedListNode p1 = head, p2 = head;
		while (k-- > 0) {
			if (p2 == null) return null;	// out of boundary
			p2 = p2.next;
		}
		while (p2 != null) {
			p1 = p1.next;
			p2 = p2.next;
		}
		return p1;
	}
	
	// TC:O(n), SC:O(n)
	// recursive
	static int kth;	// or use IntWrapper
	public static LinkedListNode kthToLast2(LinkedListNode head, int k) {
		if (head == null) return null;
		LinkedListNode node = kthToLast2(head.next, k);
		if (++kth == k) return head;
		return node;		// return the prev result (found or not found)
	}
	
	public static void main(String[] args) {
        LinkedListNode head = AssortedMethods.randomLinkedList(10, 0, 10);
        System.out.println(head.printForward());
        int nth = 3;
        LinkedListNode n = kthToLast2(head, nth);
        if (n != null) {
                System.out.println(nth + "th to last node is " + n.data);
        } else {
                System.out.println("Null.  n is out of bounds.");
        }
	}
}
