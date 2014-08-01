package chapter_2;

import CtCILibrary.LinkedListNode;

/*
 * 2.5 
 * You have two numbers represented by a linked list, where each node contains a single digit. 
 * The digits are stored in reverse order, such that the 1's digit is at the head of the list. 
 * Write a function that adds the two numbers and returns the sum as a linked list.
 * EXAMPLE
 * Input: (7 -> 1 -> 6) + (5 -> 9 -> 2). That is, 617 + 295.
 * Output: 2 -> 1 -> 9. That is, 912.
 * 
 * FOLLOW UP
 * Suppose the digits are stored in forward order. Repeat the above problem.
 * EXAMPLE
 * Input: (6 -> 1 -> 7) + (2  -> 9 -> 5). That is, 617 + 295.
 * Output: 9 -> 1 -> 2. That is, 912.
 */
public class Question2_5 {
	// TC:O(n), SC:O(n)
	public static LinkedListNode addReverseLists(LinkedListNode n1, LinkedListNode n2) {
		if (n1 == null) return n2;
		if (n2 == null) return n1;
		int carry = 0;
		LinkedListNode dummy = new LinkedListNode(0, null, null);
		LinkedListNode n = dummy;
		while (n1 != null || n2 != null || carry != 0) {
			int sum = carry;
			if (n1 != null) {
				sum += n1.data;
				n1 = n1.next;
			}
			if (n2 != null) {
				sum += n2.data;
				n2 = n2.next;
			}
			n.next = new LinkedListNode(sum % 10, null, null);
			carry = sum / 10;
			n = n.next;
		}
		return dummy.next;
	}
	
	// FOLLOW UP
	// TC:O(n), SC:O(n)
	static int carry;
	public static LinkedListNode addForwardLists(LinkedListNode n1, LinkedListNode n2) {
		if (n1 == null) return n2;
		if (n2 == null) return n1;
		int length1 = getLength(n1);
		int length2 = getLength(n2);
		if (length1 < length2) {
			n1 = addZeros(n1, length2 - length1);
		} else {
			n2 = addZeros(n2, length1 - length2);
		}
		LinkedListNode node = addForwardListsHelper(n1, n2);
		if (carry == 0) return node;
		LinkedListNode head = new LinkedListNode(carry, null, null);
		head.next = node;
		return head;
	}
	
	// recursvie
    public static LinkedListNode addForwardListsHelper(LinkedListNode n1, LinkedListNode n2) {
    	if (n1 == null) return null;
    	LinkedListNode next = addForwardListsHelper(n1.next, n2.next);
    	int sum = carry + n1.data + n2.data;
    	LinkedListNode curr = new LinkedListNode(sum % 10, null, null);
    	carry = sum / 10;
    	curr.next = next;
    	return curr;
    }
	
	public static int getLength(LinkedListNode n) {
		int length = 0;
		while (n != null) {
			length++;
			n = n.next;
		}
		return length;
	}
	
	public static LinkedListNode addZeros(LinkedListNode n, int diff) {
		while (diff-- > 0) {
			LinkedListNode add = new LinkedListNode(0, null, null);
			add.next = n;
			n = add;
		}
		return n;
	}
	
	
	// used in main
	public static int linkedListToIntReverse(LinkedListNode node) {
		int value = 0;
        if (node.next != null) {
        	value = 10 * linkedListToIntReverse(node.next);
        }
        return value + node.data;
	}       
	
	public static int linkedListToIntForward(LinkedListNode node) {
        int value = 0;
        while (node != null) {
                value = value * 10 + node.data;
                node = node.next;
        }
        return value;
	}	 
 
	public static void main(String[] args) {
		LinkedListNode lA1 = new LinkedListNode(4, null, null);
        LinkedListNode lA2 = new LinkedListNode(1, null, lA1);
//        LinkedListNode lA3 = new LinkedListNode(5, null, lA2);
        
        LinkedListNode lB1 = new LinkedListNode(5, null, null);
        LinkedListNode lB2 = new LinkedListNode(9, null, lB1);
        LinkedListNode lB3 = new LinkedListNode(6, null, lB2);  
         
        LinkedListNode list3 = addReverseLists(lA1, lB1);
         
        System.out.println("  " + lA1.printForward());          
        System.out.println("+ " + lB1.printForward());                  
        System.out.println("= " + list3.printForward());        
         
        int l1 = linkedListToIntReverse(lA1);
        int l2 = linkedListToIntReverse(lB1);
        int l3 = linkedListToIntReverse(list3);
         
        System.out.println(l1 + " + " + l2 + " = " + l3);
        System.out.println(l1 + " + " + l2 + " = " + (l1 + l2));
        
        System.out.println("================");
        
        LinkedListNode lC1 = new LinkedListNode(3, null, null);
        LinkedListNode lC2 = new LinkedListNode(1, null, lC1);
        LinkedListNode lC3 = new LinkedListNode(5, null, lC2);
        
        LinkedListNode lD1 = new LinkedListNode(6, null, null);
        LinkedListNode lD2 = new LinkedListNode(9, null, lD1);
        LinkedListNode lD3 = new LinkedListNode(1, null, lD2);  
        
        LinkedListNode list4 = addForwardLists(lC1, lD1);
        
        System.out.println("  " + lC1.printForward());          
        System.out.println("+ " + lD1.printForward());                  
        System.out.println("= " + list4.printForward());        
        
        int l11 = linkedListToIntForward(lC1);
        int l22 = linkedListToIntForward(lD1);
        int l4 = linkedListToIntForward(list4);
        
        System.out.print(l11 + " + " + l22 + " = " + l4 + "\n");
        System.out.print(l11 + " + " + l22 + " = " + (l11 + l22));  
	}
}
