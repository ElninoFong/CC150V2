package chapter_4;

import CtCILibrary.TreeNode;
import java.util.*;

/*
 * 4.9 
 * You are given a binary tree in which each node contains a value. Design an algorithm to print all paths which sum to a given value. 
 * The path does not need to start or end at the root or a leaf.
 */
public class Question4_9 {
	// TC:O(n*H), SC:O(H)
	public static void findSum(TreeNode root, int target) {
		ArrayList<Integer> path = new ArrayList<Integer>();
		findSum(root, path, target);
	}
	
	static void findSum(TreeNode node, ArrayList<Integer> path, int target) {
		if (node == null) return;
		
		path.add(node.data);
		int sum = 0;
		for (int i = path.size() - 1; i >= 0; i--) {	// err3: use i++
			sum += path.get(i);
			if (sum == target) {
				printPath(path, i);
			}
		}
		
		if (node.left != null) {				// err2: miss this, if null will remove the prev element
			findSum(node.left, path, target);
			path.remove(path.size() - 1);		// err1: miss remove node.left
		}
		
		if (node.right != null) {
			findSum(node.right, path, target);
			path.remove(path.size() - 1);
		}
	}
	
	static void printPath(ArrayList<Integer> path, int i) {
		for (int t = i; t < path.size(); t++) {
			System.out.print(path.get(t) + " ");
		}
		System.out.println();
	}
	
	
	
	public static void main(String [] args){
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(8);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(6);
        findSum(root, 8);
	}
}
