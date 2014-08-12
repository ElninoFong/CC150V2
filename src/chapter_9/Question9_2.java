package chapter_9;

import java.awt.Point;
import java.util.ArrayList;

import CtCILibrary.AssortedMethods;

/*
 * 9.2
 * Imagine a robot sitting on the upper left corner of an X by Y grid. The robot can only move in two directions: right and down.
 * How many possible paths are there for the robot to go from (0, 0) to (X, Y)?
 * FOLLOW UP
 * Imagine certain spots are "off limits", such that the robot cannot step on them.
 * Design an algorithm to find a path for the robot from the top left to the bottom right.
 */
public class Question9_2 {
	public static boolean getPath(int[][] maze, ArrayList<Point> path) {
		int m = maze.length;
		int n = maze[0].length;
		boolean[][] res = new boolean[m][n];
		
		// init
		if (maze[0][0] == 0 || maze[m - 1][n - 1] == 0) return false;
		res[0][0] = true;
		for (int i = 1; i < m; i++) {
			if (maze[i][0] != 0) {  	// not blocked
				res[i][0] = res[i - 1][0];
			}
		}
		for (int j = 1; j < n; j++) {
			if (maze[0][j] != 0) {
				res[0][j] = res[0][j - 1];
			}
		}
		
		// dp
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (maze[i][j] != 0) {
					res[i][j] = res[i - 1][j] || res[i][j - 1];
				}
			}
		}
		
		// trace path
		if (res[m - 1][n - 1]) {
			int i = m - 1;
			int j = n - 1;
			path.add(0, new Point(i, j));
			
			while (i != 0 || j != 0) {
				if (j == 0 || (i != 0 && res[i - 1][j])) {
					i--;
				} else {
					j--;
				}
				path.add(0, new Point(i, j));
			}
			
			return true;
		}
		
		return false;
	}
	
	
	//////////////
	public static void main(String[] args) {
		int[][] maze = AssortedMethods.randomMatrix(10, 10, 0, 4);
        AssortedMethods.printMatrix(maze);
        ArrayList<Point> path = new ArrayList<Point>();
        boolean success = getPath(maze, path);
        if (success) {
                String s = AssortedMethods.listOfPointsToString(path);
                System.out.println(s);
        } else {
                System.out.println("No path found.");
        }
	}
}
