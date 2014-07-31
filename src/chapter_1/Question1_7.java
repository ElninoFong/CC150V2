package chapter_1;

import CtCILibrary.AssortedMethods;

/*
 * 1.7 
 * Write an algorithm such that if an element in an MxN matrix is 0, its entire row and column are set to 0.
 */
public class Question1_7 {
	// TC:O(M*N), SC:O(1)
	// Bitmap
	public static void setZeros(int[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;
		int row = 0, col = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == 0) {
					row |= (1 << i);
					col |= (1 << j);
				}
			}
		}
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if ((row & (1 << i)) > 0 || (col & (1 << j)) > 0) {
					matrix[i][j] = 0;
				}
			}
		}
	}
	
	public static void main(String[] args) {
        int[][] matrix = AssortedMethods.randomMatrix(3, 5, 0, 5);
        AssortedMethods.printMatrix(matrix);
        setZeros(matrix);
        System.out.println();
        System.out.println();
        AssortedMethods.printMatrix(matrix);
	}
}
