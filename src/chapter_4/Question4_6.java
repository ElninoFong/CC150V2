package chapter_4;

import CtCILibrary.TreeNode;

/*
 * 4.6 
 * Write an algorithm to find the 'next' node (i.e., in-order successor) of a given node in a binary seach tree. 
 * You may assume that each node has a link to its parent.
 */
public class Question4_6 {
	// better code: http://goo.gl/e81fMB
	public static TreeNode findNext(TreeNode node) {
		if (node == null) return null;
		
		// if it has right subtree, return the leftmost node of right subtree
		if (node.right != null) {
			node = node.right;
			while (node != null && node.left != null) {
				node = node.left;
			}
			return node;
		}
		
		// if it is left child, return it is parent
		if (node == node.parent.left) return node.parent;
		
		// right child, find the first left child parent, then return its parent
		while (node.parent != null && node != node.parent.left) {
			node = node.parent;
		}
		return node.parent;
	}
	
	
	public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        TreeNode root = TreeNode.createMinimalBST(array);
        for (int i = 0; i < array.length; i++) {
            TreeNode node = root.find(array[i]);
            TreeNode next = findNext(node);
            if (next != null) {
                    System.out.println(node.data + "->" + next.data);
            } else {
                    System.out.println(node.data + "->" + null);
            }
        }
	}
}
