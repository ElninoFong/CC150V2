package chapter_17;

/*
 * 17.4
 * Write a method which finds the maximum of two numbers. You should not use if-else or any other comparison operator.
 */
public class Question17_4 {
	public static int getMax(int a, int b) {
		int c = a - b;
		
		int sa = sign(a);
		int sb = sign(b);
		int sc = sign(c);
		
		int useSignA = sa ^ sb;
		int useSignC = flip(useSignA);
		
		int k = useSignA * sa + useSignC * sc;
		int q = flip(k);
		
		return a * k + b * q;
	}
	
	// return 1 if x is positive, otherwise 0
	static int sign(int x) {
		return flip((x >> 31) & 1);
	}
	
	static int flip(int x) {
		return x ^ 1;
	}
	
	
	//////////////
	// may overflow
	public static int getMaxNaive(int a, int b) {
        int k = sign(a - b);
        int q = flip(k);
        return a * k + b * q;
	}
	
	
	public static void main(String[] args) {
        int a = 26;
        int b = -15;
        
        System.out.println("max_naive(" + a + ", " + b + ") = " + getMaxNaive(a, b));
        System.out.println("max(" + a + ", " + b + ") = " + getMax(a, b));              
        
        a = -15;
        b = 2147483647;
        
        System.out.println("max_naive(" + a + ", " + b + ") = " + getMaxNaive(a, b));
        System.out.println("max(" + a + ", " + b + ") = " + getMax(a, b));
	}
}
