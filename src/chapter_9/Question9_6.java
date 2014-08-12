package chapter_9;

import java.util.ArrayList;

/*
 * 9.6
 * Implement an algorithm to print all valid (e.g., properly opened and closed) combinations of n-pairs of parentheses.
 * EXAMPLE
 * Input: 3
 * Output: ((())), (()()), (())(), ()(()), ()()()
 */
public class Question9_6 {
	// counting
	public static ArrayList<String> generateParens1(int n) {
		ArrayList<String> res = new ArrayList<String>();
		StringBuilder sb = new StringBuilder();
		generateParens1(n, 0, 0, res, sb);
		return res;
	}
	
	static void generateParens1(int n, int l, int r, ArrayList<String> res, StringBuilder sb) {
		if (n == r) {
			res.add(sb.toString());
			return;
		}
		
		// insert '('
		if (n > l) {
			sb.append("(");
			generateParens1(n, l + 1, r, res, sb);
			sb.deleteCharAt(sb.length() - 1);
		}
		
		// insert ')'
		if (l > r) {
			sb.append(")");
			generateParens1(n, l, r + 1, res, sb);
			sb.deleteCharAt(sb.length() - 1);		// err: miss this
		}
	}
	
	// recursive
	// need to use hashset to avoid duplicates
	
	///////////////
	public static void main(String[] args) {
        ArrayList<String> list = generateParens1(3);
        for (String s : list) {
            System.out.println(s);
        }
        System.out.println(list.size());
	}
}
