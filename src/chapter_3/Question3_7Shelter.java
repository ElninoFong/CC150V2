package chapter_3;

import java.util.LinkedList;

public class Question3_7Shelter {
	LinkedList<Question3_7Dog> dogs;
	LinkedList<Question3_7Cat> cats;
	
	public Question3_7Shelter() {
		dogs = new LinkedList<Question3_7Dog>();
		cats = new LinkedList<Question3_7Cat>();
	}
	
	public void enqueue(Question3_7Animal animal) {
		if (animal instanceof Question3_7Dog) {
			dogs.add((Question3_7Dog) animal);
		} else if (animal instanceof Question3_7Cat) {
			cats.add((Question3_7Cat) animal);
		}
	}
	
	public Question3_7Animal dequeueAny() {
		if (dogs.isEmpty()) return dequeueCat();
		if (cats.isEmpty()) return dequeueDog();
		Question3_7Dog dog = dogs.peek();
		Question3_7Cat cat = cats.peek();
		if (dog.isOlderThan(cat)) return dequeueDog();
		return dequeueCat();
	}
	
	Question3_7Cat dequeueCat() {
		if (cats.isEmpty()) return null;
		return cats.poll();
	}
	
	Question3_7Dog dequeueDog() {
		if (dogs.isEmpty()) return null;
		return dogs.poll();
	}
	
	public int size() {
		return dogs.size() + cats.size();
	}
}
