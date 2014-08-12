package chapter_9;

import java.util.HashMap;

/*
 * 9.11
 * Given a boolean expression consisting of the symbols 0, 1, &, |, and ^, and a desired boolean result value result,
 * implement a function to count the number of ways of parenthesizing the expression such that it evaluates to result.
 * EXAMPLE
 * Expression: 1^0|0|1
 * Desired result: false (0)
 * Output: 2 ways. 1^((0|0)|1) and 1^(0|(0|1)).
 */
public class Question9_11 {
	public static int countWays(String exp, boolean res, int l, int r, HashMap<String, Integer> hm) {
		String key = "" + res + l + r;		// need res to distinguish true or false even the same string between l and r
		if (hm.containsKey(key)) return hm.get(key);
		
		if (l == r) {
			if (exp.charAt(l) == '1' && res) return 1;
			if (exp.charAt(l) == '0' && !res) return 1;
			return 0;
		}
		
		int ways = 0;
		if (res) {
			for (int i = l + 1; i <= r; i += 2) {
				char c = exp.charAt(i);
				if (c == '&') {
					ways += countWays(exp, true, l, i - 1, hm) * countWays(exp, true, i + 1, r, hm);
				} else if (c == '|') {
					ways += countWays(exp, true, l, i - 1, hm) * countWays(exp, true, i + 1, r, hm);
					ways += countWays(exp, true, l, i - 1, hm) * countWays(exp, false, i + 1, r, hm);
					ways += countWays(exp, false, l, i - 1, hm) * countWays(exp, true, i + 1, r, hm);
				} else if (c == '^') {
					ways += countWays(exp, true, l, i - 1, hm) * countWays(exp, false, i + 1, r, hm);
					ways += countWays(exp, false, l, i - 1, hm) * countWays(exp, true, i + 1, r, hm);
				}
			}
		} else {
			for (int i = l + 1; i <= r; i += 2) {
				char c = exp.charAt(i);
				if (c == '&') {
					ways += countWays(exp, true, l, i - 1, hm) * countWays(exp, false, i + 1, r, hm);
					ways += countWays(exp, false, l, i - 1, hm) * countWays(exp, true, i + 1, r, hm);
					ways += countWays(exp, false, l, i - 1, hm) * countWays(exp, false, i + 1, r, hm);
				} else if (c == '|') {
					ways += countWays(exp, false, l, i - 1, hm) * countWays(exp, false, i + 1, r, hm);
				} else if (c == '^') {
					ways += countWays(exp, true, l, i - 1, hm) * countWays(exp, true, i + 1, r, hm);
					ways += countWays(exp, false, l, i - 1, hm) * countWays(exp, false, i + 1, r, hm);
				}
			}
		}
		
		hm.put(key, ways);
		
		return ways;
	}
	
	//////////////
	public static int total(int n) {
        // Function to return (2n) ! / ((n+1)! * n!)
        
        // To keep the numbers small, we divide by i when possible to do evenly. If not,
        // we store up the remainder and divide when possible.
        long num = 1;
        long rem = 1;
        for (int i = 2; i <= n; i++) {
                num *= (n + i);
                rem *= i;
                if (num % rem == 0) { 
                        num /= rem;
                        rem = 1;
                }
        }               
        return (int)num;
	}
	
	public static int countDPEff(String exp, boolean result, int start, int end, HashMap<String, Integer> cache) {
        String key = "" + start + end;
        int count = 0;
        if (!cache.containsKey(key)) {
            if (start == end) {
                if (exp.charAt(start) == '1') {
                    count = 1;
                } else {
                    count = 0;
                }
            }       
            
        for (int i = start + 1; i <= end; i += 2) {
            char op = exp.charAt(i);
            if (op == '&') {
                count += countDPEff(exp, true, start, i - 1, cache) * countDPEff(exp, true, i + 1, end, cache); 
            } else if (op == '|') {
                int left_ops = (i - 1 - start) / 2; // parens on left
                int right_ops = (end - i - 1) / 2;  // parens on right
                int total_ways = total(left_ops) * total(right_ops);
                int total_false = countDPEff(exp, false, start, i - 1, cache) * countDPEff(exp, false, i + 1, end, cache);
                count += total_ways - total_false;
            } else if (op == '^') {
                count += countDPEff(exp, true, start, i - 1, cache) * countDPEff(exp, false, i + 1, end, cache);
                count += countDPEff(exp, false, start, i - 1, cache) * countDPEff(exp, true, i + 1, end, cache);
            }
        }
        cache.put(key, count);
        } else {
            count = cache.get(key);
        }
        if (result) {
            return count;
        } else {
            int num_ops = (end - start) / 2;
            return total(num_ops) - count;
        }
	}   
	
	
	public static void main(String[] args) {
        String terms = "0^0|1&1^1|0|1";
//        String terms = "0^0|1&1";
        boolean result = true;
        
//        bruteForce(terms, new HashMap<String, Boolean>(), result, new boolean[(terms.length() - 1) / 2]);
//        System.out.println(countR(terms, result, 0, terms.length() - 1));
        System.out.println(countWays(terms, result, 0, terms.length() - 1, new HashMap<String, Integer>()));
        System.out.println(countDPEff(terms, result, 0, terms.length() - 1, new HashMap<String, Integer>()));
        
	}
}
