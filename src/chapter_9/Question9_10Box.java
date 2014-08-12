package chapter_9;

public class Question9_10Box {
	public int width, height, depth;
	public Question9_10Box(int w, int h, int d) {
		width = w;
		height = h;
		depth = d;
	}
	
	public boolean canBeAbove(Question9_10Box b) {
		if (b == null) return true;
		if (b.width > width && b.height > height && b.depth > depth) return true;
		return false;
	}
	
	public String toString() {
        return "Box(" + width + "," + height + "," + depth + ")";
	}
}
