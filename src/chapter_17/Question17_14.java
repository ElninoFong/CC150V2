package chapter_17;

import java.util.HashMap;
import CtCILibrary.AssortedMethods;
import CtCILibrary.Trie;

/*
 * 17.14
 * Given a dictionary, design an algorithm to find the optimal way of "unconcatenating" a sequence of words.
 */
public class Question17_14 {
	public static String sentence;
    public static Trie dictionary;
    
    // My solution is better than answer
    public static int parse(int wordStart, HashMap<Integer, Integer> cache) {
    	if (wordStart >= sentence.length()) return 0;
    	if (cache.containsKey(wordStart)) return cache.get(wordStart);
    	
    	int res = Integer.MAX_VALUE;
    	for (int i = wordStart + 1; i <= sentence.length(); i++) {
    		String word = sentence.substring(wordStart, i);
    		int extend = parse(i, cache);
    		if (!dictionary.contains(word, true)) {
    			extend += word.length();
    		}
    		res = Math.min(res, extend);
    		
    		// prefix not in dict, pruning
    		if (!dictionary.contains(word, false)) break;
    	}
    	
    	cache.put(wordStart, res);
    	return res;
    }
    
    
    ////////////////////
    public static int parseOptimized2(int wordStart, int wordEnd, HashMap<Integer, Integer> cache) {
    	if (wordEnd >= sentence.length()) {
            return wordEnd - wordStart;
	    }
	    if (cache.containsKey(wordStart)) {
	            return cache.get(wordStart);
	    }               
	    
	    String currentWord = sentence.substring(wordStart, wordEnd + 1);
	    boolean validPartial = dictionary.contains(currentWord, false);
	    
	    /* break current word */
	    int bestExact = parseOptimized2(wordEnd + 1, wordEnd + 1, cache);
	    if (!validPartial || !dictionary.contains(currentWord, true)) {
	            bestExact += currentWord.length();
	    }
	    
	    /* extend current word */
	    int bestExtend = Integer.MAX_VALUE;
	    if (validPartial) {
	            bestExtend = parseOptimized2(wordStart, wordEnd + 1, cache);
	    }
	    
	    /* find best */
	    int min = Math.min(bestExact, bestExtend);
	    cache.put(wordStart, min);
	    return min;
    }
    
    public static String clean(String str) {
        char[] punctuation = {',', '"', '!', '.', '\'', '?', ','};
        for (char c : punctuation) {
            str = str.replace(c, ' ');
        }
        return str.replace(" ", "").toLowerCase();
	}
	
	public static void main(String[] args) {
        dictionary = AssortedMethods.getTrieDictionary();
        sentence = "As one of the top companies in the world, Google will surely attract the attention of computer gurus. " +
        			"This does not, however, mean the company is for everyone.";
        sentence = clean(sentence);
        System.out.println(sentence);
        
        long startTime = System.currentTimeMillis();
        int v = parseOptimized2(0, 0, new HashMap<Integer, Integer>());
        System.out.println(v + "--------" + (System.currentTimeMillis() - startTime));
        
        startTime = System.currentTimeMillis();
        int k = parse(0, new HashMap<Integer, Integer>());
        System.out.println(k + "--------" + (System.currentTimeMillis() - startTime));
	}
}
