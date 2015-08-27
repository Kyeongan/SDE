package edu.uh.cs.sde.bst;

import java.util.*;

public class BinarySearchTree {

	public BinarySearchTree() {
		// TODO Auto-generated constructor stub
	}

	public int minDepth(TreeNode root) {
		if (root == null)
			return 0;
		else if (root.left == null)
			return minDepth(root.left) + 1;
		else if (root.right == null)
			return minDepth(root.right) + 1;

		return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
	}

	public int maxDepth(TreeNode node) {
		if (node == null)
			return 0;
		else {
			int l_depth = maxDepth(node.left);
			int r_depth = maxDepth(node.right);

			return (Math.max(l_depth, r_depth) + 1);
		}
	}
	
	public int treeHeight(TreeNode node) {
		if (node == null)
			return 0;
		return Math.max(treeHeight(node.left), treeHeight(node.right)) + 1;
	}

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

	public boolean isValidBST(TreeNode node, int min, int max) {
		if (node == null)
			return false;
		if (node.value <= min || node.value >= max)
			return false;
		else
			return isValidBST(node.left, min, node.value) && isValidBST(node.right, node.value, max);
	}
	
	public TreeNode findLowestCommonAncestor(TreeNode root, int value1, int value2) {
		while (root != null) {
			int value = root.value;

			if (value > value1 && value > value2) {
				root = root.left;
			} else if (value < value1 && value < value2) {
				root = root.right;
			} else {
				return root;
			}
		}
		return null;
	}

	public TreeNode findLowestCommonAncestor(TreeNode root, TreeNode child1, TreeNode child2) {
		if(root==null || child1==null || child2== null)
			return null;
		
		return findLowestCommonAncestor(root, child1.value, child2.value);
	}
	
	public ArrayList<Integer> preorderTraversalStack(TreeNode root) {

		ArrayList<Integer> returnList = new ArrayList<Integer>();
		if (root == null)
			return returnList;

		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);

		while (!stack.empty()) {
			TreeNode n = stack.pop();
			returnList.add(n.value);

			if (n.right != null) {
				stack.push(n.right);
			}
			if (n.left != null) {
				stack.push(n.left);
			}
		}
		return returnList;
	}

	void preorderTraversal(TreeNode root) {
		if (root == null)
			return;
		root.printValue();
		preorderTraversal(root.left);
		preorderTraversal(root.right);
	}

	void inorderTraversal(TreeNode root) {
		if (root == null)
			return;
		inorderTraversal(root.left);
		root.printValue();
		inorderTraversal(root.right);
	}

	void postorderTraversal(TreeNode root) {
		if (root == null)
			return;
		postorderTraversal(root.left);
		postorderTraversal(root.right);
		root.printValue();
	}
}
