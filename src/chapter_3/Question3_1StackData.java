package chapter_3;

public class Question3_1StackData {
	public int start;
	public int pointer;
	public int capacity;
	public int size = 0;	// current size
	
	public Question3_1StackData(int _start, int _capacity) {
		start = _start;
		pointer = _start - 1;	// indicate empty if pointer < start
		capacity = _capacity;
	}
	
	public boolean isInStack(int i, int totalSize) {
		// non-wrapping
		if (start <= i && i < start + capacity) return true;
		// wrapping
		if (start + capacity > totalSize && i < ((start + capacity) % totalSize)) return true;	// err: miss start + capacity > totalSize 
		// otherwise
		return false;
	}
}
