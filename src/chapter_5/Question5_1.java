package chapter_5;

import CtCILibrary.AssortedMethods;

/*
 * 5.1 
 * You are given two 32-bit numbers, N amd M, and two bit positions, i and j. 
 * Write a method to insert M into N such that M starts at bit j and ends at bit i. 
 * You can assume that the bits j through i have enough space to fit all of M. 
 * That is, if M = 10011, you can assume that there are at least 5 bits between j and i. 
 * You would not, for example, have j = 3 an i = 2, because M could not fully fit between bit 3 and bit 2.
 * EXAMPLE
 * Input:  N = 10000000000, M = 10011, i = 2, j = 6
 * Output: N = 10001001100
 */
public class Question5_1 {
	public static int updateBits(int M, int N, int i, int j) {
		if (j >= 32 || j < i) return 0;
		
		int allOnes = ~0;
		int left = allOnes << j + 1;
		int right = (1 << i) - 1;
		int mask = left | right;
		
		M &= mask;
		N <<= i;
		
		return M | N;
	}
	
	
	public static void main(String[] args) {
        int a = 103217;
        System.out.println(AssortedMethods.toFullBinaryString(a));
        int b = 13;
        System.out.println(AssortedMethods.toFullBinaryString(b));              
        int c = updateBits(a, b, 4, 12);
        System.out.println(AssortedMethods.toFullBinaryString(c));
	}
}