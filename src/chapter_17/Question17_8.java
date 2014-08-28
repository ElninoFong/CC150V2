package chapter_17;

/*
 * 17.8
 * You are given an array of integers (both positive and negative). Find the contiguous sequence with the largest sum. Return the sum.
 * EXAMPLE
 * Input: 2, -8, 3, -2, 4, -10
 * Output: 5 (i.e., {3, -2, 4})
 */
public class Question17_8 {
	public static int getMaxSum(int[] arr) {
		int maxSum = Integer.MIN_VALUE;
		int currSum = 0;
		
		for (int i = 0; i < arr.length; i++) {
			currSum += arr[i];
			maxSum = Math.max(maxSum, currSum);
			currSum = Math.max(currSum, 0);
		}
		
		return maxSum;
	}
	
	//////////////
	public static void main(String[] args) {
        int[] a = {2, -8, 3, -2, 4, -10};
        System.out.println(getMaxSum(a));
	}
}
