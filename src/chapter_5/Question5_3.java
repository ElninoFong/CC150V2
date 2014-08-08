package chapter_5;

/*
 * 5.3
 * Given a positive integer, print the next smallest and the next largest number that 
 * have the same number of 1 bits in their binary representation.
 */
public class Question5_3 {
	public static int getNext(int n) {
		int c = n;
		int c0 = 0;
		int c1 = 0;
		
		// count 0s
		while ((c & 1) == 0 && c != 0) {
			c0++;
			c >>= 1;
		}
		// count 1s
		while ((c & 1) == 1) {
			c1++;
			c >>= 1;
		}
		// position of rightmost non-trailing zero
		int p = c0 + c1;
		
		// valid check
		if (p == 31 || p == 0) return -1;	// 32 - 1, because the highest bit is sign bit
		
		n |= (1 << p);
		n &= (~0 << p);
		n |= (1 << (c1 - 1)) - 1;	// err: c1 - 1, because need to flip 1 to 0
		
		return n;
	}
	
	public static int getNextArith(int n) {
		int c = n;
		int c0 = 0;
		int c1 = 0;
		
		// count 0s
		while ((c & 1) == 0 && c != 0) {
			c0++;
			c >>= 1;
		}
		// count 1s
		while ((c & 1) == 1) {
			c1++;
			c >>= 1;
		}
		// position of rightmost non-trailing zero
		int p = c0 + c1;
		
		// valid check
		if (p == 31 || p == 0) return -1;	// 32 - 1, because the highest bit is sign bit
		
		return n + (1 << c0) + (1 << (c1 - 1)) - 1;
	}
	
	public static int getPrev(int n) {
		int c = n;
		int c0 = 0;
		int c1 = 0;
		
		// count 1s
		while ((c & 1) == 1) {
			c1++;
			c >>= 1;
		}
		
		// valid check
		if (c == 0) return -1;
		
		// count 0s
		while ((c & 1) == 0 && c != 0) {
			c0++;
			c >>= 1;
		}
		int p = c0 + c1;
		
		n &= (~(1 << p));
		n &= (~0 << p);
		n |= ((1 << p) - 1) - ((1 << (c0 - 1)) - 1);
		
		return n;
	}
	
	public static int getPrevArith(int n) {
		int c = n;
		int c0 = 0;
		int c1 = 0;
		
		// count 1s
		while ((c & 1) == 1) {
			c1++;
			c >>= 1;
		}
		
		// valid check
		if (c == 0) return -1;
		
		// count 0s
		while ((c & 1) == 0 && c != 0) {
			c0++;
			c >>= 1;
		}
		
		return n - (1 << c1) - (1 << (c0 - 1)) + 1;
	}
	
	public static void binPrint(int i) {
        System.out.println(i + ": " + Integer.toBinaryString(i));               
	}
	
	public static void main(String[] args) {
        for (int i = 0; i < 200; i++) {
//            int p1 = getPrevSlow(i);
            int p2 = getPrev(i);
            int p3 = getPrevArith(i);
            
//            int n1 = getNextSlow(i);
            int n2 = getNext(i);
            int n3 = getNextArith(i);
            
//            if (p1 != p2 || p2 != p3 || n1 != n2 || n2 != n3) {
	            binPrint(i);
//	            binPrint(p1);
	            binPrint(p2);
	            binPrint(p3);
//	            binPrint(n1);
	            binPrint(n2);
	            binPrint(n3);
	            System.out.println("");
//            }                       
        }
        System.out.println("Done!");
	}
}
