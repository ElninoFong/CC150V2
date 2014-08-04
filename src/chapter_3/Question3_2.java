package chapter_3;

import java.util.Stack;

import CtCILibrary.AssortedMethods;

/*
 * 3.2 
 * How would you design a stack which, in addition to push and pop, also has a function min which returns the minimum element? 
 * Push, pop and min should all operate in O(1) time.
 */
public class Question3_2 {
	// Better design: http://goo.gl/WdrA9s
	
	// use two stacks
	Stack<Integer> stack;
	Stack<Integer> minStack;
	
	public Question3_2() {
		stack = new Stack<Integer>();
		minStack = new Stack<Integer>();
	}
	
	public void push(int value) {
		stack.push(value);
		if (minStack.isEmpty() || minStack.peek() > value) {
			minStack.push(value);
		} else {
			minStack.push(minStack.peek());
		}
	}
	
	public int pop() {
		minStack.pop();
		return stack.pop();
	}
	
	public int min() {
		if (minStack.isEmpty()) return -1;
		return minStack.peek();
	}
	
	
	public static void main(String[] args) {
		Question3_2 stack = new Question3_2();
        for (int i = 0; i < 15; i++) {
                int value = AssortedMethods.randomIntInRange(0, 20);
                stack.push(value);
                System.out.print(value + ", ");
        }
        System.out.println('\n');
        for (int i = 0; i < 15; i++) {
                System.out.println("Popped " + stack.pop());
                System.out.println("New min is " + stack.min());
        }
}
}
