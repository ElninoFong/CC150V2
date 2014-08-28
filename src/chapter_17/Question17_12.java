package chapter_17;

import java.util.Arrays;

/*
 * 17.12
 * Design an algorithm to find all pairs of integers within an array which sum to a specified value.
 */
public class Question17_12 {
	public static void printPairSums(int[] arr, int target) {
		if (arr == null || arr.length == 0) return;
		Arrays.sort(arr);
		int l = 0;
		int r = arr.length - 1;
		while (l < r) {
			int sum = arr[l] + arr[r];
			if (sum == target) {
				System.out.println(arr[l] + ", " + arr[r]);
				l++;
				r--;
			} else if (sum < target) {
				l++;
			} else {
				r--;
			}
		}
	}
	
	//////////
	public static void main(String[] args) {
        int[] test = {9, 3, 6, 5, 7, -1, 13, 14, -2, 12, 0};
        printPairSums(test, 12);
	}
}
