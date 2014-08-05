package chapter_4;

import CtCILibrary.TreeNode;

/*
 * 4.3 
 * Given a sorted (increasing order) array with unique integer elements, write an algorithm to create a binary search tree with minimal height.
 */
public class Question4_3 {
	// TC:O(n), SC:O(H)
	public static TreeNode createMinimalBST(int[] arr) {
		if (arr == null || arr.length == 0) return null;
		return createMinimalBST(arr, 0, arr.length - 1);
	}
	
	static TreeNode createMinimalBST(int[] arr, int start, int end) {
		if (start > end) return null;
		int mid = (start + end) / 2;
		
		TreeNode left = createMinimalBST(arr, start, mid - 1);
		TreeNode node = new TreeNode(arr[mid]);
		TreeNode right = createMinimalBST(arr, mid + 1, end);
		node.left = left;
		node.right = right;
		
		return node;
	}
	
	
	
	public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        
        // We needed this code for other files, so check out the code in the library
        TreeNode root = TreeNode.createMinimalBST(array);
        System.out.println("Root? " + root.data);
        System.out.println("Created BST? " + root.isBST());
        System.out.println("Height: " + root.height());
        
        TreeNode node = createMinimalBST(array);
        System.out.println("Root? " + node.data);
        System.out.println("Created BST? " + node.isBST());
        System.out.println("Height: " + node.height());
	}
}
