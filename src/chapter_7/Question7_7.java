package chapter_7;

import java.util.LinkedList;

/*
 * 7.7
 * Design an algorithm to find the kth number such that the only prime factors are 3, 5, and 7.
 */
public class Question7_7 {
	public static int getKthMagicNumber(int k) {
		if (k <= 0) return 0;
		int val = 0;
		
		LinkedList<Integer> q3 = new LinkedList<Integer>();
		LinkedList<Integer> q5 = new LinkedList<Integer>();
		LinkedList<Integer> q7 = new LinkedList<Integer>();
		
		q3.add(1);
		while (k-- > 0) {
			int v3 = q3.isEmpty() ? Integer.MAX_VALUE : q3.peek();
			int v5 = q5.isEmpty() ? Integer.MAX_VALUE : q5.peek();
			int v7 = q7.isEmpty() ? Integer.MAX_VALUE : q7.peek();
			
			val = Math.min(v3, Math.min(v5, v7));
			if (val == v3) {
				q3.remove();
				q3.add(val * 3);
				q5.add(val * 5);
			} else if (val == v5) {
				q5.remove();
				q5.add(val * 5);
			} else {
				q7.remove();
			}
			q7.add(val * 7);
		}
		
		return val;
 	}
	
	public static void main(String[] args) {
        for (int i = 0; i < 14; i++) {
            System.out.println(i + " : " + getKthMagicNumber(i));
        }
	}
}
