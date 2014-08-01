package chapter_2;

import CtCILibrary.AssortedMethods;
import CtCILibrary.LinkedListNode;
import java.util.*;

/*
 * 2.1 
 * Write code to remove duplicates from an unsorted linked list.
 * FOLLOW UP
 * How would you solve this problem if a temporary buffer is not allowed?
 */
public class Question2_1 {
	// All duplicates are removed except the first occurrence
	// TC:O(n), SC:O(n)
	public static LinkedListNode removeDuplicates1(LinkedListNode head) {
		HashSet<Integer> hs = new HashSet<Integer>();
		LinkedListNode prev = head;
		LinkedListNode curr = head;
		while (curr != null) {
			if (hs.contains(curr.data)) {
				prev.next = curr.next;
			} else {
				hs.add(curr.data);
				prev = curr;
			}
			curr = curr.next;
		}
		return head;
	}
	
	// All duplicates are removed except the first occurrence
	// TC:O(n^2), SC:O(1)
	public static LinkedListNode removeDuplicates2(LinkedListNode head) {
		LinkedListNode curr = head;
		while (curr != null) {
			LinkedListNode runner = curr;
			while (runner.next != null) {
				if (runner.next.data == curr.data) {
					runner.next = runner.next.next;
				}
				runner = runner.next;
			}
			curr = curr.next;
		}
		return head;
	}
	
	// All duplicates are removed including the first occurrence
	// TC:O(n), SC:O(n)
	public static LinkedListNode removeDuplicates3(LinkedListNode head) {
		LinkedListNode dummy = new LinkedListNode(0, head, null);
		HashMap<Integer, Boolean> hm = new HashMap<Integer, Boolean>();
		while (head != null) {
			if (hm.containsKey(head.data)) {
				hm.put(head.data, true);
			} else {
				hm.put(head.data, false);
			}
			head = head.next;
		}
		head = dummy.next;
		LinkedListNode node = dummy;
		while (head != null) {
			if (!hm.get(head.data)) {	// err1: use hashset leading to all elements being removed
				node.next = head;
				node = node.next;
			}
			head = head.next;
		}
		node.next = null;
		return dummy.next;
	}
	
	public static void main(String[] args) {
        LinkedListNode head = AssortedMethods.randomLinkedList(10, 0, 20);
        if (head == null) {
        	System.out.println("null");
        } else {
        	System.out.println(head.printForward());
        }
        LinkedListNode node = removeDuplicates3(head);
        if (node == null) {
        	System.out.println("null");
        } else {
        	System.out.println(node.printForward());
        }
	}
}
