package chapter_3;

public class Question3_7Cat extends Question3_7Animal {
	public Question3_7Cat(String name) {
		super(name);
	}
	
	public String name() {
		return "Cat: " + name;
	}
}
