package chapter_4;

import java.util.ArrayList;
import java.util.LinkedList;

import CtCILibrary.TreeNode;

/*
 * 4.7 
 * Design an algorithm and write code to find the first common ancestor of two nodes in a binary tree. 
 * Avoid storing additional nodes in a data structure. NOTE: This is not necessarily a binary search tree.
 */
public class Question4_7 {
	// TC:O(n), SC:O(H)
	public static TreeNode LCA(TreeNode root, TreeNode n1, TreeNode n2) {
		if (root == null) return null;
		if (n1 == null) return n2;
		if (n2 == null) return n1;
		if (n1 == n2) return n1;	// err: miss this
		
		Question4_7Result res = LCAHelper(root, n1, n2);
		if (res.isFound) return res.node;
		return null;
	}
	
	static Question4_7Result LCAHelper(TreeNode node, TreeNode n1, TreeNode n2) {
		if (node == null) return new Question4_7Result(null, false);
		
		Question4_7Result leftRes = LCAHelper(node.left, n1, n2);
		if (leftRes.isFound) return leftRes;
		
		Question4_7Result rightRes = LCAHelper(node.right, n1, n2);
		if (rightRes.isFound) return rightRes;
		
		if (leftRes.node == null && rightRes.node == null) {
			if (node == n1 || node == n2) return new Question4_7Result(node, false);
			return new Question4_7Result(null, false);
		} else if (leftRes.node == null || rightRes.node == null) {
			if (node == n1 || node == n2) return new Question4_7Result(node, true);
			if (leftRes.node == null) return rightRes;
			return leftRes;
		} else {
			return new Question4_7Result(node, true);
		}
	}
	
	
	public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        TreeNode root = TreeNode.createMinimalBST(array);
        ArrayList<LinkedList<TreeNode>> list = Question4_4.createBFS(root);
        Question4_4.printResult(list);
        
        TreeNode n3 = root.find(7);
        TreeNode n7 = root.find(10);
        TreeNode ancestor = LCA(root, n3, n7);
        System.out.println(ancestor.data);
	}
}
