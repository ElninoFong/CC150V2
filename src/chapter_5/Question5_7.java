package chapter_5;

import java.util.*;

/*
 * 5.7
 * An array A contains all the integers form 0 to n, except for one number which is missing.
 * In thes problem, we cannot access an entire integer in A with a single operation.
 * The elements of A are represented in binary, and the only operation we can use to access them is "fetch the jth bit of A[i]",
 * which taks constant time. Write code to find the missing integer. Can you do it in O(n) time?
 */
public class Question5_7 {
	public static int findMissing(ArrayList<Question5_7BitInteger> array) {
       return findMissing(array, Question5_7BitInteger.INTEGER_SIZE - 1);
    }        

    private static int findMissing(ArrayList<Question5_7BitInteger> input, int column) {
        if (column < 0) { // Base case and error condition
            return 0;
        }
        
        ArrayList<Question5_7BitInteger> oneBits = new ArrayList<Question5_7BitInteger>(input.size()/2);
        ArrayList<Question5_7BitInteger> zeroBits = new ArrayList<Question5_7BitInteger>(input.size()/2);
        for (Question5_7BitInteger t : input) {
            if (t.fetch(column) == 0) {
                zeroBits.add(t);
            } else {
                oneBits.add(t);
            }
        }
        
        if (zeroBits.size() <= oneBits.size()) {
            int v = findMissing(zeroBits, column - 1);
            System.out.print("0");
            return (v << 1) | 0;
        } else {
            int v = findMissing(oneBits, column - 1);
            System.out.print("1");
            return (v << 1) | 1;
        }
    }
	
	
	
	/* Create a random array of numbers from 0 to n, but skip 'missing' */
    public static ArrayList<Question5_7BitInteger> initialize(int n, int missing) {
    	Question5_7BitInteger.INTEGER_SIZE = Integer.toBinaryString(n).length();
        ArrayList<Question5_7BitInteger> array = new ArrayList<Question5_7BitInteger>();
        
        for (int i = 1; i <= n; i++) {
            array.add(new Question5_7BitInteger(i == missing ? 0 : i));
        }

        // Shuffle the array once.
        for (int i = 0; i < n; i++){
            int rand = i + (int) (Math.random() * (n-i));
            array.get(i).swapValues(array.get(rand));
        }
        
        return array;
    }

	
	public static void main(String[] args) {
        Random rand = new Random(); 
        int n = rand.nextInt(300000) + 1;
        int missing = rand.nextInt(n+1);
        ArrayList<Question5_7BitInteger> array = initialize(n, missing);
        System.out.println("The array contains all numbers but one from 0 to " + n + ", except for " + missing);
        
        int result = findMissing(array);
        if (result != missing) {
            System.out.println("Error in the algorithm!\n" + "The missing number is " + missing + ", but the algorithm reported " + result);
        } else {
            System.out.println("The missing number is " + result);
        }
    }
}
