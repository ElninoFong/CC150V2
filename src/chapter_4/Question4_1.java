package chapter_4;

import CtCILibrary.TreeNode;

/*
 * 4.1 
 * Implement a function to check if a binary tree is balanced. For the purposes of this question, 
 * a balanced tree is defined to be a tree such that the heights of the two subtrees of any node never differ by more than one.
 */
public class Question4_1 {
	// TC:O(n), SC:O(H)
	public static boolean isBalanced(TreeNode root) {
		return getHeight(root) != -1;
	}
	
	// return -1 when not balanced in any subtree
	static int getHeight(TreeNode node) {
		if (node == null) return 0;
		
		// check if left subtree is balanced
		int left = getHeight(node.left);
		if (left == -1) return -1;
		
		// check if right subtree is balanced
		int right = getHeight(node.right);
		if (right == -1) return -1;
		
		// check if node is balanced
		if (Math.abs(left - right) > 1) return -1;
		return Math.max(left, right) + 1;
	}

	
	public static void main(String[] args) {
        // Create balanced tree
        int[] array = {0, 1, 2, 3, 5, 6, 7, 8, 9, 10};
        TreeNode root = TreeNode.createMinimalBST(array);

        
        System.out.println("Is balanced? " + isBalanced(root));
        
        root.insertInOrder(-1); // Add 4 to make it unbalanced
        root.insertInOrder(-2);

        System.out.println("Is balanced? " + isBalanced(root));
	}
}
