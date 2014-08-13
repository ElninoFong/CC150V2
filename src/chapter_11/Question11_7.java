package chapter_11;

import java.util.*;

/*
 * 11.7
 * A circus is designing a tower routine consisting of people standing atop one another's shoulders. 
 * For practical and aesthetic reasons, each Question11_7Person must be both shorter and lighter than the Question11_7Person below him or her.
 * Given the heights and weights of each Question11_7Person in the circus, write a method to compute the largest possible number of people in such a tower.
 * EXAMPLE
 * Input(ht, wt): (65, 100) (70, 150) (56, 90) (75, 190) (60, 95) (68, 110)
 * Output: The longest tower is length 6 and includes from top to bottom:
 * 			(56, 90) (60, 95) (65, 100) (68, 110) (70, 150) (75, 190)
 */
public class Question11_7 {
	// DP
	public static ArrayList<Question11_7Person> computeTower(ArrayList<Question11_7Person> Question11_7Persons, 
																Question11_7Person bottom, 
																HashMap<Question11_7Person, ArrayList<Question11_7Person>> hm) {
		if (bottom != null && hm.containsKey(bottom)) return hm.get(bottom);
		
		ArrayList<Question11_7Person> res = null;
		int maxHeight = 0;
		
		for (int i = 0; i < Question11_7Persons.size(); i++) {
			Question11_7Person p = Question11_7Persons.get(i);
			if (p.canBeAbove(bottom)) {
				ArrayList<Question11_7Person> above = computeTower(Question11_7Persons, p, hm);
				if (maxHeight < above.size()) {
					maxHeight = above.size();
					res = above;
				}
			}
		}
		
		if (res == null) {
			res = new ArrayList<Question11_7Person>();
		}
		
		if (bottom != null) {
			res.add(bottom);
		}
		
		hm.put(bottom, new ArrayList<Question11_7Person>(res));		// err: hm.put(bottom, res), not store a copy
		
		return res;		
	}
	
	
	
	/////////////
	public static ArrayList<Question11_7Person> initialize() {
        ArrayList<Question11_7Person> items = new ArrayList<Question11_7Person>();
        
        Question11_7Person item = new Question11_7Person(65, 60);
        items.add(item);
        
        item = new Question11_7Person(70, 150);
        items.add(item);
        
        item = new Question11_7Person(56, 90);
        items.add(item);
        
        item = new Question11_7Person(75, 190);
        items.add(item);
        
        item = new Question11_7Person(60, 95);
        items.add(item);
        
        item = new Question11_7Person(68, 110);
        items.add(item);
        
        item = new Question11_7Person(35, 50);
        items.add(item);
        
        item = new Question11_7Person(40, 60);
        items.add(item);
        
        item = new Question11_7Person(45, 63);
        items.add(item);
        
        return items;
	}
	
	public static void printList(ArrayList<Question11_7Person> list) {
	        for (Question11_7Person item : list) {
	                System.out.println(item.toString() + " ");
	        }
	}
	
	public static void main(String[] args) {
	        ArrayList<Question11_7Person> items = initialize();
	        HashMap<Question11_7Person, ArrayList<Question11_7Person>> hm = 
	        		new HashMap<Question11_7Person, ArrayList<Question11_7Person>>();
	        ArrayList<Question11_7Person> solution = computeTower(items, null, hm);
	        printList(solution);
	}
}
