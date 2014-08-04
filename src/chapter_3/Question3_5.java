package chapter_3;

import java.util.*;

import CtCILibrary.AssortedMethods;

/*
 * 3.5 
 * Implement a MyQueue class which implements a queue using two stacks.
 */
public class Question3_5 {
	Stack<Integer> addStack, removeStack;
	
	public Question3_5() {
		addStack = new Stack<Integer>();
		removeStack = new Stack<Integer>();
	}
	
	public void add(int value) {
		addStack.push(value);
	}
	
	public int remove() {
		if (size() == 0) {
			System.out.println("Try to remove from the empty queue.");
			return -1;	// or throw exception
		}
		
		// push all elements from addStack to removeStack
		if (removeStack.isEmpty()) {
			shift();
		}
		
		return removeStack.pop();
	}
	
	void shift() {
		while (!addStack.isEmpty()) {
			removeStack.push(addStack.pop());
		}
	}
	
	public int peek() {
		if (size() == 0) {
			System.out.println("Try to peek the empty queue.");
			return -1;	// or throw exception
		}
		
		// push all elements from addStack to removeStack
		if (removeStack.isEmpty()) {
			shift();
		}
		
		return removeStack.peek();
	}
	
	public int size() {
		return addStack.size() + removeStack.size();
	}
	
	
	public static void main(String[] args) {
		Question3_5 my_queue = new Question3_5();
        
        // Let's test our code against a "real" queue
        Queue<Integer> test_queue = new LinkedList<Integer>();
        
        for (int i = 0; i < 100; i++) {
            int choice = AssortedMethods.randomIntInRange(0, 10);
            if (choice <= 5) { // enqueue
                int element = AssortedMethods.randomIntInRange(1, 10);
                test_queue.add(element);
                my_queue.add(element);
                System.out.println("Enqueued " + element);
            } else if (test_queue.size() > 0) {
                int top1 = test_queue.remove();
                int top2 = my_queue.remove();
                if (top1 != top2) { // Check for error
                    System.out.println("******* FAILURE - DIFFERENT TOPS: " + top1 + ", " + top2);
                } 
                System.out.println("Dequeued " + top1);
            }
            
            if (test_queue.size() == my_queue.size()) {
                if (test_queue.size() > 0 && test_queue.peek() != my_queue.peek()) {
                    System.out.println("******* FAILURE - DIFFERENT TOPS: " + test_queue.peek() + ", " + my_queue.peek() + " ******");
                }
            } else {
            	System.out.println("******* FAILURE - DIFFERENT SIZES ******");
            }
        }
	}

}
