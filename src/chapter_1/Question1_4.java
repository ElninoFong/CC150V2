package chapter_1;

import CtCILibrary.AssortedMethods;

/*
 * 1.4 
 * Write a method to replace all spaces in a string with '%20'. 
 * You may assume that the string has sufficient space at the end of the string to hold the additional characters, 
 * and that you are given the "true" length of the string. 
 * (Note: if implementing in Java, please use a character array so that you can perform this operation in place.)
 * EXAMPLE
 * Input:  "Mr John Smith    "
 * Output: "Mr%20John%20Smith"
 */
public class Question1_4 {
	// TC:O(n), SC:O(1)
	public static void replaceSpaces(char[] arr, int length) {
		int space = 0;
		for (char c : arr) {
			if (c == ' ') {
				space++;
			}
		}
		int end = length + space * 2;
		int curr = length - 1;		// start from the end
		while (curr >= 0) {
			if (arr[curr] == ' ') {
				arr[--end] = '0';
				arr[--end] = '2';
				arr[--end] = '%';
			} else {
				arr[--end] = arr[curr];
			}
			curr--;
		}
	}
	
	public static void main(String[] args) {
        String str = "abc d e f";
        char[] arr = new char[str.length() + 3 * 2 + 1];
        for (int i = 0; i < str.length(); i++) {
            arr[i] = str.charAt(i);
        }
        replaceSpaces(arr, str.length());       
        System.out.println("\"" + AssortedMethods.charArrayToString(arr) + "\"");
	}
}
