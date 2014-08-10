package chapter_7;

import java.util.*;

/*
 * 7.6
 * Given a two-dimensional graph with points on it, find a line which passes the most number of points.
 */
public class Question7_6 {
	public static Question7_6Line findBestLine(Question7_6GraphPoint[] points) {
		Question7_6Line bestLine = null;
		int bestCount = 0;
		HashMap<Double, ArrayList<Question7_6Line>> linesBySlope = new HashMap<Double, ArrayList<Question7_6Line>>();
		
		for (int i = 0; i < points.length; i++) {
			for (int j = i + 1; j < points.length; j++) {
				Question7_6Line line = new Question7_6Line(points[i], points[j]);
				insertLine(linesBySlope, line);
				int count = countEquivlaentLines(linesBySlope, line);
				if (count > bestCount) {
					bestCount = count;
					bestLine = line;
				}
			}
		}
		
		return bestLine;
	}
	
	static void insertLine(HashMap<Double, ArrayList<Question7_6Line>> linesBySlope, Question7_6Line line) {
		double slope = Question7_6Line.floorToNearestEpsilon(line.slope);
		ArrayList<Question7_6Line> lines;
		if (linesBySlope.containsKey(slope)) {
			lines = linesBySlope.get(slope);
		} else {
			lines = new ArrayList<Question7_6Line>();
			linesBySlope.put(slope, lines);
		}
		lines.add(line);
	}
	
	static int countEquivlaentLines(HashMap<Double, ArrayList<Question7_6Line>> linesBySlope, Question7_6Line line) {
		double slope = Question7_6Line.floorToNearestEpsilon(line.slope);
		double eps = Question7_6Line.epsilon;
		return countEquivlaentLines(linesBySlope.get(slope - eps), line) +		// HashMap.get() will return null if no such key
			   countEquivlaentLines(linesBySlope.get(slope), line) +
			   countEquivlaentLines(linesBySlope.get(slope + eps), line);
	}
	
	static int countEquivlaentLines(ArrayList<Question7_6Line> lines, Question7_6Line line) {
		if (lines == null) return 0;
		int count = 0;
		for (Question7_6Line l : lines) {
			if (l.isEquivalent(line)) {
				count++;
			}
		}
		return count;
	}
	
	
	
	//////////////////
	public static void main(String[] args) {
        int graph_size = 100;
        int n_points = 500;
        Question7_6GraphPoint[] points = new Question7_6GraphPoint[n_points];
        for (int i = 0; i < n_points; i++) {
            double x = ((double)(Math.random() * graph_size));
            double y = ((double)(Math.random() * graph_size));
            points[i] = new Question7_6GraphPoint(x, y);
        }
        Question7_6Line line = findBestLine(points);
        line.print();
	}
}
