package chapter_9;

import java.util.*;

/*
 * 9.9
 * Write an algorithm to print all ways of arranging eight queens on an 8*8 chess board 
 * so that none of them share the same row, column or diagonal.
 * In this case, "diagonal" means all diagonals, not just the two that bisect the board.
 */
public class Question9_9 {
	public static int GRID_SIZE = 8;	// good OOD
	
	// key: cols array is int type to record the specific column in each row
	static void placeQueens(int[] cols, int currRow, ArrayList<int[]> res) {
		if (currRow == GRID_SIZE) {
			res.add(cols.clone());
			return;
		}
		
		for (int i = 0; i < 8; i++) {
			if (checkValid(cols, currRow, i)) {		// good coding: make checkValid a seperate function
				cols[currRow] = i;
				placeQueens(cols, currRow + 1, res);
//				cols[currRow] = -1;		// no need to clear cols[currRow]?
										// because next i in for loop will repalce it.
			}
		}
	}
	
	static boolean checkValid(int[] cols, int currRow, int i) {
		for (int row = 0; row < currRow; row++) {
			// check if same column
			if (cols[row] == i) return false;
			
			// check if same diagonal
			int colDistance = Math.abs(cols[row] - i);
			int rowDistance = Math.abs(row - currRow);
			if (colDistance == rowDistance) return false;
		}
		return true;
	}
	
	
	
	
	///////////
	public static void clear(int[] columns) {
        for (int i = 0; i < GRID_SIZE; i++) {
            columns[i] = -1;
        }
	}
	
	public static void printBoard(int[] columns) {
        System.out.println("-----------------");
        for(int i = 0; i < GRID_SIZE; i++){
            System.out.print("|");
            for (int j = 0; j < GRID_SIZE; j++){
                if (columns[i] == j) {
                    System.out.print("Q|");
                } else {
                    System.out.print(" |");
                }
            }
            System.out.println("\n-----------------");
        }
        System.out.println("");
	}
	
	public static void printBoards(ArrayList<int[]> boards) {
		for (int i = 0; i < boards.size(); i++) {
			int[] board = boards.get(i);
			printBoard(board);
		}
	}
    
	public static void main(String[] args) {
		ArrayList<int[]> results = new ArrayList<int[]>();
		int[] columns = new int[GRID_SIZE];
		clear(columns);
		placeQueens(columns, 0, results);
		printBoards(results);
		System.out.println(results.size());
	}
}
