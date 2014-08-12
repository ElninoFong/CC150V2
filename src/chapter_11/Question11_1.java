package chapter_11;

import CtCILibrary.AssortedMethods;

/*
 * 11.1
 * You are given two sorted arrays, A and B, where A has a large enough buffer at the end to hold B. 
 * Write a method to merge B into A in sorted order.
 */
public class Question11_1 {
	public static void merge(int[] A, int[] B, int lastA, int lastB) {
		int indexA = lastA - 1;
		int indexB = lastB - 1;
		int curr = lastA + lastB - 1;
		
		while (indexA >= 0 && indexB >= 0) {
			if (A[indexA] > B[indexB]) {
				A[curr] = A[indexA--];
			} else {
				A[curr] = B[indexB--];
			}
			curr--;
		}
		
		while (indexB >= 0) {
			A[curr--] = B[indexB--];
		}
	}
	
	////////
	public static void main(String[] args) {
        int[] a = {1, 3, 4, 5, 6, 8, 10, 0, 0, 0, 0, 0};
        int[] b = {4, 7, 9, 10, 12};
        merge(a, b, 7, 5);
        System.out.println(AssortedMethods.arrayToString(a));
	}
}
