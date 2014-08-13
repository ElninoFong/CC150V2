package chapter_11;

import java.util.*;

import CtCILibrary.AssortedMethods;

/*
 * 11.2
 * Write a method to sort an array of strings so that all the anagrams are next to each other.
 */
public class Question11_2 {
	public static String sortChars(String s) {
		char[] arr = s.toCharArray();
		Arrays.sort(arr);
		return new String(arr);
	}
	
	public static void sortAnagrams1(String[] arr) {
		Arrays.sort(arr, new Comparator<String>() {
			public int compare(String s1, String s2) {
				return sortChars(s1).compareTo(sortChars(s2));
			}
		});
	}
	
	public static void sortAnagrams2(String[] arr) {
		HashMap<String, ArrayList<String>> hm = new HashMap<String, ArrayList<String>>();
		
		for (String s : arr) {
			String sorted = sortChars(s);
			if (!hm.containsKey(sorted)) {
				hm.put(sorted, new ArrayList<String>());
			}
			hm.get(sorted).add(s);
		}
		
		int i = 0;
		for (String sorted : hm.keySet()) {
			for (String s : hm.get(sorted)) {
				arr[i++] = s;
			}
		}
	}
	
	////////
    public static void main(String[] args) {
        String[] array = {"apple", "banana", "carrot", "ele", "duck", "papel", "tarroc", "cudk", "eel", "lee"};
        System.out.println(AssortedMethods.stringArrayToString(array));
//        sortAnagrams1(array);
        sortAnagrams2(array);
        System.out.println(AssortedMethods.stringArrayToString(array));
    }
}
