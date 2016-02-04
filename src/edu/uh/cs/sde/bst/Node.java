package edu.uh.cs.sde.bst;

public class Node {
	int data;
	Node left;
	Node right;
	
	static Node lca(Node root, int v1, int v2) {
		if (root != null ) {
			if (root.data > v1 && root.data > v2 ) 
				root = root.left;
			else if (root.data < v1 && root.data < v2 )
				root = root.right;
			else 
				return root;			
		}		
		return null;
	}
}
