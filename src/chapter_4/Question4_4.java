package chapter_4;

import java.util.*;
import CtCILibrary.*;

/*
 * 4.4 
 * Given a binary tree, design an algorithm which creates a linked list of all the nodes at each depth 
 * (e.g., if you have a tree with depth D, you'll have D linked lists).
 */
public class Question4_4 {
	// TC:O(n), SC:O(n)
	// BFS
	public static ArrayList<LinkedList<TreeNode>> createBFS(TreeNode root) {
		ArrayList<LinkedList<TreeNode>> result = new ArrayList<LinkedList<TreeNode>>();
		if (root == null) return result;
		
		LinkedList<TreeNode> curr = new LinkedList<TreeNode>();
		curr.add(root);
		
		while (!curr.isEmpty()) {
			LinkedList<TreeNode> next = new LinkedList<TreeNode>();
			for (TreeNode node : curr) {
				if (node.left != null) {
					next.add(node.left);
				}
				if (node.right != null) {
					next.add(node.right);
				}
			}
			result.add(new LinkedList<TreeNode>(curr));
			curr = next;
		}
		
		return result;
	}
	
	
	// TC:O(n), SC:O(n)
	// DFS
	public static ArrayList<LinkedList<TreeNode>> createDFS(TreeNode root) {
		ArrayList<LinkedList<TreeNode>> result = new ArrayList<LinkedList<TreeNode>>();
		createDFS(root, result, 0);
		return result;
	}
	
	static void createDFS(TreeNode node, ArrayList<LinkedList<TreeNode>> result, int level) {
		if (node == null) return;
		
		// add node to corresponding level
		LinkedList<TreeNode> res;
		if (result.size() == level) {
			res = new LinkedList<TreeNode>();
			result.add(res);		// err: put this after if-else 
		} else {
			res = result.get(level);
		}
		res.add(node);
		
		createDFS(node.left, result, level + 1);
		createDFS(node.right, result, level + 1);
	}
	
	
	
	/////////////
	public static void printResult(ArrayList<LinkedList<TreeNode>> result){
        int depth = 0;
        for(LinkedList<TreeNode> entry : result) {
            Iterator<TreeNode> i = entry.listIterator();
            System.out.print("Link list at depth " + depth + ":");
            while(i.hasNext()){
                System.out.print(" " + ((TreeNode)i.next()).data);
            }
            System.out.println();
            depth++;
        }
	}


	public static void main(String[] args) {
        int[] nodes_flattened = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        TreeNode root = AssortedMethods.createTreeFromArray(nodes_flattened);
        ArrayList<LinkedList<TreeNode>> list1 = createBFS(root);
        ArrayList<LinkedList<TreeNode>> list2 = createDFS(root);
        printResult(list1);
        System.out.println("===================");
        printResult(list2);
	}
}
