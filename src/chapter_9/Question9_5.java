package chapter_9;

import java.util.ArrayList;

/*
 * 9.5
 * Write a method to compute all permutations of a string.
 */
public class Question9_5 {
	// bottom up
	static ArrayList<String> res;
	public static ArrayList<String> getPerms1(String s) {
		res = new ArrayList<String>();
		if (s == null || s.isEmpty()) return res;
		getPerms1(s, 0);
		return res;
	}
	
	static void getPerms1(String s, int level) {
		if (level == s.length()) return;
		if (level == 0) {
			res.add(s.substring(0, 1));
		} else {
			ArrayList<String> newRes = new ArrayList<String>();
			String curr = s.substring(level, level + 1);
			for (String str : res) {
				for (int i = str.length(); i >= 0 ; i--) {
					newRes.add(str.substring(0, i) + curr + str.substring(i));
				}
			}
			res = newRes;
		}
		
		getPerms1(s, level + 1);
	}
	
	
	// top down
	public static ArrayList<String> getPerms2(String s) {
		ArrayList<String> res = new ArrayList<String>();
		if (s == null || s.isEmpty()) {
			res.add("");
			return res;
		}
		
		char first = s.charAt(0);
		String remainder = s.substring(1);
		ArrayList<String> words = getPerms2(remainder);
		for (String word : words) {
			for (int i = 0; i <= word.length(); i++) {
				String str = insertCharAt(word, first, i);
				res.add(str);
			}
		}
		
		return res;
	}
	
	static String insertCharAt(String word, char c, int i) {
		return word.substring(0, i) + c + word.substring(i);
	}
	
	/////////////
	public static void main(String[] args) {
        ArrayList<String> list = getPerms2("abcd");
        System.out.println("There are " + list.size() + " permutations.");
        for (String s : list) {
            System.out.println(s);
        }
	}
}
