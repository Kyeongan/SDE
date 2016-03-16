package edu.uh.cs.DesignPattern;

public interface Flys {
	String fly();
}

class ItFlys implements Flys {
	
	public String fly() {
		return "Fly High";
	}
}
class CantFlys implements Flys {
	
	public String fly() {
		return "Can't Fly";
	}
}
