package edu.uh.cs.sde.bst;

public class MaxDepth {

	public MaxDepth() {
		// TODO Auto-generated constructor stub
	}
	
	public int FindMaxDepth(TreeNode node) {
		if (node == null)
			return 0;
		else {
			int l_depth = FindMaxDepth(node.left);
			int r_depth = FindMaxDepth(node.right);
			
			return(Math.max(l_depth, r_depth) + 1);
		}
	}

}
