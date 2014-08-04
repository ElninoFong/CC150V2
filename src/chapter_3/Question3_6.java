package chapter_3;

import java.util.Stack;

/*
 * 3.6 
 * Write a program to sort a stack in ascending order (with biggest items on top). 
 * You may use at most one additional stack to hold items, but you may not copy the elements into any other data structure (such as an array). 
 * The stack supports the following operations: push, pop, peek, and isEmpty.
 */
public class Question3_6 {
	
	public static Stack<Integer> sortStack(Stack<Integer> stack) {
		if (stack == null || stack.isEmpty()) return stack;
		Stack<Integer> buffer = new Stack<Integer>();
		int tmp;
		
		// loop until sorted
		while (!stack.isEmpty()) {
			if (buffer.isEmpty() || buffer.peek() <= stack.peek()) {
				buffer.push(stack.pop());
			} else {
				// use tmp to store the large value and put the sorted values back
				tmp = stack.pop();
				while (!buffer.isEmpty() && buffer.peek() > tmp) {	// err: buffer.peek() < tmp
					stack.push(buffer.pop());
				}
				buffer.push(tmp);
			}
		}
		
		/*
		// more concise
		while (!stack.isEmpty()) {
			tmp = stack.pop();
			while (!buffer.isEmpty() && buffer.peek() > tmp) {
				stack.push(buffer.pop());
			}
			buffer.push(tmp);
		}
		*/
		
		return buffer;
	}
	
	public static void main(String [] args) {
        Stack<Integer> s = new Stack<Integer>();
        s.push(3);
        s.push(2);
        s.push(24);
        s.push(34);
        s.push(19);
        s.push(3);
        s.push(4);
        s = sortStack(s);
        while(!s.isEmpty()) {
            System.out.println(s.pop());
        }
	}
}
