package chapter_5;

import CtCILibrary.AssortedMethods;

/*
 * 5.6
 * Write a program to swap odd and even bits in an integer with as few instructions as possible 
 * (e.g., bit 0 and bit 1 are swapped, bit 2 and bit 3 are swapped, and so on).
 */
public class Question5_6 {
	public static int swapOddEvenBits(int n) {
		int oddMask = 0x55555555;	// 01010101
		int evenMask = 0xAAAAAAAA;		// 10101010
		
		return ((n & oddMask) << 1) | ((n & evenMask) >> 1);
	}
	
	public static void main(String[] args) {
        int a = 103217;
        System.out.println(a + ": " + AssortedMethods.toFullBinaryString(a));
        int b = swapOddEvenBits(a);
        System.out.println(b + ": " + AssortedMethods.toFullBinaryString(b));
	}
}
