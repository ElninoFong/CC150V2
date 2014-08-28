package chapter_17;

import CtCILibrary.AssortedMethods;

/*
 * 17.7
 * Given any integer, print an English phrase that describes the integer (e.g., "One Thousand, Two Hundred Thirty Four").
 */
public class Question17_7 {
	public static String[] digits = {"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    public static String[] teens = {"Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    public static String[] tens = {"Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    public static String[] bigs = {"", "Thousand", "Million", "Billion"};
    
	public static String numToString(int n) {
		StringBuilder res = new StringBuilder();
		if (n == 0) return "Zero";
		if (n < 0) {
			res.append("Negative ");
			n = 0 - n;
			res.append(numToString(n));
			return res.toString();
		}
		
		int count = 0;
		while (n > 0) {
			String s = numToString100(n % 1000) + " " + bigs[count] + " ";
			res.insert(0, s);
			
			n /= 1000;
			count++;
		}
		
		return res.toString();
	}
	
	static String numToString100(int n) {
		StringBuilder sb = new StringBuilder();
		
		if (n >= 100) {
			sb.append(digits[n / 100 - 1]);
			sb.append(" Hundred");
			n %= 100;
			if (n > 0) {
				sb.append(" ");
			}
		}
		
		if (n >= 11 && n <= 19) {
			sb.append(teens[n % 10 - 1]);
		} else if (n >= 10) {
			sb.append(tens[n / 10 - 1]);
			n %= 10;
			if (n > 0) {
				sb.append(" ");
			}
 		}
		
		if (n >= 1 && n <= 9) {
			sb.append(digits[n - 1]);
		}
		
		return sb.toString();
	}
	
	////////////////////
	public static void main(String[] args) {                
        /* numbers between -1 and -10000000 */
        for (int i = 0; i < 8; i++) {
                int value = (int) Math.pow(10, i) * -1;
                String s = numToString(value);
                System.out.println(value + ": " + s);
        }                       
        
        /* numbers between 0 and 100 */
        for (int i = 0; i < 10; i++) {
                int value = AssortedMethods.randomIntInRange(0, 100);
                String s = numToString(value);
                System.out.println(value + ": " + s);
        }       
        
        /* numbers between 100 and 1000 */
        for (int i = 0; i < 10; i++) {
                int value = AssortedMethods.randomIntInRange(100, 1000);
                String s = numToString(value);
                System.out.println(value + ": " + s);
        }
        
        /* numbers between 1000 and 100000 */
        for (int i = 0; i < 10; i++) {
                int value = AssortedMethods.randomIntInRange(1000, 100000);
                String s = numToString(value);
                System.out.println(value + ": " + s);
        }               
        
        
        /* numbers between 100000 and 1000000 */
        for (int i = 0; i < 10; i++) {
                int value = AssortedMethods.randomIntInRange(100000, 100000000);
                String s = numToString(value);
                System.out.println(value + ": " + s);
        }       
        
        /* numbers between 100000 and 1000000 */
        for (int i = 0; i < 10; i++) {
                int value = AssortedMethods.randomIntInRange(100000000, 1000000000);
                String s = numToString(value);
                System.out.println(value + ": " + s);
        }                       
	}
}
