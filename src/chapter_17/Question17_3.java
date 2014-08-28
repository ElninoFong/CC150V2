package chapter_17;

/*
 * 17.3
 * Write an algorithm which computes the number of trailing zeros in n factorial.
 */
public class Question17_3 {
	public static int countFactZeros(int n) {
		if (n < 0) return 0;
		if (n == 0) return 1;
		
		int res = 0;
		int k = 5;
		while (n / k != 0) {
			res += n / k;
			k *= 5;
		}
		
		return res;
	}
	
	
	// method 2:
	public static int factorsOf5(int i) {
        int count = 0;
        while (i % 5 == 0) {
            count++;
            i /= 5;
        }
        return count;
	}
	
	public static int countFactZeros2(int num) {
        int count = 0;          
        for (int i = 2; i <= num; i++) {
            count += factorsOf5(i);
        }
        return count;
	}

	//////////////
	public static long factorial(long num) {
        if (num == 1) {
            return 1;
        } else if (num > 1) {
            return num * factorial(num - 1);
        } else {
            return -1; // Error
        }
	}
	
	public static void main(String[] args) {
        for (int i = 1; i < 20; i++) {
            System.out.println(i + "! (or " + factorial(i) + ") has " + countFactZeros(i) + " zeros");
        }
        
//		for (int i = 1; i < 200; i++) {
//			System.out.println(countFactZeros(i) + ", " + countFactZeros2(i));
//		}
	}
}
