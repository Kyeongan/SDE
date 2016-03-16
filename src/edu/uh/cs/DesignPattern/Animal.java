package edu.uh.cs.DesignPattern;

public class Animal {
	private String name = "Animal";
	private int height = 10;
	private String sound = "";

	public void setName(String newName) {
		this.name = newName;
	}

	public String getName() {
		return this.name;
	}

	public void setHeight(int newHeight) {
		if (newHeight > 0)
			this.height = newHeight;
		else
			System.out.println("Height must be bigger than zero");
	}

	public int getHeight() {
		return this.height;
	}

	public void setSound(String newSound) {
		this.sound = newSound;
	}

	public String getSound() {
		return this.sound;
	}
}
