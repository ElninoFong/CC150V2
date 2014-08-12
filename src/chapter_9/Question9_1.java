package chapter_9;

/*
 * 9.1
 * A child is running up a staircase with n steps, and can hop either 1 step, 2 steps, or 3 steps at a time. 
 * Implement a method to count how many possible ways the child can run up the stairs.
 */
public class Question9_1 {
	public static int countWaysIterative(int n) {
		if (n < 0) return 0;
		if (n == 0) return 1;
		
		int prev2 = 0;
		int prev1 = 0;
		int curr = 1;
		
		while (n-- > 0) {
			int tmp = curr;
			curr += prev1 + prev2;
			prev2 = prev1;
			prev1 = tmp;
		}
		
		return curr;
	}
	
	public static int countWaysRecursive(int n) {
		if (n < 0) return 0;
		if (n == 0) return 1;
		return countWaysRecursive(n - 1) + countWaysRecursive(n - 2) + countWaysRecursive(n - 3);
	}
	
	public static int countWaysDP(int n, int[] count) {
		if (n < 0) return 0;
		if (n == 0) return 1;
		if (count[n] > 0) return count[n];
		count[n] = countWaysDP(n - 1, count) + countWaysDP(n - 2, count) + countWaysDP(n - 3, count);
		return count[n];
	}
	
	
	////////////
	public static void main(String[] args) {
        for (int i = 0; i < 30; i++) {
            long t1 = System.currentTimeMillis();
            int[] map = new int[30 + 1];
            for (int j = 0; j < map.length; j++) {
                map[j] = -1;
            }
            int c1 = countWaysDP(i, map);
            long t2 = System.currentTimeMillis();
            long d1 = t2 - t1;
            
            long t3 = System.currentTimeMillis();
            int c2 = countWaysRecursive(i);
            long t4 = System.currentTimeMillis();
            long d2 = t4 - t3;                      
            
            long t5 = System.currentTimeMillis();
            int c3 = countWaysIterative(i);
            long t6 = System.currentTimeMillis();
            long d3 = t6 - t5;
            
            System.out.println(i + " " + c1 + " " + c2 + " " + c3 + " " + d1 + " " + d2 + " " + d3);
        }
}
}
