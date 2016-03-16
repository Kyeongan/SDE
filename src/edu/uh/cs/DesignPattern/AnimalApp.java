package edu.uh.cs.DesignPattern;

public class AnimalApp {

	public static void main(String[] args) {
		
		Dog fido = new Dog();
		fido.setName("Fido");
		System.out.println(fido.getName());
		
		fido.digHole();
		
		fido.setHeight(20);
		System.out.println(fido.getHeight());

	}

}
