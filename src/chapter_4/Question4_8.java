package chapter_4;

import CtCILibrary.*;

/*
 * 4.8 
 * You have two very large binary trees: T1, with millions of nodes, and T2, with hundreds of nodes. 
 * Create an algorithm to decide if T2 is a subtree of T1.
 * A tree T2 is a subtree of T1 if there exists a node n in T1 such that the subtree of n is identical to T2. 
 * That is, if you cut off the tree at node n, the two trees would be identical.
 */
public class Question4_8 {
	// 1. In-order traversal(with NULL) + Pre-order traversal(with NULL) + Suffix tree
	//	  It is in linear time, but takes too much memory
	// 2. Brute force
	//    TC is higher, but takes less memory
	
	// 2
	public static boolean isSubtree(TreeNode T1, TreeNode T2) {
		if (T1 == null && T2 == null) return true;
		if (T1 == null) return false;
		if (T2 == null) return true;
		
		return findStartNode(T1, T2);
	}
	
	static boolean findStartNode(TreeNode T1, TreeNode T2) {
		if (T1 == null) return false;
		
		if (T1.data == T2.data) {
			if (isSubtreeHelper(T1, T2)) return true;
		}
		
		return findStartNode(T1.left, T2) || findStartNode(T1.right, T2); 
	}
	
	static boolean isSubtreeHelper(TreeNode T1, TreeNode T2) {
		if (T1 == null && T2 == null) return true;
		if (T1 == null || T2 == null) return false;
		if (T1.data != T2.data) return false;
		
		return isSubtreeHelper(T1.left, T2.left) && isSubtreeHelper(T1.right, T2.right);
	}
	
	
	
	public static void main(String[] args) {
        // t2 is a subtree of t1
        int[] array1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
        int[] array2 = {2, 4, 5, 8, 9, 10, 11};
        
        TreeNode t1 = AssortedMethods.createTreeFromArray(array1);
        TreeNode t2 = AssortedMethods.createTreeFromArray(array2);

        if (isSubtree(t1, t2))
            System.out.println("t2 is a subtree of t1");
        else
            System.out.println("t2 is not a subtree of t1");

        // t4 is not a subtree of t3
        int[] array3 = {1, 2, 3};
        TreeNode t3 = AssortedMethods.createTreeFromArray(array1);
        TreeNode t4 = AssortedMethods.createTreeFromArray(array3);

        if (isSubtree(t3, t4))
            System.out.println("t4 is a subtree of t3");
        else
            System.out.println("t4 is not a subtree of t3");
	}
}
