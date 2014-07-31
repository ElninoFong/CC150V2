package chapter_1;

/*
 * 1.5 
 * Implement a method to perform basic string compression using the count of repeated characters. 
 * For example, the string aabcccccaaa would become a2b1c5a3. 
 * If the "compressed" string would not become smaller than the original string, your method should return the original string.
 */
public class Question1_5 {
	// TC:O(n), SC:O(n)
	public static String compress(String s) {
		if (s == null || s.isEmpty() || s.length() == 1) return s;
		StringBuffer sb = new StringBuffer();
		int count = 1;
		char prevChar = s.charAt(0);
		for (int i = 1; i < s.length(); i++) {
			if (prevChar == s.charAt(i)) {
				count++;
			} else {
				sb.append(prevChar);
				sb.append(count);
				prevChar = s.charAt(i);
				count = 1;
			}
		}
		// add the last one
		sb.append(prevChar);
		sb.append(count);
		
		return sb.length() < s.length() ? sb.toString() : s;
	}
	
	public static void main(String[] args) {
        String str = "abbccccccde";
        String str2 = compress(str);
        System.out.println("Old String (len = " + str.length() + "): " + str);
        System.out.println("New String (len = " + str2.length() + "): " + str2);
	}
}
