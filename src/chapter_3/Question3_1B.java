package chapter_3;

import CtCILibrary.AssortedMethods;

public class Question3_1B {
	// dynamic size
	static int totalStackNum = 3;
	static int defaultCapacity = 4;
	static int totalSize = defaultCapacity * totalStackNum;
	static int[] buffer = new int[totalSize];		// make all these static in order to test in main function
	Question3_1StackData[] stacks = {new Question3_1StackData(0, defaultCapacity),
									 new Question3_1StackData(defaultCapacity, defaultCapacity),
									 new Question3_1StackData(defaultCapacity * 2, defaultCapacity)};
	
	int getCurrSize() {
		return stacks[0].size + stacks[1].size + stacks[2].size;
	}
	
	void shift(int stackNum) {
		// if current stack is full
		if (stacks[stackNum].size == stacks[stackNum].capacity) {
			int nextStack = (stackNum + 1) % totalStackNum;
			shift(nextStack);
			stacks[stackNum].capacity++;
		}
		
		// shift from the end
		for (int i = (stacks[stackNum].start + stacks[stackNum].size) % totalSize;
				stacks[stackNum].isInStack(i, totalSize);
				i = prevPosition(i)) {
			buffer[i] = buffer[prevPosition(i)];
		}
		
		// adjust the variables
		buffer[stacks[stackNum].start] = 0;		// clear data
		stacks[stackNum].start = nextPosition(stacks[stackNum].start);
		stacks[stackNum].pointer = nextPosition(stacks[stackNum].pointer);
		stacks[stackNum].capacity--;
	}
	
	void expand(int stackNum) {
		int nextStack = (stackNum + 1) % totalStackNum;
		shift(nextStack);
		stacks[stackNum].capacity++;
	}
	
	int prevPosition(int curr) {
		if (curr > 0) return curr - 1;
		return totalSize - 1;
	}
	
	int nextPosition(int curr) {
		return (curr + 1) % totalSize;
	}
	
	public void push(int stackNum, int value) throws Exception {
		// all stacks are full
		if (getCurrSize() == totalSize) {
			throw new Exception("Out of space.");
		}
		
		// current stack is full
		if (stacks[stackNum].size == stacks[stackNum].capacity) {
			expand(stackNum);										// err: use shift here
		}
		
		// increase pointer and store value
		stacks[stackNum].pointer = nextPosition(stacks[stackNum].pointer);
		stacks[stackNum].size++;
		buffer[stacks[stackNum].pointer] = value;
	}
	
	public int pop(int stackNum) throws Exception {
		if (isEmpty(stackNum)) {
			throw new Exception("Empty stack.");
		}
		
		int value = buffer[stacks[stackNum].pointer];
		buffer[stacks[stackNum].pointer] = 0;	// clear data
		stacks[stackNum].size--;
		stacks[stackNum].pointer = prevPosition(stacks[stackNum].pointer);
		
		return value;
	}
	
	public int peek(int stackNum) {
		return  buffer[stacks[stackNum].pointer];
	}
	
	public boolean isEmpty(int stackNum) {
		return stacks[stackNum].size <= 0;
	}
	
	
	
	public static void main(String [] args) throws Exception  {
		Question3_1B st = new Question3_1B();
		
        st.push(0, 10);
        st.push(1, 20);
        st.push(2, 30);
        
        st.push(1, 21);
        st.push(0, 11);
        st.push(0, 12);
        
        st.pop(0);
        
        st.push(2, 31);
        
        st.push(0, 13);
        st.push(1, 22);
        
        st.push(2, 31);
        st.push(2, 32);
        st.push(2, 33);
        st.push(2, 34);

        System.out.println("Final Stack: " + AssortedMethods.arrayToString(buffer));
        
        st.pop(1);
        st.push(2, 35);
        
        System.out.println("Final Stack: " + AssortedMethods.arrayToString(buffer));
	}
}
