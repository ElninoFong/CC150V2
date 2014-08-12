package chapter_9;

/*
 * 9.8
 * Given an infinte number of quarters (25 cents), dimes (10 cents), nickels (5 cents) and pennies (1 cent),
 * write code to calculate the number of ways of representing n cents.
 */
public class Question9_8 {
	public static int makeChange(int n) {
		if (n <= 0) return 0;
		return makeChange(n, 25);
	}
	
	static int makeChange(int n, int denom) {
		int nextDenom = 0;
		if (denom == 25) {
			nextDenom = 10;
		} else if (denom == 10) {
			nextDenom = 5;
		} else if (denom == 5) {
			nextDenom = 1;
		} else {
			return 1;
		}
		
		int ways = 0;
		for (int i = 0; i * denom <= n; i++) {
			ways += makeChange(n - i * denom, nextDenom); 
		}
		
		return ways;
	}
	
	
	// answer
	public static int makeChange2(int n, int denom) {
        System.out.println(n + " " + denom);
        int next_denom = 0;
        switch (denom) {
        case 25:
            next_denom = 10;
            break;
        case 10:
            next_denom = 5;
            break;
        case 5:
            next_denom = 1;
            break;
        case 1:
            return 1;
        }
        int ways = 0;
        for (int i = 0; i * denom <= n; i++) {
            ways += makeChange(n - i * denom, next_denom);
        }
        return ways;
	}
	
	public static int makeChange2(int n) {
        return makeChange(n, 25);
	}
	
	////////
	public static void main(String[] args) {
        for (int i = 100; i <= 100; i++) {
            System.out.println("makeChange(" + i + ") = " + makeChange(i));
            System.out.println("makeChange2(" + i + ") = " + makeChange2(i));
        }
	}
}
