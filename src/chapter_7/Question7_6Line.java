package chapter_7;

public class Question7_6Line {
	public static double epsilon = 0.00001;
	public double slope, intercept;
	private boolean isInfiniteSlope = false;
	
	public Question7_6Line(Question7_6GraphPoint p, Question7_6GraphPoint q) {
		if (Math.abs(p.x - q.x) < epsilon) {
			isInfiniteSlope = true;
			intercept = p.x;		// x intercept
		} else {
			slope = (p.y - q.y) / (p.x - q.x);
			intercept = p.y - slope * p.x;
		}
	}
	
	public static double floorToNearestEpsilon(double d) {
		int r = (int) (d / epsilon);
		return ((double) r) * epsilon;
	}
	
	public boolean isEquivalent(double a, double b) {
		return Math.abs(a - b) < epsilon;
	}
	
	public boolean isEquivalent(Question7_6Line l) {
		return (isEquivalent(slope, l.slope) && 
				isEquivalent(intercept, l.intercept) &&
				isInfiniteSlope == l.isInfiniteSlope);
	}
	
	 public void print() {
         System.out.println("y = " + slope + "x + " + intercept);
	 }
}
