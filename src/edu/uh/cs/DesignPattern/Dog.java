package edu.uh.cs.DesignPattern;

public class Dog extends Animal {

	public void digHole() {
		System.out.println("Dug a hole");
	}

	Dog() {
		super();

		setSound("Bark");
		
		flyingType = "Can't fly";
	}
}
