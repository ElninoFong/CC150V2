package chapter_3;

import java.util.*;

/*
 * 3.3 
 * Imagine a (literal) stack of plates. If the stack gets too high, it might topple. 
 * Therefore, in real life, we would likely start a new stack when the previous stack exceeds some threshold. 
 * Implement a data structure SetOfStacks that mimics this. 
 * SetOfStacks should be composed of several stacks and should create a new stack once the previous one exceeds capacity. 
 * SetOfStacks.push() and SetOfStacks.pop() should behave identically to a single stack 
 * (that is, pop() should return the same values as it would if there were just a single stack).
 * FOLLOW UP
 * Implement a function popAt(int index) which performs a pop operation on a specific sub-stack.
 */
public class Question3_3 {
	ArrayList<Stack<Integer>> stacks;
	int capacity = 3;
	
	public Question3_3(int _capacity) {
		stacks = new ArrayList<Stack<Integer>>();
		capacity = _capacity;
	}
	
	Stack<Integer> getLastStack() {
		if (stacks.size() == 0) {
			stacks.add(new Stack<Integer>());
		}
		return stacks.get(stacks.size() - 1);
	}
	
	public void push(int value) {
		Stack<Integer> stack = getLastStack();
		// the stack is full
		if (stack.size() == capacity) {
			stack = new Stack<Integer>();
			stacks.add(stack);
		}
		stack.add(value);
	}
	
	public int pop() throws Exception {
		// empty check
		if (stacks.size() == 0) {
			throw new Exception("Empty stack.");
		}
		
		// pop value
		Stack<Integer> stack = getLastStack();
		int value = stack.pop();
		// remove if it is empty
		if (stack.isEmpty()) {
			stacks.remove(stack);
		}
		
		return value;
	}
	
	
    public static void main(String[] args) throws Exception {
        int capacity_per_substack = 5;
        Question3_3 set = new Question3_3(capacity_per_substack);
        for (int i = 0; i < 34; i++) {
            set.push(i);
        }
        for (int i = 0; i < 34; i++) {
            System.out.println("Popped " + set.pop());
        }               
    }
}
