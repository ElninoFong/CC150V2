package chapter_1;

/*
 * 1.8 
 * Assume you have a method isSubstring which checks if one word is a substring of another. 
 * Given two strings, s1 and s2, write code to check if s2 is a rotation of s1 using only one call to isSubstring 
 * (e.g.,"waterbottle" is a rotation of "erbottlewat").
 */
public class Question1_8 {
	// TC:O(1), SC:O(n)
	public static boolean isRotation(String s1, String s2) {
		if (s1.length() != s2.length()) return false;		// err1: miss length check
		return isSubstring(s1 + s1, s2);
	}
	
	public static boolean isSubstring(String big, String small) {
        if (big.indexOf(small) >= 0) {
            return true;
        } else {
            return false;
        }
	}
	
	public static void main(String[] args) {
        String[][] pairs = {{"apple", ""}, {"apple", "pleap"}, {"waterbottle", "erbottlewat"}, {"camera", "macera"}};
        for (String[] pair : pairs) {
            String word1 = pair[0];
            String word2 = pair[1];
            boolean is_rotation = isRotation(word1, word2);
            System.out.println(word1 + ", " + word2 + ": " + is_rotation);
        }
	}
}
