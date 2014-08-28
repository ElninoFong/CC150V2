package chapter_17;

import java.util.HashMap;
import java.util.Random;

/*
 * 17.5
 * The Game of Master Mind
 * Write a method that, given a guess and a solution, returns the number of hits ansd pseudo-hits.
 */
public class Question17_5 {
	public static class Result {
        public int hits;
        public int pseudoHits;
        
        public Result(int h, int p) {
            hits = h;
            pseudoHits = p;
        }
        
        public String toString() {
            return "(" + hits + ", " + pseudoHits + ")";
        }
	};
	
	
	// another solution: first pass handle the hit cases, second pass handle pseudo hit cases
	// http://goo.gl/LKyCXs
	public static Result estimate(String guess, String solution) {
		Result res = new Result(0, 0);
		HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
		for (char c : solution.toCharArray()) {
			if (hm.containsKey(c)) {
				hm.put(c, hm.get(c) + 1);
			} else {
				hm.put(c, 1);
			}
		}
		
		for (int i = 0; i < guess.length(); i++) {
			char c = guess.charAt(i);
			if (c == solution.charAt(i)) {
				res.hits++;	// hits
				if (hm.get(c) == 0) {	// hit spot is used by pseudoHits
					res.pseudoHits--;
				} else {
					hm.put(c, hm.get(c) - 1);
				}
			} else {
				if (hm.containsKey(c) && hm.get(c) > 0) {
					res.pseudoHits++;	// pseduo-hits
					hm.put(c, hm.get(c) - 1);
				}
			}
		}
		
		return res;
	}
	
	
	
	
	/************************** TEST CODE **********************************/
    
    public static char letterFromCode(int k) {
            switch (k) {
            case 0:
                    return 'B';
            case 1:
                    return 'G';
            case 2:
                    return 'R';
            case 3:
                    return 'Y';
            default:
                    return '0';
            }               
    }
    
    public static Result estimateBad(String g, String s) {
            char[] guess = g.toCharArray();
            char[] solution = s.toCharArray();
            int hits = 0;
            for (int i = 0; i < guess.length; i++) {
                    if (guess[i] == solution[i]) {
                            hits++;
                            solution[i] = '0';
                            guess[i] = '0';
                    }
            }
            
            int pseudohits = 0;
            
            for (int i = 0; i < guess.length; i++) {
                    if (guess[i] != '0') {
                            for (int j = 0; j < solution.length; j++) {
                                    if (solution[j] != '0') {
                                            if (solution[j] == guess[i]) {
                                                    pseudohits++;
                                                    solution[j] = '0';
                                                    break;
                                            }
                                    }
                            }
                    }
            }
            
            return new Result(hits, pseudohits);
    }
    
    public static String randomString() {
            int length = 4;
            char[] str = new char[length];
            Random generator = new Random();
            
            for (int i = 0; i < length; i++) {
                    int v = generator.nextInt(4);
                    char c = letterFromCode(v);
                    str[i] = c;
            }
            
            return String.valueOf(str);
    }
    
    public static boolean test(String guess, String solution) {
            Result res1 = estimate(guess, solution);
            Result res2 = estimateBad(guess, solution);
            if (res1.hits == res2.hits && res1.pseudoHits == res2.pseudoHits) {
                    return true;
            } else {
                    System.out.println("FAIL: (" + guess + ", " + solution + "): " + res1.toString() + " | " + res2.toString());
                    return false;
            }
    }
    
    public static boolean testRandom() {
            String guess = randomString();
            String solution = randomString();
            return test(guess, solution);
    }
    
    public static boolean test(int count) {
            for (int i = 0; i < count; i++) {
                    if (!testRandom()) {
                            return true;
                    }
            }
            return false;
    }
    
    /********************** END TEST CODE ************************/
    
    
    public static void main(String[] args) {
        test(1000);
        System.out.println("Passed");
    }
}
