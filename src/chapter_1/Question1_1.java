package chapter_1;

import java.util.HashSet;

/*
 * 1.1 
 * Implement an algorithm to determine if a string has all unique characters. 
 * What if you cannot use additional data structures?
 */
public class Question1_1 {
	// TC:O(n), SC:O(n)
	// HashSet
	public static boolean isUniqueChars(String s) {
		if (s == null || s.isEmpty()) return true;
		if (s.length() > 256) return false;		// err1: miss this
		HashSet<Character> hs = new HashSet<Character>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (hs.contains(c)) return false;
			hs.add(c);
		}
		return true;
	}
	
	// TC:O(n), SC:O(1)
	// Array
	public static boolean isUniqueChars2(String s) {
		if (s == null || s.isEmpty()) return true;
		if (s.length() > 256) return false;		// err1: miss this
		boolean[] arr = new boolean[256];
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (arr[c]) return false;
			arr[c] = true;
		}
		return true;
	}
	
	// TC:O(n), SC:O(1)
	// Bitmap
	public static boolean isUniqueChars3(String s) {
		if (s == null || s.isEmpty()) return true;
		if (s.length() > 256) return false;		// err1: miss this
		int checker = 0;
		for (int i = 0; i < s.length(); i++) {
			int k = (int) s.charAt(i);	// int and char are convertible
			if ((checker & (1 << k)) > 0) return false;		// err2: didn't use parentheses
			checker |= (1 << k);
		}
		return true;
	}
	
	public static void main(String[] args) {
        String[] words = {"abcde", "hello", "apple", "kite", "padle"};
        for (String word : words) {
            System.out.println(word + ": " + isUniqueChars(word) + " " + isUniqueChars2(word) + " " + isUniqueChars3(word));
        }
	}
}
