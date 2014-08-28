package chapter_10;

import java.util.*;

import CtCILibrary.AssortedMethods;

/*
 * 10.4
 * You have an array with all the numbers from 1 to N, where N is at most 32,000. 
 * The array may have duplicate entries and you do not know what N is.
 * With only 4 kilobytes of memory availavl, how would you print all duplicate elements in the array?
 */
public class Question10_4 {
	// 4KB = 4 * 2^10 * 8 = 32 * 1024 > 32,000, we can use bit map
	public static HashSet<Integer> checkDuplicates(int[] arr) {
		if (arr == null || arr.length == 0) return null;
		HashSet<Integer> res = new HashSet<Integer>();
		Question10_4MyBitSet bs = new Question10_4MyBitSet(32000);
		
		for (int i : arr) {
			if (bs.get(i)) {
				res.add(i);
			} else {
				bs.set(i);
			}
		}
		
		return res;
	}
	
	
	public static void main(String[] args) {
        int[] array = AssortedMethods.randomArray(10, 1, 30);
        System.out.println(AssortedMethods.arrayToString(array));
        HashSet<Integer> res = checkDuplicates(array);
        for (int r : res) {
        	System.out.print(r + " "); 
        }
	}
}
