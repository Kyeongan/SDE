package edu.uh.cs.sde.bst;

public class TreeNode {

	int value;
	public TreeNode left;
	public TreeNode right;

	TreeNode(int x) {
		value = x;
	}

	public void printValue() {
		System.out.println("Value is " + this.value);
	}

}
