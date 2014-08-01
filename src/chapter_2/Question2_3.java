package chapter_2;

import CtCILibrary.AssortedMethods;
import CtCILibrary.LinkedListNode;

/*
 * 2.3 
 * Implement an algorithm to delete a node in the middle of a singly linked list, given only access to that node.
 * EXAMPLE
 * Input: the node c from the linked list a->b->c->d>e
 * Result: nothing is returned, but the new linked list looks like a->b->d->e
 */
public class Question2_3 {
	// TC:O(1), SC:O(1)
	public static boolean deleteNode(LinkedListNode n) {
		if (n == null || n.next == null) return false;		// n cannot be the last element
		n.data = n.next.data;
		n.next = n.next.next;
		return true;
	}
	
	public static void main(String[] args) {
        LinkedListNode head = AssortedMethods.randomLinkedList(10, 0, 10);
        System.out.println(head.printForward());
        deleteNode(head.next.next.next.next); // delete node 4
        System.out.println(head.printForward());
	}
}
