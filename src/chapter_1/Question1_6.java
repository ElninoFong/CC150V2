package chapter_1;

import CtCILibrary.AssortedMethods;

/*
 * 1.6 
 * Given an image represented by an NxN matrix, where each pixel in the image is 4 bytes, wirte a method to rotate the image by 90 degrees. 
 * Can you do this in place?
 */
public class Question1_6 {
	// TC:O(n^2), SC:O(1)
	// 4 bytes can be stored in 1 int
	public static void rotate(int[][] matrix) {
		int n = matrix.length;
		int tmp;
		for (int i = 0; i < n / 2; i++) {
			int last = n - 1 - i;	// last pixel of current layer
			for (int j = i; j < n - i - 1; j++) {		// last pixel is substituted, so minus 1
				int offset = j - i;
				tmp = matrix[i][j];
				matrix[i][j] = matrix[last - offset][i];
				matrix[last - offset][i] = matrix[last][last - offset];
				matrix[last][last - offset] = matrix[j][last];
				matrix[j][last] = tmp;
			}
		}
	}
	
	public static void main(String[] args) {
        int[][] matrix = AssortedMethods.randomMatrix(10, 10, 0, 9);
        AssortedMethods.printMatrix(matrix);
        rotate(matrix);
        System.out.println();
        AssortedMethods.printMatrix(matrix);
	}
}
