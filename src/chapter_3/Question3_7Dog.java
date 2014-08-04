package chapter_3;

public class Question3_7Dog extends Question3_7Animal {
	public Question3_7Dog(String name) {
		super(name);
	}
	
	public String name() {
		return "Dog: " + name;
	}
}
