package chapter_2;

import CtCILibrary.LinkedListNode;

/*
 * 2.4 
 * Write code to partition a linked list around a value x, such that all nodes less than x come before all nodes greater than or equal to x.
 */
public class Question2_4 {
	// TC:O(n), SC:O(1)
	// we can insert from the end(stable order), or insert from the beginning
	public static LinkedListNode partition(LinkedListNode head, int x) {
		if (head == null) return null;
		LinkedListNode smallHead = new LinkedListNode(0, null, null);
		LinkedListNode smallTail = smallHead;
		LinkedListNode largeHead = new LinkedListNode(0, null, null);
		LinkedListNode largeTail = largeHead;
		
		while (head != null) {
			if (head.data < x) {
				smallTail.next = head;
				smallTail = head;
			} else {
				largeTail.next = head;
				largeTail = head;
			}
			head = head.next;
		}
		
		if (smallHead == smallTail) return largeHead.next;	// no node less than x
		smallTail.next = largeHead.next;
		largeTail.next = null;
		return smallHead.next;
	}
	
	public static void main(String[] args) {
        /* Create linked list */
        int[] vals = {1, 3, 7, 5, 2, 9, 4};
        LinkedListNode head = new LinkedListNode(vals[0], null, null);
        LinkedListNode current = head;
        for (int i = 1; i < vals.length; i++) {
                current = new LinkedListNode(vals[i], null, current);
        }
        System.out.println(head.printForward());
        
        /* Partition */
        LinkedListNode h = partition(head, 5);
        
        /* Print Result */
        System.out.println(h.printForward());
	}
}
