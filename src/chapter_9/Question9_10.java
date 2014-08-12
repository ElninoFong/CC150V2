package chapter_9;

import java.util.*;

/*
 * 9.10
 * You have a stack of n boxes, with widths w(i), heights h(i), and depths d(i).
 * The boxes cannot be rotated and can only be stacked on top of one another if each box in the stack is strictly larger
 * than the box above it in width, height, and depth. Implement a method to build the tallest stack possible,
 * where the height of a stack is the sum of the heigths of each box. 
 */
public class Question9_10 {
	// Recursive
	public static ArrayList<Question9_10Box> createStackRecursive(Question9_10Box[] boxes, Question9_10Box bottom) {
		ArrayList<Question9_10Box> res = null;
		int tallest = 0;
		for (int i = 0; i < boxes.length; i++) {
			if (boxes[i].canBeAbove(bottom)) {
				ArrayList<Question9_10Box> above = createStackRecursive(boxes, boxes[i]);
				int height = getStackHeight(above);
				if (height > tallest) {
					tallest = height;
					res = above;
				}
			}
		}
		
		// base case
		if (res == null) {
			res = new ArrayList<Question9_10Box>();
		}
		
		if (bottom != null) {
			res.add(0, bottom);
		}
		
		return res;
	}
	
	static int getStackHeight(ArrayList<Question9_10Box> arr) {
		if (arr == null) return 0;
		int height = 0;
		for (Question9_10Box b : arr) {
			height += b.height;
		}
		return height;
	}
	
	
	// DP
	public static ArrayList<Question9_10Box> createStackDP(Question9_10Box[] boxes, Question9_10Box bottom,
			HashMap<Question9_10Box, ArrayList<Question9_10Box>> hm) {
		if (bottom != null && hm.containsKey(bottom)) return hm.get(bottom);	// check if cached
		
		ArrayList<Question9_10Box> res = null;
		int tallest = 0;
		for (int i = 0; i < boxes.length; i++) {
			if (boxes[i].canBeAbove(bottom)) {
				ArrayList<Question9_10Box> above = createStackDP(boxes, boxes[i], hm);
				int height = getStackHeight(above);
				if (height > tallest) {
					tallest = height;
					res = above;
				}
			}
		}
		
		// base case
		if (res == null) {
			res = new ArrayList<Question9_10Box>();
		}
		
		if (bottom != null) {
			res.add(0, bottom);
		}
		
		hm.put(bottom, res);		// cache
		
		return new ArrayList<Question9_10Box>(res);		// need a copy
		
	}
	
	////////////
	public static void main(String[] args) {
		Question9_10Box[] boxes = { new Question9_10Box(1, 7, 4), new Question9_10Box(2, 6, 9), new Question9_10Box(4, 9, 6),
									new Question9_10Box(10, 12, 8), new Question9_10Box(6, 2, 5), new Question9_10Box(3, 8, 5), 
									new Question9_10Box(5, 7, 7), new Question9_10Box(2, 10, 16), new Question9_10Box(12, 15, 9)};

        ArrayList<Question9_10Box> stack = createStackDP(boxes, null, new HashMap<Question9_10Box, ArrayList<Question9_10Box>>());
//        ArrayList<Question9_10Box> stack = createStackRecursive(boxes, null);               
        for (int i = stack.size() - 1; i >= 0; i--) {
    		Question9_10Box b = stack.get(i);
            System.out.println(b.toString());
        }
	}
}
