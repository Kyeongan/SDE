package edu.uh.cs.DesignPattern;

public class AnimalApp {

	public static void main(String[] args) {
		
		Dog fido = new Dog();
		fido.setName("Fido");
		System.out.println(fido.getName());

		fido.digHole();

		fido.setHeight(20);
		System.out.println(fido.getHeight());

		Animal doggy = new Dog();
		Animal kitty = new Cat();

		System.out.println("Dog says " + doggy.getSound());
		System.out.println("Cat says " + kitty.getSound());

		((Dog) doggy).digHole();

		Animal[] animals = new Animal[4];
		animals[0] = doggy;
		animals[1] = kitty;

		System.out.println("Animal says " + animals[0].getSound());
		System.out.println("Animal says " + animals[1].getSound());

		//Cannot make a static reference to the non-static method speakAnimal(Animal) from the type AnimalApp
		speakAnimal(doggy);

		Animal sparky = new Dog();
		Animal twitty = new Bird();
		System.out.println("Dog " + sparky.tryToFly());
		System.out.println("Bird " + twitty.tryToFly());

	}

	public static void speakAnimal(Animal rand) {
		System.out.println(rand.getSound());
	}
}
