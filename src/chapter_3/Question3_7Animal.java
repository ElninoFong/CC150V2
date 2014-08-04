package chapter_3;

public abstract class Question3_7Animal {
	static int lastArrivalNum;
	
	String name;
	int arrivalNum;
	
	public Question3_7Animal(String n) {
		name = n;
		arrivalNum = ++lastArrivalNum;
	}
	
	public int getArrivalNum() {
		return arrivalNum;
	}
	
	public String name() {
		return name;
	}
	
	public boolean isOlderThan(Question3_7Animal animal) {
		return getArrivalNum() < animal.getArrivalNum();
	}
}
