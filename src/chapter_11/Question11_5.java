package chapter_11;

/*
 * 11.5
 * Given a sorted array of strings which is interspersed with empty strings, write a method to find the location of a given string.
 * EXAMPLE
 * Input: find "ball" in {"at", "", "", "", "ball", "", "", "car", "", "", "dad", "", ""}
 * Output: 4
 */
public class Question11_5 {
	public static int searchIterative(String[] strings, String str) {
		if (strings == null || strings.length == 0) return -1;
		if (str == null || str.isEmpty()) return -1;
		return searchIterative(strings, str, 0, strings.length);
	}
	
	static int searchIterative(String[] strings, String str, int first, int last) {
		while (first < last) {
			int mid = (first + last) / 2;
			
			// find left and right that not empty
			if (strings[mid].isEmpty()) {
				int left = mid - 1;
				int right = mid + 1;
				
				while (true) {
					if (left < first && right > last) return -1;
					if (left >= first && !strings[left].isEmpty()) {
						mid = left;
						break;
					}
					if (right <= last && !strings[right].isEmpty()) {
						mid = right;
						break;
					}
					left--;
					right++;
				}
			}
			
			if (strings[mid].equals(str)) return mid;
			if (strings[mid].compareTo(str) < 0) {
				// search right
				first = mid + 1;
			} else {
				last = mid - 1;
			}
		}
		return -1;
	}
	
	
	///////
	public static void main(String[] args) {
        String[] stringList = {"apple", "", "", "banana", "", "", "", "carrot", "duck", "", "", "eel", "", "flower"};
        System.out.println(searchIterative(stringList, "ac"));
        
                //for (String s : stringList) {
                //      String cloned = new String(s);
        //      System.out.println("<" + cloned + "> " + " appears at location " + search(stringList, cloned));
                //}
        }
}
