package chapter_3;

/*
 * 3.7 An animal shelter holds only dogs and cats, and operates on a strictly "first in, 
 * first out" basis. People must adopt either the "oldest" (based on arrival time) of all
 * animals at the shelter, or they can select whether they would prefer a dog or a cat 
 * (and will receive the oldest animal of that type). They cannot select which specific
 * animal they would like. Create the data structures to maintain this system and 
 * implement operations such as enqueue, dequeueAny, dequeueDog and dequeueCat. 
 * You may use the built-in LinkedList data structure.
 */
public class Question3_7 {

	public static void main(String[] args) {
		Question3_7Shelter animals = new Question3_7Shelter();
        animals.enqueue(new Question3_7Cat("Callie"));
        animals.enqueue(new Question3_7Cat("Kiki"));
        animals.enqueue(new Question3_7Dog("Fido"));
        animals.enqueue(new Question3_7Dog("Dora"));
        animals.enqueue(new Question3_7Cat("Kari"));
        animals.enqueue(new Question3_7Dog("Dexter"));
        animals.enqueue(new Question3_7Dog("Dobo"));
        animals.enqueue(new Question3_7Cat("Copa"));
        
        System.out.println(animals.dequeueAny().name());        
        System.out.println(animals.dequeueAny().name());        
        System.out.println(animals.dequeueAny().name());        
        
        animals.enqueue(new Question3_7Dog("Dapa"));
        animals.enqueue(new Question3_7Cat("Kilo"));
        
        while (animals.size() != 0) {
            System.out.println(animals.dequeueAny().name());        
        }
	}
}
