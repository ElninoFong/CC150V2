package chapter_17;

import java.util.HashMap;

import CtCILibrary.AssortedMethods;

/*
 * 17.9
 * Design a method to find the frequency of occurrences of any given word in a book.
 */
public class Question17_9 {
	public static HashMap<String, Integer> setupDictionary(String[] book) {
		HashMap<String, Integer> res = new HashMap<String, Integer>();
		for (String word : book) {
			if (word.trim().isEmpty()) continue;
			word = word.toLowerCase();
			if (res.containsKey(word)) {
				res.put(word, res.get(word) + 1);
			} else {
				res.put(word, 1);
			}
		}
		return res;
	}
	
	public static int getFrequency(String word, HashMap<String, Integer> res) {
		if (res == null || word == null || word.isEmpty()) return 0;
		word = word.toLowerCase();
		if (!res.containsKey(word)) return 0;
		return res.get(word);
	}
	
	////////////
	public static void main(String[] args) {
        String[] wordlist = AssortedMethods.getLongTextBlobAsStringList();
        HashMap<String, Integer> dictionary = setupDictionary(wordlist);
        
        String[] words = {"the", "Lara", "and", "outcropping", "career", "it"};
        for (String word : words) {
            System.out.println(word + ": " + getFrequency(word, dictionary));
        }
	}
}
