package edu.uh.cs.sde;

public class Node {
	
	int value;
	Node left;
	Node right;
	
	Node(){
		System.out.println("Node Class");
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

}
