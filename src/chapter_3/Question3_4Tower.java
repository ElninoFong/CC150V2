package chapter_3;

import java.util.Stack;

public class Question3_4Tower {
	private Stack<Integer> disks;
	private int index;
	
	public Question3_4Tower(int i) {
		disks = new Stack<Integer>();
		index = i;
	}
	
	// can not modify index
	public int getIndex() {
		return index;
	}
	
	public void add(int value) {
		// error check
		if (disks.isEmpty() || disks.peek() > value) {
			disks.push(value);
		} else {
			System.out.println("Can not put disk " + value + " on disk " + disks.peek());
		}
	}
	
	public void moveTopTo(Question3_4Tower t) {
		if (disks.isEmpty()) {
			System.out.println("Tower " + getIndex() + " is empty.");
			return;
		}
		t.disks.add(disks.pop());
		System.out.println("Move disk form Tower " + getIndex() + " to Tower " + t.getIndex());
	}
	
	public void print() {
        System.out.println("Contents of Tower " + getIndex() + ": " + disks.toString());
	}
	
	public void moveDisks(int size, Question3_4Tower destination, Question3_4Tower buffer) {
		if (size == 0) return;
		moveDisks(size - 1, buffer, destination);
		moveTopTo(destination);
		buffer.moveDisks(size - 1, destination, this);
	}
}
