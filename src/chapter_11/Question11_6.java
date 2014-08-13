package chapter_11;

import CtCILibrary.AssortedMethods;

/*
 * 11.6
 * Given an M * N matrix in which each row and each column is sorted in ascending order, write a method to find an element.
 */
public class Question11_6 {
	// TC:O(m+n), SC:O(1)
	public static boolean findElement1(int[][] matrix, int target) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
		int i = 0;
		int j = matrix[0].length - 1;
		while (i < matrix.length && j >= 0) {
			if (matrix[i][j] == target) return true;
			if (matrix[i][j] < target) {
				i++;
			} else {
				j--;
			}
		}
		return false;
	}
	
	
	// TC:O(log(m)+log(n)), SC:O(1)
	public static boolean findElement2(int[][] matrix, int target) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
		
		int l = 0, r = matrix.length - 1;
		int col = matrix[0].length - 1;
		while (l <= r) {
			int m = (l + r) / 2;
			if (matrix[m][col] == target) return true;
			if (matrix[m][col] > target) {
				r = m - 1;
			} else {
				l = m + 1;
			}
		}
		
		int row = l;
		if (row >= matrix.length) return false;
		
		l = 0;
		r = col;
		while (l <= r) {
			int m = (l + r) / 2;
			if (matrix[row][m] == target) return true;
			if (matrix[row][m] > target) {
				r = m - 1;
			} else {
				l = m + 1;
			}
		}
		
		return false;
	}
	
	
	public static void main(String[] args) {
        int M = 10;
        int N = 5;
        int[][] matrix = new int[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                matrix[i][j] = 10 * i + j;
            }
        }
        
        AssortedMethods.printMatrix(matrix);
        
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                int v = 10 * i + j;
                System.out.println(v + ": " + findElement2(matrix, v));
            }
        }
        
	}
}
