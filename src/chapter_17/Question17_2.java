package chapter_17;

import CtCILibrary.AssortedMethods;

/*
 * 17.2
 * Design an algorithm to figure out if someone has won a game of tic-tac-toe.
 */
public class Question17_2 {
	// "base 3" method if check multiple times
	// N * N 
	
	enum Piece {Empty, Blue, Red};
	
	public static Piece hasWon(Piece[][] board) {
		int n = board.length;
		
		// check rows
		for (int i = 0; i < n; i++) {
			if (board[i][0] != Piece.Empty) {
				int j = 1;
				for (j = 1; j < n; j++) {
					if (board[i][j] != board[i][j - 1]) break;
				}
				if (j == n) return board[i][0];
			}
		}
		
		// check cols
		for (int j = 0; j < n; j++) {
			if (board[0][j] != Piece.Empty) {
				int i = 1;
				for (i = 1; i < n; i++) {
					if (board[i][j] != board[i - 1][j]) break;
				}	
				if (i == n) return board[0][j];
			}
		}
		
		// check diagonal
		if (board[0][0] != Piece.Empty) {
			int i = 1;
			for (i = 1; i < n; i++) {
				if (board[i][i] != board[i - 1][i - 1]) break;
			}
			if (i == n) return board[0][0];
		}
		
		// check reversed diagonal
		if (board[0][n - 1] != Piece.Empty) {
			int i = 1;
			for (i = 1; i < n; i++) {
				if (board[i][n - i - 1] != board[i - 1][n - i]) break;
			}
			if (i == n) return board[0][n - 1];
		}
		
		return Piece.Empty;
	}
	
	
	////////////
	public static Piece convertIntToPiece(int i) {
        if (i == 1) {
            return Piece.Blue;
        } else if (i == 2) {
            return Piece.Red;
        } else {
            return Piece.Empty;
        }
	}
	
	public static void main(String[] args) {
        for (int k = 0; k < 100; k++) {
            int N = 3;
            int[][] board_t = AssortedMethods.randomMatrix(N, N, 0, 2);
            Piece[][] board = new Piece[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    board[i][j] = convertIntToPiece(board_t[i][j]);
                }
            }
            Piece p = hasWon(board);
            System.out.println(p);
            AssortedMethods.printMatrix(board_t);
        }
	}
}
