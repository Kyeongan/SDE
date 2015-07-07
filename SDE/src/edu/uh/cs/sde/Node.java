package edu.uh.cs.sde;

public class Node {
	
	int value;
	Node left;
	Node right;
	
	Node(){
		System.out.println("Node Class - Let's enjoy");
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}

}
