package chapter_17;

/*
 * 17.6
 * Given an array of integers, write a method to find indices m and n such that if you sorted elemetns m through n, 
 * the entire array would be sorted. Minimize n - m (that is, find the smallest such sequence).
 * EXAMPLE
 * Input: 1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19
 * Output: (3, 9)
 */
public class Question17_6 {
	public static void findIndices(int[] arr) {
		if (arr == null || arr.length <= 1) return;
		int l = 1; 
		int r = arr.length - 2;
		
		// find left start point
		while (arr[l - 1] <= arr[l]) {
			l++;
			if (l == arr.length) {
				System.out.println("Array is already sorted");
				return;
			}
		}
		l--;
		
		// find right start point
		while (arr[r] <= arr[r + 1]) {
			r--;
			if (l == -1) {
				System.out.println("Array is already sorted");
				return;
			}
		}
		r++;
		
		// find the max and min in the unsorted sub array
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for (int p = l; p <= r; p++) {
			max = Math.max(max, arr[p]);
			min = Math.min(min, arr[p]);
		}
		
		// expand to the required position
		while (l >= 0 && arr[l] > min) {
			l--;
		}
		while (r < arr.length && arr[r] < max) {
			r++;
		}
		l++;
		r--;
		
		System.out.println("(" + l + ", " + r + ")");
	}
	
	
	
	//////////////////
	public static int findEndOfLeftSubsequence(int[] array) {
        for (int i = 1; i < array.length; i++) {
                if (array[i] < array[i - 1]) {
                        return i - 1;
                }
        }
        return array.length - 1;
	}
	
	public static int findStartOfRightSubsequence(int[] array) {
	        for (int i = array.length - 2; i >= 0; i--) {
	                if (array[i] > array[i + 1]) {
	                        return i + 1;
	                }
	        }
	        return 0;
	}               
	
	public static int shrinkLeft(int[] array, int min_index, int start) {
	        int comp = array[min_index];
	        for (int i = start - 1; i >= 0; i--) {
	                if (array[i] <= comp) {
	                        return i + 1;
	                }
	        }
	        return 0;
	}
	
	public static int shrinkRight(int[] array, int max_index, int start) {
	        int comp = array[max_index];
	        for (int i = start; i < array.length; i++) {
	                if (array[i] >= comp) {
	                        return i - 1;
	                }
	        }
	        return array.length - 1;
	}       
	
	public static void findUnsortedSequence(int[] array) {
	        // find left subsequence
	        int end_left = findEndOfLeftSubsequence(array);
	        
	        // find right subsequence
	        int start_right = findStartOfRightSubsequence(array);           
	        
	        // find min and max element of middle
	        int min_index = end_left + 1;
	        if (min_index >= array.length) {
	                //System.out.println("The array is already sorted.");
	                return; // Already sorted
	        }
	        
	        int max_index = start_right - 1;
	        for (int i = end_left; i <= start_right; i++) {
	                if (array[i] < array[min_index]) {
	                        min_index = i;
	                }
	                if (array[i] > array[max_index]) {
	                        max_index = i;
	                }
	        }
	        
	        // slide left until less than array[min_index]
	        int left_index = shrinkLeft(array, min_index, end_left);
	
	        // slide right until greater than array[max_index]
	        int right_index = shrinkRight(array, max_index, start_right);
	        
	        if (validate(array, left_index, right_index)) {
	                System.out.println("TRUE: " + left_index + " " + right_index);
	        } else {
	                System.out.println("FALSE: " + left_index + " " + right_index);
	        }
	}
	
	/* Validate that sorting between these indices will sort the array. Note that this is not a complete
	 * validation, as it does not check if these are the best possible indices.
	 */
	public static boolean validate(int[] array, int left_index, int right_index) {
	        int[] middle = new int[right_index - left_index + 1];
	        for (int i = left_index; i <= right_index; i++) {
	                middle[i - left_index] = array[i];
	        }
	        java.util.Arrays.sort(middle);
	        for (int i = left_index; i <= right_index; i++) {
	                array[i] = middle[i - left_index];
	        }
	        for (int i = 1; i < array.length; i++) {
	                if (array[i-1] > array[i]) {
	                        return false;
	                }
	        }
	        return true;
	}
	
	public static void main(String[] args) {
//	        int[] array = {1, 2, 3, 4, 5, 11, 7, 12, 6, 7, 16, 18, 19};
//	        int[] array = {1, 2, 3, 2, 0, 1, 4};
//			int[] array = {1, 0};
			int[] array = {1, 4, 5, 2, 3, 4};
	        findIndices(array);
	        findUnsortedSequence(array);
	}
}
