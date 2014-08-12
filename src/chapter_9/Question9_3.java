package chapter_9;

import java.util.Arrays;

import CtCILibrary.AssortedMethods;

/*
 * 9.3
 * A magic index in an array A[0...n-1] is defined to be an index such that A[i] = i. 
 * Given a sorted array of distinct integers, write a method to find a magic index, if one exists, in array A.
 * FOLLOW UP
 * What if the values are not distinct?
 */
public class Question9_3 {
	public static int findMagicIndexDistinct(int[] A) {
		if (A == null || A.length == 0) return -1;
		return findMagicIndexDistinct(A, 0, A.length - 1);
	}
	
	static int findMagicIndexDistinct(int[] A, int l, int r) {
		if (l > r) return -1;
		int mid = (l + r) / 2;
		if (A[mid] > mid) return findMagicIndexDistinct(A, l, mid - 1);
		if (A[mid] < mid) return findMagicIndexDistinct(A, mid + 1, r);
		return mid;
	}
	
	
	// FOLLOW UP
	public static int findMagicIndexDuplicate(int[] A) {
		if (A == null || A.length == 0) return -1;
		return findMagicIndexDuplicate(A, 0, A.length - 1);
	}
	
	static int findMagicIndexDuplicate(int[] A, int l, int r) {
		if (l < 0 || r > A.length) return -1;		// err: miss this
		if (l > r) return -1;
		int mid = (l + r) / 2;
		
		if (A[mid] == mid) return mid;
		
		// search left
		int rightIndex = Math.min(mid - 1, A[mid]); 
		int left = findMagicIndexDuplicate(A, l, rightIndex);
		if (left != -1) return left;
		
		// search right
		int leftIndex = Math.max(mid + 1, A[mid]);
		return findMagicIndexDuplicate(A, leftIndex, r);
	}
	
	/////////////////////
	/* Creates an array that is distinct and sorted */
    public static int[] getDistinctSortedArray(int size) {
        int[] array = AssortedMethods.randomArray(size, -1 * size, size);
        Arrays.sort(array);
        for (int i = 1; i < array.length; i++) {
            if (array[i] == array[i-1]) {
                    array[i]++;
            } else if (array[i] < array[i - 1]) {
                    array[i] = array[i-1] + 1;
            }
        }
        return array;
    }
    
    /* Creates an array that is sorted */
    public static int[] getSortedArray(int size) {
        int[] array = AssortedMethods.randomArray(size, -1 * size, size);
        Arrays.sort(array);
        return array;
    }
    
    
    public static int magicSlow(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == i) {
                    return i;
            }
        }
        return -1;
    }
    
    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            int size = AssortedMethods.randomIntInRange(5, 20);
            
//            int[] array = getDistinctSortedArray(size);
//            int v2 = findMagicIndexDistinct(array);
            
            int[] array = getSortedArray(size);
            int v2 = findMagicIndexDuplicate(array);
            
            if (v2 == -1 && magicSlow(array) != -1) {
                int v1 = magicSlow(array);
                System.out.println("Incorrect value: index = -1, actual = " + v1 + " " + i);
                System.out.println(AssortedMethods.arrayToString(array));
                break;
            } else if (v2 > -1 && array[v2] != v2) {
                System.out.println("Incorrect values: index= " + v2 + ", value " + array[v2]);
                System.out.println(AssortedMethods.arrayToString(array));
                break;
            } else {
            	System.out.println("Correct");
            }
        }
    }

}
