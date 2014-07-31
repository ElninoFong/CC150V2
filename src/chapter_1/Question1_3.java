package chapter_1;

/*
 * 1.3 
 * Given two strings, write a method to decide if one is a permutation of the other.
 */
public class Question1_3 {
	// TC:O(n), SC:O(1)
	// Array
	public static boolean isPermutation(String s1, String s2) {
		if (s1.length() != s2.length()) return false;
		int[] chars = new int[256];
		for (char c : s1.toCharArray()) {
			chars[c]++;
		}
		for (char c : s2.toCharArray()) {
			if (--chars[c] < 0) return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
        String[][] pairs = {{"apple", "papel"}, {"carrot", "tarroc"}, {"hello", "llloh"}};
        for (String[] pair : pairs) {
            String word1 = pair[0];
            String word2 = pair[1];
            boolean anagram = isPermutation(word1, word2);
            System.out.println(word1 + ", " + word2 + ": " + anagram);
        }
	}
}


// 1.是否分大小写，空格是否忽略； 
// 2.长度不等直接返回false