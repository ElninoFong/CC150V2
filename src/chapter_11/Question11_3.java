package chapter_11;

/*
 * 11.3
 * Given a sorted array of n integers that has been rotated an unknown number of times, write code to find an element in the array.
 * You may assume that the array was originally sorted in increasing oreder.
 * EXAMPLE
 * Input: find 5 in {15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14}
 * Output: 8 (the index of 5 in the array)
 */
public class Question11_3 {
	public static int search(int[] arr, int target) {
		if (arr == null || arr.length == 0) return -1;
		return search(arr, target, 0, arr.length - 1);
	}
	
	static int search(int[] arr, int target, int l, int r) {
		if (l > r) return -1;
		int mid = (l + r) / 2;
		if (arr[mid] == target) return mid;
		
		if (arr[l] < arr[mid]) {
			if (target >= arr[l] && target < arr[mid]) {
				return search(arr, target, l, mid - 1);
			} else {
				return search(arr, target, mid + 1, r);
			}
		} else if (arr[l] > arr[mid]) {
			if (target > arr[mid] && target <= arr[r]) {
				return search(arr, target, mid + 1, r);
			} else {
				return search(arr, target, l, mid - 1);
			}
		} else {
			if (arr[mid] != arr[r]) {
				return search(arr, target, mid + 1, r);
			} else {
				int res = search(arr, target, mid + 1, r);
				if (res > -1) {
					return res;
				} else {
					return search(arr, target, l, mid - 1);
				}
			}
		}
	}
	
	
	////////
	public static void main(String[] args) {
        int[] a = { 2, 3, 2, 2, 2, 2, 2, 2 , 2 , 2 };

        System.out.println(search(a, 2));
        System.out.println(search(a, 3));
        System.out.println(search(a, 4));
        System.out.println(search(a, 1));
        System.out.println(search(a, 8));
	}
}
