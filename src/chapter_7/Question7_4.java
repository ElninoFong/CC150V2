package chapter_7;

/*
 * 7.4
 * Write methods to implement the multiply, subtract, and divide operations for integers. Use only the add operator.
 */
public class Question7_4 {
	static int negate(int a) {
		int res = 0;
		int d = a > 0 ? -1 : 1;		// add 1 or -1
		
		while (a != 0) {
			a += d;
			res += d;
		}
		
		return res;
	}
	
	public static int minus(int a, int b) {
		return a + negate(b);
	}
	
	static int abs(int a) {
		return a < 0 ? negate(a) : a;
	}
	
	public static int multiply(int a, int b) {
		if (abs(a) < abs(b)) return multiply(b, a);
		int res = 0;
		
		for (int i = 0; i < abs(b); i++) {
			res += a;
		}
		
		return b > 0 ? res : negate(res);
	}
	
	public static int divide(int a, int b) throws java.lang.ArithmeticException {
		if (b == 0) {
			throw new java.lang.ArithmeticException("error");
		}
		
		int absA = abs(a);
		int absB = abs(b);
		int product = 0;
		int res = 0;
		
		while (product <= absA) {
			product += absB;
			res++;
		}
		res--;
		
		if ((a > 0 && b < 0) || (a < 0 && b > 0)) {
			res = negate(res);
		}
		
		return res;
	}
	
	
	/////////
	public static int randomInt(int n) {
        return (int) (Math.random() * n);
	}
	
	public static void main(String[] args) {
        int q = multiply(-5, -10);
        System.out.println(q);
        
        for (int i = 0; i < 100; i++) {
            int a = randomInt(10);
            int b = randomInt(10);
            int ans = minus(a, b);
            if (ans != a - b) {
                System.out.println("ERROR");
            }
            System.out.println(a + " - " + b + " = " + ans);
        }
        for (int i = 0; i < 100; i++) {
            int a = randomInt(10);
            int b = randomInt(10);
            int ans = multiply(a, b);
            if (ans != a * b) {
                System.out.println("ERROR");
            }
            System.out.println(a + " * " + b + " = " + ans);
        }
        for (int i = 0; i < 100; i++) {
            int a = randomInt(10) + 1;
            int b = randomInt(10) + 1;
            System.out.print(a + " / " + b + " = ");
            int ans = divide(a, b);
            if (ans != a / b) {
                System.out.println("ERROR");
            }
            System.out.println(ans);
        }
	}
}
