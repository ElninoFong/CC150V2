package chapter_9;

import java.util.ArrayList;

/*
 * 9.4
 * Write a method to return all subsets of a set.
 */
public class Question9_4 {
	public static ArrayList<ArrayList<Integer>> getSubsets1(ArrayList<Integer> arr) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		result.add(new ArrayList<Integer>());	// empty subset
		
		for (int i : arr) {
			ArrayList<ArrayList<Integer>> prev = new ArrayList<ArrayList<Integer>>();
			for (int curr = 0; curr < result.size(); curr++) {
				prev.add(new ArrayList<Integer>(result.get(curr)));		// deep copy
				prev.get(curr).add(i);
			}
			result.addAll(prev);
		}
		
		return result;
	}
	
	public static ArrayList<ArrayList<Integer>> getSubsets2(ArrayList<Integer> arr) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		int total = 1 << arr.size();	// 2^n
		
		for (int i = 0; i < total; i++) {
			ArrayList<Integer> res = new ArrayList<Integer>();
			int index = 0;
			for (int curr = i; curr > 0; curr >>= 1) {
				if ((curr & 1) > 0) {
					res.add(arr.get(index));
				}
				index++;
			}
			result.add(res);
		}
		
		return result;
	}
	
	public static ArrayList<ArrayList<Integer>> getSubsets3(ArrayList<Integer> arr, int index) {
		// recursive
		ArrayList<ArrayList<Integer>> allSubsets;
		if (arr.size() == index) {
			allSubsets = new ArrayList<ArrayList<Integer>>();
			allSubsets.add(new ArrayList<Integer>());
		} else {
			allSubsets = getSubsets3(arr, index + 1);
			int item = arr.get(index);
			ArrayList<ArrayList<Integer>> moresubsets = new ArrayList<ArrayList<Integer>>();
			for (ArrayList<Integer> subset : allSubsets) {
				ArrayList<Integer> newsubset = new ArrayList<Integer>();
				newsubset.addAll(subset);
				newsubset.add(item);
				moresubsets.add(newsubset);
			}
			allSubsets.addAll(moresubsets);
		}
		
		return allSubsets;
	}
	
	/////////
	public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 3; i++) {
                list.add(i);
        }
        ArrayList<ArrayList<Integer>> subsets = getSubsets1(list);
        System.out.println(subsets.toString());
        
        ArrayList<ArrayList<Integer>> subsets2 = getSubsets2(list);
        System.out.println(subsets2.toString());   
        
        ArrayList<ArrayList<Integer>> subsets3 = getSubsets3(list, 0);
        System.out.println(subsets3.toString());  
	}
}
