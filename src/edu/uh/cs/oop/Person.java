package edu.uh.cs.oop;

enum Gender {
    MALE, FEMALE
}

public class Person {
	private String name;
	private int height;
	private int weight;
	private int age;
	private Gender gender;
	
	public Person(String name, int height, int weight, int age, Gender gender) {
		super();
		this.name = name;
		this.height = height;
		this.weight = weight;
		this.age = age;
		this.gender = gender;
	}

	public String toString() {
		return "Person [" + name + ", height=" + height + "cm, weight=" + weight + "kg, age=" + age + ", gender="
				+ gender + "]";
	}



	public static void main(String args[]) {
		Person karl = new Person("Karl", 175, 70, 35, Gender.MALE);
		
		System.out.println(karl);
		
	}


	
}
