package chapter_2;

import CtCILibrary.LinkedListNode;

/*
 * 2.6 
 * Given a circular linked list, implement an algorithm which returns the node at he beginning of the loop.
 * EXAMPLE
 * Input: A -> B -> C -> D -> E -> C
 * Output: C
 */
public class Question2_6 {
	// TC:O(n), SC:O(1)
	// two pointers: slowRunner one step each time, fastRunner two steps each time
	// when slowRunner move k steps to the loop entrance, the fastRunner has run k steps in the loop.
	// so fastRunner is mod(k - LOOP_SIZE) = K steps ahead of slowRunner, it will catch up slowRunner in LOOP_SIZE - K steps.
	// make they both run one step each time. and make slowRunner to the head, they will meet again in the loop entrance.
	public static LinkedListNode FindBeginning(LinkedListNode head) {
		LinkedListNode slow = head;
		LinkedListNode fast = head;
		
		while (fast != null && fast.next != null) {		// err1: use || here
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) break;
		}
		
		if (fast == null || fast.next == null) return null;		// err2: didn't check if no loop
		
		fast = head;
		while (slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}
		
		return fast;
	}
	
	public static void main(String[] args) {
        int list_length = 100;
        int k = 10;
        
        // Create linked list
        LinkedListNode[] nodes = new LinkedListNode[list_length];
        for (int i = 0; i < list_length; i++) {
                nodes[i] = new LinkedListNode(i, null, i > 0 ? nodes[i - 1] : null);
        }
        
        // Create loop;
        nodes[list_length - 1].next = nodes[list_length - k];
        
        LinkedListNode loop = FindBeginning(nodes[0]);
        if (loop == null) {
                System.out.println("No Cycle.");
        } else {
                System.out.println(loop.data);
        }
	}
}
