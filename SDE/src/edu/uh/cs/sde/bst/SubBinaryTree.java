package edu.uh.cs.sde.bst;

public class SubBinaryTree {

	public int isSubTree(TreeNode root1, TreeNode root2) {

		if (root1 == null)
			return -1;
		if (root2 == null)
			return 1;

		if (equals(root1, root2) || equals(root1.left, root2) || equals(root1.right, root2))
			return 1;
		else
			return -1;
	}

	public boolean equals(TreeNode root1, TreeNode root2) {
		if (root1 == root2)
			return true;
		if (root1 == null || root2 == null)
			return false;
		if (root1.value != root2.value)
			return false;
		return equals(root1.left, root2.left) && equals(root1.right, root2.right);
	}
}