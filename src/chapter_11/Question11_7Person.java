package chapter_11;

public class Question11_7Person {
	public int height, weight;
	public Question11_7Person(int ht, int wt) {
		height = ht;
		weight = wt;
	}
	
	public boolean canBeAbove(Question11_7Person p) {
		if (p == null) return true;
		return height < p.height && weight < p.weight;
	}
	
	public String toString() {
        return "(" + height + ", " + weight + ")";
	}
}
