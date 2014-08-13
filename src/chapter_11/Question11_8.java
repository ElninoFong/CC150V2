package chapter_11;

import CtCILibrary.AssortedMethods;

/*
 * 11.8
 * Imagine you are reading in the stream of integers. 
 * Periodically, you wish to be able to look up the rank of a number x (the number of values less than or equal to x).
 * Implement the data structures and algorithms to support these operations.
 * That is, implement the method track(int x), which is called when each number is generated, and the method getRankOfNumber(int x),
 * which returns the number of values less than or equal to x (not including x itself).
 * EXAMPLE
 * Stream (in order of appearance): 5, 1, 4, 4, 5, 9, 7, 13, 3
 * getRankOfNumber(1) = 0
 * getRankOfNumber(3) = 1
 * getRankOfNumber(4) = 3
 */
public class Question11_8 {
	public static void main(String[] args) {
        Question11_8RankTree tree = new Question11_8RankTree();
        for (int i = 0; i < 100; i++) {
            int x = AssortedMethods.randomIntInRange(0, 99);
            tree.insert(x);       
        }
        
        for (int i = 0; i < 100; i++) {
            int rank1 = tree.getRankOfNumber(i);
            System.out.println(i + " has rank " + rank1);
        }
	}
}
