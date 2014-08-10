package chapter_7;

/*
 * 7.3
 * Given two lines on a Cartesian plane, determine whether the two lines would intersect.
 */
public class Question7_3Line {
	// 1. OOD, 2. use double, 3. use epsilon to compare double
	static double epsilon = 0.000001; 
	double slope;
	double yIntercept;
	
	public Question7_3Line(double s, double y) {
		slope = s;
		yIntercept = y;
	}
	
	public boolean isIntersect(Question7_3Line line) {
		return Math.abs(slope - line.slope) > epsilon ||
			   Math.abs(yIntercept - line.yIntercept) > epsilon;
	}
	
	public void print() {
        System.out.print("y = " + slope + "x + " + yIntercept);
	}
	
	
	public static int randomInt(int n) {
        return (int) (Math.random() * n);
	}
	
	public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
        	Question7_3Line line1 = new Question7_3Line(randomInt(5), randomInt(1));
        	Question7_3Line line2 = new Question7_3Line(randomInt(5), randomInt(2));
            line1.print();
            System.out.print(", ");
            line2.print();
            if (line1.isIntersect(line2)) {
                System.out.println("  YES");
            } else {
                System.out.println("  NO");
            }
        }
	}
}
