package chapter_3;

/*
 * 3.1 
 * Describe how you could use a single array to implement three stacks.
 */
public class Question3_1 {
	// fixed size
	int stackSize = 100;
	int[] buffer = new int[stackSize * 3];
	int[] stackPointer = {-1, -1, -1};
	
	int absTopOfStack(int stackNum) {
		return stackNum * stackSize + stackPointer[stackNum];
	}
	
	void push(int stackNum, int value) throws Exception {
		// check if enough space
		if (absTopOfStack(stackNum) == stackSize - 1) {
			throw new Exception("Out of space.");
		}
		
		// increase the pointer and store the value
		stackPointer[stackNum]++;
		buffer[absTopOfStack(stackNum)] = value;
	}
	
	int pop(int stackNum) throws Exception {
		// check if empty stack
		if (stackPointer[stackNum] == -1) {
			throw new Exception("Empty stack.");
		}
		
		// pop the value
		int value = buffer[absTopOfStack(stackNum)];
		stackPointer[stackNum]--;
		
		return value;
	}
	
	int peek(int stackNum) {
		return buffer[absTopOfStack(stackNum)];
	}
	
	boolean isEmpty(int stackNum) {
		return stackPointer[stackNum] == -1;
	}
	
	
	public static void main(String [] args) throws Exception  {
		Question3_1 st = new Question3_1();
        st.push(2, 4);
        System.out.println("Peek 2: " + st.peek(2));
        st.push(0, 3);
        st.push(0, 7);
        st.push(0, 5);
        System.out.println("Peek 0: " + st.peek(0));
        st.pop(0);
        System.out.println("Peek 0: " + st.peek(0));
        st.pop(0);
        System.out.println("Peek 0: " + st.peek(0));
	}
}
