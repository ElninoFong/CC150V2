package chapter_4;

import java.util.ArrayList;

import CtCILibrary.TreeNode;

/*
 * 4.5 
 * Implement a function to check if a binary tree is a binary search tree.
 */
public class Question4_5 {
	// 1. all left subtree nodes <= node < all right subtree nodes (MIN MAX solution)
	// 2. use in-order traverse (can not handle node <= all right subtree nodes)
	
	// 1
	// TC: O(n), SC: O(log(n))
	public static boolean isBST1(TreeNode root) {
		return isBST1(root, Integer.MIN_VALUE, Integer.MAX_VALUE);	// err: MAX_VALUE and MIN_VALUE exchanged
	}

	static boolean isBST1(TreeNode node, int min, int max) {
		if (node == null) return true;
		if (node.data > max || node.data <= min) return false;
		return isBST1(node.left, min, node.data) && isBST1(node.right, node.data, max);
	}


	//2
	// TC: O(n), SC:O (n)
	public static boolean isBST2(TreeNode node) {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		isBST2(node, arr);
		if (arr.size() < 2) return true;
		for (int i = 1; i < arr.size(); i++) {
			if (arr.get(i) < arr.get(i - 1))
				return false;
		}
		return true;
	}

	static void isBST2(TreeNode node, ArrayList<Integer> arr) {
		if (node == null) return;
		isBST2(node.left, arr);
		arr.add(node.data);
		isBST2(node.right, arr);
	}

	// 2
	// not use additional ArrayList, only use a static int
	// TC: O(n), SC: O(log(n))
	static int last_printed = Integer.MIN_VALUE;
	public static boolean isBST3(TreeNode node) {
		if (node == null) return true;
		if (!isBST3(node.left)) return false;
		if (node.data < last_printed) return false;
		last_printed = node.data;
		if (!isBST3(node.right)) return false;
		return true;
	}
	
	
	public static void main(String[] args) {
        int[] array = {3, 5, 7, 10, 13, 15, 20};
        TreeNode node = TreeNode.createMinimalBST(array);
//        node.left.right.data = 3;
        System.out.println(isBST1(node));
        System.out.println(isBST2(node));
        System.out.println(isBST3(node));
	}
}
